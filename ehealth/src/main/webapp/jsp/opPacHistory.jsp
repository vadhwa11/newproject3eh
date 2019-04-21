<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OtPreAnesthesiaDetails"%>
<%@page import="jkt.hms.masters.business.AacAcceptance"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<%
Map<String, Object> map = new HashMap<String, Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
OpdSurgeryHeader opdSurgeryHeader=new OpdSurgeryHeader();
if(map.get("opdSurgeryHeader")!=null){
	opdSurgeryHeader=(OpdSurgeryHeader)map.get("opdSurgeryHeader");
}
Map<String,String> labResultMap=new HashMap<String,String>();
if(map.get("labResultMap")!=null){
	labResultMap=(Map<String,String>)map.get("labResultMap");
}

List<PatientPrescriptionDetails> patientPrescriptionDetailList= new ArrayList<PatientPrescriptionDetails>();
if(map.get("patientPrescriptionDetailList") != null){
	patientPrescriptionDetailList=(List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetailList");
}

OtPreAnesthesiaDetails otPreAnesthesiaDetails=new OtPreAnesthesiaDetails();
if(map.get("otPreAnesthesiaDetails") != null){
	otPreAnesthesiaDetails=(OtPreAnesthesiaDetails)map.get("otPreAnesthesiaDetails");
}
AacAcceptance aacAcceptance=new AacAcceptance();
if(map.get("aacAcceptance") != null){
	aacAcceptance=(AacAcceptance)map.get("aacAcceptance");
}

List<PatientInvestigationDetails> investigationDtlList=new ArrayList<PatientInvestigationDetails>();
if(map.get("investigationDetails") != null){
	investigationDtlList=(List<PatientInvestigationDetails>)map.get("investigationDetails");
}
List<OpdPatientAllergyT> BlockedMedicineList=new ArrayList<OpdPatientAllergyT>();
if(map.get("BlockedMedicineList") != null){
	BlockedMedicineList=(List<OpdPatientAllergyT>)map.get("BlockedMedicineList");
}

%>

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body style="padding-left: 120px">
<div class="clear"></div>
<h4>History</h4>
<div class="clear"></div>
<label>Allergy</label> 
<input type="text" id="txtAllergy" name="txtAllergy" value="<%=otPreAnesthesiaDetails.getAllergy()!=null?otPreAnesthesiaDetails.getAllergy():"" %>" />

<label >Diabetes</label> 
<input type="text" id="txtDiabetes" name="txtDiabetes" value="<%=otPreAnesthesiaDetails.getDiabetes()!=null?otPreAnesthesiaDetails.getDiabetes():"" %>" />

<label >Psychiatric illness</label> 
<input type="text" id="txtPsychiatric" name="txtPsychiatric"  value="<%=otPreAnesthesiaDetails.getPsychiatricIllness()!=null?otPreAnesthesiaDetails.getPsychiatricIllness():""%>"/>

<div class="clear"></div>

<label >Menstruation</label> 
<input type="text" id="txtMenstruation" name="txtMenstruation"  value="<%=otPreAnesthesiaDetails.getMenstruation()!=null?otPreAnesthesiaDetails.getMenstruation():"" %>" />

 <label>Asthma</label> 
<input type="text" id="txtAsthma" name="txtAsthma"  value="<%=otPreAnesthesiaDetails.getAsthma()!=null?otPreAnesthesiaDetails.getAsthma():"" %>" />

<label>Epilepsy</label> 
<input type="text" id="txtEpilepsy" name="txtEpilepsy" value="<%=otPreAnesthesiaDetails.getEpilepsy()!=null?otPreAnesthesiaDetails.getEpilepsy():"" %>" />

<div class="clear"></div>

<label>Tuberculosis</label> 
<input type="text" id="txtTuberculosis" name="txtTuberculosis" value="<%=otPreAnesthesiaDetails.getTuberculosis()!=null?otPreAnesthesiaDetails.getTuberculosis():"" %>" />

<label>Child Birth</label> 
<input type="text" id="txtChildBirth" name="txtChildBirth" value="<%=otPreAnesthesiaDetails.getChildBirth()!=null?otPreAnesthesiaDetails.getChildBirth():"" %>" />

<label>Chest Pain</label> 
<input type="text" id="txtChestPain" name="txtChestPain" value="<%=otPreAnesthesiaDetails.getChestPain()!=null?otPreAnesthesiaDetails.getChestPain():"" %>" />

<div class="clear"></div>

<label>Exercise Intolerance</label> 
<input type="text" id="txtExercise" name="txtExercise" value="<%=otPreAnesthesiaDetails.getExerciseIntolerance()!=null?otPreAnesthesiaDetails.getExerciseIntolerance():"" %>" />

<label>Previous Surgeries</label> 
<input type="text" id="txtPreviousSurgeries" name="txtPreviousSurgeries" value="<%=otPreAnesthesiaDetails.getPreviousSurgeries()!=null?otPreAnesthesiaDetails.getPreviousSurgeries():"" %>" />

<label>Smoking</label> 
<input type="text" id="txtSmoking" name="txtSmoking" value="<%=otPreAnesthesiaDetails.getSmoking()!=null?otPreAnesthesiaDetails.getSmoking():"" %>" />

<div class="clear"></div>

<label>Cough</label> 
<input type="text" id="txtCough" name="txtCough" value="<%=otPreAnesthesiaDetails.getCough()!=null?otPreAnesthesiaDetails.getCough():"" %>" />

<label>Hypertension</label> 
<input type="text" id="txtHypertension" name="txtHypertension" value="<%=otPreAnesthesiaDetails.getHypertension()!=null?otPreAnesthesiaDetails.getHypertension():"" %>" />

<label>Previous Anesthetic Exposures</label> 
<input type="text" id="txtAnestheticExposures" name="txtAnestheticExposures" value="<%=otPreAnesthesiaDetails.getAnesthticTechnique()!=null?otPreAnesthesiaDetails.getAnesthticTechnique():"" %>" />

<div class="clear"></div>

<label>Alcoholism</label> 
<input type="text" id="txtAlcoholism" name="txtAlcoholism" value="<%=otPreAnesthesiaDetails.getAlcoholism()!=null?otPreAnesthesiaDetails.getAlcoholism():"" %>" />

<label>Dyspnoea</label> 
<input type="text" id="txtDyspnoea" name="txtDyspnoea" value="<%=otPreAnesthesiaDetails.getDyspnoea()!=null?otPreAnesthesiaDetails.getDyspnoea():"" %>" />

<label>Heart Disease</label> 
<input type="text" id="txtHeartDisease" name="txtHeartDisease" value="<%=otPreAnesthesiaDetails.getHeartDisease()!=null?otPreAnesthesiaDetails.getHeartDisease():"" %>" />

<div class="clear"></div>

<label>General Anesthesia</label> 
<input type="text" id="txtGeneralAnesthesia" name="txtGeneralAnesthesia" value="<%=otPreAnesthesiaDetails.getGeneralAnesthesia()!=null?otPreAnesthesiaDetails.getGeneralAnesthesia():"" %>" />

<label>Dentures</label> 
<input type="text" id="txtDentures" name="txtDentures" value="<%=otPreAnesthesiaDetails.getDentures()!=null?otPreAnesthesiaDetails.getDentures():"" %>" />

<label>Dysphagia</label> 
<input type="text" id="txtDysphagia" name="txtDysphagia" value="<%=otPreAnesthesiaDetails.getDysphagia()!=null?otPreAnesthesiaDetails.getDysphagia():"" %>" />

<div class="clear"></div>

<label>Hoarseness</label> 
<input type="text" id="txtHoarseness" name="txtHoarseness" value="<%=otPreAnesthesiaDetails.getHoarseness()!=null?otPreAnesthesiaDetails.getHoarseness():"" %>" />

<label>Spinal Anesthesia</label> 
<input type="text" id="txtSpinalAnesthesia" name="txtSpinalAnesthesia" value="<%=otPreAnesthesiaDetails.getSpinalAnesthesia()!=null?otPreAnesthesiaDetails.getSpinalAnesthesia():"" %>" />

<label>Contact Lens</label> 
<input type="text" id="txtContactLens" name="txtContactLens" value="<%=otPreAnesthesiaDetails.getContactLens()!=null?otPreAnesthesiaDetails.getContactLens():"" %>" />

<div class="clear"></div>

<label>Dyspepsia</label> 
<input type="text" id="txtDyspepsia" name="txtDyspepsia" value="<%=otPreAnesthesiaDetails.getDyspepsia()!=null?otPreAnesthesiaDetails.getDyspepsia():"" %>" />

<label>IHD</label> 
<input type="text" id="txtIHD" name="txtIHD" value="<%=otPreAnesthesiaDetails.getIhd()!=null?otPreAnesthesiaDetails.getIhd():"" %>" />

<label>Complications</label> 
<input type="text" id="txtComplications" name="txtComplications" value="<%=otPreAnesthesiaDetails.getComplications()!=null?otPreAnesthesiaDetails.getComplications():"" %>" />

<div class="clear"></div>

<label>Hearing Aids</label> 
<input type="text" id="txtHearingAids" name="txtHearingAids" value="<%=otPreAnesthesiaDetails.getHearingAids()!=null?otPreAnesthesiaDetails.getHearingAids():"" %>" />

<label>Acid Peptic Disorders</label> 
<input type="text" id="txtAcidPepticDisorders" name="txtAcidPepticDisorders" value="<%=otPreAnesthesiaDetails.getAcidPepticDisorders()!=null?otPreAnesthesiaDetails.getAcidPepticDisorders():"" %>" />

<label>Jaundice</label> 
<input type="text" id="txtJaundice" name="txtJaundice" value="<%=otPreAnesthesiaDetails.getJaundice()!=null?otPreAnesthesiaDetails.getJaundice():"" %>" />

<div class="clear"></div>

<label>PONV</label> 
<input type="text" id="txtPONV" name="txtPONV" value="<%=otPreAnesthesiaDetails.getPonv()!=null?otPreAnesthesiaDetails.getPonv():"" %>" />

<div class="clear"></div>
<label>Remarks</label>
<textarea name="txtAreaHistoryRemarks" id="txtAreaHistoryRemarks" cols="0"  rows="0" class="large" style="width:905px"><%=otPreAnesthesiaDetails.getHistoryRemarks()!=null?otPreAnesthesiaDetails.getHistoryRemarks():"" %></textarea>
<div class="clear"></div>
<h4>Drug History</h4>
<div class="clear"></div>

<label>Antiallegeric</label> 
<input type="text" id="txtAntiallegeric" name="txtAntiallegeric" value="<%=otPreAnesthesiaDetails.getAntiallegeric()!=null?otPreAnesthesiaDetails.getAntiallegeric():"" %>" />

<label>CEBs</label> 
<input type="text" id="txtCEBs" name="txtCEBs" value="<%=otPreAnesthesiaDetails.getCebs()!=null?otPreAnesthesiaDetails.getCebs():"" %>" />

<label>Antiplatelets</label> 
<input type="text" id="txtAntiplatelets" name="txtAntiplatelets" value="<%=otPreAnesthesiaDetails.getAntiplatelets()!=null?otPreAnesthesiaDetails.getAntiplatelets():"" %>" />

<div class="clear"></div>

<label>Antihypertensives</label> 
<input type="text" id="txtAntihypertensives" name="txtAntihypertensives" value="<%=otPreAnesthesiaDetails.getAntihypertensives()!=null?otPreAnesthesiaDetails.getAntihypertensives():"" %>" />

<label>Antianginals</label> 
<input type="text" id="txtAntianginals" name="txtAntianginals" value="<%=otPreAnesthesiaDetails.getAntianginals()!=null?otPreAnesthesiaDetails.getAntianginals():"" %>" />

<label>Antituberculous</label> 
<input type="text" id="txtAntituberculous" name="txtAntituberculous"  value="<%=otPreAnesthesiaDetails.getAntituberculous()!=null?otPreAnesthesiaDetails.getAntituberculous():"" %>" />

<div class="clear"></div>

<label>Antiasthmatics</label> 
<input type="text" id="txtAntiasthmatics" name="txtAntiasthmatics" value="<%=otPreAnesthesiaDetails.getAntiasthmatics()!=null?otPreAnesthesiaDetails.getAntiasthmatics():"" %>" />

<label>Antidiabetics</label> 
<input type="text" id="txtAntidiabetics" name="txtAntidiabetics" value="<%=otPreAnesthesiaDetails.getAntidiabetics()!=null?otPreAnesthesiaDetails.getAntidiabetics():"" %>" />

<label>Antimalignancy</label> 
<input type="text" id="txtAntimalignancy" name="txtAntimalignancy" value="<%=otPreAnesthesiaDetails.getAntimalignancy()!=null?otPreAnesthesiaDetails.getAntimalignancy():"" %>" />

<div class="clear"></div>

<label>Diuretics</label> 
<input type="text" id="txtDiuretics" name="txtDiuretics" value="<%=otPreAnesthesiaDetails.getDiuretics()!=null?otPreAnesthesiaDetails.getDiuretics():"" %>" />

<label>Antiepileptics</label> 
<input type="text" id="txtAntiepileptics" name="txtAntiepileptics" value="<%=otPreAnesthesiaDetails.getAntiepileptics()!=null?otPreAnesthesiaDetails.getAntiepileptics():"" %>" />

<label>Antithyroid</label> 
<input type="text" id="txtAntithyroid" name="txtAntithyroid" value="<%=otPreAnesthesiaDetails.getAntithyroid()!=null?otPreAnesthesiaDetails.getAntithyroid():"" %>" />

<div class="clear"></div>

<label>Digoxin</label> 
<input type="text" id="txtDigoxin" name="txtDigoxin" value="<%=otPreAnesthesiaDetails.getDigoxin()!=null?otPreAnesthesiaDetails.getDigoxin():"" %>" />

<label>Antipsychotics</label> 
<input type="text" id="txtAntipsychotics" name="txtAntipsychotics" value="<%=otPreAnesthesiaDetails.getAntipsychotics()!=null?otPreAnesthesiaDetails.getAntipsychotics():"" %>" />

<label>Antacid</label> 
<input type="text" id="txtAntacid" name="txtAntacid" value="<%=otPreAnesthesiaDetails.getAntacid()!=null?otPreAnesthesiaDetails.getAntacid():"" %>" />

<div class="clear"></div>

<label>Beta Blockers</label> 
<input type="text" id="txtBetaBlockers" name="txtBetaBlockers" value="<%=otPreAnesthesiaDetails.getBetaBlockers()!=null?otPreAnesthesiaDetails.getBetaBlockers():"" %>" />

<label>Steroids</label> 
<input type="text" id="txtSteroids" name="txtSteroids" value="<%=otPreAnesthesiaDetails.getSteroids()!=null?otPreAnesthesiaDetails.getSteroids():"" %>" />

<label>H2 Blockers</label> 
<input type="text" id="txtH2Blockers" name="txtH2Blockers" value="<%=otPreAnesthesiaDetails.getH2Blockers()!=null?otPreAnesthesiaDetails.getH2Blockers():"" %>" />

<div class="clear"></div>

<label>Others</label>
<textarea name="txtAreaDrugHistoryOthers" id="txtAreaDrugHistoryOthers" cols="0"  rows="0" style="width:324px"><%=otPreAnesthesiaDetails.getDrugHistoryOthers()!=null?otPreAnesthesiaDetails.getDrugHistoryOthers():"" %>	</textarea>


<label>Remarks</label>
<textarea name="txtAreaDrugHistoryRemarks" id="txtAreaDrugHistoryRemarks" cols="0"  rows="0" class="large" style="width:394px"><%=otPreAnesthesiaDetails.getDrugHistoryRemarks()!=null?otPreAnesthesiaDetails.getDrugHistoryRemarks():"" %>	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<h4>Physical Examination</h4>
<div class="clear"></div>

<label >Airway</label> <input name="txtAirway" type="text"  value="<%=otPreAnesthesiaDetails.getAirway()!=null?otPreAnesthesiaDetails.getAirway():"" %>" />
<label >Mouth Opening</label> <input name="txtMouthOpening" type="text"  value="<%=otPreAnesthesiaDetails.getMouthOpening()!=null?otPreAnesthesiaDetails.getMouthOpening():"" %>" />
<label >TMJ</label> <input name="txtTMJ" type="text"  value="<%=otPreAnesthesiaDetails.getTmj()!=null?otPreAnesthesiaDetails.getTmj():"" %>" />
<div class="clear"></div>
<label >Neck Movements</label> <input name="txtNeckMovements" type="text"  value="<%=otPreAnesthesiaDetails.getNeckMovements()!=null?otPreAnesthesiaDetails.getNeckMovements():"" %>" />
<label >Tooth</label> <input name="txtTooth" type="text"  value="<%=otPreAnesthesiaDetails.getTooth()!=null?otPreAnesthesiaDetails.getTooth():"" %>" />
<label >Mallampatti Class</label> <input name="txtMallampattiClass" type="text"  value="<%=otPreAnesthesiaDetails.getMallampattiClass()!=null?otPreAnesthesiaDetails.getMallampattiClass():"" %>" />
<div class="clear"></div>
<label >Pulse</label> <input name="txtPulse" type="text"  value="<%=otPreAnesthesiaDetails.getPulse()!=null?otPreAnesthesiaDetails.getPulse():"" %>" />
<label >BP</label> <input name="txtBP" type="text"  value="<%=otPreAnesthesiaDetails.getBp()!=null?otPreAnesthesiaDetails.getBp():"" %>" />
<label >Pallor</label> <input name="txtPallor" type="text"  value="<%=otPreAnesthesiaDetails.getPallor()!=null?otPreAnesthesiaDetails.getPallor():"" %>" />
<div class="clear"></div>
<label >Icterus</label> <input name="txtIcterus" type="text"  value="<%=otPreAnesthesiaDetails.getIcetrus()!=null?otPreAnesthesiaDetails.getIcetrus():"" %>" />
<label >Venous Access</label> <input name="txtVenousAccess" type="text"  value="<%=otPreAnesthesiaDetails.getVenousAccess()!=null?otPreAnesthesiaDetails.getVenousAccess():"" %>" />
<label >Allen's Test</label> <input name="txtAllensTest" type="text"  value="<%=otPreAnesthesiaDetails.getAllensTest()!=null?otPreAnesthesiaDetails.getAllensTest():"" %>" />
<div class="clear"></div>
<label >Respiratory System</label> <input name="txtRespiratorySystem" type="text"  value="<%=otPreAnesthesiaDetails.getRespiratorySystem()!=null?otPreAnesthesiaDetails.getRespiratorySystem():"" %>" />
<label >Trachea</label> <input name="txtTrachea" type="text"  value="<%=otPreAnesthesiaDetails.getTrachea()!=null?otPreAnesthesiaDetails.getTrachea():"" %>" />
<label >Lungs</label> <input name="txtLungs" type="text"  value="<%=otPreAnesthesiaDetails.getLungs()!=null?otPreAnesthesiaDetails.getLungs():"" %>" />
<div class="clear"></div>
<label >Cardio Vascular System</label> <input name="txtCardioVascularSystem" type="text"  value="<%=otPreAnesthesiaDetails.getCardioVascularSystem()!=null?otPreAnesthesiaDetails.getCardioVascularSystem():"" %>" />
<label >Central Nervous System</label> <input name="txtCentralNervousSystem" type="text"  value="<%=otPreAnesthesiaDetails.getCentralNervousSystem()!=null?otPreAnesthesiaDetails.getCentralNervousSystem():"" %>" />
<label >Gastrointestinal System</label> <input name="txtGastrointestinalSystem" type="text"  value="<%=otPreAnesthesiaDetails.getGastrointestinalSystem()!=null?otPreAnesthesiaDetails.getGastrointestinalSystem():"" %>" />
<div class="clear"></div>
<label >Spine</label> <input name="txtSpine" type="text"  value="<%=otPreAnesthesiaDetails.getSpine()!=null?otPreAnesthesiaDetails.getSpine():"" %>" />
<label >Remarks</label> 
<textarea name="txtAreaPhysicalExamRemarks" id="txtAreaPhysicalExamRemarks" cols="0"  rows="0" style="width:542px;margin:0px 0px 0px"><%=otPreAnesthesiaDetails.getPhysicalExamination()!=null?otPreAnesthesiaDetails.getPhysicalExamination():"" %></textarea>

<div class="clear"></div>
<h4>Investigation Results</h4>
<div class="clear"></div>

<label >HIV</label> <input name="txtHIV" type="text"  value="<%=labResultMap.get("HIV")!=null?labResultMap.get("HIV"):"" %>" />
<label >HbSAg</label> <input name="txtHbSAg" type="text"   value="<%=labResultMap.get("HbsAg")!=null?labResultMap.get("HbsAg"):"" %>"/>
<label >HB</label> <input name="txtHb" type="text"   value="<%=labResultMap.get("Hemoglobin")!=null?labResultMap.get("Hemoglobin"):"" %>"/>
<div class="clear"></div>
<label >PCV</label> <input name="txtPCV" type="text"   value="<%=labResultMap.get("PCV")!=null?labResultMap.get("PCV"):"" %>"/>
<label >PT</label> <input name="txtPT" type="text"   value="<%=labResultMap.get("Prothrombine Time Test")!=null?labResultMap.get("Prothrombine Time Test"):"" %>"/>
<label >INR</label> <input name="txtINR" type="text"   value="<%=labResultMap.get("INR")!=null?labResultMap.get("INR"):"" %>"/>
<div class="clear"></div>
<label >APTT</label> <input name="txtAPTT" type="text"   value="<%=labResultMap.get("APTT")!=null?labResultMap.get("APTT"):"" %>"/>
<label >RBS</label> <input name="txtRBS" type="text"   value="<%=labResultMap.get("Random Blood Sugar")!=null?labResultMap.get("Random Blood Sugar"):"" %>"/>
<label >HCV</label> <input name="txtHCV" type="text"   value="<%=labResultMap.get("Hepatitis C Virus quantitation (HCV) PCR")!=null?labResultMap.get("Hepatitis C Virus quantitation (HCV) PCR"):"" %>"/>
<div class="clear"></div>
<label >TC</label> <input name="txtTC" type="text"   value="<%=labResultMap.get("Total WBC Count")!=null?labResultMap.get("Total WBC Count"):"" %>"/>

<label >BT</label> <input name="txtBT" type="text"   value="<%=labResultMap.get("Bleeding Time Clotting Time")!=null?labResultMap.get("Bleeding Time Clotting Time"):"" %>"/>
<label >CT</label> <input name="txtCT" type="text"   />

<div class="clear"></div>
<label style="width:20px">DC</label> 
<label style="width:130px;margin-left:0px;padding-left: 0px">P</label> <input name="txtDcP" type="text"   />
<label >L</label> <input name="txtDcL" type="text"   />
<label >E</label> <input name="txtDcE" type="text"   />
<div class="clear"></div>

<label >Blood Group</label> <input name="txtBloodGroup" type="text"   value="<%=labResultMap.get("Blood Group")!=null?labResultMap.get("Blood Group"):"" %>"/>
<label >Platelet Count</label> <input name="txtPlateletCount" type="text"   value="<%=labResultMap.get("Platelet Count")!=null?labResultMap.get("Platelet Count"):"" %>"/>
<label >BU</label> <input name="txtBU" type="text"   value="<%=labResultMap.get("Blood Urea")!=null?labResultMap.get("Blood Urea"):"" %>"/>
<div class="clear"></div>
<label >Ser. Creatinine</label> <input name="txtSerCreatinine" type="text"   value="<%=labResultMap.get("Creatinine")!=null?labResultMap.get("Creatinine"):"" %>"/>

<label >Cr. Clearance</label> <input name="txtCrClearance" type="text"   />
<label >S. Bilirubin</label> <input name="txtSBilirubin" type="text"   value="<%=labResultMap.get("Bilirubin Total")!=null?labResultMap.get("Bilirubin Total"):"" %>"/>
<div class="clear"></div>
<label >Total Protein</label> <input name="txtTotalProtein" type="text"   value="<%=labResultMap.get("Total Protein")!=null?labResultMap.get("Total Protein"):"" %>"/>
<label >Albumin</label> <input name="txtAlbumin" type="text"   value="<%=labResultMap.get("Albumin")!=null?labResultMap.get("Albumin"):"" %>"/>
<label >Glob</label> <input name="txtGlob" type="text"   value="<%=labResultMap.get("Globulin")!=null?labResultMap.get("Globulin"):"" %>"/>
<div class="clear"></div>
<label >Electrolytes</label> <input name="txtElectrolytes" type="text"   value="<%=labResultMap.get("Electrolytes")!=null?labResultMap.get("Electrolytes"):"" %>"/>
<label >Na</label> <input name="txtNa" type="text"   value="<%=labResultMap.get("Blood Sodium")!=null?labResultMap.get("Blood Sodium"):"" %>"/>
<label >Potassium</label> <input name="txtPotassium" type="text"   value="<%=labResultMap.get("Blood Potassium")!=null?labResultMap.get("Blood Potassium"):"" %>"/>
<div class="clear"></div>
<label >Ca</label> <input name="txtCa" type="text"   value="<%=labResultMap.get("Calcium")!=null?labResultMap.get("Calcium"):"" %>"/>
<label >Magnesium</label> <input name="txtMagnesium" type="text"   value="<%=labResultMap.get("Magnesium")!=null?labResultMap.get("Magnesium"):"" %>"/>
<label >SGOT</label> <input name="txtSGOT" type="text"   value="<%=labResultMap.get("SGOT")!=null?labResultMap.get("SGOT"):"" %>"/>
<div class="clear"></div>
<label >SGPT</label> <input name="txtSGPT" type="text"   value="<%=labResultMap.get("SGPT")!=null?labResultMap.get("SGPT"):"" %>"/>
<!-- <label >RBS</label> <input name="txtRBS" type="text"   /> -->
<label >TFT</label> <input name="txtTFT" type="text"   value="<%=labResultMap.get("Thyroid Function Test")!=null?labResultMap.get("Thyroid Function Test"):"" %>"/>
<div class="clear"></div>
<label style="width:40px">Urine</label>
<label style="width:100px">Albumin</label> <input name="txtUrineAlbumin" type="text"  value="<%=labResultMap.get("Urine Albumin")!=null?labResultMap.get("Urine Albumin"):"" %>" />
<label >Sugar</label> <input name="txtUrineSugar" type="text"   value="<%=labResultMap.get("Urine Sugar")!=null?labResultMap.get("Urine Sugar"):"" %>"/>
<label >Deposits</label> <input name="txtUrineDeposits" type="text"   value="<%=labResultMap.get("Urine Deposits")!=null?labResultMap.get("Urine Deposits"):"" %>"/>

<div class="clear"></div>
<label>PFT</label>
<textarea name="txtAreaPFT" id="txtAreaPFT" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>MRI</label>
<textarea name="txtAreaMRI" id="txtAreaMRI" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>CT</label>
<textarea name="txtAreaCT" id="txtAreaCT" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>USG</label>
<textarea name="txtAreaUSG" id="txtAreaUSG" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>


<label>X-ray</label>
<label style="margin-left:0px">Chest</label> <input name="txtXrayChest" type="text"   />
<label >Neck</label> <input name="txtXrayNeck" type="text"   />

<div class="clear"></div>
<label>ECG</label>
<textarea name="txtAreaECG" id="txtAreaECG" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>Echo</label>
<textarea name="txtAreaEcho" id="txtAreaEcho" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>TMT</label>
<textarea name="txtAreaTMT" id="txtAreaTMT" cols="0"  rows="0" class="large" style="width:905px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>Others</label>
<textarea name="txtAreainvstResultsOthers" id="txtAreainvstResultsOthers" cols="0"  rows="0" class="large" style="width:905px;height:25px">	<%=labResultMap.get("Others")!=null?labResultMap.get("Others"):"" %></textarea>
<div class="clear"></div>

<div class="clear"></div>

<h4>Prescription Details</h4>
<div class="clear"></div>
<table style="width:80%;margin-left: 2px">
<tr>
<th>Item Name</th>
<th>Frequency</th>
<th>No of Days</th>
<th>Dosage</th>
<th>Total</th>
</tr>
<%for(PatientPrescriptionDetails PatientPrescriptionDetails:patientPrescriptionDetailList){ %>
<tr>
<td><%=PatientPrescriptionDetails.getItem().getNomenclature() %></td>
<%if(PatientPrescriptionDetails.getFrequency()!=null){ %>
<td><%=PatientPrescriptionDetails.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>-</td>
<%} %>
<td><%=PatientPrescriptionDetails.getNoOfDays() %></td>
<td><%=PatientPrescriptionDetails.getDosage() %></td>
<td><%=PatientPrescriptionDetails.getTotal() %></td>
</tr>

<%} %>
</table>
<div class="clear"></div>
<h4>Blocked Medicines</h4>
<div class="clear"></div>
<table style="width:80%;margin-left: 2px">
<tr>
<th>Item Name</th>
<th>Blocked Days</th>
</tr>
<%if(BlockedMedicineList.size()>0){ for(OpdPatientAllergyT allergy:BlockedMedicineList){ %>
<tr>
<td><%=allergy.getAllergen()!=null && allergy.getAllergen()!=""?allergy.getAllergen():"" %></td>
<td><%=allergy.getBlockDays()!=null && allergy.getBlockDays()!=0?allergy.getBlockDays():"" %></td>
</tr>
<%} }%>
</table>

<div class="clear"></div>
<h4>Investigation Details</h4>
<div class="clear"></div>

<table style="width:80%;margin-left: 2px">
<tr>
<th>Test Name</th>
<th>SNOMED Concepts</th>
<th>Clinical Notes</th>
</tr>

<%if(investigationDtlList.size()>0){ for(PatientInvestigationDetails investigationDtl:investigationDtlList){ %>
<tr>
<td><%=investigationDtl.getChargeCode()!=null?investigationDtl.getChargeCode().getChargeCodeName():"" %></td>
<td><%=investigationDtl.getChargeCode()!=null && investigationDtl.getChargeCode().getSnomedConceptId()!=null?investigationDtl.getChargeCode().getSnomedConceptId():"" %></td>
<td><%=investigationDtl.getClinicalNotes()!=null?investigationDtl.getClinicalNotes():"" %></td>

</tr>

<%} }%>

</table>

<div class="clear"></div>
<h4>Acceptance</h4>
<div class="clear"></div>

<%if(aacAcceptance.getAcceptanceStatus()!=null && aacAcceptance.getAcceptanceStatus().equalsIgnoreCase("y")){ %>

<!-- <label>Accepted</label>
<input type="radio" name="rdAcceptance" id="rdAccepted" checked="checked"  /> -->
<div class="clear"></div>
<div id="AcceptedDiv">

<table style="width:80%;margin-left: 2px">

<col width="10%">
<col width="40%">
<col width="42%">

<th colspan="3">Accepted</th>

<tr>
<td rowspan="5">Grading</td>
<td>ASA PS</td>
<td>
<input type="text" id="txtGradingASAPS" name="txtGradingASAPS" size="80" value="<%=aacAcceptance.getGradingAsaps()!=null?aacAcceptance.getGradingAsaps():"" %>" />
</td>
</tr>

<tr>
<td>Goldman</td>
<td>
<input type="text" id="txtGradingGoldman" name="txtGradingGoldman" size="80" value="<%=aacAcceptance.getGradingGoldman()!=null?aacAcceptance.getGradingGoldman():"" %>" />
</td>
</tr>

<tr>
<td>Pugh</td>
<td>
<input type="text" id="txtGradingPugh" name="txtGradingPugh" size="80" value="<%=aacAcceptance.getGradingPugh()!=null?aacAcceptance.getGradingPugh():"" %>" />
</td>
</tr>

<tr>
<td>Child</td>
<td>
<input type="text" id="txtGradingChild" name="txtGradingChild" size="80" value="<%=aacAcceptance.getGradingChild()!=null?aacAcceptance.getGradingChild():"" %>" />
</td>
</tr>

<tr>
<td>Detsky</td>
<td>
<input type="text" id="txtGradingDetsky" name="txtGradingDetsky" size="80" value="<%=aacAcceptance.getGradingDetsky()!=null?aacAcceptance.getGradingDetsky():"" %>" />
</td>
</tr>

<tr>
<td rowspan="12">Instructions</td>
<td>Nil Per Oral</td>
<td>
<input type="text" id="txtInstructionsNilOral" name="txtInstructionsNilOral" size="80" value="<%=aacAcceptance.getNilPerOral()!=null?aacAcceptance.getNilPerOral():"" %>" />
</td>
</tr>

<tr>
<td>Informed Consent</td>
<td>
<input type="text" id="txtInstructionsinformedConsent" name="txtInstructionsinformedConsent" size="80" value="<%=aacAcceptance.getInformedConsent()!=null?aacAcceptance.getInformedConsent():"" %>" />
</td>
</tr>

<tr>
<td>Medicines To Be Taken On Previous Day</td>
<td>
<input type="text" id="txtPreviousDayMedicines" name="txtPreviousDayMedicines" size="80" value="<%=aacAcceptance.getPreviousDayMedicine()!=null?aacAcceptance.getPreviousDayMedicine():"" %>" />
</td>
</tr>

<tr>
<td>Night Sadation 10 PM</td>
<td>
<input type="text" id="txtNightSadation" name="txtNightSadation" size="80" value="<%=aacAcceptance.getNightSedation()!=null?aacAcceptance.getNightSedation():"" %>" />
</td>
</tr>

<tr>
<td>Medicines To Be Taken With a Sip Of Water At 6 AM On The Day Of Surgery</td>
<td>
<input type="text" id="txt6amMedicines" id="txt6amMedicines" size="80" value="<%=aacAcceptance.getMedicineAt6am()!=null?aacAcceptance.getMedicineAt6am():"" %>" />
</td>
</tr>

<tr>
<td>Continue All Cardiac Drugs</td>
<td>
<input type="text" id="txtContinueCardiacDrugs" name="txtContinueCardiacDrugs" size="80" value="<%=aacAcceptance.getCardiacDrugs()!=null?aacAcceptance.getCardiacDrugs():"" %>" />
</td>
</tr>

<tr>
<td>Further Advices Before Surgery</td>
<td>
<input type="text" id="txtFurtherAdvices" name="txtFurtherAdvices" size="80" value="<%=aacAcceptance.getAdviceBeforeSurgery()!=null?aacAcceptance.getAdviceBeforeSurgery():"" %>" />
</td>
</tr>

<tr>
<td>Investigations To Be Done On The Day Of Surgery</td>
<td>
<input type="text" id="txtInvestigationB4Surgery" name="txtInvestigationB4Surgery" size="80" value="<%=aacAcceptance.getSurgeryDayInvestigations()!=null?aacAcceptance.getSurgeryDayInvestigations():"" %>" />
</td>
</tr>

<tr>
<td>Infective Endocarditis - Prophylaxis</td>
<td>
<input type="text" id="txtInfectiveEndocarditis" name="txtInfectiveEndocarditis" size="80" value="<%=aacAcceptance.getInfectiveEndocarditis()!=null?aacAcceptance.getInfectiveEndocarditis():"" %>" />
</td>
</tr>

<tr>
<td>Remove Artificial Dentures, Contact Lens, Ornaments</td>
<td>
<input type="text" id="txtRemoveArtificialDentures" name="txtRemoveArtificialDentures" size="80" value="<%=aacAcceptance.getRemoveArtificial()!=null?aacAcceptance.getRemoveArtificial():"" %>" />
</td>
</tr>

<tr>
<td>Premedications</td>
<td>
<input type="text" id="txtPremedications" name="txtPremedications" size="80" value="<%=aacAcceptance.getPreMedications()!=null?aacAcceptance.getPreMedications():"" %>" />
</td>
</tr>

<tr>
<td>Others</td>
<td>
<input type="text" id="txtAcceptedOthers" name="txtAcceptedOthers" size="80" value="<%=aacAcceptance.getOthers()!=null?aacAcceptance.getOthers():"" %>" />
</td>
</tr>

</table>

</div>

<%} else if(aacAcceptance.getAcceptanceStatus()!=null && aacAcceptance.getAcceptanceStatus().equalsIgnoreCase("n")){%>

<!-- <label>Not Accepted</label>
<input type="radio" name="rdAcceptance" id="rdNotAccepted" checked="checked" /> -->
<div class="clear"></div>

<div id="notAcceptedDiv">
<table style="width:80%;margin-left: 2px">
<th colspan="3">Not Accepted</th>

<tr>
<td rowspan="3">At Present Dated</td>
<td>Remarks</td>
<td>
<input type="text" id="txtNotAcceptedRemarks" name="txtNotAcceptedRemarks" size="80" value="<%=aacAcceptance.getRemarks()!=null?aacAcceptance.getRemarks():"" %>" />
</td>
</tr>

<tr>
<td>Consultations</td>
<td>
<input type="text" id="txtConsultations" name="txtConsultations" size="80" value="<%=aacAcceptance.getConsultations()!=null?aacAcceptance.getConsultations():"" %>" /> 
</td>
</tr>

<tr>
<td>Further Investigations Needed</td>
<td>
<input type="text" id="txtFurtherInvestigations" name="txtFurtherInvestigations" size="80" value="<%=aacAcceptance.getFurtherInvestigationsNeeded()!=null?aacAcceptance.getFurtherInvestigationsNeeded():"" %>" />
</td>
</tr>

</table>
</div>

<% } %>
<div class="clear"></div>
<div class="clear"></div>
</body>
</html>