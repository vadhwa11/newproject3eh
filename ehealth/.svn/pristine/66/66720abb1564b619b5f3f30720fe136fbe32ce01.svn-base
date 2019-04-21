<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Dipali
 * Create Date: 21 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String url1="";
	String visitId="";
	String hinNo="";
	int hospitalId = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get(RequestConstants.VISIT_ID) !=null&& !"".equals(map.get(RequestConstants.VISIT_ID))){
		visitId=""+map.get(RequestConstants.VISIT_ID);
	}
	if(map.get(RequestConstants.HIN_NO) !=null&&!"".equals(map.get(RequestConstants.HIN_NO))){
		hinNo=""+map.get(RequestConstants.HIN_NO);
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	
	if(map.get("hospitalId")!=null){
		hospitalId=(Integer)map.get("hospitalId");
	}
	
	String printUrl = "/hms/hms/stores?method=printPricriptionIssue&visitNo="+visitId+"&hinNo="+hinNo+"&hospitalId="+hospitalId;
%>
<form name="message" method="post">
	<input type="hidden" value="6"
		name="<%=RequestConstants.VISIT_NUMBER%>" /> <input type="hidden"
		value="610538" name="<%=RequestConstants.HIN_NO%>" />
	<div class="clear"></div>
	<h4>
		<span><%=message%></span>
	</h4>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<!--<input type="button" class="button" value="Back"
		onClick="submitForm('message','<%=url%>');" />  <input type="button"
		class="button" name="next" value="NextPatient"
		onClick="submitForm('message','/hms/hms/stores?method=printPricriptionIssue');"/> -->
	<input type="button" class="buttonBig2"
		value="Prescription Issue Report"
		onClick="#" />
	<input type="button" value="Prescription Issue Repor" class="buttonBig2" onClick="checkTargetForYes();submitForm('message','<%=printUrl %>');checkTargetForNo();" />	
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>