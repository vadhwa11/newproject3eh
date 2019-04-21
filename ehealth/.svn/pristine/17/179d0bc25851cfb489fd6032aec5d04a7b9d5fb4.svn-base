<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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


<form name="ProfitAndLoss" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Profit and Loss Report</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">



	<label><span>*</span> From Date:</label>
	<input type="text" name="from_date" id="from_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.ProfitAndLoss.from_date,event)" />

<label class="medium"><span>*</span>To Date:</label>
	<input type="text" name="to_date" id="to_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.ProfitAndLoss.to_date,event)" />

<label class="medium">Detail</label>
<input type="radio" value="y" name="detail" class="radioCheck" />
<label class="medium">Summary</label>
<input type="radio" value="n" name="detail" class="radioCheck" />

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('ProfitAndLoss','account?method=printProfitAndLossReport');" accesskey="a" tabindex=1 />

</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>