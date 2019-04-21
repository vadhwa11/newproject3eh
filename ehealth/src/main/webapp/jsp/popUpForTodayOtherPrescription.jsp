<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<PatientPrescriptionDetails>ppdList=new ArrayList<PatientPrescriptionDetails>();
if(map.get("ppdList")!=null){
	ppdList=(List<PatientPrescriptionDetails>)map.get("ppdList");
}
%>
<%if(ppdList.size()>0){ %>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<table>
<tr>
<th>Sr. No.</th>
<th>Item Name</th>
<th>Route</th>
<!-- <th>No. Of Days</th> -->
<th>Duration</th>
<th>Frequecy</th>
<th>Total</th>

</tr>
<%int i=1;
for(PatientPrescriptionDetails ppd:ppdList){ %>
<tr>
<td><%=i %></td>
<%if(ppd.getItem()!=null){ %>
<td><%=ppd.getItem().getNomenclature() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(ppd.getRoute()!=null){ %>
<td><%=ppd.getRoute().getRouteName() %></td>
<%}else{ %>
<td>--</td>
<%}if(ppd.getNoOfDays()!=null){ %>
<%-- <td><%=ppd.getNoOfDays() %></td> --%>
<td><%=ppd.getNoOfDays()+" "+ppd.getFrequency().getFrequencyType() %></td>
<%}else{ %>
<td>--</td>
<%}if(ppd.getFrequency()!=null){%>
<td><%=ppd.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>--</td>
<%} if(ppd.getTotal()!=null){%>
<td><%=ppd.getTotal() %></td>
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
