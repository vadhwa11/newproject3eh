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


<form name="form6A2" method="post" action="" >
<div class="titleBg"> <h2>Form 6a(2)</h2></div>
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
<div class="clear"></div>
</div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('form6A2','report?method=printForm6a2');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

