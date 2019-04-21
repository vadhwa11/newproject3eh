
<%@page import="org.apache.derby.impl.store.raw.data.RecordId"%>
<%@page import="jkt.hms.masters.business.OpdGeneralProformaDetail"%>
<%@page import="jkt.hms.masters.business.OpdGeneralProformaHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.multi-select.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/multiselect.css">
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
	String templateName="General Proforma";
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<DgResultEntryHeader>labResultForLeprosyPerformaList = new ArrayList<DgResultEntryHeader>();
	if(map.get("labResultForLeprosyPerforma") != null){
		labResultForLeprosyPerformaList=(List)map.get("labResultForLeprosyPerforma");
	}
	int hinId=0;
	int visitId=0;
	int patientAge=0;
	if(map.get("hinId")!=null)
	{
	hinId=(Integer)map.get("hinId"); 
	}
	if(map.get("visitId")!=null)
	{
		visitId=(Integer)map.get("visitId"); 
	}
	if(map.get("patientAge")!=null){
		patientAge=(Integer)map.get("patientAge");		
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
	serverdate = '<%=getDate+"/"+month+"/"+year%>';	
	
	</script>

<%
Map<String, Object> map1 = new HashMap<String, Object>();
List<OpdGeneralProformaHeader> dermogeneralProformaHeadersList = new ArrayList<OpdGeneralProformaHeader>();
List<OpdGeneralProformaDetail> dermogeneralProformaDetailsList = new ArrayList<OpdGeneralProformaDetail>();
List<OpdGeneralProformaDetail> dermogeneralProformaDetailsListSecond = new ArrayList<OpdGeneralProformaDetail>();
List<OpdPatientDetails> opdPatDetailsList = new ArrayList<OpdPatientDetails>(); 
map1 = (Map) request.getAttribute("map");
if (map.size()>0) {
		
		 if (map.get("dermogeneralProformaHeadersList") != null)
	       {
			 dermogeneralProformaHeadersList = (List<OpdGeneralProformaHeader>) map.get("dermogeneralProformaHeadersList");			
	       }
		 
		 
		 
		 if (map.get("dermogeneralProformaDetailsList") != null)
	       {
			 dermogeneralProformaDetailsList = (List<OpdGeneralProformaDetail>) map.get("dermogeneralProformaDetailsList");			
	       }
		 
		 if (map.get("dermogeneralProformaDetailsListSecond") != null)
	       {
			 dermogeneralProformaDetailsListSecond = (List<OpdGeneralProformaDetail>) map.get("dermogeneralProformaDetailsListSecond");			
	       }
		 
		 if (map.get("opdPatDetailsList") != null)
	       {
			 opdPatDetailsList = (List<OpdPatientDetails>) map.get("opdPatDetailsList");			
	       }
		 
		}
String [] prsentingComplaints = null;
String [] aggravatingFactors = null;
String [] pastHistioryValues = null;
String [] mucousMembraneValues = null;
String [] hairValues = null;
String [] nailValues = null;
String [] systemIllnessValues = null;
String [] signValues = null;
String [] distributionValues = null;
String [] durationOfIllness = null;
String familyHistoryOfIllness = "";
String familyHistoryOfIllnessPresent = "";

String drugHistory = "";
String drugHistoryvalue = "";

String primaryLessionOthers = "";
String secondaryLessionOthers = "";

int headerRecordId= 0;

if(dermogeneralProformaHeadersList.size() > 0){
prsentingComplaints = dermogeneralProformaHeadersList.get(0).getPresentingComplaintValue().split(",");
aggravatingFactors = dermogeneralProformaHeadersList.get(0).getAggravatingFactorsValue().split(",");
pastHistioryValues = dermogeneralProformaHeadersList.get(0).getPastHistoryValue().split(",");
mucousMembraneValues = dermogeneralProformaHeadersList.get(0).getMucousMenbraneValue().split(",");
hairValues = dermogeneralProformaHeadersList.get(0).getHairValue().split(",");
nailValues = dermogeneralProformaHeadersList.get(0).getNailsValue().split(",");
systemIllnessValues = dermogeneralProformaHeadersList.get(0).getSystemIllnessValue().split(",");
signValues = dermogeneralProformaHeadersList.get(0).getSignsValue().split(",");
distributionValues = dermogeneralProformaHeadersList.get(0).getDistributionParameterValue().split(",");
if(dermogeneralProformaHeadersList.get(0).getDurationOfIllness() !=null && !dermogeneralProformaHeadersList.get(0).getDurationOfIllness().equals("")){
durationOfIllness = dermogeneralProformaHeadersList.get(0).getDurationOfIllness().split("\\s+");
}
familyHistoryOfIllness = dermogeneralProformaHeadersList.get(0).getFamilyHistory();
familyHistoryOfIllnessPresent = dermogeneralProformaHeadersList.get(0).getFamilyHistoryValue();
drugHistory = dermogeneralProformaHeadersList.get(0).getDrugHistory();
drugHistoryvalue = dermogeneralProformaHeadersList.get(0).getDrugHistoryValue();
primaryLessionOthers = dermogeneralProformaHeadersList.get(0).getPrimaryLesionOther();
secondaryLessionOthers = dermogeneralProformaHeadersList.get(0).getSecondaryLesionOther();
headerRecordId = dermogeneralProformaHeadersList.get(0).getId();
}

int pulse=0;
double temprature = 0f;
String [] bp=null;
String bpSystolic = "";
String bpDiastolic = "";
double height = 0f;
double weight = 0f;
double bmi = 0f;
double respRate = 0f;
double spo2 = 0f;

if(opdPatDetailsList.size() > 0){
	
	pulse = opdPatDetailsList.get(0).getPulse();
	temprature = opdPatDetailsList.get(0).getTemperature();

	if(opdPatDetailsList.get(0).getBp() != null && !opdPatDetailsList.get(0).getBp().equals("")){
		bp = opdPatDetailsList.get(0).getBp().split("/");
		bpSystolic = bp[0];
	    bpDiastolic= bp[1];
	}
	height = opdPatDetailsList.get(0).getHeight();
	weight = opdPatDetailsList.get(0).getWeight();
	bmi = opdPatDetailsList.get(0).getBmi();
	respRate = opdPatDetailsList.get(0).getRespiratoryRate();
	spo2 = opdPatDetailsList.get(0).getSpo2();
	
}

		 %>	 

<form method="post" action="" name="leprosyProforma" >

<div class="titleBg">
<h2>General Proforma</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop5"></div>

<input id="generalProformaFlag" name="generalProformaFlag"  value="General Performa" type="hidden"  />
<input type="hidden" name="templateName" value="General Proforma"/>
<input type="hidden" name="headerRecordId" id="headerRecordId" value="<%=headerRecordId%>"/>

<label>Presenting Complaints</label>
<select  style="display: block;width:189px;height:60px;" id="presentingComplaints" name="presentingComplaints" multiple="multiple" 
onchange="showValues1(this,'presentingComplaintValue');displayGeneralProformaValueDivGp1(this.value,'presentingComplaintValueDivGp','presentingComplaints','presentingComplaintValue','presentingComplaintsOthersValueDiv');"  >
<option value="Itching">Itching</option>
<option value="Wheals">Wheals</option>
<option value="Scaling">Scaling</option>
<option value="Oozing And Crusting">Oozing And Crusting</option>
<option value="Pain">Pain</option>
<option value="Burning Sensation">Burning Sensation</option>
<option value="Fever">Fever</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="presentingComplaintValueDivGp">
<textarea class="historyAutoComplete" name="presentingComplaintValue" id="presentingComplaintValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="presentingComplaintsOthersValueDiv">
<textarea class="historyAutoComplete" type="text" id="presentingComplaintsOthersValue" name="presentingComplaintsOthersValue" style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>    
<script type="text/javascript">
 var arr= new Array();
 var pCValue= '';
 var nLine = '';
<%if(prsentingComplaints !=null){
	int count = 0;
for(String presentComplaint : prsentingComplaints){ %>
	arr.push('<%=presentComplaint%>');
	<% count++ ;
	if(count != prsentingComplaints.length) { %>
		nLine = "\n";
	<%} else {%>
		nLine = '';
	<%}%>
		pCValue = pCValue + ('<%=presentComplaint%>'.replace(/,/gi, '')) + nLine;	
<% } } %>
<%if(prsentingComplaints !=null){%>
var presentComplaintsElement = 	document.getElementById('presentingComplaints');
<%if(dermogeneralProformaHeadersList.get(0).getPresentingComplaintValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getPresentingComplaintValue().equals("")){%>
document.getElementById('presentingComplaintValueDivGp').style.display = 'block';
document.getElementById('presentingComplaintValue').value=pCValue; 
<%}}%>

for(var i=0;i<arr.length;i++){
	for(var j=0;j<presentComplaintsElement.options.length;j++){
		if(arr[i].includes(presentComplaintsElement.options[j].value)){
			presentComplaintsElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getPresentingComplaintsOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getPresentingComplaintsOthersValue().equals("")){
		  %>

		  document.getElementById('presentingComplaintsOthersValueDiv').style.display = 'block';
		  document.getElementById('presentingComplaintsOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getPresentingComplaintsOthersValue()%>'; 
		  
		<%}%>

</script>  
 <label>Aggravating Factors</label>
<select  style="display: block;width:189px;height:60px;" multiple="multiple" id="aggravatingFactors" name="aggravatingFactors" 
onchange="showValues1(this,'aggravatingFactorsValue');displayGeneralProformaValueDivGp1(this.value,'aggravatingFactorsValueDivGp','aggravatingFactors','aggravatingFactorsValue','aggravatingFactorsOthersValueDiv');" >
<option value="Food">Food</option>
<option value="Drug">Drug</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="aggravatingFactorsValueDivGp">
<textarea class="historyAutoComplete" name="aggravatingFactorsValue" id="aggravatingFactorsValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="aggravatingFactorsOthersValueDiv">
<textarea  class="historyAutoComplete" type="text" id="aggravatingFactorsOthersValue" name="aggravatingFactorsOthersValue"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>
<script type="text/javascript">
 var arraggravatingFactors= new Array();
 var aFValue= '';
 var newLine = '';
<%if(aggravatingFactors !=null){
	int countAF = 0;
for(String aggravatingFactor : aggravatingFactors){ %>
arraggravatingFactors.push('<%=aggravatingFactor%>');
	<% countAF++ ;
	if(countAF != aggravatingFactors.length) { %>
	   newLine = "\n";
	<%} else {%>
	   newLine = '';
	<%}%>
    	aFValue = aFValue + ('<%=aggravatingFactor%>'.replace(/,/gi, '')) + newLine;	
<% } } %>
<%if(aggravatingFactors !=null){%>
var aggravatingFactorsElement = 	document.getElementById('aggravatingFactors');
		<%if(dermogeneralProformaHeadersList.get(0).getAggravatingFactorsValue()!=null && 
		!dermogeneralProformaHeadersList.get(0).getAggravatingFactorsValue().equals("")){%>
		document.getElementById('aggravatingFactorsValueDivGp').style.display = 'block';
		document.getElementById('aggravatingFactorsValue').value=aFValue; 
<%}}%>

for(var i=0;i<arraggravatingFactors.length;i++){
	for(var j=0;j<aggravatingFactorsElement.options.length;j++){
		if(arraggravatingFactors[i].includes(aggravatingFactorsElement.options[j].value)){
			aggravatingFactorsElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getAggravatingFactorsOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getAggravatingFactorsOthersValue().equals("")){
		  %>

		  document.getElementById('aggravatingFactorsOthersValueDiv').style.display = 'block';
		  document.getElementById('aggravatingFactorsOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getAggravatingFactorsOthersValue()%>'; 
		  
		<%}%>

</script>    

<label>Duration of Illness</label>
<input type="hidden" id="patientAge" name="patientAge" value="<%=patientAge %>" />
<input style="width:70px; text-align:center;" type="text" id="durationOfIllness" name="durationOfIllness" value=""  maxlength="5" validate="Duration Of Illness,float,no"   >
<select  name="durationParameter" id="durationParameter" style="width:112px" onchange="yearValidationDermo('durationOfIllness',this.id);">
<option value="">Select</option>
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years </option>
</select>
<div class="clear"></div>
<script>
<%if(durationOfIllness != null && durationOfIllness.length >0){%>
document.getElementById('durationOfIllness').value = '<%=durationOfIllness[0]%>';

var elements= document.getElementById('durationParameter');

for(var elementIndex=0;elementIndex <elements.options.length;elementIndex++ ){
	if(elements[elementIndex].value.includes('<%=durationOfIllness[1]%>')){
		elements.options[elementIndex].selected = true;
	}
}
<%}%>

</script>


<label>Past History</label>

<select  style="display: block;width:189px;height:60px;" id="pastHistory11" name="pastHistory11" multiple="multiple"
onchange="showValues1(this,'pastHistoryValue');displayGeneralProformaValueDivGp1(this.value,'pastHistoryValueDivGp','pastHistory11','pastHistoryValue','pastHistoryOthersValueDiv');">
<option value="Diabetes">Diabetes</option>
<option value="Hypertension">Hypertension</option>
<option value="Atopy">Atopy</option>
<option value="Epilepsy">Epilepsy</option>
<option value="TB">TB</option>
<option value="Asthma">Asthma</option>
<option value="Drug Allergy">Drug Allergy</option>
<option value="Jaundice">Jaundice</option>
<option value="Blood transfusion">Blood transfusion</option>
<option value="Thyroid disorders">Thyroid disorders</option>
<option value="Surgery">Surgery</option>
<option value="Similar Illness">Similar Illness</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="pastHistoryValueDivGp">
<textarea class="historyAutoComplete" name="pastHistoryValue" id="pastHistoryValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="pastHistoryOthersValueDiv">
<textarea  class="historyAutoComplete" type="text" id="pastHistoryOthersValue" name="pastHistoryOthersValue" maxlength="450"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="128" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>
<script type="text/javascript">
 var arrPastHistory= new Array();
 var pastHistoryValue= '';
 var pastHistoryLine = '';
<%if(pastHistioryValues !=null){
	int countPastHistory = 0;
for(String pastHistioryValue : pastHistioryValues){ %>
arrPastHistory.push('<%=pastHistioryValue%>');
	<% countPastHistory++ ;
	if(countPastHistory != pastHistioryValues.length) { %>
	pastHistoryLine = "\n";
	<%} else {%>
	pastHistoryLine = '';
	<%}%>
	 pastHistoryValue = pastHistoryValue + ('<%=pastHistioryValue%>'.replace(/,/gi, '')) + pastHistoryLine;	
<% } } %>
<%if(pastHistioryValues !=null){%>
var pastHistioryValuesElement = 	document.getElementById('presentingComplaints');
<%if(dermogeneralProformaHeadersList.get(0).getPastHistoryValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getPastHistoryValue().equals("")){%>
document.getElementById('pastHistoryValueDivGp').style.display = 'block';
document.getElementById('pastHistoryValue').value=pastHistoryValue; 
<%}}%>

for(var i=0;i<arrPastHistory.length;i++){
	for(var j=0;j<pastHistioryValuesElement.options.length;j++){
		if(arrPastHistory[i].includes(pastHistioryValuesElement.options[j].value)){
			pastHistioryValuesElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getPastHistoryOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getPastHistoryOthersValue().equals("")){
		  %>

		  document.getElementById('pastHistoryOthersValueDiv').style.display = 'block';
		  document.getElementById('pastHistoryOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getPastHistoryOthersValue()%>'; 
		  
		<%}%>

</script> 



<label class="heightAuto">Family History of similar illness</label>
<select class="widthSec"  name="familyHistoryOfSimilarIllness" id="familyHistoryOfSimilarIllness"  onchange="displayfamilyHistoryOfSimilarIllnessValue(this.value)">
<option value="">Select</option>
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
<div style="display: none" id="familyHistoryOfSimilarIllnessValueDiv">
<textarea  class="historyAutoComplete" type="text" name="familyHistoryOfSimilarIllnessValue" id="familyHistoryOfSimilarIllnessValue" style="display:block;width:190px;height:54px;margin-left:0;" value="" maxlength="128" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>
<script>

<%if(familyHistoryOfIllness != null && !familyHistoryOfIllness.equals("") ){%>

var familyHistoryElement = document.getElementById('familyHistoryOfSimilarIllness');
for(var index = 0; index < familyHistoryElement.options.length; index++ ){
	if(familyHistoryElement[index].value.includes('<%=familyHistoryOfIllness%>')){
		familyHistoryElement.options[index].selected = true;
		if('<%=familyHistoryOfIllness%>' == 'Present' && '<%=familyHistoryOfIllnessPresent%>' != null){
			 document.getElementById('familyHistoryOfSimilarIllnessValueDiv').style.display = 'block';
			 document.getElementById('familyHistoryOfSimilarIllnessValue').value ='<%=familyHistoryOfIllnessPresent%>';
		}
			
	}
}

<%}%>

</script> 


<label>Drug History</label>
<select class="widthSec"  name="drugHistory" id="drugHistory" onchange="displaydrugHistoryValue(this.value)">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div style="display: none" id="drugHistoryValueDiv">
<textarea class="historyAutoComplete" type="text" name="drugHistoryValue" id="drugHistoryValue" value="" style="display:block;width:190px;height:54px;margin-left:0;" maxlength="128" style="margin-left: 4px;"   ></textarea>
</div>

<div class="clear"></div>
<script>
<%if(drugHistory != null && !drugHistory.equals("") ){%>

var drugHistoryElement = document.getElementById('drugHistory');
for(var index = 0; index < drugHistoryElement.options.length; index++ ){
	if(drugHistoryElement[index].value.includes('<%=drugHistory%>')){
		drugHistoryElement.options[index].selected = true;
		if('<%=drugHistory%>' == 'Yes' && '<%=drugHistoryvalue%>' != null ){
			 document.getElementById('drugHistoryValueDiv').style.display = 'block';
			 document.getElementById('drugHistoryValue').value ='<%=drugHistoryvalue%>';
		}
			
	}
}

<%}%>

</script>

 <!-- Jyotish changes-->
 <h4>Vital Signs</h4>
<div class="divisionSolid"></div>
					<label class="auto">Pulse</label> <input
						class="textYellow allownumericwithoutdecimal widthFixed26"
						name="dermoPulse" type="text" id="dermoPulse"
						maxlength="3"
						value="" onblur="setVitalValue(this.value,'pulse')" onkeypress="return isNumberDecimal(event)"/> <label
						class="smallAuto">min</label> <label class="auto">Temperature</label>
						<input class="textYellow allownumericwithdecimal textSmall" 
						name="dermoTemperature" id="dermoTemperature" type="text" maxlength="5" validate="temperature,float,no"
						value=""  onblur="setVitalValue(this.value,'temperature')" onkeypress="return isNumber(event)" /> <label
						class="smallAuto">&deg;F</label>
						<label class="auto" id="bpLabel">BP</label> <input
						name="dermoSystolic" id="systolicTempforgp"  placeholder="Systolic / Diastolic"
						value="" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal widthFixed26" onblur="commonDiastolicSystolicforGeneralProforma();setVitalValue(this.value,'systolic');" onkeypress="return isNumberOnly(event)" /> <label
						id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
						<input name="dermoDiastolic" id="diastolicTempforgp" 
						placeholder="Diastolic"
						value="" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal widthFixed26" onblur="commonDiastolicSystolicforGeneralProforma();setVitalValue(this.value,'diastolic');" onkeypress="return isNumberOnly(event)"  />
						<label class="smallAuto">mm&nbsp;Hg</label> 
                        
                        <label class="auto">Height</label>
						<input	name="dermoHeight" id="dermoHeight" type="text"  maxlength="3" class="allownumericwithoutdecimal widthFixed26"  value="" onblur="calculateDermotologyBMI();setVitalValue(this.value,'height')"  onkeypress="return isNumberDecimal(event)" />
						<label	class="smallAuto">&nbsp;cm</label>
												
						<label class="auto">Weight</label>
						<input name="dermoWeight"  onkeypress="return isNumberDecimal(event)" id="dermoWeight" type="text" maxlength="6"  class="allownumericwithdecimal textSmall"  value="" onblur="calculateDermotologyBMI();setVitalValue(this.value,'weight')"  onkeypress="return isNumberOnly(event)" />
						<input name="headCircumference"  id="headCircumference" type="hidden" maxlength="6"  class="allownumericwithdecimal textSmall"  value=""  />
						<label	class="smallAuto">&nbsp;Kg&nbsp;</label>
						<label class="auto" id="bpLabel">BMI</label>
						<input	name="dermoBmi" id="dermoBmi"  type="text" value=""  readonly="readonly" class="textSmall"  style="width:55px;" onblur="setVitalValue(this.value,'bmi')" />
						<label class="smallAuto" style="min-width:17px;" id="demoBmiCat"></label>
						
	<label class="auto">Respiratory Rate</label>
	<input class="textYellow allownumericwithdecimal widthFixed26" onkeypress="return isNumberDecimal(event)" name="dermoRespiratoryRate" id="dermoRespiratoryRate" type="text" maxlength="3" value=""  onblur="setVitalValue(this.value,'respiratoryRate')"/>
	<label class="auto">Spo2</label>
	<input class="textYellow allownumericwithdecimal widthFixed26" onkeypress="return isNumberDecimal(event)" name="dermoSpo2" id="dermoSpo2" type="text" maxlength="3" value="" onblur="setVitalValue(this.value,'spo2')"/>
<label	class="smallAuto">&nbsp;%</label>
		<div class="divisionSolid"></div>	
<div class="clear"></div> 
<script>
<%if(opdPatDetailsList.size() > 0){%>
document.getElementById('dermoPulse').value ='<%=pulse%>';
document.getElementById('dermoTemperature').value ='<%=temprature%>';
document.getElementById('systolicTempforgp').value ='<%=bpSystolic%>';
document.getElementById('diastolicTempforgp').value ='<%=bpDiastolic%>';
document.getElementById('dermoHeight').value ='<%=height%>';
document.getElementById('dermoWeight').value ='<%=weight%>';
document.getElementById('dermoBmi').value ='<%=bmi%>';
document.getElementById('dermoRespiratoryRate').value ='<%=respRate%>';
document.getElementById('dermoSpo2').value ='<%=spo2%>';

<%}%>


</script>



<!-- Jyotish changes end-->
<h6>Dermatological Examination</h6>
<div class="clear"></div>
<h4>Primary Lesion</h4>
<input type="button" class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForPrimaryLesionForGeneralProforma('General Performa');" />
<input type="button" class="buttonDel" alt="Delete" value="&nbsp;" onclick="removeRowForPrimaryLesion();" />
  <div class="clear"></div>
  
   <div style="width:1160px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" id="primaryLessionGrid"> 
   <% int firstGridIndex=1;%>
    <tr>
    <th align="center"></th>
      <th align="center">Primary Lesion</th>
      <th align="center">Number</th>
      <th align="center">Site</th>
      <th align="center">Type of Lesions</th>
      <th align="center">Pigmentation</th>
       <th align="center">Character</th> 
       <th align="center">Border</th>
       <th align="center">Surface</th>
       <th align="center">Size</th>
        <th align="center">Hair on Lesion</th>
         <th align="center">Additional Feature</th> 
    </tr>
   <%if(dermogeneralProformaDetailsList.size() >0) { 
    	 for(OpdGeneralProformaDetail performaDetail : dermogeneralProformaDetailsList){
    		
    	%>
     
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="primaryLesionRadio<%=firstGridIndex%>" id="primaryLesionRadio<%=firstGridIndex%>" /></td> 
		<td>
		<select name="primaryLesion<%=firstGridIndex%>" id="primaryLesion<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Macule" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Macule")?"selected":"" %>>Macule</option>
		<option value="Papule" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Papule")?"selected":"" %>>Papule</option>
		<option value="Plaque" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Plaque")?"selected":"" %>>Plaque</option>
		<option value="Nodule" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Nodule")?"selected":"" %>>Nodule</option>
		<option value="Wheal" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Wheal")?"selected":"" %>>Wheal</option>
		<option value="Bulla" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Bulla")?"selected":"" %>>Bulla</option>
		<option value="Pustule" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Pustule")?"selected":"" %>>Pustule</option>
		<option value="Comedone" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Comedone")?"selected":"" %>>Comedone</option>
		<option value="Burrow" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Burrow")?"selected":"" %>>Burrow</option>
		<option value="Tumor" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Tumor")?"selected":"" %>>Tumor</option>
		<option value="Vesicle" <%=performaDetail.getParameterName()!=null && performaDetail.getParameterName().contains("Vesicle")?"selected":"" %>>Vesicle</option>
		</select>
		</td>
      <td>
		<select name="primaryLesionNo<%=firstGridIndex%>" id="primaryLesionNo<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Single" <%=performaDetail.getNumber()!=null && performaDetail.getNumber().contains("Single")?"selected":"" %>>Single</option>
		<option value="Multiple" <%=performaDetail.getNumber()!=null && performaDetail.getNumber().contains("Multiple")?"selected":"" %>>Multiple</option>
		<option value="Generalized" <%=performaDetail.getNumber()!=null && performaDetail.getNumber().contains("Generalized")?"selected":"" %>>Generalized</option>
		</select>
		</td>
      <td>
		<select name="primaryLesionSite<%=firstGridIndex%>" id="primaryLesionSite<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Scalp" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Scalp")?"selected":"" %>>Scalp</option>
		<option value="Face" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Face")?"selected":"" %>>Face</option>
		<option value="Neck" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Neck")?"selected":"" %>>Neck</option>
		<option value="Upper Limb" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Upper Limb")?"selected":"" %>>Upper Limb</option>
		<option value="Trunk" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Trunk")?"selected":"" %>>Trunk</option>
		<option value="Lower Limb" <%=performaDetail.getSite()!=null && performaDetail.getSite().contains("Lower Limb")?"selected":"" %>>Lower Limb</option>
		</select>
		</td>
      <td>
		<select name="typeOfPrimaryLesion<%=firstGridIndex%>" id="typeOfPrimaryLesion<%=firstGridIndex%>" style="width:75px;">
		<option value="">Select</option>
		<option value="Discrete" <%=performaDetail.getTypeOfLesion()!=null && performaDetail.getTypeOfLesion().contains("Discrete")?"selected":"" %>>Discrete</option>
		<option value="Confluent" <%=performaDetail.getTypeOfLesion()!=null && performaDetail.getTypeOfLesion().contains("Confluent")?"selected":"" %>>Confluent</option>
		</select>
		</td>
     <td>
		<select name="primaryPigmentation<%=firstGridIndex%>" id="primaryPigmentation<%=firstGridIndex%>" style="width:105px;" onchange="displayprimaryPigmentationValue(this.value,'1');">
		<option value="">Select</option>
		<option value="Yes" <%=performaDetail.getPigmentationStatus()!=null && performaDetail.getPigmentationStatus().contains("Yes")?"selected":"" %>>Yes</option>
		<option value="No" <%=performaDetail.getPigmentationStatus()!=null && performaDetail.getPigmentationStatus().contains("No")?"selected":"" %>>No</option>
		</select>
		<%if(performaDetail.getPigmentationStatus()!=null && performaDetail.getPigmentationStatus().contains("Yes")) {%>
		<div style="display: block" id="primaryPigmentationValueDiv1"> 
		<%} else { %>
		<div style="display: none" id="primaryPigmentationValueDiv1"> 
		<%} %>
		<div class="clear"></div>
		<select name="primaryPigmentationValue<%=firstGridIndex%>" id="primaryPigmentationValue<%=firstGridIndex%>" style="width:105px;">
		<option value="">Select</option>
		<option value="Erythematous" <%=performaDetail.getPigmentation()!=null && performaDetail.getPigmentation().contains("Erythematous")?"selected":"" %>>Erythematous</option>
		<option value="Violaceous" <%=performaDetail.getPigmentation()!=null && performaDetail.getPigmentation().contains("Violaceous")?"selected":"" %>>Violaceous</option>
		<option value="Hypo pigmented" <%=performaDetail.getPigmentation()!=null && performaDetail.getPigmentation().contains("Hypo pigmented")?"selected":"" %>>Hypo pigmented</option>
		<option value="Hyper pigmented" <%=performaDetail.getPigmentation()!=null && performaDetail.getPigmentation().contains("Hyper pigmented")?"selected":"" %>>Hyper pigmented</option>
		<option value="De pigmented" <%=performaDetail.getPigmentation()!=null && performaDetail.getPigmentation().contains("De pigmented")?"selected":"" %>>De pigmented</option>
		</select></div>
	 	</td>
		 <td>
		<select name="primaryCharacter<%=firstGridIndex%>" id="primaryCharacter<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Flat" <%=performaDetail.getCharcter()!=null && performaDetail.getCharcter().contains("Flat")?"selected":"" %>>Flat</option>
		<option value="Raised" <%=performaDetail.getCharcter()!=null && performaDetail.getCharcter().contains("Raised")?"selected":"" %>>Raised</option>
		<option value="Fluid Filled" <%=performaDetail.getCharcter()!=null && performaDetail.getCharcter().contains("Fluid Filled")?"selected":"" %>>Fluid Filled</option>
		<option value="Pustule" <%=performaDetail.getCharcter()!=null && performaDetail.getCharcter().contains("Pustule")?"selected":"" %>>Pustule</option>
		</select>
		</td> 
		<td>
		<select name="primaryBorder<%=firstGridIndex%>" id="primaryBorder<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Well defined" <%=performaDetail.getBorder()!=null && performaDetail.getBorder().contains("Well defined")?"selected":"" %>>Well defined</option>
		<option value="Partially Ill Defined" <%=performaDetail.getBorder()!=null && performaDetail.getBorder().contains("Partially Ill Defined")?"selected":"" %>>Partially Ill Defined</option>
		<option value="Ill Defined" <%=performaDetail.getBorder()!=null && performaDetail.getBorder().contains("Ill Defined")?"selected":"" %>>Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="primarySurface<%=firstGridIndex%>" id="primarySurface<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Smooth" <%=performaDetail.getSurface()!=null && performaDetail.getSurface().contains("Smooth")?"selected":"" %>>Smooth</option>
		<option value="Rough" <%=performaDetail.getSurface()!=null && performaDetail.getSurface().contains("Rough")?"selected":"" %>>Rough</option>
		<option value="Dry" <%=performaDetail.getSurface()!=null && performaDetail.getSurface().contains("Dry")?"selected":"" %>>Dry</option>
		</select>
		</td>
		<td align="left">
		<div style="float:left; width:155px;">
		<input  type="text" maxlength="10" validate="Small Size,int,no"  value="<%=performaDetail.getSmallestSize()!=null ?performaDetail.getSmallestSize():""%>" 
		name="primarySmallestSize<%=firstGridIndex%>" id="primarySmallestSize<%=firstGridIndex%>" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" validate="Large Size,int,no"  id="primaryLargestSize<%=firstGridIndex%>" name="primaryLargestSize<%=firstGridIndex%>" value="<%=performaDetail.getLargestSize()!=null? performaDetail.getLargestSize():""%>"   class="medium" />
		<label class="smallAuto">Largest Lesion</label>
		</div>
		</td>
		<td>
		<select name="hairOnPrimaryLesion<%=firstGridIndex%>" id="hairOnPrimaryLesion<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Normal" <%=performaDetail.getHairOnLesion()!=null && performaDetail.getHairOnLesion().contains("Normal")?"selected":"" %>>Normal</option>
		<option value="De pigmented" <%=performaDetail.getHairOnLesion()!=null && performaDetail.getHairOnLesion().contains("De pigmented")?"selected":"" %>>De pigmented</option>
		</select>
		</td>
		<td><input  type="text"  validate="Additional Feature,metachar,no"  value="<%=performaDetail.getAggravatingFactors()!=null ? performaDetail.getAggravatingFactors():""%>" id="primaryAdditionalFeature<%=firstGridIndex%>" name="primaryAdditionalFeature<%=firstGridIndex%>" maxlength="100" class="medium" /></td> 
	    </tr>
	    <%  firstGridIndex++; }} else{ %>

   <tr>
      <td><input  type="checkbox" class="radioCheck" name="primaryLesionRadio<%=firstGridIndex%>" id="primaryLesionRadio<%=firstGridIndex%>" /></td> 
		<td>
		<select name="primaryLesion<%=firstGridIndex%>" id="primaryLesion<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Macule" >Macule</option>
		<option value="Papule" >Papule</option>
		<option value="Plaque" >Plaque</option>
		<option value="Nodule" >Nodule</option>
		<option value="Wheal" >Wheal</option>
		<option value="Bulla" >Bulla</option>
		<option value="Pustule" >Pustule</option>
		<option value="Comedone" >Comedone</option>
		<option value="Burrow" >Burrow</option>
		<option value="Tumor" >Tumor</option>
		<option value="Vesicle" >Vesicle</option>
		</select>
		</td>
     <td>
		<select name="primaryLesionNo<%=firstGridIndex%>" id="primaryLesionNo<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Single" >Single</option>
		<option value="Multiple" >Multiple</option>
		<option value="Generalized" >Generalized</option>
		</select>
		</td>
      <!-- <td align="left"><input type="text" maxlength="16" validate="Site,metachar,no"  value="" name="primaryLesionSite1" class="medium" /></td> -->
      <td>
		<select name="primaryLesionSite<%=firstGridIndex%>" id="primaryLesionSite<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Scalp">Scalp</option>
		<option value="Face">Face</option>
		<option value="Neck">Neck</option>
		<option value="Upper Limb">Upper Limb</option>
		<option value="Trunk" >Trunk</option>
		<option value="Lower Limb" >Lower Limb</option>
		</select>
		</td>
      <td>
		<select name="typeOfPrimaryLesion<%=firstGridIndex%>" id="typeOfPrimaryLesion<%=firstGridIndex%>" style="width:75px;">
		<option value="">Select</option>
		<option value="Discrete" >Discrete</option>
		<option value="Confluent" >Confluent</option>
		</select>
		</td>
     <td>
		<select name="primaryPigmentation<%=firstGridIndex%>" id="primaryPigmentation<%=firstGridIndex%>" style="width:105px;" onchange="displayprimaryPigmentationValue(this.value,'1');">
		<option value="">Select</option>
		<option value="Yes" >Yes</option>
		<option value="No" >No</option>
		</select>
		<div style="display: none" id="primaryPigmentationValueDiv1"> 
		<div class="clear"></div>
		<select name="primaryPigmentationValue<%=firstGridIndex%>" id="primaryPigmentationValue<%=firstGridIndex%>" style="width:105px;">
		<option value="">Select</option>
		<option value="Erythematous">Erythematous</option>
		<option value="Violaceous" >Violaceous</option>
		<option value="Hypo pigmented" >Hypo pigmented</option>
		<option value="Hyper pigmented" >Hyper pigmented</option>
		<option value="De pigmented" >De pigmented</option>
		</select></div>
	 	</td>
		 <td>
		<select name="primaryCharacter<%=firstGridIndex%>" id="primaryCharacter<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Flat" >Flat</option>
		<option value="Raised" >Raised</option>
		<option value="Fluid Filled" >Fluid Filled</option>
		<option value="Pustule">Pustule</option>
		</select>
		</td> 
		<td>
		<select name="primaryBorder<%=firstGridIndex%>" id="primaryBorder<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Well defined" >Well defined</option>
		<option value="Partially Ill Defined" >Partially Ill Defined</option>
		<option value="Ill Defined" >Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="primarySurface<%=firstGridIndex%>" id="primarySurface<%=firstGridIndex%>" class="smaller">
		<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Rough" >Rough</option>
		<option value="Dry" >Dry</option>
		</select>
		</td>
		<td align="left">
		<div style="float:left; width:155px;">
		<input  type="text" maxlength="10" validate="Small Size,int,no"  value="" 
		name="primarySmallestSize<%=firstGridIndex%>" id="primarySmallestSize<%=firstGridIndex%>" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" validate="Large Size,int,no"  name="primaryLargestSize<%=firstGridIndex%>" id="primaryLargestSize<%=firstGridIndex%>" value=""  class="medium" />
		<label class="smallAuto">Largest Lesion</label>
		</div>
		</td>
		<td>
		<select name="hairOnPrimaryLesion<%=firstGridIndex%>" id="hairOnPrimaryLesion<%=firstGridIndex%>" class="medium2">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		<td><input  type="text"  validate="Additional Feature,metachar,no"  value="" id="primaryAdditionalFeature<%=firstGridIndex%>" name="primaryAdditionalFeature<%=firstGridIndex%>" maxlength="100" class="medium" /></td>
	    </tr>
    
       <%} %>
      </table>
  </div> 
  
  <input type="hidden" name="primaryLesionCount" id="primaryLesionCount" value="<%=firstGridIndex%>" />
   <div class="clear"></div>
     <label>Others</label>

<input type="text"  id="primaryLessionOthers" name="primaryLessionOthers"  value=""  maxlength="250"/>

<div class="clear"></div> 

<script>

<%if(primaryLessionOthers != null && !primaryLessionOthers.equals("")){%>

document.getElementById('primaryLessionOthers').value ='<%=primaryLessionOthers%>';
<%}%>

</script>


  <h4>Secondary Lesion</h4>
  <div class="clear"></div>
  
<input type="button" class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForSecondaryLesion();" />
<input type="button" class="buttonDel"  alt="Delete" value="&nbsp;" onclick="removeRowForSecondaryLesion();" />
  <div class="clear"></div>     
  <div style="width:1160px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" style="float:left;" class="tablestyle" id="secondaryLessionGrid"> 
   <% int secondGridIndex=1;%>
    <tr>
    <th align="center"></th>
      <th align="center">Secondary Lesion</th>
      <th align="center">Number</th>
      <th align="center">Site</th>
      <th align="center">Type of Lesions</th>
      <th align="center">Pigmentation</th>
       <!-- <th align="center">Character</th> -->
       <th align="center">Border</th>
       <th align="center">Surface</th>
       <th align="center">Size</th>
        <th align="center">Hair on Lesion</th>
         <th align="center">Additional Feature</th>
    </tr>
     <%if(dermogeneralProformaDetailsListSecond.size() >0) { 
    	 for(OpdGeneralProformaDetail performaDetailSecondary : dermogeneralProformaDetailsListSecond){
    	%>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="secondaryLesionRadio<%=secondGridIndex %>" id="secondaryLesionRadio<%=secondGridIndex %>" /></td> 
		<td>
		<select name="secondaryLesion<%=secondGridIndex %>" id="secondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Erosion" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Erosion")?"selected":"" %>>Erosion</option>
		<option value="Ulcer" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Ulcer")?"selected":"" %>>Ulcer</option>
		<option value="Scale" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Scale")?"selected":"" %>>Scale</option>
		<option value="Crust" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Crust")?"selected":"" %>>Crust</option>
		<option value="Lichenification" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Lichenification")?"selected":"" %>>Lichenification</option>
		<option value="Vesicle" <%=performaDetailSecondary.getParameterName()!=null && performaDetailSecondary.getParameterName().contains("Vesicle")?"selected":"" %>>Vesicle</option>
		</select>
		</td>
     <td>
		<select name="secondaryLesionNo<%=secondGridIndex %>" id="secondaryLesionNo<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Single" <%=performaDetailSecondary.getNumber()!=null && performaDetailSecondary.getNumber().contains("Single")?"selected":"" %>>Single</option>
		<option value="Multiple" <%=performaDetailSecondary.getNumber()!=null && performaDetailSecondary.getNumber().contains("Multiple")?"selected":"" %>>Multiple</option>
		<option value="Generalized" <%=performaDetailSecondary.getNumber()!=null && performaDetailSecondary.getNumber().contains("Generalized")?"selected":"" %>>Generalized</option>
		</select>
		</td>
      <!-- <td align="left"><input  type="text" maxlength="32" validate="Site,metachar,no"  value="" name="secondaryLesionSite1"  class="medium" /></td> -->
      <td>
		<select name="secondaryLesionSite<%=secondGridIndex %>" id="secondaryLesionSite<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Scalp" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Scalp")?"selected":"" %>>Scalp</option>
		<option value="Face" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Face")?"selected":"" %>>Face</option>
		<option value="Neck" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Neck")?"selected":"" %>>Neck</option>
		<option value="Upper Limb" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Upper Limb")?"selected":"" %>>Upper Limb</option>
		<option value="Trunk" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Trunk")?"selected":"" %>>Trunk</option>
		<option value="Lower Limb" <%=performaDetailSecondary.getSite()!=null && performaDetailSecondary.getSite().contains("Lower Limb")?"selected":"" %>>Lower Limb</option>
		</select>
		</td>
      <td>
		<select name="typeOfSecondaryLesion<%=secondGridIndex %>" id="typeOfSecondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Discrete" <%=performaDetailSecondary.getTypeOfLesion()!=null && performaDetailSecondary.getTypeOfLesion().contains("Discrete")?"selected":"" %>>Discrete</option>
		<option value="Confluent" <%=performaDetailSecondary.getTypeOfLesion()!=null && performaDetailSecondary.getTypeOfLesion().contains("Confluent")?"selected":"" %>>Confluent</option>
		</select>
		</td>
     <td>
		
		
	
<select class="widthSec"  name="secondaryPigmentation<%=secondGridIndex %>" id="secondaryPigmentation<%=secondGridIndex %>" style="width:105px;" onchange="displaysecondaryPigmentationValue(this.value,'1')">
<option value="">Select</option> 
<option value="Yes" <%=performaDetailSecondary.getPigmentationStatus()!=null && performaDetailSecondary.getPigmentationStatus().contains("Yes")?"selected":"" %>>Yes</option>
<option value="No" <%=performaDetailSecondary.getPigmentationStatus()!=null && performaDetailSecondary.getPigmentationStatus().contains("No")?"selected":"" %>>No</option>
</select>
<%if(performaDetailSecondary.getPigmentationStatus()!=null && performaDetailSecondary.getPigmentationStatus().equalsIgnoreCase("Yes")) {%>
<div style="display: block" id="secondaryPigmentationValueDiv1">
<%} else { %>
<div style="display: none" id="secondaryPigmentationValueDiv1">
<%} %>
<div class="clear"></div>
<select name="secondaryPigmentationValue<%=secondGridIndex %>" id="secondaryPigmentationValue<%=secondGridIndex %>" style="width:105px;">
		<option value="">Select</option>
		<option value="Erythematous" <%=performaDetailSecondary.getPigmentation()!=null && performaDetailSecondary.getPigmentation().contains("Erythematous")?"selected":"" %>>Erythematous</option>
		<option value="Violaceous" <%=performaDetailSecondary.getPigmentation()!=null && performaDetailSecondary.getPigmentation().contains("Violaceous")?"selected":"" %>>Violaceous</option>
		<option value="Hypo pigmented" <%=performaDetailSecondary.getPigmentation()!=null && performaDetailSecondary.getPigmentation().contains("Hypo pigmented")?"selected":"" %>>Hypo pigmented</option>
		<option value="Hyper pigmented" <%=performaDetailSecondary.getPigmentation()!=null && performaDetailSecondary.getPigmentation().contains("Hyper pigmented")?"selected":"" %>>Hyper pigmented</option>
		<option value="De pigmented" <%=performaDetailSecondary.getPigmentation()!=null && performaDetailSecondary.getPigmentation().contains("De pigmented")?"selected":"" %>>De pigmented</option>
		</select>
</div>
		
		<td>
		<select name="secondaryBorder<%=secondGridIndex %>" id="secondaryBorder<%=secondGridIndex %>">
		<option value="">Select</option>
		<option value="Well defined" <%=performaDetailSecondary.getBorder()!=null && performaDetailSecondary.getBorder().contains("Well defined")?"selected":"" %>>Well defined</option>
		<option value="Partially Ill Defined" <%=performaDetailSecondary.getBorder()!=null && performaDetailSecondary.getBorder().contains("Partially Ill Defined")?"selected":"" %>>Partially Ill Defined</option>
		<option value="Ill Defined" <%=performaDetailSecondary.getBorder()!=null && performaDetailSecondary.getBorder().contains("Ill Defined")?"selected":"" %>>Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="secondarySurface<%=secondGridIndex %>" id="secondarySurface<%=secondGridIndex %>" class="smaller">
		<option value="">Select</option>
		<option value="Smooth" <%=performaDetailSecondary.getSurface()!=null && performaDetailSecondary.getSurface().contains("Smooth")?"selected":"" %>>Smooth</option>
		<option value="Rough" <%=performaDetailSecondary.getSurface()!=null && performaDetailSecondary.getSurface().contains("Rough")?"selected":"" %>>Rough</option>
		<option value="Dry" <%=performaDetailSecondary.getSurface()!=null && performaDetailSecondary.getSurface().contains("Dry")?"selected":"" %>>Dry</option>
		</select>
		</td>
		<td align="left">
		<div style="float:left; width:155px;">
		<input  type="text" maxlength="10" validate="Size,int,no"  value="<%=performaDetailSecondary.getSmallestSize()!=null ?performaDetailSecondary.getSmallestSize():"" %>" id="secondarySmallestSize<%=secondGridIndex %>" name="secondarySmallestSize<%=secondGridIndex %>" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" validate="size,int,no"  value="<%=performaDetailSecondary.getLargestSize()!=null ?performaDetailSecondary.getLargestSize():"" %>" id="secondaryLargestSize<%=secondGridIndex %>" name="secondaryLargestSize<%=secondGridIndex %>" class="medium" />
		<label class="smallAuto">Largest Lesion</label>
		</div>		
		</td>
		<td>
		<select name="hairOnSecondaryLesion<%=secondGridIndex %>" id="hairOnSecondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Normal" <%=performaDetailSecondary.getHairOnLesion()!=null && performaDetailSecondary.getHairOnLesion().contains("Normal")?"selected":"" %>>Normal</option>
		<option value="De pigmented" <%=performaDetailSecondary.getHairOnLesion()!=null && performaDetailSecondary.getHairOnLesion().contains("De pigmented")?"selected":"" %>>De pigmented</option>
		</select>
		</td>
		<td><input  type="text"  validate="Additional Feature,metachar,no"  value="<%=performaDetailSecondary.getAggravatingFactors()!=null ?performaDetailSecondary.getAggravatingFactors():"" %>" id="secondaryAdditionalFeature<%=secondGridIndex %>" name="secondaryAdditionalFeature<%=secondGridIndex %>" maxlength="100" class="medium" /></td>
    </tr>
    <% secondGridIndex++;}} else { %>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="secondaryLesionRadio<%=secondGridIndex %>" id="secondaryLesionRadio<%=secondGridIndex %>" /></td> 
		<td>
		<select name="secondaryLesion<%=secondGridIndex %>" id="secondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Erosion">Erosion</option>
		<option value="Ulcer">Ulcer</option>
		<option value="Scale">Scale</option>
		<option value="Crust">Crust</option>
		<option value="Lichenification">Lichenification</option>
		<option value="Vesicle">Vesicle</option>
		</select>
		</td>
     <td>
		<select name="secondaryLesionNo<%=secondGridIndex %>" id="secondaryLesionNo<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Single">Single</option>
		<option value="Multiple">Multiple</option>
		<option value="Generalized">Generalized</option>
		</select>
		</td>
      <!-- <td align="left"><input  type="text" maxlength="32" validate="Site,metachar,no"  value="" name="secondaryLesionSite1"  class="medium" /></td> -->
      <td>
		<select name="secondaryLesionSite<%=secondGridIndex %>" id="secondaryLesionSite<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Scalp">Scalp</option>
		<option value="Face">Face</option>
		<option value="Neck">Neck</option>
		<option value="Upper Limb">Upper Limb</option>
		<option value="Trunk">Trunk</option>
		<option value="Lower Limb">Lower Limb</option>
		</select>
		</td>
      <td>
		<select name="typeOfSecondaryLesion<%=secondGridIndex %>" id="typeOfSecondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Discrete">Discrete</option>
		<option value="Confluent">Confluent</option>
		</select>
		</td>
     <td>
		
		
	
<select class="widthSec"  name="secondaryPigmentation<%=secondGridIndex %>" id="secondaryPigmentation<%=secondGridIndex %>" style="width:105px;" onchange="displaysecondaryPigmentationValue(this.value,'1')">
<option value="">Select</option> 
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div style="display: none" id="secondaryPigmentationValueDiv1">
<select name="secondaryPigmentationValue<%=secondGridIndex %>" id="secondaryPigmentationValue<%=secondGridIndex %>" style="width:105px;">
		<option value="">Select</option>
		<option value="Erythematous">Erythematous</option>
		<option value="Violaceous">Violaceous</option>
		<option value="Hypo pigmented">Hypo pigmented</option>
		<option value="Hyper pigmented">Hyper pigmented</option>
		<option value="De pigmented">De pigmented</option>
		</select>
</div>
		
		<td>
		<select name="secondaryBorder<%=secondGridIndex %>" id="secondaryBorder<%=secondGridIndex %>">
		<option value="">Select</option>
		<option value="Well defined">Well defined</option>
		<option value="Partially Ill Defined">Partially Ill Defined</option>
		<option value="Ill Defined">Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="secondarySurface<%=secondGridIndex %>" id="secondarySurface<%=secondGridIndex %>" class="smaller">
		<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Rough">Rough</option>
		<option value="Dry">Dry</option>
		</select>
		</td>
		<td align="left">
		<div style="float:left; width:155px;">
		<input  type="text" maxlength="10" validate="Size,int,no"  value="" id="secondarySmallestSize<%=secondGridIndex %>" name="secondarySmallestSize<%=secondGridIndex %>" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" validate="size,int,no"  value="" id="secondaryLargestSize<%=secondGridIndex %>" name="secondaryLargestSize<%=secondGridIndex %>" class="medium" />
		<label class="smallAuto">Largest Lesion</label>
		</div>		
		</td>
		<td>
		<select name="hairOnSecondaryLesion<%=secondGridIndex %>" id="hairOnSecondaryLesion<%=secondGridIndex %>" class="medium2">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		<td><input  type="text"  validate="Additional Feature,metachar,no"  value="" id="secondaryAdditionalFeature<%=secondGridIndex %>" name="secondaryAdditionalFeature<%=secondGridIndex %>" maxlength="100" class="medium" /></td>
    
    <%} %>
     </table>
     </div>

<div class="clear"></div>
  <input type="hidden" name="secondaryLesionCount" id="secondaryLesionCount" value="<%=secondGridIndex %>" />
   <div class="clear"></div>
    <label>Others</label>
<input type="text"  id="secondaryLessionOthers" name="secondaryLessionOthers"  value=""  maxlength="250"/>
 <div class="clear"></div>
 <script>
 <%if(secondaryLessionOthers != null && !secondaryLessionOthers.equals("")){%>

document.getElementById('secondaryLessionOthers').value ='<%=secondaryLessionOthers%>';
<%}%>
</script>
 
<div class="paddingTop5"></div>
  <label>Distribution</label>
  
 <select style="display:block;width:189px;height:60px;" multiple="multiple" id="genDistribution" name="genDistribution"
onchange="showValues1(this,'distributionValue');
displayGeneralProformaValueDivGp1(this.value,'distributionValueDivGp','genDistribution','distributionValue','');"  >
<option value="Scalp">Scalp</option>
<option value="Face">Face</option>
<option value="Upper Limbs">Upper Limbs</option>
<option value="Trunk">Trunk</option>
<option value="Lower limbs">Lower limbs</option>
</select>
<div style="display: none" id="distributionValueDivGp">
<textarea class="historyAutoComplete" name="distributionValue" id="distributionValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>

<div class="clear"></div>

<script type="text/javascript">
 var arrDist= new Array();
 var distValue= '';
 var distLine = '';
<%if(distributionValues !=null){
	int countDist = 0;
for(String distributionValue : distributionValues){ %>
   arrDist.push('<%=distributionValue%>');
	<% countDist++ ;
	if(countDist != distributionValues.length) { %>
	distLine = "\n";
	<%} else {%>
	distLine = '';
	<%}%>
	distValue = distValue + ('<%=distributionValue%>'.replace(/,/gi, '')) + distLine;	
<% } } %>
<%if(distributionValues !=null){%>
var distributionValuesElement = 	document.getElementById('genDistribution');
<%if(dermogeneralProformaHeadersList.get(0).getDistributionParameterValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getDistributionParameterValue().equals("")){%>
document.getElementById('distributionValueDivGp').style.display = 'block';
document.getElementById('distributionValue').value=distValue; 
<%}}%>

for(var i=0;i<arrDist.length;i++){
	for(var j=0;j<distributionValuesElement.options.length;j++){
		if(arrDist[i].includes(distributionValuesElement.options[j].value)){
			distributionValuesElement.options[j].selected = true;
		}
	}
} 

</script>  




<label>Mucous Membrane</label>

<select style="display:block;width:189px;height:60px;" name="mucousMembrane" id="mucousMembrane"  multiple="multiple"
onchange="showValues1(this,'mucousMenbraneValue');
displayGeneralProformaValueDivGp1(this.value,'mucousMenbraneValueDivGp','mucousMembrane','mucousMenbraneValue','mucousMenbraneOthersValueDiv');" >
<option value="Oral">Oral</option>
<option value="Eyes">Eyes</option>
<option value="Nasal">Nasal</option>
<option value="Genital">Genital</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="mucousMenbraneValueDivGp">
<textarea class="historyAutoComplete" name="mucousMenbraneValue" id="mucousMenbraneValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="mucousMenbraneOthersValueDiv">
<textarea  class="historyAutoComplete" type="text" id="mucousMenbraneOthersValue" name="mucousMenbraneOthersValue"    style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>
<script type="text/javascript">
 var arrMucousMembrane= new Array();
 var mucousMembraneValue= '';
 var mucousMembraneLine = '';
<%if(mucousMembraneValues !=null){
	int mucousMembraneCount = 0;
for(String mucousMembraneValue : mucousMembraneValues){ %>
arrMucousMembrane.push('<%=mucousMembraneValue%>');
	<% mucousMembraneCount++ ;
	if(mucousMembraneCount != mucousMembraneValues.length) { %>
	mucousMembraneLine = "\n";
	<%} else {%>
	mucousMembraneLine = '';
	<%}%>
	mucousMembraneValue = mucousMembraneValue + ('<%=mucousMembraneValue%>'.replace(/,/gi, '')) + mucousMembraneLine;	
<% } } %>
<%if(mucousMembraneValues !=null){%>
var mucousMembraneValuesElement = 	document.getElementById('mucousMembrane');
<%if(dermogeneralProformaHeadersList.get(0).getMucousMenbraneValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getMucousMenbraneValue().equals("")){%>
document.getElementById('mucousMenbraneValueDivGp').style.display = 'block';
document.getElementById('mucousMenbraneValue').value=mucousMembraneValue; 
<%}}%>

for(var i=0;i<arrMucousMembrane.length;i++){
	for(var j=0;j<mucousMembraneValuesElement.options.length;j++){
		if(arrMucousMembrane[i].includes(mucousMembraneValuesElement.options[j].value)){
			mucousMembraneValuesElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getMucousMenbraneOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getMucousMenbraneOthersValue().equals("")){
		  %>

		  document.getElementById('mucousMenbraneOthersValueDiv').style.display = 'block';
		  document.getElementById('mucousMenbraneOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getMucousMenbraneOthersValue()%>'; 
		  
		<%}%>

</script> 

<label>Hair</label>

<select style="display:block;width:189px;height:60px;" id="hair" name="hair"  multiple="multiple"
onchange="showValues1(this,'hairValue');
displayGeneralProformaValueDivGp1(this.value,'hairValueDivGp','hair','hairValue','hairOthersValueDiv');" >
<option value="Normal">Normal</option>
<option value="Diffuse alopecia">Diffuse alopecia</option>
<option value="Alopecia Areata">Alopecia Areata</option>
<option value="Androgenic Alopecia">Androgenic Alopecia</option>
<option value="Alopecia Totalis Alopecia Universalis">Alopecia Totalis Alopecia Universalis</option>
<option value="Hirsutism">Hirsutism</option>
<option value="Scarring Alopecia">Scarring Alopecia</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="hairValueDivGp">
<textarea class="historyAutoComplete" name="hairValue" id="hairValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="hairOthersValueDiv">
<textarea  class="historyAutoComplete" type="text" id="hairOthersValue" name="hairOthersValue"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>
<script>
var arrHair= new Array();
 var hairValue= '';
 var nLine = '';
<%if(hairValues !=null){
	int countHairValue = 0;
for(String hairValue : hairValues){ %>
   arrHair.push('<%=hairValue%>');
	<% countHairValue++ ;
	if(countHairValue != hairValues.length) { %>
		nLineHair = "\n";
	<%} else {%>
	   nLineHair = '';
	<%}%>
 	hairValue = hairValue + ('<%=hairValue%>'.replace(/,/gi, '')) + nLineHair;	
<% } } %>
<%if(hairValues !=null){%>
   var hairValuesElement = 	document.getElementById('hair');
	<%if(dermogeneralProformaHeadersList.get(0).getHairValue()!=null && 
	!dermogeneralProformaHeadersList.get(0).getHairValue().equals("")){%>
	document.getElementById('hairValueDivGp').style.display = 'block';
	document.getElementById('hairValue').value=hairValue; 
<%}}%>

for(var i=0;i<arrHair.length;i++){
	for(var j=0;j<hairValuesElement.options.length;j++){
		if(arrHair[i].includes(hairValuesElement.options[j].value)){
			hairValuesElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getHairOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getHairOthersValue().equals("")){
		  %>

		  document.getElementById('hairOthersValueDiv').style.display = 'block';
		  document.getElementById('hairOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getHairOthersValue()%>'; 
		  
		<%}%>

</script>  

 
<label>Nails</label>

<select style="display:block;width:189px;height:60px;" name="nails" id="nails" multiple="multiple"
onchange="showValues1(this,'nailsValue');
displayGeneralProformaValueDivGp1(this.value,'nailsValueDivGp','nails','nailsValue','nailsOthersValueDiv');" >
<option value="Normal">Normal</option>
<option value="Onycholysis">Onycholysis</option>
<option value="Onychomadesis">Onychomadesis</option>
<option value="Paronychia">Paronychia</option>
<option value="Dystrophy">Dystrophy</option>
<option value="Pitting">Pitting</option>
<option value="Longitudinal melanonychia">Longitudinal melanonychia</option>
<option value="Subungual hyperkeratosis">Subungual hyperkeratosis</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="nailsValueDivGp">
<textarea class="historyAutoComplete" name="nailsValue" id="nailsValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="nailsOthersValueDiv">
<textarea class="historyAutoComplete" type="text" id ="nailsOthersValue" name="nailsOthersValue"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>

<script type="text/javascript">
 var arrNailValues= new Array();
 var nValue= '';
 var newLineNail = '';
<%if(nailValues !=null){
	int countNail = 0;
for(String nailValue : nailValues){ %>
arrNailValues.push('<%=nailValue%>');
	<% countNail++ ;
	if(countNail != nailValues.length) { %>
	newLineNail = "\n";
	<%} else {%>
	newLineNail = '';
	<%}%>
	nValue = nValue + ('<%=nailValue%>'.replace(/,/gi, '')) + newLineNail;	
<% } } %>
<%if(nailValues !=null){%>
var nailValuesElement = 	document.getElementById('nails');
		<%if(dermogeneralProformaHeadersList.get(0).getNailsValue()!=null && 
		!dermogeneralProformaHeadersList.get(0).getNailsValue().equals("")){%>
		document.getElementById('nailsValueDivGp').style.display = 'block';
		document.getElementById('nailsValue').value=nValue; 
<%}}%>

for(var i=0;i<arrNailValues.length;i++){
	for(var j=0;j<nailValuesElement.options.length;j++){
		if(arrNailValues[i].includes(nailValuesElement.options[j].value)){
			nailValuesElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getNailsOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getNailsOthersValue().equals("")){
		  %>

		  document.getElementById('nailsOthersValueDiv').style.display = 'block';
		  document.getElementById('nailsOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getNailsOthersValue()%>'; 
		  
		<%}%>

</script>    

<label>Systemic Illness</label>

<select style="display:block;width:189px;height:60px;" name="systemIllness" id="systemIllness" multiple="multiple"
onchange="showValues1(this,'systemIllnessValue');
displayGeneralProformaValueDivGp1(this.value,'systemIllnessValueDivGp','systemIllness','systemIllnessValue','systemIllnessOthersValueDiv');"  >
<option value="CVS">CVS</option>
<option value="CNS">CNS</option>
<option value="GIT">GIT</option>
<option value="Musculoskeletal System">Musculoskeletal System </option>
<option value="Pulmonary">Pulmonary</option>
<option value="Absent">Absent</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="systemIllnessValueDivGp">
<textarea class="historyAutoComplete" name="systemIllnessValue" id="systemIllnessValue" maxlength="950"  rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="systemIllnessOthersValueDiv">
<textarea  class="historyAutoComplete" type="text" id="systemIllnessOthersValue" name="systemIllnessOthersValue"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>

<script type="text/javascript">
 var arrSystemIllness= new Array();
 var IllnessValue= '';
 var nLineIllness = '';
<%if(systemIllnessValues !=null){
	int countIllness = 0;
for(String systemIllnessValue : systemIllnessValues){ %>
    arrSystemIllness.push('<%=systemIllnessValue%>');
	<% countIllness++ ;
	if(countIllness != systemIllnessValues.length) { %>
	nLineIllness = "\n";
	<%} else {%>
	nLineIllness = '';
	<%}%>
	IllnessValue = IllnessValue + ('<%=systemIllnessValue%>'.replace(/,/gi, '')) + nLineIllness;	
<% } } %>
<%if(systemIllnessValues !=null){%>
var systemIllnessElement = 	document.getElementById('systemIllness');
<%if(dermogeneralProformaHeadersList.get(0).getSystemIllnessValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getSystemIllnessValue().equals("")){%>
document.getElementById('systemIllnessValueDivGp').style.display = 'block';
document.getElementById('systemIllnessValue').value=IllnessValue; 
<%}}%>

for(var i=0;i<arrSystemIllness.length;i++){
	for(var j=0;j<systemIllnessElement.options.length;j++){
		if(arrSystemIllness[i].includes(systemIllnessElement.options[j].value)){
			systemIllnessElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getSystemIllnessOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getSystemIllnessOthersValue().equals("")){
		  %>

		  document.getElementById('systemIllnessOthersValueDiv').style.display = 'block';
		  document.getElementById('systemIllnessOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getSystemIllnessOthersValue()%>'; 
		  
		<%}%>

</script>  

<label>Signs</label>

<select style="display:block;width:189px;height:60px;" name="signs" id="signs" multiple="multiple"
onchange="showValues1(this,'signsValue');
displayGeneralProformaValueDivGp1(this.value,'signsValueDivGp','signs','signsValue','signsOthersValueDiv');" >
<option value="Auspitz">Auspitz</option>
<option value="Bullae Spread">Bullae Spread</option>
<option value="Nikolsky">Nikolsky</option>
<option value="Carpet Tack">Carpet Tack</option>
<option value="Others signs">Others signs</option>
<option value="Others">Others</option>
</select>
<div style="display: none" id="signsValueDivGp">
<textarea class="historyAutoComplete" name="signsValue" id="signsValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height: 55px;"></textarea>
</div>
<div style="display: none" id="signsOthersValueDiv">
<textarea class="historyAutoComplete" type="text" id="signsOthersValue" name="signsOthersValue"  style="display:block;width:190px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   ></textarea>
</div>
<div class="clear"></div>

<script type="text/javascript">
 var arrsignValues= new Array();
 var SValue= '';
 var nLineS = '';
<%if(signValues !=null){
	int countSign = 0;
for(String signValue : signValues){ %>
arrsignValues.push('<%=signValue%>');
	<% countSign++ ;
	if(countSign != signValues.length) { %>
	nLineS = "\n";
	<%} else {%>
	nLineS = '';
	<%}%>
	SValue = SValue + ('<%=signValue%>'.replace(/,/gi, '')) + nLineS;	
<% } } %>
<%if(signValues !=null){%>
var signValuesElement = document.getElementById('signs');
<%if(dermogeneralProformaHeadersList.get(0).getSignsValue()!=null && 
!dermogeneralProformaHeadersList.get(0).getSignsValue().equals("")){%>
document.getElementById('signsValueDivGp').style.display = 'block';
document.getElementById('signsValue').value=SValue; 
<%}}%>

for(var i=0;i<arrsignValues.length;i++){
	for(var j=0;j<signValuesElement.options.length;j++){
		if(arrsignValues[i].includes(signValuesElement.options[j].value)){
			signValuesElement.options[j].selected = true;
		}
	}
} 

<%if(dermogeneralProformaHeadersList.size() > 0 && dermogeneralProformaHeadersList.get(0).getSignsOthersValue()!=null && 
		  !dermogeneralProformaHeadersList.get(0).getSignsOthersValue().equals("")){
		  %>

		  document.getElementById('signsOthersValueDiv').style.display = 'block';
		  document.getElementById('signsOthersValue').value ='<%= dermogeneralProformaHeadersList.get(0).getSignsOthersValue()%>'; 
		  
		<%}%>

</script>  


  
</div>
</form>

<style>
.tableForTab table td select{margin-left:0px!important;} 
.tableForTab table td input.radioCheck{margin-left:0px;}
input.widthFixed26 {width:26px;}
</style>


