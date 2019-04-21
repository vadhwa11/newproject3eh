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
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
%> 
<form name="messageForm" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('messageForm','opd?method=showWaitingPatientListJsp');" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	
