<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Appropration Register Report.
 * @author  Govind
 * Create Date: 16th Nov , 2016 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<Patient> patientList = null;

	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map
				.get("patientList");
	}
%>
<%if(patientList.size()>0){%>
<div class="clear"></div>
<input type="button" name="Generate Report" value="Generate Report" class="buttonBig" onClick="if(this.value!=''){submitForm('voucherReport','enquiry?method=printPatientEpfReport&flag=exp');}" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}else{%>
<h4>No Data Found</h4>
<div class="clear"></div>
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}%>