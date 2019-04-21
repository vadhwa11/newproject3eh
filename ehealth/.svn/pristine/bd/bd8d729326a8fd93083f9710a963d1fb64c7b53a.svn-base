<%@page import="java.util.*"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>

<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
<form name="opPackageBooking" method="post" action=""
	onload="form.reset();">
	<script type="text/javascript">

var amtArr = new Array();
</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
	}
	

	if (map.get("bankList") != null) {
		bankList = (List<MasBankMaster>) map.get("bankList");
	}
	if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	if (map.get("packageList") != null) {
		packageList = (List<BlPackageHeader>) map.get("packageList");
	}
	String registered = "";
	if (map.get("registered") != null) {
		registered = (String) map.get("registered");
	}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>

	<div class="titleBg">
		<h2>Package Billing For OP</h2>
	</div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<%
	String adv = "";
	int hin = 0;
	String pastDue = "";
	if (registered.equals("yes")) {
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);
			hin = patient.getId();

			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();
%>
		<label>HIN</label> <label class="value"><%=patient.getHinNo()%></label>


		<label>Patient Name</label>
		<%
 	if (patient.getPFirstName() != null) {
 %>
		<label class="value"><%=patient.getPFirstName()%> <%=patient.getPMiddleName()!=null ?patient.getPMiddleName():"" %>
			<%=patient.getPLastName()!=null?patient.getPLastName():""%></label>
		<%
 	}
 %>
		<label>Age</label> <label class="value"><%=patient.getAge()%></label>
     <div class="clear"></div>
		<label><span>*</span> Consultant Name</label> <select
			name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
			validate="Consultant Name,string,yes" tabindex=1
			onchange="displayName();">
			<option value="0">Select</option>
			<%
		for (MasEmployee employee : employeeList) {
						if (employee.getEmpCategory() != null) {
							if (employee.getEmpCategory()
									.getEmpCategoryCode().equals(
											empCategoryCodeForDoctor)) {

								String doctorMiddleName = "";
								String doctorLastName = "";
								if (employee.getMiddleName() != null)
									doctorMiddleName = employee.getMiddleName();
								if (employee.getMiddleName() != null)
									doctorLastName = employee.getLastName();
	%>
			<option value="<%=employee.getId()%>"><%=employee.getFirstName()+ " " + doctorMiddleName + " "+ doctorLastName%></option>
			<%
		}
						}
					}
	%>
		</select>
		<script type="text/javascript">
	(document.getElementById("cnsltDocId").focus());
	</script>
		<%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %>
		<label>Total Advance</label> <label class="value"><%=adv%></label>
		<%
 			}
 %>
		<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
		<input type="hidden" name="<%=HIN_NO %>"
			value="<%=patient.getHinNo() %>" /> <input type="hidden"
			name="<%=PATIENT_NAME%>"
			value="<%=patient.getPFirstName() %> <%=patient.getPMiddleName()%> <%=patient.getPLastName()%>" />
		<input type="hidden" name="<%=AGE%>" value="<%=patient.getAge() %>" />
		<input type="hidden" name="<%=SEX_ID%>"
			value="<%=patient.getSex().getId() %>" />
		<%} 
	}else {
 %>
		<label><span>*</span> Patient Name</label> <input type="text"
			name="<%=PATIENT_NAME%>" value="" validate="Patient Name,string,yes"
			MAXLENGTH="40" tabindex=1 /> <label> <span>*</span> Age
		</label> <input type="text" name="<%=AGE%>" value="" validate="Age,string,yes"
			MAXLENGTH="3" tabindex=1 /> <label><span>*</span> Sex</label> <select
			name="<%=SEX_ID %>" validate="Sex,string,yes">
			<option value="0">Select</option>
			<%
		for (MasAdministrativeSex sexObj : sexList) {
	%>
			<option value="<%=sexObj.getId() %>"><%=sexObj.getAdministrativeSexName()%></option>
			<%
		}
	%>
		</select>
		<div class="clear"></div>
		<label><span>*</span> Consultant Name</label> <select
			name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
			validate="Consultant Name,string,yes" tabindex=1
			onchange="displayName();">
			<option value="0">Select</option>
			<%
		for (MasEmployee employee : employeeList) {
						if (employee.getEmpCategory() != null) {
							if (employee.getEmpCategory()
									.getEmpCategoryCode().equals(
											empCategoryCodeForDoctor)) {

								String doctorMiddleName = "";
								String doctorLastName = "";
								if (employee.getMiddleName() != null)
									doctorMiddleName = employee
											.getMiddleName();
								if (employee.getMiddleName() != null)
									doctorLastName = employee.getLastName();
	%>
			<option value="<%=employee.getId()%>"><%=employee.getFirstName()
											+ " " + doctorMiddleName + " "
											+ doctorLastName%></option>
			<%
		}
						}
					}
	%>
		</select>
		<script type="text/javascript">
	(document.getElementById("cnsltDocId").focus());
	</script>
		<%
 	}
 %>
		<input type="hidden" id="cnsltDocTextId" name="<%=CONSULTING_DOCTOR%>"
			value="" /> <label>Package</label> <select name="<%=PACKAGE_ID %>"
			onchange="submitProtoAjax('opPackageBooking','/hms/hms/packageBilling?method=getPackageDetails');displayPkgAmt(this.value)">
			<option value="0">Select</option>
			<%int counter = 0;
		for(BlPackageHeader packageHeader : packageList){
	%>
			<option value="<%=packageHeader.getId() %>"><%=packageHeader.getPackageDesc() %></option>
			<script type="text/javascript">
	
		amtArr[<%=counter%>] = new Array();
		amtArr[<%=counter%>][0] = <%=packageHeader.getId()%>;
		amtArr[<%=counter%>][1] = "<%=packageHeader.getTotalValueOfPackage()%>";									
	
	</script>
			<%counter++;
	} %>
		</select>
		<div class="clear"></div>
	</div>


	<div id="testDiv"></div>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div class="Block">
		<label class="auto">Package Amount</label> <input type="text"
			id="pkgAmtId" name="<%=DISCOUNTED_VALUE_PACKAGE %>" class="small"
			value="" readOnly />
	<%-- 	<%
	if (registered.equals("yes")) {
		if (!adv.equals("")) {
%>
		<label class="auto">Advance Adjustment</label> <input type="checkbox"
			class="radioCheck" value="" onclick="displayAdvanceText(this);" /> <label
			id="amtLabel" style="display: none;" class="auto">Amount</label> <input
			type="text" id="advAdjId" name="<%=ADVANCE_ADJUSTMENT %>" value=""
			class="small" style="display: none;" maxlength="9"
			onblur="calculateNetAmountAfterAdvOS('<%=adv %>');" />
		<%
 	}
 %>
		<label class="auto">Outstanding</label> <input type="text"
			id="outstandingId" name="<%=OUTSTANDING %>" class="small"
			onblur="calculateNetAmountAfterAdvOS('<%=adv %>');" maxlength="9" />
		<%
 	}
 %>
		<label class="auto">Round Off</label> <input type="text" id="roundId"
			name="<%=ROUND_OF_VALUE %>" class="small" readonly="readonly" /> <label
			class="auto">Net Amount</label> <input type="text" id="netAmountId"
			name="<%=TOTAL_AMOUNT%>" value="" class="small" readOnly /> --%>
		<div class="clear"></div>
	</div>

	<script type="text/javascript">
var bankArray=new Array();
</script>

	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<h4>Payment Details</h4>
	<div class="clear"></div>
	<input type="button" name="delete" class="buttonDel"
		onclick="removeRowForPayment();" />
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
			<th scope="col">&nbsp;</th>
		</tr>
		<%
		int i = 1;
	%>
		<tr>
			<td><input type="radio" value="<%=i%>" name="selectedPayMode"
				class="radioCheck" /></td>
			<td><select name="<%=PAYMENT_MODE %><%=i%>"
				id="paymentModeId<%=i %>"
				onchange="checkPaymentMode(this.value,<%=i %>);">
					<option value="">Select</option>
					<option value="C" selected="selected">Cash</option>
					<option value="Q">Cheque</option>
					<option value="R">Credit Card</option>
			</select></td>
			<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i%>"
				id="amtRcvd<%=i %>" value="" validate="Amount,string,no"
				maxlength="9" onblur="validateAmount(this.value,<%=i %>);" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i%>"
				id="cqeId<%=i %>" maxlength="20" readonly="readonly"
				onblur="validateCheque(this.value,<%=i%> );" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i%>"
				id="chqDate<%=i %>" readonly="readonly" /> <img id="calId<%=i %>"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				style="display: none;" validate="Pick a date" class="calender"
				onclick="setdate('<%=date %>',document.getElementById('chqDate<%=i %>'),event);" />

			</td>
			<td><select name="<%=BANK_NAME %><%=i%>" id="bankId<%=i %>"
				disabled="disabled">
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
				onclick="addRowForPayment('opPackageBooking');" /></td>

		</tr>
	</table>
	<input type="hidden" value="1" name="hiddenValuePayment"
		id="hiddenValuePayment" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	<input type="button" tabindex="1" class="button" name="Submit11"
		value="Submit"
		onclick="submitForm('opPackageBooking','packageBilling?method=submitOPPkgBillingDetails');"
		align="right" /> <input type="button" class="buttonHighlight"
		value="Reset" onclick="form.reset();resetAjaxValueForBilling();" /> <input
		type="button" class="button" value="Back" onclick="history.back();" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
			name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>

	<script type="text/javascript">
 
function validateRateValue(val,count,rate){
	if(val != ""){
		if(!validateFloat(val)){
			alert("Rate should be integer or decimal value");
			
			if(document.getElementById('resrate'+count)){	
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
		}
	}else{
			alert("Rate can not be blank");	
			if(document.getElementById('resrate'+count)){	
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
	}
	return true;
}


function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
				if(validateChargeCodeForAutoComplete(this.value, (iteration))){submitProtoAjaxWithDivName('opPackageBooking','/hms/hms/opBilling?method=fillChargeCode&rowVal='+(iteration)+'&hin=<%=hin%>','rateVal'+(iteration));}
				
			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update'+iteration,'opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});
		
	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=QUANTITY%>'+ (iteration);
	e2.id = 'qty'+(iteration)
	e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	e2.onblur= function(){
					validateQty(this.value,this.id);calculateNetAmount(iteration);calculateTotalAmt();
					};
	cell2.appendChild(e2);
	e2.size='5';
	
	
	var cell3 = row.insertCell(3);
	cell3.id='rateVal'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=RATE%>'+ (iteration);
	e3.readOnly = true;
	e3.id='rate'+(iteration);
	e3.size='12';
	cell3.appendChild(e3); 
	
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=AMOUNT%>'+ (iteration);
	e4.readOnly = true;
	e4.size='13';
	e4.id='amount'+(iteration);
	cell4.appendChild(e4); 
	
	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=DISCOUNT_PERCENTAGE%>'+ (iteration);
	e5.id='dispercent'+(iteration);
	e5.onblur = function(){
					if(checkDiscountAmt((iteration))){calculateDiscountAmt((iteration));calculateNetAmount(iteration);calculateTotalAmt()};
				};
	e5.size = '10';
	e5.readOnly = true;
	e5.maxLength = '3';
	cell5.appendChild(e5); 
	
	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=DISCOUNT%>'+ (iteration);
	e6.id='disamount'+(iteration);
	e6.readOnly = true;
	e6.maxLength = '7';
	e6.size = '10';
	e6.onblur = function(){
					if(checkDiscountAmt((iteration))){calculateNetAmount(iteration);calculateTotalAmt()};
				};
	cell6.appendChild(e6); 
	
	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='proporationalDis'+ (iteration);
	e7.id='prprtnlDis'+(iteration);
	e7.readOnly = true;
	e7.size = '10';
	cell7.appendChild(e7); 
	
	var cell8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=NET_AMOUNT%>'+ (iteration);
	e8.id='netamount'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell8.appendChild(e8); 

	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'button';
	e9.name='add';
	e9.className = 'buttonAdd';
	e9.tabIndex="1";
	e9.onclick = function(){
					addRow();
	}
	cell9.appendChild(e9); 
}

function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	         
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true) 
		{
		  	tbl.deleteRow(counter+1);
		 	calculateTotalAmt();
		}
	}
}

function validatePaymentAmt(){
	var msg = "";
	
	var payAmt = document.getElementById('netAmountId').value;
	var cnt = document.getElementById('hiddenValuePayment').value;
	var total = 0;
	for(var i=1;i<=cnt;i++){
		if(document.getElementById('amtRcvd'+i).value !="")
			total = parseFloat(total)+parseFloat(document.getElementById('amtRcvd'+i).value);
	}
	
	if(payAmt != 0 && total != 0){
		if(parseFloat(total) != parseFloat(payAmt)){
			msg += "Total of Payment Amount should be equal to Payable Amount.";
		}
	}else if(payAmt != 0 && total == 0){
			msg += "Please enter Amount in Payment Details.";
	}
	
	
	if(msg != ""){
		alert(msg)
		return false;
	}
	return true;
}



function displayName(){
	var w = document.getElementById('cnsltDocId').selectedIndex;
	var selectedText = document.getElementById('cnsltDocId').options[w].text;
	document.getElementById('cnsltDocTextId').value = selectedText;
}


function displayPkgAmt(val)
{
	var amt = 0;
	for(i=0;i<amtArr.length;i++){
		if(val == amtArr[i][0]){
			amt = amtArr[i][1];
			document.getElementById('pkgAmtId').value = amtArr[i][1];
			//document.getElementById('netAmountId').value = Math.round(amtArr[i][1]).toFixed(2);
			document.getElementById('amtRcvd1').value = amtArr[i][1];
			
		}
	}

	if(amt.toString().indexOf('.') > 0)
	{
		if(parseFloat(document.getElementById('netAmountId').value) > parseFloat(amt))
			document.getElementById('roundId').value = (document.getElementById('netAmountId').value-amt).toFixed(2);
		else
			document.getElementById('roundId').value = (amt-document.getElementById('netAmountId').value).toFixed(2);
	}

}

function calculateNetAmountAfterAdvOS(advamt){
	var netamt = 0;
	var pkgAmt = 0;
	var advAdj = 0;
	var osAmt = 0;
	if(document.getElementById('netAmountId').value != "")	
		netamt = document.getElementById('netAmountId').value;
		
	if(document.getElementById('pkgAmtId').value != "")	
		pkgAmt = Math.round(document.getElementById('pkgAmtId').value);
		
	if(document.getElementById('advAdjId') != null)	
		advAdj = document.getElementById('advAdjId').value;
		
	if(document.getElementById('outstandingId').value != "")	
		osAmt = document.getElementById('outstandingId').value;
	
		
	if(advAdj != ""){
		if(advamt != ''){
			if(validateFloat(advAdj)){
				if(parseFloat(advAdj) > parseFloat(netamt)){
					alert("Advance Adjustment amt should be less than or equal to Net Amount.");
					document.getElementById('advAdjId').value = "";
					return false;
				}else if(parseFloat(advAdj) > parseFloat(advamt)){
					alert("Advance Adjustment Amount should be less than or equal to Total Advance Amount.");
					document.getElementById('advAdjId').value = "";
					return false;
				}
			}else{
				alert("Advance Adjustment Amount should be integer or decimal value");
				return false;
			}
		}
	}else{
		advAdj = 0;
	}
	
	if(osAmt != ""){
		if(validateFloat(osAmt)){
			if(parseFloat(osAmt) > parseFloat(netamt)){
				alert("Oustanding Amount should be less than or equal to Net Amount.");
				document.getElementById('outstandingId').value = "";
				return false;
			}
			
		}else{
			alert("Outstanding Amount should be integer or decimal value");
			return false;
		}	
	}
	document.getElementById('netAmountId').value = (parseFloat(pkgAmt)-parseFloat(advAdj) - parseFloat(osAmt)).toFixed(2);
	document.getElementById('amtRcvd1').value = document.getElementById('netAmountId').value;
		
	return true;
}



function openPopForBatch(code,rowVal){
var dispPrice = document.getElementById('dispPriceId'+rowVal).value;
		if(code !=""){
			window.open('opBilling?method=showItemBatchNoPopUp&itemCode='+code+'&rowVal='+rowVal+'&flag=pkg&dispPrice='+dispPrice,'mywindow','location=1,status=1,scrollbars=1,width=780,height=300');
	
		}
}


</script>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
