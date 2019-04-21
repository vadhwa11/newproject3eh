<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
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
function cheack1(){
val=	document.getElementById("transactionType").value
	if(val=="0"){
	alert("pls select Transaction Type");
	return false;	
	}
	return true;
	}
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
<form name="itemTransaction" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Item Issue</h2>
</div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input type="text" name="<%= FROM_DATE %>"	value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 validate="fromDate,date,yes"/> 
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemTransaction.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 validate="toDate,date,yes"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.itemTransaction.<%= TO_DATE%>,true);" />
<label><span>*</span> Select Transaction Type</label> 
<select	name="transactionType" id="transactionType" >
	<option value="0">Select</option>
	<option value="all">Print All</option>
	<option value="rec">recieved</option>
	<option value="iss">issue</option>
	<option value="ret">return</option>
	<option value="adjustment">adjustment</option>
</select>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="if(cheack1()){submitForm('itemTransaction','/hms/hms/stores?method=printItemTransactionReportJsp');}"></input>
<div class="clear"></div>
<div class="division"></div>
</div>
</form>