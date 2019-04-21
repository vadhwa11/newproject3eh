<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Naresh
 * Create Date: 5 March,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
String message = "";
if(map.get("message") != null){
message = (String)map.get("message");
}

String url  = "";
if(map.get("url") != null){
	url = (String)map.get("url");
}
	%>
<form name="hospital" method="post" action="">
 <label class="value"
	style="FONT-WEIGHT: bold; FONT-SIZE: 11px; COLOR: #F71818; width: 100%; text-align: center; float: right; font-family: Verdana, Arial, Helvetica, sans-serif;">
<%=message%> </label> 

<input type="button" name="Back" id="addbutton" value="Back" class="button" onClick="submitForm('hospital','<%=url %>');" accesskey="a" tabindex=1 />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

