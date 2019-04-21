<%@page import="jkt.hms.masters.business.BlPaywardBooking"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRoom"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.BlReceiptHeader"%>



<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
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

<%
	  Map<String,Object> map = new HashMap<String,Object>();
	  Map<String,Object> utilMap = new HashMap<String,Object>();
	  List<Patient> patientList = new ArrayList<Patient>();
	  List<Transfer> transferList = new ArrayList<Transfer>();
	  List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	  List<MasDepartment> departList = new ArrayList<MasDepartment>();
	  List<MasRoom> roomList = new ArrayList<MasRoom>();
	  List<MasChargeCode> masCharCodeList = new ArrayList<MasChargeCode>();
	  List<BlReceiptHeader> blreceptHdr= new ArrayList<BlReceiptHeader>();
	  List<BlReceiptHeader> blAllotHdrList = new ArrayList<BlReceiptHeader>();
	  BlPaywardBooking blPaywardBooking=null;
	  if (request.getAttribute("map") != null) {
		  	map = (Map<String,Object>) request.getAttribute("map");
		  }
	    utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");

	  if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
			
		} 
	  if (map.get("transferList") != null) {
		  transferList = (List<Transfer>) map.get("transferList");
			
		}
	  if (map.get("bankList") != null) {
			bankList = (List<MasBankMaster>) map.get("bankList");
		}
	  if (map.get("departList") != null) {
		  departList = (List<MasDepartment>) map.get("departList");
		}
	  if (map.get("roomList") != null) {
		  roomList = (List<MasRoom>) map.get("roomList");
		}
	  if (map.get("masCharCodeList") != null) {
		  masCharCodeList = (List<MasChargeCode>) map.get("masCharCodeList");
		}
	  if (map.get("blreceptHdr") != null) {
		  blreceptHdr = (List<BlReceiptHeader>) map.get("blreceptHdr");
		}
	  if (map.get("blAllotHdrList") != null) {
		  blAllotHdrList = (List<BlReceiptHeader>) map.get("blAllotHdrList");			
		}
	  if (map.get("blPaywardBooking") != null) {
		  blPaywardBooking = (BlPaywardBooking) map.get("blPaywardBooking");			
		}
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
  	  }
	
%>
<%
String uhid="";
String patientName="";
String sex="";
String age="";
String mobile=""; 
String patientType="";
int unId=0;
for(Patient pat:patientList){
	uhid=pat.getHinNo();
	unId=pat.getId();
 	patientName=pat.getPFirstName();
	sex =pat.getSex().getAdministrativeSexCode();
 	age=pat.getAge();
	mobile=pat.getMobileNumber();
	//patientType=pat.getPatientType().getPatientTypeName();
	
}
%>
<%
String ipNo="";
String ward="";
String doc="";
String bilDate="";
int ipId=0;
int transferId=0;
for(Transfer trans:transferList){
	transferId=trans.getId();
	ipNo=trans.getAdNo();
	ward=trans.getInpatient().getDepartment().getDepartmentName();
	doc=trans.getInpatient().getDoctor().getEmployeeName();
	ipId=trans.getInpatient().getId();
	bilDate=""+trans.getDateOfTransfer();
}
%>

<%
double chargee=0;
for(MasChargeCode charge:masCharCodeList){
	chargee=charge.getCharge();
}
%>
<%
BigDecimal amt=new BigDecimal(0.00);
for(BlReceiptHeader am: blreceptHdr){
	amt=am.getAmount();
}
%>

<%
String allotDate="";
for(BlReceiptHeader am: blAllotHdrList){
	allotDate=""+am.getReceiptDate();
}
%>
<form name="renewalPayward" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Renewal Payward</h2>
</div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=blPaywardBooking.getHin().getId() %>" />
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=blPaywardBooking.getInpatient().getId() %>" />
<input type="hidden" name="transferId" value="<%=blPaywardBooking.getTransfer()!=null?blPaywardBooking.getTransfer().getId():0%>"/>
<input type="hidden" name="opdpatientdetailId" value="<%=blPaywardBooking.getOpdPatientDetails()!=null?blPaywardBooking.getOpdPatientDetails().getId():0%>"/>
<input type="hidden" name="bookingId" value="<%=blPaywardBooking.getId() %>" />


<label>UHID</label>
<input type="text" readonly="readonly" name="unId" value="<%=blPaywardBooking.getHin().getHinNo() %>"/>
<label>IP No</label>
<input readonly="readonly" type="text" value="<%=blPaywardBooking.getInpatient().getId() %>" />
<label>Patient Name</label><input type="text" readonly="readonly"  value="<%=blPaywardBooking.getHin().getPFirstName() %>"/>

<div class="clear"></div>
<label>Gender</label><input type="text" readonly="readonly"  value="<%=blPaywardBooking.getHin().getSex().getAdministrativeSexName() %>"/>

<label>Age</label><input type="text" readonly="readonly"  value="<%=blPaywardBooking.getHin().getAge() %>"/>

<label>Mobile Number</label><input type="text" readonly="readonly"  value="<%=blPaywardBooking.getHin().getMobileNumber() %>"/>

<div class="clear"></div>
<label>Family Income Category</label><input readonly="readonly" type="text" value="
<%
if(blPaywardBooking.getHin()!=null && blPaywardBooking.getHin().getBplStatus()!=null && !blPaywardBooking.getHin().getBplStatus().equalsIgnoreCase("") && blPaywardBooking.getHin().getBplStatus().equalsIgnoreCase("y")){
	patientType="BPL"; %>

<%}else if(blPaywardBooking.getHin()!=null && blPaywardBooking.getHin().getBplStatus()!=null && !blPaywardBooking.getHin().getBplStatus().equalsIgnoreCase("") && blPaywardBooking.getHin().getBplStatus().equalsIgnoreCase("n")){ 
patientType="APL"; %>

<%} %>
<%=patientType %>" />
<label>Social Category</label><input readonly="readonly" type="text" value="<%=blPaywardBooking.getHin()!=null?(blPaywardBooking.getHin().getPatientType()!=null?blPaywardBooking.getHin().getPatientType().getPatientTypeName():""):""%>"/>
<label>Other Category</label><input type="text" value=""/>
<div class="clear"></div>
<label>Ward</label><input type="text" readonly="readonly" value="<%=blPaywardBooking.getInpatient().getDepartment().getDepartmentName() %>"/>
<%-- <label>Requested By</label><label class="value"><%=doc %></label>
 --%><label>Bill Date</label><input type="text" readonly="readonly" value="<%=curDate+"/"+month+"/"+year%>"/>
<div class="clear"></div>
<div class="Block">
<div class="paddingTop25"></div>
<h4>Booking Details</h4>
<div class="paddingTop25"></div>
<label>Allotment Date</label><input type="text" value="<%=HMSUtil.convertDateToStringTypeDateOnly(blPaywardBooking.getBedAllotmentDate()) %>"/>
<label>Advance Already Paid For </label><input type="text" value="<%=blPaywardBooking.getNumberOfDays() %>  Days"/> 
 <%
 Calendar bedAllotmentDate=Calendar.getInstance();
	bedAllotmentDate.setTime(blPaywardBooking.getBedAllotmentDate());
	bedAllotmentDate.add(Calendar.DATE, blPaywardBooking.getNumberOfDays());
	bedAllotmentDate.set(Calendar.HOUR_OF_DAY, 0);
	bedAllotmentDate.set(Calendar.MINUTE, 0);
	bedAllotmentDate.set(Calendar.SECOND, 0);
	bedAllotmentDate.set(Calendar.MILLISECOND, 0);
 %>
 <label>Renewal Due Date</label><input type="text" value="<%=HMSUtil.convertDateToStringTypeDateOnly(bedAllotmentDate.getTime())%>"/> 
<div class="clear"></div>

<select style="display: none;"	name="ward" id="ward"  onchange="" validate="Ward,int,yes">
	
	<option value="<%=blPaywardBooking.getPayward()!=null?blPaywardBooking.getPayward().getId():0 %>"><%=blPaywardBooking.getPayward()!=null?blPaywardBooking.getPayward().getDepartmentName():""%></option>

</select>
<!-- <label>Room Type<span>*</span></label> -->
<select style="display: none;"	name="roomtypeId" id="roomtypeId"  onchange="setRoomCharge(this.value)" validate="Room Type,int,yes">
	<option value="<%=blPaywardBooking.getRoomType().getId() %>"><%=blPaywardBooking.getRoomType().getRoomTypeName()%></option>
</select>
	<%
		for (MasChargeCode masChargeType : masCharCodeList) {
	%>
	<input type="hidden" value="<%=masChargeType.getId() %>" id="<%=CHARGE_ID%>" name="<%=CHARGE_ID%>"/>
	<%
		}
	%>
		<div style="display: none" id="rateDiv"></div>
		
<!-- <label>Room Charges</label> --><input type="hidden" id="roomChargeId" class="roomChargeId" value="0.00"/>
<label>Renewal For</label><input type="text" name="numOfDaysId" id="numOfDaysId" class="numOfDaysId" onblur="calPaywardAmt(this.value);"/>
 <label>Amount</label><input type="text" id="amtt" name="amtt" class="amtthh" readonly="readonly"/>
<label>Penality Amount</label><input type="text" id="penalty" name="penalty" class="amtthh" readonly="readonly"/>

<%-- label>Payward</label>
<select	name="payward" id="payward" validate="payward,string,yes" onchange="setRoomCharge(this.value)">
	<option value="0">Select</option>
	<%
		for (MasChargeCode masChargeType : masCharCodeList) {
	%>
	<option value="<%=masChargeType.getId() %>"><%=masChargeType.getChargeCodeName()%></option>
	<%
		}
	%>

<%
		for (MasChargeCode masChargeType : masCharCodeList) {
	%>
	
	<input type="hidden" value="<%=masChargeType.getCharge() %>" id="<%=masChargeType.getId() %>" name="<%=masChargeType.getId() %>"/>
	
	<%
		}
	%>
</select> --%>
<%-- <label>Room Category</label>
<select
	name="payward" validate="Sex,string,yes">
	<option value="0">Select</option>
	<%
		for (MasRoom masRoom : roomList) {
	%>
	<option value="<%=masRoom.getId() %>"><%=masRoom.getRoomType().getRoomTypeName()%></option>
	<%
		}
	%>
</select> --%>
<!-- <label>Current Waiting List</label><input name="currentWaiting" type="text"/> -->
<%-- <div class="clear"></div>
<label>Room Charges</label><input type="text" id="roomChargeId" class="roomChargeId" value="<%=chargee%>"/>
<label>Number Of Days</label><input type="text" name="numOfDaysId" id="numOfDaysId" class="numOfDaysId" onblur="calPaywardAmt(this.value);"/>
 --%>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowForPayment();" />

<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="paymentDetails" name="paymentDetails">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<!-- <th scope="col">Advance Type</th> -->
		<th scope="col">Amount</th>
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
		<td><select name="<%=PAYMENT_MODE %><%=i %>" id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<%-- <td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
			id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
			maxlength="100"/></td> --%>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
			id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
			id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			style="display: none;" validate="Pick a date" class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
		</td>
			<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
			disabled="disabled" tabindex="6">
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
			onclick="addRowForPayment('renewalPayward');" tabindex="7" /></td>
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment" id="hiddenValuePayment" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label>Total Advance Amount Paid</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" onblur="calculateAdAmt(this.value);"/>
 <label class="smallAuto">(Rs)</label>
<label>Balance to be Paid</label> <input type="text"
	id="balToBePaid" name="<%=TOTAL_AMOUNT %>" class="readOnly"/>
 <label class="smallAuto">(Rs)</label>
<div class="clear"></div>
</div>

<!-- <input type="button" class="button" tabindex="8" value="Submit"
	name="Submit"
	onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('renewalPayward','billing?method=submitAllotmentDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
	align="right" /> -->
	
	<input type="button" class="button" tabindex="8" value="Submit"	name="Submit"
	onclick="submitPaywardRenewal();"
	align="right" />
	
<!-- <input type="button" class="button" value="Back" align="left"
	onClick="submitForm('renewalPayward','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" /> -->
<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
<div class="clear"></div>
<div id="error"></div>
</form>



<script type="text/javascript">
function fnGetDistrictHospital(roomID){
	 new Ajax.Request('billing?method=getPaywardBooking'+'&'+csrfTokenName+'='+csrfTokenValue, {
   	  onSuccess: function(response) {
   	      if(response.responseText.trim()!='')
   	    	  {
   	    	  document.getElementById('referhospital').innerHTML=response.responseText.trim();
   	    	  }
   	  }
   	});
} 
function checkAdvAmt()
{
	if(document.getElementById('totalAmt').value == "" || document.getElementById('totalAmt').value == "0")
	{
		alert("Please enter Advance Amount.");
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
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'none';
	}
	else if(val == "Q" || val == "R"){
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = false;
		document.getElementById("bankId"+count).disabled = false;
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'inline';
	}else{
		document.getElementById("amt"+count).value = "";
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "";
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
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
function submitFormToDisableSubmitDeposit(formName,action,extraFunction,extraFunction2,extraFunction3){

	errorMsgDisableSubmit="";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName);

			if(eval("window."+extraFunction))
		    	ob1 =  eval(extraFunction+"()")

				if(eval("window."+extraFunction2))
		        	ob2 = eval(extraFunction2+"()")

				if(eval("window."+extraFunction3))
		        	ob3 = eval(extraFunction3+"()")

				if(validateFieldsForDisableSubmit(formName)== true & ob1 & ob2 &ob3){
					if(document.getElementById('submitForDisable') != null){
						document.getElementById('submitForDisable').disabled=true
					}
		        	obj.action = action;
					obj.submit();
				}else{
					if(errorMsgDisableSubmit != ""){
						alert(errorMsgDisableSubmit);
			       		return false;
			       	}
			       	return true;
		    	}
		}
function submitPaywardRenewal()
{
	//calPaywardAmtAllotment();
	document.getElementById("amt1").onblur();
	document.getElementById("totalAmt").onblur();
	if(document.getElementById("numOfDaysId").value=='' || isNaN(document.getElementById("numOfDaysId").value))
			{
		alert("Please fill renewal days");
		return;
			}
	else if(parseInt(document.getElementById("numOfDaysId").value)<=0)
		{
		alert("Please enter valid renewal days");
		return;
		}
	if(document.getElementById("balToBePaid").value=='' || isNaN(document.getElementById("balToBePaid").value))
		{
		alert("Please Pay total Amount");
		}
	else if(parseFloat(document.getElementById("balToBePaid").value)>0)
		{
		alert("Please Pay total Amount");
		}
	else
		{
		submitForm('renewalPayward','/hms/hms/billing?method=submitRenewaltDetails')
		}

	}

function setRoomCharge(){
	if(document.getElementById("roomtypeId").value!="" && document.getElementById("roomtypeId").value!="0")
		{
		submitProtoAjaxWithDivName('renewalPayward','/hms/hms/billing?method=calculateRoomChargeForPayWard','rateDiv')
		}
	else
		{
		document.getElementById("roomChargeId").value='0.00';
		document.getElementById("amtthh").value='0.00';
		
		}
	
}

setRoomCharge();
</script>

<% 
bankList.clear();
%>