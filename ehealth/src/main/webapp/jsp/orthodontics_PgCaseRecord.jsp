<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>
<div class="titleBg"><h2>PG CASE RECORD -ORTHODONTICS</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="psCaseRecordOrthodoticsFlag" name="psCaseRecordOrthodoticsFlag" tabindex="1" value="psCaseRecordOrthodoticsFlag" type="hidden"  />
<input type="hidden" name="templateName" value="PG CASE RECORD -ORTHODONTICS"/>
<label>Presenting Complaints</label>


<input type="text" name="presentingComplaints" id="presentingComplaints" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>History</h4>
<div class="clear"></div>

<label>Informar</label>

<select name="informar" id="informar" tabindex="1" validate="Service Center,string,no" onclick="displayInformarValue(this.value);"> 
<option value="">Select</option>
<option value="Patient">Patient</option>
<option value="Father">Father</option>
<option value="Mother">Mother</option>
<option value="Any Other">Any Other</option>
</select>
<div style="display:none" id="informarDiv">
<input type="text" name="anyOther" id="anyOther" maxlength="128" tabindex="1">
</div>
<label>Father</label>
<label class="auto">Alive</label>
<input tabindex="1" name="father" id="father" value="Alive" class="radiobutMargin" type="radio">
<label class="auto">Dead</label>
<input tabindex="1" name="father" id="father" value="Dead" type="radio" class="radiobutMargin">

<div class="clear"></div>
<label>Mother</label>
<label class="auto">Alive</label>
<input tabindex="1" name="mother" id="mother" value="Alive" class="radiobutMargin" type="radio">
<label class="auto">Dead</label>
<input tabindex="1" name="mother" id="mother" value="Dead" type="radio" style="margin-right:60px;">

<label>Con</label>
<label class="auto">Consanguinous</label>
<input tabindex="1" name="con" id="con" value="Consanguinous" class="radiobutMargin" type="radio">
<label class="auto">Non Consangunious</label>
<input tabindex="1" name="con" id="con" value="Non Consangunious" type="radio" class="radiobutMargin">
<div class="clear"></div>

<h4>Siblings</h4>
<div class="clear"></div>

<label>Male</label>
<input type="text" name="male" id="male" onkeypress="javascript:return isNumber(event)" maxlength="2" tabindex="1" class="inputSmall">
<label>Female</label>
<input type="text" name="female" id="female" onkeypress="javascript:return isNumber(event)" maxlength="2" tabindex="1" class="inputSmall">
<div class="clear"></div>
<label class="auto">Parent's General and Dental Condition</label>
<input type="text" name="parentsGeneral" id="parentsGeneral" maxlength="128" tabindex="1">

<label>Type of Malocclusion</label>
<input type="text" name="typeOfMalocclusion" id="typeOfMalocclusion" maxlength="128" tabindex="1" style="width:125px;">
<div class="clear"></div>

<label class="auto">Siblings' General and Dental condition</label>
<input type="text" name="siblingsGeneral" id="siblingsGeneral" maxlength="128" tabindex="1">


<label>Type of Malocclusion</label>
<input type="text" name="typeOfMalocclusion1" id="typeOfMalocclusion1" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Familial Diseases</label>
<input type="text" name="familialDiseases" id="familialDiseases" maxlength="128" tabindex="1">
<label class="auto">History of Orthodontic Treatment</label>
<input type="text" name="orthodonticTreatment" id="orthodonticTreatment" maxlength="128" tabindex="1">

<div class="clear"></div>
<label class="auto">Parents' Concern for Orthodontic Treatment</label>
<select name="parentsConcern" id="parentsConcern" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Very concerned">Very concerned</option>
<option value="Indifferent">Indifferent</option>
<option value="Opposed">Opposed</option>
</select>

<label class="auto">Attitude of the Patient to Treatment</label>
<select name="patientToTreatment" id="patientToTreatment" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Positive">Positive</option>
<option value="Negative">Negative</option>
<option value="Needs Motivation">Needs Motivation</option>
</select>
<div class="clear"></div>

<h4>Prenatal History</h4>
<div class="clear"></div>

<label class="auto">Condtion of Mother During Pregnancy</label>
<input type="text" name="motherDuringPregnancy" id="motherDuringPregnancy" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>History of Infectious Diseases</h4>
<div class="clear"></div>

<label>Bacterial</label>
<input tabindex="2" name="bacterial" id="bacterial" value="Yes" validate="waiveCharge,int,yes" style=" margin: 0px 5px; " type="checkbox" onclick="displayBacterial(this.value,'Bacterial')">
<div style="display:none" id="bacterialDiv">
<input type="text" name="bacterialValue" id="bacterialValue" maxlength="128" tabindex="1" >
</div>
<label>Viral</label>
<input tabindex="2" name="viral" id="viral" value="Yes" validate="waiveCharge,int,yes" style=" margin: 0px 5px; " type="checkbox" onclick="displayViral(this.value,'Viral')">
<div style="display:none" id="viralDiv">
<input type="text" name="viralValue" id="viralValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Parasitic</label>
<input tabindex="2" name="parasitic" id="parasitic" value="Yes" validate="waiveCharge,int,yes" style=" margin: 0px 5px; " type="checkbox" onclick="displayParasitic(this.value,'Parasitic')">
<div style="display:none" id="parasiticDiv">
<input type="text" name="parasiticValue" id="parasiticValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>History of Trauma</label>
<input type="text" name="historyOfTrauma" id="historyOfTrauma" maxlength="128" tabindex="1">
<label>Drugs Taken</label>
<input type="text" name="drugsTaken" id="drugsTaken" maxlength="145" tabindex="1">
<div class="clear"></div>
<label>Any Other Releveant History</label>
<input type="text" name="anyOtherReleveantHistory" id="anyOtherReleveantHistory" maxlength="128" tabindex="1">
<div class="clear"></div>

<div class="clear"></div>
<label>Maternal Nutritional Status</label>
<label class="auto">Vegetarian</label>
<input tabindex="1" name="maternalNutritionalStatus" id="maternalNutritionalStatus" value="Vegetarian" class="radiobutMargin" type="radio" >

<label class="auto">Non-Vegetarian</label>
<input tabindex="1" name="maternalNutritionalStatus" id="maternalNutritionalStatus" value="Non-Vegetarian" type="radio" style="margin-right:60px;">
<div class="clear"></div>
<label class="auto">Vitamins/Minerals etc. Consumed as directed by physician</label>
<label class="auto">Yes</label>
<input tabindex="1" name="vitaminsMinerals" id="vitaminsMinerals" value="Yes" class="radiobutMargin" type="radio">
<label class="auto">No</label>
<input tabindex="1" name="vitaminsMinerals" id="vitaminsMinerals" value="No" type="radio" style="margin-right:60px;">

<div class="clear"></div>
<label>Delivery</label>
<label class="auto">Full Term</label>
<input tabindex="1" name="delivery" id="delivery" value="Full Term" class="radiobutMargin" type="radio">
<label class="auto">Premature</label>
<input tabindex="1" name="delivery" id="delivery" value="Premature" type="radio" style="margin-right:60px;">

<label>Type</label>
<select name="typeVal" id="typeVal" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Forceps">Forceps</option>
<option value="Caesarean">Caesarean</option>
</select>
<div class="clear"></div>

<label>Natal History</label>
<label class="auto">Rh incompatibility</label>
<input tabindex="1" name="natalHistory" id="natalHistory" value="Rh incompatibility" class="radiobutMargin" type="radio" >
<label class="auto">Other diseases</label>
<input tabindex="1" name="natalHistory" id="natalHistory" value="OtherDis" type="radio" class="radiobutMargin" onclick="displayOtherDis(this.value,'OtherDis')">
<div style="display:none" id="natalHistoryDiv">
<input type="text" name="natalHistoryValue" id="natalHistoryValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Post Natal History</h4>
<div class="clear"></div>
<label>Feeding</label>
<select name="feeding" id="feeding" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Bottle">Bottle</option>
<option value="Breast">Breast</option>
<option value="Combined">Combined</option>
</select>
<div class="clear"></div>
<h4>If Breast Fed</h4>
<div class="clear"></div>

<label>For How Long</label>
<input type="text" name="forHowLong" id="forHowLong" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<label>How Many Times Daily</label>
<input type="text" name="howManyTimesDaily" id="howManyTimesDaily" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>
<label>Weaned at (yrs)</label>
<input type="text" name="weanedAtYrs" id="weanedAtYrs" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<h4>If Bottle Fed</h4>
<div class="clear"></div>

<label>For How Long</label>
<input type="text" name="forHowLong1" id="forHowLong1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<label>How Many Times Daily</label>
<input type="text" name="howManyTimesDaily1" id="howManyTimesDaily1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>
<label>Weaned at (yrs)</label>
<input type="text" name="weanedAtYrs1" id="weanedAtYrs1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">


<label>Type of Bottle & Nipple</label>
<input type="text" name="bottleNipple" id="bottleNipple" maxlength="128" tabindex="1">
<div class="clear"></div>
<label class="auto">Any Infection/Rampant Caries</label>
<input type="text" name="anyInfectionRampantCaries" id="anyInfectionRampantCaries" maxlength="128" tabindex="1" style="width:165px;">
<div class="clear"></div>

<h4>Childhood Diseases</h4>
<div class="clear"></div>

<label>Bacterial</label>
<input type="text" name="bacterial1" id="bacterial1" maxlength="128" tabindex="1">
<label>Viral</label>
<input type="text" name="viral1" id="viral1" maxlength="128" tabindex="1">
<div class="clear"></div>
<label>Systemic</label>
<input type="text" name="systemic" id="systemic" maxlength="128" tabindex="1">


<label>Non Systemic</label>
<input type="text" name="nonSystemic" id="nonSystemic" maxlength="128" tabindex="1">
<div class="clear"></div>
<label>Other</label>
<input type="text" name="other" id="other" maxlength="128" tabindex="1">

<h4>History of Drug intake</h4>
<div class="clear"></div>

<label>Past</label>
<input type="text" name="past" id="past" maxlength="128" tabindex="1">
<label>Present</label>
<input type="text" name="present" id="present" maxlength="128" tabindex="1">

<h4>Milestones</h4>
<div class="clear"></div>

<label>Sitting (normal 6 mnts)</label>
<input type="text" name="sittingNormal6Mnts" id="sittingNormal6Mnts" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<label>Crawling (normal 9 mnts)</label>
<input type="text" name="crawlingNormal9Mnts" id="crawlingNormal9Mnts" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<div class="clear"></div>

<label>Standing (normal 12 mnts)</label>
<input type="text" name="standingNormal12Mnts" id="standingNormal12Mnts" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>

<label>Walking (normal 15 mnts)</label>
<input type="text" name="walkingNormal15Mnts" id="walkingNormal15Mnts" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>


<div class="clear"></div>
<label>Running (normal 18 mnts)</label>
<input type="text" name="runningNormal18Mnts" id="runningNormal18Mnts" onkeypress="javascript:return isNumber(event)" maxlength="5"  tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<div class="clear"></div>

<label>Speech at (Yrs)</label>
<input type="text" name="speechAtYrs" id="speechAtYrs" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Years</label>
<label class="auto">Normal</label>
<input tabindex="1" name="speechAtYrsNormal" id="speechAtYrsNormal" checked="checked" value="Normal" class="radiobutMargin" type="radio" onclick="displayTextValue(this.value,'Speech')">
<label class="auto">Abnormal</label>
<input tabindex="1" name="speechAtYrsNormal" id="speechAtYrsAbnormal" value="Abnormal" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Speech')">

<select name="speechValue" id="speechValue" tabindex="1" validate="Service Center,string,no" style="display:none">
<option value="">Select</option>
<option value="Dysfluency">Dysfluency</option>
<option value="Articulation">Articulation</option>
<option value="None">None</option>
</select>
<div class="clear"></div>

<h4>Habits</h4>
<div class="clear"></div>

<label class="auto">Finger/Thumb Sucking-Age Stopped</label>
<input type="text" name="fingerThumbSucking" id="fingerThumbSucking" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<label>Dummy Sucking</label>
<input type="text" name="dummySucking" id="dummySucking" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>

<div class="clear"></div>

<label>Nail Biting/Lip Biting</label>
<input type="text" name="nailBitingLipBiting" id="nailBitingLipBiting" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>

<label class="auto">Tongue Thrusting / Tongue Biting &nbsp; &nbsp;&nbsp;</label>
<input type="text" name="tongueThrusting" id="tongueThrusting" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<div class="clear"></div>

<label>Bruxism</label>
<input type="text" name="bruxism" id="bruxism" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<label>Mouth Breathing</label>
<input type="text" name="mouthBreathing" id="mouthBreathing" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall">
<label class="smallAuto autoSpace">Months</label>
<div class="clear"></div>

<label>If Any Habit Present</label>
<input type="text" name="ifAnyHabitPresent" id="ifAnyHabitPresent" maxlength="128" tabindex="1">
<label>Duration</label>
<input type="text" name="duration" id="duration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>
<label>Intensity</label>
<input type="text" name="intensity" id="intensity" maxlength="128" tabindex="1">


<label>Frequency</label>
<input type="text" name="frequency" id="frequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>
<label>Respiration</label>
<select name="respiration" id="respiration" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Nasal">Nasal</option>
<option value="Oral">Oral</option>
<option value="Oronasal">Oronasal</option>
</select>


<label>Deglutition</label>
<label class="auto">Normal</label>
<input tabindex="1" name="deglutition" id="deglutition" value="Normal" class="radiobutMargin" type="radio"  onclick="displayTextValue(this.value,'Deglutition')">
<label class="auto">Abnormal</label>
<input tabindex="1" name="deglutition" id="deglutition" value="Abnormal" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'Deglutition')">
<div class="clear"></div>
<div style="display:none" id="deglutitionDiv">
<label>Mention Nature</label>
<input type="text" name="mentionNature" id="mentionNature" maxlength="128" tabindex="1">
</div>
<h4>Injuries</h4>
<div class="clear"></div>

<label>Fracture of Teeth</label>
<input type="text" name="fractureOfTeeth" id="fractureOfTeeth" maxlength="128" tabindex="1">
<label>Fracture of Jaws</label>
<input type="text" name="fractureOfJaws" id="fractureOfJaws" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Any Other</label>
<input type="text" name="anyOther1" id="anyOther1" maxlength="128" tabindex="1">

<label>Treatment Done</label>
<input type="text" name="treatmentDone" id="treatmentDone" maxlength="128" tabindex="1">

<h4>General Examination</h4>
<div class="clear"></div>

<label>Build</label>
<input type="text" name="build" id="build" maxlength="128" tabindex="1">
<label>Gait</label>
<input type="text" name="gait" id="gait" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Posture</label>
<input type="text" name="posture" id="posture" maxlength="128" tabindex="1">

<label>Body Type</label>
<input type="text" name="bodyType" id="bodyType" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Body Proportion</label>
<input type="text" name="bodyProportion" id="bodyProportion" maxlength="128" tabindex="1">

<label>Pubis to Head</label>
<input type="text" name="pubisToHead" id="pubisToHead" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Ratio</label>
<input type="text" name="ratio" id="ratio" maxlength="5" onkeypress="javascript:return isNumber(event)" tabindex="1">
<label>Biauricular Width</label>
<input name="biauricularWidth" id="biauricularWidth" maxlength="5" onkeypress="javascript:return isNumber(event)" tabindex="1" type="text">
<div class="clear"></div>

<label>Length of Head</label>
<input name="lengthOfHead" id="lengthOfHead" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall" type="text">
<label>Percentage</label>
<input name="percentage" id="percentage" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="inputSmall" type="text">
<select name="" id="" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Brachycephalic">Brachycephalic</option>
<option value="Mesocephalic">Mesocephalic</option>
<option value="Dolicocephalic">Dolicocephalic</option>
</select>
<div class="clear"></div>

<h4>PROFILE AND FULL FACE ANALYSIS</h4>
<div class="clear"></div>
<h4>EXTRA ORLA EXAMINATION</h4>
<div class="clear"></div>

<label>Facial Form</label>
<select name="facialForm" id="facialForm" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Brachyfacial">Brachyfacial</option>
<option value="Mesofacial">Mesofacial</option>
<option value="Dolicofacial">Dolicofacial</option>
</select>

<label>Facial Symmetry</label>
<input type="text" name="facialSymmetry" id="facialSymmetry" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Facial Profile (Convexity)</label>
<select name="facialProfile" id="facialProfile" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Orthognathic">Orthognathic</option>
<option value="Convex">Convex</option>
<option value="Concave">Concave</option>
</select>

<label>Facial Divergence</label>
<select name="facialDivergence" id="facialDivergence" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Straight">Straight</option>
<option value="Anterior divergence">Anterior divergence</option>
<option value="Posterior divergence">Posterior divergence</option>
</select>
<div class="clear"></div>

<label>Relative Size of Nose</label>
<select name="relativeSizeOfNose" id="relativeSizeOfNose" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Average">Average</option>
<option value="Small">Small</option>
<option value="Large">Large</option>
<option value="Rhinoplasty">Rhinoplasty</option>
</select>

<label>Chin</label>
<select name="chin" id="chin" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Adequate">Adequate</option>
<option value="Prominenet">Prominenet</option>
<option value="Recessive">Recessive</option>
</select>
<div class="clear"></div>

<h4>Lip Position and Size</h4>
<div class="clear"></div>
<h4>1. 'E' line (end of nose to chin)</h4>
<div class="clear"></div>

<label class="auto">Lower Lip (norm 2 mm)-Patient's</label>
<input id="lowerLip" name="lowerLip" class="inputSmall" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>

<label class="auto">Upper Lip (norm 4 mm)-Patient's</label>
<input id="upperLip" name="upperLip" class="inputSmall" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Lip Posture</label>
<label class="auto">Competent</label>
<input tabindex="1" name="lipPosture" id="lipPosture" value="Competent" class="radiobutMargin" type="radio">
<label class="auto">InCompetent</label>
<input tabindex="1" name="lipPosture" id="lipPosture" value="InCompetent" type="radio" style="margin-right:21px;">

<label>Anatomic</label>
<label class="auto">Curled lip</label>
<input tabindex="1" name="anatomic" id="anatomic" value="Curled lip" class="radiobutMargin" type="radio">
<label class="auto">Lip trap</label>
<input tabindex="1" name="anatomic" id="anatomic" value="Lip trap" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Physiologic</label>
<input type="text" name="physiologic" id="physiologic" maxlength="128" tabindex="1">
<label>Dental</label>
<input type="text" name="dental" id="dental" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Lip Size</label>
<select name="lipSize" id="lipSize" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Short Fleshy">Short Fleshy</option>
<option value="Pouted">Pouted</option>
<option value="Everted">Everted</option>
</select>

<label class="auto">Upper</label>
<input tabindex="1" name="lipSizeUpper" id="lipSizeUpper" value="Upper" type="radio" class="radiobutMargin">
<label class="auto">Lower</label>
<input tabindex="1" name="lipSizeLower" id="lipSizeLower" value="Lower" type="radio" style="margin-right:21px;">

<div class="clear"></div>
<label>Mento Labial Sulcus</label>
<select name="mentoLabialSulcus" id="mentoLabialSulcus" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Short Normal">Short Normal</option>
<option value="Shallow">Shallow</option>
<option value="Deep">Deep</option>
</select>

<label>Inter Labial Gap</label>
<input type="text" name="interLabialGap" id="interLabialGap" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Facial Height</label>
<input type="text" name="facialHeight" id="facialHeight" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<label>Facial Height</label>
<label class="auto">UFH</label>
<input type="text" name="facialHeightUfh" id="facialHeightUfh" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<label class="auto">LFH</label>
<input type="text" name="facialHeightLfh" id="facialHeightLfh" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<label>Ratio</label>
<input type="text" name="facialHeightRatio" id="facialHeightRatio" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<h4>Inclination of mandibular plane to frankfort horizontal plane (FMA)</h4>
<div class="clear"></div>

<label>Circum-Oral Muscle Tone</label>
<select name="circumOralMuscleTone" id="circumOralMuscleTone" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normotonic">Normotonic</option>
<option value="Hypotonic">Hypotonic</option>
<option value="Hypertonic">Hypertonic</option>
</select>

<label>Skeletal Class</label>
<select name="skeletalClass" id="skeletalClass" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="I">I</option>
<option value="II">II</option>
<option value="III">III</option>
</select>

<h4>Clinical Impression</h4>
<div class="clear"></div>
<label>Max</label>
<select name="max" id="max" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Protrusive">Protrusive</option>
<option value="Retrusive">Retrusive</option>
</select>

<label>Mand</label>
<select name="mand" id="mand" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Protrusive">Protrusive</option>
<option value="Retrusive">Retrusive</option>
</select>
<div class="clear"></div>


<h4>History</h4>
<div class="clear"></div>

<label>Respiration</label>
<select name="respirationHistory" id="respirationHistory" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Nasal">Nasal</option>
<option value="Oral">Oral</option>
<option value="Oronasal">Oronasal</option>
</select>

<label>Mastication</label>
<input type="text" name="mastication" id="mastication" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Deglutition</label>
<label class="auto">Normal</label>
<input tabindex="1" name="deglutition1" id="deglutition1" value="Normal" type="radio" class="radiobutMargin">
<label class="auto">Infantile</label>
<input tabindex="1" name="deglutition1" id="deglutition1" value="Infantile" type="radio" class="radiobutMargin">

<label>Speech</label>
<label class="auto">Normal</label>
<input tabindex="1" name="speech" id="speech" value="Normal" type="radio" class="radiobutMargin">
<label class="auto">Abnormal</label>
<input tabindex="1" name="speech" id="speech" value="Abnormal" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Path of Closure/TMJ etc.</label>
<label class="auto">Normal</label>
<input tabindex="1" name="pathOfClosure" id="pathOfClosure" value="Normal" type="radio" class="radiobutMargin">
<label class="auto">Deviated</label>
<input tabindex="1" name="pathOfClosure" id="pathOfClosure" value="Deviated" type="radio" style="margin-right:26px;">

<label class="auto">Inter Incisal Opening Maximum</label>
<input id="interIncisalOpeningMaximum" name="interIncisalOpeningMaximum" class="inputSmall" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Smile Line</label>
<select name="smileLine" id="smileLine" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="High">High</option>
<option value="Low">Low</option>
<option value="Normal">Normal</option>
</select>

<label>Gingival Exposure</label>
<input type="text" name="gingivalExposure" id="gingivalExposure" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>During Speech</label>
<select name="duringSpeech" id="duringSpeech" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Excessive">Excessive</option>
<option value="Decreased">Decreased</option>
</select>

<label>During Smile</label>
<select name="duringSmile" id="duringSmile" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Excessive">Excessive</option>
<option value="Decreased">Decreased</option>
</select>
<div class="clear"></div>

<label>Any Other</label>
<input type="text" name="anyOther2" id="anyOther2" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>INTRA ORAL EXAMINATION</h4>
<div class="clear"></div>
<h4>Soft Tissue Appraisal</h4>
<div class="clear"></div>

<label>Frenum Attachment</label>
<input type="text" name="frenumAttachment" id="frenumAttachment" maxlength="128" tabindex="1">
<label class="auto">Upper</label>
<select name="frenumAttachmentUpper" id="frenumAttachmentUpper" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="High">High</option>
<option value="Low">Low</option>
</select>
<label class="auto">Lower</label>
<select name="frenumAttachmentLower" id="frenumAttachmentLower" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="High">High</option>
<option value="Low">Low</option>
</select>

<div class="clear"></div>
<label>Gingival</label>
<select name="gingival" id="gingival" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Edematous">Edematous</option>
<option value="Fibrotic">Fibrotic</option>
<option value="Etc">Etc</option>
</select>

<label>Pockets</label>
<input type="text" name="pockets" id="pockets" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Abnormal Muscle Attachments</label>
<input type="text" name="abnormalMuscleAttachments" id="abnormalMuscleAttachments" maxlength="128" tabindex="1">

<label>Attached Gingiva</label>
<input type="text" name="attachedGingiva" id="attachedGingiva" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tongue</label>
<select name="tongue" id="tongue" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Average">Average</option>
<option value="High">High</option>
<option value="Low">Low</option>
</select>
<label>Size</label>
<input type="text" name="size1" id="size1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<label>Shape</label>
<input type="text" name="shape" id="shape" maxlength="128" tabindex="1">
<label>Posture</label>
<input type="text" name="posture" id="posture" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Mobility</label>
<input type="text" name="mobility" id="mobility" maxlength="128" tabindex="1">

<label>Habit</label>
<input type="text" name="habit" id="habit" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tonsils and Adenoids</label>
<input type="text" name="tonsilsAndAdenoids" id="tonsilsAndAdenoids" maxlength="128" tabindex="1">
<label>TMJ</label>
<select name="tmj" id="tmj" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Clicking">Clicking</option>
<option value="Pain">Pain</option>
<option value="Luxation">Luxation</option>
</select>
<div class="clear"></div>

<label>Path of Closure</label>
<input type="text" name="pathOfClosure" id="pathOfClosure" maxlength="128" tabindex="1">
<label>Occlusal Prematurities</label>
<input type="text" name="occlusalPrematurities" id="occlusalPrematurities" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="auto">Maximum Opening Between Incisors</label>
<input type="text" name="maximumOpeningBetweenIncisors" id="maximumOpeningBetweenIncisors" maxlength="128" tabindex="1" style="width:132px;">

<label>Key Ridge</label>
<input type="text" name="keyRidge" id="keyRidge" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>DENTAL STATUS</h4>
<p style="margin: 0px 0px 5px 8px;">(Record using FDI system)</p>
<div class="clear"></div>

<label>Eruption Status</label>
<input type="text" name="eruptionStatus" id="eruptionStatus" maxlength="128" tabindex="1">
<label>Caries</label>
<input type="text" name="caries" id="caries" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Restorations</label>
<input type="text" name="restorations" id="restorations" maxlength="128" tabindex="1">

<label>Defective Restorations</label>
<input type="text" name="defectiveRestorations" id="defectiveRestorations" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Unerupted Teeth</label>
<input type="text" name="uneruptedTeeth" id="uneruptedTeeth" maxlength="128" tabindex="1">
<label>Impactions</label>
<input type="text" name="impactions" id="impactions" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Endodontically trt</label>
<input type="text" name="endodonticallyTrt" id="endodonticallyTrt" maxlength="128" tabindex="1">
<label>Rotations</label>
<input type="text" name="rotations" id="rotations" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Teeth in Eruption</label>
<input type="text" name="teethInEruption" id="teethInEruption" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Abnormality of Teeth</h4>
<div class="clear"></div>

<label>Enamel</label>
<input type="text" name="enamel" id="enamel" maxlength="128" tabindex="1">
<label>Texture</label>
<input type="text" name="texture" id="texture" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>White Spots</label>
<input type="text" name="whiteSpots" id="whiteSpots" maxlength="128" tabindex="1">

<label>Visible Cracks</label>
<input type="text" name="visibleCracks" id="visibleCracks" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Shape</label>
<input type="text" name="shape1" id="shape1" maxlength="128" tabindex="1">
<label>Size</label>
<input type="text" name="size2" id="size2" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<label>Number</label>
<input type="text" name="numberValue" id="number" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1">
<div class="clear"></div>

<h4>Eruption Sequence</h4>
<div class="clear"></div>

<label>Retained</label>
<input type="text" name="retained" id="retained" maxlength="128" tabindex="1">
<label>Premature Loss</label>
<input type="text" name="prematureLoss" id="prematureLoss" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Early Eruption</label>
<input type="text" name="earlyEruption" id="earlyEruption" maxlength="128" tabindex="1">

<label>Late Eruption</label>
<input type="text" name="lateEruption" id="lateEruption" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Occlusal Wear</label>
<input type="text" name="occlusalWear" id="occlusalWear" maxlength="128" tabindex="1">
<label class="auto">Dental Apical Base-Relationship</label>
<input type="text" name="baseRelationship" id="baseRelationship" maxlength="128" tabindex="1" style="width:157px;">
<div class="clear"></div>

<label>Oral Hygiene</label>
<select name="oralHygiene" id="oralHygiene" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>

<label>Type of Home Care</label>
<label class="auto">Brush</label>
<input tabindex="1" name="typeOfHomeCare" id="typeOfHomeCare" value="Brush" type="radio" class="radiobutMargin">
<label class="auto">Other Aids</label>
<input tabindex="1" name="typeOfHomeCare" id="typeOfHomeCare" value="Other Aids" type="radio" style="margin-right:25px;">
<div class="clear"></div>

<label>Maxillary Arch</label>
<input type="text" name="maxillaryArch" id="maxillaryArch" maxlength="128" tabindex="1">
<label>Mandibular Arch</label>
<input type="text" name="mandibularArch" id="mandibularArch" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Arch Shape</label>
<select name="archShape" id="archShape" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Average">Average</option>
<option value="V shaped">V shaped</option>
<option value="U shaped (square)">U shaped (square)</option>
</select>
<label>Arch Symmetry</label>
<input type="text" name="archSymmetry" id="archSymmetry" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Arch Alignment</label>
<select name="archAlignment" id="archAlignment" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Crowding">Crowding</option>
<option value="Spacing">Spacing</option>
<option value="Rotations">Rotations</option>
</select>

<label>Midline</label>
<input type="text" name="midline" id="midline" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Arches in Occlusion</h4>
<div class="clear"></div>
<h4>Angle's Class</h4>
<div class="clear"></div>

<label>Molar</label>
<input type="text" name="molar" id="molar" maxlength="128" tabindex="1">
<label>Canine</label>
<input type="text" name="canine" id="canine" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Curve of Spee (to second molar if present)</h4>
<div class="clear"></div>

<label>Over Jet</label>
<input id="overJet" name="overJet" class="inputSmall" maxlength="5" tabindex="1" type="text" onkeypress="javascript:return isNumber(event)">
<label class="smallAuto autoSpace">mm</label>
<label>Overbite</label>
<input id="overbite" name="overbite" class="inputSmall" maxlength="5" tabindex="1" type="text" onkeypress="javascript:return isNumber(event)">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Crossbite</label>
<input id="crossbite" name="crossbite" class="inputSmall" maxlength="5" tabindex="1" type="text"  onkeypress="javascript:return isNumber(event)">
<label class="smallAuto autoSpace">mm</label>

<label>Midline</label>
<input id="midline1" class="inputSmall" name="midline1" maxlength="5" tabindex="1" type="text"  onkeypress="javascript:return isNumber(event)">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>RADIOGRAPHIC ANALYSIS</h4>
<div class="clear"></div>
<h4>Intra Oral Radiograph / O.P.G</h4>

<label>Teeth Present</label>
<input type="text" name="teethPresent" id="teethPresent"  tabindex="1">
<label>Teeth Absent</label>
<input type="text" name="teethAbsent" id="teethAbsent" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Root Formation</label>
<input type="text" name="rootFormation" id="rootFormation" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Root Resorption</h4>
<div class="clear"></div>
<label>Permanent Teeth</label>
<input type="text" name="permanentTeeth" id="permanentTeeth" maxlength="128" tabindex="1">
<label>Deciduous Teeth</label>
<input type="text" name="deciduousTeeth" id="deciduousTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Eruption Levels</h4>
<div class="clear"></div>

<label>Permanent Teeth</label>
<input type="text" name="permanentTeeth1" id="permanentTeeth1" maxlength="128" tabindex="1">
<label>Deciduous Teeth</label>
<input type="text" name="deciduousTeeth1" id="deciduousTeeth1" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Character of Restoration</label>
<select name="characterOfRestoration" id="characterOfRestoration" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Over Hanging">Over Hanging</option>
<option value="Heavily Filled">Heavily Filled</option>
<option value="Deficient">Deficient</option>
</select>

<label class="auto">Lamina Dura & Height of Inter dental Crest</label>
<input type="text" name="laminaDura" id="laminaDura" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Trabecular Pattern</label>
<label class="auto">Type I</label>
<input tabindex="1" name="trabecularPattern" id="trabecularPattern" value="Type I" type="radio" class="radiobutMargin">
<label class="auto">Type II</label>
<input tabindex="1" name="trabecularPattern" id="trabecularPattern" value="Type II" type="radio" style="margin-right:38px;">
<label>Supermumerary Teeth</label>
<input type="text" name="supermumeraryTeeth" id="supermumeraryTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Third Molar Status</label>
<input type="text" name="thirdMolarStatus" id="thirdMolarStatus" maxlength="128" tabindex="1">
<label>Pathological Conditions</label>
<input type="text" name="pathologicalConditions" id="pathologicalConditions" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Any Other</label>
<input type="text" name="anyOther3" id="anyOther3" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>CEPHALOMETRIC ANALYSIS</h4>
<div class="clear"></div>
<div class="clear"></div>


<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForCEPHALOMETRICANALYSIS();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForCEPHALOMETRICANALYSIS();" type="button">
</div>
<div class="clear"></div>

<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridCEPHALOMETRICANALYSIS">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Steiner Ref Norm</th>
      <th>Kearal Norm</th>
      <th>Pre Trt.</th>
      <th>Post Trt.</th>
      <th>Diff.</th>
    </tr>
       <% int i=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="CEPHALOMETRICANALYSISRadio<%=i%>" name="CEPHALOMETRICANALYSISRadio<%=i%>"></td>
      <td>
 <select name="measurement<%=i%>" id="measurement<%=i%>" tabindex="1" validate="Measurement,string,no" onchange="displayMeanValue(this.value,'CEPHALOMETRICANALYSIS',<%=i%>)" class="smallest">
<option value="">Select</option>
<option value="SNA.">SNA</option>
<option value="SNB">SNB</option>
<option value="ANB">ANB</option>
<option value="SND">SND</option>
<option value="1 to NA">1 to NA</option>
<option value="1 to  NA">1 to  NA</option>
<option value="1 to NB">1 to NB</option>
<option value="1 to  NB">1 to  NB</option>
<option value="Po to NB">Po to NB</option>
<option value="Po to 1 to NB">Po to 1 to NB</option>
<option value="1 to 1">1 to 1</option>
<option value="Occl to SN">Occl to SN</option>
<option value="GoGn to SN">GoGn to SN</option>
<option value="SL">SL</option>
<option value="Se">Se</option>
<option value="FMA">FMA</option>
<option value="IMPA">IMPA</option>
<option value="FMIA">FMIA</option>
<option value="WITS appraisal">WITS appraisal</option>
<option value="Ant. Face ht.">Ant. Face ht.</option>
<option value="Post Face ht.">Post Face ht.</option>
<option value="Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise">Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise</option>
<option value="Y axis">Y axis</option>
<option value="E plane">E plane</option>
<option value="Effective Maxillary length">Effective Maxillary length</option>
<option value="Upper facial height:Lower facial height">Upper facial height:Lower facial height</option>
<option value="Nasion perpendicular to Point A">Nasion perpendicular to Point A</option>
<option value="Nasion perpendicular to Pog">Nasion perpendicular to Pog</option>
<option value="Lower incisor to A-Pog Line">Lower incisor to A-Pog Line</option>


</select></td>
     
<td><input name="steinerRefNorm<%=i%>" id="steinerRefNorm<%=i%>" readonly="readonly"  maxlength="50" tabindex="1" class="small" type="text"></td>
<td><input name="kearalNorm<%=i%>" id="kearalNorm<%=i%>" readonly="readonly" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="preTrt<%=i%>" id="preTrt<%=i%>" maxlength="50" tabindex="1" class="small" type="text"></td>
  <td><input name="postTrt<%=i%>" id="postTrt<%=i%>" maxlength="50" tabindex="1" class="small" type="text"></td>
  <td><input name="diff<%=i%>" id="diff<%=i%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
  <!--   <tr>
      <td colspan="4">&nbsp;</td>
      <td><strong>Total Score =</strong></td>
      <td>1200XXXX</td>
    </tr> -->
  </tbody>
</table>
</div>
<input type="hidden" name="hdbCEPHALOMETRICANALYSIS" value="<%=i%>" id="hdbCEPHALOMETRICANALYSIS" />


<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>



<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Soft Tissue Analysis: (Holdaway)</h4>
<div class="clear"></div>

<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForSoftTissueAnalysis();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForSoftTissueAnalysis();" type="button">
</div>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridSoftTissueAnalysis">
  <tbody>
    <tr>
    <th></th>
      <th>Particulars</th>
      <th>Mean</th>
      <th>Pre Trt.</th>
      <th>Post Trt.</th>
    </tr>
       <% int sta=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="softTissueAnalysisRadio<%=sta%>" name="softTissueAnalysisRadio<%=sta%>"></td>
      <td>
 <select name="particulars<%=sta%>" id="particulars<%=sta%>" tabindex="1" validate="Particulars,string,no" onchange="displayMeanValue(this.value,'SoftTissueAnalysis',<%=sta%>)" class="smallest">
<option value="">Select</option>
<option value="Facial Angle">Facial Angle</option>
<option value="Upper Lip Curve">Upper Lip Curve</option>
<option value="Skeletal Convexity at pt. A">Skeletal Convexity at pt. A</option>
<option value="H - line Angle">H - line Angle</option>
<option value="Nose Tip to H Line">Nose Tip to H Line</option>
<option value="Upper Sulcus Depth">Upper Sulcus Depth</option>
<option value="Upper Lip Thickness">Upper Lip Thickness</option>
<option value="Upper Lip Strain">Upper Lip Strain</option>
<option value="Lower Lip to H Line">Lower Lip to H Line</option>
<option value="Lower Sulcus Depth">Lower Sulcus Depth</option>
<option value="Soft Tissue Chin Thickness">Soft Tissue Chin Thickness</option>
<option value="Nasolabial Angle">Nasolabial Angle</option>
<option value="Se">Se</option>
<option value="FMA">FMA</option>
<option value="IMPA">IMPA</option>
<option value="FMIA">FMIA</option>
<option value="WITS appraisal">WITS appraisal</option>
<option value="Ant. Face ht.">Ant. Face ht.</option>
<option value="Post Face ht.">Post Face ht.</option>
<option value="Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise">Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise</option>
<option value="Y axis">Y axis</option>
<option value="E plane">E plane</option>
<option value="Effective Maxillary length">Effective Maxillary length</option>
<option value="Upper facial height:Lower facial height">Upper facial height:Lower facial height</option>
<option value="Nasion perpendicular to Point A">Nasion perpendicular to Point A</option>
<option value="Nasion perpendicular to Pog">Nasion perpendicular to Pog</option>
<option value="Lower incisor to A-Pog Line">Lower incisor to A-Pog Line</option>
</select></td>
     
<td><input name="meanValueParticulars<%=sta%>" id="meanValueParticulars<%=sta%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="preTrt<%=sta%>" id="preTrt<%=sta%>" maxlength="50" tabindex="1" class="small" type="text"></td>
  <td><input name="postTrt<%=sta%>" id="postTrt<%=sta%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbSoftTissueAnalysis" value="<%=sta%>" id="hdbSoftTissueAnalysis" />


<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Model Analysis</h4>
<div class="clear"></div>

<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForModelAnalysis();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForModelAnalysis();" type="button">
</div>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridModelAnalysis">
  <tbody>
    <tr>
    	<th></th>
      <th>No.</th>
      <th></th>
      <th>No.</th>
      <th></th>
      <th>No.</th>
      <th></th>
      <th>No.</th>
      <th></th>
      
      
    </tr>
       <% int ma=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="modelAnalysisRadio<%=ma%>" name=""modelAnalysisRadio<%=ma%>""></td>
      <td>
 <select name="noOne<%=ma%>" id="noOne<%=ma%>" tabindex="1" validate="No.,string,no"  class="smallest">
<option value="">Select</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
</select></td>
     
<td><input name="noOneText<%=ma%>" id="noOneText<%=ma%>" maxlength="50" tabindex="1" class="small" type="text"></td>


      <td>
 <select name="noTwo<%=ma%>" id="noTwo<%=ma%>" tabindex="1" validate="No.,string,no"  class="smallest">
<option value="">Select</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
</select></td>
     
<td><input name="noTwoText<%=ma%>" id="noTwoText<%=ma%>" maxlength="50" tabindex="1" class="small" type="text"></td>


    

      <td>
 <select name="noThree<%=ma%>" id="noThree<%=ma%>" tabindex="1" validate="No.,string,no"  class="smallest">
<option value="">Select</option>
<option value="31">31</option>
<option value="32">32</option>
<option value="33">33</option>
<option value="34">34</option>
<option value="35">35</option>
<option value="36">36</option>
</select></td>
     
<td><input name="noThreeText<%=ma%>" id="noOThreeText<%=ma%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
        <td>
 <select name="noFour<%=ma%>" id="noFour<%=ma%>" tabindex="1" validate="No.,string,no"  class="smallest">
<option value="">Select</option>
<option value="41">41</option>
<option value="42">42</option>
<option value="43">43</option>
<option value="44">44</option>
<option value="45">45</option>
<option value="46">46</option>
</select></td>
     
<td><input name="noFourText<%=ma%>" id="noFourText<%=ma%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbModelAnalysis" value="<%=ma%>" id="hdbModelAnalysis" />




<div class="clear"></div>
<div class="paddingTop5"></div>


<h4>POINTS ANALYSIS</h4>
<div class="clear"></div>

<label>Sum of Incisors</label>
<input id="sumOfIncisors" class="inputSmall" name="sumOfIncisors" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>414 Width</h4>
<div class="clear"></div>

<label>Actual</label>
<input id="actual1" name="actual1" class="inputSmall" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Ideal</label>
<input id="ideal1" class="inputSmall" name="ideal1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Difference</label>
<input id="difference" class="inputSmall" name="difference" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>


<h4>616 Width</h4>
<div class="clear"></div>

<label>Actual</label>
<input id="actual2" class="inputSmall" name="actual2" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Ideal</label>
<input id="ideal2" class="inputSmall" name="ideal2" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Difference</label>
<input id="difference1" class="inputSmall" name="difference1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>

<label>Permolar Area</label>
<select name="permolarArea" id="permolarArea" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Contracted">Contracted</option>
<option value="Expanded">Expanded</option>
<option value="Ideal">Ideal</option>
</select>
<div class="clear"></div>

<label>Molar Area</label>
<select name="molarArea" id="molarArea" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Contracted">Contracted</option>
<option value="Expanded">Expanded</option>
<option value="Ideal">Ideal</option>
</select>
<div class="clear"></div>

<h4>KORKHAUS ANALYSIS</h4>
<p style="margin: 0px 0px 5px 8px;">(Measure distance from interpremolar line to most procumbent central)</p>
<div class="clear"></div>

<label>Actual Length</label>
<input id="actualLength" class="inputSmall" name="actualLength" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Ideal</label>
<input id="ideal" class="inputSmall" name="ideal" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Difference</label>
<input id="difference2" class="inputSmall" name="difference2" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Indicates Anterior</label>
<select name="indicatesAnterior" id="indicatesAnterior" tabindex="1" validate="Service Center,string,no"   >
<option value="">Select</option>
<option value="Protrusiori">Protrusiori</option>
<option value="Retrusion">Retrusion</option>
<option value="Ideal">Ideal</option>
</select>
<div class="clear"></div>

<h4>HOWES ANALYSIS</h4>
<div class="clear"></div>

<label class="auto">Total Maxillary Tooth Material (molar to molar inclusive)</label>
<input id="totalMaxillaryToothMaterial" name="totalMaxillaryToothMaterial" class="inputSmall" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label class="smallAuto autoSpace">TM</label>

<label>Inter Premolar Arch Width</label>
<input id="interPremolarArchWidth" class="inputSmall" name="interPremolarArchWidth" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label class="smallAuto autoSpace">PMW</label>
<div class="clear"></div>

<label>Inter Canine Fossa Width</label>
<input id="interCanineFossaWidth" class="inputSmall" name="interCanineFossaWidth" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label class="smallAuto autoSpace">CFW</label>
<div class="clear"></div>


<h4>BOLTON ANALYSIS</h4>
<div class="clear"></div>


<label class="auto">Maxillary Tooth Material (Maxillary "12")</label>
<input id="maxillary12" name="maxillary12"  onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label class="auto">Mandibular Tooth Material (Mandibular "12")</label>
<input id="mandibular12" name="mandibular12"  onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label class="auto">Sum of Maxillary Anterior (Maxillary "6")</label>
<input id="maxillary6" name="maxillary6" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label class="auto">Sum of Mandibular Anterior (Mandibular "6")</label>
<input id="mandibular6" name="mandibular6" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>CAREYS ARCH PERIMETER ANALYSIS</h4>
<div class="clear"></div>

<label>Tooth Material</label>
<label class="auto">Upper</label>
<input type="text" name="toothMaterialUpper" id="toothMaterialUpper" maxlength="128" tabindex="1">
<label class="auto">Lower</label>
<input type="text" name="toothMaterialLower" id="toothMaterialLower" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Arch Perimeter</label>
<label class="auto">Upper</label>
<input type="text" name="archPerimeterUpper" id="archPerimeterUpper" maxlength="128" tabindex="1">
<label class="auto">Lower</label>
<input type="text" name="archPerimeterLower" id="archPerimeterLower" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Difference</label>
<label class="auto">Upper</label>
<input type="text" name="differenceUpper" id="differenceUpper" maxlength="128" tabindex="1">
<label class="auto">Lower</label>
<input type="text" name="differenceLower" id="differenceLower" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Inference</label>
<input type="text" name="inference" id="inference" maxlength="128" tabindex="1">
<div class="clear"></div>


<div class="clear"></div>
<h4>MOYER'S MIXED DENTITION ANALYSIS</h4>

<div class="clear"></div>
<div class="paddingTop15"></div>


<div class="clear"></div>

<h4>RECORD ANALYSIS</h4>
<p style="margin: 0px 0px 5px 8px;">(Clinical findings may be cross checked where - needed)</p>
<div class="clear"></div>
<h4>Antero - Posterior Relationship</h4>
<div class="clear"></div>

<label>Angle's Class</label>
<input type="text" name="angleClass" id="angleClass" maxlength="128" tabindex="1">
<label>Molar</label>
<input type="text" name="molar1" id="molar1" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Canine</label>
<input type="text" name="canine1" id="canine1" maxlength="128" tabindex="1">

<label>Over Jet</label>
<input id="overJet1" class="inputSmall" name="overJet1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>Vertical Relationship</h4>
<div class="clear"></div>

<label>Overbite</label>
<input id="overbite1" class="inputSmall" name="overbite1" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>Transverse Relationship</h4>
<div class="clear"></div>
<h4>Cross Bites / Scissor Bite</h4>
<div class="clear"></div>

<label>Anterior</label>
<input type="text" name="anterior" id="anterior" maxlength="128" tabindex="1">
<label>Posterior</label>
<input type="text" name="posterior" id="posterior" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Midline</h4>
<div class="clear"></div>

<label>Upper</label>
<input id="midlineUpper" class="inputSmall" name="midlineUpper" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Lower</label>
<input id="midlineLower" class="inputSmall" name="midlineLower" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>Axial Inclinations</h4>
<div class="clear"></div>

<label>Incisors</label>
<input id="incisors" class="inputSmall" name="incisors" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Canines</label>
<input id="canines" class="inputSmall" name="canines" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<label>Molars</label>
<input id="molars" class="inputSmall" name="molars" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" type="text">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<h4>SPECIAL INVESTIGATIONS</h4>
<p style="margin: 0px 0px 5px 8px;">(If necessary for the patient)</p>
<div class="clear"></div>

<label>Carpal Index</label>
<input type="text" name="carpalIndex" id="carpalIndex" maxlength="128" tabindex="1">
<label>Endocrine Study</label>
<input type="text" name="endocrineStudy" id="endocrineStudy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>BMR</label>
<input type="text" name="mbr" id="mbr" maxlength="128" tabindex="1">
<label>Calcium Plot</label>
<input type="text" name="calciumPlot" id="calciumPlot" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Keslings Set Up</label>
<input type="text" name="keslingsSetUp" id="keslingsSetUp" maxlength="128" tabindex="1">
<label class="auto">Diagnosis With Probable Etiology</label>
<input type="text" name="probableEtiology" id="probableEtiology" maxlength="128" tabindex="1" style="width:153px;">
<div class="clear"></div>

<label>General Treatment Objectives</label>
<input type="text" name="generalTreatmentObjectives" id="generalTreatmentObjectives" maxlength="128" tabindex="1">
<label>Treatment Objectives</label>
<input type="text" name="treatmentObjectives" id="treatmentObjectives" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Treatment Plan</label>
<input type="text" name="treatmentPlan" id="treatmentPlan" maxlength="128" tabindex="1">

<label>Mechanotherapy</label>
<input type="text" name="mechanotherapy" id="mechanotherapy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Prognesis</label>
<input type="text" name="prognesis" id="prognesis" maxlength="128" tabindex="1">
<label>Retention Plan</label>
<input type="text" name="retentionPlan" id="retentionPlan" maxlength="128" tabindex="1">
<div class="clear"></div>


<h4>CEPHALOMETRICS FOR ORTHOGNATHIC SURGERY</h4>
<div class="clear"></div>
<div class="clear"></div>


<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForCranial();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForCranial();" type="button">
</div>
<div class="clear"></div>
<h2>Cranial base</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridCranial">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Norms (Kerlala)Mean Value (F-MO</th>
      <th>Value</th>
    </tr>
       <% int k=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="cranialRadio<%=k%>" name="cranialRadio<%=k%>"></td>
      <td>
 <select name="measurementCranial<%=k%>" id="measurementCranial<%=k%>" tabindex="1" validate="Service Center,string,no" onchange="displayMeanValue(this.value,'Cranial',<%=i %>)" class="smallest">
<option value="">Select</option>
<option value="Ar-Ptm (11HP)">Ar-Ptm (11HP)</option>
<option value="Ptm-N (11HP)">Ptm-N (11HP)</option>
</select></td>
     
<td><input name="meanValueCranial<%=k%>" id="meanValueCranial<%=k%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="valueCranial<%=k%>" id="valueCranial<%=k%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbCranial" value="<%=k%>" id="hdbCranial" />


<div class="clear"></div>
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForHorizontal();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForHorizontal();" type="button">
</div>
<div class="clear"></div>
<h2>Horizontal (skeletal)</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridHorizontal">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Norms (Kerlala)Mean Value (F-MO</th>
      <th>Value</th>
    </tr>
       <% int j=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="horizontalRadio<%=j%>" name="horizontalRadio<%=j%>"></td>
      <td>
 <select name="measurementHorizontal<%=j%>" id="measurementHorizontal<%=j%>" tabindex="1" validate="Service Center,string,no" onchange="displayMeanValue(this.value,'Horizontal',<%=j %>)" class="smallest">
<option value="">Select</option>
<option value="N-Apg (angle)">N-Apg (angle)</option>
<option value="N-A (11HP)">N-A (11HP)</option>
<option value="N-B (11HP)">N-B (11HP)</option>
<option value="N-Pg (11HP)">N-Pg (11HP)</option>
</select></td>
     
<td><input name="meanValueHorizontal<%=j%>" id="meanValueHorizontal<%=j%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="valueHorizontal<%=j%>" id="valueHorizontal<%=j%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbHorizontal" value="<%=j%>" id="hdbHorizontal" />


<div class="clear"></div>

<div class="clear"></div>
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForVertical();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForVertical();" type="button">
</div>
<div class="clear"></div>
<h2>Vertical (skeletal, dental)</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridVertical">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Norms (Kerlala)Mean Value (F-MO</th>
      <th>Value</th>
    </tr>
       <% int l=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="verticalRadio<%=l%>" name="verticalRadio<%=l%>"></td>
      <td>
 <select name="measurementVertical<%=l%>" id="measurementVertical<%=l%>" tabindex="1" validate="Service Center,string,no" onchange="displayMeanValue(this.value,'Vertical',<%=l %>)" class="smallest">
<option value="">Select</option>
<option value="N-ANS">N-ANS</option>
<option value="AMS-Gn">AMS-Gn</option>
<option value="PNS-N">PNS-N</option>
<option value="MP-HP (angle)">MP-HP (angle)</option>
<option value="1-NF">1-NF</option>
<option value="1-MP">1-MP</option>
<option value="6-NF">6-NF</option>
<option value="6-MP">6-MP</option>
</select></td>
     
<td><input name="meanValueVertical<%=l%>" id="meanValueVertical<%=l%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="valueVertical<%=l%>" id="valueVertical<%=l%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbVertical" value="<%=l%>" id="hdbVertical" />


<div class="clear"></div>
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForMaxilla();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForMaxilla();" type="button">
</div>

<div class="clear"></div>
<h2>Maxilla, Mandible</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridMaxilla">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Norms (Kerlala)Mean Value (F-MO</th>
      <th>Value</th>
    </tr>
       <% int m=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="maxillaRadio<%=m%>" name="maxillaRadio<%=m%>"></td>
      <td>
 <select name="measurementMaxilla<%=m%>" id="measurementMaxilla<%=m%>" tabindex="1" validate="Service Center,string,no" onchange="displayMeanValue(this.value,'Maxilla',<%=m %>)" class="smallest">
<option value="">Select</option>
<option value="PNS - ANS (11HP)">PNS - ANS (11HP)</option>
<option value="Ar - Go (linear)">Ar - Go (linear)</option>
<option value="Go-Pg (linear)">Go-Pg (linear)</option>
<option value="B-Pg (11MP)">B-Pg (11MP)</option>
<option value="Ar-Go-Gn (angle)">Ar-Go-Gn (angle)</option>
</select></td>
     
<td><input name="meanValueMaxilla<%=m%>" id="meanValueMaxilla<%=m%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="valueMaxilla<%=m%>" id="valueMaxilla<%=m%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbMaxilla" value="<%=m%>" id="hdbMaxilla" />


<div class="clear"></div>
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForDental();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForDental();" type="button">
</div>
<div class="clear"></div>
<h2>Dental</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridDental">
  <tbody>
    <tr>
    <th></th>
      <th>Measurement</th>
      <th>Norms (Kerlala)Mean Value (F-MO</th>
      <th>Value</th>
    </tr>
       <% int n=1; %>
       
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="dentalRadio<%=n%>" name="dentalRadio<%=n%>"></td>
      <td>
 <select name="measurementDental<%=n%>" id="measurementDental<%=n%>" tabindex="1" validate="Service Center,string,no" onchange="displayMeanValue(this.value,'Dental',<%=n %>)" class="smallest">
<option value="">Select</option>
<option value="OP upper - HP (angle)">OP upper - HP (angle)</option>
<option value="OP lower - HP (angle)">OP lower - HP (angle)</option>
<option value="A-b (11 OP)">A-b (11 OP)</option>
<option value="1 - NF (angle)">1 - NF (angle)</option>
<option value="1 - MP (angle)">1 - MP (angle)</option>
</select></td>
     
<td><input name="meanValueDental<%=n%>" id="meanValueDental<%=n%>" maxlength="50" tabindex="1" class="small" type="text"></td>

  <td><input name="valueDental<%=n%>" id="valueDental<%=n%>" maxlength="50" tabindex="1" class="small" type="text"></td>
      
    </tr>
 
  </tbody>
</table>
</div>
<input type="hidden" name="hdbDental" value="<%=n%>" id="hdbDental" />


<div class="clear"></div>

<div class="paddingTop5"></div>


<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


<h4>Permanent Dentition</h4>
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

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="clear"></div>
<h4>Primary Dentition</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="data51" id="data51" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 51</td>
      <td><input name="data52" id="data52" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 52</td>
      <td><input name="data53" id="data53" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 53</td>
      <td><input name="data54" id="data54" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 54</td>
      <td><input name="data55" id="data55" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 55</td>
      <td><input name="data61" id="data61" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 61</td>
      <td><input name="data62" id="data62" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 62</td>
      <td><input name="data63" id="data63" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 63</td>
      <td><input name="data64" id="data64" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 64</td>
      <td><input name="data65" id="data65" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 65</td>
    </tr>
    <tr>
      <td><input name="data81" id="data81" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 81</td>
      <td><input name="data82" id="data82" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 82</td>
      <td><input name="data83" id="data83" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 83</td>
      <td><input name="data84" id="data84" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 84</td>
      <td><input name="data85" id="data85" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 85</td>
      <td><input name="data71" id="data71" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 71</td>
      <td><input name="data72" id="data72" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 72</td>
      <td><input name="data73" id="data73" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 73</td>
      <td><input name="data74" id="data74" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 74</td>
      <td><input name="data75" id="data75" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 75</td>
    </tr>
  </tbody>
</table>

</div>


<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataDiv51">
<label class="auto">51</label>
<select id="teeth_51_value" name="teeth_51_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv52">
<label class="auto">52</label>
<select id="teeth_52_value" name="teeth_52_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv53">
<label class="auto">53</label>
<select id="teeth_53_value" name="teeth_53_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv54">
<label class="auto">54</label>
<select id="teeth_54_value" name="teeth_54_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv55">
<label class="auto">55</label>
<select id="teeth_55_value" name="teeth_55_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv61">
<label class="auto">61</label>
<select id="teeth_61_value" name="teeth_61_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv62">
<label class="auto">62</label>
<select id="teeth_62_value" name="teeth_62_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv63">
<label class="auto">63</label>
<select id="teeth_63_value" name="teeth_63_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv64">
<label class="auto">64</label>
<select id="teeth_64_value" name="teeth_64_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv65">
<label class="auto">65</label>
<select id="teeth_65_value" name="teeth_65_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv81">
<label class="auto">81</label>
<select id="teeth_81_value" name="teeth_81_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv82">
<label class="auto">82</label>
<select id="teeth_82_value" name="teeth_82_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv83">
<label class="auto">83</label>
<select id="teeth_83_value" name="teeth_83_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv84">
<label class="auto">84</label>
<select id="teeth_84_value" name="teeth_84_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv85">
<label class="auto">85</label>
<select id="teeth_85_value" name="teeth_85_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv71">
<label class="auto">71</label>
<select id="teeth_71_value" name="teeth_71_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv72">
<label class="auto">72</label>
<select id="teeth_72_value" name="teeth_72_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv73">
<label class="auto">73</label>
<select id="teeth_73_value" name="teeth_73_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv74">
<label class="auto">74</label>
<select id="teeth_74_value" name="teeth_74_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataDiv75">
<label class="auto">75</label>
<select id="teeth_75_value" name="teeth_75_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<input name="Submit" value="Submit" tabindex="1" class="button" type="button">
<input name="Reset" value="Reset" class="buttonHighlight" tabindex="2" onclick="" accesskey="" type="reset">


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

</div>
</form>

