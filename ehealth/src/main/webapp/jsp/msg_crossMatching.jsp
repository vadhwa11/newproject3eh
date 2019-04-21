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
<title>Insert title here</title>
</head>
<body><% 
Map<String, Object> map = new HashMap<String, Object>();
String message="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
%>
<form name="msgForcrossmatch" method="post">
<h4><%=message %></h4>
<input type="button"  value="Back" class="button" onclick="submitForm('msgForcrossmatch','/hms/hms/bloodBank?method=showPendingSampleScreeningTestJsp','checkTargetForNo');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>