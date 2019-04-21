<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Iterator"%>


<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<Object[]> empScMappingList = new ArrayList<Object[]>();
if(map.get("empScMappingList") !=null){
	empScMappingList=(List<Object[]>)map.get("empScMappingList");
}


%>

<div id="doctorsDiv">

<label class="autoSpace">Doctors</label>
		<select name="employeeId" id="employeeId" >
	<option value="0">Select</option>
		<% for(Object[] empScMapping : empScMappingList){ %>
			<option value="<%=empScMapping[0] %>" ><%=empScMapping[1]%></option>
		<% } %>
	</select>

</div>
<div class="clear"></div>
