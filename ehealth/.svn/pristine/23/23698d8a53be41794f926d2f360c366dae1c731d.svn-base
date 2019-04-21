<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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

<form name="search" method="post" action="">
<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");
	  }
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
  	  }
	  String distype="";
	  if(map.get("distype")!=null){
			distype=(String)map.get("distype");
		}
	  
%>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Bill Settelment</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>

<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30"
 onblur="submitForm('search','billing?method=getPatientDetailsForFinalBill','checkAdNo');" />
</div>

<label >Final Bill No</label>
  <select name="billNumber" id="billId">
    <option>001</option>
    <option>002</option>
    <option>003</option>
    
  </select>
<div class="clear"></div>

</div>
<div class="Block">
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30" onblur="submitForm('search','billing?method=getPatientDetailsForFinalBill','checkAdNo');" />
</div>
<label>Ward</label> <input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<div class="clear"></div>
<label>Patient Name</label>
<%-- <%
	if (patient.getPFirstName() != null)
	{
		String Pname = "";
		Pname = patient.getPFirstName();
		if(patient.getPMiddleName() != null)
		{
			Pname = Pname.concat(" ").concat(patient.getPMiddleName());
		}
		if(patient.getPLastName() != null)
		{
			Pname = Pname.concat(" ").concat(patient.getPLastName());
		}
%> --%>
 		<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<%-- <%
	}
%> --%>
<label>Age</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
	
<label>Patient Category</label> <label class="value"><%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<%-- <%
 	if(patient.getCompany() != null){
 		if(patient.getPatientType().getId() == 1){
 %> --%>
 
 <div class="clear"></div>
 <label>Advance Amount</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
 <label>Total Payment Dues</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<label>Total Refund to Pay</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<div class="clear"></div>
<label>Consultaion Doctor</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<label>Total Receviable Amount</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<label>Total Reveived Amount</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />
<label>Balance Amount</label> <label class="value"> <%="" %></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=finalBill');}" />


</div>
<div class="Block">
<div class="paddingTop15"></div>
	<h4>Payment Details</h4>
	<div class="clear"></div>
	<input type="button" name="delete" class="buttonDel"
		onclick="removeRowForPayment();" />
	<input type="button" name="add" class="buttonAdd"
				onclick="addRowForPayment('billServicing');" />
	<div class="clear"></div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		id="paymentDetails">

		<tr>
			<th scope="col"></th>
			<th scope="col">Payment Mode</th>
			<th scope="col">Amount</th>
			<th scope="col">Cheque/Credit Card No</th>
			<th scope="col">Cheque/Credit Date</th>
			<th scope="col">Bank</th>
			
		</tr>
		<td><input type="checkbox" value="" name="selectedPayMode"
				class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %>"
				id="paymentModeId"
				onchange="checkPaymentMode(this.value);">
				<option value="">Select</option>
				<option value="C" selected="selected">Cash</option>
				<option value="Q">Cheque</option>
				<option value="R">Credit Card</option>
			</select></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %>"
				id="amt" value="" validate="Amount,string,no"
				maxlength="9"
				onblur="if(validateAmount(this.value)){calculateOutstandingAmt();};" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%>"
				id="cqeId" maxlength="20" readonly="readonly"
				onblur="validateCheque(this.value );" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %>"
				id="chqDate" readonly="readonly"
				onblur="validateChequeAndCreditCardDate();" /> <img
				id="calId" src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" style="display: none;" validate="Pick a date"
				class="calender"
				onclick="setdate('<%=date %>',document.getElementById('chqDate'),event);" />
			</td>
		<td><select name="<%=BANK_NAME %>" id="bankId"
				disabled="disabled">
				<option value="0">Select</option>
				
			</select></td>
		</table>
		<div class="clear"></div>
<div class="clear"></div>
<input class="button" type="button" onclick="submitForm('searchChargeSlipCancel','billing?method=cancelChargeSlip');" value="Submit" name="Submit11">
<input class="button" type="button" onclick="submitForm('searchChargeSlipCancel','billing?method=cancelChargeSlip');" value="Reset" name="Submit11">
</div>



<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>

<div id="error"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
			
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>


<script type="text/javascript">
document.getElementById('hinNoId').focus();
</script>



