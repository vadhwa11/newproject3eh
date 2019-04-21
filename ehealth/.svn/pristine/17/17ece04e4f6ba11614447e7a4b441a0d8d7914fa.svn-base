<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CaseSheet</title>
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

</style>

<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map)request.getAttribute("map");

}
List<PatientPrescriptionDetails> lastPrescription= new ArrayList<PatientPrescriptionDetails>();
String startDate="";
if (map.get("ppdtList") != null) {
	lastPrescription = (List)map.get("ppdtList");
}
String forms = "";
if (map.get("forms") != null) {
	forms = (String)map.get("forms");
}
System.out.println("forms==jsp="+forms);
String uhid ="";
String age = "";
int visitNo=0;
String department=null;
String name="";
for(PatientPrescriptionDetails patientPrescriptionDetails:lastPrescription){
	if(patientPrescriptionDetails.getPrescription().getHin()!=null){
	Patient p = patientPrescriptionDetails.getPrescription().getHin();
	uhid =((p.getHinNo() == null) ? "" : p.getHinNo());
	age= p.getAge();
	name=((p.getFullName() == null) ? "" : p.getFullName());
	if(patientPrescriptionDetails.getPrescription().getDepartment()!=null){
	department=patientPrescriptionDetails.getPrescription().getDepartment().getDepartmentName();
	visitNo = patientPrescriptionDetails.getPrescription().getVisit().getVisitNo();
	}
	}
	break;
}
%>
</head>
<body>


<%if(lastPrescription.size()>0){%>
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
<div class="clear"></div> 
</div>
	
	<table cellpadding="10" cellspacing="0" style="text-align: left;"  >
	<tr><th>Nomenclature</th>
	<th>Dose</th>
	<th>Route</th>
	<th>frequency</th>
	<th>Duration</th>
    <th>Prescribed Qty</th>
    <th>Unit</th>
    <th>Instruction</th>
  	<%if(!(forms.equalsIgnoreCase("opdlp"))){ %>
    <th>Remarks</th>
    <%} %>
    </tr>
	 <%for(PatientPrescriptionDetails patientPrescriptionDetails:lastPrescription){
		 %>
		
		<%if(patientPrescriptionDetails.getItem()!=null){ %>
		<tr><td><%=patientPrescriptionDetails.getItem().getNomenclature()%></td>
		<%}else if(patientPrescriptionDetails.getItemOut()!=null){ %>
		<tr><td><%=patientPrescriptionDetails.getItemOut().getNomenclature()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
	    <td><%=patientPrescriptionDetails.getDosage()%></td>
		
		<%if(patientPrescriptionDetails.getRoute()!=null){ %>
		<td><%=patientPrescriptionDetails.getRoute().getRouteName()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		<%if(patientPrescriptionDetails.getFrequency()!=null){ %>
		<td><%=patientPrescriptionDetails.getFrequency().getFrequencyName()%></td>
		<%}else{ %>
		<td>""</td>
		<%} %>
		
		<%if(patientPrescriptionDetails.getNoOfDays()!=null){ %>
		<td><%=patientPrescriptionDetails.getNoOfDays()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		
		<%if(patientPrescriptionDetails.getTotal()!=null){ %>
		<td><%=patientPrescriptionDetails.getTotal()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
        <%if(patientPrescriptionDetails.getItem()!=null){ %>
        <%if(patientPrescriptionDetails.getItem().getItemConversion()!=null){ %>
		<td><%=patientPrescriptionDetails.getItem().getItemConversion().getItemUnitName()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
        
       <%if(patientPrescriptionDetails.getInsrtuction()!=null){ %>
       <td><%=patientPrescriptionDetails.getInsrtuction().getOpdInstructionTreatmentName()%></td>
		<%}else{ %>
		<td>""</td>
		<%}%>
    	<%if(!(forms.equalsIgnoreCase("opdlp"))){ %>
        <%if(patientPrescriptionDetails.getSplInstruction()!=null){ %>
		<td><%=patientPrescriptionDetails.getSplInstruction()%></td>
		<%}else{ %>
		<td>""</td>
		<%}} %>
		
       <%}else{ %>
			<td> </td>
			<%}%>

	<%}%>

	 </table>
<% } else{%>
<h2 style="text-align:center;font-size:36px;">No Data Found</h2>
<%} %>

</div>

</body>
</html>


