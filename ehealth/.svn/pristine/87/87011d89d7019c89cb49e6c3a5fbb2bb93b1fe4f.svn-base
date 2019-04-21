<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForNewResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry Message.
 * @author  Abha
 *
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String url = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
%>
<form name="messageResult" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<input type="button" name="back" value="Back" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=showPendingForResultValidationLabJsp');" />

<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
