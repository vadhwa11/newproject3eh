<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>


<form name="printhrpayscale" method="post" action="">
<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("employeeList")!=null){
				employeeList=(List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("departmentList")!=null){
				departmentList=(List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("gradeList")!=null){
				gradeList=(List<MasGrade>)map.get("gradeList");
			}
%><div class="titleBg">
<h2>Pay Scale</h2>
</div>
<div class="clear"></div>
<label><span>*</span>From Employee</label> <select name="fromempcode"
	id="empcode1" validate="From Employee,string,yes">
	<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{				
		%>
	<option value="<%= masEmployee.getEmployeeCode() %>"><%=masEmployee.getFirstName()+""+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%></option>

	<%} %>
</select> <label><span>*</span>To Employee</label> <select name="toempcode"
	id="empcode2" validate="To Employee,string,yes">
	<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{				
		%>
	<option value="<%= masEmployee.getEmployeeCode() %>"><%=masEmployee.getFirstName()+""+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%></option>

	<%} %>

</select>
<div class="clear"></div>
<label>grade</label> <select name="gradeID" id="grade"
	validate="Grade,string,no">
	<option value="">Select</option>
	<%

	 			for(MasGrade masGrade:gradeList)
	 			{				
	 		%>
	<option value="<%=masGrade.getId()%>"><%=masGrade.getGradeName() %></option>

	<%} %>

</select>
<div class="clear"></div>
<input type="button" class="button" value="print" name="print"
	onclick="submitForm('printhrpayscale','/hms/hrms/report?method=printpayscale');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	

