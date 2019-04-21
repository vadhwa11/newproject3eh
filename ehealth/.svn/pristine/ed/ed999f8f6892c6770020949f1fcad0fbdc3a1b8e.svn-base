<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.CostCenter"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>

<%@page import="jkt.hms.masters.business.MasBranch"%>

<%@page import="jkt.hms.masters.business.FaMasCostCenterCode"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

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
<form name="cashVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	List<MasBranch> branchList = new ArrayList<MasBranch>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if(map.get("accList") != null){
		accList = (List<FaMasAccount>)map.get("accList");
	}
	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	if(map.get("branchList") != null){
		branchList = (List<MasBranch>)map.get("branchList");
	}
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	int mainAccountId = 0;
	if(map.get("mainAccountId") != null){
		mainAccountId = (Integer)map.get("mainAccountId");
	}

	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
	}
	String voucherDate = "";
	if(map.get("voucherDate") != null){
		voucherDate = (String)map.get("voucherDate");
	}
	int financialYearId = 0;
	if(map.get("financialYearId") != null){
		financialYearId = (Integer)map.get("financialYearId");
	}
	String fYearDesc = "";
	if(map.get("fYearDesc") != null){
		fYearDesc = (String)map.get("fYearDesc");
	}
	
String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Voucher Date:</label>
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=voucherDate %>" onblur="submitProtoAjax('cashVoucher','/hms/hms/account?method=getFinancialYear');"  class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.cashVoucher.<%=VOUCHER_DATE%>,event)" />

<label><span>*</span>Cash/Bank Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" onchange="showBalanceInAjax('cashVoucher');showGridForBank(this.value);" >

	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
			
		%>
				<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>

	<%	}
	}
		%>
</select>

<script type="text/javascript">
showBalanceInAjax('cashVoucher');
</script>
 <input id="groupId" type="hidden"  name="groupId" value=""   />

 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />
 <input id="financialYearId" type="hidden"  name="financialYearId" value="<%=financialYearId %>"   />
  <input id="fYearDescId" type="hidden"  name="fYearDesc" value="<%=fYearDesc %>"   />
<label>Balance:</label>
 <input id="balanceId" type="text"  size="5" name="<%=BALANCE_AMOUNT%>" value="" readonly="readonly" MAXLENGTH="8"  tabindex=1 />

<label><span>*</span>Voucher No:</label>
 <input id="voucherNoId" type="text"  size="5" name="<%=VOUCHER_NO%>" readonly="readonly" value="<%= voucherNo %>"  MAXLENGTH="8"  tabindex=1 />



<label>Cost Center</label>
<select id="costCenterId"  name="<%=COST_CENTER_ID %>"  >
<option value="0">Select</option>
	<%

	if(costCenterList.size()>0){
		for(MasCostCenter masCostCenter :costCenterList){
			
		%>
		<option value="<%=masCostCenter.getId() %>" ><%=masCostCenter.getCostCenterName() %></option>
		
	<%}
		}%>
</select>

<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<!--  ======================================Table for cash voucher============================================================-->

<input type="hidden" id="flagForSL" name="flagForSL" value="bank"/>
<div id="gridId"  >
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radioCheck" /></td>
	<td> <input id="accountNameId<%=i%>" type="text" size="42"  name="accountName<%=i%>" value=""    tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" />
	<script type="text/javascript">
	document.getElementById('accountNameId<%=i%>').focus();
	</script>
				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			return entry + "&financialYearId=" + document.getElementById('financialYearId').value;
		}
		  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>', callback: eventCallback});			
			</script></td>
	<td id="slId<%=i %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE%><%=i%>" value=""     /></td>
	

	<td> <input id="amountId<%=i %>"  type="text"  name="<%=AMOUNT%><%=i%>" value="" onblur="totalCrAmount('cash');"   MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	</tr>
	</table>
		<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
	</div>
<!--  ====================================================End cash voucher table==============================-->

<!--  ====================================================Start Bank voucher table==============================-->
<div id="gridBankId" style="display: none">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="bankDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Bank Name</th>
		<th scope="col">Check No</th>
		<th scope="col">Check date</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int inc = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedBankChrage" class="radioCheck" /></td>
	<td> <input id="accountNameBankId<%=inc%>" type="text" size="20"  name="accountNameBank<%=inc%>" value=""   MAXLENGTH="8" tabindex=1 onblur="validateAccountName(this.value,<%=inc %>,'bankSlId');" />

		<div id="ac2updates<%=inc%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			return entry + "&financialYearId=" + document.getElementById('financialYearId').value;
		}
		 	new Ajax.Autocompleter('accountNameBankId<%=inc%>','ac2updates<%=inc%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountNameBank<%=inc%>',callback: eventCallback});
		</script></td>

	<td id="bankSlId<%=inc %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE_BANK%><%=inc%>" value=""   MAXLENGTH="8" tabindex=1 /></td>
	
	<td><input id="bankNameId<%=inc %>" type="text" size="10" name="<%=BANK_NAME%><%=inc%>" value=""    MAXLENGTH="15" tabindex=1 /></td>
	<td><input id="checkNoId<%=inc %>" type="text" size="8" name="<%=CHEQUE_NO%><%=inc%>" value=""    MAXLENGTH="8" tabindex=1 /></td>
	<td><input id="checkDateId<%=inc %>" type="text" size="10" name="<%=CHEQUE_DATE%><%=inc%>" value=""    MAXLENGTH="8" tabindex=1 />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  onclick="setdate('',document.cashVoucher.<%=CHEQUE_DATE%><%=inc%>,event)" />
	</td>
	<td> <input id="amountBankId<%=inc %>"  type="text" size="6" name="<%=AMOUNT_BANK%><%=inc%>" value="" onblur="totalCrAmount('bank');validateAmount(this.value,<%=inc%>);"   MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRowForBank();" tabindex="1" /></td>
	</tr>
	</table>
	<input type="button" name="delete1" class="buttonDel" onClick="removeBankRow();" />
	</div>
<!--  ====================================================End Bank voucher table==============================-->

	<label></label>
		<label></label>
		<label></label>
	<label>Total</label>
	<input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value="" MAXLENGTH="100" tabindex=1 />
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
	<input type="hidden" value="<%=inc %>" name="hiddenValueChargeForBank" id="hiddenValueChargeForBank" />
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Narration</label>

<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="large"	 MAXLENGTH="190" tabindex=1 />
<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('cashVoucher','account?method=submitReceiptVoucher','validateNarration','validateFieldsFrCashVoucher');" accesskey="a" tabindex=1 />
  <input type="reset" name="Reset" id="reset" style="width: 100px; height: 23px; font: bold; border: none;" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

  <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="clear"></div>
<script type="text/javascript">
var costCenterArray =new Array();
var branchArray = new Array();
</script>
<%  int j=0;

for(MasCostCenter masCostCenter:costCenterList){
%>
<script>
			costCenterArray[<%=j%>]= new Array();
			costCenterArray[<%=j%>][0] = "<%=masCostCenter.getId()%>";
			costCenterArray[<%=j%>][1] = "<%=masCostCenter.getCostCenterName()%>";

		</script>
<%j++;} %>

<%  int h=0;

for(MasBranch masBranch:branchList){
%>
<script>
	branchArray[<%=h%>]= new Array();
	branchArray[<%=h%>][0] = "<%=masBranch.getId()%>";
	branchArray[<%=h%>][1] = "<%=masBranch.getBranchDesc()%>";

		</script>
<%h++;} %>
<script type="text/javascript">
function addRow(){
	var tbl = document.getElementById('voucherDetails');
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
						validateAccountName(this.value,(iteration),'slId')
			  };
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameId' + (iteration);
	e1.tabIndex="1";
	e1.size = '42';
   	cell1.appendChild(e1);
	e1.focus();
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cell1.appendChild(newdiv);
   
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ iteration,callback: eventCallback});


	var cell2 = row.insertCell(2);
	cell2.id='slId'+(iteration);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=SUB_LEDGER_CODE%>'+ (iteration);
	e2.id = 'subLedgerId'+(iteration)
	//e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	cell2.appendChild(e2);
	

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=AMOUNT%>'+ (iteration);
	e3.id='amountId'+(iteration);
	e3.onblur = function(){
					totalCrAmount('cash');
	}
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'button';
	e4.name='add';
	e4.className = 'buttonAdd';
	e4.tabIndex="1";
	e4.onclick = function(){
					addRow();
	}
	cell4.appendChild(e4);
}


function removeRow()
{
	var tbl = document.getElementById('voucherDetails');
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

		}
	}
}

function removeBankRow()
{
	var tbl = document.getElementById('bankDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedBankChrage').length;counter++)
	{
		if (document.getElementsByName('selectedBankChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}
}

function addRowForBank(){
	var tbl = document.getElementById('bankDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueChargeForBank');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedBankChrage';
	e0.className='radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
						validateAccountName(this.value,(iteration),'bankSlId')
			  };
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameId' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
	e1.focus();
    cell1.appendChild(newdiv);
	e1.size = '20';

  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration),callback: eventCallback});


	var cell2 = row.insertCell(2);
	cell2.id='bankSlId'+(iteration);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=SUB_LEDGER_CODE_BANK%>'+ (iteration);
	e2.id = 'subLedgerId'+(iteration)
	//e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	cell2.appendChild(e2);

	
	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=BANK_NAME%>'+ (iteration);
	e3.size='10';
	e3.id='bankNameId'+(iteration);
	cell3.appendChild(e3);


	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=CHEQUE_NO%>'+ (iteration);
	e4.size='6';
	e4.id='checkNoId'+(iteration);
	cell4.appendChild(e4);


	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=CHEQUE_DATE%>'+ (iteration);
	e5.size='10';
	e5.id='checkDateId'+(iteration);
	cell5.appendChild(e5);
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.class = 'calender';
	eImg.style.display ='inline';
	eImg.onclick = function(event){
					setdate('',document.getElementById('checkDateId'+iteration),event) };
	cell5.appendChild(e5);
	cell5.appendChild(eImg);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=AMOUNT_BANK%>'+ (iteration);
	e6.size='6';
	e6.id='amountBankId'+(iteration);
	e6.onblur = function(){
					totalCrAmount('bank');
	}
	cell6.appendChild(e6);

	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'button';
	e7.name='add';
	e7.size = '6'
	e7.className = 'buttonAdd';
	e7.tabIndex="1";
	e7.onclick = function(){
					addRowForBank();
	}
	cell7.appendChild(e7);
}






function validateAccountName( strValue,inc,tdid ) {

 	if(strValue != "")
	{
 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);

			idx1++;
			var id = strValue.substring(idx1,idx2);
		    if(id!="")
		    {
		    	//alert("flagForSL=="+flagForSL);
		    	var flagForSL = document.getElementById('flagForSL').value;
		    	submitProtoAjaxWithDivName('cashVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc+'&flagForSL='+flagForSL+'&financialYearId='+financialYearId,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var cashAccountId = document.getElementById('mainAccountId').value;
	var voucherNoId = document.getElementById('voucherNoId').value;
	var voucherDate = document.getElementById('voucherDate').value;
	var totalAmountId = document.getElementById('totalAmountId').value;

	if(cashAccountId == 0){
		errMsg += "Cash Account can not be blank.\n";
	}
	if(voucherNoId == 0){
		errMsg += "Voucher No can not be blank.\n";
	}
	if(voucherDate == ""){
		errMsg += "Voucher Date can not be blank.\n";
	}
	if(vNarrationId == ""){
		errMsg += "Voucher Narration can not be blank.\n";
	}
	if(totalAmountId == ""){
		errMsg += "Total Amount can not be blank.\n";
	}

	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}

	function totalCrAmount(flag)
	{
		var count = 0;
		var accountCrAmt = 0;var accountDrAmt = 0;
			if(flag == 'cash'){
				 count = document.getElementById('hiddenValueCharge').value;
			}else{
				 count = document.getElementById('hiddenValueChargeForBank').value;
			}
			var balance = document.getElementById('balanceId').value
			var balanceAmt = balance.substring(0,balance.indexOf(" "));
			var str = balance.substring(balance.indexOf(" "));
			if(trimAll(str) == "Dr"){
				accountDrAmt = parseFloat(balanceAmt);
			}else if(trimAll(str) == "Cr"){
				accountCrAmt = parseFloat(balanceAmt);
			}
			var drAmt = 0;
			var totalAmount = 0;
			var balanceAmt = 0;
			for(i=1; i<=count; i++){
			var amount = 0;
			if(flag == 'cash'){
				 drAmt = document.getElementById('amountId'+i).value;
				}else {
				 drAmt = document.getElementById('amountBankId'+i).value;
				}
				totalAmount = parseFloat(totalAmount)+parseFloat(drAmt);

			}
			document.getElementById('totalAmountId').value = totalAmount;
			if(parseFloat(drAmt) !=0){
				 if(parseFloat(accountCrAmt)!=0){
				 	 if(parseFloat(accountCrAmt) > parseFloat(drAmt) ){
				 		accountCrAmt = parseFloat(accountCrAmt)- parseFloat(drAmt);
				 		document.getElementById('balanceId').value = accountCrAmt+" Cr";
				 	 }else if(parseFloat(drAmt) > parseFloat(accountCrAmt)){
				 		accountDrAmt =parseFloat(drAmt) - parseFloat(accountCrAmt);
				 		document.getElementById('balanceId').value = accountDrAmt+" Dr";
				 	 }else if(parseFloat(drAmt) == parseFloat(accountCrAmt)){
				 		accountCrAmt =parseFloat(accountCrAmt)-parseFloat(drAmt) ;
				 		document.getElementById('balanceId').value = accountCrAmt+" Cr";
			 		 }
					 }else {
			 		  accountDrAmt = parseFloat(accountDrAmt)+parseFloat(drAmt);
		 		 	  document.getElementById('balanceId').value = accountDrAmt+" Dr";
				  }
				}
		}

		function validateFieldsFrCashVoucher(){
		var msg ="";
		var count = document.getElementById('hiddenValueCharge').value;
		var flagForGrid = document.getElementById('flagForSL').value;

			for(i=1; i<= count; i++){

			if(flagForGrid == 'bank'){
				if(document.getElementById('accountNameBankId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  }
  				  if(document.getElementById('bankNameId'+i).value == ""){
  					msg += "Bank can not be blank.\n";
  				  }
		  			if(document.getElementById('amountBankId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
  				  }

  				  }else{
		  			if(document.getElementById('accountNameId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  	}
		  			if(document.getElementById('amountId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
  				  }

				}
			}
			if(msg != ""){
				alert(msg);
				return false;
			}
			return true;
		}

	function validateAmount(amt,inc){
		if(!validateFloat(amt)){
			alert("Please enter valid amount.");
			document.getElementById('amountBankId'+inc).value = ""
			document.getElementById('amountBankId'+inc).focus();
			return false;
	}else{

		return true;

		}
	}





</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>