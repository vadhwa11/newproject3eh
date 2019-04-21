<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Financial Year Details.
 * @author  Ujjwal
 * Create Date: 24th Feb,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<script type="text/javascript" src="../jsp/js/calendar.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	ArrayList searchfinancialyearList = (ArrayList)map.get("searchfinancialyearList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		  %>
		   <h4><span><%=message %></span></h4>
<%} %>
<script>
<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>

		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<div class="titleBg">
<h2>Financial Year Report</h2>
</div>
<div class="clear"></div>
<form name="financial" method="post" >
<div class="Block">
<label><span>*</span> Start Date</label>
<input type="text" id="<%=START_DATE %>" readonly="readonly" name="<%=START_DATE %>" value="" validate="Start Date,date,yes"  class="date"  />
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.financial.<%=START_DATE %>,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
<label><span>*</span> End Date</label>
<input type="text" id="<%=END_DATE %>" readonly="readonly" name="<%=END_DATE %>" value="" validate="End Date,date,yes"  class="date"  />
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.financial.<%=END_DATE %>,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Financial_Report">
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" value="Generate Report" class="buttonBig" onClick="submitForm('financial','budget?method=generatefinancialyearReport');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>