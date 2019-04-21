<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
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
	List<FaVoucherHeader> voucherlist = new ArrayList<FaVoucherHeader>();
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
	if(map.get("voucherlist")!= null){
		voucherlist = (List<FaVoucherHeader>)map.get("voucherlist");
	}
%>


<form name="voucherregister" method="post" action="">
<div class="clear"></div>
<h4>Voucher Register Report</h4>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Voucher No</label>
<select id="mainAccountId"  name="<%=VOUCHER_NO %>" validate="From Voucher No,Integer,yes" >
	<option value="0">Select</option>
	<%if(voucherlist.size()>0){
		for(FaVoucherHeader faVoucherHeader :voucherlist){
			
		%>
	<option value="<%=faVoucherHeader.getId() %>"><%=faVoucherHeader.getVoucherNo() %></option>
		
	<%	}
	}
		%>
</select>
<label><span>*</span> To Voucher No</label>
	<select id="mainAccountId" name="<%=VOUCHER_NO %>" validate="To Voucher No,Integer,yes">
	<option value="0">Select</option>
	<%if(voucherlist.size()>0){
		for(FaVoucherHeader faVoucherHeader :voucherlist){
			
		%>
	<option value="<%=faVoucherHeader.getId() %>"><%=faVoucherHeader.getVoucherNo() %></option>
		
	<%	}
	}
		%>
	</select>
<label><span>*</span>Voucher Type</label>
	<select validate="Voucher Type,yes">
	<option value="SV">Sales</option>
	<option value="SV">Sales Voucher</option>
	<option value="PU">Purchase Voucher</option>
	<option value="RV">Refund Voucher</option>
	<option value="AP">Advance Voucher</option>
	<option value="FS">Final Settlement Voucher</option>
	</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('voucherregister','account?method=printfavoucherJsp');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>