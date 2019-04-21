<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<AccountMainTransac> accountBalanceList = new ArrayList<AccountMainTransac>();
	List<FaVoucherDetails> voucherDtList = new ArrayList<FaVoucherDetails>();
	if(map.get("accountBalanceList") != null){
		accountBalanceList = (List<AccountMainTransac>)map.get("accountBalanceList");
	}
	if(map.get("voucherDtList") != null){
		voucherDtList = (List<FaVoucherDetails>)map.get("voucherDtList");
	}
	System.out.println("voucherDtList==="+voucherDtList.size());
	BigDecimal clBlnc = new BigDecimal(0);
	String drCr = "";
//	FaMasAccount faAccount = new FaMasAccount();
	if(accountBalanceList.size() > 0){
		for(AccountMainTransac faAccount:accountBalanceList){
		if(faAccount.getClBalanceCr() != null && faAccount.getClBalanceCr().compareTo(new BigDecimal(0)) > 0){
			clBlnc = faAccount.getClBalanceCr();
			drCr = "Cr";
		}else if(faAccount.getClBalanceDr() != null && faAccount.getClBalanceDr().compareTo(new BigDecimal(0)) > 0){
			clBlnc = faAccount.getClBalanceDr();
			drCr = "Dr";
		}
	}
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

%>


<div class="Block">
<label class="auto">Balance As Per Company Book</label>
<input type="text" id="compBlnc" name="<%=COMPANY_BALANCE %>" value="<%=clBlnc %>" class="readOnlySmall"/>
<input type="hidden" id="compBlncHidden" name="compBlncHid" value="<%=clBlnc %>" class="readOnlySmall"/>
<input type="text" id="blncType" name="<%= BALANCE_TYPE %>" value="<%=drCr %>" class="readOnlySmall"/>
<label class="auto">Balance As Per Bank Book</label>
<input type="text" id="bankBlnc" name="bankBlnc" value="" class="date" onblur="calculateDiffrence();"/>
<select name="bankBlncType" id="bankBlncType" class="smallest" onchange="calculateDiffrence();">
<option value="">Select</option>
<option value="Dr">Dr</option>
<option value="Cr">Cr</option>
</select>
<div class="clear"></div>
<label>Difference</label>
<input type="text" id="difference" name="difference" class="readOnlySmall" value=""/>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%
int i=1;
//if(voucherDtList.size() > 0){ 
%>
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Cheque Date</th>
		<th scope="col">Voucher Type</th>
		<th scope="col">Cheque No</th>
		<th scope="col">Amount</th>
		<th scope="col">Cheque Status</th>
		<th scope="col">Date</th>
		<th scope="col">&nbsp;</th>
	</tr>
	<%
for( i=1;i<=4;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text" readonly="readonly" name="<%= CHEQUE_DATE+i %>" id="chequeDate<%=i %>" value=""/>
			</td>
			
			<td><input type="text" readonly="readonly" id="vType<%=i  %>" name="<%=VOUCHER_TYPE+i  %>" value=""/>
			<input type="text" name="<%=VOUCHER_HD_ID+i %>" id="vhId<%=i %>" value=""/>
			<input type="hidden" name="<%=VOUCHER_DT_ID+i %>" value=""/>
			</td>


			 <td>
			<%-- <input type="hidden" name="<%=CHEQUE_NO+i %>" value=""/> --%>
			<select name="<%=CHEQUE_NO+i %>" id="chequeNoId<%=i %>" disabled="disabled" onchange="getDetailsForCheckNo(this.value,<%=i%>);">
			<option value="0">Select</option>
			<%for(FaVoucherDetails d:voucherDtList){
				if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=d.getVoucherHeader().getId()%>"><%=d.getVoucherHeader().getChequeNo()%></option>
			<%}} %>
			</select>
			
			</td>
			
			<td>
			
			<input  type="text" id="amt<%=i  %>" name="<%=AMOUNT+i  %>" value=""/>
						<input  type="hidden" id="amtId2<%=i  %>" name="amt22<%=i %>" value=""/>
			</td>
			<td>
			<select id="chqStatus<%=i %>" name="<%= CHEQUE_STATUS+i %>" onchange="calculateBalanceAmt2(<%=i %>)">
				<option value="">Select</option>
				
				<option value="1">1.Cheque Issued not presented for payment</option>
				<option value="2">2.Credit Entries made in bank passbook not in cash book</option>
				<option value="3">3.Amount sent to bank but not credited in the saving bank accounts</option>
				<option value="4">4.Bank Charges debited in the Bank Acccount but not accounted for in the cash book</option>

				
			</select>
			</td>
			<td><input type="text"  name="clearingDate<%=i %>" value="" validate="Date,string,no" class="calDate" MAXLENGTH="30" readonly="readonly" />
			<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.faBankReconciliation.clearingDate<%=i %>,event);" />
			</td>
			<td><input type="button" value="add transac" onclick="popoupforTransaction(<%=i %>);" />
			</td>
		<%--<input type="text" class="date" name="transactionDate" id="transactionDateId<%=i %>" value="" />
		<input type="text"  name="transactionAmount" id="transactionAmountId<%=i %>" value="" />
		<input type="text"  name="Narration" id="narrationId<%=i %>" value="" />
		<input type="text"  name="transactionType" id="transactionType<%=i %>" value="" /> --%>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>

<%//}else{ %>

<%//} %>
<input type="hidden" id="counter" name="counter" value="<%= i %>"/>
<div class="clear"></div>
<input type="button" name="save" value="Save" class="button" onclick="submitForm('faBankReconciliation','/hms/hms/account?method=saveBankReconciliationDetails');"/>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<script>
function setvalueToParent(rowNum){
	//alert("in method");
	window.opener.document.getElementById('transactionDateId'+rowNum).value=window.opener.document.getElementById('transactionDateId'+rowNum).value;
	window.opener.document.getElementById('transactionAmountId'+rowNum).value=window.opener.document.getElementById('transactionAmountId'+rowNum).value;
	window.opener.document.getElementById('narrationId'+rowNum).value=window.opener.document.getElementById('narrationId'+rowNum).value;

	window.opener.document.getElementById('transactionType'+rowNum).value=window.opener.document.getElementById('transactionType'+rowNum).value;

}
</script>
