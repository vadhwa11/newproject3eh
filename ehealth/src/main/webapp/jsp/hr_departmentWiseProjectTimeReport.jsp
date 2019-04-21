<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>


<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="org.apache.tools.ant.Project"%>


<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MstrProject> projectList = new ArrayList<MstrProject>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("projectList")!=null){
				projectList=(List<MstrProject>)map.get("projectList");
			}
			if(map.get("employeeList")!=null){
				employeeList=(List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("departmentList")!=null){
				departmentList=(List<MasDepartment>)map.get("departmentList");
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
<form name="departmentWiseProjectTimeReport" method="post" action="">
<div class="titleBg">
<h2>Department wise Project Time Report</h2></div>

    <div class="clear"></div>
        <div class="Block">
	    <div class="clear"></div>
    
    	<label><span>*</span> Type</label>
     	<select name="billable"  validate="Billable Type,string,yes">
    	<option value="0">Select</option>
    	<option value="y">Billable</option>
    	<option value="n">Non-Billable</option>
        </select>
        
        <label><span>*</span> Project</label>
    	
     	<select name="projectId"  validate="Project,string,yes">
    	<option value="0">Select</option>
    	<%for(MstrProject mstrProject : projectList) { %>
			<option value="<%=mstrProject.getId()%>"><%=mstrProject.getPrjName()%></option>
		<%} %>
        </select>
        
         <label>Department</label>
    	
     	<select name="<%=DEPARTMENT_ID%>"  validate="Project,string,no" onChange="populateEmployee1(this.value,'departmentWiseProjectTimeReport')">
    	<option value="0">All</option>
    	<%for(MasDepartment masDepartment: departmentList) { %>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
		<%} %>
        </select>

    	<div class="clear"></div>
    	 <label> Employee</label>
    	
     	<select name="<%=EMPLOYEE_ID %>"   validate="Project,string,no">
    	<option value="0">All</option>
    	<%for(MasEmployee masEmployee: employeeList) { %>
			<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"---"+masEmployee.getEmployeeCode()%></option>
		<%} %>
        </select>
      
      	<label><span>*</span> From Date</label>
    	<input name="<%=FROM_DATE%>" id="fromDateForApply" type="text" readonly validate='From Date,date,yes' value="" class="date" />
   		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calFromDate" 
   			onclick="javascript:setdate('',document.departmentWiseProjectTimeReport.<%=FROM_DATE%>,event)"  />
		<label><span>*</span> To Date</label>
   		<input type="text" name="<%=TO_DATE%>" id="toDateForApply"  readonly   validate='To Date,date,yes'  
   			value=""  class="date" />
    	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate"
    		onclick="javascript:setdate('',document.departmentWiseProjectTimeReport.<%=TO_DATE%>,event)" />
    	
    	 <div class="clear"></div>
    	 </div>
    	 
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
    	<div class="clear"></div>
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('departmentWiseProjectTimeReport','/hms/hrms/report?method=printDepartmentWiseProjectTimeReport');"/>
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
    	
