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
int otConsentId = 0;
String adNo = "";
String backUrl = "";
int chargeSlipNo =0;
int inpatientId = 0;
int hinId = 0;
String procedureTemplate = null;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("otConsentId") != null){
	otConsentId = (Integer)map.get("otConsentId");
}
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

// added by amit das on 26-09-2016
if(map.get("inpatientId") != null){
	inpatientId = (Integer)map.get("inpatientId");
}

//added by amit das on 26-09-2016
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}

//added by amit das on 26-09-2016
if(map.get("procedureTemplate") != null){
	procedureTemplate = (String)map.get("procedureTemplate");
}


%>
<form name="messageConsent" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
	if(map.get("otConsentId") != null){
		otConsentId = (Integer)map.get("otConsentId");
%> <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageConsent','/hms/hms/ot?method=printotConsent&otConsentId=<%=otConsentId %>&hinId=<%=hinId%>&inpatientId=<%=inpatientId%>&procedureTemplate=<%=procedureTemplate%>','checkTargetForYes','checkTargetForNo');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageConsent','/hms/hms/ot?method=showOtConsentDetails','checkTargetForNo');" />

<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
