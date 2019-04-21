<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
Boolean status=null;
if(map.get("status")!=null)
{
	status=(Boolean)map.get("status");
}
if(status!=null && !status)
{
%>
Bed is not selected Or Selected Bed is not Free. Please select another bed.
<%
}
%>