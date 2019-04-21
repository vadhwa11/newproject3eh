<%--
	* Copyright 2008 JK Technosoft Ltd. All rights reserved.
	* Use is subject to license terms.
	* File Name: dischargeDetailsInput.jsp
	* Tables Used: discharge_items, discharge_items_category, discharge_summary
	* Entry Screen to feed Discharge Summary Details
	* @author  Create Date: 11.02.2008    Name: Othivadivel K R
	* Revision Date:      Revision By:
	* @version 1.0
	* @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java,
	*      DischargeDataService.java, DischargeDataServiceImpl.java, dischargeFieldDisplay.jsp
	--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%
	/* Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List inPatientDetailList = new ArrayList();
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int inpatientId = 0;
	String admissionNumber = "";
	String ptName = "";
	String mrdNo="";
	String doa = "";
	String dod = "";
	String age = "";
	String sex = "";
	int departmentId = 0;
	int hinId = 0;
	String hinNo = "";
	Inpatient inpatient = null;
	Patient patient = null;
	String category_name = "";
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");

	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp = (Integer) session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

		if (map.get("inPatientDetailList") != null)
			inPatientDetailList = (List) map.get("inPatientDetailList");

		if (map.get("category_name") != null) {
			category_name = map.get("category_name").toString();
		}
	}
	String initDiagnosis = "";
	try {
		inpatient = (Inpatient) inPatientDetailList.get(0);
		patient = (Patient) inpatient.getHin();
		hinNo = patient.getHinNo();
		try {
			initDiagnosis = inpatient.getInitDiagnosis();
		} catch (Exception e) {
			initDiagnosis = "";
		}
		try {
			initDiagnosis = inpatient.getInitDiagnosis();
		} catch (Exception e) {
			initDiagnosis = "";
		}
		try {

			String fPtName = "";
			String mPtName = "";
			String lPtName = "";
			if (inpatient.getHin().getPFirstName() != null) {
				fPtName = inpatient.getHin().getPFirstName();
			}
			if (inpatient.getHin().getPMiddleName() != null) {
				mPtName = inpatient.getHin().getPMiddleName();
			} else {
				mPtName = "";
			}
			if (inpatient.getHin().getPLastName() != null) {
				lPtName = inpatient.getHin().getPLastName();
			}
			ptName = fPtName + " " + mPtName + " " + lPtName;

		} catch (Exception e) {
			ptName = "";
		}

		try {
			admissionNumber = inpatient.getAdNo();
		} catch (Exception e) {
			admissionNumber = "";
		}

		try {
			age = inpatient.getAge();
		} catch (Exception e) {
			age = "";
		}

		try {
			sex = inpatient.getHin().getSex()
					.getAdministrativeSexName();
		} catch (Exception e) {
			sex = "";
		}

		try {
			doa = HMSUtil.changeDateToddMMyyyy(inpatient
					.getDateOfAddmission());
		} catch (Exception e) {
			doa = "";
		}
		try {
			dod = HMSUtil.changeDateToddMMyyyy(inpatient
					.getDischargeDate());
		} catch (Exception e) {
			dod = "";
		}
		try {
			hinId = inpatient.getHin().getId().intValue();
		} catch (Exception e) {
			hinId = 0;
		}
		try {
			hinNo = inpatient.getHin().getHinNo();
		} catch (Exception e) {
			hinNo = "";
		}
		try {
			departmentId = inpatient.getDepartment().getId().intValue();
		} catch (Exception e) {
			departmentId = 0;
		}
		try {
			inpatientId = inpatient.getId().intValue();
		} catch (Exception e) {
			inpatientId = 0;
		}
	try{
		mrdNo=inpatient.getFrwSlNo();
	}catch(Exception e){
		mrdNo="";
	}
	} catch (Exception e) {
		e.printStackTrace();
	} */
%>
<script language="Javascript">
	</script>

<%-- <div class="titleBg">
<h2>Discharge Summary</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block"><label>Patient Name</label> <label
	class="value"><%=ptName.length() > 2 ? ptName : "-"%></label> <label>Reg
No.</label><label class="value"><%=hinNo%></label> <label>IPD No.</label> <label
	class="value"><%=inpatient.getAdNo()%></label>

<div class="clear"></div>

<label>Age</label> <label class="value"><%=age.length() > 0 ? age : "-"%></label>

<label>Sex</label> <label class="value"><%=sex.length() > 0 ? sex : "-"%></label>

<label>DOD</label> <label class="value"><%=dod.length() > 0 ? dod : "-"%></label>

<div class="clear"></div>

<label>DOA</label> <label class="value"><%=doa.length() > 0 ? doa : "-"%></label>
<label>MRD No.</label> 
<%if(mrdNo!=null && !mrdNo.equals("")){ %>
<label class="value"><%=mrdNo%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Init Diagnosis</label> <%
 	if (initDiagnosis != null)
 %> <label class="valueAuto"><%=initDiagnosis%></label>
<div class="clear"></div>

</div>
<div class="clear"></div>

<form name="dischargePatient" method="post"><script
	type="text/javascript">

		function jsOnLoad(formName)
		{
		if (document.dischargePatient.casetypecombo.value=="") return;
		document.dischargePatient.casetype.value = document.dischargePatient.casetypecombo.value;
		//document.dischargePatient.casetypecombo.disabled=true;
		submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&admissionNumber=<%=admissionNumber%>');

		}
		function jsOnChange(formName)
		{

		document.dischargePatient.casetype.value=document.dischargePatient.casetypecombo.value;
		submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&admissionNumber=<%=admissionNumber%>');
		}
	</script>
<body onLoad="jsOnLoad('dischargePatient');">

<input type="hidden" name="<%=ADMISSION_NUMBER%>"
	value="<%=admissionNumber%>" />
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId%>" />
<input type="hidden" name="<%=HIN_NO%>" value="<%=hinNo%>" />
<input type="hidden" name=<%=HOSPITAL_ID%> value="<%=hospitalId%>" />
<input type="hidden" name=<%=DEPARTMENT_ID%> value="<%=departmentId%>" />
<input type="hidden" name=<%=INPATIENT_ID%> value="<%=inpatientId%>" />
<input type="hidden" name="casetype" value="" />
<div class="paddingTop15"></div>

<div class="Block"><label class="auto">Select Department</label> <select
	name="casetypecombo" onChange="jsOnChange('dischargePatient');">
	<option value="">--Select Department--</option>
	<option value="O" <%=HMSUtil.isSelected("O", category_name)%>>Obe
	& Gynaecology</option>
	<option value="G" <%=HMSUtil.isSelected("G", category_name)%>>General</option>
	<option value="P" <%=HMSUtil.isSelected("P", category_name)%>>Paediatrics</option>
</select>
<div class="clear"></div>
</div>

<div id="testDiv"></div>
</body>
</form> --%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List inPatientDetailList = new ArrayList();
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int inpatientId = 0;
	String admissionNumber = "";
	String patientName = "";
	String doa = "";
	String dod = "";
	String age = "";
	String sex = "";
	String deptName="";
	String patientStatus="";
	String adNo="";
	int departmentId =0;
	int hinId = 0;
	String hinNo="";
	Inpatient inpatient = null;
	Patient patient = null;
	String category_name = "";
	String admitingIcd="";
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");

	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}

	if (session.getAttribute("hospitalId") != null) {
	Integer temp =  (Integer)session.getAttribute("hospitalId");
	hospitalId = temp.intValue();
	}

	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	if(map.get("admitingIcd")!=null){
		admitingIcd=(String)map.get("admitingIcd");
	}
	
	if (map.get("inPatientDetailList") != null)
	inPatientDetailList = (List) map.get("inPatientDetailList");

	if (map.get("category_name")!=null)
	{
	category_name = map.get("category_name").toString();
	}
	}
	String initDiagnosis ="";
	try
	{
	inpatient = (Inpatient) inPatientDetailList.get(0);
	patient = (Patient) inpatient.getHin();
	hinNo=patient.getHinNo();
	try
	{
	initDiagnosis = inpatient.getInitDiagnosis();
	}
	catch(Exception e)
	{
	initDiagnosis="";
	}
	try
	{
	initDiagnosis = inpatient.getInitDiagnosis();
	}
	catch(Exception e)
	{
	initDiagnosis="";
	}
	try
	{
	patientName = inpatient.getHin().getPFirstName() + " " + inpatient.getHin().getPMiddleName() + " "
	+ inpatient.getHin().getPLastName();
	}
	catch (Exception e)
	{
	patientName = "";
	}

	try
	{
	admissionNumber = inpatient.getAdNo();
	}
	catch (Exception e)
	{
	admissionNumber = "";
	}


	try
	{
	age = inpatient.getAge();
	}
	catch (Exception e)
	{
	age = "";
	}
	
	try
	{
	adNo = inpatient.getAdNo();
	}
	catch (Exception e)
	{
	adNo = "";
	}

	try
	{
	sex = inpatient.getHin().getSex().getAdministrativeSexName();
	}
	catch (Exception e)
	{
	sex = "";
	}

	try
	{
	doa = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
	}
	catch (Exception e)
	{
	doa = "";
	}
	try
	{
	dod =  HMSUtil.changeDateToddMMyyyy(inpatient.getDischargeDate());
	}
	catch (Exception e)
	{
	dod = "";
	}
	try
	{
	hinId = inpatient.getHin().getId().intValue();
	}
	catch (Exception e)
	{
	hinId = 0;
	}
	try
	{
	hinNo = inpatient.getHin().getHinNo();
	}
	catch (Exception e)
	{
	hinNo = "";
	}
	try
	{
	departmentId = inpatient.getDepartment().getId().intValue();
	
	deptName = inpatient.getDepartment().getDepartmentName();
	
	patientStatus = inpatient.getAdStatus();
	
	adNo = inpatient.getAdNo();
	}
	catch (Exception e)
	{
	departmentId = 0;
	}
	try
	{
	inpatientId = inpatient.getId().intValue();
	}
	catch (Exception e)
	{
	inpatientId = 0;
	}

	session.setAttribute("inpatient",inpatient);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}

	%>


<input type="hidden" name="hinId" value="<%=hinId %>" />
<input type="hidden" name="parent" value="<%=inpatientId %>" />
<input type="hidden" name="hiNumber" value="<%=hinNo %>" />
<input type="hidden" name="adNo" value="<%=adNo %>" />
<input type="hidden" name="patientStatus" value="<%=patientStatus %>" />
<input type="hidden" name="deptName" value="<%=deptName %>" />


<div class="clear paddingTop25"></div>

<div class="titleBg">
	<h2>Discharge Summary</h2>
</div>


<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
	<%@include file="PatientDetails.jsp"%>
	<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>

<form name="dischargePatient" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<script type="text/javascript">

		function jsOnLoad(formName)
		{
		 
		if (document.dischargePatient.casetypecombo.value=="") return;
		document.dischargePatient.casetype.value = document.dischargePatient.casetypecombo.value;
		document.dischargePatient.casetypecombo.disabled=true;
		submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&admissionNumber=<%=admissionNumber%>');

		}
		function jsOnChange(formName)
		{
		var type=document.getElementById('deptSelect').value;
		document.dischargePatient.casetype.value=document.dischargePatient.casetypecombo.value;
		submitProtoAjax('dischargePatient','discharge?method=displayDischargeFields&type='+type+'&admissionNumber=<%=admissionNumber%>&parent=<%=inpatientId%>');
		}
	</script>
	<body onLoad="jsOnLoad('dischargePatient');" />

		<input type="hidden" name="<%=ADMISSION_NUMBER%>"
			value="<%=admissionNumber%>" />
		<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId%>" />
		<input type="hidden" name="<%=HIN_NO%>" value="<%=hinNo%>" />
		<input type="hidden" name=<%=HOSPITAL_ID%> value="<%=hospitalId%>" />
		<input type="hidden" name=<%=DEPARTMENT_ID%> value="<%=departmentId%>" />
		<input type="hidden" name=<%=INPATIENT_ID%> value="<%=inpatientId%>" />
		<input type="hidden" name="casetype" value="">

		<div class="clear padingTop10"></div>

		<div class="Block">
			<label class="">Select Department</label> <select id="deptSelect"
				name="casetypecombo"
onChange="jsOnChange('dischargePatient');tempalteDisplay('dischargePatient');"				>
				<option value="">--Select Department--</option>
				<option value="G" >General</option>
				<option value="O" >Obe & Gynaecology</option>
				<!-- <option value="P" >Paediatrics</option> -->
		
		 	</select> 
		 <%--	<label>Select Template</label> 
		 	<select name="templatecombo" id="templatecomboId">
				<!--  
onchange="submitProtoAjaxWithDivName('dischargePatient','discharge?method=getDefaultValues','dtDiv');"
				disabled="disabled">-->
				<option value="">--Select Template--</option>
				<option value="t1">Template1</option>
	<option value="t2">Template2</option>
	<option value="t3">Template3</option>
	<option value="t4">Template4</option>
	<option value="t5">Template5</option> 
			</select> --%>
			<div class="clear"></div>
		</div>

		<div id="testDiv"></div>
	</body>

</form>
<script>
function tempalteDisplay(formName){
	if(document.getElementById('deptSelect').value !='')
		document.getElementById('templatecomboId').disabled = false;
	else
		document.getElementById('templatecomboId').disabled = true;
}
</script>
<script type="text/javascript" language="javascript">
function checkPatientForDischarge()
{

	if(document.getElementById('inpatientId').value==''){
		if(!displayAlert("Please select the patient."))
			alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('inpatientId').value!=''){
		if(document.getElementById('patientStatus').value=='R'){
				return true;
		}else{
			if(!displayAlert("Patient is not ready to discharge."))
				alert("Patient is not ready to discharge.");
			return false;
		}
	}
}
</script>

<script type="text/javascript">
function openPopupForInvestigation(windowname){
	window.open('lab?method=getInvestigationDetailsForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary',windowname,'left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
}
function openPopupForProcedure(windowname){
	window.open('ipd?method=getProcedureForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary',windowname,'left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
}
function openPopupForTreatment(windowname){
	window.open('ipd?method=getTreatmentDetailsForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary',windowname,'left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
	}
function openPopupForFinalDischarge(windowname){
	window.open('ipd?method=getAllIcdForDischargeSummary&parent=<%=inpatientId%>&flag=dischargeSummary',windowname,'left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');	
}	
function openPopupForWardRemarks(windowname){
	window.open('ipd?method=getAllWardRemarks&parent=<%=inpatientId%>&flag=dischargeSummary',windowname,'left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');	
}	
	
</script>


<!-- <div class="titleBg">
<h2>Discharge Summary</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

<input type="hidden" name="patTypeId" id="patTypeId" value="">
<label>UHID</label> 
<label class="value">-</label>
<label>Patient Name</label> 
<label class="value">-</label>
<label>Address</label> 
<label class="value">-</label>
<div class="clear"></div>
<label>Gender</label> 
<label class="value">-</label>
<label>Marital Status</label> 
<label class="value">-</label>
<label>Age</label> 
<label class="value">-</label>
<div class="clear"></div>
<label>Patient Category</label> 
<label class="value">-</label>
<label>Department</label> 
<label class="value">-</label>
<label>Unit</label> 
<label class="value">-</label>
<div class="clear"></div>
<label>Referring Doctor</label> 
<label class="value">-</label>
<label>Admitting Doctor</label> 
<label class="value">-</label>
<label>IP No.</label> 
<label class="value">-</label>
<div class="clear"></div>

<label>Diagnosis</label>
<label class="value"><textarea rows="" cols="" disabled="disabled"></textarea> </label>


<label>Department</label>
<label class="value"> <select>
<option>select</option>
</select> </label>

<label>Template</label>
<label class="value"> <select>
<option>select</option>
</select> </label>


<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>

<h4>Department: </h4>
<div class="clear"></div>

<label>Final Diagnosis</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Chief Complaints</label>
<label class="value"><textarea rows="" cols="" ></textarea> </label>
<div class="clear"></div>
<label>Investigation</label>
<label class="value"><textarea rows="" cols="" class="large"></textarea> </label>

<div class="clear"></div>

<label>Summary</label>
<label class="value"><textarea rows="" cols="" disabled="disabled"></textarea> </label>
<label>Procedures Undergone</label>
<label class="value"><textarea rows="" cols="" disabled="disabled"></textarea> </label>
<label>Operative Notes</label>
<label class="value"><textarea rows="" cols="" disabled="disabled"></textarea> </label>
<div class="clear"></div>



<label>Course During Hospital Stay</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Condition at the Time Of Discharge</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Adverse Reaction</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<div class="clear"></div>


<label>Advise at the Time Of Discharge</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Nutrition</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Allergies/Adverse Drug Reaction</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<div class="clear"></div>



<label>Exercise</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Life Style Change</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Treatment</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<div class="clear"></div>



<label>Refferals</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Follow Up Instruction</label>
<label class="value"><textarea rows="" cols=""></textarea> </label>
<label>Follow Up date</label>
<label class="value"> <input class="mediumInput" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:void"></label>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" />
<input type="button" class="button" value="Reset" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
</div>
<div class="clear"></div> -->
<script type="text/javascript">
function getIPPrescriptionDetails() {
	inpatientId=<%=inpatientId%>;
	var url = "/hms/hms/ipd?method=getIPPrescriptionDetails&inpatientId="
			+ inpatientId + "&dischargeParam=" +"Y&"+ csrfTokenName + "="
			+ csrfTokenValue;
	newwindow = window.open(url, 'name','left=100,top=100,height=500,width=1160,status=1');
	return false;

}
</script>