<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Daliy Ward-Wise bed Status Report.
 * @author  Dipali
 * Create Date: 07th March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

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
	</script>
<div class="titleBg">
<h2>Daily Ward-Wise Bed Status</h2>
</div>
<div class="Block">
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
					
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<Patient> patientList = new ArrayList<Patient>();
			 	List<Visit> visitList = new ArrayList<Visit>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
				
			 	if (map.get("departmentList") != null) {
			 		departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 	}
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 %>

<form name="dailyBedStatus" target=_blank method="post" action="">

<label class="bodytextB"> From Date:</label> <input type="text"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"
	class="date" readonly="readonly" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.dailyBedStatus.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB">To Date:</label>
	<input type="text" id="ToDateId" name="<%=TO_DATE %>"
	value="<%=currenDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.dailyBedStatus.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 
<label class="bodytextB">Ward:</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID%>">
	<option value="">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					%>
</select> 
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('dailyBedStatus','mis?method=searchDailyBedStatusReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>