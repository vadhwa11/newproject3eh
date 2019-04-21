<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
Map<String ,Object> map = new HashMap<String ,Object>();
List<HesEquipmentMaster> hesEquipmentMasterList = new ArrayList<HesEquipmentMaster>();
if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("equipmentList")!= null){
	hesEquipmentMasterList = (List<HesEquipmentMaster>)map.get("equipmentList");
}
%>
	<select  name="equipment" id="eq" ><option value="">Select Equipment</option>
	<%for(HesEquipmentMaster hesEquipmentMaster:hesEquipmentMasterList){ %>
	<option value="<%=hesEquipmentMaster.getId()%>"><%=hesEquipmentMaster.getEquipmentName()%></option>
	<%} %>
	</select>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
