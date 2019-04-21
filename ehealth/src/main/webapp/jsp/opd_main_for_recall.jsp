
<%@page import="java.lang.reflect.Array"%>
<%@page import="jkt.hms.masters.business.PhAncSurvey"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.DietDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="jkt.hms.masters.business.MasInstructionMaster"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>

<script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}

		List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
		List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
		
		List<OpdPatientSecondOpinion> secondpoinionList=new ArrayList<OpdPatientSecondOpinion>();
		
		String secondOpinoinComment="";
		  
		if(map.get("secondpoinionList") != null){
			secondpoinionList=(List<OpdPatientSecondOpinion>)map.get("secondpoinionList");
		}
		if(null !=secondpoinionList && secondpoinionList.size()>0 ){
			for(OpdPatientSecondOpinion secondOpinion:secondpoinionList){
			secondOpinoinComment=secondOpinion.getOpinoinNotes();
			}
		}
		
		List<String>patientWiseMlcs=new ArrayList<String>();
		if(map.get("patientWiseMlcs") != null){
			patientWiseMlcs=(List)map.get("patientWiseMlcs");
		} 
		
		
		if(map.get("allergyProductsList") != null){
			allergyProductsList=(List)map.get("allergyProductsList");
		}
		
		if(map.get("saverityCodesList") != null){
			saverityCodesList=(List)map.get("saverityCodesList");
		} 
		
		List<MasDepartment> wardDepartmentList = new   ArrayList<MasDepartment>();
		if(map.get("wardDepartment") != null)
		{
			wardDepartmentList=(List<MasDepartment>)map.get("wardDepartment");
		}
		List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
		if(map.get("routeOfAdministrationList") != null)
		{
			routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
		}
		List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
		if(map.get("masInstructionMasterList") != null)
		{
		  masInstructionMasterList=(List<OpdInstructionTreatment>)map.get("masInstructionMasterList");
		}
		List<MedicoLegalDetails>mlcList = new ArrayList<MedicoLegalDetails>();
		if(map.get("mlcList") != null)
		{
			mlcList=(List<MedicoLegalDetails>)map.get("mlcList");
		}
		
		String comorbidityStr ="";
		if(map.get("comorbidityStr") != null)
		{
			comorbidityStr=(String)map.get("comorbidityStr");
		}
		
		String allergyStr ="";
		if(map.get("allergyStr") != null)
		{
			allergyStr=(String)map.get("allergyStr");
		}
		
		
	  	List<MasDistrict> masDistrictList = new   ArrayList<MasDistrict>();
	  	if(map.get("masDistricts") != null)
		{
	  		masDistrictList=(List<MasDistrict>)map.get("masDistricts");
		}
	  	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	  	if(map.get("hospitalTypeList") != null)
		{
	  		hospitalTypeList=(List<MasHospitalType>)map.get("hospitalTypeList");
		}
	  	List<MasHospital>masHospitals=new ArrayList<MasHospital>();
	  	if(map.get("masHospitals") != null)
		{
	  		masHospitals=(List<MasHospital>)map.get("masHospitals");
		}
	  	OpdPatientDetails opdPatientDetails = null;
		String lastEncounterDetail = "";
		
		Integer opdpatientDetailId=0;
		int referralDept=0;
		int referralHospital=0;
		int referralDistrict=0;
		String referralType="NA";
		String deptNameforExternal="NA";
		if(map.get("opdPatientDetails") != null)
		{
			opdPatientDetails=(OpdPatientDetails)map.get("opdPatientDetails");
			opdpatientDetailId=opdPatientDetails.getId();
			referralDept = opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getId():0;
			referralHospital = opdPatientDetails.getHospital().getId();
			referralDistrict = opdPatientDetails.getReferedDistrict() != null? opdPatientDetails.getReferedDistrict().getId():0;
			referralType = opdPatientDetails.getReferredType() != null?opdPatientDetails.getReferredType():"NA";
			deptNameforExternal = opdPatientDetails.getReferredDept() !=null?opdPatientDetails.getReferredDept().getDepartmentName():"NA";
			
		}
		
		
		
		//out.print("opdpatientDetailId="+opdpatientDetailId);
		if(map.get("lastEncounterDetail") != null)
		{
			lastEncounterDetail=(String)map.get("lastEncounterDetail");
		}
		List<DischargeIcdCode> dischargeIcdCodeLast3Visit = new ArrayList<DischargeIcdCode>();
		List<DgOrderdt> dgOrderdts= new ArrayList<DgOrderdt>();
		List<PatientPrescriptionDetails> patientPrescriptionDetails= new ArrayList<PatientPrescriptionDetails>(); 
		if(map.get("dischargeIcdCodeLast3Visit") != null)
		{
			dischargeIcdCodeLast3Visit=(List<DischargeIcdCode>)map.get("dischargeIcdCodeLast3Visit");
		}
		if(map.get("patientPrescriptionDetails") != null)
		{
			patientPrescriptionDetails=(List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetails");
		} 
		if(map.get("dgOrderdts") != null)
		{
			dgOrderdts=(List<DgOrderdt>)map.get("dgOrderdts");
		}
		List<DgSampleCollectionDetails> dgSampleCollectionDetails= new ArrayList<DgSampleCollectionDetails>();
		if(map.get("dgSampleCollectionDetails") != null)
		{
			dgSampleCollectionDetails=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetails");
		}
		List<PatientInvestigationDetails> patientInvestigationDetails= new ArrayList<PatientInvestigationDetails>();
		if(map.get("patientInvestigationDetails") != null)
		{
			patientInvestigationDetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetails");
		}
		
		List<OpdPatientAllergyT>opdPatientAllergyTs= new ArrayList<OpdPatientAllergyT>();
		if(map.get("opdPatientAllergyTs") != null)
		{
			opdPatientAllergyTs=(List<OpdPatientAllergyT>)map.get("opdPatientAllergyTs");
		}
		List<ProcedureDetails>procedureDetails= new ArrayList<ProcedureDetails>();
		if(map.get("procedureDetails") != null)
		{
			procedureDetails=(List<ProcedureDetails>)map.get("procedureDetails");
		}
		List<OpdSurgeryDetail>opdSurgeryDetails= new ArrayList<OpdSurgeryDetail>();
		if(map.get("opdSurgeryDetails") != null)
		{
			opdSurgeryDetails=(List<OpdSurgeryDetail>)map.get("opdSurgeryDetails");
		}
		
		List patientDataList = new ArrayList();
	  	Integer pulse=0;
	  	Float temperature=0f;
	  	String bpSystolicDiastolic="";
	  	Float bmi=0f;
	  	String bmiStatus="";
	  	Integer height=0;
	  	Double weight=0.0;
	  	String presentComplaintHistory="";
		String personalPresentHistory="";
		String familyPastHistory="";
		String madicationHistory="";
		String[] parts={"",""};
		String noSysDias="";
		OpdPatientDetails preOpdPatientDetails = new OpdPatientDetails();
	  	OpdPatientHistory preOpdPatientHistory = new OpdPatientHistory();
	  	if(map.get("opdPatientDetails") != null){
	  		preOpdPatientDetails=(OpdPatientDetails)map.get("opdPatientDetails");
	  		opdpatientDetailId=preOpdPatientDetails.getId();
	  		pulse=preOpdPatientDetails.getPulse()!=null?preOpdPatientDetails.getPulse():0;
	  		temperature=preOpdPatientDetails.getTemperature()!=null?preOpdPatientDetails.getTemperature():0f;
	  		bpSystolicDiastolic=preOpdPatientDetails.getBp()!=null?preOpdPatientDetails.getBp():"";
	  		if(!bpSystolicDiastolic.equals("") && bpSystolicDiastolic.indexOf("/")!=-1)
	  		{
	  		parts = bpSystolicDiastolic.split("/");
	  		}
	  		bmi=preOpdPatientDetails.getBmi()!=null?preOpdPatientDetails.getBmi():0f;
	  		height=preOpdPatientDetails.getHeight()!=null?preOpdPatientDetails.getHeight():0;
	  		weight=preOpdPatientDetails.getWeight()!=null?preOpdPatientDetails.getWeight():0;
	  		if(bmi>0)
	  		{
			if(bmi<18.5){
				 bmiStatus="Underweight";
			}else if(bmi>=18.5 && bmi<25){
				 bmiStatus="Healthy Range";
			}else if(bmi>=25 && bmi<=30){
				 bmiStatus="Overweight";
			}else if(bmi>=30 && bmi<=35){
				 bmiStatus="Obese";
			}else if(bmi>35){
				 bmiStatus="Severely obese";
			}
	  		}
	  		
		}
	  	String opdPatientHistoriesStr="";
	  	if(map.get("preOpdPatientHistory") != null){
	  		preOpdPatientHistory=(OpdPatientHistory)map.get("preOpdPatientHistory");	
	  		presentComplaintHistory=preOpdPatientHistory.getPresentComplaintHistory();
	  		personalPresentHistory=preOpdPatientHistory.getPersonalPresentHistory();
	  		familyPastHistory=preOpdPatientHistory.getFamilyPastHistory();
	  		madicationHistory=preOpdPatientHistory.getMadicationHistory();
	  		opdPatientHistoriesStr=preOpdPatientHistory.getPastIllnessHistory();
		}
	  		
	  	
		if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
		}

		List<MasStoreBrand> storeBrandList = new ArrayList<MasStoreBrand>();
		if(map.get("storeBrandList")!=null)
		{
		 storeBrandList = (List)map.get("storeBrandList");
		}

		Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> mapForDS= new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");
		String consultationDate = (String)utilMap.get("currentDate");
		String consultationTime = (String)utilMap.get("currentTime");

		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empDeptCodeForOPTH = properties.getProperty("empDeptCodeForOPTH");
		String empDeptCodeForGYNE = properties.getProperty("empDeptCodeForGYNE");


		
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		List<OpdTemplate>templateList= new ArrayList<OpdTemplate>();
		if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
		}
		List<OpdTemplate> templateListForInvestigation = new ArrayList<OpdTemplate>();
		if(map.get("templateListForInvestigation") != null){
			templateListForInvestigation=(List)map.get("templateListForInvestigation");
			}
		List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
		}
		List<MasDepartment> deptList= new ArrayList<MasDepartment>();
		if(map.get("deptList") != null){
		deptList=(List)map.get("deptList");
		}
		List<MasDepartment> masDepartmentList= new ArrayList<MasDepartment>();
		if(map.get("masDepartmentList") != null){
			masDepartmentList=(List)map.get("masDepartmentList");
		}
		
		
		List<MasSpecialtyTemplate> specialtyTemplateList = new ArrayList<MasSpecialtyTemplate>();
		if(map.get("specialtyTemplateList")!=null){
			specialtyTemplateList=(List<MasSpecialtyTemplate>)map.get("specialtyTemplateList");
	    }
		
	     List<MasDiet> dietList = new ArrayList<MasDiet>();
	    if(map.get("dietDataList")!=null)
	    {
	    	dietList = (List)map.get("dietDataList");

	    } 
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}
		int districtId=0;
		if(map.get("districtId")!=null)
	    {
			districtId = (Integer)map.get("districtId");
	    } 
		int hospitalTypeId=0;
		if(map.get("hospitalTypeId")!=null)
	    {
			hospitalTypeId = (Integer)map.get("hospitalTypeId");
	    } 
		
		Visit visit=null;
		if(patientDataList.size()>0){
			visit=(Visit)patientDataList.get(0);	
		}

		String patientName="";
		String age="";
		int patientAge=0;
		String gender="";
		
		/* Added By Amit Das */
		String patientRsbyCardNo = "";
		if(visit.getHin().getRsbyCardNo()!= null && !visit.getHin().getRsbyCardNo().trim().equals("")){
			patientRsbyCardNo=visit.getHin().getRsbyCardNo();
		}
		
		
		if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
		}
		if(visit.getHin().getAge()!= null){
			age=!visit.getHin().getAge().equals("")?visit.getHin().getAge():"";
			if(age.length()>0){
			patientAge=Integer.parseInt(age.split(" ")[0]);
			}
			}
		if(visit.getHin().getSex()!= null){
			gender=visit.getHin().getSex().getAdministrativeSexName();
		}
		String display="none";
		if(visit.getHin().getSex()!= null && visit.getHin().getSex().getAdministrativeSexCode().equals("F") && visit.getHin().getSex().getId()==2)
		{	display="block";}
		
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		int deptId=visit.getDepartment().getId();
		String departmentName=visit.getDepartment().getDepartmentName();
		String pragnancyStatus="";
		int pragnancyPeriod=0;
		if(map.get("patient_pregnancy_status")!=null ){
			pragnancyStatus=(String)map.get("patient_pregnancy_status");
		}
		if(map.get("patient_pregnancy_period")!=null ){
			pragnancyPeriod=(Integer)map.get("patient_pregnancy_period");
		}
		List<PhAncSurvey> phAncSurveyList =new ArrayList<PhAncSurvey>();
		if(map.get("phAncSurveyList") != null){
			phAncSurveyList = (List)map.get("phAncSurveyList");
		}
		PhAncSurvey phAncSurvey = null;
		if(phAncSurveyList.size()>0){
			phAncSurvey = phAncSurveyList.get(0);
		}
		%>

<!--main content placeholder starts here-->
<body onclick="parent_disable()">
	<form name="opdMain" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="userName" value="<%=userName %>" />
		<%if(visit.getDepartment()!= null){ %>
		<div class="titleBg">
			<h2><%=visit.getDepartment().getDepartmentName() %></h2>
		</div>
		<div class="clear"></div>
		<%} %>
		<script type="text/javascript">
		   var icdArray=new Array();
		   var icdArray1=new Array();
		   var brandArray=new Array();
		   var allergyTypeArray=new Array();
		   var saverityCodeArray=new Array();
</script>
		<div class="Block">

			<label>Patient Name</label><input type="text"
				value="<%=patientName%>" readonly="readonly" /> <label>Age</label><input
				type="text" class="dateTextSmall" value="<%=age%>"
				readonly="readonly" /> <label>Gender</label><input type="text"
				class="dateTextSmall" value="<%=gender%>" readonly="readonly" />
			<div class="clear"></div>



			<label>Allergy</label>
			<textarea style="height: 42px; width: 182px;" readonly="readonly"
				cols="0" rows="0" maxlength="300"><%=allergyStr %></textarea>
			<label>Comorbidity</label>
			<textarea name="comorbidity" class="comorBiditylarge"
				id="comorbidity" validate="comorbidity,string,no"
				readonly="readonly" cols="0" rows="0" maxlength="300"
				onkeyup="return checkLength(this)"><%=comorbidityStr %></textarea>
			<input type="button" class="buttonBig" id="patient_details"
				name="patient_details" value="Patient Details"
				onclick="patientDetails(csrfTokenName+'='+csrfTokenValue);" />

			<div class="clear"></div>
			<div class="paddingTop5">
				<%if(patientAge>=60){ %>
				<label>Physiological Status</label>
				<%}else{ %>
				<label style="display: <%=display%>">Physiological Status</label>
				<%} %>
				<div>
					<%if(patientAge>=60){ %>
					<label class="autoSpace"><input type="checkbox"
						name="geriatric" id="geriatric" checked="checked"
						class="radioCheckCol2">Geriatric case</label> <label class="auto">Remarks</label>
					<textarea name="phiso_remarks" id="phiso_remarks"
						validate="remarks,string,no" cols="0" rows="0" maxlength="300"
						onkeyup="return checkLength(this)"></textarea>
						
						<%}else if(phAncSurvey != null){ %>
					
						<label class="autoSpace"><input type="checkbox"
							name="preganancy" checked="checked" id="preganancy"
							class="radioCheckCol2">Pregnancy </label>
						<label>LMP Date</label>
						<input type="text" name="lmpDate"  value="<%=phAncSurvey != null && phAncSurvey.getLmpDate() != null ?HMSUtil.convertDateToStringWithoutTime(phAncSurvey.getLmpDate()):""%>"/>
						<label>EDC Date</label>
						<input type="text" name="edcDate"  value="<%=phAncSurvey != null && phAncSurvey.getEdcDate() != null ?HMSUtil.convertDateToStringWithoutTime(phAncSurvey.getEdcDate()):""%>"/>
						
						<label>Para</label>
						<input type="text" name="para"  value="<%=phAncSurvey != null && phAncSurvey.getParity() != null && phAncSurvey.getParity() != 0?phAncSurvey.getParity():""%>"/>
						
						<label>Gravida</label>
						<input type="text" name="gravida"  value="<%=phAncSurvey != null && phAncSurvey.getGravida() != null ? phAncSurvey.getGravida():""%>"/>
						
							
					<%}else{ %>
					<div style="display: <%=display%>">
						<%if(!pragnancyStatus.equals("")){ %>
						<label class="autoSpace"><input type="checkbox"
							name="preganancy" checked="checked" id="preganancy"
							class="radioCheckCol2">Pregnancy </label>
						<%}else{ %>
						<label class="autoSpace"><input type="checkbox"
							name="preganancy" id="preganancy" class="radioCheckCol2">Pregnancy
						</label>
						<%} %>
						<label class="auto">Period</label> <input type="text"
							class="dateTextSmall" placeholder="Period in week"
							value="<%=pragnancyPeriod!=0?pragnancyPeriod:"" %>" id="period"
							name="period"><label class="smallAuto autoSpace">in
							week</label> <label class="autoSpace"><input type="checkbox"
							name="lactation" id="lactation" class="radioCheckCol2">lactation</label>
						<label class="auto">Remarks</label>
						<textarea name="phiso_remarks" id="phiso_remarks"
							validate="remarks,string,no" cols="0" rows="0" maxlength="300"
							onkeyup="return checkLength(this)"></textarea>
					</div>
					<%} %>
				</div>
			</div>
			<%
  int docId=0;
  if(session!=null){
	  docId= (Integer)session.getAttribute("empId");
  }
 
  %>
			<div class="clear"></div>
		</div>

		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>
		<%String message ="This is MLC Case. Medico Legal Certificate is not generated."; 
if(opdPatientDetails!= null && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){
if(mlcList.size()>0){
%>
		<%}else{ %>
		<h4>
			<span><%=message %></span>
		</h4>
		<%}}else{%>
		<%} %>
		<div class="clear"></div>
		<!--tab content starts-->

		<!-- comment By rajendra :17-03-2015 -->

		<ul id="countrytabsIn" class="shadetabsInForOPDMain">
			<label><a href="#" rel="country1" class="selected"	onclick="checkTab(1);">OP Consultation</a></label>
			<label onclick="drawParkDiagnosisTable();"><a href="#"	rel="country2" onclick="checkTab(2);">Examination</a></label>
			<label><a href="#" rel="country3" onclick="checkTab(3);">Investigation/Other Services</a></label>
			<label><a href="#" rel="country4" onclick="checkTab(4);">Allergy</a></label>
			<label><a href="#" rel="country5" onclick="checkTab(5);">Treatment</a></label>
			<label><a href="#" rel="country6" onclick="checkTab(6);">Prescription</a></label>
			<label><a href="#" rel="country7" onclick="checkTab(7);">Comorbidity</a></label>
			<label><a href="#" rel="country8" onclick="checkTab(8);">Speciality</a></label>
			<%
		if(opdPatientDetails!= null  && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){%>
			<label id="mlcTab"><a href="#" rel="country9"	onclick="checkTab(9);">MLC</a></label>
		<%}else if(patientWiseMlcs.size()>0){ %>
			<label id="mlcTab"><a href="#" rel="country9" onclick="checkTab(9);">MLC</a></label>
		<%} else{%>
			<label id="mlcTab" style="display: none"><a href="#" rel="country9" onclick="checkTab(9);">MLC</a></label>
		<%} %>
		</ul>

		<input type="hidden" name="tab" id="tab" value="" />
		<div class="tabcontainerIn">
			<div id="country1" class="tabcontentIn">
				<div class="Block">
					<label style="vertical-align: baseline;"><img
						src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Data
							is part of EHR</span></label>
					<div class="clear"></div>

					<%if(opdPatientDetails!=null && opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId().equals(deptId))
	{
	%>
					<label>Referred by Doctor</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getFirstName():"" %>" />
					<input type="hidden" id="" name="" readonly="readonly" /> <label
						class="auto">Departement From</label> <input type="text" id=""
						name="" readonly="readonly"
						value="<%=opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getDepartmentName():"" %>" />
					<div class="clear"></div>
					<label>Hospital From</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getHospital()!=null?opdPatientDetails.getHospital().getHospitalName():"" %>" />

					<label class="auto">Date</label> <input type="text" class="date"
						readonly="readonly"
						value="<%=opdPatientDetails.getOpdDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getOpdDate()):"" %>" />

					<div class="clear"></div>
					<label>Doctor Note</label>
					<textarea cols="0" rows="0" maxlength="300" " readonly="readonly"><%=opdPatientDetails.getReferralNotes()!=null?opdPatientDetails.getReferralNotes():"" %>
 </textarea>

					<label>Patient Advice</label>
					<textarea cols="0" rows="0" maxlength="300" " readonly="readonly"><%=opdPatientDetails.getPatientAdvise()!=null?opdPatientDetails.getPatientAdvise():"" %>
 </textarea>
					<div class="clear"></div>
					<label>Summary Consultation</label>
					<textarea cols="0" rows="0" maxlength="490" readonly="readonly"><%=opdPatientDetails.getSummaryConsultation()!=null?opdPatientDetails.getSummaryConsultation():"" %>
 </textarea>
					<%} %>
					<%
List<Object[]> phDiseaseRegistrationFollowList = new ArrayList<Object[]>();
if(map.get("phDiseaseRegistrationFollowList") != null)
{
	phDiseaseRegistrationFollowList=(List<Object[]>)map.get("phDiseaseRegistrationFollowList");
}

if(null !=phDiseaseRegistrationFollowList && phDiseaseRegistrationFollowList.size()>0){
for(Object[] phDiseaseRegistrationFollow:phDiseaseRegistrationFollowList){%>
					<label>Referred by Doctor</label> <input type="text" id="" name=""
						readonly="readonly" value="" /> <input type="hidden" id=""
						name="" readonly="readonly" /> <label class="auto">Departement
						From</label> <input type="text" id="" name="" readonly="readonly" value="" />
					<div class="clear"></div>
					<label>Hospital From</label> <input type="text" id="" name=""
						readonly="readonly" value="<%=phDiseaseRegistrationFollow[2]%>" />

					<label class="auto">Date</label> <input type="text" class="date"
						readonly="readonly"
						value="<%=HMSUtil.convertDateToStringTypeDateOnly((Date)phDiseaseRegistrationFollow[4])%> " />

					<div class="clear"></div>
					<label>Doctor Note</label>
					<textarea cols="0" rows="0" maxlength="300" " readonly="readonly"><%=phDiseaseRegistrationFollow[5]%></textarea>

					<label>Patient Advice</label>
					<textarea cols="0" rows="0" maxlength="300" " readonly="readonly"></textarea>
					<div class="clear"></div>
					<label>Summary Consultation</label>
					<textarea cols="0" rows="0" maxlength="490" readonly="readonly"></textarea>
					<%}}
				%>

					<div class="floatRight">
					<%if(opdPatientDetails!= null && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){ %>
						<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
					<%}else if(patientWiseMlcs.size()>0){ %>
						<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
					<%}else{  %>
						<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
					<%} %>
					</div>
					<div class="paddingTop15"></div>
					<div class="clear"></div>
					<label>Patient Last Encounter </label>
					<textarea class="large" name="lastEncounter" id="lastEncounter"
						validate="Patient Last Encounter Details,string,no" cols="0"
						tabindex="1" rows="0" maxlength="300"
						onkeyup="return checkLength(this)" readonly="readonly"> <%=lastEncounterDetail!=null?lastEncounterDetail:"" %> </textarea>
					<div class="clear"></div>

					<div class="clear"></div>
					<label>Present Complaint / History</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="presentComplain" id="presentComplain" tabindex="2"
						validate="Present Complain & History,string,no" cols="0" rows="0"
						maxlength="300"><%=presentComplaintHistory %></textarea>
					<input type="button" class="buttonAuto-buttn" tabindex="3" name=""
						value="+" onclick="getPresentTemplate(csrfTokenName+'='+csrfTokenValue);" /> <label>History
						of Past Illness</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="pastIllness" id="pastIllness" cols="0" rows="0"
						maxlength="300" validate="Present Illness,string,no" tabindex="4"><%=opdPatientHistoriesStr %></textarea>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" tabindex="5" onclick="getHistoryOfPastIllnessTemplate(csrfTokenName+'='+csrfTokenValue)" />

					<div class="clear"></div>
					<label>Personal History</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="personalHistory" id="personalHistory" cols="0" rows="0"
						maxlength="500" validate="Past History,string,no" tabindex="6"><%=personalPresentHistory %></textarea>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getPersonalHistoryTemplate(csrfTokenName+'='+csrfTokenValue)" tabindex="7" />

					<label>Family History</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="familyHistory" validate="Family History,string,no"
						id="familyHistory" cols="0" rows="0" maxlength="500" tabindex="8"><%=familyPastHistory %></textarea>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getFamilyHistoryTemplate(csrfTokenName+'='+csrfTokenValue);" tabindex="9" />

					<div class="clear"></div>
					<label>Medication History</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="medicationhistory" validate="Family History,string,no"
						id="medicationhistory" cols="0" rows="0" maxlength="500"
						tabindex="10"><%=madicationHistory!=null?madicationHistory:"" %></textarea>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getMedicationHistoryTemplate(csrfTokenName+'='+csrfTokenValue)" tabindex="10" />
					<div class="clear"></div>

					<div class="divisionSolid"></div>
					<label class="auto1">Pulse</label> <input
						class="textYellow allownumericwithoutdecimal textSmall"
						tabindex="11" name="pulse" type="text" id="pulse"
						validate="pulse,num,no" maxlength="3"
						value="<%=pulse>0?pulse:"" %>" /> <label
						class="smallAuto autoSpace">min</label> <label class="auto">Temperature</label>
					<input class="textYellow allownumericwithdecimal textSmall"
						name="temperature" id="temperature" type="text" maxlength="6"
						validate="temperature,float,no"
						value="<%=temperature>0f?temperature:"" %>" tabindex="12" /> <label
						class="smallAuto autoSpace">&deg;F</label> <input type="button"
						tabindex="13" class="buttonAuto" style="margin: 0px 5px 0px 12px"
						id="calculateBmi" value="BMI" /> <input id="bmi" name="bmi"
						type="text" maxlength="5" class="textSmall"
						value="<%=bmi>0?bmi:"" %>" readonly="readonly" /> <input
						name="bmicat" id="bmicat" type="text" value="<%=bmiStatus %>"
						readonly="readonly" />
						<input type="hidden" name="heightHidden" id="heightHidden" value="<%=height==0?"":height%>" />
						<input type="hidden" name="weightHidden" id="weightHidden" value="<%=weight==0?"":weight%>"/>

					<div class="clear"></div>

					<label class="medium" id="bpLabel">BP</label> <input
						name="systolic" id="systolic" tabindex="14" placeholder="Systolic"
						value="<%=parts.length>0?parts[0]:noSysDias%>"
						validate="systolic,int,no" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal textSmall" /> <label
						id="bpLabel" class="auto"><span style="color: black">/</span></label>
					<input name="diastolic" id="diastolic" tabindex="15"
						placeholder="Diastolic"
						value="<%=parts.length>0?parts[1]:noSysDias%>"
						validate="diastolic,int,no" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal textSmall" /></span> <label
						class="smallAuto autoSpace">mm&nbsp;Hg</label> <input
						type="button" class="buttonAuto" id="vitalTrends"
						value="Vital Trends" tabindex="16" />

					<div class="clear"></div>
					<div class="clear"></div>
					<div class="divisionSolid"></div>
					<label>General Examination</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="generalExaminationOPC" id="generalExaminationOPC"
						validate="General Examination,string,no" cols="0" rows="0"
						maxlength="300" tabindex="17"><%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null?opdPatientDetails.getGeneralExamination():"" %></textarea>
					<input type="button" class="buttonAuto-buttn" value="+"
						onclick="getGeneralExaminationTemplate(csrfTokenName+'='+csrfTokenValue);" tabindex="18"
						style="margin-top: 2px; margin-right: 5px;" />
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<label>Systemic Examination</label> <label class="autoSpace"><input
						type="checkbox" class="radioCheckCol2" id="nad"
						onclick="deleteKeyword('All System NAD');putSystemicExamiantionText('nad','All System NAD');"
						checked="checked" tabindex="19" />All System NAD</label> <label
						class="autoSpace"><input type="checkbox"
						class="radioCheckCol2" id="cvs"
						onclick="deleteKeyword('CVS');putSystemicExamiantionText('cvs','CVS'); "
						disabled="disabled" tabindex="20" />CVS</label> <label class="autoSpace"><input
						type="checkbox" class="radioCheckCol2" id="cns"
						onclick="deleteKeyword('CNS'); putSystemicExamiantionText('cns','CNS');"
						disabled="disabled" tabindex="21" />CNS</label> <label class="autoSpace"><input
						type="checkbox" class="radioCheckCol2" id="rs"
						onclick="deleteKeyword('RS'); putSystemicExamiantionText('rs','RS');"
						disabled="disabled" tabindex="22" />RS</label> <label class="autoSpace"><input
						type="checkbox" class="radioCheckCol2" id="grs"
						onclick="deleteKeyword('GIS');putSystemicExamiantionText('grs','GIS');"
						disabled="disabled" tabindex="23" />GIS</label>
					<div class="clear"></div>
					<div class="paddLeftP100">
						<%if(opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null) {
						%>
						<textarea class="medium" cols="0" id="systemicExamination"
							name="systemicExamination"
							validate="systemicExamination,string,no" rows="0" maxlength="300">
					<%=opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null?opdPatientDetails.getSystemicExamination():"" %>
				</textarea>
						<%}else{ %>
						<textarea class="medium" cols="0" id="systemicExamination"	name="systemicExamination"	validate="systemicExamination,string,no" rows="0" maxlength="300">System NAD</textarea>
						<%} %>
						<label class="auto">Other</label> <input type="button"
							class="buttonAuto-buttn" value="+"
							onclick="getSystemicExaminationTemplate(csrfTokenName+'='+csrfTokenValue);" tabindex="24" />
					</div>
					<div class="clear"></div>
					<label>Local Examination</label>
					<textarea class="medium" validate="Family History,string,no"
						id="localExamination" name="localExamination" cols="0" rows="0"
						maxlength="300" tabindex="25" onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getLocalExamination()!=null?opdPatientDetails.getLocalExamination():"" %></textarea>
						
					<label class="auto">Other Diagnosis</label>
					<textarea class="medium" validate="Other Diagnosis,string,no"
						id="OtherDiagnosis" name="OtherDiagnosis" cols="0" rows="0"
						maxlength="500" tabindex="25" onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null?opdPatientDetails.getInitialDiagnosis().trim():"" %> 
						</textarea>	
					<div class="clear"></div>

					<input type="hidden" tabindex="25" class="textYellow" tabindex="23"
						id="icd1" name="icd1" /> <label><span>*</span> Snomed
						Diagnosis </label> <input type="text" tabindex="25" class="textYellow"
						tabindex="23" id="snomed" name="snomed"
						onblur="getICDListBasedOnSnomedId(this.value); <!-- fillDiagnosisCombo(this.value); -->" />
					<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"
						title="Remove Snomed Diagnosis" id="removeSnomed" />

					<div id="ac2update" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
		  new Ajax.Autocompleter('snomed','ac2update','opd?method=getSnomedListForAutoCompleteItem',{parameters:'requiredField=snomed'});
</script>
					<div id="divIcdName" style="display: none;">
						<label> Select ICD Name </label> <select id="icdName"
							name="icdName" onchange="fillICDValue(this.value,'op');">

						</select>
					</div>
					<div class="clear"></div>
					<label>ICD code</label>
					<!-- <input name="icdCode" tabindex="26" class="textYellow" value="" id="icdCode" onblur="getIcd(1);" /> -->
					<input name="icdCode" tabindex="26" class="textYellow" value=""
						id="icdCode" readonly /> <input name="temp" value="" id="temp"
						type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="24"
						HEIGHT="20" tabindex="27" class="search-img" 
						onClick="javascript:openPopupWindow();"
						title="Click here to Search ICD Codes" /> <label
						class="autoSpace"> <input type="radio" tabindex="28"
						class="radioCheckCol2" name="diagnosis_status" value="p"
						id="diagnosis_status_p1" checked="checked"
						onchange="changeDiagnosisStaus(1);" /> Provisional
					</label> <label class="autoSpace"> <input type="radio"
						tabindex="29" class="radioCheckCol2" name="diagnosis_status"
						value="f" id="diagnosis_status_f1"
						onchange="changeDiagnosisStaus(2);" /> Final
					</label> <label class="smallAuto"><img
						src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />
						Notifiable Desease</label> <label class="smallAuto"><img
						src="/hms/jsp/images/grey_rectangle.jpg" width="14" height="14" />P-Register</label>

					<div class="clear"></div>
					<div class="paddLeftP100">
						<select name="diagnosisId" multiple="4" id="diagnosisId"
							class="listBig" style="font: 16px tahoma; height: 80px;"
							validate="diagnosisId,string,no">
							<%for(DischargeIcdCode dIcd:dischargeIcdCodeLast3Visit)
							{
								MasIcd masIcd =  dIcd.getIcd();
								
							    String icdName=masIcd.getIcdName();
							    String icdCode=masIcd.getIcdCode();
							    int  icdId=dIcd.getId();
							    int  dischargeId=dIcd.getId();
							%>
							<option
								value="<%=icdCode %>@@@<%= masIcd.getSnomedConceptId()%>-<%=dischargeId%>" selected="selected">
								<%=icdName%>[<%=icdCode%>]
							</option>
							<%} %>
						</select> <img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"
							title="Remove diagnosis" id="removeOPDisgnosis" />
							<select	name="diagnosisIdNP" multiple="4" id="diagnosisIdNP" class="listBig" style="font: 16px tahoma; height: 80px;">
								<%for(DischargeIcdCode dIcd:dischargeIcdCodeLast3Visit)
								{
									MasIcd masIcd =  dIcd.getIcd();
								    String icdName=masIcd.getIcdName();
								    String icdCode=masIcd.getIcdCode();
								    if(masIcd.getNotifiableDesease()!=null &&masIcd.getNotifiableDesease().equalsIgnoreCase("n")){
								%>
									<option style="color: #FF0000;"><%=icdName%>[<%=icdCode%>]</option>
								<%}%>
								  	<%if(masIcd.getPRegister()!=null && masIcd.getPRegister().equalsIgnoreCase("p")){%>
									<option style="color: #008000;"><%=icdName%>[<%=icdCode%>]</option>
									<%}%>
								<%}%>
						    </select>

					</div>
					<div class="clear"></div>

					<label>Prescription</label> <label class="autoSpace"
						style="padding: 0px 2px 0px 1px; margin: 0px 4px 0px 0px;">Template</label>
					<div>
						<label class="autoSpace"
							style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
							<input type="radio" class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_local" onchange="getTemplate('local','p','');" />
							Local
						</label> <label class="autoSpace"
							style="padding: 0px 6px 0px 1px; margin: 0px 2px 0px 0px;"">
							<input type="radio" class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_global" onchange="getTemplate('global','p','');" />
							Global
						</label> <select class="midium" tabindex="30" name="tempLatePrescription"
							id="tempLatePrescription" onfocus="checkEnteredDiagnosis();"
							onchange="fnGetPrescriptionTemplate(this.value);">
							<option value="0">Select</option>
						</select>
					</div>
					<input type="button" class="buttonBig" name="prev"
						value="Save As Template"
						onclick="openPopupForSavePrescriptiontamplate();" /> <input
						name="Prevoius2" type="button" class="buttonBig"
						value="Last Prescription"
						onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>',csrfTokenName+'='+csrfTokenValue)" />
					<div class="clear"></div>

					<div class="floatRight" style="width: 300px;">
						<a href="#" onclick="getDetails();">Today's Other Prescription</a>
						<input type="button" class="buttonDel" value=""
							onclick="removeRow();" /> <input type="button" class="buttonAdd"
							onclick="addRow();" value="" />
					</div>
					<div class="clear"></div>
					<div class="floatLeft">
						<label id="cantralabel" class="autoSize" style="display: none"><span id="cantraMsg"></span></label>
						<label id="cantralabelDisease" class="autoSize" style="display: none"><span id="cantraMsgDisease"></span></label>
					</div>
					<div class="clear"></div>
					<div class="">
						<div class="tableForTab"
							style="width: 875px; height: 200px; overflow: scroll;">
							<div id="divTemplet1">

								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="grid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage</th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<th scope="col">Days</th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
									</tr>
									<%
	int incr = 0,len=3;
	if(patientPrescriptionDetails.size()>0){
		len=patientPrescriptionDetails.size();
	}else{
		len=3;
	}
	int inxRow=3;
	int inxCol=0;
	for(;incr< len;incr++,inxRow++){
		String nomeclature="";
		Integer ItemId=0;
		String pvmsNo="";
		int routeId=0;
		int frequencyId=0;
		int inctrunctionId=0;
		String unit="";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		String issuedStatus="";
		String routeName="";
		String pAvailableStatus="";
		PatientPrescriptionDetails pd=null;
		if(patientPrescriptionDetails.size()>0){
			pd=patientPrescriptionDetails.get(incr);
			
			ItemId=pd.getItem().getId();
			if(pd.getIssuedStatus()!=null && !pd.getIssuedStatus().equals("")  && pd.getIssuedStatus().equalsIgnoreCase("y")){
				issuedStatus=pd.getIssuedStatus();
			}		
			if(pd.getNotAvailable()!=null){
				pAvailableStatus=pd.getNotAvailable();
			}
			nomeclature=pd.getItem().getNomenclature();
			pvmsNo=pd.getItem().getPvmsNo();
			dosage=pd.getDosage();
			unit=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			ndays=pd.getNoOfDays();
			if(pd.getRoute()!=null){
				routeId=pd.getRoute().getId();
				routeName=pd.getRoute().getRouteName();
			}
			if(pd.getFrequency()!=null){
				frequencyId=pd.getFrequency().getId();
			}
			if(pd.getInsrtuction()!=null){
				inctrunctionId=pd.getInsrtuction().getId();
			}
			if(ItemId!=0 &&  !pvmsNo.equals("")){
				nomeclature=nomeclature+"("+ItemId+")["+pvmsNo+"]";
			}
		}
	%>
									<tr>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" class="radioCheck"
											id="itemRadio<%=incr %>" title="Prescription issued.."
											disabled="disabled" name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" /> <%}else{ %> <input
											type="checkbox" tabindex="<%=inxRow%><%=inxCol+1%>"
											class="radioCheck" id="itemRadio<%=incr %>"
											name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" /> <%} %> <input
											type="hidden" name="prescription_availableStatus<%=incr %>"
											id="prescription_availableStatus<%=incr %>"
											value="<%= pAvailableStatus%>" />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											title="Prescription issued.."
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											class="textYellow largTextBoxOpd" value="<%=nomeclature%>"
											id="nomenclature<%=incr%>" size="35"
											name="nomenclature<%=incr%>"
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>); checkForAllergy(this.value,<%=incr %>); populatePVMS(this.value,'<%=incr%>');populatePVMSTab(this.value,'<%=incr%>');checkItem('<%=incr%>');copyToPrescriptionTAb('<%=incr%>','opconsult'); ValidateCantra();displayAu(this.value,'<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											tabindex="<%=inxRow%><%=inxCol+2%>"
											class="textYellow largTextBoxOpd"
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											value="<%=nomeclature%>" id="nomenclature<%=incr%>" size="35"
											name="nomenclature<%=incr%>"
											onfocus="checkEnteredDiagnosis();checkFrequency('<%=incr%>','opc');"
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>);
												 checkDrugToDiseaseCantra(this);
												 checkForAllergy(this.value,<%=incr %>);populatePVMS(this.value,'<%=incr%>');
												 populatePVMSTab(this.value,'<%=incr%>');checkItem('<%=incr%>');
												 copyToPrescriptionTAb('<%=incr%>','opconsult'); 
												 ValidateCantra();displayAu(this.value,'<%=incr%>');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=incr %> )" />
											<%}%>
											<div id="ac2updates<%=incr%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>'});
					</script> <input type="hidden" name="pvmsNo<%=incr %>" id="pvmsNo<%=incr %>"
											size="10" readonly="readonly" /> <input type="hidden"
											name="actualDispensingQty<%=incr%>"
											id="actualDispensingQty<%=incr%>" size="6"
											validate="AU,string,no" />
										</td>
										<td>
								 <%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled" title="Prescription issued.."
											name="route<%=incr%>" id="route<%=incr%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
								
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select> <%}else{ %> <select name="route<%=incr%>"
											tabindex="<%=inxRow%><%=inxCol+3%>" id="route<%=incr%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
							   	  
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select> <%}%> <script type="text/javascript">	var	routeArray= new Array();
		              <%
			    		RouteOfAdministration  route = new RouteOfAdministration();
					     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
		     			 %> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=route.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=route.getRouteName()%>";
	     				<% }%> 
            </script>
										</td>
										<td><input class="textYellow opdTextBoxTSmall"
											tabindex="<%=inxRow%><%=inxCol+4%>" type="text"
											name="dosage<%=incr%>" id="dosage<%=incr%>"
											value="<%=dosage!=null && dosage!=0?dosage:"" %>" size="10"
											maxlength="45" onblur="fillValue(this.value,<%=incr%>);" /></td>
										<td><input type="text"
											tabindex="<%=inxRow%><%=inxCol+5%>" name="unit<%=incr %>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											class="textYellow opdTextBoxTSmall" id="unit<%=incr %>"
											readonly="readonly" size="5"
											onblur="fillValue(this.value,<%=incr%>);" /></td>
										<td><input type="hidden" name="frequencyValue<%=incr%>"
											id="frequencyValue<%=incr%>" value="" size="6" /> <input
											type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
											style="display: none;" size="3"
											onblur="fillValue(this.value,<%=incr%>)" maxlength="3"
											validate="Sos Qty,num,no" /> <%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="frequency<%=incr%>" id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValueFromFrequency(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>)">
												<option value="0">Select</option>
												<%
						  MasFrequency  masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
												<%if(frequencyId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRow%><%=inxCol+6%>" name="frequency<%=incr%>"
											id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValueFromFrequency(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>)">
												<option value="0">Select</option>
												<%
						  MasFrequency  masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
												<%if(frequencyId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <% }%> <%	MasFrequency  masFrequency3 = new MasFrequency();
				        for (int i = 0; i < frequencyList.size(); i++) {
				      	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     		 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDays<%=incr%>" id="noOfDays<%=incr%>"
											value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											tabindex="<%=inxRow%><%=inxCol+7%>" name="noOfDays<%=incr%>"
											id="noOfDays<%=incr%>" value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);" />
											<% }%>

										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="instrunction<%=incr%>" id="instrunction<%=incr%>"
											onblur="fillInstrunctionOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
					}
					%>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRow%><%=inxCol+8%>"
											name="instrunction<%=incr%>" id="instrunction<%=incr%>"
											onblur="fillInstrunctionOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<%
							for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
							{
				
						       int id = instructionTreatment.getId();
						       String name = instructionTreatment.getOpdInstructionTreatmentName();
				
				          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
							}
							%>
										</select> <% }%> <script type="text/javascript">	var	instructionArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunction<%=incr %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" /> <%}else{ %>
											<input type="text" tabindex="<%=inxRow%><%=inxCol+9%>"
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunction<%=incr %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" /> <% }%>
										</td>
										<td><input type="text" name="total<%=incr %>"
											id="total<%=incr %>"
											value="<%=total!=null && total!=0?total:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"
											readonly="readonly" /></td>
									</tr>
									<%} %>

								</table>
								<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
								<input type="hidden" name="hdbRecordSize"
									value="<%= patientPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize" /> <input type="hidden" name="hdbTabIndex"
									id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" />
							</div>
						</div>
					</div>

					<div class="clear"></div>
					<!-- <div  class="paddLeft55">
<input  type="button" class="buttonBig" name="prev" value="Save As Template" />
</div> -->
					<div class="floatLeft"
						style="margin-bottom: 10px; margin-top: 5px;">
						<label class="auto"><img
							src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" /><span>Stock
								not available for medicine</span></label>
					</div>
					<!--<div  class="floatRight">
 <label class="auto">Page</label>
<select class="midium"><option>Select</option></select>
</div> -->
					<div class="clear"></div>
					<label>Remarks</label>
					<textarea class="opdMainTextArea" validate="remark,string,no"
						id="opdRemarks" name="opdRemarks" cols="0" rows="0" maxlength="500"
						onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getOpdRemarks()!=null?opdPatientDetails.getOpdRemarks():"" %></textarea>
					<label class="auto">Review Date</label>
					<%-- <input type="text" id="reviewDate" name="reviewDate" class="dateTextSmall" value="<%=currentDate%>" readonly="readonly"> --%>
					<input type="text" id="reviewDate" name="reviewDate"
						class="dateTextSmall" value="" readonly="readonly"> <img
						src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
						validate="Pick a date"
						onclick="setdate('<%=currentDate%>',document.opdMain.reviewDate,event);" />

					<label class="auto">Personal Review<input type="checkbox"
						class="radioCheckCol2" /></label>
					<div class="clear"></div>
					<label>Summary Consultation</label>
					<textarea class="opdMainTextArea"
						validate="Summary Consulatation,string,no"
						id="summaryConsultation" name="summaryConsultation" cols="0"
						rows="0" maxlength="490" onkeyup="return checkLength(this)"></textarea>
					<%if(null !=secondOpinoinComment && !secondOpinoinComment.equals("")){ %>
					<label>Second Opinion Remarks</label>
					<textarea class="opdMainTextArea"
						validate="Summary Consulatation,string,no"
						id="secondOpinoinComment" readonly="readonly" value=""
						name="secondOpinoinComment" cols="0" rows="0" maxlength="490"
						onkeyup="return checkLength(this)"><%=secondOpinoinComment %></textarea>
					<%} %>
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div id="admissionDiv">
						<div class="clear"></div>
						<label class="autoSpace">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label> <label class="autoSpace">Admission Advised <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="admissionAdvised" name="admissionAdvised" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="admissionAdvised"
							name="admissionAdvised" /> <%} %>
						</label>
						<div id="admDiv" class="collaps">
							<label class="auto">Admission Date</label> <input type="text"
								name="admissionDate" id="admissionDate"
								style="text-align: left;" class="dateTextSmall"
								value="<%=currentDate%>" readonly="readonly"
								onblur="checkAdmte()" /> <img src="/hms/jsp/images/cal.gif"
								width="16" height="16" border="0" validate="Pick a date"
								onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							</td>
							<div class="clear"></div>
							<label class="autoSpace">Payward
							
							<!-- <input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2"
								onchange="checkPayWard('payward');" /> -->
							<!-- Commented by Amit Das on 20-05-2016 -->
							<!-- added by Amit Das on 20-05-2016 -->	
							<input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2" value="Y"
								 />	
							</label> <label class="auto">Ward</label>
							<select name="admissionWard" id="admissionWard"
								onclick="getBedStatus(this.value);">
								<option value="0">Select</option>
								<%for(MasDepartment ward:wardDepartmentList){ %>
								<option value="<%=ward.getId()%>"><%=ward.getDepartmentName() %></option>
								<%} %>
							</select>
							<div id="bedDiv"></div>
						</div>

					</div>

				</div>
			</div>
			<!-- op consultation scren end here  -->

			<div id="country2" class="tabcontentIn">
				<div class="Block">
					<!--<label>On Examination</label>
<input type="text" id="onExamination" 	name="onExamination" maxlength="200" />
  -->
					<label>General Examination</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="generalExaminationEXM" id="generalExaminationEXM"
						validate="generalExaminationEXM,string,no" cols="0" rows="0"
						maxlength="300">
 <%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null?opdPatientDetails.getGeneralExamination():"" %>
 </textarea>
					<!-- <select class="listBig"  name="generalExamination2" id="generalExamination2"  multiple="4" size="5" ></select> -->
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getGeneralExaminationTemplate();" /> <label>Systemic
						Examination</label>
					<%if(opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null){ %>
					<textarea class="opdMainTextArea yellowBackground" name="finding"
						id="finding" validate="generalExaminationEXM,string,no" cols="0"
						rows="0" maxlength="300">
 <%=opdPatientDetails.getSystemicExamination()!=null?opdPatientDetails.getSystemicExamination():"" %>
 </textarea>
					<%}else{ %>
					<textarea class="opdMainTextArea yellowBackground" name="finding"
						id="finding" validate="generalExaminationEXM,string,no" cols="0"
						rows="0" maxlength="300">
 </textarea>
					<%} %>
					<input type="button" class="buttonAuto-buttn" id="" name=""
						value="+" onclick="getSystemicExaminationTemplate();" />

					<div class="clear"></div>
					<label>ICD Code</label> <input name="icdCode1" value=""
						id="icdCode1" onblur="getIcd(2);" /> <input name="temp1" value=""
						id="temp1" type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif"
						WIDTH="24" HEIGHT="20" class="search-img"
						onClick="javascript:openPopupWindow();"
						title="Click here to Search ICD Codes" />

					<div class="clear"></div>
					<label>Diagnosis Type</label> <label class="autoSpace"> <input
						type="radio" class="radioCheckCol2" checked="checked"
						name="digType" id="diagnosis_status_p2"
						onchange="changeDiagnosisStaus(1);" /> Provisional
					</label> <label class="autoSpace"> <input type="radio"
						class="radioCheckCol2" name="digType" id="diagnosis_status_f2"
						onchange="changeDiagnosisStaus(2);" /> Final
					</label>

					<div class="clear"></div>
					<input type="hidden" value="" id="icd" />
					<div class="clear"></div>
					<label><span>*</span>Snomed Diagnosis</label> <input type="text"
						id="icd2" name="icd2"
						onblur="getICDListBasedOnSnomedId(this.value);" />
					<!-- onblur="fillDiagnosisCombo(this.value);" -->
					<div id="ac2update22" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
		  new Ajax.Autocompleter('icd2','ac2update22','opd?method=getSnomedListForAutoCompleteItem',{parameters:'requiredField=icd2'});
</script>

					<div id="divIcdNameExm" style="display: none;">
						<label> Select ICD Name </label> <select id="icdNameExm"
							name="icdNameExm" onchange="fillICDValue(this.value,'exm');">

						</select>
					</div>



					<div class="clear"></div>
					<div class="paddLeft175">
						<div class="clear"></div>
						<div
							style="overflow: auto; width: 600px; height: 100px; border: 1px solid #336699;">
							<table id="diagnosisId1">
								<tr>
									<th>Diagnosis</th>
									<th>Comorbidity</th>
									<th>Action</th>
								</tr>
							</table>
						</div>
					</div>

					<label> <input type="checkbox" class="radioCheckCol2"
						name="patient_expire" id="patient_expire" />Patient Dead
					</label>
					<div id="siftedToMortuaryDiv" style="display: none;">
						<select id="patientdeathStatus" class="midium" name="patientdeathStatus">
							<option>select</option>
							<option value="Brought Dead">Brought Dead</option>
							<option value="Brought Dead">Death In Opd</option>
						</select>
					<label> <input type="checkbox" class="radioCheckCol2"
						name="siftedToMortuary" id="siftedToMortuary" />Sifted To Mortuary
					</label>
					</div>

					<div id="referalDiv">

						<label>Referral </label> <select id="referral" name="referral"
							class="midium">
							<option value="0" selected="selected">No</option>
							<option value="1">Yes</option>
						</select>

						<!-- <div id="referBack" style="display:none" >

</div> -->
						<div id="referDiv" class="col collaps">
							<label class="auto">Refer To</label>
							<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
							<%
/* out.print(" opdpatientDetailId="+ opdpatientDetailId);
out.print(" referralHospital="+ referralHospital);
out.print(" referralDistrict="+ referralDistrict);
out.print(" refereferralType="+ referralType); */
if(opdpatientDetailId !=0)
{
	%>
							<label class="autoSpace"><input type="checkbox"
								class="radioCheckCol2" name="referBack" id="referBack"
								value="Internal"
								onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
							<%
}

%>

							<label class="autoSpace"><input type="radio"
								class="radioCheckCol2" name="referTo" id="referInternal"
								value="Internal" onclick="checkReferTO('referInternal');" />Internal</label>
							<label class="autoSpace"><input type="radio"
								class="radioCheckCol2" name="referTo" id="referExternal"
								value="External" onclick="checkReferTO('referExternal');" />External</label>

							<div class="clear"></div>
							<label>Refer Date:</label> <input type="text"
								id="referVisitDate" name="referVisitDate" class="date"
								value="<%=currentDate%>"
								onkeyup="mask(this.value,this,'2,5','-');"
								 />
							<img  src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" /> 
							</td> <label id="priorityLabelId">Current Proirity No.</label> <select
								id="priorityId" name="priorityName" tabindex="1">
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>
							<div class="clear"></div>
							<label id="referdistrictLabel">District</label> <select
								id="referdistrict" name="referdistrict"
								onchange="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%for(MasDistrict district:masDistrictList){%>
								<%if(districtId==district.getId()){ %>
								<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
								<%}else{ %>
								<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
								<%} %>
								<%}%>
							</select> <label id="referHospitalTypeLabel">Hospital Type</label> <select
								id="referHospitalType" name="referHospitalType"
								onchange="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%if(hospitalTypeList.size()>0){
	for(MasHospitalType masHospitalType:hospitalTypeList){%>
								<%if(hospitalTypeId==masHospitalType.getId()){ %>
								<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
								<%}else{ %>
								<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
								<%} %>
								<%}}%>
							</select>
							<div class="clear"></div>

							<label id="referhospitalLabel">Hospital</label> <select
								id="referhospital" name="referhospital"
								onchange="fnGetHospitalDepartment(this.value);">
								<option value="0">Select</option>
								<%for(MasHospital msh:masHospitals){%>
								<%if(hospitalId==msh.getId()){ %>
								<option value="<%=msh.getId()%>" selected="selected"><%=msh.getHospitalName()%></option>
								<%}else{ %>
								<option value="<%=msh.getId()%>"><%=msh.getHospitalName()%></option>
								<%} %>
								<%}%>
							</select>
							<div class="clear"></div>

							<label id="referdepartmentLabel">Department</label> <select
								id="referdepartment" name="referdepartment"
								onchange="fnGetDoctorDepartment(this.value);">
								<option value="0">Select</option>
								<%for(MasDepartment dep:deptList){
		%>
								<%if(deptId==dep.getId()) {%>
								<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
								<%}else{ %>
								<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
								<%} %>
								<%}%>
							</select> <label>Doctor</label> <select id="refereddoctor"
								name="refereddoctor">
								<option value="0">Select</option>
							</select>


							<div class="clear"></div>
							<label>Patient Advise</label>
							<textarea name="patientAdvise" validate="patientAdvise,string,no"
								id="patientAdvise" cols="0" rows="0" maxlength="500"
								tabindex="5" onkeyup="return checkLength(this)"></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" /> <label>Referral Notes</label>
							<textarea name="referralNote" validate="referralNote,string,no"
								id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
								onkeyup="return checkLength(this)"></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" />
						</div>
						<input type="hidden" name="userName" value="<%=userName %>" />
						<%
			String relationName="";
			if(visit.getHin().getRelation() != null){
				 relationName=visit.getHin().getRelation().getRelationName();
				if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
		%>
						<label>No. of Days</label> <input name="days" type="text"
							maxlength="1" />
						<%}} %>
					</div>

					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="clear"></div>
				<div class="division"></div>
				<div class="clear"></div>

				<div class="clear"></div>
			</div>
			<div id="country3" class="tabcontentIn">
				<div class="Block" style="width: 800px;">
					<div class="paddLeft55">
						<label class="auto">Template</label>
						<div class="paddLeft55">
							<div>
								<div class="labelMargeDiv">
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_local" onchange="getTemplate('local','i','');" />Local</label>
									<div class="clear"></div>
									<div class="clear"></div>
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_global"
										onchange="getTemplate('global','i','');" />Global</label>
									<div class="clear"></div>
									<div class="clear"></div>
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_global" onchange="getAllTemplate();" />ALL</label>
								</div>
								<div class="paddLeft30">
									<select class="medium" multiple="5" style="height: 80px;"
										name="tempLateInvestigation" id="tempLateInvestigation"
										onchange="fnGetInvestigationTemplate(this);">
										<option value="-1">Select</option>
										<%for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("i")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateInvestigations().size()>0){ %>
										<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
										<%}%>
										<% } %>
									</select>
									<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int kIndex=0;
				 for(OpdTemplate opd:templateListForInvestigation){ %>
					<%if(opd.getTemplateType().equalsIgnoreCase("i")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateInvestigations().size()>0){ %>
					tempArrayTemp[<%=kIndex%>]= new Array();
					tempArrayTemp[<%=kIndex%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=kIndex%>][1] = "<%=opd.getTemplateName() %>";
					<%kIndex++;%>
					<%}%>
				<%}%>
				</script>


								</div>
								<input name="Prevoius" type="button" value="Last Investigation"
									class="buttonBig"
									onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>',csrfTokenName+'='+csrfTokenValue)" />
							</div>
							<div class="clear"></div>

						</div>

					</div>
					<div class="clear"></div>
					<div class="floatRight" style="margin-right: 10px;">
						<input type="button" class="buttonDel" alt="Delete" value="&nbsp;"
							onclick="removeRowForInvestigation();" /> <input type="button"
							class="buttonAdd" alt="Add" value="&nbsp;"
							onclick="addRowForInvestigation();" />
					</div>
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<div>
									<input type="radio" value="Lab" class="radioCheckCol2"
										name="labradiologyCheck" checked="checked" onchange="" />LAB
									<div class="clear"></div>
									<input type="radio" value="Radio" class="radioCheckCol2"
										name="labradiologyCheck" onchange="" />Radiology <input
										type="hidden" name="investigationCategory"
										id="investigationCategory" />
									<div class="clear"></div>
									<img src="/hms/jsp/images/red_rectangle.jpg" width="14"
										height="14" />&nbsp;Service Not Available
								</div>
							</td>
							<td>
								<div class="tableForTab"
									style="width: 715px; height: auto; overflow: scroll;"
									id="labInvDiv" class="cmnTable">
									<div id="divTemplet1">
										<table border="0" align="center" cellpadding="0"
											cellspacing="0" id="investigationGrid">
											<tr>
												<th scope="col">&nbsp;</th>
												<th scope="col">Test Name</th>
												<th scope="col">Snomed Concepts</th>
												<th scope="col">Clinical Notes</th>
											</tr>
											<%int inc=0;
			len=2;
			if(dgOrderdts.size()>0){
				len=dgOrderdts.size();
			}
			String chargeCodeName=""; 
			String chargeCodeNotes="";
			Integer dtHids=0;Integer dtIds=0;Integer pInvHd=0;Integer pInvDt=0;	Integer pDgSHd=0;
			Integer pDgSDt=0;String orderStatus="";	Integer dgSampleId=0;String clinicalNotes="";
			Integer dgSampleHdId=0;
			String avlStatus="";
			Map<Integer,Integer> dgSampleCollectionMap=new HashMap<Integer,Integer>();
			for(;inc<dgSampleCollectionDetails.size();inc++){
				DgSampleCollectionDetails sampleCollectionDetails=(DgSampleCollectionDetails) dgSampleCollectionDetails.get(inc);
				Integer chargeCodeId=sampleCollectionDetails.getChargeCode().getId();
				dgSampleId=sampleCollectionDetails.getId();
				dgSampleHdId=sampleCollectionDetails.getSampleCollectionHeader().getId();
				dgSampleCollectionMap.put(chargeCodeId, dgSampleId);
			}
				inc=0;
			for(;inc<len;inc++){
				if((dgOrderdts.size()>0 && patientInvestigationDetails.size()>0) && ((dgOrderdts.size() == patientInvestigationDetails.size()))){
					DgOrderdt dgOrderdt=dgOrderdts.get(inc);
					PatientInvestigationDetails  patientInvestigationDetail=patientInvestigationDetails.get(inc);
					chargeCodeName=dgOrderdt.getChargeCode().getChargeCodeName()+"["+dgOrderdt.getChargeCode().getId()+"]";
					orderStatus=dgOrderdt.getOrderStatus();
					
					dtHids=dgOrderdt.getOrderhd().getId();
					dtIds=dgOrderdt.getId();
					
					clinicalNotes=patientInvestigationDetail.getClinicalNotes();
					avlStatus=patientInvestigationDetail.getAvailableStatus();
					pInvHd=patientInvestigationDetail.getInvestigationHeader().getId();
					pInvDt=patientInvestigationDetail.getId();
					
					Integer chargeCodeId=dgOrderdt.getChargeCode().getId();
					dgSampleId=(Integer)dgSampleCollectionMap.get(chargeCodeId);
				}
			%>
											<tr>
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													type="checkbox" disabled="disabled" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /> <%}else{ %>
													<input type="checkbox" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /> <%} %>
													<input type="hidden" name="parkInvestigationId<%=inc %>"
													id="parkInvestigationId<%=inc %>"
													value="<%=dtIds%>-<%=pInvDt%>-<%=dgSampleId!=null?dgSampleId:"0" %>" />
													<input type="hidden" name="availableStatus<%=inc %>"
													id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
												</td>
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) { %> <input
													readonly="readonly" type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="<%=chargeCodeName %>" id="chargeCodeName<%=inc %>"
													size="65" name="chargeCodeName<%=inc %>"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													<%}  else{ %> <input type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="<%=chargeCodeName %>" id="chargeCodeName<%=inc %>"
													size="65" name="chargeCodeName<%=inc %>"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="getUnavailableInvestigation(<%=inc %>);checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													<%} %>

													<div id="ac2update<%=inc %>" style="display: none;"
														class="autocomplete"></div> <script type="text/javascript"
														language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
												</td>
												<td><input type="input"
													class="largTextBoxOpd textYellow" type="text"
													name="snomedTermsInv<%=inc %>" id="snomedTermsInv<%=inc %>" />
												</td>
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													readonly="readonly" type="text"
													name="clinicalNotes<%=inc %>" value="<%=clinicalNotes %>"
													class="opdTextBoxSmall textYellow"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" /> <%}else{ %>
													<input type="text" name="clinicalNotes<%=inc %>"
													value="<%=clinicalNotes %>"
													class="opdTextBoxSmall textYellow"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" /> <%} %>
												</td>
											</tr>
											<%
			} %>
										</table>
									</div>
									<input type="hidden" name="hiddenValue" id="hiddenValue"
										value="<%=inc-1%>" /> <input type="hidden" name="toDate"
										id="todate" value="<%=currentDate%>" /> <input type="hidden"
										name="dhHeaderIds" id="dhHeaderIds"
										value="<%=dtHids%>-<%=pInvHd%>-<%=dgSampleHdId%>" />
								</div>
							</td>
						</tr>
					</table>

					<div class="paddingLeft15"></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="division"></div>
				<div class="clear"></div>
				<input type="button" class="buttonBig" name="prev"
					value="Save As Template"
					onclick="javascript:openPopupForSaveInvestigation();" />
			</div>


			<!-- Allergy tab: Rajendra Kumar :23-03-2015 -->
			<div id="country4" class="tabcontentIn">
				<div class="Block">
					<div class="paddFltRight140">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="&nbsp;" onclick="removeRowForAllergy();" align="right" />
						<input type="button" class="buttonAdd" alt="Add" tabindex="4"
							value="&nbsp;" onclick="addRowForAllergy();" align="right" />
					</div>
					<div class="clear"></div>
					<div class="tableForTab">
						<div id="divTemplet">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="alergyGrid">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Type</th>
									<th scope="col">Allergen</th>
									<th scope="col">Severity</th>
									<th scope="col">Since:Month</th>
									<th scope="col">Since:Year</th>
									<th scope="col">Status</th>
								</tr>
								<%incr=0 ;
	len=2;
	Integer allergyHeaderId=0;
	Integer allergyDetailId=0;
	if(opdPatientAllergyTs.size()>0){
		len=opdPatientAllergyTs.size();
	}
	MasAllergyProduct masAllergyProductPark=null;
	String allergyName=null;
	MasSeverityCode masSeverityCodePark=null;
	String allergyyear=null;
	String allergymonth=null;
	String allergyStatus=null;
	for(;incr<len;incr++){
		OpdPatientAllergyT opdPatientAllergyT=null;
		if(opdPatientAllergyTs.size()>0 ){
			opdPatientAllergyT=opdPatientAllergyTs.get(incr);
		}
		if(opdPatientAllergyT!=null){
			masAllergyProductPark=opdPatientAllergyT.getAllergy();
			allergyName=opdPatientAllergyT.getAllergen();
			masSeverityCodePark=opdPatientAllergyT.getSeverity();
			allergyyear=opdPatientAllergyT.getFromYear();
			allergymonth=opdPatientAllergyT.getFromMonth();
			allergyHeaderId=opdPatientAllergyT.getOpdPatientAllergy().getId();
			allergyDetailId=opdPatientAllergyT.getId();
			allergyStatus=opdPatientAllergyT.getStatus();
		}
		
	%>

								<tr>
									<td><input type="checkbox" class="radioCheck"
										name="allergyRadio<%=incr%>" id="allergyRadio<%=incr%>" /> <input
										type="hidden"
										value="<%=!allergyDetailId.equals(0)?allergyDetailId:0 %>"
										name="allergyDetailId<%=incr%>" id="allergyDetailId<%=incr%>" />
									</td>
									<td><select style="background: #FFFF99"
										name="allergyType<%=incr%>" id="allergyType<%=incr%>">
											<option value="0">Select</option>
											<%for(MasAllergyProduct msap:allergyProductsList){%>
											<%if(masAllergyProductPark!=null && (msap.getId()==masAllergyProductPark.getId())){ %>
											<option selected="selected" value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%}else{ %>
											<option value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%} %>
											<%} %>
									</select> <%
				MasAllergyProduct  masAllergyProduct = new MasAllergyProduct();
				         for (int i = 0; i < allergyProductsList.size(); i++) {
				        	 masAllergyProduct = (MasAllergyProduct) allergyProductsList.get(i);
	     			 %> <script>
	     			allergyTypeArray[<%=i%>]= new Array();
	     			allergyTypeArray[<%=i%>][0] = "<%=masAllergyProduct.getId()%>";
	     			allergyTypeArray[<%=i%>][1] = "<%=masAllergyProduct.getProductName()%>";
	            </script> <% }%></td>
									<td><input type="text" class="largTextBoxOpd textYellow "
										tabindex="32"
										value="<%=allergyName!=null && !allergyName.equals("")?allergyName:"" %>"
										id="allergyName<%=incr%>" size="35"
										name="allergyName<%=incr%>" /> <%-- <div id="allergy_ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<script type="text/javascript" language="javascript" charset="utf-8">
					 new Ajax.Autocompleter('allergyName<%=incr%>','allergy_ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItemAllergy',{minChars:3,
					 callback: function(element, entry) {
				            return entry + '&allergyTypeCheck=' + document.getElementById('allergyType<%=incr%>').value;
				      },parameters:'requiredField=allergyName<%=incr%>'});
		</script> --%></td>
									<td><select style="background: #FFFF99"
										name="allergyseverity<%=incr%>" id="allergyseverity<%=incr%>">
											<option value="0">Select</option>
											<%for(MasSeverityCode mssc:saverityCodesList){%>
											<%if(masSeverityCodePark!=null && (mssc.getId()==masSeverityCodePark.getId())){ %>
											<option selected="selected" value="<%=mssc.getId()%>"><%=mssc.getSeverityName()%></option>
											<%}else{ %>
											<option value="<%=mssc.getId()%>"><%=mssc.getSeverityName()%></option>
											<%} %>
											<%} %>
									</select> <%
					MasSeverityCode  masSeverityCode = new MasSeverityCode();
				         for (int i = 0; i < saverityCodesList.size(); i++) {
				        	 masSeverityCode = (MasSeverityCode) saverityCodesList.get(i);
	     			 %> <script>
	     			saverityCodeArray[<%=i%>]= new Array();
	     			saverityCodeArray[<%=i%>][0] = "<%=masSeverityCode.getId()%>";
	     			saverityCodeArray[<%=i%>][1] = "<%=masSeverityCode.getSeverityName()%>";
	            </script> <% }%></td>
									<td><input class="small textYellow"
										name="allergyyear<%=incr%>"
										value="<%=allergyyear!=null && !allergyyear.equals("")?allergyyear:"" %>"
										id="allergyyear<%=incr%>" type="text" maxlength="2"
										validate="Allergy Year,int,no" /></td>
									<td><input class="small textYellow"
										name="allergymonth<%=incr%>"
										value="<%=allergymonth!=null && !allergymonth.equals("")?allergymonth:"" %>"
										id="allergymonth<%=incr%>" type="text" maxlength="2"
										validate="Allergy Month,int,no" /></td>
									<td><select style="background: #FFFF99"	name="allergystatus<%=incr%>" id="allergystatus<%=incr%>">
											<option value="0">Select</option>
											<option value="1" <%=allergyStatus!=null && allergyStatus.equalsIgnoreCase("y")?"selected='selected'":""%>>Active</option>
											<option value="2" <%=allergyStatus!=null && allergyStatus.equalsIgnoreCase("n")?"selected='selected'":""%>>Inactive</option>
										</select></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="allergyHeaderIds"
								id="allergyHeaderIds" value="<%=allergyHeaderId%>" />
						</div>
					</div>
					<div class="paddFltRight140">
						<label class="auto">Page</label> <select class="midium">
							<option value="0">Select</option>
						</select>
					</div>
					<input type="hidden" name="allergyCount" id="allergyCount"
						value="<%=incr-1%>" />
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>


			<div id="country5" class="tabcontentIn">
				<div class="Block">

					<label>Nursing Care</label>

					<div class="floatRight" style="margin-right: 173px">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="&nbsp;" onclick="removeRowTreatmentNursingCare();"
							align="right" /> <input type="button" class="buttonAdd"
							alt="Add" tabindex="4" value="&nbsp;"
							onclick="addRowTreatmentNursingCare();" align="right" />
					</div>
					<div class="clear"></div>
					<div id="divTemplet" style="width: 700px;">
						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="gridNursing">

							<tr>
								<th>&nbsp;</th>
								<th>Procedure Name</th>
								<th>Frequency</th>
								<th>No.Of Days</th>
								<th>Remark</th>
								<th>Alert Me</th>
							</tr>
							<%
	incr=0 ;
	len=2;
	if(procedureDetails.size()>0){
		len=procedureDetails.size();
	}
	Integer procedureId=0;
	Integer procedureHeaderId=0;
	String nursingCare="";
	String nursingRemark="";
	String procedureStatus="";
	int noOfDays=0;
	int frequencyId_1=0;
	for(;incr<len;incr++){
		ProcedureDetails procedureDetails1=null;
		if(procedureDetails.size()>0 ){
			procedureDetails1=procedureDetails.get(incr);
		}
		if(procedureDetails1!=null){
			procedureId=procedureDetails1.getId();
			procedureHeaderId=procedureDetails1.getProcedureHeader().getId();
			nursingCare=procedureDetails1.getProcedure().getNursingName()+"["+procedureDetails1.getProcedure().getId()+"]";
			if(procedureDetails1.getRemarks()!=null)
			nursingRemark=procedureDetails1.getRemarks();
			procedureStatus=procedureDetails1.getStatus();
			noOfDays = procedureDetails1.getNoOfDays();
			frequencyId_1 = procedureDetails1.getFrequency().getId();
		}
	%>
							<tr>
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									type="checkbox" disabled="disabled" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>" />
								</td>
								<%}else{ %>
								<input type="checkbox" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>">
								</td>
								<%} %>
								<input type="hidden"
									value="<%=procedureId!=null && !procedureId.equals(0)?procedureId:0 %>"
									name="procedureDetailId<%=incr%>"
									id="procedureDetailId<%=incr%>" />
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									readonly="readonly" type="text"
									class="opdTextBoxSmall textYellow" value="<%=nursingCare %>"
									id="procedureName_nursing<%=incr%>" size="35"
									name="procedureName_nursing<%=incr%>" /> <%}else{%> <input
									type="text" class="opdTextBoxSmall textYellow"
									value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>"
									size="35" name="procedureName_nursing<%=incr%>" /> <%}%>
									<div id="ac2updates_nursing<%=incr%>" style="display: none;"
										class="autocomplete"></div> <script type="text/javascript"
										language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('procedureName_nursing<%=incr%>','ac2updates_nursing<%=incr%>','opd?method=getNursingCareProcedureAutoList',{minChars:3,
						  callback: function(element, entry) {
					            return entry + '&minor_major=1';
					        }, parameters:'requiredField=procedureName_nursing<%=incr%>'});
			</script>
								</td>
								<td><select name="frequency_nursing<%=incr%>"
									id="frequency_nursing<%=incr%>" tabindex="36">
										<option value="0">Select</option>
										<%
						  MasFrequency masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
										<option value="<%=id %>" <% if(frequencyId_1 == id){%>
											selected <%}%>><%=name%></option>
										<%} %>
								</select> <%
		    		MasFrequency masFrequency3 = new MasFrequency();
				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
								<td id="nf<%=incr%>"><input type="text"
									name="noOfDays_nursing<%=incr%>" id="noOfDays_nursing<%=incr%>"
									value="<%=noOfDays%>" class="opdTextBoxTSmall textYellow" size="5" />
								</td>
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									readonly="readonly" value="<%=nursingRemark %>" type="text"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									class="largTextBoxOpd textYellow" /> <%}else{ %> <input
									type="text" value="<%=nursingRemark %>"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									class="largTextBoxOpd textYellow" /> <%} %>
								</td>
								<td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td>
							</tr>
							<%} %>
						</table>
						<input type="hidden" id="procedureHeaderId"
							name="procedureHeaderId" value="<%=procedureHeaderId%>" />
						</td> <input type="hidden" name="nursinghdb" value="<%=incr-1%>"
							id="nursinghdb" />
					</div>

					<div class="clear"></div>
					<div class="clear"></div>
					<div class="paddingTop25">
						<label>Surgery Procedure</label>

						<div class="floatRight" style="margin-right: 173px">
							<input type="button" class="buttonDel" tabindex="3" alt="Delete"
								value="&nbsp;" onclick="removeRowTreatmentSurgery();"
								align="right" /> <input type="button" class="buttonAdd"
								alt="Add" tabindex="4" value="&nbsp;"
								onclick="addRowTreatmentSurgery();" align="right" />
						</div>
						<div class="clear"></div>
						<div id="divTemplet" style="width: 825px;">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="gridSurgery">
								<tr>
									<th>&nbsp;</th>
									<th>Procedure Name</th>
									<th>Tentative Date</th>
									<th>Remark</th>
									<!-- <th>Alert To Field Staff</th> -->
								</tr>
								<%
	incr=0 ;
	len=2;
	if(opdSurgeryDetails.size()>0){
		len=opdSurgeryDetails.size();
	}
	Integer surgeryId=0;
	Integer surgeryHeaderId=0;
	String surgery="";
	String surgerRemark="";
	String surgerDate="";
	for(;incr<len;incr++){
		OpdSurgeryDetail opdSurgeryDetails1=null;
		if(opdSurgeryDetails.size()>0 ){
			opdSurgeryDetails1=opdSurgeryDetails.get(incr);
		}
		if(opdSurgeryDetails1!=null){
			surgeryId=opdSurgeryDetails1.getId();
			surgeryHeaderId=opdSurgeryDetails1.getOpdSurgery().getId();
			surgery=opdSurgeryDetails1.getChargeCode().getChargeCodeName()+"["+opdSurgeryDetails1.getChargeCode().getId()+"]";
			if(opdSurgeryDetails1.getRemarks()!=null)
				surgerRemark=opdSurgeryDetails1.getRemarks();
			if(opdSurgeryDetails1.getTentativeDate()!=null)
				surgerDate=HMSUtil.changeDateToddMMyyyy(opdSurgeryDetails1.getTentativeDate());
		}
	%>
								<tr>
									<td><input type="checkbox" class="radioCheck"
										id="surgeryRadio<%=incr%>" name="surgeryRadio<%=incr%>"
										tabindex="31" /> <input type="hidden"
										value="<%=surgeryId!=null && !surgeryId.equals(0)?surgeryId:0 %>"
										name="surgeryDetailsId<%=incr%>"
										id="surgeryDetailsId<%=incr%>" /></td>
									<td><input type="text" class="opdTextBoxSmall textYellow"
										tabindex="32" value="<%=surgery %>"
										id="procedureName_surgery<%=incr%>" size="35"
										name="procedureName_surgery<%=incr%>" />
										<div id="ac2updates_surgery<%=incr%>" style="display: none;"
											class="autocomplete"></div> <script type="text/javascript"
											language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('procedureName_surgery<%=incr%>','ac2updates_surgery<%=incr%>','opd?method=getNursingCareProcedureAutoList',{minChars:3,
						  callback: function(element, entry) {
					            return entry + '&minor_major=2';
					        }, parameters:'requiredField=procedureName_surgery<%=incr%>'});
			</script></td>
									<td><input type="text" id="tentativeDate<%=incr%>"
										value="<%=surgerDate %>" name="tentativeDate<%=incr%>"
										class="small textYellow"
										validate="t1ntativeDate<%=incr%>,string,no"
										readonly="readonly" /> <img src="/hms/jsp/images/cal.gif"
										width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.opdMain.tentativeDate<%=incr%>,event);" />
									</div></td>
									<td><input type="text" name="remark_surgery<%=incr%>"
										value="<%=surgerRemark %>" id="remark_surgery<%=incr%>"
										class="largTextBoxOpd textYellow" /></td>
									<%-- <td><input class="radioCheck" type="checkbox" id="alert_surgery<%=incr %>"	name="alert_surgery<%=incr %>"/></td> --%>

									<%-- <td><input class="" type="checkbox"
										id="alertToStaff<%=incr %>" value="y"
										name="alertToStaff<%=incr %>"
										onclick="displayPhAlert(this.value,'<%=incr%>');" /> <!-- <div id="pHAlertDiv" style="display: none">  -->
										<select name="phAlert<%=incr%>" id="phAlert<%=incr%>"
										style="display: none">
											<option value="">Select</option>
											<option value="DL">Delivery</option>
											<option value="BR">Birth</option>
											<option value="CD">Communicable Disease</option>
											<option value="NCD">Non Communicable Disease</option>
											<option value="PD">Pregnancy Diagnosed</option>
											<option value="MTP">MTP</option>
											<option value="AB">Abbortion</option>
									</select> <!-- </div> --></td> --%>
								</tr>
								<%} %>
							</table>
							<input type="hidden" id="surgeryHeaderId" name="surgeryHeaderId"
								value="<%=surgeryHeaderId%>" />
							</td> <input type="hidden" name="surgeryhdb" value="<%=incr-1 %>"
								id="surgeryhdb" />
						</div>
					</div>
				</div>
			</div>

			<!-- prescription tab :by Rajendra kumar  -->
			<div id="country6" class="tabcontentIn">
				<div class="Block">
					<div></div>
					<input type="button" class="button" value="Template" onclick=""
						align="right" />
					<div>
						<label class="autoSpace"><input type="radio"
							class="radioCheckCol2" name="invTempTypepTab"
							id="invTempTypepTab_local"
							onchange="getTemplate('local','p','ptab');" />Local</label> <label
							class="autoSpace"><input type="radio"
							class="radioCheckCol2" name="invTempTypepTab"
							id="invTempTypepTab_global"
							onchange="getTemplate('global','p','ptab');" />Global</label>
						<%-- 	<input name="Prevoius" type="button"  value="Last Investigation"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" /> --%>

						<select class="midium" name="tempLatePrescriptionTab"
							id="tempLatePrescriptionTab"
							 onfocus="checkEnteredDiagnosis();"
							onchange="fnGetPrescriptionTemplate(this.value);">
							<option value="0">Select</option>
						</select>
					</div>
					<input name="Prevoius2" type="button" class="buttonBig"
						value="Last Prescription"
						onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>',csrfTokenName+'='+csrfTokenValue)" />
					<div class="floatRight">
						<input type="button" class="buttonDel" value=""
							onclick="removeRowPrescriptionTab();" align="right" /> <input
							type="button" class="buttonAdd"
							onclick="addRowPrescriptionTab();" value="" align="right" />
					</div>
					<div class="clear"></div>
					<div class="paddLeft15">
						<div class="tableForTab"
							style="width: 875px; height: 200px; overflow: scroll;">
							<div id="divTemplet2">
								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="prescriptionTabGrid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage</th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<th scope="col">Days</th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
										<th scope="col">Start Date</th>
										<th scope="col">End Date</th>
									</tr>
									<%	
	 incr = 0;len=2;
	if(patientPrescriptionDetails.size()>0){
		len=patientPrescriptionDetails.size();
	}else{
		len=3;
	}
	Integer pHeaderId=0;
	for(;incr< len;incr++){
		String nomeclature="";
		Integer ItemId=0;
		String pvmsNo="";
		int routeId=0;
		int frequencyId=0;
		int inctrunctionId=0;
		String unit="";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		Date sDate=null;
		Date eDate=null;
		String issuedStatus="";
		String routeName="";
		PatientPrescriptionDetails pd=null;
		String pAvailableStatus="";
		if(patientPrescriptionDetails.size()>0){
			pd=patientPrescriptionDetails.get(incr);
			pHeaderId=pd.getPrescription().getId();
			ItemId=pd.getItem().getId();
			if(pd.getIssuedStatus()!=null && !pd.getIssuedStatus().equals("")  && pd.getIssuedStatus().equalsIgnoreCase("y")){
				issuedStatus=pd.getIssuedStatus();
				System.out.println("issuedStatus "+issuedStatus);
			}	
			if(pd.getNotAvailable()!=null){
				pAvailableStatus=pd.getNotAvailable();
			}
			nomeclature=pd.getItem().getNomenclature();
			pvmsNo=pd.getItem().getPvmsNo();
			dosage=pd.getDosage();
			unit=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			ndays=pd.getNoOfDays();
			sDate=pd.getStartDate();
			eDate=pd.getEndDate();
			if(pd.getRoute()!=null){
				routeId=pd.getRoute().getId();
				routeName=pd.getRoute().getRouteName();
			}
			if(pd.getFrequency()!=null){
				frequencyId=pd.getFrequency().getId();
			}
			if(pd.getInsrtuction()!=null){
				inctrunctionId=pd.getInsrtuction().getId();
			}
			if(ItemId!=0 &&  !pvmsNo.equals("")){
				nomeclature=nomeclature+"("+ItemId+")["+pvmsNo+"]";
			}
		}
		%>
									<tr>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" disabled="disabled" class="radioCheck"
											id="itemRadiopTab<%=incr%>" name="itemRadiopTab<%=incr%>" />
											<%}else{ %> <input type="checkbox" class="radioCheck"
											id="itemRadiopTab<%=incr%>" name="itemRadiopTab<%=incr%>" />
											<% }%> <input type="hidden" id="parkPrescriptionIds<%=incr%>"
											name="parkPrescriptionIds<%=incr%>"
											value="<%=pd!=null && pd.getId()!=0?pd.getId():"0"%>"
											readonly="readonly" /> <input type="hidden"
											name="prescription_availableStatuspTab<%=incr %>"
											id="prescription_availableStatuspTab<%=incr %>"
											value="<%= pAvailableStatus%>" />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											class="textYellow largTextBoxOpd" value="<%=nomeclature %>"
											id="nomenclaturepTab<%=incr%>" size="35"
											name="nomenclaturepTab<%=incr%>"
											onkeypress="checkTextColor('nomenclaturepTab<%=incr%>');"
											onblur="populatePVMSTab(this.value,'<%=incr%>');checkPItem('<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr %> );checkForAllergy(this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											class="textYellow largTextBoxOpd" value="<%=nomeclature %>"
											id="nomenclaturepTab<%=incr%>" size="35"
											name="nomenclaturepTab<%=incr%>"
											onfocus="checkEnteredDiagnosis();checkFrequency('<%=incr%>','tab');"
											onkeypress="checkTextColor('nomenclaturepTab<%=incr%>');"
											onblur="populatePVMSTab(this.value,'<%=incr%>');checkPItem('<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr %>);checkForAllergy(this.value,<%=incr%>);" />
											<% }%>


											<div id="ac2updatespTab<%=incr%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclaturepTab<%=incr%>','ac2updatespTab<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturepTab<%=incr%>'});
					</script>
				<input type="hidden" name="pvmsNopTab<%=incr %>" tabindex="33" id="pvmsNopTab<%=incr %>" value="" size="10" readonly="readonly" />
				<input type="hidden" name="actualDispensingQtypTab<%=incr%>" tabindex="1" id="actualDispensingQtypTab<%=incr%>" value="" size="6" validate="AU,string,no" />
										</td>
										<td>
								 <select name="routepTab<%=incr%>"
											id="routepTab<%=incr%>"
											style="width: 70px; background: #FFFF99">
												<option value="0">Select</option>
												<%
					      for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select>
										</td>
										<td><input class="textYellow opdTextBoxTSmall"
											type="text" name="dosagepTab<%=incr%>"
											value="<%=dosage!=null && dosage!=0?dosage:"" %>"
											onblur="fillValuepTab(this.value,<%=incr%>);"
											id="dosagepTab<%=incr%>" size="10" maxlength="45" />
											<div id="testDivpTab<%=incr%>"></div></td>
										<td><input type="text" name="unitpTab<%=incr%>"
											class="textYellow opdTextBoxTSmall" id="unitpTab<%=incr%>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											readonly="readonly" size="5"
											validate="unit<%=incr%>,string,no" /></td>
										<td><input type="hidden"
											name="frequencyValuepTab<%=incr%>" tabindex="1"
											id="frequencyValuepTab<%=incr%>" size="6" /> <input
											type="hidden" name="sosQtypTab<%=incr%>" tabindex="1"
											id="sosQtypTab<%=incr%>" style="display: none;" size="3"
											maxlength="3" validate="Sos Qty,num,no" /> <select
											style="width: 70px; background: #FFFF99"
											name="frequencypTab<%=incr%>" id="frequencypTab<%=incr%>"
											onchange="getFrequencyValuepTab(this.value,<%=incr%>);fillValueFromFrequencypTab(this.value,<%=incr%>);displaySOSQtypTab(this.value,<%=incr%>)">
												<option value="0">Select</option>
												<%
				  MasFrequency masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %>
												<%if(frequencyId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%
				  MasFrequency masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>

		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
										<td><input type="text" name="noOfDayspTab<%=incr%>"
											id="noOfDayspTab<%=incr%>"
											class="textYellow opdTextBoxTSmall"
											value="<%=ndays!=0 ?ndays:"" %>" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValuepTab(this.value,<%=incr%>);setEndDate(this.value,<%=incr %>);" />
										</td>
										<td><select style="width: 70px; background: #FFFF99"
											name="instrunctionpTab<%=incr%>"
											id="instrunctionpTab<%=incr%>"><option value="0">Select</option>
												<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
					}
					%>
										</select></td>
										<td><input type="text"
											name="splInstrunctionpTab<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunctionpTab<%=incr %>" maxlength="200" /></td>
										<td><input type="text" name="totalpTab<%=incr%>"
											id="totalpTab<%=incr%>"
											value="<%=total!=null && total!=0?total:"" %>"
											class="textYellow opdTextBoxTSmall" size="5"
											validate="Total,num,no" readonly="readonly" /></td>
										<td><div style="width: 145px;">
												<input size="5" type="text" name="startDate<%=incr%>"
													value="<%=currentDate%>" class="textYellow small"
													value="<%=sDate!=null ?sDate:"" %>" id="startDate<%=incr%>"
													validate="startDate<%=incr%>,string,no" readonly="readonly"
													onblur="compareDate(<%=incr%>);checkStartDate(<%=incr%>)" />
												<img src="/hms/jsp/images/cal.gif" width="16" height="16"
													border="0" validate="Pick a date"
													onclick="setdate('<%=currentDate%>',document.opdMain.startDate<%=incr%>,event);" />
											</div></td>
										<td><div style="width: 145px;">
												<input size="5" type="text" name="endDate<%=incr%>"
													class="textYellow small" value="" id="endDate<%=incr%>"
													validate="endDate<%=incr%>,string,no" readonly="readonly"
													onblur="compareDate(<%=incr%>);checkEndDate(<%=incr%>)" />
												<img src="/hms/jsp/images/cal.gif" validate="Pick a date"
													onclick="setdate('<%=currentDate%>',document.opdMain.endDate<%=incr%>,event);" />
											</div></td>
									</tr>
									<%}%>
								</table>
								<input type="hidden" name="pTabhdb" value="<%=incr-1%>"
									id="pTabhdb" />
							</div>
						</div>
						<div class="floatLeft">
							<label class="auto"><img
								src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" /><span>Stock
									not available for medicine</span></label>
						</div>
					</div>
					<div class="clear"></div>

				</div>
				<div class="clear"></div>
				<div class="division" style="width: 790px;"></div>
				<div class="clear"></div>
				<input type="button" class="buttonBig" name="prev"
					value="Save As Template"
					onclick="javascript:openPopupForSavePrescriptiontamplateTab();" />
				<!-- countries.cycleit('prev') -->
			</div>

			<!-- Comorbidity Tab: Rajendra Kumar 24-03-2015 -->
			<div id="country7" class="tabcontentIn">
				<div class="Block" style="width: 750px;">
					<div class="floatRight" style="margin-right: 55px;">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							align="right" onclick="removeForComorbidity();" /> <input
							type="button" class="buttonAdd" alt="Add" tabindex="4"
							onclick="addRowForComorbidity();" align="right" />
					</div>
					<div class="clear"></div>
					<div class="tableForTab">
						<div id="divTemplet">
							<div id="divComorbidity">
								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="comorbidityGrid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Comorbidity</th>
										<th scope="col">Since:Month</th>
										<th scope="col">Year</th>
										<th scope="col">Remarks</th>
									</tr>
									<%incr=0;// dischargeIcdCodeLast3Visit
									if(dischargeIcdCodeLast3Visit!=null && dischargeIcdCodeLast3Visit.size()>0 ){
										for(DischargeIcdCode icd:dischargeIcdCodeLast3Visit){
											String comorbidity=icd.getIcd().getIcdName()+"["+icd.getIcd().getIcdCode()+"]";
											String sinceMonth="";
											String sinceYear="";
											String remarks="";
											if(icd.getComorbidityStatus()!=null && icd.getComorbidityStatus().equalsIgnoreCase("y")){
												sinceMonth=icd.getSinceMonth();
												sinceYear=icd.getSinceYear();
												remarks=icd.getComorbidityRemark();		
										%>
										<tr>
											<td><input type="checkbox" class="radioCheck" id="comorbidityRadio<%=incr %>"	name="comorbidityRadio<%=incr %>" /></td>
											<td><input type="text" class="opdTextBoxSmall textYellow" value="<%=comorbidity %>" id="comorbidityName<%=incr %>" name="comorbidityName<%=incr %>" />
												<div id="ac2updateComorbidity<%=incr %>" style="display: none;" class="autocomplete"></div>
												<script	type="text/javascript" language="javascript" charset="utf-8">
							  					new Ajax.Autocompleter('comorbidityName<%=incr %>','ac2updateComorbidity<%=incr %>','opd?method=getICDList',{parameters:'requiredField=icd'});
												</script>
											</td>
											<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityMonth<%=incr %>" value="<%=sinceMonth %>"	id="comorbidityMonth<%=incr %>" /></td>
											<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityYear<%=incr %>"  value="<%=sinceYear %>"	id="comorbidityYear<%=incr %>" /></td>
											<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityRemark<%=incr %>" value="<%=remarks!=null && !remarks.equals("")?remarks:"" %>"	id="comorbidityRemark<%=incr %>" /></td>
										</tr>	
									<%
									incr++;
											}}}else{%>
											<%for(;incr<2;incr++){ %>
											<tr>
												<td><input type="checkbox" class="radioCheck" id="comorbidityRadio<%=incr %>"	name="comorbidityRadio<%=incr %>" /></td>
												<td><input type="text" class="opdTextBoxSmall textYellow" value="" id="comorbidityName<%=incr %>" name="comorbidityName<%=incr %>" />
													<div id="ac2updateComorbidity<%=incr %>" style="display: none;" class="autocomplete"></div>
													<script	type="text/javascript" language="javascript" charset="utf-8">
								  					new Ajax.Autocompleter('comorbidityName<%=incr %>','ac2updateComorbidity<%=incr %>','opd?method=getICDList',{parameters:'requiredField=icd'});
													</script>
												</td>
												<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityMonth<%=incr %>"	id="comorbidityMonth<%=incr %>" /></td>
												<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityYear<%=incr %>"	id="comorbidityYear<%=incr %>" /></td>
												<td><input type="text" class="opdTextBoxSmall textYellow"	name="comorbidityRemark<%=incr %>"	id="comorbidityRemark<%=incr %>" /></td>
											</tr>
										<%}
									}
									%>
								</table>
							</div>
						</div>
					</div>
					<input type="hidden" value="<%=incr -1%>" id="comorbidityCount"
						name="comorbidityCount" />
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="division"></div>
				<div class="clear"></div>
			</div>



			<!-- Comorbidity Tab: Rajendra Kumar 24-03-2015 -->
			<div id="country8" class="tabcontentIn">
				<div class="Block" style="width: 750px;">
					<div class="clear"></div>

					<label>Speciality</label> <select id="specialty" name="specialty"
						onchange="display(this.value)">
						<option value="0">Select</option>
						<%for(MasSpecialtyTemplate mstp:specialtyTemplateList){ %>
						<option value="<%=mstp.getId()%>"><%=mstp.getTemplateName()%></option>
						<%} %>
					</select>
					<div id="specialityDiv"></div>
				</div>
			</div>
			<!-- MLC Tab: Amit Das 21-04-2016 -->
			<div id="country9" class="tabcontentIn">
				<div class="Block">
					<label>MLC certificate </label>
					 <select name="mlscasetype"	id="mlscasetype" multiple="multiple" class="multiple1" size="5">
						<option value="0">Select</option>
						<option value="Examination by a Medical Officer" <%=patientWiseMlcs.contains("Examination by a Medical Officer")? "selected='selected'":"" %>>Certificate of Examination by a Medical Officer</option>
						<option	value="Examination by a Specialist Medical Officer/Team of Specialist Medical Officers" <%=patientWiseMlcs.contains("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers")? "selected='selected'":"" %>>Certificate	of Examination by a Specialist Medical Officer/Team of Specialist Medical Officers</option>
						<option value="Accident Register-cum-Wound Certificate" <%=patientWiseMlcs.contains("Accident Register-cum-Wound Certificate")? "selected='selected'":"" %>>Accident Register-cum-Wound Certificate</option>
						<%if(visit.getHin().getSex()!= null && visit.getHin().getSex().getAdministrativeSexCode().equals("F") && visit.getHin().getSex().getId()==2){%>
							<option value="Examination of a female victim of sexual assault" <%=patientWiseMlcs.contains("Examination of a female victim of sexual assault")? "selected='selected'":"" %>>Report	of examination of a female victim of sexual assault</option>
						<%}else{ %>
						<option value="Examination of a male accused in sexual offence" <%=patientWiseMlcs.contains("Examination of a male accused in sexual offence")? "selected='selected'":"" %>>Report of examination of a male accused in sexual offence</option>
						<%} %>
						<option value="Certificate Of Drunkness" <%=patientWiseMlcs.contains("Certificate Of Drunkness")? "selected='selected'":"" %>>Certificate Of	Drunkness</option>
						<option	value="Examination of a victim alleged to have been drugged" <%=patientWiseMlcs.contains("Examination of a victim alleged to have been drugged")? "selected='selected'":"" %>>Report	of examination of a victim alleged to have been drugged</option>
						<option value="Examination for evidence of recent delivery" <%=patientWiseMlcs.contains("Examination for evidence of recent delivery")? "selected='selected'":"" %>>Report of examination for evidence of recent delivery</option>
						<option	value="Examination of a victim of unnatural sexual offence" <%=patientWiseMlcs.contains("Examination of a victim of unnatural sexual offence")? "selected='selected'":"" %>>Report of examination of a victim of unnatural sexual offence</option>
						<option value="Treatment / Discharge Certificate" <%=patientWiseMlcs.contains("Treatment / Discharge Certificate")? "selected='selected'":"" %>>Treatment	/ Discharge Certificate</option>
						<option value="Examination for estimation of age" <%=patientWiseMlcs.contains("Examination for estimation of age")? "selected='selected'":"" %>>Report of examination for estimation of age</option>
						<option	value="Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc" <%=patientWiseMlcs.contains("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc")? "selected='selected'":"" %>>Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc</option>
						<option value="Final opinion as to cause of death" <%=patientWiseMlcs.contains("Final opinion as to cause of death")? "selected='selected'":"" %>>Final opinion as to cause of death</option>
						<option value="Mortuary" <%=patientWiseMlcs.contains("Mortuary")? "selected='selected'":"" %>>Mortuary</option>
						<option value="Chemical Analysis" <%=patientWiseMlcs.contains("Chemical Analysis")? "selected='selected'":"" %>>Chemical Analysis</option>
						<option value="Application cum No Objection Certificate" <%=patientWiseMlcs.contains("Application cum No Objection Certificate")? "selected='selected'":"" %>>Form of Application cum No Objection Certificate</option>
						<option value="Application cum Certificate of Authenticity" <%=patientWiseMlcs.contains("Application cum Certificate of Authenticity")? "selected='selected'":"" %>>Form of Application cum Certificate of Authenticity</option>
						<!-- <option value="Request for Radiological examination as part of estimation of Age">Request for Radiological examination as part of estimation of Age</option> -->
						<!-- <option value="Proforma for recording dying declaration by a medical practitioner">Proforma for recording dying declaration by a medical practitioner</option> -->

					</select>
					<label>
						<%if(opdPatientDetails!=null && opdPatientDetails.getPoliceIntimation()!=null && opdPatientDetails.getPoliceIntimation().equalsIgnoreCase("y")){ %>
						 <input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" checked="checked" />Police Intimation
						 <%}else{ %>
						 	<input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" />Police Intimation
						 <%} %>
					</label>	 
				</div>
			</div>

			<div class="clear"></div>
			<div class="division"></div>
			<div class="clear"></div>
			<input name="Submit11" id="Submit11" type="button" align="right" 	class="buttonAuto" value="Submit" onclick="fnSubmitPatient('s');" />
			<div class="clear"></div>
			<div class="division"></div>
		</div>
		<script type="text/javascript">
		var countries=new ddtabcontent("countrytabsIn")
		countries.setpersist(true)
		countries.setselectedClassTarget("link") //"link" or "linkparent"
		countries.init()
		countries.expandit(0);
		</script>
		<input id="visitId" name="visitId" id="visitId" type="hidden"
			value="<%=visit.getId()%>" /> <input name="hinId" id="hinId" type="hidden"
			value="<%=visit.getHin().getId()%>" /> <input name="hinNo" id="hinNo"
			type="hidden" value="<%=visit.getHin().getHinNo()%>" /> <input
			name="departmentId" type="hidden"
			value="<%=visit.getDepartment().getId()%>" /> <input
			name="hospitalId" id="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
			name="empId" type="hidden" value="<%=docId%>" /> <input
			name="deptId" type="hidden" value="<%=deptId%>" /> <input id="consultationDate"
			name="consultationDate" type="hidden" value="<%=consultationDate%>" />
		<input name="consultationTime" type="hidden"
			value="<%=consultationTime%>" /> <input name="relation"
			type="hidden" value="<%=relationName%>" /> <input name="pHeaderId"
			type="hidden" value="<%=pHeaderId%>" /> <input
			name="opdpatientDetailId" type="hidden"
			value="<%=opdpatientDetailId%>" />
		<input type="hidden" id="patientName" name="patientName" value="<%=patientName %>" />	

		<%
		String orderSeqNo="";
		if(mapForDS.get("orderSeqNo") != null){
			orderSeqNo = (String)mapForDS.get("orderSeqNo");
		}
 %>
		<input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />

		<div class="arrowlistmenu" style="margin-top: -48px">
			<h3 class="menuheader expandable">OPD Management</h3>
			<ul class="categoryitems">
				<li><a
					href="javascript:showPatientHistory('<%=visit.getHin().getHinNo() %>',csrfTokenName+'='+csrfTokenValue)">Patient
						History</a></li>
				<li><a href="javascript:showDiagnosis(csrfTokenName+'='+csrfTokenValue)">Clinical Assist</a></li>
				<li><a
					href="javascript:popFuturConsultation('registration?method=showOnlineAppointmentJsp&futureConsultFlag=1&uhid=<%=visit.getHin().getHinNo()%>&'+csrfTokenName+'='+csrfTokenValue);">Future
						Consultation</a></li>
				<li><a href=javascript:void(0)>Patient Referral</a></li>
				<li><a href="javascript:showParkPatient('p');">List of
						Parked Patients</a></li>
				<%if(patientAge<=18){%>
				<li><a
					href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>');">Immunization</a></li>
				<%}else{%>
				<!-- <li><a href="">Immunization</a></li> -->
				<%}%>

				<li><a
					href="javascript:popwindowUploadDocuments('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue);">Upload
						Document</a></li>
				<li><a
					href="javascript:popwindowResultEntry('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>');">Result
						Entry</a></li>
				<li><a href="javascript:openPopupWindowAllergy(csrfTokenName+'='+csrfTokenValue);">Allergy</a></li>
			</ul>
			<%
		String empDeptCode="";
				for (MasDepartment  masDepartment : masDepartmentList){
					if(masDepartment.getEmpDept() != null){
						empDeptCode=masDepartment.getEmpDept().getEmpDeptCode();
					}
					
				}
				
					if(empDeptCode.equalsIgnoreCase(empDeptCodeForOPTH)){%>
			<h3 class="menuheader expandable">Opd Specification</h3>
			<ul class="categoryitems">

				<li>
				<li><a
					href="javascript:openPopupForOphthalmology('opd?method=showOpdOphthamologyJsp&visitId=<%=visit.getId()%>');">Ophthalmology</a></li>
			</ul>
			<%} %>
			<%if(empDeptCode.equalsIgnoreCase(empDeptCodeForGYNE)){%>
			<h3 class="menuheader expandable">Opd Specification</h3>
			<ul class="categoryitems">


				<li><a
					href="javascript:openPopupForAntenatal('opd?method=showAntenatalCardJsp&visitId=<%=visit.getId()%>');">Antenatal
						Card</a></li>
				<li><a
					href="javascript:openPopupForAntenatal('opd?method=showOBGONEJsp&visitId=<%=visit.getId()%>');">OBG</a></li>

			</ul>
			<%} %>
		</div>
		<td><input name="request" id="requestId" type="hidden"
			value="<%=visit.getHin().getId()%>" /></td>
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<div class="clear"></div>
	</form>
</body>
<div id="dialog" title="BMI" style="display: none;">
	<label class="auto">Weight</label><input type="text" class="textYellow"
		id="weight" maxlength="3" class="allownumericwithoutdecimal"
		value="<%=weight==0?"":weight %>" validate="Height,int,no" /><span>Kg.</span>
	<div class="clear"></div>
	<label class="auto">Height</label><input type="text" class="textYellow"
		maxlength="3" class="allownumericwithoutdecimal"
		value="<%=height==0?"":height %>" id="height" validate="Height,int,no" /><span>Cms.</span>
	<div class="clear"></div>
	<input type="button" class="button" id="submitCalBMI" value="Submit" />
	<input type="button" class="button" value="Reset" id="resetBmi" />
</div>

<div id="vitalDialog" title="Vital Trends" style="display: none;">
	<label class="auto">UHID</label><input type="text" id="vitalUHID"
		class="auto" readonly="readonly" /> <label class="auto">Patient
		Name</label><input type="text" id="vitalPname" class="auto"
		readonly="readonly" />
	<div class="clear"></div>
	<table id="vitalTable"></table>
	<div class="clear"></div>
	<!-- <div id="chartContainer" style="height: 300px; width: 100%;"></div> -->
</div>

<!--main content placeholder ends here-->
<script type="text/javascript">

jQuery(function ($) {

	 $("#referral").change(function(){
		if($("#referral").val()==1){
			$("#admDiv").hide(); 
			$("#admissionAdvised").prop( "checked", false );
			$("#admissionAdvised").prop('disabled', true);
		}else{
			$("#admissionAdvised").prop('disabled', false);
		}
	});

	 $('input[name="labradiologyCheck"]').change(function(){
		//alert($('input[name="labradiologyCheck"]:checked').val());
		$('#investigationCategory').val($('input[name="labradiologyCheck"]:checked').val());
	});
	$('#investigationCategory').val($('input[name="labradiologyCheck"]:checked').val());
	$("#vitalTrends").click(function(){
		var hinId=document.getElementById("hinId").value;;
		new Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='No vital Details')
    	    	  {		
	    	  		  $("#vitalUHID").val(document.getElementById("hinNo").value);
	    	    	  $("#vitalPname").val(document.getElementById("patientName").value); 
	    	    	  $("#vitalTable").html(response.responseText.trim()); 
	    	    	  $("#vitalDialog").dialog({width:842,height:332,modal: true});
    	    	  }else{
    	    		  alert("No vital details");
    	    	  }
	    	  }
	  	  });
		});
	 $("#calculateBmi").click(function(){
		 $("#dialog").css("color:black");
		 $("#dialog").dialog({width: 350,modal: true});
	 });
	 
	$("#resetBmi").click(function(){
			$("#height").val("");
			$("#weight").val("");
	});
	 $("#submitCalBMI").click(function(){
		 var bmicat;
			$("#bmi").val("");
			
			if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
			{
			
			 $("#heightHidden").val($("#height").val());
			 $("#weightHidden").val($("#weight").val());
			 
			 var height = 	parseFloat($("#height").val())/100;
			 var weight = 	$("#weight").val();
			 
			 $("#bmi").val((weight/(height*height)).toFixed(2));
			 bmicat=(weight/(height*height)).toFixed(2);
			
			 $("#bmicat").val(" ");
			 if(bmicat<18.5){
				 $("#bmicat").val("Underweight");
				 $("#bmicat").prev().css('color', '#F65C5C');
				 $("#bmicat").css('color', '#F65C5C');
			}else if(bmicat>=18.5 && bmicat<25){
				$("#bmicat").val("Healthy Range");	
				$("#bmicat").prev().css('color', 'green');
				$("#bmicat").css('color', 'green');
			}else if(bmicat>=25 && bmicat<=30){
				$("#bmicat").val("Overweight");
				$("#bmicat").prev().css('color', '#574F4F');
				$("#bmicat").css('color', '#574F4F');
			}else if(bmicat>=30 && bmicat<=35){
				$("#bmicat").val("Obese");
				$("#bmicat").prev().css('color', '#C40707');
				$("#bmicat").css('color', '#C40707');
			}else if(bmicat>35){
				$("#bmicat").val("Severely obese ");
				$("#bmicat").prev().css('color', '#AD0C0C');
				$("#bmicat").css('color', '#AD0C0C');
			}
			}
			$("#bmicat").val()
			$('#dialog').dialog('close');
	});
	 
	 $("#temperature").blur(function (){
		if($("#temperature").val()>999 ){
			alert("Invalide Temperature");
			$("#temperature").focus();
			$("#temperature").val("");
		}
	}); 
	
	 $(".allownumericwithdecimal").on("keypress keyup blur",function (event) {
         //this.value = this.value.replace(/[^0-9\.]/g,'');
	  	$(this).val($(this).val().replace(/[^0-9\.]/g,''));
	         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) && ((event.keyCode !=  39)) && (event.keyCode != 9) && (event.keyCode != 8)&&(event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	             event.preventDefault();
	         }
	   });

	$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
        $(this).val($(this).val().replace(/[^\d].+/, ""));
         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) &&((event.keyCode !=  39))  && (event.keyCode != 9) && (event.keyCode != 8)&&(event.which < 48 || event.which > 57)) {
             event.preventDefault();
         }
     });

	 
	 $("#generalExamination1").dblclick(function(){
		 $("#generalExaminationOPC").val($.trim($("#generalExaminationOPC").val()+"\n"+$("#generalExamination1 option:selected" ).text()));
		 $("#generalExaminationEXM").val($.trim($("#generalExaminationEXM").val()+"\n"+$("#generalExamination2 option:selected" ).text()));
	 });
	 $("#generalExamination2").dblclick(function(){
		 $("#generalExaminationOPC").val($.trim($("#generalExaminationOPC").val()+"\n"+$("#generalExamination1 option:selected" ).text()));
		 $("#generalExaminationEXM").val($.trim($("#generalExaminationEXM").val()+"\n"+$("#generalExamination2 option:selected" ).text()));
	 });
	 $("#diastolic").blur(function(){
	    if(parseInt($("#systolic").val())<parseInt($("#diastolic").val())){
	    	alert("Diastolic should be less than Systolic");
	    	$("#diastolic").val("");
	    	$("#diastolic").focus();
	    }
	});
	 $("#removeOPDisgnosis").click(function(){
		 if($("#diagnosisId option:selected").length>1){
			 alert("You can delete only one option at a time !");
		 }else{
			 $("#diagnosisId option:selected").remove();
			 deleteRowFromOPConsultationTab($("#diagnosisId1 option:selected").index());
		 }
	}); 
	 $("#removeOPDisgnosis").click(function(){
		 if($("#diagnosisId option:selected").length>1){
			 alert("You can delete only one option at a time !");
		 }else{
			 $("#diagnosisId option:selected").remove();
			 deleteRowFromOPConsultationTab($("#diagnosisId1 option:selected").index());
		 }
	});
	 $("#removeSnomed").click(function(){
		 document.getElementById("snomed").value='';
	});
	 $("#icd").blur(function(){
		 var code1 = {};
		
		 $("select[name='diagnosisId'] > option").each(function () {
		     if(code1[this.text]) {
		         $(this).remove();
		     } else {
		         code1[this.text] = this.value;
		     }
		 }); 
		 
	 });
	 $('#admissionAdvised').click(function () {
		    $("#admDiv").toggle(this.checked);
	});
	 
	 $('#patient_expire').click(function () {
		 var checked = $(this).is(':checked');
		 $("#referral").val('0');
		 if(checked){
			 if($("#referral").val()==0){
     			 $("#referalDiv").hide();
			 	 $("#referDiv").hide();
			 	$("#siftedToMortuaryDiv").show();
			 }
		 }else{
     			$("#referalDiv").show();
			 	$("#referDiv").hide();
			 	$("#siftedToMortuaryDiv").hide();
		 }
	});
	 $('#referral').click(function () {
		var selVal= $("#referral").val();
		 if(selVal==0){
			 $("#referDiv").hide();
		 }else if(selVal==1){
			 $("#referDiv").show();
		 }
	});
});
function drawParkDiagnosisTable(){
		var	diagArray= new Array();
		var obj =document.getElementById('diagnosisId1');
		<%for(int k = 0; k < dischargeIcdCodeLast3Visit.size(); k++)
		{%>
			var tableRow=obj.rows.length;
			var row = obj.insertRow(tableRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
		<%	DischargeIcdCode dIcd = (DischargeIcdCode) dischargeIcdCodeLast3Visit.get(k);
			MasIcd masIcd =  dIcd.getIcd();
		    String icdName=masIcd.getIcdName();
		    String icdCode=masIcd.getIcdCode();
		    int  icdId=dIcd.getId();
		    String comorBidityStatus=dIcd.getComorbidityStatus()!=null && dIcd.getComorbidityStatus().equalsIgnoreCase("y")?"checked":"";
		    String namecode=icdName+"["+icdCode+"]";
		%>
			var id="<%=icdCode%>";
			id=id.replace(".","_");
	    	id=id.replace("*","idid");
			cell1.innerHTML="<%=namecode%>";
			cell2.innerHTML = "<input type='checkbox'  <%=comorBidityStatus%> id='"+id+"' class='radioCheckCol2' value='"+id+"' onclick='fnCopyToComorbidityTab(\""+id+"\")'/>";
			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>";
		<% }%> 
}


		// onload
		
		var referralType = '<% out.print(referralType);%>';
		//alert(referralType);
		
		if(referralType == 'NA')
			{
				document.getElementById('referInternal').checked=true;
				checkReferTO('referInternal');
			}
		if(referralType == 'External')
		{
			document.getElementById('referExternal').checked=true;
			checkReferTO('referExternal');
		}
		if(referralType == 'Internal')
		{
			document.getElementById('referInternal').checked=true;
			checkReferTO('referInternal');
		}
		

		 function getFrequencyValue(feqValue,inc){
				var feqQty;
				<%
				if(frequencyList.size()>0){	
					for(MasFrequency masFrequency :frequencyList){
				%>
				 if(feqValue == '<%=masFrequency.getId()%>'){
					 feqQty = '<%=masFrequency.getFrequencyCount()%>'
				  }
		
				<%}
				}%>
				 document.getElementById('frequencyValue'+inc).value = feqQty;
				 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
		 }

	
		function getFrequencyValuepTab(feqValue,inc){
				var feqQty;
				<%
				if(frequencyList.size()>0){	
					for(MasFrequency masFrequency :frequencyList){
				%>
				 if(feqValue == '<%=masFrequency.getId()%>'){
					 feqQty = '<%=masFrequency.getFrequencyCount()%>'
				  }
		
				<%}
				}%>
				 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
			}

</script>

<!-- Added By Kaushal Mishra -->
<script type="text/javascript">

function checkForValidMortuary(){
	var mlscasetype = document.getElementById("mlscasetype");
	var patientExpire = document.getElementById("patient_expire");
	var i;
	var count =0;
	var mortuaryFlag = false;
	var remainingFlag = false;
	for(i=0;i<mlscasetype.length;i++){
		if(mlscasetype.options[i].selected && mlscasetype.options[i].value == 'Mortuary'){
			count++;
			if(patientExpire.checked){
				mortuaryFlag = true;
				break;
			} else{
				remainingFlag = false;
				break;		
			}
		} else if(mlscasetype.options[i].selected) {
			count++;
			remainingFlag = true;
		}
		
	}	
	
		if(mortuaryFlag)
			return true;
		else if(remainingFlag)
			return true;
		else if(!mortuaryFlag && !remainingFlag && count>0){
			alert("Please select Patient is Dead !");
			return false;
		} else if(count==0)
			return true;	
	
}
</script>

<%
	patientDataList.clear();
	storeBrandList.clear();
	templateList.clear();
	frequencyList.clear();
	deptList.clear();
	dietList.clear();
%>