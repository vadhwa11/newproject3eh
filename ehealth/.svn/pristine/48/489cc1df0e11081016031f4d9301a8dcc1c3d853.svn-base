
<%--
	* Copyright 2008 JK Technosoft Ltd. All rights reserved.
	* Use is subject to license terms.
	*intakeOutput.jsp
	* Purpose of the JSP -  This is for Intake Output.
	* @author  Dipali
	* Revision Date:
	* Revision By:
	* @version 1.2
	--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
	/***********************************************
	* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	***********************************************/
	</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js">
	/***********************************************
	* Animated Collapsible DIV v2.0- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for this script and 100s more
	***********************************************/
	</script>

<script type="text/javascript">
	/* animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets,hide=0')

	animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
	animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.init() */
	</script>

<script>
	/* function changeClass(title,t)
	{
	animatedcollapse.toggle(title,t);
	} */
	</script>




<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	String max="";
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}
	List inPatientDetailList = new ArrayList();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList")!=null){
	inpatientList = (List) map.get("inpatientList");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	int inpatientId = 0;
	if (map.get("inpatientId") != null) {
	inpatientId = Integer.parseInt(""+map.get("inpatientId")) ;
	}
	try{
	inPatientDetailList=(List)map.get("inPatientDetailList");

	}catch(Exception e){
	e.printStackTrace();
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
	int hospitalId = 0;

	String admissionNumber = "";
	String patientName = "";
	String serviceno = "";
	String rank = "";
	String unit = "";
	String adNo = "";
	String ward = "";
	String relation = "";
	String diagnosis = "";
	//String age = "";
	String sex = "";
	String doa = "";
	String serviceType = "";
	int departmentId =0;
	int hinId = 0;
	Inpatient inpatient = null;
	Patient patient = null;
	MasRank masRank = null;
	MasUnit masUnit = null;
	MasDepartment masDepartment=null;
	MasDiagnosisConclusion masDiagnosisConclusion=null;
	MasRelation masRelation = null;
	String category_name = "";
	String consultantName = "";
	
	String currentAge = "";
	String gender="-";
	String pCategory="";
	String materialStatus="";
	String admittedBy="-";

	//-----Details for Report-------
	String hinNo="";
	String initDiagnosis ="";
	if(inPatientDetailList != null)
	{
	Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	hinId=inPatientDetail.getHin().getId();
	hinNo=inPatientDetail.getHinNo();
	adNo=inPatientDetail.getAdNo();
	try
	{
	inpatient = (Inpatient) inPatientDetailList.get(0);
	patient = (Patient) inpatient.getHin();
	masDepartment=(MasDepartment)inpatient.getDepartment();
	admissionNumber=inPatientDetail.getAdNo();
	session.setAttribute("admissionNumber",admissionNumber);
	consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();

	try
	{
		String mName="";
		String lName="";
		if(inpatient.getHin().getPMiddleName()!=null){
		mName=inpatient.getHin().getPMiddleName();
		}
		if(inpatient.getHin().getPLastName()!=null){
			lName=inpatient.getHin().getPLastName();
	}
	patientName = inpatient.getHin().getPFirstName() + " " + mName + " "+lName;
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
	serviceno = inpatient.getHin().getServiceNo();
	}
	catch (Exception e)
	{
	serviceno = "";
	}

	try
	{
	ward = masDepartment.getDepartmentName();
	}
	catch (Exception e)
	{
	ward = "";
	}

	try
	{
	diagnosis = masDiagnosisConclusion.getDiagnosisConclusionName();
	}
	catch (Exception e)
	{
	diagnosis = "";
	}

	try
	{
	if(inpatient.getInitDiagnosis() !=null)
	initDiagnosis = inpatient.getInitDiagnosis();
	}
	catch (Exception e)
	{
	initDiagnosis = "";
	}
	try
	{
	rank = masRank.getRankName();
	}
	catch (Exception e)
	{
	rank = "";
	}
	try
	{
	doa =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
	}
	catch (Exception e)
	{
	doa = "";
	}

	try
	{
	unit = masUnit.getUnitName();
	}
	catch (Exception e)
	{
	unit = "";
	}

	try
	{
	sex = inpatient.getHin().getSex().getAdministrativeSexName();
	}
	catch (Exception e)
	{
	sex = "";
	}
	if (inpatient.getDoctor() != null)
		if (inpatient.getDoctor().getFirstName() != null) {
			consultantName = inpatient.getDoctor()
					.getFirstName();
		}
	if (inpatient.getDoctor() != null)
		if (inpatient.getDoctor().getMiddleName() != null) {
			consultantName +=  " "+inpatient.getDoctor()
					.getMiddleName();
		}
	if (inpatient.getDoctor() != null)
		if (inpatient.getDoctor().getLastName() != null) {
			consultantName +=  " "+inpatient.getDoctor()
					.getLastName();
		}
	session.setAttribute("inpatient",inpatient);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	
	 String age = "";
		
		if(inPatientDetail.getHin().getSex()!=null)
		{
			gender=inPatientDetail.getHin().getSex().getAdministrativeSexName();
		}		
		
		if(inPatientDetail.getHin().getMaritalStatus()!=null)
		{
			materialStatus=inPatientDetail.getHin().getMaritalStatus().getMaritalStatusName();
		}else
		{
			materialStatus="-";
		}
		
		if(inPatientDetail.getHin().getPatientType()!=null){
			pCategory = inPatientDetail.getHin().getPatientType().getPatientTypeName();
		}
		else
		{
			pCategory="-";
		}
		
	    if(inPatientDetail.getHin().getAge()!=null)
			age = inPatientDetail.getHin().getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,inPatientDetail.getHin().getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}


	%>
<script>
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</script>
<%-- <div class="titleBg">
<h2>Intake/Output Chart</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>
<form name="intakeOutput" method="post" action=""><input
	type="hidden" name="inpatientId" value="<%=inpatientId %>"/><input
	type="hidden" name="hinNo" value="<%=hinNo%>"/><input
	type="hidden" name="andNo" value="<%=andNo %>"/>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block"><input type="hidden" name="deptName"
	id="deptName" value="<%=deptName %>" /> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
	class="value"><%=inpatient.getHin().getHinNo()%></label> <label>Patient
Name</label> <label class="value"><%=patientName.length()>2?patientName:"-"%></label>

<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <label class="value"> <%=adNo.length()>0?adNo:"-"%></label>
 <div class="clear"></div>
<label>Ward</label> <label class="value"><%=ward.length()>0?ward:"-"%></label>
 <label>Rank</label>
	<label class="value"><%=rank.length()>0?rank:"-" %></label>

	<label>Unit</label>
	<label class="value"><%=unit.length()>0?unit:"-" %></label>

	<label>DOA</label>
	<label class="value"><%=doa.length()>0?doa:"-"%></label>
	
 <label>Consultant Name</label> <label class="valueAuto"><%=consultantName.length()>0?consultantName:"-"%></label>
 <label>Age</label> <label class="value"><%=age.length()>0?age:"-"%></label>
 <div class="clear"></div>
  <label>Sex</label> <label class="value"><%=sex.length()>0?sex:"-"%></label>
 <label>Diagnosis</label> <label class="valueAuto"><%=diagnosis.length()>0?diagnosis:"-"%></label>
 <label>Init Diagnosis</label> <label class="valueAuto"><%=initDiagnosis%></label>
 <input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" /> <input
	type="hidden" name="<%=AD_NO %>"
	value="<%=inPatientDetail.getAdNo() %>" />
	<%if(inPatientDetail.getDepartment()!=null){%> 
	<input type="hidden"
	name="<%=DEPARTMENT_ID %>"
	value="<%=inPatientDetail.getDepartment().getDepartmentName() %>" /> <%}}	%>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Common Details</h5>
</a>
<div class="clear"></div>
<div id="title1"><input type="hidden" value="<%=adNo%>"
	name="<%=ADMISSION_NUMBER %>" /> <input type="hidden"
	value="<%=currenDate%>" name="<%=TO_DATE %>" /> <input type="hidden"
	value="<%=currenDate%>" name="<%=FROM_DATE %>" /> <input type="button"
	class="buttonAdd" value=" "
	onclick="generateRowWithSrNos('intakeOutputId');" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRow(this,'intakeOutputId');" align="right" /> <input
	type="hidden" name="hinId" value="<%=hinId%>" />
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id='intakeOutputId'>
<!-- 				<thead class="fixedHeader headerFormat">  -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Temperature</th>
						<th>Pulse</th>
						<th>Respiration</th>
						<th>BP</th>
						<th>Bowel</th>
						<th>Pain</th>
						<th>FHR</th>
						<th>Remarks</th>
					</tr>
<!--				</thead> -->
<!--				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" name="checkbox" value=""
							class="radioCheck" id="common1" /></td>
						<td><input type="hidden" name="srNO" /> <input type="text"
							size="8" value="<%=date%>" name="<%=TEMPERATURE_DATE%>"
							validate="Date,date,no" /></td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=TEMPERATURE_TIME%>"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
						<td><select name="<%=TEMPERATURE %>" class="small">
							<option value="0">Select</option>
							<option value="97">97</option>
							<option value="97.2">97.2</option>
							<option value="97.4">97.4</option>
							<option value="97.6">97.6</option>
							<option value="97.8">97.8</option>
							<option value="98">98</option>
							<option value="98.2">98.2</option>
							<option value="98.4">98.4</option>
							<option value="98.6">98.6</option>
							<option value="98.8">98.8</option>
							<option value="99">99</option>
							<option value="99.2">99.2</option>
							<option value="99.4">99.4</option>
							<option value="99.6">99.6</option>
							<option value="99.8">99.8</option>
							<option value="100">100</option>
							<option value="100.2">100.2</option>
							<option value="100.4">100.4</option>
							<option value="100.6">100.6</option>
							<option value="100.8">100.8</option>
							<option value="101">101</option>
							<option value="101.2">101.2</option>
							<option value="101.4">101.4</option>
							<option value="101.6">101.6</option>
							<option value="101.8">101.8</option>
							<option value="102">102</option>
							<option value="102.2">102.2</option>
							<option value="102.4">102.4</option>
							<option value="102.6">102.6</option>
							<option value="102.8">102.8</option>
							<option value="103">103</option>
							<option value="103.2">103.2</option>
							<option value="103.4">103.4</option>
							<option value="103.6">103.6</option>
							<option value="103.8">103.8</option>
							<option value="104">104</option>
							<option value="104.2">104.2</option>
							<option value="104.4">104.4</option>
							<option value="104.6">104.6</option>
							<option value="104.8">104.8</option>
							<option value="105">105</option>
							<option value="105.2">105.2</option>
							<option value="105.2">105.4</option>
							<option value="105.6">105.6</option>
							<option value="105.8">105.8</option>
							<option value="106">106</option>
						</select> <sup>&deg;</sup>F</td>
						<td><input type="text" value="" name="<%=PULSE%>" id="pulse"
							validate="Pulse,int,no"
							onchange="checkPulseIntakeValidation(this.value);" MAXLENGTH="3"
							size="5" /> /min</td>
						<td><input type="text" value="" name="<%=RESPIRATION%>"
							id="respiration" validate="Respiration,int,no"
							onchange="checkRespirationIntakeValidation(this.value);"
							MAXLENGTH="2" size="5" /> /min</td>
						<td><input type="text" size="5" value="" name="<%=BP%>"
							id="bp" onchange="checkBpIntakeValidation(this.value);"
							onblur="validateBpWithSlash(this.value);" MAXLENGTH="7" /> mm/hg
						</td>
						<td><input name="<%= BOWEL%>" onchange="changeStatus();"
							id="bowel" value="" maxlength="3" size="5" /></td>
						<td><select name="<%= PAIN%>" onchange="changeStatus();"
							class="small" id="pain">
							<option value="0">Select</option>
							<option value="P1">P1</option>
							<option value="P2">P2</option>
							<option value="P3">P3</option>
							<option value="P4">P4</option>
							<option value="P5">P5</option>
							<option value="P6">P6</option>
							<option value="P7">P7</option>
							<option value="P8">P8</option>
							<option value="P9">P9</option>
							<option value="P10">P10</option>
						</select></td>
						<td><input type="text" value="" size="3" name="<%=FHR%>"
							id="fhr" onblur="fillClinical();" validate="Fhr,int,no"
							onchange="checkFhrValidation(this.value,'');" maxlength="3" />
						/min</td>
						<td><input type="text" size="10" value=""
							name="<%=TEMPERATURE_REMARKS %>" id="remarks"
							validate="Remarks,remarks,no" MAXLENGTH="30" /></td>
					</tr>
			<!--	</tbody> -->
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<!-- Intake Details  section  starts--> <a
	href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Intake Details</h5>
</a>
<div class="clear"></div>
<div id="title2">
<div class="clear"></div>
<input type="button" class="buttonAdd" value=" "
	onclick="generateRowWithSrNos('intakeOutput1');" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRow(this,'intakeOutput1');" align="right" />
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id='intakeOutput1'>
<!--				<thead class="fixedHeader headerFormat"> -->

					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Oral</th>
						<th>Artery Feeding</th>
						<th>Intake</th>
						<th>IV</th>
						<th>Remarks</th>
					</tr>
<!--				</thead>

				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" class="radioCheck" name="checkbox"
							value="" id="intakeId" /></td>
						<td><input type="hidden" name="srNO" /> <input type="text"
							size="8" value="<%=date%>" name="<%=INTAKE_DATE%>" /></td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=INTAKE_TIME%>" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" tabindex="1" /></td>

						<td><input type="text" value="" name="<%=ORAL%>"
							validate="Oral,String,no" id="oral" MAXLENGTH="20" /></td>

						<td><input type="text" value="" name="<%=PTR%>"
							validate="Ptr,String,no" id="ptr" MAXLENGTH="20" /></td>

						<td><input type="text" size="10" value="" name="<%=INTAKE%>"
							validate="Intake,int,no" id="intake"
							onchange="checkIntakeValidation(this.value);" MAXLENGTH="20" />
						/ml</td>

						<td><select name="<%=IV_COMBO%>">
							<option value="">Select</option>
							<option value="INJ.DEXTROSE  5%">INJ.DEXTROSE  5%</option>
							<option value="INJ.DEXTROSE  10%">INJ.DEXTROSE  10%</option>
							<option value="INJ.DEXTROSE  25%">INJ.DEXTROSE  25%</option>
							<option value="INJ.DEXTROSE NORMAL SALINE ">INJ.DEXTROSE NORMAL SALINE </option>
							<option value="INJ.ISOLYTE M">INJ.ISOLYTE M</option>
							<option value="INJ.ISOLYTE P">INJ.ISOLYTE P</option>
							<option value="INJ.METRONIDAZOLE">INJ.METRONIDAZOLE</option>
							<option value="INJ.CIPROFLOXACIN">INJ.CIPROFLOXACIN</option>
							<option value="INJ.MANITOL">INJ.MANITOL</option>
							<option value="INJ.LEVOFLOXACIN">INJ.LEVOFLOXACIN</option>
							<option value="INJ.OFLOXACIN">INJ.OFLOXACIN</option>
							<option value="INJ.RINGER LACTATE">INJ.RINGER LACTATE</option>
							<option value="INJ.PARACETAMOL">INJ.PARACETAMOL</option>
							<option value="INJ.SODIUM CHLORIDE 0.45">INJ.SODIUM CHLORIDE 0.45</option>
							<option value="INJ.HESTAR">INJ.HESTAR</option>
							<option value="INJ.LINEZOLID">INJ.LINEZOLID</option>
							<option value="INJ.HERMIN">INJ.HERMIN</option>
							<option value="INJ.Ptper">INJ.Piperacillin 4mg Tozobacam 0.5 mg</option>
							<option value="INJ.Normal Saline">INJ.Normal Saline</option>
							<option value="INJ.Multi Vitamin">INJ.Multi Vitamin</option>
							<option value="INJ. Tramadol">INJ. Tramadol</option>
							<option value="INJ.Cafritaxine 1gm">INJ.Cafritaxine 1gm</option>
							<option value="INJ.Trenexa">INJ.Trenexa</option>
							<option value="INJ.Ciplox">INJ.Ciplox</option>							
							<option value="INJ.Vanacomycin">INJ.Vanacomycin</option>
							<option value="INJ.Phenytoin sodium">INJ.Phenytoin sodium</option>
							<option value="Calcium gluconate">INJ. Calcium gluconate</option>
							<option value="Inj. Pralidoxine">INJ.Pralidoxine</option>
							<option value="Inj. Choloquine 30 ml">INJ. Choloquine 30 ml</option>
							<option value="Inj.Blood Transfusion">Inj. Blood Transfusion</option>
						</select> 
						<input type="text" value="" name="<%=IV%>" validate="IV,int,no"
							id="iv" onchange="checkIvValidation(this.value);" MAXLENGTH="20" />
						</td>
						<td><input type="text" value="" name="<%=INTAKE_REMARKS%>"
							id="remarks" MAXLENGTH="20" /></td>
					</tr>

			<!--	</tbody> -->
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>
<div class="clear"></div>
<!-- Intake Details  section  ends-->
<div class="paddingTop15"></div>
<!-- Output Details  section  starts-->

<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>Output Details</h5>
</a>
<div class="clear"></div>
<div id="title3"><input type="button" class="buttonAdd" value=" "
	onclick="generateRowWithSrNos('intakeOutput2');" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRow(this,'intakeOutput2');" align="right" />

<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id='intakeOutput2'>
		<!--		<thead class="fixedHeader headerFormat"> -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Drain</th>
						<th>Urine</th>
						<th>Stool</th>
						<th>Vom</th>
						<th>ASP</th>
						<th>Remarks</th>
					</tr>
			<!--	</thead>
				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td>&nbsp;</td>
						<td><input type="checkbox" class="radioCheck"
							name="checkbox2" value="" id="outputId" /> <input type="hidden"
							name="srNO" /> <input type="text" size="8" value="<%=date%>"
							name="<%=OUTPUT_DATE%>" validate="Date Of OutputDetails,date,no" /></td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=OUTPUT_TIME%>" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" /></td>
						<td><input type="text" value="" name="<%=OUTPUT%>"
							id="output" maxlength="20" /></td>
						<td><input class="radioCheck" id="urineCheckId"
							name="urineCheck" value="" onClick="check(this);" type="checkbox" />
						<input value="" name="urine" id="urine" validate="Urine,int,no"
							onChange="checkUrineValidation(this.value);" maxlength="20"
							type="text" size="5" /> /ml</td>
						<td><input class="radioCheck" name="stoolCheck" value=""
							type="checkbox" /> <input value="" name="stool" id="stool"
							validate="Stool,int,no"
							onChange="checkStoolValidation(this.value);" maxlength="20"
							type="text"/></td>

						<td width="16%"><input class="radioCheck" name="vomCheck"
							value="" type="checkbox"/><input value="" name="vom"
							id="vom" validate="Vom,int,no"
							onChange="checkVomValidation(this.value);" maxlength="20"
							type="text" size="5" /> /ml</td>

						<td><input class="radioCheck" name="aspCheck" value=""
							type="checkbox"/><input value="" name="asp" id="asp"
							validate="Asp,int,no" onChange="checkAspValidation(this.value);"
							type="text" size="5" maxlength="20" /> /ml</td>
						<td><input type="text" value="" name="<%=OUTPUT_REMARKS%>"
							id="outputRemarks" validate="Remarks,remarks,no"
							onBlur="addRowToTable();" MAXLENGTH="20" /></td>
					</tr>
			<!--	</tbody> -->
			</table>

			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>

<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>Common Details</h5>
</a>
<div class="clear"></div>
<div id="title4"><input type="button" class="buttonAdd" value=" "
	onclick="generateRowWithSrNos('intakeOutput3');" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRow(this,'intakeOutput3');" align="right" />
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id="intakeOutput3">
			<!--	<thead class="fixedHeader headerFormat"> -->
					<tr>
						<th>&nbsp;</th>
						<th>Time</th>
						<th>Drain</th>
						<th>Time</th>
						<th>Girth</th>
						<th>Time</th>
						<th>Blood Sugar</th>
						<th>Time</th>
						<th>Insulin</th>
						<th>Remarks</th>
					</tr>
		<!--		</thead>
				<tbody class="scrollContent bodyFormat"> -->
					<tr>

						<td><input type="checkbox" class="radioCheck" name="checkbox"
							value="" id="common2" /></td>
						<td><input type="hidden" name="srNO" /> <input type="text"
							size="6" value="<%=time%>" name="<%=DRAIN_TIME%>" id="timeId"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>

						<td><input type="text" value="" name="<%=DRAIN%>" id="drain"
							validate="Drain,int,no"
							onchange="checkDrainValidation(this.value);" MAXLENGTH="20"
							size="5" />/ml</td>

						<td><input type="text" size="6" value="<%=time%>"
							name="<%=GIRTH_TIME%>" id="timeId"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>

						<td><input type="text" value="" name="<%=GIRTH%>" id="girth"
							validate="Girth,int,no"
							onchange="checkGirthValidation(this.value);" MAXLENGTH="20"
							size="5" />/cm</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=BLOOD_SUGAR_TIME%>"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
						<td><input type="text" value="" name="<%=BLOOD_SUGAR%>"
							id="bloodsugar" validate="BloodSugar,int,no"
							onchange="checkBloodValidation(this.value);" MAXLENGTH="20"
							size="5" /> /mg%</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=INSULIN_TIME%>" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" /></td>
						<td><input type="text" value="" name="<%=INSULIN%>"
							id="insulin" validate="Insulin,int,no"
							onchange="checkInsulinValidation(this.value);" MAXLENGTH="20"
							size="5" />/I.V.</td>

						<td><input type="text" value="" name="<%=DRAIN_REMARKS%>"
							id="remarks" validate="Remarks,remarks,no"
							onblur="addRowToTable();" MAXLENGTH="20" /></td>
					</tr>
	<!--			</tbody> -->
			</table>

			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!-- Output Details  section   ends-->
<div class="Block"><label class="medium">Treatment</label> <textarea
	name="<%=TREATMENT%>" id="treatment" class="large" cols="20" rows="2"
	validate="Address,string,no" id="treatmentId"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" align="left"
	onClick="if(test('intakeOutput2')){submitForm('intakeOutput','ipd?method=submitIntakeOutput');}" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showPatientListJsp');" />
<input type="button" class="button" value="View" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showViewIntakeOutputJsp');" />
<input type="button" class="button" value="Print" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showIntakeOutputChartReportJsp&<%=ADMISSION_NUMBER %>=<%=adNo%>&<%=FROM_DATE %>=<%=currenDate%>&<%=TO_DATE %>=<%=currenDate %>');" />
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript">
	function test(idName)
	{
	var u=document.getElementsByName("urineCheck");
	var u1=document.getElementsByName("urine");
	var s=document.getElementsByName("stoolCheck");
	var s1=document.getElementsByName("stool");
	var v=document.getElementsByName("vomCheck");
	var v1=document.getElementsByName("vom");
	var a=document.getElementsByName("aspCheck");
	var a1=document.getElementsByName("asp");

	for(var i=0;i<u.length;i++)
	{
	if (u[i].checked == true && u1[i].value.length == 0 || u[i].checked == false && u1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (s[i].checked == true && s1[i].value.length == 0 || s[i].checked == false && s1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (v[i].checked == true && v1[i].value.length == 0 || v[i].checked == false && v1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (a[i].checked == true && a1[i].value.length == 0 || a[i].checked == false && a1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}
	}
	return true;
	}
function validateSampleValidation(){
flag = true;
	var u=document.getElementsByName("common1");
	var u1=document.getElementsByName("common2");
	var s=document.getElementsByName("inatkeId");
	var s1=document.getElementsByName("outputId");
	var v=document.getElementsByName("treatmentId");

			  if(document.getElementById('common1').checked || document.getElementById('acceptedCheck'+i).checked)
              {
              	flag = false;
     		  }

  		if(flag == false)
  		{
			return true;
		}
		else{
			alert("Please fill any details !!!!");
			return false;
		}
	}

	</script>
<div class="clear"></div></form>
<div class="paddingTop40"></div>

 --%>



<div class="titleBg">
<h2>Vitals / Intake Output Entry</h2>
</div>
<div class="clear"></div>

<form name="intakeOutput" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="inpatientId" value="<%=inpatientId%>" validate="inpatientId,int,no"/><input
	type="hidden" name="hinNo" value="<%=hinNo%>" validate="hinNo,metachar,no"/><input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo %>" validate="adNo,metachar,no"/>
	<input
	type="hidden" name="<%=HIN_ID %>" value="<%=inpatient.getHin().getId() %>" validate="hinId,int,no"/>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="deptName"
	id="deptName" value="<%=deptName %>" validate="deptName,metachar,no"/> 
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<h4>patient Details</h4>
	<div class="clear"></div>
		<div class="clear"></div>
		<%@include file="PatientDetails.jsp" %>
		<%-- <jsp:include page="PatientDetails.jsp" /> --%>
<div class="clear"></div>
		
		
		
		<div class="clear"></div>
	
<div class="clear"></div>
	<%}	%>

<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<!-- <a href="javascript:void(0)"> -->
<!-- <h5 style="background: none;" id='t1'>Common Details</h5> -->
<!-- </a> -->
<div class="clear"></div>
<div id="title1"><input type="hidden" value="<%=adNo%>"
	name="<%=ADMISSION_NUMBER %>" validate="admissionNumber,metachar,no"/> <input type="hidden"
	value="<%=currenDate%>" name="<%=TO_DATE %>" validate="toDate,date,no"/> <input type="hidden"
	value="<%=currenDate%>" name="<%=FROM_DATE %>" validate="fromDate,date,no"/> 
	
	<%-- <div style="float: right;"><input type="button"
	class="buttonAdd" value=" "
	onclick="addRowCommonDetails();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowCommonDetails();" align="right" /> 
	</div><input
	type="hidden" name="hinId" value="<%=hinId%>" />
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id='intakeOutputId'>
<!-- 				<thead class="fixedHeader headerFormat">  -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Temperature</th>
						<th>Pulse</th>
						<th>Respiration</th>
						<th>BP</th>
						<th>Bowel</th>
						<th>Pain</th>
						<!-- <th>FHR</th> -->
						<th>Remarks</th>
					</tr>
<!--				</thead> -->
<!--				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" name="common1" value=""
							class="radioCheck" id="common1" /></td>
						<td><input type="hidden" name="srNO" /> 
						
						<input type="text"
							size="8" value="<%=date%>" name="<%=TEMPERATURE_DATE%>1" id="<%=TEMPERATURE_DATE%>1"
							validate="Date,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date%>',document.intakeOutput.<%=TEMPERATURE_DATE%>1,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
							</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=TEMPERATURE_TIME%>1" id="<%=TEMPERATURE_TIME%>1"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
						<td>
						<input type="text" class="small" value=""  name="<%=TEMPERATURE %>1" id="<%=TEMPERATURE %>1" />
						<select name="<%=TEMPERATURE %>" class="small">
							<option value="0">Select</option>
							<option value="97">97</option>
							<option value="97.2">97.2</option>
							<option value="97.4">97.4</option>
							<option value="97.6">97.6</option>
							<option value="97.8">97.8</option>
							<option value="98">98</option>
							<option value="98.2">98.2</option>
							<option value="98.4">98.4</option>
							<option value="98.6">98.6</option>
							<option value="98.8">98.8</option>
							<option value="99">99</option>
							<option value="99.2">99.2</option>
							<option value="99.4">99.4</option>
							<option value="99.6">99.6</option>
							<option value="99.8">99.8</option>
							<option value="100">100</option>
							<option value="100.2">100.2</option>
							<option value="100.4">100.4</option>
							<option value="100.6">100.6</option>
							<option value="100.8">100.8</option>
							<option value="101">101</option>
							<option value="101.2">101.2</option>
							<option value="101.4">101.4</option>
							<option value="101.6">101.6</option>
							<option value="101.8">101.8</option>
							<option value="102">102</option>
							<option value="102.2">102.2</option>
							<option value="102.4">102.4</option>
							<option value="102.6">102.6</option>
							<option value="102.8">102.8</option>
							<option value="103">103</option>
							<option value="103.2">103.2</option>
							<option value="103.4">103.4</option>
							<option value="103.6">103.6</option>
							<option value="103.8">103.8</option>
							<option value="104">104</option>
							<option value="104.2">104.2</option>
							<option value="104.4">104.4</option>
							<option value="104.6">104.6</option>
							<option value="104.8">104.8</option>
							<option value="105">105</option>
							<option value="105.2">105.2</option>
							<option value="105.2">105.4</option>
							<option value="105.6">105.6</option>
							<option value="105.8">105.8</option>
							<option value="106">106</option>
						</select> <sup>&deg;</sup>F</td>
						<td><input type="text" value="" name="<%=PULSE%>1" id="<%=PULSE%>1"
							validate="Pulse,int,no"
							onchange="checkPulseIntakeValidation(this.value);" MAXLENGTH="3"
							size="5" /> /min</td>
						<td><input type="text" value="" name="<%=RESPIRATION%>1"
							id="<%=RESPIRATION%>1" validate="Respiration,int,no"
							MAXLENGTH="2" size="5" /> /min</td>
						<td><input type="text" size="3" value="" name="<%=BP%>pre1"
							id="<%=BP%>pre1"  MAXLENGTH="3" />
							mm
							<input type="text" size="3" value="" name="<%=BP%>post1"
							id="<%=BP%>post1" MAXLENGTH="3" />
							 hg
						</td>
						<td><input name="<%= BOWEL%>1" 
							id="<%= BOWEL%>1" value="" maxlength="3" size="5" /></td>
						<td><select name="<%=PAIN%>1" 
							class="small" id="<%=PAIN%>1">
							<option value="0">Select</option>
							<option value="P1">P1</option>
							<option value="P2">P2</option>
							<option value="P3">P3</option>
							<option value="P4">P4</option>
							<option value="P5">P5</option>
							<option value="P6">P6</option>
							<option value="P7">P7</option>
							<option value="P8">P8</option>
							<option value="P9">P9</option>
							<option value="P10">P10</option>
						</select></td>
						<td><input type="text" value="" size="3" name="<%=FHR%>1"
							id="<%=FHR%>1" onblur="fillClinical();" validate="Fhr,int,no"
							onchange="checkFhrValidation(this.value,'');" maxlength="3" />
						/min</td>
						<td><input type="text" size="10" value=""
							name="<%=TEMPERATURE_REMARKS %>1" id="<%=TEMPERATURE_REMARKS %>1"
							validate="Remarks,remarks,no" MAXLENGTH="30" /></td>
					</tr>
			<!--	</tbody> -->
			</table>
			<input type="hidden"  name="intakeOutputIdcount" id="intakeOutputIdcount" value="1" />
			</div>
			</td>
		</tr>
	</tbody>
</table>
<div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div> --%>
</div>


<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<!-- Intake Details  section  starts--> <a
	href="javascript:void(0)">
<h5 style="background: none;" id='t2'>Intake Details</h5>
</a>
<div class="clear"></div>
<div id="title2">
<div class="clear"></div>
<div style="float: right;">
<input type="button" class="buttonAdd" value=" "
	onclick="addRowIntakeDetails();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowIntakeDetails();" align="right" />
	</div>
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0" class="cmnTable">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="cmnTable">
			<table class="cmnTable" id='intakeOutput1'>
<!--				<thead class="fixedHeader headerFormat"> -->

					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Oral</th>
						<!-- <th>Artery Feeding</th> -->
						<th>IV</th>
						<th>RYLE's Tube</th>
						<th>Total</th>
						<th>Remarks</th>
					</tr>
<!--				</thead>

				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" class="radioCheck" name="intakeId1"
							value="" id="intakeId1" /></td>
						<td><input type="hidden" name="srNO" /> <input type="text"
							size="8" value="<%=date%>" name="<%=INTAKE_DATE%>1" id="<%=INTAKE_DATE%>1" validate="intakeDate,date,no"/>
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date%>',document.intakeOutput.<%=INTAKE_DATE%>1,event)" 
							validate="Pick a date" src="/hms/jsp/images/cal.gif" />
							</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=INTAKE_TIME%>1" id="<%=INTAKE_TIME%>1" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" tabindex="1" /></td>

						<td><input type="text" value="" name="<%=ORAL%>1"
							validate="Oral,int,no" id="<%=ORAL%>1" MAXLENGTH="3" onblur="calculateTotalIntakeDetails(this,1)" />/ml</td>

						<%-- <td><input type="text" value="" name="<%=PTR%>"
							validate="Ptr,String,no" id="ptr" MAXLENGTH="20" /></td> --%>

						<%-- <td><input type="text" size="10" value="" name="<%=INTAKE%>"
							validate="Intake,int,no" id="intake"
							onchange="checkIntakeValidation(this.value);" MAXLENGTH="20" />
						/ml</td> --%>

						<td>
						
						<%-- <select name="<%=IV_COMBO%>">
							<option value="">Select</option>
							<option value="INJ.DEXTROSE  5%">INJ.DEXTROSE  5%</option>
							<option value="INJ.DEXTROSE  10%">INJ.DEXTROSE  10%</option>
							<option value="INJ.DEXTROSE  25%">INJ.DEXTROSE  25%</option>
							<option value="INJ.DEXTROSE NORMAL SALINE ">INJ.DEXTROSE NORMAL SALINE </option>
							<option value="INJ.ISOLYTE M">INJ.ISOLYTE M</option>
							<option value="INJ.ISOLYTE P">INJ.ISOLYTE P</option>
							<option value="INJ.METRONIDAZOLE">INJ.METRONIDAZOLE</option>
							<option value="INJ.CIPROFLOXACIN">INJ.CIPROFLOXACIN</option>
							<option value="INJ.MANITOL">INJ.MANITOL</option>
							<option value="INJ.LEVOFLOXACIN">INJ.LEVOFLOXACIN</option>
							<option value="INJ.OFLOXACIN">INJ.OFLOXACIN</option>
							<option value="INJ.RINGER LACTATE">INJ.RINGER LACTATE</option>
							<option value="INJ.PARACETAMOL">INJ.PARACETAMOL</option>
							<option value="INJ.SODIUM CHLORIDE 0.45">INJ.SODIUM CHLORIDE 0.45</option>
							<option value="INJ.HESTAR">INJ.HESTAR</option>
							<option value="INJ.LINEZOLID">INJ.LINEZOLID</option>
							<option value="INJ.HERMIN">INJ.HERMIN</option>
							<option value="INJ.Ptper">INJ.Piperacillin 4mg Tozobacam 0.5 mg</option>
							<option value="INJ.Normal Saline">INJ.Normal Saline</option>
							<option value="INJ.Multi Vitamin">INJ.Multi Vitamin</option>
							<option value="INJ. Tramadol">INJ. Tramadol</option>
							<option value="INJ.Cafritaxine 1gm">INJ.Cafritaxine 1gm</option>
							<option value="INJ.Trenexa">INJ.Trenexa</option>
							<option value="INJ.Ciplox">INJ.Ciplox</option>							
							<option value="INJ.Vanacomycin">INJ.Vanacomycin</option>
							<option value="INJ.Phenytoin sodium">INJ.Phenytoin sodium</option>
							<option value="Calcium gluconate">INJ. Calcium gluconate</option>
							<option value="Inj. Pralidoxine">INJ.Pralidoxine</option>
							<option value="Inj. Choloquine 30 ml">INJ. Choloquine 30 ml</option>
							<option value="Inj.Blood Transfusion">Inj. Blood Transfusion</option>
						</select>  --%>
						<input type="text" value="" name="<%=IV%>1" validate="IV,int,no"
							id="<%=IV%>1" onblur="calculateTotalIntakeDetails(this,1)"  MAXLENGTH="3" /> /ml
						</td>
						<td>
						<input type="text" maxlength="3" value="" name="ryles1" onblur="calculateTotalIntakeDetails(this,1)" validate="Ryle's,int,no"
							id="ryles1" onchange="" /> /ml
						</td>
						
						<td>
						<input type="text" value="" name="total1" validate="Total,int,no" readonly="readonly"
							id="total1" /> /ml
						</td>
						
						<td><input type="text" value="" name="<%=INTAKE_REMARKS%>1" 
							id="<%=INTAKE_REMARKS%>1" MAXLENGTH="20" validate="intakeRemarks,string,no"/></td>
					</tr>

			<!--	</tbody> -->
			</table>
			
			<input type="hidden"  name="intakeOutputId1count" id="intakeOutputId1count" value="1" />
			</div>
			</td>
		</tr>
	</tbody>
</table>
<div style="float: right;display: none;'">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>
</div>

<div class="clear"></div>
<!-- Intake Details  section  ends-->
<div class="paddingTop15"></div>
<!-- Output Details  section  starts-->

<div class="clear"></div>
<a href="javascript:void(0)">
<h5 style="background: none;" id='t3'>Output Details</h5>
</a>
<div class="clear"></div>
<div id="title3">
<div style="float: right;"><input type="button" class="buttonAdd" value=" "
	onclick="addRowOutputDetails();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowOutputDetails();" align="right" />
</div>
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0" class="cmnTable">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="cmnTable">
			<table class="cmnTable" id='intakeOutput2'>
		<!--		<thead class="fixedHeader headerFormat"> -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Bleeding PVO</th>
						<th>Drain</th>
						<!-- <th>Output</th> -->
						<th>Urine</th>
						<!-- <th>Stool</th> -->
						<th>Vom</th>
						<th>ASP</th>
						
						<th>Total</th>
						<th>Remarks</th>
					</tr>
			<!--	</thead>
				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" class="radioCheck"
							name="outputId1" value="" id="outputId1" /></td><td><input type="hidden"
							name="srNO" /> <input type="text" size="8" value="<%=date%>"
							name="<%=OUTPUT_DATE%>1" id="<%=OUTPUT_DATE%>1" validate="Date Of OutputDetails,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date%>',document.intakeOutput.<%=OUTPUT_DATE%>1,event)" 
							validate="Pick a date" src="/hms/jsp/images/cal.gif" />
							</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=OUTPUT_TIME%>1" id="<%=OUTPUT_TIME%>1"" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" /></td>
							<td><input type="text" value="" name="bleedingpvo1"
							id="bleedingpvo1" MAXLENGTH="3" onblur="calculateTotalOutputDetails(this,1)" /> /ml</td>
							<td><input type="text" value="" name="<%=DRAIN%>1" onblur="calculateTotalOutputDetails(this,1)"
							id="<%=DRAIN%>1" MAXLENGTH="3" /> /ml</td>
						
						<%-- <td><input type="text" value="" name="<%=OUTPUT%>"
							id="output" maxlength="20" /></td>--%>
						<td> 
						<input value="" name="urine1" id="urine1" validate="Urine,int,no"
							onblur="calculateTotalOutputDetails(this,1)" MAXLENGTH="3"
							type="text" size="5" /> /ml</td>
						<!-- <td> <input value="" name="stool1" id="stool1"
							validate="Stool,int,no"
							onChange="checkStoolValidation(this.value);" maxlength="20"
							type="text"/></td> -->

						<td width="16%"><input value="" name="vom1"
							id="vom1" validate="Vom,int,no"
							onblur="calculateTotalOutputDetails(this,1)"MAXLENGTH="3"
							type="text" size="5" /> /ml</td>

						<td><input value="" name="asp1" id="asp1"
							validate="Asp,int,no" onblur="calculateTotalOutputDetails(this,1)"
							type="text" size="5" MAXLENGTH="3" /> /ml</td>
							
							<td><input value="" name="outputtotal1" id="outputtotal1"
							validate="Total Output,int,no" readonly="readonly" 
							type="text" size="5" maxlength="20" /> /ml</td>
							
						<td><input type="text" value="" name="<%=OUTPUT_REMARKS%>1"
							id="<%=OUTPUT_REMARKS%>1" validate="Remarks,string,no"
							onBlur="addRowToTable();" MAXLENGTH="20" /></td>
					</tr>
			<!--	</tbody> -->
			</table>
<input type="hidden"  name="intakeOutput2Count" id="intakeOutput2Count" value="1" />
			</div>
			</td>
		</tr>
	</tbody>
</table>
<div style="float: right;display: none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<%-- 
<a href="javascript:void(0)">
<h5 style="background: none;" id='t4'>Common Details</h5>
</a>
<div class="clear"></div>
<div id="title4"> <div style="float: right;"><input type="button" class="buttonAdd" value=" "
	onclick="addRowCommon1Details();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowCommon1Details();" align="right" />
	</div>
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id="intakeOutput3">
			<!--	<thead class="fixedHeader headerFormat"> -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Girth</th>
						<!-- <th>Time</th> -->
						<th>Blood Sugar</th>
						<!-- <th>Time</th> -->
						<th>Insulin</th>
						<th>Remarks</th>
					</tr>
		<!--		</thead>
				<tbody class="scrollContent bodyFormat"> -->
					<tr>

						<td><input type="checkbox" class="radioCheck" name="commonsecond1"
							value="" id="commonsecond1" /></td>
						<td><input type="hidden"
							name="srNO" /> <input type="text" size="8" value="<%=date%>"
							name="common2date1" id="common2date1" validate="Date Of OutputDetails,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date%>',document.intakeOutput.common2date1,event)" 
							validate="Pick a date" src="/hms/jsp/images/cal.gif" />
							</td>

						<td><input type="text" size="6" value="<%=time%>"
							name="<%=GIRTH_TIME%>1" id="<%=GIRTH_TIME%>1"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>

						<td><input type="text" value="" name="<%=GIRTH%>1" id="<%=GIRTH%>1"
							validate="Girth,int,no"
							 MAXLENGTH="20"
							size="5" />/cm</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=BLOOD_SUGAR_TIME%>"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
						<td><input type="text" value="" name="<%=BLOOD_SUGAR%>1"
							id="<%=BLOOD_SUGAR%>1" validate="BloodSugar,int,no"
							 MAXLENGTH="20"
							size="5" /> /mg%</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=INSULIN_TIME%>" onKeyUp="mask(this.value,this,'2',':');"
							maxlength="5" /></td>
						<td><input type="text" value="" name="<%=INSULIN%>1"
							id="<%=INSULIN%>1" validate="Insulin,int,no"
							 MAXLENGTH="20"
							size="5" />/I.U.</td>

						<td><input type="text" value="" name="<%=DRAIN_REMARKS%>1"
							id="<%=DRAIN_REMARKS%>1" validate="Remarks,remarks,no"
							 MAXLENGTH="20" /></td>
					</tr>
	<!--			</tbody> -->
			</table>
<input type="hidden"  name="intakeOutput3Count" id="intakeOutput3Count" value="1" />
			</div>
			</td>
		</tr>
	</tbody>
</table>
<div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>
</div>

 --%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!-- Output Details  section   ends-->
<label class="medium">Treatment</label> <textarea
	name="<%=TREATMENT%>" id="treatment" class="large" cols="20" rows="2"
	validate="Address,metachar,no" id="treatmentId" maxlength="200" onkeyup="return checkLength(this)"  ></textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" align="left"	onClick="submitIntakeOutput();" />
<input type="button" class="button" value="View" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showViewIntakeOutputJsp');" />	
<input type="reset" class="button" value="Reset" align="left" onclick="submitFormForButton('intakeOutput','ipd?method=showIntakeOutputJsp&parent=<%=inpatient.getId()%>');"	 />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('intakeOutput','ipd?method=showPatientListNurseJsp');"/>
	 <div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
	 </div>
<div class="clear"></div>
<script type="text/javascript">
	function test(idName)
	{
	var u=document.getElementsByName("urineCheck");
	var u1=document.getElementsByName("urine");
	var s=document.getElementsByName("stoolCheck");
	var s1=document.getElementsByName("stool");
	var v=document.getElementsByName("vomCheck");
	var v1=document.getElementsByName("vom");
	var a=document.getElementsByName("aspCheck");
	var a1=document.getElementsByName("asp");

	for(var i=0;i<u.length;i++)
	{
	if (u[i].checked == true && u1[i].value.length == 0 || u[i].checked == false && u1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (s[i].checked == true && s1[i].value.length == 0 || s[i].checked == false && s1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (v[i].checked == true && v1[i].value.length == 0 || v[i].checked == false && v1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}

	if (a[i].checked == true && a1[i].value.length == 0 || a[i].checked == false && a1[i].value.length > 0)
	{
	alert('Please Check Output Details!... Input Incomplete!....');
	return false;
	}
	}
	return true;
	}
function validateSampleValidation(){
flag = true;
	var u=document.getElementsByName("common1");
	var u1=document.getElementsByName("common2");
	var s=document.getElementsByName("inatkeId");
	var s1=document.getElementsByName("outputId");
	var v=document.getElementsByName("treatmentId");

			  if(document.getElementById('common1').checked || document.getElementById('acceptedCheck'+i).checked)
              {
              	flag = false;
     		  }

  		if(flag == false)
  		{
			return true;
		}
		else{
			alert("Please fill any details !!!!");
			return false;
		}
	}
	
	
	
function addRowCommonDetails(){
	var tbl = document.getElementById('intakeOutputId');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('intakeOutputIdcount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='common'+iteration;
	e1.id='common'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=TEMPERATURE_DATE%>'+iteration;
	e3.id='<%=TEMPERATURE_DATE%>'+iteration;
	e3.value='<%=date%>';
	e3.size='8'
	cellRight1.appendChild(e3);
	var e2 = document.createElement('img');
	e2.width = '16';
	e2.height = '16';
	e2.src='/hms/jsp/images/cal.gif';
	e2.onclick=function(){setdate('<%=date%>',e3,event)};
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE_TIME%>'+iteration;
	e1.id='<%=TEMPERATURE_TIME%>'+iteration;
	e1.size='6'
	e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='<%=time%>';
	e1.maxlength=5;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE%>'+iteration;
	e1.id='<%=TEMPERATURE%>'+iteration;
	e1.className='small';
	//e1.size='6'
	//e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='';
	cellRight1.appendChild(e1);
	var e1 = document.createElement('sup');
	e1.innerHTML ='&deg;';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'F';
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=PULSE%>'+iteration;
	e1.id='<%=PULSE%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min';
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=RESPIRATION%>'+iteration;
	e1.id='<%=RESPIRATION%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='2';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min';
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BP%>pre'+iteration;
	e1.id='<%=BP%>pre'+iteration;
	//e1.className='small';
	e1.size='3'
	/* e1.onchange=function(){checkBpIntakeValidation(this.value)}; */
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'mm';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BP%>post'+iteration;
	e1.id='<%=BP%>post'+iteration;
	//e1.className='small';
	e1.size='3'
/* 	e1.onchange=function(){checkBpIntakeValidation(this.value)};*/	
	 e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'hg';
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BOWEL%>'+iteration;
	e1.id='<%=BOWEL%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('select');
	e1.name='<%=BOWEL%>'+iteration;
	e1.id='<%=BOWEL%>'+iteration;
    e1.className='small';
	//e1.size='5'
	//e1.maxlength='3';
	//e1.value='';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 1;i<=10;i++ ){
	e1.options[i] = new Option('P'+i,'P'+i);
	}
	cellRight1.appendChild(e1);
	
	<%-- var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=FHR%>'+iteration;
	e1.id='<%=FHR%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.onchange=function(){checkFhrValidation(this.value,'')};
	e1.onblur=function(){fillClinical()};
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min'; --%>
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE_REMARKS%>'+iteration;
	e1.id='<%=TEMPERATURE_REMARKS%>'+iteration;
	//e1.className='small';
	e1.size='10'
	e1.maxlength='30';
	e1.value='';
	cellRight1.appendChild(e1);

	}


function removeRowCommonDetails()
{
  var tbl = document.getElementById('intakeOutputId');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('intakeOutputIdcount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("common"+i)!=null && (typeof  document.getElementById("common"+i).checked)!='undefined' && document.getElementById("common"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("common"+i)!=null && (typeof  document.getElementById("common"+i).checked)!='undefined' && document.getElementById("common"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("common"+i).parentNode.parentNode;
    		  document.getElementById("common"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}


function addRowIntakeDetails(){
	var tbl = document.getElementById('intakeOutput1');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('intakeOutputId1count');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='intakeId'+iteration;
	e1.id='intakeId'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=INTAKE_DATE%>'+iteration;
	e3.id='<%=INTAKE_DATE%>'+iteration;
	e3.value='<%=date%>';
	e3.size='8'
	cellRight1.appendChild(e3);
	var e2 = document.createElement('img');
	e2.width = '16';
	e2.height = '16';
	e2.src='/hms/jsp/images/cal.gif';
	e2.onclick=function(){setdate('<%=date%>',e3,event)};
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=INTAKE_TIME%>'+iteration;
	e1.id='<%=INTAKE_TIME%>'+iteration;
	e1.size='6'
	e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='<%=time%>';
	e1.maxlength=5;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=ORAL%>'+iteration;
	e1.id='<%=ORAL%>'+iteration;
	e1.maxLength='3';
	e1.value='';
	 e1.onblur=function(){calculateTotalIntakeDetails(this,iteration)};
	// e1.addEventListener ("blur", calculateTotalIntakeDetails(e1,iteration), false);
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=IV%>'+iteration;
	e1.id='<%=IV%>'+iteration;
	e1.maxLength='3';
	//e1.className='small';
	//e1.size='5'
 e1.onblur=function(){calculateTotalIntakeDetails(this,iteration)};
	// e1.addEventListener ("blur", calculateTotalIntakeDetails(e1,iteration), false);
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='ryles'+iteration;
	e1.id='ryles'+iteration;
	e1.maxLength='3';
	//e1.className='small';
	//e1.size='5'
 e1.onblur=function(){calculateTotalIntakeDetails(this,iteration)};
	// e1.addEventListener ("blur", calculateTotalIntakeDetails(e1,iteration), false);
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='total'+iteration;
	e1.id='total'+iteration;
	e1.readOnly=true;
	e1.maxLength='5';
	//e1.className='small';
	//e1.size='5'
	//e1.onchange=function(){checkBpIntakeValidation(this.value)};
	//e1.maxlength='7';
	e1.value='';
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);	
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=INTAKE_REMARKS%>'+iteration;
	e1.id='<%=INTAKE_REMARKS%>'+iteration;
	e1.maxLength='20';
	//e1.className='small';
	//e1.size='10'
	e1.maxlength='30';
	e1.value='';
	cellRight1.appendChild(e1);

	}


function removeRowIntakeDetails()
{
  var tbl = document.getElementById('intakeOutput1');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('intakeOutputId1count');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("intakeId"+i)!=null && (typeof  document.getElementById("intakeId"+i).checked)!='undefined' && document.getElementById("intakeId"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("intakeId"+i)!=null && (typeof  document.getElementById("intakeId"+i).checked)!='undefined' && document.getElementById("intakeId"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("intakeId"+i).parentNode.parentNode;
    		  document.getElementById("intakeId"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}



function addRowOutputDetails(){
	var tbl = document.getElementById('intakeOutput2');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('intakeOutput2Count');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='outputId'+iteration;
	e1.id='outputId'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=OUTPUT_DATE%>'+iteration;
	e3.id='<%=OUTPUT_DATE%>'+iteration;
	e3.value='<%=date%>';
	e3.size='8'
	cellRight1.appendChild(e3);
	var e2 = document.createElement('img');
	e2.width = '16';
	e2.height = '16';
	e2.src='/hms/jsp/images/cal.gif';
	e2.onclick=function(){setdate('<%=date%>',e3,event)};
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=OUTPUT_TIME%>'+iteration;
	e1.id='<%=OUTPUT_TIME%>'+iteration;
	e1.size='6'
	e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='<%=time%>';
	e1.maxlength=5;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='bleedingpvo'+iteration;
	e1.id='bleedingpvo'+iteration;
	e1.maxLength='3';
	e1.value='';
	 e1.onblur=function(){calculateTotalOutputDetails(this,iteration)};
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=DRAIN%>'+iteration;
	e1.id='<%=DRAIN%>'+iteration;
	e1.maxLength='3';
	e1.value='';
	 e1.onblur=function(){calculateTotalOutputDetails(this,iteration)};

	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='urine'+iteration;
	e1.id='urine'+iteration;
	e1.maxLength='3';
	e1.size='5';
	e1.value='';
	 e1.onblur=function(){calculateTotalOutputDetails(this,iteration)};
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);	
	/* var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='stool'+iteration;
	e1.id='stool'+iteration;
	e1.maxlength='20';
	e1.onchange=function(){checkStoolValidation(this.value)};
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/ml'; */

	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='vom'+iteration;
	e1.id='vom'+iteration;
	e1.maxLength='3';
	e1.size='5';
	e1.value='';
	 e1.onblur=function(){calculateTotalOutputDetails(this,iteration)};
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='asp'+iteration;
	e1.id='asp'+iteration;
	e1.maxLength='3';
	e1.size='5';
	e1.value='';
	 e1.onblur=function(){calculateTotalOutputDetails(this,iteration)};
	cellRight1.appendChild(e1);
	var textNode=document.createTextNode("/ml");
	cellRight1.appendChild(textNode);
	
	 var cellRight1 = row.insertCell(8);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='outputtotal'+iteration;
		e1.id='outputtotal'+iteration;
		e1.maxLength='10';
		e1.size='5';
		e1.value='';
		e1.readOnly=true;
		cellRight1.appendChild(e1);
		var textNode=document.createTextNode("/ml");
		cellRight1.appendChild(textNode);
		
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=OUTPUT_REMARKS%>'+iteration;
	e1.id='<%=OUTPUT_REMARKS%>'+iteration;
	e1.maxLength='20';
	e1.value='';
	cellRight1.appendChild(e1);

	}


function removeRowOutputDetails()
{
  var tbl = document.getElementById('intakeOutput2');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('intakeOutput2Count');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("outputId"+i)!=null && (typeof  document.getElementById("outputId"+i).checked)!='undefined' && document.getElementById("outputId"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("outputId"+i)!=null && (typeof  document.getElementById("outputId"+i).checked)!='undefined' && document.getElementById("outputId"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("outputId"+i).parentNode.parentNode;
    		  document.getElementById("outputId"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}


function addRowCommon1Details(){
	var tbl = document.getElementById('intakeOutput3');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('intakeOutput3Count');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='commonsecond'+iteration;
	e1.id='commonsecond'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='common2date'+iteration;
	e3.id='common2date'+iteration;
	e3.value='<%=date%>';
	e3.size='8'
	cellRight1.appendChild(e3);
	var e2 = document.createElement('img');
	e2.width = '16';
	e2.height = '16';
	e2.src='/hms/jsp/images/cal.gif';
	e2.onclick=function(){setdate('<%=date%>',e3,event)};
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=GIRTH_TIME%>'+iteration;
	e1.id='<%=GIRTH_TIME%>'+iteration;
	e1.size='6'
	e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='<%=time%>';
	e1.maxlength=5;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=GIRTH%>'+iteration;
	e1.id='<%=GIRTH%>'+iteration;
	e1.maxlength='20';
	e1.size='5';
	e1.value='';
	e1.onchange=function(){checkGirthValidation(this.value)};
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/cm';
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BLOOD_SUGAR%>'+iteration;
	e1.id='<%=BLOOD_SUGAR%>'+iteration;
	e1.maxlength='20';
	e1.size='5';
	e1.value='';
	e1.onchange=function(){checkBloodValidation(this.value)};
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/mg';
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=INSULIN%>'+iteration;
	e1.id='<%=INSULIN%>'+iteration;
	e1.maxlength='20';
	e1.size='5';
	e1.value='';
	e1.onchange=function(){checkInsulinValidation(this.value)};
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/I.V.';
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=DRAIN_REMARKS%>'+iteration;
	e1.id='<%=DRAIN_REMARKS%>'+iteration;
	e1.maxlength='30';
	e1.value='';
	cellRight1.appendChild(e1);

	}


function removeRowCommon1Details()
{
  var tbl = document.getElementById('intakeOutput3');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('intakeOutput3Count');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("commonsecond"+i)!=null && (typeof  document.getElementById("commonsecond"+i).checked)!='undefined' && document.getElementById("commonsecond"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("commonsecond"+i)!=null && (typeof  document.getElementById("commonsecond"+i).checked)!='undefined' && document.getElementById("commonsecond"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("commonsecond"+i).parentNode.parentNode;
    		  document.getElementById("commonsecond"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}

var totalIntakeOutput=0;
function submitIntakeOutput()
{
	totalIntakeOutput=0;
	/* checkValidationForCommonDetails(); */
	checkValidationForIntakeDetails();
	checkValidationForOutputDetails();
	/* checkValidationForCommon1Details(); */
	if(totalIntakeOutput==0)
		{
		alert('Please Enter some details to submit');
		return;
		}
	submitForm('intakeOutput','ipd?method=submitIntakeOutput');
}


function checkValidationForCommonDetails()
{
	var count = document.getElementById('intakeOutputIdcount').value;
	for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("common"+i)!=null)
			   {
			   document.getElementById('<%=TEMPERATURE%>'+i).setAttribute("validate", "Temperature,float,no");
			   document.getElementById('<%=PULSE%>'+i).setAttribute("validate", "Pulse,int,no");
			   document.getElementById('<%=RESPIRATION%>'+i).setAttribute("validate", "Respiration,float,no");
			   document.getElementById('<%=BP%>pre'+i).setAttribute("validate", "BP,int,no");
			   document.getElementById('<%=BP%>post'+i).setAttribute("validate", "BP,int,no");
			   document.getElementById('<%=BOWEL%>'+i).setAttribute("validate", "Bowel,string,no");
			   document.getElementById('<%=PAIN%>'+i).setAttribute("validate", "Pain,string,no");
			  <%--  document.getElementById('<%=FHR%>'+i).setAttribute("validate", "Fhr,int,no"); --%>
			   document.getElementById('<%=TEMPERATURE_REMARKS%>'+i).setAttribute("validate", "Temperature Remarks,string,no");
			   if(document.getElementById('<%=TEMPERATURE%>'+i).value!='' ||
					   document.getElementById('<%=PULSE%>'+i).value!='' ||
					   document.getElementById('<%=RESPIRATION%>'+i).value!='' ||
					   document.getElementById('<%=BP%>pre'+i).value!='' ||
					   document.getElementById('<%=BP%>post'+i).value!='' ||
					   document.getElementById('<%=BOWEL%>'+i).value!='' ||
					   document.getElementById('<%=PAIN%>'+i).value!='' ||
					  <%--  document.getElementById('<%=FHR%>'+i).value!='' || --%>
					   document.getElementById('<%=TEMPERATURE_REMARKS%>'+i).value!='')
				   {
				   document.getElementById('<%=TEMPERATURE_DATE%>'+i).setAttribute("validate", "Temperature Date,date,yes");
				   document.getElementById('<%=TEMPERATURE_TIME%>'+i).setAttribute("validate", "Temperature Time,time,yes");
				   }
			   else
				   {
				   document.getElementById('<%=TEMPERATURE_DATE%>'+i).setAttribute("validate", "Temperature Date,date,no");
				   document.getElementById('<%=TEMPERATURE_TIME%>'+i).setAttribute("validate", "Temperature Time,time,no");
				   }
			   if(document.getElementById('<%=BP%>pre'+i).value!='')
				   {
				   document.getElementById('<%=BP%>post'+i).setAttribute("validate", "BP,int,yes");
				   }
			   		else  if(document.getElementById('<%=BP%>post'+i).value!='')
			  		 {
			   			document.getElementById('<%=BP%>pre'+i).setAttribute("validate", "BP,int,yes");
			  		 }
			   }
		}
}


function checkValidationForIntakeDetails()
{
	var count = document.getElementById('intakeOutputId1count').value;
	for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("intakeId"+i)!=null)
			   {
			   document.getElementById('<%=ORAL%>'+i).setAttribute("validate", "Oral,int,no");
			   document.getElementById('<%=IV%>'+i).setAttribute("validate", "I.V.,int,no");
			   document.getElementById('ryles'+i).setAttribute("validate", "RYLE's Tube,float,no");
			   document.getElementById('total'+i).setAttribute("validate", "Total,string,no");
			   document.getElementById('<%=INTAKE_REMARKS%>'+i).setAttribute("validate", "Intake Remarks,string,no");
			   if(document.getElementById('<%=ORAL%>'+i).value!='' ||
					   document.getElementById('<%=IV%>'+i).value!='' ||
					   document.getElementById('ryles'+i).value!='' ||
					   document.getElementById('total'+i).value!='' ||
					   document.getElementById('<%=INTAKE_REMARKS%>'+i).value!='' )
				   {
				   totalIntakeOutput=totalIntakeOutput+1;
				   document.getElementById('<%=INTAKE_DATE%>'+i).setAttribute("validate", "Intake Date,date,yes");
				   document.getElementById('<%=INTAKE_TIME%>'+i).setAttribute("validate", "Intake Time,time,yes");
				   }
			   else
				   {
				   document.getElementById('<%=INTAKE_DATE%>'+i).setAttribute("validate", "Intake Date,date,no");
				   document.getElementById('<%=INTAKE_TIME%>'+i).setAttribute("validate", "Intake Time,time,no");
				   }
			   }
		}
}


function checkValidationForOutputDetails()
{
	var count = document.getElementById('intakeOutput2Count').value;
	for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("outputId"+i)!=null)
			   {
			   document.getElementById('bleedingpvo'+i).setAttribute("validate", "Bleeding PVO,int,no");
			   document.getElementById('<%=DRAIN%>'+i).setAttribute("validate", "Drain,int,no");
			   document.getElementById('urine'+i).setAttribute("validate", "Urine,int,no");
			 /*   document.getElementById('stool'+i).setAttribute("validate", "Stool,int,no"); */
			   document.getElementById('vom'+i).setAttribute("validate", "Vom,int,no");
			   document.getElementById('asp'+i).setAttribute("validate", "Asp,int,no");
			   document.getElementById('<%=OUTPUT_REMARKS%>'+i).setAttribute("validate", "Output Remarks,string,no");
			   if(document.getElementById('bleedingpvo'+i).value!='' ||
					   document.getElementById('<%=DRAIN%>'+i).value!='' ||
					   document.getElementById('urine'+i).value!='' ||
					   /* document.getElementById('stool'+i).value!='' || */
					   document.getElementById('vom'+i).value!='' ||
					   document.getElementById('asp'+i).value!='' ||
					   document.getElementById('<%=OUTPUT_REMARKS%>'+i).value!='' )
				   {
				   totalIntakeOutput=totalIntakeOutput+1;
				   document.getElementById('<%=OUTPUT_DATE%>'+i).setAttribute("validate", "Output Date,date,yes");
				   document.getElementById('<%=OUTPUT_TIME%>'+i).setAttribute("validate", "Output Time,time,yes");
				   }
			   else
				   {
				   document.getElementById('<%=OUTPUT_DATE%>'+i).setAttribute("validate", "Output Date,date,no");
				   document.getElementById('<%=OUTPUT_TIME%>'+i).setAttribute("validate", "Output Time,time,no");
				   }
			   }
		}
}

function checkValidationForCommon1Details()
{
	var count = document.getElementById('intakeOutput3Count').value;
	for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("commonsecond"+i)!=null)
			   {
			   document.getElementById('<%=GIRTH%>'+i).setAttribute("validate", "Grith,int,no");
			   document.getElementById('<%=BLOOD_SUGAR%>'+i).setAttribute("validate", "Blood Suger,int,no");
			   document.getElementById('<%=INSULIN%>'+i).setAttribute("validate", "Insuline,int,no");
			   document.getElementById('<%=DRAIN_REMARKS%>'+i).setAttribute("validate", "Remarks,string,no");
			   if(document.getElementById('<%=DRAIN%>'+i).value!='' ||
					   document.getElementById('<%=BLOOD_SUGAR%>'+i).value!='' ||
					   document.getElementById('<%=INSULIN%>'+i).value!='' ||
					   document.getElementById('<%=DRAIN_REMARKS%>'+i).value!='')
				   {
				   document.getElementById('common2dat'+i).setAttribute("validate", "Common Details Date,date,yes");
				   document.getElementById('<%=GIRTH_TIME%>'+i).setAttribute("validate", "Common Details Time,time,yes");
				   }
			   else
				   {
				   document.getElementById('common2dat'+i).setAttribute("validate", "Common Details Date,date,no");
				   document.getElementById('<%=GIRTH_TIME%>'+i).setAttribute("validate", "Common Details Time,time,no");
				   }
			   }
		}
}

function calculateTotalIntakeDetails(currentObj,i)
{
	var total=0;
	
	if(document.getElementById('oral'+i).value.trim()!='' && isInteger(document.getElementById('oral'+i).value))
		{
		total = total+parseInt(document.getElementById('oral'+i).value.trim());
		}
	
	if(document.getElementById('iv'+i).value.trim()!='' && isInteger(document.getElementById('iv'+i).value))
	{
	total = total+parseInt(document.getElementById('iv'+i).value.trim());
	}
	
	if(document.getElementById('ryles'+i).value.trim()!='' && isInteger(document.getElementById('ryles'+i).value))
	{
	total = total+parseInt(document.getElementById('ryles'+i).value.trim());
	}
	
	 document.getElementById('total'+i).value=total;

	 /*if(currentObj.value.trim()!='' && isInteger(currentObj.value))
		{
	if(document.getElementById('total'+i).value=='')
		{
		document.getElementById('total'+i).value=parseInt(currentObj.value);
		}
	else
		{
		document.getElementById('total'+i).value=parseInt(document.getElementById('total'+i).value)+parseInt(currentObj.value);
		}
		} */
	
	
}

function calculateTotalOutputDetails(currentObj,i)
{
	
var total=0;
	
	if(document.getElementById('bleedingpvo'+i).value.trim()!='' && isInteger(document.getElementById('bleedingpvo'+i).value))
		{
		total = total+parseInt(document.getElementById('bleedingpvo'+i).value.trim());
		}
	
	if(document.getElementById('drain'+i).value.trim()!='' && isInteger(document.getElementById('drain'+i).value))
	{
	total = total+parseInt(document.getElementById('drain'+i).value.trim());
	}
	
	if(document.getElementById('urine'+i).value.trim()!='' && isInteger(document.getElementById('urine'+i).value))
	{
	total = total+parseInt(document.getElementById('urine'+i).value.trim());
	}
	
	if(document.getElementById('vom'+i).value.trim()!='' && isInteger(document.getElementById('vom'+i).value))
	{
	total = total+parseInt(document.getElementById('vom'+i).value.trim());
	}
	
	if(document.getElementById('asp'+i).value.trim()!='' && isInteger(document.getElementById('asp'+i).value))
	{
	total = total+parseInt(document.getElementById('asp'+i).value.trim());
	}
	
	 document.getElementById('outputtotal'+i).value=total;
	 
	 
	/* if(currentObj.value.trim()!='' && isInteger(currentObj.value))
		{
	if(document.getElementById('outputtotal'+i).value=='')
		{
		document.getElementById('outputtotal'+i).value=parseInt(currentObj.value);
		}
	else
		{
		document.getElementById('outputtotal'+i).value=parseInt(document.getElementById('outputtotal'+i).value)+parseInt(currentObj.value);
		}
		}	 */
}

function isInteger(x) {
    return x % 1 === 0;
}


	</script>
<div class="clear"></div></form>
<div class="paddingTop40"></div>