<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlOpBillDetails"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceDetails"%>
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

<form name="paymentAdviceServicing" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlOpBillHeader> billList = new ArrayList<BlOpBillHeader>();
	List<BlPaymentAdviceDetails> payAdvList = new ArrayList<BlPaymentAdviceDetails>();
	List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("billList") != null) {
		billList = (List<BlOpBillHeader>) map.get("billList");
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
	BigDecimal cashAmt = new BigDecimal(0);
	BigDecimal osAmt = new BigDecimal(0);
%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
 
<%
	String pastDueFlag = "";
	BlOpBillHeader blHeader = new BlOpBillHeader();
	Patient patient = new Patient();

	Set<BlOpBillDetails> dtSet = new HashSet<BlOpBillDetails>();
	if (billList.size() > 0) {
		blHeader = billList.get(0);

		billAmt = blHeader.getBillAmt();
		if(blHeader.getPayableAmt() != null)
			cashAmt = blHeader.getPayableAmt();
		if(blHeader.getOutstanding() != null)
			osAmt = blHeader.getOutstanding();
		dtSet = blHeader.getBlOpBillDetails();
	}

	String pastDue = "";
	int hinId =0;
	if(blHeader.getHin() != null){
			patient = blHeader.getHin();
			hinId = patient.getId();

			if (patient.getPastDue() != null && !patient.getPastDue().equals("0.00") && !patient.getPastDue().equals("0"))
				pastDue = patient.getPastDue();
			%> <input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" validate="hinId,int,no"/> <%}


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
<!-- <div class="titleBg">
<h2>Patient Advice</h2>
</div> -->

<%-- <div class="Block">
<label><u>Servicing</u></label>
<div class="clear"></div>
<div class="clear"></div>
<label>Patient Type</label> 
  <select id="patientTypeId" name="<%=PATIENT_TYPE %>" onchange="changeFieldsForType()">
	<option value="op">Out Patient</option>
	<option value="ip">In Patient</option>
  </select>

<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30" onblur="callAjax();" />
<label>Bill No.</label>
<input type="text" value=""/>
<div class="clear"></div>
<input class="button" type="button" onclick="submitForm('searchChargeSlipCancel','billing?method=cancelChargeSlip');" value="Search" name="Search">
 <label class="value"><%=blHeader.getBillNo()%></label>
</div> --%>

<div class="clear"></div>
<div class="titleBg">
<h2>Patient Advice Services</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value" validate="Reg No,metachar,no"><%=blHeader.getHinNo()%></label>
<label>Patient Name</label> <%
 	if (blHeader.getPatientName() != null) {
 %> <label class="value" validate="Patient Name,metachar,no"><%=blHeader.getPatientName()%> </label> <%
 	}
 %>
<label>Bill No.</label> <label class="value" validate="Bill No.,metachar,no"><%=blHeader.getBillNo()%></label>
 <!-- Commented by Satish -->
<%-- <div class="clear"></div>

<label>Payment Advice No.</label> <label
	class="value"><%=paymentAdviceNo %></label>
<label>Payment Advice Time</label> <label class="value"><%= time%></label>



<label>Payment Advice Date</label> <label class="value"><%= date%></label> --%>

<input type="hidden" id="patientStatus" name="patientStatus" value="op"/>
<div class="clear"></div>
<!--<label>Past Dues</label> <label class="value"><%=pastDue%></label> --><input
	type="hidden" name="<%=BILL_ID %>" value="<%=blHeader.getId() %>" /> <input
	type="hidden" id="pastDueId" name="<%=PAST_DUES %>"
	value="<%=pastDue %>" /> <label>Bill Amount</label> <label id="billAmtLbl"
	class="value"><%=billAmt%></label>
	<label>Bill Date</label> <label
	class="value"><%=HMSUtil.convertDateToStringWithoutTime(blHeader.getBillDate())%></label>
	<input type="hidden" name="billAmt" id="billAmt" value="<%=billAmt %>"/>
	<input type="hidden" name="cashAmt" id="cashAmt" value="<%=cashAmt %>"/>
	<input type="hidden" name="osAmt" id="osAmt" value="<%=osAmt %>"/>

<label>Remarks</label><textarea rows="4" cols="50">
thanks for....!!!!
</textarea>
<div class="clear"></div>

<%
	if(refundList.size() > 0 && refundList.get(0) !=null){

%> <label>Refunded Amount</label> <label class="value"><%=refundList.get(0)%></label>
<div class="clear"></div>

<%} %>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Charge Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Charge Code</th>
		<th scope="col">Charge Description</th>
		<th scope="col">Charge Amount</th>
		<!-- <th scope="col">Charity Amount</th> -->
		<th scope="col">Advice Quantity</th>
		<th scope="col">Advice Amount</th>
		
	</tr>

	<%
		int inc = 1;
		BigDecimal stdDed = new BigDecimal(0.00);
			for (BlOpBillDetails billDt : dtSet) {
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
		<input type="hidden" id="billDtId<%=inc %>" name="billDtId<%=inc %>"
			value="<%=billDt.getId() %>" />
		<td><input type="checkbox" id="selectedCharge<%=inc %>"
			value="<%=billDt.getChargeCode().getId() %>"
			name="<%=CHARGE_CODE_ID %><%=inc %>" class="radioCheck"
			onclick="enableQtyAmtField(this,<%=inc %>,<%=qty %>);calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag %>');" />
		<input type="hidden" name="adviceCharity<%=inc %>"
			id="adviceCharity<%=inc %>" value="" /></td>
		<td><%=billDt.getChargeCode().getChargeCodeCode() %></td>
		<td><%=billDt.getChargeCode().getChargeCodeName() %></td>
		<td><%= charge%> <input type="hidden"  id="chargeId<%=inc %>"
			value="<%=charge %>" />
		<%-- <td><%=charity %> <input type="hidden"
			name="<%=DISCOUNT_AMOUNT %>" id="disId<%=inc %>"
			value="<%=charity %>" /></td> --%>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc %>" value="<%=qty %>" maxlength="3" readonly="readonly" validate="Advice Qty,int,no"
			onblur="checkQty(this.value,<%=inc %>,<%=qty %>,'serv');calculateTotalAdviceAmt(<%=inc %>,'<%=pastDueFlag %>');"
			tabindex="1" /></td>
		<td><input type="text" value="" id="adviceAmount<%=inc%>"
			name="<%=ADVICE_AMOUNT %><%=inc %>" validate="Advice Amount,float,no"
			maxlength="9" readonly="readonly" /></td>
		
	</tr>

	<%
	 	if(billDt.getStdDeductionGen() != null){
	 		stdDed = stdDed.add(billDt.getStdDeductionGen());
	 	}else if(billDt.getStdDeductionSpl() != null){
	 		stdDed = stdDed.add(billDt.getStdDeductionSpl());
	 	}
	inc++;
				}
} %>
</table>
<script type="text/javascript">
document.getElementById('billAmtLbl').innerHTML = '<%=billAmt%>';
document.getElementById('billAmt').value = '<%=billAmt%>';
</script>
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

<%-- <label>On Account</label> <input type="text" id="pastDueAdjId"
	name="<%=PAST_DUE_ADJUSTED %>" class="readOnlySmall" value="" readOnly /> --%>

<%-- <label>Total Charity Amount</label> <input type="text"
	id="totalCharityAmtId" name="<%=TOTAL_CHARITY_AMOUNT%>"
	class="readOnlySmall" value="" readOnly /> --%>

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="submitForm('paymentAdviceServicing','opBilling?method=submitPaymentAdviceServicingDetails','validateRows');"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="form.reset();" /> <!-- <input type="button"
	class="button" value="Back" onclick="history.back();" /> -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>