<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for OrderBooking For Inpatient.
 * @author  Dipali
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
String hinNo = "";
String orderNo="";
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
<form name="messageLab" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
if(map.get("orderSeqNo") != null){
	orderNo = (String)map.get("orderSeqNo");
}
%> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBooking&hinNo=<%=hinNo %>&orderNo=<%=orderNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageLab','ipd?method=showPatientListJsp','checkTargetForNo');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
if(formName != ""){
%> 
<input type="button" value="Close" class="button"	onclick="window.close()"> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
