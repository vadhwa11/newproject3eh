<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int mmfMasterId = 0;
	if (box.getInt("mmfMasterId")!=0)
	{
		mmfMasterId = box.getInt("mmfMasterId"); 
	}
	else if (map.get("newmmfMasterId")!=null) 
	{
		mmfMasterId = (Integer)map.get("newmmfMasterId");
	}
	
%>

<title>MMF Addition</title>


<script>

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	mmfForm.currPage.value = pidx;
	mmfForm.method="post";
	var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID %>.value;
	submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&mmfMasterId='+mmfMasterId);
}

function jsSubmit()
{
		mmfForm.method="post";
		var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value;
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&mmfMasterId='+mmfMasterId);
}

function jsAdd()
{
		mmfForm.method="post";
		var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID %>.value;
		var mmfDate = document.mmfForm.<%=MMF_DEPARTMENT_DATE%>.value;
		var deptId = document.mmfForm.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
		var mmfNo = document.mmfForm.mmfNo.value;
		var remarks  = document.mmfForm.<%=REMARKS %>.value;
		submitForm('mmfForm','stores?method=doAddMmfItems&mmfMasterId='+mmfMasterId + '&<%=MMF_DEPARTMENT_DATE%>=' + mmfDate + '&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>=' + deptId+'&mmfNo='+mmfNo+'&<%=REMARKS %>='+remarks); 
}

function jsClose()
{
  window.opener.location.href = "stores?method=getMmfDepartmentData&<%=MMF_DEPARTMENT_DATE%>="+mmfForm.<%=MMF_DEPARTMENT_DATE%>.value+"&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>="+mmfForm.<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value+"&<%=REMARKS%>="+mmfForm.<%=REMARKS%>.value;
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 } 
  window.close();
}

</script>

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<br />

<h2 align="left" class="style1">MMF Addition</h2>



<div id="contentspace">

<form name="mmfForm"><input type="hidden" name="numOfRows"
	size="5" value="15"><input type="hidden" name="pageCount"
	size="5" value="10"><input type="hidden" name="search" size="5"
	value="true"><input type="hidden"
	name="<%=MMF_DEPARTMENT_M_ID %>" value="<%=mmfMasterId%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_DATE %>"
	value="<%=box.get(MMF_DEPARTMENT_DATE)%>" /> <input type="hidden"
	name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT %>"
	value="<%=box.get(STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT) %>" />
<input type="hidden" name="mmfNo" value="<%=box.get("mmfNo") %>" /> <input
	type="hidden" name="<%=REMARKS %>" value="<%=box.get(REMARKS) %>" /> <input
	type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>"
	value="<%=box.get(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)%>" /> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div style="padding-left: 15px;">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Store Item(s) Search</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 810px; height: 83px; background-color: #f4f9fe;">



<br />


<label class="bodytextB">Nomenclature</label> <input type="text"
	name="search_text" value="<%=box.get("search_text") %>"
	class="textbox_size20" MAXLENGTH="30"
	onkeypress="submitenter(this,event,'stores?method=showAddMmfDepartmentJsp&mmfMasterId='+document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value)" />

<br />
<br />
<label class="bodytextB">PVMS No</label> <input type="text" name="pvms"
	value="<%=box.get("pvms") %>" class="textbox_size20" MAXLENGTH="30"
	onkeypress="submitenter(this,event,'stores?method=showAddMmfDepartmentJsp&mmfMasterId='+document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value)" />


<input type="button" name="Submit" id="addbutton" onClick="jsSubmit()"
	value="Submit" class="button" /></div>



<br />
<%		
		if (pagedArray == null) {
		%>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Store MMF Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: scroll; overflow-x: hidden; width: 85%; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="30%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Strength</label></td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="10%"><label valign="left" class="smalllabel">MMF</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" /> <%  } else { %>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Store MMF Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 85%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td><label valign="left" class="smalllabel">S.No.</label></td>
			<td><label valign="left" class="smalllabel">PVMS No</label></td>
			<td><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td><label valign="left" class="smalllabel">Strength</label></td>
			<td><label valign="left" class="smalllabel">A/U</label></td>
			<td><label valign="left" class="smalllabel">MMF</label></td>
			<td><label valign="left" class="smalllabel">ADD</label></td>

		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="srno" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("pvms" )%>"
				class="medcaption" name="pvms" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
				name="nomenclature" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("strength")==null?"":gridData[i].get("strength")%>"
				class="medcaption" name="strength" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("au")%>"
				name="au" class="medcaption" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get("qtymmf")==null)?"0":gridData[i].get("qtymmf")%>"
				class="medcaption" name="qtymmf" validate="MMF Qty,num,no"
				maxlength="6" /></td>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("itemId")%>"></td>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>

		</tr>
		<% } %>

	</tbody>
</table>
</div>

<br />



<div style="padding-left: 250px;">
<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>

<div><br />
<input type="button" name="Add" onClick="jsAdd()" value="Add"
	class="button" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" /></div>
</div>
<%}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
