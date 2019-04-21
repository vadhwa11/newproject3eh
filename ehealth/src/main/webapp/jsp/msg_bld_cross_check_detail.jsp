<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%
	  String message="";
	boolean status=false;
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if(map.get("status") != null){
			status= (Boolean)map.get("status");
		}
		
	%> <div id="Block">
	<form name="msgBloodCrossCheck" method="post">
	
	<%if(status){%>
		<h4><%= message%></h4>
	<%}
	%>
	<!-- <input type="button" name="Back" value="Back" 
	class="button" onclick="submitForm('msgBloodCrossCheck','/hms/hms/bloodBank?method=showbloodBagCrossCheckJsp','checkTargetForNo');"/>
	 -->
	<input type="button" name="no" value="Back" class="button"
	onclick="submitForm('msgBloodCrossCheck','/hms/hms/bloodBank?method=showPendingListBloodSampleCollection','checkTargetForNo');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	</div>
</body>
</html>