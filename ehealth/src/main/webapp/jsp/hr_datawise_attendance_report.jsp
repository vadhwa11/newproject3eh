<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masEmployeeList")!= null){
				masEmployeeList = (List)map.get("masEmployeeList");
				}				
	%>
	
<script type="text/javascript">
	function checkFromDate(){
		var fDate = document.datawiseAttendanceReport.<%= FROM_DATE%>.value;
		var tDate = document.datawiseAttendanceReport.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(toDate < fromDate)
		{
			alert(" To Date should be greater than From Date.");
			document.datawiseAttendanceReport.<%= FROM_DATE%>.value = "";
			document.datawiseAttendanceReport.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'

</script>

<form name="datawiseAttendanceReport" method="post" action="">
<div class="titleBg">
<h2>Employee Date Wise Attendance Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label class="auto"> Employee Code </label> 
<select	name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no"	onchange="display(this.value);">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :masEmployeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() +"-"+masEmployee.getEmployeeCode()%></option>
<%}%>
</select>
<label class="auto"><span>*</span> From Date</label> 
<input type="text" id="dobId" name="<%=FROM_DATE %>" value="" class="date" readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.datawiseAttendanceReport.<%=FROM_DATE%>,event)" />
<label class="auto"><span>*</span> To Date</label> 
<input type="text" id="dobId" name="<%=TO_DATE %>" value="" class="date" readonly="readonly" validate="To date ,date,yes" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.datawiseAttendanceReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Ok" type="button" class="button" value="OK" onClick="submitForm('datawiseAttendanceReport','attendance?method=printDatawiseAttendanceReport','checkFromDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

