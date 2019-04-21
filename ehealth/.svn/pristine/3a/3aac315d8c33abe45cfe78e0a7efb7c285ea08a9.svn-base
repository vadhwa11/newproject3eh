
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String orderNo = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
%>
<form name="updateTestEntry" method="post">
<div class="Clear"></div>
<% 

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button" onclick="submitForm('updateTestEntry','/hms/hms/bloodBank?method=showUpdateBloodTestEntryJsp','checkTargetForNo');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 -->
<div class="clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>