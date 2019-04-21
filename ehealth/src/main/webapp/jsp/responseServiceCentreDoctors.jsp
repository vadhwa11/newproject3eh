<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<MasEmployee> empList = new ArrayList<MasEmployee>();
if(map.get("departmentList") !=null){
	departmentList=(List<MasDepartment>)map.get("departmentList");
}
if(map.get("empList") !=null){
	empList=(List<MasEmployee>)map.get("empList");
}
String doctorsDiv = "";
if(map.get("doctorsDiv") != null) {
	doctorsDiv = (String) map.get("doctorsDiv");
}

%>
<div id="testDiv">
	<label class="autoSpace">Service Centre</label> 
	<select id="serviceCentreId" validate="serviceCentre,metachar,no" name="serviceCentreId" onchange="submitProtoAjaxWithDivName('opNominalRegister','/hms/hms/adt?method=getDoctors','doctorsDiv');">
		<option value="">Select</option>
		<% for (MasDepartment dept : departmentList) { %>
			<option value="<%=dept.getId() %>" ><%=dept.getDepartmentName()%></option>
		<% } %>
	</select>
	<% if(doctorsDiv.equals("y")) { %>
		<label class="autoSpace">Doctors </label>
   		<select name="employyeId" id="employyeId" >
			<option value="">Select</option>
			<% for (MasEmployee emp : empList) { %>
				<option value="<%=emp.getId() %>" ><%=emp.getEmployeeName()%></option>
			<% } %>
		</select>
	<% } %>

	<% if(doctorsDiv.equals("nominal")) { %>
<div id="doctorsDiv">	
		<label class="autoSpace">Doctors </label>
		<select name="employeeId" id="employeeId" >
			<option value="0">Select</option>
		</select>
	</div>
	<%}%>
</div>
	