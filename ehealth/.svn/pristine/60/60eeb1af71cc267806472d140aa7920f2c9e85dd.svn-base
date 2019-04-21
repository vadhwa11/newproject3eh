<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.MasEmployee"%>

<form name="searchLeaveBalance" action="" method="post">
<div class="titleBg">
<h2>Search Leave Details</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="search"><label><span>*</span> Employee Name</label> <select
	name="<%=EMP_NAME%>" class="select3"
	validate='Employee name,nothing,yes'>
	<option value="">Select</option>
	<%
 			        Map map = (Map)request.getAttribute("map");
 			        List employeeList = (List)map.get("employeeList");
 			        String employeeName = "";
 			        for(Iterator iter = employeeList.iterator(); iter.hasNext();)
 			        {
 			        	MasEmployee user = (MasEmployee)iter.next();	
 			        	employeeName=user.getFirstName()+" "+user.getLastName();
 			%>
	<option value="<%=user.getId()%>"><%=employeeName%><%="-"%><%=user.getEmployeeCode()%></option>
	<%}%>
</select></div></div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onClick="submitForm('searchLeaveBalance','leave?method=viewLeaveBalance')" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

