
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript">
	<%
	
	//code added by rajdeo
	Map<String,Object> map = new HashMap<String,Object>();
	String templateName="Deaddiction Center";	
	
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
<form method="post" action="" name="dedd" >

<div class="Block">
<h6>Deaddiction Center</h6>
<div class="clear"></div>
<h4>Drug Use History</h4>
<input id="deaddictionFlag" name="deaddictionFlag" tabindex="1" value="DeaddictionCenter" type="hidden"  />
<input type="hidden" name="templateName" value="Deaddiction Centre"/>

					<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForDrugUseHistory();" />
					<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForDrugUseHistory();" />
<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="drugUseHistoryGrid" >

<tr> 
<th scope="col">&nbsp;</th>
<th>Name of Drug</th>
<th>Current Use</th>
<th>Years of regular use</th>
<th>Route</th>

</tr> 
<tr>
<td><input  type="checkbox" class="radioCheck" name="drugUseHistoryRadio1" id="drugUseHistoryRadio1" /></td> 
<td>
<select name="nameOfDrug1" id="nameOfDrug1" onchange="chkDrugHistory(this.value,1);">
<option value="">Select</option>
<option value="Alcohol">Alcohol</option>
<option value="Cannabis">Cannabis</option>
<option value="Opiates">Opiates</option>
<option value="Nicotine">Nicotine</option>
<option value="Minor Tranquilizers">Minor Tranquilizers</option>
<option value="Others">Others</option>
</select>
<input type="text" id="txtOtherDrugName1" name="txtOtherDrugName1"  style="display:none" maxlength="32"/>
</td>
<td><select name="currentUse1" id="currentUse1">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
</td>
<td>

<input type="text" name="yearsOfReqularUse1" id="yearsOfReqularUse1" maxlength="3" onkeypress="javascript:return isNumber(event)"  value=""/></td>
<td>
<input type="text" name="routeDrug1" id="routeDrug1" maxlength="8" value=""/> 
</td>
 </tr>

</table>
</div>
<input type="hidden" name="drugUseHistoryCount" id="drugUseHistoryCount" value="1" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="auto">Was he/she in controlled environment recently ?</label>
<select name ="environment" id="environment" onblur="showEnvironmentYes(this.value);">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
	<div class="clear"></div>
<div id="divEnvironment" style="display: none;" class="medium">
		<label> Specify </label>
		<select id="specify"	name="specify" onchange="checkSpecify11(this.value)">
		<option value="">Select</option>
		<option value="Medical">Medical</option>
		<option value="Psychiatric">Psychiatric</option>
		<option value="Jail">Jail</option>
		<option value="Others">Others</option>
		</select>
		
		
		<input id="specifyOthers" name="specifyOthers" value="" tabindex="1" validate="Others Value,metachar,no" maxlength="50" type="text" style="display: none" >
	<label> No. of days </label>
	<input type="text"  id="noOfDays"  name="noOfDays" onkeypress="javascript:return isNumber(event)" maxlength="5" value="" validate="No. of days,int,no"/>						 
</div>
<div class="clear"></div>

<h4>If any of the drugs are being used regularly , note the following details</h4>
					<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForDrugs();"  />
					<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForDrugs();" />

<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="drugsGrid" >
<tr> 
<th scope="col" style="border-bottom: 1px solid #a5a5a5;">&nbsp;</th>
<th style="border-bottom: 1px solid #a5a5a5;">Name of Drug</th>
<th style="border-bottom: 1px solid #a5a5a5;">Age of Initiation </th>
<th colspan="2" style="border-bottom: 1px solid #a5a5a5;"><center>Regular Use</center></th>
<th colspan="2" style="border-bottom: 1px solid #a5a5a5;"><center>Dependence</center></th>
</tr> 
<tr>
<th></th>
<th></th>
<th></th>
<th><center>Age of Onset</center></th>
<th><center>Duration</center></th>
<th><center>Age of Onset</center></th>
<!-- <th></th> -->


</tr>
<tr>
<td><input  type="checkbox" class="radioCheck" name="drugsRadio1" id="drugsRadio1" value="" /></td> 
<td>
 <input type="text"  id="drugName1"  name="drugName1" maxlength="32" value=""/>
</td>
<td>
 <input type="text"  id="ageOfInitial1"  name="ageOfInitial1" maxlength="3" onkeypress="javascript:return isNumber(event);" value="" validate="Age of Initiation,float,no" />
</td>
<td>
 <input type="text"  id="regularUseAgeOfOnSet1"  name="regularUseAgeOfOnSet1" maxlength="3" size="24" validate="Age of Onset,int,no" onkeypress="javascript:return isNumber(event)" value="" />
</td>
<td>
 <input type="text"  id="regularUseDurationOnset1"  name="regularUseDurationOnset1" size="24" validate="Duration,int,no" maxlength="16" onkeypress="javascript:return isNumber(event)" value=""/>
</td>
<td style="width: 181px; ">
 <input type="text"  id="dependenceAgeOfOnset1"  name="dependenceAgeOfOnset1" validate="Age of Onset,int,no" size="24" maxlength="3" onkeypress="javascript:return isNumber(event)" value=""/>
</td>
</tr>
</table>
</div>
<input type="hidden" name="drugsCount" id="drugsCount" value="1" />

<h4>Current drug use Pattern</h4>

					<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForCurrentDrugUsePattern();" />
					<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForCurrentDrugUsePattern();" />

<div class="cmnTable">
<table 	id="currentDrugUsePatternGrid" >
<tr> 
<th scope="col">&nbsp;</th>
<th>Name of Drug</th>
<th>Frequency of Consumption </th>
<th>Avg. amt used (/day)</th>
<th>Heaviest consumption in one day</th>
<th>Withdrawal symptoms</th>
<th>Primary drug of abuse</th>
<th>Secondary drug of abuse</th>
</tr> 
<tr> 
<td><input  type="checkbox" class="radioCheck" name="currentDrugUsePatternRadio1" id="currentDrugUsePatternRadio1" /></td>
<td>
 <input type="text"  id="drugNameValue1"  name="drugNameValue1" maxlength="32" value=""/>
</td>
<td>
 <input type="text"  id="frequencyDrug1"  name="frequencyDrug1"  size="12" maxlength="10" validate="Frequency of Consumption,float,no" onkeypress="javascript:return isNumberDecimal(event)" value=""/>
</td>
<td>
 <input type="text"  id="avgAmt1"  name="avgAmt1" maxlength="10" size="12" value="" onkeypress="javascript:return isNumberDecimal(event)"/>
</td>
<td>
 <input type="text"  id="heaviest1"  name="heaviest1" maxlength="32" size="12" value=""/>
</td>
<td>
 <input type="text"  id="withdrawal1"  name="withdrawal1" maxlength="15"  size="12" value=""/>
</td>

<td>
 <input type="text"  id="primaryDrugOfAbuse1"  name="primaryDrugOfAbuse1" maxlength="32"  size="15" value=""/>
</td>

<td>
 <input type="text"  id="secondaryDrugOfAbuse1"  name="secondaryDrugOfAbuse1" maxlength="32" size="15" value=""/>
</td>
</tr>
</table>

</div>
<input type="hidden" name="currentDrugUsePatternCount" id="currentDrugUsePatternCount" value="1" />

<div class="clear"></div>
<div class="paddingTop5"></div>

<!-- comented by swarup -->
<!-- <label>Primary drug of abuse</label>
<input type="text"  id="primaryDrugOfAbuse"  name="primaryDrugOfAbuse" value=""/>
<label>Secondary drug of abuse</label>
<input type="text"  id="secondaryDrugOfAbuse"  name="secondaryDrugOfAbuse" value=""/> -->


<h4>Last use</h4>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForLastUse();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForLastUse();" />
					

<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="lastUseGrid">
<tr> 
<th scope="col">&nbsp;</th>
<th>Name of Drug</th>
<th>Date </th>
<th>Amount</th>
</tr> 
<tr> 
<td><input  type="checkbox" class="radioCheck" name="lastUseRadio1" id="lastUseRadio1" value="" /></td>
<td>
 <input type="text"  id="nameOfDrugsss1"  name="nameOfDrugsss1" maxlength="32"  value=""/>
</td>
<td>
 
<input type="text" id="dateLastUse1" name="dateLastUse1" 	value=""	size="23.5"  validate="Date,date,no" maxlength="10" onkeyup="mask(this.value,this,'2,5','/');"  > 
<!-- <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"			onclick="setdate('',document.opdMain.dateLastUse1,event);" /> --> 
 
</td>
<td>
 <input type="text"  id="amt1"  name="amt1" value="" maxlength="10" onkeypress="javascript:return isNumberDecimal(event)"     />
</td>

</tr>
</table>
</div>
<input type="hidden" name="lastUseCount" id="lastUseCount" value="1" />

<div class="clear"></div>
<div class="paddingTop5"></div>
<h4>Pathological use pattern current (with respect to alcohol)</h4>
<div class="clear"></div>
<p class="headingPtext">1. &nbsp;Alcohol is often taken in larger amounts or over a longer period than the person intended.</p>
<ul class="ulText">
<li>Did you often find that when you started drinking  you ended up drinking much more than you were planning to?</li>
<li>If No: What about drinking for a much longer period  of time that you more planning to?</li>
</ul>
<div class="clear"></div>
<select  id="alcohol"  name="alcohol" style="margin-left:40px; text-align: left;"  onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">2. &nbsp;Persistent desire OR one or more unsuccessful efforts to cut down or control alcohol use.</p>
<ul class="ulText">
<li>Did you try to cut down or stop drinking alcohol?</li>
<li>If Yes: Did you ever actually stop drinking altogether</li>
<li>If unclear: Did you want to stop or cut down?</li>
<li>If Yes: Is this something you kept worrying about?</li>
</ul>

<div class="clear"></div>
<select  name="persistent" id="persistent" style="margin-left:40px; text-align: left;" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>

</select>
<div class="clear"></div>

<p class="headingPtext">3. &nbsp;A great deal of time spent in activities necessary to get alcohol, taking alcohol, or recovering from its effects</p>
<div class="clear"></div>
<ul class="ulText">
<li>Did you spent lot of time drinking , being high or hung over?</li>
</ul>
<div class="clear"></div>
<select style="margin-left: 40px; text-align: left;" id="greatDeal" name="greatDeal" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">4. &nbsp;Craving or a strong desire or urge to use alcohol</p>
<div class="clear"></div>
<ul class="ulText">
<li>Do you feel a strong push or urge to go for drinking frequently even when you are sober for days?</li>
</ul>
<div class="clear"></div>
<select style="margin-left:40px; text-align: left;"  id="craving" name="craving" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">5. &nbsp;Recurrent alcohol use resulting in a failure to fulfill major role obligation at works, school or home (e.g.,does not go to<br>
 &nbsp;&nbsp;&nbsp;&nbsp; work because hang over, goes to school or work high, intoxicated while taking care of children)</p>
<div class="clear"></div>
<ul class="ulText">
<li>If No: What about missing something important, like staying away from school or work or missing an appointment because you were intoxicated, high  or very hang over?</li>

</ul>
<div class="clear"></div>
<select style="margin-left:40px; text-align: left;"  id="recurrent" name="recurrent" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">6. &nbsp;Continued alcohol use despite having a persistent or recurrent social (significant) or interpersonal problems caused or <br>
 &nbsp;&nbsp;&nbsp;&nbsp; exacerbated by the effects of alcohol</p>
<div class="clear"></div>
<ul class="ulText">
<li>If not already known: Did your drinking cause problems with other people, such as with family members or people at work?</li>
<li>If not already known: Did your drinking ever cause significant psychological problems, like making you depressed?</li>
<li>If not already known: Did your drinking ever cause significant physical problems or make a physical problems worse? (Was it more than just a simple hang over?)</li>
<li>If yes to any or above: Did you keep on drinking  anyway?</li>
</ul>
<div class="clear"></div>
<select style="margin-left: 40px; text-align: left;" name="continued" id="continued" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">7. &nbsp;Important social, occupational or recreational activities given up or reduced because of alcohol use</p>
<div class="clear"></div>
<ul class="ulText">
<li>Did you drink so often that you started to drink instead of working or spending time at hobbies or with your family or friends?</li>
<li>If No: What about a time when you were often intoxicated or high or very hang over while you were doing something important, like being at school or work or taking care of children?</li>
</ul>
<div class="clear"></div>

<select style="margin-left:40px; text-align: left;"  id="important" name="important" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">8. &nbsp;Recurrent alcohol use in situations in which it is physically hazardous (e.g.; drives when intoxicated)</p>
<div class="clear"></div>

<ul class="ulText">
<li>Did you drink so often that you started to drink instead of working or spending time at hobbies or with your family or friends?</li>
<li>If No: What about a time when you were often intoxicated or high or very hang over while you were doing something important, like being at school or work or taking care of children?</li>
</ul>
<div class="clear"></div>

<select style="margin-left:40px; text-align: left;" id="recurrentAlcohol" name="recurrentAlcohol" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">9. &nbsp;Alcohol use is continued despite knowledge of having persistent or recurrent physical or psychological problem that is <br>
 &nbsp;&nbsp;&nbsp;&nbsp; likely to have caused or exacerbated by alcohol</p>
<div class="clear"></div>
<ul class="ulText">
<li>Do you know that your current problems(specify) are due to alcohol</li>
<li>In spite of that do you find it difficult to stay away from alcohol</li>
</ul>

<div class="clear"></div>
<select style="margin-left:40px; text-align: left;"  name="alcoholUse" id="alcoholUse" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">10. &nbsp;Tolerance, as defined by either of the following:</p>

<div class="clear"></div>
<ul class="ulTextTypeA">
<li type="a">&nbsp; A need for markedly increased amounts of alcohol to achieve intoxication or desired effect.</li>
<li type="a">&nbsp; A markedly diminished effect with continued use of the same amount of alcohol.</li>
</ul>
<div class="clear"></div>

<ul class="ulText" style="margin-left: 14px;">
<li>Did you find that you needed to drink a lot more in order to get high than you did when  you first started drinking? (Could you drink a lot more than most people without really getting drunk?)</li>
<li>If Yes: how much more?</li>
<li>If No: What about finding when you drank the same amount, it had much less effect than before?</li>
</ul>
<div class="clear"></div>

<select style="margin-left:40px; text-align: left;" id="tolerance" name="tolerance" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>
<div class="clear"></div>

<p class="headingPtext">11. &nbsp;Withdrawal, as manifested by either of the following:</p>
<div class="clear"></div>

<ul class="ulTextTypeA">
<li type="a">&nbsp; The characteristic withdrawal syndrome of alcohol (nausea or vomiting, malaise or weakness, autonomic hyperactivity, anxiety, depressed mood or irritability, transient hallucinations or illusions, headache, insomnia)</li>
<li type="a">&nbsp; Alcohol (or a closely related substance, such as benzodiazepine) is taken to relieve or avoid withdrawal symptoms</li>
</ul>

<div class="clear"></div>
<ul class="ulText" style="margin-left: 14px;">
<li>Did you ever have the shakes when you cut down or stopped drinking (that is your hands shook so much that other people would have been able to notice it)?</label></li>
<li>After not drinking for a few hours or more, did you often drink or some medication to keep yourself from getting the shakes or becoming sick?</label></li>
<li>
<select  name="didYou" onchange="getPathologicalUsePattern(this.value);">
<option value="">Select</option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<div id="pathologicalUsePatternDiv">
<div class="clear"></div>
<div>If No: What about drinking to stop the shakes or to stop feeling?</div>
<input  type="text"  name="whatAbout"  value=""  maxlength="128"/>
</div> 	
</li>
</ul>

<div class="clear"></div>

<select style="margin-left:40px; text-align: left;" name="withdrawal"  id="withdrawal" onclick="displayTotalScore(this.value);">
<option value="">Select</option>
<option value="0-Inadequate Information">0-Inadequate Information</option>
<option value="1-absent or false">1-absent or false</option>
<option value="2-Subthreshold">2-Subthreshold </option>
<option value="3-Threshold or true">3-Threshold or true</option>
</select>

<div class="clear"></div>

<label>Total Source</label>
<input  type="text" value="0" id="totalSource" name="totalSource" readonly="readonly" />
<div class="paddingTop5"></div>
<div class="clear"></div>
 <div>
 <h4 style="cursor:pointer;" onclick="popwindowResultEntryForDermotology('<%=hinId%>@@@<%=visitId%>@@@<%=templateName%>');">External Lab Report Entry</h4>
	</div>
<div class="clear"></div>
<h6>Drug Related Problems </h6>
<h4>A. Medical Status</h4>

<table>  
<!-- <tr>
<td colspan="6"> <h4>A. Medical Status</h4></td>
</tr> -->
<tr>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
</tr>

<tr>
<td>Gastritis</td>
<td>
<select name="gastritisCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="gastritisPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Bronchitis</td>
<td>
<select name="bronchitisCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="bronchitisPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td>Jaundice</td>
<td>
<select name="jaundiceCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="jaundicePast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Heart disease</td>
<td>
<select name="heartDiseaseCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="heartDiseasePast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>
<tr>
<td>Ascites</td>
<td>
<select name="ascitesCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="ascitesPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Anemia</td>
<td>
<select name="anemiaCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="anemiaPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>

<tr>
<td>Hematemesis</td>
<td>
<select name="haematamosisCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="haematamosisPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Peripheral neuritis</td>
<td>
<select name="peripheralNeuritisCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="peripheralNeuritisPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>

<tr>
<td>Cirrhosis</td>
<td>
<select name="cirrhosisCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="cirrhosisPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Pneumonia</td>
<td>
<select name="pneumoniaCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="pneumoniaPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td>Portal HTN</td>
<td>
<select name="portalHTNCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="portalHTNPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Others(specify)</td>
<td>
<select name="othersCurrent" id="othersCurrent" onchange="othersCurrent11(this.value);">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<input id="othersCurrentValue" name="othersCurrentValue" value="" tabindex="1" validate="Others Current Value,metachar,no" maxlength="50" type="text" style="display: none" class="medium">

</td>
<td>
<select name="othersPast" id="othersPast" onchange="othersPast11(this.value);">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<input id="othersPastValue" name="othersPastValue" value="" tabindex="1" validate="Others Past Value,metachar,no" maxlength="50" type="text" style="display: none" class="medium">

</td>
</tr>


<tr>
<td colspan="6"> <h4>B. Drug related problems - Medical Status & Employment Support Status</h4></td>
</tr>
<tr>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
</tr>

<tr>
<td>Fights at work Place</td>
<td>
<select name="fightsAtWorkPlaceCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="fightsAtWorkPlacePast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Shift of Job</td>
<td>
<select name="shiftOfJobCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="shiftOfJobPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td>Jobless</td>
<td>
<select name="joblessCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="joblessPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td></td>
<td>

</td>
<td>

</td>
</tr>




<tr>
<td colspan="6"> <h4>C. Legal Status</h4></td>
</tr>
<tr>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
</tr>

<tr>
<td>Police Case</td>
<td>
<select name="policeCaseCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="policeCasePlacePast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Arrests/Stay in Jail</td>
<td>
<select name="arrestsStayInJailCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="arrestsStayInJailPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td colspan="6"> <h4>D. Psycho-social problems</h4></td>
</tr>
<tr>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
</tr>


<tr>
<td>Fights in the family</td>
<td>
<select name="fightsInTheFamilyCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="fightsInTheFamilyPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Academic deterioration</td>
<td>
<select name="academicDeteriorationCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="academicDeteriorationPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>



<tr>
<td>Loss of friends</td>
<td>
<select name="lossOfFriendsCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="lossOfFriendsPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Separation</td>
<td>
<select name="separationCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="separationPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td>Divorce</td>
<td>
<select name="divorceCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="divorcePast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Financial loss</td>
<td>
<select name="financialLossCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="financialLossPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>




<tr>
<td colspan="6"> <h4>E. Psychiatric Status</h4></td>
</tr>
<tr>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
<th></th>
<th>Current (last 30 days)</th>
<th>Past</th>
</tr>


<tr>
<td>Delirium Tremens</td>
<td>
<select name="deliriumTremensCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="deliriumTremensPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Psychotic disorder</td>
<td>
<select name="psychoticDiscorderCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="psychoticDiscorderPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>



<tr>
<td>Mood disorder</td>
<td>
<select name="moodDisorderCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="moodDisorderPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Anxiety disorder</td>
<td>
<select name="anxietyDisorderCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="anxietyDisorderPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>


<tr>
<td>Dementia</td>
<td>
<select name="dementiaCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="dementiaPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Amnestic Disorder</td>
<td>
<select name="amnestyDisorderCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="amnestyDisorderLossPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>



<tr>
<td>Sexual dysfunction</td>
<td>
<select name="sexualDysfunctionCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="sexualDysfunctionPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>

<td>Sleep disorder</td>
<td>
<select name="sleepDisorderCurrent">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
<td>
<select name="sleepDisorderPast">
<option value="">Select</option>
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
</td>
</tr>
</table>

<div class="clear"></div>
<div class="paddingTop15"></div>

<label>Family History</label>
<select  multiple="multiple" style="height: 100px;weight:300px;" name="familyHistorySelect">
<option value="Mental illness">Mental illness</option>
<option value="Alcoholism">Alcoholism</option>
<option value="Drug dependency">Drug dependency</option>
<option value="Anti-social personality">Anti-social personality</option>
<option value="Suicide">Suicide</option>
<option value="Others">Others(specify)</option>
</select>
<textarea rows="" cols="" name ="familyHistorytxtArea" class="textareaMediua" maxlength="220" onkeyup="return checkLength(this)"></textarea>

<div class="clear"></div>

<label style="height:auto; line-height: 17px;">Previous attempts at abstinence</label>
<select name="previousAttemptsAtAbstinence"  onblur="showPreviousAttemptsAtAbstinenceYes(this.value);" onchange="chkpreviousAttemptsAtAbstinence(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea id="txtpreviousAttemptsAtAbstinence"  name="txtpreviousAttemptsAtAbstinence"	onkeyup="return checkLength(this)" style="display:none;width:180px" maxlength="256"> </textarea> 
<div class="clear"></div>

<label>Mental Status</label>
<textarea rows="" cols="" name ="mentalStatusExaminationtxtArea" class="textareaMediua  historyAutoComplete" onkeyup="return checkLength(this)"  maxlength="220" onkeyup="return checkLength(this)"></textarea>



<label>Physical Examination</label>
<textarea rows="" cols="" name ="physicalExaminationtxtArea" class="textareaMediua historyAutoComplete" maxlength="220" onkeyup="return checkLength(this)"></textarea>

<div class="clear"></div>
<label style="height:auto; line-height: 17px;">Reasons for seeking treatment</label>
<select  multiple="multiple" class="multiple" name="reasonsForSeekingTreatmentSelect" style="width:220px;height:164px;" onchange="chkreasonsForSeeking(this.value)">
<option value="Physical III health">Physical III health</option>
<option value="Guilt feeling">Guilt feeling </option>
<option value="Facing Tension">Facing Tension</option>
<option value="Facing pressure facing responsibility">Facing pressure facing responsibility</option>
<option value="Financial problem">Financial problem</option>
<option value="Social outcast">Social outcast</option>
<option value="loss">loss</option>
<option value="Problem at job">Problem at job</option>
<option value="Non-availablitiy">Non-availablitiy</option>
<option value="Others">Others</option>
</select>
<input type="text" id="txtreasonsForSeeking" style="display:none;width:180px"  maxlength="32"/>
<div class="clear"></div>
<label >Formulation & Plan </label>
<select  multiple="multiple" class="multiple" name="formulationPlanSelect" onchange="chkformulationPlan(this.value)">
<option value="OP">OP</option>
<option value="IP">IP</option>
<option value="Individual sessions">Individual sessions</option>
<option value="Group therapy">Group therapy</option>
<option value="Family therapy">Family therapy</option>
<option value="Others">Others</option>
</select>
<input type="text" id="txtformulationPlan" style="display:none"/>
<div class="clear"></div>
<label>Premorbid Personality</label>
<textarea rows="" cols="" name ="premorbidPremorbidtxtArea" class="textareaMediua" maxlength="220" onkeyup="return checkLength(this)"></textarea>

<!-- <div id="divPreviousAttemptsAtAbstinence" style="display: none;">
<div class="clear"></div>


<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForPeriod();"  />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForPeriod();" />


					

<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="periodGrid">
<tr> 

<th scope="col">&nbsp;</th>
<th>Time Period</th>
<th>Period in weeks </th>
<th>Self/with medical help</th>


</tr> 
<tr>
<td><input  type="checkbox" class="radioCheck" name="periodRadio1" id="periodRadio1" /></td> 
<td>
 <input type="text"  id="timePeriod1"  name="timePeriod1" value=""/>
</td>
<td>
 <input type="text"  id="periodInWeeks1"  name="periodInWeeks1" value=""/>
</td>
<td>
 <input type="text"  id="selfWithMedicalHelp1"  name="selfWithMedicalHelp1" value=""/>
</td>
</tr>
</table>
</div>
<input type="hidden" name="periodCount" id="periodCount" value="1" />
</div> -->



</div>
</form>


