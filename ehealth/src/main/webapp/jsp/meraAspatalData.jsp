
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" 	src="/hms/jsp/js/proto.js"></script>

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

<script type="text/javascript">
function checkk()
{
var SDate = document.meraAspatalDataExcel.<%= FROM_DATE%>.value;
var EDate = document.meraAspatalDataExcel.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
	if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
	getShadowWithObj(document.calldate.next_day);

return false;
}
}
		

</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
%>
<div class="titleBg">
<h2>Mera Aspatal Data</h2>
</div>
<form name="meraAspatalDataExcel" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.meraAspatalDataExcel.<%=FROM_DATE%>,event);" />

<label><span>*</span> To Date </label> 
<input type="text"	class="date" name="<%=TO_DATE%>" value="<%=currentDate%>"	validate="To Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.meraAspatalDataExcel.<%=TO_DATE%>,event);" />
<div class="clear"></div>



<input type="button" name="add" id="addbutton" value="Generate Report"	class="buttonBig"	onClick="submitForm('meraAspatalDataExcel','registration?method=generateMeraApatalData','checkk()');"	accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Reset"	class="buttonBig"	onClick="submitFormForButton('meraAspatalDataExcel','registration?method=showMeraApatalDataJsp');"	accesskey="a" tabindex=1 />
	
</div>
</form>