<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  shailesh
 * Create Date: 14nd mar,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


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

<div id="employeeIdsDiv"><label> Employee Code </label> <select
	name="<%=EMPLOYEE_ID %>">
	<%    
			
   			for(MasEmployee masEmployee:employeeList) {
   				
   			
   %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeCode()%>
	- <%=masEmployee.getFirstName()%> <%=masEmployee.getMiddleName()%> <%=masEmployee.getLastName()%></option>
	<%	
}
%>
</select></div>