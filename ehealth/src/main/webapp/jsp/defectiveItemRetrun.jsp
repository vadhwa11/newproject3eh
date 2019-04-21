<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showDefectiveItemReturnReportJsp";
  obj.submit();
  }
</script>
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
function check(){
var SDate = document.defectiveItemRetrun.<%= FROM_DATE%>.value;
var EDate = document.defectiveItemRetrun.<%= TO_DATE %>.value;
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
<form name="defectiveItemRetrun" method="post" action="">
<div class="clear"></div>
<div class="titleBg">
<h2>Defective Item Return Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"	MAXLENGTH="30" validate="fromDate,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveItemRetrun.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label> 
<input type="text"	name="<%=TO_DATE%>" value="<%=currentDate%>" MAXLENGTH="30"	validate="toDate,date,yes" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.defectiveItemRetrun.<%=TO_DATE%>,event)" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('defectiveItemRetrun','stores?method=generateDefectiveItemReturnReport','check()');" accesskey="a" tabindex=1 /> 
<input type="button" name="clear" id="clearbutton" value="Clear" class="button"	onClick="clearButton('defectiveItemRetrun');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>