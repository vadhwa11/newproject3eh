<%@page import="jkt.hms.util.*"%>
<%@ page import="java.util.*"%>
<%String resumeId = request.getParameter(RequestConstants.RESUMEID); 
  String name = request.getParameter("name");
  
%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />




<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<title>Appointment Letter For <%=name%></title>
<body>
<div class="Block">
<form name="appLetter" method="post">
<div class="clear"></div>
<label><span>* </span>Issue Date</label> <input id="issueDate"
	name="issueDate" class="date" readonly="readonly" type="text"
	validate="Issue Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0"
	onClick="javascript:setdate('',document.appLetter.issueDate,event)"
	validate="Pick a date" />
<div class="clear"></div>
<label>Medical Fitness</label><input id="med" type="checkbox"
	class="radioCheck" />
<div class="clear"></div>
<label>Submission Documents</label><input id="doc" type="checkbox"
	class="radioCheck" />

<div class="paddingTop15"></div>
<input type="button" class="button" value="Generate"
	onclick="checkAndSubmit()">	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</body>
<script>
document.getElementById('issueDate').value = serverdate;
function checkAndSubmit()
{
 issueDate = document.getElementById('issueDate').value;	
 message = "";
 flag = true;
 if(!document.getElementById('med').checked)
 {
  message = "Candidate Not Medically fit \n";
  flag= false;
 }
 if(!document.getElementById('doc').checked)
 {
  message = message + "Documents Not submitted";
  flag=false;
 }
 
 if(flag)
 {
  location.href='/hms/hrms/resume?method=generateJoiningLetter&letterType=joiningLetter&<%=RequestConstants.RESUMEID%>=<%=resumeId%>&issueDate=' + issueDate;
  
 }
 else
 {
  alert(message);
  
 }
 
 
 
}
</script>