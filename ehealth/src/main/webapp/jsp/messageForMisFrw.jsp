<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for Birth Message.
 * @author  Diapli
 * Create Date: 26 April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int disposalId=0;
String formName = "";
String flag="";
int hinId=0;
String adNo = "";
String messageType="";
String serviceNo ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}


if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>
<form name="messageMisBirth" target="_blank" method="post"><br />
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
}
if(map.get("hinId") != null){
	hinId =Integer.parseInt(""+map.get("hinId")) ;
}
if(map.get("messageType") != null){
	messageType = (String)map.get("messageType");
}
if(map.get("disposalId") != null){
	disposalId = (Integer)map.get("disposalId");
}
%> <%if(!message.equals("")){
	if(messageType.equals("success")){
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=message %></div>
</div>

<%}%> <%if(messageType.equals("failure")){%>

<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
<%=message %></div>
</div>
<%}}%> <br />
<br />
<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId %>" /> <input
	type="button" name="yes" value="Print" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=printFRW','checkTargetForYes');" />
<input type="button" name="no" value="Back" class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=showFrwCasesJsp','checkTargetForYes');" />
<input type="button" name="no" value="P M O " class="button"
	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=printPMO&serviceNo=<%=serviceNo%>','checkTargetForYes');" />



<br />



<br />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()" /> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
