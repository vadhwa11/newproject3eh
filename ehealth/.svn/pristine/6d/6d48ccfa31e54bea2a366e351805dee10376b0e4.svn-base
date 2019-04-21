
<%--
	* Copyright 2008 JK Technosoft Ltd. All rights reserved.
	* Use is subject to license terms.
	* showPatientList.jsp
	* Purpose of the JSP -  This is Show Patient List.
	* @author  Deepti
	* @author  Ritu
	* Create Date: 21st Feb,2008
	* Revision Date:
	* Revision By:
	* @version 1.15
	--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="java.text.SimpleDateFormat"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	int waitingCount = 0;
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	List inPatientSet = new ArrayList();
	try {
	if(map.get("takeSetFromSessionInJsp")!=null)
	{
	String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");

	inPatientSet=(List)map.get("inPatientSet");

	}

	} catch (Exception exp) {
	exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	if (map.get("waitingCount") != null) {
	waitingCount = Integer.parseInt(""+map.get("waitingCount")) ;
	}
	%>

<div class="titleBg">
<h2>Nursing Station</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>
<%if(waitingCount !=0){ %>
<span><%=waitingCount%> Patients are waiting for Acknowledgement</span>
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<label>Reg No</label> <input
	type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"
	MAXLENGTH="30" tabindex=1 /> <label>IP No.</label> <select
	name="<%=RequestConstants.ADMISSION_NUMBER%>" id="admissionNo">
	<option value="0">Select</option>
	<%
	try{
	if(inPatientSet.size()>0){
	Iterator itr=inPatientSet.iterator();
	while(itr.hasNext()){
	Inpatient inpatient= (Inpatient) itr.next();
	if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
	{
	%>
	<option value=<%=inpatient.getId()%>><%=inpatient.getAdNo()%></option>
	<%
	}
	}
	}
	}catch(Exception e){
	e.printStackTrace();

	}
	%>
</select>
<div class="clear"></div>

<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="if(checkBlankForPatientSearch()){submitForm('search','ipd?method=searchPatient');}" />
 


 </form>
</div>

<%
	if(map.get("message") != null){
	String message = (String)map.get("message");
	out.println(message);
	}
	%>

<div class="clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<form name="patientList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="leftMenu">Ward Management



<div class="clear"></div>
<input type="image" src="/hms/jsp/images/buttonIcons/clinicalSetup.jpg"
	onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');"
	class="button" height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/nursingEntry.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showNursingCareEntryJsp');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/clinicalChart.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showNursingClinicalChartJsp');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/intakeOutput.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showIntakeOutputJsp','validateRadio');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/dischargeSummary.jpg" class="button"
	onClick="submitForm('patientList','discharge?method=showDischargeInputJsp','validateICard');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/wardConsumption.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showWardList');"
	height="34" width="188" /> <!-- <input type="image" src="/hms/jsp/images/buttonIcons/foodTasting.jpg" class="button" onClick="submitForm('patientList','ipd?method=showFoodTastingJsp');" height="34" width="188" /> -->

<input type="image" src="/hms/jsp/images/buttonIcons/patientIssue.jpg"
	class="button"
	onClick="submitForm('patientList','ipd?method=showPatientIssueJsp','validateRadio');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/monthlyIndent.jpg" class="button"
	onClick="submitForm('patientList','stores?method=showDepartmentIndentJsp');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showPatientDiagnosisJsp','validateRadio');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/silDil.jpg" class="button"
	onClick="submitForm('patientList','ipd?method=showSilDilJsp','validateRadio');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/patientTransfer.jpg" class="button"
	onClick="submitForm('patientList','/hms/hms/adt?method=getTransferScreen','validateRadio');"
	height="34" width="188" /> 
	<!-- <input type="image" src="/hms/jsp/images/buttonIcons/patientDischarge.jpg" class="button" onClick="submitForm('patientList','/hms/hms/adt?method=getDischargeScreen','validatePatientDischarge');" height="34" width="188" /> -->
	 <!-- <input type="image" src="/hms/jsp/images/buttonIcons/newAdmission.jpg" class="button" onClick="submitForm('patientList','/hms/hms/ipd?method=showWaitingList');" height="34" width="188" /> -->

<input type="image" src="/hms/jsp/images/buttonIcons/dailyRemarks.jpg"
	class="button"
	onClick="submitForm('patientList','/hms/hms/ipd?method=showWardRemarksJsp');"
	height="34" width="188" /> <input type="image"
	src="/hms/jsp/images/buttonIcons/investigationRecognition.jpg"
	class="button"
	onClick="submitForm('patientList','lab?method=showOrderBookingJsp','validateRadio');"
	height="34" width="188" /></div>




<div class="floatRight">
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="smallCmntable"></div>
<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.HIN_NO%>"],[3,"<%= RequestConstants.ADMISSION_NUMBER%>"], [4,"<%= RequestConstants.PATIENT_NAME %>"], [5,"<%= RequestConstants.SERVICE_NUMBER %>"],[6,"<%= RequestConstants.AGE %>"],[7,"<%= RequestConstants.SEX %>"],[8,"<%=RequestConstants.HIN_NO%>"],[9,"<%= RequestConstants.PATIENT_DIAGNOSIS %>"],[10,"<%=RequestConstants.DATE_OF_ADMISSION%>"],[11,"<%=RequestConstants.ADMISSION_STATUS%>"],[12,"<%=RequestConstants.I_CARD_VERIFIED%>"],[13,"<%=RequestConstants.SILORDIL%>"],[14,'finalBillDetail'] ];
	statusTd =14;

	</script></div>
<div id="edited"></div>
<div id="statusMessage">
<h4></h4>
</div>
</div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "radio";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	data_header[1][3] = "<%= RequestConstants.HIN_NO%>"



	data_header[2] = new Array;
	data_header[2][0] = "IPD No."
	data_header[2][1] = "data";
	data_header[2][2] = "8%";
	data_header[2][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"

	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "<%= RequestConstants.PATIENT_NAME %>";

	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";
	data_header[4][3] = "<%=RequestConstants.SERVICE_NUMBER %>";

	data_header[5] = new Array;
	data_header[5][0] = "Sex"
	data_header[5][1] = "data";
	data_header[5][2] = "6%";
	data_header[5][3] = "<%=RequestConstants.AGE %>";

	data_header[6] = new Array;
	data_header[6][0] = "Relation"
	data_header[6][1] = "hide";
	data_header[6][2] = "5%";
	data_header[6][3] = "<%=RequestConstants.SEX %>";



	data_header[7] = new Array;
	data_header[7][0] = "Service No"
	data_header[7][1] = "hide";
	data_header[7][2] = "5%";
	data_header[7][3] = "<%=RequestConstants.PATIENT_DEPARTMENT %>";

	data_header[8] = new Array;
	data_header[8][0] = "Rank"
	data_header[8][1] = "hide";
	data_header[8][2] = "10%";
	data_header[8][3] = "<%=RequestConstants.PATIENT_DIAGNOSIS %>";

	data_header[9] = new Array;
	data_header[9][0] = "S Name"
	data_header[9][1] = "hide";
	data_header[9][2] = "6%";
	data_header[9][3] = "<%=RequestConstants.DATE_OF_ADMISSION %>";



	data_header[10] = new Array;
	data_header[10][0] = "Adm Date"
	data_header[10][1] = "data";
	data_header[10][2] = "1%";
	data_header[10][3] = "<%=RequestConstants.ADMISSION_STATUS %>";

	data_header[11] = new Array;
	data_header[11][0] = "Status"
	data_header[11][1] = "data";
	data_header[11][2] = "10%";
	data_header[11][3] = "<%=RequestConstants.SILORDIL %>";

	data_header[12] = new Array;
	data_header[12][0] = "I-Card Status"
	data_header[12][1] = "hide";
	data_header[12][2] = "1%";
	data_header[12][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";

	data_header[13] = new Array;
	data_header[13][0] = "Final Bill Detail"
	data_header[13][1] = "hide";
	data_header[13][2] = "1%";
	data_header[13][3] = "finalBillDetail";

	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	Iterator iterator=inPatientSet.iterator();
	while(iterator.hasNext())
	{
	Inpatient inpatient= (Inpatient) iterator.next();
	if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
	{
	Patient patientHin=(Patient)inpatient.getHin();
	MasDepartment deptObj=(MasDepartment)inpatient.getDepartment();
	String adStatus=inpatient.getAdStatus();
	String newIcnName="";
	int dischargeId =0;


	MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
	String dateOfAdmissionInString =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());

	%>

	data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] =<%=patientHin.getHinNo()%>

	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= inpatient.getId()%>" id="parent" />'

	<%
	if(patientHin.getHinNo()!=null || patientHin.getHinNo() !="")
	{
	%>
	data_arr[<%= i%>][2] = "<%=patientHin.getHinNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][2] = ""
	<%
	}
  	if(inpatient.getAdNo()!=null || inpatient.getAdNo() !="")
	{
	%>
	data_arr[<%= i%>][3] = "<%=inpatient.getAdNo()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3] = ""
	<%
	}

	String ptName ="";
	String fPtName ="";
	String mPtName ="";
	String lPtName ="";
	if(patientHin.getPFirstName()!=null){
		fPtName=patientHin.getPFirstName();
	}
	if(patientHin.getPMiddleName()!=null){
		mPtName=patientHin.getPMiddleName();
	}else{
		mPtName="";
	}
	if(patientHin.getPLastName()!=null){
		lPtName=patientHin.getPLastName();
	}
	ptName=fPtName+" "+mPtName+" "+lPtName;
	try{
	if(ptName.length() >9){
	ptName= ptName.substring(0,9)+" "+ptName.substring(10,ptName.length());
	}
	}catch(Exception ee){
	ee.printStackTrace();
	}%>
	data_arr[<%= i%>][4] = "<%=ptName%>"
	<%if(inpatient.getAge()!= null || inpatient.getAge()!= "")
	{
	%>
	data_arr[<%= i%>][5] = "<%=inpatient.getAge()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][5] = ""
	<%
	}if(masAdministrativeSex.getAdministrativeSexName()!= null || masAdministrativeSex.getAdministrativeSexName() != "")
	{
	%>
	data_arr[<%= i%>][6] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][6] = ""
	<%
	}
	if(patientHin.getRelation() != null)
	{
	%>
	data_arr[<%= i%>][7] = "<%=patientHin.getRelation().getRelationName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][7] = ""
	<%
	}
	if(patientHin.getServiceNo() != null )
	{
	%>
	<%
	String str ="";

	if(patientHin.getServiceNo().length() >9){
	str=patientHin.getServiceNo().substring(0,10)+" "+patientHin.getServiceNo().substring(11,patientHin.getServiceNo().length());
	}else{
	str=patientHin.getServiceNo();
	}
	%>
	data_arr[<%= i%>][8] = "<%=str%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""
	<%} if(patientHin.getRank() !=null){%>
	data_arr[<%= i%>][9] = "<%=patientHin.getRank().getRankName()%>"
	<%}else{%>
	data_arr[<%= i%>][9] = ""

	<%}%>
	<%
	if(patientHin.getSFirstName() != null)
	{
	%>
	data_arr[<%= i%>][10] = "<%=patientHin.getSFirstName()+" "+patientHin.getSMiddleName()+" "+patientHin.getSLastName()%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][10] = ""
	<%   }if(inpatient.getDateOfAddmission() != null && !inpatient.getDateOfAddmission().equals("")){
	String date ="";
	try{
	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
	date=formatterOut.format(formatterIn.parse(""+inpatient.getDateOfAddmission()));
	}catch(Exception e){
	e.printStackTrace();
	}
	%>
	data_arr[<%= i%>][11] = "<%=date%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][11] = ""
	<%}
	int dilStatusId=0;
	String silDilStatus ="";
	if(inpatient.getSilDilStatus() != null){
	Set<SilDilStatus> set2=(Set<SilDilStatus>)inpatient.getSilDilStatus();
	for(SilDilStatus dilStatus :set2){
	if(dilStatus.getInpatient().getId()==inpatient.getId())
	{
	if(dilStatus.getId()>dilStatusId){
	silDilStatus=""+dilStatus.getConditionStatus();
	dilStatusId=dilStatus.getId();

	}
	}
	}
	if(silDilStatus.equals("")){
	silDilStatus="Normal";
	}
	%>
	data_arr[<%= i%>][12] = "<%=silDilStatus%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][12] = "Normal"
	<%}%>
	data_arr[<%= i%>][13] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=patientHin.getServiceCardStatus()%>"  />'

	<%
	String statusForFinalBill="";
	Set<BlFinalBillDetails> set22=(Set<BlFinalBillDetails>)inpatient.getBlFinalBillDetails();

	for(BlFinalBillDetails blFinalDetails :set22){
		if(blFinalDetails.getInpatient().getId()==inpatient.getId())
		{
			statusForFinalBill=blFinalDetails.getStatus();

		}
	}
	%>
	data_arr[<%= i%>][13] = '<input type="hidden" id="finalBillDetail<%=i%>"  name="finalBillDetail<%=i%>" value="<%=statusForFinalBill%>"  />'



	<%
	i++;
	}
	}

	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "patientList"


	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">

	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;

	}

	function validatePatientDischarge(){


	for(var i = 0; i < document.getElementsByName('parent').length; i++){

		if(document.getElementsByName('parent')[i].checked == true)
		{

			var status=document.getElementById('finalBillDetail'+i).value

			if(status =="s")
			{

			return true;
			}else{
				alert("Patient Cannot Be Discharged Without Final Bill Settlement.")
				return false;
			}
	   }
	 }
	alert("Please select the patient")
	return false;

	}


	</script></form>

