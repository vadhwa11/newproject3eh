<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.FROM_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.TO_DATE"%>

<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
%>
<div class="titleBg">
<h2>IDSP Report</h2>
</div>
<form name="idspReport" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span> From Date </label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" MAXLENGTH="30" validate="From Date date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.idspReport.<%=FROM_DATE%>,true)" />

<label><span>*</span> To Date </label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="To Date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.idspReport.<%=TO_DATE%>,true)" />
	<div class="clear"></div>
	<div class="clear"></div>
	<input type="button" value="P Form " onclick="submitForm('idspReport','/hms/hms/pubHealth?method=printIDSPReport')" />
	<input type="button" value="L Form " onclick="submitForm('idspReport','/hms/hms/pubHealth?method=printIDSPLReport')" />
	<div class="clear"></div>
	<div class="clear"></div>
</div>
</form>


</div>