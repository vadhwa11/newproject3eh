<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<form name="printhrEmployee" method="post" action="">
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
<h2>Employee Leave Card</h2>
</div>
<div class="Block">
<div class="clear"></div>
<label>Employee</label> <select name="empcode" id="empcode">
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

</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="print" name="print"
	onclick="submitForm('printhrEmployee','/hms/hrms/report?method=printEmployeeLeaveCard');" />
<div class="clear"></div>
<div class="division"></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>