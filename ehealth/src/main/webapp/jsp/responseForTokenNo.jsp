<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Integer tokNo = 0;
	String tokenNo = "";
	if(map.get("tokenNo") != null){
		tokNo = (Integer)map.get("tokenNo");
		
		if(tokNo == 0){
			tokenNo = "";
		}else{
			tokenNo = tokNo.toString();
		}
%>


<div id="testDiv"><label class="value"><%=tokenNo %></label> <input
	id="tokenNoId" type="hidden" name="<%=TOKEN_NO %>"
	value="<%=tokenNo %>" validate="Token no.,int,no" maxlength="3"
	class="readOnly"></div>
<%}%>