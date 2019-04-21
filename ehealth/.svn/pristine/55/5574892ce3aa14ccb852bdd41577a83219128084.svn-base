<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

Map<Integer,String> departmentMap=new HashMap<Integer,String>();
if(map.get("departmentList")!=null){
	
	departmentMap=(Map<Integer,String>)map.get("departmentList");
	
}

List<Visit> patientList=new ArrayList<Visit>();
if(map.get("patients")!=null){
	patientList=(List<Visit>)map.get("patients");
}

List<MasEmployee> doctorsList=new ArrayList<MasEmployee>();
if(map.get("DoctorsObjects")!=null){
	doctorsList=(List<MasEmployee>)map.get("DoctorsObjects");
}

List<MasEmployee> doctorsList2=new ArrayList<MasEmployee>();
if(map.get("DoctorsObjects2")!=null){
	doctorsList2=(List<MasEmployee>)map.get("DoctorsObjects2");
}

MasEmployee doctor=new MasEmployee();


if(map.get("doctorObj")!=null){
	doctor=(MasEmployee)map.get("doctorObj");
}

int doctorId=0;
if(map.get("doctorId")!=null){
	doctorId=(Integer)map.get("doctorId");
}

int hospitalId=0;
if(session.getAttribute("hospitalId")!=null){
	hospitalId=Integer.parseInt(String.valueOf(session.getAttribute("hospitalId")));
}
boolean success=false;
if(map.get("success")!=null){
	success=Boolean.valueOf(String.valueOf(map.get("success")));
}
int departmentId=0;
if(map.get("depatmentId")!=null){
	departmentId=Integer.parseInt(String.valueOf(map.get("depatmentId")));
}

Map<Integer,String> docNameMap=new HashMap<Integer,String>();
if(map.get("doctorNameMap")!=null){
	docNameMap=(Map<Integer,String>)map.get("doctorNameMap");
}

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Patient</title>
<%if(success){%>
<h4><span>Data Submitted Successfully !</span></h4>
<%} %>
</head>
<body>
<form name="transferPatient" method="POST" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h2>Transfer Patient</h2>
<div class="clear"></div><br>
<div class="cmnTable" >

<%if(patientList.size()>0){ int incr=0;%>
<table id="patientTable">
<tr>
<th><input type="checkbox" name="itemApproval" id="srNoId1" onchange="toggle1()"></th>
<th>Token No</th>
<th>UHID</th>
<th>Patient Name</th>
<th>Age</th>
<th>Gender</th>
<th>Doctor</th>
</tr>
<%for(Visit visit:patientList){ 
	incr++;
%>
<tr>
<td><input type="checkbox" id="visitId<%=incr%>" name="visitId<%=incr%>" value="<%=visit.getId()%>"/></td>
<input type="hidden" id="commonPoolPatient<%=incr%>" name="commonPoolPatient<%=incr%>" value="<%=visit.getId()%>"/>
<td><%=visit.getTokenNo()!=null?visit.getTokenNo():"" %></td>
<td><%=visit.getHin().getHinNo()%></td>
<td><%=visit.getHin().getPFirstName()%></td>
<td><%=visit.getHin().getAge()%></td>
<td><%=visit.getHin().getSex()!=null?visit.getHin().getSex().getAdministrativeSexName():""%></td>
		
<td>
<select id="doctors<%=incr%>" name="doctors<%=incr%>">
<option value="0">Select</option>
<%
for(MasEmployee doctors:doctorsList){
	if(doctors.getId()==doctorId){
%>
<option value="<%=doctors.getId()%>" selected="selected"><%=doctors.getEmployeeName() %></option>
<%} else{ %>
<option value="<%=doctors.getId()%>"><%=doctors.getEmployeeName() %></option>
<%} }%>
</select>
</td>		

</tr>


<%} %>

<input type="hidden" id="patientCount" name="patientCount" value=<%=incr%> />
</table>
<%}else{%>
<h4>NO RECORDS FOUND</h4>
<%} %>
</div>
<div class="clear"></div>
<%if(patientList.size()>0){ %>
<input type="Button" name="SubmitTransfer" value="Submit" tabindex="1" class="button" onclick="if(validatePatient() && validateDoctor()){submitPatients();}">
<%} %>
</form>
</body>
</html>

<script type="text/javascript">
function submitPatients(){
	submitForm('transferPatient','registration?method=submitTransferPatients');
}

function toggle1() {
	var cnt =document.getElementById('patientCount').value	;
	if(document.getElementById('srNoId1').checked)
	{
	for(var i = 1; i <= cnt; i++){
	
			document.getElementById('visitId'+i).checked =true;
	
	}
	}
else
	{
	for(var i = 1; i <= cnt; i++){
		
		document.getElementById('visitId'+i).checked =false;

		}
	}
}

function validatePatient(){
	
	var cnt =document.getElementById('patientCount').value	;
	for(var i = 1; i <= cnt; i++){
	  if(document.getElementById('visitId'+i).checked == true)
     {

		return true;
	  }
	}
	alert("Please select atleast one Patient !");
return false;

}

function validateDoctor(){
	var patients =document.getElementById('patientCount').value	;
	for(var i = 1; i <= patients; i++){
	  if(document.getElementById('visitId'+i).checked == true)
     {
		if(document.getElementById('doctors'+i).value==0){
			alert("Doctor Should not be Blank For Selected Row !");
			return false;
		}
	  }
	}
	return true;
}

</script>