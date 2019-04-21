<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationListReport.jsp  
 * Purpose of the JSP -  This is for Investigation List.
 * @author  Vishal
 * Create Date: 03th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

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
			List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("equipmentList") != null){
				equipmentList = (List<AppEquipmentMaster>) map.get("equipmentList");
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
<h2>OPD Investigation List</h2>
</div>
<div class="clear"></div>
<div class="Block">

<form name="opdInvestigationList" target="_blank" method="post"
	action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="divId"><label><span>*</span> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" validate="From Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate %>',document.opdInvestigationList.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date:</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate %>',document.opdInvestigationList.<%=TO_DATE%>,event)" />
</div>
<label>Equipment:</label> <select id="equipmentList"
	name="<%=EQUIPMENT_ID %>">
	<option value=0>Select</option>
	<%
							for (AppEquipmentMaster appEquipmentMaster : equipmentList) {
						%>
	<option value="<%=appEquipmentMaster.getId() %>"><%=appEquipmentMaster.getEquipmentName()%></option>
	<%
						}
					%>
</select>
<div class="clear"></div>
<label>Department:</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value=0>Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			
							}
					%>
</select>
<div class="floatRight"><input type="button" name="OK" value="OK"
	class="button"	onClick="submitForm('opdInvestigationList','appointment?method=generateOPDInvestigationReport','validateeDate');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
<div class="clear"></div>
</div>



<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
			submitForm('opdInvestigationList','/hms/hms/appointment?method=showOPDAppointmentListReportJsp');
		}
		
	}
	
	function validateeDate(){
	var nowDate=new Date();
	
	obj1 = eval(document.opdInvestigationList.fromDate)
	obj2 = eval(document.opdInvestigationList.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}
			
		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}
	
	}
	return true;
    }	
    </script>

