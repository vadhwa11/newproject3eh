<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * monthlySick.jsp  
 * Purpose of the JSP -  This is for Monthly sick Report.
 * * @author  Priyanka garg  
 * Create Date: 26th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>




<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <br />
<h2 align="left" class="style1">Monthly Sick Admission Report for
Staff (38-A)</h2>

<br />


<%
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	List<MasUnit> masUnitList = new ArrayList<MasUnit>();

	if (map.get("rankCategoryList") != null) {
		rankCategoryList = (List<MasRankCategory>) map
				.get("rankCategoryList");
	}
	if (map.get("masUnitList") != null) {
		masUnitList = (List<MasUnit>) map.get("masUnitList");
	}
%>

<form name="monthlySick" target="_blank" method="post" action="">

<label class="bodytextB"> <font id="error">*</font>From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.monthlySick.<%=FROM_DATE%>,event)" />

<label class="bodytextB"><font id="error">*</font> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.monthlySick.<%=TO_DATE%>,event)" />

<br />
<br />
<label class="bodytextB">NC/NON NC</label> <input type="radio" name="nc"
	id="nc" value="nc" checked="checked" />NC <input type="radio"
	name="nc" id="nc" value="nonnc" />Non NC <br />
<br />
<label class="bodytextB"><font id="error">*</font>Output To :</label> <input
	type="radio" name="outputType" value="Excel" />Excel <input
	type="radio" name="outputType" value="Pdf" checked="checked" />PDF <br />
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('monthlySick','mis?method=searchMonthlySickReport','checkFromNTodata');" />



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>






</div>