<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>


<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<!-- <script src="/hms/jsp/js/dischargeMedication.js" type="text/javascript"></script> -->
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<%
Map<String, Object> map = new HashMap<String, Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
Map<String,String> labResultMap=new HashMap<String,String>();
if(map.get("labResultMap")!=null){
	labResultMap=(Map<String,String>)map.get("labResultMap");
}
OpdSurgeryHeader opdSurgeryHeader=new OpdSurgeryHeader();
if(map.get("opdSurgeryHeader")!=null){
	opdSurgeryHeader=(OpdSurgeryHeader)map.get("opdSurgeryHeader");
}
int visitId=opdSurgeryHeader.getVisit()!=null?opdSurgeryHeader.getVisit().getId():0;
int hinId=opdSurgeryHeader.getVisit()!=null?opdSurgeryHeader.getVisit().getHin().getId():opdSurgeryHeader.getInpatient().getHin().getId();
List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
if(map.get("frequencyList") != null){
frequencyList=(List)map.get("frequencyList");
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
  
int inpatientId=0;
if(opdSurgeryHeader.getInpatient()!=null){
	inpatientId=opdSurgeryHeader.getInpatient().getId();
}
int opdSurgeryId=0;
if(opdSurgeryHeader!=null){
	opdSurgeryId=opdSurgeryHeader.getId();
}

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("serviceCenters") != null)
{
	departmentList=(List<MasDepartment>)map.get("serviceCenters");
}
List<PatientPrescriptionDetails> patientPrescriptionDetailList= new ArrayList<PatientPrescriptionDetails>();
if(map.get("patientPrescriptionDetailList") != null){
	patientPrescriptionDetailList=(List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetailList");
}

String depart="";
if(session.getAttribute(DEPT_ID)!=null){
	depart=String.valueOf(session.getAttribute(DEPT_ID));
}
String allergy="";
if(map.get("AllergyData")!=null){
	allergy=(String)map.get("AllergyData");
}
String diabetes="";
if(map.get("Diabetes")!=null){
	diabetes=(String)map.get("Diabetes");
}

%>



<title>Pre-Anesthesia Assessment Form Entry</title>
<form name="preAnesthesia" method="post" action="/hms/hms/ot?method=submitAac">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Anesthesia Assessment Clinic</h2>
</div>

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="Block">
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>UHID</label> 
<input type="text" name="txtUhid" id="txtUhid" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getHinNo() %>"  style="width:197px" />
<label>Patient Name</label> 
<input type="text" name="txtPatName" id="txtPatName" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getPFirstName() %>"  style="width:197px" />
<label>Requisition Date</label> 
<input type="text" name="txtPatDate" id="txtPatDate" readonly="readonly" value="<%=opdSurgeryHeader.getRequisitionDate() %>"  style="width:197px" />
<label>Age</label> 
<input type="text" name="txtPatAge" id="txtPatAge" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getAge() %>" style="width:197px"  />
<label>Gender</label> 
<input type="text" name="txtPatGender" id="txtPatGender" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName() %>" style="width:197px" />

<label>Weight</label> 
<input type="text" name="txtPatWeight" id="txtPatWeight" readonly="readonly" value="<%=opdSurgeryHeader.getVisit()!=null&&opdSurgeryHeader.getVisit().getWeight()!=null?opdSurgeryHeader.getVisit().getWeight():"" %>" style="width:197px" />
<label>Unit</label> 
<input type="text" name="txtPatUnit" id="txtPatUnit" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getUnit()!=null?opdSurgeryHeader.getHin().getUnit().getUnitName():"" %>" style="width:197px" />
<label>Proposed Surgery</label> 
<textarea name="txtAreaProposedSurgery" id="txtAreaProposedSurgery" cols="0"  rows="0" class="large" style="width:567px;height:25px" readonly="readonly">
<%=opdSurgeryHeader.getOpdSurgeryDetails()!=null&&((OpdSurgeryDetail)(opdSurgeryHeader.getOpdSurgeryDetails().toArray()[0])).getChargeCode()!=null?((OpdSurgeryDetail)(opdSurgeryHeader.getOpdSurgeryDetails().toArray()[0])).getChargeCode().getChargeCodeName():"" %>	
</textarea>

<div class="clear"></div>
<h4>History</h4>
<div class="clear"></div>
<label>Allergy</label> 
<input type="checkbox" id="chkAllergy" name="chkAllergy" style="margin: 0px 0px 0px 0px"  onclick="historyDetails('Allergy');"/>
<input type="text" id="txtAllergy" name="txtAllergy"  value="<%=!allergy.equals("")?allergy:"" %>"  disabled />

<label >Diabetes</label> 
<input type="checkbox" id="chkDiabetes" name="chkDiabetes" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Diabetes');"/>
<input type="text" id="txtDiabetes" name="txtDiabetes" value="<%=diabetes%>" disabled />

<label >Psychiatric illness</label> 
<input type="checkbox" id="chkPsychiatric" name="chkPsychiatric" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Psychiatric illness');"/>
<input type="text" id="txtPsychiatric" name="txtPsychiatric" disabled />

<div class="clear"></div>

<label >Menstruation</label> 
<input type="checkbox" id="chkMenstruation" name="chkMenstruation" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Menstruation');"/>
<input type="text" id="txtMenstruation" name="txtMenstruation" disabled />

 <label>Asthma</label> 
<input type="checkbox" id="chkAsthma" name="chkAsthma" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Asthma');"/>
<input type="text" id="txtAsthma" name="txtAsthma" disabled />

<label>Epilepsy</label> 
<input type="checkbox" id="chkEpilepsy" name="chkEpilepsy" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Epilepsy');"/>
<input type="text" id="txtEpilepsy" name="txtEpilepsy" disabled />

<div class="clear"></div>

<label>Tuberculosis</label> 
<input type="checkbox" id="chkTuberculosis" name="chkTuberculosis" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Tuberculosis');"/>
<input type="text" id="txtTuberculosis" name="txtTuberculosis" disabled />

<label>Child Birth</label> 
<input type="checkbox" id="chkChildBirth" name="chkChildBirth" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Child Birth');"/>
<input type="text" id="txtChildBirth" name="txtChildBirth" disabled />

<label>Chest Pain</label> 
<input type="checkbox" id="chkChestPain" name="chkChestPain" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Chest Pain');"/>
<input type="text" id="txtChestPain" name="txtChestPain" disabled />

<div class="clear"></div>

<label>Exercise Intolerance</label> 
<input type="checkbox" id="chkExercise" name="chkExercise" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Exercise Intolerance');"/>
<input type="text" id="txtExercise" name="txtExercise" disabled />

<label>Previous Surgeries</label> 
<input type="checkbox" id="chkPreviousSurgeries" name="chkPreviousSurgeries" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Previous Surgeries');"/>
<input type="text" id="txtPreviousSurgeries" name="txtPreviousSurgeries" disabled />

<label>Smoking</label> 
<input type="checkbox" id="chkSmoking" name="chkSmoking" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Smoking');"/>
<input type="text" id="txtSmoking" name="txtSmoking" disabled />

<div class="clear"></div>

<label>Cough</label> 
<input type="checkbox" id="chkCough" name="chkCough" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Cough');"/>
<input type="text" id="txtCough" name="txtCough" disabled />

<label>Hypertension</label> 
<input type="checkbox" id="chkHypertension" name="chkHypertension" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Hypertension');"/>
<input type="text" id="txtHypertension" name="txtHypertension" disabled />

<label>Previous Anesthetic Exposures</label> 
<input type="checkbox" id="chkAnestheticExposures" name="chkAnestheticExposures" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Previous Anesthetic Exposures');"/>
<input type="text" id="txtAnestheticExposures" name="txtAnestheticExposures" disabled />

<div class="clear"></div>

<label>Alcoholism</label> 
<input type="checkbox" id="chkAlcoholism" name="chkAlcoholism" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Alcoholism');"/>
<input type="text" id="txtAlcoholism" name="txtAlcoholism" disabled />

<label>Dyspnoea</label> 
<input type="checkbox" id="chkDyspnoea" name="chkDyspnoea" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Dyspnoea');"/>
<input type="text" id="txtDyspnoea" name="txtDyspnoea" disabled />

<label>Heart Disease</label> 
<input type="checkbox" id="chkHeartDisease" name="chkHeartDisease" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Heart Disease');"/>
<input type="text" id="txtHeartDisease" name="txtHeartDisease" disabled />

<div class="clear"></div>

<label>General Anesthesia</label> 
<input type="checkbox" id="chkGeneralAnesthesia" name="chkGeneralAnesthesia" style="margin: 0px 0px 0px 0px" onclick="historyDetails('General Anesthesia');"/>
<input type="text" id="txtGeneralAnesthesia" name="txtGeneralAnesthesia" disabled />

<label>Dentures</label> 
<input type="checkbox" id="chkDentures" name="chkDentures" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Dentures');"/>
<input type="text" id="txtDentures" name="txtDentures" disabled />

<label>Dysphagia</label> 
<input type="checkbox" id="chkDysphagia" name="chkDysphagia" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Dysphagia');"/>
<input type="text" id="txtDysphagia" name="txtDysphagia" disabled />

<div class="clear"></div>

<label>Hoarseness</label> 
<input type="checkbox" id="chkHoarseness" name="chkHoarseness" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Hoarseness');" />
<input type="text" id="txtHoarseness" name="txtHoarseness" disabled />

<label>Spinal Anesthesia</label> 
<input type="checkbox" id="chkSpinalAnesthesia" name="chkSpinalAnesthesia" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Spinal Anesthesia');" />
<input type="text" id="txtSpinalAnesthesia" name="txtSpinalAnesthesia" disabled />

<label>Contact Lens</label> 
<input type="checkbox" id="chkContactLens" name="chkContactLens" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Contact Lens');"/>
<input type="text" id="txtContactLens" name="txtContactLens" disabled />

<div class="clear"></div>

<label>Dyspepsia</label> 
<input type="checkbox" id="chkDyspepsia" name="chkDyspepsia" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Dyspepsia');"/>
<input type="text" id="txtDyspepsia" name="txtDyspepsia" disabled />

<label>IHD</label> 
<input type="checkbox" id="chkIHD" name="chkIHD" style="margin: 0px 0px 0px 0px" onclick="historyDetails('IHD');"/>
<input type="text" id="txtIHD" name="txtIHD" disabled />

<label>Complications</label> 
<input type="checkbox" id="chkComplications" name="chkComplications" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Complications');"/>
<input type="text" id="txtComplications" name="txtComplications" disabled />

<div class="clear"></div>

<label>Hearing Aids</label> 
<input type="checkbox" id="chkHearingAids" name="chkHearingAids" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Hearing Aids');"/>
<input type="text" id="txtHearingAids" name="txtHearingAids" disabled />

<label>Acid Peptic Disorders</label> 
<input type="checkbox" id="chkAcidPepticDisorders" name="chkAcidPepticDisorders" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Acid Peptic Disorders');"/>
<input type="text" id="txtAcidPepticDisorders" name="txtAcidPepticDisorders" disabled />

<label>Jaundice</label> 
<input type="checkbox" id="chkJaundice" name="chkJaundice" style="margin: 0px 0px 0px 0px" onclick="historyDetails('Jaundice');"/>
<input type="text" id="txtJaundice" name="txtJaundice" disabled />

<div class="clear"></div>

<label>PONV</label> 
<input type="checkbox" id="chkPONV" name="chkPONV" style="margin: 0px 0px 0px 0px" onclick="historyDetails('PONV');"/>
<input type="text" id="txtPONV" name="txtPONV" disabled />

<div class="clear"></div>
<label>Remarks</label>
<textarea name="txtAreaHistoryRemarks" id="txtAreaHistoryRemarks" cols="0"  rows="0" class="large" style="width:942px">	</textarea>
<div class="clear"></div>
<h4>Drug History</h4>
<div class="clear"></div>

<label>Antiallegeric</label> 
<input type="checkbox" id="chkAntiallegeric" name="chkAntiallegeric" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antiallegeric');"/>
<input type="text" id="txtAntiallegeric" name="txtAntiallegeric" disabled />

<label>CEBs</label> 
<input type="checkbox" id="chkCEBs" name="chkCEBs" style="margin: 0px 0px 0px 0px" onclick="drugDetails('CEBs');"/>
<input type="text" id="txtCEBs" name="txtCEBs" disabled />

<label>Antiplatelets</label> 
<input type="checkbox" id="chkAntiplatelets" name="chkAntiplatelets" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antiplatelets');"/>
<input type="text" id="txtAntiplatelets" name="txtAntiplatelets" disabled />

<div class="clear"></div>

<label>Antihypertensives</label> 
<input type="checkbox" id="chkAntihypertensives" name="chkAntihypertensives" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antihypertensives');"/>
<input type="text" id="txtAntihypertensives" name="txtAntihypertensives" disabled />

<label>Antianginals</label> 
<input type="checkbox" id="chkAntianginals" name="chkAntianginals" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antianginals');"/>
<input type="text" id="txtAntianginals" name="txtAntianginals" disabled />

<label>Antituberculous</label> 
<input type="checkbox" id="chkAntituberculous" name="chkAntituberculous" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antituberculous');"/>
<input type="text" id="txtAntituberculous" name="txtAntituberculous" disabled />

<div class="clear"></div>

<label>Antiasthmatics</label> 
<input type="checkbox" id="chkAntiasthmatics" name="chkAntiasthmatics" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antiasthmatics');"/>
<input type="text" id="txtAntiasthmatics" name="txtAntiasthmatics" disabled />

<label>Antidiabetics</label> 
<input type="checkbox" id="chkAntidiabetics" name="chkAntidiabetics" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antidiabetics');"/>
<input type="text" id="txtAntidiabetics" name="txtAntidiabetics" disabled />

<label>Antimalignancy</label> 
<input type="checkbox" id="chkAntimalignancy" name="chkAntimalignancy" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antimalignancy');"/>
<input type="text" id="txtAntimalignancy" name="txtAntimalignancy" disabled />

<div class="clear"></div>

<label>Diuretics</label> 
<input type="checkbox" id="chkDiuretics" name="chkDiuretics" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Diuretics');"/>
<input type="text" id="txtDiuretics" name="txtDiuretics" disabled />

<label>Antiepileptics</label> 
<input type="checkbox" id="chkAntiepileptics" name="chkAntiepileptics" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antiepileptics');"/>
<input type="text" id="txtAntiepileptics" name="txtAntiepileptics" disabled />

<label>Antithyroid</label> 
<input type="checkbox" id="chkAntithyroid" name="chkAntithyroid" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antithyroid');"/>
<input type="text" id="txtAntithyroid" name="txtAntithyroid" disabled />

<div class="clear"></div>

<label>Digoxin</label> 
<input type="checkbox" id="chkDigoxin" name="chkDigoxin" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Digoxin');"/>
<input type="text" id="txtDigoxin" name="txtDigoxin" disabled />

<label>Antipsychotics</label> 
<input type="checkbox" id="chkAntipsychotics" name="chkAntipsychotics" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antipsychotics');"/>
<input type="text" id="txtAntipsychotics" name="txtAntipsychotics" disabled />

<label>Antacid</label> 
<input type="checkbox" id="chkAntacid" name="chkAntacid" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Antacid');"/>
<input type="text" id="txtAntacid" name="txtAntacid" disabled />

<div class="clear"></div>

<label>Beta Blockers</label> 
<input type="checkbox" id="chkBetaBlockers" name="chkBetaBlockers" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Beta Blockers');"/>
<input type="text" id="txtBetaBlockers" name="txtBetaBlockers" disabled />

<label>Steroids</label> 
<input type="checkbox" id="chkSteroids" name="chkSteroids" style="margin: 0px 0px 0px 0px" onclick="drugDetails('Steroids');"/>
<input type="text" id="txtSteroids" name="txtSteroids" disabled />

<label>H2 Blockers</label> 
<input type="checkbox" id="chkH2Blockers" name="chkH2Blockers" style="margin: 0px 0px 0px 0px" onclick="drugDetails('H2 Blockers');"/>
<input type="text" id="txtH2Blockers" name="txtH2Blockers" disabled />

<div class="clear"></div>

<label>Others</label>
<textarea name="txtAreaDrugHistoryOthers" id="txtAreaDrugHistoryOthers" cols="0"  rows="0" style="width:324px">	</textarea>


<label>Remarks</label>
<textarea name="txtAreaDrugHistoryRemarks" id="txtAreaDrugHistoryRemarks" cols="0"  rows="0" class="large" style="width:433px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<h4>Physical Examination</h4>
<div class="clear"></div>

<label >Airway</label> <input name="txtAirway" type="text"  style="width:197px" />
<label >Mouth Opening</label> <input name="txtMouthOpening" type="text"  style="width:197px" />
<label >TMJ</label> <input name="txtTMJ" type="text"  style="width:197px" />
<label >Neck Movements</label> <input name="txtNeckMovements" type="text"  style="width:197px" />
<label >Tooth</label> <input name="txtTooth" type="text"  style="width:197px" />
<label >Mallampatti Class</label> <input name="txtMallampattiClass" type="text"  style="width:197px" />
<label >Pulse</label> <input name="txtPulse" type="text"  style="width:197px" />
<label >BP</label> <input name="txtBP" type="text"  style="width:197px" />
<label >Pallor</label> <input name="txtPallor" type="text"  style="width:197px" />
<label >Icterus</label> <input name="txtIcterus" type="text"  style="width:197px" />
<label >Venous Access</label> <input name="txtVenousAccess" type="text"  style="width:197px" />
<label >Allen's Test</label> <input name="txtAllensTest" type="text" style="width:197px" />
<label >Respiratory System</label> <input name="txtRespiratorySystem" type="text"  style="width:197px" />
<label >Trachea</label> <input name="txtTrachea" type="text"  style="width:197px" />
<label >Lungs</label> <input name="txtLungs" type="text"  style="width:197px" />
<label >Cardio Vascular System</label> <input name="txtCardioVascularSystem" type="text"  style="width:197px" />
<label >Central Nervous System</label> <input name="txtCentralNervousSystem" type="text"  style="width:197px" />
<label >Gastrointestinal System</label> <input name="txtGastrointestinalSystem" type="text"  style="width:197px" />
<label >Spine</label> <input name="txtSpine" type="text"  style="width:197px" />
<label >Remarks</label> 
<textarea name="txtAreaPhysicalExamRemarks" id="txtAreaPhysicalExamRemarks" cols="0"  rows="0" style="width:566px;margin:0px 0px 0px">	</textarea>

<div class="clear"></div>
<h4>Investigation Results</h4>
<div class="clear"></div>

<label >HIV</label> <input name="txtHIV" type="text"  value="<%=labResultMap.get("HIV")!=null?labResultMap.get("HIV"):"" %>" style="width:197px" />
<label >HbSAg</label> <input name="txtHbSAg" type="text"   value="<%=labResultMap.get("HBSAG")!=null?labResultMap.get("HBSAG"):"" %>" style="width:197px" />
<label >HB</label> <input name="txtHb" type="text"   value="<%=labResultMap.get("HB")!=null?labResultMap.get("HB"):"" %>" style="width:197px" />
<label >PCV</label> <input name="txtPCV" type="text"   value="<%=labResultMap.get("PCV")!=null?labResultMap.get("PCV"):"" %>" style="width:197px" />
<label >PT</label> <input name="txtPT" type="text"   value="<%=labResultMap.get("PT")!=null?labResultMap.get("PT"):"" %>" style="width:197px" />
<label >INR</label> <input name="txtINR" type="text"   style="width:197px" />
<label >APTT</label> <input name="txtAPTT" type="text"  style="width:197px"  />
<label >RBS</label> <input name="txtRBS" type="text"   value="<%=labResultMap.get("RBS")!=null?labResultMap.get("RBS"):"" %>" style="width:197px" />
<label >HCV</label> <input name="txtHCV" type="text"   value="<%=labResultMap.get("HCV")!=null?labResultMap.get("HCV"):"" %>" style="width:197px" />
<label >TC</label> <input name="txtTC" type="text"   value="<%=labResultMap.get("TC")!=null?labResultMap.get("TC"):"" %>" style="width:197px" />

<label >BT</label> <input name="txtBT" type="text"   value="<%=labResultMap.get("BT")!=null?labResultMap.get("BT"):"" %>" style="width:197px" />
<label >CT</label> <input name="txtCT" type="text"  style="width:197px"  />

<div class="clear"></div>
<label style="width:20px">DC</label> 
<label style="width:130px;margin-left:0px;padding-left: 0px">P</label> <input name="txtDcP" type="text"  style="width:197px"  />
<label >L</label> <input name="txtDcL" type="text"  style="width:197px"  />
<label >E</label> <input name="txtDcE" type="text"  style="width:197px"  />

<label >Blood Group</label> <input name="txtBloodGroup" type="text"   value="<%=labResultMap.get("BloodGroup")!=null?labResultMap.get("BloodGroup"):"" %>" style="width:197px" />
<label >Platelet Count</label> <input name="txtPlateletCount" type="text"   value="<%=labResultMap.get("Platelet Count")!=null?labResultMap.get("Platelet Count"):"" %>" style="width:197px" />
<label >BU</label> <input name="txtBU" type="text"   value="<%=labResultMap.get("Blood Urea")!=null?labResultMap.get("Blood Urea"):"" %>" style="width:197px" />
<label >Ser. Creatinine</label> <input name="txtSerCreatinine" type="text"   value="<%=labResultMap.get("Sr.Creatinine")!=null?labResultMap.get("Sr.Creatinine"):"" %>" style="width:197px" />

<label >Cr. Clearance</label> <input name="txtCrClearance" type="text"  style="width:197px"  />
<label >S. Bilirubin</label> <input name="txtSBilirubin" type="text"   value="<%=labResultMap.get("S.Bilirubin")!=null?labResultMap.get("S.Bilirubin"):"" %>" style="width:197px" />
<label >Total Protein</label> <input name="txtTotalProtein" type="text"   value="<%=labResultMap.get("Total Protein")!=null?labResultMap.get("Total Protein"):"" %>" style="width:197px" />
<label >Albumin</label> <input name="txtAlbumin" type="text"   value="<%=labResultMap.get("Albumin")!=null?labResultMap.get("Albumin"):"" %>" style="width:197px" />
<label >Glob</label> <input name="txtGlob" type="text"   value="<%=labResultMap.get("Globulin")!=null?labResultMap.get("Globulin"):"" %>" style="width:197px" />
<label >Electrolytes</label> <input name="txtElectrolytes" type="text"   value="<%=labResultMap.get("Electrolytes")!=null?labResultMap.get("Electrolytes"):"" %>" style="width:197px" />
<label >Na</label> <input name="txtNa" type="text" maxlength="15"  value="<%=labResultMap.get("Na")!=null?labResultMap.get("Na"):"" %>" style="width:197px" />
<label >Potassium</label> <input name="txtPotassium" type="text"   value="<%=labResultMap.get("Potassium")!=null?labResultMap.get("Potassium"):"" %>" style="width:197px" />
<label >Ca</label> <input name="txtCa" type="text" maxlength="15"  value="<%=labResultMap.get("Ca")!=null?labResultMap.get("Ca"):"" %>" style="width:197px" />
<label >Magnesium</label> <input name="txtMagnesium" type="text"   value="<%=labResultMap.get("Magnesium")!=null?labResultMap.get("Magnesium"):"" %>" style="width:197px" />
<label >SGOT</label> <input name="txtSGOT" type="text"   value="<%=labResultMap.get("SGOT")!=null?labResultMap.get("SGOT"):"" %>" style="width:197px" />
<label >SGPT</label> <input name="txtSGPT" type="text"   value="<%=labResultMap.get("SGPT")!=null?labResultMap.get("SGPT"):"" %>" style="width:197px" />
<!-- <label >RBS</label> <input name="txtRBS" type="text" maxlength="15"  /> -->
<label >TFT</label> <input name="txtTFT" type="text"   value="<%=labResultMap.get("TFT")!=null?labResultMap.get("TFT"):"" %>" style="width:197px" />
<div class="clear"></div>
<label style="width:40px">Urine</label>
<label style="width:100px">Albumin</label> <input name="txtUrineAlbumin" type="text"  value="<%=labResultMap.get("Urine Albumin")!=null?labResultMap.get("Urine Albumin"):"" %>" style="width:197px"  />
<label >Sugar</label> <input name="txtUrineSugar" type="text"   value="<%=labResultMap.get("Urine Sugar")!=null?labResultMap.get("Urine Sugar"):"" %>" style="width:197px" />
<label >Deposits</label> <input name="txtUrineDeposits" type="text"   value="<%=labResultMap.get("Urine Deposits")!=null?labResultMap.get("Urine Deposits"):"" %>" style="width:197px" />

<div class="clear"></div>
<label>PFT</label>
<textarea name="txtAreaPFT" id="txtAreaPFT" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>MRI</label>
<textarea name="txtAreaMRI" id="txtAreaMRI" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>CT</label>
<textarea name="txtAreaCT" id="txtAreaCT" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>USG</label>
<textarea name="txtAreaUSG" id="txtAreaUSG" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>


<label>X-ray</label>
<label style="margin-left:0px">Chest</label> <input name="txtXrayChest" type="text"  style="width:197px" />
<label >Neck</label> <input name="txtXrayNeck" type="text"  style="width:197px" />

<div class="clear"></div>
<label>ECG</label>
<textarea name="txtAreaECG" id="txtAreaECG" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>Echo</label>
<textarea name="txtAreaEcho" id="txtAreaEcho" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>TMT</label>
<textarea name="txtAreaTMT" id="txtAreaTMT" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<div class="clear"></div>
<label>Others</label>
<textarea name="txtAreainvstResultsOthers" id="txtAreainvstResultsOthers" cols="0"  rows="0" class="large" style="width:940px;height:25px">	</textarea>
<div class="clear"></div>

<h4>Prescription Details</h4>
<div class="clear"></div>
<table style="width:95%;margin-left: 0px">
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



<%if(inpatientId==0){ %>

<h6 class="h4Tab">Refferal</h6>
<div class="clear"></div>

<div style="float: right;width: 261.991;width: 609px;">
    <%-- <input type="button" class="buttonBig" name="lastPrescription" value="Last Priscription" align="right" onclick="openWindow('/hms/hms/ipd?method=showPatientPrescriptionDetails&inPatientId=<%=inpatient.getId()%>&hinId=<%=patient.getId() %>&hinNo=<%=patient.getHinNo()%>&backFlag=ipd');"> --%>
	<input type="button" class="buttonAdd" value="" align="right" onclick="addRefferalRow();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="removeRefferalRow();">
</div>
<div class="clear"></div>
<div id="refferalDiv">
<table style="width:58%;margin-left: 0px;margin-right: 0px" id="multiRefferalTable">
<tr>
<th scope="col"></th>
<th scope="col">Service Center</th>
<th scope="col">Session</th>
</tr>

<tr>
<td>
<input type="checkbox"  id="itemRadio0" name="itemRadio" class="radioCheck">
</td>
<td>
<select id="serviceCenter0" name="serviceCenter" onchange="if(checkDuplicateServiceCenters(this.value,0)){getSessionForDepartment(this.value,0);}">
<option value="0">Select</option>
<%for(MasDepartment dept:departmentList){ if(Integer.parseInt(depart)!=dept.getId()){%>

<option value="<%=dept.getId()%>"><%=dept.getDepartmentName() %></option>
<%} }%>

</select>
</td>

<td>
<select id="opSession0" name="opSession">
<option value="0">Select</option>
</select>
</td>

</tr>

</table>

</div>

<%} %>


<div class="clear"></div>

<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="showCollapasbleTab('divMedicineInvestigations')" name="" value="+" type="button">
</div>
<div class="plusText"><h6 class="h4Tab">Prescription And Investigations</h6></div>
<div class="clear"></div>

<div id="divMedicineInvestigations" style="display:none">
<table style="border-left-width: 0px;">
<tr>
<td style="border-left:0px;border-right:0px;border-bottom:0px"><h4>Prescribe Medicine</h4></td>
<td style="border-left:0px;border-right:0px;border-bottom:0px">
<div style="float: right;width:204px" >
    <%-- <input type="button" class="buttonBig" name="lastPrescription" value="Last Priscription" align="right" onclick="openWindow('/hms/hms/ipd?method=showPatientPrescriptionDetails&inPatientId=<%=inpatient.getId()%>&hinId=<%=patient.getId() %>&hinNo=<%=patient.getHinNo()%>&backFlag=ipd');"> --%>
	<input type="button" class="buttonAdd" value="" align="right" onclick="addAACMedicineRow();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="removeRow();">
</div>
</td>
</tr>
</table>


<div class="clear"></div>
<div class="small" id="gridtreatmentDiv" style="width:95%;overflow: scroll;">
<div class="clear"></div>

<input  type="hidden" id="visitId" name="visitId" value="<%=visitId%>" />
<input  type="hidden" id="hinId" name="hinId" value="<%=hinId%>" />
<input  type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatientId%>" />
<input  type="hidden" id="surgeryId" name="surgeryId" value="<%=opdSurgeryId%>" />
<select style="display:none" id="diagnosisId" name="diagnosisId" > </select>
<input id="consultationDate" name="consultationDate" type="hidden" value="" />
<input type="hidden" id="acceptanceStatus" name="acceptanceStatus" value="y" />

<input type="checkbox"  class="radioCheckCol2" value="y" id="PharmacyqueueId" name="Pharmacyqueue" style="display:none" />
<div class="clear"></div>
<table id="prescriptionTabGrid" style="display:none"></table>
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
   <th scope="col">Block Medicine</th>
   <th scope="col">Block Days</th>
</tr>
	
	<%
	int l =0;
		
	%>

	
	<%-- <%l++;%> --%>
	<tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="itemRadio<%=l %>"  name="itemRadio<%=l %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="35" value="" tabindex="1" id="nomenclature<%=l %>"   class="textYellow largTextBoxOpd"
	    name="nomenclature<%=l %>" onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=l %>);
												 checkDrugToDiseaseCantra(this);
												 checkForAllergy(this.value,<%=l %>);populatePVMS(this.value,'<%=l%>');
												 checkItem('<%=l%>');
												  
												 ValidateCantra();displayAu(this.value,'<%=l%>');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=l %> )" onkeypress="checkTextColor('nomenclature<%=l%>');" />
		<input id="nomenclaturepTab" name="nomenclaturepTab" type="hidden"  />										 
		<input type="hidden" name="pvmsNo<%=l %>" id="pvmsNo<%=l %>"
											size="10" readonly="readonly" value=""/> 
																					 
	   	<div id="ac2updates<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=l %>','ac2updates<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature<%=l %>'});
			</script>
			
			<input type="hidden"
											name="actualDispensingQty<%=l%>"
											id="actualDispensingQty<%=l%>" size="6"
											validate="AU,string,no" />
											
											<input type="hidden"
											name="actualDispensingQtys<%=l%>"
											id="actualDispensingQtys<%=l%>" size="6"
											validate="AU,string,no" />
										
										
										<input type="hidden"
											name="mixables<%=l%>"
											id="mixables<%=l%>" 
											validate="mixables,string,no" />
											
										<input type="hidden"
											name="mixtureQuantity<%=l%>"
											id="mixtureQuantity<%=l%>" 
											validate="mixtureQuantity,int,no" />
											
										<input type="hidden"
											name="mixtureUnit<%=l%>"
											id="mixtureUnit<%=l%>" 	
											validate="mixtureUnit,string,no" />
										<input type="hidden"
											name="actualTotalAfterMixs<%=l%>"
											id="actualTotalAfterMixs<%=l%>" 
											validate="actualTotalAfterMixs,float,no" />
										<input type="hidden"
											name="tapered<%=l%>"
											id="tapered<%=l%>" 
											validate="tapered,string,no" />
	    </td>
	    <td><select name="route<%=l %>" id="route<%=l %>" class="textYellow opdTextBoxTSmall" tabindex="1" style="width: 90px" >
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
		
		<select id="routepTab" name="routepTab" style="display:none"></select>
		
		</td>
		<td>
		
		<input type="text" name="dosage<%=l %>" tabindex="1" value="" id="dosage<%=l %>" class="textYellow opdTextBoxTSmall" size="5" maxlength="5" onblur="fillValue(this.value,<%=l%>);checkFrequencyForTaperedDrugs(<%=l%>)" />
		<input type="hidden" name="dosagepTab<%=l %>" id="dosagepTab<%=l %>" />
		</td>
		<td><input type="text" size="5" name="unit<%=l %>" readonly="readonly" id="unit<%=l %>" value="" class="textYellow opdTextBoxTSmall" />
		<input type="hidden" id="unitpTab" name="unitpTab" />
		
		</td>
		
		
		<td>
		<input type="hidden" name="frequencyValue<%=l%>" tabindex="1" id="frequencyValue<%=l%>" value=""  size="6"   />
		<input type="text" name="sosQty<%=l%>" tabindex="1" id="sosQty<%=l%>" style="display: none;"   size="3" onblur="fillValue(this.value,<%=l%>)"	maxlength="3" validate="Sos Qty,num,no" />
		<select name="frequency<%=l %>" id="frequency<%=l %>"  tabindex="1" class="textYellow opdTextBoxTSmall"
		 onchange="getFrequencyValue(this.value,<%=l%>);fillValue(this.value,<%=l%>);displaySOSQty(this.value,<%=l%>);displaFrequencyType(this,<%=l%>);checkFrequencyForTaperedDrugs(<%=l%>)" style="width: 90px">
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
		<input type="hidden" name="frequencyValuepTab<%=l %>" id="frequencyValuepTab<%=l %>" />
		<input type="hidden" name="actualDispensingQtypTab<%=l %>" id="actualDispensingQtypTab<%=l %>" />
		<input type="hidden" name="sosQtypTab<%=l %>" id="sosQtypTab<%=l %>" />
		<input type="hidden" name="frequencypTab<%=l %>" id="frequencypTab<%=l %>" />
		</td>
		
<%--		<td><input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" /> //commented by govind 24-12-2016--%>
		<td>
		<div style="width:100px; float: left;">
		<input type="text"  name="noOfDays<%=l %>" tabindex="1" id="noOfDays<%=l %>" value="" onblur="fillValueDays(<%=l%>);fillValue(this.value,<%=l%>);"  size="5" class="textYellow opdTextBoxTSmall" maxlength="3" validate="No. of Days,num,no" />
		<input type="hidden" name="noOfDayspTab<%=l %>" id="noOfDayspTab<%=l %>" />
		<p style="line-height:0px;" id="frequencyType<%=l %>" ></p>
		</div>			
		</td>
		
		<td><select name="instrunction<%=l %>" id="instrunction<%=l %>" class="textYellow opdTextBoxTSmall" tabindex="1" style="width: 90px">
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
		
		<td><input type="text" name="splInstrunction<%=l %>" tabindex="1" id="splInstrunction<%=l %>" value=""  size="15"	maxlength="50" class="textYellow opdTextBoxTSmall" style="width:180px" />
			
		</td>
		
		
		
		<td><input type="text"  name="total<%=l %>" tabindex="1" id="total<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>')"  size="5"	class="textYellow opdTextBoxTSmall" maxlength="3" validate="Total,num,no" readonly="readonly" />
			<input type="hidden" id="totalpTab<%=l %>" name="totalpTab<%=l %>"  />
		</td>
		<td>
			<input type="text" id="unitLable<%=l%>" value="" 	class="textYellow opdTextBoxTSmall" readonly="readonly" />
		</td>
		
		<td>
		<input type="checkbox" id="blockMedicine<%=l%>" name="blockMedicine<%=l%>" onchange="javascript:blockMedicine(this,<%=l%>);chkBlockMedicine(<%=l%>)" style="margin-left: 11px"/>
		</td>
		<td>
		<input type="text" id="blockDays<%=l%>" name="blockDays<%=l%>" class="textYellow opdTextBoxTSmall" readonly="readonly" maxlength="2" onkeypress="return isNumber(event);"/>
		</td>
		
	</tr>	
	
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdb" />
	<input type="hidden" name="hdbTabIndex"
									id="hdbTabIndex" value="" id="hdbRecordSize" />
	<input type="hidden" name="pTabhdb" id="pTabhdb" />


</div>

<div class="clear"></div>
<table style="border-left-width: 0px;">
<tr>
<td style="border-left:0px;border-right:0px;border-bottom:0px"><h4>Request Investigation</h4></td>
<td style="border-left:0px;border-right:0px;border-bottom:0px">
<div class="floatRight" style="padding-right: 80px">
 <input type="button"
class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForInvestigation();" />
<input type="button" class="buttonDel" alt="Delete" value="&nbsp;"
onclick="removeRowForInvestigation();" />
</div>
</td>
</tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" style="border-top:0px;border-bottom:0px;border-left:0px;border-right:0px;margin-right: 0px;margin-left: 0px">
						<tr>
							<td style="border-top:0px;border-bottom:0px;border-left:0px;border-right:0px">
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
							<td style="border-top:0px;border-bottom:0px;border-left:0px;border-right:0px">
								<div class="tableForTab" style="width:94%; height:120px;"	id="labInvDiv">
									<div id="divTemplet1">
										<table border="0" align="center" cellpadding="0"
											cellspacing="0" id="investigationGrid">
											<tr>
												<th scope="col">&nbsp;</th>
												<th scope="col">Test Name</th>
												<th scope="col">SNOMED Concepts</th>
												<th scope="col">Clinical Notes</th>
											</tr>
		<%int inc=0;
		int	len=2;
		
			for(;inc<len;inc++){
				
			%>
											<tr>
												<td>
													
													<input type="checkbox" class="radioCheck"
													name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" />
													<input type="hidden" name="parkInvestigationId<%=inc %>"
													id="parkInvestigationId<%=inc %>"
													value="" />
													<input type="hidden" name="availableStatus<%=inc %>"
													id="availableStatus<%=inc %>" value="" />
												</td>
												<td>
													 <input type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="" id="chargeCodeName<%=inc %>"
													size="65" name="chargeCodeName<%=inc %>"
													onkeypress="checkTextColor('chargeCodeName<%=inc%>');"
													onblur="getUnavailableInvestigation(<%=inc %>);checkInvestigationItem(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=hinId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													

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
													
													<input type="text" name="clinicalNotes<%=inc %>"
													value=""
													class="opdTextBoxSmall textYellow"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" /> 
												</td>
											</tr>
											
<%} %>
										
										</table>
										
									</div>
									<input type="hidden" name="hiddenValue" id="hiddenValue"
										value="<%=inc-1%>" /> <input type="hidden" name="toDate"
										id="todate" value="" /> 
										<%-- <input type="hidden"
										name="dhHeaderIds" id="dhHeaderIds"
										value="<%=dtHids%>-<%=pInvHd%>-<%=dgSampleHdId%>" /> --%>
								</div>
							</td>
						</tr>
					</table>
					

</div>



<div class="clear"></div>
<h4>Acceptance</h4>
<div class="clear"></div>

<label>Accepted</label>
<input type="radio" name="rdAcceptance" id="rdAccepted" checked="checked" onchange="checkAcceptance('rdAccepted')" />

<label>Not Accepted</label>
<input type="radio" name="rdAcceptance" id="rdNotAccepted" onchange="checkAcceptance('rdNotAccepted')" />
<div class="clear"></div>

<div id="notAcceptedDiv" style="display:none">
<table style="width:95%;margin-left: 0px">
<th colspan="3">Not Accepted</th>

<tr>
<td rowspan="3">At Present Dated</td>
<td>Remarks</td>
<td>
<input type="text" id="txtNotAcceptedRemarks" name="txtNotAcceptedRemarks" size="80" />
</td>
</tr>

<tr>
<td>Consultations</td>
<td>
<input type="text" id="txtConsultations" name="txtConsultations" size="80" /> 
</td>
</tr>

<tr>
<td>Further Investigations Needed</td>
<td>
<input type="text" id="txtFurtherInvestigations" name="txtFurtherInvestigations" size="80" />
</td>
</tr>

</table>
</div>

<div id="AcceptedDiv">

<table style="width:95%;margin-left: 0px">

<col width="10%">
<col width="40%">
<col width="42%">

<th colspan="3">Accepted</th>

<tr>
<td rowspan="5">Grading</td>
<td>ASA PS</td>
<td>
<input type="text" id="txtGradingASAPS" name="txtGradingASAPS" size="80" />
</td>
</tr>

<tr>
<td>Goldman</td>
<td>
<input type="text" id="txtGradingGoldman" name="txtGradingGoldman" size="80" />
</td>
</tr>

<tr>
<td>Pugh</td>
<td>
<input type="text" id="txtGradingPugh" name="txtGradingPugh" size="80" />
</td>
</tr>

<tr>
<td>Child</td>
<td>
<input type="text" id="txtGradingChild" name="txtGradingChild" size="80" />
</td>
</tr>

<tr>
<td>Detsky</td>
<td>
<input type="text" id="txtGradingDetsky" name="txtGradingDetsky" size="80" />
</td>
</tr>

<tr>
<td rowspan="12">Instructions</td>
<td>Nil Per Oral</td>
<td>
<input type="text" id="txtInstructionsNilOral" name="txtInstructionsNilOral" size="80" />
</td>
</tr>

<tr>
<td>Informed Consent</td>
<td>
<input type="text" id="txtInstructionsinformedConsent" name="txtInstructionsinformedConsent" size="80" />
</td>
</tr>

<tr>
<td>Medicines To Be Taken On Previous Day</td>
<td>
<input type="text" id="txtPreviousDayMedicines" name="txtPreviousDayMedicines" size="80" />
</td>
</tr>

<tr>
<td>Night Sadation 10 PM</td>
<td>
<input type="text" id="txtNightSadation" name="txtNightSadation" size="80" />
</td>
</tr>

<tr>
<td>Medicines To Be Taken With a Sip Of Water At 6 AM On The Day Of Surgery</td>
<td>
<input type="text" id="txt6amMedicines" id="txt6amMedicines" size="80" />
</td>
</tr>

<tr>
<td>Continue All Cardiac Drugs</td>
<td>
<input type="text" id="txtContinueCardiacDrugs" name="txtContinueCardiacDrugs" size="80" />
</td>
</tr>

<tr>
<td>Further Advices Before Surgery</td>
<td>
<input type="text" id="txtFurtherAdvices" name="txtFurtherAdvices" size="80" />
</td>
</tr>

<tr>
<td>Investigations To Be Done On The Day Of Surgery</td>
<td>
<input type="text" id="txtInvestigationB4Surgery" name="txtInvestigationB4Surgery" size="80" />
</td>
</tr>

<tr>
<td>Infective Endocarditis - Prophylaxis</td>
<td>
<input type="text" id="txtInfectiveEndocarditis" name="txtInfectiveEndocarditis" size="80" />
</td>
</tr>

<tr>
<td>Remove Artificial Dentures, Contact Lens, Ornaments</td>
<td>
<input type="text" id="txtRemoveArtificialDentures" name="txtRemoveArtificialDentures" size="80" />
</td>
</tr>

<tr>
<td>Premedications</td>
<td>
<input type="text" id="txtPremedications" name="txtPremedications" size="80" />
</td>
</tr>

<tr>
<td>Others</td>
<td>
<input type="text" id="txtAcceptedOthers" name="txtAcceptedOthers" size="80" />
</td>
</tr>

</table>

</div>

<div class="clear"></div>
<input type="submit" name="SubmitAac" value="Submit" tabindex="1" class="button" />
</form>

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
    
    <script type="text/javascript">	var	routeArray= new Array();
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
  <script type="text/javascript">
  var icdArray=new Array();
</script>
  <%
				  MasFrequency masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
	     		  
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
		          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
	            </script> <% }%>          

<script type="text/javascript">
function showCollapasbleTab(val){
	if(val=='divMedicineInvestigations'){
		var div = document.getElementById("divMedicineInvestigations");
		if (div.style.display !== "block") {
		   div.style.display = "block";
		}else {
		   div.style.display = "none";
		}
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
	if(document.getElementById('frequencyValue' + inc)!=null){
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	 if(document.getElementById('frequencyValuepTab' + inc)!=null){
	 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
	 }
}

function historyDetails(val){
	if(val=="Allergy"){
		if(document.getElementById("chkAllergy").checked){
			document.getElementById("txtAllergy").disabled=false;
			
		}else{
			document.getElementById("txtAllergy").disabled=true;
		}
		
	}else if(val=="Diabetes"){
		if(document.getElementById("chkDiabetes").checked){
			document.getElementById("txtDiabetes").disabled=false;
			
		}else{
			document.getElementById("txtDiabetes").disabled=true;
		}
		
	}else if(val=="Psychiatric illness"){
		if(document.getElementById("chkPsychiatric").checked){
			document.getElementById("txtPsychiatric").disabled=false;
			
		}else{
			document.getElementById("txtPsychiatric").disabled=true;
		}
		
	}else if(val=="Menstruation"){
		if(document.getElementById("chkMenstruation").checked){
			document.getElementById("txtMenstruation").disabled=false;
			
		}else{
			document.getElementById("txtMenstruation").disabled=true;
		}
		
	}else if(val=="Asthma"){
		if(document.getElementById("chkAsthma").checked){
			document.getElementById("txtAsthma").disabled=false;
			
		}else{
			document.getElementById("txtAsthma").disabled=true;
		}
		
	}else if(val=="Epilepsy"){
		if(document.getElementById("chkEpilepsy").checked){
			document.getElementById("txtEpilepsy").disabled=false;
			
		}else{
			document.getElementById("txtEpilepsy").disabled=true;
		}
		
	}else if(val=="Tuberculosis"){
		if(document.getElementById("chkTuberculosis").checked){
			document.getElementById("txtTuberculosis").disabled=false;
			
		}else{
			document.getElementById("txtTuberculosis").disabled=true;
		}
		
	}else if(val=="Child Birth"){
		if(document.getElementById("chkChildBirth").checked){
			document.getElementById("txtChildBirth").disabled=false;
			
		}else{
			document.getElementById("txtChildBirth").disabled=true;
		}
		
	}else if(val=="Chest Pain"){
		if(document.getElementById("chkChestPain").checked){
			document.getElementById("txtChestPain").disabled=false;
			
		}else{
			document.getElementById("txtChestPain").disabled=true;
		}
		
	}else if(val=="Exercise Intolerance"){
		if(document.getElementById("chkExercise").checked){
			document.getElementById("txtExercise").disabled=false;
			
		}else{
			document.getElementById("txtExercise").disabled=true;
		}
		
	}else if(val=="Previous Surgeries"){
		if(document.getElementById("chkPreviousSurgeries").checked){
			document.getElementById("txtPreviousSurgeries").disabled=false;
			
		}else{
			document.getElementById("txtPreviousSurgeries").disabled=true;
		}
		
	}else if(val=="Smoking"){
		if(document.getElementById("chkSmoking").checked){
			document.getElementById("txtSmoking").disabled=false;
			
		}else{
			document.getElementById("txtSmoking").disabled=true;
		}
		
	}else if(val=="Cough"){
		if(document.getElementById("chkCough").checked){
			document.getElementById("txtCough").disabled=false;
			
		}else{
			document.getElementById("txtCough").disabled=true;
		}
		
	}else if(val=="Hypertension"){
		if(document.getElementById("chkHypertension").checked){
			document.getElementById("txtHypertension").disabled=false;
			
		}else{
			document.getElementById("txtHypertension").disabled=true;
		}
		
	}else if(val=="Previous Anesthetic Exposures"){
		if(document.getElementById("chkAnestheticExposures").checked){
			document.getElementById("txtAnestheticExposures").disabled=false;
			
		}else{
			document.getElementById("txtAnestheticExposures").disabled=true;
		}
		
	}else if(val=="Alcoholism"){
		if(document.getElementById("chkAlcoholism").checked){
			document.getElementById("txtAlcoholism").disabled=false;
			
		}else{
			document.getElementById("txtAlcoholism").disabled=true;
		}
		
	}else if(val=="Dyspnoea"){
		if(document.getElementById("chkDyspnoea").checked){
			document.getElementById("txtDyspnoea").disabled=false;
			
		}else{
			document.getElementById("txtDyspnoea").disabled=true;
		}
		
	}else if(val=="Heart Disease"){
		if(document.getElementById("chkHeartDisease").checked){
			document.getElementById("txtHeartDisease").disabled=false;
			
		}else{
			document.getElementById("txtHeartDisease").disabled=true;
		}
		
	}else if(val=="General Anesthesia"){
		if(document.getElementById("chkGeneralAnesthesia").checked){
			document.getElementById("txtGeneralAnesthesia").disabled=false;
			
		}else{
			document.getElementById("txtGeneralAnesthesia").disabled=true;
		}
		
	}else if(val=="Dentures"){
		if(document.getElementById("chkDentures").checked){
			document.getElementById("txtDentures").disabled=false;
			
		}else{
			document.getElementById("txtDentures").disabled=true;
		}
		
	}else if(val=="Dysphagia"){
		if(document.getElementById("chkDysphagia").checked){
			document.getElementById("txtDysphagia").disabled=false;
			
		}else{
			document.getElementById("txtDysphagia").disabled=true;
		}
		
	}else if(val=="Hoarseness"){
		if(document.getElementById("chkHoarseness").checked){
			document.getElementById("txtHoarseness").disabled=false;
			
		}else{
			document.getElementById("txtHoarseness").disabled=true;
		}
		
	}else if(val=="Spinal Anesthesia"){
		if(document.getElementById("chkSpinalAnesthesia").checked){
			document.getElementById("txtSpinalAnesthesia").disabled=false;
			
		}else{
			document.getElementById("txtSpinalAnesthesia").disabled=true;
		}
		
	}else if(val=="Contact Lens"){
		if(document.getElementById("chkContactLens").checked){
			document.getElementById("txtContactLens").disabled=false;
			
		}else{
			document.getElementById("txtContactLens").disabled=true;
		}
		
	}else if(val=="Dyspepsia"){
		if(document.getElementById("chkDyspepsia").checked){
			document.getElementById("txtDyspepsia").disabled=false;
			
		}else{
			document.getElementById("txtDyspepsia").disabled=true;
		}
		
	}else if(val=="IHD"){
		if(document.getElementById("chkIHD").checked){
			document.getElementById("txtIHD").disabled=false;
			
		}else{
			document.getElementById("txtIHD").disabled=true;
		}
		
	}else if(val=="Complications"){
		if(document.getElementById("chkComplications").checked){
			document.getElementById("txtComplications").disabled=false;
			
		}else{
			document.getElementById("txtComplications").disabled=true;
		}
		
	}else if(val=="Hearing Aids"){
		if(document.getElementById("chkHearingAids").checked){
			document.getElementById("txtHearingAids").disabled=false;
			
		}else{
			document.getElementById("txtHearingAids").disabled=true;
		}
		
	}else if(val=="Acid Peptic Disorders"){
		if(document.getElementById("chkAcidPepticDisorders").checked){
			document.getElementById("txtAcidPepticDisorders").disabled=false;
			
		}else{
			document.getElementById("txtAcidPepticDisorders").disabled=true;
		}
		
	}else if(val=="Jaundice"){
		if(document.getElementById("chkJaundice").checked){
			document.getElementById("txtJaundice").disabled=false;
			
		}else{
			document.getElementById("txtJaundice").disabled=true;
		}
		
	}else if(val=="PONV"){
		if(document.getElementById("chkPONV").checked){
			document.getElementById("txtPONV").disabled=false;
			
		}else{
			document.getElementById("txtPONV").disabled=true;
		}
		
	}
	
}

function drugDetails(val){
	if(val=="Antiallegeric"){
		if(document.getElementById("chkAntiallegeric").checked){
			document.getElementById("txtAntiallegeric").disabled=false;
			
		}else{
			document.getElementById("txtAntiallegeric").value="";
			document.getElementById("txtAntiallegeric").disabled=true;
		}
		
	}else if(val=="CEBs"){
		if(document.getElementById("chkCEBs").checked){
			document.getElementById("txtCEBs").disabled=false;
			
		}else{
			document.getElementById("txtCEBs").value="";
			document.getElementById("txtCEBs").disabled=true;
		}
		
	}else if(val=="Antiplatelets"){
		if(document.getElementById("chkAntiplatelets").checked){
			document.getElementById("txtAntiplatelets").disabled=false;
			
		}else{
			document.getElementById("txtAntiplatelets").value="";
			document.getElementById("txtAntiplatelets").disabled=true;
		}
		
	}else if(val=="Antihypertensives"){
		if(document.getElementById("chkAntihypertensives").checked){
			document.getElementById("txtAntihypertensives").disabled=false;
			
		}else{
			document.getElementById("txtAntihypertensives").value="";
			document.getElementById("txtAntihypertensives").disabled=true;
		}
		
	}else if(val=="Antianginals"){
		if(document.getElementById("chkAntianginals").checked){
			document.getElementById("txtAntianginals").disabled=false;
			
		}else{
			document.getElementById("txtAntianginals").value="";
			document.getElementById("txtAntianginals").disabled=true;
		}
		
	}else if(val=="Antituberculous"){
		if(document.getElementById("chkAntituberculous").checked){
			document.getElementById("txtAntituberculous").disabled=false;
			
		}else{
			document.getElementById("txtAntituberculous").value="";
			document.getElementById("txtAntituberculous").disabled=true;
		}
		
	}else if(val=="Antiasthmatics"){
		if(document.getElementById("chkAntiasthmatics").checked){
			document.getElementById("txtAntiasthmatics").disabled=false;
			
		}else{
			document.getElementById("txtAntiasthmatics").value="";
			document.getElementById("txtAntiasthmatics").disabled=true;
		}
		
	}else if(val=="Antidiabetics"){
		if(document.getElementById("chkAntidiabetics").checked){
			document.getElementById("txtAntidiabetics").disabled=false;
			
		}else{
			document.getElementById("txtAntidiabetics").value="";
			document.getElementById("txtAntidiabetics").disabled=true;
		}
		
	}else if(val=="Antimalignancy"){
		if(document.getElementById("chkAntimalignancy").checked){
			document.getElementById("txtAntimalignancy").disabled=false;
			
		}else{
			document.getElementById("txtAntimalignancy").value="";
			document.getElementById("txtAntimalignancy").disabled=true;
		}
		
	}else if(val=="Diuretics"){
		if(document.getElementById("chkDiuretics").checked){
			document.getElementById("txtDiuretics").disabled=false;
			
		}else{
			document.getElementById("txtDiuretics").value="";
			document.getElementById("txtDiuretics").disabled=true;
		}
		
	}else if(val=="Antiepileptics"){
		if(document.getElementById("chkAntiepileptics").checked){
			document.getElementById("txtAntiepileptics").disabled=false;
			
		}else{
			document.getElementById("txtAntiepileptics").value="";
			document.getElementById("txtAntiepileptics").disabled=true;
		}
		
	}else if(val=="Antithyroid"){
		if(document.getElementById("chkAntithyroid").checked){
			document.getElementById("txtAntithyroid").disabled=false;
			
		}else{
			document.getElementById("txtAntithyroid").value="";
			document.getElementById("txtAntithyroid").disabled=true;
		}
		
	}else if(val=="Digoxin"){
		if(document.getElementById("chkDigoxin").checked){
			document.getElementById("txtDigoxin").disabled=false;
			
		}else{
			document.getElementById("txtDigoxin").value="";
			document.getElementById("txtDigoxin").disabled=true;
		}
		
	}else if(val=="Antipsychotics"){
		if(document.getElementById("chkAntipsychotics").checked){
			document.getElementById("txtAntipsychotics").disabled=false;
			
		}else{
			document.getElementById("txtAntipsychotics").value="";
			document.getElementById("txtAntipsychotics").disabled=true;
		}
		
	}else if(val=="Antacid"){
		if(document.getElementById("chkAntacid").checked){
			document.getElementById("txtAntacid").disabled=false;
			
		}else{
			document.getElementById("txtAntacid").value="";
			document.getElementById("txtAntacid").disabled=true;
		}
		
	}else if(val=="Beta Blockers"){
		if(document.getElementById("chkBetaBlockers").checked){
			document.getElementById("txtBetaBlockers").disabled=false;
			
		}else{
			document.getElementById("txtBetaBlockers").value="";
			document.getElementById("txtBetaBlockers").disabled=true;
		}
		
	}else if(val=="Steroids"){
		if(document.getElementById("chkSteroids").checked){
			document.getElementById("txtSteroids").disabled=false;
			
		}else{
			document.getElementById("txtSteroids").value="";
			document.getElementById("txtSteroids").disabled=true;
		}
		
	}else if(val=="H2 Blockers"){
		if(document.getElementById("chkH2Blockers").checked){
			document.getElementById("txtH2Blockers").disabled=false;
			
		}else{
			document.getElementById("txtH2Blockers").value="";
			document.getElementById("txtH2Blockers").disabled=true;
		}
		
	}
}

function getSessionForDepartment(deptId,rowNum){
	  if(deptId!="0"){
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange=function() {
			  
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	var data=this.responseText;
		    	var dt=data.toString();
				var result = dt.slice(1, -1);
				var deptData="";
				if(result!=""){
					deptData=result.split(",");
				}else{
					alert("Session not Available for Selected Service Center !");
					document.getElementById("serviceCenter"+rowNum).selectedIndex=0;
				}
				
				document.getElementById('opSession'+rowNum).options.length = 0;
				var select = document.getElementById('opSession'+rowNum);
				for(var index=0;index<deptData.length;index++){
					var departmentData=deptData[index].split(":");
					var opt = document.createElement('option');
					opt.value = departmentData[0].trim();
					opt.innerHTML = departmentData[1].trim();
				    select.appendChild(opt);
					
				}
		    }
		  }; 
		  xhttp.open("GET", "/hms/hms/registration?method=getSessionForDepartment&deptId="+deptId,true);
		  xhttp.send();
	  }
	  
}

function addRefferalRow(){
	var tbl = document.getElementById('multiRefferalTable');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
	var row = tbl.insertRow(lastRow);
	
	var radioCheckCell=row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	radioCheckCell.appendChild(e1);
	
	var serviceCenterCell = row.insertCell(1);
	var e2 = document.createElement('Select');
	e2.name = 'serviceCenter';
	e2.id = 'serviceCenter' + iteration;
	var i=0;
	e2.options[i] = new Option('Select', '0');
	<%for(MasDepartment dept:departmentList){%>
	i++;
	e2.options[i] = new Option('<%=dept.getDepartmentName()%>', '<%=dept.getId()%>');
	
	<%}%>
	e2.onchange = function() { 
		
		if(checkDuplicateServiceCenters(this.value,iteration)){
			getSessionForDepartment(this.value, iteration);
		}
	};
	serviceCenterCell.appendChild(e2);
	
	var sessionCell = row.insertCell(2);
	var e3 = document.createElement('Select');
	e3.name = 'opSession';
	e3.id = 'opSession' + iteration;
	e3.options[0] = new Option('Select', '0');
	sessionCell.appendChild(e3);
	
}
function removeRefferalRow(){
	var tbl = document.getElementById('multiRefferalTable');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
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
			alert('Please select atleast 1 row to delete');
		}
		
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadio" + i) != null
					&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
					&& document.getElementById("itemRadio" + i).checked) {
			
				var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
				document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
	
}

function checkDuplicateServiceCenters(val,rowNum){
	var tbl = document.getElementById('multiRefferalTable');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
	
	for(var i = 1; i <= iteration; i++){
		
		if(i!=rowNum+1){
			
			var serviceCenter=tbl.rows[i].cells[1].children[0].value;
			if(serviceCenter!="0"&&val==serviceCenter){
				alert("This Service Center is Already Selected !");
				document.getElementById('serviceCenter'+rowNum).selectedIndex=0;
				document.getElementById('opSession'+rowNum).options.length=0;
				return false;
				
			}
			
		}
		
	}
	return true;
	
}

function chkBlockMedicine(increment){
	if(document.getElementById("blockMedicine"+increment).checked){
		document.getElementById("blockMedicine"+increment).value="y";
	}else{
		document.getElementById("blockMedicine"+increment).value="n";
	}
	
}

function checkAcceptance(val){
	if(val=="rdAccepted"){
		document.getElementById("AcceptedDiv").style.display="block";
		document.getElementById("notAcceptedDiv").style.display="none";
		
		document.getElementById("txtNotAcceptedRemarks").value="";
		document.getElementById("txtConsultations").value="";
		document.getElementById("txtFurtherInvestigations").value="";
		document.getElementById("acceptanceStatus").value="y";
		
	}else if(val=="rdNotAccepted"){
		document.getElementById("AcceptedDiv").style.display="none";
		document.getElementById("notAcceptedDiv").style.display="block";
		
		document.getElementById("txtGradingASAPS").value="";
		document.getElementById("txtGradingGoldman").value="";
		document.getElementById("txtGradingPugh").value="";
		document.getElementById("txtGradingChild").value="";
		document.getElementById("txtGradingDetsky").value="";
		document.getElementById("txtInstructionsNilOral").value="";
		document.getElementById("txtInstructionsinformedConsent").value="";
		document.getElementById("txtPreviousDayMedicines").value="";
		document.getElementById("txtNightSadation").value="";
		document.getElementById("txt6amMedicines").value="";
		document.getElementById("txtContinueCardiacDrugs").value="";
		document.getElementById("txtFurtherAdvices").value="";
		document.getElementById("txtInvestigationB4Surgery").value="";
		document.getElementById("txtInfectiveEndocarditis").value="";
		document.getElementById("txtRemoveArtificialDentures").value="";
		document.getElementById("txtPremedications").value="";
		document.getElementById("txtAcceptedOthers").value="";
		document.getElementById("acceptanceStatus").value="n";
	}
}

</script>