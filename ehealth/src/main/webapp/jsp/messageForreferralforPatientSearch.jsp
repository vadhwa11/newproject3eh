<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp
 * Purpose of the JSP -  This is for Birth Message.
 * @author  Diapli
 * Create Date: 26 April,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>




<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String message1="";
String formName = "";
String flag="";
int opPatientReferralId=0;
String adNo = "";
String messageType ="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("opPatientReferralId") != null){
	opPatientReferralId = (Integer)map.get("opPatientReferralId");

}
//
%>
<form name="messageMisBirth" target="_blank" method="post"><br />
<%
if(map.get("message") != null){
	message = (String)map.get("message");
}
//


	%> <%if(!message.equals(""))
	{
	
	%>

<h4><span><%=message %></span></h4>
<%} %>

<%%> 


<h4><%=message %></h4>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="yes" value="Yes" class="button"	onclick="submitForm('messageMisBirth','/hms/hms/opd?method=printBDCertificate&opreferralId=<%=opPatientReferralId %>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageMisBirth','/hms/hms/mis?method=showreferralPatientJsp','checkTargetForNo');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <br />
<br />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
