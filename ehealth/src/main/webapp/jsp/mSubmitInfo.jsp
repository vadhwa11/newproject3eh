<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
%>
<%=map.get("msg") %>

<div class="bigTitle">
<h2><%=map.get("title")!=null ? map.get("title"):"" %></h2>
</div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
