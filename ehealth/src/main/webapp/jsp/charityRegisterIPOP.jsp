<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
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
	String currentTime = (String)utilMap.get("currentTime");
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript">
	function check(){
		var currentDate=new Date();
		var start= new Date(document.getElementById("fromDate").value.split("/")[2], (parseInt(document.getElementById("fromDate").value.split("/")[1])-1),(parseInt( document.getElementById("fromDate").value.split("/")[0])));
		//alert(start);
	   var end= new Date(document.getElementById("toDate").value.split("/")[2], (parseInt(document.getElementById("toDate").value.split("/")[1])-1), document.getElementById("toDate").value.split("/")[0]);
	   //alert(end+"====="+end);
	flag=true;
	if(currentDate<=end){
		alert("To Date Incorrect");
	    flag=false;
	}
	//alert("==="+(start<=end) +"==="+(end.getTime()>=start.getTime()));
	if(start>=end){
		alert("From Date  Incorrect");
		flag=false;
		}

	if(flag)
	{
		return flag;
	}
		else
		{
			return flag;
	}

	}
</script>
<form name="charityRegisterReport" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Charity Register Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Bill Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>"
	class="date" readonly="readonly" maxlength="30" tabindex=1 id="fromDate"/> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.charityRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Bill Date </label> <input type="text" id="toDate"
	name="<%= TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.charityRegisterReport.<%= TO_DATE%>,true);" />

<div class="clear"></div>
<label>In Patient </label> <input type="radio" class="inputRadiobutton"
	name="patientType" value="1" checked="checked" /> <label class="medium">Out
Patient</label> <input type="radio" class="inputRadiobutton" name="patientType"
	value="2" />
<div class="clear"></div>

<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(check()){submitForm('charityRegisterReport','/hms/hms/billing?method=printCharityRegisterReportIP')};">

</input>
</div>
</form>
