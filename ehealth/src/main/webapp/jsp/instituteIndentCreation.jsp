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
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
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
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<Object[]> storeInternalIndentTList = new ArrayList<Object[]>();
	List<Object[]> storeItemBatchStockList = new ArrayList<Object[]>();
	MasHospital hospital=new MasHospital();
	int deptId = 0;

	if (session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(session.getAttribute("deptId").toString());
	}
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
	}
	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
	}
	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("hospital") != null){
		hospital = (MasHospital)map.get("hospital");
	}
	
	if(map.get("hospitalTypeList") != null){
		hospitalTypeList = (List<MasHospitalType>)map.get("hospitalTypeList");
	}
	if(map.get("hospitalList") != null){
		hospitalList = (List<MasHospital>)map.get("hospitalList");
	}
	if(map.get("storeGroupList") != null){
		storeGroupList = (List<MasStoreGroup>)map.get("storeGroupList");
	}
	if(map.get("itemTypeList") != null){
		itemTypeList = (List<MasItemType>)map.get("itemTypeList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasStoreSection>)map.get("sectionList");
	}
	if(map.get("categoryList") != null){
		categoryList = (List<MasItemCategory>)map.get("categoryList");
	}
	if(map.get("itemClassList") != null){
		itemClassList = (List<MasItemClass>)map.get("itemClassList");
	}
	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List<Object[]>)map.get("storeInternalIndentTList");
	}
	if(map.get("storeItemBatchStockList") != null){
		storeItemBatchStockList = (List<Object[]>)map.get("storeItemBatchStockList");
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
<form name="instituteDepartmentIndent" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Annual Indent Creation by Institute</h2>
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
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date" validate="Indent Date,date,yes"  />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.instituteDepartmentIndent.<%= DEMAND_DATE%>,event)" />
	

	 
<input type="hidden" name="<%=FROM_WARD%>" value="<%=deptId %>" id="fromWardId"  />


<label>Type Of Indent</label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Annual" readonly="readonly"   />


<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
			
<label>Hospital Type</label>
<input type="text" name="hospitalTypeId" id="hospitalTypeId" value="<%=hospital.getHospitalType().getHospitalTypeName() %>" readonly="readonly"   />
<%-- <select name="hospitalTypeId" id="hospitalTypeId" validate="Hospital Type,String,yes">
	<option value="0">Select</option>
	<%
	
	if(hospitalTypeList.size()>0){
		for(MasHospitalType masHospitalType:hospitalTypeList){
		%>
	<option value="<%=masHospitalType.getId()%>" ><%=masHospitalType.get%></option>
	<%}} %>
	
	</select> --%>

<div class="clear"></div>

	<label>Hospital Name</label>
	<input type="text" id="hospitalId" id="hospitalId" value="<%=hospital.getHospitalName() %>" readonly="readonly"   />
<%-- <select name="hospitalId" id="hospitalId" validate="Hospital Name,String,yes"	>
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
		%>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
		
	<%}}%>
	
	</select> --%>
	
 <label>Indent To <span>*</span></label> 
<select name="<%=TO_WARD%>"  validate="Indent To,string,yes" >
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
			if(hospital.getId()!=masHospital.getId()){
		%>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
	<%}}}%>
	</select>
<%-- 
 <label><span>*</span>Requested By</label>
 <select name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" validate="Request By,String,no">
	<option value="0">Select</option>
	<%if(requestByEmployeeList.size()>0){
		for(MasEmployee masEmployee:requestByEmployeeList){
		%>
		<option value="<%=masEmployee.getId()%>" ><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}} %>
	
</select>
--%>
<label> Item Group</label> 
<select name="itemGroupId"  onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId"   >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="itemSectionId"  >
	<option value="0">Select</option>
	<%if(sectionList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName() %></option>
	<%}} %>
</select>
<label>Item Category</label>
<select name="categoryId"  id="categoryId"  >
	<option value="0">Select</option>
	<%if(categoryList.size()>0){
		for(MasItemCategory masItemCategory:categoryList){
		%>
		<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName() %></option>
	<%}} %>
</select>
<label>Item Class</label>
<select name="classId"  id="classId" >
	<option value="0">Select</option>
	<%if(itemClassList.size()>0){
		for(MasItemClass masItemClass:itemClassList){
		%>
		<option value="<%=masItemClass.getId() %>"><%=masItemClass.getItemClassName() %></option>
	<%}} %>
</select>
<div class="clear"></div>
</div>
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
<input type="text" name="toMonth" value="<%=toMonth %>"  />
<label>Year</label>
<input type="text" name="toYear" value="<%=toYear %>"  />


<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
 <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
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
						<th>Prev. Year Cons. Qty</th>
					 	<th>Stock</th>
					 	<th>Lead Time</th>
					 	<th>Cons.in Lead Time</th>
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
	<td width="%5" ><input type="checkbox" class="radioCheck" size="3" value="" name="srno" id="srNoId<%=i %>" readonly="readonly" />
 	  </td>
	
	<td  onclick="javascript:openPopupWindow('<%=storeInternalIndentT[1]!= null?storeInternalIndentT[1]:"" %>','<%=storeInternalIndentT[2]!= null?storeInternalIndentT[2]:"" %>','<%=storeInternalIndentT[3]!= null?storeInternalIndentT[3]:"" %>','<%=storeInternalIndentT[4]!= null?storeInternalIndentT[4]:"" %>','<%=i %>');">
	<input type="text"  size="4" value="<%=storeInternalIndentT[2]!= null?storeInternalIndentT[2]:"" %>" name="pvms" id="<%=pvms+i %>"  readonly="readonly" style="cursor: pointer;"/>
<%-- 	<input type="hidden" size="5" value="<%=storeInternalIndentT[5]!= null?storeInternalIndentT[5]:"" %>" name="storeInternalTId" id="storeInternalTId<%=i %>"  readonly="readonly" /></td>
 --%>	</td>
	<td><input type="text" value="<%=storeInternalIndentT[3]!= null?storeInternalIndentT[3]:"" %>" tabindex="1" name="nomenclature" readonly="readonly" size="30" id="<%=nomenclature+i %>" validate="item Name,string,yes"  onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>&toWard='+document.instituteDepartmentIndent.<%=TO_WARD%>.value+''});
			</script></td>
	<td><input type="text" size="4" value="<%=storeInternalIndentT[4]!= null?storeInternalIndentT[4]:"" %>" name="au" id="<%="au"+""+i %>" readonly="readonly" /></td>
	<td><input type="text" size="8" value="" name="year1IndentQty" id="year1IndentQtyId<%=i %>" validate="yearIndent Qty,float,no" /></td>
	<td><input type="text" size="8" value="" name="year2IndentQty" id="year2IndentQtyId<%=i %>"  validate="yearIndent Qty,float,no" /></td>
	<td><input type="text" size="8" value="" name="previousYearConsumption"  id="previousYearConsumptionId<%=i %>" validate="Previous Year Consumption,float,no"  /></td>
	<%
	BigDecimal closingStock = new BigDecimal(0);
	if(storeItemBatchStockList.size()>0){
		for(Object[] itemBatchStockObj:storeItemBatchStockList){
		if(storeInternalIndentT[1].equals(itemBatchStockObj[1])){
			if(itemBatchStockObj[0] != null){
				closingStock = (BigDecimal)itemBatchStockObj[0];
			}else{
				closingStock = new BigDecimal(0);
			}
			System.out.println("closingStock=="+closingStock);
			break;
		}
	  }
	}
	%>
	<td><input type="text" size="8" value="<%=closingStock!= null?closingStock.intValue():""  %>" name="stock" validate="Stock,float,no" id="<%=stock+i %>" readonly="readonly" /></td>
	
	<td><input type="text" size="8" value="" name="leadTime" validate="Lead Time,float,no" id="leadTimeId<%=i %>" onblur="calculateIndentQty(<%=i %>);"    /></td>
	<td><input type="text" size="8" value="" name="consumptionInLeadTime" validate="Consumption In Lead Time,float,no" id="consumptionInLeadTimeId<%=i%>"   /></td>
	<td><input type="text" size="8" value="" name="incrementalPercentage" id="incrementalPercentageId<%=i %>" onblur="calculateIndentQty(<%=i %>);"  validate="incremental Percentage,float,no" /></td>
	<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="incremental Percentage,float,no"  /></td>
	<td><input type="text" size="8" value="" name="pendingIndentQty" id="pendingIndentQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Pending Indent Qty,float,no" /></td>
	<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,no" onblur="calculateIndentQty(<%=i %>);" /></td>
	<td><input type="text" size="8" value="" name="additionalQty" validate="Additional Qty,float,no" id="additionalQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" /></td>
	<td><input type="text" size="8" value="<%=storeInternalIndentT[0]!= null?storeInternalIndentT[0]:"" %>" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,yes" readonly="readonly"/>
	<input type="hidden" size="8" value="<%=storeInternalIndentT[0]!= null?storeInternalIndentT[0]:"" %>" name="qtyRequestedHiddenId" id="<%=qtyRequestedHiddenId+i %>" /></td>
	<td><input type="text" size="10" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,remarks,no" />
	<input type="hidden" value="<%=storeInternalIndentT[1]!= null?storeInternalIndentT[1]:"" %>" name="itemId" id="<%=itemId+i %>" /></td>

					
					
					<%
					i++;}} %>
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

<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('instituteDepartmentIndent','stores?method=submitInstituteWiseIndent','validateQty');" class="button" />
<%-- 
<input type="button" name="Approve" type="submit" value="Approve"	onClick="" class="button">
<input type="button" name="Approve" type="submit" value="Send Back"	onClick="" class="button">
<input type="button" name="Add New Item" type="submit" onClick="" value="Add New Item"	class="buttonBig">--%>
</form>


<script type="text/javascript">

function removeRow()
{
	var tbl = document.getElementById('indentGrid');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	     
  	for(i=0;i<document.getElementsByName('srno').length;i++)
	{
		
  		if (document.getElementsByName('srno')[i].checked == true)
		{
		  	tbl.deleteRow(i+1);
		}
	}
}


function addRow(){
	  var tbl = document.getElementById('indentGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='srno';
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvms';
	  e1.id='pvms'+iteration;
	  e1.size='4'
	 cellRight2.appendChild(e1);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){getOtherItemsForDepartmentIndent(iteration);
	                      };
	  e2.name = 'nomenclature';
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '30';
	  e2.setAttribute('validate','Item Name,string,yes');
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight3.appendChild(newdiv);
	  cellRight3.appendChild(e2);
		new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&toWard='+document.instituteDepartmentIndent.<%=TO_WARD%>.value+''});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au';
	  e3.size='4';
	  e3.id='au'+iteration;
	  cellRight4.appendChild(e3);
			  
	  var cellRight5 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.size='8';
	  e4.name='year1IndentQty';
	  e4.id='year1IndentQtyId'+iteration
	  e4.setAttribute('validate','year1IndentQty,float,no');
	  cellRight5.appendChild(e4);

	  var cellRight6 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.size='8';
	  e5.name='year2IndentQty';
	  e5.id='year2IndentQtyId'+iteration
	  e5.setAttribute('validate','year2IndentQty,float,no');
	  cellRight6.appendChild(e5);

	  var cellRight7 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='8';
	  e6.name='previousYearConsumption';
	  e6.id='previousYearConsumptionId'+iteration
	  e6.setAttribute('validate','PreviousYearConsumption,float,no');
	  cellRight7.appendChild(e6);

	  var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='stock';
	  e7.id='stock'+iteration
	  cellRight8.appendChild(e7);

	  var cellRight9 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='8';
	  e8.name='leadTime';
	  e8.id='leadTimeId'+iteration
	  e8.onblur=function(){calculateIndentQty(iteration);};
	  e8.setAttribute('validate','LeadTime,float,no');
	  cellRight9.appendChild(e8);

	  var cellRight10 = row.insertCell(9);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='8';
	  e9.name='consumptionInLeadTime';
	  e9.id='consumptionInLeadTimeId'+iteration
	  e9.setAttribute('validate','ConsumptionInLeadTime,float,no');
	  cellRight10.appendChild(e9);

	  var cellRight11 = row.insertCell(10);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size='8';
	  e10.name='incrementalPercentage';
	  e10.id='incrementalPercentageId'+iteration
	  e10.onblur=function(){calculateIndentQty(iteration);};
	  e10.setAttribute('validate','IncrementalPercentage,float,no');
	  cellRight11.appendChild(e10);

	  var cellRight12 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.size='8';
	  e11.name='incrementalQty';
	  e11.id='incrementalQtyId'+iteration
	  e11.setAttribute('validate','IncrementalQty,float,no');
	  cellRight12.appendChild(e11);

	  var cellRight13 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='8';
	  e12.name='pendingIndentQty';
	  e12.id='pendingIndentQtyId'+iteration
	  e12.onblur=function(){calculateIndentQty(iteration);};
	  e12.setAttribute('validate','PendingIndentQty,float,no');
	  cellRight13.appendChild(e12);

	  var cellRight14 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.size='8';
	  e13.name='requiredQty';
	  e13.id='requiredQtyId'+iteration
	  e13.setAttribute('validate','PendingIndentQty,float,no');
	  cellRight14.appendChild(e13);

	  var cellRight15 = row.insertCell(14);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.size='8';
	  e14.name='additionalQty';
	  e14.id='additionalQtyId'+iteration
	  e14.setAttribute('validate','AdditionalQty,float,no');
	  e14.onblur=function(){calculateIndentQty(iteration);};
	  cellRight15.appendChild(e14);

	  var cellRight16 = row.insertCell(15);
	  var e15 = document.createElement('input');
	  e15.type = 'text';
	  e15.size='8';
	  e15.name='qtyRequest';
	  e15.id='qtyRequest'+iteration
	  e15.setAttribute('validate','Demanded Qty,float,yes');
	  cellRight16.appendChild(e15);
	  
	  var e151 = document.createElement('input');
	  e151.type = 'hidden';
	  e151.size='4';
	  e151.name='qtyRequestedHiddenId';
	  e151.id='qtyRequestedHiddenId'+iteration
	 // e151.setAttribute('validate','Demanded Qty,float,yes');
	  cellRight16.appendChild(e151);

	  var cellRight17 = row.insertCell(16);
	  var e16 = document.createElement('input');
	  e16.type = 'text';
	  e16.size='10';
	  e16.name='remarks';
	  e16.id='remarks'+iteration
	  e16.setAttribute('validate','Remarks,string,no');
	  cellRight17.appendChild(e16);

	  var e17 = document.createElement('input');
	  e17.type = 'hidden';
	  e17.size='8';
	  e17.name='itemId';
	  e17.id='itemId'+iteration
	  cellRight17.appendChild(e17);
	  
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
		if(document.getElementById('requiredQtyId'+inc).value!='')
		{
		requiredQty = document.getElementById('requiredQtyId'+inc).value;
		}
		
		var consolidatedQtyRequest = 0;
			incrementalPercentage = document.getElementById('incrementalPercentageId'+inc).value;
			previousYearConsumption =document.getElementById('previousYearConsumptionId'+inc).value;
			if(document.getElementById('additionalQtyId'+inc).value!='')
				additionalQty =document.getElementById('additionalQtyId'+inc).value;
			leadTime = parseFloat(document.getElementById('leadTimeId'+inc).value);
			pendingIndentQtyId = document.getElementById('pendingIndentQtyId'+inc).value;
			stock = document.getElementById('stock'+inc).value;
			qtyRequest =document.getElementById('qtyRequestedHiddenId'+inc).value;
		
		if(!isNaN(previousYearConsumption) != "" && !isNaN(incrementalPercentage)!= ""){
			var incrementalqty =parseFloat(previousYearConsumption)*parseFloat(incrementalPercentage)/parseFloat(100);
			if(!isNaN( parseFloat(incrementalqty))){
			document.getElementById('incrementalQtyId'+inc).value = Math.round(parseFloat(incrementalqty).toFixed(2));
			}
		}
		
		if(!isNaN(previousYearConsumption) != "" &&  !isNaN(leadTime)!= ""){
			consumptionInleadTime =parseFloat(previousYearConsumption)*parseFloat(leadTime)/parseFloat(365);
			if(!isNaN( parseFloat(consumptionInleadTime))){
			document.getElementById('consumptionInLeadTimeId'+inc).value = Math.round(parseFloat(consumptionInleadTime).toFixed(2));
			}
		}
		//alert("qtyRequest=="+qtyRequest);
		//alert("incrementalqty=="+incrementalqty);
		//alert("consumptionInleadTime=="+consumptionInleadTime);
		//alert("stock=="+stock);
		//alert("pendingIndentQtyId=="+pendingIndentQtyId);
		if(qtyRequest != ""){
			requiredQty =(parseFloat(qtyRequest)+parseFloat(incrementalqty)+parseFloat(consumptionInleadTime))-(parseFloat(stock)+parseFloat(pendingIndentQtyId));
		
			if(!isNaN( parseFloat(requiredQty))){
			document.getElementById('requiredQtyId'+inc).value = Math.round(parseFloat(requiredQty).toFixed(2));
			}
		}else{
			requiredQty = (parseFloat(incrementalqty)+parseFloat(consumptionInleadTime))-(parseFloat(stock)+parseFloat(pendingIndentQtyId));
			
			if(!isNaN( parseFloat(requiredQty))){
			document.getElementById('requiredQtyId'+inc).value = Math.round(parseFloat(requiredQty).toFixed(2));
			}
		}
	
		if(!isNaN(requiredQty) != "" && !isNaN(additionalQty)!= ""){
			demandedQty =parseFloat(requiredQty)+parseFloat(additionalQty);
			if(!isNaN( parseFloat(demandedQty))){
			document.getElementById('qtyRequest'+inc).value = Math.round(parseFloat(demandedQty).toFixed(2));
			}
		}else if(!isNaN(requiredQty) != "" && additionalQty==''){
			demandedQty =requiredQty;
			document.getElementById('qtyRequest'+inc).value = Math.round(demandedQty.toFixed(2));
		}
		
		/*if(!isNaN(pendingIndentQty) != "" || !isNaN(previousYearConsumption)!= "" && !isNaN(incrementalqty)!= "" && !isNaN(consumptionInleadTime)!= "" && !isNaN(stock)!= ""){
			requiredQty =(previousYearConsumption+incrementalqty+consumptionInleadTime)-(stock+pendingIndentQty);
			document.getElementById('requiredQtyId'+inc).value = requiredQty;
		}*/
	}
	
	function validateQty(){
		var count =0;
		 count = document.getElementById('hdb').value;
		 var flag=false;
		for(var inc=1;inc<(parseInt(count));inc++){
			var requiredQty = 0;
			var demandedQty = 0;
			requiredQty =document.getElementById('requiredQtyId'+inc).value;
			if(requiredQty!=''){
				if(parseFloat(requiredQty)<0){
				 alert("Required Qty should contains greater than 0 value");
				 document.getElementById('requiredQtyId'+inc).value = "";
				 }
				flag=true;
			 }
			demandedQty =document.getElementById('qtyRequest'+inc).value;
			if(parseFloat(demandedQty)<0){
			 alert("Demanded Qty should contains greater than 0 value");
			 document.getElementById('qtyRequest'+inc).value = "";
			 }
			
		}
		if(!flag){
			alert("Please enter required qty in one row.")
			return false;
		}else{
			return true;
		}
		
	}
	
	function checkforStock(rowVal){
		 var stockAvailable=document.getElementById('stockAvailable'+rowVal).value;
		 if(parseFloat(stockAvailable)>0){
		 return true;

		 }
		 else{
		 alert("stock is not available for this item");
		 document.getElementById('stockAvailable'+rowVal).focus();
		 return false;
		 }
		 }

function openPopupWindow(itemId,itemCode,itemName,au,rowVal)
{
 var url="/hms/hms/stores?method=showDepartmentPopupJsp&itemId="+itemId+"&itemCode="+itemCode+"&itemName="+itemName+"&au="+au+"&rowVal="+rowVal;
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=750,status=1,scrollbars=1,resizable=0");
	
}

function getOtherItemsForDepartmentIndent(val){

	instituteDepartmentIndent.method="post";
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
	  var toWard=document.instituteDepartmentIndent.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
	ajaxFunctionForGetOtherItemsForDepartmentIndent('instituteDepartmentIndent','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=TO_WARD%>='+toWard+''   , val);

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


