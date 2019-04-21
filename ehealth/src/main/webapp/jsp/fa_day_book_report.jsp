<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script> 
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("fYearList")!= null){
		fYearList = (List<HrMasFinancialYear>)map.get("fYearList");
	}
%>

<form name="daybook" method="post" action="">
<div class="clear"></div>
<h2>Day Book Report</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>From Date:</label>
<input type="text" name="from_date" id="from_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.daybook.from_date,event)" />

<label><span>*</span>To Date:</label>
<input type="text" name="to_date" id="to_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.daybook.to_date,event)" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('daybook','account?method=printDayBookReport');" accesskey="a" tabindex=1 />

</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>