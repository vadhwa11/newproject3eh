<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPsychogeriatricClinicSpeciality"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript">
	
	
	<%	
	//code added by rajdeo
	String templateName="Psychogeriatric Clinic";
	
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
	
	
	
	//added by swarup
	Map<String,Object> map = new HashMap<String,Object>();
	OpdPsychogeriatricClinicSpeciality opdPsychogeriatricClinicSpeciality = null;
	
	if(map.get("opdPsychogeriatricClinicSpeciality") != null){
		 opdPsychogeriatricClinicSpeciality =(OpdPsychogeriatricClinicSpeciality)map.get("opdPsychogeriatricClinicSpeciality");
	 }
	
	
	//code added by rajdeo
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	int hinId=0;
	int visitId=0;
	
	if(map.get("hinId")!=null)
	{
	hinId=(Integer)map.get("hinId"); 
	}
	if(map.get("visitId")!=null)
	{
		visitId=(Integer)map.get("visitId"); 
	}
	
	
	
	 

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year %>'
	</script>
	<script>jQuery.noConflict();
jQuery(function($) {
	
    function split( val ) {
        return val.split( /,\s*/ );
    }
    function extractLast( term ) {
        return split( term ).pop();
    }
    
  
	$( ".historyAutoComplete" )
    .autocomplete({
	    minLength: 1,
		source: function( request, response ) {
            // delegate back to autocomplete, but extract the last term
			var arTerm=request.term.split(",");
			var searchTerm=arTerm[arTerm.length-1].trim();
			console.log("terms :: "+searchTerm);
			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
			var refsetidParam = document.getElementById('refsetId').value;
			servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
            $.getJSON(servURL,
            		function (data)
			{ 
            	var array = data.error ? [] : $.map(data, function(m) {
					return {
						label: m.term ,
						 value:  m.conceptId 
					};
				});
				response(array);
			
            });
        },
        focus: function() {
            // prevent value inserted on focus
            return false;
        },
        select: function( event, ui ) {
            var terms = split( this.value );
         	// remove the current input
            terms.pop();
          
            terms.push( ui.item.label );
            // add placeholder to get the comma-and-space at the end
            terms.push( "" );
            var snomedCount =   $('#snomedCount').val();
            snomedCount = parseInt(snomedCount)+1;
            $('#snomedCount').val(snomedCount) ;
           
            var fieldType = $(this).prev().text().replace(/\s+/g," ");
       		if(fieldType == 'GIS'){
       			fieldType = 'Systemic Examination';
       		}
           $('#termTable').append("<input type='text' name ='snomedId"+snomedCount+"' value ='"+ui.item.value+"' />"+"<input type='text' name ='snomedDesc"+snomedCount+"' value ='"+ui.item.label+"'/><input type='text' name ='fieldType"+snomedCount+"' value ='"+fieldType+"'/>");
       /*    $('#termTable').append("<tr>");
          $('#termTable').append("<td><input type='text' name ='termValue' value ='"+ui.item.value+"' /></td>");
          $('#termTable').append("<td><input type='text' name ='termLabel' value ='"+ui.item.label+"'/></td>");
          $('#termTable').append("<td><input type='text' name ='termType' value ='Present Complaint'/></td>");
          $('#termTable').append("</tr>"); */
           	
       		 $("#termTable td").each(function () {
       		    var tdText = $(this).text();
       		    $("#termTable td").filter(function () { 
       		            return tdText == $(this).text(); 
       		        }).not(":first").remove();
       		});
		   
            this.value = terms.join( "," );
            return false;
        }
    });
});
</script>
	

<form method="post" action="" name="dedd" >
<h6>Psychogeriatric Clinic</h6>
<div class="EntExmMainDiv">
<div class="Block">
<input class="buttonAuto" value="Family tree inputs" onclick="openPopupForFamilyTreeEntry(<%=hinId %>);" type="button">
<input class="buttonAuto" value="Family Tree" onclick="openPopupForFamilyTree(<%=hinId %>)" type="button">

<div class="clear"></div>
<input id="psychogeriatricClinicFlag" name="psychogeriatricClinicFlag" tabindex="1" value="PsychogeriatricClinic" type="hidden"  />
<input type="hidden" name="templateName" value="Psychogeriatric Clinic"/>
  <label>Social-Economic Status</label>
  <select tabindex="1" id="socialEconomicStatus" name="socialEconomicStatus"  validate="Social-Economic Status,string,no"> 
		<option value="">Select</option>
		<option value="BPL">BPL</option>
		<option value="APL">APL</option>
		<option value="Do not know">Do not know</option>    
		</select>
<label>Type of Family</label>
  <select tabindex="1" id="typeOfFamily" name="typeOfFamily" validate="Type of Family,string,no"> 
		<option value="">Select</option>
		<option value="Nuclear">Nuclear</option>
		<option value="Extended">Extended</option>
		<option value="Joint">Joint</option>    
		</select>
<div class="clear"></div>
<label>Social Support</label>
  <select tabindex="1" id="socialSupport" name="socialSupport"  validate="Social Support,string,no"> 
		<option value="">Select</option>
		<option value="Poor">Poor</option>
		<option value="Average">Average</option>
		<option value="Good">Good</option>   
</select>

<label class="auto">Impulse Dyscontrol Symptoms</label>
<textarea class="opdMainTextArea yellowBackground historyAutoComplete" 
						name="impulseDyscontrolSymptoms" id="impulseDyscontrolSymptoms" tabindex="2"
						validate="Impulse Dyscontrol Symptoms,string,no" cols="0" rows="0"
						maxlength="256"  ></textarea>
<div class="clear"></div>

<!-- <label style="font-size:11px;">Present Complaint / History</label>
<textarea class="opdMainTextArea yellowBackground historyAutoComplete" 
						name="presentComplainTemp" id="presentComplainTemp" tabindex="2"
						validate="Present Complain & History,string,no" cols="0" rows="0"
						maxlength="256"  onblur="setVitalValue(this.value,'presentComplain');"></textarea>
					<input type="button" class="buttonAuto-buttn" tabindex="3" name="" style="height:19px;"
						value="+" onclick="getPresentTemplate(csrfTokenName+'='+csrfTokenValue);"/> <label>History
						of Past Illness</label> -->
<div class="clear"></div>
<!-- <label>Past h/o mental illness</label>
  <select tabindex="1" id="pastHistoryOfMentalIllness" name="pastHistoryOfMentalIllness" validate="Past h/o mental illness,string,no"> 
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="N">No</option>   
		</select>
<label>If Yes, Specify</label>
<input id="pastHistoryOfMentalIllnessValue" type="text" name="pastHistoryOfMentalIllnessValue" value="" tabindex="1" validate="Skull and Spine,metachar,no" maxlength="250">
 -->
 
 <!-- added by swarup 15/11/2017  -->
  		<label>Past h/o mental illness</label>
	<select  name="pastHistoryOfMentalIllness" onchange ="toggleOtherTextbox(this.value,'pastHistoryOfMentalIllnessValue',128, 'pastHistoryOfMentalIllness_span')">
		<option value="">Select</option>
		<option value="y" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfMentalIllness().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfMentalIllness().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="pastHistoryOfMentalIllness_span">
	<%if(opdPsychogeriatricClinicSpeciality!=null && opdPsychogeriatricClinicSpeciality.getPastHistoryOfMentalIllnessValue().equals("y")){%>
	<input type="text" maxlength="128" name="pastHistoryOfMentalIllnessValue" value="<%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfMentalIllnessValue():""%>"><%} %>
	</span> 
 <!-- ended by swarup 15/11/2017  -->
 
<div class="clear"></div>
<!--previous <label>Past h/o physical illness</label>
  <select tabindex="1" id="pastHistoryOfPastIllness" name="pastHistoryOfPastIllness"  validate="Cold Spatula Test,string,no"> 
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="N">No</option>   
		</select>
<div class="clear"></div>
<label>If Yes, Specify</label>
<label>Hypertension</label>
<input type="checkbox" id="hypertension" name="hypertension" tabindex="1"  value="y" class="checkboxMargin">
<label>Diabetes Mellitus</label>
<input type="checkbox" id="diabetesMellitus" name="diabetesMellitus" tabindex="1" value="y"   class="checkboxMargin" >
<label>Bronchial asthma</label>
<input type="checkbox" id="bronchialAsthma" name="bronchialAsthma" tabindex="1"  value="y" class="checkboxMargin" >
<div class="clear"></div>
<label>Tuberculosis</label>
<input type="checkbox" id="tuberculosis" name="tuberculosis" tabindex="1"  value="y" class="checkboxMargin" >
<label>Cerebrovascular Accident</label>
<input type="checkbox" id="cerebrovascularAccident" name="cerebrovascularAccident" tabindex="1"  value="y" class="checkboxMargin" >
<label>Seizure Disorder</label>
<input type="checkbox" id="seizureDisorder" name="seizureDisorder" tabindex="1"  value = "y" class="checkboxMargin" > -->

<!-- added by swarup 15/11/2017  -->
<label>Past h/o physical illness</label>
<select  name="pastHistoryOfPastIllness" onchange="getPastHistoryOfPhysicalIllness(this.value);">
<option value="">Select</option>
<option value="y" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfPhysicalIllness().equals("y")?"selected":"block":"none"%>>Yes</option>
<option value="n" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfPhysicalIllness().equals("n")?"selected":"block":"none"%>>No</option>
</select>
<div id="pastHistoryOfPhysicalIllnessDiv" style="display: <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPastHistoryOfPhysicalIllness().equals("Yes")?"selected":"block":"none"%>">
<div class="clear"></div>
<label>Hypertension</label>
<input type="checkbox" id="hypertension" name="hypertension" tabindex="1"  value="y" class="checkboxMargin">  

<label>Diabetes Mellitus</label>
<input type="checkbox" id="diabetesMellitus" name="diabetesMellitus" tabindex="1" value="y"   class="checkboxMargin" >
<div class="clear"></div>

<label>Bronchial asthma</label>
<input type="checkbox" id="bronchialAsthma" name="bronchialAsthma" tabindex="1"  value="y" class="checkboxMargin" >

<label>Tuberculosis</label>
<input type="checkbox" id="tuberculosis" name="tuberculosis" tabindex="1"  value="y" class="checkboxMargin" >
<div class="clear"></div>

<label>Cerebrovascular Accident</label>
<input type="checkbox" id="cerebrovascularAccident" name="cerebrovascularAccident" tabindex="1"  value="y" class="checkboxMargin" >


<label>Seizure Disorder</label>
<input type="checkbox" id="seizureDisorder" name="seizureDisorder" tabindex="1"  value = "y" class="checkboxMargin" >
<div class="clear"></div>

<div class="clear"></div>
 <label>Others, Specify</label>
	<select  name="otherPhysicalIllness" onchange ="toggleOtherTextbox(this.value,'otherPhysicalIllnessValue',128, 'otherPhysicalIllnessValue_span')">
		<option value="">Select</option>
		<option value="y" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getOtherPhysicalIllness().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getOtherPhysicalIllness().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="otherPhysicalIllnessValue_span">
	<%if(opdPsychogeriatricClinicSpeciality!=null && opdPsychogeriatricClinicSpeciality.getOtherPhysicalIllnessValue().equals("y")){%>
	<input type="text" maxlength="100" name="otherPhysicalIllnessValue" value="<%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getOtherPhysicalIllnessValue():""%>"><%} %>
	</span>  
	
	<!-- <label>Others, Specify</label>
<input type="checkbox" id="" name="otherPhysicalIllness" tabindex="1"  value = "y" style="margin:0px 11px 0px 5px;" >
<input id="physicalIllnessValue" type="text" name="physicalIllnessValue" value="" tabindex="1" validate="Others,metachar,no" maxlength="250"> -->
</div>
<!-- ended by swarup 15/11/2017  -->

<div class="clear"></div>
<!-- <label>Family h/o mental illness</label>
  <select tabindex="1" id="familyHistoryOfMentalIllness" name="familyHistoryOfMentalIllness"  validate="Cold Spatula Test,string,no"> 
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="N">No</option>   
		</select>
<label>If Yes, Specify</label>
<input id="familyHistoryOfMentalIllnessValue" type="text" name="familyHistoryOfMentalIllnessValue" value="" tabindex="1" validate="Skull and Spine,metachar,no" maxlength="250">
 -->
 
 <!--added by swarup 15/11/2017  -->
 <label>Family h/o mental illness</label>
	<select  name="familyHistoryOfMentalIllness" onchange ="toggleOtherTextbox(this.value,'familyHistoryOfMentalIllnessValue',128, 'familyHistoryOfMentalIllness_span')">
		<option value="">Select</option>
		<option value="y" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getFamilyHistoryOfMentalIllness().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getFamilyHistoryOfMentalIllness().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="familyHistoryOfMentalIllness_span">
	<%if(opdPsychogeriatricClinicSpeciality!=null && opdPsychogeriatricClinicSpeciality.getFamilyHistoryOfMentalIllnessValue().equals("y")){%>
	<input type="text" maxlength="28" name="familyHistoryOfMentalIllnessValue" value="<%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getFamilyHistoryOfMentalIllnessValue():""%>"><%} %>
	</span>
 <!--ended by swarup 15/11/2017  -->
 
 <div class="clear"></div>
<!-- <label>Substance use d/o</label>
  <select tabindex="1" id="subStanceUse" name="subStanceUse"  validate="Cold Spatula Test,string,no" style="width:68px;"> 
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="N">No</option>   
		</select>
<label class="auto">If yes, Type of Substance/s & substance use d/o</label>
<input id="typeOfSubstance" type="text" name="typeOfSubstance" value="" tabindex="1" validate="Skull and Spine,metachar,no" maxlength="250">
 -->
 
 <div class="clear"></div> 
<!--added by swarup 15/11/2017  -->
<label>Substance Use Disorder</label>
<select  name="subStanceUse" onchange="getSubstanceUse(this.value);">
<option value="">Select</option>
<option value="Yes" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getSubstanceUse().equals("Yes")?"selected":"block":"none"%>>Yes</option>
<option value="No" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getSubstanceUse().equals("No")?"selected":"block":"none"%>>No</option>
</select>
<div id="substanceUseDiv" style="display: <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getSubstanceUse().equals("Yes")?"selected":"block":"none"%>">
<label class="heightAuto">Type of Substance use Disorder</label>
<input  type="text"  name="typeOfSubstance" id="typeOfSubstance"  value="<%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getSubstanceUse():""%>" maxlength="30"  />
</div>
<!--ended by swarup 15/11/2017  -->
 
<!-- <label>Premorbid Personality</label>
  <select tabindex="1" id="premorbidPersonality" name="premorbidPersonality" value="" validate="Cold Spatula Test,string,no"> 
		<option value="">Select</option>
		<option value="Y">Yes</option>
		<option value="N">No</option>   
		</select>
<label>If Yes, Specify</label>
<select tabindex="1" id="premorbidPersonalityValue" name="premorbidPersonalityValue" value="" validate="Cold Spatula Test,string,no"> 
		<option value="">Select</option>
		<option value="1">Cluster A</option>
		<option value="2">Cluster B</option>
		<option value="3">Cluster C</option>   
		</select> -->
<div class="clear"></div>	
	
<!--Added by swarup 15/11/2017  -->
	<label>Premorbid Personality</label>
	<%-- <select  name="premorbidPersonality" onchange ="toggleOtherTextbox(this.value,'premorbidPersonalityValue',28, 'premorbidPersonality_span')">
		<option value="">Select</option>
		<option value="y" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPremorbidPersonality().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPremorbidPersonality().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="premorbidPersonality_span"> --%>
	<%if(opdPsychogeriatricClinicSpeciality!=null && opdPsychogeriatricClinicSpeciality.getPremorbidPersonalityValue().equals("y")){%>
	<input type="text" maxlength="128" name="premorbidPersonalityValue" value="<%=opdPsychogeriatricClinicSpeciality!=null?opdPsychogeriatricClinicSpeciality.getPremorbidPersonalityValue():""%>"><%}else{ %>
	<input type="text" maxlength="128" name="premorbidPersonalityValue" value="">
	<%} %>
	<!-- </span> --> 
 <!--ended by swarup 15/11/2017  -->
		
<div class="clear"></div>
<label>Mental Status Examination</label>
<textarea id="mentalStatusExamination" name="mentalStatusExamination" maxlength="256" rows="0" cols="0" validate="Mental Status Examination,string,no" class="textareaMediua historyAutoComplete" onkeyup="" ></textarea>
<label>Cognitive Function</label>
<textarea id="cognitiveFunction" name="cognitiveFunction" maxlength="256" rows="0" cols="0" validate="Cognitive Function,string,no" class="textareaMediua historyAutoComplete" onkeyup="" ></textarea>
<div class="clear"></div>
<label>Treatment Given</label>
<textarea id="treatmentGiven" name="treatmentGiven" maxlength="256" rows="0" cols="0" validate="Treatment Given,string,no" class="textareaMediua historyAutoComplete" onkeyup="" ></textarea>
<div class="clear"></div>
<div class="titleBg">
<h2>EVERYDAY ABILITIES SCALE FOR INDIA (EASI)</h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<table border="0" cellpadding="5" cellspacing="0" class="tablestylePadding" style="width:890px!important;">
<tr>
      <td width="38" align="center">&nbsp;</td>
      <td width="586" align="center">&nbsp;</td>
      <td colspan="4" align="center"><strong>Score</strong></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td align="left">&nbsp;</td>
      <td colspan="2" align="center"><strong>Yes</strong></td>
      <td colspan="2" align="center"><strong>No</strong></td>
    </tr>

    
    <tr>
      <td align="center">1.</td>
      <td align="left">Does he/she ever forget that he/she has just eaten and ask for food again?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="eatenAndAskForFood" name="eatenAndAskForFood" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value);" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="eatenAndAskForFood" name="eatenAndAskForFood" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value);" checked></td>
    </tr>
   
    
    
    <tr>
      <td align="center">2.</td>
      <td align="left">Does he/she urinate in an appropriate place?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="urinateInAnAppropriatePlace" name="urinateInAnAppropriatePlace" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value);" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="urinateInAnAppropriatePlace" name="urinateInAnAppropriatePlace" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value);" checked ></td>
    </tr>
    <tr>
      <td align="center">3.</td>
      <td align="left">Do his/her clothes ever get dirty from urine or stools?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="urineOrStools" name="urineOrStools" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="urineOrStools" name="urineOrStools" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">4.</td>
      <td align="left">Is his/her shirt/petticoat tied properly?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="shirtAndPetticoatTiedProperly" name="shirtAndPetticoatTiedProperly" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="shirtAndPetticoatTiedProperly" name="shirtAndPetticoatTiedProperly" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">5.</td>
      <td align="left">Is his/her dhoti/petticoat tied properly?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="DhotiAndPetticoatTiedProperly" name="DhotiAndPetticoatTiedProperly" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="DhotiAndPetticoatTiedProperly" name="DhotiAndPetticoatTiedProperly" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">6.</td>
      <td align="left">Is he/she able to work as a member of a team i.e., in a group activity which requires different roles from people, will he/she be able to participate?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="ableToParticipate" name="ableToParticipate" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="ableToParticipate" name="ableToParticipate" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">7.</td>
      <td align="left">Does he/she express his/her opinion appropriately on  important family matters. e.g.: marriage?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="familyMatters" name="familyMatters" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="familyMatters" name="familyMatters" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">8.</td>
      <td align="left">If he/she is assigned or himself/herself decides to undertake an important task,  can he/she follow it through to completion?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="undertakeAnImportantTask" name="undertakeAnImportantTask" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="undertakeAnImportantTask" name="undertakeAnImportantTask" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">9.</td>
      <td align="left">Is he/she able to remember important festivals such as Holi, Diwali?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="importantFestivals" name="importantFestivals" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="importantFestivals" name="importantFestivals" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">10.</td>
      <td align="left">If he/she is asked to deliver a message does he/she remember to do so?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="deliverAMessage" name="deliverAMessage" value="0"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="deliverAMessage" name="deliverAMessage" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">11.</td>
      <td align="left">Does he/she appropriately discuss local/regional events such as marriages, disasters, politics?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="regionalEvents" name="regionalEvents" value="0"  tabindex="1" class="radiobutMargin" onclick="calculate(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="regionalEvents" name="regionalEvents" value="1"  tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">12.</td>
      <td align="left">Does he/she ever lose his her way in the village?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="wayInTheVillage" name="wayInTheVillage" value="1"   tabindex="1" class="radiobutMargin"  onclick="calculate(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="wayInTheVillage" name="wayInTheVillage" value="0" tabindex="1"  class="radiobutMargin"  onclick="calculate(this.value)" checked></td>
    </tr>
  </table>
  
 
<div class="clear"></div>

<h4 style="color:#000;">Total Score</h4>

<div class="clear"></div>

<label class="widthAuto">0</label>
<input type="text" name="easiTotalScoreZero" id="easiTotalScoreZero" onkeypress="javascript:return isNumber(event)" size="20" value="3" tabindex="1" validate="Total Score,metachar,no" maxlength="2">

<label>1</label>
<input type="text" name="easiTotalScoreOne"  id="easiTotalScoreOne" onkeypress="javascript:return isNumber(event)" size="20"  value="9" tabindex="1" validate="Total Score,metachar,no" maxlength="2">
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h2>HINDI MENTAL STATE EXAMINATION (HMSE)</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>
<table border="0" cellpadding="5" cellspacing="0" class="tablestylePadding" style="width:890px!important;">
    <tr>
      <td colspan="3" align="center">&nbsp;</td>
      <td colspan="2" align="center"><strong>Correct</strong></td>
      <td colspan="2" align="center"><strong>Wrong</strong></td>
    </tr>
    <tr>
      <td width="38" align="center">1.</td>
      <td colspan="2" align="left">Is it morning or afternoon or evening?</td>
      <td width="33" align="right">1</td>
      <td width="35" align="center"><input type="radio" id="afternoonOrEvening" name="afternoonOrEvening" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td width="37" align="right">0</td>
      <td width="41" align="center"><input type="radio" id="afternoonOrEvening" name="afternoonOrEvening" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">2.</td>
      <td colspan="2" align="left">What day of the week is today?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="dayOfTheWeek" name="dayOfTheWeek" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="dayOfTheWeek" name="dayOfTheWeek" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">3.</td>
      <td colspan="2" align="left">What date is today?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="dateIsToday" name="dateIsToday" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="dateIsToday" name="dateIsToday" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">4.</td>
      <td colspan="2" align="left">Which month is today?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="monthIsToday" name="monthIsToday" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="monthIsToday" name="monthIsToday" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">5.</td>
      <td colspan="2" align="left">What season of the year is this?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="seasonOfTheYear" name="seasonOfTheYear" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="seasonOfTheYear" name="seasonOfTheYear" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">6.</td>
      <td colspan="2" align="left">Under which post office does your village come?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="postOffice" name="postOffice" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="postOffice" name="postOffice" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">7.</td>
      <td colspan="2" align="left">Which district does your village fall under?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="district" name="district" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="district" name="district" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">8.</td>
      <td colspan="2" align="left">Which village are you from?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="village" name="village" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="village" name="village" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">9.</td>
      <td colspan="2" align="left">Which block (if village has only blocks) &nbsp;&nbsp;&nbsp;&nbsp;
        <strong>OR</strong></td>
      <td rowspan="2" align="right">1</td>
      <td rowspan="2" align="center"><input type="radio" id="block" name="block" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td rowspan="2" align="right">0</td>
      <td rowspan="2" align="center"><input type="radio" id="block" name="block" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">Which numbered area is this?</td>
    </tr>
    <tr>
      <td align="center">10.</td>
      <td colspan="2" align="left">Which place is this?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="place" name="place" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="place" name="place" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">11.</td>
      <td colspan="2" rowspan="2" align="left">I went to Delhi and brought three things - Mango, Chair and Coin<br>
      Can you tell me what the three things I bought from Delhi are?</td>
      <td align="left">&nbsp;</td>
      <td align="center">1</td>
      <td align="center">2</td>
      <td align="center">3</td>
    </tr>
    <tr>
      <td align="left">&nbsp;</td>
      <td align="center"><input id="boughtFromDelhi11One" name="boughtFromDelhi" value="1" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFromDelhi1Val)" tabindex="1" name=""></td>
      <td align="right"><input id="" name="boughtFromDelhi" value="2" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFromDelhi1Val)" tabindex="1" name=""></td>
      <td align="center"><input id="" name="boughtFromDelhi" value="3" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFromDelhi1Val)" tabindex="1" name="">
      <!-- Added by Babita: Change all checkboxes to radio buttons, below variable for score counting purpose-->
      <input type="hidden" name="boughtFromDelhi1Val" id="boughtFromDelhi1Val" value="0">
      <!-- End -->
      </td>
    </tr>
    <tr>
      <td rowspan="2" align="center">12.</td>
      <td width="586" rowspan="2" align="left">(a) Now can you tell me the names of the day of the week starting from Sunday?<br>
      (b) Now can you tell me names of the day backward order?</td>
      <td width="33" align="center">1</td>
      <td align="center">2</td>
      <td align="center">3</td>
      <td align="center">4</td>
      <td align="center">5</td>
    </tr>
    <tr>
      <td align="right"><input id="boughtFromDelhi12One" value="1" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,weekDaysVal)" tabindex="1" name="weekDays"></td>
      <td align="center"><input id="boughtFromDelhi12Two" value="2" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,weekDaysVal)" tabindex="1" name="weekDays"></td>
      <td align="right"><input id="boughtFromDelhi12Three" value="3" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,weekDaysVal)" tabindex="1" name="weekDays"></td>
      <td align="center"><input id="boughtFromDelhi12Four" value="4" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,weekDaysVal)" tabindex="1" name="weekDays"></td>
      <td align="center"><input id="boughtFromDelhi12Five" value="5" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,weekDaysVal)" tabindex="1" name="weekDays">
       <input type="hidden" name="weekDaysVal" id="weekDaysVal" value="0">
      </td>
    </tr>
    <tr>
      <td rowspan="2" align="center">13.</td>
      <td colspan="2" rowspan="2" align="left">What are the names of the three things which<br>
      I told you that I have brought from Delhi?</td>
      <td align="center">&nbsp;</td>
      <td align="center">1</td>
      <td align="center">2</td>
      <td align="center">3</td>
    </tr>
    <tr> 
      <td align="center">&nbsp;</td>
      <td align="center"><input id="boughtFromDelhi13One" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFrom2Delhi)" tabindex="1" name="broughtFromDelhi"></td>
      <td align="right"><input id="boughtFromDelhi13Two" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFrom2Delhi)" tabindex="1" name="broughtFromDelhi"></td>
      <td align="center"><input id="boughtFromDelhi13Three" class="checkboxMargin" type="radio" onchange="calMiddleTabChkBox(this.value,this,boughtFrom2Delhi)" tabindex="1" name="broughtFromDelhi">
      <input type="hidden" name="boughtFrom2Delhi" id="boughtFrom2Delhi" value="0"> 
      </td>
    </tr>
    <tr>
      <td rowspan="2" align="center">14.</td>
      <td colspan="2" align="left">Show him the wrist watch and ask- What is this? &nbsp;&nbsp;&nbsp; <strong>OR</strong></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="wristWatch" name="wristWatch" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id=wristWatch" name="wristWatch" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">(a) (<strong>If necessary</strong>) identification of watch by touching, ask what is this?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="identificationOfWatch" name="identificationOfWatch" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="identificationOfWatch" name="identificationOfWatch" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">15.</td>
      <td colspan="2" align="left">Show him the pen and ask - What is this? &nbsp;&nbsp;&nbsp; <strong>OR</strong></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="showHimPen" name="showHimPen" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="showHimPen" name="showHimPen" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">(a) (If necessary) identification of pen by touching, ask what is this?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="identificationOfPen" name="identificationOfPen" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="identificationOfPen" name="identificationOfPen" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">16.</td>
      <td colspan="2" align="left">Now I am going to say something, listen carefully and repeat it exactly as I say after I finish.</td>
      <td rowspan="2" align="right">1</td>
      <td rowspan="2" align="center"><input type="radio" id="repeatItExactly" name="repeatItExactly" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td rowspan="2" align="right">0</td>
      <td rowspan="2" align="center"><input type="radio" id="repeatItExactly" name="repeatItExactly" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">Phrase:<strong> 'NEITHER THIS NOR THAT'</strong></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">17.</td>
      <td colspan="2" align="left">Now look at my face and do exactly what I do.</td>
      <td rowspan="2" align="right">1</td>
      <td rowspan="2" align="center"><input type="radio" id="doExactly" name="doExactly" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td rowspan="2" align="right">0</td>
      <td rowspan="2" align="center"><input type="radio" id="doExactly" name="doExactly" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left"><strong>Close your eyes</strong></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">18.</td>
      <td colspan="2" align="left">Show a piece of paper and instruct.</td>
      <td rowspan="2" align="right">1</td>
      <td rowspan="2" align="center"><input type="radio" id="paperAndInstruct" name="paperAndInstruct" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td rowspan="2" align="right">0</td>
      <td rowspan="2" align="center"><input type="radio" id="paperAndInstruct" name="paperAndInstruct" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">First you take the paper in your right hand, then with your both hands, fold it in to half once and then given the paper back to me.</td>
    </tr>
    <tr>
      <td rowspan="3" align="center">19.</td>
      <td colspan="2" align="left">Now say a line about your house? (Something specifically about your house)</td>
      <td rowspan="3" align="center">1</td>
      <td rowspan="3" align="right"><input type="radio" id="aboutYourHouse" name="aboutYourHouse" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" ></td>
      <td rowspan="3" align="center">0</td>
      <td rowspan="3" align="center"><input type="radio" id="aboutYourHouse" name="aboutYourHouse" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcMiddleTable(this.value)" checked></td>
    </tr>
    <tr>
      <td colspan="2" align="left">Not included in HMSE Total</td>
    </tr>
    <tr>
      <td colspan="2" align="left"><strong>If given-1, Not given-0</strong></td>
    </tr>
    <tr>
      <td rowspan="2" align="center">20.</td>
      <td colspan="6" align="left">Here is a drawing, you must copy this drawing</td>
    </tr>
    <tr>
      <td colspan="6" align="left">Exactly as shown in the space provided here</td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td colspan="6" align="left"><strong>SCORE:</strong></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td colspan="5" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Must draw two four sided figure = 1</td>
      <td align="center"><input id="twoFourSidedFigure" onchange="calMiddleTabChkBox(this.value,this)" class="checkboxMargin" type="checkbox" value="1"  tabindex="1" name="twoFourSidedFigure"></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td colspan="5" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; One figure should be mostly inside the other = 2</td>
      <td align="center"><input id="mostlyInsideTheDoor" onchange="calMiddleTabChkBox(this.value,this)" class="checkboxMargin" value="2" type="checkbox" onclick="" tabindex="1" name="mostlyInsideTheDoor"></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td colspan="5" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Orientation of the figures should be obviously appropriate = 3</td>
      <td align="center"><input id="obviouslyAppropriate" onchange="calMiddleTabChkBox(this.value,this)" class="checkboxMargin" type="checkbox" value="3" tabindex="1" name="obviouslyAppropriate"></td>
    </tr>
  </table>
  <div class="clear"></div>
  <label>Total Score</label>
  <input type="hidden" id="txtMiddleTableTotalZeros" name="txtMiddleTableTotalZeros" value="18" />
  <input type="text" id="txtMiddleTableTotal" name="txtMiddleTableTotal" value="0" />
  
  <div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="paddingTop5"></div>
  <div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="clear"></div>
    <div>

 <h4 style="cursor:pointer;" onclick="popwindowResultEntryForDermotology('<%=hinId%>@@@<%=visitId%>@@@<%=templateName%>');">External Lab Report Entry</h4>
	</div>
   <div class="clear"></div>
  <h2>GERIATRIC DEPRESSION SCALE</h2>
  <div class="clear"></div>
  <h4>Choose the best answer for how you felt the past week</h4>
  <div class="clear"></div>

<table border="0" cellpadding="5" cellspacing="0" class="tablestylePadding" style="width:890px!important;">
    <tr>
      <td width="38" colspan="3" align="center">&nbsp;</td>
      <td colspan="2" align="center"><strong>Yes</strong></td>
      <td colspan="2" align="center"><strong>No</strong></td>
    </tr>
    <tr>
      <td width="38" align="center">1.</td>
      <td colspan="2" align="left">Are you basically satisfy with your life?</td>
      <td width="33" align="right">0</td>
      <td width="35" align="center"><input type="radio" id="satisfieyWithYourLife" name="satisfieyWithYourLife" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td width="37" align="right">1</td>
      <td width="41" align="center"><input type="radio" id="satisfieyWithYourLife" name="satisfieyWithYourLife" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">2.</td>
      <td colspan="2" align="left">Have you dropped many of your activities and interests?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="activitiesAndInterests" name="activitiesAndInterests" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="activitiesAndInterests" name="activitiesAndInterests" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">3.</td>
      <td colspan="2" align="left">Do you feel that your life is empty?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="lifeIsEmpty" name="lifeIsEmpty" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="lifeIsEmpty" name="lifeIsEmpty" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">4.</td>
      <td colspan="2" align="left">Do you often get bored?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="oftenGetBored" name="oftenGetBored" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="oftenGetBored" name="oftenGetBored" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">5.</td>
      <td colspan="2" align="left">Are you hopeful about the future?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="aboutTheFuture" name="aboutTheFuture" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="aboutTheFuture" name="aboutTheFuture" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">6.</td>
      <td colspan="2" align="left">Are you bothered by thoughts you can't get out of your head?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="getOutOfYourHead" name="getOutOfYourHead" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="getOutOfYourHead" name="getOutOfYourHead" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">7.</td>
      <td colspan="2" align="left">Are you in good spirits most of the time?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="godSpirits" name="godSpirits" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="godSpirits" name="godSpirits" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">8.</td>
      <td colspan="2" align="left">Are you afraid that something bad is going to happen to you?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="somethingBadIsGoing" name="somethingBadIsGoing" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="somethingBadIsGoing" name="somethingBadIsGoing" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">9.</td>
      <td colspan="2" align="left">Do you feel happy most of the time?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="feelHappyMostOfTheTime" name="feelHappyMostOfTheTime" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="feelHappyMostOfTheTime" name="feelHappyMostOfTheTime" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">10.</td>
      <td colspan="2" align="left">Do you often feel helpless?</td>
      <td width="33" align="right">1</td>
      <td width="35" align="center"><input type="radio" id="feelHelpless" name="feelHelpless" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td width="37" align="right">0</td>
      <td width="41" align="center"><input type="radio" id="feelHelpless" name="feelHelpless" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">11.</td>
      <td colspan="2" align="left">Do you often get restless and fidgety?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id=restlessAndFidgety"" name="restlessAndFidgety" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="restlessAndFidgety" name="restlessAndFidgety" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">12.</td>
      <td colspan="2" align="left">Do you prefer to stay at home, rather than going out and doing new things?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="doingNewThings" name="doingNewThings" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="doingNewThings" name="doingNewThings" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">13.</td>
      <td colspan="2" align="left">Do you frequently worry about the future?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="worryaboutTheFuture" name="worryaboutTheFuture" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="worryaboutTheFuture" name="worryaboutTheFuture" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">14.</td>
      <td colspan="2" align="left">Do you feel you have more problems with memory than most?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="problemsWithMemory" name="problemsWithMemory" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="problemsWithMemory" name="problemsWithMemory" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">15.</td>
      <td colspan="2" align="left">Do you think it is wonderful to be alive now?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="aliveNow" name="aliveNow" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="aliveNow" name="aliveNow" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">16.</td>
      <td colspan="2" align="left">Do you often feel downhearted and blue?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="feelDownhearted" name="feelDownhearted" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="feelDownhearted" name="feelDownhearted" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">17.</td>
      <td colspan="2" align="left">Do you feel pretty worthless the way you are now?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="prettyWorthless" name="prettyWorthless" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="prettyWorthless" name="prettyWorthless" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">18.</td>
      <td colspan="2" align="left">Do you worry a lot about the past?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="aboutThePast" name="aboutThePast" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="aboutThePast" name="aboutThePast" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">19.</td>
      <td colspan="2" align="left">Do you find life very exciting?</td>
      <td width="33" align="right">0</td>
      <td width="35" align="center"><input type="radio" id="lifeVeryExciting" name="lifeVeryExciting" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td width="37" align="right">1</td>
      <td width="41" align="center"><input type="radio" id="lifeVeryExciting" name="lifeVeryExciting" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">20.</td>
      <td colspan="2" align="left">Is it hard for you to get started on new projects?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="newProjects" name="newProjects" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="newProjects" name="newProjects" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">21.</td>
      <td colspan="2" align="left">Do you feel full of energy?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="fullOfEnergy" name="fullOfEnergy" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="fullOfEnergy" name="fullOfEnergy" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">22.</td>
      <td colspan="2" align="left">Do you feel that your situation is hopeless?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="situationIsHopeless" name="situationIsHopeless" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="situationIsHopeless" name="situationIsHopeless" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">23.</td>
      <td colspan="2" align="left">Do you think that most people are better off than you are?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="mostPeople" name="mostPeople" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="mostPeople" name="mostPeople" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">24.</td>
      <td colspan="2" align="left">Do you frequently get upset over little things?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="littleThings" name="littleThings" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="littleThings" name="littleThings" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">25.</td>
      <td colspan="2" align="left">Do you frequently feel like crying?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="crying" name="crying" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="crying" name="crying" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">26.</td>
      <td colspan="2" align="left">Do you have trouble concentrating?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="troubleConcentrating" name="troubleConcentrating" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="troubleConcentrating" name="troubleConcentrating" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">27.</td>
      <td colspan="2" align="left">Do you enjoy getting up in the morning?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="enjoyGettingUp" name="enjoyGettingUp" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="enjoyGettingUp" name="enjoyGettingUp" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">28.</td>
      <td colspan="2" align="left">Do you prefer to avoid social gatherings?</td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="socialGathering" name="socialGathering" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="socialGathering" name="socialGathering" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">29.</td>
      <td colspan="2" align="left">Is it easy for you to make decisions?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="makeDecisions" name="makeDecisions" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="makeDecisions" name="makeDecisions" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
    <tr>
      <td align="center">30.</td>
      <td colspan="2" align="left">Is your mind as clear as it use to be?</td>
      <td align="right">0</td>
      <td align="center"><input type="radio" id="mindAsClear" name="mindAsClear" value="0"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" ></td>
      <td align="right">1</td>
      <td align="center"><input type="radio" id="mindAsClear" name="mindAsClear" value="1"  tabindex="1" class="radiobutMargin"  onclick="calcLastTable(this.value)" checked></td>
    </tr>
  </table>
  <div class="clear"></div>
<div class="paddingTop5"></div> 
<div class="paddingTop5"></div> 
<div class="clear"></div>

<h4 style="color:#000;">Total Score</h4>
<div class="clear"></div>



<!-- <input type="hidden" name="totalScore" id="totalScore" maxlength="2" validate="Total Score,int,no" value="10"> -->


<label class="widthAuto">0</label>
<input type="text" id="totZeros" name="totZeros" maxlength="2" validate="Total Score,int,no" value="20">
<!-- <input type="text" name="totalScoreZero" id="totalScoreZero" onkeypress="javascript:return isNumber(event)" size="20" value="3" tabindex="1" validate="Total Score,metachar,no" maxlength="2"> -->

<label>1</label>
<!-- <input type="text" name="totalScoreOne"  id="totalScoreOne" onkeypress="javascript:return isNumber(event)" size="20"  value="9" tabindex="1" validate="Total Score,metachar,no" maxlength="2"> -->
<input type="text" name="totalScore" id="totalScore" maxlength="2" validate="Total Score,int,no" value="10">


<div class="clear"></div>

<!-- <label class="auto">Deferred Diagnosis</label>
<textarea name="txtDeferredlDiag"  class="auto"id="txtDeferredDiag" style="margin-left: 5px; margin-right: 5px; width: 158px;height: 47px" maxlength="256"></textarea>

<label class="auto">Provisional Diagnosis</label>
<textarea name="txtProvisionalDiag" id="txtProvisionalDiag" style="margin-left: 5px; margin-right: 5px; width: 180px;;height: 47px" maxlength="256"></textarea>

<label class="auto">Final Diagnosis</label>
<textarea name="txtFinalDiag" id="txtFinalDiag" style="margin-left: 5px; margin-right: 5px; width: 170px;;height: 47px" maxlength="256"></textarea> --> 
<div class="clear"></div>
<div class="paddingTop5"></div>   
<div class="clear"></div>
	
</div>
</div>
</form>