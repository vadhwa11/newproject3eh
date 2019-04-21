
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showFrequencyOfIndentReportJsp";
  obj.submit();
  }
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'

function check(){
var SDate = document.otPost.<%= FROM_DATE%>.value;
var EDate = document.otPost.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
	if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
<form name="otPost" method="post" action="">
<div class="titleBg">
<h2>Anesthesia Register</h2>
</div>

<div class="Block">
<div class="clear"></div>
<label><span>*</span>From Date</label> <input type="text"
	id="fromDate" name="<%=FROM_DATE %>" class="date" value=""
	validate="From date,date,yes" maxlength="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" style="margin-right:16px;"
	validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.otPost.<%=FROM_DATE%>,event);" />

<label><span>*</span>To Date</label> <input type="text"
	name="<%=TO_DATE%>" value="" class="date" maxlength="30"
	validate="To date,date,yes" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.otPost.<%=TO_DATE%>,event);" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onclick="submitForm('otPost','ot?method=generateOtPostAnaesthesiaReport','check()');"
	accesskey="a" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
