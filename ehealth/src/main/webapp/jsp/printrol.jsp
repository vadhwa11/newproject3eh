<%@ page import="java.util.*"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("message") != null)
	{
		String message = (String)map.get("message");
%>
		<h4><span><%=message %></span></h4>
<%
	}
%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
