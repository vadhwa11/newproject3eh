<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.io.InputStream"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 28 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
String currentDate="";
String currentTime="";

Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> dateAndTimeMap=HMSUtil.getCurrentDateAndTime();
currentDate=(String)dateAndTimeMap.get("currentDate");
currentTime=(String)dateAndTimeMap.get("currentTime");

List<MasAuthorizer> authorizerList=new ArrayList<MasAuthorizer>();
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("authorizerList") != null)
{
	authorizerList = (List<MasAuthorizer>)map.get("authorizerList");
}
if(map.get("chargeCodeList") != null)
{
	chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
}
%>

<div class="titleBg">
<h2>Registration Card</h2>
</div>

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label class="bodytextB"><%=prop.getProperty("com.jkt.hms.registration_no") %><span>*</span></label> <input
	type="text" id="uhidNo" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjax('search','registration?method=getPatientName')" />

<input type="hidden" name="<%=PRESCRIPTION_SLIP%>" value="o" />
<div id="testDiv"></div>
<div class="clear"></div>

<label>Date</label><input type="text" name="<%=CURRENT_DATE%>" value="<%=currentDate %>" readonly="readonly"/>
<label>Time</label><input type="text" name="<%=CURRENT_TIME%>" value="<%=currentTime %>" readonly="readonly"/>

<label>Print Reason<span>*</span></label>
<select name="<%=PRINT_REASON%>" id="printReason">
<option value="0">Select</option>
<option value="1">New Registration</option>
<option value="2">Lost</option>
<option value="3">Destroyed</option>
<option value="4">Old</option>
</select>
<script type="text/javascript">
function displayAuthorizedText(obj){
	if(obj.checked){
	document.getElementById("refDoctorId").disabled = false;
	}else{
	document.getElementById("refDoctorId").disabled = true;
	document.getElementById('refDoctorId').value = "";
	}
	}
</script>
<div class="clear"></div>
<label> Charge<span>*</span></label> <select name="registrationType"
				id="registrationTypeId" tabindex="1"
				onchange="populateChargeAmout()">
				<option value="0">Select</option>
				<% for(MasChargeCode masChargeCode : chargeCodeList){
				if(masChargeCode.getId()== 4778)
			{%>
			
				<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
				
		<%} }%>
			</select>
<label>Waive Charge</label><input type="checkbox" name="<%=WAIVE_CHARGE%>" value="waiveChage" class="inputRadiobutton" onclick="displayAuthorizedText(this)"/>


<label>Authorized By</label> 
		<select name="refDoctor" id="refDoctorId" validate="" disabled="disabled" tabindex="">
		<option value="0">Select</option>
<%
		for(MasAuthorizer masAuthorizer : authorizerList)
		{
%>
			<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
<%
		}
%>
		</select>

<div class="clear"></div>
			<label>Amount Chargeable</label> <input type="text" tabindex="1"
				id="amountId" name="billAmount" value=""
				MAXLENGTH="4" readonly="readonly" class="readOnly" /> 
				
				 <input type="checkbox" tabindex="1"
				name="cAdjustAmount" id="cAdjustAmountId" style="margin: 0;padding: 0" 

				onclick="displayAmountText(this)" /> 
				
				
				<label style="width:143px;">Adjust Against Credit</label>
				
				<input type="text" style="display: none;" tabindex="1"
				name="adjustAgainstCreditName" maxlength="5" id="adjustAgainstCreditName" onblur="adjustAgaintsCredit(this.value)"
				 value=""onkeypress="return numbersonly(event)"  />
				
				<label style="display: none;" id="labelcredit">Available Credit Balance</label>
			<input type="text" style="display: none;" tabindex="1"
				name="<%=AVIALABLE_CREDIT_BALANCE %>" id="availableCreditBalanceId"
				readonly="readonly" value="" />
				
			
			<label>Balance To Be Paid</label><input type="text" tabindex="1"
				name="balanceToBePaid" value="" id="balanceToBePaidId"
				readonly="readonly" />


			<!-- <label>Adjust Against Credit</label>
	<input type="checkbox" tabindex="1"  name="cAdjustAmount" id="cAdjustAmountId"  onclick="displayAmountText(this)"/>
	 -->
			<!-- 	<input type="text" tabindex="1" name="adjustAmount" id="adjustAmountId" MAXLENGTH="8" disabled="disabled" value="" onblur="balanceToBePaidFunction(this.value);"/>
 --> 
 
 <div class="clear"></div>
 		<label> Amount Tendered</label><input type="text" tabindex="1" name="amountTendered" MAXLENGTH="5"
				id="amountTenderedId" onblur="calculateBalaceReturn(this.value)" onkeypress="return numbersonly(event)" />

			<label>Balance to be return</label> <input type="text" tabindex="1"
				name="balanceActuallyPaid" MAXLENGTH="5" id="balanceActuallyPaidId" onblur="calculateRevisedCredit(this.value)"
				value="" onkeypress="return numbersonly(event)" /> 
				
				<input type="hidden" tabindex="1"
				name="balanceActuallyPaidhidden" MAXLENGTH="5" id="balanceActuallyPaidIdhidden"
				value=""  /> 


			<label>Revised Credit Balance</label><input type="text" tabindex="1"
				name="revisedCreditBalance" id="revisedCreditBalanceId"
				readonly="readonly" />
				
				
			<div class="clear"></div>
<!-- <input name="Send" type="button"  class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" /> -->
<%-- <input type="hidden" name="billNo" id="billNo" value="<%=billNo%>" />
<input type="hidden" name="loginName" id="loginName" value="<%=loginName%>" /> --%>
<input type="hidden" name="billtype" id="billtype" value="servicing" />
<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig"onClick="submitForm('messageAdt','generalMaster?method=generateReportsForBilling');"accesskey="g" tabindex=1 /> -->

<input type="button" name="OK" value="OK" class="button"
	onClick="if(checkField()){submitFormForDirectPrint('search','registration?method=printRegistrationCard');}" />
<input type="button" name="Reset" value="Cancel" class="button"
	accesskey="r"
	onClick="submitForm('search','registration?method=showRegistrationCardReportJsp');" />
</div>	
</form>
<script type="text/javascript">

function checkField() {
	var printReasonId = document.getElementById('printReason').value;
	var charge = document.getElementById("registrationTypeId").value;
	var uhidNo = document.getElementById("uhidNo").value;
	

	if(!uhidNo || uhidNo==""){
		alert("Enter UHID Number ");
		
		return false;
	}
	
	if (printReasonId == "0") {
		alert("Select Print Reason ");
		
		return false;
	} else {
		if(charge == "0")
		{
		alert("Select Charge");
		return false;
		}
		else{
			return true;
		}
		//return true;

	}
	
	
}

function displayAmountText(obj) {
	document.getElementById('availableCreditBalanceId').value=document.getElementById('pastDueAmountId').value;
	if (obj.checked) {
		adjustAgainstCreditName
		document.getElementById("availableCreditBalanceId").style.display = 'block';
		document.getElementById("adjustAgainstCreditName").style.display = 'block';
		
		document.getElementById("adjustAgainstCreditName").value = '0.0';
		document.getElementById("labelcredit").style.display = 'block';
		if (document.getElementById('adjustAmountId').value == "") {
			document.getElementById('adjustAmountId').value = "";
			document.getElementById("adjustAmountId").disabled = false;

		} else {
			var x = parseFloat(document
					.getElementById('adjustAmountId').value);
			var y = parseFloat(document
					.getElementById("availableCreditBalanceId").value);
			var z = x + y
			document.getElementById("availableCreditBalanceId").value = x
					+ y;
			document.getElementById("adjustAmountId").disabled = false;
			document.getElementById("adjustAmountId").focus();
			document.getElementById('adjustAmountId').value = "";
			document.getElementById("balanceActuallyPaidId").disabled = false;
			document.getElementById("amountTenderedId").disabled = false;
			document.getElementById("revisedCreditBalanceId").value = "";
			document.getElementById("amountTenderedId").value = "";
			document.getElementById("balanceActuallyPaidId").value = "";
			document.getElementById('balanceToBePaidId').value = parseFloat(document
					.getElementById("amountId").value);
		}

	} else {
		document.getElementById("availableCreditBalanceId").style.display = 'none';
		document.getElementById("labelcredit").style.display = 'none';
		document.getElementById("adjustAmountId").disabled = true;
	}
}

function calculateBalaceReturn(tenderAmount){
	
	var balanceToBePaid=document.getElementById('balanceToBePaidId').value;
	document.getElementById('balanceActuallyPaidId').value="0.0";
	document.getElementById('balanceActuallyPaidIdhidden').value="";
	document.getElementById('revisedCreditBalanceId').value="";
	
	
	
	if(parseFloat(balanceToBePaid) <= parseFloat(tenderAmount)){
		
		
		var abc=parseFloat(tenderAmount)-parseFloat(balanceToBePaid);
		document.getElementById('balanceActuallyPaidId').value=abc;
		document.getElementById('balanceActuallyPaidIdhidden').value=abc;
		if(abc==0.0){
			document.getElementById('revisedCreditBalanceId').value=abc;
			}
		
		
	}
	else{
		alert("Tender Amoumt can not less than Balanced to be paid amount");
		document.getElementById('balanceActuallyPaidId').value="";
	}
	
}

function calculateRevisedCredit(balancetoPaid){
	
	if (balancetoPaid != "") {
		if(parseFloat(balancetoPaid)<0){
			alert("Please Enter Correct Value")
			
		}
		else{
			var balanceToReturn=document.getElementById('balanceActuallyPaidIdhidden').value;
			if(parseFloat(balancetoPaid)<= parseFloat(balanceToReturn)){
				var actualCreditBalance=parseFloat(balanceToReturn)-parseFloat(balancetoPaid);
				document.getElementById('revisedCreditBalanceId').value=actualCreditBalance;
			}
			else{
				document.getElementById('balanceActuallyPaidId').value="0";
				alert("Entered Amount Can not greater then actual return balance !")
			}
		}
		
	}
}

function adjustAgaintsCredit(adjustAmount){

	
	var availableCreditbalance=document.getElementById('availableCreditBalanceId').value;
	if(adjustAmount>availableCreditbalance){
		alert("Enter value is greater than available balance")
		document.getElementById('adjustAgainstCreditName').value="0.0";
		
	}
	else{
		
		
		
		var btp=document.getElementById('balanceToBePaidId').value;
		var amount=document.getElementById('amountId').value;
		if(parseFloat(adjustAmount)<=parseFloat(amount)){
			
			var availableCredit=parseFloat(availableCreditbalance)-parseFloat(adjustAmount);
			document.getElementById('availableCreditBalanceId').value=availableCredit;
			alert(amount)
		var balanceToPaid=parseFloat(btp)-parseFloat(adjustAmount);
		document.getElementById('balanceToBePaidId').value=balanceToPaid;
		document.getElementById('amountTenderedId').value=balanceToPaid;
		}
		else{
			alert("Sorry Your amount can not ajdust !")
		}
		
	}
}

function numbersonly(e){
	{
        var charCode = (e.which) ? e.which : event.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
           return false;

        return true;
     }
   
}

</script>




