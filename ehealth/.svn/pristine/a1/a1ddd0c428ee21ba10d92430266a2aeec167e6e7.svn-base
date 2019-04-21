<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
	List<FaVoucherDetails> ledgerVoucherDetailList= new ArrayList<FaVoucherDetails>();
	List<FaMasAccount> ledgerAccountList = new ArrayList<FaMasAccount>();
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
	if(map.get("ledgerVoucherDetailList")!= null){
		ledgerVoucherDetailList = (List<FaVoucherDetails>)map.get("ledgerVoucherDetailList");
	}
	if(map.get("ledgerAccountList")!= null){
		ledgerAccountList = (List<FaMasAccount>)map.get("ledgerAccountList");
	}
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

<%@page import="jkt.hms.masters.business.FaVoucherHeader"%><form name="ledger" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Ledger Voucher</h4>
<div class="clear"></div>
<div class="clear"></div>

<label><span>*</span> Ledger</label>
<label class="value"><%=accountName %></label>
<input type="hidden" name="ledgerAccount" value="<%=mainAccountId %>" />




<div class="right">
<label ><%=fromDate %></label>
<label class="auto value">To</label>
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
	String accountsDesc = "";
	Date voucherDate = null;
	String voucherType = "";
	int accId = 0;
	if(voucherDetailList.size()>0){
		for(FaVoucherDetails faVoucherDetails : voucherDetailList){
			//FaVoucherDetails voucherDetails = ledgerVoucherDetailList.get(0);
			for(FaVoucherDetails voucherDetails : ledgerVoucherDetailList){
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
	
	<tr class="background"> 
	<td colspan="4" class="right">Opening</td>
	<%if(ledgerAccountList.size()>0){
	for(FaMasAccount masAccount:ledgerAccountList){
		
	if(masAccount.getOpBalanceCr()!= null){
		closingCrAmount = masAccount.getOpBalanceCr().add(totalDrAmount);
	}
	if(masAccount.getOpBalanceDr()!= null){
		closingDrAmount = masAccount.getOpBalanceDr().add(totalCrAmount);
	}
		//closingCrAmount = masAccount.getClBalanceCr();
		//closingDrAmount = masAccount.getClBalanceDr();
	%>
	<%if(masAccount.getOpBalanceDr() != null && !masAccount.getOpBalanceDr().equals(new BigDecimal("0.00"))) {%>
	<td colspan=""  class="right"><%=masAccount.getOpBalanceDr() %></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
	<%} %>
	<%if(masAccount.getOpBalanceCr()!= null && !masAccount.getOpBalanceCr().equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=masAccount.getOpBalanceCr() %></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
	<%} %>
	
<%}} %>
	</tr>

<tr class="background"> 
	<td colspan="4"  class="right">Current Total</td>
	<%if(totalCrAmount != null && !totalCrAmount.equals(new BigDecimal("0.00"))){%>
	<td colspan=""  class="right"><%=totalCrAmount%></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
	<%} %>
	<%if(totalDrAmount != null && !totalDrAmount.equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=totalDrAmount %></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
	<%} %>
		</tr>
	
<tr class="background" > 
	<td colspan="4"  class="right">Closing Balance</td>
	<%if(closingDrAmount != null && !closingDrAmount.equals(new BigDecimal("0.00"))){%>
	<td colspan=""  class="right"><%=closingDrAmount%></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
	<%} %>
	<%if(closingCrAmount != null && !closingCrAmount.equals(new BigDecimal("0.00"))){ %>
	<td colspan=""  class="right"><%=closingCrAmount %></td>
	<%}else{%>
	<td colspan=""  class="right">0</td>
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
				window.open('account?method=showSubLedghmsopupJsp&accountId='+val,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

		}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
