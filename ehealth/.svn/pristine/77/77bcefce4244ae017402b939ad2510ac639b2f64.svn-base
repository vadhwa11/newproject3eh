<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Users> usersList = new ArrayList<Users>();
if (map.get("usersList") != null) {
	usersList = (List) map.get("usersList");
}

System.out.println("usersList jsp "+usersList.size());

%>
<ul>
	<%	if(usersList.size()>0){
		for (Users user :usersList) {
			String loginName = user.getLoginName();
%>
	<li style="width: auto;"><%=loginName%></li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>
