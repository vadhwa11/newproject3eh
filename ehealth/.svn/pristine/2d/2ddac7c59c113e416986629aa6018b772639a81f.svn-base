<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
 int equipmentId=0;
 
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<HesEquipmentMaster> equipmentNoList = new ArrayList<HesEquipmentMaster>();
if(map.get("equipmentNoList") != null){
	equipmentNoList = (List<HesEquipmentMaster>)map.get("equipmentNoList");
}
%>

<ul>
	<%	if(equipmentNoList.size() !=0){
		for (HesEquipmentMaster hes:equipmentNoList) {
			
%>
   <li style="width: auto;"><%=hes.getEntryNo()%> </li> 
	  <%--<li style="width: auto;"><%=hes.getEntryNo()%>[<%=hes.getId()%>]</li>--%>
	<%}}else{%>
	<li>----------No Entry No. found-------------</li>
	<%} %>
</ul>



