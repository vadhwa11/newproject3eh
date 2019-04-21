
<%@page import="jkt.hms.masters.business.IpdDialysisProcess"%>
<%@page import="jkt.hms.masters.business.IpdVitalcareDetails"%>
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="jkt.hms.masters.business.OpdNursingPatientDetails"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyM"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	<%Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	Inpatient inpatient = (Inpatient) map.get("inpatient");
	List<OpdNursingPatientDetails> opdNursingPatientDetailsList = new ArrayList<OpdNursingPatientDetails>();
	  List<IpdDialysisProcess>ipdDialysisProcessList = new ArrayList<IpdDialysisProcess>();
	  List<IpdVitalcareDetails>ipdVitalCareDetailList = new ArrayList<IpdVitalcareDetails>();

	if (map.get("opdNursingPatientDetailsList") != null) {
		opdNursingPatientDetailsList = (List) map.get("opdNursingPatientDetailsList");
	}
	if (map.get("ipdDialysisProcessList") != null) {
		ipdDialysisProcessList = (List) map.get("ipdDialysisProcessList");
	}
	if (map.get("ipdVitalCareDetailList") != null) {
		ipdVitalCareDetailList = (List) map.get("ipdVitalCareDetailList");
	}
	OpdNursingPatientDetails opdNursingPatientDetails = new OpdNursingPatientDetails();
	if (opdNursingPatientDetailsList.size() > 0) {
		opdNursingPatientDetails = opdNursingPatientDetailsList.get(0);
	}
	IpdDialysisProcess ipdDialysisProcess = new IpdDialysisProcess();
	if(ipdDialysisProcessList.size()>0){
		ipdDialysisProcess = ipdDialysisProcessList.get(0);
	}
	List<String> vitalList = new ArrayList<String>();
	vitalList.add("Temperature");
	vitalList.add("Pulse");
	vitalList.add("Respiration");
	vitalList.add("BP");
	vitalList.add("Bowl");
	vitalList.add("Pain");
	vitalList.add("Girth");
	vitalList.add("Blood Sugar");
	vitalList.add("Insulin");
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");

	session.setAttribute("inpatient",inpatient);
	
%>

<h4><%= message %></h4>
<%} %>
	<div class="clear"></div>
<div class="titleBg">
	<h2>Dialysis Process</h2>
</div>
<form name="dialysisProcess" method="post">




	<input name="hinId" type="hidden"
		value="<%=inpatient.getHin().getId()%>" validate="hinId,int,no" /> <input
		name="inpatientId" type="hidden" value="<%=inpatient.getId()%>"
		validate="inpatientId,int,no" /> <input name="adNo" type="hidden"
		value="<%=inpatient.getAdNo()%>" validate="adNo,metachar,no" /> <input
		name="hinNo" type="hidden" value="<%=inpatient.getHin().getHinNo()%>"
		validate="hinNo,metachar,no" />

	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<div class="clear paddingTop15"></div>
		<div class="clear"></div>
		<h4>Patient Details</h4>
		<div class="clear"></div>

		<%@include file="PatientDetails.jsp"%>

		<div class="clear"></div>

		<h4>PreDialysis Detail</h4>
		<div class="clear"></div>

		<label>Present Complaint / History</label>
		<textarea name="presentComplain" class="medium" id="presentComplain"
			validate="presentComplain,string,no" cols="0" rows="0"
			maxlength="300" tabindex="1"><%=opdNursingPatientDetails.getPresentComplaintHistory() != null ? opdNursingPatientDetails
					.getPresentComplaintHistory() : ""%></textarea>
		<input type="button" class="buttonAuto-buttn"
			style="margin: 2px 0px 0px 4px;" id="button1" name="button1"
			value="+" onclick="getPresentTemplate();" /> <label>History
			of Past Illness</label>
		<textarea name="pastIllness" class="medium" id="pastIllness" cols="0"
			validate="pastIllness,string,no" rows="0" maxlength="300"
			tabindex="1"><%=opdNursingPatientDetails.getPastIllnessHistory() != null ? opdNursingPatientDetails
					.getPastIllnessHistory() : ""%></textarea>
		<input type="button" class="buttonAuto-buttn"
			style="margin: 2px 0px 0px 4px;" id="button2" name="button2"
			value="+" onclick="getHistoryOfPastIllnessTemplate()" />

		<div class="clear"></div>
		<label>Personal History</label>
		<textarea name="personalHistory" class="medium" id="personalHistory"
			validate="personalHistory,string,no" tabindex="1" cols="0" rows="0"
			maxlength="500"><%=opdNursingPatientDetails.getPresentComplaintHistory() != null ? opdNursingPatientDetails
					.getPresentHistory() : ""%></textarea>

		<label>Family History</label>
		<textarea name="familyHistory" id="familyHistory" class="medium"
			validate="familyHistory,string,no" cols="0" tabindex="4" rows="0"
			maxlength="500"><%=opdNursingPatientDetails.getFamilyHistory() != null ? opdNursingPatientDetails
					.getFamilyHistory() : ""%></textarea>

		<div class="clear"></div>

		<label>Medication History</label>
		<textarea name="medicationhistory" id="medicationhistory"
			class="medium" validate="medicationhistory,string,no" cols="0"
			rows="0" maxlength="500" tabindex="5"><%=opdNursingPatientDetails.getMadicationHistory() != null ? opdNursingPatientDetails
					.getMadicationHistory() : ""%></textarea>
		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<label class="auto">Pulse</label> <input name="pulse" id="pulse"
			type="text"
			value="<%=opdNursingPatientDetails.getPulse() != null ? opdNursingPatientDetails
					.getPulse() : ""%>"
			validate="pulse,num,no" maxlength="3"
			class="allownumericwithoutdecimal textSmall" tabindex="10" /> <label
			class="smallAuto">min</label> <label class="auto">Temperature</label>
		<input name="temperature" id="temperature"
			value="<%=opdNursingPatientDetails.getTemperature() != null ? opdNursingPatientDetails
					.getTemperature() : ""%>"
			validate="temperature,float,no" type="text" maxlength="6"
			class="allownumericwithdecimal textSmall" tabindex="11" /> <label
			class="smallAuto">&deg;F</label> <label id="bpLabel" class="auto">BP</label>
		<%
			String bp[] = null;
			String sBp = "";
			String dBp = "";

			if (opdNursingPatientDetails.getBp() != null) {
				bp = opdNursingPatientDetails.getBp().split("/");
				sBp = (String) bp[0];
				dBp = (String) bp[1];
			}
		%>
		<input name="systolic" id="systolic" name="Systolic"
			placeholder="Systolic" value="<%=sBp != null ? sBp : ""%>"
			validate="systolic,int,no" type="text" onblur="" maxlength="3"
			class="allownumericwithoutdecimal textSmall" tabindex="12" /> <label
			id="bpLabel" class="auto"><span style="color: black">/</span></label>
		<input name="diastolic" id="diastolic" name="diastolic"
			value="<%=dBp != null ? dBp : ""%>" placeholder="Diastolic"
			validate="diastolic,int,no" type="text" onblur="" maxlength="3"
			class="allownumericwithoutdecimal textSmall" tabindex="13" /></span> <label
			class="smallAuto">mm&nbsp;Hg</label> <label class="auto">Weight</label>
		<input name="weight" id="weight" type="text" maxlength="3"
			class="allownumericwithoutdecimal textSmall"
			value="<%=opdNursingPatientDetails.getWeight() != null ? opdNursingPatientDetails
					.getWeight() : ""%>"
			validate="weight,int,no" onblur="calculateBMI();" tabindex="14" /> <label
			class="smallAuto">Kg</label> <label class="auto">Height</label> <input
			name="height" id="height" type="text" maxlength="3"
			class="allownumericwithoutdecimal textSmall"
			value="<%=opdNursingPatientDetails.getHeight() != null ? opdNursingPatientDetails
					.getHeight() : ""%>"
			validate="height,int,no" onblur="calculateBMI();" tabindex="15" /> <label
			class="smallAuto">cm</label> <label class="auto" id="bpLabel">BMI</label>
		<input name="bmi" id="bmi" type="text"
			value="<%=opdNursingPatientDetails.getBmi() != null ? opdNursingPatientDetails
					.getBmi() : ""%>"
			readonly="readonly" class="textSmall" />

		<div class="clear paddingTop15"></div>
		<input type="hidden" name="ipdDialysisId"  id="ipdDialysisId" value="<%=ipdDialysisProcess.getId()!= null?ipdDialysisProcess.getId():"" %>" />
		  <label>Dialysis Start Date</label>
 <%if(ipdDialysisProcess.getStartDate() != null){ %>
  <input type="text" class="startDate" id="startDateId" class="date" name="startDate"  value="<%=HMSUtil.convertDateToStringWithoutTime(ipdDialysisProcess.getStartDate()) %>" readonly="readonly" MAXLENGTH="30" />
  <%}else{ %>
    <input type="text" class="startDate" id="startDateId" class="date" name="startDate" value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" />
  
  <%} %>
   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.dialysisProcess.startDate,event);" />
	
 <label>Dialysis Start Time</label>
 <%if(ipdDialysisProcess.getStartTime() != null){ %>
 <input	type="text" name="startTime" id="startTime" value="<%=ipdDialysisProcess.getStartTime() %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"/>
 <%}else{ %>
 <input	type="text" name="startTime" id="startTime" value="<%=time %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"/>
 <%} %>
 	<div class="clear"></div>
	<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForVitalcare();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForVitalcare();">
		</div>
		<h4>Vitals</h4>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="cmnTable">
			<table border="0" align="center" cellpadding="0" cellspacing="0" id="vitalcaretable">
				<tr>
					<th scope="col">Vitals</th>
					<th scope="col">Time</th>
					<th scope="col">Value</th>

				</tr>
				<%
				int i=0;
				if(ipdVitalCareDetailList.size()>0){
					for(IpdVitalcareDetails ipdVitalcareDetails : ipdVitalCareDetailList){
					%>
				<tr>
					<td><input type="text"  id="vitalName" value="<%=ipdVitalcareDetails.getVitalHeader().getVitalSetup().getVitalName() %>" name="vitalName" maxlength="5" />
					<input type="hidden" name="ipdVitalcareDetailId" value="<%=ipdVitalcareDetails.getId() %>" />
					<input type="hidden" name="ipdVitalcareHeaderId" value="<%=ipdVitalcareDetails.getVitalHeader().getId() %>" />
					<input type="hidden" name="ipdVitalcareSetupId" value="<%=ipdVitalcareDetails.getVitalHeader().getVitalSetup().getId() %>" /> </td>
					<td><input type="text" id="vitalTime" name="vitalTime" value="<%=ipdVitalcareDetails.getCareTime() %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
					<td><input type="text"  id="vitalValue" name="vitalValue" maxlength="5" value="<%=ipdVitalcareDetails.getVitalValue() %>" /></td>
				</tr>
				
				
				<%}}else{ %>
				<%
				
				i++;
										%>
				<tr>
					<td width="27%"><select name="vitalName<%=i%>" id="vitalName<%=i%>" onblur="displayBPValue(this.value,'<%=i%>')">
											<option value="">Select</option>
											<%for (String vital : vitalList) {%>
											<option value="<%=vital%>"><%=vital%></option>
											<%
												}
											%>
									</select></td>
					<td><input type="text" id="vitalTime<%=i%>" name="vitalTime" value="<%=time %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
					<td><div id="normalDiv<%=i%>">
					<input type="text"  id="vitalValue<%=i%>" name="vitalValue<%=i%>" value="" maxlength="5" />
					</div>
					<div id="bpDiv<%=i%>" style="display:none;">
					<input type="text"  id="dBP<%=i%>" name="dBP<%=i%>" value="" class="allownumericwithoutdecimal textSmall" maxlength="5" />
					<label style="float:left;">/</label>
					<input type="text"  id="sBP<%=i%>" name="sBP<%=i%>" value="" class="allownumericwithoutdecimal textSmall" maxlength="5" />
					</div></td>
				</tr>
				<%} %>
			</table>
		</div>
<input type="hidden" name="vitalcarecount" id="vitalcarecount" value="<%=i%>"/>
		<div class="clear"></div>
<div class="clear"></div>

		<h4>Intra Dialytic Event</h4>
		<div class="clear"></div>
		
<label>Cramps</label>
<%if(ipdDialysisProcess.getCramps()!= null && !ipdDialysisProcess.getCramps().equals("")){ %>
<input	type="checkbox" name="cramps" id="cramps" value="y" checked="checked"	readonly="readonly" class="radioCheck" onclick="checkCrampsTextValue();" />
<input	type="text" name="crampsValue" id="crampsValue" value="<%=ipdDialysisProcess.getCramps()%>" />

<%}else{ %>
<input	type="checkbox" name="cramps" id="cramps" value="y"  class="radioCheck" onclick="checkCrampsTextValue();" />
<div id="crampsDiv" style="display: none">
<input	type="text" name="crampsValue" id="crampsValue" value=""/>
</div>
<%} %>



 <label>Vomiting</label> 
 <%if(ipdDialysisProcess.getVomiting()!= null && !ipdDialysisProcess.getVomiting().equals("")){ %>
 <input type="checkbox"	name="vomiting" id="vomiting" value="y" checked="checked"	readonly="readonly" class="radioCheck" onclick="checkVomitingTextValue();" />
<input	type="text" name="vomitingValue" id="vomitingValue" value="<%=ipdDialysisProcess.getVomiting()%>"/>
 <%}else{ %>
<input type="checkbox"	name="vomiting" id="vomiting" value="y" class="radioCheck" onclick="checkVomitingTextValue();" />
<div id="vomitingDiv" style="display: none">
<input	type="text" name="vomitingValue" id="vomitingValue" value=""/>
</div>
<%} %>
<div class="clear"></div>



 <label>Chest pain</label>
 <%if(ipdDialysisProcess.getChestPain()!= null && !ipdDialysisProcess.getChestPain().equals("")){ %>
  <input type="checkbox"	name="chestPain" id="chestPain" value="y" class="radioCheck" checked="checked"	readonly="readonly"  onclick="checkChestPainTextValue();" />
 <input	type="text" name="chestPainValue" id="chestPainValue" value="<%=ipdDialysisProcess.getChestPain()%>"/>
 <%}else{ %>
 <input type="checkbox"	name="chestPain" id="chestPain" value="y" class="radioCheck"  onclick="checkChestPainTextValue();" />
 <div id="chestPainDiv" style="display: none">
 <input	type="text" name="chestPainValue" id="chestPainValue" value=""/>
</div>
<%} %>
 

 
 <label>Shivering</label>
 <%if(ipdDialysisProcess.getShivering()!= null && !ipdDialysisProcess.getShivering().equals("")){ %>
 <input type="checkbox"	name="shivering" id ="shivering"   value="y"  class="radioCheck" checked="checked"	readonly="readonly"  onclick="checkShiveringTextValue();" />
 <input	type="text" name="shiveringValue" id="shiveringValue" value="<%=ipdDialysisProcess.getShivering()%>" />

 <%}else{ %>
 <input type="checkbox"	name="shivering" id ="shivering"   value="y" class="radioCheck"  onclick="checkShiveringTextValue();" />
 <div id="shiveringDiv" style="display: none">
 <input	type="text" name="shiveringValue" id="shiveringValue" value=""/>
 </div>
 <%} %>

<div class="clear"></div>


 <label>Fever</label>
  <%if(ipdDialysisProcess.getFever()!= null && !ipdDialysisProcess.getFever().equals("")){ %>
  <input type="checkbox"	name="fever" id ="fever"  value="y" class="radioCheck"  checked="checked"	readonly="readonly"   onclick="checkFeverTextValue();" />
 <input	type="text" name="feverValue" id="feverValue" value="<%=ipdDialysisProcess.getFever()%>"/>
  <%}else{ %>
 <input type="checkbox"	name="fever" id ="fever"  value="y" class="radioCheck"  onclick="checkFeverTextValue();" />
 <div id="feverDiv" style="display: none">
 <input	type="text" name="feverValue" id="feverValue" value=""/>
 </div>
 <%} %>

<div class="clear"></div>
<label>Other Health Event</label>
<textarea name="otherHealthEvent" class="medium" id="otherHealthEvent" validate="Other Health Event,string,no" tabindex="1" cols="0" rows="0"maxlength="180"><%=ipdDialysisProcess.getOtherHealthEvent()!= null?ipdDialysisProcess.getOtherHealthEvent():"" %></textarea>
<div class="clear"></div>
<label>End</label>
<%if(ipdDialysisProcess.getEndEvent() != null && ipdDialysisProcess.getEndEvent().equals("y")){ %>
 <input type="checkbox"	name="endEvent" id ="endEvent"  value="y" class="radioCheck" checked="checked"  onclick="checkEndTextValue();" />
 <%}else{ %>
 <input type="checkbox"	name="endEvent" id ="endEvent"  value="y" class="radioCheck"  onclick="checkEndTextValue();" />
 <%} %>
 
 <%if(ipdDialysisProcess.getEndEvent() != null && !ipdDialysisProcess.getEndEvent().equals("") && ipdDialysisProcess.getEndEvent().equals("y")){ %>
  <label>End Date</label>
  <input type="text" class="date" id="endDateId" class="date" name="endDate" value="<%=ipdDialysisProcess.getEndDate() != null ?HMSUtil.convertDateToStringWithoutTime(ipdDialysisProcess.getEndDate()):"" %>"  readonly="readonly" MAXLENGTH="30" />
   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.dialysisProcess.endDate,event);" />
	
 <label>End Time</label>
 <input	type="text" name="endTime" id="endTime" value="<%=ipdDialysisProcess.getEndTime()!= null?ipdDialysisProcess.getEndTime():"" %>" onKeyUp="mask(this.value,this,'2',':');"  onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"/>
 
 
 <%}else{ %>
  <div id="endDiv" style="display: none">
  <label>End Date</label>
  <input type="text" class="date" id="endDateId" class="date" name="endDate" value=""  readonly="readonly" MAXLENGTH="30" />
   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.dialysisProcess.endDate,event);" />
	
 <label>End Time</label>
 <input	type="text" name="endTime" id="endTime" value="<%=time %>" onKeyUp="mask(this.value,this,'2',':');"  onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"/>
 
</div>
<%} %>
	<div class="clear"></div>
	
	<%
	
	if(ipdDialysisProcess.getEndEvent()!= null && !ipdDialysisProcess.getEndEvent().equals("")){
		if(ipdDialysisProcess.getEndEvent().equals("y")){
		%>
		<%}}else{ %>
		<input type="button" name="Save" id="addbutton" value="Save" class="button" onClick="submitForm('dialysisProcess','/hms/hms/ipd?method=saveDialysisProcess&inpatientId=<%=opdNursingPatientDetails.getInpatient().getId()%>');" accesskey="a" /> 
		<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="submitForm('dialysisProcess','/hms/hms/ipd?method=saveDialysisProcess&inpatientId=<%=opdNursingPatientDetails.getInpatient().getId()%>','checkEndDateTime');" accesskey="a" /> 
<%} %>
<input name="Back" type="button" alt="Back" value="Back" class="cmnButton" onclick="submitForm('dialysisProcess','/hms/hms/ipd?method=showPatientListJsp');" align="right" />
		
		<div class="clear"></div>


		<!-- <div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div> -->
		<div class="clear"></div>

	</div>
	<div class="clear"></div>
<script>
function checkEndDateTime(){
	if(document.getElementById('endEvent').checked){
		if(document.getElementById('endDateId').value == ''){
			alert("Enter End date.");
			return false;
		}
		
	}else{
		alert("First end the dialysis process.");
		return false;
	}
	return true;
	
}
function displayBPValue(val,i){

	if(val == "BP"){
		document.getElementById('bpDiv'+i).style.display = 'inline';
		document.getElementById('normalDiv'+i).style.display = 'none';
	}else{
		document.getElementById('normalDiv'+i).style.display = 'inline';
		document.getElementById('bpDiv'+i).style.display = 'none';
	}

}	

function checkCrampsTextValue(){
	if(document.getElementById('cramps').checked == true){
		document.getElementById('crampsDiv').style.display = 'inline';
	}else{
		document.getElementById('crampsDiv').style.display = 'none';
	}
}
function checkVomitingTextValue(){
	if(document.getElementById('vomiting').checked == true){
		document.getElementById('vomitingDiv').style.display = 'inline';
	}else{
		document.getElementById('vomitingDiv').style.display = 'none';
	}
}
function checkChestPainTextValue(){
	if(document.getElementById('chestPain').checked == true){
		document.getElementById('chestPainDiv').style.display = 'inline';
	}else{
		document.getElementById('chestPainDiv').style.display = 'none';
	}
}
function checkShiveringTextValue(){
	if(document.getElementById('shivering').checked == true){
		document.getElementById('shiveringDiv').style.display = 'inline';
	}else{
		document.getElementById('shiveringDiv').style.display = 'none';
	}
}
function checkFeverTextValue(){
	if(document.getElementById('fever').checked == true){
		document.getElementById('feverDiv').style.display = 'inline';
	}else{
		document.getElementById('feverDiv').style.display = 'none';
	}
}

function checkEndTextValue(){
	if(document.getElementById('endEvent').checked == true){
		document.getElementById('endDiv').style.display = 'inline';
	}else{
		document.getElementById('endDiv').style.display = 'none';
	}
}


function addRowForVitalcare(){
	var tbl = document.getElementById('vitalcaretable');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('vitalcarecount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	
	var cellRight0 = row.insertCell(0);
	var e1 = document.createElement('Select');
	e1.name='vitalName'+iteration;
	e1.id='vitalName'+iteration;
	e1.options[0] = new Option('Select', '0');
	e1.onblur=function(){
		displayBPValue(this.value,iteration);};
	var vitalCount=0;
	<%
	
	for (String vital : vitalList) {
		%>
		vitalCount++;
		e1.options[vitalCount] = new Option('<%=vital%>','<%=vital%>');
<%
	}
%>
	cellRight0.appendChild(e1);

	
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='vitalTime'+iteration;
	e1.id='vitalTime'+iteration;
	e1.value='<%=time%>';
	cellRight1.appendChild(e1);
	
	var cellRight2 = row.insertCell(2);
	var div1 = document.createElement('div');
 	 div1.id='normalDiv'+iteration;
	  //div.style.display=' none';
	  //div.className='autocomplete';
  	cellRight2.appendChild(div1);
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='vitalValue'+iteration;
	e1.id='vitalValue'+iteration;
	div1.appendChild(e1);
	
	var div2 = document.createElement('div');
	 div2.id='bpDiv'+iteration;
 	 div2.style.display='none';
 	cellRight2.appendChild(div2);
 	 
 	 
	//var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='dBP'+iteration;
	e1.id='dBP'+iteration;
	e1.className='allownumericwithoutdecimal textSmall';

	
	var e2 = document.createElement('label');
	e2.style.float='left';
	//e2.value= '/';
	e2.innerHTML ='/';

	
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='sBP'+iteration;
	e3.id='sBP'+iteration;
	e3.className='allownumericwithoutdecimal textSmall';
	div2.appendChild(e1);
	div2.appendChild(e2);
	div2.appendChild(e3);
	
	
	
	}

/* function removeRowForVitalcare()
{
  var tbl = document.getElementById('vitalcaretable');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('vitalcarecount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("radiovitalCare"+i)!=null && (typeof  document.getElementById("radiovitalCare"+i).checked)!='undefined' && document.getElementById("radiovitalCare"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("radiovitalCare"+i)!=null && (typeof  document.getElementById("radiovitalCare"+i).checked)!='undefined' && document.getElementById("radiovitalCare"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("radiovitalCare"+i).parentNode.parentNode;
    		  document.getElementById("radiovitalCare"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
} */
function removeRowForVitalcare()
{ 
	var tbl = document.getElementById('vitalcaretable');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('vitalcarecount').length;counter++)
	{
		//if (document.getElementsByName('selectedReaction')[counter].checked == true)
		//{
		  	tbl.deleteRow(counter+1);
		  	//totalCost();
		//}
	}
}
</Script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>




