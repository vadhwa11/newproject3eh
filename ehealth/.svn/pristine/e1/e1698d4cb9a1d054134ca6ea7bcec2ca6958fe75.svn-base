<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry
 * @author  Abha

 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>




<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> infoMap = new HashMap<String,Object>();
	
	String message = "";
	String url = "";
	String resultIdStringForTemplate = "";
	
	int deptId= 0;

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") != null){
		url = (String)map.get("url");
	}
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("resultIdStringForTemplate")!= null){
		resultIdStringForTemplate= (String)map.get("resultIdStringForTemplate");
	}
	
%>

<form name="messageResult" method="post" target="_blank">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<input type="hidden" name="resultIdStringForTemplate"
	id="resultIdStringForTemplate" value="<%=resultIdStringForTemplate%>" />

<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=showPrintResultModificationLab');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageResult','/hms/hms/investigation?method=showPendingResultValidationForCorrectionLabJsp','checkTargetForNo');" />

<!--  <input type="button" value="Report Delivery" class="cmnButton" onClick="submitFormForButton('messageResult','/hms/hms/investigation?method=showReportCollectionJsp','checkTargetForNo');" /> -->
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

