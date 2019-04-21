<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%@page import="java.net.URL"%>
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
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();

	
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	
		int branchId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}

		if(session.getAttribute("branchId") != null){
			branchId = (Integer)session.getAttribute("branchId");
		}
	%>

<div class="titleBg">
<h2>Voucher Reports</h2>
</div>
<form name="voucherReport" target="_blank" action="" method="post">

<div class="Block">

<label><span>*</span>Voucher Type</label> 
<select name="voucherType" id="voucherType" validate="Type,string,yes">
	<option value="V">Select</option>
	<option value="SV">Sales Voucher</option>
	<option value="RV">Receipt Voucher</option>
	<option value="PV">Payment Voucher</option>
	</select>

<label><span>*</span>Voucher Number</label> 
<input type="text" 
	id="voucherNo" name="voucherNo" MAXLENGTH="30" /> 
	

<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="OK" class="button" value="Print" 
	onClick="submitForm('voucherReport','account?method=printVoucherReport');" />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
