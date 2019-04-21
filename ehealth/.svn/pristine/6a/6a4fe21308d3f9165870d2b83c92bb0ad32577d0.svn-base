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
				
	%> <script type="text/javascript">
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

submitProtoAjaxforAttendence('monthlyAttendanceReport','/hms/hrms/attendance?method=getEmployeeList&departmentId='+departmentId+'');
return ;
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

<form name="monthlyAttendanceReport" method="post" action="">
<div class="titleBg">
<h2>Employee Attendance Card Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>Department</label> <select
	name="<%=DEPARTMENT_ID %>" id="departmentId1"
	validate="Department,string,yes" onblur="displayDepartment(this.value)">
	<option value="0">Select</option>
	<%
	for(MasDepartment masDepartment :masDepartmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>

	<%
	}
%>
</select> <input name="<%=DEPARTMENT_NAME%>" id="departmentId" class="readOnly"
	readonly="readonly" type="text" />
<div id="employeeIdsDiv"><label> Employee Name </label> <select
	name="<%=EMPLOYEE_ID %>">
	<option value="0">Select</option>
</select></div>


<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label><span>*</span> Month</label> <select name="<%=MONTH %>"
	validate="Month,string,yes">
	<option value="0">Select</option>
	<option value="1">January</option>
	<option value="2">February</option>
	<option value="3">March</option>
	<option value="4">April</option>
	<option value="5">May</option>
	<option value="6">June</option>
	<option value="7">July</option>
	<option value="8">August</option>
	<option value="9">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> <label><span>*</span>Year</label> <select name="<%=YEAR %>"
	validate="Year,string,yes"">
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>
	<option value="2014">2014</option>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	<option value="2017">2017</option>
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	<option value="2021">2021</option>
	<option value="2022">2022</option>
	<option value="2023">2023</option>
	<option value="2024">2024</option>
	<option value="2025">2025</option>
	<option value="2026">2026</option>
	<option value="2027">2027</option>
	<option value="2028">2028</option>
	<option value="2029">2029</option>
	<option value="2030">2030</option>

</select>

<div class="clear"></div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="OK"
	onClick="submitForm('monthlyAttendanceReport','attendance?method=printMonthlyAttendanceReport');" />


<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>