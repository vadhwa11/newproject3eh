<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<EmpScMapping>list= new ArrayList<EmpScMapping>();
if(map.get("doctorList") != null){
	list = (List)map.get("doctorList");
}
%>
<option value='0'>Select</option>
<%	if(list.size() !=0){
		for (EmpScMapping empsc :list) {
			MasEmployee	masEmployee=empsc.getEmployee();
			String name=masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null && !masEmployee.getMiddleName().equals(""))
				name=name+" "+masEmployee.getMiddleName();
			if(masEmployee.getLastName()!=null && !masEmployee.getLastName().equals(""))
				name=name+" "+masEmployee.getLastName();	
				
%>				
<option value=<%=masEmployee.getId()%>><%=name%></option>
<%} }%>

