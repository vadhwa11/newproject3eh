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

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />


<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
int userType = 0;
if(session.getAttribute("users") != null){
	 Users user = (Users)session.getAttribute("users");
	 userType = user.getUserType()!=null?user.getUserType():4;
	 
}

%>

<form name=phMapping method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h4><%=message%></h4>
<%
if(userType == 5){ // PH Admin
%>
<input type="button" class="button" name="Reset" value="Back" onclick="submitForm('phMapping','/hms/hms/pubHealth?method=showPhMappingAdminJsp');">
<%}else{ %>
<input type="button" class="button" name="Reset" value="Back" onclick="submitForm('phMapping','/hms/hms/pubHealth?method=showPhMappingJsp');">
<%} %>
</form>
</div>