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
List<MasHospital> instituteList = new ArrayList<MasHospital>();
if(map.get("instituteList") != null){
	instituteList = (List<MasHospital>)map.get("instituteList");
}

System.out.println("instituteList jsp "+instituteList.size());

%>
<ul>
	<%	if(instituteList.size()>0){
		for (MasHospital hos :instituteList) {
			int hospitalId = hos.getId();
		    String hospitalName = hos.getHospitalName();
		    String hospitalShortName  = hos.getShortName(); 
%>
	<li style="width: auto;"><%=hospitalShortName%></li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
