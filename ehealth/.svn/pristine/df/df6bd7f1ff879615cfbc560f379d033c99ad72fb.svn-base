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
String formName = "";
int intraOpId = 0;
String adNo = "";
String backUrl = "";
int chargeSlipNo =0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("intraOpId") != null){
	intraOpId = (Integer)map.get("intraOpId");
}
System.out.println("intraOpId------------------>>>>"+intraOpId);
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
String tempFlag ="";
if(map.get("tempFlag") != null){
	tempFlag = (String)map.get("tempFlag");
}
%>
<form name="messageAdt" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
	if(map.get("intraOpId") != null){
		intraOpId = (Integer)map.get("intraOpId");
%> <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageAdt','/hms/hms/ot?method=printintraOp&intraOpId=<%=intraOpId %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageAdt','/hms/hms/ot?method=showOtSignoutList','checkTargetForNo');" />

<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
