
<%--
	* Copyright 2008 JK Technosoft Ltd. All rights reserved.
	* Use is subject to license terms.
	* nursingClinicalChart.jsp
	* Purpose of the JSP -  This is for Nursing Clinical Chart Details.
	* @author  Dipali
	* Create Date: 08th Feb,2008
	* Revision Date:
	* Revision By: Purpose
	* @version 1.8
	--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script> 
<script language="JavaScript">

	function fillHin(val1,val2,hinNo){
	document.getElementById("adminNo").value=val1
	document.getElementById("srNo").value=val2
	document.getElementById("hinNo").value=hinNo;
	}
	function checkRadio(){

	  for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				return true;
			  }
  		}
  		alert("Please select the patient")
		return false;
		}

	function fillTime(time)
	{
	var len = document.getElementById("indentDetails").rows.length;
	for(var i=1;i<len;i++)
	{
	document.getElementById(i).value=time;
	}
	}
	</script>
<script type='text/javascript'>
	function isEmpty(elem, errorMsg){
	var len
	if(elem.value.length == 0){
	alert(errorMsg);
	elem.focus();
	return true;
	}
	return false;
	}
	</script>
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->

	</script>


<!--[if IE]>
	<style type="text/css">
	/* IE Specific Style addition to constrain table from automatically growing in height */
	div.TableContainer {
	 height: auto;
	 overflow-x:hidden;
	 overflow-y:auto;
	}
	</style>
	<![endif]-->

<script type="text/JavaScript" src="/hms/jsp/js/sortTable.js"></script>
<script>
	// Function to scroll to top before sorting to fix an IE bug
	// Which repositions the header off the top of the screen
	// if you try to sort while scrolled to bottom.
	function GoTop() {
	 document.getElementById('TableContainer').scrollTop = 0;
	}

	// For those browsers that fully support the CSS :hover pseudo class the "table.scrollTable tr:hover" definition above
	// will work fine, but Internet Explorer 6 only supports "hover" for "<a>" tag elements, so we need to use the following
	// JavaScript to mimic support (at least until IE7 comes out, which does support "hover" for all elements)

	// Create a JavaScript function that dynamically assigns mouseover and mouseout events to all
	// rows in a table which is assigned the "scrollTable" class name,  in order to simulate a "hover"
	// effect on each of the tables rows
	HoverRow = function() {

	 // If an IE browser
	 if (document.all) {
	  var table_rows = 0;

	  // Find the table that uses the "scrollTable" classname
	  var allTableTags=document.getElementsByTagName("table");
	  for (i=0; i<allTableTags.length; i++) {
	   // If this table uses the "scrollTable" class then get a reference to its body and first row
	   if (allTableTags[i].className=="scrollTable") {
	    table_body = allTableTags[i].getElementsByTagName("tbody");
	    table_rows = table_body[0].getElementsByTagName("tr");
	    i = allTableTags.length + 1; // Force an exit from the loop - only interested in first table match
	   }
	  }

	  // For each row add a onmouseover and onmouseout event that adds, then remove the "hoverMe" class
	  // (but leaving untouched all other class assignments) to the row in order to simulate a "hover"
	  // effect on the entire row
	  for (var i=0; i<table_rows.length; i++) {
	   // ignore rows with the title and total class assigned to them
	   if (table_rows[i].className != "title" && table_rows[i].className != "total") {
	    table_rows[i].onmouseover=function() {this.className += " hoverMe";}
	    table_rows[i].onmouseout=function() {this.className=this.className.replace(new RegExp(" hoverMe\\b"), "");}
	   }
	  } // End of for loop

	 } // End of "If an IE browser"

	}
	// If this browser suports attaching events (IE) then make the HoverRow function run on page load
	// Hote: HoverRow has to be re-run each time the table gets sorted
	if (window.attachEvent) window.attachEvent("onload", HoverRow);
	</script>
	
	<script>
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String time = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	int pageNo=1;
	String max="";
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String clinicalDate = (String)utilMap.get("currentDate");
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	Set inPatientSet = new HashSet();
	try {
	if(map.get("takeSetFromSessionInJsp")!=null)
	{
	String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
	if(takeSetFromSessionInJsp.equals("false"))
	{
	inPatientSet=(Set)map.get("inPatientSet");
	session.setAttribute("inPatientSet",inPatientSet);
	}else{
	inPatientSet=(Set) session.getAttribute("inPatientSet");
	}
	}

	} catch (Exception exp) {
	exp.printStackTrace();
	}
	List inPatientDetailList = new ArrayList();
	try{
	inPatientDetailList=(List)map.get("inPatientDetailList");

	}catch(Exception e){
	e.printStackTrace();
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	if(map.get("inpatientList")!=null){
	inpatientList = (List) map.get("inpatientList");
	}
	if(map.get("message") != null){
	String message = (String)map.get("message");
	out.println(message);
	}
	if(map.get("max")!=null)
	max = (String) map.get("max");
	Inpatient inpatient=null;
	if(inpatientList.size()>0)
	{
		inpatient=(Inpatient)inpatientList.get(0);
		session.setAttribute("inpatient",inpatient);
	}

	/*   int k=0;
	if(inpatientList.size()>0)
	for (Inpatient inpatient : inpatientList){ */
	%>
<%--<script>
 indentArray[<%=k%>]= new Array();
	indentArray[<%=k%>][0] = "<%=inpatient.getId()%>";
	indentArray[<%=k%>][1] = "<%=inpatient.getAdNo()%>";
	indentArray[<%=k%>][2] = "<%=inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName()+" "+inpatient.getHin().getPLastName()%>";
	indentArray[<%=k%>][3] = "" ;
	indentArray[<%=k%>][4] = "";
	indentArray[<%=k%>][5] = "";
	indentArray[<%=k%>][6] = "";
	indentArray[<%=k%>][7] = "" ;
	indentArray[<%=k%>][8] = "";
	indentArray[<%=k%>][9] = "";
	indentArray[<%=k%>][10] = "";
	indentArray[<%=k%>][11] = "";
	</script>
<%
	k++;
	} %>


 <form name="nursingClinicalChart" method="post">
<h2>Clinical Chart</h2>

<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label class="medium">Date</label>
<label class="valueAuto" id="time"><%=clinicalDate%></label>
<label id="testDiv" class="medium">Time</label>
<input type="text" id="timeId" name="timeForAll" class="small" value="<%=time%>" tabindex=1
			onKeyUp="mask(this.value,this,'2',':');" maxlength="5" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--<div class="cmntableWithHeight">-->

<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>
						<tr>
							<th></th>
							<th>Reg No.</th>
							<th>IPD No.</th>
							<th>Patient Name</th>
							<th>Time</th>
							<th colspan="2">Temperature</th>
							<th colspan="2">Pulse</th>
							<th colspan="2">Respiration</th>
							<th colspan="2">BP</th>
							<th colspan="2">FHR</th>
							<th colspan="2">SPO2</th>
							<th>Pain</th>
							<th>Bowel</th>
							<th>Remarks</th>
						</tr>
				</thead>
				<tbody class="scrollContent bodyFormat">
					<tr>
						<%
	String status="status";
	String incTime="time";
	String incPulse="incPulse";
	String incResp="incResp";
	String incBp="incBp";
	String incFhr="incFhr";
	String incSPO2="incSPO2";
	String incRemarks="incRemarks";
	String incPulseTemp="incPulseTemp";
	String incRespTemp="incRespTemp";
	String incBpTemp="incBpTemp";
	String incFhrTemp="incFhrTemp";
	String incSPO2Temp="incSPO2Temp";
	String incRemarksTemp="incRemarksTemp";
	String incTimeTemp="incTimeTemp";
	String incPulse2="incPulse";
	String incResp2="incResp";
	String incBp2="incBp";
	String incFhr2="incFhr";
	String incSPO22="incSPO2";
	String incRemarks2="incRemarks";
	String incPulseTemp2="incPulseTemp";
	String incRespTemp2="incRespTemp";
	String incTimeTemp2="incTimeTemp";
	String incBpTemp2="incBpTemp";
	String incFhrTemp2="incFhrTemp";
	String incSPO2Temp2="incSPO2Temp";
	String incRemarksTemp2="incRemarksTemp";
	String status2="status";
	int inc=((pageNo-1)*10)+1;
	int incTemp2=inc+10;
	int cnt = 1;
	for(Inpatient inpatientObj : inpatientList){
	status=status2+(""+inc);
	incPulse=incPulse2+(""+inc);
	incResp=incResp2+(""+inc);
	incBp=incBp2+(""+inc);
	incFhr=incFhr2+(""+inc);
	incSPO2=incSPO22+inc;
	incRemarks=incRemarks2+(""+inc);
	incPulseTemp=incPulseTemp2+(""+inc);
	incRespTemp=incRespTemp2+(""+inc);
	incBpTemp=incBpTemp2+(""+inc);
	incFhrTemp=incFhrTemp2+(""+inc);
	incSPO2Temp=incSPO2Temp2+inc;
	incRemarksTemp=incRemarksTemp2+(""+inc);
	incTimeTemp=incTimeTemp2+(""+inc);
	%>
						<td><input type="radio"
							onchange="fillHin('<%=inpatientObj.getAdNo()%>','<%=inpatientObj.getHin().getServiceNo()%>','<%=inpatientObj.getHin().getHinNo() %>');"
							tabindex=3 name="parent" value="<%= inpatientObj.getAdNo()%>"
							id="radio" class="radioCheck" /></td>
						<td><input type="text"
							value="<%=inpatientObj.getHin().getHinNo() %>" size="12"
							name="<%=HIN_NO%>" readonly="readonly" tabindex=3
							class="readOnly" /></td>
						<td><input type="text" value="<%=inpatientObj.getAdNo() %>"
							size="12" name="<%=AD_NO%>" readonly="readonly" tabindex=3
							class="readOnly" /> <input type="hidden"
							value="<%=inpatientObj.getHin().getHinNo() %>" id="hinNoTemp"
							name="hinNoTemp" /></td>
						<td>
					<%	String ptName ="";
	String fPtName ="";
	String mPtName ="";
	String lPtName ="";
	if(inpatientObj.getHin().getPFirstName()!=null){
		fPtName=inpatientObj.getHin().getPFirstName();
	}
	if(inpatientObj.getHin().getPMiddleName()!=null){
		mPtName=inpatientObj.getHin().getPMiddleName();
	}else{
		mPtName="";
	}
	if(inpatientObj.getHin().getPLastName()!=null){
		lPtName=inpatientObj.getHin().getPLastName();
	}
	ptName=fPtName+" "+mPtName+" "+lPtName; %>

						<input type="text" size="35"value="<%=ptName%>"name="<%=PATIENT_NAME%>"
								 readonly="readonly" tabindex=3	class="readOnly" /></td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=CHANGED_TIME%>" id="<%=cnt++%>" class="readOnly"
							tabindex=3 /></td>
						<td><select name="<%=TEMPERATURE %>"
							onchange="changeStatus(<%=inc %>);" tabindex=1 class="small">
							<option value="0">Select</option>
							<option value="97">97</option>
							<option value="97.2">97.2</option>
							<option value="97.4">97.4</option>
							<option value="97.6">97.6</option>
							<option value="97.8">97.8</option>
							<option value="98">98</option>
							<option value="98.2">98.2</option>
							<option value="98.4">98.4</option>
							<option value="98.6">98.6</option>
							<option value="98.8">98.8</option>
							<option value="99">99</option>
							<option value="99.2">99.2</option>
							<option value="99.4">99.4</option>
							<option value="99.6">99.6</option>
							<option value="99.8">99.8</option>
							<option value="100">100</option>
							<option value="100.2">100.2</option>
							<option value="100.4">100.4</option>
							<option value="100.6">100.6</option>
							<option value="100.8">100.8</option>
							<option value="101">101</option>
							<option value="101.2">101.2</option>
							<option value="101.4">101.4</option>
							<option value="101.6">101.6</option>
							<option value="101.8">101.8</option>
							<option value="102">102</option>
							<option value="102.2">102.2</option>
							<option value="102.4">102.4</option>
							<option value="102.6">102.6</option>
							<option value="102.8">102.8</option>
							<option value="103">103</option>
							<option value="103.2">103.2</option>
							<option value="103.4">103.4</option>
							<option value="103.6">103.6</option>
							<option value="103.8">103.8</option>
							<option value="104">104</option>
							<option value="104.2">104.2</option>
							<option value="104.4">104.4</option>
							<option value="104.6">104.6</option>
							<option value="104.8">104.8</option>
							<option value="105">105</option>
							<option value="105.2">105.2</option>
							<option value="105.2">105.4</option>
							<option value="105.6">105.6</option>
							<option value="105.8">105.8</option>
							<option value="106">106</option>
						</select></td>
						<td><sup>&deg;</sup>F</td>
						<td><input type="hidden" size="2" value="0" name="<%=PULSE%>"
							id="<%=incPulse%>" validate="Pulse,int,no"
							onchange="checkPulseValidation(this.value);" maxlength="3"
							tabindex=1 /> <input type="text" size="2" value=""
							name="<%=PULSE_TEMP%>" id="<%=incPulseTemp%>"
							onblur="fillClinical(<%=inc %>);" validate="Pulse,int,no"
							onchange="checkPulseValidation(this.value,'<%=inc %>');"
							maxlength="3" tabindex=1 /></td>
						<td>/min</td>
						<td><input type="text" size="2" value=""
							name="<%=RESPIRATION_TEMP%>" id="<%=incRespTemp%>"
							onblur="fillClinical(<%=inc %>);" validate="Respiration,int,no"
							onchange="checkRespirationValidation(this.value,'<%=inc %>');"
							maxlength="2" tabindex=1 /> <input type="hidden" size="2"
							value="0" name="<%=RESPIRATION%>" id="<%=incResp%>"
							validate="Respiration,int,no"
							onchange="checkRespirationValidation(this.value);" maxlength="2"
							tabindex=1 /></td>
						<td>/min</td>
						<td><input type="text" size="6" value="" name="<%=BP_TEMP%>"
							id="<%=incBpTemp%>"
							onblur="validateBpWithSlash(this.value);fillClinical(<%=inc %>);"
							onchange="checkBpValidation(this.value,'<%=inc %>');"
							maxlength="7" tabindex=1 /> <input type="hidden" value="0"
							name="<%=BP%>" id="<%=incBp%>" maxlength="7" /></td>
						<td>mm/hg</td>
						<td><input type="text" value="" name="<%=FHR_TEMP%>"
							id="<%=incFhrTemp%>" onblur="fillClinical(<%=inc %>);"
							validate="Fhr,int,no"
							onchange="checkFhrValidation(this.value,'<%=inc %>');" tabindex=1
							maxlength="3" size="2" /> <input type="hidden" size="2"
							value="0" name="<%=FHR%>" id="<%=incFhr%>"
							validate="Fhr,string,no"
							onchange="checkFhrValidation(this.value);" tabindex=1 /></td>
						<td>/min</td>
<td><input type="text" value="" name="<%=SPO2_TEMP%>" id="<%=incSPO2Temp%>"
							 onblur="fillClinical(<%=inc %>);"	validate="SPO2,float,no" tabindex=1
							maxlength="7" size="2" tabindex=1/>
							<input type="hidden" size="2" value="0.0" name="<%=SPO2%>" id="<%=incSPO2%>"
							  		validate="SPO2,string,no"  maxlength="7"/>
							</td><td>%</td>
						<td><select name="<%= PAIN%>"
							onchange="changeStatus(<%=inc %>);" tabindex=1 class="small">
							<option value="0">Select</option>
							<option value="P1">P1</option>
							<option value="P2">P2</option>
							<option value="P3">P3</option>
							<option value="P4">P4</option>
							<option value="P5">P5</option>
							<option value="P6">P6</option>
							<option value="P7">P7</option>
							<option value="P8">P8</option>
							<option value="P9">P9</option>
							<option value="P10">P10</option>
						</select></td>

						<td><input name="<%= BOWEL%>"
							onchange="changeStatus(<%=inc %>);" value="" size="3"
							maxlength="3" tabindex=1 /></td>
						<td><input type="text" value="" name="<%=REMARKS_TEMP%>"
							id="<%=incRemarksTemp%>" onblur="fillClinical(<%=inc %>);"
							validate="Remarks,string,no" tabindex=1 maxlength="30" size="8" />
						<input type="hidden"  value="emptyString"
							name="<%=REMARKS%>" id="<%=incRemarks%>"
							validate="Remarks,string,no" tabindex=1 maxlength="30" size="8"/></td>
					</tr>

					<input type="hidden" name=<%=HIN_ID %>
						value="<%=inpatientObj.getHin().getId()%>" />
					<input type="hidden" name=<%=STATUS%> value="n" id="<%=status%>" />
					<%inc++;} %>
				</tbody>
			</table>

			</div>
			</td>
		</tr>
	</tbody>
</table>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" value="" name="adminNo" id="adminNo" /> <input
	type="hidden" value="" name="hinNo" id="hinNo" /> <input type="hidden"
	value="" name="srNo" id="srNo" /> <input type="hidden" name="pageNo"
	value="<%=pageNo%>" /> <input type="hidden" name="<%=NO_OF_ROWS%>"
	id="rr" value="22" /> <input type="button" name="sss" class="button"
	value="Submit"
	onclick="submitForm('nursingClinicalChart','ipd?method=submitNursingClinicalChart','checkRadio');" />
<input type="button" class="button" value="Print" align="left"
	onClick="{submitForm('nursingClinicalChart','/hms/hms/discharge?method=showClinicalSheetReport&admissionNumber='+document.getElementById('adminNo').value+'&serviceNo='+document.getElementById('srNo').value+'&hinNo='+document.getElementById('hinNo').value+'','validateRadio');}" />
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('nursingClinicalChart','ipd?method=showPatientListJsp');" />
<input type="button" class="button" value="View" align="left"
	onClick="submitForm('nursingClinicalChart','ipd?method=showViewClinicalChartJsp','validateRadio');" />
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

</form>  --%>

 <form name="nursingClinicalChart" method="post">
 
 <input type="hidden" name=<%=HIN_ID %> value="<%=inpatient.getHin().getId()%>" />
<input type="hidden" value="<%=inpatient.getAdNo()%>" name="<%=AD_NO %>" id="adminNo"  /> 
<input type="hidden" value="<%=inpatient.getId()%>" name="<%=INPATIENT_ID %>" id="adminNo"  /> 
<input type="hidden" value="<%=inpatient.getHin().getHinNo()%>" name="<%=HIN_NO %>" id="adminNo"  /> 
	
<h2>Clinical Entry</h2>

<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>


<div class="clear"></div>
<div class="Block">
<div class="paddingTop15"></div>

<h4>patient Details</h4>
	<div class="clear"></div>
	<div class="paddingTop15"></div><div class="paddingTop15"></div>
		<%@include file="PatientDetails.jsp" %>
	
	<div class="clear"></div>
	<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<%--<div class="division"></div>

<div class="clear"></div>
 <label class="medium">Date</label>
<label class="valueAuto" id="time">
<input type="text" size="8" value="<%=clinicalDate%>"
							name="common2date1" id="common2date11" validate="Date Of OutputDetails,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=clinicalDate%>',document.intakeOutput.common2date1,event)" 
							validate="Pick a date" src="/hms/jsp/images/cal.gif" />


</label> --%>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--<div class="cmntableWithHeight">-->
<div style="float: right;"><input type="button"
	class="buttonAdd" value=" "
	onclick="addRowCommonDetails();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowCommonDetails();" align="right" /> 
	</div>
		<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table class="scrollTable" id='intakeOutputId'>
<!-- 				<thead class="fixedHeader headerFormat">  -->
					<tr>
						<th>&nbsp;</th>
						<th>Date</th>
						<th>Time</th>
						<th>Temperature</th>
						<th>Pulse</th>
						<th>Respiration</th>
						<th>BP</th>
						<th>Bowel</th>
						<th>Pain</th>
						<!-- <th>FHR</th> -->
						<th>Remarks</th>
					</tr>
<!--				</thead> -->
<!--				<tbody class="scrollContent bodyFormat"> -->
					<tr>
						<td><input type="checkbox" name="common1" value=""
							class="radioCheck" id="common1" /></td>
						<td><input type="hidden" name="srNO" /> 
						
						<input type="text"
							size="8" value="<%=dateCal+"/"+month+"/"+year%>" name="<%=TEMPERATURE_DATE%>1" id="<%=TEMPERATURE_DATE%>1"
							validate="Date,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=dateCal+"/"+month+"/"+year%>',document.nursingClinicalChart.<%=TEMPERATURE_DATE%>1,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
							</td>
						<td><input type="text" size="6" value="<%=time%>"
							name="<%=TEMPERATURE_TIME%>1" id="<%=TEMPERATURE_TIME%>1"
							onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
						<td>
						<input type="text" class="small" value=""  name="<%=TEMPERATURE %>1" id="<%=TEMPERATURE %>1" />
						<%-- <select name="<%=TEMPERATURE %>" class="small">
							<option value="0">Select</option>
							<option value="97">97</option>
							<option value="97.2">97.2</option>
							<option value="97.4">97.4</option>
							<option value="97.6">97.6</option>
							<option value="97.8">97.8</option>
							<option value="98">98</option>
							<option value="98.2">98.2</option>
							<option value="98.4">98.4</option>
							<option value="98.6">98.6</option>
							<option value="98.8">98.8</option>
							<option value="99">99</option>
							<option value="99.2">99.2</option>
							<option value="99.4">99.4</option>
							<option value="99.6">99.6</option>
							<option value="99.8">99.8</option>
							<option value="100">100</option>
							<option value="100.2">100.2</option>
							<option value="100.4">100.4</option>
							<option value="100.6">100.6</option>
							<option value="100.8">100.8</option>
							<option value="101">101</option>
							<option value="101.2">101.2</option>
							<option value="101.4">101.4</option>
							<option value="101.6">101.6</option>
							<option value="101.8">101.8</option>
							<option value="102">102</option>
							<option value="102.2">102.2</option>
							<option value="102.4">102.4</option>
							<option value="102.6">102.6</option>
							<option value="102.8">102.8</option>
							<option value="103">103</option>
							<option value="103.2">103.2</option>
							<option value="103.4">103.4</option>
							<option value="103.6">103.6</option>
							<option value="103.8">103.8</option>
							<option value="104">104</option>
							<option value="104.2">104.2</option>
							<option value="104.4">104.4</option>
							<option value="104.6">104.6</option>
							<option value="104.8">104.8</option>
							<option value="105">105</option>
							<option value="105.2">105.2</option>
							<option value="105.2">105.4</option>
							<option value="105.6">105.6</option>
							<option value="105.8">105.8</option>
							<option value="106">106</option>
						</select> --%> <sup>&deg;</sup>F</td>
						<td><input type="text" value="" name="<%=PULSE%>1" id="<%=PULSE%>1"
							validate="Pulse,int,no"
							onchange="checkPulseIntakeValidation(this.value);" MAXLENGTH="3"
							size="5" /> /min</td>
						<td><input type="text" value="" name="<%=RESPIRATION%>1"
							id="<%=RESPIRATION%>1" validate="Respiration,int,no"
							MAXLENGTH="2" size="5" /> /min</td>
						<td><input type="text" size="3" value="" name="<%=BP%>pre1"
							id="<%=BP%>pre1"  MAXLENGTH="3" />
							mm
							<input type="text" size="3" value="" name="<%=BP%>post1"
							id="<%=BP%>post1" MAXLENGTH="3" />
							 hg
						</td>
						<td><input name="<%= BOWEL%>1" 
							id="<%= BOWEL%>1" value="" maxlength="3" size="5" /></td>
						<td><select name="<%=PAIN%>1" 
							class="small" id="<%=PAIN%>1">
							<option value="0">Select</option>
							<option value="P1">P1</option>
							<option value="P2">P2</option>
							<option value="P3">P3</option>
							<option value="P4">P4</option>
							<option value="P5">P5</option>
							<option value="P6">P6</option>
							<option value="P7">P7</option>
							<option value="P8">P8</option>
							<option value="P9">P9</option>
							<option value="P10">P10</option>
						</select></td>
						<%-- <td><input type="text" value="" size="3" name="<%=FHR%>1"
							id="<%=FHR%>1" onblur="fillClinical();" validate="Fhr,int,no"
							onchange="checkFhrValidation(this.value,'');" maxlength="3" />
						/min</td> --%>
						<td><input type="text" size="10" value=""
							name="<%=TEMPERATURE_REMARKS %>1" id="<%=TEMPERATURE_REMARKS %>1"
							validate="Remarks,remarks,no" MAXLENGTH="30" /></td>
					</tr>
			<!--	</tbody> -->
			</table>
			<input type="hidden"  name="intakeOutputIdcount" id="intakeOutputIdcount" value="1" />
			</div>
			</td>
		</tr>
	</tbody>
</table>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
 <input type="button" name="sss" class="button"
	value="Submit"
	onclick="submitClinicalChart()" />
<input type="reset" class="button" name="reset" value="reset" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
  

<script type="text/javascript">
function addRowCommonDetails(){
	var tbl = document.getElementById('intakeOutputId');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('intakeOutputIdcount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='common'+iteration;
	e1.id='common'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=TEMPERATURE_DATE%>'+iteration;
	e3.id='<%=TEMPERATURE_DATE%>'+iteration;
	e3.value='<%=dateCal+"/"+month+"/"+year%>';
	e3.size='8'
	cellRight1.appendChild(e3);
	var e2 = document.createElement('img');
	e2.width = '16';
	e2.height = '16';
	e2.src='/hms/jsp/images/cal.gif';
	e2.onclick=function(){setdate('<%=dateCal+"/"+month+"/"+year%>',e3,event)};
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE_TIME%>'+iteration;
	e1.id='<%=TEMPERATURE_TIME%>'+iteration;
	e1.size='6'
	e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='<%=time%>';
	e1.maxlength=5;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE%>'+iteration;
	e1.id='<%=TEMPERATURE%>'+iteration;
	e1.className='small';
	//e1.size='6'
	//e1.onkeyup=function(){mask(this.value,this,'2',':')};
	e1.value='';
	cellRight1.appendChild(e1);
	var e1 = document.createElement('sup');
	e1.innerHTML ='&deg;';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'F';
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=PULSE%>'+iteration;
	e1.id='<%=PULSE%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min';
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=RESPIRATION%>'+iteration;
	e1.id='<%=RESPIRATION%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='2';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min';
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BP%>pre'+iteration;
	e1.id='<%=BP%>pre'+iteration;
	//e1.className='small';
	e1.size='3'
	/* e1.onchange=function(){checkBpIntakeValidation(this.value)}; */
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'mm';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BP%>post'+iteration;
	e1.id='<%=BP%>post'+iteration;
	//e1.className='small';
	e1.size='3'
/* 	e1.onchange=function(){checkBpIntakeValidation(this.value)};*/	
	 e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + 'hg';
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=BOWEL%>'+iteration;
	e1.id='<%=BOWEL%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('select');
	e1.name='<%=BOWEL%>'+iteration;
	e1.id='<%=BOWEL%>'+iteration;
    e1.className='small';
	//e1.size='5'
	//e1.maxlength='3';
	//e1.value='';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 1;i<=10;i++ ){
	e1.options[i] = new Option('P'+i,'P'+i);
	}
	cellRight1.appendChild(e1);
	
	<%-- var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=FHR%>'+iteration;
	e1.id='<%=FHR%>'+iteration;
	//e1.className='small';
	e1.size='5'
	e1.onchange=function(){checkFhrValidation(this.value,'')};
	e1.onblur=function(){fillClinical()};
	e1.maxlength='3';
	e1.value='';
	cellRight1.appendChild(e1);
	cellRight1.innerHTML = cellRight1.innerHTML + '/min'; --%>
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=TEMPERATURE_REMARKS%>'+iteration;
	e1.id='<%=TEMPERATURE_REMARKS%>'+iteration;
	//e1.className='small';
	e1.size='10'
	e1.maxlength='30';
	e1.value='';
	cellRight1.appendChild(e1);

	}


function removeRowCommonDetails()
{
  var tbl = document.getElementById('intakeOutputId');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('intakeOutputIdcount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("common"+i)!=null && (typeof  document.getElementById("common"+i).checked)!='undefined' && document.getElementById("common"+i).checked )
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
    		  if(document.getElementById("common"+i)!=null && (typeof  document.getElementById("common"+i).checked)!='undefined' && document.getElementById("common"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("common"+i).parentNode.parentNode;
    		  document.getElementById("common"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}

function submitClinicalChart()
{
	checkValidationForCommonDetails();
	submitForm('nursingClinicalChart','ipd?method=submitNursingClinicalChart');
}


function checkValidationForCommonDetails()
{
	var count = document.getElementById('intakeOutputIdcount').value;
	for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("common"+i)!=null)
			   {
			   document.getElementById('<%=TEMPERATURE%>'+i).setAttribute("validate", "Temperature,float,no");
			   document.getElementById('<%=PULSE%>'+i).setAttribute("validate", "Pulse,int,no");
			   document.getElementById('<%=RESPIRATION%>'+i).setAttribute("validate", "Respiration,float,no");
			   document.getElementById('<%=BP%>pre'+i).setAttribute("validate", "BP,int,no");
			   document.getElementById('<%=BP%>post'+i).setAttribute("validate", "BP,int,no");
			   document.getElementById('<%=BOWEL%>'+i).setAttribute("validate", "Bowel,string,no");
			   document.getElementById('<%=PAIN%>'+i).setAttribute("validate", "Pain,string,no");
			  <%--  document.getElementById('<%=FHR%>'+i).setAttribute("validate", "Fhr,int,no"); --%>
			   document.getElementById('<%=TEMPERATURE_REMARKS%>'+i).setAttribute("validate", "Temperature Remarks,string,no");
			   if(document.getElementById('<%=TEMPERATURE%>'+i).value!='' ||
					   document.getElementById('<%=PULSE%>'+i).value!='' ||
					   document.getElementById('<%=RESPIRATION%>'+i).value!='' ||
					   document.getElementById('<%=BP%>pre'+i).value!='' ||
					   document.getElementById('<%=BP%>post'+i).value!='' ||
					   document.getElementById('<%=BOWEL%>'+i).value!='' ||
					   document.getElementById('<%=PAIN%>'+i).value!='' ||
					  <%--  document.getElementById('<%=FHR%>'+i).value!='' || --%>
					   document.getElementById('<%=TEMPERATURE_REMARKS%>'+i).value!='')
				   {
				   document.getElementById('<%=TEMPERATURE_DATE%>'+i).setAttribute("validate", "Temperature Date,date,yes");
				   document.getElementById('<%=TEMPERATURE_TIME%>'+i).setAttribute("validate", "Temperature Time,time,yes");
				   }
			   else
				   {
				   document.getElementById('<%=TEMPERATURE_DATE%>'+i).setAttribute("validate", "Temperature Date,date,no");
				   document.getElementById('<%=TEMPERATURE_TIME%>'+i).setAttribute("validate", "Temperature Time,time,no");
				   }
			   if(document.getElementById('<%=BP%>pre'+i).value!='')
				   {
				   document.getElementById('<%=BP%>post'+i).setAttribute("validate", "BP,int,yes");
				   }
			   		else  if(document.getElementById('<%=BP%>post'+i).value!='')
			  		 {
			   			document.getElementById('<%=BP%>pre'+i).setAttribute("validate", "BP,int,yes");
			  		 }
			   }
		}
}


</script>

