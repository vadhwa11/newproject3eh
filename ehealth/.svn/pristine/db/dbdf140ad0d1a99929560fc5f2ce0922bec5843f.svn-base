<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div class="titleBg">
<h2>Employee Leave Card</h2>
</div>
<form name="printhrEmployee" method="post" action="">
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}


%> <select name="empId" id="empId">
	<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{
				
		%>
	<option value="<%= masEmployee.getId() %>"><%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName() %> <%=masEmployee.getLastName() %></option>

	<%} %>
</select> <input type="button" value="print" name="print"
	onclick="submitForm('printhrEmployee','/hms/hrms/report?method=printEmployeeExpirience');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
