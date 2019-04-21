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
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
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
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	int deptId = 0;

	if (session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(session.getAttribute("deptId").toString());
	}
	if(map.get("hospitalTypeList") != null){
		hospitalTypeList = (ArrayList) map.get("hospitalTypeList");
	}
	if(map.get("instituteDepartmentList") != null){
		instituteDepartmentList = (ArrayList) map.get("instituteDepartmentList");
	}
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
	}
	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
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
%>
<form name="emergencyIndent" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Intrim Indent</h2>
</div>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="Block">
<h4>Details</h4>
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
 <input type="text" name="<%=DEMAND_NO %>" value="<%=demandNo %>" readonly="readonly" MAXLENGTH="8" class="readOnly" validate="demandNo,string,no"/> 
 </div>
	<div class="clear"></div>
	<label>Indent Date<span>*</span></label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="Indent Date,date,yes" />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.emergencyIndent.<%= DEMAND_DATE%>,event)" />
	

	 
<input type="hidden" name="<%=FROM_WARD%>" value="<%=deptId %>" id="fromWardId" validate="fromWard,metachar,no"/>


<label>Type Of Indent<span>*</span></label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Emergent" readonly="readonly"  validate="Type Of Indent,metachar,yes"  />


<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
			




	<label> To Institute<span>*</span></label>
<select name="hospitalId" id="hospitalId"  validate="Institute,metachar,yes">
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
		%>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
		
	<%}}%>
	
	</select>
	<div class="clear"></div><%--
 <label>Indent To </label> 
<select name="toInstitute" validate="To Ward,String,yes">
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
		%>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
	<%}}%>
	
	</select> --%>
	<%-- 
 <label><span>*</span>Requested By</label>
 <select name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" validate="Request By,String,no">
	<option value="0">Select</option>
	<%if(requestByEmployeeList.size()>0){
		for(MasEmployee masEmployee:requestByEmployeeList){
		%>
		<option value="<%=masEmployee.getId()%>" ><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}} %>
	
</select>--%>
<%if(hospitalTypeList.size()>0){ %>
<label> Department</label> 
<select name="toDepartmentId" id="toDepartmentId"  >
	<option value="0">Select</option>
	<%if(instituteDepartmentList.size()>0){
		for(MasInstituteDepartment masInstituteDepartment:instituteDepartmentList){
		%>
		<option value="<%=masInstituteDepartment.getId() %>"><%=masInstituteDepartment.getDepartment().getDepartmentName()%></option>
	<%}} %>
</select>
<%} %>

<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"  onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId"  id="itemTypeId" >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="sectionId"   id="sectionId" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}} %>
</select>

<label>Item Category</label>
<select name="categoryId"   id="categoryId"  >
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
</div>
<div class="clear"></div>
</div>

<div class="Block">
<h4>Period</h4>
<label>From Date<span>*</span></label>
<input type="text" name="<%=FROM_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="fromDate,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.emergencyIndent.<%= FROM_DATE%>,event)" />

<label>To Date<span>*</span></label>
<input type="text" name="<%=TO_DATE %>" value="<%=date %>" readonly="readonly" class="date" validate="toDate,date,yes" />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.emergencyIndent.<%= TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
    
  <div class="cmntable">
    <div id="gridDiv">
<h4>Indent Details</h4>
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid">
					<tr>

						<th></th>
						<th>Item Code</th>
						<th>KMSCL Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Consumption per Day</th>
						 <th>Available Stock</th>
						  <th>Lead Time</th>
						   <th>Consumption In Lead Time</th>
						  <th>Days</th>
						  <th>Incremental Qty</th>
							<th>Pending Qty</th>
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
					  String itemId="itemId";
					  int requestedQty = 0;
								
					
					%>
				<tr>
						<td><input type="checkbox" size="5" value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly"  /></td>
							
						<td><input type="text" size="5" tabindex="1"  value="" name="pvms" id="<%=pvms+i %>" /></td>
						<td><input type="text" size="5" tabindex="1"  value="" name="kmsclItemCode" id="kmsclItemCode<%=i %>"  /></td>
							
	 <script>
			function eventCallback(element, entry){
			//alert("group-=="+document.getElementById('itemGroupId').value);
				return entry + "&itemGroupId=" + document.getElementById('itemGroupId').value+"&itemTypeId="+document.getElementById('itemTypeId').value+"&sectionId="+document.getElementById('sectionId').value+"&categoryId="+document.getElementById('categoryId').value+"&classId="+document.getElementById('classId').value                                                                       
			}
			</script> 
						<td><input type="text" value="" tabindex="1" name="nomenclature" size="30" id="<%=nomenclature+i %>" validate="Item Name,string,yes" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
							<%-- new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>'});--%>
							new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>',callback: eventCallback}); 
							//} 
								<%--new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&itemGroupId='+document.getElementById('itemGroupId').value+'&itemTypeId='+document.getElementById('itemTypeId').value+''});--%>
								</script></td>
					<td><input type="text" size="5" tabindex="1" disabled value="" name="au" id="<%="au"+""+i %>" class="readOnly" readonly="readonly"  /></td>
					<td><input type="text" size="8" value="" name="previousYearConsumption" id="previousYearConsumptionId<%=i %>" validate="PreviousYearConsumption,float,no"  /></td>
					<td><input type="text" size="8" readonly="readonly" tabindex="1" value="" id="<%=stock+i %>" name="stock" validate="Stock,float,no" /></td>
					<td><input type="text" size="8" value="" name="leadTime"   id="leadTimeId<%=i %>" onblur="calculateIndentQty(<%=i %>);"    /></td>
					<td><input type="text" size="8" value="" name="consumptionInLeadTime"   id="consumptionInLeadTimeId<%=i%>"   /></td>
					<td><input type="text" size="8" value="" name="days" id="daysId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Days,metachar,no" /></td>
					<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="IncrementalQty,float,no" /></td>
					<td><input type="text" size="8" value="" name="pendingIndentQty" id="pendingIndentQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Pending Indent Qty,float,no" /></td>
					<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,no" /></td>
					<td><input type="text" size="8" value="" name="additionalQty" id="additionalQtyId<%=i %>" validate="Additional,float,no" onblur="calculateIndentQty(<%=i %>);"   /></td>
					<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,no" /></td>
					<td><input type="text" size="20" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,remarks,no" /></td>
					<input type="hidden" value="" name="itemId" id="<%=itemId+i %>" validate="itemId,int,no"/></td>
						
					</tr>
			</table>
	</div>	
	</div>	
 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
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
    <input type="button" name="Below ROL" type="submit" value="Below ROL"	onClick="submitProtoAjaxWithDivName('emergencyIndent','stores?method=getItemListBelowROL','gridDiv')" class="button" />
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('emergencyIndent','stores?method=submitEmergencyIndent');" class="button" />
<%-- 
<input type="button" name="Approve" type="submit" value="Approve"	onClick="" class="button">
<input type="button" name="Approve" type="submit" value="Send Back"	onClick="" class="button">
<input type="button"	name="Add New Item" type="submit" onClick="" value="Add New Item"	class="buttonBig">--%>
</form>


<script type="text/javascript">
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
	  e0.type = 'checkBox';
	  e0.name='srno';
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvms';
	  e1.id='pvms'+iteration;
	  e1.size='5'
	 cellRight2.appendChild(e1);

	  var cellRight3 = row.insertCell(2);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='kmsclItemCode';
	  e11.id='kmsclItemCode'+iteration;
	  e11.size='5'
	 cellRight3.appendChild(e11);

	  var cellRight4 = row.insertCell(3);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){getOtherItemsForDepartmentIndent(iteration);
	                      };
	  e2.name = 'nomenclature';
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '30';
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight4.appendChild(newdiv);
	  cellRight4.appendChild(e2);
		new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>',callback: eventCallback});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight5 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au';
	  e3.size='4';
	  e3.id='au'+iteration;
	  cellRight5.appendChild(e3);

	  var cellRight6 = row.insertCell(5);
	  var e31 = document.createElement('input');
	  e31.type = 'text';
	  e31.size='8';
	  e31.name='previousYearConsumption';
	  e31.id='previousYearConsumptionId'+iteration
	  cellRight6.appendChild(e31);

	  var cellRight7 = row.insertCell(6);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.size='8';
	  e4.name='stock';
	  e4.id='stock'+iteration
	  cellRight7.appendChild(e4);

	  var cellRight8 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.size='8';
	  e5.name='leadTime';
	  e5.id='leadTimeId'+iteration
	  e5.onblur=function(){calculateIndentQty(iteration);};
	  cellRight8.appendChild(e5);

	  var cellRight9 = row.insertCell(8);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='8';
	  e6.name='consumptionInLeadTime';
	  e6.id='consumptionInLeadTimeId'+iteration
	  cellRight9.appendChild(e6);

	  var cellRight10 = row.insertCell(9);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='8';
	  e6.name='days';
	  e6.id='daysId'+iteration
	  e6.onblur=function(){calculateIndentQty(iteration);};
	  cellRight10.appendChild(e6);

	  var cellRight11 = row.insertCell(10);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='incrementalQty';
	  e7.id='incrementalQtyId'+iteration
	  cellRight11.appendChild(e7);

	  var cellRight12 = row.insertCell(11);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='8';
	  e8.name='pendingIndentQty';
	  e8.id='pendingIndentQtyId'+iteration
	  e8.onblur=function(){calculateIndentQty(iteration);};
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(12);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='8';
	  e9.name='requiredQty';
	  e9.id='requiredQtyId'+iteration
	  cellRight13.appendChild(e9);

	  var cellRight14 = row.insertCell(13);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size='8';
	  e10.name='additionalQty';
	  e10.id='additionalQtyId'+iteration
	  e10.onblur=function(){calculateIndentQty(iteration);};
	  cellRight14.appendChild(e10);

	  var cellRight15 = row.insertCell(14);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.size='8';
	  e11.name='qtyRequest';
	  e11.id='qtyRequest'+iteration
	  cellRight15.appendChild(e11);

	  var cellRight16 = row.insertCell(15);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='20';
	  e12.name='remarks';
	  e12.id='remarks'+iteration
	  cellRight16.appendChild(e12);

	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.size='5';
	  e13.name='itemId';
	  e13.id='itemId'+iteration
	  cellRight16.appendChild(e13);
	  
	}
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
function calculateIndentQty(inc) {
	var days =0;
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
		days = document.getElementById('daysId'+inc).value;
		previousYearConsumption =document.getElementById('previousYearConsumptionId'+inc).value;
		additionalQty =document.getElementById('additionalQtyId'+inc).value;
		leadTime = parseFloat(document.getElementById('leadTimeId'+inc).value);
		pendingIndentQtyId = document.getElementById('pendingIndentQtyId'+inc).value;
		stock = document.getElementById('stock'+inc).value;
		qtyRequest =document.getElementById('qtyRequest'+inc).value;
	
	if(!isNaN(previousYearConsumption) != "" && !isNaN(days)!= ""){
		var incrementalqty =parseFloat(previousYearConsumption)*parseFloat(days);
		if(!isNaN( parseFloat(incrementalqty))){
		document.getElementById('incrementalQtyId'+inc).value = Math.round(parseFloat(incrementalqty).toFixed(2));
		}
	}
	if(!isNaN(previousYearConsumption) != "" || !isNaN(leadTime)!= ""){
		consumptionInleadTime =parseFloat(previousYearConsumption)*parseFloat(leadTime);
		if(!isNaN( parseFloat(consumptionInleadTime))){
		document.getElementById('consumptionInLeadTimeId'+inc).value = Math.round(parseFloat(consumptionInleadTime).toFixed(2));
		}
	}
	if(!isNaN(incrementalqty) != "" && !isNaN(previousYearConsumption)!= "" && !isNaN(qtyRequest)!= ""){
		//requiredQty =(parseFloat(previousYearConsumption)+parseFloat(incrementalqty))-(parseFloat(consumptionInleadTime)+parseFloat(stock)+parseFloat(pendingIndentQtyId));
		requiredQty =(parseFloat(incrementalqty)+parseFloat(consumptionInleadTime))-(parseFloat(stock)+parseFloat(pendingIndentQtyId));
		if(!isNaN( parseFloat(requiredQty))){
		document.getElementById('requiredQtyId'+inc).value = Math.round(requiredQty.toFixed(2));
		}
	}
	if(!isNaN(requiredQty) != "" && !isNaN(additionalQty)!= ""){
		demandedQty =parseFloat(requiredQty)+parseFloat(additionalQty);
		if(!isNaN( parseFloat(demandedQty))){
		document.getElementById('qtyRequest'+inc).value = Math.round(demandedQty.toFixed(2));
		}
	}
	
	/*if(!isNaN(pendingIndentQty) != "" || !isNaN(previousYearConsumption)!= "" && !isNaN(incrementalqty)!= "" && !isNaN(consumptionInleadTime)!= "" && !isNaN(stock)!= ""){
		requiredQty =(previousYearConsumption+incrementalqty+consumptionInleadTime)-(stock+pendingIndentQty);
		document.getElementById('requiredQtyId'+inc).value = requiredQty;
	}*/
}


function openPopupWindow(itemId,itemCode,itemName,au,rowVal)
{
 var url="/hms/hms/stores?method=showDepartmentPopupJsp&itemId="+itemId+"&itemCode="+itemCode+"&itemName="+itemName+"&au="+au+"&rowVal="+rowVal;
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	
}

function getOtherItemsForDepartmentIndent(val){

	emergencyIndent.method="post";
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
	  <%--var toWard=document.emergencyIndent.<%= TO_WARD%>.value;--%>
	    if(pvmsNo!=""){
	ajaxFunctionForGetOtherItemsForDepartmentIndent('emergencyIndent','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+''   , val);

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


