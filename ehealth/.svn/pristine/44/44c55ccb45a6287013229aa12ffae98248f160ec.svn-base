<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	</script>

<%
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currentDate = (String) utilMap.get("currentDate");
		 	
	%>

<h2>Search Advance</h2>
<div class="clear"></div>
<form name="advanceSearch" target="_blank" method="post" action="">
<div id="divId" class="Block"><label class="auto"> From
Date</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" "readonly="readonly" MAXLENGTH="30"
	class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate %>',document.advanceSearch.<%=FROM_DATE%>)" />

<label class="auto"> To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" class="date" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate %>',document.advanceSearch.<%=TO_DATE%>)" />
<input type="radio" name="reportType" value="advance" class="radioCheck" />
<label class="auto">Advance</label> <input type="radio"
	name="reportType" value="refund" class="radioCheck" /> <label
	class="auto">Refund</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('advanceSearch','billing?method=printAdvanceAndRefundHsrReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

