<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Lab Message.
 * @author  Dipali
 * Create Date: 14th August,2008 
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
String visitNo = "";
String hinNo = "";
String orderNo = "";
String backUrl = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
/* if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
} */
%>
<form name="messageLab" method="post">

<h4><span><%=message %></span></h4>

<%-- <%
	if(map.get("visitNo") != null){
		visitNo = (String)map.get("visitNo");
	}
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
%> --%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBooking&hinNo=<%=hinNo %>&visitNo=<%=visitNo %>&orderNo=<%=orderNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=showOpOrderBookingSearchJsp','checkTargetForNo');" />
 --%><div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
if(formName != ""){
%> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" value="Close" class="button"	onclick="window.close()"> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

