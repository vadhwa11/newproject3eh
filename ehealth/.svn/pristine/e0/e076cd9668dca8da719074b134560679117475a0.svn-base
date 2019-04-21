<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
				List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("courseList")!= null){
					courseList = (List)map.get("courseList");
				}
				if(map.get("instructorList")!= null){
					instructorList = (List)map.get("instructorList");
				}
				
	%>

<%@page import="jkt.hrms.masters.business.HrMasCourse"%>
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
<form name="trainingEvaluationReport" method="post" action="">
<div class="titleBg">
<h2>Training Evaluation Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date</label> <input
	type="text" id="dobId" name="<%=FROM_DATE %>" value="" class="date"
	readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingEvaluationReport.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="dobId"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="To date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingEvaluationReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Employee</label> <select name="<%=EMPLOYEE_ID %>"
	validate="Training Name,string,no">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>

	<%
	}
%>
</select> <label>Course Name </label> <select name="<%=COURSE_ID %>"
	validate="Course,string,no">
	<option value="0">Select</option>
	<%
	for(HrMasCourse hrMasCourse :courseList){
%>
	<option value="<%=hrMasCourse.getId() %>"><%=hrMasCourse.getCourseName()%></option>

	<%
	}
%>
</select>
<div class="clear"></div>
<label>Instructor Name </label> <select name="<%=INSTRUCTOR_ID %>"
	validate="Instructor,string,no">
	<option value="0">Select</option>
	<%
	for(HrMasInstructor hrMasInstructor :instructorList){
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
	onclick="submitForm('trainingEvaluationReport','training?method=printTrainingEvaluationReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

