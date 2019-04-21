<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.BlPackageBill"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceHeader"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispHeader"%>
<%@page import="jkt.hms.masters.business.BlReceiptHeader"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="finalBill" method="post" action="">
<%

	Map<String,Object> map = new HashMap<String,Object>();
	List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
	List<Object[]> chargeSlipList = new ArrayList<Object[]>();
	List<Object[]> dispenseDetailsList = new ArrayList<Object[]>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<BlPackageBill> packageBillList = new ArrayList<BlPackageBill>();
	List<Object[]> paidAmtList = new ArrayList<Object[]>();

	List<Object[]> adviceDtList = new ArrayList<Object[]>();
	List<Object[]> adviceDispDtList = new ArrayList<Object[]>();
	List<Object[]> receiptHeaderList = new ArrayList<Object[]>();


	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

	BigDecimal paidAmt = new BigDecimal(0);
	BigDecimal pkgPaidAmt = new BigDecimal(0);
	String finalBillNo = "";
	if(map.get("patientDetailsList") != null){
		patientDetailsList = (List<Inpatient>)map.get("patientDetailsList");
	}
	if(map.get("chargeSlipList") != null){
		chargeSlipList = (List<Object[]>)map.get("chargeSlipList");
	}
	if(map.get("dispenseDetailsList") != null){
		dispenseDetailsList = (List)map.get("dispenseDetailsList");
	}
	if(map.get("paidAmtList") != null){
		paidAmtList = (List)map.get("paidAmtList");
	}
	if(map.get("adviceDtList") != null){
		adviceDtList = (List)map.get("adviceDtList");
	}
	if(map.get("adviceDispDtList") != null){
		adviceDispDtList = (List)map.get("adviceDispDtList");
	}
	if(map.get("receiptHeaderList") != null){
		receiptHeaderList = (List)map.get("receiptHeaderList");
	}
	BigDecimal totalAdvAmt = new BigDecimal(0);
	if(map.get("totalAdvAmt") != null){
		totalAdvAmt = (BigDecimal)map.get("totalAdvAmt");
	}

	if(paidAmtList.size() > 0){
		for(Object[] obj : paidAmtList){
			paidAmt = paidAmt.add((BigDecimal)obj[0]);
			if(obj[1].equals("pkb")){
				pkgPaidAmt = (BigDecimal)obj[0];
			}
		}
	}
	
	if(map.get("finalBillNo") != null){
		finalBillNo = (String)map.get("finalBillNo");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map.get("authorizerList");
	}
	if (map.get("packageBillList") != null) {
		packageBillList = (List<BlPackageBill>) map.get("packageBillList");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	int mainChargeId = 0;
	int itemId = 0;
	int inpatientId = 0;
	  String adNo = "";
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int bookingId = 0;
	if(map.get("bookingId") != null){
		bookingId = (Integer)map.get("bookingId");
	}
	System.out.println("bookingId= in jsp========"+bookingId);

	BigDecimal totalAmt = new BigDecimal(0);
	BigDecimal totalAmtForCharge = new BigDecimal(0);
	BigDecimal totalAmtDispense = new BigDecimal(0);
	BigDecimal totalAmtPkg = new BigDecimal(0);
	int patientTypeId = 0;
	int hinId=0;
	int consultDoc=0;
	String age = "";

	if(patientDetailsList.size() > 0){
     %> <!--Block One Starts-->

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
		String pastDue = "";


Set<BlReceiptHeader> receiptSet = new HashSet<BlReceiptHeader>();
BigDecimal adv = new BigDecimal(0.00);
   		for(Inpatient inpatient : patientDetailsList){
   		 Patient patient = inpatient.getHin();
   		 if(patient.getPatientType()!=null){
   		 patientTypeId = patient.getPatientType().getId();
   		 }
   		hinId=patient.getId();
   			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();

   			 /* if(inpatient.getBlReceiptHeaders() != null){
   				receiptSet = inpatient.getBlReceiptHeaders();
   				if(receiptSet.size() > 0){
	   				for(BlReceiptHeader receiptHeader : receiptSet){
	   					if(receiptHeader.getReceiptType().equals("adv")){
	   						adv  = adv.add(receiptHeader.getAmount());
	   					}

	   				}
   				}
   			} */
   			
   			
   			if(receiptHeaderList.size() > 0){
   				for(Object[] obj : receiptHeaderList){
   					adv = adv.add((BigDecimal)obj[0]);
   					
   				}
   			}

%>
<div class="clear"></div>
<label>Final Bill No.</label> 
<input type="text" readonly="readonly" value="<%=inpatient.getAdNo() %>" />
<label>IP No.</label> <%
		  
		    String ward = "";
		   	//if(!inpatient.getAdStatus().equals("D")){
					inpatientId = inpatient.getId();
					adNo = inpatient.getAdNo();
					ward = inpatient.getDepartment().getDepartmentName();
			//}
	    %> 
<input type="text" readonly="readonly" value="<%=adNo%>" />
 <label>Ward</label> 
<input type="text" readonly="readonly" value="<%=ward %>" />
<div class="clear"></div>
<label>UHID</label> 
<input type="text" readonly="readonly" value="<%=patient.getHinNo() %>" />
<label>Patient Name</label> 
<%
	String pName= "";
		if(patient.getPFirstName() != null)
		{
			pName = patient.getPFirstName();
		}
		if(patient.getPMiddleName() != null)
		{
			pName += " "+patient.getPMiddleName();
		}
		if(patient.getPLastName() != null)
		{
			pName += " "+patient.getPLastName();
		} %>
 <input type="text" readonly="readonly" value=" <%= pName%>" />

		<%
	
		String currentAge = "";
		age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());	%>
<label>Age</label> 
<input type="text" readonly="readonly" value=" <%=currentAge %>" />
<div class="clear"></div>

<label>Patient Type</label> 
<%if(patient.getPatientType()!=null){ %>
<input type="text" readonly="readonly" value="<%=patient.getPatientType().getPatientTypeName() %>" />
<%}else{ %>
<input type="text" readonly="readonly" value="-" />
<%} %>
<%	 
if(patient.getPatientType()!=null){
if(patient.getPatientType().getId() == 1){ %>
<label>Company</label> <%}else if(patient.getPatientType().getId() == 4){ %>
<label>Project</label> <%}} %> 
<%	if(patient.getCompany() != null){ %>
<input type="text" readonly="readonly" value="<%=patient.getCompany().getCompanyName() %>" />


<input type="hidden" id="companyId" name="companyId" value="<%=patient.getCompany().getId() %>" />
<%} %>
 <input type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>" value="<%=patientTypeId %>" />

<div class="clear"></div>

<%--
<label>Past Due</label> --%>
<%if(inpatient.getHin().getPastDue() !=null){ %>
<input type="hidden" id="pastDue" value="<%=new BigDecimal(inpatient.getHin().getPastDue()) %>" name="pastDue" 
			readonly="readonly" /> <%}else{ %>
<input type="hidden" id="pastDue" value="" name="pastDue" class="readOnly" readonly="readonly" /><%} %>
<label>Consulting Doctor</label>
<input type="text" readonly="readonly" value="<%=inpatient.getDoctor().getFirstName()+" "+inpatient.getDoctor().getMiddleName() + " "+
						inpatient.getDoctor().getLastName() %>"/>
<input type="hidden" name="ConsultId" value="<%=inpatient.getDoctor().getId() %>"/>
 <!--<label> </label>
 --><input type="text" id="pastDue111" value="" name="pastDue111" class="readOnly" readonly="readonly" />
 
 <div class="clear"></div>

<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" id="hinId"/>
<input type="hidden" name="bookingId" value="<%=bookingId %>" id="bookingId"/>
<input type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" id="hinNo"/>
<input	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>" />
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo%>" /> 
<input type="hidden" name="<%=AGE %>" value="<%=currentAge%>" /> 
<input type="hidden" name="<%=SEX_ID %>" value="<%=patient.getSex().getId()%>" /> 
<input type="hidden" name="<%=PATIENT_NAME %>" value="<%=patient.getPFirstName()+" "+patient.getPLastName()%>" /> <%} %>
</div>
<%
if(packageBillList.size() > 0){
%>
<div class="clear"></div>
<h4>Package Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="pkgDetailsTable">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Package Description</th>
		<th scope="col">Amount</th>
	</tr>
	<%
   	  	int k=1;
   	  	for(BlPackageBill packageBill : packageBillList){
   	  %>
	<tr>
		<td><%=k %></td>
		<td><%=packageBill.getPackage().getPackageDesc() %></td>
		<td><%=packageBill.getNetPkgAmt() %></td>
	</tr>
	<%
   	totalAmtPkg = totalAmtPkg.add(packageBill.getNetPkgAmt());
   	  	} %>

</table>
<%} %>
<div class="clear"></div>

<%
if(chargeSlipList.size() > 0){
%>
<div class="clear"></div>
<h4>Charge Details</h4>
<div class="clear"></div>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetailsTable">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Main Charge Code</th>
		<th scope="col">Qty</th>
		<th scope="col">Amount</th>
	</tr>
	<%
   	    	int i =1;
	    		for(Object[] obj : chargeSlipList){
    		//	BigDecimal qty =new BigDecimal(0);
	   	 	//	BigDecimal advQty =new BigDecimal(0);
	   	 		long qty =0;
	   	 		long advQty=0;
		    	BigDecimal advAmt = new BigDecimal(0);
		    	BigDecimal advCharityDispAmt = new BigDecimal(0);
    			BigDecimal amt =new BigDecimal(0);
    			mainChargeId = (Integer)obj[0];
    			//qty = (BigDecimal)obj[2];
    			qty=(Long)obj[2];
    			if((BigDecimal)obj[3] != null)
    				amt = (BigDecimal)obj[3];
    			for(Object[] advObj : adviceDtList){
    				if(mainChargeId == (Integer)advObj[0]){
    					if(advObj[2] != null)
    						advQty = (Integer)advObj[2];
    					if(advObj[3] != null)
    						advAmt = (BigDecimal)advObj[3];
    					if(advObj[4] != null)
    						advCharityDispAmt = (BigDecimal)advObj[4];
    				}
    				
    			}
    			
    			if((qty-advQty) > 0 ){
   	    %>
	<tr style="cursor: pointer;"
		onclick="openPopUpForCharge(<%=mainChargeId %>,<%=i %>);">
		<td><%=i %></td>
		<td><%=(String)obj[1] %></td>
		<!-- - <td><%=(qty -advQty)%></td> -->
		<td><input type="text" id="totalQtyId<%=i %>" name="totalQuantity" 
					value="<%=(qty -advQty)%>" size="5" readonly="readonly" class="readOnly" />
					
					<input type="hidden" id="totalQtyIdHide<%=i %>" name="totalQuantityHide" 
					value="<%= (qty -advQty)%>" size="5" readonly="readonly" class="readOnly" /></td>
					
		<!-- - <td><%=amt.subtract(advAmt.subtract(advCharityDispAmt))%></td> -->
		<td>
		<input type="text" id="totalCostId<%=i %>"  name="totalAmount<%=i %>" size="10"
			value="<%=amt.subtract(advAmt.subtract(advCharityDispAmt))%>" readonly="readonly" class="readOnly"
			 />
		<input type="hidden" id="totalCostIdHide<%=i %>"  name="totalAmountHide<%=i %>" size="10"
			value="<%=amt.subtract(advAmt.subtract(advCharityDispAmt))%>" readonly="readonly" class="readOnly"
			 /></td>
	</tr>
	<%
   	 totalAmtForCharge = totalAmtForCharge.add(amt.subtract(advAmt.subtract(advCharityDispAmt)));
   	    	i++;}
	    		}
   	    %>
</table>
<input type="hidden" value="<%=i %>" name="hiddenValueCharge" id="hiddenValueCharge" />
<%} %>
<div class="clear"></div>
<%
	if(dispenseDetailsList.size() > 0){
%>
<h4>Dispensing Details</h4>
<div class="clear"></div>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetailsTable">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Item Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Amount</th>
	</tr>
	<%
   	    	int j =1;
	 		for(Object[] obj : dispenseDetailsList){
			   	BigDecimal advDispQty =new BigDecimal(0);
			 	BigDecimal advDispAmt = new BigDecimal(0);
			 	BigDecimal advCharityDispAmt = new BigDecimal(0);
	 			BigDecimal dispQty =new BigDecimal(0);
	 			BigDecimal dispAmt =new BigDecimal(0);
	 			itemId = (Integer)obj[0];
	 			dispQty = (BigDecimal)obj[2];
	 			dispAmt = (BigDecimal)obj[3];
	 			for(Object[] advObj : adviceDispDtList){
	 				if(itemId == (Integer)advObj[0]){
	 				  	advDispQty = (BigDecimal)advObj[2];
	 					advDispAmt = (BigDecimal)advObj[3];
	 					advCharityDispAmt = (BigDecimal)advObj[4];
	 				}
	 			}
	 			if((dispQty.subtract(advDispQty)).compareTo(new BigDecimal(0)) > 0){
   	    %>
	<tr style="cursor: pointer;" onclick="openPopUpForItem(<%=itemId %>,<%=j %>);">
		<td><%=j %></td>
		<td><%=(String)obj[1] %></td>
		<!-- - <td><%= dispQty.subtract(advDispQty)%></td> -->
		<td><input type="text" id="totalQtyDisId<%=j %>" name="totalQuantity" 
					value="<%= dispQty.subtract(advDispQty)%>" size="5" readonly="readonly" class="readOnly" />
		<input type="hidden" id="totalQtyDisIdHide<%=j %>" name="totalQuantityHide" 
		value="<%= dispQty.subtract(advDispQty)%>" size="5" readonly="readonly" class="readOnly" /></td>
					
		<!-- - <td><%=dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt))%></td> -->
		<td style="text-align: right;">
		<div class="floatRight">
		<input type="text" id="totalCostDisId<%=j %>" style="text-align: right;" name="totalAmount<%=j %>" size="10"
			value="<%=dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt))%>" readonly="readonly" class="readOnly"
			 />
			 <input type="hidden" id="totalCostDisIdHide<%=j %>"  name="totalAmountHide<%=j %>" size="10"
			value="<%=dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt))%>" readonly="readonly" class="readOnly"
			 /></div></td>
	</tr>
	<%
   	 totalAmtDispense = totalAmtDispense.add(dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt)));
   	    	j++;}
	 		}

   	    %>
</table>
<input type="hidden" value="<%=j %>" name="hiddenValue" id="hiddenValue" />
<%}
	totalAmt = totalAmtForCharge.add(totalAmtDispense).add(totalAmtPkg);
	%> <script type="text/javascript">
		var authorizerArr = new Array();
</script>
<div class="clear"></div>
<!-- <input type="button" name="sss" align="right" class="button" value="Other Item" onclick="openItemPopup();" /> -->

<div class="Block">
<div class="clear"></div>
<div class="floatRight">
<label class="auto">Gross Total</label> <input type="text" class="readOnlySmall" id="totalAmtId"
	name="<%=TOTAL_AMOUNT %>" value="<%=totalAmt %>" readonly="readonly"  onblur="calculateNetAmt();"/>
</div>
<div class="clear"></div>
<div class="floatRight"><label class="auto"> Dispensing Total</label> <input type="text" class="readOnlySmall" id="totalDisId"
	name="totalDisId" value="<%=totalAmtDispense %>" readonly="readonly" />
</div>
<div class="clear"></div>	
<div class="floatRight"><label onclick="openPopUpForReceipt();" class="auto">Cash Paid</label> <%
 	if(paidAmt == null){
 		paidAmt = new BigDecimal(0);
 	}%> 
 <input type="text" id="paidAmtId" name="<%=PAID_AMOUNT %>"	value="<%=paidAmt.subtract(totalAdvAmt) %>"
	onclick="openPopUpForReceipt();" readonly="readonly" class="readOnlySmall" />
</div>

<input type="hidden" class="readOnlySmall" id="totalAmtId2"	name="totalAmtId2" value="<%=totalAmt %>"/>

<div class="clear"></div>
<div class="floatRight">

<label class="auto">Net Amount</label>
<%BigDecimal netAmt = new BigDecimal(0);
 if(patientTypeId == 2 || patientTypeId == 8){
	 netAmt = new BigDecimal(0);
 }else{
 	if(paidAmt != null){
 		netAmt = totalAmt.subtract(paidAmt.subtract(totalAdvAmt));
 	}else{
 		netAmt =totalAmt;
 	}
 }
 %>
 <input type="text" class="readOnlySmall" id="netAmtId" name="<%=NET_AMOUNT %>" 
	value="<%=Math.ceil(netAmt.floatValue()) %>" readonly="readonly"  />
<input 	type="hidden" id="netAmtHiddenId" value="<%=Math.ceil(netAmt.floatValue()) %>" />
</div>
<div class="clear"></div>
<div class="floatRight">
<label class="auto">Advance Amount</label>
<input type="text" id="advAmt" value="<%=adv %>" class="readOnlySmall" name="advAmt" readonly="readonly" />
</div>
<div class="clear"></div>
<div class="floatRight">
 <label class="auto">Total Payment Dues</label> <!--<input type="text" id="pastDue" value="<%=new BigDecimal(pastDue) %>" 
name="pastDue" class="readOnly" readonly="readonly"/> <label class="value"> <%=paidAmt.subtract(adv) %></label>-->
<input type="text" id="pastDue" value="<%=netAmt.subtract(adv) %>" name="pastDue" 
 			readonly="readonly" class="readOnlySmall" />
<input type="hidden" id="pastDueHidden" value="<%=new BigDecimal(pastDue) %>" name="pastDueHidden" 
			class="readOnly" readonly="readonly" />
					
</div>	

<div class="clear"></div>
<div class="floatRight">
<label class="auto">*(-) Indicate Refund To Patients</label>			
</div>
</div>

<div class="Block">
<label>Authorizer</label> <select name="<%=AUTHORIZER_ID %>" id="authorizerId" disabled="disabled">
	<option value="0">Select</option>
	<%	int counter=0;
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
</select> <%-- <label>Total Package Amount</label> <input type="text" class="readOnlySmall" id="totalPkgAmtId"
	name="<%=TOTAL_PACKAGE_VALUE %>" value="<%=totalAmtPkg %>" readonly="readonly" /> --%>

<div class="clear"></div>

<label>Discount Percent</label>
<input type="text" id="disPercentId" name="<%=DISCOUNT_PERCENTAGE %>" value=""
	onblur="if(validateDis(this)){calculateDisAmt(this);populateAuthorizer(this.value);}" maxlength="3" /> 
<label>Discount Amount</label> 
<input type="text"	id="disAmtId" name="<%=DISCOUNT_AMOUNT %>" value=""
	onblur="if(validateDis(this)){calculateDisAmt(this);populateAuthorizer(this.value);}" maxlength="7" />
	
<%-- <div class="clear"></div>
<label>Service Charge Percent</label> 
<input type="text" id="serChrgPercentId" name="<%=SERVICE_CHARGE_PERCENT %>" value=""
	onblur="calculateServiceChargeAmt();" maxlength="5" />
<label>Service Charge Amt</label>
<input type="text" id="serChrgAmtId" name="<%=SERVICE_CHARGE_AMOUNT %>" readonly="readonly" value="" 
			maxlength="7" /> 
	 <div class="clear"></div>
	  <label>EDU CessPer</label>
<input type="text" id="cessPer" name="cessPer"  value="" onblur="calculateCessAmt();" maxlength="10" />
<label>EDU CessAmt</label>
<input type="text" id="cessAmt" name="cessAmt" readonly="readonly" value=""  maxlength="10" />
	 <div class="clear"></div>
<label>H.EDU CessPer</label>
<input type="text" id="cessPer1" name="cessPer1"  onblur="calculateCessAmt1();"  value="" maxlength="10" />
	<label>H.EDU CessAmt</label>
<input type="text" id="cessAmt1" name="cessAmt1" readonly="readonly" value="" maxlength="10" />
 --%>

<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	onclick="submitForm('finalBill','billing?method=submitFinalBillDetails','checkNetAmount');" align="right" />
 <input type="reset" class="buttonHighlight" value="Reset" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
 <label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<%} %>
<div class="clear"></div>
<div class="paddingTop40"></div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</div>
</form>

<script type="text/javascript">
function calculateNetAmt(){
		var amount=parseFloat(document.getElementById('totalAmtId').value);
	if(parseFloat(amount) > 0){
		document.getElementById('netAmtId').value= amount;
	}
}
function calculateDisAmt(obj){
	var amount =0;
	var pendingPkgAmount = 0;

	//amount=parseFloat(document.getElementById('pastDue').value);
	amount=parseFloat(document.getElementById('totalAmtId').value);
/*	if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/
//	if(document.getElementById('serChrgAmtId').value != "")
	//	amount = amount + parseFloat(document.getElementById('serChrgAmtId').value);

<%
	BigDecimal pendingPkgAmt = new BigDecimal(0);
	if(pkgPaidAmt.compareTo(new BigDecimal(0)) > 0){
		pendingPkgAmt = totalAmtPkg.subtract(pkgPaidAmt);
%>
	pendingPkgAmount = '<%=pendingPkgAmt%>';
	<%}%>
	var charityOn = parseFloat(amount) - parseFloat(pendingPkgAmount);

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
			if(disAmount > charityOn){
				alert("Discount Amount can not be greater than "+charityOn.toFixed(2));
				document.getElementById('disAmtId').value = "";
				return false;
			}
			if(obj.readOnly == false)
				document.getElementById('disPercentId').readOnly = true;

		}

		var totalNetAmt = parseFloat(amount)- parseFloat(disAmount).toFixed(2);
	//	document.getElementById('netAmtId').value = parseFloat(totalNetAmt).toFixed(2);
		document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDueHidden').value))-parseFloat(disAmount)).toFixed(2);
		populateAuthorizer(parseFloat(disAmount).toFixed(2));
		document.getElementById('authorizerId').disabled = false;
		document.getElementById('netAmtId').value = ((parseFloat(document.getElementById('totalAmtId').value))-parseFloat(disAmount)).toFixed(2);
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

function calculateServiceChargeAmt(){
	var amount;
	var netAmt;
	var dis_amt = document.getElementById('disAmtId').value;
	amount=parseFloat(document.getElementById('netAmtId').value);
	netAmt=parseFloat(document.getElementById('totalAmtId').value);

	//amount=parseFloat(document.getElementById('totalAmtId').value);
	/*if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/
	if(document.getElementById('disAmtId').value != "")
		amount = netAmt - parseFloat(document.getElementById('disAmtId').value);

	if(document.getElementById('serChrgPercentId').value != ""){
		if(validateFloat(document.getElementById('serChrgPercentId').value)){

			if(document.getElementById('serChrgPercentId').value >= 100){
					alert(" Service Charge Percent should be less than 100.");
					document.getElementById('serChrgPercentId').value = "";
					document.getElementById('serChrgAmtId').value = "";
					return false;
			}
			var serChrgAmount = 0;
			serChrgAmount = parseFloat(document.getElementById('serChrgPercentId').value)*parseFloat(netAmt)/100;
			document.getElementById('serChrgAmtId').value = parseFloat(serChrgAmount.toFixed(2));
			document.getElementById('serChrgAmtId').readOnly = true;
			document.getElementById('disPercentId').readOnly = true;
			document.getElementById('disAmtId').readOnly = true;

			var totalNetAmt = parseFloat(amount)+ parseFloat(serChrgAmount);
			document.getElementById('netAmtId').value = totalNetAmt.toFixed(2);
			document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDue').value))+ parseFloat(serChrgAmount)).toFixed(2);
			//document.getElementById('pastDue').value = totalNetAmt.toFixed(2);
			//document.getElementById('pastDue').value = parseFloat(totalNetAmt).toFixed(2);
			return true;
		}else{
			alert("Service Charge Percent should be integer or decimal value.");
			document.getElementById('serChrgPercentId').value = "";
			return false;
		}
	}else{
		document.getElementById('serChrgAmtId').value = "";
	}
}

function calculateServiceChargeAmt(){
	var amount;
	var netAmt;
	var dis_amt = document.getElementById('disAmtId').value;
	amount=parseFloat(document.getElementById('netAmtId').value);
	netAmt=parseFloat(document.getElementById('totalAmtId').value);

	//amount=parseFloat(document.getElementById('totalAmtId').value);
	/*if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/
	if(document.getElementById('disAmtId').value != "")
		amount = netAmt - parseFloat(document.getElementById('disAmtId').value);

	if(document.getElementById('serChrgPercentId').value != ""){
		if(validateFloat(document.getElementById('serChrgPercentId').value)){

			if(document.getElementById('serChrgPercentId').value >= 100){
					alert(" Service Charge Percent should be less than 100.");
					document.getElementById('serChrgPercentId').value = "";
					document.getElementById('serChrgAmtId').value = "";
					return false;
			}
			var serChrgAmount = 0;
			serChrgAmount = parseFloat(document.getElementById('serChrgPercentId').value)*parseFloat(netAmt)/100;
			document.getElementById('serChrgAmtId').value = parseFloat(serChrgAmount.toFixed(2));
			document.getElementById('serChrgAmtId').readOnly = true;
			document.getElementById('disPercentId').readOnly = true;
			document.getElementById('disAmtId').readOnly = true;

			var totalNetAmt = parseFloat(amount)+ parseFloat(serChrgAmount);
			document.getElementById('netAmtId').value = totalNetAmt.toFixed(2);
			document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDue').value))+ parseFloat(serChrgAmount)).toFixed(2);
			//document.getElementById('pastDue').value = totalNetAmt.toFixed(2);
			//document.getElementById('pastDue').value = parseFloat(totalNetAmt).toFixed(2);
			return true;
		}else{
			alert("Service Charge Percent should be integer or decimal value.");
			document.getElementById('serChrgPercentId').value = "";
			return false;
		}
	}else{
		document.getElementById('serChrgAmtId').value = "";
	}
}

function calculateCessAmt(){
	var amount=0;
	var netAmt=0;
	amount=parseFloat(document.getElementById('netAmtId').value);
	netAmt=parseFloat(document.getElementById('totalAmtId').value);

	if(document.getElementById('cessPer').value != ""){
		if(validateFloat(document.getElementById('cessPer').value)){

			if(document.getElementById('cessPer').value >= 100){
					alert(" Cess Charge Percent should be less than 100.");
					document.getElementById('cessPer').value = "";
					document.getElementById('cessAmt').value = "";
					return false;
			}
			var cessAmt =0;
			var surChargeAmt=0;
			if(document.getElementById('serChrgAmtId').value !='')
			{
				surChargeAmt=document.getElementById('serChrgAmtId').value;
			}
			if(surChargeAmt !=0 )
			cessAmt = parseFloat(document.getElementById('cessPer').value)*parseFloat(surChargeAmt)/100;
			document.getElementById('cessAmt').value = parseFloat(cessAmt.toFixed(2));
			document.getElementById('cessAmt').readOnly = true;
			var totalNetAmt = parseFloat(amount)+ parseFloat(cessAmt);
			document.getElementById('netAmtId').value = totalNetAmt.toFixed(2);
			document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDue').value))+ parseFloat(cessAmt)).toFixed(2);

				return true;
		}else{
			alert("Cess Charge Percent should be integer or decimal value.");
			document.getElementById('cessPer').value = "";
			return false;
		}
	}else{
		document.getElementById('cessAmt').value = "";
	}
}

function calculateCessAmt1(){
	var amount=0;
	var netAmt=0;
	amount=parseFloat(document.getElementById('netAmtId').value);
	netAmt=parseFloat(document.getElementById('totalAmtId').value);

	if(document.getElementById('cessPer1').value != ""){
		if(validateFloat(document.getElementById('cessPer1').value)){

			if(document.getElementById('cessPer1').value >= 100){
					alert(" Cess Charge Percent should be less than 100.");
					document.getElementById('cessPer1').value = "";
					document.getElementById('cessAmt1').value = "";
					return false;
			}
			var cessAmt =0;
			var surChargeAmt=0;
			if(document.getElementById('serChrgAmtId').value !='')
			{
				surChargeAmt=document.getElementById('serChrgAmtId').value;
			}

			if(surChargeAmt !=0 )
			cessAmt = parseFloat(document.getElementById('cessPer1').value)*parseFloat(surChargeAmt)/100;
			document.getElementById('cessAmt1').value = parseFloat(cessAmt.toFixed(2));
			document.getElementById('cessAmt1').readOnly = true;
			var totalNetAmt = parseFloat(amount)+ parseFloat(cessAmt);
			document.getElementById('netAmtId').value = totalNetAmt.toFixed(2);
			document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDue').value))+ parseFloat(cessAmt)).toFixed(2);

				return true;
		}else{
			alert("Cess Charge Percent should be integer or decimal value.");
			document.getElementById('cessPer1').value = "";
			return false;
		}
	}else{
		document.getElementById('cessAmt1').value = "";
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

function checkNetAmount(){
	var netAmt = document.getElementById('netAmtId').value;
	if( parseFloat(netAmt) < 0){
		alert("Net Amount should be greater than 0.");
		return false;
	}
	return true;
}

function openPopUpForCharge(mainChargeId,inc)
{
	window.open('billing?method=showChargeCodeInPopUp&mainChargeId='+mainChargeId+'&inpatientId=<%=inpatientId%>&rowVal='+inc,'mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}

function openPopUpForReceipt()
{
	if(document.getElementById('paidAmtId').value !=0 && document.getElementById('paidAmtId').value !="")
		window.open('billing?method=showReceiptDetailsInPopUp&inpatientId=<%=inpatientId%>','mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}

function openPopUpForItem(itemId,inc)
{
	window.open('billing?method=showItemBatchInFinalPopUp&itemId='+itemId+'&inpatientId=<%=inpatientId%>&rowVal='+inc,'mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}

function totalGrossCost(){
	var amt = document.getElementById('totalAmtId').value;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<count; i++){
		var totalQtyIdHide=eval(document.getElementById("totalQtyIdHide"+i));
		var totalQtyId=eval(document.getElementById("totalQtyId"+i));
		var totalAmt = eval(document.getElementById("totalCostId"+i));
		var totalHiddenAmt= eval(document.getElementById("totalCostIdHide"+i));
		
		var increaseQty=parseInt(totalQtyId.value)-parseInt(totalQtyIdHide.value);
		var increaseAmt=parseInt(totalAmt.value)-parseInt(totalHiddenAmt.value);
	
		if(increaseAmt !=null ){
		if(validateFloat(increaseAmt)){
			if(amt != 0 && increaseAmt != ""){
				amt = parseInt(amt)+parseInt(increaseAmt);
			}else if(amt == 0 && increaseAmt != ""){
				amt = parseInt(increaseAmt);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amount"+i).value = "";
			return false;
		}
	}
	}
	document.getElementById('totalAmtId').value = amt;
}
function totalGrossDisCost(){
	var amt = document.getElementById('totalAmtId').value;
	var disamt=document.getElementById('totalDisId').value
	var count = document.getElementById('hiddenValue').value;
	for(var i=1; i<count; i++){
		var totalQtyIdHide=eval(document.getElementById("totalQtyDisIdHide"+i));
		var totalQtyId=eval(document.getElementById("totalQtyDisId"+i));
		var totalAmt = eval(document.getElementById("totalCostDisId"+i));
		var totalHiddenAmt= eval(document.getElementById("totalCostDisIdHide"+i));
		
		var increaseQty=parseInt(totalQtyId.value)-parseInt(totalQtyIdHide.value);
		var increaseAmt=parseInt(totalAmt.value)-parseInt(totalHiddenAmt.value);
		if(increaseAmt !=null ){
			if(validateFloat(increaseAmt)){
				if(amt != 0 && increaseAmt != ""){
					amt = parseInt(amt)+parseInt(increaseAmt);
					disamt = parseInt(disamt)+parseInt(increaseAmt);
				}else if(amt == 0 && increaseAmt != ""){
					amt = parseInt(increaseAmt);
					disamt= parseInt(increaseAmt);
				}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amount"+i).value = "";
			return false;
		}
	}
	}
	document.getElementById('totalDisId').value = disamt;
	document.getElementById('totalAmtId').value = amt;
}
function openItemPopup()
{
	var url = "billing?method=showOtherItemForFinalBill&"+getNameAndData('finalBill');
 window.open(url,'mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
 popwindow(url);
}
</script>
