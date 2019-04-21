<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietMessageDetails.jsp
 * Purpose of the JSP -  This is for Message.
 * @author  @Ramdular
 * Create Date: 22 Oct 2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
%>
<div class="clear"></div>
<form name="message" method="post"><br />
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<input type="button" name="b" value="Go Back" class="button" onClick="javascript:history.back();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>