<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>


<div class="titleBg"><h2>Pedodontics Vital Statistics</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="pedodonticsVitalStatisticsFlag" name="pedodonticsVitalStatisticsFlag" tabindex="1" value="pedodonticsVitalStatisticsFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Pedodontics Vital Statistics"/>
<div class="clear"></div>
<h4>Occupation of The Parents</h4>
<div class="clear"></div>

<!-- <label class="auto">History of Presenting Complaints</label> -->
<label class="auto">Presenting Complaints</label>
<input type="text" name="presentingComplaints" id="presentingComplaints" maxlength="128" tabindex="1" style="width:153px;">

<label>Informar</label>
<select name="informar" id="informar" tabindex="1" validate="Service Center,string,no"  onclick="displayInformarValue(this.value);">
<option value="">Select</option>
<option value="Patient">Patient</option>
<option value="Father">Father</option>
<option value="Mother">Mother</option>
<option value="Any Other">Any Other</option>
</select>
<div style="display:none" id="informarDiv">
<input type="text" name="informarValue" id="informarValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Chief Complaint</label>
<input type="text" name="chiefComplaint" id="chiefComplaint" maxlength="128" tabindex="1">
<label class="auto">History of Presenting Complaints</label>
<input type="text" name="presentingComplaints1" id="presentingComplaints1" maxlength="128" tabindex="1" style="width:153px;">
<div class="clear"></div>

<h4>MEDICAL HISTORY</h4>
<div class="clear"></div>

<label class="lable308">Is the child on any treatment or drug therapy</label>
<input type="text" name="drugTherapy" id="drugTherapy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">If Yes, why?</label>
<input type="text" name="ifYeswhy" id="ifYeswhy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Special tests (Describe date and result)</label>
<input type="text" name="specialTests" id="specialTests" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Immunization status</label>
<input type="text" name="immunizationStatus" id="immunizationStatus" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Dose / Did the child suffer frequent illnesses?</label>
<input type="text" name="frequentIllnesses" id="frequentIllnesses" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">(Cough, Cold, Fever etc. During early childhood)</label>
<input type="text" name="duringEarlyChildhood" id="duringEarlyChildhood" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Does the child have any drug allergy?</label>
<input type="text" name="drugAllergy" id="drugAllergy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">If yes, Specify</label>
<input type="text" name="ifyesSpecify" id="ifyesSpecify" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Does the child have any developmental abnormality?</label>
<input type="text" name="developmentalAbnormality" id="developmentalAbnormality" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Does the child have any mental or physical disability?</label>
<input type="text" name="physicalDisability" id="physicalDisability" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Was the child hopsitalized for any reason?</label>
<input type="text" name="childHopsitalized" id="childHopsitalized" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">Was the child ever given blood transfusion?</label>
<input type="text" name="bloodTransfusion" id="bloodTransfusion" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>FAMILY HISTORY</h4>
<div class="clear"></div>
<p style="margin: 0px 0px 5px 8px;">Does any one in the child's family suffer from any of the following?</p>
<div class="clear"></div>

<label>Bleeding Disorders</label>
<label class="auto">Yes</label>
<input tabindex="1" name="bleedingDisorders" id="bleedingDisorders" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="bleedingDisorders" id="bleedingDisorders" value="No" type="radio" style="margin-right:21px;">
<label>Heart Disease</label>
<label class="auto">Yes</label>
<input tabindex="1" name="heartDisease" id="heartDisease" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="heartDisease" id="heartDisease" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Diabetes</label>
<label class="auto">Yes</label>
<input tabindex="1" name="diabetes" id="diabetes" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="diabetes" id="diabetes" value="No" type="radio" style="margin-right:21px;">
<label>Tuberculosis</label>
<label class="auto">Yes</label>
<input tabindex="1" name="tuberculosis" id="tuberculosis" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="tuberculosis" id="tuberculosis" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Asthma</label>
<label class="auto">Yes</label>
<input tabindex="1" name="asthma" id="asthma" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="asthma" id="asthma" value="No" type="radio" style="margin-right:21px;">
<label>Allergic Reactions</label>
<label class="auto">Yes</label>
<input tabindex="1" name="allergicReactions" id="allergicReactions" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="allergicReactions" id="allergicReactions" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Genetic Disorders</label>
<label class="auto">Yes</label>
<input tabindex="1" name="geneticDisorders" id="geneticDisorders" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="geneticDisorders" id="geneticDisorders" value="No" type="radio" style="margin-right:21px;">
<label>Abnormalities of Teeth</label>
<label class="auto">Yes</label>
<input tabindex="1" name="abnormalitiesOfTeeth" id="abnormalitiesOfTeeth" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="abnormalitiesOfTeeth" id="abnormalitiesOfTeeth" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Malocclusion</label>
<label class="auto">Yes</label>
<input tabindex="1" name="malocclusion" id="malocclusion" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="malocclusion" id="malocclusion" value="No" type="radio" style="margin-right:21px;">
<label>Any Other</label>
<label class="auto">Yes</label>
<input tabindex="1" name="anyOther" id="anyOther" value="Yes" type="radio" class="radiobutMargin" onchange="displayAnyOtherValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="anyOther" id="anyOther" value="No" type="radio" style="margin-right:21px;" onchange="displayAnyOtherValue(this.value);">
<div style="display:none" id="anyOtherDiv">
<input type="text" name="anyOtherValue" id="anyOtherValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>PRENATAL HISTORY</h4>
<div class="clear"></div>

<label class="lable308">Health of the Mother During Pregnancy</label>
<input type="text" name="motherDuringPregnancy" id="motherDuringPregnancy" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable308">History of blood incompatiblity between parents:</label>
<label class="auto">Present</label>
<input tabindex="1" name="incompatiblityBetweenParents" id="incompatiblityBetweenParents" value="Present" type="radio" class="radiobutMargin">
<label class="auto">Absent</label>
<input tabindex="1" name="incompatiblityBetweenParents" id="incompatiblityBetweenParents" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="lable308" style="height:auto;">Whether the mother has undergone any form of drug therapy during pregnancy:</label>
<div class="yesNowWidth">
<label class="auto">Yes</label>
<input tabindex="1" name="therapyDuringPregnancy" id="therapyDuringPregnancy" value="Yes" type="radio" class="radiobutMargin" onclick="displayTherapyDuringPregnancyValue(this.value);">
<div class="clear"></div>
<label class="auto">No &nbsp;</label>
<input tabindex="1" name="therapyDuringPregnancy" id="therapyDuringPregnancy" value="No" type="radio" class="radiobutMargin" onclick="displayTherapyDuringPregnancyValue(this.value);">
</div>
<div class="clear"></div>

<div style="display:none;" id="therapyDuringPregnancyDiv">
<label>Name of The Drug</label>
<input type="text" name="nameOfTheDrug" id="nameOfTheDrug" maxlength="128" tabindex="1">
<label>Duration of Adminstration</label>
<input type="text" name="durationOfAdminstration" id="durationOfAdminstration" maxlength="128" tabindex="1">
<div class="clear"></div>
<label>Probable Diagnosis</label>
<input type="text" name="probableDiagnosis" id="probableDiagnosis" maxlength="128" tabindex="1">
<label>Source of Drinking Water</label>
<input type="text" name="sourceOfDrinkingWaterYes" id="sourceOfDrinkingWater" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>NATAL HISTORY</h4>
<div class="clear"></div>

<label>Delivery</label>
<label class="auto">Full-Term</label>
<input tabindex="1" name="delivery" id="delivery" value="Full-Term" type="radio" class="radiobutMargin">
<label class="auto">Premature</label>
<input tabindex="1" name="delivery" id="delivery" value="Premature" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Type of Delivery</label>
<select name="typeOfDelivery" id="typeOfDelivery" tabindex="1" validate="Service Center,string,no" onclick="displayTypeOfDeliveryValue(this.value)" >
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Forceps">Forceps</option>
<option value="Caesarian">Caesarian</option>
<option value="Other">Other</option>
</select>
<div style="display:none" id="typeOfDeliveryDiv">
<input type="text" name="typeOfDeliveryValue" id="typeOfDeliveryValue" maxlength="128" tabindex="1">
<div class="clear"></div>
</div>

<label>Birth Cry</label>
<label class="auto">Immediate</label>
<input tabindex="1" name="birthCry" id="birthCry" value="Immediate" type="radio" class="radiobutMargin">
<label class="auto">Delayed</label>
<input tabindex="1" name="birthCry" id="birthCry" value="Delayed" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Birth Weight</label>
<input type="text" name="birthWeight" id="birthWeight" maxlength="5" tabindex="1" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<label>Blood Group</label>
<input type="text" name="bloodGroup" id="bloodGroup" maxlength="5" tabindex="1" validate="Birth Blood Group,string,no">
<div class="clear"></div>

<label class="lable262">How was the child's health at birth?</label>
<select name="healthAtBirth" id="healthAtBirth" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Fair">Fair</option>
<option value="Poor">Poor</option>
</select>
<div class="clear"></div>
<label class="lable262">Was the child give oxygen Supplementation?</label>
<input type="text" name="oxygenSupplementation" id="oxygenSupplementation" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable262">Was the child a blue baby?</label>
<input type="text" name="childBlueBaby" id="childBlueBaby" maxlength="128" tabindex="1">
<div class="clear"></div>
<label class="lable262">Was the child jaundiced at birth?</label>
<input type="text" name="childJaundicedAtBirth" id="childJaundicedAtBirth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable262">Any other abnormality at birth:</label>
<input type="text" name="abnormalityAtBirth" id="abnormalityAtBirth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>POST NATAL HISTORY</h4>
<div class="clear"></div>
<h4>Method of Feeding</h4>
<div class="clear"></div>

<label>Breast - Fed</label>
<label class="auto">Yes</label>
<input tabindex="1" name="breastFed" id="breastFed" value="Yes" type="radio" class="radiobutMargin" onchange="displayBreastFedValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="breastFed" id="breastFed" value="No" type="radio" class="radiobutMargin" onchange="displayBreastFedValue(this.value);">
<div style="display:none" id="breastFedDiv">
<input type="text" name="breastFedValue" id="breastFedValue"  maxlength="56" tabindex="1"  validate="Breast - Fed,num,no">
</div>
<div class="clear"></div>

<label>Bottle - Fed</label>
<label class="auto">Yes</label>
<input tabindex="1" name="bottleFed" id="bottleFed" value="Yes" type="radio" class="radiobutMargin" onchange="displayBottleFedValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="bottleFed" id="bottleFed" value="No" type="radio" class="radiobutMargin" onchange="displayBottleFedValue(this.value);">
<div style="display:none" id="bottleFedDiv">
<input type="text" name="bottleFedValue" id="bottleFedValue" maxlength="56" validate="Bottle - Fed,num,no"  validate="Bottle - Fed,num,no" tabindex="1">
</div>
<div class="clear"></div>

<label>Combination</label>
<label class="auto">Yes</label>
<input tabindex="1" name="combination" id="combination" value="Yes" type="radio" class="radiobutMargin" onchange="displayCombinationValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="combination" id="combination" value="No" type="radio" class="radiobutMargin" onchange="displayCombinationValue(this.value);">
<div style="display:none" id="combinationDiv">
<input type="text" name="combinationValue" id="combinationValue" maxlength="56" onPaste="return false"  onkeypress="javascript:return isNumber(event) validate="Combination,num,no" tabindex="1">
</div>
<div class="clear"></div>

<label class="lable412">Age until which the child was breast fed?</label>
<input type="text" name="childreastFed" id="childreastFed" maxlength="5" tabindex="1" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<div class="clear"></div>

<label class="lable412">Dose / Did your child sleep with the bottle?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="sleepWithTheBottle" id="sleepWithTheBottle" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="sleepWithTheBottle" id="sleepWithTheBottle" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="lable412">What were the contents of the bottle?</label>
<input type="text" name="contentsOfTheBottle" id="contentsOfTheBottle" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable412">Did the child have an erupted tooth at birth or within 30 days after birth?</label>
<input type="text" name="within30DaysAfterBirth" id="within30DaysAfterBirth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable412">At what age did the first tooth erupt in the mouth?</label>
<input type="text" name="firstToothErupt" id="firstToothErupt" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1">
<div class="clear"></div>

<label class="lable412">Which tooth and was there any associated problem?</label>
<input type="text" name="anyAssociatedProblem" id="anyAssociatedProblem" maxlength="128" tabindex="1">
<div class="clear"></div>
<label class="lable412">When did the child attain the following developmental milestones?</label>
<input type="text" name="followingDevelopmentalMilestones" id="followingDevelopmentalMilestones" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Head holding</label>
<input type="text" name="headHolding" id="headHolding" maxlength="128" tabindex="1">
<label>Rolling Over</label>
<input type="text" name="rollingOver" id="rollingOver" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Sitting</label>
<input type="text" name="sitting" id="sitting" maxlength="128" tabindex="1">
<label>Standing without support</label>
<input type="text" name="standingwithoutSupport" id="standingwithoutSupport" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Walking</label>
<input type="text" name="walking" id="walking" maxlength="128" tabindex="1">
<label>Running</label>
<input type="text" name="running" id="running" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Speaking sentences</label>
<input type="text" name="speakingSentences" id="speakingSentences" maxlength="128" tabindex="1">
<label>Inference</label>
<input type="text" name="inference" id="inference" maxlength="128" tabindex="1">

<h4>SOCIAL HISTORY</h4>
<div class="clear"></div>

<label class="lable412">Does the child fail to get along with other children?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="alongWithOtherChildren" id="alongWithOtherChildren" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="alongWithOtherChildren" id="alongWithOtherChildren" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="lable412">Does the child have difficulty in keeping up with his school work?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="difficultyInKeeping" id="difficultyInKeeping" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="difficultyInKeeping" id="difficultyInKeeping" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="lable412">Does the child have brothers/Sisters?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="childHaveBrothersSisters" id="childHaveBrothersSisters" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="childHaveBrothersSisters" id="childHaveBrothersSisters" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Scholastic Performance</label>
<select name="scholasticPerformance" id="scholasticPerformance" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Excellent">Excellent</option>
<option value="Good">Good</option>
<option value="Poor">Poor</option>
</select>

<label>Behaviour</label>
<select name="behaviour" id="behaviour" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Receptive">Receptive</option>
<option value="Apprehensive">Apprehensive</option>
<option value="Problematic">Problematic</option>
</select>
<div class="clear"></div>

<label>Behaviour Rating </label>
<input type="text" name="behaviourRating" id="behaviourRating" maxlength="128" tabindex="1">
 <label>of frankl rating scale</label>

<div class="clear"></div>

<h4>PERSONAL HISTORY</h4>
<div class="clear"></div>

<label class="lable262">When does the child brush his teeth? </label>
<select name="childBrushHisTeeth" id="childBrushHisTeeth" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="On rising up in the morning">On rising up in the morning</option>
<option value="After meals">After meals</option>
<option value="At night">At night</option>
</select>
<div class="clear"></div>

<label class="lable262">Method of cleaning teeth at present:</label>
<select name="teethAtPresent" id="teethAtPresent" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Tooth brush">Tooth brush</option>
<option value="Finger cleaning">Finger cleaning</option>
<option value="Others">Others</option>
</select>
<div class="clear"></div>

<label class="lable262">At what age was tooth brushing initiated?</label>
<input type="text" name="brushingInitiated" id="brushingInitiated" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1">
<div class="clear"></div>

<label class="lable262">When did the child start brushing on his own?</label>
<input type="text" name="childStartBrushing" id="childStartBrushing" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable262">Is the child's brushing supervised?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="brushingSupervised" id="brushingSupervised" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="brushingSupervised" id="brushingSupervised" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Frequency of Brushing</h4>
<div class="clear"></div>

<label>Time</label>
<input type="text" name="timeFrequency" id="time" maxlength="5" tabindex="1" validate="Time,num,no">
<label>Method</label>
<input type="text" name="methodFrequency" id="method" maxlength="128" tabindex="1">

<div class="clear"></div>
<label>Type of paste used</label>
<input type="text" name="typeOfPasteUsed" id="typeOfPasteUsed" maxlength="128" tabindex="1">

<div class="clear"></div>
<label class="auto">Does the child rinse the mouth after taking any food / drinks / sugary medications?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="sugaryMedications" id="sugaryMedications" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="sugaryMedications" id="sugaryMedications" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>DIET HISTORY</h4>
<div class="clear"></div>

<label>Dietary Habit</label>
<label class="auto">Vegetarian</label>
<input tabindex="1" name="dietaryHabit" id="dietaryHabit" value="Vegetarian" type="radio" class="radiobutMargin">
<label class="auto">Non-Vegetarian</label>
<input tabindex="1" name="dietaryHabit" id="dietaryHabit" value="Non-Vegetarian" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="auto">Does the child have the habit of frequent snacking?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="frequentSnacking" id="frequentSnacking" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="frequentSnacking" id="frequentSnacking" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Favourite Foods</label>
<input type="text" name="favouriteFoods" id="favouriteFoods" maxlength="128" tabindex="1">

<div class="clear"></div>

<h4>DIET RECORDING CHART-24 HOUR RECALL</h4>
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForDietRecordChart();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForDietRecordChart();" type="button">
</div>
<div class="clear"></div>
<div class="clear"></div>
<div  class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridDiet">
  <tbody>
    <tr>
    	<th colspan="1" style="text-align: center;"></th>
      <th colspan="2" style="text-align: center;">Breakfast</th>
      <th colspan="2" style="text-align: center;">Snacks</th>
      <th colspan="2" style="text-align: center;">Lunch</th>
      <th colspan="2" style="text-align: center;">Snacks</th>
      <th colspan="2" style="text-align: center;">Dinner</th>
      <th colspan="2" style="text-align: center;">Before bed</th>
    </tr>
    <tr>
    <th> </th>
      <th> Type &amp; Quantity</th>
      <th>Preparation</th>
      <th>Type & Quantity</th>
      <th>Preparation</th>
      <th>Type & Quantity</th>
      <th>Preparation</th>
      <th>Type & Quantity</th>
      <th>Preparation</th>
      <th>Type & Quantity</th>
      <th>Preparation</th>
      <th>Type & Quantity</th>
      <th>Preparation</th>
    </tr>
       <% int incDiet=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="dietRadio<%=incDiet%>" name="dietRadio<%=incDiet%>"></td>
  
      <td><input name="breakfastTypeQuantity<%=incDiet %>" id="breakfastTypeQuantity<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="breakfastPreparation<%=incDiet %>" id="breakfastPreparation<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="snacksTypeQuantity<%=incDiet %>" id="snacksTypeQuantity<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="snacksPreparation<%=incDiet %>" id="snacksPreparation<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="lunchTypeQuantity<%=incDiet %>" id="lunchTypeQuantity<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="lunchPreparation<%=incDiet %>" id="lunchPreparation<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="snacksTypeQuantityOne<%=incDiet %>" id="snacksTypeQuantityOne<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="snacksPreparationOne<%=incDiet %>" id="snacksPreparationOne<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dinnerTypeQuantity<%=incDiet %>" id="dinnerTypeQuantity<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dinnerPreparation<%=incDiet %>" id="dinnerPreparation<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="beforeBedQuantity<%=incDiet %>" id="beforeBedQuantity<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="beforeBedPreparation<%=incDiet %>" id="beforeBedPreparation<%=incDiet %>" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
  </tbody>
</table>

</div>
<input type="hidden" name="hdbDiet" value="<%=incDiet%>" id="hdbDiet" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>DIET ANALYSIS</h4>
<div class="clear"></div>

<div  class="tableForTabNumber">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <th>Food Group</th>
      <th colspan="6">Food Consumptions in Serving</th>
      <th>Total Consumption In a Day</th>
      <th>Daily Recommended Servings</th>
      <th>Difference<br/> +ve : more<br/> -ve : Less</th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><strong>1</strong></td>
      <td><strong>2</strong></td>
      <td><strong>3</strong></td>
      <td><strong>4</strong></td>
      <td><strong>5</strong></td>
      <td><strong>6</strong></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <%int i = 1; %>
    <tr>
      <td><input name="foodGroup<%=i%>" value="Milk and Milk Products" type="hidden"/> <strong>Milk and Milk Products</strong></td>
      <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTwo<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <% i++; %>
    <tr>
      
   <td><input name="foodGroup<%=i%>" value="Meat Poultry" type="hidden"/> <strong>Meat Poultry</strong></td>
    <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTwo<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
       <% i++; %>
    <tr>
      
   <td><input name="foodGroup<%=i%>" value="Vegetable Fruits" type="hidden"/> <strong>Vegetable Fruits</strong></td>
    <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTwo<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
        <% i++; %>
    <tr>
 
   <td><input name="foodGroup<%=i%>" value="Bread Cereal" type="hidden"/> <strong>Bread Cereal</strong></td>
    <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTio<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
        <% i++; %>
    <tr>

   <td><input name="foodGroup<%=i%>" value="Detergent Food" type="hidden"/> <strong>Detergent Food</strong></td>
    <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTwo<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
        <% i++; %>
    <tr>
      <td><input name="foodGroup<%=i%>" value="Sugar Equivalents" type="hidden"/> <strong>Sugar Equivalents</strong></td>
    <td><input name="foodConsumptionsInServingOne<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingTwo<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingThree<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFour<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingFive<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="foodConsumptionsInServingSix<%=i%>" id="" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"></td>
      <td><input name="totalConsumption<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="dailyRecommendedServings<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
      <td><input name="difference<%=i%>" id="" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
        <% i++; %>
  </tbody>
</table>
<input type="hidden" name="hdbDietAnalysis" value="<%=i%>" id="hdbDietAnalysis" />

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


<h4>CARIOGENICITY OF FOOD</h4>
<div class="clear"></div>

<div  class="tableForTabNumber">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <th>Type Of Food</th>
      <th>Frequency</th>
      <th>Total Exposures</th>
    </tr>
    <tr>
      <td rowspan="3"><strong>Sugars in Solution</strong></td>
      <td><div style="float:left; width:110px;">During Meals :</div> <input name="sugarsInSolutionDM" id="sugarsInSolutionDM" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="sugarsInSolutionDMTotalExposures" id="sugarsInSolutionDMTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <tr>
      <td><div style="float:left; width:110px;">Between  Meals:</div> <input name="sugarsInSolutionBM" id="sugarsInSolutionBM" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="sugarsInSolutionBMTotalExposures" id="sugarsInSolutionBMTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <tr>
      <td><div style="float:left; width:110px;">At bed time:</div> <input name="sugarsInSolutionABT" id="sugarsInSolutionABT" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="sugarsInSolutionABTTotalExposures" id="sugarsInSolutionABTTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <tr>
      <td rowspan="3"><strong>Solid retentive Food containing sugars</strong></td>
      <td><div style="float:left; width:110px;">During Meals:</div> <input name="solidRetentiveDM" id="solidRetentiveDM" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="solidRetentiveDMTotalExposures" id="solidRetentiveDMTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <tr>
      <td><div style="float:left; width:110px;">Between  Meals:</div> <input name="solidRetentiveBM" id="solidRetentiveBM" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="solidRetentiveBMTotalExposures" id="solidRetentiveBMTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
    <tr>
      <td><div style="float:left; width:110px;">At bed time:</div> <input name="solidRetentiveABT" id="solidRetentiveABT" value="" class="small" size="20" maxlength="45" type="text"></td>
      <td><input name="solidRetentiveABTTotalExposures" id="solidRetentiveABTTotalExposures" value="" class="opdTextBoxSmall" size="20" maxlength="45" type="text"></td>
    </tr>
  </tbody>
</table>

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


<h4>DENTAL HISTORY</h4>
<div class="clear"></div>

<label class="lable348">Is this the child's first dental visit?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="firstDentalVisit" id="firstDentalVisit" value="Yes" type="radio" class="radiobutMargin" onchange="displayDentalVisitValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="firstDentalVisit" id="firstDentalVisit" value="No" type="radio" style="margin-right:21px;" onchange="displayDentalVisitValue(this.value);">
<div class="clear"></div>


<div style="display:none" id="dentalvisitNoDiv">
<label class="auto">If no, when was the last visit?</label>
<input type="text" name="theLastVisit" id="theLastVisit" maxlength="128" tabindex="1">
<label>Reason for the last visit</label>
<input type="text" name="theLastVisit" id="theLastVisit" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>




<label class="lable348">Has the child ever had any unpleasant dental experience</label>
<label class="auto">Yes</label>
<input tabindex="1" name="unpleasantDentalExperience" id="unpleasantDentalExperience" value="Yes" type="radio" class="radiobutMargin" onchange="displayDentalExperienceValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="unpleasantDentalExperience" id="unpleasantDentalExperience" value="No" type="radio" style="margin-right:21px;" onchange="displayDentalExperienceValue(this.value);">
</div>

<div class="clear"></div>
<div style="display:none" id="dentalExperienceYesDiv">
<label>If yes, Explain</label>
<input type="text" name="ifYesExplain" id="ifYesExplain" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>
<label class="lable348">Does the child have fear of dentist</label>
<label class="auto">Yes</label>
<input tabindex="1" name="fearOfDentist" id="fearOfDentist" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="fearOfDentist" id="fearOfDentist" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label class="lable348">Did the child have any fluoride treatmennt done before?</label>
<input type="text" name="fluorideTreatmennt" id="fluorideTreatmennt" maxlength="128" tabindex="1">
<div class="clear"></div>
<label class="lable348">Does the child complain of tooth ache?</label>
<select name="childComplainOfToothAche" id="childComplainOfToothAche" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="No">No</option>
<option value="Sometimes">Sometimes</option>
<option value="Often">Often</option>
</select>
<div class="clear"></div>
<label class="lable348">If yes, has it affected his food habits and sleep?</label>
<input type="text" name="foodHabitsAndSleep" id="foodHabitsAndSleep" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Pain</label>
<select name="pain" id="pain" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Discomfort">Discomfort</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>
<label class="auto">Aggravating / Relieving factors</label>
<input type="text" name="aggravatingRelievingFactors" id="aggravatingRelievingFactors" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tenderness</label>
<label class="auto">Yes</label>
<input tabindex="1" name="tenderness" id="tenderness" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="tenderness" id="tenderness" value="No" type="radio" style="margin-right:21px;">

<label>Previous Treatment</label>
<input type="text" name="previousTreatment" id="previousTreatment" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable348">Has the child suffered any injury to teeth?</label>
<label class="auto">Yes</label>
<input tabindex="1" name="injuryToTeeth" id="injuryToTeeth" value="Yes" type="radio" class="radiobutMargin" onchange="displayInjuryToTeethValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="injuryToTeeth" id="injuryToTeeth" value="No" type="radio" style="margin-right:21px;" onchange="displayInjuryToTeethValue(this.value);">
<div style="display:none" id="injuryToTeethYesDiv">
<label>If yes, brief history</label>
<input type="text" name="ifYesBriefHistory" id="ifYesBriefHistory" maxlength="128" tabindex="1">
<div class="clear"></div>


<label>When did it happen?</label>
<input type="text" name="whenDidItHappen" id="whenDidItHappen" maxlength="128" tabindex="1">

<label>How did it happen?</label>
<input type="text" name="howDidItHappen" id="howDidItHappen" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Where did it happen?</label>
<input type="text" name="whereDidItHappen" id="whereDidItHappen" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label class="lable348">Road Traffic Accident (RTA) / Medico legal case (MLC)</label>
<input type="text" name="medicoLegalCase" id="medicoLegalCase" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Does your child have any of the following abnormal habits?</h4>
<div class="clear"></div>

<label>Mouth breathing</label>
<label class="auto">Yes</label>
<input tabindex="1" name="mouthBreathing" id="mouthBreathing" value="Yes" type="radio" class="radiobutMargin" onchange="displayMouthBreathingValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="mouthBreathing" id="mouthBreathing" value="No" type="radio" style="margin-right:21px;" onchange="displayMouthBreathingValue(this.value);">
<div style="display:none" id="mouthBreathingDiv">
<input type="text" name="mouthBreathingValue" id="mouthBreathingValue" maxlength="128" tabindex="1">
</div>

<label>Tongue Thrusting</label>
<label class="auto">Yes</label>
<input tabindex="1" name="tongueThrusting" id="tongueThrusting" value="Yes" type="radio" class="radiobutMargin" onchange="displayTongueThrustingValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="tongueThrusting" id="tongueThrusting" value="No" type="radio" style="margin-right:21px;" onchange="displayTongueThrustingValue(this.value);">
<div style="display:none" id="tongueThrustingDiv">
<input type="text" name="tongueThrustingValue" id="tongueThrustingValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Thumb / Finger sucking</label>
<label class="auto">Yes</label>
<input tabindex="1" name="thumbFingerSucking" id="thumbFingerSucking" value="Yes" type="radio" class="radiobutMargin" onchange="displayThumbFingerSuckingValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="thumbFingerSucking" id="thumbFingerSucking" value="No" type="radio" style="margin-right:21px;" onchange="displayThumbFingerSuckingValue(this.value);">
<div style="display:none;" id="thumbFingerSuckingDiv">
<label class="auto">Duration</label>
<input type="text" name="thumbDuration" id="thumbDuration" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" validate="Duration,num,no" class="small">
<label class="auto">Frequency</label>
<input type="text" name="thumbFrequency" id="thumbFrequency" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" validate="Frequency,num,no" class="small">
<label class="auto">Intensity</label>
<input type="text" name="thumbIntensity" id="thumbIntensity" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" validate="Intensity,num,no" class="small">
</div>
<div class="clear"></div>

<label>Lip biting / Sucking</label>
<label class="auto">Yes</label>
<input tabindex="1" name="lipBitingSucking" id="lipBitingSucking" value="Yes" type="radio" class="radiobutMargin" onchange="displayLipBitingSuckingValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="lipBitingSucking" id="lipBitingSucking" value="No" type="radio" style="margin-right:21px;" onchange="displayLipBitingSuckingValue(this.value);">
<div style="display:none;" id="lipBitingSuckingDiv">
<label class="auto">Duration</label>
<input type="text" name="lipBitingDuration" id="lipBitingDuration" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Nail biting</label>
<label class="auto">Yes</label>
<input tabindex="1" name="nailBiting" id="nailBiting" value="Yes" type="radio" class="radiobutMargin" onchange="displayNailBitingValue(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="nailBiting" id="nailBiting" value="No" type="radio" style="margin-right:21px;" onchange="displayNailBitingValue(this.value);">
<div style="display:none;"  id="nailBitingDiv">
<label class="auto">Duration</label>
<input type="text" name="nailBitingDuration" id="nailBitingDuration" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Other Habits</label>
<input type="text" name="otherHabits" id="otherHabits" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable348">What measures were taken to make the child stop the habit?</label>
<input type="text" name="childStopTheHabit" id="childStopTheHabit" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="lable348">Source of drinking water</label>
<input type="text" name="sourceOfDrinkingWater" id="sourceOfDrinkingWater" maxlength="128" tabindex="1">
<div class="clear"></div>
<label class="lable348">Area of residing for the last few years</label>
<input type="text" name="lastFewYears" id="lastFewYears" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>CLINICAL EXAMINATION</h4>
<div class="clear"></div>
<h4>General Examination</h4>
<div class="clear"></div>

<label>Height</label>
<input id="height" name="heightOne" class="inputSmall"  maxlength="5" tabindex="1"  tabindex="1" type="text"onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" >
<label class="smallAuto autoSpace">cms</label>
<label style="width:117px;">Weight</label>
<input id="weight" name="weightOne" class="inputSmall"  maxlength="5" tabindex="1"  tabindex="1" type="text"  onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<label class="smallAuto autoSpace">kgs</label>
<div class="clear"></div>

<label>Somatotype</label>
<input id="somatotype" name="somatotype" class="inputSmall"  maxlength="5" tabindex="1" validate="Somatotype,num,no" tabindex="1" type="text">
<label>Gait</label>
<input id="gait" name="gait" class="inputSmall"  maxlength="5" tabindex="1" validate="Gait,num,no" tabindex="1" type="text">
<label>Posture</label>
<input id="posture" name="posture" class="inputSmall"  maxlength="5" tabindex="1" validate="Posture,num,no" tabindex="1" type="text">
<div class="clear"></div>

<label>Pulse Rate</label>
<input id="pulseRate" name="pulseRate" class="inputSmall"  maxlength="5" tabindex="1"  tabindex="1" type="text" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<label>Respiratory Rat</label>
<input id="respiratoryRat" name="respiratoryRat" class="inputSmall"  maxlength="5" tabindex="1"  tabindex="1" type="text" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<label>Temperature</label>
<input id="temperature" name="temperature" class="inputSmall"  maxlength="5" tabindex="1" tabindex="1" type="text"  onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)">
<div class="clear"></div>

<h4>Extraoral Examination</h4>
<div class="clear"></div>

<label>Hair</label>
<label class="auto">Normal</label>
<input tabindex="1" name="hair" id="hair" value="Normal" type="radio" class="radiobutMargin" onchange="displayHairNormalValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="hair" id="hair" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displayHairNormalValue(this.value);">
<div style="display:none;" id="hairNormalDiv" >
<input type="text" name="hairValue" id="hair" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="hairDuration" id="hairDuration" maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>

<label>Skin</label>
<label class="auto">Normal</label>
<input tabindex="1" name="skin" id="skin" value="Normal" type="radio" class="radiobutMargin" onchange="displaySkinNormalValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="skin" id="skin" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displaySkinNormalValue(this.value);">
<div style="display:none;" id="skinNormalDiv">
<input type="text" name="skinValue" id="skin" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="skinDuration" id="skinDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>

<label>Nails</label>
<label class="auto">Normal</label>
<input tabindex="1" name="nails" id="nails" value="Normal" type="radio" class="radiobutMargin" onchange="displayNailsNormal(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="nails" id="nails" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displayNailsNormal(this.value);">
<div style="display:none;" id="nailsNormalDiv">
<input type="text" name="nailsValue" id="nails" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="nailsDuration" id="nailsDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>

<label>Eyes</label>
<label class="auto">Normal</label>
<input tabindex="1" name="eyes" id="eyes" value="Normal" type="radio" class="radiobutMargin" onchange="displayEyesNormal(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="eyes" id="eyes" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displayEyesNormal(this.value);">
<div style="display:none;" id="eyesValueDiv">
<input type="text" name="eyesValue" id="eyes" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="eyesDuration" id="eyesDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>

<label>Ears</label>
<label class="auto">Normal</label>
<input tabindex="1" name="ears" id="ears" value="Normal" type="radio" class="radiobutMargin" onchange="displayEarsNormal(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="ears" id="ears" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displayEarsNormal(this.value);">
<div style="display:none;" id="earsNormalDiv">
<input type="text" name="earsValue" id="ears" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="earsDuration" id="earsDuration" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>

<label>Nose</label>
<label class="auto">Normal</label>
<input tabindex="1" name="nose" id="nose" value="Normal" type="radio" class="radiobutMargin" onchange="displayNoseNormal(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="nose" id="nose" value="Abnormal" type="radio" style="margin-right:26px;" onchange="displayNoseNormal(this.value);">
<div style="display:none;" id="noseNormalDiv">
<input type="text" name="noseValue" id="nose" maxlength="128" tabindex="1">
<label class="auto">Duration</label>
<input type="text" name="noseDuration" id="noseDuration" onPaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" validate="Duration,num,no" class="small">
</div>
<div class="clear"></div>
<label>Regional Lymphnodes</label>
<input type="text" name="regionalLymphnodes" id="regionalLymphnodes" maxlength="128" tabindex="1">

<label>Shape of The Head</label>
<select name="shapeOfTheHead" id="shapeOfTheHead" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mesocephalic">Mesocephalic</option>
<option value="Dolichocephalic">Dolichocephalic</option>
<option value="Brachycephalic">Brachycephalic</option>
</select>
<div class="clear"></div>

<label>Facial Form</label>
<select name="facialForm" id="facialForm" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Square">Square</option>
<option value="Oval">Oval</option>
<option value="Round">Round</option>
</select>

<label>Facial Symmetry</label>
<label class="auto">Symmetrical</label>
<input tabindex="1" name="facialSymmetry" id="facialSymmetry" value="Symmetrical" type="radio" class="radiobutMargin">
<label class="auto">Asymmetrical</label>
<input tabindex="1" name="facialSymmetry" id="facialSymmetry" value="Asymmetrical" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Facial Profile</label>
<select name="facialProfile" id="facialProfile" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Straight">Straight</option>
<option value="Convex">Convex</option>
<option value="Concave">Concave</option>
<option value="Low FMA">Low FMA</option>
<option value="Average FMA">Average FMA</option>
<option value="High FMA">High FMA</option>
</select>
<label>Lower Facial Height (LFH)</label>
<select name="lowerFacialHeight" id="lowerFacialHeight" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Large">Large</option>
<option value="Average">Average</option>
<option value="Small">Small</option>
</select>
<div class="clear"></div>

<label>Upper Lip</label>
<select name="upperLip" id="upperLip" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Short">Short</option>
<option value="Everted">Everted</option>
<option value="Protrusive">Protrusive</option>
<option value="Repaired">Repaired</option>
</select>
<label>Lower Lip</label>
<select name="lowerLip" id="lowerLip" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Pronounced Supramental groove">Pronounced Supramental groove</option>
<option value="Everted">Everted</option>
<option value="Protrusive">Protrusive</option>
<option value="Behind max. Incisors">Behind max. Incisors</option>
<option value="Resting on max. Incisors">Resting on max. Incisors</option>
</select>
<div class="clear"></div>

<label>Lips</label>
<select name="lips" id="lips" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Competent">Competent</option>
<option value="Potentially competent">Potentially competent</option>
<option value="Incompetent">Incompetent</option>
</select>
<label>Lip Tonicity</label>
<select name="lipTonicity" id="lipTonicity" tabindex="1" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Normal">Normal</option>
<option value="Hypertonic">Hypertonic</option>
<option value="Hypotonic">Hypotonic</option>
</select>
<div class="clear"></div>

<label>Lip Line</label>
<select name="lipLine" id="lipLine" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Low">Low</option>
<option value="Normal">Normal</option>
<option value="High">High</option>
</select>
<label>Swallowing</label>
<select name="swallowing" id="swallowing" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Teeth together">Teeth together</option>
<option value="Tongue to lower lip">Tongue to lower lip</option>
<option value="Infantile type">Infantile type</option>
<option value="Tongue thrust">Tongue thrust</option>
</select>
<div class="clear"></div>

<label>Speech</label>
<label class="auto">Normal</label>
<input tabindex="1" name="speech" id="speech" value="Normal" type="radio" class="radiobutMargin">
<label class="auto">Defective</label>
<input tabindex="1" name="speech" id="speech" value="Defective" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>TMJ & Mandible</h4>
<div class="clear"></div>

<label>Normal Movement</label>
<input name="normalMovement" id="normalMovement" tabindex="62"  maxlength="25" type="checkbox" class="radiobutMargin" onchange="displayNormalMovementValue();">
<div style="display:none" id="normalMovementDiv">
<input type="text" name="normalMovementValue" id="normalMovementValue" maxlength="128" tabindex="1">
</div>

<label>Clicking</label>
<input name="clicking" id="clicking" tabindex="62"  maxlength="25" type="checkbox" class="radiobutMargin" onchange="displayClickingValue();">
<div style="display:none" id="clickingDiv">
<input type="text" name="clickingValue" id="clickingValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Crepitus</label>
<input name="crepitus" id="crepitus" tabindex="62"  maxlength="25" type="checkbox" class="radiobutMargin" onchange="displayCrepitusValue();">
<div style="display:none" id="crepitusDiv">
<input type="text" name="crepitusValue" id="crepitusValue" maxlength="128" tabindex="1">
</div>

<label>Anterior Displacement</label>
<input name="anteriorDisplacement" id="anteriorDisplacement" tabindex="62"  maxlength="25" type="checkbox" class="radiobutMargin" onchange="displayAnteriorDisplacementValue();">
<div style="display:none" id="anteriorDisplacementDiv">
<input type="text" name="anteriorDisplacementValue" id="anteriorDisplacementValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<label>Posterior Displacement</label>
<input name="posteriorDisplacement" id="posteriorDisplacement" tabindex="62"  maxlength="25" type="checkbox" class="radiobutMargin" onchange="displayPosteriorDisplacementValue();">
<div style="display:none" id="posteriorDisplacementDiv">
<input type="text" name="posteriorDisplacementValue" id="posteriorDisplacementValue" maxlength="128" tabindex="1">
</div>

<label>Premature Contact On</label>
<input type="text" name="prematureContactOn" id="prematureContactOn" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Intraoral Examination</label>
<input type="text" name="intraoralExamination" id="intraoralExamination" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Soft Tissue Examination</h4>
<div class="clear"></div>


<label>Mucosa</label>
<label class="auto">Normal</label>
<input tabindex="1" name="mucosa" id="mucosa" value="Normal" type="radio" class="radiobutMargin" onchange="displayMucosaValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="mucosa" id="mucosa" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayMucosaValue(this.value);">
<div style="display:none;" id="mucosaDiv">
<label class="auto">Lesion</label>
<input type="text" name="mucosaLesion" id="mucosaLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="mucosaSite" id="mucosaSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="mucosaSize" id="mucosaSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="mucosaDuration" id="mucosaDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Palate</label>
<label class="auto">Normal</label>
<input tabindex="1" name="palate" id="palate" value="Normal" type="radio" class="radiobutMargin" onchange="displayPalateValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="palate" id="palate" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayPalateValue(this.value);">

<div style="display:none;" id="palateDiv">
<label class="auto">Lesion</label>
<input type="text" name="palateLesion" id="palateLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="palateSite" id="palateSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="palateSize" id="palateSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="palateDuration" id="palateDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Pharynx</label>
<label class="auto">Normal</label>
<input tabindex="1" name="pharynx" id="pharynx" value="Normal" type="radio" class="radiobutMargin" onchange="displayPharynxValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="pharynx" id="pharynx" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayPharynxValue(this.value);">

<div style="display:none;" id="pharynxDiv">
<label class="auto">Lesion</label>
<input type="text" name="pharynxLesion" id="pharynxLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="pharynxSite" id="pharynxSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="pharynxSize" id="pharynxSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="pharynxDuration" id="pharynxDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Floor of the Mouth</label>
<label class="auto">Normal</label>
<input tabindex="1" name="floorOfTheMouth" id="floorOfTheMouth" value="Normal" type="radio" class="radiobutMargin" onchange="displayFloorOfTheMouthValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="floorOfTheMouth" id="floorOfTheMouth" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayFloorOfTheMouthValue(this.value);">

<div style="display:none;" id="floorOfTheMouthDiv">
<label class="auto">Lesion</label>
<input type="text" name="floorOfTheMouthLesion" id="floorOfTheMouthLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="floorOfTheMouthSite" id="floorOfTheMouthSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="floorOfTheMouthSize" id="floorOfTheMouthSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="floorOfTheMouthDuration" id="floorOfTheMouthDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Tongue</label>
<label class="auto">Normal</label>
<input tabindex="1" name="tongue" id="tongue" value="Normal" type="radio" class="radiobutMargin" onchange="displayTongueValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="tongue" id="tongue" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayTongueValue(this.value);">

<div style="display:none;" id="tongueDiv">
<label class="auto">Lesion</label>
<input type="text" name="tongueLesion" id="tongueLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="tongueSite" id="tongueSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="tongueSize" id="tongueSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="tongueDuration" id="tongueDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" validate="Duration,num,no" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Frenal Attachments</label>
<label class="auto">Normal</label>
<input tabindex="1" name="frenalAttachments" id="frenalAttachments" value="Normal" type="radio" class="radiobutMargin" onchange="displayFrenalAttachmentsValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="frenalAttachments" id="frenalAttachments" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayFrenalAttachmentsValue(this.value);">

<div style="display:none;" id="frenalAttachmentsDiv">
<label class="auto">Lesion</label>
<input type="text" name="frenalAttachmentsLesion" id="frenalAttachmentsLesion" maxlength="128" tabindex="1" class="small">
<label class="auto">Site</label>
<input type="text" name="frenalAttachmentsSite" id="frenalAttachmentsSite" maxlength="128" tabindex="1" class="small">
<label class="auto">Size</label>
<input type="text" name="frenalAttachmentsSize" id="frenalAttachmentsSize" maxlength="128" tabindex="1" class="small">
<label class="auto">Duration</label>
<input type="text" name="frenalAttachmentsDuration" id="frenalAttachmentsDuration"  maxlength="5" tabindex="1" onPaste="return false" onkeypress="javascript:return isNumber(event)" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label>Gingiva</label>
<label class="auto">Normal</label>
<input tabindex="1" name="gingiva" id="gingiva" value="Normal" type="radio" class="radiobutMargin" onchange="displayGingivaValue(this.value);">
<label class="auto">Abnormal</label>
<input tabindex="1" name="gingiva" id="gingiva" value="Abnormal" type="radio" class="radiobutMargin" onchange="displayGingivaValue(this.value);">

<div style="display:none;" id="gingivaDiv">
<label class="auto">Colour</label>
<input type="text" name="gingivaColour" id="gingivaColour" maxlength="128" tabindex="1" class="small">
<label class="auto">Consistency</label>
<input type="text" name="gingivaConsistency" id="gingivaConsistency" maxlength="128" tabindex="1" class="small">
<label class="auto">Texture</label>
<input type="text" name="gingivaTexture" id="gingivaTexture" maxlength="128" tabindex="1" class="small">
<div class="clear"></div>

<label class="auto">Bleeding</label>
<input type="text" name="gingivaBleeding" id="gingivaBleeding" maxlength="128" tabindex="1" class="small">
<label class="auto">Any Other</label>
<input type="text" name="gingivaAnyOther" id="gingivaAnyOther" maxlength="128" tabindex="1" class="small">
</div>
<div class="clear"></div>

<label class="auto">Gingival Index (Loe and Silness)</label>
<input type="text" name="gingivalIndex" id="gingivalIndex" maxlength="128" tabindex="1" style="width:156px;">
<label>Score</label>
<input type="text" name="score" id="score" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Gingivities</label>
<select name="gingivities" id="gingivities" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="No">No</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>
<label>Saliva</label>
<label class="auto">Serous</label>
<input tabindex="1" name="saliva" id="saliva" value="Serous" type="radio" class="radiobutMargin">
<label class="auto">Viscous</label>
<input tabindex="1" name="saliva" id="saliva" value="Viscous" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Plaque Index (Silness & Loe)</label>
<input type="text" name="plaqueIndex" id="plaqueIndex" maxlength="128" tabindex="1">
<label>Score</label>
<input type="text" name="scoreOne" id="scoreOne" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Oral Hygiene</label>
<select name="oralHygiene" id="oralHygiene" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Fair">Fair</option>
<option value="Poor">Poor</option>
</select>

<label>Saliva</label>
<label class="auto">Yes</label>
<input tabindex="1" name="salivaOne" id="salivaOne" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="salivaOne" id="salivaOne" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Hard Tissue Examination</h4>
<div class="clear"></div>

<label class="auto">Eruption Status (FDI System)</label>
<input type="text" name="eruptionStatus" id="eruptionStatus" maxlength="128" tabindex="1" style="width:173px">

<label>Dental Stage</label>
<select name="dentalStage" id="dentalStage" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Gum Pads">Gum Pads</option>
<option value="Primary dentition">Primary dentition</option>
<option value="Early Mixed dentition">Early Mixed dentition</option>
<option value="Mixed dentition">Mixed dentition</option>
<option value="Late mixed dentition">Late mixed dentition</option>
<option value="Permanent dentition">Permanent dentition</option>
</select>
<div class="clear"></div>

<h4>Caries Status</h4>
<div class="clear"></div>

<label>Incipient Lession</label>
<input type="text" name="incipientLession" id="incipientLession" maxlength="128" tabindex="1">
<label>Enamel Caries</label>
<input type="text" name="enamelCaries" id="enamelCaries" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Dentinal Caries</label>
<input type="text" name="dentinalCaries" id="dentinalCaries" maxlength="128" tabindex="1">
<label>Arrested Caries</label>
<input type="text" name="arrestedCaries" id="arrestedCaries" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Pulp Exposure</label>
<input type="text" name="pulpExposure" id="pulpExposure" maxlength="128" tabindex="1">
<label class="auto">Pulp exposure with periapical pathology</label>
<input type="text" name="periapicalPathology" id="periapicalPathology" maxlength="128" tabindex="1" style="width:112px;">
<div class="clear"></div>

<label>Root Stumps</label>
<input type="text" name="rootStumps" id="rootStumps" maxlength="128" tabindex="1">
<label>Retained Teeth</label>
<input type="text" name="retainedTeeth" id="retainedTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Fractured Teeth</label>
<input type="text" name="fracturedTeeth" id="fracturedTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Mobility</h4>
<div class="clear"></div>

<label>Physiologic (Preshedding)</label>
<input type="text" name="physiologic" id="physiologic" maxlength="128" tabindex="1">
<label>Pathologic</label>
<select name="pathologic" id="pathologic" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Grade I">Grade I</option>
<option value="Grade II">Grade II</option>
<option value="Grade III">Grade III</option>
</select>
<div class="clear"></div>

<label>Congenitally Missing Teeth</label>
<input type="text" name="congenitallyMissingTeeth" id="congenitallyMissingTeeth" maxlength="128" tabindex="1">
<label>Ectopic Eruption</label>
<input type="text" name="ectopicEruption" id="ectopicEruption" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Discolouration of Teeth</label>
<input type="text" name="discolourationOfTeeth" id="discolourationOfTeeth" maxlength="128" tabindex="1">
<label>Supernumerary Teeth</label>
<input type="text" name="supernumeraryTeeth" id="supernumeraryTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="auto">Any Other Dental Anomalies</label>
<input type="text" name="dentalAnomalies" id="dentalAnomalies" maxlength="128" tabindex="1" style="width:179px;">
<div class="clear"></div>

<h4>OCCLUSION ANALYSIS</h4>
<div class="clear"></div>

<h4>Incisal relationship</h4>
<div class="clear"></div>

<label>Overjet</label>
<input id="overjet" name="overjet"  maxlength="5" tabindex="1"  onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" type="text" style="width:148px;">
<label class="smallAuto autoSpace">mm</label>
<label>Overbite</label>
<input id="overbite" name="overbite"   maxlength="5" tabindex="1" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" type="text" style="width:148px;">
<label class="smallAuto autoSpace">mm</label>
<div class="clear"></div>

<label>Deep Bite</label>
<select name="deepBite" id="deepBite" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Complete">Complete</option>
<option value="Incomplete">Incomplete</option>
<option value="Traumatic">Traumatic</option>
<option value="Openbite (Anteriors)">Openbite (Anteriors)</option>
</select>
<label>Anterior Cross-Bite</label>
<input type="text" name="anteriorCrossBite" id="anteriorCrossBite" maxlength="128" tabindex="1">
<div class="clear"></div>

<label class="auto">Maxillary Incisor Angulation</label>
<select name="maxillaryIncisorAngulation" id="maxillaryIncisorAngulation" tabindex="1" validate="Service Center,string,no" style="width:184px;">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Procilined">Procilined</option>
<option value="Retroclined">Retroclined</option>
</select>
<label class="auto">Mandibular Incisor Angulation</label>
<select name="mandibularIncisorAngulation" id="mandibularIncisorAngulation" tabindex="1" validate="Service Center,string,no" style="width:172px;">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Procilined">Procilined</option>
<option value="Retroclined">Retroclined</option>
</select>
<div class="clear"></div>

<h4>Primate Space</h4>
<div class="clear"></div>

<label>Maxilla</label>
<label class="auto">Present</label>
<input tabindex="1" name="maxilla" id="maxilla" value="Present" type="radio" class="radiobutMargin">
<label class="auto">Absent</label>
<input tabindex="1" name="maxilla" id="maxilla" value="Absent" type="radio" style="margin-right:21px;">

<label>Mandible</label>
<label class="auto">Present</label>
<input tabindex="1" name="mandible" id="mandible" value="Present" type="radio" class="radiobutMargin">
<label class="auto">Absent</label>
<input tabindex="1" name="mandible" id="mandible" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Diastema</label>
<label class="auto">Present</label>
<input tabindex="1" name="diastema" id="diastema" value="Present" type="radio" class="radiobutMargin" onchange="displayDiastemaValue(this.value);">
<label class="auto">Absent</label>
<input tabindex="1" name="diastema" id="diastema" value="Absent" type="radio" style="margin-right:21px;" onchange="displayDiastemaValue(this.value);">

<div style="display:none" id="diastemaDiv">
<label class="auto">Midline</label>
<input tabindex="1" name="diastemaMidline" id="diastemaMidline" value="Midline" type="radio" class="radiobutMargin">
<label class="auto">Generalised</label>
<input tabindex="1" name="diastemaGeneralised" id="diastemaGeneralised" value="Generalised" type="radio" style="margin-right:21px;">

<label>Probable Cause</label>
<input type="text" name="probableCause" id="probableCause" maxlength="128" tabindex="1" style="width:170px;">
</div>
<div class="clear"></div>

<label class="auto">Midline (relative to midfacial line)</label>
<label>Max</label>
<label class="auto">Deviated</label>
<input tabindex="1" name="max" id="max" value="Deviated" type="radio" class="radiobutMargin">
<label class="auto">No Deviated</label>
<input tabindex="1" name="max" id="max" value="No Deviated" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Mand</label>
<label class="auto">Deviated</label>
<input tabindex="1" name="mand" id="mand" value="Deviated" type="radio" class="radiobutMargin">
<label class="auto">No Deviated</label>
<input tabindex="1" name="mand" id="mand" value="No Deviated" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Canine Relationship</h4>
<div class="clear"></div>

<label>Class I</label>
<label class="auto">RT</label>
<input id="classI" name="classIRT" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="radiobutMargin">
<label class="auto">LT</label>
<input id="classI" name="classIRT" tabindex="62" maxlength="25" type="checkbox" value="Yes"class="radiobutMargin">

<label>Class II</label>
<label class="auto">RT</label>
<input id="classII" name="classIIRT" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="radiobutMargin">
<label class="auto">LT</label>
<input id="classII" name="classIILT" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="radiobutMargin">
<div class="clear"></div>

<label>Class III</label>
<label class="auto">RT</label>
<input id="Class III" name="classIIIRT" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="radiobutMargin">
<label class="auto">LT</label>
<input id="Class III" name="classIIILT" tabindex="62" maxlength="25" type="checkbox" value="Yes" class="radiobutMargin">
<div class="clear"></div>

<h4>Permanent First Molar Relationship	</h4>
<div class="clear"></div>

<label>Right</label>
<select name="rightClass" id="rightClass" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<label>Left</label>
<select name="leftClass" id="leftClass" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<div class="clear"></div>

<h4>Terminal Plane</h4>
<div class="clear"></div>

<label>Right</label>
<select name="terminalPlaneRight" id="terminalPlaneRight" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<label>Left</label>
<select name="terminalPlaneLeft" id="terminalPlaneLeft" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<div class="clear"></div>

<h4>Cross-Bite (Posterior)</h4>
<div class="clear"></div>

<label>Right</label>
<select name="crossBiteRight" id="crossBiteRight" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<label>Left</label>
<select name="crossBiteLeft" id="crossBiteLeft" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="(1/2) Class II Full Unit">(1/2) Class II Full Unit</option>
<option value="Class III">Class III</option>
</select>
<div class="clear"></div>

<label>Openbite (Posterior)</label>
<input id="openbitePosterior" name="openbitePosterior" maxlength="128" tabindex="1" type="text">
<label class="smallAuto autoSpace">specify tooth</label>

<div class="clear"></div>

<h4>Arch Form</h4>
<div class="clear"></div>

<label>Max</label>
<select name="archFormMax" id="archFormMax" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="U shaped">U shaped</option>
<option value="V shaped">V shaped</option>
<option value="Parabolic">Parabolic</option>
<option value="Asymmetrical">Asymmetrical</option>
<option value="Symmetrical">Symmetrical</option>
</select>

<label>Mand</label>
<select name="archFormMand" id="archFormMand" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="U shaped">U shaped</option>
<option value="V shaped">V shaped</option>
<option value="Parabolic">Parabolic</option>
<option value="Asymmetrical">Asymmetrical</option>
<option value="Symmetrical">Symmetrical</option>
</select>
<div class="clear"></div>

<label>Displaced Teeth</label>
<input type="text" name="displacedTeeth" id="displacedTeeth" maxlength="128" tabindex="1">
<label>Rotated Teeth</label>
<input type="text" name="rotatedTeeth" id="rotatedTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Crowding</h4>
<div class="clear"></div>
<h4>Max</h4>
<div class="clear"></div>

<label>Anterior</label>
<select name="maxAnterior" id="maxAnterior" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>

<label>Posterior</label>
<select name="maxPosterior" id="maxPosterior" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>

<div class="clear"></div>

<h4>Mand</h4>
<div class="clear"></div>

<label>Anterior</label>
<select name="mandAnterior" id="mandAnterior" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>

<label>Posterior</label>
<select name="mandPosterior" id="mandPosterior" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>
<div class="clear"></div>

<label class="auto">Premature Loss of Primary Teeth</label>
<input type="text" name="prematureLossOfPrimary" id="prematureLossOfPrimary" maxlength="128" tabindex="1" style="width:150px;">
<label>Space Closure</label>
<input type="text" name="spaceClosure" id="spaceClosure" maxlength="128" tabindex="1">


<div class="clear"></div>
<div class="paddingTop5"></div>



<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

</div>
</form>

<style>
.lable262 {width:266px !important;}
.lable308 {width:310px !important;}
.lable348 {width:348px!important;}
.lable364 {width:364px !important;}
.lable412 {width:416px !important;}
.yesNowWidth{width:65px; height:51px; float:left;}

</style>




