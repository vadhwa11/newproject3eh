<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>


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
</script>
<%
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();

		Date fromDate = new Date();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
	%>

<div class="titleBg">
<h2>Blood Issue Register</h2>
</div>
<form name="bloodIssueRegister" target="_blank" action="" method="post">
<div class="Block"><label>
<span>*</span> From Date</label>
	<input type="text" class="date" id="lastDateId" 
	name="<%=FROM_DATE %>" value="<%=currentDate %>"  
	validate="From Date,date,no" MAXLENGTH="10"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" 
	border="0" validate="Pick a date" 
	onClick="setdate('<%=currentDate %>',document.bloodIssueRegister.<%=FROM_DATE%>,event)"/>
	
	<label><span>*</span> To Date</label>
	<input type="text" class="date" id="lastDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"  validate="To Date,date,no" MAXLENGTH="10"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" 
	validate="Pick a date" onClick="setdate('<%=currentDate %>',document.bloodIssueRegister.<%=TO_DATE%>,event)"/>
	<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('bloodIssueRegister','bloodBank?method=printBloodIssueRegister','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript" language="javascript">
function validateFromToDate(){

	var nowDate=new Date();

	obj1 = eval(document.bloodIssueRegister.fromDate)
	obj2 = eval(document.bloodIssueRegister.toDate)

	if(obj1.value != "" && obj2.value != "")
	{

	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}

		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}

	}
	return true;
}
</script>