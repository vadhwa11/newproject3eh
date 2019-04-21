
<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masEmployeeList")!= null){
				masEmployeeList = (List)map.get("masEmployeeList");
				}				
	%>
<script type="text/javascript">
	function display(idvalue) {
	<%
	for(MasEmployee masEmployee :masEmployeeList){
		int id = masEmployee.getId();
		
	%>
	if(idvalue == <%=id%> ){
      document.getElementById('empId').value = '<%= masEmployee.getFirstName()+" "+masEmployee.getLastName() %>'
	}
<%}%>
}
	function checkFromDate(){
		var fDate = document.lateAttendanceReport.<%= FROM_DATE%>.value;
		var tDate = document.lateAttendanceReport.<%= TO_DATE %>.value;	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(toDate < fromDate)
		{
			alert(" To Date should be greater than From Date.");
			document.lateAttendanceReport.<%= FROM_DATE%>.value = "";
			document.lateAttendanceReport.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
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

<form name="lateAttendanceReport" method="post" action="">
<div class="titleBg">
<h2>Employee Late Attendance Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label> Employee Code </label> 
<select name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no"	onchange="display(this.value);">
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :masEmployeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() +"-"+masEmployee.getEmployeeCode()%></option>
<%}%>
</select> 
<input name="<%=EMPLOYEE_NAME%>" id="empId" class="readOnly" readonly="readonly" type="text" />
<label class="auto"><span>*</span> From Date</label> 
<input type="text"	name="<%=FROM_DATE %>" value="" class="date" readonly="readonly"	validate="From date ,date,yes" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.lateAttendanceReport.<%=FROM_DATE%>,event)" />
<label class="auto"><span>*</span> To Date</label> 
<input type="text" id="dobId"	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"	validate="To date ,date,yes" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.lateAttendanceReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label><span>*</span> In Time From </label> 
<input name="<%=TIME_IN %>"	type="text" value="" title="Time Should be in 24 hr Format"	validate="In Time From,string,yes"	onBlur="IsValidTime(this.value,this.id);" maxlength="5" /> 
<label style="margin-left: 68px;">In Time To</label> 
<input name="<%=TIME_OUT %>" type="text" value="" title="Time Should be in 24 hr Format" validate="In Time To,string,no" onBlur="IsValidTime(this.value,this.id);" maxlength="5" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK"	onclick="submitForm('lateAttendanceReport','attendance?method=printLateAttendanceReport','checkFromDate');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
function IsValidTime(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.
	
	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
	
	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
		alert("Time should be in HH:MM format.");
		obj.value = "";
		obj.focus();
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];
	
	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }
	
	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}





</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

