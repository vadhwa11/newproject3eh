<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<div class="Block">

<form name="EmpExpSummary" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}


%><div class="titleBg">
<h2>Employee Experience Summary</h2>
</div>

<div class="clear"></div>
<label>From Employee</label> <select name="frmEmpCode" id="frmEmpCode">
	<option value="">Select</option>
	<%
    		Collections.sort(employeeList, new EmployeeComparator());
			for(MasEmployee masEmployee:employeeList)
			{				
				String fname=masEmployee.getFirstName();
				String lname= masEmployee.getLastName();
				String mname= masEmployee.getMiddleName();
				if(fname==null)
				{
					fname="";
				}
				if(lname==null)
				{
					lname="";
				}
				if(mname==null)
				{
					mname="";
				}
		%>
	<option value="<%= masEmployee.getId() %>"><%=fname%> <%=mname %>
	<%=lname %>-<%=masEmployee.getEmployeeCode()%></option>

	<%} %>
</select> <label>To Employee</label> <select name="toEmpCode" id="toEmpCode">
	<option value="">Select</option>
	<%
			for(MasEmployee masEmployee:employeeList)
			{				
				String fname=masEmployee.getFirstName();
				String lname= masEmployee.getLastName();
				String mname= masEmployee.getMiddleName();
				if(fname==null)
				{
					fname="";
				}
				if(lname==null)
				{
					lname="";
				}
				if(mname==null)
				{
					mname="";
				}
		%>
	<option value="<%= masEmployee.getId() %>"><%=fname%> <%=mname %>
	<%=lname %>-<%=masEmployee.getEmployeeCode()%></option>

	<%} %>
</select>
<div class="clear"></div>
<input type="button" class="button" value="print" name="print"
	onclick="submitForm('EmpExpSummary','/hms/hrms/report?method=printEmpExpSummary');" />
</form>
</div>