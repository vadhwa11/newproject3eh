<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingIntimation.jsp  
 * Purpose of the JSP -  This is for Training Intimation 
 * @author  Rajendra
 * Create Date: 27th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrTrainingSchedule"%>
<%@ page import="jkt.hrms.masters.business.MasLocation"%>
<%@ page import="jkt.hms.masters.business.MasGrade"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	session.setAttribute("searchMap", map);
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<MasLocation> locationList= new ArrayList<MasLocation>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasGrade> gradeList =new ArrayList<MasGrade>();
	List<MasEmployee> employeeList =new ArrayList<MasEmployee>();
	List<MasEmployee> employeeTrainingList =new ArrayList<MasEmployee>();
	if(map.get("locationList") !=null){
		locationList =(List)map.get("locationList");
	}
	
	if(map.get("departmentList") !=null){
		departmentList =(List)map.get("departmentList");
	}
	if(map.get("gradeList") !=null){
		gradeList =(List)map.get("gradeList");
	}
	if(map.get("employeeList") !=null){
		employeeList =(List)map.get("employeeList");
	}
		
	List<HrTrainingSchedule> searchTrainingScheduleList = new ArrayList<HrTrainingSchedule>();
	
	if (map.get("searchTrainingScheduleList") != null) {
		searchTrainingScheduleList = (List) map.get("searchTrainingScheduleList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>



<%@page import="jkt.hms.masters.business.MasDepartment"%>
<div class="titleBg">
<h2>Scheduled Training</h2>
</div>

<div class="clear"></div>

<form name="searchEmployee" method="post">
<div class="block">
<div class="clear"></div>
<div class="division"></div>
<h4>Search</h4>
<div class="clear"></div>

<%if(searchTrainingScheduleList.size()!=0){ %>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<th>Id</th>
		<th>Training</th>
		<th>Instructor</th>
		<th>Training Start Date</th>
		<th>Training End Date</th>
		<th>Training Time</th>
		<th>Training Duration</th>
		<th>Addres</th>
	</tr>
	<tbody>
		<%
 			int i = 0;
			String klass = "";
 			for(HrTrainingSchedule trainingSchedule : searchTrainingScheduleList ){
 			if(i%2 == 0)
 			{
 				klass= "even";
 			}
 			else
 			{
 				klass="odd";
 			}
 			String status = "";
 			 			
 		%>

		<tr class="<%=klass%>">
			<td><input name="rb" class="radioCheck" id="rb<%=i%>"
				type="radio" value='<%=trainingSchedule.getId()%>' /></td>
			<td><%=trainingSchedule.getTraining().getTrainingName()%></td>
			<td><%=trainingSchedule.getInstructor().getInstructorName()%></td>
			<td><%=trainingSchedule.getTrainingStartDate()%></td>
			<td><%=trainingSchedule.getTrainingEndDate()%></td>
			<td><%=trainingSchedule.getTrainingTime()%></td>
			<td><%=trainingSchedule.getDuration()%></td>
			<td><%=trainingSchedule.getAddress()%></td>
		</tr>
		<script>
 			document.getElementById('rb0').checked = 'checked';
 		</script>
 		<%
 		i++;
 			}
 		%>
 		
	
	
	</tbody>
</table>
<%}
	else{
	%>
<h4>No Training Schedule Are Present</h4>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>To All Employee</label> <input type="checkbox" id="toAllEmp"
	name="<%=TO_ALL_EMPLOYEE %>" value="y" onclick="" class="radioCheck"
	validate="All Employee,String,no" onChange="disField(this.value)" />
<div class="clear"></div>

<div id="fields"><label>Location</label> <select id="locationId"
	name=<%=LOCATION_ID %> validate="Location,string,no">
	<option value="0">Select</option>

	<%
	           		if(locationList != null){ 	
	           			for (Iterator iter = locationList.iterator(); iter.hasNext();) {
	           				MasLocation masLocation = (MasLocation) iter.next();
	           %>
	<option value="<%=masLocation.getId() %>"><%=masLocation.getLocationName() %></option>
	<%		
	          			}
	          		 } 
	          %>
</select> <label>Department</label> <select id="departmentId"
	name=<%=DEPARTMENT_ID %> validate="Department,string,no">
	<option value="0">Select</option>

	<%
	           		if(departmentList != null){ 	
	           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
	           				MasDepartment masDepartment = (MasDepartment) iter.next();
	           %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
	          			}
	          		 } 
	          %>
</select> <label>Employee</label> <select id="employeeId" name=<%=EMPLOYEE_ID %>
	validate="Employee,string,no">
	<option value="0">Select</option>

	<%
	           		if(employeeList != null){ 	
	           			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
	           				MasEmployee masEmployee = (MasEmployee) iter.next();
	           %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() %></option>
	<%		
	          			}
	          		 } 
	          %>
</select></div>

<div class="clear"></div>
<label>&nbsp;</label> <label>&nbsp;</label> <input type="button"
	name="Search" value="Search" class="button" onclick="validateAndSub();"
	tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="buttonHighlight" onclick="resetForm();"
	accesskey="r" />
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<!---Search Ends--->

<!-- Send Intimation Start -->
<div class="titleBg">
<h2>Training Intimation</h2>
</div>
<div class="clear"></div>
<div id="update">
<form name="trainingIntimation" method="post">
<%
	if(map.get("employeeTrainingList") !=null){
		employeeTrainingList =(List)map.get("employeeTrainingList");
	}
	int  counter=0;
	%>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%if (employeeTrainingList != null && employeeTrainingList.size() > 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>Employee Id</th>
		<th>Employee Code</th>
		<th>Employee Name</th>
		<th>Designation</th>
		<th>Department</th>
		<th>Location</th>
		<th>Email Id</th>
	</tr>

	<tbody id="tableData">
		<%
		String klass = "even";
			
	 	for(MasEmployee masEmployee : employeeTrainingList){
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
		<tr class=<%= klass%> id="<%=counter%>">
			<td><input type="checkbox" name=<%=id %>
				value="<%=masEmployee.getId()%>" onClick="unCheck(this)"
				class="radioCheck" /></td>
			<td><%=masEmployee.getId()%></td>
			<td><%=masEmployee.getEmployeeCode()%></td>
			<td><%=masEmployee.getFirstName()%></td>
			<td><%=masEmployee.getRank().getRankName()%></td>
			<td><%=masEmployee.getDepartment().getDepartmentName()%></td>
			<td><%=masEmployee.getLocationId()%></td>
			<td><%=masEmployee.getEmail()%></td>
		</tr>


		<%
	  	}
	  	%>

	</tbody>
</table>
<script>
	 	var pager = new Pager('tableData',10); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
 	</script>

<div class="clear"></div>
<label>&nbsp;</label>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="<%= EMPLOYEE_ID%>" value="">
<div class="clear"></div>
<label> Mail Subject </label> <input name=<%=MAIL_SUBJECT%> value=""
	type="text" validate="Mail Subject,alphaspace,yes" maxlength="50" />


<div class="clear"></div>
<label> Mail Text </label> <textarea name="<%=MAIL_BODY%>"
	validate="Mail Text,alphaspace,yes" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="2000" class="medium"></textarea>
<div class="clear"></div>
<div id="messagebar"></div>
<div class="clear"></div>
<input type="button" name="mail" value="Broadcast" class="buttonBig"
	onClick="submitForm('trainingIntimation','training?method=broadcastMail&listSize=<%=counter%>','chkCheckBoxes')" />
<div class="clear"></div>


<div class="bottom">
<div class="division"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
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
<%if (employeeTrainingList.size() == 0	&& map.get("search") != null) {
	%>
<h4><a href="training?method=searchEmployeeList">Show All
Records</a></h4>
<%}}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>


<!-- Send Intimation End -->

<script>

	function validateAndSub()
	{
	if(document.getElementById('toAllEmp').checked ==false){
	if(document.searchEmployee.<%=LOCATION_ID%>.value=="0"
	&& document.searchEmployee.<%=DEPARTMENT_ID%>.value=="0"
	&& document.searchEmployee.<%=EMPLOYEE_ID%>.value=="0")
	{
	alert("Please select Any Search Criteria");
	return false;
	}else{
		submitForm('searchEmployee','training?method=searchEmployeeList');
	}
	}else{	
		submitForm('searchEmployee','training?method=searchEmployeeList');
	}
	}


	function resetForm()
	{
		document.searchEmployee.<%=LOCATION_ID%>.value = '';
		document.searchEmployee.<%=DEPARTMENT_ID%>.value = '';
		document.searchEmployee.<%=EMPLOYEE_ID%>.value = '';
	}
	
	function disField(){
		if(document.getElementById('toAllEmp').checked == true)
		{
		document.getElementById('fields').style.display = 'none';
		}
		else
		{
		document.getElementById('fields').style.display = 'block';
		}
	}
	
	
	function checkAll()
	{
	var no = <%=counter%>;
	
	for(i=0;i<no;i++)
	{
	var obj = "document.trainingIntimation." + "id" +i;
	obj=eval(obj);
	if(obj.disabled==true)
	{
	}
	else
	{
	if(document.trainingIntimation.allIds.checked==true)
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
	document.trainingIntimation.allIds.checked=false;
	}
	}
	
	
 	function checkAndSubmit()
 	{
 	url='';
 	for(i = 0 ;i<<%=searchTrainingScheduleList.size()%>;i++)
 	{
 		radioButton = document.getElementById('rb'+i);
 		
 		if(radioButton.checked == true)
 		{
 		 url = '/hms/hrms/resume?method=changeAssignedTo&requestId='+ radioButton.value;
 		}
 	}
 	if(url == '') 
 		{
 		alert('Please select a manpower request');
 		}
 		else
 		{
 		submitForm('scheduledTraining',url,'changeAssignedTo');
 		}
 	}
 	 	
 </script>

