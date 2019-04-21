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

<%
	String pastDueFlag = "";
	BlDispensingHeader dispensingHeader = new BlDispensingHeader();
	Patient patient = new Patient();

	Set<BlDispensingDetails> dtSet = new HashSet<BlDispensingDetails>();
	if (dispensingHeaderList.size() > 0) {
		dispensingHeader = dispensingHeaderList.get(0);
	if(dispensingHeader.getBillAmt()!= null)
		billAmt = dispensingHeader.getBillAmt();
	else
		billAmt = new BigDecimal(0);


		if(dispensingHeader.getPayableAmt() != null)
		cashAmt = dispensingHeader.getPayableAmt();
	else
		cashAmt =new BigDecimal(0);

	if(dispensingHeader.getOutstanding() != null)
		osAmt = dispensingHeader.getOutstanding();
	else
		osAmt = new BigDecimal(0);
	if(dispensingHeader.getAdvAdjustment() != null)
		advAmt = dispensingHeader.getAdvAdjustment();
	else
		advAmt = new BigDecimal(0);



		dtSet = dispensingHeader.getBlDispensingDetails();
	}

	String pastDue = "";
	if(dispensingHeader.getHin() != null){
			patient = dispensingHeader.getHin();

			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();

			String sign = "";
 			if (!pastDue.equals("")){
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					pastDueFlag = "advance";
 				}else{
 					pastDueFlag = "due";
 				}
 			}

%>
<div class="Block">
<label>Payment Advice No.</label> <label
	class="value" validate="Payment Advice No.,metachar,no"><%=paymentAdviceNo %></label> 
<label>Payment Advice Date</label> <label class="value" validate="Payment Advice Date,date,no"><%= date%></label>
 <label>Payment Advice Time</label> <label class="value" validate="Payment Advice Time,metachar,no"><%= time%></label>
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<label class="value" validate="RegNo,metachar,no"><%=patient.getHinNo()%></label>

<label>Bill No.</label> <label class="value" validate="Bill No.,metachar,no"><%=dispensingHeader.getBillNo()%></label>

<label>Patient Name</label> <%
 	if (patient.getPFirstName() != null) {
 %> <label class="value" validate="Patient Name,metachar,no"><%=patient.getPFirstName()%> <%=patient.getPMiddleName()%>
<%=patient.getPLastName()%></label> <%
 	}
 %>

<div class="clear"></div>
<%
	if(dispensingHeader.getInpatient() != null){
%>
<input type="hidden" id="patientStatus" name="patientStatus" value="ip" validate="patientStatus,metachar,no"/>
<label>Past Dues</label> <label class="value" validate="Past Dues,metachar,no"><%=pastDue%></label>
<%}else{ %>
<input type="hidden" id="patientStatus" name="patientStatus" value="op" validate="patientStatus,metachar,no"/>
<%} %>
<input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" validate="hinId,int,no"/> <input
	type="hidden" name="<%=BILL_ID %>"
	value="<%=dispensingHeader.getId() %>" validate="billId,int,no"/> <input type="hidden"
	id="pastDueId" name="<%=PAST_DUES %>" value="<%=pastDue %>" validate="Past Dues,metachar,no"/> <%
	if(dispensingHeader.getInpatient() != null){
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dispensingHeader.getInpatient().getId() %>" validate="inpatientId,int,no" /> <%}
 	}
 %> <label>Bill Amt</label> <label class="value" validate="Bill Amt,float,no"><%=billAmt%></label> 
 <label>Bill Date</label> <label class="value" validate="Bill Date,date,no"><%=HMSUtil.convertDateToStringWithoutTime(dispensingHeader.getBillDate())%></label>
	<input type="hidden" name="billAmt" id="billAmt" value="<%=billAmt %>" validate="billAmt,float,no"/>
	<input type="hidden" name="cashAmt" id="cashAmt" value="<%=cashAmt %>" validate="cashAmt,float,no"/>
	<input type="hidden" name="osAmt" id="osAmt" value="<%=osAmt %>" valisdate="osAmt,float,no"/>
	<input type="hidden" name="advAmt" id="advAmt" value="<%=advAmt %>" validate="advAmt,float,no"/>
<div class="clear"></div>

<%
	if(refundList.size() > 0 && refundList.get(0) !=null){

%> <label>Refunded Amount</label> <label class="value"><%=refundList.get(0)%></label>
<div class="clear"></div>

<%} %>
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

	<%
		int inc = 1;

			for (BlDispensingDetails billDt : dtSet) {
				BigDecimal qty = new BigDecimal(0);
				BigDecimal charge = new BigDecimal(0);
				BigDecimal charity = new BigDecimal(0);

				BigDecimal totalAdvAmt = new BigDecimal(0);
				BigDecimal totalAdvQty = new BigDecimal(0);
				BigDecimal totalAdvCahrity = new BigDecimal(0);

				if (payAdvList.size() > 0) {
					for(BlPymntAdviceDispDetails paymentAdviceDetails : payAdvList){
						if(billDt.getBatch().getId() == paymentAdviceDetails.getBatch().getId()){
							totalAdvQty = totalAdvQty.add(paymentAdviceDetails.getAdviceQty());
							totalAdvAmt = totalAdvAmt.add(paymentAdviceDetails.getAdviceAmt());
							totalAdvCahrity = totalAdvCahrity.add(paymentAdviceDetails.getAdviceCharityAmt());

						}
					}
					if(billDt.getQty() != totalAdvQty){
						qty = billDt.getQty().subtract(totalAdvQty);
						charge = billDt.getNetAmt().subtract(totalAdvAmt.subtract(totalAdvCahrity));
						if(billDt.getDiscountAmt() != null)
							charity = billDt.getDiscountAmt();
						if(billDt.getProportionalDisAmt() != null)
							charity =charity.add(billDt.getProportionalDisAmt());

						charity = charity.subtract(totalAdvCahrity);
					}
				}else{
					qty = billDt.getQty();
					charge = billDt.getNetAmt();
					if(billDt.getDiscountAmt() != null)
						charity = billDt.getDiscountAmt();
					if(billDt.getProportionalDisAmt() != null)
						charity =charity.add(billDt.getProportionalDisAmt());
				}
				if(qty.compareTo(new BigDecimal("0")) > 0){
	%>
	<tr>
		<input type="hidden" id="dispensingDtId<%=inc %>" name="dispensingDtId<%=inc %>" value="<%=billDt.getId() %>" />
		<td><%=billDt.getItem().getNomenclature()%></td>
		<td><%=billDt.getBatch().getBatchNo() %></td>
		<td><%=charge%> <input type="hidden" id="chargeId<%=inc %>"
			value="<%=charge %>" validate="chargeId,float,no"/>
		<td><%=charity %> <input type="hidden"
			name="<%=DISCOUNT_AMOUNT %>" id="disId<%=inc %>"
			value="<%=charity %>" validate="discontAmount,float,no"/></td>

		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc %>" value="<%=qty %>" maxlength="6" validate="quantity,float,no"
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
			value="<%=billDt.getItem().getId() %>" validate="itemId,int,no"/> <input type="hidden"
			name="adviceCharity<%=inc %>" id="adviceCharity<%=inc %>" value="" validate="adviceCharity,float,no" />
		</td>
	</tr>

	<%inc++;
				}
} %>
</table>
<input type="hidden" id="counterId" name="chargeListLength"
	value="<%=inc %>" validate="chargeListLength,int,no"/>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<div class="Block"><label>Total Advice Amt</label>
<input	type="text" id="totalAdviceAmtId" name="<%=TOTAL_ADVICE_AMOUNT%>" validate="totalAdviceAmount,float,no"	class="readOnlySmall" value="" readOnly />
	<label>Cash Advice Amount</label>
	<input type="text" id="cashAdviceAmtId" name="<%=CASH_ADVICE_AMOUNT%>"
	class="readOnlySmall" validate="cashAdviceAmount,float,no" value="" readOnly />

<%
//if(dispensingHeader.getInpatient() != null){
%>
<label>On Account</label> <input type="text" id="pastDueAdjId"
	name="<%=PAST_DUE_ADJUSTED %>" class="readOnlySmall" validate="pastDueAdjusted,float,no" value="" readOnly />
<%//} %>
<label>Total Charity Amount</label> <input type="text"
	id="totalCharityAmtId" name="<%=TOTAL_CHARITY_AMOUNT%>"
	class="readOnlySmall" validate="totalCharityAmount,float,no" value="" readOnly />

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
