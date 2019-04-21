<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	//String url="";
	//String url1="";
	String bagNumber="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map"); 
	} 
	
%>

<%	String message ="";
	if (map.get("messageTOBeVisibleToTheUser") != null) {
	             message = (String) map.get("messageTOBeVisibleToTheUser");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<%} %> 
<form name="message" method="post">
<%if(map.get("bagNumber")!=null && !(map.get("bagNumber").toString().equals(""))){
bagNumber=map.get("bagNumber").toString();
String url="/hms/hms/bloodBank?method=printBloodBagNoReport";
%>

	<input type="button" class="buttonAuto"  value="Generate Bag Number Slip" align="right" 
			onclick="submitForm('message','<%=url%>')" /> 
	
<%}%>
<input type="hidden" name="bagNo" value="<%=bagNumber%>">
<div class="clear"></div>
<div class="Height10"></div>   

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
