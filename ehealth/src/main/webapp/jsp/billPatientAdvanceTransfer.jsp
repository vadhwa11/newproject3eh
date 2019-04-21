<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
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

<form name="deposit" id="form1" method="post" action="">
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> patientMap = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientDetailsList = new ArrayList<Patient>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();

	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");

	if(map.get("patientMap") != null){
		patientMap= (Map<String, Object>)map.get("patientMap");
	}

	if(patientMap.get("patientDetailsList") != null){
		patientDetailsList = (List<Patient>)patientMap.get("patientDetailsList");
	}
	if (patientMap.get("bankList") != null) {
		bankList = (List<MasBankMaster>) patientMap.get("bankList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	String hinNo = "";
	   	if(patientDetailsList.size() > 0){
	   		for(Patient patient12 : patientDetailsList){
	   		hinNo = patient12.getHinNo();
	   		}}	%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<%-- <h4><span><%=message %></span></h4>
	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/> --%>
<div class="clear"></div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="titleBg">
<h2>Patient Advance Transfer</h2>
</div>

<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" id="hinNo" name="<%=HIN_NO %>" value=""
	onblur="if(this.value != ''){submitForm('billingDepositsSearch','ipd?method=searchPatientFOrAdvance');}"
	MAXLENGTH="50" />
<label>Patient Name</label>
<input type="text" value=""/>
<label>Mobile Number</label>
<input type="text" value=""/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchMainChargecode','checkSearch')" tabindex=1 />


<div class="clear"></div>
</div>
</div>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<label class="value">610549</label>
<label>Patient Name</label>
<label class="value">KAUSHIK</label>
<label>Age</label>
<label class="value"> 13 Years</label>
<div class="clear"></div>
<label>Gender</label>
<label class="value">Male</label>
<label>Patient Category</label>
<label class="value">BILLING FOR NON DOMICILE</label>
<label>Family Id</label>
<label class="value">003</label>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="Block">
<h4>Transfer To</h4>
<div class="clear"></div>

<label>Family Members</label>
<input type="radio" value="" name="a"/ >
<label>Charity Name</label>
<input type="radio" value="" name="a"checked="checked"/>
<div class="clear"></div>
<!-- <h4>Family Members Detials</h4>
<div class="clear"></div>
<label>Family Id</label><input type="text" value=""/>
<label>Members</label>
<select>
<option>------Select-----</option>
<option>Mother</option>
<option>Father</option>
<option>Other</option>
</select> 
<label>UHID</label><input type="text" value=""/>
<div class="clear"></div>
<label>Mobile Number</label><input type="text" value=""/>

<div class="clear"></div> -->
<h4>Charity Detials</h4>
<div class="clear"></div>
<label>Charity Name</label><select>----------select--------</select>
<label>Charity Type</label><select>--------select---------</select>
</div>

<div class="clear"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowForPayment();" />
<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRowForPayment('deposit');" tabindex="7" /></td>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="paymentDetails">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Advance Type</th>
		<th scope="col">Advance Amt</th>
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
		<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
			id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
			maxlength="100"/></td>
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
		
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Amount</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
	readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" tabindex="8" value="Submit"
	name="Submit"
	onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
	align="right" />

<!-- <input type="button" class="button" value="Back" align="left"
	onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" /> -->
<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
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
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<% 
bankList.clear();
patientDetailsList.clear();

%>