
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.util.RequisitionHistoryComparator"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MasVacancyReason"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hrms.masters.business.MasEmployeeType"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hrms.masters.business.MasExperience"%>
<%@page import="jkt.hrms.masters.business.MasInfrastructureRequerment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.MasLocation"%>
<%@page import="jkt.hrms.masters.business.UserManager"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.ResourceRequisition"%>


<%
				Map<String, Object> map = new HashMap<String, Object>();

				Map<String,Object> mapEmployee = new HashMap<String,Object>();
				if(request.getAttribute("map") != null){
				mapEmployee = (Map<String,Object>) request.getAttribute("map");
				}
				List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
				List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
				List<MasLocation> masLocationList = new ArrayList<MasLocation>();
				List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
				List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
				List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
				List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
				List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();
				List<ResourceRequisition> resourceRequisitionList = new ArrayList<ResourceRequisition>();
				List<UserManager> userManagerList = new ArrayList<UserManager>();
				ResourceRequisition resourceRequisition = null; 
				
				Users users=null;
				String message=null;
				int requisitionId = 0;
				int employeeId = 0;
				int hospitalId = 0;
				
	/* for now userFirstName is hard coded But it will come from users object actually */
				String userFirstName="rakesh";
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masEmployeeTypeList")!= null){
					masEmployeeTypeList = (List)map.get("masEmployeeTypeList");
				}
				if(map.get("masDepartmentList")!= null){
					masDepartmentList = (List)map.get("masDepartmentList");
				}
				if(map.get("masLocationList")!= null){
					masLocationList = (List)map.get("masLocationList");
				}
				if(map.get("masVacancyReasonList")!= null){
					masVacancyReasonList = (List)map.get("masVacancyReasonList");
				}
				if(map.get("masQualificationList")!= null){
					masQualificationList = (List)map.get("masQualificationList");
				}
				if(map.get("masManagerList")!= null){
					masManagerList = (List)map.get("masManagerList");
				}
				
				
				if(map.get("masExperienceList")!= null){
					masExperienceList = (List)map.get("masExperienceList");
				}
				if(map.get("masInfrastructureRequirmentList")!= null){
					masInfrastructureRequirmentList = (List)map.get("masInfrastructureRequirmentList");
				}
				if(map.get("resourceRequisitionList")!= null){
					resourceRequisitionList = (List)map.get("resourceRequisitionList");
					resourceRequisition = resourceRequisitionList.get(0);
					requisitionId=resourceRequisition.getId();
				}
				if(map.get("hospitalId")!= null){
					hospitalId = (Integer)map.get("hospitalId");
				}
				
				
				//String requisitionDate = HMSUtil.changeDateToddMMyyyy(resourceRequisition.getRequisitionDate());
				
				if(map.get("message") != null){
					   message = (String)map.get("message");
					   //out.println(message);
				}
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				//if(map.get("users")!= null){
					//users = (Users)map.get("users");
					//userFirstName = users.getEmployee().getFirstName();
				//}

				MasRank intermediateApproverDesignation = null;
				if(map.get("intermediateApproverDesignation")!= null){
					intermediateApproverDesignation = (MasRank)map.get("intermediateApproverDesignation");
					
				}
				MasRank finalApproverDesignation = null;
				if(map.get("finalApproverDesignation")!= null){
					finalApproverDesignation = (MasRank)map.get("finalApproverDesignation");
					
				}
				
				String lastName = "";
				String empCode = ""; 
				if(session.getAttribute("users") != null){
					users = (Users)session.getAttribute("users");
					MasEmployee masEmployee = users.getEmployee();
					employeeId = masEmployee.getId();
					userFirstName = masEmployee.getFirstName();
					lastName = masEmployee.getLastName();
					empCode = masEmployee.getEmployeeCode();
				}
				if(users!= null){
				userManagerList = new ArrayList<UserManager>(users.getEmployee().getUserManager());
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				

%>


<%@page
	import="jkt.hrms.recruitment.masters.business.HrRequisitionHistory"%>
<%@page import="jkt.hrms.util.RequisitionHistoryComparator"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<div class="titleBg">
<h2>Man Power Requisition</h2>
</div>
<div class="clear"></div>

<form name="manPowerRequisition" method="post" action="">

<div class="Block">
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>


<label>Name of Initiator </label> <input name="<%=INITIATOR_NAME %>"
	id="<%=INITIATOR_NAME %>" value="<%= userFirstName + " " +lastName %>"
	type="text" class="readOnly" readonly="readonly" /> <input
	type="hidden" name="<%=INITIATOR_ID %>" id="<%=INITIATOR_ID %>"
	value="<%= employeeId%>" type="text" class="readOnly"
	readonly="readonly" /> <script type="text/javascript">
  <% if(resourceRequisitionList.size()>0){   %> 
          		  document.manPowerRequisition.<%=INITIATOR_NAME%>.value='<%=resourceRequisition.getInitiator().getFirstName() + " "+ resourceRequisition.getInitiator().getLastName()%>';
 <% } %>
</script> <label>Date </label> <input name="<%=REQUISITION_DATE %>"
	id="<%=REQUISITION_DATE %>" type="text" class="readOnly"
	value="<%=currentDate %>" readonly="readonly" /> <script
	type="text/javascript">
  <% if(resourceRequisitionList.size()>0){   %> 
         document.manPowerRequisition.<%=REQUISITION_DATE%>.value='<%=HMSUtil.changeDateToddMMyyyy(resourceRequisition.getRequisitionDate())%>';
          		  
 <% } %>
</script> <label><span>*</span> Employee Type</label> <select
	name="<%=EMPLOYEE_TYPE %>" validate="Employee Type,string,yes">
	<option value="0">Select</option>
	<%
		for(MasEmployeeType  masEmployeeType:masEmployeeTypeList){	%>
	<option value="<%=masEmployeeType.getId() %>"><%=masEmployeeType.getEmpType() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0){ %> 
          		  document.manPowerRequisition.<%=EMPLOYEE_TYPE%>.value='<%=resourceRequisition.getEmployeeType().getId()%>';
 <% } %> 
</script>

<div class="clear"></div>

<label><span>*</span> Department</label> <select
	id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>"
	validate="Department,string,yes" onchange="getEmployeeList(this)">
	<option value="0">Select</option>
	<%	for(MasDepartment  masDepartment:masDepartmentList){	%>

	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>

	<%	} %>
</select> <label><span>*</span> Location</label> <select name="<%=LOCATION_ID %>"
	validate="Location,string,yes">
	<option value="0">Select</option>
	<%
		for(MasLocation  masLocation:masLocationList){	%>
	<option value="<%=masLocation.getId() %>"><%=masLocation.getLocationName() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0){ %> 
          		  document.manPowerRequisition.<%=LOCATION_ID%>.value='<%=resourceRequisition.getLocation().getId()%>';
          		  
 <% } %> 
</script> <label><span>*</span> Vacancy Due To</label> <select
	name="<%=VACANCY_REASON_ID %>" validate="Vacancy Due To,string,yes">
	<option value="0">Select</option>
	<%
		for(MasVacancyReason  masVacancyReason:masVacancyReasonList){	%>
	<option value="<%=masVacancyReason.getId() %>"><%=masVacancyReason.getVacancyReason() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=VACANCY_REASON_ID%>.value='<%=resourceRequisition.getVacancyReason().getId()%>';
          		  
 <% } %> 
</script>
<div class="clear"></div>



<label> <span>*</span> Reporting Manager</label> <select
	id="<%=REPORTING_MANAGER_EMP_ID %>"
	name="<%=REPORTING_MANAGER_EMP_ID %>"
	validate="Reporting Manager,string,yes">
	<option value="0">Select</option>
	<%
		for(MasEmployee  masManager:masManagerList){	%>
	<option value="<%=masManager.getId() %>"><%=masManager.getFirstName()+" "+masManager.getLastName()+ "-"+masManager.getEmployeeCode() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=REPORTING_MANAGER_EMP_ID%>.value='<%=resourceRequisition.getRepManager().getId()%>';
          		  
 <% } %> 
</script> <!--  <label><span>*</span>  Billing Project Code</label>--> <label><span>*</span>
Total No of Positions</label> <input name="<%=NUMBER_OF_POSITIONS %>"
	id="<%=NUMBER_OF_POSITIONS %>" validate="Total No of Positions,int,yes"
	type="text" maxlength="4" /> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=NUMBER_OF_POSITIONS%>.value='<%=resourceRequisition.getTotalNoPosition()%>';
          		  
 <% } %> 
</script> <label>Min. Qualification</label> <select
	name="<%=QUALIFICATION_OBTAINED %>">
	<option value="0">Select</option>
	<%
		for(MasQualification  masQualification:masQualificationList){	%>
	<option value="<%=masQualification.getId() %>"><%=masQualification.getQualificationName() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getQualification()!=null)){   %> 
		document.manPowerRequisition.<%=QUALIFICATION_OBTAINED%>.value='<%=resourceRequisition.getQualification().getId()%>';
          		  
 <% } %> 
</script>



<div class="clear"></div>


<label>Desirable Qualification</label> <select
	name="<%=DESIRABLE_QUALIFICATION %>">
	<option value="0">Select</option>
	<%
		for(MasQualification  masQualification:masQualificationList){	%>
	<option value="<%=masQualification.getId() %>"><%=masQualification.getQualificationName() %></option>

	<%	} %>
</select> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getDesirableQlf()!=null)){   %> 
		document.manPowerRequisition.<%=DESIRABLE_QUALIFICATION%>.value='<%=resourceRequisition.getDesirableQlf().getId()%>';
          		  
 <% } %> 
</script> <label>Exp. Range(in yrs)</label> <input type="text"
	id="<%=EXP_LOWER_RANGE %>" name="<%=EXP_LOWER_RANGE %>" value=""
	class="small" maxlength=2 validate="Exp Lower Range,int,no" /> <label
	class="smallAuto">to</label> <input type="text"
	id="<%= EXP_UPPER_RANGE%>" name="<%= EXP_UPPER_RANGE%>" value=""
	class="small" maxlength=2 validate="Exp Upper Range,int,no" /> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getExpLowerRange()!=null)){   %> 
		document.manPowerRequisition.<%=EXP_LOWER_RANGE%>.value='<%=resourceRequisition.getExpLowerRange()%>';
          		  
 <% } %> 
</script> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getExpUpperRange()!=null)){   %> 
		document.manPowerRequisition.<%=EXP_UPPER_RANGE%>.value='<%=resourceRequisition.getExpUpperRange()%>';
          		  
 <% } %> 
</script> <label>Age Limit </label> <input name="<%=AGE_LIMIT %>"
	id="<%=AGE_LIMIT %>" type="text" validate="Age Limit,int,no"
	maxlength="2" /> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getAgeLimit()!=null)){   %> 
		document.manPowerRequisition.<%=AGE_LIMIT%>.value='<%=resourceRequisition.getAgeLimit()%>';
          		  
 <% } %> 
</script>

<div class="clear"></div>

<label>Job Description </label> <textarea name="<%=JOB_DESCRIPTION %>"
	id="<%=JOB_DESCRIPTION %>" onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getJobDesc()!=null)){   %> 
		document.manPowerRequisition.<%=JOB_DESCRIPTION%>.value='<%=resourceRequisition.getJobDesc()%>';
          		  
 <% } %> 
</script> <label><span>*</span> Required Skill</label> <!--  <div class="msg"><label id="rootcauselen2" style="visibility: hidden;" >Maximum character limit reached</label></div>-->
<textarea name="<%=REQUIRED_SKILL %>" id="<%=REQUIRED_SKILL %>"
	validate="Required Skill,string,yes"
	onkeydown="refreshLengthWithoutMeter1(this.id,250)"
	onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=REQUIRED_SKILL%>.value='<%=resourceRequisition.getRequiredSkill()%>';
          		  
 <% } %> 
</script> <label>Primary Purpose of Position </label> <textarea
	name="<%=PRIMARY_PURPOSE_OF_POSITION %>"
	id="<%=PRIMARY_PURPOSE_OF_POSITION %>"
	onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getPositionPurpose()!=null)){   %> 
		document.manPowerRequisition.<%=PRIMARY_PURPOSE_OF_POSITION%>.value='<%=resourceRequisition.getPositionPurpose()%>';
          		  
 <% } %> 
</script>
<div class="clear"></div>

<label><span>*</span> Proposed Designation </label> <input
	name="<%=PROPOSED_DESIGNATION %>" id="<%=PROPOSED_DESIGNATION %>"
	validate="Proposed Designation,string,yes" type="text" maxlength="50" />
<script type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=PROPOSED_DESIGNATION%>.value='<%=resourceRequisition.getProposedDesignation()%>';
          		  
 <% } %> 
</script> <label>Infrastructure Requirement </label> <textarea
	id="<%=INFRASTRUCTURE_REQUIREMENT %>"
	name="<%=INFRASTRUCTURE_REQUIREMENT %>"
	validate="Infrastructure Requirement ,'',no"
	onkeydown="refreshLengthWithoutMeter1(this.id,200)"
	onkeyup="refreshLengthWithoutMeter(this.id,200)"></textarea> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getInfrastRequirment()!=null)){   %> 
		document.manPowerRequisition.<%=INFRASTRUCTURE_REQUIREMENT%>.value='<%=resourceRequisition.getInfrastRequirment()%>';
          		  
 <% } %> 
</script> <label>CTC Range (in Rs)</label> <input type="text"
	id="<%=SALARY_LOWER_RANGE %>" name="<%=SALARY_LOWER_RANGE %>" value=""
	class="small" maxlength=7 validate="Salary Range,int,no" /> <label
	class="smallAuto">to</label> <input type="text"
	id="<%= SALARY_UPPER_RANGE%>" name="<%= SALARY_UPPER_RANGE%>" value=""
	class="small" maxlength=7 validate="Salary Range,int,no" /> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getSalaryLowerRange()!=null)){   %> 
		document.manPowerRequisition.<%=SALARY_LOWER_RANGE%>.value='<%=resourceRequisition.getSalaryLowerRange()%>';
          		  
 <% } %> 
</script> <script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getSalaryUpperRange()!=null)){   %> 
		document.manPowerRequisition.<%=SALARY_UPPER_RANGE%>.value='<%=resourceRequisition.getSalaryUpperRange()%>';
          		  
 <% } %> 
</script>
<div class="clear"></div>
<label>Comments</label> <textarea id="<%=COMMENTS %>"
	name="<%=COMMENTS %>" validate="Comments,'',no"
	onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea> <script
	type="text/javascript">
<% if(resourceRequisitionList.size()>0 && resourceRequisition.getHrResourceRequisitionStatus()!=null && (resourceRequisition.getHrResourceRequisitionStatus().getComments()!=null)){   %> 
		document.manPowerRequisition.<%=COMMENTS%>.value='<%=resourceRequisition.getHrResourceRequisitionStatus().getComments()%>';
          		  
 <% } %> 
</script>

<div id="toBeApprovedBy"><label><span>* </span>To Be
Approved By</label> <%

if(resourceRequisitionList.size()>0 && (resourceRequisition.getApprovingManager()!=null)){   %>
<input type="text" readonly="readonly" class="readOnly"
	value="<%=resourceRequisition.getApprovingManager().getFirstName() + " " + resourceRequisition.getApprovingManager().getLastName()%>"><input
	type="hidden" name="approvingManager"
	value="<%=resourceRequisition.getApprovingManager().getId()%>">
<% }else{ %> <select name="approvingManager" id="approvingManager"
	validate="To Be Approved By,int,yes">
	<option value="0">Select</option>
	<%
 	for(MasEmployee masEmployee:masManagerList){
	String firstName="";
	String middleName="";
	String lastName1="";
	if(masEmployee.getFirstName()!=null){
		firstName=masEmployee.getFirstName();
	}
	if(masEmployee.getMiddleName()!=null){
		middleName=masEmployee.getMiddleName();
	}
	
	if(masEmployee.getLastName()!=null){
		lastName=masEmployee.getLastName();
	}
	 
	%>
	<option value="<%=masEmployee.getId()%>"><%=firstName+" "+middleName+" "+lastName%></option>
	<%} %>




</select> <%} %>
</div>
<script type="text/javascript">
<% if(resourceRequisitionList.size()>0 && (resourceRequisition.getApprovingManager()!=null)){   %> 
		document.getElementById('approvingManager').value='<%=resourceRequisition.getApprovingManager().getId()%>';
        document.manPowerRequisition.approvingManager.value =  '<%=resourceRequisition.getApprovingManager().getId()%>'; 		  
 <% }%>
  
</script> <%
String status = "";
if(resourceRequisition!=null && ((intermediateApproverDesignation.getId().equals(resourceRequisition.getApprovingManager().getRank().getId()) && resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(1))|| ( resourceRequisition.getApprovingManager().getRank().getId().equals(finalApproverDesignation.getId()) &&  resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(2)))) 
	{
		status = "Initiated By " + resourceRequisition.getInitiator().getFirstName() + " " + resourceRequisition.getInitiator().getLastName();
	}
	else if (resourceRequisition !=null && resourceRequisition.getHrResourceRequisitionStatus()!=null)
	{
		status = resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getStatusDesc() +" by " + resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getFirstName()+" " + resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getLastName();
	}
	
 
%> <%if(resourceRequisition!=null && resourceRequisition.getHrResourceRequisitionStatus()!=null){%>
<label>Current Status</label> <label><%=status%></label> <%} %> <input
	type="hidden" name="<%=RESOURCE_REQUEST_ID %>"
	value="<%=requisitionId%>" /> <input type="hidden"
	name="<%=EMPLOYEE_ID %>" value="<%=employeeId%>" /> <input
	type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<div class="clear"></div>
</div>
<% if(resourceRequisitionList.size()!=0 && (resourceRequisition.getHrResourceRequisitionStatus()!=null && resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(1)) ){   %>
<input name="update" type="button" class="button" value="Update"
	onClick="submitForm('manPowerRequisition','recruitment?method=updateManPowerRequisitionDetail');" />
<%}else if(resourceRequisition!=null && resourceRequisition.getHrResourceRequisitionStatus()!=null && resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(6)){%>
<input name="resend" type="button" class="button" value="Resend"
	onClick="submitForm('manPowerRequisition','recruitment?method=updateManPowerRequisitionDetail&resend=yes');" />
<%}
	 else if(resourceRequisitionList.size()==0 ){ %> <input name="save"
	type="button" class="button" value="Submit"
	onClick="submitForm('manPowerRequisition','recruitment?method=saveManPowerRequisitionDetail','checkRange');" />
<%} %> <%if(resourceRequisitionList.size() == 0){ %> <input name="cancel"
	type="button" class="button" value="Cancel"
	onClick="location.href='/hms/hrms/recruitment?method=searchResourceRequests'" />
<% }else{ %> <input name="cancel" type="button" class="button"
	value="Back" onClick="history.go(-1)" /> <%} %> <%
if(resourceRequisition!=null && resourceRequisition.getRequisitionHistory()!=null && !resourceRequisition.getRequisitionHistory().isEmpty()){ %>
<div class="clear"></div>
<div class="division"></div>
<h4>Notification Path</h4>
<table cellpadding="0" cellspacing="0">
	<tr>
		<th>Action Taken by</th>
		<th>Status</th>
		<th>Action Date</th>
		<th>Comments</th>
	</tr>
	<%
  
  Set reqHistorySet = resourceRequisition.getRequisitionHistory();
  List<HrRequisitionHistory> reqHistoryList = new ArrayList<HrRequisitionHistory>(reqHistorySet);
  Collections.sort(reqHistoryList,new RequisitionHistoryComparator());
  
  for(HrRequisitionHistory requisitionHistory : reqHistoryList){ 
  String comments = "--";
  if(requisitionHistory.getComments()!=null)
  {
	  comments = requisitionHistory.getComments();
  }%>
	<tr>
		<td><%=requisitionHistory.getEmployee().getFirstName() + " " +requisitionHistory.getEmployee().getLastName()%></td>
		<td><%=requisitionHistory.getStatus().getStatusDesc()%></td>
		<td><%=requisitionHistory.getActionDate()%></td>
		<td><%=comments%></td>
	</tr>
	<%} %>
</table>
<%} %>
<div class="clear"></div>
<div class="division"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
<%if(resourceRequisition!=null && resourceRequisition.getHrResourceRequisitionStatus()!=null && !(resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(1) || resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(6))){%>
	disablefields('input');
	disablefields('select');
	disablefields('textarea');
	hideObjects('img');
	hideObjects('span');
	
<%}
else if(resourceRequisition!=null && resourceRequisition.getHrResourceRequisitionStatus()!=null && resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(6)){%>
	document.getElementById('toBeApprovedBy').style.display = 'none';
<%}else if(resourceRequisition!=null && resourceRequisition.getHrResourceRequisitionStatus()!=null && resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getId().equals(1)){%>
	document.getElementById('approvingManager').disabled = 'disabled';
<%}%>
</script>

<script>
function getEmployeeList(obj)
{
	<%for(MasDepartment department : masDepartmentList){%>
		if(obj.value == <%=department.getId()%>){
			var sel = document.getElementById("<%=REPORTING_MANAGER_EMP_ID %>");
			removeAllOptions(sel);
			sel.options.add(new Option('Select' , '0'));
			<%
			Set empSet = department.getMasEmployees();
			List<MasEmployee> emList = new ArrayList();
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
			if(empSet!=null)
			{
				emList = new ArrayList(empSet);
				Collections.sort(emList,new EmployeeComparator());
			}
			
			for(MasEmployee employee:emList){
				if(employee.getStatus().equals("y")){
			%>
				optionRepMan = new Option('<%=employee.getFirstName()+ " " + employee.getLastName()+"-"+employee.getEmployeeCode()%>' , '<%=employee.getId()%>');				
				sel.options.add(optionRepMan);
					<% if(resourceRequisitionList.size()>0){   %> 
					if(<%=resourceRequisition.getRepManager().getId()%> == '<%=employee.getId()%>'){
					optionRepMan.selected = 'selected';
					}
				 <% } %> 
			<%}
			}
			%>
			
		
		}
		
	<%}%>
}
function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}


function checkRange()
{
	exp_lower_range = document.getElementById("<%=EXP_LOWER_RANGE%>").value ;
	exp_upper_range = document.getElementById("<%=EXP_UPPER_RANGE%>").value ;
	sal_low_range   = document.getElementById("<%=SALARY_LOWER_RANGE%>").value ;
	sal_upper_range = document.getElementById("<%=SALARY_UPPER_RANGE%>").value ;
	flag = true;
	if(parseInt(exp_lower_range) > parseInt(exp_upper_range))
	{
		errorMsg = errorMsg +  "Invalid Experience Range \n";
		flag = false ;
	}
	if(parseInt(sal_low_range) > parseInt(sal_upper_range))
	{
		errorMsg = errorMsg +  "Invalid Salary Range \n";
		flag =  false;
	}
	
	
	
		return flag;
	
	
}

</script>

<script type="text/javascript">
<% if(resourceRequisitionList.size()>0){   %> 
		document.manPowerRequisition.<%=DEPARTMENT_ID%>.value='<%=resourceRequisition.getDepartment().getId()%>';
		getEmployeeList(document.getElementById("<%=DEPARTMENT_ID %>"));
		
		
		
          		  
 <% } %> 
 
</script>