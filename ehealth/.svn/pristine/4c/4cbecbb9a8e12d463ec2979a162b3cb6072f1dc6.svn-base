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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
int chargeSlipNo =0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("messageTOBeVisibleToTheUser") != null){
	message = (String)map.get("messageTOBeVisibleToTheUser");
}

%>
<form name="messageAdt" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<input type="button" value="Back" class="button" onClick="submitForm('messageAdt','/hms/hms/stores?method=showGrnJsp');"> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
