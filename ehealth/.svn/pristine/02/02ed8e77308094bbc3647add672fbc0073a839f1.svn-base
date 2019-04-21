<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.multi-select.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/multiselect.css">

	
<style>
.widthSec { width: 148px;}
.widthSec:hover { width: 148px;}
.widthSec:focus { width: 148px;}
</style>
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

<script type="text/javascript" language="javascript">
	<%
	String templateName= "Leprosy Proforma";
	Map<String, Object> map1 = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map1 = (Map) request.getAttribute("map");
	}
	int hinId=0;
	int visitId=0;
	int patientAge=0;
	if(map1.get("hinId")!=null)
	{
	hinId=(Integer)map1.get("hinId"); 
	}
	if(map1.get("visitId")!=null)
	{
		visitId=(Integer)map1.get("visitId"); 
	}
	if(map1.get("patientAge")!=null){
		patientAge=(Integer)map1.get("patientAge");		
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
<%
List<DgResultEntryHeader>labResultForLeprosyPerformaList = new ArrayList<DgResultEntryHeader>();
Map<String, Object> map = new HashMap<String, Object>();

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

if(map.get("labResultForLeprosyPerforma") != null){
	labResultForLeprosyPerformaList=(List)map.get("labResultForLeprosyPerforma");
}
%>


<form method="post" action="" name="leprosyProforma" >
<div class="titleBg">
<h2>Leprosy Proforma</h2>
</div>
<div class="Block">
<input id="leprosyFlag" name="leprosyFlag" tabindex="1" value="LeprosyPerforma" type="hidden" />
<input type="hidden" name="templateName" value="Leprosy Performa"/>
<label>Presenting Complaints</label>
<!-- <select  multiple="multiple" class="multiple" name="presentingComplaints" onchange="displayLeproPresenting(this.value)" >
<option value="Itching">Itching</option>
<option value="Wheals">Wheals</option>
<option value="Scaling">Scaling</option>
<option value="Oozing And Crusting">Oozing And Crusting</option>
<option value="Pain">Pain</option>
<option value="Burning Sensation">Burning Sensation</option>
<option value="Fever">Fever</option>
<option value="Numbness">Numbness</option>
<option value="Parasthesia">Parasthesia</option>
<option value="Weakness of Limbs">Weakness of Limbs</option>
<option value="Plantar Ulcer">Plantar Ulcer</option>
<option value="Dry Skin">Dry Skin</option>
<option value="Motor Palsy">Motor Palsy</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="leprosyPresenting">
<textarea type="text" name="leprosyNeighboursValue" id="leprosyPresenting" maxlength="256" class="historyAutoComplete" style="width:264px;overflow-x:hidden;resize:vertical;"></textarea>
</div> -->

<select  style="display: block;width: 212px;height:62px;" id="presentingComplaintsLp" name="presentingComplaintsLp" onchange="showValuesLp(getMultiSelectValueLp(this));displayLeprosyProformaValueDivLp(this.value);" multiple >
<option value="Itching - ">Itching</option>
<option value="Wheals - ">Wheals</option>
<option value="Scaling - ">Scaling</option>
<option value="Oozing And Crusting - ">Oozing And Crusting</option>
<option value="Pain - ">Pain</option>
<option value="Burning Sensation - ">Burning Sensation</option>
<option value="Fever - ">Fever</option>
<option value="Numbness - ">Numbness</option>
<option value="Parasthesia - ">Parasthesia</option>
<option value="Weakness of Limbs - ">Weakness of Limbs</option>
<option value="Plantar Ulcer - ">Plantar Ulcer</option>
<option value="Dry Skin - ">Dry Skin</option>
<option value="Motor Palsy - ">Motor Palsy</option>
<option value="Others - ">Others</option>
</select>
<div style="display: none" id="presentingComplaintsValueDivLp">
<textarea name="presentingComplaints" id="presentingComplaints" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 62px;"></textarea>
</div>
<div style="display: none" id=presentingComplaintsValue>
<textarea  type="text" name="presentingComplaintsValue"    style="display:block;width:181px;height:62px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   tabindex="1"></textarea>
</div>
 <div class="clear"></div>


<label>Duration of Illness</label>
<input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge %>" />
<input style="width:50px"  type="text" id="durationOfIllness" name="durationOfIllness" value=""  maxlength="4" validate="Duration Of Illness,float,no" tabindex="1"  >
<select id="durationParameter" name="durationParameter" class="small" onchange="yearValidationDermo('durationOfIllness',this.id);">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years </option>
</select>
<h4>Past History</h4>

<label class="medium1">TB
<input  type="checkbox" name="tb" value="y"  validate="TB,string,no" tabindex="1" class="checkboxMargin" />
</label>

<label class="medium1">Hypertension
<input  type="checkbox" name="hypertension" value="y"   validate="Hypertension,metachar,no" tabindex="1" class="checkboxMargin" />
</label>

<label class="medium1">Diabetes
<input  type="checkbox" name="diabetes" value="y"   validate="Diabetes,string,no" tabindex="1" class="checkboxMargin" /> 
</label>

<label class="medium1">Cardiac
<input  type="checkbox" name="cardiac" value="y" validate="Cardiac,string,no" tabindex="1" class="checkboxMargin" /> 
</label>

<label class="medium1">Hepatic
<input  type="checkbox" name="hepatic" value="y"  validate="Hepatic,string,no" tabindex="1"class="checkboxMargin"  />
</label>

<label class="medium1">Renal
<input  type="checkbox" name="renal" value="y"   validate="Renal,string,no" tabindex="1" class="checkboxMargin" />
</label>

<label class="medium1">Others
<input  type="checkbox" name="othersPastHistory" class="checkboxMargin" id="othersPastHistory" value="y"
maxlength="1" validate="Others,string,no" tabindex="1" onclick="displayOtherVal(this)"/>
</label>
<input type="text"  id="othersPast"  name="othersPastHistoryValue" value="" style="display: none" maxlength="45" validate="othersPastHistoryValue,string,no"/>

<div class="clear"></div>
<label>History of Epistaxis</label>
<select  name="historyOfEpistaxis" class="widthSec">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>

<label>Family History of Leprosy</label>
<select  name="familyHistoryLeprosy"  onchange="displayRelationLeprosyDetail(this.value)" class="widthSec">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div class="clear"></div>

<div id="familyHistoryDiv" class="tableRightfixHide">
<input type="button" class="buttonAdd"  tabindex="1" value="&nbsp;" onclick="addFamilyHistoryRelation();" />
<input type="button" class="buttonDel" tabindex="1"  value="&nbsp;" onclick="removeFamilyHistory();" />
<div class="clear"></div>
<div class="cmnTable tableRightfix">
<table border="0"  cellpadding="0" cellspacing="0" id="familyHistoryGrid" >
<tr> 
<th></th>
<th>Relation</th>
<th>Leprosy Type</th>
</tr> 
<%int k = 1; %>
<tr>
<td><input type="checkbox" name="srNo<%=k %>" id="srNo" value="1" class="radioCheck" /></td>
<td><select name="relation<%=k %>" id="relation<%=k %>" onchange="displayFamilyHistoryLeprosyOther(<%=k %>);" >
<option value="">Select</option>	
<option value="Mother">Mother</option>
<option value="Father">Father</option>
<option value="Son">Son</option>
<option value="Daughter">Daughter</option>
<option value="Uncle">Uncle</option>
<option value="Aunt">Aunt</option>
<option value="Grand Father">Grand Father</option>
<option value="Grand Mother">Grand Mother</option>
<option value="Others">Others</option>
</select>
<input type="text" name="familyHistoryLeprosyOthers<%=k %>" id="familyHistoryLeprosyOthers<%=k %>"  maxlength="128" style="display:none"></input>
</td>
<td><select name="leprosyType<%=k %>" id = "leprosyType<%=k %>">
<option value="">Select</option>
<option value="PB">PB</option>
<option value="MB">MB</option>
<option value="I">I</option>
<option value="TT">TT</option>
<option value="BT">BT</option>
<option value="BB">BB</option>
<option value="BL">BL</option>
<option value="LL">LL</option>
<option value="PN">PN</option>
</select>
</td>
</tr>
</table>
<div class="clear"></div>
</div>
<input type="hidden" name="familyHistoryCount" id="familyHistoryCount" value="1" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label class="lblWidth235">Total no. of family members affected</label>
<select  name="noOfFamilyAffected" class="widthSec" class="widthSec">
<option value="">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<!-- <option value="3">3</option> -->
<option value='3>'>3&gt;</option>
</select>

<label class="auto">History of leprosy in neighbours</label>
<select class="widthSec"  name="historyOfLeprosyInNeighbours" id="historyOfLeprosyInNeighbours" onchange="displayLeprosyNeighboursValue(this.value)">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div style="display: none" id="leprosyNeighboursValueDiv">
<input  type="text" name="leprosyNeighboursValue" id="leprosyNeighboursValue" value="" maxlength="128" style="margin-left: 4px;" validate="History of leprosy in neighbours Value,string,no" tabindex="1"/>
</div>
<div class="clear"></div>
<label class="lblWidth235">Previous History of treatment of leprosy</label>
<select  name="previousHistoryOfLeprosy" onchange="selectPreviousHistory(this.value);" class="widthSec">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div style="display: none" id="leprosyTypeDiv">
<label style="width:187px;">Leprosy Type</label>
<select  name="previousHistoryOfLeprosyValue" class="widthSec">
<option value="">Select</option>
<option value="PB">PB</option>
<option value="MB">MB</option>
<option value="I">I</option>
<option value="TT">TT</option>
<option value="BT">BT</option>
<option value="BB">BB</option>
<option value="BL">BL</option>
<option value="LL">LL</option>
<option value="PN">PN</option>
</select>
</div>

<h4>General Examination</h4>

<label class="medium">Pallor</label>
<label class="auto">Yes
<input type="radio" name="pallor" class="checkboxMargin" id="pallor" value="Yes"/>
</label>
<label class="auto">No
<input type="radio" name="pallor" checked="checked" class="checkboxMargin" id="pallor" value="No"/> 
</label>

<label class="medium">Jaundice</label>
<label class="auto">Yes
<input type="radio" name="jaundice" class="checkboxMargin" id="jaundice" value="Yes"/>
</label>
<label class="auto">No
<input type="radio" name="jaundice" checked="checked" class="checkboxMargin" id="jaundice" value="No"/> 
</label>


<label class="medium">Cyanosis</label>
<label class="auto">Yes
<input type="radio" name="cyanosis" class="checkboxMargin" id="cyanosis" value="Yes"/>
</label>
<label class="auto">No
<input type="radio" name="cyanosis" checked="checked" class="checkboxMargin" id="cyanosis" value="No"/> 
</label>
<!-- 
<div class="clear"></div> -->

<label class="auto">Lymphadenopathy</label>
<label class="auto">Yes
<input type="radio" name="lymphadenopathy" class="checkboxMargin" id="lymphadenopathy" value="Yes"/> 
</label>
<label class="auto">No
<input type="radio" name="lymphadenopathy" checked="checked" class="checkboxMargin" id="lymphadenopathy" value="No"/> 
</label>

<label class="medium">Edema</label>
<label class="auto">Yes
<input type="radio" name="edema" class="checkboxMargin" id="edema" value="Yes"/> 
</label>
<label class="auto">No
<input type="radio" name="edema" checked="checked" class="checkboxMargin" id="edema" value="No"/>
</label>

<div class="clear"></div>
<h4 style="padding-bottom: 0;">Vitals</h4>
<div class="clear"></div>
<div style="margin-top:0;" class="divisionSolid"></div>
<label class="auto">Pulse</label> <input
						class="textYellow allownumericwithoutdecimal widthFixed26"
						tabindex="13" name="pulseTemp" type="text" id="pulseTemp"
						maxlength="3"
						value="" onblur="setVitalValue(this.value,'pulse')" onkeypress="return isNumberDecimal(event)"/> <label
						class="smallAuto">min</label> <label class="auto">Temperature</label>
						<input class="textYellow allownumericwithdecimal textSmall" validate="temperature,float,no"
						name="leprosyTemperature" id="leprosyTemperature" type="text" maxlength="5" onkeypress="return isNumber(event)"
						value="" tabindex="14" onblur="setVitalValue(this.value,'temperature')"/> <label
						class="smallAuto">&deg;F</label>
						<label class="auto" id="bpLabel">BP</label> <input
						name="systolicTemp" id="systolicTemp" tabindex="14" placeholder="Systolic / Diastolic"
						value="" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal widthFixed26" onblur="commonDiastolicSystolic1();setVitalValue(this.value,'systolic')" onkeypress="return isNumber(event)"/> <label
						id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
						<input name="diastolicTemp" id="diastolicTemp" tabindex="16"
						placeholder="Diastolic"
						value="" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal widthFixed26" onblur="commonDiastolicSystolic1();setVitalValue(this.value,'diastolic')" onkeypress="return isNumber(event)" /></span>  
						<label class="smallAuto">mm&nbsp;Hg</label> 
						
						<label class="auto">Height</label>
						<input	name="leprosyHeight" id="leprosyHeight" onkeypress="return isNumberDecimal(event)" type="text"  maxlength="3" class="allownumericwithoutdecimal textSmall"  value="" onblur="calculateleprosyBMI();setVitalValue(this.value,'height')" tabindex="17"/>
						<label	class="smallAuto">&nbsp;cm</label>
						
						<label class="auto">Weight</label>
						<input name="leprosyWeight"  onkeypress="return isNumber(event)" id="leprosyWeight" type="text" maxlength="6"  class="allownumericwithdecimal textSmall"  value="" onblur="calculateleprosyBMI();setVitalValue(this.value,'weight')" tabindex="18"/>
						<input name="headCircumference"  id="headCircumference" type="hidden" maxlength="6"  class="allownumericwithdecimal textSmall"  value="" tabindex="14"/>
						<label	class="smallAuto">Kg</label>
						
						<label class="auto" id="bpLabel">BMI</label>
						<input	name="leprosyBmi" id="leprosyBmi"  onkeypress="return isNumberDecimal(event)" type="text" value=""  readonly="readonly" class="textSmall" onblur="setVitalValue(this.value,'bmi')"/>
						<label class="smallAuto" style="min-width:17px;" id="leprosyBmiCat"></label>
						
	<label class="auto">Respiratory Rate</label>
	<input class="textYellow allownumericwithdecimal widthFixed26" onkeypress="return isNumberDecimal(event)" name="leprosyRespiratoryRate" id="leprosyRespiratoryRate" type="text" maxlength="3" value="" tabindex="12" onblur="setVitalValue(this.value,'respiratoryRate')"/>
	<label class="auto">Spo2</label>
	<input class="textYellow allownumericwithdecimal widthFixed26" onkeypress="return isNumberDecimal(event)" name="leprosySpo2" id="leprosySpo2" type="text" maxlength="3" value="" tabindex="12" onblur="setVitalValue(this.value,'spo2')"/>
<label	class="smallAuto">%</label>

<!-- <input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="pulseTemp" type="text" id="" validate="pulse,num,no" maxlength="3" value=""  /> 
<label class="smallAuto">min</label>

<label style="width:50px;" id="bpLabel">BP</label>
<input name="systolicTemp" id="systolicTemp" tabindex="14"  validate="systolic,int,no" type="text" maxlength="3" 
class="textYellow allownumericwithoutdecimal textSmall" />

<label id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
<input name="diastolicTemp" id="diastolicTemp" tabindex="15"  type="text" maxlength="3"
class="textYellow allownumericwithoutdecimal textSmall"  />
<label class="smallAuto">mm&nbsp;Hg</label>-->
<div class="divisionSolid"></div> 


<div class="clear"></div>

<h4>Dermatological Examination</h4>
<div class="LeprosyProformacmntable" style="width:1154px;">
<table border="0"  cellpadding="0" cellspacing="0"	id="lastUseGrid">
<tr> 
<th>Lesion</th>
<th>Ear lobe </th>
<th>Madarosis</th>
<th>Face</th>
<th>Upper limb</th>
<th>Anterior trunk</th>
<th>Posterior trunk</th>
<th>Lower limb</th>
</tr> 
<tr>
<td><input class="inpWdth130" type="hidden"  name="lesion1" id="maculeLesion"  value="Macule"/>Macule</td>
<td><input class="inpWdth130" type="text"  name="earLobe1" id="earLobe1"  value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="madarosis1" id="madarosis1"  value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="face1" id="face1"  value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="upperLimb1" id="upperLimb1" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="anteriorTrunk1" id="anteriorTrunk1" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="posteriorTrunk1" id="posteriorTrunk1"  value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="lowerLimb1" id="lowerLimb1" value=""  maxlength="128"/></td>
</tr>
<tr>
<td><input class="inpWdth130" type="hidden"  name="lesion2" id="lesion2"  value="Papule"/>Papule</td>
<td><input class="inpWdth130" type="text"  name="earLobe2" id="earLobe2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="madarosis2" id="madarosis2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="face2" id="face2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="upperLimb2" id="upperLimb2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="anteriorTrunk2" id="anteriorTrunk2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="posteriorTrunk2" id="posteriorTrunk2" value=""  maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="lowerLimb2" id="lowerLimb2" value=""  maxlength="128"/></td>
</tr>
<tr> 
<td><input class="inpWdth130" type="hidden"  name="lesion3" id="lesion3"  value="Plaque" maxlength="128"/>Plaque</td>
<td><input class="inpWdth130" type="text"  name="earLobe3" id="earLobe3" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="madarosis3" id="madarosis3" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="face3" id="face3" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="upperLimb3" id="upperLimb3"  value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="anteriorTrunk3" id="anteriorTrunk3" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="posteriorTrunk3" id="posteriorTrunk3" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="lowerLimb3" id="lowerLimb3" value="" maxlength="128"/></td>
</tr>
<tr> 
<td><input class="inpWdth130" type="hidden"  name="lesion4" id="lesion4"  value="Nodule"/>Nodule</td>
<td><input class="inpWdth130" type="text"  name="earLobe4" id="earLobe4" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="madarosis4" id="madarosis4" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="face4" id="face4" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="upperLimb4" id="upperLimb4"  value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="anteriorTrunk4" id="anteriorTrunk4" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="posteriorTrunk4" id="posteriorTrunk4" value="" maxlength="128"/></td>
<td><input class="inpWdth130" type="text"  name="lowerLimb4" id="lowerLimb4" value="" maxlength="128"/></td>
</tr>
</table>
</div>
<%-- <!-- ------Lab Examination--------- -->
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTabForLabResultDermoLeprosy('Lab Result Leprosy')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab" style="font-size:15px;">Lab Result</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="labResultLeprosy" class="collapasHide" style="width:1158px;">
<div class="indArrow"></div>
<div class="Block">
			<div class="clear"></div>
			
			<%if(labResultForLeprosyPerformaList.size()>0){ %>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet1">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="labResultFirstTrimester">
							<tr>
								<th>Investigation</th>
								<th>Resul Date</th>
								<th>Result</th>
							</tr>
							<%
								boolean flag = false;
								int OrderId = 0; 
								for(DgResultEntryHeader dgResultEntry :labResultForLeprosyPerformaList){
									DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
									 if (dgResultEntry.getDgResultEntryDetails().size() > 0) {
										flag = true;
										dgResultEntryDetail = dgResultEntry.getDgResultEntryDetails().iterator().next();
										OrderId = (Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId();
									} 
									
								%>
							<tr>
							<td><%=dgResultEntry.getInvestigation().getInvestigationName() %></td>
							<td><%=HMSUtil.convertDateToStringWithoutTime(dgResultEntry.getResultDate()) %></td>
							<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=OrderId%>','<%=dgResultEntry.getInvestigation().getId()%>');">Lab Results</a></td>
							</tr>
						<%} %>	
						</table>
						
					</div>
				</div>
				<%}else{ %>
						<span>No Record Found</span>
						<%} %>
</div>			
</div>
<!-- ------Lab Examination End--------- --> --%>



<div class="clear"></div>
<h4>Other Sites</h4>

<label class="medium">Palms
<input  type="checkbox" name="palms" value="y" validate="Palms,string,no" tabindex="1" class="checkboxMargin" />
</label>

<label class="medium">Soles
<input  type="checkbox" name="soles" value="y" validate="Soles,string,no" tabindex="1" class="checkboxMargin" />
</label>

<label class="medium">Scalp
<input  type="checkbox" name="scalp" value="y" validate="Scalp,string,no" tabindex="1" class="checkboxMargin" />
</label>

<label>Mucous Membrane
<input  type="checkbox" name="mucousMembrane" value="y" validate="Mucous Membrane,string,no" tabindex="1" class="checkboxMargin" onclick="mucousMembraneValue(this)"/>
</label>

<div id="otherSitesValueDiv" style="display: none;">
<select  name="otherSitesValue" id="otherSitesValue" >
<option value="">Select</option>
<option value="Eye">Eye</option>
<option value="Oral">Oral</option>
<option value="Nasal">Nasal</option>
<option value="Genital">Genital</option>
</select>
</div>
<div class="clear"></div>

<!-- <label>Lepra Reaction</label>
<select  name="lepraReaction" style="width:154px;" onclick="selectLepraReaction(this.value)" >
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent" selected="selected">Absent</option>
</select>
<div id="lepraReactionValueDiv" style="display: none">

<label class="medium">Type I
<input type="radio" name="lepraReactionValue" class="checkboxMargin" id="lepraReactionValue" value="Type I"/> onclick="selectLepraReactionParameter(this.value)"
</label>

<label class="medium">Type II
<input type="radio" name="lepraReactionValue" class="checkboxMargin" id="lepraReactionValue" value="Type II"  /> onclick="selectLepraReactionParameter(this.value)"
</label>

<label class="medium">No
<input type="radio" name="lepraReactionValue"  class="checkboxMargin" id="lepraReactionValue" value="NO" checked="checked"  />  onclick="selectLepraReactionParameter(this.value)"  

</label>
<textarea type="text" name="lepraReactionParameterValue" id="lepraReactionParameterValue"   maxlength="256" class="historyAutoComplete" style="width:264px;overflow-x:hidden;resize:vertical;" ></textarea>
  
</div>
<div id="lepraReactionParameterValueDiv" style="display: none">
<textarea type="text" name="lepraReactionParameterValue" id="lepraReactionParameterValue" maxlength="256" class="historyAutoComplete" style="width:264px;overflow-x:hidden;resize:vertical;"></textarea>
</div> -->



<label>Lepra Reaction</label>
<label class="medium">Type I
<input type="radio" name="lepraReactionValue" class="checkboxMargin" id="lepraReactionValue" value="Type I"/>  
</label>

<label class="medium">Type II
<input type="radio" name="lepraReactionValue" class="checkboxMargin" id="lepraReactionValue" value="Type II"  /> 
</label>

<label class="medium">No
<input type="radio" name="lepraReactionValue"  class="checkboxMargin" id="lepraReactionValue" value="NO" checked="checked"  />  
</label>
<textarea type="text" name="lepraReactionParameterValue" id="lepraReactionParameterValue"   maxlength="256" class="historyAutoComplete" style="width:264px;overflow-x:hidden;resize:vertical;" ></textarea>

 <!-- <label>Sensory Examination</label> 
 <textarea rows="" cols="" name ="sensoryExamination" class="large" ></textarea>  -->

<!-- <h4>On lesion</h4>
<label class="auto">Temperature</label>
<input  type="checkbox" name="temperatureW" value="y"  maxlength="1" validate="Temperature,string,no" tabindex="1"  />
<label class="auto">Touch</label>
<input  type="checkbox" name="touchW" value="y"  maxlength="1" validate="Touch,string,no" tabindex="1"  />
<label class="auto">Pain</label>
<input  type="checkbox" name="painW" value="y"  maxlength="1" validate="Pain,string,no" tabindex="1" style="margin-right:20px;" />
<input  type="text" name="onLesionValue" value=""  maxlength="100" validate="On Lesion,string,no" tabindex="1"  /> -->

<div class="clear"></div> 
<div class="divisionSolid"></div>
<div class="clear"></div> 	

<div class="cmnTable cmnWdth">
<h4>Sensory Examination</h4>  
<div class="clear"></div>
<input type="button" class="buttonAdd"  tabindex="1"	value="&nbsp;" onclick="addSensoryExamination();" />
<input type="button" class="buttonDel" tabindex="1"  value="&nbsp;" onclick="removeSensoryExamination();" />
<div class="clear"></div>

<table border="0"  cellpadding="0" cellspacing="0"	id="sensoryGrid">
<tr> 
<th></th>
<th>Site</th>
<th>Temperature</th>
<th>Touch</th>
<th>Pain</th>

</tr> 
<%int j = 1; %>
<tr>
<td><input type="checkbox" name="srNo<%=j %>" id="srNo<%=j %>" value="1" class="radioCheck" /></td>
<td><select name="site<%=j %>" id="site<%=j %>">
<option value="">Select</option>	
<option value="Face">Face</option>
<option value="Upper Limb">Upper Limb</option>
<option value="Anterior Trunk">Anterior Trunk</option>
<option value="Posterior Trunk">Posterior Trunk</option>
<option value="Lower Limb">Lower Limb</option>
</select></td>
<td><input type="checkbox" name="temperature<%=j %>" id="temperature" value="1" class="radioCheck" /></td>
<td><input type="checkbox" name="touch<%=j %>" id="touch" value="1" class="radioCheck" /></td>
<td><input type="checkbox" name="pain<%=j %>" id="pain" value="1" class="radioCheck" /></td>
</tr>
</table>
<input type="hidden" name="sensoryCount" id="sensoryCount" value="1" />
<div class="clear"></div>
<div class="paddingTop5"></div>

<label style="width:183px;">Glove and stocking anesthesia</label>
<select  name="gloveAndStockingAnesthesia" id = "gloveAndStockingAnesthesia" onchange="selectGloveAndStockingAnesthesia(this.value)" class="medium2">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div id="gloveAndStockingAnesthesiaValueDiv" style="display: none;">
<input  type="text" name="gloveAndStockingAnesthesiaValue" id="gloveAndStockingAnesthesiaValue" value=""  maxlength="100" validate="Glove and stocking anesthesia,string,no" tabindex="1" />
</div>
<div class="clear"></div>
<label style="width:183px;">Plantar Ulcer</label>
<select  name="plantarUlcer" onchange="selectPlantarUlcer(this.value)" class="medium2">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div id="plantarUlcerValueDiv" style="display: none;">
<input  type="text" name="plantarUlcerValue" id="plantarUlcerValue" value=""  maxlength="100" validate="Plantar Ulcer,string,no" tabindex="1" />
</div>

</div>

<div class="cmnWdthRight">

<div class="clear"></div>
<h4>Peripheral Nerve Examination</h4>
<input type="button" class="buttonAdd"  tabindex="1"	value="&nbsp;" onclick="addRowForPeripheralNerve();" />
<input type="button" class="buttonDel" tabindex="1"  value="&nbsp;" onclick="removeRowForPeripheralNerve();" />
<div class="clear"></div>
<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="peripheralNerveGrid">
<tr> 
<th></th>
<th>Nerve</th>
<th>Right</th>
<th>Left</th>

</tr> 
<%int i = 1; %>
<tr>
<td><input type="checkbox" name="srNo<%=i %>" id="srNo<%=i %>" value="1" class="radioCheck" /></td>
<td><select name="nerve<%=i %>">
<option value="">Select</option>	
<option value="Supraorbital">Supraorbital</option>
<option value="Supratrochlear">Supratrochlear</option>
<option value="Infraorbital">Infraorbital</option>
<option value="Infratrochlear">Infratrochlear</option>
<option value="Greater auricular">Greater auricular</option>
<option value="Transverse cervical">Transverse cervical</option>
<option value="Supraclavicular">Supraclavicular</option>
<option value="Radial">Radial</option>
<option value="Ulnar">Ulnar</option>
<option value="Median">Median</option>
<option value="Radial cutaneous">Radial cutaneous</option>
<option value="Common peroneal">Common peroneal</option>
<option value="Superficial peroneal">Superficial peroneal</option>
<option value="Sural">Sural</option>
<option value="Saphenous">Saphenous</option>
<option value="Tibial">Tibial</option>
<option value="Perilesional Nerve Twigs">Perilesional Nerve Twigs</option>

</select></td>
<td><input  type="text"  name="rightNerve<%=i %>" id="rightNerve" maxlength="50"/></td>
<td><input  type="text"  name="leftNerve<%=i %>" id="leftNerve" maxlength="50"/></td>
</tr>

</table>
</div>
<div class="clear"></div>
<input type="hidden" name="nerveCount" id="nerveCount" value="1" />
<div class="clear"></div>
</div>
 
 <div class="clear"></div> 
<div class="divisionSolid"></div>
<div class="clear"></div> 
 
 <div class="tblLeftDiv">
 <h4>Deformity</h4> 
<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	id="lastUseGrid">
<tr> 

<th>Site</th>
<th>Right</th>
<th>Grade</th>
<th>Left</th>
<th>Grade</th>
</tr> 

<tr>
<td>Hand<input  type="hidden"  name="siteHand" id="siteHand" value="Hand" /></td>
<td><input  type="text"  name="rightHand" id="rightHand" value="" maxlength="30"/></td>
<td>

<!-- <input  type="text"  name="rightHandGrade" id="rightHandGrade" value="" value="30"/> -->

<select  name="rightHandGrade" id="rightHandGrade" class="small" >
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>
<td><input  type="text"  name="leftHand" id="leftHand" value="" maxlength="30"/></td>
<td>

<!-- <input  type="text"  name="leftHandGrade" id="leftHandGrade" value="" value="30"/> -->

<select  name="leftHandGrade" id="leftHandGrade" class="small">
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>

</tr>
<tr>
<td>Foot<input  type="hidden"  name="siteFoot" id="siteFoot" value="Foot"/></td>
<td><input  type="text"  name="rightFoot" id="rightFoot" value="" maxlength="30"/></td>
<td><!-- <input  type="text"  name="rightFootGrade" id="rightFootGrade" value="" value="30"/> -->


<select  name="rightFootGrade" id="rightFootGrade" class="small">
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>
<td><input  type="text"  name="leftFoot" id="leftFoot" value=""  maxlength="30" /></td>
<td><!-- <input  type="text"  name="leftFootGrade" id="leftFootGrade" value="" value="30"/> -->

<select  name="leftFootGrade" id="leftFootGrade" class="small">
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>

</tr>
<tr> 
<td>Eyes<input  type="hidden"  name="siteEyes" id="siteEyes" value="Eyes" /></td>
<td><input  type="text"  name="rightEyes" id="rightEyes"  value="" maxlength="30"/></td>
<td><!-- <input  type="text"  name="rightEyesGrade" id="rightEyesGrade"  value="" value="30"/> -->

<select  name="rightEyesGrade" id="rightEyesGrade" class="small">
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>
<td><input  type="text"  name="leftEyes" id="leftEyes" value="" maxlength="30"/></td>
<td><!-- <input  type="text"  name="leftEyesGrade" id="leftEyesGrade" value="" value="30" /> -->
<select  name="leftEyesGrade" id="leftEyesGrade" class="small">
<option value="">Select</option>
<option value="0">0</option>
<option value="I">I</option>
<option value="II">II</option>
</select>
</td>
</tr>
</table>
</div>
</div>



<div class="tblRightDiv">
<h4>Smear Examination</h4> 
<div class="cmnTable">
<table border="0"  cellpadding="0" cellspacing="0"	>
<tr> 

<th>Site</th>
<th>Morphological index(%)</th>
<th>Bacterial index</th>

</tr> 

<tr>
<td>Ear lobe<input  type="hidden"  name="siteEarlobe" id="siteEarlobe" value="Ear lobe" /></td>
<td><input  type="text"  name="morphologicalEarlobe" id="morphologicalEarlobe"  maxlength="30" value=""/></td>
<td><input  type="text"  name="bacterialEarlobe" id="bacterialEarlobe" value="" maxlength="30"/></td>
</tr>

<tr>
<td>Skin lesion<input  type="hidden"  name="siteSkinlesion" id="siteSkinlesion" value="Skin lesion" /></td>
<td><input  type="text"  name="morphologicalSkinlesion" id="morphologicalSkinlesion"  maxlength="30"  value=""/></td>
<td><input  type="text"  name="bacterialSkinlesion" id="bacterialSkinlesion" value="" maxlength="30"/></td>
</tr>

<tr>
<td>Normal Skin<input  type="hidden"  name="siteNormallesion" id="siteNormallesion" value="Normal lesion" /></td>
<td><input  type="text"  name="morphologicalNormallesion" id="morphologicalNormallesion"  maxlength="30" value=""/></td>
<td><input  type="text"  name="bacterialNormallesion" id="bacterialNormallesion" value="" maxlength="30"/></td>
</tr>

</table>
</div>

</div>


<div class="clear"></div>
  <div class="paddingTop5"></div>
  <label>Relapse</label>
  <select  name="relapse" onchange="displayRelapseType(this.value);" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div style="display: none" id="relapseTypeDiv">
<label>Type of Relapse</label>
  <select  name="typeOfRelapse" >
<option value="">Select</option>
<option value="PB">PB</option>
<option value="MB">MB</option>
</select>
</div>
<div class="clear"></div>
<label>Any Other Remarks</label>
<textarea rows="" cols="" name ="otherRemarks" maxlength="200" style="width:550px;" class="large" onkeyup="return checkLength(this)"></textarea>
</div>
</form>


<style>
.tableRightfixHide{display:none; width:644px;float:left;}
.tableRightfix{ height:auto; /*min-height:68px; max-height:150px; overflow-x:hidden;overflow:auto; */}
.lblWidth235{width:235px;}
.cmnWdth{width:577px; float:left;}
.cmnWdthRight{width:570px;margin-left:14px; float:left;}
.tblLeftDiv{width:580px; float:left;}
.tblRightDiv{width:568px; float:left; margin-left:14px;}
input.widthFixed26 {width:26px;}

.LeprosyProformacmntable table td input.inpWdth130{width:130px;}

</style>
