<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	
<script type="text/javascript">
function check()
{
var SDate = document.cssdReportForm.<%= FROM_DATE%>.value;
var EDate = document.cssdReportForm.<%= TO_DATE %>.value;

var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

if(startDate > endDate)
{
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
<form name="cssdReportForm" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Autoclave Request/Receipt Register</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date</label> 
<input	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>" class="date"	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('<%=currentDate%>',document.cssdReportForm.<%=FROM_DATE%>,true)" validate="Pick a date" /> 
<label><span>*</span> To Date </label> 
<input	type="text" name="<%=TO_DATE%>" value="<%=currentDate%>" class="date" MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" onclick="javascript:setdate('<%=currentDate%>',document.cssdReportForm.<%=TO_DATE%>,true)" width="16" height="16" border="0" validate="Pick a date" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Generate Report" id="addbutton"	value="Generate Report" class="buttonBig"	onClick="submitForm('cssdReportForm','cssd?method=generateCssdRequestReceiptRegisterReport','check()');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

