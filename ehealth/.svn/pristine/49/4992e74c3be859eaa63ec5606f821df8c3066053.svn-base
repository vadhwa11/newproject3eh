<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
 	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
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
	
	//System.out.println("departmentTypeCodeForWard "+departmentTypeCodeForWard);	
	
	%>
<div class="titleBg">
<h2>IP Discharge Register</h2>
</div>
<div class="clear"></div>

<form name="ipDischargeRegister" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="Block">
<label>From Date</label> 
<input type="text"	id="mlcDateId" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.ipDischargeRegister.<%=FROM_DATE%>,event)" />
<label> To Date </label> 
<input type="text" id="mlcDateId" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.ipDischargeRegister.<%=TO_DATE%>,event)" />
<label> Ward</label> 
<select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getDepartmentType()!=null){//added by govind 29-12-2016
								if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
							}}
					%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('ipDischargeRegister','adt?method=printIPDischargeRegister');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>





