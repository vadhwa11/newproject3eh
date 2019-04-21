<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
</script>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>
<script type="text/javascript">
function check(){
	var currentdate=new Date();
	var SDate = document.employeeWiseBillingReport.<%= FROM_DATE%>.value;
	var EDate = document.employeeWiseBillingReport.<%= TO_DATE %>.value;


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
<form name="employeeWiseBillingReport" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Employee Wise Billing Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>"
	class="date" readonly="readonly" maxlength="30" tabindex=1
	validate="From Date,date,yes" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=currentDate%>',document.employeeWiseBillingReport.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" maxlength="30" tabindex=1
	validate="To Date,date,yes" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=currentDate%>',document.employeeWiseBillingReport.<%= TO_DATE%>,true);" />
<label><span>*</span><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="hin" class=""
	validate="Reg No.,string,yes" maxlength="30" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(check()){submitForm('employeeWiseBillingReport','/hms/hms/billing?method=printEmployeeWiseBillingReport')};">
</input>
<div class="clear"></div>
</div>
</form>


