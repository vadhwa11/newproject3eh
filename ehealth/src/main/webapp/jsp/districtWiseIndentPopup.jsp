<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>

<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<Object[]> departmentWiseStoreInternalIndentTList = new ArrayList<Object[]>();
	List<Object[]> instituteWiseStoreInternalIndentTList = new ArrayList<Object[]>();
	if(map.get("departmentWiseStoreInternalIndentTList") != null){
		departmentWiseStoreInternalIndentTList = (List<Object[]>)map.get("departmentWiseStoreInternalIndentTList");
	}
	if(map.get("instituteWiseStoreInternalIndentTList") != null){
		instituteWiseStoreInternalIndentTList = (List<Object[]>)map.get("instituteWiseStoreInternalIndentTList");
	}
	System.out.println("instituteWiseStoreInternalIndentTList=="+instituteWiseStoreInternalIndentTList.size());
	int itemId = 0;
	String itemName = "";
	String itemCode = "";
	String au = "";
	int rowVal = 0;
	if(map.get("itemId") != null){
		itemId = (Integer)map.get("itemId");
	}
	if(map.get("itemName") != null){
		itemName = (String)map.get("itemName");
	}
	if(map.get("itemCode") != null){
		itemCode = (String)map.get("itemCode");
	}
	if(map.get("au") != null){
		au = (String)map.get("au");
	}
	if(map.get("rowVal") != null){
		rowVal = (Integer)map.get("rowVal");
	}	


	
%>
<form name="districtWiseIndentPopup" method="post">

<div class="Block">

<label>Item Code</label>
	 <input type="text" name="pvmsNo" value="<%=itemCode %>" readonly="readonly"  />
	 <label>Item Name</label>
	 <input type="text" name="nomenclature" value="<%=itemName %>" readonly="readonly"  />
	 <div class="clear"></div>
	  <label>Unit</label>
	 <input type="text" name="au" value="<%=au %>" readonly="readonly"   />
	  <input type="hidden" name="itemId" value="<%=itemId %>" readonly="readonly"  />
	   <input type="hidden" name="rowVal" value="<%=rowVal %>" readonly="readonly"   />
<div class="clear"></div>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>Institute Wise Item Details</h4>


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

 <div class="tableAuto">
<table border="0" cellpadding="0" cellspacing="0">
	
					<tr>

						<th>Institute</th>
						<th>Year1</th>
						<th>Year2</th>
						<th>Consumption Qty</th>
						<th>Available Stock</th>
						<th>Lead Time</th>
						<th>Consumption in Lead Time</th>
						 <th>Incremental(%)</th>
						 <th>Incremental Qty</th>
						<th>Pending Indent Qty</th>
						<th>Required Qty</th>
						  <th>Additional qty</th>
						<th>Demanded Qty</th>
						<th>Remarks</th>
						
					</tr>
					
						<%
					int i = 1;
						int totalRequestQty = 0;
						if(instituteWiseStoreInternalIndentTList.size()>0){
							for(Object[] storeIndentTObj : instituteWiseStoreInternalIndentTList){
								if(storeIndentTObj[13] != null){
									totalRequestQty = totalRequestQty +(Integer)storeIndentTObj[13];
								}
					
					%>
					
					
					<tr>
						<td width="%5"><input type="text" size="30" value="<%=storeIndentTObj[1]!= null?storeIndentTObj[1]:"" %>" name="institute" id="instituteId<%=i %>"  class="readOnly" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[2]!= null?((BigDecimal)storeIndentTObj[2]).intValue():"" %>" name="year1IndentQty" id="year1IndentQtyId<%=i %>" class="readOnly" readonly="readonly" validate="year1IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[3]!= null?((BigDecimal)storeIndentTObj[3]).intValue():"" %>" name="year2IndentQty" id="year2IndentQtyId<%=i %>" class="readOnly" readonly="readonly" validate="year2IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[4]!= null?((BigDecimal)storeIndentTObj[4]).intValue():"" %>" name="previousYearConsumption" id="previousYearConsumption<%=i %>" class="readOnly" readonly="readonly" validate="previousYearConsumption,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[5]!= null?((Integer)storeIndentTObj[5]):"" %>" name="stock" id="stock<%=i %>"  validate="Stock In Hand,float,no" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[9]!= null?((Integer)storeIndentTObj[9]):"" %>" name="leadTime" id="leadTimeId<%=i %>"   class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[10]!= null?((BigDecimal)storeIndentTObj[10]).intValue():"" %>" name="consumptionInLeadTime" id="consumptionInLeadTime<%=i %>"   class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[6]!= null?((BigDecimal)storeIndentTObj[6]).intValue():"" %>" name="incrementalPercentage" id="incrementalPercentageId<%=i %>"   class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[7]!= null?((BigDecimal)storeIndentTObj[7]).intValue():"" %>" name="incrementalQty" validate="incrementalQty,float,no" id="incrementalQtyId<%=i %>" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[8]!= null?((BigDecimal)storeIndentTObj[8]).intValue():"" %>" name="pendingIndentQty" class="readOnly" validate="Stock In Hand,float,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[11]!= null?((BigDecimal)storeIndentTObj[11]).intValue():"" %>" name="requiredQty" class="readOnly" id="requiredQtyId<%=i %>" validate="requiredQty,float,no" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[12]!= null?((BigDecimal)storeIndentTObj[12]).intValue():"" %>" name="additionalQty" id="additionalQtyId<%=i %>" class="readOnly" validate="Demanded Qty,float,no" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[13]!= null?((Integer)storeIndentTObj[13]):"" %>" name="qtyRequest" id="qtyRequest<%=i %>" onblur="calculateTotalDemandedQty();"  validate="additionalQty,float,no" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[15]!= null?storeIndentTObj[15]:"" %>" name="remarks" class="readOnly" validate="Remarks,remarks,no" />
						<input type="hidden" size="8" value="<%=storeIndentTObj[14]!= null?storeIndentTObj[14]:"" %>" name="storeInternalTId" id="storeInternalTId" class="readOnly"   /></td>
						
					</tr>
				<%}} %>	
</table>
</div>
 <input	type="hidden" name="count" id="count"	value="<%=i %>" />
<div class="clear"></div>
<label>Total Demanded Qty</label>
	 <input type="text" name="" value="<%=totalRequestQty %>" id="totalDemandedQty" class="smallest"  />
	 
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<h4>Department Wise Item Details</h4>


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

 <div class="tableAuto">
<table border="0" cellpadding="0" cellspacing="0">
				<tr>
						<th>Department</th>
						<th>Year1</th>
						<th>Year2</th>
						<th>Consumption Qty</th>
						<th>Incremental(%)</th>
						<th>Incremental Qty</th>
						<th>Required Qty</th>
					 	<th>Additional qty</th>
						<th>Demanded Qty</th>
						<th>Remarks</th>
						
					</tr>
					
					<%
					
						if(departmentWiseStoreInternalIndentTList.size()>0){
							for(Object[] storeIndentTObj : departmentWiseStoreInternalIndentTList){
								
					
					%>
					
					<tr>
						<td width="%5"><input type="text" size="25" value="<%=storeIndentTObj[1]!= null?storeIndentTObj[1]:"" %>" name="department" id="departmentId<%=i %>" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[2]!= null?((BigDecimal)storeIndentTObj[2]).intValue():"" %>" name="year1IndentQty" id="year1IndentQtyId<%=i %>" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[3]!= null?((BigDecimal)storeIndentTObj[3]).intValue():"" %>" name="year2IndentQty" id="year2IndentQtyId<%=i %>" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[4]!= null?((BigDecimal)storeIndentTObj[4]).intValue():"" %>" name="previousYearConsumption" id="previousYearConsumption<%=i %>" class="readOnly" readonly="readonly" /></td>
						<%--<td><input type="text" size="8" value="<%=storeIndentTObj[5]!= null?storeIndentTObj[5]:"" %>" name="stock" validate="Stock In Hand,num,no" class="readOnly" id="stock<%=i %>" readonly="readonly" /></td> --%>
						<td><input type="text" size="8" value="<%=storeIndentTObj[9]!= null?((BigDecimal)storeIndentTObj[9]).intValue():"" %>" name="incrementalPercentage" id="incrementalPercentageId<%=i %>" class="readOnly" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[10]!= null?((BigDecimal)storeIndentTObj[10]).intValue():"" %>" name="incrementalQty" id="incrementalQtyId<%=i %>" class="readOnly" readonly="readonly" /></td>
						
						<td><input type="text" size="8" value="<%=storeIndentTObj[5]!= null?((BigDecimal)storeIndentTObj[5]).intValue():"" %>" name="requiredQty" class="readOnly" id="requiredQtyId<%=i %>" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[6]!= null?((BigDecimal)storeIndentTObj[6]).intValue():"" %>" name="additionaalQty" class="readOnly" id="additionalQtyId<%=i %>" validate="Stock In Hand,num,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIndentTObj[7]!= null?((Integer)storeIndentTObj[7]):"" %>" name="qtyRequestDepartment"  onblur="calculateTotalDemandedQty();"  class="readOnly" validate="Demanded Qty,num,no" /></td>
						<%-- <td><input type="text" size="8" value="" name="notReceivedQty" id="notReceivedQtyId"    validate="Demanded Qty,num,no" /></td>--%>
						<td><input type="text" size="8" value="<%=storeIndentTObj[11]!= null?storeIndentTObj[11]:"" %>" name="remarks" class="readOnly" id="remarkId" validate="Remarks,string,no" />
</td>
						
					</tr>
					<%}} %>
					
	</table>

</div>

<div class="clear"></div>
<input	type="button" name="Close" type="submit" value="Update" 	onClick="submitForm('districtWiseIndentPopup','stores?method=updateInstituteDemandedQty');" class="button" />
<input	type="button" name="Close" type="submit" value="Close" 	onClick="setTotalDemandeQty();window.close();" class="button" />


<script type="text/javascript">
function calculateTotalDemandedQty(){
	var count = 0;
	var demandedQty = 0;
	var totalDemandedQty = 0;
	count = document.getElementById('count').value;
		for(i=1; i<=count; i++){
			if(document.getElementById('qtyRequest'+i) != null){
				demandedQty = document.getElementById('qtyRequest'+i).value;
				totalDemandedQty = parseFloat(totalDemandedQty)+parseFloat(demandedQty);
			}
		}
		if(totalDemandedQty != 0){
		document.getElementById('totalDemandedQty').value = totalDemandedQty;
		}
}



function setTotalDemandeQty(){
	var incrementQty= window.opener.document.getElementById('incrementalQtyId<%=rowVal%>').value;
	var consInLeadTime = window.opener.document.getElementById('consumptionInLeadTimeId<%=rowVal%>').value;
	var stock = window.opener.document.getElementById('stock<%=rowVal%>').value;
	var pendingIndentQuantity = window.opener.document.getElementById('pendingIndentQtyId<%=rowVal%>').value;
	var additionalQuantity = window.opener.document.getElementById('additionalQtyId<%=rowVal%>').value;
	var totalDemandQuantity = document.getElementById('totalDemandedQty').value;
	var newQtyRequired = 0;
	var newQtyDemanded = 0;
	
	if(incrementQty !="" && consInLeadTime!= "" && stock != "" && pendingIndentQuantity != "" && totalDemandQuantity != "" && additionalQuantity != ""){
		newQtyRequired =(parseFloat(totalDemandQuantity)+parseFloat(incrementQty)+parseFloat(consInLeadTime))-(parseFloat(stock)+parseFloat(pendingIndentQuantity));
		newQtyDemanded = parseFloat(newQtyRequired)+parseFloat(additionalQuantity);
		
	if(document.getElementById('totalDemandedQty') != null){
		window.opener.document.getElementById('requiredQtyId<%=rowVal%>').value = Math.round(parseFloat(newQtyRequired).toFixed(2));
		window.opener.document.getElementById('qtyRequest<%=rowVal%>').value = Math.round(parseFloat(newQtyDemanded).toFixed(2));
		
	}
	}else{
		if(document.getElementById('totalDemandedQty') != null){
			window.opener.document.getElementById('qtyRequest<%=rowVal%>').value =Math.round(parseFloat(totalDemandQuantity).toFixed(2));
		}
		
	}
}


</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
