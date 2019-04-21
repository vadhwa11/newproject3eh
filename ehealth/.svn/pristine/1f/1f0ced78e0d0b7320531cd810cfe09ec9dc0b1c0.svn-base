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

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String backUrl = "";
int inpatientId = 0;
String flag ="";
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
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
%>
<form name="messageAdt" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageAdt','/hms/hms/ipd?method=showDischargeSlipReport');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageAdt','<%=backUrl%>');" /> 
	<input type="button" name="no" value="Back" class="button"
	onclick="submitForm('messageAdt','<%=backUrl%>');" /> 
	<input
	name="<%=INPATIENT_ID%>" value="<%=inpatientId%>" type="hidden" />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
