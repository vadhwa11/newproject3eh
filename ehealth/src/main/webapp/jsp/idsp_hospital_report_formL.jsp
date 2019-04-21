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

	
	function getIdspReportFormLList(){
		submitProtoAjaxWithDivName('idspHospitalReportFormL','pubHealth?method=getIdspReportDataFormLHospitalWise','itemList');
	}
	
	function updateIdspReportFormLData(){
		submitForm('idspHospitalReportFormL','pubHealth?method=updateIdspReportFormLDataHospitalWise');
	}
	
	function generateIdspReportFormLExcel(){
		submitForm('idspHospitalReportFormL','pubHealth?method=generatetIdspReportFormL');
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
<h2>Form L</h2>
</div>
<form name="idspHospitalReportFormL" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<h4>Form L</h4>
		<div id="pageNavPosition"></div>		
		<div class="clear"></div>
		 <label><span>* </span>From Date</label> 
 	<input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="fromDate" validate="From Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.idspHospitalReportFormL.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="toDate" validate="To Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.idspHospitalReportFormL.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<div class="clear"></div>
<div style="float: left;">
	<input type="button" class="button" value="Generate Excel" align="left" onclick="javascript:generateIdspReportFormLExcel();">
</div>

<div style="float: right;">
	<!-- <input type="button" class="button" value="Search" align="left" onclick="javascript:getIdspReportFormLList();"> -->
</div>
		
		<div class="clear"></div>
<!-- <table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemGrid">
	<tr>
		<th scope="col">Diseases/Syndromes</th>
		<th scope="col">No Of Samples Tested</th>
	</tr>
	<tbody id="itemList">
	
	</tbody>
</table>
<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
<div style="float: left;">
	<input type="button" class="button" value="Update" align="left" onclick="javascript:updateIdspReportFormLData();">
</div> -->
	</div>
	
</form>
<div id="responseDiv" style="display: none;"></div>


<script type="text/javascript">
// getIdspReportFormLList();
</script>