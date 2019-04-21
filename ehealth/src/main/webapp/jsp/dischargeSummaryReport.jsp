<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dischargeSummaryReport.jsp
	 * Jasper Reports Used : Discharge_Summary_General.jasper, Discharge_Summary_Gyna.jasper, Discharge_Summary_Pedia.jasper
	 * Tables Used         : discharge_items, discharge_items_category, discharge_summary, patient
	 * Description         : User Screen to feed Input data for Reports viz. Discharge Summary General, Gynaecology & Pediatrics
	 * @author  Create Date: 18.02.2008    Name: Othivadivel K R
	 * Revision Date:      Revision By:
	 * @version 1.0
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java,
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, admissionNumberPopulate.jsp
--%>


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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script> 
<script type="text/javascript" language="javascript">
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

</script>

<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String status = "";
String admissionNumber = "";
String hinNo = "";
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
	status = (String)map.get("status");
	if (status.equalsIgnoreCase("nodata"))
	{
		admissionNumber = (String)map.get("admissionNumber");
		hinNo = (String)map.get("hinNo");
	}
}

String date = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String adno = "";
String hinno="";

%>

<div class="titleBg">
<h2>Patient Discharge Summary</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<form name="dischargeSummaryReportForm" action="" method="post">
<div class="titleBg">
<h4>Enter Details</h4>
</div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span>UHID</label>
<input	type="text" name="<%=HIN_NO%>" id="<%=HIN_NO%>" value="" MAXLENGTH="30" validate="Reg No.,string,yes"
	onblur="submitProtoAjax('dischargeSummaryReportForm','discharge?method=getAdmissionNumberList');" />
<!--
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"	style="cursor: pointer;" onClick="javascript:openPopupWindow();">
-->
<div id="testDiv">
<label>IP No. </label>
<select	name="<%=ADMISSION_NUMBER%>" class="select" validate="IPD No,metachar,yes"></select>
</div>


<h4 id="errorMsg"></h4>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton"	onClick="submitForm('dischargeSummaryReportForm','discharge?method=showDischargeSummaryReport');"	value="Submit" class="button" accesskey="a" />
<input type="reset"	name="Reset" value="Cancel" class="button" onclick="location.reload();"	accesskey="r" />
<input type="hidden" name="SearchFlag" value="false" />
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

