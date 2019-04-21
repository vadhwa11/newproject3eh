


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>


<div class="titleBg"><h2>Endodontics</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="endodonticsFlag" name="endodonticsFlag" tabindex="1" value="endodonticsFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Endodontics"/>

<div class="clear"></div>
<label>Chief Complaint</label>
<select id="chiefComplaint" name="chiefComplaint" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no" onclick="displayTextValue(this.value,'Chief Complaint');">
<option value="">Select</option>
<option value="Pain">Pain</option>
<option value="Swelling">Swelling</option>
<option value="Pus Discharge">Pus Discharge</option>
<option value="Trauma">Trauma</option>
<option value="Tooth Wear">Tooth Wear</option>
<option value="Aesthetic Concern">Aesthetic Concern</option>
<option value="Decayed Tooth">Decayed Tooth</option>
<option value="Referred Cases">Referred Cases</option>
<option value="Food Lodgement">Food Lodgement</option>
<option value="Broken Filling">Broken Filling</option>
<option value="Cheek / Tongue Biting">Cheek / Tongue Biting</option>
<option value="Others">Others</option>
</select>
<div style="display:none" id="chiefComplaintDiv">
<input type="text" name="chiefComplaintValue" id="chiefComplaintValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>H/O Present Illness</h4>
<div class="clear"></div>

<label>Nature of Pain</label>
<select name="natureOfPain" id="natureOfPain" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="None">None</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>
<label>Quality</label>
<select name="quality" id="quality" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Dull">Dull</option>
<option value="Sharp">Sharp</option>
<option value="Throbbing">Throbbing</option>
<option value="Constant">Constant</option>
</select>
<div class="clear"></div>
<label>Onset</label>
<select name="onset" id="onset" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Stimulus Required">Stimulus Required</option>
<option value="Intermittent">Intermittent</option>
<option value="Spontaneous">Spontaneous</option>
</select>


<label>Location</label>
<select name="location" id="location" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Localised">Localised</option>
<option value="Diffuse">Diffuse</option>
<option value="Referred">Referred</option>
<option value="Radiating">Radiating</option>
</select>
<div class="clear"></div>
<label>Duration</label>
<select name="duration" id="duration" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Seconds">Seconds</option>
<option value="Minutes">Minutes</option>
<option value="Hours">Hours</option>
<option value="Constant">Constant</option>
</select>

<label>Initiated by</label>
<select name="initiatedBy" id="initiatedBy" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Cold">Cold</option>
<option value="Heat">Heat</option>
<option value="Sweet">Sweet</option>
<option value="Spontaneous">Spontaneous</option>
<option value="Palpation">Palpation</option>
<option value="Mastication">Mastication</option>
<option value="Supination">Supination</option>
<option value="Night Pain">Night Pain</option>
</select>
<div class="clear"></div>

<label>Relieved by</label>
<select name="releivedBy" id="releivedBy" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Cold">Cold</option>
<option value="Heat">Heat</option>
<option value="Over the counter drugs">Over the counter drugs</option>
</select>

<label>Others</label>
<input type="text" name="others" id="others" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Clinical Examination / Findings</h4>
<div class="clear"></div>
<h4>Tooth</h4>
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
<select id="teeth_18_value" name="teeth_18_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'18');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="18Div">
<input type="text" name="others18" id="others18" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv17">
<label class="auto">17</label>
<select id="teeth_17_value" name="teeth_17_value" tabindex="1" multiple="multiple" size="3" onclick="displayOtherValue(this.value,'17');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown a�� Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="17Div">
<input type="text" name="others17" id="others17" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv16">
<label class="auto">16</label>
<select id="teeth_16_value" name="teeth_16_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,,'16');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="16Div">
<input type="text" name="others16" id="others16" maxlength="128" tabindex="1">
</div>
</div>


<div class="mltpSlect" style="display:none" id="dataDiv15">
<label class="auto">15</label>
<select id="teeth_15_value" name="teeth_15_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'15');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="15Div">
<input type="text" name="others15" id="others15" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv14">
<label class="auto">14</label>
<select id="teeth_14_value" name="teeth_14_value" tabindex="1" multiple="multiple" onclick="displayOtherValue(this.value,,'14');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="14Div">
<input type="text" name="others14" id="others14" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv13">
<label class="auto">13</label>
<select id="teeth_13_value" name="teeth_13_value" tabindex="1" multiple="multiple" size="3" onclick="displayOtherValue(this.value,'13');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="13Div">
<input type="text" name="others13" id="others13" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv12">
<label class="auto">12</label>
<select id="teeth_12_value" name="teeth_12_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,12);" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="12Div">
<input type="text" name="others12" id="others12" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv11">
<label class="auto">11</label>
<select id="teeth_11_value" name="teeth_11_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,11);" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="11Div">
<input type="text" name="others11" id="others11" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv21">
<label class="auto">21</label>
<select id="teeth_21_value" name="teeth_21_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,21);" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="21Div">
<input type="text" name="others21" id="others21" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv22">
<label class="auto">22</label>
<select id="teeth_22_value" name="teeth_22_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,,'22');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="22Div">
<input type="text" name="others22" id="others22" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv23">
<label class="auto">23</label>
<select id="teeth_23_value" name="teeth_23_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'23');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="23Div">
<input type="text" name="others23" id="others23" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv24">
<label class="auto">24</label>
<select id="teeth_24_value" name="teeth_24_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'24');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="24Div">
<input type="text" name="others24" id="others24" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv25">
<label class="auto">25</label>
<select id="teeth_25_value" name="teeth_25_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'25');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="25Div">
<input type="text" name="others25" id="others25" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv26">
<label class="auto">26</label>
<select id="teeth_26_value" name="teeth_26_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'26');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="26Div">
<input type="text" name="others26" id="others26" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv27">
<label class="auto">27</label>
<select id="teeth_27_value" name="teeth_27_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'27');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="27Div">
<input type="text" name="others27" id="others27" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv28">
<label class="auto">28</label>
<select id="teeth_27_value" name="teeth_27_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'28');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="28Div">
<input type="text" name="others28" id="others28" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none"id="dataDiv48">
<label class="auto">48</label>
<select id="teeth_48_value" name="teeth_48_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'48');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="48Div">
<input type="text" name="others48" id="others48" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv47">
<label class="auto">47</label>
<select id="teeth_47_value" name="teeth_47_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'47');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="47Div">
<input type="text" name="others47" id="others47" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv46">
<label class="auto">46</label>
<select id="teeth_46_value" name="teeth_46_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'46');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="46Div">
<input type="text" name="others46" id="others46" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv45">
<label class="auto">45</label>
<select id="teeth_45_value" name="teeth_45_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'45');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="45Div">
<input type="text" name="others45" id="others45" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv44">
<label class="auto">44</label>
<select id="teeth_44_value" name="teeth_44_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'44');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="44Div">
<input type="text" name="others44" id="others44" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv43">
<label class="auto">43</label>
<select id="teeth_43_value" name="teeth_43_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'43');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="43Div">
<input type="text" name="others43" id="others43" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv42">
<label class="auto">42</label>
<select id="teeth_42_value" name="teeth_42_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'42');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="42Div">
<input type="text" name="others42" id="others42" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv41">
<label class="auto">41</label>
<select id="teeth_41_value" name="teeth_41_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'41');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="41Div">
<input type="text" name="others41" id="others41" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv31">
<label class="auto">31</label>
<select id="teeth_31_value" name="teeth_31_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'31');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="31Div">
<input type="text" name="others31" id="others31" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv32">
<label class="auto">32</label>
<select id="teeth_32_value" name="teeth_32_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'32');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="32Div">
<input type="text" name="others32" id="others32" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv33">
<label class="auto">33</label>
<select id="teeth_33_value" name="teeth_33_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'33');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="33Div">
<input type="text" name="others33" id="others33" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv34">
<label class="auto">34</label>
<select id="teeth_34_value" name="teeth_34_value" tabindex="1" multiple="multiple" size="3" onclick="displayOtherValue(this.value,'34');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="34Div">
<input type="text" name="others34" id="others34" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv35">
<label class="auto">35</label>
<select id="teeth_35_value" name="teeth_35_value" tabindex="1" multiple="multiple" size="3" onclick="displayOtherValue(this.value,'35');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="35Div">
<input type="text" name="others35" id="others35" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv36">
<label class="auto">36</label>
<select id="teeth_36_value" name="teeth_36_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'36');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="36Div">
<input type="text" name="others36" id="others36" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv37">
<label class="auto">37</label>
<select id="teeth_37_value" name="teeth_37_value" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayOtherValue(this.value,'37');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="37Div">
<input type="text" name="others37" id="others37" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv38">
<label class="auto">38</label>
<select id="teeth_38_value" name="teeth_38_value" tabindex="1" multiple="multiple" size="3" onclick="displayOtherValue(this.value,'38');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Caries">Caries</option>
<option value="Stained Pits & Fissures">Stained Pits & Fissures</option>
<option value="White Spot Lesion">White Spot Lesion</option>
<option value="Pulp Exposure">Pulp Exposure</option>
<option value="Intact Restoration">Intact Restoration</option>
<option value="Defective Restoration">Defective Restoration</option>
<option value="Discoloured Tooth">Discoloured Tooth</option>
<option value="Fractured Enamel">Fractured Enamel</option>
<option value="Fractured Dentin">Fractured Dentin</option>
<option value="Fracture Involving Pulp">Fracture Involving Pulp</option>
<option value="Crown - Root Fracture">Crown - Root Fracture</option>
<option value="Root Fracture">Root Fracture</option>
<option value="Vertical Fracture">Vertical Fracture</option>
<option value="1Cracked Tooth">Cracked Tooth</option>
<option value="Cracked Tooth">Tooth Mobility</option>
<option value="Displacement Injuries">Displacement Injuries</option>
<option value="Sharp Tooth Surfaces / Restoration">Sharp Tooth Surfaces / Restoration</option>
<option value="Cervical Abrasion">Cervical Abrasion</option>
<option value="Attrition / Erosion">Attrition / Erosion</option>
<option value="Occlusal Interference of Restoration">Occlusal Interference of Restoration</option>
<option value="Peg Laterals">Peg Laterals</option>
<option value="Diastema">Diastema</option>
<option value="Trauma From Occlusion">Trauma From Occlusion</option>
<option value="Prior Access Preparation">Prior Access Preparation</option>
<option value="Crown Fabricated Tooth">Crown Fabricated Tooth</option>
<option value="Temporary Restoration">Temporary Restoration</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="38Div">
<input type="text" name="others38" id="others38" maxlength="128" tabindex="1">
</div>
</div>


<div class="clear"></div>
<h4>Soft Tissue</h4>
<div class="clear"></div>
<h4>Extra Oral</h4>
<div class="clear"></div>

<label>Facial Swelling</label>
<label class="auto">Yes</label>
<input tabindex="1" name="facialSwellinga" id="facialSwellinga" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Facial Swelling');">
<label class="auto">No</label>
<input tabindex="1" name="facialSwellinga" id="facialSwellinga" value="No" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'Facial Swelling');">
<div style="display:none" id="facialSwellingaDiv">
<input type="text" name="facialSwellingaValue" id="facialSwellingaValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>
<label>Lymph Node Enlargement</label>
<label class="auto">Yes</label>
<input tabindex="1" name="lymphNodeEnlargement" id="lymphNodeEnlargement" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Lymph Node Enlargement');">
<label class="auto">No</label>
<input tabindex="1" name="lymphNodeEnlargement" id="lymphNodeEnlargement" value="No" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'Lymph Node Enlargement');">
<div style="display:none" id="lymphNodeEnlargementDiv">
<input type="text" name="lymphNodeEnlargementValue" id="lymphNodeEnlargementValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Intra Oral</h4>
<div class="clear"></div>

<label>Swelling</label>
<label class="auto">Yes</label>
<input tabindex="1" name="swelling" id="swelling" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Swelling');">
<label class="auto">No</label>
<input tabindex="1" name="swelling" id="swelling" value="No" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'Swelling');">
<div style="display:none" id="swellingDiv">
<input type="text" name="swellingValue" id="swellingValue" maxlength="128" tabindex="1">
</div>

<label>Nature</label>
<select name="nature" id="nature" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Mild">Mild</option>
<option value="Moderate">Moderate</option>
<option value="Severe">Severe</option>
</select>
<div class="clear"></div>

<label>Location</label>
<select name="location" id="location" tabindex="1" validate="Service Center,string,no" >
<option value="">Select</option>
<option value="Buccal">Buccal</option>
<option value="Lingual">Lingual</option>
<option value="Palatal">Palatal</option>
<option value="Labial">Labial</option>
</select>

<label>Sinus Tract</label>
<label class="auto">Yes</label>
<input tabindex="1" name="sinusTract" id="sinusTract" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValue(this.value,'Sinus Tract');"> 
<label class="auto">No</label>
<input tabindex="1" name="sinusTract" id="sinusTract" value="No" type="radio" style="margin-right:21px;" onclick="displayTextValue(this.value,'Sinus Tract');">
<div style="display:none" id="sinusTractDiv">
<input type="text" name="sinusTractValue" id="sinusTractValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<h4>Radiographic Examination</h4>
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
      <td><input name="dataAnother11" id="dataAnother11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnother();"> 11</td>
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

<div class="mltpSlect" style="display:none" id="dataAnotherDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnother" name="teeth_18_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'18');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="18AnotherDiv">
<input type="text" name="othersAnother18" id="othersAnother18" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnother" name="teeth_17_valueAnother" tabindex="1" multiple="multiple" onclick="displayRadioOtherValue(this.value,'17');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="17AnotherDiv">
<input type="text" name="othersAnother17" id="othersAnother17" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnother" name="teeth_16_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'16');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="16AnotherDiv">
<input type="text" name="othersAnother16" id="othersAnother16" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnother" name="teeth_15_valueAnother" tabindex="1" multiple="multiple" onclick="displayRadioOtherValue(this.value,'15');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="15AnotherDiv">
<input type="text" name="othersAnother15" id="othersAnother15" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnother" name="teeth_14_valueAnother" tabindex="1" multiple="multiple" onclick="displayRadioOtherValue(this.value,'14');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="14AnotherDiv">
<input type="text" name="othersAnother14" id="othersAnother14" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnother" name="teeth_13_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'13');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="13AnotherDiv">
<input type="text" name="othersAnother13" id="othersAnother13" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnother" name="teeth_12_valueAnother" tabindex="1" multiple="multiple" onclick="displayRadioOtherValue(this.value,'12');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="12AnotherDiv">
<input type="text" name="othersAnother12" id="othersAnother12" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnother" name="teeth_11_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'11');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="11AnotherDiv">
<input type="text" name="othersAnother11" id="othersAnother11" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnother" name="teeth_21_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'21');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="21AnotherDiv">
<input type="text" name="othersAnother21" id="othersAnother21" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnother" name="teeth_22_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'22');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="22AnotherDiv">
<input type="text" name="othersAnother22" id="othersAnother22" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnother" name="teeth_23_valueAnother" tabindex="1" multiple="multiple" onclick="displayRadioOtherValue(this.value,'23');" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="23AnotherDiv">
<input type="text" name="othersAnother23" id="othersAnother23" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnother" name="teeth_24_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'24');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="24AnotherDiv">
<input type="text" name="othersAnother24" id="othersAnother24" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnother" name="teeth_25_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'25');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="25AnotherDiv">
<input type="text" name="othersAnother25" id="othersAnother25" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnother" name="teeth_26_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'26');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="26AnotherDiv">
<input type="text" name="othersAnother26" id="othersAnother26" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnother" name="teeth_27_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'27');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="27AnotherDiv">
<input type="text" name="othersAnother27" id="othersAnother27" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnother" name="teeth_28_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'28');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="28AnotherDiv">
<input type="text" name="othersAnother28" id="othersAnother28" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnother" name="teeth_48_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'48');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="48AnotherDiv">
<input type="text" name="othersAnother48" id="othersAnother48" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnother" name="teeth_47_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'47');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="47AnotherDiv">
<input type="text" name="othersAnother47" id="othersAnother47" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnother" name="teeth_46_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'46');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="46AnotherDiv">
<input type="text" name="othersAnother46" id="othersAnother46" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnother" name="teeth_45_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'45');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="45AnotherDiv">
<input type="text" name="othersAnother45" id="othersAnother45" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnother" name="teeth_44_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'44');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="44AnotherDiv">
<input type="text" name="othersAnother44" id="othersAnother44" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnother" name="teeth_43_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'43');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="43AnotherDiv">
<input type="text" name="othersAnother43" id="othersAnother43" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnother" name="teeth_42_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'42');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="42AnotherDiv">
<input type="text" name="othersAnother42" id="othersAnother42" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnother" name="teeth_41_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'41');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="41AnotherDiv">
<input type="text" name="othersAnother41" id="othersAnother41" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnother" name="teeth_31_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'31');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="31AnotherDiv">
<input type="text" name="othersAnother31" id="othersAnother31" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnother" name="teeth_32_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'32');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="32AnotherDiv">
<input type="text" name="othersAnother32" id="othersAnother32" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnother" name="teeth_33_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple"  onclick="displayRadioOtherValue(this.value,'33');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="33AnotherDiv">
<input type="text" name="othersAnother33" id="othersAnother33" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnother" name="teeth_34_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'34');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option><option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="34AnotherDiv">
<input type="text" name="othersAnother34" id="othersAnother34" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnother" name="teeth_35_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'35');" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="35AnotherDiv">
<input type="text" name="othersAnother35" id="othersAnother35" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnother" name="teeth_36_valueAnother" tabindex="1" multiple="multiple" size="3" onclick="displayRadioOtherValue(this.value,'36');"  class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="36AnotherDiv">
<input type="text" name="othersAnother36" id="othersAnother36" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnother" name="teeth_37_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'37');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="37AnotherDiv">
<input type="text" name="othersAnother37" id="othersAnother37" maxlength="128" tabindex="1">
</div>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnother" name="teeth_38_valueAnother" tabindex="1" multiple="multiple" size="3" class="multiple" onclick="displayRadioOtherValue(this.value,'38');" validate="Service Center,string,no">
<option value="">Select</option>
<option value="WNL">WNL</option>
<option value="Caries">Caries</option>
<option value="Restoration">Restoration</option>
<option value="Calcified Canal">Calcified Canal</option>
<option value="Apical Resorption">Apical Resorption</option>
<option value="Cervical Resorption">Cervical Resorption</option>
<option value="Internal Resorption">Internal Resorption</option>
<option value="Lateral Resorption">Lateral Resorption</option>
<option value="Tooth Fracture">Tooth Fracture</option>
<option value="Preforation">Preforation</option>
<option value="Canal Transportation">Canal Transportation</option>
<option value="Missed Canal">Missed Canal</option>
<option value="Prior RCT">Prior RCT</option>
<option value="Separated Instrument">Separated Instrument</option>
<option value="Canal Obstruction">Canal Obstruction</option>
<option value="Post & Core Build Up">Post & Core Build Up</option>
<option value="Dilaceration">Dilaceration</option>
<option value="Open Apex">Open Apex</option>
<option value="Others">Others</option>				 
</select>
<div style="display:none" id="38AnotherDiv">
<input type="text" name="othersAnother38" id="othersAnother38" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<h4>Attachment Apparatus</h4>
<div class="clear"></div>
<h4>PDL : WNL</h4>
<div class="clear"></div>

<h4>PDL Space Widened</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="dataAnotherOne18" id="dataAnotherOne18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 18</td>
      <td><input name="dataAnotherOne17" id="dataAnotherOne17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 17</td>
      <td><input name="dataAnotherOne16" id="dataAnotherOne16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 16</td>
      <td><input name="dataAnotherOne15" id="dataAnotherOne15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 15</td>
      <td><input name="dataAnotherOne14" id="dataAnotherOne14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 14</td>
      <td><input name="dataAnotherOne13" id="dataAnotherOne13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 13</td>
      <td><input name="dataAnotherOne12" id="dataAnotherOne12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 12</td>
      <td><input name="dataAnotherOne11" id="dataAnotherOne11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 11</td>
      <td><input name="dataAnotherOne21" id="dataAnotherOne21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 21</td>
      <td><input name="dataAnotherOne22" id="dataAnotherOne22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 22</td>
      <td><input name="dataAnotherOne23" id="dataAnotherOne23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 23</td>
      <td><input name="dataAnotherOne24" id="dataAnotherOne24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 24</td>
      <td><input name="dataAnotherOne25" id="dataAnotherOne25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 25</td>
      <td><input name="dataAnotherOne26" id="dataAnotherOne26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 26</td>
      <td><input name="dataAnotherOne27" id="dataAnotherOne27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 27</td>
      <td><input name="dataAnotherOne28" id="dataAnotherOne28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherOne48" id="dataAnotherOne48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 48</td>
      <td><input name="dataAnotherOne47" id="dataAnotherOne47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 47</td>
      <td><input name="dataAnotherOne46" id="dataAnotherOne46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 46</td>
      <td><input name="dataAnotherOne45" id="dataAnotherOne45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 45</td>
      <td><input name="dataAnotherOne44" id="dataAnotherOne44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 44</td>
      <td><input name="dataAnotherOne43" id="dataAnotherOne43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 43</td>
      <td><input name="dataAnotherOne42" id="dataAnotherOne42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 42</td>
      <td><input name="dataAnotherOne41" id="dataAnotherOne41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 41</td>
      <td><input name="dataAnotherOne31" id="dataAnotherOne31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 31</td>
      <td><input name="dataAnotherOne32" id="dataAnotherOne32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 32</td>
      <td><input name="dataAnotherOne33" id="dataAnotherOne33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 33</td>
      <td><input name="dataAnotherOne34" id="dataAnotherOne34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 34</td>
      <td><input name="dataAnotherOne35" id="dataAnotherOne35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 35</td>
      <td><input name="dataAnotherOne36" id="dataAnotherOne36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 36</td>
      <td><input name="dataAnotherOne37" id="dataAnotherOne37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 37</td>
      <td><input name="dataAnotherOne38" id="dataAnotherOne38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherOne" name="teeth_18_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherOne" name="teeth_17_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherOne" name="teeth_16_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherOne" name="teeth_15_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherOne" name="teeth_14_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherOne" name="teeth_13_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherOne" name="teeth_12_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherOne" name="teeth_11_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherOne" name="teeth_21_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherOne" name="teeth_22_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>

</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherOne" name="teeth_23_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherOne" name="teeth_24_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherOne" name="teeth_25_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherOne" name="teeth_26_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherOne" name="teeth_27_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv28">
<label class="auto">28</label>
<select id="teeth_28" name="teeth_28" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherOne" name="teeth_48_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherOne" name="teeth_47_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherOne" name="teeth_46_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherOne" name="teeth_45_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
<div style="display:none" id="45AnotherDiv">
<input type="text" name="othersAnother45" id="othersAnother45" maxlength="128" tabindex="1">
</div>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherOne" name="teeth_44_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherOne" name="teeth_43_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherOne" name="teeth_42_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherOne" name="teeth_41_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherOne" name="teeth_31_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherOne" name="teeth_32_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherOne" name="teeth_33_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherOne" name="teeth_34_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherOne" name="teeth_35_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherOne" name="teeth_36_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherOne" name="teeth_37_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option></select>
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherOne" name="teeth_38_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="PDL: WNL">PDL: WNL</option>
<option value="PDL Space Widened">PDL Space Widened</option>
<option value="Alveolar Bone">Alveolar Bone</option>
<option value="Apical Lucency">Apical Lucency</option>
<option value="Lateral Lucency">Lateral Lucency</option>
<option value="Apical / Lateral Opacity">Apical / Lateral Opacity</option>
<option value="Crestal Bone Loss">Crestal Bone Loss</option>			 
</select>
</div>
<div class="clear"></div>

<h4>Sinus Tracing To</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="dataAnotherTwo18" id="dataAnotherTwo18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 18</td>
      <td><input name="dataAnotherTwo17" id="dataAnotherTwo17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 17</td>
      <td><input name="dataAnotherTwo16" id="dataAnotherTwo16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 16</td>
      <td><input name="dataAnotherTwo15" id="dataAnotherTwo15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 15</td>
      <td><input name="dataAnotherTwo14" id="dataAnotherTwo14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 14</td>
      <td><input name="dataAnotherTwo13" id="dataAnotherTwo13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 13</td>
      <td><input name="dataAnotherTwo12" id="dataAnotherTwo12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 12</td>
      <td><input name="dataAnotherTwo11" id="dataAnotherTwo11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 11</td>
      <td><input name="dataAnotherTwo21" id="dataAnotherTwo21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 21</td>
      <td><input name="dataAnotherTwo22" id="dataAnotherTwo22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 22</td>
      <td><input name="dataAnotherTwo23" id="dataAnotherTwo23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 23</td>
      <td><input name="dataAnotherTwo24" id="dataAnotherTwo24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 24</td>
      <td><input name="dataAnotherTwo25" id="dataAnotherTwo25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 25</td>
      <td><input name="dataAnotherTwo26" id="dataAnotherTwo26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 26</td>
      <td><input name="dataAnotherTwo27" id="dataAnotherTwo27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 27</td>
      <td><input name="dataAnotherTwo28" id="dataAnotherTwo28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherTwo48" id="dataAnotherTwo48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 48</td>
      <td><input name="dataAnotherTwo47" id="dataAnotherTwo47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 47</td>
      <td><input name="dataAnotherTwo46" id="dataAnotherTwo46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 46</td>
      <td><input name="dataAnotherTwo45" id="dataAnotherTwo45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 45</td>
      <td><input name="dataAnotherTwo44" id="dataAnotherTwo44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 44</td>
      <td><input name="dataAnotherTwo43" id="dataAnotherTwo43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 43</td>
      <td><input name="dataAnotherTwo42" id="dataAnotherTwo42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 42</td>
      <td><input name="dataAnotherTwo41" id="dataAnotherTwo41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 41</td>
      <td><input name="dataAnotherTwo31" id="dataAnotherTwo31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 31</td>
      <td><input name="dataAnotherTwo32" id="dataAnotherTwo32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 32</td>
      <td><input name="dataAnotherTwo33" id="dataAnotherTwo33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 33</td>
      <td><input name="dataAnotherTwo34" id="dataAnotherTwo34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 34</td>
      <td><input name="dataAnotherTwo35" id="dataAnotherTwo35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 35</td>
      <td><input name="dataAnotherTwo36" id="dataAnotherTwo36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 36</td>
      <td><input name="dataAnotherTwo37" id="dataAnotherTwo37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 37</td>
      <td><input name="dataAnotherTwo38" id="dataAnotherTwo38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv18">
<label class="auto">18</label>
<input type="text" name="sinusTracingDataValue18" id="sinusTracingDataValue18" maxlength="128" tabindex="1">
</div>
<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv17">
<label class="auto">17</label>
<input type="text" name="sinusTracingDataValue17" id="sinusTracingDataValue17" maxlength="128" tabindex="1">
</div>
<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv16">
<label class="auto">16</label>
<input type="text" name="sinusTracingDataValue16" id="sinusTracingDataValue16" maxlength="128" tabindex="1">
</div>
<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv15">
<label class="auto">15</label>
<input type="text" name="sinusTracingDataValue15" id="sinusTracingDataValue15" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv14">
<label class="auto">14</label>
<input type="text" name="sinusTracingDataValue14" id="sinusTracingDataValue14" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv13">
<label class="auto">13</label>
<input type="text" name="sinusTracingDataValue13" id="sinusTracingDataValue13" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv12">
<label class="auto">12</label>
<input type="text" name="sinusTracingDataValue12" id="sinusTracingDataValue12" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv11">
<label class="auto">11</label>
<input type="text" name="sinusTracingDataValue11" id="sinusTracingDataValue11" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv21">
<label class="auto">21</label>
<input type="text" name="sinusTracingDataValue21" id="sinusTracingDataValue21" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv22">
<label class="auto">22</label>
<input type="text" name="sinusTracingDataValue22" id="sinusTracingDataValue22" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv23">
<label class="auto">23</label>
<input type="text" name="sinusTracingDataValue23" id="sinusTracingDataValue23" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv24">
<label class="auto">24</label>
<input type="text" name="sinusTracingDataValue24" id="sinusTracingDataValue24" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv25">
<label class="auto">25</label>
<input type="text" name="sinusTracingDataValue25" id="sinusTracingDataValue25" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv26">
<label class="auto">26</label>
<input type="text" name="sinusTracingDataValue26" id="sinusTracingDataValue26" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv27">
<label class="auto">27</label>
<input type="text" name="sinusTracingDataValue27" id="sinusTracingDataValue27" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv28">
<label class="auto">28</label>
<input type="text" name="sinusTracingDataValue28" id="sinusTracingDataValue28" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv48">
<label class="auto">48</label>
<input type="text" name="sinusTracingDataValue48" id="sinusTracingDataValue48" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv47">
<label class="auto">47</label>
<input type="text" name="sinusTracingDataValue47" id="sinusTracingDataValue47" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv46">
<label class="auto">46</label>
<input type="text" name="sinusTracingDataValue46" id="sinusTracingDataValue46" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv45">
<label class="auto">45</label>
<input type="text" name="sinusTracingDataValue45" id="sinusTracingDataValue45" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv44">
<label class="auto">44</label>
<input type="text" name="sinusTracingDataValue44" id="sinusTracingDataValue44" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv43">
<label class="auto">43</label>
<input type="text" name="sinusTracingDataValue43" id="sinusTracingDataValue43" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv42">
<label class="auto">42</label>
<input type="text" name="sinusTracingDataValue42" id="sinusTracingDataValue42" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv41">
<label class="auto">41</label>
<input type="text" name="sinusTracingDataValue41" id="sinusTracingDataValue41" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv31">
<label class="auto">31</label>
<input type="text" name="sinusTracingDataValue31" id="sinusTracingDataValue31" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv32">
<label class="auto">32</label>
<input type="text" name="sinusTracingDataValue32" id="sinusTracingDataValue32" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv33">
<label class="auto">33</label>
<input type="text" name="sinusTracingDataValue33" id="sinusTracingDataValue33" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv34">
<label class="auto">34</label>
<input type="text" name="sinusTracingDataValue34" id="sinusTracingDataValue34" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv35">
<label class="auto">35</label>
<input type="text" name="sinusTracingDataValue35" id="sinusTracingDataValue35" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv36">
<label class="auto">36</label>
<input type="text" name="sinusTracingDataValue36" id="sinusTracingDataValue36" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv37">
<label class="auto">37</label>
<input type="text" name="sinusTracingDataValue37" id="sinusTracingDataValue37" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv38">
<label class="auto">38</label>
<input type="text" name="sinusTracingDataValue38" id="sinusTracingDataValue38" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>
<div class="clear"></div>

<h4>Vitality Testing</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="dataAnotherThree18" id="dataAnotherThree18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 18</td>
      <td><input name="dataAnotherThree17" id="dataAnotherThree17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 17</td>
      <td><input name="dataAnotherThree16" id="dataAnotherThree16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 16</td>
      <td><input name="dataAnotherThree15" id="dataAnotherThree15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 15</td>
      <td><input name="dataAnotherThree14" id="dataAnotherThree14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 14</td>
      <td><input name="dataAnotherThree13" id="dataAnotherThree13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 13</td>
      <td><input name="dataAnotherThree12" id="dataAnotherThree12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 12</td>
      <td><input name="dataAnotherThree11" id="dataAnotherThree11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 11</td>
      <td><input name="dataAnotherThree21" id="dataAnotherThree21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 21</td>
      <td><input name="dataAnotherThree22" id="dataAnotherThree22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 22</td>
      <td><input name="dataAnotherThree23" id="dataAnotherThree23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 23</td>
      <td><input name="dataAnotherThree24" id="dataAnotherThree24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 24</td>
      <td><input name="dataAnotherThree25" id="dataAnotherThree25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 25</td>
      <td><input name="dataAnotherThree26" id="dataAnotherThree26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 26</td>
      <td><input name="dataAnotherThree27" id="dataAnotherThree27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 27</td>
      <td><input name="dataAnotherThree28" id="dataAnotherThree28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherThree48" id="dataAnotherThree48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 48</td>
      <td><input name="dataAnotherThree47" id="dataAnotherThree47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 47</td>
      <td><input name="dataAnotherThree46" id="dataAnotherThree46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 46</td>
      <td><input name="dataAnotherThree45" id="dataAnotherThree45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 45</td>
      <td><input name="dataAnotherThree44" id="dataAnotherThree44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 44</td>
      <td><input name="dataAnotherThree43" id="dataAnotherThree43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 43</td>
      <td><input name="dataAnotherThree42" id="dataAnotherThree42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 42</td>
      <td><input name="dataAnotherThree41" id="dataAnotherThree41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 41</td>
      <td><input name="dataAnotherThree31" id="dataAnotherThree31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 31</td>
      <td><input name="dataAnotherThree32" id="dataAnotherThree32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 32</td>
      <td><input name="dataAnotherThree33" id="dataAnotherThree33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 33</td>
      <td><input name="dataAnotherThree34" id="dataAnotherThree34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 34</td>
      <td><input name="dataAnotherThree35" id="dataAnotherThree35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 35</td>
      <td><input name="dataAnotherThree36" id="dataAnotherThree36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 36</td>
      <td><input name="dataAnotherThree37" id="dataAnotherThree37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 37</td>
      <td><input name="dataAnotherThree38" id="dataAnotherThree38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv18">
<label class="auto">18</label>
<input type="text" name="vitalityTestDataValue18" id="vitalityTestDataValue18" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv17">
<label class="auto">17</label>
<input type="text" name="vitalityTestDataValue17" id="vitalityTestDataValue17" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv16">
<label class="auto">16</label>
<input type="text" name="vitalityTestDataValue16" id="vitalityTestDataValue16" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv15">
<label class="auto">15</label>
<input type="text" name="vitalityTestDataValue15" id="vitalityTestDataValue15" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv14">
<label class="auto">14</label>
<input type="text" name="vitalityTestDataValue14" id="vitalityTestDataValue14" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv13">
<label class="auto">13</label>
<input type="text" name="vitalityTestDataValue13" id="vitalityTestDataValue13" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv12">
<label class="auto">12</label>
<input type="text" name="vitalityTestDataValue12" id="vitalityTestDataValue12" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv11">
<label class="auto">11</label>
<input type="text" name="vitalityTestDataValue11" id="vitalityTestDataValue11" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv21">
<label class="auto">21</label>
<input type="text" name="vitalityTestDataValue21" id="vitalityTestDataValue21" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv22">
<label class="auto">22</label>
<input type="text" name="vitalityTestDataValue22" id="vitalityTestDataValue22" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv23">
<label class="auto">23</label>
<input type="text" name="vitalityTestDataValue23" id="vitalityTestDataValue23" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv24">
<label class="auto">24</label>
<input type="text" name="vitalityTestDataValue24" id="vitalityTestDataValue24" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv25">
<label class="auto">25</label>
<input type="text" name="vitalityTestDataValue25" id="vitalityTestDataValue25" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv26">
<label class="auto">26</label>
<input type="text" name="vitalityTestDataValue26" id="vitalityTestDataValue26" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv27">
<label class="auto">27</label>
<input type="text" name="vitalityTestDataValue27" id="vitalityTestDataValue27" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv28">
<label class="auto">28</label>
<input type="text" name="vitalityTestDataValue28" id="vitalityTestDataValue28" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv48">
<label class="auto">48</label>
<input type="text" name="vitalityTestDataValue48" id="vitalityTestDataValue48" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv47">
<label class="auto">47</label>
<input type="text" name="vitalityTestDataValue47" id="vitalityTestDataValue47" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv46">
<label class="auto">46</label>
<input type="text" name="vitalityTestDataValue46" id="vitalityTestDataValue46" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv45">
<label class="auto">45</label>
<input type="text" name="vitalityTestDataValue45" id="vitalityTestDataValue45" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv44">
<label class="auto">44</label>
<input type="text" name="vitalityTestDataValue44" id="vitalityTestDataValue44" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv43">
<label class="auto">43</label>
<input type="text" name="vitalityTestDataValue43" id="vitalityTestDataValue43" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv42">
<label class="auto">42</label>
<input type="text" name="vitalityTestDataValue42" id="vitalityTestDataValue42" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv41">
<label class="auto">41</label>
<input type="text" name="vitalityTestDataValue41" id="vitalityTestDataValue41" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv31">
<label class="auto">31</label>
<input type="text" name="vitalityTestDataValue31" id="vitalityTestDataValue31" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv32">
<label class="auto">32</label>
<input type="text" name="vitalityTestDataValue32" id="vitalityTestDataValue32" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv33">
<label class="auto">33</label>
<input type="text" name="vitalityTestDataValue33" id="vitalityTestDataValue33" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv34">
<label class="auto">34</label>
<input type="text" name="vitalityTestDataValue34" id="vitalityTestDataValue34" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv35">
<label class="auto">35</label>
<input type="text" name="vitalityTestDataValue35" id="vitalityTestDataValue35" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv36">
<label class="auto">36</label>
<input type="text" name="vitalityTestDataValue36" id="vitalityTestDataValue36" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv37">
<label class="auto">37</label>
<input type="text" name="vitalityTestDataValue37" id="vitalityTestDataValue37" maxlength="128" tabindex="1">
</div>

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv38">
<label class="auto">38</label>
<input type="text" name="vitalityTestDataValue38" id="vitalityTestDataValue38" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>


<h4>Treatment Plan</h4>
<div class="clear"></div>

<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForTreatmentPlan();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForTreatmentPlan();" type="button">
</div>

<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridTreatmentPlan">
  <tbody>
    <tr>
    <th></th>
      <th>Tooth</th>
      <th>Treatment</th>
      <th>Remarks</th>     
    </tr>
    <% int incTreatmentPlan=1; %>
    <tr>
    <td> <input type="checkbox" class="radioCheck" id="treatmentPlanRadio<%=incTreatmentPlan%>" name="treatmentPlanRadio<%=incTreatmentPlan%>"></td>
<td><select name="toothTreatmentPlan" id="toothTreatmentPlan<%=incTreatmentPlan %>" tabindex="1" >
<option value="">Select</option>
<option value="18">18</option>
<option value="17">17</option>
<option value="16">16</option>
<option value="15">15</option>
<option value="14">14</option>
<option value="13">13</option>
<option value="12">12</option>
<option value="11">11</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="16">28</option>
<option value="48">48</option>
<option value="47">47</option>
<option value="46">46</option>
<option value="45">45</option>
<option value="44">44</option>
<option value="43">43</option>
<option value="42">42</option>
<option value="41">41</option>
<option value="31">31</option>
<option value="32">32</option>
<option value="33">33</option>
<option value="34">34</option>
<option value="35">35</option>
<option value="36">36</option>
<option value="37">37</option>
<option value="38">38</option>
</select></td>

 <td><select name="treatmentTreatmentPlan<%=incTreatmentPlan %>" id="treatmentTreatmentPlan<%=incTreatmentPlan %>" tabindex="1" validate="Service Center,string,no" style="width:200px !important">
<option value="">Select</option>
<option value="Amalgam">Amalgam</option>
<option value="composite">composite</option>
<option value="GIC">GIC</option>
<option value="IRM">IRM</option>
<option value="Temporary filling">Temporary filling</option>
<option value="Inlay / Onlay">Inlay / Onlay</option>
<option value="Veneers">Veneers</option>
<option value="Jacket crown fabrication">Jacket crown fabrication</option>
<option value="RCT">RCT</option>
<option value="Re-RCT">Re-RCT</option>
<option value="Perforation / Resorption repair">Perforation / Resorption repair</option>
<option value="Fibre Post & Core build up">Fibre Post & Core build up</option>
<option value="Cast post fabrication">Cast post fabrication</option>
<option value="Direct pulp capping">Direct pulp capping</option>
<option value="Indirect pulp capping">Indirect pulp capping</option>
<option value="Pulpotomy">Pulpotomy</option>
<option value="Apexogenesis / Apexification">Apexogenesis / Apexification</option>
<option value="Regenerative therapy">Regenerative therapy</option>
<option value="Vital bleaching">Vital bleaching</option>
<option value="Non - Vital Bleaching">Non - Vital Bleaching</option>
<option value="desensitizing agent">desensitizing agent</option>
<option value="selective Grinding">selective Grinding</option>
<option value="Apicoectomy">Apicoectomy</option>
<option value="Peripical surgery">Peripical surgery</option>
<option value="I & D">I & D</option>
<option value="Orthodontic / Surgical Extrusion">Orthodontic / Surgical Extrusion</option>
<option value="Gingivectomy">Gingivectomy</option>
<option value="Spliniting">Spliniting</option>
<option value="Interdisciplinary approach">Interdisciplinary approach</option>
<option value="No active intervention needed">No active intervention needed</option>
<option value="Extraction">Extraction</option>
<option value="Patient not willing for treatment">Patient not willing for treatment</option>
<option value="Others">Others</option>
</select></td>
      <td><input type="text" name="remarksTreatmentPlan<%=incTreatmentPlan %>" id="remarksTreatmentPlan<%=incTreatmentPlan %>" maxlength="128" tabindex="1" class="largTextBoxOpd popper"></td>      
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbTreatmentPlan" value="<%=incTreatmentPlan%>" id="hdbTreatmentPlan" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


<h4>Treatment Done</h4>
<div class="clear"></div>

<div class="floatRight" style="margin-right: 10px;">
<input class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForTreatmentDone();" type="button">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForTreatmentDone();" type="button">
</div>

<div class="tableForTabNumber">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="gridTreatmentDone">
  <tbody>
    <tr>
    <th></th>
      <th>Tooth</th>
      <th>Treatment</th>
      <th>Remarks</th>     
    </tr>
    <% int incTreatmentDone=1; %>
    <tr>
     <td> <input type="checkbox" class="radioCheck" id="treatmentDoneRadio<%=incTreatmentDone%>" name="treatmentDoneRadio<%=incTreatmentDone%>"></td>
    <td><select name="toothTreatmentDone<%=incTreatmentDone %>" id="toothTreatmentDone<%=incTreatmentDone %>" tabindex="1" validate="Service Center,string,no">
<option value="">Select</option>
<option value="18">18</option>
<option value="17">17</option>
<option value="16">16</option>
<option value="15">15</option>
<option value="14">14</option>
<option value="13">13</option>
<option value="12">12</option>
<option value="11">11</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="16">28</option>
<option value="48">48</option>
<option value="47">47</option>
<option value="46">46</option>
<option value="45">45</option>
<option value="44">44</option>
<option value="43">43</option>
<option value="42">42</option>
<option value="41">41</option>
<option value="31">31</option>
<option value="32">32</option>
<option value="33">33</option>
<option value="34">34</option>
<option value="35">35</option>
<option value="36">36</option>
<option value="37">37</option>
<option value="38">38</option>
</select></td>

      <td><select name="treatmentTreatmentDone<%=incTreatmentDone %>" id="treatmentTreatmentDone<%=incTreatmentDone %>" tabindex="1" validate="Service Center,string,no" style="width:200px !important">
<option value="">Select</option>
<option value="Amalgam">Amalgam</option>
<option value="composite">composite</option>
<option value="GIC">GIC</option>
<option value="IRM">IRM</option>
<option value="Temporary filling">Temporary filling</option>
<option value="Inlay / Onlay">Inlay / Onlay</option>
<option value="Veneers">Veneers</option>
<option value="Jacket crown fabrication">Jacket crown fabrication</option>
<option value="RCT">RCT</option>
<option value="Re-RCT">Re-RCT</option>
<option value="Perforation / Resorption repair">Perforation / Resorption repair</option>
<option value="Fibre Post & Core build up">Fibre Post & Core build up</option>
<option value="Cast post fabrication">Cast post fabrication</option>
<option value="Direct pulp capping">Direct pulp capping</option>
<option value="Indirect pulp capping">Indirect pulp capping</option>
<option value="Pulpotomy">Pulpotomy</option>
<option value="Apexogenesis / Apexification">Apexogenesis / Apexification</option>
<option value="Regenerative therapy">Regenerative therapy</option>
<option value="Vital bleaching">Vital bleaching</option>
<option value="Non - Vital Bleaching">Non - Vital Bleaching</option>
<option value="desensitizing agent">desensitizing agent</option>
<option value="selective Grinding">selective Grinding</option>
<option value="Apicoectomy">Apicoectomy</option>
<option value="Peripical surgery">Peripical surgery</option>
<option value="I & D">I & D</option>
<option value="Orthodontic / Surgical Extrusion">Orthodontic / Surgical Extrusion</option>
<option value="Gingivectomy">Gingivectomy</option>
<option value="Spliniting">Spliniting</option>
<option value="Interdisciplinary approach">Interdisciplinary approach</option>
<option value="No active intervention needed">No active intervention needed</option>
<option value="Extraction">Extraction</option>
<option value="Patient not willing for treatment">Patient not willing for treatment</option>
<option value="Others">Others</option>
</select></td>
      <td><input type="text" name="remarksTreatmentDone<%=incTreatmentDone %>" id="remarksTreatmentDone<%=incTreatmentDone %>" maxlength="128" tabindex="1" class="largTextBoxOpd popper"></td>      
    </tr>
  </tbody>
</table>
</div>
<input type="hidden" name="hdbTreatmentDone" value="<%=incTreatmentDone%>" id="hdbTreatmentDone" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

</div>
</form>







