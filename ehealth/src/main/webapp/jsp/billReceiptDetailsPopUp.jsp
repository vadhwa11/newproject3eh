<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.BlReceiptHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceHeader"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispDetails"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispHeader"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<div class="titleBg">
<h2>Payment Details</h2>
</div>
<div class="clear"></div>
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<BlReceiptHeader> receiptList = new ArrayList<BlReceiptHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("receiptList") != null){
		receiptList = (List<BlReceiptHeader>)map.get("receiptList");
	}
	
	
%>
<%
for(BlReceiptHeader receiptHeader : receiptList){
		if(receiptHeader.getReceiptType().equals("chs")){
%>
<div class="paddingTop15"></div>
<h4>Servicing</h4>
<div class="division"></div>
<div class="clear"></div>
<table class="small" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Receipt No</th>
		<th scope="col">Charge Slip No</th>
		<th scope="col">Charge Slip Amount</th>
		<th scope="col">Refunded Amount</th>
		<th scope="col">Receipt Date</th>
	</tr>
	<%break;}
		}%>
	<%
   	   		 Set<BlPaymentAdviceHeader> advHdSet = new HashSet<BlPaymentAdviceHeader>(); 
   	    	BigDecimal totalAdvAmt = new BigDecimal(0);
   	    	int i=1;
   	    	for(BlReceiptHeader receiptHeader : receiptList){
   	    		if(receiptHeader.getReceiptType().equals("chs")){
   	    		if(receiptHeader.getChargeSlipMain().getBlPaymentAdviceHeaders() != null)
   	    			advHdSet = receiptHeader.getChargeSlipMain().getBlPaymentAdviceHeaders();
   	    		
   	    		if(advHdSet.size() > 0){
	   	    		for(BlPaymentAdviceHeader advHd : advHdSet){
	   	    			totalAdvAmt = totalAdvAmt.add(advHd.getTotalAdviceAmt());
	   	    		}
   	    		}
   	    %>
	<tr>
		<td><%=i %></td>
		<td><%=receiptHeader.getReceiptNo() %></td>
		<td><%=receiptHeader.getChargeSlipMain().getChargeSlipNo() %></td>
		<td><%=receiptHeader.getAmount() %></td>
		<td><%=totalAdvAmt %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(receiptHeader.getReceiptDate())%></td>
	</tr>
	<%
   	    i++;}
   	    }%>
</table>

<div class="clear"></div>
<%
for(BlReceiptHeader receiptHeader : receiptList){
		if(receiptHeader.getReceiptType().equals("bld")){
%>
<div class="paddingTop15"></div>
<h4>Dispensing</h4>
<div class="division"></div>
<div class="clear"></div>

<table class="small" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Receipt No</th>
		<th scope="col">Bill No</th>
		<th scope="col">Amount</th>
		<th scope="col">Refunded Amount</th>
		<th scope="col">Receipt Date</th>
	</tr>
	<%
   	    	break;}
		
		}%>
	<%
   	    	int j=1;

	   		 Set<BlPymntAdviceDispHeader> advDispHdSet = new HashSet<BlPymntAdviceDispHeader>(); 
	    	BigDecimal totalDispAdvAmt = new BigDecimal(0);
   	    	for(BlReceiptHeader receiptHeader : receiptList){
   	    		if(receiptHeader.getReceiptType().equals("bld")){
   	    			if(receiptHeader.getDispensingHeader().getBlPymntAdviceDispHeaders() != null)
   	    				advDispHdSet = receiptHeader.getDispensingHeader().getBlPymntAdviceDispHeaders();
   	   	    		
   	   	    		if(advDispHdSet.size() > 0){
   		   	    		for(BlPymntAdviceDispHeader advHd : advDispHdSet){
   		   	    		totalDispAdvAmt = totalDispAdvAmt.add(advHd.getTotalAdviceAmt());
   		   	    		}
   	   	    		}
   	    %>
	<tr>
		<td><%=j %></td>
		<td><%=receiptHeader.getReceiptNo() %></td>
		<td><%=receiptHeader.getDispensingHeader().getBillNo() %></td>
		<td><%=receiptHeader.getAmount() %></td>
		<td><%=totalDispAdvAmt %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(receiptHeader.getReceiptDate())%></td>
	</tr>
	<%
   	    j++;}}
   	    		%>
</table>

<div class="clear"></div>
<%
for(BlReceiptHeader receiptHeader : receiptList){
		if(receiptHeader.getReceiptType().equals("pkb")){
%>
<div class="paddingTop15"></div>
<h4>Package</h4>
<div class="division"></div>
<div class="clear"></div>

<table class="small" width="100%" border="0" cellspacing="0"
	cellpadding="0">

	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Receipt No</th>
		<th scope="col">Package Bill No</th>
		<th scope="col">Amount</th>
		<th scope="col">Receipt Date</th>
	</tr>
	<%break;
   	    }
   	    }%>
	<%
   	    	int k=1;
   	    	for(BlReceiptHeader receiptHeader : receiptList){
   	    		if(receiptHeader.getReceiptType().equals("pkb")){
   	    %>
	<tr>
		<td><%=k %></td>
		<td><%=receiptHeader.getReceiptNo() %></td>
		<td><%=receiptHeader.getPackageBill().getPackageBillNo() %></td>
		<td><%=receiptHeader.getAmount() %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(receiptHeader.getReceiptDate())%></td>
	</tr>
	<%
   	    k++;}
   	    		}%>
</table>

<div class="clear"></div>
<input type="button" name="close" value="Close" class="button"
	onclick="window.close();" />
	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
