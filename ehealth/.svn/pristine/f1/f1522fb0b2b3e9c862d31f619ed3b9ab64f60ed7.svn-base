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
	System.out.print("uhidStatus @@@@@@@@@@@@ ");
	if(map.get("uhidStatus") !=null)
	{
		System.out.print("uhidStatus ");
		uhidStatus1 =(Boolean)map.get("uhidStatus");
		System.out.print("uhidStatus "+uhidStatus1);
	}
	
	if(map.get("appointmentNo")!=null) 
	{
		appointmentNo =(String)map.get("appointmentNo");
	}%>

<form name="messageForm" method="post">
<%if(map.get("patientNameExist")!=null || map.get("recordExists")!=null)
			 	{
			 		if(map.get("recordExists")!=null)
			 		{
			 			recordExists=(Boolean)map.get("recordExists");
			 		}
			 		patientNameExist=(Boolean)map.get("patientNameExist");
			 		if(patientNameExist==true || recordExists==true)
			 		{
			 		%>
			 		<%if(map.get("departmentId")!=null){%> 
<input type="hidden" id="returnDeptId" name="returnDeptId" value="<%=map.get("departmentId")%>" />
<%}else{ %>
<input type="hidden" id="returnDeptId" name="returnDeptId" value="0" />
<%} %> 
<input type="hidden" id="returnPatientName" name="returnPatientName" value="<%=map.get("patientName") %>" />
 <%if(map.get("sex")!=null){%>
 <input type="hidden"	id="returnSex" name="returnSex" value="<%=map.get("sex") %>" />
 <%}else{ %>
 <input type="hidden"	id="returnSex" name="returnSex" value="" />
 <%} %>
 <%if(map.get("age")!=null){%> 
<input	type="hidden" id="returnAge" name="returnAge"	value="<%=map.get("age") %>" />
<%}else{ %>
<input	type="hidden" id="returnAge" name="returnAge"	value="0" />
<%} %>
	  <%if(map.get("ageUnit")!=null){%>
	   <input	type="hidden" id="returnAgeUnit" name="returnAgeUnit"	value="<%=map.get("ageUnit") %>" /> 
	   <%}else{ %> 
	<input type="hidden"	id="returnAgeUnit" name="returnAgeUnit" value="" />
	 <%} %> 
	<input	type="hidden" id="returnAppointmentDate" name="returnAppointmentDate"	value="<%=map.get("appointmentDate") %>" /> 
	<input type="hidden"	id="returnStartTime" name="returnStartTime"	value="<%=map.get("fromTimeSlot") %>" /> 
	<input type="hidden"	id="returnEndTime" name="returnEndTime"	value="<%=map.get("toTimeSlot") %>" />
	 <%if(map.get("mobileNo")!=null){%>
<input type="hidden" id="returnMobileNo" name="returnMobileNo"	value="<%=map.get("mobileNo") %>" /> <%}else{ %> 
<input type="hidden"	id="returnMobileNo" name="returnMobileNo" value="" /> <%} %> 
	<%if(map.get("hinId")!=null){%>
<input type="hidden" id="returnHinId" name="returnHinId"	value="<%=map.get("hinId") %>" /> <%}else{ %>
 <input type="hidden"	id="returnHinId" name="returnHinId" value="" /> <%} %>
	 <%if(recordExists==true)
		 			{ 
		 				alertMessage="You have already taken appointment for this Department :" ;
		 			}
		 			else
		 			{
		 				alertMessage="Duplicate Patient Name!!!";
		 			}
		 			
		 			%> <Script>
			 			if(confirm('<%=alertMessage%>'))
			 			{
			 				
			 				submitForm('messageForm','/hms/hms/appointment?method=showDialysisSchedulingJsp');
			 			}
			 		</script> <%		}
			 	}
			 %>

<h4><%=message %></h4>
<div class="clear"></div>
<input type="button" value="Back" class="button" onClick="submitForm('messageForm','/hms/hms/appointment?method=showDialysisSchedulingJsp')" />

<%-- <input	type="hidden" name="appointmentNo" value="<%=appointmentNo%>">
<% if(uhidStatus1 && flag.equals("appointment") && recordExists==false ){%> <input type="button" name="Print"
	value="Generate Slip" target="_blank" class="buttonBig" 	onClick="submitForm('messageForm','appointment?method=printAppointmentSlip');" />
<%} %> <% if( flag.equals("investigation")){%> <input type="button"
	name="Print" value="Generate Slip" target="_blank" class="buttonBig"
	onClick="submitForm('messageForm','appointment?method=printAppointmentInvestigationSlip');" />
<%} %> --%> <!-- -----------------------Vishal Code----------------------  -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
