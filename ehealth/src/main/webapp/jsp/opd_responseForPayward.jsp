<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasDepartment> list = new   ArrayList<MasDepartment>();
if(map.get("wardDepartment") != null)
{
	list=(List<MasDepartment>)map.get("wardDepartment");
}
%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
		for (MasDepartment ward :list) {
%>				
<option value=<%=ward.getId()%>><%=ward.getDepartmentName()%></option>
<%} 
}%>

