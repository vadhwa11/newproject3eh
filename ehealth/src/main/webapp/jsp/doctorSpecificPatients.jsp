<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Patients</title>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
</head>
<body>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> patientList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Object[]>)map.get("patientList");
	}

%>
<div class="Block">
	<% 
	if(null !=patientList && !patientList.isEmpty()){
		
	%>
<h2>My Patients</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>  
	  
<table id="" width="100%" border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #C0C0C0;">
 <thead>
		<tr>
			<th>UHID</th>
			<th>Patient Name</th>
			<th>Token No</th>
		</tr>
	
	<% for(Object[] objects : patientList){ %>
	<tr>
		<td ><%=objects[0]%></td>
		<td ><%=objects[1]+""+((objects[2]!=null)?objects[2]:"")+""+((objects[3]!=null)?objects[3]:"")%></td>
		<td ><%=objects[4]%></td>
		</tr>
		<% } %>
	</thead>
	</table>
	<% }else{%>
			<h2>Record Not found</h2>
	<%} %>		
		
</div>
</body>
</html>









