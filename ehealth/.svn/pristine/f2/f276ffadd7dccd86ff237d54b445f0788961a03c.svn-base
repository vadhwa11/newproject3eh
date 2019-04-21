<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<div class="clear"></div>

<div class="titleBg">
<h2>Appointment slip</h2>
</div>
<div class="clear"></div>
<form name="appointmentReport" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<div id="testDiv"><label> Appointment No.</label> <input type="text"
	id="frwSlno" name="<%=APPOINTMENT_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="Appointment No,string,yes" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Appointment Slip" class="buttonBig"
	onClick="submitForm('appointmentReport','appointment?method=showAppointmentSlip');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>