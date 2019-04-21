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
	<tr><th>Hd No</th><th>Dialysis Date</th><th>Left Access</th><th>Right Access</th><th>Pre Hd Weight</th><th>Post Hd Weight</th><th>Weight Gain</th>
	<th>Heparin Dose</th><th>blood Flow Rate</th><th>Dialysate Flow Rate</th><th>KT/V</th><th>URR</th><th>UF</th><th>Next Dialysis Date</th>
	<th>Next Dialysis Time</th><th>Events Complications</th></tr>
	<%for (OpdHemoDialysis opdHemoDialysis :hemoDialysisVitalList) {%>		
			
<tr>
			<td><input type="text"  value="<%=opdHemoDialysis.getDialysisHdNo()!=null?opdHemoDialysis.getDialysisHdNo() :""%>"   readonly="readonly" /></td>
			<td><input type="text" value="<%=opdHemoDialysis.getDialysisDate()!=null?opdHemoDialysis.getDialysisDate():"" %>" readonly="readonly" /> </td>
			<td><input type="text" value="<%=opdHemoDialysis.getDialysisAccess1()!=null?opdHemoDialysis.getDialysisAccess1():"" %>"   readonly="readonly" /></td>
			<td> <input type="text" value="<%=opdHemoDialysis.getDialysisAccess2()!=null?opdHemoDialysis.getDialysisAccess2():"" %>" readonly="readonly" /> </td>
			
			<td><input type="text"  value="<%=opdHemoDialysis.getPreHdWeight()!=null?opdHemoDialysis.getPreHdWeight().setScale(2) :""%>"   readonly="readonly" /></td>
			<td><input type="text" value="<%=opdHemoDialysis.getPostHdWeight()!=null?opdHemoDialysis.getPostHdWeight().setScale(2):"" %>" readonly="readonly" /> </td>
			<td><input type="text" value="<%=opdHemoDialysis.getWeightGain()!=null?opdHemoDialysis.getWeightGain().setScale(2):"" %>"   readonly="readonly" /></td>
			<td> <input type="text" value="<%=opdHemoDialysis.getHeparinDose()!=null?opdHemoDialysis.getHeparinDose():"" %>" readonly="readonly" /> </td>
			
			<td><input type="text"  value="<%=opdHemoDialysis.getBloodFlowRate()!=null?opdHemoDialysis.getBloodFlowRate() :""%>"   readonly="readonly" /></td>
			<td><input type="text" value="<%=opdHemoDialysis.getDialysateFlowRate()!=null?opdHemoDialysis.getDialysateFlowRate():"" %>" readonly="readonly" /> </td>
			<td><input type="text" value="<%=opdHemoDialysis.getKtV()!=null?opdHemoDialysis.getKtV():"" %>"   readonly="readonly" /></td>
			<td> <input type="text" value="<%=opdHemoDialysis.getUrr()!=null?opdHemoDialysis.getUrr():"" %>" readonly="readonly" /> </td>
			
			<td><input type="text"  value="<%=opdHemoDialysis.getUf()!=null?opdHemoDialysis.getUf() :""%>"   readonly="readonly" /></td>
			<td><input type="text" value="<%=opdHemoDialysis.getNextDialysisDate()!=null?opdHemoDialysis.getNextDialysisDate():"" %>" readonly="readonly" /> </td>
			<td><input type="text" value="<%=opdHemoDialysis.getNextDialysisTime()!=null?opdHemoDialysis.getNextDialysisTime():"" %>"   readonly="readonly" /></td>
			<td> <input type="text" value="<%=opdHemoDialysis.getEventsComplications()!=null?opdHemoDialysis.getEventsComplications():"" %>" readonly="readonly" /> </td>
	
</tr>

<% }%>
	</table>	
<%}else{%>
	No Details Available
<%}%>




