<%@page import="jkt.hms.masters.business.OpdEntExaminationSpeciality"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
List<OpdEntExaminationSpeciality>entExaminationList = new ArrayList<OpdEntExaminationSpeciality>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
}
if(map.get("entExaminationList") != null){
	entExaminationList=(List<OpdEntExaminationSpeciality>)map.get("entExaminationList");
}


int hinId = 0;
if(map.get("hinId") != null){
	hinId=(Integer)map.get("hinId");
}


%>

<%if(entExaminationList.size()>0) {%>
<input  name="entExaminationId" type="hidden" value="<%=entExaminationList.get(0).getId()%>" />
<%}%> 


<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
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
<!-- <form method="post" action="" name="dedd" > -->

<div class="titleBg">
<h2 class="h4Tab">ENT Examination</h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div> 
<div class="clear"></div>

<!--  <div>
 <img id="annotatableEnt" class="annotatable" src="/hms/jsp/images/1.png">
  <img id="annotatableEntDemo" src="/hms/jsp/images/2.png">
 <img id="annotatableEntTest" src="/hms/jsp/images/3.png"> </div> -->
 <!--<img src="/hms/jsp/images/left_tympanic_membrance.jpg" id="image1" class="annotatable" border="0">
  <div class="clear"></div>
<img src="/hms/jsp/images/right_tympanic_membrance.jpg" id="image2" class="annotatable" border="0">
 <div class="clear"></div>

 <img src="/hms/jsp/images/left_tympanic_membrance_normal.jpg"  id="image3" class="annotatable" border="0">
 <div class="clear"></div>
<img src="/hms/jsp/images/right_tympanic_membrance_normal.jpg"  id="image4" class="annotatable" border="0"> -->
 <div class="clear"></div>

<!--  </div> -->
 <div class="clear"></div>

<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="showCollapasbleTab('Ear')" name="" value="+" type="button">
</div>
<div class="plusText"><h6 class="h4Tab">Ear</h6></div>
<div style="float:right; width:100px;">
<%if(hinId !=0) {%>
 <a href="javascript:openPopupForViewImages(csrfTokenName+'='+csrfTokenValue,'<%=hinId%>');">VIEW IMAGES</a>
 <%} %>
 </div>
<div class="clear"></div>
<!-- <div class="paddingTop5"></div> -->
<div class="clear"></div>
<input id="entFlag" name="entFlag" tabindex="1" value="EntExamination" type="hidden"  />
<input type="hidden" name="templateName" value="Ent Examination"/>
<!-- <div class="collapasHide" id="earTitle"> -->
<div class="indArrow"></div>
<!-- <div class="Block"> -->

<!-- ----entExaImageLeftDiv start from here--- -->
<div class="entExaImageLeftDiv"">
 <div class="clear"></div>
 <div class="Block">
<table width="500" border="0" cellpadding="5" cellspacing="0" style="width:560px; float:left;" class="tablestyle"> 
    <tr>
      <th align="center">Local Examination</th>
      <th align="center">Right</th>
      <th align="center">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Pinna</label></td>
      <td align="left"><input  type="text" maxlength="100" validate="Right,metachar,no" tabindex="1" value="" name="rightPinna" ></td>
      <td align="left"><input  type="text" maxlength="100" validate="Left Pinna,metachar,no" tabindex="1" value="" name="leftPinna" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Pre Auricular Area</label></td>
      <td align="left"><input  type="text" maxlength="100" validate="Reght Pre Auricular Area,metachar,no" tabindex="1" value="" name="rightPreAuricularArea" ></td>
      <td align="left"><input  type="text" maxlength="100" validate="Left Pre Auricular Area,metachar,no" tabindex="1" value="" name="leftPreAuricularArea" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Post Auricular Area</label></td>
      <td align="left"><input  type="text" maxlength="100" validate="Right Post Auricular Area,metachar,no" tabindex="1" value="" name="rightPostAuricularArea" ></td>
      <td align="left"><input  type="text" maxlength="100" validate="Left Post Auricular Area,metachar,no" tabindex="1" value="" name="leftPostAuricularArea" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Tragal Tenderness</label></td>
      <td align="left"><select validate="Right Mastoid Tenderness,string,no"  name="rightTragalTenderness" id="" tabindex="1" style="width:140px; margin-left:0px !important;"> 
		<option value="">Select</option>		
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		
	  </select></td>
      
      <td align="left"><select validate="Left Mastoid Tenderness,string,no" name="leftTragalTenderness" id="" tabindex="1" style="width:140px; margin-left:0px !important;"> 
		<option value="">Select</option>		
		<option value="Yes">Yes</option>
		<option value="No">No</option>
				</select></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">External Auditory Canal</label></td>
      <td align="left"><input  type="text" maxlength="100" validate="Right External Auditory Canal,metachar,no" tabindex="1" value="" name="rightExternalAuditoryCanal" ></td>
      <td align="left"><input  type="text" maxlength="100" validate="Left External Auditory Canal,metachar,no" tabindex="1" value="" name="leftExternalAuditoryCanal" ></td>
    </tr>
    
     <tr>
      <td align="left"><label class="Tablelabel">Tympanic Membrane</label></td>
      <!-- <td align="left"><input  type="text" maxlength="30" validate="Right Tympanic Membrane,metachar,no" tabindex="1" value="" name="rightTympanicMembrane" ></td>
      <td align="left"><input  type="text" maxlength="30" validate="Left Tympanic Membrane,metachar,no" tabindex="1" value="" name="leftTympanicMembrane" ></td>  -->
 <td>    <select id="rightTympanicMembrane" name="rightTympanicMembrane" tabindex="1" style="width:140px; margin-left:0px !important;" onchange="entShowDiv(this.value,'tympanicRightPerforation')">
<option value="">Select</option>    
<option value="Normal">Normal</option>
<option value="Retracted">Retracted</option>
<option value="Congested">Congested</option>
<option value="Perforation">Perforation</option>
</select>


<div class="clear"></div>
<select id="tympanicRightPerforation" name="tympanicRightPerforation" tabindex="1" style="margin-top:1px !important; display:none" onchange="entShowparseFlaccidaValue(this.value,'rightParseTensa','parseFlaccidaValueRight')">
<option value="">Select</option>    
<option value="Pars Tensa">Pars Tensa </option>
<option value="Pars Flaccida">Pars Flaccida</option>
</select>

<div class="clear"></div>
<select id="rightParseTensa" name="rightParseTensa" tabindex="1" style="margin-top:1px !important; display:none" onchange="entShowparseTensaValue(this.value)">
<option value="">Select</option>    
<option value="Central">Central</option>
<option value="Marginal">Marginal</option>
<option value="Middle Ear Mucosa">Middle Ear Mucosa</option>
<option value="Discharge">Discharge</option>
</select>

<div class="clear"></div> 
<select id="rightCentral" name="rightCentral" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Small">Small</option>
<option value="Medium">Medium</option>
<option value="Large">Large</option>
</select>

<div class="clear"></div> 
<input  type="text" id="marginalValueRight" name="marginalValueRight" value="" tabindex="1" maxlength="50" style="margin-top:1px; margin-left:5px;width:116px; display:none" />

<div class="clear"></div> 
<select id="rightMiddleEarMucosa" name="rightMiddleEarMucosa" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Normal">Normal</option>
<option value="Congested">Congested</option>
<option value="Polyp">Polyp</option>
<option value="Granulation">Granulation</option>
</select>

<div class="clear"></div> 
<select id="rightDischarge" name="rightDischarge" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Serous">Serous</option>
<option value="Mucinous">Mucinous</option>
<option value="Mucopurulent">Mucopurulent</option>
<option value="Purulent">Purulent</option>
<option value="Blood-stained">Blood-stained</option>
<option value="Foul Smelling">Foul Smelling</option>
</select>

<div class="clear"></div> 
<input  type="text" id="parseFlaccidaValueRight" name="parseFlaccidaValueRight" value="" tabindex="1" maxlength="50" style="margin-top:1px; margin-left:5px;width:116px; display:none" />
 </td>
<!-- ----left side below--- --> 
 
<td>    <select id="leftTympanicMembrane" name="leftTympanicMembrane" tabindex="1" style="width:140px; margin-left:0px !important;" onchange="entShowDivLeft(this.value,'tympanicLeftPerforation')">
<option value="">Select</option>    
<option value="Normal">Normal</option>
<option value="Retracted">Retracted</option>
<option value="Congested">Congested</option>
<option value="Perforation">Perforation</option>
</select>


<div class="clear"></div>
<select id="tympanicLeftPerforation" name="tympanicLeftPerforation" tabindex="1" style="margin-top:1px !important; display:none" onchange="entShowparseFlaccidaValueLeft(this.value,'leftParseTensa','parseFlaccidaValueLeft')">
<option value="">Select</option>    
<option value="Pars Tensa">Pars Tensa </option>
<option value="Pars Flaccida">Pars Flaccida</option>
</select>

<div class="clear"></div>
<select id="leftParseTensa" name="leftParseTensa" tabindex="1" style="margin-top:1px !important; display:none" onchange="entShowparseTensaValueLeft(this.value)">
<option value="">Select</option>    
<option value="Central">Central</option>
<option value="Marginal">Marginal</option>
<option value="Middle Ear Mucosa">Middle Ear Mucosa</option>
<option value="Discharge">Discharge</option>
</select>

<div class="clear"></div> 
<select id="leftCentral" name="leftCentral" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Small">Small</option>
<option value="Medium">Medium</option>
<option value="Large">Large</option>
</select>

<div class="clear"></div> 
<input  type="text" id="marginalValueLeft" name="marginalValueLeft" value="" tabindex="1" maxlength="50" style="margin-top:1px; margin-left:5px;width:116px; display:none" />

<div class="clear"></div> 
<select id="leftMiddleEarMucosa" name="leftMiddleEarMucosa" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Normal">Normal</option>
<option value="Congested">Congested</option>
<option value="Polyp">Polyp</option>
<option value="Granulation">Granulation</option>
</select>

<div class="clear"></div> 
<select id="leftDischarge" name="leftDischarge" tabindex="1" style="margin-top:1px !important; display:none">
<option value="">Select</option>    
<option value="Serous">Serous</option>
<option value="Mucinous">Mucinous</option>
<option value="Mucopurulent">Mucopurulent</option>
<option value="Purulent">Purulent</option>
<option value="Blood-stained">Blood-stained</option>
<option value="Foul Smelling">Foul Smelling</option>
</select>

<div class="clear"></div> 
<input  type="text" id="parseFlaccidaValueLeft" name="parseFlaccidaValueLeft" value="" tabindex="1" maxlength="50" style="margin-top:1px; margin-left:5px;width:116px; display:none" />
 </td>
<!--   ----end ---   --> 
      
    </tr>
  </table>
  
  <div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="paddingTop5"></div>
  <div class="clear"></div>
  <h4>Tuning Fork Test</h4>
  <table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center">Rinne</th>
      <th align="center">Right</th>
      <th align="center">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">256 Hz</label></td>
       <td align="left"><select validate="Right 256 Hz,string,no" value="" name="right256HzRinnes"  tabindex="1"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
				</select></td>
      <td align="left"><select validate="Left 256 Hz,string,no" value="" name="left256HzRinnes"  tabindex="1"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
				</select></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">512 Hz</label></td>
      <td align="left"><select validate="Right 512 Hz,string,no" value="" name="right512HzRinnes"  tabindex="1" onchange="entDisplayRinneValue(this.value, 'rinneOtherValueRight')"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
        <option value="Other">Other</option>
				</select>
		<div class="clear"></div>
		<div class="clear"></div>		
		<input type="text" name="rinneOtherValueRight" id="rinneOtherValueRight" validate="Rinne Right,metachar,no" maxlength="128" style="display: none" />		
				</td>
       <td align="left"><select validate="Left 512 Hz,string,no" value="" name="left512HzRinnes"  tabindex="1" onchange="entDisplayRinneValue(this.value, 'rinneOtherValueleft')"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
        <option value="Other">Other</option>
				</select>
      <div class="clear"></div>
      <div class="clear"></div>
      <input type="text" name="rinneOtherValueleft" id="rinneOtherValueleft" validate="Rinne Left,metachar,no" maxlength="128" style="display: none" /></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">1024 Hz</label></td>
        <td align="left"><select validate="Right 1024 Hz,string,no" value="" name="right1024HzRinnes" id="" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
				</select></td>
     
      <td align="left"><select validate="Left 1024 Hz,string,no" value="" name="left1024HzRinnes" id="" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Rinne Positive">Rinne Positive</option>
		<option value="Rinne Negative">Rinne Negative</option>
        <option value="Rinne Equivocal">Rinne Equivocal</option>
				</select></td>

    </tr>
  </table> 
  <div class="clear"></div>
  
  
  
<div class="clear"></div>
<div class="paddingTop5"></div>  
<div class="clear"></div>
<label>Weber</label><select validate="Weber,string,no"  name="weber" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Weber Left">Weber Left</option>
		<option value="Weber Right">Weber Right</option>
        <option value="Weber Central">Weber Central</option>
		</select>
		<div class="clear"></div>
		
<label class="heightAuto">Absolute Bone Conduction Test (ABC)</label>	
 <table width="" border="0" cellpadding="5" cellspacing="0"  style="width:392px; float:left;"> 
    <tr>   
      <th align="center">Right</th>   
      <th align="center">Left</th>
     
    </tr>
    <tr>
      
       <td align="left"> <select validate="Absolute Bone Conduction Test,string,no" name="rightAbsoluteBoneConductionTest" id="rightAbsoluteBoneConductionTest" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Equal/Normal">Equal/Normal</option>
		<option value="Decreased">Decreased</option>        
		</select></td>
      
      <td align="left"> <select validate="Absolute Bone Conduction Test,string,no"  name="leftAbsoluteBoneConductionTest" id="leftAbsoluteBoneConductionTest" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Equal/Normal">Equal/Normal</option>
		<option value="Decreased">Decreased</option>        
		</select></td>

 
	</tr></table>	
 <div class="clear"></div> 
  <div class="paddingTop5"></div>
  
  
<label>Mastoid Tenderness</label>	
 <table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:390px; float:left;"> 
    <tr>      
      <th align="center">Right</th>
      <th align="center">Left</th>
    </tr>
    <tr>
      
      <td align="left"> 
  
   <select validate="Right Mastoid Tenderness,string,no" value="" name="rightMastoidTenderness" id="rightMastoidTenderness" onchange="displayTextValue(this.value,'MastoidTendernessR')" tabindex="1"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	
				</select>
				  <div class="clear"></div>
	<select  multiple="multiple" class="multiple" name="tragalTendernessRightList" style="display:none;width:120px;height:32px!important;margin-top:0px!important;" id="tragalTendernessRightList">
				<option value="">Select</option>		
				<option value="Posterior">Posterior</option>
				<option value="Cymba Concha">Cymba Concha</option>
				<option value="Tip">Tip</option>
				</select>
    </td>
      <td align="left"> 
       <select validate="Left Mastoid Tenderness,string,no"  name="leftMastoidTenderness" id="leftMastoidTenderness" onchange="displayTextValue(this.value,'MastoidTendernessL')" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		
				</select>
				  <div class="clear"></div>
		<select  multiple="multiple" class="multiple" name="tragalTendernessLeftList" style="display:none;width:120px;height:32px!important;margin-top:0px!important;"  id="tragalTendernessLeftList" >
				<option value="">Select</option>		
				<option value="Posterior">Posterior</option>
				<option value="Cymba Concha">Cymba Concha</option>
				<option value="Tip">Tip</option>
				</select>    
      </td>
  
	</tr></table>	
	
<div class="clear"></div>
<div class="clear"></div>

<label>Facial Nerve</label>
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:392px; float:left;"> 
    <tr> 
      <th align="center">Right</th>     
      <th align="center">Left</th>
    </tr>
    <tr>
     <td align="left"> 
   <select validate="Righr Facial Nreve,string,no" name="rightFacialNerve" id="rightFacialNerve" tabindex="1" onchange="displayTextValue(this.value,'FacialNerveR')"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Palsy">Palsy</option>
				</select>
					
<div class="clear"></div>
<div id="rightGradingDiv" style="display: none">
<label  class="smallAuto autoSpace">Grading</label>
	<select validate="Right Grading,string,no" style="width:61px; margin-top:0px !important;" value="" name="rightGrading" id="rightGrading" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Grade I">Grade I</option>
		<option value="Grade II">Grade II</option>
		<option value="Grade III">Grade III</option>
        <option value="Grade IV">Grade IV</option>
		<option value="Grade V">Grade V</option>
		<option value="Grade VI">Grade VI</option>
</select>
</div>
  </td>
    
      <td align="left"> 
      <select validate="Left Facial Nreve,string,no"  name="leftFacialNerve" id="leftFacialNerve" tabindex="1" onchange="displayTextValue(this.value,'FacialNerveL')"> 
	<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Palsy">Palsy</option>
				</select>
					
  <div class="clear"></div>
<div id="leftGradingDiv" style="display: none">
<div class="clear"></div>
	<label class="smallAuto" style="margin-right:0px;">Grading</label>
	<select validate="Left Grading,string,no"  style="width:74px; margin-top:0px !important;" name="leftGrading" id="leftGrading"  tabindex="1"> 
		<option value="">Select</option>		
		<option value="Grade I">Grade I</option>
		<option value="Grade II">Grade II</option>
		<option value="Grade III">Grade III</option>
        <option value="Grade IV">Grade IV</option>
		<option value="Grade V">Grade V</option>
		<option value="Grade VI">Grade VI</option>
		</select>
		</div>
		</td>
 
</tr></table>	
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

    <label>Spontaneous Nystagmus</label>
       <select validate="Left Fistula Sign,string,no"  name="spontaneousNystagmus"  tabindex="1" onchange="displayTextValue(this.value,'Spontaneous')" class="smallest">
		<option value="">Select</option>		
		<option value="Yes">Yes</option>
		<option value="No">No</option>
				</select>
<div id="spontaneousDiv" style="display: none">
	 <label class="auto">Degree</label>
      <select validate="Left Fistula Sign,string,no"  name="spontaneouSnystagmusDegree"  tabindex="1" class="smallest">  
		<option value="">Select</option>		
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		</select>		
		<label class="auto">Direction</label>
        <select validate="Left Fistula Sign,string,no"  name="spontaneouSnystagmusDirection"  tabindex="1" class="smallest-"> 
		<option value="">Select</option>		
		<option value="Right">Right</option>
		<option value="Left">Left</option>
		<option value="Direction Changing">Direction Changing</option>
		<option value="Clockwise Torsion">Clockwise Torsion</option>
		<option value="Left">Anti-Clockwise Torsion</option>
		</select>				
		<input id="spontaneouSnystagmusDirectionValue" type="text" maxlength="100" validate="Spontaneou Snystagmus Direction Value,metachar,no" tabindex="1" value=""
		name="spontaneouSnystagmusDirectionValue" style="margin-left:5px;">						
 </div>  
 <div class="clear"></div>
  
<label>Fistula Sign</label>
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:392px; float:left;"> 
    <tr>      
      <th align="center">Right</th>
      <th align="center">Left</th>
    </tr>
    <tr>

  <td align="left"> 
  
 <select validate="Right Fistula Sign,string,no" value="" name="rightFistulaSign" id="" tabindex="1" onchange="displayTextValue(this.value,'FistulaSignR')"> 
		<option value="">Select</option>		
		<option value="Positive">Positive</option>
		<option value="Negative">Negative</option>
		<option value="False Positive">False Positive</option>
		<option value="False Negative">False Negative</option>
				</select>
					
  <div class="clear"></div>
  
  
  <!-- <div id="rightFistulaSignDiv" style="display: none">
				<label  class="smallAuto autoSpace" style="width:41px;margin:2px 0px 0px 5px;">Degree</label>
    <select validate="Right Fistula Sign,string,no" value="" name="rightFistulaSignDegree" style="width:63px; margin-top:0px !important;" id="" tabindex="1"> 
		<option value="">Select</option>		
		<option value="Positive">Positive</option>
		<option value="Negative">Negative</option>
				</select>
				
				
				   
				   <select validate="Right Fistula Sign,string,no"  style="width:63px; margin-top:0px !important;" name="rightFistulaSignDegree"  tabindex="1" >   
		<option value="">Select</option>		
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		</select>
				<div class="clear"></div>
				<label  class="smallAuto autoSpace" style="width:41px;margin:2px 0px 0px 5px;">Direction</label>
        <select validate="Left Fistula Sign,string,no"  name="rightFistulaSignDirection"  style="width:63px; margin-top:0px !important;" tabindex="1" > 
		<option value="">Select</option>		
		<option value="Right">Right</option>
		<option value="Left">Left</option>
		<option value="Direction Changing">Direction Changing</option>
		<option value="Clockwise Torsion">Clockwise Torsion</option>
		<option value="Anti-Clockwise Torsion">Anti-Clockwise Torsion</option>
				</select>
				</div> -->
  
  </td>
  <td align="left"> 
    <select validate="Left Fistula Sign,string,no"  name="leftFistulaSign"  tabindex="1" onchange="displayTextValue(this.value,'FistulaSignL')"> 
		<option value="">Select</option>		
		<option value="Positive">Positive</option>
		<option value="Negative">Negative</option>
		<option value="False Positive">False Positive</option>
		<option value="False Negative">False Negative</option>
				</select>
   
   
					
  <div class="clear"></div>
  
  
  <!-- <div id="leftFistulaSignDiv" style="display: none">
				<label  class="smallAuto autoSpace" style="width:41px;margin:2px 0px 0px 5px;">Degree</label>
      <select validate="Left Fistula Sign,string,no"  style="width:63px; margin-top:0px !important;" name="leftFistulaSignDegree"  tabindex="1" >  
		<option value="">Select</option>		
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
				</select>
				<div class="clear"></div>
				<label  class="smallAuto autoSpace" style="width:41px;margin:2px 0px 0px 5px;">Direction</label>
        <select validate="Left Fistula Sign,string,no"  style="width:63px; margin-top:0px !important;" name="leftFistulaSignDegreeDirection"  tabindex="1" > 
		<option value="">Select</option>		
		<option value="Right">Right</option>
		<option value="Left">Left</option>
		<option value="Direction Changing">Direction Changing</option>
		<option value="Clockwise Torsion">Clockwise Torsion</option>
		<option value="Anti-Clockwise Torsion">Anti-Clockwise Torsion</option>
				</select>
				</div> -->
  
          </td>
	</tr></table>	
 
  <div class="clear"></div>
 <!--  <label>Tympanic Membrane</label> -->
 <!--  <input id="tympanicMembrane" type="text" maxlength="30" validate="Tympanic Membrane,metachar,no" tabindex="1" value="" name="tympanicMembrane" > -->
 <!--  <textarea rows="" cols="" name ="tympanicMembrane" id ="tympanicMembrane" validate="Tympanic Membrane,metachar,no" tabindex="1"  class="large"></textarea> -->
  <div class="paddingTop5"></div>   
  <div class="clear"></div>
<!-- <label>Skull and Spine</label> -->
 <!--  <input id="" type="text" maxlength="250" validate="Skull and Spine,metachar,no" tabindex="1" value="" name="skullAndSpine" > -->
 <!-- <textarea rows="" cols="" name ="skullAndSpine" id ="skullAndSpine" validate="Skull and Spine,metachar,no" tabindex="1"  class="large"></textarea> -->
 <div class="clear"></div>
  <label>Cerebellar Signs</label>
  <!-- <input id="" type="text" maxlength="250" validate="Cerebellar Signs,metachar,no" tabindex="1" value="" name="cerebellarSign" > -->
  <textarea   maxlength="256"  rows="" cols="" name ="cerebellarSign" id ="cerebellarSign" validate="Cerebellar Signs,metachar,no" tabindex="1"  class="large" style="width:387px;"></textarea>
    <div class="clear"></div>
    <div class="paddingTop5"></div>
    <div class="clear"></div>
   <label class="heightAuto">Signs of Meningeal Irritation</label>
  <!-- <input id="" type="text" maxlength="250" validate="Cerebellar Signs,metachar,no" tabindex="1" value="" name="cerebellarSign" > -->
  <textarea rows="" cols="" maxlength="250"  name ="signsOfMeningealIrritation" id ="signsOfMeningealIrritation" validate="Signs of Meningeal Irritation,metachar,no" tabindex="1"  class="large" style="width:387px;"></textarea>
  
<div class="clear"></div>
  
  
<div class="clear"></div>
<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="showCollapasbleTab('Nose')" name="" value="+" type="button">
</div>
<div class="plusText"><h6 class="h4Tab">Nose and PNS</h6></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<!-- <div class="collapasHide" id="noseTitle"> -->
<div class="indArrow"></div>
<!-- <div class="Block"> -->
<h4>Inspection</h4>
<label>External Appearance</label>
<select name="externalAppearance" validate="External Appearance,string,no" value="" class="medium2" id="" tabindex="1"  onchange="displayTextValue(this.value,'Appearance');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
    <textarea  id="externalAppearanceValue" maxlength="256" validate="External Appearance,metachar,no" tabindex="1" value="" name="externalAppearanceValue" style="display: none" ></textarea>
  <!-- <div class="clear"></div> -->
  <label class="auto">Cold Spatula Test</label>
  <select tabindex="1" id="" name="coldSpatulaTest" value="" validate="Cold Spatula Test,string,no" class="medium2"> 
		<option value="">Select</option>		
		<option value="Equal">Equal</option>
		<option value="Left Decreased">Left Decreased</option>
		<option value="Left Absent">Left Absent</option>
		<option value="Right Decreased">Right Decreased</option>
		<option value="Right Absent">Right Absent</option>
		<option value="Both Absent">Both Absent</option> 
		<option value="Both Decreased">Both Decreased</option>       
		</select>
<div class="clear"></div>


<label>Vestibule</label>
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:392px; float:left;"> 
    <tr>      
      <th align="center">Right</th>
      <th align="center">Left</th>
    </tr>
    <tr>

  <td align="left"> 

  <select name="rightVestibule" validate="External Appearance,string,no" id="rightVestibule" tabindex="1"
  onchange="displayTextValue(this.value,'VestibuleR');" style="width:140px; margin-left:0px !important;"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<!-- <option value="Both Decreased">Both Decreased</option> -->
				</select>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="text" maxlength="250" validate="Vestibule and Columella,metachar,no" tabindex="1" value="" id = "rightVestibuleValue" name="rightVestibuleValue" style="display: none" />
  </td>
  <td align="left"> 
      
  <select name="leftVestibule" validate="Vestibule Left,string,no" id="leftVestibule" tabindex="1" 
  onchange="displayTextValue(this.value,'VestibuleL');" style="width:140px; margin-left:0px !important;">  
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
		<!-- <option value="Both Decreased">Both Decreased</option> -->
				</select>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	<input type="text" maxlength="250" validate="Vestibule and Columella,metachar,no" tabindex="1" value="" id = "leftVestibuleValue" name="leftVestibuleValue" style="display: none"/>
		
		<div class="clear"></div>

      </td>
	</tr></table>	
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Columella</label>			

<!-- <input type="text" maxlength="250" validate="Columella,metachar,no" tabindex="1" value="" id = "columella" name="columella"  /> -->
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:392px; float:left;">
<tr>  
      <th align="center">Right</th>    
      <th align="center">Left</th>
    </tr>
    <tr>

  <td align="left"> 

  <select name="rightColumella" validate="Columella Right,string,no" id="rightColumella" tabindex="1"
  onchange="displayTextValue(this.value,'ColumellaR');" style="width:140px; margin-left:0px !important;"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
 </select>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="text" maxlength="250" validate="Columella,metachar,no" tabindex="1" value="" id = "rightColumellaValue" name="rightColumellaValue" style="display: none" />
  </td>
  
     <td align="left"> 
      
  <select name="leftColumella" validate="Columella Left,string,no" id="leftColumella" tabindex="1" 
  onchange="displayTextValue(this.value,'ColumellaL');" style="width:140px; margin-left:0px !important;">  
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
 </select>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	
		<input type="text" maxlength="250" validate="Columella,metachar,no" tabindex="1" value="" id = "leftColumellaValue" name="leftColumellaValue" style="display: none" />
		<div class="clear"></div>

      </td>
	</tr></table>
<div class="clear"></div>
<div class="paddingTop5"></div> 
<!-- Anterior Rhinoscopy section -->
<h4>Anterior Rhinoscopy</h4>
<div class="clear"></div>
<div class="entExaImageLeftDiv">
<label>Septum</label>
<textarea class="textareaMediua" rows="" cols="" maxlength="256" validate="Septum,metachar,no" tabindex="1" value="" name="noseSeptum" id="noseSeptum"> </textarea>
<div class="clear"></div>
<table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">IT</label></td>
      <td align="left"><input id="noseRightIt" type="text" maxlength="50" validate="Right IT,metachar,no" tabindex="1" value="" name="noseRightIt" ></td>
      <td align="left"><input id="noseleftIt" type="text" maxlength="50" validate="Left IT,metachar,no" tabindex="1" value="" name="noseleftIt" ></td>
    </tr>
   
    <tr>
      <td align="left"><label class="Tablelabel">IM</label></td>
      <td align="left"><input id="noseRightIM" type="text" maxlength="50" validate="Right IM,metachar,no" tabindex="1" value="" name="noseRightIM" ></td>
      <td align="left"><input id="noseleftIM" type="text" maxlength="50" validate="Left IM,metachar,no" tabindex="1" value="" name="noseleftIM" ></td>
    </tr>
    
    <tr>
      <td align="left"><label class="Tablelabel">MT</label></td>
      <td align="left"><input id="noseRightMT" type="text" maxlength="50" validate="Right MT,metachar,no" tabindex="1" value="" name="noseRightMT" ></td>
      <td align="left"><input id="noseleftMT" type="text" maxlength="50" validate="Left MT,metachar,no" tabindex="1" value="" name="noseleftMT" ></td>
    </tr>
    
    <tr>
      <td align="left"><label class="Tablelabel">MM</label></td>
      <td align="left"><input id="noseRightMM" type="text" maxlength="50" validate="Right MM,metachar,no" tabindex="1" value="" name="noseRightMM" ></td>
      <td align="left"><input id="noseleftMM" type="text" maxlength="50" validate="Left MM,metachar,no" tabindex="1" value="" name="noseleftMM" ></td>
    </tr>
    
    <tr>
      <td align="left"><label class="Tablelabel">Floor</label></td>
      <td align="left"><input id="noseRightFloor" type="text" maxlength="50" validate="Right Floor,metachar,no" tabindex="1" value="" name="noseRightFloor" ></td>
      <td align="left"><input id="noseleftFloor" type="text" maxlength="50" validate="Left Floor,metachar,no" tabindex="1" value="" name="noseleftFloor" ></td>
    </tr>
    
     <tr>
      <td align="left"><label class="Tablelabel">Roof</label></td>
      <td align="left"><input id="noseRightRoof" type="text" maxlength="50" validate="Right Roof,metachar,no" tabindex="1" value="" name="noseRightRoof" ></td>
      <td align="left"><input id="noseleftRoof" type="text" maxlength="50" validate="Left Roof,metachar,no" tabindex="1" value="" name="noseleftRoof" ></td>
    </tr>
  </table> 
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>   
<div class="clear"></div>
<div class="clear"></div>
 <div class="clear"></div>
 <div class="titleBg">
<h2>Post nasal Examination</h2>
 <div class="clear"></div>
 </div>
 <div class="clear"></div>
  
 <label>Posterior end of septum </label>
  <select name="posteriorEndOfSeptum" validate="Posterior end of septum,string,no"   id="posteriorEndOfSeptum" tabindex="1" onchange="displayTextValue(this.value,'Posterior');">
  <option value="">Select</option> 
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
  <textarea id="posteriorEndOfSeptumValue"  maxlength="256" validate="Posterior end of septum,metachar,no" tabindex="1" value="" name="posteriorEndOfSeptumValue" style="display: none" ></textarea>
   
<div class="clear"></div>  
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><strong>Choanae</strong></td>
      <td align="left">
      <div class="tdWidth">
      <select name="rightChoane" validate="Right Choanae,string,no"   id="rightChoane" tabindex="1" onchange="displayTextValue(this.value,'ChoaneR');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="rightChoaneValue" type="text" maxlength="100" validate="Right Choane Value,metachar,no" tabindex="1" value="" name="rightChoaneValue" style="display: none" >
      </div>
      </td>
      <td align="left">
      <div class="tdWidth">
      <select name="leftChoane" validate="Left Choanae,string,no"   id="leftChoane" tabindex="1" onchange="displayTextValue(this.value,'ChoaneL');"> 
      <option value="">Select</option>
	  <option value="Normal">Normal</option>
	  <option value="Abnormal">Abnormal</option>
	  </select>
	  
	  <div class="clear"></div>
	  <div class="paddingTop5"></div>
	  <input id="leftChoaneValue" type="text" maxlength="100" validate="Left Choanae Value,metachar,no" tabindex="1" value="" name="leftChoaneValue" style="display: none" >
	  </div>
		</td>
    </tr>
    <tr>
      <td align="left"><strong>Roof</strong></td>
      <td align="left">
      <div class="tdWidth">
      <select name="rightPostnatalRoof" validate="Roof,string,no"   id="rightPostnatalRoof" tabindex="1" onchange="displayTextValue(this.value,'RoofR');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="rightPostnatalRoofValue" type="text" maxlength="100" validate="Right Postnatal Ro of Value,metachar,no" tabindex="1" value="" name="rightPostnatalRoofValue"  style="display: none">
      </div>
      </td>
      <td align="left">
      <div class="tdWidth">
      <select name="leftPostnatalRoof" validate="Roof,string,no"   id="leftPostnatalRoof" tabindex="1" onchange="displayTextValue(this.value,'RoofL');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="leftPostnatalRoofValue" type="text" maxlength="100" validate="left Postnatal Ro of Value,metachar,no" tabindex="1" value="" name="leftPostnatalRoofValue" style="display: none" >
      </div>
      </td>
    </tr>
    <tr>
      <td align="left"><strong>ET orifice</strong></td>
      
      <td align="left">
      <div class="tdWidth">
      <select name="rightEtOnliae" validate="Right ET orifice,string,no"   id="rightEtOnliae" tabindex="1" onchange="displayTextValue(this.value,'EtOnliaeR');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
		</select>      
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="rightEtOnliaeValue" type="text" maxlength="100" validate="Right ET orifice value,metachar,no" tabindex="1" value="" name="rightEtOnliaeValue"  style="display: none">
      </div>
      </td>
      
      <td align="left">
      <div class="tdWidth">
      <select name="leftEtOnliae" validate="Left ET orifice ,string,no"   id="leftEtOnliae" tabindex="1" onchange="displayTextValue(this.value,'EtOnliaeL');"> 
      <option value="">Select</option>
		<option value="Normal" "Normal"="selected">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="leftEtOnliaeValue" type="text" maxlength="100" validate="Left ET orifice value,metachar,no" tabindex="1" value="" name="leftEtOnliaeValue"  style="display: none">
      </div>
      </td>
    </tr>
    
    <tr>
      <td align="left"><strong>FOR</strong></td>
      <td align="left">
      <div class="tdWidth">
      <select name="rightFor" validate="Right FOR,string,no"   id="rightFor" tabindex="1" onchange="displayTextValue(this.value,'ForR');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="rightForValue" type="text" maxlength="100" validate="Right FOR value,metachar,no" tabindex="1" value="" name="rightForValue" style="display: none" >
      </div>
      </td>
      
       <td align="left">
      <div class="tdWidth">
      <select name="leftFor" validate="Left FOR,string,no"   id="leftFor" tabindex="1" onchange="displayTextValue(this.value,'ForL');"> 
      <option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="leftForValue" type="text" maxlength="100" validate="Left FOR value,metachar,no" tabindex="1" value="" name="leftForValue" style="display: none" >
      </div>
      </td>
    </tr>
    
    <tr>
      <td align="left"><strong>Posterior end of turbinates</strong></td>
      
      <td align="left">
      <div class="tdWidth">
      <select name="rightPosteriorTurbinates" validate="Right Posterior end of turbinates,string,no"   id="rightPosteriorTurbinates" tabindex="1" onchange="displayTextValue(this.value,'TurbinatesR');">
      <option value="">Select</option> 
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="rightPosteriorTurbinatesValue" type="text" maxlength="100" validate="Right Posterior end of turbinates value,metachar,no" tabindex="1" value="" name="rightPosteriorTurbinatesValue"  style="display: none">
      </div>
      </td>
      
      <td align="left">
      <div class="tdWidth">
      <select name="leftPosteriorTurbinates" validate="Left Posterior end of turbinates,string,no"   id="leftPosteriorTurbinates" tabindex="1" onchange="displayTextValue(this.value,'TurbinatesL');">
      <option value="">Select</option> 
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
      <div class="clear"></div>
	  <div class="paddingTop5"></div>
      <input id="leftPosteriorTurbinatesValue" type="text" maxlength="100" validate="Left Posterior end of turbinates value,metachar,no" tabindex="1" value="" name="leftPosteriorTurbinatesValue" style="display: none" >
      </div>
      </td>
    </tr>
    
    
  </table>  
  <div class="clear"></div>
<div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="paddingTop5"></div>   
  <div class="clear"></div>
<table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center">Examination of Paranasal Sinuses</th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Maxillary</label></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Right Maxillary,metachar,no" tabindex="1" value="" name="rightMaxillary" ></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Left Maxillary,metachar,no" tabindex="1" value="" name="leftMaxillary" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Frontal</label></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Right Frontal,metachar,no" tabindex="1" value="" name="rightFrontol" ></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Left Frontal,metachar,no" tabindex="1" value="" name="leftFrontol" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Ethmoid</label></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Right Ethmoid,metachar,no" tabindex="1" value="" name="rightEthmoid" ></td>
      <td align="left"><input id="" type="text" maxlength="50" validate="Left Ethmoid,metachar,no" tabindex="1" value="" name="leftEthmoid" ></td>
    </tr>
     <!-- <tr>
      <td align="left"><label class="Tablelabel">Olfaction</label></td>
      <td align="left"><input id="rightOlfaction" type="text" maxlength="50" validate="Right Ethmoid,metachar,no" tabindex="1" value="" name="rightOlfaction" ></td>
      <td align="left"><input id="leftOlfaction" type="text" maxlength="50" validate="Left Ethmoid,metachar,no" tabindex="1" value="" name="leftOlfaction" ></td>
    </tr> -->
  </table>

<div class="clear"></div>
<div class="paddingTop5"></div>
  
  <table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Olfaction</label></td>
      <td align="left"><input id="rightOlfaction" type="text" maxlength="50" validate="Right Ethmoid,metachar,no" tabindex="1" value="" name="rightOlfaction" ></td>
      <td align="left"><input id="leftOlfaction" type="text" maxlength="50" validate="Left Ethmoid,metachar,no" tabindex="1" value="" name="leftOlfaction" ></td>
    </tr>
    </table> 
      <div class="clear"></div>
  <div class="paddingTop5"></div>    
  <label>Eye and Orbit</label>			
<textarea maxlength="256" validate="Eye and Orbit,metachar,no" class="large" tabindex="1" value="" id ="eyeAndOrbit" name="eyeAndOrbit" style="width:385px;" ></textarea>
<div class="clear"></div>


<div class="clear"></div>  
 </div> 
<!-- block div end --> 
</div>
<!-- ----entExaImageLeftDiv end here--- -->

<script>
jQuery.noConflict();
//setTimeout(function(){
jQuery(document).ready(function($) {
	   var annotatable = $('.ann');
		    for (var i = 0; i < annotatable.length; i++) {
		        $(annotatable[i]).annotate({
		            color: 'black',
		            images: [annotatable[i].getAttribute('data-src')],
		        	id : i,
		        	/* divId:document.getElementById('tool-tip'); */
		        });
		    }
	});
//} , 1000);
 
 
 </script>
 

<div style="width:530px; float:left;">
    <div>
        <!-- <button class="export-image">Export image</button> -->
    <!-- <button onclick="exportImages()" class="mybutton" style="padding: 10px;width: 100px;background-color: #4CAF50;color: #fff;font-size: 15px;" type="button">Export image</button> -->
   <!--  <input id="btn" type="button" class="mybutton" value="click" onclick="exportImages();" /> -->
        
    </div>
     <div class="clear"></div>
  <div class="paddingTop5"></div>
    <div id="tool-tip" style="width:530px; float:left;">
            
        <label class="auto"><input class="checkboxMargin" type="radio" name="tool_option_myCanvas" data-tool="rectangle" checked="">RECTANGLE</label>
        <label class="auto"><input class="checkboxMargin" type="radio" name="tool_option_myCanvas" data-tool="circle">CIRCLE</label>
        <label class="auto"><input class="checkboxMargin" type="radio" name="tool_option_myCanvas" data-tool="text"> TEXT</label>
        <label class="auto"><input class="checkboxMargin" type="radio" name="tool_option_myCanvas" data-tool="arrow">ARROW</label>
        <label class="auto"><input class="checkboxMargin" type="radio" name="tool_option_myCanvas" data-tool="pen">PEN</label>
        <button id="undoaction" class="annotate-undo">UNDO</button>
        <button id="redoaction" class="annotate-redo" title="Redo the last undone annotation">REDO</button>
    </div>
 <div class="clear"></div>
  <div class="paddingTop5"></div>
  
    <%
    
   // if(entExaminationList.size()>0){
    	String imageName = "";
    	String imgSrc ="";
    	String imagextension = "png";
    	String fileSeparator = System.getProperty("file.separator");
    	
    	String imageNameStr = entExaminationList.size()>0 && entExaminationList.get(0).getImageName() !=null?entExaminationList.get(0).getImageName() :"";
    	if(!imageNameStr.equals("")){
    	String[] imageList = imageNameStr.split(",");
    	for(int j = 0; j <imageList.length; j++)
    	{
        	  //imgSrc = getServletContext().getRealPath("/specialityImage")+fileSeparator+imageList[j]+"."+imagextension;
        	  imgSrc = request.getContextPath()+fileSeparator+"specialityImage"+fileSeparator+imageList[j]+"."+imagextension;
	    	    //System.out.println(imageList[j]);
        	  //imgSrc = request.getContextPath()+fileSeparator+"\\specialityImage\\"+"ENT_3338312_01";
        	  
        	 // System.out.println("imgSrc==="+imgSrc);
    		
    	
             %>
              <div class="ann"  data-src="<%= imgSrc%>" style="position: relative;" id="image1"  ></div>
       
   <%} %>
  
  <% }else{ %>  
 <%--   <div class="ann"  data-src="<%= imgSrc%>" style="position: relative;" id="image1"  ></div> --%> 
	 <div class="ann"  data-src="/hms/jsp/images/left_tympanic_membrance.jpg" style="position: relative;" id="image1"  ></div> 
  <div class="ann"  data-src="/hms/jsp/images/right_tympanic_membrance.jpg" style="position: relative;" id="image2"  ></div>
   <div class="ann"  data-src="/hms/jsp/images/left_tympanic_membrance_normal.jpg" style="position: relative;" id="image3"  ></div>
    <div class="ann"  data-src="/hms/jsp/images/right_tympanic_membrance_normal.jpg" style="position: relative;" id="image4"  ></div>
    <div class="ann" data-src="/hms/jsp/images/anterior_rhinoscopy.jpg" style="position: relative;" id="image5"></div>
    <div class="ann" data-src="/hms/jsp/images/indirect_laryngoscopy.jpg" style="position: relative;" id="image6" ></div>
	<div class="ann" data-src="/hms/jsp/images/indirect_laryngoscopy_2.jpg" style="position: relative;" id="image7" ></div>

	<div class="ann" data-src="/hms/jsp/images/post_nasal_examination.jpg" style="position: relative;" id="image8"></div>
	<div class="ann" data-src="/hms/jsp/images/oral_cavity_and_oropharynx.jpg" style="position: relative;" id="image9"></div>
	  <%} %> 

</div> 


<div class="entExaImageRightDiv">

<div class="Block">
<div class="clear"></div>
<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="showCollapasbleTab('oralCavity')" name="" value="+" type="button">
</div>
<div class="plusText"><h4 class="h4Tab">Oral Cavity and Throat</h4></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="collapasHide" id="oralCavityTitle" style="width:576px;">
<div class="indArrow"></div>
<div class="Block" style="width:575px;">

<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Upper</th>
      <th align="left">Lower</th>
    </tr>
 <tr>
 <td align="left"><label class="Tablelabel">Lips </label></td>
 	  <td align="left">      
  <select name="upperLips" validate="Upper Lips,string,no"   id="upperLips" tabindex="1" onchange="displayTextValue(this.value,'LipsU');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>	
				</select>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
    <input id="upperLipsValue" type="text" maxlength="100" validate="Upper Lips value,metachar,no" tabindex="1" value="" name="upperLipsValue" style="display: none" >
    <div class="clear"></div></td>
  <!-- <label>Lower Lips</label> -->
   <td align="left">
   
  <select name="lowerLips" validate="Lower Lips,string,no"   id="lowerLips" tabindex="1" onchange="displayTextValue(this.value,'LipsL');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
				<div class="clear"></div>
				<div class="paddingTop5"></div>
  <input id="lowerLipsValue" type="text" maxlength="100" validate="Lower Lips value,metachar,no" tabindex="1" value="" name="lowerLipsValue" style="display: none" />
     <div class="clear"></div></td>
     <tr></table>
    <div class="clear"></div>
  <label>Mouth Opening</label>
  <select name="mouth" validate="Mouth Opening,string,no"   id="mouth" tabindex="1" onchange="displayTextValue(this.value,'Mouth');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
<textarea id="mouthValue"  maxlength="256" validate="Mouth Opening value,metachar,no" tabindex="1" value="" name="mouthValue" class="textareaMediua" style="display: none" ></textarea>
    
     <div class="clear"></div>
     <label>Teeth</label>
  <select name="teeth" validate="Teeth,string,no"   id="teeth" tabindex="1"  onchange="displayTextValue(this.value,'Teeth');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
 <textarea id="teethValue"  maxlength="256" validate="Teeth value,metachar,no" tabindex="1" value="" class="textareaMediua" name="teethValue" style="display: none" ></textarea>
    <div class="clear"></div>
  <label>Gums</label>
    <select name="gums" validate="Gums,metachar,no"   id="gums" tabindex="1" onchange="displayTextValue(this.value,'Gums');" > 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
 <textarea id="gumsValue"  maxlength="256" validate="Gums value,metachar,no" tabindex="1" value="" class="textareaMediua" name="gumsValue" style="display: none" ></textarea>
  <div class="clear"></div>
    
  <div class="clear"></div>
  <label>Gingivolabial Sulcus</label>
 <textarea id="" maxlength="256" validate="Gingivo Labial Sulcus,metachar,no" tabindex="1" value="" name="gingivoLabialSulcus" class="textareaMediua" ></textarea>
  
  <div class="clear"></div>
  <label>Gingivobuccal Sulcus</label>
 <textarea id="" maxlength="256" validate="Gingivo Buccal Sulcus,metachar,no" tabindex="1" value="" name="gingivobuccalSulcus" class="textareaMediua" ></textarea>
   
  <div class="clear"></div>
  <label>Buccal Mucosa</label>
 <textarea id=""  maxlength="256" validate="Buccal Mucosa,metachar,no" tabindex="1" value="" name="buccalMucosa" class="textareaMediua"></textarea>
    
      <div class="clear"></div>
      <div class="clear"></div>
     <label>Tongue</label>
  <select name="tongue" validate="Teeth,string,no"  id="tongue" tabindex="1" onchange="displayTextValue(this.value,'Tongue');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
 <textarea id="tongueValue" maxlength="256" validate="Tongue value,metachar,no" class="textareaMediua" tabindex="1" value="" name="tongueValue" style="display: none" ></textarea>
  <div class="clear"></div>
   <label>Hard Palate</label>
 <textarea id="" maxlength="256" validate="Hard Palate,metachar,no" tabindex="1" value="" name="hardPalate" class="textareaMediua"></textarea>
     <div class="clear"></div>
    <label>Retro molar trigone Right</label>
  <select name="retroMolarRight" validate="Teeth,string,no"  id="retroMolarRight" tabindex="1" onchange="displayTextValue(this.value,'RetromolarR');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
  
 <textarea id="retroMolarRightValue" maxlength="256" class="textareaMediua" validate="Retro molar trigone Right value,metachar,no" class="textareaMediua" tabindex="1" value="" name="retroMolarRightValue" style="display: none" ></textarea>
      
    <div class="clear"></div>
  
  <div class="clear"></div>   
    <label>Retro molar trigone Left</label>
  <select name="retroMolarLeft" validate="Retro molar trigone Left,string,no" id="retroMolarLeft" tabindex="1" onchange="displayTextValue(this.value,'RetromolarL');"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
 <textarea id="retroMolarLeftValue" maxlength="256" class="textareaMediua" validate="Retro molar trigone Left value,metachar,no" tabindex="1" value="" name="retroMolarLeftValue" style="display: none" ></textarea>
    <div class="clear"></div>


</div>
</div>
<div class="clear"></div>
<h4>Floor of Mouth</h4>
<label>Frenulum</label>
 <textarea id="frenulum" maxlength="256" validate="Frenulum,metachar,no" tabindex="1" value="" name="frenulum" class="textareaMediua" > </textarea>
  <div class="clear"></div> 
<label>Opening of Salivary Duct</label>
 <textarea id="salivaryDuct" maxlength="256" validate="Opening of Salivary Duct,metachar,no" tabindex="1" value="" name="salivaryDuct" class="textareaMediua" > </textarea>
    <div class="clear"></div>
   <label>Any other finding</label>
 <textarea id="anyOtherFinding"  maxlength="256" validate="Any other finding,metachar,no" tabindex="1" value="" name="anyOtherFinding" class="textareaMediua" ></textarea>
 <div class="clear"></div>
 
  <h4>Oropharynx</h4>
  <h4 style="color:#000;">Uvula</h4>
 <div class="clear"></div>
   <label>Appearance</label>
   <textarea id="appearance"  maxlength="256" validate="Buccal Mucosa,metachar,no" tabindex="1" value="" name="appearance" class="textareaMediua"></textarea>
  <div class="clear"></div>
  <label>Deviation </label>
  <label class="auto">Yes <input type="radio" name="deviation" class="checkboxMargin" id="deviation" value="Yes"  onclick="displayTextValue(this.value,'Deviation');"/></label>

<label class="auto">No <input type="radio" name="deviation" class="checkboxMargin" id="deviation" checked="checked" value="No" onclick="displayTextValue(this.value,'Deviation');"/></label>

 <div class="clear"></div>
<div id="deviationDiv" style="display: none">
 <label class="medium">Left Deviation </label>
   <textarea id="leftDeviation" maxlength="256" validate="Left Deviation,metachar,no" tabindex="1" value="" name="leftDeviation" ></textarea>
   <label class="auto">Right Deviation </label>
 <textarea id="rightDeviation"  maxlength="256" validate="Right Deviation,metachar,no" tabindex="1" value="" name="rightDeviation" ></textarea>
</div>
    
        <div class="clear"></div>
        <table width="500" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Soft palate</label></td>
      <td align="left"><input id="rightSoftPalette" type="text" maxlength="100" validate="Right Soft palette,metachar,no" tabindex="1" value="" name="rightSoftPalette" ></td>
      <td align="left"><input id="leftSoftPalette" type="text" maxlength="100" validate="Left Soft palette,metachar,no" tabindex="1" value="" name="leftSoftPalette" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Anterior Pillar </label></td>
      <td align="left"><input id="rightAnteriorPillar" type="text" maxlength="100" validate="Right Anterior Pillar,metachar,no" tabindex="1" value="" name="rightAnteriorPillar" ></td>
      <td align="left"><input id="leftAnteriorPillar" type="text" maxlength="100" validate="Left Anterior Pillar,metachar,no" tabindex="1" value="" name="leftAnteriorPillar" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Tonsil</label></td>
      <td align="left"><input id="rightTonsil" type="text" maxlength="100" validate="Right Tonsil,metachar,no" tabindex="1" value="" name="rightTonsil" ></td>
      <td align="left"><input id="leftTonsil" type="text" maxlength="100" validate="Left Tonsil,metachar,no" tabindex="1" value="" name="leftTonsil" ></td>
    </tr>
    
    <tr>
      <td align="left"><label class="Tablelabel">Posterior pillar</label></td>
      <td align="left"><input id="rightPosteriorPillar" type="text" maxlength="100" validate="Right Posterior pillar,metachar,no" tabindex="1" value="" name="rightPosteriorPillar" ></td>
      <td align="left"><input id="leftPosteriorPillar" type="text" maxlength="100" validate="Left Posterior pillar,metachar,no" tabindex="1" value="" name="leftPosteriorPillar" ></td>
    </tr>
  </table>
  <div class="clear"></div> 

<div class="clear"></div>
  <div class="paddingTop5"></div>
  <label>Posterior Pharyngeal Wall</label>
  <textarea id="" maxlength="256" validate="Posterior Pharyngeal Wall,metachar,no" tabindex="1" value="" name="posterioPpharyngealWall" class="textareaMediua" ></textarea>
     <div class="clear"></div>     
    
  <h4>Larynx and Hypopharynx</h4>
  <div class="clear"></div>
  <label class="auto">IDL Findings</label>
  
  <textarea rows="" cols="" name ="idlFindings" id ="idlFindings" validate="IDL Findings,metachar,no" tabindex="1"  class="historyAutoComplete" style="width:460px;" maxlength="256"  ></textarea>
   <div class="clear"></div>
</div>
</div>



<div class="clear"></div>
 
<div class="plusDiv">
<input class="plusMinus" tabindex="3" onclick="showCollapasbleTab('Neck')" name="" value="+" type="button">
</div>
<div class="plusText"><h6 class="h4Tab">Examination of Neck</h6></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
 <div class="collapasHide" id="neckTitle">
 <div class="indArrow"></div>
 <div class="Block">   
 <h4>Inspection</h4>
<div class="entExaImageLeftDiv2">

<label>Swelling</label>
<select tabindex="1" id="" name="swelling"  validate="Swelling,string,no" onchange="displayTextValue(this.value,'Swelling')"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	        
		</select>
<div class="clear"></div>
<div id="swellingDiv" style="display: none">
<h4>Inspection of Swelling</h4>
<label class="medium">Size</label>
<input id="" type="text" maxlength="2" validate="Size,num,no" tabindex="1" value="" name="size" style="width:160px;">
<label class="medium">Shape</label>
<input id="" type="text" maxlength="50" validate="Shape,metachar,no" tabindex="1" value="" name="shape" >
<div class="clear"></div>
<label class="medium">Surface</label>
<input id="" type="text" maxlength="30" validate="Surface,metachar,no" tabindex="1" value="" name="surface" style="width:160px;">
<label class="auto">Skin over Swelling</label>
<input id="" type="text" maxlength="30" validate="Skin over Swelling,metachar,no" tabindex="1" value="" name="skinOverSwelling" style="width:163px;">
<div class="clear"></div> 
<label>Movements on deglutition</label>
<select tabindex="1" id="" name="movementsOnDeglutition"  validate="Movements on deglutition,string,no" style="width:90px;"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	            
		</select>
		
<label class="auto">Movements with Protrusion of Tongue</label>
<select tabindex="1" id="movementsWithProtrusionOfTongue" name="movementsWithProtrusionOfTongue"  validate="Movements with Protrusion of Tongue,string,no" style="width:55px;"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	           
		</select>
		<div class="clear"></div>
		<label>Engorged Veins</label>
<select tabindex="1"  name="engorgedVeins"  validate="Engorged Veins,string,no" style="width:90px;" > 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	            
		</select>

<label>Pulsation</label>
<select tabindex="1"  name="pulsation"  validate="Pulsation,string,no" style="width:90px;"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	            
		</select>
<div class="clear"></div>
<h4>Palpation</h4>
<label>Tenderness</label>
<select tabindex="1"  name="tenderness"  validate="Tenderness,string,no"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>	           
		</select>
		<div class="clear"></div>
<label>Fixity to deeper structures</label>
<select tabindex="1"  name="fixityToDeeperStructures" validate="Fixity to deeper structures,string,no" onchange="displayTextValue(this.value,'Fixity')"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>	            
		</select>
		<input id="fixityToDeeperStructuresValue" type="text" maxlength="100" validate="Fixity to deeper structures value,metachar,no" tabindex="1" value="" name="fixityToDeeperStructuresValue" style="display: none">
<div class="clear"></div>		
<label>Palpable pulsation</label>
<select tabindex="1"  name="palpablePulsation" validate="Palpable pulsation,string,no" onchange="displayTextValue(this.value,'Palpable')"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>	           
		</select>
<input id="palpablePulsationValue" type="text" maxlength="100" validate="Palpable pulsation value,metachar,no" tabindex="1" value="" name="palpablePulsationValue" style="display: none">
		
		<div class="clear"></div>
<label>Laryngeal Crepitus</label>
<select tabindex="1"  name="laryngealCrepitus"  validate="Laryngeal Crepitus,string,no"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>	            
		</select>
<div class="clear"></div>
<div class="clear"></div>
<h4>Auscultation</h4>
<label>Bruit</label>
<select tabindex="1"  name="bruit" validate="Bruit,string,no"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>
	            
		</select> 
</div>
<div class="clear"></div>
 <div class="clear"></div>
  <div class="paddingTop5"></div>
<label>Lymphnodes</label>
<select tabindex="1" id="lymphnodes" name="lymphnodes"  validate="Swelling,string,no" onchange="displayTextValue(this.value,'Lymphnodes')"> 
		<option value="">Select</option>		
			<option value="Yes">Yes</option>
		<option value="No">No</option>	        
		</select>

<div id="lymphnodesDiv" style="display: none">
 <textarea id="lymphnodesValue"  maxlength="256" validate="Lymphnodes value,metachar,no" tabindex="1" value="" name="lymphnodesValue" style="width:190px;"></textarea>

<div class="clear"></div>
<table width="" border="0" cellpadding="5" cellspacing="0"  style="width:560px; float:left;"> 
    <tr>
      <th align="center"></th>
      <th align="left">Right</th>
      <th align="left">Left</th>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Level</label></td>
      <td align="left"><select tabindex="1" id="rightLevel" name="rightLevel"  validate="Right Level,string,no" style="width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select></td>
		<td align="left"><select tabindex="1" id="leftLevel" name="leftLevel"  validate="Left Level,string,no" style="width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Size</label></td>
      <td align="left"><input id="rightSize" type="text" maxlength="5" validate="Right Size,num,no" tabindex="1" value="" name="rightSize" ></td>
      <td align="left"><input id="leftSize" type="text" maxlength="5" validate="Left Size,num,no" tabindex="1" value="" name="leftSize" ></td>
    </tr>
    <tr>
      <td align="left"><label class="Tablelabel">Consistency</label></td>
      <td align="left"><select tabindex="1" id="rightConsistency" name="rightConsistency"  validate="Right Consistency,string,no" style="width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="Soft">Soft</option>
			<option value="Medium">Medium</option>
			<option value="Hard">Hard</option>
		</select></td>
		 <td align="left"><select tabindex="1" id="leftConsistency" name="leftConsistency"  validate="Left Consistency,string,no" style="width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="Soft">Soft</option>
			<option value="Medium">Medium</option>
			<option value="Hard">Hard</option>
		</select></td>
    </tr>
    
    <tr>
      <td align="left"><label class="Tablelabel">Surface</label></td>
     
      <td align="left">
      
      <label class="smallAuto autoSpace">Regular</label>
      <input type="radio" name="rightSurface" class="radioCheckCol2" id="rightSurface" value="Regular" onchange="displayTextValue(this.value,'SurfaceR');"/>
      <label class="smallAuto autoSpace">Irregular</label>
      <input type="radio" name="rightSurface" class="radioCheckCol2" id="rightSurface" value="Irregular" onchange="displayTextValue(this.value,'SurfaceR');"/>
      <div class="clear"></div>
      <div class="clear"></div>   
      <input id="rightSurfaceValue" type="text" maxlength="50" validate="Right Surface value,metachar,no" tabindex="1" value="" name="rightSurfaceValue" style="display: none" ></td>
      
       <td align="left">
      <label class="smallAuto autoSpace">Regular</label>
      <input type="radio" name="leftSurface" class="radioCheckCol2" id="leftSurface" value="Regular" onchange="displayTextValue(this.value,'SurfaceL');"/>
      <label class="smallAuto autoSpace">Irregular</label>
      <input type="radio" name="leftSurface" class="radioCheckCol2" id="leftSurface" value="Irregular" onchange="displayTextValue(this.value,'SurfaceL');"/>
    <div class="clear"></div>
    <div class="clear"></div>
	<input id="leftSurfaceValue" type="text" maxlength="50" validate="Left Surface value,metachar,no" tabindex="1" value="" name="leftSurfaceValue"  style="display: none"></td>
    </tr>    
    <tr>
      <td align="left"><label class="Tablelabel">Margins</label></td>
      <td align="left"><input id="rightMargins" type="text" maxlength="50" validate="Right Margins,metachar,no" tabindex="1" value="" name="rightMargins" ></td>
      <td align="left"><input id="leftMargins" type="text" maxlength="50" validate="Left Margins,metachar,no" tabindex="1" value="" name="leftMargins" ></td>
    </tr>    
    <tr>
      <td align="left"><label class="Tablelabel">Mobility</label></td>
      
      <td align="left">
<label class="smallAuto autoSpace">Normal</label>
<input type="radio" name="rightMobility" checked="checked" class="radioCheckCol2" id="rightMobility" value="Normal" onchange="displayTextValue(this.value,'MobilityR')"/>
<label class="smallAuto autoSpace">Abnormal</label>
<input type="radio" name="rightMobility" class="radioCheckCol2" id="rightMobility" value="Abnormal" onchange="displayTextValue(this.value,'MobilityR')"/>
<div class="clear"></div>
<div class="clear"></div>	
<select tabindex="1" id="rightMobilityValue" name="rightMobilityValue"  validate="Right Surface,string,no"  style="display:none; width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="Vertical">Vertical</option>
			<option value="Horizontal">Horizontal</option>
			<option value="Absolute">Absolute</option>
		</select></td>
		
 <td align="left">
<label class="smallAuto autoSpace">Normal</label>
<input type="radio" name="leftMobility" checked="checked" class="radioCheckCol2" id="leftMobility" value="Normal" onchange="displayTextValue(this.value,'MobilityL')"/>
<label class="smallAuto autoSpace">Abnormal</label>
<input type="radio" name="leftMobility" class="radioCheckCol2" id="leftMobility" value="Abnormal" onchange="displayTextValue(this.value,'MobilityL')"/>
<div class="clear"></div>
<div class="clear"></div>
<select tabindex="1" id="leftMobilityValue" name="leftMobilityValue"  validate="Right Surface,string,no"  style="display:none; width:140px; margin-left:0px !important;"> 
			<option value="">Select</option>		
			<option value="Vertical">Vertical</option>
			<option value="Horizontal">Horizontal</option>
			<option value="Absolute">Absolute</option>
		</select>
      </td>		
    </tr>
    
    
  </table>  
  <div class="clear"></div>
    </div>
<div class="clear"></div>
  
 </div>

 <div class="entExaImageRightDiv2">
 
 <div class="clear"></div>
  <label>Laryngeal Framework</label>
  <select name="laryngealFramework" validate="Laryngeal Framework,string,no" value="" class="medium2" id="laryngealFramework" tabindex="1" onchange="displayTextValue(this.value,'Laryngeal');">
  <option value="">Select</option>	 
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal</option>
				</select>
  <input id="laryngealFrameworkValue" type="text" maxlength="100" validate="Laryngeal Framework value,metachar,no" tabindex="1" value="" name="laryngealFrameworkValue" style="display: none" >
 
  <div class="clear"></div>
  <label>Laryngeal Crepitus</label>
  <label class="auto">Absent</label>
<input type="radio" name="laryngealCrepitusAnother" checked="checked" class="radioCheckCol2" id="laryngealCrepitusAnother" value="Absent"/>
<label class="auto">Present</label>
<input type="radio" name="laryngealCrepitusAnother" class="radioCheckCol2" id="laryngealCrepitusAnother" value="Present"/>
<div class="clear"></div>
<label>Thyroid</label>
<textarea id="thyroid"  maxlength="256" tabindex="1" value="" name="thyroid"  ></textarea>
<!-- <input id="thyroid" type="text" maxlength="30" validate="thyroid,metachar,no" tabindex="1" value="" name="thyroid" > -->
<!-- <label>Normal</label>
<input type="radio" name="thyroid" checked="checked" class="radioCheckCol2" id="thyroid" value="Normal"/>
<label>Abnormal</label>
<input type="radio" name="thyroid" class="radioCheckCol2" id="thyroid" value="Abnormal"/> -->
<div class="clear"></div>
<label>Carotid</label>
<textarea id="carotid"  maxlength="256" tabindex="1" value="" name="carotid"  ></textarea>
<!-- <input id="carotid" type="text" maxlength="30" validate="Carotid,metachar,no" tabindex="1" value="" name="carotid" >  -->
<!--    <label>Normal</label>
<input type="radio" name="carotid" checked="checked" class="radioCheckCol2" id="carotid" value="Normal"/>
<label>Abnormal</label>
<input type="radio" name="carotid" class="radioCheckCol2" id="carotid" value="Abnormal"/>  -->
<div class="clear"></div>
<div class="clear"></div>
<label>Internal jugular vein</label>
<textarea id="internalJugularVein"  maxlength="256" tabindex="1" value="" name="internalJugularVein"  ></textarea>
<!--  <input id="internalJugularVein" type="text" maxlength="30" validate="Internal jugular vein,metachar,no" tabindex="1" value="" name="internalJugularVein" >  -->
<!--   <label>Tender</label>
<input type="radio" name="internalJugularVein" class="radioCheckCol2" id="internalJugularVein" value="Tender"/>
<label>Non-tender</label>
<input type="radio" name="internalJugularVein" class="radioCheckCol2" id="internalJugularVein" value="Non-tender"/> --> 
<div class="clear"></div>
<label>Any other swellings </label>
  <!-- <input id="anyOtherSwelling" type="text" maxlength="100" validate="Any other swellings,metachar,no" tabindex="1" value="" name="anyOtherSwelling"  > -->
  <textarea id="anyOtherSwelling"  maxlength="256" tabindex="1" value="" name="anyOtherSwelling"  ></textarea>
  <div class="clear"></div>
<div class="clear"></div>
 <!--  <h4>PICCLE</h4> -->
 <h4>General Examination</h4>
  <label>Pallor</label>
  <label class="auto">Yes</label>
<input type="radio" name="pallor" class="radioCheckCol2" id="pallor" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="pallor" checked="checked" class="radioCheckCol2" id="pallor" value="No"/>
<div class="clear"></div>
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
<input type="radio" name="cyanosis" checked="checked" class="radioCheckCol2" id="cyanosis" value="No"/>
<div class="clear"></div>
<label>Clubbing</label>
  <label class="auto">Yes</label>
<input type="radio" name="clubbing" class="radioCheckCol2" id="clubbing" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="clubbing" checked="checked" class="radioCheckCol2" id="clubbing" value="No"/>
<div class="clear"></div>
<label>Lymphadenopathy</label>
  <label class="auto">Yes</label>
<input type="radio" name="lymphadenopathy" class="radioCheckCol2" id="lymphadenopathy" value="Yes" onchange="displayTextValue(this.value,'Lymphadenopathy');"/>
<label class="auto">No</label>
<input type="radio" name="lymphadenopathy" checked="checked" class="radioCheckCol2" id="lymphadenopathy" value="No" onchange="displayTextValue(this.value,'Lymphadenopathy');"/>

<input id="lymphadenopathyValue" type="text" maxlength="30" style="display: none" validate="Lymphadenopathy,metachar,no" tabindex="1" value="" name="lymphadenopathyValue" >
<div class="clear"></div>
<label>Edema </label>
  <label class="auto">Yes</label>
<input type="radio" name="edema" class="radioCheckCol2" id="edema" value="Yes"/>
<label class="auto">No</label>
<input type="radio" name="edema" checked="checked" class="radioCheckCol2" id="edema" value="No"/>
<div class="clear"></div>
<label>Any Other</label>
<!-- <input id="anyOther" type="text" maxlength="50" validate="Any Other,metachar,no" tabindex="1" value="" name="anyOther"  > -->
<textarea id="anyOther"  maxlength="256" validate="Any Other,metachar,no" tabindex="1" value="" name="anyOther" ></textarea>

</div>
<div class="clear"></div>
</div>
</div>



<style type="text/css">
.tdWidth{width:196px; float:left;}
.entExaImageLeftDiv{width:570px; margin-right:15px; float:left;}
.entExaImageRightDiv{width:580px; float:left;margin:0px;padding:0px;}

.entExaImageLeftDiv2{width:568px; padding-right:15px; float:left; border-right:solid 2px #d5e2e7; min-height:485px;}
.entExaImageRightDiv2{width:555px; padding-left:15px; float:left;}

.annotate-container>[id^=baseLayer] {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 0;
        background: grey;
    }

    .annotate-container>[id^=drawingLayer] {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1;
        background: transparent;
    }
   
   .ann {float:left; margin:5px 50px 15px 0px;}
   
    </style>



