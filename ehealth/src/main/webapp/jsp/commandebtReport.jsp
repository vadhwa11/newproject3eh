<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
	<%
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
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
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
	 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}
	 	if (map.get("masDepartmentList") != null) {
	 		masDepartmentList = (List<MasDepartment>) map.get("masDepartmentList");
	 	}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<h2 align="left" class="style1">Commandant Report</h2>

<br />
<form name="commandentReport" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="bodytextB"><font id="error">*</font> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('',document.commandentReport.<%=TO_DATE%>,event)" />
<br />
<div style="padding-left: 15px;"><input type="button" name="OK"
	value="OK" class="button"
	onClick="submitForm('commandentReport','mis?method=printCommandentReport');" />
</div>

</form>

</div>