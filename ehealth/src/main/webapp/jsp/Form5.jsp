<%@page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("hrMasFinancialYearList")!= null){
					hrMasFinancialYearList = (List)map.get("hrMasFinancialYearList");
				}
				
	%>


<form name="form5" method="post" action="" >
<div class="titleBg"> <h2>Form 5</h2></div>
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
<label><span>*</span> Month</label>
<select  name="month" validate="Month,string,yes" ">
<option value="">Select</option>
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
</select>


<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('form5','report?method=printForm5');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

