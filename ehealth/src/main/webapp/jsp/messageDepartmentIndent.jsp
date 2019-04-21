<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	
%>
<div id="contentspace">
<form name="message" method="post"><br />
<h2 align="left" class="style1"><%=message %></h2>
<input type="button" value="Back" class="button"
	onClick="submitForm('message','<%=url%>');" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>