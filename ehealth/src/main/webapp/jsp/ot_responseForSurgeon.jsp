
<%@page import="java.util.*"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List empList= new ArrayList();
if(map.get("empList") != null){
	empList = (List)map.get("empList");
}
%>


<%@page import="java.util.Iterator"%>


<%@page import="jkt.hms.masters.business.MasEmployee"%>
<ul>
	<%	if(empList.size() !=0){
	
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			
			MasEmployee masEmployee=(MasEmployee)iterator.next();
			 String empName=masEmployee.getFirstName()+" "+masEmployee.getLastName();
			 String empCode=masEmployee.getEmployeeCode();
		    int empId=masEmployee.getId();

	
		
%>
	<li style="width: auto;"><%=empName%>[<%=empId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



