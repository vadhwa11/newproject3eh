<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form action=""  method="POST" name="plannedLeaveCommonPool">
<div class="Block">
 <label class="medium"> From Date<span>*</span>
		</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="fromDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.plannedLeaveCommonPool.<%=FROM_DATE%>,event)" />

		<label> To Date<span>*</span>
		</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="toDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.plannedLeaveCommonPool.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="button" id="btnSendToCommonPool"  class="buttonAuto" value="Submit" name="btnSendToCommonPool" onclick="if(checkDate()){if(validateFromToDate()){sendToCommonPool()}}">			
</div>
</form>
</body>
</html>

<script>
function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.plannedLeaveCommonPool.fromDate);
	obj2 = eval(document.plannedLeaveCommonPool.toDate);
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
					    return false;
				}
			
	}
	return true;
}

function checkDate() {
	var selectedText = document.getElementById('fromDateId').value;
	   var dateAry=selectedText.split("/");
	   var dateString=dateAry[2]+"-"+dateAry[1]+"-"+dateAry[0];
	   var now = new Date();
	   now.setHours(0,0,0,0);
	   
	   var selectedDate = new Date(dateString);
	   selectedDate.setHours(0,0,0,0);
	   
	    if (selectedDate < now) {
	     alert("From Date must be Today or Future");
	     return false;
	   }
	    return true;
}

function sendToCommonPool(){
	var fromDate=document.getElementById('fromDateId').value;
	var toDate=document.getElementById('ToDateId').value;
	
	var data = "fromDate="+fromDate+"&toDate="+toDate;
    var url = "opd?method=transferToCommonPool";
    
 	    
  jQuery(function ($) {
    	$.ajax({
			type:"POST",
			url: url+'&'+csrfTokenName+'='+csrfTokenValue,
			data: data,	 							
			cache: false,
			success: function(msg){									 
				if(msg.indexOf("success") != -1){
					
					if(confirm("Successfully transferred all patients to Common Pool !")){
						<%-- submitForm('header','/hms/hms/login?method=logout'); --%>
						
						window.opener.performAction('logout');
						window.close();
						
					}
							
							
			}else{
				alert("There are no Assigned patients to Transfer !");
			}
			},
			error: function(msg)
			{					
				alert("An error has occurred while contacting the server");
				
			}
			
			});
    });  
}
</script>