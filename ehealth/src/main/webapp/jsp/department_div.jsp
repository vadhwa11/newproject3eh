<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	departmentList = (List<MasDepartment>)map.get("departmentList");
}

/* String jspParam="";
if(map.get("jspParam")!=null){
	jspParam=(String)map.get("jspParam");
} */


System.out.println("departmentList jsp "+departmentList.size());

%>
<%-- <select <%=jspParam %>> --%>
<option value="0">Select</option>
<% 
for(MasDepartment masDepartment : departmentList)
		{
%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%
		} 
%>
<!-- </select> -->
