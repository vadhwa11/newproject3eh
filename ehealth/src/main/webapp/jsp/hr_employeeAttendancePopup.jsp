<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hrms.masters.business.HrAttendanceLoader"%>
<%@page import="jkt.hrms.masters.business.HrParameter"%>
<%@page import="jkt.hrms.masters.business.Holidaycalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%@page import="jkt.hrms.masters.business.Holidaycalendar"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<Holidaycalendar> holidayList = new ArrayList<Holidaycalendar>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		String message = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}

		if(map.get("attendanceList")!= null){
			attendanceList = (List<HrAttendanceLoader>)map.get("attendanceList");
			}
		if(map.get("masEmployeeList")!= null){
			masEmployeeList = (List)map.get("masEmployeeList");
			}
		if(map.get("parameterList")!= null){
			parameterList = (List<HrParameter>)map.get("parameterList");
			}

		if(map.get("holidayList")!= null){
			holidayList = (List<Holidaycalendar>)map.get("holidayList");
			}

		if(map.get("message")!= null){
			message = (String)map.get("message");
			}

		String halfday = "";
		String fullday = "";
		String manualOverTime ="";
		if(parameterList.size()>0){
			for(HrParameter hrParameter: parameterList){
				halfday =""+hrParameter.getHalfday();
				fullday = ""+hrParameter.getFullday();
				manualOverTime = ""+hrParameter.getOvertime();

			}
		}
%>

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





<form name="employeeAttendance" method="post" action="">
<div id="main">
<div class="titleBg">
<h2>Employee Attendance</h2>
</div>
<div class="clear"></div>

<!--table starts-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Employee Name</th>
		<th scope="col">Attendance Date</th>
		<th scope="col">Time In</th>
		<th scope="col">Time Out</th>
		<th scope="col">Attendance Mark</th>
		<th scope="col">OT</th>
		<th scope="col">Under Time</th>
		<th scope="col">Authorized</th>
		<th scope="col">Processed</th>



	</tr>
	<%
	  if(attendanceList.size()>0){
			String inTime = "";
			String outTime = "";
			String inDate = "";
			String outDate = "";
		for(HrAttendanceLoader hrAttendanceLoader :attendanceList){
			String totalOverTime = "";
		    String totalUt = "";
			inDate = HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getDate());
			outDate =HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getOutDate());
			inTime=hrAttendanceLoader.getTimeIn();
			outTime =hrAttendanceLoader.getTimeOut();

			boolean holidayFlag = false;
			if(holidayList.size() > 0){
				for (Iterator iter = holidayList.iterator(); iter.hasNext();){
					Holidaycalendar element = (Holidaycalendar) iter.next();
					String holiday=HMSUtil.convertDateToStringWithoutTime(element.getHolidayDate());
					if(inDate.equals(holiday)){
						holidayFlag = true;
					}
				 }
			}

			int isday=hrAttendanceLoader.getDate().getDay();
			boolean satSun = false;
			if(isday==0 || isday==6){
				satSun = true;
			}

			Map parameterMap = new HashMap();
			parameterMap.put("inDate",inDate);
			parameterMap.put("outDate",outDate);
			parameterMap.put("inTime",inTime);
			parameterMap.put("outTime",outTime);
			parameterMap.put("manualOverTime",manualOverTime);
			parameterMap.put("fullday",fullday);

			Map diffMap = new HashMap();
			diffMap = HMSUtil.calculateTimeDiffForAttendance(parameterMap);

			if(diffMap.get("totalOverTime")!= null){
				totalOverTime = (String)diffMap.get("totalOverTime");
			}
			if(diffMap.get("totalUt")!= null){
				totalUt = (String)diffMap.get("totalUt");
			}
 %>

	<%
 	if(satSun == true || holidayFlag == true){
 %>
	<tr bgcolor="green">
		<%}else{ %>

		<tr>
			<%} %>
			<%
  	for(MasEmployee masEmployee :masEmployeeList){
  		if(masEmployee.getId().equals(hrAttendanceLoader.getEmployee().getId())){
  %>
			<td><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></td>
			<%
  		}
  	}
     %>
			<td><%=HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getDate())%></td>
			<td><%=hrAttendanceLoader.getTimeIn() %></td>
			<td><%=hrAttendanceLoader.getTimeOut() %></td>
			<td><%=hrAttendanceLoader.getAttendanceMark() %></td>
			<td><%=totalOverTime %></td>
			<td><%=totalUt %></td>
			<td><%=hrAttendanceLoader.getAuthorized() %></td>
			<td><%=hrAttendanceLoader.getProcessed() %></td>





		</tr>
		<%
  		}

 %>

</table>
<%}else{ %>
<h4><span>No Records Found</span></h4>
<%} %>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

