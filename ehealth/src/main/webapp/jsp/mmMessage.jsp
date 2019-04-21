<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>



<%
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String message ="";
	
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	request.setAttribute("box",box);
%>

<form name="message" method="post">
<div class="clear"></div>




<h4><span><%=message %> </span></h4>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" value="Back" class="button"	onClick="submitForm('message','<%=url%>');" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>