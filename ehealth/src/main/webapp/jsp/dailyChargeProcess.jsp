<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

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

<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date lastProcessedDate = null;
		if (map.get("lastProcessedDate") != null) {
			lastProcessedDate = (Date) map.get("lastProcessedDate");
		}

		if (map.get("message") != null) {
			String message = (String) map.get("message");
			out.println(message);
		}
%>

<div class="titleBg"><H2>Process Daily Charge</H2></div>
<div class=clear></div>
<form name="dailyChargeProcess" action="" method="post" >
<div class="Block">
<div class="clear"></div>
<label>Last Processed Date:</label>
<%
	if(lastProcessedDate != null)
	{
%>
<label class="value"><%=HMSUtil.convertDateTypeToStringWithoutTime(lastProcessedDate)%></label>
<%
	}
	else
	{
%>
		<label class="value">-</label>
<%
	}
%>
<div class=clear></div>
<label>Date:</label>
<input	type="text" name="processDate" value="<%= date%>" validate="Process Date,string,yes" class="date" MAXLENGTH="30" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('',document.dailyChargeProcess.processDate,true);" />

<div class=clear></div>
<input type="button" name="Process" value="Process" class="button" onclick="submitForm('dailyChargeProcess','/hms/hms/opBilling?method=scheduledDailyChargeEntry');" accesskey="g" tabindex=1/>
<input type="button" name="Process_Bill_Detail" value="Process Bill Detail" class="button" style="display:none;"
onclick="submitForm('dailyChargeProcess','/hms/hms/opBilling?method=scheduledBillDetail');"
accesskey="g" tabindex=1/>
<div class=clear></div>
</div>

<div class=clear></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
