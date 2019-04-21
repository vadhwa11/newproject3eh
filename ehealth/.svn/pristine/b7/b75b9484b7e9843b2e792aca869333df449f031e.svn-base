<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>



<%

		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}

		List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
		if(map.get("masMaritalStatusList") != null)
		{
			masMaritalStatusList=(List<MasMaritalStatus>)map.get("masMaritalStatusList");
		}
		%>

<div class="titleBg"><h2>Oral and Maxillofacial Surgery</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="oralAndMaxillofacialSurgeryFlag" name="oralAndMaxillofacialSurgeryFlag" tabindex="1" value="oralAndMaxillofacialSurgeryFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Oral and Maxillofacial Surgery"/>
<label>Marital Status</label>



	<select name="masMaritalStatusId" id="masMaritalStatusId"  class="-smallest"  tabindex="1"  validate="marrital status,string,yes">
								<option value="0">Select</option>
								<%for(MasMaritalStatus masMaritalStatus:masMaritalStatusList){ %>
								<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName() %></option>
								<%} %>
							</select>


<label>Date Of Reporting</label>
<input type="text" name="dateOfReporting" id="dateOfReporting" maxlength="10" tabindex="1" class="date">
<div id="dobcalId">
<img id="calImageId" src="/hms/jsp/images/cal.gif" onclick="setdate('05/06/2017',document.getElementById('dateOfReporting'),event)" width="16" border="0" height="">
</div>
<div class="clear"></div>

<label>Date of Operation</label>
<input type="text" name="dateOfOperation" id="dateOfOperation" maxlength="10" tabindex="1" class="date">
<div id="dobcalId">
<img id="calImageId" src="/hms/jsp/images/cal.gif" onclick="setdate('05/06/2017',document.getElementById('dateOfOperation'),event)" width="16" border="0" height="">
</div>

<label>Date of Discharge</label>
<input type="text" name="dateOfDischarge" id="dateOfDischarge" maxlength="10" tabindex="1" class="date">
<div id="dobcalId">
<img id="calImageId" src="/hms/jsp/images/cal.gif" onclick="setdate('05/06/2017',document.getElementById('dateOfDischarge'),event)" width="16" border="0" height="">
</div>
<div class="clear"></div>

<label>Chief Complaint</label>
<input type="text" name="chiefComplaint" id="chiefComplaint" maxlength="128" tabindex="1">
<label>H/O Presenting Complaints</label>
<input type="text" name="hOPresentingComplaints" id="hOPresentingComplaints" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Past Medical History</label>
<select id="pastMedicalHistory" name="pastMedicalHistory" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Allergy">Allergy</option>
<option value="Diabetes">Diabetes</option>
<option value="Hypertension">Hypertension</option>
<option value="Cardiac">Cardiac</option>
<option value="Others">Others</option>
</select>
<input type="text" name="pastMedicalHistoryValue" id="pastMedicalHistoryValue" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Past Dental History</label>
<select id="pastDentalHistory" name="pastDentalHistory" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Extraction">Extraction</option>
<option value="Ortho Treatment">Ortho Treatment</option>
<option value="Conservative Treatment">Conservative Treatment</option>
<option value="Others">Others</option>
</select>
<input type="text" name="pastDentalHistoryValue" id="pastDentalHistoryValue" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Family History</label>
<input type="text" name="familyHistoryOne" id="familyHistoryOne" maxlength="128" tabindex="1">
<label>Personal History</label>
<input type="text" name="personalHistoryOne" id="personalHistoryOne" maxlength="128" tabindex="1">
<div class="clear"></div>
<label>Habits</label>
<select id="habbits" name="habbits" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Chewing">Chewing</option>
<option value="Smoking">Smoking</option>
<option value="Alcoholism">Alcoholism</option>
</select>
<input type="text" name="habbitsValue" id="habbitsValue" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Females</label>
<select id="females" name="females" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Menstrual History">Menstrual History</option>
<option value="Pregnancy">Pregnancy</option>
<option value="Lactation">Lactation</option>
<option value="Abortion">Abortion</option>
</select>
<input type="text" name="femalesValue" id="femalesValue" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Examination</h4>
<div class="clear"></div>
<h4>General</h4>
<div class="clear"></div>

<label>Built</label>
<select name="built" id="built" tabindex="1" class="-smallest">
<option value="">Select</option>
<option value="Ill Built">Ill Built</option>
<option value="Moderately Built">Moderately Built</option>
<option value="Moderately Built">Obese</option>
</select>

<label>Gait</label>
<label class="auto">Normal</label>
<input tabindex="1" name="gait" id="" value="Normal" type="radio" class="radiobutMargin">
<label class="auto">Altered</label>
<input tabindex="1" name="gait" id="" value="Altered" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Nourishment</label>
<label class="auto">Well Nurished</label>
<input tabindex="1" name="nourishment" id="" value="Well Nurished" type="radio" class="radiobutMargin">
<label class="auto">Ill Nurished</label>
<input tabindex="1" name="nourishment" id="" value="Ill Nurished" type="radio" style="margin-right:21px;">
<div class="clear"></div>
<div class="clear"></div>

<h4>VITAL SIGNS</h4>
<div class="clear"></div>
<h4>Pulse</h4>
<div class="clear"></div>

<label>Rate</label>
<input id="rate" name="rate" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">PER MINUTE</label>

<label class="auto">Tachy Cardia</label>
<input tabindex="1" name="rateValue" id="" value="Tachy Cardia" type="radio" class="radiobutMargin">
<label class="auto">Brady Cardia</label>
<input tabindex="1" name="rateValue" id="" value="Brady Cardia" type="radio" style="margin-right:50px;">
<div class="clear"></div>

<label>Rhythm</label>
<label class="auto">Regular</label>
<input tabindex="1" name="rhythm" id="" value="Regular" type="radio" class="radiobutMargin">
<label class="auto">Irregular</label>
<input tabindex="1" name="rhythm" id="" value="Irregular" type="radio" style="margin-right:21px;">

<label>Volume</label>
<label class="auto">Regular</label>
<input tabindex="1" name="volume" id="" value="Regular" type="radio" class="radiobutMargin">
<label class="auto">Irregular</label>
<input tabindex="1" name="volume" id="" value="Irregular" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Temperature</label>
<input id="temperature" name="temperature" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">farenheit</label>
<select name="temperatureValue" id="temperatureValue" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Hypothermia">Hypothermia</option>
<option value="Normal">Normal</option>
<option value="Hyperthermia">Hyperthermia</option>
</select>
<div class="clear"></div>

<label>Respiratory Rate</label>
<input id="resoiratoryRate" name="resoiratoryRate" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">PER MINUTE</label>
<div class="clear"></div>

<label>Blood Pressure</label>
<input type="text" name="bloodPressure" id="bloodPressure" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" maxlength="128" tabindex="1">
<label class="auto">Systolic</label>
<input tabindex="1" name="bloodPressureValue" id="" value="Systolic" type="radio" class="radiobutMargin">
<label class="auto">Diastolic</label>
<input tabindex="1" name="bloodPressureValue" id="" value="Diastolic" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>PICCLE</h4>
<div class="clear"></div>

<label>Pallor</label>
<label class="auto">Present</label>
<input tabindex="1" name="pallor" id="" value="Present" type="radio" class="radiobutMargin" >
<label class="auto">Absent</label>
<input tabindex="1" name="pallor" id="" value="Absent" type="radio" style="margin-right:32px;">

<label>Icterus</label>
<label class="auto">Present</label>
<input tabindex="1" name="icterus" id="" value="Absent" type="radio" class="radiobutMargin">
<label class="auto">Absent</label>
<input tabindex="1" name="icterus" id="" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Cyanosis</label>
<select name="cyanosis" id="cyanosis" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Central">Central</option>
<option value="Peripheral">Peripheral</option>
<option value="Mixed">Mixed</option>
</select>

<label>Clubbing</label>
<label class="auto">Present</label>
<input tabindex="1" name="clubbing" id="" value="Present" type="radio" class="radiobutMargin">
<label class="auto">Absent</label>
<input tabindex="1" name="clubbing" id="" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Lymphadenopathy</label>
<label class="auto">Present</label>
<input tabindex="1" name="lymphadenopathy" id="lymphadenopathy" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'LymphadenopathyO');">
<label class="auto">Absent</label>
<input tabindex="1" name="lymphadenopathy" id="lymphadenopathy" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'LymphadenopathyO');">

<div style="display:none" id="lymphadenopathyDiv">
<h4>Level1</h4>
<label>Submeantal</label>
<input tabindex="2" name="submeantal" id="submeantal" value="Yes" validate="Submeantal,int,no" style=" margin: 0px 5px; " type="checkbox" >
<label>Sub Mandibular</label>
<input tabindex="2" name="subMandibular" id="subMandibular"  validate="Sub Mandibular,int,no" style=" margin: 0px 5px; " type="checkbox" value="Yes">

<div class="clear"></div>

<h4>Level 2</h4>
<label>Upper Juglodidastric</label>
<input tabindex="2" name="upperJuglodidastric" id="upperJuglodidastric"  validate="Upper Juglodidastric,int,no" style=" margin: 0px 5px; " type="checkbox" value="Yes">

<div class="clear"></div>

<h4>Level 3</h4>
<label>Mid Juglodigastric</label>
<input tabindex="2" name="midJuglodigastric" id="midJuglodigastric"  validate="Mid Juglodigastric,int,no" style=" margin: 0px 5px; " type="checkbox" value="Yes">
<div class="clear"></div>
<h4>Level 4</h4>
<label>Supra Clavicular</label>
<input tabindex="2" name="supraClavicular" id="supraClavicular"  validate="Supra Clavicular,int,no" style=" margin: 0px 5px; " type="checkbox" value="Yes">
<div class="clear"></div>

<h4>Level 5</h4>
<label>Posterior Triangle</label>
<input tabindex="2" name="posteriorTriangle" id="posteriorTriangle" validate="Posterior Triangle,int,no" style=" margin: 0px 5px; " type="checkbox" value="Yes">

<div class="clear"></div>
</div>

<div class="clear"></div>
<label>Edema</label>
<label class="auto">Present</label>
<input tabindex="1" name="edema" id="edema" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="edema" id="edema" value="Absent" type="radio" style="margin-right:40px;" onclick="displayTextValueDiv();">

<div style="display:none" id="edemaDiv">
<label class="auto">Pitting</label>
<input tabindex="2" name="edemaPitting" id="edemaPitting" value="Pitting" validate="waiveCharge,int,yes" style=" margin: 0px 5px; " type="checkbox" value="Yes">
<label class="auto">Non Pitting</label>
<input tabindex="2" name="edemaNonPitting" id="edemaNonPitting" value="Non Pitting" validate="waiveCharge,int,yes" style=" margin: 0px 5px; " type="checkbox" value="Yes">
</div>
<div class="clear"></div>

<h4>Review Of System</h4>
<div class="clear"></div>

<h4>Cardio Vascular</h4>
<div class="clear"></div>

<label>Chest Pain</label>
<label class="auto">Present</label>
<input tabindex="1" name="chestPain" id="chestPain" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="chestPain" id="chestPain" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="chestPainDiv">
<input type="text" name="chestPainValue" id="chestPainValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Palpitation</label>
<label class="auto">Present</label>
<input tabindex="1" name="palpitation" id="palpitation" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="palpitation" id="palpitation" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="palpitationDiv">
<input type="text" name="palpitationValue" id="palpitationValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Hypertension</label>
<label class="auto">Present</label>
<input tabindex="1" name="hypertension" id="hypertension" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="hypertension" id="hypertension" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="hypertensionDiv">
<input type="text" name="hypertensionValue" id="hypertensionValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Murmers</label>
<label class="auto">Present</label>
<input tabindex="1" name="murmers" id="murmers" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="murmers" id="murmers" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="murmersDiv">
<input type="text" name="murmersValue" id="murmersValue" maxlength="128" tabindex="1">
</div>
<h4>Respiratory System</h4>
<div class="clear"></div>

<label>Cough</label>
<label class="auto">Present</label>
<input tabindex="1" name="cough" id="cough" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="cough" id="cough" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();" onclick="displayTextValueDiv();">
<div style="display:none" id="coughDiv">
<input type="text" name="coughValue" id="coughValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Wheezing</label>
<label class="auto">Present</label>
<input tabindex="1" name="wheezing" id="wheezing" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="wheezing" id="wheezing" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="wheezingDiv">
<input type="text" name="wheezingValue" id="wheezingValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Dyspnoea</label>
<label class="auto">Present</label>
<input tabindex="1" name="dyspnoea" id="dyspnoea" value="Absent" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="dyspnoea" id="dyspnoea" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="dyspnoeaDiv">
<input type="text" name="dyspnoeaValue" id="dyspnoeaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Nasal Block</label>
<label class="auto">Present</label>
<input tabindex="1" name="nasalBlock" id="nasalBlock" value="Absent" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="nasalBlock" id="nasalBlock" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="nasalBlockDiv">
<input type="text" name="nasalBlockValue" id="nasalBlockValue" maxlength="128" tabindex="1">
</div>
<h4>Central Nervous System</h4>
<div class="clear"></div>

<label>Dizziness</label>
<label class="auto">Present</label>
<input tabindex="1" name="dizziness" id="dizziness" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="dizziness" id="dizziness" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="dizzinessDiv">
<input type="text" name="dizzinessValue" id="dizzinessValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Tremors</label>
<label class="auto">Present</label>
<input tabindex="1" name="tremors" id="tremors" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="tremors" id="tremors" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="tremorsDiv">
<input type="text" name="tremorsValue" id="tremorsValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Headache</label>
<label class="auto">Present</label>
<input tabindex="1" name="headache" id="headache" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="headache" id="headache" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="headacheDiv">
<input type="text" name="headacheValue" id="headacheValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Vommitting</label>
<label class="auto">Present</label>
<input tabindex="1" name="vommitting" id="vommitting" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="vommitting" id="vommitting" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="vommittingDiv">
<input type="text" name="vommittingValue" id="vommittingValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Parathesisa</label>
<label class="auto">Present</label>
<input tabindex="1" name="parathesisa" id="parathesisa" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="parathesisa" id="parathesisa" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="parathesisaDiv">
<input type="text" name="parathesisaValue" id="parathesisaValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Convulsion</label>
<label class="auto">Present</label>
<input tabindex="1" name="convulsion" id="convulsion" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="convulsion" id="convulsion" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="convulsionDiv">
<input type="text" name="convulsionValue" id="convulsionValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Gastro Intestinal System</label>
<input type="text" name="gastroIntestinalSystem" id="gastroIntestinalSystem" maxlength="128" tabindex="1" >
<label>Skeletal System</label>
<input type="text" name="skeltalSystem" id="skeltalSystem" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>GENITO URINARY SYSTEM</h4>
<div class="clear"></div>

<label>Polyuria</label>
<label class="auto">Present</label>
<input tabindex="1" name="polyuria" id="polyuria" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="polyuria" id="polyuria" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="polyuriaDiv">
<input type="text" name="polyuriaValue" id="polyuriaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Oligouria</label>
<label class="auto">Present</label>
<input tabindex="1" name="oligouria" id="oligouria" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="oligouria" id="oligouria" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="oligouriaDiv">
<input type="text" name="oligouriaValue" id="oligouriaValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Haematuria</label>
<label class="auto">Present</label>
<input tabindex="1" name="heamatuia" id="heamatuia" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueDiv();">
<label class="auto">Absent</label>
<input tabindex="1" name="heamatuia" id="heamatuia" value="Absent" type="radio" style="margin-right:21px;" onclick="displayTextValueDiv();">
<div style="display:none" id="heamatuiaDiv">
<input type="text" name="heamatuiaValue" id="heamatuiaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>PALPATION</h4>
<div class="clear"></div>
<label>Temperature</label>
<label class="wdth50">Warm</label>
<input tabindex="1" name="temperatureOne" id="" value="Warm" type="radio" class="radiobutMargin">
<label class="wdth50">Cold</label>
<input tabindex="1" name="temperatureOne" id="" value="Cold" type="radio" style="margin-right:21px;">

<label>Conistency</label>
<select name="conistency" id="conistency" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Soft">Soft</option>
<option value="Firm">Firm</option>
<option value="Hard">Hard</option>
</select>
<div class="clear"></div>

<label>Tenderness</label>
<label class="wdth50">Present</label>
<input tabindex="1" name="tenderness" id="" value="Present" type="radio" class="radiobutMargin">
<label class="wdth50">Absent</label>
<input tabindex="1" name="tenderness" id="" value="Absent" type="radio" style="margin-right:21px;">

<label>Attachment</label>
<input type="text" name="attachment" id="attachment" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Margins</label>
<input type="text" name="margins" id="margins" maxlength="128" tabindex="1">
<label>Compressible</label>
<input type="text" name="compressble" id="compressble" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Reducible</label>
<input type="text" name="reducble" id="reducble" maxlength="128" tabindex="1">
<label>Edge</label>
<input type="text" name="edge" id="edge" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Pressure</label>
<input type="text" name="pressure" id="pressure" maxlength="128" tabindex="1">

<label>Discharge On Pressure</label>
<input type="text" name="dischargeOnPressure" id="dischargeOnPressure" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Percussion</label>
<input type="text" name="percussion" id="percussion" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>INTRA ORAL</h4>
<div class="clear"></div>
<h4>TEETH</h4>
<div class="clear"></div>

<label>Number</label>
<input type="text" name="number" id="number" maxlength="128" tabindex="1">
<label>Root Stumps</label>
<input type="text" name="rootStumps" id="rootStumps" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Decayed Teeth</label>
<input type="text" name="decayedTeeth" id="decayedTeeth" maxlength="128" tabindex="1">

<label>Missing/Avulsed Teeth</label>
<input type="text" name="missingAvulsedTeeth" id="missingAvulsedTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Gingiva</label>
<input type="text" name="gingiva" id="gingiva" maxlength="128" tabindex="1">
<label>Alveloar Mucosa</label>
<input type="text" name="alveloarMucosa" id="alveloarMucosa" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Labial Mucosa</label>
<input type="text" name="labialMucosa" id="labialMucosa" maxlength="128" tabindex="1">
<label>Buccal Mucosa</label>
<input type="text" name="buccalMucosa" id="buccalMucosa" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Palate And Fauces</label>
<input type="text" name="palateAndFauces" id="palateAndFauces" maxlength="128" tabindex="1">

<label>Tongue</label>
<input type="text" name="tongue" id="tongue" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Floor Of Mouth</label>
<input type="text" name="floorOfMouth" id="floorOfMouth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>LOCAL</h4>
<div class="clear"></div>
<h4>EXTRA ORAL</h4>
<div class="clear"></div>

<label>Mouth Opening</label>
<input type="text" name="mouthOpening" id="mouthOpening" maxlength="128" tabindex="1">
<label>Jaw Movements</label>
<input type="text" name="jawMovements" id="jawMovements" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Lateral Movements</label>
<input type="text" name="lateralMovements" id="lateralMovements" maxlength="128" tabindex="1">
<label>Retrusion</label>
<input type="text" name="retrusion" id="retrusion" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Protrusion</label>
<input type="text" name="protrusion" id="protrusion" maxlength="128" tabindex="1">
<label>TM Joints</label>
<input type="text" name="tMJoints" id="tMJoints" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>INSPECTION</h4>
<div class="clear"></div>


<div class="floatRight" style="margin-right: 10px;">
					<input type="button" class="buttonDel" value=""		onclick="removeRowInspection();" />
					<input type="button" class="buttonAdd"	onclick="addRowInspection();" value="" />
					</div>



<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridInspection">
  <tbody>
    <tr>
    <th></th>
      <th>Site</th>
      <th>Number</th>
      <th>Size</th>
      <th>Shape</th>
      <th>Colour</th>
      <th>Discharge</th>
      <th>Surface</th>
      <th>skin over the swelling</th>
    </tr>
    <% int incInspection=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="inspectionRadio<%=incInspection%>" name="softTissueInjuryRadio<%=incInspection%>"></td>
      <td><input name="site<%=incInspection %>" id="site<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><input name="numberInspection<%=incInspection %>" id="numberInspection<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><input name="size<%=incInspection %>" id="size<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><input name="shape<%=incInspection %>" id="shape<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><input name="colour<%=incInspection %>" id="colour<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><input name="discharge<%=incInspection %>" id="discharge<%=incInspection %>" value="" tabindex="34" size="10" maxlength="50" type="text"></td>
      <td><select id="surface<%=incInspection%>" name="surface<%=incInspection%>" maxlength="50"  tabindex="">
      	<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Nodular">Nodular</option>
		<option value="Lobular">Lobular</option>
		<option value="Rough">Rough</option>
		<option value="Irregular">Irregular</option>
		</select>
      </td>
      <td><select id="skinOverTheSwelling<%=incInspection %>" name="skinOverTheSwelling<%=incInspection %>" maxlength="50" tabindex="">
      	<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Engorged Vessels">Engorged Vessels</option>
		<option value="Pigmentation">Pigmentation</option>
		<option value="Scar">Scar</option>	
		</select></td>
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbInspection" value="<%=incInspection%>" id="hdbInspection" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>TREATMENT</h4>
<div class="clear"></div>
<h4>Dental Extractions</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="data18" id="data18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 18</td>
      <td><input name="data17" id="data17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 17</td>
      <td><input name="data16" id="data16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 16</td>
      <td><input name="data15" id="data15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 15</td>
      <td><input name="data14" id="data14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 14</td>
      <td><input name="data13" id="data13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 13</td>
      <td><input name="data12" id="data12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 12</td>
      <td><input name="data11" id="data11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 11</td>
      <td><input name="data21" id="data21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 21</td>
      <td><input name="data22" id="data22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 22</td>
      <td><input name="data23" id="data23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 23</td>
      <td><input name="data24" id="data24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 24</td>
      <td><input name="data25" id="data25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 25</td>
      <td><input name="data26" id="data26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 26</td>
      <td><input name="data27" id="data27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 27</td>
      <td><input name="data28" id="data28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 28</td>
    </tr>
    <tr>
      <td><input name="data48" id="data48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 48</td>
      <td><input name="data47" id="data47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 47</td>
      <td><input name="data46" id="data46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 46</td>
      <td><input name="data45" id="data45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 45</td>
      <td><input name="data44" id="data44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 44</td>
      <td><input name="data43" id="data43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 43</td>
      <td><input name="data42" id="data42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 42</td>
      <td><input name="data41" id="data41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 41</td>
      <td><input name="data31" id="data31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 31</td>
      <td><input name="data32" id="data32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 32</td>
      <td><input name="data33" id="data33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 33</td>
      <td><input name="data34" id="data34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 34</td>
      <td><input name="data35" id="data35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 35</td>
      <td><input name="data36" id="data36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 36</td>
      <td><input name="data37" id="data37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 37</td>
      <td><input name="data38" id="data38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="hidden" name="flagTeeth" id="flagTeeth" maxlength="128" tabindex="1" value="Dental Extractions">
<div class="mltpSlect" style="display:none" id="dataDiv18">
<label class="auto">18</label>
<select id="teeth_18_value" name="teeth_18_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>				 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv17">
<label class="auto">17</label>
<select id="teeth_17_value" name="teeth_17_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv16">
<label class="auto">16</label>
<select id="teeth_16_value" name="teeth_16_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv15">
<label class="auto">15</label>
<select id="teeth_15_value" name="teeth_15_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv14">
<label class="auto">14</label>
<select id="teeth_14_value" name="teeth_14_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv13">
<label class="auto">13</label>
<select id="teeth_13_value" name="teeth_13_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv12">
<label class="auto">12</label>
<select id="teeth_12_value" name="teeth_12_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv11">
<label class="auto">11</label>
<select id="teeth_11_value" name="teeth_11_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv21">
<label class="auto">21</label>
<select id="teeth_21_value" name="teeth_21_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv22">
<label class="auto">22</label>
<select id="teeth_22_value" name="teeth_22_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv23">
<label class="auto">23</label>
<select id="teeth_23_value" name="teeth_23_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv24">
<label class="auto">24</label>
<select id="teeth_24_value" name="teeth_24_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv25">
<label class="auto">25</label>
<select id="teeth_25_value" name="teeth_25_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv26">
<label class="auto">26</label>
<select id="teeth_26_value" name="teeth_26_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv27">
<label class="auto">27</label>
<select id="teeth_27_value" name="teeth_27_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv28">
<label class="auto">28</label>
<select id="teeth_28_value" name="teeth_28_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv48">
<label class="auto">48</label>
<select id="teeth_48_value" name="teeth_48_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv47">
<label class="auto">47</label>
<select id="teeth_47_value" name="teeth_47_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv46">
<label class="auto">46</label>
<select id="teeth_46_value" name="teeth_46_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv45">
<label class="auto">45</label>
<select id="teeth_45_value" name="teeth_45_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv44">
<label class="auto">44</label>
<select id="teeth_44_value" name="teeth_44_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv43">
<label class="auto">43</label>
<select id="teeth_43_value" name="teeth_43_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv42">
<label class="auto">42</label>
<select id="teeth_42_value" name="teeth_42_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv41">
<label class="auto">41</label>
<select id="teeth_41_value" name="teeth_41_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv31">
<label class="auto">31</label>
<select id="teeth_31_value" name="teeth_31_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv32">
<label class="auto">32</label>
<select id="teeth_32_value" name="teeth_32_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv33">
<label class="auto">33</label>
<select id="teeth_33_value" name="teeth_33_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv34">
<label class="auto">34</label>
<select id="teeth_34_value" name="teeth_34_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv35">
<label class="auto">35</label>
<select id="teeth_35_value" name="teeth_35_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv36">
<label class="auto">36</label>
<select id="teeth_36_value" name="teeth_36_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv37">
<label class="auto">37</label>
<select id="teeth_37_value" name="teeth_37_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv38">
<label class="auto">38</label>
<select id="teeth_38_value" name="teeth_38_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>Fascial Extractions</h4>
<div class="clear"></div>
<label>Infection</label>
<label class="auto">Periapical</label>
<input tabindex="1" name="infection" id="" value="Periapical" type="radio" class="radiobutMargin">
<label class="auto">Dentoalveolar</label>
<input tabindex="1" name="infection" id="" value="Dentoalveolar" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Spaces</h4>
<div class="clear"></div>

<label>Buccal</label>
<input name="buccal" id="buccal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="buccalDiv">
<input type="text" name="buccalValue" id="buccalValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<label>Canine</label>
<input name="canine" id="canine" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="canineDiv">
<input type="text" name="canineValue" id="canineValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>

<label>Pericoronal</label>
<input name="pericoronal" id="pericoronal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="pericoronalDiv">
<input type="text" name="pericoronalValue" id="pericoronalValue" maxlength="128" tabindex="1" >
</div>

<label>Masseteric</label>
<input name="masseteric" id="masseteric" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="massetericDiv">
<input type="text" name="massetericValue" id="massetericValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>

<label>Submandiblar</label>
<input name="submandiblar" id="submandiblar" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="submandiblarDiv">
<input type="text" name="submandiblarValue" id="submandiblarValue" maxlength="128" tabindex="1" >
</div>
<label>Sublingual</label>
<input name="sublingual" id="sublingual" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="sublingualDiv">
<input type="text" name="sublingualValue" id="sublingualValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>

<label>Submetal</label>
<input name="submetal" id="submetal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="submetalDiv">
<input type="text" name="submetalValue" id="submetalValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<label>Retromolar</label>
<input name="retromolar" id="retromolar" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="retromolarDiv">
<input type="text" name="retromolarValue" id="retromolarValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>
<label>Pterygomandibular</label>
<input name="pterygomandibular" id="pterygomandibular" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="pterygomandibularDiv">
<input type="text" name="pterygomandibularValue" id="pterygomandibularValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();" >
</div>

<label>Lateral Pharyngeal</label>
<input name="lateralPharyngeal" id="lateralPharyngeal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lateralPharyngealDiv">
<input type="text" name="lateralPharyngealValue" id="lateralPharyngealValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>
<!-- 
<label>Lateral Pharyngeal</label>
<input name="lateralPharyngeal" id="lateralPharyngeal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lateralPharyngealDiv">
<input type="text" name="lateralPharyngealValue" id="lateralPharyngealValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div> -->
<label>Retroopharyngeal</label>
<input name="retroopharyngeal" id="retroopharyngeal" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="retroopharyngealDiv">
<input type="text" name="retroopharyngealValue" id="retroopharyngealValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>

<label>Mediastemitis</label>
<input name="mediastemitis" id="mediastemitis" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="mediastemitisDiv">
<input type="text" name="mediastemitisValue" id="mediastemitisValue" maxlength="128" tabindex="1" onclick="displayTextValueDiv();">
</div>
<div class="clear"></div>

<h4>TREATMENT</h4>
<div class="clear"></div>
<h4>TRAUMA</h4>
<div class="clear"></div>

<label>History</label>
<input type="text" name="history" id="history" maxlength="128" tabindex="1">

<label>RTA</label>
<select name="rta" id="rta" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Assault">Assault</option>
<option value="House hold fall">House hold fall</option>
<option value="Fall at work place">Fall at work place</option>
<option value="Fall from height">Fall from height</option>
<option value="Fall from Vehicle">Fall from Vehicle</option>
<option value="Self-Inflicted">Self-Inflicted</option>
<option value="Occupational">Occupational</option>
<option value="Repetitive stress injury">Repetitive stress injury</option>
<option value="Others">Others</option>
</select>
<div class="clear"></div>

<h4>TRAUMA</h4>
<div class="clear"></div>

<div style="float:left; width:300px;"><h4>Soft Tissue Injury</h4></div>

<div class="floatRight" style="margin-right: 10px;">
					<input type="button" class="buttonDel" value=""		onclick="removeRowSoftTissueInjury();" />
					<input type="button" class="buttonAdd"	onclick="addRowSoftTissueInjury();" value="" />
					</div>



<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridSoftTissueInjury">

  <tbody>
    <tr>
    <th></th>
      <th>Site</th>
      <th>Type of Injury</th>
      <th>Left</th>
      <th>Right</th>
      <th>Size</th>
      <th>Comments</th>
    </tr>
    <% int incrSoftTissueInjury=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="softTissueInjuryRadio<%=incrSoftTissueInjury%>" name="softTissueInjuryRadio<%=incrSoftTissueInjury%>"></td>
    
    <td><select name="site<%=incrSoftTissueInjury %>" id="site<%=incrSoftTissueInjury %>" tabindex="1" class="-smallest">
<option value="">Select</option>
<option value="Face">Face</option>
<option value="Frontal">Frontal</option>
<option value="Supraorbital">Supraorbital</option>
<option value="Nasal">Nasal</option>
<option value="Circumorbital">Circumorbital</option>
<option value="Zygomatic">Zygomatic</option>
<option value="Buccal">Buccal</option>
<option value="Lips">Lips</option>
<option value="Mandible">Mandible</option>
<option value="Submandibular">Submandibular</option>
<option value="Neck">Neck</option>
<option value="Eyelids">Eyelids</option>
</select></td>
      <td><select name="typeOfInjury<%=incrSoftTissueInjury %>" id="typeOfInjury<%=incrSoftTissueInjury %>" tabindex="1"  class="-smallest">
<option value="">Select</option>
<option value="Edema">Edema</option>
<option value="Abrasion Size">Abrasion Size</option>
<option value="Laceration Size">Laceration Size</option>
<option value="Macerated wounds">Macerated wounds</option>
<option value="Loss of tissue wounds">Loss of tissue wounds</option>
<option value="Echymosis">Echymosis</option>
</select></td>
      <td><input name="leftSoftTissue<%=incrSoftTissueInjury %>" id="leftSoftTissue<%=incrSoftTissueInjury %>" tabindex="62" maxlength="25" type="checkbox" value="Yes" style="margin-top: 2px;"></td>
      <td><input name="rightSoftTissue<%=incrSoftTissueInjury %>" id="rightSoftTissue<%=incrSoftTissueInjury %>" tabindex="62" maxlength="25" type="checkbox" value="Yes" style="margin-top: 2px;"></td>
      <td><input name="size<%=incrSoftTissueInjury %>" id="size<%=incrSoftTissueInjury %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" maxlength="50" type="text"></td>
      <td><input name="commentsSoftTissue<%=incrSoftTissueInjury %>" id="commentsSoftTissue<%=incrSoftTissueInjury%>" value="" tabindex="34" maxlength="50" size="10" class="textYellow opdTextBoxSmall" type="text"></td>
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbSoftTissueInjury" value="<%=incrSoftTissueInjury%>" id="hdbSoftTissueInjury" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>HARD TISSUE INJURIES</h4>
<div class="clear"></div>

<label class="auto">Maxillary Dento Alveolar Fracture</label>
<input name="maxillaryDentoAlveolarFracture" id="maxillaryDentoAlveolarFracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="maxillaryDentoAlveolarFractureDiv">
<input type="text" name="maxillaryDentoAlveolarFractureValue" id="maxillaryDentoAlveolarFractureValue" maxlength="128" tabindex="1" style="width:146px;">
</div>
<label>Lefort 1 Fracture</label>
<input name="lefort1Fracture" id="lefort1Fracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lefort1FractureDiv">
<input type="text" name="lefort1FractureValue" id="lefort1FractureValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Lefort 2 Fracture</label>
<input name="lefort2Fracture" id="lefort2Fracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lefort2FractureDiv">
<input type="text" name="lefort2FractureValue" id="lefort2FractureValue" maxlength="128" tabindex="1" >
</div>
<label>Lefort 3 Fracture</label>
<input name="lefort3Fracture" id="lefort3Fracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lefort3FractureDiv">
<input type="text" name="lefort3FractureValue" id="lefort3FractureValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Nasal Bone Fracture</label>
<input name="nasalBoneFracture" id="nasalBoneFracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="nasalBoneFractureDiv">
<input type="text" name="nasalBoneFractureValue" id="nasalBoneFractureValue" maxlength="128" tabindex="1" >
</div>
<label>Zygomatic Arch Fracture</label>
<input name="zygomaticArchFracture" id="zygomaticArchFracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="zygomaticArchFractureDiv">
<input type="text" name="zygomaticArchFractureValue" id="zygomaticArchFractureValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Zygomatic Complex</label>
<input name="zygomaticComplex" id="zygomaticComplex" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="zygomaticComplexDiv">
<input type="text" name="zygomaticComplexValue" id="zygomaticComplexValue" maxlength="128" tabindex="1" >
</div>
<label>Orbital Fracture</label>
<input name="orbitalFracture" id="orbitalFracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="orbitalFractureDiv">
<input type="text" name="orbitalFractureValue" id="orbitalFractureValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>
<label>Frontal Bone Fracture</label>
<input name="frontalBoneFracture" id="frontalBoneFracture" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="frontalBoneFractureDiv">
<input type="text" name="frontalBoneFractureValue" id="frontalBoneFractureValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<h4>Fracture Mandible</h4>
<div class="clear"></div>

<label>Dentoalveolar</label>
<input name="dentoalveolar" id="dentoalveolar" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dentoalveolarDiv">
<input type="text" name="dentoalveolarValue" id="dentoalveolarValue" maxlength="128" tabindex="1">
</div>
<label>Symphysis</label>
<input name="symphysis" id="symphysis" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="symphysisDiv">
<input type="text" name="symphysisValue" id="symphysisValue" maxlength="128" tabindex="1">
</div>
<label>Ramus</label>
<input name="ramus" id="ramus" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ramusDiv">
<input type="text" name="ramusValue" id="ramusValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Angle</label>
<input name="angle" id="angle" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="angleDiv">
<input type="text" name="angleValue" id="angleValue" maxlength="128" tabindex="1">
</div>
<label>Body</label>
<input name="body" id="body" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="bodyDiv">
<input type="text" name="bodyValue" id="bodyValue" maxlength="128" tabindex="1">
</div>
<label>Condyle</label>
<input name="condyle" id="condyle" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="condyleDiv">
<input type="text" name="condyleValue" id="condyleValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Coronoid</label>
<input name="coronoid" id="coronoid" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="coronoidDiv">
<input type="text" name="coronoidValue" id="coronoidValue" maxlength="128" tabindex="1">
</div>

<label>Subcondylar</label>
<input name="subcondylar" id="subcondylar" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="subcondylarDiv">
<input type="text" name="subcondylarValue" id="subcondylarValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Tooth Fracture</h4>
<div class="clear"></div>
<label>Occlusion</label>
<input type="text" name="occusion" id="occusion" maxlength="128" tabindex="1">
<label>Mobility</label>
<input type="text" name="mobility" id="mobility" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>IMPACTIONS</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="dataAnother18" id="dataAnother18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 18</td>
      <td><input name="dataAnother17" id="dataAnother17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 17</td>
      <td><input name="dataAnother16" id="dataAnother16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 16</td>
      <td><input name="dataAnother15" id="dataAnother15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 15</td>
      <td><input name="dataAnother14" id="dataAnother14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 14</td>
      <td><input name="dataAnother13" id="dataAnother13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 13</td>
      <td><input name="dataAnother12" id="dataAnother12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 12</td>
      <td><input name="dataAnother11" id="dataAnother11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnother();" > 11</td>
      <td><input name="dataAnother21" id="dataAnother21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 21</td>
      <td><input name="dataAnother22" id="dataAnother22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 22</td>
      <td><input name="dataAnother23" id="dataAnother23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 23</td>
      <td><input name="dataAnother24" id="dataAnother24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 24</td>
      <td><input name="dataAnother25" id="dataAnother25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 25</td>
      <td><input name="dataAnother26" id="dataAnother26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 26</td>
      <td><input name="dataAnother27" id="dataAnother27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 27</td>
      <td><input name="dataAnother28" id="dataAnother28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnother48" id="dataAnother48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 48</td>
      <td><input name="dataAnother47" id="dataAnother47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 47</td>
      <td><input name="dataAnother46" id="dataAnother46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 46</td>
      <td><input name="dataAnother45" id="dataAnother45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 45</td>
      <td><input name="dataAnother44" id="dataAnother44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 44</td>
      <td><input name="dataAnother43" id="dataAnother43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 43</td>
      <td><input name="dataAnother42" id="dataAnother42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 42</td>
      <td><input name="dataAnother41" id="dataAnother41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 41</td>
      <td><input name="dataAnother31" id="dataAnother31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 31</td>
      <td><input name="dataAnother32" id="dataAnother32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 32</td>
      <td><input name="dataAnother33" id="dataAnother33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 33</td>
      <td><input name="dataAnother34" id="dataAnother34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 34</td>
      <td><input name="dataAnother35" id="dataAnother35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 35</td>
      <td><input name="dataAnother36" id="dataAnother36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 36</td>
      <td><input name="dataAnother37" id="dataAnother37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 37</td>
      <td><input name="dataAnother38" id="dataAnother38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="hidden" name="flagTeeth" id="flagTeeth" maxlength="128" tabindex="1" value="Impactions">
<div class="mltpSlect" style="display:none" id="dataAnotherDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnother" name="teeth_18_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>				 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnother" name="teeth_17_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnother" name="teeth_16_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnother" name="teeth_15_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnother" name="teeth_14_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnother" name="teeth_13_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnother" name="teeth_12_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnother" name="teeth_11_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnother" name="teeth_21_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnother" name="teeth_22_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnother" name="teeth_23_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnother" name="teeth_24_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnother" name="teeth_25_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnother" name="teeth_26_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnother" name="teeth_27_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnother" name="teeth_28_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnother" name="teeth_48_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnother" name="teeth_47_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnother" name="teeth_46_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnother" name="teeth_45_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnother" name="teeth_44_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnother" name="teeth_43_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnother" name="teeth_42_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnother" name="teeth_41_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnother" name="teeth_31_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnother" name="teeth_32_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnother" name="teeth_33_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnother" name="teeth_34_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnother" name="teeth_35_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnother" name="teeth_36_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnother" name="teeth_37_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnother" name="teeth_38_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<label>Treatment</label>
<label>Surgical Removal</label>
<input type="text" name="surgicalRemoval" id="surgicalRemoval" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Surgical Exposure</label>
<input type="text" name="surgicalExposure" id="surgicalExposure" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>TUMORS</h4>
<div class="clear"></div>
<h4>Ameloblastoma</h4>
<div class="clear"></div>

<label>Maxilla</label>
<input name="maxilla" id="maxilla" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="maxillaDiv">
<input type="text" name="maxillaValue" id="maxillaValue" maxlength="128" tabindex="1">
</div>
<label>Mandible</label>
<input name="mandible" id="mandible" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="mandibleDiv">
<input type="text" name="mandibleValue" id="mandibleValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Carcinoma</h4>
<div class="clear"></div>

<label>Buccal Mucosa</label>
<input name="buccalMucosa1" id="buccalMucosa1" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="buccalMucosaDiv">
<input type="text" name="buccalMucosaValue" id="buccalMucosaValue" maxlength="128" tabindex="1">
</div>
<label>Tongue</label>
<input name="tongue1" id="tongue1" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="tongueDiv">
<input type="text" name="tongueValue" id="tongueValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Retromolar Mucosa</label>
<input name="retromolarMucosa" id="retromolarMucosa" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="retromolarMucosaDiv">
<input type="text" name="retromolarMucosaValue" id="retromolarMucosaValue" maxlength="128" tabindex="1">
</div>

<label>Floor Of Mouth</label>
<input name="floorOfMouth1" id="floorOfMouth1" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="floorOfMouthDiv">
<input type="text" name="floorOfMouthValue" id="floorOfMouthValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Alveolus</label>
<input name="alveolus" id="alveolus" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="alveolusDiv">
<input type="text" name="alveolusValue" id="alveolusValue" maxlength="128" tabindex="1">
</div>
<label>Lips</label>
<input name="lips" id="lips" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lipsDiv">
<input type="text" name="lipsValue" id="lipsValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Fibroma</h4>
<div class="clear"></div>

<label>Pre Cancerous Lesions</label>
<input name="preCancerousLesions" id="preCancerousLesions" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="preCancerousLesionsDiv">
<input type="text" name="preCancerousLesionsValue" id="preCancerousLesionsValue" maxlength="128" tabindex="1">
</div>
<label>Pre Cancerous Conditions</label>
<input name="preCancerousConditions" id="preCancerousConditions" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="preCancerousConditionsDiv">
<input type="text" name="preCancerousConditionsValue" id="preCancerousConditionsValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Others</label>
<input name="others" id="others" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="othersDiv">
<input type="text" name="othersValue" id="othersValue" maxlength="128" tabindex="1">
</div>
<label>Fibrous Dysplasia</label>
<input name="fibrousDysplasia" id="fibrousDysplasia" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="fibrousDysplasiaDiv">
<input type="text" name="fibrousDysplasiaValue" id="fibrousDysplasiaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Lymphangioma</label>
<input name="lymphangioma" id="lymphangioma" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="lymphangiomaDiv">
<input type="text" name="lymphangiomaValue" id="lymphangiomaValue" maxlength="128" tabindex="1">
</div>
<label>Ewigs Sarcoma</label>
<input name="ewigsSarcoma" id="ewigsSarcoma" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ewigsSarcomaDiv">
<input type="text" name="ewigsSarcomaValue" id="ewigsSarcomaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Hemangioma</label>
<input name="hemangioma" id="hemangioma" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="hemangiomaDiv">
<input type="text" name="hemangiomaValue" id="hemangiomaValue" maxlength="128" tabindex="1">
</div>
<label class="auto">Central Giant Cell Granuloma</label>
<input name="centralGiant" id="centralGiant" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="centralGiantDiv">
<input type="text" name="centralGiantValue" id="centralGiantValue" maxlength="128" tabindex="1" style="width:175px;">
</div>
<div class="clear"></div>

<label class="auto">Peripheral Giant Cell Granuloma</label>
<input name="peripheralGiant" id="peripheralGiant" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="peripheralGiantDiv">
<input type="text" name="peripheralGiantValue" id="peripheralGiantValue" maxlength="128" tabindex="1" style="width:158px;">
</div>


<label class="auto">Anteriovenous Malfromation</label>
<input name="anteriovenousMalfromation" id="anteriovenousMalfromation" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="anteriovenousMalfromationDiv">
<input type="text" name="anteriovenousMalfromationValue" id="anteriovenousMalfromationValue" maxlength="128" tabindex="1" style="width:175px;">
</div>
<div class="clear"></div>

<h4>Treatment</h4>
<div class="clear"></div>

<label>Excision</label>
<input name="excision" id="excision" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="excisionDiv">
<input type="text" name="excisionValue" id="excisionValue" maxlength="128" tabindex="1">
</div>
<label>Resection</label>
<input name="resection" id="resection" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="resectionDiv">
<input type="text" name="resectionValue" id="resectionValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Others</label>
<input name="others1" id="others1" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="others1Div">
<input type="text" name="others1Value" id="others1Value" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Cysts</h4>
<div class="clear"></div>

<label>Dentigerous Cysts</label>
<input name="dentigerousCysts" id="dentigerousCysts" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dentigerousCystsDiv">
<input type="text" name="dentigerousCystsValue" id="dentigerousCystsValue" maxlength="128" tabindex="1">
</div>
<label>OKC</label>
<input name="okc" id="okc" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="okcDiv">
<input type="text" name="okcValue" id="okcValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Periapical Cysts</label>
<input name="periapicalCysts" id="periapicalCysts" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="periapicalCystsDiv">
<input type="text" name="periapicalCystsValue" id="periapicalCystsValue" maxlength="128" tabindex="1">
</div>

<label>Dermoid Cyst</label>
<input name="dermoidCyst" id="dermoidCyst" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dermoidCystDiv">
<input type="text" name="dermoidCystValue" id="dermoidCystValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Sebeceous Cyst</label>
<input name="sebeceousCyst" id="sebeceousCyst" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="sebeceousCystDiv">
<input type="text" name="sebeceousCystValue" id="sebeceousCystValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Treatment</h4>
<div class="clear"></div>

<label>Marsupialization</label>
<input name="marsupialization" id="marsupialization" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="marsupializationDiv">
<input type="text" name="marsupializationValue" id="marsupializationValue" maxlength="128" tabindex="1">
</div>
<label>Enucleation</label>
<input name="enucleation" id="enucleation" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="enucleationDiv">
<input type="text" name="enucleationValue" id="enucleationValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Others</label>
<input name="others3" id="others3" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="others3Div">
<input type="text" name="others3Value" id="others3Value" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>
<div class="clear"></div>

<h4>Diseasese Of Salivary Glands</h4>
<div class="clear"></div>

<label>Inflammatory</label>
<input name="inflammatory" id="inflammatory" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="inflammatoryDiv">
<input type="text" name="inflammatoryValue" id="inflammatoryValue" maxlength="128" tabindex="1">
</div>
<label>Obstructive</label>
<input name="obstructive" id="obstructive" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="obstructiveDiv">
<input type="text" name="obstructiveValue" id="obstructiveValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Mucocele</label>
<input name="mucocele" id="mucocele" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="mucoceleDiv">
<input type="text" name="mucoceleValue" id="mucoceleValue" maxlength="128" tabindex="1">
</div>

<label>Ranula</label>
<input name="ranula" id="ranula" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ranulaDiv">
<input type="text" name="ranulaValue" id="ranulaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Tumors</label>
<input type="text" name="tumors" id="tumors" maxlength="128" tabindex="1">
<label>Treatment</label>
<input type="text" name="treatment" id="treatment" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Diseasese Of TMJ</h4>
<div class="clear"></div>

<label>Inflammation</label>
<input name="inflammation" id="inflammation" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="inflammationDiv">
<input type="text" name="inflammationValue" id="inflammationValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Ankylosis</label>
<label class="auto">Bony</label>
<input name="ankylosisBony" id="ankylosisBony" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ankylosisBonyDiv">
<input type="text" name="ankylosisBonyValue" id="ankylosisBonyValue" maxlength="128" tabindex="1">
</div>
<label class="auto">Fibrous</label>
<input name="ankylosisFibrous" id="ankylosisFibrous" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ankylosisFibrousDiv">
<input type="text" name="ankylosisFibrousValue" id="ankylosisFibrousValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Dislocation</label>
<label class="auto">Acute</label>
<input name="dislocationAcute" id="dislocationAcute" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dislocationAcuteDiv">
<input type="text" name="dislocationAcuteValue" id="dislocationAcuteValue" maxlength="128" tabindex="1" style="width:120px;">
</div>
<label class="auto">Chronic</label>
<input name="dislocationChronic" id="dislocationChronic" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dislocationChronicDiv">
<input type="text" name="dislocationChronicValue" id="dislocationChronicValue" maxlength="128" tabindex="1" style="width:120px;">
</div>
<label class="auto">Subluxation</label>
<input name="dislocationSubluxation" id="dislocationSubluxation" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="dislocationSubluxationDiv">
<input type="text" name="dislocationSubluxationValue" id="dislocationSubluxationValue" maxlength="128" tabindex="1" style="width:120px;">
</div>
<div class="clear"></div>

<label>Treatment</label>
<input type="text" name="treatmentDiseasese" id="treatmentDiseasese" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>JAW DEFORMITIES</h4>
<div class="clear"></div>
<h4>Maxilla</h4>
<div class="clear"></div>

<label>Deficiency</label>
<label class="auto">AP</label>
<input tabindex="1" name="deficiency" id="" value="AP" type="radio" class="radiobutMargin">
<label class="auto">Vertical</label>
<input tabindex="1" name="deficiency" id="" value="Vertical" type="radio" style="margin-right:21px;">

<label>Excess</label>
<label class="auto">AP</label>
<input tabindex="1" name="excess" id="" value="AP" type="radio" class="radiobutMargin">
<label class="auto">Vertical</label>
<input tabindex="1" name="excess" id="" value="Vertical" type="radio">
<div class="clear"></div>

<h4>Mandible</h4>
<div class="clear"></div>

<label>Deficiency</label>
<label class="auto">AP</label>
<input tabindex="1" name="aPDeficiencyMandible" id="" value="AP" type="radio" class="radiobutMargin">
<label class="auto">Vertical</label>
<input tabindex="1" name="aPDeficiencyMandible" id="" value="Vertical" type="radio" style="margin-right:21px;">

<label>Excess</label>
<label class="auto">AP</label>
<input tabindex="1" name="aPExcessMandible" id="" value="AP" type="radio" class="radiobutMargin">
<label class="auto">Vertical</label>
<input tabindex="1" name="aPExcessMandible" id="" value="Vertical" type="radio">
<div class="clear"></div>

<label>Open Bite</label>
<input name="openBite" id="openBite" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="openBiteDiv">
<input type="text" name="openBiteValue" id="openBiteValue" maxlength="128" tabindex="1">
</div>
<label>Asymmetry</label>
<input name="asymmetry" id="asymmetry" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="asymmetryDiv">
<input type="text" name="asymmetryValue" id="asymmetryValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Treatment</h4>
<div class="clear"></div>

<label class="auto">Anterior Maxillary Osteotomy</label>
<input name="anteriorMaxillaryOsteotomy" id="anteriorMaxillaryOsteotomy" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="anteriorMaxillaryOsteotomyDiv">
<input type="text" name="anteriorMaxillaryOsteotomyValue" id="anteriorMaxillaryOsteotomyValue" maxlength="128" tabindex="1" style="width: 169px;">
</div>

<label>Leforte 1 Osteotomy</label>
<input name="leforte1Osteotomy" id="leforte1Osteotomy" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="leforte1OsteotomyDiv">
<input type="text" name="leforte1OsteotomyValue" id="leforte1OsteotomyValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>BSSO</label>
<input name="bsso" id="bsso" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="bssoDiv">
<input type="text" name="bssoValue" id="bssoValue" maxlength="128" tabindex="1">
</div>

<label>IVRO</label>
<input name="ivro" id="ivro" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="ivroDiv">
<input type="text" name="ivroValue" id="ivroValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Subapical</label>
<input name="subapical" id="subapical" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="subapicalDiv">
<input type="text" name="subapicalValue" id="subapicalValue" maxlength="128" tabindex="1">
</div>
<label>Condyletomy</label>
<input name="condyletomy" id="condyletomy" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="condyletomyDiv">
<input type="text" name="condyletomyValue" id="condyletomyValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Genioplasty</label>
<input name="genioplasty" id="genioplasty" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="genioplastyDiv">
<input type="text" name="genioplastyValue" id="genioplastyValue" maxlength="128" tabindex="1">
</div>
<label>Distraction Osteogenesis</label>
<input name="distractionOsteogenesis" id="distractionOsteogenesis" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="distractionOsteogenesisDiv">
<input type="text" name="distractionOsteogenesisValue" id="distractionOsteogenesisValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>NEUROLOGICAL DISEASES</h4>
<div class="clear"></div>

<label>Trigeminal Neuralgia</label>
<input name="trgeminalNeuralgia" id="trgeminalNeuralgia" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="trgeminalNeuralgiaDiv">
<input type="text" name="trgeminalNeuralgiaValue" id="trgeminalNeuralgiaValue" maxlength="128" tabindex="1">
</div>
<label>Facial Paralysis</label>
<input name="facialParalysis" id="facialParalysis" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="facialParalysisDiv">
<input type="text" name="facialParalysisValue" id="facialParalysisValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Others</label>
<input name="others4" id="others4" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="others4Div">
<input type="text" name="others4Value" id="others4Value" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Treatment</h4>
<div class="clear"></div>

<label>Medical</label>
<input name="medical" id="medical" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="medicalDiv">
<input type="text" name="medicalValue" id="medicalValue" maxlength="128" tabindex="1">
</div>
<label>Surgical</label>
<input name="surgical" id="surgical" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="surgicalDiv">
<input type="text" name="surgicalValue" id="surgicalValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Syndromes</label>
<input type="text" name="syndromes" id="syndromes" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>CONGENITAL ANOMALIES</h4>
<div class="clear"></div>

<label>Cleft Lip</label>
<input name="cleftLip" id="cleftLip" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="cleftLipDiv">
<input type="text" name="cleftLipValue" id="cleftLipValue" maxlength="128" tabindex="1">
</div>
<label>Cleft Palate</label>
<input name="cleftPalate" id="cleftPalate" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="cleftPalateDiv">
<input type="text" name="cleftPalateValue" id="cleftPalateValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Others</label>
<input name="others5" id="others5" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="checkboxMargin" onclick="displayTextValueDiv();">
<div style="display:none" id="others5Div">
<input type="text" name="others5Value" id="others5Value" maxlength="128" tabindex="1">
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

</div>
</form>


<style>
.wdth50 {width:50px;}
</style>



