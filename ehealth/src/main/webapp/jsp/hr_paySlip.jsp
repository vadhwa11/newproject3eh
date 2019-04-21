<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<HrMasLocation> locationList = new ArrayList<HrMasLocation>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("locationList")!= null){
					locationList = (List)map.get("locationList");
				}
				
	%>

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
		
		document.getElementById('monthStringId').value = pMonth;
	}
	


</script>


<%@page import="jkt.hrms.masters.business.HrMasLocation"%>
<form name="paySlip" method="post" action="">
<div class="titleBg">
<h2>Pay Slip</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Employee </label> 
<select	name="fromEmpId" validate="Employee Code,string,yes">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>-<%=masEmployee.getEmployeeCode()%></option>
<%	}%>
</select>
<div class="clear"></div>
<label><span>*</span> Month</label> 
<select name="<%=MONTH %>" validate="Month,string,yes" onchange="convertMonthInString(this.value)">
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
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>
	<option value="2014">2014</option>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	<option value="2017">2017</option>
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	<option value="2021">2021</option>
	<option value="2022">2022</option>
	<option value="2023">2023</option>
	<option value="2024">2024</option>
	<option value="2025">2025</option>
	<option value="2026">2026</option>
	<option value="2027">2027</option>
	<option value="2028">2028</option>
	<option value="2029">2029</option>
	<option value="2030">2030</option>

</select>


<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK"	onclick="submitForm('paySlip','payroll?method=printPaySlipReport');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

