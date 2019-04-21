<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opd-physiotherapy_msg.jsp
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ramdular
 * Create Date: 24 Sept 2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";

int visitId =0;
int hinId =0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
%>
<%@page import="jkt.hms.masters.business.Users"%>
<form name="messageAdt" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop15"></div>
<h4><span><%=message %></span></h4>
<input type="hidden" name="visitId" id="visitId" value="<%=visitId%>" />
<input type="hidden" name="hinId" id="hinId" value="<%=hinId%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('messageAdt','opd?method=showPhysiotherapyPatientList');"/>
<input name="print" type="button" alt="print" value="Print" class="button"	onclick="submitForm('messageAdt','opd?method=printPhysiotherapyReport');"/>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
