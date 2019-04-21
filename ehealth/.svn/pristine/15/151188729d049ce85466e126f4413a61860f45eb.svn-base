
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="java.util.*"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<RouteOfAdministration> routeList = new ArrayList<RouteOfAdministration>();
if(map.get("routList") != null){
	routeList = (List<RouteOfAdministration>)map.get("routList");
}
%>
<%@page import="java.util.Iterator"%>
<ul>
	<%	if(routeList.size() !=0){
  		    for (RouteOfAdministration route:routeList) {
  		    	String routeName=route.getRouteName();
  		    	Integer routeId=route.getId();
%>
	<li style="width: auto;"><%=routeName%><span class="smallAuto">[<%=routeId%>]</span></li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



