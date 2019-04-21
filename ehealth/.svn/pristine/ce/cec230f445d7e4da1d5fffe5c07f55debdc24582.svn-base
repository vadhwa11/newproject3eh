
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page isThreadSafe="false" %>
<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script lang="javascript"  src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%
Map<String,Object> map=null;
map=new HashMap<String,Object>();

List<Visit> visitList = null;
visitList = new ArrayList<Visit>();

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
if(map.get("visitList") != null){
	visitList = (List<Visit>)map.get("visitList");
}
List<MasDepartment> departmentList = null;
departmentList=new ArrayList<MasDepartment>();

if(map.get("departmentList") != null){
	departmentList = (List<MasDepartment>)map.get("departmentList");
}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
%>

<div class="Block">

<h2>Print OP Card</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<form name="referralPrintOpTicket"  method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>UHID</label>
<input type="text" name="uhid" value="" id="uhid"/>
<label>Op Clinic Service Center<span id="opClinicService"></span></label>
			<%-- <select id="deptId"
				name="<%=PATIENT_DEPARTMENT %>" tabindex=""  onchange="showLastVisitDetails();"> --%>
			<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="1" >
				<option value="0">Select</option>
				<%int departmentId = 0;
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%> 

			</select>

<input type="button" name="" class="button" 
value="Search" onclick="submitForm('referralPrintOpTicket','/hms/hms/registration?method=referralPrintOpTicketCard')"/>
</form>
<div class="clear"></div>
<div class="cmntable">
<table>
	
	<tr>
	 <th>UHID</th> 
	<th>Name</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Mobile No.</th>
	<th>Department</th>
	<!-- <th>UHID Print Status</th> -->
	</tr>
	
		<% 
		String tempHinNo="";
		for(Visit visit:visitList){
			if(!(visit.getHin().getHinNo().equals(tempHinNo))){
			tempHinNo=visit.getHin().getHinNo();
			%>
	<%-- <tr onclick="submitForm('search','/hms/hms/registration?method=showMsgForRegJsp&patientHinNo=<%=patient.getId()%>')"> --%>	
	<tr  onclick="pouplateHiddenValue(<%=visit.getId() %>,<%=visit.getHin().getId() %>);HighLightTR(this)" style="cursor: pointer;">
	
	<td><%=visit.getHin().getHinNo()%></td>
	<td><%=visit.getHin().getFullName()%></td>
	<td><%=visit.getHin().getSex().getAdministrativeSexName()%></td>
	<td><%=visit.getHin().getAge()%></td>
	
	<% if(null!=visit.getHin().getMobileNumber()){%>
	<td><%=visit.getHin().getMobileNumber()%></td>
	<%}else{
		%>
		<td></td>
		<% 
	}
	%>
	<td><%=visit.getDepartment().getDepartmentName()%></td>
</tr>
<%}
		}
		%>
	</table>
	</div>
	<div class="clear"></div>
	<form action=""  name="printPatientOpCard">
	
	
<input type="hidden" name="pHinId" id="pHinId"  value=""/>

<input type="hidden" name="visitId" id="visitId" value="" />

	<input type="button" name="" class="button" 
value="Print" onclick="if(check()){submitFormForDirectPrint('printPatientOpCard','/hms/hms/registration?method=referralPrintPrescriptionCard')}"/>
	</form>
	<script type="text/javascript">
	function pouplateHiddenValue(visitId,hinId){
		document.getElementById('pHinId').value=hinId;
		document.getElementById('visitId').value=visitId;
		
	}
	function check(){
	var pHinId=	document.getElementById('pHinId').value;
	if(!pHinId ){
		alert("Select Patient ")
		return false;
	}
	return true;
	}
	</script>
</div>
</body>
</html>