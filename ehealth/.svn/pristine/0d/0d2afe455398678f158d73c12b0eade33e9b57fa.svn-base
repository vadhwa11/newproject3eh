<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		if(map.get("empList") != null){
			empList = (List)map.get("empList");
		}
		

%>

<ul>
	<%	if(empList.size() !=0){

		for (MasEmployee masEmployee :empList) {


%>
	<li><%=masEmployee.getEmployeeName()%></li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>


