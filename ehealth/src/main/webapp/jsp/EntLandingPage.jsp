
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreOutItem"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PhDiseaseRegistration"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<script type="text/javascript" src="/hms/jsp/js/newTab.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/prescription.js"></script>

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
<script type="text/javascript" src="/hms/jsp/js/jquery.multi-select.js"></script>
<link rel="stylesheet" type="text/css"
	href="/hms/jsp/css/multiselect.css">
	<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript">
		   var icdArray=new Array();
		   var allergyTypeArray=new Array();
		   var saverityCodeArray=new Array();
</script>
<script type="text/javascript">
	jQuery.noConflict();

	jQuery(document).ready(function($) {
		//Tab_function 1
		//Default Action
		$(".tab_content").hide(); //Hide all content
		$("ul.tabsClass li:first").addClass("active").show(); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
		$("ul.tabsClass li").click(function() {
			$("ul.tabsClass li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content
			var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active content
			return false;
		});
	});

	jQuery(document).ready(function($) {
		//Tab_function 2
		//Default Action
		$(".tab_content2").hide(); //Hide all content
		$("ul.tabsClass2 li:first").addClass("active2").show(); //Activate first tab
		$(".tab_content2:first").show(); //Show first tab content

		//On Click Event
		$("ul.tabsClass2 li").click(function() {
			$("ul.tabsClass2 li").removeClass("active2"); //Remove any "active" class
			$(this).addClass("active2"); //Add "active" class to selected tab
			$(".tab_content2").hide(); //Hide all tab content
			var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active content
			return false;
		});
	});
</script>

<script>
	jQuery(function($) {

		function split(val) {
			return val.split(/,\s*/);
		}
		function extractLast(term) {
			return split(term).pop();
		}

		$( ".historyAutoComplete" )
	    .autocomplete({
		    minLength: 1,
			source: function( request, response ) {
	            // delegate back to autocomplete, but extract the last term
				var arTerm=request.term.split(",");
				var searchTerm=arTerm[arTerm.length-1].trim();
				console.log("terms :: "+searchTerm);
				servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
				var refsetidParam = document.getElementById('refsetId').value;
				
				
				
				servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
	            $.getJSON(servURL,
	            		function (data)
				{ 
	            	var array = data.error ? [] : $.map(data, function(m) {
						return {
							label: m.term ,
							 value:  m.conceptId 
						};
					});
					response(array);
				
	            });
	        },
	        focus: function() {
	            // prevent value inserted on focus
	            return false;
	        },
	        select: function( event, ui ) {
	            var terms = split( this.value );
	         	// remove the current input
	            terms.pop();
	          
	            terms.push( ui.item.label );
	            // add placeholder to get the comma-and-space at the end
	            terms.push( "" );
	            var snomedCount =   $('#snomedCount').val();
	            snomedCount = parseInt(snomedCount)+1;
	            $('#snomedCount').val(snomedCount) ;
	           
	            var fieldType = $(this).prev().text().replace(/\s+/g," ");
	       		if(fieldType == 'GIS'){
	       			fieldType = 'Systemic Examination';
	       		}
	       		if(fieldType=='Provisional Diagnosis' || fieldType=='Final Diagnosis' ){
	       			var diagnosis_status="";
	       			var diagnosisId="";
	       			document.getElementById("snomedTermConceptId").value=ui.item.value;
	       			document.getElementById("snomedTermConceptIdEXM").value=ui.item.value;
	       			
	       			if(fieldType=='Provisional Diagnosis' ){
	       				removeDiagnosisId ="finalDiagnosis";
	       				diagnosis_status='p';}
	       			else if(fieldType=='Final Diagnosis'){
	       				removeDiagnosisId="snomed";
	       				diagnosis_status='f';}
	       			console.log(document.getElementById("diagnosis_status").value +" sfsf");
	       			console.log("resu="+document.getElementById("diagnosis_status").value!="");
	       			
	       			if(document.getElementById("diagnosis_status").value!="" &&document.getElementById("diagnosis_status").value!=diagnosis_status)
       				{	document.getElementById(removeDiagnosisId).value='';
       				console.log("succes");
       			           $("#diagnosisId option").remove();
       				}
	       		  document.getElementById("diagnosis_status").value=diagnosis_status;
	       			
	       			getICDListBasedOnSnomedId();
	       		 this.value = terms.join( "," );
	       		return false;
	       		}else{
	           $('#termTable').append("<input type='text' name ='snomedId"+snomedCount+"' value ='"+ui.item.value+"' />"+"<input type='text' name ='snomedDesc"+snomedCount+"' value ='"+ui.item.label+"'/><input type='text' name ='fieldType"+snomedCount+"' value ='"+fieldType+"'/>");
	       /*    $('#termTable').append("<tr>");
	          $('#termTable').append("<td><input type='text' name ='termValue' value ='"+ui.item.value+"' /></td>");
	          $('#termTable').append("<td><input type='text' name ='termLabel' value ='"+ui.item.label+"'/></td>");
	          $('#termTable').append("<td><input type='text' name ='termType' value ='Present Complaint'/></td>");
	          $('#termTable').append("</tr>"); */
	           	
	       		 $("#termTable td").each(function () {
	       		    var tdText = $(this).text();
	       		    $("#termTable td").filter(function () { 
	       		            return tdText == $(this).text(); 
	       		        }).not(":first").remove();
	       		});
	       		
	            this.value = terms.join( "," );
	            return false;
	       		}
	        }
	    });
	});
	</script>
	


<script type="text/javascript">
	var callbck_index = function(ret_OUT) {
		setValue(ret_OUT);
	};
	var semantictag_IN;
	var acceptability_IN;
	var state_IN;
	var returnlimit_IN;
	var retterm_value = {};
	function setValue(selectedSNOMEDTerm) {
		document.getElementById("snomedTermConceptId").value = selectedSNOMEDTerm;
		document.getElementById("snomedTermConceptIdEXM").value = selectedSNOMEDTerm;
	}
	function isNumeric(e) {
		e.value = (e.value.replace(/[^0-9]/g, ''));
	}

	function ismaxlength(obj) {
		var mlength = obj.getAttribute ? parseInt(obj.getAttribute("maxlength"))
				: "";
		if (obj.getAttribute && obj.value.length > mlength)
			obj.value = obj.value.substring(0, mlength)
	}
	
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
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Visit> patientDataList = null;
	if (map.get("patientDataList") != null) {
		patientDataList = (List) map.get("patientDataList");
	}
	Visit visit = null;
	if (patientDataList.size() > 0) {
		visit = (Visit) patientDataList.get(0);
	}
	List<OpdTemplate> templateListForInvestigation =null;
	if(map.get("templateListForInvestigation") != null){
		templateListForInvestigation=(List)map.get("templateListForInvestigation");
	}
	List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
	if(map.get("routeOfAdministrationList") != null)
	{
		routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	List<OpdInstructionTreatment> masInstructionMasterList =null;
	if(map.get("masInstructionMasterList") != null)
	{
	  masInstructionMasterList=(List<OpdInstructionTreatment>)map.get("masInstructionMasterList");
	}
	List<MasDepartment> wardDepartmentList = new   ArrayList<MasDepartment>();
	if(map.get("wardDepartment") != null)
	{
		wardDepartmentList=(List<MasDepartment>)map.get("wardDepartment");
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
  	List<Object[]> masHospitals = new ArrayList<Object[]>();
  	if(map.get("masHospitals") != null)
	{
  		masHospitals=(List<Object[]>)map.get("masHospitals");
	}
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
		deptList=(List)map.get("deptList");
	}
	
	List<DgOrderdt> dgOrderdts= null;
	if(map.get("dgOrderdts") != null)
	{
		dgOrderdts=(List<DgOrderdt>)map.get("dgOrderdts");
	}

    List<DgSampleCollectionDetails> dgSampleCollectionDetails= null;
	if(map.get("dgSampleCollectionDetails") != null)
	{
		dgSampleCollectionDetails=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetails");
	}
	List<PatientInvestigationDetails> patientInvestigationDetails= new ArrayList<PatientInvestigationDetails>();
	if(map.get("patientInvestigationDetails") != null)
	{
		patientInvestigationDetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetails");
	}

	List<PatientPrescriptionDetails> patientPrescriptionDetails= null; 
 	if(map.get("patientPrescriptionDetails") != null){
		patientPrescriptionDetails=(List)map.get("patientPrescriptionDetails");
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
	
	List<MasStoreOutItem> masStoreOutItemsList = new   ArrayList<MasStoreOutItem>();
	if(map.get("masStoreOutItemsList") != null)
	{
		masStoreOutItemsList=(List<MasStoreOutItem>)map.get("masStoreOutItemsList");
	}
	
	List<String>patientWiseMlcs=new ArrayList<String>();
	List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
	List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
	if(map.get("patientWiseMlcs") != null){
		patientWiseMlcs=(List)map.get("patientWiseMlcs");
	} 
	
	if(map.get("allergyProductsList") != null){
		allergyProductsList=(List)map.get("allergyProductsList");
	}
	
	if(map.get("saverityCodesList") != null){
		saverityCodesList=(List)map.get("saverityCodesList");
	} 
	
	List<PatientPrescriptionDetails> patientOtherPrescriptionDetails= new ArrayList<PatientPrescriptionDetails>();
	if(map.get("patientOtherPrescriptionDetails") != null)
	{
		patientOtherPrescriptionDetails=(List<PatientPrescriptionDetails>)map.get("patientOtherPrescriptionDetails");
	}
	String departmentCode =null;
	if(map.get("departmentCode") != null){
		 departmentCode = (String)map.get("departmentCode");
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
		referredDept = opdPatientDetails.getReferedDepartment()!=null?opdPatientDetails.getReferedDepartment().getId():0; //Added by Arbind on 15-03-2017
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int hospitalTypeId=0;
	if(map.get("hospitalTypeId")!=null)
    {
		hospitalTypeId = (Integer)map.get("hospitalTypeId");
    } 
	int districtId=0;
	if(map.get("districtId")!=null)
    {
		districtId = (Integer)map.get("districtId");
    } 
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
    if(map.get("bloodGroupList")!=null){
    	bloodGroupList = (List)map.get("bloodGroupList");
    }
    String bloodGroupValue = "";
    if(map.get("bloodGroupValue")!=null){
    	bloodGroupValue = ((String)map.get("bloodGroupValue")).trim();
    }
    String bloodGroupStatus = "";
    if(map.get("bloodGroupStatus")!=null){
    	bloodGroupStatus = (String)map.get("bloodGroupStatus");
    }
    
    List<DischargeIcdCode> dischargeIcdCodeLast3Visit = new ArrayList<DischargeIcdCode>();
	if(map.get("dischargeIcdCodeLast3Visit") != null)
	{
		dischargeIcdCodeLast3Visit=(List<DischargeIcdCode>)map.get("dischargeIcdCodeLast3Visit");
	}
	if(map.get("allergyProductsList") != null){
		allergyProductsList=(List)map.get("allergyProductsList");
	}
	
	if(map.get("saverityCodesList") != null){
		saverityCodesList=(List)map.get("saverityCodesList");
	} 
	
	List<OpdPatientAllergyT>opdPatientAllergyTs= new ArrayList<OpdPatientAllergyT>();
	if(map.get("opdPatientAllergyTs") != null)
	{
		opdPatientAllergyTs=(List<OpdPatientAllergyT>)map.get("opdPatientAllergyTs");
	}
	
	
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
	
	
	
	
  	Integer pulse=0;
  	Float temperature=0f;
  	String bpSystolicDiastolic="";
  	Float bmi=0f;
  	Float respirtoryRate=0f;
  	Float spo2=0f;
  	String bmiStatus="";
  	Double height=0.0;
  	Double weight=0.0;
  	String stuning = null;
  	String pem = null;
  	String wasting = null;
  	String presentComplaintHistory="";
	String personalPresentHistory="";
	String familyPastHistory="";
	String physicalExamination="";
	String madicationHistory="";
	String[] parts={"",""};
	String noSysDias="";
	String treatmentPlan =null;
	String surgeryHistory =null;
	String medicationhistory =null;
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
  	  System.out.println("preOpdPatientDetails.getHeight() "+preOpdPatientDetails.getHeight() +" fgh"+preOpdPatientDetails.getId());
  		height=preOpdPatientDetails.getHeight()!=null?preOpdPatientDetails.getHeight():0.0;
  		weight=preOpdPatientDetails.getWeight()!=null?preOpdPatientDetails.getWeight():0.0;
  		respirtoryRate =preOpdPatientDetails.getRespiratoryRate()!=null?preOpdPatientDetails.getRespiratoryRate():0;
  		spo2 = preOpdPatientDetails.getSpo2()!=null?preOpdPatientDetails.getSpo2():0;
  		 stuning = preOpdPatientDetails.getStuning()!=null?preOpdPatientDetails.getStuning():null;
  	  	 pem = preOpdPatientDetails.getPem()!=null?preOpdPatientDetails.getPem():null;
  	  	 wasting = preOpdPatientDetails.getWasting()!=null?preOpdPatientDetails.getWasting():null;
  	     
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
  		treatmentPlan = preOpdPatientDetails.getTreatmentPlan();
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
  		 surgeryHistory = preOpdPatientHistory.getSurgicalHistory() !=null?preOpdPatientHistory.getSurgicalHistory():"";
  	  	 medicationhistory = preOpdPatientHistory.getMadicationHistory()!=null?preOpdPatientHistory.getMadicationHistory():"";
	}else if(map.get("majorHealthIssue") != null)
	{
		presentComplaintHistory=(String)map.get("majorHealthIssue");
	}


String personalPresentHistoryMember="";
String majorHealthIssue="";
	boolean ncd=false;
List<PhMemberSurvey> phMemberSurveyList =new ArrayList<PhMemberSurvey>();
List<PhDiseaseRegistration> phNCDRegList =new ArrayList<PhDiseaseRegistration>();
  	if(map.get("phMemberSurveyList") != null)
	{
  		phMemberSurveyList=(List<PhMemberSurvey>)map.get("phMemberSurveyList");
  		
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
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");
	
	int deptIdSession = 0;
	if(session.getAttribute("deptId")!=null){
		deptIdSession= (Integer) session.getAttribute("deptId");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int docId=0;
	  if(session!=null){
		  docId= (Integer)session.getAttribute("empId");
	  }
		int OrderId=0;
		if(map.get("OrderId")!=null)
	    {
			OrderId = (Integer)map.get("OrderId");
	    }
	String uhid = null;
	String patientName = "";
	String age = "";
	int patientAge = 0;
	String gender = "";
	String yearMonth = "";
	int hinId=0;
	int visitId=0;
	if(visit!=null)
	{
		hinId = visit.getHin().getId();
		visitId = visit.getId();
	}
	String patientRsbyCardNo = "";
	if (visit.getHin().getRsbyCardNo() != null
			&& !visit.getHin().getRsbyCardNo().trim().equals("")) {
		patientRsbyCardNo = visit.getHin().getRsbyCardNo();
	}

	uhid = visit.getHin().getHinNo();
	if (visit.getHin().getPFirstName() != null) {
		patientName = visit.getHin().getPFirstName();
	}
	if (visit.getHin().getPMiddleName() != null) {
		patientName = patientName + " "
				+ visit.getHin().getPMiddleName();
	}
	if (visit.getHin().getPLastName() != null) {
		patientName = patientName + " " + visit.getHin().getPLastName();
	}
	if (visit.getHin().getAge() != null) {
		age = !visit.getHin().getAge().equals("") ? visit.getHin()
				.getAge() : "";
		if (age.length() > 0) {
			patientAge = Integer.parseInt(age.split(" ")[0]);
		}
	}
	if (visit.getHin().getDateOfBirth() != null) {
		Date dob = visit.getHin().getDateOfBirth();
		String ymd = HMSUtil.calculateYearMonthDay(dob);
		String d[] = ymd.split("&");

		int year1 = Integer.parseInt(d[0].toString());
		int months1 = Integer.parseInt(d[1].toString());
		int days1 = Integer.parseInt(d[2].toString());
	/* 	System.out.println("years " + year1 + " month " + months1
				+ " days " + days1); */
		yearMonth = year1 != 0 ? d[0] + " Y " : "";
		yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
		yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
	}

	if (visit.getHin().getSex() != null) {
		gender = visit.getHin().getSex().getAdministrativeSexName();
	}
	String display = "none";
	if (visit.getHin().getSex() != null
			&& visit.getHin().getSex().getAdministrativeSexCode()
					.equals("F")
			&& visit.getHin().getSex().getId() == 2) {
		display = "block";
	}

	String visitDateInString = HMSUtil.changeDateToddMMyyyy(visit
			.getVisitDate());
	int deptId = visit.getDepartment().getId();
	
	
%>

<div class="clear"></div> 

<div class="clear"></div> 
<div class="clear"></div>
<input name="request" id="requestId" type="hidden"
			value="<%=visit.getHin().getId()%>" />
<div class="mgmtDivMain">
<div class="mgmtMenuDiv">
<input name="" id="" class="buttonAuto" value="Patient History" onclick="showPatientHistory('<%=visit.getHin().getHinNo() %>',csrfTokenName+'='+csrfTokenValue)"
				type="button"> 
		<!-- 	<input name="" id="" class="buttonAuto" onclick="openPopupWindowAllergy(csrfTokenName+'='+csrfTokenValue);"
				value="Allergy" type="button">  -->
			<input name="" id="" onclick="popwindowResultEntry('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>');"
				class="buttonAuto" value="Result Entry" type="button"> 
			<input onclick="openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>');"
				name="" id="" class="buttonAuto" value="Lab Results" type="button">
			<input name="" id="" class="buttonAuto" onclick="showParkPatient('p');"
				value="List of Parked Patients" type="button"> 
			<input onclick="openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');"
				name="" id="" class="buttonAuto" value="NCD Clinic" type="button">
			<input name="" id="" class="buttonAuto" value="Upload Document" onclick="popwindowUploadDocuments('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue);"
				type="button">

</div>
</div>
<div class="clear"></div> 


<div class="clear"></div>
<form name="opdMain" action="" method="post">
<div class="Block">
<div class="tabContainerMain">

<ul class="tabsClass" id="countrytabsIn" >
<li><a href="#tab1">OP Consultation</a></li>
<%-- <%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")) || departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))){%> --%>
<li><a href="#tab2">Clinical Summary</a></li>
<%-- <%} %> --%>
<%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine"))){%>
 <li>
 <input name="splName" id="splName" type="hidden" 	value=""/>
 <a href="#tab4" onclick="display('37','Medicine','OP');">Medicine</a></li>
  <%}%>
  <%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics"))){%>
 <li>
 <input name="splName" id="splName" type="hidden" 	value=""/>
 <a href="#tab4" onclick="display('12','Orthopedic','OP');">Orthopedic</a></li>
  <%}%>
<li><a href="#tab3" id="mlcTab"  style="display: none">MLC</a></li>

</ul>

<!-- Tab Contenair start -->
<div class="tab_container">

<div id="tab1" class="tab_content">
<div class="clear"></div> 

        


<div class="Block">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
			
					<input type="hidden" name="refsetId" id="refsetId" value="null">
	<div class="floatRight" style="margin-right: 15px;">
		<label class="autoSpace "><input id="mlcCheck" name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()" type="checkbox">MLC</label>
	</div>

	<label style="vertical-align: baseline;"><img
		src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Data
			is part of EHR</span></label>
	<div class="clear"></div>

	<div class="titleBg">
		<h2>PATIENT DETAILS</h2>
	</div>
	<div class="clear"></div>
	<div class="paddingTop5"></div>

	<label>UHID</label> <input type="text" id="" name="" value="<%=uhid%>"
		tabindex="1" readonly="readonly" /> <label>Patient Name</label> <input
		type="text" id="" name="" value="<%=patientName%>" tabindex="1"
		title="" readonly="readonly" /> <label>Age</label> <input type="text"
		id="" name="" value="<%=yearMonth%>" tabindex="1" title=""
		class="small" readonly="readonly" />
	<div class="clear"></div>

	<label>Gender</label> <input type="text" value="<%=gender%>"
		readonly="readonly" /> <label>Comorbidity</label> <input type="text"
		id="" name="" value="" tabindex="1" title="" />

	<div class="clear"></div>
	<div class="paddingTop5"></div>
<%if(opdPatientDetails!=null && opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId().equals(deptId))
					{
					%>
	
<div class="titleBg">
<h2>Referred details</h2>
</div>
<div class="clear"></div>
	<div class="paddingTop5"></div>
					<input type="hidden" name="referralCase" value="yes"/>
					<label>Referred by Doctor</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getFirstName():"" %>" />
					<input type="hidden" id="" name="" readonly="readonly" /> <label
						class="auto">Departement From</label> <input type="text" id=""
						name="" readonly="readonly"
						value="<%=opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getDepartmentName():"" %>" />
					
					<label>Hospital From</label> <input type="text" id="" name=""
						readonly="readonly"
						value="<%=opdPatientDetails.getHospital()!=null?opdPatientDetails.getHospital().getHospitalName():"" %>" />
					<div class="clear"></div>
					<label>Date</label> <input type="text" 
						readonly="readonly"
						value="<%=opdPatientDetails.getOpdDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getOpdDate()):"" %>" />
					<label>Doctor Note</label>
					<textarea cols="0" rows="0" maxlength="200" " readonly="readonly"><%=opdPatientDetails.getReferralNotes()!=null?opdPatientDetails.getReferralNotes():"" %>
 					</textarea>

					<label>Patient Advice</label>
					<textarea cols="0" rows="0" maxlength="200" " readonly="readonly"><%=opdPatientDetails.getPatientAdvise()!=null?opdPatientDetails.getPatientAdvise():"" %>
 					</textarea>
					<div class="clear"></div>
					<label>Summary Consultation</label>
					<textarea cols="0" rows="0" maxlength="490" readonly="readonly"><%=opdPatientDetails.getSummaryConsultation()!=null?opdPatientDetails.getSummaryConsultation():"" %>
 					</textarea>
					<%} %>

	<div class="clear"></div>
	<div class="paddingTop5"></div>
<div class="tabContWidth2">
<label>Presenting Complaints</label>
<div class="clear"></div>
<textarea class="historyAutoComplete" name="presentComplain" id="presentComplain"  cols="0" rows="0" maxlength="500"><%=presentComplaintHistory!=null?presentComplaintHistory:""%></textarea>
</div>


<div class="tabContWidth2">
<label>History of Presenting Illness</label>
<div class="clear"></div>
<textarea  name="pastIllness" class="historyAutoComplete"  id="pastIllness" cols="0" rows="0" maxlength="500"  ><%=opdPatientHistoriesStr!=null?opdPatientHistoriesStr:"" %></textarea>
</div>



<div class="clear"></div> 


<div class="titleBg">
<h2>HISTORY</h2>
</div>

<div class="clear"></div> 
<div class="paddingTop5"></div>
	<!-- tab-1111 Start -->

		    <div class="tabContWidth5">
			    <label>Past History</label>
					 	<% if(ncd){%>
					<textarea name="personalHistory" id="personalHistory" cols="0"
					rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"><%=personalPresentHistory %><%=personalPresentHistoryMember %></textarea>
					<%}else{%>
						 <textarea name="personalHistory" id="personalHistory" cols="0"
					rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"><%=personalPresentHistory %><%=personalPresentHistoryMember %></textarea>
						 
					<%} %>	
			</div>

			<div class="tabContWidth5">
				<label>Surgical History</label>
				<textarea name="surgicalHistory" id="surgicalHistory" cols="0" rows="0"
					maxlength="500" tabindex="26" 
					class="historyAutoComplete"><%=surgeryHistory!=null?surgeryHistory:""%></textarea>
			</div>
				<div class="tabContWidth5">
				<label>Family History</label>
				<textarea name="familyHistory" id="familyHistory" cols="0" rows="0"
					maxlength="500" tabindex="26" 
					class="historyAutoComplete"><%=familyPastHistory %></textarea>
			</div>
			<div class="tabContWidth5">
				<label>Medication History</label>
				<textarea name="medicationhistory"
					validate="Medication History,string,no" id="medicationhistory"
					cols="0" rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"><%=medicationhistory!=null?medicationhistory:""%></textarea>
			</div>
				<%
				int incr=0 ;
				int len=1;
				if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))){%>
		<div class="tabContWidth5">
		<label>Permorbid Personality</label>
				<textarea name="permorbidPersonality"
					validate="Medication History,string,no" id="permorbidPersonality"
					cols="0" rows="0" maxlength="256" tabindex="26"
					 class="historyAutoComplete"></textarea>
		  </div>			 
		<%} else{%>
			<div class="tabContWidth5" style="width: 320px;">
			<div>
				<label style="width: 310px;"> <span style="float:left;color: black;">Allergies</span> 
				<span style="float:right;"><input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowForAllergy();">
				 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForAllergy();"> </span>
				</label>	
			</div>
					<div class="clear"></div>
						<div id="divTemplet" style="width:314px; height:78px; margin-left:5px; overflow:scroll; overflow-x:hidden;">
							<table style="width:100%; border-top: solid 1px #C0C0C0" id="alergyGrid">
								<tr>
									<th style="background: rgb(189, 214, 238);padding:0px;">&nbsp;</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Type</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Allergen</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Remarks</th>
									
								</tr>
								<% incr=0 ;
	 len=1;
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
	String allergyRemarks =null;
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
			allergyRemarks = opdPatientAllergyT.getAllergyRemarks();
		}		
	%>
								<tr>
									<td><input type="checkbox" class="radioCheck"
										name="allergyRadio<%=incr%>" id="allergyRadio<%=incr%>" /> <input
										type="hidden"
										value="<%=!allergyDetailId.equals(0)?allergyDetailId:0 %>"
										name="allergyDetailId<%=incr%>" id="allergyDetailId<%=incr%>" />
									</td>
									<td><select style="background: #FFFF99 ;width:62px;"
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
									<td><input type="text" class="largTextBoxOpd textYellow historyAutoComplete ui-autocomplete-input "
										tabindex="32"
										value="<%=allergyName!=null && !allergyName.equals("")?allergyName:"" %>"
										id="allergyName<%=incr%>" size="35"
										name="allergyName<%=incr%>" style="width: 68px;"" /> <div id="allergy_ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div> 
		
									<td><input class="small textYellow" name="allergy_remarks<%=incr%>" maxlength="30" value="<%=allergyRemarks!=null && !allergyRemarks.equals("")?allergyRemarks:"" %>"/></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="allergyHeaderIds"
								id="allergyHeaderIds" value="<%=allergyHeaderId%>" />
						</div>
				
					<input type="hidden" name="allergyCount" id="allergyCount"
						value="<%=incr-1%>" />
					<div class="clear"></div>
		
			</div> 
		
<%} %>
<!-- ----ENT changes----- -->
<div class="clear"></div> 
<div class="paddingTop5"></div>
	<!-- tab-1111 Start -->

		    <div class="tabContWidth5">
			    <label>Devlopment History</label>
					 <%-- 	<% if(ncd){%>
					<textarea name="developmentHistory" id="developmentHistory" cols="0"
					rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"></textarea>
			    	<%}else{%> --%>
						 <textarea name="entDevelopmentHistory" id="entDevelopmentHistory" cols="0"
					rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"></textarea>
						 
				<%-- 	<%} %>	 --%>
			</div>

			<div class="tabContWidth5">
				<label>Diet History</label>
				<textarea name="entDietHistory" id="entDietHistory" cols="0" rows="0"
					maxlength="500" tabindex="26" 
					class="historyAutoComplete"></textarea>
			</div>
			<div class="tabContWidth5">
				<label>Socio Economic History</label>
				<textarea name="entSocioEconomicHistory"
					validate="Socio Economic History,string,no" id="entSocioEconomicHistory"
					cols="0" rows="0" maxlength="500" tabindex="26"
					 class="historyAutoComplete"></textarea>
			</div>
				<%-- <%
				int incr=0 ;
				int len=1;
				if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))){%> --%>
		<div class="tabContWidth5">
		<label>Personal History</label>
				<textarea name="entPersonalHistory"
					validate="Personal History,string,no" id="entPersonalHistory"
					cols="0" rows="0" maxlength="256" tabindex="26"
					 class="historyAutoComplete"></textarea>
		  </div>			 
		<%-- <%} else{%> --%>
			
<%-- 		
<%} %> --%>
		<div class="clear"></div>
<div class="paddingTop5"></div>

			<div id="country4" class="tabcontenstIn">
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div class="clear"></div>

<!-- ------Ent changes end----- -->
		<div class="clear"></div>
<div class="paddingTop5"></div>

			<div id="country4" class="tabcontenstIn">
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div class="clear"></div>

		<div class="titleBg">
		<h2>VITALS</h2>
		</div>
		<div class="clear"></div> 
		<div class="paddingTop5"></div> 
		
		<table style="width:1157px; border-top:1px solid #C0C0C0; float:left;">
		  <tr>
		    <td>    
		    <label class="smallAuto">&nbsp;T:&nbsp;</label>
		    <input type="text"  id="temperature" name="temperature" value="<%=temperature>0f?temperature:"" %>" maxlength="3"  class="textYellow allownumericwithdecimal textSmall" style="width:50px;" onblur="setVitalValue(this.value,'temperatureTemp')"/>
		    <label class="smallAuto">&nbsp;&deg;F&nbsp; </label></td>
		    <td>
		<label class="smallAuto">BP:</label><input name="systolic" id="systolic"  placeholder="Systolic" value="<%=parts.length>0?parts[0]:noSysDias%>" validate="systolic,int,no" maxlength="3" class="textSmall allownumericwithoutdecimal" type="text" maxlength="5" onblur="setVitalValue(this.value,'systolicTemp');"/> <label class="smallAuto">/</label> <input name="diastolic" id="diastolic" placeholder="Diastolic" value="<%=parts.length>0?parts[1]:noSysDias%>" validate="diastolic,int,no" maxlength="3" class="textSmall allownumericwithoutdecimal" type="text" onblur="setVitalValue(this.value,'diastolicTemp');"/> <label class="smallAuto">mm Hg</label>
		</td>
		    <td>
		    <label class="smallAuto">HR:</label>
		<input type="text"  id="pulse" name="pulse" value="<%=pulse>0?pulse:"" %>"  onblur="setVitalValue(this.value,'pulseTemp')"  maxlength="3" style="width:50px;" class="textYellow allownumericwithoutdecimal textSmall"/>
		<label class="smallAuto">/ min</label>
		</td> 
		
		   
	<td><label class="smallAuto">Wt:</label> <input name="weight"
				id="weight" type="text" maxlength="6"
				class="allownumericwithdecimal textSmall" value="<%=weight>0?weight:"" %>"
				validate="weight,double,no" onblur="calculateBMI();"  />
				<label class="smallAuto">kgs</label></td>
			<td><label class="smallAuto">Ht:</label><input name="height"
				id="height" type="text" maxlength="6"
				class="allownumericwithdecimal textSmall" value="<%=height>0?height:"" %>"
				validate="height,float,no" onblur="calculateBMI();"  /> <label
				class="smallAuto">cms</label> <input name="bmi" id="bmiValue" value="" readonly="readonly" class="textSmall"  type="hidden"></td>

			<td><label id="bmi" class="value"><%=bmi>0f?bmi:"" %></label></td>
			<td><label id="bmiCat" class="value">&nbsp; <%=bmiStatus%></label></td>
		  </tr>  
		
		
		
	<tr>
	<td>
		<label class="smallAuto">PEM</label>
		<input class="textYellow textSmall" name="pem" id="pem" type="text" maxlength="3" validate=",float,no" onkeypress="return isNumberOnly(event)" value="<%=pem!=null?pem:""%>">
	</td>
	<td>	
		<label class="smallAuto">Stunting</label>
		<input class="textYellow  textSmall" name="stunting" id="stunting" type="text" maxlength="3" validate="Stunting,float,no"  onkeypress="return isNumberOnly(event)" value="<%=stuning!=null?stuning:""%>">
		</td>
		<td>
		<label class="smallAuto">Wasting</label>
		<input class="textYellow  textSmall" name="wasting" id="wasting" type="text" maxlength="3" validate="Wasting,float,no" value="<%=wasting!=null?wasting:""%>" onkeypress="return isNumberOnly(event)">
		</td>
		<td>
		<label class="smallAuto">Resp.Rate</label>
		<input class="textYellow allownumericwithdecimal textSmall" name="respiratoryRate" id="respiratoryRate" type="text" maxlength="3" validate="Respiratory Rate,float,no" value="<%=respirtoryRate>0?respirtoryRate:"" %>" onblur="setVitalValue(this.value,'respiratoryRateTemp');"/>
		<label class="smallAuto">/ min</label>
		</td>
		<td>
		<label class="smallAuto">SpO2</label>
		<input class="textYellow allownumericwithoutdecimal textSmall" name="spo2" id="spo2" type="text" maxlength="3" validate="spo2,float,no" value="<%=spo2>0?spo2:"" %>" onblur="if(maxDigitAllowed(this, '100')){setVitalValue(this.value,'spo2Temp');}" onkeypress="return isNumberOnly(event)" />
		<label class="smallAuto">%</label>
		</td>
		<td colspan="2">
		<label class="smallAuto">Blood Group</label>
		    <%
		    if(bloodGroupValue != null &&  !bloodGroupValue.isEmpty() && bloodGroupValue!="0" ){ %>
		    <label class="smallAuto"><%=bloodGroupValue%></label>
		   <% }else{ %>
						<select name="bloodGroupValue"	id="bloodGroupValue" tabindex=1 class="midium">
							<option value="0">Select</option>
						<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
							<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
						<%} %>
						</select>
						<label class="smallAuto">Confirm</label>
						<input type="checkbox" name="bloodGroupStatus" id="bloodGroupStatus" value="y" class="checkboxMargin" />
						<%} %>
			</td>			
		</tr>
		</table>
		<!-- </div> -->
		<div class="clear"></div> 
		<div class="divisionSolid"></div>
		<div class="clear"></div> 
		
			<div class="clear"></div> 
				<div class="clear"></div> 
				
				<div class="titleBg">
				<h2>EXAMINATION</h2>
				</div>
				<div class="clear"></div> 
				<div class="paddingTop5"></div> 
				
				<div class="tabContWidth3">
				<label>General Examination</label>
				<textarea name="generalExaminationOPC" id="generalExaminationOPC"
					cols="0" rows="0" maxlength="300" tabindex="26"
					 class="historyAutoComplete"><%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getGeneralExamination():"" %></textarea>
			    </div>
			
				<div class="tabContWidth3">
				<label>Systemic Examination</label>
				
				<textarea name="systemicExamination" id="systemicExamination"
					cols="0" rows="0" maxlength="300" tabindex="26"
					 class="historyAutoComplete"><%=opdPatientDetails!=null && opdPatientDetails.getGeneralExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getGeneralExamination():"" %></textarea>
					
			</div>
			<div class="tabContWidth3">
				<label>Examination of Ear</label>
				<textarea id="earExamination" name="earExamination" cols="0" rows="0" maxlength="300" tabindex="26" class="historyAutoComplete"><%=opdPatientDetails!=null && opdPatientDetails.getLocalExamination()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getLocalExamination().trim():"" %></textarea>
					 
			</div>
<!--   -----Ent changes------ -->

            <div class="clear"></div> 
		<div class="divisionSolid"></div>
		<div class="clear"></div> 
		
			<div class="clear"></div> 
				<div class="clear"></div> 
				
				</div>
			<div class="tabContWidth3">
				<label>Examination of Nose & PNS</label>
				<textarea id="nosePnsExamination" name="nosePnsExamination" cols="0" rows="0" maxlength="300" tabindex="26" class="historyAutoComplete"></textarea>
					 
			</div>
			
			<div class="tabContWidth3">
				<label>Examination of Oral Cavity & Throat</label>
				<textarea id="oralCavityExamination" name="oralCavityExamination" cols="0" rows="0" maxlength="300" tabindex="26" class="historyAutoComplete"></textarea>
					 
			</div>
			
			<div class="tabContWidth3">
				<label>Examination of Neck</label>
				<textarea id="neckExamination" name="neckExamination" cols="0" rows="0" maxlength="300" tabindex="26" class="historyAutoComplete"></textarea>
					 
			</div>
			

<!--   ----- Ent changes end----- -->

			<div class="clear"></div> 
			<div class="paddingTop5"></div> 
			
			<div class="titleBg">
			<h2>DIAGNOSIS</h2>
			</div>
			<div class="clear"></div> 
			<div class="paddingTop5"></div> 
				<%
			String pDiagnosis=null;
			String fDiagnosis=null;
			if(dischargeIcdCodeLast3Visit!=null){
			for(DischargeIcdCode dIcd:dischargeIcdCodeLast3Visit){ 
				if(dIcd.getDiagnosisStatus().equalsIgnoreCase("p"))
				 pDiagnosis = pDiagnosis!=null?pDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
				else if(dIcd.getDiagnosisStatus().equalsIgnoreCase("f"))
				 fDiagnosis = fDiagnosis!=null?fDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
			}}
			%>
			
			<div class="tabContWidth2">
			<label>Provisional Diagnosis</label>
			<!-- <textarea name="" id="" cols="0" rows="0" maxlength="300" id="snomed" name="snomed"	onblur="getICDListBasedOnSnomedId();"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');"> </textarea> -->
						<textarea   class="textYellow historyAutoComplete" id="snomed" <%=pDiagnosis!=null?"style='width:276px;'":""%> name="snomed" maxlength="500"></textarea>
						 <%if(pDiagnosis!=null){%>
						<textarea  readonly="readonly" style="width:276px;"><%=pDiagnosis%></textarea>
						<%}%>
			<input type="hidden"	id="snomedTermConceptIdEXM" name="snomedTermConceptIdEXM"/>
				<input type="hidden" name="snomedTermConceptId" id="snomedTermConceptId" />
			</div>
			
			<div class="tabContWidth2">
			<label>Final Diagnosis</label>
			<textarea name="finalDiagnosis" id="finalDiagnosis" <%=fDiagnosis!=null?"style='width:276px;'":""%>maxlength="500" class="textYellow historyAutoComplete ui-autocomplete-input"> </textarea>
				 <%if(fDiagnosis!=null){%>
						<textarea  readonly="readonly" style="width:276px;"><%=fDiagnosis%></textarea>
						<%}%>
			</div>
			
			<div style="display: none">
				<input type="hidden" tabindex="30" class="textYellow" tabindex="23"	id="snomedNames" name="snomedNames" />
					<input type="hidden" tabindex="30" class="textYellow" tabindex="23"	id="icd1" name="icd1" />
					
						<label>Diagnosis</label>
						<!-- <input type="text" tabindex="30" class="textYellow"	tabindex="23" id="snomed" name="snomed"	onblur="getICDListBasedOnSnomedId();"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');" style="width:278px; margin-right:0px;" /> -->
						<img src="/hms/jsp/images/removeBu.png" width="18" height="18" title="Remove Snomed Diagnosis" id="removeSnomed" style="cursor:pointer;" />
						<label class="auto">Diagnosis to be printed on Prescription</label>
						<input type="checkbox" name="diagnosisCheck" id="diagnosisCheck" value="y" checked="checked" />
						<div class="clear"></div>
						<label>Selected Diagnosis</label>
							
						<select name="snomedList" multiple="4" id="snomedList" class="listBig" style="font:12px;height:60px;width:282px; margin-right:0px;" validate="snomedList,string,no">
							<%-- <%if(snomedStr!=null){
								for(String term:snomedStr){%>
									<option value="<%=term%>"><%=term%></option>
							<%} }%> --%>
						</select>
						<img src="/hms/jsp/images/removeBu.png" width="18" height="18"	title="Remove Snomed" id="removesnomedList" style="cursor:pointer;" />
					
					<label class="auto">Other Diagnosis</label>
					<textarea class="medium" validate="Other Diagnosis,string,no"
						id="OtherDiagnosis" name="OtherDiagnosis" cols="0" rows="0"
						maxlength="100" tabindex="25" ><%=opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getInitialDiagnosis().trim():"" %></textarea>	
						
						
					<div id="divIcdName" style="display: none;">
						<label> Select ICD Name </label>
						 <select id="icdName"	name="icdName" onchange="fillICDValue(this.value,'op');"></select>
					</div>
				
					<div class="clear"></div>
					<label>ICD code</label>
					<!-- <input name="icdCode" tabindex="26" class="textYellow" value="" id="icdCode" onblur="getIcd(1);" /> -->
					<input name="icdCode" tabindex="31" class="textYellow" value=""
						id="icdCode" readonly /> <input name="temp" value="" id="temp"
						type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="24"
						HEIGHT="20" tabindex="31" class="search-img" 
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
						<select name="diagnosisId" multiple="4" id="diagnssosisId"
							class="listBig" style="font:12px;height:60px;margin-right:0px; margin-right:0px;"
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
						</select> <img src="/hms/jsp/images/removeBu.png" width="18" height="18"
							title="Remove diagnosis" id="removeOPDisgnosis" style="cursor:pointer;" />
							<select	name="diagnosisIdNP" multiple="4" id="diagnosisIdNP" class="listBig" style="font:12px;height:60px;margin-left:75px;width:284px;">
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
					
					</div>
				
					<div class="clear"></div>
			
			<div class="clear"></div>
			<div class="paddingTop5"></div>

	<div class="titleBg">
		<h2>Treatment Plan</h2>
	</div>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
		<%-- <label class="auto"><%= departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))?"Non-pharmacological Advice":"Treatment Plan" %> </label> --%>
		<textarea class="large" validate="P/S,string,no" id="treatmentPlan" name="treatmentPlan"
			cols="0" rows="0" maxlength="500" tabindex="26"
			style="width: 1159px; height: 46px;overflow-x:hidden;resize:vertical;"><%=treatmentPlan!=null?treatmentPlan:""%></textarea>
			<div class="clear"></div>
			<div class="paddingTop5"></div>

	<div class="titleBg">
		<h2>INVESTIGATIONS</h2>
	</div>
	<div class="paddingTop5"></div>
	<div class="clear"></div>

	<div style="width: 257px; float: left;">
	<%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics"))){%>
		<div style="width: 170px; float: left;">
			<label>Laboratory <input class="radioCheckCol2" value="Lab"
				id="labradiologyCheck" name="labradiologyCheck" type="radio"
				checked="checked">
			</label> <label>Radiology <input class="radioCheckCol2" value="Radio"
				id="labradiologyCheck" name="labradiologyCheck" type="radio"><input
										type="hidden" name="investigationCategory"
										id="investigationCategory" />
			</label>
			<div class="clear"></div>
			<!-- <img src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />&nbsp;Service
			Not Available -->
			<input type="hidden" name="investigationCategory" id="investigationCategory" />
				<div class="clear"></div>
			<div class="divisionSolid"></div>
			<div class="clear"></div>
		</div> 
  <%} %>
		<div class="labelMargeDiv" style="width: 104px;">
		
					<label class="small-medium" style="margin-right: 5px; width: 90px;"><input
				class="radioCheckCol2" name="invTempType" id="invTempType_global"
				onchange="getTemplate('global','i','');" type="radio">Local</label>
			<div class="clear"></div>
			<div class="clear"></div>
			<label style="margin-right: 5px; width: 90px;"><input
				class="radioCheckCol2" name="invTempType" id="invTempType_local"
				onchange="getTemplate('local','i','');" type="radio">Individual</label>
			<div class="clear"></div>
			<div class="clear"></div>
			<label class="small-medium" style="margin-right: 5px; width: 90px;"><input
				class="radioCheckCol2" name="invTempType" id="invTempType_global"
				onchange="getTemplate('all','i','');" type="radio">Global</label>
				<div style="float:left;width: 187px;">
			<h4 style="cursor:pointer;" onclick="popwindowResultEntryForDermotology('<%=hinId%>@@@<%=visitId%>');">External Lab Report Entry</h4>
		</div>
		</div>
		<div class="paddLeft30">
			<select class="medium" multiple="5"
				style="height: 83px; width: 140px;" name="tempLateInvestigation"
				id="tempLateInvestigation"
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

	</div>
	<div style="width: 832px; float: left;" id="labInvDiv">

		<table style="width: 100%; border-top: solid 1px #C0C0C0" id="investigationGrid">
			<tr>
			<th style="background: #bdd6ee; text-align: center;">&nbsp;</th>
				<th style="background: #bdd6ee; text-align: center;">Test Name</th>
			</tr>

			<tr>
											<%int inc=0;
			len=3;
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
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>"/> <%}else{ %>
													<input type="checkbox" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>"/> <%} %>
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
													size="65" name="chargeCodeName<%=inc %>" style="width: 672px;"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													<%}  else{ %> <input type="text" style="width: 672px;"
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
		
				
			</tr>
				<%}%>
		</table>
			<input type="hidden" name="hiddenValue" id="hiddenValue"
										value="<%=inc%>" />
	</div>
	<div style="width:-26px;background-color:floralwhite;float: right;" >
	<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowInvestigationForLP();">
	 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForInvestigation();"> 
	
	<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div class="paddingTop5"></div>

	<div class="titleBg">
		<h2>PRESCRIPTION</h2>
	</div>
	<div class="paddingTop5"></div>
	<div class="clear"></div>
		<!-- <div style="width: 900px; float: left;"> -->
			<label>Tablet <input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForTablet")%>"
				id="pharmacyCheck" name="pharmacyCheck" type="radio">
			</label>
			<label>Capsule <input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForCapsule")%>"
				id="pharmacyCheck" name="pharmacyCheck"
				type="radio">
			</label> <label>Injection <input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForInjection")%>"
				id="pharmacyCheck" name="pharmacyCheck" type="radio">
			<input type="hidden" name="pharmacyCategory" id="pharmacyCategory" /></label>
			<label style="width: 297px;">Do you want to prescribe NON KMSCL medicine <!-- <input class="radioCheckCol2" 
					id="pharmacyCheck" name="pharmacyCheck" type="checkbox" onclick="switchVisible();">  -->
					<%
		if(patientOtherPrescriptionDetails.size() > 0){
			%>
			<input  class="radioCheckCol2" type="checkbox" value="Click" onclick="switchVisible();" checked="checked"/>
			<script>switchVisible();</script>
			<%}else{ %>
			<input  class="radioCheckCol2" type="checkbox" value="Click" onclick="switchVisible();" /><%} %>
				
			</label>
		
		<div class="clear"></div>
	<div style="width: 257px; float: left;">

		<div class="labelMargeDiv" style="width: 104px;">
			
			
				<label class="small-medium" style="margin-right: 5px; width: 90px;">
			<input class="radioCheckCol2" name="invTempTypePres" id="presTempType_local" onchange="getTemplate('local','p','');" type="radio">
			Local</label>
			<div class="clear"></div>
			<div class="clear"></div>
		<label style="margin-right: 5px; width: 90px;">
			<input class="radioCheckCol2" name="invTempTypePres" id="presTempType_indiviual" onchange="getTemplate('individual','p','');" type="radio">
			Individual</label>
			<label class="small-medium" style="margin-right: 5px; width: 90px;">
			<input class="radioCheckCol2" name="invTempTypePres" id="presTempType_global" onchange="getTemplate('global','p','');" type="radio">
			Global</label>
			<div class="clear"></div>
		</div>
		<div class="paddLeft30">
			<select class="medium" multiple="5"
				style="height: 83px; width: 140px;" 
										name="tempLatePrescription" id="tempLatePrescription"
										onchange="fnGetPrescriptionTemplate(this);setDisablePharmacy();" onblur="setDisablePharmacy();" onclick="setDisablePharmacy();">
										<option value="-1">Select</option>
										<%
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

	<div style="width: 832px; float: left;">
		<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="grid">
			<tr>
			<th style="background: #bdd6ee;">&nbsp;</th>
				<th style="background: #bdd6ee;">Drug Name</th>
					<th style="background: #bdd6ee;">Route</th>
				<th style="background: #bdd6ee;">Dosage</th>
				<th style="background: #bdd6ee;">Unit</th>
				<th style="background: #bdd6ee;">Frequency</th>
				<th style="background: #bdd6ee;">Duration</th>
				<th style="background: #bdd6ee;">Instruction</th>
				
			</tr>
								
									<%
    incr = 0;len=3;
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
		String specialInstruction= null;
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
			specialInstruction=pd.getSplInstruction();
			System.out.println(specialInstruction +" dfdf"+specialInstruction);
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
											id="itemRadio<%=incr%>" name="itemRadio<%=incr%>" />
											<%}else{ %> <input type="checkbox" class="radioCheck"
											id="itemRadio<%=incr%>" name="itemRadio<%=incr%>" />
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
											title="Prescription issued.."
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											class="textYellow largTextBoxOpd" value="<%=nomeclature%>"
											id="nomenclature<%=incr%>" size="35"
											name="nomenclaturepTab<%=incr%>"
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>); checkForAllergy(this.value,<%=incr %>); populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>');ValidateCantra();displayAu(this.value,'<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											
											class="textYellow largTextBoxOpd"
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											value="<%=nomeclature%>" id="nomenclature<%=incr%>" size="35"
											name="nomenclaturepTab<%=incr%>" style="width: 160px;"
											<%-- onfocus="checkEnteredDiagnosis(); //Commented by Arbind on 31-01-2017--%>
											
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>);
												 checkDrugToDiseaseCantra(this);
												 checkForAllergy(this.value,<%=incr %>);populatePVMS(this.value,'<%=incr%>');
												 checkItem('<%=incr%>');
												 ValidateCantra();displayAu(this.value,'<%=incr%>');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=incr %> )" />
											<%}%>
											<div id="ac2updates<%=incr%>" style="display: none;"
												class="autocomplete"></div>
									<script type="text/javascript"
						language="javascript" charset="utf-8">
								 new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>',
						  'opd?method=getItemListForAutoCompleteItem',{minChars:3,
					  callback: function(element, entry) {
				            return entry + '&pharmacyCheck=' + document.getElementById('pharmacyCategory').value;
				        },
					  parameters:'requiredField=nomenclaturepTab<%=incr%>'});
				</script>
					 <input type="hidden" name="pvmsNopTab<%=incr %>" id="pvmsNo<%=incr %>"
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
											name="routepTab<%=incr%>" id="route<%=incr%>"
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
										</select> <%}else{ %> <select name="routepTab<%=incr%>"
											id="route<%=incr%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
							   	  
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												
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
										<td><input class="textYellow allownumericwithdecimal  opdTextBoxTSmall"
											type="text"
											name="dosagepTab<%=incr%>" id="dosage<%=incr%>" 
											value="<%=dosage!=null && dosage!=0?dosage:"" %>" size="10" 
											maxlength="3" onblur="fillValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" /></td>
										<td><input type="text"
											 name="unit<%=incr %>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											class="textYellow opdTextBoxTSmall" id="unit<%=incr %>"
											readonly="readonly" size="5"
											onblur="fillValue(this.value,<%=incr%>);" /></td>
										<td><input type="hidden" name="frequencyValue<%=incr%>"
											id="frequencyValue<%=incr%>" value="" size="6" /> <input
											type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
											style="display: none; " size="3"
											onblur="fillValue(this.value,<%=incr%>)" maxlength="3"
											validate="Sos Qty,num,no" /> 
									<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 69px; background: #FFFF99"
											name="frequencypTab<%=incr%>" id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyTypeForLP(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
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
										</select> <%}else{ %> <select style="width: 69px; background: #FFFF99"
											 name="frequencypTab<%=incr%>"
											id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyTypeForLP(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
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
											name="noOfDayspTab<%=incr%>" id="noOfDays<%=incr%>"
											value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValue(this.value,<%=incr%>);" onkeypress="return isNumberOnly(event)"/>
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<%}else{ %> <input type="text"
											 name="noOfDayspTab<%=incr%>"
											id="noOfDays<%=incr%>" value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event)"
											onblur="fillValue(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<% }%>
											<input type="hidden" name="totalpTab<%=incr %>" id="total<%=incr %>"	value="<%=total!=null && total!=0?total:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
                                         </div>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="instrunctionpTab<%=incr%>" id="instrunction<%=incr%>"
											>
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
											
											name="instrunctionpTab<%=incr%>" id="instrunction<%=incr%>"
											 onchange ="toggleOtherTextbox1(this,'splInstrunctionpTab<%=incr%>',200, 'otherSplInstrunctionSpan<%=incr%>','68px')">
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
										</select> <% }%>
										
										<span id="otherSplInstrunctionSpan<%=incr%>">
											<%if(specialInstruction!=null && !specialInstruction.isEmpty()){%>
											<input name="splInstrunctionpTab<%=incr%>" id="splInstrunctionpTab<%=incr%>" value="<%=specialInstruction%>" class="textYellow" maxlength="200" style="width: 68px;" type="text">
											
											<%} %>
										</span>
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
										</td>
										
									</tr>
									<%} %>
					
<tbody id="divTemplet1"></tbody>
		</table>
			<input type="hidden" name="pTabhdb" value="<%=incr-1 %>" id="hdb" />
		<div class="clear"></div>
		<div class="paddingTop5"></div>


				

	</div>
	
	<div style="width:-26px;background-color:floralwhite;float: right;">
	<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowMedicineForLP();">
	 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowMedicineForLP();"> 
	<div class="clear"></div>
	</div>

<div id="Div1"></div>
<div id="Div2" style="padding-left: 257px;<%=patientOtherPrescriptionDetails.size()>0?"display:block;":""%>" >
<div  style="width: 832px; float: left;">
 	<div  class="floatRight"> <div id="responseId"></div>
 		<!-- <input type="button" class="buttonBig" name="prev"
					value="Add Medicine"
					onclick="javascript:addOutsideMedicine(csrfTokenName+'='+csrfTokenValue);" />
 -->			
 			<!-- <div class="addDeleteButton">
						<input type="button" class="buttonDel" value=""	onclick="removeForPrescriptionRow();" />
						 <input type="button" class="buttonAdd" onclick="addRowOtherMedicineForLP();" value="" />
					</div> -->
					<div class="clear"></div>
					</div>
 <div class="">
						<!-- <div class="tableForTab" style="width:890px; height:152px; overflow: scroll;"> -->
							<!-- <div id="divTemplet1"> -->
								<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridForPrescription">
									<tr>
										<th style="background: #bdd6ee;">&nbsp;</th>
										<th style="background: #bdd6ee;">Item Name</th>
										<th style="background: #bdd6ee;">Route</th>
										<th style="background: #bdd6ee;">Dosage</th>
										<!-- <th scope="col">Unit</th> -->
										<th style="background: #bdd6ee;">Frequency</th>
										<th style="background: #bdd6ee;">Duration</th>
										<th style="background: #bdd6ee;">Instruction</th>
										<th style="background: #bdd6ee;">Special Instruction</th>
										<!-- <th scope="col">Total</th> -->
									</tr>
									<%
	int incrs = 0,lens=1,lent=0;
	if(patientOtherPrescriptionDetails.size()>0 && masStoreOutItemsList.size()>0){
		lens=patientOtherPrescriptionDetails.size();
		lent=masStoreOutItemsList.size();
	}else{
		lens=1;
		lent=3;
	}
	int inxRows=1;
	int inxCols=0;
	for(;incrs< lens;incrs++,inxRows++){
		String nomeclatures="";
		Integer ItemIds=0;
		String pvmsNo="";
		int routeIds=0;
		int frequencyIds=0;
		int inctrunctionIds=0;
		String unitOut="";
		String frequecnyTypes="";
		Float dosagesOut=0f;
		int noOfDaysOut=0;
		Float totalOut=0f;
		String issuedStatus="";
		String routeNames="";
		String conversions="";
		PatientPrescriptionDetails pds=null; MasStoreOutItem mso=null;
		if(patientOtherPrescriptionDetails.size()>0 && masStoreOutItemsList.size()>0){
			pds=patientOtherPrescriptionDetails.get(incrs);
			mso=masStoreOutItemsList.get(incrs);
			ItemIds=mso.getId();
					
			if(mso.getStatus()!=null && !mso.getStatus().equals("")  && mso.getStatus().equalsIgnoreCase("y")){
				issuedStatus=mso.getStatus();
			}
			
			
			nomeclatures=mso.getNomenclature();
			dosagesOut=pds.getDosage();
			totalOut=pds.getTotal();
			noOfDaysOut=pds.getNoOfDays();
			frequecnyTypes=pds.getFrequency().getFrequencyType();
			if(pds.getRoute()!=null){
				routeIds=pds.getRoute().getId();
				routeNames=pds.getRoute().getRouteName();
			}
			if(pds.getFrequency()!=null){
				frequencyIds=pds.getFrequency().getId();
			}
			if(pds.getInsrtuction()!=null){
				inctrunctionIds=pds.getInsrtuction().getId();
			}
			if(ItemIds!=0){
				nomeclatures=nomeclatures;
			}
		}
	%>
									<tr>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" class="radioCheck"
											id="itemRadios<%=incrs %>" title="Prescription issued.."
											disabled="disabled" name="itemRadios<%=incrs %>"
											onchange="checkPrescriptionCheckList(<%=incrs %>)" />
											<%}else{%> <input
											type="checkbox" tabindex="<%=inxRows%><%=inxCols+10%>"
											class="radioCheck" id="itemRadios<%=incrs %>"
											name="itemRadios<%=incrs %>"
											onchange="checkPrescriptionCheckList(<%=incrs %>)" /> <%} %> <input
											type="hidden" name="prescription_availableStatus<%=incrs %>"
											id="prescription_availableStatus<%=incrs %>"
											 />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											title="Prescription issued.."
											onkeypress="checkTextColorList('nomenclatures<%=incrs%>');"
											class="textYellow largTextBoxOpd" value="<%=nomeclatures%>"
											id="nomenclatures<%=incrs%>" size="35"
											name="nomenclatures<%=incrs%>"
											onblur="validatePrescriptionAutocompleteList('opPTab',this.value,<%=incrs%>);" />
											<%}else{ %> <input type="text"
											tabindex="<%=inxRows%><%=inxCols+11%>"
											class="textYellow largTextBoxOpd"
											onkeypress="checkTextColorList('nomenclatures<%=incrs%>');"
											value="<%=nomeclatures%>" id="nomenclatures<%=incrs%>" size="35"
											name="nomenclatures<%=incrs%>" style="width: 160px;"
											onblur="validatePrescriptionAutocompleteList('otherPres',this.value,<%=incrs %> )" />
											<%}%>
											<div id="ac2update1<%=incrs%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclatures<%=incrs%>','ac2update1<%=incrs%>','opd?method=getItemListForAutoCompleteOutItem',{minChars:3,parameters:'requiredField=nomenclatures<%=incrs%>'});
					</script> <input type="hidden" name="pvmsNo<%=incrs %>" id="pvmsNo<%=incrs %>"
											size="10" readonly="readonly" /> <input type="hidden"
											name="actualDispensingQtys<%=incrs%>"
											id="actualDispensingQtys<%=incrs%>" size="6"
											validate="AU,string,no" />
										
										
										<input type="hidden"
											name="mixables<%=incrs%>"
											id="mixables<%=incrs%>" 
											validate="mixables,string,no" />
											
										<input type="hidden"
											name="mixtureQuantity<%=incrs%>"
											id="mixtureQuantity<%=incrs%>" 
											validate="mixtureQuantity,int,no" />
											
										<input type="hidden"
											name="mixtureUnit<%=incrs%>"
											id="mixtureUnit<%=incrs%>" 	
											validate="mixtureUnit,string,no" />
										<input type="hidden"
											name="actualTotalAfterMixs<%=incrs%>"
											id="actualTotalAfterMixs<%=incrs%>" 
											validate="actualTotalAfterMixs,float,no" />
										<input type="hidden"
											name="tapered<%=incrs%>"
											id="tapered<%=incrs%>" 
											validate="tapered,string,no" />
										</td>
										<td>
								 <%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled" title="Prescription issued.."
											name="routesOut<%=incrs%>" id="routesOut<%=incrs%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAbList('<%=incrs%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
								
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%if(routeIds==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select> <%}else{ %> <select name="routesOut<%=incrs%>"
											tabindex="<%=inxRows%><%=inxCols+12%>" id="routesOut<%=incrs%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAbList('<%=incrs%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
							   	  
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%if(routeIds==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ 
												%>
												<option  value="<%=id %>"><%=name%></option>
												
												<%}%>
												<%}%>
										</select> <%}%> <script type="text/javascript">	var	routeArray= new Array();
		              <%
			    		RouteOfAdministration  routesOut = new RouteOfAdministration();
					     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					    	 routesOut = (RouteOfAdministration) routeOfAdministrationList.get(k);
		     			 %> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=routesOut.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=routesOut.getRouteName()%>";
	     				<% }%> 
            </script>
										</td>
										<td><input class="textYellow allownumericwithdecimal opdTextBoxTSmall"
											tabindex="<%=inxRows%><%=inxCols+13%>" type="text"
											name="dosagesOut<%=incrs%>" id="dosagesOut<%=incrs%>"
											value="<%=dosagesOut!=null && dosagesOut!=0?dosagesOut:"" %>" size="10"
											maxlength="3" onblur="fillValueList(this.value,<%=incrs%>);" /></td>
										<%-- <td><input type="text"
											tabindex="<%=inxRows%><%=inxCols+14%>" name="unitOut<%=incrs %>"
											value="<%=unitOut!=null && !unitOut.equals("")?unitOut:"" %>"
											class="textYellow opdTextBoxTSmall" id="unitOut<%=incrs %>"
											readonly="readonly" size="5"
											onblur="fillValueList(this.value,<%=incrs%>);" /></td> --%>
										<td><input type="hidden" name="frequencyValueOut<%=incrs%>"
											id="frequencyValueOut<%=incrs%>" value="" size="6"/> <input
											type="hidden" name="sosQtyout<%=incrs%>" id="sosQtyout<%=incrs%>"
											style="display: none;" size="3"
											onblur="fillValueList(this.value,<%=incrs%>)" maxlength="3"
											validate="Sos Qty,num,no" /> 
									<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 69px; background: #FFFF99"
											name="frequencyValueOut<%=incrs%>" id="frequencyValueOut<%=incrs%>"
											onchange="getFrequencyValueList(this.value,<%=incrs%>);fillValueList(this.value,<%=incrs%>);displaySOSQtyList(this.value,<%=incrs%>);displaFrequencyTypeList(this,<%=incrs%>);">
												<option value="0">Select</option>
												<%
												  for(MasFrequency masFrequency2 : frequencyList){
											       int id = masFrequency2.getId();
											       String name = masFrequency2.getFrequencyName();
											       String type = masFrequency2.getFrequencyType();
									          %>
												<%if(frequencyIds==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%}else{ %> <select style="width: 68px; background: #FFFF99"
											tabindex="<%=inxRows%><%=inxCols+15%>" name="frequencyValueOut<%=incrs%>"
											id="frequencyValueOut<%=incrs%>"
											onchange="getFrequencyValueList(this.value,<%=incrs%>);fillValueList(this.value,<%=incrs%>);displaySOSQtyList(this.value,<%=incrs%>);displaFrequencyTypeList(this,<%=incrs%>);">
												<option value="0">Select</option>
												<%
													 
												      for(MasFrequency masFrequency2 : frequencyList){
												       int id = masFrequency2.getId();
												       String name = masFrequency2.getFrequencyName();
												       String type = masFrequency2.getFrequencyType();
										          %>
												<%if(frequencyIds==id){%>
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
											<div style="width:60px; float: left;">
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDaysOut<%=incrs%>" id="noOfDaysOut<%=incrs%>"
											value="<%=noOfDaysOut!=0 ?noOfDaysOut:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event);" 
											onblur="fillValueDay(<%=incrs%>);fillValueList(this.value,<%=incrs%>);" />
											<p style="line-height:0px;" id="frequencyTypeOut<%=incrs %>" ><%=frequecnyTypes %></p>
											<%}else{ %> <input type="text"
											tabindex="<%=inxRows%><%=inxCols+16%>" name="noOfDaysOut<%=incrs%>"
											id="noOfDaysOut<%=incrs%>" value="<%=noOfDaysOut!=0 ?noOfDaysOut:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event);" 
											onblur="fillValueDay(<%=incrs%>);fillValueList(this.value,<%=incrs%>);" />
											<p style="line-height:0px;" id="frequencyTypeOut<%=incrs %>" ><%=frequecnyTypes %></p>
											<% }%>
                                         </div>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="instrunctionOut<%=incrs%>" id="instrunctionOut<%=incrs%>"
											onblur="fillInstrunctionOnTAbs('<%=incrs%>');">
												<option value="0">Select</option>
												<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
												<%if(inctrunctionIds==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
					}
					%>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRows%><%=inxCols+17%>"
											name="instrunctionOut<%=incrs%>" id="instrunctionOut<%=incrs%>"
											onblur="fillInstrunctionOnTAbs('<%=incrs%>');">
												<option value="0">Select</option>
												<%
							for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
							{
				
						       int id = instructionTreatment.getId();
						       String name = instructionTreatment.getOpdInstructionTreatmentName();
				
				          %>
												<%if(inctrunctionIds==id){%>
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
											name="splInstrunctionsOut<%=incrs %>"
											class="textYellow opdTextBoxTSmall" style="width: 80px;"
											id="splInstrunctionsOut<%=incrs %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incrs %>);" /> <%}else{ %>
											<input type="text" tabindex="<%=inxRows%><%=inxCols+18%>"
											name="splInstrunctionsOut<%=incrs %>"
											class="textYellow opdTextBoxTSmall"
											id="splInstrunctionsOut<%=incrs %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incrs %>);" style="width: 80px;"/> <% }%>
											<input type="hidden" name="totalOut<%=incrs %>" id="totalOut<%=incrs %>"	value="<%=totalOut!=null && totalOut!=0?totalOut:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td>
										<%-- <td>
											<input type="text" name="totalOut<%=incrs %>" id="totalOut<%=incrs %>"	value="<%=totalOut!=null && totalOut!=0?totalOut:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td> --%>
										
									<%-- 	<td>
											<input type="text" id="unitLables<%=incrs%>" value="<%=!conversions.equals("")?conversions:"" %>" 	class="textYellow opdTextBoxTSmall" readonly="readonly" />
										</td> --%>
										
									</tr>
									<%} %>
					
								<tbody id="divTemplet1"></tbody>	
								</table>
								<input type="hidden" name="hdb1" value="<%=incrs-1 %>" id="hdb1" />
								<input type="hidden" name="hdbRecordSize1"
									value="<%= patientOtherPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize1" /> <input type="hidden" name="hdbTabIndex1"
									id="hdbTabIndex1" value="<%=inxRows-1%>" id="hdbRecordSize1" />
								
						<!-- 	</div> -->
						<!-- </div> -->
						
					</div>
</div>

<div style="width:-26px;background-color:floralwhite;float: right;">
						<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowOtherMedicineForLP();">
						 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowOtherMedicineForLP();"> 
		</div>				
						<div class="clear"></div>
						</div>
	<div class="clear"></div>
  <div class="paddingTop25">

	<div class="Block">

	<div class="titleBg">
		<h2>PROCEDURES</h2>
	</div>

			<!-- 		<div class="addDeleteButton">
						<input type="button" class="buttonDel" tabindex="3" alt="Delete"
							value="&nbsp;" onclick="removeRowTreatmentNursingCare();"
							align="right" /> <input type="button" class="buttonAdd"
							alt="Add" tabindex="4" value="&nbsp;"
							onclick="addRowTreatmentNursingCareLP();" align="right" />
					</div> -->
					<div class="clear"></div>
					
					<div  style="width:1024px; float:left; background:red;">
					
				<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="gridNursing">
				<tbody><tr>
					<th style="background: #bdd6ee;">&nbsp;</th>
						<th style="background: #bdd6ee;">Procedure Name</th>
						<th style="background: #bdd6ee;">Frequency</th>
						<th style="background: #bdd6ee;">No. of Days</th>
						<th style="background: #bdd6ee;">Remarks</th>
					</tr>
							<%
	incr=0 ;
	len=1;
	if(procedureDetails.size()>0){
		len = procedureDetails.size();
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
										<input	readonly="readonly" type="text"	
										value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" size="35"	name="procedureName_nursing<%=incr%>" style="width: 320px;"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)"/>
									<%}else{%>
										<input	type="text" value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" style="width: 320px;"
										size="35" name="procedureName_nursing<%=incr%>"
										<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)"/> 
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
									value="<%=noOfDays!=0?noOfDays:""%>" class="textSmall" size="5" maxlength="3" onkeypress="return isNumberOnly(event)"/>
								</td>
								<td>
									<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
									readonly="readonly" value="<%=nursingRemark %>" type="text"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									style="width: 510px;" maxlength="100"/> <%}else{ %> <input
									type="text" value="<%=nursingRemark %>"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									style="width: 510px;"  maxlength="100"/> <%} %>
								</td>
								<%-- <td><input class="radioCheck" type="checkbox"
									name="alert_nursing<%=incr %>" name="alert_nursing<%=incr %>" /></td> --%>
							</tr>
							<%} %>
						</tbody> </table>
						<input type="hidden" id="procedureHeaderId"
							name="procedureHeaderId" value="<%=procedureHeaderId%>" />
						 <input type="hidden" name="nursinghdb" value="<%=incr-1%>"
							id="nursinghdb" />
							
							</div>
							
						<div style="width:-26px;background-color:floralwhite;float: right;">
							<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowTreatmentNursingCareLP();">
						 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowTreatmentNursingCare();"> 
						<div class="clear"></div>
						</div>
					<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div class="paddingTop5"></div>
	<div class="titleBg">
		<h2>SURGERY PROCEDURES</h2>
	</div>
	
					

					<!-- 	<div class="addDeleteButton">
							<input type="button" class="buttonDel" tabindex="3" alt="Delete"
								value="&nbsp;" onclick="removeRowTreatmentSurgery();"
								align="right" /> <input type="button" class="buttonAdd"
								alt="Add" tabindex="4" value="&nbsp;"
								onclick="addRowTreatmentSurgeryNP();" align="right" />
						</div> -->
					
	<div class="clear"></div>
	</div>
						<div class="clear"></div>
						<div  style="width:1100px; float:left; background:red;">
						<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="gridSurgery">
							<tbody><tr><th style="background: #bdd6ee;">&nbsp;</th>
								<th style="background: #bdd6ee;">Procedure Name</th>
								<th style="background: #bdd6ee;">Tentative Date</th>
								<th style="background: #bdd6ee;">Remarks</th>
							</tr>
								<%
	incr=0 ;
	len=1;
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
									<input type="text" style="width: 250px;" tabindex="32" value="<%=surgery %>"	id="procedureName_surgery<%=incr%>" size="35"
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
									<td><input type="text" id="tentativeDate<%=incr%>" class="small"
										value="<%=surgerDate %>" name="tentativeDate<%=incr%>"
										validate="t1ntativeDate<%=incr%>,string,no"
										readonly="readonly" /> <img src="/hms/jsp/images/cal.gif"
										width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.opdMain.tentativeDate<%=incr%>,event);" />
								</td>
									<td><input type="text" name="remark_surgery<%=incr%>"
										value="<%=surgerRemark %>" id="remark_surgery<%=incr%>"
										style="width: 610px;" maxlength="100" /></td>
									<%-- <td><input type="checkbox" name="alertToStaffy<%=incr%>" id="alertToStaff<%=incr%>" onchange="displayPhAlert(this.value,<%=incr %>>)"/></td> --%>	
								</tr>
								<%} %>
							</tbody></table>
							<input type="hidden" id="surgeryHeaderId" name="surgeryHeaderId"	value="<%=surgeryHeaderId%>" />
						    <input type="hidden" name="surgeryhdb" value="<%=incr-1 %>"	id="surgeryhdb" />
						    
						    </div>
						    	<div style="width:-26px;background-color:floralwhite;float: right;">
						    	<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowTreatmentSurgeryNP();">
	 		<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowTreatmentSurgery();"> 
					</div>
				</div>
			

<div class="clear"></div>
	<div class="titleBg">
		<h2>ADVICE</h2>
	</div>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<div class="clear"></div>
	 <div id="admissionDiv">
						<div class="clear"></div>
						<label class="auto">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="checkboxMargin"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="checkboxMargin" id="observationStatus"
							name="observationStatus" /> <%} %>
						</label>
						 <label class="auto">Admission Advised
						  <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="checkboxMargin"	id="admissionAdvised" name="admissionAdvised"/>
							<%}else{
							 if(opdPatientDetails!=null && opdPatientDetails.getReferedStatus()!=null && opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {
								%>
							<input	type="checkbox" class="checkboxMargin" id="admissionAdvised" name="admissionAdvised" disabled="disabled"/><%}else{ %>
							<input	type="checkbox" class="checkboxMargin" id="admissionAdvised" name="admissionAdvised" />
							<%} }%>
						</label>
						
						 <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<div id="admDiv">
							<label class="auto">Admission Date</label>
							 <input type="text"	name="admissionDate" id="admissionDate"	style="text-align: left;" class="dateTextSmall"	value="<%=HMSUtil.convertDateOneFormatToAnother("dd/MM/yyyy",opdPatientDetails.getAdmissionDate())%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif" class="calenderImg" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<div class="clear"></div>
							<label class="auto">Payward
							<input type="checkbox" name="payward" id="payward" class="checkboxMargin" value="Y" onchange="checkPayWard()" />	
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
							 <input type="text"	name="admissionDate" id="admissionDate"	class="inputSmall"	value="<%=currentDate%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif" class="calenderImg" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<div class="clear"></div>
							<label class="auto">Payward

							<input type="checkbox" name="payward" id="payward" class="checkboxMargin" value="Y" onchange="checkPayWard()"
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
			
				<%
					String relationName="";
					if(opdPatientDetails!=null &&  opdPatientDetails.getReferedStatus()!=null && (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C"))  && opdPatientDetails.getVisit().getId().equals(visitId)/* && !opdPatientDetails.getVisit().getVisitStatus().equalsIgnoreCase("c") */){ %>
									
									<div class="clear"></div>
									<div id="referalDiv" style="display:block; margin-top:5px;">	
		                          
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
		
								<div id="referDiv" style="margin-top:5px;">
									<label class="auto">Refer To</label>
									<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
									<%
									if(opdpatientDetailId !=0)
									{%>
										<label class="auto"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%>
		
									<%if(opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")){ %>
										<input type="hidden" name="referCheck" id="referCheck" value="y"/>
										<label class="auto">
										<input type="radio"	class="checkboxMargin" name="referTo" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("Interanal")?"checked='checked'":"" %>  id="referInternal" value="Internal" onclick="checkReferTO('referInternalRecall',<%=referredDept%>);" />Internal</label>
										<label class="auto">
										<input type="radio" class="checkboxMargin" name="referTo" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"checked='checked'":"" %>id="referExternal" value="External" onclick="checkReferTO('referExternal',<%=referredDept%>);" />External</label>
									<%}%>
									
		
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"	id="referVisitDate" name="referVisitDate" class="date"	value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','-');"
										 />
									<img  src="/hms/jsp/images/cal.gif"	class="calenderImg" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" /> 
									<label id="priorityLabelId"  style="width:115px;">Current Proirity No.</label>
									<select
										id="priorityId" name="priorityName" tabindex="1"  style="width:100px;">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select>
									<label id="referdistrictLabel" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"style='display:block;width:100px;'":"" %> >District</label>
									<select	id="referdistrict" <%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"style='display:block;width:100px;'":"" %> name="referdistrict"	onchange="fnGetDistrictHospital();">
										<option value="0">Select</option>
										<%for(MasDistrict district:masDistrictList){
										%>
											<%if(opdPatientDetails.getReferedDistrict()!=null && opdPatientDetails.getReferedDistrict().getId()==district.getId()){ %>
											<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
											<%}else{ %>
											<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
											<%} %>
										<%}%>
									</select> 
									<div class="clear"></div>
									
									<label id="referHospitalTypeLabel">Hospital Type</label>
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
		
									<label id="referhospitalLabel" style="width:100px;">Hospital</label> <select
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
										onchange="fnGetDoctorDepartment(this.value);getSessionForDepartment(this.value);">
										<option value="0">Select</option>
										<%for(MasDepartment dep:deptList){%>
											<%if(opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId()==dep.getId()) {
											%>
												<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
											<%}else{ %>
												<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
											<%} %>
										<%}%>
									</select> 
									
									<label id="refersessionLabel"  style="width:115px;">Session</label> <select
										id="opsession" name="referredSession"  style="width:100px;">
										
										<%if(opdPatientDetails.getReferredSession()!=null) {
											%>
											<option value="<%=opdPatientDetails.getReferredSession().getId()%>" selected="selected"><%=opdPatientDetails.getReferredSession().getSessionName()%></option>
										<%}else{ %>
											<option value="0">Select</option>
										<%} %>	
										
									</select> 
									
								
									<label  style="width:100px;">Doctor</label>
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
										id="patientAdvise" cols="0" rows="0" maxlength="500" style="margin-left:0px; width:141px;"
										tabindex="5" onkeyup="return checkLength(this)"><%=opdPatientDetails.getPatientAdvise() != null ? opdPatientDetails.getPatientAdvise() : ""%></textarea>
									<input type="button" class="buttonAuto-buttn" value="+"		onclick="" />
									 <label  style="width:101px;margin-left:0px;">Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"	id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5" style="margin-left:0px;width: 162px;"
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
								<div id="referalDiv" style="margin-top:5px;">
		
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
										<label class="auto"><input type="checkbox"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>');" />ReferBack</label>
										<%
									}
									%>
		
									<label class="auto"><input type="radio"
										class="checkboxMargin" name="referTo" id="referInternal"
										value="Internal" onclick="checkReferTO('referInternal',<%=deptIdSession%>);" />Internal</label>
									<label class="auto"><input type="radio"
										class="checkboxMargin" name="referTo" id="referExternal"
										value="External" onclick="checkReferTO('referExternal',<%=deptIdSession%>);" />External</label>
		
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"
										id="referVisitDate" name="referVisitDate" class="date" style="width:133px;"
										value="<%=currentDate%>"
										onkeyup="mask(this.value,this,'2,5','-');"
										 />
									<img  src="/hms/jsp/images/cal.gif" class="calenderImg"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" /> 
									<label id="priorityLabelId" style="width:115px;">Current Proirity No.</label> <select
										id="priorityId" name="priorityName" tabindex="1" style="width: 100px;">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select>
								
									<label id="referdistrictLabel" style="width:100px;">District</label> <select
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
									</select> 
										<div class="clear"></div>
									<label id="referHospitalTypeLabel" >Hospital Type</label> <select
										id="referHospitalType" name="referHospitalType" style="width:168px; margin-right:0px;"
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
									
									<label id="referhospitalLabel"  style="width:100px;">Hospital</label> <select
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
									<label id="referdepartmentLabel">Department</label> <select	id="referdepartment" name="referdepartment"
										onchange="fnGetDoctorDepartment(this.value);getSessionForDepartment(this.value);" style="width:169px; margin-right:0px;" >
										<option value="0">Select</option>
										<%for(MasDepartment dep:deptList){
										%>
										<%if(deptId==dep.getId()) {%>
										<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
										<%}else{ %>
										<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
										<%} %>
										<%}%>
									</select>
									
									<label id="refersessionLabel" style="width:115px;">Session</label> <select
										id="opsession" name="referredSession" style="width: 100px;">
										<option value="0">Select</option>
										
												
										
									</select> 
									 <label style="width:100px;">Doctor</label> <select id="refereddoctor"
										name="refereddoctor">
										<option value="0">Select</option>
									</select>		
		
									<div class="clear"></div>
									<label>Patient Advise</label>
									<textarea name="patientAdvise" validate="patientAdvise,string,no" style="margin-left:0px; width:141px;"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="5" onkeyup="return checkLength(this)"></textarea>
									<input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> <label style="width:101px;margin-left:0px;">Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"
										id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5" style="margin-left:0px;width: 162px;"
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
			</div>
	<div class="paddingTop5"></div>
	<label>Remarks</label>

		
	<textarea class="large" name="opdRemarks" id="opdRemarks"
		style="width: 83%; margin-left: 4px; height: 60px;overflow-x:hidden;resize:vertical;" cols="0" rows="0"
		maxlength="500" ><%=opdPatientDetails!=null && opdPatientDetails.getOpdRemarks()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getOpdRemarks():"" %></textarea>
	<%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")) && visit!=null && visit.getVisitNo()>1) {%>
		<div class="clear"></div>
		<label>Review</label>
		<textarea name="opdReview" id="opdReview"
		style="width: 83%; margin-left: 4px; height: 60px;" cols="0" rows="0" class="large historyAutoComplete"
		maxlength="256"(this)" > </textarea>
	<%} %>
	
	<%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")) && visit!=null && visit.getVisitNo()>1) {%>
		<div class="clear"></div>
		<label>Review</label>
		<textarea name="opdReview" id="opdReview"
		style="width: 83%; margin-left: 4px; height: 60px;" cols="0" rows="0" class="large historyAutoComplete"
		maxlength="256" > </textarea>
	<%} %>
					<input type="hidden" id="reviewDate" name="reviewDate" class="dateTextSmall" value="<%=currentDate%>" readonly="readonly">
					<input id="PatientUhid" type="hidden" name="UHID" value="<%=visit.getHin().getHinNo()%>" >
					<input id="deptId" name="deptId" type="hidden" value="<%=deptId%>" />
					<input id="doctorId" name="doctorId" type="hidden" value="<%=request.getParameter(CONSULTING_DOCTOR) %>" >
	<div class="clear"></div>
	<div class="paddingTop5"></div>
			</div>
</div>
<%-- <%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics"))){%> --%>
  <div id="tab2" class="tab_content">
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
				<div class="clear"></div>
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
					
					/* if(patientHistory[10] != null && ((Integer)patientHistory[10])!=0){
						findings+="Vitals: Height-"+(Double)patientHistory[10];
					} 
					if(patientHistory[11] != null && ((Double)patientHistory[11])!=0){
						findings+="weight-"+(Double)patientHistory[11];
					}*/
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
			
			<div class="summaryDivMain">
			<label>Procedure done</label>
			<div class="summaryDetails"><p><%=procedureDone %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Remarks</label>
			<div class="summaryDetails"><p><%=opdRemarks %></p></div>
			</div>
			
			<div class="clear"></div>
			</div>
			</div>


<!-- --------------------------------End Code for Clinical Summary---------------------------------------------------------- -->
        

   </div>

	<%-- <%} %> --%>
        <div id="tab3" class="tab_content">
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

          <div class="clear"></div> 
			</div>
        </div>

 <!-- ----- tab4---- -->
        <div id="tab4" class="tab_content">
         
<div style="width:100%; height:200px;" id="specialityDiv"></div>

         <div class="clear"></div> 
        </div>
        
        <!-- ----- tab5---- -->
		 <div id="tab5" class="tab_content">
		 
          <div style="width:100%; height:200px;"></div>
          
          <div class="clear"></div> 
        </div> <!-- ----- tab4---- -->
        <div id="tab4" class="tab_content">
         
<div style="width:100%; height:200px;"></div>

         <div class="clear"></div> 
        </div>
        
        <!-- ----- tab5---- -->
		 <div id="tab5" class="tab_content">
		 
          <div style="width:100%; height:200px;"></div>
          
          <div class="clear"></div> 
        </div>


   <!--    tab contenair end  --> 
    </div>

    <div class="clear"></div>

	<input type="hidden" name="userName" value="<%=userName %>" />
		<input type="hidden" name="diagnosis_status" id="diagnosis_status" />
		
	<input id="visitId" name="visitId" id="visitId" type="hidden"
			value="<%=visit.getId()%>" /> <input name="hinId" id="hinId" type="hidden"
			value="<%=visit.getHin().getId()%>" /> <input name="hinNo" id="hinNo"
			type="hidden" value="<%=visit.getHin().getHinNo()%>" /> <input
			name="departmentId" type="hidden"
			value="<%=visit.getDepartment().getId()%>" /> 
			<input name="departmentCode" id="departmentCode" type="hidden" value="<%=map.get("departmentCode")!= null?map.get("departmentCode").toString():""%>" />
			<input
			name="hospitalId" id="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
			name="empId" type="hidden" value="<%=docId%>" /> <input
			name="deptId" type="hidden" value="<%=deptId%>" /> <input id="consultationDate"
			name="consultationDate" type="hidden" value="<%=consultationDate%>" />
			<input name="opdpatientDetailId" type="hidden" value="<%=opdpatientDetailId%>"/>
			<input name="pHeaderId" type="hidden" value="<%=pHeaderId%>"/>
			
		<input name="consultationTime" type="hidden"
			value="<%=consultationTime%>" />
		<input type="hidden" id="patientName" name="patientName" value="<%=patientName %>" />
		<input type="hidden" id="gender" name="gender" value="<%=gender != null?gender:"" %>" />
		<input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge != 0?patientAge:"" %>" />

</div>
	<input name="Submit11" id="Submit11" class="buttonAuto" value="Submit"
		type="button" align="right" style="background: #c55a11; color: #fff;" onclick="if(checkForProcedure()){if(fillcheckDoseFrequency() ){fnSubmitPatient('s');}}"/>
	<input name="Submit11" id="Submit11" class="buttonAuto" value="Reset"
		type="button" align="right" style="background: #c55a11; color: #fff;" />


<table id="termTable" style="display: none;">
		<thead><tr><th>ConceptId</th><th>Terms</th><th>Type</th></tr></thead>
	</table>
<script>
function calculateBMI() {
	var height = document.getElementById("height").value;
	var weight = document.getElementById("weight").value;
	document.getElementById("bmi").value = "";
	if(height != null && weight != null && height != "" && weight != "") {
		var height = 	parseFloat(height)/100;
		document.getElementById("bmiValue").value = ((weight/(height*height)).toFixed(2));
		document.getElementById("bmi").innerHTML = document.getElementById("bmiValue").value;
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

jQuery(function($) {
$(".allownumericwithoutdecimal").on(
		"keypress keyup blur",
		function(event) {
			$(this).val($(this).val().replace(/[^\d].+/, ""));
			if ((event.keyCode != 46) && ((event.keyCode != 37))
					&& ((event.keyCode != 39)) && (event.keyCode != 9)
					&& (event.keyCode != 8)
					&& (event.which < 48 || event.which > 57)) {
				event.preventDefault();
			}
		});
})



function showHideOtherVitals()
{
   var div = document.getElementById("otherVitalDiv");
if (div.style.display !== "block") {
   div.style.display = "block";
}
else {
   div.style.display = "none";
}
}


function addRowInvestigationForLP() {

	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValue');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	var cellRight1 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'chargeRadio' + iteration;
	e0.id = 'chargeRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'availableStatus' + iteration;
	e0.id = 'availableStatus' + iteration;
	e0.size = '20';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'parkInvestigationId' + iteration;
	e0.id = 'parkInvestigationId' + iteration;
	cellRight1.appendChild(e0);

	var cellRight0 = row.insertCell(1);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.style="width: 672px;" ;
	e0.name = 'chargeCodeName' + iteration;
	e0.id = 'chargeCodeName' + iteration;
	e0.onkeypress = function() {
		checkTextColor('chargeCodeName' + iteration);
	};
	e0.onblur = function() {
		getUnavailableInvestigation(iteration);
		checkInvestigationItem(iteration);
		getLoincSnomedList(iteration);
		if (validateInvestigationAutoComplete(this.value, iteration)) {
			submitProtoAjaxNew('opdMain',
					"/hms/hms/opd?method=fillChargeCode&hinId="
							+ document.getElementById("hinId").value
							+ "&rowVal=" + iteration, 'chargeCodeVal'
							+ iteration);
		}
	};
	e0.size = '65';
	e0.className = "textYellow largTextBoxOpd";
	cellRight0.appendChild(e0);

	var updatediv = document.createElement('div');
	updatediv.setAttribute('id', 'ac2update' + iteration);
	updatediv.style.display = 'none';
	updatediv.className = "autocomplete";
	cellRight0.appendChild(updatediv);

	new Ajax.Autocompleter('chargeCodeName' + iteration, 'ac2update'
			+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
		minChars : 3,
		callback : function(element, entry) {
			return entry + '&labradiologyCheck='
					+ document.getElementById('investigationCategory').value;
		},
		parameters : 'requiredField=chargeCodeName' + iteration
				+ '&fromOpd=fromOpd'
	});

	
	// var cellRightSel = row.insertCell(3);
	// cellRightSel.id='chargeCodeVal'+iteration;
	var sel = document.createElement('input');
	sel.type = 'hidden';
	sel.name = 'chargeCode' + iteration;
	sel.id = 'chargeCode' + iteration;
	sel.size = '15';
	cellRight2.appendChild(sel);

}


function addRowMedicineForLP() {
	var tbl = document.getElementById('grid');

	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.onchange = function() {
		checkPrescriptionCheck(iteration);
	};
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'prescription_availableStatus' + iteration;
	e1.id = 'prescription_availableStatus' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclaturepTab' + iteration;
	e1.id = 'nomenclature' + iteration;
	e1.style="width: 160px;" ;
	e1.className = "textYellow largTextBoxOpd";
	/* e1.onfocus = function() {
		checkFrequency(iteration, "opc");
	} */
	e1.onkeypress = function() {
		checkTextColor('nomenclature' + iteration);
	};
	e1.onblur = function() {
		checkForAlreadyIssuedPrescribtion(this.value, iteration);
		populatePVMS(this.value, iteration);
		checkItem(iteration);
		ValidateCantra();
		displayAu(this.value, iteration);
		validatePrescriptionAutocomplete('opmain', this.value, iteration);
		checkForAllergy(this.value, iteration);
		
	};
	e1.size = '35';
	cellRight1.appendChild(e1);
	e1.focus();

	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updates' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclature' + iteration,
			'ac2updates' + iteration,
			'opd?method=getItemListForAutoCompleteItem', {
				minChars : 3,
				callback : function(element, entry) {
					return entry + '&pharmacyCheck='
							+ document.getElementById('pharmacyCategory').value;
				},
				parameters : 'requiredField=nomenclaturepTab' + iteration
			});

	

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'brandId' + iteration;
	e1.id = 'brandId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'manufactureId' + iteration;
	e1.id = 'manufactureId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNopTab' + iteration;
	e1.id = 'pvmsNo' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualDispensingQty' + iteration;
	e1.id = 'actualDispensingQty' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixable' + iteration;
	e1.id = 'mixable' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureQuantity' + iteration;
	e1.id = 'mixtureQuantity' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureUnit' + iteration;
	e1.id = 'mixtureUnit' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualTotalAfterMix' + iteration;
	e1.id = 'actualTotalAfterMix' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'tapered' + iteration;
	e1.id = 'tapered' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'alreadyPres' + iteration;
	e1.id = 'alreadyPres' + iteration;
	e1.value='N';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'routepTab' + iteration;
	e1.id = 'route' + iteration;
	e1.className = "medium2 textYellow";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	e1.onblur = function() {
		fillRouteOnTAb(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosagepTab' + iteration;
	e1.id = 'dosage' + iteration;
	e1.className = "textYellow allownumericwithdecimal opdTextBoxTSmall";
	e1.size="3";
	e1.maxLength = "3";
	e1.onblur = function() {
		fillValue(this.value, iteration);checkFrequencyForTaperedDrugs(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unit' + iteration;
	e1.id = 'unit' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'frequencypTab' + iteration;
	e1.id = 'frequency' + iteration;
	e1.className = 'textYellow';
	e1.style.width = "69px";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		// this part is added by amit das 
		 var opt = document.createElement('option'); 
		 	opt.id = icdArray[i][2];
		 	opt.value = icdArray[i][0];
		    opt.innerHTML = icdArray[i][1];
		    e1.appendChild(opt);
		 //e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); // this part is commented by amit das
	}
	e1.onblur = function() {
		getFrequencyValue(this.value, iteration);
		fillValue(this.value, iteration);
		displaySOSQty(this.value, iteration);	
		checkFrequencyForTaperedDrugs(iteration);
	};
	
	e1.onchange = function() { // added by amit das
		displaFrequencyTypeForLP(this, iteration);	
	};
	
	cellRight1.appendChild(e1);
	
	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQty' + iteration;
	e21.id = 'sosQty' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValue' + iteration;
	e21.id = 'frequencyValue' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(6);
	
	/* var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;'; */
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDayspTab' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.id = 'noOfDays' + iteration;
	e1.size = '3';
	e1.maxLength = "3";
	e1.onblur = function() {
		fillValue(this.value, iteration);
	};
	e1.onkeypress=function(event){
		return isNumberOnly(event);
	};
	cellRight1.appendChild(e1);
	
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyType' + iteration;
	cellRight1.appendChild(ef21);
	/* cellRight1.appendChild(e21Div); */

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'instrunctionpTab' + iteration;
	e1.id = 'instrunction' + iteration;
	e1.style = "width: 90px;";
	e1.className = 'textYellow';
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionArray.length; i++) {
		e1.options[i + 1] = new Option(instructionArray[i][1],
				instructionArray[i][0]);
	}
	e1.setAttribute("onchange", "toggleOtherTextbox1(this,'splInstrunctionpTab"
			+ iteration + "','200','otherSplInstrunctionSpan" + iteration + "','68px')");
	cellRight1.appendChild(e1);

	var dateSpan = document.createElement('span');
	dateSpan.id = 'otherSplInstrunctionSpan' + iteration;
	cellRight1.appendChild(dateSpan);

	//var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'totalpTab' + iteration;
	e1.id = 'total' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);

/* 	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.maxlength = '200';
	e1.name = 'splInstrunction' + iteration;
	e1.id = 'splInstrunction' + iteration;
	e1.className = "textYellow opdTextBoxSmall";
	e1.style = "width: 105px;";
	cellRight1.appendChild(e1); */
	
}

function fnGetPrescriptionTemplate(tempId) {
	var result = "";
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
		}
	}

	var len = document.getElementById("grid").rows.length;

	for (i = len - 1; i > 0; i--) {
		if (document.getElementById("nomenclature" + (i - 1)) != null
				&& document.getElementById("nomenclature" + (i - 1)).value == '')
			var tbl = document.getElementById("grid").deleteRow(i);
	}
	var updatedLen = document.getElementById("grid").rows.length;

	/* var tablen = document.getElementById("prescriptionTabGrid").rows.length; */
/* 	for (i = tablen - 1; i > 0; i--) {
		if (document.getElementById("nomenclaturepTab" + (i - 1)) != null
				&& document.getElementById("nomenclaturepTab" + (i - 1)).value == '')
			/* var tabtbl = document.getElementById("prescriptionTabGrid")
					.deleteRow(i); */
	/* }
	var updatedTabLen = document.getElementById("prescriptionTabGrid").rows.length; */

	var visitId = document.getElementById("visitId").value;
	var hinId = document.getElementById("hinId").value;

	if (tempId.value != 0) {
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getPrescriptionTemplateOP&templateId="
						+ result + "&updatedLen=" + updatedLen + "&hinId="
						+ hinId + "&visitId=" + visitId+"&departmentCode="+document.getElementById("departmentCode").value, 'divTemplet1');
		/* submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getPrescriptionTemplateTab&templateId="
						+ result + "&updatedLen=" + updatedTabLen + "&hinId="
						+ hinId + "&visitId=" + visitId, 'divTemplet2'); */
	}

	setDisablePharmacy();
}


function fnGetInvestigationTemplate(tempId) {
	var result = "";
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
		}
	}
	if (tempId.value != 0) {
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getLabInvestigationTemplate&templateid="
						+ result + "&hinId="
						+ document.getElementById("hinId").value +"&departmentCode="+document.getElementById("departmentCode").value+ "&"
						+ csrfTokenName + "=" + csrfTokenValue, "labInvDiv");
	}
}

function addRowTreatmentNursingCareLP() {

	var tbl = document.getElementById('gridNursing');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('nursinghdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'nursingRadio' + iteration;
	e1.id = 'nursingRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'procedureDetailId' + iteration;
	e1.id = 'procedureDetailId' + iteration;
	e1.size = '35';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'procedureName_nursing' + iteration;
	e1.id = 'procedureName_nursing' + iteration;
	e1.style.width="320px";
	e1.size = '35';
	e1.onblur = function chkProcedure() {
		validatePrescriptionAutocomplete('opNursingProc', document
				.getElementById('procedureName_nursing' + iteration).value,
				iteration);
	}

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updates_nursing' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('procedureName_nursing' + iteration,
			'ac2updates_nursing' + iteration,
			'opd?method=getNursingCareProcedureAutoList', {
				minChars : 3,
				callback : function(element, entry) {
					return entry + '&minor_major=1';
				},
				parameters : 'requiredField=procedureName_nursing' + iteration
			});

	var cellRight2 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'frequency_nursing' + iteration;
	e1.id = 'frequency_nursing' + iteration;
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
	}
	cellRight2.appendChild(e1);

	var cellRight3 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDays_nursing' + iteration;
	e1.className = "textSmall";
	e1.id = 'noOfDays_nursing' + iteration;
	e1.size = '3';
	e1.maxLength = "3";
	e1.onkeypress=function(event){
		return isNumberOnly(event);
	};
	cellRight3.appendChild(e1);

	var cellRight4 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.name = 'remark_nursing' + iteration;
	e1.id = 'remark_nursing' + iteration;
	e1.maxlength="100";
	e1.style.width="510px";
	cellRight4.appendChild(e1);
}


function addRowTreatmentSurgeryNP() {

	var tbl = document.getElementById('gridSurgery');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('surgeryhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryRadio' + iteration;
	e1.id = 'surgeryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'surgeryDetailsId' + iteration;
	e1.id = 'surgeryDetailsId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'procedureName_surgery' + iteration;
	e1.id = 'procedureName_surgery' + iteration;
	e1.style.width="250px";
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'PROCEDURE', 'ALL', returnlimit_IN,
				callbck_index, 'procedureName_surgery' + iteration);
	};
	e1.onblur = function() {
		checkMappedCharge(this.value, iteration);
	};
	e1.size = '35';
	cellRight2.appendChild(e1);

	/*
	 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
	 * 'ac2updates_surgery'+iteration); newdiv.style.display = 'none';
	 * newdiv.className = "autocomplete textYellow";
	 * cellRight1.appendChild(newdiv); new
	 * Ajax.Autocompleter('procedureName_surgery'+iteration,'ac2updates_surgery'+iteration,'opd?method=getNursingCareProcedureAutoList',{minChars:3,
	 * callback: function(element, entry) { return entry + '&minor_major=2'; },
	 * parameters:'requiredField=procedureName_surgery'+iteration});
	 */
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'surgery_code_id' + iteration;
	e1.id = 'surgery_code_id' + iteration;
	cellRight2.appendChild(e1);

	var cellRight3 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'tentativeDate' + iteration;
	e1.id = 'tentativeDate' + iteration;
	e1.size = '5';
	e1.className="small";
	e1.value = "";
	e1.readOnly = true;
	cellRight3.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('tentativeDate' + iteration);
		setdate(document.createElement('consultationDate').value, obj, event);
	};
	cellRight3.appendChild(img1);

	var cellRight4 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'remark_surgery' + iteration;
	e1.id = 'remark_surgery' + iteration;
	e1.maxlength="100px";
	e1.style.width="610px";
	cellRight4.appendChild(e1);



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
function fillValue(value, inc, from) {
	var dosage;
	var freq;
	var dispenseQty;
	var noOfDays;
	var sosQty;
	// added by amit das on 19-11-2016
	var unit;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;

	// added by govind 24-01-2017
	setDisablePharmacy();
	// added by govind 24-01-2017 end
	if (from != 'tab') {
		dosage = document.getElementById('dosage' + inc).value;
		freq = document.getElementById('frequencyValue' + inc).value;
		dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
		noOfDays = document.getElementById('noOfDays' + inc).value;
		sosQty = document.getElementById('sosQty' + inc).value;

		// added by amit das on 19-11-2016
		unit = document.getElementById('unit' + inc).value;
		/*
		 * mixable = document.getElementById('mixable' + inc).value;//commented
		 * by govind 23-12-2016 mixtureUnit =
		 * document.getElementById('mixtureUnit' + inc).value; mixtureQuantity =
		 * document.getElementById('mixtureQuantity' + inc).value;
		 */

		if (document.getElementById('mixable' + inc) != null) {
			mixable = document.getElementById('mixable' + inc).value;
		}
		if (document.getElementById('mixtureUnit' + inc) != null) {
			mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
		}
		if (document.getElementById('mixtureQuantity' + inc) != null) {
			mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
		}
		// commented by govind 23-12-2016 end

		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total = Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}

		var finalQty = "";
		var actualFinalQty = "";
		if (document.getElementById('frequency' + inc).value != 13) {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {

				// condition added by amit das on 19-11-2016
				if (mixable == 'Y') {
					// var solutionMixAmount = parseFloat(mixtureQuantity) +
					// parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
							* parseFloat(total);
					if (actualFinalQty != '0.00') {
						finalQty = parseFloat(actualFinalQty)
								/ parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;

				} else {
					var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
							.toFixed(2);
					if (totalQty != '0.00') {
						finalQty = freq > 0 ? Math.ceil(totalQty) : "";
					}
					document.getElementById('total' + inc).value = finalQty;
				}
			} else {

				document.getElementById('total' + inc).value = total;

			}
		} else {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {

				// condition added by amit das on 19-11-2016
				if (diluteable == 'Y') {
					// var solutionMixAmount = parseFloat(mixtureQuantity) +
					// parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
							* parseFloat(total);
					if (actualFinalQty != '0.00') {
						finalQty = parseFloat(actualFinalQty)
								/ parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;

				} else {

					var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
							.toFixed(2);
					if (totalQty != '0.00') {
						finalQty = freq > 0 ? Math.ceil(totalQty) : "";
					}
					document.getElementById('total' + inc).value = finalQty;
				}
			} else {

				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
				
			}
		}

	

	} else {

		unit = document.getElementById('unit' + inc).value;

		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total = Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}

		var finalQty = "";
		if (document.getElementById('frequencypTab' + inc).value != 13) {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('total' + inc).value = total;
			}
		} else {

			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
			}
		}

		document.getElementById('dosage' + inc).value = dosage;
		document.getElementById('noOfDays' + inc).value = noOfDays;
		document.getElementById('frequencyValue' + inc).value = freq;
		document.getElementById('actualDispensingQty' + inc).value = dispenseQty;
		document.getElementById('sosQty' + inc).value = sosQty;
		document.getElementById('frequency' + inc).value = document
				.getElementById('frequencypTab' + inc).value;
	
	}
}

function displaySOSQty(val, inc) {
	if (val == '13') {
		document.getElementById('sosQty' + inc).style.display = 'block';
		document.getElementById('noOfDays' + inc).disabled = true;
	} else {

		document.getElementById('sosQty' + inc).style.display = 'none';
		document.getElementById('noOfDays' + inc).disabled = false;
		
	}
}
function validateFieldValues(from) {
	var dateSelected = document.getElementById("reviewDate").value;

	if (from == 'n') {
		if (confirm("Do you want to skip this patient!")) {
			submitForm('opdMain',
					'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
		}
		return false;
	} else {
		/*
		 * if (document.getElementById('diagnosisId').length == 0 &&
		 * document.getElementById('OtherDiagnosis').value.trim().length == 0) {
		 * alert("Please Enter the diagnosis of the Patient.");
		 * document.getElementById("snomed").focus(); if (from != 's' && from !=
		 * 'p') { if (confirm("Do you want to skip this patient!")) {
		 * submitForm('opdMain',
		 * 'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1'); } }
		 * return false; }
		 */
		if (from != 's' && from != 'p') {
			if (confirm("Do you want to skip this patient!")) {
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
			}
		}
		return true;// commented and added by govind 31-01-2017
	}

	if (dateSelected != "") {
		var visitDate = new Date(dateSelected.substring(6), (dateSelected
				.substring(3, 5) - 1), dateSelected.substring(0, 2))
		var currentDate = new Date(serverdate.substring(6), (serverdate
				.substring(3, 5) - 1), serverdate.substring(0, 2))
		if (visitDate < currentDate) {
			document.getElementById("reviewDate").value = document
					.createElement('consultationDate').value;
			alert("Please enter the correct Visit date.")
			return false;
		}
	}

	var systolic = document.getElementById("systolic").value;
	var diastolic = document.getElementById("diastolic").value;
	if (diastolic != null && diastolic != ''
			&& (systolic == null || systolic == '')) {
		alert('please fill systolic');
		return false;
	} else if (systolic != null && systolic != ''
			&& (diastolic == null || diastolic == '')) {
		alert('please fill diastolic');
		return false;
	}
	// code for chaecking investigation requistion grid
	var tbl = document.getElementById('grid');
	var lastRow = parseInt(tbl.rows.length);
	var nomenclature = "";
	var pnomenclature = "";

	if (document.getElementById('mlscasetype').length != 0) {
		var x = document.getElementById("mlscasetype");
		var val = "";
		for (var i = 0; i < x.options.length; i++) {
			if (x.options[i].selected == true) {
				val = x.options[i].value;
				// alert(val);
				// alert(val.contains('postmortem'));
				if (val.indexOf("postmortem") > -1) {
					if (document.getElementById('patient_expire').checked == false) {
						alert("Please check Patient is dead as you are referring for postmortem examination.");
						return false;
					}
				}
			}
		}
	}
	return true;
}
function getICDListBasedOnSnomedId() {

	var $ = jQuery.noConflict();
	var val = "";
	if ($("#snomedTermConceptIdEXM").val() != "") {
		val = $("#snomedTermConceptIdEXM").val();
	}
	if ($("#snomedTermConceptId").val() != "") {
		val = $("#snomedTermConceptId").val();
	}
	var temp = val;
	/* $("#icdName").empty();
	$("#divIcdName").hide();

	$("#icdNameExm").empty();
	$("#divIcdNameExm").hide(); */
console.log("val"+val);
	if (val != "") {
		// console.log("val="+val);
		// var index1 = val.lastIndexOf("[");
		// var index2 = val.lastIndexOf("]");
		// index1++;
		var id = val; // val.substring(index1,index2);

		var tempStr = $("#snomed").val(); // val.substring(0,index1-1);
		var objsnomedList = document.getElementById('snomedList');
		var SnStatus = false;
		for (var i = 0; i < objsnomedList.length; i++) {
			var temp = $("#snomedList option").eq(i).text();
			if (temp == tempStr)
				SnStatus = true;
		}
		if (!SnStatus && tempStr != "") {
			$("#snomedList").append(
					"<option value='" + tempStr + "'>" + tempStr + "</option>");
			objsnomedList.options[objsnomedList.length - 1].selected = true;
		}

		var data = "snomedId=" + id;
		var url = "opd?method=getICDListBasedOnSnomedId&" + csrfTokenName + '='
				+ csrfTokenValue;

		$("#icdName").empty();
		document.getElementById('icdCode').value = "";
		document.getElementById('icd1').value = "";

		jQuery(function($) {

			$
					.ajax({
						type : "POST",
						url : url,
						data : data,
						dataType : "json",
						cache : false,
						success : function(msg) {
							var jsonData = msg;
							var totalMatches = jsonData.length;
							/*
							 * if(totalMatches == 0) { alert("ICD Name does not
							 * exist with this Snomed Name"); return }
							 */
							 console.log("totalMatches= "+totalMatches);
							if (totalMatches == 1) {

								var b = false;
								document.getElementById('icd1').value = jsonData[0].IndName
										+ "["
										+ jsonData[0].IcdCode
										+ "@@@"
										+ jsonData[0].SnomedId + "]";
								document.getElementById('icdCode').value = "["
										+ jsonData[0].IcdCode + "]";

								var val = document.getElementById('icd1').value;
								var index1 = val.lastIndexOf("[");
								var index2 = val.lastIndexOf("]");
								index1++;
								var BothId = val.substring(index1, index2);
								var tempArray = new Array();
								tempArray = BothId.split("@@@");
								var ICdId = tempArray[0];
								var SnomedId = tempArray[1];

								var tempIcdId = ICdId;
								tempIcdId = tempIcdId.replace(".", "_");
								tempIcdId = tempIcdId.replace("*", "idid");
								tempIcdId = tempIcdId.replace("?", "~");
								console.log("id="+id);
								if (id == "") {
									return;
								} else {
									var obj = document
											.getElementById('diagnosisId');

									for (var i = 0; i < obj.length; i++) {
										var temp = $("#diagnosisId option").eq(
												i).val();
										/*
										 * var temp = obj.options[i].value; var
										 * length=obj.length-1;
										 */
										var BothId = new Array();
										BothId = temp.split("-");

										var tempArray = new Array();
										tempArray = BothId[0].split("@@@");
										var tempICdId = tempArray[0];
										var tempSnomedId = tempArray[1];
										/*
										 * alert("ICdId="+ICdId);
										 * alert("tempICdId="+tempICdId);
										 */

										if (ICdId == tempICdId) {
											alert("ICD  Already taken");
											document.getElementById('icd').value = ""
											document.getElementById('icd2').value = ""
											b = true;
											break
										}
									}
								}
								if (!b) {
									var flag = 2;
									var obj = document
											.getElementById('diagnosisId');

									for (var x = 0; x < obj.length; x++) {

										var temp = $("#diagnosisId option").eq(
												x).val();
										/* alert(temp); */
										var BothId = temp.split("-");
										var tempArray = new Array();
										tempArray = BothId[0].split("@@@");
										var tempICdId = tempArray[0];
										var tempSnomedId = tempArray[1];

										if (SnomedId == tempSnomedId) {
											flag = 1;
											break;
										}
									}

									if (flag != 1) {
										var obj = document
												.getElementById('diagnosisId');
										var length = obj.length + 1;

										$("#diagnosisId").append(
												"<option value="
														+ jsonData[0].IcdCode
														+ "@@@"
														+ jsonData[0].SnomedId
														+ "-0>"
														+ jsonData[0].IndName
														+ "["
														+ jsonData[0].IcdCode
														+ "]</option>");

										obj.options[obj.length - 1].selected = true;
										if (document
												.getElementById('diagnosisId1') != null) {
											obj = document
													.getElementById('diagnosisId1');
											var tableRow = obj.rows.length;
											var row = obj.insertRow(tableRow);
											var cell1 = row.insertCell(0);
											var cell2 = row.insertCell(1);
											var cell3 = row.insertCell(2);
											cell1.innerHTML = jsonData[0].IndName
													+ "["
													+ jsonData[0].IcdCode
													+ "]";
											cell2.innerHTML = "<input type='checkbox' id='"
													+ tempIcdId
													+ "' class='radioCheckCol2' value='"
													+ tempIcdId
													+ "' onclick='fnCopyToComorbidityTab(\""
													+ tempIcdId + "\")'/>";
											cell3.innerHTML = "<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
										}
										notifiablePregisterCheck(tempIcdId,
												jsonData[0].IndName + "["
														+ jsonData[0].IcdCode
														+ "]");
									} else {
										alert("Diagnosis already exist");
									}
								}
							}

							if (parseInt(totalMatches) > 1) {

								$("#divIcdName").show();
								$("#icdName").append(
										"<option value='0'>Select</option>");
								for (i = 0; i < jsonData.length; i++) {

									$("#icdName").append(
											"<option value="
													+ jsonData[i].IcdCode
													+ "@@@"
													+ jsonData[i].SnomedId
													+ ">" + jsonData[i].IndName
													+ "[" + jsonData[i].IcdCode
													+ "]</option>");

								}

								$("#divIcdNameExm").show();
								$("#icdNameExm").append(
										"<option value='0'>Select</option>");
								for (i = 0; i < jsonData.length; i++) {

									$("#icdNameExm").append(
											"<option value="
													+ jsonData[i].IcdCode
													+ "@@@"
													+ jsonData[i].SnomedId
													+ ">" + jsonData[i].IndName
													+ "[" + jsonData[i].IcdCode
													+ "]</option>");

								}

							}

						},
						error : function(msg) {

							// alert("An error has occurred while contacting the
							// server");

						}

					});
		});

	}// close else
	//$("#snomed").val("");
	/* $("#icd2").val("");
	$("#snomedTermConceptId").val("");
	$("#snomedTermConceptIdEXM").val(""); */

}
function selectSNOMEDCT(state_IN, semantictag_IN, acceptability_IN,
		returnlimit_IN, callback, from, iteration) {
	jQuery(function($) {
		if (returnlimit_IN <= -1 || returnlimit_IN == ''
				|| returnlimit_IN == undefined || returnlimit_IN == null) {
			returnlimit_IN = -1;

		}
		returnlimitParam = returnlimit_IN;

		if (state_IN == -1 || state_IN == null || state_IN == ''
				|| state_IN == undefined) {
			state_IN = enumSTATE.BOTH;
		} else

			state_IN = enumSTATE[state_IN];

		stateParam = state_IN;

		if (semantictag_IN == -1 || semantictag_IN == null
				|| semantictag_IN == undefined || semantictag_IN == '') {
			semantictag_IN = enumSEMANTICTAG.ALL;
		} else
			semantictag_IN = enumSEMANTICTAG[semantictag_IN];

		semantictagParam = semantictag_IN;

		if (acceptability_IN == -1 || acceptability_IN == null
				|| acceptability_IN == undefined || acceptability_IN == '') {
			acceptability_IN = enumACCEPTABILITY.ALL;
		} else
			acceptability_IN = enumACCEPTABILITY[acceptability_IN];

		acceptabilityParam = acceptability_IN;

		jQuery('.ui-dialog button:nth-child(0)').button('disable');
		$('.ui-dialog-buttonpane').find("button").show().filter(
				":contains('.')").hide();

		var txtBox = document.getElementById(from);
		txtBox.focus();

		var xhrRequest = null;
		$("#" + from)
				.autocomplete(
						{
							max : 20,
							minLength : 3,
							cacheLength : 1,
							scroll : false,
							width : 520,
							highlight : false,
							autoFocus : false,
							source : function(request, response) {

								var dataValue = document.getElementById(from).value;

								var servURL = "";
								if (dataValue == '') {
									$("#dialog-form").dialog("option",
											"height", 160);
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									var txtBox = document.getElementById(from);
									txtBox.focus();
									return;
								}

								if (dataValue.length >= 3) {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$("#msg3chars").hide();
									$('#nosuggestion').hide();

								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}

								servURL = enumSERVICES.SEARCH.suggestbyacceptability_url;
								var refsetidParam = document.getElementById('refsetId').value;
								servURL += "?term="
										+ encodeURIComponent(request.term)
										+ "&state=" + stateParam
										+ "&semantictag=" + semantictagParam
										+ "&acceptability="
										+ acceptabilityParam
										+ "&returnlimit=10&refsetid="+refsetidParam;
								console.log(servURL);

								if (xhrRequest && xhrRequest.readystate != 4)
									xhrRequest.abort();
								xhrRequest = $
										.ajax({
											type : "GET",
											url : servURL,
											dataType : "jsonp",
											crossDomain : true,
											success : function(data,
													textStatus, jqXHR) {
												console.log(data);
												var items = data;

												response(items);
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);

											}
										});

							},
							select : function(event, ui) {
								var data = document.getElementById(from).value;
								if (data.length >= 3) {
									$("#msg3chars").hide();
									$('#nosuggestion').hide();
									document.getElementById(from).value = ui.item.value;
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									displaySearch = false;
									loadResultsList(stateParam,
											semantictagParam,
											acceptabilityParam,
											returnlimitParam, callback, from,
											iteration);
								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}
							}

						});
	});
}

function addRowForAllergy() {
	var tbl = document.getElementById('alergyGrid');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('allergyCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'allergyRadio' + iteration;
	e1.id = 'allergyRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'allergyDetailId' + iteration;
	e1.id = 'allergyDetailId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'allergyType' + iteration;
	e1.id = 'allergyType' + iteration;
	e1.style.background = "#FFFF99";
	e1.style.width='62px';
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < allergyTypeArray.length; i++) {
		e1.options[i + 1] = new Option(allergyTypeArray[i][1],
				allergyTypeArray[i][0]);
	}

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergyName' + iteration;
	e1.id = 'allergyName' + iteration;
	e1.className = "largTextBoxOpd textYellow";
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'allergyName' + iteration);
	};
	e1.maxLength = "60";
	e1.size = '20';
	e1.style.width='68px';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergy_remarks' + iteration;
	e1.id = 'allergy_remarks' + iteration;
	e1.className = "small textYellow";
	e1.maxLength = "30";
	cellRight1.appendChild(e1);
	


}
function setDisablePharmacy() {

}
function isNumberOnly(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
		 if (iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}


function fillcheckDoseFrequency() {
	var hdb = document.getElementById("hdb").value;

	var i;
	var status = true;

	for (i = 0; i <= hdb; i++) {
		if (document.getElementById("nomenclature" + i) != null) {
/* 			if (document.getElementById("tapered" + i) == "") { */
				var itemName = document.getElementById("nomenclature" + i).value;
				// alert(itemName);
				if (itemName) {
					var res = itemName.split("(");
					if (res) {
						var dosage = document.getElementById("dosage" + i).value;
						if (!dosage || dosage=="0") {
							status = false;
							alert("Enter the Dosage")
							return;
						}

						 var unit = document.getElementById("unit" + i).value;
						if (unit == "") {
							alert("Unit not available")
							status = false;
							return;
						} 
						if (document.getElementById("frequency" + i).selectedIndex == "0") {
							alert("Select Frequency")
							status = false;
							return;
						}

						var noOfDays = document.getElementById("noOfDays" + i).value;

						if (!noOfDays || noOfDays=="0") {
							alert("Enter Days")
							status = false;
							return;
						}

					}
				}
			//}
		}
	}

	return status;

}

function validateFrequency(counter){
	   
	   if(counter!=undefined)
		   var count = document.getElementById(counter).value;
	   else
		var count = document.getElementById('hdb').value;
		//alert("fasfsf"+count);
		for(var i = 1; i <= count;i++){
			
			//var nomenclature = document.getElementById('nomenclature'+i).value;
			if((document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != '') ||( document.getElementById('otherMedicine'+i) && document.getElementById('otherMedicine'+i).value != '')){
			//if(document.getElementById('nomenclature'+i).value != ''){
				if(document.getElementById('frequency'+i)){
				if(document.getElementById('frequency'+i).value == '0'){
					alert('Please select frequency.');
					return false;
				  }
				 }
				
	
	             if(document.getElementById('dosage'+i)){
				if(document.getElementById('dosage'+i).value == ''){
					alert('Please Enter dosage.');
					return false;
				 }
				}
			
				//var noOfDays = document.getElementById('noOfDays'+i).value;
			//commented for sos	if(document.getElementById('frequency'+i).value != '13'){
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value == ''){
					alert('Please Enter No. of Days.');
					return false;
				 }
				 }
			/*commented for sos		}else{
					if(document.getElementById('sosQty'+i)){
						if(document.getElementById('sosQty'+i).value == ''){
							alert('Please Enter SOS Qty.');
							return false;
						 }
						 }
				}*/
				if(document.getElementById('noOfDays'+i)){
				if(document.getElementById('noOfDays'+i).value!="")
				{
				if( isNaN(document.getElementById('noOfDays'+i).value))
		    	{
					document.getElementById('noOfDays'+i).value =""; 
		        	alert("No. of Days should be a number");
		        	return false;
		    	 }
				 }
			   }
				
				/*var instructionACPC = document.getElementById('instructionACPC'+i).value;
				if(instructionACPC == ''){
					alert('Please select Intake.');
					return false;
				}
				var typeLeftRight = document.getElementById('typeLeftRight'+i).value;
				if(typeLeftRight == ''){
					alert('Please select Type.');
					return false;
				}
				var remarks = document.getElementById('remarks'+i).value;
				if(remarks == ''){
					alert('Please Enter remarks.');
					return false;
				}*/
			//}
			/*else
			{
				alert("Please Enter Nomenclature");
				return false;
			}*/
			
		 }
		}
		return true;
	}
function switchVisible() {
    if (document.getElementById('Div1')) {

        if (document.getElementById('Div1').style.display == 'none') {
            document.getElementById('Div1').style.display = 'block';
            document.getElementById('Div2').style.display = 'none';
        }
        else {
            document.getElementById('Div1').style.display = 'none';
            document.getElementById('Div2').style.display = 'block';
        }
    }
}


function addRowOtherMedicineForLP() {
	var tbl = document.getElementById('gridForPrescription');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex1').value) + 1;
	document.getElementById('hdbTabIndex1').value = hdbTabIndex;

	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb1 = document.getElementById('hdb1');
	iteration = parseInt(hdb1.value) + 1;
	hdb1.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadios' + iteration;
	e1.id = 'itemRadios' + iteration;
	e1.className = 'radioCheck';
	e1.onchange = function() {
		checkPrescriptionCheckList(iteration);
	};
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'prescription_availableStatus' + iteration;
	e1.id = 'prescription_availableStatus' + iteration;
	e1.className = "textYellow grdTextSmall";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclatures' + iteration;
	e1.id = 'nomenclatures' + iteration;
	e1.className = "textYellow largTextBoxOpd";
	e1.style.width="160px";
	e1.onfocus = function() {
		checkFrequencyList(iteration, "opc");
	}
	e1.onkeypress = function() {
		checkTextColorList('nomenclatures' + iteration);
	};
	e1.onblur = function() {
		checkForAlreadyIssuedPrescribtionList(this.value, iteration);
		populatePVMSList(this.value, iteration);
		checkItemList(iteration);
		copyToPrescriptionTAbList(iteration, 'opconsult');
		ValidateCantraList();
		//displayAuList(this.value, iteration);
		validatePrescriptionAutocompleteList('opmain', this.value, iteration);
		checkForAllergyList(this.value, iteration);
		
	};
	e1.size = '35';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);
	e1.focus();

	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2update1' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclatures' + iteration,
			'ac2update1' + iteration,
			'opd?method=getItemListForAutoCompleteItem', {
				minChars : 3,
				parameters : 'requiredField=nomenclatures' + iteration
			});

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'brandId' + iteration;
	e1.id = 'brandId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'manufactureId' + iteration;
	e1.id = 'manufactureId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNo' + iteration;
	e1.id = 'pvmsNo' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualDispensingQtys' + iteration;
	e1.id = 'actualDispensingQtys' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixable' + iteration;
	e1.id = 'mixable' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureQuantity' + iteration;
	e1.id = 'mixtureQuantity' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureUnit' + iteration;
	e1.id = 'mixtureUnit' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualTotalAfterMix' + iteration;
	e1.id = 'actualTotalAfterMix' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'tapered' + iteration;
	e1.id = 'tapered' + iteration;
	cellRight1.appendChild(e1);
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'routesOut' + iteration;
	e1.id = 'routesOut' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "3";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	e1.onblur = function() {
		fillRouteOnTAbList(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosagesOut' + iteration;
	e1.id = 'dosagesOut' + iteration;
	e1.maxLength = "3";
	e1.className = "textYellow allownumericwithdecimal opdTextBoxTSmall";
	e1.onblur = function() {
		fillValueList(this.value, iteration);
	};
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

/* 	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitOut' + iteration;
	e1.id = 'unitOut' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1); */

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'frequencyValueOut' + iteration;
	e1.id = 'frequencyValueOut' + iteration;
	e1.style.width = "68px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "6";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		
		 var opt = document.createElement('option'); 
		 	opt.id = icdArray[i][2];
		 	opt.value = icdArray[i][0];
		    opt.innerHTML = icdArray[i][1];
		    e1.appendChild(opt);
	}
	e1.onblur = function() {
		getFrequencyValueList(this.value, iteration);
		fillValueList(this.value, iteration);
		displaySOSQtyList(this.value, iteration);	
		
	};
	
	e1.onchange = function() { 
		displaFrequencyTypeList(this, iteration);	
	};
	
	cellRight1.appendChild(e1);
	
	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQtyout' + iteration;
	e21.id = 'sosQtyout' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValueOut' + iteration;
	e21.id = 'frequencyValueOut' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(5);
	
	var e21Div = document.createElement('div');
	e21Div.style = 'width:60px; float: left;';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.maxLength = "3";
	e1.name = 'noOfDaysOut' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.id = 'noOfDaysOut' + iteration;
	e1.size = '3';
	e1.maxLength = "3";
	e1.tabIndex = hdbTabIndex + "7";
	e1.onblur = function() {
		fillValueDay(iteration);
		fillValueList(this.value, iteration);
	};
	e1.onkeypress=function(event){
		return isNumberOnly(event);
	};
	e21Div.appendChild(e1);
	
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyTypeOut' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'instrunctionOut' + iteration;
	e1.id = 'instrunctionOut' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "8";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionArray.length; i++) {
		e1.options[i + 1] = new Option(instructionArray[i][1],
				instructionArray[i][0]);
	}
	e1.onblur = function() {
		fillInstrunctionOnTAbs(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'splInstrunctionsOut' + iteration;
	e1.id = 'splInstrunctionsOut' + iteration;
	e1.tabIndex = hdbTabIndex + "9";
	e1.style.width='80px';
	e1.className = "textYellow opdTextBoxSmall";
	e1.onblur = function() {
		fillSPLInstrunctionOnPTAb(iteration);
	};
	e1.maxLength = "200";
	cellRight1.appendChild(e1);


	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'total' + iteration;
	e1.id = 'total' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);
/* 	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'total' + iteration;
	e1.id = 'total' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1); */

/* 	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitLables' + iteration;
	e1.id = 'unitLables' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1); */
	
}

function removeRowMedicineForLP(){
var tbl = document.getElementById('grid');
var lastRow = tbl.rows.length;
var hdb = document.getElementById('hdb');
var iteration = parseInt(hdb.value);
var totalSelected = 0;

if (confirm("Do you want to delete !")) {
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("itemRadio" + i) != null
				&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
				&& document.getElementById("itemRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}

	if (totalSelected == 0) {
		if (from != 'opc')
			alert('Please select atleast 1 row to delete');
	}
	/*
	 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
	 * not delete all Row.'); } else if (lastRow > 2){
	 */
	var flag = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("itemRadio" + i) != null
				&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
				&& document.getElementById("itemRadio" + i).checked) {
			jQuery(function($) {
				if (document.getElementById("parkPrescriptionIds" + i) != null) {
					var ids = document.getElementById("parkPrescriptionIds"
							+ i).value;
					if (ids != "" && ids != "0") {
						$.post('opd?method=deleteOPDdetails&ids=' + ids
								+ "&for=" + "prc" + "&" + csrfTokenName
								+ "=" + csrfTokenValue, function(data) {
							try {
								flag = 1;
								msgFlag = data;
							} catch (e) {
								alert(e);
							}
						});
					}
				}
			});

			var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
			document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
					.removeChild(deleteRow);
		}
	}
}
}

function removeRowOtherMedicineForLP(){
	var tbl = document.getElementById('gridForPrescription');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdb1');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;

	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadios" + i) != null
					&& (typeof document.getElementById("itemRadios" + i).checked) != 'undefined'
					&& document.getElementById("itemRadios" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		var flag = 0;
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadios" + i) != null
					&& (typeof document.getElementById("itemRadios" + i).checked) != 'undefined'
					&& document.getElementById("itemRadios" + i).checked) {
				jQuery(function($) {
					if (document.getElementById("parkPrescriptionIds" + i) != null) {
						var ids = document.getElementById("parkPrescriptionIds"
								+ i).value;
						if (ids != "" && ids != "0") {
							$.post('opd?method=deleteOPDdetails&ids=' + ids
									+ "&for=" + "prc" + "&" + csrfTokenName
									+ "=" + csrfTokenValue, function(data) {
								try {
									flag = 1;
									msgFlag = data;
								} catch (e) {
									alert(e);
								}
							});
						}
					}
				});

				var deleteRow = document.getElementById("itemRadios" + i).parentNode.parentNode;
				document.getElementById("itemRadios" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
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

function displaFrequencyTypeForLP(i, incr) {
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyType' + incr).innerHTML = frequencyType;

if(i.options[i.selectedIndex].text=="STAT"){
	document.getElementById('noOfDays'+incr).readOnly=true;
	document.getElementById('noOfDays'+incr).value = "1";}
else
	document.getElementById('noOfDays'+incr).readOnly=false;


}
</script>


</div>

</form>
<style>
.tabeLeftDiv {width:690px; float:left;}

.tabContWidth5 {width:205px; margin-right:5px; float:left;}
.tabContWidth5 label{width:187px; background:none;box-shadow:none; margin:0px 0px 0px 4px; text-align:center; background:#ffd966;}
.tabContWidth5 textarea { width:188px; margin-left:4px;overflow-x:hidden;resize:vertical;height: 58px;
<%if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))){%>
height:100px;
<%}%>
}


.tabContWidth3 {width:384px; margin-right:5px; float:left;}
.tabContWidth3 label{width:375px; background:none;box-shadow:none; margin:0px 0px 0px 4px; background:#ffd966;}
.tabContWidth3 textarea { width:376px;height:35px; margin-left:4px;overflow-x:hidden;resize:vertical;}

.tabContWidth2 {width:579px; margin-right:5px; float:left;}
.tabContWidth2 label{width:570px; background:none;box-shadow:none; margin:0px 0px 0px 4px; background:#ffd966;}
.tabContWidth2 textarea { width:571px ;height:35px; margin-left:4px;overflow-x:hidden;resize:vertical;}


.preDivLeft{width:555px; float:left;}
.preDivLeft label{width:auto; background:none;box-shadow:none;margin:0px; height:22px;}
.vitalsDivRight{width:613px; float:left;}
.plusTabeDiv {width:120px; float:left;margin-top:4px; }
.plusHideDiv{width:529px; float:left;}

</style>



