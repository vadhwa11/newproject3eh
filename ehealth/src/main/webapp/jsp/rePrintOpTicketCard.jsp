
<%@page import="org.apache.commons.lang.StringUtils"%>
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
	String FromTime = "";
	String ToTime = "";
	String MobileNo = "";
	String uhid = "";
	if(map.get(PATIENT_DEPARTMENT)!=null){
		patientDepartment=(Integer)map.get(PATIENT_DEPARTMENT);
	}
	if(map.get("FromTime")!=null){
		FromTime=(String)map.get("FromTime");
	}
	if(map.get("ToTime")!=null){
		ToTime=(String)map.get("ToTime");
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
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	System.out.println("time"+time);
%>

<div class="Block">

<h2>Print OP Card</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<form name="rePrintOpTicket"  method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="medium">From Time</label>
<input type="text" name="FromTime"  id="FromTime" value="<%=!StringUtils.isBlank(FromTime)?FromTime:time%>" class="small"
onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5""/>
<label class="medium">To Time</label>
<input type="text" name="ToTime"  id="ToTime" class="small"  value="<%=!StringUtils.isBlank(ToTime)?ToTime:time%>"
onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="medium">UHID</label>
<input type="text" name="uhid" value="<%=uhid!=null?uhid:""%>" id="uhid"/>

<div class="clear"></div>
<label class="medium">Name</label>
<input type="text" name="Name" value="<%=Name!=null?Name:""%>" id="name"/>

<label class="medium">Mobile No.</label>
<input type="text" name="MobileNo" value="<%=MobileNo!=null?MobileNo:""%>" id="Mobile No" class="small" style="text-align:left;"/>
<label>Op Clinic Service Center<span id="opClinicService"></span></label>
			<%-- <select id="deptId"
				name="<%=PATIENT_DEPARTMENT %>" tabindex=""  onchange="showLastVisitDetails();"> --%>
			<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="1" >
				<option value="0">Select</option>
				<%int departmentId = 0;
				for(MasDepartment masDepartment : departmentList)
		{%>
		
			<option value="<%=masDepartment.getId() %>" <%=patientDepartment==masDepartment.getId()?"selected":"" %>><%=masDepartment.getDepartmentName() %></option>
				<%}%> 

			</select>

<input type="button" name="" class="button" 
value="Search" onclick="if(timeCheck()){submitForm('rePrintOpTicket','/hms/hms/registration?method=rePrintOpTicketCard')}"/>

</form>
<%if(visitList.size()>0){%>
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


	<%
	if(currentPage > 1 ){%>

		<a href='/hms/hms/registration?method=showRePrintOpTicketJsp&page=<%=currentPage-1%>&patientDepartment=<%=patientDepartment%>&FromTime=<%=FromTime%>&ToTime=<%=ToTime%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'>Previous</a>


	<%}

if(noOfPages>=1){
	//for(int i=1;i<=noOfPages;i++){
		//if(currentPage==i){%>
<%-- 	<%=i%> --%>
<%-- 	<%//}else{%> --%>

	<a
		href='/hms/hms/registration?method=showRePrintOpTicketJsp&page=<%=currentPage%>&patientDepartment=<%=patientDepartment%>&FromTime=<%=FromTime%>&ToTime=<%=ToTime%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'><%=currentPage%></a>
	<%
	//}}
}
if(currentPage <noOfPages){%>

	<a
		href='/hms/hms/registration?method=showRePrintOpTicketJsp&page=<%=currentPage+1%>&patientDepartment=<%=patientDepartment%>&FromTime=<%=FromTime%>&ToTime=<%=ToTime%>&Name=<%=Name%>&MobileNo=<%=MobileNo%>&uhid=<%=uhid%>'>Next</a>
	
	<%}%>

	<div class="clear"></div>
	<form action=""  name="printPatientOpCard">
	
	
<input type="hidden" name="pHinId" id="pHinId"  value=""/>

<input type="hidden" name="visitId" id="visitId" value="" />

	<input type="button" name="" class="button" 
value="Print" onclick="if(check()){submitFormForDirectPrint('printPatientOpCard','/hms/hms/registration?method=reapetPrintPrescriptionCard')}"/>
	</form>
		<%}else{%>
		<h4>No records found.</h4>
		<%} %>
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
	<script type="text/javascript">
	function timeCheck(){
		var fromTime = document.getElementById('FromTime').value;
		var toTime = document.getElementById('ToTime').value;
		if(fromTime!="" || toTime!=""){
		var fromHours = fromTime.split(':');
		var toHours = toTime.split(':');
		var fHours = fromHours[0];
		var tHours = toHours[0];
		var fMin = fromHours[1];
		var tMin = toHours[1];
		if( (parseInt(fHours)) <= (parseInt(tHours)) && (fHours !=tHours || ( parseInt(fMin)) <= (parseInt(tMin)))){
			return true;			
		}else{
			if(fromTime=="")
				alert("Please enter From Time");
			else if(toTime=="")
				alert("Please enter To Time");
			else
			alert('From Time must be less than To Time');
			return false;
		}
		}
		return true;
	}
	</script>
</div>
</body>
</html>