

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
String reasonForblock="";
if(map.get("reasonForblock")!=null){
	 reasonForblock=(String)map.get("reasonForblock");
}

%>
<label>Reason</label>
<label class="value"><%=reasonForblock %></label>