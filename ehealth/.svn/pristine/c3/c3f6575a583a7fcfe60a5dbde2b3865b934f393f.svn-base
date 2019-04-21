
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * foodTastingReport.jsp  
 * Purpose of the JSP -  This is for Duty Nursing Officers Report.
 * @author  Dipali
 * Create Date: 19, jUNE,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@page import="java.net.URL"%>



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
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
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
			 	List<Object> list = null;
			 	Date date1  = null;
			 	
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("date") != null) {
			 		date1 = (Date) map.get("date");
			 		session.setAttribute("date", date1);
			 	}
			 	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");  
			 %>
<h2 align="left" class="style1">Duty Nursing Officers Report</h2>
<div class="clear"></div>
<form name="dutyNursing" target="_blank" method="post" action="">
<div class="Block"><label><Span>*</Span> Date: </label> <input
	type="text" name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"
	readonly="readonly" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.dutyNursing.<%=TO_DATE%>,true);" />

<label class="bodytextB"><span>*</span> Ward :</label> <select
	id="departmentId" name="<%=DEPARTMENT_ID %>"
	onchange="getDepartmentName();" validate="Ward,String,yes">
	<option value="0">Select</option>
	<%
	int departmentId = 0;
		for(MasDepartment masDepartment : departmentList){
			if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
				departmentId = masDepartment.getId();
		%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
		}
	} %>
</select> <input name="deptName" value="" type="hidden" id="deptName" />
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('dutyNursing','ipd?method=showDutyNursingReport');" />
<div class="clear"></div>
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<h2 align="left" class="style1">Duty Nursing Officers Daily Remarks</h2>
<div class="clear"></div>
<form name="dutyNursing1" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label class="bodytextB"><span>*</span>
Date:</label> <input type="text" name="<%=DATE_OF_WARD_MASTER%>"
	value="<%=currentDate %>" class="textbox_size20" style="width: 140px;"
	readonly="readonly" validate="Adm. Date,dateOfAdmission,yes"
	MAXLENGTH="30" id="admDate" onchange="populateListDateTime();"
	onclick="populateListDateTime();" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" id="imgId" class="calender"
	onclick="setdate('<%=currenDate%>',document.dutyNursing1.<%=DATE_OF_WARD_MASTER%>,true);" />


<label class="bodytextB"><span>*</span>Ward :</label> <select
	id="departmentIdTemp" name="<%=DEPARTMENT_ID_TEMP%>"
	onchange="getDepartmentNameForRemarks();" validate="Ward,String,yes">
	<option value="0">Select</option>
	<%
	int departmentId1 = 0;
		for(MasDepartment masDepartment : departmentList){
			if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
				departmentId1 = masDepartment.getId();
		%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
		}
	} %>
</select> <input name="deptNameForRemarks" value="" type="hidden"
	id="deptNameForRemarks" />
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('dutyNursing1','ipd?method=showDutyNursingOfficersRemarks');" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<script type="text/javascript">
			function getDepartmentName(){
			
			var obj = document.getElementById("departmentId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					deptName = obj.options[i].text
					break;
				}
			}
				document.getElementById("deptName").value =deptName
			}
			function getDepartmentNameForRemarks(){
			
			var obj = document.getElementById("departmentIdTemp");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					deptName = obj.options[i].text
					break;
				}
			}
				document.getElementById("deptNameForRemarks").value =deptName
			}
			
			</script></form>
</div>