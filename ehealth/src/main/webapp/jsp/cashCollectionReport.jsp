<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
		function check(){
		var currentdate=new Date();
		var SDate = document.stockRegisterReport.<%= FROM_DATE%>.value;
		var EDate = document.stockRegisterReport.<%= TO_DATE %>.value;


		var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
		var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

		if(endDate>currentdate)
			{
			alert("Please ensure that the To Date is less than or equal to the Current Date.");
			document.calldate.next_day.focus();
			return false; 
			}
		else if(startDate > endDate)
		{
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
		document.calldate.next_day.focus();
		return false;
		}
		else
		{
		return true;
		}
		}
</script>
<form name="stockRegisterReport" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Cash Collection Report</h2>
</div>
<div class="Block">
<label><span>*</span>From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate %>" class="date"
	maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= TO_DATE%>,true);" />
<div class="clear"></div>

<input type="hidden" name="reportName" value="<%=CASH_COLLECTION_REPORT %>" />
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="if(check()){submitForm('stockRegisterReport','/hms/hms/billing?method=printReportForBilling')};"></input>

<%--- Excel Report Button   --%> <input type="button" name="Report"
	value="Generate Excel Report" class="buttonBig"
	onClick="if(check()){submitForm('stockRegisterReport','generalMaster?method=generateCashCollectionReports')};"
	accesskey="e" tabindex=1 />

<div class="clear"></div>
</div>
<div class="division"></div>
</form>