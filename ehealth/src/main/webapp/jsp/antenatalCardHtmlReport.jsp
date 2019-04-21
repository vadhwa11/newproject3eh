<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
   
<%@page import="jkt.hms.masters.business.OpdAntenatalUsg"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardPregnancy"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardMedicalHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardTrimester"%>
<%@page import="jkt.hms.masters.business.ExternalAdmissionDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Antenatal Card</title>

<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>
<link href="/hms/jsp/css/--style.css?n=1" rel="stylesheet" type="text/css" />

<style>
body {font-family: arial, tahoma;}

.reportMainDiv {width: 1024px;
height: auto;
background: #fff;
margin:0 auto;

}

label.mainlbl {
	font-weight: bold;
	font-size: 18px;
	height:24px;
	line-height:25px;
	color: #010101;
	width: 170px;
	float: left;
	text-align: left;
	padding:0px 0px 0px 5px;
	margin:0px 5px 5px 5px;
	}

label.mainlblAuto {
	font-weight: bold;
	font-size:16px;
	height:24px;
	line-height:25px;
	color: #010101;
	width: auto;
	float: left;
	text-align: left;
	padding:0px;
	margin:0px;
	}



label.value {
	font-size: 18px;
	font-weight:normal;
	color: #010101;
	width: 190px;
	height: 23px;
	float: left;
	text-align: left;
	padding: 2px 5px 0px 3px;
	margin: 0px 0px 0px 0px;
}
label.valueAuto {
	font-size:16px;
	font-weight:normal;
	color: #010101;
	width: auto;
	height: 23px;
	float: left;
	text-align: left;
	padding:5px 5px 0px 3px;
	margin: 0px 0px 0px 0px;
}

label.auto {
	font-weight: bold;
	font-size: 12px;	
	width: auto;
	height:19px;
	float: left;
	text-align: left;
	padding: 5px 5px 0px 5px;
	margin: 0px 4px 0px 4px;
}
.clear, .Clear{
	clear: both;
	overflow: hidden;
	padding: 0px;
	margin: 0px;
	height: 1px;
}

.headerDiv
{
background: #aaa;
 width:100%; 
float:left;
}

table {border-collapse:collapse; width:100%;}
table th{border:solid 1px #000; text-align: left;}
table td{ border:solid 1px #000; text-align: left;}

@page {
    size: auto;   
    margin-top: 0;  
    margin-bottom: 0;
}

h4{border-bottom: 2px solid #ccc;
    padding-bottom: 3px;}
    
    
    
    
</style>



<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map)request.getAttribute("map");

}
List<OpdAntenatalCard> lastPrescription= new ArrayList<OpdAntenatalCard>();
String startDate="";
if (map.get("ancList") != null) {
	lastPrescription = (List)map.get("ancList");
}
String uhid =null;
String age = "";
int visitNo=0;
String department=null;
String name=null;
String bloodGroup=null;
	Date dateOfBirth=null;
String bloodGroupStatus=null;
String confirmedBloodStatus=null;
String verbalBloodtatus=null;
for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){
	if(OpdAntenatalCard.getHin()!=null){
	Patient p = OpdAntenatalCard.getHin();
	uhid = p.getHinNo();  
	age= p.getAge();
	name=p.getFullName();
	dateOfBirth= p.getDateOfBirth();
	bloodGroup=p.getBloodGroupValue();
	confirmedBloodStatus=p.getConfirmedStatus();
	verbalBloodtatus=p.getVerbalStatus();
    if(OpdAntenatalCard.getDepartment()!=null){
	department=OpdAntenatalCard.getDepartment().getDepartmentName();
	visitNo = OpdAntenatalCard.getVisit().getVisitNo();
	}
	}
	break;
}

List<OpdAntenatalUsg> usgFirstTrimGrid1DateListFirstVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid1DateListSecondVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid1DateListThirdVisit= new ArrayList<OpdAntenatalUsg>();

if(map.get("usgFirstTrimGrid1DateListFirstVisit") != null){
	usgFirstTrimGrid1DateListFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid1DateListFirstVisit");
}

if(map.get("usgFirstTrimGrid1DateListSecondVisit") != null){
	usgFirstTrimGrid1DateListSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid1DateListSecondVisit");
}
if(map.get("usgFirstTrimGrid1DateListThirdVisit") != null){
	usgFirstTrimGrid1DateListThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid1DateListThirdVisit");
}

String usgFlag="";
if(usgFirstTrimGrid1DateListFirstVisit.size() >0){
for(OpdAntenatalUsg usgFlagS:usgFirstTrimGrid1DateListFirstVisit){
usgFlag = usgFlagS.getUsgFlag();
break;
}
}

String usgFlagSecondV="";
if(usgFirstTrimGrid1DateListSecondVisit.size() >0){
for(OpdAntenatalUsg usgFlagS:usgFirstTrimGrid1DateListSecondVisit){
	usgFlagSecondV = usgFlagS.getUsgFlag();
	break;
}
}


String usgFlagThirdV="";
if(usgFirstTrimGrid1DateListThirdVisit.size() >0){
for(OpdAntenatalUsg usgFlagT:usgFirstTrimGrid1DateListThirdVisit){
	usgFlagThirdV = usgFlagT.getUsgFlag();
}
}

List<OpdAntenatalUsg> usgFirstTrimGrid2DateListFirstVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid2DateListSecondVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid2DateListThirdVisit= new ArrayList<OpdAntenatalUsg>();

if(map.get("usgFirstTrimGrid2DateListFirstVisit") != null){
	usgFirstTrimGrid2DateListFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListFirstVisit");
}

if(map.get("usgFirstTrimGrid2DateListSecondVisit") != null){
	usgFirstTrimGrid2DateListSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListSecondVisit");
}
if(map.get("usgFirstTrimGrid2DateListThirdVisit") != null){
	usgFirstTrimGrid2DateListThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListThirdVisit");
}


String usgFlagSecondGrid="";
if(usgFirstTrimGrid2DateListFirstVisit.size() >0){
for(OpdAntenatalUsg usgFlagSG:usgFirstTrimGrid2DateListFirstVisit){
usgFlagSecondGrid = usgFlagSG.getUsgFlag();
break;
}
}

String usgFlagSecondVgrid2="";
if(usgFirstTrimGrid2DateListSecondVisit.size() >0){
for(OpdAntenatalUsg usgFlagSG:usgFirstTrimGrid2DateListSecondVisit){
	usgFlagSecondVgrid2 = usgFlagSG.getUsgFlag();
	break;
}
}


String usgFlagThirdVSecondgrid="";
if(usgFirstTrimGrid2DateListThirdVisit.size() >0){
for(OpdAntenatalUsg usgFlagT2:usgFirstTrimGrid2DateListThirdVisit){
	usgFlagThirdVSecondgrid = usgFlagT2.getUsgFlag();
}
}


List<OpdAntenatalUsg> usgSecondTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgSecondTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgSecondTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();

if(map.get("usgSecondTrimFirstVisitList") != null){
	usgSecondTrimFirstVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimFirstVisitList");
}
if(map.get("usgSecondTrimSecondVisitList") != null){
	usgSecondTrimSecondVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimSecondVisitList");
}
if(map.get("usgSecondTrimThirdVisitList") != null){
	usgSecondTrimThirdVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimThirdVisitList");
}


String usgFlagSecondTrimV1="";
if(usgSecondTrimFirstVisitList.size() >0){
for(OpdAntenatalUsg usgFlagST1:usgSecondTrimFirstVisitList){
	usgFlagSecondTrimV1 = usgFlagST1.getUsgFlag();
break;
}
}

String usgFlagSecondTrimV2="";
if(usgSecondTrimSecondVisitList.size() >0){
for(OpdAntenatalUsg usgFlagST2:usgSecondTrimSecondVisitList){
	usgFlagSecondTrimV2 = usgFlagST2.getUsgFlag();
	break;
}
}


String usgFlagSecondTrimV3="";
if(usgSecondTrimThirdVisitList.size() >0){
for(OpdAntenatalUsg usgFlagST3:usgSecondTrimThirdVisitList){
	usgFlagSecondTrimV3 = usgFlagST3.getUsgFlag();
}
}


List<OpdAntenatalUsg> usgThirdTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgThirdTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg>  usgThirdTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();
if(map.get("usgThirdTrimFirstVisitList") != null){
	usgThirdTrimFirstVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimFirstVisitList");
}
if(map.get("usgThirdTrimSecondVisitList") != null){
	usgThirdTrimSecondVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimSecondVisitList");
}
if(map.get("usgThirdTrimThirdVisitList") != null){
	usgThirdTrimThirdVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimThirdVisitList");
}



String usgFlagThirdTrimV1="";
if(usgThirdTrimFirstVisitList.size() >0){
for(OpdAntenatalUsg usgFlagTT1:usgThirdTrimFirstVisitList){
	usgFlagThirdTrimV1 = usgFlagTT1.getUsgFlag();
break;
}
}

String usgFlagThirdTrimV2="";
if(usgThirdTrimSecondVisitList.size() >0){
for(OpdAntenatalUsg usgFlagTT2:usgThirdTrimSecondVisitList){
	usgFlagThirdTrimV2 = usgFlagTT2.getUsgFlag();
	break;
}
}


String usgFlagThirdTrimV3="";
if(usgThirdTrimThirdVisitList.size() >0){
for(OpdAntenatalUsg usgFlagTT3:usgThirdTrimThirdVisitList){
	usgFlagThirdTrimV3 = usgFlagTT3.getUsgFlag();
}
}

// for gender List

Map<String,Object> map16= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map16 = (Map)request.getAttribute("map");

}
List<MasAdministrativeSex> list16= new ArrayList<MasAdministrativeSex>();

if (map16.get("GenderList") != null) {
	list16= (List)map16.get("GenderList");

}%>


</head>

<body>
<h2 style="text-align:center;font-size:36px;">EHEALTH KERALA</h2>
<div class="reportMainDiv">
<div class="headerDiv">
<label class="mainlbl">UHID</label><label class="auto">:</label> <label class="value"><%=uhid%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>

<label class="mainlbl">Patient Name</label><label class="auto">:</label> <label class="value"><%=name%></label>
<div class="clear"></div> 
<label class="mainlbl">Age</label><label class="auto">:</label> <label class="value"><%=age%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>

<label class="mainlbl">Visit no</label><label class="auto">:</label> <label class="value"><%=visitNo %></label>
<div class="clear"></div> 
<label class="mainlbl">Department</label><label class="auto">:</label> <label class="value"><%=department%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>
<div class="clear"></div> 
</div>
<div class="clear"></div> 
<div class="plusText"><h4 class="h4Tab">General Examination</h4></div>

<div class="clear"></div>
<%if(lastPrescription.size()>0){%>
<div ><h4>Patient Details:</h4></div>
<%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%> 
<label class="mainlblAuto">Date of Birth: </label> 
<label class="valueAuto"><%=HMSUtil.convertDateToStringTypeDateOnly(dateOfBirth)%></label>
<label class="mainlblAuto">Blood Group: </label>
<label class="valueAuto"><%=bloodGroup%></label>

<%if(confirmedBloodStatus!=null && !confirmedBloodStatus.isEmpty()){%>
<label class="mainlblAuto">Confirm: </label>
<label class="valueAuto"><%=confirmedBloodStatus!=null?confirmedBloodStatus:""%></label>
<%}%>
<div class="clear"></div> 

<%if(verbalBloodtatus!=null && !verbalBloodtatus.isEmpty()){%>
<label class="mainlblAuto">Verbal:</label>
<label class="valueAuto"><%=verbalBloodtatus!=null?verbalBloodtatus:""%></label>   
<%}%>

<%if(OpdAntenatalCard.getRefferedHospital()!=null && !OpdAntenatalCard.getRefferedHospital().isEmpty()){%>
<label class="mainlblAuto">Referred Hospital: </label>
<label class="valueAuto"><%=OpdAntenatalCard.getRefferedHospital()!=null?OpdAntenatalCard.getRefferedHospital():""%></label>
<%}%>
<label class="mainlblAuto">Referred GA: </label>
<label class="valueAuto"><%=OpdAntenatalCard.getRefferedGA()!=null?OpdAntenatalCard.getRefferedGA():""%></label>
<label class="valueAuto">Weeks</label>
<%}}%>
	
<div class="clear"></div> 
<%
Map<String,Object> map0= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map0= (Map)request.getAttribute("map");

}
List<OpdPatientAllergyT> list0= new ArrayList<OpdPatientAllergyT>();

if (map.get("OpdPatientAllergyTList") != null) {
	list0= (List)map.get("OpdPatientAllergyTList");
}%>
<div class="clear"></div> 
<h4>GENERAL DETAILS</h4>
<% if(list0.size()>0){%>
<h4>ALLERGIES</h4> 
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Type</th>
	<th>Allergen</th>
	<th>Remarks</th>
	
	</tr>
 <%for(OpdPatientAllergyT OpdPatientAllergyT:list0){
	
		 if(OpdPatientAllergyT.getAllergy().getProductName()!=null){ 
		%>
		<tr><td><%=OpdPatientAllergyT.getAllergy().getProductName()%></td>
		<td><%=OpdPatientAllergyT.getAllergen()!=null?OpdPatientAllergyT.getAllergen():""%></td>
		<td><%=OpdPatientAllergyT.getAllergyRemarks()!=null?OpdPatientAllergyT.getAllergyRemarks():""%></td>
		
		
		</tr>
		<% } }%>
 </table>
<%}%>
<div class="clear"></div> 
<div class="clear"></div> 
<%if(lastPrescription.size()>0){%>

<table cellpadding="10" cellspacing="0" style="text-align: left;"  >
	
	<tr><th>Gravida</th>
	<th>Parity</th>
	<th>Live Birth</th>
	<th>Abortion</th>
	<th>IUD</th>
    <th>Still Birth</th>
    <th>Neonatal Death</th>
    <th>MTP</th>
    <th>Ectopic</th>
    <th>Vesicular Mole</th>
    </tr>
	 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){
		 %>
		
		<%if(OpdAntenatalCard.getGravida1()!=null){ %>
		<tr><td><%=OpdAntenatalCard.getGravida1()%></td>
		
		<%}else{ %>
		<td> </td>
		<%} %>
		
	    <td><%=OpdAntenatalCard.getPara()%></td>
		
		<%if(OpdAntenatalCard.getLive()!=null){ %>
		<td><%=OpdAntenatalCard.getLive()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		<%if(OpdAntenatalCard.getAbortions()!=null){ %>
		<td><%=OpdAntenatalCard.getAbortions()%></td>
		<%}else{ %>
		<td>""</td>
		<%} %>
		
		<%if(OpdAntenatalCard.getIud()!=null){ %>
		<td><%=OpdAntenatalCard.getIud()%></td>
		<%}else{ %>
		<td>""</td>
		<%} %>
		
		<%if(OpdAntenatalCard.getStillBirth()!=null){ %>
		<td><%=OpdAntenatalCard.getStillBirth()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
        <%if(OpdAntenatalCard.getNnd()!=null){ %>
        
		<td><%=OpdAntenatalCard.getNnd()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
        
       <%if(OpdAntenatalCard.getMtp()!=null){ %>
       <td><%=OpdAntenatalCard.getMtp()%></td>
		<%}else{ %>
		<td>""</td>
		<%}%>
    
        <%if(OpdAntenatalCard.getEctopic()!=null){ %>
		<td><%=OpdAntenatalCard.getEctopic()%></td>
		<%}else{ %>
		<td>""</td>
		<%} %>
		
		 <%if(OpdAntenatalCard.getVesicular()!=null){ %>
		<td><%=OpdAntenatalCard.getVesicular()%></td>
		<%}else{ %>
		<td>""</td>
		<%} %>
       <%}%>
</table>
<%}%>


 <div class="clear"></div> 
 <div class="clear"></div> 
 <%if(lastPrescription.size()>0){%>
<table cellpadding="10" cellspacing="0" style="text-align: left;"  >
	
	<tr><th>LMP</th>
	<th>Unknown</th>
	<th>EDC (LMP)</th>
	<th>EDC(USG)</th>
	<th>Corrected EDC</th>
    <th colspan="2" style="text-align:center;">
	GA
	<hr style="height:1px; border:0; background:#000;">
	Weeks/Days
    </tr>
	 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){
		 %>
		
		<%if(OpdAntenatalCard.getLmp()!=null){ %>
		<tr><td><%=HMSUtil.convertStringDateFormat(OpdAntenatalCard.getLmp().toString())%></td>
		
		<%}else{ %>
		<td> </td>
		<%} %>
		
	    <td><%=OpdAntenatalCard.getUnknownLmpStatus()%></td>
		
		<%if(OpdAntenatalCard.getEdd()!=null){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(OpdAntenatalCard.getEdd())%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		<%if(OpdAntenatalCard.getScannedEdc()!=null){ %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(OpdAntenatalCard.getScannedEdc())%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
		<%if(OpdAntenatalCard.getEdcDate()!=null){ %>
		<td><%=HMSUtil.convertStringDateFormat(OpdAntenatalCard.getEdcDate().toString())%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
		<%if(OpdAntenatalCard.getGestationalAgeWeeks()!=null){ %>
		<td><%=OpdAntenatalCard.getGestationalAgeWeeks()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
		<%if(OpdAntenatalCard.getGestationalAgeDays()!=null){ %>
		<td><%=OpdAntenatalCard.getGestationalAgeDays()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
       <%}%>
</table>
<%}%>      

 <div class="clear"></div> 


<div class="clear"></div>
<%if(lastPrescription.size()>0){%>
 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%> 
<div class="plusText"><h4 class="h4Tab">MENSTRUAL HISTORY:</h4></div>	
<div class="clear"></div>   
 
<label class="mainlblAuto">Menarche : </label>
<label class="valueAuto"><%=OpdAntenatalCard.getMenarche()!=null?OpdAntenatalCard.getMenarche():""%></label>
<label class="valueAuto">Years</label>
<label class="valueAuto">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</label>

<label class="mainlblAuto">Previous Three Cycle : </label>
<label class="valueAuto"><%=OpdAntenatalCard.getCycle()!=null?OpdAntenatalCard.getCycle():""%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getCycleFlow()!=null?OpdAntenatalCard.getCycleFlow():""%></label>
<div class="clear"></div>

<div class="plusText"><h4 class="h4Tab">MARITAL HISTORY:</h4></div>	
<label class="mainlblAuto">Marital Status:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getMaritalStatus()!=null?OpdAntenatalCard.getMaritalStatus():""%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getMarritalHistoryRemarks()!=null?OpdAntenatalCard.getMarritalHistoryRemarks():""%></label>


<label class="mainlblAuto">Age at Marriage:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getAgeYear()%><%=OpdAntenatalCard.getYear()!=null?OpdAntenatalCard.getAgeMonth():""%></label>
<label class="valueAuto">Years</label>

<%if (OpdAntenatalCard.getDurationOfMarriageYear()!=null || OpdAntenatalCard.getDurationOfMarriageMonth()!=null){%>
<label class="mainlblAuto">Duration of Marriage:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getDurationOfMarriageYear()!=null?OpdAntenatalCard.getDurationOfMarriageYear():""%></label>
<label class="valueAuto">Years</label>
<label class="valueAuto"><%=OpdAntenatalCard.getDurationOfMarriageMonth()!=null?OpdAntenatalCard.getDurationOfMarriageMonth():""%></label>
<label class="valueAuto">Months</label>
<%}%>

<%if(OpdAntenatalCard.getConsanguineous()!=null && !OpdAntenatalCard.getConsanguineous().isEmpty()){%>
<label class="mainlblAuto">Consanguineous:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getConsanguineous()!=null?OpdAntenatalCard.getConsanguineous():""%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getDegree()!=null?OpdAntenatalCard.getDegree():""%></label>
<%}%>
<%if(OpdAntenatalCard.getInfertility()!=null && !OpdAntenatalCard.getInfertility().isEmpty()){%>
<label class="mainlblAuto">Treatment for Infertility:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getInfertility()!=null?OpdAntenatalCard.getInfertility():""%></label>
<%}%>

<label class="valueAuto"><%=OpdAntenatalCard.getFactor()!=null?OpdAntenatalCard.getFactor():""%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getInfertilityDetails()!=null?OpdAntenatalCard.getInfertilityDetails():""%></label>
  <%}%>  
<%}%>  
 <div class="clear"></div>
   <%
Map<String,Object> map1= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map1 = (Map)request.getAttribute("map");

}
List<OpdAntenatalCardPregnancy> list= new ArrayList<OpdAntenatalCardPregnancy>();

if (map1.get("cardPregnancyList") != null) {
	list = (List)map1.get("cardPregnancyList");
}%>
   <% if(list.size()>0){%>
 <%for(OpdAntenatalCardPregnancy OpdAntenatalCardPregnancy:list){%>
 <div class="clear"></div>   
<h4>PREVIOUS PREGNANCY DETAILS:</h4>
<div class="clear"></div>  
<label class="mainlblAuto" style="text-decoration:underline;">MOTHER:</label>

<div class="clear"></div>
<label class="mainlblAuto">Pregnancy No.: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getNoOfPregnancy()%></label>

<label class="mainlblAuto">Age of Mother: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getAge()%></label>
<label class="valueAuto">Yrs</label>  

<label class="mainlblAuto">Pregnancy Outcome: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getPregnancyOutcome()!=null?OpdAntenatalCardPregnancy.getPregnancyOutcome():""%></label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getPregnancyOutcomePreTermValue()!=null?OpdAntenatalCardPregnancy.getPregnancyOutcomePreTermValue():""%></label>

<label class="mainlblAuto">Place of Outcome: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getPlaceDelivery()!=null?OpdAntenatalCardPregnancy.getPlaceDelivery():""%></label>
<div class="clear"></div>

<label class="mainlblAuto" style="text-decoration:underline;">BABY:</label>
<div class="clear"></div>

<label class="mainlblAuto">Delivery Outcome: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getDeliveryOutcome()!=null?OpdAntenatalCardPregnancy.getDeliveryOutcome():""%></label>

<label class="mainlblAuto">Gender:</label>
<%for(MasAdministrativeSex MasAdministrativeSex:list16){
	
if (MasAdministrativeSex.getId() == Integer.parseInt(OpdAntenatalCardPregnancy.getSex())){%>
<label class="valueAuto"><%=MasAdministrativeSex.getAdministrativeSexName()%></label>
<%break;}}%>


<label class="mainlblAuto">GA: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getPreviousGestationalAge()!=null?OpdAntenatalCardPregnancy.getPreviousGestationalAge():""%></label>
<label class="valueAuto">Weeks</label>

<label class="mainlblAuto">Birth Weight: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getBirthWeight()%></label>
<label class="valueAuto">Kg</label>

<label class="mainlblAuto">Blood Transfusion: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getBloodTransfusion()!=null?OpdAntenatalCardPregnancy.getBloodTransfusion():""%></label>
<div class="clear"></div>

<label class="mainlblAuto" style="text-decoration:underline;">COMPLICATIONS:</label>
<div class="clear"></div>

<label class="mainlblAuto">Antenatal: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getAntenatal()!=null?OpdAntenatalCardPregnancy.getAntenatal():""%></label>


<label class="mainlblAuto">Intra Partum: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getIntraPartum()!=null?OpdAntenatalCardPregnancy.getIntraPartum():""%></label>



<label class="mainlblAuto">Post Partum: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getPostPartum()!=null?OpdAntenatalCardPregnancy.getPostPartum():""%></label>

<%if(OpdAntenatalCardPregnancy.getRemarks()!=null && !OpdAntenatalCardPregnancy.getRemarks().isEmpty()){%>
<label class="mainlblAuto">Remarks: </label>
<label class="valueAuto"><%=OpdAntenatalCardPregnancy.getRemarks()!=null?OpdAntenatalCardPregnancy.getRemarks():""%></label>
<div class="clear"></div> 
<%}%>
<%}%>  
<%}%>  
<%if(lastPrescription.size()>0){%>
 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%>
 
 <%if(OpdAntenatalCard.getObstetricComplications()!=null && !OpdAntenatalCard.getObstetricComplications().isEmpty()){%>
<label class="mainlblAuto">Medical Disorders: </label>
<label class="valueAuto"><%=OpdAntenatalCard.getMedicalDisord()%></label>
<%}%>

<%if(OpdAntenatalCard.getObstetricComplications()!=null && !OpdAntenatalCard.getObstetricComplications().isEmpty()){%>
<label class="mainlblAuto">Present Obstetric Complications:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getObstetricComplications()%></label>


<%}%>

<%}}%>
 <div class="clear"></div> 
 
 <%
Map<String,Object> map2= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map2 = (Map)request.getAttribute("map");

}
List<OpdAntenatalCardMedicalHistory> list1= new ArrayList<OpdAntenatalCardMedicalHistory>();

if (map2.get("MedicalHistoryList") != null) {
	list1= (List)map2.get("MedicalHistoryList");
}%>

<div class="clear"></div> 

<% if(list1.size()>0){%>   
<h4>PAST MEDICAL HISTORY:</h4>
<div class="clear"></div>  
  
<label class="mainlblAuto" style="text-decoration:underline;">Comorbidity:</label>

<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Comorbidity</th>
	<th colspan="2" style="text-align:center;">Since
	<hr style="height:1px; border:0; background:#000;">
	Years/Months
	
	</th>
	<th>Remarks</th>
	</tr>
	<%for(OpdAntenatalCardMedicalHistory OpdAntenatalCardMedicalHistory:list1){
		if(OpdAntenatalCardMedicalHistory.getComorbidity()!=null && !OpdAntenatalCardMedicalHistory.getComorbidity().isEmpty()){
		%>
		<tr><td><%=OpdAntenatalCardMedicalHistory.getComorbidity()%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getYears()!=null?OpdAntenatalCardMedicalHistory.getYears():""%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getMonths()!=null?OpdAntenatalCardMedicalHistory.getMonths():""%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getRemarks()!=null?OpdAntenatalCardMedicalHistory.getRemarks():""%></td></tr>
		
		<%} }%>
 </table>
<%}%>
<div class="clear"></div>  
<% if(list1.size()>0){%>
<label class="mainlblAuto" style="text-decoration:underline;">INFECTIONS:</label>

<table cellpadding="10" cellspacing="0" style="text-align: left;" >
	<tr><th>Infections</th>
	<th>Remarks</th>
	</tr>
	<%for(OpdAntenatalCardMedicalHistory OpdAntenatalCardMedicalHistory:list1){
	if(OpdAntenatalCardMedicalHistory.getInfection()!=null && !OpdAntenatalCardMedicalHistory.getInfection().isEmpty()){
		%>
		<tr><td><%=OpdAntenatalCardMedicalHistory.getInfection()%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getInfectionRemarks()!=null?OpdAntenatalCardMedicalHistory.getInfectionRemarks():""%></td>
		</tr>
     <%} }%>
</table>
<%}%> 
<div class="clear"></div>  
<h4>PAST SURGICAL HISTORY:</h4>
<% if(list1.size()>0 ){%>
<table cellpadding="10" cellspacing="0" style="text-align: left;" >
	<tr><th>Surgery Name</th>
	<th>Year</th>
	<th>Hospital</th>
	<th>Remarks</th>
	</tr>
	<%for(OpdAntenatalCardMedicalHistory OpdAntenatalCardMedicalHistory:list1){
		if(OpdAntenatalCardMedicalHistory.getPastSurgeryName()!=null && !OpdAntenatalCardMedicalHistory.getPastSurgeryName().isEmpty()){
		 %>
		<tr><td><%=OpdAntenatalCardMedicalHistory.getPastSurgeryName()%></td>
	    <td><%=OpdAntenatalCardMedicalHistory.getPastSurgeryYears()!=null?OpdAntenatalCardMedicalHistory.getPastSurgeryYears():""%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getPastSurgeryHospital()!=null?OpdAntenatalCardMedicalHistory.getPastSurgeryHospital():""%></td>
		<td><%=OpdAntenatalCardMedicalHistory.getPastSurgeryRemarks()!=null?OpdAntenatalCardMedicalHistory.getPastSurgeryHospital():""%></td>
		</tr>
		<%}} %>
   </table>
<%}%> 

<div class="clear"></div>
  
   <% if(lastPrescription.size()>0){%>
   <table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Personal History</th>
	<th>Family History</th>
	<th>Other Immunization Detail</th>
	
	</tr>
 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%>
			 		
		<tr><td><%=OpdAntenatalCard.getPersonalHistory()!=null?OpdAntenatalCard.getPersonalHistory():""%></td>
		<td><%=OpdAntenatalCard.getFamilyHistory()!=null?OpdAntenatalCard.getFamilyHistory():""%></td>
		<td><%=OpdAntenatalCard.getOtherImmunizationDetail()!=null?OpdAntenatalCard.getOtherImmunizationDetail():""%></td>
		
		</tr>
		<% }%>
 </table>
   <% }%>
   
 
<div class="clear"></div> 
<% if(lastPrescription.size()>0){%>
<%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%>  
<h4>GENERAL EXAMINATION:</h4>
<div class="clear"></div>  

<div class="clear"></div>
<label class="mainlblAuto">Weight:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getWeight()%></label>

<label class="mainlblAuto">Height:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getHeight()%></label>
<label class="valueAuto">Cm</label>  

<label class="mainlblAuto">BMI: </label>
<label class="valueAuto"><%=OpdAntenatalCard.getBmi()%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getBmiStatus()%></label>

<label class="mainlblAuto">Breast:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getBreast()%></label>
<label class="mainlblAuto">Nipple:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getNipple()%></label>
<div class="clear"></div>
<label class="mainlblAuto">Pallor:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getPallor()%></label>
<label class="mainlblAuto">Cyanosis:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getCyanosis()%></label>
<label class="mainlblAuto">Clubbing:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getClubbing()%></label>
<label class="mainlblAuto">Lymphadenopathy:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getLymphadenopathy()!=null?OpdAntenatalCard.getLymphadenopathy():""%></label>
<label class="valueAuto"><%=OpdAntenatalCard.getLymphadenopathyValue()!=null?OpdAntenatalCard.getLymphadenopathyValue():""%></label>
<label class="mainlblAuto">Edema:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getEdema()!=null?OpdAntenatalCard.getEdema():""%></label>
<div class="clear"></div>
<label class="mainlblAuto">Spine:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getSpine()!=null?OpdAntenatalCard.getSpine():""%></label>
<label class="mainlblAuto">GAIT:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getGait()!=null?OpdAntenatalCard.getGait():""%></label>
<label class="mainlblAuto">CVS:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getCvsGenExam()!=null?OpdAntenatalCard.getCvsGenExam():""%></label>
<label class="mainlblAuto">Others:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getOthersGeneralExamination()!=null?OpdAntenatalCard.getOthersGeneralExamination():""%></label>
<div class="clear"></div>
<label class="mainlblAuto" style="text-decoration:underline;">IMMUNIZATION DETAILS:</label>
<div class="clear"></div>
<%if(OpdAntenatalCard.getTetanusOnestDoseDate()!=null && !OpdAntenatalCard.getTetanusOnestDoseDate().equals("")){ %>
<label class="mainlblAuto">1st Dose of TT:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getTetanusOnestDoseDate() != null?HMSUtil.convertDateToStringWithoutTime(OpdAntenatalCard.getTetanusOnestDoseDate()):""%></label>
<%}%>
<%if(OpdAntenatalCard.getTetanusTwondDoseDate()!=null && !OpdAntenatalCard.getTetanusTwondDoseDate().equals("")){ %>
<label class="mainlblAuto">2nd Dose of TT:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getTetanusTwondDoseDate() != null?HMSUtil.convertDateToStringWithoutTime(OpdAntenatalCard.getTetanusTwondDoseDate()):""%></label>
<%}%>
<!-- ----------------- -->
<%if(OpdAntenatalCard.getOthersTtDetails()!=null && !OpdAntenatalCard.getOthersTtDetails().isEmpty()){ %>
<label class="mainlblAuto">Others:</label>
<label class="valueAuto"><%=OpdAntenatalCard.getOthersTtDetails()%></label>
<%}%>

<%}%>
 <%}%>
 <div class="clear"></div> 
 <p style="page-break-after: always;">&nbsp;</p> 
 <%
Map<String,Object> map4= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map4= (Map)request.getAttribute("map");

}
List<OpdAntenatalCardTrimester> list4= new ArrayList<OpdAntenatalCardTrimester>();

if (map4.get("CardTrimesterList") != null) {
	list4= (List)map4.get("CardTrimesterList");
}%>
 
<div class="clear"></div> 
<h4>FIRST TRIMESTER:</h4>
<h4>CLINICAL EXAMINATION CHART</h4> 
<% if(list4.size()>0){%>
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Date</th>
	<th>Weight(Kg)</th>
	<th colspan="2" style="text-align:center;">
	GA
	<hr style="height:1px; border:0; background:#000;">
	Weeks/Days
	</th>
	<th colspan="2" style="text-align:center;">BP
	<hr style="height:1px; border:0; background:#000;">
	Systolic/Diastolic
	</th>
	<th>General Examination</th>
	<th>Systemic Examination</th>
	<th>P/A</th>
	<th>P/V</th>
	<th>Risk</th>
	<th>Advice</th>
	</tr>
 <%for(OpdAntenatalCardTrimester OpdAntenatalCardTrimester:list4){
	
		 if(OpdAntenatalCardTrimester.getTrimesDate()!=null && !OpdAntenatalCardTrimester.getTrimesDate().equals("")){ 
		%>
		<tr><td><%=HMSUtil.convertStringDateFormat(OpdAntenatalCardTrimester.getTrimesDate().toString())%></td>
		<td><%=OpdAntenatalCardTrimester.getWeight()!=null?OpdAntenatalCardTrimester.getWeight():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaWeeks()!=null?OpdAntenatalCardTrimester.getGaWeeks():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaDays()!=null?OpdAntenatalCardTrimester.getGaDays():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpSystolics()!=null?OpdAntenatalCardTrimester.getBpSystolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpDiastolics()!=null?OpdAntenatalCardTrimester.getBpDiastolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGeneralExamination()!=null?OpdAntenatalCardTrimester.getGeneralExamination():""%></td>
		<td><%=OpdAntenatalCardTrimester.getSystemicExamin()!=null?OpdAntenatalCardTrimester.getSystemicExamin():""%></td>
		<td><%=OpdAntenatalCardTrimester.getPaTrimes()!=null?OpdAntenatalCardTrimester.getPaTrimes():""%></td>
		<td><%=OpdAntenatalCardTrimester.getPvTrimes()!=null?OpdAntenatalCardTrimester.getPvTrimes():""%></td>
		<td><%=OpdAntenatalCardTrimester.getObstetricRiskMeasure()!=null?OpdAntenatalCardTrimester.getObstetricRiskMeasure():""%></td>
		<td><%=OpdAntenatalCardTrimester.getOthers()!=null?OpdAntenatalCardTrimester.getOthers():""%></td>
		</tr>
		<% } }%>
 </table>
<%}%>
<div class="clear"></div>
<% if(usgFirstTrimGrid1DateListFirstVisit .size()>0){ %>
<h4>USG REPORT FIRST TRIMESTER:</h4>
<div class="clear"></div> 

<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							  <tr>
							  <td><b>USG</b>(<10 Weeks)</td>
							  <% if(usgFirstTrimGrid1DateListFirstVisit .size()>0){ %>
							  <td><b><%=usgFlag %></b></td>
							  <%} %>
							  <%if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td><b><%=usgFlagSecondV %></b></td>
							  <%} %>
							  <%if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							   <td><b><%=usgFlagThirdV %></b></td>
							   <%} %>
							  </tr>
						<tr>
						
							<td>USG Parameters</td>
							<% if(usgFirstTrimGrid1DateListFirstVisit .size()>0){ 
								for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								if(dateListFirstVisit.getUsgParameter().equalsIgnoreCase("Date")){%>
								 <td><input type="text" value="<%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
						<%}break;}}%>
						
							<%if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ 
							for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimGrid1DateListSecondVisit ){
								if(dateListSecondVisit.getUsgParameter().equalsIgnoreCase("Date")){%>
								<td><input type="text" value="<%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							<%}break;}}%>
						
						<%if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ 
							for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimGrid1DateListThirdVisit ){
								if(dateListThirdVisit.getUsgParameter().equalsIgnoreCase("Date")){%>
								<td><input type="text" value="<%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							<%}break;}}%>
						
						</tr>
						<tr>
						<td>Mean SAC Diameter</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Mean SAC Diameter")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Mean SAC Diameter")){ %>
								<input type="text" value="<%=crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Mean SAC Diameter")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>

                         <tr>
						<td>Yolk SAC</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Yolk SAC")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Yolk SAC")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Yolk SAC")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
						<tr>
                      <td>Fetal Pole</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Pole")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Pole")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Pole")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
						
						<tr>
                      <td>Fetal Heart</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Heart")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Heart")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Fetal Heart")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
						
						
						<tr>
                      <td>Crown Rump Length</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Crown Rump Length")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Crown Rump Length")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Crown Rump Length")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
						<tr>
                      <td>Scan EDC</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){ %>
								<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){ %>
								<%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){ %>
								<%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
						<tr>
                      <td>Remarks</td>
						
						<% if(usgFirstTrimGrid1DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Remarks")){ %>
								<textarea type="text"  readonly="readonly" ><%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						
						<% if(usgFirstTrimGrid1DateListSecondVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListSecondVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Remarks")){ %>
								<textarea type="text"  readonly="readonly" ><%= crlVisit.getUsgParameterValue2() != null?crlVisit.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							
							<% if(usgFirstTrimGrid1DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid1DateListThirdVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Remarks")){ %>
								<textarea type="text"  readonly="readonly" ><%= crlVisit.getUsgParameterValue3() != null?crlVisit.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
						</tr>
                      </table>
<%}%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<% if(usgFirstTrimGrid2DateListFirstVisit .size()>0){ %>
<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							  <tr><td><b>USG</b>(10-14 Weeks)</td>
							   <% if(usgFirstTrimGrid2DateListFirstVisit .size()>0){ %>
							  <td><b><%=usgFlagSecondGrid %></b></td>
							  <%} %>
							  <%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){ %>
							  <td><b><%=usgFlagSecondVgrid2 %></b></td>
							  <%} %>
							  <%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){ %>
							   <td><b><%=usgFlagThirdVSecondgrid %></b></td>
							   <%} %>
				         <tr>
						<td>USG Parameters</td>
					
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ 
								for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								if(dateListFirstVisit.getUsgParameter().equalsIgnoreCase("Date")){
								%>
								
								 <td><input type="text" value="  <%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								</td>
								
								
							
							<%}break;}}  %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){ 
							for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimGrid2DateListSecondVisit ){
								if(dateListSecondVisit.getUsgParameter().equalsIgnoreCase("Date")){%>
								<td><input type="text" value="  <%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"readonly="readonly" />
							</td>
							<%}break;}}  %>
						
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){ 
							for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimGrid2DateListThirdVisit ){ 
							if(dateListThirdVisit.getUsgParameter().equalsIgnoreCase("Date")) {%>
									<td><input type="text" value=" <%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>"readonly="readonly" />
							</td>
							<%break;}}}  %> 
							
							</tr> 
						
						<!-- ------- -->
				
				           <tr>
						<td>CRL</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("CRL")){ %>
								<input type="text" value=" <%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("CRL")) {%> 
								<input type="text" value=" <%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("CRL")) { %> 
								
                               <input type="text" value=" <%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
				
				<tr>
						<td>NT</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("NT")){ %>
								<input type="text" value=" <%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("NT")) {%> 
								 <input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("NT")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%} %>
							
							</tr>
							
							<tr>
						<td>NB</td>
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("NB")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("NB")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("NB")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%} %>
							
							</tr>
							
							<tr>
						<td>GA</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("GA")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
						
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("GA")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
						
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("GA")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
							
							<tr>
						<td>Scan EDC</td>
					
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								if(dateListFirstVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){
								%>
								
								<input type="text" value="<%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>" readonly="readonly" />
								</td>
							
							<%break;}}}  %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimGrid2DateListSecondVisit ){
								if(dateListSecondVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){%>
								<input type="text" value="<%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly" />
							</td>
							<%break;}}}  %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimGrid2DateListThirdVisit ){ 
							if(dateListThirdVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")) {%>
								<input type="text" value="<%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>" readonly="readonly" />
							</td>
							<%break;}}}  %> 
							
							</tr> 
							<tr>
						<td>Cx Length</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Cx Length")){ %>
								<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>
								<%break;}} %> 
								</td>
							
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Cx Length")) { %> 
								<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>
							<%break;} }%>
							</td>
							<%} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){%>
								 
									 <%if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Cx Length")) { %> 
								<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>
							<%break;}} %>
							</td>
							<%} %>
							
							</tr>
							
							<tr>
						<td>Impression</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Impression")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>" readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Impression")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Impression")) {%> 
								<input type="text" value=" <%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"readonly="readonly" />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
							
							<tr>
						<td>Remarks</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Remarks")){ %>
								<textarea type="text"  readonly="readonly" ><%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Remarks")) {%> 
								<textarea type="text"  readonly="readonly" ><%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Remarks")) {%> 
								<textarea type="text"  readonly="readonly" ><%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
						
						</table> 
						<%}%>
						
						
						
<div class="clear"></div>
  
<%
Map<String,Object> map5= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map5= (Map)request.getAttribute("map");

}
List<OpdAntenatalCardTrimester> list5= new ArrayList<OpdAntenatalCardTrimester>();

if (map.get("CardTrimesterList2") != null) {
	list5= (List)map.get("CardTrimesterList2");
}%>
 <p style="page-break-after: always;">&nbsp;</p> 
<div class="clear"></div> 
<h4>SECOND TRIMESTER:</h4>
<h4>CLINICAL EXAMINATION CHART</h4> 
<% if(list5.size()>0){%>
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Date</th>
	<th >Weight(Kg)</th>
	<th colspan="2" style="text-align:center;">
	GA
	<hr style="height:1px; border:0; background:#000;">
	Weeks/Days
	</th>
	<th colspan="2" style="text-align:center;">
	BP
	<hr style="height:1px; border:0; background:#000;">
	Systolic/Diastolic 
	</th>
	<th>General Examination</th>
	<th>Systemic Examination</th>
	<th>P/A</th>
	<th>SFH</th>
	<th>FH</th>
	<th>U.Alb</th>
	<th>Risk</th>
	<th>Advice</th>
	</tr>
 <%for(OpdAntenatalCardTrimester OpdAntenatalCardTrimester:list5){
	
		 if(OpdAntenatalCardTrimester.getTrimesDate()!=null && !OpdAntenatalCardTrimester.getTrimesDate().equals("")){ 
		%>
		<tr><td><%=HMSUtil.convertStringDateFormat(OpdAntenatalCardTrimester.getTrimesDate().toString())%></td>
		<td><%=OpdAntenatalCardTrimester.getWeight()!=null?OpdAntenatalCardTrimester.getWeight():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaWeeks()!=null?OpdAntenatalCardTrimester.getGaWeeks():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaDays()!=null?OpdAntenatalCardTrimester.getGaDays():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpSystolics()!=null?OpdAntenatalCardTrimester.getBpSystolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpDiastolics()!=null?OpdAntenatalCardTrimester.getBpDiastolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGeneralExamination()!=null?OpdAntenatalCardTrimester.getGeneralExamination():""%></td>
		<td><%=OpdAntenatalCardTrimester.getSystemicExamin()!=null?OpdAntenatalCardTrimester.getSystemicExamin():""%></td>
		<td><%=OpdAntenatalCardTrimester.getPaTrimes()!=null?OpdAntenatalCardTrimester.getPaTrimes():""%></td>
		<td><%=OpdAntenatalCardTrimester.getFhs()!=null?OpdAntenatalCardTrimester.getFhs():""%></td>
		<td><%=OpdAntenatalCardTrimester.getFh()!=null?OpdAntenatalCardTrimester.getFh():""%></td>
		<td><%=OpdAntenatalCardTrimester.getUrinAlbumin()!=null?OpdAntenatalCardTrimester.getUrinAlbumin():""%></td>
		<td><%=OpdAntenatalCardTrimester.getObstetricRiskMeasure()!=null?OpdAntenatalCardTrimester.getObstetricRiskMeasure():""%></td>
		<td><%=OpdAntenatalCardTrimester.getOthers()!=null?OpdAntenatalCardTrimester.getOthers():""%></td>
		</tr>
		<% } }%>
 </table>
<%}%>

<div class="clear"></div>
 <% if(usgSecondTrimFirstVisitList .size()>0){ %>
<div class="plusText"><h4 class="h4Tab">USG Report Second Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
		<!-- <div  id="usgThirdDiv"  > -->
		<div class="indArrow"></div>		
		<div class="Block">
		<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							  <tr><td><b>USG</b>(2nd Trimester)</td>
							   <% if(usgSecondTrimFirstVisitList .size()>0){ %>
							  <td><b><%=usgFlagSecondTrimV1 %></b></td>
							  <%} %>
							  <%if(usgSecondTrimSecondVisitList.size()>0){ %>
							  <td><b><%=usgFlagSecondTrimV2 %></b></td>
							  <%} %>
							  <%if(usgSecondTrimThirdVisitList.size()>0){ %>
							   <td><b><%=usgFlagSecondTrimV3 %></b></td>
							   <%} %>
							
						</tr>	  
						 <tr>
						<td>USG Parameters
					
							<% if(usgSecondTrimFirstVisitList.size()>0){ 
								for(OpdAntenatalUsg dateListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
									if(dateListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Date")){
									%>
								
								 <td><input type="text" value="<%=dateListSecondTrimFirstV.getUsgParameterValue1() != null?dateListSecondTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%break;}}}  %>
							
							
							<%if(usgSecondTrimSecondVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListSecondTrimSecondV : usgSecondTrimSecondVisitList ){ 
								if(dateListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListSecondTrimSecondV.getUsgParameterValue2() != null?dateListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
							</td>
							<%break;}} } %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
								if(dateListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListSecondTrimThirdV.getUsgParameterValue3() != null?dateListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
							</td>
							<%break;}}}  %> 
							
							</tr> 
						
						<!-- ------- -->
						 <tr>
						<td>LMP GA</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg lmpGAListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(lmpGAListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("LMP GA")){
									 %>
								
								<input type="text" value="<%=lmpGAListSecondTrimFirstV.getUsgParameterValue1() != null?lmpGAListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg lmpGAListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(lmpGAListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListSecondTrimSecondV.getUsgParameterValue2() != null?lmpGAListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg lmpGAListSecondTrimThirdV:usgSecondTrimThirdVisitList ){ 
									 if(lmpGAListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListSecondTrimThirdV.getUsgParameterValue3() != null?lmpGAListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
						<!-- ------ -->
						
						<tr>
						<td>USG GA</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%  for(OpdAntenatalUsg usgGAListSecondTrimFirstV:usgSecondTrimFirstVisitList ){ 
								  if(usgGAListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("USG GA")){
							  %>	
								<input type="text" value="<%=usgGAListSecondTrimFirstV.getUsgParameterValue1() != null?usgGAListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />
							     <div class="clear"></div>
							<%}} %>	
								</td>							
							<%} %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg usgGAListSecondTrimSecondV:usgSecondTrimSecondVisitList ){
									 if(usgGAListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>		
								
								<input type="text" value="<%=usgGAListSecondTrimSecondV.getUsgParameterValue2() != null?usgGAListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
							     <div class="clear"></div>
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg usgGAListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									 if(usgGAListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>
								
								<input type="text" value="<%=usgGAListSecondTrimThirdV.getUsgParameterValue3() != null?usgGAListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
							<!-- ----- -->
							<tr>
						<td>BPD</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg bpdListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(bpdListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("BPD")){
									 %>		
								
								<input type="text" value="<%=bpdListSecondTrimFirstV.getUsgParameterValue1() !=null?bpdListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg bpdListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(bpdListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("BPD")){
								%>	
								<input type="text" value="<%=bpdListSecondTrimSecondV.getUsgParameterValue2() !=null?bpdListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg bpdListSecondTrimSecondtV:usgSecondTrimThirdVisitList ){
									 if(bpdListSecondTrimSecondtV.getUsgParameter().equalsIgnoreCase("BPD")){
									%>	 
								
								<input type="text" value="<%=bpdListSecondTrimSecondtV.getUsgParameterValue3() !=null?bpdListSecondTrimSecondtV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}}%>
							</td>
							<%}  %>							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>HC</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimFirstV:usgSecondTrimFirstVisitList ){
									 if(hcListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								
								<input type="text" value="<%=hcListSecondTrimFirstV.getUsgParameterValue1() !=null?hcListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimSecondV:usgSecondTrimSecondVisitList ){ 
									 if(hcListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("HC")){
								 %>	
								<input type="text" value="<%=hcListSecondTrimSecondV.getUsgParameterValue2() !=null?hcListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<%  for(OpdAntenatalUsg hcListSecondTrimThirdV:usgSecondTrimThirdVisitList ){
									 if(hcListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								 
								<input type="text" value="<%=hcListSecondTrimThirdV.getUsgParameterValue3() !=null?hcListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>AC</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 		for(OpdAntenatalUsg acListSecondTrimFirstV:usgSecondTrimFirstVisitList ){ 
									 if(acListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListSecondTrimFirstV.getUsgParameterValue1() !=null?acListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
						
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg acListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(acListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("AC")){
									%>	
								<input type="text" value="<%=acListSecondTrimSecondV.getUsgParameterValue2() !=null?acListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg acListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(acListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListSecondTrimThirdV.getUsgParameterValue3() !=null?acListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							</tr>
							
							
						
						<!-- ------- -->
						
						<tr>
						<td>FL</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg flListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(flListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("FL")){
								%>
								<input type="text" value="<%=flListSecondTrimFirstV.getUsgParameterValue1() !=null?flListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg flListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(flListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("FL")){
									%>	
							   <input type="text" value="<%=flListSecondTrimSecondV.getUsgParameterValue2() !=null?flListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg flListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(flListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("FL")){
								%>	
								<input type="text" value="<%=flListSecondTrimThirdV.getUsgParameterValue3() !=null?flListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>AFI</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 	for(OpdAntenatalUsg afiListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(afiListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>
								<input type="text" value="<%=afiListSecondTrimFirstV.getUsgParameterValue1() !=null?afiListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />

								 <div class="clear"></div>
								<%} }%> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg afiListSecondTrimSecondV : usgSecondTrimSecondVisitList ){ 
									if(afiListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
							    <input type="text" value="<%=afiListSecondTrimSecondV.getUsgParameterValue2() !=null?afiListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg afiListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(afiListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
								<input type="text" value="<%=afiListSecondTrimThirdV.getUsgParameterValue3() !=null?afiListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Placenta</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg placentaListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(placentaListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Placenta")){
								%>
								<input type="text" value="<%=placentaListSecondTrimFirstV.getUsgParameterValue1() !=null?placentaListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg placentaListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(placentaListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
							    <input type="text" value="<%=placentaListSecondTrimSecondV.getUsgParameterValue2() !=null?placentaListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								
								  <div class="clear"></div>
							<%}} %>
							</td>
							<%} %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg placentaListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(placentaListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
								<input type="text" value="<%=placentaListSecondTrimThirdV.getUsgParameterValue3() !=null?placentaListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>EBW</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<%   
							for(OpdAntenatalUsg ebwListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
								if(ebwListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("EBW")){
								%>
								<input type="text" value="<%=ebwListSecondTrimFirstV.getUsgParameterValue1() !=null?ebwListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"  />

								 <div class="clear"></div>
								<%}}%> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg ebwListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(ebwListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
							   <input type="text" value=" <%=ebwListSecondTrimSecondV.getUsgParameterValue2() !=null?ebwListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"  />
								
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg ebwListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(ebwListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
								 <input type="text" value=" <%=ebwListSecondTrimThirdV.getUsgParameterValue3() !=null?ebwListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"  />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>CX Length</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(cxLengthListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("CX Length")){
							%>
								 <input type="text" value=" <%=cxLengthListSecondTrimFirstV.getUsgParameterValue1() !=null?cxLengthListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"/>

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}%>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(cxLengthListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("CX Length")){
									%>	
							    <input type="text" value="<%=cxLengthListSecondTrimSecondV.getUsgParameterValue2() !=null?cxLengthListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"/>
								
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg cxLengthListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(cxLengthListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("CX Length")){
									%>	
								<input type="text" value="<%=cxLengthListSecondTrimThirdV.getUsgParameterValue3() !=null?cxLengthListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"/>
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							</tr>
							
							
							<!-- ------- -->
						
						<tr>
						<td>Anomalies</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 
							for(OpdAntenatalUsg anomaliesListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(anomaliesListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Anomalies")){
							%>
								<input type="text" value="<%=anomaliesListSecondTrimFirstV.getUsgParameterValue1() !=null?anomaliesListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"/>

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg anomaliesListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(anomaliesListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Anomalies")){
									%>	
							    <input type="text" value="<%=anomaliesListSecondTrimSecondV.getUsgParameterValue2() !=null?anomaliesListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"/>
								
								  <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg anomaliesListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(anomaliesListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Anomalies")){
								%>	
								<input type="text" value="<%=anomaliesListSecondTrimThirdV.getUsgParameterValue3() !=null?anomaliesListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"/>
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Impression</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% 
							for(OpdAntenatalUsg impressionListSecondTrimFirstV : usgSecondTrimFirstVisitList ){ 
								if(impressionListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Impression")){
							%>
								<input type="text" value="<%=impressionListSecondTrimFirstV.getUsgParameterValue1() !=null?impressionListSecondTrimFirstV.getUsgParameterValue1():"" %>" readonly="readonly"/>

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% 	for(OpdAntenatalUsg impressionListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(impressionListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Impression")){
									%>	
							   <input type="text" value="<%=impressionListSecondTrimSecondV.getUsgParameterValue2() !=null?impressionListSecondTrimSecondV.getUsgParameterValue2():"" %>" readonly="readonly"/>
							   
								
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg impressionListSecondTrimThirdV : usgSecondTrimThirdVisitList ){ 
									if(impressionListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Impression")){
								%>	
							<input type="text" value="<%=impressionListSecondTrimThirdV.getUsgParameterValue3() !=null?impressionListSecondTrimThirdV.getUsgParameterValue3():"" %>" readonly="readonly"/>
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Remarks</td>
						
							<% if(usgSecondTrimFirstVisitList.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimFirstV : usgSecondTrimFirstVisitList ){
									if(remarksListSecondTrimFirstV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>
								<textarea type="text"  readonly="readonly"><%=remarksListSecondTrimFirstV.getUsgParameterValue1() !=null?remarksListSecondTrimFirstV.getUsgParameterValue1():"" %> </textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgSecondTrimSecondVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimSecondV : usgSecondTrimSecondVisitList ){
									if(remarksListSecondTrimSecondV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text"  readonly="readonly"><%=remarksListSecondTrimSecondV.getUsgParameterValue2() !=null?remarksListSecondTrimSecondV.getUsgParameterValue2():"" %> </textarea>
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgSecondTrimThirdVisitList.size()>0){%>
							  <td>
								<% for(OpdAntenatalUsg remarksListSecondTrimThirdV : usgSecondTrimThirdVisitList ){
									if(remarksListSecondTrimThirdV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								
<textarea type="text"  readonly="readonly"><%=remarksListSecondTrimThirdV.getUsgParameterValue3() !=null?remarksListSecondTrimThirdV.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
							<%}} %>
							</td>
							<%}  %>
							</tr>
							   
						</table> 
						
			<div class="clear"></div>
		
		</div> 
		<%} %>
		
<div class="clear"></div>	
<%
Map<String,Object> map6= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map6= (Map)request.getAttribute("map");

}
List<OpdAntenatalCardTrimester> list6= new ArrayList<OpdAntenatalCardTrimester>();

if (map.get("CardTrimesterList2") != null) {
	list6= (List)map.get("CardTrimesterList3");
}%>
<p style="page-break-after: always;">&nbsp;</p> 
<div class="clear"></div> 
<h4>THIRD TRIMESTER:</h4>
<% if(list5.size()>0){%>
<h4>CLINICAL EXAMINATION CHART</h4> 
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Date</th>
	<th >Weight(Kg)</th>
	<th colspan="2" style="text-align:center;">
	GA
	<hr style="height:1px; border:0; background:#000;">
	Weeks/Days
	</th>
	<th colspan="2" style="text-align:center;">
	BP
	<hr style="height:1px; border:0; background:#000;">
	Systolic/Diastolic 
	</th>
	<th>General Examination</th>
	<th>Systemic Examination</th>
	<th>P/A</th>
	<th>SFH</th>
	<th>FH</th>
	<th>U.Alb</th>
	<th>Risk</th>
	<th>Advice</th>
	</tr>
 <%for(OpdAntenatalCardTrimester OpdAntenatalCardTrimester:list6){
	
		 if(OpdAntenatalCardTrimester.getTrimesDate()!=null && !OpdAntenatalCardTrimester.getTrimesDate().equals("")){ 
		%>
		<tr><td><%=HMSUtil.convertStringDateFormat(OpdAntenatalCardTrimester.getTrimesDate().toString())%></td>
		<td><%=OpdAntenatalCardTrimester.getWeight()!=null?OpdAntenatalCardTrimester.getWeight():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaWeeks()!=null?OpdAntenatalCardTrimester.getGaWeeks():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGaDays()!=null?OpdAntenatalCardTrimester.getGaDays():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpSystolics()!=null?OpdAntenatalCardTrimester.getBpSystolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getBpDiastolics()!=null?OpdAntenatalCardTrimester.getBpDiastolics():""%></td>
		<td><%=OpdAntenatalCardTrimester.getGeneralExamination()!=null?OpdAntenatalCardTrimester.getGeneralExamination():""%></td>
		<td><%=OpdAntenatalCardTrimester.getSystemicExamin()!=null?OpdAntenatalCardTrimester.getSystemicExamin():""%></td>
		<td><%=OpdAntenatalCardTrimester.getPaTrimes()!=null?OpdAntenatalCardTrimester.getPaTrimes():""%></td>
		<td><%=OpdAntenatalCardTrimester.getFhs()!=null?OpdAntenatalCardTrimester.getFhs():""%></td>
		<td><%=OpdAntenatalCardTrimester.getFh()!=null?OpdAntenatalCardTrimester.getFh():""%></td>
		<td><%=OpdAntenatalCardTrimester.getUrinAlbumin()!=null?OpdAntenatalCardTrimester.getUrinAlbumin():""%></td>
		<td><%=OpdAntenatalCardTrimester.getObstetricRiskMeasure()!=null?OpdAntenatalCardTrimester.getObstetricRiskMeasure():""%></td>
		<td><%=OpdAntenatalCardTrimester.getOthers()!=null?OpdAntenatalCardTrimester.getOthers():""%></td>
		</tr>
		<% } }%>
 </table>
<%}%>

<% if(usgThirdTrimFirstVisitList.size()>0){ %>		
<h4>USG Report Third Trimester</h4>
 <div class="clear"></div>
		<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							  <tr><td><b>USG</b>(3rd Trimester)</td>
							  
							   <% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td><b><%=usgFlagThirdTrimV1 %></b></td>
							  <%} %>
							  <%if(usgThirdTrimSecondVisitList.size()>0){ %>
							  <td><b><%=usgFlagThirdTrimV2 %></b></td>
							  <%} %>
							  <%if(usgThirdTrimThirdVisitList.size()>0){ %>
							   <td><b><%=usgFlagThirdTrimV3 %></b></td>
							   <%} %>
							
						</tr>	  
						 <tr>
						<td>USG Parameters</td>
					
							<% if(usgThirdTrimFirstVisitList.size()>0){ 
								for(OpdAntenatalUsg dateListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
									if(dateListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Date")){
									%>
								
								 <td><input type="text" value="<%=dateListThirdTrimFirstV.getUsgParameterValue1() != null?dateListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%break;}}} %>
							
							
							<%if(usgThirdTrimSecondVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListThirdTrimSecondV : usgThirdTrimSecondVisitList ){ 
								if(dateListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListThirdTrimSecondV.getUsgParameterValue2() != null?dateListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							</td>
							<%break;}} } %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){ 
							for(OpdAntenatalUsg dateListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
								if(dateListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Date")){
							%>
								<td><input type="text" value="<%=dateListThirdTrimThirdV.getUsgParameterValue3() != null?dateListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} %> 
							
							</tr> 
						
						<!-- ------- -->
						 <tr>
						<td>LMP GA</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg lmpGAListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(lmpGAListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("LMP GA")){
									 %>
								
								<input type="text" value="<%=lmpGAListThirdTrimFirstV.getUsgParameterValue1() != null?lmpGAListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%
								 for(OpdAntenatalUsg lmpGAListThirdTrimSecondV:usgThirdTrimSecondVisitList ){  if(lmpGAListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListThirdTrimSecondV.getUsgParameterValue2() != null?lmpGAListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg lmpGAListThirdTrimThirdV:usgThirdTrimThirdVisitList ){ 
									 if(lmpGAListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("LMP GA")){
								 %> 
								<input type="text" value="<%=lmpGAListThirdTrimThirdV.getUsgParameterValue3() != null?lmpGAListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%} %>
							
							</tr>
						<!-- ------ -->
						
						<tr>
						<td>USG GA</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimFirstV:usgThirdTrimFirstVisitList ){ 
								  if(usgGAListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("USG GA")){
							  %>	
								<input type="text" value="<%=usgGAListThirdTrimFirstV.getUsgParameterValue1() != null?usgGAListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
							     <div class="clear"></div>
							<%}} %>	
								</td>							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimSecondV:usgThirdTrimSecondVisitList ){
									 if(usgGAListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>		
								
								<input type="text" value="<%=usgGAListThirdTrimSecondV.getUsgParameterValue2() != null?usgGAListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg usgGAListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									 if(usgGAListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("USG GA")){
									 %>
								
								<input type="text" value="<%=usgGAListThirdTrimThirdV.getUsgParameterValue3() != null?usgGAListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
							  
							<%}} %>
							</td>
							<%}  %>
							
							</tr>
							<!-- ----- -->
							<tr>
						<td>BPD</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg bpdListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(bpdListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("BPD")){
									 %>		
								
								<input type="text" value="<%=bpdListThirdTrimFirstV.getUsgParameterValue1() !=null?bpdListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bpdListThirdTrimSecondV:usgThirdTrimSecondVisitList ){ 
									 if(bpdListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("BPD")){
								%>	
								<input type="text" value="<%=bpdListThirdTrimSecondV.getUsgParameterValue2() !=null?bpdListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bpdListThirdTrimSecondtV:usgThirdTrimThirdVisitList ){
									 if(bpdListThirdTrimSecondtV.getUsgParameter().equalsIgnoreCase("BPD")){
									%>	 
								
								<input type="text" value="<%=bpdListThirdTrimSecondtV.getUsgParameterValue3() !=null?bpdListThirdTrimSecondtV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 
							<%}}%>
							</td>
							<%}  %>							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>HC</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg hcListThirdTrimFirstV:usgThirdTrimFirstVisitList ){
									 if(hcListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								
								<input type="text" value="<%=hcListThirdTrimFirstV.getUsgParameterValue1() !=null?hcListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
						
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg hcListThirdTrimSecondV:usgThirdTrimSecondVisitList ){ 
									 if(hcListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("HC")){
								 %>	
								<input type="text" value="<%=hcListThirdTrimSecondV.getUsgParameterValue2() !=null?hcListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								  
							<%}} %>
							</td>
							<%}  %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg hcListThirdTrimThirdV:usgThirdTrimThirdVisitList ){
									 if(hcListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("HC")){
									 %>	
								 
								<input type="text" value="<%=hcListThirdTrimThirdV.getUsgParameterValue3() !=null?hcListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%}  %>
							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>AC</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimFirstV:usgThirdTrimFirstVisitList ){ 
									 if(acListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListThirdTrimFirstV.getUsgParameterValue1() !=null?acListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(acListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("AC")){
									%>	
								<input type="text" value="<%=acListThirdTrimSecondV.getUsgParameterValue2() !=null?acListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg acListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(acListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("AC")){
								%>	
								<input type="text" value="<%=acListThirdTrimThirdV.getUsgParameterValue3() !=null?acListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%} %>
							</tr>
						<!-- ------- -->
						
						<tr>
						<td>FL</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg flListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(flListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("FL")){
								%>
								<input type="text" value="<%=flListThirdTrimFirstV.getUsgParameterValue1() !=null?flListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							 <td>
								 <%for(OpdAntenatalUsg flListThirdTrimSecondV : usgThirdTrimSecondVisitList ){%>
								  
									 <%if(flListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("FL")){
									%>	
							    <input type="text" value="<%=flListThirdTrimSecondV.getUsgParameterValue2() !=null?flListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
							 
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg flListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(flListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("FL")){
								%>	
								<input type="text" value="<%=flListThirdTrimThirdV.getUsgParameterValue3() !=null?flListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								  <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							</tr>
				        	<tr>
						<td>AFI</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(afiListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>
								<input type="text" value="<%=afiListThirdTrimFirstV.getUsgParameterValue1() !=null?afiListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%} }%> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimSecondV : usgThirdTrimSecondVisitList ){ 
									if(afiListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
							    <input type="text" value="<%=afiListThirdTrimSecondV.getUsgParameterValue2() !=null?afiListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg afiListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(afiListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("AFI")){
								%>	
								<input type="text" value="<%=afiListThirdTrimThirdV.getUsgParameterValue3() !=null?afiListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Placenta</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(placentaListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Placenta")){
								%>
								<input type="text" value="<%=placentaListThirdTrimFirstV.getUsgParameterValue1() !=null?placentaListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(placentaListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
							    <input type="text" value="<%=placentaListThirdTrimSecondV.getUsgParameterValue2() !=null?placentaListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg placentaListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(placentaListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Placenta")){
									%>	
								<input type="text" value="<%=placentaListThirdTrimThirdV.getUsgParameterValue3() !=null?placentaListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}%>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>EBW</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
								if(ebwListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("EBW")){
								%>
								<input type="text" value="<%=ebwListThirdTrimFirstV.getUsgParameterValue1() !=null?ebwListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}}%> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(ebwListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
							    <input type="text" value="<%=ebwListThirdTrimSecondV.getUsgParameterValue2() !=null?ebwListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%} %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg ebwListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(ebwListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("EBW")){
									%>	
								<input type="text" value="<%=ebwListThirdTrimThirdV.getUsgParameterValue3() !=null?ebwListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>BPP</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(bppListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("BPP")){
							%>
								<input type="text" value="<%=bppListThirdTrimFirstV.getUsgParameterValue1() !=null?bppListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(bppListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("BPP")){
									%>	
							    <input type="text" value="<%=bppListThirdTrimSecondV.getUsgParameterValue2() !=null?bppListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg bppListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(bppListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("BPP")){
									%>	
								<input type="text" value="<%=bppListThirdTrimThirdV.getUsgParameterValue3() !=null?bppListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%} }%>
							</td>
							<%}  %>
							</tr>
							
							
							<!-- ------- -->
						
						<tr>
						<td>Doppler</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%
							for(OpdAntenatalUsg dopplerListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(dopplerListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Doppler")){
							%>
								<input type="text" value="<%=dopplerListThirdTrimFirstV.getUsgParameterValue1() !=null?dopplerListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
						
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dopplerListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(dopplerListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Doppler")){
									%>	
							    <input type="text" value="<%=dopplerListThirdTrimSecondV.getUsgParameterValue2() !=null?dopplerListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
							    
							<%}} %>
							</td>
							<%} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dopplerListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(dopplerListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Doppler")){
								%>	
								<input type="text" value="<%=dopplerListThirdTrimThirdV.getUsgParameterValue3() !=null?dopplerListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Impression</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimFirstV : usgThirdTrimFirstVisitList ){ 
								if(impressionListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Impression")){
							%>
								<input type="text" value="<%=impressionListThirdTrimFirstV.getUsgParameterValue1() !=null?impressionListThirdTrimFirstV.getUsgParameterValue1():"" %>"  readonly="readonly"  />

								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(impressionListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Impression")){
									%>	
							    <input type="text" value="<%=impressionListThirdTrimSecondV.getUsgParameterValue2() !=null?impressionListThirdTrimSecondV.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%} %>
							
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg impressionListThirdTrimThirdV : usgThirdTrimThirdVisitList ){ 
									if(impressionListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Impression")){
								%>	
								<input type="text" value="<%=impressionListThirdTrimThirdV.getUsgParameterValue3() !=null?impressionListThirdTrimThirdV.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%} %>
							</tr>
							
							<!-- ------- -->
						
						<tr>
						<td>Remarks</td>
						
							<% if(usgThirdTrimFirstVisitList.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimFirstV : usgThirdTrimFirstVisitList ){
									if(remarksListThirdTrimFirstV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>
								<textarea type="text" readonly="readonly" ><%=remarksListThirdTrimFirstV.getUsgParameterValue1() !=null?remarksListThirdTrimFirstV.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%}  %>
							
							<%if(usgThirdTrimSecondVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimSecondV : usgThirdTrimSecondVisitList ){
									if(remarksListThirdTrimSecondV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text"  readonly="readonly" ><%=remarksListThirdTrimSecondV.getUsgParameterValue2() !=null?remarksListThirdTrimSecondV.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
							    
							<%}} %>
							</td>
							<%}  %>
						
							<%if(usgThirdTrimThirdVisitList.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg remarksListThirdTrimThirdV : usgThirdTrimThirdVisitList ){
									if(remarksListThirdTrimThirdV.getUsgParameter().equalsIgnoreCase("Remarks")){
									%>	
								<textarea type="text" readonly="readonly"  ><%=remarksListThirdTrimThirdV.getUsgParameterValue3() !=null?remarksListThirdTrimThirdV.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
								
							<%}} %>
							</td>
							<%}  %>
							</tr>
							   
						</table> 
						<%}%>
			
<div class="clear"></div>	
<%
Map<String,Object> map7= new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map7= (Map)request.getAttribute("map");

}
List<ExternalAdmissionDetails> list7= new ArrayList<ExternalAdmissionDetails>();

if (map.get("ExternalAdmissionDetailsList") != null) {
	list7= (List)map.get("ExternalAdmissionDetailsList");
}%>
<p style="page-break-after: always;">&nbsp;</p> 
<div class="clear"></div> 
<h4>IP ADMISSIONS</h4>
<% if(list7.size()>0){%>
<h4>EXTERNAL ADMISSION DETAILS</h4> 
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>Date of Admission</th>
	<th>IP No.</th>
	<th>Diagnosis</th>
	<th>Management</th>
	<th>Advice</th>
	<th>Date of Discharge</th>
	</tr>
 <%for(ExternalAdmissionDetails ExternalAdmissionDetails:list7){
	
		 if(ExternalAdmissionDetails.getDateOfAdmission()!=null && !ExternalAdmissionDetails.getDateOfAdmission().equals("")){ 
		%>
		<tr><td><%=ExternalAdmissionDetails.getDateOfAdmission().toString().replaceAll("-", "/")%></td>
		<td><%=ExternalAdmissionDetails.getIpNo()!=null?ExternalAdmissionDetails.getIpNo():""%></td>
		<td><%=ExternalAdmissionDetails.getDiagnosis()!=null?ExternalAdmissionDetails.getDiagnosis():""%></td>
		<td><%=ExternalAdmissionDetails.getManagement()!=null?ExternalAdmissionDetails.getManagement():""%></td>
		<td><%=ExternalAdmissionDetails.getAdvice()!=null?ExternalAdmissionDetails.getAdvice():""%></td>
		<td><%=ExternalAdmissionDetails.getDateOfDischarge()!=null?ExternalAdmissionDetails.getDateOfDischarge():""%></td>
		
		</tr>
		<% } }%>
 </table>
<%}%>
<!-- for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){
if(lastPrescription.size()>0){ -->
<div class="clear"></div> 
<% if(lastPrescription.size()>0){%>
<h4>FAMILY PLANNING</h4> 
<table cellpadding="10" cellspacing="0" style="text-align: left;">
	<tr><th>OCPs</th>
	<th>PPIUCD</th>
	<th>Tubal Ligation</th>
	<th>Vasectomy</th>
	<th>Condom</th>
	<th>LAM</th>
	<th>None</th>
	</tr>
 <%for(OpdAntenatalCard OpdAntenatalCard:lastPrescription){%>
			 		
		<tr><td><%=OpdAntenatalCard.getOcpS()!=null?OpdAntenatalCard.getOcpS():""%></td>
		<td><%=OpdAntenatalCard.getPpiucd()!=null?OpdAntenatalCard.getPpiucd():""%></td>
		<td><%=OpdAntenatalCard.getTubalLigation()!=null?OpdAntenatalCard.getTubalLigation():""%></td>
		<td><%=OpdAntenatalCard.getVasectomy()!=null?OpdAntenatalCard.getVasectomy():""%></td>
		<td><%=OpdAntenatalCard.getCondom()!=null?OpdAntenatalCard.getCondom():""%></td>
		<td><%=OpdAntenatalCard.getLam()!=null?OpdAntenatalCard.getLam():""%></td>
		<td><%=OpdAntenatalCard.getNone()!=null?OpdAntenatalCard.getNone():""%></td>
		</tr>
		<% }%>
 </table>
<%}%>
</div>
<div class="clear"></div>
<input id="printpagebutton" type="button" value="Print this page" onclick="printpage()"/>   

<script type="text/javascript">
    function printpage() {
       
        var printButton = document.getElementById("printpagebutton");
        
        printButton.style.visibility = 'hidden';
       
        window.print()
       
        printButton.style.visibility = 'visible';
    }
</script>
</body>
</html>