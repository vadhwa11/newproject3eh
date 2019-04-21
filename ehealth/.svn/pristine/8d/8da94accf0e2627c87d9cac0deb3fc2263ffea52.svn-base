<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdMedicineSpecialityTemplate"%>
<%@page import="jkt.hms.masters.business.OpdMedicineCardiovascularSystem"%>
<%@page import="jkt.hms.masters.business.OpdMedicineArterialBloodPressure"%>

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

	//Added By Babita on 31-10-2017
	Map<String,Object> map = new HashMap<String,Object>();
	OpdMedicineSpecialityTemplate opdMedicineTemplate = null;
	List<OpdMedicineCardiovascularSystem> opdMedicineCardioSysList = null;
	List<OpdMedicineArterialBloodPressure> opdMedicineABPList = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	 if(map.get("opdMedicineTemplate") != null){
		 opdMedicineTemplate =(OpdMedicineSpecialityTemplate)map.get("opdMedicineTemplate");
	 }
	 
	 if(map.get("opdMedicineCardioSysList") != null){
		 opdMedicineCardioSysList =(List<OpdMedicineCardiovascularSystem>)map.get("opdMedicineCardioSysList");
	 }
	 
	 if(map.get("opdMedicineABPList") != null){
		 opdMedicineABPList =(List<OpdMedicineArterialBloodPressure>)map.get("opdMedicineABPList");
	 }

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<style type="text/css">
		circle, rect, path {
			stroke: black;
			stroke-width: 2px;
			fill: none;
		}
	</style>
<form method="post" action="" name="medicineTemplate" >

<div class="Block">
<input id="medicineFlag" name="medicineFlag" tabindex="1" value="GeneralMedicine" type="hidden"  />
<input type="hidden" name="templateName" value="General Medicine"/>
<div class="clear"></div>
<h6 style="float:left;">General Medicine</h6>
<div class="clear"></div>

<!-- family tree -->
<div id="familyTree" style="margin-top: -259px;margin-left: -109px;"></div>
<script type="text/javascript">
var width = 1400, 
	height = 600,
	personSize = 20;
	person1="";
;
var svg = d3.select("#familyTree").append("svg")
	.attr("width", width)
	.attr("height", height)
  .append("g");
svg.append('text').text('This is some information about whatever');
svg.selectAll("circle")
	.data(people.filter(function(person, index, people) {  return person.Gender === "F"; }))
  .enter().append("circle")
	.attr("cx", function(d) { return circX(d); })
	.attr("cy", function(d) { return circY(d); })
	  
	  
	 
	  .attr("title", function (d) { return "yellow"; })
	  .style("fill", "red")
	  
	.attr("r", function (d) { return findCircleSize(d); })
	.attr("class", function(d) { return d.Medical; })
 .append("title")
          .text(function(d) {  return displayNodeInfo(d);});
	;

svg.selectAll("rect")
	.data(people.filter(function(person, index, people) { return person.Gender === "M"; }))
  .enter().append("svg:rect")
	.attr("x", function(d) { return rectX(d); })
	.attr("y", function(d) { return rectY(d); })
	.attr("width", function (d) { return findRectangleSize(d); })
	.attr("height", function (d) { return findRectangleSize(d); })
		  .style("fill", "white")
	 .append("title")
          .text(function(d) {  return displayNodeInfo(d);});
	
  
svg.append("g").selectAll("path")
	.data(parents)
  .enter().append("path")
	.attr("d", function(r) {
		var fromNode = findPersonById(r.B);
		return "M" + fromNode.XPosition + "," + (fromNode.YPosition - (personSize / 2)) + " L" + fromNode.XPosition + "," + (fromNode.YPosition - ((personSize * 2) + (personSize / 2)));
	});
	

svg.append("g").selectAll("path")
	.data(peers)
  .enter().append("path")
	.attr("d", function(r) {
		var fromNode = findPersonById(r.A);
		var toNode = findPersonById(r.B);
		var verticalTravel = findVerticalTravel(fromNode, toNode);
		return "M" + fromNode.XPosition + "," + ((personSize / 2) + (1 * fromNode.YPosition))
			+ " v" + (verticalTravel) 
			+ " H" + toNode.XPosition
			+ " v" + (-(verticalTravel));
	});
	
function findPersonById(id) {
	return people.filter(function(person, index, people) { return person.Id === id; })[0];
}

function rectX(person) {
	return person.XPosition - (personSize / 2);
}

function rectY(person) {
	return person.YPosition - (personSize / 2);
}

function circX(person) {
	return person.XPosition;
}

function circY(person) {
	return person.YPosition;
}

function findCircleSize(person) {
    return findIconSize(((personSize / 2) + 1), person);
}

function findRectangleSize(person) {
    return findIconSize(personSize, person);
}
function displayNodeInfo(person) {
  //art(person.XPosition);
  
     return "Name:"+person.Name +"\n"+"Gender:"+person.XPosition;
}
/*$('svg circle').tipsy({

        gravity: 'w', 
        html: true, 
        title: function() {
         var d = person1; //c = colors(d.i);
          return "Name:<r/>"+d.XPosition+"Gender:";
        }
      });*/

function findIconSize(startingSize, person) {
    var size = startingSize;
    for (var i = 2; i < person.DistanceToPrimaryLineage; i++) {
        size = size * 0.8;
    }
    return size;
}

function findVerticalTravel(fromNode, toNode) {
    var decreaser = 0;
    if (fromNode.DistanceToPrimaryLineage > 2 || toNode.DistanceToPrimaryLineage > 2) {
        decreaser = personSize;
    }
    return (personSize * 2) - decreaser;
}

</script>
<!-- end family tree -->
<div class="clear"></div>
<h4 class="h4style">Cardiovascular System</h4>
<div class="clear"></div>
<h4 style="float:left; width:500px;">Examination of Arterial Pulse</h4>
<div class="floatRight">
<input type="button" class="buttonAdd"  tabindex="1"	value="&nbsp;" onclick="addRowForCardiovascularSystem();" />
<input type="button" class="buttonDel" tabindex="1"  value="&nbsp;" onclick="removeRowForCardiovascularSystem();" />
</div>
<div class="clear"></div>
<div class="tableForTab" style="width:1159px; max-height:194px; min-height:107px;"> 
<table border="0"  cellpadding="0" cellspacing="0"	id="cardiovascularSystemGrid">
<tr> 
<th></th>
<th>Site</th>
<th>Rate</th>
<th>Rhythm</th>
<th>Volume</th>
<th>Character</th>
<th>Condition of the vessel wall</th>
<th>Radio femoral delay</th>
<th>Palpation of peripheral vessel</th>

</tr> 
<%int ii = 1; %>
<%if(opdMedicineCardioSysList!=null && opdMedicineCardioSysList.size()>0){ 
  for(OpdMedicineCardiovascularSystem opmcvs:opdMedicineCardioSysList){
%>
<tr>
<td>
<input type="hidden" name="opdMedicineCardioSysId<%=ii%>" value=<%=opmcvs.getId()%>>
<input type="checkbox" name="srNo<%=ii %>" id="srNo<%=ii %>" disabled="disabled" value="1" class="radioCheck" /></td>
<td><select name="site<%=ii %>" id="site<%=ii %>">
<option value="">Select</option>	
<option value="Radial" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Radial")?"selected":"":""%> >Radial</option>
<option value="Brachial" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Brachial")?"selected":"":""%>>Brachial</option>
<option value="Carotid" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Carotid")?"selected":"":""%>>Carotid</option>
<option value="Femoral" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Femoral")?"selected":"":""%>>Femoral</option>
<option value="Popliteal" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Popliteal")?"selected":"":""%>>Popliteal</option>
<option value="Abdominal Aorta" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Abdominal Aorta")?"selected":"":""%>>Abdominal Aorta</option>
<option value="DP and TP arteries of foot" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("DP and TP arteries of foot")?"selected":"":""%>>DP and TP arteries of foot</option>
<option value="Other" <%=opmcvs.getSite()!=null?opmcvs.getSite().equals("Other")?"selected":"":""%>>Other</option>

</select></td>
<td>
<div style="width:107px; float: left;">
<input  type="text" style="width:36px" value ="<%=opmcvs.getRate()!=null?opmcvs.getRate():""%>" name="rate<%=ii %>" id="rate<%=ii %>" onkeypress="javascript:return isNumber(event)" maxlength="3" />
<label class="smallAuto" style="margin:-3px 0px 0px 0px;">beats/min</label>
</div>
</td>
<td><select name="rhythm<%=ii %>" id="rhythm<%=ii %>">
<option value="">Select</option>	
<option value="Regular" <%=opmcvs.getRhythm()!=null?opmcvs.getRhythm().equals("Regular")?"selected":"":""%>>Regular</option>
<option value="Regularly Irregular" <%=opmcvs.getRhythm()!=null?opmcvs.getRhythm().equals("Regularly Irregular")?"selected":"":""%>>Regularly Irregular</option>
<option value="Irregularly Irregular" <%=opmcvs.getRhythm()!=null?opmcvs.getRhythm().equals("Irregularly Irregular")?"selected":"":""%>>Irregularly Irregular</option>
</select>
</td>
<td><select name="volume<%=ii %>" id="volume<%=ii %>">
<option value="">Select</option>	
<option value="Normal" <%=opmcvs.getVolume()!=null?opmcvs.getVolume().equals("Normal")?"selected":"":""%>>Normal</option>
<option value="Low" <%=opmcvs.getVolume()!=null?opmcvs.getVolume().equals("Low")?"selected":"":""%>>Low</option>
<option value="High" <%=opmcvs.getVolume()!=null?opmcvs.getVolume().equals("High")?"selected":"":""%>>High</option>
</select>
</td>
<td><select name="csCharacter<%=ii %>"  id="csCharacter<%=ii %>">
<option value="">Select</option>	
<option value="Normal" <%=opmcvs.getCsCharacter()!=null?opmcvs.getCsCharacter().equals("Normal")?"selected":"":""%>>Normal</option>
<option value="Anacrotic" <%=opmcvs.getCsCharacter()!=null?opmcvs.getCsCharacter().equals("Anacrotic")?"selected":"":""%>>Anacrotic</option>
<option value="Dicrotic" <%=opmcvs.getCsCharacter()!=null?opmcvs.getCsCharacter().equals("Dicrotic")?"selected":"":""%>>Dicrotic</option>
<option value="Bisferiens" <%=opmcvs.getCsCharacter()!=null?opmcvs.getCsCharacter().equals("Bisferiens")?"selected":"":""%>>Bisferiens</option>
<option value="Collapsing" <%=opmcvs.getCsCharacter()!=null?opmcvs.getCsCharacter().equals("Collapsing")?"selected":"":""%>>Collapsing</option>
</select>
</td>
<td><select name="conditionOfTheVesselWell<%=ii %>" id="conditionOfTheVesselWell<%=ii %>"> 
<option value="">Select</option>	
<option value="Normal" <%=opmcvs.getConditionOfTheVesselWell()!=null?opmcvs.getConditionOfTheVesselWell().equals("Normal")?"selected":"":""%>>Normal</option>
<option value="Thickened" <%=opmcvs.getConditionOfTheVesselWell()!=null?opmcvs.getConditionOfTheVesselWell().equals("Thickened")?"selected":"":""%>>Thickened</option>
</select>
</td>
<td><select name="radioFemoralDelay<%=ii %>" id="radioFemoralDelay<%=ii %>">
<option value="">Select</option>	
<option value="Present" <%=opmcvs.getRadioFemoralDelay()!=null?opmcvs.getRadioFemoralDelay().equals("Present")?"selected":"":""%>>Present</option>
<option value="Absent" <%=opmcvs.getRadioFemoralDelay()!=null?opmcvs.getRadioFemoralDelay().equals("Absent")?"selected":"":""%>>Absent</option>
</select>
</td>
<td><select name="palpitationOfPeripheralVessel<%=ii%>" id="palpitationOfPeripheralVessel<%=ii%>">
<option value="">Select</option>	
<option value="0/Absent" <%=opmcvs.getPalpitationOfPeripheralVessel() !=null?opmcvs.getPalpitationOfPeripheralVessel().equals("0/Absent")?"selected":"":""%>>0/Absent</option>
<option value="+/Feeble" <%=opmcvs.getPalpitationOfPeripheralVessel()!=null?opmcvs.getPalpitationOfPeripheralVessel().equals("+/Feeble")?"selected":"":""%>>+/Feeble</option>
<option value="++/Normal" <%=opmcvs.getPalpitationOfPeripheralVessel()!=null?opmcvs.getPalpitationOfPeripheralVessel().equals("++/Normal")?"selected":"":""%>>++/Normal</option>
<option value="+++/Bounding" <%=opmcvs.getPalpitationOfPeripheralVessel()!=null?opmcvs.getPalpitationOfPeripheralVessel().equals("+++/Bounding")?"selected":"":""%>>+++/Bounding</option>
</select>
</td>
<%ii++;}}else{%>
<tr>
<td><input type="checkbox" name="srNo<%=ii %>" id="srNo<%=ii %>" value="1" class="radioCheck" /></td>
<td><select name="site<%=ii %>" id="site<%=ii %>">
<option value="">Select</option>	
<option value="Radial">Radial</option>
<option value="Brachial">Brachial</option>
<option value="Carotid">Carotid</option>
<option value="Femoral">Femoral</option>
<option value="Popliteal">Popliteal</option>
<option value="Abdominal Aorta">Abdominal Aorta</option>
<option value="DP and TP arteries of foot">DP and TP arteries of foot</option>
<option value="Other">Other</option>

</select></td>
<td>
<div style="width:107px; float: left;">
<input  type="text" style="width:36px"  name="rate<%=ii %>" id="rate<%=ii %>" onkeypress="javascript:return isNumber(event)" maxlength="3" />
<label class="smallAuto" style="margin:-3px 0px 0px 0px;">beats/min</label>
</div>
</td>
<td><select name="rhythm<%=ii %>" id="rhythm<%=ii %>">
<option value="">Select</option>	
<option value="Regular">Regular</option>
<option value="Regularly Irregular">Regularly Irregular</option>
<option value="Irregularly Irregular">Irregularly Irregular</option>
</select>
</td>
<td><select name="volume<%=ii %>" id="volume<%=ii %>">
<option value="">Select</option>	
<option value="Normal">Normal</option>
<option value="Low">Low</option>
<option value="High">High</option>
</select>
</td>
<td><select name="csCharacter<%=ii %>"  id="csCharacter<%=ii %>">
<option value="">Select</option>	
<option value="Normal">Normal</option>
<option value="Anacrotic">Anacrotic</option>
<option value="Dicrotic">Dicrotic</option>
<option value="Bisferiens">Bisferiens</option>
<option value="Collapsing">Collapsing</option>
</select>
</td>

<td><select name="conditionOfTheVesselWell<%=ii %>" id="conditionOfTheVesselWell<%=ii %>"> 
<option value="">Select</option>	
<option value="Normal">Normal</option>
<option value="Thickened">Thickened</option>
</select>
</td>
<td><select name="radioFemoralDelay<%=ii %>" id="radioFemoralDelay<%=ii %>">
<option value="">Select</option>	
<option value="Present">Present</option>
<option value="Absent">Absent</option>
</select>
</td>

<td><select name="palpitationOfPeripheralVessel<%=ii %>" id="palpitationOfPeripheralVessel<%=ii %>">
<option value="">Select</option>	
<option value="0/Absent">0/Absent</option>
<option value="+/Feeble">+/Feeble</option>
<option value="++/Normal">++/Normal</option>
<option value="+++/Bounding">+++/Bounding</option>
</select>
</td>
</tr>
<%} %>
</table>
</div>
<input type="hidden" name="cardiovascularSystemCount" id="cardiovascularSystemCount" value="<%=ii%>" />
<div class="clear"></div>
<div class="paddingTop5"></div>

<h4 style="float:left; width:526px;">Arterial Blood Pressure (BP)</h4>


<div style="float:left;">
<input type="button" class="buttonAdd"  tabindex="1"	value="&nbsp;" onclick="addRowForArterialBloodPressure();" />
<input type="button" class="buttonDel" tabindex="1"  value="&nbsp;" onclick="removeRowForArterialBloodPressure();" />
</div>

<div class="clear"></div>
<div class="tableForTab" style="width:650px; max-height:194px; min-height:107px;">
<table border="0"  cellpadding="0" cellspacing="0"	id="arterialBloodPressureGrid">
<tr> 
<th></th>
<th>Position</th>
<th>Systolic</th>
<th>Diastolic</th>
</tr> 
<%int i = 1; %>
<%

if(opdMedicineABPList!=null && opdMedicineABPList.size()>0){ 
  for(OpdMedicineArterialBloodPressure opABP:opdMedicineABPList){
%>
<tr>
<td>
<input type="hidden" name="opdMedicineABPId<%=i%>" value=<%=opABP.getId()%>>
<input type="checkbox" name="srNoo<%=i%>" id="srNoo" value="1" disabled="disabled" class="radioCheck" /></td>
<td><select name="abpPosition<%=i%>" id="abpPosition<%=i%>" onchange ="toggleOtherTextbox(this.value,'otherPosition<%=i%>',10, 'otherPositionSpan<%=i%>')">
<option value="">Select</option>	
<option value="RT UL Sitting" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("RT UL Sitting")?"selected":"":""%>>RT UL Sitting</option>
<option value="RT UL Supine" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("RT UL Supine")?"selected":"":""%>>RT UL Supine</option>
<option value="LT UL Sitting" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("LT UL Sitting")?"selected":"":""%>>LT UL Sitting</option>
<option value="LT UL Supine" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("LT UL Supine")?"selected":"":""%>>LT UL Supine</option>
<option value="RT LL" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("RT LL")?"selected":"":""%>>RT LL</option>
<option value="LT LL" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("LT LL")?"selected":"":""%>>LT LL</option>
<option value="Ankle Brachial Index" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("Ankle Brachial Index")?"selected":"":""%>>Ankle Brachial Index</option>
<option value="Others" <%=opABP.getAbpPosition()!=null?opABP.getAbpPosition().equals("Others")?"selected":"":""%>>Others</option>

</select>
<span id="otherPositionSpan<%=i%>">
<%if(opABP.getAbpPosition()!=null && opABP.getAbpPosition().equalsIgnoreCase("Others")){%>
<input name="otherPosition<%=i%>" value="<%=opABP.getAbpPositionOther()%>" maxlength="10" type="text"></span>
<%} %>
</td>
<td><input  type="text" value="<%=opABP.getSystolic()!=null?opABP.getSystolic():""%>" name="systolic<%=i%>" id="systolic<%=i%>" class="textSmall"  maxlength="3" onkeypress="javascript:return isNumber(event)"/>
<label class="smallAuto autoSpace">mm Hg</label></td>

<td><input  type="text"  name="diastolic<%=i%>" id="diastolic<%=i%>" value="<%=opABP.getDiastolic()!=null?opABP.getDiastolic():""%>"  class="textSmall" maxlength="3" onkeypress="javascript:return isNumber(event)"/>
<label class="smallAuto autoSpace">mm Hg</label></td>
</tr>
<%i++;}}else{ System.out.println("gsg");%>
<tr>
<td>
<input type="checkbox" name="srNoo<%=i%>" id="srNoo" value="1" class="radioCheck" /></td>
<td><select name="abpPosition<%=i%>" id="abpPosition<%=i%>" onchange ="toggleOtherTextbox(this.value,'otherPosition<%=i%>',10, 'otherPositionSpan<%=i%>')">
<option value="">Select</option>	
<option value="RT UL Sitting">RT UL Sitting</option>
<option value="RT UL Supine">RT UL Supine</option>
<option value="LT UL Sitting">LT UL Sitting</option>
<option value="LT UL Supine">LT UL Supine</option>
<option value="RT LL">RT LL</option>
<option value="LT LL">LT LL</option>
<option value="Ankle Brachial Index">Ankle Brachial Index</option>
<option value="Others">Others</option>

</select>
<span id="otherPositionSpan<%=i%>"></span>
</td>
<td><input  type="text"  name="systolic<%=i%>" id="systolic<%=i%>" class="textSmall"  maxlength="3" onkeypress="javascript:return isNumber(event)"/>
<label class="smallAuto autoSpace">mm Hg</label></td>

<td><input  type="text"  name="diastolic<%=i%>" id="diastolic<%=i%>" class="textSmall" maxlength="3" onkeypress="javascript:return isNumber(event)"/>
<label class="smallAuto autoSpace">mm Hg</label></td>
</tr>
<%} %>
</table>
</div>
<input type="hidden" name="arterialBloodPressureCount" id="arterialBloodPressureCount" value="<%=i%>" />
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Pulsus Paradoxus</label>
<select  name="pulsusParadoxus" onchange="getPulsusParadoxus(this.value);" class="medium2">
<option value="">Select</option>
<option value="Present" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusParadoxus().equals("Present")?"selected":"":""%>>Present</option>
<option value="Absent" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusParadoxus().equals("Absent")?"selected":"":""%>>Absent</option>
</select>
<div id="pulsusParadoxusDiv" style="display: <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusParadoxus().equals("Present")?"block":"":"none"%>">
<!-- <label>BP</label> -->
<input  type="text"  name="systolicPulsusParadoxus" id="systolicPulsusParadoxus" placeholder="Systolic / Diastolic" maxlength="10" value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusParadoxusSystolic():""%>" class="auto" />
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<%-- <input  type="text"  name="diastolicPulsusParadoxus" id="diastolicPulsusParadoxus" class="textSmall" maxlength="3" value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusParadoxusDiastolic():""%>" placeholder="Diastolic" onkeypress="javascript:return isNumber(event)"/> --%>
<label class="smallAuto autoSpace">mm Hg</label>
</div>

<label>Pulsus Alternans</label>
<select  name="pulsusAlternans" onchange="getPulsusAlternans(this.value);" class="medium2">
<option value="">Select</option>
<option value="Present" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusAlternans().equals("Present")?"selected":"block":"none"%>>Present</option>
<option value="Absent" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusAlternans().equals("Absent")?"selected":"block":"none"%>>Absent</option>
</select>
<div id="pulsusAlternansDiv" style="display: <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusAlternans().equals("Present")?"selected":"block":"none"%>">
<!-- <label>BP</label> -->
<input  type="text"  name="systolicPulsusAlternans" id="systolicPulsusAlternans" placeholder="Systolic / Diastolic" value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusAlternansSystolic():""%>" maxlength="10" class="auto"  />
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<%-- <input  type="text"  name="diastolicPulsusAlternans" id="diastolicPulsusAlternans" placeholder="Diastolic" maxlength="3" class="textSmall"  value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getPulsusAlternansDiastolic():""%>" onkeypress="javascript:return isNumber(event)"/> --%>
<label class="smallAuto autoSpace">mm Hg</label>
</div>
<h4>Examination of Jugular Venous Pulse</h4>
<label>Level of Venous Pressure</label>
<input  type="text"  name="levelOfVenousPressure" value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getLevelOfVenousPressure():""%>"  id="levelOfVenousPressure" class="textSmall" maxlength="5" onkeypress="javascript:return isNumber(event)"/>
<label class="smallAuto autoSpace">cm from the angle of Louis</label>

<!-- <label>A Wave</label>
<input type="checkbox" name="aWave" id="aWave" value="y" style="margin-right:20px;"/>
<label>V Wave</label>
<input  type="checkbox"  name="vWave" id="vWave" value="y" />   -->
<%

String xWave = "";
String yWave = "";
String cWave = "";
String vWave = "";
String aWave = "";
String xWaveRem = null;
String yWaveRem = null;
String vWaveRem = null;
String cWaveRem = null;
String aWaveRem = null;

String [] wavesRemarks =null;
String [] wavesSubRemarks =null;
if(opdMedicineTemplate!=null && opdMedicineTemplate.getWavesV()!=null)
	wavesRemarks =opdMedicineTemplate.getWavesV().split("#");

	String waveStr = 	opdMedicineTemplate!=null?opdMedicineTemplate.getWaves():"";
	
if(wavesRemarks!=null){
	for(int j=0;j<wavesRemarks.length;j++)
	{
		wavesSubRemarks = wavesRemarks[j].split("@");
		System.out.println("here="+wavesSubRemarks +" wavesRemarks="+wavesRemarks.length);
		if(wavesSubRemarks[1].equals("x"))
			xWaveRem = wavesSubRemarks[0];
		else if(wavesSubRemarks[1].equals("y"))
			yWaveRem = wavesSubRemarks[0];
		else if(wavesSubRemarks[1].equals("v"))
			vWaveRem = wavesSubRemarks[0];
		else if(wavesSubRemarks[1].equals("c"))
			cWaveRem = wavesSubRemarks[0];
		else if(wavesSubRemarks[1].equals("a"))
			aWaveRem = wavesSubRemarks[0];
	
	}}

/* System.out.println(opdMedicineTemplate.getWavesV());
System.out.println(wavesRemarks);
System.out.println(wavesRemarks[0]);
System.out.println(wavesRemarks[1]);
System.out.println(wavesRemarks[2]); */

/* if(opdMedicineTemplate!=null && waveStr!=null && waveStr.contains("X Wave"))
{
	xWave = "y";
	xWaveRem = wavesRemarks[0];
	
}
if(opdMedicineTemplate!=null && waveStr!=null && waveStr.contains("Y Wave"))
{
	yWave = "y";
	yWaveRem = xWave.equals("y")? wavesRemarks[1]:wavesRemarks[0];
}
if(opdMedicineTemplate!=null && waveStr!=null && waveStr.contains("C Wave"))
{

	cWave = "y";
	cWaveRem = xWave.equals("y") && yWave.equals("y")?wavesRemarks[2]:xWave.equals("y") || yWave.equals("y")?wavesRemarks[1]:wavesRemarks[0];

}
if(opdMedicineTemplate!=null && waveStr!=null && waveStr.contains("V Wave"))
{
	vWave = "y";
	aWaveRem = xWave.equals("y") && yWave.equals("y") && cWave.equals("y")?wavesRemarks[3]:xWave.equals("y") || yWave.equals("y")?wavesRemarks[1]:wavesRemarks[0];
}
if(opdMedicineTemplate!=null && waveStr!=null && waveStr.contains("A Wave"))
{
	vWave = "y";
	aWaveRem = xWave.equals("y") && yWave.equals("y")?wavesRemarks[2]:xWave.equals("y") || yWave.equals("y")?wavesRemarks[1]:wavesRemarks[0];
} */

xWave = opdMedicineTemplate!=null?waveStr!=null?waveStr.contains("X Wave")?"y":"":"":"";
yWave = opdMedicineTemplate!=null?waveStr!=null?waveStr.contains("Y Wave")?"y":"":"":"";
cWave = opdMedicineTemplate!=null?waveStr!=null?waveStr.contains("C Wave")?"y":"":"":"";
vWave = opdMedicineTemplate!=null?waveStr!=null?waveStr.contains("V Wave")?"y":"":"":"";
aWave = opdMedicineTemplate!=null?waveStr!=null?waveStr.contains("A Wave")?"y":"":"":"";

%>
	<label>Waves</label>
        <select id="wave" name="wave" multiple>
            <option <%=xWave.equals("y")?"selected":""%>>X Wave</option>
            <option <%=yWave.equals("y")?"selected":""%>>Y Wave</option>
            <option <%=cWave.equals("y")?"selected":""%>>C Wave</option>
               <option <%=vWave.equals("y")?"selected":""%>>V Wave</option>
                  <option <%=aWave.equals("y")?"selected":""%>>A Wave</option>
        </select>
        <input type="hidden" name="multiDropDownValue" value="" id="multiDropDownValue" value="">
<div class="clear"></div>
<div id="waveTextBoxDiv">

  <label id="Xwave_lebel" style="display:<%=xWave.equals("y")?"block":"none"%>">X Wave:</label>  <input  validate="X Wave,metachar,no" style="display:<%=xWave.equals("y")?"block":"none"%>"type="text" name="Xwave_remarks" value="<%=xWaveRem!=null?xWaveRem:"" %>" id="Xwave_remarks" maxlength="28" onkeypress="return alphanumericOnly(event)"><div class="clear"></div>
  <label id="Ywave_lebel" style="display:<%=yWave.equals("y")?"block":"none"%>">Y Wave:</label>  <input  validate="Y Wave,metachar,no" style="display:<%=yWave.equals("y")?"block":"none"%>"type="text" name="Ywave_remarks" value="<%=yWaveRem!=null?yWaveRem:""%>" id="Ywave_remarks" maxlength="28" onkeypress="return alphanumericOnly(event)"><div class="clear"></div>
  <label id="Cwave_lebel" style="display:<%=cWave.equals("y")?"block":"none"%>">C Wave:</label>  <input  validate="C Wave,metachar,no" style="display:<%=cWave.equals("y")?"block":"none"%>"type="text" name="Cwave_remarks" value="<%=cWaveRem!=null?cWaveRem:""%>" id="Cwave_remarks" maxlength="28" onkeypress="return alphanumericOnly(event)"><div class="clear"></div>
  <label id="Vwave_lebel" style="display:<%=vWave.equals("y")?"block":"none"%>">V Wave:</label>  <input  validate="V Wave,metachar,no" style="display:<%=vWave.equals("y")?"block":"none"%>"type="text" name="Vwave_remarks" value="<%=vWaveRem!=null?vWaveRem:""%>" id="Vwave_remarks" maxlength="28" onkeypress="return alphanumericOnly(event)"><div class="clear"></div>
  <label id="Awave_lebel" style="display:<%=aWave.equals("y")?"block":"none"%>">A Wave:</label>  <input  validate="A Wave,metachar,no" style="display:<%=aWave.equals("y")?"block":"none"%>"type="text" name="Awave_remarks" value="<%=aWaveRem!=null?aWaveRem:"" %>" id="Awave_remarks" maxlength="28" onkeypress="return alphanumericOnly(event)">
</div>

<div class="clear"></div>
<label>Hepatojugular Reflex</label>
<select  name="hepatojugularReflex" id="hepatojugularReflex">
<option value="">Select</option>
<option value="Present" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getHepatojugularReflex().equals("Present")?"selected":"":""%>>Present</option>
<option value="Absent" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getHepatojugularReflex().equals("Absent")?"selected":"":""%>>Absent</option>
</select>

<h4>Vital</h4>
<label style="width:50px;">Pulse</label>
<input class="textYellow allownumericwithoutdecimal textSmall" tabindex="11" name="" type="text" id="" validate="pulse,num,no" maxlength="3" value="" onblur="setVitalValue(this.value,'pulse')" />
<label class="smallAuto">min</label>
<label class="auto">Temperature</label>
<input class="textYellow allownumericwithdecimal textSmall"	name= "temperatureTemp" id="temperatureTemp" type="text" maxlength="6" tabindex="12" onblur="setVitalValue(this.value,'temperature')"/>
<label class="smallAuto">&deg;F</label> 
<label style="width:50px;" id="bpLabel">BP</label>
<input name="systolicTemp" id="systolicTemp" tabindex="14" placeholder="Systolic" validate="systolic,int,no" type="text" maxlength="3" 
class="textYellow allownumericwithoutdecimal textSmall" onblur="setVitalValue(this.value,'systolic')"/>
<label id="bpLabel" class="smallAuto"><span style="color: black">/</span></label>
<input name="diastolicTemp" id="diastolicTemp" tabindex="15" placeholder="Diastolic" type="text" maxlength="3"
class="textYellow allownumericwithoutdecimal textSmall" onblur="setVitalValue(this.value,'diastolic')" />
<label class="smallAuto">mm&nbsp;Hg</label>

<label class="auto">Respiratory Rate</label>
<input class="textYellow allownumericwithdecimal textSmall" name="respiratoryRateTemp" id="respiratoryRateTemp" type="text" maxlength="3" validate="Respiratory Rate,float,no"  tabindex="12" onblur="setVitalValue(this.value,'respiratoryRate')" />		
<label style="width:50px;">Sp2</label>
<input class="textYellow allownumericwithdecimal textSmall" name="spo2Temp" id="spo2Temp" type="text" maxlength="3" validate="spo2,float,no" tabindex="12" onblur="if(maxDigitAllowed(this, '100')){setVitalValue(this.value,'spo2');}" onkeypress="return isNumberOnly(event)"/>
<div class="clear"></div>						

<h4>General Examination</h4>
<div class="clear"></div>
 <label>Pallor</label>
	<select  name="pallor"class="smaller" onchange ="toggleOtherTextbox(this.value,'pallor_remarks',28, 'pallor_span')">
		<option value="">Select</option>
		<option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPallor().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getPallor().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="pallor_span">
	<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getPallorRemarks().equals("y")){%>
	<input type="text" maxlength="28" name="pallor_remarks" value="<%=opdMedicineTemplate!=null?opdMedicineTemplate.getPallorRemarks():""%>"><%} %>
	</span>
    <label>Jaundice</label>
	<select class="smaller"  name="jaundice" onchange ="toggleOtherTextbox(this.value,'jaundice_remarks',28, 'jaundice_span')">
		<option value="">Select</option>
		<option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getJaundice().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getJaundice().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="jaundice_span">
		<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getJaundice().equals("y")){%>
	<input type="text" name="jaundice_remarks" maxlength="28" value="<%=opdMedicineTemplate.getJaundiceRemarks()%>"><%} %>
	</span>
	<div class="clear"></div>
    <label>Cyanosis</label>
	<select  class="smaller" name="cyanosis" onchange ="toggleOtherTextbox(this.value,'cyanosis_remarks',28, 'cyanosis_span')">
		<option value="">Select</option>
			<option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getCyanosis().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getCyanosis().equals("n")?"selected":"":""%>>No</option>
	</select> 
	<span id="cyanosis_span">
		<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getCyanosis().equals("y")){%>
	<input type="text" name="cyanosis_remarks" maxlength="28" value="<%=opdMedicineTemplate.getCyanosisRemarks()%>">
	<%} %>
	</span>
	
    <label>Clubbing</label>
	<select class="smaller"  name="clubbing" onchange ="toggleOtherTextbox(this.value,'clubbing_remarks',28, 'clubbing_span')">
		<option value="">Select</option>
		<option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getClubbing().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getClubbing().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="clubbing_span">
		<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getClubbing().equals("y")){%>
	<input type="text" name="clubbing_span" maxlength="28"  value="<%=opdMedicineTemplate.getClubbingRemarks()%>">
	<%} %>
	</span>
		<div class="clear"></div>
    <label>Lymphadenopathy</label>
	<select  class="smaller" name="lymphadenopathy" onchange ="toggleOtherTextbox(this.value,'lymphadenopathy_remarks',28, 'lymphadenopathy_span')">
		<option value="">Select</option>
	<option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getLymphadenopathy().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getLymphadenopathy().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="lymphadenopathy_span">
		<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getLymphadenopathy().equals("y")){%>
	<input type="text" name="lymphadenopathy_remarks" maxlength="28" value="<%=opdMedicineTemplate.getLymphadenopathyRemarks()%>">
	<%} %>
	</span>
    <label>Oedema</label>
	<select  class="smaller" name="oedema" onchange ="toggleOtherTextbox(this.value,'oedema_remarks',28, 'oedema_span')">
		<option value="">Select</option>
	   <option value="y" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getOedema().equals("y")?"selected":"":""%>>Yes</option>
		<option value="n" <%=opdMedicineTemplate!=null?opdMedicineTemplate.getOedema().equals("n")?"selected":"":""%>>No</option>
	</select>
	<span id="oedema_span">
		<%if(opdMedicineTemplate!=null && opdMedicineTemplate.getOedema().equals("y")){%>
	<input type="text" name="oedema_remarks" maxlength="28"  value="<%=opdMedicineTemplate.getOedemaRemarks()%>">
	<%} %>
	</span>
	
<!-- <h4>Examination of System</h4> -->
<div class="clear"></div>
<label>Inspection</label>
<textarea rows="" cols="" name ="inspection" maxlength="256"  class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getInspection():""%></textarea>
<label>Palpation</label>
<textarea rows="" cols="" name ="palpation" maxlength="256"  class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getPalpation():""%></textarea>

<div class="clear"></div>
<label>Percussion</label>
<textarea rows="" cols="" name ="percussion" maxlength="256"  class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getPercussion():""%></textarea>
<label>Auscultation</label>
<textarea rows="" cols="" name ="auscultation" maxlength="256"  class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getAuscultation():""%></textarea>
<div class="clear"></div>

<h4>Examination of System</h4>
<div class="clear"></div>
<label>Nervous System</label>
<textarea rows="" cols="" name ="nervousSystem" maxlength="256"  class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getNervousSystem():""%></textarea>
<label>Respiratory System</label>
<textarea rows="" cols="" name ="respiratorySystem"  maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getRespiratorySystem():""%></textarea>

<div class="clear"></div>
<label>Gastrointestinal System</label>
<textarea rows="" cols="" name ="gastrointestinalSystem"  maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getGastrointestinalSystem():""%></textarea>
<label>Locomotor System</label>
<textarea rows="" cols="" name ="locomotorSystem" maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getLocomotorSystem():""%></textarea>

<div class="clear"></div>
<label>Cardiovascular system</label>
<textarea rows="" cols="" name ="cardiovascularSystem" maxlength="256" class="medium w270"> <%=opdMedicineTemplate!=null?opdMedicineTemplate.getCardiovascularSystem():""%></textarea>
<label>Haematology</label>
<textarea rows="" cols="" name ="haematology" maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getHaematology():""%></textarea>

<div class="clear"></div>
<label>Nephrology</label>
<textarea rows="" cols="" name ="nephrology" maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getNephrology():""%></textarea>
<label>Remarks</label>
<textarea rows="" cols="" name ="remarks" maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getRemarks():""%></textarea>
<div class="clear"></div>
<label>Comments</label>
<textarea rows="" cols="" name ="comments" maxlength="256" class="medium w270"><%=opdMedicineTemplate!=null?opdMedicineTemplate.getOedemaComments():""%></textarea>
<div class="clear"></div>
</div>
<%if(opdMedicineTemplate!=null) {%>
<input  name="opdMedicineTemplateId" type="hidden" value="<%=opdMedicineTemplate.getId()%>" />
<%}%> 

</form>

  

<script>jQuery.noConflict();
jQuery(function($) {
	
	$("#wave").on('change','option',function(){
		 var val =$(this).val();
			//alert(val);
			if(!document.getElementById("multiDropDownValue").value.includes(val)){
			document.getElementById(val.charAt(0)+"wave_lebel").style.display='block';
			document.getElementById(val.charAt(0)+"wave_remarks").style.display='block';	
			}
			else
				{
				document.getElementById(val.charAt(0)+"wave_lebel").style.display='none';
				document.getElementById(val.charAt(0)+"wave_remarks").style.display='none';
				}
	});
	
	 $('#wave').multiSelect();
	    $('#line-wrap-example').multiSelect({
	        positionMenuWithin: $('.position-menu-within')
	    });
	    $('#categories').multiSelect({
	        noneText: 'All categories',
	        presets: [
	            {
	                name: 'All categories',
	                options: []
	            },
	            {
	                name: 'My categories',
	                options: ['a', 'c']
	            }
	        ]
	    });
});
	    </script>
<style>
.w270{width:273px !important;}
</style>



