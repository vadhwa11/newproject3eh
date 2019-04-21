
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
		Map map = new HashMap();
		List<StoreIssueM> issueMList = new ArrayList<StoreIssueM>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("issueMList")!=null){
			issueMList=(List<StoreIssueM>)map.get("issueMList");
		}
			%>
<script >
function disableSave(){
	var save=document.getElementById("Save");
	if(issueMList.size()> 0 ){
		alert("This Indent No is Already Issued..")
	document.getElementById("Save").disabled=true;
	}
	
}

</script>
<%--<%@page import="jkt.hms.util.RequestConstants"
<select name=<%= RequestConstants.ISSUE_UNIT_ID %>
	id="<%= RequestConstants.ISSUE_UNIT_ID %>">
	<option value="">Select</option>
	<%for(StoreIssueM  storeIssueM : storeIssueMList){%>
	<option value="<%=storeIssueM.getId() %>"><%=storeIssueM.getIssueNo() %></option>
	<%}	%>
</select>
--%>

