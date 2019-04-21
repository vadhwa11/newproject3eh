<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasCompany"%>
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
	Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>)request.getAttribute("map");
	
}
List<MasCompany> companyList = new ArrayList<MasCompany>();
if(map.get("companyList") != null){
	companyList = (List<MasCompany>)map.get("companyList");
}

%>

<script type="text/javascript">
function check(){
	var currentdate=new Date();
	var SDate = document.ProjectBillingBothSummaryReport.<%= FROM_DATE%>.value;
	var EDate = document.ProjectBillingBothSummaryReport.<%= TO_DATE %>.value;


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

<form name="ProjectBillingBothSummaryReport" method="post">
<div class="titleBg">
<h2>Project Billing Both Summary Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>"
	class="date" maxlength="30" tabindex=1 validate="From Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0"
	onclick="setdate('<%=currentDate%>',document.ProjectBillingBothSummaryReport.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate %>" class="date"
	maxlength="30" tabindex=1 validate="To Date,date,yes" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0"
	onclick="setdate('<%=currentDate%>',document.ProjectBillingBothSummaryReport.<%= TO_DATE%>,true);" />

<label>Project</label> <select name="<%=PROJECT_ID %>">
	<option value="0">All</option>
	<%
for(MasCompany company : companyList){
	if(company.getPatientType().getId() == 4){
%>
	<option value="<%=company.getId() %>"><%=company.getCompanyName() %></option>
	<%} 
}%>

</select>


<div class="clear"></div>
<label>Summary </label> <input type="radio" class="inputRadiobutton"
	name="reportType" value="1" checked="checked" /> <label>Detail</label>
<input type="radio" class="inputRadiobutton" name="reportType" value="2" />
<div class="clear"></div>

<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(check()){submitForm('ProjectBillingBothSummaryReport','/hms/hms/billing?method=printProjectBillingReport')};">
</input>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
