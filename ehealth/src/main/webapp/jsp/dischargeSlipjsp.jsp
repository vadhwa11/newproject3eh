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
	Map map = new HashMap();
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
	}
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


<div class="titleBg">
<h2>Discharge Slip</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">

<div class="clear"></div>
<h4>Discharge Schedule</h4>
<div class="clear"></div>

<label>Discharge Date</label>
<label class="value"> <input class="mediumInput" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:void"></label>
<label>Discharge Time</label>
<label><input /> </label>

<label>IPD Date</label>
<label><input /> </label>
<div class="clear"></div>
<label>IPD Time</label>
<label><input /> </label>

<label>Ward</label>
<label><select>
<option>select</option>
</select> </label>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>



<h4>Patient Details</h4>
<div class="clear"></div>

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

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>

<h4>Discharge Details: </h4>
<div class="clear"></div>
<label>Doctor Name</label>
<label class="value"> <select><option>select</option></select> </label>
<label>Discharge Condition</label>
<label class="value"> <select><option>select</option></select> </label>
<label>Discharge To</label>
<label class="value"> <select><option>select</option></select> </label>
<div class="clear"></div>
<label>Discharge Status</label>
<label class="value"> <select><option>select</option></select> </label>
<label>Care Summary</label>
<label class="value"><textarea rows="" cols="" ></textarea> </label>
<label>Instructions To Patient</label>
<label class="value"><textarea rows="" cols="" ></textarea> </label>
<div class="clear"></div>



<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<label>ICD Code</label>
<label> <input /> </label>
<div class="clear"></div>
<label>ICD Diagnosis</label>
 <input /> <textarea rows="" cols="" class="large" ></textarea><input type="button" value="delete" class="button" />



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
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
