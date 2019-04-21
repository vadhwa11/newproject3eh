<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String url1="";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<%} %>

<form name="message" method="post">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" value="Back" class="button"	onClick="submitForm('message','<%=url%>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
