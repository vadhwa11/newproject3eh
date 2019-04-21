
<%@page import="jkt.hms.masters.business.OpdGeneralSurgeryPrevSpeciality"%>
<%@page import="jkt.hms.masters.business.OpdGeneralSurgeryPastSpeciality"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDeliveryType"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	
		/*  var relArray=new Array(); */
	
	</script>

<%


	Map<String, Object> map = new HashMap<String, Object>();

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	
	if(map.get("deliveryTypeList") != null){
		deliveryTypeList = (List<MasDeliveryType>)map.get("deliveryTypeList");
	}
	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientList") != null)
	{
		patientList=(List<Patient>)map.get("patientList");
	}
	
	List<OpdGeneralSurgeryPastSpeciality> opdGeneralSurgeryPastSpecialityList = new ArrayList<OpdGeneralSurgeryPastSpeciality>();
	if(map.get("opdGeneralSurgeryPastSpecialityList") != null)
	{
		opdGeneralSurgeryPastSpecialityList=(List<OpdGeneralSurgeryPastSpeciality>)map.get("opdGeneralSurgeryPastSpecialityList");
	}
	
	List<OpdGeneralSurgeryPastSpeciality> opdGeneralSurgeryFamilySpecialityList = new ArrayList<OpdGeneralSurgeryPastSpeciality>();
	if(map.get("opdGeneralSurgeryFamilySpecialityList") != null)
	{
		opdGeneralSurgeryFamilySpecialityList=(List<OpdGeneralSurgeryPastSpeciality>)map.get("opdGeneralSurgeryFamilySpecialityList");
	}
	
	List<OpdGeneralSurgeryPrevSpeciality> opdGeneralSurgeryPrevSpeciality = new ArrayList<OpdGeneralSurgeryPrevSpeciality>();
	if(map.get("opdGeneralSurgeryPrevSpeciality") != null)
	{
		opdGeneralSurgeryPrevSpeciality=(List<OpdGeneralSurgeryPrevSpeciality>)map.get("opdGeneralSurgeryPrevSpeciality");
	}
	
	System.out.println(opdGeneralSurgeryPrevSpeciality.size()+"----opdGeneralSurgeryPrevSpeciality--");
	
%>
<form method="post" action="" name="dedd" >
<input id="generalSurgeryFlag" name="generalSurgeryFlag" tabindex="1" value="General Surgery" type="hidden"  />
<div class="Block">

<div class="clear"></div>
<div class="paddingTop5"></div>
<h6>Presenting Complaints</h6>
<div class="widthH4"><h4>Bleeding</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="bleeding" class="radioCheckCol2" id="bleeding" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Bleeding');"/>
<label class="auto">No</label>
<input type="radio" name="bleeding" class="radioCheckCol2" id="bleeding" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Bleeding');"/>
<div class="clear"></div>
<div id="bleedingDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="bleedingDuration" id="bleedingDuration" value=""  maxlength="5" validate="Bleeding Duration,float,no" tabindex="1"  onkeypress="javascript:return isNumberDecimal(event)"  >
<select  name="bleedingDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="bleedingSite"  id="bleedingSite" maxlength="128" value="" validate="Bleeding Site,string,no"/>
</div>
<div class="clear"></div>

<div class="widthH4"><h4>Claudication</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="claudication" class="radioCheckCol2" id="claudication" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Claudication');"/>
<label class="auto">No</label>
<input type="radio" name="claudication" class="radioCheckCol2" id="claudication" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Claudication');"/>
<div class="clear"></div>
<div id="claudicationDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="claudicationDuration" id="claudicationDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"  validate="Claudication Duration,float,no" tabindex="1"  >
<select  name="claudicationDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="claudicationSite" id="claudicationSite" maxlength="128" value="" validate="Claudication Site,string,no"  />

<div class="clear"></div>
<label class="medium">Type</label>
<input type="text" name="claudicationType" id="claudicationType" value=""  maxlength="128" validate="Claudication Type,string,no"/>
<!-- <div class="clear"></div> -->
<!--  <label class="medium">Radiation</label>
<input type="text" name="claudicationRadiation" id="claudicationRadiation" value="" maxlength="50" validate="Claudication Radiation,string,no" /> -->
<!--
<div class="clear"></div>
<label>Shifting</label>
<input type="text" name="claudicationShifting" id="claudicationShifting" value=""/>
<label>Referral</label>
<input type="text" name="claudicationReferral" id="claudicationReferral" value=""/>
 -->
<!-- <div class="clear"></div> -->
<label class="medium">Distance</label>
<input type="text" name="claudicationDistance" id="claudicationDistance"  value="" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Claudication Distance,float,no"  />
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Constipation</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="constipation" class="radioCheckCol2" id="constipation" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Constipation');"/>
<label class="auto">No</label>
<input type="radio" name="constipation" class="radioCheckCol2" id="constipation" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Constipation');"/>
<div class="clear"></div>
<div id="constipationDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="constipationDuration" id="constipationDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Constipation Duration,float,no" tabindex="1"  >
<select  name="constipationDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Absolute</label>
<input type="radio" name="constipationAbsoluteRelative" class="radioCheckCol2" id="constipationAbsoluteRelative" value="Absolute"/>
<label class="medium">Relative</label>
<input type="radio" name="constipationAbsoluteRelative" class="radioCheckCol2" id="constipationAbsoluteRelative" value="Relative"/>
<!-- <div class="clear"></div> -->
<label class="medium">Progressive</label>
<input type="radio" name="constipationProgressiveIntermittent" class="radioCheckCol2" id="constipationProgressiveIntermittent" value="Constipation Progressive"/>
<label class="medium">Intermittent</label>
<input type="radio" name="constipationProgressiveIntermittent" class="radioCheckCol2" id="constipationProgressiveIntermittent" value="Constipation Intermittent"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Cough</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="cough" class="radioCheckCol2" id="cough" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Cough');"/>
<label class="auto">No</label>
<input type="radio" name="cough" class="radioCheckCol2" id="cough" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'cough');"/>
<div class="clear"></div>
<div id="coughDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="coughDuration" id="coughDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Cough Duration,float,no" tabindex="1"  >
<select  name="coughDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="coughType" id="coughType"  value="" validate="Cough Type,string,no" maxlength="128"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Dilated veins</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="dilatedVeins" class="radioCheckCol2" id="dilatedVeins" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'DilatedVeins');"/>
<label class="auto">No</label>
<input type="radio" name="dilatedVeins" class="radioCheckCol2" id="dilatedVeins" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'DilatedVeins');"/>
<div class="clear"></div>
<div id="dilatedVeinsDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="dilatedVeinsDuration" id="dilatedVeinsDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Dilated Duration,float,no" tabindex="1"  >
<select  name="dilatedVeinsDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="dilatedVeinsSite" id="dilatedVeinsSite"  value="" maxlength="128" validate="Dilated Site,string,no"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Discharge</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="discharge" class="radioCheckCol2" id="discharge" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Discharge');"/>
<label class="auto">No</label>
<input type="radio" name="discharge" class="radioCheckCol2" id="discharge" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Discharge');"/>
<div class="clear"></div>
<div id="dischargeDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="dischargeDuration" id="dischargeDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Discharge Duration,float,no" tabindex="1"  >
<select  name="dischargeDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="dischargeSite" id="dischargeSite"  value="" maxlength="128" validate="Discharge Site,string,no"/>
<!-- <div class="clear"></div> -->
<label class="medium">Type</label>
<input type="text" name="dischargeType" id="dischargeType" value=""  maxlength="128" validate="Discharge Type,string,no"/>
</div>

<div class="clear"></div>
<div class="widthH4"><h4>Discoloration</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="discoloration" class="radioCheckCol2" id="discoloration" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Discoloration');"/>
<label class="auto">No</label>
<input type="radio" name="discoloration" class="radioCheckCol2" id="discoloration" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Discoloration');"/>
<div class="clear"></div>
<div id="discolorationDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="discolorationDuration" id="discolorationDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Discoloration Duration,float,no" tabindex="1"  >
<select  name="discolorationDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="discolorationSite" id="discolorationSite" maxlength="128" value=""  validate="Discoloration Site,string,no"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Distension</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="distension" class="radioCheckCol2" id="distension" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Distension');"/>
<label class="auto">No</label>
<input type="radio" name="distension" class="radioCheckCol2" id="distension" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Distension');"/>
<div class="clear"></div>
<div id="distensionDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="distensionDuration" id="distensionDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Distension Duration,float,no" tabindex="1"  >
<select  name="distensionDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="distensionSite" id="distensionSite" maxlength="128"  value="" validate="Distension Site,string,no" />
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Dysphagia</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="dysphagia" class="radioCheckCol2" id="dysphagia" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Dysphagia');"/>
<label class="auto">No</label>
<input type="radio" name="dysphagia" class="radioCheckCol2" id="dysphagia" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Dysphagia');"/>
<div class="clear"></div>
<div id="dysphagiaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="dysphagiaDuration" id="dysphagiaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Dysphagia Duration,float,no" tabindex="1"  >
<select  name="dysphagiaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="dysphagiaType" id="dysphagiaType" maxlength="128"  value="" validate="Dysphagia Type,string,no"/>
<div class="clear"></div>

<label class="medium">Solids</label> <input type="checkbox" name="dysphagiaSolids" id="dysphagiaSolids" value="Solids" />
<label class="medium">Liquids</label><input type="checkbox" name="dysphagiaLiquids" id="dysphagiaLiquids" value="Liquids"/>

</div>
<div class="clear"></div>
<div class="widthH4"><h4>Dyspnea</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="dyspnea" class="radioCheckCol2" id="dyspnea" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Dyspnea');"/>
<label class="auto">No</label>
<input type="radio" name="dyspnea" class="radioCheckCol2" id="dyspnea" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Dyspnea');"/>
<div class="clear"></div>
<div id="dyspneaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="dyspneaDuration" id="dyspneaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Dyspnea Duration,float,no" tabindex="1"  >
<select  name="dyspneaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="dyspneaType" id="dyspneaType" maxlength="128"  value="" validate="Dyspnea Type,string,no"/>

</div>
<div class="clear"></div>
<div class="widthH4"><h4>Dysuria</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="dysuria" class="radioCheckCol2" id="dysuria" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Dysuria');"/>
<label class="auto">No</label>
<input type="radio" name="dysuria" class="radioCheckCol2" id="dysuria" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Dysuria');"/>
<div class="clear"></div>
<div id="dysuriaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="dysuriaDuration" id="dysuriaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Dysuria Duration,float,no" tabindex="1"  >
<select  name="dysuriaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>

<label class="medium">Type</label>
<input type="text" name="dysuriaType" id="dysuriaType" maxlength="128"  value="" validate="Dysuria Type,string,no"/>


</div>
<div class="clear"></div>
<div class="widthH4"><h4>Fever</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="fever" class="radioCheckCol2" id="fever" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Fever');"/>
<label class="auto">No</label>
<input type="radio" name="fever" class="radioCheckCol2" id="fever" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Fever');"/>
<div class="clear"></div>
<div id="feverDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="feverDuration" id="feverDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Fever Duration,float,no" tabindex="1"  >
<select  name="feverDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="feverType" id="feverType" value="" maxlength="128" validate="Fever Type,string,no" />

</div>
<div class="clear"></div>
<div class="widthH4"><h4>Haematochezia</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="haematochezia" class="radioCheckCol2" id="haematochezia" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Haematochezia');"/>
<label class="auto">No</label>
<input type="radio" name="haematochezia" class="radioCheckCol2" id="haematochezia" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Haematochezia');"/>
<div class="clear"></div>
<div id="haematocheziaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="haematocheziaDuration" id="haematocheziaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Haematochezia Duration,float,no" tabindex="1"  >
<select  name="haematocheziaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Initial</label>
<input type="radio" name="haematocheziaInitial" id="haematocheziaInitial" class="radioCheckCol2" value="Initial"/>
<label class="medium">Later</label>
<input type="radio" name="haematocheziaInitial" id="haematocheziaInitial" class="radioCheckCol2"  value="Later"/>

</div>

<div class="clear"></div>
<div class="widthH4"><h4>Haemetemesis</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="haemetemesis" class="radioCheckCol2" id="haemetemesis" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Haemetemesis');"/>
<label class="auto">No</label>
<input type="radio" name="haemetemesis" class="radioCheckCol2" id="haemetemesis" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Haemetemesis');"/>
<div class="clear"></div>
<div id="haemetemesisDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="haemetemesisDuration" id="haemetemesisDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Haemetemesis Duration,float,no" tabindex="1"  >
<select  name="haemetemesisDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>

<label class="medium">Initial</label>
<input type="radio" name="haemetemesisInitial" id="haemetemesisInitial" class="radioCheckCol2" value="Haemetemesis Initial"/>
<label class="medium">Later</label>
<input type="radio" name="haemetemesisInitial" id="haemetemesisInitial" class="radioCheckCol2"  value="Haemetemesis Later"/>
</div>


<div class="clear"></div>
<div class="widthH4"><h4>Heartburn</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="heartburn" class="radioCheckCol2" id="heartburn" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Heartburn');"/>
<label class="auto">No</label>
<input type="radio" name="heartburn" class="radioCheckCol2" id="heartburn" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Heartburn');"/>
<div class="clear"></div>
<div id="heartburnDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="heartburnDuration" id="heartburnDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Heartburn Duration,float,no" tabindex="1"  >
<select  name="heartburnDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="heartburnType" id="heartburnType" maxlength="128"  value="" validate="Heartburn Type,string,no"/>

</div>

<div class="clear"></div>
<div class="widthH4"><h4>Jaundice</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="jaundice" class="radioCheckCol2" id="jaundice" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Jaundice');"/>
<label class="auto">No</label>
<input type="radio" name="jaundice" class="radioCheckCol2" id="jaundice" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Jaundice');"/>
<div class="clear"></div>
<div id="jaundiceDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="jaundiceDuration" id="jaundiceDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Heartburn Duration,float,no" tabindex="1"  >
<select  name="jaundiceDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>


<label class="medium">Progressive</label>
<input type="radio" name="jaundiceProgressiveIntermittent" class="radioCheckCol2" id="jaundiceProgressiveIntermittent" value="Jaundice Progressive"/>
<label class="medium">Intermittent</label>
<input type="radio" name="jaundiceProgressiveIntermittent" class="radioCheckCol2" id="jaundiceProgressiveIntermittent" value="Jaundice Intermittent "/>

</div>

<div class="clear"></div>
<div class="widthH4"><h4>Malena</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="malena" class="radioCheckCol2" id="malena" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Malena');"/>
<label class="auto">No</label>
<input type="radio" name="malena" class="radioCheckCol2" id="malena" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Malena');"/>
<div class="clear"></div>
<div id="malenaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="malenaDuration" id="malenaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Malena Duration,float,no" tabindex="1"  >
<select  name="malenaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>

</div>
<div class="clear"></div>
<div class="widthH4"><h4>Nausea</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="nausea" class="radioCheckCol2" id="nausea" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Nausea');"/>
<label class="auto">No</label>
<input type="radio" name="nausea" class="radioCheckCol2" id="nausea" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Nausea');"/>
<div class="clear"></div>
<div id="nauseaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="nauseaDuration" id="nauseaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Nausea Duration,float,no" tabindex="1"  >
<select  name="nauseaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="nauseaType" id="nauseaType"  value=""/>

</div>

<div class="clear"></div>
<div class="widthH4"><h4>Pain</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="pain" class="radioCheckCol2" id="pain" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Pain');"/>
<label class="auto">No</label>
<input type="radio" name="pain" class="radioCheckCol2" id="pain" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Pain');"/>
<div class="clear"></div>
<div id="painDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="painDuration" id="painDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Pain Duration,float,no" tabindex="1"  >
<select  name="painDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="painSite" id="painSite" maxlength="128"  value="" validate="Pain Site,string,no"/>
<!-- <div class="clear"></div> -->

<label class="medium">Type</label>
<input type="text" name="painType" id="painType" maxlength="128"  value="" validate="Pain Type,string,no"/>

<div class="clear"></div>
<!-- <label>Radiation</label>
<input type="text" name="painRadiation" id="painRadiation"  value=""/>

<div class="clear"></div>

<label>Shifting</label>
<input type="text" name="painShifting" id="painShifting"  value=""/>
<div class="clear"></div>
<label>Referral</label>
<input type="text" name="painReferral" id="painReferral"  value=""/> -->
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Swelling</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="swelling" class="radioCheckCol2" id="swelling" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Swelling');"/>
<label class="auto">No</label>
<input type="radio" name="swelling" class="radioCheckCol2" id="swelling" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Swelling');"/>
<div class="clear"></div>
<div id="swellingDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="swellingDuration" id="swellingDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Swelling Duration,float,no" tabindex="1"  >
<select  name="swellingDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="swellingSite" id="swellingSite" maxlength="128"  value="" validate="Swelling Site,string,no"/>


<label class="medium">Size</label>
<input type="text" name="swellingSize" id="swellingSize" maxlength="4"  value="" validate="Swelling Size,int,no"/>
<div class="clear"></div>
<label class="medium">Shape</label>
<input type="text" name="swellingShape" id="swellingShape"  value="" maxlength="50" validate="Swelling Shape,string,no"/>


<label class="medium">Growth rate</label>
<input type="text" name="swellingGrowthRate" id="swellingGrowthRate" maxlength="50"  value="" validate="Growth rate,string,no"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Trauma</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="trauma" class="radioCheckCol2" id="trauma" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Trauma');"/>
<label class="auto">No</label>
<input type="radio" name="Trauma" class="radioCheckCol2" id="trauma" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Trauma');"/>
<div class="clear"></div>
<div id="traumaDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="traumaDuration" id="traumaDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Trauma,float,no" tabindex="1"  >
<select  name="traumaDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Type</label>
<input type="text" name="traumaType" id="traumaType" maxlength="50" value="" validate="Traumab Type,string,no" />
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Ulcer</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="ulcer" class="radioCheckCol2" id="ulcer" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Ulcer');"/>
<label class="auto">No</label>
<input type="radio" name="ulcer" class="radioCheckCol2" id="ulcer" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Ulcer');"/>
<div class="clear"></div>
<div id="ulcerDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="ulcerDuration" id="ulcerDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Ulcer Duration,float,no" tabindex="1"  >
<select  name="ulcerDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Site</label>
<input type="text" name="ulcerSite" id="ulcerSite" maxlength="50"  value="" validate="Ulcer Site,string,no" />


<label class="medium">Size</label>
<input type="text" name="ulcerSize" id="ulcerSize" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"    value="" validate="Ulcer Size,int,no"/>
<div class="clear"></div>
<label class="medium">Shape</label>
<input type="text" name="ulcerShape" id="ulcerShape" maxlength="50"  value="" validate="Ulcer Shape,string,no"/>
<div class="clear"></div>

<label class="medium">Growth rate</label>
<input type="text" name="ulcerGrowthRate" id="ulcerGrowthRate" maxlength="50"  value="" validate="Growth rate,string,no"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Urinary obstruction</h4></div>
<label class="auto">Yes</label>
<input type="radio" name="urinaryObstruction" class="radioCheckCol2" id="urinaryObstruction" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Urinary');"/>
<label class="auto">No</label>
<input type="radio" name="urinaryObstruction" class="radioCheckCol2" id="urinaryObstruction" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Urinary');"/>
<div class="clear"></div>
<div id="urinaryObstructionDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="urinaryObstructionDuration" id="urinaryObstructionDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Urinary Duartion,float,no" tabindex="1"  >
<select  name="urinaryObstructionDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>

<label class="medium">Continuous</label>
<input type="radio" name="urinaryObstructionContinuos" class="radioCheckCol2" id="urinaryObstructionContinuos" value="Continuous"/>
<label class="medium">Intermittent</label>
<input type="radio" name="urinaryObstructionContinuos" class="radioCheckCol2" id="urinaryObstructionContinuos" value="Intermittent"/>
</div>
<div class="clear"></div>
<div class="widthH4"><h4>Vomiting</h4></div>

<label class="auto">Yes</label>
<input type="radio" name="vomiting" class="radioCheckCol2" id="vomiting" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Vomiting');"/>
<label class="auto">No</label>
<input type="radio" name="vomiting" class="radioCheckCol2" id="vomiting" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Vomiting');"/>
<!-- <div class="clear"></div> -->
<div id="vomitingDiv" style="display: none">
<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="vomitingDuration" id="vomitingDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Vomiting Duration,float,no" tabindex="1"  >
<select  name="vomitingDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
<label class="medium">Projectile</label>
<input type="radio" name="vomitingProjectile" class="radioCheckCol2" id="vomitingProjectile" value="Vomiting Projectile"/>
<label class="medium">Nonprojectile</label>
<input type="radio" name="vomitingProjectile" class="radioCheckCol2" id="vomitingProjectile" value="Vomiting Nonprojectile"/>
<div class="clear"></div>
<label >Time after food-intake</label>
<input type="text" name="vomitingTimeAfterFoodIntake" id="vomitingTimeAfterFoodIntake"  value="" maxlength="50" validate="Time after food-intake,string,no"/>
<!-- <div class="clear"></div> -->
<label class="medium">Bilious</label>
<input type="radio" name="vomitingBilious" class="radioCheckCol2" id="vomitingBilious" value="Vomiting Bilious"/>
<label class="medium">Nonbilious</label>
<input type="radio" name="vomitingBilious" class="radioCheckCol2" id="vomitingBilious" value="Vomiting Nonbilious"/>
</div>
<div class="clear"></div>
<input type="hidden" name="presentingComplaints" />
<!-- <textarea onkeyup="return checkLength(this)" name="presentingComplaints" id="presentingComplaints"   cols="0" rows="0" maxlength="256"></textarea> -->
<div class="clear"></div>
<h4>Past History</h4>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForPastHistory();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForPastHistory();" />
<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="pastHistoryGrid">

<tr> 
<th scope="col">&nbsp;</th>
<th>Disease</th>
<th>Duration</th>
<th>Number of Episodes&nbsp;&nbsp; Details</th>
<th>Drugs &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Details</th>
<th>Any others( Specify) </th>

</tr> 



<%if(opdGeneralSurgeryPastSpecialityList.size()>0){ 
	for(OpdGeneralSurgeryPastSpeciality a : opdGeneralSurgeryPastSpecialityList){
%>
<tr>
<td><input  type="checkbox" class="radioCheck" disabled="disabled" /></td>
<td><input  type="text"  value="<%=a.getDisease()!=null?a.getDisease():""%>" readonly /></td>
<td><input  type="text"  value="<%=a.getDuration()!=null?a.getDuration():""%>" readonly /></td>
<td><input  type="text"  value="<%=a.getNumberOfEpisodes()!=null?a.getNumberOfEpisodes():""%>"  style="width:95px;" readonly />
<input  type="text"  value="<%=a.getDetailsOne()!=null?a.getDetailsOne():""%>" readonly style="width:95px;"/></td>
<td><input  type="text"  value="<%=a.getDrugs()!=null?a.getDrugs():""%>" readonly style="width:95px;"/>
<input  type="text"  value="<%=a.getDetailsTwo()!=null?a.getDetailsTwo():""%>" readonly style="width:95px;"/>
</td>
<td><input  type="text"  value="<%=a.getOthersAnother()!=null?a.getOthersAnother():""%>" readonly /></td>

</tr>
<%} }%>
<tr>
<td><input  type="checkbox" class="radioCheck" name="pastHistoryRadio1" id="pastHistoryRadio1" /></td> 
<td>
<select name="disease1" id="disease1">
<option value="">Select</option>
<option value="Allergy">Allergy</option>
<option value="Diabetes Mellitus">Diabetes Mellitus</option>
<option value="Hypertension">Hypertension</option>
<option value="Tuberculosis">Tuberculosis</option>
<option value="Bronchial Asthma">Bronchial Asthma</option>
<option value="Cardiovascular disease">Cardiovascular disease</option>
<option value="Kidney disease">Kidney disease</option>
<option value="Malignancy">Malignancy</option>
<option value="Acid peptic disease">Acid peptic disease</option>
<option value="Swellings">Swellings</option>
<option value="Varicose veins">Varicose veins</option>
<option value="Claudication">Claudication</option>
<option value="Collagen diseases">Collagen diseases</option>
<option value="Genetic Illness">Genetic Illness</option>
</select>
</td>
<td><input type="text" name="duration1" id="duration1" value="" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Duration,float,no"/></td>
<td><input type="text" name="numberOfEpisodes1" id="numberOfEpisodes1" value="" validate="No. Of Episodes,int,no" maxlength="2" style="width:95px;"  onkeypress="javascript:return isNumber(event)"/>
<input type="text" name="detailsOne1" id="detailsOne1" value="" validate="Detail No. Of Episodes,string,no"  maxlength="32" style="width:95px;"/>
</td>
<td><input type="text" name="drugs1" id="drugs1"  value="" validate="Drugs,string,no" maxlength="32" style="width:95px;"/>
<input type="text" name="detailsTwo1" id="detailsTwo1" value=""  maxlength="32" validate="Drug Detail,string,no" style="width:95px;" />
</td>
<td>
 <input type="text"  id="anyOtherSpecifyAnother1"  name="anyOtherSpecifyAnother1" value="" validate="Any other,string,no"  maxlength="32"/>
</td>
 </tr>
</table>
</div>
<input type="hidden" name="pastHistoryCount" id="pastHistoryCount" value="1" />

<div class="clear"></div>
<h4>Family History</h4>

<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForFamilyHistory();"  />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForFamilyHistory();" />

<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="familyHistoryGrid">

<tr> 
<th scope="col">&nbsp;</th>
<th>Disease</th>
<th>Relation</th>
<th>Duration</th>
<th>Any others( Specify) </th>

</tr>
<%if(opdGeneralSurgeryFamilySpecialityList.size()>0){ 
	for(OpdGeneralSurgeryPastSpeciality b : opdGeneralSurgeryFamilySpecialityList){
		
%>
<tr>
<td><input  type="checkbox" disabled="disabled" /></td> 
 <td><input  type="text"  value="<%=b.getDisease()!=null?b.getDisease():""%>" readonly /></td>
<td><input  type="text"  value="<%=b.getRelation()!=null?b.getRelation().getRelationName():""%>" readonly /></td>
<td><input  type="text"  value="<%=b.getDuration()!=null?b.getDuration():""%>" readonly /></td>
<td><input  type="text"  value="<%=b.getOthers()!=null?b.getOthers():""%>" readonly /></td>
</tr>
<%}} %> 
<tr>
<td><input  type="checkbox" class="radioCheck" name="familyHistoryRadio1" id="familyHistoryRadio1" value="" /></td> 
<td>
 <select name="diseaseF1" id="diseaseF1">
<option value="">Select</option>
<option value="Allergy">Allergy</option>
<option value="Diabetes Mellitus">Diabetes Mellitus</option>
<option value="Hypertension">Hypertension</option>
<option value="Tuberculosis">Tuberculosis</option>
<option value="Bronchial Asthma">Bronchial Asthma</option>
<option value="Cardiovascular disease">Cardiovascular disease</option>
<option value="Kidney disease">Kidney disease</option>
<option value="Malignancy">Malignancy</option>
<option value="Acid peptic disease">Acid peptic disease</option>
<option value="Swellings">Swellings</option>
<option value="Varicose veins">Varicose veins</option>
<option value="Claudication">Claudication</option>
<option value="Collagen diseases">Collagen diseases</option>
<option value="Genetic Illness">Genetic Illness</option>
</select>
</td>

<td>
 <select name="realationF1" id="realationF1">
<option value="0">Select</option>
<% if(relationList.size() > 0){
int i=0;
for(MasRelation relation : relationList){%>
<option value=<%=relation.getId() %>><%=relation.getRelationName() %></option>
<%-- <script>
relArray[<%=i%>]= new Array();
relArray[<%=i%>][0] = "<%=relation.getId()%>";
relArray[<%=i%>][1] = "<%=relation.getRelationName()%>";
</script> --%>
<%  i++; } %>
<%} %>
</select>
</td>


 <!-- <td><input type="text" name="realationF1" id="realationF1" value=""  maxlength="10" validate="Relation,int,no"/></td> -->
 <td><input type="text" name="durationF1" id="durationF1" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Duration,float,no"/></td>

<td>
 <input type="text"  id="anyOtherSpecify1"  name="anyOtherSpecify1" value="" maxlength="32"/>
</td>
</tr>
</table>
</div>
<input type="hidden" name="familyHistoryCount" id="familyHistoryCount" value="1" />

<h4>Previous surgeries</h4>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForCurrentPreviousSurgeries();addRowForCurrentPreviousSurgeriesTemp();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForCurrentPreviousSurgeries();removeRowForCurrentPreviousSurgeriesTemp();" />

<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="previousSurgeriesGrid">
<tr> 
<th scope="col">&nbsp;</th>
<th>Type</th>
<th>Date/Year </th>
<th>Institution</th>
<th>Hospitalization duration</th>
<th>Complications</th>
</tr>
<%if(opdGeneralSurgeryPrevSpeciality.size()>0){ 
	for(OpdGeneralSurgeryPrevSpeciality c : opdGeneralSurgeryPrevSpeciality){
		
%>
<tr>
<td><input  type="checkbox" disabled="disabled" /></td> 
 <td><textarea rows="" cols=""  style="margin: 0px 5px; width: 231px; height: 30px;" maxlength="150"><%=c.getTypePrev()!=null?c.getTypePrev():""%></textarea>
<td><input  type="text"  value="<%=c.getDatePrev()!=null?HMSUtil.convertDateToStringTypeDateOnly(c.getDatePrev()):""%>" readonly class="date" /></td>
<td><input  type="text"  value="<%=c.getInstitution()!=null?c.getInstitution():""%>" readonly /></td>
<td><input  type="text"  value="<%=c.getHospitalizationDuration()!=null?c.getHospitalizationDuration():""%>" readonly /></td>
<td><input  type="text"  value="<%=c.getComplications()!=null?c.getComplications():""%>" readonly /></td>
</tr>

<%}} %>
<tr> 
<tr> 
<td><input  type="checkbox" class="radioCheck" name="previousSurgeriesRadio1" id="previousSurgeriesRadio1" /></td>
<td>
 <!-- <input type="text"  id="typeP1"  name="typeP1" size="30" maxlength="150" value=""/> -->
 <textarea rows="" cols="" id="typeP1" onblur="setVitalValue(this.value,'typePTemp1')"  name="typeP1" onkeyup="return checkLength(this)" style="margin: 0px 5px; width: 231px; height: 30px;" maxlength="150"></textarea>
</td>
<td>
  <input type="text" id="dateYear1" name="dateYear1"  	value="" class="date" maxlength="4"	 onkeypress="javascript:return isNumber(event)"  onblur="yearFormatDate(1);setVitalValue(this.value,'dateYearTemp1');" >  
 <!-- <input type="text" id="dateYear1" name="dateYear1" 	value=""	size="23.5"  validate="Date,date,no" maxlength="10" onkeyup="mask(this.value,this,'2,5','/');"  > -->
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"			onclick="setdate('',document.getElementById('dateYear1'),event);" />
 
</td>
<td>
 <input type="text"  id="institution1"  onblur="setVitalValue(this.value,'institutionTemp1')"  name="institution1" value="" maxlength="120"/>
</td>
<td>
 <input type="text"  id="hospitalizationDuration1"   onblur="setVitalValue(this.value,'hospitalizationDurationTemp1')" name="hospitalizationDuration1" value="" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Hospitalization duration,float,no"/>
</td>
<td>
 <input type="text"  id="complications1"  onblur="setVitalValue(this.value,'complicationsTemp1')"  name="complications1" value="" maxlength="120"/>
</td>
</tr>
</table>

</div>
<input type="hidden" name="previousSurgeriesCount" id="previousSurgeriesCount" value="1"   onblur="setVitalValue(this.value,'previousSurgeriesCountTemp')"/>

<h4>Personal History</h4>
<label class="medium">Diet</label>
 <select name="diet" id="diet" class="medium2">
<option value="">Select</option>
<option value="Veg">Veg</option>
<option value="NonVeg">NonVeg</option>
</select>

<label class="medium">Sleep</label>
 <select name="sleep" id="sleep" class="medium2">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Reduced">Reduced</option>
<option value="Increased">Increased</option>
</select>

<label class="medium">Appetite</label>
 <select name="appetite" id="appetite" class="medium2">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Reduced">Reduced</option>
<option value="Increased">Increased</option>
</select>

<div class="clear"></div>
<label class="medium">Bladder</label>
<!-- <input type="text"  id="bladder"  name="bladder" value="" maxlength="40"/> -->

<textarea id="bladder" name="bladder" cols="0" rows="0" maxlength="256" class="medium" style="display: block"></textarea>
<label class="medium">Bowel</label>
<!-- <input type="text"  id="bowel"  name="bowel" value="" maxlength="50"/> -->
<textarea id="bowel" name="bowel" cols="0" rows="0" maxlength="256" class="medium" style="display: block"></textarea>

<div class="clear"></div>
<!-- <h4>Personal Habits</h4>
<label>Yes</label>
<input type="radio" name="personalHabits" class="radioCheckCol2" id="vomiting" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'PersonalHabits');"/>
<label>No</label>
<input type="radio" name="personalHabits" class="radioCheckCol2" id="vomiting" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'PersonalHabits');"/>
<div class="clear"></div> -->
<div id="personalHabitsDiv" style="display: block">
<label>Smoking</label>
<input id="smokingValue" name="smokingValue" tabindex="1" value="yes" type="checkbox" class="checkboxMargin" onclick="displayGeneralSurgryTextValue(this.value,'Smoking')">
<!-- <label>Yes</label>
<input type="radio" name="smoking" class="radioCheckCol2" id="vomiting" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'Smoking');"/>
<label>No</label>
<input type="radio" name="smoking" class="radioCheckCol2" id="vomiting" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Smoking');"/>
<div class="clear"></div>-->

<!-- <label class="auto">Yes</label>
<input type="radio" name="smokingValue" class="radioCheckCol2" id="smokingValue" value="yes" onclick="displayGeneralSurgryTextValue(this.value,'Smoking');"/>
<label class="auto">No</label>
<input type="radio" name="smokingValue" class="radioCheckCol2" id="smokingValue" value="No" checked="checked" onclick="displayGeneralSurgryTextValue(this.value,'Smoking');"/>  -->
<div id="smokingDiv" style="display: none"> 
<select name="smoking" id="smoking" class="medium" style="width:73px;">
<option value="">Select</option>
<option value="Cigarette">Cigarette</option>
<option value="Beedi">Beedi</option>
</select>


<!-- <label>Number</label>
<input type="text"  id="smokingNumber"  name="smokingNumber" value=""/>
<label>Day</label>
<input type="text"  id="smokingDay"  name="smokingDay" value=""/> -->

<label>Duration</label>
<input style="width:86px"  type="text" name="smokingDuration" id="smokingDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Smoking Duration,float,no" tabindex="1"  >
<select  name="smokingDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
</div>
<div class="clear"></div>
<!-- <label>Yes</label>
<input type="radio" name="alcohol" class="radioCheckCol2" id="vomiting" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'Alcohol');"/>
<label>No</label>
<input type="radio" name="alcohol" class="radioCheckCol2" id="vomiting" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Alcohol');"/>
<div class="clear"></div> -->

<label>Alcohol</label>



<!--<label class="auto">Yes</label>
 <input type="radio" name="alcoholValue" class="radioCheckCol2" id="alcoholValue" value="yes" onclick="displayGeneralSurgryTextValue(this.value,'Alcohol');"/> -->
<input id="alcoholValue" name="alcoholValue" tabindex="1" value="yes" type="checkbox" class="checkboxMargin" onclick="displayGeneralSurgryTextValue(this.value,'Alcohol')">

<!-- <label class="auto">No</label>
<input type="radio" name="alcoholValue" class="radioCheckCol2" id="alcoholValue" value="No" checked="checked" onclick="displayGeneralSurgryTextValue(this.value,'Alcohol');"/> -->
<div id="alcoholDiv" style="display: none"> 
<!-- <label>Volume per day</label>
<input type="text"  id="alcoholVolume"  name="alcoholVolume" value="" maxlength="20"/> -->
<!-- <label>Day</label>
<input type="text"  id="alcoholDay"  name="alcoholDay" value=""/> -->

<label class="medium">Duration</label>
<input style="width:50px"  type="text" name="alcoholDuration" id="alcoholDuration" value=""  maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Alcohol Duration,float,no" tabindex="1"  >
<select  name="alcoholDurationParameter" class="medium2">
<option value="">Select</option>
<option value="Days" selected="selected">Days</option>
<option value="Weeks">Weeks</option>
<option value="Month">Months</option>
<option value="Years">Years </option>
</select>
</div>

<div class="clear"></div>
<!-- <label>Yes</label>
<input type="radio" name="otherAddictions" class="radioCheckCol2" id="vomiting" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'Addictions');"/>
<label>No</label>
<input type="radio" name="otherAddictions" class="radioCheckCol2" id="vomiting" checked="checked" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Addictions');"/>
<div class="clear"></div>-->

<label>Other addictions</label>
<label class="auto">Yes</label>
<input type="radio" name="otherAddictionsValue" class="radioCheckCol2" id="otherAddictionsValue" value="yes" onclick="displayGeneralSurgryTextValue(this.value,'Addictions');"/>
<label class="auto">No</label>
<input type="radio" name="otherAddictionsValue" class="radioCheckCol2" id="otherAddictionsValue" value="No" checked="checked" onclick="displayGeneralSurgryTextValue(this.value,'Addictions');"/>
<div id="otherAddictionsDiv" style="display: none"> 
<textarea id="otherAddictions" name="otherAddictions" cols="0" rows="0" maxlength="256" class="medium" style="display: block"></textarea> 
<!-- <input type="text"  id="otherAddictions"  name="otherAddictions" value="" maxlength="150"/> -->
</div> 
</div>
<div class="clear"></div>
<%
String genderName="";
Inpatient inpatient = new Inpatient();
if(inpatientList.size() >0){
	inpatient = inpatientList.get(0);
	if(inpatient.getHin().getSex()!=null)
	{
		genderName=inpatient.getHin().getSex().getAdministrativeSexName();
	}
}
Patient patient = new Patient();
if(patientList.size() >0){
	patient = patientList.get(0);
	if(patient.getSex()!=null)
	{
		genderName=patient.getSex().getAdministrativeSexName();
	}
}
		if(genderName.equals("Female") && !genderName.equals(""))
		{	
		
		
%>

<h4>Menstrual History</h4>

<label>Menarche</label>
<input type="text"  id="menarche"  name="menarche" value="" maxlength="2" validate=Menarche,int,no" class="small"/>

<label>Cycle length</label>
<input type="text"  id="cyclelength"  name="cyclelength" value="" maxlength="2" validate="Cycle length,int,no" class="small"/>
<div class="clear"></div>

<label>Flow days</label>
<input type="text"  id="flowdays"  name="flowdays" value="" maxlength="2" validate="Flow days,int,no" class="small"/>

<label>Menopause</label>
<input type="text"  id="menopause"  name="menopause" value="" maxlength="2" validate="Menopause,int,no" class="small"/>
<div class="clear"></div>
<label>LMP</label>
 <!-- <input type="text" id="lmpDate" name="lmpDate" value="" class="date" readonly="readonly" style="width:158px;"> -->
 <input type="text" id="lmpDate" name="lmpDate" 	value=""	size="23.5"  validate="Pick a date,date,no" maxlength="10" onkeyup="mask(this.value,this,'2,5','/');"  > 
<!-- <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.ipdCaseSheet.lmpDate,event);" /> -->
<div class="clear"></div>
<h4>Obstetric History</h4>

<label>Number of children</label>
<input type="text"  id="numberOfChildren"  name="numberOfChildren" value=""  maxlength="2" validate="Number of children,int,no"/>
<label>Type of delivery</label>
<select name="typeOfDelivery" id="typeOfDelivery" >

	<option value="0">Select</option>
	<% if(deliveryTypeList.size() > 0) { %>

		<%
		for(MasDeliveryType delivery : deliveryTypeList) {
		%>
		<option value="<%=delivery.getId()%>"><%=delivery.getDeliveryTypeDescription()%></option>
		<%
		}}
		%>
</select>
<%}
%>
<div class="clear"></div>

<label>Lactation duration</label>
<input type="text"  id="lactationDuration"  name="lactationDuration" value="" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)"   validate="Lactation Duration,float,no"/>
<label>PPS</label>
<select name="pps" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div class="clear"></div>

<label>HRT</label>
<select name="hrt">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<label>OCP</label>
<select name="ocp">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div class="clear"></div>
<label>Infertility Treatment</label>
<select name="infertitility">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div class="clear"></div>
<h6>Physical Examination</h6>

<h4>General Examination</h4>

<label>Pallor</label>
<label class="auto">Yes</label>
<input type="radio" name="pallor" class="radioCheckCol2" id="pallor" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="pallor" checked="checked" class="radioCheckCol2" id="pallor" value="No"/> 

<label>Icterus</label>
<label class="auto">Yes</label>
<input type="radio" name="icterus" class="radioCheckCol2" id="icterus" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="icterus" checked="checked" class="radioCheckCol2" id="icterus" value="No"/> 

<div class="clear"></div>

<label>Cyanosis</label>
<label class="auto">Yes</label>
<input type="radio" name="cyanosis" class="radioCheckCol2" id="cyanosis" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="cyanosis" checked="checked" class="radioCheckCol2" id="icterus" value="No"/> 

<label>Clubbing</label>
<label class="auto">Yes</label>
<input type="radio" name="clubbing" class="radioCheckCol2" id="clubbing" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="clubbing" checked="checked" class="radioCheckCol2" id="clubbing" value="No"/> 

<div class="clear"></div>

<label class="heightAuto">Generalized Lymphadenopathy</label>
<label class="auto">Yes</label>
<input type="radio" name="generalizedLymphadenopathy" class="radioCheckCol2" id="generalizedLymphadenopathy" value="Yes" onclick="displayGeneralSurgryTextValue(this.value,'Lymphadenopathy Generalized');"/>
<label class="auto">No</label>
<input type="radio" name="generalizedLymphadenopathy" checked="checked" class="radioCheckCol2" id="generalizedLymphadenopathy" onclick="displayGeneralSurgryTextValue(this.value,'Lymphadenopathy Generalized');" value="No"/>
 
<div id="generalizedLymphadenopathyDiv" style="display: none;">
<select  multiple="multiple" class="multiple" name="lymphadenopathyValue1" id="lymphadenopathyValue1" onclick="displayGeneralSurgryTextValue(this.value,'GeneralizedOthers');">
<option value="">Select</option>
<option value="Cervical">Cervical</option>
<option value="Axillary">Axillary</option>
<option value="Inguinal">Inguinal</option>
<option value="Abdominal">Abdominal</option>
<option value="Others">Others</option>
</select>

<input type="text"  id="othersData"  name="othersData" value=""  maxlength="128"  style="display: none">

<select name="lymphadenopathyValue2" class="medium2">
<option value="">Select</option>
<option value="Unilateral">Unilateral</option>
<option value="Bilateral">Bilateral</option>
</select>
</div>
<label style="width:131px;">Edema</label>

<label class="auto">Yes</label>
<input type="radio" name="edema" class="radioCheckCol2" id="edema" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="edema" checked="checked" class="radioCheckCol2" id="edema" value="No"/> 
 <div class="clear"></div>
<!--<h4>General Examination</h4>
<div class="clear"></div> -->

<label>Bones</label>
<textarea rows="" cols="" name ="bones" class="textareaMediua" maxlength="256" validate="Bones,string,no" onkeyup="return checkLength(this)"></textarea>
<label>Genitalia</label>
<textarea rows="" cols="" name ="genitalia" class="textareaMediua" maxlength="256" validate="Genitalia,string,no" onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>Joints</label>
<textarea rows="" cols="" name ="joints" class="textareaMediua" maxlength="256" validate="Joints,string,no" onkeyup="return checkLength(this)"></textarea>
<label>Nails</label>
<textarea rows="" cols="" name ="nails" class="textareaMediua" maxlength="256" validate="Nails,string,no" onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>Nerves</label>
<textarea rows="" cols="" name ="nerves" class="textareaMediua" maxlength="256" validate="Nerves,string,no" onkeyup="return checkLength(this)"></textarea>

<label>Scalp</label>
<textarea rows="" cols="" name ="scalp" class="textareaMediua" maxlength="256" validate="Scalp,string,no" onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>Skin</label>
<textarea rows="" cols="" name ="skin" class="textareaMediua" maxlength="256" validate="Skin,string,no" onkeyup="return checkLength(this)"></textarea>

<label>Skull</label>
<textarea rows="" cols="" name ="skull" class="textareaMediua" maxlength="256" validate="Skull,string,no" onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>Spine</label>
<textarea rows="" cols="" name ="spine" class="textareaMediua" maxlength="256" validate="Spine,string,no" onkeyup="return checkLength(this)"></textarea>

<label>Vessels</label>
<textarea rows="" cols="" name ="vessels" class="textareaMediua" maxlength="256" validate="Vessels,string,no" onkeyup="return checkLength(this)"></textarea>

<div class="clear"></div>
<!-- <label>Height(cms)</label>
<input type="text"  id="height"  name="height"  value=""/>
 
 <label>Weight (kgs)</label>
 <input type="text"  id="weight"  name="weight" value=""/>
 <div class="clear"></div>
 
 <label>BMI</label>
 <input type="text"  id="bmi"  name="bmi" value=""/>
 
  <label>Blood Pressure</label>
 <input type="text"  id="bp"  name="bp" value=""/>
 <div class="clear"></div>
 
 <label>mm of Hg in</label>
 <input type="text"  id="mm"  name="mm" value=""/> -->
 
 <label>JVP</label>
 <input type="text"  id="jvp"  name="jvp" value="" maxlength="45" validate="JVP,string,no" /> 
  
 <label>SP02</label>
 <input type="text"  id="sp"  name="sp" value="" maxlength="45" validate="SP02,string,no" /> 
 
 <div class="clear"></div>
  <h4>Pulse</h4>
  <label>Rate</label>
  <input type="text"  id="pulseRate"  name="pulseRate" value="" maxlength="45" validate="Pulse Rate,string,no" />  
  <label>Rhythm</label>
  <input type="text"  id="pulseRhythm"  name="pulseRhythm" value="" maxlength="45" validate="Pulse Rhythm,string,no"/>
  <div class="clear"></div>
  
  <label>Volume</label>
  <input type="text"  id="pulseVolume"  name="pulseVolume" value="" maxlength="45" validate="Volume,string,no"/>
   <label>Vessel wall</label>
  <input type="text"  id="pulseVesselWall"  name="pulseVesselWall" value="" maxlength="45" validate="Vessel wall,string,no"/>
  
  <div class="clear"></div>
  <h4>Respiration</h4>
  <label>Rate</label>
 <input type="text"  id="respirationRater"  name="respirationRate" value="" maxlength="45" validate="Respiration Rate,string,no"/>
  <label>Rhythm</label>
  <input type="text"  id="respirationRhythm"  name="respirationRhythm" value="" maxlength="45" validate="Respiration Rhythm,string,no"/>
  <div class="clear"></div>
  
  <label>Type</label>
  <input type="text"  id="respirationType"  name="respirationType" value="" maxlength="45" validate="Respiration Type,string,no"/>
 <div class="clear"></div>
 <label>ASA Grade</label>
<!-- <input type="text"  id="asaGrade"  name="asaGrade" value="" maxlength="45" validate="ASA Grade,string,no"/> -->
 <select name="asaGrade" id="asaGrade" class="medium">
<option value="">Select</option>
<option value="Grade-1">Grade-1</option>
<option value="Grade-2">Grade-2</option>
<option value="Grade-3">Grade-3</option>
<option value="Grade-4">Grade-4</option>
<option value="Grade-5">Grade-5</option>
<option value="Grade-6">Grade-6</option>
</select>
<div class="clear"></div>

<h4>Local examination</h4>
<label>Lesion</label>
<label class="auto">Yes</label>
<input type="radio" name="lesion" class="radioCheckCol2" id="lesion" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Lesion');"/>
<label class="auto">No</label>
<input type="radio" name="lesion" checked="checked" class="radioCheckCol2" id="lesion" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Lesion');"/> 

<div class="clear"></div>
<div id="lesionYesDiv" style="display: none;">
<label>Type</label>
<input type="text"  id="lesionType"  name="lesionType" value="" maxlength="45" validate="Lesion Type,string,no"/>

<label>Site</label>
<input type="text"  id="lesionSite"  name="lesionSite" value="" maxlength="45" validate="Lesion Site,string,no"/>
<div class="clear"></div>
<label>Size</label>
<input type="text"  id="lesionSize"  name="lesionSize" value="" maxlength="5" validate="Lesion Size,int,no"/>

<label>Surface</label>
<input type="text"  id="lesionSurface"  name="lesionSurface" value="" maxlength="45" validate="Lesion Surface,string,no"/>
<div class="clear"></div>
<label>Shape</label>
<input type="text"  id="lesionShape"  name="lesionShape" value="" maxlength="45" validate="Lesion Shape,string,no"/>

<label>Consistency</label>
<input type="text"  id="lesionConsistency"  name="lesionConsistency" value="" maxlength="45" validate="Lesion Consistency,string,no"/>
<div class="clear"></div>
<label>Mobility</label>
<input type="text"  id="lesionMobility"  name="lesionMobility" value="" maxlength="45" validate="Lesion Mobility,string,no"/>

<label>Plane</label>
<input type="text"  id="lesionPlane"  name="lesionPlane" value="" maxlength="45" validate="Lesion Others,string,no"/>
<div class="clear"></div>
<label>Others</label>
<input type="text"  id="lesionOthers"  name="lesionOthers" value="" maxlength="45" validate="Lesion Others,string,no"/>
</div>
<div class="clear"></div>

<label>Local Lymph nodes</label>
<label class="auto">Yes</label>
<input type="radio" name="localLymph" class="radioCheckCol2" id="localLymph" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Lymph');"/>
<label class="auto">No</label>
<input type="radio" name="localLymph" checked="checked" class="radioCheckCol2" id="localLymph" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Lymph');"/>
<div class="clear"></div>
<div id="localLymphYesDiv" style="display: none;">
<!-- <label>Type</label>
<input type="text"  id="localLymphType"  name="localLymphType" value="" maxlength="45" validate="Local Lymph nodes Type,string,no"/>
 -->
<label>Site</label>
<input type="text"  id="localLymphSite"  name="localLymphSite" value="" maxlength="45" validate="Local Lymph nodes Site,string,no"/>



<label>Size</label>
<input type="text"  id="localLymphSize"  name="localLymphSize" value="" maxlength="5" validate="Local Lymph nodes Size,int,no"/>
<div class="clear"></div>

<label>Surface</label>
<input type="text"  id="localLymphSurface"  name="localLymphSurface" value="" maxlength="45" validate="Local Lymph nodes Surface,string,no"/>

<label>Shape</label>
<input type="text"  id="localLymphShape"  name="localLymphShape" value="" maxlength="45" validate="Local Lymph nodes Shape,string,no"/>

<div class="clear"></div>
<label>Consistency</label>
<input type="text"  id="localLymphConsistency"  name="localLymphConsistency" value="" maxlength="45" validate="Local Lymph nodes Consistency,string,no"/>

<label>Mobility</label>
<input type="text"  id="localLymphMobility"  name="localLymphMobility" value="" maxlength="45" validate="Local Lymph nodes Mobility,string,no" />
<div class="clear"></div>
<label>Others</label>
<input type="text"  id="localLymphOthers"  name="localLymphOthers" value="" maxlength="45" validate="Local Lymph nodes Others,string,no"/>
</div>
<div class="clear"></div>

<label>Local Vessel Details</label>
<label class="auto">Present</label>
<input id="localVessel" name="localVessel" tabindex="1" value="Present" type="checkbox" class="checkboxMargin" onclick="displayGeneralSurgryTextValue(this.value,'Vessels');">
<!-- <input type="radio" name="localVessel" class="radioCheckCol2" id="localVessel" value="Present"  onclick="displayGeneralSurgryTextValue(this.value,'Vessels');"/> -->
<!-- <label class="auto">Absent</label>
<input type="radio" name="localVessel" checked="checked" class="radioCheckCol2" id="localVessel" value="Absent" onclick="displayGeneralSurgryTextValue(this.value,'Vessels');"/> -->
<div class="clear"></div>
<div id="localVesselPresentDiv" style="display: none;">
<label>Flow volume</label>
<input type="text"  id="localVesselFlowVolume"  name="localVesselFlowVolume" value="" maxlength="45" validate="Flow volume,string,no"/>

<label>Bruit</label>
<input type="text"  id="localVesselBruit"  name="localVesselBruit" value="" maxlength="45" validate="Bruit,string,no"/>
<div class="clear"></div>
<label>Others</label>
<input type="text"  id="localVesselOthers"  name="localVesselOthers" value="" maxlength="45" validate="Local Vessels Others,string,no"/>
</div>
<div class="clear"></div>

<label>Local Nerves Details</label>
<label class="auto">Yes</label>
<input id="localNerves" name="localNerves" tabindex="1" value="Yes" type="checkbox" class="checkboxMargin" onclick="displayGeneralSurgryTextValue(this.value,'Nerves');">
<!-- <input type="radio" name="localNerves" class="radioCheckCol2" id="localNerves" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'Nerves');"/>
<label class="auto">No</label>
<input type="radio" name="localNerves" checked="checked" class="radioCheckCol2" id="localNerves" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Nerves');"/> -->
<div class="clear"></div>
<div id="localNervesYesDiv" style="display: none;">
<label>Sensory</label>
<input type="text"  id="localNervesSensory"  name="localNervesSensory" value="" maxlength="45" validate="Local Nerves Sensory,string,no"/>


<label>Motor</label>
<input type="text"  id="localNervesMotor"  name="localNervesMotor" value="" maxlength="45" validate="Local Nerves Motor,string,no"/>
<div class="clear"></div>
<label>Others</label>
<input type="text"  id="localNervesOthers"  name="localNervesOthers" value="" maxlength="45" validate="Local Nerves Others,string,no"/>
</div>
<div class="clear"></div>

<label>Local Joints Details</label>
<label class="auto">Yes</label>
<input id="localJoints" name="localJoints" tabindex="1" value="Yes" type="checkbox" class="checkboxMargin" onclick="displayGeneralSurgryTextValue(this.value,'Joints');">
<!-- <input type="radio" name="localJoints" class="radioCheckCol2" id="localJoints" value="yes"  onclick="displayGeneralSurgryTextValue(this.value,'Joints');"/>
<label class="auto">No</label>
<input type="radio" name="localJoints" checked="checked" class="radioCheckCol2" id="localJoints" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Joints');"/> -->
<div class="clear"></div>
<div id="localJointsYesDiv" style="display: none;">
<label>Movements</label>
<input type="text"  id="localJointsMovements"  name="localJointsMovements" value="" maxlength="45" validate="Movements,string,no"/>
</div>
<div class="clear"></div>

<h4>Systemic Examination</h4>
<h4>Gastro-Intestinal system</h4>

<label>Oral cavity</label>
<input  type="checkbox" name="oralCavityWnl" id="oralCavityWnl" class="checkboxMargin" value="y" onclick="displayGeneralSurgryTextValue(this,'cavity');" />
<input type="text"  id="oralCavity"  name="oralCavity" value="" style="display: none" maxlength="45" validate="Oral cavity,string,no"/>
<label>Tongue</label>
<input  type="checkbox" class="checkboxMargin" name="tongueWnl" id="tongueWnl" value="y"  onclick="displayGeneralSurgryTextValue(this,'Tongue');" />
<input type="text"  id="tongue"  name="tongue" value="" style="display: none" maxlength="45" validate="Tongue,string,no"/>
<div class="clear"></div>

<label>Throat</label>
<input  type="checkbox" class="checkboxMargin" name="throatWnl"  id="throatWnl" value="y"  onclick="displayGeneralSurgryTextValue(this,'Throat');" />
<input type="text"  id="throat"  name="throat" value="" style="display: none" maxlength="45" validate="Throat,string,no"/>
<label>Abdomen</label>
<input  type="checkbox" class="checkboxMargin" name="abdomenWnl"  id="abdomenWnl" value="y" onclick="displayGeneralSurgryTextValue(this,'Abdomen');"  />
<input type="text"  id="abdomen"  name="abdomen" value="" style="display: none" maxlength="45" validate="Abdomen,string,no"/>
<div class="clear"></div>

<label>Tenderness</label>
<label class="auto">Yes</label>
<input type="radio" name="gastroIntestinalTenderness" class="radioCheckCol2" id="gastroIntestinalTenderness" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Tenderness');"/>
<label class="auto">No</label>
<input type="radio" name="gastroIntestinalTenderness"  class="radioCheckCol2" id="gastroIntestinalTenderness" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Tenderness');"/>
<div class="clear"></div>
<div id="tendernessYesDiv" style="display: none;">
<label>Site</label>
<input type="text"  id="gastroIntestinalTendernessSite"  name="gastroIntestinalTendernessSite" value="" maxlength="45" validate="Tenderness Site,string,no"/>

<label>Type</label>
<input type="text"  id="gastroIntestinalTendernessType"  name="gastroIntestinalTendernessType" value="" maxlength="45" validate="Tenderness Type,string,no"/>
</div>
<div class="clear"></div>

<label>Swellings</label>
<input  type="checkbox" class="checkboxMargin" name="swellingWnl" value="yes" id="swellingWnl" onclick="displayGeneralSurgryTextValue(this,'SwellingsCheck');" />
<input type="text"  id="swellings"  name="swellings" value="" style="display: none" maxlength="45" validate="Swellings,string,no"/>
<label>Liver</label>
<input  type="checkbox" class="checkboxMargin" name="liverWnl" value="yes" id="liverWnl" onclick="displayGeneralSurgryTextValue(this,'Liver');"/>
<input type="text"  id="liver"  name="liver" value="" style="display: none" maxlength="45" validate="Liver,string,no"/>
<div class="clear"></div>

<label>Renal angles</label>
<input  type="checkbox" class="checkboxMargin" name="renalAnglesWnl" value="y" id="renalAnglesWnl"  onclick="displayGeneralSurgryTextValue(this,'angles');" />
<input type="text"  id="renalAngles"  name="renalAngles" value=""  style="display: none" maxlength="45" validate="Renal angles,string,no"/>
<label>Traube's space</label>
<input  type="checkbox" class="checkboxMargin" name="traubeSpaceWnl" value="y" id="traubeSpaceWnl" onclick="displayGeneralSurgryTextValue(this,'space');"  />
<input type="text"  id="traubeSpace"  name="traubeSpace" value="" style="display: none" maxlength="45" validate="Traube's space,string,no"/>
<div class="clear"></div>

<label>Shifting Dullness</label>
<label class="auto">Yes</label>
<input type="radio" name="ascites" class="radioCheckCol2" id="ascites" value="Yes"  />
<label class="auto">No</label>
<input type="radio" name="ascites"  class="radioCheckCol2" id="ascites" value="No" />

<label>Fluid Thrill</label>
<label class="auto">Yes</label>
<input type="radio" name="ascites" class="radioCheckCol2" id="fluidThrill" value="Yes"  />
<label class="auto">No</label>
<input type="radio" name="ascites"  class="radioCheckCol2" id="fluidThrill" value="No" />

<label>Bruit</label>
<label class="auto">Yes</label>
<input type="radio" name="bruit" class="radioCheckCol2" id="bruit" value="Yes"  onclick="displayGeneralSurgryTextValue(this.value,'Bruit');"  />
<label class="auto">No</label>
<input type="radio" name="bruit"  class="radioCheckCol2" id="bruit" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Bruit');"/>
<div class="clear"></div>

<div id="bruitYesDiv" style="display: none;">
<label>Site</label>
<input type="text"  id="gastroIntestinalBruitSite"  name="gastroIntestinalBruitSite" value="" maxlength="45" validate="Bruit Site,string,no"/>
<label>Type</label>
<input type="text"  id="gastroIntestinalBruitType"  name="gastroIntestinalBruitType" value="" maxlength="45" validate="Bruit Type,string,no"/>
</div>
<div class="clear"></div>

<label>Rectal Examination</label>
<input  type="checkbox"  class="checkboxMargin" name="prExaminationWnl" value="y" id="prExaminationWnl" onclick="displayGeneralSurgryTextValue(this.value,'PRExamination');"/>

<div id="rectalExm" style="display:none">
<input type="text"  id="prExamination"  name="prExamination" value=""  maxlength="45" validate="PR Examination,string,no"/>
<label>Vaginal Examination</label>
<input  type="checkbox" class="checkboxMargin" name="gentialExamWnl" value="y" id="gentialExamWnl" onclick="displayGeneralSurgryTextValue(this.value,'gentialExamWnl');"/>
<input type="text"  id="gentialExamWnlValue"  name="gentialExamWnlValue" value="" style="display:none" maxlength="45" validate="PR Examination,string,no"/>
</div>

<div class="clear"></div>
<label>External Genitalia</label>
<input  type="checkbox" class="checkboxMargin" name="externalGenitaliaWnl" value="y" id="externalGenitaliaWnl" onclick="displayGeneralSurgryTextValue(this.value,'Genitalia');" />
<input type="text"  id="externalGenitalia"  name="externalGenitalia" value="" style="display: none" maxlength="45" validate="External Genitalia,string,no"/>
<div class="clear"></div>

<h4>Respiratory System</h4>
<label>Air entry</label>
<label class="auto">Equal</label>
<input type="radio" name="airEntry" class="radioCheckCol2" id="airEntry" value="Equal" checked="checked" onclick="displayGeneralSurgryTextValue(this.value,'AirEntry');"/>
<label class="auto">Reduced</label>
<input type="radio" name="airEntry"  class="radioCheckCol2" id="airEntry" value="Reduced"  onclick="displayGeneralSurgryTextValue(this.value,'AirEntry');"/>

<div id="airEntryReducedDiv">
<label class="auto">Left</label>
<input type="radio" name="airEntryReduced" class="radioCheckCol2" id="airEntryReduced" value="Left"  />
<label class="auto">Right</label>
<input type="radio" name="airEntryReduced"  class="radioCheckCol2" id="airEntryReduced" value="Right" />
</div>
<div class="clear"></div>

<label>Tenderness </label>
<label class="auto">Yes</label>
<input type="radio" name="respiratoryTenderness" class="radioCheckCol2" id="respiratoryTenderness" value="Yes" onclick="displayGeneralSurgryTextValue(this.value,'TendernessR');"  />
<label class="auto">No</label>
<input type="radio" name="respiratoryTenderness" checked="checked"  class="radioCheckCol2" id="respiratoryTenderness" value="No" onclick="displayGeneralSurgryTextValue(this.value,'TendernessR');" />

<div id="tendernessRYesDiv" style="display: none;">
<label>Site</label>
<input type="text"  id="respiratoryTendernessSite"  name="respiratoryTendernessSite" value=""  maxlength="45" validate="Tenderness Site,string,no"/>
<div class="clear"></div>
<label>Type</label>
<input type="text"  id="respiratoryTendernessType"  name="respiratoryTendernessType" value=""  maxlength="45" validate="Tenderness Type,string,no"/>
</div>
<div class="clear"></div>

<label>Rhonchi</label>
<label class="auto">Yes</label>
<input type="radio" name="rhonchi" class="radioCheckCol2" id="rhonchi" value="Yes" onclick="displayGeneralSurgryTextValue(this.value,'Rhonchi');"  />
<label class="auto">No</label>
<input type="radio" name="rhonchi" checked="checked"  class="radioCheckCol2" id="rhonchi" value="No" onclick="displayGeneralSurgryTextValue(this.value,'Rhonchi');"  />

<div id="rhonchiYesDiv" style="display: none;">
<label>Site</label>
<input type="text"  id="rhonchiSite"  name="rhonchiSite" value=""  maxlength="45" validate="Rhonchi Site,string,no"/>
<div class="clear"></div>
<label>Type</label>
<input type="text"  id="rhonchiType"  name="rhonchiType" value=""  maxlength="45" validate="Rhonchi Type,string,no"/>
</div>
<div class="clear"></div>

<label>Crepitation</label> 
<label class="auto">Yes</label>
<input type="radio" name="respiratoryCrepitaions" class="radioCheckCol2" id="respiratoryCrepitaions" value="Yes" onclick="displayGeneralSurgryTextValue(this.value,'Crepitiation');"  />
<label class="auto">No</label>
<input type="radio" name="respiratoryCrepitaions" checked="checked"  class="radioCheckCol2" id="respiratoryCrepitaions" value="No" onclick="displayGeneralSurgryTextValue(this.value,'RhonCrepitiationchi');"  />

<div id="crepitaionsYesDiv" style="display: none;">
<label>Site</label>
<input type="text"  id="respiratoryCrepitaionsSite"  name="respiratoryCrepitaionsSite" value="" maxlength="45" validate="Crepitiation Site,string,no"/>
<label>Type</label>
<input type="text"  id="respiratoryCrepitaionsType"  name="respiratoryCrepitaionsType" value="" maxlength="45" validate="Crepitiation Type,string,no"/>
</div>
<div class="clear"></div>

<h4>Cardiovascular System</h4>
<label>Sounds</label>
<input  type="checkbox" class="checkboxMargin" name="soundsWnl" id="soundsWnl" value="y" onclick="displayGeneralSurgryTextValue(this,'Sounds');" />
<input type="text"  id="sounds"  name="sounds" value="" style="display: none" maxlength="45" validate="Sounds,string,no"/>
<label>Cardiomegaly</label>
<label class="auto">Yes</label>
<input type="radio" name="cardiomegaly" class="radioCheckCol2" id="cardiomegaly" value="Yes"  />
<label class="auto">No</label>
<input type="radio" name="cardiomegaly"   class="radioCheckCol2" id="cardiomegaly" value="No" />
<div class="clear"></div>

<h4>Central Nervous System</h4>
<label>GCS</label>
<label class="auto">Yes</label>
<input type="radio" name="GCS" class="radioCheckCol2" id="GCS" value="Yes" onclick="displayGeneralSurgryTextValue(this.value,'GCS');" />
<label class="auto">No</label>
<input type="radio" name="GCS" checked="checked"  class="radioCheckCol2" id="GCS" value="No" onclick="displayGeneralSurgryTextValue(this.value,'GCS');" />
<div id="GCSDiv" style="display: none">
<div class="clear"></div>
<label>Eye Opening Response</label>
<select  name="eyeOpeningResponse" id="eyeOpeningResponse" class="large" onchange="displayTotalScoreGCSS();calculateHeadInjuryClassification();">
<option value="">Select</option>
<option value="Spontaneous--open with blinking at baseline 4 points">Spontaneous--open with blinking at baseline 4 points </option>
<option value="To verbal stimuli, command, speech 3 points">To verbal stimuli, command, speech 3 points </option>
<option value="To pain only (not applied to face) 2 points">To pain only (not applied to face) 2 points</option>
<option value="No response 1 point">No response 1 point </option>
</select>
<div class="clear"></div>
<label>Verbal Response </label>
<select  name="verbalResponse"  id="verbalResponse" class="large" onchange="displayTotalScoreGCSS();calculateHeadInjuryClassification();">
<option value="">Select</option>
<option value="Oriented 5 points">Oriented 5 points </option>
<option value="Confused conversation, but able to answer questions 4 points">Confused conversation, but able to answer questions 4 points</option>
<option value="Inappropriate words 3 points">Inappropriate words 3 points</option>
<option value="Incomprehensible speech 2 points ">Incomprehensible speech 2 points </option>
<option value="No response 1 point">No response 1 point</option>
</select>
<div class="clear"></div>
<label>Motor Response </label>
<select  name="motorResponse" id="motorResponse" class="large" onchange="displayTotalScoreGCSS();calculateHeadInjuryClassification();">
<option value="">Select</option>
<option value="Obeys commands for movement 6 points ">Obeys commands for movement 6 points </option>
<option value="Purposeful movement to painful stimulus 5 points">Purposeful movement to painful stimulus 5 points</option>
<option value="Withdraws in response to pain 4 points">Withdraws in response to pain 4 points</option>
<option value="Flexion in response to pain (decorticate posturing) 3 points">Flexion in response to pain (decorticate posturing) 3 points</option>
<option value="Extension response in response to pain (decerebrate posturing) 2 points">Extension response in response to pain (decerebrate posturing) 2 points</option>
<option value="No response 1 point">No response 1 point</option>
</select>
<div class="clear"></div>
<label>Glasgow Come Scale  Score</label>
<input type="text"  id="totalSourceGCSS"  name="totalSourceGCSS" value="" maxlength="45" disabled="disabled"/>

<!-- <label>Categorization / Head Injury Classification</label>
<select  name="headInjury"  id="headInjury" class="large">
<option value="">Select</option>
<option value="No eye opening, no ability to follow commands, no word verbalizations (3-8)">If Score is 3-8 then display - Coma - No eye opening, no ability to follow commands, no word verbalizations (3-8)</option>
<option value="Severe Head Injury">If Score is 8 or less then display - Severe Head Injury</option>
<option value="Moderate Head Injury">If Score is 9 to 12 then display - Moderate Head Injury</option>
<option value="Mild Head Injury">If Score is 13 to 15 then display - Mild Head Injury</option>
</select>  -->
</div>
<div class="clear"></div>
<!-- <input type="text"  id="gcs"  name="gcs" value=""/> -->
<label>Cranial nerves</label>
<input type="text"  id="cranialNerves"  name="cranialNerves" value="" maxlength="45" validate="Cranial nerves,string,no"/>

<label>Reflexes</label>
<input type="text"  id="reflexes"  name="reflexes" value="" maxlength="45" validate="Reflexes,string,no"/>
<div class="clear"></div>

<h4>Musculoskeletal system</h4>
<label>Muscle power</label>
<input type="text"  id="musclePower"  name="musclePower" value="" maxlength="45" validate="Muscle power,string,no"/>
<label>Joints</label>
<input type="text"  id="musculoskeletalJoints"  name="musculoskeletalJoints" value="" maxlength="45" validate="Joints,string,no"/>
<div class="clear"></div>
<div class="clear"></div>
<label>Management Plan</label>
<textarea rows="" cols="" name="plan" style="margin:0px; width:550px;" maxlength="250" validate="Management Plan,string,no"  onkeyup="return checkLength(this)"></textarea>

</div>
</form>

<style>
.widthH4{min-width:170px; float:left;}
.width85{width:85px;}
</style>




 <script type="text/javascript">	

 				var	relationArray= new Array();
                      <%
				         for (int k = 0; k < relationList.size(); k++) {
				        	 MasRelation  masRelation = (MasRelation) relationList.get(k);
	     			 %> 
	     			relationArray[<%=k%>]= new Array();
	     			relationArray[<%=k%>][0] = "<%=masRelation.getId()%>";
	     			relationArray[<%=k%>][1] = "<%=masRelation.getRelationName()%>";
	             <% }%>
	             </script>

