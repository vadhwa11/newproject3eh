
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String orderNo = "";

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

<form name="msgReqEntry" method="post">
<div class="clear"></div>
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button"
	onclick="submitForm('msgReqEntry','/hms/hms/bloodBank?method=showBloodDiscardJsp','checkTargetForNo');" />

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