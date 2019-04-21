<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreCondemnationM"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style>
#contentspace label {
	text-align: right;
	padding-right: 0px;
	width: 95px;
	float: left;
	height: 9px;
}
</style>

<script type="text/javascript">

function checkForWorkOrder()
{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=getWorkOrderDetails');
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	condemnForm.currPage.value = pidx;
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=getWorkOrderDataForDisplayGrid');
}

function validateDeleteButton()
{
	if (condemnForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < condemnForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (condemnForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (condemnForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=deleteGridItemsForCondemnation');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function upd()
{
	condemnForm.method="post";
	submitForm('condemnForm','nonExpNew?method=updateGridItemsInCondemnation');
}

function jsDisplay() {
	var condemnationId = document.searchPanel.<%=CONDEMNATION_ID%>.value	
	if (condemnationId == "")
	{
	alert('Pl. select Condemnation No....');
	return;
	}
	var workDate = document.condemnForm.<%=WORK_ORDER_DATE %>.value;
	var condemnationDate = document.condemnForm.<%=CONDEMNATION_DATE %>.value;
	var deptId = document.searchPanel.<%= FROM_WARD%>.value;
	//var condemnationNo = document.condemnForm.<%= CONDEMNATION_NO%>.value;
		
	searchPanel.method="post";
	submitForm('searchPanel','nonExpNew?method=searchCondemnation&<%=WORK_ORDER_DATE%>='+workDate+'&<%=CONDEMNATION_DATE%>=' + condemnationDate+'&<%=CONDEMNATION_ID%>='+condemnationId+'&deptId='+deptId);
}

</script> <script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script> <script>

<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<style type="text/css" media="screen">
.selected {
	background-color: #888;
}
</style>

<% 
	Box box = HMSUtil.getBox(request);
	HashMap[] gridData = null;
	PagedArray pagedArray = null;
	
	Map map = new HashMap();
	String message = "";
	String userName = "";
	int deptId = 0;
	int hospitalId = 0;
	String time ="";
	int condemnationId = 0;	
	int condemnationNo = 0;
	int workOrderId = 0;
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
	List<StoreWorkOrderM> workOrderMList = new ArrayList<StoreWorkOrderM>();
	List<StoreCondemnationM> condemnationMList = new ArrayList<StoreCondemnationM>();
	List<StoreCondemnationM> searchCondemnationMList = new ArrayList<StoreCondemnationM>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	if(map.get("condemnationId")!=null){
		condemnationId=Integer.parseInt(""+map.get("condemnationId"));
	}	
	if(map.get("condemnationNo")!=null){
		condemnationNo = (Integer)map.get("condemnationNo");
	}
	if(map.get("workOrderId")!=null){
		workOrderId = (Integer)map.get("workOrderId");
	}
	String condemnationDate = "";
	String workOrderDate = "";
	
	
	if(map.get("condemnationDate")!=null){
		condemnationDate = (String)map.get("condemnationDate");
	}
	if(map.get("workOrderDate")!=null){
		workOrderDate = (String)map.get("workOrderDate");
	}
	
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(map.get("departmentList") != null)
	{
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null)
	{
		departmentList = (ArrayList)session.getAttribute("departmentList");
	}
	if(map.get("searchWorkOrderList")!=null)
	{
		searchWorkOrderList = (List) map.get("searchWorkOrderList");
	}
	if(map.get("message") != null)
	{
		message = (String)map.get("message"); 
	}
	if (session.getAttribute("userName") != null) 
	{
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("deptId") != null) 
	{
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (session.getAttribute("hospitalId") != null) 
	{
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	if(map.get("workOrderMList")!=null)
	{
		workOrderMList = (List<StoreWorkOrderM>) map.get("workOrderMList");
	}
	else if(map.get("condemnationMList")!=null)
	{
		condemnationMList = (List<StoreCondemnationM>) map.get("condemnationMList");
	}
	
	if(map.get("searchCondemnationMList")!=null)
	{
		searchCondemnationMList = (List<StoreCondemnationM>) map.get("searchCondemnationMList");
	}
		
	StoreWorkOrderM  storeWorkOrderObj = null;
%> <br />
<h2 align="left" class="style1">Condemnation Entry</h2>

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
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('createGrn','nonExpNew?method=showGrnJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton" onClick="upd()"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="del()"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" value="Print" class="toolbutton"
					onClick="submitForm('condemnForm','nonExpNew?method=printCondemnationJsp');" /></td>

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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB"> Condemnation No: </label> <select
			name="<%=CONDEMNATION_ID%>">
			<option value="0">Select Condemnation No</option>
			<%
				for (StoreCondemnationM mObj :searchCondemnationMList ) {
				
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getCondemnationNo()%></option>
			<%
		
				}
			%>
		</select> <input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" /> <input
			type="button" name="Submit" id="addbutton" value="Submit"
			class="button" onClick="jsDisplay();" /></td>
	</tr>


</table>
</form>
</div>
</div>


</div>
<br />
<form name="condemnForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">

<input type="hidden" name="deptId" value="<%=deptId%>" /> <input
	type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <label
	class="bodytextB"><font id="error">*</font>Condemnation No.</label> <% if(storeWorkOrderObj != null){%>
<input type="text" class="readOnly" name="<%= CONDEMNATION_NO %>"
	value="<%=condemnationNo %>" readonly="readonly" tabindex=1 /> <%}else{ %>
<input type="text" class="readOnly" name="<%= CONDEMNATION_NO %>"
	value="<%=condemnationNo %>" readonly="readonly" tabindex=1 /> <%} %> <%if(condemnationDate != null){ %>
<label class="bodytextB"><font id="error">*</font> Condemnation
Date:</label> <input type="text" name="<%=CONDEMNATION_DATE%>"
	value="<%=condemnationDate%>" class="textbox_date" readonly
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate%>',document.condemnForm.<%=CONDEMNATION_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <%}else{ %> <label
	class="bodytextB"><font id="error">*</font> Condemnation Date:</label>
<input type="text" name="<%=CONDEMNATION_DATE%>"
	value="<%=box.get(CONDEMNATION_DATE) %>" class="textbox_date" readonly
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate%>',document.condemnForm.<%=CONDEMNATION_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <%} %> <br />

<label class="bodytextB"><font id="error">*</font>Work Order No.</label>
<select name="<%=WORK_ORDER_ID %>" onchange="checkForWorkOrder()">
	<option value="">Select</option>
	<%
	for(StoreWorkOrderM mObj : workOrderMList)
	  {
		if(mObj.getId() == workOrderId){
	%>
	<option value="<%=mObj.getId() %>"
		<%=HMSUtil.isSelected(mObj.getId().toString(),box.getString(WORK_ORDER_ID)) %>
		selected><%=mObj.getWorkOrderNo() %></option>

	<%}else{ %>
	<option value="<%=mObj.getId() %>"
		<%=HMSUtil.isSelected(mObj.getId().toString(),box.getString(WORK_ORDER_ID)) %>><%=mObj.getWorkOrderNo() %></option>
	<%} 
	}%>
</select> <%if(workOrderDate != null){ %> <label class="bodytextB"> Work
Order Date:</label> <input type="text" name="<%=WORK_ORDER_DATE%>"
	value="<%=workOrderDate%>" class="textbox_date" readonly MAXLENGTH="30" />
<a
	href="javascript:setdate('<%=currentDate%>',document.condemnForm.<%=WORK_ORDER_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <%}else{ %> <label
	class="bodytextB"> Work Order Date:</label> <input type="text"
	name="<%=WORK_ORDER_DATE%>" value="<%=box.get(WORK_ORDER_DATE) %>"
	class="textbox_date" readonly MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate%>',document.condemnForm.<%=WORK_ORDER_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <%} %> <!-- 
	 <label class="bodytextB"><font id="error">*</font>Condition Of Item:</label>
	 <select name="<%=CONDITION_OF_ITEM %>" >
		 <option value="">Select</option>
		 <option value="S" <%=HMSUtil.isSelected("S",box.getString(CONDITION_OF_ITEM)) %>>Ser</option>
		 <option value="R" <%=HMSUtil.isSelected("R",box.getString(CONDITION_OF_ITEM)) %>>Rep</option>
		 <option value="U" <%=HMSUtil.isSelected("U",box.getString(CONDITION_OF_ITEM)) %>>U/S</option>
		 <option value="O" <%=HMSUtil.isSelected("O",box.getString(CONDITION_OF_ITEM)) %>>OBS</option>
	 </select>
	  --> <br />
<br />

<!--<div style="float: left; padding-left: 15px;  ">
	 		<input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkSave()){submitForm('grnGrid','neStores?method=submitCondemnation');}"/>
	  </div>--></div>
<br />

<br />


<% if (pagedArray == null) { %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Work Order</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="100%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="23%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="8%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Part
			No. </label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>
			<td width="23%"><label valign="left" class="smalllabel">Reason
			For Sentence</label></td>
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
<font class="boxtitle">Work Order</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="100%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="23%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="8%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Part
			No. </label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>
			<td width="23%"><label valign="left" class="smalllabel">Reason
			For Sentence</label></td>
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
				class="readOnly" name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")==null?"":gridData[i].get("pvms")%>"
				class="readOnly" name="pvms" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")==null?"":gridData[i].get("nomenclature")%>"
				class="readOnly" name="nomenclature" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("serialNo")==null?"":gridData[i].get("serialNo")%>"
				class="readOnly" name="serialNo" readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("partNo")==null?"":gridData[i].get("partNo")%>"
				name="partNo" validate="Part No,num,no" maxlength="6" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("qty")==null?"":gridData[i].get("qty")%>"
				name="qty" validate="Qty,int,no" class="readOnly" readonly
				maxlength="30" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("reason")==null?"":gridData[i].get("reason")%>"
				name="reason" validate="Reason For Sentence,String,no"
				maxlength="30" /></td>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=gridData[i].get("id")%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<% } %>
		<tr class="locatorArrow">
			<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
		</tr>
	</tbody>
</table>
</div>
<%} %> <br />

<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=currentDate%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=currentTime%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /> <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>
</div>