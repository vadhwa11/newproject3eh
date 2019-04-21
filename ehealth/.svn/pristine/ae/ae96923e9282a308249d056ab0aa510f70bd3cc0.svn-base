<%--
	 * Copyright 2010 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dietIndoorPatientChartJsp.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 09.11.2010    Name: Ramdular
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>

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
		Map<String, Object> map = new HashMap<String, Object>();
		String message="";
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currenDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");
	 	String userName=null;
	  	if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
%>
<div class="titleBg">
<h2>Chart of diet served to indoor patient</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="dietIndoorPatientChart" method="post" >
<label>Date :</label>
<input id="toDateId" name="tDate" value="<%=currenDate%>" class="date" readonly="readonly" maxlength="30" type="text" />
<img src="/hms/jsp/images/cal.gif" validate="Pick a date" onclick="javascript:setdate('12/11/2010',document.dietIndoorPatientChart.tDate,event)" border="0" width="16" height="16"/>

<label>Time:</label> <select name="timeType" id="timeType">
	<option value="M">Morning</option>
	<option value="E">Evening</option>
</select>
<input type="hidden" name="toDate" id="toDate" value="" />
<input name="Submit"
	type="button" align="right" tabindex="5" class="button" value="Submit"
	onclick="if(dateValue()){submitForm('dietIndoorPatientChart','/hms/hms/diet?method=printIndoorPatientDiet');}" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currenDate%></label>
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currenDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
<div class="clear"></div>
<script type="text/javascript" language="javascript">
function dateValue()
{
	var toDateId =document.getElementById('toDateId').value;
  	toDateId =toDateId.substring(6,10)+'-'+toDateId.substring(3,5)+'-'+toDateId.substring(0,2);
 	document.getElementById('toDate').value = toDateId;
 	return true;
}
</script>
