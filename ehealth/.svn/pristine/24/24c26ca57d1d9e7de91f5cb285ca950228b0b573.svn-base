
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>


<div class="titleBg"><h2>Community Oral Health Case History</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="communityOralHealthCaseHistoryFlag" name="communityOralHealthCaseHistoryFlag" tabindex="1" value="communityOralHealthCaseHistoryFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Community Oral Health"/>

<div class="clear"></div>
<h4>Case History</h4>
<div class="clear"></div>


<label>Education</label>
<select name="education" id="education" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Profession or Honours">Profession or Honours</option>
<option value="Graduate OR Post Graduate">Graduate OR Post Graduate</option>
<option value="Intermediate OR Post High School Diploma">Intermediate OR Post High School Diploma</option>
<option value="High School Certificate">High School Certificate</option>
<option value="Middle School Certificate">Middle School Certificate</option>
<option value="Primary School Certificate">Primary School Certificate</option>
<option value="Illiterate">Illiterate</option>
</select>

<label>Occupation</label>
<select name="occupation" id="occupation" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Profession">Profession</option>
<option value="Semi-Profession">Semi-Profession</option>
<option value="Clerical, Shop-Owner, Framer">Clerical, Shop-Owner, Framer</option>
<option value="Skilled Worker">Skilled Worker</option>
<option value="Semi-Skilled Worker">Semi-Skilled Worker</option>
<option value="Unskilled Worker">Unskilled Worker</option>
<option value="Unemployed">Unemployed</option>
</select>
<div class="clear"></div>

<label>Per Capita Income</label>
<select name="perCapitaIncome" id="perCapitaIncome" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="42271-Above">42271-Above</option>
<option value="21361-42720">21361-42720</option>
<option value="16021-21360">16021-21360</option>
<option value="10680-16020">10680-16020</option>
<option value="6408-10679">6408-10679</option>
<option value="2158-6407">2158-6407</option>
<option value="2157-Below">2157-Below</option>
</select>

<label>Socio Economic Status</label>
<select name="socioEconomicStatus" id="socioEconomicStatus" tabindex="1" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Upper">Upper</option>
<option value="Upper Middle">Upper Middle</option>
<option value="Lower Middle">Lower Middle</option>
<option value="Upper Lower">Upper Lower</option>
<option value="Lower">Lower</option>
</select>
<div class="clear"></div>

<label>Place of Birth</label>
<input type="text" name="placeOfBirth" id="placeOfBirth" maxlength="128" tabindex="1">

<label class="auto">Continuous residence from birth to 12 years</label>
<label class="auto">Yes</label>
<input tabindex="1" name="continuousResidence" id="continuousResidence" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="continuousResidence" id="continuousResidence" value="No" type="radio" style="margin-right:21px;">
<div class="clear"></div>


<label>Water Source</label>
<select name="waterSource" id="waterSource" tabindex="1" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Pipe Water">Pipe Water</option>
<option value="Well Water">Well Water</option>
<option value="BoreWell Water">BoreWell Water</option>
</select>

<label>Chief Complaint</label>
<input type="text" name="chiefComplaint" id="chiefComplaint" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>History Of Present Illness</label>
<input type="text" name="historyOfPresentIllness" id="historyOfPresentIllness" maxlength="128" tabindex="1">

<label>Medical History</label>
<input name="medicalHistory" id="medicalHistory" tabindex="62" maxlength="128" value="Yes" class="radiobutMargin" type="checkbox" onclick="showMedicalHistory();">


<div style="display:none" id="medicalHistoryDiv">
<select id="medicalHistoryValue" name="medicalHistoryValue" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="Diabetes">Diabetes</option>
<option value="Respiratory Infections">Respiratory Infections</option>
<option value="Rheumatic Fever">Rheumatic Fever</option>
<option value="Dermatological Disease">Dermatological Disease</option>
<option value="Hepatitis">Hepatitis</option>
<option value="ArthritisArthritis">Arthritis</option>
<option value="Epilepsy">Epilepsy</option>
<option value="Jaundice">Jaundice</option>
<option value="Allery to drugs">Allery to drugs</option>
<option value="Bleeding Disorders">Bleeding Disorders</option>
<option value="Cardiovascular Disease">Cardiovascular Disease</option>
<option value="Recent Hospitalisation">Recent Hospitalisation</option>
</select>
</div>
<div class="clear"></div>

<label>Dental History</label>
<label class="auto">Yes</label>
<input tabindex="1" name="dentalHistory" id="dentalHistory" value="Yes" type="radio" class="radiobutMargin" onclick="dentalHistoryDiv(this.value);" >
<label class="auto">No</label>
<input tabindex="1" name="dentalHistory" id="dentalHistory" value="No" type="radio" style="margin-right:10px;" onclick="dentalHistoryDiv(this.value);" >

<div style="display:none" id="dentalHistoryDiv">
<input type="text" name="dentalHistoryValue" id="dentalHistoryValue" maxlength="128" tabindex="1">
</div>

<div class="clear"></div>

<h4>Personal History</h4>
<div class="clear"></div>

<label>Smoking</label>
<label class="auto">Number</label>
<input type="text" name="smokingNumber" id="smokingNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="smokingFrequency" id="smokingFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="smokingDuration" id="smokingDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="smokingDurationValue" id="smokingDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Tobaco Chewing</label>
<label class="auto">Number</label>
<input type="text" name="tobacoChewingNumber" id="tobacoChewingNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="tobacoChewingFrequency" id="tobacoChewingFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="tobacoChewingDuration" id="tobacoChewingDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="tobacoChewingDurationValue" id="tobacoChewingDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Pan Chewing</label>
<label class="auto">Number</label>
<input type="text" name="panChewingNumber" id="panChewingNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="panChewingFrequency" id="panChewingFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="panChewingDuration" id="panChewingDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="panChewingDurationValue" id="panChewingDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Gutka</label>
<label class="auto">Number</label>
<input type="text" name="gutkaNumber" id="gutkaNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="gutkaFrequency" id="gutkaFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="gutkaDuration" id="gutkaDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="gutkaDurationValue" id="gutkaDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Snuff</label>
<label class="auto">Number</label>
<input type="text" name="snuffNumber" id="snuffNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="snuffFrequency" id="snuffFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="snuffDuration" id="snuffDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="snuffDurationValue" id="snuffDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Betel Nut Chewing</label>
<label class="auto">Number</label>
<input type="text" name="betelNutChewingNumber" id="betelNutChewingNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="betelNutChewingFrequency" id="betelNutChewingFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="betelNutChewingDuration" id="betelNutChewingDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="betelNutChewingDurationValue" id="betelNutChewingDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Alcoholic</label>
<label class="auto">Number</label>
<input type="text" name="alcoholicNumber" id="alcoholicNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="alcoholicFrequency" id="alcoholicFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="alcoholicDuration" id="alcoholicDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="alcoholicDurationValue" id="alcoholicDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label>Drugs</label>
<label class="auto">Number</label>
<input type="text" name="drugsNumber" id="drugsNumber" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="auto">Frequency</label>
<input type="text" name="drugsFrequency" id="drugsFrequency" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<label class="smallAuto autoSpace">per day</label>
<label class="auto">Duration</label>
<input type="text" name="drugsDuration" id="drugsDuration" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small">
<select name="drugsDurationValue" id="drugsDurationValue" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>
<div class="clear"></div>

<label class="auto">Habits Related to Oral Cavity</label>
<label class="auto">Yes</label>
<input tabindex="1" name="habitsRelated" id="habitsRelated" value="Yes" type="radio" class="radiobutMargin" onclick="habitsRelatedDiv(this.value);">
<label class="auto">No</label>
<input tabindex="1" name="habitsRelated" id="habitsRelated" value="No" type="radio" style="margin-right:21px;" onclick="habitsRelatedDiv(this.value);">

<div style="display:none" id="habitsRelatedDiv">
<select id="habitsRelatedValue" name="habitsRelatedValue" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="Mouth Breathing">Mouth Breathing</option>
<option value="Thumb Sucking">Thumb Sucking</option>
<option value="Tongue thrusting">Tongue thrusting</option>
<option value="Bruxism">Bruxism</option>
<option value="Lip biting">Lip biting</option>
<option value="Nail biting">Nail biting</option>
<option value="Pencil biting">Pencil biting</option>
</select>
</div>
<div class="clear"></div>

<h4>Oral Hygiene Practice</h4>
<div class="clear"></div>

<label class="lable190">Type of Cleaning</label>
<label class="lable70">Brush</label>
<input name="typeOfCleaningBrush" id="typeOfCleaningBrush" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Finger</label>
<input name="typeOfCleaningFinger" id="typeOfCleaningFinger" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Stick</label>
<input name="typeOfCleaningStick" id="typeOfCleaningStick" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Any Other</label>
<input name="typeOfCleaningAnyOther" id="typeOfCleaningAnyOther" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<div class="clear"></div>

<label class="lable190">Method of Cleaning</label>
<label class="lable70">Vertical</label>
<input name="methodOfCleaningVertical" id="methodOfCleaningVertical" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Horizontal</label>
<input name="methodOfCleaningHorizontal" id="methodOfCleaningHorizontal" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Circular</label>
<input name="methodOfCleaningCircular" id="methodOfCleaningCircular" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<div class="clear"></div>

<label class="lable190">Materials</label>
<label class="lable70">Tooth Paste</label>
<input name="materialsToothPaste" id="materialsToothPaste" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Powder</label>
<input name="materialsPowder" id="materialsPowder" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Charcoal</label>
<input name="materialsCharcoal" id="materialsCharcoal" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Any Other</label>
<input name="materialsAnyOther" id="materialsAnyOther" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<div class="clear"></div>

<label class="lable190">Frequency of Cleaning/brushing</label>
<label class="lable70">Once</label>
<input name="cleaningBrushingOnce" id="cleaningBrushingOnce" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Twice</label>
<input name="cleaningBrushingTwice" id="cleaningBrushingTwice" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="lable70">Thrice</label>
<input name="cleaningBrushingThrice" id="cleaningBrushingThrice" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="auto">Immediately After Eating</label>
<input name="cleaningBrushingImmediately" id="cleaningBrushingImmediately" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<div class="clear"></div>

<label class="lable190">Any other oral hygiene aids used</label>
<label class="auto">Flossing/inter dental brushing</label>
<input name="flossingInter" id="flossingInter" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<label class="auto">Oral Mouth Rinse</label>
<input name="oralMouthRinse" id="oralMouthRinse" tabindex="62" maxlength="25" value="Yes" class="radiobutMargin" type="checkbox">
<div class="clear"></div>

<h4>Dietary Habits</h4>
<div class="clear"></div>

<label>Dietary</label>
<label class="auto">Vegetarian</label>
<input name="dietary" id="dietary" tabindex="62" maxlength="25" value="Vegetarian" class="radiobutMargin" type="radio">
<label class="auto">Non-Vegetarian</label>
<input name="dietary" id="dietary" tabindex="62" maxlength="25" value="Non-Vegetarian" class="radiobutMargin" type="radio">
<div class="clear"></div>

<h4>Dietary Chart (24 Hrs Recall)</h4>
<div class="clear"></div>

<div class="clear"></div>


<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForDietary();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForDietary();" type="button">
</div>
<div class="clear"></div>

<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridDietary">
  <tbody>
    <tr>
    <th></th>
      <th>Form of Food</th>
      <th>Type of Food</th>
      <th>Time of Intake</th>
      <th>Quantity / Sugar Exposure</th>
      <th>Frequency</th>
      <th>Points</th>
    </tr>
       <% int incDietary=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="dietaryRadio<%=incDietary%>" name="dietaryRadio<%=incDietary%>"></td>
      <td>
 <select name="formOfFood<%=incDietary%>" id="formOfFood<%=incDietary%>" tabindex="1" validate="Service Center,string,no" class="smallest">
<option value="">Select</option>
<option value="Liquids">Liquids</option>
<option value="Solid and Sticky">Solid and Sticky</option>
<option value="Slowly Dissolving">Slowly Dissolving</option>
</select></td>
      <td>
<select name="typeOfFood<%=incDietary%>" id="typeOfFood<%=incDietary%>" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Soft Drinks">Soft Drinks</option>
<option value="Fruit Drinks">Fruit Drinks</option>
<option value="Cocoa Sugar Inbeverages">Cocoa Sugar Inbeverages</option>
<option value="Cake">Cake</option>
<option value="Cupcake">Cupcake</option>
<option value="Sweet Rolls">Sweet Rolls</option>
<option value="Pastries">Pastries</option>
<option value="Coffee Chocolates">Coffee Chocolates</option>
<option value="Caramel">Caramel</option>
<option value="Jelly Jam">Jelly Jam</option>
<option value="Candy">Candy</option>
<option value="Hard Candies">Hard Candies</option>
<option value="Breathmints">Breathmints</option>
<option value="Antacid Tablets">Antacid Tablets</option>
</select>


</td>
      <td><input name="timeOfIntake<%=incDietary%>" id="timeOfIntake<%=incDietary%>" maxlength="128" tabindex="1" class="small" type="text"></td>
      <td><input name="quantitySugarExposure<%=incDietary%>" id="quantitySugarExposure<%=incDietary%>" maxlength="128" tabindex="1" class="small" type="text"></td>
      <td><input name="frequency<%=incDietary%>" id="frequency<%=incDietary%>" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small" type="text"></td>
      <td><input name="points<%=incDietary%>" id="points<%=incDietary%>" onkeypress="javascript:return isNumber(event)" maxlength="5" tabindex="1" class="small" type="text"></td>
    </tr>
  <!--   <tr>
      <td colspan="4">&nbsp;</td>
      <td><strong>Total Score =</strong></td>
      <td>1200XXXX</td>
    </tr> -->
  </tbody>
</table>
</div>
<input type="hidden" name="hdbDietary" value="<%=incDietary%>" id="hdbDietary" />


<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>General Examination</h4>
<div class="clear"></div>

<label>Gait</label>
<input type="text" name="gait" id="gait" maxlength="128" tabindex="1">
<label>Posture</label>
<input type="text" name="posture" id="posture" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Built</label>
<input type="text" name="built" id="built" maxlength="128" tabindex="1">
<label>Nourishment</label>
<input type="text" name="nourishment" id="nourishment" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Local Examination</h4>
<div class="clear"></div>
<h4>Exrta Oral</h4>
<div class="clear"></div>

<label>Symmetry of Face</label>
<input type="text" name="symmetryOfFace" id="symmetryOfFace" maxlength="128" tabindex="1">
<label>Temporomandibular Joint</label>
<input type="text" name="temporomandibularJoint" id="temporomandibularJoint" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Lymph Nodes</label>
<input type="text" name="lymphNodes" id="lymphNodes" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Intra Oral</h4>
<div class="clear"></div>
<h4>Soft Tissue</h4>
<div class="clear"></div>

<label>Lip</label>
<input type="text" name="lip" id="lip" maxlength="128" tabindex="1">
<label>Labical Mucosa</label>
<input type="text" name="labicalMucosa" id="labicalMucosa" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Buccal Mucosa</label>
<input type="text" name="buccalMucosa" id="buccalMucosa" maxlength="128" tabindex="1">
<label>Floor of the Mouth</label>
<input type="text" name="floorOfTheMouth" id="floorOfTheMouth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tounge</label>
<input type="text" name="tounge" id="tounge" maxlength="128" tabindex="1">
<label>Gingiva</label>
<input type="text" name="gingiva" id="gingiva" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Palate</label>
<input type="text" name="palate" id="palate" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Hard Tissue</h4>
<div class="clear"></div>

<label>Type Of Definition</label>
<select name="typeOfDefinition" id="typeOfDefinition" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Deciduous">Deciduous</option>
<option value="Mixed">Mixed</option>
<option value="Permanent">Permanent</option>
</select>
<label>Number of Teeth Present</label>
<input type="text" name="numberOfTeethPresent" id="numberOfTeethPresent" onkeypress="javascript:return isNumber(event)" maxlength="2" tabindex="1">
<div class="clear"></div>

<label class="auto">Teeth Absent and Reason for Loss</label>
<input type="text" name="teethAbsentReasonLoss" id="teethAbsentReasonLoss" maxlength="128" tabindex="1" style="width:146px;">
<label>Dental Caries</label>
<input type="text" name="dentalCaries" id="dentalCaries" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Filled Teeth</label>
<input type="text" name="filledTeeth" id="filledTeeth" maxlength="128" tabindex="1">
<label>Any Prosthesis</label>
<select name="anyProsthesis" id="anyProsthesis" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Crown">Crown</option>
<option value="Bridge">Bridge</option>
<option value="Jacket Crown">Jacket Crown</option>
<option value="RPD">RPD</option>
</select>
<div class="clear"></div>

<label>Wasting Disease</label>
<select name="wastingDisease" id="wastingDisease" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Attrition">Attrition</option>
<option value="Abrasion">Abrasion</option>
<option value="Erosion">Erosion</option>
</select>
<label>Enamel Hypolasia</label>
<input type="text" name="enamelHypolasia" id="enamelHypolasia" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Supernumerary Teeth</label>
<input type="text" name="supernumeraryTeeth" id="supernumeraryTeeth" maxlength="128" tabindex="1">
<label>Malocclusion</label>
<input type="text" name="malocclusion" id="malocclusion" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Occlusal Traumatism</label>
<input type="text" name="occlusalTraumatism" id="occlusalTraumatism" maxlength="128" tabindex="1">
<label>Fractured non Vital Tooth</label>
<input type="text" name="fracturedNonVitalTooth" id="fracturedNonVitalTooth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Stains</label>
<label class="lable70">Extrinsic</label>
<input tabindex="1" name="stains" id="stains" value="Extrinsic" type="radio" class="radiobutMargin">
<label class="lable70">Intrinsic</label>
<input tabindex="1" name="stains" id="stains" value="Intrinsic" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Periodontal Health</h4>
<div class="clear"></div>

<label>Dental Deposits</label>
<label class="lable70">Present</label>
<input tabindex="1" name="dentalDeposits" id="dentalDeposits" value="Present" type="radio" class="radiobutMargin">
<label class="lable70">Absent</label>
<input tabindex="1" name="dentalDeposits" id="dentalDeposits" value="Absent" type="radio" style="margin-right:21px;">

<label>Gingivitis</label>
<label class="lable70">Present</label>
<input tabindex="1" name="gingivitis" id="gingivitis" value="Present" type="radio" class="radiobutMargin">
<label class="lable70">Absent</label>
<input tabindex="1" name="gingivitis" id="gingivitis" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Periodontal Pocket</label>
<label class="lable70">Localized</label>
<input tabindex="1" name="periodontalPocket" id="periodontalPocket" value="Localized" type="radio" class="radiobutMargin">
<label class="lable70">Generalized</label>
<input tabindex="1" name="periodontalPocket" id="periodontalPocket" value="Generalized" type="radio" style="margin-right:21px;">

<label>Mobility of Teeth</label>
<label class="lable70">Present</label>
<input tabindex="1" name="mobilityOfTeeth" id="mobilityOfTeeth" value="Present" type="radio" class="radiobutMargin">
<label class="lable70">Absent</label>
<input tabindex="1" name="mobilityOfTeeth" id="mobilityOfTeeth" value="Absent" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>TREATMENT PLAN/COMPREHENSIVE</h4>
<div class="clear"></div>

<label>Emergency</label>
<input type="text" name="emergency" id="emergency" maxlength="128" tabindex="1">
<label>Promotive</label>
<input type="text" name="promotive" id="promotive" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Preventive</label>
<input type="text" name="preventive" id="preventive" maxlength="128" tabindex="1">
<label>Curative</label>
<input type="text" name="curative" id="curative" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Rehabilitative</label>
<input type="text" name="rehabilitative" id="rehabilitative" maxlength="128" tabindex="1">
<label>Maintenance</label>
<input type="text" name="maintenance" id="maintenance" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>COMMUNITY ORAL HEALTH CARE</h4>
<div class="clear"></div>
<h4>Primary Prevention </h4>
<div class="clear"></div>
<label>Health Promotion</label>
<input type="text" name="healthPromotion" id="healthPromotion" maxlength="128" tabindex="1">
<label>Specific Protection</label>
<input type="text" name="specificProtection" id="specificProtection" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Secondary Prevention</h4>
<div class="clear"></div>

<label class="auto">Early Diagnosis And Prompt Treatment</label>
<input type="text" name="promptTreatment" id="Prompt Treatment" maxlength="128" tabindex="1" style="width:290px;">
<div class="clear"></div>

<h4>Tertiary Prevention</h4>
<div class="clear"></div>

<label>Disability Limitations</label>
<input type="text" name="disabilityLimitations" id="disabilityLimitations" maxlength="128" tabindex="1">
<label>Rehabilitation</label>
<input type="text" name="rehabilitation" id="rehabilitation" maxlength="128" tabindex="1">

<div class="clear"></div>
<div class="paddingTop5"></div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

</div>
</form>


<style>
.lable190 {width:190px !important;}
.lable70 {width:70px !important;}
</style>



