
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



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
<form name="msgReactEntry" method="post">

<h4><span><%=message %></span></h4>
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
%>
<div class="clear"></div>

<input type="button" name="back" value="Back" class="button"
	onclick="submitForm('msgReactEntry','/hms/hms/bloodBank?method=showSearchPatientForReactionJsp','checkTargetForNo');" />

<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 --> <%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
