<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietIndoorMessageDetails.jsp
 * Purpose of the JSP -  This is for Message.
 * @author  @Ramdular
 * Create Date: 29 Oct 2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%@page import="java.util.Calendar"%><script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script> 
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	String time ="";
	if(map.get("time") !=null){
		time= (String)map.get("time");
	}
	String toDate=null;
	if(map.get("toDate") !=null){
		toDate= (String)map.get("toDate");
	}
%>

<%@page import="java.util.Date"%><div class="clear"></div>
<form name="message" method="post"><br />
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<input type="hidden" name="toDate" id="toDate" value="<%=toDate%>" />
<input type="hidden" name="timeType" id="timeType" value="<%=time%>" />
<input type="button" name="b" value="Go Back" class="button" onClick="javascript:history.back();" />
<input name="print" type="button" align="right" class="button"
	value="Print" tabindex="6"
	onclick="submitForm('message','/hms/hms/diet?method=printIndoorPatientDiet');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>