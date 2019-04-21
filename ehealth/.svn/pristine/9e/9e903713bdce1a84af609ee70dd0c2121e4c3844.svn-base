<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
	Map<String, Object> utilMap = new HashMap<String, Object>();	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
%>
<form name="drugForm" method="post" action="">
<div class="titleBg">
<h2>Drug Expiry Report</h2>
</div>
<div class="Block">
<label><span>*</span> Expiry Date as on</label> 
<input type="text"	name="<%=FROM_DATE%>" value="<%=currentDate%>" class="textbox_date"	MAXLENGTH="30" validate="Pick a Expiry Date,date,yes" readonly="readonly" /> 
<a href="javascript:setdate('<%=currentDate%>',document.drugForm.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" />
 </a>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report"	class="buttonBig"	onClick="submitForm('drugForm','purchaseOrder?method=generateDrugExpiryReport');"	accesskey="a" tabindex=1 />
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
