<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

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
 
 	List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	
 	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
 	if(map.get("employeeDepartmentList") != null){
		employeeDepartmentList = (List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
	}
			
	%>
<div class="titleBg">
<h2>Daily Visit Report</h2>
</div>
<div class="clear"></div>

<form name="dailyVisitReport" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="doctorsDiv" value="y">
<div class="Block">
<label class="autoSpace">From Date<span>*</span></label> 
<input type="text"	id="opNominalFromDateId" validate="fromDate,char,yes" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.dailyVisitReport.<%=FROM_DATE%>,event)" />
<label class="autoSpace"> Time</label>
<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="autoSpace"> To Date <span>*</span></label> 
<input type="text" id="opNominalToDateId"  validate="toDate,char,yes" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.dailyVisitReport.<%=TO_DATE%>,event)" />
<label class="autoSpace"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<div class="clear"></div>
<label class="autoSpace">Department</label> 
<select id="departmentId" validate="department,metachar,no" name="<%=DEPARTMENT_ID %>"
		onchange="submitProtoAjaxWithDivName('dailyVisitReport','/hms/hms/adt?method=getServiceCentreDoctors','testDiv');">
	<option value="">Select</option>
	<% for (MasEmployeeDepartment empDepSearch : employeeDepartmentList) { %>
		<option value="<%=empDepSearch.getId() %>" ><%=empDepSearch.getEmpDeptName()%></option>
	<% } %>
</select>
<div id="testDiv">
	<label class="autoSpace">Service Centre</label> 
	<select id="serviceCentreId" validate="serviceCentre,metachar,no" name="serviceCentreId">
		<option value="">Select</option>
	</select>
	<label class="autoSpace">Doctors </label>
   	<select name="employyeId" id="employyeId" >
		<option value="">Select</option>
	</select>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('dailyVisitReport','adt?method=printDailyVisitReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>





