
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.BlPackageServicesDetails"%>
<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.business.RsbyCardDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.WardRemarks"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasMenuType"%>
<%@page import="jkt.hms.masters.business.AmbulanceRegister"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyM"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.PatientHistory"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="jkt.hms.masters.business.MasInstructionMaster"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.FREQUENCY"%>
<%-- <%@page import="jkt.hms.masters.business.AllergyDetail"%> --%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%-- <%@page import="jkt.hms.masters.business.ProcedureDetails"%> --%>
<%-- <%@page import="jkt.hms.masters.business.PhysioRequisitionDetail"%> --%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>

<%-- <%@page import="jkt.hms.masters.business.PatientFamilyHistory"%> --%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%-- <%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.PhysioRequisitionHeader"%> --%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.Set"%>
<%-- <%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%> --%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>



<%-- <%@page import="jkt.hms.masters.business.IpdPatientDiet"%> --%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%-- <%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%> --%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>

  <link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
  <script src="/hms/jsp/js/jquery-1.10.2.js"></script>
  <script src="/hms/jsp/js/jquery-ui.js"></script>
  <script src="/hms/jsp/js/canvasjs.min.js"></script>
  <!-- added by govind 19-9-2016 -->
  <script src="/hms/jsp/js/ipd.js" type="text/javascript"></script>
  <script src="/hms/jsp/js/dischargeMedication.js" type="text/javascript"></script>
  <script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>
  <!-- added by govind 19-9-2016 -->
  <script>jQuery.noConflict();</script>
  
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
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
}
function isNumeric(e)
{
e.value = (e.value.replace(/[^0-9]/g, ''));
}

function checkLength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<form name="ipdCaseSheet" id="ipdCaseSheet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
Map<String, Object> map = new HashMap<String, Object>();
//List inPatientDetailList = new ArrayList();
List nursingCareList = new ArrayList();
List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
List<AmbulanceRegister> ambulanceRegistersList=new ArrayList<AmbulanceRegister>();
List<MasDiet> masDietList = new ArrayList<MasDiet>();
List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<PatientPrescriptionDetails>patientPrescriptionDetailsList=new ArrayList<PatientPrescriptionDetails>();
List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
int patientAge=0;
List<RsbyCardDetails> rsbyCardDetailsList = new ArrayList<RsbyCardDetails>(); // added by Amit Das
List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>(); // added by Amit Das
List<MasScheme> packageSchemeList = new ArrayList<MasScheme>(); // added by Amit Das
List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>(); // added by Amit Das
List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
//List<MasSpecialtyTemplate> specialtyTemplateList = new ArrayList<MasSpecialtyTemplate>(); // added by Amit Das on 22-07-2016
List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 06-09-2016 
List<Object[]> specialtyTemplateList=new ArrayList<Object[]>();
List<Integer> dgOrderList=new ArrayList<Integer>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String) utilMap.get("currentTime");
	List<Object[]>employeeList=new ArrayList<Object[]>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
  	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	// added by Amit Das
	if(map.get("rsbyCardDetailsList")!=null){
		rsbyCardDetailsList=(List<RsbyCardDetails>)map.get("rsbyCardDetailsList");
	}
	
	// added by Amit Das
	if(map.get("packageList")!=null){
		packageList=(List<BlPackageHeader>)map.get("packageList");
	}
	
	// added by Amit Das
		if(map.get("packageSchemeList")!=null){
			packageSchemeList=(List<MasScheme>)map.get("packageSchemeList");
		}
		// added by Amit Das
		if(map.get("packageServicesList")!=null){
			packageServicesList=(List<BlPackageServicesDetails>)map.get("packageServicesList");
		}
		
		// added by Amit Das on 22-07-2016
		if(map.get("specialtyTemplateList")!=null){
			specialtyTemplateList=(List<Object[]>)map.get("specialtyTemplateList");
		}
		
		
		// addded by amit das on 06-09-2016
				if(map.get("patientEpisodeList") != null){
					patientEpisodeList=(List<PatientEpisode>)map.get("patientEpisodeList");
				} 
	
	if(map.get("employeeList")!=null){
		employeeList=(List<Object[]>)map.get("employeeList");
	}
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	if(map.get("patientPrescriptionDetailsList")!=null){
		patientPrescriptionDetailsList=(List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetailsList");
	}
	if(map.get("DgOrderdtList")!=null){
		DgOrderdtList=(List<DgOrderdt>)map.get("DgOrderdtList");
	}
	
	if(map.get("dgOrderList")!=null){
		dgOrderList=(List<Integer>)map.get("dgOrderList");
	}
	
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList") != null)
	{
		//opdDetailsList=(List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	  List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
	if(map.get("wardreamarksList")!=null){
		wardreamarksList=(List<WardRemarks>)map.get("wardreamarksList");
	}
	
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	/* List<MasIcd> masIcdList = new ArrayList<MasIcd>();
	if(map.get("masIcdList") != null){
		masIcdList=(List<MasIcd>)map.get("masIcdList");
	} */
	List<MasDiet> dietTypeList = new ArrayList<MasDiet>();
	if(map.get("dietTypeList") != null){
		dietTypeList =(List<MasDiet>)map.get("dietTypeList");
	}
	List<OpdTemplate>templateList= new ArrayList<OpdTemplate>();
	if(map.get("templateList") != null){
	templateList=(List)map.get("templateList");
	}
	List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	// List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>(); //commented by amit das on 08-11-2016
	List<DgOrderdt> ipdInvestigationList = new ArrayList<DgOrderdt>(); //added by amit das on 08-11-2016
	List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
//	List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
//	List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
	List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
	/* List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>(); */

	if(map.get("ipdPrescriptionList") != null){
		ipdPrescriptionList=(List<PatientPrescriptionHeader>)map.get("ipdPrescriptionList");
	}
	if(map.get("ipdInvestigationList") != null){
		ipdInvestigationList=(List<DgOrderdt>)map.get("ipdInvestigationList");
	}
	if(map.get("ipIcdList") != null){
		ipIcdList=(List<DischargeIcdCode>)map.get("ipIcdList");
	}
	List<IpdVitalSetup>ipdVitalSetupList=new ArrayList<IpdVitalSetup>();
	if(map.get("ipdVitalSetupList")!=null){
	ipdVitalSetupList = (List<IpdVitalSetup>) map.get("ipdVitalSetupList");
	}
/*	if(map.get("ipdProcedureList") != null){
		ipdProcedureList=(List<ProcedureHeader>)map.get("ipdProcedureList");
	}
	if(map.get("ipdPhysiotherapyList") != null){
		ipdPhysiotherapyList=(List<PhysioRequisitionHeader>)map.get("ipdPhysiotherapyList");
	}*/
	/* List<PatientFamilyHistory> familyHistoryList = new ArrayList<PatientFamilyHistory>();
	if(map.get("familyHistoryList") != null){
		familyHistoryList=(List<PatientFamilyHistory>)map.get("familyHistoryList");
	}
	
	if(map.get("ipdPatientDietList") != null){
		ipdPatientDietList=(List)map.get("ipdPatientDietList");
	} */
	
	if(map.get("ipdHistoryDetailsListForFollowUp") != null){
		ipdHistoryDetailsListForFollowUp=(List)map.get("ipdHistoryDetailsListForFollowUp");
	}
	List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
	if(map.get("caseSheetList") != null)
	{
		caseSheetList=(List<OpdPatientDetails>)map.get("caseSheetList");
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
	
	OpdPatientHistory opdPatientHistory = null;
	
	if(ipdHistoryDetailsListForFollowUp.size()>0){
		opdPatientHistory = ipdHistoryDetailsListForFollowUp.get(0);
	}
	
	List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
	List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
	
	if(map.get("allergyProductsList") != null){
		allergyProductsList=(List)map.get("allergyProductsList");
	}
	
	if(map.get("saverityCodesList") != null){
		saverityCodesList=(List)map.get("saverityCodesList");
	} 
	//added for history
	List<OpdPatientDetails>  ipdPatientDetailList = new ArrayList<OpdPatientDetails>();
	 List<OpdPatientHistory>  ipdPatientHistoryList = new ArrayList<OpdPatientHistory>();
	 List<DischargeIcdCode>  ipdDischargeList = new ArrayList<DischargeIcdCode>();
	 if(map.get("ipdPatientDetailList") != null){
		 ipdPatientDetailList=(List<OpdPatientDetails>)map.get("ipdPatientDetailList");
		}
	 if(map.get("ipdPatientHistoryList") != null){
		 ipdPatientHistoryList=(List<OpdPatientHistory>)map.get("ipdPatientHistoryList");
		}
	 if(map.get("ipdDischargeList") != null){
		 ipdDischargeList=(List<DischargeIcdCode>)map.get("ipdDischargeList");
		}
	 List<InpatientPrescriptionHeader>  ipdPatientPrescriptionHeaderList = new ArrayList<InpatientPrescriptionHeader>();

	 if(map.get("ipdPatientPrescriptionHeaderList") != null){
		 ipdPatientPrescriptionHeaderList=(List<InpatientPrescriptionHeader>)map.get("ipdPatientPrescriptionHeaderList");
		}
	 System.out.println("ipdPatientPrescriptionHeaderList jsp "+ipdPatientPrescriptionHeaderList.size());
	/*  List<PatientInvestigationHeader>  ipdPatientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
	 if(map.get("ipdPatientInvestigationHeaderList") != null){
		 ipdPatientInvestigationHeaderList=(List<PatientInvestigationHeader>)map.get("ipdPatientInvestigationHeaderList");
		} */
		
		List<DgOrderhd>  ipdPatientInvestigationHeaderList = new ArrayList<DgOrderhd>();
		 if(map.get("ipdPatientInvestigationHeaderList") != null){
			 ipdPatientInvestigationHeaderList=(List<DgOrderhd>)map.get("ipdPatientInvestigationHeaderList");
			}
	 
	 List<OpdSurgeryHeader>  ipdOpdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
	 if(map.get("ipdOpdSurgeryHeaderList") != null){
		 ipdOpdSurgeryHeaderList=(List<OpdSurgeryHeader>)map.get("ipdOpdSurgeryHeaderList");
		}
	 
	 List<OpdPatientAllergyM>  ipdOpdPatientAllergyMList = new ArrayList<OpdPatientAllergyM>();
	 if(map.get("ipdOpdPatientAllergyMList") != null){
		 ipdOpdPatientAllergyMList=(List<OpdPatientAllergyM>)map.get("ipdOpdPatientAllergyMList");
		}
	
	/*  if(map.get("inPatientDetailList") != null){
	 inPatientDetailList = (List) map.get("inPatientDetailList");
	 } */
	 if(map.get("nursingCareList") != null){
		nursingCareList = (List) map.get("nursingCareList");
	 }
	 if(map.get("nursingCareSetupList") != null){
		nursingCareSetupList = (List<NursingcareSetup>) map.get("nursingCareSetupList");
	 }
	 
	 if(map.get("ambulanceRegistersList") != null){
		 ambulanceRegistersList = (List<AmbulanceRegister>) map.get("ambulanceRegistersList");
		 }
	 
	 if(map.get("masDietList") != null){
			masDietList= (List<MasDiet>)map.get("masDietList");
		}
		if(map.get("masMenuTypeList") != null){
			masMenuTypeList= (List<MasMenuType>)map.get("masMenuTypeList");
		}
		if(map.get("departmentList") != null){
			departmentList= (List<MasDepartment>)map.get("departmentList");
		}
		if(map.get("expiryDetailsList") != null){
			expiryDetailsList= (List<ExpiryDetails>)map.get("expiryDetailsList");
		}

		List<String> vitalList = new ArrayList<String>();
		vitalList.add("Temperature");
		vitalList.add("Pulse");
		vitalList.add("Respiration");
		vitalList.add("BP");
		vitalList.add("Bowl");
		vitalList.add("Pain");
		vitalList.add("Girth");
		vitalList.add("Blood Sugar");
		vitalList.add("Insulin");

	Patient patient = new Patient();
	Inpatient inpatient = new Inpatient();
	String patientName ="";
	String servPersonName ="";
	String consultantName = "";
	String currentAge = "";
	String gender="-";
	String display="none";
	String pCategory="";
	String bloodGroup="";
	String materialStatus="";
	String admittedBy="-";
	int currAge = 0;
	String ageunit ="";
	String motherHinNo = "";
	int motherInpatientId=0;
	int inpatientId=0;
	String mlcType = "";
	int preagnancyPeriod=0;
	OpdPatientDetails opdDetails=null;
	String readyToDischarge=null;
	int visitId = 0;
	if(inpatientList.size() >0){
		inpatient = inpatientList.get(0);
		patient = inpatient.getHin();
		inpatientId=inpatient.getId();
		opdDetails=inpatient.getOpdPatientDetails()!=null?inpatient.getOpdPatientDetails():null;
		
		if(null !=opdDetails && null !=opdDetails.getPragnancyPeriod()){
			preagnancyPeriod=opdDetails.getPragnancyPeriod();
		}
		if(opdDetails != null && opdDetails.getVisit() != null){
			visitId = opdDetails.getVisit().getId();
		} 
		
		//System.out.println("motherHinNo=11="+inpatient.getMotherAdNo());
		//System.out.println("id=11="+inpatient.getId());
		
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
		servPersonName =(patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"");
		consultantName=inpatient.getDoctor().getRank()!=null?inpatient.getDoctor().getRank().getRankName():""+" "+ inpatient.getDoctor().getEmployeeName();	
		if(inpatient.getHin().getDateOfBirth()!=null){
			currentAge = HMSUtil.calculateAge(inpatient.getHin().getDateOfBirth());
			currAge = Integer.parseInt(currentAge.substring(0, 2).trim());
			ageunit = currentAge.substring(currentAge.indexOf(" "));
		}
		
		if(inpatient.getDoctor()!=null)
		{
			admittedBy=inpatient.getDoctor().getFirstName();
			if(inpatient.getDoctor().getMiddleName()!=null)
			{
				admittedBy +=" "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName()!=null)
			{
				admittedBy +=" "+inpatient.getDoctor().getLastName();
			}
		}
		String age = "";
		
		if(inpatient.getHin().getSex()!=null)
		{
			gender=inpatient.getHin().getSex().getAdministrativeSexName();
			if(inpatient.getHin().getSex().getAdministrativeSexCode().equals("F"))
			{	
				display="block";
			}
		}		
		
		if(inpatient.getHin().getMaritalStatus()!=null)
		{
			materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
		}else
		{
			materialStatus="-";
		}
		
		if(inpatient.getHin().getBloodGroup()!=null){
			bloodGroup = inpatient.getHin().getBloodGroup().getBloodGroupName();
		}
		else
		{
			bloodGroup="-";
		}
		
		if(inpatient.getHin().getPatientType()!=null){
			pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
		}
		else
		{
			pCategory="-";
		}
		if(inpatient.getMlc()!= null){
			mlcType = (String)inpatient.getMlc();
		}
		

	    if(patient.getAge()!=null){
			age = patient.getAge();
	    }
	    
	    if(age.length()>0){
	    patientAge=Integer.parseInt(age.split(" ")[0]);
	    }
		try{
			if(!age.equals("")){
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(map.get("motherHinNo") != null){
			motherHinNo = (String)map.get("motherHinNo");
		}else{
			motherHinNo = inpatient.getHin().getMotherHinNo()!=null?inpatient.getHin().getMotherHinNo():"";
		}
		if(map.get("motherInpatientId") != null){
			motherInpatientId = (Integer)map.get("motherInpatientId");
		}
		
		if(inpatient.getAdStatus()!=null){
			readyToDischarge=inpatient.getAdStatus();
		}
		session.setAttribute("inpatient",inpatient);
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
	
	//added by govind 20-10-2016
			String injStatus ="";
		if(map.get("injStatus") != null)
		{
			injStatus=(String)map.get("injStatus");
		}
		
		List<InjAppointmentDetails> injAppointmentDetailsList=new ArrayList<InjAppointmentDetails>();
		if(map.get("injAppointmentDetailsList")!=null){
			injAppointmentDetailsList=(List<InjAppointmentDetails>)map.get("injAppointmentDetailsList");
		}
		//added by govind 20-10-2016
	/* Calendar now = Calendar.getInstance();
 	Calendar cal = Calendar.getInstance();
	cal.setTime(inpatient.getDateOfAddmission());

	
	int currentDays = now.get(Calendar.DATE);
	int regDays = cal.get(Calendar.DATE);
	
	int currentMonth = now.get(Calendar.MONTH) + 1;
	int regMonth = cal.get(Calendar.MONTH) + 1;
	
	int currentYear = now.get(Calendar.YEAR);
	int regYear = cal.get(Calendar.YEAR);
	
	int calculatedDays=0;
	int calculatedMonth=0;
	int calculatedYear=0;
	
	if (currentDays < regDays) {
		currentDays = currentDays + 30;
		calculatedDays = currentDays - regDays;
		currentMonth = currentMonth - 1;
	} else {
		calculatedDays = (currentDays - regDays);
	}
	
	if (currentMonth < regMonth) {
		currentMonth = currentMonth + 12;
		calculatedMonth = currentMonth - regMonth;
		currentYear = currentYear - 1;
	} else {
		calculatedMonth = currentMonth - regMonth;
	}

	calculatedYear = currentYear - regYear;	
	
	Date d1= inpatient.getDateOfAddmission(); 
	Date d2= new Date();
	long t1 = d1.getTime();
	long  t2 = d2.getTime();
	long day = 1000 * 60 * 60 * 24; // milliseconds in a day
	long totalOfDays =  (t2 - t1) / day;*/	
	
	//added by govind 6-10-2016
		String diagnose ="",icCode="",icdVal="",icName="";
		if(map.get("diagnose") != null)
		{
			diagnose=(String)map.get("diagnose");
		}
		if(map.get("icCode") != null)
		{
			icCode=(String)map.get("icCode");
			icCode="["+icCode+"]";
		}
		if(map.get("icName") != null)
		{
			icName=(String)map.get("icName");
		}
		if(map.get("icdVal") != null)
		{
			icdVal=(String)map.get("icdVal");
		}
		//added by govind 6-10-2016 end
		String orderNo="";
		int OrderId=0;
		if(map.get("orderNo")!=null)
	    {
			orderNo = (String)map.get("orderNo");
	    } 
		if(map.get("OrderId")!=null)
	    {
			OrderId = (Integer)map.get("OrderId");
	    }
	
%>

<div class="titleBg"><h2>Case Sheet</h2></div>

<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>
<%@include file="PatientDetails.jsp" %>
<div class="clear"></div>


<label>Allergy</label>
<textarea class="comorBiditylarge"  readonly="readonly" cols="0" rows="0"  maxlength="300"><%=allergyStr %></textarea>

<label>Comorbidity</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" validate="comorbidity,string,no" readonly="readonly" cols="0" rows="0"  maxlength="300"  onkeyup="return checkLength(this)"><%=comorbidityStr %></textarea>

<div class="clear"></div>
</div>
<% if(rsbyCardDetailsList!=null && rsbyCardDetailsList.size()!=0) {
	  RsbyCardDetails rsbyCardDetails = rsbyCardDetailsList.get(0);
 	%>
<h4>Package Details</h4>
<div class="clear"></div>
<div class="Block">	
 	<script type="text/javascript">
 		<% int count3=0;
 			for(RsbyCardDetails cardDetails : rsbyCardDetailsList){
 		%>
 		rsbyCardArray[<%=count3%>] = new Array();
 		rsbyCardArray[<%=count3%>][0] = <%=cardDetails.getPkgScheme().getId()%>;
 		rsbyCardArray[<%=count3%>][1] = <%=cardDetails.getRsbyCardNo()%>;
 		rsbyCardArray[<%=count3%>][2] = "<%=cardDetails.getBalanceUtilized()%>";
 		rsbyCardArray[<%=count3%>][3] = "<%=(cardDetails.getPkgScheme().getAmountLimit()!=null)?cardDetails.getPkgScheme().getAmountLimit():0%>";
 		<% count3++;
 		} %>
 	</script>
 	
 	<label>Package Scheme</label>
 	<select id="pkgSchemeId" name="pkgSchemeId" onchange="loadRelatedPackages(this.value,'ipdCaseSheet');loadBalanceUtlizied(this.value,'ipdCaseSheet');">
 		<option value="0">Select</option>
 		<% for(MasScheme masScheme : packageSchemeList){ %>
 		<option value="<%=masScheme.getId()%>"><%=masScheme.getSchemeName()%></option>
 		<% } %>
 	</select>
 	  <script type="text/javascript">
      <%
			int countScheme = 0;
			for (MasScheme masScheme : packageSchemeList) 
			{
				%>
				schemePkgArray[<%=countScheme%>] = new Array();
				schemePkgArray[<%=countScheme%>][0] = <%=masScheme.getId()%>;
				schemePkgArray[<%=countScheme%>][1] = <%=(masScheme.getAmountLimit()!=null)?masScheme.getAmountLimit():0%>;																
				<%
				countScheme++;
			} %>
		</script> 
	<%-- <% for(RsbyCardDetails cardDetails : rsbyCardDetailsList){ %>
 		<input type="hidden" name="balanceUtilized<%=cardDetails.getPkgScheme().getId()%>" id="balanceUtilized<%=cardDetails.getPkgScheme().getId()%>" value="<%=cardDetails.getBalanceUtilized()%>" >
 	<% } %>	 --%>
 	
 	<input type="hidden" name="rsbyCardNo" id="rsbyCardNo" value="<%=rsbyCardDetails.getRsbyCardNo()%>" >
 	
 	
 	
 	<label>Package</label>
 	<select id="pkgHeaderId" name="pkgHeaderId" onchange="loadRelatedPackageServices(this.value,'ipdCaseSheet');">
 		<option value="0">Select</option>
 		<% for(BlPackageHeader blPackageHeader : packageList){ %>
 		<option value="<%=blPackageHeader.getId()%>"><%=blPackageHeader.getPackageDesc()%></option>
 		<% } %>
 	</select>
 	<input type="hidden" value="" name="pkgCharge" id="pkgCharge">
 	<input type="hidden" value="" name="pkgId" id="pkgId">
 	<input type="hidden" value="" name="pkgScheme" id="pkgScheme">
 	
 	 <script type="text/javascript">
      <%
			int count1 = 0;
			for (BlPackageHeader blPackageHeader : packageList) 
			{
				%>
				pkgArray[<%=count1%>] = new Array();
				pkgArray[<%=count1%>][0] = <%=blPackageHeader.getScheme().getId()%>;
				pkgArray[<%=count1%>][1] = <%=blPackageHeader.getId()%>;
				pkgArray[<%=count1%>][2] = "<%=blPackageHeader.getPackageDesc()%>";
				pkgArray[<%=count1%>][3] = <%=blPackageHeader.getTotalValueOfPackage()%>;
				<%
				count1++;
			} %>
		</script>
		
 	<input type="button" class="buttonBig" id="packageSelector" value="Select Package" align="right" onclick="javascript:togglePackage();">
<div class="clear"></div>
<% if(rsbyCardDetailsList !=null && rsbyCardDetailsList.size()>0 ) {%>
<label id="balanceLabel">Balance Utilzied</label>
<% for(RsbyCardDetails cardDetails : rsbyCardDetailsList){ %>
		<input type="text" style="display: none;" readonly="readonly" name="balanceUtilized<%=cardDetails.getPkgScheme().getId()%>" id="balanceUtilized<%=cardDetails.getPkgScheme().getId()%>" value="<%=cardDetails.getBalanceUtilized()%>" >
<% } } %>	
<label>Scheme Limit</label>
		<input type="text" readonly="readonly" name="schemeLimit" id="schemeLimit" value="" >
</div>
<% } %>
<div class="clear"></div>
 <h4 style="text-align:left; display: <%=display%>;">Physiological Status</h4>

     <div class="Block" style="display: <%=display%>" >
      <label><input type="checkbox" name="preganancy" value="y"style="padding:0px;margin: 0px;" <%=opdDetails!=null && opdDetails.getPregnancy()!=null && opdDetails.getPregnancy().equalsIgnoreCase("y")?"checked='checked'":"" %> id="preganancy"   class="radioCheck">&nbsp; Pregnancy</label>
	 <!--  <label>Period<input type="checkbox"  name="Period" id="Period" style="padding:0px;margin: 0px;"   class="radioCheck" value="" />
	 </label>
	  -->
	  
	  <%-- 	  Added By dhananjay 14-11-2016
 --%>
<label class="medium">Period</label>
<input type="text" class="dateTextSmall" placeholder="Period in week" value="<%=preagnancyPeriod%>" id="period" name="period">
<label class="smallAuto">in week</label> 
		 <%-- 	  End--%>				

<label><input type="checkbox" value="y" name="lactation" id="lactation" style="padding:0px;margin: 0px;" <%=opdDetails!=null && opdDetails.getLactation()!=null && opdDetails.getLactation().equalsIgnoreCase("y")?"checked='checked'":"" %>  class="radioCheck" >&nbsp; lactation</label>

<label>Remarks</label><textarea name="remarks" id="remarks" class="textareaMediua" validate="remarks,string,no" cols="0" rows="0"  maxlength="300" tabindex="1" onkeyup="return checkLength(this)"><%=opdDetails!=null && opdDetails.getPhysiologicalStatusRemarks()!=null?opdDetails.getPhysiologicalStatusRemarks():"" %></textarea>
</div>

<div class="clear"></div>
<div class="newWndPopUp">
<input type="button" value="View Intake Output" onClick="submitForm('ipdCaseSheet','ipd?method=showIntakeOutputChartReport&reportType=summary','validatePatient');"	/>
<input	name="investigationTemplate" type="button" value="ViewClinical Assist"	onclick="showDiagnosis()" tabindex="1" />  
<input	name="viewvitalDetail" type="button" value="View Vital Detail"	onclick="showVaitalDetail()" tabindex="1" />

<!-- left arrowlistmenu change into buttons add herer -->
<input	name="" type="button" value="Previous Visits & Hospitalizations" href="#"
onclick="openWindow('/hms/hms/ipd?method=showPatientDetails&hinId=<%=patient.getId() %>&hinNo=<%=patient.getHinNo() %>&backFlag=ipd')" tabindex="1"/>  

<a href="javascript:popwindowUploadDocuments('<%=patient.getId()%>@@@<%=inpatient.getId()%>');">
<input	name="" type="button" value="Upload Document" tabindex="1" /></a>
<a href="javascript:openPopupWindow();"><input name="" type="button" value="Allergy" tabindex="1" /></a>
<a href="javascript:popwindowResultEntry('<%=patient.getId()%>@@@<%=inpatient.getId()%>');">
<input name="" type="button" value="Result Entry" tabindex="1" /></a>

<%if(patientAge<=18){%>
<a href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&inpatientId=<%=inpatient.getId()%>');">
<input name="" type="button" value="Immunization" tabindex="1" /></a>
				<%}else{%>
				<!-- <a href=""><input name="" type="button" value="Immunization" tabindex="1" /></a> -->				
				<%}%>

<a href="javascript:openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>');">
<input name="" type="button" value="Lab Results" tabindex="1" /></a>

</div>

 
 
<div class="clear"></div>
<input id="gender" name="gender" type="hidden"	value="<%=gender%>" />
<input id="visitId" name="visitId" id="visitId" type="hidden" value="<%=visitId%>" />
<input id="hinId" name="hinId" type="hidden"	value="<%=patient.getId()%>" />
<input name="motherHinNo" id="motherHinNo" type="hidden"	value="<%=patient.getMotherHinNo()%>" />
<input id="inpatientId"  name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
<input name="adNo" type="hidden"	value="<%=inpatient.getAdNo()%>" />
<input name="hinNo" type="hidden"	value="<%=patient.getHinNo()%>" />
<input name="serviceNo" type="hidden"	value="<%=patient.getServiceNo()!=null?patient.getServiceNo():"" %>" /> 
 <input name="request" id="requestId" type="hidden"	value="<%=patient.getId()%>" />
 <input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge != 0?patientAge:"" %>" />

 <%
String serviceNo = patient.getServiceNo()!=null?patient.getServiceNo():"";
int hinId= patient.getId();
%>
<!-- display none by aanand 18-06-18 -->
<div class="arrowlistmenu" style="width:150px; margin:0px; display:none">

<ul class="categoryitems">

<li><a href="#" onclick="openWindow('/hms/hms/ipd?method=showPatientDetails&hinId=<%=patient.getId() %>&hinNo=<%=patient.getHinNo() %>&backFlag=ipd')">
	Previous Visits <br/>& Hospitalizations </a></li>
	<li><a href="javascript:popwindowUploadDocuments('<%=patient.getId()%>@@@<%=inpatient.getId()%>');">Upload Document</a></li>
     <li><a href="javascript:openPopupWindow();">Allergy</a></li>
     <li><a href="javascript:popwindowResultEntry('<%=patient.getId()%>@@@<%=inpatient.getId()%>');">Result Entry</a></li>
     <%if(patientAge<=18){%>
				<li><a
					href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&inpatientId=<%=inpatient.getId()%>');">Immunization</a></li>
				<%}else{%>
				<!-- <li><a href="">Immunization</a></li> -->
				<%}%>
				
				
				
				
				<!-- <li><a  href="#" onclick="display('','General Surgry');displaySpecialty('General Surgry');">General Surgry</a></li>
				<li><a  href="#" onclick="display('','Neonatal');displaySpecialty('Neonatal');">Neonatal</a></li> -->
				<li><a href="javascript:openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>');">Lab Results</a></li><!-- added by govind 23-01-2017 -->
				
				<%
					
				for(Object[] mstp:specialtyTemplateList){ 
					
					%>
			<%if(mstp[0] != null){ %>	
				<ul class="primary-items">    
			<li><a rel="country8" href="#" onclick="display('<%=mstp[0] %>','<%=mstp[1] %>','IP');displaySpecialty('<%=mstp[1]%>');"><%=mstp[1] %></a></li>
			
			
			<%}} %>	
     
	<%-- <li><a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForViewScreen&hinId=<%=hinId %>&backFlag=ipd')">
	Previous Visits </a></li> --%>

	<%-- <li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedExamFromHIC&serviceNo=<%=serviceNo %>&hinId=<%=hinId %>&backFlag=ipd')">
	Previous Medical Exams </a>
	
	</li>
	
	<li>
	<a href="#" onclick="openWindow('/hms/hms/medicalExam?method=getPrevMedBoardFromHIC&hinId=<%=hinId %>&serviceNo=<%=serviceNo %>&backFlag=ipd')">
	Previous Medical Boards</a>
	</li> --%>
	
	<!-- <li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&hinId=&backFlag=ipd')">
    Previous Hospitalizations</a>
	</li> -->
	
	<%-- <li>
	<a href="#" onclick="openWindow('/hms/hms/opd?method=showPatientPreviousVisitForHospitality&hinId=<%=hinId %>&backFlag=ipd')">
    Previous Hospitalizations</a>
	</li> --%>
	
	
	<!--

	<li>
	 <a href="#" onclick="javascript:openPopupPrescriptions(,,,)">
	Previous Prescriptions</a>
	</li>
	<li>
	<a
		href="#" onclick="javascript:openPopupInvestigation(,,,)">
		Previous Investigations</a></li> 
		
--></ul>
<input name="splName" id="splName" type="hidden" value="" />
<script type="text/javascript">
function openWindow(url){

    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=1010,status=1,scrollbars=1,resizable=0");
	
}
</script>
</div>
<div class="opdArea">
<div class="clear"></div>		
<ul id="countrytabs" class="shadetabs">
           <li><a href="javascript:void(0);" rel="country1" onclick="checkTab(1);" >Case Notes/Diagnosis</a></li>
           <li ><a href="javascript:void(0);" rel="country2" >Treatments</a></li>
           <li><a href="javascript:void(0);" rel="country3">Investigations</a></li>
           <li><a href="javascript:void(0);" rel="country4">Procedure</a></li>
           <li><a href="javascript:void(0);" rel="country5">Allergy</a></li>
<!--            <li><a href="javascript:void(0);" rel="country7">Comorbidity</a></li>
 --><%--       <li onclick="submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/ipd?method=getPrevPhysiotherapyDetails&parent=<%=inpatient.getId() %>&hinId=<%=inpatient.getHin().getId() %>','prevTherapyDiv');"><a href="#" rel="country5">Physiotherapy</a></li>
 --%>          
 
  <li><a href="javascript:void(0);" rel="country6">Diet Details</a></li>
	<li><a href="javascript:void(0);" rel="country8">Remarks From Other Doctors</a></li>
 <li><a href="javascript:void(0);" rel="country10">Speciality</a></li> 
 <li><a href="javascript:void(0);" rel="country12">Clinical Summary</a></li> 
 <li><a href="javascript:void(0);" rel="country11" style="display: none;" id="dischargeLink">Discharge Medication</a></li>
	<%if(mlcType != null){
	if(mlcType.equalsIgnoreCase("y")){
	%>
	 <li id="mlcTab"><a href="javascript:void(0);" rel="country9">MLC</a></li> 
	<%}else{ %>
	 <li id="mlcTab" style="display:none;"><a href="javascript:void(0);" rel="country9">MLC</a></li> 
	 <%}}else{ %>
	 <li id="mlcTab" style="display:none;"><a href="javascript:void(0);" rel="country9">MLC</a></li> 
	 <%} %>
	
	
	</ul>
<!-- First Tab End -->

<div id="country1" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="auto">Date & Time</label>
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.diagnosisdate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<input  id="diagnosisdate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="diagnosisdate">
<input type="text" class="date" name="diagnosistime" value="<%=time.substring(0,5)%>"  validate="Diagnosis Time,String,yes" id="diagnosistime" onblur="checkTime('ipdCaseSheet','diagnosistime');"/>

<div class="floatRight">
<%if(mlcType != null){
	if(mlcType.equalsIgnoreCase("y")){
	%>
  <label class="auto">MLC</label><input type="checkbox" id="mlcCheck" checked="checked" name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()" style="margin:1px 10px 0 0;"/>
  <%}else{ %>
   <label class="auto">MLC</label><input type="checkbox" id="mlcCheck"  name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()" style="margin:1px 10px 0 0;"/>
  <%}}else{ %>
  <label class="auto">MLC</label><input type="checkbox" id="mlcCheck"  name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()" style="margin:1px 10px 0 0;"/>
  <%} %>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>Patient Episode Details</label>	

<label>Select Past Episode
<input type="radio" name="episodeCheck" id="episodeIdPast" onclick="showPastEpisodeDiv();" class="episodeSelect" title="Select Past Episode">
</label>			
<label>Create New Episode
<input type="radio" name="episodeCheck" id="episodeIdNew" checked="checked" class="episodeSelect"  onclick="hidePastEpisodeDiv();">
</label>		

<!-- <input type="radio" name="episodeCheck" id="episodeIdPast" onclick="showPastEpisodeDiv();" class="episodeSelect" title="Select Past Episode">
<div class="episodelabel">Select Past Episode</div>
<input type="radio" name="episodeCheck" id="episodeIdNew" checked="checked" class="episodeSelect"  onclick="hidePastEpisodeDiv();">
<div class="episodelabel">Create New Episode</div> -->

<div class="Block" style="display: none;" id="pastEpisodeDiv"> 
<label>Past Episodes</label>
<select name="episodeList"	id="episodeList" size="1" onchange="getEpisodeDetail(this,'inpatient');">
<option value="0">Select</option>
<% for(PatientEpisode patientEpisode : patientEpisodeList) { %>
<%if(patientEpisode.getEpisodeName()!=null){ %>
<option value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)<%=patientEpisode.getEpisodeName()%></option>
<% }else{ %>
<option value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)</option>
<% } %>
<% } %>
</select>
</div>				
					 
					 <div class="Block" id="EpisodeNameDiv">
						 <label>Episode Name</label>
					 	<input name="episodeName" id="episodeName" type="text" value="">
					 </div>
<label>Close Episode
<input type="checkbox" id="episodeCloseCheck" name="episodeCloseCheck" class="episodeSelect" value="true" >
</label>
					 
<!-- <input type="checkbox" id="episodeCloseCheck" name="episodeCloseCheck" class="episodeSelect" value="true" >
<div class="episodelabel">Close Episode</div> -->
					 	
					 <div class="clear"></div>
					  <div id="patientEpisodeDetail">
					 </div>
					<div class="clear"></div>
					<input type="hidden" id="episodeId" name="episodeId" value="0"> 
					
					
<%--
<%
OpdPatientDetails prevPatientDetails =new OpdPatientDetails();
if(caseSheetList.size() > 0){
	prevPatientDetails = caseSheetList.get(0); // For getting latest case notes
}

%>--%>
<div class="clear"></div>

<div class="Block">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;" >History</h6>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<label class="heightAuto">Present Complaint & History</label>
<textarea name="presentComplain" id="presentComplain" 
validate="Present Complaint,string,no" cols="0" rows="0"  
maxlength="300" tabindex="1" onkeyup="return checkLength(this)">
<%=ipdHistoryDetailsListForFollowUp.size()>0?(ipdHistoryDetailsListForFollowUp.get(0).getPresentComplaintHistory()!=null?ipdHistoryDetailsListForFollowUp.get(0).getPresentComplaintHistory():""):"" %>
</textarea>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getPresentTemplate();"  />
 
<label>History of Past Illness</label>
 <textarea name="pastIllness" id="pastIllness" cols="0"
	rows="0" maxlength="300" tabindex="1" validate="History Of Past Illness,string,no" onkeyup="return checkLength(this)">
	<%=ipdHistoryDetailsListForFollowUp.size()>0?(ipdHistoryDetailsListForFollowUp.get(0).getPastIllnessHistory()!=null?ipdHistoryDetailsListForFollowUp.get(0).getPastIllnessHistory():""):"" %>
	
	</textarea>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getHistoryOfPastIllnessTemplate();"  />
<div class="clear"></div>
<label>Personal History</label>
<textarea name="personalHistory" id="personalHistory" tabindex="1" cols="0"	rows="0" maxlength="500" onkeyup="return checkLength(this)" validate="Personal History,string,no" >
<%=ipdHistoryDetailsListForFollowUp.size()>0?(ipdHistoryDetailsListForFollowUp.get(0).getPersonalPresentHistory()!=null?ipdHistoryDetailsListForFollowUp.get(0).getPersonalPresentHistory():""):"" %>
</textarea>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getPersonalHistoryTemplate();"  />
<label>Family History</label>
 <textarea name="familyHistory" validate="Family History,string,no" id="familyHistory" cols="0"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)">
	<%=ipdHistoryDetailsListForFollowUp.size()>0?(ipdHistoryDetailsListForFollowUp.get(0).getFamilyPastHistory()!=null?ipdHistoryDetailsListForFollowUp.get(0).getFamilyPastHistory():""):"" %>
	</textarea>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getFamilyHistoryTemplate()"  />
<div class="clear"></div>
<label>Medication History</label> 
<textarea name="medicationhistory" validate="Medication  History,string,no" id="medicationhistory" cols="0"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)">
	<%=ipdHistoryDetailsListForFollowUp.size()>0?(ipdHistoryDetailsListForFollowUp.get(0).getMadicationHistory()!=null?ipdHistoryDetailsListForFollowUp.get(0).getMadicationHistory():""):"" %>
	</textarea>
	<input type="button" class="buttonSm" id="" name="" value="---" onclick="getMedicationHistoryTemplate();"  />
<div class="clear"></div>
</div>
</div>
</div>

<div class="Block">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;" >Examination</h6>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<label class="auto">Pulse</label>
 <input id="pulse" name="pulse" validate="pulse,num,no" type="text" class="textSmall" tabindex="1" value="<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getPulse()!=0?opdDetailsList.get(0).getPulse():""):"" %>" class="smallest" size="5" tabindex="1"  maxlength="3" />
<label	class="smallAuto">min</label>
<div class="paddLeft55"></div>
<label class="auto">Temperature</label> 
 <input  name="temperature" id="tempId" validate="temperature,float,no" class="textSmall" type="text" tabindex="1" value="<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getTemperature()!=0?opdDetailsList.get(0).getTemperature():""):"" %>" class="smallest" size="5" maxlength="5" />
<label	class="smallAuto">&deg;F</label>
<%

String systolic1="";
String diastolic1="";
if(opdDetailsList.size()>0)
{
	String bp=opdDetailsList.get(0).getBp();
	if(bp!=null && !bp.equals("")&& bp.indexOf("/")!=-1)
	{
		systolic1=bp.substring(0,bp.indexOf("/"));
		diastolic1=bp.substring(bp.indexOf("/")+1, bp.length());
				
	}
}
%>

<label class="auto" id="bpLabel">BP</label>
<input  name="systolic" id="systolic" validate="systolic,int,no" placeholder="Systolic" value="<%=systolic1 %>"    type="text" onblur=""	maxlength="3" class="textSmall"  />
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input  name="diastolic" id="diastolic" validate="diastolic,int,no"  placeholder="Diastolic" value="<%=diastolic1 %>" type="text" onblur=""	maxlength="3" class="textSmall" />
<label class="smallAuto autoSpace">mm&nbsp;Hg</label>

<label class="auto">Weight</label>
<input name="weight" tabindex="1"  validate="weight,int,no" type="text" id="weight" class="textSmall" value="<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getWeight()!=null?(opdDetailsList.get(0).getWeight()!=0?opdDetailsList.get(0).getWeight():""):""):"" %>"  onblur="calculateBMI()" class="smallest" size="5"  maxlength="3" />
<label	class="smallAuto">Kg</label>

<label class="auto">Height</label>
<input name="height" tabindex="1" validate="height,int,no" type="text" id="height" class="textSmall" value="<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getHeight()!=null?(opdDetailsList.get(0).getHeight()!=0?opdDetailsList.get(0).getHeight():""):""):"" %>" class="smallest" onblur="calculateBMI();" size="5"   maxlength="3" />
<label	class="smallAuto">cm</label>

<label class="auto" id="bpLabel">BMI</label>
<input tabindex="1" type="text" id="bmi" name="bmi" class="textSmall"  maxlength="6" value="<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getBmi()!=null?(opdDetailsList.get(0).getBmi()!=0?opdDetailsList.get(0).getBmi():""):""):""%>" onKeyUp="" class="smallest" size="5" />
<input type="text" readonly="readonly" tabindex="11" style="width:150px;" id="bmicat" name="bmicat">

<input type="button" class="buttonAuto sizeFont" id="vitalTrends" value="Vital Trends" />

<div class="clear"></div>
<label>General Examination</label>
<select  class="listBig" name="generalExamination1" id="generalExamination1" tabindex="11" style="width:286px;" multiple="4" size="5" ondblclick="onGeneralExaminationDblClick();"></select>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getGeneralExaminationTemplate();" style="margin:2px 5px 0px 0px" />
<textarea class="medium" name="generalExaminationOPC" id="generalExaminationOPC" validate="General Examination,string,no" cols="0" rows="0"  maxlength="300" tabindex="12" ></textarea>

<div class="clear"></div>
<div class="sysExmLeftDiv">
<label>Systemic Examination</label>
<label class="autoSpace"><input type="checkbox" class="radioCheckCol2" id="nad" onclick="putSystemicExamiantionText('nad','All System NAD');" checked="checked"   tabindex="13"/>All System NAD</label>
<label class="autoSpace"><input type="checkbox" class="radioCheckCol2" id="cvs" onclick="putSystemicExamiantionText('cvs','CVS');" disabled="disabled" tabindex="14"/>CVS</label>
<label class="autoSpace"><input type="checkbox" class="radioCheckCol2" id="cns" onclick="putSystemicExamiantionText('cns','CNS');" disabled="disabled" tabindex="15"/>CNS</label>
<label class="autoSpace"><input type="checkbox" class="radioCheckCol2" id="rs"  onclick="putSystemicExamiantionText('rs','RS');"   disabled="disabled" tabindex="16"/>RS</label>
<label class="autoSpace"><input type="checkbox" class="radioCheckCol2" id="grs" onclick="putSystemicExamiantionText('grs','GIS');" disabled="disabled" tabindex="17"/>GIS</label>
<div class="clear"></div>
<div class="paddLeftP100">
<textarea class="medium" cols="0" id="systemicExamination" name="systemicExamination" validate="systemicExamination,string,no" rows="0" maxlength="500"  tabindex="18">All System NAD</textarea>
<label class="auto">Other</label>
<input type="button" class="buttonSm" id="" name="" value="---" onclick="getSystemicExaminationTemplate();" tabindex="19" />
</div>
</div>

<label>Local Examination</label>
<textarea class="medium wdthLrg" style="height:74px;" validate="Family History,string,no" id="localExamination" cols="0" rows="0" maxlength="500" tabindex="20" onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>
<label class="heightAuto">Outside Investigation Details</label> 
<textarea name="outinvestigation" validate="Outside iNvestigation,string,no" id="outinvestigation" cols="0"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)" style="margin:0px"></textarea>

<label class="heightAuto">Outside Investigation Imaging Details</label> 
<textarea name="outinvestigationImage" validate="Outside Investigation Image,string,no" id="outinvestigationImage" cols="0"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)" style="margin:0px"></textarea>
	<div class="clear"></div>
<!-- <div class="clear"></div>
<label class="auto">General Examination&nbsp;&nbsp;&nbsp;</label>
<select class="listBig" name="systemicExamination" id="systemicExamination" tabindex="1" multiple="4" size="5" ></select>
<input type="button" class="buttonSm" id="" name="" value="-----" onclick="getGeneralExaminationTemplate();"  />

<label class="auto">Local Examination</label>
<select class="listBig" name="localExamination" id="localExamination"  tabindex="1" multiple="4" size="5" ></select>

<input type="button" class="buttonSm" id="" name="" value="-----" onclick="getLocalExaminationTemplate();"  />
<div class="clear"></div>


<label class="auto">Systemic Examination</label>
<select class="listBig"  tabindex="1" multiple="4" size="5" ></select>
<input type="button" class="buttonSm" id="systemicExamination" name="" value="-----" onclick="getSystemicExaminationTemplate();"  />
<div class="clear"></div> -->
</div>
</div>
</div>

<div class="Block">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;" >Diagnosis</h6>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>

<%-- <input	type="hidden" id="systamicExam" class="large" name="systamicExam"	maxlength="200" />
<label>Diagnosis</label>
<input 	name="systemDiagnosis" value="<%=prevPatientDetails.getSystemDiagnosis()!=null?prevPatientDetails.getSystemDiagnosis().getSystemDiagnosisName()+"["+prevPatientDetails.getSystemDiagnosis().getId()+"]":"" %>"	id="systemDiagnosis" tabindex="1" class="large"  size="119" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('systemDiagnosis','ac2update','opd?method=autoCompleteForSystemDiagnosis',{parameters:'requiredField=systemDiagnosis'});
</script>
		
<div class="clear"></div>

<label>ICD Code</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="large"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
<div class="clear"></div>
<div class="paddLeft35" style="padding-left:5px">
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1"  id="diagnosisId" class="listBig">
	<option value="0">Select</option>
	 <%
		if(ipIcdList.size()>0){
			for(DischargeIcdCode icdCode : ipIcdList){
	%>
	<option value="<%=icdCode.getIcd().getIcdCode() %>" selected="selected"><%=icdCode.getIcd().getIcdName()+"["+icdCode.getIcd().getIcdCode()+"]" %></option>
	<%}
			}%>
</select>
</div>
<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<div class="clear"></div>
<label class="autoSpace"><input type="radio" name="todaycaseNotetype" checked="checked" class="radioCheckCol2" />Provisional</label>
<label class="autoSpace"><input type="radio" name="todaycaseNotetype" class="radioCheckCol2" />Final</label>
<div class="clear"></div> --%>

<!--Diagnosis same as OPD  :Start-->
<input type="hidden" tabindex="25" class="textYellow" tabindex="23"	id="icd1" name="icd1" />
<label><span>*</span>Diagnosis </label>
<input type="text" tabindex="25" class="large"	tabindex="23" id="snomed" name="snomed" value="<%=diagnose %>"
	onblur="getICDListBasedOnSnomedId();"
	onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');" style="width:300px" />
	<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"		title="Remove Snomed Diagnosis" id="removeSnomed" />
	<input type="hidden" name="snomedTermConceptId" id="snomedTermConceptId" />
	<label>Selected Diagnosis</label>						
	<select name="snomedList" multiple="4" id="snomedList" class="listBig" style="font: 14px tahoma; height: 51px;" validate="snomedList,string,no"></select>
	<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"	title="Remove Snomed" id="removesnomedList" />
<!--
 <label><span>*</span> Snomed Diagnosis </label>
 <input type="text" tabindex="25" class="textYellow"	tabindex="23" id="snomed" name="snomed"	onblur="getICDListBasedOnSnomedId(this.value);" /> fillDiagnosisCombo(this.value);
 <img src="/hms/jsp/images/removeImg.jpg" width="16" height="16" title="Remove Snomed Diagnosis" id="removeSnomed" />
	<div id="ac2update" style="display: none;" class="autocomplete"></div>
	<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('snomed','ac2update','opd?method=getSnomedListForAutoCompleteItem',{parameters:'requiredField=snomed'});
	</script>
 -->
	<div id="divIcdName" style="display: none;">
		<label> Select ICD Name </label> <select id="icdName"
			name="icdName" onchange="fillICDValue(this.value,'op');">
		</select>
	</div>
<div class="clear"></div>
<label>ICD code</label>
<input name="icdCode" tabindex="26" class="textYellow" value="<%=icCode %>"		id="icdCode" readonly />
<input name="temp" value="" id="temp" type="hidden" />
<IMG SRC="/hms/jsp/images/search.gif" WIDTH="24" HEIGHT="20" tabindex="27" class="search-img"	onClick="javascript:openPopupDiagnosisWindow();" title="Click here to Search ICD Codes" />
<label	class="autoSpace"> 
<input type="radio" tabindex="28" class="radioCheckCol2" name="diagnosis_status" value="p" id="diagnosis_status_p1" checked="checked" onchange="changeDiagnosisStaus(1);" /> Provisional
</label>
<label class="autoSpace">
 <input type="radio"	tabindex="29" class="radioCheckCol2" name="diagnosis_status"	value="f" id="diagnosis_status_f1"	onchange="changeDiagnosisStaus(2);" /> Final
</label>
 <label class="smallAuto">
 <img	src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />Notifiable Desease</label>
 <label class="smallAuto"><img	src="/hms/jsp/images/grey_rectangle.jpg" width="14" height="14" />P-Register</label>
<div class="clear"></div>
<div class="paddLeftP100">
<select name="diagnosisId" multiple="4" id="diagnosisId" class="listBig" style="font: 14px tahoma; height: 51px;" validate="diagnosisId,string,no">
</select>
<img src="/hms/jsp/images/removeImg.jpg" width="16" height="16"	title="Remove diagnosis" id="removeOPDisgnosis" />
<select	name="diagnosisIdNP" multiple="4" id="diagnosisIdNP" class="listBig" style="font: 14px tahoma; height: 51px;">
</select>
</div>
<!--Diagnosis same as OPD  : End-->
</div>
</div>
</div>


<div class="Block">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;" >Case Note</h6>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<label>Case Note</label>
<textarea name="clinicalNotes" validate="Clinical Notes,string,no" id="clinicalNotes" cols="0"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)" style="margin:0px">
	<%=opdDetailsList.size()>0?(opdDetailsList.get(0).getClinicalNote()!=null?opdDetailsList.get(0).getClinicalNote():""):"" %>
	</textarea>
<div class="clear"></div>
</div>
</div>
</div>


<div id="prevDiagCaseNoteDiv">
<div class="clear"></div>


<%if(ipdPatientDetailList.size()>0)
{
	 for (OpdPatientDetails details : ipdPatientDetailList) {
	%>
<div class="">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;"><%=HMSUtil.convertDateToStringTypeDateOnly(details.getConsultationDate()) %></h6>
<h6 style="display: inline;"><%=details.getConsultationTime() %></h6>
<h6 style="display: inline;"><%=details.getInpatient().getDepartment().getDepartmentName() %></h6>
<input type="hidden" name="referredDept" id="referredDept" value="<%=details.getInpatient().getDepartment().getId() %>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>

<%
 OpdPatientHistory patientHistory=null; 
if(ipdPatientHistoryList.size()>0)
{
	for(OpdPatientHistory history:ipdPatientHistoryList)
	{
		if(history.getOpdPatientDetails().getId()==details.getId())
		{
			 patientHistory=history; 
		}
	}
}

%>
<div class="Block">
<div class="clear"></div>
<h4>History</h4>
<div class="clear"></div>
<label class="heightAuto">Present Complaint & History</label>
<textarea name="presentComplainhistory" id="presentComplainhistory"  readonly="readonly" cols="0" rows="0"  maxlength="300" tabindex="1" ><%=patientHistory!=null && patientHistory.getPresentComplaintHistory()!=null?patientHistory.getPresentComplaintHistory().trim():""%></textarea>
<label>History of Past Illness</label>
 <textarea name="presentIllnesshistory" id="presentIllnesshistory" cols="0"  readonly="readonly"	rows="0" maxlength="300" tabindex="1" ><%=patientHistory!=null && patientHistory.getPastIllnessHistory()!=null?patientHistory.getPastIllnessHistory().trim():""%></textarea>

<div class="clear"></div>
<label>Personal  History</label>
<textarea name="pastHistoryhistory" id="pastHistoryhistory" tabindex="1" cols="0" readonly="readonly"	rows="0" maxlength="500"  ><%=patientHistory!=null && patientHistory.getPersonalPresentHistory()!=null?patientHistory.getPersonalPresentHistory().trim():""%></textarea>
<label>Family History</label>
 <textarea name="familyHistoryhistory"  id="familyHistoryhistory" cols="0" readonly="readonly"	rows="0" maxlength="500" tabindex="5" ><%=patientHistory!=null && patientHistory.getFamilyPastHistory()!=null?patientHistory.getFamilyPastHistory().trim():""%></textarea>
<div class="clear"></div>

<label>Medication History</label> 
<textarea name="familyHistoryhistory"  id="familyHistoryhistory" cols="0" readonly="readonly"	rows="0" maxlength="500" tabindex="5" ><%=patientHistory!=null && patientHistory.getMadicationHistory()!=null?patientHistory.getMadicationHistory().trim():""%></textarea>
<div class="clear"></div>

<h4>Examination</h4>
<div class="clear"></div>
<label class="medium">Pulse</label>
<%
%>
<input name="pulsehistory" id="pulsehistory" type="text" maxlength="3" value="<%=details.getPulse()!=0?details.getPulse():"" %>" class="textSmall" tabindex="10" readonly="readonly"/>
<label	class="smallAuto">min</label>

<label class="medium">Temperature</label>
<input	name="temperaturehistory" id="temperaturehistory" value="<%=details.getTemperature()!=0?details.getTemperature():"" %>"  type="text" maxlength="5" class="textSmall" tabindex="11" readonly="readonly"/>
<label	class="smallAuto">&deg;F</label>
<%
String systolic="";
String diastolic="";
if(details.getBp()!=null && details.getBp().indexOf("/")!=-1)
{
	systolic=details.getBp().substring(0,details.getBp().indexOf("/"));
	diastolic=details.getBp().substring(details.getBp().indexOf("/")+1,details.getBp().length());
}
%>

<label class="auto" id="bpLabel">BP</label>
<input name="systolic" id="systolic" tabindex="14" placeholder="Systolic" value="<%=systolic%>" validate="systolic,int,no" type="text" maxlength="3" class="allownumericwithoutdecimal textSmall" />
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input name="diastolic" id="diastolic" tabindex="15" placeholder="Diastolic" value="<%=diastolic%>"	validate="diastolic,int,no" type="text" maxlength="3"	class="allownumericwithoutdecimal textSmall" />
<label	class="smallAuto autoSpace">mm&nbsp;Hg</label>

<label class="medium">Weight</label>
<input name="weighthistory" id="weighthistory" value="<%=details.getWeight()!=null?details.getWeight():"" %>" readonly="readonly" type="text"	 maxlength="3" class="textSmall" tabindex="10"/>
<label	class="smallAuto">Kg</label>

<label class="medium">Height</label>
<input	name="heighthistory" id="heighthistory" readonly="readonly" value="<%=details.getHeight()!=null?details.getHeight():"" %>" type="text" maxlength="5" class="textSmall" tabindex="11"/>
<label	class="smallAuto">cm</label>

<label style="width:80px;" id="bpLabel">BMI</label>
<input	name="bmihistory" id="bmihistory" type="text" readonly="readonly" value="<%=details.getBmi()!=null?details.getBmi():"" %>" 	maxlength="6" class="textSmall" tabindex="12"/>

<div class="clear"></div>
<div class="paddingTop5"></div>

<label>General Examination</label>
<textarea tabindex="1" cols="0" readonly="readonly"	rows="0" maxlength="500"  >
	 <%=details.getGeneralExamination()!=null?details.getGeneralExamination():"" %>
</textarea>

<label >Systemic Examination</label>
<textarea tabindex="1" cols="0" readonly="readonly"	rows="0" maxlength="500"  >
	 <%=details.getSystemicExamination()!=null?details.getSystemicExamination():"" %>
</textarea>
<div class="clear"></div>
<label >Local Examination</label>
<textarea tabindex="1" cols="0" readonly="readonly"	rows="0" maxlength="500"  >
	 <%=details.getLocalExamination()!=null?details.getLocalExamination():""%>
</textarea>
<label class="heightAuto">Outside Investigation Details</label> 
<textarea name="outinvestigation" validate="Outside iNvestigation,string,no" id="outinvestigation" cols="0" disabled="disabled"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"> <%=details.getOutsideInvestigation()!=null?details.getOutsideInvestigation():""%></textarea>

<div class="clear"></div>
<label class="heightAuto">Outside Investigation Imaging Details</label> 
<textarea name="outinvestigationImage" validate="Outside Investigation Image,string,no" id="outinvestigationImage" cols="0" disabled="disabled"
	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"><%=details.getOutsideInvestigationImage()!=null?details.getOutsideInvestigationImage():""%></textarea>
<div class="clear"></div>

<h4>Diagnosis</h4>
<div class="clear"></div>
<input	type="hidden" id="systamicExamhistory" class="large" name="systamicExamhistory"	maxlength="200" />

<%-- <label>Diagnosis</label>
<input type="text" class="large"  size="119" readonly="readonly" id="initialDiagnosishistory" tabindex="1" 
value="<%=details.getSystemDiagnosis()!=null?details.getSystemDiagnosis().getSystemDiagnosisName():"" %>"	name="initialDiagnosishistory" maxlength="100" />	
<div class="clear"></div>
 --%>
<label>Diagnosis</label>
<select name="<%=DIAGNOSIS_ID%>history" readonly="readonly" multiple="4" style="width:550px;" size="5" tabindex="1"  id="diagnosisIdhistory" class=listBig>
	<%
		 DischargeIcdCode dischargeIcdCode=null; 
		if(ipdDischargeList.size()>0)
		{
			for(DischargeIcdCode icdCode :ipdDischargeList)
			{
				if(icdCode.getOpdPatientDetails().getId()==details.getId())
				{
					%>
					<option value="<%=icdCode.getIcd().getIcdCode()%>"><%=icdCode.getIcd().getIcdName()%></option>
					<%
				}
			}
		}
	%>
</select>

<label class="medium">Provisional
<input type="radio" class="radioCheckCol2"  name="todaycaseNotetypehistory" disabled="disabled" checked="checked" /></label>
<label class="medium">Final
<input type="radio" class="radioCheckCol2" name="todaycaseNotetypehistory" disabled="disabled" /></label>

<div class="clear"></div>
<h4>Case Note</h4>
<div class="clear"></div>
<label>Case Note</label>
<textarea name="clinicalNotes" readonly="readonly"  id="clinicalNoteshistory" cols="0"
	rows="0" maxlength="500" tabindex="5">
	
	<%=details.getClinicalNote()%>
	</textarea>
<div class="clear"></div>
</div>
</div>
</div>
</div>
<%}
	 }%>
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
</div>

<div id="country2" class="tabcontentIn">
<div class="Block">
<div id="templateDivToShowHide" class="-floatLeft">
<div id="testDiv">
<div class="clear"></div>
<div class="paddingTop25"></div>
<label class="medium">Date</label>
<input  id="treatmentdate" class="date" type="text" maxlength="30" validate="Treatment Date,date,yes"  readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="treatmentdate">
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.treatmentdate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<label class="medium">Time</label>
<input type="text" name="treatmenttime" value="<%=time.substring(0,5)%>"  validate="Treatment Time,String,yes" id="admTime" onblur="checkTime('ipdCaseSheet','treatmenttime');"/>


<input type="button" class="button"  value="Template" tabindex="27" style="margin:0px 5px;">
<select class="midium" name="tempLatePrescription" id="tempLatePrescription" onchange="fnGetPrescriptionTemplate(this.value);" >
	<option value="0">Select</option>
	<%for(OpdTemplate opd:templateList){ %>
			<%if(opd.getTemplateType().equalsIgnoreCase("p")){ %>
				<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
			<%} %>
	<%} %>
	
</select>
<input  type="button" class="buttonBig" name="prev" value="Save As Template" onclick="openPopupForSavePrescriptiontamplate();" />
<div class="clear"></div>
<div class="small wdthSm" id="gridtreatmentDiv">
<div class="clear"></div>
<div style="float: right;" >
    <input type="button" class="buttonBig sizeFont" style="margin-top:8px!important;" name="lastPrescription" value="Last Prescription" align="right" onclick="openWindow('/hms/hms/ipd?method=showPatientPrescriptionDetails&inPatientId=<%=inpatient.getId()%>&hinId=<%=patient.getId() %>&hinNo=<%=patient.getHinNo()%>&backFlag=ipd');">
	<input type="button" class="buttonAdd" style="margin-top:9px;" value="" align="right" onclick="javascript:addRowTreatment();">
	<input type="button" name="Reset" value="" class="buttonDel" style="margin-top:9px;" align="right" onclick="javascript:removeRowTreatment();">
		</div>

<div class="clear"></div>
<div class="Block">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridtreatment">
	<tr>
	    <th scope="col">&nbsp;</th>
		 <th scope="col">Drug Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<!-- <th scope="col">No Of Days</th> -->
		<th scope="col">Duration</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
	</tr>
	
	<%
	int l =0;
		/* if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
				l++; */
	%>

	
	<%
			/* }}else{ */ l++;%>
	<tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="itemRadiotreatment<%=l %>"  name="itemRadiotreatment<%=l %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="30" value="" tabindex="1" id="nomenclaturetreatment<%=l %>" size="70"  
	    name="nomenclaturetreatment<%=l %>" onblur="validatePrescriptionAutocomplete('opmainTM',this.value,<%=l %> );populatePVMS(this.value,'<%=l %>'); 
	     displayAu(this.value,'<%=l %>');checkForAllergy(this.value,<%=l %>);checkIPItem('<%=l%>');" onkeypress="checkTextColor('nomenclaturetreatment<%=l%>');" />
	   	<div id="ac2updatetreatment<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturetreatment<%=l %>','ac2updatetreatment<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclaturetreatment<%=l %>'});
			</script>
			<input type="hidden" name="tapered<%=l%>" id="tapered<%=l%>"  validate="tapered,string,no" />
	    </td>
		<td><input type="hidden" name="pvmsNotreatment<%=l %>" tabindex="1" id="pvmsNotreatment<%=l %>" value=""	size="10" readonly="readonly" />
				<input type="hidden" name="actualDispensingQty<%=l%>" tabindex="1" id="actualDispensingQty<%=l%>" value=""  size="6"  validate="AU,string,no" />
		
		<input type="text" name="dosagetreatment<%=l %>" tabindex="1" value="" id="dosagetreatment<%=l %>"	size="2" maxlength="5" onblur="fillTotalForTreatment('<%=l %>');checkFrequencyForTaperedDrugs(<%=l%>)" /></td>
		<td><input type="text" size="2" name="unittreatment<%=l %>" readonly="readonly" id="unittreatment<%=l %>" value="" />
		<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixable<%=l%>"
											id="mixable<%=l%>" 
											validate="mixable,string,no" />
																				
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixtureQuantity<%=l%>"
											id="mixtureQuantity<%=l%>" 
											validate="mixtureQuantity,int,no" />
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="actualTotalAfterMix<%=l%>"
											id="actualTotalAfterMix<%=l%>" 
											validate="actualTotalAfterMix,float,no" />
											<input type="hidden"
											name="tapered<%=l%>"
											id="tapered<%=l%>" 
											validate="tapered,string,no" />
											<input type="hidden"
											name="mixtureUnit<%=l%>"
											id="mixtureUnit<%=l%>" 	
											validate="mixtureUnit,string,no" />
		</td>
		<td>
		<input type="hidden" name="frequencyValue<%=l%>" tabindex="1" id="frequencyValue<%=l%>" value=""  size="6"   />
		<input type="text" name="sosQty<%=l%>" tabindex="1" id="sosQty<%=l%>" style="display: none;"   size="3" onblur="fillValue(this.value,<%=l%>)"	maxlength="3" validate="Sos Qty,num,no" />
		<select name="frequencytreatment<%=l %>" id="frequencytreatment<%=l %>"  tabindex="1" 
<%--		 onblur="getFrequencyValue(this.value,<%=l%>);fillValueFromFrequency(this.value,<%=l%>);displaySOSQty(this.value,<%=l%>)" > //commented by govind 24-12-2016--%>
		 onchange="getFrequencyValue(this.value,<%=l%>);fillValueFromFrequency(this.value,<%=l%>);displaySOSQty(this.value,<%=l%>);displaFrequencyType(this,<%=l%>);checkFrequencyForTaperedDrugs(<%=l%>)" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
		       String type = masFrequency.getFrequencyType() != null?masFrequency.getFrequencyType():"";
          %>
			<option id="<%=type %>" value="<%=id %>"><%=name%></option>
			<%}%>
		</select> 
		
		</td>
		
<%--		<td><input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" /> //commented by govind 24-12-2016--%>
		<td>
		<div style="width:100px; float: left;">
		<input type="text"  name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillValueFromFrequency(this.value,<%=l%>);"  oninput="fillValueFromFrequency(this.value,<%=l%>);" size="2"	maxlength="3" validate="Duration,num,no" />
		<p style="line-height:0px;" id="frequencyType<%=l %>" ></p>
		</div>			
		</td>
		
		<td><select name="instructiontreatment<%=l %>" id="instructiontreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();

          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}
			%>
			
		</select> 
		
		</td>
		
		<td><input type="text" name="spslinstructiontreatment<%=l %>" tabindex="1" id="spslinstructiontreatment<%=l %>" value=""  size="15"	maxlength="50"  />
			
		</td>
		
		<td><select name="routetreatment<%=l %>" id="routetreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
				for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		      
          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" name="totaltreatment<%=l %>" tabindex="1" id="totaltreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>')"  size="2"	maxlength="3" validate="Total,num,no" readonly="readonly" />
			
		</td>
		
		
	</tr>
<%-- <%} %> --%>
	<%
	//int l =0;
		/* if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){ */
				//l++;
	%>	
	
	
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdbtreatment" />
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div id="prevTreatmentDiv">
<%
Date prescriptiondate=new Date();
String departmentNameOPD="OPD";
String prescriptionTime="";
System.out.println("patientPrescriptionDetailsList jsp "+patientPrescriptionDetailsList.size());
if(patientPrescriptionDetailsList.size()>0)
{
for(PatientPrescriptionDetails ppd:patientPrescriptionDetailsList){
	prescriptiondate=ppd.getPrescription().getPrescriptionDate();
	departmentNameOPD=ppd.getPrescription().getVisit().getDepartment().getDepartmentName();
	prescriptionTime=ppd.getPrescription().getPrescriptionTime();
}

	%>
	<div class="">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;"><%=HMSUtil.convertDateToStringTypeDateOnly(prescriptiondate) %></h6>
<h6 style="display: inline;"><%=prescriptionTime %></h6>
<h6 style="display: inline;"><%=departmentNameOPD%></h6>
<div class="clear"></div>
</div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<div class="small wdthSm">
<div class="clear"></div>
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th scope="col">Drug Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<!-- <th scope="col">No Of Days</th> -->
		<th scope="col">Duration</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col" >Route</th>
		<th scope="col">Total</th>
		<th scope="col">Status</th>
	</tr>
	<%
	
		for(PatientPrescriptionDetails details:patientPrescriptionDetailsList)
		{

%>


	<tr>
	
	
		<td>
	    <%=details.getItem().getNomenclature() %>
	    </td>
		<td>
		 <%=details.getDosage() %>
		</td>
		<%
		String uName="";
		String fqName="";
		if(details.getItem()!=null && details.getItem().getItemConversion()!=null && details.getItem().getItemConversion().getIssueUnit()!=null && details.getItem().getItemConversion().getIssueUnit().getUnitName()!=null){
			uName=details.getItem().getItemConversion().getIssueUnit().getUnitName();
		} 
		if(details.getFrequency()!=null && details.getFrequency().getFrequencyName()!=null){
			fqName=details.getFrequency().getFrequencyName();
		}
		
		%>
		<td> 
		 <%=uName%>
		</td>
		<%if(details.getFrequency()!=null){ %>
		<td> <%=details.getFrequency().getFrequencyName()%>
		</td>
		<%}else{ %>
<td>-</td>
<%} %>
		<td>
		 <%=details.getNoOfDays()%><%=details.getFrequency().getFrequencyType() %>
		</td>
		<td>
		<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
		</td>
		<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
		</td>
		<td>
		<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
		</td>
		<td>
		<%=details.getTotal() %>
		</td>
		<td><%if(details.getIssuedStatus()!=null && details.getIssuedStatus().equals("J")){ %>
		Cancelled
		<%}else{ %>
		Pending
		<%} %>
		</td>
		
	</tr>	

<%}
	%>
	</table>
</div>
</div>
</div>
</div>
<%} %>	

</div>
<div class="clear"></div>
<div id="prevTreatmentDiv">
<% int medCount=0;//added by govind 2-12-2016 for stop medicin
if(ipdPatientPrescriptionHeaderList!=null)
{
	%>
	
	<%
	for(InpatientPrescriptionHeader header:ipdPatientPrescriptionHeaderList)
	{
		
	%>
	<div class="">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;"><%=HMSUtil.convertDateToStringTypeDateOnly(header.getPrescriptionDate()) %></h6>
<h6 style="display: inline;"><%=header.getPrescriptionTime() %></h6>
<h6 style="display: inline;"><%=header.getDepartment().getDepartmentName() %></h6>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<div class="small wdthSm">
<div class="clear"></div>
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th scope="col">Drug Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">Duration</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col" >Route</th>
		<th scope="col">Total</th>
		<th scope="col">Status</th>
		<th scope="col">Stop Medicine</th>
	</tr>
	<%
		for(InpatientPrescriptionDetails details:header.getPrescription())
		{

%>
<%        // if(details.getInjectionStatus()!=null){ // commented by amit das on 09-12-2016
			// if(details.getInjectionStatus().equalsIgnoreCase("Y")){ // commented by amit das on 09-12-2016
				if(details.getInjectionStatus()!=null && details.getInjectionStatus().equalsIgnoreCase("Y")){ // added by amit das on 09-12-2016
				for(InjAppointmentDetails injDetail:injAppointmentDetailsList){	
					
					if(injDetail.getInpatientPrescriptionDetails().getId()==details.getId()){
										%>	
				<tr>
	
	
		<td>
	    <%=details.getItem().getNomenclature() %>
	    </td>
		<td>
		 <%=details.getDosage() %>
		</td>
		<td>
		 <%=details.getItem().getItemConversion().getIssueUnit().getUnitName()%>
		</td>
		<%if(details.getFrequency()!=null){ %>
		<td> <%=details.getFrequency().getFrequencyName()%>
		</td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		
		<td>
		 <%=details.getNoOfDays()%>
		</td>
		<td>
		<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
		</td>
		<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
		</td>
		<td>
		<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
		</td>
		<td>
		<%=details.getTotal() %>
		</td>
		<td>	<%if(injDetail.getInpatientPrescriptionDetails().getIssuedStatus().equalsIgnoreCase("J")) {%>
                 Cancelled
		 	<%} else if(injDetail.getFinalStatus()==null || injDetail.getFinalStatus().equalsIgnoreCase("n")) {%>
		 		Not Completed
		 	<%}else{ %>
		 		Completed
		 	<%} %>
		</td>
		
	</tr>					
				<%} }}else{ medCount++;%>
       
	<tr>
	
	
		<td>
	    <%=details.getItem().getNomenclature() %>
	    </td>
		<td>
		 <%=details.getDosage() %>
		</td>
		<td>
		 <%=details.getItem().getItemConversion().getIssueUnit().getUnitName()%>
		</td>
		<%if(details.getFrequency()!=null){ %>
		<td> <%=details.getFrequency().getFrequencyName()%>
		</td>
		<%}else{ %>
		<td>--</td>
		<%} %>
		
		<td>
		 <%=details.getNoOfDays()%>
		</td>
		<td>
		<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
		</td>
		<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
		</td>
		<td>
		<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
		</td>
		<td>
		<%=details.getTotal() %>
		</td>
		<td><%if(details.getIssuedStatus()!=null && details.getIssuedStatus().equals("J")){ %>
		Cancelled
		<%}else{ %>
		Pending
		<%} %>
		</td>
		<td>
		<input type="hidden" name="mediStopId<%=medCount %>" id="mediStopId<%=medCount %>" value="<%=details.getId() %>"/>
		 <%if(details.getStopMedicine().equalsIgnoreCase("y")){ %>
		<input type="checkbox" name="medicinStop<%=medCount %>" id="medicinStop<%=medCount %>" value="1" disabled="disabled" checked="checked"/>
					 <%}else{%>
		<input type="checkbox" name="medicinStop<%=medCount %>" id="medicinStop<%=medCount %>" value="1"/>
					 <%}%>
		</td>
	</tr>	

<%}
	%>
	<%} //}
	%>
	</table>	
</div>
</div>
</div>
</div>
	<%
		}
	%>
	<%
		}%>
	<input type="hidden" name="mediStopCount" id="mediStopCount" value="<%=medCount %>"/>
<div class="clear"></div>
</div>
</div>
</div>

 <div id="country3" class="tabcontentIn">
<div class="Block">
 <% if(rsbyCardDetailsList!=null && rsbyCardDetailsList.size()!=0) {
	 %>
 	<label>Package Service</label>
 	<select id="pkgServiceId" name="pkgServiceId">
 		<option value="0">Select</option>
 		<% for(BlPackageServicesDetails blPackageServicesDetails : packageServicesList){ %>
 		<option value="<%=blPackageServicesDetails.getChargeCode().getCharge()%>"><%=blPackageServicesDetails.getChargeCode().getChargeCodeName()+"["+blPackageServicesDetails.getChargeCode().getId()+"]"%></option>
 		<% } %>
 	</select>
 	 <script type="text/javascript">
      <% 
			int count2 = 0;
			for (BlPackageServicesDetails blPackageServicesDetails  : packageServicesList) 
			{
				%>
				pkgServicesArray[<%=count2%>] = new Array();
				pkgServicesArray[<%=count2%>][0] = <%=blPackageServicesDetails.getPackageHeader().getId()%>;
				pkgServicesArray[<%=count2%>][1] = <%=blPackageServicesDetails.getChargeCode().getId()%>;
				pkgServicesArray[<%=count2%>][2] = "<%=blPackageServicesDetails.getChargeCode().getChargeCodeName()%>[<%=blPackageServicesDetails.getChargeCode().getId()%>]";
				pkgServicesArray[<%=count2%>][3] = <%=blPackageServicesDetails.getPackageHeader().getTotalValueOfPackage()%>;
				<%
				count2++;
				
			} %>
		</script>
 	
 <input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addPackageServiceIntoInvestigation();">
 <!-- Ended by Amit Das -->
 <% } %>
 
<%
int inc = 0;
%>
<div class="clear"></div>
<div id="gridview">
<div class="clear"></div>
<div class="paddingTop15"></div>
<label class="medium">Date</label>
<input  id="investigationdate" class="date" type="text" validate="Investigation Date,date,yes" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="investigationdate">
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.investigationdate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<label class="medium">Time</label>
<input type="text" name="investigationtime" value="<%=time.substring(0,5)%>"  validate="Investigation Time,String,yes" id="admTime" onblur="checkTime('ipdCaseSheet','investigationtime');"/>

<input type="button" class="button" tabindex="3" alt="Delete" value="Template"	style="margin:0px 5px;"/>
<select class="midium" name="tempLateInvestigation" id="tempLateInvestigation" onchange="fnGetInvestigationTemplate(this.value);">
	<option value="0">Select</option>
	<%for(OpdTemplate opd:templateList){ %>
		<%if(opd.getTemplateType().equalsIgnoreCase("i")){ %>
			<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
		<%} %>	
	<%} %>
</select>
<input type="button" class="buttonBig" name="prev" value="Save As Template" onclick="javascript:openPopupForSaveInvestigation();"  />
<div class="clear"></div>

<label class="medium">LAB
<input type="radio" class="radioCheckCol2" value="Lab" name="labradiologyCheck" checked="checked" onclick="onChangeInvestigationDepartment();" /></label> 

<label class="medium">Radiology
<input type="radio" class="radioCheckCol2" value="Radio" name="labradiologyCheck"  onclick="onChangeInvestigationDepartment();" /></label>

<input type="hidden" value=""  name="investigationCategory" id="investigationCategory" />

<div class="clear"></div>
<div class="clear"></div>
<div class="small wdthSm" id="investigationGridDiv">
<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForInvestigation();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowInvestigation();">
</div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
	</tr>
<%inc++; %>

<tr>
<td><input type="checkbox"  class="radioCheck"  tabindex="1" id="investigationtradio<%=inc %>" size="70"  name="investigationtradio<%=inc %>" /></td>
<td><input type="text" value="" style="width:400px;" tabindex="1" id="chargeCodeName<%=inc %>" size="40" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){disablePkgFlag('isPackageFlag<%=inc %>'); checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2<%=inc %>" style="display: none;" class="autocomplete">
		</div>
		
		<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete&'+csrfTokenName+'='+csrfTokenValue,{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> --%> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 

		</td>
		<td>
		<input type="text" name="chargecodeclinicalnote<%=inc %>"  id="chargecodeclinicalnote<%=inc%>" value="" style="width:350px;"/>
		<input type="hidden" name="isPackageFlag<%=inc %>"  id="isPackageFlag<%=inc%>" value="n" />
		<input type="hidden" name="serviceSchemeId<%=inc %>"  id="serviceSchemeId<%=inc %>" value="" />
		<input type="hidden" name="pkgServiceCharge<%=inc %>"  id="pkgServiceCharge<%=inc %>" value="" />
		</td>
	</tr>

</table>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />

</div>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>

	<div id="prevInvestigationDiv">
	<div class="">
<%
Date invDateOP=new Date();
String invDeptOp="OPD";
String invTimeOP="";
if(DgOrderdtList!=null && DgOrderdtList.size()>0)
{
for(DgOrderdt dt:DgOrderdtList){
	invDateOP=dt.getOrderhd().getOrderDate();
	departmentNameOPD=dt.getOrderhd().getVisit().getDepartment().getDepartmentName();
	invTimeOP=dt.getOrderhd().getOrderTime();
}

	%>
	<div class="">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;"><%=HMSUtil.convertDateToStringTypeDateOnly(invDateOP) %></h6>
<h6 style="display: inline;"><%=prescriptionTime %></h6>
<h6 style="display: inline;"><%=departmentNameOPD%></h6>
<div class="clear"></div>
</div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<div class="small wdthSm">
<div class="clear"></div>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
		
	</tr>
<%
for(DgOrderdt dt2:DgOrderdtList)
{
%>
<tr>
		<td><%=dt2.getChargeCode().getChargeCodeName() %>
		<% if(dt2.getOrderStatus().equalsIgnoreCase("j") || dt2.getOrderStatus().equalsIgnoreCase("x")) {%> <!-- edited by amit das on 09-11-2016 -->
		<span style="color: red;">(Cancelled on <%=dt2.getLastChgDate()%>, <%=dt2.getLastChgTime()%>)</span>
		<% } %>
		</td>
		
		<td>-</td>
		
	</tr>
	<%} %>

</table>
</div>
</div>
</div>
</div>
<%} %>
</div>
<div class="clear"></div>
<div id="prevInvestigationDiv">	
<div class="clear"></div>
<%
if(ipdPatientInvestigationHeaderList.size()>0)
{
%>
<div class="clear"></div>
<div class="division"></div>
<%
/* for(PatientInvestigationHeader investigationHeader:ipdPatientInvestigationHeaderList) */
for(DgOrderhd investigationHeader:ipdPatientInvestigationHeaderList)
{
%>
<div class="">
<div class="ipCollapsWp" onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.png" alt="" /> 
</h6>
<h6 style="display: inline;"><%=HMSUtil.convertDateToStringTypeDateOnly(investigationHeader.getOrderDate())%></h6>
<h6 style="display: inline;"><%=investigationHeader.getOrderTime()%></h6>

<h6 style="display: inline;"><%=investigationHeader.getDepartment().getDepartmentName() %></h6>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="collapasHideMain">
<div class="indArrowClp"></div>
<div class="small wdthSm">
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
		
	</tr>
<%
for(DgOrderdt dgOrderdt:investigationHeader.getDgOrderdts())
{
%>
<tr>
		<%-- <td><%=investigationDetails.getChargeCode().getChargeCodeName() %></td>
	
		<td><%=investigationDetails.getClinicalNotes()%></td> --%>
		<td><%=dgOrderdt.getChargeCode().getChargeCodeName() %>
		<%if(dgOrderdt.getOrderStatus().equalsIgnoreCase("j") || dgOrderdt.getOrderStatus().equalsIgnoreCase("x")) {%> <!-- edited by amit das on 09-11-2016 -->
		<span style="color: red;">(Cancelled on <%=dgOrderdt.getLastChgDate()%>, <%=dgOrderdt.getLastChgTime()%>)</span>
		<% } %>
		</td>
	
		<td>-</td>
		
		
	</tr>
	<%} %>

</table>
</div>
</div>
</div>
</div>
<%}
}%>
<div class="clear"></div>		
</div>
</div>
</div>
</div>

<div id="country4" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop25"></div>
<label class="medium">Date</label>
<input  id="proceduredate" class="date" validate="proscedure Date,date,yes" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="proceduredate">
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.proceduredate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<label class="medium">Time</label>
<input type="text" name="proceduretime" value="<%=time.substring(0,5)%>"  validate="proscedure Time,String,yes" id="admTime" onblur="checkTime('ipdCaseSheet','proceduretime');"/>
<div class="clear"></div>
<div class="small wdthSm">
<div class="clear"></div>
<div style="float: right;">
<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForNursingcare();">
<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForNursingcare();">
</div>
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0" id="nursingcaretable">
								<tr>
								     <th>&nbsp;</th>
									<th>Nursing Care / Procedure</th>
									<th>Frequency</th>
									<th>Stop</th>
									<th>Remarks</th>
								</tr>
								<%
								int countNursingCare=0;
								if(nursingCareSetupList.size()==0){
									countNursingCare++;
								}
								if(nursingCareSetupList.size()>0)
								{
									for(NursingcareSetup nursingcareSetup:nursingCareSetupList)
									{
										countNursingCare++;
										%>
										<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radionursingcare<%=countNursingCare%>"  name="radionursingcare<%=countNursingCare%>"  />
							</td>
							<td width="27%"><select name="<%=CARE_TYPE_ID%><%=countNursingCare%>" id="<%=CARE_TYPE_ID%><%=countNursingCare%>" onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
											<option value="0">Select</option>
											<%
												for (Object masCareTypeObject : nursingCareList) {
													MasNursingCare masNursingCare=(MasNursingCare)masCareTypeObject;
													if(masNursingCare.getId()==nursingcareSetup.getNursing().getId())
													{%>
													<option value="<%=masNursingCare.getId()%>" selected="selected">
											<%=masNursingCare.getNursingName()%>
											</option>
													<%
													}
													else{
												%>
											<option value="<%=masNursingCare.getId()%>">
											<%=masNursingCare.getNursingName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									<td width="27%"><select name="<%=FREQUENCY%><%=countNursingCare%>" id="<%=FREQUENCY%><%=countNursingCare%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
													if(masFrequency.getId()==nursingcareSetup.getFrequency().getId())
													{%>
													<option value="<%=masFrequency.getId()%>" selected="selected">
											<%=masFrequency.getFrequencyName()%>
											</option>
													<%
													}
													else{
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									<td><input type="hidden" name="carestop_id<%=countNursingCare%>" id="carestop_id<%=countNursingCare%>" value="<%=nursingcareSetup.getId() %>"/>
									<%if(nursingcareSetup.getStopCare().equalsIgnoreCase("y")){%>
									   <input type="checkbox" name="carestop<%=countNursingCare%>" id="carestop<%=countNursingCare%>" disabled="disabled" checked="checked" value="1"/>
										<%}else{%>
										<input type="checkbox" name="carestop<%=countNursingCare%>" id="carestop<%=countNursingCare%>" value="1" />
										<%}%>
									 </td>
									<td><input type="text" name="<%=CARE_REMARKS%><%=countNursingCare%>" id="<%=CARE_REMARKS%><%=countNursingCare%>" 
									value="<%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():""%>" /> </td>
							</tr>
										<%
									}
								}
								else
								{
								
								%>
							
							<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radionursingcare1"  name="radionursingcare1"  />
							</td>
							<td width="27%"><select name="<%=CARE_TYPE_ID%>1" id="<%=CARE_TYPE_ID%>1" onblur="validateDuplicateNursingCare('1')">
											<option value="0">Select</option>
											<%
												for (Object masCareTypeObject : nursingCareList) {
													MasNursingCare masNursingCare=(MasNursingCare)masCareTypeObject;
											%>
											<option value="<%=masNursingCare.getId()%>">
											<%=masNursingCare.getNursingName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td width="27%"><select name="<%=FREQUENCY%>1" id="<%=FREQUENCY%>1"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td><input type="checkbox" name="carestop1" id="carestop1" value="1" /> </td>
									<td><input type="text" name="<%=CARE_REMARKS%>1" id="<%=CARE_REMARKS%>1" /> </td>
							</tr>
							<%} %>
							
							</tbody>
						</table>
	<input type="hidden" name="nursingcarecount" id="nursingcarecount" value="<%=countNursingCare%>"/>
			
	<div id="prevProcedureDiv">
	</div>
	
	<%-- By Ujjwal For Vital in IP Case Sheet --%>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForVitalcare();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForVitalcare();">
		</div>
		<div class="clear"></div>		
	<div class="clear"></div>
	<table border="0" cellpadding="0" cellspacing="0" id="vitalcaretable">
								<tr>
								     <th>&nbsp;</th>
									<th>Vitals</th>
									<th>Frequency</th>
									<th>Stop</th>
									<th>Remarks</th>
								</tr>
								<%
								int vitalCount=0;
								if(ipdVitalSetupList.size()>0)
								{
									for(IpdVitalSetup ipdVitalSetup:ipdVitalSetupList)
									{
										vitalCount++;
										%>
										<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radiovitalCare<%=vitalCount%>"  name="radiovitalCare<%=vitalCount%>"  />
							</td>
							<td width="27%"><select name="vitalName<%=vitalCount%>" id="vitalName<%=vitalCount%>" onblur="validateDuplicateVitalCare('<%=vitalCount%>')">
											<option value="0">Select</option>
											<%
												for (String vital : vitalList) {
													if(vital.equalsIgnoreCase(ipdVitalSetup.getVitalName()))
													{%>
													<option value="<%=vital%>" selected="selected">
											<%=vital%>
											</option>
													<%
													}
													else{
												%>
											<option value="<%=vital%>">
											<%=vital%>
											</option>
											<%
												}
												}
											%>
									</select></td>
									<td width="27%"><select name="vitalFrequency<%=vitalCount%>" id="vitalFrequency<%=vitalCount%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
													if(ipdVitalSetup.getFrequency() != null){
													if(masFrequency.getId()==ipdVitalSetup.getFrequency().getId())
													{%>
													<option value="<%=masFrequency.getId()%>" selected="selected">
											<%=masFrequency.getFrequencyName()%>
											</option>
													<%
													}
													else{
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
												}}
											%>
									</select></td>
									<td><input type="hidden" name="vitalstop_id<%=vitalCount%>" id="carestop_id<%=vitalCount%>" value="<%=ipdVitalSetup.getId()%>"/>
									<%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){%>
									   <input type="checkbox" name="vitalstop<%=vitalCount%>" id="vitalstop<%=vitalCount%>"  disabled="disabled" checked="checked" value="1" />
										<%}else{%>
										<input type="checkbox" name="vitalstop<%=vitalCount%>" id="vitalstop<%=vitalCount%>" value="1" />
										<%}%>
									</td>
									<td><input type="text" name="vitalRemarks<%=vitalCount%>" id="vitalRemarks<%=vitalCount%>" 
									value="<%=ipdVitalSetup.getRemarks()!=null?ipdVitalSetup.getRemarks():""%>" /> </td>
							</tr>
										<%
									
								}
								}
								else
								{
									vitalCount++;
								%>
							<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radiovitalCare<%=vitalCount%>"  name="radiovitalCare<%=vitalCount%>"  />
							</td>
							<td width="27%"><select name="vitalName<%=vitalCount%>" id="vitalName<%=vitalCount%>" onblur="validateDuplicateVitalCare('<%=vitalCount%>')">
											<option value="0">Select</option>
											<%
												for (String vital : vitalList) {
													%>
													
													
											<option value="<%=vital%>">
											<%=vital%>
											</option>
											<%
												}
											%>
									</select></td>
									<td width="27%"><select name="vitalFrequency<%=vitalCount%>" id="vitalFrequency<%=vitalCount%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
													%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td><input type="checkbox" name="vitalstop<%=vitalCount%>" id="vitalstop<%=vitalCount%>" value="1" /> </td>
									<td><input type="text" name="vitalRemarks<%=vitalCount%>" id="vitalRemarks<%=vitalCount%>" 
									value="" /> </td>
							</tr>
							<%} %>
							
							</tbody>
						</table>
	<input type="hidden" name="vitalcarecount" id="vitalcarecount" value="<%=vitalCount%>"/>
	
</div>
</div>
</div>

<div id="country5" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="small wdthSm">
<div class="clear"></div>
<div style="float:right;">
<input	type="button" class="buttonAdd" alt="Add" tabindex="4" value="&nbsp;" onclick="addRowForAllergy();" align="right" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;"	onclick="removeRowForAllergy();" align="right" />
</div>
<div class="paddingTop25"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="alergyGrid">
	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Type</th>
		<th scope="col">Allergen</th>
		<th scope="col">Severity</th>
		<th scope="col">Since:Month</th>
		<th scope="col">Year</th>
		<th scope="col">Status</th>
	</tr>
	<tr>
	<td><input  type="checkbox" class="radioCheck" name="allergyRadio1" id="allergyRadio1" /></td>	
	<td><select name="allergyType1" id="allergyType1" tabindex="1">
		<option value="0">Select</option>
		<%for(MasAllergyProduct msap:allergyProductsList){%>
			<option value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
		<%} %>
		</select>
	</td>
	<td><input size="20" type="text" name="allergyName1"  id="allergyName1"/></td>
	<td><select name="allergyseverity1" id="allergyseverity1" class="smallest"  tabindex="1">
		<option value="0">Select</option>
		<%for(MasSeverityCode mssc:saverityCodesList){%>
			<option value="<%=mssc.getId()%>"><%=mssc.getSeverityName()%></option>
		<%} %>
		</select>
	</td>
	<td><select class="smallest" name="allergymonth1" id="allergymonth1" type="text">
	   <option value="1">Jaunary</option>
		<option value="2">February</option>
		<option value="3">March</option>
		<option value="4">April</option>
		<option value="5">May</option>
		<option value="6">June</option>
		<option value="7">July</option>
		<option value="8">Augest</option>
		<option value="9">September</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
		</select>
	</td>
	<td><input size="2" name="allergyyear1" maxlength="2" id="allergyyear1" placeholder="YY" onkeypress="return isNumber(event)"  type="text"/></td>
	<td><select name="allergystatus1" id="allergystatus1" class="smallest" tabindex="1">
		<option value="0">Select</option>
		<option value="1">Active</option>
		<option value="2">Inactive</option>
		</select>
	</td>
	</tr>
</table>

<div style="float: right;display: none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" tabindex="1">
	<option value="0">Select</option>
</select>
</div>
<input type="hidden" name="allergyCount" id="allergyCount" value="1" />
</div>
<div class="clear"></div>

<%if(ipdOpdPatientAllergyMList.size()>0)
	{%>
	<div class="small wdthSm">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="alergyGrid">
		<tr>
			<th scope="col">Type</th>
			<th scope="col">Allergen</th>
			<th scope="col">Severity</th>
			<th scope="col">Since:Month</th>
			<th scope="col">Year</th>
			<th scope="col">Status</th>
		</tr>
	<%
	for(OpdPatientAllergyM allergyM:ipdOpdPatientAllergyMList)
	{		
	for(OpdPatientAllergyT allergyT:allergyM.getOpdPatientAllergyTs())
	{%>		
		<tr>
		<td>
		<%=allergyT.getAllergy().getProductName() %>
		</td>
		<td><%=allergyT.getAllergen() %></td>
		<td><%=allergyT.getSeverity()!=null?allergyT.getSeverity().getSeverityName():"" %>
		</td>
		<td><%=allergyT.getFromMonth()!=null?allergyT.getFromMonth():"" %></td>
		<td><%=allergyT.getFromYear()!=null?allergyT.getFromYear():"" %></td>
		<td>
		<%
		if(allergyT.getStatus()!=null  && allergyT.getStatus().equals("1"))
		{
			%>
			Active
			<%
		}
		else if(allergyT.getStatus()!=null  && allergyT.getStatus().equals("2"))
		{
			%>
			InActive
			<%
		}
		%>
		</td>
		</tr>
	<%}
	}
	%>
		</table>
		</div>
	<%
	}%>
</div>
</div>

<div id="country6" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop25"></div>
<label>Date</label>
<input  id="dietdate" class="date" validate="Diet Date,date,yes" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="dietdate">
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.dietdate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<label>Time</label>
<input type="text" name="diettime" value="<%=time.substring(0,5)%>"  validate="Diet Time,String,yes" id="admTime" onblur="checkTime('ipdCaseSheet','diettime');"/>
<div class="clear"></div>
<div class="small wdthSm">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="dietgrid">
    <tr>
   		<th scope="col">Diet Time</th>
		<th scope="col">Diet Type</th>
		<th scope="col">Requisition To</th>
		<th scope="col">Requisition for Date</th>
		<th scope="col">Select Diet</th>
		<th scope="col">Extra Diet</th>
	</tr>
	<tr>
	<td>
	<select name="<%=DIET_MENU_ITEM_ID %>" id="<%=DIET_MENU_ITEM_ID %>" onchange="onChangeSearchCriteria();">
<option value="">select</option>
<%
for(MasMenuType menuType : masMenuTypeList)
{
%>
<option value="<%=	menuType.getId()%>"><%=menuType.getMenuName()%></option>

<%} %>
</select> 
	</td>
	<td>
	<select id="dietTypeId" name="dietTypeId">
	<option value="0">Select</option>
	<%
		if(dietTypeList.size() > 0){
			for(MasDiet diet:dietTypeList){
	%>
	<option value="<%=diet.getId() %>"><%=diet.getDietName() %></option>
	
	<%}
			}%>
	</select>
	</td>
	<td>
	<select name="requisitionTo" id="requisitionTo">
<option value="">select</option>
<%
for(MasDepartment department : departmentList)
{
%>
		<option value="<%=	department.getId()%>"><%=department.getDepartmentName()%></option>
	<%} %>
</select> 
	</td>
	<td><input type="text"  class="date" name="dietForDate" id="dietForDate" readonly="readonly" value="<%=date+"/"+month+"/"+year%>"    onblur="onRequisitiondateChange(this.value);" />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.dietForDate,event);" validate="Pick a date" src="/hms/jsp/images/cal.gif">
</td>

<td><input type="button" class="button" value="Select Diet" onclick="openDietCombination('1','<%=inpatient.getId() %>')" /> </td>

<td><input type="checkbox" name="extradiet1" id="extradiet1" onchange="openExtraDiet('1','<%=inpatient.getId() %>')" />
	<div id="extradiet<%=inpatient.getId() %>">	
	<input type="hidden" name="extracount<%=inpatient.getId() %>" id="extracount<%=inpatient.getId() %>" value="0" />
	</div>
	<div id="selectedDiet<%=inpatient.getId() %>">	
	<input type="hidden" name="dietCount<%=inpatient.getId() %>" id="dietCount<%=inpatient.getId() %>" value="0" />
	</div>
	</td>
	</tr>	
</table>

</div>
<div class="clear"></div>
<h4>Total Diet Required</h4>
<div class="clear"></div>

<%
int itemrequired=0;
%>
<table  id="itemrequiredTable" >
		<tr>
			<th>Item</th>
			<th>Qty</th>
			<!-- <th>Remarks</th> -->
		</tr>		
</table>
<input type="hidden" name="itemRequired" id="itemRequired" value="<%=itemrequired%>" />
	<div class="clear"></div>
<div id="prevDietDiv"></div>
</div>
</div>

<div id="country7" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div style="float: right;">
<input	type="button" class="buttonAdd" alt="Add" tabindex="4" value="&nbsp;" onclick="addRowForComorbidity();" align="right" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;"	onclick="removeRowForComorbidity();" align="right" />
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="small wdthSm">
 <table border="0" align="center" cellpadding="0" cellspacing="0" id="comorbidityGrid">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Comorbidity</th>
			<th scope="col">Since:Month</th>
			<th scope="col">Year</th>
			<th scope="col">Remarks</th>
		</tr>
		<tr>
		<td><input type="checkbox" class="radioCheck"  id="radioComorbidity1" name="radioComorbidity1" /></td>	
		<td><select  id="comorbidityType1" name="comorbidityType1"  tabindex="1">
			<option value="0">Select</option>
			</select>
		</td>
		<td><input size="20" id="comorbiditymonth1" name="comorbiditymonth1"/></td>
		<td><input size="20" id="comorbidityyear1" name="comorbidityyear1" /></td>
		<td><input size="20" id="comorbidityremarks1" name="comorbidityremarks1"  /></td>
		</tr>
	</table>
	<input type="hidden" name="comorbidityCount" id="comorbidityCount" value="1" />
	
</div>
<div style="float: right;display:none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" tabindex="1">
	<option value="0">Select</option>
</select>
</div>
</div>
</div>

<div id="country8" class="tabcontentIn">
<div class="Block">
<div class="Clear"></div>
<div class="paddingTop15"></div>

<label>Remarks</label>
<%String remarksFromOtherDoctor="";
for(WardRemarks wardRemarks:wardreamarksList){
	remarksFromOtherDoctor=remarksFromOtherDoctor.concat(wardRemarks.getRemarks());
}

%>
<textarea readonly="readonly">
<%=remarksFromOtherDoctor %>
</textarea>
<div class="clear"></div>
<%if(wardreamarksList.size()>0){ %>
<label>New Remarks</label>
<textarea name="newRemarks" cols="newRemarksId">
<%=remarksFromOtherDoctor %>
</textarea>
<%} %>
</div>
</div>
	
<!-- added by amit das on 22-07-2016 -->

<div id="country10" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>

					<%-- <label>Speciality</label> <select id="specialty" name="specialty"
						onchange="display(this.value)">
						<option value="0">Select</option>
						<%for(MasSpecialtyTemplate mstp:specialtyTemplateList){ %>
						<option value="<%=mstp.getId()%>"><%=mstp.getTemplateName()%></option>
						<%} %>
					</select> --%>
					<div id="specialityDiv"></div>
				</div>
			</div>

<div id="country9" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop25"></div>
<label>MLC certificate </label>
<select  name="mlscasetype" id="mlscasetype" multiple="multiple" class="multiple1" size="5" style="width:500px;" >
	<option value="0">Select</option>
	<!-- <option value="Police Intimation">Police Intimation</option> -->
	<option value="Examination by a Medical Officer">Certificate of Examination by a Medical Officer</option>
	<option value="Examination by a Specialist Medical Officer/Team of Specialist Medical Officers">Certificate of Examination by a Specialist Medical Officer/Team of Specialist Medical Officers</option>
	<option value="Accident Register-cum-Wound Certificate">Accident Register-cum-Wound Certificate</option>
	<%
	if(patient.getSex()!= null && patient.getSex().getAdministrativeSexCode().equals("F") && patient.getSex().getId()==2){
%>
	<option value="Examination of a female victim of sexual assault" >Report of examination of a female victim of sexual assault</option>
	<%}else{ %>
	<option value="Examination of a male accused in sexual offence">Report of examination of a male accused in sexual offence</option>
	<%} %>
	<option value="Certificate Of Drunkness">Certificate Of Drunkness</option>
	<option value="Examination of a victim alleged to have been drugged">Report of examination of a victim alleged to have been drugged</option>
	<option value="Examination for evidence of recent delivery">Report of examination for evidence of recent delivery</option>
	<option value="Examination of a victim of unnatural sexual offence" >Report of examination of a victim of unnatural sexual offence</option>
	<option value="Treatment / Discharge Certificate">Treatment / Discharge Certificate</option>
	<option value="Examination for estimation of age">Report of examination for estimation of age</option>
	<option value="Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc">Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc</option>
	<option value="Final opinion as to cause of death">Final opinion as to cause of death</option>
	<!-- <option value="Format for referring a postmortem examination to police sugeon through investigating police officer or magistrate">Format for referring a postmortem examination to police sugeon through investigating police officer or magistrate</option> -->
	<option value="Mortuary">Mortuary</option>
	<option value="Chemical Analysis">Chemical Analysis</option>
	<option value="Application cum No Objection Certificate">Form of Application cum No Objection Certificate</option>
	<!-- <option value="Application cum Certificate of Authenticity">Form of Application cum Certificate of Authenticity</option> --> <!--  commented by amit das on 03-06-2016 -->
	<!-- <option value="Request for Radiological examination as part of estimation of Age">Request for Radiological examination as part of estimation of Age</option> -->
	<!-- <option value="Proforma for recording dying declaration by a medical practitioner">Proforma for recording dying declaration by a medical practitioner</option> -->
	
	
</select>

<label>
<input type="checkbox" class="radioCheckCol2" name="policeIntimation" value="y" id="policeIntimation" />Police Intimation
</label>
</div>
</div>

<div id="country11" class="tabcontentIn" style="display: none;">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="small wdthSm" id="DMgridtreatmentDiv">
<div style="float: right;" >
<a href="#" onclick="getIPPrescriptionDetails();">IP Prescription Details</a>
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowTreatmentDM();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowTreatmentDM();">
		</div>
<div class="clear"></div>	
<table border="0" align="center" cellpadding="0" cellspacing="0" id="DMgridtreatment">
	<tr>
	    <th scope="col">&nbsp;</th>
		 <th scope="col">Drug Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">Duration</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
	</tr>
	
	<%
	int di =0;
		/* if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){
				l++; */
	%>
	<%-- <tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="DMitemRadiotreatment<%=di %>"  name="DMitemRadiotreatment<%=di %>"  />
	    </td>
		<td>
	    <input type="text" size="30" value="<%=prescriptionDetails.getItem().getNomenclature()+"("+prescriptionDetails.getItem().getId()+")"+"["+prescriptionDetails.getItem().getPvmsNo()+"]"%>" tabindex="1" id="DMnomenclaturetreatment<%=di %>" size="70"  name="DMnomenclaturetreatment<%=di %>" onblur="populatePVMSDM(this.value,'<%=di %>');checkItemDM('<%=di %>'), displayAuDM(this.value,'<%=di %>')"  />
	   	<div id="DMac2updatetreatment<%=di %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('DMnomenclaturetreatment<%=di %>','DMac2updatetreatment<%=di %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclaturetreatment<%=di %>'});
			</script>
	    </td>
		<td><input type="hidden" name="DMpvmsNotreatment<%=di %>" tabindex="1" id="DMpvmsNotreatment<%=di %>" value="<%=prescriptionDetails.getItem().getPvmsNo() %>"	size="10" readonly="readonly" />
		<input type="text" name="DMdosagetreatment<%=di %>" tabindex="1" value="<%=prescriptionDetails.getDosage()%>" id="DMdosagetreatment<%=di %>"	size="2" maxlength="5" /></td>
		<td><input type="text" size="2" name="DMunit<%=di %>" id="DMunit<%=di %>" value="<%=prescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName() %>" />
		</td>
		<td><select name="DMfrequencytreatmen<%=di %>" id="DMfrequencytreatmen<%=di %>" class=smallest tabindex="1" onclick="fillValueFromFrequencyDM(this.value,'<%=di %>');" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%}%>
		</select> 
		<script>
		document.getElementById('DMfrequencytreatmen<%=di %>').value = '<%=prescriptionDetails.getFrequency().getId()%>'
		</script>
		</td>
		
		
		<td><input type="text" name="DMnoOfDaystreatment<%=di %>" tabindex="1" id="DMnoOfDaystreatment<%=di %>" value="<%=prescriptionDetails.getNoOfDays()!=null?prescriptionDetails.getNoOfDays():"" %>" onblur="fillValueDM(this.value,'<%=di %>')"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		
		<td><select name="DMinstructiontreatment<%=di %>" id="DMinstructiontreatment<%=di %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		    	  
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
		       if(prescriptionDetails.getFrequency()!=null && prescriptionDetails.getFrequency().getId()==id)
		       {
		    	   %>
		    	   <option selected="selected" value="<%=id %>"><%=name%></option>
		    	   <%
		       }else{
          %>
			<option value="<%=id %>"><%=name%></option>
			<%}
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" name="DMspslinstructiontreatment<%=di %>" tabindex="1" id="DMspslinstructiontreatment<%=di %>" value="<%=prescriptionDetails.getSplInstruction()%>"  size="15"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		
		<td><select name="DMroutetreatment<%=di %>" id="DMroutetreatment<%=di %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
		      for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		       if(prescriptionDetails.getRoute()!=null && prescriptionDetails.getRoute().getId()==id)
		       {
		    	   %>
		    	   <option selected="selected" value="<%=id %>"><%=name%></option>
		    	   <%
		       }else{
          %>
			<option value="<%=id %>"><%=name%></option>
			<%}
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" name="DMtotaltreatment<%=di %>" tabindex="1" id="DMtotaltreatment<%=di %>" value="<%=prescriptionDetails.getTotal()%>" onblur="fillValueDM(this.value,'<%=di %>')"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		
		<td><input type="text" name="DMroute<%=di %>" tabindex="1" id="DMroute<%=di %>"  size="5" maxlength="20" value="<%=prescriptionDetails.getRoute()!=null?prescriptionDetails.getRoute():"" %>"	 validate="Route,string,no" />
			<input type="hidden" name="DMtotal<%=di %>" tabindex="1" id="DMtotal<%=di %>" value="<%=prescriptionDetails.getTotal()!=null?prescriptionDetails.getTotal():"" %>"/>
		</td>
		<td><input type="text" name="DMtreatRemarks<%=di %>" tabindex="1" id="DMtreatRemarks<%=di %>" size="10" maxlength="40" value="<%=prescriptionDetails.getRemarks()!=null?prescriptionDetails.getRemarks():"" %>"/>
			</td>
	</tr> --%>
	
	<%
			/* }}else{ */ di++;%>
	<tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="DMitemRadiotreatment<%=di %>"  name="DMitemRadiotreatment<%=di %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="30" value="" tabindex="1" id="DMnomenclaturetreatment<%=di %>"
	    name="DMnomenclaturetreatment<%=di %>" onblur="validatePrescriptionAutocompleteDM('opmain',this.value,<%=di %> );populatePVMSDM(this.value,'<%=di %>'); 
	     displayAuDM(this.value,'<%=di %>');checkForAllergyDM(this.value,<%=di %>);checkIPItemDM('<%=di%>');" onkeypress="checkTextColor('DMnomenclaturetreatment<%=di%>');" />
	   	<div id="DMac2updatetreatment<%=di %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('DMnomenclaturetreatment<%=di %>','DMac2updatetreatment<%=di %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=DMnomenclaturetreatment<%=di %>'});
			</script>
	    </td>
		<td><input type="hidden" name="DMpvmsNotreatment<%=di %>" tabindex="1" id="DMpvmsNotreatment<%=di %>" value=""	size="10" readonly="readonly" />
				<input type="hidden" name="DMactualDispensingQty<%=di%>" tabindex="1" id="DMactualDispensingQty<%=di%>" value=""  size="6"  validate="AU,string,no" />
		
		<input type="text" name="DMdosagetreatment<%=di %>" tabindex="1" value="" id="DMdosagetreatment<%=di %>"	size="2" maxlength="5" onblur="fillTotalForTreatmentDM('<%=di %>');" /></td>
		<td><input type="text" size="2" name="DMunittreatment<%=di %>" readonly="readonly" id="DMunittreatment<%=di %>" value="" />
		<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="DMmixable<%=di%>"
											id="DMmixable<%=di%>" 
											validate="mixable,string,no" />
																				
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="DMmixtureQuantity<%=di%>"
											id="DMmixtureQuantity<%=di%>" 
											validate="mixtureQuantity,int,no" />
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="DMactualTotalAfterMix<%=di%>"
											id="DMactualTotalAfterMix<%=di%>" 
											validate="actualTotalAfterMix,float,no" />
		</td>
		<td>
		<input type="hidden" name="DMfrequencyValue<%=di%>" tabindex="1" id="DMfrequencyValue<%=di%>" value=""  size="6"   />
		<input type="text" name="DMsosQty<%=di%>" tabindex="1" id="DMsosQty<%=di%>" style="display: none;"   size="3" onblur="fillValueDM(this.value,<%=di%>)"	maxlength="3" validate="Sos Qty,num,no" />
		<select name="DMfrequencytreatment<%=di %>" id="DMfrequencytreatment<%=di %>"  tabindex="1" 
<%--		 onblur="getFrequencyValue(this.value,<%=di%>);fillValueFromFrequencyDM(this.value,<%=di%>);displaySOSQty(this.value,<%=di%>)" > //commented by govind 24-12-2016--%>
		 onchange="getFrequencyValueDM(this.value,<%=di%>);fillValueFromFrequencyDM(this.value,<%=di%>);displaySOSQty(this.value,<%=di%>);fillTotalForTreatmentDM('<%=di %>');" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%}%>
		</select> 
		
		</td>
		
<%--		<td><input type="text" class="smallest" name="DMnoOfDaystreatment<%=di %>" tabindex="1" id="DMnoOfDaystreatment<%=di %>" value="" onblur="fillTotalForTreatmentDM('<%=di %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" /> //commented by govind 24-12-2016--%>
		<td><input type="text" name="DMnoOfDaystreatment<%=di %>" tabindex="1" id="DMnoOfDaystreatment<%=di %>" value="" onblur="fillValueFromFrequencyDM(this.value,<%=di%>);fillTotalForTreatmentDM('<%=di %>');"  oninput="fillValueFromFrequencyDM(this.value,<%=di%>);fillTotalForTreatmentDM('<%=di %>');" size="2"	maxlength="3" validate="Duration,num,no" />
			
		</td>
		
		<td><select name="DMinstructiontreatment<%=di %>" id="DMinstructiontreatment<%=di %>" tabindex="1" class="small" >
			<option value="0">Select</option>
			<%
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();

          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}
			%>
			
		</select> 
		
		</td>
		
		<td><input type="text" name="DMspslinstructiontreatment<%=di %>" tabindex="1" id="DMspslinstructiontreatment<%=di %>" value=""  size="15"	maxlength="50"  />
			
		</td>
		
		<td><select name="DMroutetreatment<%=di %>" id="DMroutetreatment<%=di %>" tabindex="1" class="small" >
			<option value="0">Select</option>
			<%
				for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		      
          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" name="DMtotaltreatment<%=di %>" tabindex="1" id="DMtotaltreatment<%=di %>" value="" onblur="fillTotalForTreatmentDM('<%=di %>')"  size="2"	maxlength="3" validate="Total,num,no" readonly="readonly" />
			
		</td>
		
		
	</tr>
<%-- <%} %> --%>
	<%
	//int l =0;
		/* if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){ */
				//l++;
	%>	
	
	
</table>
<input type="hidden" name="DMhdb" value="<%=di %>" id="DMhdbtreatment" />
</div>
</div>
</div>

<div id="country12" class="tabcontentIn">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>Clinical Summary</h4>
<div class="clear"></div>

<label>From Date</label>
<input type="text"	name="fromDateId" id="fromDateId" onfocus="FDate(<%=date%>,<%=month%>,<%=year%>);" value="<%=date+"/"+month+"/"+year%>" readonly="readonly" class="dateTextSmall" />
 <img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.fromDateId,event);" />

<label>To Date</label>
<input type="text" id="toDateId" name="toDateId" class="dateTextSmall" onfocus="TDate(<%=date%>,<%=month%>,<%=year%>),DateCheck(<%=date%>,<%=month%>,<%=year%>);" value="<%=date+"/"+month+"/"+year%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=date+"/"+month+"/"+year%>',document.ipdCaseSheet.toDateId,event);" />
	
<input type="button" name="search" value="Search" class="button" onClick="submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getClinicalSummaryHistoryData','clinicalSummaryDiv');" />	
<div class="clear"></div>


<div id="clinicalSummaryDiv">

<div class="summaryDivMain">
<label>Previous Complaints</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>History</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Systemic Examination</label>
<div class="summaryDetails"><p></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Findings</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Investigations</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Prescription</label>
<div class="summaryDetails"><p></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Diagnosis</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Treatment</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Previous Ip Details</label>
<div class="summaryDetails"><p></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Procedure done</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="clear"></div>
</div>
</div>

</div>
			
<script type="text/javascript">	var	frequencyArray= new Array();
                 <%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %>

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
     			frequencyArray[<%=k%>][2] = "<%=frequency.getFrequencyType() != null?frequency.getFrequencyType():""%>";
     			<% }%> 
            </script> 
            
            <script type="text/javascript">	var	roteArray= new Array();
              <%
	    		RouteOfAdministration  route = new RouteOfAdministration();

			     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
			    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
     			 %> 

     			roteArray[<%=k%>]= new Array();
     			roteArray[<%=k%>][0] = "<%=route.getId()%>";
     			roteArray[<%=k%>][1] = "<%=route.getRouteName()%>";
     			<% }%> 
            </script> 
            
             <script type="text/javascript">	var	instructionArray= new Array();
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
             <script type="text/javascript">	var	allergyTypeArray= new Array();
                      <%
				         for (int k = 0; k < allergyProductsList.size(); k++) {
				        	 MasAllergyProduct  masAllergyProduct = (MasAllergyProduct) allergyProductsList.get(k);
	     			 %> 
	     			allergyTypeArray[<%=k%>]= new Array();
	     			allergyTypeArray[<%=k%>][0] = "<%=masAllergyProduct.getId()%>";
	     			allergyTypeArray[<%=k%>][1] = "<%=masAllergyProduct.getProductName()%>";
	             <% }%>
	             </script>
	             <script type="text/javascript">	var	saverityCodeArray= new Array();
	            
	            <%
				         for (int k = 0; k < saverityCodesList.size(); k++) {
				        	 MasSeverityCode  masSeverityCode = (MasSeverityCode) saverityCodesList.get(k);
	     			 %> 
	     			saverityCodeArray[<%=k%>]= new Array();
	     			saverityCodeArray[<%=k%>][0] = "<%=masSeverityCode.getId()%>";
	     			saverityCodeArray[<%=k%>][1] = "<%=masSeverityCode.getSeverityName()%>";
	             <% }%>
	             </script>
	             
	             <script type="text/javascript">	var	nursingCareSetupList= new Array();
                 <%

			     for (int k = 0; k < nursingCareList.size(); k++) {
			    	 MasNursingCare nursingCare = (MasNursingCare) nursingCareList.get(k);
     			 %>

     			nursingCareSetupList[<%=k%>]= new Array();
     			nursingCareSetupList[<%=k%>][0] = "<%=nursingCare.getId()%>";
     			nursingCareSetupList[<%=k%>][1] = "<%=nursingCare.getNursingName()%>";
     			<% }%> 
            </script> 
            

 <div class="Block">
  <div class="clear"></div>           
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
 
<label>Ready to Discharge</label>
<%
	if(readyToDischarge.equals("R")){
%>
<input type="checkbox" value="y" id="readyToDischarge" class="checkboxMargin" checked="checked" disabled="disabled">
<input type="hidden" value="y" name="readyToDischarge">
<script>
document.getElementById('dischargeLink').style.display = "block";
</script>
 <%}else{  %>
<input type="checkbox" value="y" name="readyToDischarge" id="readyToDischarge" onclick="checkForPendingService(<%=inpatientId %>);" class="checkboxMargin">
<script>
document.getElementById('country11').style.display = "none";
</script>
 <%} %>


<label>Ambulance Request</label>
<%if(ambulanceRegistersList.size()>0){ %>
<input type="checkbox" value="y" name="ambulanceregister" id="ambulanceregister" class="checkboxMargin" checked="checked">
<%}else {%>
<input type="checkbox" value="y" name="ambulanceregister" id="ambulanceregister" class="checkboxMargin">
<%} %>

<label class="medium">Patient Dead</label>
<%if(expiryDetailsList.size()>0){ %>
<input type="checkbox" value="y" name="deadPatient" id="deadPatientId" onclick="displayExpiryDetails();" checked="checked" class="checkboxMargin">
<input type="button" name="expiryDetails" id="expiryDetails"  class="button" value="Expiry Details" onclick="openPopupWindowForExpiryDetails('<%=inpatient.getAdNo()%>','<%=inpatient.getId()%>');"	/>
<%}else{ %>
<input type="checkbox" value="y" name="deadPatient" id="deadPatientId" onclick="displayExpiryDetails();" class="checkboxMargin">
<input type="button" name="expiryDetails" id="expiryDetails"  class="button" style="display: none;" value="Expiry Details" onclick="openPopupWindowForExpiryDetails('<%=inpatient.getAdNo()%>','<%=inpatient.getId()%>');"	/>

<%} %>

<label class="medium">Refer</label>
<input type="checkbox" value="" name="referToName" id="referToId" onclick="getReferDoctors();" class="checkboxMargin"/>
<input type="hidden" value="" name="referToName1" id="referToId1" />
<div id="referDivId" style="display: none;">
<label class="medium">Doctor</label>
<select name="docName" id="docNameId">
<option value="0">Select</option>
<%for(Object[] me:employeeList){ %>
<option value="<%=me[0] %>"><%=me[1] %></option>
<%} %>
</select>
<div class="clear"></div>
<label>Remarks By Doctor</label>
<textarea name="remarksBYDoc" id="remarksBYDocId"></textarea>
</div>
<div class="clear"></div>
<div class="clear paddingTop25"></div>
<div class="clear"></div> 
</div>


<%-- <input type="hidden" name="ageName" value="<%=inpatient.getAge() %>" id="ageId" /> 
<input type="hidden" name="genderId" id="genderId" value="<%=patient.getSex().getId() %>"> --%>
<div class="division"></div>
  <div class="Block">
<input type="button"	name="sss" class="button" value="Submit" onclick="validatecaseNote();" style="margin-left:5px;" />
<input type="button" class="button" value="Back" onClick="submitForm('ipdCaseSheet','ipd?method=showPatientListJsp');" />
<%
if(ageunit.trim().equalsIgnoreCase("days") || ageunit.trim().equalsIgnoreCase("months")){
if(motherHinNo != null && !motherHinNo.equals("")){	
	%>

<input type="button"	name="sss" class="buttonBig" value="View Mother CashSheet" onclick="submitForm('ipdCaseSheet','ipd?method=showPatientMedicalCaseSheetReportNew&hinNo=<%=motherHinNo%>&inpatientId=<%=motherInpatientId %>');" style="margin-left:5px;" />
<!--  <input type="button"	name="sss" class="buttonBig2" value="View Discharge Summary" onclick="submitForm('ipdCaseSheet','discharge?method=viewDischargeSummary&motherHinNo=<%=motherHinNo%>');" style="margin-left:5px;" />-->
<%}} %> 
<input type="reset" name="reset" value="Reset" class="button" onclick="submitFormForButton('ipdCaseSheet','ipd?method=showCaseSheetJsp&parent=<%=inpatient.getId()%>');" />	
<div class="clear"></div>
<div class="division"></div>
</div>

<input type="hidden" name="time" value="<%=time %>">
<input type="hidden" name="currentDate" value="<%=currentDate %>">

</div>
 <div  style="display: none;">
						<table id="taperedMedicne1">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
	<input type="hidden" id="taperedMedicineHdb1" name="taperedMedicineHdb" value="0"/>
</div>
</form>
<form action="" name="taperedForm"  style="display: none;">
							<!-- added by govind for tapered Medicine -->
						<div>
						<table id="taperedMedicne">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						</div>
						<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb" value="0"/>
						<!-- added by govind for tapered Medicine -->
	</form>

<div id="vitalDialog" title="Vital Trends" style="display:none;">
  <label class="auto">UHID</label><input type="text" id="vitalUHID" class="auto" readonly="readonly"/>
  <label class="auto">Patient Name</label><input type="text" id="vitalPname" class="auto" readonly="readonly"/>	
  <div class="clear"></div>
  <table id="vitalTable"></table>
  <div class="clear"></div>
  <!-- <div id="chartContainer" style="height: 300px; width: 100%;"></div> -->
</div>
<script>

// loadRelatedPackages();
function displayExpiryDetails(){
	if(document.getElementById('deadPatientId').checked==true){
		document.getElementById('expiryDetails').style.display="inline";
	}else{
		document.getElementById('expiryDetails').style.display="none";
	}
	}

function fnShowHideMLCTab(){
	if(document.getElementById("mlcCheck").checked)
		document.getElementById("mlcTab").style.display='block';
	else	
		document.getElementById("mlcTab").style.display='none';
}

function checkTab(tab){
	document.getElementById("tab").value=tab;	
}

function validateRows(){
	if(document.getElementById('caseNotes').value==''){
		alert("Please enter Case Notes.");
		return false;
	}

	
	var treatCount = document.getElementById('hdb').value;
//	var therapyCount = document.getElementById('therapyCount').value;
	if(treatCount>0){
		for(var i =1;i<=treatCount;i++){
			if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value!=''){
				if(document.getElementById('frequency'+i)){
					if(document.getElementById('frequency'+i).value == '0'){
						alert('Please select frequency for treatment in row '+i);
						return false;
					  }
					 }
					
					if(document.getElementById('dosage'+i)){
					if(document.getElementById('dosage'+i).value == ''){
						alert('Please enter dosage for treatment in row '+i);
						return false;
					 }
					}
					
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value == ''){
						alert('Please enter noOfDays for treatment in row '+i);
						return false;
					 }
					}
					if(document.getElementById('noOfDays'+i).value!="")
					{
					if( isNaN(document.getElementById('noOfDays'+i).value))
			    	{
			        	alert("Duration should be number");
			        	return false;
			    	 }
					 }
				   }
			}
		
	}

/*	if(therapyCount>0){
		for(var j =1;j<=therapyCount;j++){
			if(document.getElementById('therapyTypeId'+j) && document.getElementById('therapyTypeId'+j).value!=''){
				if(document.getElementById('frequencyId'+j)){
					if(document.getElementById('frequencyId'+j).value == '0'){
						alert('Please select frequency for therapy in row '+j);
						return false;
					  }
					 }
					
					if(document.getElementById('durationId'+j)){
					if(document.getElementById('durationId'+j).value == ''){
						alert('Please enter therapy duration in row '+j);
						return false;
					 }
					}
					
					if(document.getElementById('phyNoOfDays'+j)){
					if(document.getElementById('phyNoOfDays'+j).value == ''){
						alert('Please enter noOfDays for therapy in row '+j);
						return false;
					 }
					}
					if(document.getElementById('phyNoOfDays'+j).value!="")
					{
					if( isNaN(document.getElementById('phyNoOfDays'+j).value))
			    	{
			        	alert("No. of Days should be number");
			        	return false;
			    	 }
					 }
				   }
			}

		
	}*/
	return true;
}

function removeRow(idName,obj)
{
  var tbl = document.getElementById(idName);
  var lastRow = tbl.rows.length;
  if (lastRow > 1){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}


function fillDiagnosisCombo(val) {

         
	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		   
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
                   var valu=obj.options[obj.length-1].value;
					var b="false";
					for(var i=1;i<obj.length;i++){
							    
		                    	var val1=obj.options[i].value;
		                    	var length=obj.length-1;
                               	
		                    	if(id==val1)
		                    	{
		                        	alert("ICD  Already taken");
		                        	document.getElementById('icd').value =""
		                        	b=true;
		                       	}
		                              	
		                    }
                   
		                    if(b=="false")
		                    {
		                    	obj.length++;
		    					obj.options[obj.length-1].value=id
		    					obj.options[obj.length-1].text=val
		    					obj.options[obj.length-1].selected=true
		    					document.getElementById('icd').value =""
		    			                    
		                    }
				}
			
	  }

function populatePVMS(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);

	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclaturetreatment'+inc).value="";
	    document.getElementById('pvmsNotreatment'+inc).value="";
	    document.getElementById('dosagetreatment'+inc).value="";
	      document.getElementById('noOfDaystreatment'+inc).value="";
	      document.getElementById('unittreatment'+inc).value="";
	   return;
	   }
	   else
		   {
	      document.getElementById('pvmsNotreatment'+inc).value=pvmsNo;
	      document.getElementById('dosagetreatment'+inc).value=1;
	      document.getElementById('noOfDaystreatment'+inc).value=1;
	      
	      new Ajax.Request('ipd?method=updateItemUnit&pvmsNo='+pvmsNo+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  var str=response.responseText.trim().split("###");
	    	    	  document.getElementById('unittreatment'+inc).value=str[0];
	    	    	  document.getElementById('routetreatment' + inc).value = str[2]!=undefined?str[2]:"0";

					 //added by govind on 25-10-2017 for Tapered Medicine
	    	    	  document.getElementById('tapered' + inc).value = str[3]!=undefined?str[3]:"n";
						if(document.getElementById('tapered' + inc)!=null && document.getElementById('tapered' + inc).value=='y' ){
							var nomenclature=document.getElementById('nomenclaturetreatment' + inc).value;
							var index1 = nomenclature.lastIndexOf("[");
							var index2 = nomenclature.lastIndexOf("]");
							index1++;
							var id = nomenclature.substring(index1, index2);
							var count = document.getElementById('hdbtreatment').value;
							var alrady=0;
							for (var i = 0; i < count; i++) {
								if (document.getElementById('nomenclaturetreatment' + i) != null
										&& document.getElementById('nomenclaturetreatment' + i).value == nomenclature
										&& i != inc) {
										alert('This Prescription is already selected.');
										alrady++;
										document.getElementById('nomenclaturetreatment' + inc).value = "";
								}
								
							}
							/*var alPres= document.getElementById('alreadyPres' + inc).value;
							if(alPres=="Y"){
								alrady++;
							}*/
							if(alrady==0){
								var first = nomenclature.lastIndexOf("(");
								var second = nomenclature.lastIndexOf(")");
								first++;
								var itemId = val.substring(first, second);
								//alert("itemId "+itemId);
								var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&row='+inc+'&type=IP'+'&' + csrfTokenName + '='
								+ csrfTokenValue;
								openTaperedMedicine(url);
							}
						}
						 //added by govind on 25-10-2017 for Tapered Medicine end
	    	    	  }
	    	  }
	    	});
	 }
	}
	else
		{
		document.getElementById('nomenclaturetreatment'+inc).value="";
	    document.getElementById('pvmsNotreatment'+inc).value="";
	    document.getElementById('dosagetreatment'+inc).value="";
	      document.getElementById('noOfDaystreatment'+inc).value="";
	      document.getElementById('unittreatment'+inc).value="";
	      }
}
function getProcedureId(val,inc){
	if(val!=''){
		var index1 = val.indexOf("[");
		var index2 = val.indexOf("]");
		index1++;
		var procName = val.substring(0,index1-1);
		var procId = val.substring(index1,index2);
		
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procCode = val.substring(index1,index2);
		document.getElementById('procedure'+inc).value=procName;
		document.getElementById('procedureId'+inc).value = procId;
		document.getElementById('procedurecode'+inc).value = procCode;
		
		
	}else{
		if(document.getElementById('procedure'+inc)){
	      	document.getElementById('procedure'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	document.getElementById('proDtId'+inc).value="";
	      	document.getElementById('procRemarks'+inc).value="";
	      	document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}

function getTheraphyId(val,inc){
	if(val != ""){
			
			var index1 = val.lastIndexOf("[");
			var indexForTheraphyCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var therapyId = val.substring(index1,index2);
			var indexForTheraphyCode = indexForTheraphyCode--;
			var theraphyCode = val.substring(0,indexForTheraphyCode);

			 
			if(therapyId == "" ) {
		      	document.getElementById('therapyTypeId'+inc).value="";
		      	return;
			}
		if(therapyId!=""){
			submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getTheraphyId&counter='+inc+'&therapyId='+therapyId,'therapyDiv'+inc);
		}
	}else{
	
		if(document.getElementById('therapyTypeId'+inc)){
			document.getElementById('therapyTypeId'+inc).value="";
	      	document.getElementById('therapyId'+inc).value="";
	      	document.getElementById('durationId'+inc).value="";
	    	document.getElementById('frequencyId'+inc).value="0";
	      	document.getElementById('phyNoOfDays'+inc).value="";
	      	document.getElementById('remarks'+inc).value="";
			}

	}
		
	}

function addRow(){
	  
	  var tbl = document.getElementById('grid');
	 
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);displayAu(this.value,iteration);
						   }
	  					  };
	  
	    var newdiv = document.createElement('div');
      	newdiv.setAttribute('id', 'ac2update1'+iteration);
      	newdiv.setAttribute('class', 'autocomplete');
       	newdiv.style.display = 'none';
        e0.size = '40';
 
	  e0.setAttribute('tabindex','1');
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv);
	
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update1'+iteration,'opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+iteration});
	  var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='dosage'+iteration;
	  e3.id='dosage'+iteration
	  e3.size='2';
	  e3.setAttribute('maxlength', 5); 
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('Select');

	  e2.name='treatmentFrequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className="small";
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onclick=function(){fillValueFromFrequency(this.value,iteration);}

	   for(var i = 0;i<frequencyArray.length;i++ ){
	      e2.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	      }
	  cellRight2.appendChild(e2);
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight2.appendChild(sel);
	
	 

	  
	  var cellRight3 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='2';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','Duration,int,no');

	  e4.onblur=function(){fillValue(this.value,iteration);	}
	  cellRight3.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight3.appendChild(e5);



		var cellRight4 = row.insertCell(4);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.value='PO';
		e6.size='5';
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight4.appendChild(e6);

	  var cellRight5 = row.insertCell(5);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='treatRemarks'+iteration;
	  e7.id='treatRemarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight5.appendChild(e7);

	  var cellRight6 = row.insertCell(6);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='add'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight6.appendChild(e8);

	  var cellRight7 = row.insertCell(7);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='del'+iteration;
	  e9.onclick = function(){removeRow('grid',this);};
	  e9.setAttribute('tabindex','1');
	  cellRight7.appendChild(e9);


	}


function addRowForInvestigation(){
    
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  
	  var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='investigationtradio'+iteration;
		e1.id='investigationtradio'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
   
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.style.width="400px";
	  e0.onblur=function(){
	  						if(validateInvestigationAutoComplete(this.value,iteration)){disablePkgFlag('isPackageFlag'+iteration);checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  e0.size = '40'
	  
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv1);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2'+iteration,'opd?method=getInvestigationListForAutoComplete',
			  {minChars:3, 
		  callback: function(element, entry) {
            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
        },parameters:'requiredField=chargeCodeName'+iteration+'&fromOpd=fromOpd'});
	  
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	  
	  var cellRight1 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='chargecodeclinicalnote'+iteration;
	  e3.id='chargecodeclinicalnote'+iteration
	//  e3.size='10';
	  e3.style.width="350px";
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);
	  
	  
	  // Added by Amit Das on 08-03-2016
	  var e4 = document.createElement('input');
	  e4.type = 'hidden';
	  e4.name='isPackageFlag'+iteration;
	  e4.id='isPackageFlag'+iteration
	  e4.size='10';
	  e4.setAttribute('tabindex','1');
	  cellRight1.appendChild(e4);
	  
	// Added by Amit Das on 09-03-2016
	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='pkgServiceCharge'+iteration;
	  e5.id='pkgServiceCharge'+iteration
	  e5.size='10';
	  e5.setAttribute('tabindex','1');
	  cellRight1.appendChild(e5);
	  
	// Added by Amit Das on 09-03-2016
	  var e6 = document.createElement('input');
	  e6.type = 'hidden';
	  e6.name='serviceSchemeId'+iteration;
	  e6.id='serviceSchemeId'+iteration
	  e6.size='10';
	  e6.setAttribute('tabindex','1');
	  cellRight1.appendChild(e6);
	
	}


<%-- function addProcedureRow(){
		
		  var tbl = document.getElementById('proceduregrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('procCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  
		  var cellRight1 = row.insertCell(0);
			var e1 = document.createElement('input');
			e1.type = 'checkbox';
			e1.name='Procedureradio'+iteration;
			e1.id='Procedureradio'+iteration;
			e1.className='radioCheck';
			cellRight1.appendChild(e1);
			
		  var cell1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '30';
		  e1.tabindex='1';
		  e1.name='procedure'+iteration;
		  e1.id='procedure'+iteration
		  e1.onblur=function() {getProcedureId(this.value,iteration);}

		  var newdiv = document.createElement('div');
	      newdiv.setAttribute('id', 'ac2update3'+iteration);
	      newdiv.setAttribute('class', 'autocomplete');
	      newdiv.style.display = 'none';
	      cell1.appendChild(newdiv);
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('procedure'+iteration,'ac2update3'+iteration,'ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=procedure'+iteration});
	       	
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='procedureId'+iteration;
		  e11.id='procedureId'+iteration
		  cell1.appendChild(e11);
		  
		  var e12 = document.createElement('input');
		  e12.type = 'hidden';
		  e12.name='proDtId'+iteration;
		  e12.id='proDtId'+iteration
		  cell1.appendChild(e12);

		  var cell2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='procedurecode'+iteration;
		  e2.id='procedurecode'+iteration
		  e2.tabindex='1';
		  e2.size = '30';
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(3);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='procedureTentativedate'+iteration;
		  e2.id='procedureTentativedate'+iteration
		  e2.tabindex='1';
		  e2.className='date';
		  e2.maxlegth="30"
		e2.value="<%=date+"/"+month+"/"+year%>"
		  e2.readOnly =true;
		  cell2.appendChild(e2);
		  
		  var e3 = document.createElement('img');
		  e3.width='16';
		  e3.height='16';
		  e3.border='0';
		  e3.src="/hms/jsp/images/cal.gif";
		  e3.onclick=function(){setdate(<%=date+"/"+month+"/"+year%>,e2,event)};
		  cell2.appendChild(e3);
		  //onclick="javascript:setdate('24/04/2015',document.ipdCaseSheet.procedureTentativedate1,event)" >

		 
		  
		  var cell6 = row.insertCell(4);
		  var e21 = document.createElement('input');
		  e21.type = 'text';
		  e21.name='procRemarks'+iteration;
		  e21.id='procRemarks'+iteration
		  e21.maxlegth="50"
		  e21.size = '30';
		  e21.setAttribute('tabindex','1');
		  cell6.appendChild(e21);
		  
		 /*  var cell7 = row.insertCell(6);
		  var e31 = document.createElement('input');
		  e31.type = 'button';
		  e31.className = 'buttonAdd';
		  e31.name='Button'+iteration;
		  e31.setAttribute('onClick', 'addProcedureRow();'); 
		  e31.setAttribute('tabindex','1');
		  cell7.appendChild(e31);

		  var cell8 = row.insertCell(7);
		  var e41 = document.createElement('input');
		  e41.type = 'button';
		  e41.className = 'buttonDel';
		  e41.name='delete'+iteration;
		  e41.onclick = function(){removeRow('proceduregrid',this);};
		  e41.setAttribute('tabindex','1');
		  cell8.appendChild(e41); */
} --%>


function addPhysiotherapyRow(){
		
		  var tbl = document.getElementById('therapygrid');
		  var lastRow = tbl.rows.length;

		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('therapyCount');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;
		  
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '30';
		  e1.name='therapyType'+iteration;
		  e1.id='therapyTypeId'+iteration
		  e1.onblur=function() {getTheraphyId(this.value,iteration);}

		  var newdiv = document.createElement('div');
	      newdiv.setAttribute('id', 'ac2update4'+iteration);
	      newdiv.setAttribute('class', 'autocomplete');
	      newdiv.style.display = 'none';
	      cell1.appendChild(newdiv);
		  cell1.appendChild(e1);
		  new Ajax.Autocompleter('therapyTypeId'+iteration,'ac2update4'+iteration,'opd?method=getTherapyTypeListForAutoComplete',{parameters:'requiredField=therapyType'});
		  
		  var e11 = document.createElement('input');
		  var ediv = document.createElement('div');
		  ediv.id='therapyDiv'+(iteration);
		  e11.type = 'hidden';
		  e11.name='therapyId'+iteration;
		  e11.id='therapyId'+iteration
		  cell1.appendChild(ediv);
		  cell1.appendChild(e11);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='duration'+iteration;
		  e2.id='durationId'+iteration
		  e2.size = '2'
		  cell2.appendChild(e2);

		  var cell3 = row.insertCell(2);
		  cell3.innerHTML='min'
			  
		  var cell14 = row.insertCell(3);
		  var e3 = document.createElement('Select');

		  e3.name='frequencyId'+iteration;
		  e3.id='frequencyId'+iteration;
		  e3.classname='smalllabel';
		  e3.setAttribute('tabindex','1');
		  e3.options[0] = new Option('Select', '0');
		   for(var i = 0;i<frequencyArray.length;i++ ){
		      e3.options[i+1] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		      }
		   cell14.appendChild(e3);

		  var cell15 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='phyNoOfDays'+iteration;
		  e4.id='phyNoOfDays'+iteration;
		  e4.size='3';
		  e4.setAttribute('maxlength', 3); 
		  e4.setAttribute('tabindex','1');
		  e4.setAttribute('validate','No. of days,int,no');
		  cell15.appendChild(e4);
		  
		  var cell6 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name='remarks'+iteration;
		  e5.id='remarks'+iteration
		  e5.size = '30';
		  e5.setAttribute('tabindex','1');
		  cell6.appendChild(e5);
		  
		  var cell7 = row.insertCell(6);
		  var e6 = document.createElement('input');
		  e6.type = 'button';
		  e6.className = 'buttonAdd';
		  e6.name='Button'+iteration;
		  e6.setAttribute('onClick', 'addPhysiotherapyRow();'); 
		  e6.setAttribute('tabindex','1');
		  cell7.appendChild(e6);

		  var cell8 = row.insertCell(7);
		  var e7 = document.createElement('input');
		  e7.type = 'button';
		  e7.className = 'buttonDel';
		  e7.name='delete'+iteration;
		  e7.onclick = function(){removeRow('therapygrid',this);};
		  e7.setAttribute('tabindex','1');
		  cell8.appendChild(e7);
}


function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
//	document.getElementById('testDivDown').innerHTML = "";
	if(flag == 'rhLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'&'+csrfTokenName+'='+csrfTokenValue,'newWindow','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rdRadio'){
		//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
		window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'&'+csrfTokenName+'='+csrfTokenValue,'newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rhSenLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'&'+csrfTokenName+'='+csrfTokenValue,'newWindow','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
		//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
	}
	if(flag == 'rEntryDetailLab'){
		if(resultType == 's'){
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'&'+csrfTokenName+'='+csrfTokenValue,'newWindow','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
		}else{
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'&'+csrfTokenName+'='+csrfTokenValue,'newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
		}
	}
}
function deleteDgItems(value){
    if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){
	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex);
	    }
	   }
    }
function  fillValue(value,inc){
	  var freq=document.getElementById('frequency'+inc).value;
	  var dosage=document.getElementById('dosage'+inc).value;
	  //added by amit das on 19-11-2016
		var mixable = document.getElementById('mixable' + inc).value;
		var mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
		var mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
		var dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
		// condition added by amit das on 19-11-2016 
		if(mixable=='Y'){
			var finalQty;
			// var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
			actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(noOfDays*value*dosage);
			if(actualFinalQty != '0.00'){
				finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
			}
			document.getElementById('total' + inc).value = total;
			document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
			
		} else {
	  			document.getElementById('total'+inc).value=freq*value*dosage;
		}
	 }
	 
//function  fillValueFromFrequency(value,inc){//changed by govind 24-12-2016
function  fillValueFromFrequency(inc){
   var noOfDays=document.getElementById('noOfDays'+inc).value;
  var dosage=document.getElementById('dosage'+inc).value;
  var frequency=document.getElementById('frequencyValue'+inc).value;//changed by govind 24-12-2016
    //added by amit das on 19-11-2016
	var mixable = document.getElementById('mixable' + inc).value;
	var mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
	var mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
		
	var dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
	// condition added by amit das on 19-11-2016 
	var total = noOfDays*frequency*dosage;
	if(mixable=='Y'){
		var finalQty;
		//var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
		actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(total);
		if(actualFinalQty != '0.00'){
			finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
		}
		document.getElementById('total' + inc).value = total;
		document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
		
	} else {
  			document.getElementById('total'+inc).value=noOfDays*value*dosage;
	}
 }
 
function  fillTotalForTreatment(inc){
	    if(!isNaN(document.getElementById('noOfDaystreatment'+inc).value) 
	    		&& !isNaN(document.getElementById('dosagetreatment'+inc).value)
	    		&& !isNaN(document.getElementById('frequencytreatment'+inc).value) 
	    		&& document.getElementById('frequencytreatment'+inc).value>0)
	    	{
	    	
	    	// added by amit das on 19-11-2016
	    	if(document.getElementById('mixable' + inc)!=null){
			var mixable = document.getElementById('mixable' + inc).value;
	    	}
			if(document.getElementById('mixable' + inc)!=null){
			var mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
			}
			if(document.getElementById('mixable' + inc)!=null){
			var mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
			}
			if(document.getElementById('mixable' + inc)!=null){
			var dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
			}
	    	var selectedFrequency=0;
	    		 for(var i = 0;i<frequencyArray.length;i++ ){
	    			 if(frequencyArray[i][0]==document.getElementById('frequencytreatment'+inc).value)
	    				 {
	    				 selectedFrequency=frequencyArray[i][2];
	    				 break;
	    				 }
	    			}
	    		 if(selectedFrequency!=0)
	    			 {
	    			// condition added by amit das on 19-11-2016 
	 				if(mixable=='Y'){
	 				//	var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
	 					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency);
	 					if(actualFinalQty != '0.00'){
	 						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
	 					}
	 					document.getElementById('totaltreatment' + inc).value = Math.round(document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency); 
	 					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
	 					
	 				} else {
	    			 document.getElementById('totaltreatment'+inc).value=Math.round(document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency); 
	 				} 
	 				}
	    	}
	 }
function  fillTotalForTreatmentDM(inc){
    if(!isNaN(document.getElementById('DMnoOfDaystreatment'+inc).value) 
    		&& !isNaN(document.getElementById('DMdosagetreatment'+inc).value)
    		&& !isNaN(document.getElementById('DMfrequencytreatment'+inc).value) 
    		&& document.getElementById('DMfrequencytreatment'+inc).value>0)
    	{
    	
    	// added by amit das on 19-11-2016
    	if(document.getElementById('DMmixable' + inc)!=null){
		var mixable = document.getElementById('DMmixable' + inc).value;
    	}
		if(document.getElementById('DMmixable' + inc)!=null){
		var mixtureUnit = document.getElementById('DMmixtureUnit' + inc).value;
		}
		if(document.getElementById('DMmixable' + inc)!=null){
		var mixtureQuantity = document.getElementById('DMmixtureQuantity' + inc).value;
		}
		if(document.getElementById('DMmixable' + inc)!=null){
		var dispenseQty = document.getElementById('DMactualDispensingQty' + inc).value;
		}
    	var selectedFrequency=0;
    		 for(var i = 0;i<frequencyArray.length;i++ ){
    			 if(frequencyArray[i][0]==document.getElementById('DMfrequencytreatment'+inc).value)
    				 {
    				 selectedFrequency=frequencyArray[i][2];
    				 break;
    				 }
    			}
    		 if(selectedFrequency!=0)
    			 {
    			// condition added by amit das on 19-11-2016 
 				if(mixable=='Y'){
 				//	var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
 					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency);
 					if(actualFinalQty != '0.00'){
 						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
 					}
 					document.getElementById('DMtotaltreatment' + inc).value = Math.round(document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency); 
 					document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
 					
 				} else {
    			 document.getElementById('DMtotaltreatment'+inc).value=Math.round(document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency); 
 				} 
 				}
    	}
 }

function openPopupProcedureAdviceWindow(inpatientId,hinId,doctorId)
{
 var url="/hms/hms/ipd?method=showIPProcedureListJsp&inpatientId="+inpatientId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=ipd&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
}
function openPopupWindowForExpiryDetails(adNo,inpatientId)
{
	
	//var url="/hms/hms/opd?method=showDiagnosisPopUp&"+csrfTokenName+"="+csrfTokenValue;
 var url="/hms/hms/adt?method=showExpiryDetails&adNo="+adNo+"&inpatientId="+inpatientId+"&flagJsp=popup&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'name',"left=100,top=60,height=500,width=1045,status=1,scrollbars=1,resizable=0");
}

function openPopupPhysiotheraphyAdviceWindow(inpatientId,hinId,doctorId)
{
 var url="/hms/hms/opd?method=showPhysiotherapyListJsp&inpatientId="+inpatientId+"&hinId="+hinId+"&doctorId="+doctorId+"&flag=ipd&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,'name',"left=1,top=100,height=300,width=900,status=1,scrollbars=1,resizable=0");
	 //alert("Physiotheraphy Advice ....");
}
function showHideInvestigationTemplateCombo(valueOfTemplate){
	
	if(checkTemplateId(valueOfTemplate)){
		
			submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=showGridForInvestigation','gridview');
			
			}

}

function checkTemplateId(templateId){
	
  if(templateId=="0"){
    return true;
  }else{
    return true;
  }
}

function getListForTreatment(val){
	if(val=='investigationDiv'){
		submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
	}else if(val=='treatmentDiv'){
		submitProtoAjaxWithDivName('ipdCaseSheet','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
	}
}

function showCreateInvestigationTemplate(){
    
    document.getElementById("investigationImportButton1").style.display='inline'
  	var url="/hms/hms/opd?method=showCreateInvestigationTemplate&"+csrfTokenName+"="+csrfTokenValue;
   newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
  

}
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()


function showDiagnosis()
    {
    		   	var url="/hms/hms/opd?method=showDiagnosisPopUp&"+csrfTokenName+"="+csrfTokenValue;
    		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
    		  
    }
function showVaitalDetail()
{
		   	var url="/hms/hms/ipd?method=showViewVitalPopUp&inpatientId="+<%=inpatient.getId()%>+"&"+csrfTokenName+"="+csrfTokenValue;
		   newwindow=window.open(url,'Diagnosis',"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
		
}
    
    
    function expandCollaps(obj)
    {
    	if(obj.parentNode.getElementsByClassName("collaps").length>=1)
    		{
    		obj.parentNode.getElementsByTagName("img")[0].src="../jsp/images/minusIcon.png";
    		obj.parentNode.getElementsByClassName("collaps")[0].setAttribute("class", "expand");
    		}
    	else if(obj.parentNode.getElementsByClassName("expand").length>=1)
    		{
    		obj.parentNode.getElementsByTagName("img")[0].src="../jsp/images/plusIcon.png";
    		obj.parentNode.getElementsByClassName("expand")[0].setAttribute("class", "collaps");
    		}
    		
    //alert(obj.parentNode.getElementsByClassName("collaps").length);	
     }
    
    
    

    
    //code for history templet
	 
	 function getPresentTemplate()
{
var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrfTokenName+'='+csrfTokenValue;
popwindow(url);
} 
	 
	 function getFamilyHistoryTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpFamilyHistory&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 
	 function getHistoryOfPastIllnessTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpHistoryOfPastIllness&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 
	 function getPersonalHistoryTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpPersonalHistory&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 
	 function getMedicationHistoryTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpMedicationHistory&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 }
	 function getGeneralExaminationTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpGeneralExamination&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 } 
	 
	 function getSystemicExaminationTemplate()
	 {
	 var url='/hms/hms/opd?method=showPopUpSystemicExamination&'+csrfTokenName+'='+csrfTokenValue;
	  popwindow(url);
	 } 
	 
	 function getLocalExaminationTemplate()
	 {
		 var url='/hms/hms/opd?method=showPopUpLocalExamination&'+csrfTokenName+'='+csrfTokenValue;
		  popwindow(url);
	 }
	 
var newwindow;
function popwindow(url)
{
newwindow=window.open(url,'name','height=500,width=800,status=1');
if (window.focus) 
{
newwindow.focus()
}
newwindow.createPopup();

}


function addRowTreatmentDM(){
	var tbl = document.getElementById('DMgridtreatment');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('DMhdbtreatment');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='DMitemRadiotreatment'+iteration;
	e1.id='DMitemRadiotreatment'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMnomenclaturetreatment'+iteration;
	e1.id='DMnomenclaturetreatment'+iteration;
	e1.onblur=function(){populatePVMS(this.value,iteration); displayAu(this.value,iteration);checkForAllergy(this.value,iteration);/* checkItem(iteration),*/};
	e1.size='30'
	 e1.onblur=function(){
		populatePVMS(this.value,iteration); 
	     displayAu(this.value,iteration);
	     checkForAllergy(this.value,iteration);
	     checkIPItem(iteration);
	     validatePrescriptionAutocomplete('opmainTM',this.value,iteration );
	}; 

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updatestreatment'+iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('DMnomenclaturetreatment'+iteration,'ac2updatestreatment'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=DMnomenclaturetreatment'+iteration+'&DMcountertreatment='+iteration});

	var cellRight1 = row.insertCell(2);
	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name='DMpvmsNotreatment'+iteration;
	e1.id='DMpvmsNotreatment'+iteration;
	cellRight1.appendChild(e1);
	
	
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMactualDispensingQty'+iteration;
	 e1.id='DMactualDispensingQty'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMmixable'+iteration;
	 e1.id='DMmixable'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMmixtureQuantity'+iteration;
	 e1.id='DMmixtureQuantity'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMactualTotalAfterMix'+iteration;
	 e1.id='DMactualTotalAfterMix'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMmixtureUnit'+iteration;
	 e1.id='DMmixtureUnit'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMtapered'+iteration;
	 e1.id='DMtapered'+iteration;
	 cellRight1.appendChild(e1);
	  
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMdosagetreatment'+iteration;
	e1.id='DMdosagetreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatmentDM(iteration);checkFrequencyForTaperedDrugsDM(iteration);
	};
	/* e1.className='small'; */
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMunittreatment'+iteration;
	e1.id='DMunittreatment'+iteration;
	e1.size='2';
	/* e1.className='small'; */
	e1.readOnly='readOnly';
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name='DMfrequencytreatment'+iteration;
	e1.id='DMfrequencytreatment'+iteration;
	//e1.className='smallest';//changed by govind 24-12-2016
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<frequencyArray.length;i++ ){
		 var opt = document.createElement('option'); 
		 	opt.id = frequencyArray[i][2];
		 	opt.value = frequencyArray[i][0];
		    opt.innerHTML = frequencyArray[i][1];
		    e1.appendChild(opt);
	//e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	}
	e1.onchange=function()//changed by govind 24-12-2016
	 //e1.onchange=function()
		{
		getFrequencyValueDM(this.value,iteration);fillValueFromFrequencyDM(this.value,iteration);displaySOSQty(this.value,iteration);displaFrequencyType(this, iteration);checkFrequencyForTaperedDrugsDM(iteration);
		}; 
		/* e1.onchange = function() {
			displaFrequencyType(this, iteration);	
		}; */
	cellRight1.appendChild(e1);
	var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='DMsosQty'+iteration;
	  e21.id='DMsosQty'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);
	  
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='DMfrequencyValue'+iteration;
	  e21.id='DMfrequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(5);
	
	var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMnoOfDaystreatment'+iteration;
	e1.id='DMnoOfDaystreatment'+iteration;
	e1.size='2';
	/*e1.onblur=function()//changed by govind 24-12-2016
	{
		fillTotalForTreatment(iteration);
	};*/
	e1.onblur=function()
	{
		fillValueFromFrequencyDM(this.value,iteration);
		//fillTotalForTreatment(iteration);
	};
	e1.oninput=function()
	{
		fillValueFromFrequencyDM(this.value,iteration);
		//fillTotalForTreatment(iteration);
	};//changed by govind 24-12-2016 end
	e21Div.appendChild(e1);
	
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'DMfrequencyType' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);
	//cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name='DMinstructiontreatment'+iteration;
	e1.id='DMinstructiontreatment'+iteration;
	e1.className='small';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<instructionArray.length;i++ ){
			e1.options[instructionArray[i][0]] = new Option(instructionArray[i][1],instructionArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size = '15';
	e1.name='DMspslinstructiontreatment'+iteration;
	e1.id='DMspslinstructiontreatment'+iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name='DMroutetreatment'+iteration;
	e1.id='DMroutetreatment'+iteration;
	e1.className='small';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<roteArray.length;i++ ){
			e1.options[roteArray[i][0]] = new Option(roteArray[i][1],roteArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMtotaltreatment'+iteration;
	e1.id='DMtotaltreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatment(iteration);
	};
	cellRight1.appendChild(e1);


	}
	/* function removeRowTreatment()
	{
	var tbl = document.getElementById('gridtreatment');
	var lastRow = tbl.rows.length;
	if (lastRow > 2){
	tbl.deleteRow(lastRow - 1);
	var hdb = document.getElementById('hdbtreatment');
	hdb.value=hdb.value-1
	}
	} */
	
	function removeRowTreatment()
	{
	  var tbl = document.getElementById('DMgridtreatment');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('DMhdbtreatment');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("DMitemRadiotreatment"+i)!=null && (typeof  document.getElementById("DMitemRadiotreatment"+i).checked)!='undefined' && document.getElementById("DMitemRadiotreatment"+i).checked )
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
			  if(document.getElementById("DMitemRadiotreatment"+i)!=null && (typeof  document.getElementById("DMitemRadiotreatment"+i).checked)!='undefined' && document.getElementById("DMitemRadiotreatment"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("DMitemRadiotreatment"+i).parentNode.parentNode;
	    		  document.getElementById("DMitemRadiotreatment"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	    	 /*  for(var i=1;i<document.getElementById('grid').rows.length;i++)
	    		  {
	    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
	    		  } */
	  }
	}
	
	
	
	function removeRowInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("investigationtradio"+i)!=null && (typeof  document.getElementById("investigationtradio"+i).checked)!='undefined' && document.getElementById("investigationtradio"+i).checked )
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
	    		  if(document.getElementById("investigationtradio"+i)!=null && (typeof  document.getElementById("investigationtradio"+i).checked)!='undefined' && document.getElementById("investigationtradio"+i).checked )
	    		  {
	    		  
	    		  var deleteRow= document.getElementById("investigationtradio"+i).parentNode.parentNode;
	    		  document.getElementById("investigationtradio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	    	 /*  for(var i=1;i<document.getElementById('grid').rows.length;i++)
	    		  {
	    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
	    		  } */
	  }
	      
	      
	}
	
	
	/* function removeRowProscedure()
	{
	  var tbl = document.getElementById('proceduregrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('procCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("Procedureradio"+i)!=null && (typeof  document.getElementById("Procedureradio"+i).checked)!='undefined' && document.getElementById("Procedureradio"+i).checked )
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
	    		  if(document.getElementById("Procedureradio"+i)!=null && (typeof  document.getElementById("Procedureradio"+i).checked)!='undefined' && document.getElementById("Procedureradio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("Procedureradio"+i).parentNode.parentNode;
	    		  document.getElementById("Procedureradio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	    	  }
	}
	 */
	function addRowForAllergy(){
		var tbl = document.getElementById('alergyGrid');
		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('allergyCount');
		iteration = parseInt(hdb.value)+1;
		hdb.value=iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='allergyRadio'+iteration;
		e1.id='allergyRadio'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name='allergyType'+iteration;
		e1.id='allergyType'+iteration;
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<allergyTypeArray.length;i++ ){
		e1.options[allergyTypeArray[i][0]] = new Option(allergyTypeArray[i][1],allergyTypeArray[i][0]);
		} 
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='allergyName'+iteration;
		e1.id='allergyName'+iteration;
		e1.size='20'
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('Select');
		e1.name='allergyseverity'+iteration;
		e1.id='allergyseverity'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<saverityCodeArray.length;i++ ){
		e1.options[saverityCodeArray[i][0]] = new Option(saverityCodeArray[i][1],saverityCodeArray[i][0]);
		} 
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='allergymonth'+iteration;
		e1.id='allergymonth'+iteration;
		e1.size='20'
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(5);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='allergyyear'+iteration;
		e1.id='allergyyear'+iteration;
		e1.size='20'
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(6);
		var e1 = document.createElement('Select');
		e1.name='allergystatus'+iteration;
		e1.id='allergystatus'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		e1.options[1] = new Option('Active', '1');
		e1.options[2] = new Option('Inactive', '2');
		cellRight1.appendChild(e1);
		}
	
	
	
	function addRowForComorbidity(){
		var tbl = document.getElementById('comorbidityGrid');
		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('comorbidityCount');
		iteration = parseInt(hdb.value)+1;
		hdb.value=iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='radioComorbidity'+iteration;
		e1.id='radioComorbidity'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name='comorbidityType'+iteration;
		e1.id='comorbidityType'+iteration;
		e1.options[0] = new Option('Select', '0');
		/*  for(var i = 0;i<frequencyArray.length;i++ ){
		e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		} */
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='comorbiditymonth'+iteration;
		e1.id='comorbiditymonth'+iteration;
		e1.size='20'
		cellRight1.appendChild(e1);
		
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='comorbidityyear'+iteration;
		e1.id='comorbidityyear'+iteration;
		e1.size='20'
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='comorbidityremarks'+iteration;
		e1.id='comorbidityremarks'+iteration;
		e1.size='20'
		cellRight1.appendChild(e1);
		
		
		}
	
		/* function removeRowTreatment()
		{
		var tbl = document.getElementById('gridtreatment');
		var lastRow = tbl.rows.length;
		if (lastRow > 2){
		tbl.deleteRow(lastRow - 1);
		var hdb = document.getElementById('hdbtreatment');
		hdb.value=hdb.value-1
		}
		} */
		
		function removeRowTreatment()
		{
		  var tbl = document.getElementById('gridtreatment');
		  var lastRow = tbl.rows.length;
		  var hdb = document.getElementById('hdbtreatment');
		  var iteration = parseInt(hdb.value);
		  var totalSelected=0;
		  for(var i=1;i<=iteration;i++)
			  {
			  if(document.getElementById("itemRadiotreatment"+i)!=null && (typeof  document.getElementById("itemRadiotreatment"+i).checked)!='undefined' && document.getElementById("itemRadiotreatment"+i).checked )
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
				  if(document.getElementById("itemRadiotreatment"+i)!=null && (typeof  document.getElementById("itemRadiotreatment"+i).checked)!='undefined' && document.getElementById("itemRadiotreatment"+i).checked )
		    		  {
		    		  var deleteRow= document.getElementById("itemRadiotreatment"+i).parentNode.parentNode;
		    		  document.getElementById("itemRadiotreatment"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
		    		  }
		    	  }
		    	 /*  for(var i=1;i<document.getElementById('grid').rows.length;i++)
		    		  {
		    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
		    		  } */
		  }
		}
		
		
	
	
	function removeRowForAllergy()
	{
	  var tbl = document.getElementById('alergyGrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('allergyCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
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
	    		  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("allergyRadio"+i).parentNode.parentNode;
	    		  document.getElementById("allergyRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
	}
	
	function removeRowForComorbidity()
	{
	  var tbl = document.getElementById('comorbidityGrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('comorbidityCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("radioComorbidity"+i)!=null && (typeof  document.getElementById("radioComorbidity"+i).checked)!='undefined' && document.getElementById("radioComorbidity"+i).checked )
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
	    		  if(document.getElementById("radioComorbidity"+i)!=null && (typeof  document.getElementById("radioComorbidity"+i).checked)!='undefined' && document.getElementById("radioComorbidity"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("radioComorbidity"+i).parentNode.parentNode;
	    		  document.getElementById("radioComorbidity"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
	}
	function validateSurgery(inpatientId){
		

		//alert(val+"<<<-------val======inc------>>"+inc);
		//alert("visitId---->>>>"+visitId);
		var id;
		if(inpatientId!=""){

			  var xmlHttp;
			  try {
			    // Firefox, Opera 8.0+, Safari
			    xmlHttp=new XMLHttpRequest();
			  }catch (e){
			    // Internet Explorer
			    try{
			      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			    }catch (e){
			    	alert(e)
			      try{
			        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }catch (e){
			        alert("Your browser does not support AJAX!");
			        return false;
			      }
			     }
			   }

			xmlHttp.onreadystatechange=function()
			{
			  if(xmlHttp.readyState==4){
				var b="false";
			  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
			  	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			         icdString  = item.getElementsByTagName('surgeryString')[0];
			      
			         b =icdString.childNodes[0].nodeValue
			    // alert(""+b)
					    if(b=='true'){
							 if(confirm("Patient is under Surgical Procedure!! \n Still want to Discharge??")==true){
								 submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails');
							 }else if(confirm("Patient is under Surgical Procedure!! \n Still want to Discharge??")==false){
								 return false;
							 }
					    }else{
					    	submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails');
					    }
			  	}	
			  }
			  }
		}
			var url="/hms/hms/ot?method=getSurgeryInfoForPatient&inaptientId="+inpatientId;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			xmlHttp.open("GET",url,true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
		}
		
	
	
	
	function validatecaseNote()
	{
		 var systolic=document.getElementById("systolic").value;
		 var diastolic=document.getElementById("diastolic").value;
		 if(diastolic!=null && diastolic!=''&& (systolic==null || systolic==''))
			 {
			 alert('please fill systolic');
			 return false;
			 }
		 else if(systolic!=null && systolic!=''&& (diastolic==null || diastolic==''))
			 {
			 alert('please fill diastolic');
			 return false;
			 }
		checkValidationForCaseNote();
		checkValidationForTreatment();
		checkValidationForInvestigation();
		//checkValidationForProscedure();
		validateRequiredFieldNursingCare();
		//fillcheckDoseFrequency();//added by govind 20-9-2016
		if(document.getElementById('readyToDischarge').checked==true){
		validateSurgery(<%=inpatientId%>);
		//submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails');
		}
		else{
			submitForm('ipdCaseSheet','ipd?method=submitIpdCaseSheetDetails');
		}
	}
	
	function checkValidationForCaseNote()
	{
		document.getElementById("presentComplain").setAttribute("validate", "Present Complaint ,string,no");
		document.getElementById("pastIllness").setAttribute("validate", "Past Illness ,string,no");
		document.getElementById("personalHistory").setAttribute("validate", "Personal  History ,string,no");
		document.getElementById("familyHistory").setAttribute("validate", "Family History ,string,no");
		document.getElementById("medicationhistory").setAttribute("validate", "Medication History ,string,no");	
		document.getElementById("diagnosisId").setAttribute("validate", "Diagnosis ,string,yes");	
	}
	
	function checkValidationForTreatment()
	{
		var count = document.getElementById('hdbtreatment').value;
		for(var i=1;i<=count;i++)
			{
			   if(document.getElementById("nomenclaturetreatment"+i)!=null && document.getElementById("nomenclaturetreatment"+i).value!='')
				   {
				   if(document.getElementById("tapered"+i)!=null && document.getElementById("tapered"+i).value!='y')
				   {	
				   document.getElementById("nomenclaturetreatment"+i).setAttribute("validate", "Drug Name,string,yes");
				   document.getElementById("dosagetreatment"+i).setAttribute("validate", "Dosage,float,yes");
				   document.getElementById("unittreatment"+i).setAttribute("validate", "Unit,string,yes");
				   document.getElementById("frequencytreatment"+i).setAttribute("validate", "Frequency,int,yes");
				   document.getElementById("noOfDaystreatment"+i).setAttribute("validate", "Duration,int,yes");
				   document.getElementById("instructiontreatment"+i).setAttribute("validate", "Instruction,int,no");
				   document.getElementById("routetreatment"+i).setAttribute("validate", "Route,int,no");
				   document.getElementById("routetreatment"+i).setAttribute("totaltreatment", "Total,num,yes");
				   document.getElementById("spslinstructiontreatment"+i).setAttribute("validate", "Special Instruction,string,no");
				   }
				  }
			}
	}
		
	
	function checkValidationForInvestigation()
	{
		var count = document.getElementById('hiddenValue').value;
		for(var i=1;i<=count;i++)
			{
			   if(document.getElementById("chargeCodeName"+i)!=null && document.getElementById("chargeCodeName"+i).value!='')
				   {
				   document.getElementById("chargeCodeName"+i).setAttribute("validate", "Test Name,string,yes");
				   document.getElementById("chargecodeclinicalnote"+i).setAttribute("validate", "clinical Note,string,no");
				   }
			}
	}
	
	
	/* function checkValidationForProscedure()
	{
		var count = document.getElementById('procCount').value;
		for(var i=1;i<=count;i++)
			{
			   if(document.getElementById("procedure"+i)!=null && document.getElementById("procedure"+i).value!='')
				   {
				   document.getElementById("procedure"+i).setAttribute("validate", "Procedure Name,string,yes");
				   document.getElementById("procedurecode"+i).setAttribute("validate", "Procedure Code,string,yes");
				   document.getElementById("procedureTentativedate"+i).setAttribute("validate", "Tentative Date,date,yes");
				   document.getElementById("procRemarks"+i).setAttribute("validate", "Remarks,string,no");
				   }
			}
	} */
	
	function checkValidationForAlergy()
	{
		var count = document.getElementById('allergyCount').value;
		for(var i=1;i<=count;i++)
			{
			   if(document.getElementById("allergyName"+i)!=null && document.getElementById("allergyName"+i).value!='')
				   {
				   document.getElementById("allergyType"+i).setAttribute("validate", "Allergy Type,int,yes");
				   document.getElementById("allergyName"+i).setAttribute("validate", "Allergen,string,yes");
				   document.getElementById("allergyseverity"+i).setAttribute("validate", "Severity,int,yes");
				   document.getElementById("allergymonth"+i).setAttribute("validate", "Allergy Month,string,yes");
				   document.getElementById("allergyyear"+i).setAttribute("validate", "Allergy Year,string,yes");
				   document.getElementById("allergystatus"+i).setAttribute("validate", "Allergy Status,int,yes");
				   }
			}
	}
	
	/* function checkValidationForDiet()
	{
		var count = document.getElementById('allergyCount').value;
		for(var i=1;i<=count;i++)
			{
			   if(document.getElementById("allergyName"+i)!=null && document.getElementById("allergyName"+i).value!='')
				   {
				   document.getElementById("allergyType"+i).setAttribute("validate", "Allergy Type,int,yes");
				   document.getElementById("allergyName"+i).setAttribute("validate", "Allergen,string,yes");
				   document.getElementById("allergyseverity"+i).setAttribute("validate", "Severity,int,yes");
				   document.getElementById("allergymonth"+i).setAttribute("validate", "Allergy Month,string,yes");
				   document.getElementById("allergyyear"+i).setAttribute("validate", "Allergy Year,string,yes");
				   document.getElementById("allergystatus"+i).setAttribute("validate", "Allergy Status,int,yes");
				   }
			}
	}
	 */
	 
	function addRowForNursingcare(){
		var tbl = document.getElementById('nursingcaretable');
		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('nursingcarecount');
		iteration = parseInt(hdb.value)+1;
		hdb.value=iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='radionursingcare'+iteration;
		e1.id='radionursingcare'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name='careTypeId'+iteration;
		e1.id='careTypeId'+iteration;
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<nursingCareSetupList.length;i++ ){
		e1.options[nursingCareSetupList[i][0]] = new Option(nursingCareSetupList[i][1],nursingCareSetupList[i][0]);
		} 
		  e1.onblur=function(){
			  validateDuplicateNursingCare(iteration);
				};
		cellRight1.appendChild(e1);

		
		
		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.name='frequency'+iteration;
		e1.id='frequency'+iteration;
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<frequencyArray.length;i++ ){
		e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		} 
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='carestop'+iteration;
		e1.id='carestop'+iteration;
		e1.value='1';
		cellRight1.appendChild(e1);
		
		
		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='careremarks'+iteration;
		e1.id='careremarks'+iteration;
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
    }
    
    function removeRowForNursingcare()
	{
	  var tbl = document.getElementById('nursingcaretable');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('nursingcarecount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
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
        		  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("radionursingcare"+i).parentNode.parentNode;
	    		  document.getElementById("radionursingcare"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
	}
	 
	 function validateDuplicateNursingCare(index)
     {
     	var count = document.getElementById('nursingcarecount').value;
     	var nursingCareId=document.getElementById("careTypeId"+index).value;
 		for(var i=1;i<=count;i++)
 			{
 			   if(i!=index && document.getElementById("careTypeId"+i)!=null && document.getElementById("careTypeId"+i).value!=''&& document.getElementById("careTypeId"+i).value!=0)
 				   {
 				   if(document.getElementById("careTypeId"+i).value==nursingCareId)
 				    	{
 					   
 				    	alert(document.getElementById("careTypeId"+i).options[document.getElementById("careTypeId"+i).selectedIndex].text +" is duplicate");        				    	
 				    	document.getElementById("careTypeId"+index).value=0;
 				    	return false;
 				    	}
 				   
 				   }
 			}
 		return true;
     }
	 
	 function validateRequiredFieldNursingCare()
     {
     	var count = document.getElementById('nursingcarecount').value;
 		for(var i=1;i<=count;i++)
 			{
 			   if(document.getElementById("careTypeId"+i)!=null && document.getElementById("careTypeId"+i).value!=''&& document.getElementById("careTypeId"+i).value!=0)
 				   {
 					   document.getElementById("careTypeId"+i).setAttribute("validate", "Nursing Care / Procedure,int,yes");
 					   document.getElementById("frequency"+i).setAttribute("validate", "Frequency,int,yes");
 					   document.getElementById("careremarks"+i).setAttribute("validate", "Remarks,string,no");
 				   }
 			}
     }
	 
	 function openExtraDiet(index,inpatientId)
	 {
	 	
	 	if(document.getElementById('extracount'+inpatientId)==null)
	 		{
	 		  var e3 = document.createElement('input');
	 		  e3.type = 'hidden';
	 		  e3.name='extracount'+inpatientId;
	 		  e3.id='extracount'+inpatientId;
	 		  e3.value='0';
	 		  document.getElementById('extradiet'+inpatientId).appendChild(e3);
	 		}
	 	if(document.getElementById('extracount'+inpatientId).value>0)
	 		{
	 		var tbl = document.getElementById('itemrequiredTable');
	 		var itemRequiredCount=document.getElementById('itemRequired').value;
	 		var patientDietCount=document.getElementById('extracount'+inpatientId).value;
	 		for(var i=1;i<=patientDietCount;i++)
	 			{
	 			var deleteRow=0;
	 			for(var j=1;j<=itemRequiredCount;j++)
	 				{
	 				if(document.getElementById('dietId'+j)!=null)
	 					{
	 					deleteRow=deleteRow+1;
	 					}
	 				if(document.getElementById('dietId'+j)!=null && document.getElementById('extraDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
	 				{
	 					
	 					
	 					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('extraDietquantity'+inpatientId+''+i).value);
	 					 document.getElementById('dietItemCountView'+j).innerHTML='';
	 					var e3 = document.createElement('input');
	 					  e3.type = 'hidden';
	 					  e3.name='dietItemCount'+j;
	 					  e3.id='dietItemCount'+j
	 					  e3.value=quantity;
	 					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
	 					var e3 = document.createElement('label');
	 					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
	 					 document.getElementById('dietItemCountView'+j).appendChild(e3);	
	 					if(document.getElementById('dietItemCount'+j).value<=0)
	 						{
	 						tbl.deleteRow(deleteRow);
	 						}
	 					break;
	 				}
	 				}
	 			}
	 		}
	 	
	 	document.getElementById('extradiet'+inpatientId).innerHTML='';
	 	/* var e3 = document.createElement('input');
	 	  e3.type = 'hidden';
	 	  e3.name='extracount'+inpatientId;
	 	  e3.id='extracount'+inpatientId;
	 	  e3.value='0';
	 	  document.getElementById('extradiet'+inpatientId).appendChild(e3); */
	 	
	 	if(document.getElementById('extradiet'+index).checked)
	 		{
	 		openWindow('/hms/hms/ipd?method=showExtraDietJsp&parent='+inpatientId+'&'+csrfTokenName+'='+csrfTokenValue);
	 		}
	 	else
	 		{
	 		var e3 = document.createElement('input');
	 		  e3.type = 'hidden';
	 		  e3.name='extracount'+inpatientId;
	 		  e3.id='extracount'+inpatientId;
	 		  e3.value='0';
	 		  document.getElementById('extradiet'+inpatientId).appendChild(e3);
	 		 // newwindow.close();
	 		}
	 	
	 	
	 }
	 
	 function openDietCombination(index,inpatientId)
	 {

	 	if(document.getElementById('dietCount'+inpatientId)==null)
	 		{
	 		  var e3 = document.createElement('input');
	 		  e3.type = 'hidden';
	 		  e3.name='dietCount'+inpatientId;
	 		  e3.id='dietCount'+inpatientId;
	 		  e3.value='0';
	 		  document.getElementById('selectedDiet'+inpatientId).appendChild(e3);
	 		}
	 	if(document.getElementById('dietCount'+inpatientId).value>0)
	 		{
	 		var tbl = document.getElementById('itemrequiredTable');
	 		var itemRequiredCount=document.getElementById('itemRequired').value;
	 		var patientDietCount=document.getElementById('dietCount'+inpatientId).value;
	 		for(var i=1;i<=patientDietCount;i++)
	 			{
	 			var deleteRow=0;
	 			for(var j=1;j<=itemRequiredCount;j++)
	 				{
	 				if(document.getElementById('dietId'+j)!=null)
	 					{
	 					deleteRow=deleteRow+1;
	 					}
	 				if(document.getElementById('dietId'+j)!=null && document.getElementById('dietcombinationDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
	 				{
	 					
	 					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('dietcombinationquantity'+inpatientId+''+i).value);
	 					document.getElementById('dietItemCountView'+j).innerHTML='';
	 					var e3 = document.createElement('input');
	 					  e3.type = 'hidden';
	 					  e3.name='dietItemCount'+j;
	 					  e3.id='dietItemCount'+j
	 					  e3.value=quantity;
	 					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
	 					var e3 = document.createElement('label');
	 					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
	 					  document.getElementById('dietItemCountView'+j).appendChild(e3);
	 					if(document.getElementById('dietItemCount'+j).value<=0)
	 						{
	 						tbl.deleteRow(deleteRow);
	 						}
	 					break;
	 				}
	 				}
	 			}
	 		}
	 	
	 	document.getElementById('selectedDiet'+inpatientId).innerHTML='';
	 	/* var e3 = document.createElement('input');
	 	  e3.type = 'hidden';
	 	  e3.name='extracount'+inpatientId;
	 	  e3.id='extracount'+inpatientId;
	 	  e3.value='0';
	 	  document.getElementById('extradiet'+inpatientId).appendChild(e3); */
	 	

	 		
	 		<%-- alert(document.getElementById('<%=DIET_MENU_ITEM_ID %>').value=='');
	 		alert(document.getElementById('<%=DIET_TYPE_ID %>').value==''); --%>
	 		if(document.getElementById('<%=DIET_MENU_ITEM_ID %>')==null || document.getElementById('<%=DIET_MENU_ITEM_ID %>').value==''|| document.getElementById('<%=DIET_MENU_ITEM_ID %>').value=='0')
	 			{
	 			alert('Please select Diet Time');
	 			return;
	 			}
	 		
	 		if(document.getElementById('<%=DIET_TYPE_ID %>')==null || document.getElementById('<%=DIET_TYPE_ID %>').value=='' || document.getElementById('<%=DIET_TYPE_ID %>').value=='0')
	 		{
	 		alert('Please select Diet Type');
	 		return;
	 		}
	 		if(document.getElementById('dietForDate')==null || document.getElementById('dietForDate').value=='')
			{
			alert('Please select Diet Date');
			return;
			}
	 		
	 		openWindow('/hms/hms/ipd?method=showDietCombinationjsp&parent='+inpatientId+'&<%=DIET_TYPE_ID%>='+document.getElementById('<%=DIET_TYPE_ID %>').value+'&<%=DIET_MENU_ITEM_ID%>='+document.getElementById('<%=DIET_MENU_ITEM_ID %>').value+'&dietForDate='+document.getElementById('dietForDate').value+'&'+csrfTokenName+'='+csrfTokenValue);
	 	
	 	
	 	
	 }
	 
	 function calculateBMI()
	 {
		 document.getElementById('bmi').value='';
	 	if(document.getElementById('height').value != "" && document.getElementById('weight').value !="")
	 	{
	 	 var height = 	parseFloat(document.getElementById('height').value)/100;
	 	 var weight = 	document.getElementById('weight').value;
	 	document.getElementById('bmi').value=(weight/(height*height)).toFixed(2);
	 	}
	 	bmiCat();
	 }

	 function bmiCat(){
	 	 var bmicat;
	 	document.getElementById('bmi').value='';
	 		if(document.getElementById('height').value != "" && document.getElementById('weight').value !="")
	 		{
	 		 var height = 	parseFloat(document.getElementById('height').value)/100;
	 		 var weight = 	document.getElementById('weight').value;
	 		document.getElementById('bmi').value=(weight/(height*height)).toFixed(2);
	 		 bmicat=(weight/(height*height)).toFixed(2);
	 		}
	 		document.getElementById('bmicat').value=' ';
	 		 if(bmicat<18.5){
	 			document.getElementById('bmicat').value='Underweight';
	 		}else if(bmicat>=18.5 && bmicat<25){
	 			document.getElementById('bmicat').value='Healthy Range';
	 		}else if(bmicat>=25 && bmicat<=30){
	 			document.getElementById('bmicat').value='Overweight';
	 		}else if(bmicat>=30 && bmicat<=35){
	 			document.getElementById('bmicat').value='Obese';
	 		}else if(bmicat>35){
	 			
	 			document.getElementById('bmicat').value='Severely obese';
	 		}else{
	 			document.getElementById('bmicat').value='';
	 		}
	 }
	 
	 jQuery(function ($) {
			$("#vitalTrends").click(function(){
				new Ajax.Request('opd?method=getPatientVitalTrends&hinId='+<%=inpatient.getHin().getId()%>+'&'+csrfTokenName+'='+csrfTokenValue, {
			    	  onSuccess: function(response) {
			    	      if(response.responseText.trim()!='No vital Details')
		    	    	  {		
			    	  		  $("#vitalUHID").val('<%=inpatient.getHin().getHinNo()%>');
			    	    	  $("#vitalPname").val('<%=inpatient.getHin().getPFirstName()%>'); 
			    	    	  $("#vitalTable").html(response.responseText.trim()); 
			    	    	  $("#vitalDialog").dialog({width:842,height:332,modal: true});
		    	    	  }else{
		    	    		  alert("No vital details");
		    	    	  }
			    	  }
			  	  });
				});
	 });
	 
	 function openPopupForSavePrescriptiontamplate()
	 {
	 	   var totalRow=document.getElementById('hdbtreatment').value;
	 	   var htmlText="";
	 	   var count=0;
	 	   if(!isNaN(totalRow) && totalRow>0)
	 		   {
	 		   htmlText +='<form method="post" action="/hms/hms/opd?method=submitPrescriptionTamplate">'
	 		   +'<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:both;;"></div><br/><br/><div style="clear:both;;"></div>';
	 		   htmlText +='<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
	 		   for(var i=1;i<=totalRow;i++)
	 			   {
	 			   
	 			   if(document.getElementById('nomenclaturetreatment'+i)!=null && document.getElementById('nomenclaturetreatment'+i).value!='' && 
	 					   document.getElementById('pvmsNotreatment'+i).value!='' && document.getElementById('pvmsNotreatment'+i).value!='0')
	 				   {
	 				  
	 				   if(count==0)
	 					   {
	 					   htmlText +=''
	 						         +'<tr>'
	 						         +'<th scope="col">Drug Name</th>'
	 						         +'<th scope="col">Dosage</th>'
	 						         +'<th scope="col">Frequency</th>'
	 						         +'<th scope="col">Duration</th>'
	 						         +'<th scope="col">Instruction </th>'
	 						         +'<th scope="col">Route</th>'
	 						         +'<th scope="col">Total</th>'
	 						         +'</tr>';
	 					   }
	 				   count++;
	 				   htmlText +=''
	 				         +'<tr>'
	 				         +'<td>'
	 				   		 +'<input type="hidden" name="pvms'+count+'" value="'+document.getElementById('pvmsNotreatment'+i).value+'" />'
	 				   		 +'<input type="hidden" name="nomenclature'+count+'" value="'+document.getElementById('nomenclaturetreatment'+i).value+'" />'
	 				   		 +''+document.getElementById('nomenclaturetreatment'+i).value
	 				   		 +'</td>'
	 				   		+'<td>'
	 				   		 +'<input type="hidden" name="dosage'+count+'" value="'+document.getElementById('dosagetreatment'+i).value+'" />'
	 				   		 +''+document.getElementById('dosagetreatment'+i).value
	 				   		
	 				   		+'</td>'
	 				   		 +'<td>'
	 				   		
	 				   		+'<input type="hidden" name="frequency'+count+'" value="'+document.getElementById('frequencytreatment'+i).value+'" />';
	 				   	 if(document.getElementById('frequencytreatment'+i).value!=0)
	 		   			 {
	 				   		 htmlText +='<input type="hidden" name="frequencyname'+count+'" value="'+document.getElementById('frequencytreatment'+i).options[document.getElementById('frequencytreatment'+i).selectedIndex].text+'" />';
	 				   		 htmlText +=''+document.getElementById('frequencytreatment'+i).options[document.getElementById('frequencytreatment'+i).selectedIndex].text;
	 		   			 }
	 				   	htmlText +='</td>'
	 				   		+'<td>'
	 				   		+'<input type="hidden" name="noOfDays'+count+'" value="'+document.getElementById('noOfDaystreatment'+i).value+'" />'
	 				   		 +''+document.getElementById('noOfDaystreatment'+i).value
	 				   		+'</td>'
	 				   		+'<td>'
	 				   		+'<input type="hidden" name="instrunction'+count+'" value="'+document.getElementById('instructiontreatment'+i).value+'" />';
	 				   	 if(document.getElementById('instructiontreatment'+i).value!=0)
	 		   			 {
	 				   		 htmlText +='<input type="hidden" name="instrunctionname'+count+'" value="'+document.getElementById('instructiontreatment'+i).options[document.getElementById('instructiontreatment'+i).selectedIndex].text+'" />';

	 				   		 htmlText +=''+document.getElementById('instructiontreatment'+i).options[document.getElementById('instructiontreatment'+i).selectedIndex].text;
	 		   			 }
	 				   	htmlText +='<td>'
	 			   		+'<input type="hidden" name="route'+count+'" value="'+document.getElementById('routetreatment'+i).value+'" />';
	 			   	 if(document.getElementById('routetreatment'+i).value!=0)
	 	   			 {
	 			   		 htmlText +='<input type="hidden" name="routename'+count+'" value="'+document.getElementById('routetreatment'+i).options[document.getElementById('routetreatment'+i).selectedIndex].text+'" />';

	 			   		 htmlText +=''+document.getElementById('routetreatment'+i).options[document.getElementById('routetreatment'+i).selectedIndex].text;
	 	   			 }
	 			   	 
	 			   	htmlText +='</td>'
	 			   	+'<td>'
	 		   		+'<input type="hidden" name="total'+count+'" value="'+document.getElementById('totaltreatment'+i).value+'" />'
	 		   	 +''+document.getElementById('totaltreatment'+i).value;
	 				   	 htmlText +='</td>'
	 				   		
	 				   		 +'</tr>';
	 				   
	 				   }
	 			   
	 			   }
	 		   htmlText +='</table>'
	 		   +'<div style="clear:both;;"></div><input type="hidden" id="total" name="total" value="'+count+'" /><div style="clear:both;"></div><div style="clear:both;margin-top:30px;"><div style="clear:both;;"></div><input type="submit" id="submit" value="Save" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /><div style="clear:both;;"></div></div><div style="clear:both;;"></div>'
	 		  +'<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">'
	 		   +'</form>';
	 		   }
	 	  // alert(htmlText);
	 	   if(count==0)
	 		   {
	 		   alert('Please enter some data to save Tamplate');
	 		   }
	 	   else
	 		   {
	 		   var myWindow = window.open("", "saveprescriptionWindow", "width=500, height=500");
	 		   //myWindow.document.write('/hms/jsp/css/style.css');
	 		   myWindow.document.write(htmlText);
	 		   }
	 	  
	 }

	 function fnGetPrescriptionTemplate(tempId){
		 submitProtoAjaxWithDivName('ipdCaseSheet',"/hms/hms/ipd?method=getPrescriptionTemplateOP&templateId="+tempId,'gridtreatmentDiv');
	}
	 
	 function onChangeInvestigationDepartment()
	 {
		 var elementList=document.getElementsByName('labradiologyCheck');
		 for(var i=0;i<elementList.length;i++)
			 {
			 if(elementList[i]!=null && elementList[i].checked)
				 {
				 document.getElementById('investigationCategory').value=elementList[i].value;
				 return;
				 }
			 }
	 }
	 onChangeInvestigationDepartment();
	 
	 
	 function validateInvestigationAutoComplete(strValue,inc ) {

			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    var count=document.getElementById('hiddenValue').value;
		    
		    //alert("inc----"+inc)
		    if(id =="")
		    {		
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
					return ;
			}
		    
		    for(var i=1;i<=count;i++)
	    	{
	    	if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value==strValue  && i!=inc)
	    		{
	    		alert('This Investigation is already selected.');
	    		document.getElementById('chargeCodeName'+inc).value="";
				document.getElementById('chargeCode'+inc).value="";
	    		return false;
	    		}
	    	}
				document.getElementById('chargeCode'+inc).value=id;

			return true;
		}
	
	 
	 function openPopupForSaveInvestigation()
	 {
	 	   var totalRow=document.getElementById('hiddenValue').value;
	 	   var htmlText="";
	 	   var count=0;
	 	   if(!isNaN(totalRow) && totalRow>0)
	 		   {
	 		   htmlText +='<form method="post" action="/hms/hms/opd?method=submitInvestigationTamplate">'
	 		   +'<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:both;"><div><br/><br/>';
	 		   htmlText +='<table width="100%" border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
	 		   for(var i=1;i<=totalRow;i++)
	 			   {
	 			   
	 			   if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value!='' && 
	 					   document.getElementById('chargeCode'+i).value!='' && document.getElementById('chargeCode'+i).value!='0')
	 				   {
	 				  
	 				   if(count==0)
	 					   {
	 					   htmlText +=''
	 						         +'<tr>'
	 						         +'<th scope="col">Test Name</th>'
	 						         +'<th scope="col">Clinical Notes</th>'
	 						    
	 						         +'</tr>';
	 					   }
	 				   count++;
	 				   htmlText +=''
	 				         +'<tr>'
	 				         +'<td>'
	 				   		 +'<input type="hidden" name="chargeCode'+count+'" value="'+document.getElementById('chargeCode'+i).value+'" />'
	 				   		 +'<input type="hidden" name="chargeCodeName'+count+'" value="'+document.getElementById('chargeCodeName'+i).value+'" />'
	 				   		 +''+document.getElementById('chargeCodeName'+i).value
	 				   		 +'</td>'
	 				   		+'<td>'
	 				   		 +'<input type="hidden" name="clinicalNotes'+count+'" value="'+document.getElementById('chargecodeclinicalnote'+i).value+'" />'
	 				   		 +''+document.getElementById('chargecodeclinicalnote'+i).value
	 				   		
	 				   		+'</td>'
	 				   	 htmlText +='</td>'
	 				   		
	 				   		 +'</tr>';
	 				   
	 				   }
	 			   
	 			   }
	 		   htmlText +='</table>'
	 		   +'<div style="clear:both;"><div><br/><br/><input type="hidden" id="total" name="total" value="'+count+'" /><input type="hidden" id="fromIp" name="fromIp" value="ipd" /><br/><br/><div>'
	 		   +'<div><input type="submit" id="submit" value="Save"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
	 		   +'<input type="button" id="close" value="Close"  onclick="window.close()" />'
	 		   +'</div></div></div></form>';
	 		   }
	 	  // alert(htmlText);
	 	   if(count==0)
	 		   {
	 		   alert('Please enter some data to save Tamplate');
	 		   }
	 	   else
	 		   {
	 		   var myWindow = window.open("", "saveprescriptionWindow", "width=500, height=500");
	 		  myWindow.document.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
	 		   myWindow.document.write(htmlText);
	 		   }	 	  
	 }
	 function fnGetInvestigationTemplate(tempId){
		 submitProtoAjaxWithDivName('ipdCaseSheet',"/hms/hms/ipd?method=getLabInvestigationTemplate&templateId="+tempId+"&hinId=<%=inpatient.getHin().getId()%>",'investigationGridDiv');
	}
	 
	 function putSystemicExamiantionText(id,text){
			var putText=document.getElementById('systemicExamination').value;
			var nad=document.getElementById("nad");
			var cvs=document.getElementById("cvs");
			var cns=document.getElementById("cns");
			var rs=document.getElementById('rs');
			var grs=document.getElementById('grs');
			if(nad.checked==true){
				cvs.disabled=true;cns.disabled=true;rs.disabled=true;grs.disabled=true;
				document.getElementById('systemicExamination').value="";
				document.getElementById('systemicExamination').value=text;	
			}else{
				nad.disabled=true;cvs.disabled=false;cns.disabled=false;rs.disabled=false;grs.disabled=false;
				if(cvs.checked==true){
					document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
				}else if(cns.checked==true){
					document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
				}else if(rs.checked==true){
					document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
				}else if(grs.checked==true){
					document.getElementById('systemicExamination').value=(putText+"\n"+text).trim();
				}else{
					nad.disabled=false;
					document.getElementById('systemicExamination').value="";
				}
			}
			
			
	}
	 
	 function onGeneralExaminationDblClick()
	 {
		 var gnrlexamination=document.getElementById('generalExamination1');
		 for(var i=0;i<gnrlexamination.options.length;i++)
			 {
			 if(gnrlexamination.options[i].selected)
		{
				 document.getElementById('generalExaminationOPC').value=document.getElementById('generalExaminationOPC').value+"\n"+gnrlexamination.options[i].text;
		}
			 }
	 }
	 
	 function displayAu(val,inc){
         if(val != "")
         {
             var index1 = val.lastIndexOf("[");
             var indexForBrandName=index1;
             var index2 = val.lastIndexOf("]");
             index1++;
             var pvmsNo = val.substring(index1,index2);
             var indexForBrandName=indexForBrandName--;
             var brandName=val.substring(0,indexForBrandName);
		      if(pvmsNo == "")
		      {
		        document.getElementById('nomenclaturetreatment'+inc).value="";
		        document.getElementById('pvmsNotreatment'+inc).value="";
		       return;
		       }
		       else
		            var xmlHttp;
		              try {
		                // Firefox, Opera 8.0+, Safari
		                xmlHttp=new XMLHttpRequest();
		              }catch (e){
		                // Internet Explorer
		                try{
		                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		                }catch (e){
		                        alert(e)
		                  try{
		                    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		                  }catch (e){
		                    alert("Your browser does not support AJAX!");
		                    return false;
		                  }
		                 }
		               }
		            
		                xmlHttp.onreadystatechange=function()
		                {
		                  if(xmlHttp.readyState==4){
		                          var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		                          for (loop = 0; loop < items.childNodes.length; loop++) {
		                                   var item = items.childNodes[loop];
		                                
		                            var au  = item.getElementsByTagName("au")[0];
		                            var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
		                            var stock = item.getElementsByTagName("stock")[0];
		                            
		                         // added by amit das on 19-11-2016
		        					var mixable = item.getElementsByTagName("mixable")[0];
		        					var mixtureQuantity = item.getElementsByTagName("mixtureQuantity")[0];
		        					var mixtureUnit = item.getElementsByTagName("mixtureUnit")[0];
		        					var tapered = item.getElementsByTagName("tapered")[0];
		        					
		                            
		                            if(document.getElementById('au'+inc) && au.childNodes[0] != undefined ){
		                                    document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
		                            }
		                         /*    if(document.getElementById('closingStock'+inc) && stock.childNodes[0] != undefined){
		                                    document.getElementById('closingStock'+inc).value = stock.childNodes[0].nodeValue;
		                                    if(stock.childNodes[0].nodeValue == 0){
		                                       alert("Stock is not available...");
		                                    }
		                            }else{
		                            } */
		                            if(document.getElementById('actualDispensingQty'+inc)){
		                            if(actualDispensingQty.childNodes[0]!=undefined){
		                                    document.getElementById('actualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
		                            }else{
		                                    document.getElementById('actualDispensingQty'+inc).value = 0;
		
		                            }
		                            }
		                            var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
		                            if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
		                                    alert("This drug is dangerous.");
		                            }
		                            
		                        	// added by amit das on 19-11-2016
		        					if (document.getElementById('mixable' + inc)
		        							&& mixable.childNodes[0] != undefined) {
		        						document.getElementById('mixable' + inc).value = mixable.childNodes[0].nodeValue;
		        					}
		        					// added by amit das on 19-11-2016
		        					if (document.getElementById('mixtureQuantity' + inc)
		        							&& mixtureQuantity.childNodes[0] != undefined) {
		        						document.getElementById('mixtureQuantity' + inc).value = mixtureQuantity.childNodes[0].nodeValue;
		        					}
		        					
		        					// added by amit das on 19-11-2016
		        					if (document.getElementById('mixtureUnit' + inc)
		        							&& mixtureUnit.childNodes[0] != undefined) {
		        						document.getElementById('mixtureUnit' + inc).value = mixtureUnit.childNodes[0].nodeValue;
		        					}
		        					if (document.getElementById('tapered' + inc)
		        							&& tapered.childNodes[0] != undefined) {
		        						document.getElementById('tapered' + inc).value = tapered.childNodes[0].nodeValue;
		        					}
		                          }
		                  }
		                 }
		                var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		                xmlHttp.open("GET",url,true);
		                xmlHttp.setRequestHeader("Content-Type", "text/xml");
		                xmlHttp.send(null);
		            }
  }
	 
	 function  fillValue(value,inc){
		  var dosage = document.getElementById('dosagetreatment'+inc).value;;
		  var freq=document.getElementById('frequencyValue'+inc).value;
		  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
		  var noOfDays = document.getElementById('noOfDaystreatment'+inc).value;;
		  var sosQty = document.getElementById('sosQty'+inc).value;
		  var total = freq*noOfDays*dosage;
		  var finalQty;
		  if(document.getElementById('frequencytreatment'+inc).value != 13 ){
		  if(document.getElementById('actualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('totaltreatment'+inc).value=Math.round(freq*value*dosage);//Math.round(finalQty);
			 }else{
				  document.getElementById('totaltreatment'+inc).value=Math.round(freq*value*dosage);
			  }
		  }else{
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
				 }else{
					  document.getElementById('totaltreatment'+inc).value=Math.round(freq*sosQty*dosage);
				  }
		  }
		 }
	
		/*
		 var freq=document.getElementById('frequency'+inc2).value;
	     var noOfDays=document.getElementById('noOfDays'+inc2).value;
	     var dosage=document.getElementById('dosage'+inc2).value;
	     document.getElementById('total'+inc2).value=freq*dosage*noOfDays;
	     
	     document.getElementById('noOfDayspTab'+inc2).value=noOfDays;
	     document.getElementById('frequencypTab'+inc2).value=freq;
	     document.getElementById('frequencypTab'+inc2).text=document.getElementById('frequency'+inc2).text;
	     document.getElementById('totalpTab'+inc2).value=freq*dosage*noOfDays;
		*/
	
		function displaySOSQty(val,inc){
		if(val == '13'){
			document.getElementById('sosQty'+inc).style.display = 'block';
			document.getElementById('noOfDaystreatment'+inc).disabled = true;
		 }else{
		  document.getElementById('sosQty'+inc).style.display  = 'none';
		  document.getElementById('noOfDaystreatment'+inc).disabled = false;
		 }
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
			}
		
		 function  fillValueFromFrequency(value,inc){
		   	  var dosage = document.getElementById('dosagetreatment'+inc).value;
			  var noOfDays=document.getElementById('noOfDaystreatment'+inc).value
			  var freq=document.getElementById('frequencyValue'+inc).value
			  document.getElementById('totaltreatment'+inc).value=Math.round(noOfDays*freq*dosage)
			  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
		   	  var sosQty = document.getElementById('sosQty'+inc).value;
			  var total = freq*noOfDays*dosage;
			  var finalQty;
			  if(document.getElementById('frequencytreatment'+inc).value != 13 ){
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
				  document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
				 }else{
					  document.getElementById('totaltreatment'+inc).value=Math.round(noOfDays*freq*dosage);
				  }
			  }else{
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
					  if(totalQty != '0.00'){
						  finalQty = Math.ceil(totalQty);
					  }
					  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
				
					 }else{
						  document.getElementById('totaltreatment'+inc).value=Math.round(sosQty*freq*dosage);
					  }
			  }
			 } 
	 
	/*  $("#generalExamination1").dblclick(function(){
		 $("#generalExaminationOPC").val($.trim($("#generalExaminationOPC").val()+"\n"+$("#generalExamination1 option:selected" ).text()));
		 $("#generalExaminationEXM").val($.trim($("#generalExaminationEXM").val()+"\n"+$("#generalExamination2 option:selected" ).text()));
	 }); */
</script>
<script>
function addRowForVitalcare(){
	var tbl = document.getElementById('vitalcaretable');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('vitalcarecount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='radiovitalCare'+iteration;
	e1.id='radiovitalCare'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name='vitalName'+iteration;
	e1.id='vitalName'+iteration;
	e1.options[0] = new Option('Select', '0');
	var vitalCount=0;
	<%
	
	for (String vital : vitalList) {
		%>
		vitalCount++;
		e1.options[vitalCount] = new Option('<%=vital%>','<%=vital%>');
<%
	}
%>
	   e1.onblur=function(){
		   validateDuplicateVitalCare(iteration);
			}; 
	cellRight1.appendChild(e1);

	
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name='vitalFrequency'+iteration;
	e1.id='vitalFrequency'+iteration;
	e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<frequencyArray.length;i++ ){
	e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	} 
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='vitalstop'+iteration;
	e1.id='vitalstop'+iteration;
	e1.value='1';
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='vitalRemarks'+iteration;
	e1.id='vitalRemarks'+iteration;
	/* e1.onblur=function(){
	populatebrand(this.value, iteration);
	checkItem(iteration);
	}; */
	cellRight1.appendChild(e1);
	
}

function removeRowForVitalcare()
{
  var tbl = document.getElementById('vitalcaretable');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('vitalcarecount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("radiovitalCare"+i)!=null && (typeof  document.getElementById("radiovitalCare"+i).checked)!='undefined' && document.getElementById("radiovitalCare"+i).checked )
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
    		  if(document.getElementById("radiovitalCare"+i)!=null && (typeof  document.getElementById("radiovitalCare"+i).checked)!='undefined' && document.getElementById("radiovitalCare"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("radiovitalCare"+i).parentNode.parentNode;
    		  document.getElementById("radiovitalCare"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}

function checkForAllergy(val,inc){
	//alert(val+"<<<-------val======inc------>>"+inc);
	var visitId=<%=inpatient.getHin().getId()%>;
	//alert("visitId---->>>>"+visitId);
	var id;
	if(val!=""){

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }

		xmlHttp.onreadystatechange=function()
		{
		  if(xmlHttp.readyState==4){
			var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		         icdString  = item.getElementsByTagName('allergyString')[0];
		      //  alert("icdString"+icdString);
		         b =icdString.childNodes[0].nodeValue
		      // alert("b-->>"+b);
		       
		        // var val=document.getElementById('icd').value;
		         var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				  //  alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				  
				    if(b=='true'){
						   alert("Patient is allergic to this message!!");
						   document.getElementById('nomenclaturetreatment'+inc).value="";
					   }
				    }
					
		  }
		  }
		//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
		  	
		 
				var url="/hms/hms/ipd?method=getItemForAllergy&val="+val+"&visitId="+visitId;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

			
	}
}
</script>
<script>
function checkForPendingService(ipId){
	//alert("ipId----->>"+ipId);
	
	if(ipId!="0" && ipId!=""){

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }

		xmlHttp.onreadystatechange=function()
		{
		  if(xmlHttp.readyState==4){
			var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		         icdString  = item.getElementsByTagName('pendingString')[0];
		         b =icdString.childNodes[0].nodeValue;	  
				    if(b=='true'){
						 //  confirm("Some Prescription && Investigations are pending for the patient!!");
						   //document.getElementById('nomenclaturetreatment'+inc).value="";
						   if(confirm("Are you sure!!\n  Some Prescription && Investigations are pending for the patient!!")){
							   document.getElementById('readyToDischarge').checked=true;
							   document.getElementById('dischargeLink').style.display = "block";
						   }else {
							   document.getElementById('readyToDischarge').checked=false;
							   document.getElementById('dischargeLink').style.display = "none";
							   }
						   }else{
							   if(document.getElementById('readyToDischarge').checked==false){
								 document.getElementById('dischargeLink').style.display = "none";
								 document.getElementById('country11').style.display = "none";
								 //document.getElementById('dischargeLink').className="";
								}else{
							      document.getElementById('dischargeLink').style.display = "block";
							      //document.getElementById('dischargeLink').className="selected";
								}
						   }
					   }
				    }
					
		  }
			
	var url="/hms/hms/ipd?method=getDetailsForPendingServices&inpatientId="+ipId;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
			}
}
</script>
<script>
// added by Amit Das on 08-03-2016
function addPackageServiceIntoInvestigation(){
	var hdb = document.getElementById('hiddenValue');
	var iteration = parseInt(hdb.value);
	var e = document.getElementById("pkgSchemeId");
	var pkgSchemeId = e.options[e.selectedIndex].value;
	e = document.getElementById("pkgServiceId");
	var pkgServiceName = e.options[e.selectedIndex].text;
	var serviceFlag = true;
	
	for(var i=1;i<iteration;i++){
 	if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value==pkgServiceName){
 		alert('This Investigation is already selected.');
 		serviceFlag = false;
 		}
 	}

	
	if(serviceFlag && (document.getElementById('pkgHeaderId').disabled)){
		document.getElementById("chargeCodeName"+iteration).value = pkgServiceName;
		document.getElementById("isPackageFlag"+iteration).value = 'y';
		document.getElementById("serviceSchemeId"+iteration).value = pkgSchemeId;		
		addRowForInvestigation();
	} else if(!(document.getElementById('pkgHeaderId').disabled)) {
		alert("Please select package first !");
	}
	
}

function disablePkgFlag(val){
	document.getElementById(val).value = 'n';
}

function togglePackage(){
	var e = document.getElementById("pkgHeaderId");
	var pkgHeaderId = e.options[e.selectedIndex].value;
	e = document.getElementById("pkgSchemeId");
	var pkgSchemeId = e.options[e.selectedIndex].value;
	var pkgCharge = document.getElementById('pkgCharge').value;
	var schemeLimit = document.getElementById("schemeLimit").value;
	var balanceUtilized = document.getElementById("balanceUtilized"+pkgSchemeId).value;
	
	
	if(document.getElementById('pkgHeaderId').disabled){
		document.getElementById('pkgHeaderId').disabled = false;
		document.getElementById('pkgSchemeId').disabled = false;
		document.getElementById('packageSelector').value = 'Select Package';
		document.getElementById('pkgCharge').value = '0';
		document.getElementById("balanceUtilized"+pkgSchemeId).value = parseFloat(balanceUtilized)-parseFloat(pkgCharge);
		document.getElementById('pkgId').value = '';
		document.getElementById('pkgScheme').value = '';
		removeRowOfPackage();
	} else if(!(document.getElementById('pkgHeaderId').disabled) && pkgHeaderId!='0') {
		
		if((parseFloat(pkgCharge)+parseFloat(balanceUtilized))>parseFloat(schemeLimit)){
			alert("Not enough balance in card to add this Package !");
		} else {
		document.getElementById('pkgHeaderId').disabled = true;
		document.getElementById('pkgSchemeId').disabled = true;
		document.getElementById('packageSelector').value = 'Deselect Package';
		document.getElementById('pkgId').value = pkgHeaderId;
		document.getElementById('pkgScheme').value = pkgSchemeId;
		document.getElementById("balanceUtilized"+pkgSchemeId).value = parseFloat(pkgCharge)+parseFloat(balanceUtilized);
		}
		
	}
}


function removeRowOfPackage()
{
  var tbl = document.getElementById('investigationGrid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hiddenValue');
  var pkgCharge = document.getElementById("pkgCharge").value;
  var iteration = parseInt(hdb.value);
  var e = document.getElementById("pkgSchemeId");
  var schemeId = e.options[e.selectedIndex].value;
  var totalSelected=0;
  if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("isPackageFlag"+i)!=null && document.getElementById("isPackageFlag"+i).value == 'y' )
    		  {
    		  		var deleteRow= document.getElementById("investigationtradio"+i).parentNode.parentNode;
    		  		document.getElementById("investigationtradio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
    	 	 var oldBalanceUtilized = document.getElementById("balanceUtilized"+schemeId).value;
			 document.getElementById("balanceUtilized"+schemeId).value = parseFloat(oldBalanceUtilized) - parseFloat(pkgCharge);  
  }
        
  addRowForInvestigation();
  
}


function getReferDoctors(){
	var refer;
	if(document.getElementById('referToId').checked==true){
		refer="y";
		document.getElementById('referDivId').style.display="inline";
		document.getElementById('referToId1').value="y";
	}
	else if(document.getElementById('referToId').checked==false)
	{
		refer="n";
		document.getElementById('referDivId').style.display="none";
		document.getElementById('referToId1').value="n";
	}
	}
	
	function popwindowUploadDocuments(tempId)
{
	var array = new Array();
	array= tempId.split("@@@");
	var hinId= array[0];
	var inpatientId= array[1];


	var url="/hms/hms/opd?method=openUploadPopWindow&hinId="+hinId+"&inpatientId="+inpatientId+"&"+csrfTokenName+"="+csrfTokenValue;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
}
	function openPopupWindow(){
		   var requestId=document.getElementById("requestId").value.trim();
			
		 window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
		}
	function popwindowResultEntry(tempId)
	{
		var array = new Array();
		array= tempId.split("@@@");
		var hinId= array[0];
		var visitId= array[1];


		var url="/hms/hms/investigation?method=showPendingResultEntryTemplateOPD&hinId="+hinId+"&RequisitionFrom=OPD&"+csrfTokenName+"="+csrfTokenValue;
	 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1124,status=1,scrollbars=1,resizable=0");
	}
	
	// added by amit das on 22-07-2016
	/* function display(obj){
		 submitProtoAjaxNew('ipdCaseSheet','/hms/hms/ipd?method=getGroupAndParameterValues&tempLate='+obj,'specialityDiv');
	} */
	
	window.onload= callDiagnoseSet('<%=icdVal%>','<%=icName%><%=icCode%>');
	
	function checkFrequencyForTaperedDrugs(inc){
		var count = document.getElementById('hdbtreatment').value;
		
	
		for (var i = 0; i < count; i++) {
			
			if (document.getElementById('nomenclaturetreatment' + i) != null
					&& document.getElementById('nomenclaturetreatment' + i).value == document.getElementById('nomenclaturetreatment' + inc).value
					&& i != inc) {
				
					if(document.getElementById('frequencytreatment' + i).value!='0' &&  document.getElementById('dosagetreatment' + i).value!=''){
						
						if(document.getElementById('frequencytreatment' + i).value==document.getElementById('frequencytreatment' + inc).value && document.getElementById('dosagetreatment' + i).value==document.getElementById('dosagetreatment' + inc).value){
							alert('This Prescription is already selected with same dosage and frequency.');
							document.getElementById('frequencytreatment' + inc).value = "0";
							return false;
					}
					
				}
			}
		}
		return true;
	}
	
	
	
	
	function validationVal()
	{
		
		var motherAge = document.getElementById("motherAge").value;
	var ageOfMarriage = document.getElementById("ageOfMarriage").value;
	if(ageOfMarriage>motherAge)
		{
			alert("Please Age at Marriage is not greater and equal to Mother's age");
			document.getElementById("ageOfMarriage").value="";
			return false;
		
		}
		
	return true;
	}
	
	
	//added by govind 25-10-2017
		function openTaperedMedicine(url) {
			/*submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);*/
			window.open(url,
							"opd_window",
							"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
		}		
		
	function editTaperedMedicine(row,itemId){
		//alert("editTaperedMedicine");
		var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&'+getFormData('taperedForm')+'&taperedEdit=Y'+'&type=IP'+'&row='+row+'&' + csrfTokenName + '='
		+ csrfTokenValue;
		openTaperedMedicine(url);
	}

	function getFormData(formName) {
		   var str="";
		   inputs = eval('document.'+formName+'.elements');
		   // alert(inputs.length);
		   for(i=0;i<inputs.length;i++){
		   	str=str+inputs[i].name+"="+inputs[i].value+"&"
		   }
		   return str;
	}
	//added by govind 25-10-2017
	//......................Js For Discharge Medication..................
	
	function checkFrequencyForTaperedDrugsDM(inc){
		var count = document.getElementById('DMhdbtreatment').value;
		
	
		for (var i = 0; i < count; i++) {
			
			if (document.getElementById('DMnomenclaturetreatment' + i) != null
					&& document.getElementById('DMnomenclaturetreatment' + i).value == document.getElementById('DMnomenclaturetreatment' + inc).value
					&& i != inc) {
				
					if(document.getElementById('DMfrequencytreatment' + i).value!='0' &&  document.getElementById('DMdosagetreatment' + i).value!=''){
						
						if(document.getElementById('DMfrequencytreatment' + i).value==document.getElementById('DMfrequencytreatment' + inc).value && document.getElementById('DMdosagetreatment' + i).value==document.getElementById('DMdosagetreatment' + inc).value){
							alert('This Prescription is already selected with same dosage and frequency.');
							document.getElementById('DMfrequencytreatment' + inc).value = "0";
							return false;
					}
					
				}
			}
		}
		return true;
	}

	
	function getFrequencyValueDM(feqValue,inc){
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
		 document.getElementById('DMfrequencyValue'+inc).value = feqQty;
	}
	
	 function  fillValueFromFrequencyDM(value,inc){
	   	  var dosage = document.getElementById('DMdosagetreatment'+inc).value;
		  var noOfDays=document.getElementById('DMnoOfDaystreatment'+inc).value
		  var freq=document.getElementById('DMfrequencyValue'+inc).value
		  document.getElementById('DMtotaltreatment'+inc).value=Math.round(noOfDays*freq*dosage)
		  var dispenseQty = document.getElementById('DMactualDispensingQty'+inc).value;
	   	  var sosQty = document.getElementById('DMsosQty'+inc).value;
		  var total = freq*noOfDays*dosage;
		  var finalQty;
		  if(document.getElementById('DMfrequencytreatment'+inc).value != 13 ){
		  if(document.getElementById('DMactualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('DMtotaltreatment'+inc).value=Math.round(finalQty);
			  document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
			 }else{
				  document.getElementById('DMtotaltreatment'+inc).value=Math.round(noOfDays*freq*dosage);
			  }
		  }else{
			  if(document.getElementById('DMactualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('DMtotaltreatment'+inc).value=Math.round(finalQty);
			
				 }else{
					  document.getElementById('DMtotaltreatment'+inc).value=Math.round(sosQty*freq*dosage);
				  }
		  }
		 }
	 function DateCheck(dd,mm,yy)
	 {
	   var StartDate= document.getElementById('fromDateId').value;
	   var EndDate= document.getElementById('toDateId').value;
	   var eDate = new Date(EndDate);
	   var sDate = new Date(StartDate);
	   if(StartDate!= '' && StartDate!= '' && sDate> eDate)
	     {
	     alert("Please ensure that the End Date is greater than or equal to the Start Date.");
	     document.getElementById('toDateId').value=dd+"/"+mm+"/"+yy;
	     document.getElementById('fromDateId').value=dd+"/"+mm+"/"+yy;
	     return false;
	     }
	 }
	 function TDate(dd,mm,yy) {
		    var EndDate = document.getElementById('toDateId').value;
		    var ToDate = new Date();
		    var eDate = new Date(EndDate);
		    if (isNaN(eDate)) {
		    	alert("Please Enter Valid Date");
		    	document.getElementById('toDateId').value=dd+"/"+mm+"/"+yy
		          return false;
		     }
		    return true;
		}
	 function FDate(dd,mm,yy) {
		    var EndDate = document.getElementById('fromDateId').value;
		    var ToDate = new Date();
		    var eDate = new Date(EndDate);
		    if (isNaN(eDate)) {
		    	alert("Please Enter Valid Date");
		    	document.getElementById('fromDateId').value=dd+"/"+mm+"/"+yy
		          return false;
		     }
		    return true;
		}
	 function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        alert("Please Enter Only Numeric Value");
		    	return false;
		    }
		    return true;
		}
	 
	 function checkForBlockedMedicine(val, inc) {
			// alert(val+"<<<-------val======inc------>>"+inc);
			var hinId = document.getElementById("hinId").value;
			var id;
			if (val != "") {

				var xmlHttp;
				try {
					// Firefox, Opera 8.0+, Safari
					xmlHttp = new XMLHttpRequest();
				} catch (e) {
					// Internet Explorer
					try {
						xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						alert(e)
						try {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							alert("Your browser does not support AJAX!");
							return false;
						}
					}
				}

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4) {
						
						var responseJson = JSON.parse(this.responseText);
						
						if(responseJson.matched==true){
							var message="";
							if(responseJson.blockedDays!=null && responseJson.blockedDays!="" && responseJson.blockedDays!=0){
								message="This Medicine is Blocked By "+responseJson.blockedDoctor+" For "+responseJson.blockedDays+" Days. Do You Want to UnBlock It?";
							}else{
								message="This Medicine is Blocked By "+responseJson.blockedDoctor+" Do You Want to UnBlock It?";
							}
							document.getElementById("blockMedicineMsg").innerHTML=message;
							
							document.getElementById("blockMedicineMsg").value=responseJson.allergyTid;
							document.getElementById("incrementNum").value=inc;
							 
							var modal = document.getElementById('myModal');
							modal.style.display = "block";	
						}else{
							//checkForAllergy(val, inc);
						}
						
					}
				}
				var url = "/hms/hms/ipd?method=checkForBlockedMedicine&val=" + val
						+ "&hinId=" + hinId + "&" + csrfTokenName + "="
						+ csrfTokenValue;
				xmlHttp.open("GET", url, true);
				xmlHttp.setRequestHeader("Content-Type", "text/xml");
				xmlHttp.send(null);
			}
		}
	 
	 function closePopUp(){
			var incr=document.getElementById("incrementNum").value;
			var val=document.getElementById("nomenclaturetreatment"+incr).value;
			document.getElementById("nomenclaturetreatment"+incr).value="";
			var modal = document.getElementById('myModal');
			modal.style.display = "none";
			
			//checkForAllergy(val, incr);
			
		}
	 function unBlockMedicine(){
			var medicineTableId=document.getElementById("blockMedicineMsg").value;
			if (medicineTableId != "") {

				var xmlHttp;
				try {
					// Firefox, Opera 8.0+, Safari
					xmlHttp = new XMLHttpRequest();
				} catch (e) {
					// Internet Explorer
					try {
						xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						alert(e)
						try {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							alert("Your browser does not support AJAX!");
							return false;
						}
					}
				}

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4) {
						var modal = document.getElementById('myModal');
						modal.style.display = "none";

					}
				}
				var url = "/hms/hms/opd?method=unBlockMedicine&medicineTableId=" + medicineTableId;
				xmlHttp.open("GET", url, true);
				xmlHttp.setRequestHeader("Content-Type", "text/xml");
				xmlHttp.send(null);
			}
			
		}
		 	 
</script>

<script type="text/javascript">	
  				var	relationArray= new Array();
                      <%
				         for (int k = 0; k < relationList.size(); k++) {
				        	 MasRelation  masRelation = (MasRelation) relationList.get(k);
	     			 %> 
	     			relationArray[<%=k%>]= new Array();
	     			relationArray[<%=k%>][0] = "<%=masRelation.getId()%>";
	     			relationArray[<%=k%>][1] = "<%=masRelation.getRelationName()%>";
	             <% }%>
	             </script>



<style>
.newWndPopUp{width:100%; float:left;margin:0px; padding:0px;}
.newWndPopUp input[type="button"]{font-size:11px;height:20px;padding: 0px 6px;}
.opdArea {width:1170px; float:left;}
.sysExmLeftDiv{width:557px; float:left;}
.wdthLrg{width:377px!important;}
.sizeFont {font-size:11px !important; height:20px !important; margin:3px 0px 0px 0px !important; padding:0px 4px !important;}
.wdthSm {width:99.2%;}
</style>





