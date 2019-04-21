
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>
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

<script type="text/javascript" language="javaScript">
function check(){
		var SDate = document.generalDietSheetForm.<%= FROM_DATE%>.value;
		var EDate = document.generalDietSheetForm.<%= TO_DATE %>.value;
		var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
		var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
		if(startDate > endDate)
		{
			alert("Please Ensure that the To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
		else
		{
			return true;
		}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
%>
<form name="generalDietSheetForm" method="post" action="">
<div class="titleBg">
<h2>General Diet Sheet</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date</label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" MAXLENGTH="30" validate="Pick a from date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.generalDietSheetForm.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate%>" class="date"
	MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.generalDietSheetForm.<%=TO_DATE%>,true);" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<input name="Submit" id="Submit" type="button" value="submit" class="button"
	onclick="if(check()){submitForm('generalDietSheetForm','/hms/hms/diet?method=printGeneralDietSheet');}" accesskey="a" tabindex=1 />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="division"></div>





