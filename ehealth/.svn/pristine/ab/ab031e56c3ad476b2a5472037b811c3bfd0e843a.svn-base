
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

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
<script type="text/javascript" language="javascript">
function openPopupWindow()
{
 var url="/hms/hms/discharge?method=showPatientSearchJsp";
 newwindow=window.open(url,'name',"height=600,width=800,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(hinNo)
{
document.clinicalSheetReportForm.<%=HIN_NO%>.value=hinNo;
document.clinicalSheetReportForm.<%=HIN_NO%>.focus();
}
</script>

<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String status = "";
String admissionNumber = "";
String serviceNo = "";
String hinNoForPrint ="";
String adNoForprint ="" ;
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
	status = (String)map.get("status");
	if (status.equalsIgnoreCase("nodata"))
	{
		admissionNumber = (String)map.get("admissionNumber");
		serviceNo = (String)map.get("serviceNo");
	}
}
if(map.get("adNo") != null) {
	adNoForprint = (String) map.get("adNo");
}
if(map.get("serviceNo") != null) {
	serviceNo = (String) map.get("serviceNo");
}
%>

<div id="contentHolder"><div class="clear"></div>
<h2>Clinical Graphic Report</h2>
<div class="clear"></div>
<form name="clinicalSheetReportForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<label>UHID </label>
<input	type="text" name="<%=HIN_NO%>" id="<%=HIN_NO%>"	value="" MAXLENGTH="30" validate="Reg No.,yes"
 	onblur="submitProtoAjax('clinicalSheetReportForm','discharge?method=getAdmissionNumberList');" />
 	<!--
<img src="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"	onClick="javascript:openPopupWindow();"/> -->
<div id="testDiv">
<label>IP No. </label>
 <select name="<%=ADMISSION_NUMBER %>" class="select" validate="IPD No.">
	<%if(adNoForprint.equals("")){ %>
	<option value="<%=adNoForprint%>"><%=adNoForprint%></option>
	<%} %>
</select>
</div>

<div class="clear"></div>

<label><span>*</span>From Date</label>
<input type="text"	class="date" id="fromDateId" name="<%=FROM_DATE %>"
	   value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"   validate="From Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"border="0" validate="Pick a date,date,no"
	onclick="setdate('<%=currentDate%>',document.clinicalSheetReportForm.<%= FROM_DATE%>,event);" />

<label><span>*</span>To Date</label>
<input type="text" class="date" id="toDateId" name="<%=TO_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30"  validate="To Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"
	onclick="setdate('<%=currentDate%>',document.clinicalSheetReportForm.<%= TO_DATE%>,event);" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" onClick="submitForm('clinicalSheetReportForm','discharge?method=showClinicalSheetReport');" value="Submit" class="button" accesskey="a" align="center" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input	type="hidden" name="SearchFlag" value="false" />
<label id="errorMsg" class="biglabel"></label>
<script>
	<% if (status.equalsIgnoreCase("nodata")) { %>
			 document.clinicalSheetReportForm.<%=HIN_NO%>.value='<%=serviceNo%>';
			 alert('No Report Data Found');
			 submitProtoAjax('clinicalSheetReportForm','discharge?method=getAdmissionNumberList');
   	<% } %>
   	</script></form>
</div>