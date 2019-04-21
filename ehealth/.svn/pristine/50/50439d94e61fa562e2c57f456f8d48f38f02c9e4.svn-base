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
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OnlinePatientVisit"%>
<%@page import="jkt.hms.masters.business.OnlinePatientPortal"%>
<%@ page import="java.util.*"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<OnlinePatientPortal> portalPatientList = null;
	List<Patient> webPatientList = null;
	OnlinePatientPortal onlinePatientPortal = null;
	Patient patient = null;
	boolean isVisit = false;
	
	if(map.get("portalPatientList") != null)
		portalPatientList = (List<OnlinePatientPortal>)map.get("portalPatientList");
	
	if(map.get("webPatientList") != null)
		webPatientList = (List<Patient>)map.get("webPatientList");
		
	if(map.get("isVisit") != null)
		isVisit = (Boolean)map.get("isVisit");	
		
		
%>
<% if(portalPatientList!=null && portalPatientList.size()>0){ 
		onlinePatientPortal = portalPatientList.get(0);
%>	
<h2>Patient Details</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="hidden" name="patientFlag" id="patientFlag" value="new">
<label>Aadhaar No.</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=onlinePatientPortal.getAadhaarNo()%>"/>
<div class="clear"></div>
<label>Name</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=(onlinePatientPortal.getFullName()==null)?onlinePatientPortal.getPFirstName():onlinePatientPortal.getFullName()%>"/>
<div class="clear"></div>
<label>DOB</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=onlinePatientPortal.getDateOfBirth()%>"/>
<div class="clear"></div>
<label>Mobile</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=(onlinePatientPortal.getMobileNumber()!=null)?onlinePatientPortal.getMobileNumber():""%>"/>
<div class="clear"></div>
<input type="button" value="Submit" onclick="submitPatientDetails();"  />	
<% } else if(webPatientList!=null && webPatientList.size()>0){ 
	patient = webPatientList.get(0);%>
<h2>Patient Details</h2>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="patientFlag" id="patientFlag" value="old">
<input type="hidden" name="hinId" id="hinId" value="<%=patient.getId()%>">
<label>Aadhaar No.</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=patient.getAadhaarNo()%>"/>
<div class="clear"></div>
<label>Name</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=(patient.getFullName()==null)?patient.getPFirstName():patient.getFullName()%>"/>
<div class="clear"></div>
<label>DOB</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=patient.getDateOfBirth()%>"/>
<div class="clear"></div>
<label>Mobile</label>
 <input type="text"  class="readonly" readonly="readonly" value="<%=(patient.getMobileNumber()!=null)?patient.getMobileNumber():""%>"/>
<div class="clear"></div>
<input type="button" value="Submit" onclick="submitPatientDetails();"  />	
<% } else {%>	
<h2>No Patient Found</h2>
<% } %>