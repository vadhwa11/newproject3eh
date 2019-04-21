<%@page import="jkt.hms.masters.business.LoincSnomed"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<LoincSnomed>list= new ArrayList<LoincSnomed>();
if(map.get("loincSnomedList") != null){
	list = (List)map.get("loincSnomedList");
}

%>
<%	if(list.size() !=0){%>
		<%for(LoincSnomed ls:list){ %>
     			 <%=ls.getSnomed() %>
		<%} %>
<%}else{%>
	No Snomed Mapping Founds
<%}%>


