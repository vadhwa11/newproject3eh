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

<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script> 
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPACClearanceList";
  obj.target ="_self"
  obj.submit();
}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
int orderNo = 0;
int hinId=0;
String pastRecords="";
String presentHistory="";
String drugTherapy="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("orderNo") != null){
	orderNo = (Integer)map.get("orderNo");
}
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
if(map.get("pastRecords") != null){
	pastRecords = (String)map.get("pastRecords");
}
else
{
	pastRecords="No Records";
}
if(map.get("presentHistory") != null){
	presentHistory = (String)map.get("presentHistory");
}
else
{
	presentHistory="No Records";
}
if(map.get("drugTherapy") != null){
	drugTherapy = (String)map.get("drugTherapy");
}
else
{
	drugTherapy="No Records";
}
%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<h4><span><%=message%></span></h4>
<div class="division"></div>

<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('message','/hms/hms/ot?method=printPAC&hinId=<%=hinId %>&orderNo=<%=orderNo %>&pastRecords=<%=pastRecords.trim()%>&presentHistory=<%=presentHistory.trim()%>&drugTherapy=<%=drugTherapy.trim()%>','checkTargetForYes');" />
<input type="button" name="no" class="button" value="No"
	onclick="showBack('message')" /></form>
