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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

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
<form name="patientAD" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="submitForm('patientAD','opd?method=showOPDMainJsp&visitId=<%=visitId%>');"	align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>