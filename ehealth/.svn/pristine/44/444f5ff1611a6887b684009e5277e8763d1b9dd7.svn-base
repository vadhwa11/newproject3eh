<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.DepartmentRefset"%>
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
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OtPreAnesthesiaDetails"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd_LP.js"></script>
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
<link rel="stylesheet" type="text/css"
	href="/hms/jsp/css/multiselect.css">

<script>

jQuery.noConflict();
jQuery(function($) {

	function split(val) {
		return val.split(/,\s*/);
	}
	function extractLast(term) {
		return split(term).pop();
	}

	$( ".historyAutoComplete" )
    .autocomplete({
	    //minLength: 3,
	    search: function() {
	        // custom minLength
	        var term = extractLast( this.value );
	        if ( term.length < 3 ) {
	            return false;
	        }
	    },
	    focus: function() {
            // prevent value inserted on focus
            return false;
        },
		source: function( request, response) {
            // delegate back to autocomplete, but extract the last term
			var arTerm=request.term.split(",");
			var searchTerm=arTerm[arTerm.length-1].trim();
			console.log("terms :: "+searchTerm);
			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
		 // var refsetidParam = document.getElementById('refsetId').value;
		//	var fieldType =	this.element;
			var fieldType = $(this.element).prev().text().replace(/\s+/g," ");
			
			
			//servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
			
			servURL +="?term="+searchTerm+"&state=active&acceptability=all&returnlimit=10&refsetid=null";
			
			if(fieldType=='Provisional Diagnosis' || fieldType=='Final Diagnosis' ){
				servURL +="&semantictag=disorder";
			}else{
				servURL +="&semantictag=all";
			}
			
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
           // var fieldType = $(this).prev().text().replace(/\s+/g," ");
            var fieldType = $(this).attr('validate').split(',')[0];
            console.log('validate = '+fieldType);
       		
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
       			
       			if(document.getElementById("diagnosis_status").value!="" &&document.getElementById("diagnosis_status").value!=diagnosis_status){	
       					//document.getElementById(removeDiagnosisId).value='';
   						console.log("succes");
   			           //	$("#diagnosisId option").remove();
   				}
       		  document.getElementById("diagnosis_status").value=diagnosis_status;
       			
       		//  getICDListBasedOnSnomedId(ui.item.label, diagnosis_status);
       		 this.value = terms.join( "," );
       		
       		}
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
    });
});

function calculateBMI() {
	var height = document.getElementById("height").value;
	var weight = document.getElementById("weight").value;
	document.getElementById("bmi").value = "";
	if(height != null && weight != null && height != "" && weight != "") {
		var height = 	parseFloat(height)/100;
		document.getElementById("bmiValue").value = ((weight/(height*height)).toFixed(2));
		document.getElementById("bmi").innerHTML = document.getElementById("bmiValue").value;
		bmiCat();
	}
	else
		{
		document.getElementById("bmi").innerHTML="";
		document.getElementById("bmiCat").innerHTML="";
		}

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
		}else if(bmicat>=18.5 && bmicat<23){
			document.getElementById("bmiCat").innerHTML = "Healthy Range" ;	
			document.getElementById("bmiCat").style.color = 'green';
			document.getElementById("bmi").style.color = 'green';
		}else if(bmicat>=23 && bmicat<=30){
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
<script>
    function showhide(buttonId)
     {
		 if(buttonId=="button1"){
					test(buttonId,"newpost1");
		 }
		 else if(buttonId=="button2"){
					test(buttonId,"newpost2");
		 }else if(buttonId=="button3"){
					test('realted'+buttonId,"newpost3");
		 }else if(buttonId=="button8"){
					test('realted'+buttonId,"newpost8");
		 }else if(buttonId=="button9"){
					test('realted'+buttonId,"newpost9");
		 }
	 }
    
	function test(buttonId,newpost){
			 var x = document.getElementById(newpost);
				if (x.style.display != "block") {
					x.style.display = "block";
					document.getElementById(buttonId).value="-";
				}else {
					x.style.display = "none";
					document.getElementById(buttonId).value="+";
				}	 
	}
	   var icdArray=new Array();
	   var icdArray1=new Array();
	   var brandArray=new Array();
	   var allergyTypeArray=new Array();
	   var saverityCodeArray=new Array();
	   
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
		int opCallCount = 0;
		long memberId=0l;
		if(map.get("memberId")!=null){
			memberId = (Long)map.get("memberId");
			}
			String ncdPatient="t1";
		if(map.get("ncdPatient")!=null){
			ncdPatient = (String)map.get("ncdPatient");
			}
		String rntcpPatient="";
		if(map.get("rntcpPatient")!=null){
			rntcpPatient = (String)map.get("rntcpPatient");
			}
		String immunization_status="false";
		if(map.get("immunization_status")!=null){
			immunization_status = (String)map.get("immunization_status");
			}
		String chkFpisList="";
		if(map.get("chkFpisList") != null)
		{
			chkFpisList=(String)map.get("chkFpisList");
		}
		  List<Object[]>diseaseScreening=new ArrayList<Object[]>();
		    if(map.get("diseaseScreening")!=null){
		    	diseaseScreening=(List<Object[]>)map.get("diseaseScreening");
		    }
		    List<String>familyHistory=new ArrayList<String>(); 
		    String disease="";
		    String relation="";
		    for (Object[] phd : diseaseScreening) {
		    	if(phd[29]!=null && phd[28]!=null){
		    	disease= phd[29].toString()+"--"+phd[28].toString();
		    	familyHistory.add(disease);
		    	}
		    	
			}
		    
		List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
		List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
		
		List<OpdPatientSecondOpinion> secondpoinionList=new ArrayList<OpdPatientSecondOpinion>();
		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>();  
		List<PhProbablePregnancy> phProbablePregnancyList = new ArrayList<PhProbablePregnancy>();
		List<Object[]> fixedInvestigationList = null;
		
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
		
		if(map.get("fixedInvestigationList") != null){
			fixedInvestigationList=(List<Object[]>)map.get("fixedInvestigationList");
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
		
		List<DepartmentRefset> deptRefsetList = null;
		if(map.get("deptRefsetList")!=null){
			deptRefsetList = (List<DepartmentRefset>)map.get("deptRefsetList");
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
		String deptNameDoctorName="";
		int deptNameDoctorId=0;
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
			deptNameDoctorId = opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getId():0;
			deptNameDoctorName = opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getEmployeeName():"";
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
		Set<Integer> availStockItemIdSet = new HashSet<Integer>();
		if(map.get("availStockItemIdSet") != null)
		{
			availStockItemIdSet=(Set<Integer>)map.get("availStockItemIdSet");
		}
		Set<Integer>availableInvesStatus=new HashSet<Integer>();
		if(map.get("availableInvesStatus") != null)
		{
			availableInvesStatus=(Set<Integer>)map.get("availableInvesStatus");
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
	  	String comorbidityHistory="";
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
			}else if(bmi>=18.5 && bmi<23){
				 bmiStatus="Healthy Range";
			}else if(bmi>=23 && bmi<=30){
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
	  		comorbidityHistory=preOpdPatientHistory.getComorbidityHistory()!=null?preOpdPatientHistory.getComorbidityHistory().replace(",", "\n"):"";
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
	  				personalPresentHistoryMember=phMs.getTobaccoUse()!=null?"Tobacco Use--"+phMs.getTobaccoUse()+"":"";
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
		float weightNcd=0f;
		float hightNcd=0f;
		String ncdType="";
		if(map.get("weightNcd")!=null)
	    {
			weightNcd =Float.parseFloat((String)map.get("weightNcd"));
	    } 
		if(map.get("hightNcd")!=null)
	    {
			hightNcd = Float.parseFloat((String)map.get("hightNcd"));
	    } 
		if(map.get("ncdType")!=null)
	    {
			ncdType =(String)map.get("ncdType");
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
		
		if(visit!=null && visit.getOpCallCount()!= null){
			opCallCount=visit.getOpCallCount();
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
		String previousDiagnosis = null;
		String preProcedure = "";
		String preComplain = "";
		String procedureDone = "";
		String opdRemarks = "";
		
		String medicationHistoryStr="";
		String personalHistoryStr="";
		String familyHistoryStr="";
		String pastHistoryStr="";
		
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
		/* history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>"; */
		history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"\n";
		if(patientHistory[27] != null && !patientHistory[27].equals("")){
			/* history += "Personal History--"+(String)patientHistory[2]+"<div class='clear'></div>"; */
			history += "Personal History--"+(String)patientHistory[27]+"\n";
			personalHistoryStr=HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"\n"+(String)patientHistory[27]+"\n";
		}
		if(patientHistory[3] != null && !patientHistory[3].equals("")){
			/* history += "Family History--"+(String)patientHistory[3]+"<div class='clear'></div>"; */
			history += "Family History--"+(String)patientHistory[3]+"\n";
			familyHistoryStr=HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"\n"+(String)patientHistory[3]+"\n";
		}
		if(patientHistory[4] != null && !patientHistory[4].equals("")){
			/* history += "Medication History--"+(String)patientHistory[4]+"<div class='clear'></div>"; */
			history += "Medication History--"+(String)patientHistory[4]+"\n";
			medicationHistoryStr=HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"\n"+(String)patientHistory[4]+"\n";
		}
		if(patientHistory[5] != null && !patientHistory[5].equals("")){
			/* history += "History of Past Illness--"+(String)patientHistory[5]+"<div class='clear'></div>"; */
			history += "History of Past Illness--"+(String)patientHistory[5]+"\n";
			pastHistoryStr=HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"\n"+(String)patientHistory[5]+"\n";
		}
		if(patientHistory[6] != null && !patientHistory[6].equals("")){
			/* history += "History of Menstrual and Obstetric--"+(String)patientHistory[6]+"<div class='clear'></div>"; */
			history += "History of Menstrual and Obstetric--"+(String)patientHistory[6]+"\n";
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
			/* history += "History of Development--"+(String)patientHistory[23]+"<div class='clear'></div>"; */
			history += "History of Development--"+(String)patientHistory[23]+"\n";
		}
		
		if(patientHistory[24] != null && !patientHistory[24].equals("")){
			/* history += "History of Diet--"+(String)patientHistory[24]+"<div class='clear'></div>"; */
			history += "History of Diet--"+(String)patientHistory[24]+"\n";
		}
		
		if(patientHistory[26] != null && !patientHistory[26].equals("")){
			comorbidityStr  = (String)patientHistory[26];
		}
		 
	 if(patientHistory[28]!=null && !patientHistory[28].equals("")){
			previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"":HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"";
			 previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+patientHistory[30]+"":patientHistory[30]+""; 
			previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[P] "+patientHistory[28].toString():patientHistory[28].toString();
		}
 	if(patientHistory[29]!=null){
		previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"":HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"";
	 	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+patientHistory[30]+"":patientHistory[30]+""; 
		previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[F] "+patientHistory[29].toString():patientHistory[29].toString();
	}
	if(patientHistory[18]!=null){
		previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"":HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"";
		previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+patientHistory[30]+"":patientHistory[30]+""; 
		previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[O] "+patientHistory[18].toString():patientHistory[30].toString();
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
/* if(opdPatientDetails!=null && opdPatientDetails.getProvisionalDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)&& opdPatientDetails.getProvisionalDiagnosis()!=null && !opdPatientDetails.getProvisionalDiagnosis().equals("") && !opdPatientDetails.getProvisionalDiagnosis().equals(" ")){
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"":HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"":opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[P] "+opdPatientDetails.getProvisionalDiagnosis().trim():opdPatientDetails.getProvisionalDiagnosis().trim();
}
if(opdPatientDetails!=null && opdPatientDetails.getFinalDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId) && opdPatientDetails.getFinalDiagnosis()!=null && !opdPatientDetails.getFinalDiagnosis().equals("") && !opdPatientDetails.getFinalDiagnosis().equals(" ")){
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"":HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"":opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[F] "+opdPatientDetails.getFinalDiagnosis().trim():opdPatientDetails.getFinalDiagnosis().trim();
}
if(opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId) && opdPatientDetails.getInitialDiagnosis()!=null && !"".equals(opdPatientDetails.getInitialDiagnosis())){
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"\n"+HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"":HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getConsultationDate())+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":"+opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"":opdPatientDetails.getVisit().getDepartment().getDepartmentName()+"";
	previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+":[O] "+opdPatientDetails.getInitialDiagnosis().trim():opdPatientDetails.getInitialDiagnosis().trim();
} */

if(previousProcedureList.size()>0){
	for(Object[] proc :previousProcedureList){
		Date visitDate = (Date)proc[0];
		preProcedure += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
		if(proc[1] != null && !proc[1].equals("")){
			preProcedure +="Procedure--"+ (String)proc[1]+"<div class='clear'></div>";
		}
		
	}}

/* Srikanth Start */
Visit lastVisit=new Visit();
if(map.get("previousVisit")!=null){
	lastVisit=(Visit)map.get("previousVisit");
}
OpdSurgeryHeader surgeryHdr=new OpdSurgeryHeader();
if(map.get("opdSurgeryHdr")!=null){
	surgeryHdr=(OpdSurgeryHeader)map.get("opdSurgeryHdr");
}

OpdSurgeryDetail surgeryDetail=new OpdSurgeryDetail();
if(map.get("opdSurgeryDtl")!=null){
	surgeryDetail=(OpdSurgeryDetail)map.get("opdSurgeryDtl");
}
OtPreAnesthesiaDetails otPreAnesthesiaDetails=new OtPreAnesthesiaDetails();
if(map.get("otPreAnesthesiaDetails")!=null){
	otPreAnesthesiaDetails=(OtPreAnesthesiaDetails)map.get("otPreAnesthesiaDetails");
}	
/* Srikanth End */
		
  %>
  
  <script type="text/javascript">
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
	}
 
  </script>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<!-- =====Inner Tab start here===== -->

<div class="inTab">
  <!-- <div class="tablinks inActive" onclick="javascript:openCity(event, 'inTab1')">OP Consultation</div>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab10')">Know Your Patient</div>
 -->
	<%-- <%if(visit!=null && visit.getVisitNo()>1) {%>
	<div class="tablinks" onclick="javascript:openCity(event, 'inTab1')">OP Consultation</div>
  <div class="tablinks inActive" onclick="javascript:openCity(event, 'inTab10')">Know Your Patient</div>
  <%}else{ %> --%>
<%if(visit!=null && visit.getVisitNo()>1) {%>
	<div class="tablinks" onclick="javascript:openCity(event, 'inTab1')">OP Consultation</div>
  <div class="tablinks inActive" onclick="javascript:openCity(event, 'inTab10')">Know Your Patient</div>
  <%}else{ %>
    <div class="tablinks inActive" onclick="javascript:openCity(event, 'inTab1')">OP Consultation</div>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab10')">Know Your Patient</div>
  <%} %>
<%--   <%} %> --%>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab3');display('37','History','OP');">Patient History</div>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab8');display('37','Allergy','OP');">Allergy</div>
<%--  <%if(ncdPatient.equals("true")){%>
<div class="tablinks blink_me" style="background:#ec7028;color:#000;" onclick="javascript:openCity(event, 'inTab9');display('37','NCDClinic','OP');">NCD Clinic</div>
<%}else{%>
<div class="tablinks" onclick="javascript:openCity(event, 'inTab9');display('37','NCDClinic','OP');">NCD Clinic</div>
<%} %> --%>
 <%-- <%if(chkFpisList.equals("true")){%>
<div class="tablinks" style="color: red;" onclick="javascript:openCity(event, 'inTab13');display('37','FPISDetail','OP');">FPIS Detail</div>
<%}else{%>
<div class="tablinks" onclick="javascript:openCity(event, 'inTab13');display('37','FPISDetail','OP');">FPIS Detail</div>
<%} %> --%>
 <div class="tablinks" onclick="javascript:openCity(event, 'inTab12');display('37','LabResult','OP');">Lab Results</div>
   
  <% if(opdPatientDetails!= null  && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){%>
			<div class="tablinks"  id="mlcTab" onclick="javascript:openCity(event, 'inTab2')" >MLC</div> 
		<%}else if(patientWiseMlcs.size()>0){ %>
			<div class="tablinks"  id="mlcTab" onclick="javascript:openCity(event, 'inTab2')" >MLC</div> 
		<%} else{%>
			<div class="tablinks"  id="mlcTab" onclick="javascript:openCity(event, 'inTab2')" style="display: none;">MLC</div> 
		<%} %>
</div>
<!-- Drop Down menu Button Star -->
<div class="dropDownMainDiv">
<%if(ncdPatient.equals("true") || rntcpPatient.equals("true")||(immunization_status.equalsIgnoreCase("true") && patientAge<=18) ){%>
<button class="dropDwnbuttn blink_me" style="background:#ec7028;color:#000;">Health Condition</button>
<%}else{%>
  <button class="dropDwnbuttn">Health Condition</button>
  <%} %>
  <div class="dropDownContent">
  <%if(ncdPatient.equals("true") ){%>
    <a class="dropDwnbuttn blink_me" style="background:#ec7028;color:#000;" href="javascript:openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');">NCD Clinic</a>
    <%}else{%>
     <a  href="javascript:openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');">NCD Clinic</a>
    <%} %>
   <!--  <a href="#">ANC</a> -->
    
     <%if(rntcpPatient.equals("true") ){%>
    <a class="dropDwnbuttn blink_me" style="background:#ec7028;color:#000;" href="javascript:openPopupWindowRNTCPDetail(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>','<%=visit.getId()%>');">RNTCP</a>
    <%}else{%>
     <a href="javascript:openPopupWindowRNTCPDetail(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>','<%=visit.getId()%>');">RNTCP</a>
    <%} %>
    <%if(patientAge<=18){ %>
     <%if(immunization_status.equals("true") ){%>
    <a class="dropDwnbuttn blink_me" style="background:#ec7028;color:#000;" href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>&hinId=<%=visit.getHin().getId()%>&csrfTokenName=csrfTokenValue');">Immunizations</a>
    <%}else{%>
    <a href="javascript:popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>&hinId=<%=visit.getHin().getId()%>&csrfTokenName=csrfTokenValue');">Immunizations</a>
     <%}} %>
  </div>
</div>
<!-- Drop Down menu Button end -->

<form name="opdMain" action="" method="post" id="opdMain">
<input type="hidden" id="fromTemplate" name="fromTemplate" value="opConsultationLite">
<div id="inTab1" class="inTabcontent" style="display:block;">
<div class="clear"></div>
<div class="Block" style="padding-top:0;">
	<div style="width:200px; float: left;">
		<label style="vertical-align: baseline;"><img
			src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Data is part of EHR</span></label>
	</div>


<div class="mgmtDivMain">	
			<%-- <input name="" id="" class="buttonAuto" value="Patient History" onclick="showPatientHistory('<%=visit.getHin().getHinNo() %>',csrfTokenName+'='+csrfTokenValue)"
				type="button">  --%>
			<!-- <input name="" id="" class="buttonAuto" onclick="openPopupWindowAllergy(csrfTokenName+'='+csrfTokenValue+'&LP=y');"
				value="Allergy" type="button">  -->
					<%-- <%if(patientAge<=18){%>
				<input tabindex="1" name="" id="" onclick="popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>');"
				class="buttonAuto" value="Immunisation" type="button">
				<%}else{%>
				<!-- <li><a href="">Immunization</a></li> -->
	             <%}%> --%>
			<input name="" id="" onclick="popwindowResultEntry('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>');"
				class="buttonAuto" value="Result Entry" type="button" tabindex="1"> 
			<%-- <input onclick="openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>');"
				name="" id="" class="buttonAuto" value="Lab Results" type="button"> --%>
			<input name="" id="" class="buttonAuto" onclick="showParkPatient('p');"
				value="List of Parked Patients" type="button" tabindex="1"> 
			<%-- <input onclick="openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');"
				name="" id="" class="buttonAuto" value="NCD Clinic" type="button"> --%>
			<input name="" id="" class="buttonAuto" value="Upload Document" onclick="popwindowUploadDocuments('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue);"
				type="button" tabindex="1">
				<%-- <%
					if(deptRefsetList!=null){
					if(deptRefsetList.size() > 0){
					%>
					<label class="auto">Refset </label>
					<select name="refsetId" id="refsetId">
						<option value="null">Select</option>
						<%for(DepartmentRefset deptRefset : deptRefsetList){ %>
						<option value="<%=deptRefset.getRefsetId()%>"><%=deptRefset.getRefsetDesc() %></option>
						<%} %>
					</select>
					<%} else{
					%>
					<input type="hidden" name="refsetId" id="refsetId" value="null">
					<%} }else{%>
					<input type="hidden" name="refsetId" id="refsetId" value="null">
							<%} %>	 --%>				

</div>
	<div class="floatRight" style="margin-right:15px;">
	<%if(opdPatientDetails!= null && opdPatientDetails.getMlcType() != null && opdPatientDetails.getMlcType().equalsIgnoreCase("y")){ %>
	<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()" tabindex="1"/>MLC</label>
	<%}else if(patientWiseMlcs.size()>0){ %>
	<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" checked="checked" class="radioCheckCol2" onchange="fnShowHideMLCTab()" tabindex="1"/>MLC</label>
	<%}else{  %>
	<label class="autoSpace "><input type="checkbox" id="mlcCheck" name="mlcCheck" class="radioCheckCol2" onchange="fnShowHideMLCTab()" tabindex="1"/>MLC</label>
	<%} %>
	</div>

	<div class="clear"></div>
	<div class="clear"></div>

	<div
		style="float: left; width: 1170px; padding-top: 1px; background: #c5c4c4;">
		<div class="titleBg" style="width: 156px; float: left;">
			<h2 class="h2Text" style="padding: 3px 0px 0px 0px;">PATIENT
				DETAILS:</h2>
		</div>
		<label class="auto" style="background: none; box-shadow: none;">Patient Name</label> 
		<label class="value" style="background: #bdd6ee; box-shadow: none;"><%=patientName%></label>

		
		<label class="auto" style="background: none; box-shadow: none;">UHID</label>
		<label class="value" style="background: none; box-shadow: none;"><%=uhid%></label>

		<label class="auto" style="background: none; box-shadow: none;">Age</label>
		<label class="value" style="background: none; box-shadow: none;"><%=yearMonth %></label>

		<label class="auto" style="background: none; box-shadow: none;">Gender</label>
		<label class="value"
			style="width: 75px; background: none; box-shadow: none;"><%=gender%></label>
		<label class="auto" style="background:none; box-shadow:none;">Token No</label>
        <label class="value" style="width:75px; background:none; box-shadow:none;"><%=visit.getTokenNo()%></label>	
	</div>

	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>	
	<div class="clear"></div>

<div style="width:888px; float:left;">	
<h4 style="float:left; width:170px;">Patient Episode Details</h4>

<label>Select Past Episode
<input type="radio" name="episodeCheck" id="episodeIdPast" onclick="showPastEpisodeDiv();" class="episodeSelect checkboxMargin" title="Select Past Episode" tabindex="1">
</label>
<label>Create New Episode
<input type="radio" name="episodeCheck" id="episodeIdNew" checked="checked" class="episodeSelect checkboxMargin"  onclick="hidePastEpisodeDiv();" maxlength="100" validate="Create New Episode,metacharDot,no"  tabindex="1"> 
</label>
<div class="" style="display: none;" id="pastEpisodeDiv"> 
					<label>Past Episodes</label>
					 <select name="episodeList"	id="episodeList" size="1" onclick="getEpisodeDetail(this,'outpatient');">
					 	<option value="0">Select</option>
					 	<% for(PatientEpisode patientEpisode : patientEpisodeList) { %>
					 	<%if(patientEpisode.getEpisodeName()!=null){%>
					 		<option value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)<%=patientEpisode.getEpisodeName()%></option>
					 	<% } else{%>
					 		<option value="<%=patientEpisode.getId()%>"><%=patientEpisode.getEpisodeNumber()%></option>
					 	<%}} %>
					 </select>
					 </div>					 
					 <div class="" id="EpisodeNameDiv">
						 <label>Episode Name</label>
					 	<input name="episodeName" id="episodeName" type="text" value="" tabindex="1">
					 </div>	
					 	
					<div id="patientEpisodeDetail"></div>					
					<input type="hidden" id="episodeId" name="episodeId" value="0"> 

</div>	
					
<label class="auto">Close Episode
<input type="checkbox" tabindex="1" id="episodeCloseCheck" name="episodeCloseCheck" class="episodeSelect checkboxMargin" value="true" >
</label>

<div class="historyTxtDiv">
<a href="#" onclick="showhide(this.id)" id="button1" tabindex="1" style="color:#0f75bf;font-size:14px;">HISTORY</a>
</div>
<input name="request" id="requestId" type="hidden" value="<%=visit.getHin().getId()%>" />

<div class="hisDivHide" id="newpost1">
<div class="clear"></div> 
<div class="divisionSolid"></div>
<div class="clear"></div>  
		<div class="tabContWidth6">
			<label>Past History</label>
			<textarea class="historyAutoComplete" 
						name="pastIllness" id="pastIllness" cols="0" rows="0" maxlength="300" validate="Past History,string,no"
						 tabindex="6"><%=opdPatientHistoriesStr %></textarea>
		</div>
		<div class="tabContWidth6">
					<label>Personal History</label>
					<% if(!personalPresentHistory.equals("")){%>
					<textarea class="historyAutoComplete" style="font-weight:bold; font-style:italic;"
						name="personalHistory" id="personalHistory" cols="0" rows="0" maxlength="300" validate="Personal History,string,no"
						 tabindex="6"><%=personalPresentHistory %></textarea>
					<%}else if(!personalPresentHistoryMember.equals("")){%>
						 <textarea class="historyAutoComplete"
						name="personalHistory" id="personalHistory" cols="0" rows="0" maxlength="300" validate="Personal History,string,no"
						 tabindex="6" style="color:green;"><%=personalPresentHistoryMember %></textarea>
						 <%}else{%>
						  <textarea class="historyAutoComplete"
						name="personalHistory" id="personalHistory" cols="0" rows="0" maxlength="300" validate="Personal History,string,no"
						 tabindex="6"></textarea>
		<%} %>	 	
		</div>
		<div class="tabContWidth6">
			<label>Family History</label>
			<%if(familyPastHistory!=""){%>
			<textarea class="historyAutoComplete"
						name="familyHistory" validate="Family History,string,no"
						id="familyHistory" cols="0" rows="0" maxlength="300" tabindex="8"><%=familyPastHistory %></textarea>
						<%}else if(familyHistory.size()>0){%>
						 <textarea class="historyAutoComplete"
						name="familyHistory" validate="Family History,string,no"
						id="familyHistory" cols="0" rows="0" maxlength="300" tabindex="1" style="color:green;"> <%=familyHistory %></textarea>
						<%}else{%>
						<textarea class="historyAutoComplete"
						name="familyHistory" validate="Family History,string,no"
						id="familyHistory" cols="0" rows="0" maxlength="300" tabindex="8"></textarea>
						<%} %>
		</div>
		<div class="tabContWidth6">
			<label>Medication History</label>
			<textarea class="historyAutoComplete"
						name="medicationhistory" validate="Medication History,string,no"
						id="medicationhistory" cols="0" rows="0" maxlength="300"
						tabindex="10"><%=madicationHistory!=null?madicationHistory:"" %></textarea>
		</div>
		<div class="tabContWidth6"  style="width: 330px;">
			<div>
				<label style="width: 321px;"> <span style="float:left;color: black;">Allergies</span> 
				<span style="float:right;"><input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowForOpdLiteAllergy();"></span>
				</label>	
			</div>
					<div class="clear"></div>
						<div id="divTemplet" style="width:323px; height:61px; margin-left:5px; overflow:auto; overflow-x:hidden;">
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
			//allergyStr=allergyName+","+allergyStr;
			masSeverityCodePark=opdPatientAllergyT.getSeverity();
			allergyyear=opdPatientAllergyT.getFromYear();
			allergymonth=opdPatientAllergyT.getFromMonth();
			allergyHeaderId=opdPatientAllergyT.getOpdPatientAllergy().getId();
			allergyDetailId=opdPatientAllergyT.getId();
			allergyRemarks = opdPatientAllergyT.getAllergyRemarks();
		}		
	%>
								<tr>
									<td>
									<%-- 
									<input type="checkbox" class="radioCheck"
										name="allergyRadio<%=incr%>" id="allergyRadio<%=incr%>" />  --%>
									<input class="delButSmll allergy" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'allergy');"> 	
									<input
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
										tabindex="1" validate="Allergy,string,no"
										value="<%=allergyName!=null && !allergyName.equals("")?allergyName:"" %>"
										id="allergyName<%=incr%>" size="35"
										name="allergyName<%=incr%>" style="width: 68px;"" /> <div id="allergy_ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
					 new Ajax.Autocompleter('allergyName<%=incr%>','allergy_ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItemAllergy',{minChars:3,
					 callback: function(element, entry) {
				            return entry + '&allergyTypeCheck=' + document.getElementById('allergyType<%=incr%>').value;
				      },parameters:'requiredField=allergyName<%=incr%>'});
		</script> --%></td>
							<%-- 		<td><select style="background: #FFFF99"
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
									</select></td> --%>
									<td><input  name="allergy_remarks<%=incr%>" style="width: 97px;background: #FFFF99;" maxlength="30" value="<%=allergyRemarks!=null && !allergyRemarks.equals("")?allergyRemarks.trim():"" %>"/></td>
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
		<div class="tabContWidth6">
			<label>Comorbidity</label>
			<%if(!comorbidityStr.equals("")){ %>
			<textarea name="comorbidityHistoryFromSnomed" class="historyAutoComplete"
				id="comorbidityFromSnomed" validate="Comorbidity,string,no"
				 cols="0" rows="0" maxlength="300"
				onkeyup="return checkLength(this)"><%=comorbidityStr%></textarea>
				<%}else{ %>
				<textarea name="comorbidityHistoryFromSnomed" class="historyAutoComplete"
				id="comorbidityFromSnomed" validate="Comorbidity,string,no"
				 cols="0" rows="0" maxlength="300"
				onkeyup="return checkLength(this)" style="color:green;"><%=majorHealthIssue%></textarea>
				<%} %>
		</div>
	</div>

	<div class="clear"></div>
	<div class="divisionSolid"></div>
	<div class="clear"></div>

	<div class="preDivLeft">
		<p style="margin:4px 0px 4px 5px;">Presenting Complaints & History of Presenting Illness</p>
		<div class="clear"></div>
<%if(ncdType!=""){if(ncdType.equalsIgnoreCase("ncdcli")){%>
<textarea class="historyAutoComplete" name="presentComplain" id="presentComplain" cols="0" rows="0"
maxlength="300" validate="Presenting Complaints & History of Presenting Illness,string,no" tabindex="1" style="color:green;">"Referred from NCD clinic for suspected NCD"</textarea>

<%}else if(ncdType.equalsIgnoreCase("ncdout")){ %>
<textarea class="historyAutoComplete" name="presentComplain" id="presentComplain" cols="0" rows="0"
maxlength="300" validate="Presenting Complaints & History of Presenting Illness,string,no" tabindex="1" style="color:green;">"Referred from NCD camp for suspected NCD"</textarea>
<%}} else{%>
<textarea class="historyAutoComplete" name="presentComplain" id="presentComplain" cols="0" rows="0"
maxlength="300" validate="Presenting Complaints & History of Presenting Illness,string,no" tabindex="1"><%=opdPatientDetails!=null?presentComplaintHistory:""%></textarea>
<%} %>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<p>Clinical Findings</p>
		<div class="clear"></div>
		<textarea class="historyAutoComplete" tabindex="1" name="clinicalFindings" id="clinicalFindings" validate="Clinical findings,string,no" cols="0" rows="0" maxlength="300"><%=(opdPatientDetails!=null && opdPatientDetails.getClinicalFindings()!=null)?opdPatientDetails.getClinicalFindings().trim():""%></textarea>
	</div>
	<div class="vitalsDivRight">
		<div class="titleBg">
			<h2 class="h2Text">VITALS</h2>
		</div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>

		<table
			style="width: 550px; border-top: 1px solid #C0C0C0; float: left;">
			<tr>
				<td><label class="smallAuto">&nbsp;T:&nbsp;</label> <input
					class="allownumericwithdecimal textSmall" name="temperature"
					id="temperature" type="text" maxlength="4"
					validate="temperature,float,no" style="width: 50px;"
					value="<%=temperature>0f?temperature:"" %>" tabindex="1"
					onblur="setVitalValue(this.value,'temperatureTemp')" /> <label
					class="smallAuto">&nbsp;&deg;F&nbsp;</label></td>
				<td><label class="smallAuto">BP:</label> <input name="systolic"
					id="systolic" tabindex="1" style="width: 50px;"
					value="<%=parts.length>0?parts[0]:noSysDias%>"
					validate="systolic,int,no" type="text" maxlength="3"
					class="allownumericwithoutdecimal textSmall"
					onblur="setVitalValue(this.value,'systolicTemp')" /> <label
					class="smallAuto">/</label> <input name="diastolic" id="diastolic"
					tabindex="1" style="width: 50px;"
					value="<%=parts.length>0?parts[1]:noSysDias%>"
					validate="diastolic,int,no" type="text" maxlength="3"
					class="allownumericwithoutdecimal textSmall"
					onblur="setVitalValue(this.value,'diastolicTemp')" /> <label
					class="smallAuto">mm Hg</label></td>
				<td><label class="smallAuto">Pulse:</label> <input
					class="textSmall allownumericwithoutdecimal" style="width: 50px;"
					tabindex="1" name="pulse" type="text" id="pulse"
					validate="pulse,int,no" maxlength="3"
					value="<%=pulse>0?pulse:"" %>"
					onblur="setVitalValue(this.value,'pulseTemp')" /> <label
					class="smallAuto">/ min</label></td>
		</table>

		<table
			style="width:450px; border-top: 1px solid #C0C0C0; float: left;">
			<tr>
				<td><label class="smallAuto">Wt:</label> 
				<%if(weight!=0){ %>
				    <input name="weight"
					id="weight" type="text" maxlength="6"
					class="allownumericwithdecimal textSmall" style="width:42px;"
					value="<%=weight.intValue()>0?weight.intValue():"" %>" validate="weight,double,no"
					onblur="calculateBMI();" tabindex="1" /> <input
					name="headCircumference" id="headCircumference" type="hidden"
					maxlength="6" class="allownumericwithdecimal textSmall" value=""
					validate="weight,double,no" tabindex="1" />
				<%}else{ %>	
				<input name="weight"
					id="weight" type="text" maxlength="6"
					class="allownumericwithdecimal textSmall" style="width:42px;"
					value="<%=weightNcd>0?weightNcd:"" %>" validate="weight,float,no"
					onblur="calculateBMI();" tabindex="1" /> <input
					name="headCircumference" id="headCircumference" type="hidden"
					maxlength="6" class="allownumericwithdecimal textSmall" value=""
					validate="weight,double,no" tabindex="1" />
				<%} %>
				<label class="smallAuto">kgs</label></td>
				<td>
				<label class="smallAuto">Ht:</label> 
				
				<%if(height!=0){ %>
				 <input name="height"
					id="height" type="text" maxlength="3"
					class="allownumericwithoutdecimal textSmall" style="width:25px;"
					value="<%=height.intValue()>0?height.intValue():"" %>" validate="height,int,no"
					onblur="calculateBMI();" tabindex="1" />
					<%}else{ %>	
					<input name="height"
					id="height" type="text" maxlength="3"
					class="allownumericwithdecimal textSmall" style="width:25px;"
					value="<%=hightNcd>0?hightNcd:"" %>" validate="height,float,no"
					onblur="calculateBMI();" tabindex="1" />
					<%} %> <label class="smallAuto">cms</label>
					 <input name="bmi" id="bmiValue" value="" readonly="readonly" class="textSmall"  type="hidden">
					</td>
				<td><label>BMI</label></td>
				
				<td><label id="bmi" class="value"><%=bmi>0f?bmi:"" %></label></td>
				<td><label class="value" id="bmiCat" ><%=(!bmiStatus.equals("")?bmiStatus:"") %></label></td>
			</tr>
		</table>

   <input type="button" class="buttonAuto" id="vitalTrends" value="Vital Trends" tabindex="1" style="margin-top: 6px;"/> 
		<div class="clear"></div>
		<div class="paddingTop5"></div>
		<div class="plusHideDiv hisDivHide" id="newpost2" style="width: 559px;display: block;">
			<label class="auto">Resp.Rate</label> <input
				class="allownumericwithdecimal textSmall" name="respiratoryRate"
				id="respiratoryRate" type="text" maxlength="3"
				validate="Respiratory Rate,float,no"
				value="<%=respirtoryRate>0?respirtoryRate:"" %>" tabindex="1"
				onblur="setVitalValue(this.value,'respiratoryRateTemp')" /> <label
				class="smallAuto">/ min</label>

			<label class="auto">Blood Group</label>
			<%
						if(bloodGroupValue != null &&  !bloodGroupValue.equals("") && !bloodGroupValue.equals("0")){ 
							
						%>
			<label style="width:24px; margin-left: 0;"><%=!bloodGroupValue.equals("0")?bloodGroupValue:""%></label>

			<%if(bloodGroupStatus != null && !bloodGroupStatus.equals("")){ %>
			<%}else{%>
			<select name="bloodGroupValue" id="bloodGroupValue" tabindex=1
				 style="width:58px;">
				<option value="0">Select</option>
				<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
				<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
				<%} %>
			</select>
			
		<%-- 	<label class="auto">Confirm</label>
						<%if(bloodGroupStatus != null && !bloodGroupStatus.equals("") && bloodGroupStatus.equalsIgnoreCase("y") ){ %>
						<input type="checkbox" tabindex="1" name="bloodGroupStatus" id="bloodGroupStatus" value="y" checked="checked" disabled="disabled" class="checkboxMargin" />
						<%}else{%>
						 <input type="checkbox" tabindex="1" name="bloodGroupStatus" id="bloodGroupStatus" value="y" class="checkboxMargin" />
			<%}%> --%>
						
			<%}}else{ %> <select name="bloodGroupValue" id="bloodGroupValue"
				tabindex=1 class="medium2">
				<option value="0">Select</option>
				<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
				<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
				<%} %>
			</select>
			<!-- <label class="auto">Confirm</label>
						<input type="checkbox" tabindex="1" name="bloodGroupStatus" id="bloodGroupStatus" value="y" class="checkboxMargin" /> -->
			<%} %>
		</div>
		
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
			<%
			String pDiagnosis=null;
			String fDiagnosis=null;
			String provisionalDiagnosis=null;
			String finalDiagnosis=null;
			String otherDiagnosis=null;
			String dDiagnosis=null;
			String diffDiagnosis=null;
			if(dischargeIcdCodeLast3Visit!=null){
			for(DischargeIcdCode dIcd:dischargeIcdCodeLast3Visit){ 
				if(dIcd.getDiagnosisStatus().equalsIgnoreCase("p"))
				 pDiagnosis = pDiagnosis!=null?pDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
				else if(dIcd.getDiagnosisStatus().equalsIgnoreCase("f"))
				 fDiagnosis = fDiagnosis!=null?fDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
				 
				 else if(dIcd.getDiagnosisStatus().equalsIgnoreCase("d"))
					 dDiagnosis = dDiagnosis!=null?dDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
					 
					 else if(dIcd.getDiagnosisStatus().equalsIgnoreCase("diff"))
						 diffDiagnosis = diffDiagnosis!=null?diffDiagnosis+"\n"+dIcd.getIcd().getIcdName():dIcd.getIcd().getIcdName();
			}}
			if(opdPatientDetails!=null && opdPatientDetails.getProvisionalDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)){
				provisionalDiagnosis = provisionalDiagnosis!=null?opdPatientDetails.getProvisionalDiagnosis().trim():opdPatientDetails.getProvisionalDiagnosis().trim();
			}
			if(opdPatientDetails!=null && opdPatientDetails.getFinalDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)){
				finalDiagnosis = finalDiagnosis!=null?opdPatientDetails.getFinalDiagnosis().trim():opdPatientDetails.getFinalDiagnosis().trim();
			}
			if(opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)){
				otherDiagnosis = otherDiagnosis!=null?opdPatientDetails.getInitialDiagnosis().trim():opdPatientDetails.getInitialDiagnosis().trim();
			}
			%>
	<div class="tabContWidth2">
		<label>Provisional Diagnosis</label>
		<textarea class="textYellow historyAutoComplete" id="snomed" tabindex="1"  <%=provisionalDiagnosis!=null%> name="snomed" maxlength="300" validate="Provisional Diagnosis,string,no"><%=provisionalDiagnosis!=null&&!"".equals(provisionalDiagnosis)?provisionalDiagnosis:""%></textarea>
			<input type="hidden"	id="snomedTermConceptIdEXM" name="snomedTermConceptIdEXM"/>
				<input type="hidden" name="snomedTermConceptId" id="snomedTermConceptId" />
	</div>

	<div class="tabContWidth2">
		<label>Final Diagnosis</label>
		<textarea name="finalDiagnosis" tabindex="1" id="finalDiagnosis" <%=finalDiagnosis!=null%> maxlength="300" class="textYellow historyAutoComplete ui-autocomplete-input" validate="Final Diagnosis,string,no"><%=finalDiagnosis!=null && !"".equals(finalDiagnosis)?finalDiagnosis:""%></textarea>
						
	</div>
	
<%-- 	<div class="tabContWidth3">
	<label class="auto">Other Diagnosis</label>
	
	<textarea tabindex="1" id="OtherDiagnosis" <%=provisionalDiagnosis!=null?"":""%> name="OtherDiagnosis" maxlength="300" validate="Other Diagnosis,string,no"></textarea>
						 <%if(otherDiagnosis!=null && !otherDiagnosis.equals("")){%>
						<textarea  tabindex="1" readonly="readonly" ><%=otherDiagnosis%></textarea>
						<%}%>
					</div> --%>
	
		<div style="display: none">
				<input type="hidden"  class="textYellow" id="snomedNames" name="snomedNames" />
					<input type="hidden"  class="textYellow" id="icd1" name="icd1" />
					
						<label>Diagnosis</label>
						<!-- <input type="text" tabindex="30" class="textYellow"	tabindex="23" id="snomed" name="snomed"	onblur="getICDListBasedOnSnomedId();"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');" style="width:278px; margin-right:0px;" /> -->
						<img src="/hms/jsp/images/removeBu.png" width="18" height="18" title="Remove Snomed Diagnosis" id="removeSnomed" style="cursor:pointer;" />
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
						maxlength="100" ><%=opdPatientDetails!=null && opdPatientDetails.getInitialDiagnosis()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getInitialDiagnosis().trim():"" %></textarea>	
						
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
						 <select id="icdName"	name="icdName" ></select>
					</div>
				
					<div class="clear"></div>
					<label>ICD code</label>
					<!-- <input name="icdCode" tabindex="26" class="textYellow" value="" id="icdCode" onblur="getIcd(1);" /> -->
					<input name="icdCode" tabindex="31" class="textYellow" value=""
						id="icdCode" readonly /> <input name="temp" value="" id="temp"
						type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="24"
						HEIGHT="20" class="search-img" 
						onClick="javascript:openPopupDiagnosisWindow();"
						title="Click here to Search ICD Codes" /> <!--<label
						class="autoSpace"> <input type="radio" tabindex="28"
						class="radioCheckCol2" name="diagnosis_status" value="p"
						id="diagnosis_status_p1" checked="checked"
						onchange="changeDiagnosisStaus(1);" />  Provisional
					</label> <label class="autoSpace"> <input type="radio"
						tabindex="29" class="radioCheckCol2" name="diagnosis_status"
						value="f" id="diagnosis_status_f1"
						onchange="changeDiagnosisStaus(2);" /> Final
					</label> <label class="smallAuto"><img
						src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" /> -->
						Notifiable Desease</label> <label class="smallAuto"><img
						src="/hms/jsp/images/grey_rectangle.jpg" width="14" height="14" />P-Register</label>

					<div class="clear"></div>
					
					
					
					
						<div class="paddLeftP100">
						<select name="diagnosisId" multiple="4" id="diagnosisId"
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
	<div class="clear"></div>



	<div class="invstHeadMainDiv">
		<div class="invstHeadDiv">
			<h2>INVESTIGATIONS:</h2>
			<label class="auto" style="background: #bdd6ee;">Lab 
			<input type="checkbox" value="Lab" class="radioCheckCol2"
										name="labradiologyCheck" checked="checked" onchange="" tabindex="1"/>
			</label> 
			<label class="auto" style="background: #bdd6ee;">Radiology 
			<input type="checkbox" value="Radio" class="radioCheckCol2"
										name="labradiologyCheck" onchange="" tabindex="1"/>
			</label> 
			<input type="hidden" name="investigationCategory"
										id="investigationCategory" tabindex="1"/>
			
			<label class="auto">Personal 
			<input type="checkbox" class="radioCheckCol2" name="invTempType"
				 checked="checked" name="invTempType" id="invTempType_personal"  onchange="getTemplate('local','i','');" tabindex="1"/>				
			</label> 
			<label class="auto">Local				
				<input type="checkbox" class="radioCheckCol2" name="invTempType" id="invTempType_local" onchange="getTemplate('global','i','');" tabindex="1"/>
				
			</label> 
			<label class="auto">Global
			<input type="checkbox" class="radioCheckCol2" name="invTempType" id="invTempType_global" onchange="getTemplate('all','i','');" tabindex="1"/>
				
			</label>

			<div class="clear"></div>
		</div>

		<div class="clear"></div>
		<div class="clear"></div>

		<%if(fixedInvestigationList!=null) {
			Object[] fixedInvestigationObjectArray = null;
			int length = fixedInvestigationList.size();
			for(int count=0;count<length;count++){
				fixedInvestigationObjectArray = fixedInvestigationList.get(count);
				
				if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("Blood Routine")){
		%>
		<label class="autoM">BRE<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
			type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
		<% }else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("Urine Routine")){
			%>
			<label class="autoM">URE<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
				type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
			<% } else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("Platelets Counts")){
			%>
			<%-- <label class="autoM">PLT Counts<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
				type="checkbox" onclick="toogleFixedInvestigationToList(this);" ></label> --%>
				<label class="autoM">PLT Counts<input class="breCheck" id="" value="<%="Platelet Count"+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
				type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
			<% } else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("Malaria Smear")){
				%>
				<label class="autoM">MP<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
					type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
				<% } else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("Creatinine")){
					%>
					<label class="autoM">S.Creat<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
						type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
					<% } else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("AFB Stain")){
					%>
					<label class="autoM">AFB<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
						type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
					<% }else if(((String)fixedInvestigationObjectArray[1]).equalsIgnoreCase("RBS [Random Blood Sugar]")){ %>	
			<%-- <label class="autoM">RBS<input class="breCheck" id="" value="<%=fixedInvestigationObjectArray[1]+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
			type="checkbox" onclick="toogleFixedInvestigationToList(this);" ></label> --%>
			<label class="autoM">RBS<input class="breCheck" id="" value="<%="Random Blood Sugar"+"["+(Integer)fixedInvestigationObjectArray[0]+"]"%>" name="fixedInvestigation"
			type="checkbox" onclick="toogleFixedInvestigationToList(this);" tabindex="1"></label>
		<% } } }%>
		
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="mltSelectDivLeft">
	<select multiple="5" tabindex="1"name="tempLateInvestigation" id="tempLateInvestigation"
										onchange="fnGetInvestigationTemplate(this,'opdLite');">
										<option value="-1">Select</option>
										<%for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("i")&& opd.getDepartment().getId()==visit.getDepartment().getId() && opd.getOpdTemplateInvestigations().size()>0){ %>
										<option value="<%=opd.getId()%>"  title="<%=opd.getTemplateName() %>"><%=opd.getTemplateName() %></option>
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
	<input name="" id="" class="buttonAuto" value="Save As Template" type="button" onclick="javascript:openPopupForSaveInvestigation();">
		</div>		
		<div class="textNameDiv" id="labInvDiv">
			<table style="width: 100%; border-top: solid 1px #C0C0C0" id="investigationGrid">
				<tr>
					<th>&nbsp;</th>
					<th>Test Name</th>
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
			int  chargeCodeId=0;
			Map<Integer,Integer> dgSampleCollectionMap=new HashMap<Integer,Integer>();
			for(;inc<dgSampleCollectionDetails.size();inc++){
				DgSampleCollectionDetails sampleCollectionDetails=(DgSampleCollectionDetails) dgSampleCollectionDetails.get(inc);
				 chargeCodeId=sampleCollectionDetails.getChargeCode().getId();
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
					
					chargeCodeId=dgOrderdt.getChargeCode().getId();
					dgSampleId=(Integer)dgSampleCollectionMap.get(chargeCodeId);
				
				}
			%>
											<tr>
												<td>
													<%-- <%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													type="checkbox" disabled="disabled" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /> <%}else{ %>
													<input type="checkbox" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /> <%} %>
													 --%>
													<input type="hidden" name="parkInvestigationId<%=inc %>"
													id="parkInvestigationId<%=inc %>"
													value="<%=dtIds%>-<%=pInvDt%>-<%=dgSampleId!=null?dgSampleId:"0" %>" />
													<input type="hidden" name="availableStatus<%=inc %>"
													id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
													<input class="delButSmll" id="investigationDelete<%=inc%>" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'investigation');"  > 
												</td>
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) { %> <input
													readonly="readonly" type="text" style="width:240px;<%=!availableInvesStatus.contains(chargeCodeId)?"color:red":""%>"
													class="popper chargeCodeName" data-popbox="pop1"
													value="<%=chargeCodeName %>" title="<%=chargeCodeName %>" id="chargeCodeName<%=inc %>"
													size="65" name="chargeCodeName<%=inc %>"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" tabindex="1"/>
													<%}  else{ %> <input type="text" style="width:240px;<%=!availableInvesStatus.contains(chargeCodeId)?"color:red":""%>"
													class="popper chargeCodeName" data-popbox="pop1"
													value="<%=chargeCodeName %>" title="<%=chargeCodeName %>"id="chargeCodeName<%=inc %>"
													size="65" name="chargeCodeName<%=inc %>"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="getUnavailableInvestigation(<%=inc %>);checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" tabindex="1"/>
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
					<input type="text" name="clinicalNotes<%=inc %>" 
													value="<%=clinicalNotes %>"
													class="opdTextBoxSmall textYellow" style="display: none;"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" tabindex="1"/>
				 </td>
				</tr>
		<%
			} %>
				
			</table>
		</div>
		<div class="adDelSmall">
			<input class="addButSmll" alt="Add" name="" type="button" style="height: 20px; width: 20px;" value="" onclick="addRowForInvestigationForOpdLite();">
		</div>	
		<input type="hidden" name="hiddenValue" id="hiddenValue"
										value="<%=inc-1%>" /> <input type="hidden" name="toDate"
										id="todate" value="<%=currentDate%>" /> <input type="hidden"
										name="dhHeaderIds" id="dhHeaderIds"
										value="<%=dtHids%>-<%=pInvHd%>-<%=dgSampleHdId%>" />
		<div class="paddLeft30"></div>

	</div>


	<div class="prescrMainDiv">
		<div class="prescrHeadDiv">
			<h2>PRESCRIPTION:</h2>
			
			<label class="auto" style="background: #bdd6ee;">Tablet <input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForTablet")%>"
				id="pharmacyCheck" name="pharmacyCheck" type="checkbox"tabindex="1">
			</label>
			<label class="auto"
				style="background: #bdd6ee;">Capsule <input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForCapsule")%>"
				id="pharmacyCheck" name="pharmacyCheck"
				type="checkbox" tabindex="1">
			</label> 
			<label class="auto" style="background: #bdd6ee;">Injection
			<input class="radioCheckCol2" value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForInjection")%>"
				id="pharmacyCheck" name="pharmacyCheck" type="checkbox" tabindex="1"></label>
				
			<input type="hidden" name="pharmacyCategory" id="pharmacyCategory" />
					
			<label class="auto">Personal
			<input class="radioCheckCol2" checked="checked" name="presTempType" id="presTempType_personal" onchange="getTemplate('local','p','');"	type="checkbox" tabindex="1"></label> 
			<label class="auto">Local
			 <input type="checkbox" class="radioCheckCol2" name="presTempType" id="presTempType_local" onchange="getTemplate('global','p','');" tabindex="1" />
			</label> 
			<label class="auto"> Global
				<input type="checkbox" class="radioCheckCol2" name="presTempType" id="presTempType_global" onchange="getTemplate('all','p','');" tabindex="1"/>
				</label>

			<div class="adDelSmall" style="width: 26px;">
				<input class="addButSmll"  alt="Add" name="" type="button" style="height: 20px; width: 20px;" value="" onclick="addRowForOpdLite();">
				<div class="clear"></div>
			</div>
		</div>

		<div class="clear"></div>

		<div class="clear"></div>
		 <input name="opdType" id="opdType" type="hidden"  value="lite"/>
		 <input name="splName" id="splName" type="hidden"  value=""/>
  <input name="OrderId" id="OrderId" type="hidden"  value="<%=OrderId%>"/>
		<div class="mltSelectDiv">
		<select multiple="5" name="tempLatePrescription" id="tempLatePrescription"
										onchange="fnGetPrescriptionTemplate(this,'opdLite');setDisablePharmacy();" onblur="setDisablePharmacy();" onclick="setDisablePharmacy();" tabindex="1">
										<option value="0">Select</option>
										<%
										for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("P")/* && opd.getDepartment().getId()==visit.getDepartment().getId()  */&& opd.getOpdTemplateTreatments().size()>0){ %>
										<option value="<%=opd.getId()%>" title="<%=opd.getTemplateName() %>"><%=opd.getTemplateName() %></option>
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
		<input name="" id="" class="buttonAuto" value="Save/Edit Template" type="button" onclick="openPopupForSavePrescriptiontamplate();">
		<input name="Prevoius2" id="" class="buttonAuto" value="Last prescription" type="button" onclick="openPopupForPatientPrescriptionForOpLite('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue)">						
		</div>		

		<div class="tableDiv">
			<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="grid">
				<tr>
					<th>&nbsp;</th>
					<th>Drug Name</th>
					<th>Route</th>
					<th>Dosage</th>
					<th>Unit</th>
					<th>Frequency</th>
					<th>Duration</th>
					<th>Instruction</th>
					<th>CT</th>
					<th>Remarks</th>
				</tr>			
				
	<%
	incr = 0;
	len=3;
	if(patientPrescriptionDetails.size()>0){
		len=patientPrescriptionDetails.size();
	}else{
		len=3;
	}
	int inxRow=3;
	Integer pHeaderId=0;
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
		String ct="";
		String specialInstruction="";
		PatientPrescriptionDetails pd=null;
		if(patientPrescriptionDetails.size()>0){
			pd=patientPrescriptionDetails.get(incr);
			pHeaderId=pd.getPrescription().getId();
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
			if(pd.getNoOfDays()!=null){
			ndays=pd.getNoOfDays();
			}
			specialInstruction=pd.getSplInstruction();
			ct=pd.getCt();
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
											<%-- <%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" class="radioCheck"
											id="itemRadio<%=incr %>" title="Prescription issued.."
											disabled="disabled" name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" />
											<%}else{%> <input
											type="checkbox" tabindex="<%=inxRow%><%=inxCol+1%>"
											class="radioCheck" id="itemRadio<%=incr %>"
											name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" /> <%} %>
											--%>
											<input type="hidden" id="parkPrescriptionIds<%=incr%>"
											name="parkPrescriptionIds<%=incr%>"
											value="<%=pd!=null && pd.getId()!=0?pd.getId():"0"%>"
											readonly="readonly" /> 
											<input
											type="hidden" name="prescription_availableStatus<%=incr %>"
											id="prescription_availableStatus<%=incr %>"
											value="<%= pAvailableStatus%>" />
											<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'prescription');"> 
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											title="Prescription issued.."
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											style="width: 146px;<%=!availStockItemIdSet.contains(ItemId) ?"color:red":""%>" value="<%=nomeclature%>" title="<%=nomeclature%>"
											id="nomenclature<%=incr%>" size="35" class="nomenclaturepTab"
											name="nomenclaturepTab<%=incr%>"
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>); checkForAllergy(this.value,<%=incr %>); populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>'); ValidateCantra();displayAu(this.value,'<%=incr%>','opdlite');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr%>);" tabindex="1"/>
											<%}else{ %> <input type="text"
											tabindex="1"
											style="width: 146px;<%=!availStockItemIdSet.contains(ItemId) ?"color:red":"" %>" class="nomenclaturepTab" title="<%=nomeclature%>"
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											value="<%=nomeclature%>" id="nomenclature<%=incr%>" size="35" <%=nomeclature!=""?"readonly":""%>
											name="nomenclaturepTab<%=incr%>"
											<%-- onfocus="checkEnteredDiagnosis(); //Commented by Arbind on 31-01-2017--%>
											<%-- checkFrequency('<%=incr%>','opc');" --%>
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>);
											     checkFrequency('<%=incr%>','opc');
												 checkDrugToDiseaseCantra(this);
												 checkForAllergy(this.value,<%=incr %>);populatePVMS(this.value,'<%=incr%>');
												 checkItem('<%=incr%>'); 
												 ValidateCantra();displayAu(this.value,'<%=incr%>','opdlite');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=incr %> )"/>
											<%}%>
											<div id="ac2updates<%=incr%>" style="display: none;"
												class="autocomplete"></div>
								 <script type="text/javascript"	language="javascript" charset="utf-8">
							 	 new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,
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
											class="medium2" style="width: 55px; margin-left: 0px !important; background: #FFFF99"
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
											class="medium2" style="width: 55px; margin-left: 0px !important; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');" tabindex="1">
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
											 type="text"
											name="dosagepTab<%=incr%>" id="dosage<%=incr%>"
											value="<%=dosage!=null && dosage!=0?dosage:"" %>" size="10"
											style="width: 34px;"  
										maxlength="45" onblur="fillValueForOpdLite(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" tabindex="1"/></td>
										<td><input type="text"
											 name="unit<%=incr %>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											class="textYellow opdTextBoxTSmall" id="unit<%=incr %>"
											readonly="readonly" size="5"
											onblur="fillValueForOpdLite(this.value,<%=incr%>);" tabindex="1"/></td>
										<td><input type="hidden" name="frequencyValue<%=incr%>"
											id="frequencyValue<%=incr%>" value="" size="6" tabindex="1"/> <input
											type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
											style="display: none;" size="3"
											onblur="fillValueForOpdLite(this.value,<%=incr%>)" maxlength="3"
											validate="Sos Qty,num,no" tabindex="1"/> 
									<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											class="medium2" style="width: 55px; margin-left: 0px !important;"
											name="frequencyTab<%=incr%>" id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValueForOpdLite(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>,'opdLite');displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
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
										</select> <%}else{ %> <select 
											class="medium2" style="width: 55px; margin-left: 0px !important;"
											 name="frequencypTab<%=incr%>"
											id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillValueForOpdLite(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>,'opdLite');displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" tabindex="1">
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
											<div style="width:62px; float:left;">
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDayspTab<%=incr%>" id="noOfDays<%=incr%>"
											value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" style="width: 14px;" size="2" maxlength="2"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValueForOpdLite(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<%}else{ %> <input type="text"
											 name="noOfDayspTab<%=incr%>"
											id="noOfDays<%=incr%>" value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" style="width: 14px;" size="2" maxlength="2"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillValueForOpdLite(this.value,<%=incr%>);" tabindex="1"/>
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<% }%>
                                         </div>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 80px; background: #FFFF99"
											name="instrunctionpTab<%=incr%>" id="instrunction<%=incr%>" >
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
										</select> <%}else{ %> <select style="width: 80px; background: #FFFF99"
											name="instrunctionpTab<%=incr%>" id="instrunction<%=incr%>" tabindex="1">
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
            <%-- <input type="text" tabindex="<%=inxRow%><%=inxCol+9%>" 
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall" style="display: none;"
											id="splInstrunction<%=incr %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" value="<%=specialInstruction%>" /> --%>
            <input type="hidden" name="total<%=incr %>" id="total<%=incr %>"	value="<%=total!=null && total!=0?total:"" %>" 
											 validate="Total,num,no"	readonly="readonly" />
										</td>
										<td>
										<%if(!ct.equals("") && !ct.equals(null) && ct.equalsIgnoreCase("y")){ %>
										<input type="checkbox" name="ct<%=incr %>" class="radio" id="ct<%=incr %>" value="y" checked="checked"/>
											<%}else{ %>
											<input type="checkbox" name="ct<%=incr %>" class="radio" id="ct<%=incr %>" value="y" />
											<%} %>
			<td><input type="text"  tabindex="1" 
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall" 
											id="splInstrunction<%=incr %>" maxlength="100"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" value="<%=specialInstruction%>"
			style="width:60px;" validate="Remarks,alphanumeric,no" value=""></td>							
										
									</tr>
									<%} %>
					
		<tbody id="divTemplet1"></tbody>	
								</table>
								<input type="hidden" name="pTabhdb" value="<%=incr-1 %>" id="hdb" />
								<%-- <input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" /> --%>
								<input type="hidden" name="hdbRecordSize"
									value="<%= patientPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize" /> <input type="hidden" name="hdbTabIndex"
									id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" />
								

		</div>
	</div>


	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>

<label class="auto">Do you want to prescribe NON KMSCL medicine
		<%
		if(patientOtherPrescriptionDetails.size() > 0){
			%>
			<input  class="radioCheckCol2" tabindex="1" type="checkbox" value="Click" onclick="switchVisible();" checked="checked"/>
			<script>switchVisible();</script>
			<%}else{ %>
			<input  class="radioCheckCol2" tabindex="1" type="checkbox" value="Click" onclick="switchVisible();" /><%} %>				
			</label>
<div id="Div1"></div>
<div id="Div2" tabindex="1" style="padding-left:-257px;<%=patientOtherPrescriptionDetails.size()>0?"display:block;":""%>" >
<div style="width: 800px; float: left;"> 
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridForPrescription">
									<tr>
										<th style="background: #bdd6ee;">&nbsp;</th>
										<th style="background: #bdd6ee;">Item Name</th>
										<th style="background: #bdd6ee;">Route</th>
										<th style="background: #bdd6ee;">Dosage</th>
										
										<th style="background: #bdd6ee;">Frequency</th>
										<th style="background: #bdd6ee;">Duration</th>
										<th style="background: #bdd6ee;">Instruction</th>
										<th style="background: #bdd6ee;">Special Instruction</th>
										
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
		String splInstrunctionsOut = null;
		String unitOut="";
		String frequecnyTypes="";
		Float dosagesOut=0f;
		int noOfDaysOut=0;
		Float totalOut=0f;
		String issuedStatus="";
		String routeNames="";
		String conversions="";
		int prescriptionIdOut =0;
		PatientPrescriptionDetails pds=null; MasStoreOutItem mso=null;
		if(patientOtherPrescriptionDetails.size()>0 && masStoreOutItemsList.size()>0){
			pds=patientOtherPrescriptionDetails.get(incrs);
			mso=masStoreOutItemsList.get(incrs);
			ItemIds=mso.getId();
					
			if(mso.getStatus()!=null && !mso.getStatus().equals("")  && mso.getStatus().equalsIgnoreCase("y")){
				issuedStatus=mso.getStatus();
			}
			if(pds.getItemOut()!=null){
				nomeclatures=pds.getItemOut().getNomenclature();	
			}if(pds.getSplInstruction()!=null){
				splInstrunctionsOut = pds.getSplInstruction();
			}if(pds.getDosage()!=null){
				dosagesOut=pds.getDosage();
			}if(pds.getTotal()!=null){
				totalOut=pds.getTotal();
			}if(pds.getNoOfDays()!=null){
				noOfDaysOut=pds.getNoOfDays();
			}if(pds.getFrequency().getFrequencyType()!=null){
				frequecnyTypes=pds.getFrequency().getFrequencyType();
			}			
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
											type="checkbox" tabindex="1"
											class="radioCheck" id="itemRadios<%=incrs %>"
											name="itemRadios<%=incrs %>"
											onchange="checkPrescriptionCheckList(<%=incrs %>)" /> <%} %> 
													<input type="hidden" id="parkOutPrescriptionIds<%=incrs%>"
											name="parkOutPrescriptionIds<%=incrs%>"
											value="<%=pds!=null && pds.getId()!=0?pds.getId():"0"%>"
											readonly="readonly" /> 
											<input
											type="hidden" name="prescription_availableStatus<%=incrs %>"
											id="prescription_availableStatus<%=incrs %>"
											 />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											title="Prescription issued.."
											onkeypress="checkTextColorList('nomenclatures<%=incrs%>');"
											class="textYellow largTextBoxOpd" value="<%=nomeclatures%>" title="<%=nomeclatures%>"
											id="nomenclatures<%=incrs%>" size="35"
											name="nomenclatures<%=incrs%>"
											onblur="validatePrescriptionAutocompleteList('opPTab',this.value,<%=incrs%>);" />
											<%}else{ %> <input type="text"
											tabindex="1"
											class="textYellow largTextBoxOpd" title="<%=nomeclatures%>"
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
										
										<input type="hidden" id="prescriptionIdOut<%=incrs%>"
											name="prescriptionIdOut<%=incrs%>"
											value="<%=pds!=null && pds.getId()!=0?pds.getId():"0"%>"
											readonly="readonly" /> 
										
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
											tabindex="1" id="routesOut<%=incrs%>"
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
											tabindex="1" type="text"
											name="dosagesOut<%=incrs%>" id="dosagesOut<%=incrs%>"
											value="<%=dosagesOut!=null && dosagesOut!=0?dosagesOut:"" %>" size="10"
											maxlength="3" onblur="fillValueList(this.value,<%=incrs%>);" /></td>
										
										<td><input type="hidden" name="sosQtyout<%=incrs%>" id="sosQtyout<%=incrs%>"
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
											tabindex="1" name="frequencyValueOut<%=incrs%>"
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
							            <input type="hidden" name="totalpTab<%=incrs %>" id="total<%=incrs %>"	 size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
                                       
	          					  </td>
										<td>
											<div style="width:95px; float: left;">
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDaysOut<%=incrs%>" id="noOfDaysOut<%=incrs%>"
											value="<%=noOfDaysOut!=0 ?noOfDaysOut:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event);" 
											onblur="fillValueDay(<%=incrs%>);fillValueList(this.value,<%=incrs%>);" />
											<p style="line-height:0px;" id="frequencyTypeOut<%=incrs %>" ><%=frequecnyTypes %></p>
											<%}else{ %> <input type="text"
											tabindex="1" name="noOfDaysOut<%=incrs%>"
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
											tabindex="1"
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
											onblur="fillSPLInstrunctionOnPTAb(<%=incrs %>);"  value="<%=splInstrunctionsOut!=null?splInstrunctionsOut:""%>"/> <%}else{ %>
											<input type="text" tabindex="1"
											name="splInstrunctionsOut<%=incrs %>"
											class="textYellow opdTextBoxTSmall"
											id="splInstrunctionsOut<%=incrs %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incrs %>);" style="width: 80px;" value="<%=splInstrunctionsOut!=null?splInstrunctionsOut:""%>"/> <% }%>
											<input type="hidden" name="totalOut<%=incrs %>" id="totalOut<%=incrs %>"	value="<%=totalOut!=null && totalOut!=0?totalOut:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td>								
										
									</tr>
									<%} %>
					
								<tbody id="divTemplet1"></tbody>	
								</table>
								<input type="hidden" name="hdb1" value="<%=incrs-1 %>" id="hdb1" />
								<input type="hidden" name="hdbRecordSize1"
									value="<%= patientOtherPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize1" /> <input type="hidden" name="hdbTabIndex1"
									id="hdbTabIndex1" value="<%=inxRows-1%>" id="hdbRecordSize1" />
						
						

</div>

<div style="width:-26px;background-color:floralwhite;float:left;">
<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowOtherMedicineForLP();">
<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowOtherMedicineForLP();"> 
</div>				
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="procduMainDiv">
<div class="procduTitleDiv" id="button9" style=" cursor: pointer;" onclick="showhide(this.id)">
<div class="titleBg" style="width: 520px; float: left;">
<h2 class="h2Text">PROCEDURES</h2>
</div>
<input class="buttonPlusMinus" tabindex="1" name="" id="realtedbutton9" value="+" onclick="showhide(this.id)" type="button">	
</div>	
<div class="hisDivHide" id="newpost9">
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="buttonAuto-buttn" style="height:19px; width:18px;float:left; margin-left:0;" alt="Add"  value="+"
onclick="addRowTreatmentNursingCareOpdLite();"   />
<div class="clear"></div>
<div class="clear"></div>
<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="gridNursing">
				<tr>
					<th>&nbsp;</th>
					<th>Procedure Name</th>
					<th>Frequency</th>
					<th>No. of Days</th>
					<th>Remarks</th>
				</tr>

				<%
	incr=0 ;
	len=1;
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
					<%-- <td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						type="checkbox" disabled="disabled" class="radioCheck"
						id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>" />
					</td>
					<%}else{ %>
					<input type="checkbox" class="radioCheck"
						id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>">
					</td>
					<%} %> --%>
					<td>
					<input type="hidden"
						value="<%=procedureId!=null && !procedureId.equals(0)?procedureId:0 %>"
						name="procedureDetailId<%=incr%>" id="procedureDetailId<%=incr%>" />
					<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'procedure');"> 
					</td>	
					<td>
						<%if(procedureStatus.equalsIgnoreCase("y")) {%> <input
						readonly="readonly" type="text" style="width:180px;"
						value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>"
						size="35" name="procedureName_nursing<%=incr%>" class="procedure"
						<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)" />
						<%}else{%> <input type="text" style="width:180px;" class="procedure"
						value="<%=nursingCare %>" id="procedureName_nursing<%=incr%>" tabindex="1"
						size="35" name="procedureName_nursing<%=incr%>"
						<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)" />
						<%}%>
						<div id="ac2updates_nursing<%=incr%>" style="display: none;"
							class="autocomplete"></div> <script type="text/javascript"
							language="javascript" charset="utf-8">
											  new Ajax.Autocompleter('procedureName_nursing<%=incr%>','ac2updates_nursing<%=incr%>','opd?method=getNursingCareProcedureAutoList&minor_major=1',{minChars:3,
											  callback: function(element, entry) {
								              return entry;
								        }, parameters:'requiredField=procedureName_nursing<%=incr%>'});
									</script>
					</td>
					<td><select name="frequency_nursing<%=incr%>" style="width:80px;"
						id="frequency_nursing<%=incr%>" tabindex="1"
						onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')" tabindex="1">
							<option value="0">Select</option>
							<%
						  MasFrequency masFrequency = new MasFrequency();
					      for(MasFrequency masFrequency2 : frequencyList){
					       int id = masFrequency2.getId();
					       String name = masFrequency2.getFrequencyName();
			          %>
							<option value="<%=id %>" <% if(frequencyId_1 == id){%> selected
								<%}%>><%=name%></option>
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
	            </script> <%
 	}
 %></td>
					<td id="nf<%=incr%>"><input type="text"
						name="noOfDays_nursing<%=incr%>" id="noOfDays_nursing<%=incr%>"
						value="<%=noOfDays != 0 ? noOfDays : ""%>"
						class="textSmall" type="text" style="width:50px;" size="5" tabindex="1"/></td>
					<td>
						<%
							if (procedureStatus.equalsIgnoreCase("y")) {
						%> <input
						readonly="readonly" value="<%=nursingRemark%>" type="text"
						name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
						style="width:164px;" /> <%
 				} else {
			 %> <input type="text"
						value="<%=nursingRemark%>" name="remark_nursing<%=incr%>"
						id="remark_nursing<%=incr%>" style="width:164px;" tabindex="1"/>
						<%
							}
						%>
					</td>
				</tr>
				<%
					}
				%>
			
			</table>
			<input type="hidden" id="procedureHeaderId"
							name="procedureHeaderId" value="<%=procedureHeaderId%>" />
						<input type="hidden" name="nursinghdb" value="<%=incr-1%>"
							id="nursinghdb" />
			<div class="clear"></div>
			<div class="clear"></div>
		</div>		
	</div>
	
<div class="surProMainDiv">	
<div class="surProTitleDiv" id="button3" style=" cursor: pointer;" onclick="showhide(this.id)">
<div class="titleBg" style="width: 520px; float: left;"><h2 class="h2Text">SURGERY PROCEDURES</h2></div>
<input class="buttonPlusMinus" tabindex="1" name="" id="realtedbutton3"value="+" onclick="showhide(this.id)" type="button">
</div>	
<div class="hisDivHide" id="newpost3">
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="buttonAuto-buttn"  style="height:19px;width:18px;float:left;margin-left:0;" alt="Add" value="+" onclick="addRowTreatmentSurgeryOpdLite();"  />
<div class="clear"></div>
<div class="clear"></div>
			<table style="width: 100%; border-top: solid 1px #C0C0C0;" id="gridSurgery">
				<tr>
					<th>&nbsp;</th>
					<th>Procedure Name</th>
					<th>Tentative Date</th>
					<th>Remarks</th>
					<th>PAC</th>
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
									<%-- <td><input type="checkbox" class="radioCheck"
										id="surgeryRadio<%=incr%>" name="surgeryRadio<%=incr%>"
										tabindex="31" /> <input type="hidden"
										value="<%=surgeryId!=null && !surgeryId.equals(0)?surgeryId:0 %>"
										name="surgeryDetailsId<%=incr%>"
										id="surgeryDetailsId<%=incr%>" /></td> --%>
									<td>
									<input type="hidden"
										value="<%=surgeryId!=null && !surgeryId.equals(0)?surgeryId:0 %>"
										name="surgeryDetailsId<%=incr%>"
										id="surgeryDetailsId<%=incr%>" />
					<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'surgery');"> 
					</td>		
										
									<td>
									<input type="text" style="width: 190px;" tabindex="1" value="<%=surgery %>" class="surgery" id="procedureName_surgery<%=incr%>" size="35"
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
										onclick="setdate('<%=currentDate%>',document.opdMain.tentativeDate<%=incr%>,event);" tabindex="1"/>
								</td>
									<td><input type="text" name="remark_surgery<%=incr%>"
										value="<%=surgerRemark %>" id="remark_surgery<%=incr%>"
										style='width: 205px;' tabindex="1"/></td>
								<td>
								<input type="checkbox" id="chkpacNeed<%=incr%>" name="chkpacNeed<%=incr%>" value=""  onchange="pacRequesting(<%=incr%>);" tabindex="1"/>
								</td>
								</tr>
						<%} %>
				
			</table>
			<input type="hidden" id="surgeryHeaderId" name="surgeryHeaderId"	value="<%=surgeryHeaderId%>" />
			<input type="hidden" name="surgeryhdb" value="<%=incr-1 %>"	id="surgeryhdb" />
			<div class="clear"></div>
			<div class="clear"></div>
		</div>	
	
	</div>
	
	<div class="clear"></div>
	<div class="clear"></div>	
	
	
	<div class="adviceDivMain" id="button8" onclick="showhide(this.id)">
		<div class="titleBg" style="width: 520px; float: left;">
			<h2 class="h2Text">ADVICE</h2>
		</div>
		<input class="buttonPlusMinus" tabindex="1" name="" id="realtedbutton8" value="+" onclick="showhide(this.id)" type="button">
	</div>

	<div class="clear"></div>
	<div class="clear"></div>

	<%-- <label class="auto">Transfer to Observation Ward 
	<%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="radio" checked="checked" class="radioCheckCol2"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="radioCheckCol2" id="observationStatus"
							name="observationStatus" /> <%} %>
	<!-- <input
		class="radioCheckCol2" value="y" id="laboratoryqueueId"
		name="laboratoryqueue" type="radio"> -->
	</label>  --%>
	
	<%-- <label class="auto">Admission 
	<%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="radio" checked="checked" class="radioCheckCol2"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="radio" class="radioCheckCol2" id="admissionAdvised"	name="admissionAdvised" />
							<%} %>
	<!-- <input class="radioCheckCol2"
		value="y" id="laboratoryqueueId" name="laboratoryqueue" type="radio"> -->
	</label>  --%>
	<div class="clear"></div>
	<div class="hisDivHide" id="newpost8">
	 <div id="admissionDiv">
						<div class="clear"></div>
						<label>Personal Review<input type ="checkbox" tabindex="1" id="checked" class="checkboxMargin" name="chk1" onclick="popFuturConsultationReview('registration?method=showOnlineAppointmentPreviewJsp&futureConsultFlag=1&uhid=<%=visit.getHin().getHinNo()%>&deptId=<%=deptId %>&'+csrfTokenName+'='+csrfTokenValue)" /></label>
						<label class="auto">Transfer to observation ward <%if(opdPatientDetails!=null && opdPatientDetails.getObservationStatus()!=null && opdPatientDetails.getObservationStatus().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="checkboxMargin"
							id="observationStatus" name="observationStatus" /> <%}else{ %> <input
							type="checkbox" class="checkboxMargin" id="observationStatus"
							name="observationStatus" tabindex="1"/> <%} %>
						</label>
						<label class="autoSpace" onclick="setDisablePharmacy();">Pharmacy
					<input type="checkbox"  class="radioCheckCol2" value="y" tabindex="1"	id="PharmacyqueueId" name="Pharmacyqueue" onclick="setDisablePharmacy();" />
						</label>
						
						 <label class="autoSpace">Laboratory
					<input type="checkbox"  class="radioCheckCol2" value="y"	tabindex="1"id="laboratoryqueueId" name="laboratoryqueue" />
						</label>
						
						 <label class="autoSpace">X-ray
					<input type="checkbox"  class="radioCheckCol2" value="y"	tabindex="1"id="RadiologyqueueId" name="Radiologyqueue" />
						</label>
						
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
						 <label>Admission Advised
						  <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<input type="checkbox" checked="checked" class="checkboxMargin"	id="admissionAdvised" name="admissionAdvised" />
							<%}else{ %>
							<input	type="checkbox" class="checkboxMargin" id="admissionAdvised" name="admissionAdvised" tabindex="1"/>
							<%} %>
						</label>
						
						 <%if(opdPatientDetails!=null && opdPatientDetails.getAdmissionAdvised()!=null && opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y") && opdPatientDetails.getVisit().getId().equals(visitId)) {%>
							<div id="admDiv">
							<label class="auto">Admission Date</label>
							 <input type="text"	name="admissionDate" id="admissionDate"	style="text-align: left;" class="dateTextSmall"	value="<%=HMSUtil.convertDateOneFormatToAnother("dd/MM/yyyy",opdPatientDetails.getAdmissionDate())%>" readonly="readonly" onblur="checkAdmte()" />
							  <img src="/hms/jsp/images/cal.gif" class="calenderImg" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
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
	
	<!-- <label class="auto">Refer Patient <input
		class="radioCheckCol2" value="y" id="laboratoryqueueId"
		name="laboratoryqueue" type="radio"></label> --> 
	<%
					String relationName="";
					if(opdPatientDetails!=null &&  opdPatientDetails.getReferedStatus()!=null && (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C"))  && opdPatientDetails.getVisit().getId().equals(visitId)/* && !opdPatientDetails.getVisit().getVisitStatus().equalsIgnoreCase("c") */){ %>
									
									<div class="clear"></div>
									<div id="referalDiv" style="display:block; margin-top:5px;">	
		                          
									<label>Referral </label>
									
									 <select id="referral" name="referral"	class="midium" tabindex="1">
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
										<label class="auto"><input type="checkbox" tabindex="1"
											class="radioCheckCol2" name="referBack" id="referBack"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>@@@<%=deptNameDoctorId%>@@@<%=deptNameDoctorName%>');" />ReferBack</label>
										<%
									}
									%>
		
									<%if(opdPatientDetails.getReferedStatus().equalsIgnoreCase("y") || opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")){ %>
										<input type="hidden" name="referCheck" id="referCheck" value="y"/>
										<label class="auto">
										<input type="radio"	class="checkboxMargin" name="referTo" tabindex="1"<%=opdPatientDetails.getReferredType().equalsIgnoreCase("Interanal")?"checked='checked'":"" %>  id="referInternal" value="Internal" onclick="checkReferTO('referInternalRecall',<%=referredDept%>);" />Internal</label>
										<label class="auto">
										<input type="radio" class="checkboxMargin" name="referTo" tabindex="1"<%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")?"checked='checked'":"" %>id="referExternal" value="External" onclick="checkReferTO('referExternal',<%=referredDept%>);" />External</label>
									<%}%>
									
		
									<div class="clear"></div>
									<label>Refer Date:</label> <input type="text"	id="referVisitDate"tabindex="1" name="referVisitDate" class="date"	value="<%=currentDate%>" onkeyup="mask(this.value,this,'2,5','-');"
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
									<select	id="referHospitalType" name="referHospitalType"	onchange="fnGetDistrictHospital();" style="display: none;" >
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
										class="midium" tabindex="1">
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
											class="radioCheckCol2" name="referBack" id="referBack" tabindex="1"
											value="Internal"
											onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>@@@<%=deptNameDoctorId%>@@@<%=deptNameDoctorName%>');" />ReferBack</label>
										<%
									}
									%>
		
									<label class="auto"><input type="radio"
										class="checkboxMargin" name="referTo" id="referInternal"
										value="Internal" onclick="checkReferTO('referInternal',<%=deptIdSession%>);" checked tabindex="1"/>Internal</label>
									<label class="auto"><input type="radio"
										class="checkboxMargin" name="referTo" id="referExternal"
										value="External" onclick="checkReferTO('referExternal',<%=deptIdSession%>);" tabindex="1"/>External</label>
		
									<div class="clear"></div>
									
									<label>Refer Date:</label> <input type="text"
										id="referVisitDate" name="referVisitDate" class="date" style="width:133px;"
										value="<%=currentDate%>"
										onkeyup="mask(this.value,this,'2,5','-');"
										 />
									<img  src="/hms/jsp/images/cal.gif" class="calenderImg"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" tabindex="1"/> 
									<label id="priorityLabelId" style="width:115px;">Current Proirity No.</label> <select
										id="priorityId" name="priorityName" tabindex="1" style="width: 100px;">
										<option value="3">3</option>
										<option value="2">2</option>
										<option value="1">1</option>
									</select>
								
									<label id="referdistrictLabel" style="width:100px;display: none;">District</label> <select
										id="referdistrict" name="referdistrict"
										onchange="fnGetDistrictHospital();" style="display: none;" tabindex="1">
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
									<label id="referHospitalTypeLabel" style="display: none;">Hospital Type</label> <select
										id="referHospitalType" name="referHospitalType" style="width:168px; margin-right:0px;display: none;"
										onchange="fnGetDistrictHospital();" onblur="fnGetDistrictHospital();" tabindex="1">
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
									
									<label id="referhospitalLabel"  style="width:100px;display: none;">Hospital</label> <select
										id="referhospital" name="referhospital"
										onchange="fnGetHospitalDepartment(this.value,'referExternal',<%=deptIdSession%>);" style="display: none;" tabindex="1">
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
										onchange="fnGetDoctorDepartment(this.value);getSessionForDepartment(this.value);" style="width:169px; margin-right:0px;"tabindex="1" >
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
										id="opsession" name="referredSession" style="width: 100px;" tabindex="1">
										<option value="0">Select</option>
										
												
										
									</select> 
									 <label style="width:100px;">Doctor</label> <select id="refereddoctor"
										name="refereddoctor" tabindex="1">
										<option value="0">Select</option>
									</select>		
		
									<div class="clear"></div>
									<label>Patient Advise</label>
									<textarea name="patientAdvise" validate="patientAdvise,string,no" style="margin-left:0px; width:141px;"
										id="patientAdvise" cols="0" rows="0" maxlength="500"
										tabindex="1" onkeyup="return checkLength(this)" tabindex="1"></textarea>
									<input type="button" class="buttonAuto-buttn" value="+"
										onclick="" /> <label style="width:101px;margin-left:0px;">Referral Notes</label>
									<textarea name="referralNote" validate="referralNote,string,no"
										id="referralNote" cols="0" rows="0" maxlength="500" tabindex="1" style="margin-left:0px;width: 162px;"
										onkeyup="return checkLength(this)"tabindex="1"></textarea>
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
									maxlength="1" tabindex="1"/>
								<%}} %>
							</div>
					<%} %>		
			
			
	<div class="clear"></div>	
	<label class="heightAuto">Review / Follow Up Remarks</label>
	<textarea class="large" id="opdRemarks" name="opdRemarks" tabindex="1" cols="0" rows="0" maxlength="250" style="width: 560px; height:30px;overflow-x:hidden;resize:vertical;" onkeyup="return checkLength(this)"><%=opdPatientDetails!=null && opdPatientDetails.getOpdRemarks()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getOpdRemarks():"" %></textarea>
		
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
	
<input type="hidden" name="diagnosis_status" id="diagnosis_status" />
<input id="visitId" name="visitId" id="visitId" type="hidden"
			value="<%=visit.getId()%>" /> <input name="hinId" id="hinId" type="hidden"
			value="<%=visit.getHin().getId()%>" /><input name="memberId" id="memberId" type="hidden"
			value="<%=memberId%>" /> <input name="hinNo" id="hinNo"
			type="hidden" value="<%=visit.getHin().getHinNo()%>" /> <input
			name="departmentId" type="hidden"
			value="<%=visit.getDepartment().getId()%>" /> <input
			name="hospitalId" id="hospitalId" type="hidden" value="<%=hospitalId%>" /> 
			<%-- <input name="empId" type="hidden" value="<%=docId%>" /> --%> 
			<input id="deptId"
			name="deptId" type="hidden" value="<%=deptId%>" /> <input id="consultationDate"
			name="consultationDate" type="hidden" value="<%=consultationDate%>" />
		<input name="consultationTime" type="hidden"
			value="<%=consultationTime%>" /> 
			 <input name="relation"
			type="hidden" value="<%=relationName%>" /> <input name="pHeaderId"
			type="hidden" value="<%=pHeaderId%>" /> 
			 
			<input
			name="opdpatientDetailId" type="hidden"
			value="<%=opdpatientDetailId%>" />
		<input type="hidden" id="patientName" name="patientName" value="<%=patientName %>" />
		<input type="hidden" id="gender" name="gender" value="<%=gender != null?gender:"" %>" />
		<input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge != 0?patientAge:"" %>" />

<div class="clear"></div><div class="clear"></div><div class="clear"></div><div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input name="Submit11" id="Submit11" class="buttonAuto" value="Submit"
		type="button" align="right" style="background: #c55a11; color: #fff;" onclick="if(checkForProcedure()){if(fillcheckDoseFrequency() ){if(checkTentativeDates() ){fnSubmitPatient('s');}}}" tabindex="1"/>
<input type="button" class="buttonAuto" value="Park Patient" align="right" style="background: #c55a11; color: #fff;"  onclick="fnSubmitPatient('p');" tabindex="1">
<input name="Submit11" id="Submit11" class="buttonAuto" value="Reset" onclick="resetAll();"
		type="button" align="right" style="background: #c55a11; color: #fff;" tabindex="1"/>
<input name="Submit11" id="Submit11" class="buttonAuto" value="Second Opinion"
		type="button" align="right" style="background: #c55a11; color: #fff;" onclick="SecondOpinion();" tabindex="1"/>
<!-- <input type="button" class="buttonAuto" name="next" style="background: #c55a11; color: #fff;" value="Next"	onclick="fnSubmitPatient('nextlite');" /> -->

<div class="countButtonMain">
<input type="button" class="buttonAuto" name="next" style="background: #c55a11; color: #fff;" value="Next" onclick="fnSubmitPatient('nextlite');" tabindex="1"/>
<% if(opCallCount>0){ %>
<div class="countMain"><%=opCallCount%></div>
<% } %>
</div>

<% if(opCallCount>=2){ %>
					<input type="button" class="buttonAuto" style="background: #c55a11; color: #fff;" value="Release Patient" onclick="doPatientRelease('<%=visit.getId()%>','opLite');" tabindex="1"/>
				<% } %>

<%if(lastVisit.getId()!=null && surgeryDetail.getPacRequest()!=null && surgeryDetail.getPacRequest().equalsIgnoreCase("y") && otPreAnesthesiaDetails.getId()!=null) {%>
				<input type="button" class="buttonAuto" value="PAC Status" style="background: #c55a11; color: #fff;" onclick="getPacStatus('<%=surgeryHdr.getId()%>','<%=surgeryHdr.getVisit().getId()%>','<%=otPreAnesthesiaDetails.getId()%>');" tabindex="1"/>
				
<%} %>

</div>
<div class="clear"></div>
</div>

<div id="inTab2" class="inTabcontent">

 <div class="Block">
         	<label>MLC certificate </label>
					 <select name="mlscasetype"	id="mlscasetype" multiple="multiple" class="multiple1" size="5" tabindex="1">
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
						 <input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" checked="checked" tabindex="1"/>Police Intimation
						 <%}else{ %>
						 	<input type="checkbox" class="radioCheckCol2"  id="policeIntimation"name="policeIntimation" tabindex="1"/>Police Intimation
						 <%} %>
					</label>

          <div class="clear"></div> 
			</div>
 
 <div class="clear"></div>
</div>

<div id="inTab10" class="inTabcontent">

<div class="clear"></div>
<div class="Block" style="padding-top:0;">

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
<label class="medium">Gender</label>
<label class="value" style="width:75px;"><%=gender%></label>
<div class="clear"></div>
<label>Comorbidity</label>
<%if(!comorbidityStr.equals("")){ %>
<label class="valueAuto" style="min-width:200px;"> <%=comorbidityStr %>  </label>
<%}else{ %>
<label class="valueAuto" style="min-width:200px;color:green;font-weight:bold;">  <%=majorHealthIssue %>  </label>
<%} %>
<div class="clear"></div> 
<div class="paddingTop5"></div> 
<div class="titleBg">
<h2>KNOW YOUR PATIENT</h2>
</div>


<div class="summaryDivMain">
<label>Diagnosis of Last Visit</label>
<div class="summaryDetails" style="height: 66px;"><pre><%=previousDiagnosis!=null?previousDiagnosis:""%></pre></div>
</div>



<div class="summaryDivMain">
<label>Family History</label>
<%if(familyHistoryStr!=""){ %>
<div class="summaryDetails" style="height: 66px;"><pre><%=familyHistoryStr %> </pre></div>
</div>
<%}else if(familyHistory.size()>0){ %>
<div class="summaryDetails" style="height: 66px;color:green;"><pre><%=familyHistory %> </pre></div>
</div>
<%}else{ %>
<div class="summaryDetails" style="height: 66px;"><pre> </pre></div>
</div>
<%} %>

<div class="summaryDivMain" style="margin-right:0px;">
<label>Second Opinion Remarks</label>
<div class="summaryDetails" style="height: 66px;"><pre><%=secondOpinoinComment %></pre></div>
</div>

<div class="clear"></div> 
<div class="paddingTop5"></div>

<div class="summaryDivMain"> 
<label>Medication History</label>
<div class="summaryDetails" style="height: 66px;"><pre><%=medicationHistoryStr %></pre></div>
</div> 

<div class="summaryDivMain">
<label>Past History</label><div class="clear"></div> 
<div class="summaryDetails" style="height: 66px;"><pre><%=pastHistoryStr %></pre></div>
</div>

<div class="summaryDivMain" style="margin-right:0px;">
<label>Doctor Refer</label>
<%if(opdPatientDetails!=null && opdPatientDetails.getReferedDepartment()!=null && opdPatientDetails.getReferedDepartment().getId().equals(deptId)){%>
<div class="summaryDetails" style="height:66px;">
<pre>Referred by Doctor : <%=opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getFirstName():"" %> </pre> 
<pre>Department From : <%=opdPatientDetails.getReferredDept()!=null?opdPatientDetails.getReferredDept().getDepartmentName():"" %></pre> 
<pre>Hospital From : <%=opdPatientDetails.getHospital()!=null?opdPatientDetails.getHospital().getHospitalName():"" %> </pre>
 <pre>Date : <%=opdPatientDetails.getOpdDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getOpdDate()):"" %> </pre> 
 <pre>Doctor Note : <%=opdPatientDetails.getReferralNotes()!=null?opdPatientDetails.getReferralNotes():"" %> </pre> 
 <pre>Patient Advice : <%=opdPatientDetails.getPatientAdvise()!=null?opdPatientDetails.getPatientAdvise():"" %></pre>
 <pre>Summary Consultation : <%=opdPatientDetails.getSummaryConsultation()!=null?opdPatientDetails.getSummaryConsultation():"" %> </pre>
 <%}else{ %>
 <div class="summaryDetails" style="height: 66px;">
 <pre></pre>
 <%} %>
</div>
</div>

<div class="clear"></div> 
<div class="paddingTop5"></div> 

<div class="summaryDivMain">
<label>Personal History</label>
<%if(!personalHistoryStr.equals("")){ %>
<div class="summaryDetails" style="height: 66px;"><pre><%=personalHistoryStr %></pre></div>
</div>
<%}else if(!personalPresentHistoryMember.equals("")){ %>
<div class="summaryDetails" style="height: 66px;color:green;"><pre><%=personalPresentHistoryMember %></pre></div>
</div>
<%}else{ %>
<div class="summaryDetails" style="height: 66px;"><pre></pre></div>
</div>
<%} %>


<div class="summaryDivMain">
<label>Allergies</label>
<div class="summaryDetails" style="height: 66px;"><p><%=allergyStr.length()>0 && allergyStr.charAt(allergyStr.length()-1)==','?allergyStr.substring(0,allergyStr.length()-1):allergyStr %></p></div>
</div>
<div class="clear"></div> 
<div class="paddingTop5"></div> 

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
</div>

<div class="clear"></div>
</div>

<div id="inTab3" class="inTabcontent">

<div id="historyDiv"></div>

<div class="clear"></div>

</div>

<div id="inTab4" class="inTabcontent">
<div class="Block" style="padding-top:0;">
4444444444444444444444444444444

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>

<div id="inTab5" class="inTabcontent">
<div class="Block" style="padding-top:0;">
55555555555555555555555555555555555555555

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>

<div id="inTab6" class="inTabcontent">
<div class="Block" style="padding-top:0;">
66666666666666666666666666666

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>

<div id="inTab7" class="inTabcontent">
<div class="Block" style="padding-top:0;">

7777777777777777777777777777777777777

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>



<div id="inTab8" class="inTabcontent">

<div id="AllergyDiv"></div>

<div class="clear"></div>
</div>



<div id="inTab9" class="inTabcontent">

<div id="NCDClinicDiv"></div>

<div class="clear"></div>
</div>



<div id="inTab12" class="inTabcontent">

<div id="LabResultDiv"></div>

<div class="clear"></div>
</div>

<!-- <div id="inTab13" class="inTabcontent">

<div id="FPISDetailDiv"></div>

<div class="clear"></div>
</div> -->

<!-- =======Inner tab end here====== -->





<table id="termTable" style="display: none;">
		<thead><tr><th>ConceptId</th><th>Terms</th><th>Type</th></tr></thead>
</table>
<input type="hidden" name="snomedCount" id="snomedCount" value="0"/>



<div id="vitalDialog" title="Vital Trends" style="display: none;">
	<label class="auto">UHID</label><input type="text" id="vitalUHID"
		class="auto" readonly="readonly" /><label class="auto">Patient	Name</label><input type="text" id="vitalPname" class="auto"
		readonly="readonly" />
	<div class="clear"></div>
	<table id="vitalTable"></table>
</div>
 <div style="display: none;">
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
<form action="" name="taperedForm" style="display: none;">
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
	
	<!-- By Srikanth Start-->
<div id="myModal" class="modal">

  <div class="modal-content" id="blockMedicineDiv">
    <span class="close" onclick="closePopUp();">&times;</span>
    <p id="blockMedicineMsg" style="color:red;font-weight: bold;"></p>
    <input type="hidden" id="blockMedicineTableId" name="blockMedicineTableId"  />
    <input type="hidden" id="incrementNum" />
    
    <input type="button"  value="UnBlock" onclick="unBlockMedicine();"  />
    <input type="button"  value="Cancel" onclick="closePopUp();"  />
  </div>

</div>

<!-- By Srikanth End-->

<style>

.preDivLeft{width:589px;float:left;min-height:126px;}
.preDivLeft label{width:auto; background:none;box-shadow:none;margin:0px; height:22px;}
.preDivLeft p{margin: 0px 0px 0px 5px;font-weight: bold;}
.preDivLeft textarea{width:570px; height:37px; margin-left:4px; overflow-x:hidden;resize:vertical;}

.preHisDiv {
	width: 272px;
	float: left;
}

.preHisDiv textarea {
	width: 257px;
	height: 47px;
	margin-left: 4px;
	overflow-x:hidden;resize:vertical;
}

.vitalsDivRight {width: 578px;float: left;}
.vitalsDivRight input.buttonAuto {float:left; margin-top:4px; font-size:11px; height: 20px; padding: 0px 6px; margin:7px 0px 0px 10px;}




.tabContWidth3 {width:384px; margin-right:5px; float:left;}
.tabContWidth3 label{width:375px; background:none;box-shadow:none; margin:0px 0px 0px 4px; background:#ffd966;}
.tabContWidth3 textarea { width:374px;height:45px; margin-left:4px; overflow-x:hidden;resize:vertical;}

.tabContWidth2 {
	width: 579px;
	margin-right: 5px;
	float: left;
}

.tabContWidth2 label {
	width: 572px;
	background: none;
	box-shadow: none;
	margin: 0px 0px 0px 4px;
	background: #ffd966;
}

.tabContWidth2 textarea {
	width: 571px;
	height:45px;
	margin-left: 4px;
	overflow-x:hidden;resize:vertical;
}

.tabContWidth6 {
	width: 166px;
	margin-right: 1px;
	float: left;
}

.tabContWidth6 label {
	width: 160px;
	background: none;
	box-shadow: none;
	margin: 0px 0px 0px 4px;
	text-align: center;
	background: #ffd966;
}

.tabContWidth6 textarea {
	width: 159px;
	height: 54px;
	margin-left: 4px;
	overflow-x:hidden;resize:vertical;
}

.plusTabeDiv {
	width: 120px;
	float: left;
	margin-top: 3px;
	margin-left: 5px;
}

.plusHideDiv {
	width: 435px;
	float: left;
}

.h2Text {
	line-height: 20px;
	font-size: 12px;
}

.divisionSolid {
	margin:0px 0px 2px 0px !important;
}

.invstHeadMainDiv {
	width: 417px;
	float: left;
	border-right: solid 2px #0f75bf;
	margin-right: 6px;
}

.invstHeadDiv {float:left; width:412px; padding-top:1px; background:#c5c4c4;}
.invstHeadDiv h2{line-height:20px;font-size:11px; text-indent:3px; width:100px;float:left; }
.invstHeadDiv label {font-size:11px!important; line-height:20px; margin:0px 1px; padding:0px 3px 0px 4px; height:20px;} 
.invstHeadDiv input.radioCheckCol2{margin:0px 3px; width:auto;}

.invstHeadMainDiv label.autoM {
	margin: 0px 2px;
	width: auto;
	padding-right:2px;
	font-size:11px;
}

.invstHeadMainDiv input.breCheck {
	margin: 0px 2px 0px 2px;
}

.prescrMainDiv {width:740px;float:left;}

.prescrHeadDiv {float:left; width:740px; padding-top:1px; background:#c5c4c4;}
.prescrHeadDiv h2{line-height:20px;font-size:11px; text-indent:3px; width:119px;float:left; }
.prescrHeadDiv label {font-size:11px!important; line-height:20px; margin:0px 1px; padding:0px 3px 0px 4px; height: 20px;} 
.prescrHeadDiv input.radioCheckCol2{margin:0px 3px; width:auto;}

.prescrHeadDiv input.addButSmll {
	margin: 0px;
}

.mltSelectDivLeft{width:115px; float:left; margin:0px 5px 0px 0px;}
.mltSelectDivLeft select {height:48px; width:115px; margin-left:0px; margin-bottom: 0px;}
.mltSelectDivLeft input.buttonAuto {font-size: 11px; padding:0px 4px;height: 20px; margin:4px 0px 0px 0px;}

.textNameDiv {width:266px; float: left;}



.mltSelectDiv{width:100px; float:left; margin:0px 5px 0px 0px;}
.mltSelectDiv select {height:56px; width:100px; margin:0px;}
.mltSelectDiv input.buttonAuto {font-size:9px; padding:0px 2px;height:20px; margin:4px 0px 0px 0px;}


.procduMainDiv {width:579px; float:left; border-right: solid 1px #0f75bf; padding-right: 5px;}
.procduTitleDiv {width: 579px; float: left; margin-right: 13px; background: #c5c4c4;}

.surProMainDiv {width: 576px; float: left;border-left: solid 1px #0f75bf;padding-left: 5px;}
.surProTitleDiv {width: 576px; float: left; background: #c5c4c4;}

.tableDiv {	width: 630px;float: left;}

.surProMainDiv table th, .tableDiv table th,
.textNameDiv table th,
.procduMainDiv table th {background: #bdd6ee; padding:0px; text-align:center; height: 18px;}

.surProMainDiv table td, .tableDiv table td,
.textNameDiv table td,
.procduMainDiv table td {padding: 0px 0px 1px 2px !important; height:24px;}

.procduMainDiv table td input, .surProMainDiv table td input, .surProMainDiv table td input.small,
.procduMainDiv table td input.textSmall,
.tableDiv table td input, .tableDiv table td input.opdTextBoxTSmall, 
.tableDiv table td input.textYellow, .textNameDiv table td input {height:18px; margin:0px;}

.procduMainDiv table td input:hover, .surProMainDiv table td input:hover, .surProMainDiv table td input.small:hover,
.tableDiv table td input:hover, .tableDiv table td input.opdTextBoxTSmall:hover, 
.tableDiv table td input.textYellow:hover {height:18px; margin:0px;}

.procduMainDiv table td select, .surProMainDiv table td select,
.tableDiv table td select, .tableDiv table td select.medium2 {height:21px!important; margin:0px;}


.adDelSmall {
	width:30px;
	float:right;
}

.mgmtDivMain {
	width:600px;
	float:left;
	padding-top:3px;
}

.mgmtDivMain input.buttonAuto {
	font-size: 11px;
	padding: 0px 6px;
	height: 20px;
}
.hisDivHide {
	display: none;
}

.historyTxtDiv { width: 64px; float: right; margin:7px 6px 0px 0px; }

.surProTitleDiv input.buttonPlusMinus, .adviceDivMain input.buttonPlusMinus,
.procduTitleDiv input.buttonPlusMinus {height: 19px; width: 18px;
float: right;
margin:0px;
padding:0px;
font-size:16px;
color:#000;
background:#83d9ff;
}

.adviceDivMain {width: 1168px; float: left; background: #c5c4c4; cursor:pointer;}

/*----blinking Css start------*/

.blink_me {
    -webkit-animation-name: blinker;
    -webkit-animation-duration: 1s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-iteration-count: infinite;
    
    -moz-animation-name: blinker;
    -moz-animation-duration: 1s;
    -moz-animation-timing-function: linear;
    -moz-animation-iteration-count: infinite;
    
    animation-name: blinker;
    animation-duration: 1s;
    animation-timing-function: linear;
    animation-iteration-count: infinite;
}

@-moz-keyframes blinker {  
    0% { opacity: 1.0; }
    25% { opacity: 0.0; }
    50% { opacity: 1.0; }
    75% { opacity: 1.0; }
    100% { opacity: 1.0; }
}

@-webkit-keyframes blinker {  
   0% { opacity: 1.0; }
    25% { opacity: 0.0; }
    50% { opacity: 1.0; }
    75% { opacity: 1.0; }
    100% { opacity: 1.0; }
}

@keyframes blinker {  
   0% { opacity: 1.0; }
    25% { opacity: 0.0; }
    50% { opacity: 1.0; }
    75% { opacity: 1.0; }
    100% { opacity: 1.0; }
}
/*----blinking Css end------*/

</style>


<script type="text/javascript">

function displayAdNo(id,opOrString,extPara,adVisitNo){
	//alert("id-->>"+id)
	document.getElementById('opOrId').value=id;
	document.getElementById('adVisitNo').value=adVisitNo;
	
	//alert("id -->>"+id);
	//alert("opOrString ----- --->>"+opOrString)
	if(opOrString =="0"){
		 	document.getElementById('opOrString').value ="IP"
			document.getElementById('hinId').value=0
    		obj =document.getElementById("detailId");
			obj.length = 0;
        	obj.length++;
			obj.options[obj.length-1].value="Admission"
			obj.options[obj.length-1].text="Admission";
			obj.length++;
		 
			obj.options[obj.length-1].value="Diagnostics"
				obj.options[obj.length-1].text="Case Note/Diagnosis";
				obj.length++;
			obj.options[obj.length-1].value="Prescriptions"
			obj.options[obj.length-1].text="Treatment";
			obj.length++;
			obj.options[obj.length-1].value="Investigation"
			obj.options[obj.length-1].text="Investigation";
			obj.length++;
			obj.options[obj.length-1].value="Procedures"
			obj.options[obj.length-1].text="Procedures";
		submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
	}else{
		document.getElementById('opOrString').value ="OP"
			document.getElementById('hinId').value=extPara
		obj =document.getElementById("detailId");
			obj.length = 0;
        	obj.length++;
			obj.options[obj.length-1].value="Visit"
			obj.options[obj.length-1].text="Visit";
			
			obj.length++;
			obj.options[obj.length-1].value="diag"
			obj.options[obj.length-1].text="Diagnosis";
			
			obj.length++;
			obj.options[obj.length-1].value="Investigation"
			obj.options[obj.length-1].text="Investigation";
		
			obj.length++;
			obj.options[obj.length-1].value="Prescriptions"
			obj.options[obj.length-1].text="Prescriptions";
			obj.length++;
			obj.options[obj.length-1].value="Procedures"
			obj.options[obj.length-1].text="Procedures";
			
			obj.length++;
			obj.options[obj.length-1].value="Vitals"
			obj.options[obj.length-1].text="Vitals";
			
			obj.length++;
			obj.options[obj.length-1].value="pre-opc"
			obj.options[obj.length-1].text="Pre-Consultation";
			
			obj.length++;
			obj.options[obj.length-1].value="examination"
			obj.options[obj.length-1].text="Examination";
			
			
			submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&currentVisitId='+<%=visitId%>+'&opOrString='+document.getElementById('opOrString').value+'&detailId=Visit'+'&id='+document.getElementById('opOrId').value+'&visitId ='+id+'&adVisitNo='+document.getElementById('adVisitNo').value);
	}
}

function getAdVisitDetails(){
	
	if(document.getElementById('detailId').value =="Admission"){

			submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
	}
		submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&opOrString='+document.getElementById('opOrString').value+'&detailId='+document.getElementById('detailId').value+'&id='+document.getElementById('opOrId').value+'&hinId='+document.getElementById('hinId').value+'&adVisitNo='+document.getElementById('adVisitNo').value)
	}
	
function displayCaseSheetReport(visitId,visitNo,hospital){
	submitForm('patientAndAdDetailsGrid','/hms/hms/opd?method=showPatientMedicalCaseSheetReportNew&visitId='+visitId+'&visitNo='+visitNo+'&hospitalId='+hospital);
}

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	var hinId= document.getElementById("hinId").value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.getElementById("flag").value="y";
	/* document.attachFile.method="post"; */
	submitForm('attachFile','opd?method=uploadAndViewDocuments&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue);
	
}

jQuery(function ($) {
	$("#vitalTrends").click(function(){
		var hinId=document.getElementById("hinId").value;
		var memberId=document.getElementById("memberId").value;
		new Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId+'&memberId='+memberId+'&'+csrfTokenName+'='+csrfTokenValue, {
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
	
}); 

<%if(visit!=null && visit.getVisitNo()>1) {%>
var tabcontent = document.getElementsByClassName("inTabcontent");
for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
}
document.getElementById('inTab10').style.display = "block";
document.getElementById('inTab10').className.replace("inActive", "");
//openCity(event, 'inTab10');
<%} %>


function resetAll(){
	document.getElementById("opdMain").reset();
}

function validatePrescriptionAutocompleteForTemplate(strValue, inc, rowObj) {
	
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var drug =  strValue.substring(0,  strValue.lastIndexOf("(")-1);
		var count = document.getElementById('hdb').value;
		if (id == "") {
			document.getElementById('nomenclature' + inc).value = "";
			return;
		}
		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclature' + i) != null
					&& document.getElementById('nomenclature' + i).value == strValue
					&& i != inc) {
				if (document.getElementById('tapered' + i) != null
						&& document.getElementById('tapered' + i).value != 'y') {
					/* alert(drug+' is already selected.'); */
					document.getElementById('nomenclature' + i).value = "";
					removeRowForOpdLite(document.getElementById('nomenclature' + i),'prescription','template');
					return false;
				}
			}
		}
		return true;
	}
	
function showParkPatient(status) {
	document.opdMain.action = "/hms/hms/opd?method=showNewOPWaitingList&flag="
			+ status+"&opdType=opdLite";
	document.opdMain.submit();
}

//Added By Om Tripathi 15/01/2018
	var today = new Date();
	today.setHours(0,0,0,0);
	function checkTentativeDates(){
		
		var total = document.getElementById('surgeryhdb').value;
		  for (var i = 0; i <= total; i++) {
			  var splitDate = document.getElementById("tentativeDate"+i).value.split("/");
				var refDate = new Date(splitDate[2]+" "+splitDate[1]+" "+splitDate[0]);
				if (refDate <= today)
					{
					 alert('Must enter a future date')
					document.getElementById("tentativeDate"+i).value = ""; 
					 document.getElementById("tentativeDate"+i).focus();
					 return false;
					}
				return true;
		  }
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
		e1.tabIndex = '1';
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
		e1.tabIndex = '1';
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
		e1.tabIndex = '1';
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
		e1.tabIndex = '1';
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
		e21Div.style = 'width:95px; float: left;';
		
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.maxLength = "3";
		e1.name = 'noOfDaysOut' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.id = 'noOfDaysOut' + iteration;
		e1.size = '3';
		e1.maxLength = "3";
		e1.tabIndex = '1';
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
		e1.tabIndex = '1';
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
		e1.tabIndex ='1';
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
			
			var flag = 0;
			for (var i = 0; i <= iteration; i++) {
				if (document.getElementById("itemRadios" + i) != null
						&& (typeof document.getElementById("itemRadios" + i).checked) != 'undefined'
						&& document.getElementById("itemRadios" + i).checked) {
					jQuery(function($) {
						if (document.getElementById("parkOutPrescriptionIds" + i) != null) {
							var ids = document.getElementById("parkOutPrescriptionIds"
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
	
	function pacRequesting(increment){
		if(document.getElementById("chkpacNeed"+increment).checked){
			document.getElementById("chkpacNeed"+increment).value="y";
		}else{
			document.getElementById("chkpacNeed"+increment).value="n";
		}
		
	}
	
	function checkForBlockedMedicine(val, inc) {
		// alert(val+"<<<-------val======inc------>>"+inc);
		var visitId = document.getElementById("visitId").value;
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
			var url = "/hms/hms/opd?method=checkForBlockedMedicine&val=" + val
					+ "&visitId=" + visitId + "&" + csrfTokenName + "="
					+ csrfTokenValue;
			xmlHttp.open("GET", url, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
		}
	}

	function closePopUp(){
		var incr=document.getElementById("incrementNum").value;
		var val=document.getElementById("nomenclature"+incr).value;
		document.getElementById("nomenclature"+incr).value="";
		var modal = document.getElementById('myModal');
		modal.style.display = "none";
		
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
