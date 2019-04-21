<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherDetails> cashVoucherDetailList= new ArrayList<FaVoucherDetails>();
	List<FaMasAccount> cashAccountList = new ArrayList<FaMasAccount>();
	List<AccountMainTransac>accountTransacList=new ArrayList<AccountMainTransac>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	} 
	int mainAccountId = 0;
	if(map.get("mainAccountId") != null){
		mainAccountId = (Integer)map.get("mainAccountId");
	}
	String accountName = "";
	if(map.get("accountName") != null){
		accountName = (String)map.get("accountName");
	}
	if(map.get("voucherDetailList")!= null){
		voucherDetailList = (List<FaVoucherDetails>)map.get("voucherDetailList");
	}
	if(map.get("cashVoucherDetailList")!= null){
		cashVoucherDetailList = (List<FaVoucherDetails>)map.get("cashVoucherDetailList");
	}
	if(map.get("cashAccountList")!= null){
		cashAccountList = (List<FaMasAccount>)map.get("cashAccountList");
	}
	if(map.get("accountTransacList")!=null){
		accountTransacList=(List<AccountMainTransac>)map.get("accountTransacList");
	}
	System.out.println("accountTransacList jsop--"+accountTransacList.size());
	
	String fromDate = "";
	String toDate = "";
	if(map.get("fromDate")!= null){
		fromDate = (String)map.get("fromDate");
	}
	if(map.get("toDate")!= null){
		toDate = (String)map.get("toDate");
	}
%>



<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>

<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>

<form name="ledger" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Cash Book</h4>
<div class="clear"></div>
<div class="clear"></div>


<label><span>*</span> Cash Account</label>
<label class="value"><%=accountName %></label>
<input type="hidden" name="ledgerAccount" value="<%=mainAccountId %>" />

<div class="right">
<label ><%=fromDate %></label>
<label class="small">To</label>
<label><%=toDate %></label>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table>
	<tr>
		
		<th scope="col">Date</th>
		<th scope="col">Particulars</th>
		<th scope="col">Voucher Type</th>
		<th scope="col">Voucher No.</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
	</tr>
	<tbody id="tableData">
	<%
	BigDecimal totalDrAmount = new BigDecimal(0.0);
	BigDecimal totalCrAmount = new BigDecimal(0.0);
	BigDecimal closingDrAmount = new BigDecimal(0.0);
	BigDecimal closingCrAmount = new BigDecimal(0.0);
	BigDecimal closingDrAmount2 = new BigDecimal(0.0);
	BigDecimal closingCrAmount2 = new BigDecimal(0.0);
	String accountsDesc = "";
	Date voucherDate = null;
	String voucherType = "";
	int accId = 0;
	%>
	<tr class="background"> 
	<td colspan="4" class="right">Opening</td>
		<%if(cashAccountList.size()>0){
	for(FaMasAccount masAccount:cashAccountList){
		
		if(masAccount.getOpBalanceCr() != null){
			closingCrAmount = masAccount.getOpBalanceCr().add(totalDrAmount);
		}
		if( masAccount.getOpBalanceDr() != null){
		closingDrAmount = masAccount.getOpBalanceDr().add(totalCrAmount);
		}
		//closingCrAmount = masAccount.getClBalanceCr();
		//closingDrAmount = masAccount.getClBalanceDr();

	%>
	<%if(masAccount.getOpBalanceDr() != null && !masAccount.getOpBalanceDr().equals(new BigDecimal("0.00"))) {%>
	<td colspan=""  class="right"><%=masAccount.getOpBalanceDr() %></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
	<%if(masAccount.getOpBalanceCr()!= null && !masAccount.getOpBalanceCr().equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=masAccount.getOpBalanceCr() %></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
	
<%}} %>
	</tr>
	
	
	<%
	
	
	if(voucherDetailList.size()>0){
		for(FaVoucherDetails faVoucherDetails : voucherDetailList){
			//FaVoucherDetails voucherDetails = ledgerVoucherDetailList.get(0);
			for(FaVoucherDetails voucherDetails : cashVoucherDetailList){
			FaVoucherHeader voucherHeader = voucherDetails.getVoucherHeader();
			if(voucherHeader.getId().equals(faVoucherDetails.getVoucherHeader().getId())){	
				
		%>
	<tr>
	<%
	if(!faVoucherDetails.getAccount().getId().equals(voucherDetails.getAccount().getId())){
		accountsDesc = faVoucherDetails.getAccount().getAccDesc();
		accId = faVoucherDetails.getAccount().getId();
		voucherDate = faVoucherDetails.getVoucherHeader().getVoucherDate();
		voucherType = faVoucherDetails.getVoucherHeader().getVoucherType();
	
	%>
	<%if(voucherDate != null){%>
	<td><%=HMSUtil.convertDateToStringWithoutTime(faVoucherDetails.getVoucherHeader().getVoucherDate()) %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(accountsDesc != null){ %>
	<td onclick="openPopUp(<%=accId %>)"><%=accountsDesc%></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(voucherType.equals("PU")){ %>
	<td>Purchase</td>
	<%}else if(voucherType.equals("PV")){ %>
	<td>Payment</td>
	<%}else if(voucherType.equals("SV")){ %>
	<td>Sales</td>
	<%}else if(voucherType.equals("SR")){ %>
	<td>Sales Return</td>
	<%}else if(voucherType.equals("PR")){ %>
	<td>Purchase Return</td>
	<%}else if(voucherType.equals("JV")){ %>
	<td>Journal</td>
	<%}else if(voucherType.equals("RV")){ %>
	<td>Receipt Voucher</td>
	<%} %>
	<%if(faVoucherDetails.getVoucherHeader().getVoucherNo()!= null){ %>
	<td><%=faVoucherDetails.getVoucherHeader().getVoucherNo() %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%
	//if(faVoucherDetails.getAccount().getId().equals(voucherDetails.getAccount().getId())){
	if(faVoucherDetails.getCrAmount() != null){
	 	totalCrAmount = totalCrAmount.add(faVoucherDetails.getCrAmount());
	 	
	%>
	<td class="right"><%=faVoucherDetails.getCrAmount() %></td>
	<%}else{%>
	<td class="right">--</td>
	
	<%}%>
	<%
		if(faVoucherDetails.getDrAmount() != null){
			totalDrAmount = totalDrAmount.add(faVoucherDetails.getDrAmount());
		 %>
	<td class="right"><%=faVoucherDetails.getDrAmount() %></td>
	<%}else{%>
	<td class="right">--</td>
	<%}%>	
	</tr>
	<%}}}}} %>
	
<tr class="background" > 
	<td colspan="4"  class="right">Closing Balance</td>
	<%for(AccountMainTransac amt:accountTransacList){ %>
	<%if(amt.getClBalanceDr()!=null && !amt.getClBalanceDr().equals(new BigDecimal(0.00))){
		closingDrAmount=amt.getClBalanceDr();
	}else if(amt.getClBalanceCr()!=null && !amt.getClBalanceCr().equals(new BigDecimal(0.00))){
		closingCrAmount=amt.getClBalanceCr();
	}
	if(amt.getYtdAmountCr()!=null && !amt.getYtdAmountCr().equals(new BigDecimal(0.00))){
	closingCrAmount2=amt.getYtdAmountCr();
	}if(amt.getYtdAmountDr()!=null && !amt.getYtdAmountDr().equals(new BigDecimal(0.00))){
		closingDrAmount2=amt.getYtdAmountDr();
	}
	
	}
	
	 %>
	
	<%if(closingCrAmount != null && !closingCrAmount.equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=closingCrAmount %></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
	<%if(closingDrAmount != null && !closingDrAmount.equals(new BigDecimal("0.00"))){%>
	<td colspan=""  class="right"><%=closingDrAmount%></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
		</tr>
	
<tr class="background"> 
	<td colspan="4"  class="right">Current Total</td>
	<%if(totalCrAmount != null && !totalCrAmount.equals(new BigDecimal("0.00"))){%>
	<td colspan=""  class="right"><%=totalCrAmount%></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
	<%if(totalDrAmount != null && !totalDrAmount.equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=closingDrAmount2 %></td>
	<%}else{%>
	<td colspan=""  class="right">--</td>
	<%} %>
		</tr>
	
	
	</tbody>
	</table>

	
	
<div class="clear"></div>


<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);

		function openPopUp(val)
		{
				window.open('account?method=showSubLedgerPopupJsp&accountId='+val,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

		}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>