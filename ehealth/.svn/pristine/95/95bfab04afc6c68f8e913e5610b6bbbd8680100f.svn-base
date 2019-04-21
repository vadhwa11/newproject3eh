<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<script type="text/javascript">
function checkk() {
	var SDate = document.birth.<%= FROM_DATE%>.value;
	var EDate = document.birth.<%= TO_DATE %>.value;


	var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


	if(startDate > endDate) {
		if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
			alert("Please ensure that the To Date is greater than or equal to the From Date.");
		getShadowWithObj(document.calldate.next_day);
		return false;
	}
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
int bloodConsentId = 0;
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
if(map.get("bloodConsentId") != null){
	bloodConsentId = (Integer)map.get("bloodConsentId");
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
if(map.get("inpatientId") != null){
	inpatientId = (Integer)map.get("inpatientId");
}
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}

%>
<form name="messageConsent" method="post">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<%
	if(bloodConsentId != 0){ %>
		<input type="button" name="yes" value="Yes" class="button"
			onclick="submitForm('messageConsent','/hms/hms/bloodBank?method=printBloodConsent&bloodConsentId=<%=bloodConsentId %>&hinId=<%=hinId%>&inpatientId=<%=inpatientId%>');" />
		<input type="button" name="no" value="No" class="button"
			onclick="submitForm('messageConsent','/hms/hms/bloodBank?method=showBloodConsentDetails');" />
<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
