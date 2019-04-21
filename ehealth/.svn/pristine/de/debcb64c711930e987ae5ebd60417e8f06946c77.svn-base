
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>
<div class="titleBg"><h2>Removable Partial Prosthodontics</h2></div>

<form name="patientUpdate" method="post">
<div class="Block">
<input id="removablePartialProsthodonticsFlag" name="removablePartialProsthodonticsFlag" tabindex="1" value="removablePartialProsthodonticsFlag" type="hidden"  />
<input type="hidden" name="templateName" value="Removable Partial Prosthodontics"/>
<h4>Systemic Status</h4>
<div class="clear"></div>

<label>Medical History</label>
<select name="medicalHistory" id="medicalHistory" tabindex="1" >
<option value="">Select</option>
<option value="Diabetes">Diabetes</option>
<option value="Hypertension">Hypertension</option>
<option value="Arthritis">Arthritis</option>
<option value="Tuberculosis">Tuberculosis</option>
<option value="Asthma">Asthma</option>
<option value="Neuromuscular Disorder">Neuromuscular Disorder</option>
<option value="Cardiovascular Diseases">Cardiovascular Diseases</option>
<option value="Medication">Medication</option>
</select>

<div class="clear"></div>
<label>History of allergy</label>
<label class="auto">Yes</label>
<input tabindex="1" name="historyOfAllergy" id="historyOfAllergy" value="Yes" type="radio" class="radiobutMargin" onclick="displayTextValueRPP();">
<label class="auto">No</label>
<input tabindex="1" name="historyOfAllergy" id="historyOfAllergy" value="No" type="radio" style="margin-right:21px;" onclick="displayTextValueRPP();">
<div style="display:none" id="historyOfAllergyDiv">
<input type="text" name="historyOfAllergyValue" id="historyOfAllergyValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>
<label>Dental History</label>
<textarea rows="" cols="" id="dentalHistory" name="dentalHistory" style="margin:0px; width:550px;" maxlength="256" validate="Dental History,string,no"  onkeyup="return checkLength(this)"></textarea>


<h4>Clinical Examination</h4>
<div class="clear"></div>
<h4>Intra oral Examination</h4>
<div class="clear"></div>
<label>Oral Hygiene Status</label>
<select name="oralHygieneStatus" id="oralHygieneStatus" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Fair">Fair</option>
<option value="Poor">Poor</option>
</select>

<label>Condition of Periodontium</label>
<label class="wdth55">Healthy</label>
<input tabindex="1" name="conditionOfPeriodontium" id="" value="Healthy" type="radio" class="radiobutMargin">
<label class="wdth55">Diseased</label>
<input tabindex="1" name="conditionOfPeriodontium" id="" value="Diseased" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<label>Color of Gingiva</label>
<select name="colorOfGingiva" id="colorOfGingiva" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Pink">Pink</option>
<option value="Red">Red</option>
<option value="Pigmented">Pigmented</option>
</select>

<label>Contour of Gingiva</label>
<label class="wdth55">Normal</label>
<input tabindex="1" name="contourOfGingiva" id="" value="Normal" type="radio" class="radiobutMargin">
<label class="wdth55">Altered</label>
<input tabindex="1" name="contourOfGingiva" id="" value="Altered" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Pockets</h4>
<div class="clear"></div>
<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <!--   <tbody>
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
   -->
  
  
  <tbody>
   <tr>
      <td><input name="data18" id="data18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 18</td>
      <td><input name="data17" id="data17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 17</td>
      <td><input name="data16" id="data16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 16</td>
      <td><input name="data15" id="data15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 15</td>
      <td><input name="data14" id="data14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 14</td>
      <td><input name="data13" id="data13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 13</td>
      <td><input name="data12" id="data12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 12</td>
      <td><input name="data11" id="data11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 11</td>
      <td><input name="data21" id="data21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 21</td>
      <td><input name="data22" id="data22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 22</td>
      <td><input name="data23" id="data23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 23</td>
      <td><input name="data24" id="data24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 24</td>
      <td><input name="data25" id="data25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 25</td>
      <td><input name="data26" id="data26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 26</td>
      <td><input name="data27" id="data27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 27</td>
      <td><input name="data28" id="data28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 28</td>
    </tr>
    <tr>
      <td><input name="data48" id="data48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 48</td>
      <td><input name="data47" id="data47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 47</td>
      <td><input name="data46" id="data46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 46</td>
      <td><input name="data45" id="data45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 45</td>
      <td><input name="data44" id="data44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 44</td>
      <td><input name="data43" id="data43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 43</td>
      <td><input name="data42" id="data42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 42</td>
      <td><input name="data41" id="data41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 41</td>
      <td><input name="data31" id="data31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 31</td>
      <td><input name="data32" id="data32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 32</td>
      <td><input name="data33" id="data33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 33</td>
      <td><input name="data34" id="data34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 34</td>
      <td><input name="data35" id="data35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 35</td>
      <td><input name="data36" id="data36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 36</td>
      <td><input name="data37" id="data37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 37</td>
      <td><input name="data38" id="data38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenVal();"> 38</td>
    </tr>
        <input value="" type="hidden" name="dentalhiddenValue" id="dentalhiddenValue"/>
  </tbody>
</table>
</div>


<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>Tooth Mobility</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
   <tbody>
    <tr>
      <td><input name="dataAnother18" id="dataAnother18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();"> 18</td>
      <td><input name="dataAnother17" id="dataAnother17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  17</td>
      <td><input name="dataAnother16" id="dataAnother16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  16</td>
      <td><input name="dataAnother15" id="dataAnother15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  15</td>
      <td><input name="dataAnother14" id="dataAnother14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  14</td>
      <td><input name="dataAnother13" id="dataAnother13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  13</td>
      <td><input name="dataAnother12" id="dataAnother12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  12</td>
      <td><input name="dataAnother11" id="dataAnother11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  11</td>
      <td><input name="dataAnother21" id="dataAnother21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  21</td>
      <td><input name="dataAnother22" id="dataAnother22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  22</td>
      <td><input name="dataAnother23" id="dataAnother23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  23</td>
      <td><input name="dataAnother24" id="dataAnother24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  24</td>
      <td><input name="dataAnother25" id="dataAnother25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  25</td>
      <td><input name="dataAnother26" id="dataAnother26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  26</td>
      <td><input name="dataAnother27" id="dataAnother27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  27</td>
      <td><input name="dataAnother28" id="dataAnother28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  28</td>
    </tr>
    <tr>
      <td><input name="dataAnother48" id="dataAnother48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  48</td>
      <td><input name="dataAnother47" id="dataAnother47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  47</td>
      <td><input name="dataAnother46" id="dataAnother46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  46</td>
      <td><input name="dataAnother45" id="dataAnother45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  45</td>
      <td><input name="dataAnother44" id="dataAnother44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  44</td>
      <td><input name="dataAnother43" id="dataAnother43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  43</td>
      <td><input name="dataAnother42" id="dataAnother42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  42</td>
      <td><input name="dataAnother41" id="dataAnother41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  41</td>
      <td><input name="dataAnother31" id="dataAnother31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  31</td>
      <td><input name="dataAnother32" id="dataAnother32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  32</td>
      <td><input name="dataAnother33" id="dataAnother33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  33</td>
      <td><input name="dataAnother34" id="dataAnother34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  34</td>
      <td><input name="dataAnother35" id="dataAnother35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  35</td>
      <td><input name="dataAnother36" id="dataAnother36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  36</td>
      <td><input name="dataAnother37" id="dataAnother37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  37</td>
      <td><input name="dataAnother38" id="dataAnother38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValAnother();">  38</td>
    </tr>
        <input value="" type="hidden" name="dentalhiddenValueAnother" id="dentalhiddenValueAnother"/>
  </tbody>
  
  
  
   <!-- <tbody>
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
  </tbody> -->
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="hidden" name="flagTeeth" id="flagTeeth" maxlength="20" tabindex="1" value="Impactions">
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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>

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
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>Examination of Teeth</h4>
<div class="clear"></div>

<h4>Carious Lesion</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="dataAnotherOne18" id="dataAnotherOne18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 18</td>
      <td><input name="dataAnotherOne17" id="dataAnotherOne17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 17</td>
      <td><input name="dataAnotherOne16" id="dataAnotherOne16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 16</td>
      <td><input name="dataAnotherOne15" id="dataAnotherOne15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 15</td>
      <td><input name="dataAnotherOne14" id="dataAnotherOne14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 14</td>
      <td><input name="dataAnotherOne13" id="dataAnotherOne13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 13</td>
      <td><input name="dataAnotherOne12" id="dataAnotherOne12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 12</td>
      <td><input name="dataAnotherOne11" id="dataAnotherOne11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 11</td>
      <td><input name="dataAnotherOne21" id="dataAnotherOne21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 21</td>
      <td><input name="dataAnotherOne22" id="dataAnotherOne22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 22</td>
      <td><input name="dataAnotherOne23" id="dataAnotherOne23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 23</td>
      <td><input name="dataAnotherOne24" id="dataAnotherOne24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 24</td>
      <td><input name="dataAnotherOne25" id="dataAnotherOne25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 25</td>
      <td><input name="dataAnotherOne26" id="dataAnotherOne26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 26</td>
      <td><input name="dataAnotherOne27" id="dataAnotherOne27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 27</td>
      <td><input name="dataAnotherOne28" id="dataAnotherOne28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherOne48" id="dataAnotherOne48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 48</td>
      <td><input name="dataAnotherOne47" id="dataAnotherOne47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 47</td>
      <td><input name="dataAnotherOne46" id="dataAnotherOne46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 46</td>
      <td><input name="dataAnotherOne45" id="dataAnotherOne45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 45</td>
      <td><input name="dataAnotherOne44" id="dataAnotherOne44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 44</td>
      <td><input name="dataAnotherOne43" id="dataAnotherOne43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 43</td>
      <td><input name="dataAnotherOne42" id="dataAnotherOne42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 42</td>
      <td><input name="dataAnotherOne41" id="dataAnotherOne41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 41</td>
      <td><input name="dataAnotherOne31" id="dataAnotherOne31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 31</td>
      <td><input name="dataAnotherOne32" id="dataAnotherOne32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 32</td>
      <td><input name="dataAnotherOne33" id="dataAnotherOne33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 33</td>
      <td><input name="dataAnotherOne34" id="dataAnotherOne34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 34</td>
      <td><input name="dataAnotherOne35" id="dataAnotherOne35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 35</td>
      <td><input name="dataAnotherOne36" id="dataAnotherOne36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 36</td>
      <td><input name="dataAnotherOne37" id="dataAnotherOne37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 37</td>
      <td><input name="dataAnotherOne38" id="dataAnotherOne38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeOne();"> 38</td>
    </tr>
    
  </tbody>
  
  <!-- <tbody>
    <tr>
      <td><input name="dataAnotherOne18" id="dataAnotherOne18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 18</td>
      <td><input name="dataAnotherOne17" id="dataAnotherOne17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 17</td>
      <td><input name="dataAnotherOne16" id="dataAnotherOne16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 16</td>
      <td><input name="dataAnotherOne15" id="dataAnotherOne15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 15</td>
      <td><input name="dataAnotherOne14" id="dataAnotherOne14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 14</td>
      <td><input name="dataAnotherOne13" id="dataAnotherOne13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 13</td>
      <td><input name="dataAnotherOne12" id="dataAnotherOne12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherOne();"> 12</td>
      <td><input name="dataAnotherOne11" id="dataAnotherOne11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherOne();" > 11</td>
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
  </tbody> -->
      <input value="" type="hidden" name="dentalhiddenValueOne" id="dentalhiddenValueOne"/>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherOne" name="teeth_18_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherOne" name="teeth_17_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherOne" name="teeth_16_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherOne" name="teeth_15_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherOne" name="teeth_14_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherOne" name="teeth_13_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherOne" name="teeth_12_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherOne" name="teeth_11_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherOne" name="teeth_21_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherOne" name="teeth_22_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherOne" name="teeth_23_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherOne" name="teeth_24_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherOne" name="teeth_25_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherOne" name="teeth_26_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherOne" name="teeth_27_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherOne" name="teeth_28_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherOne" name="teeth_48_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherOne" name="teeth_47_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherOne" name="teeth_46_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherOne" name="teeth_45_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherOne" name="teeth_44_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherOne" name="teeth_43_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherOne" name="teeth_42_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherOne" name="teeth_41_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherOne" name="teeth_31_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherOne" name="teeth_32_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherOne" name="teeth_33_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherOne" name="teeth_34_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherOne" name="teeth_35_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherOne" name="teeth_36_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherOne" name="teeth_37_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherOneDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherOne" name="teeth_38_valueAnotherOne" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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


<h4>Colour Variation of Enamel</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
 <tbody>
    <tr>
      <td><input name="dataAnotherTwo18" id="dataAnotherTwo18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();">  18</td>
      <td><input name="dataAnotherTwo17" id="dataAnotherTwo17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 17</td>
      <td><input name="dataAnotherTwo16" id="dataAnotherTwo16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 16</td>
      <td><input name="dataAnotherTwo15" id="dataAnotherTwo15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 15</td>
      <td><input name="dataAnotherTwo14" id="dataAnotherTwo14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 14</td>
      <td><input name="dataAnotherTwo13" id="dataAnotherTwo13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 13</td>
      <td><input name="dataAnotherTwo12" id="dataAnotherTwo12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 12</td>
      <td><input name="dataAnotherTwo11" id="dataAnotherTwo11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 11</td>
      <td><input name="dataAnotherTwo21" id="dataAnotherTwo21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 21</td>
      <td><input name="dataAnotherTwo22" id="dataAnotherTwo22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 22</td>
      <td><input name="dataAnotherTwo23" id="dataAnotherTwo23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 23</td>
      <td><input name="dataAnotherTwo24" id="dataAnotherTwo24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 24</td>
      <td><input name="dataAnotherTwo25" id="dataAnotherTwo25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 25</td>
      <td><input name="dataAnotherTwo26" id="dataAnotherTwo26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 26</td>
      <td><input name="dataAnotherTwo27" id="dataAnotherTwo27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 27</td>
      <td><input name="dataAnotherTwo28" id="dataAnotherTwo28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherTwo48" id="dataAnotherTwo48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 48</td>
      <td><input name="dataAnotherTwo47" id="dataAnotherTwo47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 47</td>
      <td><input name="dataAnotherTwo46" id="dataAnotherTwo46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 46</td>
      <td><input name="dataAnotherTwo45" id="dataAnotherTwo45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 45</td>
      <td><input name="dataAnotherTwo44" id="dataAnotherTwo44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 44</td>
      <td><input name="dataAnotherTwo43" id="dataAnotherTwo43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 43</td>
      <td><input name="dataAnotherTwo42" id="dataAnotherTwo42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 42</td>
      <td><input name="dataAnotherTwo41" id="dataAnotherTwo41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 41</td>
      <td><input name="dataAnotherTwo31" id="dataAnotherTwo31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 31</td>
      <td><input name="dataAnotherTwo32" id="dataAnotherTwo32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 32</td>
      <td><input name="dataAnotherTwo33" id="dataAnotherTwo33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 33</td>
      <td><input name="dataAnotherTwo34" id="dataAnotherTwo34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 34</td>
      <td><input name="dataAnotherTwo35" id="dataAnotherTwo35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 35</td>
      <td><input name="dataAnotherTwo36" id="dataAnotherTwo36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 36</td>
      <td><input name="dataAnotherTwo37" id="dataAnotherTwo37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 37</td>
      <td><input name="dataAnotherTwo38" id="dataAnotherTwo38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeTwo();"> 38</td>
    </tr>
     <input value="" type="hidden" name="dentalhiddenValueTwo" id="dentalhiddenValueTwo"/>
  </tbody>
  
  <!-- <tbody>
    <tr>
      <td><input name="dataAnotherTwo18" id="dataAnotherTwo18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 18</td>
      <td><input name="dataAnotherTwo17" id="dataAnotherTwo17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 17</td>
      <td><input name="dataAnotherTwo16" id="dataAnotherTwo16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 16</td>
      <td><input name="dataAnotherTwo15" id="dataAnotherTwo15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 15</td>
      <td><input name="dataAnotherTwo14" id="dataAnotherTwo14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 14</td>
      <td><input name="dataAnotherTwo13" id="dataAnotherTwo13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 13</td>
      <td><input name="dataAnotherTwo12" id="dataAnotherTwo12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherTwo();"> 12</td>
      <td><input name="dataAnotherTwo11" id="dataAnotherTwo11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherTwo();" > 11</td>
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
  </tbody> -->
   
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherTwo" name="teeth_18_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherTwo" name="teeth_17_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherTwo" name="teeth_16_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherTwo" name="teeth_15_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherTwo" name="teeth_14_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherTwo" name="teeth_13_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherTwo" name="teeth_12_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherTwo" name="teeth_11_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherTwo" name="teeth_21_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherTwo" name="teeth_22_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherTwo" name="teeth_23_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherTwo" name="teeth_24_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherTwo" name="teeth_25_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherTwo" name="teeth_26_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherTwo" name="teeth_27_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherTwo" name="teeth_28_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherTwo" name="teeth_48_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherTwo" name="teeth_47_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherTwo" name="teeth_46_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherTwo" name="teeth_45_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherTwo" name="teeth_44_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherTwo" name="teeth_43_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherTwo" name="teeth_42_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherTwo" name="teeth_41_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherTwo" name="teeth_31_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherTwo" name="teeth_32_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherTwo" name="teeth_33_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherTwo" name="teeth_34_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherTwo" name="teeth_35_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherTwo" name="teeth_36_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherTwo" name="teeth_37_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherTwoDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherTwo" name="teeth_38_valueAnotherTwo" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<h4>Evidence of Erosion</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
   <tbody>
    <tr>
      <td><input name="dataAnotherThree18" id="dataAnotherThree18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 18</td>
      <td><input name="dataAnotherThree17" id="dataAnotherThree17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 17</td>
      <td><input name="dataAnotherThree16" id="dataAnotherThree16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 16</td>
      <td><input name="dataAnotherThree15" id="dataAnotherThree15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 15</td>
      <td><input name="dataAnotherThree14" id="dataAnotherThree14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 14</td>
      <td><input name="dataAnotherThree13" id="dataAnotherThree13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 13</td>
      <td><input name="dataAnotherThree12" id="dataAnotherThree12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 12</td>
      <td><input name="dataAnotherThree11" id="dataAnotherThree11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 11</td>
      <td><input name="dataAnotherThree21" id="dataAnotherThree21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 21</td>
      <td><input name="dataAnotherThree22" id="dataAnotherThree22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 22</td>
      <td><input name="dataAnotherThree23" id="dataAnotherThree23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 23</td>
      <td><input name="dataAnotherThree24" id="dataAnotherThree24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 24</td>
      <td><input name="dataAnotherThree25" id="dataAnotherThree25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 25</td>
      <td><input name="dataAnotherThree26" id="dataAnotherThree26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 26</td>
      <td><input name="dataAnotherThree27" id="dataAnotherThree27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 27</td>
      <td><input name="dataAnotherThree28" id="dataAnotherThree28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherThree48" id="dataAnotherThree48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 48</td>
      <td><input name="dataAnotherThree47" id="dataAnotherThree47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 47</td>
      <td><input name="dataAnotherThree46" id="dataAnotherThree46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 46</td>
      <td><input name="dataAnotherThree45" id="dataAnotherThree45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 45</td>
      <td><input name="dataAnotherThree44" id="dataAnotherThree44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 44</td>
      <td><input name="dataAnotherThree43" id="dataAnotherThree43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 43</td>
      <td><input name="dataAnotherThree42" id="dataAnotherThree42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 42</td>
      <td><input name="dataAnotherThree41" id="dataAnotherThree41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 41</td>
      <td><input name="dataAnotherThree31" id="dataAnotherThree31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 31</td>
      <td><input name="dataAnotherThree32" id="dataAnotherThree32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 32</td>
      <td><input name="dataAnotherThree33" id="dataAnotherThree33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 33</td>
      <td><input name="dataAnotherThree34" id="dataAnotherThree34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 34</td>
      <td><input name="dataAnotherThree35" id="dataAnotherThree35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 35</td>
      <td><input name="dataAnotherThree36" id="dataAnotherThree36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 36</td>
      <td><input name="dataAnotherThree37" id="dataAnotherThree37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 37</td>
      <td><input name="dataAnotherThree38" id="dataAnotherThree38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeThree();"> 38</td>
    </tr>
  </tbody>
  
  <!-- 
  
  <tbody>
    <tr>
      <td><input name="dataAnotherThree18" id="dataAnotherThree18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 18</td>
      <td><input name="dataAnotherThree17" id="dataAnotherThree17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 17</td>
      <td><input name="dataAnotherThree16" id="dataAnotherThree16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 16</td>
      <td><input name="dataAnotherThree15" id="dataAnotherThree15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 15</td>
      <td><input name="dataAnotherThree14" id="dataAnotherThree14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 14</td>
      <td><input name="dataAnotherThree13" id="dataAnotherThree13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 13</td>
      <td><input name="dataAnotherThree12" id="dataAnotherThree12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherThree();"> 12</td>
      <td><input name="dataAnotherThree11" id="dataAnotherThree11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherThree();" > 11</td>
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
  </tbody> -->
   <input value="" type="hidden" name="dentalhiddenValueThree" id="dentalhiddenValueThree"/>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherThree" name="teeth_18_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherThree" name="teeth_17_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherThree" name="teeth_16_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherThree" name="teeth_15_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherThree" name="teeth_14_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherThree" name="teeth_13_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherThree" name="teeth_12_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherThree" name="teeth_11_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherThree" name="teeth_21_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherThree" name="teeth_22_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherThree" name="teeth_23_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherThree" name="teeth_24_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherThree" name="teeth_25_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherThree" name="teeth_26_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherThree" name="teeth_27_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherThree" name="teeth_28_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherThree" name="teeth_48_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherThree" name="teeth_47_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherThree" name="teeth_46_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherThree" name="teeth_45_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherThree" name="teeth_44_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherThree" name="teeth_43_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherThree" name="teeth_42_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherThree" name="teeth_41_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherThree" name="teeth_31_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherThree" name="teeth_32_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherThree" name="teeth_33_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherThree" name="teeth_34_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherThree" name="teeth_35_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherThree" name="teeth_36_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherThree" name="teeth_37_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherThreeDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherThree" name="teeth_38_valueAnotherThree" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<h4>Areas of Abrasion</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
    <tbody>
    <tr>
      <td><input name="dataAnotherFour18" id="dataAnotherFour18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 18</td>
      <td><input name="dataAnotherFour17" id="dataAnotherFour17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 17</td>
      <td><input name="dataAnotherFour16" id="dataAnotherFour16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 16</td>
      <td><input name="dataAnotherFour15" id="dataAnotherFour15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 15</td>
      <td><input name="dataAnotherFour14" id="dataAnotherFour14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 14</td>
      <td><input name="dataAnotherFour13" id="dataAnotherFour13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 13</td>
      <td><input name="dataAnotherFour12" id="dataAnotherFour12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 12</td>
      <td><input name="dataAnotherFour11" id="dataAnotherFour11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 11</td>
      <td><input name="dataAnotherFour21" id="dataAnotherFour21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 21</td>
      <td><input name="dataAnotherFour22" id="dataAnotherFour22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 22</td>
      <td><input name="dataAnotherFour23" id="dataAnotherFour23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 23</td>
      <td><input name="dataAnotherFour24" id="dataAnotherFour24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 24</td>
      <td><input name="dataAnotherFour25" id="dataAnotherFour25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 25</td>
      <td><input name="dataAnotherFour26" id="dataAnotherFour26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 26</td>
      <td><input name="dataAnotherFour27" id="dataAnotherFour27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 27</td>
      <td><input name="dataAnotherFour28" id="dataAnotherFour28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherFour48" id="dataAnotherFour48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 48</td>
      <td><input name="dataAnotherFour47" id="dataAnotherFour47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 47</td>
      <td><input name="dataAnotherFour46" id="dataAnotherFour46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 46</td>
      <td><input name="dataAnotherFour45" id="dataAnotherFour45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 45</td>
      <td><input name="dataAnotherFour44" id="dataAnotherFour44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 44</td>
      <td><input name="dataAnotherFour43" id="dataAnotherFour43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 43</td>
      <td><input name="dataAnotherFour42" id="dataAnotherFour42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 42</td>
      <td><input name="dataAnotherFour41" id="dataAnotherFour41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 41</td>
      <td><input name="dataAnotherFour31" id="dataAnotherFour31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 31</td>
      <td><input name="dataAnotherFour32" id="dataAnotherFour32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 32</td>
      <td><input name="dataAnotherFour33" id="dataAnotherFour33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 33</td>
      <td><input name="dataAnotherFour34" id="dataAnotherFour34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 34</td>
      <td><input name="dataAnotherFour35" id="dataAnotherFour35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 35</td>
      <td><input name="dataAnotherFour36" id="dataAnotherFour36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 36</td>
      <td><input name="dataAnotherFour37" id="dataAnotherFour37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 37</td>
      <td><input name="dataAnotherFour38" id="dataAnotherFour38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFour();"> 38</td>
    </tr>
  </tbody>
  <!-- 
   <tbody>
    <tr>
      <td><input name="dataAnotherFour18" id="dataAnotherFour18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 18</td>
      <td><input name="dataAnotherFour17" id="dataAnotherFour17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 17</td>
      <td><input name="dataAnotherFour16" id="dataAnotherFour16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 16</td>
      <td><input name="dataAnotherFour15" id="dataAnotherFour15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 15</td>
      <td><input name="dataAnotherFour14" id="dataAnotherFour14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 14</td>
      <td><input name="dataAnotherFour13" id="dataAnotherFour13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 13</td>
      <td><input name="dataAnotherFour12" id="dataAnotherFour12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 12</td>
      <td><input name="dataAnotherFour11" id="dataAnotherFour11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherFour();" > 11</td>
      <td><input name="dataAnotherFour21" id="dataAnotherFour21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 21</td>
      <td><input name="dataAnotherFour22" id="dataAnotherFour22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 22</td>
      <td><input name="dataAnotherFour23" id="dataAnotherFour23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 23</td>
      <td><input name="dataAnotherFour24" id="dataAnotherFour24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 24</td>
      <td><input name="dataAnotherFour25" id="dataAnotherFour25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 25</td>
      <td><input name="dataAnotherFour26" id="dataAnotherFour26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 26</td>
      <td><input name="dataAnotherFour27" id="dataAnotherFour27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 27</td>
      <td><input name="dataAnotherFour28" id="dataAnotherFour28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherFour48" id="dataAnotherFour48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 48</td>
      <td><input name="dataAnotherFour47" id="dataAnotherFour47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 47</td>
      <td><input name="dataAnotherFour46" id="dataAnotherFour46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 46</td>
      <td><input name="dataAnotherFour45" id="dataAnotherFour45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 45</td>
      <td><input name="dataAnotherFour44" id="dataAnotherFour44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 44</td>
      <td><input name="dataAnotherFour43" id="dataAnotherFour43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 43</td>
      <td><input name="dataAnotherFour42" id="dataAnotherFour42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 42</td>
      <td><input name="dataAnotherFour41" id="dataAnotherFour41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 41</td>
      <td><input name="dataAnotherFour31" id="dataAnotherFour31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 31</td>
      <td><input name="dataAnotherFour32" id="dataAnotherFour32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 32</td>
      <td><input name="dataAnotherFour33" id="dataAnotherFour33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 33</td>
      <td><input name="dataAnotherFour34" id="dataAnotherFour34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 34</td>
      <td><input name="dataAnotherFour35" id="dataAnotherFour35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 35</td>
      <td><input name="dataAnotherFour36" id="dataAnotherFour36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 36</td>
      <td><input name="dataAnotherFour37" id="dataAnotherFour37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 37</td>
      <td><input name="dataAnotherFour38" id="dataAnotherFour38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFour();"> 38</td>
    </tr>
  </tbody> -->
   <input value="" type="hidden" name="dentalhiddenValueFour" id="dentalhiddenValueFour"/>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherFour" name="teeth_18_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherFour" name="teeth_17_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherFour" name="teeth_16_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherFour" name="teeth_15_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherFour" name="teeth_14_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherFour" name="teeth_13_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherFour" name="teeth_12_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherFour" name="teeth_11_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherFour" name="teeth_21_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherFour" name="teeth_22_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherFour" name="teeth_23_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherFour" name="teeth_24_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherFour" name="teeth_25_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherFour" name="teeth_26_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherFour" name="teeth_27_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherFour" name="teeth_28_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherFour" name="teeth_48_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherFour" name="teeth_47_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherFour" name="teeth_46_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherFour" name="teeth_45_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherFour" name="teeth_44_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherFour" name="teeth_43_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherFour" name="teeth_42_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherFour" name="teeth_41_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherFour" name="teeth_31_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherFour" name="teeth_32_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherFour" name="teeth_33_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherFour" name="teeth_34_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherFour" name="teeth_35_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherFour" name="teeth_36_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherFour" name="teeth_37_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFourDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherFour" name="teeth_38_valueAnotherFour" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<h4>Areas of Occlusal Wear</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
 <tbody>
    <tr>
      <td><input name="dataAnotherFive18" id="dataAnotherFive18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 18</td>
      <td><input name="dataAnotherFive17" id="dataAnotherFive17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 17</td>
      <td><input name="dataAnotherFive16" id="dataAnotherFive16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 16</td>
      <td><input name="dataAnotherFive15" id="dataAnotherFive15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 15</td>
      <td><input name="dataAnotherFive14" id="dataAnotherFive14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 14</td>
      <td><input name="dataAnotherFive13" id="dataAnotherFive13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 13</td>
      <td><input name="dataAnotherFive12" id="dataAnotherFive12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 12</td>
      <td><input name="dataAnotherFive11" id="dataAnotherFive11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 11</td>
      <td><input name="dataAnotherFive21" id="dataAnotherFive21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 21</td>
      <td><input name="dataAnotherFive22" id="dataAnotherFive22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 22</td>
      <td><input name="dataAnotherFive23" id="dataAnotherFive23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 23</td>
      <td><input name="dataAnotherFive24" id="dataAnotherFive24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 24</td>
      <td><input name="dataAnotherFive25" id="dataAnotherFive25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 25</td>
      <td><input name="dataAnotherFive26" id="dataAnotherFive26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 26</td>
      <td><input name="dataAnotherFive27" id="dataAnotherFive27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 27</td>
      <td><input name="dataAnotherFive28" id="dataAnotherFive28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherFive48" id="dataAnotherFive48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 48</td>
      <td><input name="dataAnotherFive47" id="dataAnotherFive47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 47</td>
      <td><input name="dataAnotherFive46" id="dataAnotherFive46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 46</td>
      <td><input name="dataAnotherFive45" id="dataAnotherFive45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 45</td>
      <td><input name="dataAnotherFive44" id="dataAnotherFive44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 44</td>
      <td><input name="dataAnotherFive43" id="dataAnotherFive43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 43</td>
      <td><input name="dataAnotherFive42" id="dataAnotherFive42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 42</td>
      <td><input name="dataAnotherFive41" id="dataAnotherFive41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 41</td>
      <td><input name="dataAnotherFive31" id="dataAnotherFive31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 31</td>
      <td><input name="dataAnotherFive32" id="dataAnotherFive32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 32</td>
      <td><input name="dataAnotherFive33" id="dataAnotherFive33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 33</td>
      <td><input name="dataAnotherFive34" id="dataAnotherFive34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 34</td>
      <td><input name="dataAnotherFive35" id="dataAnotherFive35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 35</td>
      <td><input name="dataAnotherFive36" id="dataAnotherFive36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 36</td>
      <td><input name="dataAnotherFive37" id="dataAnotherFive37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 37</td>
      <td><input name="dataAnotherFive38" id="dataAnotherFive38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeFive();"> 38</td>
    </tr>
  </tbody>
 
 <!-- 
  <tbody>
    <tr>
      <td><input name="dataAnotherFive18" id="dataAnotherFive18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 18</td>
      <td><input name="dataAnotherFive17" id="dataAnotherFive17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 17</td>
      <td><input name="dataAnotherFive16" id="dataAnotherFive16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 16</td>
      <td><input name="dataAnotherFive15" id="dataAnotherFive15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 15</td>
      <td><input name="dataAnotherFive14" id="dataAnotherFive14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 14</td>
      <td><input name="dataAnotherFive13" id="dataAnotherFive13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 13</td>
      <td><input name="dataAnotherFive12" id="dataAnotherFive12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 12</td>
      <td><input name="dataAnotherFive11" id="dataAnotherFive11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherFive();" > 11</td>
      <td><input name="dataAnotherFive21" id="dataAnotherFive21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 21</td>
      <td><input name="dataAnotherFive22" id="dataAnotherFive22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 22</td>
      <td><input name="dataAnotherFive23" id="dataAnotherFive23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 23</td>
      <td><input name="dataAnotherFive24" id="dataAnotherFive24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 24</td>
      <td><input name="dataAnotherFive25" id="dataAnotherFive25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 25</td>
      <td><input name="dataAnotherFive26" id="dataAnotherFive26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 26</td>
      <td><input name="dataAnotherFive27" id="dataAnotherFive27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 27</td>
      <td><input name="dataAnotherFive28" id="dataAnotherFive28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherFive48" id="dataAnotherFive48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 48</td>
      <td><input name="dataAnotherFive47" id="dataAnotherFive47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 47</td>
      <td><input name="dataAnotherFive46" id="dataAnotherFive46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 46</td>
      <td><input name="dataAnotherFive45" id="dataAnotherFive45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 45</td>
      <td><input name="dataAnotherFive44" id="dataAnotherFive44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 44</td>
      <td><input name="dataAnotherFive43" id="dataAnotherFive43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 43</td>
      <td><input name="dataAnotherFive42" id="dataAnotherFive42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 42</td>
      <td><input name="dataAnotherFive41" id="dataAnotherFive41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 41</td>
      <td><input name="dataAnotherFive31" id="dataAnotherFive31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 31</td>
      <td><input name="dataAnotherFive32" id="dataAnotherFive32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 32</td>
      <td><input name="dataAnotherFive33" id="dataAnotherFive33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 33</td>
      <td><input name="dataAnotherFive34" id="dataAnotherFive34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 34</td>
      <td><input name="dataAnotherFive35" id="dataAnotherFive35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 35</td>
      <td><input name="dataAnotherFive36" id="dataAnotherFive36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 36</td>
      <td><input name="dataAnotherFive37" id="dataAnotherFive37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 37</td>
      <td><input name="dataAnotherFive38" id="dataAnotherFive38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherFive();"> 38</td>
    </tr>
  </tbody> --> 
   <input value="" type="hidden" name="dentalhiddenValueFive" id="dentalhiddenValueFive"/>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherFive" name="teeth_18_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherFive" name="teeth_17_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherFive" name="teeth_16_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherFive" name="teeth_15_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherFive" name="teeth_14_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherFive" name="teeth_13_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherFive" name="teeth_12_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherFive" name="teeth_11_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherFive" name="teeth_21_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherFive" name="teeth_22_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherFive" name="teeth_23_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherFive" name="teeth_24_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherFive" name="teeth_25_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherFive" name="teeth_26_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherFive" name="teeth_27_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherFive" name="teeth_28_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherFive" name="teeth_48_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherFive" name="teeth_47_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherFive" name="teeth_46_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherFive" name="teeth_45_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherFive" name="teeth_44_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherFive" name="teeth_43_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherFive" name="teeth_42_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherFive" name="teeth_41_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherFive" name="teeth_31_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherFive" name="teeth_32_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherFive" name="teeth_33_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherFive" name="teeth_34_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherFive" name="teeth_35_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherFive" name="teeth_36_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherFive" name="teeth_37_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherFiveDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherFive" name="teeth_38_valueAnotherFive" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<h4>Restorations</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
    <tbody>
    <tr>
      <td><input name="dataAnotherSix18" id="dataAnotherSix18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 18</td>
      <td><input name="dataAnotherSix17" id="dataAnotherSix17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 17</td>
      <td><input name="dataAnotherSix16" id="dataAnotherSix16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 16</td>
      <td><input name="dataAnotherSix15" id="dataAnotherSix15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 15</td>
      <td><input name="dataAnotherSix14" id="dataAnotherSix14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 14</td>
      <td><input name="dataAnotherSix13" id="dataAnotherSix13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 13</td>
      <td><input name="dataAnotherSix12" id="dataAnotherSix12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 12</td>
      <td><input name="dataAnotherSix11" id="dataAnotherSix11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 11</td>
      <td><input name="dataAnotherSix21" id="dataAnotherSix21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 21</td>
      <td><input name="dataAnotherSix22" id="dataAnotherSix22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 22</td>
      <td><input name="dataAnotherSix23" id="dataAnotherSix23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 23</td>
      <td><input name="dataAnotherSix24" id="dataAnotherSix24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 24</td>
      <td><input name="dataAnotherSix25" id="dataAnotherSix25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 25</td>
      <td><input name="dataAnotherSix26" id="dataAnotherSix26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 26</td>
      <td><input name="dataAnotherSix27" id="dataAnotherSix27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 27</td>
      <td><input name="dataAnotherSix28" id="dataAnotherSix28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherSix48" id="dataAnotherSix48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 48</td>
      <td><input name="dataAnotherSix47" id="dataAnotherSix47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 47</td>
      <td><input name="dataAnotherSix46" id="dataAnotherSix46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 46</td>
      <td><input name="dataAnotherSix45" id="dataAnotherSix45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 45</td>
      <td><input name="dataAnotherSix44" id="dataAnotherSix44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 44</td>
      <td><input name="dataAnotherSix43" id="dataAnotherSix43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 43</td>
      <td><input name="dataAnotherSix42" id="dataAnotherSix42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 42</td>
      <td><input name="dataAnotherSix41" id="dataAnotherSix41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 41</td>
      <td><input name="dataAnotherSix31" id="dataAnotherSix31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 31</td>
      <td><input name="dataAnotherSix32" id="dataAnotherSix32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 32</td>
      <td><input name="dataAnotherSix33" id="dataAnotherSix33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 33</td>
      <td><input name="dataAnotherSix34" id="dataAnotherSix34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 34</td>
      <td><input name="dataAnotherSix35" id="dataAnotherSix35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 35</td>
      <td><input name="dataAnotherSix36" id="dataAnotherSix36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 36</td>
      <td><input name="dataAnotherSix37" id="dataAnotherSix37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 37</td>
      <td><input name="dataAnotherSix38" id="dataAnotherSix38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataHiddenValeSix();"> 38</td>
    </tr>
  </tbody>
  
  <!-- 
    <tbody>
    <tr>
      <td><input name="dataAnotherSix18" id="dataAnotherSix18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 18</td>
      <td><input name="dataAnotherSix17" id="dataAnotherSix17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 17</td>
      <td><input name="dataAnotherSix16" id="dataAnotherSix16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 16</td>
      <td><input name="dataAnotherSix15" id="dataAnotherSix15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 15</td>
      <td><input name="dataAnotherSix14" id="dataAnotherSix14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 14</td>
      <td><input name="dataAnotherSix13" id="dataAnotherSix13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 13</td>
      <td><input name="dataAnotherSix12" id="dataAnotherSix12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 12</td>
      <td><input name="dataAnotherSix11" id="dataAnotherSix11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="dataAnotherSix();" > 11</td>
      <td><input name="dataAnotherSix21" id="dataAnotherSix21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 21</td>
      <td><input name="dataAnotherSix22" id="dataAnotherSix22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 22</td>
      <td><input name="dataAnotherSix23" id="dataAnotherSix23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 23</td>
      <td><input name="dataAnotherSix24" id="dataAnotherSix24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 24</td>
      <td><input name="dataAnotherSix25" id="dataAnotherSix25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 25</td>
      <td><input name="dataAnotherSix26" id="dataAnotherSix26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 26</td>
      <td><input name="dataAnotherSix27" id="dataAnotherSix27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 27</td>
      <td><input name="dataAnotherSix28" id="dataAnotherSix28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 28</td>
    </tr>
    <tr>
      <td><input name="dataAnotherSix48" id="dataAnotherSix48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 48</td>
      <td><input name="dataAnotherSix47" id="dataAnotherSix47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 47</td>
      <td><input name="dataAnotherSix46" id="dataAnotherSix46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 46</td>
      <td><input name="dataAnotherSix45" id="dataAnotherSix45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 45</td>
      <td><input name="dataAnotherSix44" id="dataAnotherSix44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 44</td>
      <td><input name="dataAnotherSix43" id="dataAnotherSix43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 43</td>
      <td><input name="dataAnotherSix42" id="dataAnotherSix42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 42</td>
      <td><input name="dataAnotherSix41" id="dataAnotherSix41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 41</td>
      <td><input name="dataAnotherSix31" id="dataAnotherSix31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 31</td>
      <td><input name="dataAnotherSix32" id="dataAnotherSix32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 32</td>
      <td><input name="dataAnotherSix33" id="dataAnotherSix33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 33</td>
      <td><input name="dataAnotherSix34" id="dataAnotherSix34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 34</td>
      <td><input name="dataAnotherSix35" id="dataAnotherSix35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 35</td>
      <td><input name="dataAnotherSix36" id="dataAnotherSix36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 36</td>
      <td><input name="dataAnotherSix37" id="dataAnotherSix37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 37</td>
      <td><input name="dataAnotherSix38" id="dataAnotherSix38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="dataAnotherSix();"> 38</td>
    </tr>
  </tbody> -->
   <input value="" type="hidden" name="dentalhiddenValueSix" id="dentalhiddenValueSix"/>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv18">
<label class="auto">18</label>
<select id="teeth_18_valueAnotherSix" name="teeth_18_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv17">
<label class="auto">17</label>
<select id="teeth_17_valueAnotherSix" name="teeth_17_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv16">
<label class="auto">16</label>
<select id="teeth_16_valueAnotherSix" name="teeth_16_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv15">
<label class="auto">15</label>
<select id="teeth_15_valueAnotherSix" name="teeth_15_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv14">
<label class="auto">14</label>
<select id="teeth_14_valueAnotherSix" name="teeth_14_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv13">
<label class="auto">13</label>
<select id="teeth_13_valueAnotherSix" name="teeth_13_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv12">
<label class="auto">12</label>
<select id="teeth_12_valueAnotherSix" name="teeth_12_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv11">
<label class="auto">11</label>
<select id="teeth_11_valueAnotherSix" name="teeth_11_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv21">
<label class="auto">21</label>
<select id="teeth_21_valueAnotherSix" name="teeth_21_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv22">
<label class="auto">22</label>
<select id="teeth_22_valueAnotherSix" name="teeth_22_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv23">
<label class="auto">23</label>
<select id="teeth_23_valueAnotherSix" name="teeth_23_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv24">
<label class="auto">24</label>
<select id="teeth_24_valueAnotherSix" name="teeth_24_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv25">
<label class="auto">25</label>
<select id="teeth_25_valueAnotherSix" name="teeth_25_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv26">
<label class="auto">26</label>
<select id="teeth_26_valueAnotherSix" name="teeth_26_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv27">
<label class="auto">27</label>
<select id="teeth_27_valueAnotherSix" name="teeth_27_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv28">
<label class="auto">28</label>
<select id="teeth_28_valueAnotherSix" name="teeth_28_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv48">
<label class="auto">48</label>
<select id="teeth_48_valueAnotherSix" name="teeth_48_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv47">
<label class="auto">47</label>
<select id="teeth_47_valueAnotherSix" name="teeth_47_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv46">
<label class="auto">46</label>
<select id="teeth_46_valueAnotherSix" name="teeth_46_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv45">
<label class="auto">45</label>
<select id="teeth_45_valueAnotherSix" name="teeth_45_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv44">
<label class="auto">44</label>
<select id="teeth_44_valueAnotherSix" name="teeth_44_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv43">
<label class="auto">43</label>
<select id="teeth_43_valueAnotherSix" name="teeth_43_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv42">
<label class="auto">42</label>
<select id="teeth_42_valueAnotherSix" name="teeth_42_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv41">
<label class="auto">41</label>
<select id="teeth_41_valueAnotherSix" name="teeth_41_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv31">
<label class="auto">31</label>
<select id="teeth_31_valueAnotherSix" name="teeth_31_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv32">
<label class="auto">32</label>
<select id="teeth_32_valueAnotherSix" name="teeth_32_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv33">
<label class="auto">33</label>
<select id="teeth_33_valueAnotherSix" name="teeth_33_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv34">
<label class="auto">34</label>
<select id="teeth_34_valueAnotherSix" name="teeth_34_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv35">
<label class="auto">35</label>
<select id="teeth_35_valueAnotherSix" name="teeth_35_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv36">
<label class="auto">36</label>
<select id="teeth_36_valueAnotherSix" name="teeth_36_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv37">
<label class="auto">37</label>
<select id="teeth_37_valueAnotherSix" name="teeth_37_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<div class="mltpSlect" style="display:none" id="dataAnotherSixDiv38">
<label class="auto">38</label>
<select id="teeth_38_valueAnotherSix" name="teeth_38_valueAnotherSix" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
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

<label>Examination of Ridge</label>
<select name="examinationOfRidge" id="examinationOfRidge" tabindex="1" validate="Service Center,string,no" class="-smallest">
<option value="">Select</option>
<option value="Class I">Class I</option>
<option value="Class II">Class II</option>
<option value="Class III">Class III</option>
<option value="Class IV">Class IV</option>
</select>
<div class="clear"></div>

<h4>Evaluation of Occlusion</h4>
<div class="clear"></div>

<label class="auto">Interferences in Movements</label>
<input type="text" name="interferencesInMovements" id="interferencesInMovements" maxlength="128" tabindex="1">

<label>Type of Guidance</label>
<label class="auto">Canine guided</label>
<input tabindex="1" name="typeOfGuidance" id="" value="Canine guided" type="radio" class="radiobutMargin">
<label class="auto">Group function</label>
<input tabindex="1" name="typeOfGuidance" id="" value="Group function" type="radio" style="margin-right:21px;">
<div class="clear"></div>

<h4>Examination of Temperomandibular Joint</h4>
<div class="clear"></div>

<label>Deviation</label>
<label class="auto">Present</label>
<input tabindex="1" name="deviation" id="deviation" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueRPP();">
<label class="auto">Absent</label>
<input tabindex="1" name="deviation" id="deviation" value="Absent" type="radio" style="margin-right:47px;" onclick="displayTextValueRPP();">
<div id="deviationDiv" style="display:none;">
<input type="text" name="deviationValue" id="deviationValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>
<label>Pain</label>
<label class="auto">Present</label>
<input tabindex="1" name="pain" id="pain" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueRPP();">
<label class="auto">Absent</label>
<input tabindex="1" name="pain" id="pain" value="Absent" type="radio" style="margin-right:47px;" onclick="displayTextValueRPP();">
<div id="painDiv" style="display:none;">
<input type="text" name="painValue" id="painValue" maxlength="128" tabindex="1" >
</div>
<div class="clear"></div>

<label>Clicking</label>
<label class="auto">Present</label>
<input tabindex="1" name="clicking" id="clicking" value="Present" type="radio" class="radiobutMargin" onclick="displayTextValueRPP();">
<label class="auto">Absent</label>
<input tabindex="1" name="clicking" id="clicking" value="Absent" type="radio" style="margin-right:47px;" onclick="displayTextValueRPP();">
<div id="clickingDiv" style="display:none;">
<input type="text" name="clickingValue" id="clickingValue" maxlength="128" tabindex="1">
</div>
<div class="clear"></div>
<label>Treatment Planning</label>
<!-- <input type="text" name="treatmentPlanning" id="treatmentPlanning" maxlength="128" tabindex="1"> -->
<textarea rows="" cols="" id="treatmentPlanning" name="treatmentPlanning" style="margin:0px; width:550px;" maxlength="256" validate="Treatment Planning,string,no"  onkeyup="return checkLength(this)"></textarea>



<div class="clear"></div>
<div class="paddingTop5"></div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

</div>
</form>

<style>
.wdth55 {width:55px;}
</style>
