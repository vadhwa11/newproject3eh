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
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
String orderDetailsFlag = "";
if(map.get("orderDetailsFlag")!=null){
	orderDetailsFlag=(String)map.get("orderDetailsFlag");
}

String billingScreen = null;
if(map.get("billingScreen")!=null){
	billingScreen = (String)map.get("billingScreen");
}
//added by govind 27-07-2017
String patientType="";
if(map.get("patientType")!=null){
	patientType = (String)map.get("patientType");
}
String adNo="",uHid="";
if(map.get("adNo")!=null){
	adNo = (String)map.get("adNo");
}
if(map.get("uHid")!=null){
	uHid = (String)map.get("uHid");
}
//added by govind 27-07-2017 end
%>

<form name="messageLab" method="post">

<h4><span><%=message %></span></h4>

<%
	if(map.get("visitNo") != null){
		visitNo = (String)map.get("visitNo");
	}
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
	int orderId = 0;
	if(map.get("orderId") != null){
		orderId = (Integer)map.get("orderId");
	}
	// added by amit das on 11-05-2017
	int dgOrderHdId = 0;
	if(map.get("dgOrderHdId") != null){
		dgOrderHdId = (Integer)map.get("dgOrderHdId");
	}
	
	
	int visitId = 0;
	if(map.get("visitId") != null){
		visitId = (Integer)map.get("visitId");
	}
%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
	if(orderDetailsFlag.equalsIgnoreCase("no")){
%>
<input type="button" name="Sample Collection" value="Collect Sample" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=searchPatient&orderId=<%=orderId %>&visitNumber=<%=visitId %>','checkTargetForNo');" />


<%} %>

<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=printOrderBooking&hinNo=<%=hinNo %>&visitNo=<%=visitNo %>&orderNo=<%=orderNo %>','checkTargetForYes');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=showOpOrderBookingSearchJsp','checkTargetForNo');" />
<input type="button" name="tr5" value="TR5" class="button"	onclick="submitForm('messageLab','/hms/hms/lab?method=printtr5&hinNo=<%=hinNo %>&orderNo=<%=orderNo %>');" />
<%if(patientType.equals("OP")){%>
<% //if(billingScreen!=null && billingScreen.equalsIgnoreCase("y")) {%>
	<%-- <input type="button" name="tr5" value="Go To Billing" class="button"	onclick="submitForm('messageLab','/hms/hms/opBilling?method=getPatientDetailsForOpBilling&registered=yes&&orderId=<%=dgOrderHdId %>');" /> commented by govind 11-07-2017--%>
	<input type="button" name="tr5" value="Go To Billing" class="button"	onclick="submitForm('messageLab','/hms/hms/opBilling?method=getPatientDetailsForOpBilling&registered=yes&&orderId=<%=dgOrderHdId %>&billType=lab');" /><!-- added by govind 11-07-2017 -->
<% } //}%>
<%if(patientType.equals("IP")){%><%--//added by govind 27-07-2017--%>
<input type="button" name="tr5" value="Go To Billing" class="button"	onclick="submitForm('messageLab','/hms/hms/billing?method=getPatientDetails&uhid=<%=uHid%>&ipNo=<%=adNo %>');" /><!-- added by govind 11-07-2017 -->
<% }%>
<div class="clear"></div>
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
