<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"> </script>
<script language=javascript src="/hms/jsp/js/common.js" type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></script> 
<script language=javascript	src="/hms/jsp/js/calendar.js" type=text/javascript></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
			serverdate = '<%=dateCal+"/"+month+"/"+year%>';
		</SCRIPT>

	<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
		if (map.get("message") != null) {
			String message = (String) map.get("message");
			out.println(message);
		}
	%> 


<form name="report" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg"> <h2>Bank Voucher</h2></div>
<div class="Block"> 

<label><span>*</span> From Date</label> 
<input type="text" name="fromDate" value="<%=date %>" validate="From Date,yes" class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.report.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> 
<input type="text" name="toDate" value="<%=date %>" validate="To Date,yes"	class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=TO_DATE%>',document.report.<%=TO_DATE%>,true);" />


<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('report','budget?method=printAppropriationReport');" accesskey="g" tabindex=1 />
<input type="reset" name="clear"  id="clearbutton" value="Clear" class="buttonHighlight"  accesskey="a"  tabindex=1 />
<div class="clear"></div>
<div class="division"></div>

</form>