<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* clinicalDetails.jsp
* Purpose of the JSP -  This is for Clinical Details
* @author  Deepali
* @author  Vikas
* Create Date: 31st Jan,2008
* Revision Date:
* Revision By:
* @version 1.4
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>


<%


Map map = new HashMap();
String includedJsp="";
if(request.getAttribute("map") != null){
map = (Map) request.getAttribute("map");

}

List inPatientDetailList = new ArrayList();



try{



inPatientDetailList=(List)session.getAttribute("inPatientDetailList");
//clinicalDetailsList=(List)map.get("clinicalDetailList");



}catch(Exception e){
}

int ipdClinicalId=(Integer)map.get("ipdClinicalId");
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
String admissionNumber=null;
if(inPatientDetailList != null)
{
Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
int hinId=inPatientDetail.getHin().getId();

String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
String consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
admissionNumber=inPatientDetail.getAdNo();
MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inPatientDetail.getDiagnosis();
%>

<%
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
%>
<form name="clinicalDetails" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label>Patient Name</label> <label
	class="value"> <%= patientName %></label> <label class="medium">Service
No.</label> <label class="value"> <%=inPatientDetail.getHin().getServiceNo() %></label>

<label class="medium">IP No.</label> <label class="value"> <%=inPatientDetail.getAdNo() %></label>

<label class="medium">Ward Name</label> <label class="value"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>

<div class="clear"></div>

<label>Age</label> <label class="value"> <%=inPatientDetail.getAge() %></label>

<label class="medium">Sex</label> <label class="valueMedium"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></label>

<label class="medium">Rank</label> <label class="valueMedium">
1212</label> <label class="medium">Unit</label> <label class="valueMedium">
12345</label>

<div class="clear"></div>

<label>Consultant</label> <label class="value"><%=consultantName %></label>

<label class="medium">Diagnosis</label> <%
if(masDiagnosisConclusion != null )
{
%> <label class="valueAuto"><%=inPatientDetail.getDiagnosis().getDiagnosisConclusionName() %></label>
<%
}else{
%> <label class="valueAuto"></label> <%
}
%> <%
}
%>
<div class="clear"></div>

</div>
<div class="clear"></div>

<div id="searchbar">
<h4>Clinical Details</h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table>
	<tr>
		<th>Daily Entry Records</th>
		<th>Values</th>
		<th>Daily Entry Records</th>
		<th>Values</th>
	</tr>

	<tr>
		<td>Fahrenheit Temperature</td>
		<td><input type="text" class="textboxward" name="temperature"
			id="" validate="temperature,int,no" MAXLENGTH="3" /></td>
		<td>Respiration</td>
		<td><input type="text" class="textboxward" name="respiration"
			id="respiration" validate="respiration,int,no" value=""></td>
	</tr>

	<tr>
		<td>Pulse</td>

		<td><input type="text" class="textboxward" name="pulse" id=""
			validate="pulse,int,no" value=""></td>
		<td>Blood Pressure</td>
		<td><input type="text" class="textboxward" name="bloodPressure"
			id="bloodPressure" validate="bloodPressure,int,no" value=""></td>
	</tr>
	<tr>
		<td>Input</td>

		<td><input type="text" class="textboxward" name="input" id=""
			value=""></td>
		<td>Output</td>
		<td><input type="text" class="textboxward" name="output"
			id="output" value=""></td>
	</tr>

	<tr>
		<td>Weight</td>
		<td><input type="text" class="textboxward" name="weight"
			id="weight" validate="weight,int,no" value=""></td>
		<td>(kgs)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Treatment</td>
		<td><input type="text" class="textboxward" name="treatment"
			id="treatment" value=""></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>


	<tr>
		<td>Intake/Output Chart</td>
		<td>Values</td>
		<td>Intake/Output Chart</td>
		<td>Values</td>
	</tr>

	<tr>
		<td>PTR</td>

		<td><input type="text" class="textboxward" name="ptr" id=""
			value="" /></td>
		<td>BP</td>
		<td><input type="text" class="textboxward" name="bp" id="bp"
			validate="bp,int,no" value="" /></td>
	</tr>

	<tr>
		<td>Intake</td>

		<td><input type="text" class="textboxward" name="intake" id=""
			value="" /></td>
		<td>IV</td>
		<td><input type="text" class="textboxward" name="iv" id="iv"
			value="" /></td>
	</tr>

	<tr>
		<td>Oral</td>

		<td><input type="text" class="textboxward" name="oral" id=""
			value="" /></td>
		<td>Urine</td>
		<td><input type="text" class="textboxward" name="urine"
			id="urine" value="" /></td>
	</tr>

	<tr>
		<td>Stool</td>
		<td><input type="text" class="textboxward" name="stool"
			id="stool" value="" /></td>
		<td>VOM/ASP</td>
		<td><input type="text" class="textboxward" name="vom" id="vom"
			value="" /></td>
	</tr>
	<tr>
		<td height="24">Remarks</td>
		<td colspan="3"><input name="stool2" type="text" id="stool2"
			value="" size="123" /></td>
	</tr>

</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit" align="left"
	onClick="submitForm('clinicalDetails','ipd?method=submitClinicalDetails');" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('clinicalDetails','ipd?method=showPatientListJsp');" />
<input type="hidden" name="ipdClinicalId" value="<%=ipdClinicalId %>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

