<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasState"%>
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
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");

List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasState> stateList = new ArrayList<MasState>();

if (request.getAttribute("map") != null) 
{
	map = (Map) request.getAttribute("map");
}
if(map.get("employeeList")!=null)
{
		employeeList = (List<MasEmployee>)map.get("employeeList");
}
if(map.get("stateList")!=null)
{
	stateList = (List<MasState>)map.get("stateList");
}
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

%>


<div class="titleBg">
<h2>Patient Statistics Report</h2>
</div>
<div class="clear"></div>
<form name="opdRegisterBelowAge" target="_blank" method="post" action="">

<div class="Block">
<label>From Date</label>
<input type="text" id="dobId" name="<%=FROM_DATE %>" tabindex="13"	value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img id="" src="/hms/jsp/images/cal.gif"width="16" height="16" border="0"onclick="setdate('<%=currentDate %>',document.opdRegisterBelowAge.<%=FROM_DATE%>,event)" validate="Pick a date"  tabindex="14" />
<label>To Date</label>
<input type="text" id="dobId" name="<%=TO_DATE %>" tabindex="13" value="<%=currentDate %>" class="date" readonly="readonly"	 MAXLENGTH="30" />
<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('<%=currentDate %>',document.opdRegisterBelowAge.<%=TO_DATE%>,event)" validate="Pick a date"  tabindex="14" />	

<label><span>* </span>Gender</label>
<select name="gender" id="genderId" validate="Gender,string,yes">
<option value="">Select</option>
<option value="Male">Male</option>
<option value="Female">Female</option>
</select>
<div class="clear"></div>
<label><span>* </span>Report Type</label>
<select name="reportType" id="reportTypeId"  validate="Report Type,string,yes">
<option value="">Select</option>
<option value="na">New Admission</option>
<option value="nr">New Registration</option>
<option value="nv">New Visit</option>
</select>
<label><span>* </span>Condition</label>
<select name="condition" id="condition"  validate="Condition,string,yes">
<option value="">Select</option>
<option value="Below 18 years">Below 18 years</option>
<option value="Above 18 Years">Above 18 Years</option>

</select>


</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdRegisterBelowAge','registration?method=generatePatientStatReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	