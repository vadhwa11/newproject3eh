
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.FaMasNarration"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

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
	serverdate = '<%=curDate+"/"+month+"/"+year%>';
</script>
<form name="paymentVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	List<AccountMainTransac> accTransactionList = new ArrayList<AccountMainTransac>();
	List<MasBranch> branchList = new ArrayList();
	List<Object[]> amountList = new ArrayList<Object[]>();
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
	if(map.get("accTransactionList") != null){
		accTransactionList = (List<AccountMainTransac>)map.get("accTransactionList");
	}
	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	if(map.get("masSchemeList") != null){
		masSchemeList = (List<MasScheme>)map.get("masSchemeList");
	}
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	if(map.get("branchList") != null){
		branchList = (List<MasBranch>)map.get("branchList");
	}
	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
	}
	if(map.get("amountList") != null){
		amountList = (List<Object[]>)map.get("amountList");
	}
	List<MasWard>wardList=new ArrayList<MasWard>();
	if(map.get("wardList")!=null){
		wardList=(List<MasWard>)map.get("wardList");
	}
	BigDecimal totalAmountDr = new BigDecimal(0);
	BigDecimal totalAmountCr = new BigDecimal(0);
if(amountList.size()>0){
for(Object[] obj : amountList){
	totalAmountDr = (BigDecimal)obj[0];
	
	totalAmountCr = (BigDecimal)obj[1];
	
}
}
	 int mainAccountId = 0;
	 if(map.get("mainAccountId") != null){
		 mainAccountId = (Integer)map.get("mainAccountId");
		}
%>
<div class="titleBg">
<h2>Payment Voucher</h2>
</div>
<div class="Block">
<div class="clear"></div>
<label>Voucher Date<span>*</span></label>
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate2" value="<%=date %>" class="calDate" tabindex=1  readonly="readonly" validate="Voucher Date ,date,no" MAXLENGTH="30" />

<label>Cash/Bank Account<span>*</span></label>
<%-- <select id="mainAccountId"  name="<%=ACCOUNT_ID %>"  onchange="showCrBalanceInAjax('paymentVoucher');showGridForBank(this.value);" >--%>
<select id="mainAccountId2"  name="<%=ACCOUNT_ID %>"  onchange="showCrBalanceInAjax('paymentVoucher');" onblur="submitProtoAjaxWithDivName('paymentVoucher','account?method=checkForAccountType','checkNoDiv');" tabindex=1 >
	<option value="0">Select</option>
	<%

	if(accTransactionList.size()>0){
		for(AccountMainTransac faMasAccount :accTransactionList){%>
			
		<option value="<%=faMasAccount.getAccount().getId() %>" ><%=faMasAccount.getAccount().getAccDesc() %></option>
		
	<%}
		}%>
</select>
<script type="text/javascript">
showBalanceInAjax('paymentVoucher');
</script>
<input id="groupId" type="hidden"  name="groupId" value=""   />
<div id="checkNoDiv"></div>
 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />
 <div class="clear"></div>
<label>Balance</label>
<input id="balanceAmountId" type="text"   name="<%=BALANCE_AMOUNT%>" readonly="readonly" value=""   tabindex=1 />
<input id="balanceId" type="hidden"   name="balanceAmt" readonly="readonly" value=""   tabindex=1 />


<%-- <label>Voucher No<span>*</span></label> --%>
 <input id="voucherNoId" type="hidden"   name="<%=VOUCHER_NO%>" value="<%= voucherNo %>" readonly="readonly"  validate="Voucher No,metachar,no"  tabindex=1/>

<%--<label>Cost Center</label>
<select id="costCenterId"  name="<%=COST_CENTER_ID %>" tabindex=1 >
<option value="0">Select</option>
	<%

	if(costCenterList.size()>0){
		for(MasCostCenter masCostCenter :costCenterList){
			
		%>
		<option value="<%=masCostCenter.getId() %>" ><%=masCostCenter.getCostCenterName() %></option>
		
	<%}
		}%>
</select> 
<div id="bankDetails" style="display: none">
<label>Cheque No.<span>*</span></label>
<input id="chequeNoId" type="text"  size="5" name="<%=CHEQUE_NO%>"  value=""  MAXLENGTH="20"  tabindex=1 />

<label>Cheque Date<span>*</span></label>
<input type="text" name="<%=CHEQUE_DATE%>" id="chequeDate" value="<%=date %>" class="calDate"  MAXLENGTH="8" tabindex=1 />
</div>--%>


<label>Scheme</label>
<select id="schemeId"  name="schemeId"   tabindex=1 >
	<option value="0">Select</option>
	<%

	if(masSchemeList.size()>0){
		for(MasScheme masScheme :masSchemeList){%>
			
		<option value="<%=masScheme.getId() %>" ><%=masScheme.getSchemeName() %></option>
		
	<%}
		}%>
</select>
<label>Ward</label>
<select id="wardId"  name="wardId"   tabindex=1 >
	<option value="0">Select</option>
	<%

	if(wardList.size()>0){
		for(MasWard masward :wardList){%>
			
		<option value="<%=masward.getId() %>" ><%=masward.getWardName() %></option>
		
	<%}
		}%>
</select>
</div>
<div class="clear"></div>
<!--  ======================================Table for cash voucher============================================================-->
<%--
<script type="text/javascript">
	function showGridForBank(accountId){
		var accountId=document.getElementById('mainAccountId').value;
		
		<%
		for(FaMasAccount faMasAccount :accList){%>
			if(accountId == <%=faMasAccount.getId()%>){
			var subGroupId = <%=faMasAccount.getAccountSubGroup().getId()%>	
		
		if(subGroupId == 1){
			document.getElementById('gridId').style.display = "none"
			document.getElementById('gridBankId').style.display = "inline"	;
			document.getElementById('flagForSL').value = 'bank';
			//alert(document.getElementById('flagForSL').value)

		}else if(subGroupId == 2){

			document.getElementById('gridId').style.display = "inline";
			document.getElementById('gridBankId').style.display = "none"
			document.getElementById('flagForSL').value = 'cash';
			//alert(document.getElementById('flagForSL').value)
		}
			}
			<%}%>
	}

	function showBankDetails(accountId){
		var accSubGrpId= 0;
		<%for(FaMasAccount masAccount :accList){ %>
			if(<%=masAccount.getId()%> == accountId){
				accSubGrpId = '<%=masAccount.getAccountSubGroup().getId()%>';
			}
		<%}%>
		if(accSubGrpId == 2){
			document.getElementById('bankDetails').style.display = "none"	;

		}else if(accSubGrpId == 1){
			document.getElementById('bankDetails').style.display = "inline"
		}
	}


</script>
 <input type="hidden" id="flagForSL" name="flagForSL" value="bank"/>--%>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<!-- <th scope="col">Ward</th> -->
		<th scope="col">CostCenter</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage"  class="radioAuto" /></td>
	<%-- <td> <input id="accountNameId<%=i%>" type="text" size="42"  name="accountName<%=i%>" value=""  tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" onchange="showAllBalanceInAjax('paymentVoucher',<%=i %>);"  />--%>
	
	<td> <input id="accountNameId<%=i%>" type="text" size="42"  name="accountName<%=i%>" value=""  tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')"  />
<script>
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('schemeId').value);
	return entry+"&schemeId="+document.getElementById('schemeId').value;                                                                       
}
</script>
				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>',callback: eventCallback});
			</script></td>
	<td id="slId<%=i %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE%><%=i%>" value=""  readonly="readonly"  size="12"/></td>
			<%-- <td><select name="wardName<%=i %>" id="wardId<%=i %>" >
			<option value="0">Select</option>
			<%for(MasWard mw:wardList){ %>
			<option value="<%=mw.getId()%>"><%=mw.getWardName() %></option>
			
			<%} %>
			</select></td> --%>
<td><select id="costCenterId<%=i %>"  name="<%=COST_CENTER_ID %><%=i%>" tabindex=1 class="small">
	<option value="0">Select</option>
	<%if(costCenterList.size()>0){
		for(MasCostCenter costCenter:costCenterList){
		%>
		<option value="<%=costCenter.getId() %>"><%=costCenter.getCostCenterName() %></option>
	<%}
		}%>
</select></td>
	<td> <input id="amountId<%=i %>" type="text"  name="<%=AMOUNT%><%=i%>" value="" onblur="totalCrAmount('cash',<%=i%>);"  validate="Amount,float,no"  MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex=1 /></td>
	</tr>
	<tr class="background">
	<td colspan=4 class="right">Total</td>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value=""  validate="Total Amount ,float,no"  MAXLENGTH="100" tabindex=1 /></td>
	</tr>
	<tr class="background">
	<td colspan=3 class="right">Total Payment Voucher Control Fig.</td>
	<td><input id="totalDrId" type="text" size="10" class="readOnlySmall" readonly="readonly" name="totalDr" value="<%=totalAmountDr != null?totalAmountDr:"" %>" validate="Total DrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
	<td><input id="totalCrId" size="10" type="text" class="readOnlySmall" readonly="readonly" name="totalCr" value="<%=totalAmountCr != null?totalAmountCr:"" %>" validate="Total CrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
	</tr>
	
	
	</table>
	<input type="button" name="delete" class="buttonDel" onClick="removeRow();totalCrAmount('cash',<%=i %>);" />
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />

<!--  ====================================================End cash voucher table==============================-->

<!--  ====================================================Start Bank voucher table==============================-->
<%-- <div id="gridBankId" >
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="bankDetails"  class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Bank Name</th>
		<th scope="col">Cheque No</th>
		<th scope="col">Cheque Date</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int inc = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedBankChrage" class="radioCheck" /></td>
	<td> <input id="accountNameBankId<%=inc%>" type="text" size="20"  name="accountNameBank<%=inc%>" value=""   tabindex=1 onblur="validateAccountName(this.value,<%=inc %>,'bankSlId');" onchange="showAllBalanceInAjax('paymentVoucher',<%=inc %>);"  />

		<div id="ac2updates<%=inc%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		 	new Ajax.Autocompleter('accountNameBankId<%=inc%>','ac2updates<%=inc%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountNameBank<%=inc%>'});
		</script></td>

	<td id="bankSlId<%=inc %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE_BANK%><%=inc%>" value=""  tabindex=1 /></td>
	
	<td><input id="bankNameId<%=inc %>" type="text" size="10" name="<%=BANK_NAME%><%=inc%>" value=""   validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 /></td>
	<td><input id="checkNoId<%=inc %>" type="text" size="8" name="<%=CHEQUE_NO%><%=inc%>" value=""   validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 /></td>
	<td><input id="checkDateId<%=inc %>" type="text" size="10" name="<%=CHEQUE_DATE%><%=inc%>" value=""   validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.paymentVoucher.<%=CHEQUE_DATE%><%=inc%>,event)" />
	</td>
	<td> <input id="amountBankId<%=inc %>" type="text" size="6" name="<%=AMOUNT_BANK%><%=inc%>" value="" onblur="totalCrAmount('bank');"  validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 /></td>
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRowForBank();" tabindex="1" /></td>
	</tr>
	</table>
	<input type="button" name="delete1" class="buttonDel" onclick="removeBankRow();totalCrAmount('bank');" />
</div>--%>
<!--  ====================================================End Bank voucher table==============================-->
	
	<%-- <label>Total</label>
	<input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value=""  validate="Total Amount ,string,no" MAXLENGTH="100" tabindex=1 />
	--%>
	<%-- <input type="hidden" value="<%=inc %>" name="hiddenValueChargeForBank" id="hiddenValueChargeForBank" />--%>
	
<div class="clear"></div>
<div class="Block">
<label>Narration<span>*</span></label>

<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge" MAXLENGTH="190" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('paymentVoucher','account?method=submitPaymentVoucher','validateNarration','validateFieldsFrCashVoucher');" accesskey="a" tabindex=1 />
 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="" accesskey="u" tabindex=1 />
  <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="" accesskey="d" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
</div>
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
var wardArray=new Array();
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
<%int l=0;
for(MasWard ward:wardList){
%>
<script>
wardArray[<%=l%>]= new Array();
wardArray[<%=l%>][0] = "<%=ward.getId()%>";
wardArray[<%=l%>][1] = "<%=ward.getWardName()%>";

		</script>
<%} %>
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
	var lastRow = tbl.rows.length-2;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioAuto';
	//e0.id = 'radioId' + (iteration);
	e0.value=(iteration);
	
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
						validateAccountName(this.value,(iteration),'slId')
			  };
	//e1.onchange=function(){
		//showAllBalanceInAjax('paymentVoucher',iteration)
	//}; 
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameId' + (iteration);
	e1.tabIndex='1';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
	e1.focus();
    cell1.appendChild(newdiv);
	e1.size = '42';
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


	var cell2 = row.insertCell(2);
	cell2.id='slId'+(iteration);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=SUB_LEDGER_CODE%>'+ (iteration);
	e2.id = 'subLedgerId'+(iteration)
	e2.readOnly = true;
	e2.size='12';
	cell2.appendChild(e2);
	
	/* var cell6 = row.insertCell(3);
	var e6 = document.createElement('select');
	e6.name='wardName'+ (iteration);
	e6.id='wardId'+(iteration);
	e6.options[0] = new Option('Select', '0');
	for(var k1 = 0;k1<wardArray.length;k1++){
		e6.options[k1+1] = new Option(wardArray[k1][1],wardArray[k1][0]);
	}
	e6.className='medium';
	cell6.appendChild(e6); */
	
	
	 var cell3 = row.insertCell(3);
		var e3 = document.createElement('select');
		e3.name='<%=COST_CENTER_ID%>'+ (iteration);
		e3.id='costCenterId'+(iteration);
		e3.options[0] = new Option('Select', '0');
		for(var k = 0;k<costCenterArray.length;k++){
			e3.options[k+1] = new Option(costCenterArray[k][1],costCenterArray[k][0]);
		}
		e3.className='small';
		cell3.appendChild(e3);
	
	
	
		
	
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=AMOUNT%>';
	e4.id='amountId'+(iteration);
	e4.onblur = function(){
					totalCrAmount('cash',iteration);
	}
	e4.tabIndex='1';
	e4.setAttribute('validate','Account,float,yes');
	cell4.appendChild(e4);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'button';
	e5.name='add';
	e5.className = 'buttonAdd';
	e5.tabIndex="1";
	e5.onclick = function(){
					addRow();
	}
	cell5.appendChild(e5);
}

<%--
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
	e1.onchange=function(){
		showAllBalanceInAjax('paymentVoucher',(iteration))
	};
	e1.name = 'accountName'+ (iteration);
	e1.id = 'accountNameBankId' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
	e1.focus();
    cell1.appendChild(newdiv);
	e1.size = '20';
  	new Ajax.Autocompleter('accountNameBankId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


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
	e4.size='7';
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
--%>

/*fnction removeBankRow()
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
*/
function validateAccountName( strValue,inc,tdid ) {

 	if(strValue != "")
	{
 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);

			idx1++;
			var id = strValue.substring(idx1,idx2);
			//alert("id=="+id);
		    if(id!="")
		    {
		    	//var flagForSL = document.getElementById('flagForSL').value;
		    	submitProtoAjaxWithDivName('paymentVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    	//submitProtoAjaxWithDivName('paymentVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc+'&flagForSL11='+flagForSL,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var cashAccountId = document.getElementById('mainAccountId2').value;
	var voucherNoId = document.getElementById('voucherNoId').value;
	var voucherDate = document.getElementById('voucherDate2').value;
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


function removeRow()
{
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-3==0){
         	alert("Can not delete all rows")
         	return false;
     }
	/*var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	var totalDrAmt =0;
	var k = 1;
	var accountCrAmt = 0;var accountDrAmt = 0;
	var balance = document.getElementById('balanceId').value;
		var balanceAmt = balance.substring(0,balance.indexOf(" "));
		var str = balance.substring(balance.indexOf(" "));
		if(trimAll(str) == "Dr"){
			accountDrAmt = parseFloat(balanceAmt);
		}else if(trimAll(str) == "Cr"){
			accountCrAmt = parseFloat(balanceAmt);
		}
		var drAmt = 0;
		var totalAmt =0;*/
		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);

			}
		}
			
			//totalAmt = parseFloat(totalAmt)+parseFloat(drAmt);
			//document.getElementById('totalAmountId').value = totalAmt;
		/*if(parseFloat(drAmt)!= 0){
		if(parseFloat(accountCrAmt)!= 0){
		  if(parseFloat(accountCrAmt) > parseFloat(drAmt) ){
			  accountCrAmt =parseFloat(accountCrAmt) - parseFloat(drAmt);
			  alert("accountDrAmt111==="+accountCrAmt);
				document.getElementById('balanceId').value = accountCrAmt+" Cr"; 
		  }else if(parseFloat(drAmt) > parseFloat(accountCrAmt) ){
			    accountCrAmt = parseFloat(drAmt)- parseFloat(accountCrAmt);
			    alert("accountCrAmt222==="+accountCrAmt);
			    document.getElementById('balanceId').value = accountCrAmt+" Dr"; 
		 	 }else if(parseFloat(crAmt) == parseFloat(accountDrAmt)){
		 		accountCrAmt =parseFloat(accountCrAmt)- parseFloat(drAmt) ;
		 		  alert("accountDrAmt333==="+accountDrAmt);
		 		document.getElementById('balanceId').value = accountCrAmt+" Cr"; 
		 	 }
		}else{
			 accountDrAmt = parseFloat(accountCrAmt)+parseFloat(drAmt);
			 alert("accountCrAmt333==="+accountCrAmt);
			 document.getElementById('balanceId').value = accountDrAmt+" Dr"; 
		  }
			}
		
		k++;*/
	
	/*for(i=1; i<=count; i++){
		var dramount = 0;
				if(document.getElementById('amountId'+i) && document.getElementById('amountId'+i).value != "" ){
					dramount = document.getElementById('amountId'+i).value;
					totalDrAmt = parseFloat(totalDrAmt)+parseFloat(dramount);
					
				}
		}
		
		document.getElementById('totalAmountId').value = totalDrAmt;*/
	
}


		function totalCrAmount(flag,cnt)
		{
			
			var count = 0;
			var accountCrAmt = 0;var accountDrAmt = 0;
			if(flag == 'cash'){
				 count = document.getElementById('hiddenValueCharge').value;
			}else{
				 count = document.getElementById('hiddenValueChargeForBank').value;
			}
			var balance = document.getElementById('balanceId').value;
				var balanceAmt = balance.substring(0,balance.indexOf(" "));
				var str = balance.substring(balance.indexOf(" "));
				if(trimAll(str) == "Dr"){
					accountDrAmt = parseFloat(balanceAmt);
				}else if(trimAll(str) == "Cr"){
					accountCrAmt = parseFloat(balanceAmt);
				}
			var crAmt = 0;
			var totalAmt =0;
				for(i=1; i<=count; i++){
				if(flag == 'cash'){
					 crAmt = document.getElementById('amountId'+i).value;
					}else {
					 crAmt = document.getElementById('amountBankId'+i).value;
					}
				
					totalAmt = parseFloat(totalAmt)+parseFloat(crAmt);
				}
				document.getElementById('totalAmountId').value = totalAmt;
				if(parseFloat(crAmt)!= 0){
				if(parseFloat(accountDrAmt)!= 0){
				  if(parseFloat(accountDrAmt) > parseFloat(crAmt) ){
					  
					    accountDrAmt =parseFloat(accountDrAmt) - parseFloat(crAmt);
						document.getElementById('balanceAmountId').value = accountDrAmt+" Dr"; 
				  }else if(parseFloat(crAmt) > parseFloat(accountDrAmt) ){
						 alert("Cr Amount is greater than Dr Amount");
						 document.getElementById('amountId'+cnt).value='';
					    //accountCrAmt = parseFloat(crAmt)- parseFloat(accountDrAmt);
					   // document.getElementById('balanceAmountId').value = accountCrAmt+" Cr"; 
				 	 }else if(parseFloat(crAmt) == parseFloat(accountDrAmt)){
				 		
				 		accountDrAmt =parseFloat(accountDrAmt)-parseFloat(crAmt) ;
				 		document.getElementById('balanceAmountId').value = accountDrAmt+" Dr"; 
				 	 }
				}else{
					
					 accountCrAmt = parseFloat(accountCrAmt) + parseFloat(crAmt);
					 document.getElementById('balanceAmountId').value = accountCrAmt+" Cr"; 
				  }
					}
				}



	function checkSubLed(val, inc){
		for(i=1;i<inc;i++){
			if(inc != 1){
				if(document.getElementById('resrate'+i)!=null){
					var subled =document.getElementById('resrate'+i).value;
					

					
					if(subled == val)
					{
						alert("SL already selected...!")
						document.getElementById('resrate'+inc).value="0"
						var e=eval(document.getElementById('resrate'+inc));
						e.focus();
						return false;
					}
				}
			}
		}
	}


	function validateFieldsFrCashVoucher(){
		var msg ="";
		//var count = document.getElementById('hiddenValueChargeForBank').value;
		var cnt = document.getElementById('hiddenValueCharge').value;
		//var flagForGrid = document.getElementById('flagForSL').value;
		/*	if(flagForGrid == 'bank'){
			for(i=1; i<= count; i++){
				if(document.getElementById('accountNameBankId'+i)){
				if(document.getElementById('accountNameBankId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  	}
				  }
				if(document.getElementById('bankNameId'+i)){
  				  if(document.getElementById('bankNameId'+i).value == ""){
  					msg += "Bank can not be blank.\n";
  				  }
				}
				if(document.getElementById('checkNoId'+i)){
  				 if(document.getElementById('checkNoId'+i).value == ""){
   					msg += "Check No can not be blank.\n";
   				  }
				}
				if(document.getElementById('checkDateId'+i)){
  				if(document.getElementById('checkDateId'+i).value == ""){
   					msg += "Check D can not be blank.\n";
   				  }
				}
				if(document.getElementById('amountBankId'+i)){
		  			if(document.getElementById('amountBankId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
		  			}
  				  }
			}

  				  }else{*/
  					for(i=1; i<= cnt; i++){
  						if(document.getElementById('accountNameId'+i)){
		  			if(document.getElementById('accountNameId'+i).value == ""){
  					msg += "Account can not be blank.\n";
		  			}
  						}
  						if(document.getElementById('amountId'+i)){
		  			if(document.getElementById('amountId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
		  			}
  				  }
		  			

				}
			//}
			if(msg != ""){
				alert(msg);
				return false;
			}
			return true;
		}

	function checkvalue(inc){
	
			//submitForm('paymentVoucher','account?method=showAccountBal&accountNameId'+accountNameId);
		showAllBalanceInAjaxSub('paymentVoucher',inc);
		}
		function checkPaymentType(){
			alert(document.getElementById("subGroupId").value);
			if(document.getElementById("subGroupId").value=='31378' ||document.getElementById("subGroupId").value=='31383'){
				document.getElementById("checkNoId22").style.display="inline";
			}
		}
</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>