<%@page import="jkt.hms.masters.business.OpdHemoDialysis"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

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

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js?n=1"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js?n=1"></script>

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
	document.getElementById('dialDate').value=serverdate;
	document.getElementById('nextDialysisDate').value=serverdate;
	</script>

<%

Map<String, Object> map = new HashMap<String, Object>();
List <OpdHemoDialysis> hemoDialysisList = new ArrayList<OpdHemoDialysis>();

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

if(map.get("hemoDialysisList") != null)
{
	hemoDialysisList=(List<OpdHemoDialysis>)map.get("hemoDialysisList");
}
int hdNo=0;
if(map.get("hdNo") != null)
{
	hdNo=(Integer)map.get("hdNo");
}

int hinId=0;
if(map.get("hinId") != null)
{
	hinId=(Integer)map.get("hinId");
}

Map<String,Object> utilMap = new HashMap<String, Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");

String currentDateAndTime = currentDate +" "+currentTime;
%>

<form method="post" name="hemoDialysis">
<input id="hemoDialysisFlag" name="hemoDialysisFlag" tabindex="1" value="HemoDialysis" type="hidden"  />
<h6>Hemo Dialysis</h6>
<div class="clear"></div> 
<div class="paddingTop5"></div> 

<label class="medium">Date</label>
<input type="text" name="dialDate"  id="dialDate" value="" tabindex="1" style="width:75px;" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('dialDate'),event);"/>
 
<label class="medium">HD No.</label>
<input type="text" name="hdNo"  id="hdNo" value="<%=hdNo %>" tabindex="1" style="width:75px;" readonly="readonly"/>

<label class="medium">Access</label>
<select name="dialysis_access1" id="dialysis_access1" class="medium2">
			    <option value="" >Select</option>
				<option value="Twice" >Twice</option>
				<option value="Thrice">Thrice</option>
			</select>
	
<label class="smallAuto">Weeks</label>	

<label class="medium">Access</label>
<select name="dialysis_access2" id="dialysis_access2" class="medium2">
			    <option value="" >Select</option>
				<option value="AVF">AVF</option>
				<option value="IJF">IJF</option>
				<option value="Femoral">Femoral</option>
				<option value="Perm Carth">Perm Carth</option>
			</select>
			
<div class="clear"></div> 			
<label class="medium">Pre HD Weight</label>
<input style="width:75px;" type="text" name="preHdWeight"  id="preHdWeight" validate="Pre HD Weight,float,no" value="" tabindex="1" maxlength="5"/>			
<label class="smallAuto">Kg</label>

<label class="auto">Post HD Weight</label>
<input style="width:75px;" type="text" name="postHdWeight"  id="postHdWeight" validate="Post HD Weight,float,no" value="<%=hemoDialysisList.size()>0 && hemoDialysisList.get(0).getPostHdWeight()!=null?hemoDialysisList.get(0).getPostHdWeight().setScale(2):"" %>" tabindex="1" maxlength="5"/>			
<label class="smallAuto">Kg</label>

<label class="medium">Weight Gain</label>
<input style="width:75px;" type="text" name="weightGain"  id="weightGain" value="" tabindex="1" readonly="readonly" validate="Weight Gain,float,no" maxlength="5" onblur="waitGainCalculation()"/>			
<label class="smallAuto">Kg</label>
<div class="clear"></div> 

<h4>Vital Details</h4>
<div class="clear"></div>
<div class="divisionSolid"></div>
<div class="clear"></div>
					
					<label class="auto">Current Date and Time</label>
					<label class="value" style="width:95px"><%=currentDateAndTime %></label>
					<input type="hidden" id="vitalCurrentDateAndTime" name="vitalCurrentDateAndTime" value="<%=currentDateAndTime%>"/>
					
					<label class="width45" id="bpLabel">BP</label> 
					<input name="vitalSystolic" id="vitalSystolic" tabindex="14" placeholder="Systolic" value="" validate="systolic,int,no" type="text" maxlength="3" class="textYellow allownumericwithoutdecimal textSmall" /> 
					<label id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
					<input name="vitalDiastolic" id="vitalDiastolic" tabindex="16" placeholder="Diastolic" value="" validate="diastolic,int,no" type="text" maxlength="3"
						class="textYellow allownumericwithoutdecimal textSmall"  /></span> <label
						class="smallAuto">mm&nbsp;Hg</label>
					<label class="width45">Pulse</label>
					<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="13" name="vitalPulse" type="text" id="vitalPulse" validate="pulse,num,no" maxlength="3" value="" />
					<label class="smallAuto">min</label> 
					<label class="width75">Temperature</label>
					<input class="textYellow allownumericwithdecimal textSmall" name="vitalTemperature" id="vitalTemperature" type="text" maxlength="6" validate="temperature,float,no" value="" tabindex="14" />
					<label class="smallAuto">&deg;F</label> 
					
					<input type="button" class="buttonBig" id="vital_details" name="vital_details" value="Vital Details" onclick="vitalDetails('<%=hinId %>');" />
	
<div class="clear"></div>
<div class="divisionSolid"></div>
<div class="clear"></div>

<label class="medium">Heparin Dose</label>
<select name="heparinDose" id="heparinDose" class="medium2">
			    <option value="" >Select</option>
				<option value="Regular" >Regular</option>
				<option value="Rigid">Rigid</option>
				<option value="Free">Free</option>
			</select>

<label class="auto">Blood Flow Rate</label>
<input type="text" name="bloodFlowRate"  id="bloodFlowRate" value="" tabindex="1" validate="diastolic,int,no" class="medium" maxlength="3"/>			
<label class="smallAuto">ml/min</label>

<label class="auto">Dialysate Flow Rate</label>
<input type="text" name="dialysateFlowRate"  id="dialysateFlowRate" value="" validate="diastolic,int,no" tabindex="1" class="medium" maxlength="3"/>			
<label class="smallAuto">ml/min</label>

<div class="clear"></div>
<h4>Adequecy</h4>
<div class="clear"></div>

<label class="medium">KT/V</label>
<input type="text" name="ktV"  id="ktV" value="" tabindex="1" validate="diastolic,int,no" class="medium" maxlength="3"/>			

<label class="medium">URR</label>
<input type="text" name="urr"  id="urr" value="" tabindex="1" validate="diastolic,int,no" class="medium" maxlength="3"/>			
<label class="smallAuto">%</label>

<label class="medium">UF</label>
<input type="text" name="uf"  id="uf" value="" tabindex="1" validate="diastolic,int,no" class="medium" maxlength="3"/>
<div class="clear"></div>

<h4>Appointment for next Dialysis</h4>
<div class="clear"></div>

<label class="medium">Date</label>
<input type="text" name="nextDialysisDate"  id="nextDialysisDate" value="" tabindex="1" style="width:75px;" readonly="readonly"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('nextDialysisDate'),event);"/>

<label class="medium">Time</label>
<input type="text" name="nextDialysisTime"  id="nextDialysisTime" placeholder="hh:mm" maxlength="5" value="" tabindex="1" style="width:75px;"/>

<label>Events / Complications</label>
<textarea rows="" cols="" id="events_complications" name="events_complications" maxlength="250" class="textareaMediua historyAutoComplete"> </textarea>


<!-- <input name="Save" type="button" class="button" value="Save" />
<input name="Cancel" type="button" class="button" value="Cancel" /> -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<input type="button" class="buttonBig" id="previousDetails" name="previousDetails" value="Previous Details" onclick="patientDetailsHemoDialysis('<%=hinId %>');" />

</form>

