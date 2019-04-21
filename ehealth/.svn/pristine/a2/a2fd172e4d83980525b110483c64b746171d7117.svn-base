<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>EHA Hospital Management System</title>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />



</head>
<body>
<form name="header" method="post"><!--header Starts-->
<div class="header"><!---for header text--->
<div class="hdText">
<div class="hdTextFix">&nbsp; <%	
String userName ="";
if(session.getAttribute("userName")!=null){
userName = (String)session.getAttribute("userName");	
}
String deptName ="";
if(session.getAttribute("deptName")!=null){
	deptName = (String)session.getAttribute("deptName");
%> <%=userName%> | Dept: <%=deptName %> <%} %>
</div>

<span class="paddLeft30"> <script type="text/javascript">
/*
var currentDate = new Date()
var day = currentDate.getDate()
var month = currentDate.getMonth()
var year = currentDate.getFullYear()
document.write(day + "/" + month + "/" + year)	
*/
function getCalendarDate()
{
var months = new Array(13);
months[0]  = "January";
months[1]  = "February";
months[2]  = "March";
months[3]  = "April";
months[4]  = "May";
months[5]  = "June";
months[6]  = "July";
months[7]  = "August";
months[8]  = "September";
months[9]  = "October";
months[10] = "November";
months[11] = "December";
var now         = new Date();
var monthnumber = now.getMonth();
var monthname   = months[monthnumber];
var monthday    = now.getDate();
var year        = now.getYear();
if(year < 2000) { year = year + 1900; }
var dateString = monthname + ' ' + monthday + ', ' + year;
return dateString;
} // function getCalendarDate()								

var calendarDate = getCalendarDate();
document.write(calendarDate);	
</script> </span> <span class="paddLeft30"> <script type="text/javascript">
var currentTime = new Date()
var hours = currentTime.getHours()
var minutes = currentTime.getMinutes()

if (minutes < 10)
minutes = "0" + minutes

var suffix = "AM";
if (hours >= 12) {
suffix = "PM";
hours = hours - 12;
}
if (hours == 0) {
hours = 12;
}

document.write(hours + ":" + minutes + " " + suffix)
//-->
</script> </span> <%		if (session != null && session.getAttribute("users") != null) { %> <span
	class=paddLeft280><a href="/hms/hms/login?method=homePage">Home</a></span>
<img src="/hms/jsp/images/iconHome.gif" alt="Home" /> <%} %> <%
if(!userName.equals("")){
%> <a href="#" name="logout"
	onclick="submitForm('header','/hms/hms/login?method=logout')">Logout</a>
<%} %> </span> <!---header text ends---> <%		if (session != null && session.getAttribute("users") == null) { %>

<%} %>
</div>
<!--header Ends--></div>
<div class="clear"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>