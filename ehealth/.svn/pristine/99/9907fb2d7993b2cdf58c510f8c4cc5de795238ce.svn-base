<%@page import="jkt.hms.masters.business.MasCharityType"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceHeader"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispHeader"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<%@page import="jkt.hms.masters.business.BlRefundHeader"%>


<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
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
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="cashRefund" method="post" action="">
<div class="titleBg">
<h2>Cash Refund</h2>
</div>
<div class="clear"></div>
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<BlPaymentAdviceHeader> pmntAdvServList = new ArrayList<BlPaymentAdviceHeader>();
	List<BlPymntAdviceDispHeader> pmntAdvDispList = new ArrayList<BlPymntAdviceDispHeader>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<BigDecimal> refundList = new ArrayList<BigDecimal>();
	List<BigDecimal> refundList1 = new ArrayList<BigDecimal>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");

	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	if(map.get("pmntAdvServList") != null){
		pmntAdvServList = (List<BlPaymentAdviceHeader>)map.get("pmntAdvServList");
	}
	if (map.get("pmntAdvDispList") != null) {
		pmntAdvDispList = (List<BlPymntAdviceDispHeader>) map.get("pmntAdvDispList");
	}
	if (map.get("bankList") != null) {
		bankList = (List<MasBankMaster>) map.get("bankList");
	}
	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	if (map.get("refundList") != null) {
		refundList = (List<BigDecimal>) map.get("refundList");
	}
	if (map.get("refundList1") != null) {
		refundList1 = (List<BigDecimal>) map.get("refundList1");
	}
	if (map.get("masCharityList") != null) {
		masCharityList = (List<MasCharityType>) map.get("masCharityList");
	}
	System.out.println("size"+refundList1.size());
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	%> <!--Block One Starts-->
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
			String refundNo = "";
			if(map.get("refundNo") != null){
				refundNo = (String)map.get("refundNo");
			}

		%> 
<%-- <label>Refund No.</label> <label class="value"><%=refundNo %></label>

<label>Refund Date</label> <input type="text" name="<%=REFUND_DATE %>" class="readOnly" value="<%=date %>" /> 
<label>Refund Time</label> <input type="text" name="<%=REFUND_TIME %>" class="readOnly" value="<%=time %>" /> --%>

<div class="clear"></div>
<%
   int inpatientId = 0;
   int hinId = 0;
   String patientName = "";
   String hin = "";
   String pastDue = "";
   String billNo = "";
   int chargeSlipNo = 0;
   String pymtAdvNo = "";
   String pymtAdvDate = "";
   BigDecimal totalAdvAmt = new BigDecimal(0);
   BigDecimal cashAdvAmt = new BigDecimal(0);
   BigDecimal onAccAdvAmt = new BigDecimal(0);
   BigDecimal charityAdvAmt = new BigDecimal(0);
   System.out.println("pmntAdvServList.size()....>>>>>>>>"+pmntAdvServList.size());
   	if(pmntAdvServList.size() > 0){
   		System.out.println("pmntAdvServList.size()...."+pmntAdvServList.size());
   		for(BlPaymentAdviceHeader paymentAdviceHeader : pmntAdvServList){
   			BlOpBillHeader opBillHeader = new BlOpBillHeader();
   			if(paymentAdviceHeader.getBill() != null){
   				opBillHeader = paymentAdviceHeader.getBill();
   				patientName = opBillHeader.getPatientName();
   				hin = opBillHeader.getHinNo();
   				billNo = opBillHeader.getBillNo();
   				if(opBillHeader.getHin() != null){
   	   				hinId = opBillHeader.getHin().getId();
   	   				if(opBillHeader.getHin().getPastDue() != null){
   	   					pastDue = opBillHeader.getHin().getPastDue();
   	   				}
   	   			}
   			}else if(paymentAdviceHeader.getChargeSlipMain() != null){
   				patientName = paymentAdviceHeader.getChargeSlipMain().getHin().getPFirstName();
   				hin = paymentAdviceHeader.getChargeSlipMain().getHin().getHinNo();
   				hinId =  paymentAdviceHeader.getChargeSlipMain().getHin().getId();
   				chargeSlipNo = paymentAdviceHeader.getChargeSlipMain().getChargeSlipNo();
   				inpatientId = paymentAdviceHeader.getInpatient().getId();
   			}


   			pymtAdvNo = paymentAdviceHeader.getPaymentAdviceNo();
   			pymtAdvDate = HMSUtil.convertDateToStringWithoutTime(paymentAdviceHeader.getPaymentAdviceDate());
   			totalAdvAmt = paymentAdviceHeader.getTotalAdviceAmt();
			if(paymentAdviceHeader.getCashAdviceAmt() != null){
				cashAdvAmt = paymentAdviceHeader.getCashAdviceAmt();
			}
			if(paymentAdviceHeader.getOnAccountAmt() != null){
				onAccAdvAmt = paymentAdviceHeader.getOnAccountAmt();
			}
			if(paymentAdviceHeader.getTotalAdviceCharityAmt() != null){
				charityAdvAmt = paymentAdviceHeader.getTotalAdviceCharityAmt();
			}
			%> <input type="hidden" name="<%=PAYMENT_ADVICE_ID %>"
	value="<%=paymentAdviceHeader.getId() %>" validate="paymentAdviceId,int,no"> <%
   		}
   	}else if(pmntAdvDispList.size() > 0){
   		for(BlPymntAdviceDispHeader pymntAdviceDispHeader : pmntAdvDispList){
   			BlDispensingHeader dispensingHeader = pymntAdviceDispHeader.getBillDispensing();
   			patientName = dispensingHeader.getPatientName();
   			hin = dispensingHeader.getHinNo();
   			if(dispensingHeader.getHin() != null){
   				hinId = dispensingHeader.getHin().getId();
   				if(dispensingHeader.getHin().getPastDue() != null){
   					pastDue = dispensingHeader.getHin().getPastDue();
   				}
   			}
   			billNo = dispensingHeader.getBillNo();
   			pymtAdvNo = pymntAdviceDispHeader.getPaymentAdviceNo();
   			pymtAdvDate = HMSUtil.convertDateToStringWithoutTime(pymntAdviceDispHeader.getPaymentAdviceDate());
   			totalAdvAmt = pymntAdviceDispHeader.getTotalAdviceAmt();
			if(pymntAdviceDispHeader.getCashAdviceAmt() != null){
				cashAdvAmt = pymntAdviceDispHeader.getCashAdviceAmt();
			}
			if(pymntAdviceDispHeader.getOnAccountAmt() != null){
				onAccAdvAmt = pymntAdviceDispHeader.getOnAccountAmt();
			}
			if(pymntAdviceDispHeader.getTotalAdviceCharityAmt() != null){
				charityAdvAmt = pymntAdviceDispHeader.getTotalAdviceCharityAmt();
			}
			if(pymntAdviceDispHeader.getInpatient() != null){
				inpatientId = pymntAdviceDispHeader.getInpatient().getId();
			}
			%> <input type="hidden" name="<%=PAYMENT_ADVICE_DISPENSING_ID %>"
	value="<%=pymntAdviceDispHeader.getId() %>" validate="paymentAdviceDispensingId,int,no"> <%
   		}

   	}

	%> 
<%
String uhid="";
String pname="";
String age="";
String sex="";
String mobile="";
String status="";
//int billNo=0;
for(Patient pat:patientList){
	uhid=pat.getHinNo();
	pname=pat.getPFirstName();
	age=pat.getAge()!=null ?pat.getAge():"" ;
	sex=pat.getSex().getAdministrativeSexCode();
	mobile=pat.getMobileNumber()!=null ?pat.getMobileNumber():"";
	status=pat.getBplStatus()!=null ? pat.getBplStatus():"";
	// billNo=pat.getBillNo(); 
}
%>
<input type="hidden" name="<%=INPATIENT_ID %>"	value="<%=inpatientId %>" validate="inpatientId,int,no"/>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" value="<%=uhid%>" readonly="readonly"  validate="uhid,metachar,no"/>
<label>Patient Name</label>
<input type="text" name="patientName" id="patientName" value="<%=pname%>"validate="patientName,metachar,no"/>
<label>Age</label><input type="text" value="<%=age%>" validate="Age,String,no"/>

<div class="clear"></div>
<label>Gender</label>
<input type="text"  value="<%=sex%>" validate="Gender,metachar,no"/>
<label>Mobile</label>
<input type="text"  value="<%=mobile%>" validate="Mobile,metachar,no"/>
<label>Bill No</label><input type="text" value="<%=billNo%>" validate="billNo,int,no"/>
	<%
	    	if(!pastDue.equals("")){
	    %> 
<label>Past Due</label> <label class="value" validate="Past Dues,metachar,no"> <%=pastDue %></label>
<%} %> <input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" validate="hinId,int,no">
<div class="clear"></div>
<%
			if(!billNo.equals("")){
		%> 
<label>Bill No.</label> <label class="value" validate="Bill No.,metachar,no"><%=billNo %></label> <%}else if(chargeSlipNo !=0){ %>
<label>Charge Slip No.</label> <label class="value" validate="Charge Slip No.,metachar,no"><%=chargeSlipNo %></label>
<%} %> 
<label>Payment Advice No.</label><input type="text" value="<%=pymtAdvNo %>" validate="Payment Advice No.,metachar,no"/>

<label>Payment Advice Date</label> <input type="text" value="<%=pymtAdvDate %>" validate="currentDate,date,no"/>
<label>Total Advice Amount</label><input type="text" value="<%=totalAdvAmt %>" validate="totalAdvAmt,float,no"/>
<div class="clear"></div>
<%-- <label>Family Income Category</label><%if(status.equalsIgnoreCase("y")){ %>
   <input type="text"  readonly="readonly" value="BPL" />
  
  <%}else if(status.equalsIgnoreCase("n")){ %>
   <input type="text"  readonly="readonly" value="APL" />
  
  <%}else { %>
   <input type="text"  readonly="readonly" value="-" />
  <%} %>
<label>Social Category</label><input type="text" value="" validate="Social Category,metachar,no"/>
<label>Other Category</label><input type="text" value="" validate="Other Category,metachar,no"/>
<label>Total Advice Amount</label> <label class="value"><%=totalAdvAmt %></label>
<label>Cash Advice Amount</label> <label class="value"><%=Math.round(cashAdvAmt.doubleValue()) %></label>
<input type="hidden" id="cashAdvAmtId" value="<%=Math.round(cashAdvAmt.doubleValue()) %>" /> 
<label>On Account</label> <label class="value"><%=onAccAdvAmt %></label>

<div class="clear"></div> --%>

<%
		BigDecimal refundAmt = new BigDecimal(0);
       BigDecimal charityAmt = new BigDecimal(0);
       
       BigDecimal refundedAmt = new BigDecimal(0);
       if(refundList1.size() > 0 && refundList1.get(0) !=null){
    	   charityAmt = (BigDecimal)refundList1.get(0);}
			if(refundList.size() > 0 && refundList.get(0) !=null){ 
				
				refundAmt = (BigDecimal)refundList.get(0);}
			 refundedAmt=refundAmt.add(charityAmt);
		%> <%-- <label>Refunded Amount</label> <label class="value"><%=refundedAmt%></label> --%>

<input type="hidden" name="<%=REFUND_AMOUNT %>" value="<%=refundedAmt%>" validate="refundAmt,float,no"/>

<label>Remaining Refund Amount</label> <label class="value" validate="Remaining Refund Amount,float,no"><%=Math.round((cashAdvAmt.subtract(refundedAmt)).doubleValue())%></label>
<input type="hidden" name="remRefAmt" id="remRefAmt"  validate="remRefAmt,float,no" value="<%=Math.round((cashAdvAmt.subtract(refundedAmt)).doubleValue())%>" />
<label style="display: none;">Charity Amount</label>
<input type="text" class="readOnly" style="display: none;"
	name="<%=CHARITY_AMOUNT %>" value="<%=charityAdvAmt %>" validate="charityAmount,float,no"/> 
<label>Round Off</label><input type="text" class="readOnly" name="<%=ROUND_OF_VALUE %>" validate="roundOfValue,float,no"
	id="roundId" />  <script type="text/javascript">
		var cashAdvAmt = '<%=cashAdvAmt%>';
		var roundedCashAmt = Math.round(parseFloat(cashAdvAmt))
		if(cashAdvAmt.toString().indexOf('.') > 0)
			{
				if(roundedCashAmt > parseFloat(cashAdvAmt)){
					document.getElementById('roundId').value =
						(roundedCashAmt-cashAdvAmt).toFixed(2);
				}
				else{
					document.getElementById('roundId').value =
					(cashAdvAmt-roundedCashAmt).toFixed(2);
				}
			}
		</script>
<div class="clear"></div></div>
<div class="clear"></div>
<h4>Refund Details</h4>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Relation To Patient</label> <select id="relationId" name="<%=RELATION_ID %>"
	validate="Relation To Patient,metachar,yes" onchange="checkForRelation();">
	<option value="0">Select</option>
	<%
	for(MasRelation relation : relationList){
%>
	<option value="<%=relation.getId() %>"><%=relation.getRelationName() %></option>
	<%} %>
</select>

<label><span>*</span> Person Collected Amount</label>

<input type="text" id="personName" 	name="<%=PERSON_COLLECTED_AMT %>" readonly="readonly" value="<%=totalAdvAmt %>" validate="Person Collected Amount,String,no" />
<label>Remarks</label> <textarea name="<%=REMARKS %>" rows="2" cols="4" validate="remarks,metachar,no"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<script type="text/javascript">
var bankArray=new Array();
</script>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowForPayment();" />

<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="paymentDetails">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Refund Amt</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>
		<th scope="col"></th>
	</tr>
	<%
     	int i = 1;
    	%>
	<tr>
		<td><input type="radio" value="<%=i%>" name="selectedPayMode"
			class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %><%=i %>"
			id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
			id="amt<%=i %>" value="<%=Math.round((cashAdvAmt.subtract(refundedAmt)).doubleValue())%>" validate="amountReceived,float,no" tabindex="1"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>" 
			id="cqeId<%=i %>" tabindex="1" maxlength="20" validate="chequeNo,metachar,no" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>" 
			id="chqDate<%=i %>" tabindex="1"  validate="chequeDate,date,no" readonly="readonly" /> <img
			id="calId<%=i %>" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" style="display: none;" validate="Pick a date"
			class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
		</td>
		<td><select name="<%=BANK_NAME %>" id="bankId<%=i %>" validate="bankName,metachar,no"
			tabindex="1" disabled="disabled">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (MasBankMaster bankMaster : bankList) {
			%>
			<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
			bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>

		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRowForPayment('cashRefund');" tabindex="1" /></td>

	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Amount</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
	readonly="readonly" value="<%=Math.round((cashAdvAmt.subtract(refundedAmt)).doubleValue())%>" validate="totalAmount,float,no" />
	
<label> Balance To Be Returned</label>
<input type="text" readonly="readonly" value="<%=Math.round((cashAdvAmt.subtract(refundedAmt)).doubleValue())%>" id="balToBeRId" name="balToBeRId" onblur="totalAdvCredit1(this.value);" validate="BalanceAmount,float,no"/>

<label>Remaining Credit</label>
<input type="text" readonly="readonly" value="" id="remainCId" name="remainCId"/>
<div class="clear"></div>

<input type="checkbox" id="charitYId" class="radioCheck" value="" onclick="transferCharity(this);" /> 
<label>Refund Transfer To Charity</label>
<input type="text" id="charityTransferId" name="charityTransferId" class="" value=""
		onblur="onUpdateCharityCreditOp(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<label>Charity Name</label>
<select name="charityIdd" id="charityIdd" validate="Charity Name,string,no">
<option value="0">--Select--</option>
<%
if(masCharityList!=null && masCharityList.size()>0){
	for(MasCharityType charityy:masCharityList){ %>
	<option value="<%=charityy.getId() %>"><%=charityy.getCharityTypeName().trim() %></option>
	<%}} %>
</select>
	
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="if(checkAdvAmt()){if(validateFieldsOnSubmit()){submitForm('cashRefund','opBilling?method=submitCashRefundDetails','validateMandatory','validateChequeAndCreditCardDate');}}"
	align="right" /> <input type="button" class="button" value="Back"
	align="left" onClick="submitForm('cashRefund','opBilling?method=showCashRefundSearchJsp');" />
<input type="reset" class="buttonHighlight" value="Reset">
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

function validateMandatory(){
	var msg = "";
	if(document.getElementById('personName').value == ""){
		msg += "Person Collected Amount can not be blank.\n";
	}
	
	if(msg != ""){
		alert(msg);
		return false;
	}
	return true;
}
function checkForRelation(){
	var msg = "";
	var rel= document.getElementById('relationId').value;
	var name=document.getElementById('patientName').value ;

	if(rel == 8){
		document.getElementById('personName').value =name ;
		return true;
	}

}
function checkAdvAmt(){

var totalAmt = document.getElementById('totalAmt').value ;
var cashAdvAmt = document.getElementById('remRefAmt').value;
	if(totalAmt == "" || parseFloat(totalAmt) == 0){
		alert("Please enter Amount.");
		return false;
	}else if(parseFloat(totalAmt) > parseFloat(cashAdvAmt)){
		alert("Total Amount should be less than or equal to Remaining Refund Amount");
		return false;
	}

return true;
}

function checkPaymentMode(val, count){
	if(val == "C"){
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "";
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bankId"+count).disabled = true;
		if(document.getElementById("received"+count) != null)
			document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'none';
	}
	else if(val == "Q" || val == "R"){
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = false;
		document.getElementById("bankId"+count).disabled = false;
		if(document.getElementById("received"+count) != null)
			document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'inline';
	}else{
		document.getElementById("amt"+count).value = "";
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "";
		if(document.getElementById("received"+count) != null)
			document.getElementById("received"+count).value = "";
		document.getElementById("amt"+count).readOnly = true;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bankId"+count).disabled = true;
		document.getElementById("received"+count).readOnly = true;
		document.getElementById("calId"+count).style.display = 'none';
	}
	totalAdvAmt();
}

function totalAdvAmt(){
	var amt = 0;
	var count = document.getElementById('hiddenValuePayment').value;
	for(var i=1; i<=count; i++){
		var advAmt = eval(document.getElementById("amt"+i));
		if(validateFloat(advAmt.value)){
			if(amt != 0 && advAmt.value != ""){
				amt = parseInt(amt)+parseInt(advAmt.value);
			}else if(amt == 0 && advAmt.value != ""){
				amt = parseInt(advAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amt"+i).value = "";
			document.getElementById("amt"+i).focus();
			return false;
		}
	}
	document.getElementById('totalAmt').value = amt;
}
function totalAdvCredit1(val) {
	if (val != "") {
		document.getElementById('charityTransferId').value = '0.00';
		/* var pasDue = document.getElementById('remRefAmt').value;
		var totalCredit = parseFloat(pasDue) + parseFloat(val);
		// document.getElementById('remainCId').value=parseFloat(totalCredit).toFixed(2); */
		var actualCollect = document.getElementById('totalAmt').value;
		var netBalance = document.getElementById('balToBeRId').value;
		var balToBe = parseFloat(actualCollect) - parseFloat(netBalance);
		if (isNaN(balToBe)) {
			alert('please enter correct value.');
		} else {
			if (balToBe < 0) {
				alert('Balance to be Returned is less than 0.');
			} else {
				var remainingCredit = balToBe;
				if (remainingCredit < 0) {
					alert('Remaining credit is less than 0');
				} else {
					document.getElementById('remainCId').value = parseFloat(
							remainingCredit).toFixed(2);
				}

			}
		}
		

	}
}
</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
