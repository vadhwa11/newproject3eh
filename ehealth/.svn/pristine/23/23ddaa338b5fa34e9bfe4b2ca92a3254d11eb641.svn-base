<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script> 
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


<form name="gLWiseSubLedReport" method="post" action="">
<div class="clear"></div>

<div class="titleBg">
<h2>GL wise Sub Ledger Report</h2></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<label>Financial Year</label>

<select id="mainAccountId" name="fYear" validate="Financial Year,string,yes"  />
	<option value="0">Select</option>
	<%if(fYearList.size()>0){
		for(HrMasFinancialYear financialYear:fYearList){
		%>
		<option value="<%=financialYear.getFinancialYear()%>"><%=financialYear.getFinancialYear() %></option>
	<%}
		}%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<%--- Report Button   --%>
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('gLWiseSubLedReport','account?method=printGLWiseSubLedReport');" accesskey="a" tabindex=1 />
<input type="reset" name="clear"  id="clearbutton" value="Clear" class="buttonHighlight" accesskey="a"  tabindex=1 />
<div class="clear"></div>
<div class="division"></div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>