<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingApproval.jsp  
 * Purpose of the JSP -  This is for Training details 
 * @author  Rajendra
 * Create Date: 30th Jan,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<%@ page import="jkt.hrms.masters.business.HrTrainingRequisition"%>
<%@ page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hrms.masters.business.HrMasTrainingStatus"%>
<%@page import="jkt.hms.masters.business.Users"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		session.setAttribute("map", map);
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	
	List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
	
	
	if (map.get("searchTrainingRequisitionList") != null) {
		searchTrainingRequisitionList = (List) map.get("searchTrainingRequisitionList");
	}
		String userName = "";
	String message=null;
	Users  users=null;
	int employeeId = 0;
	
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
		out.println(message);
	}
				
		
	if(session.getAttribute("users") != null){
		users = (Users)session.getAttribute("users");
		MasEmployee masEmployee = users.getEmployee();
		employeeId = masEmployee.getId();
	
	}
%>

<%@page import="jkt.hrms.masters.business.UserManager"%>
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	
function check(){
	var SDate = document.requisitionApproval.<%= FROM_DATE%>.value;
	var EDate = document.requisitionApproval.<%= TO_DATE %>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
		// document.calldate.next_day.focus();
		return false;
	}else{
		submitForm('requisitionApproval','training?method=showTrainingApprovalStatus');
	}
}
</script>
<div class="titleBg">
<h2>Training Approval Status</h2>
</div>
<div class="clear"></div>
<form name="requisitionApproval" method="post">
<div class="Block">
<div class="clear"></div>

<label class="auto">From Date </label> <input type="text"
	name="<%= FROM_DATE%>" value="" readonly="readonly"
	validate="From Date,string,yes" class="textbox_size20" MAXLENGTH="15"
	/ tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.requisitionApproval.<%=FROM_DATE%>,event)" />

<label class="auto">To Date </label> <input type="text"
	name="<%= TO_DATE%>" value="" readonly="readonly"
	validate="To Date,string,yes" class="textbox_size20" MAXLENGTH="15"
	/ tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.requisitionApproval.<%=TO_DATE%>,event)" />

<input name="save" type="button" class="button" value="Search"
	onClick="check()" /> <input name="save" type="button" class="button"
	value="Back" onClick="javascript:history.back()" />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="division"></div>
<div class="clear"></div>

<div id="update">
<form name="trainingStatus" method="post">
<% int  counter=0;%>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%if (searchTrainingRequisitionList != null && searchTrainingRequisitionList.size() > 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>Training Id</th>
		<th>Employee Name</th>
		<th>Designation</th>
		<th>Department</th>
		<th>Requisition Date</th>
		<th>Training Date</th>
		<th>Training</th>
		<th>Contributing Training</th>
		<th>Changed By</th>
		<th>Requisition Status</th>
	</tr>



	<%
		String klass = "even";
		
	
	 	for(HrTrainingRequisition hrTrainingRequisition : searchTrainingRequisitionList){
	 		String id = "";
	 		id = "id" + counter;
	 		counter++;
	 		
	 		if(counter%2==0){
	 			klass = "even"; 
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}
	 		
	%>
	<tbody id="tableData">


		<tr class=<%= klass%> id="<%=counter%>">
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getId()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getEmployee().getFirstName()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getDesignation().getRankName()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getDepartment().getDepartmentName()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getRequisitionDate()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getTrainingDate()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getTraining().getTrainingName()%></a></td>
			<% if(hrTrainingRequisition.getContributingTraining().getId() != 0){ %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getContributingTraining().getTrainingName()%></a></td>
			<%}else{%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"></a></td>
			<%} %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getHrTrainingApprovalStatus().getEmployee().getFirstName()%></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'trainingStatus')"
				rel="balloon<%=counter%>"><%=hrTrainingRequisition.getHrTrainingApprovalStatus().getTrainingStatus().getTrainingStatusDescription()%></a></td>
		</tr>

	</tbody>
	<%
	  	}
	  	%>
</table>
<script>
	  	intializeHover('searchresulttable', 'tr', ' tableover');
	  </script> <script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
	  </script>
	<div class="clear"></div>
	<label>&nbsp;</label>
	<%		
	 }
	else{
	%>
	<h4><span>No Record Exists</span></h4>
	<div class="clear"></div>
	<%if (searchTrainingRequisitionList.size() == 0	&& map.get("search") != null) {
	%>
	<h4><a href="training?method=showTrainingStatusJsp">Show All Records</a></h4>
	<%}}%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>


<script>

	
function unCheck(obj)
{
if(obj.checked==false)
{
document.trainingStatus.allIds.checked=false;
}
}

function checkAndSubmit()
{
	val = dateCompare1('requisitionApproval');
	alert(val);
	if(val == true){
	submitForm('requisitionApproval','recruitment?method=showRequestApprovalScreen');
	}
}
function changeClass(obj)
{
	obj.getAttribute('class') += 'tableover';
}
</script>
