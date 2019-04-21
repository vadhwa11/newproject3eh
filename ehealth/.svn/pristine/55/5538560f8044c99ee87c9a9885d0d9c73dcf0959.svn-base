<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<%@page import="jkt.hms.masters.business.BlDispensingDetails"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispDetails"%>
<%@page import="jkt.hms.masters.business.BlRefundHeader"%>
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
		serverdate = '<%=curDate+"/"+month+"/"+year%>';
</script>

<form name="paymentAdviceDispensing" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
	List<BlPymntAdviceDispDetails> payAdvList = new ArrayList<BlPymntAdviceDispDetails>();
	List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("dispensingHeaderList") != null) {
		dispensingHeaderList = (List<BlDispensingHeader>) map.get("dispensingHeaderList");
	}
	if (map.get("payAdvList") != null) {
		payAdvList = (List<BlPymntAdviceDispDetails>) map.get("payAdvList");
	}
	if (map.get("refundList") != null) {
		refundList = (List<BlRefundHeader>) map.get("refundList");
	}
	String paymentAdviceNo = "";
	if (map.get("paymentAdviceNo") != null) {
		paymentAdviceNo = (String) map.get("paymentAdviceNo");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	BigDecimal billAmt = new BigDecimal(0);
	BigDecimal cashAmt = new BigDecimal(0);
	BigDecimal osAmt = new BigDecimal(0);
	BigDecimal advAmt = new BigDecimal(0);
%>

<div class="titleBg">
<h2>Payment Advice Dispensing</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

 <label>Bill Amt</label> 
 <label class="value"></label> 
 <label>Bill
Date</label> 
<label class="value">
</label>
	<input type="hidden" name="billAmt" id="billAmt" value=""/>
	<input type="hidden" name="cashAmt" id="cashAmt" value=""/>
	<input type="hidden" name="osAmt" id="osAmt" value=""/>
	<input type="hidden" name="advAmt" id="advAmt" value=""/>
<div class="clear"></div>

 <label>Refunded Amount</label> <label class="value"></label>
<div class="clear"></div>


</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Item Details</h4>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col">Item Name</th>
		<th scope="col">Batch No</th>
		<th scope="col">Amount</th>
		<th scope="col">Charity</th>
		<th scope="col">Advice Quantity</th>
		<th scope="col">Advice Amount</th>
		<th scope="col"></th>
	</tr>

	
	<tr>
		<input type="hidden" id="dispensingDtId"
			name="dispensingDtId" value="" />
		<td>fddf</td>
		<td></td>
		
		<td> <input type="hidden"
			name="" id=""
			value="" /></td>

		<td><input type="text" size="5" id=""
			name="" value="<%=qty %>" maxlength="6"
			readonly="readonly"
			onblur="checkQty(this.value,<%=inc %>,<%=qty %>,'disp');calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag%>');"
			tabindex="1" /></td>
		<td><input type="text" value="" id="adviceAmount<%=inc%>"
			name="<%=ADVICE_AMOUNT %><%=inc %>" validate="Advice Amount,float,no"
			maxlength="9" readonly="readonly" /></td>
		<td><input type="checkbox" id="selectedCharge<%=inc %>"
			value="<%=billDt.getBatch().getId() %>"
			name="<%=BATCH_ID %><%=inc %>" class="radioCheck"
			onclick="enableQtyAmtField(this,<%=inc %>,<%=qty %>); calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag%>');" />
		<input type="hidden" name="<%=ITEM_ID %><%=inc %>"
			value="<%=billDt.getItem().getId() %>" /> <input type="hidden"
			name="adviceCharity<%=inc %>" id="adviceCharity<%=inc %>" value="" />
		</td>
	</tr>

	<%inc++;
				}
} %>
</table>
<input type="hidden" id="counterId" name="chargeListLength"
	value="<%=inc %>" />
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<div class="Block"><label>Total Advice Amt</label>
<input	type="text" id="totalAdviceAmtId" name="<%=TOTAL_ADVICE_AMOUNT%>"	class="readOnlySmall" value="" readOnly />
	<label>Cash Advice Amount</label>
	<input type="text" id="cashAdviceAmtId" name="<%=CASH_ADVICE_AMOUNT%>"
	class="readOnlySmall" value="" readOnly />

<%
//if(dispensingHeader.getInpatient() != null){
%>
<label>On Account</label> <input type="text" id="pastDueAdjId"
	name="<%=PAST_DUE_ADJUSTED %>" class="readOnlySmall" value="" readOnly />
<%//} %>
<label>Total Charity Amount</label> <input type="text"
	id="totalCharityAmtId" name="<%=TOTAL_CHARITY_AMOUNT%>"
	class="readOnlySmall" value="" readOnly />

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="submitForm('paymentAdviceDispensing','opBilling?method=submitPaymentAdviceDispensingDetails','validateRows');"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="form.reset();" /> <input type="button"
	class="button" value="Back" onclick="history.back();" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
