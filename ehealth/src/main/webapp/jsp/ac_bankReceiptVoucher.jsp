<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ac_bankReceiptVoucher.jsp
	 * Tables Used         :
	 * Description         : For Receipt Voucher For Bank A/C .
	 * @author Name        : Vishal
	 * Revision Date:
	 * Revision By:
	 * @version 1.0
--%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.FaMasAccountType"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasCostCenterCode"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.MasAccountType"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="bankReceiptVoucher" method="post" action=""><script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%

		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<FaMasAccountType> faMasAccountTypeList = new ArrayList<FaMasAccountType>();
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed>  faMasSubLedList = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed>  faMasSubLedBankList = new ArrayList<FaMasSubLed>();
		List<FaMasCostCenterCode>  faMasCostCenterCodeList = new ArrayList<FaMasCostCenterCode>();
		List<MasBankMaster> masBankMasterList   = new ArrayList<MasBankMaster>();

		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");
		Box box = HMSUtil.getBox(request);
		String voucherNo = "";

		if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(map.get("faMasAccountTypeList") != null){
					faMasAccountTypeList = (ArrayList)map.get("faMasAccountTypeList");

		}
		if(map.get("faMasAccountList") != null){
					faMasAccountList     = (ArrayList)map.get("faMasAccountList");
		}
		if(map.get("faMasSubLedList") != null){
			faMasSubLedList   = (ArrayList)map.get("faMasSubLedList");
		}
		if(map.get("faMasSubLedBankList") != null){
			faMasSubLedBankList   = (ArrayList)map.get("faMasSubLedBankList");
		}
		if(map.get("faMasCostCenterCodeList") != null){
			faMasCostCenterCodeList   = (ArrayList)map.get("faMasCostCenterCodeList");
		}
		if(map.get("masBankMasterList") != null){
			masBankMasterList   = (ArrayList)map.get("masBankMasterList");
		}
		if(map.get("voucherNo") != null){
		 	voucherNo   = (String)(map.get("voucherNo"));
		}

%>
<div class="titleBg">
<h2>Bank Voucher</h2>
</div>
<div class="clear"></div>
<div class="division"></div>

<div class="Block"><label>Voucher Number</label> <input
	id="voucherNumber" value=<%=voucherNo%> type=text name="voucherNumber"
	class="readOnly" readonly="readonly" /> <label>Voucher Date</label> <label
	class="value"><%= date%></label> <label>Voucher Time</label> <label
	class="value"><%= time%></label>

<div class="Clear"></div>
<div class="clear"></div>
<div class="division"></div>

<label class="common">Narration</label> <input id="Narration"
	type="text" name="<%=M_NARRATION%>" value=""
	validate="Narration,string,yes" MAXLENGTH="150" tabindex=1
	style="width: 600px;" /> <select id="faMasSubLed"
	name="<%=FA_MAS_SUB_LED %>" tabindex="1">
	<option value="0">Select</option>
	<%
				for (FaMasSubLed  faMasSubLed : faMasSubLedBankList){

				%>
	<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSlDesc()%></option>
	<%}%>
</select>
<div class="clear"></div>

</div>
<div class="division"></div>


<table width="100%" id="chargeDetails" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Main Account</th>
		<th scope="col">Sub Account</th>
		<th scope="col">C C Code</th>
		<th scope="col">Bank Name</th>
		<th scope="col">Cheque No.</th>
		<th scope="col">Issue Date</th>

		<th scope="col">Narration</th>
		<th scope="col">Dr. Amount</th>
		<th scope="col">Cr. Amount</th>
	</tr>


	<% int i = 0;
	for(int faCount=1;faCount<=4; faCount++, i++){	%>
	<tr>
		<td><input type="text" size="1" value=<%=faCount %> name="srno"
			class="readOnly" readonly="readonly" /></td>

		<td><select id="acc_id<%=faCount %>"
			name="<%=FA_ACCOUNT_ID %><%=faCount %>"
			onchange="populateMasSubLedForAccount(this.value,'bankRreceiptVoucher',<%=faCount %>)">
			<option value="0">Select</option>
			<%
				for (FaMasAccount  faMasAccount : faMasAccountList){
			  %>
			<option value="<%=faMasAccount.getId()%>"><%=faMasAccount.getAccDesc()%></option>
			<%}%>
		</select></td>

		<td><select id="faMasSubLed<%=faCount %>"
			name="<%=FA_MAS_SUB_LED %><%=faCount %>" tabindex="1">
			<option value="0">Select</option>
			<%
				for (FaMasSubLed  faMasSubLed : faMasSubLedList){

				%>
			<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSlDesc()%></option>
			<%}%>
		</select></td>
		<td><select id="cost_center_code_id<%=faCount %>"
			name="cost_center_code_id<%=faCount %>" class="small">
			<option value="0">Select</option>
			<%
				for (FaMasCostCenterCode  faMasCostCenterCode : faMasCostCenterCodeList){
			  %>
			<option value="<%=faMasCostCenterCode.getId()%>"><%=faMasCostCenterCode.getCostCenterCodeName()%></option>
			<%}%>
		</select></td>
		<td><select id="bank_id<%=faCount %>"
			name="<%=BANK_ID %><%=faCount %>">
			<option value="0">Select</option>
			<%
				for (MasBankMaster  masBankMaster : masBankMasterList){
			  %>
			<option value="<%=masBankMaster.getId()%>"><%=masBankMaster.getBankName()%></option>
			<%}%>
		</select></td>
		<td><input id="chk_no<%=faCount %>" type="text" size="8"
			name="chkNo<%=faCount %>" value="" onkeyup="chkIntValue(this)"
			tabindex=1 /></td>
		<td><input id="issue_date<%=faCount %>" type="text" size="8"
			name="chkIssueDate<%=faCount %>" value="<%= date%>" tabindex=1 /></td>
		<td><input type="text" size="20" id="naration<%=faCount %>"
			name="<%=NARRATION%><%=faCount %>" value="" /></td>
		<td><input type="text" id="drAmount<%=faCount %>" size="10"
			name="<%=AMOUNT%><%=faCount %>" onkeyup="chkIntValue(this) onblur="
			calcTotalDrAmount();" maxlength="4" tabindex="1" /></td>
		<td><input type="text" id="crAmount<%=faCount %>" size="10"
			name="<%=AMOUNT%><%=faCount %>" onblur="calcTotalCrAmount();"
			maxlength="4" tabindex="1" /></td>
	</tr>

	<%} %>

	<input type="hidden" id="noOfRec" name="noOfRec" value="<%=i%>" />
	<script type="text/javascript">
<%
int counter=0;
for (FaMasAccount faMasAccount : faMasAccountList)
{
	for (FaMasSubLed faMasSubLed : faMasSubLedList)
	{
		if(faMasSubLed.getAcc() != null){
			if(faMasAccount.getId().equals(faMasSubLed.getAcc().getId())){
					%>
						faMasSubLedArray[<%=counter%>] = new Array();
						faMasSubLedArray[<%=counter%>][0]=<%=faMasAccount.getId()%>;
						faMasSubLedArray[<%=counter%>][1] = "<%=faMasSubLed.getId()%>";
					  	faMasSubLedArray[<%=counter%>][2] = "<%=faMasSubLed.getSlDesc()%>";
					<%
					counter++;
			}
		}
	}
}
%>
</script>

</table>

<!--table ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="floatRight"><label>Total</label> <input type="text"
	id="totalNetIdDr" name="<%=FA_NET_AMOUNT_DR %>" readOnly
	class="readOnlySmall" /> <input type="text" id="totalNetIdCr"
	name="<%=FA_NET_AMOUNT_CR %>" readOnly class="readOnlySmall" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>



<div class="clear"></div>


<input type="button" class="button" value="Submit"
	onclick="if(totalValidation()){submitForm('bankRreceiptVoucher','account?method=submitbankRreceiptVoucher');}"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetClicked('bankRreceiptVoucher');" accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" />

<div class="clear"></div>
<div class="division"></div>


<script type="text/javascript">

function chkIntValue(a){
	if(a.value != ""){
		if(!validateInteger(a.value)){
			alert(" Value should be an integer");
			a.value = "";
			return false;

		}
		else
		{
		return true;
		}
	}
}

function calcTotalCrAmount(){
    var count = 0 ;
    var netAmt = 0;
    var amt = 0;
    count = document.getElementById('noOfRec').value;
    while(count != 0){
         var amt = Number(document.getElementById('crAmount'+count).value);
   	     netAmt =parseFloat(netAmt,10)+parseFloat(amt,10);
         count = count - 1;
	}
	 var netAmtObj = eval(document.getElementById('totalNetIdCr'));
	 netAmtObj.value = String(netAmt);
}

function calcTotalDrAmount(){
    var count = 0 ;
    var netAmt = 0;
    var amt = 0;
    count = document.getElementById('noOfRec').value;
    while(count != 0){
         var amt = Number(document.getElementById('drAmount'+count).value);
   	     netAmt =parseFloat(netAmt,10)+parseFloat(amt,10);
         count = count - 1;
	}
	 var netAmtObj = eval(document.getElementById('totalNetIdDr'));
	 netAmtObj.value = String(netAmt);
}


function totalValidation()
{
  var crAmt =0;
  var dramt =0;
  crAmt = document.getElementById('totalNetIdCr').value;
  drAmt = document.getElementById('totalNetIdDr').value;
   if(crAmt != drAmt)
  {
    alert('The Cr Value and Debit value does not match!');
    return false;
  }
  else
  {
    return true;
  }
}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%faMasAccountList.clear();
faMasAccountTypeList.clear();
faMasCostCenterCodeList.clear();
faMasSubLedBankList.clear();
faMasSubLedList.clear();

%>