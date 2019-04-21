<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<META content="Evrsoft First Page" name=GENERATOR><SCRIPT
	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT> <SCRIPT language=javascript
	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT>
	
	 <SCRIPT>
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

<div class="titleBg">
<H2>Charge Slip Report</H2>
</div>

<DIV class=clear></DIV>
<FORM name=report action="" method=post>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><LABEL>Charge Slip No </LABEL> <input
	type="text" name="chargeSlipNo" value="" maxlength="15" />
<DIV class=clear></DIV>
</div>
<DIV class=clear></DIV>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="submitForm('report','billing?method=printChargeSlipReport');"
	accesskey="g" tabindex=1 /></FORM>