<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.FROM_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.TO_DATE"%>
<%@page import="java.util.Calendar"%>
<script>
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
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
%>
<div class="titleBg">
<h2>Syndromic Survcillence Report</h2>
</div>
<form name="syndromicSurvcillenceRpt" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span> From Date </label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" MAXLENGTH="30" validate="From Date date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.syndromicSurvcillenceRpt.<%=FROM_DATE%>,true)" />

<label><span>*</span> To Date </label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="To Date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.syndromicSurvcillenceRpt.<%=TO_DATE%>,true)" />
	<div class="clear"></div>
	<div class="clear"></div>
	<input type="button" value="Generate Report" onclick="submitForm('syndromicSurvcillenceRpt','/hms/hms/pubHealth?method=printSyndromicSurvcillenceReport')" />
	
	<div class="clear"></div>
	<div class="clear"></div>
</div>
</form>


</div>