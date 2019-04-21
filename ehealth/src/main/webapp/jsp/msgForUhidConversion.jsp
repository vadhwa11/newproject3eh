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
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%
String currentDate="";
String currentTime="";
Map<String, Object> dateAndTimeMap=HMSUtil.getCurrentDateAndTime();
currentDate=(String)dateAndTimeMap.get("currentDate");
currentTime=(String)dateAndTimeMap.get("currentTime");
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";

String backUrl = "";
int currenVisitNo=0;
boolean successfullyAdded=false;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
String hinNo="";
if(null !=map.get("hinNo")){
	hinNo=(String)map.get("hinNo");
}

%>

<form name="messageAdt" method="post">

<div class="paddingTop15"></div>
<% if(successfullyAdded) 
{
	
%>
<h4><%=message %></h4>
<%} 
else{
%>
<h4>
<%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>


<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>


<input type="button" name="Back" value="Back" class="button" 
onclick="submitForm('messageAdt','/hms/hms/registration?method=showUHIDConversionJsp');" />

 <input type="button" name="yes" value="Yes" class="button"	
onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>');" />
 

<div class="clear"></div>

<div class="clear"></div>
<div class="Block">


<div class="clear"></div>



</div>
<div class="division"></div>

<div class="clear"></div>
<%-- <jsp:include page="testImageUpload.jsp">
<jsp:param value="<%=hinNo%>" name="hinNo"/>
</jsp:include> --%>
<div class="clear"></div>
<div class="division"></div>
	

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
