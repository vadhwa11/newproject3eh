 <%--
 * Copyright 2016 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * studentDetailsById.jsp  
 * @author Kaushal Mishra 
  * Revision Date:      
 * Revision By: 
--%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.PhStudentHealthDetails"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script> 

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
	</script> 
<%
	Map<String,Object> map = new HashMap<String,Object>();
	 
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}  
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<PhStudentHealthDetails> studentList=new ArrayList<PhStudentHealthDetails>();
	  
	if(map.get("studentList") !=null){
		studentList =(List) map.get("studentList");
	}
	%>
<div class="clear"></div>
<div class="detailsDiv">
<div class="detailsDivLeft"><h4>Previous Health Records</h4></div>
<div class="detailsDivRight"><h4><a href="#" onclick="getBackPage();">Back</a></h4></div>
<div class="clear"></div>
</div>
<div id="pageNavPosition"></div>
	<%
		if(studentList.size()>0){
		%>

	<table >
		<tr>
		    <th width="13%">S No.</th>
			<th width="13%">Name</th>
			<th width="13%">House Name</th>
			<th width="13%">Date Of Birth</th>
			<th width="13%">Gender</th>
			<th width="13%">Date</th>
			<th width="13%">Class</th>
		</tr>
	<%int count=1; 
	for(PhStudentHealthDetails studList:studentList){ %>
	
		<form method="post" name="studentDetails<%=count %>">
		<input type="hidden" name="phStudentsHealthDetailsId" value="<%=studList.getId() %>" />
		<input type="hidden" name="studentId" value="<%=studList.getStudent().getId() %>" />
		<tr onclick="submitForm('studentDetails<%=count %>', 'pubHealth?method=getIndividualStudentDetails')">
		    <td><%=count %></td>
			<td><%=studList.getStudent().getMembersurvey().getName()!=null?studList.getStudent().getMembersurvey().getName():"" %></td>
			<td><%=studList.getStudent().getMembersurvey().getHouseName()!=null?studList.getStudent().getMembersurvey().getHouseName():"" %></td>
			<td><%=studList.getStudent().getMembersurvey().getDateOfBirth()!=null?HMSUtil.convertDateToStringWithoutTime(studList.getStudent().getMembersurvey().getDateOfBirth()):"" %></td>
			<td><%=studList.getStudent().getMembersurvey().getGender().getAdministrativeSexName()!=null?studList.getStudent().getMembersurvey().getGender().getAdministrativeSexName():"" %></td>
			<td><%=studList.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(studList.getLastChgDate()):"" %></td>
				<td><%=studList.getSchoolClass()!=null?studList.getSchoolClass():"" %></td>
		</tr> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
		<%++count;
		%>
		<input type="hidden" id="studId"  value="<%=studList.getStudent().getId()%>">
		<%}%>
	</table>
	
	 <%}else{%>
	 <h2>No Records Available</h2>
	    <%} %>
	
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

<script language="javascript">
function getBackPage()
{
	if(document.getElementById('studId')){
		var studentId=document.getElementById('studId').value;
	}else{
		var studentId = '<%=(Integer) map.get("studentId")%>';
	}
	
	window.location = "/hms/hms/pubHealth?method=getValueStudentRegistration&studentRegistrationId="+studentId;
	
		}
</script>