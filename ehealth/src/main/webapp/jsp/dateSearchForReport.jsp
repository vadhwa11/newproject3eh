
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<META content="Evrsoft First Page" name=GENERATOR><SCRIPT
	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT> <SCRIPT language=javascript
	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> <SCRIPT>
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
		</SCRIPT>
<LINK href="/hms/jsp/css/hms_style.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
	    String flag = "";
		if (map.get("flag") != null) {
			flag = (String)map.get("flag");
		}
	
		String url = "";
		String title = "";
		if(flag.equals("accStatusIP")){
			url = "billing?method=printAccountStatusOfIPReport";
			title = "Account Status Of IP";
		}else if(flag.equals("cashCollIP")){
			url = "billing?method=printCashCollectionIPChargeWiseReport";
			title = "Cash Collection IP Charge Wise";
		}else{
			title = "Cash Collection Report";
			url = "billing?method=printCashCollectionReport";
		}
	
	%> <script type="text/javascript">
function check(){
	var currentdate=new Date();
	var SDate = document.search.<%=FROM_DATE%>.value;
	var EDate = document.search.<%=TO_DATE %>.value;


	var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(endDate>currentdate)
		{
		alert("Please ensure that the To Date is less than or equal to the Current Date.");
		document.calldate.next_day.focus();
		return false;
		}
	else if(startDate > endDate)
	{
	alert("Please ensure that the To Date is greater than or equal to the From Date.");
	document.calldate.next_day.focus();
	return false;
	}
	else
	{
	return true;
	}
	}
</script>
<form name="search" method="post" action="">
<div class="titleBg">
<h2><%=title %></h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date</label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=date%>"
	validate="From Date,date,yes" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.search.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> <input type="text"
	name="<%=TO_DATE%>" value="<%=date %>" validate="To Date,date,yes"
	class="date" MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=TO_DATE%>',document.search.<%=TO_DATE%>,event);" />

<div class="clear"></div>

<input type="hidden" name="flag" value="<%=flag %>" validate="flag,metachar,no"/>
<div class="clear"></div>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="if( check()){submitForm('search','<%=url %>')};" accesskey="g" tabindex=1 />
<input type="reset" name="clear" id="clearbutton" value="Clear"
	class="button" " accesskey="a" tabindex=1 />
</div>	

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
