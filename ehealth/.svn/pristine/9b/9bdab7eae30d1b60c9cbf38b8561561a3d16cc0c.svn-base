<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<!-- <script src="/hms/jsp/js/dischargeMedication.js" type="text/javascript"></script> -->
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript">
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
MasDepartment deptObj=new MasDepartment();

if(map.get("doctorObj")!=null){
	doctor=(MasEmployee)map.get("doctorObj");
}
if(map.get("deptObj")!=null){
	deptObj=(MasDepartment)map.get("deptObj");
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

</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%if(success){%>
<h4><span>Data Submitted Successfully !</span></h4>
<%} %>
</head>
<form name="editVisit" method="post" action="/hms/hms/registration?method=submitEditVisitDetails">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hospitalId" Value="<%=hospitalId %>" />
<div class="clear"></div>
<label>Department Name</label>
<select id="deptId" name="deptId" onchange="getDoctors(this.value);">
<option value="0">Select</option>

<%
if(departmentMap.size()>0){
	for(Map.Entry<Integer,String> depMap:departmentMap.entrySet()){
		if(depMap.getKey()==departmentId){
%>
<option value="<%=depMap.getKey()%>" selected="selected"><%=depMap.getValue() %></option>
<%}else{ %>
<option value="<%=depMap.getKey()%>"><%=depMap.getValue() %></option>
<%} }}%>

</select>

<label>Doctors</label>
<%-- <select id="doctors" name="doctors">
<option value="0">Select</option>
<%if(docNameMap.size()>0){ for(Map.Entry<Integer,String> docmap:docNameMap.entrySet()){ if(docmap.getKey()==doctorId){%>
<option value="<%=docmap.getKey()%>" selected="selected"><%=docmap.getValue() %></option>
<%}else{ %>

<option value="<%=docmap.getKey()%>" ><%=docmap.getValue() %></option>
<%}} }%>
</select> --%>

<select id="doctors" name="doctors">
<option value="0">Select</option>
<%if(doctorsList2.size()>0){ for(MasEmployee docList:doctorsList2){ if(docList.getId()==doctorId){%>
<option value="<%=docList.getId()%>" selected="selected"><%=docList.getEmployeeName() %></option>
<%}else{ %>

<option value="<%=docList.getId()%>" ><%=docList.getEmployeeName() %></option>
<%}} }%>
</select>

<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button" onclick="searchVisits();">
<!-- <input type="submit" name="SubmitEditVisit" value="Submit" tabindex="1" class="button" onclick="validatePatient();">
<input type="Button" name="CommonPool" value="CommonPool" tabindex="1" class="button" onclick="sendToCommonPool();"> -->
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
<div class="clear"></div><br>
<%if(patientList.size()>0){ %>
<!-- <input type="submit" name="SubmitEditVisit" value="Submit" tabindex="1" class="button" onclick="validatePatient();"> -->
<input type="Button" name="SubmitEditVisit" value="Submit" tabindex="1" class="button" onclick="if(validatePatient()){submitPatients();}">
<input type="Button" name="CommonPool" value="CommonPool" tabindex="1" class="button" onclick="sendToCommonPool();">
<%} %>

</form>

<body>

</body>
</html>

<script>
function submitPatients(){
	submitForm('editVisit','registration?method=submitEditVisitDetails');
}
function searchVisits(){
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	var deptId=document.getElementById("deptId").value;
	var docId=document.getElementById("doctors").value;
	if(deptId=="0"){
		alert("Please Select Service Center !");
		return false;
	}else{
		submitForm('editVisit','registration?method=showEditVisitDetails&hospitalId=' + hospitalId + '&'
				+ csrfTokenName + '=' + csrfTokenValue +'&deptId='+deptId+'&docId='+docId);
	}
	
	
}

function sendToCommonPool(){
	submitForm('editVisit','registration?method=submitEditVisitDetails&commonPool=commonPool&'
			+ csrfTokenName + '=' + csrfTokenValue);
}

function getDoctors(departmentId) {

	  var xmlHttp=null;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	  
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	    	  var data=this.responseText;
		    	
		    	var dt=data.toString();
				var result = dt.slice(1, -1);
				
				var unitData=result.split(",");
				
				document.getElementById('doctors').options.length = 1;
				var select = document.getElementById('doctors');
				
		
				for(var index=0;index<unitData.length;index++){
					
					var hospUnitData=unitData[index].split(":");
					var opt = document.createElement('option');
					opt.value = hospUnitData[0].trim();
				    opt.innerHTML = hospUnitData[1].trim();
				    select.appendChild(opt);
				    
				}
	      }
	    }
	  

	       var url="/hms/hms/registration?method=getDoctorsForDept&depatmentId="+departmentId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	   
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
	alert("Please select atleast one Patient !")
return false;

}


</script>