<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

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

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h4><span><%=message %></span></h4>
<%} %>
<form name="msgReqEntry" method="post">
<div class="clear"></div>
<%
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
	if(map.get("orderSeqNo") != null){
		orderNo = (String)map.get("orderSeqNo");
	}
%> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button"	onclick="submitForm('msgReqEntry','/hms/hms/bloodBank?method=showPatientSearchForBloodRequestJsp','checkTargetForNo');" />
<input type="button" style="display: none;" name="sampleCollection" value="Pending Sample Collection" class="button" onclick="submitForm('msgReqEntry','/hms/hms/bloodBank?method=showPendingSampleCollectionJsp','checkTargetForNo');" />
<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
