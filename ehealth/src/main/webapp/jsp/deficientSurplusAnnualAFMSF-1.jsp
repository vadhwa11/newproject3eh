<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
	</script> <%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
				Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
	%>

<h2 align="left" class="style1">AFMSF-1 Dispatch Details</h2>



<form name="showAfmsfDispatchDetailsReport" target="_blank"
	method="post" action=""><label class="bodytextB"> From
Date:</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.showAfmsfDispatchDetailsReport.<%=FROM_DATE%>,event)" />


<label class="bodytextB"> To Date:</label> <input type="text"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.showAfmsfDispatchDetailsReport.<%=TO_DATE%>,event)" />

<br />
<br />

<input type="button" name="OK" value="OK" class="button" target="_blank"
	onClick="submitForm('showAfmsfDispatchDetailsReport','mis?method=showAfmsfReports&form=Dispatch','checkFromNTodata');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>




