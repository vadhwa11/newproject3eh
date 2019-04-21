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


<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />


<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOtPatientDetails&otProcedure=yes";
  obj.submit();
}
</script> <%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String YearlySrNo = "";
String ipNo="";
String wardName="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("YearlySrNo") != null ){
	YearlySrNo = (String)map.get("YearlySrNo");
}
if(map.get("ipNumber")!=null&&map.get("ipNumber")!=""){
	ipNo=(String)map.get("ipNumber");
}
if(map.get("wardName")!=null&&map.get("wardName")!=""){
	wardName=(String)map.get("wardName");
}

%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>
<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('message','/hms/hms/ot?method=printOtProcedureNotesEntryJsp&YearlySrNo=<%=YearlySrNo %>&ipNo=<%=ipNo%>&wardName=<%=wardName%>','checkTargetForYes','checkTargetForNo');" />
<input type="button" name="no" class="button" value="No"
	onclick="showBack('message');checkTargetForNo()" />
	
</form>