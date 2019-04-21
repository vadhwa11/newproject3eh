<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveType"%>
<%@page import="jkt.hrms.masters.business.HrMasLeave"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeNew"%>

<%
    Map<String,Object> map=(Map)request.getAttribute("map");
	
	List<HrMasLeave> leaveTypeList =new ArrayList<HrMasLeave>();
	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	
	List<HrMasLeaveTypeNew> masLeaveTypeList =new ArrayList<HrMasLeaveTypeNew>();
	List<HrMasLeaveTypeNew> leaveTypeForEdit =new ArrayList<HrMasLeaveTypeNew>();
	List<Object[]> minDateList =new ArrayList<Object[]>();
	
	HrMasLeaveTypeNew masLeaveType = new HrMasLeaveTypeNew();
	int leaveId = 0;
	List<HrMasLeaveTypeMediator> leaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();
	String message = "";
	
	

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	
	}
	if(map.get("leaveTypeMediatorList")!= null){
		leaveTypeMediatorList = (List)map.get("leaveTypeMediatorList");
	
	}
		Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); 
	if(map.get("employeeList") != null){
		employeeList = (List)map.get("employeeList");
	
	}	
%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeMediator"%>
<script>
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
<h2>Leave Statement</h2>
</div>
<div class="Block">
<form name="LeaveStatement" method="post" action="">
<label><span>*</span>From Employee </label> <select name="empcode1" validate="From Employee,string,yes">
	<option value="0">Select</option>
	<% for(MasEmployee masEmployee:employeeList){%>

	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getEmployeeCode()+"--"+masEmployee.getFirstName()+" " + masEmployee.getMiddleName()+ " " +masEmployee.getLastName()%>
	</option>
	<%} %>
</select> 

<label><span>*</span> Leave Type</label> <select name="leavetype"
	validate="Leave Type,nothing,yes">
	<option value="0">Select</option>
	<%
			for(HrMasLeaveTypeMediator leaveTypeMediator:leaveTypeMediatorList)
			{
				
		%>
	<option value="<%= leaveTypeMediator.getId() %>"><%=leaveTypeMediator.getLeaveType().getLeaveType().getDescription()%></option>

	<%} %>
</select>
<%--<!--<label>To Employee </label> <select name="empcode2">
	<option value="">Select</option>
	<% for(MasEmployee masEmployee:employeeList){%>

	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getEmployeeCode()+"--"+masEmployee.getFirstName()+" " + masEmployee.getMiddleName()+ " " +masEmployee.getLastName()%>
	</option>
	<%} %>
</select>--%>
<div class="clear"></div>
<div id="datesForm" style="display: block;"><label><span>*</span>
From Date</label> <input name="<%=FROM_DATE%>" type="text" readonly
	validate='From Date,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calFromDate"
	onclick="javascript:setdate('',document.LeaveStatement.<%=FROM_DATE%>,event)" />

<div id="divToDate"><label><span>*</span> To Date</label> <input
	type="text" name="<%=TO_DATE%>" readonly validate='To Date,date,yes'
	value="" class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calToDate"
	onclick="javascript:setdate('',document.LeaveStatement.<%=TO_DATE%>,event)" />
</div>
<div class="clear"></div>


</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="print" name="print"
	onclick="submitForm('LeaveStatement','/hms/hrms/report?method=printLeaveStatement');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="division"></div>
