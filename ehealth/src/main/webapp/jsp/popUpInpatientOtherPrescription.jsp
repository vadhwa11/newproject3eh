<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<InpatientPrescriptionDetails> ipPrescriptionList=new ArrayList<InpatientPrescriptionDetails>();
if(map.get("ipPrescriptionList")!=null){
	ipPrescriptionList=(List<InpatientPrescriptionDetails>)map.get("ipPrescriptionList");
}
%>
<%if(ipPrescriptionList.size()>0){ %>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<table>
<tr>
<th>Sr. No.</th>
<th>Item Name</th>
<th>Route</th>
<th>No. Of Days</th>
<th>Frequecy</th>
<th>Total</th>

</tr>
<%int i=1;
for(InpatientPrescriptionDetails ipd:ipPrescriptionList){ %>
<tr>
<td><%=i %></td>
<%if(ipd.getItem()!=null){ %>
<td><%=ipd.getItem().getNomenclature() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(ipd.getRoute()!=null){ %>
<td><%=ipd.getRoute().getRouteName() %></td>
<%}else{ %>
<td>--</td>
<%}if(ipd.getNoOfDays()!=null){ %>
<td><%=ipd.getNoOfDays() %></td>
<%}else{ %>
<td>--</td>
<%}if(ipd.getFrequency()!=null){%>
<td><%=ipd.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>--</td>
<%} if(ipd.getTotal()!=null){%>
<td><%=ipd.getTotal() %></td>
<%}else{ %>
<td>--</td>
<%} %>

</tr>

<%i++;} %>
</table>
<%}else{%>
<h4>No Record Found</h4>
<%}%>

<div class="clear"></div>
<div class="clear"></div>
<input type="button" value="Close" onclick="window.close();" />
<div class="clear"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
