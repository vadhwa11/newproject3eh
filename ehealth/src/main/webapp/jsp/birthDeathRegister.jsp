<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language=javascript" src="/hms/jsp/js/proto.js"></script>
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
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
	 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}			
	%>
		serverdate ='<%=date+"/"+month+"/"+year%>'
	</script>
	
<div class="titleBg">
<h2>Birth / Death Registration</h2>
</div>
<form name="BirthDeathRegister" target="_blank" method="post" action="">
<div class="Block">
<label><span>*</span>From Date</label> 
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>" class="date"	readonly="readonly" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.BirthDeathRegister.<%= FROM_DATE%>,event);" />

<label><span>*</span> To Date</label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" class="date" readonly="readonly"	MAXLENGTH="30" validate="toDate,date,no"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.BirthDeathRegister.<%= TO_DATE%>,event);" />

<div class="clear"></div>
<label>Register</label> 

<label >Birth</label>
<input type="radio" class="radioCheckCol1" name="<%=SELECTED_RADIO%>" value="birth" checked="checked" validate="Birth,string,no">

<label>Death</label>
<input type="radio" name="<%=SELECTED_RADIO %>" class="radioCheckCol1" value="death" validate="Death,string,no">
<div class="clear"></div>

<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('BirthDeathRegister','mis?method=showBirthDeathRegister');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>