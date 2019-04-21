<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceDetails"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipDetail"%>
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
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>

<form name="paymentAdviceChargeSlip" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();
	List<BlPaymentAdviceDetails> payAdvList = new ArrayList<BlPaymentAdviceDetails>();
	List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("chargeSlipList") != null) {
		chargeSlipList = (List<BlChargeSlipMain>) map.get("chargeSlipList");
	}
	if (map.get("payAdvList") != null) {
		payAdvList = (List<BlPaymentAdviceDetails>) map.get("payAdvList");
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
%>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="titleBg">
<h2>Payment Advice Charge Slip</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>

<%
	String pastDueFlag = ""; 
	BlChargeSlipMain chargeSlipMain = new BlChargeSlipMain();
	Patient patient = new Patient();
	
	Set<BlChargeSlipDetail> dtSet = new HashSet<BlChargeSlipDetail>();
	if (chargeSlipList.size() > 0) {
		chargeSlipMain = chargeSlipList.get(0);	
			
		billAmt = chargeSlipMain.getChgSlpAmt();
		dtSet = chargeSlipMain.getBlChargeSlipDetails();
	}
	
	String pastDue = "";
	if(chargeSlipMain.getHin() != null){
			patient = chargeSlipMain.getHin();
			
			if (patient.getPastDue() != null && !patient.getPastDue().equals("0.00") && !patient.getPastDue().equals("0"))
				pastDue = patient.getPastDue();
			
			String sign = "";
 			if (!pastDue.equals("")){
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					pastDueFlag = "advance";
 				}else{
 					pastDueFlag = "due";
 				}
 			}else{
 				pastDueFlag = "noDue"; 				
 			}
			
%>
<div class="Block"><label>Payment Advice No.</label> <label
	class="value" validate="Payment Advice No.,metachar,no"><%=paymentAdviceNo %></label> <label>Payment
Advice Date</label> <label class="value" validate="Payment Advice Date,date,no"><%= date%></label> <label>Payment
Advice Time</label> <label class="value" validate="Payment Advice Time,string,no"><%= time%></label>
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value" validate="Reg No,metachar,no"><%=patient.getHinNo()%></label>

<label>Charge Slip No.</label> <label class="value" validate="Charge Slip No.,metachar,no"><%=chargeSlipMain.getChargeSlipNo()%></label>

<label>Patient Name</label>
<%
	String pName = patient.getPFirstName();
	if (patient.getPMiddleName() != null)
	{
		pName = pName.concat(" ").concat(patient.getPMiddleName());
	}
	if (patient.getPLastName() != null)
	{
		pName = pName.concat(" ").concat(patient.getPLastName());
	}
 %>
<label class="value" validate="Patient Name,metachar,no"><%=pName%></label> 

<input type="hidden" id="patientStatus" name="patientStatus" value="ip"/>
<div class="clear"></div>
<label>Past Dues</label> <label class="value" validate="Past Dues,metachar,no"><%=pastDue%></label> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" validate="hinId,int,no"/> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=chargeSlipMain.getInpatient().getId() %>" validate="inpatientId,int,no"/> <input
	type="hidden" name="<%=CHARGE_SLIP_ID %>"
	value="<%=chargeSlipMain.getId() %>" validate="chargeSlipId,int,no"/> <input type="hidden"
	id="pastDueId" name="<%=PAST_DUES %>" value="<%=pastDue %>" validate="pastDues,metachar,no"/> <%
 	}
 %> <label>Charge Slip Amount</label> <label class="value" validate="Charge Slip Amount,float,no"><%=billAmt%></label>

<label>Charge Slip Date</label> <label class="value" validate="Charge Slip Date,date,no"><%=HMSUtil.convertDateToStringWithoutTime(chargeSlipMain.getChgSlpDate())%></label>
<input type="hidden" name="billAmt" id="billAmt" value="<%=billAmt %>" validate="Charge Slip Amount,float,no"/>


<label>Cash Amount</label> 
	<label class="value" validate="Cash Amount,float,no"><%=chargeSlipMain.getReceiptAmt() %></label>
<input type="hidden" name="cashAmt" id="cashAmt" value="<%=chargeSlipMain.getReceiptAmt() %>" validate="Cash Amount,float,no"/>

	<label>On Account Amount</label> 
	<%
		BigDecimal onAcc = new BigDecimal(0.00);
		if(chargeSlipMain.getOsAmt() != null){
			onAcc = chargeSlipMain.getOsAmt();
		}
	%>
	<label class="value" validate="On Account Amount,float,no"><%=onAcc %></label>
<input type="hidden" name="osAmt" id="osAmt" value="<%=onAcc %>" validate="On Account Amount,float,no" />
	
<%
	if(refundList.size() > 0 && refundList.get(0) !=null){
		
%> <label>Refunded Amount</label> <label class="value" validate="Refunded Amount,float,no"><%=refundList.get(0)%></label>

<%} %>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Charge Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col">Charge Code</th>
		<th scope="col">Charge Description</th>
		<th scope="col">Charge Amount</th>
		<th scope="col">Charity Amount</th>
		<th scope="col">Advice Quantity</th>
		<th scope="col">Advice Amount</th>
		<th scope="col"></th>
	</tr>

	<%
		int inc = 1;
		
			for (BlChargeSlipDetail billDt : dtSet) {
				int qty = 0;
				BigDecimal charge = new BigDecimal(0);
				BigDecimal charity = new BigDecimal(0);
				
				BigDecimal totalAdvAmt = new BigDecimal(0);
				int totalAdvQty = 0;
				BigDecimal totalAdvCahrity = new BigDecimal(0);
				
				if (payAdvList.size() > 0) {
					for(BlPaymentAdviceDetails paymentAdviceDetails : payAdvList){
						if(billDt.getChargeCode().getId() == paymentAdviceDetails.getCharge().getId()){
							totalAdvQty = totalAdvQty+paymentAdviceDetails.getAdviceQty();
							totalAdvAmt = totalAdvAmt.add(paymentAdviceDetails.getAdviceAmt());
							totalAdvCahrity = totalAdvCahrity.add(paymentAdviceDetails.getAdviceCharityAmt());
						}
					}
					if(billDt.getQuantity() != totalAdvQty){
						qty = billDt.getQuantity() - totalAdvQty;
						charge = billDt.getNetAmt().subtract(totalAdvAmt.subtract(totalAdvCahrity));
						if(billDt.getDiscountAmt() != null)
							charity = billDt.getDiscountAmt();
						if(billDt.getProportionalDiscountAmount() != null)
							charity =charity.add(billDt.getProportionalDiscountAmount());
						
						charity = charity.subtract(totalAdvCahrity);
						
					}
				}else{
					qty = billDt.getQuantity();
					charge = billDt.getNetAmt();
					if(billDt.getDiscountAmt() != null)
						charity = billDt.getDiscountAmt();
					if(billDt.getProportionalDiscountAmount() != null)
						charity =charity.add(billDt.getProportionalDiscountAmount());
				}
				if(qty != 0){
	%>
	<tr>
		<input type="hidden" id="billDtId<%=inc %>"
			name="chargeSlipDtId<%=inc %>" value="<%=billDt.getId() %>" />
		<td><%=billDt.getChargeCode().getChargeCodeCode() %></td>
		<td><%=billDt.getChargeCode().getChargeCodeName() %></td>
		<td><%= charge%> <input type="hidden" id="chargeId<%=inc %>"
			value="<%=charge %>" />
		<td><%=charity %> <input type="hidden"
			name="<%=DISCOUNT_AMOUNT %>" id="disId<%=inc %>"
			value="<%=charity %>" /></td>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc %>" value="<%=qty %>" maxlength="3"
			readonly="readonly"
			onblur="checkQty(this.value,<%=inc %>,<%=qty %>,'serv');calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag %>');"
			tabindex="1" /></td>
		<td><input type="text" value="" id="adviceAmount<%=inc%>"
			name="<%=ADVICE_AMOUNT %><%=inc %>" validate="Advice Amount,float,no"
			maxlength="9" readonly="readonly" /></td>
		<td><input type="checkbox" id="selectedCharge<%=inc %>"
			value="<%=billDt.getChargeCode().getId() %>"
			name="<%=CHARGE_CODE_ID %><%=inc %>" class="radioCheck"
			onclick="enableQtyAmtField(this,<%=inc %>,<%=qty %>);calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag %>');" />
		<input type="hidden" name="adviceCharity<%=inc %>"
			id="adviceCharity<%=inc %>" value="" /></td>
	</tr>

	<%inc++;
				}
} %>
</table>
<input type="hidden" id="counterId" name="chargeListLength"
	value="<%=inc %>" />
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="Block"><label>Total Advice Amount</label> <input
	type="text" id="totalAdviceAmtId" name="<%=TOTAL_ADVICE_AMOUNT%>"
	class="readOnlySmall" value="" readOnly /> <label>Cash Advice
Amount</label> <input type="text" id="cashAdviceAmtId"
	name="<%=CASH_ADVICE_AMOUNT%>" class="readOnlySmall" value="" readOnly />

<label>On Account</label> <input type="text" id="pastDueAdjId"
	name="<%=PAST_DUE_ADJUSTED %>" class="readOnlySmall" value="" readOnly />

<label>Total Charity Amount</label> <input type="text"
	id="totalCharityAmtId" name="<%=TOTAL_CHARITY_AMOUNT%>"
	class="readOnlySmall" value="" readOnly />

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="submitForm('paymentAdviceChargeSlip','opBilling?method=submitPaymentAdviceServicingDetails','validateRows');"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="form.reset();" /> <input type="button"
	class="button" value="Back" onclick="history.back();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
