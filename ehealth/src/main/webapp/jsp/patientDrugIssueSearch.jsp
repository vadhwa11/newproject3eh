<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>
<SCRIPT>
		<%
			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String dateCal=String.valueOf(calendar.get(Calendar.DATE));
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(dateCal.length()<2){
				dateCal="0"+dateCal;
			}			
		%>
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
		</SCRIPT>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
	%>
<script type="text/javascript">
function check(){
var SDate = document.report.<%= FROM_DATE%>.value;
var EDate = document.report.<%= TO_DATE %>.value;
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
	if(!message.equals("")){
%>
<h4><span><%=message %></span></h4>
<%} %>
<form name="patientDrugIssueSearch" method="post" action="">
<div class="titleBg">
<h2>Patient Drug Issue</h2>
</div>
<div class="clear"></div>
<div class="Block"><label class="auto">
<span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%=date %>"	class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.patientDrugIssueSearch.<%=FROM_DATE%>,true);" />
<label class="auto">
<span>*</span> To Date</label> 
<input type="text"	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"	readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.patientDrugIssueSearch.<%=TO_DATE%>,true);" />
<!-- 
	<label class="auto">Pending</label>
	<input type="radio" name="dispenseType" value="pending" checked="checked" class="radioCheck">
			
	<label class="auto">All</label>
	<input type="radio" name="dispenseType" value="all" class="radioCheck" >
	 --> 

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onClick="submitForm('patientDrugIssueSearch','billing?method=showPatientDrugIssueJsp');" accesskey="g" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>