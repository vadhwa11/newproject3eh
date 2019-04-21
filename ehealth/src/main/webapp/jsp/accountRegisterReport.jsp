<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlAccountType"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
<%
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
		Map<String,Object> mapBlAccountType = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapBlAccountType = (Map<String,Object>) request.getAttribute("map");
		}
		
		
		List<BlAccountType> blAccountTypeList = new ArrayList<BlAccountType>();
		
				
		if(mapBlAccountType.get("blAccountTypeList") != null){
			blAccountTypeList = (List)mapBlAccountType.get("blAccountTypeList");
			session.setAttribute("blAccountTypeList", blAccountTypeList);
		}else if(session.getAttribute("blAccountTypeList") != null){
			blAccountTypeList = (List)session.getAttribute("blAccountTypeList");
		}
		
	%>

<form name="accountRegisterReport" method="post">
<div class="titleBg">
<h2>Account Register Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Account Type: </label> <select
	id="blAccountType" name=<%=ACCOUNT_TYPE%>>
	<option value="0">Select</option>
	<%for(BlAccountType blAccountType : blAccountTypeList){
		/*Three Reports are not available in code  */
	if((!blAccountType.getBlAccountTypeCode().equalsIgnoreCase("EXPR")) && (!blAccountType.getBlAccountTypeCode().equalsIgnoreCase("PYBL")) && (!blAccountType.getBlAccountTypeCode().equalsIgnoreCase("RCBL"))){%>
	<option value="<%= blAccountType.getBlAccountTypeName() %>"><%= blAccountType.getBlAccountTypeName()%></option>
	<%} }%>
</select> <label><span>*</span>From Date </label> <input type="text"
	name="<%= FROM_DATE %>" value="<%=currentDate %>"
	validate="From Date,string,yes" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.accountRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate %>"
	validate="To Date,string,yes" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.accountRegisterReport.<%= TO_DATE%>,event);" />
<div class="clear"></div>

<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(checkFields();check();){submitForm('accountRegisterReport','/hms/hms/billing?method=printAccountRegisterReports');}"><script
	type="text/javascript">

function checkFields(){
	if(document.getElementById('blAccountType').value == "0"){
		alert("Please Select Account Type.");
		return false;
	}
	else {
	return true;
	}
}
function check(){
	var currentdate=new Date();
	var SDate = document.accountRegisterReport.<%= FROM_DATE%>.value;
	var EDate = document.accountRegisterReport.<%= TO_DATE %>.value;


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
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<% blAccountTypeList.clear();
%>