<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opd_msgSurgeryRequisitionForInpatient.jsp  
 * Purpose of the JSP -  This is for OT Message.
 * @author  Dipali
 * Create Date: 1st Jan,2009
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />


<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	int visitId = 0;
	int hospitalId=0;
	int deptId=0;
	int orderNo = 0;
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("visitId") != null && !map.get("visitId").equals("")){
		visitId = (Integer)map.get("visitId");
	}
	if(map.get("hospitalId") != null && !map.get("hospitalId").equals("")){
		hospitalId = (Integer)map.get("hospitalId");
	}
	if(map.get("deptId") != null && !map.get("deptId").equals("")){
		deptId = (Integer)map.get("deptId");
	}
	if(map.get("orderNo") != null){
		orderNo = (Integer)map.get("orderNo");
	}
	%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('message','/hms/hms/opd?method=printSurgeryRequisitionForInPatient&orderNo=<%=orderNo %>&hospitalId=<%=hospitalId %>');" />
<input type="button" name="no" class="button" value="No"
	onclick="submitForm('message','/hms/hms/opd?method=showOPDMainJsp&deptId=<%=deptId %>&visitId=<%=visitId %>');" />
</form>