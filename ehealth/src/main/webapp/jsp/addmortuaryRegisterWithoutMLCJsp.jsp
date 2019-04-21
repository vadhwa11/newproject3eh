<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.MortuaryRegisterDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'		
	</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	} 
	List<Discharge> discharge=new ArrayList<Discharge>();
	 List<MortuaryRegisterDetails> mortuaryRegisterList = new ArrayList<MortuaryRegisterDetails>();
	 if(map.get("discharge") != null){
		 discharge =(List<Discharge>)map.get("discharge");
		}
	 
	 List<OpdPatientDetails> opdPatientDetails=new ArrayList<OpdPatientDetails>();
	 if(map.get("opdPatientDetails") != null){
		 opdPatientDetails =(List<OpdPatientDetails>)map.get("opdPatientDetails");
		}
	 if(map.get("mortuaryRegisterList") != null){
		 mortuaryRegisterList =(List<MortuaryRegisterDetails>)map.get("mortuaryRegisterList");
		}
	 
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	int empId  = 0;
	String empName = "";
	if(map.get("empId") != null){
		empId = (Integer)map.get("empId");
	}
	if(map.get("empName") != null){
		empName = (String)map.get("empName");
	}
	MortuaryRegisterDetails mortuaryRegisterDetails = new MortuaryRegisterDetails();
	
	if(mortuaryRegisterList.size()>0){
		mortuaryRegisterDetails = (MortuaryRegisterDetails)mortuaryRegisterList.get(0);
	}
	System.out.println("mortuaryRegisterList=========================="+mortuaryRegisterList.size());
	String stringOrderNo = "";
	if(map.get("stringOrderNo") != null){
		stringOrderNo = (String)map.get("stringOrderNo");
	}
  
	   %>
	<% if(msg!=null) {%>
	   <h4><span><%=msg %></span></h4>
         <%}%>	
<form name="mortuaryRegister" method="post" action="">
<%if(discharge.size() >0){%>
<div class="titleBg">
<h2> Mortuary Register</h2>
</div>
<div class="Block">
<h4 style="margin-top:0px;"><span><%=msg %></span></h4>

<!-- <div class="titleBg">
<h4>Search</h4>
</div> -->

<input type="hidden" name="hin_Id" id="hin_Id" value="<%=discharge.get(0).getHin().getId() %>" >

<label>UHID</label> 
<!-- <input type="text"  name="hinNo" id="hinNo" onblur="getMedicoLegalDetails(this.value);"> -->
<%if(discharge.size() >0){ %>
<input type="text" readonly="readonly"  name="hinNo" id="hinNo" value="<%=discharge.get(0).getHin().getHinNo()!=null?discharge.get(0).getHin().getHinNo():"" %>" >
<%}else{ %>
<input type="text" name="hinNo" id="hinNo" value="" >
<%} %>
</div>
<div class="Block">
<label>SL. No.</label>
<input type="text"  name="slNo" id="slNo" value="<%=stringOrderNo != null?stringOrderNo:""%>">
<label>Date</label>
<input type="text" readonly="readonly" name="date" id="date" value="<%=currentDate%>" class="date">
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.date,event);" />
<label>Time</label>
<input type="text" readonly="readonly"  name="time" id="time" value="<%=time%>" maxlength="5" onkeyup="mask(this.value,this,'2',':');">


<div class="clear"></div>

<label>Deceased Name</label>
<%if(discharge.size() >0){ %>
<input type="text" readonly="readonly"  name="deceasedName" id="deceasedName" value="<%=discharge.get(0).getHin().getFullName()!=null?discharge.get(0).getHin().getFullName():"" %>">
<%}else{ %>
<input type="text"  name="deceasedName" id="deceasedName" value="">
<%} %>
<input type="hidden"  name="dischargeId" id="dischargeId" value="<%= discharge.get(0).getId()%>"> 
<input type="hidden"  name="pType" id="pType" value="IP"> 

<label>Age</label>
<%if(discharge.size() >0){ %>
<input type="text" readonly="readonly"  name="age" id="age" value="<%=discharge.get(0).getHin().getAge()!=null?discharge.get(0).getHin().getAge():"" %>">
<%}else{ %>
<input type="text" name="age" id="age" value="">
<%} %>
<label>Sex</label>
<%if(discharge.size() >0){ %>
<input type="text" readonly="readonly" name="gender" id="gender" value="<%=discharge.get(0).getHin().getSex().getAdministrativeSexName()!=null?discharge.get(0).getHin().getSex().getAdministrativeSexName():"" %>">
<%}else{ %>
<input type="text"  name="gender" id="gender" value="" >
<%} %>
<div class="clear"></div>

<label>Address</label>
<textarea name="address" id="address" value = "" validate="address,string,no"  cols="0" rows="0" class="textareaMediua"></textarea>

<label> Cause of Death</label>
<input type="text"  name="causeOfDeath" id = "causeOfDeath" value="<%=mortuaryRegisterDetails.getCauseOfDeath() != null?mortuaryRegisterDetails.getCauseOfDeath():"" %>" maxlength="96"/>
<label>Deceased was brought By</label>
<input type="text"  name="deceasedBroughtBy" id="deceasedBroughtBy" value="<%=mortuaryRegisterDetails.getDeceasedBroughtBy() != null?mortuaryRegisterDetails.getDeceasedBroughtBy():"" %>" maxlength=""/>

<div class="clear"></div>

<label>Brought from</label>
<input type="text"  name="deceasedBroughtFrom" id = "deceasedBroughtFrom" value="<%=mortuaryRegisterDetails.getDeceasedBroughtFrom()!= null?mortuaryRegisterDetails.getDeceasedBroughtFrom():"" %>" />

<label>Body kept in Mortuary Time</label>
<input type="text"  name="bodyKeptInMortuaryTime" id="name" value = "<%=mortuaryRegisterDetails.getDeadBodyKeptTime() != null?mortuaryRegisterDetails.getDeadBodyKeptTime():"" %>" maxlength="5" onkeyup="mask(this.value,this,'2',':');">

<label>Body kept in Mortuary Date</label>

<input 	type="text" name="bodyKeptInMortuaryDate" value="<%=mortuaryRegisterDetails.getDeadBodyKeptDate() != null?mortuaryRegisterDetails.getDeadBodyKeptDate():currentDate %>" class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.bodyKeptInMortuaryDate,event);" />


<div class="clear"></div>

<label>Intimation Given To.</label>
<Select name ="intimationGivenTo">
<%
if(mortuaryRegisterDetails.getInitimationGiven() != null){
 if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Police")){ %>
	<option value="">Select</option>
	<option value="Police" selected="selected">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Corporation")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation" selected="selected">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Panchayat")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat" selected="selected">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Relatives")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives" selected="selected">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Not Necessary")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary" selected="selected">Not Necessary</option>
	<%}}else{ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
	<%} %>
</Select>

<label>Articles on the body</label>
<textarea name="articlesOnBody" id="articlesOnBody" value = "" validate="address,string,no"  cols="0" rows="0"  maxlength="122" class="textareaMediua"><%=mortuaryRegisterDetails.getArticlesOnBody()!= null?mortuaryRegisterDetails.getArticlesOnBody():"" %></textarea>

<label>Other Remarks</label>
<textarea name="otherRemarks" id="otherRemarks" value = "" validate="address,string,no"  cols="0" rows="0"  maxlength="122" class="textareaMediua"><%=mortuaryRegisterDetails.getMortuaryRegRemarks()!= null?mortuaryRegisterDetails.getMortuaryRegRemarks():"" %></textarea>


<label>Body Handed Over to  </label>
<Select name ="bodyHandedOverTo" id = "bodyHandedOverTo">
<%if(mortuaryRegisterDetails.getBodyHandedOver()!= null){
	if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Legal Heir")){%>
	<option value="">Select</option>
	<option value="Legal Heir" selected="selected">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Police")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police" selected="selected">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Academic Institutions")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions" selected="selected">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Hospital")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital" selected="selected">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Local body Authorities")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities" selected="selected">Local body Authorities</option>
	<%}}else{ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%} %>
</Select>




<label>Body Handed Over Time  </label>
<input type="text"  name="bodyHandedOverTime" id = "bodyHandedOverTime" value="<%=mortuaryRegisterDetails.getHandOverTime()!= null?mortuaryRegisterDetails.getHandOverTime():"" %>" maxlength="5" onkeyup="mask(this.value,this,'2',':');"/>


<label>Body Handed Over Date  </label>
<input 	type="text" name="bodyHandedOverDate" value="<%=mortuaryRegisterDetails.getHandOverDate()!= null?mortuaryRegisterDetails.getHandOverDate():currentDate %>" class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.bodyHandedOverDate,event);" />

<div class="clear"></div>
<label>Cremation/Burial by </label>
<Select name ="cremation" id="cremation">
<%if(mortuaryRegisterDetails.getCremation()!= null){ 
if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Legal Heir")){%>
	<option value="">Select</option>
	<option value="Legal Heir" selected="selected">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Inquest")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest" selected="selected">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Academic Purpose")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose" selected="selected">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Disposal")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal" selected="selected">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Hospital")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital" selected="selected">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Local body Authorities")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities" selected="selected">Local body Authorities</option>
	<%}}else{%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%} %>
</Select>


<label>Received dead body of </label>
<input type="text"  name="receivedDeadBodyOf" id="receivedDeadBodyOf"   value=""/>

<label>Received dead body aged(years) </label>
<input type="text"  name="receivedDeadBodyAged" id = "receivedDeadBodyAged" value="" />


<div class="clear"></div>

<label>Received dead body Time </label>
<input type="text"  name="receivedDeadBodyTime" id = "receivedDeadBodyTime" value="<%=mortuaryRegisterDetails.getBodyReceivedTime()!= null?mortuaryRegisterDetails.getBodyReceivedTime():""%>"  maxlength="5" onkeyup="mask(this.value,this,'2',':');"/>


<label>Received dead body Date </label>
<input type="text"  name="receivedDeadBodyDate" id="receivedDeadBodyDate" value="<%=mortuaryRegisterDetails.getBodyReceivedTime()!= null?mortuaryRegisterDetails.getBodyReceivedTime():currentDate%>" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.receivedDeadBodyDate,event);" />




<label>Receiving By</label>
<input type="text"  name="receivingBy" id="receivingBy" value="<%=empName %>" />
<input type="hidden"  name="receivingById" id="receivingById" value="<%=empId %>" />

<div class="clear"></div>
<div class="clear"></div>

<%
if(mortuaryRegisterDetails.getStatus()!= null && !mortuaryRegisterDetails.getStatus().equals("")){
if(mortuaryRegisterDetails.getStatus().equalsIgnoreCase("m")){ %>

<%}}else{%>
<input type="button" name="Submit" id="Submit" value="Save" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=save');" accesskey="a" tabindex=1 />
<input type="button" name="Submit" id="Submit" value="Submit" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=submit');" accesskey="a" tabindex=1 />

<%}}%>
<%if(opdPatientDetails.size() >0){%>
<div class="titleBg">
<h2> Mortuary Register</h2>
</div>
<div class="Block">
<h4 style="margin-top:0px;"><span><%=msg %></span></h4>

<!-- <div class="titleBg">
<h4>Search</h4>
</div> -->

<input type="hidden" name="hin_Id" id="hin_Id" value="<%=opdPatientDetails.get(0).getVisit().getHin().getId() %>" >

<label>UHID</label> 
<!-- <input type="text"  name="hinNo" id="hinNo" onblur="getMedicoLegalDetails(this.value);"> -->
<%if(opdPatientDetails.size() >0){ %>
<input type="text" readonly="readonly"  name="hinNo" id="hinNo" value="<%=opdPatientDetails.get(0).getVisit().getHin().getHinNo()!=null?opdPatientDetails.get(0).getVisit().getHin().getHinNo():"" %>" >
<%}else{ %>
<input type="text" name="hinNo" id="hinNo" value="" >
<%} %>
</div>
<div class="Block">
<label>SL. No.</label>
<input type="text"  name="slNo" id="slNo" value="<%=stringOrderNo != null?stringOrderNo:""%>">
<label>Date</label>
<input type="text" readonly="readonly" name="date" id="date" value="<%=currentDate%>" class="date">
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.date,event);" />
<label>Time</label>
<input type="text" readonly="readonly"  name="time" id="time" value="<%=time%>" maxlength="5" onkeyup="mask(this.value,this,'2',':');">


<div class="clear"></div>

<label>Deceased Name</label>
<%if(opdPatientDetails.size() >0){ %>
<input type="text" readonly="readonly"  name="deceasedName" id="deceasedName" value="<%=opdPatientDetails.get(0).getVisit().getHin().getFullName()!=null?opdPatientDetails.get(0).getVisit().getHin().getFullName():"" %>">
<%}else{ %>
<input type="text"  name="deceasedName" id="deceasedName" value="">
<%} %>
<input type="hidden"  name="opdPatientDetailId" id="opdPatientDetailId" value="<%= opdPatientDetails.get(0).getId()%>"> 
<input type="hidden"  name="pType" id="pType" value="OP" /> 

<label>Age</label>
<%if(opdPatientDetails.size() >0){ %>
<input type="text" readonly="readonly"  name="age" id="age" value="<%=opdPatientDetails.get(0).getVisit().getHin().getAge()!=null?opdPatientDetails.get(0).getVisit().getHin().getAge():"" %>">
<%}else{ %>
<input type="text" name="age" id="age" value="">
<%} %>
<label>Sex</label>
<%if(opdPatientDetails.size() >0){ %>
<input type="text" readonly="readonly" name="gender" id="gender" value="<%=opdPatientDetails.get(0).getVisit().getHin().getSex().getAdministrativeSexName()!=null?opdPatientDetails.get(0).getVisit().getHin().getSex().getAdministrativeSexName():"" %>">
<%}else{ %>
<input type="text"  name="gender" id="gender" value="" >
<%} %>
<div class="clear"></div>

<label>Address</label>
<textarea name="address" id="address" value = "" validate="address,string,no"  cols="0" rows="0" class="textareaMediua"></textarea>

<label> Cause of Death</label>
<input type="text"  name="causeOfDeath" id = "causeOfDeath" value="<%=mortuaryRegisterDetails.getCauseOfDeath() != null?mortuaryRegisterDetails.getCauseOfDeath():"" %>" maxlength="96"/>
<label>Deceased was brought By</label>
<input type="text"  name="deceasedBroughtBy" id="deceasedBroughtBy" value="<%=mortuaryRegisterDetails.getDeceasedBroughtBy() != null?mortuaryRegisterDetails.getDeceasedBroughtBy():"" %>" maxlength=""/>

<div class="clear"></div>

<label>Brought from</label>
<input type="text"  name="deceasedBroughtFrom" id = "deceasedBroughtFrom" value="<%=mortuaryRegisterDetails.getDeceasedBroughtFrom()!= null?mortuaryRegisterDetails.getDeceasedBroughtFrom():"" %>" />

<label>Body kept in Mortuary Time</label>
<input type="text"  name="bodyKeptInMortuaryTime" id="name" value = "<%=mortuaryRegisterDetails.getDeadBodyKeptTime() != null?mortuaryRegisterDetails.getDeadBodyKeptTime():"" %>" maxlength="5" onkeyup="mask(this.value,this,'2',':');">

<label>Body kept in Mortuary Date</label>
<input 	type="text" name="bodyKeptInMortuaryDate" value="<%=mortuaryRegisterDetails.getDeadBodyKeptDate() != null?mortuaryRegisterDetails.getDeadBodyKeptDate():currentDate %>" class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.bodyKeptInMortuaryDate,event);" />


<div class="clear"></div>

<label>Intimation Given To.</label>
<Select name ="intimationGivenTo">
<%
if(mortuaryRegisterDetails.getInitimationGiven() != null){
 if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Police")){ %>
	<option value="">Select</option>
	<option value="Police" selected="selected">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Corporation")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation" selected="selected">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Panchayat")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat" selected="selected">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Relatives")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives" selected="selected">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
<%}else if(mortuaryRegisterDetails.getInitimationGiven().equalsIgnoreCase("Not Necessary")){ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary" selected="selected">Not Necessary</option>
	<%}}else{ %>
	<option value="">Select</option>
	<option value="Police">Police</option>
	<option value="Corporation">Corporation</option>
	<option value="Panchayat">Panchayat</option>
	<option value="Relatives">Relatives</option>
	<option value="Not Necessary">Not Necessary</option>
	<%} %>
</Select>

<label>Articles on the body</label>
<textarea name="articlesOnBody" id="articlesOnBody" value = "" validate="address,string,no"  cols="0" rows="0"  maxlength="122" class="textareaMediua"><%=mortuaryRegisterDetails.getArticlesOnBody()!= null?mortuaryRegisterDetails.getArticlesOnBody():"" %></textarea>

<label>Other Remarks</label>
<textarea name="otherRemarks" id="otherRemarks" value = "" validate="address,string,no"  cols="0" rows="0"  maxlength="122" class="textareaMediua"><%=mortuaryRegisterDetails.getMortuaryRegRemarks()!= null?mortuaryRegisterDetails.getMortuaryRegRemarks():"" %></textarea>


<label>Body Handed Over to  </label>
<Select name ="bodyHandedOverTo" id = "bodyHandedOverTo">
<%if(mortuaryRegisterDetails.getBodyHandedOver()!= null){
 if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Legal Heir")){%>
	<option value="">Select</option>
	<option value="Legal Heir" selected="selected">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Police")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police" selected="selected">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Academic Institutions")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions" selected="selected">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Hospital")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital" selected="selected">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
<%}else if(mortuaryRegisterDetails.getBodyHandedOver().equalsIgnoreCase("Local body Authorities")){ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities" selected="selected">Local body Authorities</option>
	<%}}else{ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Police">Police</option>
	<option value="Academic Institutions">Academic Institutions</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%} %>
</Select>




<label>Body Handed Over Time  </label>
<input type="text"  name="bodyHandedOverTime" id = "bodyHandedOverTime" value="" maxlength="5" onkeyup="mask(this.value,this,'2',':');"/>


<label>Body Handed Over Date  </label>
<input 	type="text" name="bodyHandedOverDate" value="<%=currentDate%>" class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.bodyHandedOverDate,event);" />

<div class="clear"></div>
<label>Cremation/Burial by </label>
<Select name ="cremation" id="cremation">
<%if(mortuaryRegisterDetails.getCremation()!= null){
 if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Legal Heir")){%>
	<option value="">Select</option>
	<option value="Legal Heir" selected="selected">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Inquest")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest" selected="selected">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Academic Purpose")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose" selected="selected">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Disposal")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal" selected="selected">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Hospital")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital" selected="selected">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%}else if(mortuaryRegisterDetails.getCremation().equalsIgnoreCase("Local body Authorities")){%>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities" selected="selected">Local body Authorities</option>
	<%}}else{ %>
	<option value="">Select</option>
	<option value="Legal Heir">Legal Heir</option>
	<option value="Inquest">Inquest</option>
	<option value="Academic Purpose">Academic Purpose</option>
	<option value="Disposal">Disposal</option>
	<option value="Hospital">Hospital</option>
	<option value="Local body Authorities">Local body Authorities</option>
	<%} %>
</Select>


<label>Received dead body of </label>
<input type="text"  name="receivedDeadBodyOf" id="receivedDeadBodyOf"   value=""/>

<label>Received dead body aged(years) </label>
<input type="text"  name="receivedDeadBodyAged" id = "receivedDeadBodyAged" value="" />


<div class="clear"></div>

<label>Received dead body Time </label>
<input type="text"  name="receivedDeadBodyTime" id = "receivedDeadBodyTime" value="<%=mortuaryRegisterDetails.getBodyReceivedTime()!= null?mortuaryRegisterDetails.getBodyReceivedTime():""%>"  maxlength="5" onkeyup="mask(this.value,this,'2',':');"/>


<label>Received dead body Date </label>
<input type="text"  name="receivedDeadBodyDate" id="receivedDeadBodyDate" value="<%=mortuaryRegisterDetails.getBodyReceivedTime()!= null?mortuaryRegisterDetails.getBodyReceivedTime():currentDate%>" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.mortuaryRegister.receivedDeadBodyDate,event);" />




<label>Receiving By</label>
<input type="text"  name="receivingBy" id="receivingBy" value="<%=empName %>" />
<input type="hidden"  name="receivingById" id="receivingById" value="<%=empId %>" />

<div class="clear"></div>
<div class="clear"></div>

<%
if(mortuaryRegisterDetails.getStatus()!= null && !mortuaryRegisterDetails.getStatus().equals("")){%>
	
<input type="button" name="Submit" id="Submit" value="Save" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=save');" accesskey="a" tabindex=1 />
<input type="button" name="Submit" id="Submit" value="Submit" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=submit');" accesskey="a" tabindex=1 />
<%}else if(mortuaryRegisterDetails.getStatus()!= null && mortuaryRegisterDetails.getStatus().equalsIgnoreCase("m")){ %>

<%}else{%>
<input type="button" name="Submit" id="Submit" value="Save" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=save');" accesskey="a" tabindex=1 />
<input type="button" name="Submit" id="Submit" value="Submit" class="buttonBig" onClick="submitForm('mortuaryRegister','adt?method=submitMortuaryRegisterWithoutMLC&flagStatus=submit');" accesskey="a" tabindex=1 />

<%}}%>
<script>

function getMedicoLegalDetails(val)
{
	ajaxFunctionForMortuaryRegisterDetails('mortuaryRegister','mlc?method=getMedicoLegalDetailsForMortuary&hinNo='+val);
		
}  

</script>
</div> 	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







