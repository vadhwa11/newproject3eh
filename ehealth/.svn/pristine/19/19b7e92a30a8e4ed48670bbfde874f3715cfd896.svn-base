<%@page import="jkt.hms.masters.business.QueueManagment"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
List<QueueManagment> patientList2=new ArrayList<QueueManagment>();
if(map.get("patients2")!=null){
	patientList2=(List<QueueManagment>)map.get("patients2");
}

List<MasEmployee> doctorsList=new ArrayList<MasEmployee>();
if(map.get("DoctorsObjects")!=null){
	doctorsList=(List<MasEmployee>)map.get("DoctorsObjects");
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
<label>Service Center</label>
<select id="deptId" name="deptId" >
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

<label>Token Number</label>
<input type="text" name="tokenNumber" value=""  validate="Token Number, metacharDot, no"  id="tokenNumberId" onblur="ValidatetokenNumber('tokenNumberId');">

<input type="hidden" name="doctors" value="" >

<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button" onclick="searchVisits();">
<div class="clear"></div><br>
<div class="cmnTable" >

<%if(patientList2.size()>0){ int incr=0;%>
<table id="patientTable">
<tr>
<th><input type="checkbox" name="itemApproval" id="srNoId1" onchange="toggle1()"></th>
<th>Token No</th>
<th>UHID</th>
<th>Patient Name</th>
<th>Next</th>
<th>Status</th>
<th>Common Pool</th>
<th>Emergency</th>
<th>Last Display After</th>
<!-- <th>Call After</th> -->
<th>Assigned Doctor</th>
<!-- <th>UnRelease</th> -->

</tr>
<%for(QueueManagment queue:patientList2){
	incr++;
%>
<tr>
<%if(queue.getVisit().getVisitStatus()!=null && "a".equals(queue.getVisit().getVisitStatus())){ %>
<td><input type="checkbox" id="visitId<%=incr%>" name="visitId<%=incr%>" value="<%=queue.getVisit().getId()%>"/></td>
<%}else{ %>
<td></td>
<%} %>
<td><input type="text" readonly="readonly" name="tokensNo" value="<%=queue.getVisit().getTokenNo()!=null?queue.getVisit().getTokenNo():"" %>" id="tokenNoId<%=incr%>"></td>
<td><%=queue.getVisit().getHin().getHinNo()!=null?queue.getVisit().getHin().getHinNo():"" %></td>
<td><%=queue.getVisit().getHin().getPFirstName()!=null?queue.getVisit().getHin().getPFirstName():"" %></td>
<%if(queue.getVisit()!=null && queue.getVisit().getOpCallCount() !=null && queue.getVisit().getOpCallCount()==0 ){ %>
<td></td>
<%}else{ %>
<td><%=queue.getVisit().getOpCallCount()!=null?queue.getVisit().getOpCallCount():"" %></td>
<%} %>

<%if(queue.getTokenStatus()!=null && "p".equals(queue.getTokenStatus())){ %>
<td style='background-color:#F7FF81;'>Parked</td>
<%}else if(queue.getTokenStatus()!=null && "w".equals(queue.getTokenStatus())){ %>
<td style='background-color:#93FAEF;'>Waiting</td>
<%}else if(queue.getTokenStatus()!=null && "C".equalsIgnoreCase(queue.getTokenStatus())){ %>
<td style='background-color:#F7C3F1;'>Completed</td>
<%}else if(queue.getVisit().getVisitStatus()!=null && "a".equals(queue.getVisit().getVisitStatus())){ %>
<td style='background-color:#F7C3F1;'>Released</td>
<%}else{ %>
<td style='background-color:#B1FF81;'>In progress</td>
<%} %>
<td><%=queue.getTransferToCommonPoolCount()!=null?queue.getTransferToCommonPoolCount():""%></td>
<%if(queue.getPatientSpecialCategory()!=null && queue.getPatientSpecialCategory().equals("E")) {%>
<td style='background-color:#FA8B7C;'><%=queue.getPatientSpecialCategory()!=null?queue.getPatientSpecialCategory():""%></td>
<%}else if(queue.getPatientSpecialCategory()!=null && queue.getPatientSpecialCategory().equals("C")){ %>
<td style='background-color:#93FAEF;'><%=queue.getPatientSpecialCategory()!=null?queue.getPatientSpecialCategory():""%></td>
<%}else { %>
<td><%=queue.getPatientSpecialCategory()!=null?queue.getPatientSpecialCategory():""%></td>
<%} %>
<%if(queue.getVisit()!=null && queue.getVisit().getDisplayAfterNo()!=null && queue.getVisit().getDisplayAfterNo()!=-1){ %>
<td><%=queue.getVisit().getDisplayAfterNo()!=null?queue.getVisit().getDisplayAfterNo():"" %></td>
<%}else{ %>
<td></td>
<%}%>
<%-- <td><input type="text" name="displayAfter" value="" validate="Call after, int, no" id="callAfter<%=incr%>" ></td> --%>
<% if(queue.getInitialDr()!=null && !"".equals(queue.getInitialDr())){%>
<td><%=queue.getInitialDr().getEmployeeName()!=null?queue.getInitialDr().getEmployeeName():"" %></td>
<%}else{ %>
<td></td>
 <%} %>
 <%if(queue.getTokenStatus()!=null && "a".equalsIgnoreCase(queue.getTokenStatus())){ %>
<!-- <td><input type="checkbox" name="unrelease" value="y" id="unrelease"></td> -->
<%}else{ %>
<!-- <td></td> -->
<%} %>
</tr>
<%} %>

<input type="hidden" id="patientCount" name="patientCount" value=<%=incr%> />
</table>
<%}else{%>
<h4>NO RECORDS FOUND</h4>
<%} %>
</div>
<div class="clear"></div><br>
<%if(patientList2.size()>0){ %>
<input type="Button" name="SubmitEditVisit" value="Submit" tabindex="1" class="button" onclick="if(validatePatient()){submitPatients();}">

<%} %>

</form>

<body>

</body>
<script>
function submitPatients(){
	submitForm('editVisit','registration?method=submitPatientVisitDetails&unrelease=y');
}
function searchVisits(){
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	var deptId=document.getElementById("deptId").value;
	if(deptId=="0"){
		alert("Please Select Service Center !");
		return false;
	}else{
		submitForm('editVisit','registration?method=releasedPatientDetails&hospitalId=' + hospitalId + '&'
				+ csrfTokenName + '=' + csrfTokenValue +'&deptId='+deptId);
	}
	
}

function sendToCommonPool(){
	submitForm('editVisit','registration?method=submitEditVisitDetails&commonPool=commonPool&'
			+ csrfTokenName + '=' + csrfTokenValue);
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

function ValidatetokenNumber(tokenNumberId) {
	var fld = document.getElementById(tokenNumberId);
	if (fld.value == "") {
		alert("You didn't enter a token number.");
		return false;
	} else if (isNaN(fld.value)) {
		alert("The token number contains illegal characters.");
		fld.value = "";
		return false;
	} 
}

</script>
</html>
