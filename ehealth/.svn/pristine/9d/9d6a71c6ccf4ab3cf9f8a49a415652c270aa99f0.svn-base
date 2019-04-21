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


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">
function back() {
window.close();
return;

}
</script> <%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

int visitId=0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
%>
<form name="patientAD" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
 <input name="Back"	type="button" alt="Back" value="Close" class="button"	onclick="back();"  />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	
