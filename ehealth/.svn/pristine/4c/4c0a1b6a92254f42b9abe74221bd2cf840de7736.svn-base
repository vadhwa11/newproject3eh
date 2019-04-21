<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>





<%
			Map<String,Object> map =new HashMap<String,Object>();
	//		List<MstrProjectrole> roleList = new ArrayList<MstrProjectrole>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			
			if(map.get("employeeList")!=null){
				employeeList=(List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("departmentList")!=null){
				departmentList=(List<MasDepartment>)map.get("departmentList");
			}
			
%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

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
<form name="employeeWiseTaskList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Employee Wise Task Report</h2></div>

    <div class="clear"></div>
        <div class="Block">
	    <div class="clear"></div>
	  
         <label><span>* </span>Department</label>
    	
     	<select name="<%=DEPARTMENT_ID%>"  validate="Project,string,no" onChange="populateEmployee1(this.value,'employeeWiseTaskList')">
    	<option value="0">All</option>
    	<%for(MasDepartment masDepartment: departmentList) { %>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
		<%} %>
        </select>
  <label><span>* </span>Employee</label>
    	
     	<select name="<%=EMPLOYEE_ID %>"  validate="Project,string,no" >
    	<option value="0">All</option>
    	<%for(MasEmployee masEmployee: employeeList) { %>
			<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
		<%} %>
        </select>
    
    	<div class="clear"></div>
    	<label>Woking</label>
    	<input type="checkbox" name="empstatus" value="yes">
    	
    
    	 </div>
 <script>    	 
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
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('employeeWiseTaskList','/hms/hrms/report?method=printEmployeeWiseTaskListReport');"/>
    	</form>
    	
