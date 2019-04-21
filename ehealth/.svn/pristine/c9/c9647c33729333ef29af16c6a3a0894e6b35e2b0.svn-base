<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForOpdHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in patientPrescriptionReport.jsp
	 * @author  Create Date: 25.08.2008    Name: Mansi  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="java.util.*"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>




<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String url = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") != null){
	url = (String)map.get("url");
}

%>
<form name="search" method="post"><br />
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button" onclick="submitForm('search','/hms/hms/lab?method=showPendingSampleValidationJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
