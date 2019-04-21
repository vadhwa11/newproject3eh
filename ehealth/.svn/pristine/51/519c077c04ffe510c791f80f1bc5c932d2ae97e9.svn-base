<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<% 	
	Map<String,Object> map = new HashMap<String,Object>();
	String message="Voucher Added Successfully";
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
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<form name="message" method="post"><br />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" value="Back" class="button"	onClick="submitForm('message','<%=url%>');" />
<input type="button" class="button" value="Print" onclick="submitForm('message','budget?method=showPrintVoucherReport');"  />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	