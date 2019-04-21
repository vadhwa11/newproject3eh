<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.util.HMSUtil"%>
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
String hinNo ="";
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
%>

<div id="contentHolder"><div class="clear"></div>
<h2>IP Patient Issue  Report</h2>
<div class="clear"></div>
<form name="clinicalSheetReportForm" action="" method="post">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>From Date</label>
<input type="text"	class="date" id="fromDateId" name="<%=FROM_DATE %>"
	   value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.clinicalSheetReportForm.<%= FROM_DATE%>,event);" />

<label><span>*</span>To Date</label>
<input type="text" class="date" id="toDateId" name="<%=TO_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="to date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"
	onclick="setdate('<%=currentDate%>',document.clinicalSheetReportForm.<%= TO_DATE%>,event);" />
	
<label><span>*</span>UHID</label>
<input	type="text" name="<%=HIN_NO%>" value="<%=hinNo%>" class="textbox_date"MAXLENGTH="30"
	onchange="submitProtoAjaxWithDivName('clinicalSheetReportForm','ipd?method=getIpNoForReport',hinDiv)"validate="HIN,,yes" />
<div id="hinDiv">
<label>IP NO.</label>	
<input type="text" value="" id="" readonly="readonly">	
</div>


<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" onClick="submitForm('clinicalSheetReportForm','ipd?method=showPatinetissueReport');" value="Submit" class="button" accesskey="a" align="center" />
<input type="button" name="Submit" id="addbutton" onClick="submitForm('clinicalSheetReportForm','ipd?method=showPatinetIssueRpt');" value="Print" class="button" accesskey="a" align="center" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" name="SearchFlag" value="false" />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>