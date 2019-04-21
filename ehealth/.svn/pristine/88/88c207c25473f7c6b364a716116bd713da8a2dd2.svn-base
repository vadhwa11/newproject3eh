<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appointmentListReport.jsp  
 * Purpose of the JSP -  This is for Appointment List Report.
 * @author  Vishal
 * Create Date: 28th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<div class="clear"></div>

<script type="text/javascript" language="javascript">
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

<%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currentDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("employeeList") != null){
				employeeList = (List<MasEmployee>) map.get("employeeList");
			}
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%>

<div class="titleBg">
<h2>OPD Appointment List</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="opdAppointmentList" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="divId"><label><span>*</span>From Date</label> <input
	type="text" id="fromDateId" name="<%=VALID_FROM_DATE %>"
	value="<%=currentDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" validate="Validity Start Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.opdAppointmentList.<%=VALID_FROM_DATE%>,event)" />



<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
	name="<%=VALID_TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.opdAppointmentList.<%=VALID_TO_DATE%>,event)" />


</div>

<label>Doctor</label> <select id="employeeList" name="<%=EMPLOYEE_ID %>">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+ masEmployee.getLastName()%></option>
	<%
						}
					%>
</select>
<div class="clear"></div>
<label>Department</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			
							}
					%>
</select>
<div class="clear"></div>
<label>Consulted</label> <input type="radio" class="radioCheck"
	name="<%=SELECTED_RADIO  %>" value="1" /> <label class="noWidth">Non
Consulted:</label> <input type="radio" class="radioCheck"
	name="<%=SELECTED_RADIO  %>" value="2" /> <label class="noWidth">Both:</label>
<input type="radio" class="radioCheck" name="<%=SELECTED_RADIO  %>"
	value="3" checked="checked" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdAppointmentList','appointment?method=generateOPDAppointmentReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"	accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<div class="clear"></div>




<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('opdAppointmentList','/hms/hms/appointment?method=showOPDAppointmentListReportJsp');
		}
		
	}
	
	
    </script>

