<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmpCategory> empCategorylist = new ArrayList<MasEmpCategory>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("empCategorylist")!= null){
					empCategorylist = (List)map.get("empCategorylist");
				}				
	%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>

<script type="text/javascript">
	function convertMonthInString(month){
	var pMonth = "" ;
		if(month == 0){
			pMonth = "";
		}else if(month == 1){
			pMonth = "January";
		}else if(month == 2){
			pMonth = "February";
		}else if(month == 3){
			pMonth = "March";
		}else if(month == 4){
			pMonth = "April";
		}else if(month == 5){
			pMonth = "May";
		}else if(month == 6){
			pMonth = "June";
		}else if(month == 7){
			pMonth = "July";
		}else if(month == 8){
			pMonth = "August";
		}else if(month == 9){
			pMonth = "September";
		}else if(month == 10){
			pMonth = "October";
		}else if(month == 11){
			pMonth = "November";
		}else if(month == 12){
			pMonth = "December";
		}
		
		alert(pMonth)
		document.getElementById('monthStringId').value = pMonth;
	}
</script>
<form name="earningAndDeduction" method="post" action="">
<div class="titleBg">
<h2>Earning And Deduction Summary</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Emp Category</label> 
<select	name="<%=EMP_CATEGORY_ID %>" id="empCategoryId"	validate="Employee Code,string,no">
<option value="0">Select</option>
	<%
	for(MasEmpCategory masEmpCategory :empCategorylist){
%>
<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName()%></option>
<%}%>
</select> 
<label>Emp Name </label> 
<select name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no">
<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
<%}%>
</select>
<div class="clear"></div>
<label><span>*</span> Month</label> <select name="<%=MONTH %>"
	validate="Month,string,yes" onchange="convertMonthInString(this.value)">
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
</select> 
<input type="hidden" name="monthString" id="monthStringId" value="">
<label><span>*</span> Year</label>
<select name="<%=YEAR %>" validate="Year,string,yes"">
	<option value="0">Select</option>
	<option value="2001">2001</option>
	<option value="2002">2002</option>
	<option value="2003">2003</option>
	<option value="2004">2004</option>
	<option value="2005">2005</option>
	<option value="2006">2006</option>
	<option value="2007">2007</option>
	<option value="2008">2008</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
</select>



<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onclick="submitForm('earningAndDeduction','payroll?method=printEarningAndDeductionReport');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

