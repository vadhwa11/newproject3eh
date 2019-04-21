<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingRequisition.jsp  
 * Purpose of the JSP -  This is for Training details 
 * @author  Rajendra
 * Create Date: 7th Jan,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrTrainingRequisition"%>
<%@ page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasRank"%>



<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<MasEmployee> employeeList =new ArrayList<MasEmployee>();
	List<MasEmployee> gridEmployeeList =new ArrayList<MasEmployee>();
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasRank> gridRankList = new ArrayList<MasRank>();

	List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
	List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();
	
	List<HrMasTraining> contributingTrainingList = new ArrayList<HrMasTraining>();
	
	List<MasEmployee> userManagerList =new ArrayList<MasEmployee>();
	
	List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
	
	if(map.get("employeeList") !=null){
		employeeList = (List) map.get("employeeList");
	}
	
	if(map.get("gridEmployeeList") !=null){
		gridEmployeeList = (List)map.get("gridEmployeeList");
	}

	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}

	if (map.get("gridDepartmentList") != null) {
		gridDepartmentList = (List) map.get("gridDepartmentList");
	}

	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}

	if (map.get("gridRankList") != null) {
		gridRankList = (List) map.get("gridRankList");
	}

	if(map.get("trainingMasterList") !=null){
		trainingMasterList =(List) map.get("trainingMasterList");
	}
	if(map.get("gridTrainingMasterList") !=null){
		gridTrainingMasterList =(List) map.get("gridTrainingMasterList");
	}
		
	if (map.get("searchTrainingRequisitionList") != null) {
		searchTrainingRequisitionList = (List) map.get("searchTrainingRequisitionList");
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



<%@page import="jkt.hrms.masters.business.MasTraining"%>
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
		
 function showEmployeeInf(idvalue){
	<%
	for(MasEmployee masEmployee :employeeList){
		int id = masEmployee.getId();
	%>
	if(idvalue == <%=id%> ){
	<%
	int deptId = masEmployee.getDepartment().getId();
	int rankId = masEmployee.getRank().getId();
	
	for(MasDepartment masDepartment :departmentList){
		int departmentId = masDepartment.getId();
	%>	
	if(<%= deptId%> == <%= departmentId%>){
	document.getElementById('departmentId').value = '<%= masDepartment.getDepartmentName() %>'
	document.getElementById('departmentHiddenId').value = '<%= masDepartment.getId() %>'
	
	}
	<% } %>
	
	<%
	for(MasRank masRank :rankList){
		int designationId =masRank.getId();
		%>
	if(<%= rankId%> == <%= designationId%>){
	document.getElementById('rankId').value = '<%= masRank.getRankName()%>'
	document.getElementById('rankHiddenId').value = '<%= masRank.getId()%>'
	}
	<%	
	}
	%>
	
	}
	

<% } %>	
		
}		
		
	
	function userManagerList(empId){
	
		//var sel1 = document.getElementById("managerId");
		//removeAllOptions(sel1);
		//var sel = document.getElementById("managerId");
		//sel.options.add(new Option('Select', '0'));
		
		<%
		List<UserManager> managerList = new ArrayList<UserManager>();
		Set managerSet = new HashSet(); 
		for(MasEmployee masEmployee :employeeList){
		
		%>
		//if(empId == <masEmployee.getId()%> && empId!= "" ){
		<%
		//managerSet = masEmployee.getUserManager();
	//	managerList = new ArrayList(managerSet);
		//for(UserManager userManager: managerList){
		%>
		//	sel.options.add(new Option('<userManager.getManagers().getFirstName()%>' , '<userManager.getManagers().getId()%>',false,false));
		<%//} //End of User Manager For loop.%>
	
		//} <!-- end of If --> 
		
		<%
			
		} //End of Employee For loop. %>  
			
	}	<!-- end of function-->

	
	function validateTraining(idvalue){
		var sel1 = document.getElementById("contributingTrainingId");
		removeAllOptions(sel1);
		var sel = document.getElementById("contributingTrainingId");
		sel.options.add(new Option('Select', '0'));
	<%
		for (HrMasTraining hrMasTraining : trainingMasterList) {
	%>
		
		if(idvalue!=<%=hrMasTraining.getId()%>){
			sel.options.add(new Option('<%=hrMasTraining.getTrainingName()%>' , '<%=hrMasTraining.getId()%>'));
	}

	<%
		}
	%>
	}

	function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}	
	
	
	function check(methodName){
	
	var SDate = document.trainingRequisition.<%= TRAINING_REQUISITION_DATE%>.value;
	var EDate = document.trainingRequisition.<%= TRAINING_DATE %>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the Training Date is greater than or equal to the Requisition Date.");
		document.trainingRequisition.<%= TRAINING_DATE%>.focus();
		return false;
	}else{
		if(methodName =="add"){
			submitForm('trainingRequisition','training?method=addTrainingRequisition');
		}else if(methodName =="update"){
			submitForm('trainingRequisition','training?method=editTrainingRequisition');
		}
	}
}
		
			
	</script>

<div class="titleBg">
<h2>Training Requisition</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>
Employee</label> <select id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Employee,string,yes">
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
	%>

	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getEmployeeCode()+"-"+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>

	<%
		}
	%>
</select> <label>&nbsp;</label> <input type="button" name="search" value="Search"
	class="button"
	onclick="submitForm('search','training?method=searchTrainingRequisition')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%if (searchTrainingRequisitionList.size() == 0
			&& map.get("search") != null) {
%>
<h4><a href="training?method=showTrainingRequisitionJsp">Show
All Records</a></h4>

<%}%> <script type="text/javascript">
formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_ID%>"], [2,"<%= RANK_ID%>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= TRAINING_ID %>"], [5,"<%= CONTRIBUTING_TRAINING_ID%>"],[6,"<%= TRAINING_REQUISITION_DATE%>"], [7,"<%= TRAINING_DATE %>"], [8,"<%= REMARKS%>"], [9,"<%= TRAINING_REQUISITION_STATUS %>"], [10,"<%= CHANGED_BY%>"], [11,"<%= CHANGED_DATE %>"],[12,"<%= CHANGED_TIME %>"],[13,"<%=TO_BE_APPROVED%>"],[14,"<%=STATUS%>"] ];
	 statusTd = 14;
	</script></div>

<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="trainingRequisition" method="post" action=""><input
	type="hidden" name="title" value="Training Requisition"><input
	type="hidden" name="<%=JSP_NAME %>" value="hr_trainingRequisition"><label><span>*</span>
Employee</label> <select name="<%= EMPLOYEE_ID %>"
	validate="Employee,string,yes"
	onchange="showEmployeeInf(this.value);userManagerList(this.value);">
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployee : employeeList) {
			String middleName = "";
			String lastName = "";
			if(masEmployee.getMiddleName() != null){
				middleName = masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName() != null){
				lastName = masEmployee.getLastName();
			}
			
		%>

	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getEmployeeCode()+"-"+ masEmployee.getFirstName()%></option>

	<%
		}
	%>
</select> <label><span>*</span> Designation</label> <input type="text"
	id="rankId" name="<%= RANK_ID %>" class="readOnly" readonly="readonly"
	tabindex=1 /> <input type="hidden" id="rankHiddenId"
	name="<%= RANK_HIDDEN_ID %>" readonly="readonly" tabindex=1 /> <script>
	document.trainingRequisition.<%= EMPLOYEE_ID%>.focus();
</script> <label> Department</label> <input type="text" id="departmentId"
	name="<%= DEPARTMENT_ID %>" class="readOnly" readonly="readonly"
	tabindex=1 /> <input type="hidden" id="departmentHiddenId"
	name="<%= DEPARTMENT_HIDDEN_ID %>" readonly="readonly" tabindex=1 />


<div class="clear"></div>

<label><span>*</span>To Be Approved By</label> <select
	name="<%=TO_BE_APPROVED%>" id="managerId"
	validate="To Be Approved By,string,yes">
	<option value="">Select</option>
	<%
		for(MasEmployee  masEmployee:employeeList){	%>
	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getEmployeeCode()+"-"+ masEmployee.getFirstName()%></option>

	<%	} %>
</select> <label><span>*</span> Training</label> <select id="trainingId"
	name="<%=TRAINING_ID%>" validate="Training,string,yes" tabindex=1
	onchange="validateTraining(this.value);"
	onkeyUp="validateTraining(this.value);">
	<option value="">Select</option>
	<%
	for (HrMasTraining hrMasTraining : trainingMasterList) {
%>

	<option value="<%=hrMasTraining.getId()%>"><%=hrMasTraining.getTrainingName()%></option>

	<%
	}
%>
</select> <label> Contributing Training</label> <select
	id="contributingTrainingId" name="<%= CONTRIBUTING_TRAINING_ID %>"
	validate="Contributing Training,string,no" tabindex=1>
	<option value="">Select</option>
	<%
	for (HrMasTraining hrMasTraining : trainingMasterList) {
%>

	<option value="<%=hrMasTraining.getId ()%>"><%=hrMasTraining.getTrainingName()%></option>

	<%
	}
%>
</select>
<div class="clear"></div>

<label><span>*</span> Requisition Date</label> <input type="input"
	name="<%= TRAINING_REQUISITION_DATE%>" value=<%= date%>
	readonly="readonly" validate="Requisition Date,string,yes" class="date"
	MAXLENGTH="15" / tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',document.trainingRequisition.<%=TRAINING_REQUISITION_DATE%>,event)" />

<label><span>*</span> Expected Training Date</label> <input type="text"
	id="fromDateId" name="<%= TRAINING_DATE%>" value="" readonly="readonly"
	validate="Training Date,string,yes" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingRequisition.<%=TRAINING_DATE%>,event);" />

<div class="clear"></div>
<label>Remarks</label> <input type="text" name="<%= REMARKS %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="100" tabindex=1 />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button" onClick="check('add');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button" onClick="check('update');"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('trainingRequisition','training?method=deleteTrainingRequisition&flag='+this.value)"
	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />


<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=COMMON_ID%>" value="" />

<div class="clear"></div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= EMPLOYEE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Designation"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= RANK_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= DEPARTMENT_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Training"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= TRAINING_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Contributing Training"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "<%= CONTRIBUTING_TRAINING_ID%>";

data_header[5] = new Array;
data_header[5][0] = "Requistion Date"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "<%= TRAINING_REQUISITION_DATE%>";

data_header[6] = new Array;
data_header[6][0] = "Training Date"
data_header[6][1] = "data";
data_header[6][2] = "";
data_header[6][3] = "<%= TRAINING_DATE%>";

data_header[7] = new Array;
data_header[7][0] = "Remarks"
data_header[7][1] = "data";
data_header[7][2] = "";
data_header[7][3] = "<%= REMARKS%>";

data_header[8] = new Array;
data_header[8][0] = "Training Statuts"
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "<%= TRAINING_REQUISITION_STATUS%>";


data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_BY %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_DATE %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "";
data_header[11][3] = "<%=CHANGED_TIME %>";

data_header[12] = new Array;
data_header[12][0] = "Approved By"
data_header[12][1] = "data";
data_header[12][2] = "";
data_header[12][3] = "<%=TO_BE_APPROVED %>";

data_header[13] = new Array;
data_header[13][0] = "Status"
data_header[13][1] = "data";
data_header[13][2] = "";
data_header[13][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchTrainingRequisitionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrTrainingRequisition  hrTrainingRequisition = (HrTrainingRequisition)itr.next(); 
            

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrTrainingRequisition.getId()%>

<% if(hrTrainingRequisition.getEmployee() !=null){%>
<%
     Iterator itrGridEmployeeList=gridEmployeeList.iterator();
		 while(itrGridEmployeeList.hasNext())
            {try{
             MasEmployee masEmployeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
			 if(hrTrainingRequisition.getEmployee().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("y")){
			%>
			data_arr[<%= counter%>][1] = "<%=masEmployeeGrid.getEmployeeCode()+"-"+ masEmployeeGrid.getFirstName()%>"
			<%}else if(hrTrainingRequisition.getEmployee().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masEmployeeGrid.getFirstName() %>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][1] ="-";<%}%>

<% if(hrTrainingRequisition.getDesignation() !=null){%>
<%
		Iterator itrGridRankList=gridRankList.iterator();
		 while(itrGridRankList.hasNext())
            {try{
             MasRank masRankGrid = (MasRank)itrGridRankList.next(); 
			 if(hrTrainingRequisition.getDesignation().getId().equals(masRankGrid.getId()) && masRankGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=masRankGrid.getRankName()%>"
			<%}else if(hrTrainingRequisition.getDesignation().getId().equals(masRankGrid.getId()) && masRankGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masRankGrid.getRankName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][2] ="-";<%}%>

<% if(hrTrainingRequisition.getDepartment() !=null){%>
<%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {try{
             MasDepartment masDepartmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
              if(hrTrainingRequisition.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=masDepartmentGrid.getDepartmentName()%>"
			<%}else if(hrTrainingRequisition.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDepartmentGrid.getDepartmentName()%>";
				
			 <%} } catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][3] ="-";<%}%>



<% if(hrTrainingRequisition.getTraining() !=null){%>
<%
      Iterator itrGridTrainingList=gridTrainingMasterList.iterator();
		 while(itrGridTrainingList.hasNext())
            {try{
             HrMasTraining hrMasTrainingGrid = (HrMasTraining)itrGridTrainingList.next(); 
			 if(hrTrainingRequisition.getTraining().getId().equals(hrMasTrainingGrid.getId()) && hrMasTrainingGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=hrMasTrainingGrid.getTrainingName()%>"
			<%}else if(hrTrainingRequisition.getTraining().getId().equals(hrMasTrainingGrid.getId()) && hrMasTrainingGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=hrMasTrainingGrid.getTrainingName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][4] ="-";<%}%>




<% if(hrTrainingRequisition.getContributingTraining() !=null && hrTrainingRequisition.getContributingTraining().getId() !=0){%>
<%
		Iterator itrGridTrainingList=gridTrainingMasterList.iterator();
		 while(itrGridTrainingList.hasNext())
            {try{
             HrMasTraining hrMasTrainingGrid = (HrMasTraining)itrGridTrainingList.next(); 
			 if(hrTrainingRequisition.getContributingTraining().getId().equals(hrMasTrainingGrid.getId()) && hrMasTrainingGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=hrMasTrainingGrid.getTrainingName()%>"
			<%}else if(hrTrainingRequisition.getContributingTraining().getId().equals(hrMasTrainingGrid.getId()) && hrMasTrainingGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=hrMasTrainingGrid.getTrainingName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][5] ="-";<%}%>


data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingRequisition.getRequisitionDate())%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingRequisition.getTrainingDate())%>"
data_arr[<%= counter%>][8] = "<%= hrTrainingRequisition.getRemarks()%>"    
data_arr[<%= counter%>][9] = "<%= hrTrainingRequisition.getTrainingRequisitionStatus()%>"   
data_arr[<%= counter%>][10] = "<%= hrTrainingRequisition.getLastChgBy() %>"
data_arr[<%= counter%>][11] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingRequisition.getLastChgDate()) %>"
data_arr[<%= counter%>][12] = "<%= hrTrainingRequisition.getLastChgTime() %>"

<% if(hrTrainingRequisition.getToBeApproved() !=null){%>
<%
     Iterator itrGridEmployeeList=gridEmployeeList.iterator();
		 while(itrGridEmployeeList.hasNext())
            {try{
             MasEmployee masEmployeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
			 if(hrTrainingRequisition.getToBeApproved().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("y")){
			%>
			data_arr[<%= counter%>][13] = "<%=masEmployeeGrid.getEmployeeCode()+"-"+ masEmployeeGrid.getFirstName()%>"
			<%}else if(hrTrainingRequisition.getToBeApproved().getId().equals(masEmployeeGrid.getId()) && masEmployeeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][13] = "<font id='error'>*</font>Parent InActivated--<%=masEmployeeGrid.getFirstName() %>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][13] ="-";<%}%>



<% if(hrTrainingRequisition.getStatus().equals("y")){ %>
data_arr[<%= counter%>][14] = "Active"
<%}else{%>
data_arr[<%= counter%>][14] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "trainingRequisition"

nonEditable = "";
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
