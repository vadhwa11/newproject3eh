<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("empStatusList")!= null){
					empStatusList = (List)map.get("empStatusList");
				}
				
	%>



<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<form name="staffPersonnelDetails" method="post" action="">
<div class="titleBg">
<h2>Staff Personnel Details</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Emp Code </label> 
<select	name="fromEmpCode" validate="Employee Code,string,yes">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>

	<%
	}
%>
</select> 
<label><span>*</span> To Emp Code </label> 
<select name="toEmpCode"	validate="Employee Code,string,yes">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>

	<%
	}
%>
</select>
<div class="clear"></div>
<label><span>*</span> Status </label> 
<select name="empStatus"	validate="Employee Status,string,yes">
	<option value="0">Select</option>
	<%
	for(MasEmpStatus masEmpStatus :empStatusList){
%>
	<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName()%></option>

	<%
	}
%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('staffPersonnelDetails','payroll?method=printStaffPersonnelDetailReport');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

