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
%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Payment Advice</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar"><label>Servicing</label> <input type="radio"
	id="servId" value="servicing" name="<%=BILL_TYPE%>"  validate="billTypeVar,metachar,no" class="radioCheck"
	checked="checked" onclick="changeFieldsForType();" /> </div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<label>Patient Type</label> <select id="patientTypeId"
	name="<%=PATIENT_TYPE %>" onchange="changeFieldsForType()" validate="Patient Type,metachar,no">
	<option value="op">Out Patient</option>
	<option value="ip">In Patient</option>
</select>
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30" onblur="callAjax();" validate="hinNo,metachar,no"/>

<div id="adDiv" style="display: none;"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30"
	onblur="callAjaxForAdNo();" validate="adNo,metachar,no" /></div>

<div id="chargeSlipDiv" style="display: none;">
<label>Charge Slip No.</label>
<input type="text" name="<%=CHARGE_SLIP_NO%>" id="chargeSlipId"
	value="" MAXLENGTH="30" onblur="callAjaxForChargeSlip();" validate="Charge Slip No.,metachar,no"/>
</div>

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.bill_no")%></label>
<input type="text" name="<%=BILL_NO%>" id="billNoId" value="" MAXLENGTH="30"
	onblur="submitForm('search','opBilling?method=getPatientDetailsForPaymentAdvice','checkBillNo');" validate="Bill No,metachar,no"/>
</div>
<div class="clear"></div>
</div>

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
function checkBillNo(){
	if(document.getElementById('billNoId').value == "" ){
		return false;
	}
	return true;
}

function checkHin(){
	if(document.getElementById('hinNoId').value == "" ){
		return false;
	}
	return true;
}

function callAjax(){
 	var billType;
	if(document.getElementById('servId').checked){
		billType = "servicing";
	}else if(document.getElementById('dispId').checked){
		billType = "dispensing";
	}
	if (checkHin())
	{
		if(document.getElementById('patientTypeId').value == 'op')
			 submitProtoAjax('search','opBilling?method=getBillNoForPaymentAdvice&<%=BILL_TYPE%>='+billType+'&flag=advice');
		else if(document.getElementById('patientTypeId').value == 'ip'){
			 submitProtoAjaxWithDivName('search','billing?method=getAdNo&<%=BILL_TYPE%>='+billType+'&flag=advice','adDiv');
		}
		
	}
}

function changeFieldsForType(){
	var patientType = document.getElementById('patientTypeId').value; 

	var billType;
	if(document.getElementById('servId').checked){
		billType = "servicing";
	}else if(document.getElementById('dispId').checked){
		billType = "dispensing";
	}

	if(patientType == 'ip' && billType == 'servicing'){
		document.getElementById('adDiv').style.display = 'block';
		document.getElementById('chargeSlipDiv').style.display = 'block';
		document.getElementById('testDiv').style.display = 'none';
	}else if(patientType == 'op'){
		document.getElementById('adDiv').style.display = 'none';
		document.getElementById('chargeSlipDiv').style.display = 'none';
		document.getElementById('testDiv').style.display = 'block';
	}else if(patientType == 'ip' && billType == 'dispensing'){
		document.getElementById('adDiv').style.display = 'block';
		document.getElementById('chargeSlipDiv').style.display = 'none';
		document.getElementById('testDiv').style.display = 'block';
	}

}
	
function callAjaxForChargeSlip(){

	var billType;
	if(document.getElementById('servId').checked){
		billType = "servicing";
	}else if(document.getElementById('dispId').checked){
		billType = "dispensing";
	}
	
	if(document.getElementById('chargeSlipId').value == "" ){
		return false;
	}
		
	submitForm('search','billing?method=getPatientDetailsForIPPaymentAdvice&<%=BILL_TYPE%>='+billType);
}


function callAjaxForAdNo(){
	var billType;
	if(document.getElementById('servId').checked){
		billType = "servicing";
	}else if(document.getElementById('dispId').checked){
		billType = "dispensing";
	}
	
	if(document.getElementById('adNoId').value == "" ){
		return false;
	}
	if(billType == 'servicing')
		submitProtoAjaxWithDivName('search','billing?method=searchChargeSlipNoForPymntAdv&<%=BILL_TYPE%>='+billType,'chargeSlipDiv');
	else if(billType == 'dispensing')
		submitProtoAjaxWithDivName('search','opBilling?method=getBillNoForPaymentAdvice&<%=BILL_TYPE%>='+billType+'&flag=advice','testDiv');
}

document.getElementById('hinNoId').focus();

	</script>
 