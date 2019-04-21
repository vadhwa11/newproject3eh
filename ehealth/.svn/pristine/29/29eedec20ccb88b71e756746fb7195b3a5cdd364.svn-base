<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
<%
Box box = HMSUtil.getBox(request);
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
Date toDate  = new Date();
Date fromDate = new Date();

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
serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" target="_blank" method="POST" name="otPendingPatients">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h2>OT Pending Patients</h2>
<div class="Block">
 <label class="medium"> From Date<span>*</span>
		</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="fromDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.otPendingPatients.<%=FROM_DATE%>,event)" />

		<label> To Date<span>*</span>
		</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="toDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.otPendingPatients.<%=TO_DATE%>,event)" />
<div class="clear"></div>			
<input type="button" name="OK" value="PRINT" class="button" onclick="submitForm('otPendingPatients','ot?method=PrintOtPendingPatients','validateFromToDate');">			
</div>

</form>
</body>
</html>

<script>
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.otPendingPatients.fromDate);
	obj2 = eval(document.otPendingPatients.toDate);
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
					//if(!displayAlert("From Date should be smaller than To Date\n"))
						alert("From Date should be smaller than To Date\n");
					//showShadow(obj1);
					return false;
				}
			}
			
		else
		{
			//if(!displayAlert("From Date should not be greater than Current date\n"))
				alert("From Date should not be greater than Current date\n");
			//showShadow(obj1);
			return false;
		}
	
	}
	return true;
}
</script>