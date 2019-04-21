<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Amit Das
 * Create Date: 06th Nov,2016 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="java.util.*"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<AppPatientAppointments> appPatientAppointmentList = new ArrayList<AppPatientAppointments>();
	
	Patient patient = null;
	boolean isVisit = false;
	
	if(map.get("appPatientAppointmentList") != null){
		appPatientAppointmentList = (List<AppPatientAppointments>)map.get("appPatientAppointmentList");
	}
	System.out.println("appPatientAppointmentList==="+appPatientAppointmentList.size());
	
	
		
	if(map.get("isVisit") != null)
		isVisit = (Boolean)map.get("isVisit");	
		
		
%>
<% if(appPatientAppointmentList!=null && appPatientAppointmentList.size()>0){ 
	AppPatientAppointments	appPatientAppointment = appPatientAppointmentList.get(0);
%>	
<h2>Patient Details</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="hidden" name="patientFlag" id="patientFlag" value="new">
<label>Hin No.</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=appPatientAppointment.getHin()!= null && appPatientAppointment.getHin().getHinNo() != null ?appPatientAppointment.getHin().getHinNo():""%>"/>
<div class="clear"></div>
<label>Name</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=(appPatientAppointment.getPatientName() != null)?appPatientAppointment.getPatientName():""%>"/>
<div class="clear"></div>
<label>DOB</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=appPatientAppointment.getHin()!= null?HMSUtil.convertDateToStringWithoutTime(appPatientAppointment.getHin().getDateOfBirth()):""%>"/>
<div class="clear"></div>
<label>Mobile</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=appPatientAppointment.getHin()!= null && appPatientAppointment.getHin().getMobileNumber() != null ?appPatientAppointment.getHin().getMobileNumber():""%>"/>
 <input type="hidden" name="departmentId" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getDepartment()!= null && appPatientAppointment.getDepartment().getId() != null ?appPatientAppointment.getDepartment().getId():""%>"/>
 <input type="hidden" name="hinId" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getHin()!= null && appPatientAppointment.getHin().getId() != null ?appPatientAppointment.getHin().getId():""%>"/>
 <input type="hidden" name="age" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getAge() != null ?appPatientAppointment.getAge():""%>"/>
  <input type="hidden" name="onlineAppointmentStauts" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getAppointmentStatus() != null ?appPatientAppointment.getAppointmentStatus():""%>"/>
  <input type="hidden" name="onlineAppId" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getId() != null ?appPatientAppointment.getId():""%>"/>
   <input type="hidden" name="opSessionId" class="readonly" readonly="readonly" value="<%=appPatientAppointment.getAppSession() != null && appPatientAppointment.getAppSession().getId()!= null ?appPatientAppointment.getAppSession().getId():""%>"/>
<div class="clear"></div>
<input type="button" value="Submit" onclick="submitPatientDetails();"  />	

<% } else {%>	
<h2>No Patient Found</h2>
<% } %>