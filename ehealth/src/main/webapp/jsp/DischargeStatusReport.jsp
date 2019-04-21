<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *nursingCareReport.jsp
 * Purpose of the JSP -  This is for Discharge Status Wise Report.
 * @author  Dipali
 * Create Date: 29 March,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
	</script>

<div class="titleBg">
<h2>Discharge Status Wise Report</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<%
			 	String userName = "";
	 			int deptId =0;
	 			int careType =0;

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
			 	List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
			 	//	 	List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;

				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}

				if (map.get("dischargeStatusList") != null) {
					dischargeStatusList = (List<MasDischargeStatus>) map.get("dischargeStatusList");
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}

				if (map.get("deptId") != null) {
			 		deptId = Integer.parseInt(""+map.get("deptId")) ;
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
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

<form name="search" target="_blank" method="post" action="">
<div class="Block">
<label><span>*</span> From Date </label>
<input type="text" name="<%= FROM_DATE %>" value="<%=currenDate%>"class="date" maxlength="30" tabindex=1 validate="From Date,date,yes"/>
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date,date,no"
	onclick="setdate('<%=currenDate%>',document.search.<%= FROM_DATE%>,event);" />
<label><Span>*</Span> To Date </label>
<input type="text"	name="<%= TO_DATE %>" value="<%=currenDate%>" class="date"	maxlength="30" tabindex=1  validate="From Date,date,yes"/>
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date,date,no"
	onclick="setdate('<%=currenDate%>',document.search.<%= TO_DATE%>,true);" />

<div class="clear"></div>
<label>Ward </label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>" onchange="getDepartmentName();" validate="Ward,string,no">
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
</select>
 <%-- <div class="clear"></div> --%>
 <label><span>*</span>Status  </label>
 <select id="dischargeStatusId" name="<%=DISCHARGE_STATUS_ID %>"onchange="getDischargeStatusName();"validate="Discharge Status Name,string,yes">
	<option value="0">Select</option>
	<%
		for (MasDischargeStatus masDischargeStatus : dischargeStatusList) {
	%>
	<option value="<%=masDischargeStatus.getId() %>"><%=masDischargeStatus.getDischargeStatusName()%></option>
	<%}	%>
</select>
<div class="clear"></div>
<div class="clear"></div>
<label> Detail Type</label>
<input type="radio" name="reportName" checked="checked" value="DischargeStatusWiseReport" class="inputRadiobutton" />
<label>Summary Type</label>
<input type="radio" name="reportName" value="Discharge_Status_Wise_Summary" class="inputRadiobutton" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report" onClick="submitForm('search','ipd?method=generateDischargeStatusWiseReport');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input type="button" name="OK" value="OK" class="button" onClick="submitForm('search','ipd?method=generateDischargeStatusWiseReport');" />---%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>