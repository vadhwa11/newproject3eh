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
String dateOfAdmission="";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
int chargeSlipNo =0;
int hinId=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("chargeSlipNo") != null){
	chargeSlipNo = (Integer)map.get("chargeSlipNo");
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
if(map.get("patienthinId") != null){
	hinId = (Integer)map.get("patienthinId");
}


%>
<form name="messageAdt" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
%> <input type="button" name="yes" value="Yes" class="button"
	onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>','checkTargetForYes');checkTargetForNo()" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageAdt','/hms/hms/registration?method=showUpdateSearchJsp','checkTargetForNo');" />
	
	<jsp:include page="testImageUpload.jsp">
<jsp:param value="<%=hinNo %>" name="hinNo"/> 
</jsp:include>

<%} 
if(map.get("adNo") != null && map.get("adNo") != "" ){
	adNo = (String)map.get("adNo");
	
	if(map.get("dateOfAdmission") != null){
		dateOfAdmission = (String)map.get("dateOfAdmission");
	}
%>
<div class="clear"></div>
<input name="chargeSlipNo" type="hidden" value="<%=chargeSlipNo%>" />
<input name="hinId" type="hidden" value="<%=hinId%>" />
<%-- <input type="button" name="yes" value="Yes" class="button"	onclick="submitFormForDirectPrint('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>','checkTargetForYes');checkTargetForNo()" />
 --%>
 <input type="button" name="yes" value="Yes" class="button"	onclick="submitFormForDirectPrint('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&dateOfAdmission=<%=dateOfAdmission %>&adNo=<%=adNo %>','checkTargetForYes');checkTargetForNo()" />
 
 <!-- <input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo');" /> -->

<!-- <input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/registration?method=showUpdateSearchJsp','checkTargetForNo');" />
 -->
<%-- <input type="button" name="SIL/DIL" value="SIL/DIL" class="button"	onClick="submitForm('messageAdt','/hms/hms/adt?method=showSiDiReport&<%=AD_NO%>=<%=adNo%>');" />
<input type="button" name="registraion" value="Registration" class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />
<input type="button" name="Report" value="Bill" class="button"	onClick="submitForm('messageAdt','billing?method=printChargeSlipReport');"	accesskey="g" tabindex=1 /> 
<input type="button" name="Report" value="Generate BarCode" class="buttonBig" 
onClick="submitForm('messageAdt','/hms/hms/registration?method=generateBarCode&adNo=<%=adNo %>');"/> --%>
<%} %>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"	onclick="window.close()"> <%} %>
	<input type="button" value="Back" class="button"	onclick="submitForm('messageAdt','<%=backUrl%>');">
	
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
