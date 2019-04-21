<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>


<div class="titleBg"><h2>Case Record - Periodontics</h2></div>



<form method="post" action="">
<div class="Block">
<input id="caseRecordOfPeriodonticsFlag" name="caseRecordOfPeriodonticsFlag" tabindex="1" value="caseRecordOfPeriodonticsFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Case Record Periodontics"/>
<label>Chief Complaint</label>
<input type="text" name="chiefComplaint" id="chiefComplaint" maxlength="128" tabindex="1">

<label class="auto">History of Present Illness</label>
<input type="text" name="historyOfPresentIllness" id="historyOfPresentIllness" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Past Dental History</h4>
<div class="clear"></div>

<label>Past Medical History</label>
<input type="text" name="pastMedicalHistory" id="pastMedicalHistory" maxlength="128" tabindex="1">

<label class="auto">History of Drug/Food Allergy</label>
<input type="text" name="drugFoodAllergy" id="drugFoodAllergy" maxlength="128" tabindex="1" style="width:175px;">
<div class="clear"></div>

<label class="auto">Abnormal bleeding Tendancy</label>
<input type="text" name="abnormalBleedingTendancy" id="abnormalBleedingTendancy" maxlength="128" tabindex="1" style="width:174px;">

<label>Habits</label>
<input type="text" name="habits" id="habits" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Medical Status</label>
<select id="medicalStatus" name="medicalStatus" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Congential Heart Disease">Congential Heart Disease</option>
<option value="Angina">Angina</option>
<option value="Heart Attack">Heart Attack</option>
<option value="Pace Maker">Pace Maker</option>
<option value="Hypertension">Hypertension</option>
<option value="Asthma">Asthma</option>
<option value="Stroke and Seizure or Convulsion">Stroke and Seizure or Convulsion</option>
<option value="Diabetes">Diabetes</option>
<option value="Blood Disorders">Blood Disorders</option>
<option value="Thyroid Problems">Thyroid Problems</option>
<option value="Hepatitis">Hepatitis</option>
<option value="Radiation / Chemotherapy">Radiation / Chemotherapy</option>
<option value="Pregnancy">Pregnancy</option>
<option value="Problems">Renal Problems</option>			 
</select>
<div class="clear"></div>

<h4>Personal History</h4>
<div class="clear"></div>
<h4>Oral Hygiene Practices</h4>
<div class="clear"></div>

<label>Frequency</label>
<label class="auto">Once</label>
<input tabindex="1" name="fequency" id="" value="Once" class="radiobutMargin" type="radio">
<label class="auto">Twice</label>
<input tabindex="1" name="fequency" id="" value="Twice" type="radio" style="margin-right:56px !important;">

<label>Dentrifices</label>
<select id="dentrifices" name="dentrifices" tabindex="1" validate="gender,metachar,no">
<option value="">Select</option>
<option value="Charcol">Charcol</option>
<option value="Tooth Powder">Tooth Powder</option>
<option value="Tooth Paste">Tooth Paste</option>		 
</select>
<div class="clear"></div>

<label>Method</label>
<label class="auto">Brush</label>
<input tabindex="1" name="method" id="" value="Brush" class="radiobutMargin" type="radio">
<label class="auto">Finger</label>
<input tabindex="1" name="method" id="" value="Finger" type="radio" style="margin-right:49px !important;">

<label>Adverse Habits</label>
<select id="adverseHabits" name="adverseHabits" tabindex="1" validate="gender,metachar,no">
<option value="0">Select</option>
<option value="1">Tobacco</option>
<option value="2">Beetel Nuts</option>
<option value="3">Others</option>		 
</select>
<div class="clear"></div>

<label>Parafunctional Habits</label>
<select id="parafunctionalHabits" name="parafunctionalHabits" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="1">Bruxism</option>
<option value="2">Clenching</option>
<option value="3">Lip Biting</option>
<option value="4">Tongue Thrusting</option>
<option value="5">Thumb Sucking</option>
<option value="6">Others</option>
</select>

<label>Family History</label>
<input type="text" name="familyHistory" id="familyHistory" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>General Examination</h4>
<div class="clear"></div>

<label>Cyanosis</label>
<label class="auto">Yes</label>
<input tabindex="1" name="cyanosis" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="cyanosis" id="" value="No" type="radio" style="margin-right:80px !important;">

<label>Icterus</label>
<label class="auto">Yes</label>
<input tabindex="1" name="icterus" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="icterus" id="" value="No" type="radio" style="margin-right:80px !important;">
<div class="clear"></div>

<label>Clubbing</label>
<label class="auto">Yes</label>
<input tabindex="1" name="clubbing" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="clubbing" id="" value="No" type="radio" class="radiobutMargin">

<h4>Extra Oral Examination</h4>
<div class="clear"></div>

<label>Facial Symmetry</label>
<input type="text" name="facialSymmetry" id="facialSymmetry" maxlength="128" tabindex="1">

<label>Eyes, Ears Nose</label>
<input type="text" name="eyesEarsNose" id="eyesEarsNose" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Lip Competance</label>
<input type="text" name="lipCompetance" id="lipCompetance" maxlength="128" tabindex="1">

<label>TMJ Examination</label>
<input type="text" name="tmjExamination" id="tmjExamination" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Lymph Node Examination</label>
<input type="text" name="lymphNodeExamination" id="lymphNodeExamination" maxlength="128" tabindex="1">

<label>Others</label>
<input type="text" name="others" id="others" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Intra Oral Examination</h4>
<div class="clear"></div>
<h4>Soft Tissue Examination</h4>
<div class="clear"></div>

<label>Buccal Mucosa</label>
<input type="text" name="buccalMucosa" id="buccalMucosa" maxlength="128" tabindex="1">

<label>Labial Mucosa</label>
<input type="text" name="labialMucosa" id="labialMucosa" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tongue</label>
<input type="text" name="tongue" id="tongue" maxlength="128" tabindex="1">

<label>Hard Palate</label>
<input type="text" name="hardPalate" id="hardPalate" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Soft Palate</label>
<input type="text" name="softPalate" id="softPalate" maxlength="128" tabindex="1">

<label>Floor of Mouth</label>
<input type="text" name="floorOfMouth" id="floorOfMouth" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Tonsils</label>
<input type="text" name="tonsils" id="tonsils" maxlength="128" tabindex="1">

<label>Frenal Attachment</label>
<input type="text" name="frenalAttachment" id="frenalAttachment" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Maxillary</h4>
<div class="clear"></div>
<label>Attachment</label>
<select id="maxillaryAttachment" name="maxillaryAttachment" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Papillary">Papillary</option>
<option value="Mucosa">Mucosa</option>
<option value="Gingival">Gingival</option>
<option value="Papillary Pendr">Papillary Pendr</option>
</select>

<label>Tension Test</label>
<label class="auto">Present</label>
<input tabindex="1" name="tensionTest1" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="tensionTest1" id="" value="Absent" type="radio" class="radiobutMargin">
<div class="clear"></div>

<h4>Mandibular</h4>
<div class="clear"></div>
<label>Attachment</label>
<select id="mandibularAttachment" name="mandibularAttachment" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="0">Select</option>
<option value="Papillary">Papillary</option>
<option value="Mucosa">Mucosa</option>
<option value="Gingival">Gingival</option>
<option value="Papillary Pendr">Papillary Pendr</option>
</select>

<label>Tension Test</label>
<label class="auto">Present</label>
<input tabindex="1" name="tensionTest2" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="tensionTest2" id="" value="Absent" type="radio" class="radiobutMargin">

<h4>Examination of Gingiva</h4>
<div class="clear"></div>

<h4>Maxillary</h4>
<div class="clear"></div>
<div class="addDeleteButton">
					<input type="button" class="buttonDel" value=""		onclick="removeRowMaxillary();" />
					<input type="button" class="buttonAdd"	onclick="addRowMaxillary();" value="" />
					</div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridMaxillary">
  <tbody>
    <tr>
    <th></th>
      <th>Clinical Feature</th>
      <th>Right Posterior</th>
      <th>Anterior</th>
      <th>Left Posterior</th>
    </tr>
        <%
	int incrMaxillary = 1;%>
    <tr>
    	<td> <input type="checkbox" class="radioCheck" id="maxillaryRadio<%=incrMaxillary%>" name="maxillaryRadio<%=incrMaxillary%>">
    
    	</td>
      <td><select id="maxClinicalFeature<%=incrMaxillary %>" name="maxClinicalFeature<%=incrMaxillary %>"  tabindex="">
<option value="">Select</option>
<option value="Colour">Colour</option>
<option value="Contour">Contour</option>
<option value="Position">Position</option>
<option value="Surface Texture">Surface Texture</option>
<option value="Consistency">Consistency</option>
<option value="Size">Size</option>
<option value="Exudation">Exudation</option>
<option value="Bleeding on Probing">Bleeding on Probing</option>
<option value="Adequacy of Gingiva">Adequacy of Gingiva</option>
</select></td>
      <td><input name="maxRightPosterior<%=incrMaxillary %>" id="maxRightPosterior<%=incrMaxillary %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128" ></td>
      <td><input name="maxAnterior<%=incrMaxillary %>" id="maxAnterior<%=incrMaxillary %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128"></td>
      <td><input name="maxLeftPosterior<%=incrMaxillary %>"  id="maxLeftPosterior<%=incrMaxillary %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128"></td>
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbMaxillary" value="<%=incrMaxillary%>" id="hdbMaxillary" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>

<h4>Mandibular</h4>
<div class="clear"></div>
<div class="addDeleteButton">
					<input type="button" class="buttonDel" value=""		onclick="removeRowMandibular();" />
					<input type="button" class="buttonAdd"	onclick="addRowMandibular();" value="" />
					</div>
					<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridMandibular">
  <tbody>
    <tr>
    <th></th>
      <th>Clinical Feature</th>
      <th>Right Posterior</th>
      <th>Anterior</th>
      <th>Left Posterior</th>
    </tr>
    <%
	int incrMandibular = 1;%>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="mandibularRadio<%=incrMandibular%>" name="mandibularRadio<%=incrMandibular%>">
		</td>
      <td><select id="manClinicalFeature<%=incrMandibular %>" name="manClinicalFeature<%=incrMandibular%>"  tabindex="">
<option value="">Select</option>
<option value="Colour">Colour</option>
<option value="Contour">Contour</option>
<option value="Position">Position</option>
<option value="Surface Texture">Surface Texture</option>
<option value="Consistency">Consistency</option>
<option value="Size">Size</option>
<option value="Exudation">Exudation</option>
<option value="Bleeding on Probing">Bleeding on Probing</option>
<option value="Adequacy of Gingiva">Adequacy of Gingiva</option>
</select></td>
      <td><input name="manRightPosterior<%=incrMandibular %>" id="manRightPosterior<%=incrMandibular %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128"></td>
      <td><input name="manAnterior<%=incrMandibular %>" id="manAnterior<%=incrMandibular %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128"></td>
      <td><input name="manLeftPosterior<%=incrMandibular %>" id="manLeftPosterior<%=incrMandibular %>" value="" tabindex="34" size="10" class="textYellow opdTextBoxSmall" type="text" maxlength="128"></td>
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbMandibular" value="<%=incrMandibular %>" id="hdbMandibular" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>

<label>Mucogingival Problems</label>
<label class="auto">Present</label>
<input tabindex="1" name="mucogingivalProblems" id="" value="Present" class="radiobutMargin" type="radio" onclick="displayTextValue(this.value,'Mucogingival');" >
<label class="auto">Absent</label>
<input tabindex="1" name="mucogingivalProblems" id="" value="Absent" type="radio" style="margin-right:31px;" onclick="displayTextValue(this.value,'Mucogingival');" >

<div style="display:none;"  id="mucogingivalProblemsDiv">
<label>Tension Test</label>
<label class="auto">Yes</label>
<input tabindex="1" name="tensionTest" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="tensionTest" id="" value="No" type="radio" style="margin-right:82px;">

<div class="clear"></div>
<label class="auto">Adequacy of Attached Gingiva</label>
<label class="auto">Yes</label>
<input tabindex="1" name="attachedGingiva" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="attachedGingiva" id="" value="No" type="radio" style="margin-right:62px;">


<label>Vestibular Depth</label>
<label class="auto">Yes</label>
<input tabindex="1" name="vestibularDepth" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="vestibularDepth" id="" value="No" type="radio" class="radiobutMargin">
</div>
<div class="clear"></div>
<label>Ulceration</label>
<label class="auto">Present</label>
<input tabindex="1" name="ulceration" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="ulceration" id="" value="Absent" type="radio" style="margin-right:31px;">


<label>Gingival Abscess</label>
<label class="auto">Present</label>
<input tabindex="1" name="gingivalAbscess" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="gingivalAbscess" id="" value="Absent" type="radio" style="margin-right:31px;">
<div class="clear"></div>
<label>Periodontal Abscess</label>
<label class="auto">Present</label>
<input tabindex="1" name="periodontalAbscess" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="periodontalAbscess" id="" value="Absent" type="radio" class="radiobutMargin">


<label>Pericoronnal Abscess</label>
<label class="auto">Present</label>
<input tabindex="1" name="pericoronnalAbscess" id="" value="Present" class="radiobutMargin" type="radio">
<label class="auto">Absent</label>
<input tabindex="1" name="pericoronnalAbscess" id="" value="Absent" type="radio" style="margin-right:31px;">
<div class="clear"></div>
<label>Hard Tissue Examination</label>
<input name="hardTissueExamination" id="hardTissueExamination" maxlength="128" tabindex="1" type="text">
<div class="clear"></div>

<h4>Teeth Present</h4>
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
      <td><input name="data11" id="data11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="data();" > 11</td>
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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<label class="auto">Missing Teeth and reason for IT</label>
<input type="text" name="missingTeeth" id="missingTeeth" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Occlusion</h4>
<div class="clear"></div>

<label>Angles Classification</label>
<select id="anglesClassification" name="anglesClassification" tabindex="1" validate="gender,metachar,no">
<option value="0">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="Class III">Class III</option>		 
</select>

<label>Overjet</label>
<input type="text" name="overjet" id="overjet" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Overbite</label>
<select id="" name="overbite" tabindex="1" validate="gender,metachar,no">
<option value="0">Select</option>
<option value="Normal">Normal</option>
<option value="Open">Open</option>
<option value="Deep">Deep</option>		 
</select>

<label>Crossbite</label>
<select id="crossbite" name="crossbite" tabindex="1" validate="gender,metachar,no">
<option value="0">Select</option>
<option value="Anterior1">Anterior</option>
<option value="Posterior Uniliateral">Posterior Uniliateral</option>
<option value="Bilateral">Bilateral</option>		 
</select>
<div class="clear"></div>

<label>Premature Contacts</label>
<label class="auto">Yes</label>
<input tabindex="1" name="prematureContacts" id="Yes" value="" type="radio" class="radiobutMargin" >
<label class="auto">No</label>
<input tabindex="1" name="prematureContacts" id="No" value="" type="radio" style="margin-right:84px;">

<label>Fremitus</label>
<label class="auto">Yes</label>
<input tabindex="1" name="fremitus" id="fremitus" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Fremitus');">
<label class="auto">No</label>
<input tabindex="1" name="fremitus" id="fremitus" value="No" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Fremitus');">
<div id="fremitusDiv" style="display:none;">
<select id="fremitusVal" name="fremitusVal" tabindex="1" validate="gender,metachar,no" class="small" >
<option value="">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>		 
</select>
</div>
<div class="clear"></div>

<h4>Interferences</h4>
<div class="clear"></div>

<label>Working Side</label>
<label class="auto">Yes</label>
<input tabindex="1" name="workingSide" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="workingSide" id="" value="No" type="radio" style="margin-right:84px;">

<label>Balancing Side</label>
<label class="auto">Yes</label>
<input tabindex="1" name="balancingSide" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="balancingSide" id="" value="No" type="radio" class="radiobutMargin">
<div class="clear"></div>

<label>Mobility</label>
<label class="auto">Yes</label>
<input tabindex="1" name="mobility" id="" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Mobility');">
<label class="auto">No</label>
<input tabindex="1" name="mobility" id="" value="No" type="radio" style="margin-right:89px;" onclick="displayTextValue(this.value,'Mobility');">
<div id="mobilityDiv" style="display:none;">
<select id="mobilityVal" name="mobilityVal" tabindex="1" validate="gender,metachar,no" class="small">
<option value="">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>		 
</select>
</div>
<div class="clear"></div>
<label>Furcation Involvement</label>
<label class="auto">Yes</label>
<input tabindex="1" name="furcationInvolvement" id="furcationInvolvement" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Furcation Involvement');">
<label class="auto">No</label>
<input tabindex="1" name="furcationInvolvement" id="furcationInvolvement" value="No" type="radio" style="margin-right:89px;" onclick="displayTextValue(this.value,'Furcation Involvement');">
<div id="furcationInvolvementDiv" style="display:none;">
<select id="furcationInvolvementVal" name="furcationInvolvementVal" tabindex="1" validate="gender,metachar,no" class="small" >
<option value="">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>		 
</select>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>
<h4>Pathologic Migration</h4>
<div class="clear"></div>

<h4>Pain on Percussion Upper Tooths</h4>
<div class="clear"></div>
<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridUpperTooth">
  <tbody>
    <tr>
      <th>Tooth</th>
      <th>18</th>
      <th>17</th>
      <th>16</th>
      <th>15</th>
      <th>14</th>
      <th>13</th>
      <th>12</th>
      <th>11</th>
      <th>21</th>
      <th>22</th>
      <th>23</th>
      <th>24</th>
      <th>25</th>
      <th>26</th>
      <th>27</th>
      <th>28</th>
    </tr>
    <tr>
      <%
	int incrUpperTooth = 1;%>
      <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Calculus">
      <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Pain on Percussion Upper Tooths Calculus">
      </td>
      <td><select id="" name="utooth_1<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_2<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_3<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option></select></td>
      <td><select id="" name="utooth_4<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_5<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_6<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="1">0</option>
<option value="2">1</option>
<option value="3">2</option>
<option value="4">3</option>
</select></td>
      <td><select id="" name="utooth_7<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_8<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_9<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_10<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_11<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_12<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_13<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_14<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_15<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_16<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
    </tr>
    <% incrUpperTooth++; %>
    <tr>
         <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Plaque">
      <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Pain on Percussion Upper Tooths Plaque">
      </td>
       <td><select id="" name="utooth_1<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_2<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_3<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_4<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_5<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_6<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_7<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_8<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_9<%=incrUpperTooth%>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_10<%=incrUpperTooth%>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_11<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_12<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_13<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_14<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_15<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_16<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
    </tr>
  </tbody>
</table>

</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Pain on Percussion Lower Tooths</h4>
<div class="clear"></div>
<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridLowerTooth">
  <tbody>
    <tr>
      <th>Tooth</th>
      <th>48</th>
      <th>47</th>
      <th>46</th>
      <th>45</th>
      <th>44</th>
      <th>43</th>
      <th>42</th>
      <th>41</th>
      <th>31</th>
      <th>32</th>
      <th>33</th>
      <th>34</th>
      <th>35</th>
      <th>36</th>
      <th>37</th>
      <th>38</th>
    </tr>
    <tr>
     <% incrUpperTooth++; %>
<td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Calculus">
      
        <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Pain on Percussion Lower Tooths Calculus">
      </td>
     <td><select id="" name="utooth_1<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_2<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_3<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_4<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_5<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_6<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_7<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_8<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_9<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_10<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_11<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_12<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_13<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_14<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_15<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_16<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
    </tr>
     <% incrUpperTooth++; %>
    <tr>
      <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Plaque">
      <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Pain on Percussion Lower Tooths Plaque">
      </td>
      
         <td><select id="" name="utooth_1<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_2<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_3<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_4<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_5<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_6<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_7<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_8<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_9<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_10<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_11<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_12<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_13<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_14<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_15<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
      <td><select id="" name="utooth_16<%=incrUpperTooth %>"  tabindex="" class="smaller">
<option value="">Select</option>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
</select></td>
    </tr>
  </tbody>
</table>

</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Wasting Diseases</h4>
<div class="clear"></div>

<label>Attrition</label>
<label class="auto">Yes</label>
<input tabindex="1" name="attrition" id="" value="" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="attrition" id="" value="" type="radio" style="margin-right:84px;">

<label>Abrasion</label>
<label class="auto">Yes</label>
<input tabindex="1" name="abrasion" id="" value="" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="abrasion" id="" value="" type="radio" style="margin-right:84px;">
<div class="clear"></div>

<label>Erosion</label>
<label class="auto">Yes</label>
<input tabindex="1" name="erosion" id="" value="" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="erosion" id="" value="" type="radio" style="margin-right:84px;">

<label>Abfractioin</label>
<label class="auto">Yes</label>
<input tabindex="1" name="abfractioin" id="" value="" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="abfractioin" id="" value="" type="radio" class="radiobutMargin">
<div class="clear"></div>
<h4>Carious Teeth</h4>
<div class="clear"></div>

<label>Filled Teeth</label>
<input type="text" name="filledTeeth" id="filledTeeth" maxlength="128" tabindex="1">

<label>Tooth Fracture</label>
<input type="text" name="toothFracture" id="toothFracture" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Hypoplasia / Flurosis</label>
<input type="text" name="hypoplasiaFlurosis" id="hypoplasiaFlurosis" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Study Models</h4>
<div class="clear"></div>

<label>Pre Operative</label>
<label class="auto">Yes</label>
<input tabindex="1" name="preOperative1" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="preOperative1" id="" value="No" type="radio" style="margin-right:84px;">

<label>Post Operative</label>
<label class="auto">Yes</label>
<input tabindex="1" name="postOperative1" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="postOperative1" id="" value="No" type="radio" style="margin-right:84px;">
<div class="clear"></div>

<h4>Photographs</h4>
<div class="clear"></div>

<label>Pre Operative</label>
<label class="auto">Yes</label>
<input tabindex="1" name="preOperative3" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="preOperative3" id="" value="No" type="radio" style="margin-right:84px;">

<label>Post Operative</label>
<label class="auto">Yes</label>
<input tabindex="1" name="postOperative2" id="" value="Yes" type="radio" class="radiobutMargin">
<label class="auto">No</label>
<input tabindex="1" name="postOperative2" id="" value="No" type="radio" style="margin-right:84px;">
<div class="clear"></div>

<h4>Roentgenographic Findings</h4>
<div class="clear"></div>

<label>I.O.P.A View</label>
<input type="text" name="iopaView" id="iopaView" maxlength="128" tabindex="1">

<label>OPG View</label>
<input type="text" name="opgView" id="opgView" maxlength="128" tabindex="1">
<div class="clear"></div>

<label>Others</label>
<input type="text" name="others1" id="others1" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Probing Depth Chart Maxillary Upper Tooth(BUCCAL)</h4>
<div class="clear"></div>

<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridBuccal">
  <tbody>
    <tr>
      <th>Tooth</th>
      <th>18</th>
      <th>17</th>
      <th>16</th>
      <th>15</th>
      <th>14</th>
      <th>13</th>
      <th>12</th>
      <th>11</th>
      <th>21</th>
      <th>22</th>
      <th>23</th>
      <th>24</th>
      <th>25</th>
      <th>26</th>
      <th>27</th>
      <th>28</th>
    </tr>
       <% incrUpperTooth++; %>
    <tr>
     <td><input type="text" name="tooth<%=incrUpperTooth %>" tabindex="1" value="Recession/Enlargement">
     
     <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth BUCCAL Recession Enlargement">
     </td>
     
     
     <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      </tr>
         <% incrUpperTooth++; %>
    <tr>
       <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Pocket">
       <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth BUCCAL Pocket">
       </td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10" maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      </tr>
         <% incrUpperTooth++; %>
    <tr>
        <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Mobility">
        <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth BUCCAL Mobility">
        </td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10" maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
         <% incrUpperTooth++; %>
    <tr>
        <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="FI">
        <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth BUCCAL FI"></td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10" maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
         <% incrUpperTooth++; %>
    <tr>
      <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Graft">
      <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth BUCCAL Graft"></td>
      <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
  </tbody>
</table>

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>


<h4>Probing Depth Chart Maxillary Lower Tooth (PALATAL)</h4>
<div class="clear"></div>

<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridPalatal">
  <tbody>
    <tr>
      <th>Tooth</th>
      <th>48</th>
      <th>47</th>
      <th>46</th>
      <th>45</th>
      <th>44</th>
      <th>43</th>
      <th>42</th>
      <th>41</th>
      <th>31</th>
      <th>32</th>
      <th>33</th>
      <th>34</th>
      <th>35</th>
      <th>36</th>
      <th>37</th>
      <th>38</th>
    </tr>
       <% incrUpperTooth++; %>
    <tr>
      
        <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Recession/Enlargement">
        <input type="hidden" name="flag<%=incrUpperTooth %>" tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth PALATAL Recession Enlargement"></td>
        
     <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      </tr>
         <% incrUpperTooth++; %>
    <tr>
       <td><input type="text" name="tooth<%=incrUpperTooth %>" tabindex="1" value="Pocket">
       
       <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth PALATAL Pocket"></td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      </tr>
         <% incrUpperTooth++; %>
    <tr>
        <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Mobility">
        <input type="hidden" name="flag<%=incrUpperTooth %>" tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth PALATAL Mobility"></td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
         <% incrUpperTooth++; %>
    <tr>
        <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="FI">
        <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth PALATAL FI"></td>
       <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
         <% incrUpperTooth++; %>
    <tr>
      <td><input type="text" name="tooth<%=incrUpperTooth %>"  tabindex="1" value="Graft">
      <input type="hidden" name="flag<%=incrUpperTooth %>"  tabindex="1" value="Probing Depth Chart Maxillary Upper Tooth PALATAL Graft"></td>
      <td><input type="text" name="utooth_1<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_2<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_3<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_4<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_5<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_6<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_7<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_8<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_9<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_10<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_11<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_12<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_13<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_14<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_15<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
      <td><input type="text" name="utooth_16<%=incrUpperTooth %>" id="" value=""  tabindex="34" size="10"maxlength="128" class="textYellow opdTextBoxTSmall"></td>
    </tr>
  </tbody>
</table>

</div>
<input type="hidden" name="hdbUpperTooth" value="<%=incrUpperTooth %>" id="hdbUpperTooth" />
<div class="clear"></div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

</div>
</form>
