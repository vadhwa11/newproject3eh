<%@page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("hrMasFinancialYearList")!= null){
					hrMasFinancialYearList = (List)map.get("hrMasFinancialYearList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				
	%>


<form name="form3A" method="post" action="" >
<div class="titleBg"> <h2>Form 3A</h2></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Financial Year </label>
<select name="invYear" validate="Financial Year,string,yes"  >
<option value="">Select</option>
<%
	for(HrMasFinancialYear hrMasFinancialYear :hrMasFinancialYearList){
%>
<option value="<%=hrMasFinancialYear.getYearDescription() %>"><%=hrMasFinancialYear.getFinancialYear()%></option>
			
<%
	}
%>
</select>

<label><span>*</span>Employee </label>
<select name="empcode" validate="Employee,string,yes"  >
<option value="">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+" --- "+masEmployee.getEmployeeCode()%></option>
			
<%
	}
%>
</select>
<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('form3A','report?method=printForm3A');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

