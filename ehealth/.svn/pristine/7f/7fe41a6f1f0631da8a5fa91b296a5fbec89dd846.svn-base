<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingApproval.jsp
 * Purpose of the JSP -  This is for Training details
 * @author  Rajendra
 * Create Date: 15th Jan,2009
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

	List<HrMasTrainingStatus> trainingStatusList =new ArrayList<HrMasTrainingStatus>();

	List<MasEmployee> employeeList =new ArrayList<MasEmployee>();

	List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();

	if(map.get("trainingStatusList") !=null){
		trainingStatusList = (List) map.get("trainingStatusList");
	}

	if (map.get("searchTrainingRequisitionList") != null) {
		searchTrainingRequisitionList = (List) map.get("searchTrainingRequisitionList");
	}
	if(map.get("employeeList") !=null){
		employeeList =(List)map.get("employeeList");
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
<h2>Training Requisition Approval</h2>
</div>
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
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>Training Id</th>
		<th>Employee Name</th>
		<th>Designation</th>
		<th>Department</th>
		<th>Requisition Date</th>
		<th>Expected Training Date</th>
		<th>Training</th>
		<th>Contributing Training</th>
		<th>Changed By</th>
		<th>Requisition Status</th>
	</tr>



	<%
		String klass = "even";

		int currentLevel =0;
	 	for(HrTrainingRequisition hrTrainingRequisition : searchTrainingRequisitionList){
	 		String id = "";
	 		if(hrTrainingRequisition.getHrTrainingApprovalStatus() !=null){
	 		 	currentLevel = hrTrainingRequisition.getHrTrainingApprovalStatus().getCurrentLevel();
	 		}
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


		<tr class=<%= klass%> id="<%=counter%>" >
	  			<td><input type="checkbox" name=<%=id %> value="<%=hrTrainingRequisition.getId()%>" onClick="unCheck(this)" class="radioCheck" /></td>
	  			<td><%=hrTrainingRequisition.getEmployee().getFirstName()+" "+hrTrainingRequisition.getEmployee().getMiddleName()+" "+hrTrainingRequisition.getEmployee().getLastName()%></td>
	  			<td><%=hrTrainingRequisition.getDesignation().getRankName()%></td>
	  			<td><%=hrTrainingRequisition.getDepartment().getDepartmentName()%></td>
	  			<td><%=hrTrainingRequisition.getRequisitionDate()%></td>
	  			<td><%=hrTrainingRequisition.getTrainingDate()%></td>
	  			<td><%=hrTrainingRequisition.getTraining().getTrainingName()%></td>
	  			<% if(hrTrainingRequisition.getContributingTraining().getId() != 0){ %>
	  			<td><%=hrTrainingRequisition.getContributingTraining().getTrainingName()%></td>
	  			<%}else{%>
	  			<td>-</td>
	  			<%} %>
	  			<td><%=hrTrainingRequisition.getHrTrainingApprovalStatus().getEmployee().getFirstName()+" "+hrTrainingRequisition.getHrTrainingApprovalStatus().getEmployee().getMiddleName()+" "+hrTrainingRequisition.getHrTrainingApprovalStatus().getEmployee().getLastName()%></td>
	  			<td><%=hrTrainingRequisition.getHrTrainingApprovalStatus().getTrainingStatus().getTrainingStatusDescription()%></td>
	  		</tr>

	<%
	  	}
	  	%>
</tbody>
</table>
<script>
	  	intializeHover('searchresulttable', 'tr', ' tableover');
	 	var pager = new Pager('tableData',5);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
<div class="clear"></div>
<label>&nbsp;</label>
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><input type="hidden"
	name="<%= TRAINING_REQUISITION_ID%>" value=""><label><span>*</span>
Status</label> <select name="<%= TRAINING_STATUS_ID%>" value=""
	validate="Request Status,string,yes">
	<option value="">Select</option>
	<% for(HrMasTrainingStatus hrMasTrainingStatus : trainingStatusList){%>
	<option value="<%=hrMasTrainingStatus.getId()%>"><%= hrMasTrainingStatus.getTrainingStatusDescription()%></option>
	<%} %>
</select> <%if(!(currentLevel >= 1)) {%> <label>To Be Approved By</label> <select
	name="<%=TO_BE_APPROVED%>" validate="To Be Approved By,string,no">
	<option value="">Select</option>
	<%
		for(UserManager  masManager:users.getEmployee().getUserManager()){	%>
	<option value="<%=masManager.getManagers().getId()%>"><%=masManager.getManagers().getFirstName()+" "+masManager.getManagers().getLastName()+ "--"+masManager.getManagers().getEmployeeCode() %></option>

	<%} %>
</select> <%} %> <label> Date</label> <input type="input" name="<%= STATUS_DATE%>"
	value="<%=date%>" readonly="readonly" validate="From Date,string,yes"
	class="date" MAXLENGTH="15" / tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingStatus.<%=STATUS_DATE%>,event)" />
<div class="clear"></div>
<label>Reason</label> <input type="text" name="<%= STATUS_REASON%>"
	value="" validate="Status Reason,string,no" class="large"
	MAXLENGTH="100" tabindex=1 />

<div class="clear"></div></div>
<div class="clear"></div>

<div class="division"></div>
<input type="button" class=button value="Go" onClick="updatestatus()" />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="division"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <%
	 }
	else{
	%> <label>No Record Exists</label>
<div class="clear"></div>
<%if (searchTrainingRequisitionList.size() == 0	&& map.get("search") != null) {
	%>
<h4><a href="training?method=showTrainingApprovalJsp">Show All
Records</a></h4>
<%}}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>


<script>



	function checkAll()
	{
	var no = <%=counter%>;

	for(i=0;i<no;i++)
	{
	var obj = "document.trainingStatus." + "id" +i;
	obj=eval(obj);
	if(obj.disabled==true)
	{
	}
	else
	{
	if(document.trainingStatus.allIds.checked==true)
	{
	obj.checked=true;
	}
	else
	{
	obj.checked=false;
	}
	}
	}
	}



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



	function chkCheckBoxesForAuthorization()
		{

			inps = document.getElementsByTagName('input');
			flag=false;
			for(i=0;i<inps.length;i++)
			{
	 			if(inps[i].type == 'checkbox')
	  			{
					if(inps[i].checked)
					{
	       	            flag=true;
		 			     break;
					}
				}
			}
			if(!flag)
			{
				alert("Please select one of the candidate.");
				return false;
			}
			return true;
		}

	function updatestatus()
	{
	val = chkCheckBoxesForAuthorization();

	var SDate = document.trainingStatus.<%= STATUS_DATE%>.value;
	var EDate =document.trainingStatus.<%= CHANGED_DATE%>.value;

	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
    var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate < endDate)
	{
		alert("Please ensure that the Training Status Date is greater than or equal to the Todate.");
		document.trainingStatus.<%= STATUS_DATE%>.focus();
		return false;
	}else{
		if(val==true)
		submitForm('trainingStatus','training?method=updateRequisitionStatus');
		}
	}


</script>
