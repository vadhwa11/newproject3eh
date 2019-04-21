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


%>

<form name="patientAD" method="post">
<h4><%=message%></h4>
<%-- <h4><font id="error"><%=message%></font></h4> --%>
<input type="button" class="button" name="Reset" value="Back" onclick="submitForm('patientAD','/hms/hms/pubHealth?method=showDayBlockAllocationJsp')">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>