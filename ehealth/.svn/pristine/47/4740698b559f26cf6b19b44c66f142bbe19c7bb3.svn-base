<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script><script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");

currentDate=currentDate.substring(6,10);



%>

<div id="contentHolder"><div class="clear"></div>
<h2>Attendance Report</h2>
<div class="clear"></div>
<form name="clinicalSheetReportForm" action="" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Year</label>

<%
int startyear=1999;
int currentYear=Integer.parseInt(currentDate);

%>
<select name="year" id="year">
<%
int i=currentYear;
while(i>1999){ 

%>
<option value="<%=i %>"><%=i %></option>

<%
i=i-1;
} %>
</select>


<label>Month</label>
<select name="month" id="month" >
<option value="0">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" onClick="submitForm('clinicalSheetReportForm','ipd?method=generateAttendanceReport');" value="Submit" class="button" accesskey="a" align="center" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" name="SearchFlag" value="false" />
<label id="errorMsg" class="biglabel"></label>
</form>
</div>