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
<%@page import="jkt.hms.masters.business.Users"%>
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
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection>sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory>categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
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
	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
		session.setAttribute("requestByEmployeeList",requestByEmployeeList);
	}else if(session.getAttribute("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList)session.getAttribute("requestByEmployeeList");
	}
	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
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
	if(map.get("categoryList") != null){
		categoryList = (List<MasItemCategory>)map.get("categoryList");
	}
	if(map.get("itemClassList") != null){
		itemClassList =(List<MasItemClass>)map.get("itemClassList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasStoreSection>)map.get("sectionList");
	}
	String fromMonth = "";
	String fromYear = "";
	String toMonth = "";
	String toYear = "";
	String hospitalname = "";
	
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
	if(map.get("hospitalname") != null){
		hospitalname = (String)map.get("hospitalname");
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	List<Object[]> hospTypeList = new ArrayList<Object[]>();
	if(map.get("hospTypeList")!=null){
		hospTypeList = (List<Object[]>)map.get("hospTypeList");
	}
	String hospType= "";
	String hospTypeCode= "";
	if(hospTypeList.size()>0){
		Object[] obj = hospTypeList.get(0);
		hospType = (String)obj[1];
		hospTypeCode =(String) obj[0];
	}
%>
<form name="annualDepartmentIndent" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<div class="titleBg">
<h2>Department Annual Indent</h2>
</div>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class = "Block">
<h4>Details</h4>
<div class="clear"></div>

<%
String demandNo = "";

if(map.get("finalDemandNo") != null){
	demandNo = (String)map.get("finalDemandNo");
	
}else if(map.get("demandNo") != null){
	demandNo = (String)map.get("demandNo");
	
}

%>
<input type="hidden" name="pageNo" value="" id="pageNo" validate="pageNo,int,no"/>
<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" validate="NoOfRows,int,no"/>

<div style="display: none">
<label>Demand No.</label>
 <input type="text" name="<%=DEMAND_NO %>" value="<%=demandNo %>" readonly="readonly" MAXLENGTH="8" class="readOnly" /> 
</div>	
<div class="clear"></div>
<label>Indent Date<span>*</span></label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" validate="Indent Date,date,yes"  readonly="readonly" class="date"  />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.annualDepartmentIndent.<%= DEMAND_DATE%>,event)" />
	 
<input type="hidden" name="<%=FROM_WARD%>" value="<%=deptId %>" id="fromWardId"  />
<label>Type Of Indent</label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Annual" readonly="readonly" />

<label>Hospital Type </label>
<label  name="hospitalTypeId" validate="Hospital Type,metachar,no">

<input type="text" name="hospitalTypeId" id="hospitalTypeId" readonly="readonly"  value="<%=hospType%>" validate="Hospital Type ,metachar,no"/>
<%-- <input type="hidden" name="hospTypeCode" id="hospTypeCode" readonly="readonly"  value="<%=hospTypeCode%>"/> --%>
</label>
	<%-- <option value="0">Select</option>
	<%if(hospitalTypeList.size()>0){
		for(MasHospitalType masHospitalType:hospitalTypeList){
		%>
		<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
	<%}} %>
	
	</select> --%>

<div class="clear"></div>
			
<label>Hospital Name </label>
<%
   String hospital="";
   if(hospitalname!=null)
   {
	   hospital=hospitalname;
   }
%>
<input type="text" name="hospitalname" value="<%=hospital%>"	tabindex=1   id="hospitalname" class="readonly" validate="hospitalName,metachar,no"/>

<%-- <select name="hospitalId" id="hospitalId" validate="Hospital Name,String,yes">
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
		%>
		<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%}} %>
	
	</select>
	 --%>
 <label>Indent To<span>*</span> </label> 
<select name="<%=TO_WARD%>" validate="Indent To,string,yes">
	<option value="0">Select</option>
	<%if(departmentList.size()>0){
		for(MasDepartment masDepartment:departmentList){
		%>
		<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}} %>
	
	</select>
	<%-- 
 <label><span>*</span> Request By</label>
 <select name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" validate="Request By,String,no">
	<option value="0">Select</option>
	<%if(requestByEmployeeList.size()>0){
		for(MasEmployee masEmployee:requestByEmployeeList){
		%>
		<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}} %>
	--%>
</select>
<div class="clear"></div>
<label><span>*</span> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"  onchange="submitProtoAjaxWithDivName('annualDepartmentIndent','stores?method=getItemListForGrp','gridDiv');submitProtoAjaxWithDivName('annualDepartmentIndent','stores?method=getItemTypeListForAnnualIndent&group='+this.value,'nameDiv');" validate="Item Group,String,yes" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId"   id="itemTypeId"  >
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
	<%if(sectionList.size()>0){
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
</div>
<div class="Block">
<h4>Period</h4>
<div class="clear"></div>
<label>From Month<span>*</span></label>
<input type="text" name="fromMonth" value="<%=fromMonth %>" validate="From Month,string,yes"/>
<label>Year<span>*</span></label>
<input type="text" name="fromYear" value="<%=fromYear %>" validate="Year,string,yes"/>

<div class="clear"></div>
<label>To Month<span>*</span></label>
<input type="text" name="toMonth" value="<%=toMonth %>" validate="To Month,string,yes"/>
<label>Year<span>*</span></label>
<input type="text" name="toYear" value="<%=toYear %>" validate="Year,string,yes"/>

<div class="clear"></div>
 <label>Import Indent through<span>*</span> </label>
 <select name="importIndent" Id="importIndent"  onchange="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemListForGrp','gridDiv')">
  <option value="institute">Item Groups Which Should be Avaliable by default in the institute</option>
  <option value="specificPeriod" onclick="show()">Item Groups Which were Transacted/stocked during the specified period</option>
  <option value="indentLastYear">Item Groups Which were intended last year</option>
</select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<!-- <input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" /> -->
  <div class="cmntable">
<h4>Indent Details</h4>
<div id="gridDiv">
<div id="pageNavPosition"></div>
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid" >
<tbody id="tableData">
	<!--	<tr>
			<td>
			
			<table width="98%" colspan="7" id="indentGrid" class="scrollTable">
				<thead class="fixedHeader headerFormat"> -->
					<tr>
						<th></th>
						
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Year1 Indent Qty</th>
						<th>Year2 Indent Qty</th>
						<th>Previous Year Cons. Qty</th>
						<%--  <th>Available Stock</th>--%>
						<th>Incremental(%)</th>
						<th>IncrementalQty</th>
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
					%>
					
					<tr>
						<td><input type="checkbox" size="3"  value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly"  /></td>
						<td><input type="text" size="6" tabindex="1"  value="" name="pvms" id="<%=pvms+i %>"readonly="readonly" /></td>
						 <script>
			function eventCallback(element, entry){
			//alert("group-=="+document.getElementById('itemGroupId').value);
				return entry + "&itemGroupId=" + document.getElementById('itemGroupId').value+"&itemTypeId="+document.getElementById('itemTypeId').value+"&sectionId="+document.getElementById('sectionId').value+"&categoryId="+document.getElementById('categoryId').value+"&classId="+document.getElementById('classId').value                                                                       
			}
			</script> 	
						<td><input type="text" value="" tabindex="1" name="nomenclature" size="30" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"   />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
								new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>&toWard='+document.annualDepartmentIndent.<%=TO_WARD%>.value+''});
								</script></td>
						<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="<%="au"+""+i %>"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="year1IndentQty" id="year1IndentQtyId<%=i %>" validate="year1 Indent Qty,float,no"  /></td>
						<td><input type="text" size="8" value="" name="year2IndentQty" id="year2IndentQtyId<%=i %>"  validate="year2 Indent Qty,float,no" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" id="previousYearConsumptionId<%=i %>" validate="Previous Year Consumption,float,no" /></td>
						<td><input type="text" size="8" value="" name="incrementalPercentage" id="incrementalPercentageId<%=i %>" validate="Incremental Percentage,float,no"  onblur="calculateIndentQty(<%=i %>);"  /></td>
						<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="Incremental Qty,float,no" onblur="calculateIndentQty(<%=i %>);"  readonly="readonly"/></td>
						
						<%-- <td><input type="text" size="6" readonly="readonly" tabindex="1" value="" id="<%=stock+i %>" name="stock" validate="Stock In Hand,Intger,no" /></td>--%>
						<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,yes" /></td>
						<td><input type="text" size="8" value="" name="additionalQty" id="additionalQtyId<%=i %>" validate="additional Qty,float,no" onblur="calculateIndentQty(<%=i %>);"  /></td>
						<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,yes" /></td>
						<td><input type="text" size="10" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,remarks,no" maxlength="50"/></td>
						<input type="hidden" value="" name="itemId" id="<%=itemId+i %>" /></td>
						
					</tr>
					
			</table>
			</div>
	</div>	
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>


<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('annualDepartmentIndent','stores?method=submitAnnualDepartmentIndentData','validateQty');" class="button" />
<%-- <input	type="button" name="Forward for Approval" type="submit" value="Forward for Approval" 	onClick="upd();" class="buttonBig2" />--%>
<input type="button"	name="Reset" type="submit" onClick="" value="Reset"	class="button" />


</form>

<script type="text/javascript">

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
	
	if (!isNaN(document.getElementById('incrementalPercentageId'+inc).value))
		incrementalPercentage = parseFloat(document.getElementById('incrementalPercentageId'+inc).value);
	if (!isNaN(document.getElementById('previousYearConsumptionId'+inc).value))
		previousYearConsumption = parseFloat(document.getElementById('previousYearConsumptionId'+inc).value);

	if (!isNaN(document.getElementById('additionalQtyId'+inc).value) && document.getElementById('additionalQtyId'+inc).value!='')
		additionalQty = parseFloat(document.getElementById('additionalQtyId'+inc).value);
	
		if(!isNaN(previousYearConsumption) != "" && !isNaN(incrementalPercentage)!= ""){
			incrementalqty =Math.round(previousYearConsumption*incrementalPercentage)/100;
			document.getElementById('incrementalQtyId'+inc).value = Math.round(incrementalqty.toFixed(2));
		}
	if(!isNaN(incrementalqty) != "" && !isNaN(previousYearConsumption)!= ""){
		requiredQty =incrementalqty+previousYearConsumption;
		document.getElementById('requiredQtyId'+inc).value = Math.round(requiredQty.toFixed(2));
	}

	if(!isNaN(requiredQty) != "" && !isNaN(additionalQty)!= ""){
		demandedQty =requiredQty+additionalQty;
		document.getElementById('qtyRequest'+inc).value = Math.round(demandedQty.toFixed(2));
	}else if(!isNaN(requiredQty) != "" && additionalQty==''){
		demandedQty =requiredQty;
		document.getElementById('qtyRequest'+inc).value = Math.round(demandedQty.toFixed(2));
	}

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


<%-- function addRow(){
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
	  e0.value =iteration 
	  e0.size='3'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvms';
	  e1.id='pvms'+iteration;
	  e1.readonly ='readonly';
	  e1.size='5'
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
		new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&toWard='+document.annualDepartmentIndent.<%=TO_WARD%>.value+''});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au';
	  e3.size = '8';
	  e3.id='au'+iteration;
	  e3.readonly ='readonly';
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
	  e7.name='incrementalPercentage';
	  e7.id='incrementalPercentageId'+iteration
	  e7.setAttribute('validate','IncrementalPercentage,float,no');
	  e7.onblur=function(){calculateIndentQty(iteration);};
	  cellRight8.appendChild(e7);

	 /* var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='stock';
	  e7.id='stock'+iteration
	  cellRight8.appendChild(e7);*/
	  

	  var cellRight9 = row.insertCell(8);
	  var e71 = document.createElement('input');
	  e71.type = 'text';
	  e71.size='8';
	  e71.name='incrementalQty';
	  e71.id='incrementalQtyId'+iteration
	  e71.setAttribute('validate','IncrementalQty,float,no');
	  e71.onblur=function(){calculateIndentQty(iteration);};
	  cellRight9.appendChild(e71);



	  
	  var cellRight10 = row.insertCell(9);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='8';
	  e8.name='requiredQty';
	  e8.id='requiredQtyId'+iteration
	  e8.setAttribute('validate','RequiredQty,float,yes');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='8';
	  e9.name='additionalQty';
	  e9.id='additionalQtyId'+iteration
	  e9.onblur=function(){calculateIndentQty(iteration);};
	  e9.setAttribute('validate','AdditionalQty,float,no');
	  cellRight11.appendChild(e9);

	  var cellRight12 = row.insertCell(11);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.size='10';
	  e11.name='qtyRequest';
	  e11.id='qtyRequest'+iteration
	  e11.setAttribute('validate','Demanded Qty,float,yes');
	  cellRight12.appendChild(e11);

	  var cellRight13 = row.insertCell(12);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='10';
	  e12.name='remarks';
	  e12.id='remarks'+iteration
	  e12.setAttribute('validate','Remarks,string,no');
	  cellRight13.appendChild(e12);

	  var e13 = document.createElement('input');
	  e13.type = 'hidden';
	  e13.size='8';
	  e13.name='itemId';
	  e13.id='itemId'+iteration
	  cellRight13.appendChild(e13);
	  

	  
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
} --%>

function getOtherItemsForDepartmentIndent(val){

	annualDepartmentIndent.method="post";
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
	  var toWard=document.annualDepartmentIndent.<%= TO_WARD%>.value;
	    if(pvmsNo!=""){
	ajaxFunctionForGetOtherItemsForDepartmentIndent('annualDepartmentIndent','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+'&<%=TO_WARD%>='+toWard+''   , val);

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
	     //var stock=item.getElementsByTagName("stock")[0];
	        var name  = item.getElementsByTagName("name")[0];
       	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
       	document.getElementById('pvms'+rowVal).value =  pvms.childNodes[0].nodeValue ;
       	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue ;
       //	document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue ;
       	document.getElementById('qtyRequest'+rowVal).value = 0 ;
       	document.getElementById('au'+rowVal).value =  au.childNodes[0].nodeValue ;

     }
   }
 }
}


function show()
{
	alert("data is not available");
}



</script>
 
