<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<HrMasTraining> masTrainingList = new ArrayList<HrMasTraining>();
				List<HrMasInstructor> masInstructorList = new ArrayList<HrMasInstructor>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("masTrainingList")!= null){
					masTrainingList = (List)map.get("masTrainingList");
				}
				if(map.get("masInstructorList")!= null){
					masInstructorList = (List)map.get("masInstructorList");
				}
				
	%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.HrMasTrainingStatus"%>
<script type="text/javascript">
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
	
</script>

<%@page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@page import="jkt.hrms.masters.business.HrMasInstructor"%>
<form name="trainingDetailReport" method="post" action="">
<div class="titleBg">
<h2>Training Detail Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date</label> <input
	type="text" id="dobId" name="<%=FROM_DATE %>" value="" class="date"
	readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingDetailReport.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="dobId"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="To date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingDetailReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Department Code</label> <select id="deptId"
	name="<%=DEPARTMENT_ID %>" validate="Department Name,string,no"
	onChange="populateEmployee(this.value,'trainingDetailReport')">
	<option value="0">Select</option>
	<%
	for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>

	<%
	}
%>
</select> <label>Employee </label> <select id="employeeId"
	name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>

	<%
	}
%>
</select> <script type="text/javascript">
<%
int counter=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
if(masEmployee.getDepartment() != null){
if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment.getId()%>;
empArr[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script>
<div class="clear"></div>
<label>Training Name </label> <select name="<%=TRAINING_ID %>"
	validate="Status,string,no">
	<option value="0">Select</option>
	<%
	for(HrMasTraining hrMasTraining :masTrainingList){
%>
	<option value="<%=hrMasTraining.getId() %>"><%=hrMasTraining.getTrainingName()%></option>

	<%
	}
%>
</select> <label>Instructor Name </label> <select name="<%=INSTRUCTOR_ID %>"
	validate="Status,string,no">
	<option value="0">Select</option>
	<%
	for(HrMasInstructor hrMasInstructor :masInstructorList){
%>
	<option value="<%=hrMasInstructor.getId() %>"><%=hrMasInstructor.getInstructorName()%></option>

	<%
	}
%>
</select>

<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Print" type="button" class="button" value="Print"
	onclick="submitForm('trainingDetailReport','training?method=printTrainingDetailReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

