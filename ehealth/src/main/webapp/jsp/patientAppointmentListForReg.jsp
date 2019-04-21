<%-- 
			 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
			 * Use is subject to license terms.
			 * File Name           : appointmentPatient.jsp 
			 * Tables Used         : 
			 * Description         : 
			 * @author  Create Date: 18/07/2011   Name: Ujjwal Kashyap
			 * Revision Date:      Revision By: 
			 * @version 1.0  
		--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>



<form name="patientSearch" action="" method="post"><script
	type="text/javascript" language="javascript">
			<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
				serverdate = '<%=date + "/" + month + "/" + year%>'
			</script> <%
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
 	List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	String userName = "";
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("patientList") != null) {
 		patientList = (List<AppPatientAppointments>) map
 				.get("patientList");
 	}
 	if (map.get("departmentList") != null) {
 		departmentList = (List<MasDepartment>) map
 				.get("departmentList");
 	}

 	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	if (map.get("message") != null) {
 		String message = (String) map.get("message");
 %> <span> <%=message%></span> <%
 	}
 %>



<div class="titleBg">
<h2> Patient Appointments (Registration)</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<%
	int counter = 0;
	if (patientList != null && patientList.size() > 0) {
%>

<div class="cmntable">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">Department</th>
		<th scope="col">Registration No</th>
		<th scope="col">Doctor</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Age</th>
		<th scope="col">Appointment No.</th>
		<th scope="col">Appointment Date</th>
		<th scope="col">Timings</th>
		<th scope="col"></th>
	</tr>


	<%
		for (AppPatientAppointments appPatientAppointments : patientList) {
				//AppPatientAppointments appPatientAppointments = appPatientAppointments.getHin();
				if (appPatientAppointments.getHin() == null) {
					if((HMSUtil.changeDateToddMMyyyy(appPatientAppointments.getAppointmentDate())).equals(currentDate)){ 
	%>
	<tr>
		<td><input type="radio" id="parent<%=counter%>"
			name="<%=APPOINTMENT_ID %>" class="radioCheck"
			value="<%=appPatientAppointments.getId()%>" /></td>
		<td><input type="text" id="wardId<%=counter%>"
			name="<%=WARD_ID%>"
			value="<%=appPatientAppointments.getDepartment()
								.getDepartmentName()%>"
			class="readOnly" readonly="readonly" /></td>
		<td>
		<%
			if (appPatientAppointments.getHin() != null) {
		%>
		<input type="text"	size="8" id="hinNo<%=counter%>" name="<%=HIN_NO%>"
			value="<%=appPatientAppointments.getHin()
									.getHinNo()%>"
			class="readOnly" readonly="readonly" /> <%
 	} else {
 %> <input type="text"
			size="8" id="hinNo<%=counter%>" name="<%=HIN_NO%>" value=""
			readonly="readonly" /> <%
 	}
 %>
		</td>
				<td>
				<%if(appPatientAppointments.getEmployee()!=null){ %>
		<input type="text" id="employeeId<%=counter%>"	name=<%=NAME%>
			value="<%=appPatientAppointments.getEmployee().getFirstName().concat(" ").concat(appPatientAppointments.getEmployee().getLastName())%>"
			class="readOnly" readonly="readonly" />
		<%}else{ %>
				<input type="text" id="employeeId<%=counter%>"	name=<%=NAME%>
			value=""
			class="readOnly" readonly="readonly" /><%} %>
		
		</td>

		<td><input type="text" id="patientName<%=counter%>"
			name="<%=PATIENT_NAME%>"
			value="<%=appPatientAppointments.getPatientName()%>" class="readOnly"
			readonly="readonly" /></td>
		<td><input type="text" size="8" id="age<%=counter%>"
			name="<%=AGE%>" value="<%=appPatientAppointments.getAge()%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentNo<%=counter%>"
			name="<%=APPOINTMENT_NO%>"
			value="<%=appPatientAppointments.getAppointmentNo()%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter%>"
			name="apptDate"
			value="<%=HMSUtil
								.changeDateToddMMyyyy(appPatientAppointments
										.getAppointmentDate())%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter%>"
			name="<%=FROM_TIME%>"
			value="<%=appPatientAppointments.getFromTimeSlot()%> - <%=appPatientAppointments.getToTimeSlot()%>"
			class="readOnly" readonly="readonly" /></td>
			<td><input type="button" id="parent<%=counter%>" name="<%=NAME%>" class="button" value="Go" onclick="submitForm('patientSearch','/hms/hms/registration?method=showRegistrationForAppointmentJsp&patientName=<%=appPatientAppointments.getId()%>');" /></td>
	</tr>
	<%
		}}
	%>
	<%
		counter++;
			}
	%>
</table>
</div>
<!--Bottom labels starts-->

<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName%></label> <label>Changed Date </label> <label
	class="value"><%=currentDate%></label> <label>Changed Time </label> <label
	class="value"><%=time%></label></div>
<%
	}
%>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<div class="paddingTop40"></div>

<script>
		function validateAppointmentRadio(){
			var msg="Select a Appointment for Cancellation !!";
			 for(var i = 0; i < document.getElementsByName('appointmentId').length; i++){
			  if(document.getElementsByName('appointmentId')[i].checked)
              { msg="";
					break;
			 	}
			}		
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
		</script>