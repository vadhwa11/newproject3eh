<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hrms.masters.business.MasEmployeeType"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<div class="Block">
<form name="EmployeeTypeReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployeeType> employeeTypeList = new ArrayList<MasEmployeeType>();
if(map.get("employeeTypeList")!=null){
	employeeTypeList=(List<MasEmployeeType>)map.get("employeeTypeList");
}
%><div class="titleBg">
<h2>Employee Type Wise Report</h2>
</div>

<div class="clear"></div>
<label><span>*</span>Employee Type</label> <select name="empType"
	id="empType" validate="Employee Type,string,yes">
	<option value="">Select</option>
	<%
    	
			for(MasEmployeeType masEmployeeType:employeeTypeList)
			{				
		%>
	<option value="<%= masEmployeeType.getId() %>"><%= masEmployeeType.getEmpType()%></option>

	<%} %>
</select>

<div class="clear"></div>
<input type="button" class="button" value="print" name="print"
	onclick="submitForm('EmployeeTypeReport','/hms/hrms/report?method=printEmployeeTypeWiseReport');" />
</form>
</div>