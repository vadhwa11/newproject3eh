<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appointmentListReport.jsp  
 * Purpose of the JSP -  This is for Appointment Investigation Setup Report Day Wise.
 * @author  Vishal
 * Create Date: 15 September,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
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
<h2>Appointment Investigation List Day Wise</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="AppInvestigationSetupDayWiseList" target="_blank"
	method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="divId"><label>Days:</label> <select id="day"
	name="<%=DAY %>">
	<option value="0">Select</option>
	<option value="Sunday">Sunday</option>
	<option value="Monday">Monday</option>
	<option value="Tuesday">Tuesday</option>
	<option value="Wednesday">Wednesday</option>
	<option value="Thursday">Thursday</option>
	<option value="Friday">Friday</option>
	<option value="Saturday">Saturday</option>
</select> <label>Department:</label> <select id="departmentd"
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
<div class="floatRight"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('AppInvestigationSetupDayWiseList','appointment?method=generateAppointmentInvestigationSetupDayWiseReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></div>
</form>
</div>
<div class="clear"></div>
</div>



<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('AppSetupDayWiseList','/hms/hms/appointment?method=showAppointmentInvestigationSetupDayWiseReportJsp');
		}
		
	}
    </script>

