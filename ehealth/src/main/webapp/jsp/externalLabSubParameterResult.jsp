<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.ExternalLabReportCommon"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<ExternalLabReportCommon>labReportList = new ArrayList<ExternalLabReportCommon>();
if(map.get("labReportList") != null){
	labReportList = (List)map.get("labReportList");
}
List<DgFixedValue>normalRangeList = new ArrayList<DgFixedValue>();
if(map.get("normalRangeList") != null){
	normalRangeList = (List)map.get("normalRangeList");
}


%>
<form name="labSubResult" method="post" action="">
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<%if(labReportList.size()>0){ %>


<table>
<tr>
<th>SubParameter</th>
<th>Result</th>
<th>Result Status</th>
<!-- <th>Normal Range</th> -->


</tr>

<%	
/* Set<DgFixedValue> normalRangeSet = new HashSet<DgFixedValue>(); */
for(ExternalLabReportCommon externalLabReportCommon : labReportList){
%>

<tr>
<td><%=externalLabReportCommon.getSubInvestigation().getSubInvestigationName() %></td>
<td><%=externalLabReportCommon.getTestResult().replaceFirst("^0+(?!$)", "") %></td>
<%if(externalLabReportCommon.getResultStatus().equalsIgnoreCase("Abnormal")){ %>
<td style="color: red;"><%=externalLabReportCommon.getResultStatus() %></td>
<%}else { %>
<td><%=externalLabReportCommon.getResultStatus() %></td>
<%} %>
</tr>

<%} %>
</table>

<%}%>
</form>