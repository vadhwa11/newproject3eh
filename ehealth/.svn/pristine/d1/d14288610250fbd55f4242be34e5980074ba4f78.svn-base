<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForNewResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry Message.
 * @author  Abha
 *
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String url = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") != null){
	url = (String)map.get("url");
}
%>
<form name="messageResult" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
int newSampleCollectionId=0;
if(map.get("newSampleCollectionId")!=null&&map.get("newSampleCollectionId")!="0"){
	newSampleCollectionId =(Integer)map.get("newSampleCollectionId");
	if(newSampleCollectionId != 0){
	}
	}%> <input type="button" name="back" value="Back" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=searchPatient');" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>