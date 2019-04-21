<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
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
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>
<form name="msgAssesstment" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button"onclick="submitForm('msgAssesstment','/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp','checkTargetForNo');" />
<!-- <input type="button" class="buttonBig2"
			value="Print Registration Slip"
			onclick="submitForm()"
			align="right" tabindex=1 /> -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</body>
</html>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>