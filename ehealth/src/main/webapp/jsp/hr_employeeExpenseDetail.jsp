<%@page import="java.util.*"%>
<%@ page import = "static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>

<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<form name="employeeExpensesDetail" method="post" action="">

<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MstrProject> projectList = new ArrayList<MstrProject>();
			
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("projectList")!=null){
				projectList=(List<MstrProject>)map.get("projectList");
			}
			if(map.get("departmentList")!=null){
				departmentList=(List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("employeeList")!=null){
				employeeList=(List<MasEmployee>)map.get("employeeList");
			}
%>
<script type="text/javascript">
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
	<h2>Employee Expenses </h2></div>
	<div class="Block">
    <div class="clear"></div>
    	<label><span>*</span> Project</label>
    	
     	<select name="projectId"  validate="Project,string,yes">
    	<option value="">Select</option>
    	<%for(MstrProject mstrProject : projectList) { %>
			<option value="<%=mstrProject.getId()%>"><%=mstrProject.getPrjName()%></option>
		<%} %>
        </select>

    	
        <label> Department</label>
     	<select name="<%=DEPARTMENT_ID%>"  validate="Department,string,no" onChange="populateEmployee1(this.value,'employeeExpensesDetail')">
    	<option value="">All</option>
    	<%for(MasDepartment masDepartment : departmentList) { %>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
		<%} %>
        </select>
        <label> Employee</label>
     	<select name="<%=EMPLOYEE_ID%>"  validate="Employee,string,no">
    	<option value="">All</option>
    	<%for(MasEmployee masEmployee: employeeList) { %>
			<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
		<%} %>
        </select>

    	<div class="clear"></div>
      
      	<label><span>*</span> From Date</label>
    	<input name="<%=FROM_DATE%>" id="fromDateForApply" type="text" readonly validate='From Date,date,yes' value="" class="date" />
   		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calFromDate" 
   			onclick="javascript:setdate('',document.employeeExpensesDetail.<%=FROM_DATE%>,event)"  />

		<label><span>*</span> To Date</label>
   		<input type="text" name="<%=TO_DATE%>" id="toDateForApply"  readonly   validate='To Date,date,yes'  
   			value=""  class="date" />
    	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate"
    		onclick="javascript:setdate('',document.employeeExpensesDetail.<%=TO_DATE%>,event)" />
    	
    	 <div class="clear"></div>
    	  
    	 <script type="text/javascript">
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
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script> 
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('employeeExpensesDetail','/hms/hrms/etravel?method=exportToExcelEmployeeExpenseReport');"/>
    	</div>
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
    	
