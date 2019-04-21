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

<form name="serviceStatement" method="post" action="">
<div class="titleBg">
<h2>Salary Statement</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Emp Code </label> 
<select	name="fromEmpCode" validate="Employee Code,string,yes">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%></option>
<%}%>
</select> 
<label><span>*</span> To Emp Code </label> 
<select name="toEmpCode" validate="Employee Code,string,yes">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%></option>
<%}%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('serviceStatement','payroll?method=printServiceStatementReport');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

