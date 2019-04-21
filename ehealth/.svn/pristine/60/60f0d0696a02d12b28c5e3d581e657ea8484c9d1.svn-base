<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
String hospitalCode = null;
String hospitalName = null;
List<MasHospital> hospitals = new ArrayList<MasHospital>();
if(map.get("hospitals")!=null){
	hospitals = (List<MasHospital>)map.get("hospitals");
}

%>
<ul>
	<%	if(hospitals.size() >0){
		for(MasHospital hospital:hospitals){
			hospitalCode = hospital.getHospitalCode();
%>
	<li style="width: auto;"><%=hospitalCode%></li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
