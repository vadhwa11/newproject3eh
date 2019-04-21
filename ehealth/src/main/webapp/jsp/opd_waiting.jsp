<%@page import="jkt.hms.masters.business.OpdHemoDialysis"%>
<%@page import="jkt.hms.masters.business.OpdGeneralPsychiatricCaseRecord"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaDetail"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaHeader"%>
<%@page import="jkt.hms.masters.business.OpdGynecologyCaseSheet"%>
<%@page import="jkt.hms.masters.business.OpdContactLensTemplate"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.OpdOralMedicineDental"%>
<%@page import="jkt.hms.masters.business.OpdOralAndMaxillofacialSurgery"%>
<%@page import="jkt.hms.masters.business.OpdEndodonticsHeader"%>
<%@page import="jkt.hms.masters.business.OpdFixedProsthodonticsHeader"%>
<%@page import="jkt.hms.masters.business.OpdMaxillofacialProsthesis"%>
<%@page import="jkt.hms.masters.business.OpdImplantPlanningHeader"%>
<%@page import="jkt.hms.masters.business.OpdRemovablePartialProsthodonticsHeader"%>
<%@page import="jkt.hms.masters.business.OpdDiagnosticRecord"%>
<%@page import="jkt.hms.masters.business.OpdPedodonticsVitalStatisticsHeader"%>
<%@page import="jkt.hms.masters.business.OpdPediatricRespiratorySpecialityHeader"%>
<%@page import="jkt.hms.masters.business.OpdCommunityOralHealthHeader"%>
<%@page import="jkt.hms.masters.business.OpdPsCaseRecordOrthodotics"%>
<%@page import="jkt.hms.masters.business.OpdOralMedicinePathology"%>
<%@page import="jkt.hms.masters.business.OpdPathologicMigration"%>
<%@page import="jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader"%>
<%@page import="jkt.hms.masters.business.OpdMaxillofacialTraumaHeader"%>
<%@page import="jkt.hms.masters.business.OpdPreAssessmentClinicDental"%>
<%@page import="jkt.hms.masters.business.OpdRespiratorySpecialityHeader"%>
<%@page import="jkt.hms.masters.business.OpdGeneralProformaHeader"%>
<%@page import="jkt.hms.masters.business.OpdPsychogeriatricClinicSpeciality"%>
<%@page import="jkt.hms.masters.business.OpdNicuCaseRecord"%>
<%@page import="jkt.hms.masters.business.OpdDermatologyLeprosyProforma"%>
<%@page import="jkt.hms.masters.business.OpdEntExaminationSpeciality"%>
<%@page import="jkt.hms.masters.business.DrugUsageHistory"%>
<%@page import="jkt.hms.masters.business.OpdMedicineSpecialityTemplate"%>
<%@page import="jkt.hms.masters.business.OpdOrthopedicSpeciality"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdAudiologicalExamEntSpeciality"%> 
<%@page import="jkt.hms.masters.business.NephrologyCaseSheet"%> 
<%@page import="jkt.hms.masters.business.FamilyPlanningGynecology"%> 


<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
 		}
 		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
 	List patientList = new ArrayList();
 	MasSpecialtyTemplate masSpecialtyTemplate = null; // adedd by amit das on 22-07-2016
 	
 	if(map.get("patientList") != null){
		patientList=(List)map.get("patientList");
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
	 boolean submitData = false;
	 if(map.get("submitData") != null){
		 submitData = (Boolean) map.get("submitData");
	 }
	 String hinNo ="";
	 if(map.get("hinNo") != null){
		 hinNo = (String)map.get("hinNo");
	 }
	 int visitNo = 0;
	 if(map.get("visitNo") != null){
		 visitNo = (Integer)map.get("visitNo");
	 }
	 int hinId=0;
	 if (map.get("hinId") != null) {
		 hinId = (Integer) map.get("hinId");
		}
	 int opdId=0;
		
	 if (map.get("opdId") != null) {
		 opdId = (Integer) map.get("opdId");
		}
	 int visitId=0;
	 if (map.get("visitId") != null) {
			visitId = (Integer) map.get("visitId");
		}
	 System.out.print("patientStatus check");
	 String patientStatus="";
	 if (map.get("patient_status") != null) {
		 patientStatus = (String) map.get("patient_status");
		 System.out.print("patientStatus "+patientStatus);
		}
	
	 // added by amit das on 22-07-2016 
	 if (map.get("masSpecialtyTemplate") != null) {
		 masSpecialtyTemplate = (MasSpecialtyTemplate) map.get("masSpecialtyTemplate");
		}
	 
	 String templateName = "";
	 if (map.get("templateName") != null) {
		 templateName = (String) map.get("templateName");
		}
	 String templateFlag = "";
	 if (map.get("templateFlag") != null) {
		 templateFlag = (String) map.get("templateFlag");
	 }
	 System.out.println("templateFlag=2222=="+templateFlag);
	 	OpdOrthopedicSpeciality orthopedicSpeciality = null; 
	 	
	 if (map.get("orthopedicSpeciality") != null) {
		 orthopedicSpeciality = (OpdOrthopedicSpeciality) map.get("orthopedicSpeciality");
		}
	 OpdMedicineSpecialityTemplate opdMedicineSpecialityTemplate=null;
	 if (map.get("opdMedicineSpecialityTemplate") != null) {
		 opdMedicineSpecialityTemplate = (OpdMedicineSpecialityTemplate) map.get("opdMedicineSpecialityTemplate");
		}
	 DrugUsageHistory drugUsageHistory=null;
	 if (map.get("drugUsageHistory") != null) {
		 drugUsageHistory = (DrugUsageHistory) map.get("drugUsageHistory");
		}
	  
	 OpdEntExaminationSpeciality opdEntExaminationSpeciality=null;
	 if (map.get("opdEntExaminationSpeciality") != null) {
		 opdEntExaminationSpeciality = (OpdEntExaminationSpeciality) map.get("opdEntExaminationSpeciality");
		}
	 OpdDermatologyLeprosyProforma opdLeprosyProforma=null;
	 if (map.get("opdLeprosyProforma") != null) {
		 opdLeprosyProforma = (OpdDermatologyLeprosyProforma) map.get("opdLeprosyProforma");
		}
	 OpdNicuCaseRecord opdNicuCaseRecord=null;
	 if (map.get("opdNicuCaseRecord") != null) {
		 opdNicuCaseRecord = (OpdNicuCaseRecord) map.get("opdNicuCaseRecord");
		}
	 
	 OpdGynecologyCaseSheet opdGynecologyCaseSheet=null;
	 if (map.get("opdGynecologyCaseSheet") != null) {
		 opdGynecologyCaseSheet = (OpdGynecologyCaseSheet) map.get("opdGynecologyCaseSheet");
		}
	 OpdContactLensTemplate opdContactLensTemplate=null;
	 if (map.get("opdContactLensTemplate") != null) {
		 opdContactLensTemplate = (OpdContactLensTemplate) map.get("opdContactLensTemplate");
		}
	 OpdPsychogeriatricClinicSpeciality opdPsychogeriatricClinicSpeciality=null;
	 if (map.get("opdPsychogeriatricClinicSpeciality") != null) {
		 opdPsychogeriatricClinicSpeciality = (OpdPsychogeriatricClinicSpeciality) map.get("opdPsychogeriatricClinicSpeciality");
		}
	OpdGeneralProformaHeader opdGeneralProformaHeader = null;
	 if (map.get("opdGeneralProformaHeader") != null) {
		 opdGeneralProformaHeader = (OpdGeneralProformaHeader) map.get("opdGeneralProformaHeader");
		}
	
	 OpdAudiologicalExamEntSpeciality opdAudiologicalExamEntSpeciality = null;
	 if (map.get("opdAudiologicalExamEntSpeciality") != null) {
		 opdAudiologicalExamEntSpeciality = (OpdAudiologicalExamEntSpeciality) map.get("opdAudiologicalExamEntSpeciality");
		}
	 	 
		OpdRespiratorySpecialityHeader opdRespiratorySpecialityHeader = null;
		 if (map.get("opdRespiratorySpecialityHeader") != null) {
			 opdRespiratorySpecialityHeader = (OpdRespiratorySpecialityHeader) map.get("opdRespiratorySpecialityHeader");
			}
		 int tokenNo=0;
		 if(map.get("referred_tokenNo") != null) {
		 	tokenNo = (Integer) map.get("referred_tokenNo");
		 }


		 String refferedDepartmentName="";
		 if(map.get("reffered_department_name") != null) {
		 	refferedDepartmentName = (String) map.get("reffered_department_name");
		 }
	 System.out.println("refferedDepartmentName "+refferedDepartmentName);
	 
	 
		OpdPreAssessmentClinicDental opdPreAssessmentClinicDental = null;
		 if (map.get("opdPreAssessmentClinicDental") != null) {
			 opdPreAssessmentClinicDental = (OpdPreAssessmentClinicDental) map.get("opdPreAssessmentClinicDental");
			}
		 
		OpdMaxillofacialTraumaHeader opdMaxillofacialTraumaHeader = null;
		if (map.get("opdMaxillofacialTraumaHeader") != null) {
			opdMaxillofacialTraumaHeader = (OpdMaxillofacialTraumaHeader) map.get("opdMaxillofacialTraumaHeader");
			}
			 
		OpdCaseRecordPeriodonticsHeader opdCaseRecordPeriodonticsHeader = null;
		 if (map.get("opdCaseRecordPeriodonticsHeader") != null) {
			 opdCaseRecordPeriodonticsHeader = (OpdCaseRecordPeriodonticsHeader) map.get("opdCaseRecordPeriodonticsHeader");
			}
				 
		OpdOralMedicinePathology opdOralMedicinePathology = null;
		 if (map.get("opdOralMedicinePathology") != null) {
			 opdOralMedicinePathology = (OpdOralMedicinePathology) map.get("opdOralMedicinePathology");
			 
		}
		
		 System.out.println("opdOralMedicinePathology---"+opdOralMedicinePathology);
		 OpdPsCaseRecordOrthodotics opdPsCaseRecordOrthodotics = null;
		 if (map.get("opdPsCaseRecordOrthodotics") != null) {
			 opdPsCaseRecordOrthodotics = (OpdPsCaseRecordOrthodotics) map.get("opdPsCaseRecordOrthodotics");
		}
		 
			OpdCommunityOralHealthHeader opdCommunityOralHealthHeader = null;
			 if (map.get("opdCommunityOralHealthHeader") != null) {
				 opdCommunityOralHealthHeader = (OpdCommunityOralHealthHeader) map.get("opdCommunityOralHealthHeader");
				}
			 
			OpdPedodonticsVitalStatisticsHeader opdPedodonticsVitalStatisticsHeader = null;
			if (map.get("opdPedodonticsVitalStatisticsHeader") != null) {
				opdPedodonticsVitalStatisticsHeader = (OpdPedodonticsVitalStatisticsHeader) map.get("opdPedodonticsVitalStatisticsHeader");
				}
				 
			OpdDiagnosticRecord opdDiagnosticRecord = null;
			 if (map.get("opdDiagnosticRecord") != null) {
				 opdDiagnosticRecord = (OpdDiagnosticRecord) map.get("opdDiagnosticRecord");
				}
					 
			OpdRemovablePartialProsthodonticsHeader opdRemovablePartialProsthodonticsHeader = null;
			 if (map.get("opdRemovablePartialProsthodonticsHeader") != null) {
				 opdRemovablePartialProsthodonticsHeader = (OpdRemovablePartialProsthodonticsHeader) map.get("opdRemovablePartialProsthodonticsHeader");
			}
		
			OpdImplantPlanningHeader opdImplantPlanningHeader = null;
			 if (map.get("opdImplantPlanningHeader") != null) {
				 opdImplantPlanningHeader = (OpdImplantPlanningHeader) map.get("opdImplantPlanningHeader");
			}
			
			 
			 
				OpdMaxillofacialProsthesis opdMaxillofacialProsthesis = null;
				 if (map.get("opdMaxillofacialProsthesis") != null) {
					 opdMaxillofacialProsthesis = (OpdMaxillofacialProsthesis) map.get("opdMaxillofacialProsthesis");
					}
				 
				OpdFixedProsthodonticsHeader opdFixedProsthodonticsHeader = null;
				if (map.get("opdFixedProsthodonticsHeader") != null) {
					opdFixedProsthodonticsHeader = (OpdFixedProsthodonticsHeader) map.get("opdFixedProsthodonticsHeader");
					}
					 
				OpdEndodonticsHeader opdEndodonticsHeader= null;
				 if (map.get("opdEndodonticsHeader") != null) {
					 opdEndodonticsHeader = (OpdEndodonticsHeader) map.get("opdEndodonticsHeader");
					}
						 
				OpdOralAndMaxillofacialSurgery opdOralAndMaxillofacialSurgery = null;
				 if (map.get("opdOralAndMaxillofacialSurgery") != null) {
					 opdOralAndMaxillofacialSurgery = (OpdOralAndMaxillofacialSurgery) map.get("opdOralAndMaxillofacialSurgery");
				}
			
				 OpdOralMedicineDental opdOralMedicineDental = null;
				 if (map.get("opdOralMedicineDental") != null) {
					 opdOralMedicineDental = (OpdOralMedicineDental) map.get("opdOralMedicineDental");
				}
							 
											 
				OpdObg opdObg = null;
				 if (map.get("opdObg") != null) {
					 opdObg = (OpdObg) map.get("opdObg");
				}
				 OpdHemoDialysis opdHemoDialysis = null;
					 if (map.get("opdHemoDialysis") != null) {
						 opdHemoDialysis = (OpdHemoDialysis) map.get("opdHemoDialysis");
					}	
				 NephrologyCaseSheet nephrologyCaseSheet = null;
				 if (map.get("nephrologyCaseSheet") != null) {
					 nephrologyCaseSheet = (NephrologyCaseSheet) map.get("nephrologyCaseSheet");
					}
				 FamilyPlanningGynecology familyPlanningGynecology = null;
				 if (map.get("familyPlanningGynecology") != null) {
					 familyPlanningGynecology = (FamilyPlanningGynecology) map.get("familyPlanningGynecology");
					}
	 
				 OpdPhototherapyProformaHeader opdPhototherapyProformaHeader = null;
				 if (map.get("opdPhototherapyProformaHeader") != null) {
					 opdPhototherapyProformaHeader = (OpdPhototherapyProformaHeader) map.get("opdPhototherapyProformaHeader");
					}
	 
				 OpdGeneralPsychiatricCaseRecord opdGeneralPsychiatricCaseRecord = null;
				 if (map.get("opdGeneralPsychiatricCaseRecord") != null) {
					 opdGeneralPsychiatricCaseRecord = (OpdGeneralPsychiatricCaseRecord) map.get("opdGeneralPsychiatricCaseRecord");
					}
				 
				 

String tempalteName="";
if (map.get("tempalteName") != null) {
	tempalteName = (String) map.get("tempalteName");
	}

String forms="";
if (map.get("forms") != null) {
	forms = (String) map.get("forms");
	}
	 
 %>
<form name="opdPatientList" method="post" action="" target="_blank">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2><%=deptName %></h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<%
	if(map.get("message") != null){
	   String message = (String)map.get("message");
	  %>
		 <div class="clear"></div>
		<label class="large">
		<span><%=message%>
		</span>
		</label>
		<div class="clear"></div>
		<div class="paddingTop5"></div>
	 <% }
int tokenForPhysio=0;
int visitNoTemp=0;
String opdType="";

if(map.get("tokenForPhysio")!=null){
	tokenForPhysio=(Integer)map.get("tokenForPhysio");
}
if(map.get("visitNoTemp")!=null){
	visitNoTemp=(Integer)map.get("visitNoTemp");
	
}if(map.get("opdType")!=null){
	opdType=(String)map.get("opdType");
}


//
//

String message1 ="";
if(map.get("message1") != null){
	message1  = (String)map.get("message1");
	   out.println(message1);
	  }
String transferPatientMessage="";

if(map.get("transferPatientMessage")!=null){
	transferPatientMessage=(String)map.get("transferPatientMessage");
}	
String antStatus = "";
if(map.get("antStatus") != null) {
	antStatus = (String) map.get("antStatus");
}



//
    %> <% if(submitData == true){
	%>
<%--  <label class="large"><span>Do you want to open <%=deptName%> --%>
<label class="large">Do you want to go back to patient waiting list ?
</span></label>
<div class="clear"></div>
<div class="paddingTop5"></div>

<%if(null !=refferedDepartmentName && !refferedDepartmentName.equals("")){System.out.println("s###############################refferedDepartmentName "+refferedDepartmentName); %>

<label class="auto"><span style="color:#000; font-size:14px;">Reffered Department Name -  <%=refferedDepartmentName%> " Token No. " <%=tokenNo %>
</span></label>
<%} %>
<div class="clear"></div>
<%if(tokenForPhysio!=0){ %>
<label class="large">
<span>Your Token : "<%=tokenForPhysio %>" , Visit No : " <%=visitNoTemp %>"  and Department : Physiotherapy OPD";
</span>
</label>
<%} %>
<div class="clear"></div>

<input type="hidden" name="hinNo" id="hinNo" value="<%=hinNo%>" />
 <input	type="hidden" name="visitNo" id="visitNo" value="<%=visitNoTemp%>" />
  <input	type="hidden" name="visitId" id="visitId" value="<%=visitId%>" />
  <input	type="hidden" name="opdPatientDetailId" id="opdPatientDetailId" value="<%=opdId%>" />
	<input type="hidden" name="deptId" id="deptId" value="<%=deptId%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

 

<%
	String urlDept = "";
	if(map.get("urlDept") != null){
		urlDept = (String)map.get("urlDept");
		String departmentCode = null;
		if(map.get("departmentCode") != null){
			departmentCode = (String)map.get("departmentCode");}
			
 %>
<%-- <input name="Yes" type="button" align="right" class="button"	value="Yes" onclick="submitForm('opdPatientList','<%=urlDept%>');" /> --%>
<% if(opdType.equalsIgnoreCase("lite")){%>
<input name="No" type="button" align="right" class="button" value="Yes"	onclick="submitForm('opdPatientList','opd?method=showNewOPWaitingList','checkTargetForNo');" />
<%}else if(opdType.equalsIgnoreCase("detail")){%>
<input name="No" type="button" align="right" class="button" value="Yes"	onclick="submitForm('opdPatientList','opd?method=showNewOPDetailWaitingList','checkTargetForNo');" />
<%}else{ %>
<input name="No" type="button" align="right" class="button" value="Yes"	onclick="submitForm('opdPatientList','opd?method=showOPClinicwWaitingPatientListJsp','checkTargetForNo');" />
<%} %>

<%-- <%if(departmentCode!=null && (departmentCode.equalsIgnoreCase(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine")) || departmentCode.equalsIgnoreCase(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")))) {%> --%>
<%if(opdType!=null && opdType.equalsIgnoreCase("LP")){%>
<input name="button2" type="button"	align="right" class="buttonBig2" value="Case Sheet"	onclick="submitFormForMedicineCaseSheetReport();" />
<%if(departmentCode!=null && departmentCode.equalsIgnoreCase(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePaeditrics"))){%>
<input name="button2" type="button"	align="right" class="buttonBig2" value="Case Sheet HTML"	onclick="submitFormForMedicineCaseSheetReport('html');" />
<%}%>
<%}else{ %>
<input name="button2" type="button"	align="right" class="buttonBig2" value="Case Sheet"	onclick="submitFormForCaseSheetReport();" />
<!-- //Note: Revert the changes for story NO :37
<input name="button2" type="button"	align="right" class="buttonBig2" value="Case Sheet HTML"	onclick="submitFormForCaseSheetReportHTML();" />
 -->
<%} %>

<input name="button2" type="button" align="right" class="buttonBig"	value="Prescription Print"	onclick="submitForm('opdPatientList','opd?method=showPatientPrescriptionReport');" />
<%if(forms != null && !forms.equals("")){ %>
<input name="button2" type="button" align="right" class="buttonBig"	value="Prescription Print HTML"	onclick="submitForm('opdPatientList','opd?method=prescriptionHTML&forms=<%=forms %>');" />
<%}else{ %>
<input name="button2" type="button" align="right" class="buttonBig"	value="Prescription Print HTML"	onclick="submitForm('opdPatientList','opd?method=prescriptionHTML');" />

<%} %>
<input name="button2" type="button" align="right" class="buttonBig"	value="Investigation Print HTML"	onclick="submitForm('opdPatientList','opd?method=investigationHTML');" />
<input name="button3" type="button" align="right" class="buttonBig"	value="Investigation Print"	onclick="submitForm('opdPatientList','opd?method=showPatientInvestigationReport');" />
<!-- 
<input type="button" value="Fitness Certificate" onclick="submitForm('opdPatientList','/hms/hms/registration?method=printFitnessCertificate')" />
<input type="button" value="PHYSICAL FITNESS" onclick="submitForm('opdPatientList','/hms/hms/registration?method=drivingFitnessCertificate&flag=p')" />
<input type="button" value="MEDICAL CERTIFICATE" onclick="submitForm('opdPatientList','/hms/hms/registration?method=drivingFitnessCertificate&flag=m')" />
<input type="button" value="VISUAL STANDARDS FOR DRIVING" onclick="submitForm('opdPatientList','/hms/hms/registration?method=drivingFitnessCertificate&flag=v')" /> -->

<%if(antStatus.equals("y")){ %>
<input name="button3" type="button" align="right" class="buttonBig"	value="Antenatal Card Speciality Print"	onclick="submitForm('opdPatientList','opd?method=showAntenatalCardReport&hinId=<%=hinId %>&visitId=<%=visitId %>');" />
<input name="button2" type="button" align="right" class="buttonBig"	value="Antenatal Card Speciality Print HTML"	onclick="submitForm('opdPatientList','opd?method=antenatalHTMLReport&hinId=<%=hinId %>');" />

<% } %>
<%if(null !=patientStatus && !patientStatus.equals("")){ %>
<input id="expiryDetailsId" type="button" name="expiry" value="Expiry Details" class="buttonBig" 
	onclick="submitForm('opdPatientList','/hms/hms/opd?method=submitDischargeInformation&flag=expiry');" />
<%}
%> 
<!-- added by amit das on 22-07-2016 -->
<%if(null !=templateFlag && !templateFlag.equals("") && templateFlag.equalsIgnoreCase("Template")){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReportTemplate('<%=visitId %>','<%=templateName %>');" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="<%=templateName%>">
 <input name="templateFlag" id="templateFlag" type="hidden" value="Template"> 
<%}else if(null!=orthopedicSpeciality){ %>
	<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
	<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Orthopedic">
<%}
	else if(null!=opdMedicineSpecialityTemplate){ %>
	<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
	<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Medicine">
<%}else if(null!=drugUsageHistory){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Deaddiction Centre">
<!-- <input name="templateFlag" id="templateFlag" type="hidden" value=""> -->
<%}else if(null!=opdEntExaminationSpeciality){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="ENT Examination">
<%}else if(null!=opdLeprosyProforma){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Leprosy Proforma">
<%}
else if(null!=opdAudiologicalExamEntSpeciality){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Audiological Examination">
<%}
else if(null!=opdNicuCaseRecord){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="niceCaseRecordPopwindow(<%=opdId%>,<%=visitId %>);" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Nicu Case Record">
<%}
else if(null!=opdGynecologyCaseSheet){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Gynecology Case Sheet">

<%}
else if(null!=opdContactLensTemplate){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Contact Lens"> 
<%}
else if(null!=nephrologyCaseSheet){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Nephrology Case Sheet">
<%}
else if(null!=familyPlanningGynecology){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Family Planning">
<%}
else if(null!=opdPhototherapyProformaHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Phototherapy Proforma">
<%}
else if(null!=opdGeneralPsychiatricCaseRecord){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityOpdDetailsIdReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="General Adult Psychiatry Case Record">
<%}
else if(null!=opdPsychogeriatricClinicSpeciality){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Psychogeriatric Clinic">
<input name="templateFlag" id="templateFlag" type="hidden" value="">
<%}
else if(null!=opdGeneralProformaHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="General Proforma">
<%}
else if(null!=opdRespiratorySpecialityHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Respiratory Clinic">
<%}
else if(null!=opdOralMedicineDental){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Oral Medicine">
<%}
else if(null!=opdOralAndMaxillofacialSurgery){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Oral and Maxillofacial Surgery">
<%}
else if(null!=opdEndodonticsHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Endodontics">
<%}
else if(null!=opdMaxillofacialProsthesis){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Maxillofacial Prosthesis">
<%}
else if(null!=opdFixedProsthodonticsHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Fixed Prosthodontics">
<%}
else if(null!=opdImplantPlanningHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Implant Planning">
<%}
else if(null!=opdRemovablePartialProsthodonticsHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Removable Partial Prosthodontics">
<%}
else if(null!=opdDiagnosticRecord){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Diagnostic Record Prosthodontics">
<%}
else if(null!=opdPedodonticsVitalStatisticsHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Pedodontics Vital Statistics">
<%}
else if(null!=opdPsCaseRecordOrthodotics){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="PG CASE RECORD - Orthodontics">
<%}
else if(null!=opdCommunityOralHealthHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Community Oral Health">
<%}

else if(null!=opdOralMedicinePathology){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Oral Medicine Pathology">
<%}
else if(null!=opdCaseRecordPeriodonticsHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Case Record Periodontics">
<%}
else if(null!=opdMaxillofacialTraumaHeader){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Maxillofacial Trauma - Proforma">
<%}
else if(null!=opdPreAssessmentClinicDental){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Pre Assessment Clinic">
<%}
else if(null!=opdObg){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Infertility Clinic">
<%}
else if(null!=opdHemoDialysis){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="Hemo Dialysis">
<%}

	}}
%>
<% if(tempalteName.equals("General Surgery")){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReportIPD();" />
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Excel" onclick="submitFormForSpecialityReportExcel();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="<%=tempalteName%>">
<%}%> 
 
<script>
function submitFormForSpecialityReportExcel()
{
	submitForm('opdPatientList','ipd?method=showPatientSpecialityReportExcel&hinId=<%=hinId %>');
	}

function submitFormForSpecialityReportIPD(){
			submitForm('opdPatientList','ipd?method=showPatientSpecialityReport&hinId=<%=hinId %>');
			//checkTargetForNo();
		}
</script>
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
				return true;
			  }
  		}
  		alert("Please select the patient")
		return false;

	}
function submitFormForSpecialityReportTemplate(visitId,templateName){
			
			//submitForm('opdPatientList','opd?method=htmlTemplateRpt');
			//checkTargetForNo();
			var url='/hms/hms/opd?method=htmlTemplateRpt&visitId='+visitId+'&specialityTemplateName='+templateName;
			popwindowForToolReport(url);
		}
	var newwindow1;
	function popwindowForToolReport(url) {
		url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
		newwindow1 = window.open(url, 'name', 'height=500,width=800,status=1');
		if (window.focus) {
			newwindow1.focus()
		}
		newwindow1.createPopup();
	}
		
		function submitFormForCaseSheetReport(){
			
			submitForm('opdPatientList','opd?method=showPatientMedicalCaseSheetReportNew&flag=1');
			//checkTargetForNo();
		}
		
      	//Note: Revert the changes for story NO :37
      /*  
      function submitFormForCaseSheetReportHTML(){
			
			submitForm('opdPatientList','opd?method=showPatientMedicalCaseSheetReportNew&flag=2');
			//checkTargetForNo();
		} */
		
	function submitFormForMedicineCaseSheetReport(reportFormat){
			submitForm('opdPatientList','opd?method=submitFormForMedicineCaseSheetReport&reportFormat='+reportFormat);
			//checkTargetForNo();
		}
		
		// added by amit das on 22-07-2016
		function submitFormForSpecialityReport(){
			submitForm('opdPatientList','opd?method=showPatientSpecialityReport');
			//checkTargetForNo();
		}
		function submitFormForSpecialityOpdDetailsIdReport(){
			submitForm('opdPatientList','opd?method=showPatientSpecialityOpdDetailsIdReport');
			//checkTargetForNo();
		}
		
		function niceCaseRecordPopwindow(value,visitId)
		{
			
		var url='/hms/hms/opd?method=printNicuCaseRecord&opdPatientDetailId='+value+'&visitId='+visitId;
		 popwindow(url);
		} 
		

		var newwindow;
		function popwindow(url) {
			url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
			newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
			if (window.focus) {
				newwindow.focus()
			}
			newwindow.createPopup();
		}
		
		
		
</script></form>

<% patientList=null;%>