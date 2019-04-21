<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
boolean duplicateRegistration=false;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
int donorRegSerialNo=0;
if(map.get("donorRegSerialNo") != null){
	donorRegSerialNo = (Integer)map.get("donorRegSerialNo");
}
if(map.get("duplicateRegistration") != null){
	duplicateRegistration = (Boolean)map.get("duplicateRegistration");
}

%>

<form name="msgDonation" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="donorRegSerialNo" value="<%= donorRegSerialNo%>" />
<input type="button" name="back" value="Back" class="button"onclick="submitForm('msgDonation','/hms/hms/bloodBank?method=showBloodDonationEntryJsp','checkTargetForNo');" />
<%if(!duplicateRegistration){ %>
<input type="button" class="buttonBig2"
			value="Print Registration Slip"
			onclick="submitForm('msgDonation','/hms/hms/bloodBank?method=printDonorRegCard');" accesskey="r"
			align="right" tabindex=1 />
			<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>