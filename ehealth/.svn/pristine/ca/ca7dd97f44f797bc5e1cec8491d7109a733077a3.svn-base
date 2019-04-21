<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* messageForWard.jsp  
* Purpose of the JSP -  This is Messages for Ward
* @author  Mansi
* @author  Deepali
* Create Date: 21st Feb,2008 
* Revision Date:      
* Revision By: 
* @version 1.2
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
message = (String)map.get("message");
}
String backUrl="";
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}

%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message For New Transferred Member </title>
</head>
<body>
<form name="message" method="post">
<h4><%= message %></h4> 
<div class="clear"></div>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=backUrl%>');" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>