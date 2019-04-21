<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
String hin_no="";
if(map.get("hin_no")!=null){
	hin_no=(String)map.get("hin_no");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
%>
<script>
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

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script lang="javascript" src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script lang="javascript"  src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="donorAssessment1" method="post">
<label>From Date</label>
	<input type="text"	tabindex="1" name="fromDate" value="<%=currentDate %>" class="date"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.donorAssessment1.fromDate,event)" />
<div class="clear"></div>
<label>To Date</label>
	<input type="text"	tabindex="1" name="toDate" value="<%=currentDate %>" class="date"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
	
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.donorAssessment1.toDate,event)" />
		<div class="clear"></div>
		<div class="clear"></div>
		<input type="hidden" name="hin_no" id="hin_no" value="<%=hin_no %>" />
		
<input type="button" value="Print" onclick="submitForm('donorAssessment1','enquiry?method=printPatientEpfReport&flag=ehr')" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>