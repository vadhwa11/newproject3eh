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
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%> 
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
String backUrl = "";
int inpatientId =0;
String andNo="";
String deptName="";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

int intakeoutput_id=0;
if(map.get("intakeoutput_id") != null){
	intakeoutput_id = Integer.parseInt(""+map.get("intakeoutput_id")) ;
}

Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
%>
<form name="silDilStatusMessage" method="post">
<input type="hidden" name="intakeoutput_id" value="<%=intakeoutput_id%>" />

<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="yes" value="Yes" class="button"	onClick="submitForm('silDilStatusMessage','/hms/hms/ipd?method=showIntakeOutputChartIdReport&intakeoutput_id=<%=intakeoutput_id%>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitFormForButton('silDilStatusMessage','/hms/hms/ipd?method=showIntakeOutputJsp&parent=<%=inpatientId %>');" />
<input type="button" name="no" value="Back" class="button"	onclick="submitFormForButton('silDilStatusMessage','/hms/hms/ipd?method=showIntakeOutputJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
