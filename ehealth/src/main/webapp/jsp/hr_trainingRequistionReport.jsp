<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrMasTrainingStatus> trainingStatusList = new ArrayList<HrMasTrainingStatus>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("trainingStatusList")!= null){
					trainingStatusList = (List)map.get("trainingStatusList");
				}
				
	%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.HrMasTrainingStatus"%>

<script type="text/javascript">
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

<%@page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@page import="jkt.hrms.masters.business.HrMasInstructor"%>
<form name="trainingRequistionReport" method="post" action="">
<div class="titleBg">
<h2>Training Requistion Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Department Code</label> <select
	id="deptId" name="<%=DEPARTMENT_ID %>"
	validate="Department Name,string,no"
	onChange="populateEmployee(this.value,'trainingRequistionReport')">
	<option value="0">Select</option>
	<%
	for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>

	<%
	}
%>
</select> <label>Employee </label> <select id="employeeId"
	name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>

	<%
	}
%>
</select> <script type="text/javascript">
<%
int counter=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
if(masEmployee.getDepartment() != null){
if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment.getId()%>;
empArr[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script>

<div class="clear"></div>
<label><span>*</span>Status </label> <select name="reqStatus"
	validate="Status,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasTrainingStatus hrMasTrainingStatus :trainingStatusList){
%>
	<option value="<%=hrMasTrainingStatus.getId() %>"><%=hrMasTrainingStatus.getTrainingStatusDescription()%></option>

	<%
	}
%>
</select>

<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Print" type="button" class="button" value="Print"
	onclick="submitForm('trainingRequistionReport','training?method=printTrainingRequistionReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

