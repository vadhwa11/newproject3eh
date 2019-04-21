<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
	
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOtPatientDetails&otProcedure=no";
  obj.submit();
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String YearlySrNo = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("yearlySerialNo") != null){
	YearlySrNo = (String)map.get("yearlySerialNo");
}
%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('message','/hms/hms/ot?method=printOtPreAnesthesiaNotesEntryJsp&yearlySerialNo=<%=YearlySrNo %>','checkTargetForNo');" />
<input type="button" name="no" class="button" value="No"
	onclick="showBack('message')" /></form>
