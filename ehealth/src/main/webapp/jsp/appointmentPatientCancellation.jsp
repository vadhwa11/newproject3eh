
<%-- 
			 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
			 * Use is subject to license terms.
			 * File Name           : appointmentPatientCancel.jsp 
			 * Tables Used         : 
			 * Description         : 
			 * @author  Create Date: 01.09.2008    Name: Priyanka Garg
			 * Revision Date:      Revision By: 
			 * @version 1.0  
		--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments;"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<!-- <script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script> -->




<form name="patientSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript" language="javascript">
			<%
			
			URL myURL=application.getResource("/WEB-INF/commonFile.properties");
			InputStream in = myURL.openStream();
			Properties prop = new Properties();
			prop.load(in);

				Calendar calendar=Calendar.getInstance();
				String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
				String date=String.valueOf(calendar.get(Calendar.DATE));
				int year=calendar.get(calendar.YEAR);
				if(month.length()<2){
					month="0"+month;
				}
				if(date.length()<2){
					date="0"+date;
				}
			%>
				serverdate = '<%=date+"/"+month+"/"+year%>'
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
				if(request.getAttribute("map") != null){
					map = (Map<String, Object>)request.getAttribute("map");
				}
				if(map.get("patientList") != null){
					patientList= (List<AppPatientAppointments>)map.get("patientList");
				}
				if(map.get("departmentList") != null){
					departmentList= (List<MasDepartment>)map.get("departmentList");
				}
				
				if(session.getAttribute("userName") != null){
				 userName = (String)session.getAttribute("userName");
				}
				if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <span> <%=message %></span> <%    
					   
					  }		 	
			 %>



<div class="titleBg">
<h2>Cancellation for Patient Appointments</h2>
</div>
<div class="clear"></div>
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="Block"><!--<label> Service No.</label>
					--><input type="hidden" name="<%=SERVICE_NO %>" value=""
	MAXLENGTH="20" /> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="50" /> <label>Department</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							int deptId=(Integer)session.getAttribute("deptId");
							if(departmentList!= null){
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getId()==deptId){
						%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	
								}
							}
						}
						%>
</select>

<div class="clear"></div>

<label> Patient Name</label> <input type="text"
	name="<%=PATIENT_NAME %>" value="" MAXLENGTH="30" /> <label>
Age</label> <input type="text" name="<%=AGE %>" value="" MAXLENGTH="2" /> 


<label>Appointment
Date</label> <input type="text" class="date" id="fromDateId" class="date"
	name="<%=APPOINTMENT_DATE %>" value="" readonly="readonly"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.patientSearch.<%=APPOINTMENT_DATE%>,event);" />



<div class="clear"></div>

<label> Appointment No:</label> <input type="text"
	name="<%=APPOINTMENT_NO %>" value="" MAXLENGTH="40" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Submit" id="searchButton"
	onclick="submitForm('patientSearch','/hms/hms/appointment?method=patientAppointmentList');"
	value="Search" class="button" accesskey="a" /> <input name="a"
	type="reset" class="buttonHighlight" value="Reset" />
<div class="clear"></div>

<!--Block Three Starts-->

<div class="paddingTop15"></div>
<%
			    int  counter=0;
System.out.println("patientList>>"+patientList.size());
				if (patientList != null && patientList.size() > 0) { 
			%>


<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">Department</th>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
		<th scope="col">Patient Name</th>
		<th scope="col">Doctor Name</th>
		<th scope="col">Age</th>
		<th scope="col">Appointment No.</th>
		<th scope="col">Appointment <br />
		Date</th>
		<th scope="col">Timings</th>
	</tr>


	<% 	
				for(AppPatientAppointments appPatientAppointments: patientList){
					//AppPatientAppointments appPatientAppointments = appPatientAppointments.getHin();
			%>
	<tr>
		<td><input type="checkbox" id="parent<%=counter%>"
			name="<%=APPOINTMENT_ID %>"
			value="<%=appPatientAppointments.getId()%>" /></td>
		<td><input type="text" id="wardId<%=counter %>"
			name="<%=WARD_ID%>"
			value="<%=appPatientAppointments.getDepartment().getDepartmentName()%>"
			class="readOnly" readonly="readonly" /></td>
		<td>
		<%if(appPatientAppointments.getHin()!=null){ %> <input type="text"
			size="8" id="hinNo<%=counter %>" name="<%=HIN_NO%>"
			value="<%=appPatientAppointments.getHin().getHinNo()%>"
			class="readOnly" readonly="readonly" /> <%}else{%> <input type="text"
			size="8" id="hinNo<%=counter %>" name="<%=HIN_NO%>" value=""
			readonly="readonly" /> <%} %>
		</td>
		<td><input type="text" id="patientName<%=counter %>"
			name="<%=PATIENT_NAME%>"
			value="<%=appPatientAppointments.getPatientName()%>" class="readOnly"
			readonly="readonly" /></td>
			
		<td>
		<%if(appPatientAppointments.getEmployee() !=null){ %>
		<input type="text" id="doctorName<%=counter %>" name="<%=DOCTOR_NAME%>" value="<%=appPatientAppointments.getEmployee().getFirstName().concat(" ").concat(appPatientAppointments.getEmployee().getLastName())%>" class="readOnly" readonly="readonly" />
		<%}else{ %>
		<input type="text" id="doctorName<%=counter %>" name="<%=DOCTOR_NAME%>" value="" class="readOnly" readonly="readonly" />
		<%} %>
		</td>	
			
			
			
		<td><input type="text" size="8" id="age<%=counter %>"
			name="<%=AGE%>" value="<%=appPatientAppointments.getAge()%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentNo<%=counter %>"
			name="<%=APPOINTMENT_NO%>"
			value="<%=appPatientAppointments.getAppointmentNo()%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter %>"
			name="apptDate"
			value="<%=HMSUtil.changeDateToddMMyyyy(appPatientAppointments.getAppointmentDate())%>"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" id="appointmentDate<%=counter %>"
			name="<%=FROM_TIME%>"
			value="<%=appPatientAppointments.getFromTimeSlot()%> - <%=appPatientAppointments.getToTimeSlot()%>"
			class="readOnly" readonly="readonly" /></td>
	</tr>
	<%	     counter++;
				    }	
			
					
			%>
</table>

<!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input name="" type="button" class="buttonBig"
	value="Cancel Appointment"
	onclick="if(validateAppointmentRadio())submitForm('patientSearch','appointment?method=submitCancelPatientAppointment');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <labelclass="value"><%="javed" %></label>
	 <label>Changed Date </label> <label class="value"><%=currentDate %></label>
	 <label>Changed Time </label> <label class="value"><%=time%></label></div>
	
<%} %>
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