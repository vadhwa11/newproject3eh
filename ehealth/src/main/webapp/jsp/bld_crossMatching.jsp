<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.util.Box"%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryDetail"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cross Matching Screen</title>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
</head>
<body>

<!--Block One Starts-->
<div class="titleBg">
<h2>CROSS MATCHING</h2>
</div>
<div class="Block">
<%
Map<String, Object> map = new HashMap<String, Object>();

List<Patient> patientDetailList=new ArrayList<Patient>();
List<Inpatient> inPatient=new ArrayList<Inpatient>();


List<BloodRequestEntryDetail> requestEntryDetails=new ArrayList<BloodRequestEntryDetail>();

Map<String, Object> utilMap = new HashMap<String, Object>();utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");


	String patientName="";
	String gender="";
	String uhidNo="";
	String mobNo="";
	String adNo="";
	String doctorName="";
	String  bedNo="";
	String wardName="";
	String orderDate="";
	String requestedBy="";

	String requiredDate="";
	String crossMatchbyName="";
	int userId=0;
	
	map.put("userId", userId);
	map.put("crossMatchbyName", crossMatchbyName);

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}


List<MasBloodGroup> bloodGroupSample=new ArrayList<MasBloodGroup>();


if(map.get("bloodGroupSample") != null){
	bloodGroupSample = (List<MasBloodGroup>)map.get("bloodGroupSample");
}
if(map.get("requestEntryDetails") != null){
	requestEntryDetails = (List<BloodRequestEntryDetail>)map.get("requestEntryDetails");
}
if(map.get("userId") != null){
	userId = (Integer)map.get("userId");
}
if(map.get("crossMatchbyName") != null){
	crossMatchbyName = (String)map.get("crossMatchbyName");
}


String requestDate="";
String requestOrder="";
String bloodGroup="";
String sampleValidationDate="";
String validatedBy="";
int bldgrupId=0;
int unitNo=0;
int bloodRequestEntryHeaderId=0;
String no_of_bottel="";
String sampleValidationBy="";
String sampleValidationBloodGroup="";

int quantity=0;
String componentName="";

System.out.println();
if(null !=requestEntryDetails && requestEntryDetails.size()>0){
	for(BloodRequestEntryDetail breh:requestEntryDetails){
		
		bloodRequestEntryHeaderId=breh.getRequest().getId();
		if(null !=breh.getRequest().getOrderDate())
		requiredDate=HMSUtil.convertDateToStringWithoutTime(breh.getRequest().getOrderDate());
		
		if(null !=breh.getRequest().getDate1())
		requestDate=HMSUtil.convertDateToStringWithoutTime(breh.getRequest().getDate1());
		
		requestedBy=breh.getRequest().getLastChgBy();
		
		if(null !=breh.getRequest().getBloodGroup())
		bloodGroup=breh.getRequest().getBloodGroup().getBloodGroupName();
		
		if(null !=breh.getRequest().getBloodGroup())
		bldgrupId=breh.getRequest().getBloodGroup().getId();
		if(null !=breh.getRequest().getNoBottles() && !breh.getRequest().getNoBottles().isEmpty() )
		unitNo=Integer.parseInt(breh.getRequest().getNoBottles());
		requestOrder=breh.getRequest().getOrderNo();
		if(null !=breh.getRequest().getInpatient()){
		doctorName=breh.getRequest().getInpatient().getDoctor().getEmployeeName();
		if(null != breh.getRequest().getInpatient().getBed()) {
			bedNo=breh.getRequest().getInpatient().getBed().getBedNo();
		}
		no_of_bottel=breh.getRequest().getNoBottles();
		if(null !=breh.getRequest().getSampleValidatedBy())
		sampleValidationBy=breh.getRequest().getSampleValidatedBy().getEmployee().getEmployeeName();
		if(null !=breh.getRequest().getValidatedBloodGroup())
		sampleValidationBloodGroup=breh.getRequest().getValidatedBloodGroup().getBloodGroupName();
		
		quantity=breh.getQty();
		componentName=breh.getComponent().getComponentName();
		
		adNo=breh.getRequest().getInpatient().getAdNo();
		doctorName=breh.getRequest().getInpatient().getDoctor().getEmployeeName();
		wardName=breh.getRequest().getInpatient().getAdWard().getDepartmentName();
		

		patientName=breh.getRequest().getHin().getPFirstName();
		gender=breh.getRequest().getHin().getSex().getAdministrativeSexName();
		uhidNo=breh.getRequest().getHin().getHinNo();
		mobNo=breh.getRequest().getHin().getMobileNumber();
		
		
		}
	}
}



List<DgMasInvestigation> testlist = new ArrayList<DgMasInvestigation>();
if(request.getAttribute("map") != null){
	testlist = (List<DgMasInvestigation>)map.get("testlist");
}



%>

	<form method="post" name="crossMatching">
	<label><u>Patient Details</u></label>
	<div class="clear">
	</div>
	<div class="clear">
	</div>
	<div class="clear">
	</div>
	 <label>UHID </label> 
	 <input id="hinNo"
	name="<%=HIN_NO %>" type="text" value="<%=uhidNo %>"
	 maxlength="16"
	tabindex=1 /> 
	
	<label>Patient Name </label> 
	 <input id="idNo"
	name="patientName" type="text" value="<%=patientName %>"
	 maxlength="128"
	tabindex=1 /> 
	
	<label>Gender </label> 
	 <input id="idNo"
	name="gender" type="text" value="<%=gender %>"
	 maxlength="5"
	tabindex=1 /> 
	<input id="hinId" name="<%=HIN_ID %>" type="hidden" value="" tabindex=1 />
	
	<label>IP No. </label> 
	 <input id="idNo"
	name="adNo" type="text" value="<%=adNo %>"
	 maxlength="15"
	tabindex=1 /> 
	
	<label>Blood Group </label> 
	 <input id="idNo"
	name="blodGroup" type="text" value="<%=bloodGroup %>"
	maxlength="15"
	tabindex=1 /> 
	
	 <input id="idNo"
	name="blodGroupId" type="hidden" value="<%=bldgrupId %>"
	maxlength="15"
	tabindex=1 /> 
	
	<label>Mobile No. </label> 
	 <input id="idNo"name="mobNo" type="text" value="<%=mobNo!=null?mobNo:"" %>" maxlength="10"
	tabindex=1 />
	
	<label>Unit </label> 
	 <input id="idNo"
	name="Unit" type="text" value="<%=no_of_bottel %>"
	 maxlength="15"
	tabindex=1 />
	
	
	
	<label>Ward </label> 
	 <input id="idNo"
	name="ward" type="text" value="<%=wardName %>"
	 maxlength="10"
	tabindex=1 />
	
	<label>Bed No </label> 
	 <input id="idNo"
	name="bedNo" type="text" value="<%=bedNo %>"
	 maxlength="1"
	tabindex=1 />
	
	<label>Doctor Name </label> 
	 <input id="idNo"
	name="doctorName" type="text" value="<%=doctorName %>"
	onblur="ajaxFunctionForDonor(bloodDonationEntry);" maxlength="15"
	tabindex=1 />
	<div class="clear">
	</div>
	
	<label><u>Request Details</u></label>
	<div class="clear">
	</div>
	<div class="clear">
	</div>
	<div class="clear">
	</div>
	
	
	
	<label>Request Id No.</label> <input
	id="mobNo" name="requestOrderNo" type="text"
	 value="<%=requestOrder %>" maxlength="15" value=""
	tabindex="1" /> 
	
	<input id="bloodRequestEntryHeaderId" name="bloodRequestEntryHeaderId" type="hidden"
	 value="<%=bloodRequestEntryHeaderId %>" maxlength="15" 
	tabindex="1" /> 
	
	 <label> Request Date</label> <input
	id="donorName" type="text" name="<%= DONOR_NAME%>" value="<%=requestDate %>"
	validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1 />


<label>Requested By</label> 

<input type="text" name="requestedBy"
	value="<%=requestedBy %>" validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 />



<div class="clear"></div>
<label>Component Requested</label> 

<input type="text" name="<%= FATHER_NAME%>"
	value="<%=componentName %>" validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 />
	
	<label>Quantity</label> 

<input type="text" name="quantity"
	value="<%=quantity %>" validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 />
	
	<label>Unit</label> 

<input type="text" name="unit"
	value="<%=unitNo %>"  MAXLENGTH="20" tabindex=1 />
	
	<label>Blood Required Date</label> 

<input type="text" name="bldrequiredDate"
	value="<%=requiredDate %>"  MAXLENGTH="20" tabindex=1 />
	
<div class="clear">
	</div>
	
	
<label><u>Sample Details</u></label>
	<div class="clear">
	</div>
	<div class="clear">
	</div>	
	
<label>Sample Validation No.</label> 

<input type="text" name="SampleValidationNo"
	value="<%=requestOrder %>"   MAXLENGTH="20" tabindex=1 />
		
<label>Sample Validation Date</label> 

<input type="text" name="sampleValidationDate" value="<%=requiredDate %>"  MAXLENGTH="20" tabindex=1 />
		
 <label>Validated By</label> 
<input type="text" name="sampleValidationBy" value="<%=sampleValidationBy %>"  MAXLENGTH="20" tabindex=1 />
	

 <label>Blood Group Validated</label> 
	<input type="text" name="sampleValidationBy" value="<%=sampleValidationBloodGroup %>"  MAXLENGTH="20" tabindex=1 />
	<div class="clear"></div>
	
	<label><u>Cross Match Details</u></label> 
	<div class="clear"></div>
	
	<label >Cross Match Date</label> 

	<input type="text" class="date" id="lastDateId"
	name="currentDate"  value="<%=currentDate %>"
	validate="" MAXLENGTH="14" tabindex="1" /> 
	
 
 <label>Cross Match Time</label> 
<input type="text" name="time"
	value="<%=time %>" validate="" MAXLENGTH="20" tabindex=1 />

<label>Blood Group Sample<span>*</span></label>
<select name="source" validate="Blood Bag,string,yes" onchange="populateBloodBags(this.value)">
<option value="">Select</option>
<%
if(null !=bloodGroupSample && bloodGroupSample.size()>0){
	for(MasBloodGroup mbgs:bloodGroupSample){
%>

<option value="<%=mbgs.getId()%>"><%=mbgs.getBloodGroupName()%></option>
<%}} %>
</select>
 <div class="clear"></div>

<label>Blood Bags<span>*</span></label>
<select name="source" id="stockBags" validate="Blood Bag,string,yes" onchange="populateBagDetails(this.value)">
<option value="">Select</option>
</select>
<div class="clear"></div>

<div class="clear"></div>
<!-- <div class="tableHolderAuto"> -->
<%
if(null != testlist && testlist.size()>0){
	%>
<div class="tableForTab" style="width:1100px; height:252px; overflow: scroll;">
<table id="testListID" width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			 
			<th>Name Of Test</th>
			<th>Result</th>
			<!-- <th><span>*</span>Result</th> -->
		</tr>
	</thead>
	<tbody>
	
			<% 	for(DgMasInvestigation dmi:testlist){
%>
			
		<tr>
			
			<td>
			<input type="text" size="50" id="investigationName"
				name="investigationName" value="<%=dmi.getInvestigationName() %>" />
				<!-- onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" /> -->

		<input type="hidden" size="20" id="investigationName"
				name="crossInvestName" value="<%=dmi.getId() %>" />
				<!-- onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" /> -->

			
			<td>
			<select  name="investigationNameResult">
			<option value="">select</option>
			<option value="reactive">Reactive</option>
			<option value="Nonreactive">NonReactive</option>
			</select> 
			</td></tr>
	<%} %>
		
		
	</tbody>
</table>
<%} %>
</div>


<div class="clear"></div>
<!-- <div class="division"></div> -->
<input type="button" class="button" value="Other Test"
	onclick="SelectName()"
	align="right" tabindex=1 /> 
	
<input type="Save" class="button" value="Save"
	onclick="addbagsIntable('bagsDetailsId')"
	align="right" tabindex=1 /> 
		
	<div class="clear"></div>
	
	<div class="clear"></div>


<label>Cross Match By</label>

<input type="text" name="crossMatchbyName" id="crossMatchbyName" value="<%=crossMatchbyName %>" readonly="readonly" />
<input type="hidden" name="userId" id="userId" value="<%=userId %>" />

	<div class="clear"></div>
	<td><input type="hidden" name="bagnumberId" id="bagnumberId" /></td>
	<td><input type="hidden" name="bldgrp" id="bldgrpId" /></td>
	<td><input type="hidden" name="comp" id="compId" /></td>
	<td><input type="hidden" name="quant" id="quantId" /></td>
	<td><input type="hidden" name="expiry" id="expiryId	" /></td>
	<hr>
	<div class="clear"></div>
	
<table width="100%" colspan="7" id="" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			 
			 <th>Blood Bag</th>
			<th>Blood Group</th>
			<th>Component Name</th>
			<th>Quantity(ml)</th>
			<th>Expiry Date</th>
		</tr>
	</thead>
	</table>
	<table width="100%" colspan="7" id="bagsDetailsId" cellpadding="0"
	cellspacing="0">
	<tbody>
	<tr>
	<td><input type="text"  readonly="readonly" name="bagnumberI" validate="Bag,string,yes" id="bagnumberI" /></td>
	<td><input type="text"  readonly="readonly" name="bldgrp" id="bldgrpI"  validate="Blood Group,string,yes"/></td>
	<td><input type="text"  readonly="readonly" name="comp" id="compI" validate="Blood Component,string,yes"/></td>
	<td><input type="text" name="quantt" id="quantI"  validate="Quantity,string,yes"/></td>
	<td><input type="text" name="expiry" id="expiryI" /></td>
	</tr>
	</tbody>
	</table>
<div class="clear"></div>
<hr>
<div class="clear"></div>

    	
    	<script language="javascript">
		function addbagsIntable(tableID) {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);
			var colCount = table.rows[0].cells.length;
			//alert(rowCount)
			if(rowCount>1){
			for (var i = 0; i < colCount; i++) {
				var newcell = row.insertCell(i);
				newcell.innerHTML = table.rows[0].cells[i].innerHTML;
				
				
			}
			document.getElementById("bagnumberI").value=document.getElementById("bagnumberId").value;
			document.getElementById("bldgrpI").value=document.getElementById("bldgrpId").value;
			document.getElementById("compI").value=document.getElementById("compId").value;
			document.getElementById("quantI").value=document.getElementById("quantId").value;
			document.getElementById("expiryI").value=document.getElementById("expiryId	").value;
		}
			else{ 
				document.getElementById("bagnumberI").value=document.getElementById("bagnumberId").value;
				document.getElementById("bldgrpI").value=document.getElementById("bldgrpId").value;
				document.getElementById("compI").value=document.getElementById("compId").value;
				document.getElementById("quantI").value=document.getElementById("quantId").value;
				document.getElementById("expiryI").value=document.getElementById("expiryId	").value;
			}
			
		}
    </script>

<label>Remarks</label> 
	
<textarea style="height:50px; width: 200px;">
</textarea>
<div class="clear"></div>
<!-- <div class="division"></div> -->

<input type="button" class="button" value="save"
	onclick="submitForm('crossMatching','/hms/hms/bloodBank?method=saveCrossMatching');"
	align="right" tabindex=1 /> 
	
<input type="button" class="button" value="Reset"
	onclick="{submitForm('bloodDonationEntry','bloodBank?method=submitBloodDonationEntry');}"
	align="right" tabindex=1 /> 
	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	 
</div>
 <div class="clear"></div>
<div class="paddingTop40"></div>
 
</body>
<script type="text/javascript">
var popup;
function SelectName() {
    popup = window.open("/hms/hms/bloodBank?method=showBloodTestList&crossMatch=Yes", "Popup", "width=500,height=350");
    popup.focus();
}
</script>
</html>