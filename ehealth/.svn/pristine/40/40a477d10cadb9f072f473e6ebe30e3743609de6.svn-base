<%@page import="jkt.hms.masters.business.HmisParameterMapping"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>

<script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	function generateReportMCTSExcel() {
		var id = document.getElementById("reportType").value;
		if(id == "MCTS")
			submitForm('mctsReport','pubHealth?method=generatetMCTSReport');
		else if(id == "MCTSC")
			submitForm('mctsReport','pubHealth?method=generateMCTSChildReport');
		else
			alert("Please select report! ");
	}
	
</script>

<%
Map map = new HashMap();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

utilMap = (Map)HMSUtil.getCurrentDateAndTime(); 

String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
int inc = 0;


if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}
%>

<div class="titleBg">
<h2>MCTS </h2>
</div>
<form name="mctsReport" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<h4>MCTS </h4>
	<div id="pageNavPosition"></div>		
	<div class="clear"></div>

	<!-- Added by Arbind -->
	<label><span>* </span>Report </label>
	<select name="reportType" id="reportType" validate="MCTS Report,string,yes" >
	<option value="">Select</option>
	<option value="MCTS">MCTS Mother</option>
	<option value="MCTSC">MCTS Child</option>
	</select>
	<label><span>* </span>From Date</label>
 	<input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="fromDate" validate="From Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mctsReport.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="toDate" validate="To Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mctsReport.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<div class="clear"></div>
<div style="float: left;">
	<input type="button" class="button" value="Generate Excel" align="left" onclick="javascript:generateReportMCTSExcel();">
</div>
	
</form>
<div id="responseDiv" style="display: none;"></div>
