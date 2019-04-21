<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="/hms/jsp/css/--style.css?n=1" rel="stylesheet" type="text/css" />
<style>

.reportMainDiv {width: 1080px;
height: auto;
background: #fff;
margin:0 auto;

}
@page {
    size: auto;   
    margin-top: 0;  
    margin-bottom: 0px;
}
.headerDiv
{
background: #aaa;
 width:100%; 
float:left;
}

label.mainlbl {
	/* background:red; */
	/* box-shadow: 0 1px 1px #c5c3c3; */
	font-weight: bold;
	font-size: 12px;
	height:24px;
	line-height:25px;
	color: #010101;
	width: 155px;
	float: left;
	text-align: left;
	padding:0px 0px 0px 5px;
	margin:0px 5px 5px 5px;
	/* text-indent:5px; */
}



label.value {
	font-size: 12px;
	font-weight:normal;
	color: #010101;
	width: 160px;
	float: left;
	text-align: left;
	padding: 0px 5px 0px 3px;
	margin: 0px 0px 0px 0px;
}

label.auto {
	font-weight: bold;
	font-size: 12px;	
	width: auto;
	float: left;
	text-align: left;
	padding: 0px 5px 0px 5px;
	margin: 0px 4px 0px 4px;
}
.clear, .Clear{
	clear: both;
	overflow: hidden;
	padding: 0px;
	margin: 0px;
	height: 1px;
}
</style>
</head>
<body>
<%Map map = new HashMap();
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
String uhid = null;
String patientName = "";
String age = "";
int patientAge = 0;
String gender = "";
int visitNo=0;
String department=null;
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
	String mac = null;
	String presentComplaintHistory="";
String personalPresentHistory="";
String familyPastHistory="";
String physicalExamination="";
String madicationHistory="";
String[] parts={"",""};
String noSysDias="";
String treatmentPlan =null;
String deferredDiagnosis = null;
String surgeryHistory =null;
String medicationhistory =null;
String earExamination = null;
String nosePnsExamination =null;
String oralCavityThroatExamination = null;
String neckExamination = null;
String developmentHistory =null;
String dietHistory = null;
String socioEconomicHistory = null;
String pastHistory =null;
String menstrualHistory = null;
String obstreticHistory = null;
String managementPlan =null;
String nonPharmacological=null;
String antenatalHistory=null;
int visitId=0;
int opdpatientDetailId =0;
if(visit!=null)
{
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
	
	if (visit.getVisitNo() != null) {
		visitNo = visit.getVisitNo();
	}
	
	if (visit.getDepartment() != null) {
		department = visit.getDepartment().getDepartmentName();
	}
}

OpdPatientDetails opdPatientDetails = null;
String lastEncounterDetail = "";
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
		weight=preOpdPatientDetails.getWeight()!=null?preOpdPatientDetails.getWeight():0.0;
		respirtoryRate =preOpdPatientDetails.getRespiratoryRate()!=null?preOpdPatientDetails.getRespiratoryRate():0;
		spo2 = preOpdPatientDetails.getSpo2()!=null?preOpdPatientDetails.getSpo2():0;
		 stuning = preOpdPatientDetails.getStuning()!=null?preOpdPatientDetails.getStuning():null;
	  	 pem = preOpdPatientDetails.getPem()!=null?preOpdPatientDetails.getPem():null;
	  	 wasting = preOpdPatientDetails.getWasting()!=null?preOpdPatientDetails.getWasting():null;
	  	 mac = preOpdPatientDetails.getMac()!=null?preOpdPatientDetails.getMac():"";
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
		nonPharmacological = preOpdPatientDetails.getNonPharmacological();
		deferredDiagnosis = preOpdPatientDetails.getDeferredDiagnosis();
		if(opdPatientDetails.getVisit().getId().equals(visitId))
		{
			 earExamination = opdPatientDetails.getEarExamination();
			 nosePnsExamination =opdPatientDetails.getNosePnsExamination();
			 oralCavityThroatExamination = opdPatientDetails.getOralCavityThroatExamination();
			 neckExamination = opdPatientDetails.getNeckExamination();
			managementPlan = opdPatientDetails.getManagementPlan();
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
		 surgeryHistory = preOpdPatientHistory.getSurgicalHistory() !=null?preOpdPatientHistory.getSurgicalHistory():"";
	  	 medicationhistory = preOpdPatientHistory.getMadicationHistory()!=null?preOpdPatientHistory.getMadicationHistory():"";
	  	 developmentHistory =preOpdPatientHistory.getDevelopmentHistory();
		 dietHistory = preOpdPatientHistory.getDietHistory();
		 socioEconomicHistory = preOpdPatientHistory.getSocioEconomicHistory();
		pastHistory = preOpdPatientHistory.getPastHistory();
		menstrualHistory = preOpdPatientHistory.getMenstrualHistory();
		obstreticHistory = preOpdPatientHistory.getObstreticHistory();
		antenatalHistory = preOpdPatientHistory.getAntenatalHistory()!=null?preOpdPatientHistory.getAntenatalHistory():"";
		
}
	int counter = 0;
%>
<h2 style="text-align: center;">EHEALTH KERALA</h2>
<div class="reportMainDiv">
<div class="headerDiv">
<label class="mainlbl">UHID</label><label class="auto">:</label> <label class="value"><%=uhid%></label>
<label class="mainlbl">Patient Name</label><label class="auto">:</label> <label class="value"><%=patientName%></label>
<div class="clear"></div> 
<label class="mainlbl">Age</label><label class="auto">:</label> <label class="value"><%=patientAge%></label>
<label class="mainlbl">Visit no</label><label class="auto">:</label> <label class="value"><%=visitNo%></label>
<div class="clear"></div> 
<label class="mainlbl">Department</label><label class="auto">:</label> <label class="value"><%=department%></label>
<div class="clear"></div> 
 </div>
<div class="clear"></div> 
<div class="clear"></div> 
<%if(antenatalHistory!=null && !antenatalHistory.isEmpty()){%>
<label class="mainlbl">Presenting Complaints</label><label class="auto">:</label> <label class="value"><%=presentComplaintHistory%></label>
<%counter++;}%>
<%if(antenatalHistory!=null && !antenatalHistory.isEmpty()){%>
<label class="mainlbl">History of Presenting Illness</label><label class="auto">:</label> <label class="value"><%=opdPatientHistoriesStr%></label>
<%}counter++;%>
<%if(antenatalHistory!=null && !antenatalHistory.isEmpty()){%>
<label class="mainlbl">Past History</label><label class="auto">:</label> <label class="value"><%=pastHistory%></label>
<%}counter++;%>
<%if(counter==3)%>
<div class="clear"></div>
 <%if(antenatalHistory!=null && !antenatalHistory.isEmpty()){%>
<label class="mainlbl">Antenatal/ Natal / Post Natal History</label><label class="auto">:</label> <label class="value"><%=antenatalHistory%></label>
<%}%>
<%if(familyPastHistory!=null && !familyPastHistory.isEmpty()){%>
<label class="mainlbl">Family History 	</label><label class="auto">:</label> <label class="value"><%=familyPastHistory%></label>
<%}%>
<%if(medicationhistory!=null && !medicationhistory.isEmpty()){%>
<label class="mainlbl">Medication History</label><label class="auto">:</label> <label class="value"><%=medicationhistory%></label>
<%}%>
<%if(developmentHistory!=null && !developmentHistory.isEmpty()){%>
<label class="mainlbl">Development History</label><label class="auto">:</label> <label class="value"><%=developmentHistory%></label>
<%}%>
<%if(dietHistory!=null && !dietHistory.isEmpty()){%>
<label class="mainlbl">Diet History</label><label class="auto">:</label> <label class="value"><%=dietHistory%></label>
<%}%>
<%if(socioEconomicHistory!=null && !socioEconomicHistory.isEmpty()){%>
<label class="mainlbl">Socio Economic History</label><label class="auto">:</label> <label class="value"><%=socioEconomicHistory%></label>
<%}%> 
<div class="clear"></div> 
</div>
</body>
</html>
