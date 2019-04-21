<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>


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
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 
	%>


<div class="titleBg">
<h2>Sick Report</h2>
</div>
<div class="clear"></div>
<form name="search" target="_blank" method="post" action="">
<div class="Block">
<label> Date</label>
 <input type="text"	id="fromDateId" name="<%=DATE %>" value="<%=currenDate %>"	readonly="readonly" MAXLENGTH="30" class="date" /> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.search.<%=DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('search','registration?method=showSickReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>





