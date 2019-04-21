<%@page import="jkt.hms.masters.business.BlPriority"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>
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

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
	  List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
	  List<BlPriority> blPriorities=new ArrayList<BlPriority>();
	  List<MasDepartment> wardDepartment = new ArrayList<MasDepartment>(); // added by amit das on 20-05-2016
	  Integer currentwaitingList=1;
	  Transfer transfer=null;
	  int totalBedPayward=0;
	  int occupiedBedPayWard=0;
	  int vacantBedPayWard=0;
	  OpdPatientDetails opdPatientDetails=null;
	  Inpatient inpatient = null;
	  if (request.getAttribute("map") != null) {
		  	map = (Map<String,Object>) request.getAttribute("map");
		  }
	  utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");

	  if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
			
		} 
	  if(map.get("totalBedPayward")!=null){
		  totalBedPayward=(Integer)map.get("totalBedPayward");
	  }
	  if(map.get("occupiedBedPayWard")!=null){
		  occupiedBedPayWard=(Integer)map.get("occupiedBedPayWard");
	  }
	  if(map.get("vacantBedPayWard")!=null){
		  vacantBedPayWard=(Integer)map.get("vacantBedPayWard");
	  }
	  if (map.get("transferList") != null) {
		  transferList = (List<Transfer>) map.get("transferList");
			
		}
	  if (map.get("blPriorities") != null) {
		  blPriorities = (List<BlPriority>) map.get("blPriorities");
			
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
	  
	  if (map.get("roomTypeList") != null) {
		  roomTypeList = (List<MasRoomType>) map.get("roomTypeList");
		}
	  
	  if (map.get("transfer") != null) {
		  transfer = (Transfer) map.get("transfer");
		}
	  
	  if (map.get("opdPatientDetails") != null) {
		  opdPatientDetails = (OpdPatientDetails) map.get("opdPatientDetails");
		}
	  
	  if (map.get("inpatient") != null) {
		  inpatient = (Inpatient) map.get("inpatient");
		}
	  if (map.get("currentwaitingList") != null) {
		  currentwaitingList = (Integer) map.get("currentwaitingList");
		}
	  
	  if (map.get("wardDepartment") != null) {
		  wardDepartment = (List) map.get("wardDepartment");
		}
	  
	  
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
  	  }
	
%>
<%
String pastDue="";
String uhid="";
String patientName="";
String sex="";
String age="";
String mobile=""; 
String patientType="";
int unId=0;
Patient patient=null;
MasDepartment department=null;
if(opdPatientDetails!=null)
{
	patient=opdPatientDetails.getVisit().getHin();
}

if(transfer!=null)
{
	patient=transfer.getHin();
}
if(inpatient!=null)
{
	patient=inpatient.getHin();
}

if(patient!=null){
	
	if (patient.getPastDue() != null){
		pastDue = patient.getPastDue();
	}else{
		pastDue="0";
	}
	
	uhid=patient.getHinNo();
	unId=patient.getId();
 	patientName=patient.getPFirstName();
	sex =patient.getSex()!=null?patient.getSex().getAdministrativeSexName():"";
 	age=patient.getAge();
	mobile=patient.getMobileNumber()!=null?patient.getMobileNumber():"";
	//patientType=pat.getPatientType().getPatientTypeName();
}
%>
<%
String ipNo="";
String ward="";
String doc="";
Date bilDate=new Date();
int ipId=0;
int transferId=0;
int opdpatientDetailsId=0;

if(transfer!=null)
{
	inpatient=transfer.getInpatient();
	transferId=transfer.getId();
	ipNo=transfer.getAdNo();
	ward=transfer.getInpatient().getDepartment().getDepartmentName();
	doc=transfer.getInpatient().getAdmittingDoctor().getEmployeeName()!=null?transfer.getInpatient().getAdmittingDoctor().getEmployeeName():"";
	ipId=transfer.getInpatient().getId();
	bilDate=transfer.getDateOfTransfer();
	department=transfer.getToWard();
}
%>


<%
if(opdPatientDetails!=null)
{
	opdpatientDetailsId=opdPatientDetails.getId();
	//ipNo=trans.getAdNo();
	//ward=trans.getInpatient().getDepartment().getDepartmentName();
	if(opdPatientDetails.getEmployee()!=null)
	doc=opdPatientDetails.getEmployee().getEmployeeName();
	bilDate=opdPatientDetails.getAdmissionDate();
	department=opdPatientDetails.getAdmissionWard();
	 if(opdPatientDetails.getInpatient() != null){
		inpatient=opdPatientDetails.getInpatient();
	} 
}

if(inpatient!=null)
{
	//inpatient=transfer.getInpatient();
	//transferId=transfer.getId();
	ipNo=inpatient.getAdNo();
	ward=inpatient.getDepartment().getDepartmentName();
	doc=inpatient.getAdmittingDoctor().getEmployeeName()!=null?inpatient.getAdmittingDoctor().getEmployeeName():"-";
	ipId=inpatient.getId();
	bilDate=inpatient.getDateOfAddmission();
	department=inpatient.getDepartment();
}


%>
<%
double chargee=0;
for(MasChargeCode charge:masCharCodeList){
	chargee=charge.getCharge();
}
%>
<%if(patient.getBplStatus()==null || patient.getBplStatus().equalsIgnoreCase("") || patient.getBplStatus().equalsIgnoreCase("n")){%>
<%if(masCharCodeList.size()>0){ %>
<form name="bookingPayward" method="post" action="">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Booking Payward</h2>
</div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient!=null ? patient.getId():"" %>" />
<input type="hidden" name="<%=INPATIENT_ID%>" value="<%=inpatient !=null ? inpatient.getId():"" %>" />
<div class="Block">
<label>UHID</label>
<input readonly="readonly" type="text" value="<%=uhid %>" />
<input type="hidden" name="transferId" value="<%=transferId%>"/>
<input type="hidden" name="opdpatientdetailId" value="<%=opdpatientDetailsId%>"/>

<input type="hidden" name="unId" value="<%=unId %>"/>
<label>IP No</label>
<input readonly="readonly" type="text" value="<%=ipNo %>" />
<input type="hidden" name="ipId" value="<%=ipId%>"/>
<label>Patient Name</label><input readonly="readonly" type="text" value="<%=patientName %>" />
<div class="clear"></div>
<label>Gender</label><input readonly="readonly" type="text" value="<%=sex%>" />
<label>Age</label><input readonly="readonly" type="text" value="<%=age %>" />
<label>Mobile Number</label><input readonly="readonly" type="text" value="<%=mobile %>" />
<div class="clear"></div>
<label>Family Income Category</label><input readonly="readonly" type="text" value="
<%if(patient!=null && patient.getBplStatus()!=null && !patient.getBplStatus().equalsIgnoreCase("") && patient.getBplStatus().equalsIgnoreCase("y")){
	patientType="BPL"; %>

<%}else if(patient!=null && patient.getBplStatus()!=null && !patient.getBplStatus().equalsIgnoreCase("") && patient.getBplStatus().equalsIgnoreCase("n")){ 
patientType="APL"; %>

<%} %>
<%=patientType %>" />
<label>Social Category</label><input readonly="readonly" type="text" value="<%=patient!=null?(patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():""):""%>"/>
<label>Other Category</label><input type="text" value=""/>
<div class="clear"></div>
<label>Ward</label><input readonly="readonly" type="text" value="<%=ward %>"/>
<label>Requested By</label><input readonly="readonly" type="text" value="<%=doc %>"/>
<label>Bill Date</label><input readonly="readonly" type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(bilDate) %>"/>
<div class="clear"></div>

<h4>Advance Details</h4>
<label>Ward<span>*</span></label>

<!-- Select options has changed by Amit das on 20-05-2016 -->
<select	name="ward" id="ward"  validate="Ward,int,yes" onchange="getBedStatus(this.value);setChargeValue(this.value);">
	<!-- <option value="0">Select</option> -->
	<% if(wardDepartment.size()>0) {
		for(MasDepartment masDepartment : wardDepartment){
		if(department!=null && department.getId()==masDepartment.getId()){	
	%>
		<option selected="selected" value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName() %></option>
		<%} else { %>
		<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName() %></option>
	<% } } } %>
	<%-- <option value="<%=department!=null?department.getId():0 %>"><%=department!=null?department.getDepartmentName():""%></option> --%>

</select>
<div class="clear"></div>
<%-- <div id="bedDiv">
<label>Total Bed</label>
<label class="value"><%=totalBedPayward %></label>
<label>Occupied Bed</label>
<label class="value"><%=occupiedBedPayWard %></label>
<label>Vacant Bed</label>
<label class="value"><%=vacantBedPayWard %></label>
</div> --%>

<div id="bedDiv">
<label>Occupied Bed</label>
<label class="value">0</label>
<label>Vacant Bed</label>
<label class="value">0</label>
</div> 


<div class="clear"></div>
<label>Room Type<span>*</span></label>
<select	name="roomtypeId" id="roomtypeId"  onchange="setRoomCharge(this.value)" validate="Room Type,int,yes">
	<option value="0">Select</option>
	<%
		for (MasRoomType masRoomType : roomTypeList) {
	%>
	<option value="<%=masRoomType.getId() %>"><%=masRoomType.getRoomTypeName()%></option>
	<%
		}
	%>

</select>
	<%
		/* for (MasChargeCode masChargeType : masCharCodeList) { */
	%>
	<input type="hidden" value="" id="<%=CHARGE_ID%>" name="<%=CHARGE_ID%>"/>
	<%
		//}
	%>
	<div style="display: none" id="rateDiv"></div>
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
<label>Current Waiting List</label><input name="currentWaiting" type="text" readonly="readonly" value="<%=currentwaitingList%>"/>
<div class="clear"></div>
<label>Room Charges<span>*</span></label><input type="text" id="roomChargeId" name="roomChargeId" class="roomChargeId" value="0.00" validate="Room Charges,float,yes" readonly="readonly"/>
<label>Number Of Days<span>*</span></label><input type="text" name="numOfDaysId" id="numOfDaysId" class="numOfDaysId" value="0" onblur="calPaywardAmt(this.value);" validate="Number Of Days,int,yes" />
<label>Amount<span>*</span></label><input type="text" id="amtt" name="amtt" class="amtthh" validate="Amount,float,yes" value="0.00" readonly="readonly"/>

<input type="hidden" value="<%=pastDue%>" class="readOnly" id="balanceAmount" name="balanceAmount" 
		readonly="readonly" /> 
<div class="clear"></div>

<label>Priority<span>*</span></label>
<select	name="priority" id="priorityId" validate="Priority,int,no">
           <option value="0">Select</option>
	<%
		for (BlPriority blPriority : blPriorities) {
	%>
	<option value="<%=blPriority.getId() %>"><%=blPriority.getPriorityNam()%></option>
	<%
		}
	%>
</select>
<input type="checkbox" id="advAdjCheckId" name="" class="" style="margin: 0;padding: 0" value="" onclick="displayPaywardAdvance(this);" />
<label class="auto" style="padding:0px 25px 0px 5px;">Adjust Against Credit</label>
<div id="advanceadjistdiv" style="display:none;">		
<input type="text" id="adjusetCreditId" name="adjusetCreditId" value="0.00" onblur="adjustPaywardBillAmt(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
		<label>Available Credit Balance</label>
<input type="text" id="avAdvAmtId" name="avAdvAmtId" readonly="readonly" value="<%=pastDue %>" 
			maxlength="9" />
<div class="clear"></div>
<label>Ballance to Be Paid</label>
<input type="text" id="balToBePiadId" name="balToBePiadId" value="0.00" class="readOnly" readonly />
<!-- <input type="text" id="balToBePiadId" name="balToBePiadId" value="" class="" /> -->
</div>
</div>
<div class="clear"></div>
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
			onclick="addRowForPayment('bookingPayward');" tabindex="7" /></td>
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment" id="hiddenValuePayment" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label>Total Amount Paid</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" onblur="calculateAdAmt(this.value);" readonly="readonly"/>
 <label class="smallAuto">(Rs)</label>
<label>Balance to be Paid</label> <input type="text"
	id="balToBePaid" name="<%=BALANCE_AMOUNT %>1" class="readOnly" readonly="readonly"/>
 <label class="smallAuto">(Rs)</label>
<div class="clear"></div>


<!-- <input type="button" class="button" tabindex="8" value="Submit"
	name="Submit"
	onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('bookingPayward','billing?method=submitPaywardDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
	align="right" /> -->
	
	<input type="button" class="button" tabindex="8" value="Submit"	name="Submit"
	onclick="submitForm('bookingPayward','/hms/hms/billing?method=submitPaywardDetails');"
	align="right" />
	
<!-- <input type="button" class="button" value="Back" align="left"
	onClick="submitForm('bookingPayward','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" /> -->
<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
<div class="clear"></div>
<div id="error"></div>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%}else{ %>
<h4><span> No Bed Charge is defined. Please define a bed cgarge for booking</span></h4>
<%} %>
<%}else{ %>
<h4><span> Patient is BPL category. Please change patient category.</span></h4>

<%} %>



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
		
function setRoomCharge(id){
	var ward = document.getElementById("roomtypeId").value;
	if(document.getElementById("roomtypeId").value!="" && document.getElementById("roomtypeId").value!="0")
		{
		submitProtoAjaxWithDivName('bookingPayward','/hms/hms/billing?method=calculateRoomChargeForPayWard&wardId='+ward,'rateDiv')
		}
	else
		{
		document.getElementById("roomChargeId").value='0.00';
		document.getElementById("amtt").value='0.00';
		
		}
	
}

function setChargeValue(val){
	<% for (MasChargeCode masChargeType : masCharCodeList){
			int deptId = masChargeType.getDepartment().getId();
	%>
	if(<%=deptId%> == val){
		
		document.getElementById('chargeId').value= '<%=masChargeType.getId()%>';
	
	}
	<%}%>
}

</script>
<script>
function getBedStatus(val){
	submitProtoAjaxWithDivName('bookingPayward','opd?method=getBedStatus&deptId='+val,'bedDiv');
}

var element = document.getElementById("ward");
var wardId = element.options[element.selectedIndex].value;

getBedStatus(wardId);
setChargeValue(wardId)
</script>

<% 
bankList.clear();
%>