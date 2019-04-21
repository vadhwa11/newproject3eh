<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");	

%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>


<form name="patientDrugIssueReport" method="post">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<MasDepartment> masDepartList = new ArrayList<MasDepartment>();
if(map.get("masDepartList")!=null)
{
	masDepartList=(List<MasDepartment>)map.get("masDepartList");
}
%>
<div class="titleBg">
<h2>Ward Wise Drug Issue Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input 	type="text" name="fromDate" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.patientDrugIssueReport.fromDate,event);" />
<label><span>*</span> To Date </label> 
<input type="text"	name="toDate" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.patientDrugIssueReport.toDate,true);" />
<div class="clear"></div>
<label><span>*</span> Ward Name</label> <select
	name="ward_name" validate="Ward Name,string,yes" tabindex=1 >
	<option value="0">Select</option>
	<%
	if(masDepartList.size()>0)
	{
		for (MasDepartment masDept : masDepartList) {
	%>
	<option value="<%=masDept.getId()%>"><%=masDept.getDepartmentName()%></option>
	<%
		}
	}					
	%>
</select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('patientDrugIssueReport','/hms/hms/stores?method=printPatientDrugIssueReportDateWise');"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	