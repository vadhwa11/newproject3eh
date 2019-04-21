<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mmfDepartment.jsp  
 * Purpose of the JSP -  This is for mmf Department.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>


<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<style type="text/css">
.locatorArrow {
	COLOR: #666666;
	text-align: center;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px;
}
</style>



<script language="Javascript">

function openPopupWindow()
{
var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	if(mmfDate != 0){
		var mmfMasterId = document.mmfDepartment.<%=MMF_DEPARTMENT_M_ID %>.value;
		var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
		var mmfNo = document.mmfDepartment.mmfNo.value;
		var remarks = document.mmfDepartment.<%=REMARKS %>.value;
		var approvedBy = document.mmfDepartment.<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>.value;
		var url="/hms/hms/stores?method=showAddMmfDepartmentJsp&mmfMasterId="+mmfMasterId + "&<%=MMF_DEPARTMENT_DATE%>=" + mmfDate +"&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>="+deptId+"&mmfNo="+mmfNo+"&<%=REMARKS%>="+remarks+"&<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>="+approvedBy +"&numOfRows=15&pageCount=10&currPage=1";
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=850,status=1');
	}else{
		alert("Please Select Year.");
	}
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	mmfDepartment.currPage.value = pidx;
	mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=getMmfDepartmentData');
}

function importMMF()
{
mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=createAndImportMmfDepartmentData');
}

function upd()
{
mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=updateGridItemsInMmf');
}

function checkForMmfData()
{
mmfDepartment.<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>.options.length=0;
mmfDepartment.method="post";
submitForm('mmfDepartment','stores?method=getCurrentYearMmf');
//document.getElementById('addbutton').disabled = true;
}

function validateDeleteButton()
{
	if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (mmfDepartment.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	mmfDepartment.method="post";
	submitForm('mmfDepartment','stores?method=deleteGridItemsForMmf');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function jsDisplay() {
	var docNo = document.searchPanel.<%=DOC_NO%>.value	
	if (docNo == "")
	{
	alert('Pl. select MMF No....');
	return;
	}
	var mmfDate = document.mmfDepartment.<%=MMF_DEPARTMENT_DATE %>.value;
	var deptId = document.mmfDepartment.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
	
	searchPanel.method="post";
	submitForm('searchPanel','stores?method=searchMmfDepartmentData&<%=MMF_DEPARTMENT_DATE%>='+mmfDate+'&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>=' + deptId+'&<%=DOC_NO%>='+docNo);
}
  function showReport(formName)
{
  obj = eval('document.'+formName)
  var docId = document.getElementById('docId').value
  obj.action = "/hms/hms/stores?method=printMmfEntryJsp&newDocId="+docId;
  obj.submit();
}
</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else 
	{
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) 
	{
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else 
	{
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<%
	Box box = HMSUtil.getBox(request);
	
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	int deptId = 0;
	String userName = "";
	int hospitalId = 0;
	int docId = 0;
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreFyDocumentNo> mmfNoList = new ArrayList<StoreFyDocumentNo>();
	List<StoreMmfDepartmentM> storeMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();

	if(session.getAttribute("deptId") != null)
	{
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if (session.getAttribute("userName") != null)
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null)
	{
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}
	
	if(map.get("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
		session.setAttribute("approvedByList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByList") != null)
	{
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByList");
		
	}
	
	if(map.get("mmfNoList")!=null)
	{
		mmfNoList = (List) map.get("mmfNoList");
	}
	
	if(map.get("docId")!=null)
	{
		docId = (Integer) map.get("docId");
		box.put("docId",docId);
	}
	
	if(map.get("remarks")!=null)
	{
		box.put(REMARKS, map.get("remarks").toString());
	}
	
	
	if(map.get("searchStoreMmfDepartmentMList")!=null)
		searchStoreMmfDepartmentMList = (List) map.get("searchStoreMmfDepartmentMList");
	
	if(map.get("storeMmfDepartmentMList")!=null)
		storeMmfDepartmentMList = (List) map.get("storeMmfDepartmentMList");

	
%>
<br />

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<h2 align="left" class="style1">MMF Department Entry</h2>


<div id="contentspace">

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<%
							if(storeMmfDepartmentMList != null && storeMmfDepartmentMList.size() > 0){
								
								StoreMmfDepartmentM mObj = (StoreMmfDepartmentM) storeMmfDepartmentMList.get(0);
								if(mObj.getStatus().equals("o")){
							%>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					onClick="openPopupWindow();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Update"
					onClick="upd();" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" onClick="del();"
					value="Delete" class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('mmfDepartment');"></td>



				<%}else{ 
					    %>

				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" disabled value="Add"
					onClick="openPopupWindow();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" disabled value="Update"
					onClick="upd();" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" disabled value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" disabled onClick="del();"
					value="Delete" class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('mmfDepartment');"></td>

				<%}
							}else{%>

				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					onClick="openPopupWindow();" class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Update"
					onClick="upd();" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" onClick="del();"
					value="Delete" class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('searchPanel');"></td>

				<%} %>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB"> MMF No: </label> <select name="<%=DOC_NO%>">
			<option value="">Select MMF No</option>
			<%
				for (StoreMmfDepartmentM mObj :searchStoreMmfDepartmentMList ) {
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getDocNo()%></option>
			<%
				}
			%>
		</select> <input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" /> <input
			type="button" name="Submit" id="addbutton" value="Submit"
			class="button" onClick="jsDisplay();" /></td>
	</tr>


</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


</div>
</div>
</div>
<br />

<form name="mmfDepartment" method="post"><input type="hidden"
	name="numOfRows" size="5" value="5"><input type="hidden"
	name="pageCount" size="5" value="10"><input type="hidden"
	name="docId" id="docId" value="<%=box.get("docId")%>" /> <br />

<%
	String mmfNo = "";
	
	if(map.get("finalMmfNo") != null){
		mmfNo = (String)map.get("finalMmfNo");
	}else if(map.get("mmfNo") != null){
		mmfNo = (String)map.get("mmfNo");
	}
	
	%> <input type="hidden" name="mmfNo" value="<%=mmfNo%>">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 52px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">




<label class="bodytextB">Dept Name:</label> <%
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%> <label><%=masDepartment.getDepartmentName()%></label> <input
	type="hidden" name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>"
	value="<%=masDepartment.getId() %>"> <%	break;	
				}
				}
			%> <label class="bodytextB">Year:</label> <select
	name="<%=MMF_DEPARTMENT_DATE %>" onchange="checkForMmfData()"
	validate="Year,String,yes">
	<option value="0">Select</option>

	<%
	int mmfDate = 0;
	if(map.get("mmfDate") != null){ 
		mmfDate = (Integer)map.get("mmfDate"); 
		if(mmfDate == Integer.parseInt(date.substring(6))){
	%>

	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>
		selected><%=date.substring(6)%></option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6))+1%>
	</option>
	<%}else if(mmfDate == Integer.parseInt(date.substring(6))+1){ %>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>><%=date.substring(6)%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>
		selected><%=Integer.parseInt(date.substring(6))+1%></option>
	<%}
		}else{	%>
	<option value="<%=date.substring(6)%>"
		<%=HMSUtil.isSelected(date.substring(6),box.getString(MMF_DEPARTMENT_DATE))%>><%=date.substring(6)%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"
		<%=HMSUtil.isSelected(String.valueOf(Integer.parseInt(date.substring(6))+1),box.getString(MMF_DEPARTMENT_DATE)) %>><%=Integer.parseInt(date.substring(6))+1%>
	</option>

	<%} %>
</select> <br> <label class="bodytextB">Remarks:</label> <input type="text"
	name="<%=REMARKS %>" value="<%=box.get(REMARKS) %>"
	class="textbox_size20" tabindex=3 MAXLENGTH="30" /> <label
	class="bodytextB">Approved By:</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	<%
	int approvedId = 0;
	if(map.get("approvedId") != null){
		approvedId = (Integer)map.get("approvedId") ;
	}
	if(approvedId != 0){
		for (MasEmployee approvedBy :approvedByEmployeeList ) {
			if(approvedBy.getId() == approvedId){
%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>
		selected><%=approvedBy.getFirstName()%></option>
	<%			}else{
%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>><%=approvedBy.getFirstName()%></option>

	<%	
			}
		}
	}else{
			for (MasEmployee approvedBy :approvedByEmployeeList ) 
			{
%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)) %>><%=approvedBy.getFirstName()%></option>
	<%
			}
	}
%>
</select></div>
<br />

<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_M_ID %>"
	value="<%=map.get("mmfMasterId") == null?0:map.get("mmfMasterId")%>" />
<% if (pagedArray==null) {  %> <input type="button" name="Submit"
	id="addbutton" value="Import" class="button" onClick="importMMF();" />
<% } %> <br />


<% if (pagedArray == null) { %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF Department Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Remarks</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Delete</label></td>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>

<% } else { %>


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">MMF Department Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; width: 100%; height: 175px; padding-left: 9px;">
<table width="100%" colspan="7" id="mmfDepartmentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">MMF</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Remarks</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Delete</label></td>
		</tr>
	</thead>
	<tbody>
		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")==null?"":gridData[i].get("pvms")%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")==null?"":gridData[i].get("nomenclature")%>"
				class="bigcaption" name="nomenclature" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				class="medcaption" name="au" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("qtymmf")%>" name="qtymmf"
				validate="MMF Qty,num,no" maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remark")==null?"":gridData[i].get("remark")%>"
				name="remark" validate="Remarks,String,no" maxlength="30" /></td>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>

<div style="padding-left: 250px;">
<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>
<br />

<% } %> <input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>
</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>