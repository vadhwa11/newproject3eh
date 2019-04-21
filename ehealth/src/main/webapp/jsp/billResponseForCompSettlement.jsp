
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<%@page import="jkt.hms.masters.business.BlFinalBillDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlCompanySettlementDetails"%>
<%@page import="jkt.hms.masters.business.BlPaymentAdviceHeader"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/calendar.js"></script>

<%

		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlOpBillHeader> opServicingList = new ArrayList<BlOpBillHeader>();
		List<BlDispensingHeader> opDispensingList = new ArrayList<BlDispensingHeader>();
		List<BlFinalBillDetails> ipBillList = new ArrayList<BlFinalBillDetails>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<BlCompanySettlementDetails> listForSettledAmt = new ArrayList<BlCompanySettlementDetails>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("opServicingList") != null){
			opServicingList= (List<BlOpBillHeader>)map.get("opServicingList");
		}
		if(map.get("opDispensingList") != null){
			opDispensingList= (List<BlDispensingHeader>)map.get("opDispensingList");
		}
		if(map.get("ipBillList") != null){
			ipBillList= (List<BlFinalBillDetails>)map.get("ipBillList");
		}
		if(map.get("bankList") != null){
			bankList= (List<MasBankMaster>)map.get("bankList");
		}
		if(map.get("listForSettledAmt") != null){
			listForSettledAmt= (List<BlCompanySettlementDetails>)map.get("listForSettledAmt");
		}

		Map<String,Object> utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
	BigDecimal totalDueAmount = new BigDecimal(0);

	%>


<%
	if(opServicingList.size() == 0 && opDispensingList.size() == 0 && ipBillList.size() == 0){
%>
<h4>No Record Found!</h4>

<%}else{ %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="Block">
<div class="clear"></div>

<label class="auto"><span>*</span> Paid Amount</label>
<input	type="text" id="amtId" name="<%=AMOUNT %>" value="" class="date"	validate="Amount,float,yes" />
<label class="auto"><span>*</span> Cheque No.</label>
<input type="text" name="<%=CHEQUE_NO %>" value=""	class="date" validate="Cheque No.,int,yes" />
<label class="auto"><span>*</span> Cheque Date</label>
<input type="text" name="<%=CHEQUE_DATE %>" class="date"	value="" validate="Cheque Date,string,yes" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" id="imgId"	onclick="javascript:setdate('<%=currentDate %>',document.companySettlement.<%=CHEQUE_DATE%>,event)" />
<label class="auto"><span>*</span> Bank</label>
<select	name="<%=BANK_ID %>" validate="Bank,string,yes">	<option value="0">Select</option>
	<%
	for(MasBankMaster bankMaster : bankList){
%>
	<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName() %></option>
	<%} %>
</select>
<div class="clear"></div>
<label>All Bill</label>
<input type="checkbox" class="radioCheck"		name="checkallOPD" id="checkallOPD" onclick="checkAllOPD();calculateTotalPaidAmt();" onchange="calculateTotalPaidAmt();" />
<div class="clear"></div>
</div>

<%} %>

<%

 	int i = 1;
 	if(opServicingList.size() > 0){
 %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>OP Bill Services Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Bill No.</th>
		<th scope="col">Bill Date</th>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
		<th scope="col">Patient Name</th>
		<th scope="col">Due Amount</th>
		<th scope="col">Settlement Amount</th>
		<th scope="col">
		</th>
	</tr>
	<%
   	    	for(BlOpBillHeader billHeader : opServicingList){
	   	    	BigDecimal dueAmt = new BigDecimal(0);
	   	    	BigDecimal advicedAmt = new BigDecimal(0);
	   	    	BigDecimal advicedcharityAmt = new BigDecimal(0);
	   	    	BigDecimal remainingAmt = new BigDecimal(0);

   	    		dueAmt = billHeader.getNetAmt();

   	    		Set<BlPaymentAdviceHeader> advHdSet = new HashSet<BlPaymentAdviceHeader>();
				if(billHeader.getBlPaymentAdviceHeaders() != null){
					advHdSet = billHeader.getBlPaymentAdviceHeaders();
					for(BlPaymentAdviceHeader advHeader : advHdSet){
						advicedAmt = advicedAmt.add(advHeader.getTotalAdviceAmt());
						if(advHeader.getTotalAdviceCharityAmt() != null){
							advicedcharityAmt = advicedcharityAmt.add(advHeader.getTotalAdviceCharityAmt());
						}

					}

					remainingAmt = advicedAmt.subtract(advicedcharityAmt);
					dueAmt = dueAmt.subtract(remainingAmt);
				}

   	    		if(listForSettledAmt.size() > 0){
	   	    		for(BlCompanySettlementDetails compDt : listForSettledAmt){
	   	    			if(compDt.getOpBillHeader() != null){
	   	    				if(billHeader.getId() == compDt.getOpBillHeader().getId()){
	   	    					dueAmt = dueAmt.subtract(compDt.getSettledAmount());
	   	    				}
	   	    			}

	   	    		}
   	    		}
   	    		if(dueAmt.compareTo(new BigDecimal(0)) > 0){


   	    %>
	<tr>
		<td><%=billHeader.getBillNo() %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(billHeader.getBillDate()) %></td>
		<td><%=billHeader.getHinNo() %></td>
		<td><%=billHeader.getPatientName() %></td>
		<td><%=dueAmt %></td>
		<td><input type="text" id="paidAmtId<%=i %>"
			name="<%=PAID_AMOUNT+i %>" value="<%=dueAmt %>" /></td>
		<td><input type="checkbox" id="billId<%=i %>"
			name="<%=BILL_ID+i %>" value="<%=billHeader.getId() %>"
			onclick="calculateTotalPaidAmt();" /> <input type="hidden"
			name="<%=HIN_ID+i %>" value="<%=billHeader.getHin().getId() %>" /> <input
			type="hidden" name="<%=BILL_TYPE+i %>" value="opservicing" /></td>
	</tr>

	<%
   	 	totalDueAmount = totalDueAmount.add(billHeader.getNetAmt());
   	    i++;}
   	    } %>
</table>
<input type="hidden" id="countOId" name="counterO" value="<%=i-1 %>" />
<%} %>

<% //int j =0;
 	if(opDispensingList.size() > 0){
 %>
<div class="clear"></div>
<div class="paddingTop40"></div>
<h4>OP Bill Dispensing Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Bill No.</th>
		<th scope="col">Bill Date</th>
		<th scope="col">HIN</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Due Amount</th>
		<th scope="col">Settlement Amount</th>
		<th scope="col"></th>
	</tr>
	<%
   	    	for(BlDispensingHeader dispensingHeader : opDispensingList){
   	    		BigDecimal dueAmt = new BigDecimal(0);
   	    		dueAmt = dispensingHeader.getNetAmt();
   	    		for(BlCompanySettlementDetails compDt : listForSettledAmt){
   	    			if(compDt.getDispensingHeader() != null){
   	    				if(dispensingHeader.getId() == compDt.getDispensingHeader().getId()){
   	    					dueAmt = dueAmt.subtract(compDt.getSettledAmount());
   	    				}
   	    			}

   	    		}
   	    		if(dueAmt.compareTo(new BigDecimal(0)) > 0){

   	    %>
	<tr>
		<td><%=dispensingHeader.getBillNo() %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(dispensingHeader.getBillDate()) %></td>
		<td><%=dispensingHeader.getHinNo() %></td>
		<td><%=dispensingHeader.getPatientName() %></td>
		<td><%=dueAmt %></td>
		<td><input type="text" id="paidAmtId<%= i%>"
			name="<%=PAID_AMOUNT+i %>" value="<%=dueAmt %>" /></td>
		<td><input type="checkbox" id="billId<%= i%>"
			name="<%=BILL_ID+i %>" value="<%=dispensingHeader.getId() %>"
			onclick="calculateTotalPaidAmt();" /> <input type="hidden"
			name="<%=HIN_ID+i %>" value="<%=dispensingHeader.getHin().getId() %>" />
		<input type="hidden" name="<%=BILL_TYPE+i %>" value="opdispensing" />
		</td>
	</tr>

	<%
   	    	totalDueAmount = totalDueAmount.add(dispensingHeader.getNetAmt());
   	    	i++;}
   	    	} %>
</table>
<input type="hidden" id="countOPD" name="counterOPD" value="<%=i-1 %>" />
<%} %>

<% //int k=0;
 	if(ipBillList.size() > 0){
 %>
<div class="clear"></div>
<div class="paddingTop40"></div>
<h4>IP Bill Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Bill No.</th>
		<th scope="col">Bill Date</th>
		<th scope="col">HIN</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Due Amount</th>
		<th scope="col">Settlement Amount</th>
		<th scope="col"></th>
	</tr>
	<%
   	    	for(BlFinalBillDetails finalBillDetails : ipBillList){
   	    		BigDecimal dueAmt = new BigDecimal(0);
   	    		dueAmt = finalBillDetails.getNetAmt();
   	    		for(BlCompanySettlementDetails compDt : listForSettledAmt){
   	    			if(compDt.getIpFinalBillDetails() != null){
   	    				if(finalBillDetails.getId() == compDt.getIpFinalBillDetails().getId()){
   	    					dueAmt = dueAmt.subtract(compDt.getSettledAmount());
   	    				}
   	    			}

   	    		}
   	    		if(dueAmt.compareTo(new BigDecimal(0)) > 0){

   	    %>
	<tr>
		<td><%=finalBillDetails.getFinalBillNo() %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(finalBillDetails.getFinalBillDate()) %></td>
		<td><%=finalBillDetails.getHin().getHinNo() %></td>
		<td><%=finalBillDetails.getHin().getPFirstName()+ " "+ finalBillDetails.getHin().getPMiddleName()+ " "+ finalBillDetails.getHin().getPLastName()%></td>
		<td><%=dueAmt %></td>
		<td><input type="text" id="paidAmtId<%=i %>"
			name="<%=PAID_AMOUNT+i %>" value="<%=dueAmt%>" /></td>
		<td><input type="checkbox" id="billId<%=i%>"
			name="<%=BILL_ID+i %>" value="<%=finalBillDetails.getId() %>"
			onclick="calculateTotalPaidAmt();" /> <input type="hidden"
			name="<%=HIN_ID+i %>" value="<%=finalBillDetails.getHin().getId() %>" />
		<input type="text" name="<%=BILL_TYPE+i %>" value="ipbill" /></td>
	</tr>

	<%
   	 		totalDueAmount = totalDueAmount.add(finalBillDetails.getNetAmt());
   	 	    i++;}
   	 	    } %>
</table>
<input type="hidden" id="countOPD" name="counterOPD" value="<%=i-1 %>" />
<%} %>

<input type="hidden" id="billCount" name="billCount" value="<%=i %>" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Due Amount</label> <input
	type="text" id="totaldueid" value="<%=totalDueAmount %>"
	class="readOnly" readonly="readonly" /> <label>Total
Settlement Amount</label> <input type="text" id="totalsettledid" value=""
	class="readOnly" readonly="readonly" /> <label>Total Balance
Amount</label> <input type="text" id="totalbalanceid" value="" class="readOnly"
	readonly="readonly" />

<div class="clear"></div>
</div>

<%
if(opServicingList.size() > 0 || opDispensingList.size() > 0 || ipBillList.size() > 0){
%>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="save" value="Submit" class="button"	onclick="submitForm('companySettlement','opBilling?method=submitCompanySettlementDetails','checkPaidAmount');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=currentDate%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
