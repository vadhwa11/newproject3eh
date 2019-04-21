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
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();
	List<Object[]> storeItemBatchStockList = new ArrayList<Object[]>();
	List<Object[]> storeInternalIndentTList = new ArrayList<Object[]>();
	int deptId = 0;

	if (session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(session.getAttribute("deptId").toString());
	}
	
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null){
		departmentList = (ArrayList)session.getAttribute("departmentList");

	}
	
	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List<Object[]>)map.get("storeInternalIndentTList");
	}
	String fromMonth = "";
	String fromYear = "";
	String toMonth = "";
	String toYear = "";
	
	if(map.get("fromMonth") != null){
		fromMonth = (String)map.get("fromMonth");
	}
	if(map.get("fromYear") != null){
		fromYear = (String)map.get("fromYear");
	}
	if(map.get("toMonth") != null){
		toMonth = (String)map.get("toMonth");
	}
	if(map.get("toYear") != null){
		toYear = (String)map.get("toYear");
	}

	
%>
<form name="stateWiseIndent" method="post">
<div class="titleBg">
<h2>Annual Indent Creation At State Level</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block">
<%
String demandNo = "";

if(map.get("finalDemandNo") != null){
	demandNo = (String)map.get("finalDemandNo");
	
}else if(map.get("demandNo") != null){
	demandNo = (String)map.get("demandNo");
	
}

%>
<div style="display: none">
<label>Demand No.</label>
 <input type="text" name="<%=DEMAND_NO %>" value="<%=demandNo %>" readonly="readonly" MAXLENGTH="8" class="readOnly" /> 
 </div>
	<div class="clear"></div>
	<label>Indent Date<span>*</span></label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date" validate="demandDate,date,yes" />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.stateWiseIndent.<%= DEMAND_DATE%>,event)" />
	

	 
<input type="hidden" name="<%=FROM_WARD%>" value="<%=deptId %>" id="fromWardId"  />


<label>Type Of Indent <span>*</span></label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Annual" readonly="readonly"  />


<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
			
<%-- 	
 <label>Indent To </label> 
<select name="<%=TO_WARD%>" validate="To Ward,String,yes">
	<option value="0">Select</option>
	<%if(departmentList.size()>0){
		for(MasDepartment masDepartment:departmentList){
		%>
		<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
	<%}}%>
	
	</select>--%>
 
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Period</h4>
<div class="clear"></div>
<div class="Block">

<label>From Month</label>
<input type="text" name="fromMonth" value="<%=fromMonth %>"  />
<label>Year</label>
<input type="text" name="fromYear" value="<%=fromYear %>"  />


<div class="clear"></div>
<label>To Month</label>
<input type="text" name="toMonth" value="<%=toMonth %>" />
<label>Year</label>
<input type="text" name="toYear" value="<%=toYear %>" />


<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Indent Details</h4>
  <div class="cmntable">
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid">
					<tr>

						<th></th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Year1 Indent Qty</th>
						<th>Year2 Indent Qty</th>
						<th>Prev Year Cons Qty</th>
						 <th> Stock</th>
						 <th>Lead Time</th>
					 	<th>Cons.in Lead Time</th>
					 	<th>Incremental (%)</th>
					 	<th>Incremental Qty</th>
						<th>Pending Indent Qty</th>
						 <th>Additional qty</th>
						<th>Required Qty</th>
						<th>Demanded Qty</th>
						<th>Remarks</th>
						
					</tr>
					<%
					int i = 1;
					String nomenclature="nomenclature";
					  String au="au";
					  String pvms="pvms";
					  String stock="stock";
					  String qtyRequest="qtyRequest";
					  String qtyRequestedHiddenId="qtyRequestedHiddenId";
					  String itemId="itemId";
					  int requestedQty = 0;
						if(storeInternalIndentTList.size()>0){
							for(Object[] storeInternalIndentT : storeInternalIndentTList){
					
					%>
					<tr>
						<td width="%5"><input type="checkbox" size="3" value="" class="radioCheck" name="srno" id="srNoId<%=i %>" readonly="readonly"  /></td>
							
						<td onclick="javascript:openPopupWindow('<%=storeInternalIndentT[1]!= null?storeInternalIndentT[1]:"" %>','<%=storeInternalIndentT[2]!= null?storeInternalIndentT[2]:"" %>','<%=storeInternalIndentT[3]!= null?storeInternalIndentT[3]:"" %>','<%=storeInternalIndentT[4]!= null?storeInternalIndentT[4]:"" %>','<%=i %>');"><input type="text" size="4" value="<%=storeInternalIndentT[2]!= null?storeInternalIndentT[2]:"" %>" name="pvms" id="<%=pvms+i %>"  readonly="readonly" />
						<%-- <input type="hidden" size="5" value="<%=storeInternalIndentT[10]!= null?storeInternalIndentT[10]:"" %>" name="storeInternalTId" id="storeInternalTId<%=i %>"  readonly="readonly" />
						<input type="hidden" size="5" value="<%=storeInternalIndentT[11]!= null?storeInternalIndentT[11]:"" %>" name="storeInternalMId" id="storeInternalMId"  readonly="readonly" />
						 --%>
						 </td><td><input type="text" value="<%=storeInternalIndentT[3]!= null?storeInternalIndentT[3]:"" %>" tabindex="1" name="nomenclature" size="20" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
								new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&toWard='+document.stateWiseIndent.<%=TO_WARD%>.value+''});
								</script></td>
						<td><input type="text" size="4" value="<%=storeInternalIndentT[4]!= null?storeInternalIndentT[4]:"" %>" name="au" id="<%="au"+""+i %>" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[5]!= null?((BigDecimal)storeInternalIndentT[5]).intValue():"" %>" name="year1IndentQty" id="year1IndentQtyId<%=i %>" readonly="readonly" validate="year1IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[6]!= null?((BigDecimal)storeInternalIndentT[6]).intValue():"" %>" name="year2IndentQty" id="year2IndentQtyId<%=i %>"  readonly="readonly" validate="year2IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[7]!= null?((BigDecimal)storeInternalIndentT[7]).intValue():"" %>" name="previousYearConsumption"  id="previousYearConsumptionId<%=i %>"  readonly="readonly" validate="previousYearConsumption,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[8]!= null?storeInternalIndentT[8]:"" %>" name="stock" validate="Stock In Hand,float,no" id="<%=stock+i %>"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="leadTime"   id="leadTimeId<%=i %>" onblur="calculateIndentQty(<%=i %>);"    /></td>
						<td><input type="text" size="8" value="" name="consumptionInLeadTime"  id="consumptionInLeadTimeId<%=i%>"   /></td>
						<td><input type="text" size="8" value="" name="incrementalPercentage" id="incrementalPercentageId<%=i %>"  onblur="calculateIndentQty(<%=i %>);"  /></td>
						<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="IncrementalQty,float,no" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[9]!= null?((BigDecimal)storeInternalIndentT[9]).intValue():"" %>" name="pendingIndentQty" id="pendingIndentQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Pending Indent Qty,float,no" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="additionalQty" validate="Stock In Hand,num,no" id="additionalQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Additional Qty,float,no" /></td>
						<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,yes" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT[0]!= null?storeInternalIndentT[0]:"" %>" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,yes" readonly="readonly" />
						<input type="hidden" size="8" value="<%=storeInternalIndentT[0]!= null?storeInternalIndentT[0]:"" %>" name="qtyRequestedHiddenId" id="<%=qtyRequestedHiddenId+i %>" /></td>
						<td><input type="text" size="10" value="" name="remarks" id="remarks<%=i %>" maxlength="50" validate="Remarks,metachar,no" />
						<input type="hidden" value="<%=storeInternalIndentT[1]!= null?storeInternalIndentT[1]:"" %>" name="itemId" id="<%=itemId+i %>" validate="itemId,int,no"/></td>
						
					
					
					<%i++;}} %>
			</table>
		</div>	
 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="clear"></div>
<%-- 
<label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	<option value="Approve">Send Back</option>
	
</select>--%>

<div class="clear"></div>
<%-- 
<label>DHS/DME Remarks</label>
<textarea name="dmeRemarks"  validate="DME,string,no" cols="0" rows="0" class="large" maxlength="300" tabindex="1" ></textarea>
--%>

<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('stateWiseIndent','stores?method=submitStateWiseIndent','validateQty');" class="button" />

<%-- 
<input type="button" name="Approve" type="submit" value="Approve"	onClick="" class="button">
<input type="button" name="Approve" type="submit" value="Send Back"	onClick="" class="button">
<input type="button"	name="Add New Item" type="submit" onClick="" value="Add New Item"	class="buttonBig">--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<script type="text/javascript">
function openPopupWindow(itemId,itemCode,itemName,au,rowVal)
{
 var url="/hms/hms/stores?method=showDistrictIndentPopupJsp&itemId="+itemId+"&itemCode="+itemCode+"&itemName="+itemName+"&au="+au+"&rowVal="+rowVal;
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function calculateIndentQty(inc) {
	var incrementalPercentage =0;
	var previousYearConsumption =0;
	var incrementalqty = 0;
	var requiredQty = 0;
	var demandedQty = 0;
	var additionalQty = 0;
	var leadTime = 0;
	var consumptionInleadTime = 0;
	var pendingIndentQty = 0;
	var stock = 0;
	var requiredQty = 0;
	var consolidatedQtyRequest = 0;
		incrementalPercentage = document.getElementById('incrementalPercentageId'+inc).value;
		previousYearConsumption =document.getElementById('previousYearConsumptionId'+inc).value;
		additionalQty =document.getElementById('additionalQtyId'+inc).value;
		leadTime = parseFloat(document.getElementById('leadTimeId'+inc).value);
		pendingIndentQtyId = document.getElementById('pendingIndentQtyId'+inc).value;
		stock = document.getElementById('stock'+inc).value;
		qtyRequest =document.getElementById('qtyRequestedHiddenId'+inc).value;
	
	if(!isNaN(previousYearConsumption) != "" && !isNaN(incrementalPercentage)!= ""){
		var incrementalqty =parseFloat(previousYearConsumption)*parseFloat(incrementalPercentage)/parseFloat(100);
		if(!isNaN( parseFloat(incrementalqty))){
		document.getElementById('incrementalQtyId'+inc).value =Math.round(parseFloat(incrementalqty).toFixed(2));
		}
	}
	if(!isNaN(previousYearConsumption) != "" || !isNaN(leadTime)!= ""){
		consumptionInleadTime =parseFloat(previousYearConsumption)*parseFloat(leadTime)/parseFloat(365);
		if(!isNaN( parseFloat(consumptionInleadTime))){
		document.getElementById('consumptionInLeadTimeId'+inc).value =Math.round(parseFloat(consumptionInleadTime).toFixed(2));
		}
	}
	if(!isNaN(incrementalqty) != "" && !isNaN(previousYearConsumption)!= "" && !isNaN(qtyRequest)!= ""){
		requiredQty =(parseFloat(qtyRequest)+parseFloat(incrementalqty)+parseFloat(consumptionInleadTime))-(parseFloat(stock)+parseFloat(pendingIndentQtyId));
		if(!isNaN( parseFloat(requiredQty))){
		document.getElementById('requiredQtyId'+inc).value = Math.round(requiredQty.toFixed(2));
		}
	}
	if(!isNaN(requiredQty) != "" && !isNaN(additionalQty)!= ""){
		demandedQty =parseFloat(requiredQty)+parseFloat(additionalQty);
		if(!isNaN( parseFloat(demandedQty))){
		document.getElementById('qtyRequest'+inc).value =Math.round(demandedQty.toFixed(2));
		}
	}
	
	/*if(!isNaN(pendingIndentQty) != "" || !isNaN(previousYearConsumption)!= "" && !isNaN(incrementalqty)!= "" && !isNaN(consumptionInleadTime)!= "" && !isNaN(stock)!= ""){
		requiredQty =(previousYearConsumption+incrementalqty+consumptionInleadTime)-(stock+pendingIndentQty);
		document.getElementById('requiredQtyId'+inc).value = requiredQty;
	}*/
}

function validateQty(){
	var count =0;
	 count = document.getElementById('hdb').value;
	for(var inc=1;inc<=(parseInt(count));inc++){
		var requiredQty = 0;
		var demandedQty = 0;
		 requiredQty =document.getElementById('requiredQtyId'+inc).value;
		if(parseFloat(requiredQty)<0){
		 alert("Required Qty should contains greater than 0 value");
		 document.getElementById('requiredQtyId'+inc).value = "";
		 }else{
			 return true;
		 }
		demandedQty =document.getElementById('qtyRequest'+inc).value;
		if(parseFloat(demandedQty)<0){
		 alert("Demanded Qty should contains greater than 0 value");
		 document.getElementById('qtyRequest'+inc).value = "";
		 }else{
			 return true;
		 }
		
	}
	
	
}


function getOtherItemsForDepartmentIndent(val){

	stateWiseIndent.method="post";
	 var counterValue=document.getElementById("hdb").value

	 var nomenclature=document.getElementById("nomenclature"+val).value;
	 for(var i=1;i<(parseInt(counterValue));i++){

	 if(document.getElementById("nomenclature"+i)!=null){
	 if(document.getElementById("nomenclature"+i).value==nomenclature && i!=val){

	 alert("Item is already Selected");
	 document.getElementById("nomenclature"+val).value="";
	 return false;
	 }
	 }
	 }

	   var index1 = nomenclature.lastIndexOf("[");
	        index1++;

	      var index2 = nomenclature.lastIndexOf("]");
	       var pvmsNo = nomenclature.substring(index1,index2);
	  <%--var fromWard=document.indentForm.<%= FROM_WARD%>.value;--%>
	  var toWard=document.stateWiseIndent.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
	ajaxFunctionForGetOtherItemsForDepartmentIndent('stateWiseIndent','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=TO_WARD%>='+toWard+''   , val);

	}}

function ajaxFunctionForGetOtherItemsForDepartmentIndent(formName,action,rowVal)
{
 var xmlHttp;
 try {
   // Firefox, Opera 8.0+, Safari
   xmlHttp=new XMLHttpRequest();
 }catch (e){
   // Internet Explorer
   try{
     xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
   }catch (e){
   	alert(e)
     try{
       xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
     }catch (e){
       alert("Your browser does not support AJAX!");
       return false;
     }
    }
  }
   var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);
   xmlHttp.onreadystatechange=function()
   {
     if(xmlHttp.readyState==4){
     	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

     	for (loop = 0; loop < items.childNodes.length; loop++)
     	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	      var au=item.getElementsByTagName("au")[0];
	      var stock=item.getElementsByTagName("stock")[0];
	        var name  = item.getElementsByTagName("name")[0];
       	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
       	document.getElementById('pvms'+rowVal).value =  pvms.childNodes[0].nodeValue ;
       	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue ;
       	document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue ;
       	document.getElementById('qtyRequest'+rowVal).value = 0 ;
       	document.getElementById('au'+rowVal).value =  au.childNodes[0].nodeValue ;

     }
   }
 }
}


</script>


