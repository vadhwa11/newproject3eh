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
<!-- <script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script> -->
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
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>

<!-- by anamika -->
<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>


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
var callbck_index =function(ret_OUT){setValue(ret_OUT);};
var semantictag_IN;
var acceptability_IN;
var state_IN ;
var returnlimit_IN;
var retterm_value ={};
function setValue(selectedSNOMEDTerm)
{		
	document.getElementById("snomedTermConceptId").value=selectedSNOMEDTerm;
	document.getElementById("snomedTermConceptIdEXM").value=selectedSNOMEDTerm;
}
function isNumeric(e)
{
e.value = (e.value.replace(/[^0-9]/g, ''));
}


function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : "";
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
	serverdate = '<%=getDate+"/"+month+"/"+year%>';
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
		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 06-09-2016 
		List<PhProbablePregnancy> phProbablePregnancyList = new ArrayList<PhProbablePregnancy>(); // added by amit das 13-09-2016
		
		
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
	  //added by govind 17-9-2016 end 
	  
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
			referredDept = opdPatientDetails.getReferedDepartment()!=null?opdPatientDetails.getReferedDepartment().getId():0; //Added by Arbind on 15-03-2017
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
		
		List<Visit> patientDataList = new ArrayList<Visit>();
	  	Integer pulse=0;
	  	Float temperature=0f;
	  	String bpSystolicDiastolic="";
	  	Float bmi=0f;
	  	Float respirtoryRate=0f;
	  	Float spo2=0f;
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
		}else if(map.get("majorHealthIssue") != null)
		{
			presentComplaintHistory=(String)map.get("majorHealthIssue");
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
		String yearMonth="";
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
		if(visit.getHin().getDateOfBirth()!=null){
			Date dob=visit.getHin().getDateOfBirth();
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
		if(visit.getHin().getSex()!= null){
			gender=visit.getHin().getSex().getAdministrativeSexName();
		}
		String display="none";
		if(visit.getHin().getSex()!= null && visit.getHin().getSex().getAdministrativeSexCode().equals("F") && visit.getHin().getSex().getId()==2)
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
		//added by govind 17-11-2016  end
			List<Object[]>previousDetailList = new ArrayList<Object[]>();
			List<Object[]>previousPrescriptionList = new ArrayList<Object[]>();
			List<Object[]>previousInvestigationList = new ArrayList<Object[]>();
			List<Object[]>previousDiagnosisList = new ArrayList<Object[]>();
			List<Object[]>previousProcedureList = new ArrayList<Object[]>();
				
			
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
			
		
		%>
<!--main content placeholder starts here-->
<body onclick="parent_disable();setDisablePharmacy();">
	<form name="opdMain" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="userName" value="<%=userName %>" />
		<%if(visit.getDepartment()!= null){ %>
		<div class="titleBg">
			<h2><%=visit.getDepartment().getDepartmentName() %></h2>
		</div>		
		<%} %>
		<script type="text/javascript">
		   var icdArray=new Array();
		   var icdArray1=new Array();
		   var brandArray=new Array();
		   var allergyTypeArray=new Array();
		   var saverityCodeArray=new Array();
</script>
		<div class="Block" style="padding-bottom:0px;">

			<label>Patient Name</label><input type="text"
				value="<%=patientName%>" readonly="readonly" /> <label>Age</label><input
				type="text" value="<%=yearMonth%>"
				readonly="readonly" /> <label>Gender</label><input type="text"
				class="dateTextSmall" value="<%=gender%>" readonly="readonly" />
			<div class="clear"></div>
			<label>Allergy</label>
			<textarea class="textareaMediua" readonly="readonly" cols="0" rows="0" maxlength="300" style="font-weight: bold;color:red;margin:0 5px 5px 0"><%=allergyStr %></textarea>
			<label>Comorbidity</label>
			<textarea name="comorbidity" class="comorBiditylarge"
				id="comorbidity" validate="comorbidity,string,no"
				readonly="readonly" cols="0" rows="0" maxlength="300"
				onkeyup="return checkLength(this)"><%=comorbidityStr %></textarea>
			<input type="button" class="buttonBig" id="patient_details"
				name="patient_details" value="Patient Details"
				onclick="patientDetails(csrfTokenName+'='+csrfTokenValue);" />
			<%if(!pragnancyStatus.equals("")){ %>	
				<input type="button" class="buttonBig" id="ancSummary"
				name="ancSummary" value="ANC Summary"
				onclick="ancSummaryDetail(csrfTokenName+'='+csrfTokenValue);" />
				<%} %>

			<div class="clear"></div>
			<label>Major Health Issue</label>
			<textarea cols="0" rows="0" maxlength="300" readonly="readonly" class="textareaMediua"><%=majorHealthIssue%></textarea>
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
					<textarea name="phiso_remarks" id="phiso_remarks" class="textareaMediua"
						validate="remarks,string,no" cols="0" rows="0" maxlength="300"
						onkeyup="return checkLength(this)"></textarea>
						
						<%}else if(phAncSurvey != null){ %>
					
						<label class="autoSpace">
						<input type="checkbox" name="preganancy" checked="checked" id="preganancy" class="radioCheckCol2">Pregnancy</label>
						<label>LMP Date</label>
						<input type="text" name="lmpDate" readonly="readonly"  value="<%=phAncSurvey != null && phAncSurvey.getLmpDate() != null ?HMSUtil.convertDateToStringWithoutTime(phAncSurvey.getLmpDate()):""%>"/>
						<label>EDC Date</label>
						<input type="text" name="edcDate" readonly="readonly"  value="<%=phAncSurvey != null && phAncSurvey.getEdcDate() != null ?HMSUtil.convertDateToStringWithoutTime(phAncSurvey.getEdcDate()):""%>"/>
						
						<label>Para</label>
						<input type="text" name="para" readonly="readonly" value="<%=phAncSurvey != null && phAncSurvey.getParity() != null && phAncSurvey.getParity() != 0?phAncSurvey.getParity():""%>"/>
						
						<label>Gravida</label>
						<input type="text" name="gravida" readonly="readonly" value="<%=phAncSurvey != null && phAncSurvey.getGravida() != null ? phAncSurvey.getGravida():""%>"/>
												
						<label class="auto">Period</label> <input type="text"
							class="dateTextSmall" placeholder="Period in week"
							value="<%=diffWeeks != 0?diffWeeks:"" %>" id="period"
							name="period"><label class="smallAuto autoSpace">in
							week</label> 
							
							<div class="clear"></div>
							<label class="autoSpace"><input type="checkbox"
							name="lactation" id="lactation" class="radioCheckCol2">lactation</label>
						<label class="auto">Remarks</label>
						<textarea name="phiso_remarks" id="phiso_remarks" class="textareaMediua-"
							validate="remarks,string,no" cols="0" rows="0" maxlength="300"
							onkeyup="return checkLength(this)"></textarea>
							
					<%}else{ %>
					<%if(patientAge>12){ %>
					<div style="display: <%=display%>">
						<%if(!pragnancyStatus.equals("")){ %>
						<label class="autoSpace"><input type="checkbox" 
							name="preganancy" checked="checked" id="preganancy"
							class="radioCheckCol2" onclick="getPeriodRead()">Pregnancy </label>
						<%}else{ %>
						<label class="autoSpace"><input type="checkbox" <%=opdPatientDetails!=null && opdPatientDetails.getPregnancy()!=null && opdPatientDetails.getPregnancy().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)?"checked='checked'":"" %>
							name="preganancy" id="preganancy" class="radioCheckCol2" onclick="getPeriodRead()">Pregnancy
						</label>
						<%} %>
						<label class="auto">Period</label> <input type="text"
							class="dateTextSmall" placeholder="Period in week"
							value="<%=pragnancyPeriod!=0?pragnancyPeriod:"" %>" id="period1"
							name="period" readonly maxlength="2"><label class="smallAuto autoSpace">in
							week</label> <label class="autoSpace">
							<input type="checkbox" <%=opdPatientDetails!=null && opdPatientDetails.getLactation()!=null && opdPatientDetails.getLactation().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)?"checked='checked'":"" %>
							name="lactation" id="lactation" class="radioCheckCol2">lactation</label>
						<label class="auto">Remarks</label>
						<textarea name="phiso_remarks" id="phiso_remarks" class="textareaMediua-"
							validate="remarks,string,no" cols="0" rows="0" maxlength="300"
							onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getPhysiologicalStatusRemarks()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getPhysiologicalStatusRemarks():"" %></textarea>
					</div>
					<%}} %>
				</div>	
				<div class="clear"></div>
					<label>Patient Last Encounter </label>
					<textarea class="large" name="lastEncounter" id="lastEncounter" style="width:356px;"
						validate="Patient Last Encounter Details,string,no" cols="0"
						tabindex="1" rows="0" maxlength="300"
						onkeyup="return checkLength(this)" readonly="readonly"> <%=lastEncounterDetail!=null?lastEncounterDetail:"" %> </textarea>		
			<%
  int docId=0;
  if(session!=null){
	  docId= (Integer)session.getAttribute("empId");
  }
  
  /* if(visit.getDoctor()!=null){
	  docId=visit.getDoctor().getId();
	  /* docName = (String)visit.getDoctor().getFirstName();
	   if(visit.getDoctor().getMiddleName()!=null)
	  {
		  docName =docName+" "+visit.getDoctor().getMiddleName();
	  }
	  if(visit.getDoctor().getLastName()!=null)
	  {
		  docName =docName+" "+visit.getDoctor().getLastName();
	  } 
  }*/
  %>
</div>
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
		<!--tab content starts-->

		<!-- comment By rajendra :17-03-2015 -->

		<ul id="countrytabsIn" class="shadetabsInForOPDMain">
			<label><a href="#" rel="country1" class="selected"	onclick="checkTab(1);">Clinical Summary</a></label>
			<label><a href="#" rel="country2" 	onclick="checkTab(2);">OP Consultation</a></label>
			<label><a href="#" rel="country3" 	onclick="checkTab(3);">History</a></label>
			<label onclick="drawParkDiagnosisTable();"><a href="#"	rel="country4" onclick="checkTab(4);">Examination</a></label>
			<label><a href="#" rel="country5" onclick="checkTab(5);">Investigation/Other Services</a></label>
			<label><a href="#" rel="country6" onclick="checkTab(6);">Allergy</a></label>
			<label><a href="#" rel="country7" onclick="checkTab(7);">Treatment</a></label>
			<label><a href="#" rel="country8" onclick="checkTab(8);">Prescription</a></label>
			<label><a href="#" rel="country9" onclick="checkTab(9);">Comorbidity</a></label>
			<label><a href="#" rel="country10" onclick="checkTab(10);">Speciality</a></label>			
			<%
		if(opdPatientDetails!= null  && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){%>
			<label id="mlcTab"><a href="#" rel="country11"	onclick="checkTab(11);">MLC</a></label>
		<%}else if(patientWiseMlcs.size()>0){ %>
			<label id="mlcTab"><a href="#" rel="country11" onclick="checkTab(11);">MLC</a></label>
		<%} else{%>
			<label id="mlcTab" style="display: none"><a href="#" rel="country11" onclick="checkTab(11);">MLC</a></label>
		<%} %>		
		<%
if(babyDetailList != null && babyDetailList.size()>0 &&  gender.equalsIgnoreCase("Female")){
 %>	
			<label><a href="#" rel="country12" onclick="checkTab(12);">Delivery Details</a></label>
			<label><a href="#" rel="country13" onclick="checkTab(13);">PNC</a></label>
			<%} %>		
		</ul>

<input type="hidden" name="tab" id="tab" value="" />
<div class="tabcontainerIn">
<!-- -------------------------------Start code for Clinical Summary--------------------------------------- -->
<div id="country1" class="tabcontentIn">
<div class="Block">
<h6>Clinical Summary</h6>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>From Date</label>
<input type="text"	name="fromDateId" id="fromDateId" value="" readonly="readonly" class="dateTextSmall" />
 <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.fromDateId,event);" />

<label>To Date</label>
<input type="text" id="toDateId" name="toDateId" class="dateTextSmall" value="" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate %>',document.opdMain.toDateId,event);" />
	
<input type="button" name="search" value="Search" class="button" onClick="submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getClinicalSummaryHistoryData','clinicalSummaryDiv');" />	
<div id="clinicalSummaryDiv">
<div class="summaryDivMain">
<label>Previous Complaints</label>
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
if(previousDetailList.size()>0){
	for(Object[] patientHistory :previousDetailList){
		Date opdDate = (Date)patientHistory[0];
		String preComplain = (String)patientHistory[1];
		if(!preComplain.equals("")){
		
		preComplaindateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
		preComplaindateWise += " --  "+ preComplain+"<div class='clear'></div>";
		}
		history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
		if(patientHistory[2] != null && !patientHistory[2].equals("")){
			history += "Personal History--"+(String)patientHistory[2]+"<div class='clear'></div>";
		}
		if(patientHistory[3] != null && !patientHistory[3].equals("")){
			history += "Family History--"+(String)patientHistory[3]+"<div class='clear'></div>";
		}
		if(patientHistory[4] != null && !patientHistory[4].equals("")){
			history += "Medication History--"+(String)patientHistory[4]+"<div class='clear'></div>";
		}
		if(patientHistory[5] != null && !patientHistory[5].equals("")){
			history += "History of Past Illness--"+(String)patientHistory[5]+"<div class='clear'></div>";
		}
		
		if(patientHistory[6] != null && !patientHistory[6].equals("")){
			systemicExamination += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
			systemicExamination+=(String)patientHistory[6]+"<div class='clear'></div>";
		}
		if(patientHistory[7] != null && !patientHistory[7].equals("")){
			findings += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			findings+="Local Examination--"+(String)patientHistory[7]+"<div class='clear'></div>";
		}
		if(patientHistory[8] != null && !patientHistory[8].equals("")){
			findings+="General Examination--"+(String)patientHistory[8]+"<div class='clear'></div>";
		}
		
		if(patientHistory[9] != null && ((Integer)patientHistory[9])!=0){
			findings+="Vitals: Height-"+(Integer)patientHistory[9];
		}
		if(patientHistory[10] != null && ((Integer)patientHistory[10])!=0){
			findings+="weight-"+(Integer)patientHistory[10];
		}
		if(patientHistory[11] != null && ((Integer)patientHistory[11])!=0){
			findings+="Pulse-"+(Integer)patientHistory[11];
		}
		if(patientHistory[12] != null && !patientHistory[12].equals("")){
			findings+="BP-"+(String)patientHistory[12];
		}
		if(patientHistory[12] != null && !patientHistory[12].equals("")){
			findings+="BP-"+(String)patientHistory[12];
		}
		if(patientHistory[13] != null && !patientHistory[13].equals("")){
			preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			preDiagnosis+="Other Diagnosis--"+(String)patientHistory[13]+"<div class='clear'></div>";
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
			prePrecription += (String)pres[6];
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
<div class="summaryDetails"><p><%=preComplaindateWise %></p></div>

</div>

<div class="summaryDivMain">
<label>History</label>
<div class="summaryDetails"><p><%=history %></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Systemic Examination</label>
<div class="summaryDetails"><p><%=systemicExamination %></p></div>
</div>

<div class="summaryDivMain">
<label>Findings</label>
<div class="summaryDetails"><p><%=findings%></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Investigations</label>
<div class="summaryDetails"><p><%=preInvestigation %></p></div>
</div>

<div class="summaryDivMain">
<label>Prescription</label>
<div class="summaryDetails"><p><%=prePrecription %></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Diagnosis</label>
<div class="summaryDetails"><p><%=preDiagnosis %></p></div>
</div>

<div class="summaryDivMain">
<label>Treatment</label>
<div class="summaryDetails"><p><%=preProcedure %></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Previous Ip Details</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="clear"></div>
</div>
</div>
</div>

<!-- --------------------------------End Code for Clinical Summary---------------------------------------------------------- -->
<div id="country2" class="tabcontentIn">
<div class="Block">

<div class="floatRight" style="margin-right:15px;">
<%if(opdPatientDetails!= null && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){ %>
<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
<%}else if(patientWiseMlcs.size()>0){ %>
<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
<%}else{  %>
<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()"/>MLC</label>
<%} %>
</div>
<label style="vertical-align: baseline;"><img src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Data is part of EHR</span></label>
<div class="clear"></div>
			<!-- <div id="country12" class="tabcontentIn">
				<div class="Block"> -->
				
				<!-- added by amit das on 15-09-2016 -->
					<h4>Patient Episode Details</h4>
					<div class="clear"></div>
					<input type="radio" name="episodeCheck" id="episodeIdPast" onclick="showPastEpisodeDiv();" class="episodeSelect" title="Select Past Episode">
					<!-- <div class="episodelabel">Select Past Episode</div> -->
					<label style="width:130px;">Select Past Episode</label>
					<input type="radio" name="episodeCheck" id="episodeIdNew" checked="checked" class="episodeSelect"  onclick="hidePastEpisodeDiv();">
					<!-- <div class="episodelabel">Create New Episode</div> -->
					<label>Create New Episode</label>					
					<div class="" style="display: none;" id="pastEpisodeDiv"> 
					<label>Past Episodes</label>
					 <select name="episodeList"	id="episodeList" size="1" onclick="getEpisodeDetail(this,'outpatient');">
					 	<option value="0">Select</option>
					 	<% for(PatientEpisode patientEpisode : patientEpisodeList) { %>
					 		<option value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)<%=patientEpisode.getEpisodeName()%></option>
					 	<% } %>
					 </select>
					 </div>					 
					 <div class="" id="EpisodeNameDiv">
						 <label>Episode Name</label>
					 	<input name="episodeName" id="episodeName" type="text" value="">
					 </div>	
					 	
					 <div class="clear"></div>
					  <div id="patientEpisodeDetail">
					 </div>
					<div class="clear"></div>
					<input type="hidden" id="episodeId" name="episodeId" value="0"> 
					<input type="checkbox" id="episodeCloseCheck" name="episodeCloseCheck" class="episodeSelect" value="true" >
					<label style="width:130px;">Close Episode</label>
					<!-- <div class="episodelabel">Close Episode</div> -->
					<!-- ended by amit das on 15-09-2016 -->					
			<!-- </div>
			</div> -->			
					
					<div class="clear"></div>					
					<!-- added by amit das on 14-09-2016 -->
					<% if(phProbablePregnancyList.size()>0) {%>
					<input type="checkbox" class="episodeSelect"  checked="checked" disabled="disabled"><div class="episodelabel">Probable Pregnant</div>
					<%}  %>
					<input type="hidden"  name="vaccinPvms" id="vaccinPvms">					
					<%if(opdPatientDetails!=null && opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId().equals(deptId))
					{
					%>
					<input type="hidden" name="referralCase" value="yes"/>
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
						class="smallAuto autoSpace">&deg;F</label> 
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
						class="smallAuto autoSpace">mm&nbsp;Hg</label>
						<div class="clear"></div>
						<label class="auto">Height</label>
						<input	name="height" id="height" type="text"  maxlength="3" class="allownumericwithoutdecimal textSmall"  value="<%=height>0?height:"" %>" validate="height,int,no" onblur="calculateBMI();" tabindex="15"/>
						<label	class="smallAuto">cm</label>
						
						<label class="auto">Weight</label>
						<input name="weight"  id="weight" type="text" maxlength="3"  class="allownumericwithoutdecimal textSmall"  value="<%=weight>0?weight:"" %>" validate="weight,int,no" onblur="calculateBMI();" tabindex="14"/>
						<label	class="smallAuto">Kg</label>

						<label class="auto" id="bpLabel">BMI</label>
						<input	name="bmi" id="bmi"  type="text" value="<%=bmi>0f?bmi:"" %>"  readonly="readonly" class="textSmall" />
						<label class="auto" id="bmiCat"><%=bmiStatus %></label>
						<%-- <input type="button"
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
						value="Vital Trends" tabindex="16" />  --%>
						
	<label>Respiratory Rate</label>
	<input class="textYellow allownumericwithdecimal textSmall" name="respiratoryRate" id="respiratoryRate" type="text" maxlength="3" validate="Respiratory Rate,float,no" value="<%=respirtoryRate>0?respirtoryRate:"" %>" tabindex="12" />
	<!--  <label class="smallAuto autoSpace">&deg;F</label>  -->
						
						 <label class="auto">Spo2</label>
	<input class="textYellow allownumericwithdecimal textSmall" name="spo2" id="spo2" type="text" maxlength="3" validate="spo2,float,no" value="<%=spo2>0?spo2:"" %>" tabindex="12" />
	<!--  <label class="smallAuto autoSpace">&deg;F</label>  -->
	<input type="button" class="buttonAuto" id="vitalTrends" value="Vital Trends" tabindex="16" />
					<div class="clear"></div>
					<div class="divisionSolid"></div>
					<label>General Examination</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="generalExaminationOPC" id="generalExaminationOPC"
						validate="General Examination,string,no" cols="0" rows="0"
						maxlength="300" tabindex="17"><%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getGeneralExamination():"" %></textarea>
					<input type="button" class="buttonAuto-buttn" value="+"	onclick="getGeneralExaminationTemplate(csrfTokenName+'='+csrfTokenValue);" tabindex="18"
						style="margin-top: 2px; margin-right: 5px;" />
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
						<%if(opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)) {
						%>
						<textarea class="medium" cols="0" id="systemicExamination"	name="systemicExamination"	validate="systemicExamination,string,no" rows="0" maxlength="300"><%=opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null?opdPatientDetails.getSystemicExamination():"" %></textarea>
						<%}else{ %>
						<textarea class="medium" cols="0" rows="0" id="systemicExamination"	name="systemicExamination"	validate="systemicExamination,string,no"  maxlength="300">System NAD</textarea>
						<%} %>
						<label class="auto">Other</label> <input type="button"
							class="buttonAuto-buttn" value="+"
							onclick="getSystemicExaminationTemplate(csrfTokenName+'='+csrfTokenValue);" tabindex="24" />
					</div>
					<div class="clear"></div>
					<label>Local Examination</label>
					<textarea class="medium" validate="Family History,string,no"
						id="localExamination" name="localExamination" cols="0" rows="0"
						maxlength="300" tabindex="25" ><%=opdPatientDetails!=null && opdPatientDetails.getLocalExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getLocalExamination().trim():"" %></textarea>
					
					<label class="auto">Other Diagnosis</label>
					<textarea class="medium" validate="Other Diagnosis,string,no"
						id="OtherDiagnosis" name="OtherDiagnosis" cols="0" rows="0"
						maxlength="100" tabindex="25" ><%=opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getInitialDiagnosis().trim():"" %></textarea>	
					<div class="clear"></div>					
					
					<!-- <input type="text" tabindex="25" class="textYellow"
						tabindex="23" id="txt-snomed-ct-search" name="txt-snomed-ct-search"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','PREFERRED',returnlimit_IN,callbck_index);" />
						 -->					
					<input type="hidden" tabindex="25" class="textYellow" tabindex="23"	id="snomedNames" name="snomedNames" />
					<input type="hidden" tabindex="25" class="textYellow" tabindex="23"	id="icd1" name="icd1" />
<!-- 					<label><span>*</span>Diagnosis </label> -->
						<label>Diagnosis </label>
						<input type="text" tabindex="25" class="textYellow"
						tabindex="23" id="snomed" name="snomed"
						onblur="getICDListBasedOnSnomedId();"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');" />
						<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"		title="Remove Snomed Diagnosis" id="removeSnomed" />
						<input type="hidden" name="snomedTermConceptId" id="snomedTermConceptId" />
						<label class="auto">Diagnosis to be printed on Prescription</label>
						<input type="checkbox" name="diagnosisCheck" id="diagnosisCheck" value="y" checked="checked" />
						<div class="clear"></div>
						<label>Selected Diagnosis</label>
							<%-- <%
							String[] snomedStr=null;
							if(opdPatientDetails!=null && opdPatientDetails.getSnomedNames()!=null){
								String snomedList=opdPatientDetails.getSnomedNames();
									if(snomedList!=null && snomedList.length()>0){
										snomedStr=snomedList.split(",");
									}	
							}
							
							%> --%>
						<select name="snomedList" multiple="4" id="snomedList" class="listBig" validate="snomedList,string,no">
							<%-- <%if(snomedStr!=null){
								for(String term:snomedStr){%>
									<option value="<%=term%>"><%=term%></option>
							<%} }%> --%>
						</select>
						<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"	title="Remove Snomed" id="removesnomedList" />
						
						<!-- <input type="text" tabindex="25" class="textYellow"
						tabindex="23" id="snomed" name="snomed"
						onblur="getICDListBasedOnSnomedId(this.value);"
						/> fillDiagnosisCombo(this.value); -->
						
					
					 <!-- <div id="ac2update" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"	charset="utf-8">
		  				new Ajax.Autocompleter('snomed','ac2update','opd?method=getSnomedListForAutoCompleteItem',{parameters:'requiredField=snomed'});
					</script>  -->
					<div id="divIcdName" style="display: none;">
						<label> Select ICD Name </label>
						 <select id="icdName"	name="icdName" onchange="fillICDValue(this.value,'op');"></select>
					</div>
					<div class="clear"></div>
					<label>ICD code</label>
					<!-- <input name="icdCode" tabindex="26" class="textYellow" value="" id="icdCode" onblur="getIcd(1);" /> -->
					<input name="icdCode" tabindex="26" class="textYellow" value=""
						id="icdCode" readonly /> <input name="temp" value="" id="temp"
						type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="24"
						HEIGHT="20" tabindex="27" class="search-img" 
						onClick="javascript:openPopupDiagnosisWindow();"
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
							class="listBig" validate="diagnosisId,string,no">
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
							<select	name="diagnosisIdNP" multiple="4" id="diagnosisIdNP" class="listBig">
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
							id="presTempType_local" onchange="getTemplate('local','p','');"  />
							Local
						</label> <label class="autoSpace"
							style="padding: 0px 6px 0px 1px; margin: 0px 2px 0px 0px;"">
							<input type="radio" class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_global" onchange="getTemplate('global','p','');" />
							Global
						</label> <!-- <select class="midium" tabindex="30" name="tempLatePrescription"
							id="tempLatePrescription" onblur="setDisablePharmacy();"
							onchange="fnGetPrescriptionTemplate(this.value);">
							<option value="0">Select</option>
						</select> -->
						</div>
						<div class="paddLeft30">
									<select class="medium" multiple="5" style="height:50px;"
										name="tempLatePrescription" id="tempLatePrescription"
										onchange="fnGetPrescriptionTemplate(this);setDisablePharmacy();" onblur="setDisablePharmacy();" onclick="setDisablePharmacy();">
										<option value="-1">Select</option>
										<%
										System.out.println("templateListForInvestigation==in jsp===="+templateListForInvestigation.size());
										for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("P")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateTreatments().size()>0){ %>
										<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
										<%}%>
										<% } %>
									</select>
									<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int pIndexTab=0;
				 for(OpdTemplate opd:templateListForInvestigation){ %>
					<%if(opd.getTemplateType().equalsIgnoreCase("P")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateTreatments().size()>0){ %>
					tempArrayTemp[<%=pIndexTab%>]= new Array();
					tempArrayTemp[<%=pIndexTab%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=pIndexTab%>][1] = "<%=opd.getTemplateName() %>";
					<%pIndexTab++;%>
					<%}%>
				<%}%>
				</script>
</div>
						
						 <!-- onfocus="checkEnteredDiagnosis();" //Removed by Arbind on 31-01-2017 -->
					
					<input type="button" class="buttonBig" name="prev"
						value="Save / Edit Template"
						onclick="openPopupForSavePrescriptiontamplate();" /> <input
						name="Prevoius2" type="button" class="buttonBig"
						value="Last Prescription"
						onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue)" />
					<div class="clear"></div>
					<div class="addDeleteButton">
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
						<div class="tableForTab" style="width:890px; height:152px; overflow: scroll;">
							<!-- <div id="divTemplet1"> -->
								<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage<span>*</span></th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<!-- <th scope="col">Days<span>*</span></th> -->
										<th scope="col">Duration<span>*</span></th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
										<th scope="col"></th>
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
		String frequecnyType="";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		String issuedStatus="";
		String routeName="";
		String pAvailableStatus="";
		String conversion="";
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
			unit=pd.getItem().getDispUnit()!=null?pd.getItem().getDispUnit():pd.getItem().getItemConversion().getItemUnitName();
			conversion=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			ndays=pd.getNoOfDays();
			frequecnyType=pd.getFrequency().getFrequencyType();
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
											onchange="checkPrescriptionCheck(<%=incr %>)" />
											<%}else{%> <input
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
											<%-- onfocus="checkEnteredDiagnosis(); //Commented by Arbind on 31-01-2017--%>
											checkFrequency('<%=incr%>','opc');"
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
										
										
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixable<%=incr%>"
											id="mixable<%=incr%>" 
											validate="mixable,string,no" />
											
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixtureQuantity<%=incr%>"
											id="mixtureQuantity<%=incr%>" 
											validate="mixtureQuantity,int,no" />
											
										<input type="hidden"
											name="mixtureUnit<%=incr%>"
											id="mixtureUnit<%=incr%>" 	
											validate="mixtureUnit,string,no" />
<!-- 											validate="mixtureUnit,int,no" /> added by govind 05-01-2017-->
										<input type="hidden"
											name="actualTotalAfterMix<%=incr%>"
											id="actualTotalAfterMix<%=incr%>" 
											validate="actualTotalAfterMix,float,no" />
										<input type="hidden"
											name="tapered<%=incr%>"
											id="tapered<%=incr%>" 
											validate="tapered,string,no" />
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
												<%-- <%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ if(name.equalsIgnoreCase("oral")){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%} else{%>
												<option  value="<%=id %>"><%=name%></option>
													<%} %>
												
												<%}%> --%>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ 
												%>
												<option  value="<%=id %>"><%=name%></option>
												
												<%}%>
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
											maxlength="45" onblur="fillValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" /></td>
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
											validate="Sos Qty,num,no" /> 
									<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="frequency<%=incr%>" id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
												<option value="0">Select</option>
												<%
												  for(MasFrequency masFrequency2 : frequencyList){
											       int id = masFrequency2.getId();
											       String name = masFrequency2.getFrequencyName();
											       String type = masFrequency2.getFrequencyType();
									          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRow%><%=inxCol+6%>" name="frequency<%=incr%>"
											id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
												<option value="0">Select</option>
												<%
													 
												      for(MasFrequency masFrequency2 : frequencyList){
												       int id = masFrequency2.getId();
												       String name = masFrequency2.getFrequencyName();
												       String type = masFrequency2.getFrequencyType();
										          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <% }%> 
										
										<%	MasFrequency  masFrequency3 = null;
										        for (int i = 0; i < frequencyList.size(); i++) {
										      	 masFrequency3 = (MasFrequency) frequencyList.get(i);
							     		 %> <script>
								          icdArray[<%=i%>]= new Array();
								          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
								          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
								          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
							            </script> <% }%>
	          					  </td>
										<td>
											<div style="width:100px; float: left;">
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDays<%=incr%>" id="noOfDays<%=incr%>"
											value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<%}else{ %> <input type="text"
											tabindex="<%=inxRow%><%=inxCol+7%>" name="noOfDays<%=incr%>"
											id="noOfDays<%=incr%>" value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<% }%>
                                         </div>
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
										<td>
											<input type="text" name="total<%=incr %>" id="total<%=incr %>"	value="<%=total!=null && total!=0?total:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td>
										
										<td>
											<input type="text" id="unitLable<%=incr%>" value="<%=!conversion.equals("")?conversion:"" %>" 	class="textYellow opdTextBoxTSmall" readonly="readonly" />
										</td>
										
									</tr>
									<%} %>
					
<tbody id="divTemplet1"></tbody>	
								</table>
								<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
								<input type="hidden" name="hdbRecordSize"
									value="<%= patientPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize" /> <input type="hidden" name="hdbTabIndex"
									id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" />
								
							</div>
						<!-- </div> -->
					</div>

					<div class="clear"></div>
					<!-- <div  class="paddLeft55">
<input  type="button" class="buttonBig" name="prev" value="Save As Template" />
</div> -->
<div class="floatLeft" style=" margin: 5px 0px;">
<label class="auto"><img src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />
<span>Stock not available for medicine</span></label>
</div>
<!--<div  class="floatRight">
 <label class="auto">Page</label>
<select class="midium"><option>Select</option></select>
</div> -->
					<div class="clear"></div>
					<label>Remarks</label>
					<textarea class="opdMainTextArea"	id="opdRemarks" name="opdRemarks" cols="0" rows="0" maxlength="250"	onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getOpdRemarks()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getOpdRemarks():"" %></textarea>
					<label class="auto">Review Date</label>
					<%-- <input type="text" id="reviewDate" name="reviewDate" class="dateTextSmall" value="<%=currentDate%>" readonly="readonly"> --%>
					<input id="PatientUhid" type="hidden" name="UHID" value="<%=visit.getHin().getHinNo()%>" >
					<input id="deptId" name="deptId" type="hidden" value="<%=deptId%>" />
					<input id="doctorId" name="doctorId" type="hidden" value="<%=request.getParameter(CONSULTING_DOCTOR) %>" >
					<input type="text" id="reviewDate" name="reviewDate" value="<%=opdPatientDetails!=null && opdPatientDetails.getReviewDate()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?HMSUtil.convertDateOneFormatToAnother("dd/MM/yyyy",opdPatientDetails.getReviewDate()):""%>"
						class="dateTextSmall"  readonly="readonly"> <img
						src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
						validate="Pick a date" 
						onclick="setdate('<%=currentDate%>',document.opdMain.reviewDate,event);" />
					<label class="auto">Personal Review<input type="checkbox"
						class="radioCheckCol2" /></label>
					<div class="clear"></div>
					<label>Summary Consultation</label>
					<textarea class="opdMainTextArea"
						  validate="Summary Consulatation,string,no" 	id="summaryConsultation" name="summaryConsultation" cols="0"
						rows="0" maxlength="490" onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getSummaryConsultation() != null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getSummaryConsultation():""%></textarea>
					<%if(null !=secondOpinoinComment && !secondOpinoinComment.equals("")){ %>
					<label>Second Opinion Remarks</label>
					<textarea class="opdMainTextArea"
						validate="Summary Consulatation,string,no"
						id="secondOpinoinComment" readonly="readonly" value=""
						name="secondOpinoinComment" cols="0" rows="0" maxlength="490"
						onkeyup="return checkLength(this)"><%=secondOpinoinComment %></textarea>
					<%} %>
					<div class="clear"></div>					
					<div id="admissionDiv">
						<div class="clear"></div>
						<label class="autoSpace">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label>
						 <label class="autoSpace">Admission Advised
						  <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="radioCheckCol2"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="checkbox" class="radioCheckCol2" id="admissionAdvised"	name="admissionAdvised" />
							<%} %>
						</label>
						
						 <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<div id="admDiv">
							<label class="auto">Admission Date</label>
							 <input type="text"	name="admissionDate" id="admissionDate"	style="text-align: left;" class="dateTextSmall"	value="<%=HMSUtil.convertDateOneFormatToAnother("dd/MM/yyyy",opdPatientDetails.getAdmissionDate())%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<div class="clear"></div>
							<label class="autoSpace">Payward
							<input type="checkbox" name="payward" id="payward" class="radioCheckCol2" value="Y" onchange="checkPayWard()" />	
							</label> <label class="auto">Ward</label>
							<select name="admissionWard" id="admissionWard"
								onclick="getBedStatus(this.value);">
								<option value="0">Select</option>
								<%for(MasDepartment ward:wardDepartmentList){
									if(opdPatientDetails.getAdmissionWard().getId()==ward.getId()){
								%>
										<option value="<%=ward.getId()%>" selected="selected"><%=ward.getDepartmentName() %></option>
								<%}else{ %>
										<option value="<%=ward.getId()%>"><%=ward.getDepartmentName() %></option>	
								<%} }%>
							</select>
							<div id="bedDiv"></div>
						</div>
							<%}else{ %>
							<div id="admDiv" class="collaps">
							<label class="auto">Admission Date</label>
							 <input type="text"	name="admissionDate" id="admissionDate"	style="text-align: left;" class="dateTextSmall"	value="<%=currentDate%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<div class="clear"></div>
							<label class="autoSpace">Payward

							<input type="checkbox"
								name="payward" id="payward" class="radioCheckCol2" value="Y" onchange="checkPayWard()"
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
						<%} %>
						
					</div>
					<div class="clear"></div>
				 <label class="autoSpace" onclick="setDisablePharmacy();">Pharmacy
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="PharmacyqueueId" name="Pharmacyqueue" onclick="setDisablePharmacy();" />
						</label>
						
						 <label class="autoSpace">Laboratory
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="laboratoryqueueId" name="laboratoryqueue" />
						</label>
						
						 <label class="autoSpace">X-ray
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="RadiologyqueueId" name="Radiologyqueue" />
						</label>
						
						<!--  <label class="autoSpace">Sonography
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="SonographyId" name="Sonography" />
						</label>
						
						 <label class="autoSpace">Echo
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="EchoId" name="Echo" />
						</label>
						
						 <label class="autoSpace">Ultrasound
					<input type="checkbox"  class="radioCheckCol2" value="y"	id="UltrasoundId" name="Ultrasound" />
						</label> -->
				</div>
			</div>
			<!-- op consultation scren end here  -->
			
			<div id="country3" class="tabcontentIn">
<div class="Block">

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

</div>
</div>
			

			<div id="country4" class="tabcontentIn">
				<div class="Block">
						<div class="floatRight" style="margin:0px 15px 5px 0px;">
							<label class="autoSpace "><input type="checkbox" id="ncd" name="ncd" <%=opdPatientDetails!=null && opdPatientDetails.getNcdStatus()!=null && opdPatientDetails.getNcdStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)?"checked='checked'":""%>   class="radioCheckCol2"/>NCD Confirm</label>
						</div>
					<div class="clear"></div>
					<label>General Examination</label>
					<textarea class="opdMainTextArea yellowBackground"
						name="generalExaminationEXM" id="generalExaminationEXM"
						validate="generalExaminationEXM,string,no" cols="0" rows="0"
						maxlength="300">
 <%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getGeneralExamination():"" %>
 </textarea>
					<!-- <select class="listBig"  name="generalExamination2" id="generalExamination2"  multiple="4" size="5" ></select> -->
					<input type="button" class="buttonAuto-buttn" 
						value="+" onclick="getGeneralExaminationTemplate();" /> <label>Systemic
						Examination</label>
					<%if(opdPatientDetails!=null && opdPatientDetails.getSystemicExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)){ %>
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
					<input type="button" class="buttonAuto-buttn" 
						value="+" onclick="getSystemicExaminationTemplate();" />

					<div class="clear"></div>
					<label>ICD Code</label> <input name="icdCode1" value=""
						id="icdCode1" onblur="getIcd(2);" /> <input name="temp1" value=""
						id="temp1" type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif"
						WIDTH="24" HEIGHT="20" class="search-img"
						onClick="javascript:openPopupDiagnosisWindow();"
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
					<input type="hidden" id="icd" />
					<div class="clear"></div>
					
					<label><span>*</span>Diagnosis</label>
					<input type="text"	id="icd2" name="icd2"	onblur="getICDListBasedOnSnomedId();" 
					onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'icd2');"
					/>
					<input type="hidden"	id="snomedTermConceptIdEXM" name="snomedTermConceptIdEXM"/>
					
					
					<!-- onblur="fillDiagnosisCombo(this.value);" -->
					<!-- <div id="ac2update22" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript"
						charset="utf-8">
							  new Ajax.Autocompleter('icd2','ac2update22','opd?method=getSnomedListForAutoCompleteItem',{parameters:'requiredField=icd2'});
					</script> -->

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
					
					<%
					String relationName="";
					if(opdPatientDetails!=null &&  opdPatientDetails.getReferedStatus()!=null && (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C"))  && opdPatientDetails.getVisit().getId().equals(visitId)/* && !opdPatientDetails.getVisit().getVisitStatus().equalsIgnoreCase("c") */){ %>
									<div id="referalDiv" style="display: block" >
		
									<label>Referral </label>
									 <select id="referral" name="referral"	class="midium">
									 	<%if(opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")){ %>
									 			<option value="0" >No</option>
												<option value="1" selected="selected">Yes</option>
									 	<%}else{ %>
									 			<option value="0" selected="selected">No</option>
												<option value="1">Yes</option>
									 	<%} %>
										
									</select>
		
								<div id="referDiv" >
									<label class="auto">Refer To</label>
									<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
									<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="autoSpace"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%>
		
									<%if(opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")){ %>
										<input type="hidden" name="referCheck" id="referCheck" value="y"/>
										<label class="autoSpace">
										<input type="radio"	class="radioCheckCol2" name="referTo" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("Interanal")?"checked='checked'":"" %>  id="referInternal" value="Internal" onclick="checkReferTO('referInternalRecall',<%=referredDept%>);" />Internal</label>
										<label class="autoSpace">
										<input type="radio" class="radioCheckCol2" name="referTo" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"checked='checked'":"" %>id="referExternal" value="External" onclick="checkReferTO('referExternal',<%=referredDept%>);" />External</label>
									<%}%>
									
		
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"	id="referVisitDate" name="referVisitDate" class="date"	value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','-');"
										 />
									<img  src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" /> 
									<label id="priorityLabelId">Current Proirity No.</label>
									<select
										id="priorityId" name="priorityName" tabindex="1">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select>
									<div class="clear"></div>
									<label id="referdistrictLabel" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"style='display:block'":"" %> >District</label>
									<select	id="referdistrict" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"style='display:block'":"" %> name="referdistrict"	onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%for(MasDistrict district:masDistrictList){
										%>
											<%if(opdPatientDetails.getReferedDistrict()!=null && opdPatientDetails.getReferedDistrict().getId()==district.getId()){ %>
											<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
											<%}else{ %>
											<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
											<%} %>
										<%}%>
									</select> <label id="referHospitalTypeLabel">Hospital Type</label>
									<select	id="referHospitalType" name="referHospitalType"	onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%if(hospitalTypeList.size()>0){
											for(MasHospitalType masHospitalType:hospitalTypeList){
											%>
											<%if(opdPatientDetails.getReferredHospital() != null && opdPatientDetails.getReferredHospital().getHospitalType().getId()==masHospitalType.getId()){ %>
											<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
											<%}else{ %>
											<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
											<%} %>
										<%}}%>
									</select>
									<div class="clear"></div>
		
									<label id="referhospitalLabel">Hospital</label> <select
										id="referhospital" name="referhospital"
										onchange="fnGetHospitalDepartment(this.value,'referExternal',<%=referredDept%>);">
										<option value="0">Select</option>
										<%for(Object[] msh:masHospitals){
										%>
										<%if(opdPatientDetails.getReferredHospital()!=null && opdPatientDetails.getReferredHospital().getId()==msh[0]
											&& opdPatientDetails.getReferredHospital().getHospitalType().getId()==msh[2])
										{%>
										<option value="<%=msh[0]%>" selected="selected"><%=msh[1]%></option>
										
										<%}else if(opdPatientDetails.getReferredHospital() != null && opdPatientDetails.getReferredHospital().getHospitalType().getId()==msh[2]){ %>
										<option value="<%=msh[0]%>"><%=msh[1]%></option>
										<%} %>
										<%}%>
									</select>
									<div class="clear"></div>
		
									<label id="referdepartmentLabel">Department</label> <select
										id="referdepartment" name="referdepartment"
										onchange="fnGetDoctorDepartment(this.value);">
										<option value="0">Select</option>
										<%for(MasDepartment dep:deptList){%>
											<%if(opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId()==dep.getId()) {
											%>
												<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
											<%}else{ %>
												<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
											<%} %>
										<%}%>
									</select> <label>Doctor</label>
									 <select id="refereddoctor"	name="refereddoctor">
										<%if(opdPatientDetails.getReferredDoctor()!=null) {
											//Commented by Arbind on 15-03-2017
											/* String name=opdPatientDetails.getReferredDoctor().getFirstName();
												name=opdPatientDetails.getReferredDoctor().getMiddleName()!=null && !opdPatientDetails.getReferredDoctor().getMiddleName().equals("")?opdPatientDetails.getReferredDoctor().getMiddleName():" ";
												name=name+" "+opdPatientDetails.getReferredDoctor().getLastName()!=null && !opdPatientDetails.getReferredDoctor().getLastName().equals("")?opdPatientDetails.getReferredDoctor().getLastName():" "; */
											%>
												<option value="<%=opdPatientDetails.getReferredDoctor().getId()%>" selected="selected"><%=opdPatientDetails.getReferredDoctor().getEmployeeName()%></option>
											<%}else{ %>
												<option value="0">Select</option>
											<%} %>
									</select>
		
		
									<div class="clear"></div>
									<label>Patient Advise</label>
									<textarea name="patientAdvise" validate="patientAdvise,string,no"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" onkeyup="return checkLength(this)"><%=opdPatientDetails.getPatientAdvise() != null ? opdPatientDetails.getPatientAdvise() : ""%></textarea>
									<input type="button" class="buttonAuto-buttn" value="+"		onclick="" />
									 <label>Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"	id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
										onkeyup="return checkLength(this)"><%=opdPatientDetails.getReferralNotes() != null ? opdPatientDetails.getReferralNotes() : ""%></textarea>
									<input type="button" class="buttonAuto-buttn" value="+"
										onclick="" />
								</div>
								<input type="hidden" name="userName" value="<%=userName %>" />
								<%
									if(visit.getHin().getRelation() != null){
							    	 relationName=visit.getHin().getRelation().getRelationName();
								if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
								%>
								<label>No. of Days</label> <input name="days" type="text"
									maxlength="1" />
								<%}} %>
							</div>
					<%}else{ %>
								<div id="referalDiv" >
		
									<label>Referral </label> <select id="referral" name="referral"
										class="midium">
										<option value="0" selected="selected">No</option>
										<option value="1">Yes</option>
									</select>
		
								<div id="referDiv" class="col collaps">
									<label class="auto">Refer To</label>
									<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
									<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="autoSpace"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%>
		
									<label class="autoSpace"><input type="radio"
										class="radioCheckCol2" name="referTo" id="referInternal"
										value="Internal" onclick="checkReferTO('referInternal',<%=deptIdSession%>);" />Internal</label>
									<label class="autoSpace"><input type="radio"
										class="radioCheckCol2" name="referTo" id="referExternal"
										value="External" onclick="checkReferTO('referExternal',<%=deptIdSession%>);" />External</label>
		
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
										onchange="fnGetDistrictHospital();" onblur="fnGetDistrictHospital();">
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
										onchange="fnGetHospitalDepartment(this.value,'referExternal',<%=deptIdSession%>);" >
										<option value="0">Select</option>
										<%for(Object[] msh:masHospitals){%>
										<%if(hospitalId==(Integer)msh[0]){ %>
										<option value="<%=msh[0]%>" selected="selected"><%=msh[1]%></option>
										<%}else{ %>
										<option value="<%=msh[0]%>"><%=msh[1]%></option>
										<%} %>
										<%}%>
									</select>
									<div class="clear"></div>
		
									<label id="referdepartmentLabel">Department</label> <select
										id="referdepartment" name="referdepartment"
										onchange="fnGetDoctorDepartment(this.value);" onblur="fnGetDoctorDepartment(this.value);">
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
									if(visit.getHin().getRelation() != null){
							    	 relationName=visit.getHin().getRelation().getRelationName();
								if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")){
								%>
								<label>No. of Days</label> <input name="days" type="text"
									maxlength="1" />
								<%}} %>
							</div>
					<%} %>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<div id="country5" class="tabcontentIn">
				<div class="Block">
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
		class="buttonBig" onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>',csrfTokenName+'='+csrfTokenValue)" />

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
					<table border="0" cellspacing="0" cellpadding="0" style="border-top:solid 1px #c0c0c0;">
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
								<div class="tableForTab" style="width: 753px; height: auto; overflow: scroll;"
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
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<input type="button" class="buttonBig" name="prev"
					value="Save As Template"
					onclick="javascript:openPopupForSaveInvestigation();" />
			</div>

			<!-- Allergy tab: Rajendra Kumar :23-03-2015 -->
			<div id="country6" class="tabcontentIn">
				<div class="Block">
					<div class="addDeleteButton">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="&nbsp;" onclick="removeRowForAllergy();" align="right" />
						<input type="button" class="buttonAdd" alt="Add" tabindex="4"
							value="&nbsp;" onclick="addRowForAllergy();" align="right" />
					</div>
					<div class="clear"></div>
					<div class="tableForTab" style="width:883px;">
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
									<td><select style="background: #FFFF99"
										name="allergystatus<%=incr%>" id="allergystatus<%=incr%>">
											<option value="0">Select</option>
											<option value="1">Active</option>
											<option value="2">Inactive</option>
									</select></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="allergyHeaderIds"
								id="allergyHeaderIds" value="<%=allergyHeaderId%>" />
						</div>
					</div>
					<div class="addDeleteButton">
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

			<div id="country7" class="tabcontentIn">
				<div class="Block">

					<label>Nursing Care</label>

					<div class="addDeleteButton">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="&nbsp;" onclick="removeRowTreatmentNursingCare();"
							align="right" /> <input type="button" class="buttonAdd"
							alt="Add" tabindex="4" value="&nbsp;"
							onclick="addRowTreatmentNursingCare();" align="right" />
					</div>
					<div class="clear"></div>
					<div id="divTemplet" style="width: 890px;">
						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="gridNursing">
							<tr>
								<th>&nbsp;</th>
								<th>Procedure Name</th>
								<th>Frequency<span>*</span></th>
								<th>No.Of Days<span>*</span></th>
								<th>Remarks</th>
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
									<%if(procedureStatus.equalsIgnoreCase("y")) {%>
										<input	readonly="readonly" type="text"	class="opdTextBoxSmall textYellow"
										value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" size="35"	name="procedureName_nursing<%=incr%>"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 />
									<%}else{%>
										<input	type="text" class="opdTextBoxSmall textYellow"	value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" 
										size="35" name="procedureName_nursing<%=incr%>"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  /> 
										<%}%>
									<div id="ac2updates_nursing<%=incr%>" style="display: none;" class="autocomplete"></div>
									<script type="text/javascript"	language="javascript" charset="utf-8">
											  new Ajax.Autocompleter('procedureName_nursing<%=incr%>','ac2updates_nursing<%=incr%>','opd?method=getNursingCareProcedureAutoList',{minChars:3,
											  callback: function(element, entry) {
								              return entry + '&minor_major=1';
								        }, parameters:'requiredField=procedureName_nursing<%=incr%>'});
									</script> 
								</td>
								<td><select name="frequency_nursing<%=incr%>"
									id="frequency_nursing<%=incr%>" tabindex="36" onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')"> 
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
		          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
	            </script> <% }%></td>
								<td id="nf<%=incr%>"><input type="text"
									name="noOfDays_nursing<%=incr%>" id="noOfDays_nursing<%=incr%>" 
									value="<%=noOfDays!=0?noOfDays:""%>" class="opdTextBoxTSmall textYellow" size="5" />
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
					<div class="paddingTop25">
						<label>Surgery Procedure</label>

						<div class="addDeleteButton">
							<input type="button" class="buttonDel" tabindex="3" alt="Delete"
								value="&nbsp;" onclick="removeRowTreatmentSurgery();"
								align="right" /> <input type="button" class="buttonAdd"
								alt="Add" tabindex="4" value="&nbsp;"
								onclick="addRowTreatmentSurgery();" align="right" />
						</div>
						<div class="clear"></div>
						<div id="divTemplet" style="width: 890px;">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="gridSurgery">
								<tr>
									<th>&nbsp;</th>
									<th>Procedure Name</th>
									<th>Tentative Date</th>
									<th>Remarks</th>
									<th>Alert To Field Staff</th>
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
	Integer surgerChargeId=0;
	for(;incr<len;incr++){
		OpdSurgeryDetail opdSurgeryDetails1=null;
		if(opdSurgeryDetails.size()>0 ){
			opdSurgeryDetails1=opdSurgeryDetails.get(incr);
		}
		if(opdSurgeryDetails1!=null){
			surgeryId=opdSurgeryDetails1.getId();
			surgeryHeaderId=opdSurgeryDetails1.getOpdSurgery().getId();
			surgery=opdSurgeryDetails1.getChargeCode().getChargeCodeName();
			surgerChargeId=opdSurgeryDetails1.getChargeCode().getId();
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
									<td>
									<input type="text" class="opdTextBoxSmall textYellow"	tabindex="32" value="<%=surgery %>"	id="procedureName_surgery<%=incr%>" size="35"
										name="procedureName_surgery<%=incr%>"
										onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_surgery<%=incr%>');"
										onblur="checkMappedCharge(this.value,'<%=incr%>');" 	
										/>
									<input type="hidden" id="surgery_code_id<%=incr%>" value="<%=surgerChargeId%>" name="surgery_code_id<%=incr%>"/> 	
								<%--  <div id="ac2updates_surgery<%=incr%>" style="display: none;" class="autocomplete"></div>
								<script type="text/javascript" language="javascript" charset="utf-8">
								  new Ajax.Autocompleter('procedureName_surgery<%=incr%>','ac2updates_surgery<%=incr%>','opd?method=getNursingCareProcedureAutoList',{minChars:3,
									  callback: function(element, entry) {
								            return entry + '&minor_major=2';
								        }, parameters:'requiredField=procedureName_surgery<%=incr%>'});
								</script>  --%>
							    </td>
									<td><input type="text" id="tentativeDate<%=incr%>"
										value="<%=surgerDate %>" name="tentativeDate<%=incr%>"
										class="small textYellow"
										validate="t1ntativeDate<%=incr%>,string,no"
										readonly="readonly" /> <img src="/hms/jsp/images/cal.gif"
										width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.opdMain.tentativeDate<%=incr%>,event);" />
								</td>
									<td><input type="text" name="remark_surgery<%=incr%>"
										value="<%=surgerRemark %>" id="remark_surgery<%=incr%>"
										class="largTextBoxOpd textYellow" /></td>
									<td><input type="checkbox" name="alertToStaffy<%=incr%>" id="alertToStaff<%=incr%>" onchange="displayPhAlert(this.value,<%=incr %>>)"/></td>	
								</tr>
								<%} %>
							</table>
							<input type="hidden" id="surgeryHeaderId" name="surgeryHeaderId"	value="<%=surgeryHeaderId%>" />
						    <input type="hidden" name="surgeryhdb" value="<%=incr-1 %>"	id="surgeryhdb" />
						</div>
					</div>
				</div>
			</div>

			<!-- prescription tab :by Rajendra kumar  -->
			<div id="country8" class="tabcontentIn">
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

						<!-- <select class="midium" name="tempLatePrescriptionTab"
							id="tempLatePrescriptionTab"
							 onfocus="checkEnteredDiagnosis();"
							onchange="fnGetPrescriptionTemplate(this.value);">
							<option value="0">Select</option>
						</select> -->
					</div>
					<div class="paddLeft30">
									<select class="medium" multiple="5" style="height: 80px;"
										name="tempLatePrescriptionTab" id="tempLatePrescriptionTab"
										onchange="fnGetPrescriptionTemplate(this);">
										<option value="-1">Select</option>
										<%for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("P")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateTreatments().size()>0){ %>
										<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
										<%}%>
										<% } %>
									</select>
									<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int pIndex=0;
				 for(OpdTemplate opd:templateListForInvestigation){ %>
					<%if(opd.getTemplateType().equalsIgnoreCase("P")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateTreatments().size()>0){ %>
					tempArrayTemp[<%=pIndex%>]= new Array();
					tempArrayTemp[<%=pIndex%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=pIndex%>][1] = "<%=opd.getTemplateName() %>";
					<%pIndex++;%>
					<%}%>
				<%}%>
				</script>
</div>
					<input name="Prevoius2" type="button" class="buttonBig"
						value="Last Prescription"
						onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue)" />
					<div class="addDeleteButton">
						<input type="button" class="buttonDel" value=""
							onclick="removeRowPrescriptionTab('opcTab');" align="right" /> <input
							type="button" class="buttonAdd"
							onclick="addRowPrescriptionTab();" value="" align="right" />
					</div>
					<div class="clear"></div>
					<div class="paddLeft15">
						<div class="tableForTab" style="width:890px; height:152px; overflow: scroll;">
							<!-- <div id="divTemplet2"> -->
								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="prescriptionTabGrid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage</th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<!-- <th scope="col">Days</th> -->
										<th scope="col">Duration</th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
										<th scope="col"></th>
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
		String frequecnyType = "";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		Date sDate=null;
		Date eDate=null;
		String issuedStatus="";
		String routeName="";
		PatientPrescriptionDetails pd=null;
		String pAvailableStatus="";
		String conversion="";
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
			unit=pd.getItem().getDispUnit();
			conversion=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			frequecnyType = pd.getFrequency().getFrequencyType();
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
											<% }%>
											<input type="hidden" id="parkPrescriptionIds<%=incr%>"
											name="parkPrescriptionIds<%=incr%>"
											value="<%=pd!=null && pd.getId()!=0?pd.getId():"0"%>"
											readonly="readonly" /> 
											
											<input type="hidden"
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
											onblur="fillValue(this.value,<%=incr%>,'tab');"
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
											onchange="getFrequencyValuepTab(this.value,<%=incr%>);fillValue(this.value,<%=incr%>,'tab');displaySOSQtypTab(this.value,<%=incr%>);displaFrequencyTypeForPrescriptionTab(this,<%=incr%>);">
												<option value="0">Select</option>
												<%
				  
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
			       String type = masFrequency2.getFrequencyType();
	          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
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
		          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
	            </script> <% }%></td>
	            						
										<td>
										<div style="width:100px; float: left;">
										<input type="text" name="noOfDayspTab<%=incr%>"
											id="noOfDayspTab<%=incr%>"
											class="textYellow opdTextBoxTSmall"
											value="<%=ndays!=0 ?ndays:"" %>" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValue(this.value,<%=incr%>,'tab');setEndDate(this.value,<%=incr %>);" />
									    <p style="line-height:0px;" id="frequencyTypeForPrescriptionTab<%=incr %>" ><%=frequecnyType %></p>
										</div>
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
										<td>
										<input type="text" name="totalpTab<%=incr%>"
											id="totalpTab<%=incr%>"
											value="<%=total!=null && total!=0?total:"" %>"
											class="textYellow opdTextBoxTSmall" size="5"
											validate="Total,num,no" readonly="readonly" /></td>
										
										<td>
											<input type="text" name="unitLablepTab<%=incr%>"
											id="unitLablepTab<%=incr%>" value="<%=!conversion.equals("")?conversion:"" %>"
											class="textYellow opdTextBoxTSmall" size="5"
											readonly="readonly" />
										</td>	
											
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
									<tbody id="divTemplet2"></tbody>	
								</table>
								<input type="hidden" name="pTabhdb" value="<%=incr-1%>"
									id="pTabhdb" />
							<!-- </div> -->
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
				<input type="button" class="buttonBig" name="prev"
					value="Save As Template"
					onclick="javascript:openPopupForSavePrescriptiontamplateTab();" />
				<!-- countries.cycleit('prev') -->
			</div>

			<!-- Comorbidity Tab: Rajendra Kumar 24-03-2015 -->
			<div id="country9" class="tabcontentIn">
				<div class="Block">
					<div class="addDeleteButton">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							align="right" onclick="removeForComorbidity();" /> <input
							type="button" class="buttonAdd" alt="Add" tabindex="4"
							onclick="addRowForComorbidity();" align="right" />
					</div>
					<div class="clear"></div>
					<div class="tableForTab" style="width:890px;">
						<div id="divTemplet">
							<div id="divComorbidity">
								<table border="0" align="center" cellpadding="0" cellspacing="0" id="comorbidityGrid">
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
					<input type="hidden" value="<%=incr%>" id="comorbidityCount" name="comorbidityCount" />
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
		</div>

			<!-- Comorbidity Tab: Rajendra Kumar 24-03-2015 -->
			<div id="country10" class="tabcontentIn">
				<div class="Block">
					<div class="clear"></div>
<%-- 
					<label>Speciality</label> <select id="specialty" name="specialty"
						onchange="display(this.value)">
						<option value="0">Select</option>
						<%for(MasSpecialtyTemplate mstp:specialtyTemplateList){ %>
						<option value="<%=mstp.getId()%>"><%=mstp.getTemplateName()%></option>
						<%} %>
					</select> --%>
					<div id="specialityDiv"></div>
				</div>
			</div>
			<!-- MLC Tab: Amit Das 21-04-2016 -->
			<div id="country11" class="tabcontentIn">
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
						<%if(opdPatientDetails!=null && opdPatientDetails.getPoliceIntimation()!=null && opdPatientDetails.getPoliceIntimation().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)){ %>
						 <input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" checked="checked" />Police Intimation</label>
						 <%}else{ %>
						 	<input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" />Police Intimation
						 <%} %>
					</label>	 
				</div>
			</div>
			
			<div id="country12" class="tabcontentIn">
				<div class="Block">
					<div class="clear"></div>

					
					<label>Head Circumference</label> 
					<input name="headCircumference" value="<%=babyDetails != null && babyDetails.getHeadCircumferance()!= null?babyDetails.getHeadCircumferance().intValue():""  %>" />
					
					<label>Weight</label> 
					<input name="weight" value="<%=babyDetails != null && babyDetails.getWeight() != null?babyDetails.getWeight():""  %>" />
					
					<label>Delivery Time</label>
					<input name="deliveryTime" value="<%=babyDetails != null && babyDetails.getTimeOfBirth() != null?babyDetails.getTimeOfBirth():""  %>" />
					
					<label>Delivery Date</label> 
					<input name="deliveryDate" value="<%=babyDetails != null && babyDetails.getBirthCertificationDate() != null?HMSUtil.convertDateToStringWithoutTime(babyDetails.getBirthCertificationDate()):""  %>" />
					
					<label>Delivery Type</label> 
					<input name="deliveryType" value="<%=babyDetails != null && babyDetails.getDeliveryType() != null?babyDetails.getDeliveryType().getDeliveryType():""  %>" />
					
				</div>	
			</div>
			
			<div id="country13" class="tabcontentIn">
				<div class="Block">
					<div class="clear"></div>

					
					<label>Family Planning Method</label> 
				<input name="familyPlanningMethod" value="<%=phRegDetail != null && phRegDetail.getMethodName()!= null?phRegDetail.getMethodName():""  %>" />
					
					<label>Complication</label> 
					<input name="complication" value="<%=phRegDetail != null && phRegDetail.getComplication()!= null?phRegDetail.getComplication():""  %>" />
					
				</div>	
			</div>
	<div class="clear"></div>
			<%if(!visit.getVisitStatus().equalsIgnoreCase("c")){ %>
				<input type="button" class="buttonAuto" name="next" value="Next"	onclick="fnSubmitPatient('n');" />
				<input type="button" class="buttonAuto" value="Waiting List" onClick="showWaitingList();" />
				<input name="Submit11" id="Submit11" class="buttonAuto" type="button" align="right"	value="Submit"
				 onclick="if(checkForProcedure()){if(fillcheckDoseFrequency()){if(checkForValidMortuary()){fnSubmitPatient('s');}}}" />
				<input type="button" class="buttonAuto" value="Park Patient" onclick="fnSubmitPatient('p');" />
				<input type="button" class="buttonAuto" value="Second Opinion" onclick="SecondOpinion();" />
<!-- 				<input type="button" class="buttonAuto" value="Ehr Report"	onclick="submitForm('opdMain','/hms/hms/enquiry?method=printPatientEpfReportOpd');" /> -->
			<%}else if(visit.getVisitStatus().equalsIgnoreCase("c")){ %>
				<input name="Submit11" id="Submit11" class="buttonAuto" type="button" align="right"	value="Submit" onclick="if(checkExpired()){if(checkForValidMortuary()){fnSubmitPatient('s');}}" />
			<%} %>

			<div class="clear"></div>
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
		<input type="hidden" id="gender" name="gender" value="<%=gender != null?gender:"" %>" />
		<input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge != 0?patientAge:"" %>" />

		<%
		String orderSeqNo="";
		if(mapForDS.get("orderSeqNo") != null){
			orderSeqNo = (String)mapForDS.get("orderSeqNo");
		}
 %>
		<input name="<%=ORDER_NO %>" type="hidden" value="<%=orderSeqNo %>" />

		<div class="arrowlistmenu">
			<h3 class="menuheader expandable">OPD Management</h3>
			<ul class="categoryitems">
				<li><a
					href="javascript:showPatientHistory('<%=visit.getHin().getHinNo() %>',csrfTokenName+'='+csrfTokenValue)">Patient
						History</a></li>
				<li><a href="javascript:showDiagnosis(csrfTokenName+'='+csrfTokenValue)">Clinical Assist</a></li>
				<li><a
					href="javascript:popFuturConsultation('registration?method=showOnlineAppointmentJsp&futureConsultFlag=1&uhid=<%=visit.getHin().getHinNo()%>&'+csrfTokenName+'='+csrfTokenValue);">Future
						Consultation</a></li>
				<!-- <li><a href=javascript:void(0)>Patient Referral</a></li> -->
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
				<li><a href="javascript:openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');">NCD Clinic</a></li>
<%-- 				<li><a href="javascript:openPopupForLabResults(csrfTokenName+'='+csrfTokenValue,'<%=visit.getId()%>','<%=visit.getHin().getId()%>');">Lab Results</a></li> --%>
				<li><a href="javascript:openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=orderNo%>');">Lab Results</a></li><!-- added by govind -->
				
				<%if(visit.getHin().getMember() != null && visit.getHin().getMember().getId() != null){ %>
				<li><a href="javascript:openPopupWindowPhTravelHistory('<%=visit.getHin().getMember().getId()%>',csrfTokenName+'='+csrfTokenValue);">Travel History</a></li>
				<%} %>
			</ul>
			<%
		String empDeptCode="";			
			empDeptCode=visit.getDepartment().getId().toString();
				/*for (MasDepartment  masDepartment : masDepartmentList){
					if(masDepartment.getEmpDept() != null){
						empDeptCode=masDepartment.getEmpDept().getEmpDeptCode();
					}
					
				}*/
				
					if(empDeptCode.equalsIgnoreCase(empDeptCodeForOPTH)){%>
	<%-- 		<h3 class="menuheader expandable">Opd Specification</h3>
			<ul class="categoryitems">

				<li>
				<li><a
					href="javascript:openPopupForOphthalmology('opd?method=showOpdOphthamologyJsp&visitId=<%=visit.getId()%>');">Ophthalmology</a></li>
			</ul> --%>
			<%} %>
			<!-- Commented by Arbind on 18-04-2017 -->
			<%-- <%if(empDeptCode.equalsIgnoreCase(empDeptCodeForGYNE) || empDeptCode.equalsIgnoreCase(empDeptCodeForGenMed) || empDeptCode.equalsIgnoreCase(empDeptCodeForAnt)){%>
			<!-- <h3 class="menuheader expandable">Opd Specification</h3> -->
			<ul class="primary-items">                       
					<li><a>Obstetric and Gynaecology</a> 
					<!-- added by govind 21-10-2016 -->
					  <ul id="subMenu">
					  <%if(empDeptCode.equalsIgnoreCase(empDeptCodeForAnt) ){%>
				<!-- ANC1 and OBG commented by Arbind on 29-03-2017 -->
				<li><a
					href="javascript:openPopupForAntenatal('opd?method=showAntenatalCardJsp&visitId=<%=visit.getId()%>');">Antenatal
						Card1</a></li>	
				<li><a
					href="javascript:openPopupForAntenatal('opd?method=showAntenatalCardJsp2&visitId=<%=visit.getId()%>');">Antenatal
						Card</a></li>
					<%} %>	
					<%if(empDeptCode.equalsIgnoreCase(empDeptCodeForGYNE)){%>		
					<li><a
					href="javascript:openPopupForAntenatal('opd?method=showAntenatalCardJsp&visitId=<%=visit.getId()%>');">Antenatal
						Card1</a></li>	
					<li><a
					href="javascript:openPopupForAntenatal('opd?method=showAntenatalCardJsp2&visitId=<%=visit.getId()%>');">Antenatal
						Card</a></li>			
				<li><a 
 					href="javascript:openPopupForAntenatal('opd?method=showOBGONEJsp&visitId=<%=visit.getId()%>');">OBG</a></li> 
 					<%} %>
</ul>

<!-- added by govind 21-10-2016 end-->
</li>

			</ul>
			<%} %> --%>
			
			<%
				Set<String> set=new HashSet<String>();
					
				for(Object[] mstp:specialtyTemplateList){ 
					
					%>
			<!-- Commented and added by Arbind on 18-04-2017 -->
			<%-- <%if(mstp[0] != null){ %>	
				<ul class="primary-items">    
			<li><a rel="country8" href="#" onclick="display('<%=mstp[0] %>','<%=mstp[1] %>');displaySpecialty('<%=mstp[1]%>');"><%=mstp[1] %></a></li>
			</ul>
			
			<%}} %>	 --%>
			<%if(mstp[0] != null && ((mstp[1].toString()).equalsIgnoreCase("Antenatal Card") || (mstp[1].toString()).equalsIgnoreCase("Gynecology"))){ %>	
				<ul class="primary-items">
					<li><a href="#" onclick="display('<%=mstp[0] %>','<%=mstp[1] %>');displaySpecialty('<%=mstp[1]%>');"><%=mstp[1] %></a></li>
				</ul>
			
			<%} else { if(mstp[0] != null) { %>
					<ul class="primary-items">
					<li><a rel="country8" href="#" onclick="display('<%=mstp[0] %>','<%=mstp[1] %>');displaySpecialty('<%=mstp[1]%>');"><%=mstp[1] %></a></li>
				</ul>
			<%}} } %>	
					
		
						<%-- <%	if(set.add(mstp[2].toString())){
								
							%>
			<ul class="primary-items">                       
					<li><a><%=mstp[2] %></a> 
					   <ul id="subMenu">
					<%
					
					String deptCode = "";
					if(session.getAttribute("deptCode")!=null){
						deptCode = (String)session.getAttribute("deptCode");
					}
					%>
				
				
				<%
				
				if(deptCode.equalsIgnoreCase(deptCodeDermatology)){%>
				<li><a rel="country9" href="#" onclick="display('','Leprosy Proforma');displaySpecialty('Leprosy Proforma');">Leprosy Proforma</a></li>
				 <li><a rel="country9" href="#" onclick="display('','General Proforma');displaySpecialty('General Proforma');">General Proforma</a></li> 
				<%}%>
				
				
				<%if(deptCode.equalsIgnoreCase(deptCodePsychiatry)){%>
					<li><a rel="country8" href="#" onclick="display('','Deaddiction Centre');displaySpecialty('Deaddiction Centre');">Deaddiction Centre</a></li>
					<li><a rel="country8" href="#" onclick="display('','Psychogeriatric Clinic');displaySpecialty('Psychogeriatric Clinic');">Psychogeriatric Clinic</a></li>
				<%}%>
				<%if(deptCode.equalsIgnoreCase(deptCodePaeditrics)){%>
				 	<li><a rel="country8" href="#" onclick="display('','Nicu Case Record');displaySpecialty('Nicu Case Record');">Nicu Case Record</a></li>
				 	<li><a rel="country8" href="#" onclick="display('','Respiratory Clinic');displaySpecialty('Respiratory Clinic');">Respiratory Clinic</a></li>
				<%}%>
				
				
					<%}%>
					<li><a rel="country8" href="#" onclick="display('<%=mstp[0] %>','<%=mstp[1] %>');displaySpecialty('<%=mstp[1] %>');"><%=mstp[1] %></a></li>
					
					
					
				<%	if(set.add(mstp[2].toString())){
								
					%>
				</ul>
				</li>
				</ul>
				<%} %>
				<%}%>
			<%	String deptCode = "";
				if(session.getAttribute("deptCode")!=null){
					deptCode = (String)session.getAttribute("deptCode");
				}%>
			<ul class="primary-items"> 
			
			<%
				System.out.println("deptCode=="+deptCode);
				System.out.println("deptCodeGeneralMedicine=="+deptCodeGeneralMedicine);
				if(deptCode.equalsIgnoreCase(deptCodeGeneralMedicine)){%>
				<li><a rel="country9" href="#" onclick="display('','Medicine');displaySpecialty('Medicine');">Medicine </a></li>
				<%}%>
			
				<%if(deptCode.equalsIgnoreCase(deptCodeENT)){%>
				<li><a rel="country8" href="#" onclick="display('','ENT Examination');displaySpecialty('ENT Examination');">ENT Examination</a></li>
				<%}%>
			
				<%
				
				if(deptCode.trim().equalsIgnoreCase(deptCodeOrthopadics)){
				%>
				 	<li><a rel="country8" href="#" onclick="display('','Orthopedic');displaySpecialty('Orthopedic');">Orthopedic</a></li>
				<%}%>
					</ul> --%>
				
		</div>
		
		
		<input name="splName" id="splName" type="hidden" 	value="" />
		<input name="request" id="requestId" type="hidden"
			value="<%=visit.getHin().getId()%>" />
			
			<input name="expired" id="expiredId" type="hidden" value="<%=expired%>" />
			
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<div class="clear"></div>
	</form>
</body>
<%-- <div id="dialog" title="BMI" style="display: none;">
	<label class="auto">Weight</label>
	<input type="text" class="textYellow" id="weight" maxlength="3" class="allownumericwithoutdecimal"
		value="<%=weight==0?"":weight %>" validate="Height,int,no" /><span>Kg.</span>
	<div class="clear"></div>
	<label class="auto">Height</label><input type="text" class="textYellow" maxlength="3" class="allownumericwithoutdecimal"
		value="<%=height==0?"":height %>" id="height" validate="Height,int,no" /><span>Cms.</span>
	<div class="clear"></div>
	<input type="button" class="button" id="submitCalBMI" value="Submit" />
	<input type="button" class="button" value="Reset" id="resetBmi" />
</div> --%>

<div id="vitalDialog" title="Vital Trends" style="display: none;">
	<label class="auto">UHID</label><input type="text" id="vitalUHID"
		class="auto" readonly="readonly" /><label class="auto">Patient	Name</label><input type="text" id="vitalPname" class="auto"
		readonly="readonly" />
	<div class="clear"></div>
	<table id="vitalTable"></table>
</div>

<!--main content placeholder ends here-->
<script type="text/javascript">

jQuery(function ($) {
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
	// added by Arbind on 05-04-2017
	 /* $("#calculateBmi").click(function(){
		 $("#dialog").css("color:black");
		 $("#dialog").dialog({width: 350,modal: true});
	 });
	 
	 $("#submitCalBMI").click(function(){
		 var bmicat;
			$("#bmi").val("");
			$("#weightShow").val("");
			$("#heightShow").val("");
			$("#bmicat").val(" ");
			
			if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
			{
			
			 $("#heightHidden").val($("#height").val());
			 $("#weightHidden").val($("#weight").val());
			 $("#weightShow").val($("#weight").val() + " Kg.");
			 $("#heightShow").val($("#height").val() + " Cms.");
			 
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
	}); */
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
		    String comorBidityStatus=dIcd.getComorbidityStatus()!=null && dIcd.getComorbidityStatus().equalsIgnoreCase("y")?"checked":"";
		    int  icdId=dIcd.getId();
		    String namecode=icdName+"["+icdCode+"]";
		%>
			var id="<%=icdCode%>";
			id=id.replace(".","_");
	    	id=id.replace("*","idid");
			cell1.innerHTML="<%=namecode%>";
			cell2.innerHTML = "<input type='checkbox' <%=comorBidityStatus%> id='"+id+"' class='radioCheckCol2' value='"+id+"' onclick='fnCopyToComorbidityTab(\""+id+"\")'/>";
			cell3.innerHTML ="<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>";
		<% }%> 
}


		// onload
		
		var referralType = '<% out.print(referralType);%>';
		//alert(referralType);
		
		if(referralType == 'NA')
			{
				document.getElementById('referInternal').checked=true;
				checkReferTO('referInternal',<%=deptIdSession%>);
			}
		if(referralType == 'External')
		{
			document.getElementById('referExternal').checked=true;
			checkReferTO('referExternal',<%=referredDept%>);
		}
		if(referralType == 'Internal')
		{
			document.getElementById('referInternal').checked=true;
			//Changed by Arbind on 15-03-2017
			//checkReferTO('referInternal');
			checkReferTO('referInternalRecall',<%=referredDept%>);
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
				if(document.getElementById('frequencyValue' + inc)!=null){
				 document.getElementById('frequencyValue'+inc).value = feqQty;
				}
				 if(document.getElementById('frequencyValuepTab' + inc)!=null){
				 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
				 }
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
				 if(document.getElementById('frequencyValuepTab' + inc)!=null){
				 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
				 }
			}

		// added by amit das on 15-09-2016
		function setVaccinPvms(elementId, elementValue){
			document.getElementById(elementId).value = elementValue;
		}

		// added by Arbind on 05-04-2017
		function calculateBMI() {
			var height = document.getElementById("height").value;
			var weight = document.getElementById("weight").value;
			document.getElementById("bmi").value = "";
			if(height != null && weight != null && height != "" && weight != "") {
				var height = 	parseFloat(height)/100;
				document.getElementById("bmi").value = ((weight/(height*height)).toFixed(2));
			}
			bmiCat();
		}

		function bmiCat(){
			var bmicat;
			var height = document.getElementById("height").value;
			var weight = document.getElementById("weight").value;
			if(height != null && weight != null && height != "" && weight != "") {
				var height = 	parseFloat(height)/100;
				bmicat=(weight/(height*height)).toFixed(2);

				document.getElementById("bmiCat").innerHTML = " ";
				 if(bmicat<18.5){
					 document.getElementById("bmiCat").innerHTML = "Underweight";
					 document.getElementById("bmiCat").style.color = '#F65C5C';
					 document.getElementById("bmi").style.color = '#F65C5C';
				}else if(bmicat>=18.5 && bmicat<25){
					document.getElementById("bmiCat").innerHTML = "Healthy Range" ;	
					document.getElementById("bmiCat").style.color = 'green';
					document.getElementById("bmi").style.color = 'green';
				}else if(bmicat>=25 && bmicat<=30){
					document.getElementById("bmiCat").innerHTML = "Overweight";
					document.getElementById("bmiCat").style.color = '#574F4F';
					document.getElementById("bmi").style.color = '#574F4F';
				}else if(bmicat>=30 && bmicat<=35){
					document.getElementById("bmiCat").innerHTML = "Obese";
					document.getElementById("bmiCat").style.color = '#C40707';
					document.getElementById("bmi").style.color = '#C40707';
				}else if(bmicat>35){
					document.getElementById("bmiCat").innerHTML = "Severely obese ";
					document.getElementById("bmiCat").style.color = '#AD0C0C';
					document.getElementById("bmi").style.color = '#AD0C0C';
				}else{
					document.getElementById("bmiCat").innerHTML = "";
				}
				}
				else{
					
					document.getElementById("bmiCat").innerHTML = "";
				}		
		}
		// added by Arbind on 05-04-2017 end
		function getPeriodRead(){
			if(document.getElementById('preganancy').checked == true){
				
				document.getElementById('period1').readOnly = false;
			}else{
				document.getElementById('period1').readOnly = true;
				document.getElementById('period1').value = "";
			}
		}
		
		 function displayMultipleSelection(obj,cnt){
			var multiSelectionValue="";
				for(var i = 1; i <=obj.length; i++){
					if(obj[i].selected != ""){
						multiSelectionValue +=  obj[i].value  +', ';
					  	  //alert("multiSelectionValue=111="+multiSelectionValue);
					 }
					document.getElementById('multiSelectText'+cnt).value = multiSelectionValue;
					}
				}
		
		 
		 function ancSummaryDetail(csrf) {
				var height = 400;
				var width = 900;
				var hinId = document.getElementById("hinId").value;
				var left = (screen.width / 2) - (width / 2);
				var top = (screen.height / 2) - (height / 2);
				window.open("/hms/hms/opd?method=getANCSummary&hinId=" + hinId + "&"
						+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
						"ANC Summary", "scrollbars=no, status = no, height = " + height
								+ ", width =" + width + ",top=" + top + ", left=" + left)
			}
		 
		
	 
		
</script>

<%
	patientDataList.clear();
	storeBrandList.clear();
/* 	templateList.clear(); */
	frequencyList.clear();
	deptList.clear();
	dietList.clear();
%>

