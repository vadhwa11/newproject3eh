<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String orderNo = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>

<%

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h4><span><%=message %></span></h4>
<%} %>

<form name="msgIndentForm" method="post">
<input type="button" name="back" value="Back" class="button"
	onclick="submitForm('msgIndentForm','/hms/hms/pubHealth?method=showPhOpdMainJsp');" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>