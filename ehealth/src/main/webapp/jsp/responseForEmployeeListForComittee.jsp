<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script> <script
	type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}

	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList=(List<MasEmployee>)map.get("employeeList");
	}
%>

	<%    
   			for(MasEmployee masEmployee:employeeList) {
   %>
	<option value="<%=masEmployee.getId()%>">
	<%=(masEmployee.getFirstName()!=null)?masEmployee.getFirstName():""%> <%=(masEmployee.getMiddleName()!=null)?masEmployee.getMiddleName():""%>
	<%=(masEmployee.getLastName()!=null)?masEmployee.getLastName():""%></option>
	<%	
}
%>