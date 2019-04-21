<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("hospitalList")!=null){
				hospitalList=(List<MasHospital>)map.get("hospitalList");
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
<form name="employeeList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Employee List Report</h2></div>

    <div class="clear"></div>
        <div class="Block">
	    <div class="clear"></div>
	    
	    
	    <label><span>* </span>Company</label>
    	
     	<select name="<%=HOSPITAL_ID%>"  validate="Company, string,yes" onChange="populateEmployee1(this.value,'departmentWiseProjectCostReport')">
    	<option value="0">select</option>
    	<%for(MasHospital masHospital: hospitalList) { %>
			<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
			
		<%} %>
        </select>
    
         <label>Department</label>
    	
     	<select name="<%=DEPARTMENT_ID%>"  validate="Department,string,no" onChange="populateEmployee1(this.value,'departmentWiseProjectCostReport')">
    	<option value="0">All</option>
    	<%for(MasDepartment masDepartment: departmentList) { %>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
		<%} %>
        </select>

    	<div class="clear"></div>
    	<label>Active Employees</label>
    	<input type="checkbox" name="workingStatus" value="yes">
    	<label>Joining Date Wise</label>
    	<input type="checkbox" name="dateWise" value="yes">
    	
    
    	 </div>
    	
    	<div class="clear"></div>
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('employeeList','/hms/hrms/report?method=printEmployeeListReport');"/>
    	</form>
    	
