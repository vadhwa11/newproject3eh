<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
	
}
List<StoreIssueT>issueTList=new ArrayList<StoreIssueT>();
if(map.get("storeIssueTList")!=null){
	issueTList=(List<StoreIssueT>)map.get("storeIssueTList");
}

if(issueTList.size()>0){
%>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<table>
<tr>
<th>Sr No.</th>
<th>Item Code</th>
<th>Item Name</th>
<th>Frequency</th>
<th>No Of Days</th>
<th>Prescribed Qty</th>
<th>Qty Issued</th>
</tr>
<%
int i=1;
for(StoreIssueT issueT:issueTList){ %>
<tr>
<td><%=i %></td>
<td><%=issueT.getItem().getPvmsNo() %></td>
<td><%=issueT.getItem().getNomenclature() %></td>
<%if(issueT.getPrescription()!=null){ %>
<td><%=issueT.getPrescription().getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>--</td>
<%}%>
<%if(issueT.getPrescription()!=null){ %>
<td><%=issueT.getPrescription().getNoOfDays() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<td><%=issueT.getQtyRequest().intValue() %></td>
<td><%=issueT.getQtyIssued().intValue() %></td>

</tr>
<%} %>
</table>

<%}%>