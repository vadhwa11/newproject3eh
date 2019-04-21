<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
String message=null;

Map<String,Object> map=new HashMap<String,Object>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

message=(String)map.get("message");
%>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="clear"></div>
<form name="msgIndentAck" method="post">

<input type="button" name="Back" value="Back" class="button"	
onclick="submitForm('msgIndentAck','/hms/hms/bloodBank?method=showbldIssueAcknowledgmentListJsp','checkTargetForNo');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>