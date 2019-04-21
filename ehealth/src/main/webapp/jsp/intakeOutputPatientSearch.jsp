<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : intakeOutputPatientSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 16.05.2008    Name: Dipali  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function jsSelData(serviceNo) {
		opener.jsSetPatientData(serviceNo);
		self.close();
	}
	
	function sub()
	{
	if (patientSearchForm.serviceNo.value=="" && patientSearchForm.serviceType.value=="" &&
	    patientSearchForm.patientName.value=="" && patientSearchForm.servicePersonnelName.value==""
	    &&patientSearchForm.adNo.value=="" && patientSearchForm.rank.value=="" )
	    {
	    alert("Pl. Check your Input..... ");
	    return;
	    }
	    else
		{
		submitForm('patientSearchForm','ipd?method=showPatientSearchJsp');
		}
	}
	
//-->
</SCRIPT>

<title>Patient Search</title>

<style type="text/css">
<!--
BODY {
	MARGIN-TOP: 0px;
	MARGIN-BOTTOM: 0px;
	MARGIN-LEFT: 0px;
	MARGIN-RIGHT: 0px;
}

.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>
</head>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	
	Box box = HMSUtil.getBox(request);

	List patientList = null;
	Patient patient = null;
	
	
	if (map.get("patientList")!=null)
	patientList = (List)map.get("patientList");

%>


<div id="contentspace"><br />
<form name="patientSearchForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<div style="padding-left: 15px;">


<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Patient Search</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 760px; height: 83px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><br />


<br />

<label class="bodytextB">Patient Name </label> <input type="text"
	name="patientName" value="<%=box.get("patientName")%>"
	class="textbox_size20" MAXLENGTH="30" validate="patientName,metachar,no"/> <label class="bodytextB">IP
No. </label> <input type="text" name="adNo" value="" class="textbox_size20"
	MAXLENGTH="30" validate="adNo,metachar,no"/></div>
</div>


<br />
<label>&nbsp;</label> <input type="button" name="Submit" id="addbutton"
	onClick="sub();" value="Search" class="button" accesskey="a" /> <input
	type="hidden" name="SearchFlag" value="true" /> <br />
<br />



<div style="overflow: scroll; width: 780px; height: 410px;">
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">

	<thead>
		<tr>

			<td width="135" class="gridheaderlabel">Patient Name</td>


		</tr>

	</thead>
	<tbody>

		<% if (patientList != null && patientList.size() > 0) { %>

		<% for(int i=0;i<patientList.size();i++)
	{
		patient = (Patient)patientList.get(i);
	%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:jsSelData('<%=patient.getServiceNo()%>');">
			<td align="left"><%=patient.getPFirstName() + " " + patient.getPMiddleName() + " " + patient.getPLastName()%></td>
		</tr>
		<%
	}
	%>
		<% } 
	else
	{
	%>
		<tr>
			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>


</div>
</form>
</div>