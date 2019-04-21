<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">

<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	
</script>

<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
	</script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<h4>Future Consultation</h4>
<div class="Block" >
<form name="futureConsultation" method="post" action="">

<label>Appointment Date</label>
<input id="appointmentDate"  name="appointmentDate"  type="text"	validate="pulse,int,no" maxlength="3" class="date" tabindex="10"/>
<img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.futureConsultation.appointmentDate,true);" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<table  border="0">
	<tr>
		<td>
			<div style="height:100px;width:100px;background:#FF9900">6
			    <div class="clear"></div>
				<label>ADHR2819</label>
				<label>0999973152</label>
			</div>
		</td>
		<td>
			<div style="height:100px;width:100px;background:#3ADF00"><label>11</label></div>
		</td>
		<td>
			<div style="height:100px;width:100px;background:#3ADF00"><label>12</label></div>
		</td>
		<td>
			<div style="height:100px;width:100px;background:#3ADF00"><label>13</label></div>
		</td>
		<td>
			<div style="height:100px;width:100px;background:#3ADF00"><label>14</label></div>
		</td>
		<td>
			<div style="height:100px;width:100px;background:#3ADF00"><label>15</label></div>
		</td>
	</tr>
</table>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

