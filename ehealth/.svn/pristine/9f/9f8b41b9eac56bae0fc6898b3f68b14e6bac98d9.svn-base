<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * acknowledgmentIssueLaundry.jsp
	 * Purpose of the JSP -  This is for Acknowledgment for Issue Laundry.
	 * @author  Mukesh Narayan Singh	
	 * Create Date: 7th July, 2011
	 * Revision Date:
	 * Revision By:
	 * @version 1.5
	--%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
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
<script language="Javascript">
deptArray = new Array();
/*function populateIssueNoAndDate(val,formName){
		obj = eval('document.'+formName+'.issueNo');
		obj.length = 1;
		for(i=0;i<deptArray.length;i++){
			if(deptArray[i][1]==val){
				obj.length++;
				obj.options[obj.length-1].value=deptArray[i][0];
				obj.options[obj.length-1].text=deptArray[i][2];
			}
		}
	}
*/
function getIssue()
{
	document.ack.method="post";
	var issueNo = document.getElementById('issueNo').value;
	var issueDept = document.getElementById('issueDept').value;
	var acknowledgedBy = document.getElementById('acknowledgedBy').value;
	if (issueNo==0 || issueDept==0 || acknowledgedBy==0)
	{
		alert("Pl. Check your Inputs!...  ");
		return;
	}
	submitForm('ack','laundry?method=createGridLaundryIssueData&<%=ISSUE_NO%>='+issueNo+"&currPage=1");
}
//this function will be called by the Bean (not from JSP)
function goPage(pidx) {
	//ack.currPage.value = pidx;
	//ack.method="post";
	 obj = eval('document.ack');
	 obj.currPage.value = pidx;
	 obj.method="post";
	submitForm('ack','laundry?method=createGridLaundryIssueData');
}
/*function showAck(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=closeAckJsp";
  obj.submit();
}*/
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

		int month1 = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month1 < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month1);
		} else {
			orderDateOnly.append(month1);
		}

		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>
<%
		Map<String,Object> map = new HashMap<String,Object>();

		Box box = HMSUtil.getBox(request);
		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		int deptId = 0;
		String message="";
		int issueMId = 0;
		//List<StoreIssueM> searchStoreIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		
		List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		if (request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
			pagedArray = (PagedArray) map.get("pagedArray");
		}
		if(map.get("message")!=null){
			message=(String)map.get("message");
		}
		if (map.get("issueMId")!=null){
			issueMId=Integer.parseInt(""+map.get("issueMId"));
		}
		if(session.getAttribute("deptId") != null){
			deptId = Integer.parseInt(""+session.getAttribute("deptId"));
		}

		//if(map.get("searchStoreIssueMList")!=null)
			//searchStoreIssueMList = (List) map.get("searchStoreIssueMList");

		if(map.get("storeInternalPendingIndentList")!=null){
			storeInternalPendingIndentList = (List<StoreInternalIndentM>) map.get("storeInternalPendingIndentList");
		}
		if(map.get("storeIssueMList")!=null){
			storeIssueMList = (List<StoreIssueM>) map.get("storeIssueMList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();

		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		String deptName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(session.getAttribute("deptName") != null){
			deptName = (String)session.getAttribute("deptName");
		}
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		if(map.get("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
			session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
		}
		else if(session.getAttribute("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		}
		if (map.get("departmentList")!=null)
		{
			departmentList = (ArrayList)map.get("departmentList");
		}
		int approvedById = 0;
		if(session.getAttribute("approvedById") != null)
		{
			approvedById = Integer.parseInt(""+session.getAttribute("approvedById"));
		}
		if(map.get("storeIssueTList") != null)
		{
			storeIssueTList = (List)map.get("storeIssueTList");
		}
	%>

<form name="ack" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Acknowledgment for Laundry Issue</h2>
</div>
<div class="clear"></div>
<input type="hidden" name="numOfRows" size="5" value="8">
<input 	type="hidden" name="pageCount" size="5" value="10">
<div class="Block">
<label>Indent Department</label>
<select	name="<%=ISSUE_DEPT%>" id="issueDept"	validate="Indent Department,metachar,no"	onchange="populateIndentNoAndDate(this.value,'ack')" tabindex=1>
	<option value="0">Select</option>
	<%
	for (MasDepartment masDepartment :departmentList) {
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(ISSUE_DEPT)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					%>
</select>
<label>Acknowledge Date</label>
<input type="text"	name="<%=ACK_DATE %>"	value="<%=box.get(ACK_DATE)==""?currentDate:box.get(ACK_DATE)%>"	class="date" readonly validate="Pick a date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.ack.<%=ACK_DATE %>,event)" />
<label>Acknowledge By</label>
<select name="<%=ACK_BY %>"	id="acknowledgedBy" validate="Acknowledgment By,metachar,no" tabindex=1>
<option value="0">Select</option>
	<%
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(ACK_BY)) %>><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
	<%

					}
				%>
</select>
<div class="clear"></div>
<label>Receipt Department </label>
<label>

<input type="text"	value="<%=deptName%>" class="readOnly" readonly="readonly" validate="deptName,metachar,no"/></label>
<label>Indent/Demand No </label>
<select id="issueNo" name="<%=ISSUE_NO%>"	  onchange="" tabindex=1>
	<option value="0">Select</option>
	<%
		if (box.getInt(ISSUE_NO)!=0)
		{
			for(StoreInternalIndentM storeInternalIndentM : storeInternalPendingIndentList)
				{
					if (box.getInt(ISSUE_DEPT)==storeInternalIndentM.getDepartment().getId())
					{
				%>
	<option value="<%=storeInternalIndentM.getId()%>"
			<%=HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.getString(ISSUE_NO)) %>><%=storeInternalIndentM.getDemandNo()%></option>
	<% }
				}
		}
		%>
</select>
<label>Indent Date</label>
<%
				for (StoreInternalIndentM storeInternalIndentM : storeInternalPendingIndentList) {
				%>
<label><%=HMSUtil.convertDateToStringWithoutTime(storeInternalIndentM.getDemandDate())%></label>
<input type="hidden" name="<%=ISSUE_DATE%>"	value="<%=storeInternalIndentM.getToStore().getId() %>"> <%	break;
					}
				%>
<input type="hidden" name="<%=CHANGED_BY %>"	value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="deptId" value="<%=deptId%>" validate="deptId,int,no"/>
<div class="clear"></div></div>
<input type="hidden" name="issueMId" value="<%=map.get("issueMId") == null?0:(Integer)map.get("issueMId")%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="ss" value="Submit" class="button" onClick="getIssue();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Accept"
	class="button" onClick="submitForm('ack','laundry?method=addAckLaundry');"
	accesskey="a" tabindex=1 /> <!--  <input type="button" name="close" id="closebutton" value="Close" class="button" onClick="showAck('ack')" accesskey="u" tabindex=1 />  -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<% if (pagedArray == null) { %>
<h4>Acknowledgment Details For Laundry Issue</h4>
<table width="100%" colspan="7" id="indentDetails" class="grid_header"	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>UOM</th>
			<!-- <th>Brand Name</th> -->
			<th>Demand Qty</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan='5'>No Data Found</td>
		</tr>
	</tbody>
</table>


<% } else { %>
<h4>Acknowledgment Details For Laundry Issue</h4>

<table width="90%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>UOM</th>
			<!-- <th>Brand Name</th> -->
			<th>Demand Qty</th>
		</tr>
	</thead>
	<tbody>
		<%
				    gridData = (HashMap[])pagedArray.getPagedArray();
					int iFirstRow = pagedArray.getFirstRowIdx();
				    for(int i=0;i<gridData.length;i++)
				    { %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=iFirstRow++%>" name="srno" class="readOnly"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" size="5"
				value="<%=gridData[i].get("pvms")%>" name="pvms" class="readOnly"
				readonly="readonly" /></td>
			<td width="40%"><input type="text" size="30"
				value="<%=gridData[i].get("nomenclature")%>" name="nomenclature"
				class="readOnly" readonly="readonly" /></td>
			<td width="5%"><input type="text" size="5"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				name="au" class="readOnly" readonly="readonly" /></td>
			<%--<td width="8%"> <input type="text"	size="" value="<%=gridData[i].get("brandname")%>" name="brandname" validate="Brand Name,string,no" readonly="readonly"/> </td> 
			<td width="12%"><input type="text" size="6"
				value="<%=gridData[i].get("batchNo")%>" name="batchNo"
				class="readOnly" readonly="readonly" validate="Batch No.,string,no" />
			</td>--%>
			<td width="10%"><input type="text" size="6"
				value="<%=gridData[i].get("qtyRequest")%>" name="qtyRequest"
				class="readOnly" readonly="readonly" validate="Demand Qty,float,no" />
			</td>
				<%-- <td width="10%"><input type="text" size="6"
				value="<%=gridData[i].get("qtyIssued")%>" name="qtyIssued"
				class="readOnly" readonly="readonly" validate="Issue Qty,num,no" />
			</td>
			--%>
			<%--
		    <td width="10%"><input type="text" size="12"
				value="<%=gridData[i].get("expiry_date")%>" name="expiry_date"
				class="readOnly" readonly="readonly" /> <td width="12%"> <input type="hidden"	value="<%=gridData[i].get("brand")%>" name="brand"  readonly="readonly"/> </td>
				--%>
				
			<input type="hidden" value="<%=gridData[i].get("issueId")%>"
				name="issueId" /> <input type="hidden"
				value="<%=gridData[i].get("itemId")%>" name="itemId" /></td>
				 
		</tr>
		<% } %>
	</tbody>
</table>


<div style="padding-left: 250px;">
<div style="float: left;"><%= pagedArray.showIndex()%></div>
<div style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>

<div class="clear"></div>


<% } %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>

<script language="Javascript">
	function populateIndentNoAndDate(val,formName)
	{
		obj = eval('document.'+formName+'.issueNo');
		obj.length = 1;
 		<%
 		for(StoreInternalIndentM storeInternalIndentM : storeInternalPendingIndentList)
		{
 		%>
 				if (val == <%=storeInternalIndentM.getDepartment().getId().toString()%>)
				{
				obj.length++;
				obj.options[obj.length-1].value="<%=storeInternalIndentM.getId()%>";
				obj.options[obj.length-1].text="<%=storeInternalIndentM.getDemandNo()%>";
				}
		<% } %>
	}
</script>
<%approvedByEmployeeList.clear();
departmentList.clear();
storeInternalPendingIndentList.clear();
storeIssueTList.clear();
storeIssueMList.clear();

%>