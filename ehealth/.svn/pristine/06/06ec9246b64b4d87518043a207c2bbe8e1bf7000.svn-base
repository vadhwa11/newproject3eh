<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
	map = (Map<String, Object>)request.getAttribute("map");
}
String message="";
if(map.get("message") != null)
{
	message = (String)map.get("message");
}


String flag = "";


if(map.get("flag") != null){
	flag =(String)map.get("flag");
}
int scheduleId=0;
if(map.get("scheduleId") != null){
	scheduleId =(Integer)map.get("scheduleId");
}
%>

<form name="lgl_msg_minutes_of_meeting" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<%-- <%if(scheduleId!=0){ %>
<input type="button" name="Yes" value="Print" class="button"	onclick="submitForm('lgl_msg_minutes_of_meeting','legal?method=printMinutesOfMeetingJsp&meetingId=<%=scheduleId %>');" />
<%} %> --%>
<input type="button" name="No" value="Back" class="button"	onclick="submitForm('lgl_msg_minutes_of_meeting','training?method=showListOfMeetingSchedulingJsp');" />

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
