<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
int visitId=0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
int deptId=0;
if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
}
%>
<form name="patientAD" target="2" method="post"><br />
<h4><font id="error"><%=message %></font></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=VISIT_ID %>" id="visitId"	value="<%=visitId %>" /> 
<input type="hidden" name="deptId"	id="deptId" value="<%=deptId %>" /> 
<input type="button" name="yes"	value="Yes" class="button"	onclick="submitForm('patientAD','opd?method=printOpdGastroColonoscopy');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('patientAD','opd?method=showWaitingPatientListJsp');" />
<input type="button" name="Back" value="Back" class="button"	onclick="submitForm('patientAD','opd?method=showWaitingPatientListJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	