<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<HrMasTraining> masTrainingList = new ArrayList<HrMasTraining>();
				List<HrMasInstructor> masInstructorList = new ArrayList<HrMasInstructor>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masTrainingList")!= null){
					masTrainingList = (List)map.get("masTrainingList");
				}
				if(map.get("masInstructorList")!= null){
					masInstructorList = (List)map.get("masInstructorList");
				}
				
	%>

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
<form name="trainingScheduleReport" method="post" action="">
<div class="titleBg">
<h2>Training Schedule Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Training Code</label> <select
	name="<%=TRAINING_ID %>" validate="Training Name,string,no">
	<option value="0">Select</option>
	<%
	for(HrMasTraining hrMasTraining : masTrainingList){
%>
	<option value="<%=hrMasTraining.getId() %>"><%=hrMasTraining.getTrainingName()%></option>

	<%
	}
%>
</select> </select> <label>Instructor Code </label> <select name="<%=INSTRUCTOR_ID %>"
	validate="Instructor,string,no">
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

<label><span>*</span>From Date</label> <input type="text" id="dobId"
	name="<%=FROM_DATE %>" value="" class="date" readonly="readonly"
	validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingScheduleReport.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="dobId"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="To date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.trainingScheduleReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Print" type="button" class="button" value="Print"
	onclick="submitForm('trainingScheduleReport','training?method=printTrainingScheduleReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

