<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.math.BigDecimal"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> companyRefundAmountList = new ArrayList<Object[]>();
	List<Object[]> companyReceiptAmountList = new ArrayList<Object[]>();
	List<Object[]> cashReceiptAmountList  = new ArrayList<Object[]>();
	List<Object[]> cashRefundAmountList  = new ArrayList<Object[]>();
	List<Object[]> bankReceiptAmountList  = new ArrayList<Object[]>();
	List<Object[]> bankRefundAmountList  = new ArrayList<Object[]>();
	List<Object[]> creditCardReceiptAmountList  = new ArrayList<Object[]>();
	List<Object[]> creditCardRefundAmountList  = new ArrayList<Object[]>();
	List<Object[]> patientTypeReceiptAmountList  = new ArrayList<Object[]>();
	List<Object[]> patientTypeRefundAmountList  = new ArrayList<Object[]>();
	if(map.get("companyRefundAmountList")!= null){
		companyRefundAmountList = (List<Object[]> )map.get("companyRefundAmountList");
	}
	if(map.get("companyReceiptAmountList")!= null){
		companyReceiptAmountList = (List<Object[]> )map.get("companyReceiptAmountList");
	}
	if(map.get("cashReceiptAmountList")!= null){
		cashReceiptAmountList = (List<Object[]> )map.get("cashReceiptAmountList");
	}
	if(map.get("cashRefundAmountList")!= null){
		cashRefundAmountList = (List<Object[]> )map.get("cashRefundAmountList");
	}
	if(map.get("bankReceiptAmountList")!= null){
		bankReceiptAmountList = (List<Object[]> )map.get("bankReceiptAmountList");
	}
	if(map.get("bankRefundAmountList")!= null){
		bankRefundAmountList = (List<Object[]> )map.get("bankRefundAmountList");
	}
	if(map.get("creditCardReceiptAmountList")!= null){
		creditCardReceiptAmountList = (List<Object[]> )map.get("creditCardReceiptAmountList");
	}
	if(map.get("creditCardRefundAmountList")!= null){
		creditCardRefundAmountList = (List<Object[]> )map.get("creditCardRefundAmountList");
	}
	if(map.get("patientTypeReceiptAmountList")!= null){
		patientTypeReceiptAmountList = (List<Object[]> )map.get("patientTypeReceiptAmountList");
	}
	if(map.get("patientTypeRefundAmountList")!= null){
		patientTypeRefundAmountList = (List<Object[]> )map.get("patientTypeRefundAmountList");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}



		%>

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

<form name="finalSettlementVoucher" method="post" action="">
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span>From Date:</label>
	<input type="text" name="<%=FROM_DATE %>" id="from_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.finalSettlementVoucher.<%=FROM_DATE %>,event)" />

<label><span>*</span>To Date:</label>
	<input type="text" name="<%=TO_DATE %>" id="to_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.finalSettlementVoucher.<%=TO_DATE %>,event)" />

<div class="clear"></div>

<input type="button" name="Submit11" id="addbutton" value="Dispaly" class="button" onClick="submitForm('finalSettlementVoucher','account?method=dispalyFinalSettlementVoucherAmount');" accesskey="a" tabindex=1 />

<div class="clear"></div>
<label><span>*</span>Narration</label>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="large" MAXLENGTH="100" tabindex=1 />
<div class="clear"></div>
</div>
<div class="paddingTop40"></div>
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="small" >
	<tr>

		<th scope="col"></th>
		<th scope="col">GL</th>
		<th scope="col">SL</th>
		<th scope="col">Dr Amount</th>
		<th scope="col">Cr Amount</th>


	</tr>
	<tbody>



<%
int i = 1;
BigDecimal totalDrAmount = new BigDecimal(0.00);
BigDecimal totalCrAmount = new BigDecimal(0.00);
if(companyReceiptAmountList.size()>0){
			for(Object[] comReceiptAcc :companyReceiptAmountList){
			if(comReceiptAcc[7] != null){
			totalDrAmount = totalDrAmount.add((BigDecimal)comReceiptAcc[7]);
			}
	%>
<tr>
	<td><%=(String)comReceiptAcc[0] %></td>
	<td><%=(String)comReceiptAcc[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)comReceiptAcc[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)comReceiptAcc[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)comReceiptAcc[5] %>" /></td>
	<td><%=(String)comReceiptAcc[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)comReceiptAcc[4] %>" /></td>
	<%if(comReceiptAcc[7]!= null){ %>
	<td><%=(BigDecimal)comReceiptAcc[7] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)comReceiptAcc[7] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>

	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00%>"   /></td>
	</tr>
<%i++;}} %>

<%
if(companyRefundAmountList.size()>0){
	for(Object[] comRefundAcc :companyRefundAmountList){

	totalCrAmount = totalCrAmount.add((BigDecimal)comRefundAcc[7]);
%>
<tr>
<td><%=(String)comRefundAcc[0] %></td>
<td><%=(String)comRefundAcc[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)comRefundAcc[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)comRefundAcc[6] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)comRefundAcc[5] %>" /></td>
<td><%=(String)comRefundAcc[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)comRefundAcc[4] %>" /></td>
<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"   /></td>
<%if(comRefundAcc[7]!= null){ %>
<td><%=(BigDecimal)comRefundAcc[7] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)comRefundAcc[7] %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
</tr>
<%i++;}} %>

<%
		if(cashReceiptAmountList.size()>0){
			for(Object[] cashReceiptObj :cashReceiptAmountList){
				if(cashReceiptObj[0] != null){
				totalDrAmount = totalDrAmount.add((BigDecimal)cashReceiptObj[0]);
				}

	%>
<tr>
	<td>Cash</td>
	<td><%=(String)cashReceiptObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)cashReceiptObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)cashReceiptObj[5] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)cashReceiptObj[6] %>" /></td>
	<td><%=(String)cashReceiptObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)cashReceiptObj[4] %>" /></td>
	<%if(cashReceiptObj[0] != null){  %>
	<td><%=(BigDecimal)cashReceiptObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)cashReceiptObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %>

<%
if(cashRefundAmountList.size()>0){
	for(Object[] cashRefundObj :cashRefundAmountList){
		if(cashRefundObj[0] != null){
		totalCrAmount = totalCrAmount.add((BigDecimal)cashRefundObj[0]);
		}

%>
<tr>
<td>Cash</td>
<td><%=(String)cashRefundObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)cashRefundObj[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)cashRefundObj[5] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)cashRefundObj[6] %>" /></td>
<td><%=(String)cashRefundObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)cashRefundObj[4] %>" /></td>
<td><%=0.00%><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"   />
</td>
<%if(cashRefundObj[0] != null){  %>
<td><%=(BigDecimal)cashRefundObj[0] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)cashRefundObj[0] %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
</tr>
<%i++;}} %>

<%
if(bankReceiptAmountList.size()>0){
	for(Object[] bankReceiptObj :bankReceiptAmountList){
		if(bankReceiptObj[0] != null){
		totalDrAmount = totalDrAmount.add((BigDecimal)bankReceiptObj[0]);
		}

%>
<tr>
<td>Bank</td>
<td><%=(String)bankReceiptObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)bankReceiptObj[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)bankReceiptObj[5] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)bankReceiptObj[6] %>" /></td>
<td><%=(String)bankReceiptObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)bankReceiptObj[4] %>" /></td>
<%if(bankReceiptObj[0] != null){  %>
<td><%=(BigDecimal)bankReceiptObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)bankReceiptObj[0] %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
</tr>
<%i++;}} %>


<%
if(bankRefundAmountList.size()>0){
	for(Object[] bankRefundObj :bankRefundAmountList){
		if(bankRefundObj[0] != null){
		totalCrAmount = totalCrAmount.add((BigDecimal)bankRefundObj[0]);
		}

%>
<tr>
<td>Bank</td>
<td><%=(String)bankRefundObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)bankRefundObj[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)bankRefundObj[5] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)bankRefundObj[6] %>" /></td>
<td><%=(String)bankRefundObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)bankRefundObj[4] %>" /></td>
<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"   /></td>
<%if(bankRefundObj[0] != null){  %>
<td><%=(BigDecimal)bankRefundObj[0] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)bankRefundObj[0] %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
</tr>
<%i++;}} %>

<%
if(creditCardReceiptAmountList.size()>0){
	for(Object[] creditCardReceiptObj :creditCardReceiptAmountList){
		if(creditCardReceiptObj[0] != null){
		totalDrAmount = totalDrAmount.add((BigDecimal)creditCardReceiptObj[0]);
		}

%>
<tr>
<td>Credit Card</td>
<td><%=(String)creditCardReceiptObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)creditCardReceiptObj[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)creditCardReceiptObj[5] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)creditCardReceiptObj[6] %>" /></td>
<td><%=(String)creditCardReceiptObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)creditCardReceiptObj[4] %>" /></td>
<%if(creditCardReceiptObj[0] != null){  %>
<td><%=(BigDecimal)creditCardReceiptObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)creditCardReceiptObj[0] %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
</tr>
<%i++;}} %>

<%
if(creditCardRefundAmountList.size()>0){
	for(Object[] creditCardRefundObj :creditCardRefundAmountList){
		if(creditCardRefundObj[0] != null){
		totalCrAmount = totalCrAmount.add((BigDecimal)creditCardRefundObj[0]);
		}

%>
<tr>
<td>Credit Card</td>
<td><%=(String)creditCardRefundObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)creditCardRefundObj[3] %>" />
<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)creditCardRefundObj[5] %>" />
<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)creditCardRefundObj[6] %>" /></td>
<td><%=(String)creditCardRefundObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)creditCardRefundObj[4] %>" /></td>
<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"   />
<%if(creditCardRefundObj[0] != null){  %>
<td><%=(BigDecimal)creditCardRefundObj[0] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)creditCardRefundObj[0]  %>"   /></td>
<%}else{ %>
<td>0.00</td>
<%} %>
</tr>
<%i++;}} %>



<%
		if(patientTypeReceiptAmountList.size()>0){
			for(Object[] patientTypeReceiptObj :patientTypeReceiptAmountList){
				if(patientTypeReceiptObj[7]!= null){
				totalDrAmount = totalDrAmount.add((BigDecimal)patientTypeReceiptObj[7]);
				}
	%>
<tr>
	<td><%=(String)patientTypeReceiptObj[0] %></td>
	<td><%=(String)patientTypeReceiptObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)patientTypeReceiptObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)patientTypeReceiptObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)patientTypeReceiptObj[5] %>" /></td>
	<td><%=(String)patientTypeReceiptObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)patientTypeReceiptObj[4] %>" /></td>
	<%if(patientTypeReceiptObj[7]!= null){ %>
	<td><%=(BigDecimal)patientTypeReceiptObj[7] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)patientTypeReceiptObj[7] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %>
<%
		if(patientTypeRefundAmountList.size()>0){
			for(Object[] patientTypeRefundObj :patientTypeRefundAmountList){
				if(patientTypeRefundObj[7]!= null){
				totalCrAmount = totalCrAmount.add((BigDecimal)patientTypeRefundObj[7]);
				}
	%>
<tr>
	<td><%=(String)patientTypeRefundObj[0] %></td>
	<td><%=(String)patientTypeRefundObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)patientTypeRefundObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)patientTypeRefundObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)patientTypeRefundObj[5] %>" /></td>
	<td><%=(String)patientTypeRefundObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)patientTypeRefundObj[4] %>" /></td>
	<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00%>"   /></td>
	<%if(patientTypeRefundObj[7]!= null){ %>
	<td><%=(BigDecimal)patientTypeRefundObj[7] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)patientTypeRefundObj[7] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	</tr>
<%i++;}} %>


	</tbody>
</table>

<input type="hidden" id="count" name="counter" value="<%=i %>"   />
<div class="clear"></div>




	<label>Total </label>
	<label class="auto">Dr</label>
	<input id="totalDrAmountId" type="text" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value="<%=totalDrAmount %>"   MAXLENGTH="15" tabindex=1 />

	<label class="auto">Cr</label>
	<input id="totalCrAmountId" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="<%=totalCrAmount %>"  MAXLENGTH="15" tabindex=1 />
	<div class="clear"></div>

<input type="button" name="Submit11" id="addbutton" value="Submit" class="button" onClick="submitForm('finalSettlementVoucher','account?method=postFinalSettlementVoucherMapping','validateTotalDrCr');" accesskey="a" tabindex=1 />
	<div class="clear"></div>

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

<script type="text/javascript">

function validateTotalDrCr(){
	var drTotal = document.getElementById('totalDrAmountId').value;
	var crTotal = document.getElementById('totalCrAmountId').value;
	if(parseFloat(drTotal) != parseFloat(crTotal)){
		alert("Total of Dr and Cr amount should be Equal.");
		return false;
	}
	return true;
}

</script>

<div class="clear"></div>

<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
