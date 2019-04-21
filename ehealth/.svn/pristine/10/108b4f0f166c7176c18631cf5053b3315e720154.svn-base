
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

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


<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<ul>
	<%	if(empList.size() !=0){
	String empName="";
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			
			//Object[] pair = (Object[]) iterator.next();
			MasEmployee masEmp=(MasEmployee)iterator.next();
			if(masEmp.getEmployeeName()!= null){
			      empName=masEmp.getEmployeeName().trim();
			}
			/* if(masEmp.getFirstName()!= null){
		      empName=masEmp.getFirstName().trim();
			}
			if(masEmp.getMiddleName()!= null){
			      empName=empName+" "+masEmp.getMiddleName();
				}
			if(masEmp.getLastName()!= null){
			      empName=empName+" "+masEmp.getLastName();
				} */
			int empId=masEmp.getId();
	
		
%>
	<li style="width: auto;"><%=empName%>[<%=empId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



