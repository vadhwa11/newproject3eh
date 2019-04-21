<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}				
	%>
<form name="incrementMonthStatement" method="post" action="">
<div class="titleBg">
<h2>Increment Month Statement</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Month</label> <select
	name="<%=MONTH %>" validate="Month,string,yes"">
	<option value="0">Select</option>
	<option value="1">January</option>
	<option value="2">February</option>
	<option value="3">March</option>
	<option value="4">April</option>
	<option value="5">May</option>
	<option value="6">June</option>
	<option value="7">July</option>
	<option value="8">August</option>
	<option value="9">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> <label><span>*</span> From Emp Code </label> <select name="fromEmpCode"
	validate="Employee Code,string,yes">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%></option>

	<%
	}
%>
</select>
<div class="clear"></div>
<label><span>*</span> To Emp Code </label> <select name="toEmpCode"
	validate="Employee Code,string,yes">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%></option>

	<%
	}
%>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('incrementMonthStatement','payroll?method=printIncrementMonthStatementReport');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

