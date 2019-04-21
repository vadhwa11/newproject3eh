<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
	%>
<div class="titleBg">
<h2>Month Wise MLC Cases</h2>
</div>
<div class="clear"></div>

<form name="mlcCaseReport" target="_blank" method="post" action="">

<div class="Block">
<label>From Date</label> 
<input type="text" id="mlcDateId" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.mlcCaseReport.<%=FROM_DATE%>,event)" />

<label>To Date</label> 
<input type="text" id="mlcDateId" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.mlcCaseReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('mlcCaseReport','adt?method=showMonthlyMlcCaseReport','validateFromToDate');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript" language="javascript">
	function validateFromToDate(){
		var nowDate=new Date();
		obj1 = eval(document.mlcCaseReport.fromDate)
		obj2 = eval(document.mlcCaseReport.toDate)
		if(obj1.value != "" && obj2.value != "")
		{
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			if(validFromDate<=nowDate)
				{
					if(validFromDate > validToDate)
					{
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}
				
			else
				{
				alert("From Date should not be greater than Current date\n");
				return false;
				}
		
		}
		return true;
	}
</script>



