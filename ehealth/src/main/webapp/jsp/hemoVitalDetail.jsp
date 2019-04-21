<%@page import="jkt.hms.masters.business.OpdHemoDialysis"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OpdHemoDialysis>hemoDialysisVitalList= new ArrayList<OpdHemoDialysis>();
if(map.get("hemoDialysisVitalList") != null){
	hemoDialysisVitalList = (List<OpdHemoDialysis>)map.get("hemoDialysisVitalList");
}

%>
<%	if(hemoDialysisVitalList.size() !=0){ %>
<table id="vitalDetailsTable" width="350px" border="1">
	<tr><th>OPD Date Time</th><th>BP</th><th>Pulse</th><th>Temperature (&deg;f)</th></tr>
	<%for (OpdHemoDialysis opdHemoDialysis :hemoDialysisVitalList) {%>		
			
<tr>
			<td><input type="text" name="dateTime" value="<%=opdHemoDialysis.getVitalDateTime()!=null?opdHemoDialysis.getVitalDateTime() :""%>"   readonly="readonly" /></td>
			<td> <input type="text" name="bp" value="<%=opdHemoDialysis.getVitalBp()!=null?opdHemoDialysis.getVitalBp():"" %>" readonly="readonly" /> </td>
			<td><input type="text" name="pulse" value="<%=opdHemoDialysis.getVitalPulse()!=null?opdHemoDialysis.getVitalPulse():"" %>"   readonly="readonly" /></td>
			<td> <input type="text" name="temp" value="<%=opdHemoDialysis.getVitalTemperature()!=null?opdHemoDialysis.getVitalTemperature():"" %>" readonly="readonly" /> </td>
	<%-- <td><%= opdHemoDialysis.getVitalDateTime()!=null?opdHemoDialysis.getVitalDateTime() :""%></td>
	<%if(opdHemoDialysis.getVitalPulse()!=null && opdHemoDialysis.getVitalPulse() != 0){%>
		<td><%=opdHemoDialysis.getVitalPulse()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdHemoDialysis.getVitalTemperature()!=null && !opdHemoDialysis.getVitalTemperature().equals("")){%>
		<td><%=opdHemoDialysis.getVitalTemperature()%></td>
	<%}else{ %>
		<td></td>
	<%} %>
	
	<%if(opdHemoDialysis.getVitalBp()!=null && !opdHemoDialysis.getVitalBp().equals("")){%>
		<td><%=opdHemoDialysis.getVitalBp()%></td>
	<%}else{ %>
		<td></td>
	<%} %> --%>
</tr>

<% }%>
	</table>	
<%}else{%>
	No vital Details
<%}%>




