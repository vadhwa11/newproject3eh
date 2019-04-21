<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="org.apache.derby.tools.sysinfo"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<!--By Vishnu  -->
<title>Waiting List For Surgery</title>

<script type="text/javascript" language="javascript">

	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
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

<div class="titleBg">
	<h2>Pending For Surgery Scheduling</h2>
</div>
<div class="clear"></div>

<% 
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
                 
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	boolean showSubmitButton=false;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

                 if(map.get("department") != null){
			       departmentList = (List<MasDepartment>)map.get("department");
		         }
                 
			 	List<OpdSurgeryHeader> waitList = new ArrayList<OpdSurgeryHeader>();
				if (map.get("waitList") != null) {
					waitList = (List) map.get("waitList");
				}	
			 	
			 	%>
<%if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<h4>
	<span><%=message %></span>
</h4>
<%}%>

<div class="clear"></div>


<!--Block One Starts-->
<form name="search" action="" method="post">
	<div class="Block">

		<label>Date</label> <input type="text" id="appointmentdate"
			name="<%=APPOINTMENT_DATE %>" class="date" value="" MAXLENGTH="30"
			readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="setdate('<%=currenDate %>',document.search.<%=APPOINTMENT_DATE%>,event);" />

		<label> Department</label> <select name="department" id="department">
			<option value="">Select Department</option>
			<% for(MasDepartment masDepartment:departmentList){ %>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
			<%} %>
		</select>
		<!-- <label>Unit</label>
 <select id="unit" name="unit"
	validate="Unit,number,no">
	<option value="">Select</option>
   </select> -->

		<label>UHID</label> <input type="text" name="hinNo" id="uhid" value=""></input>

		<div class="clear"></div>
		<label>IP No.</label> <input type="text" name="ipno" id="ipno"
			value=""></input> <label>Patient Name</label> <input type="text"
			name="pname" id="pname" value=""></input>

		<div class="clear"></div>

		<input type="button" name="Search" value="Search" class="button"
			onClick="submitForm('search','/hms/hms/ot?method=waitingList');" />

	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
</form>
<form name="itemGrid" method="post">

	<% int currentPage=0;
int noOfPages=0;
if(null !=map.get("currentPage")){
	currentPage=(Integer)map.get("currentPage");
    noOfPages=(Integer)map.get("noOfPages");
}
if(waitList.size()>0){%>

	<div class="Block">
		<table>
			<tr>
				<!-- <th>SI No</th>
    <th>Admission Date</th> -->
				<th>UHID</th>
				<th>Patient Name</th>
				<th>IP No. / OP No.</th>
				<th>Department</th>
				<th>PAC Status</th>
				<th>Unit</th>

			</tr>

			<% 
         int  counter=0;
        for(OpdSurgeryHeader object:waitList){
        	
        	/* if(object.getPatientStatus().equalsIgnoreCase("InPatient"))
        	{ */
        		counter++;
        	String patientName = "-";
        	try
        	{
        		patientName=object.getHin().getPFirstName();
        		if(object.getHin().getPMiddleName()!=null){
        			patientName += " "+object.getHin().getPMiddleName();
        		}
        		if(object.getHin().getPLastName()!=null){
        			patientName += " "+object.getHin().getPLastName();
        	}
        	}
        	catch (Exception e)
        	{
        	patientName = "-";
        	}
    %>

			<%--   <form name="servicRequest<%= counter%>" method="post"> --%>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<input type="hidden" name="requestId" value="<%=object.getId() %>" />
			<tr
				onclick="submitForm('itemGrid', 'ot?method=showOTBookingJsp&surgeryHdId=<%=(Integer)object.getId()%>')"
				style="cursor: pointer;">
				<%-- <td><%= counter%></td>
            <%if(object.getInpatient()!=null){ %>
            <td><%= HMSUtil.convertDateToStringWithoutTime(object.getInpatient().getDateOfAddmission())%></td>
            <%}else{ %>
            <td>-</td>
            <%} %> --%>
				<td><%= object.getHin().getHinNo()%></td>
				<td><%= patientName%></td>
				<%if(object.getInpatient()!=null){ %>
				<td><%= object.getInpatient().getAdNo()%></td>
				<%}else{ %>
				<td><%= object.getVisit().getTokenNo() %> / <%= object.getVisit().getTotalHospitalVisit()%></td>
				<%} %>
				<td><%= object.getPrescribedDepartment().getDepartmentName()%></td>
				<td><%= object.getPacStatus()%></td>
				<%if(object.getInpatient()!=null && object.getInpatient().getBed()!=null && object.getInpatient().getUnitM()!=null){ %>
				<td><%=object.getInpatient().getUnitM().getUnitCode() %></td>
				<%}else{ %>

				<%} %>
			</tr>

			<%}%>
		</table>

		<%if(currentPage !=1){%>
		<a href='/hms/hms/ot?method=waitingList&page=<%=currentPage-1%>'>Previous</a>
		<%}
	if(noOfPages>=1){%>
		<a href='/hms/hms/ot?method=waitingList&page=<%=currentPage%>'><%=currentPage%></a>
		<%}
	if(currentPage <noOfPages){%>
		<a href='/hms/hms/ot?method=waitingList&page=<%=currentPage+1%>'>Next</a>
		<%}%>
		<div class="Block">
			<input type="text" id="inPage" tabindex="2" maxlength="4"
				style="width: 30px;" /> <input type="button" value="Go" tabindex="2"
				onclick="searchParticularPage();" /> <label> No of Pages : <%=noOfPages%></label>
		</div>
		<%}
	else{%>
		<font size="4" color="red">No Record Found </font>
		<%}%>
		<div class="clear"></div>

	</div>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
</form>

<script type="text/javascript">
function searchParticularPage(type){
	var curPage=document.getElementById("inPage").value;
	if(!curPage || isNaN(curPage)){
		curPage=1;
	}
	submitForm('search','/hms/hms/ot?method=waitingList&page='+curPage);
}
</script>