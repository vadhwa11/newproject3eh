<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<script type="text/javascript">
function openPopupWindow()
{
 var url="/hms/hms/discharge?method=showPatientSearchJsp";
 newwindow=window.open(url,'name',"height=600,width=800,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(serviceNo)
{
document.dischargeSummaryReportForm.<%=HIN_NO%>.value=serviceNo;
document.dischargeSummaryReportForm.<%=HIN_NO%>.focus();
}

</script> <%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String status = "";
String admissionNumber = "";
String hinNo = "";
String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String adno = "";
String hinno="";

%>


<div id="contentHolder">

<div class="clear"></div>
<h2 align="left" class="style1">Discharge Slip Report</h2>
<div class="clear"></div>


<form name="dischargeSlipReport" target="_blank" method="post" action="">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block"><%--
			<label class="bodytextB">Service No.:</label>
			<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="30" onblur="getHinNo('dischargeSlipReport','ipd?method=getAdmissionNoList&flag=hin')"/>

			<div id="hinDiv">

			<label class="bodytextB">Hin:</label>
			<input type="text" name="<%=HIN_NO%>" value="" class="textbox_date" MAXLENGTH="30" />
			</div>
			<div id="testDiv">
			<label class="bodytextB">IP No.:</label>
			<input type="text" name="<%=AD_NO%>" value="" class="textbox_date" MAXLENGTH="30" />
			</div>
			--%> <label class="bodytextB">UHID</label> <input type="text"
	name="<%=HIN_NO%>" id="<%=HIN_NO%>" value="" class="textbox_size20"
	MAXLENGTH="30" validate="Reg No.,,yes"
	onblur="submitProtoAjax('dischargeSlipReport','discharge?method=getAdmissionNumberList');" />
	<input type="hidden" name="flag" id="flag" value="D"/>
<div id="testDiv"><label class="bodytextB">IP No & Admission date </label> <select
	name="<%=ADMISSION_NUMBER%>" class="select" validate="IPD No,yes">

</select>

</div>
<div class="clear"></div>
<h4 id="errorMsg"></h4>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('dischargeSlipReport','ipd?method=showDischargeSlipReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
			<% if (status.equalsIgnoreCase("nodata")) { %>
					 document.dischargeSummaryReportForm.<%=HIN_NO%>.value='<%=hinNo%>';
					 
					 alert('No Report Data Found');
					 submitProtoAjax('dischargeSummaryReportForm','discharge?method=getAdmissionNumberList');
		   	<% } %>
		   	</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>