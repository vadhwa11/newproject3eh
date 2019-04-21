<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
boolean status=false;
String message="";

if(map.get("status") != null){
	status = (Boolean)map.get("status");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}



if(status) 
{
	
%>
<h4><%=message %></h4>
<%} 
else{
%>
<h4>Some error occurred !</h4>
<%} %>
<form name="indentMsg" method="post">
<input type="button" name="back" value="Back" class="button"	
onclick="submitForm('indentMsg','/hms/hms/bloodBank?method=showIndentBloodBankJsp','checkTargetForNo');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>