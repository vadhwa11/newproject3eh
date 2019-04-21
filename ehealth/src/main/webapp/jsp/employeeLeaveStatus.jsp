<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}
%>
<div class="titleBg">
<h2>Employee Leave Status</h2>
</div>
<div class="Block">
<form name="EmployeeLeaveStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>From PEN </label> 
<select name="pen1" id="pen1">
<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{
		%>
<option value="<%= masEmployee.getId() %>"><%=masEmployee.getPEN()%> 
   - <%=masEmployee.getEmployeeName() %>
	<%-- - <%=masEmployee.getFirstName()%> <%=masEmployee.getMiddleName() %> <%=masEmployee.getLastName() %> --%>
	</option>

	<%} %>
</select>
<div class="titlebg"><label>To PEN </label> <select
	name="pen2" id="pen2">
	<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{
				
		%>
	<option value="<%= masEmployee.getId() %>"><%=masEmployee.getPEN()%>
	 - <%=masEmployee.getEmployeeName() %>
	<%-- -<%=masEmployee.getFirstName()%> <%=masEmployee.getMiddleName() %> <%=masEmployee.getLastName() %> --%>
	</option>

	<%} %>
</select>
<div class="clear"></div>

<label>Year </label> <input type="text" name="year" value="" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" value="Print" class="button" name="Print"
	onclick="submitForm('EmployeeLeaveStatus','/hms/hrms/report?method=printEmployeeLeaveStatus');" />
<div class="clear"></div>
</form>
</div>

<div class="division"></div>

