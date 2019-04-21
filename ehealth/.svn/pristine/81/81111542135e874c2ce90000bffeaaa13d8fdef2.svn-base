<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasHospital>list= new ArrayList<MasHospital>();
if(map.get("hospitaList") != null){
	list = (List)map.get("hospitaList");
}
%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
		for (MasHospital masHospital :list) {
%>			
<option value=<%=masHospital.getId()%>><%=masHospital.getHospitalName()%></option>
<%} }%>


