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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script lang="javascript"  src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<head>

<title>Reprint Advanced Ticket</title>
</head>
<body>
	<%
	Map<String,Object> map=null;
	map=new HashMap<String,Object>();
	String appointmentNo = null;
	List<Visit> visitList = null;
	visitList = new ArrayList<Visit>();
	
	if(request.getAttribute("map")!=null){
		map=(Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("visitList") != null){
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("appointmentNo")!=null) 
	{
		appointmentNo =(String)map.get("appointmentNo");
	}
	List<MasDepartment> departmentList = null;
	departmentList=new ArrayList<MasDepartment>();
	
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	int currentPage = 0;
	if(map.get("currentPage")!=null){
		currentPage=(Integer)map.get("currentPage");
	}
	int noOfPages = 0;
	if(map.get("currentPage")!=null){
	noOfPages=(Integer)map.get("noOfPages");
	}
	String Name ="";
	int patientDepartment=0;
	String FromDate = "";
	String ToDate = "";
	String MobileNo = "";
	String uhid = "";
	if(map.get("patientDepartment")!=null){
		patientDepartment=(Integer)map.get("patientDepartment");
	}
	if(map.get("FromDate")!=null){
		FromDate=(String)map.get("FromDate");
	}
	if(map.get("ToDate")!=null){
		ToDate=(String)map.get("ToDate");
	}
	if(map.get("Name")!=null){
		Name=(String)map.get("Name");
	}
	if(map.get("MobileNo")!=null){
		MobileNo=(String)map.get("MobileNo");
	}
	if(map.get("uhid")!=null){
		uhid=(String)map.get("uhid");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTimeDBFormat();
	String currentDate = (String)utilMap.get("currentDate");
%>

<div class="Block">

<h2>Print OP Card</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<form name="rePrintAdvancedOpTicket"  method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>From Date</label>
<input type="text"	id="FromDate" name="FromDate" value="<%=currentDate %>"	class="date" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.rePrintAdvancedOpTicket.FromDate,event)" />


<label>To Date</label>
<input type="text" id="ToDate" name="ToDate" value="<%=currentDate %>" class="date"  MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.rePrintAdvancedOpTicket.TODATE,event)" />
 
 <label>UHID</label>
<input type="text" name="uhid" value="" id="uhid"/>

<div class="clear"></div>
<label>Name</label>
<input type="text" name="Name" value="" id="name"/>

<label>Mobile No.</label>
<input type="text" name="MobileNo" value="" id="Mobile No"/>
<label>Op Clinic Service Center<span id="opClinicService"></span></label>
			<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="1" >
				<option value="0">Select</option>
				<%int departmentId = 0;
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%> 
			</select>

<input type="button" name="" class="button" 
value="Search" onclick="submitForm('rePrintAdvancedOpTicket','/hms/hms/registration?method=rePrintAdvancedOpTicket')"/>
</form>
<div class="cmntable">
<table>
	
	<tr>
	 <th>UHID</th> 
	<th>Name</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Mobile No.</th>
	<th>Department</th>
	</tr>
	
		<% 
		String tempHinNo="";
			
		for(Visit visit:visitList){
			if(!(visit.getHin().getHinNo().equals(tempHinNo))){
			tempHinNo=visit.getHin().getHinNo();
			%>
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
	<%
	if(currentPage > 1 ){%>
		<a href='/hms/hms/registration?method=showRePrintAdvancedOpTicketJsp&page=<%=currentPage-1%>&patientDepartment=<%=patientDepartment%>&FromDate=<%=FromDate%>&ToDate=<%=ToDate%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'>Previous</a>
	<%}

if(noOfPages>=1){
	//for(int i=1;i<=noOfPages;i++){
		//if(currentPage==i){%>

	<a
		href='/hms/hms/registration?method=showRePrintAdvancedOpTicketJsp&page=<%=currentPage%>&patientDepartment=<%=patientDepartment%>&FromDate=<%=FromDate%>&ToDate=<%=ToDate%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'><%=currentPage%></a>
	<%
	//}}
}
if(currentPage <noOfPages){%>

	<a
		href='/hms/hms/registration?method=showRePrintAdvancedOpTicketJsp&page=<%=currentPage+1%>&patientDepartment=<%=patientDepartment%>&FromDate=<%=FromDate%>&ToDate=<%=ToDate%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'>Next</a>
	
	<%}%>
	<div class="clear"></div>
	<form action=""  name="printPatientOpCard">
	
	
<input type="hidden" name="pHinId" id="pHinId"  value=""/>

<input type="hidden" name="visitId" id="visitId" value="" />

<input id="apptNo"	type="hidden" name="appointmentNo" value="<%=appointmentNo%>">

	<input type="button" name="" class="button" 
value="Print" onclick="if(check()){submitFormForDirectPrint('printPatientOpCard','/hms/hms/registration?method=printAppointmentSlips')}"/>

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