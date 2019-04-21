<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.HesEquipmentBreakdownEntry"%>

<%Map<String,Object> map = new HashMap<String,Object>();
 int equipmentId=0;
 
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<HesEquipmentBreakdownEntry> equipmentBreakdownList = new ArrayList<HesEquipmentBreakdownEntry>();
if(map.get("equipmentBreakdownList") != null){
	equipmentBreakdownList = (List<HesEquipmentBreakdownEntry>)map.get("equipmentBreakdownList");
}
%>


<ul>
	<%	if(equipmentBreakdownList.size() !=0){
		for (HesEquipmentBreakdownEntry hes:equipmentBreakdownList) {
			
%>
   <li style="width: auto;"><%=hes.getEntryNo()%> </li> 
	  <%--<li style="width: auto;"><%=hes.getEntryNo()%>[<%=hes.getId()%>]</li>--%>
	<%}}else{%>
	<li>----------No Entry No. found-------------</li>
	<%} %>
</ul>



