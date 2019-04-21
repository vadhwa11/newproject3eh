<%@page import="jkt.hms.masters.business.MasWard"%>
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
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<form name="cashVoucher" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<FaMasNarration> narrationList = new ArrayList<FaMasNarration>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<MasWard>wardList=new ArrayList<MasWard>();
	if(map.get("wardList")!=null){
		wardList=(List<MasWard>)map.get("wardList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<Object[]> amountList = new ArrayList<Object[]>();

	if(map.get("accList") != null){
		accList = (List<FaMasAccount>)map.get("accList");
	}
	List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
	if(map.get("masSchemeList") != null){
		masSchemeList = (List<MasScheme>)map.get("masSchemeList");
	}
	if(map.get("costCenterList") != null){
		costCenterList = (List<MasCostCenter>)map.get("costCenterList");
	}
	System.out.println("costCenterList size -=======------->>>>"+costCenterList.size());
	if(map.get("narrationList") != null){
		narrationList = (List<FaMasNarration>)map.get("narrationList");
	}
	int mainAccountId = 0;
	if(map.get("mainAccountId") != null){
		mainAccountId = (Integer)map.get("mainAccountId");
	}
	System.out.println("mainAccountId-=====>>"+mainAccountId);
	if(map.get("amountList") != null){
		amountList = (List<Object[]>)map.get("amountList");
	}
	BigDecimal totalAmountDr = new BigDecimal(0);
	BigDecimal totalAmountCr = new BigDecimal(0);
	if(amountList.size()>0){
	for(Object[] obj : amountList){
		totalAmountDr = (BigDecimal)obj[0];
		
		totalAmountCr = (BigDecimal)obj[1];
		
	  }
 }
	int voucherNo = 0;
	if(map.get("voucherNo") != null){
		voucherNo = (Integer)map.get("voucherNo");
	}
String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>

<div class="titleBg">
<h2>Receipt Voucher</h2>
</div>
<div class="Block">
<div class="paddingTop5"></div>
<div class="clear"></div>
<label>Cash/Bank Account<span>*</span></label>
<%-- <select id="mainAccountId"  name="<%=ACCOUNT_ID %>" onchange="showBalanceInAjax('cashVoucher');showGridForBank(this.value);">--%>
<select id="mainAccountId2"  name="<%=ACCOUNT_ID %>" onchange="showBalanceInAjax('cashVoucher');showBankDetails(this.value);">
<option value="0">Select</option>
	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
			if(faMasAccount.getId().equals(mainAccountId)){
		%>
		<option value="<%=faMasAccount.getId() %>" selected="selected"><%=faMasAccount.getAccDesc() %></option>
		<%}else{%>
				<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>

	<%	}
	}
		}%>
</select>
<script type="text/javascript">
showBalanceInAjax('cashVoucher');
</script>
 <input id="groupId" type="hidden"  name="groupId" value=""   />

 <input id="subGroupId"  type="hidden"   name="subGroupId" value=""  />

<label>Balance:</label>
  
 <input id="balanceAmountId" type="text"   name="<%=BALANCE_AMOUNT%>" readonly="readonly" value=""   tabindex=1 />
<input id="balanceId" type="hidden"   name="balanceAmt" readonly="readonly" value=""   tabindex=1 />
 

<div class="clear"></div>
<%--<label>Voucher No<span>*</span></label>--%>
 <input id="voucherNoId" type="hidden"  size="5" name="<%=VOUCHER_NO%>" readonly="readonly" value="<%= voucherNo %>"  MAXLENGTH="8"  tabindex=1/ >

<label>Voucher Date<span>*</span></label> 
<input type="text" name="<%=VOUCHER_DATE %>" id="voucherDate" value="<%=date %>" class="calDate" readonly="readonly" MAXLENGTH="8" />

<div class="clear"></div>
<div id="bankDetails" style="display: none;">
<label>Bank Name </label>
 <input id="bankNameId" type="text"  size="5" name="<%=BANK_NAME %>"  value=""  MAXLENGTH="40"  tabindex=1 />

<label>Cheque No. </label>
<input id="chequeNoId" type="text"  size="5" name="<%=CHEQUE_NO%>"  value=""  MAXLENGTH="20"  tabindex=1 />

<label>Cheque Date</label>
<input type="text" name="<%=CHEQUE_DATE%>" id="chequeDate" value="<%=date %>" class="calDate"  MAXLENGTH="10" validate="Check Date,date,no" />
</div>

<div class="clear"></div>

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
<div class="paddingTop15"></div>
<!--  ======================================Table for cash voucher============================================================-->
<script type="text/javascript">
	function showBankDetails(accountId){
		var accSubGrpId= "";
		<%for(FaMasAccount masAccount :accList){ %>
			if(<%=masAccount.getId()%> == accountId){
				accSubGrpId = '<%=masAccount.getAccountSubGroup().getFlag()%>';
			}
		<%}%>
		//alert("accSubGrpId=====>>"+accSubGrpId);
		if(accSubGrpId == "2"){
			document.getElementById('bankDetails').style.display = "inline"	;

		}else if(accSubGrpId == "1"){
			document.getElementById('bankDetails').style.display = "none"
		}else if(accSubGrpId == "" || accSubGrpId == "0"){
			document.getElementById('bankDetails').style.display = "none"
		}
	}

	function showGridForBank(accounId){
		var accSubGrpId= 0;
		<%for(FaMasAccount masAccount :accList){ %>
			if(<%=masAccount.getId()%> == accountId){
				accSubGrpId = '<%=masAccount.getAccountSubGroup().getId()%>';
			}
		<%}%>
		if(accSubGrpId == 2){
			document.getElementById('gridId').style.display = "inline"
			document.getElementById('gridBankId').style.display = "none"	;
			document.getElementById('flagForSL').value = 'cash';

		}else if(accSubGrpId == 1){

			document.getElementById('gridId').style.display = "none";
			document.getElementById('gridBankId').style.display = "inline"
			document.getElementById('flagForSL').value = 'bank';
		}

	}


</script>
<%-- <input type="hidden" id="flagForSL" name="flagForSL" value="bank"/>--%>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">CostCenter</th>
		<th scope="col">Narration</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%int i = 1;%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
	<td> <input id="accountNameId<%=i%>" type="text" size="42"  name="accountName<%=i%>" value=""    tabindex=1 onblur="validateAccountName(this.value,<%=i %>,'slId')" />
	<script type="text/javascript">
	document.getElementById('accountNameId<%=i%>').focus();
	</script>
	<script type="text/javascript" language="javascript" charset="utf-8">
			  function eventCallback(element, entry){
					return entry + "&schemeId=" + document.getElementById('schemeId').value;
				}
			  
			</script>
	
				<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId<%=i%>','ac2update<%=i%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName<%=i%>', callback: eventCallback});
			</script></td>
	<td id="slId<%=i %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE%><%=i%>" value=""    readonly="readonly" /></td>
	<td><select id="costCenterId<%=i %>"  name="<%=COST_CENTER_ID %><%=i%>" tabindex=1 class="small">
	<option value="0">Select</option>
	<%if(costCenterList.size()>0){
		for(MasCostCenter costCenter:costCenterList){
		%>
		<option value="<%=costCenter.getId() %>"><%=costCenter.getCostCenterName() %></option>
	<%}
		}%>
</select></td> 
	<td> <input id="accountNarrationId<%=i %>" type="text" size="20" class="large"  name="<%=ACCOUNT_NARRATION%><%=i%>" value=""   MAXLENGTH="100" tabindex=1 />
	<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNarrationId<%=i%>','ac2update<%=i%>','account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%><%=i%>'});
			</script>
	<input type="button" name="add"  value="" class="buttonAdd" onClick="addAccountsNarrationInAjax('cashVoucher',<%=i %>);" />
	</td>

	<td> <input id="amountId<%=i %>" type="text"  name="<%=AMOUNT%><%=i%>" value="" onblur="totalCrAmount('cash');"   validate="Amount,float,yes" MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	</tr>
	<tr class="background">
	<td colspan=5 class="right">Total</td>
	<td><input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" validate="Total Amount,float,yes" value="" MAXLENGTH="100" tabindex=1 /></td>
	</tr>
	
	
	<tr class="background">
	<td colspan=4 class="right">Total Receipt Control Fig.</td>
	<td><input id="totalDrId" type="text" size="10" class="readOnlySmall" readonly="readonly" name="totalDr" value="<%=totalAmountDr != null?totalAmountDr:"" %>" validate="Total DrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
	<td><input id="totalCrId" size="10" type="text" class="readOnlySmall" readonly="readonly" name="totalCr" value="<%=totalAmountCr != null?totalAmountCr:"" %>" validate="Total CrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
	</tr>
	</table>
		<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
	
<!--  ====================================================End cash voucher table==============================-->

<!--  ====================================================Start Bank voucher table==============================-->
<%-- 
<div id="gridBankId">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="bankDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">CostCenter</th>
		<th scope="col">Narration</th>
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
		 	new Ajax.Autocompleter('accountNameBankId<%=inc%>','ac2updates<%=inc%>','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountNameBank<%=inc%>'});
		</script></td>

	<td id="bankSlId<%=inc %>"> <input  type="text"   name="<%=SUB_LEDGER_CODE_BANK%><%=inc%>" value=""   MAXLENGTH="8" tabindex=1 /></td>
	<td><select id="costCenterBankId<%=inc %>" class="small" name="<%=COST_CENTER_ID_BANK %><%=inc%>" >
	<option value="0">Select</option>
	<%if(costCenterList.size()>0){
		for(MasCostCenter costCenter:costCenterList){
		%>
		<option value="<%=costCenter.getId() %>"><%=costCenter.getCostCenterName() %></option>
	<%}
		}%>
</select></td>
	<td> <input id="accountNarrationBankId<%=inc %>" size="15" type="text" class="large"  name="<%=ACCOUNT_NARRATION_BANK%><%=inc%>" value=""   MAXLENGTH="100" tabindex=1 />
	<div id="ac2updates<%=inc%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNarrationBankId<%=inc%>','ac2updates<%=inc%>','account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION_BANK%><%=inc%>'});
			</script>
	<input type="button" name="add"  value="" class="buttonAdd" onClick="addAccountsNarrationInAjax('cashVoucher',<%=inc %>);" tabindex=1 />
	</td>
	<td><input id="bankNameId<%=inc %>" type="text" size="10" name="<%=BANK_NAME%><%=inc%>" value=""    MAXLENGTH="8" tabindex=1 /></td>
	<td><input id="checkNoId<%=inc %>" type="text" size="8" name="<%=CHEQUE_NO%><%=inc%>" value=""    MAXLENGTH="8" tabindex=1 /></td>
	<td><input id="checkDateId<%=inc %>" type="text" size="10" name="<%=CHEQUE_DATE%><%=inc%>" value=""  class="calDate"   MAXLENGTH="8" tabindex=1 />
	</td>
	<td> <input id="amountBankId<%=inc %>" type="text" size="6" name="<%=AMOUNT_BANK%><%=inc%>" value="" onblur="totalCrAmount('bank');validateAmount(this.value,<%=inc%>);"   MAXLENGTH="8" tabindex=1 />
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRowForBank();" tabindex="1" /></td>
	</tr>
	</table>
	<input type="button" name="delete1" class="buttonDel" onClick="removeBankRow();" />
	</div>
<!--  ====================================================End Bank voucher table==============================-->
--%>
	
<%-- 	<label>Total</label>
	<input id="totalAmountId" type="text"   name="<%=TOTAL_AMOUNT %>" value="" MAXLENGTH="100" tabindex=1 />--%>
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
	<%-- <input type="hidden" value="<%=inc %>" name="hiddenValueChargeForBank" id="hiddenValueChargeForBank" />--%>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Narration</label>

<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="extraLarge"	 MAXLENGTH="190" tabindex=1 />


<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('voucherNarrationId','ac2update','account?method=getNarrationForAutoComplete',{parameters:'requiredField=<%=NARRATION %>'});
			</script>

<input type="button" name="add" id="addbutton" value="Add TO Template" class="buttonBig" onClick="addNarrationInAjax('cashVoucher');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('cashVoucher','account?method=submitReceiptVoucher','validateNarration','validateFieldsFrCashVoucher');" accesskey="a" tabindex=1 />
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
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration),callback: eventCallback});


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
	e4.name='<%=ACCOUNT_NARRATION%>'+ (iteration);
	e4.id='accountNarrationId'+(iteration);
	e4.size='20';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
  	 cell4.appendChild(e4);
    cell4.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNarrationId'+ (iteration),'ac2update'+iteration,'account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION%>'+ (iteration)});

	var e41 = document.createElement('input');
	e41.type = 'button';
	e41.name='add';
	e41.className = 'buttonAdd';
	e41.tabIndex="1";
	e41.onclick = function(){
					addAccountsNarrationInAjax('cashVoucher', (iteration));

	}
	cell4.appendChild(e41);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.id='amountId'+(iteration);
	e5.setAttribute('validate','Amount,float,no');
	e5.onblur = function(){
					totalCrAmount('cash');
	}
	cell5.appendChild(e5);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.tabIndex="1";
	e6.onclick = function(){
					addRow();
	}
	cell6.appendChild(e6);
}


function removeRow()
{
	var tbl = document.getElementById('voucherDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-3==0){
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
</script>
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
  	new Ajax.Autocompleter('accountNameId'+ (iteration),'ac2update'+iteration,'account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'+ (iteration)});


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
	var e3 = document.createElement('select');
	e3.name='<%=COST_CENTER_ID_BANK%>'+ (iteration);
	e3.id='costCenterBankId'+(iteration);
	e3.options[0] = new Option('Select', '0');
	for(var k = 0;k<costCenterArray.length;k++){
		e3.options[k+1] = new Option(costCenterArray[k][1],costCenterArray[k][0]);
	}
	e3.className = 'small';
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=ACCOUNT_NARRATION_BANK%>'+ (iteration);
	e4.id='accountNarrationBankId'+(iteration);
	e4.size='15';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
  	 cell4.appendChild(e4);
    cell4.appendChild(newdiv);
  	new Ajax.Autocompleter('accountNarrationBankId'+ (iteration),'ac2update'+iteration,'account?method=getAccountNarrationForAutoComplete',{parameters:'requiredField=<%=ACCOUNT_NARRATION_BANK%>'+ (iteration)});

	var e41 = document.createElement('input');
	e41.type = 'button';
	e41.name='add';
	e41.className = 'buttonAdd';
	e41.tabIndex="1";
	e41.onclick = function(){
					addAccountsNarrationInAjax('cashVoucher', (iteration));

	}
	cell4.appendChild(e41);



	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=BANK_NAME%>'+ (iteration);
	e5.size='10';
	e5.id='bankNameId'+(iteration);
	cell5.appendChild(e5);


	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=CHEQUE_NO%>'+ (iteration);
	e6.size='6';
	e6.id='checkNoId'+(iteration);
	cell6.appendChild(e6);


	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=CHEQUE_DATE%>'+ (iteration);
	e7.size='10';
	e7.id='checkDateId'+(iteration);
	cell7.appendChild(e7);
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.class = 'calender';
	eImg.style.display ='inline';
	eImg.onclick = function(event){
					setdate('',document.getElementById('checkDateId'+iteration),event) };
	cell7.appendChild(e7);
	cell7.appendChild(eImg);

	var cell8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=AMOUNT_BANK%>'+ (iteration);
	e8.size='6';
	e8.id='amountBankId'+(iteration);
	e8.onblur = function(){
					totalCrAmount('bank');
	}
	cell8.appendChild(e8);

	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'button';
	e9.name='add';
	e9.size = '6'
	e9.className = 'buttonAdd';
	e9.tabIndex="1";
	e9.onclick = function(){
					addRowForBank();
	}
	cell9.appendChild(e9);
}

--%>


<script type="text/javascript">
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
		    	//var flagForSL = document.getElementById('flagForSL').value;
		    	//submitProtoAjaxWithDivName('cashVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc+'&flagForSL='+flagForSL,tdid+inc);
		    	submitProtoAjaxWithDivName('cashVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc,tdid+inc);
		    }
	}
}


function validateNarration(){
var errMsg = "";
	var vNarrationId = document.getElementById('voucherNarrationId').value;
	var cashAccountId = document.getElementById('mainAccountId2').value;
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
				if(document.getElementById('amountId'+i)!=null && !isNaN(document.getElementById('amountId'+i).value))
					{
				 drAmt = document.getElementById('amountId'+i).value;
					}
				else{
					drAmt=0;
				}
				}else {
					if(document.getElementById('amountBankId'+i)!=null && !isNaN(document.getElementById('amountBankId'+i).value))
						{
				 drAmt = document.getElementById('amountBankId'+i).value;
						}
					else
						{
						drAmt=0;
						}
				}
				totalAmount = parseFloat(totalAmount)+parseFloat(drAmt);

			}
			document.getElementById('totalAmountId').value = totalAmount;
			if(parseFloat(drAmt) !=0){
				 if(parseFloat(accountCrAmt)!=0){
				 	 if(parseFloat(accountCrAmt) > parseFloat(drAmt) ){
				 		accountCrAmt = parseFloat(accountCrAmt)- parseFloat(drAmt);
				 		document.getElementById('balanceAmountId').value = accountCrAmt+" Cr";
				 	 }else if(parseFloat(drAmt) > parseFloat(accountCrAmt)){
				 		accountDrAmt =parseFloat(drAmt) - parseFloat(accountCrAmt);
				 		document.getElementById('balanceAmountId').value = accountDrAmt+" Dr";
				 	 }else if(parseFloat(drAmt) == parseFloat(accountCrAmt)){
				 		accountCrAmt =parseFloat(accountCrAmt)-parseFloat(drAmt) ;
				 		document.getElementById('balanceAmountId').value = accountCrAmt+" Cr";
			 		 }
					 }else {
			 		  accountDrAmt = parseFloat(accountDrAmt)+parseFloat(drAmt);
		 		 	  document.getElementById('balanceAmountId').value = accountDrAmt+" Dr";
				  }
				}
		}

		function validateFieldsFrCashVoucher(){
		var msg ="";
		var count = document.getElementById('hiddenValueCharge').value;
		//var flagForGrid = document.getElementById('flagForSL').value;

			for(i=1; i<= count; i++){

			/*if(flagForGrid == 'bank'){
				if(document.getElementById('accountNameBankId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  }
  				  if(document.getElementById('bankNameId'+i).value == ""){
  					msg += "Bank can not be blank.\n";
  				  }
		  			if(document.getElementById('amountBankId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
  				  }

  				  }else{*/
		  			if(document.getElementById('accountNameId'+i)!=null&& document.getElementById('accountNameId'+i).value == ""){
  					msg += "Account can not be blank.\n";
  				  	}
		  			if(document.getElementById('amountId'+i)!=null && document.getElementById('amountId'+i).value == ""){
	 					msg += "Amount can not be blank.\n";
  				  }

				//}
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