<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOrthopedicSpeciality"%>


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
Map<String, Object> map = new HashMap<String, Object>();
//OpdOrthopedicSpeciality opdOrthopedicSpeciality = new OpdOrthopedicSpeciality();
List<OpdOrthopedicSpeciality>opdOrthopedicSpeciality = new ArrayList<OpdOrthopedicSpeciality>();
map = (Map) request.getAttribute("map");
if (map.size()>0) {
		
		  if (map.get("opdOrthopedicSpecList") != null)
	       {
			  opdOrthopedicSpeciality = (List<OpdOrthopedicSpeciality>) map.get("opdOrthopedicSpecList");	
	       }
		}
int orthoRecId=0;
String [] modeOfInjuries=null;
String [] modeOfInjuryValues=null;
String upperLimbSelection="";
String upperLimbLengthUnit = "";
String natureOfInjuryOtherValue="";
String neckValue="";
String midbackValue="";
String girdleValue="";
String lowbackValue="";
String hip="";
String hipValue="";
String hipValueAnother = "";

String sacroiliac="";
String sacroiliacValue="";
String sacroiliacValueAnother = "";

String pelvis="";
String pelvisValue="";
String pelvisValueAnother = "";

String thigh="";
String thighValue="";
String thighValueAnother = "";

String knee="";
String kneeValue="";
String kneeValueAnother = "";

String leg="";
String legValue="";
String legValueAnother = "";

String ankle="";
String ankleValue="";
String ankleValueAnother = "";

String foot="";
String footValue="";
String footValueAnother = "";

String shoulder="";
String shoulderValue="";
String shoulderValueAnother = "";

String interscapular="";
String interscapularValue="";
String interscapularValueAnother = "";

String arm="";
String armValue="";
String armValueAnother = "";

String elbow="";
String elbowValue="";
String elbowValueAnother = "";

String forearm="";
String forearmValue="";
String forearmValueAnother = "";

String wrist="";
String wristValue="";
String wristValueAnother = "";

String hand="";
String handValue="";
String handValueAnother = "";

String upperLimbValue = "";
String rightUpperLimbValue = "";
int upperLimbLength = 0;
String upperLimbDiscrepancy="";
String upperLimbOther = "";

String  lowerLimbSelection="";
String rightLowerLimbValue = "";
String lowerLimbValue = "";
int lowerLimbLength = 0;
String lowerLimbLengthUnit = "";
String lowerLimbDiscrepancy="";
String lowerLimbOther = "";

String natureOfDiscomfort = "";
String occupationalHistory = "";
String constitutionalSymptoms = "";
String treatmentHistory = "";
String developmentalHistory = "";
String developmentalMilestones = "";
String perinatalAntenatalHistory = "";

String painValue = "";
String siteValue = "";
String natureOfPain = "";
String radiationValue = "";
String exacerbatingFactor = "";
String relievingFactor = "";

String stiffness = "";
String stiffnessValue = "";
String morningStiffness = "";
String morningStiffnessvalue = "";
String weakness = "";
String weaknessValue = "";
String inabilityToUseALimb = "";
String inabilityToUseALimbValue = "";
String disabilityInUsingALimb = "";
String disabilityInUsingALimbValue = "";
String swelling = "";
String swellingValue = "";

String swellingLocalEx = "";
String swellingSite = "";
String swellingNatureOfGrowth = "";
String swellingSize = "";
String swellingSurface = "";
String swellingShape = "";
String swellingConsistency = "";
String planeOfTheSwelling = "";
String natureOfGrowthValue = "";
String remarksForSwelling = "";




if(opdOrthopedicSpeciality.size() > 0)
{
orthoRecId = opdOrthopedicSpeciality.get(0).getId();	
if(opdOrthopedicSpeciality.get(0).getNatureOfInjury()!= null  ){
modeOfInjuries = opdOrthopedicSpeciality.get(0).getNatureOfInjury().split(",");
}

if(opdOrthopedicSpeciality.get(0).getNatureOfInjuryValue()!= null  ){
modeOfInjuryValues = opdOrthopedicSpeciality.get(0).getNatureOfInjuryValue().split("\\^");
}

natureOfInjuryOtherValue = opdOrthopedicSpeciality.get(0).getNatureOfInjuryOthers()!=null ? opdOrthopedicSpeciality.get(0).getNatureOfInjuryOthers():"";
neckValue = opdOrthopedicSpeciality.get(0).getNeck()!= null ? opdOrthopedicSpeciality.get(0).getNeck():"";
midbackValue = opdOrthopedicSpeciality.get(0).getMidBack()!= null ? opdOrthopedicSpeciality.get(0).getMidBack():"";
girdleValue = opdOrthopedicSpeciality.get(0).getGirdle()!= null ?opdOrthopedicSpeciality.get(0).getGirdle():"";
lowbackValue = opdOrthopedicSpeciality.get(0).getLowBack()!= null ? opdOrthopedicSpeciality.get(0).getLowBack():"";
hip = opdOrthopedicSpeciality.get(0).getHip()!= null ? opdOrthopedicSpeciality.get(0).getHip():"";
hipValue = opdOrthopedicSpeciality.get(0).getHipValue()!= null ? opdOrthopedicSpeciality.get(0).getHipValue():"";
hipValueAnother = opdOrthopedicSpeciality.get(0).getHipValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getHipValueAnother():"";
sacroiliac = opdOrthopedicSpeciality.get(0).getSacroiliac()!=null ? opdOrthopedicSpeciality.get(0).getSacroiliac():"";
sacroiliacValue = opdOrthopedicSpeciality.get(0).getSacroiliacValue()!=null ? opdOrthopedicSpeciality.get(0).getSacroiliacValue():"";
sacroiliacValueAnother = opdOrthopedicSpeciality.get(0).getSacroiliacValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getSacroiliacValueAnother():"";
pelvis = opdOrthopedicSpeciality.get(0).getPelvis()!=null ? opdOrthopedicSpeciality.get(0).getPelvis():"";
pelvisValue = opdOrthopedicSpeciality.get(0).getPelvisValue()!=null ? opdOrthopedicSpeciality.get(0).getPelvisValue():"";
pelvisValueAnother = opdOrthopedicSpeciality.get(0).getPelvisValueAnother()!= null ? opdOrthopedicSpeciality.get(0).getPelvisValueAnother():"";
thigh = opdOrthopedicSpeciality.get(0).getThigh()!=null ? opdOrthopedicSpeciality.get(0).getThigh():"";
thighValue = opdOrthopedicSpeciality.get(0).getThighValue()!= null ? opdOrthopedicSpeciality.get(0).getThighValue():"";
thighValueAnother = opdOrthopedicSpeciality.get(0).getThighValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getThighValueAnother():"";

knee = opdOrthopedicSpeciality.get(0).getKnee()!=null ? opdOrthopedicSpeciality.get(0).getKnee():"";
kneeValue = opdOrthopedicSpeciality.get(0).getKneeValue()!=null ? opdOrthopedicSpeciality.get(0).getKneeValue():"";
kneeValueAnother = opdOrthopedicSpeciality.get(0).getKneeValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getKneeValueAnother():"";

leg = opdOrthopedicSpeciality.get(0).getLeg()!= null ? opdOrthopedicSpeciality.get(0).getLeg():"";
legValue = opdOrthopedicSpeciality.get(0).getLegValue()!=null ? opdOrthopedicSpeciality.get(0).getLegValue():"";
legValueAnother = opdOrthopedicSpeciality.get(0).getLegValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getLegValueAnother():"";

ankle = opdOrthopedicSpeciality.get(0).getAnkle()!=null ? opdOrthopedicSpeciality.get(0).getAnkle():"";
ankleValue = opdOrthopedicSpeciality.get(0).getAnkleValue()!=null ? opdOrthopedicSpeciality.get(0).getAnkleValue():"";
ankleValueAnother = opdOrthopedicSpeciality.get(0).getAnkleValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getAnkleValueAnother():"";

foot = opdOrthopedicSpeciality.get(0).getFoot()!=null ? opdOrthopedicSpeciality.get(0).getFoot():"";
footValue = opdOrthopedicSpeciality.get(0).getFootValue()!=null ? opdOrthopedicSpeciality.get(0).getFootValue():"";
footValueAnother = opdOrthopedicSpeciality.get(0).getFootValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getFootValueAnother():"";

shoulder = opdOrthopedicSpeciality.get(0).getShoulder()!=null ? opdOrthopedicSpeciality.get(0).getShoulder():"";
shoulderValue = opdOrthopedicSpeciality.get(0).getShoulderValue()!=null ? opdOrthopedicSpeciality.get(0).getShoulderValue():"";
shoulderValueAnother = opdOrthopedicSpeciality.get(0).getShoulderValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getShoulderValueAnother():"";

interscapular = opdOrthopedicSpeciality.get(0).getInterscapular()!=null ? opdOrthopedicSpeciality.get(0).getInterscapular():"";
interscapularValue = opdOrthopedicSpeciality.get(0).getInterscapularValue()!=null ? opdOrthopedicSpeciality.get(0).getInterscapularValue():"";
interscapularValueAnother = opdOrthopedicSpeciality.get(0).getInterscapularValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getInterscapularValueAnother():"";

arm = opdOrthopedicSpeciality.get(0).getArm()!=null ? opdOrthopedicSpeciality.get(0).getArm():"";
armValue = opdOrthopedicSpeciality.get(0).getArmValue()!=null ? opdOrthopedicSpeciality.get(0).getArmValue():"";
armValueAnother = opdOrthopedicSpeciality.get(0).getArmValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getArmValueAnother():"";

elbow = opdOrthopedicSpeciality.get(0).getElbow()!=null ? opdOrthopedicSpeciality.get(0).getElbow():"";
elbowValue = opdOrthopedicSpeciality.get(0).getElbowValue()!=null ? opdOrthopedicSpeciality.get(0).getElbowValue():"";
elbowValueAnother = opdOrthopedicSpeciality.get(0).getElbowValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getElbowValueAnother():"";

forearm = opdOrthopedicSpeciality.get(0).getForearm()!=null ? opdOrthopedicSpeciality.get(0).getForearm():"";
forearmValue = opdOrthopedicSpeciality.get(0).getForearmValue()!=null ? opdOrthopedicSpeciality.get(0).getForearmValue():"";
forearmValueAnother = opdOrthopedicSpeciality.get(0).getForearmValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getForearmValueAnother():"";

wrist = opdOrthopedicSpeciality.get(0).getWrist()!=null ? opdOrthopedicSpeciality.get(0).getWrist():"";
wristValue = opdOrthopedicSpeciality.get(0).getWristValue()!=null ? opdOrthopedicSpeciality.get(0).getWristValue():"";
wristValueAnother = opdOrthopedicSpeciality.get(0).getWristValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getWristValueAnother():"";

hand = opdOrthopedicSpeciality.get(0).getHand()!=null ? opdOrthopedicSpeciality.get(0).getHand():"";
handValue = opdOrthopedicSpeciality.get(0).getHandValue()!=null ? opdOrthopedicSpeciality.get(0).getHandValue():"";
handValueAnother = opdOrthopedicSpeciality.get(0).getHandValueAnother()!=null ? opdOrthopedicSpeciality.get(0).getHandValueAnother():"";

if(opdOrthopedicSpeciality.get(0).getLimb() != null){
upperLimbSelection = opdOrthopedicSpeciality.get(0).getLimb();

upperLimbValue = opdOrthopedicSpeciality.get(0).getLimbValue()!=null ? opdOrthopedicSpeciality.get(0).getLimbValue():"";
rightUpperLimbValue= opdOrthopedicSpeciality.get(0).getRightUpperLimbValue()!=null ? opdOrthopedicSpeciality.get(0).getRightUpperLimbValue():"";
upperLimbLength = opdOrthopedicSpeciality.get(0).getLimbLength();
upperLimbLengthUnit = opdOrthopedicSpeciality.get(0).getUpperLimbLengthUnit();
upperLimbDiscrepancy = opdOrthopedicSpeciality.get(0).getDiscrepancy()!=null ? opdOrthopedicSpeciality.get(0).getDiscrepancy():"";
upperLimbOther = opdOrthopedicSpeciality.get(0).getAnyOther()!=null ? opdOrthopedicSpeciality.get(0).getAnyOther():"";
}

if(opdOrthopedicSpeciality.get(0).getLowerLimb() != null){
lowerLimbSelection=opdOrthopedicSpeciality.get(0).getLowerLimb();

lowerLimbValue = opdOrthopedicSpeciality.get(0).getLowerLimbValue()!=null ? opdOrthopedicSpeciality.get(0).getLowerLimbValue():"";
rightLowerLimbValue= opdOrthopedicSpeciality.get(0).getRightLowerLimbValue()!=null ? opdOrthopedicSpeciality.get(0).getRightLowerLimbValue():"";
lowerLimbLength = opdOrthopedicSpeciality.get(0).getLowerLimbLength();
lowerLimbLengthUnit = opdOrthopedicSpeciality.get(0).getLowerLimbLengthUnit();
lowerLimbDiscrepancy = opdOrthopedicSpeciality.get(0).getLowerDiscrepancy()!=null ? opdOrthopedicSpeciality.get(0).getLowerDiscrepancy():"";
lowerLimbOther = opdOrthopedicSpeciality.get(0).getLowerLimbAnyOther()!=null ? opdOrthopedicSpeciality.get(0).getLowerLimbAnyOther():"";
}

natureOfDiscomfort = opdOrthopedicSpeciality.get(0).getNameOfDiscomfort()!=null ? opdOrthopedicSpeciality.get(0).getNameOfDiscomfort():"";

occupationalHistory = opdOrthopedicSpeciality.get(0).getOccupationalHistory()!=null ? opdOrthopedicSpeciality.get(0).getOccupationalHistory():"";
constitutionalSymptoms = opdOrthopedicSpeciality.get(0).getConstitutionalSymptoms()!=null ? opdOrthopedicSpeciality.get(0).getConstitutionalSymptoms():"";
treatmentHistory = opdOrthopedicSpeciality.get(0).getTreatmentHistory()!=null ? opdOrthopedicSpeciality.get(0).getTreatmentHistory():"";
developmentalHistory = opdOrthopedicSpeciality.get(0).getDevelopmentHistory()!=null ? opdOrthopedicSpeciality.get(0).getDevelopmentHistory():"";
developmentalMilestones = opdOrthopedicSpeciality.get(0).getDevelopmentMilestones()!=null ? opdOrthopedicSpeciality.get(0).getDevelopmentMilestones():"";
perinatalAntenatalHistory = opdOrthopedicSpeciality.get(0).getParinatalAndAntenatalHistory()!=null ? opdOrthopedicSpeciality.get(0).getParinatalAndAntenatalHistory():"";

painValue = opdOrthopedicSpeciality.get(0).getPain()!=null ? opdOrthopedicSpeciality.get(0).getPain():"";
siteValue = opdOrthopedicSpeciality.get(0).getSite()!=null ? opdOrthopedicSpeciality.get(0).getSite():"";
natureOfPain = opdOrthopedicSpeciality.get(0).getNatureOfPain()!=null ? opdOrthopedicSpeciality.get(0).getNatureOfPain():"";
radiationValue = opdOrthopedicSpeciality.get(0).getRadition()!=null ? opdOrthopedicSpeciality.get(0).getRadition():"";
exacerbatingFactor = opdOrthopedicSpeciality.get(0).getExacerbatingFactor()!=null ? opdOrthopedicSpeciality.get(0).getExacerbatingFactor():"";
relievingFactor = opdOrthopedicSpeciality.get(0).getRelievingFactor()!=null ? opdOrthopedicSpeciality.get(0).getRelievingFactor():"";

stiffness = opdOrthopedicSpeciality.get(0).getStiffness()!=null ? opdOrthopedicSpeciality.get(0).getStiffness():"";
stiffnessValue = opdOrthopedicSpeciality.get(0).getStiffnessValue()!=null ? opdOrthopedicSpeciality.get(0).getStiffnessValue():"";
morningStiffness = opdOrthopedicSpeciality.get(0).getMorningStiffness()!=null ? opdOrthopedicSpeciality.get(0).getMorningStiffness():"";
morningStiffnessvalue = opdOrthopedicSpeciality.get(0).getMorningStiffnessValue()!=null ? opdOrthopedicSpeciality.get(0).getMorningStiffnessValue():"";
weakness = opdOrthopedicSpeciality.get(0).getWeakness()!=null ? opdOrthopedicSpeciality.get(0).getWeakness():"";
weaknessValue = opdOrthopedicSpeciality.get(0).getWeaknessValue()!=null ? opdOrthopedicSpeciality.get(0).getWeaknessValue():"";
inabilityToUseALimb = opdOrthopedicSpeciality.get(0).getInabilityToUseALimb()!=null ? opdOrthopedicSpeciality.get(0).getInabilityToUseALimb():"";
inabilityToUseALimbValue = opdOrthopedicSpeciality.get(0).getInabilityToUseLimbValue()!=null ? opdOrthopedicSpeciality.get(0).getInabilityToUseLimbValue():"";
disabilityInUsingALimb = opdOrthopedicSpeciality.get(0).getDisabilityInUsingALimb()!=null ? opdOrthopedicSpeciality.get(0).getDisabilityInUsingALimb():"";
disabilityInUsingALimbValue = opdOrthopedicSpeciality.get(0).getDisabilityInUsingALimbValue()!=null ? opdOrthopedicSpeciality.get(0).getDisabilityInUsingALimbValue():"";
swelling = opdOrthopedicSpeciality.get(0).getSwelling()!=null ? opdOrthopedicSpeciality.get(0).getSwelling():"";
swellingValue = opdOrthopedicSpeciality.get(0).getSwellingValue()!=null ? opdOrthopedicSpeciality.get(0).getSwellingValue():"";

swellingLocalEx = opdOrthopedicSpeciality.get(0).getSwelling2()!=null ? opdOrthopedicSpeciality.get(0).getSwelling2():"";
swellingSite = opdOrthopedicSpeciality.get(0).getSite2()!=null ? opdOrthopedicSpeciality.get(0).getSite2():"";
swellingNatureOfGrowth = opdOrthopedicSpeciality.get(0).getNatureOfGrowth()!=null ? opdOrthopedicSpeciality.get(0).getNatureOfGrowth():"";
swellingSize = opdOrthopedicSpeciality.get(0).getSize()!=null ? opdOrthopedicSpeciality.get(0).getSize():"";
swellingSurface = opdOrthopedicSpeciality.get(0).getShape()!=null ? opdOrthopedicSpeciality.get(0).getShape():"";
swellingShape = opdOrthopedicSpeciality.get(0).getShape1()!=null ? opdOrthopedicSpeciality.get(0).getShape1():"";
swellingConsistency = opdOrthopedicSpeciality.get(0).getConsistency()!=null ? opdOrthopedicSpeciality.get(0).getConsistency():"";
planeOfTheSwelling = opdOrthopedicSpeciality.get(0).getPlaneOfSwelling()!=null ? opdOrthopedicSpeciality.get(0).getPlaneOfSwelling():"";
natureOfGrowthValue = opdOrthopedicSpeciality.get(0).getNatureOfGrowthValue()!=null ? opdOrthopedicSpeciality.get(0).getNatureOfGrowthValue():"";
remarksForSwelling = opdOrthopedicSpeciality.get(0).getRemarksForSwelling()!=null ? opdOrthopedicSpeciality.get(0).getRemarksForSwelling():"";

}

%>


<form  method="post" name="orthopedics">
<input type="hidden" name="orthoRecordId" id="orthoRecordId" value="<%=orthoRecId%>"/>
<div class="Block">
<h6>Orthopedic</h6>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>


<label>Mode of Injury</label>
<select id="natureOfInjury" multiple="multiple" name="natureOfInjury" tabindex="1" validate="natureOfInjury,metachar,no" style="height:187px"
onchange="showValues1(this,'natureOfInjuryValue');displayGeneralProformaValueDivGp1(this.value,'natureOfInjuryValueDivGp','natureOfInjury','natureOfInjuryValue','natureOfInjuryOthersValue','natureOfInjuryOthersValueDiv')" >
<!-- onchange="displayNatureOfInjury(this.value)" > -->

<option value="0" disabled="disabled">Select</option>
<option value="Fall">Fall</option>
<option value="RTA">RTA</option>
<option value="Assault">Assault</option>
<option value="House hold fall">House hold fall</option>
<option value="Fall at work place">Fall at work place</option>
<option value="Fall from height">Fall from height</option>
<option value="Fall from Vehicle">Fall from Vehicle</option>
<option value="Self-Inflicted">Self-Inflicted</option>
<option value="Occupational">Occupational</option>
<option value="Repetitive stress injury">Repetitive stress injury</option>
<option value="Others">Others</option>
</select>
<div style="display:none" id="natureOfInjuryValueDivGp">
<textarea class="historyAutoComplete" name="natureOfInjuryValue" id="natureOfInjuryValue" cols="0" rows="0" maxlength="1450" style="width:400px;height:65px;"></textarea>
</div>
<div style="display:none" id="natureOfInjuryOthersValueDiv">
<textarea class="historyAutoComplete" name="natureOfInjuryOthersValue" id="natureOfInjuryOthersValue" cols="0" rows="0" style="width:190px;height:65px;margin-left:5px;" maxlength="256"></textarea>
</div>
<div class="clear"></div>

<script>

var arr= new Array();
var injValue= '';
var nLine = '';
<%if(modeOfInjuryValues !=null){
	int count = 0;
for(String injuryValues : modeOfInjuryValues){ %>
	arr.push('<%=injuryValues%>');
	<% count++ ;
	if(count != modeOfInjuryValues.length) { %>
		nLine = "\n";
	<%} else {%>
		nLine = '';
	<%}%>
	injValue = injValue + ('<%=injuryValues%>' ) + nLine;	
<% } } %>



/* --- */

var modeofInjuryArray = new Array();
<%if(modeOfInjuries != null){ %>
     document.getElementById('natureOfInjuryValueDivGp').style.display = 'block';
     document.getElementById('natureOfInjuryValue').value =injValue; 
    <%--  document.getElementById('natureOfInjuryValue').value ='<%= opdOrthopedicSpeciality.get(0).getNatureOfInjury()%>';  --%>
	<%for(String injuryMode : modeOfInjuries){%>
	modeofInjuryArray.push('<%=injuryMode%>');    	
		
<% } } %>	
var modeofInjuryElement = 	document.getElementById('natureOfInjury');
for(var i=0;i<modeofInjuryArray.length;i++){
	for(var j=0;j<modeofInjuryElement.options.length;j++){
		if(modeofInjuryArray[i].includes(modeofInjuryElement.options[j].value)){
			modeofInjuryElement.options[j].selected = true;
		}
	}
}


<%if(opdOrthopedicSpeciality.size() > 0 && natureOfInjuryOtherValue!=null && !natureOfInjuryOtherValue.equals("")){
		  %>

		  document.getElementById('natureOfInjuryOthersValueDiv').style.display = 'block';
		  document.getElementById('natureOfInjuryOthersValue').value ='<%= natureOfInjuryOtherValue%>'; 
		  
		<%}%>

</script>

<h4>Presenting Complaints</h4>
<div class="clear"></div>

<input id="orthoFlag" name="orthoFlag" tabindex="1" value="Orthopedics" type="hidden"  />
<input type="hidden" name="templateName" value="Orthopaedics"/>
<label>Neck</label>
<input id="neck" name="neck" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkNeckValue(this.value)">
<input id="neckValue" name="neckValue" class="largeMedium" value="" tabindex="1" validate="Neck Value,metachar,no" maxlength="50" type="text" style="display: none" >

<script>

<%if(neckValue !=null && !neckValue.equals("")){%>
document.getElementById('neck').checked = true;
document.getElementById('neckValue').style.display = 'block';
document.getElementById('neckValue').value = '<%= neckValue%>'; 
<%}%>
</script>


<label class="medium">Midback</label>
<input id="midBack" name="midBack" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkMidBackValue(this.value)">
<input id="midBackValue" name="midBackValue" class="largeMedium" value="" tabindex="1" validate="Midback Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div> 

<script>

<%if(midbackValue !=null && !midbackValue.equals("")){%>
document.getElementById('midBack').checked = true;
document.getElementById('midBackValue').style.display = 'block';
document.getElementById('midBackValue').value = '<%= midbackValue%>'; 
<%}%>
</script>


<label>Girdle</label>
<input id="girdle" name="girdle" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkGirdleValue(this.value)">
<input id="girdleValue" name="girdleValue" class="largeMedium" value="" tabindex="1" validate="Girdle Value,metachar,no" maxlength="50" type="text" style="display: none" >

<script>

<%if(girdleValue !=null && !girdleValue.equals("")){%>
document.getElementById('girdle').checked = true;
document.getElementById('girdleValue').style.display = 'block';
document.getElementById('girdleValue').value = '<%= girdleValue%>'; 
<%}%>
</script>


<label class="medium">Lowback</label>
<input id="lowBack" name="lowBack" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLowbackValue(this.value)">
<input id="lowBackValue" name="lowBackValue" class="largeMedium" value="" tabindex="1" validate="Lowback Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div> 

<script>

<%if(lowbackValue !=null && !lowbackValue.equals("")){%>
document.getElementById('lowBack').checked = true;
document.getElementById('lowBackValue').style.display = 'block';
document.getElementById('lowBackValue').value = '<%= lowbackValue%>'; 
<%}%>
</script>

<label>HIP</label>
<input id="hip" name="hip" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHipValue(this.value)">
<select id="hipType" name="hipType" tabindex="1" style="display: none" class="medium2" onchange="checkHipValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>

<label id="leftHiplabelId" class="medium" style="display: none" >Left</label>
<input id="hipValue" name="hipValue" class="largeMedium" value="" tabindex="1" validate="HIP Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightHiplabelId" class="medium" style="display: none">Right</label>
<input id="hipValueAnother" name="hipValueAnother" class="largeMedium" value="" tabindex="1" validate="HIP Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div> 
<script>
var hipValues = document.getElementById('hipType');
<%if(hipValue !=null && !hipValue.trim().equals("")){%>
document.getElementById('hip').checked = true;
document.getElementById('hipType').style.display = 'block';
for(var j=0;j<hipValues.options.length;j++){
	if(hipValues.options[j].value == '<%= hip%>' ){
		hipValues.options[j].selected = true;
	}
	if('<%= hip%>' == 'Left & Right'){
		document.getElementById('hipValueAnother').style.display = 'block';
		document.getElementById('hipValueAnother').value = '<%= hipValueAnother%>';
		document.getElementById('leftHiplabelId').style.display = 'block';
		document.getElementById('rightHiplabelId').style.display = 'block';
	}
}

document.getElementById('hipValue').style.display = 'block';
document.getElementById('hipValue').value = '<%= hipValue%>'; 
<%}%>

</script>


<label>Sacroiliac</label>
<input id="sacroiliac" name="sacroiliac" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkSacroiliacValue(this.value)">
<select id="sacroiliacType" name="sacroiliacType" tabindex="1" class="medium2"  style="display: none" onchange="checkSacroiliacValueAnother(this.value)" >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftSacroiliaclabelId" class="medium" style="display: none" >Left</label>
<input id="sacroiliacValue" name="sacroiliacValue" class="largeMedium" value="" tabindex="1" validate="Sacroiliac Value,metachar,no" maxlength="50" type="text" style="display: none"  >
<label id="rightSacroiliaclabelId" class="medium" style="display: none">Right</label>
<input id="sacroiliacValueAnother" class="largeMedium" name="sacroiliacValueAnother" value="" tabindex="1" validate="Sacroiliac Value Right,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div> 

<script>
var sacroiliacValues = document.getElementById('sacroiliacType');
<%if(sacroiliacValue !=null && !sacroiliacValue.equals("")){%>
document.getElementById('sacroiliac').checked = true;
document.getElementById('sacroiliacType').style.display = 'block';
for(var j=0;j<sacroiliacValues.options.length;j++){
	if(sacroiliacValues.options[j].value == '<%= sacroiliac%>' ){
		sacroiliacValues.options[j].selected = true;
	}
	if('<%= sacroiliac%>' == 'Left & Right'){
		document.getElementById('sacroiliacValueAnother').style.display = 'block';
		document.getElementById('sacroiliacValueAnother').value = '<%= sacroiliacValueAnother%>';
		document.getElementById('leftSacroiliaclabelId').style.display = 'block';
		document.getElementById('rightSacroiliaclabelId').style.display = 'block';
	}
}

document.getElementById('sacroiliacValue').style.display = 'block';
document.getElementById('sacroiliacValue').value = '<%= sacroiliacValue%>'; 
<%}%>

</script>

<label>Pelvis</label>
<input id="pelvis" name="pelvis" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkPelvisValue(this.value)">
<select id="pelvisType" name="pelvisType" tabindex="1" class="medium2"  style="display: none" onchange="checkPelvisValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftPelvislabelId" class="medium" style="display: none" >Left</label>
<input id="pelvisValue" name="pelvisValue" class="largeMedium" value="" tabindex="1" validate="Pelvis Value,metachar,no" maxlength="50" type="text"  style="display: none" >
<label id="rightPelvislabelId" class="medium" style="display: none">Right</label>
<input id="pelvisValueAnother" name="pelvisValueAnother" class="largeMedium" value="" tabindex="1" validate="Pelvis Value Right,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var pelvisValues = document.getElementById('pelvisType');
<%if(pelvisValue !=null && !pelvisValue.equals("")){%>
document.getElementById('pelvis').checked = true;
document.getElementById('pelvisType').style.display = 'block';
for(var j=0;j<pelvisValues.options.length;j++){
	if(pelvisValues.options[j].value == '<%= pelvis%>' ){
		pelvisValues.options[j].selected = true;
	}
	if('<%= pelvis%>' == 'Left & Right'){
		document.getElementById('pelvisValueAnother').style.display = 'block';
		document.getElementById('pelvisValueAnother').value = '<%= pelvisValueAnother%>';
		document.getElementById('leftPelvislabelId').style.display = 'block';
		document.getElementById('rightPelvislabelId').style.display = 'block';
	}
}

document.getElementById('pelvisValue').style.display = 'block';
document.getElementById('pelvisValue').value = '<%= pelvisValue%>'; 
<%}%>

</script>



<label>Thigh</label>
<input id="thigh" name="thigh" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkThighValue(this.value)">
<select id="thighType" name="thighType" tabindex="1" class="medium2" style="display: none" onchange="checkThighValueAnother(this.value)" >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftThighlabelId" class="medium" style="display: none" >Left</label>
<input id="thighValue" name="thighValue" class="largeMedium" value="" tabindex="1" validate="Thigh Value,metachar,no" maxlength="50" type="text"  style="display: none" >
<label id="rightThighlabelId" class="medium" style="display: none">Right</label>
<input id="thighValueAnother" name="thighValueAnother" class="largeMedium" value="" tabindex="1" validate="Thigh Value,metachar,no" maxlength="50" type="text"  style="display: none" >
<div class="clear"></div>

<script>
var thighValues = document.getElementById('thighType');
<%if(thighValue !=null && !thighValue.equals("")){%>
document.getElementById('thigh').checked = true;
document.getElementById('thighType').style.display = 'block';
for(var j=0;j<thighValues.options.length;j++){
	if(thighValues.options[j].value == '<%= thigh%>' ){
		thighValues.options[j].selected = true;
	}
	if('<%= thigh%>' == 'Left & Right'){
		document.getElementById('thighValueAnother').style.display = 'block';
		document.getElementById('thighValueAnother').value = '<%= thighValueAnother%>';
		document.getElementById('leftThighlabelId').style.display = 'block';
		document.getElementById('rightThighlabelId').style.display = 'block';
	}
}

document.getElementById('thighValue').style.display = 'block';
document.getElementById('thighValue').value = '<%= thighValue%>'; 
<%}%>

</script>



<label>Knee</label>
<input id="knee" name="knee" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkKneeValue(this.value)">
<select id="kneeType" name="kneeType" tabindex="1" class="medium2"  style="display: none"  onchange="checkKneeValueAnother(this.value)"  >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftKneelabelId" class="medium" style="display: none" >Left</label>
<input id="kneeValue" name="kneeValue" value="" class="largeMedium" tabindex="1" validate="Knee Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightKneelabelId" class="medium" style="display: none">Right</label>
<input id="kneeValueAnother" name="kneeValueAnother" class="largeMedium" value="" tabindex="1" validate="Knee Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var kneeValues = document.getElementById('kneeType');
<%if(kneeValue !=null && !kneeValue.equals("")){%>
document.getElementById('knee').checked = true;
document.getElementById('kneeType').style.display = 'block';
for(var j=0;j<kneeValues.options.length;j++){
	if(kneeValues.options[j].value == '<%= knee%>' ){
		kneeValues.options[j].selected = true;
	}
	if('<%= knee%>' == 'Left & Right'){
		document.getElementById('kneeValueAnother').style.display = 'block';
		document.getElementById('kneeValueAnother').value = '<%= kneeValueAnother%>';
		document.getElementById('leftKneelabelId').style.display = 'block';
		document.getElementById('rightKneelabelId').style.display = 'block';
	}
}

document.getElementById('kneeValue').style.display = 'block';
document.getElementById('kneeValue').value = '<%= kneeValue%>'; 
<%}%>

</script>


<label>Leg</label>
<input id="leg" name="leg" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLegValue(this.value)">
<select id="legType" name="legType" tabindex="1" class="medium2"  style="display: none" onchange="checkLegValueAnother(this.value)" >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftLeglabelId" class="medium" style="display: none" >Left</label>
<input id="legValue" name="legValue" class="largeMedium" value="" tabindex="1" validate="Leg Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightLeglabelId" class="medium" style="display: none">Right</label>
<input id="legValueAnother" class="largeMedium" name="legValueAnother" value="" tabindex="1" validate="Leg Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var legValues = document.getElementById('legType');
<%if(legValue !=null && !legValue.equals("")){%>
document.getElementById('leg').checked = true;
document.getElementById('legType').style.display = 'block';
for(var j=0;j<legValues.options.length;j++){
	if(legValues.options[j].value == '<%= leg%>' ){
		legValues.options[j].selected = true;
	}
	if('<%= leg%>' == 'Left & Right'){
		document.getElementById('legValueAnother').style.display = 'block';
		document.getElementById('legValueAnother').value = '<%= legValueAnother%>';
		document.getElementById('leftLeglabelId').style.display = 'block';
		document.getElementById('rightLeglabelId').style.display = 'block';
	}
}

document.getElementById('legValue').style.display = 'block';
document.getElementById('legValue').value = '<%= legValue%>'; 
<%}%>

</script>


<label>Ankle</label>
<input id="ankle" name="ankle" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkAnkleValue(this.value)">
<select id="ankleType" name="ankleType" tabindex="1" class="medium2" style="display: none" onchange="checkAnkleValueAnother(this.value)" >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftAnklelabelId" class="medium" style="display: none" >Left</label>
<input id="ankleValue" name="ankleValue" class="largeMedium" value="" tabindex="1" validate="Ankle Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightAnklelabelId" class="medium" style="display: none">Right</label>
<input id="ankleValueAnother" name="ankleValueAnother" class="largeMedium" value="" tabindex="1" validate="Ankle Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var ankleValues = document.getElementById('ankleType');
<%if(ankleValue !=null && !ankleValue.equals("")){%>
document.getElementById('ankle').checked = true;
document.getElementById('ankleType').style.display = 'block';
for(var j=0;j<ankleValues.options.length;j++){
	if(ankleValues.options[j].value == '<%= ankle%>' ){
		ankleValues.options[j].selected = true;
	}
	if('<%= ankle%>' == 'Left & Right'){
		document.getElementById('ankleValueAnother').style.display = 'block';
		document.getElementById('ankleValueAnother').value = '<%= ankleValueAnother%>'; 
		document.getElementById('leftAnklelabelId').style.display = 'block';
		document.getElementById('rightAnklelabelId').style.display = 'block';
	}
}

document.getElementById('ankleValue').style.display = 'block';
document.getElementById('ankleValue').value = '<%= ankleValue%>'; 
<%}%>

</script>


<label>Foot</label>
<input id="foot" name="foot" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkFootValue(this.value)">
<select id="footType" name="footType" tabindex="1" class="medium2" style="display: none" onchange="checkFootValueAnother(this.value)" >
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftFootlabelId" class="medium" style="display: none" >Left</label>
<input id="footValue" name="footValue" class="largeMedium" value="" tabindex="1" validate="Foot Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightFootlabelId" class="medium" style="display: none" >Left</label>
<input id="footValueAnother" name="footValueAnother" class="largeMedium" value="" tabindex="1" validate="Foot Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var footValues = document.getElementById('footType');
<%if(footValue !=null && !footValue.equals("")){%>
document.getElementById('foot').checked = true;
document.getElementById('footType').style.display = 'block';
for(var j=0;j<footValues.options.length;j++){
	if(footValues.options[j].value == '<%= foot%>' ){
		footValues.options[j].selected = true;
	}
	if('<%= foot%>' == 'Left & Right'){
		document.getElementById('footValueAnother').style.display = 'block';
		document.getElementById('footValueAnother').value = '<%= footValueAnother%>';
		document.getElementById('leftFootlabelId').style.display = 'block';
		document.getElementById('rightFootlabelId').style.display = 'block';
	}
}

document.getElementById('footValue').style.display = 'block';
document.getElementById('footValue').value = '<%= footValue%>'; 
<%}%>

</script>


<label>Shoulder</label>
<input id="shoulder" name="shoulder" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkShoulderValue(this.value)">
<select id="shoulderType" name="shoulderType" tabindex="1" class="medium2" style="display: none" onchange="checkShoulderValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftShoulderlabelId" class="medium" style="display: none" >Left</label>
<input id="shoulderValue" name="shoulderValue" class="largeMedium" value="" tabindex="1" validate="Shoulder Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightShoulderlabelId" class="medium" style="display: none">Right</label>
<input id="shoulderValueAnother" name="shoulderValueAnother" class="largeMedium" value="" tabindex="1" validate="Shoulder Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var shoulderValues = document.getElementById('shoulderType');
<%if(shoulderValue !=null && !shoulderValue.equals("")){%>
document.getElementById('shoulder').checked = true;
document.getElementById('shoulderType').style.display = 'block';
for(var j=0;j<shoulderValues.options.length;j++){
	if(shoulderValues.options[j].value == '<%= shoulder%>' ){
		shoulderValues.options[j].selected = true;
	}
	if('<%= shoulder%>' == 'Left & Right'){
		document.getElementById('shoulderValueAnother').style.display = 'block';
		document.getElementById('shoulderValueAnother').value = '<%= shoulderValueAnother%>'; 
		document.getElementById('leftShoulderlabelId').style.display = 'block';
		document.getElementById('rightShoulderlabelId').style.display = 'block';
	}
}

document.getElementById('shoulderValue').style.display = 'block';
document.getElementById('shoulderValue').value = '<%= shoulderValue%>'; 
<%}%>

</script>


<label>Interscapular</label>
<input id="interscapular" name="interscapular" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkInterscapularValue(this.value)">
<select id="interscapularType" name="interscapularType" tabindex="1" class="medium2" style="display: none" onchange="checkInterscapularValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftInterscapularlabelId" class="medium" style="display: none" >Left</label>
<input id="interscapularValue" name="interscapularValue" class="largeMedium" value="" tabindex="1" validate="Interscapular Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightInterscapularlabelId" class="medium" style="display: none">Right</label>
<input id="interscapularValueAnother" name="interscapularValueAnother" class="largeMedium" value="" tabindex="1" validate="Interscapular Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var interscapularValues = document.getElementById('interscapularType');
<%if(interscapularValue !=null && !interscapularValue.equals("")){%>
document.getElementById('interscapular').checked = true;
document.getElementById('interscapularType').style.display = 'block';
for(var j=0;j<interscapularValues.options.length;j++){
	if(interscapularValues.options[j].value == '<%= interscapular%>' ){
		interscapularValues.options[j].selected = true;
	}
	if('<%= interscapular%>' == 'Left & Right'){
		document.getElementById('interscapularValueAnother').style.display = 'block';
		document.getElementById('interscapularValueAnother').value = '<%= interscapularValueAnother%>';
		document.getElementById('leftInterscapularlabelId').style.display = 'block';
		document.getElementById('rightInterscapularlabelId').style.display = 'block';
	}
}

document.getElementById('interscapularValue').style.display = 'block';
document.getElementById('interscapularValue').value = '<%= interscapularValue%>'; 
<%}%>

</script>

<label>Arm</label>
<input id="arm" name="arm" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkArmValue(this.value)">
<select id="armType" name="armType" tabindex="1" class="medium2" style="display: none" onchange="checkArmValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftArmlabelId" class="medium" style="display: none" >Left</label>
<input id="armValue" name="armValue" class="largeMedium" value="" tabindex="1" validate="Arm Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightArmlabelId" class="medium" style="display: none">Right</label>
<input id="armValueAnother" name="armValueAnother" class="largeMedium" value="" tabindex="1" validate="Arm Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var armValues = document.getElementById('armType');
<%if(armValue !=null && !armValue.equals("")){%>
document.getElementById('arm').checked = true;
document.getElementById('armType').style.display = 'block';
for(var j=0;j<armValues.options.length;j++){
	if(armValues.options[j].value == '<%= arm%>' ){
		armValues.options[j].selected = true;
	}
	if('<%= arm%>' == 'Left & Right'){
		document.getElementById('armValueAnother').style.display = 'block';
		document.getElementById('armValueAnother').value = '<%= armValueAnother%>';
		document.getElementById('leftArmlabelId').style.display = 'block';
		document.getElementById('rightArmlabelId').style.display = 'block';
	}
}

document.getElementById('armValue').style.display = 'block';
document.getElementById('armValue').value = '<%= armValue%>'; 
<%}%>

</script>


<label>Elbow</label>
<input id="elbow" name="elbow" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkElbowValue(this.value)">
<select id="elbowType" name="elbowType" tabindex="1" class="medium2" style="display: none" onchange="checkElbowValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftElbowlabelId" class="medium" style="display: none" >Left</label>
<input id="elbowValue" name="elbowValue" class="largeMedium" value="" tabindex="1" validate="Elbow Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightElbowlabelId" class="medium" style="display: none">Right</label>
<input id="elbowValueAnother" name="elbowValueAnother" class="largeMedium" value="" tabindex="1" validate="Elbow Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var elbowValues = document.getElementById('elbowType');
<%if(elbowValue !=null && !elbowValue.equals("")){%>
document.getElementById('elbow').checked = true;
document.getElementById('elbowType').style.display = 'block';
for(var j=0;j<elbowValues.options.length;j++){
	if(elbowValues.options[j].value == '<%= elbow%>' ){
		elbowValues.options[j].selected = true;
	}
	if('<%= elbow%>' == 'Left & Right'){
		document.getElementById('elbowValueAnother').style.display = 'block';
		document.getElementById('elbowValueAnother').value = '<%= elbowValueAnother%>'; 
		document.getElementById('leftElbowlabelId').style.display = 'block';
		document.getElementById('rightElbowlabelId').style.display = 'block';
	}
}

document.getElementById('elbowValue').style.display = 'block';
document.getElementById('elbowValue').value = '<%= elbowValue%>'; 
<%}%>

</script>


<label>Forearm</label>
<input id="forearm" name="forearm" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkForearmValue(this.value)">
<select id="forearmType" name="forearmType" tabindex="1" class="medium2" style="display: none" onchange="checkForearmValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftForearmlabelId" class="medium" style="display: none" >Left</label>
<input id="forearmValue" name="forearmValue" class="largeMedium" value="" tabindex="1" validate="Forearm Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightForearmlabelId" class="medium" style="display: none">Right</label>
<input id="forearmValueAnother" name="forearmValueAnother" class="largeMedium" value="" tabindex="1" validate="Forearm Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var forearmValues = document.getElementById('forearmType');
<%if(forearmValue !=null && !forearmValue.equals("")){%>
document.getElementById('forearm').checked = true;
document.getElementById('forearmType').style.display = 'block';
for(var j=0;j<forearmValues.options.length;j++){
	if(forearmValues.options[j].value == '<%= forearm%>' ){
		forearmValues.options[j].selected = true;
	}
	if('<%= forearm%>' == 'Left & Right'){
		document.getElementById('forearmValueAnother').style.display = 'block';
		document.getElementById('forearmValueAnother').value = '<%= forearmValueAnother%>'; 
		document.getElementById('leftForearmlabelId').style.display = 'block';
		document.getElementById('rightForearmlabelId').style.display = 'block';
	}
}

document.getElementById('forearmValue').style.display = 'block';
document.getElementById('forearmValue').value = '<%= forearmValue%>'; 
<%}%>

</script>


<label>Wrist</label>
<input id="wrist" name="wrist" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkWristValue(this.value)">
<select id="wristType" name="wristType" tabindex="1" class="medium2" style="display: none" onchange="checkWristValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftWristlabelId" class="medium" style="display: none" >Left</label>
<input id="wristValue" name="wristValue" class="largeMedium" value="" tabindex="1" validate="Wrist Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightWristlabelId" class="medium" style="display: none">Right</label>
<input id="wristValueAnother" name="wristValueAnother" class="largeMedium" value="" tabindex="1" validate="Wrist Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var wristValues = document.getElementById('wristType');
<%if(wristValue !=null && !wristValue.equals("")){%>
document.getElementById('wrist').checked = true;
document.getElementById('wristType').style.display = 'block';
for(var j=0;j<wristValues.options.length;j++){
	if(wristValues.options[j].value == '<%= wrist%>' ){
		wristValues.options[j].selected = true;
	}
	if('<%= wrist%>' == 'Left & Right'){
		document.getElementById('wristValueAnother').style.display = 'block';
		document.getElementById('wristValueAnother').value = '<%= wristValueAnother%>';
		document.getElementById('leftWristlabelId').style.display = 'block';
		document.getElementById('rightWristlabelId').style.display = 'block';
	}
}

document.getElementById('wristValue').style.display = 'block';
document.getElementById('wristValue').value = '<%= wristValue%>'; 
<%}%>

</script>


<label>Hand</label>
<input id="hand" name="hand" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkHandValue(this.value)">
<select id="handType" name="handType" tabindex="1" class="medium2" style="display: none" onchange="checkHandValueAnother(this.value)">
<option value="">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftHandlabelId" class="medium" style="display: none" >Left</label>
<input id="handValue" name="handValue" class="largeMedium" value="" tabindex="1" validate="Hand Value,metachar,no" maxlength="50" type="text" style="display: none" >
<label id="rightHandlabelId" class="medium" style="display: none">Right</label>
<input id="handValueAnother" name="handValueAnother" class="largeMedium" value="" tabindex="1" validate="Hand Value,metachar,no" maxlength="50" type="text" style="display: none" >
<div class="clear"></div>

<script>
var handValues = document.getElementById('handType');
<%if(handValue !=null && !handValue.equals("")){%>
document.getElementById('hand').checked = true;
document.getElementById('handType').style.display = 'block';
for(var j=0;j<handValues.options.length;j++){
	if(handValues.options[j].value == '<%= hand%>' ){
		handValues.options[j].selected = true;
	}
	if('<%= hand%>' == 'Left & Right'){
		document.getElementById('handValueAnother').style.display = 'block';
		document.getElementById('handValueAnother').value = '<%= handValueAnother%>'; 
		document.getElementById('leftHandlabelId').style.display = 'block';
		document.getElementById('rightHandlabelId').style.display = 'block';
	}
}

document.getElementById('handValue').style.display = 'block';
document.getElementById('handValue').value = '<%= handValue%>'; 
<%}%>

</script>


<label>Upper Limb</label>
<input id="upperLimb" name="upperLimb" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkUpperLimb(this.value)">

<select id="upperLimbType" name="upperLimbType" tabindex="1" class="medium2" style="display: none" onchange="checkUpperLimbValue(this.value)"  >
<option value="0">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftupperLimblabelId" class="medium" style="display: none" >Left</label>
<input id="upperLimbValue" name="upperLimbValue" class="largeMedium" value="" tabindex="1" validate="Left Upper Limb Value,metachar,no" maxlength="50" type="text" style="display: none">
<label id="rightupperLimblabelId" class="medium" style="display: none">Right</label>
<input id="upperLimbValueAnother" name="upperLimbValueAnother" class="largeMedium" value="" tabindex="1" validate="Right Upper Limb Value,metachar,no" maxlength="50" type="text" style="display: none" >

 <div id="upperLimbDiv" style="display: none"  >
 <div class="clear"></div>
<label>Length</label>
<input id="upperLimbLength" name="upperLimbLength" style="width:40px;margin-right:3px;" value="" tabindex="1" validate="Limb Length,int,no" maxlength="5" type="text" onkeypress="return isNumberOnly(event)">
<select id="upperLimbUnit" name="upperLimbUnit" tabindex="1" style="width:69px;" >
<option value="0">Select</option>
<option value="mm">mm</option>
<option value="Cm">Cm</option>
<option value="Inch">Inch</option>
</select>


<label class="medium">Discrepancy</label>
<input id="upperLimbDiscrepancy" name="upperLimbDiscrepancy" class="largeMedium" value="" tabindex="1" validate="Discrepancy Value,metachar,no" maxlength="50" type="text" >

<label class="medium">Any Other</label>
<input id="anyOther" name="anyOther" class="largeMedium" value="" tabindex="1" validate="Any Other Value,metachar,no" maxlength="50" type="text">
</div>
<div class="clear"></div>

<script>
 var upperLimbValues = document.getElementById('upperLimbType');
 var upperLimbUnitValues = document.getElementById('upperLimbUnit');
<%if(upperLimbValue !=null && !upperLimbValue.equals("")){%>
document.getElementById('upperLimb').checked = true;
document.getElementById('upperLimbType').style.display = 'block';

for(var j=0;j<upperLimbValues.options.length;j++){
	if(upperLimbValues.options[j].value == '<%=upperLimbSelection %>' ){
		upperLimbValues.options[j].selected = true;
	}
	if('<%= upperLimbSelection%>' == 'Left & Right'){
		document.getElementById('upperLimbValueAnother').style.display = 'block';
		document.getElementById('upperLimbValueAnother').value = '<%= rightUpperLimbValue%>'; 
		document.getElementById('leftupperLimblabelId').style.display = 'block';
		document.getElementById('rightupperLimblabelId').style.display = 'block';
		document.getElementById('upperLimbDiv').style.display = 'block';
		document.getElementById('upperLimbLength').value ='<%= upperLimbLength%>'; 
		for(var k=0;k<upperLimbUnitValues.options.length;k++){
			if(upperLimbUnitValues.options[k].value == '<%=upperLimbLengthUnit %>' ){
				upperLimbUnitValues.options[k].selected = true;
			}
		}
		document.getElementById('upperLimbDiscrepancy').value ='<%= upperLimbDiscrepancy%>'; 
		document.getElementById('anyOther').value ='<%= upperLimbOther%>'; 
	}
}

document.getElementById('upperLimbValue').style.display = 'block';
document.getElementById('upperLimbValue').value = '<%= upperLimbValue%>';
document.getElementById('upperLimbDiv').style.display = 'block';
document.getElementById('upperLimbLength').value ='<%= upperLimbLength%>'; 
document.getElementById('upperLimbDiscrepancy').value ='<%= upperLimbDiscrepancy%>'; 
document.getElementById('anyOther').value ='<%= upperLimbOther%>'; 
for(var k=0;k<upperLimbUnitValues.options.length;k++){
	if(upperLimbUnitValues.options[k].value == '<%=upperLimbLengthUnit %>' ){
		upperLimbUnitValues.options[k].selected = true;
	}
}
<%}%> 
<%-- var upperLimbArray = new Array();
<%if(upperLimbSelection != null){ %>
	 document.getElementById('upperLimb').checked = true;
     document.getElementById('upperLimbDiv').style.display = 'block';
	<%for(String upperLimbSelected : upperLimbSelection){%>
	upperLimbArray.push('<%=upperLimbSelected%>');    	
		
<% } } %>	
var upperLimbElement = 	document.getElementById('upperLimbType');
for(var i=0;i<upperLimbArray.length;i++){
	for(var j=0;j<upperLimbElement.options.length;j++){
		if(upperLimbArray[i].includes(upperLimbElement.options[j].value)){
			upperLimbElement.options[j].selected = true;
		}
	}
}
 --%>
<%-- <%if(upperLimbValue != null ){%>
document.getElementById('upperLimbValue').value ='<%= upperLimbValue%>'; 
<%}%> --%>
		  






</script>



<label>Lower Limb</label>
<input id="lowerLimb" name="lowerLimb" tabindex="1" value="y" type="checkbox" class="checkboxMargin" onclick="checkLowerLimb(this.value)">


<select id="lowerLimbType" name="lowerLimbType" tabindex="1" class="medium2" onchange="checkLowerLimbValue(this.value)" style="display: none"  >
<option value="0">Select</option>
<option value="Left">Left</option>
<option value="Right">Right</option>
<option value="Bilateral">Bilateral</option>
<option value="Left & Right">Left & Right</option>
</select>
<label id="leftLowerLimblabelId" class="medium" style="display: none" >Left</label>
<input id="lowerLimbValue" name="lowerLimbValue" class="largeMedium" value="" tabindex="1" validate="Lower Limb Value,metachar,no" style="display: none" maxlength="50" type="text" >
<label id="rightLowerLimblabelId" class="medium" style="display: none">Right</label>
<input id="lowerLimbValueAnother" name="lowerLimbValueAnother" class="largeMedium" value="" tabindex="1" validate="Right Lower Limb Value,metachar,no" maxlength="50" type="text" style="display: none" >


<div id="lowerLimbDiv" style="display: none">
<div class="clear"></div>
<label>Length</label>
<input id="lowerLimbLength" name="lowerLimbLength" style="width:40px;margin-right:3px;" value="<%-- <%=opdOrthopedicSpeciality.getLowerLimbLength()!=null?opdOrthopedicSpeciality.getLowerLimbLength():"" %> --%>" tabindex="1" validate="Limb Length,int,no" maxlength="5" type="text" onkeypress="return isNumberOnly(event)">
<select id="lowerLimbUnit" name="lowerLimbUnit" tabindex="1" style="width:69px;" >
<option value="0">Select</option>
<option value="mm">mm</option>
<option value="Cm">Cm</option>
<option value="Inch">Inch</option>
</select>
<label class="medium">Discrepancy</label>
<input id="lowerLimbDiscrepancy" name="lowerLimbDiscrepancy" class="largeMedium" value="<%-- <%=opdOrthopedicSpeciality.getLowerDiscrepancy()!=null?opdOrthopedicSpeciality.getLowerDiscrepancy():"" %> --%>" tabindex="1" validate="Discrepancy Value,metachar,no" maxlength="50" type="text">

<label class="medium">Any Other</label>
<input id="anyOtherLowerLimb" name="anyOtherLowerLimb" class="largeMedium" value="<%-- <%=opdOrthopedicSpeciality.getLowerLimbAnyOther()!=null?opdOrthopedicSpeciality.getLowerLimbAnyOther():"" %> --%>" tabindex="1" validate="Any Other Value,metachar,no" maxlength="50" type="text">
</div>
<div class="clear"></div> 

<script>
var lowerLimbValues = document.getElementById('lowerLimbType');
var lowerLimbUnitValues = document.getElementById('lowerLimbUnit');
<%if(lowerLimbValue !=null && !lowerLimbValue.equals("")){%>
document.getElementById('lowerLimb').checked = true;
document.getElementById('lowerLimbType').style.display = 'block';

for(var j=0;j<lowerLimbValues.options.length;j++){
	if(lowerLimbValues.options[j].value == '<%=lowerLimbSelection %>' ){
		lowerLimbValues.options[j].selected = true;
	}
	if('<%= lowerLimbSelection%>' == 'Left & Right'){
		document.getElementById('lowerLimbValueAnother').style.display = 'block';
		document.getElementById('lowerLimbValueAnother').value = '<%= rightUpperLimbValue%>'; 
		document.getElementById('leftLowerLimblabelId').style.display = 'block';
		document.getElementById('rightLowerLimblabelId').style.display = 'block';
		document.getElementById('lowerLimbDiv').style.display = 'block';
		document.getElementById('lowerLimbLength').value ='<%= lowerLimbLength%>'; 
		for(var k=0;k<lowerLimbUnitValues.options.length;k++){
			if(lowerLimbUnitValues.options[k].value == '<%=lowerLimbLengthUnit %>' ){
				lowerLimbUnitValues.options[k].selected = true;
			}
		}
		document.getElementById('lowerLimbDiscrepancy').value ='<%= lowerLimbDiscrepancy%>'; 
		document.getElementById('anyOtherLowerLimb').value ='<%= lowerLimbOther%>'; 
	}
}

document.getElementById('lowerLimbValue').style.display = 'block';
document.getElementById('lowerLimbValue').value = '<%= lowerLimbValue%>';
document.getElementById('lowerLimbDiv').style.display = 'block';
document.getElementById('lowerLimbLength').value ='<%= lowerLimbLength%>'; 
document.getElementById('lowerLimbDiscrepancy').value ='<%= lowerLimbDiscrepancy%>'; 
document.getElementById('anyOtherLowerLimb').value ='<%= lowerLimbOther%>';
for(var k=0;k<lowerLimbUnitValues.options.length;k++){
	if(lowerLimbUnitValues.options[k].value == '<%=lowerLimbLengthUnit %>' ){
		lowerLimbUnitValues.options[k].selected = true;
	}
}
<%}%> 








<%-- var lowerLimbArray = new Array();
<%if(lowerLimbSelection != null){ %>
	 document.getElementById('lowerLimb').checked = true;
     document.getElementById('lowerLimbDiv').style.display = 'block';
	<%for(String lowerLimbSelected : lowerLimbSelection){%>
	lowerLimbArray.push('<%=lowerLimbSelected%>');    	
		
<% } } %>	
var lowerLimbElement = 	document.getElementById('lowerLimbType');
for(var i=0;i<lowerLimbArray.length;i++){
	for(var j=0;j<lowerLimbElement.options.length;j++){
		if(lowerLimbArray[i].includes(lowerLimbElement.options[j].value)){
			lowerLimbElement.options[j].selected = true;
		}
	}
} --%>

<%if(lowerLimbValue != null ){%>
document.getElementById('lowerLimbValue').value ='<%= lowerLimbValue%>'; 
<%}%>
		  
<%if(lowerLimbLength != 0 ){%>
document.getElementById('lowerLimbLength').value ='<%= lowerLimbLength%>'; 
<%}%>

<%if(lowerLimbDiscrepancy != null ){%>
document.getElementById('lowerLimbDiscrepancy').value ='<%= lowerLimbDiscrepancy%>'; 
<%}%>

<%if(lowerLimbOther != null ){%>
document.getElementById('anyOtherLowerLimb').value ='<%= lowerLimbOther%>'; 
<%}%>

</script>


<label>Nature of Discomfort</label>
<textarea onkeyup="return checkLength(this)" id="natureOfDiscomfort" name="natureOfDiscomfort" class="largeIner" validate="Nature of Discomfort,string,no" cols="0" rows="0" maxlength="256" ><%-- <%=opdOrthopedicSpeciality.getNameOfDiscomfort()!=null?opdOrthopedicSpeciality.getNameOfDiscomfort():"" %> --%></textarea>
<div class="clear"></div> 
<div class="paddingTop5"></div> 
<div class="clear"></div> 


<script>

<%if(natureOfDiscomfort != null ){%>
document.getElementById('natureOfDiscomfort').value ='<%= natureOfDiscomfort%>'; 
<%}%>

</script>

<label>Pain</label>
<select id="painValue" name="painValue" tabindex="1" class="medium2" validate="Pain,string,no" onchange="SelectPainValue(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div class="clear"></div> 
<div id="painDiv" style="display: none">
<label>Site</label>
<textarea onkeyup="return checkLength(this)" name="painSite" id="painSite" class="largeIner" validate="Site,string,no" cols="0" rows="0" maxlength="256"></textarea>
<label>Nature of Pain</label>
<textarea onkeyup="return checkLength(this)" name="natureOfPain" id="natureOfPain" class="largeIner" validate="Nature of Pain,string,no" cols="0" rows="0" maxlength="256"></textarea>
<div class="clear"></div>
<label>Radiation</label>
<textarea onkeyup="return checkLength(this)" name="radiation" id="radiation" class="largeIner" validate="Radiation,string,no" cols="0" rows="0" maxlength="256"></textarea>


<label>Exacerbating Factor</label>
<textarea onkeyup="return checkLength(this)" name="exacerbatingFactor" id="exacerbatingFactor" class="largeIner" validate="Exacerbating Factor,string,no" cols="0" rows="0" maxlength="256"></textarea>
<div class="clear"></div>
<label>Relieving Factor</label>
<textarea onkeyup="return checkLength(this)" name="relievingFactor" id="relievingFactor" class="largeIner" validate="Relieving Factor,string,no" cols="0" rows="0" maxlength="256"></textarea>
</div>
<div class="clear"></div>
<script>
var painValues = document.getElementById('painValue');
<%if(painValue !=null && !painValue.equals("")){%>
for(var j=0;j<painValues.options.length;j++){
	if(painValues.options[j].value == '<%= painValue%>' ){
		painValues.options[j].selected = true;
	}
}

<%if(painValue !=null && painValue.equalsIgnoreCase("Yes")){%>
document.getElementById('painDiv').style.display = 'block';
<%}%>

document.getElementById('painSite').value ='<%= siteValue%>'; 
document.getElementById('natureOfPain').value ='<%= natureOfPain%>'; 
document.getElementById('radiation').value ='<%= radiationValue%>'; 
document.getElementById('exacerbatingFactor').value ='<%= exacerbatingFactor%>'; 
document.getElementById('relievingFactor').value ='<%= relievingFactor%>'; 

<%}%>
</script>

<label>Stiffness</label>
<select id="stiffness" name="stiffness" class="medium2" tabindex="1" validate="stiffness,string,no" onchange="displayStiffnessValue(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div id="stiffnessDiv" style="display: none">
<textarea onkeyup="return checkLength(this)" name="stiffnessValue" id="stiffnessValue" class="largeIner" validate="Stiffness Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>

<label class="mnuWdthSmll">Morning Stiffness</label> 
<select id="morningStiffness" name="morningStiffness" class="smlWdth" tabindex="1" validate="Morning Stiffness,string,no" onchange="displayMorningStiffnessValue(this.value)" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea onkeyup="return checkLength(this)" name="morningStiffnessValue" id="morningStiffnessValue" class="largeIner" validate="Morning Stiffness Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>
<div class="clear"></div>

<label>Weakness</label>
<select id="weakness" name="weakness" class="medium2" tabindex="1" validate="Weakness,string,no" onchange="displayWeaknessValue(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea onkeyup="return checkLength(this)" name="weaknessValue" id="weaknessValue" class="largeIner" validate="Weakness Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>

<label class="mnuWdthSmll">Inability to use a Limb</label>
<select id="inabilityToUseALimb" name="inabilityToUseALimb" class="smlWdth" tabindex="1" validate="Inability to use a Limb,string,no" onchange="displayInabilityToUseLimbValue(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea onkeyup="return checkLength(this)" name="inabilityToUseALimbValue" id="inabilityToUseALimbValue" class="largeIner" validate="Inability to use a Limb Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>
<div class="clear"></div>

<label>Disability in using a Limb</label>
<select id="disabilityToUseALimb" name="disabilityToUseALimb" class="medium2" tabindex="1" validate="Disability in using a Limb,string,no" onchange="displayDisabilityInUsingALimbValue(this.value)" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea onkeyup="return checkLength(this)" name="disabilityToUseALimbValue" id="disabilityToUseALimbValue" class="largeIner" validate="Disability in using a Limb Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>

<label class="mnuWdthSmll">Swelling</label>
<select id="limbSwelling" name="limbSwelling" class="smlWdth" "tabindex="1" validate="Limb Swelling,string,no" onchange="displaySwelling(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<textarea onkeyup="return checkLength(this)" name="limbSwellingValue" id="limbSwellingValue" class="largeIner" validate="Limb Swelling Value,string,no" cols="0" rows="0" maxlength="256" style="display: none"></textarea>
</div>
<div class="clear"></div>

<script>
var stiffnessValues = document.getElementById('stiffness');
<%if(stiffness !=null && !stiffness.equals("")){%>
for(var j=0;j<stiffnessValues.options.length;j++){
	if(stiffnessValues.options[j].value == '<%= stiffness%>' ){
		stiffnessValues.options[j].selected = true;
	}
}

<%if(stiffness !=null && stiffness.equalsIgnoreCase("Yes")){%>
document.getElementById('stiffnessDiv').style.display = 'block';
document.getElementById('stiffnessValue').style.display = 'block';
document.getElementById('stiffnessValue').value = '<%= stiffnessValue%>';

var morningStiffnessValues = document.getElementById('morningStiffness');
<%if(morningStiffness !=null && !morningStiffness.equals("")){%>
for(var j=0;j<morningStiffnessValues.options.length;j++){
	if(morningStiffnessValues.options[j].value == '<%= morningStiffness%>' ){
		morningStiffnessValues.options[j].selected = true;
	}
}

<%if(morningStiffness !=null && morningStiffness.equalsIgnoreCase("Yes")){%>
document.getElementById('morningStiffnessValue').style.display = 'block';
document.getElementById('morningStiffnessValue').value = '<%= morningStiffnessvalue%>';

<%}}%>

var weaknessValues = document.getElementById('weakness');
<%if(weakness !=null && !weakness.equals("")){%>
for(var j=0;j<weaknessValues.options.length;j++){
	if(weaknessValues.options[j].value == '<%= weakness%>' ){
		weaknessValues.options[j].selected = true;
	}
}

<%if(weakness !=null && weakness.equalsIgnoreCase("Yes")){%>
document.getElementById('weaknessValue').style.display = 'block';
document.getElementById('weaknessValue').value = '<%= weaknessValue%>';

<%}}%>

var inabilityToUseALimbValues = document.getElementById('inabilityToUseALimb');
<%if(inabilityToUseALimb !=null && !inabilityToUseALimb.equals("")){%>
for(var j=0;j<inabilityToUseALimbValues.options.length;j++){
	if(inabilityToUseALimbValues.options[j].value == '<%= inabilityToUseALimb%>' ){
		inabilityToUseALimbValues.options[j].selected = true;
	}
}

<%if(inabilityToUseALimb !=null && inabilityToUseALimb.equalsIgnoreCase("Yes")){%>
document.getElementById('inabilityToUseALimbValue').style.display = 'block';
document.getElementById('inabilityToUseALimbValue').value = '<%= inabilityToUseALimbValue%>';

<%}}%>


var disabilityInUsingALimbValues = document.getElementById('disabilityToUseALimb');
<%if(disabilityInUsingALimb !=null && !disabilityInUsingALimb.equals("")){%>
for(var j=0;j<disabilityInUsingALimbValues.options.length;j++){
	if(disabilityInUsingALimbValues.options[j].value == '<%= disabilityInUsingALimb%>' ){
		disabilityInUsingALimbValues.options[j].selected = true;
	}
}

<%if(disabilityInUsingALimb !=null && disabilityInUsingALimb.equalsIgnoreCase("Yes")){%>
document.getElementById('disabilityToUseALimbValue').style.display = 'block';
document.getElementById('disabilityToUseALimbValue').value = '<%= disabilityInUsingALimbValue%>';

<%}}%>


var swellingValues = document.getElementById('limbSwelling');
<%if(swelling !=null && !swelling.equals("")){%>
for(var j=0;j<swellingValues.options.length;j++){
	if(swellingValues.options[j].value == '<%= swelling%>' ){
		swellingValues.options[j].selected = true;
	}
}

<%if(swelling !=null && swelling.equalsIgnoreCase("Yes")){%>
document.getElementById('limbSwellingValue').style.display = 'block';
document.getElementById('limbSwellingValue').value = '<%= swellingValue%>';

<%}}%>



<%}%>
<%}%>
</script>


<label>Constitutional Symptoms</label>
<textarea onkeyup="return checkLength(this)" name="constitutionalSymptoms" id="constitutionalSymptoms" class="largeIner" validate="Constitutional Symptoms,string,no" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getConstitutionalSymptoms()!=null?opdOrthopedicSpeciality.getConstitutionalSymptoms():"" %> --%></textarea>

<script>
<%if(constitutionalSymptoms != null ){%>
document.getElementById('constitutionalSymptoms').value ='<%= constitutionalSymptoms%>'; 
<%}%>
</script>

<label>Occupational History</label>
<textarea onkeyup="return checkLength(this)" name="occupationalHistory" id="occupationalHistory" class="largeIner" validate="Occupational History,string,no" onkeyup="return checkLength(this)" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getOccupationalHistory()!=null?opdOrthopedicSpeciality.getOccupationalHistory():"" %> --%></textarea>
<script>
<%if(occupationalHistory != null ){%>
document.getElementById('occupationalHistory').value ='<%= occupationalHistory%>'; 
<%}%>
</script>
<div class="clear"></div> 
<label>Treatment History</label>
<textarea onkeyup="return checkLength(this)" name="treatmentHistory" id="treatmentHistory" class="largeIner" validate="Treatment History,string,no" onkeyup="return checkLength(this)" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getTreatmentHistory()!=null?opdOrthopedicSpeciality.getTreatmentHistory():"" %> --%></textarea>


<script>
<%if(treatmentHistory != null ){%>
document.getElementById('treatmentHistory').value ='<%= treatmentHistory%>'; 
<%}%>
</script>

<label>Developmental History</label>
<textarea onkeyup="return checkLength(this)" name="developmentalHistory" id="developmentalHistory" class="largeIner" validate="Developmental History,string,no" onkeyup="return checkLength(this)" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getDevelopmentHistory()!=null?opdOrthopedicSpeciality.getDevelopmentHistory():"" %> --%></textarea>
<script>
<%if(developmentalHistory != null ){%>
document.getElementById('developmentalHistory').value ='<%= developmentalHistory%>'; 
<%}%>
</script>
<div class="clear"></div> 
<label>Developmental Milestones</label>
<textarea onkeyup="return checkLength(this)" name="developmentalMilestones" id="developmentalMilestones" class="largeIner" validate="Developmental Milestones,string,no" onkeyup="return checkLength(this)" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getDevelopmentMilestones()!=null?opdOrthopedicSpeciality.getDevelopmentMilestones():"" %> --%></textarea>


<script>
<%if(developmentalMilestones != null ){%>
document.getElementById('developmentalMilestones').value ='<%= developmentalMilestones%>'; 
<%}%>
</script>

<label class="heightAuto">Perinatal & Antenatal History</label>
<textarea onkeyup="return checkLength(this)" name="perinatalAndAntenatalHistory" id="perinatalAndAntenatalHistory" class="largeIner" validate="Perinatal & Antenatal History,string,no"  onkeyup="return checkLength(this)" cols="0" rows="0" maxlength="256"><%-- <%=opdOrthopedicSpeciality.getParinatalAndAntenatalHistory()!=null?opdOrthopedicSpeciality.getParinatalAndAntenatalHistory():"" %> --%></textarea>
<div class="clear"></div>

<script>
<%if(perinatalAntenatalHistory != null ){%>
document.getElementById('perinatalAndAntenatalHistory').value ='<%= perinatalAntenatalHistory%>'; 
<%}%>
</script>

<h4>Local Examination</h4>
<div class="clear"></div> 

<label>Swelling</label>
<select id="swelling" name="swelling" tabindex="1" validate="Swelling,metachar,no" onchange="displaySite(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div id = "siteDiv" style="display: none">
<label>Site</label>
<textarea onkeyup="return checkLength(this)" name="site" id="site" class="largeIner" validate="Site,string,no" cols="0" rows="0" maxlength="256"></textarea>
<div class="clear"></div>

<label>Nature of Growth</label>
<select id="natureOfGrowth" name="natureOfGrowth" tabindex="1" validate="Nature of Growth,metachar,no" onchange="displayGrowthValue(this.value)" >
<option value="">Select</option>
<option value="Static">Static</option>
<option value="Slowly Progressing">Slowly Progressing</option>
<option value="Rapidly Progressing">Rapidly Progressing</option>
<option value="Pressure Symptoms">Pressure Symptoms</option>
</select>
<div id="natureDiv" style="display: none">
<textarea name="natureOfGrowthValue" id="natureOfGrowthValue" class="largeIner" validate="Nature of Growth Value,string,no" cols="0" rows="0" maxlength="256" style="width:354px;" ></textarea>
<div class="clear"></div>
</div>

<label>Size</label>
<input type="text" name="size" id="size"  validate="Size,string,no" class="largeMedium" maxlength="5" value="" >

<div class="clear"></div>

<label>Surface</label>
<textarea onkeyup="return checkLength(this)" name="surface" id="surface" class="largeIner" validate="Surface,string,no" cols="0" rows="0" maxlength="256"></textarea>
<label>Shape</label>
<textarea onkeyup="return checkLength(this)" name="shape" id="shape" class="largeIner" validate="Shape,string,no" cols="0" rows="0" maxlength="256"></textarea>
<div class="clear"></div> 

<label>Consistency</label>
<textarea onkeyup="return checkLength(this)" name="consistency" id="consistency" class="largeIner" validate="Consistency,string,no" cols="0" rows="0" maxlength="256"></textarea>
<label>Plane of the Swelling</label>
<textarea onkeyup="return checkLength(this)" name="planeOfTheSwelling" id="planeOfTheSwelling" class="largeIner" validate="Plane of the Swelling,string,no" cols="0" rows="0" maxlength="256"></textarea>
<label>Remarks</label>
<textarea onkeyup="return checkLength(this)" name="remarksForSwelling" id="remarksForSwelling" class="largeIner" validate="Remarks,string,no" cols="0" rows="0" maxlength="256"></textarea>
</div>
<div class="clear"></div>


<script>
var swellingValues = document.getElementById('swelling');
<%if(swellingLocalEx !=null && !swellingLocalEx.equals("")){%>
document.getElementById('siteDiv').style.display = 'block';
for(var j=0;j<swellingValues.options.length;j++){
	if(swellingValues.options[j].value == '<%= swellingLocalEx%>' ){
		swellingValues.options[j].selected = true;
	}
}
document.getElementById('site').value = '<%= swellingSite%>';

var natureOfGrowthValues = document.getElementById('natureOfGrowth');
<%if(swellingNatureOfGrowth !=null && !swellingNatureOfGrowth.equals("")){%>
for(var j=0;j<natureOfGrowthValues.options.length;j++){
	if(natureOfGrowthValues.options[j].value == '<%= swellingNatureOfGrowth%>' ){
		natureOfGrowthValues.options[j].selected = true;
	}
}
<%}%>

document.getElementById('size').value = '<%= swellingSize%>' ;

document.getElementById('surface').value = '<%= swellingSurface%>' ;

document.getElementById('shape').value = '<%= swellingShape%>' ;

document.getElementById('consistency').value = '<%= swellingConsistency%>' ;

document.getElementById('planeOfTheSwelling').value = '<%= planeOfTheSwelling%>' ;

<%if(swellingNatureOfGrowth !=null && !swellingNatureOfGrowth.equals("")){%>
document.getElementById('natureDiv').style.display = 'inline';
document.getElementById('natureOfGrowthValue').value = '<%= natureOfGrowthValue%>' ;
<%}%>

document.getElementById('remarksForSwelling').value = '<%= remarksForSwelling%>' ;

<%}%>
</script>



<%
String medicalDisor="";
String obsterDisord="";
String obsterScore="";
Date edc= null;

	List<OpdAntenatalCard> opdAntenatalCardList= new ArrayList<OpdAntenatalCard>();
	if(map.get("opdAntenatalCardList") != null){
		opdAntenatalCardList=(List<OpdAntenatalCard>)map.get("opdAntenatalCardList");
	}
if(opdAntenatalCardList.size()>0){
 for(OpdAntenatalCard opd:opdAntenatalCardList){
	 
 if(opd!=null && opd.getMedicalDisord()!=null && !opd.getMedicalDisord().equals("")){
			 medicalDisor=opd.getMedicalDisord();
			 }
 
 if(opd!=null &&  opd.getObstetricComplications()!=null  && !opd.getObstetricComplications().equals("") ){
	 obsterDisord=opd.getObstetricComplications();
	 }
 
 
 if(opd!=null && opd.getObstetricValues()!=null && !opd.getObstetricValues().equals("") ){
	 obsterScore=opd.getObstetricValues();
	 }
 

 
 if(opd!=null && opd.getEdcDate()!=null && !opd.getEdcDate().equals("") ){
	 edc= opd.getEdcDate();
	 }

 }%>


<label>EDC</label>
<input id="edc" name="edc" style="margin-right:0px;" class="largeMedium" tabindex="1"  readonly="readonly" maxlength="50" type="text" value="<%=edc!=null?HMSUtil.convertDateToStringWithoutTime(edc):""%>">

<label>Obstetric Disorder</label>
<textarea onkeyup="return checkLength(this)" class="largeIner" name="obsterDisord" 	id="obsterDisord" maxlength="256" readonly="readonly"><%=obsterDisord %></textarea>
<div class="clear"></div>

<label>Obstetric Score</label>
<textarea onkeyup="return checkLength(this)" class="largeIner" name="obsterScore" id="obsterScore" maxlength="256" readonly="readonly"><%=obsterScore %></textarea>

<label >Medical Disorder </label>
<textarea onkeyup="return checkLength(this)" class="largeIner" name="medicalDisord" id="medicalDisord" maxlength="256" readonly="readonly"><%=medicalDisor %></textarea>
<%} %>


</div>
</form>

<script>jQuery.noConflict();
jQuery(function($) {
	

    function split( val ) {
        return val.split( /,\s*/ );
    }
    function extractLast( term ) {
        return split( term ).pop();
    }
    
  
	$( ".natureOfInjuryAutoComplete" )
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

<style>
textarea.largeIner{width:326px;}
label.mnuWdthSmll{width:130px;}
select.smlWdth {width:75px;}
</style>


