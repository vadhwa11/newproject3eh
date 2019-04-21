<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
String uhidNo="";
if(map.get("uhidNo") != null){
	uhidNo = (String)map.get("uhidNo");
}
int bloodrequestHeaderId=0;
if(map.get("bloodrequestHeaderId") != null){
	bloodrequestHeaderId = (Integer)map.get("bloodrequestHeaderId");
}
int hinId=0;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
%>
<form name="msgForBBValidation" method="post">
<h4><%=message %></h4>

<input type="hidden" name="bloodrequestHeaderId" value="<%=bloodrequestHeaderId%>"/>
<input type="hidden" name="uhidNo" value="<%=uhidNo%>"/>

<input type="button"  value="Back" class="button" onclick="submitForm('msgForBBValidation','/hms/hms/bloodBank?method=showPendingSampleValidationJsp','checkTargetForNo');" />
<input type="button"  value="Print Sticker" class="button" 
onclick="submitForm('msgForBBValidation','/hms/hms/bloodBank?method=printBarCodeStickerForContainer','checkTargetForNo');" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>