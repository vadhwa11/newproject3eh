
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaDetail"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaHeader"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage"%>
<script type="text/javascript" src="/hms/jsp/js/phototherapyProformaJs.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>
<script type="text/javascript" src="/hms/jsp/js/prescription.js"></script>

<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
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

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();
	List<OpdPhototherapyProformaDetailDosage> phototherapyProformaDosage = new ArrayList<OpdPhototherapyProformaDetailDosage>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("phototherapyProformaDosage") != null){
		phototherapyProformaDosage =(List<OpdPhototherapyProformaDetailDosage>)map.get("phototherapyProformaDosage");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList =(List<MasBloodGroup>)map.get("bloodGroupList");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	int hinId = 0;
	if(map.get("hinId") != null){
		hinId =(Integer)map.get("hinId");
	}
	int visitId = 0;
	if(map.get("visitId") != null){
		visitId =(Integer)map.get("visitId");
	}
	String tempLateName = "";
	if(map.get("tempLateName") != null){
		tempLateName =(String)map.get("tempLateName");
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<form method="post" action="" name="phototherapyProforma" >

<div class="titleBg">
<h2>Proforma for Dermatoses Treated with Phototherapy</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<input id="phototherapyFlag" name="phototherapyFlag" tabindex="1" value="Phototherapy Proforma" type="hidden"  />
<input type="hidden" name="templateName" value="Phototherapy Proforma"/>
<input type="hidden" name="currentDateJs" id="currentDateJs" value="<%=currentDate %>"/>
<label>Presenting Complaints</label>
<textarea rows="" cols="" name="ptPresentingComplaints" id="ptPresentingComplaints" class="historyAutoComplete" class="large" style="width:299px;"  maxlength="256" tabindex="1" ></textarea>

<label style="width:120px;">Duration of Illness</label>
<input  type="text" id="ptDurationOfIllness" name="ptDurationOfIllness" value="" onPaste="return false" onkeypress="javascript:return isNumber(event)" tabindex="1" maxlength="10" class="medium" />
<select id="ptDurationParameter" name="ptDurationParameter" tabindex="1" class="medium2" >
<option value="">Select</option>	
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
<option value="Months">Months</option>
<option value="Years">Years</option>
</select>

<div class="clear"></div>
<label>History of Present Illness</label>
<textarea rows="" cols="" name ="ptPresentIllnessHistory" id="ptPresentIllnessHistory" class="historyAutoComplete" class="large" style="width:299px;"  maxlength="256" tabindex="1"></textarea>

<label style="width:120px;">Past History</label>
<select id="ptPastHistory" name="ptPastHistory" tabindex="1" style="width:160px;" tabindex="1">
<option value="">Select</option>	
<option value="Diabetes">Diabetes</option>
<option value="Hypertension">Hypertension</option>
<option value="Others">Others</option>
</select>
<textarea rows="" cols="" name ="ptPastHistoryValue" id="ptPastHistoryValue" class="historyAutoComplete" class="large" style="width:270px;"  maxlength="256" tabindex="1"></textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<label class="heightAuto">Family History of Similar Illness</label>
<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin:0px;" tabindex="1">
<input class="radioCheckCol2" name="ptFamilyHistoryOfSimilarIllness" id="ptFamilyHistoryOfSimilarIllness" tabindex="1" value="Present" type="radio" onclick="dataPhototherapyDiv();">Present</label>
<label class="autoSpace" style="padding: 0px 6px 0px 1px;">
<input class="radioCheckCol2" name="ptFamilyHistoryOfSimilarIllness" id="ptFamilyHistoryOfSimilarIllness" tabindex="1" checked="checked" value="Absent" type="radio"  onclick="dataPhototherapyDiv();">Absent</label>
<div class="" style="display:none" id="dataDivFamilyIllness">
<textarea rows="" cols="" name ="ptFamilyHistoryOfSimilarIllnessValue" id="ptFamilyHistoryOfSimilarIllnessValue" class="large" style="width:236px;"  maxlength="256"></textarea>
</div>
<!-- <div class="clear"></div> -->

<label>Drug History</label>
<select id="ptDrugHistory" name="ptDrugHistory" tabindex="1" style="width:126px;">
<option value="">Select</option>	
<option value="Steroids">Steroids</option>
<option value="DCP">DCP</option>
<option value="Cyclophosphamide">Cyclophosphamide</option>
<option value="Azathioprine">Azathioprine</option>
<option value="Cyclosporine">Cyclosporine</option>
<option value="Methotrexate">Methotrexate</option>
<option value="Others">Others</option>
</select>
<input  type="text" id="ptDrugHistoryValue" name="ptDrugHistoryValue" value="" tabindex="1" maxlength="256" />
<div class="clear"></div>

<h4>General Examination </h4>
<div class="clear"></div>

<label>Build and Nourishment</label>
<input  type="text" id="ptBuildAndNourishment" name="ptBuildAndNourishment" value="" tabindex="1" maxlength="256" />
<div class="clear"></div>

<label class="medium">Anemia
<input class="checkboxMargin" id="ptGenExamAnemia" name="ptGenExamAnemia" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div style="display:none" id="dataDivAnemia">
<input  type="text" id="ptGenExamAnemiaValue" name="ptGenExamAnemiaValue" value="" tabindex="1" maxlength="256" />
</div>
 
<label class="medium">Cyanosis
<input class="checkboxMargin" id="ptGenExamCyanosis" name="ptGenExamCyanosis" type="checkbox"tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div style="display:none" id="dataDivCyanosis">
<input  type="text" id="ptGenExamCyanosisValue" name="ptGenExamCyanosisValue" value="" tabindex="1" maxlength="256" />
</div>
<label>Jaundice
<input class="checkboxMargin" id="ptGenExamJaundice" name="ptGenExamJaundice" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivJaundice">
<input  type="text" id="ptGenExamJaundiceValue" name="ptGenExamJaundiceValue" value="" tabindex="1" maxlength="256" />
</div>
<div class="clear"></div>
<label class="medium">Clubbing
<input class="checkboxMargin" id="ptGenExamClubbing" name="ptGenExamClubbing" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div style="display:none" id="dataDivClubbing">
<input  type="text" id="ptGenExamClubbingValue" name="ptGenExamClubbingValue" value="" tabindex="1" maxlength="256" />
</div>
<label class="medium">Edema
<input class="checkboxMargin" id="ptGenExamEdema" name="ptGenExamEdema" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivEdema">
<input  type="text" id="ptGenExamEdemaValue" name="ptGenExamEdemaValue" value="" tabindex="1" maxlength="256" />
</div>
 
<label>Lymphadenopathy
<input class="checkboxMargin" id="ptGenExamLymphadenopathy" name="ptGenExamLymphadenopathy" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivLymphadenopathy">
<input  type="text" id="ptGenExamLymphadenopathyValue" name="ptGenExamLymphadenopathyValue" value="" tabindex="1" maxlength="256" />
</div>
<div class="clear"></div>


<h4>VITALS </h4>
<div class="clear"></div>
<div class="divisionSolid"></div>
<div class="clear"></div>
<label class="auto">Pulse</label> 
<input class="allownumericwithoutdecimal widthFixed26" onkeypress="javascript:return isNumberDecimal(event)" onPaste="return false" tabindex="1" name="ptPulse" 
	type="text" id="ptPulse" validate="pulse,num,no" maxlength="3" value="" onblur="setVitalValue(this.value,'pulse')" /> 
<label class="smallAuto">min</label> 
<label class="auto">Temperature</label>
<input class="allownumericwithdecimal textSmall" name="ptTemperature" id="ptTemperature" onkeypress="javascript:return isNumber(event)" onPaste="return false"
	type="text" maxlength="5" validate="temperature,float,no" value="" tabindex="1" onblur="setVitalValue(this.value,'temperature')" />
<label class="smallAuto">&deg;F</label> 
<label class="auto" id="ptBpLabel">BP</label> 
<input name="ptSystolic" id="ptSystolic" tabindex="1" placeholder="Systolic" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false"
	validate="systolic,int,no" type="text" maxlength="3" class="allownumericwithoutdecimal widthFixed26" onblur="commonDiastolicSystolic2();setVitalValue(this.value,'systolic');"/>
<label id="ptBpLabel" class="smallAuto"><span style="color: black">/</span></label>
<input name="ptDiastolic" id="ptDiastolic" tabindex="1" placeholder="Diastolic" onkeypress="javascript:return isNumber(event)" onPaste="return false"
	value=""validate="diastolic,int,no" type="text" maxlength="3" class="allownumericwithoutdecimal widthFixed26"  onblur="commonDiastolicSystolic2();setVitalValue(this.value,'diastolic');"/>
<label class="smallAuto">mm&nbsp;Hg</label>

<label class="auto">Height</label>
<input	name="ptHeight" id="ptHeight" type="text"  maxlength="3" class="allownumericwithoutdecimal widthFixed26"  onkeypress="javascript:return isNumberDecimal(event)" onPaste="return false"
	value="" validate="height,int,no" onblur="calculatePhototherapyBMI();setVitalValue(this.value,'height')" tabindex="1"/>
<label	class="smallAuto">&nbsp;cm</label>
						
<label class="auto">Weight</label>
<input name="ptWeight"  id="ptWeight" type="text" maxlength="6"  class="allownumericwithdecimal textSmall" onkeypress="javascript:return isNumber(event)" onPaste="return false"
	value="" validate="weight,double,no" onblur="calculatePhototherapyBMI();setVitalValue(this.value,'weight')" tabindex="1"/>
<label	class="smallAuto">Kg</label>


<label class="auto" id="bpLabel">BMI</label>
<input	name="ptBmi" id="ptBmi"  type="text" value=""  readonly="readonly" class="textSmall" onblur="setVitalValue(this.value,'bmi')" />
<label class="smallAuto" style="min-width:17px;" id="ptBmiCat">&nbsp;</label>
<label class="auto">Resp.Rate</label>
<input type="text"  id="ptRespiratoryRate" name="ptRespiratoryRate" value="" onkeypress="javascript:return isNumberDecimal(event)" onPaste="return false" tabindex="1" maxlength="6" class="textSmall" onblur="setVitalValue(this.value,'respiratoryRate')" />
<label class="smallAuto">/ min</label>
<label class="auto">SPO2</label>
<input type="text"  id="ptSpo2" name="ptSpo2" value="" tabindex="1" onkeypress="javascript:return isNumberDecimal(event)" onPaste="return false" maxlength="6" class="textSmall" onblur="setVitalValue(this.value,'spo2')" />
<label class="smallAuto">%</label>

<label class="auto">Blood Group</label>
<select name="ptBloodGroup" id="ptBloodGroup" tabindex=1 style="width:110px;">
	<option value="">Select</option>
	<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
		<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%} %>
</select>

<div class="clear"></div>
<div class="divisionSolid"></div>
<div class="clear"></div>
<div class="clear"></div>

<h4>Dermatological Examination</h4>
<div class="clear"></div>
<h4>Primary Lesion</h4>
<input type="button" class="buttonAdd" alt="Add" tabindex="1" value="&nbsp;" onclick="addRowForPrimaryLesionForPhototherapy('Phototherapy Performa');" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" tabindex="1" onclick="removeRowForPrimaryLesionForPhototherapy();" />
  <div class="clear"></div>
  
  <div style="width:1158px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" tabindex="1" id="ptPrimaryLessionGrid"> 
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
    <tr>
      <td><input type="checkbox" class="radioCheck" name="ptPrimaryLesionRadio1" id="ptPrimaryLesionRadio1" tabindex="1" /></td>  
	  <td>
		<select name="ptPrimaryLesion1" id="ptPrimaryLesion1" style="width:65px;" tabindex="1" onchange="showPrimaryLesionOthers(this.value,'1');">
			<option value="">Select</option>
			<option value="Macule">Macule</option>
			<option value="Papule">Papule</option>
			<option value="Plaque">Plaque</option>
			<option value="Nodule">Nodule</option>
			<option value="Others">Others</option>
		</select>
		<div class="clear"></div> 
		<div class="clear"></div> 
		<div class="clear"></div> 
		<div style="display: none" id="ptPrimaryLesionOthersDiv1">
			<input type="text" maxlength="16" tabindex="1" value="" name="ptPrimaryLesionOthers1" id="ptPrimaryLesionOthers1" class="medium" />
		</div>
	  </td>
      <td>
		<select name="ptPrimaryLesionNo1" id="ptPrimaryLesionNo1" tabindex="1"  style="width:83px;">
			<option value="">Select</option>
			<option value="Single">Single</option>
			<option value="Multiple">Multiple</option>
			<option value="Generalized">Generalized</option>
		</select>
	  </td>
      <td>
		<select name="ptPrimaryLesionSite1" id="ptPrimaryLesionSite1" tabindex="1" style="width:84px;">
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
		<select name="typeOfPtPrimaryLesion1" id="typeOfPtPrimaryLesion1" tabindex="1" style="width:75px;">
			<option value="">Select</option>
			<option value="Discrete">Discrete</option>
			<option value="Confluent">Confluent</option>
		</select>
	  </td>
      <td>
		<select name="ptPrimaryPigmentation1" id="ptPrimaryPigmentation1" tabindex="1" style="width:105px;">
			<option value="">Select</option>
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		</select>
		
		<select name="ptPrimaryPigmentationValue1" id="ptPrimaryPigmentationValue1" tabindex="1" style="width:105px;">
			<option value="">Select</option>
			<option value="Erythematous">Erythematous</option>
			<option value="Violaceous">Violaceous</option>
			<option value="Hypo pigmented">Hypo pigmented</option>
			<option value="Hyper pigmented">Hyper pigmented</option>
			<option value="De pigmented">De pigmented</option>
		</select>
	  </td>
	  <td>
		<select name="ptPrimaryCharacter1" id="ptPrimaryCharacter1" tabindex="1" style="width:82px;">
			<option value="">Select</option>
			<option value="Flat">Flat</option>
			<option value="Raised">Raised</option>
			<option value="Fluid Filled">Fluid Filled</option>
			<option value="Pustule">Pustule</option>
		</select>
	  </td> 
	  <td>
		<select name="ptPrimaryBorder1" id="ptPrimaryBorder1" tabindex="1">
			<option value="">Select</option>
			<option value="Well defined">Well defined</option>
			<option value="Partially Ill Defined">Partially Ill Defined</option>
			<option value="Ill Defined">Ill Defined</option>
		</select>
	  </td>
	  <td>
		<select name="ptPrimarySurface1" id="ptPrimarySurface1" tabindex="1" class="smaller">
			<option value="">Select</option>
			<option value="Smooth">Smooth</option>
			<option value="Rough">Rough</option>
			<option value="Dry">Dry</option>
		</select>
	  </td>
	  <td align="left">
		<div style="float:left; width:159px;">
		<input  type="text" maxlength="10" onkeypress="javascript:return isNumber(event)" onPaste="return false" validate="Smallest Lesion,int,no" tabindex="1" value="" name="ptPrimarySmallestSize1" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" onkeypress="javascript:return isNumber(event)" onPaste="return false" validate="Largest Lesion,int,no" tabindex="1" value="" name="ptPrimaryLargestSize1" class="medium" />
		<label class="smallAuto" style="width:72px;">Largest Lesion</label>
		</div>
	  </td>
	  <td>
		<select name="ptHairOnPrimaryLesion1" id="ptHairOnPrimaryLesion1" tabindex="1" class="medium2">
			<option value="">Select</option>
			<option value="Normal">Normal</option>
			<option value="De pigmented">De pigmented</option>
		</select>
	  </td>
	  <td><input  type="text"  validate="Additional Feature,metachar,no" tabindex="1" value="" name="ptPrimaryAdditionalFeature1" maxlength="100" class="medium" /></td>
	</tr>
  </table>
  </div>
  
  <input type="hidden" name="ptPrimaryLesionCount" id="ptPrimaryLesionCount" tabindex="1" value="1" />
<div class="clear"></div>

<!-- <label>Others</label>
<textarea rows="" cols="" name="ptPrimaryLessionOthers" id="ptPrimaryLessionOthers" class="textareaMediua"  maxlength="256" ></textarea>
 -->
 
<label>Others
<input class="checkboxMargin" id="ptPrimaryLessionOthers" name="ptPrimaryLessionOthers" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivOthers">
<textarea  type="text" id="ptPrimaryLessionOthersValue" name="ptPrimaryLessionOthersValue" value="" tabindex="1" maxlength="256" class="textareaMediua"></textarea>
</div>
 
 
<div class="clear"></div> 
  <h4>Secondary Lesion</h4>
  <div class="clear"></div>
  
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" tabindex="1" onclick="addRowForSecondaryLesionForPhototherapy('Phototherapy Performa');" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" tabindex="1" onclick="removeRowForSecondaryLesionForPhototherapy();" />
  <div class="clear"></div>     
  <div style="width:1158px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" style="float:left;" tabindex="1" class="tablestyle" id="ptSecondaryLessionGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Secondary Lesion</th>
      <th align="center">Number</th>
      <th align="center">Site</th>
      <th align="center">Type of Lesions</th>
      <th align="center">Pigmentation</th>
      <th align="center">Border</th>
      <th align="center">Surface</th>
      <th align="center">Size</th>
      <th align="center">Hair on Lesion</th>
      <th align="center">Additional Feature</th>
    </tr>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="ptSecondaryLesionRadio1" id="ptSecondaryLesionRadio1" tabindex="1" /></td> 
		<td>
		<select name="ptSecondaryLesion1" id="ptSecondaryLesion1" style="width:65px;" tabindex="1" onchange="showSecondaryLesionOthers(this.value,'1');">
		<option value="">Select</option>
		<option value="Scale">Scale</option>
		<option value="Crust">Crust</option>
	   <option value="Others">Others</option>
		</select>
		<div class="clear"></div> 
		<div class="clear"></div> 
		<div class="clear"></div> 
		<div style="display: none" id="ptSecondaryLessionOthersDiv1">
			<input type="text" maxlength="16" tabindex="1" value="" name="ptSecondaryLessionOthers1" id="ptSecondaryLessionOthers1" tabindex="1" class="medium" />
		</div>
		</td>
     <td>
		<select name="ptSecondaryLesionNo1" id="ptSecondaryLesionNo1" tabindex="1" style="width:83px;">
		<option value="">Select</option>
		<option value="Single">Single</option>
		<option value="Multiple">Multiple</option>
		<option value="Generalized">Generalized</option>
		</select>
		</td>
      <td>
		<select name="ptSecondaryLesionSite1" id="ptSecondaryLesionSite1" style="width:84px;" tabindex="1">
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
		<select name="typeOfptSecondaryLesion1" id="typeOfptSecondaryLesion1" style="width:75px;" tabindex="1">
		<option value="">Select</option>
		<option value="Discrete">Discrete</option>
		<option value="Confluent">Confluent</option>
		</select>
		</td>
     <td>
		<select name="ptSecondaryPigmentation1" id="ptSecondaryPigmentation1" style="width:105px;" tabindex="1">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>
		<div class="clear"></div>
		<select name="ptSecondaryPigmentationValue1" id="ptSecondaryPigmentationValue1" style="width:105px;" tabindex="1">
		<option value="">Select</option>
		<option value="Erythematous">Erythematous</option>
		<option value="Violaceous">Violaceous</option>
		<option value="Hypo pigmented">Hypo pigmented</option>
		<option value="Hyper pigmented">Hyper pigmented</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		<td>
		<select name="ptSecondaryBorder1" id="ptSecondaryBorder1" tabindex="1">
		<option value="">Select</option>
		<option value="Well defined">Well defined</option>
		<option value="Partially Ill Defined">Partially Ill Defined</option>
		<option value="Ill Defined">Ill Defined</option>
		</select>
		</td>
		<td>
		<select name="ptSecondarySurface1" id="ptSecondarySurface1" class="smaller" tabindex="1">
		<option value="">Select</option>
		<option value="Smooth">Smooth</option>
		<option value="Rough">Rough</option>
		<option value="Dry">Dry</option>
		</select>
		</td>
		<td align="left">
		<div style="float:left; width:159px;">
		<input  type="text" maxlength="10" onkeypress="javascript:return isNumber(event)" onPaste="return false" validate="Size,int,no" tabindex="1" value="" name="ptSecondarySmallestSize1" class="medium" />
		<label class="smallAuto">Smallest Lesion</label>
		<div class="clear"></div>
		<input  type="text" maxlength="10" onkeypress="javascript:return isNumber(event)" onPaste="return false" validate="size,int,no" tabindex="1" value="" name="ptSecondaryLargestSize1" class="medium" />
		<label class="smallAuto" style="width:72px;">Largest Lesion</label>
		</div>		
		</td>
		<td>
		<select name="ptHairOnSecondaryLesion1" id="ptHairOnSecondaryLesion1" class="medium2" tabindex="1">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="De pigmented">De pigmented</option>
		</select>
		</td>
		<td><input  type="text"  validate="Additional Feature,metachar,no" tabindex="1" value="" name="ptSecondaryAdditionalFeature1" maxlength="100" class="medium" /></td>
    </tr>
     </table>
     </div>
     <input type="hidden" name="ptSecondaryLesionCount" id="ptSecondaryLesionCount" value="1" tabindex="1" />

 <div class="clear"></div>
 
<label>Others
<input class="checkboxMargin" id="ptSecondaryLessionOthers" name="ptSecondaryLessionOthers" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivSecOthers">
<textarea  type="text" id="ptSecondaryLessionOthersValue" name="ptSecondaryLessionOthersValue" value="" tabindex="1" maxlength="256" class="textareaMediua" ></textarea>
</div>

<div class="clear"></div> 
<div class="paddingTop5"></div>
 
<!-- <label>Distribution</label>
<select  multiple="multiple" class="multiple" name="ptDistribution">
<option value="Scalp">Scalp</option>
<option value="Face">Face</option>
<option value="Upper Limbs">Upper Limbs</option>
<option value="Trunk">Trunk</option>
<option value="Lower limbs">Lower limbs</option>
</select>
<input type="text"  id="ptDistributionValue" name="ptDistributionValue" tabindex="1" value=""  maxlength="120"/> -->

<label>Distribution</label>
<!-- <select  multiple="multiple" class="multiple" name="ptDistribution" id="ptDistribution" tabindex="1" onchange="showListBoxValueInTextArea(this.value,'ptDistribution','ptDistributionValue')">
<option value="Scalp">Scalp</option>
<option value="Face">Face</option>
<option value="Upper Limbs">Upper Limbs</option>
<option value="Trunk">Trunk</option>
<option value="Lower limbs">Lower limbs</option>
</select>
<textarea name="ptDistributionValue" id="ptDistributionValue"  cols="0" rows="0" maxlength="120" style="display:block; width: 185px;margin: 0px 5px 5px 0px;" class="historyAutoComplete" tabindex="1" ></textarea>
 <div class="clear"></div> -->
 
 <select  style="display: block;width:189px;height:60px;" onchange="showValuesPt(getMultiSelectValuePt(this));displayPhototherapyProformaValueDivPt(this.value);" multiple >
<option value="Scalp - ">Scalp</option>
<option value="Face - ">Face</option>
<option value="Upper Limbs - ">Upper Limbs</option>
<option value="Trunk - ">Trunk</option>
<option value="Lower limbs - ">Lower limbs</option>
</select>
<div style="display: none" id="distributionValueDivPt">
<textarea name="distribution" id="distributionValue" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height:55px;"></textarea>
</div>
<!-- 
 <label>Hair</label>
<select  multiple="multiple" class="multiple" name="ptHair">
<option value="Normal">Normal</option>
<option value="Diffuse alopecia">Diffuse alopecia</option>
<option value="Alopecia Areata">Alopecia Areata</option>
<option value="Androgenic Alopecia">Androgenic Alopecia</option>
<option value="Alopecia Totalis Alopecia Universalis">Alopecia Totalis Alopecia Universalis</option>
<option value="Hirsutism">Hirsutism</option>
<option value="Scarring Alopecia">Scarring Alopecia</option>
<option value="Others">Others</option>
</select>
<input type="text"  id="ptHairValue" name="ptHairValue" tabindex="1" value=""  maxlength="120"/> -->
 <div class="clear"></div>
 
<label>Hair</label>
<!-- <select  multiple="multiple" class="multiple" name="ptHair" id="ptHair" tabindex="1" onchange="showListBoxValueInTextArea(this.value,'ptHair','ptHairValue')">
<option value="Normal">Normal</option>
<option value="Diffuse alopecia">Diffuse alopecia</option>
<option value="Alopecia Areata">Alopecia Areata</option>
<option value="Androgenic Alopecia">Androgenic Alopecia</option>
<option value="Alopecia Totalis Alopecia Universalis">Alopecia Totalis Alopecia Universalis</option>
<option value="Hirsutism">Hirsutism</option>
<option value="Scarring Alopecia">Scarring Alopecia</option>
<option value="Others">Others</option>
</select>
<textarea name="ptHairValue" id="ptHairValue" cols="0" rows="0" maxlength="120" style="display:block; width: 185px;margin: 0px 5px 5px 0px;" tabindex="1" class="historyAutoComplete" ></textarea>
 
<label class="medium">Others
<input class="checkboxMargin" id="hairOthers" name="hairOthers" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivHair">
<textarea  type="text" id="hairOthersValue" name="hairOthersValue" value="" tabindex="1" maxlength="120" class="textareaMediua" ></textarea>
</div> -->
 
<select style="display: block;width:189px;height:60px;" id="hairPt" name="hairPt"  onchange="showValuesPt2(getMultiSelectValuePt2(this));displayPhototherapyProformaValueDivPt2(this.value);" multiple >
<option value="Normal - ">Normal</option>
<option value="Diffuse alopecia - ">Diffuse alopecia</option>
<option value="Alopecia Areata - ">Alopecia Areata</option>
<option value="Androgenic Alopecia - ">Androgenic Alopecia</option>
<option value="Alopecia Totalis Alopecia Universalis - ">Alopecia Totalis Alopecia Universalis</option>
<option value="Hirsutism - ">Hirsutism</option>
<option value="Scarring Alopecia - ">Scarring Alopecia</option>
<option value="Others - ">Others</option>
</select>
<div style="display: none" id="hairValueDivPt">
<textarea name="hair" id="hair" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height:55px;"></textarea>
</div>
<div style="display: none" id="hairValue">
<textarea  type="text" name="hairValue"  style="display:block;width:181px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   tabindex="1"></textarea>
</div>
<div class="clear"></div>

<!--  <label>Nails</label>m
<select  multiple="multiple" class="multiple" name="ptNails">
<option value="Others">Normal</option>
<option value="Onycholysis">Onycholysis</option>
<option value="Onychomadesis">Onychomadesis</option>
<option value="Paronychia">Paronychia</option>
<option value="Dystrophy">Dystrophy</option>
<option value="Pitting">Pitting</option>
<option value="Longitudinal melanonychia">Longitudinal melanonychia</option>
<option value="Subungual hyperkeratosis">Subungual hyperkeratosis</option>
<option value="Others">Others</option>
</select>
<input type="text"  id="ptNailsValue" name="ptNailsValue" tabindex="1" value=""  maxlength="120"/>
 -->
<div class="clear"></div>
<label>Nails</label>
<!-- <select  multiple="multiple" class="multiple" name="ptNails" id="ptNails" tabindex="1" onchange="showListBoxValueInTextArea(this.value,'ptNails','ptNailsValue')">
<option value="Others">Normal</option>
<option value="Onycholysis">Onycholysis</option>
<option value="Onychomadesis">Onychomadesis</option>
<option value="Paronychia">Paronychia</option>
<option value="Dystrophy">Dystrophy</option>
<option value="Pitting">Pitting</option>
<option value="Longitudinal melanonychia">Longitudinal melanonychia</option>
<option value="Subungual hyperkeratosis">Subungual hyperkeratosis</option>
<option value="Others">Others</option>
</select>
<textarea name="ptNailsValue" id="ptNailsValue"  cols="0" rows="0" maxlength="120" tabindex="1" style="display:block; width: 185px;margin: 0px 5px 5px 0px;" class="historyAutoComplete" ></textarea>
 
 <label class="medium">Others
<input class="checkboxMargin" id="nailsOthers" name="nailsOthers" type="checkbox" tabindex="1" onclick="dataPhototherapyDiv();"> 
</label>
<div class="" style="display:none" id="dataDivNails">
<textarea  type="text" id="nailsOthersValue" name="nailsOthersValue" value="" tabindex="1" maxlength="120" class="textareaMediua" ></textarea>
</div> -->
<select style="display: block;width:189px;height:60px;" name="ptNails" id="ptNails" onchange="showValuesPt3(getMultiSelectValuePt3(this));displayPhototherapyProformaValueDivPt3(this.value);" multiple >
<option value="Normal - ">Normal</option>
<option value="Onycholysis - ">Onycholysis</option>
<option value="Onychomadesis - ">Onychomadesis</option>
<option value="Paronychia - ">Paronychia</option>
<option value="Dystrophy - ">Dystrophy</option>
<option value="Pitting - ">Pitting</option>
<option value="Longitudinal melanonychia - ">Longitudinal melanonychia</option>
<option value="Subungual hyperkeratosis - ">Subungual hyperkeratosis</option>
<option value="Others - ">Others</option>
</select>
<div style="display: none" id="nailsValueDivPt">
<textarea name="nails" id="nails" maxlength="950" rows="5" cols="5" style="display: block;width: 400px;height:55px;"></textarea>
</div>
<div style="display: none" id="nailsValue">
<textarea  type="text" name="nailsValue"  style="display:block;width:181px;height:55px;margin-left:0;" value="" maxlength="450" style="margin-left: 4px;"   tabindex="1"></textarea>
</div>
 
 
 <div class="clear"></div>
<label>Systems Illness</label>
<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
<input class="radioCheckCol2" name="ptSystemIllness" id="ptSystemIllness" tabindex="1" value="Yes" type="radio" onclick="illnessDivShow();">Present</label>
<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
<input class="radioCheckCol2" name="ptSystemIllness" id="ptSystemIllness" tabindex="1" checked="checked" value="No" type="radio" onclick="illnessDivShow();">Absent</label>

<div class="clear"></div>

<div style="display:none" id="illnessDiv">
<label class="lblWidth42">CVS </label>
<input  type="text" id="ptCVS" name="ptCVS" value="" tabindex="1" maxlength="256" style="width:160px;"/>
<label class="lblWidth42">RS </label>
<input  type="text" id="ptRS" name="ptRS" value="" tabindex="1" maxlength="256" style="width:160px;"/>
<label class="lblWidth42"> GIT</label>
<input  type="text" id="ptGIT" name="ptGIT" value="" tabindex="1" maxlength="256" style="width:160px;" />
<label class="lblWidth42">CNS </label>
<input  type="text" id="ptCNS" name="ptCNS" value="" tabindex="1" maxlength="256" style="width:160px;" />
<label class="lblWidth42"> Others</label>
<input  type="text" id="ptOthersIllness" name="ptOthersIllness" value="" tabindex="1" maxlength="256" style="width:160px;" />
</div>
<div class="clear"></div>

<h6>Investigations </h6>
<h4>Blood</h4>
<div class="clear"></div>
<label class="lblWidth42">Hb</label>
<input  type="text" id="ptHb" name="ptHb" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">g/dI</label>
<label class="lblWidth42">TC</label>
<label class="lblWidth42">P%</label>
<input  type="text" id="ptTcP" name="ptTcP" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="lblWidth42">L%</label>
<input  type="text" id="ptTcL" name="ptTcL" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="lblWidth42">E%</label>
<input  type="text" id="ptTcE" name="ptTcE" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="auto">Platelets</label>
<input  type="text" id="ptPlatelets" name="ptPlatelets" value="" onkeypress="javascript:return isNumber(event)"onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="lblWidth42">ESR</label>
<input  type="text" id="ptESR" name="ptESR" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mm in 1 hr</label>
<label class="auto">Peripheral smear</label>
<textarea rows="" cols="" name="ptPeripheralSmear" id="ptPeripheralSmear" class="textareaMediua" tabindex="1"  maxlength="32" ></textarea>
<div class="clear"></div>
<label class="lblWidth42">FBS</label>
<input  type="text" id="ptFBS" name="ptFBS" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mg/dI</label>
<label class="lblWidth42">PPBS</label>
<input  type="text" id="ptPPBS" name="ptPPBS" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mg/dI</label>
<div class="clear"></div>

<h4>Urine </h4>
<div class="clear"></div>
<label class="medium">Albumin</label>
<input  type="text" id="ptUrineAlbumin" name="ptUrineAlbumin" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="medium">Sugar</label>
<input  type="text" id="ptUrineSugar" name="ptUrineSugar" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="medium">Deposits</label>
<input  type="text" id="ptUrineDeposits" name="ptUrineDeposits" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<div class="clear"></div>

<h4>RFT and LFT</h4>
<div class="clear"></div>

<label class="lblWidth62">Urea</label>
<input  type="text" id="ptUrea" name="ptUrea" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mg/dI</label>

<label class="lblWidth62">Creatinine</label>
<input  type="text" id="ptCreatinine" name="ptCreatinine" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mg/dI</label>

<label class="lblWidth62">Protein</label>
<input  type="text" id="ptProtein" name="ptProtein" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">g/dI</label>

<label class="lblWidth62">Bilirubin</label>
<input  type="text" id="ptBilirubin" name="ptBilirubin" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mg/dI</label>

<label class="lblWidth62">SGOT</label>
<input type="text" id="ptSGOT" name="ptSGOT" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">U/L</label>

<label class="lblWidth62">Na+</label>
<input type="text" id="ptNa" name="ptNa" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mEq/L</label>
<div class="clear"></div>

<label class="lblWidth62">K+</label>
<input type="text" id="ptK" name="ptK" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">mEq/L</label>

<label class="lblWidth62">Albumin</label>
<input type="text" id="ptAlbumin" name="ptAlbumin" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">&nbsp;g/dI&nbsp;</label>

<label class="lblWidth62">Alk.P</label>
<input type="text" id="ptAlkP" name="ptAlkP" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">IU/L</label>

<label class="lblWidth62">SGPT </label>
<input type="text" id="ptSGPT" name="ptSGPT" value="" onkeypress="javascript:return isNumber(event)" onPaste="return false" tabindex="1" maxlength="32" style="width:42px;" />
<label class="smallAuto">&nbsp; U/L &nbsp;</label>

<label class="auto">Chest X-ray </label>
<input  type="text" id="ptChestXRay" name="ptChestXRay" value="" tabindex="1" maxlength="50" />
<div class="clear"></div>

<label class="medium">CT-Scan/MRI </label>
<input  type="text" id="ptCTScan" name="ptCTScan" value="" tabindex="1" maxlength="50" />
<label class="auto">Ultrasound Abdomen </label>
<input  type="text" id="ptUltrasoundAbdomen" name="ptUltrasoundAbdomen" value="" tabindex="1" maxlength="50" />
<label class="medium">Others  </label>
<input  type="text" id="ptRFTOthers" name="ptRFTOthers" value="" tabindex="1" maxlength="50" />
<div class="clear"></div>

<h4>Dermatoses </h4>
<div class="clear"></div>
  
<label class="auto">Psoriasis
<input class="checkboxMargin" id="ptPsoriasis" name="ptPsoriasis" type="checkbox"> 
</label>
<label class="auto">Vitiligo
<input class="checkboxMargin" id="ptVitiligo" name="ptVitiligo" type="checkbox"> 
</label>
<label class="auto">Alopecia
<input class="checkboxMargin" id="ptAlopecia" name="ptAlopecia" type="checkbox"> 
</label>
<label class="auto">Parapsoriasis
<input class="checkboxMargin" id="ptParapsoriasis" name="ptParapsoriasis" type="checkbox"> 
</label>
<label class="auto">Pityriasis lichenoides
<input class="checkboxMargin" id="ptPityriasislichenoides" name="ptPityriasislichenoides" type="checkbox"> 
</label>
<label class="auto">Mastocytosis
<input class="checkboxMargin" id="ptMastocytosis" name="ptMastocytosis" type="checkbox"> 
</label>
<label class="auto">CTCL
<input class="checkboxMargin" id="ptCTCL" name="ptCTCL" type="checkbox"> 
</label>
<label class="auto">Others
<input class="checkboxMargin" id="ptDermatosesOthers" name="ptDermatosesOthers" type="checkbox"> 
</label>
<input  type="text" id="ptDermatosesValue" name="ptDermatosesValue" value="" tabindex="1" maxlength="32" />
<div class="clear"></div>
<div class="clear"></div>

<h4>Concomitant Therapy </h4>
<div class="clear"></div>

<label class="auto">Systemic steroids
<input class="checkboxMargin" id="ptSystemicSteroids" name="ptSystemicSteroids" type="checkbox"> 
</label>
<label class="auto">Topical steroids
<input class="checkboxMargin" id="ptTopicalSteroids" name="ptTopicalSteroids" type="checkbox"> 
</label>
<label class="auto">Antihistamines
<input class="checkboxMargin" id="ptAntihistamines" name="ptAntihistamines" type="checkbox"> 
</label>
<label class="auto">Emolients
<input class="checkboxMargin" id="ptEmolients" name="ptEmolients" type="checkbox"> 
</label>
<label class="auto">Tacrolimus
<input class="checkboxMargin" id="ptTacrolimus" name="ptTacrolimus" maxlength="32" type="checkbox"> 
</label>
<label class="auto">Others
<input class="checkboxMargin" id="ptConcomitantTherapyOthers" maxlength="32" name="ptConcomitantTherapyOthers" type="checkbox"> 
</label>
<input type="text" id="ptConcomitantTherapyValue" name="ptConcomitantTherapyValue" value="" tabindex="1" maxlength="32" />
<div class="clear"></div>
<div class="clear"></div>

<div class="clear"></div>

<h4 style="float:left;width:300px;">
<input class="checkboxMargin" id="ptNbuvb" name="ptNbuvb" type="checkbox" style="margin-top:-4px!important;" tabindex="1" onclick="showNbuvbDiv();">
 NB-UVB</h4>
<div style="display:none;" id="nbuvbDiv">
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForNBUVB();" tabindex="1"  type="button">
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" tabindex="1" onclick="removeRowForNBUVB();" />
</div>

  <div class="clear"></div>     
  <div style="width:1158px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" float:left;" class="tablestyle" id="nbUvbGrid"> 
    <tr>
      <th align="center"></th>
      <th align="center">S.No</th>
      <th align="center">Date</th>
      <th align="center">Increment</th>
      <th align="center">Dosage (mj/cm<sup>2</sup>)</th>
      <th align="center">Score</th>     
      <th align="center">Remarks</th> 
   </tr>

<%int inc = 1; %>
<%if(phototherapyProformaDosage!=null && phototherapyProformaDosage.size()>0){ 
  for(OpdPhototherapyProformaDetailDosage photoDosage:phototherapyProformaDosage){
	if(null != photoDosage.getParameterName() && photoDosage.getParameterName().equals("NB-UVB")) {
%>
	<tr>
	<td><input  type="checkbox" class="radioCheck" name="NBUVBRadio" id="NBUVBRadio"/></td> 
      <td><input type="text" name="srNoo<%=inc%>" id="srNoo" value="<%=inc %>" readonly="readonly" class="sNumb" /></td> 
	  <td>
		<input id="nbuvbDate<%=inc %>" value="<%=photoDosage.getDosageDate()!=null?photoDosage.getDosageDate():"" %>" name="nbuvbDate<%=inc %>" class="small" validate="nbuvbDate<%=inc %>,string,no" readonly="readonly" type="text">
	  </td>
      <td>
      	<select name="nbuvbIncrement<%=inc %>" id="nbuvbIncrement<%=inc %>" class="medium2">
			<option value="<%=photoDosage.getIncrementPercentage()!=null?photoDosage.getIncrementPercentage():"" %>"><%=photoDosage.getIncrementPercentage()!=null?photoDosage.getIncrementPercentage() + "%":"" %></option>
		</select>
	  </td>
      <td align="left"><input id="nbuvbDosage<%=inc %>" value="<%=photoDosage.getDosage()!=null?photoDosage.getDosage():"" %>" name="nbuvbDosage<%=inc %>" class="small" readonly="readonly" type="text"></td>
      <td><input id="nbuvbScore<%=inc %>" value="<%=photoDosage.getScore()!=null?photoDosage.getScore():"" %>" name="nbuvbScore<%=inc %>" class="small" readonly="readonly"  maxlength="6" tabindex="1" onkeypress="javascript:return isNumber(event)" type="text"></td>
     <td><input id="nbuvbRemarks<%=inc %>" name="nbuvbRemarks<%=inc %>" value="<%=photoDosage.getRemarks()!=null?photoDosage.getRemarks():"" %>" tabindex="1" readonly="readonly" style="width:350px;" type="text"></td>		 
    </tr>
 <%inc++;}}}else{ %>
 	<tr>
 	<td><input  type="checkbox" class="radioCheck" name="NBUVBRadio" id="NBUVBRadio"/></td> 
 	<td><input type="text" name="srNoNbuvb<%=inc%>" id="srNoNbuvb<%=inc%>" value="<%=inc %>" readonly="readonly" class="sNumb" /></td> 
	  <td>
		<input id="nbuvbDate<%=inc %>" value="<%=currentDate %>" name="nbuvbDate<%=inc %>" class="small" validate="nbuvbDate<%=inc %>,string,no" readonly="readonly" type="text">
		<img id="calendar" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=currentDate %>',document.phototherapyProforma.nbuvbDate<%=inc %>,event);" width="16" height="16" border="0">
	  </td>
      <td>
      	<select name="nbuvbIncrement<%=inc %>" id="nbuvbIncrement<%=inc %>" class="medium2">
			<option value="0">0 %</option>
		</select>
	  </td>
      <td align="left"><input id="nbuvbDosage<%=inc %>" value="280" name="nbuvbDosage<%=inc %>" class="small" readonly="readonly" type="text"></td>
      <td><input id="nbuvbScore<%=inc %>" value="" name="nbuvbScore<%=inc %>" class="small" maxlength="6" tabindex="1" onkeypress="javascript:return isNumber(event)" type="text"></td>
     <td><input id="nbuvbRemarks<%=inc %>" name="nbuvbRemarks<%=inc %>" value="" tabindex="1" style="width:350px;"tabindex="1"  maxlength="128" type="text"></td>		 
	</tr>
<%inc++;} %>
 </table>
 </div>
 <input type="hidden" name="nbuvbCount" id="nbuvbCount" value="<%=inc-1 %>" />
 </div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="clear"></div>
<div class="clear"></div>

<h4 style="float:left;width:300px;">
<input class="checkboxMargin" id="ptPuva" name="ptPuva" type="checkbox" style="margin-top:-4px!important;" tabindex="1" onclick="showPuvaDiv();">
  PUVA</h4>
<div style="display:none;" id="puvaDiv">
<div class="floatRight" style="margin-right: 10px;">
<input class="buttonAdd" alt="Add" value="&nbsp;" onclick="addRowForPUVA();" type="button">
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForPUVA();" />
</div>

  <div class="clear"></div>     
  <div style="width:1158px; min-height:100px;" class="tableForTab">
  <table width="100%" border="0" cellpadding="5" cellspacing="0" float:left;" class="tablestyle" id="puvaGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">S.No</th>
      <th align="center">Date</th>
      <th align="center">Increment</th>
      <th align="center">Dosage (j/cm<sup>2</sup>)</th>
      <th align="center">Score</th>     
      <th align="center">Remarks</th> 
   </tr>
<%int inc1 = 1; %>
<%if(phototherapyProformaDosage!=null && phototherapyProformaDosage.size()>0){ 
  for(OpdPhototherapyProformaDetailDosage photoDosage:phototherapyProformaDosage){
	if(null != photoDosage.getParameterName() && photoDosage.getParameterName().equals("PUVA")) {
%>
	<tr>
	<td><input  type="checkbox" class="radioCheck" name="PUVARadio" id="PUVARadio"/></td> 
      <td><input type="text" name="srNoo<%=inc1%>" id="srNoo" value="<%=inc1 %>" readonly="readonly" class="sNumb" /></td> 
	  <td>
		<input id="puvaDate<%=inc1 %>" value="<%=photoDosage.getDosageDate()!=null?photoDosage.getDosageDate():"" %>" name="puvaDate<%=inc1 %>" class="small" validate="puvaDate<%=inc1 %>,string,no" readonly="readonly" type="text">
	  </td>
      <td>
      	<select name="puvaIncrement<%=inc1 %>" id="puvaIncrement<%=inc1 %>" class="medium2">
			<option value="<%=photoDosage.getIncrementPercentage()!=null?photoDosage.getIncrementPercentage():"" %>"><%=photoDosage.getIncrementPercentage()!=null?"+" + photoDosage.getIncrementPercentage():"" %></option>
		</select>
	  </td>
      <td align="left"><input id="puvaDosage<%=inc1 %>" value="<%=photoDosage.getDosage()!=null?photoDosage.getDosage():"" %>" name="puvaDosage<%=inc1 %>" class="small" readonly="readonly" type="text"></td>
      <td><input id="puvaScore<%=inc1 %>" value="<%=photoDosage.getScore()!=null?photoDosage.getScore():"" %>" name="puvaScore<%=inc1 %>" class="small" tabindex="1"   readonly="readonly" onkeypress="javascript:return isNumber(event)" type="text"></td>
     <td><input id="puvaRemarks<%=inc1 %>" name="puvaRemarks<%=inc1 %>" value="<%=photoDosage.getRemarks()!=null?photoDosage.getRemarks():"" %>" tabindex="1" readonly="readonly" style="width:350px;" type="text"></td>		 
    </tr>
 <%inc1++;}}}else{ %>
 	<tr>
 	<td><input  type="checkbox" class="radioCheck" name="PUVARadio" id="PUVARadio"/></td> 
 	<td><input type="text" name="srNoPuva<%=inc1%>" id="srNoPuva<%=inc1%>" value="<%=inc1 %>" readonly="readonly" class="sNumb" /></td> 
	  <td>
		<input id="puvaDate<%=inc1 %>" value="<%=currentDate %>" name="puvaDate<%=inc1 %>" class="small" validate="puvaDate<%=inc1 %>,string,no" readonly="readonly" type="text">
		<img id="calendar" src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="setdate('<%=currentDate %>',document.phototherapyProforma.puvaDate<%=inc1 %>,event);" width="16" height="16" border="0">
	  </td>
      <td>
      	<select name="puvaIncrement<%=inc1 %>" id="puvaIncrement<%=inc1 %>" class="medium2">
			<option value="0">0</option>
		</select>
	  </td>
      <td align="left"><input id="puvaDosage<%=inc1 %>" value="0.5" name="puvaDosage<%=inc1 %>" class="small" readonly="readonly" type="text"></td>
      <td><input id="puvaScore<%=inc1 %>" value="" name="puvaScore<%=inc1 %>" class="small" type="text" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1"></td>
     <td><input id="puvaRemarks<%=inc1 %>" name="puvaRemarks<%=inc1 %>" value="" tabindex="1" maxlength="128" style="width:350px;" type="text"></td>		 
	</tr>
<%inc1++;} %>
</table>
</div>
<input type="hidden" name="puvaCount" id="puvaCount" tabindex="1"  value="<%=inc1-1 %>" />
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<label class="auto">Adverse events & follow up</label>
<textarea rows="" cols="" name ="ptAdverseEventsAndFollowUp" id="ptAdverseEventsAndFollowUp" class="large" style="width:380px;"  maxlength="256" tabindex="1" ></textarea>
<div class="clear"></div>

<%-- <div>
<h4 style="cursor:pointer;" onclick="popwindowResultEntryForDermotology('<%=hinId%>@@@<%=visitId%>@@@<%=tempLateName%>');">External Lab Report Entry</h4>
</div> --%>


<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

</div>
</form>

<style>
.tableForTab table td select{margin-left:0px!important;} 
.tableForTab table td input.radioCheck{margin-left:0px;}
input.widthFixed26 {width:26px;}
.lblWidth42{width:42px;}
.lblWidth62{width:62px;}
.Block table td input.sNumb{width:40px; text-align:center;}

</style>



