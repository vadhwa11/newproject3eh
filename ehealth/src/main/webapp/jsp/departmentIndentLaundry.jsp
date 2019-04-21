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
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<!-- <style type="text/css">
.locatorArrow
{
    COLOR: #666666;
    text-align: center;
    FONT-FAMILY: Verdana;
    FONT-SIZE: 12px;
}
</style> -->
<script language="Javascript">
function openPopupWindow()
{
//var storeDepartmentId=document.departmentIndent.<%= ITEM_TYPE_ID %>.value;
var toDept = document.departmentIndent.<%= TO_WARD%>.value;
var approvedBy = document.departmentIndent.<%= APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
var requestBy = document.departmentIndent.<%= REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
if(toDept != 0 && approvedBy != 0 && requestBy != 0 ){
var internalIndentId = document.departmentIndent.internalIndentId.value;
var deptId = document.departmentIndent.<%= FROM_WARD%>.value;
var demandNo = document.departmentIndent.<%= DEMAND_NO%>.value;
var demandDate = document.departmentIndent.<%= DEMAND_DATE%>.value;
//var storeDepartmentId= document.departmentIndent.<%= ITEM_TYPE_ID%>.value;
var url="/hms/hms/laundry?method=showAddDepartmentIndentLaundry&internalIndentId="+internalIndentId + "&<%=FROM_WARD%>="+deptId+ "&<%=TO_WARD%>="+toDept+ "&<%=DEMAND_NO%>="+demandNo+ "&<%=DEMAND_DATE%>="+demandDate+"&<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+approvedBy+"&<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>="+requestBy +"&numOfRows=15&pageNo="+1;
newwindow=window.open(url,'name','top=50, left=50, height=500,width=800,status=1,scrollbars=yes');
}else{
alert("Please Select All the fields.");
}
}
//this function will be called by the Bean (not from JSP)
function goPage(pidx) {
	document.departmentIndent.currPage.value = pidx;

	var numOfRows=document.getElementById('numOfRows').value;
	document.departmentIndent.method="post";
	submitForm('departmentIndent','laundry?method=getLaundryIndentData&numOfRows='+numOfRows+'&currPage='+pidx+'');
}
function storeDisabled()
{
//document.departmentIndent.<%= ITEM_TYPE_ID%>.disabled=true;
}
function importIndent()
{
document.departmentIndent.method="post";
var toDept = document.departmentIndent.<%= TO_WARD%>.value;
var approvedBy = document.departmentIndent.<%= APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
var requestBy = document.departmentIndent.<%= REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>.value;
if(toDept==""||toDept=="0"){
alert("pls select the field to department");
return false;
}
if(approvedBy==""||approvedBy=="0"){
alert("pls select the field to Approved By");
return false;
}
if(requestBy==""||requestBy=="0"){
alert("pls select the field to Request By");
return false;
}
document.getElementById('importIndent').style.display ='none';
document.getElementById('importIndentNone').style.display ='inline';
submitForm('departmentIndent','stores?method=createAndImportDepartmentIndentData');
}

function upd()
{
var status1="YES";

document.departmentIndent.method="post";
submitForm('departmentIndent','laundry?method=updateGridItemsInDepartmentIndentLaundry&status1='+status1);
}

function validateDeleteButton()
{
	if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (document.departmentIndent.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	document.departmentIndent.method="post";
	submitForm('departmentIndent','laundry?method=deleteGridItemsForDepartmentIndentLaundry');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function jsDisplay() {
	var demandNo = document.searchPanel.<%=DEMAND_NO%>.value
	var status1="YES"
	if (demandNo == "")
	{
	alert('Pl. select Demand No....');
	return;
	}
	//document.departmentIndent.currPage.value=1;
	var numOfRows=document.departmentIndent.numOfRows.value;

	document.searchPanel.method="post";

	submitForm('searchPanel','laundry?method=getLaundryIndentData&<%=DEMAND_NO%>='+demandNo+"&status1="+status1+'&numOfRows=5&currPage=1');
}
function showReport(formName)
{
  obj = eval('document.'+formName)
  var newDemandNo = document.getElementById('newDemandNo').value
  obj.action = "/hms/hms/stores?method=printDepartmentIndentJsp&newDemandNo="+newDemandNo;
  obj.submit();
}


function submitprint(formName){
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printDepartmentIndent";
  obj.submit();

  }

</script>

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);

	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int deptId = 0;
	int hospitalId = 0;
	String newDemandNo = "";

	int internalIndentId = 0;
	List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<Object[]> storeInternalIndentMDemandNoList = new ArrayList<Object[]>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();

	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if (map.get("internalIndentId")!=null){
		internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
	}
	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("searchStoreInternalIndentMList")!=null){
		searchStoreInternalIndentMList = (List) map.get("searchStoreInternalIndentMList");
	}
	if(map.get("storeInternalIndentMDemandNoList")!=null){
		storeInternalIndentMDemandNoList = (List) map.get("storeInternalIndentMDemandNoList");
	}
	if(map.get("storeInternalIndentMList")!=null)
		storeInternalIndentMList = (List) map.get("storeInternalIndentMList");

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();

	String date = (String)utilMap.get("currentDate");
	String demandDate ="";
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null){
		departmentList = (ArrayList)session.getAttribute("departmentList");

	}
	List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
	if(map.get("departmentList1") != null)
	{
		departmentList1= (ArrayList) map.get("departmentList1");
	}

	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
		session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
	}

	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
		session.setAttribute("requestByEmployeeList",requestByEmployeeList);
	}else if(session.getAttribute("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList)session.getAttribute("requestByEmployeeList");
	}
	String status1="";
	if(map.get("status1") != null){
		 status1 = (String)map.get("status1");
	}

	if(map.get("demandNoList") != null){
		demandNoList = (List<StoreFyDocumentNo>)map.get("demandNoList");
	}
	if(map.get("newDemandNo") != null){
		newDemandNo = (String)map.get("newDemandNo");
	}

	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %> </span></h4>
<%
	}
	int deptIdForToStore =151;
	int approvedById = 0;
	int requestById = 0;
	int storeDepartmentId =0 ;

	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List)map.get("storeInternalIndentTList");
	}
	if(storeInternalIndentTList != null && storeInternalIndentTList.size() > 0){
		StoreInternalIndentT tObj = (StoreInternalIndentT)storeInternalIndentTList.get(0);
		deptIdForToStore = tObj.getInternal().getToStore().getId();
		approvedById = tObj.getInternal().getApprovedBy().getId();
		requestById = tObj.getInternal().getRequestedBy().getId();
		if(tObj.getInternal().getStoreDepartment()!=null){
			storeDepartmentId = tObj.getInternal().getStoreDepartment().getId();
		}
	}
%>

<div class="titleBg">
<h2>Laundry Indent</h2>
</div>
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<%
if(storeInternalIndentMList != null && storeInternalIndentMList.size() > 0){

StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentMList.get(0);
	if(mObj.getDemandDate()!=null){
	demandDate = HMSUtil.convertDateToStringTypeDateOnly(mObj.getDemandDate());
	}else{
		demandDate =date;
	}
	
	
if(mObj.getStatus().equals("o")){

%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" value="Add"	onClick="openPopupWindow();" class="button">
<input	type="button" name="Update" type="submit" value="Update"	onClick="upd();" class="button">
<input type="button"	name="Delete" type="submit" onClick="del();" value="Delete"	class="button">
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<%}else{

					    %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Add" type="submit" disabled	value="Add" onClick="openPopupWindow();" class="button">
<input	type="button" name="Update" type="submit" disabled value="Update"	onClick="upd();" class="button">
 <input type="button"	name="Delete" type="submit" disabled onClick="del();" value="Delete"	class="button"> <%--<input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<%}
			}else{
			// At the time of Jsp load or Fress Indent Demand date will be current date
				demandDate =date;
				
			%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit"	value="Add" onClick="openPopupWindow();" class="button">
 <input	type="button" name="Update" type="submit" value="Update"	onClick="upd();" class="button">
  <input type="button"	name="Delete" type="submit" onClick="del();" value="Delete"	class="button">
   <%--<input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('searchPanel');">--%>
<%} %>
<input type="button" name="print" type="button" class="button"	value="Print" onClick="submitprint('departmentIndent');"> <!-- thread search menu -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="searchPanel" method="post">
<label>Demand No.  </label>
<select name="<%=DEMAND_NO%>">
<!-- for (StoreInternalIndentM mObj :searchStoreInternalIndentMList ) {
mObj.getDemandNo()
 -->
	<option value="">Select Demand No.</option>
	<%for(Object[]  obj : storeInternalIndentMDemandNoList){%>
	<option value="<%=obj[1] %>"><%=obj[1] %></option>
	<%}	%>
</select>
<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
 <input	type="image" name="Submit" id="addbutton"	class="button" onClick="jsDisplay();" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<form name="departmentIndent" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" id="numOfRows"	name="numOfRows" size="10" value="5">
<input type="hidden"	name="pageCount" size="5" value="10">
<input type="hidden"	name="newDemandNo" id="newDemandNo" value="<%=newDemandNo%>" />
 <%if(map.get("fromImport")!=null&&pagedArray==null){%>
<script language="Javascript">
		alert("There Are no Items To Import...");
		</script> <%}
	String demandNo = "";

	if(map.get("finalDemandNo") != null){
		demandNo = (String)map.get("finalDemandNo");
	}else if(map.get("demandNo") != null){
		demandNo = (String)map.get("demandNo");
	}

	%>
<div class="clear"></div>
<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block"><label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="<%=demandNo%>" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> 
	
	<label>Demand Date</label> <input
	type="text" name="<%=DEMAND_DATE %>" value="<%=demandDate%>"
	readonly="readonly" tabindex=3 class="readOnly" />
<div class="clear"></div>

</select>
<%-- <label><span>*</span> Store Department</label> <% if(status1.equals("YES")){%>
<select name="<%= ITEM_TYPE_ID %>" Disabled
	onchange="submitProtoAjaxWithDivName('item','pharmacy?method=getGroupDepartmentWise','itemDiv');"
	tabindex=1>


	<option value="0">Select</option>


	<%
				for (MasDepartment masItemTypecode  :departmentList1)  {
					if(storeDepartmentId != 0){
						if(masItemTypecode.getId() == storeDepartmentId){
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>
		selected="selected"><%=masItemTypecode.getDepartmentName()%></option>
	<%			}else{
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>><%=masItemTypecode.getDepartmentName()%></option>
	<%
						}
					}else{
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>><%=masItemTypecode.getDepartmentName()%></option>
	<%
					}
				}
			%>
</select> <%}else{ %> <select name="<%= ITEM_TYPE_ID %>" onblur="storeDisabled()"
	onchange="submitProtoAjaxWithDivName('item','pharmacy?method=getGroupDepartmentWise','itemDiv');"
	tabindex=1>


	<option value="0">Select</option>


	<%
				for (MasDepartment masItemTypecode  :departmentList1)  {
					if(storeDepartmentId != 0){
						if(masItemTypecode.getId() == storeDepartmentId){
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>
		selected="selected"><%=masItemTypecode.getDepartmentName()%></option>
	<%			}else{
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>><%=masItemTypecode.getDepartmentName()%></option>
	<%
						}
					}else{
			%>
	<option value=<%=masItemTypecode.getId()%>
		<%=HMSUtil.isSelected(masItemTypecode.getId().toString(),box.getString(ITEM_TYPE_ID)) %>><%=masItemTypecode.getDepartmentName()%></option>
	<%
					}
				}
			%>
</select> <%} %>
--%>
<label>From </label> <%
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%> <label class="value"><%=masDepartment.getDepartmentName()%></label>

<input type="hidden" name="<%=FROM_WARD%>"
	value="<%=masDepartment.getId() %>"> <%	break;
				}
				}
			%> <label>To </label> <select name="<%=TO_WARD%>"
	validate="To Ward,String,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :departmentList ) {
					if(deptIdForToStore != 0){
						if(masDepartment.getId() == deptIdForToStore){
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>
		selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%
						}else{
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					}else{
			%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(TO_WARD)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
					}
				}
			%>
</select>

<div class="clear"></div>
<label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
					if(approvedById != 0){
						if(approvedBy.getId() == approvedById){
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>
		selected="selected"><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
	<%			}else{
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
	<%
						}
					}else{
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
	<%
					}
				}
			%>
</select> <label><span>*</span> Request By</label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,String,no">
	<option value="0">Select</option>
	<%
				for (MasEmployee requestedBy :requestByEmployeeList ) {
					if(requestById != 0){
						if(requestedBy.getId() == requestById){
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>
		selected><%=requestedBy.getFirstName()+" "+requestedBy.getLastName()%></option>

	<%			}else{
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=requestedBy.getFirstName()+" "+requestedBy.getLastName()%></option>
	<%
			}
					}else{
			%>
	<option value="<%=requestedBy.getId()%>"
		<%=HMSUtil.isSelected(requestedBy.getId().toString(),box.getString(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT)) %>><%=requestedBy.getFirstName()+" "+requestedBy.getLastName()%></option>
	<%
					}
				}
			%>
</select>
<div class="clear"></div></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="internalIndentId"
	value="<%=map.get("internalIndentId") == null?0:(Integer)map.get("internalIndentId")%>" />

<% if (pagedArray==null) {  %>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="importIndent" style="display: none;">
<input type="button" name="Submit" id="addbutton"	value="Import Last Indent" class="buttonBig" onClick="importIndent();" />
</div>
<div id="importIndentNone" style="display: none;">
<input type="button" name="Submit" id="addbutton"	value="Import Last Indent" class="buttonBig"  disabled="disabled"/>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% } %>
<div class="clear"></div>
<% if (pagedArray == null) { %>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Indent Details</h4>
<div class="clear"></div>
<table width="100%" colspan="7" id="indentDetails" border="0"
	cellpadding="0" cellspacing="0">
	<tr>
		<th>S.No.</th>
		<th>Item No</th>
		<th>Item Name</th>
		<th>UOM</th>
		<th>Stock In Hand</th>

		<th>Requested Qty</th>
		<th>Delete</th>
	</tr>

	<tr>
		<td colspan=6>No Data Found</td>
	</tr>

</table>

<% } else { %>
<h4>Indent Details</h4>
<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>UOM</th>
						<th>Stock In Hand</th>

						<th>Requested Qty</th>
						<th>Delete</th>
					</tr>
					<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
				for(int i=0;i<gridData.length;i++)
			    { %>
					<tr>
						<td width="%5"><input type="text" size="5"
							value="<%=iFirstRow++%>" name="srno" class="readOnly"
							readonly="readonly" /></td>
						<td><input type="text" size="8"
							value="<%=gridData[i].get("pvms")%>" name="pvms" class="readOnly"
							readonly="readonly" /></td>
						<td><input type="text"
							value="<%=gridData[i].get("nomenclature")%>" name="nomenclature"
							class="readOnly" readonly="readonly"  size="50"/></td>
						<td><input type="text" size="8"
							value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
							name="au" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8"
							value="<%=gridData[i].get("stock")%>" name="stock"
							validate="Stock In Hand,num,no" class="readOnly"
							readonly="readonly" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="text" size="8"
							value="<%=gridData[i].get("qtyRequest")%>" name="qtyRequest"
							validate="Requested Qty,num,no" /></td>
						<td align="center" width="10%"><input type="checkbox"
							name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>"
							class="radioCheck"></td>
						<td><input type="hidden" value="<%=gridData[i].get("id")%>"
							name="id" /></td>
					</tr>
					<% } %>
					<tr class="locatorArrow">
						<td colspan=7><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
					</tr>
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
<% } %> <input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<div class="clear"></div>
<div class="paddingTop40"></div></form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>