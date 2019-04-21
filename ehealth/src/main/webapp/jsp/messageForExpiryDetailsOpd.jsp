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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String backUrl = "";
int inpatientId = 0;
int hinId=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("inpatientId") != null){
	inpatientId = Integer.parseInt(""+map.get("inpatientId"));
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
if(map.get("hinId") != null){
	hinId = Integer.parseInt(""+map.get("hinId"));
}
%>
<form name="messageExpiry" method="post"><br/>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<%-- <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageExpiry','/hms/hms/adt?method=printExpiryDetails&inpatientId='+<%=inpatientId%>);" /> --%>
	<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageExpiry','/hms/hms/opd?method=printExpiryDetails&hinId='+<%=hinId%>);" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageExpiry','/hms/hms/adt?method=searchExpiryDetails&appId=A345');" />
<br />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>