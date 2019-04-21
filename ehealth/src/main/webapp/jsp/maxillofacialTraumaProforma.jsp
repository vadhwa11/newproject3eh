<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>


<div class="titleBg"><h2>Maxillofacial Trauma - Proforma</h2></div>


<form method="post" action="">
<div class="Block">
<input id="maxillofacialTraumaProformaFlag" name="maxillofacialTraumaProformaFlag" tabindex="1" value="maxillofacialTraumaProformaFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Maxillofacial Trauma - Proforma"/>
<label>Cause of Injury</label>
<input type="text" name="caseOfInjury" id="caseOfInjury" maxlength="128" tabindex="1">

<label>Clinical Features</label>
<input type="text" name="clinicalFeatures" id="clinicalFeatures" maxlength="128" tabindex="1">
<div class="clear"></div>

<h4>Extra Oral Findings</h4>
<div class="clear"></div>

<label>Difficulty in Mastication</label>
<input type="checkbox" id="difficultyInMastication" name="difficultyInMastication" tabindex="2" value="Yes"  class="checkboxMargin">
<label>Ear Bleed</label>
<input type="checkbox" id="earBleed" name="earBleed" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Sublingual Hematoma</label>
<input type="checkbox" id="sublingualHematoma" name="sublingualHematoma" tabindex="2" value="Yes"  class="checkboxMargin">
<div class="clear"></div>

<label>Deranged Occlusion</label>
<input type="checkbox" id="derangedOcclusion" name="derangedOcclusion" tabindex="2" value="Yes"  class="checkboxMargin">
<label>Crepitus</label>
<input type="checkbox" id="crepitus" name="crepitus" tabindex="2" value="Yes"  class="checkboxMargin">
<label>Step Defect on Palpation</label>
<input type="checkbox" id="stepDefectOnPalpation" name="stepDefectOnPalpation" tabindex="2" value="Yes"   class="checkboxMargin">
<div class="clear"></div>

<label>Pain at Rest</label>
<input type="checkbox" id="painAtRest" name="painAtRest" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Pain on Mouth Opening</label>
<input type="checkbox" id="painOnMouthOpening" name="painOnMouthOpening" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Swelling</label>
<input type="checkbox" id="swelling" name="swelling" tabindex="2" value="Yes"   class="checkboxMargin">
<div class="clear"></div>

<label>Laceration</label>
<input type="checkbox" id="laceration" name="laceration" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Intra - Oral Bleed</label>
<input type="checkbox" id="intraOralBleed" name="intraOralBleed" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Trismus</label>
<input type="checkbox" id="trismus" name="trismus" tabindex="2" value="Yes"   class="checkboxMargin">
<div class="clear"></div>

<label>Broken Teeth</label>
<input type="checkbox" id="brokenTeeth" name="brokenTeeth" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Loss of Teeth</label>
<input type="checkbox" id="lossOfTeeth" name="lossOfTeeth" tabindex="2" value="Yes"   class="checkboxMargin">
<label>Tenderness</label>
<input type="checkbox" id="tenderness" name="tenderness" tabindex="2" value="Yes"   class="checkboxMargin">
<div class="clear"></div>

<label class="auto">Mandibular Deviation on Mouth Opening</label>
<input type="checkbox" id="mouthOpening" name="mouthOpening" tabindex="2" value="Yes"   style="margin-right: 102px;">

<label class="auto">Inability to do Lateral Jaw Movements</label>
<input type="checkbox" id="lateralJawMovements" name="lateralJawMovements" tabindex="2" value="Yes" validate="waiveCharge,int,yes" >
<div class="clear"></div>

<h4>Radiographic Rule in Trauma - Mandibuler Fracture</h4>
<div class="clear"></div>
<label>Step Defect</label>
<label class="auto">Yes</label> 
<input type="radio"	name="stepDefect" value="Yes" class="radiobutMargin" />
<label class="auto">No</label>  
<input type="radio"	name="stepDefect" value="No" style="margin-right:84px;" />

<label>Deranged Occlusion</label>
<label class="auto">Yes</label> 
<input type="radio"	name="derangedOcclusion" value="Yes" class="radiobutMargin" />
<label class="auto">No</label>  
<input type="radio"	name="derangedOcclusion" value="No" style="margin-right:84px;" />
<div class="clear"></div>
<label>Crepitus</label>
<label class="auto">Yes</label> 
<input type="radio"	name="crepitus" value="Yes" class="radiobutMargin" />
<label class="auto">No</label>  
<input type="radio"	name="crepitus" value="No" style="margin-right:84px;" />

<label>Sublingual Hematoma</label>
<label class="auto">Yes</label> 
<input type="radio"	name="sublingualHematoma" value="Yes" class="radiobutMargin" />
<label class="auto">No</label>  
<input type="radio"	name="sublingualHematoma" value="No" style="margin-right:84px;" />
<div class="clear"></div>
<label>If Yes to any of the above then</label>
<input type="text" name="otherRadigraphicValue" id="otherRadigraphicValue" class="large" maxlength="56" tabindex="1">
<div class="clear"></div>
<label>Site of fracture</label>
<input type="text" name="siteOfFarcture" id="siteOfFarcture" maxlength="128" tabindex="1">
<label>Radiographic diagnosis</label>
<input type="text" name="radioGraphicDiagnosis" id="radioGraphicDiagnosis" maxlength="128" tabindex="1">
<div class="clear"></div>
<h4>Intra Oral Findings</h4>
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

<h4>Radiographic and CT scan findings</h4>
<div class="clear"></div>

<label>Maxilla Fracture</label>
<input type="text" name="maxillaFracture" id="maxillaFracture" maxlength="128" tabindex="1">

<label>Mandible Fracture</label>
<input type="text" name="mandibleFracture" id="mandibleFracture" maxlength="128" tabindex="1">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
</div>



</form>




<style>
.mt4 {margin-top:4px !important;}
.mltpSlect {width:228px; float:left;}
</style>

