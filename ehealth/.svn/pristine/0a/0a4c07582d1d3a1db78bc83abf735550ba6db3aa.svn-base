<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
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
		List<MasQualification> educationList=new ArrayList<MasQualification>();
		if(map.get("educationList") != null)
	      {
	    	  educationList = (List<MasQualification>)map.get("educationList");
	      }
		List<MasReligion> religionList=new ArrayList<MasReligion>();
		if(map.get("religionList") != null)
	       {
	               religionList = (List<MasReligion>)map.get("religionList");
	       }
		%>



<form method="post" action="" name="dedd" >
<div class="Block" style="padding-top:0px;">
<h6>General Adult Psychiatry Case Record</h6>
<div class="clear"></div>
<input id="generalPsychiatricCaseRecordFlag" name="generalPsychiatricCaseRecordFlag" tabindex="1" value="General Adult Psychiatry Case Record" type="hidden"  />
<input type="hidden" name="templateName" value="General Adult Psychiatry Case Record"/>
<div class="clear"></div>
<h4>Source of Referral</h4>

<label class="medium">Self
<input type="checkbox" value="Yes" class="checkboxMargin" name="self"> 
</label>

<label>Brought by Relatives
<input type="checkbox" value="Yes" class="checkboxMargin" name="broughtByRelatives">
</label>

<label class="medium">Court
<input type="checkbox" value="Yes" class="checkboxMargin" name="court"> 
</label>

<label class="auto">Medical College Hospital
<input type="checkbox" value="Yes" class="checkboxMargin" name="medicalCollegeHospital">
</label>

<label class="medium">Others
<input type="checkbox" value="Yes" class="checkboxMargin" name="othersSourceOfReferral"  id="othersSourceOfReferral"  onclick="displayTextValue(this.value,'OthersSourceOfReferral');">
</label>

<input type="text" value="" id="othersSourceOfReferralDiv" name="othersSourceOfReferralDiv" validate="OthersSource Of Referral,metachar,no" maxlength="128" style="display: none;">

<div class="clear"></div>
<label>Marital Status</label>
<select name="masMaritalStatusId" id="masMaritalStatusId"   tabindex="1" >
								<option value="0">Select</option>
								<%for(MasMaritalStatus masMaritalStatus:masMaritalStatusList){ %>
								<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName() %></option>
								<%} %>
</select>

<label>Education</label> 
<select name="educationId"  id="educationId" >
			<option value=" ">Select</option>
			<% for(MasQualification education: educationList){ %>
			<option value="<%=education.getId()%>"><%=education.getQualificationName() %></option>
			<%}
			
			%>
</select>
<div class="clear"></div>	
<label> Language </label>
<input type="text" value="" name="lanuage" validate="Language,metachar,no" maxlength="128">


<label> Religion </label>
<select name="masReligionId" id="masReligionId"    tabindex="1" >
								<option value="0">Select</option>
								<%for(MasReligion masReligion:religionList){ %>
								<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName() %></option>
								<%} %>
</select>
<div class="clear"></div>
<label> Informant </label>
<input type="text" value="" name="informant" validate="Informant,metachar,no" maxlength="128">

<label class="heightAuto"> Relationship,Reliability & Competency</label>
<input type="text" value="" name="rrc" validate="Relationship,Reliability and Competency ,metachar,no" maxlength="128">


<div class="clear"></div>
<label> Presenting complaints </label>
<textarea rows="" cols="" name="presentingCompliments"  maxlength="256" class="textareaMediua historyAutoComplete"></textarea>


<h4>Cours of Disorder</h4> 

<label> Total Duration </label>
<input type="text" value="" name="totalDuration" validate="Total Duration,int,no" maxlength="5" onkeypress="javascript:return isNumber(event)" >
 
<label> Episodic Type </label>
<select id="episodicType" name="episodicType" tabindex="1"  validate="Service Center,string,no" onchange="checkEpisodicType(this.value);">
<option value="">Select</option>
<option value="Episodic">Episodic</option>
<option value="Continuous">Continuous</option>
<option value="Continuous with Relapses & Remission">Continuous with Relapses & Remission</option>
<option value="Not Known">Not Known</option>
<option value="Others">Others</option>
</select>
<input value="" name="episodicTypeValue"  id="episodicTypeValue"  maxlength="128" type="text" style="display:none; width:180px;" >

<div class="clear"></div>

<label> Number of Episodes </label>
<input type="text" value="" name="numberOfEpisodes" validate="Number of Episodes,int,no" maxlength="5" onkeypress="javascript:return isNumber(event)" class="historyAutoComplete">

<label> Age of onset </label>
<input type="text" value="" name="ageOfOnset" validate="Age of onset ,int,no" maxlength="5" onkeypress="javascript:return isNumber(event)" >
<div class="clear"></div>

<h4>History of Presenting Illness</h4> 

<label class="heightAuto historyAutoComplete">Continuous with relapses & remissions</label>
<input type="checkbox" value="Yes" class="checkboxMargin" name="cwrar">

<label>Not Known</label>
<input type="checkbox" value="Yes" class="checkboxMargin" name="notKnow" id="notKnow"  onclick="displayTextValue(this.value,'checkNoKnow');">


<div id="noKnowVal"  style="display: none" >
<label style="width:133px;">Onset</label>
<select name="onset" id="onset">
<option value=""> Select </option>
<option value="Acute(within hours)"> Acute(within hours) </option>
<option value="Sub Acute(Days to few weeks)"> Sub Acute(Days to few weeks) </option>
<option value="Gradual(weeks to months)"> Gradual(weeks to months) </option>
</select>
<div class="clear"></div>
</div>

<label>Precipitation events if any</label>
<label class="auto">Yes
<input type="radio" name="precipitation" class="checkboxMargin" id="precipitation" value="Yes"  onclick="displayTextValue(this.value,'Precipitation');"/> 
</label>
<label class="auto">No
<input type="radio" name="precipitation" class="checkboxMargin" id="precipitation"  value="No" onclick="displayTextValue(this.value,'Precipitation');"/>
</label>

<div id="precipitationSpecifyDiv"   style="display: none" >
<label> Specify </label>
<input type="text" maxlength="128" value="" name="precipitationSpecify" id="precipitationSpecify" >
</div>

<div class="clear"></div>
<label> Progress of Symptoms </label>
<textarea onkeyup="return checkLength(this)" class="opdMainTextArea historyAutoComplete" name="progressOfSymptoms" 	id="progressOfSymptoms" maxlength="256" class="historyAutoComplete"> </textarea>

<h4>Symptom Checklist </h4>

<label> Cognitive  Symptoms </label>
  <label class="auto">Absent</label>
<input type="radio" name="congitiveSymptoms" class="radioCheckCol2" id="congitiveSymptoms" value="Absent"  onclick="displayTextValue(this.value,'CongitiveSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="congitiveSymptoms" class="radioCheckCol2" id="congitiveSymptoms"  value="Present" onclick="displayTextValue(this.value,'CongitiveSymptoms');"/>


<div id="congitiveSymptomsVal" style="display: none" >

<div class="clear"></div>
<label>Onset</label>
<input type="checkbox" value="Yes" class="checkboxMargin" name="onsetCongitiveSymptoms" id="onsetCongitiveSymptoms"   onclick="displayTextValue(this.value,'OnsetCongitiveSymptoms');">

<div id="onsetCongitiveSymptomsVal"   style="display: none" >
<label class="heightAuto">Over short period of time(hours to days)</label>
<input type="checkbox" value="Yes" name="overShort" id="overShort" class="checkboxMargin">

<label>Gradual</label>
<input type="checkbox" value="Yes" name="gradual"  id="gradual" class="checkboxMargin">
<div class="clear"></div>
</div>

<label>Distrurbed Consciousness</label>
<input type="checkbox" value="Yes" name="distrurbedConsciousness" id="distrurbedConsciousness" class="checkboxMargin"  onclick="displayTextValue(this.value,'DistrurbedConsciousness');">

<div id="distrurbedConsciousnessVal"   style="display: none" >
<label class="heightAuto">Reduced clarity of awareness of environment</label>
<input type="checkbox" value="Yes" name="rcoaoe" id="rcoaoe" class="checkboxMargin">

<label class="heightAuto">Impaired attention and concentration</label>
<input type="checkbox" value="Yes" name="iaac"  id="iaac" class="checkboxMargin">
</div>

<div class="clear"></div>
<label>Perceptual disturbance</label>
<input type="checkbox" value="Yes" name="perceptualDisturbance" class="checkboxMargin">
<label class="heightAuto">Flucturtaion during the course of day</label>
<input type="checkbox" value="Yes" name="fdtcod" class="checkboxMargin">

<label>Memory Impairment</label>
<input type="checkbox" value="Yes" name="memoryImpairment" class="checkboxMargin">
<label>Aphasia</label>
<input type="checkbox" value="Yes" name="aphasia" class="checkboxMargin">
<div class="clear"></div>
<label>Aphraxia</label>
<input type="checkbox" value="Yes" name="aphraxia" class="checkboxMargin">

<label>Agnosia</label>
<input type="checkbox" value="Yes" name="agnosia" class="checkboxMargin">

<label class="heightAuto">Disturbed executive functioning</label>
<input type="checkbox" value="Yes" name="def" class="checkboxMargin">
<label>Disorientation</label>
<input type="checkbox" value="Yes" name="disorientation" class="checkboxMargin">

</div>

<div class="clear"></div>
<label>Psychotic Symptoms</label>
<label class="auto">Absent</label>
<input type="radio" name="psychoticSymptoms" class="radioCheckCol2" id="congitiveSymptoms" value="Absent"  onclick="displayTextValue(this.value,'PsychoticSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="psychoticSymptoms" class="radioCheckCol2" id="congitiveSymptoms"  value="Present" onclick="displayTextValue(this.value,'PsychoticSymptoms');"/>

<div id="psychoticSymptomsVal" style="display: none" >
<div class="clear"></div>
<label>Suspiciousness</label>
<input type="checkbox" value="Yes" name="suspiciousness" class="checkboxMargin">

<label>Delusional behaviour</label>
<input type="checkbox" value="Yes" name="delusionalBehaviour" class="checkboxMargin">

<label>Hallucinatory behaviour</label>
<input type="checkbox" value="Yes" name="hallucinatoryBehaviour" class="checkboxMargin">

<label>Disorganised speech</label>
<input type="checkbox" value="Yes" name="disorganisedSpeech" class="checkboxMargin">
<div class="clear"></div>

<label>Disorganised behaviour</label>
<input type="checkbox" value="Yes" name="disorganisedBehaviour" class="checkboxMargin">

<label>Catatonic behaviour</label>
<input type="checkbox" value="Yes" name="catatonicBehaviour" class="checkboxMargin">

<label>Social withdrawal</label>
<input type="checkbox" value="Yes" name="socialWithdrawal" class="checkboxMargin">

<label>Emotional blunting</label>
<input type="checkbox" value="Yes" name="emotionalBlunting" class="checkboxMargin">
</div>

<div class="clear"></div>
<label>Manic Symptoms</label>
<label class="auto">Absent</label>
<input type="radio" name="manicSymptoms" class="radioCheckCol2" id="manicSymptoms" value="Absent"  onclick="displayTextValue(this.value,'ManicSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="manicSymptoms" class="radioCheckCol2" id="manicSymptoms"  value="Present" onclick="displayTextValue(this.value,'ManicSymptoms');"/>

<div id="manicSymptomsVal" style="display: none" >
<div class="clear"></div>
<label class="heightAuto">Elevated, expansive or irritable mood</label>
<input type="checkbox" value="Yes" name="eeoim" class="checkboxMargin">

<label>Deceased need for sleep</label>
<input type="checkbox" value="Yes" name="dnfs" class="checkboxMargin">
<label>Grandiose behaviour</label>
<input type="checkbox" value="Yes" name="grandioseBehaviour" class="checkboxMargin">
<label class="heightAuto">Overtalkativeness / Pressure to keep talking</label>
<input type="checkbox" value="Yes" name="optkt" class="checkboxMargin">
<div class="clear"></div>
<label>Overactivity</label>
<input type="checkbox" value="Yes" name="overactivity" class="checkboxMargin">

<label class="heightAuto">Excessive indulgence  in pleasurable activities</label>
<input type="checkbox" value="Yes" name="eiiip" class="checkboxMargin">
<label>Rapid switches in mood</label>
<input type="checkbox" value="Yes" name="rsim" class="checkboxMargin">
</div>

<div class="clear"></div>
<label> Depressive Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="depressiveSymptoms" class="radioCheckCol2" id="depressiveSymptoms" value="Absent"  onclick="displayTextValue(this.value,'DepressiveSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="depressiveSymptoms" class="radioCheckCol2" id="depressiveSymptoms"  value="Present" onclick="displayTextValue(this.value,'DepressiveSymptoms');"/>


<div id="depressiveSymptomsVal" style="display: none" >
<div class="clear"></div>
<label class="heightAuto">Subjective or objective report of depressed mood</label>
<input type="checkbox" value="Yes" name="soorodm" class="checkboxMargin">

<label class="heightAuto">Loss of interest or enjoyment</label>
<input type="checkbox" value="Yes" name="loioe" class="checkboxMargin">

<label class="heightAuto">Significant loss of weight/gain in weight</label>
<input type="checkbox" value="Yes" name="slowgiw" class="checkboxMargin">

<label>Insomia or hypersomnia</label>
<input type="checkbox" value="Yes" name="ioh" class="checkboxMargin">
<div class="clear"></div>
<label class="heightAuto">Psychomotor agitation or retardation</label>
<input type="checkbox" value="Yes" name="paor" class="checkboxMargin">

<label>Loss of engergy/fatigue</label>
<input type="checkbox" value="Yes" name="loef" class="checkboxMargin">

<label>Worthlessness/guilt</label>
<input type="checkbox" value="Yes" name="wg" class="checkboxMargin">

<label class="heightAuto">Lack of concentration of indecisiveness</label>
<input type="checkbox" value="Yes" name="locoi" class="checkboxMargin">

<div class="clear"></div>
<label>Delusional</label>
<input type="checkbox" value="Yes" id="delusional"  name="delusional" class="checkboxMargin" onclick="displayTextValue(this.value,'Delusional');"  >
<div id="delusionalValDiv"   style="display: none" >
<label class="auto">Yes</label>
<input type="radio" name="delusionalVal" class="radioCheckCol2" id="delusionalVal" value="Yes"  />
<label class="auto">No</label>
<input type="radio" name="delusionalVal" class="radioCheckCol2" id="delusionalVal" value="No" />
</div>

<label>Suicidal behaviour</label>
<input type="checkbox" value="Yes" name="suicidalBehaviour" class="checkboxMargin">
</div>



<div class="clear"></div>
<label> Anxiety Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="anxietySymptoms" class="radioCheckCol2" id="anxietySymptoms" value="Absent"  onclick="displayTextValue(this.value,'AnxietySymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="anxietySymptoms" class="radioCheckCol2" id="anxietySymptoms"  value="Present" onclick="displayTextValue(this.value,'AnxietySymptoms');"/>

<div id="anxietySymptomsDiv"   style="display: none" >
<label>Specify </label>
<input type="text" value="" name="anxietySymptomsVal" id="anxietySymptomsVal" maxlength="128">
</div>

<div class="clear"></div>
<label class="heightAuto"> Sexual and Gender Identity Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="sagis" class="radioCheckCol2" id="sagis" value="Absent"  onclick="displayTextValue(this.value,'Sagis');"/>
<label class="auto">Present</label>
<input type="radio" name="sagis" class="radioCheckCol2" id="sagis"  value="Present" onclick="displayTextValue(this.value,'Sagis');"/>


<div id="sagisDiv"   style="display: none" >
<label> Specify </label>
<input type="text" value="" name="sagisVal" id="sagisVal" maxlength="128">
</div>

<div class="clear"></div>
<label> Eating Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="eatingSymptoms" class="radioCheckCol2" id="eatingSymptoms" value="Absent"  onclick="displayTextValue(this.value,'EatingSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="eatingSymptoms" class="radioCheckCol2" id="eatingSymptoms"  value="Present" onclick="displayTextValue(this.value,'EatingSymptoms');"/>

<div id="eatingSymptomsDiv"   style="display: none" >
<label> Specify </label>
<input type="text" value="" name="eatingSymptomsVal" id="eatingSymptomsVal" maxlength="128">
</div>

<div class="clear"></div>
<label> Sleep Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="sleepSymptoms" class="radioCheckCol2" id="sleepSymptoms" value="Absent"  onclick="displayTextValue(this.value,'SleepSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="sleepSymptoms" class="radioCheckCol2" id="sleepSymptoms"  value="Present" onclick="displayTextValue(this.value,'SleepSymptoms');"/>

<div id="sleepSymptomsDiv" style="display: none" >
<label> Specify </label>
<input type="text" value="" name="sleepSymptomsVal" id="sleepSymptomsVal" maxlength="128">
</div>


<div class="clear"></div>
<label class="heightAuto">Impulse Dyscontrol Symptoms </label>
<label class="auto">Absent</label>
<input type="radio" name="impulseDyscontrolSymptoms" class="radioCheckCol2" id="impulseDyscontrolSymptoms" value="Absent"  onclick="displayTextValue(this.value,'ImpulseDyscontrolSymptoms');"/>
<label class="auto">Present</label>
<input type="radio" name="impulseDyscontrolSymptoms" class="radioCheckCol2" id="impulseDyscontrolSymptoms"  value="Present" onclick="displayTextValue(this.value,'ImpulseDyscontrolSymptoms');"/>

<div id="impulseDyscontrolSymptomsDiv" style="display:none" >
<label class="medium"> Specify </label>
<input type="text" value="" name="impulseDyscontrolSymptomsVal" id="impulseDyscontrolSymptomsVal" maxlength="128" />
<label class="medium"> Future Details </label>
<input type="text" value="" name="futureDetailsVal" id="futureDetailsVal" maxlength="128" style="width:178px;" />
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h6>Problems Requiring Special Attention</h6>
<h4>Potential for injury to self/others </h4>

<label class="medium">Suicidal
<input type="checkbox" value="Yes" name="suicidal" class="checkboxMargin">
</label>

<label>Self-mutilating
<input type="checkbox" value="Yes" name="selfMutilating" class="checkboxMargin">
</label>

<label class="medium">Violent
<input type="checkbox" value="Yes" name="violent" class="checkboxMargin">
</label>

<label class="medium">Homicidal
<input type="checkbox" value="Yes" name="homicidal" class="checkboxMargin">
</label>

<label class="medium"> Details </label>
<input type="text" value="" name="detailOne" id="detailOne" maxlength="128">


<h4>Current Medications</h4>

<label>Not on medications
<input type="checkbox" value="Yes" name="notOnMedications" class="checkboxMargin">
</label>

<label>On Medications
<input type="checkbox" value="Yes" name="onMedications" class="checkboxMargin">
</label>

<label> Details </label>
<input type="text" value="" name="detailTwo" id="detailTwo" maxlength="128">

<div class="clear"></div>
<label>Degree Of Drug Adherence</label>

<select name="dgreeOfDrugAdherence" class="midium">
<option value="">Select</option>
<option value="Regular">Regular</option>
<option value="Irregular">Irregular</option>
<option value="Poor">Poor</option>
</select>

<label>Past Psychiatric History</label>

<label class="auto">Absent
<input type="radio" name="pastPsychiatricHistory" class="checkboxMargin" id="pastPsychiatricHistory" value="Absent"  onclick="displayTextValue(this.value,'PastPsychiatricHistory');"/>
</label>
<label class="auto">Present
<input type="radio" name="pastPsychiatricHistory" class="checkboxMargin" id="pastPsychiatricHistory"  value="Present" onclick="displayTextValue(this.value,'PastPsychiatricHistory');"/>
</label>

<div id="pastPsychiatricHistoryDiv"   style="display: none" >
<label class="auto"> Details </label>
<input type="text" value="" name="pastPsychiatricHistoryVal" id="pastPsychiatricHistoryVal" maxlength="128" class=" historyAutoComplete"/>
</div>

<div class="clear"></div>

<label class="heightAuto">Past History of Deliberate Self Harm</label>

<label class="auto">Absent
<input type="radio" name="pastHistoryOfDeliberateSelfHarm" class="checkboxMargin" id="pastHistoryOfDeliberateSelfHarm" value="Absent"  onclick="displayTextValue(this.value,'PastHistoryOfDeliberateSelfHarm');"/> 
</label>
<label class="auto">Present
<input type="radio" name="pastHistoryOfDeliberateSelfHarm" class="checkboxMargin" style="margin-right:33px;" id="pastHistoryOfDeliberateSelfHarm"  value="Present" onclick="displayTextValue(this.value,'PastHistoryOfDeliberateSelfHarm');"/>
</label>

<div id="pastHistoryOfDeliberateSelfHarmDiv" style="display: none" >
<label> Pervious attempt</label>
<input type="text" value="" name="perviousAttemptFantasisedSuicide" id="perviousAttemptFantasisedSuicide" maxlength="128" />
<div class="clear"></div>

<label> Impulsive/planned </label>
<input type="text" value="" name="impulsivePlanned" id="impulsivePlanned" maxlength="128" />




<label> Intent </label>

<select name="intentVal" class="midium">
<option value="">Select</option>
<option value="High">High</option>
<option value="Low">Low</option>
</select>
<input type="text" value="" name="manipulativeIntent" id="manipulativeIntent" maxlength="128" />


<label> Circumstances</label>
<input type="text" value="" name="circumstances" id="circumstances" maxlength="128" />
</div>
<div class="clear"></div>

<div style="width:252px; float:left;">
<h4>Past Psychiatric Treatment History</h4>
<p>(Major Medications & side effect,Therpaist/IP/OP)</p>
</div>
<input type="text" value="" name="pastPsychiatricTreatmentHistory" id="pastPsychiatricTreatmentHistory" maxlength="128" />
<div class="clear"></div>

<h4> Medical History</h4>

<label>No known diseases
<input type="checkbox" value="Yes" name="allergiesSensitvities" class="checkboxMargin">
</label>

<label>Allergies / Sensitvities
<input class="checkboxMargin" id="" name="" type="checkbox"> 
</label>
<input type="text" value="" name="allergiesSensitvitiesVal" id="allergiesSensitvitiesVal" maxlength="128" style="margin-left:9px; width:157px" />


<div class="clear"></div>

<label>Seizures</label>
<input type="text" value="" name="seizuresVal" id="seizuresVal" maxlength="128" style="margin-left:24px;" />


<label>Head trauma</label>
<input type="text" value="" name="headTraumaVal" id="headTraumaVal" maxlength="128" class="historyAutoComplete"/>

<div class="clear"></div>
<label class="heightAuto">Non-psychiatric hospitalions/ illnessed/ surgeries</label>
<input type="checkbox" value="Yes" name="nonPsychiatric" class="checkboxMargin">
<input type="text" value="" name="nonPsychiatricVal" id="nonPsychiatricVal" maxlength="128" />

<label>Family History</label>
<input type="text" value="" name="familyHistoryVal" id="familyHistoryVal" maxlength="128" />

<h6>Personal History</h6>

<h4>Prenatal,Perinatal and early development </h4>

<label>Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="ppaed" id="normalPpaed"  />
</label>

<label>Impaired
<input type="radio" name="ppaed" class="checkboxMargin" id="ppaed"  value="Impaired" />
</label>

<label style="width:132px;">Details</label>
<input type="text" value="" name="detailsThree" id="detailsThree" maxlength="128" />

<div class="clear"></div>
<label>Intellectual and congnitive development</label>
<input type="text" value="" name="congnitiveDevelopment" id="congnitiveDevelopment" maxlength="128" />

<label>Motor development</label>
<input type="text" value="" name="motorDevelopment" id="motorDevelopment" maxlength="128" />

<div class="clear"></div>
<label>Behaviour in childhood</label>
<input type="text" value="" name="behaviourChildhood" id="behaviourChildhood" maxlength="128" />

<label>Significant physical illness</label>
<input type="text" value="" name="significantPhysicalillness" id="significantPhysicalillness" maxlength="128" class="historyAutoComplete"/>
<div class="clear"></div>
<label>Education History</label><input type="text" value="" name="educationHistory" id="educationHistory" maxlength="128" class="historyAutoComplete"/>
<div class="clear"></div>
<p>(Period of sschooling,scholastic,performance,relations with teachers and peers,problems if any)</p>
<div class="clear"></div>

<label>Occupational History</label>
<input type="text" value="" name="occupationalHistory" id="occupationalHistory" maxlength="128" class="historyAutoComplete"/>
<div class="clear"></div>
<p>(Age of starting work,jobs held,jobs stresses,problems if any)</p>
<div class="clear"></div>

<label>Sexual History</label>
<input type="text" value="" name="sexualHistory" id="sexualHistory" maxlength="128" class="historyAutoComplete"/>

<label>Menstrual History</label>
<input type="text" value="" name="menstrualHistory" id="menstrualHistory" maxlength="128" class="historyAutoComplete"/>
<div class="clear"></div>
<p>(Age of menarche/menopause,disturbances if any)</p>
<div class="clear"></div>

<label>Social history</label>
<input type="text" value="" name="socialHistory" id="socialHistory" maxlength="128" />
<label class="heightAuto">Marital and relationship history</label>
<input type="text" value="" name="maritalRelationshiphistory" id="maritalRelationshiphistory" maxlength="128" />
<div class="clear"></div>
<p>(Economic status/current living situation/psychosocial stressors)</p>
<div class="clear"></div>

<h4>Substance use History</h4>

<label class="medium">Absent
<input type="radio" name="substanceHistory" class="radioCheckCol2" id="substanceHistory" value="Absent"  onclick="displayTextValue(this.value,'SubstanceHistory');"/>
</label>
<label class="medium">Present
<input type="radio" name="substanceHistory" class="radioCheckCol2" id="substanceHistory"  value="Present" onclick="displayTextValue(this.value,'SubstanceHistory');"/> 
</label>

<div id="substanceHistoryDiv"   style="display: none" >
<label>Substance of Choice</label>
<select name="substanceOfChoice" onchange="displayTextValue(this.value,'SubstanceOfChoiceVal');">
<option value="">Select</option>
<option value="Alcoholo">Alcoholo</option>
<option value="Cannabis">Cannabis</option>
<option value="Opioid">Opioid</option>
<option value="Tobacco">Tobacco</option>
<option value="Benzodiazepinos">Benzodiazepinos</option>
<option value="Others">Others</option>
</select>
<input type="text" value="" id="substanceOfChoiceVal" name="substanceOfChoiceVal" validate="Others -Substance Of Choice ,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>

<label>Age of onset</label>
<input type="text" value="" name="ageOnSet" id="ageOnSet" maxlength="5"  onkeypress="javascript:return isNumber(event)"/>

<label>Current use pattern</label>
<input type="text" value="" name="currentUsePattern" id="currentUsePattern" maxlength="128" />

<div class="clear"></div>
<label>Date of last use</label>
<input type="text" class="date" id="dateOfLastUse"		validate="Date of last use,date,no" value="" name="dateOfLastUse"	 readonly="readonly" MAXLENGTH="30"  /> 
<img src="/hms/jsp/images/cal.gif" 	width="16" height="16" border="0"	onClick="setdate('',document.getElementById('dateOfLastUse'),event);" /> 

<label>Others</label>
<input type="text" value="" name="othersVal" id="othersVal" maxlength="128" />
</div>
<div class="clear"></div>
<h4>Withdrawal symptoms</h4>

<label>Current</label>
<input type="checkbox" value="Yes" name="currentWs"  id="currentWs" class="checkboxMargin" onchange="displayTextValue(this.value,'Current');" >
<input type="text" value="" id="currentWsVal" name="currentWsVal" validate="Current Value ,metachar,no" maxlength="128" style="display: none;">

<label>Past</label>
<input type="checkbox" value="Yes" name="pastWs" class="checkboxMargin" onchange="displayTextValue(this.value,'Past');" id="pastWs">
<input type="text" value="" id="pastWsVal" name="pastWsVal" validate="Past Value,metachar,no" maxlength="128" style="display: none;">

<label>Tolerance</label>
<input type="checkbox" value="Yes" name="tolerance" class="checkboxMargin">

<label>Loss of control/craving</label>
<input type="checkbox" value="Yes" name="locc" class="checkboxMargin">
<div class="clear"></div>

<label>Failed attempts to control</label>
<input type="checkbox" value="Yes" name="fatc" class="checkboxMargin">

<label class="heightAuto">Time spent on drug-related activities</label>
<input type="checkbox" value="Yes" name="tsodra" class="checkboxMargin">


<label class="heightAuto">Important activities given up</label>
<input type="checkbox" value="Yes" name="iagu" class="checkboxMargin">

<label class="heightAuto">Continued use despite problems</label>
<input type="checkbox" value="Yes" name="cudp" class="checkboxMargin">
<div class="clear"></div>

<label class="heightAuto">Fanilure in major role obligations</label>
<input type="checkbox" value="Yes" name="fimro" class="checkboxMargin">

<label>Hazardous use</label>
<input type="checkbox" value="Yes" name="hazardousUse" class="checkboxMargin">


<label class="heightAuto">Substance related legal problem</label>
<input type="checkbox" value="Yes" name="substanceRelatedLegalProblem"  id="substanceRelatedLegalProblem" class="checkboxMargin"  onchange="displayTextValue(this.value,'SubstanceRelatedLegalProblem');" >
<input type="text" value="" id="substanceRelatedLegalProblemVal" name="substanceRelatedLegalProblemVal" validate="Current Value ,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>

<label style="width:280px;">Longest period of abstinence in the past 2 years</label>
<input type="text" value="" id="lpoaitp" name="lpoaitp" validate="Past Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>

<label style="width:280px;">Previous treatment for substance use disorder</label>
  <label class="auto">Yes</label>
<input type="radio" name="ptfsud" class="radioCheckCol2" id="ptfsud" value="Yes"  onchange="displayTextValue(this.value,'ptfsud');"/>
<label class="auto">No</label>
<input type="radio" name="ptfsud" class="radioCheckCol2" id="ptfsud" value="No" onchange="displayTextValue(this.value,'ptfsud');"/>

<input type="text" value="" id="ptfsudVal" name="ptfsudVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>

<label>Premorbid Personality</label>
<input type="text" value="" id="premorbidPersonality" name="premorbidPersonality" validate="Premorbid Personality,metachar,no" maxlength="128">
<div class="clear"></div>
<p>(Describe social and interpersonal relationship, intellectual activitymood, attitude towareds work and responsibility, any others)</>
<div class="clear"></div>

<h4>Abnormal Personality Traits</h4>

<label class="medium">Absent
<input type="radio" name="abnormalPersonality" class="checkboxMargin" id="congitiveSymptoms" value="Absent"  onclick="displayTextValue(this.value,'AbnormalPersonality');"/> 
</label>
<label class="medium">Present
<input type="radio" name="abnormalPersonality" class="checkboxMargin" id="congitiveSymptoms"  value="Present" onclick="displayTextValue(this.value,'AbnormalPersonality');"/> 
</label>

<div id="abnormalPersonalityDiv" style="display: none;">
<div class="clear"></div>
<input type="checkbox" value="Yes" name="pmsamom" class="checkboxMargin">
<label class="auto bg">Perasive mistrust,suspiciousnes and misinterpretation others motives</label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="ppodfsrarroeeiis" class="checkboxMargin">
<label class="auto bg">Perasive pattern of detachment from social relationships and restricted range of emotional expression in interpersonal setting</label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="dwrcapdaeob" class="checkboxMargin">
<label class="auto bg">Discomfort with close relationships, congnitive and perceptive distortions and eccentricities of behaviour</label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="dfavoroo" class="checkboxMargin">
<label class="auto bg">Disregard for and violation of rights of others </label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="iiirsiaaic" class="checkboxMargin">
<label class="auto bg">Instability in interpersonal relationshlip, self-image,affect and impulse control </label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="eeaas" class="checkboxMargin">
<label class="auto bg">Excessive emotionalitiy and attention seeking </label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="gnfaaloe" class="checkboxMargin">
<label class="auto bg">Grandiosity (in fantasy or behaviour), need for admiration and lack of empathy </label>

<div class="clear"></div>
<input type="checkbox" value="Yes" name="sifoiahtne" class="checkboxMargin">
<label class="auto bg">Social inhibition,feeling of inadequacy and hypersensitivity to negative evaluation </label>
<div class="clear"></div>

<input type="checkbox" value="Yes" name="entbtcosacbafos" class="checkboxMargin">
<label class="auto bg">Excessive need to be taken care of,submissive and clinging behaviour and fears of sparation </label>
<div class="clear"></div>
<input type="checkbox" value="Yes" name="pwopamaic" class="checkboxMargin">
<label class="auto bg">Preoccupation with orderliness,perfectionism and mental and interpersonal control</label>

<div class="clear"></div>
</div>

<h6>Mental Status Examination</h6>
<h4> Sensorium</h4>

<label>Level of consiousness</label>

<label class="medium">Alert
<input type="checkbox" value="Yes" name="alertLOC" class="checkboxMargin">
</label>

<label class="medium">Droxsy
<input type="checkbox" value="Yes" name="droxsy" class="checkboxMargin">
</label>

<label class="medium">Stuporose
<input type="checkbox" value="Yes" name="stuporose" class="checkboxMargin">
</label>

<label class="medium">Comatose
<input type="checkbox" value="Yes" name="comatose" class="checkboxMargin">
</label>

<label class="medium">Fluctuating
<input type="checkbox" value="Yes" name="fluctuting" class="checkboxMargin">
</label>

<div class="partLeftDiv">
<h4>Orientation</h4>

<label class="medium">Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="orienation" id="orienation"    onclick="displayTextValue(this.value,'OrienationImpaired');"/>
</label>
<label class="medium">Impaired
<input type="radio" value="Impaired" name="orienation" class="checkboxMargin" id="orienation"    onclick="displayTextValue(this.value,'OrienationImpaired');"/>
</label>
<input type="text" value="" id="orienationImpairedVal" name="orienationImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>

<h4>Time</h4>
<label class="medium">Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="timeVal" id="timeVal"  onclick="displayTextValue(this.value,'TimeImpaired');"/>
</label>
<label class="medium">Impaired
<input type="radio" value="Impaired" name="timeVal" class="checkboxMargin" id="timeVal"    onclick="displayTextValue(this.value,'TimeImpaired');"/>
</label>
<input type="text" value="" id="timeImpairedVal" name="timeImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>
</div>

<div class="partRightDiv">
<h4>Person</h4>

<label class="medium">Normal
<input type="radio" value="Normal"  class="radioCheckCol2" name="person" id="person"  onclick="displayTextValue(this.value,'PersonImpaired');"/>
</label>
<label class="medium">Impaired
<input type="radio" value="Impaired" name="person" class="radioCheckCol2" id="person"    onclick="displayTextValue(this.value,'PersonImpaired');"/>
</label>
<input type="text" value="" id="personImpairedVal" name="personImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>

<h4>Place</h4>

<label class="medium">Normal
<input type="radio" value="Normal"  class="radioCheckCol2" name="place" id="place"   onclick="displayTextValue(this.value,'PlaceImpaired');"/>
</label>
<label class="medium">Impaired
<input type="radio" value="Impaired" name="place" class="radioCheckCol2" id="place"    onclick="displayTextValue(this.value,'PlaceImpaired');"/>
</label>
<input type="text" value="" id="placeImpairedVal" name="placeImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>
</div>
<div class="clear"></div>
 
 <label>Appearance & behaviour</label>
 <input type="text" value="" id="appearanceAndBehaviour" name="appearanceAndBehaviour" validate="Appearance and behaviour,metachar,no" maxlength="128" >
 
<label>Well-groomed
<input type="checkbox" value="Yes" name="wellGroomed" class="checkboxMargin"> 
</label>

<label>Dishevelled
<input type="checkbox" value="Yes" name="dishevelled" class="checkboxMargin"> 
</label>

<label>Bizarre
<input type="checkbox" value="Yes" name="bizzare" class="checkboxMargin">
</label>

<div class="clear"></div>
<label style="width:349px;">Gross physical anomalies/MPA /Involuntary movements</label>
<input type="text" value="" id="gross" name="gross" validate="Appearance and behaviour,metachar,no" maxlength="128" >
<div class="clear"></div>
 
<label>Attitude</label>
<input type="text" value="" id="attitude" name="attitudeTxt" validate="Appearance and behaviour,metachar,no" maxlength="128" >
<div class="clear"></div>

<label class="auto">Co-operative
<input type="checkbox" value="Yes" name="cooperative" class="checkboxMargin"> 
</label>

<label class="auto">Guarded
<input type="checkbox" value="Yes" name="guarded" class="checkboxMargin"> 
</label>

<label class="auto">Indifferent
<input type="checkbox" value="Yes" name="indifferent" class="checkboxMargin"> 
</label>

<label class="auto">Withdrawn/preoccupied
<input type="checkbox" value="Yes" name="withdrawnPreoccupied" class="checkboxMargin">
</label>
<!-- <div class="clear"></div> -->

<label class="auto">Silly
<input type="checkbox" value="Yes" name="silly" class="checkboxMargin">
</label>

<label class="auto">Un co-operative
<input type="checkbox" value="Yes" name="uncooperative" class="checkboxMargin"> 
</label>

<label class="auto">Belligerent/hostile
<input type="checkbox" value="Yes" name="belligerent" class="checkboxMargin">
</label>
<div class="clear"></div>
<div class="paddingTop5"></div>
 
<label>Eye Contact</label>
<select name="eyeContract" class="midium-">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Avoidance">Avoidance</option>
<option value="Decreased">Decreased</option>
</select>

<label>Rapport</label>
<select name="rapport"  class="midium-">
<option value="">Select</option>
<option value="Easily extablished">Easily extablished</option>
<option value="Possible with difficulty">Avoidance</option>
<option value="Poor">Poor</option>
</select>

 <div class="clear"></div>
<label>Psychomotor Activity</label>
 <input type="text" value="" id="psychomotorActivity" name="psychomotorActivity" validate="Psychomotor Activity,metachar,no" maxlength="128" >
<div class="clear"></div>

<label>Normal
<input type="checkbox" value="Yes" name="normalPsychomotorActivity" class="checkboxMargin">
</label>

<label>Increased
<input type="checkbox" value="Yes" name="increasedPsychomotorActivity" class="checkboxMargin">
</label>

<label>Excited
<input type="checkbox" value="Yes" name="excitedPsychomotorActivity" class="checkboxMargin">
</label>

<label>Agitated
<input type="checkbox" value="Yes" name="agitatedPsychomotorActivity" class="checkboxMargin">
</label>

<label class="auto">Disorganised behaviour
<input type="checkbox" value="Yes" name="disorganisedPsychomotorActivity" class="checkboxMargin"> 
</label>
<div class="clear"></div>

<label>Aggressive
<input type="checkbox" value="Yes" name="aggressivePsychomotorActivity" class="checkboxMargin">
</label>

<label>Repetitive acts
<input type="checkbox" value="Yes" name="repetitivePsychomotorActivity" class="checkboxMargin"> 
</label>

<label>Decreased
<input type="checkbox" value="Yes" name="decreasedPsychomotorActivity" class="checkboxMargin"> 
</label>

<label>Catatonic phenomena
<input type="checkbox" value="Yes" name="catatonicPsychomotorActivity" class="checkboxMargin">
</label>

<label>Bradykinesia
<input type="checkbox" value="Yes" name="bradykinesiaPsychomotorActivity" class="checkboxMargin"> 
</label>
<div class="clear"></div> 
 
 <h4>Talk</h4>
 
<label class="medium">Normal
<input type="radio" value="Normal" class="checkboxMargin" name="talk" id="talk"  onclick="displayTextValue(this.value,'TalkImpaired');"/>
</label>

<label class="medium">Impaired
<input type="radio" value="Impaired" name="talk" class="checkboxMargin" id="talk" onclick="displayTextValue(this.value,'TalkImpaired');"/>
</label>
<input type="text" value="" id="talkImpairedVal" name="talkImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">

<label class="auto">Spontaneous/response only to queries
<input type="checkbox" value="Yes" name="srotq" class="checkboxMargin" > 
</label>

<label class="medium">Quantum
<input type="checkbox" value="Yes" name="quantum" class="checkboxMargin">
</label>
<select name="quantumVal" class="midium">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Increased">Increased</option>
<option value="Decreased">Decreased</option>
</select>
<div class="clear"></div>

<h4>Rate</h4>
<label>Increased
<input type="radio" name="rate" class="checkboxMargin" id="rate" value="Increased" /> 
</label>
<label>Decreased
<input type="radio" name="rate" class="checkboxMargin" id="rate"  value="Decreased" />
</label>
<div class="clear"></div>

<h4>Tone</h4>
<label class="medium">High
<input type="radio" name="tone" class="checkboxMargin" id="tone" value="High" />
</label>
<label class="medium">Low
<input type="radio" name="tone" class="checkboxMargin" id="tone"  value="Low" />
</label>
<label class="medium">Mute <input type="checkbox" value="Yes" name="mute"  id="mute" class="checkboxMargin" onclick="displayTextValue(this.value,'Mute');">
</label>
<div id="muteDiv">
<input type="text" value="" id="muteTxt" name="muteTxt" validate="mute Value,metachar,no" maxlength="128" >

<label class="medium">Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="muteVal" id="muteVal" onclick="displayTextValue(this.value,'MuteImpaired');" />
</label>

<label class="medium">Impaired
<input type="radio" value="Impaired" name="muteVal" class="checkboxMargin" id="muteVal" onclick="displayTextValue(this.value,'MuteImpaired');"/>
</label>
<input type="text" value="" id="muteImpairedVal" name="muteImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
</div>
<div class="clear"></div>

<label class="medium">Relevant
<input type="radio" name="muteValOne" class="checkboxMargin" id="muteValOne" value="Relevant" /> 
</label>

<label class="medium">Irrelevant
<input type="radio" name="muteValOne" class="checkboxMargin" id="muteValOne" value="Irrelevant" />
</label>

<label class="medium">Coherent
<input type="radio" name="muteValOne" class="checkboxMargin" id="muteValOne" value="Coherent" />
</label>

<label class="medium">Incoherent
<input type="radio" name="muteValOne" class="checkboxMargin" id="muteValOne"  value="Incoherent" />
</label>

<label class="medium">Yes
<input type="radio" name="muteValYN" class="checkboxMargin" id="muteValYN" value="Yes" />
</label>

<label class="medium">No
<input type="radio" name="muteValYN" class="checkboxMargin" id="muteValYN"  value="No" /> 
</label>

<select name="muteValNID" class="midium">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Increased">Increased</option>
<option value="Decreased">Decreased</option>
</select>
<div class="clear"></div>

<h6>Thought</h6>
<h4>Stream and form</h4>
<label> Normal</label> <input type="checkbox" value="Yes" name="streamAndFormNormal" class="checkboxMargin">
<label> Lossening of association</label> <input type="checkbox" value="Yes" name="streamAndFormLossening" class="checkboxMargin">
<label> Flight of ideas</label> <input type="checkbox" value="Yes" name="streamAndFormFlight" class="checkboxMargin">
<label> Circumstantiality</label> <input type="checkbox" value="Yes" name="streamAndFormCircumstantiality" class="checkboxMargin">
<label> Wor salad(incoherence)</label> <input type="checkbox" value="Yes" name="streamAndFormWor" class="checkboxMargin">
<label> Neologism</label> <input type="checkbox" value="Yes" name="streamAndFormNeologism" class="checkboxMargin">
<label> Perseveration</label> <input type="checkbox" value="Yes" name="streamAndFormPerseveration" class="checkboxMargin">
<label>Poverty of ideas</label> <input type="checkbox" value="Yes" name="streamAndFormPoverty" class="checkboxMargin">
<label> Thought block</label> <input type="checkbox" value="Yes" name="streamAndFormThought" class="checkboxMargin">
<label> Incompleted sentences</label> <input type="checkbox" value="Yes" name="streamAndFormIncompleted" class="checkboxMargin">
<label> Pressure of speech</label> <input type="checkbox" value="Yes" name="streamAndFormPressure" class="checkboxMargin">
<label> Vagueness</label> <input type="checkbox" value="Yes" name="streamAndFormVagueness" class="checkboxMargin">
<label> Thought sample</label>
<input type="text" value="" id="thoughtSample" name="thoughtSample" validate="ptfsudVal Value,metachar,no" maxlength="128">

<div class="clear"></div>
<h4>Thought content </h4>
<h4> Preoccupations</h4>
<label>None</label> <input type="checkbox" value="Yes" name="preoccupationsNone" class="checkboxMargin">
<label> Religiosity</label> <input type="checkbox" value="Yes" name="preoccupationsReligiosity" class="checkboxMargin">
<label> Somatic</label> <input type="checkbox" value="Yes" name="preoccupationsSomatic" class="checkboxMargin">
<label> Hypochondriacal</label> <input type="checkbox" value="Yes" name="preoccupationsHypochondriacal" class="checkboxMargin">
<label> Hopelessness</label> <input type="checkbox" value="Yes" name="preoccupationsHopelessness" class="checkboxMargin">
<label> Worthlessness</label> <input type="checkbox" value="Yes" name="preoccupationsWorthlessness" class="checkboxMargin">
<label> Guilt</label> <input type="checkbox" value="Yes" name="preoccupationsGuilt" class="checkboxMargin">
<label> Ideas of reference</label> <input type="checkbox" value="Yes" name="preoccupationsIdeas" class="checkboxMargin">
<label> Other</label> <input type="checkbox" value="Yes" name="preoccupationsOther" class="checkboxMargin">
<input type="text" value="" id="preoccupationsOtherVal" name="preoccupationsOtherVal" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<h4>Suicidal thoughts</h4>

<label class="medium">Absent
<input type="radio" name="suicidalAP" class="checkboxMargin" id="suicidalAP" value="Absent"  onclick="displayTextValue(this.value,'Suicidal');"/>
</label>

<label class="medium">Present
<input type="radio" name="suicidalAP" class="checkboxMargin" id="suicidalAP"  value="Present" onclick="displayTextValue(this.value,'Suicidal');"/>
</label>

<label class="medium">No plan
<input type="radio" name="suicidalNP" class="checkboxMargin" id="suicidalNP" value="No plan"  onclick="displayTextValue(this.value,'Suicidal');"/>
</label>

<label class="medium">Plan
<input type="radio" name="suicidalNP" class="checkboxMargin" id="suicidalNP"  value="Plan" onclick="displayTextValue(this.value,'Suicidal');"/>
</label>
<input type="text" value="" id="suicidalOther" name="suicidalOther" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display:none; ">  
  
  
<div class="clear"></div>
<h4>Homicidal thoughts</h4>

<label class="medium">Absent
<input type="radio" name="homicidalAP" class="checkboxMargin" id="homicidalAP" value="Absent" onclick="displayTextValue(this.value,'Homicidal');"/>
</label>

<label class="medium">Present
<input type="radio" name="homicidalAP" class="checkboxMargin" id="homicidalAP"  value="Present"  onclick="displayTextValue(this.value,'Homicidal');"/>
</label>

<label class="medium">No plan
<input type="radio" name="homicidalNP" class="checkboxMargin" id="homicidalNP" value="No plan"  onclick="displayTextValue(this.value,'Homicidal');"/>
</label>

<label class="medium">Plan
<input type="radio" name="homicidalNP" class="checkboxMargin" id="homicidalNP"  value="Plan"  onclick="displayTextValue(this.value,'Homicidal');"/>
</label>
<input type="text" value="" id="homicidalOther" name="homicidalOther" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display:none; "> >


<div class="clear"></div>  
<h4>Phobia</h4>

<label class="medium">Absent
<input type="checkbox" value="Yes" name="phobiaAbsent" class="checkboxMargin">
</label>

<label>Agora phobia
<input type="checkbox" value="Yes" name="phobiaAgora" class="checkboxMargin">
</label>

<label>Social phobia
<input type="checkbox" value="Yes" name="phobiaSocial" class="checkboxMargin">
</label>

<label>Specific phobia
<input type="checkbox" value="Yes" name="phobiaSpecific" class="checkboxMargin"> 
</label>
<input type="text" value="" id="phobiaOther" name="phobiaOther" validate="ptfsudVal Value,metachar,no" maxlength="128">


<div class="clear"></div>   
<h4>Delusions</h4>

<label>Absent
<input type="checkbox" value="Yes" name="delusionsAbsent" class="checkboxMargin">
</label>

<label>Persectory
<input type="checkbox" value="Yes" name="delusionsPersectory" class="checkboxMargin">
</label>

<label>D/O Control
<input type="checkbox" value="Yes" name="delusionsDO" class="checkboxMargin">
</label>

<label>Grandiose
<input type="checkbox" value="Yes" name="delusionsGrandiose" class="checkboxMargin">
</label>

<label>Delusional Perception
<input type="checkbox" value="Yes" name="delusionsDP" class="checkboxMargin">
</label>    

<div class="clear"></div> 
<!-- 
<label>Delusional Perception
<input type="checkbox" value="Yes" name="delusionsDPAnother" class="checkboxMargin">
</label> --> 


<label>Somatic
<input type="checkbox" value="Yes" name="delusionsSomatic" class="checkboxMargin"> 
</label>     


<label>Jealous
<input type="checkbox" value="Yes" name="delusionsJealous" class="checkboxMargin"> 
</label>

<label>Guilty
<input type="checkbox" value="Yes" name="delusionsGuilty" class="checkboxMargin">
</label>

<label>Nihilistic
<input type="checkbox" value="Yes" name="delusionsNihilistic" class="checkboxMargin"> 
</label>

<div class="clear"></div>


<label>Bizzare
<input type="checkbox" value="Yes" name="delusionsBizzare" class="checkboxMargin">
</label>

<label>Mood incongruent
<input type="checkbox" value="Yes" name="delusionsMood" class="checkboxMargin">
</label>

<label>Other
<input type="checkbox" value="Yes" name="delusionsOther" class="checkboxMargin">
</label>
<input type="text" value="" id="delusionsOtherVal" name="delusionsOtherVal" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<label class="auto"> Content of deision/Delusional Perception</label> 
<input type="text" value="" id="coddp" name="coddp" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>

<h4>Possessions of thought</h4>     

<label class="auto">Obsessions and Compulsions</label>
<label class="medium">Absent
<input type="radio" name="obsessions" class="radioCheckCol2" id="obsessions" value="Absent"  onclick="displayTextValue(this.value,'Possessions');"/>
</label>
<label class="medium">Present
<input type="radio" name="obsessions" class="radioCheckCol2" id="obsessions"  value="Present" onclick="displayTextValue(this.value,'Possessions');"/>
</label>
<input type="text" value="" id="obsessionsOther" name="obsessionsOther" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display:none; "> 

<div class="clear"></div>

<h4>Delusional Alienation / Passivity</h4>

<label>Absent
<input type="checkbox" value="Yes" name="delusionalAbsent" class="checkboxMargin">
</label>

<label>Thought insertion
<input type="checkbox" value="Yes" name="delusionalThoughtInsertion" class="checkboxMargin">
</label>

<label>Thought withdrawal
<input type="checkbox" value="Yes" name="delusionalThoughtWithdrawal" class="checkboxMargin"> 
</label>

<label>Thought broadcast
<input type="checkbox" value="Yes" name="delusionalThoughtBroadcast" class="checkboxMargin">
</label>  

<label>Somatic Passivity
<input type="checkbox" value="Yes" name="delusionalSomaticPassivity" class="checkboxMargin">
</label>  
<div class="clear"></div>     

<h4>Affect</h4>

<label>Appropriate
<input type="checkbox" value="Yes" name="affectAppropriate" class="checkboxMargin">
</label>

<label>Inappropritate
<input type="checkbox" value="Yes" name="affectInappropritate" class="checkboxMargin"> 
</label>
 
<label>Labile
<input type="checkbox" value="Yes" name="affectLabile" class="checkboxMargin">
</label>

<label>Constricted
<input type="checkbox" value="Yes" name="affectConstricted" class="checkboxMargin">
</label>    

<label>Flat
<input type="checkbox" value="Yes" name="affectFlat" class="checkboxMargin">
</label>
  
<div class="clear"></div> 
<h4>Mood</h4>

<label>Normal
<input type="checkbox" value="Yes" name="moodNormal" class="checkboxMargin">
</label>

<label>Depressed
<input type="checkbox" value="Yes" name="moodDepressed" class="checkboxMargin">
</label>

<label>Anxious
<input type="checkbox" value="Yes" name="moodAnxious" class="checkboxMargin">
</label>

<label>Fearful
<input type="checkbox" value="Yes" name="moodFearful" class="checkboxMargin"> 
</label>    

<label>Euphoric
<input type="checkbox" value="Yes" name="moodEuphoric" class="checkboxMargin">
</label>    

<label>Imtable
<input type="checkbox" value="Yes" name="moodImtable" class="checkboxMargin">
</label>

<label>Apathetic
<input type="checkbox" value="Yes" name="moodApathetic" class="checkboxMargin">
</label>

<div class="clear"></div> 
<h4>Perception</h4>

<label>Absent
<input type="radio" name="perception" class="checkboxMargin" id="perception" value="Absent"  onclick="displayTextValue(this.value,'Perception');"/> 
</label>
<label>Present
<input type="radio" name="perception" class="checkboxMargin" id="perception"  value="Present" onclick="displayTextValue(this.value,'Perception');"/>
</label>
<input type="text" value="" id="perceptionVal" name="perceptionVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display:none; "> 
<div class="clear"></div> 
     
<h4>Hallucinations</h4>

<label>Absent
<input type="radio" name="hallucinations" class="checkboxMargin" id="hallucinations" value="Absent"  onclick="displayTextValue(this.value,'Hallucinations');"/>
</label>

<label>Present
<input type="radio" name="hallucinations" class="checkboxMargin" id="hallucinations"  value="Present" onclick="displayTextValue(this.value,'Hallucinations');"/>
</label>

<div id="hallucinationsDiv" style="display: none;">
<div class="clear"></div>
<label>Auditory
<input type="checkbox" value="Yes" name="auditory" id="auditory"  class="checkboxMargin" onclick="displayTextValue(this.value,'Auditory');">
</label>

<div id="auditoryDiv" style="display: none;">
<label>II Person
<input type="checkbox" value="Yes" name="auditoryII" class="checkboxMargin">
</label>

<label>III Person
<input type="checkbox" value="Yes" name="auditoryIII" class="checkboxMargin">
</label>

<label>Running Commentary
<input type="checkbox" value="Yes" name="auditoryRunning" class="checkboxMargin">
</label>

<label>Command
<input type="checkbox" value="Yes" name="auditoryCommand" class="checkboxMargin">
</label>

<label class="auto">AH from a part of the body
<input type="checkbox" value="Yes" name="auditoryAH" class="checkboxMargin">
</label>
<input type="text" value="" id="auditoryVal" name="auditoryVal" validate="ptfsudVal Value,metachar,no" maxlength="128"> 
<div class="clear"></div>
</div>

<label>Visual
<input type="checkbox" value="Yes" name="visual" class="checkboxMargin"> 
</label>

<label>Olfactory
<input type="checkbox" value="Yes" name="olfactory" class="checkboxMargin"> 
</label>

<label>Tactile
<input type="checkbox" value="Yes" name="tactile" class="checkboxMargin">
</label>

<label>Gustatory
<input type="checkbox" value="Yes" name="gustatory" class="checkboxMargin">
</label>

<label>Sexual
<input type="checkbox" value="Yes" name="sexual" class="checkboxMargin">
</label>
</div>
    
<label>Describe</label> 
<input type="text" value="" id="describe" name="describe" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
     
<h6>Cognition</h6>    
<h4>Attention</h4>

<label class="medium">Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="attention" id="attention"  />
</label>

<label class="medium">Impaired
<input type="radio" value="Impaired" name="attention" class="checkboxMargin" id="attention"   />
</label>

<label class="auto">Digit forward</label> 
<input type="text" value="" id="digitForward" name="digitForward" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">     
 <label class="auto">Digit backward</label> 
<input type="text" value="" id="digitBackward" name="digitBackward" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
 <div class="clear"></div>    

<h4>Concertration</h4>

<label class="medium">Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="concertration" id="concertration"  />
</label>

<label class="medium">Impaired
<input type="radio" value="Impaired" name="concertration" class="checkboxMargin" id="concertration"   />
</label>
<div class="clear"></div>

<label class="auto">Month in reverse</label> 
<input type="text" value="" id="monthInReverse" name="monthInReverse" validate="ptfsudVal Value,metachar,no" maxlength="128">
     
 <label class="auto">Days in reverse</label> 
<input type="text" value="" id="daysInReverse" name="daysInReverse" validate="ptfsudVal Value,metachar,no" maxlength="128">
<label class="auto">Other</label> 
<input type="text" value="" id="concertrationVal" name="concertrationVal" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<h4>Memory </h4>
<label>Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="memory" id="memory" onclick="displayTextValue(this.value,'MemoryImpaired');"  />
</label>

<label>Impaired
<input type="radio" value="Impaired" name="memory" class="checkboxMargin" id="memory"  onclick="displayTextValue(this.value,'MemoryImpaired');" />
</label>
<input type="text" value="" id="memoryImpaired" name="memoryImpaired" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
<div class="clear"></div>         
     
<h4>New learning (Retelling newly learned address)</h4>

<label>Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="nlrnls" id="nlrnls"  />
</label>

<label>Impaired
<input type="radio" value="Impaired" name="nlrnls" class="checkboxMargin" id="nlrnls"   />
</label>
<div class="clear"></div> 

<h4>Clinical assessment of intelligence</h4>     

<label>Average
<input type="radio" name="clinical" class="checkboxMargin" id="clinical" value="Average"  />
</label>

<label>Borderline
<input type="radio" name="clinical" class="checkboxMargin" id="clinical"  value="Borderline" /> 
</label>

<label>Below Average
<input type="radio" name="clinical" class="checkboxMargin" id="clinical"  value="Below Average" />
</label>

<div class="clear"></div> 
<h4> Language</h4>

<label>Normal
<input type="radio" value="Normal"  class="checkboxMargin" name="lang" id="lang"  onclick="displayTextValue(this.value,'LanguageImpaired');"/>
</label>

<label>Impaired
<input type="radio" value="Impaired" name="lang" class="checkboxMargin" id="lang"   onclick="displayTextValue(this.value,'LanguageImpaired');"/>
</label>
<input type="text" value="" id="languageImpairedVal" name="languageImpairedVal" validate="ptfsudVal Value,metachar,no" maxlength="128" style="display: none;">
 
<div class="clear"></div>       
<h4>Absractability (similarities,proverbs)</h4>

<label>Concrete
<input type="checkbox" value="Yes" name="concerate" class="checkboxMargin">
</label>

<label>Semi Abstract
<input type="checkbox" value="Yes" name="semiAbstract" class="checkboxMargin">
</label>

<label>Abstract
<input type="checkbox" value="Yes" name="abstract" class="checkboxMargin">
</label>
<input type="text" value="" id="abstractVal" name="abstractVal" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">


<div class="clear"></div> 
<h4 style="width:161px;float:left;">Judgment</h4>
<input type="text" value="" id="judgement" name="judgement" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">


<div class="clear"></div>
<label>Social</label>	
 <select name="social">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>
	
<label>Personal</label>		
 <select name="personal">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>
<div class="clear"></div>

<label>Test</label>		
<select name="test">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Satisfactory">Satisfactory</option>
<option value="Poor">Poor</option>
</select>
<h4>Insight</h4>
<select name="insight">
<option value="">Select</option>
<option value="Complete denial of illness">Complete denial of illness</option>
<option value="SatiSlight awarness of being sick but denying at the same timesfactory">Slight awarness of being sick but denying at the same time</option>
<option value="Awareness that illness is due to smething unknown in the patient">Awareness that illness is due to smething unknown in the patient</option>
<option value="Intellectual insight">Intellectual insight</option>
<option value="True emotional">True emotional</option>
</select>
<div class="clear"></div>

<h4>Examination of non-coperative and stuperous patient</h4>

<label class="auto">General reaction and posture</label>
<input type="text" value="" id="grap" name="grap" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">

<h4>Attitude</h4>

<label>Voluntary
<input type="radio" name="attitude" class="radioCheckCol2" id="attitude" value="Voluntary"  />
</label>

<label>Passive
<input type="radio" name="attitude" class="radioCheckCol2" id="attitude"  value="Passive" />
</label>

<label>Voluntary postures</label>
<select name="voluntaryPostures">
<option value="">Select</option>
<option value="Comfortable">Comfortable</option>
<option value="Natural Constrained">Natural Constrained</option>
<option value="Awkward">Awkward</option>
</select>
<div class="clear"></div>

<label class="labWidth44">What does the patient do if placeded in awkward or comfortable positions</label>
<input type="text" value="" id="wdtpdiiaocp" name="wdtpdiiaocp" validate="ptfsudVal Value,metachar,no" maxlength="128" >
<div class="clear"></div>
<label class="auto">Behaviour towards physician and nurses</label>
 <select name="btpan">
 <option value="">Select</option>
<option value="Resistive">Resistive</option>
<option value="Evasive">Evasive</option>
<option value="Irritable">Irritable</option>
<option value="Apathetic">Apathetic</option>
<option value="Compliant">Compliant</option>
</select>
<label>Spontaneous Acts</label>
 <select name="spontaneousActs">
 <option value="">Select</option>
<option value="Playfulness">Playfulness</option>
<option value="Mischievousness assaultiveness">Mischievousness assaultiveness</option>
</select>
<div class="clear"></div>


<label class="labWidth44">Defence movements when interfered with or pricked with a pin</label>
<input type="text" value="" id="dmwiwopwap" name="dmwiwopwap" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">
<div class="clear"></div>
<label class="labWidth44">Eating and Dressing</label>
<input type="text" value="" id="ead" name="ead" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete" class=" historyAutoComplete">
<div class="clear"></div>
<label class="labWidth44">What Attention to bowels and bladder</label>
<input type="text" value="" id="watbab" name="watbab" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">
<div class="clear"></div>
<label class="labWidth44">Do the movements show only initial retardation or they consistent throughout</label>
<input type="text" value="" id="dtmsoiroatct" name="dtmsoiroatct" validate="ptfsudVal Value,metachar,no" maxlength="128" class=" historyAutoComplete">

<div class="clear"></div>



<label class="labWidth44">To what extent does the attitude changed?</label>
<input type="text" value="" id="twedtac" name="twedtac" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>
<label class="labWidth44">Is the behaviour constant or variable from day to day?</label>
<input type="text" value="" id="itbcovfdtd" name="itbcovfdtd" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>
<label class="labWidth44">Do any special occurences influence the condition?</label>
<input type="text" value="" id="dasoitc" name="dasoitc" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>


<label>Facial Expression</label>
<input type="text" value="" id="facialExpression" name="facialExpression" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<label>Alert
<input type="checkbox" value="Yes" name="alert" class="checkboxMargin">
</label>

<label>Attentive
<input type="checkbox" value="Yes" name="attentive" class="checkboxMargin">
</label>

<label>Placid
<input type="checkbox" value="Yes" name="placid" class="checkboxMargin">
</label>

<label>Vacant
<input type="checkbox" value="Yes" name="vacant" class="checkboxMargin">
</label>

<label>Stolid
<input type="checkbox" value="Yes" name="stolid" class="checkboxMargin">
</label>

<div class="clear"></div>

<label>Sulky
<input type="checkbox" value="Yes" name="sulky" class="checkboxMargin">
</label>

<label>Scowling
<input type="checkbox" value="Yes" name="scowling" class="checkboxMargin">
</label>

<label>Averse
<input type="checkbox" value="Yes" name="averse" class="checkboxMargin">
</label>

<label>Perplexed
<input type="checkbox" value="Yes" name="perplexed" class="checkboxMargin">
</label>

<label>Distressed
<input type="checkbox" value="Yes" name="distressed" class="checkboxMargin">
</label>

<div class="clear"></div>

<label class="auto">Any play of facial expression or signs of emotion</label>
 <select name="apofeosoe">
 <option value="">Select</option>
<option value="Tears">Tears</option>
<option value="Smiles">Smiles</option>
<option value="Flushing perspiration">Flushing perspiration</option>
</select>

<div class="clear"></div>

<label>On what occasions</label>
<input type="text" value="" id="owo" name="owo" validate="ptfsudVal Value,metachar,no" maxlength="128">

<label>Eyes</label>
<input type="text" value="" id="eyes" name="eyes" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<label class="medium">Open
<input type="radio" name="eyesVal" class="checkboxMargin" id="eyesVal" value="Open"  /> 
</label>
<label class="medium">Closed
<input type="radio" name="eyesVal" class="checkboxMargin" id="eyesVal"  value="Closed" />
</label>

<label class="auto">Resist having lids raised
<input type="checkbox" value="Yes" name="rhlr" class="checkboxMargin"> 
</label>

<label>Movement of eyes</label>
 <select name="movementOfEyes">
 <option value="">Select</option>
<option value="Absent">Absent</option>
<option value="Obtain on Request">Obtain on Request</option>
</select>

<div class="clear"></div>

<label class="labChe375">Give attention or follow the examiner or moving objects</label>

<label class="auto">Yes
<input type="radio" name="gaofteomo" class="checkboxMargin" id="gaofteomo" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="gaofteomo" class="checkboxMargin" id="gaofteomo"  value="No" />
</label>

<div class="clear"></div>
<label class="labChe375">Show only fixed gazing, furtive glances or evasion</label>

<label class="auto">Yes
<input type="radio" name="sofgfgoe" class="checkboxMargin" id="sofgfgoe" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="sofgfgoe" class="checkboxMargin" id="sofgfgoe"  value="No" />
</label>
<div class="clear"></div>

<label class="labChe375">Rolling of eyeball upward,blinkinh, flickering or termor of lids</label>
<label class="auto">Yes
<input type="radio" name="roeubfotol" class="checkboxMargin" id="roeubfotol" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="roeubfotol" class="checkboxMargin" id="roeubfotol"  value="No" />
</label>

<div class="clear"></div>
<label class="labChe375">Reaction to sudden approach or threat to stick or pin the eye</label>

<label class="auto">Yes
<input type="radio" name="rtsaottsopte" class="checkboxMargin" id="rtsaottsopte" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="rtsaottsopte" class="checkboxMargin" id="rtsaottsopte"  value="No" />
</label>
<div class="clear"></div>

<label class="auto">Sensory reaction of pupli (Dilatation from painful stimulus or irriation of skin of neck)</label>
<label class="auto">Yes
<input type="radio" name="srop" class="checkboxMargin" id="srop" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="srop" class="checkboxMargin" id="srop"  value="No" />
</label>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label class="auto">Reaction to what  is said or done</label>
<input type="text" value="" id="rtwisod" name="rtwisod" validate="ptfsudVal Value,metachar,no" maxlength="128">
<div class="clear"></div>

<h4>Command</h4>

<label style="width:102px;">Show tongue
<input type="checkbox" value="Yes" name="showTongue" class="checkboxMargin">
</label>

<label style="width:102px;">Move limbs
<input type="checkbox" value="Yes" name="moveLimbs" class="checkboxMargin"> 
</label>

<label class="auto">Grasp with hand(Clinging ,clutching etc.)
<input type="checkbox" value="Yes" name="gwh" class="checkboxMargin">
</label>

<label style="width:102px;">Move limbs
<input type="checkbox" value="Yes" name="moveLimbsAnother" class="checkboxMargin">
</label>

<label class="medium">Slow
<input type="radio" name="moveLimbsVal" class="checkboxMargin" id="moveLimbsVal" value="Slow"  />
</label>

<label class="medium">Sudden
<input type="radio" name="moveLimbsVal" class="checkboxMargin" id="moveLimbsVal"  value="Sudden" />
</label>

<div class="clear"></div>

<label>Reaction to pin 	pricks</label>
<input type="text" value="" id="rtpp" name="rtpp" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete" >

<label>Automatic Obedience</label>
<input type="text" value="" id="automatic" name="automatic" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>
<label>Echopraxia</label>
<input type="text" value="" id="echopraxia" name="echopraxia" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>
<h4>Muscular reaction</h4>

<label>Test for rigidity</label>
<input type="text" value="" id="testForRigidity" name="testForRigidity" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete" >
<div class="clear"></div>

<label class="labChe412">Teat head and neck movements backwards and forwards and sideways</label>

<label class="auto">Yes
<input type="radio" name="teatHead" class="checkboxMargin" id="teatHead" value="Yes"  /> 
</label>
<label class="auto">No
<input type="radio" name="teatHead" class="checkboxMargin" id="teatHead"  value="No" />
</label>

<div class="clear"></div>

<label class="labChe412">Test also the jaw, shoulder,elbows, fingers and lower extremities</label>

<label class="auto">Yes
<input type="radio" name="testAlsoTheJaw" class="checkboxMargin" id="testAlsoTheJaw" value="Yes"  /> 
</label>
<label class="auto">No
<input type="radio" name="testAlsoTheJaw" class="checkboxMargin" id="testAlsoTheJaw"  value="No" />
</label>
<div class="clear"></div>

<label class="labChe412">Does distraction or command influence the reactions?</label>
<label class="auto">Yes
<input type="radio" name="doesDistraction" class="checkboxMargin" id="doesDistraction" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="doesDistraction" class="checkboxMargin" id="doesDistraction"  value="No" /> 
</label>

<div class="clear"></div>
<label class="labChe412">Closing of mouth, protrusion of lips</label>

<label class="auto">Yes
<input type="radio" name="closingOfMouth" class="checkboxMargin" id="closingOfMouth" value="Yes"  /> 
</label>
<label class="auto">No
<input type="radio" name="closingOfMouth" class="checkboxMargin" id="closingOfMouth"  value="No" /> 
</label>

<div class="clear"></div>
<label class="labChe412">Holding of saliva,drooling</label>

<label class="auto">Yes
<input type="radio" name="holdingOfSaliva" class="checkboxMargin" id="holdingOfSaliva" value="Yes"  /> 
</label>
<label class="auto">No
<input type="radio" name="holdingOfSaliva" class="checkboxMargin" id="holdingOfSaliva"  value="No" />
</label>
<div class="clear"></div>

<h4 style="float:left;width:190px;">Emotional Responsiveness</h4>
<input type="text" value="" id="emotional" name="emotional" validate="ptfsudVal Value,metachar,no" maxlength="128" class="historyAutoComplete">
<div class="clear"></div>


<label class="labChe486">Is feeling shown when talked to of family or children?</label>
<label class="auto">Yes
<input type="radio" name="ifswttofoc" class="checkboxMargin" id="ifswttofoc" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="ifswttofoc" class="checkboxMargin" id="ifswttofoc"  value="No" />
</label>

<div class="clear"></div>
<label class="labChe486">Is feeling  shown when sensitive points in history are mentioned, when visitors come?</label>

<label class="auto">Yes
<input type="radio" name="ifswspihamwvc" class="checkboxMargin" id="ifswspihamwvc" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="ifswspihamwvc" class="checkboxMargin" id="ifswspihamwvc"  value="No" />
</label>

<div class="clear"></div>

<label>Acceleration of respiration
<input type="checkbox" value="Yes" name="acceleration" class="checkboxMargin">
</label>

<label>Flushing
<input type="checkbox" value="Yes" name="flushing" class="checkboxMargin">
</label>

<label>Tears in the eyes
<input type="checkbox" value="Yes" name="tearsInTheEyes" class="checkboxMargin">
</label>

<label>Acceleration of pulse
<input type="checkbox" value="Yes" name="accelerationOfPulse" class="checkboxMargin">
</label>

<label>Perspiration
<input type="checkbox" value="Yes" name="perspiration" class="checkboxMargin"> 
</label>

<label>Others
<input type="checkbox" value="Yes" name="othersAnother" class="checkboxMargin"> 
</label>
<input type="text" value="" id="othersAnotherVal" name="othersAnotherVal" validate="ptfsudVal Value,metachar,no" maxlength="128">



<div class="clear"></div>
<label class="auto">Do joke elicit any response</label>

<label class="auto">Yes
<input type="radio" name="djear" class="radioCheckCol2" id="djear" value="Yes"  />
</label>
<label class="auto">No
<input type="radio" name="djear" class="radioCheckCol2" id="djear"  value="No" />
</label>

<label class="auto">Effects of Unexpected Stimuli
<input type="checkbox" value="Yes" name="effects" class="checkboxMargin"> 
</label>

<label>Speech
<input type="checkbox" value="Yes" name="speech" class="checkboxMargin">
</label>

<label>Writing
<input type="checkbox" value="Yes" name="writing" class="checkboxMargin">
</label>
<div class="clear"></div>

<h4 style="float:left;width:156px;">Case Formulation</h4>
<textarea rows="" cols="" name="caseFromulation"    maxlength="128" onkeyup="return checkLength(this)" class="textareaMediua historyAutoComplete"></textarea>


</div>
</form>



<style>
p{margin:0px 0px 5px 10px;font-size:11px;}
label.bg {background:none;box-shadow: none;}
.partLeftDiv{width:450px; float:left;}
.partRightDiv{width:450px; float:left; margin-left:10px;}

.labWidth44{width:450px;}
.labChe375{width:375px;}
.labChe412{width:412px;}
.labChe486{width:486px;}
</style>


