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


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String flag="";
int inpatientId=0;
String adNo = "";
String messageType="";
String serviceNo ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}


%>
<form name="FDT" method="post"><br />
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
}
if(map.get("inpatientId") != null){
	inpatientId =Integer.parseInt(""+map.get("inpatientId")) ;
}
if(map.get("messageType") != null){
	messageType = (String)map.get("messageType");
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
<input type="hidden" name="<%=AD_NO%>" value="<%=inpatientId %>" validate="adNo,metachar,no"/> <input
	type="button" name="yes" value="Print" class="button"
	onclick="submitForm('FDT','/hms/hms/mis?method=printFDTReport');" /> <input
	type="button" name="no" value="Back" class="button"
	onclick="submitForm('FDT','/hms/hms/mis?method=showFatalCasejsp');" />
<br />
<br />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>