<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>

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
	String resultNo="";
	if(map.get("resultNo") != null){
		resultNo = (String)map.get("resultNo");
	}
	String resultType="";
	if(map.get("resultType") != null){
		resultType = (String)map.get("resultType");
	}
	
	int hinId_OPD=0;
	if(map.get("hinId_OPD") != null){
		hinId_OPD = (Integer)map.get("hinId_OPD");
	}
%>
<form name="message" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type=hidden name="<%=RESULT_NO %>" value="<%=resultNo %>" /> 
<input	type=hidden name="<%=RESULT_TYPE %>" value="<%=resultType %>" />
 <% if(resultType.equalsIgnoreCase("t")){%>
<input type="button" name="yes" value="yes" id="buttonTemplate"	class="button"	onclick="submitForm('message','/hms/hms/investigation?method=showPrintResultEntry');" />
<%}else{ %> 
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('message','/hms/hms/investigation?method=printResultEntryReport');" />
<% }%> 
<input type="button" name="no" value="No" class="button" 	onClick="submitForm('message','<%=url%>','checkTargetForNo');" /> 
<input type="button" name="next" value="Next" class="button"	onclick="submitForm('message','/hms/hms/investigation?method=nextForResultEntry','checkTargetForNo');" />

<%
  if(hinId_OPD == 0)
  {
	  %>
	  	<input type="button" value="Result Validation" class="buttonBig" onClick="submitFormForButton('message','/hms/hms/investigation?method=showPendingForResultValidationJsp','checkTargetForNo');" />
	  <%
  }
  
%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
