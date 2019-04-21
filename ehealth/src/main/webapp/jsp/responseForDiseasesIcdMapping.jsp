<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("result") != null){
%>
<%=map.get("result")%>
<%}%>