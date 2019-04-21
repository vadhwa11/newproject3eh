<%@page import="jkt.hms.masters.business.PhDiseaseRegistration"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreOutItem"%>
<%@page import="jkt.hms.masters.business.PhProbablePregnancy"%>
<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@page import="jkt.hms.masters.business.PhFpRegDetail"%>
<%@page import="jkt.hms.masters.business.BabyDetails"%>
<%@page import="jkt.hms.masters.business.Birthdeathreg"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DeliveryDetails"%>
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
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>

<script type="text/javascript" 
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/prescription.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.multi-select.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="/hms/jsp/css/multiselect.css">
	
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
		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 06-09-2016 
		List<PhProbablePregnancy> phProbablePregnancyList = new ArrayList<PhProbablePregnancy>(); // added by amit das 13-09-2016
		
		int incr=0 ;
		int len=0;
		

		
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
		
		// addded by amit das on 06-09-2016
		if(map.get("patientEpisodeList") != null){
			patientEpisodeList=(List<PatientEpisode>)map.get("patientEpisodeList");
		} 
		
		// addded by amit das on 13-09-2016
		if(map.get("phProbablePregnancyList") != null){
			phProbablePregnancyList=(List<PhProbablePregnancy>)map.get("phProbablePregnancyList");
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
		
		List<MasStoreOutItem> masStoreOutItemsList = new   ArrayList<MasStoreOutItem>();
		if(map.get("masStoreOutItemsList") != null)
		{
			masStoreOutItemsList=(List<MasStoreOutItem>)map.get("masStoreOutItemsList");
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
	 // 	List<MasHospital>masHospitals=new ArrayList<MasHospital>();
	  	List<Object[]> masHospitals = new ArrayList<Object[]>();
	  	if(map.get("masHospitals") != null)
		{
	  		masHospitals=(List<Object[]>)map.get("masHospitals");
		}
	  	String majorHealthIssue="";
	  	//added by govind 17-9-2016
		List<PhMemberSurvey> phMemberSurveyList =new ArrayList<PhMemberSurvey>();
	  	if(map.get("phMemberSurveyList") != null)
		{
	  		phMemberSurveyList=(List<PhMemberSurvey>)map.get("phMemberSurveyList");
	  		System.out.println("jsp phMemberSurveyList size "+phMemberSurveyList.size());
	  		if(phMemberSurveyList.size()>0){
	  			PhMemberSurvey phMs=new PhMemberSurvey();
	  			phMs=phMemberSurveyList.get(0);
	  			majorHealthIssue=phMs.getMajorHealthIssue();
	  		}
		}
	  
	  	OpdPatientDetails opdPatientDetails = null;
		String lastEncounterDetail = "";
		
		Integer opdpatientDetailId=0;
		int referredDept=0;
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
			referredDept = opdPatientDetails.getReferedDepartment()!=null?opdPatientDetails.getReferedDepartment().getId():0;
		}
		
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
		List<PatientPrescriptionDetails> patientOtherPrescriptionDetails= new ArrayList<PatientPrescriptionDetails>();
		if(map.get("patientOtherPrescriptionDetails") != null)
		{
			patientOtherPrescriptionDetails=(List<PatientPrescriptionDetails>)map.get("patientOtherPrescriptionDetails");
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
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		Patient patient = null;
	  	Integer pulse=0;
	  	Float temperature=0f;
	  	String bpSystolicDiastolic="";
	  	Float bmi=0f;
	  	Float respirtoryRate=0f;
	  	Float spo2=0f;
	  	String bmiStatus="";
	  	Double height=0.0;
	  	Double weight=0.0;
	  	String presentComplaintHistory="";
		String personalPresentHistory="";
		String familyPastHistory="";
		String physicalExamination="";
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
	  		height=preOpdPatientDetails.getHeight()!=null?preOpdPatientDetails.getHeight():0.0;
	  		weight=preOpdPatientDetails.getWeight()!=null?preOpdPatientDetails.getWeight():0;
	  		respirtoryRate =preOpdPatientDetails.getRespiratoryRate()!=null?preOpdPatientDetails.getRespiratoryRate():0;
	  		spo2 = preOpdPatientDetails.getSpo2()!=null?preOpdPatientDetails.getSpo2():0;
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
	  		presentComplaintHistory=preOpdPatientHistory.getPresentComplaintHistory()!=null?preOpdPatientHistory.getPresentComplaintHistory().replace(",", "\n"):"";
	  		personalPresentHistory=preOpdPatientHistory.getPersonalPresentHistory()!=null?preOpdPatientHistory.getPersonalPresentHistory().replace(",", "\n"):"";
	  		familyPastHistory=preOpdPatientHistory.getFamilyPastHistory()!=null?preOpdPatientHistory.getFamilyPastHistory().replace(",", "\n"):"";
	  		madicationHistory=preOpdPatientHistory.getMadicationHistory()!=null?preOpdPatientHistory.getMadicationHistory().replace(",", "\n"):"";
	  		opdPatientHistoriesStr=preOpdPatientHistory.getPastIllnessHistory()!=null?preOpdPatientHistory.getPastIllnessHistory().replace(",", "\n"):"";
	  		physicalExamination=preOpdPatientHistory.getPhysicalExamination()!=null?preOpdPatientHistory.getPhysicalExamination().replace(",", "\n"):"";
		}else if(map.get("majorHealthIssue") != null)
		{
			presentComplaintHistory=(String)map.get("majorHealthIssue");
		}	  		
	  	
	  	String personalPresentHistoryMember="";
	  	boolean ncd=false;
	  	//added by govind 17-9-2016
		List<PhDiseaseRegistration> phNCDRegList =new ArrayList<PhDiseaseRegistration>();
	  	if(map.get("phMemberSurveyList") != null)
		{
	  		phMemberSurveyList=(List<PhMemberSurvey>)map.get("phMemberSurveyList");
	  		System.out.println("jsp phMemberSurveyList size "+phMemberSurveyList.size());
	  		if(phMemberSurveyList.size()>0){
	  			PhMemberSurvey phMs=new PhMemberSurvey();
	  			phMs=phMemberSurveyList.get(0);
	  			majorHealthIssue=phMs.getMajorHealthIssue()!=null?phMs.getMajorHealthIssue():"";
	  			//Added by Arbind on 15-11-2017
	  			if(preOpdPatientHistory.getPersonalPresentHistory()!=null && preOpdPatientHistory.getPersonalPresentHistory().contains("Tobacco Use--")) {
	  				
	  			} else {
	  				personalPresentHistoryMember=phMs.getTobaccoUse()!=null?"Tobacco Use--"+phMs.getTobaccoUse()+" ":"";
	  				personalPresentHistoryMember+=phMs.getTobaccoType()!=null && !phMs.getTobaccoType().equals("")?"Type--"+phMs.getTobaccoType():"";
	  				personalPresentHistoryMember+=phMs.getAlcoholUse()!=null?"\nAlcohol Use--"+phMs.getAlcoholUse():"";
	  				personalPresentHistoryMember+=phMs.getDiet()!=null && !phMs.getDiet().equals("Select") && !phMs.getDiet().equals(" Select")?"\nDiet--"+phMs.getDiet():"";
	  				if(map.get("phNCDRegList") != null) {
	  					phNCDRegList=(List<PhDiseaseRegistration>)map.get("phNCDRegList");
	  					if(phNCDRegList.size() > 0) {
	  						PhDiseaseRegistration phNcd = new PhDiseaseRegistration();
	  						phNcd=phNCDRegList.get(0);
	  						ncd = true;
	  						personalPresentHistoryMember+=phNcd.getDiagnosis()!=null?"\nNCD Diagnosis--"+phNcd.getDiagnosis():"";
	  						personalPresentHistoryMember+=phNcd.getOtherDiagnosis()!=null?" "+phNcd.getOtherDiagnosis():"";
	  						personalPresentHistoryMember+=phNcd.getDiagnosisType()!=null?" "+phNcd.getDiagnosisType():"";
	  					}
	  				}
	  			}
	  		}
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
		String empDeptCodeForGenMed  = properties.getProperty("empDeptCodeForGenMed");
		String empDeptCodeForAnt  = properties.getProperty("empDeptCodeForAnt");
		
		String deptCodeENT  = properties.getProperty("deptCodeENT");
		String deptCodeDermatology  = properties.getProperty("deptCodeDermatology");
		String deptCodeGeneralMedicine  = properties.getProperty("deptCodeGeneralMedicine");
		String deptCodeOrthopadics  = properties.getProperty("deptCodeOrthopadics");
		String deptCodeOphtomology = properties.getProperty("deptCodeOphtomology");
		String deptCodePsychiatry  = properties.getProperty("deptCodePsychiatry");
		String deptCodeNephrology  = properties.getProperty("deptCodeNephrology");
		String deptCodePaeditrics  = properties.getProperty("deptCodePaeditrics");

		//Added by Arbind on 15-03-2017
		int deptIdSession = 0;
		if(session.getAttribute("deptId")!=null){
			deptIdSession= (Integer) session.getAttribute("deptId");
		}
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		}
	/* 	List<OpdTemplate>templateList= new ArrayList<OpdTemplate>();
		if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
		} */
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
		
		
		//List<MasSpecialtyTemplate> specialtyTemplateList = new ArrayList<MasSpecialtyTemplate>();
		List<Object[]> specialtyTemplateList=new ArrayList<Object[]>();
		
		if(map.get("specialtyTemplateList")!=null){
			//specialtyTemplateList=(List<MasSpecialtyTemplate>)map.get("specialtyTemplateList");
			specialtyTemplateList=(List<Object[]>)map.get("specialtyTemplateList");
	    }
		
	     List<MasDiet> dietList = new ArrayList<MasDiet>();
	    if(map.get("dietDataList")!=null)
	    {
	    	dietList = (List)map.get("dietDataList");

	    }
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	    if(map.get("bloodGroupList")!=null){
	    	bloodGroupList = (List)map.get("bloodGroupList");
	    }
	    String bloodGroupValue = "";
	    if(map.get("bloodGroupValue")!=null){
	    	bloodGroupValue = (String)map.get("bloodGroupValue");
	    }
	    String bloodGroupStatus = "";
	    if(map.get("bloodGroupStatus")!=null){
	    	bloodGroupStatus = (String)map.get("bloodGroupStatus");
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
			patient = visit.getHin();
		}

		String patientName="";
		String uhid = ""; 
		String age="";
		int patientAge=0;
		String gender="";
		String yearMonth="";
		/* Added By Amit Das */
		String patientRsbyCardNo = "";
		
		if(patient.getRsbyCardNo()!= null && !patient.getRsbyCardNo().trim().equals(""))
			patientRsbyCardNo=patient.getRsbyCardNo();
		
		if(patient!= null)
			uhid=patient.getHinNo();	
		
		if(patient.getPFirstName()!= null)
		patientName=patient.getPFirstName();
		
		if(patient.getPMiddleName()!= null)
		patientName=patientName+" "+patient.getPMiddleName();
		
		if(patient.getPLastName()!= null)
		patientName=patientName+" "+patient.getPLastName();
		
		
		if(patient.getAge()!= null){
			age=!patient.getAge().equals("")?patient.getAge():"";
			if(age.length()>0){
			patientAge=Integer.parseInt(age.split(" ")[0]);
			}
			}
		if(patient.getDateOfBirth()!=null){
			Date dob=patient.getDateOfBirth();
		String ymd=HMSUtil.calculateYearMonthDay(dob);
		System.out.println("yearsmontday "+ymd);
		String d[]=ymd.split("&");
		/* Commented and Added by Arbind on 22-04-2017 */
		/* String year1=d[0];
		String months1=d[1];
		System.out.println("years "+year1+" month "+months1);
		yearMonth=year1+" Years "+months1+" Months"; */
		int year1=Integer.parseInt(d[0].toString());
		int months1=Integer.parseInt(d[1].toString());
		int days1=Integer.parseInt(d[2].toString());
		System.out.println("years "+year1+" month "+months1+" days "+days1);
		yearMonth = year1 != 0 ? d[0] + " Y " : "";
		yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
		yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
		}
		
		if(patient.getSex()!= null){
			gender=patient.getSex().getAdministrativeSexName();
		}
		String display="none";
		if(patient.getSex()!= null && patient.getSex().getAdministrativeSexCode().equals("F") && patient.getSex().getId()==2)
		{	display="block";}
		
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		int deptId=visit.getDepartment().getId();
		int visitId=visit.getId(); //Added by Arbind on 16-03-2017
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
		List<BabyDetails> babyDetailList = new ArrayList<BabyDetails>();
		List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
		if(map.get("babyDetailList") != null){
			babyDetailList = (List)map.get("babyDetailList");
		}
		if(map.get("deliveryDetailsList") != null){
			deliveryDetailsList = (List)map.get("deliveryDetailsList");
		}
		List<PhFpRegDetail>phFpRegDetailList = new ArrayList<PhFpRegDetail>();
		if(map.get("phFpRegDetailList") != null){
			phFpRegDetailList = (List)map.get("phFpRegDetailList");
		}
		PhFpRegDetail phRegDetail = new PhFpRegDetail();
		if(phFpRegDetailList.size()>0){
			phRegDetail = phFpRegDetailList.get(0);
		}
		DeliveryDetails deliveryDetails = new DeliveryDetails();
		if(deliveryDetailsList.size()>0){
			deliveryDetails = deliveryDetailsList.get(0);
		}
		BabyDetails babyDetails = new BabyDetails();
		if(babyDetailList.size()>0){
			babyDetails = babyDetailList.get(0);
		}
		
		PhAncSurvey phAncSurvey = null;
		if(phAncSurveyList.size()>0){
			phAncSurvey = phAncSurveyList.get(0);
			
		}
		int diffWeeks = 0;
		if(map.get("diffWeeks") != null){
			diffWeeks = Integer.parseInt(map.get("diffWeeks").toString());
		}
		
		//added by govind 17-11-2016 
		String expired="";
		Patient expPatient=visit.getHin();		
		expired=expPatient.getPatientStatus();
		
		System.out.println("expired "+expired);
		
		String orderNo="";
		if(map.get("orderNo")!=null)
	    {
			orderNo = (String)map.get("orderNo");
	    } 
		int OrderId=0;
		if(map.get("OrderId")!=null)
	    {
			OrderId = (Integer)map.get("OrderId");
	    }
		System.out.println("OrderId "+OrderId);
		//added by govind 17-11-2016  end
			List<Object[]>previousDetailList = new ArrayList<Object[]>();
			List<Object[]>previousPrescriptionList = new ArrayList<Object[]>();
			List<Object[]>previousInvestigationList = new ArrayList<Object[]>();
			List<Object[]>previousDiagnosisList = new ArrayList<Object[]>();
			List<Object[]>previousProcedureList = new ArrayList<Object[]>();
			String loggedInDeptName = null;	
			
			if(map.get("previousDetailList")!=null){
				previousDetailList = (List<Object[]>)map.get("previousDetailList");
		    } 
			if(map.get("previousPrescriptionList")!=null){
				previousPrescriptionList = (List<Object[]>)map.get("previousPrescriptionList");
		    } 
			if(map.get("previousInvestigationList")!=null){
				previousInvestigationList = (List<Object[]>)map.get("previousInvestigationList");
		    } 
			if(map.get("previousDiagnosisList")!=null){
				previousDiagnosisList = (List<Object[]>)map.get("previousDiagnosisList");
		    } 
			if(map.get("previousProcedureList")!=null){
				previousProcedureList = (List<Object[]>)map.get("previousProcedureList");
		    } 
			
			if(map.get("loggedInDeptName")!=null){
				loggedInDeptName = (String)map.get("loggedInDeptName");
			}
		
		%>

<%
		String preComplaindateWise = "";
		String history = "";
		String systemicExamination = "";
		String findings = "";
		int preHeight = 0;
		String preWeight = "";
		String prePulse = "";
		String preBP = "";
		String preInvestigation = "";
		String prePrecription = "";
		String preDiagnosis = "";
		String preProcedure = "";
		String preComplain = "";
		String procedureDone = "";
		String opdRemarks = "";
	if(previousDetailList.size()>0){
	for(Object[] patientHistory :previousDetailList){
		
		Date opdDate = (Date)patientHistory[0];
		if(patientHistory[1] != null && !patientHistory[1].equals("")){
			preComplain = (String)patientHistory[1];
		}
		if(!preComplain.equals("")){
		
		preComplaindateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
		preComplaindateWise += " --  "+ preComplain+"<div class='clear'></div>";
		}
		history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
		if(patientHistory[2] != null && !patientHistory[2].equals("")){
			history += "Personal History--"+(String)patientHistory[2]+"<div class='clear'></div>";
			personalPresentHistory += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+" --  ";
			personalPresentHistory += (String)patientHistory[2]+"<div class='clear'></div>";
		}
		if(patientHistory[3] != null && !patientHistory[3].equals("")){
			history += "Family History--"+(String)patientHistory[3]+"<div class='clear'></div>";
			familyPastHistory += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+" --  ";
			familyPastHistory += (String)patientHistory[3]+"<div class='clear'></div>";
		}
		if(patientHistory[4] != null && !patientHistory[4].equals("")){
			history += "Medication History--"+(String)patientHistory[4]+"<div class='clear'></div>";
			madicationHistory = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+" --  ";
			madicationHistory += (String)patientHistory[4]+"<div class='clear'></div>";
		}
		if(patientHistory[5] != null && !patientHistory[5].equals("")){
			history += "History of Past Illness--"+(String)patientHistory[5]+"<div class='clear'></div>";
		}
		if(patientHistory[6] != null && !patientHistory[6].equals("")){
			history += "History of Menstrual and Obstetric--"+(String)patientHistory[6]+"<div class='clear'></div>";
		}
		if(patientHistory[7] != null && !patientHistory[7].equals("")){
			systemicExamination += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
			systemicExamination+=(String)patientHistory[7]+"<div class='clear'></div>";
		}
		if(patientHistory[8] != null && !patientHistory[8].equals("")){
			findings += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			findings+="Local Examination--"+(String)patientHistory[8]+"<div class='clear'></div>";
		}
		if(patientHistory[9] != null && !patientHistory[9].equals("")){
			findings+="General Examination--"+(String)patientHistory[9]+"<div class='clear'></div>";
		}
		
		if(patientHistory[10] != null && ((Double)patientHistory[10])!=0){
			findings+="Vitals: Height-"+(Double)patientHistory[10];
		}
		if(patientHistory[11] != null && ((Double)patientHistory[11])!=0){
			findings+="weight-"+(Double)patientHistory[11];
		}
		if(patientHistory[12] != null && ((Integer)patientHistory[12])!=0){
			findings+="Pulse-"+(Integer)patientHistory[12];
		}
		if(patientHistory[13] != null && !patientHistory[13].equals("")){
			findings+="BP-"+(String)patientHistory[13];
		}
		if(patientHistory[14] != null && !patientHistory[14].equals("")){
			findings+="P/S-"+(String)patientHistory[14]+"<div class='clear'></div>";
		}
		if(patientHistory[15] != null && !patientHistory[15].equals("")){
			findings+="P/V-"+(String)patientHistory[15]+"<div class='clear'></div>";
		}
		if(patientHistory[16] != null && !patientHistory[16].equals("")){
			findings+="P/R-"+(String)patientHistory[16]+"<div class='clear'></div>";
		}
		if(patientHistory[17] != null && !patientHistory[17].equals("")){
			findings+="Smear Collection-"+(((String)patientHistory[17]).equalsIgnoreCase("y")?"Yes":"No")+"<div class='clear'></div>";
		}
		 
		if(patientHistory[18] != null && !patientHistory[18].equals("")){
			preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			preDiagnosis+="Other Diagnosis--"+(String)patientHistory[18]+"<div class='clear'></div>";
		}
		
		if(patientHistory[19] != null && !patientHistory[19].equals("")){
			opdRemarks += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			opdRemarks +=(String)patientHistory[19]+"<div class='clear'></div>";
		}
		if(patientHistory[21] != null && !patientHistory[21].equals("")){
			procedureDone += (String)patientHistory[21]+"<div class='clear'></div>";
		}
		if(patientHistory[22] != null && !patientHistory[22].equals("")){
			preProcedure += "Treatment --"+(String)patientHistory[22]+"<div class='clear'></div>";
		}
		
		if(patientHistory[23] != null && !patientHistory[23].equals("")){
			history += "History of Development--"+(String)patientHistory[23]+"<div class='clear'></div>";
		}
		
		if(patientHistory[24] != null && !patientHistory[24].equals("")){
			history += "History of Diet--"+(String)patientHistory[24]+"<div class='clear'></div>";
		}
		
		if(patientHistory[26] != null && !patientHistory[26].equals("")){
			comorbidityStr  = (String)patientHistory[26];
		}
	}}

if(previousInvestigationList.size()>0){
	for(Object[] inves :previousInvestigationList){
		Date visitDate = (Date)inves[0];
		preInvestigation += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
		if(inves[1] != null && !inves[1].equals("")){
			preInvestigation += (String)inves[1]+"<div class='clear'></div>";
		}
		
	}}

if(previousPrescriptionList.size()>0){
	for(Object[] pres :previousPrescriptionList){
		Date visitDate = (Date)pres[0];
		prePrecription += HMSUtil.convertDateToStringTypeDateOnly(visitDate)+"<div class='clear'></div>";
		if(pres[1] != null && !pres[1].equals("")){
			prePrecription += (String)pres[1];
		}
		if(pres[2] != null && !pres[2].equals("")){
			prePrecription += (String)pres[2];
		}
		if(pres[3] != null && !pres[3].equals("")){
			prePrecription += (Float)pres[3];
		}
		if(pres[4] != null && !pres[4].equals("")){
			prePrecription += (String)pres[4];
		}
		if(pres[5] != null && ((Integer)pres[5])!=0){
			prePrecription += (Integer)pres[5];
		}
		if(pres[6] != null && !pres[6].equals("")){
			prePrecription += (String)pres[6]+"<div class='clear'></div>";
		}
		
	}}

if(previousDiagnosisList.size()>0){
	for(Object[] diag :previousDiagnosisList){
		Date visitDate = (Date)diag[0];
		//preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
		if(diag[1] != null && !diag[1].equals("")){
			preDiagnosis += (String)diag[1]+"<div class='clear'></div>";
		}
		
	}}

if(previousProcedureList.size()>0){
	for(Object[] proc :previousProcedureList){
		Date visitDate = (Date)proc[0];
		preProcedure += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
		if(proc[1] != null && !proc[1].equals("")){
			preProcedure +="Procedure--"+ (String)proc[1]+"<div class='clear'></div>";
		}
		
	}}
%>

<div class="clear"></div>
<div class="Block">

<div class="titleBg">
<h2>PATIENT DETAILS</h2>
</div>
<div class="clear"></div> 
<div class="paddingTop5"></div>

<label class="medium">UHID</label>
<label class="valueAuto"><%=uhid%></label>
<label class="medium">Patient Name</label>
<label class="value"><%=patientName%></label>
<label class="medium">Age</label>
<label class="value"><%=patientAge %></label>
<div class="clear"></div> 
<label class="medium">Gender</label>
<label class="value" style="width:75px;"><%=gender%></label>
<label>Comorbidity</label>
<label class="valueAuto"> <%=comorbidityStr %> </label>

<div class="clear"></div> 
<div class="paddingTop5"></div> 
<div class="titleBg">
<h2>KNOW YOUR PATIENT</h2>
</div>

<div class="preDivLeft">

<label>Diagnosis of Last Visit</label>
<div class="summaryDetails" style="width: 351px;height: 66px;"><p><%=preDiagnosis %></p></div>
<!-- <textarea name="" id="" cols="0" rows="0" maxlength="300" >preDiagnosis</textarea> -->

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Family History</label>
<div class="summaryDetails" style="width: 351px;height: 66px;"><p><%=familyPastHistory %></p></div>
<%-- <textarea name="" id="" cols="0" rows="0" maxlength="300"><%=familyPastHistory %></textarea> --%>

<div class="clear"></div> 
<div class="paddingTop5"></div> 
<label>Medication History</label>
<div class="summaryDetails" style="width: 351px;height: 66px;"><p><%=madicationHistory %></p></div>
<%-- <textarea name="" id="" cols="0" rows="0" maxlength="300"><%=madicationHistory!=null?madicationHistory:"" %></textarea> --%>

<div class="clear"></div> 
<div class="paddingTop5"></div> 


</div>


<div class="preDivLeft">

<label>Past History</label><div class="clear"></div> 
<div class="summaryDetails" style="width: 351px;height: 66px;"><p><%=history %></p></div>
<%-- <textarea   name="" id="" cols="0" rows="0" maxlength="300" ><%=history %></textarea> --%>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Personal History</label>
<div class="summaryDetails" style="width: 351px;height: 66px;"><p><%=personalPresentHistory %></p></div>
<%-- <textarea name="" id="" cols="0" rows="0" maxlength="300"  ><%=personalPresentHistory %><%=personalPresentHistoryMember %></textarea> --%>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Allergies</label>
<textarea name="" id="" cols="0" rows="0" maxlength="300"  ><%=allergyStr %></textarea>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

</div>




<div class="clear"></div> 
<div class="paddingTop5"></div>  
<!-- 
<label>Diagnosis of Last Visit</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300" > </textarea>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Past History</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300"  > </textarea>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Family History</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300"  > </textarea>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Personal History</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300"> </textarea>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label>Medication History</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300" > </textarea>

<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Allergies</label>
<textarea class="large" name="" id="" cols="0" rows="0" maxlength="300" > </textarea>
 -->

<div class="clear"></div>
<div class="paddingTop5"></div>
<!-- <h4 style="width:150px; float:left;">Add Allergy Details</h4> 
<input class="buttonAuto-buttn" tabindex="3" name="" style="height:19px;" value="+" type="button">
 -->
<div class="clear"></div>
<div class="paddingTop5"></div>

<div style="width:140px; margin-left:344px; float:left;">
<input name="Submit11" id="Submit11" class="buttonAuto" value="Close" type="button" align="right" style="background:#c55a11; color:#fff;" onclick="self.close();" />
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
</div>

<style>
.preDivLeft{width:377px;float:left;height:auto;}
.preDivLeft label{width:auto; background:none;box-shadow:none;margin:0px; height:22px;}
.preDivLeft textarea {width:362px;height:80px;}




</style>


