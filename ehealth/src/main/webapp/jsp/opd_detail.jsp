<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page
	import="jkt.hms.masters.business.OpdGeneralSurgeryPrevSpeciality"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.OpdGeneralProformaDetail"%>
<%@page import="jkt.hms.masters.business.OpdGeneralProformaHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DepartmentRefset"%>
<%@page import="jkt.hms.masters.business.ChildExpectedWtHtChart"%>
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
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OtPreAnesthesiaDetails"%>
<%@page import="jkt.hms.masters.business.ExternalLabReportCommon"%>
<%@page import="jkt.hms.masters.business.CommonLabTestReport"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.ComparatorForLabTestDate"%>



<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="/hms/jsp/js/newTab.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/prescription.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phototherapyProformaJs.js"></script>
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
<script type="text/javascript" src="/hms/jsp/js/opd_LP.js"></script>
<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>


<script type="text/javascript" src="/hms/jsp/js/djaodjin-annotate.js"></script>




<script type="text/javascript">
		   var icdArray=new Array();
		   var frequencyArray=new Array();
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
		    //minLength: 3,
		    search: function() {
		        // custom minLength
		        var term = extractLast( this.value );
		        if ( term.length < 3 ) {
		            return false;
		        }
		    },
			source: function( request, response ) {
	            // delegate back to autocomplete, but extract the last term
				var arTerm=request.term.split(",");
				var searchTerm=arTerm[arTerm.length-1].trim();
				console.log("terms :: "+searchTerm);
				servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
				var refsetidParam = document.getElementById('refsetId').value;
				
				
				var fieldType = $(this.element).prev().text().replace(/\s+/g," ");
				servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
				if(fieldType=='Provisional Diagnosis' || fieldType=='Final Diagnosis' || fieldType=='Differential Diagnosis' ){
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
	       		if(fieldType=='Provisional Diagnosis' || fieldType=='Final Diagnosis' || fieldType=='Differential Diagnosis' ){
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
	       			else if(fieldType=='Differential Diagnosis'){
	       				removeDiagnosisId="snomed";
	       				diagnosis_status='d';}
	       			/* if(document.getElementById("diagnosis_status").value!="" &&document.getElementById("diagnosis_status").value!=diagnosis_status)
       				{	document.getElementById(removeDiagnosisId).value='';
       			           $("#diagnosisId option").remove();
       			        $("#snomedList option").remove();
       			        
       				} */
	       		  document.getElementById("diagnosis_status").value=diagnosis_status;
	       			
	       			getICDListBasedOnSnomedId(ui.item.label,diagnosis_status);
	       		 this.value = terms.join( "," );
	       		//return false;
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
	
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String getDate = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (getDate.length() < 2) {
				getDate = "0" + getDate;
			}%>
	serverdate = '<%=getDate + "/" + month + "/" + year%>';
</script>

<script>
    function showhide(buttonId)
     {
		 if(buttonId=="button1"){
					//test(buttonId,"newpost1");
					test('realted'+buttonId,"newpost1");
		 }
		 else if(buttonId=="button2"){
					test(buttonId,"newpost2");
		 }else if(buttonId=="button3"){
					test(buttonId,"newpost3");
		 }
	 }
	function test(buttonId,newpost){
			 var x = document.getElementById(newpost);
				if (x.style.display != "block") {
					x.style.display = "block";
					document.getElementById(buttonId).value="-"
				}
				else {
					x.style.display = "none";
					document.getElementById(buttonId).value="+"
				}	 
	}
	 
  </script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Visit> patientDataList = null;
	int opCallCount = 0;
	if (map.get("patientDataList") != null) {
		patientDataList = (List) map.get("patientDataList");
	}
	Visit visit = null;
	if (patientDataList.size() > 0) {
		visit = (Visit) patientDataList.get(0);
	}
	List<MasRelation> relationList = new ArrayList<MasRelation>();

	if (map.get("relationList") != null) {
		relationList = (List<MasRelation>) map.get("relationList");
	}
	List<OpdTemplate> templateListForInvestigation = new ArrayList<OpdTemplate>();
	if (map.get("templateListForInvestigation") != null) {
		templateListForInvestigation = (List) map.get("templateListForInvestigation");
	}
	List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
	if (map.get("routeOfAdministrationList") != null) {
		routeOfAdministrationList = (List<RouteOfAdministration>) map.get("routeOfAdministrationList");
	}
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if (map.get("frequencyList") != null) {
		frequencyList = (List) map.get("frequencyList");
	}
	List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
	if (map.get("masInstructionMasterList") != null) {
		masInstructionMasterList = (List<OpdInstructionTreatment>) map.get("masInstructionMasterList");
	}
	List<MasDepartment> wardDepartmentList = new ArrayList<MasDepartment>();
	if (map.get("wardDepartment") != null) {
		wardDepartmentList = (List<MasDepartment>) map.get("wardDepartment");
	}
	List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
	if (map.get("masDistricts") != null) {
		masDistrictList = (List<MasDistrict>) map.get("masDistricts");
	}
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	if (map.get("hospitalTypeList") != null) {
		hospitalTypeList = (List<MasHospitalType>) map.get("hospitalTypeList");
	}
	List<Object[]> masHospitals = new ArrayList<Object[]>();
	if (map.get("masHospitals") != null) {
		masHospitals = (List<Object[]>) map.get("masHospitals");
	}
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	if (map.get("deptList") != null) {
		deptList = (List) map.get("deptList");
	}

	List<DgOrderdt> dgOrderdts = new ArrayList<DgOrderdt>();
	if (map.get("dgOrderdts") != null) {
		dgOrderdts = (List<DgOrderdt>) map.get("dgOrderdts");
	}

	List<DgSampleCollectionDetails> dgSampleCollectionDetails = new ArrayList<DgSampleCollectionDetails>();
	if (map.get("dgSampleCollectionDetails") != null) {
		dgSampleCollectionDetails = (List<DgSampleCollectionDetails>) map.get("dgSampleCollectionDetails");
	}
	List<PatientInvestigationDetails> patientInvestigationDetails = new ArrayList<PatientInvestigationDetails>();
	if (map.get("patientInvestigationDetails") != null) {
		patientInvestigationDetails = (List<PatientInvestigationDetails>) map
				.get("patientInvestigationDetails");
	}

	List<PatientPrescriptionDetails> patientPrescriptionDetails = new ArrayList<PatientPrescriptionDetails>();
	if (map.get("patientPrescriptionDetails") != null) {
		patientPrescriptionDetails = (List) map.get("patientPrescriptionDetails");
	}

	Set<Integer> availStockItemIdSet = new HashSet<Integer>();
	if (map.get("availStockItemIdSet") != null) {
		availStockItemIdSet = (Set<Integer>) map.get("availStockItemIdSet");
	}
	Set<Integer> availableInvesStatus = new HashSet<Integer>();
	if (map.get("availableInvesStatus") != null) {
		availableInvesStatus = (Set<Integer>) map.get("availableInvesStatus");
	}
	List<ProcedureDetails> procedureDetails = new ArrayList<ProcedureDetails>();
	if (map.get("procedureDetails") != null) {
		procedureDetails = (List<ProcedureDetails>) map.get("procedureDetails");
	}
	List<OpdSurgeryDetail> opdSurgeryDetails = new ArrayList<OpdSurgeryDetail>();
	if (map.get("opdSurgeryDetails") != null) {
		opdSurgeryDetails = (List<OpdSurgeryDetail>) map.get("opdSurgeryDetails");
	}

	List<MasStoreOutItem> masStoreOutItemsList = new ArrayList<MasStoreOutItem>();
	if (map.get("masStoreOutItemsList") != null) {
		masStoreOutItemsList = (List<MasStoreOutItem>) map.get("masStoreOutItemsList");
	}

	List<String> patientWiseMlcs = new ArrayList<String>();
	List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
	List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
	if (map.get("patientWiseMlcs") != null) {
		patientWiseMlcs = (List) map.get("patientWiseMlcs");
	}

	if (map.get("allergyProductsList") != null) {
		allergyProductsList = (List) map.get("allergyProductsList");
	}

	if (map.get("saverityCodesList") != null) {
		saverityCodesList = (List) map.get("saverityCodesList");
	}

	List<PatientPrescriptionDetails> patientOtherPrescriptionDetails = new ArrayList<PatientPrescriptionDetails>();
	if (map.get("patientOtherPrescriptionDetails") != null) {
		patientOtherPrescriptionDetails = (List<PatientPrescriptionDetails>) map
				.get("patientOtherPrescriptionDetails");
	}
	List<DgResultEntryHeader> labResultForLeprosyPerformaList = new ArrayList<DgResultEntryHeader>();

	if (map.get("labResultForLeprosyPerforma") != null) {
		labResultForLeprosyPerformaList = (List) map.get("labResultForLeprosyPerforma");
	}

	String departmentCode = null;
	if (map.get("departmentCode") != null) {
		departmentCode = (String) map.get("departmentCode");
	}
	String empDeptCode = "";
	if (map.get("empDeptCode") != null) {
		empDeptCode = (String) map.get("empDeptCode");
	}

	String deptName = "";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}

	List<DepartmentRefset> deptRefsetList = null;
	if (map.get("deptRefsetList") != null) {
		deptRefsetList = (List<DepartmentRefset>) map.get("deptRefsetList");
	}

	OpdPatientDetails opdPatientDetails = null;
	String lastEncounterDetail = "";
	Integer opdpatientDetailId = 0;
	int referredDept = 0;
	int referralDept = 0;
	int referralHospital = 0;
	int referralDistrict = 0;
	String referralType = "NA";
	String deptNameforExternal = "NA";
	String deptNameDoctorName = "";
	int deptNameDoctorId = 0;
	if (map.get("opdPatientDetails") != null) {
		opdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
		opdpatientDetailId = opdPatientDetails.getId();
		referralDept = opdPatientDetails.getReferredDept() != null
				? opdPatientDetails.getReferredDept().getId()
				: 0;
		referralHospital = opdPatientDetails.getHospital().getId();
		referralDistrict = opdPatientDetails.getReferedDistrict() != null
				? opdPatientDetails.getReferedDistrict().getId()
				: 0;
		referralType = opdPatientDetails.getReferredType() != null ? opdPatientDetails.getReferredType() : "NA";
		deptNameforExternal = opdPatientDetails.getReferredDept() != null
				? opdPatientDetails.getReferredDept().getDepartmentName()
				: "NA";
		referredDept = opdPatientDetails.getReferedDepartment() != null
				? opdPatientDetails.getReferedDepartment().getId()
				: 0; //Added by Arbind on 15-03-2017
		deptNameDoctorId = opdPatientDetails.getEmployee() != null
				? opdPatientDetails.getEmployee().getId()
				: 0;
		deptNameDoctorName = opdPatientDetails.getEmployee() != null
				? opdPatientDetails.getEmployee().getEmployeeName()
				: "";
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalTypeId = 0;
	if (map.get("hospitalTypeId") != null) {
		hospitalTypeId = (Integer) map.get("hospitalTypeId");
	}
	int districtId = 0;
	if (map.get("districtId") != null) {
		districtId = (Integer) map.get("districtId");
	}
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	if (map.get("bloodGroupList") != null) {
		bloodGroupList = (List) map.get("bloodGroupList");
	}
	String bloodGroupValue = "";
	if (map.get("bloodGroupValue") != null) {
		bloodGroupValue = ((String) map.get("bloodGroupValue")).trim();
	}
	String bloodGroupStatus = "";
	if (map.get("bloodGroupStatus") != null) {
		bloodGroupStatus = (String) map.get("bloodGroupStatus");
	}

	List<DischargeIcdCode> dischargeIcdCodeLast3Visit = new ArrayList<DischargeIcdCode>();
	if (map.get("dischargeIcdCodeLast3Visit") != null) {
		dischargeIcdCodeLast3Visit = (List<DischargeIcdCode>) map.get("dischargeIcdCodeLast3Visit");
	}
	if (map.get("allergyProductsList") != null) {
		allergyProductsList = (List) map.get("allergyProductsList");
	}

	if (map.get("saverityCodesList") != null) {
		saverityCodesList = (List) map.get("saverityCodesList");
	}

	List<OpdPatientAllergyT> opdPatientAllergyTs = new ArrayList<OpdPatientAllergyT>();
	if (map.get("opdPatientAllergyTs") != null) {
		opdPatientAllergyTs = (List<OpdPatientAllergyT>) map.get("opdPatientAllergyTs");
	}

	List<Object[]> previousDetailList = new ArrayList<Object[]>();
	List<Object[]> previousPrescriptionList = new ArrayList<Object[]>();
	List<Object[]> previousInvestigationList = new ArrayList<Object[]>();
	List<Object[]> previousDiagnosisList = new ArrayList<Object[]>();
	List<Object[]> previousProcedureList = new ArrayList<Object[]>();
	String loggedInDeptName = null;
	Map<Date, String> previousInvestigationHashMap = null;
	if (map.get("previousInvestigationHashMap") != null) {
		previousInvestigationHashMap = (Map<Date, String>) map.get("previousInvestigationHashMap");
	}
	if (map.get("previousDetailList") != null) {
		previousDetailList = (List<Object[]>) map.get("previousDetailList");
	}
	if (map.get("previousPrescriptionList") != null) {
		previousPrescriptionList = (List<Object[]>) map.get("previousPrescriptionList");
	}
	if (map.get("previousInvestigationList") != null) {
		previousInvestigationList = (List<Object[]>) map.get("previousInvestigationList");
	}
	if (map.get("previousDiagnosisList") != null) {
		previousDiagnosisList = (List<Object[]>) map.get("previousDiagnosisList");
	}
	if (map.get("previousProcedureList") != null) {
		previousProcedureList = (List<Object[]>) map.get("previousProcedureList");
	}

	if (map.get("loggedInDeptName") != null) {
		loggedInDeptName = (String) map.get("loggedInDeptName");
	}
	ChildExpectedWtHtChart childExpectedHW = null;
	if (map.get("childExpectedHW") != null) {
		childExpectedHW = (ChildExpectedWtHtChart) map.get("childExpectedHW");
	}

	List<OpdGeneralSurgeryPrevSpeciality> opdGeneralSurgeryPrevSpeciality = new ArrayList<OpdGeneralSurgeryPrevSpeciality>();
	if (map.get("opdGeneralSurgeryPrevSpeciality") != null) {
		opdGeneralSurgeryPrevSpeciality = (List<OpdGeneralSurgeryPrevSpeciality>) map
				.get("opdGeneralSurgeryPrevSpeciality");
	}

	int hinId = 0;
	int visitId = 0;
	if (visit != null) {
		hinId = visit.getHin().getId();
		visitId = visit.getId();
	}
	Integer pulse = 0;
	Float temperature = 0f;
	String bpSystolicDiastolic = "";
	Float bmi = 0f;
	Float respirtoryRate = 0f;
	Float spo2 = 0f;
	String bmiStatus = "";
	Double height = 0.0;
	Double weight = 0.0;
	String stuning = null;
	String pem = null;
	String wasting = null;
	String mac = null;
	String presentComplaintHistory = "";
	String personalPresentHistory = "";
	String familyPastHistory = "";
	String physicalExamination = "";
	String madicationHistory = "";
	String[] parts = {"", ""};
	String noSysDias = "";
	String treatmentPlan = null;
	String deferredDiagnosis = null;
	String surgeryHistory = null;
	String medicationhistory = null;
	String earExamination = null;
	String nosePnsExamination = null;
	String oralCavityThroatExamination = null;
	String neckExamination = null;
	String developmentHistory = null;
	String dietHistory = null;
	String socioEconomicHistory = null;
	String pastHistory = null;
	String menstrualHistory = null;
	String obstreticHistory = null;
	String managementPlan = null;
	String nonPharmacological = null;
	String antenatalHistory = null;
	String extraOralExamination = null;
	String intraOralExamination = null;
	String chairSideInvestigations = null;
	String orderingProcedure = null;
	OpdPatientDetails preOpdPatientDetails = new OpdPatientDetails();
	OpdPatientHistory preOpdPatientHistory = new OpdPatientHistory();
	if (map.get("opdPatientDetails") != null) {
		preOpdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
		opdpatientDetailId = preOpdPatientDetails.getId();
		pulse = preOpdPatientDetails.getPulse() != null ? preOpdPatientDetails.getPulse() : 0;
		temperature = preOpdPatientDetails.getTemperature() != null
				? preOpdPatientDetails.getTemperature()
				: 0f;
		bpSystolicDiastolic = preOpdPatientDetails.getBp() != null ? preOpdPatientDetails.getBp() : "";
		if (!bpSystolicDiastolic.equals("") && bpSystolicDiastolic.indexOf("/") != -1) {
			parts = bpSystolicDiastolic.split("/");
		}

		bmi = preOpdPatientDetails.getBmi() != null ? preOpdPatientDetails.getBmi() : 0f;
		height = preOpdPatientDetails.getHeight() != null ? preOpdPatientDetails.getHeight() : 0.0;
		weight = preOpdPatientDetails.getWeight() != null ? preOpdPatientDetails.getWeight() : 0.0;
		respirtoryRate = preOpdPatientDetails.getRespiratoryRate() != null
				? preOpdPatientDetails.getRespiratoryRate()
				: 0;
		spo2 = preOpdPatientDetails.getSpo2() != null ? preOpdPatientDetails.getSpo2() : 0;
		stuning = preOpdPatientDetails.getStuning() != null ? preOpdPatientDetails.getStuning() : null;
		pem = preOpdPatientDetails.getPem() != null ? preOpdPatientDetails.getPem() : null;
		wasting = preOpdPatientDetails.getWasting() != null ? preOpdPatientDetails.getWasting() : null;
		mac = preOpdPatientDetails.getMac() != null ? preOpdPatientDetails.getMac() : "";
		if (bmi > 0) {
			if (bmi < 18.5) {
				bmiStatus = "Underweight";
			} else if (bmi >= 18.5 && bmi < 25) {
				bmiStatus = "Healthy Range";
			} else if (bmi >= 25 && bmi <= 30) {
				bmiStatus = "Overweight";
			} else if (bmi >= 30 && bmi <= 35) {
				bmiStatus = "Obese";
			} else if (bmi > 35) {
				bmiStatus = "Severely obese";
			}
		}
		treatmentPlan = preOpdPatientDetails.getTreatmentPlan();
		nonPharmacological = preOpdPatientDetails.getNonPharmacological();
		deferredDiagnosis = preOpdPatientDetails.getDeferredDiagnosis();
		extraOralExamination = preOpdPatientDetails.getExtraOralExamination();
		intraOralExamination = preOpdPatientDetails.getIntraOralExamination();
		chairSideInvestigations = preOpdPatientDetails.getChairSideInvestigations();
		orderingProcedure = preOpdPatientDetails.getOrderingProcedureFindings();

		if (opdPatientDetails.getVisit().getId().equals(visitId)) {
			earExamination = opdPatientDetails.getEarExamination();
			nosePnsExamination = opdPatientDetails.getNosePnsExamination();
			oralCavityThroatExamination = opdPatientDetails.getOralCavityThroatExamination();
			neckExamination = opdPatientDetails.getNeckExamination();
			managementPlan = opdPatientDetails.getManagementPlan();
		}
	}
	String opdPatientHistoriesStr = "";
	if (map.get("preOpdPatientHistory") != null) {
		preOpdPatientHistory = (OpdPatientHistory) map.get("preOpdPatientHistory");
		presentComplaintHistory = preOpdPatientHistory.getPresentComplaintHistory() != null
				? preOpdPatientHistory.getPresentComplaintHistory().replace(",", "\n")
				: "";
		personalPresentHistory = preOpdPatientHistory.getPersonalPresentHistory() != null
				? preOpdPatientHistory.getPersonalPresentHistory().replace(",", "\n")
				: "";
		familyPastHistory = preOpdPatientHistory.getFamilyPastHistory() != null
				? preOpdPatientHistory.getFamilyPastHistory().replace(",", "\n")
				: "";
		madicationHistory = preOpdPatientHistory.getMadicationHistory() != null
				? preOpdPatientHistory.getMadicationHistory().replace(",", "\n")
				: "";
		opdPatientHistoriesStr = preOpdPatientHistory.getPastIllnessHistory() != null
				? preOpdPatientHistory.getPastIllnessHistory().replace(",", "\n")
				: "";
		physicalExamination = preOpdPatientHistory.getPhysicalExamination() != null
				? preOpdPatientHistory.getPhysicalExamination().replace(",", "\n")
				: "";
		surgeryHistory = preOpdPatientHistory.getSurgicalHistory() != null
				? preOpdPatientHistory.getSurgicalHistory()
				: "";
		medicationhistory = preOpdPatientHistory.getMadicationHistory() != null
				? preOpdPatientHistory.getMadicationHistory()
				: "";
		developmentHistory = preOpdPatientHistory.getDevelopmentHistory();
		dietHistory = preOpdPatientHistory.getDietHistory();
		socioEconomicHistory = preOpdPatientHistory.getSocioEconomicHistory();
		pastHistory = preOpdPatientHistory.getPastHistory();
		menstrualHistory = preOpdPatientHistory.getMenstrualHistory();
		obstreticHistory = preOpdPatientHistory.getObstreticHistory();
		antenatalHistory = preOpdPatientHistory.getAntenatalHistory() != null
				? preOpdPatientHistory.getAntenatalHistory()
				: "";

	} else if (map.get("majorHealthIssue") != null) {
		presentComplaintHistory = (String) map.get("majorHealthIssue");
	}
	String personalPresentHistoryMember = "";
	String majorHealthIssue = "";
	boolean ncd = false;
	List<PhMemberSurvey> phMemberSurveyList = new ArrayList<PhMemberSurvey>();
	List<PhDiseaseRegistration> phNCDRegList = new ArrayList<PhDiseaseRegistration>();
	if (map.get("phMemberSurveyList") != null) {
		phMemberSurveyList = (List<PhMemberSurvey>) map.get("phMemberSurveyList");

		if (phMemberSurveyList.size() > 0) {
			PhMemberSurvey phMs = new PhMemberSurvey();
			phMs = phMemberSurveyList.get(0);
			majorHealthIssue = phMs.getMajorHealthIssue() != null ? phMs.getMajorHealthIssue() : "";
			//Added by Arbind on 15-11-2017
			if (preOpdPatientHistory.getPersonalPresentHistory() != null
					&& preOpdPatientHistory.getPersonalPresentHistory().contains("Tobacco Use--")) {

			} else {
				personalPresentHistoryMember = phMs.getTobaccoUse() != null
						? "Tobacco Use--" + phMs.getTobaccoUse() + " "
						: "";
				personalPresentHistoryMember += phMs.getTobaccoType() != null
						&& !phMs.getTobaccoType().equals("") ? "Type--" + phMs.getTobaccoType() : "";
				personalPresentHistoryMember += phMs.getAlcoholUse() != null
						? "\nAlcohol Use--" + phMs.getAlcoholUse()
						: "";
				personalPresentHistoryMember += phMs.getDiet() != null && !phMs.getDiet().equals("Select")
						&& !phMs.getDiet().equals(" Select") ? "\nDiet--" + phMs.getDiet() : "";
				if (map.get("phNCDRegList") != null) {
					phNCDRegList = (List<PhDiseaseRegistration>) map.get("phNCDRegList");
					if (phNCDRegList.size() > 0) {
						PhDiseaseRegistration phNcd = new PhDiseaseRegistration();
						phNcd = phNCDRegList.get(0);
						ncd = true;
						personalPresentHistoryMember += phNcd.getDiagnosis() != null
								? "\nNCD Diagnosis--" + phNcd.getDiagnosis()
								: "";
						personalPresentHistoryMember += phNcd.getOtherDiagnosis() != null
								? " " + phNcd.getOtherDiagnosis()
								: "";
						personalPresentHistoryMember += phNcd.getDiagnosisType() != null
								? " " + phNcd.getDiagnosisType()
								: "";
					}
				}
			}
		}
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String consultationDate = (String) utilMap.get("currentDate");
	String consultationTime = (String) utilMap.get("currentTime");

	int deptIdSession = 0;
	if (session.getAttribute("deptId") != null) {
		deptIdSession = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int docId = 0;
	if (session != null) {
		docId = (Integer) session.getAttribute("empId");
	}
	int OrderId = 0;
	if (map.get("OrderId") != null) {
		OrderId = (Integer) map.get("OrderId");
	}
	String uhid = null;
	String patientName = "";
	String age = "";
	int pedAge = 0;
	int patientAge = 0;
	String gender = "";
	String yearMonth = "";
	String comorbidity = "";
	String patientRsbyCardNo = "";
	if (visit.getHin().getRsbyCardNo() != null && !visit.getHin().getRsbyCardNo().trim().equals("")) {
		patientRsbyCardNo = visit.getHin().getRsbyCardNo();
	}

	uhid = visit.getHin().getHinNo();
	if (visit.getHin().getPFirstName() != null) {
		patientName = visit.getHin().getPFirstName();
	}
	if (visit.getHin().getPMiddleName() != null) {
		patientName = patientName + " " + visit.getHin().getPMiddleName();
	}
	if (visit.getHin().getPLastName() != null) {
		patientName = patientName + " " + visit.getHin().getPLastName();
	}
	if (visit.getHin().getAge() != null) {
		age = !visit.getHin().getAge().equals("") ? visit.getHin().getAge() : "";
		if (age.length() > 0) {
			patientAge = Integer.parseInt(age.split(" ")[0]);
		}
	}
	if (visit.getHin().getDateOfBirth() != null) {
		Date dob = visit.getHin().getDateOfBirth();
		String ymd = HMSUtil.calculateYearMonthDay(dob);
		String d[] = ymd.split("&");

		int year1 = Integer.parseInt(d[0].toString());
		pedAge = year1;
		int months1 = Integer.parseInt(d[1].toString());
		int days1 = Integer.parseInt(d[2].toString());
		yearMonth = year1 != 0 ? d[0] + " Y " : "";
		yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
		yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
	}
	if (visit.getHin().getSex() != null) {
		gender = visit.getHin().getSex().getAdministrativeSexName();
	}

	if (visit != null && visit.getOpCallCount() != null) {
		opCallCount = visit.getOpCallCount();
	}

	String display = "none";
	if (visit.getHin().getSex() != null && visit.getHin().getSex().getAdministrativeSexCode().equals("F")
			&& visit.getHin().getSex().getId() == 2) {
		display = "block";
	}
	String visitDateInString = HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	int deptId = visit.getDepartment().getId();
	if (preOpdPatientHistory != null) {
		comorbidity = preOpdPatientHistory.getComorbidityHistory();
	}
	String dead = null, patientDeadStatus = null, mortuaryStatus = null;

	if (opdPatientDetails != null && opdPatientDetails.getPatientStatus() != null
			&& opdPatientDetails.getPatientStatus().equalsIgnoreCase("expire"))
		dead = "y";
	if (dead != null && opdPatientDetails.getPatientDeathStatus() != null) {
		patientDeadStatus = opdPatientDetails.getPatientDeathStatus();
	}
	if (dead != null && opdPatientDetails.getSiftedForMortuary() != null
			&& opdPatientDetails.getSiftedForMortuary().equalsIgnoreCase("y")) {
		mortuaryStatus = opdPatientDetails.getSiftedForMortuary();
	}

	/* Srikanth Start */
	Visit lastVisit = new Visit();
	if (map.get("previousVisit") != null) {
		lastVisit = (Visit) map.get("previousVisit");
	}
	OpdSurgeryHeader surgeryHdr = new OpdSurgeryHeader();
	if (map.get("opdSurgeryHdr") != null) {
		surgeryHdr = (OpdSurgeryHeader) map.get("opdSurgeryHdr");
	}

	OpdSurgeryDetail surgeryDetail = new OpdSurgeryDetail();
	if (map.get("opdSurgeryDtl") != null) {
		surgeryDetail = (OpdSurgeryDetail) map.get("opdSurgeryDtl");
	}
	OtPreAnesthesiaDetails otPreAnesthesiaDetails = new OtPreAnesthesiaDetails();
	if (map.get("otPreAnesthesiaDetails") != null) {
		otPreAnesthesiaDetails = (OtPreAnesthesiaDetails) map.get("otPreAnesthesiaDetails");
	}

	List<DgResultEntryHeader> internalLablistNephro = new ArrayList<DgResultEntryHeader>();
	List<ExternalLabReportCommon> externalLabListNephro = new ArrayList<ExternalLabReportCommon>();
	if (map.get("internalLabTestList") != null) {
		internalLablistNephro = (List) map.get("internalLabTestList");
	}

	if (map.get("externalLabTestList") != null) {
		externalLabListNephro = (List) map.get("externalLabTestList");
	}

	if (map.get("externalLabTestList") != null) {
		externalLabListNephro = (List) map.get("externalLabTestList");
	}
	// Lab test 

	List<CommonLabTestReport> commonLabTestReports = new ArrayList<CommonLabTestReport>();

	if (internalLablistNephro.size() > 0) {

		for (DgResultEntryHeader dgResultEntryHeaderFirstTrim : internalLablistNephro) {
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();

			if (dgResultEntryHeaderFirstTrim.getDgResultEntryDetails().size() > 0) {
				dgResultEntryDetail = dgResultEntryHeaderFirstTrim.getDgResultEntryDetails().iterator().next();
				commonLabTestReport.setDgId((Integer) dgResultEntryDetail.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getId());
			}

			commonLabTestReport.setInvestigationId(dgResultEntryHeaderFirstTrim.getInvestigation().getId());
			commonLabTestReport.setResultDate(dgResultEntryHeaderFirstTrim.getResultDate().toString());
			commonLabTestReport
					.setTestName(dgResultEntryHeaderFirstTrim.getInvestigation().getInvestigationName());
			commonLabTestReport.setTestType("Internal Test");
			commonLabTestReports.add(commonLabTestReport);
		}

	}

	int labResultSize = 0;
	labResultSize = externalLabListNephro.size();
	if (externalLabListNephro.size() > 0) {
		for (ExternalLabReportCommon externalList : externalLabListNephro) {

			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			commonLabTestReport.setResultDate(externalList.getTestDate().toString());
			commonLabTestReport.setResultTime(
					externalList.getTestTime() != null ? externalList.getTestTime().toString() : "");
			commonLabTestReport.setTestName(externalList.getTestName());
			commonLabTestReport.setTestResult(externalList.getTestResult());
			commonLabTestReport.setTestStatus(externalList.getResultStatus());
			commonLabTestReport.setTestType("External Test");
			commonLabTestReport.setInvestigationId(
					externalList.getInvestigation() != null ? externalList.getInvestigation().getId() : 0);
			commonLabTestReports.add(commonLabTestReport);
		}

	}
	Collections.sort(commonLabTestReports, new ComparatorForLabTestDate());

	Set<String> testDate = new HashSet<String>();
	for (CommonLabTestReport externalListTemp : commonLabTestReports) {
		testDate.add(externalListTemp.getResultDate());
	}
	List<String> sortedTestDate = new ArrayList<String>(testDate);
	Collections.sort(sortedTestDate);

	Map<String, List<CommonLabTestReport>> commonLabTestReportsMap = new HashMap<String, List<CommonLabTestReport>>();
	List<CommonLabTestReport> testsObjList = null;
	for (CommonLabTestReport externalListTemp : commonLabTestReports) {
		String testName = externalListTemp.getTestName();
		if (commonLabTestReportsMap.containsKey(testName)) {
			testsObjList = commonLabTestReportsMap.get(testName);
		} else {
			testsObjList = new ArrayList<CommonLabTestReport>();
		}
		testsObjList.add(externalListTemp);
		commonLabTestReportsMap.put(testName, testsObjList);

	}

	//----Lab test End---

	/* Srikanth End */
%>

<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<input name="splName" id="splName" type="hidden" value="" />
<input name="forms" id="formId" type="hidden" value="opdlp" />
<input name="request" id="requestId" type="hidden"
	value="<%=visit.getHin().getId()%>" />
<div class="mgmtDivMain">
	<div class="mgmtMenuDiv">
		<input name="" id="" class="buttonAuto" value="Patient History"
			onclick="showPatientHistory('<%=visit.getHin().getHinNo()%>',csrfTokenName+'='+csrfTokenValue)"
			type="button"> <input name="" id=""
			onclick="popwindowResultEntry('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>');"
			class="buttonAuto" value="Result Entry" type="button"> <input
			onclick="openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>');"
			name="" id="" class="buttonAuto" value="Lab Results" type="button">
		<input name="" id="" class="buttonAuto"
			onclick="showParkPatient('p');" value="List of Parked Patients"
			type="button"> <input
			onclick="openPopupWindowNCDPattern(csrfTokenName+'='+csrfTokenValue,'<%=visit.getHin().getId()%>');"
			name="" id="" class="buttonAuto" value="NCD Clinic" type="button">
		<input name="" id="" class="buttonAuto" value="Upload Document"
			onclick="popwindowUploadDocuments('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>',csrfTokenName+'='+csrfTokenValue);"
			type="button">
	</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<body onclick="parent_disable()">
<form id="opdMainResetId" name="opdMain" action="" method="post">
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<script type="text/javascript">
<%if (!empDeptCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {%>
 setTimeout(function(){ displayClinicalSummary('<%=visit.getVisitNo()%>'); }, 100);
 <%}%>
</script>

	<!-- =====Inner Tab start here===== -->
	<div class="inTab">
		<%
			if (visit != null && visit.getVisitNo() > 1) {
		%>
		<%
			if (!empDeptCode
						.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab1');enableOPCommonDivForLP('y');hideSubmitButton('y')">OP
			Consultation</div>
		<div class="tablinks inActive"
			onclick="javascript:openCity(event, 'inTab2');enableOPCommonDivForLP('n');hideSubmitButton('n')">Clinical
			Summary</div>
		<%
			}
		%>
		<%-- 	else{%>
  		<div class="tablinks" onclick="javascript:openCity(event, 'inTab2');enableOPCommonDivForLP('n');">Clinical Summary</div>
  		<%}%> --%>
		<%
			} else {
		%>
		<%
			if (!empDeptCode
						.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {
		%>
		<div class="tablinks inActive"
			onclick="javascript:openCity(event, 'inTab1');enableOPCommonDivForLP('y');hideSubmitButton('y')">OP
			Consultation</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab2');enableOPCommonDivForLP('n');hideSubmitButton('n')">Clinical
			Summary</div>
		<%
			}
		%>
		<%--  else{ %>
    <div class="tablinks" onclick="javascript:openCity(event, 'inTab1');enableOPCommonDivForLP('y');">OP Consultation</div>
    <%} %>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab2');enableOPCommonDivForLP('n');">Clinical Summary</div> --%>
		<%
			}
		%>



		<!--  <input name="splName" id="splName" type="hidden"  value=""/> -->
		<%
			if (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('37','Medicine','OP');">Medicine</div>
		<%
			} else if (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab6');enableOPCommonDivForLP('n');display('12','Orthopedic Summary','OP');hideSubmitButton('n')">Speciality
			Summary</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('12','Orthopedic','OP');hideSubmitButton('y')">Orthopedic</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('78','Orthopedic Examination','OP');hideSubmitButton('y')">Orthopedic
			Examination</div>
		<%
			} else if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('35','ENT Examination','OP');">ENT
			Examination</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('86','Audiological Examination','OP');">Audiological
			Examination</div>
		<%
			} else if (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralSurgery"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('38','General Surgery','OP');">General
			Surgery</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab6');enableOPCommonDivForLP('n');display('24','Dermatology Summary','OP');">Speciality
			Summary</div>
		<!-- <div class="tablinks" onclick="javascript:openCity(event, 'inTab5');enableOPCommonDivForLP('n');"> Speciality Summary</div> -->
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('24','General Proforma','OP');">General
			Proforma</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('36','Leprosy Proforma','OP');">Leprosy
			Proforma</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('25','Vesiculo-bullous disorders','OP');">Vesiculo-bullous
			disorders</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('26','STD Case Record','OP');">STD
			Case Record</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('75','Phototherapy Proforma','OP');">Phototherapy
			Proforma</div>
		<%
			}
		%>
		<!-- code change by rajdeo psychiatry -->
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab5');enableOPCommonDivForLP('n');">
			Speciality Summary</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('34','Psychogeriatric Clinic','OP');">
			Psychogeriatric Clinic</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('11','Holistic and Psychosomatic','OP');">
			Holistic and Psychosomatic</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('21','Child And Adolescent','OP');">
			Child And Adolescent</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('23','Suicide Prevention','OP');">
			Suicide Prevention</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('33','Deaddiction Center','OP');">
			Deaddiction Center</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('85','General Adult Psychiatry Case Record','OP');">
			General Adult Psychiatry Case Record</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('19','Neonatology Unit','OP');">
			Neonatology Unit</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('30','Nicu Case Record','OP');">
			Nicu Case Record</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('32','Respiratory Clinic','OP');">
			Respiratory Clinic</div>
		<%
			}
		%>
		<%
			if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeNephrology"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('18','Donor Evaluation','OP');">
			Donor Evaluation</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('20','Recipient Evaluation','OP');">
			Recipient Evaluation</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('73','Dialysis','OP');">
			Dialysis</div>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('89','Hemo Dialysis','OP');">
			Hemo Dialysis</div>
		<%
			}
		%>

		<%
			if (empDeptCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {
		%>
		<div class="tablinks"
			onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('39','Antenatal Card','OP');">
			Antenatal Card</div>
		<!-- <div class="tablinks" onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('30','Family Planning','OP');"> Family Planning</div>
 <div class="tablinks" onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('40','Infertility Clinic','OP');"> Infertility Clinic</div>
  <div class="tablinks" onclick="javascript:openCity(event, 'inTab4');enableOPCommonDivForLP('y');display('32','Gynecology Case Sheet','OP');"> Gynecology Case Sheet</div> -->
		<%
			}
		%>

		<%
			if (opdPatientDetails != null && opdPatientDetails.getMlcType() != null
					&& opdPatientDetails.getMlcType().equalsIgnoreCase("y")) {
		%>
		<div class="tablinks" id="mlcTab"
			onclick="javascript:openCity(event, 'inTab3');enableOPCommonDivForLP('y');">MLC</div>
		<%
			} else {
		%>
		<div class="tablinks" id="mlcTab"
			onclick="javascript:openCity(event, 'inTab3');enableOPCommonDivForLP('y');"
			style="display: none">MLC</div>
		<%
			}
		%>
	</div>
	
	
	<div id="inTab1" class="inTabcontent" style="display: block;">
		<div class="clear"></div>
		<div class="Block" style="padding-bottom: 0px;">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="hidden" name="refsetId"
				id="refsetId" value="null">
			<div class="floatRight" style="margin-right: 15px;">
				<%
					if (opdPatientDetails != null && opdPatientDetails.getMlcType() != null
							&& opdPatientDetails.getMlcType().equalsIgnoreCase("y")) {
				%>
				<label class="autoSpace "><input id="mlcCheck"
					name="mlcCheck" class="radioCheckCol2"
					onchange="fnShowHideMLCTab()" checked="checked" type="checkbox">MLC</label>
				<%
					} else if (patientWiseMlcs.size() > 0) {
				%>
				<label class="autoSpace "><input id="mlcCheck"
					name="mlcCheck" class="radioCheckCol2"
					onchange="fnShowHideMLCTab()" checked="checked" type="checkbox">MLC</label>
				<%
					} else {
				%>
				<label class="autoSpace "><input id="mlcCheck"
					name="mlcCheck" class="radioCheckCol2"
					onchange="fnShowHideMLCTab()" type="checkbox">MLC</label>
				<%
					}
				%>
			</div>
			<label style="vertical-align: baseline;"><img
				src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Data
					is part of EHR</span></label>
			<div class="clear"></div>
			<div class="titleBg">
				<h2>PATIENT DETAILS</h2>
			</div>
			<div class="clear"></div>
			<div class="paddingTop2"></div>
			<label class="medium">UHID</label> <input type="text" id="" name=""
				value="<%=uhid%>" tabindex="1" readonly="readonly" /> <label
				class="medium">Patient Name</label> <input type="text" id="" name=""
				value="<%=patientName%>" tabindex="1" title="" readonly="readonly" />
			<label class="medium">Age</label> <input type="text" id="" name=""
				value="<%=yearMonth%>" tabindex="1" title="" class="small"
				readonly="readonly" /> <label class="medium">Gender</label> <input
				type="text" value="<%=gender%>" readonly="readonly" />
			<!-- code change by rajdeo -->
			<div class="clear"></div>
			<label class="medium">Comorbidity</label> <input type="text"
				id="comorbidityHistoryFromSnomed"
				name="comorbidityHistoryFromSnomed" maxlength="300"
				value="<%=opdPatientHistoriesStr != null ? opdPatientHistoriesStr : ""%>"
				tabindex="1" title="" />
			<%
				if (deptRefsetList != null) {
					if (deptRefsetList.size() > 0) {
			%>
			<label class="medium">Refset </label> <select name="refsetId"
				id="refsetId">
				<option value="null">Select</option>
				<%
					for (DepartmentRefset deptRefset : deptRefsetList) {
				%>
				<option value="<%=deptRefset.getRefsetId()%>"><%=deptRefset.getRefsetDesc()%></option>
				<%
					}
				%>
			</select>
			<%
				} else {
			%>
			<input type="hidden" name="refsetId" id="refsetId" value="null">
			<%
				}
				} else {
			%>
			<input type="hidden" name="refsetId" id="refsetId" value="null">
			<%
				}
			%>
			<div class="clear"></div>
			<%
				if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))) {
			%>
			<label> <%
 	if (dead != null) {
 %> <input type="checkbox"
				class="radioCheckCol2" name="patient_expire" id="patient_expire"
				disabled="disabled" checked="checked" /> <%
 	} else {
 %> <input
				type="checkbox" class="radioCheckCol2" name="patient_expire"
				id="patient_expire" /> <%
 	}
 %> Patient Dead
			</label>
			<div id="siftedToMortuaryDiv"
				style="display: <%=dead != null ? "block" : "none"%> ;">
				<select id="patientdeathStatus" class="midium"
					name="patientdeathStatus">
					<option>select</option>
					<option value="Brought Dead"
						<%=patientDeadStatus != null ? patientDeadStatus.equals("Brought Dead") ? "selected" : "" : ""%>>Brought
						Dead</option>
					<option value="Death In Opd"
						<%=patientDeadStatus != null ? patientDeadStatus.equals("Death In Opd") ? "selected" : "" : ""%>>Death
						In Opd</option>
				</select> <label> <%
 	if (mortuaryStatus != null) {
 %> <input type="checkbox"
					class="radioCheckCol2" name="siftedToMortuary"
					id="siftedToMortuary" disabled="disabled" checked="checked" /> <%
 	} else {
 %>
					<input type="checkbox" class="radioCheckCol2"
					name="siftedToMortuary" id="siftedToMortuary" /> <%
 	}
 %> Sifted To
					Mortuary
				</label>
			</div>
			<%
				}
			%>
			<%
				if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics"))
						|| departmentCode
								.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeNephrology"))) {
			%>
			<h4
				style="cursor: pointer; text-decoration: underline; float: left; width: 150px;"
				onclick="popwindowImmunization('opd?method=showVaccineDetailJsp&visitId=<%=visit.getId()%>');">Immunization</h4>
			<%
				}
			%>
			<div class="clear"></div>
			<%
				if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
			%>
			<div class="clear"></div>
			<div id="mlcRefered_div">
				<label class="auto">Referred From</label> <select name="mlcRefered"
					id="mlcRefered" onchange="getTextBox(this)">
					<option value="0">Select</option>
					<option value="1">From Jail</option>
					<option value="2">From Court</option>
					<option value="3">From Private Hospital</option>
					<option value="4">Others</option>
				</select>
			</div>
			<div id="mlcTextBox_divId" style="display: none">
				<input type="text" id="mlcTextBox" name="mlcTextBox">
			</div>
			<%
				}
			%>
			<%
				if (opdPatientDetails != null && opdPatientDetails.getReferedDepartment() != null
						&& opdPatientDetails.getReferedDepartment().getId().equals(deptId)) {
			%>
			<div class="titleBg">
				<h2>Referred details</h2>
			</div>
			<div class="clear"></div>
			<input type="hidden" name="referralCase" value="yes" /> <label>Referred
				by Doctor</label> <input type="text" id="" name="" readonly="readonly"
				value="<%=opdPatientDetails.getEmployee() != null ? opdPatientDetails.getEmployee().getFirstName() : ""%>" />
			<input type="hidden" id="" name="" readonly="readonly" /> <label>Departement
				From</label> <input type="text" id="" name="" readonly="readonly"
				value="<%=opdPatientDetails.getReferredDept() != null
						? opdPatientDetails.getReferredDept().getDepartmentName()
						: ""%>" />

			<label>Hospital From</label> <input type="text" id="" name=""
				readonly="readonly"
				value="<%=opdPatientDetails.getHospital() != null
						? opdPatientDetails.getHospital().getHospitalName()
						: ""%>" />
			<div class="clear"></div>
			<label>Date</label> <input type="text" readonly="readonly"
				value="<%=opdPatientDetails.getOpdDate() != null
						? HMSUtil.convertDateToStringTypeDateOnly(opdPatientDetails.getOpdDate())
						: ""%>" />
			<label>Doctor Note</label>
			<textarea class="textareaMediua" cols="0" rows="0" maxlength="200"
				" readonly="readonly"><%=opdPatientDetails.getReferralNotes() != null ? opdPatientDetails.getReferralNotes() : ""%>
 					</textarea>
			<label>Patient Advice</label>
			<textarea class="textareaMediua" cols="0" rows="0" maxlength="200"
				" readonly="readonly"><%=opdPatientDetails.getPatientAdvise() != null ? opdPatientDetails.getPatientAdvise() : ""%>
 					</textarea>
			<div class="clear"></div>
			<label>Summary Consultation</label>
			<textarea class="textareaMediua" cols="0" rows="0" maxlength="490"
				readonly="readonly"><%=opdPatientDetails.getSummaryConsultation() != null
						? opdPatientDetails.getSummaryConsultation()
						: ""%>
 					</textarea>
			<%
				}
			%>

			<div class="clear"></div>
			<div class="divisionSolid" style="margin: 0px;"></div>
			<div class="clear"></div>

			<%
				if (departmentCode
						.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine"))) {
			%>
			<div class="tabContWidth3">
			<label>Presenting Complaints</label>
					<div class="clear"></div>
					<textarea class="historyAutoComplete" name="presentComplain"
						validate="Presenting Complaints,string,no" id="presentComplain"
						cols="0" rows="0" maxlength="500"><%=presentComplaintHistory != null ? presentComplaintHistory : ""%></textarea>
						</div>
				<%
					} else {
				%>
				<div class="tabContWidth2">
					<label>Presenting Complaints</label>
					<div class="clear"></div>
					<textarea class="historyAutoComplete" name="presentComplain"
						validate="Presenting Complaints,string,no" id="presentComplain"
						cols="0" rows="0" maxlength="500"><%=presentComplaintHistory != null ? presentComplaintHistory : ""%></textarea>
				</div>
				<%
						}
					%>
				<%
					if (departmentCode
							.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine"))) {
				%>
				<div class="tabContWidth3">
				<label>History of Presenting Illness</label>
						<div class="clear"></div>
						<textarea name="pastIllness" class="historyAutoComplete"
							validate="History of Presenting Illness,string,no"
							id="pastIllness" cols="0" rows="0" maxlength="500"><%=opdPatientHistoriesStr != null ? opdPatientHistoriesStr : ""%></textarea>
					</div>
					<%
						} else {
					%>
					<div class="tabContWidth2">
						<label>History of Presenting Illness</label>
						<div class="clear"></div>
						<textarea name="pastIllness" class="historyAutoComplete"
							validate="History of Presenting Illness,string,no"
							id="pastIllness" cols="0" rows="0" maxlength="500"><%=opdPatientHistoriesStr != null ? opdPatientHistoriesStr : ""%></textarea>
					</div>
					<%
							}
						%>
					<div class="clear"></div>
					<div class="paddingTop2"></div>
					<div class="titleBg">
						<h2>HISTORY</h2>
					</div>
					<div class="clear"></div>
					<div class="paddingTop2"></div>
					<div class="tabContWidth5">
						<%
							if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
						%>
						<label>Past Medical / Dental History</label>
						<%
							} else {
						%>
						<label>Past History</label>
						<%
							}
						%>
						<%
							if (ncd) {
						%>
						<textarea name="pastHistory" id="pastHistory" cols="0" rows="0"
							maxlength="1024" tabindex="26" class="historyAutoComplete"
							validate="Past History,string,no"><%=pastHistory != null ? pastHistory : ""%></textarea>
						<%
							} else {
						%>
						<textarea name="pastHistory" id="pastHistory" cols="0" rows="0"
							maxlength="1024" tabindex="26" class="historyAutoComplete"
							validate="Past History,string,no"><%=pastHistory != null ? pastHistory : ""%></textarea>
						<%
							}
						%>
					</div>
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics"))) {
					%>
					<div class="tabContWidth5">
						<label>Antenatal/ Natal / Post Natal History</label>
						<textarea name="antenatalHistory" id="antenatalHistory" cols="0"
							rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete"
							validate="Antenatal/ Natal / Post Natal History,string,no"><%=antenatalHistory != null ? antenatalHistory : ""%></textarea>
					</div>
					<%
						} else {
					%>
					<%
						if (!departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<div class="tabContWidth5">
						<label>Surgical History</label>
						<textarea name="surgicalHistory" id="surgicalHistory" cols="0"
							rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete" validate="Surgical History,string,no"><%=surgeryHistory != null ? surgeryHistory : ""%></textarea>
					</div>
					<%
						}
						}
					%>
					<%
						if (!departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<div class="tabContWidth5">
						<label>Family History</label>
						<textarea name="familyHistory" id="familyHistory" cols="0"
							rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete" validate="Family History,string,no"><%=familyPastHistory%></textarea>
					</div>
					<%
						}
					%>
					<div class="tabContWidth5">
						<%
							if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
						%>
						<label>Personal History / habits</label>
						<%
							} else {
						%>
						<label>Medication History</label>
						<%
							}
						%>
						<textarea name="medicationhistory"
							validate="Medication History,string,no" id="medicationhistory"
							cols="0" rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete" validate="Family History,string,no"><%=medicationhistory != null ? medicationhistory : ""%></textarea>
					</div>
					<%
						int incr = 0;
						int len = 1;
					%>
					<%
						if (!empDeptCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))
								&& !departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<div class="tabContWidth5" style="width: 320px;">
						<div>
							<label style="width: 310px;"> <span
								style="float: left; color: black;">Allergies</span> <input
								name="" id="" class="buttonAuto" value="Allergy History"
								style="margin: 3px 0px 0px 60px; padding: 0px 4px; height: 19px; font-size: 10px;"
								onclick="openPopupWindowAllergyForLP(csrfTokenName+'='+csrfTokenValue);"
								type="button"> <span style="float: right;"><input
									class="addButSmll" alt="Add" value="&nbsp;" type="button"
									onclick="addRowForAllergy();"> <input
									class="delButSmll" alt="Delete" value="&nbsp;" type="button"
									onclick="removeRowForAllergy();"> </span>
							</label>
						</div>
						<div class="clear"></div>
						<div id="divTemplet"
							style="width: 314px; height: 59px; margin-left: 5px; overflow: auto; overflow-x: hidden;">
							<table style="width: 100%; border-top: solid 1px #C0C0C0"
								id="alergyGrid">
								<tr>
									<th style="background: rgb(189, 214, 238); padding: 0px;">&nbsp;</th>
									<th style="background: rgb(189, 214, 238); padding: 0px;">Type</th>
									<th style="background: rgb(189, 214, 238); padding: 0px;">Allergen</th>
									<th style="background: rgb(189, 214, 238); padding: 0px;">Remarks</th>
								</tr>
								<%
									incr = 0;
										len = 1;
										Integer allergyHeaderId = 0;
										Integer allergyDetailId = 0;
										if (opdPatientAllergyTs.size() > 0) {
											len = opdPatientAllergyTs.size();
										}
										MasAllergyProduct masAllergyProductPark = null;
										String allergyName = null;
										MasSeverityCode masSeverityCodePark = null;
										String allergyyear = null;
										String allergymonth = null;
										String allergyRemarks = null;
										for (; incr < len; incr++) {
											OpdPatientAllergyT opdPatientAllergyT = null;
											if (opdPatientAllergyTs.size() > 0) {
												opdPatientAllergyT = opdPatientAllergyTs.get(incr);
											}
											if (opdPatientAllergyT != null) {
												masAllergyProductPark = opdPatientAllergyT.getAllergy();
												allergyName = opdPatientAllergyT.getAllergen();
												masSeverityCodePark = opdPatientAllergyT.getSeverity();
												allergyyear = opdPatientAllergyT.getFromYear();
												allergymonth = opdPatientAllergyT.getFromMonth();
												allergyHeaderId = opdPatientAllergyT.getOpdPatientAllergy().getId();
												allergyDetailId = opdPatientAllergyT.getId();
												allergyRemarks = opdPatientAllergyT.getAllergyRemarks();
											}
								%>
								<tr>
									<td><input type="checkbox" class="radioCheck"
										name="allergyRadio<%=incr%>" id="allergyRadio<%=incr%>" /> <input
										type="hidden"
										value="<%=!allergyDetailId.equals(0) ? allergyDetailId : 0%>"
										name="allergyDetailId<%=incr%>" id="allergyDetailId<%=incr%>" />
									</td>
									<td><select style="width: 62px;" class="textYellow"
										name="allergyType<%=incr%>" id="allergyType<%=incr%>">
											<option value="0">Select</option>
											<%
												for (MasAllergyProduct msap : allergyProductsList) {
											%>
											<%
												if (masAllergyProductPark != null && (msap.getId() == masAllergyProductPark.getId())) {
											%>
											<option selected="selected" value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%
												} else {
											%>
											<option value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%
												}
											%>
											<%
												}
											%>
									</select> <%
 	MasAllergyProduct masAllergyProduct = new MasAllergyProduct();
 			for (int i = 0; i < allergyProductsList.size(); i++) {
 				masAllergyProduct = (MasAllergyProduct) allergyProductsList.get(i);
 %> <script>
	     			allergyTypeArray[<%=i%>]= new Array();
	     			allergyTypeArray[<%=i%>][0] = "<%=masAllergyProduct.getId()%>";
	     			allergyTypeArray[<%=i%>][1] = "<%=masAllergyProduct.getProductName()%>";
	            </script> <%
 	}
 %></td>
									<td><input type="text"
										class="largTextBoxOpd textYellow historyAutoComplete ui-autocomplete-input "
										tabindex="32" maxlength="256"
										value="<%=allergyName != null && !allergyName.equals("") ? allergyName : ""%>"
										id="allergyName<%=incr%>" size="35"
										name="allergyName<%=incr%>" style="width: 68px;"
										validate="Allergy Name,string,no" />
										<div id="allergy_ac2updates<%=incr%>" style="display: none;"
											class="autocomplete"></div></td>
									<td><input class="small textYellow"
										name="allergy_remarks<%=incr%>" maxlength="30"
										value="<%=allergyRemarks != null && !allergyRemarks.equals("") ? allergyRemarks : ""%>" /></td>
								</tr>
								<%
									}
								%>
							</table>
							<input type="hidden" name="allergyHeaderIds"
								id="allergyHeaderIds" value="<%=allergyHeaderId%>" />
						</div>
						<input type="hidden" name="allergyCount" id="allergyCount"
							value="<%=incr - 1%>" />
						<div class="clear"></div>
					</div>
					<%
						}
					%>
					<div class="clear"></div>

					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
					%>
					<div class="tabContWidth5">
						<label>Pre-morbid Personality</label>
						<textarea name="permorbidPersonality"
							validate="Medication History,string,no" id="permorbidPersonality"
							cols="0" rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete"
							validate="Pre-morbid  Personality,string,no"></textarea>
					</div>
					<div class="tabContWidth5">
						<label>Personal History</label>
						<textarea name="personalHistory" id="personalHistory" cols="0"
							rows="0" maxlength="1024" tabindex="26"
							class="historyAutoComplete" validate="Personal History,string,no"><%=personalPresentHistory != null ? personalPresentHistory : ""%></textarea>
					</div>
					<%
						}
					%>
					<!-- tab-111 end -->

					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))
								|| departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics"))) {
					%>
					<div class="tabContWidth4">
						<label>Development History</label>
						<textarea name="developmentHistory" id="developmentHistory"
							cols="0" rows="0" maxlength="500" tabindex="26"
							class="historyAutoComplete"
							validate="Development History,string,no"><%=developmentHistory != null ? developmentHistory : ""%></textarea>
					</div>

					<div class="tabContWidth4">
						<label>Diet History</label>
						<textarea name="dietHistory" id="dietHistory" cols="0" rows="0"
							maxlength="500" tabindex="26" class="historyAutoComplete"
							validate="Diet History,string,no"><%=dietHistory != null ? dietHistory : ""%></textarea>
					</div>
					<div class="tabContWidth4">
						<label>Socio Economic History</label>
						<textarea name="socioEconomicHistory" id="socioEconomicHistory"
							cols="0" rows="0" maxlength="500" tabindex="26"
							class="historyAutoComplete"
							validate="Socio Economic History,string,no"><%=socioEconomicHistory != null ? socioEconomicHistory : ""%></textarea>
					</div>
					<%
						}
					%>
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))) {
					%>
					<div class="tabContWidth4">
						<label>Personal History</label>
						<textarea name="personalHistory" id="personalHistory" cols="0"
							rows="0" maxlength="500" tabindex="26"
							class="historyAutoComplete" validate="Personal History,string,no"><%=personalPresentHistory != null ? personalPresentHistory : ""%></textarea>
					</div>
					<%
						}
					%>

					<%
						if (departmentCode
								.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralSurgery"))) {
					%>
					<div class="tabContWidth2">
						<label>Menstrual History</label>
						<textarea name="menstrualHistory" id="menstrualHistory" cols="0"
							rows="0" maxlength="500" class="historyAutoComplete"
							validate="Menstrual History,string,no"><%=menstrualHistory != null ? menstrualHistory : ""%></textarea>
					</div>
					<div class="tabContWidth2">
						<label>Obstretic History</label>
						<textarea name="obstreticHistory" id="obstreticHistory" cols="0"
							rows="0" maxlength="500" class="historyAutoComplete"
							validate="Obstretic History,string,no"><%=obstreticHistory != null ? obstreticHistory : ""%></textarea>
					</div>

					<div class="clear"></div>
					<div class="paddingTop5"></div>
					<h4>Previous surgeries</h4>
					<input type="button" class="buttonAdd" alt="Add" tabindex="4"
						value="&nbsp;"
						onclick="addRowForCurrentPreviousSurgeriesTemp();addRowForCurrentPreviousSurgeries();" />
					<input type="button" class="buttonDel" tabindex="3" alt="Delete"
						value="&nbsp;"
						onclick="removeRowForCurrentPreviousSurgeriesTemp();removeRowForCurrentPreviousSurgeries();" />

					<div class="cmnTable">
						<table border="0" cellpadding="0" cellspacing="0"
							id="previousSurgeriesGridTemp">
							<tr>
								<th scope="col">&nbsp;</th>
								<th>Type</th>
								<th>Date/Year</th>
								<th>Institution</th>
								<th>Hospitalization duration</th>
								<th>Complications</th>
							</tr>
							<%
								if (opdGeneralSurgeryPrevSpeciality.size() > 0) {
										for (OpdGeneralSurgeryPrevSpeciality c : opdGeneralSurgeryPrevSpeciality) {
							%>
							<tr>
								<td><input type="checkbox" disabled="disabled" /></td>
								<td><textarea rows="" cols=""
										style="margin: 0px 5px; width: 231px; height: 30px;"
										maxlength="150"><%=c.getTypePrev() != null ? c.getTypePrev() : ""%></textarea>
								<td><input type="text"
									value="<%=c.getDatePrev() != null
								? HMSUtil.convertDateToStringTypeDateOnly(c.getDatePrev())
								: ""%>"
									readonly class="date" /></td>
								<td><input type="text"
									value="<%=c.getInstitution() != null ? c.getInstitution() : ""%>"
									readonly /></td>
								<td><input type="text"
									value="<%=c.getHospitalizationDuration() != null ? c.getHospitalizationDuration() : ""%>"
									readonly /></td>
								<td><input type="text"
									value="<%=c.getComplications() != null ? c.getComplications() : ""%>"
									readonly /></td>
							</tr>

							<%
								}
									}
							%>
							<tr>
							<tr>
								<td><input type="checkbox" class="radioCheck"
									name="previousSurgeriesRadioTemp1"
									id="previousSurgeriesRadioTemp1" /></td>
								<td>
									<!-- <input type="text"  id="typeP1"  name="typeP1" size="30" maxlength="150" value=""/> -->
									<textarea rows="" cols="" id="typePTemp1"
										onblur="setVitalValue(this.value,'typeP1')" name="typePTemp1"
										onkeyup="return checkLength(this)"
										style="margin: 0px 5px; width: 231px; height: 30px;"
										maxlength="150"></textarea>
								</td>
								<td><input type="text" id="dateYearTemp1"
									name="dateYearTemp1" value="" class="date" maxlength="4"
									onkeypress="javascript:return isNumber(event)"
									onblur="yearTempFormatDate(1); setVitalValue(this.value,'dateYear1');">
									<!-- <input type="text" id="dateYear1" name="dateYear1" 	value=""	size="23.5"  validate="Date,date,no" maxlength="10" onkeyup="mask(this.value,this,'2,5','/');"  > -->
									<img src="/hms/jsp/images/cal.gif" width="16" height="16"
									border="0"
									onclick="setdate('',document.getElementById('dateYearTemp1'),event);" />

								</td>
								<td><input type="text" id="institutionTemp1"
									name="institutionTemp1"
									onblur="setVitalValue(this.value,'institution1')" value=""
									maxlength="120" /></td>
								<td><input type="text" id="hospitalizationDurationTemp1"
									onblur="setVitalValue(this.value,'hospitalizationDuration1')"
									name="hospitalizationDuration1Temp" value="" maxlength="5"
									onkeypress="javascript:return isNumberDecimal(event)"
									validate="Hospitalization duration,float,no" /></td>
								<td><input type="text" id="complicationsTemp1"
									onblur="setVitalValue(this.value,'complicationsP1')"
									name="complicationsTemp1" value="" maxlength="120" /></td>
							</tr>
						</table>
						<input type="hidden" name="previousSurgeriesCountTemp"
							id="previousSurgeriesCountTemp" value="1" />
					</div>
					<%
						}
					%>

					<div class="clear"></div>
					<div class="paddingTop2"></div>
					<div class="titleBg">
						<h2>VITALS</h2>
					</div>
					<div class="clear"></div>
					<div class="paddingTop2"></div>

					<table
						style="width: 1157px; border-top: 1px solid #C0C0C0; float: left;">
						<tr>
							<td><label class="smallAuto">&nbsp;T:&nbsp;</label> <input
								type="text" id="temperature" name="temperature"
								value="<%=temperature > 0f ? temperature : ""%>" maxlength="3"
								class="textYellow allownumericwithdecimal textSmall"
								style="width: 50px;"
								onblur="setVitalValue(this.value,'temperatureTemp');setVitalValue(this.value,'leprosyTemperature');setVitalValue(this.value,'dermoTemperature');setVitalValue(this.value,'ptTemperature');" />
								<label class="smallAuto">&nbsp;&deg;F&nbsp; </label></td>
							<td><label class="smallAuto">BP:</label><input
								name="systolic" id="systolic" placeholder="Systolic"
								value="<%=parts.length > 0 ? parts[0] : noSysDias%>"
								validate="systolic,int,no" maxlength="3"
								class="textSmall allownumericwithoutdecimal" type="text"
								maxlength="5"
								onblur="setVitalValue(this.value,'systolicTemp');setVitalValue(this.value,'systolicTempforgp');setVitalValue(this.value,'ptSystolic');" />
								<label class="smallAuto">/</label> <input name="diastolic"
								id="diastolic" placeholder="Diastolic"
								value="<%=parts.length > 0 ? parts[1] : noSysDias%>"
								validate="diastolic,int,no" maxlength="3"
								class="textSmall allownumericwithoutdecimal" type="text"
								onblur="setVitalValue(this.value,'diastolicTemp');setVitalValue(this.value,'diastolicTempforgp');setVitalValue(this.value,'ptDiastolic');" />
								<label class="smallAuto">mm Hg</label></td>
							<td><label class="smallAuto">HR:</label> <input type="text"
								id="pulse" name="pulse" value="<%=pulse > 0 ? pulse : ""%>"
								onblur="setVitalValue(this.value,'pulseTemp')" maxlength="3"
								style="width: 50px;"
								class="textYellow allownumericwithoutdecimal textSmall" /> <label
								class="smallAuto">/ min</label></td>
							<td><label class="smallAuto">Wt:</label> <input
								name="weight" id="weight" type="text" maxlength="6"
								class="allownumericwithdecimal textSmall"
								value="<%=weight > 0 ? weight : ""%>"
								<%if (departmentCode != null && (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {%>
								validate="weight,double,no"
								onblur="calculateBMIPaeditrics('<%=pedAge%>');calculatePEMPaeditrics(this.value);"
								<%} else {%> validate="weight,double,no"
								onblur="calculateBMI();calculatePEM(this.value);setVitalValue(this.value,'dermoWeight');setVitalValue(this.value,'leprosyWeight');setVitalValue(this.value,'ptWeight');"
								<%}%> /> <label class="smallAuto">kgs</label></td>
							<td><label class="smallAuto">Ht:</label><input name="height"
								id="height" type="text" maxlength="6"
								class="allownumericwithdecimal textSmall"
								value="<%=height > 0 ? height : ""%>"
								<%if (departmentCode != null && (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {%>
								validate="height,float,no"
								onblur="calculateBMIPaeditrics('<%=pedAge%>');calculateStuntingPaeditrics(this.value);"
								<%} else {%> validate="height,float,no"
								onblur="calculateBMI();calculateStunting(this.value);setVitalValue(this.value,'dermoHeight');setVitalValue(this.value,'leprosyHeight');setVitalValue(this.value,'ptHeight');"
								<%}%> /> <label class="smallAuto">cms</label> <input
								name="bmi" id="bmiValue" value="" readonly="readonly"
								class="textSmall" type="hidden"></td>

							<td><label id="bmi" class="value" name="bmi"
								readonly="readonly" class="textSmall"
								onblur="setVitalValue(this.value,'dermoBmi');setVitalValue(this.value,'leprosyBmi')"><%=bmi > 0f ? bmi : ""%></label>
							</td>
							<td><label id="bmiCat" class="value">&nbsp; <%=bmiStatus%></label></td>
						</tr>
					</table>
					<table
						style="width: 1157px; border-top: 0px solid #C0C0C0; float: left;">
						<tr>
							<td><label class="smallAuto">PEM</label> <%
 	if (childExpectedHW != null) {
 %>
								<input type="hidden" id="expectedHt" name="expectedHt"
								value=<%=childExpectedHW.getChildHeight()%> /> <input
								type="hidden" id="expectedWt" name="expectedWt"
								value=<%=childExpectedHW.getChildWeight()%> /> <%
 	}
 %> <%
 	if (departmentCode != null && (departmentCode
 			.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
 %>
								<input class="textYellow textSmall" style="width: 73px;"
								name="pem" id="pem" type="text" maxlength="15"
								validate="PEM,string,no" value="<%=pem != null ? pem : ""%>">
								<%
									} else {
								%> <input class="textYellow textSmall" name="pem"
								id="pem" type="text" maxlength="5" validate="PEM,float,no"
								value="<%=pem != null ? pem : ""%>"> <%
 	}
 %></td>
							<td><label class="smallAuto">Stunting</label> <%
 	if (departmentCode != null && (departmentCode
 			.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
 %>
								<input class="textYellow textSmall" style="width: 73px;"
								name="stunting" id="stunting" type="text" maxlength="15"
								validate="Stunting,string,no"
								value="<%=stuning != null ? stuning : ""%>"> <%
 	} else {
 %> <input
								class="textYellow textSmall" name="stunting" id="stunting"
								type="text" maxlength="5" validate="Stunting,float,no"
								value="<%=stuning != null ? stuning : ""%>"> <%
 	}
 %></td>
							<%
								if (departmentCode != null && (departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
							%>
							<td><label class="smallAuto">MAC</label> <input
								class="textYellow allownumericwithdecimal textSmall"
								name="ped_mac" id="ped_mac" type="text" maxlength="5"
								validate="MAC,float,no" value="<%=mac != null ? mac : ""%>"><label
								class="smallAuto">cms</label></td>
							<%
								}
							%>

							<%
								if (departmentCode != null && (departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
							%>
							<td><label class="smallAuto">Wasting</label> <select
								name="wasting" id="wasting">
									<option value="">Select</option>
									<option value="No Wasting"
										<%=preOpdPatientDetails.getWasting() != null
						? preOpdPatientDetails.getWasting().equals("No Wasting") ? "selected" : ""
						: ""%>>No
										Wasting</option>
									<option value="Grade 1"
										<%=preOpdPatientDetails.getWasting() != null
						? preOpdPatientDetails.getWasting().equals("Grade 1") ? "selected" : ""
						: ""%>>Grade
										1</option>
									<option value="Grade 2"
										<%=preOpdPatientDetails.getWasting() != null
						? preOpdPatientDetails.getWasting().equals("Grade 2") ? "selected" : ""
						: ""%>>Grade
										2</option>
									<option value="Grade 3"
										<%=preOpdPatientDetails.getWasting() != null
						? preOpdPatientDetails.getWasting().equals("Grade 3") ? "selected" : ""
						: ""%>>Grade
										3</option>
							</select></td>
							<%
								} else {
							%>
							<td><label class="smallAuto">Wasting</label> <input
								class="textYellow  textSmall" name="wasting" id="wasting"
								type="text" maxlength="5" validate="Wasting,float,no"
								value="<%=wasting != null ? wasting : ""%>"></td>
							<%
								}
							%>
							<td><label class="smallAuto">Resp.Rate</label> <input
								class="textYellow allownumericwithdecimal textSmall"
								name="respiratoryRate" id="respiratoryRate" type="text"
								maxlength="3" validate="Respiratory Rate,float,no"
								value="<%=respirtoryRate > 0 ? respirtoryRate : ""%>"
								onblur="setVitalValue(this.value,'respiratoryRateTemp');setVitalValue(this.value,'dermoRespiratoryRate');setVitalValue(this.value,'leprosyRespiratoryRate');setVitalValue(this.value,'ptRespiratoryRate');" />
								<label class="smallAuto">/ min</label></td>
							<td><label class="smallAuto">SpO2</label> <input
								class="textYellow allownumericwithoutdecimal textSmall"
								name="spo2" id="spo2" type="text" maxlength="3"
								validate="spo2,float,no" value="<%=spo2 > 0 ? spo2 : ""%>"
								onblur="if(maxDigitAllowed(this, '100')){setVitalValue(this.value,'spo2Temp');setVitalValue(this.value,'dermoSpo2');setVitalValue(this.value,'leprosySpo2');setVitalValue(this.value,'ptSpo2');}"
								onkeypress="return isNumberOnly(event)" /> <label
								class="smallAuto">%</label></td>
							<td colspan="2"><label class="smallAuto">Blood Group</label>
								<%
									if (bloodGroupValue != null && !bloodGroupValue.isEmpty() && !bloodGroupValue.equals("0")) {
								%>
								<label class="smallAuto"><%=bloodGroupValue%></label> <%
 	} else {
 %>
								<select name="bloodGroupValue" id="bloodGroupValue" tabindex=1
								class="midium">
									<option value="0">Select</option>
									<%
										for (MasBloodGroup masBloodGroup : bloodGroupList) {
									%>
									<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
									<%
										}
									%>
							</select> <label class="smallAuto">Confirm</label> <input type="checkbox"
								name="bloodGroupStatus" id="bloodGroupStatus" value="y"
								class="checkboxMargin" /> <%
 	}
 %></td>
						</tr>
					</table>
					<!-- </div> -->
					<div class="clear"></div>
					<div class="paddingTop2"></div>

					<div class="titleBg">
						<h2>EXAMINATION</h2>
					</div>
					<div class="clear"></div>
					<div class="paddingTop2"></div>

					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
					%>
					<div class="tabContWidth3">
						<label>General Appearance & Behavior</label>
						<textarea name="general_appearance" id="general_appearance"
							cols="0" rows="0" maxlength="256" tabindex="26" class=""></textarea>
					</div>
					<div class="tabContWidth3">
						<label>Mental Status</label>
						<textarea name="mental_status" id="mental_status" cols="0"
							rows="0" maxlength="256" tabindex="26" class=""></textarea>
					</div>
					<div class="tabContWidth3">
						<label>Cognitive Functions</label>
						<textarea name="cognitive_function" id="cognitive_function"
							cols="0" rows="0" maxlength="256" tabindex="26" class=""></textarea>
					</div>
					<%
						}
					%>

					<div class="tabContWidth3">
						<label>General Examination</label>
						<textarea name="generalExaminationOPC" id="generalExaminationOPC"
							cols="0" rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="General Examination,string,no"><%=opdPatientDetails != null && opdPatientDetails.getGeneralExamination() != null
					&& opdPatientDetails.getVisit().getId().equals(visitId)
							? opdPatientDetails.getGeneralExamination()
							: ""%></textarea>
					</div>

					<div class="tabContWidth3">
						<label>Systemic Examination</label>

						<textarea name="systemicExamination" id="systemicExamination"
							cols="0" rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Systemic Examination,string,no"><%=opdPatientDetails != null && opdPatientDetails.getGeneralExamination() != null
					&& opdPatientDetails.getVisit().getId().equals(visitId)
							? opdPatientDetails.getGeneralExamination()
							: ""%></textarea>
					</div>
					<div class="clear"></div>
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<jsp:include page="dentalExamination.jsp" />
					<%
						}
					%>
					<div class="clear"></div>
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<div class="tabContWidth3">
						<label>Extra-Oral Examination</label>
						<textarea id="extraOralExamination" name="extraOralExamination"
							cols="0" rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Extra-Oral Examination,string,no"><%=extraOralExamination != null ? extraOralExamination : ""%></textarea>
					</div>

					<div class="tabContWidth3">
						<label>Intra-Oral Examination</label>
						<textarea id="intraOralExamination" name="intraOralExamination"
							cols="0" rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Intra-Oral Examination,string,no"><%=intraOralExamination != null ? intraOralExamination : ""%></textarea>
					</div>

					<div class="tabContWidth3">
						<label>Chair Side Investigations</label>
						<textarea id="chairSideInvestigations"
							name="chairSideInvestigations" cols="0" rows="0" maxlength="300"
							tabindex="26" class="historyAutoComplete"
							validate="Chair Side Investigations,string,no"><%=chairSideInvestigations != null ? chairSideInvestigations : ""%></textarea>
					</div>
					<%
						}
					%>

					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))) {
					%>
					<div class="tabContWidth3">
						<label>Examination of Ear</label>
						<textarea id="earExamination" name="earExamination" cols="0"
							rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Examination of Ear,string,no"><%=earExamination != null ? earExamination : ""%></textarea>
					</div>
					<div class="clear"></div>
					<div class="divisionSolid"></div>
					<div class="clear"></div>
					<div class="tabContWidth3">
						<label>Examination of Nose & PNS</label>
						<textarea id="nosePnsExamination" name="nosePnsExamination"
							cols="0" rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Examination of Nose & PNS,string,no"><%=nosePnsExamination != null ? nosePnsExamination : ""%></textarea>
					</div>
					<div class="tabContWidth3">
						<label>Examination of Oral Cavity & Throat</label>
						<textarea id="oralCavityThroatExamination"
							name="oralCavityThroatExamination" cols="0" rows="0"
							maxlength="300" tabindex="26" class="historyAutoComplete"
							validate="Examination of Oral Cavity & Throat,string,no"><%=oralCavityThroatExamination != null ? oralCavityThroatExamination : ""%></textarea>
					</div>
					<div class="tabContWidth3">
						<label>Examination of Neck</label>
						<textarea id="neckExamination" name="neckExamination" cols="0"
							rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Examination of Neck,string,no"><%=neckExamination != null ? neckExamination : ""%></textarea>
					</div>

					<%
						} else if (!departmentCode
								.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))
								&& !departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
					%>
					<div class="tabContWidth3">
						<label>Local Examination</label>
						<textarea id="localExamination" name="localExamination" cols="0"
							rows="0" maxlength="300" tabindex="26"
							class="historyAutoComplete"
							validate="Local Examination,string,no"><%=opdPatientDetails != null && opdPatientDetails.getLocalExamination() != null
						&& opdPatientDetails.getVisit().getId().equals(visitId)
								? opdPatientDetails.getLocalExamination().trim()
								: ""%></textarea>
					</div>
					<%
						}
					%>

					<!-- Nephrology related changes -->

					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeNephrology"))) {
							String templateName = "Nephrology";
					%>
					<div class="clear"></div>

					<h4 style="cursor: pointer;"
						onclick="popwindowResultEntryForDermotology('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>@@@<%=templateName%>');">External
						Lab Report Entry</h4>
					<div class="clear"></div>
					<div class="plusText">
						<h4 class="h4Tab">Lab Test Result</h4>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div class="clear"></div>
					<div id="labResult">

						<div class="indArrow"></div>
						<!-- changes for external lab report -->

						<div class="Block">
							<div class="clear"></div>
							<%
								if (commonLabTestReports != null && sortedTestDate != null && commonLabTestReportsMap.size() > 0) {
										String testName = null;
							%>
							<label>Lab test report</label>
							<div class="tableForTab" style="width: 910px">
								<div id="divTemplet2">
									<table border="0" align="center" cellpadding="0"
										cellspacing="0" id="OutSidelabResult">
										<tr>
											<th>Test Name</th>
											<%
												int labIndex = 0;
														for (; labIndex < sortedTestDate.size(); labIndex++) {
											%>
											<th><%=HMSUtil.convertStringDateFormat(sortedTestDate.get(labIndex))%>
											</th>
											<%
												}
											%>
										</tr>

										<%
											Iterator records = commonLabTestReportsMap.entrySet().iterator();
													while (records.hasNext()) {
														Map.Entry entry = (Map.Entry) records.next();
														String key = (String) entry.getKey();
										%>

										<tr>
											<td style="width: 175px;"><input type="text"
												name="testN" value="<%=key%>" readonly="readonly" /></td>

											<%
												List<CommonLabTestReport> testDispList = new ArrayList<CommonLabTestReport>();
															testDispList = (ArrayList<CommonLabTestReport>) entry.getValue();
															for (int dateIndex = 0; dateIndex < sortedTestDate.size(); dateIndex++) {
																List<CommonLabTestReport> localList = new ArrayList<CommonLabTestReport>();
																for (CommonLabTestReport reportList : testDispList) {

																	if (sortedTestDate != null
																			&& sortedTestDate.get(dateIndex).equalsIgnoreCase(reportList.getResultDate())) {
																		localList.add(reportList);
																	}
																}

																//single test start
																if (localList.size() == 1) {
											%>
											<%
												if (localList.get(0).getTestType().equalsIgnoreCase("Internal Test")) {
											%>
											<td><a
												href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getDgId()%>','<%=localList.get(0).getInvestigationId()%>');">Lab
													Results</a></td>
											<%
												}
											%>
											<%
												if (localList.get(0).getTestType().equalsIgnoreCase("External Test")) {
																		if (localList.get(0).getTestStatus() != null
																				&& !localList.get(0).getTestStatus().equals("")
																				&& localList.get(0).getTestResult().equals("")) {
											%>
											<td><a
												href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getInvestigationId()%>','<%=localList.get(0).getResultDate()%>','<%=hinId%>','<%=localList.get(0).getResultTime()%>');">Lab
													Results</a></td>
											<%
												} else if (localList.get(0).getTestStatus() != null
																				&& !localList.get(0).getTestStatus().equals("")
																				&& localList.get(0).getTestStatus().equalsIgnoreCase("Abnormal")) {
											%>
											<td><%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")
												+ "<b>(Abnormal)</b>"%>
											</td>
											<%
												} else {
											%>
											<td><%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")%>
											</td>
											<%
												}
																	}
																}
																//single test end
																if (localList.size() == 0) {
											%>
											<td>-</td>


											<%
												}
											%>
											<%
												if (localList.size() > 1) {
											%>
											<td>
												<%
													String res = "";
																		String hLink = "";
																		for (CommonLabTestReport finalReport : localList) {
																			String testResult = "";
																			if (finalReport.getTestType().equalsIgnoreCase("External Test")) {
																				if (finalReport.getTestResult() == null
																						|| finalReport.getTestResult().equals("")) {
																					if (!finalReport.getResultTime().equals("00:00"))
																						hLink = "<a href=".concat("\"").concat(
																								"javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'")
																								.concat("" + finalReport.getInvestigationId()).concat("'")
																								.concat(",").concat("'").concat(finalReport.getResultDate())
																								.concat("'").concat(",").concat("'" + hinId).concat("'")
																								.concat(",'" + finalReport.getResultTime() + "'").concat(");")
																								.concat("\"").concat(">Lab Results - "
																										+ finalReport.getResultTime() + "</a>");
																					else
																						hLink = "<a href=".concat("\"").concat(
																								"javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'")
																								.concat("" + finalReport.getInvestigationId()).concat("'")
																								.concat(",").concat("'").concat(finalReport.getResultDate())
																								.concat("'").concat(",").concat("'" + hinId).concat("'")
																								.concat(",'" + finalReport.getResultTime() + "'").concat(");")
																								.concat("\"").concat(">Lab Results</a>");

																					res = res.concat("\n").concat(hLink);
																				}
																				if (finalReport.getTestResult() != null
																						&& !finalReport.getTestResult().equals("")) {
																					if (!finalReport.getResultTime().equals("00:00")) {
																						if (finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
																							testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																									"") + "<b>(Abnormal)</b>" + "-"
																									+ finalReport.getResultTime();
																						else
																							testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																									"") + "-" + finalReport.getResultTime();
																					} else {
																						if (finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
																							testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																									"");
																						else
																							testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																									"") + "<b>(Abnormal)</b>";
																					}
																					res = res.concat(testResult).concat(", ");
																				}
																			} // external test end here
																				// internal test starts here
																			if (finalReport.getTestType().equalsIgnoreCase("Internal Test")) {
																				if (finalReport.getTestResult() == null
																						|| finalReport.getTestResult().equals("")) {

																					hLink = "<a href=".concat("\"").concat(
																							"javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'")
																							.concat("" + finalReport.getDgId()).concat("'").concat(",")
																							.concat("'").concat("" + finalReport.getInvestigationId())
																							.concat("'").concat(");").concat("\"")
																							.concat(">Lab Results - " + finalReport.getResultTime() + "</a>");

																					res = res.concat("\n").concat(hLink);
																				}
																			} // internal test end here
																		} // end of for loop
												%> <%=res%>
											</td>
											<%
												}
															}
														}
											%>
										</tr>
									</table>
								</div>
							</div>
							<%
								} else {
							%>
							<span>No Test Record found</span>
							<%
								}
							%>
						</div>
						<!-- changes for external lab report end -->
					</div>

					<%
						}
					%>

					<div class="clear"></div>

					<div id="Div1"></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<div id="inTab2" class="inTabcontent">
				<div class="clear"></div>
				<div class="Block">
					<h6>Clinical Summary</h6>
					<div class="clear"></div>
					<div class="paddingTop5"></div>

					<label class="medium">From Date</label> <input type="text"
						name="fromDateId" id="fromDateId" value="" readonly="readonly"
						class="dateTextSmall" /> <img src="/hms/jsp/images/cal.gif"
						width="16" height="16" border="0" validate="Pick a date"
						onclick="setdate('<%=currentDate%>',document.opdMain.fromDateId,event);" />

					<label class="medium">To Date</label> <input type="text"
						id="toDateId" name="toDateId" class="dateTextSmall" value=""
						readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
						width="16" height="16" border="0" validate="Pick a date"
						onclick="setdate('<%=currentDate%>',document.opdMain.toDateId,event);" />

					<input type="button" name="search" value="Search" class="button"
						onClick="submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getClinicalSummaryHistoryData&opdType=LP','clinicalSummaryDiv');" />
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
								String opdReview = "";
								String previousDiagnosis = null;
								if (previousDetailList.size() > 0) {
									for (Object[] patientHistory : previousDetailList) {

										Date opdDate = (Date) patientHistory[0];
										if (patientHistory[1] != null && !patientHistory[1].equals("")) {
											preComplain = (String) patientHistory[1];
										}
										if (!preComplain.equals("")) {

											preComplaindateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
											preComplaindateWise += " --  " + preComplain + "<div class='clear'></div>";
										}
										history += HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "<div class='clear'></div>";
										if (patientHistory[2] != null && !patientHistory[2].equals("")) {
											history += "Past History--" + (String) patientHistory[2] + "<div class='clear'></div>";
										}
										if (patientHistory[3] != null && !patientHistory[3].equals("")) {
											history += "Family History--" + (String) patientHistory[3] + "<div class='clear'></div>";
										}
										if (patientHistory[4] != null && !patientHistory[4].equals("")) {
											history += "Medication History--" + (String) patientHistory[4] + "<div class='clear'></div>";
										}
										if (patientHistory[5] != null && !patientHistory[5].equals("")) {
											history += "History of Past Illness--" + (String) patientHistory[5]
													+ "<div class='clear'></div>";
										}
										if (patientHistory[6] != null && !patientHistory[6].equals("")) {
											history += "History of Menstrual and Obstetric--" + (String) patientHistory[6]
													+ "<div class='clear'></div>";
										}
										if (patientHistory[7] != null && !patientHistory[7].equals("")) {
											systemicExamination += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
											systemicExamination += (String) patientHistory[7] + "<div class='clear'></div>";
										}
										if (patientHistory[8] != null && !patientHistory[8].equals("")) {
											findings += HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "<div class='clear'></div>";
											findings += "Local Examination--" + (String) patientHistory[8] + "<div class='clear'></div>";
										}
										if (patientHistory[9] != null && !patientHistory[9].equals("")) {
											findings += "General Examination--" + (String) patientHistory[9] + "<div class='clear'></div>";
										}

										if (patientHistory[12] != null && ((Integer) patientHistory[12]) != 0) {
											findings += "Pulse-" + (Integer) patientHistory[12];
										}
										if (patientHistory[13] != null && !patientHistory[13].equals("")) {
											findings += "BP-" + (String) patientHistory[13];
										}
										if (patientHistory[14] != null && !patientHistory[14].equals("")) {
											findings += "P/S-" + (String) patientHistory[14] + "<div class='clear'></div>";
										}
										if (patientHistory[15] != null && !patientHistory[15].equals("")) {
											findings += "P/V-" + (String) patientHistory[15] + "<div class='clear'></div>";
										}
										if (patientHistory[16] != null && !patientHistory[16].equals("")) {
											findings += "P/R-" + (String) patientHistory[16] + "<div class='clear'></div>";
										}
										if (patientHistory[17] != null && !patientHistory[17].equals("")) {
											findings += "Smear Collection-"
													+ (((String) patientHistory[17]).equalsIgnoreCase("y") ? "Yes" : "No")
													+ "<div class='clear'></div>";
										}
										if (patientHistory[19] != null && !patientHistory[19].equals("")) {
											opdRemarks += HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "<div class='clear'></div>";
											opdRemarks += (String) patientHistory[19] + "<div class='clear'></div>";
										}
										if (patientHistory[25] != null && !patientHistory[25].equals("")) {
											opdReview += HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "<div class='clear'></div>";
											opdReview += (String) patientHistory[25] + "<div class='clear'></div>";
										}

										if (patientHistory[21] != null && !patientHistory[21].equals("")) {
											procedureDone += (String) patientHistory[21] + "<div class='clear'></div>";
										}
										if (patientHistory[22] != null && !patientHistory[22].equals("")) {
											preProcedure += "Treatment --" + (String) patientHistory[22] + "<div class='clear'></div>";
										}

										if (patientHistory[23] != null && !patientHistory[23].equals("")) {
											history += "History of Development--" + (String) patientHistory[23]
													+ "<div class='clear'></div>";
										}

										if (patientHistory[24] != null && !patientHistory[24].equals("")) {
											history += "History of Diet--" + (String) patientHistory[24] + "<div class='clear'></div>";
										}

										if (patientHistory[28] != null && !patientHistory[28].equals("")) {
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + "<div class='clear'></div>"
															+ HMSUtil.convertDateToStringTypeDateOnly(opdDate) + ""
													: HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":" + patientHistory[30] + ""
													: patientHistory[30] + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":[P] " + patientHistory[28].toString()
													: patientHistory[28].toString();
										}
										if (patientHistory[29] != null) {
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + "<div class='clear'></div>"
															+ HMSUtil.convertDateToStringTypeDateOnly(opdDate) + ""
													: HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":" + patientHistory[30] + ""
													: patientHistory[30] + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":[F] " + patientHistory[29].toString()
													: patientHistory[29].toString();
										}
										if (patientHistory[18] != null) {
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + "<div class='clear'></div>"
															+ HMSUtil.convertDateToStringTypeDateOnly(opdDate) + ""
													: HMSUtil.convertDateToStringTypeDateOnly(opdDate) + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":" + patientHistory[30] + ""
													: patientHistory[30] + "";
											previousDiagnosis = previousDiagnosis != null
													? previousDiagnosis + ":[O] " + patientHistory[18].toString()
													: patientHistory[30].toString();
										}

									}
								}

								if (previousInvestigationHashMap != null && previousInvestigationHashMap.size() > 0) {
									for (Map.Entry<Date, String> prevInves : previousInvestigationHashMap.entrySet()) {
										preInvestigation += HMSUtil.convertDateToStringTypeDateOnly(prevInves.getKey()) + " "
												+ prevInves.getValue() + "<div class='clear'></div>";
									}

								}

								if (previousPrescriptionList.size() > 0) {
									for (Object[] pres : previousPrescriptionList) {
										Date visitDate = (Date) pres[0];
										prePrecription += HMSUtil.convertDateToStringTypeDateOnly(visitDate) + "<div class='clear'></div>";
										if (pres[1] != null && !pres[1].equals("")) {
											prePrecription += (String) pres[1];
										}
										if (pres[3] != null && !pres[3].equals("")) {
											prePrecription += " | " + (Float) pres[3];
										}
										prePrecription += "<div class='clear'></div>";
									}
								}

								if (previousDiagnosisList.size() > 0) {
									for (Object[] diag : previousDiagnosisList) {
										Date visitDate = (Date) diag[0];
										preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
										if (diag[1] != null && !diag[1].equals("")) {
											preDiagnosis += (String) diag[1] + "<div class='clear'></div>";
										}

									}
								}

								if (previousProcedureList.size() > 0) {
									for (Object[] proc : previousProcedureList) {
										Date visitDate = (Date) proc[0];
										preProcedure += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
										if (proc[1] != null && !proc[1].equals("")) {
											preProcedure += "Procedure--" + (String) proc[1] + "<div class='clear'></div>";
										}

									}
								}
							%>
							<div class="summaryDetails">
								<p><%=preComplaindateWise%></p>
							</div>

						</div>

						<div class="summaryDivMain">
							<label>History</label>
							<div class="summaryDetails">
								<p><%=history%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Systemic Examination</label>
							<div class="summaryDetails">
								<p><%=systemicExamination%></p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="paddingTop5"></div>

						<div class="summaryDivMain">
							<label>Findings</label>
							<div class="summaryDetails">
								<p><%=findings%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Investigations</label>
							<div class="summaryDetails">
								<p><%=preInvestigation%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Prescription</label>
							<div class="summaryDetails">
								<p><%=prePrecription%></p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="paddingTop5"></div>

						<div class="summaryDivMain">
							<label>Diagnosis</label>
							<div class="summaryDetails">
								<p><%=previousDiagnosis != null ? previousDiagnosis : ""%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Treatment</label>
							<div class="summaryDetails">
								<p><%=preProcedure%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Previous Ip Details</label>
							<div class="summaryDetails">
								<p></p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="paddingTop5"></div>

						<div class="summaryDivMain">
							<label>Procedure done</label>
							<div class="summaryDetails">
								<p><%=procedureDone%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<label>Remarks</label>
							<div class="summaryDetails">
								<p><%=opdRemarks%></p>
							</div>
						</div>

						<div class="summaryDivMain">
							<%
								if (departmentCode != null && (departmentCode
										.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
							%>
							<label>Follow Up Notes</label>
							<%
								} else {
							%>
							<label>OPD Review</label>
							<%
								}
							%>
							<div class="summaryDetails">
								<p><%=opdReview%></p>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>

				<div class="clear"></div>
			</div>

			<div id="inTab3" class="inTabcontent">
				<div class="clear"></div>
				<div class="Block">
					<label>MLC certificate </label> <select name="mlscasetype"
						id="mlscasetype" multiple="multiple" class="multiple1" size="5">
						<option value="0">Select</option>
						<option value="Examination by a Medical Officer"
							<%=patientWiseMlcs.contains("Examination by a Medical Officer") ? "selected='selected'" : ""%>>Certificate
							of Examination by a Medical Officer</option>
						<option
							value="Examination by a Specialist Medical Officer/Team of Specialist Medical Officers"
							<%=patientWiseMlcs
					.contains("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers")
							? "selected='selected'"
							: ""%>>Certificate
							of Examination by a Specialist Medical Officer/Team of Specialist
							Medical Officers</option>
						<option value="Accident Register-cum-Wound Certificate"
							<%=patientWiseMlcs.contains("Accident Register-cum-Wound Certificate") ? "selected='selected'" : ""%>>Accident
							Register-cum-Wound Certificate</option>
						<%
							if (visit.getHin().getSex() != null && visit.getHin().getSex().getAdministrativeSexCode().equals("F")
									&& visit.getHin().getSex().getId() == 2) {
						%>
						<option value="Examination of a female victim of sexual assault"
							<%=patientWiseMlcs.contains("Examination of a female victim of sexual assault")
						? "selected='selected'"
						: ""%>>Report
							of examination of a female victim of sexual assault</option>
						<%
							} else {
						%>
						<option value="Examination of a male accused in sexual offence"
							<%=patientWiseMlcs.contains("Examination of a male accused in sexual offence")
						? "selected='selected'"
						: ""%>>Report
							of examination of a male accused in sexual offence</option>
						<%
							}
						%>
						<option value="Certificate Of Drunkness"
							<%=patientWiseMlcs.contains("Certificate Of Drunkness") ? "selected='selected'" : ""%>>Certificate
							Of Drunkness</option>
						<option
							value="Examination of a victim alleged to have been drugged"
							<%=patientWiseMlcs.contains("Examination of a victim alleged to have been drugged")
					? "selected='selected'"
					: ""%>>Report
							of examination of a victim alleged to have been drugged</option>
						<option value="Examination for evidence of recent delivery"
							<%=patientWiseMlcs.contains("Examination for evidence of recent delivery")
					? "selected='selected'"
					: ""%>>Report
							of examination for evidence of recent delivery</option>
						<option
							value="Examination of a victim of unnatural sexual offence"
							<%=patientWiseMlcs.contains("Examination of a victim of unnatural sexual offence")
					? "selected='selected'"
					: ""%>>Report
							of examination of a victim of unnatural sexual offence</option>
						<option value="Treatment / Discharge Certificate"
							<%=patientWiseMlcs.contains("Treatment / Discharge Certificate") ? "selected='selected'" : ""%>>Treatment
							/ Discharge Certificate</option>
						<option value="Examination for estimation of age"
							<%=patientWiseMlcs.contains("Examination for estimation of age") ? "selected='selected'" : ""%>>Report
							of examination for estimation of age</option>
						<option
							value="Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc"
							<%=patientWiseMlcs.contains(
					"Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc")
							? "selected='selected'"
							: ""%>>Certificate
							of collection of material objects from the body of a person for
							chemical examination, DNA profiling, examination at FSL, etc</option>
						<option value="Final opinion as to cause of death"
							<%=patientWiseMlcs.contains("Final opinion as to cause of death") ? "selected='selected'" : ""%>>Final
							opinion as to cause of death</option>
						<option value="Mortuary"
							<%=patientWiseMlcs.contains("Mortuary") ? "selected='selected'" : ""%>>Mortuary</option>
						<option value="Chemical Analysis"
							<%=patientWiseMlcs.contains("Chemical Analysis") ? "selected='selected'" : ""%>>Chemical
							Analysis</option>
						<option value="Application cum No Objection Certificate"
							<%=patientWiseMlcs.contains("Application cum No Objection Certificate") ? "selected='selected'" : ""%>>Form
							of Application cum No Objection Certificate</option>
						<option value="Application cum Certificate of Authenticity"
							<%=patientWiseMlcs.contains("Application cum Certificate of Authenticity")
					? "selected='selected'"
					: ""%>>Form
							of Application cum Certificate of Authenticity</option>
						<!-- <option value="Request for Radiological examination as part of estimation of Age">Request for Radiological examination as part of estimation of Age</option> -->
						<!-- <option value="Proforma for recording dying declaration by a medical practitioner">Proforma for recording dying declaration by a medical practitioner</option> -->

					</select> <label> <%
 	if (opdPatientDetails != null && opdPatientDetails.getPoliceIntimation() != null
 			&& opdPatientDetails.getPoliceIntimation().equalsIgnoreCase("y")
 			&& opdPatientDetails.getVisit().getId().equals(visitId)) {
 %>
						<input type="checkbox" class="radioCheckCol2"
						id="policeIntimation" name="policeIntimation" checked="checked" />Police
						Intimation
					
					<%
						} else {
					%>
					<input type="checkbox" class="radioCheckCol2" id="policeIntimation"
						name="policeIntimation" />Police Intimation
					<%
						}
					%>
					</label>

					<div class="clear"></div>
				</div>

				<%
					List<Object[]> previousComplaintListPsychogeriatricClinic = new ArrayList<Object[]>();
					List<Object[]> psychogeriatricClinic = new ArrayList<Object[]>();
					List<Object[]> systemicExmListpsychogeriatricClinic = new ArrayList<Object[]>();
					List<PatientPrescriptionDetails> psychogeriatricClinic_prescriptionDetails = new ArrayList<PatientPrescriptionDetails>();
				%>
				<div class="clear"></div>
			</div>

			<div id="inTab4" class="inTabcontent">
				<div class="clear"></div>
				<!-- code added by rajdeo -->
				<div style="width: 100%; height: auto;" id="specialityDiv"></div>
				<div class="clear"></div>
			</div>

			<!-- Added by Arbind -->
			<div id="inTab6" class="inTabcontent">
				<div class="clear"></div>
				<div style="width: 100%; height: auto;" id="specialitySummaryDiv"></div>
				<div class="clear"></div>
			</div>

			<!-- code added by rajdeo speciality summary -->
			<div id="inTab5" class="inTabcontent">

				<div class="clear"></div>
				<div class="paddingTop5"></div>

				<h6>Speciality Clinical Summary</h6>
				<div class="clear"></div>

				<div class="summaryDivMain">
					<label>Previous Complaints</label>
					<div class="summaryDetails">
						<p></p>
					</div>
				</div>

				<div class="summaryDivMain">
					<label>History</label>
					<div class="summaryDetails">
						<p></p>
					</div>
				</div>
				<div class="clear"></div>
				<div class="paddingTop5"></div>

				<div class="summaryDivMain">
					<label>Primary Lesion</label>
					<div class="summaryDetails">
						<p></p>
					</div>
				</div>

				<div class="summaryDivMain">
					<label>Seconday Lesion</label>
					<div class="summaryDetails">
						<p></p>
					</div>
				</div>

				<div class="clear"></div>
				<div class="paddingTop5"></div>

				<div class="summaryDivMain">
					<label>Findings</label>
					<div class="summaryDetails">
						<p></p>
					</div>
				</div>
				<div class="clear"></div>
			</div>

			<div id="inTab4" class="inTabcontent">
				<div class="clear"></div>
				<div style="width: 100%; height: 200px;" id="specialityDiv"></div>
				<div class="clear"></div>
			</div>

			<!-- =======Inner tab end here====== -->

			<div class="clear"></div>
			<div id="opdCommon" class="Block">
				<div class="titleBg">
					<h2>DIAGNOSIS</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<%
				String provisionalDiagnosis=null;
				String finalDiagnosis=null;
				String otherDiagnosis=null;
				 	String pDiagnosis = null;
					String fDiagnosis = null;
					String dDiagnosis = null;
					String diffDiagnosis = null;
					if (dischargeIcdCodeLast3Visit != null) {
						for (DischargeIcdCode dIcd : dischargeIcdCodeLast3Visit) {
							if (dIcd.getDiagnosisStatus().equalsIgnoreCase("p"))
								pDiagnosis = pDiagnosis != null
										? pDiagnosis + "\n" + dIcd.getIcd().getIcdName()
										: dIcd.getIcd().getIcdName();
							else if (dIcd.getDiagnosisStatus().equalsIgnoreCase("f"))
								fDiagnosis = fDiagnosis != null
										? fDiagnosis + "\n" + dIcd.getIcd().getIcdName()
										: dIcd.getIcd().getIcdName();

							else if (dIcd.getDiagnosisStatus().equalsIgnoreCase("d"))
								dDiagnosis = dDiagnosis != null
										? dDiagnosis + "\n" + dIcd.getIcd().getIcdName()
										: dIcd.getIcd().getIcdName();

							else if (dIcd.getDiagnosisStatus().equalsIgnoreCase("diff"))
								diffDiagnosis = diffDiagnosis != null
										? diffDiagnosis + "\n" + dIcd.getIcd().getIcdName()
										: dIcd.getIcd().getIcdName();
						}
					}
					 
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

<%-- 				<div class="tabContWidth2">

					<label>Provisional Diagnosis</label>
					<textarea class="textYellow historyAutoComplete" id="snomed"
						<%=pDiagnosis != null ? "style='width:272px;'" : ""%> name="snomed"
						maxlength="500"
						<%=deferredDiagnosis != null && deferredDiagnosis.equalsIgnoreCase("y") ? "readonly='readonly'" : ""%>
						validate="Provisional Diagnosis,string,no"></textarea>
					<%
						if (pDiagnosis != null) {
					%>
					<textarea readonly="readonly" style="width: 276px;"><%=pDiagnosis%></textarea>
					<%
						}
					%>
					<input type="hidden" id="snomedTermConceptIdEXM"
						name="snomedTermConceptIdEXM" /> <input type="hidden"
						name="snomedTermConceptId" id="snomedTermConceptId" />
				</div>

				<div class="tabContWidth2">
					<label>Final Diagnosis</label>
					<textarea name="finalDiagnosis" id="finalDiagnosis"
						<%=fDiagnosis != null ? "style='width:272px;'" : ""%> maxlength="500"
						class="textYellow historyAutoComplete ui-autocomplete-input"
						<%=deferredDiagnosis != null && deferredDiagnosis.equalsIgnoreCase("y") ? "readonly='readonly'" : ""%>
						validate="Final Diagnosis,string,no"> </textarea>
					<%
						if (fDiagnosis != null) {
					%>
					<textarea readonly="readonly" style="width: 276px;"><%=fDiagnosis%></textarea>
					<%
						}
					%>
				</div> --%>
				<%
					if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
				%>
				<div class="tabContWidth2">
					<label>Differential Diagnosis</label>
					<textarea name="differentialDiagnosis" id="differentialDiagnosis"
						<%=diffDiagnosis != null ? "style='width:276px;'" : ""%> maxlength="300"
						class="textYellow historyAutoComplete ui-autocomplete-input"
						<%=deferredDiagnosis != null && deferredDiagnosis.equalsIgnoreCase("y")
						? "readonly='readonly'"
						: ""%>
						validate="Differential Diagnosis,string,no"> </textarea>
					<%
						if (finalDiagnosis != null) {
					%>
					<textarea readonly="readonly" style="width: 276px;"><%=diffDiagnosis%></textarea>
					<%
						}
					%>
				</div>

				<div class="paddingTop5"></div>
				<%
					if (dischargeIcdCodeLast3Visit.size() == 0) {
				%>
				<label class="autoSpace "><input id="deferredDiagnosis"
					name="deferredDiagnosis" class="radioCheckCol2"
					onchange="deferredDiagnosisChk(this)" type="checkbox"
					<%=deferredDiagnosis != null && deferredDiagnosis.equalsIgnoreCase("y")
							? "checked='checked'"
							: ""%>>Diagnosis
					Deferred</label>
				<%
					}
				%>
				<%
					}
				%>

				<div style="display: none">
					<input type="hidden" tabindex="30" class="textYellow" tabindex="23"
						id="snomedNames" name="snomedNames" /> <input type="hidden"
						tabindex="30" class="textYellow" tabindex="23" id="icd1"
						name="icd1" /> <label>Diagnosis</label>
					<!-- <input type="text" tabindex="30" class="textYellow"	tabindex="23" id="snomed" name="snomed"	onblur="getICDListBasedOnSnomedId();"
						onkeypress="selectSNOMEDCT('ACTIVE','DISORDER','ALL',returnlimit_IN,callbck_index,'snomed');" style="width:278px; margin-right:0px;" /> -->
					<img src="/hms/jsp/images/removeBu.png" width="18" height="18"
						title="Remove Snomed Diagnosis" id="removeSnomed"
						style="cursor: pointer;" /> <label class="auto">Diagnosis
						to be printed on Prescription</label> <input type="checkbox"
						name="diagnosisCheck" id="diagnosisCheck" value="y"
						checked="checked" />
					<div class="clear"></div>
					<label>Selected Diagnosis</label> <select name="snomedList"
						multiple="4" id="snomedList" class="listBig"
						style="font: 12px; height: 60px; width: 282px; margin-right: 0px;"
						validate="snomedList,string,no">

					</select> <img src="/hms/jsp/images/removeBu.png" width="18" height="18"
						title="Remove Snomed" id="removesnomedList"
						style="cursor: pointer;" /> <label class="auto">Other
						Diagnosis</label>
					<textarea class="medium" validate="Other Diagnosis,string,no"
						id="OtherDiagnosis" name="OtherDiagnosis" cols="0" rows="0"
						maxlength="100" tabindex="25"><%=opdPatientDetails != null && opdPatientDetails.getInitialDiagnosis() != null
					&& opdPatientDetails.getVisit().getId().equals(visitId)
							? opdPatientDetails.getInitialDiagnosis().trim()
							: ""%></textarea>

					<div id="divIcdName" style="display: none;">
						<label> Select ICD Name </label> <select id="icdName"
							name="icdName"></select>
					</div>

					<div class="clear"></div>
					<label>ICD code</label>
					<!-- <input name="icdCode" tabindex="26" class="textYellow" value="" id="icdCode" onblur="getIcd(1);" /> -->
					<input name="icdCode" tabindex="31" class="textYellow" value=""
						id="icdCode" readonly /> <input name="temp" value="" id="temp"
						type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="24"
						HEIGHT="20" tabindex="31" class="search-img"
						onClick="javascript:openPopupDiagnosisWindow();"
						title="Click here to Search ICD Codes" /> Notifiable Desease</label> <label
						class="smallAuto"><img
						src="/hms/jsp/images/grey_rectangle.jpg" width="14" height="14" />P-Register</label>

					<div class="clear"></div>

					<div class="paddLeftP100">
						<select name="diagnosisId" multiple="4" id="diagnosisId"
							class="listBig"
							style="font: 12px; height: 60px; margin-right: 0px; margin-right: 0px;"
							validate="diagnosisId,string,no">
							<%
								for (DischargeIcdCode dIcd : dischargeIcdCodeLast3Visit) {
									MasIcd masIcd = dIcd.getIcd();

									String icdName = masIcd.getIcdName();
									String icdCode = masIcd.getIcdCode();
									int icdId = dIcd.getId();
									int dischargeId = dIcd.getId();
									String diaStatus = dIcd.getDiagnosisStatus();
							%>
							<option
								value="<%=icdCode%>@@@<%=masIcd.getSnomedConceptId()%>-<%=dischargeId%>-<%=diaStatus%>"
								selected="selected">
								<%=icdName%>[<%=icdCode%>]
							</option>
							<%
								}
							%>
						</select> <img src="/hms/jsp/images/removeBu.png" width="18" height="18"
							title="Remove diagnosis" id="removeOPDisgnosis"
							style="cursor: pointer;" /> <select name="diagnosisIdNP"
							multiple="4" id="diagnosisIdNP" class="listBig"
							style="font: 12px; height: 60px; margin-left: 75px; width: 284px;">
							<%
								for (DischargeIcdCode dIcd : dischargeIcdCodeLast3Visit) {
									MasIcd masIcd = dIcd.getIcd();
									String icdName = masIcd.getIcdName();
									String icdCode = masIcd.getIcdCode();
									if (masIcd.getNotifiableDesease() != null && masIcd.getNotifiableDesease().equalsIgnoreCase("n")) {
							%>
							<option style="color: #FF0000;"><%=icdName%>[<%=icdCode%>]
							</option>
							<%
								}
							%>
							<%
								if (masIcd.getPRegister() != null && masIcd.getPRegister().equalsIgnoreCase("p")) {
							%>
							<option style="color: #008000;"><%=icdName%>[<%=icdCode%>]
							</option>
							<%
								}
							%>
							<%
								}
							%>
						</select>
					</div>

				</div>
				<div class="clear"></div>
				<%
					if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
				%>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
				<div class="titleBg">
					<h2>Ordering Procedure and entering the findings</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
				<textarea class="large"
					validate="Ordering Procedure and findings,string,no"
					id="orderingProcedure" name="orderingProcedure" cols="0" rows="0"
					maxlength="500" tabindex="26" style="width: 1159px;"><%=orderingProcedure != null ? orderingProcedure : ""%></textarea>
				<%
					}
				%>
				<!-- ----- -->
				<%
					if (departmentCode
							.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralSurgery"))) {
				%>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
				<div class="titleBg">
					<h2>Management Plan</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
				<%-- <label class="auto"><%= departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))?"Non-pharmacological Advice":"Treatment Plan" %> </label> --%>
				<textarea class="large" validate="P/S,string,no" id="managementPlan"
					name="managementPlan" cols="0" rows="0" maxlength="500"
					tabindex="26" style="width: 1159px;"><%=managementPlan != null ? managementPlan : ""%></textarea>
				<%
					}
				%>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div class="titleBg">
					<h2>Treatment Plan</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<textarea class="large" validate="P/S,string,no" id="treatmentPlan"
					name="treatmentPlan" cols="0" rows="0" maxlength="500"
					tabindex="26" style="width: 1159px; height: 40px;"><%=treatmentPlan != null ? treatmentPlan : ""%></textarea>

				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<%
					if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDental"))) {
				%>
				<div class="titleBg">
					<h2>Referral</h2>
				</div>
				<table border="0" cellspacing="0" cellpadding="0"
					style="border-top: 1px solid #c0c0c0; ! important; font-size: 14px;">
					<tbody>
						<tr>
							<td><input name="maxillofacialSurgeryReferral"
								id="maxillofacialSurgeryReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> PlainOral and Maxillofacial Surgery</td>
							<td><input name="prosthodonticsReferral"
								id="prosthodonticsReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Prosthodontics</td>
							<td><input name="periodonticsReferral"
								id="periodonticsReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Periodontics</td>
						</tr>

						<tr>
							<td><input name="oralPathologAndLabReferral"
								id="oralPathologAndLabReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Oral Pathology and Lab</td>
							<td><input name="conservativeDentistryReferral"
								id="conservativeDentistryReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Conservative Dentistry</td>
							<td><input name="paedodonticsReferral"
								id="paedodonticsReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Paedodontics</td>
						</tr>

						<tr>
							<td><input name="publicHealthDetistryReferral"
								id="publicHealthDetistryReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Public Health Detistry</td>
							<td><input name="oralMedicineAndRadiologyReferral"
								id="oralMedicineAndRadiologyReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Oral Medicine and Radiology</td>
							<td><input name="orthodonticsReferral"
								id="orthodonticsReferral" class="radioCheckCol2 mt4"
								type="checkbox" /> Orthodontics</td>
						</tr>

					</tbody>
				</table>
				<%
					}
				%>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div class="titleBg">
					<h2>INVESTIGATIONS</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>

				<div class="invleftDiv">
					<input type="hidden" name="investigationCategory"
						id="investigationCategory" />
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics"))) {
					%>
					<div style="width: 245px; float: left;">
						<label class="medium">Laboratory <input
							class="radioCheckCol2" value="Lab" id="labradiologyCheck"
							name="labradiologyCheck" type="radio" checked="checked">
						</label> <label class="medium">Radiology <input
							class="radioCheckCol2" value="Radio" id="labradiologyCheck"
							name="labradiologyCheck" type="radio">
						</label>
						<div class="clear"></div>
						<div class="clear"></div>
					</div>
					<%
						}
					%>
					<div class="labelMargeDiv" style="width: 104px;">

						<label class="small-medium"
							style="margin-right: 5px; width: 90px;"><input
							class="radioCheckCol2" name="invTempType" id="invTempType_global"
							onchange="getTemplate('global','i','');" type="radio">Local</label>
						<div class="clear"></div>
						<div class="clear"></div>
						<label style="margin-right: 5px; width: 90px;"><input
							class="radioCheckCol2" name="invTempType" id="invTempType_local"
							onchange="getTemplate('local','i','');" type="radio">Individual</label>
						<div class="clear"></div>
						<div class="clear"></div>
						<label class="small-medium"
							style="margin-right: 5px; width: 90px;"><input
							class="radioCheckCol2" name="invTempType" id="invTempType_global"
							onchange="getTemplate('all','i','');" type="radio">Global</label>
						<%
							if (!empDeptCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {
						%>
						<div class="extlabDiv">
							<h4
								onclick="popwindowResultEntryForDermotology('<%=hinId%>@@@<%=visitId%>@@@<%=deptName%>');">External
								Lab Report Entry</h4>
						</div>
						<%
							}
						%>
					</div>
					<div class="paddLeft30">
						<select class="medium" multiple="5"
							style="height: 83px; width: 140px;" name="tempLateInvestigation"
							id="tempLateInvestigation"
							onchange="fnGetInvestigationTemplate(this);">
							<option value="-1">Select</option>
							<%
								for (OpdTemplate opd : templateListForInvestigation) {
							%>
							<%
								if (opd.getTemplateType().equalsIgnoreCase("i")
											&& opd.getDepartment().getId() == visit.getDepartment().getId()
											&& opd.getOpdTemplateInvestigations().size() > 0) {
							%>
							<option value="<%=opd.getId()%>"><%=opd.getTemplateName()%></option>
							<%
								}
							%>
							<%
								}
							%>
						</select>
						<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int kIndex = 0;
			for (OpdTemplate opd : templateListForInvestigation) {%>
					<%if (opd.getTemplateType().equalsIgnoreCase("i")
						&& opd.getDepartment().getId() == visit.getDepartment().getId()
						&& opd.getOpdTemplateInvestigations().size() > 0) {%>
					tempArrayTemp[<%=kIndex%>]= new Array();
					tempArrayTemp[<%=kIndex%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=kIndex%>][1] = "<%=opd.getTemplateName()%>";
					<%kIndex++;%>
					<%}%>
				<%}%>
				</script>
					</div>
					<div class="clear"></div>
					<input name="Prevoius" type="button" value="Last Investigation"
						style="height: 22px;" class="buttonBig"
						onclick="openPopupForPatientInvestigationLP('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','LP',csrfTokenName+'='+csrfTokenValue)" />
				</div>

				<div class="invRightDiv" id="labInvDiv">

					<table style="width: 100%; border-top: solid 1px #C0C0C0"
						id="investigationGrid">
						<tr>
							<th style="background: #bdd6ee; text-align: center;">&nbsp;</th>
							<th style="background: #bdd6ee;">Test Name</th>
						</tr>

						<tr>
							<%
								int inc = 0;
								len = 3;
								if (dgOrderdts.size() > 0) {
									len = dgOrderdts.size();
								}
								String chargeCodeName = "";
								String chargeCodeNotes = "";
								Integer dtHids = 0;
								Integer dtIds = 0;
								Integer pInvHd = 0;
								Integer pInvDt = 0;
								Integer pDgSHd = 0;
								Integer pDgSDt = 0;
								String orderStatus = "";
								Integer dgSampleId = 0;
								String clinicalNotes = "";
								Integer dgSampleHdId = 0;
								String avlStatus = "";
								int chargeCodeId = 0;
								Map<Integer, Integer> dgSampleCollectionMap = new HashMap<Integer, Integer>();
								for (; inc < dgSampleCollectionDetails.size(); inc++) {
									DgSampleCollectionDetails sampleCollectionDetails = (DgSampleCollectionDetails) dgSampleCollectionDetails
											.get(inc);
									chargeCodeId = sampleCollectionDetails.getChargeCode().getId();
									dgSampleId = sampleCollectionDetails.getId();
									dgSampleHdId = sampleCollectionDetails.getSampleCollectionHeader().getId();
									dgSampleCollectionMap.put(chargeCodeId, dgSampleId);
								}
								inc = 0;
								for (; inc < len; inc++) {
									if ((dgOrderdts.size() > 0 && patientInvestigationDetails.size() > 0)
											&& ((dgOrderdts.size() == patientInvestigationDetails.size()))) {
										DgOrderdt dgOrderdt = dgOrderdts.get(inc);
										PatientInvestigationDetails patientInvestigationDetail = patientInvestigationDetails.get(inc);
										chargeCodeName = dgOrderdt.getChargeCode().getChargeCodeName() + "["
												+ dgOrderdt.getChargeCode().getId() + "]";
										orderStatus = dgOrderdt.getOrderStatus();

										dtHids = dgOrderdt.getOrderhd().getId();
										dtIds = dgOrderdt.getId();

										clinicalNotes = patientInvestigationDetail.getClinicalNotes();
										avlStatus = patientInvestigationDetail.getAvailableStatus();
										pInvHd = patientInvestigationDetail.getInvestigationHeader().getId();
										pInvDt = patientInvestigationDetail.getId();

										chargeCodeId = dgOrderdt.getChargeCode().getId();
										dgSampleId = (Integer) dgSampleCollectionMap.get(chargeCodeId);
									}
							%>
						
						<tr>
							<td>
								<%
									if (orderStatus.equalsIgnoreCase("p")) {
								%> <input type="checkbox"
								disabled="disabled" class="radioCheck"
								name="chargeRadio<%=inc%>" id="chargeRadio<%=inc%>" /> <%
 	} else {
 %>
								<input type="checkbox" class="radioCheck"
								name="chargeRadio<%=inc%>" id="chargeRadio<%=inc%>" /> <%
 	}
 %> <input
								type="hidden" name="parkInvestigationId<%=inc%>"
								id="parkInvestigationId<%=inc%>"
								value="<%=dtIds%>-<%=pInvDt%>-<%=dgSampleId != null ? dgSampleId : "0"%>" />
								<input type="hidden" name="availableStatus<%=inc%>"
								id="availableStatus<%=inc%>" value="<%=avlStatus%>" />
							</td>
							<td>
								<%
									if (orderStatus.equalsIgnoreCase("p")) {
								%> <input
								readonly="readonly" type="text"
								<%=!availableInvesStatus.contains(chargeCodeId) ? "style='color:red'" : ""%>"
													class="textYellow largTextBoxOpd popper"
								data-popbox="pop1" value="<%=chargeCodeName%>"
								title="<%=chargeCodeName%>" id="chargeCodeName<%=inc%>"
								size="65" name="chargeCodeName<%=inc%>"
								onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
								onblur="checkInvestigationItem(<%=inc%>);getLoincSnomedList('<%=inc%>');if(validateInvestigationAutoComplete(this.value,'<%=inc%>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc%>','chargeCodeVal<%=inc%>');}" />
								<%
									} else {
								%> <input type="text"
								class="textYellow largTextBoxOpd popper" data-popbox="pop1"
								<%=!availableInvesStatus.contains(chargeCodeId) ? "style='color:red'" : ""%>"
													value="<%=chargeCodeName%>"
								title="<%=chargeCodeName%>" id="chargeCodeName<%=inc%>"
								size="65" name="chargeCodeName<%=inc%>"
								onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
								onblur="getUnavailableInvestigation(<%=inc%>);checkInvestigationItem(<%=inc%>);getLoincSnomedList('<%=inc%>');if(validateInvestigationAutoComplete(this.value,'<%=inc%>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=visit.getHin().getId()%>&rowVal=<%=inc%>','chargeCodeVal<%=inc%>');}" />
								<%
									}
								%>

								<div id="ac2update<%=inc%>" style="display: none;"
									class="autocomplete"></div> <script type="text/javascript"
									language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc%>','ac2update<%=inc%>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc%>&fromOpd=fromOpd'});
				</script>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<input type="hidden" name="hiddenValue" id="hiddenValue"
						value="<%=inc%>" />
					 <input type="hidden"
										name="dhHeaderIds" id="dhHeaderIds"
										value="<%=dtHids%>-<%=pInvHd%>-<%=dgSampleHdId%>" />
				</div>
				<div style="background-color: floralwhite; float: left;">
					<input class="addButSmll" alt="Add" value="&nbsp;" type="button"
						onclick="addRowInvestigationForLP();"> <input
						class="delButSmll" alt="Delete" value="&nbsp;" type="button"
						onclick="removeRowForInvestigation();">

					<div class="clear"></div>
				</div>

				<div>
					<input class="buttonSmall" name="prev"
						style="height: 22px; font-size: 12px;" value="Save As Template"
						onclick="javascript:openPopupForSaveInvestigationLP();"
						type="button">
				</div>
				<div class="clear"></div>
				<%
					if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
				%>
				<!-- ------Lab Examination--------- -->
				<div class="clear"></div>
				<div class="paddingTop2"></div>

<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="displayCollapsibleTabForLabResultDermoLeprosy('Lab Result Leprosy')" id="labResultLeprosyId"	name="" value="+" type="button">
</div>
				<div class="plusText">
					<h4 class="h4Tab">Lab Result</h4>
				</div>
				<div class="clear"></div>
				<div class="clear"></div>
				<div class="clear"></div>
				<div id="labResultLeprosy" class="collapasHide"
					style="width: 1158px;">

					<div class="indArrow"></div>
					<!-- changes for external lab report -->

					<div class="Block">
						<div class="clear"></div>
						<%
							if (commonLabTestReports != null && sortedTestDate != null && commonLabTestReportsMap.size() > 0) {
									String testName = null;
						%>
						<label>Lab test report</label>
						<div class="tableForTab" style="width: 910px">
							<div id="divTemplet2">
								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="OutSidelabResult">
									<tr>
										<th>Test Name</th>
										<%
											int labIndex = 0;
													for (; labIndex < sortedTestDate.size(); labIndex++) {
										%>
										<th><%=HMSUtil.convertStringDateFormat(sortedTestDate.get(labIndex))%>
										</th>
										<%
											}
										%>
									</tr>

									<%
										Iterator records = commonLabTestReportsMap.entrySet().iterator();
												while (records.hasNext()) {
													Map.Entry entry = (Map.Entry) records.next();
													String key = (String) entry.getKey();
									%>

									<tr>
										<td style="width: 175px;"><input type="text" name="testN"
											value="<%=key%>" readonly="readonly" /></td>

										<%
											List<CommonLabTestReport> testDispList = new ArrayList<CommonLabTestReport>();
														testDispList = (ArrayList<CommonLabTestReport>) entry.getValue();
														for (int dateIndex = 0; dateIndex < sortedTestDate.size(); dateIndex++) {
															List<CommonLabTestReport> localList = new ArrayList<CommonLabTestReport>();
															for (CommonLabTestReport reportList : testDispList) {

																if (sortedTestDate != null
																		&& sortedTestDate.get(dateIndex).equalsIgnoreCase(reportList.getResultDate())) {
																	localList.add(reportList);
																}
															}

															//single test start
															if (localList.size() == 1) {
										%>
										<%
											if (localList.get(0).getTestType().equalsIgnoreCase("Internal Test")) {
										%>
										<td><a
											href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getDgId()%>','<%=localList.get(0).getInvestigationId()%>');">Lab
												Results</a></td>
										<%
											}
										%>
										<%
											if (localList.get(0).getTestType().equalsIgnoreCase("External Test")) {
																	if (localList.get(0).getTestStatus() != null
																			&& !localList.get(0).getTestStatus().equals("")
																			&& localList.get(0).getTestResult().equals("")) {
										%>
										<td><a
											href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getInvestigationId()%>','<%=localList.get(0).getResultDate()%>','<%=hinId%>','<%=localList.get(0).getResultTime()%>');">Lab
												Results</a></td>
										<%
											} else if (localList.get(0).getTestStatus() != null
																			&& !localList.get(0).getTestStatus().equals("")
																			&& localList.get(0).getTestStatus().equalsIgnoreCase("Abnormal")) {
										%>
										<td><%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")
												+ "<b>(Abnormal)</b>"%>
										</td>
										<%
											} else {
										%>
										<td><%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")%>
										</td>
										<%
											}
																}
															}
															//single test end
															if (localList.size() == 0) {
										%>
										<td>-</td>


										<%
											}
										%>
										<%
											if (localList.size() > 1) {
										%>
										<td>
											<%
												String res = "";
																	String hLink = "";
																	for (CommonLabTestReport finalReport : localList) {
																		String testResult = "";
																		if (finalReport.getTestType().equalsIgnoreCase("External Test")) {
																			if (finalReport.getTestResult() == null
																					|| finalReport.getTestResult().equals("")) {
																				if (!finalReport.getResultTime().equals("00:00"))
																					hLink = "<a href=".concat("\"").concat(
																							"javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'")
																							.concat("" + finalReport.getInvestigationId()).concat("'")
																							.concat(",").concat("'").concat(finalReport.getResultDate())
																							.concat("'").concat(",").concat("'" + hinId).concat("'")
																							.concat(",'" + finalReport.getResultTime() + "'").concat(");")
																							.concat("\"").concat(">Lab Results - "
																									+ finalReport.getResultTime() + "</a>");
																				else
																					hLink = "<a href=".concat("\"").concat(
																							"javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'")
																							.concat("" + finalReport.getInvestigationId()).concat("'")
																							.concat(",").concat("'").concat(finalReport.getResultDate())
																							.concat("'").concat(",").concat("'" + hinId).concat("'")
																							.concat(",'" + finalReport.getResultTime() + "'").concat(");")
																							.concat("\"").concat(">Lab Results</a>");

																				res = res.concat("\n").concat(hLink);
																			}
																			if (finalReport.getTestResult() != null
																					&& !finalReport.getTestResult().equals("")) {
																				if (!finalReport.getResultTime().equals("00:00")) {
																					if (finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
																						testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																								"") + "<b>(Abnormal)</b>" + "-"
																								+ finalReport.getResultTime();
																					else
																						testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																								"") + "-" + finalReport.getResultTime();
																				} else {
																					if (finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
																						testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																								"");
																					else
																						testResult = finalReport.getTestResult().replaceFirst("^0+(?!$)",
																								"") + "<b>(Abnormal)</b>";
																				}
																				res = res.concat(testResult).concat(", ");
																			}
																		} // external test end here
																			// internal test starts here
																		if (finalReport.getTestType().equalsIgnoreCase("Internal Test")) {
																			if (finalReport.getTestResult() == null
																					|| finalReport.getTestResult().equals("")) {

																				hLink = "<a href=".concat("\"").concat(
																						"javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'")
																						.concat("" + finalReport.getDgId()).concat("'").concat(",")
																						.concat("'").concat("" + finalReport.getInvestigationId())
																						.concat("'").concat(");").concat("\"")
																						.concat(">Lab Results - " + finalReport.getResultTime() + "</a>");

																				res = res.concat("\n").concat(hLink);
																			}
																		} // internal test end here
																	} // end of for loop
											%> <%=res%>
										</td>
										<%
											}
														}
													}
										%>
									</tr>
								</table>
							</div>
						</div>
						<%
							} else {
						%>
						<span>No Test Record found</span>
						<%
							}
						%>
					</div>
					<!-- changes for external lab report end -->
				</div>

				<!-- ------Lab Examination End--------- -->
				<%
					}
				%>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div class="titleBg">
					<h2>PRESCRIPTION</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<!-- <div style="width: 900px; float: left;"> -->
				<label style="width: 90px;">All<input class="radioCheckCol2"
					value="" id="pharmacyCheck" name="pharmacyCheck" type="radio">
				</label> <label class="medium">Tablet <input class="radioCheckCol2"
					value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForTablet")%>"
					id="pharmacyCheck" name="pharmacyCheck" type="radio">
				</label> <label class="medium">Capsule <input class="radioCheckCol2"
					value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForCapsule")%>"
					id="pharmacyCheck" name="pharmacyCheck" type="radio">
				</label> <label class="medium">Injection <input
					class="radioCheckCol2"
					value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "itemClassForInjection")%>"
					id="pharmacyCheck" name="pharmacyCheck" type="radio"> <input
					type="hidden" name="pharmacyCategory" id="pharmacyCategory" /></label> <label
					class="auto">Do you want to prescribe NON KMSCL medicine <!-- <input class="radioCheckCol2" 
					id="pharmacyCheck" name="pharmacyCheck" type="checkbox" onclick="switchVisible();">  -->
					<%
						if (patientOtherPrescriptionDetails.size() > 0) {
					%> <input class="radioCheckCol2" type="checkbox" value="Click"
					onclick="switchVisible();" checked="checked" /> <script>switchVisible();</script>
					<%
						} else {
					%> <input class="radioCheckCol2" type="checkbox"
					value="Click" onclick="switchVisible();" />
					<%
						}
					%>

				</label> <input type="button" class="buttonBig" name="prev"
					style="height: 22px;" value="Save As Template"
					onclick="javascript:openPopupForSavePrescriptiontamplate();" />

				<div class="clear"></div>
				<div style="width: 257px; float: left;">

					<div class="labelMargeDiv" style="width: 104px;">


						<label class="small-medium"
							style="margin-right: 5px; width: 90px;"> <input
							class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_local" onchange="getTemplate('local','p','');"
							type="radio"> Local
						</label>
						<div class="clear"></div>
						<div class="clear"></div>
						<label style="margin-right: 5px; width: 90px;"> <input
							class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_indiviual"
							onchange="getTemplate('individual','p','');" type="radio">
							Individual
						</label> <label class="small-medium"
							style="margin-right: 5px; width: 90px;"> <input
							class="radioCheckCol2" name="invTempTypePres"
							id="presTempType_global" onchange="getTemplate('global','p','');"
							type="radio"> Global
						</label>
						<div class="clear"></div>
						<div class="paddingTop5"></div>
						<div class="paddingTop5"></div>
						<input name="Prevoius2" type="button" class="buttonBig"
							value="Last Prescription" style="height: 22px;"
							onclick="openPopupForPatientPrescriptionLP('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>','<%=visit.getId()%>','LP',csrfTokenName+'='+csrfTokenValue)" />
					</div>
					<div class="paddLeft30">
						<select class="medium" multiple="5"
							style="height: 83px; width: 140px;" name="tempLatePrescription"
							id="tempLatePrescription"
							onchange="fnGetPrescriptionTemplate(this);setDisablePharmacy();"
							onblur="setDisablePharmacy();" onclick="setDisablePharmacy();">
							<option value="-1">Select</option>
							<%
								for (OpdTemplate opd : templateListForInvestigation) {
							%>
							<%
								if (opd.getTemplateType().equalsIgnoreCase("P")
											&& opd.getDepartment().getId() == visit.getDepartment().getId()
											&& opd.getOpdTemplateTreatments().size() > 0) {
							%>
							<option value="<%=opd.getId()%>"
								title="<%=opd.getTemplateName()%>"><%=opd.getTemplateName()%></option>
							<%
								}
							%>
							<%
								}
							%>
						</select>
						<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int pIndexTab = 0;
			for (OpdTemplate opd : templateListForInvestigation) {%>
					<%if (opd.getTemplateType().equalsIgnoreCase("P")
						&& opd.getDepartment().getId() == visit.getDepartment().getId()
						&& opd.getOpdTemplateTreatments().size() > 0) {%>
					tempArrayTemp[<%=pIndexTab%>]= new Array();
					tempArrayTemp[<%=pIndexTab%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=pIndexTab%>][1] = "<%=opd.getTemplateName()%>";
					<%pIndexTab++;%>
					<%}%>
				<%}%>
				</script>
					</div>
				</div>

				<div style="width: 850px; float: left;">
					<table style="width: 100%; border-top: solid 1px #C0C0C0;"
						id="grid">
						<tr>
							<th style="background: #bdd6ee;">&nbsp;</th>
							<th style="background: #bdd6ee;">Drug Name</th>
							<th style="background: #bdd6ee;">Route</th>
							<th style="background: #bdd6ee;">Dosage</th>
							<th style="background: #bdd6ee;">Unit</th>
							<th style="background: #bdd6ee;">Frequency</th>
							<th style="background: #bdd6ee;">Duration</th>
							<th style="background: #bdd6ee;">Instruction</th>
							<th style="background: #bdd6ee;">CT</th>

						</tr>

						<%
							incr = 0;
							len = 3;
							if (patientPrescriptionDetails.size() > 0) {
								len = patientPrescriptionDetails.size();
							} else {
								len = 3;
							}
							Integer pHeaderId = 0;
							for (; incr < len; incr++) {
								String nomeclature = "";
								Integer ItemId = 0;
								String pvmsNo = "";
								int routeId = 0;
								int frequencyId = 0;
								int inctrunctionId = 0;
								String unit = "";
								String frequecnyType = "";
								Float dosage = 0f;
								int ndays = 0;
								Float total = 0f;
								Date sDate = null;
								Date eDate = null;
								String issuedStatus = "";
								String routeName = "";
								PatientPrescriptionDetails pd = null;
								String pAvailableStatus = "";
								String conversion = "";
								String specialInstruction = null;
								if (patientPrescriptionDetails.size() > 0) {
									pd = patientPrescriptionDetails.get(incr);
									pHeaderId = pd.getPrescription().getId();
									ItemId = pd.getItem().getId();
									if (pd.getIssuedStatus() != null && !pd.getIssuedStatus().equals("")
											&& pd.getIssuedStatus().equalsIgnoreCase("y")) {
										issuedStatus = pd.getIssuedStatus();
									}
									if (pd.getNotAvailable() != null) {
										pAvailableStatus = pd.getNotAvailable();
									}
									nomeclature = pd.getItem().getNomenclature();
									pvmsNo = pd.getItem().getPvmsNo();
									dosage = pd.getDosage();
									//unit=pd.getItem().getDispUnit();
									unit = pd.getItem().getDispUnit() != null
											? pd.getItem().getDispUnit()
											: pd.getItem().getItemConversion().getItemUnitName();
									conversion = pd.getItem().getItemConversion().getItemUnitName();
									total = pd.getTotal();
									frequecnyType = pd.getFrequency().getFrequencyType();
									ndays = pd.getNoOfDays();
									sDate = pd.getStartDate();
									eDate = pd.getEndDate();
									specialInstruction = pd.getSplInstruction();
									if (pd.getRoute() != null) {
										routeId = pd.getRoute().getId();
										routeName = pd.getRoute().getRouteName();
									}
									if (pd.getFrequency() != null) {
										frequencyId = pd.getFrequency().getId();
									}
									if (pd.getInsrtuction() != null) {
										inctrunctionId = pd.getInsrtuction().getId();
									}
									if (ItemId != 0 && !pvmsNo.equals("")) {
										nomeclature = nomeclature + "(" + ItemId + ")[" + pvmsNo + "]";
									}
								}
						%>
						<tr>
							<td>
								<%
									if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
								%>
								<input type="checkbox" disabled="disabled" class="radioCheck"
								id="itemRadioCheck<%=incr%>" name="itemRadio<%=incr%>" /> <%
 	} else {
 %>
								<input type="checkbox" class="radioCheck"
								id="itemRadioCheck<%=incr%>" name="itemRadio<%=incr%>" /> <%
 	}
 %> <input
								type="hidden" id="parkPrescriptionIds<%=incr%>"
								name="parkPrescriptionIds<%=incr%>"
								value="<%=pd != null && pd.getId() != 0 ? pd.getId() : "0"%>"
								readonly="readonly" /> <input type="hidden"
								name="prescription_availableStatuspTab<%=incr%>"
								id="prescription_availableStatuspTab<%=incr%>"
								value="<%=pAvailableStatus%>" />
							</td>
							<td>
								<%
									if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
								%>
								<input type="text" readonly="readonly"
								title="Prescription issued.."
								<%=!availStockItemIdSet.contains(ItemId) ? "style='color:red'" : ""%>"
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
								class="nomenclaturepTab textYellow largTextBoxOpd" value="<%=nomeclature%>"
								title="<%=nomeclature%>" id="nomenclature<%=incr%>" size="35"
								name="nomenclaturepTab<%=incr%>"
								onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr%>);checkForBlockedMedicine(this.value,<%=incr%>); checkForAllergy(this.value,<%=incr%>); populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>');ValidateCantra();displayAu(this.value,'<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr%>);" />
								<%
									} else {
								%> <input type="text" class="nomenclaturepTab textYellow largTextBoxOpd"
								onkeypress="checkTextColor('nomenclature<%=incr%>');"
								value="<%=nomeclature%>" title="<%=nomeclature%>"
								id="nomenclature<%=incr%>" size="35"
								<%=nomeclature != "" ? "readonly" : ""%>
								name="nomenclaturepTab<%=incr%>"
								style="width: 160px;<%=!availStockItemIdSet.contains(ItemId) ? "color:red" : ""%>"
								<%-- onfocus="checkEnteredDiagnosis(); //Commented by Arbind on 31-01-2017--%>
											
											onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr%>);
												 checkDrugToDiseaseCantra(this);checkForBlockedMedicine(this.value,<%=incr%>);
												 checkForAllergy(this.value,<%=incr%>);populatePVMS(this.value,'<%=incr%>');
												 checkItem('<%=incr%>');
												 ValidateCantra();displayAu(this.value,'<%=incr%>');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=incr%> )" />
								<%
									}
								%>
								<div id="ac2updates<%=incr%>" style="display: none;"
									class="autocomplete"></div> <script type="text/javascript"
									language="javascript" charset="utf-8">
								 new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>',
						  'opd?method=getItemListForAutoCompleteItem',{minChars:3,
					  callback: function(element, entry) {
				            return entry + '&pharmacyCheck=' + document.getElementById('pharmacyCategory').value;
				        },
					  parameters:'requiredField=nomenclaturepTab<%=incr%>'});
				</script> <input type="hidden" name="pvmsNopTab<%=incr%>"
								id="pvmsNo<%=incr%>" size="10" readonly="readonly" /> <input
								type="hidden" name="actualDispensingQty<%=incr%>"
								id="actualDispensingQty<%=incr%>" size="6"
								validate="AU,string,no" /> <!-- added by amit das on 19-11-2016 -->
								<input type="hidden" name="mixable<%=incr%>"
								id="mixable<%=incr%>" validate="mixable,string,no" /> <!-- added by amit das on 19-11-2016 -->
								<input type="hidden" name="mixtureQuantity<%=incr%>"
								id="mixtureQuantity<%=incr%>" validate="mixtureQuantity,int,no" />

								<input type="hidden" name="mixtureUnit<%=incr%>"
								id="mixtureUnit<%=incr%>" validate="mixtureUnit,string,no" /> <!-- 											validate="mixtureUnit,int,no" /> added by govind 05-01-2017-->
								<input type="hidden" name="actualTotalAfterMix<%=incr%>"
								id="actualTotalAfterMix<%=incr%>"
								validate="actualTotalAfterMix,float,no" /> <input type="hidden"
								name="tapered<%=incr%>" id="tapered<%=incr%>"
								validate="tapered,string,no" />
							</td>
							<td>
								<%
									if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
								%>
								<select disabled="disabled" title="Prescription issued.."
								name="routepTab<%=incr%>" id="route<%=incr%>"
								style="width: 90px;" class="textYellow"
								onblur="fillRouteOnTAb('<%=incr%>');">
									<option value="0">Select</option>
									<%
										for (RouteOfAdministration routeOfAdministration : routeOfAdministrationList) {

													int id = routeOfAdministration.getId();
													String name = routeOfAdministration.getRouteName();
									%>
									<%
										if (routeId == id) {
									%>
									<option selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option value="<%=id%>"><%=name%></option>
									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	} else {
 %> <select name="routepTab<%=incr%>" id="route<%=incr%>"
								style="width: 90px;" class="textYellow"
								onblur="fillRouteOnTAb('<%=incr%>');">
									<option value="0">Select</option>
									<%
										for (RouteOfAdministration routeOfAdministration : routeOfAdministrationList) {

													int id = routeOfAdministration.getId();
													String name = routeOfAdministration.getRouteName();
									%>
									<%
										if (routeId == id) {
									%>
									<option selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option value="<%=id%>"><%=name%></option>

									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	}
 %> <script type="text/javascript">	var	routeArray= new Array();
		              <%RouteOfAdministration route = new RouteOfAdministration();
				for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					route = (RouteOfAdministration) routeOfAdministrationList.get(k);%> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=route.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=route.getRouteName()%>";
	     				<%}%> 
            </script>
							</td>
							<td><input
								class="textYellow allownumericwithdecimal  opdTextBoxTSmall"
								type="text" name="dosagepTab<%=incr%>" id="dosage<%=incr%>"
								value="<%=dosage != null && dosage != 0 ? dosage : ""%>" size="10"
								maxlength="3"
								onblur="fillValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" /></td>
							<td><input type="text" name="unit<%=incr%>"
								value="<%=unit != null && !unit.equals("") ? unit : ""%>"
								class="textYellow opdTextBoxTSmall" id="unit<%=incr%>"
								readonly="readonly" size="5"
								onblur="fillValue(this.value,<%=incr%>);" /></td>
							<td><input type="hidden" name="frequencyValue<%=incr%>"
								id="frequencyValue<%=incr%>" value="" size="6" /> <input
								type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
								style="display: none;" size="3"
								onblur="fillValue(this.value,<%=incr%>)" maxlength="3"
								validate="Sos Qty,num,no" /> <%
 	if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
 %>
								<select disabled="disabled" style="width: 69px;"
								class="textYellow" name="frequencypTab<%=incr%>"
								id="frequency<%=incr%>"
								onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyTypeForLP(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
									<option value="0">Select</option>
									<%
										for (MasFrequency masFrequency2 : frequencyList) {
													int id = masFrequency2.getId();
													String name = masFrequency2.getFrequencyName();
													String type = masFrequency2.getFrequencyType();
									%>
									<%
										if (frequencyId == id) {
									%>
									<option id="<%=type%>" selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option id="<%=type%>" value="<%=id%>"><%=name%></option>
									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	} else {
 %> <select style="width: 69px;" class="textYellow"
								name="frequencypTab<%=incr%>" id="frequency<%=incr%>"
								onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyTypeForLP(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
									<option value="0">Select</option>
									<%
										for (MasFrequency masFrequency2 : frequencyList) {
													int id = masFrequency2.getId();
													String name = masFrequency2.getFrequencyName();
													String type = masFrequency2.getFrequencyType();
									%>
									<%
										if (frequencyId == id) {
									%>
									<option id="<%=type%>" selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option id="<%=type%>" value="<%=id%>"><%=name%></option>
									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	}
 %> <%
 	MasFrequency masFrequency3 = null;
 		for (int i = 0; i < frequencyList.size(); i++) {
 			masFrequency3 = (MasFrequency) frequencyList.get(i);
 %> <script>
									      frequencyArray[<%=i%>]= new Array();
									      frequencyArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
									      frequencyArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
									      frequencyArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
							            </script> <%
 	}
 %></td>
							<td>
								<div style="width: 100px; float: left;">
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<input type="text" readonly="readonly"
										name="noOfDayspTab<%=incr%>" id="noOfDays<%=incr%>"
										value="<%=ndays != 0 ? ndays : ""%>"
										class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
										validate="No Of Days,num,no"
										onblur="fillValue(this.value,<%=incr%>);"
										onkeypress="return isNumberOnly(event)" />
									<p style="line-height: 0px;" id="frequencyType<%=incr%>"><%=frequecnyType%></p>
									<%
										} else {
									%>
									<input type="text" name="noOfDayspTab<%=incr%>"
										id="noOfDays<%=incr%>" value="<%=ndays != 0 ? ndays : ""%>"
										class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
										onkeypress="return isNumberOnly(event)"
										onblur="fillValue(this.value,<%=incr%>);" />
									<p style="line-height: 0px;" id="frequencyType<%=incr%>"><%=frequecnyType%></p>
									<%
										}
									%>
									<input type="hidden" name="totalpTab<%=incr%>"
										id="total<%=incr%>"
										value="<%=total != null && total != 0 ? total : ""%>" size="5"
										class="textYellow opdTextBoxTSmall" validate="Total,num,no"
										readonly="readonly" />
								</div>
							</td>
							<td>
								<%
									if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
								%>
								<select disabled="disabled" style="width: 90px;"
								class="textYellow" name="instrunctionpTab<%=incr%>"
								id="instrunction<%=incr%>">
									<option value="0">Select</option>
									<%
										for (OpdInstructionTreatment instructionTreatment : masInstructionMasterList) {

													int id = instructionTreatment.getId();
													String name = instructionTreatment.getOpdInstructionTreatmentName();
									%>
									<%
										if (inctrunctionId == id) {
									%>
									<option selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option value="<%=id%>"><%=name%></option>
									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	} else {
 %> <select style="width: 90px;" class="textYellow"
								name="instrunctionpTab<%=incr%>" id="instrunction<%=incr%>"
								onchange="toggleOtherTextbox1(this,'splInstrunctionpTab<%=incr%>',200, 'otherSplInstrunctionSpan<%=incr%>','68px','splInstrunction<%=incr%>')">
									<option value="0">Select</option>
									<%
										for (OpdInstructionTreatment instructionTreatment : masInstructionMasterList) {

													int id = instructionTreatment.getId();
													String name = instructionTreatment.getOpdInstructionTreatmentName();
									%>
									<%
										if (inctrunctionId == id) {
									%>
									<option selected="selected" value="<%=id%>"><%=name%></option>
									<%
										} else {
									%>
									<option value="<%=id%>"><%=name%></option>
									<%
										}
									%>
									<%
										}
									%>
							</select> <%
 	}
 %> <span id="otherSplInstrunctionSpan<%=incr%>"> <%
 	if (specialInstruction != null && !specialInstruction.isEmpty()) {
 %>
									<input name="splInstrunctionpTab<%=incr%>"
									id="splInstrunctionpTab<%=incr%>"
									value="<%=specialInstruction%>" class="textYellow"
									maxlength="200" style="width: 68px;" type="text"> <%
 	}
 %>
							</span> <script type="text/javascript">	var	instructionArray= new Array();
              <%OpdInstructionTreatment instructionMaster = new OpdInstructionTreatment();
				for (int k = 0; k < masInstructionMasterList.size(); k++) {
					instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);%> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<%}%> 
            </script>
							</td>
							<td><input type="checkbox" name="ct<%=incr%>" class="radio"
								id="ct<%=incr%>" value="y" />
						</tr>
						<%
							}
						%>

						<tbody id="divPresTemplet1"></tbody>
					</table>
					<input type="hidden" name="pTabhdb" value="<%=incr - 1%>" id="pTabhdb" />
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {
					%>
					<div class="clear"></div>
					<div class="paddingTop5"></div>
					<label class="auto">Non-pharmacological advice</label>
					<textarea style="width: 661px; height: 40px;"
						validate="N/P,string,no" id="nonPharmacological"
						name="nonPharmacological" cols="0" rows="0" maxlength="300"
						tabindex="26"><%=nonPharmacological != null ? nonPharmacological : ""%></textarea>
					<%
						}
					%>
				</div>
				<div
					style="width: -26px; background-color: floralwhite; float: right;">
					<input class="addButSmll" alt="Add" value="&nbsp;" type="button"
						onclick="addRowMedicineForLP();"> <input
						class="delButSmll" alt="Delete" value="&nbsp;" type="button"
						onclick="removeRowMedicineForLP();">
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>

				<div id="Div1"></div>
				<div id="Div2"
					style="padding-left:257px;<%=patientOtherPrescriptionDetails.size() > 0 ? "display:block;" : ""%>">
					<div style="width: 850px; float: left;">
						<div class="floatRight">
							<div id="responseId"></div>
							<div class="clear"></div>
						</div>

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="gridForPrescription">
							<tr>
								<th style="background: #bdd6ee;">&nbsp;</th>
								<th style="background: #bdd6ee; width: 190px;">Item Name</th>
								<th style="background: #bdd6ee; width: 106px;">Route</th>
								<th style="background: #bdd6ee; width: 57px;">Dosage</th>
								<!-- <th scope="col">Unit</th> -->
								<th style="background: #bdd6ee; width: 67px;">Frequency</th>
								<th style="background: #bdd6ee;">Duration</th>
								<th style="background: #bdd6ee;">Instruction</th>
								<th style="background: #bdd6ee;">Special Instruction</th>
								<!-- <th scope="col">Total</th> -->
							</tr>
							<%
								int incrs = 0, lens = 1, lent = 0;
								if (patientOtherPrescriptionDetails.size() > 0 && masStoreOutItemsList.size() > 0) {
									lens = patientOtherPrescriptionDetails.size();
									lent = masStoreOutItemsList.size();
								} else {
									lens = 1;
									lent = 3;
								}
								int inxRows = 1;
								int inxCols = 0;
								for (; incrs < lens; incrs++, inxRows++) {
									String nomeclatures = "";
									Integer ItemIds = 0;
									String pvmsNo = "";
									int routeIds = 0;
									int frequencyIds = 0;
									int inctrunctionIds = 0;
									String unitOut = "";
									String frequecnyTypes = "";
									Float dosagesOut = 0f;
									int noOfDaysOut = 0;
									Float totalOut = 0f;
									String issuedStatus = "";
									String splInstrunctionsOut = null;
									String routeNames = "";
									String conversions = "";
									PatientPrescriptionDetails pds = null;
									MasStoreOutItem mso = null;
									if (patientOtherPrescriptionDetails.size() > 0 && masStoreOutItemsList.size() > 0) {
										pds = patientOtherPrescriptionDetails.get(incrs);
										mso = masStoreOutItemsList.get(incrs);
										ItemIds = mso.getId();

										if (mso.getStatus() != null && !mso.getStatus().equals("")
												&& mso.getStatus().equalsIgnoreCase("y")) {
											issuedStatus = mso.getStatus();
										}

										nomeclatures = pds.getItemOut().getNomenclature();
										splInstrunctionsOut = pds.getSplInstruction();
										dosagesOut = pds.getDosage();
										totalOut = pds.getTotal();
										noOfDaysOut = pds.getNoOfDays();
										frequecnyTypes = pds.getFrequency().getFrequencyType();
										if (pds.getRoute() != null) {
											routeIds = pds.getRoute().getId();
											routeNames = pds.getRoute().getRouteName();
										}
										if (pds.getFrequency() != null) {
											frequencyIds = pds.getFrequency().getId();
										}
										if (pds.getInsrtuction() != null) {
											inctrunctionIds = pds.getInsrtuction().getId();
										}
										if (ItemIds != 0) {
											nomeclatures = nomeclatures;
										}
									}
							%>
							<tr>
								<td>
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<input type="checkbox" class="radioCheck"
									id="itemRadios<%=incrs%>" title="Prescription issued.."
									disabled="disabled" name="itemRadios<%=incrs%>"
									onchange="checkPrescriptionCheckList(<%=incrs%>)" /> <%
 	} else {
 %>
									<input type="checkbox" tabindex="<%=inxRows%><%=inxCols + 10%>"
									class="radioCheck" id="itemRadios<%=incrs%>"
									name="itemRadios<%=incrs%>"
									onchange="checkPrescriptionCheckList(<%=incrs%>)" /> <%
 	}
 %> <input
									type="hidden" id="parkOutPrescriptionIds<%=incrs%>"
									name="parkOutPrescriptionIds<%=incrs%>"
									value="<%=pds != null && pds.getId() != 0 ? pds.getId() : "0"%>"
									readonly="readonly" /> <input type="hidden"
									name="prescription_availableStatus<%=incrs%>"
									id="prescription_availableStatus<%=incrs%>" />
								</td>
								<td>
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<input type="text" readonly="readonly"
									title="Prescription issued.."
									onkeypress="checkTextColorList('nomenclatures<%=incrs%>');"
									class="textYellow largTextBoxOpd" value="<%=nomeclatures%>"
									title="<%=nomeclatures%>" id="nomenclatures<%=incrs%>"
									size="35" name="nomenclatures<%=incrs%>"
									onblur="validatePrescriptionAutocompleteList('opPTab',this.value,<%=incrs%>);" />
									<%
										} else {
									%> <input type="text"
									tabindex="<%=inxRows%><%=inxCols + 11%>"
									class="textYellow largTextBoxOpd"
									onkeypress="checkTextColorList('nomenclatures<%=incrs%>');"
									value="<%=nomeclatures%>" id="nomenclatures<%=incrs%>"
									size="35" name="nomenclatures<%=incrs%>" style="width: 160px;"
									onblur="validatePrescriptionAutocompleteList('otherPres',this.value,<%=incrs%> )" />
									<%
										}
									%>
									<div id="ac2update1<%=incrs%>" style="display: none;"
										class="autocomplete"></div> <script type="text/javascript"
										language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclatures<%=incrs%>','ac2update1<%=incrs%>','opd?method=getItemListForAutoCompleteOutItem',{minChars:3,parameters:'requiredField=nomenclatures<%=incrs%>'});
					</script> <input type="hidden" name="pvmsNo<%=incrs%>"
									id="pvmsNo<%=incrs%>" size="10" readonly="readonly" /> <input
									type="hidden" name="actualDispensingQtys<%=incrs%>"
									id="actualDispensingQtys<%=incrs%>" size="6"
									validate="AU,string,no" /> <input type="hidden"
									id="prescriptionIdOut<%=incrs%>"
									name="prescriptionIdOut<%=incrs%>"
									value="<%=pds != null && pds.getId() != 0 ? pds.getId() : "0"%>"
									readonly="readonly" /> <input type="hidden"
									name="mixables<%=incrs%>" id="mixables<%=incrs%>"
									validate="mixables,string,no" /> <input type="hidden"
									name="mixtureQuantity<%=incrs%>" id="mixtureQuantity<%=incrs%>"
									validate="mixtureQuantity,int,no" /> <input type="hidden"
									name="mixtureUnit<%=incrs%>" id="mixtureUnit<%=incrs%>"
									validate="mixtureUnit,string,no" /> <input type="hidden"
									name="actualTotalAfterMixs<%=incrs%>"
									id="actualTotalAfterMixs<%=incrs%>"
									validate="actualTotalAfterMixs,float,no" /> <input
									type="hidden" name="tapered<%=incrs%>" id="tapered<%=incrs%>"
									validate="tapered,string,no" />
								</td>
								<td>
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<select disabled="disabled" title="Prescription issued.."
									name="routesOut<%=incrs%>" id="routesOut<%=incrs%>"
									style="width: 90px;" class="textYellow"
									onblur="fillRouteOnTAbList('<%=incrs%>');">
										<option value="0">Select</option>
										<%
											for (RouteOfAdministration routeOfAdministration : routeOfAdministrationList) {

														int id = routeOfAdministration.getId();
														String name = routeOfAdministration.getRouteName();
										%>
										<%
											if (routeIds == id) {
										%>
										<option selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=id%>"><%=name%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	} else {
 %> <select name="routesOut<%=incrs%>"
									tabindex="<%=inxRows%><%=inxCols + 12%>" id="routesOut<%=incrs%>"
									style="width: 90px;" class="textYellow"
									onblur="fillRouteOnTAbList('<%=incrs%>');">
										<option value="0">Select</option>
										<%
											for (RouteOfAdministration routeOfAdministration : routeOfAdministrationList) {

														int id = routeOfAdministration.getId();
														String name = routeOfAdministration.getRouteName();
										%>
										<%
											if (routeIds == id) {
										%>
										<option selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=id%>"><%=name%></option>

										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	}
 %> <script type="text/javascript">	var	routeArray= new Array();
		              <%RouteOfAdministration routesOut = new RouteOfAdministration();
				for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					routesOut = (RouteOfAdministration) routeOfAdministrationList.get(k);%> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=routesOut.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=routesOut.getRouteName()%>";
	     				<%}%> 
            </script>
								</td>
								<td><input
									class="textYellow allownumericwithdecimal opdTextBoxTSmall"
									tabindex="<%=inxRows%><%=inxCols + 13%>" type="text"
									name="dosagesOut<%=incrs%>" id="dosagesOut<%=incrs%>"
									value="<%=dosagesOut != null && dosagesOut != 0 ? dosagesOut : ""%>"
									size="10" maxlength="3"
									onblur="fillValueList(this.value,<%=incrs%>);" /></td>
								<%-- <td><input type="text"
											tabindex="<%=inxRows%><%=inxCols+14%>" name="unitOut<%=incrs %>"
											value="<%=unitOut!=null && !unitOut.equals("")?unitOut:"" %>"
											class="textYellow opdTextBoxTSmall" id="unitOut<%=incrs %>"
											readonly="readonly" size="5"
											onblur="fillValueList(this.value,<%=incrs%>);" /></td> --%>
								<td>
									<input type="hidden" name="frequencyValueKmcl<%=incrs%>"
											id="frequencyValueKmcl<%=incrs%>" value="" size="6"/>  <input
									type="hidden" name="sosQtyout<%=incrs%>"
									id="sosQtyout<%=incrs%>" style="display: none;" size="3"
									onblur="fillValueList(this.value,<%=incrs%>)" maxlength="3"
									validate="Sos Qty,num,no" /> <%
 	if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
 %>
									<select disabled="disabled" style="width: 69px;"
									class="textYellow" name="frequencyValueOut<%=incrs%>"
									id="frequencyValueOut<%=incrs%>"
									onchange="getFrequencyValueList(this.value,<%=incrs%>);fillValueList(this.value,<%=incrs%>);displaySOSQtyList(this.value,<%=incrs%>);displaFrequencyTypeList(this,<%=incrs%>);">
										<option value="0">Select</option>
										<%
											for (MasFrequency masFrequency2 : frequencyList) {
														int id = masFrequency2.getId();
														String name = masFrequency2.getFrequencyName();
														String type = masFrequency2.getFrequencyType();
										%>
										<%
											if (frequencyIds == id) {
										%>
										<option id="<%=type%>" selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option id="<%=type%>" value="<%=id%>"><%=name%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	} else {
 %> <select style="width: 68px;" class="textYellow"
									tabindex="<%=inxRows%><%=inxCols + 15%>"
									name="frequencyValueOut<%=incrs%>"
									id="frequencyValueOut<%=incrs%>"
									onchange="getFrequencyValueList(this.value,<%=incrs%>);fillValueList(this.value,<%=incrs%>);displaySOSQtyList(this.value,<%=incrs%>);displaFrequencyTypeList(this,<%=incrs%>);">
										<option value="0">Select</option>
										<%
											for (MasFrequency masFrequency2 : frequencyList) {
														int id = masFrequency2.getId();
														String name = masFrequency2.getFrequencyName();
														String type = masFrequency2.getFrequencyType();
										%>
										<%
											if (frequencyIds == id) {
										%>
										<option id="<%=type%>" selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option id="<%=type%>" value="<%=id%>"><%=name%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	}
 %> <%
 	MasFrequency masFrequency3 = null;
 		for (int i = 0; i < frequencyList.size(); i++) {
 			masFrequency3 = (MasFrequency) frequencyList.get(i);
 %> <script>
		 frequencyArray[<%=i%>]= new Array();
		 frequencyArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		 frequencyArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
		 frequencyArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
							            </script> <%
 	}
 %>
								</td>
								<td>
									<div style="width: 95px; float: left;">
										<%
											if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
										%>
										<input type="text" readonly="readonly"
											name="noOfDaysOut<%=incrs%>" id="noOfDaysOut<%=incrs%>"
											value="<%=noOfDaysOut != 0 ? noOfDaysOut : ""%>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event);"
											onblur="fillValueDay(<%=incrs%>);fillValueList(this.value,<%=incrs%>);" />
										<p style="line-height: 0px;" id="frequencyTypeOut<%=incrs%>"><%=frequecnyTypes%></p>
										<%
											} else {
										%>
										<input type="text" tabindex="<%=inxRows%><%=inxCols + 16%>"
											name="noOfDaysOut<%=incrs%>" id="noOfDaysOut<%=incrs%>"
											value="<%=noOfDaysOut != 0 ? noOfDaysOut : ""%>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											onkeypress="return isNumberOnly(event);"
											onblur="fillValueDay(<%=incrs%>);fillValueList(this.value,<%=incrs%>);" />
										<p style="line-height: 0px;" id="frequencyTypeOut<%=incrs%>"><%=frequecnyTypes%></p>
										<%
											}
										%>
									</div>
								</td>
								<td>
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<select disabled="disabled" style="width: 90px;"
									class="textYellow" name="instrunctionOut<%=incrs%>"
									id="instrunctionOut<%=incrs%>"
									onblur="fillInstrunctionOnTAbs('<%=incrs%>');">
										<option value="0">Select</option>
										<%
											for (OpdInstructionTreatment instructionTreatment : masInstructionMasterList) {

														int id = instructionTreatment.getId();
														String name = instructionTreatment.getOpdInstructionTreatmentName();
										%>
										<%
											if (inctrunctionIds == id) {
										%>
										<option selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=id%>"><%=name%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	} else {
 %> <select style="width: 90px;" class="textYellow"
									tabindex="<%=inxRows%><%=inxCols + 17%>"
									name="instrunctionOut<%=incrs%>" id="instrunctionOut<%=incrs%>"
									onblur="fillInstrunctionOnTAbs('<%=incrs%>');">
										<option value="0">Select</option>
										<%
											for (OpdInstructionTreatment instructionTreatment : masInstructionMasterList) {

														int id = instructionTreatment.getId();
														String name = instructionTreatment.getOpdInstructionTreatmentName();
										%>
										<%
											if (inctrunctionIds == id) {
										%>
										<option selected="selected" value="<%=id%>"><%=name%></option>
										<%
											} else {
										%>
										<option value="<%=id%>"><%=name%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select> <%
 	}
 %> <script type="text/javascript">	var	instructionArray= new Array();
              <%OpdInstructionTreatment instructionMaster = new OpdInstructionTreatment();
				for (int k = 0; k < masInstructionMasterList.size(); k++) {
					instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);%> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<%}%> 
            </script>
								</td>
								<td>
									<%
										if (!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")) {
									%>
									<input type="text" readonly="readonly"
									name="splInstrunctionsOut<%=incrs%>"
									class="textYellow opdTextBoxTSmall" style="width: 80px;"
									id="splInstrunctionsOut<%=incrs%>" maxlength="200"
									<%-- onblur="fillSPLInstrunctionOnPTAb(<%=incrs%>);" --%>
									value="<%=splInstrunctionsOut != null ? splInstrunctionsOut : ""%>" />
									<%
										} else {
									%> <input type="text"
									tabindex="<%=inxRows%><%=inxCols + 18%>"
									name="splInstrunctionsOut<%=incrs%>"
									class="textYellow opdTextBoxTSmall"
									id="splInstrunctionsOut<%=incrs%>" maxlength="200"
									<%-- onblur="fillSPLInstrunctionOnPTAb(<%=incrs%>);" --%>
									style="width: 80px;"
									value="<%=splInstrunctionsOut != null ? splInstrunctionsOut : ""%>" />
									<%
										}
									%> <input type="hidden" name="totalOut<%=incrs%>"
									id="totalOut<%=incrs%>"
									value="<%=totalOut != null && totalOut != 0 ? totalOut : ""%>"
									size="5" class="textYellow opdTextBoxTSmall"
									validate="Total,num,no" readonly="readonly" />
								</td>
								<%-- <td>
											<input type="text" name="totalOut<%=incrs %>" id="totalOut<%=incrs %>"	value="<%=totalOut!=null && totalOut!=0?totalOut:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td> --%>

								<%-- 	<td>
											<input type="text" id="unitLables<%=incrs%>" value="<%=!conversions.equals("")?conversions:"" %>" 	class="textYellow opdTextBoxTSmall" readonly="readonly" />
										</td> --%>

							</tr>
							<%
								}
							%>

							<tbody id="divTemplet1"></tbody>
						</table>
						<input type="hidden" name="hdb1" value="<%=incrs - 1%>" id="hdb1" />
						<input type="hidden" name="hdbRecordSize1"
							value="<%=patientOtherPrescriptionDetails.size() - 1%>"
							id="hdbRecordSize1" /> <input type="hidden" name="hdbTabIndex1"
							id="hdbTabIndex1" value="<%=inxRows - 1%>" id="hdbRecordSize1" />

					</div>

					<div
						style="width: -26px; background-color: floralwhite; float: right;">
						<input class="addButSmll" alt="Add" value="&nbsp;" type="button"
							onclick="addRowOtherMedicineForLP();"> <input
							class="delButSmll" alt="Delete" value="&nbsp;" type="button"
							onclick="removeRowOtherMedicineForLP();">
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="titleBg">
					<h2>PROCEDURES</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div style="width: 1110px; float: left;">
					<table style="width: 100%; border-top: solid 1px #C0C0C0;"
						id="gridNursing">
						<tbody>
							<tr>
								<th style="background: #bdd6ee;">&nbsp;</th>
								<th style="background: #bdd6ee;">Procedure Name</th>
								<th style="background: #bdd6ee;">Frequency</th>
								<th style="background: #bdd6ee;">No. of Days</th>
								<th style="background: #bdd6ee;">Remarks</th>
							</tr>
							<%
								incr = 0;
								len = 1;
								if (procedureDetails.size() > 0) {
									len = procedureDetails.size();
								}
								Integer procedureId = 0;
								Integer procedureHeaderId = 0;
								String nursingCare = "";
								String nursingRemark = "";
								String procedureStatus = "";
								int noOfDays = 0;
								int frequencyId_1 = 0;
								for (; incr < len; incr++) {
									ProcedureDetails procedureDetails1 = null;
									if (procedureDetails.size() > 0) {
										procedureDetails1 = procedureDetails.get(incr);
									}
									if (procedureDetails1 != null) {
										procedureId = procedureDetails1.getId();
										procedureHeaderId = procedureDetails1.getProcedureHeader().getId();
										nursingCare = procedureDetails1.getProcedure().getNursingName() + "["
												+ procedureDetails1.getProcedure().getId() + "]";
										if (procedureDetails1.getRemarks() != null)
											nursingRemark = procedureDetails1.getRemarks();
										procedureStatus = procedureDetails1.getStatus();
										noOfDays = procedureDetails1.getNoOfDays();
										frequencyId_1 = procedureDetails1.getFrequency().getId();
									}
							%>
							<tr>
								<td>
									<%
										if (procedureStatus.equalsIgnoreCase("y")) {
									%> <input
									type="checkbox" disabled="disabled" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>" />
								</td>
								<%
									} else {
								%>
								<input type="checkbox" class="radioCheck"
									id="nursingRadio<%=incr%>" name="nursingRadio<%=incr%>">
								</td>
								<%
									}
								%>
								<input type="hidden"
									value="<%=procedureId != null && !procedureId.equals(0) ? procedureId : 0%>"
									name="procedureDetailId<%=incr%>"
									id="procedureDetailId<%=incr%>" />
								<td>
									<%
										if (procedureStatus.equalsIgnoreCase("y")) {
									%> <input
									readonly="readonly" type="text" value="<%=nursingCare%>"
									id="procedureName_nursing<%=incr%>" size="35"
									name="procedureName_nursing<%=incr%>" style="width: 320px;"
									<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 	
										 onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)" />
									<%
										} else {
									%> <input type="text" value="<%=nursingCare%>"
									id="procedureName_nursing<%=incr%>" style="width: 320px;"
									size="35" name="procedureName_nursing<%=incr%>"
									<%-- onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_nursing<%=incr%>');" --%> 
										  onblur="validatePrescriptionAutocomplete('opNursingProc',this.value,<%=incr%>)" />
									<%
										}
									%>
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
									id="frequency_nursing<%=incr%>" tabindex="36"
									onchange="populateNoOfDaysForNursingProcedure(this.value,'<%=incr%>')">
										<option value="0">Select</option>
										<%
											MasFrequency masFrequency = new MasFrequency();
												for (MasFrequency masFrequency2 : frequencyList) {
													int id = masFrequency2.getId();
													String name = masFrequency2.getFrequencyName();
										%>
										<option value="<%=id%>" <%if (frequencyId_1 == id) {%>
											selected <%}%>><%=name%></option>
										<%
											}
										%>
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
									value="<%=noOfDays != 0 ? noOfDays : ""%>" class="textSmall" size="5"
									maxlength="3" onkeypress="return isNumberOnly(event)" /></td>
								<td>
									<%
										if (procedureStatus.equalsIgnoreCase("y")) {
									%> <input
									readonly="readonly" value="<%=nursingRemark%>" type="text"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									style="width: 510px;" maxlength="100" /> <%
 	} else {
 %> <input
									type="text" value="<%=nursingRemark%>"
									name="remark_nursing<%=incr%>" id="remark_nursing<%=incr%>"
									style="width: 510px;" maxlength="100" /> <%
 	}
 %>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<input type="hidden" id="procedureHeaderId"
						name="procedureHeaderId" value="<%=procedureHeaderId%>" /> <input
						type="hidden" name="nursinghdb" value="<%=incr - 1%>"
						id="nursinghdb" />

				</div>

				<div
					style="width: -26px; background-color: floralwhite; float: right;">
					<input class="addButSmll" alt="Add" value="&nbsp;" type="button"
						onclick="addRowTreatmentNursingCareLP();"> <input
						class="delButSmll" alt="Delete" value="&nbsp;" type="button"
						onclick="removeRowTreatmentNursingCare();">
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div class="titleBg">
					<h2>SURGERY PROCEDURES</h2>
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<div style="width: 1110px; float: left; background: red;">
					<table style="width: 100%; border-top: solid 1px #C0C0C0;"
						id="gridSurgery">
						<tbody>
							<tr>
								<th style="background: #bdd6ee;">&nbsp;</th>
								<th style="background: #bdd6ee;">Procedure Name</th>
								<th style="background: #bdd6ee;">Tentative Date</th>
								<th style="background: #bdd6ee;">Remarks</th>
								<th style="background: #bdd6ee;">PAC</th>
							</tr>
							<%
								incr = 0;
								len = 1;
								if (opdSurgeryDetails.size() > 0) {
									len = opdSurgeryDetails.size();
								}
								Integer surgeryId = 0;
								Integer surgeryHeaderId = 0;
								String surgery = "";
								String surgerRemark = "";
								String surgerDate = "";
								Integer surgerChargeId = 0;
								for (; incr < len; incr++) {
									OpdSurgeryDetail opdSurgeryDetails1 = null;
									if (opdSurgeryDetails.size() > 0) {
										opdSurgeryDetails1 = opdSurgeryDetails.get(incr);
									}
									if (opdSurgeryDetails1 != null) {
										surgeryId = opdSurgeryDetails1.getId();
										surgeryHeaderId = opdSurgeryDetails1.getOpdSurgery().getId();
										surgery = opdSurgeryDetails1.getChargeCode().getChargeCodeName();
										surgerChargeId = opdSurgeryDetails1.getChargeCode().getId();
										if (opdSurgeryDetails1.getRemarks() != null)
											surgerRemark = opdSurgeryDetails1.getRemarks();
										if (opdSurgeryDetails1.getTentativeDate() != null)
											surgerDate = HMSUtil.changeDateToddMMyyyy(opdSurgeryDetails1.getTentativeDate());
									}
							%>
							<tr>
								<td><input type="checkbox" class="radioCheck"
									id="surgeryRadio<%=incr%>" name="surgeryRadio<%=incr%>"
									tabindex="31" /> <input type="hidden"
									value="<%=surgeryId != null && !surgeryId.equals(0) ? surgeryId : 0%>"
									name="surgeryDetailsId<%=incr%>" id="surgeryDetailsId<%=incr%>" /></td>
								<td><input type="text" style="width: 250px;" tabindex="32"
									value="<%=surgery%>" id="procedureName_surgery<%=incr%>"
									size="35" name="procedureName_surgery<%=incr%>"
									onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'procedureName_surgery<%=incr%>');"
									onblur="checkMappedCharge(this.value,'<%=incr%>');" />
									<input type="hidden" id="surgery_code_id<%=incr%>"
									value="<%=surgerChargeId%>" name="surgery_code_id<%=incr%>" />
								</td>
								<td><input type="text" id="tentativeDate<%=incr%>"
									class="small" value="<%=surgerDate%>"
									name="tentativeDate<%=incr%>"
									validate="t1ntativeDate<%=incr%>,string,no" readonly="readonly" />
									<img src="/hms/jsp/images/cal.gif" width="16" height="16"
									border="0" validate="Pick a date"
									onclick="setdate('<%=currentDate%>',document.opdMain.tentativeDate<%=incr%>,event);" />
								</td>
								<td><input type="text" name="remark_surgery<%=incr%>"
									value="<%=surgerRemark%>" id="remark_surgery<%=incr%>"
									style="width: 610px;" maxlength="100" /></td>
								<td><input type="checkbox" id="chkpacNeed<%=incr%>"
									name="chkpacNeed<%=incr%>" value=""
									onchange="pacRequesting(<%=incr%>);" /></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<input type="hidden" id="surgeryHeaderId" name="surgeryHeaderId"
						value="<%=surgeryHeaderId%>" /> <input type="hidden"
						name="surgeryhdb" value="<%=incr - 1%>" id="surgeryhdb" />

				</div>
				<div
					style="width: -26px; background-color: floralwhite; float: right;">
					<input class="addButSmll" alt="Add" value="&nbsp;" type="button"
						onclick="addRowTreatmentSurgeryNP();"> <input
						class="delButSmll" alt="Delete" value="&nbsp;" type="button"
						onclick="removeRowTreatmentSurgery();">
				</div>


				<div class="clear"></div>
				<div class="paddingTop2"></div>
				<!-- plus minus button -->
				<div class="adviceDivMain" id="button1" onclick="showhide(this.id)">
					<div class="titleBg" style="width: 520px; float: left;">
						<h2 class="h2Text">ADVICE</h2>
					</div>
					<input class="buttonPlusMinus" type="button" tabindex="3" name=""
						value="+" id="realtedbutton1" onclick="showhide(this.id)">
				</div>
				<div class="clear"></div>
				<div class="paddingTop2"></div>

				<!-- show Hide div start here -->
				<div id="newpost1" class="hidAdviceDiv">

					<div id="admissionDiv">
						<div class="clear"></div>
						<label class="auto">Transfer to observation ward <%
							if (opdPatientDetails != null && opdPatientDetails.getObservationStatus() != null
									&& opdPatientDetails.getObservationStatus().equalsIgnoreCase("y")
									&& opdPatientDetails.getVisit().getId().equals(visitId)) {
						%>
							<input type="checkbox" checked="checked" class="checkboxMargin"
							id="observationStatus" name="observationStatus" /> <%
 	} else {
 %> <input
							type="checkbox" class="checkboxMargin" id="observationStatus"
							name="observationStatus" /> <%
 	}
 %>
						</label> <label class="auto">Admission Advised <%
 	if (opdPatientDetails != null && opdPatientDetails.getAdmissionAdvised() != null
 			&& opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")
 			&& opdPatientDetails.getVisit().getId().equals(visitId)) {
 %>
							<input type="checkbox" checked="checked" class="checkboxMargin"
							id="admissionAdvised" name="admissionAdvised" /> <%
 	} else {
 		if (opdPatientDetails != null && opdPatientDetails.getReferedStatus() != null
 				&& opdPatientDetails.getReferedStatus().equalsIgnoreCase("y")
 				&& opdPatientDetails.getVisit().getId().equals(visitId)) {
 %> <input type="checkbox" class="checkboxMargin"
							id="admissionAdvised" name="admissionAdvised" disabled="disabled" />
							<%
								} else {
							%> <input type="checkbox" class="checkboxMargin"
							id="admissionAdvised" name="admissionAdvised" /> <%
 	}
 	}
 %>
						</label>

						<%
							if (opdPatientDetails != null && opdPatientDetails.getAdmissionAdvised() != null
									&& opdPatientDetails.getAdmissionAdvised().equalsIgnoreCase("y")
									&& opdPatientDetails.getVisit().getId().equals(visitId)) {
						%>
						<div id="admDiv">
							<label class="auto">Admission Date</label> <input type="text"
								name="admissionDate" id="admissionDate"
								style="text-align: left;" class="dateTextSmall"
								value="<%=HMSUtil.convertDateOneFormatToAnother("dd/MM/yyyy", opdPatientDetails.getAdmissionDate())%>"
								readonly="readonly" onblur="checkAdmte()" /> <img
								src="/hms/jsp/images/cal.gif" class="calenderImg" width="16"
								height="16" border="0" validate="Pick a date"
								onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<!-- <div class="clear"></div> -->
							<label class="auto">Payward <input type="checkbox"
								name="payward" id="payward" class="checkboxMargin" value="Y"
								onchange="checkPayWard()" />
							</label> <label class="auto">Ward</label> <select name="admissionWard"
								id="admissionWard" onclick="getBedStatus(this.value);">
								<option value="0">Select</option>
								<%
									for (MasDepartment ward : wardDepartmentList) {
											if (opdPatientDetails.getAdmissionWard().getId() == ward.getId()) {
								%>
								<option value="<%=ward.getId()%>" selected="selected"><%=ward.getDepartmentName()%></option>
								<%
									} else {
								%>
								<option value="<%=ward.getId()%>"><%=ward.getDepartmentName()%></option>
								<%
									}
										}
								%>
							</select>
							<div id="bedDiv"></div>
						</div>
						<%
							} else {
						%>
						<div id="admDiv" class="collaps">
							<label class="auto">Admission Date</label> <input type="text"
								name="admissionDate" id="admissionDate" class="inputSmall"
								value="<%=currentDate%>" readonly="readonly"
								onblur="checkAdmte()" /> <img src="/hms/jsp/images/cal.gif"
								class="calenderImg" width="16" height="16" border="0"
								validate="Pick a date"
								onclick="setdate('<%=currentDate%>',document.opdMain.admissionDate,event);" />
							<!-- <div class="clear"></div> -->
							<label class="auto">Payward <input type="checkbox"
								name="payward" id="payward" class="checkboxMargin" value="Y"
								onchange="checkPayWard()" />
							</label> <label class="auto">Ward</label> <select name="admissionWard"
								id="admissionWard" onclick="getBedStatus(this.value);">
								<option value="0">Select</option>
								<%
									for (MasDepartment ward : wardDepartmentList) {
								%>
								<option value="<%=ward.getId()%>"><%=ward.getDepartmentName()%></option>
								<%
									}
								%>
							</select>
							<div id="bedDiv"></div>
						</div>
						<%
							}
						%>

					</div>
					<div class="clear"></div>

					<%
						String relationName = "";
						if (opdPatientDetails != null && opdPatientDetails.getReferedStatus() != null
								&& (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y")
										|| opdPatientDetails.getReferedStatus().equalsIgnoreCase("C"))
								&& opdPatientDetails.getVisit().getId().equals(
										visitId)/* && !opdPatientDetails.getVisit().getVisitStatus().equalsIgnoreCase("c") */) {
					%>

					<div class="clear"></div>
					<div class="paddingTop2"></div>
					<div id="referalDiv" style="display: block;">

						<label>Referral </label> <select id="referral" name="referral"
							class="midium">
							<%
								if (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y")
											|| opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")) {
							%>
							<option value="0">No</option>
							<option value="1" selected="selected">Yes</option>
							<%
								} else {
							%>
							<option value="0" selected="selected">No</option>
							<option value="1">Yes</option>
							<%
								}
							%>

						</select>

						<div id="referDiv" style="margin-top: 5px;">
							<label class="auto">Refer To</label>
							<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
							<%
								if (opdpatientDetailId != 0) {
							%>
							<label class="auto"><input type="checkbox"
								class="radioCheckCol2" name="referBack" id="referBack"
								value="Internal"
								onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>@@@<%=deptNameDoctorId%>@@@<%=deptNameDoctorName%>');" />ReferBack</label>
							<%
								}
							%>

							<%
								if (opdPatientDetails.getReferedStatus().equalsIgnoreCase("y")
											|| opdPatientDetails.getReferedStatus().equalsIgnoreCase("C")) {
							%>
							<input type="hidden" name="referCheck" id="referCheck" value="y" />
							<label class="auto"> <input type="radio"
								class="checkboxMargin" name="referTo"
								<%=opdPatientDetails.getReferredType().equalsIgnoreCase("Interanal")
							? "checked='checked'"
							: ""%>
								id="referInternal" value="Internal"
								onclick="checkReferTO('referInternalRecall',<%=referredDept%>);" />Internal
							</label> <label class="auto"> <input type="radio"
								class="checkboxMargin" name="referTo"
								<%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")
							? "checked='checked'"
							: ""%>
								id="referExternal" value="External"
								onclick="checkReferTO('referExternal',<%=referredDept%>);" />External
							</label>
							<%
								}
							%>


							<div class="clear"></div>
							<label>Refer Date:</label> <input type="text" id="referVisitDate"
								name="referVisitDate" class="date" value="<%=currentDate%>" onblur="checkReferDate(this.value);"
								onkeyup="mask(this.value,this,'2,5','-');" /> <img
								src="/hms/jsp/images/cal.gif" class="calenderImg" width="16"
								height="16" border="0" validate="Pick a date"
								onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" />
							<label id="priorityLabelId" style="width: 115px;">Current
								Proirity No.</label> <select id="priorityId" name="priorityName"
								tabindex="1" style="width: 100px;">
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select> <label id="referdistrictLabel"
								<%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")
						? "style='display:block;width:100px;'"
						: ""%>>District</label>
							<select id="referdistrict"
								<%=opdPatientDetails.getReferredType().equalsIgnoreCase("External")
						? "style='display:block;width:100px;'"
						: ""%>
								name="referdistrict" onchange="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%
									for (MasDistrict district : masDistrictList) {
								%>
								<%
									if (opdPatientDetails.getReferedDistrict() != null
													&& opdPatientDetails.getReferedDistrict().getId() == district.getId()) {
								%>
								<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
								<%
									} else {
								%>
								<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select>
							<div class="clear"></div>

							<label id="referHospitalTypeLabel">Hospital Type</label> <select
								id="referHospitalType" name="referHospitalType"
								onchange="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%
									if (hospitalTypeList.size() > 0) {
											for (MasHospitalType masHospitalType : hospitalTypeList) {
								%>
								<%
									if (opdPatientDetails.getReferredHospital() != null && opdPatientDetails.getReferredHospital()
														.getHospitalType().getId() == masHospitalType.getId()) {
								%>
								<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
								<%
									} else {
								%>
								<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
								<%
									}
								%>
								<%
									}
										}
								%>
							</select> <label id="referhospitalLabel" style="width: 100px;">Hospital</label>
							<select id="referhospital" name="referhospital"
								onchange="fnGetHospitalDepartment(this.value,'referExternal',<%=referredDept%>);">
								<option value="0">Select</option>
								<%
									for (Object[] msh : masHospitals) {
								%>
								<%
									if (opdPatientDetails.getReferredHospital() != null
													&& opdPatientDetails.getReferredHospital().getId() == msh[0]
													&& opdPatientDetails.getReferredHospital().getHospitalType().getId() == msh[2]) {
								%>
								<option value="<%=msh[0]%>" selected="selected"><%=msh[1]%></option>

								<%
									} else if (opdPatientDetails.getReferredHospital() != null
													&& opdPatientDetails.getReferredHospital().getHospitalType().getId() == msh[2]) {
								%>
								<option value="<%=msh[0]%>"><%=msh[1]%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select>
							<div class="clear"></div>

							<label id="referdepartmentLabel">Department</label> <select
								id="referdepartment" name="referdepartment"
								onchange="fnGetDoctorDepartment(this.value);getSessionForDepartment(this.value);">
								<option value="0">Select</option>
								<%
									for (MasDepartment dep : deptList) {
								%>
								<%
									if (opdPatientDetails.getReferedDepartment() != null
													&& opdPatientDetails.getReferedDepartment().getId() == dep.getId()) {
								%>
								<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
								<%
									} else {
								%>
								<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select> <label id="refersessionLabel" style="width: 115px;">Session</label>
							<select id="opsession" name="referredSession"
								style="width: 100px;">

								<%
									if (opdPatientDetails.getReferredSession() != null) {
								%>
								<option
									value="<%=opdPatientDetails.getReferredSession().getId()%>"
									selected="selected"><%=opdPatientDetails.getReferredSession().getSessionName()%></option>
								<%
									} else {
								%>
								<option value="0">Select</option>
								<%
									}
								%>

							</select> <label style="width: 100px;">Doctor</label> <select
								id="refereddoctor" name="refereddoctor">
								<%
									if (opdPatientDetails.getReferredDoctor() != null) {
											//Commented by Arbind on 15-03-2017
											/* String name=opdPatientDetails.getReferredDoctor().getFirstName();
												name=opdPatientDetails.getReferredDoctor().getMiddleName()!=null && !opdPatientDetails.getReferredDoctor().getMiddleName().equals("")?opdPatientDetails.getReferredDoctor().getMiddleName():" ";
												name=name+" "+opdPatientDetails.getReferredDoctor().getLastName()!=null && !opdPatientDetails.getReferredDoctor().getLastName().equals("")?opdPatientDetails.getReferredDoctor().getLastName():" "; */
								%>
								<option
									value="<%=opdPatientDetails.getReferredDoctor().getId()%>"
									selected="selected"><%=opdPatientDetails.getReferredDoctor().getEmployeeName()%></option>
								<%
									} else {
								%>
								<option value="0">Select</option>
								<%
									}
								%>
							</select>


							<div class="clear"></div>
							<label>Patient Advise</label>
							<textarea name="patientAdvise" validate="patientAdvise,string,no"
								id="patientAdvise" cols="0" rows="0" maxlength="500"
								style="margin-left: 0px; width: 141px;" tabindex="5"
								onkeyup="return checkLength(this)"><%=opdPatientDetails.getPatientAdvise() != null ? opdPatientDetails.getPatientAdvise() : ""%></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" /> <label style="width: 101px; margin-left: 0px;">Referral
								Notes</label>
							<textarea name="referralNote" validate="referralNote,string,no"
								id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
								style="margin-left: 0px; width: 162px;"
								onkeyup="return checkLength(this)"><%=opdPatientDetails.getReferralNotes() != null ? opdPatientDetails.getReferralNotes() : ""%></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" />
						</div>
						<input type="hidden" name="userName" value="<%=userName%>" />

						<%
							if (visit.getHin().getRelation() != null) {
									relationName = visit.getHin().getRelation().getRelationName();
									if (visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")) {
						%>
						<label>No. of Days</label> <input name="days" type="text"
							maxlength="1" />
						<%
							}
								}
						%>
					</div>
					<%
						} else {
					%>

					<div class="clear"></div>
					<div class="paddingTop2"></div>
					<div id="referalDiv">

						<label>Referral </label> <select id="referral" name="referral"
							class="midium">
							<option value="0" selected="selected">No</option>
							<option value="1">Yes</option>
						</select>

						<div id="referDiv" class="col collaps">
							<label class="auto">Refer To</label>
							<!-- <label><input type="checkbox"  name="referBack" id="referBack"  onclick="selectDept('referInternal');"/>ReferBack</label> -->
							<%
								if (opdpatientDetailId != 0) {
							%>
							<label class="auto"><input type="checkbox"
								class="radioCheckCol2" name="referBack" id="referBack"
								value="Internal"
								onclick="selectReferBack('<%out.print(referralDistrict);%>@@@<%out.print(referralHospital);%>@@@<%out.print(referralDept);%>@@@<%out.print(referralType);%>@@@<%out.print(deptNameforExternal);%>@@@<%=deptNameDoctorId%>@@@<%=deptNameDoctorName%>');" />ReferBack</label>
							<%
								}
							%>

							<label class="auto"><input type="radio"
								class="checkboxMargin" name="referTo" id="referInternal"
								value="Internal"
								onclick="checkReferTO('referInternal',<%=deptIdSession%>);" />Internal</label>
							<label class="auto"><input type="radio"
								class="checkboxMargin" name="referTo" id="referExternal"
								value="External"
								onclick="checkReferTO('referExternal',<%=deptIdSession%>);" />External</label>

							<div class="clear"></div>
							<label>Refer Date:</label> <input type="text" id="referVisitDate" onblur="checkReferDate(this.value);"
								name="referVisitDate" class="date" style="width: 133px;"
								value="<%=currentDate%>"
								onkeyup="mask(this.value,this,'2,5','-');" /> <img
								src="/hms/jsp/images/cal.gif" class="calenderImg" width="16"
								height="16" border="0" validate="Pick a date"
								onclick="setdate('<%=currentDate%>',document.opdMain.referVisitDate,event);" />
							<label id="priorityLabelId" style="width: 115px;">Current
								Proirity No.</label> <select id="priorityId" name="priorityName"
								tabindex="1" style="width: 100px;">
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select> <label id="referdistrictLabel" style="width: 100px;">District</label>
							<select id="referdistrict" name="referdistrict"
								onchange="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%
									for (MasDistrict district : masDistrictList) {
								%>
								<%
									if (districtId == district.getId()) {
								%>
								<option value="<%=district.getId()%>" selected="selected"><%=district.getDistrictName()%></option>
								<%
									} else {
								%>
								<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select>
							<div class="clear"></div>
							<label id="referHospitalTypeLabel">Hospital Type</label> <select
								id="referHospitalType" name="referHospitalType"
								style="width: 168px; margin-right: 0px;"
								onchange="fnGetDistrictHospital();"
								onblur="fnGetDistrictHospital();">
								<option value="0">Select</option>
								<%
									if (hospitalTypeList.size() > 0) {
											for (MasHospitalType masHospitalType : hospitalTypeList) {
								%>
								<%
									if (hospitalTypeId == masHospitalType.getId()) {
								%>
								<option value="<%=masHospitalType.getId()%>" selected="selected"><%=masHospitalType.getHospitalTypeName()%></option>
								<%
									} else {
								%>
								<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
								<%
									}
								%>
								<%
									}
										}
								%>
							</select> <label id="referhospitalLabel" style="width: 100px;">Hospital</label>
							<select id="referhospital" name="referhospital"
								onchange="fnGetHospitalDepartment(this.value,'referExternal',<%=deptIdSession%>);">
								<option value="0">Select</option>
								<%
									for (Object[] msh : masHospitals) {
								%>
								<%
									if (hospitalId == (Integer) msh[0]) {
								%>
								<option value="<%=msh[0]%>" selected="selected"><%=msh[1]%></option>
								<%
									} else {
								%>
								<option value="<%=msh[0]%>"><%=msh[1]%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select>
							<div class="clear"></div>
							<label id="referdepartmentLabel">Department</label> <select
								id="referdepartment" name="referdepartment"
								onchange="fnGetDoctorDepartment(this.value);getSessionForDepartment(this.value);"
								style="width: 169px; margin-right: 0px;">
								<option value="0">Select</option>
								<%
									for (MasDepartment dep : deptList) {
								%>
								<%
									if (deptId == dep.getId()) {
								%>
								<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
								<%
									} else {
								%>
								<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
								<%
									}
								%>
								<%
									}
								%>
							</select> <label id="refersessionLabel" style="width: 115px;">Session</label>
							<select id="opsession" name="referredSession"
								style="width: 100px;">
								<option value="0">Select</option>



							</select> <label style="width: 100px;">Doctor</label> <select
								id="refereddoctor" name="refereddoctor">
								<option value="0">Select</option>
							</select>

							<div class="clear"></div>
							<label>Patient Advise</label>
							<textarea name="patientAdvise" validate="patientAdvise,string,no"
								style="margin-left: 0px; width: 141px;" id="patientAdvise"
								cols="0" rows="0" maxlength="500" tabindex="5"
								onkeyup="return checkLength(this)"></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" /> <label style="width: 101px; margin-left: 0px;">Referral
								Notes</label>
							<textarea name="referralNote" validate="referralNote,string,no"
								id="referralNote" cols="0" rows="0" maxlength="500" tabindex="5"
								style="margin-left: 0px; width: 162px;"
								onkeyup="return checkLength(this)"></textarea>
							<input type="button" class="buttonAuto-buttn" value="+"
								onclick="" />
						</div>
						<input type="hidden" name="userName" value="<%=userName%>" />
						<%
							if (visit.getHin().getRelation() != null) {
									relationName = visit.getHin().getRelation().getRelationName();
									if (visit.getHin().getRelation().getRelationName().equalsIgnoreCase("Self")) {
						%>
						<label>No. of Days</label> <input name="days" type="text"
							maxlength="1" />
						<%
							}
								}
						%>
					</div>
					<%
						}
					%>

					<div class="clear"></div>
					<div class="paddingTop2"></div>

					<label class="auto">Personal Review<input type="checkbox"
						id="checked" class="checkboxMargin" name="chk1"
						onclick="popFuturConsultationReview('registration?method=showOnlineAppointmentPreviewJsp&futureConsultFlag=1&uhid=<%=visit.getHin().getHinNo()%>&deptId=<%=deptId%>&'+csrfTokenName+'='+csrfTokenValue)" /></label>

					<label class="medium">Remarks</label>

					<textarea name="opdRemarks" id="opdRemarks"
						style="width:385px; height: 40px; overflow-x: hidden; resize: vertical;"
						cols="0" rows="0" maxlength="500"><%=opdPatientDetails != null && opdPatientDetails.getOpdRemarks() != null
					&& opdPatientDetails.getVisit().getId().equals(visitId) ? opdPatientDetails.getOpdRemarks() : ""%></textarea>
					<%
						if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeDermatology"))) {
					%>
					<label class="auto">Review Note / Remarks</label>
					<%-- <textarea name="opdReview" id="opdReview"
		style="width: 400px; height: 60px;" cols="0" rows="0" 
		maxlength="256"(this)"><%=opdPatientDetails!=null && opdPatientDetails.getReview()!=null && opdPatientDetails.getVisit().getId().equals(visitId)?opdPatientDetails.getReview():"" %></textarea>
		commented by Babita --%>
					<%
						} else if (departmentCode != null && (departmentCode
								.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics")))) {
					%>
					<label class="auto">Follow Up Notes</label>
					<%
						} else {
					%>
					<label class="medium">Review</label>
					<%
						}
					%>
					<textarea name="opdReview" id="opdReview"
						style="width:385px; height: 40px;" cols="0" rows="0"
						class="historyAutoComplete" validate="OPD Review,string,no"
						maxlength="256"(this)"><%=opdPatientDetails != null && opdPatientDetails.getReview() != null
					&& opdPatientDetails.getVisit().getId().equals(visitId) ? opdPatientDetails.getReview() : ""%></textarea>

					<div class="clear"></div>
					<!-- show Hide div end here -->
				</div>


				<input type="hidden" id="reviewDate" name="reviewDate"
					class="dateTextSmall" value="<%=currentDate%>" readonly="readonly">
				<input id="PatientUhid" type="hidden" name="UHID"
					value="<%=visit.getHin().getHinNo()%>"> <input id="deptId"
					name="deptId" type="hidden" value="<%=deptId%>" /> <input
					id="doctorId" name="doctorId" type="hidden"
					value="<%=request.getParameter(CONSULTING_DOCTOR)%>"> <input
					id="deptName" name="deptName" type="hidden" value="<%=deptName%>">

			</div>


			<div class="Block" style="padding: 0px;">
				<div class="clear"></div>
				<input type="hidden" name="userName" value="<%=userName%>" /> <input
					type="hidden" name="diagnosis_status" id="diagnosis_status"
					value="p" /> <input id="visitId" name="visitId" id="visitId"
					type="hidden" value="<%=visit.getId()%>" /> <input name="hinId"
					id="hinId" type="hidden" value="<%=visit.getHin().getId()%>" /> <input
					name="hinNo" id="hinNo" type="hidden"
					value="<%=visit.getHin().getHinNo()%>" /> <input
					name="departmentId" type="hidden"
					value="<%=visit.getDepartment().getId()%>" /> <input
					name="imageStr" id="imageStrId" type="hidden" value="" /> <input
					name="visitDate" id="visitDate" type="hidden"
					value="<%=visit.getVisitDate()%>" /> <input name="departmentCode"
					id="departmentCode" type="hidden"
					value="<%=map.get("departmentCode") != null ? map.get("departmentCode").toString() : ""%>" />
				<input name="deptCodeENT" id="deptCodeENT" type="hidden"
					value="<%=HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT")%>" />
				<input name="opdType" id="opdType" type="hidden" value="LP" /> <input
					name="hospitalId" id="hospitalId" type="hidden"
					value="<%=hospitalId%>" /> <input name="empId" type="hidden"
					value="<%=docId%>" /> <input name="deptId" type="hidden"
					value="<%=deptId%>" /> <input id="consultationDate"
					name="consultationDate" type="hidden" value="<%=consultationDate%>" />
				<input name="opdpatientDetailId" type="hidden"
					value="<%=opdpatientDetailId%>" /> <input name="pHeaderId"
					type="hidden" value="<%=pHeaderId%>" /> <input
					name="consultationTime" type="hidden" value="<%=consultationTime%>" />
				<input type="hidden" id="patientName" name="patientName"
					value="<%=patientName%>" /> <input type="hidden" id="gender"
					name="gender" value="<%=gender != null ? gender : ""%>" /> <input
					type="hidden" id="patientAge" name="patientAge"
					value="<%=patientAge != 0 ? patientAge : ""%>" />


			</div>
			
	<div id="commButton" style="float:left; width:500px;">
			
			<input name="Submit11" id="Submit11" class="buttonAuto"
				value="Submit" type="button" align="right"
				style="background: #c55a11; color: #fff;"
				onclick="if(checkForProcedure()){if(fillcheckDoseFrequency() ){fnSubmitPatient('s');}}" />

			<%
				if (!visit.getVisitStatus().equalsIgnoreCase("c")) {
			%>
			<!-- <input type="button" class="buttonAuto" name="next" value="Next" style="background: #c55a11; color: #fff;" onclick="fnSubmitPatient('n');" /> -->

			<div class="countButtonMain">
				<input type="button" class="buttonAuto" name="next"
					style="background: #c55a11; color: #fff;" value="Next"
					onclick="fnSubmitPatient('n');" />
				<%
					if (opCallCount > 0) {
				%>
				<div class="countMain"><%=opCallCount%></div>
				<%
					}
				%>
			</div>



			<input type="button" class="buttonAuto"
				style="background: #c55a11; color: #fff;" value="Park Patient"
				onclick="fnSubmitPatient('p');" /> <input type="button"
				class="buttonAuto" style="background: #c55a11; color: #fff;"
				value="Second Opinion" onclick="SecondOpinion();" />
			<%
				if (opCallCount >= 2) {
			%>
			<input type="button" class="buttonAuto"
				style="background: #c55a11; color: #fff;" value="Release Patient"
				onclick="doPatientRelease('<%=visit.getId()%>','opd');" />
			<%
				}
			%>
			<%
				}
			%>
			
	
			
			<input name="Submit11" id="Submit11" class="buttonAuto" value="Reset"
				type="button" align="right" onclick="setFocus();"
				style="background: #c55a11; color: #fff;" />

			<%
				if (lastVisit.getId() != null && surgeryDetail.getPacRequest() != null
						&& surgeryDetail.getPacRequest().equalsIgnoreCase("y") && otPreAnesthesiaDetails.getId() != null) {
			%>
			<input type="button" class="buttonAuto" value="PAC Status"
				style="background: #c55a11; color: #fff;"
				onclick="getPacStatus('<%=surgeryHdr.getId()%>','<%=surgeryHdr.getVisit().getId()%>','<%=otPreAnesthesiaDetails.getId()%>');" />

			<%
				}
			%>

<div class="clear"></div>
</div>


			<table id="termTable" style="display: none;">
				<thead>
					<tr>
						<th>ConceptId</th>
						<th>Terms</th>
						<th>Type</th>
					</tr>
				</thead>
			</table>

			<!-- By Srikanth Start-->
			<div id="myModal" class="modal">

				<div class="modal-content" id="blockMedicineDiv">
					<span class="close" onclick="closePopUp();">&times;</span>
					<p id="blockMedicineMsg" style="color: red; font-weight: bold;"></p>
					<input type="hidden" id="blockMedicineTableId"
						name="blockMedicineTableId" /> <input type="hidden"
						id="incrementNum" /> <input type="button" value="UnBlock"
						onclick="unBlockMedicine();" /> <input type="button"
						value="Cancel" onclick="closePopUp();" />
				</div>

			</div>

			<!-- By Srikanth End-->

			<script>
function calculateBMIPaeditrics(age) {	
	var height = document.getElementById("height").value;
	var weight = document.getElementById("weight").value;
	document.getElementById("bmi").value = "";
	if(height != null && weight != null && height != "" && weight != "") {
		var height = 	parseFloat(height)/100;
		document.getElementById("bmiValue").value = ((weight/(height*height)).toFixed(2));
		document.getElementById("bmi").innerHTML = document.getElementById("bmiValue").value;
	}
	if(age >= 5){
	bmiCat();
	}
}
 
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
	//e0.style="width: 672px;" ;
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
	cellRight0.appendChild(sel);

}


function addRowMedicineForLP() {
	var tbl = document.getElementById('grid');

	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('pTabhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadioCheck' + iteration;
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
	e1.className = "nomenclaturepTab textYellow largTextBoxOpd";
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
		checkForBlockedMedicine(this.value, iteration);
		
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
	
	e1.setAttribute("validate", "doage,float,no");
	
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
	for (var i = 0; i < frequencyArray.length; i++) {
		// this part is added by amit das 
		 var opt = document.createElement('option'); 
		 	opt.id = frequencyArray[i][2];
		 	opt.value = frequencyArray[i][0];
		    opt.innerHTML = frequencyArray[i][1];
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
	
	 var cellRight1 = row.insertCell(8);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='ct'+iteration;
	  e1.id='ct'+iteration
	  e1.size='10';
	  e1.className='radio';
	  e1.value='y';
	  e1.setAttribute('tabindex','1');
	 cellRight1.appendChild(e1);
	
}

function fnGetPrescriptionTemplate(tempId) {
	var result = "";
	var noSelection=false;
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			if(tempId.options.length==1 && opt.value=="-1")
				noSelection=true;
			result += opt.value + ",";
		}
	}
   if(noSelection)
	 return;
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
	var opdType = document.getElementById("opdType").value;

	if (tempId.value != 0) {

		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getPrescriptionTemplateOP&templateId="
						+ result + "&updatedLen=" + updatedLen + "&hinId="
						+ hinId + "&visitId=" + visitId+"&opdType="+opdType, 'divPresTemplet1');
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
		//alert("dafsf"+document.getElementById("opdType").value);
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getLabInvestigationTemplate&templateid="
						+ result + "&hinId="
						+ document.getElementById("hinId").value +"&opdType="+document.getElementById("opdType").value+ "&"
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
	
	var cellRight5 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type="checkbox";
	e1.name = 'chkpacNeed' + iteration;
	e1.id = 'chkpacNeed' + iteration;
	//e1.style = 'width: 205px;';
	e1.onchange=function(){
		pacRequesting(iteration);
	};
	cellRight5.appendChild(e1);



}
var newwindow = null;
function popwindowResultEntryForDermotologyAnc(tempValue) {
	var array = new Array();
	array = tempValue.split("@@@");
	var hinId = array[0];
	var visitId = array[1];
	var templateFlag = array[2];
	//alert(templateFlag);
	var url = "/hms/hms/opd?method=showOutSideResultEntryDermotology&hinId="
			+ hinId + "&visitId=" + visitId +"&from=1" + "&templateFlag="+templateFlag;
	newwindow = window
			.open(url, 'name',
					"left=170,top=10,height=640,width=1000,status=1,scrollbars=1,resizable=0");
}
function parent_disable() {
    if (newwindow && !newwindow.closed)
    	newwindow.focus();
                 }
function getFrequencyValue(feqValue,inc){
	var feqQty;
	<%if (frequencyList.size() > 0) {
				for (MasFrequency masFrequency : frequencyList) {%>
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

function getFrequencyValueList(feqValue,inc){
	var feqQty;
	<%if (frequencyList.size() > 0) {
				for (MasFrequency masFrequency : frequencyList) {%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFrequencyCount()%>'
	  }

	<%}
			}%>
	if(document.getElementById('frequencyValueKmcl' + inc)!=null){
	 document.getElementById('frequencyValueKmcl'+inc).value = feqQty;
	}
	/*  if(document.getElementById('frequencyValuepTab' + inc)!=null){
	 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
	 } */
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

		if (document.getElementById('frequency' + inc).value == 24 && noOfDays > 0) {
			total = noOfDays;
		} else if (freq > 0 && dosage > 0 && noOfDays > 0) {
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
function isNumberOnly(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
		 if (iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}

function isNumberDecimalOnly(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
			 if (iKeyCode != 46 && iKeyCode > 31 
			            && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}



function fillcheckDoseFrequency() {
	var hdb = document.getElementById("pTabhdb").value;

	var i;
	var status = true;

	for (i = 0; i <= hdb; i++) {
		if (document.getElementById("nomenclature" + i) != null) {
			
			if (document.getElementById("tapered" + i).value.length==0) { 
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
			}
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
		//checkForAlreadyIssuedPrescribtionList(this.value, iteration);
		//populatePVMSList(this.value, iteration);
		checkItemList(iteration);
		//copyToPrescriptionTAbList(iteration, 'opconsult');
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
			'opd?method=getItemListForAutoCompleteOutItem', {
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

	
	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValueKmcl' + iteration;
	e21.id = 'frequencyValueKmcl' + iteration;
	cellRight1.appendChild(e21);
	
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'frequencyValueOut' + iteration;
	e1.id = 'frequencyValueOut' + iteration;
	e1.style.width = "68px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "6";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < frequencyArray.length; i++) {
		
		 var opt = document.createElement('option'); 
		 	opt.id = frequencyArray[i][2];
		 	opt.value = frequencyArray[i][0];
		    opt.innerHTML = frequencyArray[i][1];
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
	/* e1.onblur = function() {
		fillSPLInstrunctionOnPTAb(iteration);
	}; */
	e1.maxLength = "200";
	cellRight1.appendChild(e1);


	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'totalOut' + iteration;
	e1.id = 'totalOut' + iteration;
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
function displaySOSQtyList(val, inc) {
	if (val == '13') { // this value ????
		document.getElementById('sosQtyout' + inc).style.display = 'block';
		document.getElementById('noOfDaysOut' + inc).disabled = true;
		//document.getElementById('sosQtypTab' + inc).style.display = 'block';
		document.getElementById('noOfDaysOut' + inc).disabled = true;
	} else {

		document.getElementById('sosQtyout' + inc).style.display = 'none';
		document.getElementById('noOfDaysOut' + inc).disabled = false;
		//document.getElementById('sosQtypTab' + inc).style.display = 'none';
		document.getElementById('noOfDaysOut' + inc).disabled = false;
	}
}
function removeRowMedicineForLP(){
	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('pTabhdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadioCheck" + i) != null 
					&& (typeof document.getElementById("itemRadioCheck" + i).checked) != 'undefined'
					&& document.getElementById("itemRadioCheck" + i).checked == true) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
		}else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
			alert('You can not delete all Row');
		} else if (lastRow > 2) {
		var flag = 0;
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadioCheck" + i) != null
					&& (typeof document.getElementById("itemRadioCheck" + i).checked) != 'undefined'
					&& document.getElementById("itemRadioCheck" + i).checked) {
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

				var deleteRow = document.getElementById("itemRadioCheck" + i).parentNode.parentNode;
				document.getElementById("itemRadioCheck" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
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
			}else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
				alert('You can not delete all Row');
			} else if (lastRow > 2) {		
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
	}

// onload

var referralType = '<%out.print(referralType);%>';
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

function openPopupWindowAllergyForLP(csrf)  {
	var requestId = document.getElementById("requestId").value.trim();

	window
			.open(
					"/hms/hms/ot?method=showAllergy&requestId=" + requestId
							+ "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue + "&LP=y",
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}

function enableOPCommonDivForLP(flag)
{

	if(flag=="y")
		document.getElementById('opdCommon').style.display='block';
	else
		document.getElementById('opdCommon').style.display='none';
		
}

function hideSubmitButton(flag)
{
	if(flag=="y")
		document.getElementById('commButton').style.display='block';
	else
		document.getElementById('commButton').style.display='none';
		
}

<%if (empDeptCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeAnteNatalClinic"))) {%>
enableOPCommonDivForLP('y');display('39','Antenatal Card','OP');
document.getElementById('inTab1').style.display='none';
document.getElementById('inTab2').style.display='none';
document.getElementById('inTab4').style.display='block';

<%}%>

function validatePrescriptionAutocomplete(flag, strValue, inc) {
	if (flag == 'opmain') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('pTabhdb').value;
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
					alert('This Prescription is already selected.');
					document.getElementById('nomenclature' + inc).value = "";
					document.getElementById('tapered' + inc).value = "";
					document.getElementById('route' + inc).value = "0";
					document.getElementById('dosage' + inc).value = "";
					document.getElementById('unit' + inc).value = "";
					document.getElementById('noOfDays' + inc).value = "";
					return false;
				}
			}

		}
		return true;
	} else if (flag == 'opPTab') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hdb').value;
		if (id == "") {
			document.getElementById('nomenclaturepTab' + inc).value = "";
			return;
		}

		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclaturepTab' + i) != null
					&& document.getElementById('nomenclaturepTab' + i).value == strValue
					&& i != inc) {

				alert('This Prescription is already selected.');
				document.getElementById('nomenclaturepTab' + inc).value = "";
				return false;
			}
		}
		return true;
	} else if (flag == 'opNursingProc') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('nursinghdb').value;

		for (var i = 0; i < count; i++) {
			var nxtValue = document.getElementById('procedureName_nursing' + i).value;
			var index3 = nxtValue.lastIndexOf("[");
			var index4 = nxtValue.lastIndexOf("]");
			var nxtId1 = nxtValue.substring(index3, index4);
			var nxtId = "";
			/*
			 * if(nxtId1.charAt(0)=='['){ nxtId=nxtId1.substr(1); }
			 */
			nxtId = nxtId1.replace("[", "");
			if (document.getElementById('procedureName_nursing' + i).value != ""
					&& id != "" && nxtId != "" && id == nxtId && i != inc) {

				alert('This Procedure is already Entered.');
				document.getElementById('procedureName_nursing' + inc).value = "";
				return false;
			}
		}
		return true;
	}

}

</script>


		<!-- ------------------------------------for tapered medicine--------------- -- -->
		<div style="display: none;">
			<table id="taperedMedicne1">
				<th scope="col">Item Id</th>
				<th scope="col">Frequency</th>
				<th scope="col">Dosage</th>
				<th scope="col">Dosage Total</th>
				<th scope="col">Duration</th>
				<th scope="col">Total</th>
			</table>
			<input type="hidden" id="taperedMedicineHdb1"
				name="taperedMedicineHdb" value="0" />
		</div>
</form>
</body>
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
	<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb"
		value="0" />
	<!-- added by govind for tapered Medicine -->
</form>

<style>
.tabeLeftDiv {
	width: 690px;
	float: left;
}

.tabContWidth3 {
	width: 384px;
	margin-right: 5px;
	float: left;
}

.tabContWidth3 label {
	width: 377px;
	box-shadow: none;
	margin: 0px 0px 0px 4px; /* background:#ffd966; */
}

.tabContWidth3 textarea {
	width: 376px;
	height: 40px;
	margin-left: 4px;
	overflow-x: hidden;
	resize: vertical;
}

.tabContWidth2 {
	width: 579px;
	margin-right: 5px;
	float: left;
}

.tabContWidth2 label {
	width: 572px;
	box-shadow: none;
	margin: 0px 0px 0px 4px; /* background:#ffd966; */
}

.tabContWidth2 textarea {
	width: 571px;
	height: 40px;
	margin-left: 4px;
	overflow-x: hidden;
	resize: vertical;
}

.preDivLeft {
	width: 555px;
	float: left;
}

.preDivLeft label {
	width: auto;
	background: none;
	box-shadow: none;
	margin: 0px;
	height: 22px;
}

.vitalsDivRight {
	width: 613px;
	float: left;
}

.plusTabeDiv {
	width: 120px;
	float: left;
	margin-top: 4px;
}

.plusHideDiv {
	width: 529px;
	float: left;
}

.tabContWidth4 {
	width: 286px;
	margin-right: 5px;
	float: left;
}

.tabContWidth4 label {
	width: 277px;
	box-shadow: none;
	margin: 0px 0px 0px 4px;
	text-align: center; /* background:#ffd966; */
}

.tabContWidth4 textarea {
	width: 278px;
	margin-left: 4px;
	overflow-x: hidden;
	resize: vertical;
	height: 58px;
}

input.buttonSmall {
	width: auto;
	height: 19px;
	font-size: 10px;
	font-family: arial, tahoma, sans-serif;
}

.extlabDiv {
	float: left;
	width: 220px;
	height: 23px;
	margin-top: 5px;
	margin-bottom: 3px;
}

.extlabDiv h4 {
	cursor: pointer;
	text-decoration: underline;
}

.extlabDiv h4:hover {
	cursor: pointer;
	text-decoration: none;
}

.invleftDiv {
	width: 257px;
	float: left;
}

.invRightDiv {
	width: 725px;
	float: left;
}

.adviceDivMain input.buttonPlusMinus {
	height: 19px;
	width: 18px;
	float: right;
	margin: 2px 4px 0px 0px;
	padding: 0px;
	font-size: 16px;
	color: #000;
	background: #83d9ff;
}

.adviceDivMain {
	width: 1168px;
	float: left;
	background: #c5c4c4;
	cursor: pointer;
}

.hidAdviceDiv {
	display: none;
}

.tabContWidth5 {
	width: 205px;
	margin-right: 5px;
	float: left;
}

.tabContWidth5 label {
	width: 199px;
	box-shadow: none;
	margin: 0px 0px 0px 4px;
	text-align: center; /* background:#ffd966; */
}

.tabContWidth5 textarea {
	width: 198px;
	margin-left: 4px;
	overflow-x: hidden;
	resize: vertical;
	height: 40px;
	<%if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry"))) {%>
	height
	:
	100px;
	<%}%>
}
</style>


<script>
<%if (departmentCode
					.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralSurgery"))) {%>
enableOPCommonDivForLP('y');display('38','General Surgery','OP');
<%}%>
</script>

<script type="text/javascript">	
  				var	relationArray= new Array();
                      <%for (int k = 0; k < relationList.size(); k++) {
				MasRelation masRelation = (MasRelation) relationList.get(k);%> 
	     			relationArray[<%=k%>]= new Array();
	     			relationArray[<%=k%>][0] = "<%=masRelation.getId()%>";
	     			relationArray[<%=k%>][1] = "<%=masRelation.getRelationName()%>";
	             <%}%>
	             
	             
	    <%if (departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeENT"))) {%>
					function exportImages() {
					 	jQuery('.ann').annotate("export", { type: "image/png", quality:1 }, function(d) {
					        var imageData=d;
					        var imageName ;
					        var imageNameString ="";
					        var info;
					        var visitId = document.getElementById('visitId').value;
					        var deptName = document.getElementById('deptName').value;
					        var visitDate = document.getElementById('visitDate').value;
						  for(var i = 0; i <imageData.length; i++) {
					     	 info =imageData[i];
					     	imageName= (deptName+"_"+visitId+"_"+visitDate+"_"+i+1);
					     	
					     	if(imageNameString == ""){
					     		imageNameString = imageName;
					     	}else{
					     		imageNameString =imageNameString+","+imageName ;
					     	}
					      jQuery.ajax({
					     	 				url : "/hms/hms/opd?method=getImageData&visitId="+visitId+"&imageName="+(deptName+"_"+visitId+"_"+visitDate+"_"+i+1)+"&"+ csrfTokenName + "=" + csrfTokenValue,
												type : "POST",
												  data:{result :JSON.stringify(info)},
										          dataType: "json",	
												 success : function(result) {
												} 
											});
							 }

					     document.getElementById('imageStrId').value =imageNameString; 
					     }); 
					     
					 }
					<%
		}
	%>
			
	function setFocus()
    {
		document.getElementById("opdMainResetId").reset();
	     document.getElementById("Trimester1Summery").innerHTML="";
	     document.getElementById("Trimester2Summery").innerHTML="";
	     document.getElementById("Trimester3Summery").innerHTML="";
	     document.getElementById("pastHistorySummary").innerHTML="";	     
        
   }
	
	function checkFrequencyList(counter, loc) {
		if (counter > 0 && loc == "opc") {
			var obj = document.getElementById("frequencyValueOut" + (counter - 1));
			//var unitOut = document.getElementById("unitOut" + (counter - 1)).value;
			/* if (unitOut == "") {
				alert("Unit not available");
				document.getElementById("nomenclatures" + (counter - 1)).focus();
				return;
			} */
			if (obj.selectedIndex == 0) {
				alert("Select Frequency");
				document.getElementById("frequencyValueOut" + (counter - 1)).focus();
				return;
			}

		} else if (counter > 0 && loc == "tab") {
			var obj = document.getElementById("frequencypTab" + (counter - 1));
			var unitOut = document.getElementById("unitOut" + (counter - 1)).value;
			if (unitOut == "") {
				alert("Unit not available");
				document.getElementById("nomenclaturepTab" + (counter - 1)).focus();
				return;
			}
			if (obj.selectedIndex == 0) {
				alert("Select Frequency");
				document.getElementById("frequencypTab" + (counter - 1)).focus();
				return;
			}

		}
	}
	

	function validatePrescriptionAutocompleteForTemplate(strValue, inc, rowObj) {
		
			var index1 = strValue.lastIndexOf("[");
			var index2 = strValue.lastIndexOf("]");
			index1++;
			var id = strValue.substring(index1, index2);
			var drug =  strValue.substring(0,  strValue.lastIndexOf("(")-1);
			var count = document.getElementById('pTabhdb').value;
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
	

	function removeRowForOpdLite(i,boxtype,flag) {
		var rowCounter ;
		
		if(boxtype=='investigation'){
			rowCounter = document.getElementsByClassName('chargeCodeName').length;
		}else if(boxtype=='prescription'){
			rowCounter = document.getElementsByClassName('nomenclaturepTab').length;
		} else if(boxtype=='procedure'){
			rowCounter = document.getElementsByClassName('procedure').length;
		} else if(boxtype=='surgery'){
			rowCounter = document.getElementsByClassName('surgery').length;
		}else if(boxtype=='allergy'){
			rowCounter = document.getElementsByClassName('allergy').length;
		}
		if(rowCounter>1){
			
			if(flag && flag=='template'){
				var toBeDeletedInvestigation	=		i.parentNode.nextElementSibling.children[0].value;
				var deleteRow 					= 		i.parentNode.parentNode;
				i.parentNode.parentNode.parentNode.removeChild(deleteRow);
				
				if(boxtype=='prescription'){
					setDisablePharmacy();
				}
				
				if(boxtype=='investigation'){
					uncheckFixedInvestigation(toBeDeletedInvestigation);
				}
			} else if (confirm("Do you want to delete !")) {
				var toBeDeletedInvestigation	=		i.parentNode.nextElementSibling.children[0].value;
				var deleteRow 					= 		i.parentNode.parentNode;
				i.parentNode.parentNode.parentNode.removeChild(deleteRow);
				
				if(boxtype=='prescription'){
					setDisablePharmacy();
				}
				
				if(boxtype=='investigation'){
					uncheckFixedInvestigation(toBeDeletedInvestigation);
				}
			}
		}else{
			alert("You can not delete all rows !")
		}
		
	}
	function checkFrequencyForTaperedDrugs(inc) {
		var count = document.getElementById('hdb1').value;

		for (var i = 0; i < count; i++) {

			if (document.getElementById('nomenclature' + i) != null
					&& document.getElementById('nomenclature' + i).value == document
							.getElementById('nomenclature' + inc).value && i != inc) {
				if (document.getElementById('frequency' + i).value != '0'
						&& document.getElementById('dosage' + i).value != '') {

					if (document.getElementById('frequency' + i).value == document
							.getElementById('frequency' + inc).value
							&& document.getElementById('dosage' + i).value == document
									.getElementById('dosage' + inc).value) {
						alert('This Prescription is already selected with same dosage and frequency.');
						document.getElementById('frequency' + inc).value = "0";
						return false;
					}

				}
			}
		}
		return true;
	}

			             </script>



