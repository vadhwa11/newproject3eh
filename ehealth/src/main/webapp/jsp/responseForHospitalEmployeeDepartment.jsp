<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasEmployeeDepartment> list= new ArrayList<MasEmployeeDepartment>();
if(map.get("employeeDepartmentList") != null){
	list = (List)map.get("employeeDepartmentList");
}
%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
		for (MasEmployeeDepartment masEmployeeDepartment :list) {
%>			
<option value=<%=masEmployeeDepartment.getId()%>><%=masEmployeeDepartment.getEmpDeptName()%></option>
<%} }%>


