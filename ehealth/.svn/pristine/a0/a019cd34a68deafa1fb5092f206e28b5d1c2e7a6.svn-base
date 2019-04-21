<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
<%@page import="jkt.hms.masters.business.MasCharityType"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlFinalBillDetails"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
	
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />

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

<form name="patientFinalSettlement" method="post" action="">
<div class="titleBg">
<h2>Patient Final Settlement</h2>
</div>
<div class="clear"></div>
<%
BigDecimal finalAmount=new BigDecimal(0);
BigDecimal a=new BigDecimal(0);
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	BigDecimal totalamt=new BigDecimal(0);
	if(map.get("finalBillList") != null){
		finalBillList = (List<BlFinalBillDetails>)map.get("finalBillList");
	}

	if (map.get("bankList") != null) {
		bankList = (List<MasBankMaster>) map.get("bankList");
	}

	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map.get("authorizerList");
	}

	if (map.get("masCharityList") != null) {
		masCharityList = (List<MasCharityType>) map.get("masCharityList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	BlChargeSlipMain blChargeSlipMain=null ;
	String pay_status="";
	if(map.get("blChargeSlipMain") != null){
		blChargeSlipMain=(BlChargeSlipMain)map.get("blChargeSlipMain");
		if(null !=blChargeSlipMain){
			
			pay_status=blChargeSlipMain.getPayStatus();
			System.out.print("pay_status  "+pay_status);
			
		}
	}
	List<Object[]>unbilledChargeList=new ArrayList<Object[]>();
	if(map.get("unbilledChargeList") != null){
		unbilledChargeList = (List<Object[]>)map.get("unbilledChargeList");
	}

	

	BigDecimal netAmt = new BigDecimal(0);
	BigDecimal totalAdvAmt = new BigDecimal(0);
	BigDecimal totalRefundAmt = new BigDecimal(0);
	BigDecimal diffAmt = new BigDecimal(0);
	BigDecimal payableAmt = new BigDecimal(0);
	
	
	BigDecimal totalsettled=new BigDecimal(0);

	for(Object[] obj:unbilledChargeList){
		if(obj[0]!=null){
			totalsettled=totalsettled.add(new BigDecimal(""+obj[0]));
		}
		System.out.println(" totalsettled by Ujjwal ---- -- >>"+totalsettled);
	%>
	   	    	
	   	    	<%
	   	    	 }

	   	    %>


<div class="clear"></div>

<!--Block One Starts-->
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
   String adv = "";
	String pastDue = "";
   int patientTypeId = 0;
   Inpatient inpatient = new Inpatient();
	int inc = 1;
   	if(finalBillList.size() > 0){
   		for(BlFinalBillDetails finalBillDetails : finalBillList){

			Patient patient = finalBillDetails.getHin();
			//patientTypeId = patient.getPatientType().getId();

			//if(patientTypeId !=1 && patientTypeId!= 4)
				netAmt = finalBillDetails.getNetAmt();
			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();
   %> <label>Final Bill No.</label> 
   <input type="text" name="<%=SETTLEMENT_NO%>"readonly="readonly" value="<%=finalBillDetails.getFinalBillNo() %>" />
<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<%
		String adNo = "";
		int inpatientId = 0;
		String ward = "";
		if(finalBillDetails.getInpatient() != null)
		{
			inpatient = finalBillDetails.getInpatient();
			inpatientId = inpatient.getId();
			adNo = inpatient.getAdNo();
			ward = inpatient.getDepartment().getDepartmentName();
		}
%> 


<%
if(finalBillDetails.getAdvAmt()!=null)
{
totalAdvAmt=(BigDecimal)finalBillDetails.getAdvAmt();
}
BigDecimal paidAmount=new BigDecimal(0);
 if(finalBillDetails.getPaidAmt()!=null && finalBillDetails.getPaidAmt().compareTo(new BigDecimal(0))==1)
{
	 paidAmount=finalBillDetails.getPaidAmt();
	//totalAdvAmt=totalAdvAmt.add(finalBillDetails.getPaidAmt());
	//totalAdvAmt=totalAdvAmt.add(finalBillDetails.getPaidAmt());
} 

			/* if(map.get("totalAdvAmt") != null){
				totalAdvAmt = (BigDecimal)map.get("totalAdvAmt");
			}
			if(map.get("totalRefundAmt") != null){
				totalRefundAmt = (BigDecimal)map.get("totalRefundAmt");
			}
			if(map.get("diffAmt") != null){
				diffAmt = (BigDecimal)map.get("diffAmt");
			} */

			String displayStringBal = "";
			String displayString = "";
			String diffAmtString =  "";
			String seqNo = "";
			if(netAmt != null){


				if(netAmt.intValue() < 0){
					if(map.get("refundNo") != null){
						seqNo = (String)map.get("refundNo");
					}

					if(totalRefundAmt.intValue() > 0){
						diffAmt = diffAmt.add(totalRefundAmt);

					}
					diffAmtString = diffAmt.toString().substring(1);
					displayStringBal = "Refundable Amt";
					displayString = "Refund";
				}else if(netAmt.intValue() >= 0){
					if(map.get("receiptNo") != null){
						seqNo = (String)map.get("receiptNo");
					}

					diffAmtString = diffAmt.toString();
					displayStringBal = "Receivable Amt";
					displayString = "Receipt";
				}
			}

			/* if(patientTypeId ==1 || patientTypeId == 4){
				payableAmt = new BigDecimal(0);
			}else{ */
				if(!diffAmtString.equals("")){
					payableAmt = new BigDecimal(diffAmtString);
				}
			/* } */
		%>

<input type="text" readonly="readonly" value="<%=adNo%> "/>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" readonly="readonly" value="<%=patient.getHinNo() %>" />
 <label>Ward</label> 
<input type="text" readonly="readonly" value="<%=ward %>" />



<label>Patient Name</label> <%
String patientName="";
patientName=patient.getPFirstName() ;
if(patient.getPMiddleName()!=null){
	patientName+=patient.getPMiddleName();
}
if(patient.getPLastName()!=null){
	patientName+=patient.getPLastName();
}

%> <input type="text" readonly="readonly" value="<%=patientName%>" />
 <label>Age</label> <input type="text" readonly="readonly" value="<%=patient.getAge() %>" />
<div class="clear"></div>

<label>Family Income Category</label><input readonly="readonly" type="text" value="
<%
String patientType="";
if(patient!=null && patient.getBplStatus()!=null && !patient.getBplStatus().equalsIgnoreCase("") && patient.getBplStatus().equalsIgnoreCase("y")){
	patientType="BPL"; %>

<%}else if(patient!=null && patient.getBplStatus()!=null && !patient.getBplStatus().equalsIgnoreCase("") && patient.getBplStatus().equalsIgnoreCase("n")){ 
patientType="APL"; %>

<%} %>
<%=patientType %>" />
<label>Social Category</label><input readonly="readonly" type="text" value="<%=patient!=null?(patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():""):""%>"/>
<label>Other Category</label><input type="text" readonly="readonly" value=""/>

<input type="hidden" id="patientTypeId" name="patientTypeId" value="<%=patient!=null?(patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():""):""%>" />
<label>Consulting Doctor</label> <input readonly="readonly" type="text" value="
<%
String doctorName="";
doctorName=inpatient.getDoctor().getFirstName();
if(inpatient.getDoctor().getMiddleName()!=null){
	doctorName+=inpatient.getDoctor().getMiddleName();
}
if(inpatient.getDoctor().getLastName()!=null){
	doctorName+=inpatient.getDoctor().getLastName();
}
%>
<%=doctorName%>" />
	<!-- 
	BigDecimal netAmt = new BigDecimal(0);
	BigDecimal totalAdvAmt = new BigDecimal(0);
	BigDecimal totalRefundAmt = new BigDecimal(0);
	BigDecimal diffAmt = new BigDecimal(0);
	BigDecimal payableAmt = new BigDecimal(0); -->
	
<input type="hidden" name="netAmount" id="netAmount" value="<%=finalBillDetails.getGrossAmt() %>" class="readOnly"
	readonly="readonly" />
<label>Net Amt</label>
<%if(finalBillDetails.getGrossAmt() !=null){ %>
 <input type="text"
	name="netAmount1" id="netAmount1" value="<%=finalBillDetails.getGrossAmt().setScale(0,BigDecimal.ROUND_DOWN) %>" class="readOnly"
	readonly="readonly" />
	<%
	

	totalamt=finalBillDetails.getGrossAmt().setScale(0,BigDecimal.ROUND_DOWN);
	
	
	a=finalBillDetails.getPaidAmt().add(finalBillDetails.getAdvAmt());
	finalAmount=finalBillDetails.getGrossAmt().subtract(a);
	System.out.println("finalAmount  jsp----->>"+finalAmount);
} %>

  <label>Total Advance</label> 
 <input type="text"
	name="advance" value="<%=finalBillDetails.getAdvAmt()!=null?finalBillDetails.getAdvAmt().setScale(0,BigDecimal.ROUND_DOWN):"0" %>" class="readOnly"
	readonly="readonly" />
	
	 <label>Total Paid</label> 
 <input type="text"
	name="<%=ADVANCE_AMOUNT %>" value="<%=finalBillDetails.getPaidAmt()!=null?finalBillDetails.getPaidAmt().setScale(0,BigDecimal.ROUND_DOWN):"0" %>" class="readOnly"
	readonly="readonly" />
	
 <input type="hidden"
	name="<%=ADVANCE_AMOUNT %>" value="<%=totalAdvAmt.setScale(0,BigDecimal.ROUND_DOWN) %>" class="readOnly"
	readonly="readonly" />
	<%BigDecimal totalPayable=new BigDecimal(0);
	totalPayable=finalBillDetails.getAdvAmt().subtract(finalBillDetails.getGrossAmt().subtract(finalBillDetails.getPaidAmt()));
	
	%>
	<% //System.out.print("1111111111111 "+finalBillDetails.getAdvAmt().subtract(finalBillDetails.getGrossAmt().subtract(finalBillDetails.getPaidAmt())));
	//System.out.print("@@ "+totalamt);
	//System.out.print("\n "+totalAdvAmt);
	//System.out.print("  \n"+paidAmount);
	//System.out.print(" \n "+totalamt.compareTo(paidAmount));
	/* if(totalamt.compareTo(paidAmount)==-1 && totalamt.compareTo(totalAdvAmt)==-1) */
	if(finalAmount.compareTo(new BigDecimal(0))==-1 ){ %>
	
	<label>Total Refundable</label>
	 <input type="text"  id="<%=REFUND_AMOUNT %>"  	name="<%=REFUND_AMOUNT %>" value="<%=totalPayable %>" class="readOnly" readonly="readonly" /> 
	<%--<input type="text"  id="<%=REFUND_AMOUNT %>"  	name="<%=REFUND_AMOUNT %>" value="<%=totalAdvAmt.subtract(totalamt) %>" /> --%>
	
	<%-- <input type="text"  id="<%=REFUND_AMOUNT %>"  	name="<%=REFUND_AMOUNT %>" value="<%=totalAdvAmt.setScale(0,BigDecimal.ROUND_DOWN) %>"
	class="readOnly" readonly="readonly" /> --%>
	
	<%-- <label>
	<input type="checkbox" name="advancetrancefer" id="advancetrancefer" onchange="updateOnRefundBal();" class="radioCheck" style="width: 10px;margin: 0;padding: 0;" />
	Transfer to Advance</label>
	<input type="text" id="advTransfer" name="advTransfer" value="0" onblur="updateOnRefundBal();"
	class="readOnly" readonly="readonly" />
	
	<label>
	<input type="checkbox" name="charitytrancefer" id="charitytrancefer" onchange="updateOnRefundBal()" class="radioCheck" style="width: 10px;margin: 0;padding: 0;" />
	Transfer to Charity</label>
	<input type="text" id="chrtTransfer" name="chrtTransfer" value="0" onblur="updateOnRefundBal()"
	class="readOnly" readonly="readonly" />
	
	<label>Charity Name</label>
<select name="charityIdd" id="charityIdd" validate="Charity Name,string,no">
<option value="0">--Select--</option>
<%
if(masCharityList!=null && masCharityList.size()>0){
	for(MasCharityType charityy:masCharityList){ %>
	<option value="<%=charityy.getId() %>"><%=charityy.getCharityTypeName().trim() %></option>
	<%}} %>
</select> --%>
	
	<%}else{
		System.out.print("sdfsdfsdc "+totalamt);
		System.out.print("totalAdvAmt "+totalAdvAmt);
		
		%>
		
	<label>Total Payabale</label>
	<%-- <input type="text" id="<%=REFUND_AMOUNT %>" 	name="<%=REFUND_AMOUNT %>" value="<%=totalamt.subtract(totalAdvAmt) %>"
	class="readOnly" readonly="readonly" />
	 --%>
	 <%if(pay_status.equalsIgnoreCase("W")){%>
			 <input type="text" id="<%=REFUND_AMOUNT %>" 	name="<%=REFUND_AMOUNT %>" value="<%=new BigDecimal(0) %>"
	class="readOnly" readonly="readonly" />
		<%} else{%>
	 <input type="text" id="<%=REFUND_AMOUNT %>" 	name="<%=REFUND_AMOUNT %>" value="<%=totalPayable.setScale(0,BigDecimal.ROUND_DOWN).multiply(new BigDecimal(1).negate()) %>"
	class="readOnly" readonly="readonly" />
	
	
	<%}} %>


<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/>
	<input 	type="hidden" name="finalBillId" value="<%=finalBillDetails.getId()%>"/>

<div class="clear"></div></div>

<div class="clear"></div>

<div style="display: none;">
<h4>Bill Details</h4>
<div class="clear"></div>

<div class="Block">
<input type="hidden" id="transTypeId" name="transType" value="<%=displayString %>"/>
<input 	type="hidden" name="diffAmt" value="<%=diffAmt %>"/>
<label><%=displayString %>No.</label> <input type="text" name="<%=SETTLEMENT_NO %>" value="<%=seqNo %>"
	class="readOnly" readonly="readonly" /> <label><%=displayString %>
Date</label> <input type="text" name="<%=SETTLEMENT_DATE%>" value="<%=date %>"
	class="readOnly" readonly="readonly" /> <label><%=displayString %>
Time</label> <input type="text" name="<%=SETTLEMENT_TIME %>" value="<%=time %>"
	class="readOnly" readonly="readonly" />

<div class="clear"></div>
</div>

	
	 <%--<%
 	String sign = "";
BigDecimal finalBlAmt = new BigDecimal(0.00);
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 				finalBlAmt = (new BigDecimal(adv)).subtract(netAmt);
 %>

 <label>Total Advance</label>
 <input type="text" name="<%=ADVANCE_AMOUNT %>" value="<%=adv %>" class="readOnly" readonly="readonly" />
<%
	}else if(!sign.equals("-")){
		finalBlAmt = (new BigDecimal(pastDue)).add(netAmt);
	%>
		<label>Past Due</label>
		 <input type="text" name="<%=ADVANCE_AMOUNT %>" value="<%=pastDue %>" class="readOnly" readonly="readonly" />

<%	}
%>
--%>


<div class="clear"></div>
<%
BigDecimal finalBlAmt = new BigDecimal(0.00);
if(totalAdvAmt.compareTo(netAmt) > 0){
	finalBlAmt = totalAdvAmt.subtract(netAmt);

}else{
	finalBlAmt = netAmt.subtract(totalAdvAmt);
}

String sign = "";
 			if (!netAmt.toString().equals("")) {
 				sign = netAmt.toString().substring(0, 1);
 			}
 			if(netAmt.intValue()<0)
 			{
 				displayStringBal = "Refundable Amt";
				displayString = "Refund";
				netAmt = new BigDecimal(netAmt.toString().substring(1));
 			}else
 			{
 				displayStringBal = "Receivable Amt";
				displayString = "Receipt";
 			}

%> 

	
	<input type="hidden" 	id="<%=BALANCE_AMOUNT %>" name="<%=BALANCE_AMOUNT %>" value="<%=totalAdvAmt.subtract(totalamt) %>"
	class="readOnly" readonly="readonly" />  
	
	<input
	type="hidden" id="roundOffId" name="<%=ROUND_OF_VALUE %>" class="readOnlySmall" readonly="readonly" /> <script
	type="text/javascript">
   var netAmt = '<%=netAmt%>';
   var roundedNetAmt = Math.round(parseFloat(<%=netAmt%>));
   if(netAmt.toString().indexOf('.') > 0)
	{
		if(roundedNetAmt > parseFloat(netAmt))
			document.getElementById('roundOffId').value = (roundedNetAmt - parseFloat(<%=netAmt%>)).toFixed(2);
		else
			document.getElementById('roundOffId').value = (parseFloat(<%=netAmt%>) - roundedNetAmt).toFixed(2);
	}
   document.getElementById('<%=BALANCE_AMOUNT %>').value = roundedNetAmt;
   </script>
<div class="clear"></div>
<label>Scheme</label>
<select name="schemeName" id="schemeId" onchange="setAmount();">
<option value="">Select</option>
<option value="jssk">JSSK</option>
</select>
<div class="clear"></div></div>

<script type="text/javascript">
var bankArray=new Array();
</script>
<div class="clear"></div>
 <div class="paddingTop15"></div>
 
 <%if(totalamt.compareTo(totalAdvAmt)==1){ %>
<h4>Discount Details</h4>
<div class="clear"></div>
<div class="Block">
<script type="text/javascript">
		var authorizerArr = new Array();
</script>
<label>Authorizer</label>
<select name="<%=AUTHORIZER_ID %>" 	id="authorizerId" disabled="disabled">
	<option value="0">Select</option>
	<%
	int counter=0;
		for (MasAuthorizer authorizer : authorizerList) {
	%>
	<option value="<%=authorizer.getId() %>"><%=authorizer.getAuthorizerName()%></option>

	<script type="text/javascript">

		authorizerArr[<%=counter%>] = new Array();
		authorizerArr[<%=counter%>][0] = <%=authorizer.getId()%>;
		authorizerArr[<%=counter%>][1] = "<%=authorizer.getAuthorizerCode()%>";
		authorizerArr[<%=counter%>][2] = "<%=authorizer.getAuthorizerName()%>";
		authorizerArr[<%=counter%>][3] = "<%=authorizer.getMinAuthorizeAmt()%>";
		authorizerArr[<%=counter%>][4] = "<%=authorizer.getMaxAuthorizeAmt()%>";

	</script>
	<%counter++;
		}
	%>
	</select>
  <div class="clear"></div>
	<label>Discount Percent</label>
	 <input type="text" id="disPercentId" 	name="<%=DISCOUNT_PERCENTAGE %>" value=""
	onblur="if(validateDis(this)){calculateDisAmt(this);populateAuthorizer(this.value);}"
	maxlength="3" />
	<label>Discount Amount</label>
	<input type="text" 	id="disAmtId" name="<%=DISCOUNT_AMOUNT %>" value=""
	onblur="if(validateDis(this)){calculateDisAmt(this);populateAuthorizer(this.value);}"
	maxlength="7" />
<div class="clear"></div>

	</div> 
<%} %>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" class="buttonDel"
	onclick="removeRowForPayment();" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<%
	String displayStrForChq = "";
	String displayStrForChqDate = "";
	if(displayString.equals("Receipt")){
		displayStrForChq = "Cheque/Credit Card No";
		displayStrForChqDate = "Cheque/Credit Card Date";
	}else{
		displayStrForChq = "Cheque No";
		displayStrForChqDate = "Cheque Date";
	}

%>
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Amount</th>
		<th scope="col"><%=displayStrForChq %></th>
		<th scope="col"><%=displayStrForChqDate %></th>
		<th scope="col">Bank</th>
		<th scope="col">&nbsp;</th>
	</tr>
	<tr>

		<td><input type="radio" value="<%=inc%>" name="selectedPayMode"
			class="radioCheck" /></td>

		<td><select name="<%=PAYMENT_MODE %>" id="paymentModeId<%=inc %>"
			onchange="checkPaymentMode(this.value,<%=inc %>);totalFinalSttmntAmt();" tabindex="1">
			<option value="">Select</option>
			<%
			if(finalBlAmt.compareTo(new BigDecimal(0)) > 0){
		%>
			<option value="C" selected="selected">Cash</option>
			<%}else{ %>
			<option value="C">Cash</option>
			<%} %>
			<option value="Q">Cheque</option>
		</select> <script type="text/javascript">

		<!------------------- Script for adding option in payment mode for transaction type Receipt ------------->

			var payMode = '<%=displayString%>'
			if(payMode == "Receipt"){
				obj = document.getElementById('paymentModeId<%=inc %>');
				var length = obj.length;
				obj.length++;
				obj.options[obj.length-1].value = "R";
				obj.options[obj.length-1].text = "Credit Card";
			}

		<!--------------- End Of script   ---------------------->

		</script></td>
		<td>
		
		<%
		BigDecimal amt1=new BigDecimal(0.00);
		/* if(totalamt.compareTo(totalAdvAmt)==-1){  */
			if(totalamt.compareTo(paidAmount)==-1 ){ 
	//amt1=totalAdvAmt.subtract(totalamt) ;
	amt1=totalAdvAmt ;
		}else{ 
			amt1=totalamt;
		/* amt1=totalamt.subtract(totalAdvAmt); */
	}
			if(pay_status.equalsIgnoreCase("W")){
				amt1=new BigDecimal(0);
			}
		%>
	
		<input type="text" name="<%=AMOUNT %>" id="amt<%=inc %>"
			value="<%=totalsettled.setScale(0,BigDecimal.ROUND_DOWN)%>"
			validate="Advance Amount,string,no" onblur="totalFinalSttmntAmt();"
			tabindex="1" maxlength="10" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%>"
			id="cqeId<%=inc %>" tabindex="1" maxlength="16"
			onblur="validateCheque(this.value,<%=inc %>);" readonly="readonly" />
		</td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %>"
			id="chqDate<%=inc %>" tabindex="1" readonly="readonly" /> <img
			id="calId<%=inc %>" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" style="display: none;" validate="Pick a date"
			class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=inc %>'),event)" />
		</td>
		<td><select name="<%=BANK_NAME %><%=inc%>" id="bankId<%=inc %>"
			tabindex="1" disabled="disabled">
			<option value="">Select</option>
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

		<td><input type="button" name="add" class="buttonAdd"
			onclick="addRowForPayment('finalSettlement');" tabindex="1" /></td>

	</tr>

</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />
<div class="clear"></div>
<div class="Block">
<div class="floatRight"><label>Total Amount</label>
<%if(totalamt.compareTo(paidAmount)==-1  ){
	
	%>

	
	<input 	type="text" id="<%=TOTAL_AMOUNT %>" name="<%=TOTAL_AMOUNT %>"
value="<%=totalsettled.setScale(0,BigDecimal.ROUND_DOWN) %>" validate="Total Amount,string,no"
	class="readOnly" readonly="readonly" />
	<%}else{
		if(pay_status.equalsIgnoreCase("W")){
			System.out.print(" ##############dshds ");
		
		%>
	
	<input 	type="text" id="<%=TOTAL_AMOUNT %>" name="<%=TOTAL_AMOUNT %>"
value="<%=new BigDecimal(0) %>" validate="Total Amount,string,no"
	class="readOnly" readonly="readonly" />	
	<%}else{ %>
	<input 	type="text" id="<%=TOTAL_AMOUNT %>" name="<%=TOTAL_AMOUNT %>"
value="<%=totalsettled.setScale(0,BigDecimal.ROUND_DOWN) %>" validate="Total Amount,string,no"
	class="readOnly" readonly="readonly" />	
<%}} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="if(checkBalanceAmt()){if(validateFieldsOnSubmit()){submitForm('patientFinalSettlement','billing?method=submitBillingFinalSettlementDetails','validateChequeAndCreditCardDate')}};"
	align="right" /> 
	
	<input type="button" class="button" value="Back"
	align="left"
	onClick="submitForm('patientFinalSettlement','billing?method=showSearchJspForDepositAndSettlement&flag=searchFinalSettlement');" />
<input type="reset" class="buttonHighlight" value="Reset"/>
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
<%}

		}
		%>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">

<%-- function calculateDisAmt(obj){
	var amount =0;
	var blanceAmount = 0;
    blanceAmount = parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value)
	amount=parseFloat(document.getElementById('netAmount').value);



/*	if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/


	var charityOn = parseFloat(amount) ;

	var disAmount = 0;

	if(obj.value != ""){
		if(validateFloat(obj.value)){

			if(obj.id == 'disPercentId'){
				/*if(document.getElementById('disPercentId').value >= 100){
					alert(" Discount Percent should be less than 100.");
					document.getElementById('disPercentId').value = "";
					document.getElementById('disAmtId').value = "";
					return false;
				}*/
				disAmount = parseFloat(document.getElementById('disPercentId').value)*(charityOn).toFixed(2)/100;
				document.getElementById('disAmtId').value = parseFloat(disAmount).toFixed(2);
			if(obj.readOnly == false)
				document.getElementById('disAmtId').readOnly = true;
			}else if(obj.id == 'disAmtId'){
				disAmount = document.getElementById('disAmtId').value;

				if(disAmount>=0)
				{
				if(disAmount >= charityOn ){
					alert("Discount Amount can not be greater than "+charityOn.toFixed(2));
					document.getElementById('disAmtId').value = "";
					return false;
				}
				}
				else
				{
				alert("Discount Amount can not be less than 0");
				}
				if(obj.readOnly == false)
					document.getElementById('disPercentId').readOnly = true;


			}

			var totalNetAmt = parseFloat(amount)- parseFloat(disAmount).toFixed(2);
		//	document.getElementById('netAmtId').value = parseFloat(totalNetAmt).toFixed(2);

			document.getElementById('netAmount1').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
			document.getElementById('<%=BALANCE_AMOUNT %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
			document.getElementById('<%=TOTAL_AMOUNT %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
			document.getElementById('amt<%=inc %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);

			populateAuthorizer(parseFloat(disAmount).toFixed(2));
			document.getElementById('authorizerId').disabled = false;
			return true;
		}else{
			alert("Discount should be integer or decimal value.");
			document.getElementById('disPercentId').value = "";
			document.getElementById('disAmtId').value = "";
			document.getElementById('disPercentId').readOnly = false;
			document.getElementById('disAmtId').readOnly = false;
			return false;
		}
	}else{
	if(obj.readOnly == false){
		document.getElementById('disPercentId').value = "";
		document.getElementById('disAmtId').value = "";
		document.getElementById('disPercentId').readOnly = false;
		document.getElementById('disAmtId').readOnly = false;
		}
	}

}
 --%>
 
 function calculateDisAmt(obj){
	 
	 
		var amount =0;
		var blanceAmount = 0;
	    blanceAmount = parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value)
	    
	    if(parseFloat(blanceAmount)>=0)
	    	{
		amount=parseFloat(document.getElementById('netAmount').value);



	/*	if(document.getElementById('paidAmtId').value != "")
			amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/


		var charityOn = parseFloat(blanceAmount) ;

		var disAmount = 0;

		if(obj.value != ""){
			if(validateFloat(obj.value)){

				if(obj.id == 'disPercentId'){
					if(document.getElementById('disPercentId').value >= 100){
						alert(" Discount Percent should be less than 100.");
						document.getElementById('disPercentId').value = "";
						document.getElementById('disAmtId').value = "";
						document.getElementById('refundAmt').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('amt1').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('totalAmount').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						
						return false;
					}
					disAmount = parseFloat(document.getElementById('disPercentId').value)*(charityOn).toFixed(2)/100;
					document.getElementById('disAmtId').value = parseFloat(disAmount).toFixed(2);
					document.getElementById('refundAmt').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
					document.getElementById('amt1').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
					document.getElementById('totalAmount').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
				if(obj.readOnly == false)
					document.getElementById('disAmtId').readOnly = true;
				}else if(obj.id == 'disAmtId'){
					disAmount = document.getElementById('disAmtId').value;
					if(disAmount>=0)
					{
					if(disAmount > charityOn ){
						document.getElementById('disAmtId').value = "";
						document.getElementById('disPercentId').value = "";
						document.getElementById('refundAmt').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('amt1').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('totalAmount').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						alert("Discount Amount can not be greater than "+charityOn.toFixed(2));
						
						return false;
					}
					document.getElementById('refundAmt').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
					document.getElementById('amt1').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
					document.getElementById('totalAmount').value=parseFloat(document.getElementById('<%=BALANCE_AMOUNT %>').value-disAmount).toFixed(2);
					}
					else
					{
						ddocument.getElementById('disAmtId').value = "";
						document.getElementById('disPercentId').value = "";
						document.getElementById('refundAmt').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('amt1').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
						document.getElementById('totalAmount').value=document.getElementById('<%=BALANCE_AMOUNT %>').value;
					alert("Discount Amount can not be less than 0");
					}
					if(obj.readOnly == false)
						document.getElementById('disPercentId').readOnly = true;


				}

				<%-- var totalNetAmt = parseFloat(amount)- parseFloat(disAmount).toFixed(2);
			//	document.getElementById('netAmtId').value = parseFloat(totalNetAmt).toFixed(2);

				document.getElementById('netAmount1').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
				document.getElementById('<%=BALANCE_AMOUNT %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
				document.getElementById('<%=TOTAL_AMOUNT %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2);
				document.getElementById('amt<%=inc %>').value = ((parseFloat(document.getElementById('netAmount').value))-parseFloat(disAmount)).toFixed(2); --%>

				populateAuthorizer(parseFloat(disAmount).toFixed(2));
				document.getElementById('authorizerId').disabled = false;
				return true;
			}else{
				alert("Discount should be integer or decimal value.");
				document.getElementById('disPercentId').value = "";
				document.getElementById('disAmtId').value = "";
				document.getElementById('disPercentId').readOnly = false;
				document.getElementById('disAmtId').readOnly = false;
				document.getElementById('authorizerId').disabled = true;
				return false;
			}
		}else{
		if(obj.readOnly == false){
			document.getElementById('disPercentId').value = "";
			document.getElementById('disAmtId').value = "";
			document.getElementById('disPercentId').readOnly = false;
			document.getElementById('disAmtId').readOnly = false;
			}
		}
	    	}
	    else{
	    	alert('Discount is not allowed');
	    	document.getElementById('disPercentId').value = "";
			document.getElementById('disAmtId').value = "";
			document.getElementById('disPercentId').readOnly = true;
			document.getElementById('disAmtId').readOnly = true;
	    }

	}


function validateDis(obj){
	if(!validateFloat(obj.value)){
		alert("Discount should be integer or decimal value.");
		document.getElementById(obj.id).value = "";
		return false;
	}else
		return true;

}

function checkBalanceAmt(){
		var balanceAmt = document.getElementById('refundAmt').value;
		var totalAmt = document.getElementById('<%=TOTAL_AMOUNT %>').value;
		var str = '<%=netAmt%>';

	<%-- <%
		if(patientTypeId != 8 && patientTypeId != 1 && patientTypeId != 2){
	%> --%>
 
		if(totalAmt <= 0 && str != 0){
//			alert("Please enter settlement amount "+balanceAmt);
	//		return false;
		}else if(parseFloat(totalAmt) != 0){
			if(Math.round(parseFloat(totalAmt)) < Math.round(parseFloat(balanceAmt))){
//			alert("Total Amount should not be greater than "+str+"sss"+Math.round(parseFloat(totalAmt))+"balance++"+parseFloat(balanceAmt) );
				alert("Total Amount should not be less than "+balanceAmt );
				return false;
			}
		}

<%-- <%}%> --%>

		if(totalAmt != ""){
			if(Math.round(parseFloat(totalAmt)) > Math.round(parseFloat(balanceAmt))){
					alert("Total Amount should not be greater than "+str );
				   document.getElementById('<%=TOTAL_AMOUNT %>').value = "";
				return false;
			}
		}
		return true;
}
function setAmount(){
	alert("in method");
	var netAmount=document.getElementById("netAmount1").value;
	var scheme=document.getElementById("schemeId").value;
	alert("scheme--->"+scheme)
	if(scheme!=""){
	var amt=Math.round(parseFloat(netAmount));
	//alert("netAmount  --> "+amt);
		if(amt<0){
				//alert("Negative Value");
			}else {
				alert("Positive Value");

				document.getElementById("netAmount").value='0.0';
				document.getElementById("<%=TOTAL_AMOUNT %>").value='0.0';
				document.getElementById("amt1").value='0.0';
				document.getElementById("balanceAmount").value='0.0';
				
				
			}
}}

function updateOnRefundBal()
{
	document.getElementById("amt1").value=document.getElementById("<%=BALANCE_AMOUNT %>").value;
	document.getElementById("totalAmount").value=document.getElementById("<%=BALANCE_AMOUNT %>").value;
	if(document.getElementById("advancetrancefer")!=null && document.getElementById("advancetrancefer").checked)
		{
		document.getElementById("advTransfer").readOnly=false;
		if(document.getElementById("advTransfer").value!="" && !isNaN(document.getElementById("advTransfer").value))
			{
			if(parseFloat(document.getElementById("advTransfer").value)<=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value))
			{
				document.getElementById("amt1").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value);
				document.getElementById("totalAmount").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value);
				document.getElementById("<%=REFUND_AMOUNT %>").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value);

			}
			else
				{
				
				alert("Advance transfer amount is greater than refundable amount.");
				document.getElementById("advTransfer").value='0.00';
				}
			
			}
		}
	else
		{
		document.getElementById("advTransfer").readOnly=true;
		document.getElementById("advTransfer").value='0.00';
		}
	
	if(document.getElementById("charitytrancefer")!=null && document.getElementById("charitytrancefer").checked)
	{
	document.getElementById("chrtTransfer").readOnly=false;
	 document.getElementById("charityIdd").setAttribute("validate", "Charity Name,int,yes");
	if(document.getElementById("chrtTransfer").value!="" && !isNaN(document.getElementById("chrtTransfer").value))
		{
		if(parseFloat(document.getElementById("chrtTransfer").value)<=parseFloat(document.getElementById("<%=REFUND_AMOUNT %>").value))
		{
			document.getElementById("<%=REFUND_AMOUNT %>").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value)- parseFloat(document.getElementById("chrtTransfer").value);
			document.getElementById("amt1").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value)- parseFloat(document.getElementById("chrtTransfer").value);
			document.getElementById("totalAmount").value=parseFloat(document.getElementById("<%=BALANCE_AMOUNT %>").value)-parseFloat(document.getElementById("advTransfer").value)- parseFloat(document.getElementById("chrtTransfer").value);
		}
		else
			{			
			alert("Charity transfer amount is greater than refundable amount.");
			document.getElementById("chrtTransfer").value='0.00';
			}
		
		}
	}
else
	{
	 document.getElementById("charityIdd").setAttribute("validate", "Charity Name,int,no");
	document.getElementById("chrtTransfer").readOnly=true;
	document.getElementById("chrtTransfer").value='0.00';
	}
}

</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

