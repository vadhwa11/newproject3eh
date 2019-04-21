<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	boolean patientNameExist = false;
 	boolean recordExists=false;
 	boolean uhidStatus1=false;
 	
 	
 	String alertMessage=null;
	String appointmentNo = null;
	String flag =null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	if(map.get("url")!=null)
	{
		url=(String)map.get("url");
	}
	
	//-----------------------Vishal Code----------------------
	if(map.get("flag")!=null)
	{
		flag =(String)map.get("flag");
	}
	
	if(map.get("uhidStatus") !=null)
	{
		uhidStatus1 =(Boolean)map.get("uhidStatus");
	}
	
	if(map.get("appointmentNo")!=null) 
	{
		appointmentNo =(String)map.get("appointmentNo");
	}%>

<form name="messageForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(map.get("patientNameExist")!=null || map.get("recordExists")!=null)
			 	{
			 		if(map.get("recordExists")!=null)
			 		{
			 			recordExists=(Boolean)map.get("recordExists");
			 		}
			 		patientNameExist=(Boolean)map.get("patientNameExist");
			 		if(patientNameExist==true || recordExists==true)
			 		{
			 		%> <input type="hidden" id="returnDeptId" name="returnDeptId"
	value="<%=map.get("departmentId")%>" /> <input type="hidden"
	id="returnEquipId" name="returnEquipId" value="<%=map.get("equipId")%>" />
<input type="hidden" id="returnPatientName" name="returnPatientName"
	value="<%=map.get("patientName") %>" /> <input type="hidden"
	id="returnSex" name="returnSex" value="<%=map.get("sex") %>" /> <input
	type="hidden" id="returnAge" name="returnAge"
	value="<%=map.get("age") %>" /> <%if(map.get("ageUnit")!=null){%> <input
	type="hidden" id="returnAgeUnit" name="returnAgeUnit"
	value="<%=map.get("ageUnit") %>" /> <%}else{ %> <input type="hidden"
	id="returnAgeUnit" name="returnAgeUnit" value="" /> <%} %> <input
	type="hidden" id="returnAppointmentDate" name="returnAppointmentDate"
	value="<%=map.get("appointmentDate") %>" /> <input type="hidden"
	id="returnStartTime" name="returnStartTime"
	value="<%=map.get("fromTimeSlot") %>" /> <input type="hidden"
	id="returnEndTime" name="returnEndTime"
	value="<%=map.get("toTimeSlot") %>" /> <%if(map.get("doctorId")!=null){%>
<input type="hidden" id="returnDoctorId" name="returnDoctorId"
	value="<%=map.get("doctorId") %>" /> <%}else{ %> <input type="hidden"
	id="returnDoctorId" name="returnDoctorId" value="" /> <%} %> <%if(map.get("doctorId")!=null){%>
<input type="hidden" id="returnDoctorId" name="returnDoctorId"
	value="<%=map.get("doctorId") %>" /> <%}else{ %> <input type="hidden"
	id="returnDoctorId" name="returnDoctorId" value="" /> <%} %> <%if(map.get("mobileNo")!=null){%>
<input type="hidden" id="returnMobileNo" name="returnMobileNo"
	value="<%=map.get("mobileNo") %>" /> <%}else{ %> <input type="hidden"
	id="returnMobileNo" name="returnMobileNo" value="" /> <%} %> <%if(map.get("hinId")!=null){%>
<input type="hidden" id="returnHinId" name="returnHinId"
	value="<%=map.get("hinId") %>" /> <%}else{ %> <input type="hidden"
	id="returnHinId" name="returnHinId" value="" /> <%} %> <%if(recordExists==true)
		 			{ 
		 				alertMessage="You have already taken appointment for this Department :" ;
		 			}
		 			else
		 			{
		 				alertMessage="Duplicate Patient Name!!!";
		 			}
		 			boolean duplicateRecord = false;
		 			duplicateRecord =  (Boolean)map.get("duplicateRecord");
		 			%> <Script>
			 			
			 			var fl = '<%=duplicateRecord%>';
			 			if(confirm('<%=alertMessage%>') && fl=="false")
			 			{
			 				//submitForm('messageForm','appointment?method=submitDulicatePatientNameInvAppointment');
			 				submitForm('messageForm','/hms/hms/registration?method=showOtherHospitalOnlineAppointmentJsp');
			 			}
			 		</script> <%		}
			 	}
			 %>

<h4><%=message %></h4>
<div class="clear"></div>
<input type="button" value="Back" class="button" onClick="submitForm('messageForm','/hms/hms/registration?method=showOtherHospitalOnlineAppointmentJsp')" />
<input type="hidden" name="pHinId" value="<%=map.get("phinId") %>" id="pHinId">
<input type="hidden" id="departmentId" name="departmentId" value="<%=","+map.get("departmentId")%>" />
<input type="hidden" id="appointmentDateOp" name="appointmentDateOp" value="<%=map.get("appointmentDateOp") %>" />

<!-- -----------------------Vishal Code----------------------  --> <input id="apptNo"
	type="hidden" name="appointmentNo" value="<%=appointmentNo%>">
<% if(uhidStatus1 && flag.equals("appointment") && recordExists==false ){%> <input type="button" name="Print"
	value="Generate Slip" target="_blank" class="buttonBig"
	onclick="submitFormForDirectPrint('messageForm','/hms/hms/appointment?method=printAppointmentSlip')"/><!--// added by govind on 11-01-2017 -->
<!-- 	onClick="submitForm('messageForm','appointment?method=printAppointmentSlip');" /> -->
<input type="button" name="Prescription" class="button" 
value="Print OP Card" onclick="submitFormForDirectPrint('messageForm','/hms/hms/registration?method=printPrescriptionCard')"/>
	
<%} %> <% if( flag.equals("investigation")){%> <input type="button"
	name="Print" value="Generate Slip" target="_blank" class="buttonBig"
	onclick="submitFormForDirectPrint('messageForm','/hms/hms/appointment?method=printAppointmentInvestigationSlip')"/><!--// added by govind on 11-01-2017 -->
<!-- 	onClick="submitForm('messageForm','appointment?method=printAppointmentInvestigationSlip');" /> -->
<input type="button" name="Prescription" class="button" 
value="Print OP Card" onclick="submitFormForDirectPrint('messageForm','/hms/hms/registration?method=printPrescriptionCard')"/>
<%} %> <!-- -----------------------Vishal Code----------------------  -->
</form>
<script type="text/javascript">
