<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masEmployeeList")!= null){
				masEmployeeList = (List)map.get("masEmployeeList");
				}
				if(map.get("masDepartmentList")!= null){
					masDepartmentList = (List)map.get("masDepartmentList");
				}
				
%> 
<script type="text/javascript">
	function display(idvalue) {
	<%
	for(MasEmployee masEmployee :masEmployeeList){
		int id = masEmployee.getId();
		
	%>
	if(idvalue == <%=id%> ){
      document.getElementById('empId').value = '<%= masEmployee.getFirstName()+" "+masEmployee.getLastName() %>'
      
	}
<%
	}
	
%>

}

function displayDepartment(idvalue) {
	<%
	for(MasDepartment masDepartment :masDepartmentList){
		int id = masDepartment.getId();
		
	%>
	if(idvalue == <%=id%> ){
      document.getElementById('departmentId').value = '<%= masDepartment.getDepartmentName() %>'
     
	}
<%
	}
	
%>

var departmentId=document.getElementById('departmentId1').value;

submitProtoAjaxforAttendence('employeeAttendanceCardReport','/hms/hrms/attendance?method=getEmployeeList&departmentId='+departmentId+'');
return ;
}


	function checkFromDate(){
		var fDate = document.employeeAttendanceCardReport.<%= FROM_DATE%>.value;
		var tDate = document.employeeAttendanceCardReport.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(toDate < fromDate)
		{
			alert(" From Date is greater than  To Date.");
			document.employeeAttendanceCardReport.<%= FROM_DATE%>.value = "";
			document.employeeAttendanceCardReport.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	</script> <script>
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

<form name="employeeAttendanceCardReport" method="post" action="">
<div class="titleBg">
<h2>Employee Attendance Card Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label> Department Code</label> 
<select	name="<%=DEPARTMENT_ID %>" id="departmentId1" onblur="displayDepartment(this.value)">
<option value="0">Select</option>
<%
	for(MasDepartment masDepartment :masDepartmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
<%}%>
</select> 
<input name="<%=DEPARTMENT_NAME%>" id="departmentId" class="readOnly" readonly="readonly" type="text" />
<div id="employeeIdsDiv">
<label> Employee Name </label> 
<select	name="<%=EMPLOYEE_ID %>">
<option value="">Select</option>
</select></div>
<div class="clear"></div>
<label>From Date</label> 
<input type="text" id="dobId"	name="<%=FROM_DATE %>" value="" class="date" readonly="readonly"	validate="From date ,date,yes" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.employeeAttendanceCardReport.<%=FROM_DATE%>,event)" />
<label>To Date</label> 
<input type="text" name="<%=TO_DATE %>" value="" class="date" readonly="readonly" validate="To date ,date,yes" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.employeeAttendanceCardReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onClick="submitForm('employeeAttendanceCardReport','attendance?method=printEmployeeAttendanceCardReport');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>