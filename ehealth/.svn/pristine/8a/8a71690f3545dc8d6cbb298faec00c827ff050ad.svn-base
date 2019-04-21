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
</script>
<form name="OPDStatisticalData" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>OPD Statistical Data</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.OPDStatisticalData.<%= FROM_DATE %>,event);" />
<label><span>*</span> To Date </label> 
<input type="text" name="<%= TO_DATE %>" value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.OPDStatisticalData.<%=TO_DATE %>,event);" />
<div class="clear"></div>

<input type="hidden" name="reportName" value="<%=OPD_Statistical_Data %>" />
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('OPDStatisticalData','/hms/hms/billing?method=printOPDStatisticalData');"></input>
<div class="clear"></div>
</div>
<div class="division"></div>
</form>