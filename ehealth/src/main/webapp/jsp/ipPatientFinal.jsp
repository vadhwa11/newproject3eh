<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 23 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
	List<Object[]> chargeSlipList = new ArrayList<Object[]>();
	List<Object[]> advanceSlipList = new ArrayList<Object[]>();
	List<Object[]> dispenseDetailsList = new ArrayList<Object[]>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<BlPackageBill> packageBillList = new ArrayList<BlPackageBill>();
	List<Object[]> paidAmtList = new ArrayList<Object[]>();
	
	List<Object[]> adviceDtList = new ArrayList<Object[]>();
	List<Object[]> adviceDispDtList = new ArrayList<Object[]>();
	
	
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
	if(map.get("advanceSlipList") != null){
		advanceSlipList = (List<Object[]>)map.get("advanceSlipList");
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
	boolean flagtype = false;
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	BigDecimal totalAmt = new BigDecimal(0);
	BigDecimal totalAmtForCharge = new BigDecimal(0);
	BigDecimal totalAmtDispense = new BigDecimal(0);
	BigDecimal totalAmtPkg = new BigDecimal(0);
	int patientTypeId = 0;
	
	if(patientDetailsList.size() > 0){
     %> <!--Block One Starts-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
		String pastDue = "";
		String adNo = "";
		String ward = "";
		String hinNo = "";
		BigDecimal adv = new BigDecimal(0.00);
		Set<BlReceiptHeader> receiptSet = new HashSet<BlReceiptHeader>();
   		for(Inpatient inpatient : patientDetailsList)
   		{
   			String docterName="";
   			docterName=inpatient.getDoctor().getFirstName();
   			if(inpatient.getDoctor().getMiddleName()!= null)
   			{
   				docterName = docterName.concat(" ").concat(inpatient.getDoctor().getMiddleName());
   			}
   			if(inpatient.getDoctor().getLastName()!=null)
   			{
   				docterName = docterName.concat(" ").concat(inpatient.getDoctor().getLastName());
   			}
   			
   			Patient patient = inpatient.getHin();
   		 	patientTypeId = patient.getPatientType().getId();
   			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();
   			
   			if(inpatient.getBlReceiptHeaders() != null){
   				receiptSet = inpatient.getBlReceiptHeaders();
   				if(receiptSet.size() > 0){
	   				for(BlReceiptHeader receiptHeader : receiptSet){
	   					if(receiptHeader.getReceiptType().equals("adv")){
	   						adv  = adv.add(receiptHeader.getAmount());
	   					}
	   					
	   				}
   				}
   			}
   			
   			
%>
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
<%
	
	if(inpatient.getAdStatus().equals("D") || inpatient.getAdStatus().equals("A"))
	{
		inpatientId = inpatient.getId();
		adNo = inpatient.getAdNo();
		ward = inpatient.getDepartment().getDepartmentName();
		if(inpatient.getDischargeDate() != null && inpatient.getDischargeTime() != null)
		{
			flagtype = true;
		}
	}
	hinNo = patient.getHinNo();
%> 
<label class="value"><%=adNo%></label>
<input type="hidden" name="<%=AD_NO%>" id="adNoId" value="<%=adNo%>" MAXLENGTH="10" />
<%
	if(flagtype == true)
	{
%>
		<input type="hidden" name="reportType" value="<%=PATIENTDETAIL%>" class="radioCheck"	maxlength="30" />		
<% 
	}
	else
	{
%>
		<input type="hidden" name="reportType" value="<%=DETAIL%>" class="radioCheck"	maxlength="30" />
<%
	}
%>

<label>Ward</label><label class="value"><%=ward %></label>
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value"><%=patient.getHinNo()%></label>

<label>Patient Name</label>
<%
	if(patient.getPFirstName() != null)
	{
		String pName="";
		pName=patient.getPFirstName();
		if(patient.getPMiddleName()!=null)
		{
			pName=pName.concat(" ").concat(patient.getPMiddleName());
		}
		if(patient.getPLastName()!=null)
		{
			pName=pName.concat(" ").concat(patient.getPLastName());
		}
%>
<label class="value"><%=pName%></label>
<%
	}
%> 
<label>Age</label> <label class="value"> <%=patient.getAge() %></label>
<div class="clear"></div>

<label>Patient Type</label> <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label>

<%
	if(patient.getCompany() != null)
	{
		if(patient.getPatientType().getId() == 1)
		{
%> 
			<label>Company</label>
<%		}
		else if(patient.getPatientType().getId() == 4)
		{
%>
			<label>Project</label> 
<%		}
%> 
		<label class="value"><%=patient.getCompany().getCompanyName() %></label>
		<input type="hidden" id="companyId" name="companyId" value="<%=patient.getCompany().getId() %>" />
<%	
	}
%> 
	<input	type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>" value="<%=patientTypeId %>" />
	<label>Advance Amount</label>
	<input type="text" id="advAmt" value="<%=adv %>" name="advAmt" class="readOnly" readonly="readonly" />
	<label>Past Dues</label> 
	<!--<input type="text" id="pastDue" value="<%=new BigDecimal(pastDue) %>" name="pastDue" class="readOnly" readonly="readonly"/>
	<label class="value"> <%=pastDue %></label>--> 
	<input type="text" id="pastDue" value="<%=new BigDecimal(pastDue) %>" name="pastDue"
	class="readOnly" readonly="readonly" />
	<input type="hidden" id="pastDueHidden" value="<%=new BigDecimal(pastDue) %>" name="pastDueHidden" class="readOnly" readonly="readonly" />
	<div class="clear"></div>
	<label>Consulting Doctor</label> <label class="value"><%=docterName %></label>
	<div class="clear"></div>

	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"><input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>"><input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"><input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"> <%} %>
</div>

<%
	if(packageBillList.size() > 0)
	{
%>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<h4>Package Details</h4>
		<div class="clear"></div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="pkgDetailsTable">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Package Description</th>
			<th scope="col">Amount</th>
		</tr>
<%
   	  	int k=1;
   	  	for(BlPackageBill packageBill : packageBillList)
   	  	{
%>
			<tr>
				<td><%=k %></td>
				<td><%=packageBill.getPackage().getPackageDesc() %></td>
				<td><%=packageBill.getNetPkgAmt() %></td>
			</tr>
<%
   			totalAmtPkg = totalAmtPkg.add(packageBill.getNetPkgAmt());
   	  	} 
%>

		</table>
<%
	}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<%
	if(advanceSlipList.size() > 0)
	{
%>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<h4>Advance Details</h4>
		<div class="clear"></div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="advDetailsTable">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Advance Receipt Date</th>
			<th scope="col">Amount</th>
			<th scope="col">Payment Mode</th>
		</tr>
<%
   	  	int k=1;
   	  	for(Object[] obj : advanceSlipList)
   	  	{
   	  		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	    	Date Receiptdate;
 	    	String payMode;
 	    	Receiptdate = (Date)sdf.parse(obj[0].toString());
 	    	if(obj[2].toString().equalsIgnoreCase("C"))
 	    	{
 	    		payMode = "Cash";
 	    	}
 	    	else if(obj[2].toString().equalsIgnoreCase("Q"))
 	    	{
 	    		payMode = "Cheque";
 	    	}
 	    	else
 	    	{
 	    		payMode = "Credit Card";
 	    	}
 	    		
%>
			<tr>
				<td><%=k %></td>
				<td><%=HMSUtil.convertDateToStringWithoutTime(Receiptdate)%></td>
				<td><%=obj[1]%></td>
				<td><%=payMode%></td>
			</tr>
<%
   	  	}
%>
		</table>
<%
	}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<%
	if(chargeSlipList.size() > 0)
	{
%>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<h4>Service Details</h4>
		<div class="clear"></div>

		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="chargeDetailsTable">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Main Service Head</th>
			<th scope="col">Qty</th>
			<th scope="col">Amount</th>
		</tr>
<%
		int i =1;
   		for(Object[] obj : chargeSlipList)
   		{
	   		long advQty =0;
		  	BigDecimal advAmt = new BigDecimal(0);
		   	BigDecimal advCharityDispAmt = new BigDecimal(0);
    		long qty =0;
    		BigDecimal amt =new BigDecimal(0);
    		mainChargeId = (Integer)obj[0];
   			qty = (Long)obj[2];
   			if((BigDecimal)obj[3] != null)
   				amt = (BigDecimal)obj[3];
    			
   			for(Object[] advObj : adviceDtList)
   			{
    			if(mainChargeId == (Integer)advObj[0])
    			{
    				if(advObj[2] != null)
    					advQty = (Integer)advObj[2];
    				if(advObj[3] != null)
    					advAmt = (BigDecimal)advObj[3];
    				if(advObj[4] != null)
    					advCharityDispAmt = (BigDecimal)advObj[4];
    			}
   			}
    		if((qty-advQty) > 0 )
    		{
%>
				<tr style="cursor: pointer;" onclick="openPopUpForCharge(<%=mainChargeId %>);">
					<td><%=i %></td>
					<td><%=(String)obj[1] %></td>
					<td><%=(qty-advQty)%></td>
					<td><%=amt%></td>
				</tr>
<%
		  	 	totalAmtForCharge = totalAmtForCharge.add(amt.subtract(advAmt.subtract(advCharityDispAmt)));
   	    		i++;
   	    	}
   		}
   	    
%>
		</table>
<%	
	}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
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
	<tr style="cursor: pointer;" onclick="openPopUpForItem(<%=itemId %>);">
		<td><%=j %></td>
		<td><%=(String)obj[1] %></td>
		<td><%=dispQty.subtract(advDispQty) %></td>
		<td><%=dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt)) %></td>
	</tr>
	<%
   	 totalAmtDispense = totalAmtDispense.add(dispAmt.subtract(advDispAmt.subtract(advCharityDispAmt)));
   	    	j++;}
	 		}
   	   
   	    %>
</table>
<%
	}
	totalAmt = totalAmtForCharge.add(totalAmtDispense).add(totalAmtPkg);
%> 

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<div class="floatRight">
<label onclick="openPopUpForReceipt();">Cash Paid</label>
<%
 	if(paidAmt == null){
 		paidAmt = new BigDecimal(0);
 	}
 
 %>
<input type="text" id="paidAmtId" name="<%=PAID_AMOUNT %>"
value="<%=adv %>"
onclick="openPopUpForReceipt();" readonly="readonly"
class="readOnlySmall" />

<label class="auto">Gross Total</label>
<input type="text" class="readOnlySmall" id="totalAmtId" name="<%=TOTAL_AMOUNT %>" value="<%=totalAmt %>" 
readonly="readonly" />
</div>

<div class="clear"></div>
<div class="floatRight"><label class="medium">Net Amount</label> 
<%
	BigDecimal netAmt = new BigDecimal(0);
	if(patientTypeId == 2 || patientTypeId == 8)
	{
		 netAmt = new BigDecimal(0);
	 }
	 else
	 {
 		if(paidAmt != null && paidAmt.intValue() > 0)
 		{
 			netAmt = totalAmt.subtract(paidAmt.subtract(totalAdvAmt));
 		}
 		else
 		{
 			netAmt = totalAmt.subtract(adv);
 		}
 	}
 %> 
<input type="text" class="readOnlySmall" id="netAmtId" name="<%=NET_AMOUNT %>" 
value="<%=Math.ceil(netAmt.floatValue()) %>" readonly="readonly" /> 

<input 	type="hidden" id="netAmtHiddenId" value="<%=Math.ceil(netAmt.floatValue()) %>" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<input type="button" class="buttonHighlight" value="Back" 
onclick="submitForm('finalBill','enquiry?method=showEnquiryJsp&jspName=inPatientEnquiry');" />

<input type="button" class="buttonBig" value="Generate Report"
onclick="submitForm('finalBill','/hms/hms/billing?method=printIPFinalBillReport');">

<input type="button" class="buttonBig3" value="Discharge Summary Report"
onClick="submitForm('finalBill','/hms/hms/discharge?method=showDischargeSummaryReport&<%=ADMISSION_NUMBER%>=<%=adNo%>&<%=HIN_NO%>=<%=hinNo%>&flag=en');" />

<input type="button" name="yes" value="Discharge Slip" class="buttonBig"
	onclick="submitForm('finalBill','/hms/hms/ipd?method=showDischargeSlipReport');" />

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

<script type="text/javascript">

function calculateDisAmt(obj){
	var amount =0;
	var pendingPkgAmount = 0;
	
	amount=parseFloat(document.getElementById('pastDue').value);
/*	if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/
	if(document.getElementById('serChrgAmtId').value != "")
		amount = amount + parseFloat(document.getElementById('serChrgAmtId').value);
	
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
	amount=parseFloat(document.getElementById('pastDue').value);
	//amount=parseFloat(document.getElementById('totalAmtId').value);
	/*if(document.getElementById('paidAmtId').value != "")
		amount = amount-parseFloat(document.getElementById('paidAmtId').value);*/
	if(document.getElementById('disAmtId').value != "")
		amount = amount - parseFloat(document.getElementById('disAmtId').value);
	
	if(document.getElementById('serChrgPercentId').value != ""){
		if(validateFloat(document.getElementById('serChrgPercentId').value)){
		
			if(document.getElementById('serChrgPercentId').value >= 100){
					alert(" Service Charge Percent should be less than 100.");
					document.getElementById('serChrgPercentId').value = "";
					document.getElementById('serChrgAmtId').value = "";
					return false;
			}
			var serChrgAmount = 0;
			serChrgAmount = parseFloat(document.getElementById('serChrgPercentId').value)*parseFloat(amount)/100;
			document.getElementById('serChrgAmtId').value = parseFloat(serChrgAmount.toFixed(2));
			document.getElementById('serChrgAmtId').readOnly = true;
			var totalNetAmt = parseFloat(amount)+ parseFloat(serChrgAmount);
		//	document.getElementById('netAmtId').value = totalNetAmt.toFixed(2);
			document.getElementById('pastDue').value = ((parseFloat(document.getElementById('pastDue').value))+parseFloat(serChrgAmount)).toFixed(2);
		
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

function openPopUpForCharge(mainChargeId)
{
	window.open('billing?method=showChargeCodeInPopUp&mainChargeId='+mainChargeId+'&inpatientId=<%=inpatientId%>','mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}
		
function openPopUpForReceipt()
{
	if(document.getElementById('paidAmtId').value !=0 && document.getElementById('paidAmtId').value !="")
		window.open('billing?method=showReceiptDetailsInPopUp&inpatientId=<%=inpatientId%>','mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}

function openPopUpForItem(itemId)
{
	window.open('billing?method=showItemBatchInPopUp&itemId='+itemId+'&inpatientId=<%=inpatientId%>','mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
}
		
	
</script></form>
