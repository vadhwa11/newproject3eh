<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.math.BigDecimal"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
	List<Object[]> companyAmountList = new ArrayList<Object[]>();
	List<Object[]> cashAmountList  = new ArrayList<Object[]>();
	List<Object[]> bankAmountList  = new ArrayList<Object[]>();
	List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
	List<Object[]> discountAmountList  = new ArrayList<Object[]>();
	List<Object[]> charityAmountList  = new ArrayList<Object[]>();
	List<Object[]> stdAmountList  = new ArrayList<Object[]>();
	List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
	List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
	List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
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
	if(map.get("mainChargeAmountList")!= null){
		mainChargeAmountList = (List<Object[]> )map.get("mainChargeAmountList");
	}
	if(map.get("companyAmountList")!= null){
		companyAmountList = (List<Object[]> )map.get("companyAmountList");
	}
	if(map.get("cashAmountList")!= null){
		cashAmountList = (List<Object[]> )map.get("cashAmountList");
	}
	if(map.get("bankAmountList")!= null){
		bankAmountList = (List<Object[]> )map.get("bankAmountList");
	}
	if(map.get("creditCardAmountList")!= null){
		creditCardAmountList = (List<Object[]> )map.get("creditCardAmountList");
	}
	if(map.get("charityAmountList")!= null){
		charityAmountList = (List<Object[]> )map.get("charityAmountList");
	}
	if(map.get("discountAmountList")!= null){
		discountAmountList = (List<Object[]> )map.get("discountAmountList");
	}
	if(map.get("stdAmountList")!= null){
		stdAmountList = (List<Object[]> )map.get("stdAmountList");
	}
	if(map.get("roundOffAmountList")!= null){
		roundOffAmountList = (List<Object[]> )map.get("roundOffAmountList");
	}
	if(map.get("patientTypeAmountList")!= null){
		patientTypeAmountList = (List<Object[]> )map.get("patientTypeAmountList");
	}
	if(map.get("salesMedicineAmountList")!= null){
		salesMedicineAmountList = (List<Object[]> )map.get("salesMedicineAmountList");
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

<div class="titleBg">
<h2>Sales Voucher Mapping</h2>
</div>
<form name="voucherMapping" method="post" action="">
<div class="Block">
<div class="clear"></div>
<div class="paddingTop5"></div>
<label><span>*</span>From Date:</label>
<input type="text" name="<%=FROM_DATE %>" id="from_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.voucherMapping.<%=FROM_DATE %>,event)" />

<label><span>*</span>To Date:</label>
<input type="text" name="<%=TO_DATE %>" id="to_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.voucherMapping.<%=TO_DATE %>,event)" />
<div class="clear"></div>
<input type="button" name="Submit11" id="addbutton" value="Display" class="button" onClick="submitForm('voucherMapping','account?method=dispalySalesBillingAmount');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label><span>*</span>Narration</label>
<input id="voucherNarrationId" type="text" name="<%=NARRATION %>" value="" class="large" MAXLENGTH="100" tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="small" >
	<tr><th scope="col"></th>
		<th scope="col">GL</th>
		<th scope="col">SL</th>
		<th scope="col">Dr Amount</th>
		<th scope="col">Cr Amount</th>
</tr>
	<tbody>
	<tr>
	<%
	int i = 1;
	BigDecimal totalDrAmount = new BigDecimal(0.00);
	BigDecimal totalCrAmount = new BigDecimal(0.00);
	if(mainChargeAmountList.size()>0){
			for(Object[] obj :mainChargeAmountList){
				if(obj[8] != null){
					totalCrAmount =totalCrAmount.add((BigDecimal)obj[8]);
				}
	%>
	<%if(obj[4] != null){ %>
	<td><%=(String)obj[4] %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(obj[0] != null){ %>
	<td><%=(String)obj[0] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)obj[2] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)obj[7] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)obj[6] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>

	<%if(obj[1]!= null){ %>
	<td><%=(String)obj[1] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)obj[3] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"  /></td>
	<%if(obj[8] != null){ %>
	<td><%=(BigDecimal)obj[8] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)obj[8] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	</tr>
<%i++;}} %>
<%

	if(salesMedicineAmountList.size()>0){
			for(Object[] obj :salesMedicineAmountList){
			if(obj[0] != null){
			totalCrAmount =totalCrAmount.add((BigDecimal)obj[0]);
			}
	%>

	<td>Sales Medicine</td>
	<%if(obj[1]!= null){ %>
	<td><%=(String)obj[1] %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>

	<%if(obj[3]!= null){ %>
	<td><%=(String)obj[3] %>
	<input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)obj[2] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)obj[5] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)obj[6] %>" />
	<input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)obj[4] %>" />
	</td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<td><%=0.00 %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"  /></td>
	<%if(obj[0] != null){ %>
	<td><%=(BigDecimal)obj[0] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)obj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	</tr>
<%i++;}} %>


<%-- <%
		if(companyAmountList.size()>0){
			for(Object[] comAcc :companyAmountList){

				if(comAcc[7] != null){
				totalDrAmount = totalDrAmount.add((BigDecimal)comAcc[7]);
				}
	%>
<tr>
	<td><%=(String)comAcc[0] %></td>
	<%if(comAcc[1] != null){ %>
	<td><%=(String)comAcc[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)comAcc[3] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(comAcc[2] != null){ %>
	<td><%=(String)comAcc[2] %>
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)comAcc[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)comAcc[5] %>" />
	<input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)comAcc[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(comAcc[7] != null){ %>
	<td><%=(BigDecimal)comAcc[7] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)comAcc[7] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00%>"   /></td>
	</tr>
<%i++;}} %> --%>

<%
		if(cashAmountList.size()>0){
			for(Object[] cashObj :cashAmountList){
				if(cashObj[0] != null){
				totalDrAmount = totalDrAmount.add((BigDecimal)cashObj[0]);
				}
	%>
<tr>
	<td>Cash</td>
	<%if(cashObj[1] != null){ %>
	<td><%=(String)cashObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)cashObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)cashObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)cashObj[5] %>" />
	<input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)cashObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(cashObj[2] != null){ %>
	<td><%=(String)cashObj[2] %>
	</td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(cashObj[0] != null){ %>
	<td><%=(BigDecimal)cashObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)cashObj[0] %>"    /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00%>"   /></td>
	</tr>
<%i++;}} %>

<%
		if(bankAmountList.size()>0){
			for(Object[] bankObj :bankAmountList){
				if(bankObj[0] != null){
				totalDrAmount = totalDrAmount.add((BigDecimal)bankObj[0]);
				}

	%>
<tr>
	<td>Bank</td>
	<%if(bankObj[1] != null){ %>
	<td><%=(String)bankObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)bankObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)bankObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)bankObj[5] %>" />
	<input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)bankObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(bankObj[2] != null){ %>
	<td><%=(String)bankObj[2] %>
	</td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(bankObj[0] != null){ %>
	<td><%=(BigDecimal)bankObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)bankObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %>

<%
		if(creditCardAmountList.size()>0){
			for(Object[] creditCardObj :creditCardAmountList){
				if(creditCardObj[0]!= null){
				totalDrAmount = totalDrAmount.add((BigDecimal)creditCardObj[0]);
				}

	%>
<tr>
	<td>CreditCard</td>
	<%if(creditCardObj[1] != null){ %>
	<td><%=(String)creditCardObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)creditCardObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)creditCardObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)creditCardObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(creditCardObj[2]!= null){ %>
	<td><%=(String)creditCardObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)creditCardObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(creditCardObj[0]!= null){ %>
	<td><%=(BigDecimal)creditCardObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)creditCardObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00%>"   /></td>
	</tr>
<%i++;}} %>

<%
		if(discountAmountList.size()>0){
			for(Object[] disObj :discountAmountList){
				if(disObj[0]!= null){
				totalDrAmount = totalDrAmount.add((BigDecimal)disObj[0]);
				}
	%>
<tr>
	<td>Discount</td>
	<%if(disObj[1] != null){ %>
	<td><%=(String)disObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)disObj[2] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)disObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)disObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(disObj[3] != null){ %>
	<td><%=(String)disObj[3] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)disObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(disObj[0]!= null){ %>
	<td><%=(BigDecimal)disObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)disObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %>


<%
		if(charityAmountList.size()>0){
			for(Object[] charityObj :charityAmountList){
				if(charityObj[0]!= null){
				totalCrAmount = totalCrAmount.add((BigDecimal)charityObj[0]);
				}

	%>
<tr>
	<td>Charity</td>
	<%if(charityObj[1] != null){ %>
	<td><%=(String)charityObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)charityObj[2] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)charityObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)charityObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(charityObj[3] != null){ %>
	<td><%=(String)charityObj[3] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)charityObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>

	<td>0.00<input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	
	<%if(charityObj[0]!= null){ %>
	<td><%=(BigDecimal)charityObj[0] %><input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=(BigDecimal)charityObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	</tr>
<%i++;}} %>

<%-- <%
		if(stdAmountList.size()>0){
			for(Object[] sdObj :stdAmountList){
				if(sdObj[0] != null){
				totalDrAmount = totalDrAmount.add((BigDecimal)sdObj[0]);
				}

	%>
<tr>
	<td>Std. Deduction</td>
	<%if(sdObj[1] != null){ %>
	<td><%=(String)sdObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)sdObj[2]%>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)sdObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)sdObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(sdObj[3] != null){ %>
	<td><%=(String)sdObj[3] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)sdObj[4]%>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(sdObj[0]!= null){ %>
	<td><%=(BigDecimal)sdObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmt<%=i %>" value="<%=(BigDecimal)sdObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmt<%=i %>" value="<%=0.00%>"   /></td>
	</tr>
<%i++;}} %> --%>

<%
		if(roundOffAmountList.size()>0){
			for(Object[] roundObj :roundOffAmountList){
				if(roundObj[0]!= null){
				totalDrAmount = totalDrAmount.add((BigDecimal)roundObj[0]);
				}

	%>
<tr>
	<td>Round Off.</td>
	<%if(roundObj[1] != null){ %>
	<td><%=(String)roundObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)roundObj[2]%>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)roundObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)roundObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(roundObj[3] != null){ %>
	<td><%=(String)roundObj[3] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)roundObj[4]%>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(roundObj[0]!= null){ %>
	<td><%=(BigDecimal)roundObj[0] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)roundObj[0] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %>

<%-- <%
		if(patientTypeAmountList.size()>0){
			for(Object[] patientTypeObj :patientTypeAmountList){
				if(patientTypeObj[7]!= null){
				totalDrAmount = totalDrAmount.add((BigDecimal)patientTypeObj[7]);
				}
	%>
<tr>
	<%if(patientTypeObj[0] != null){ %>
	<td><%=(String)patientTypeObj[0] %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(patientTypeObj[1] != null){ %>
	<td><%=(String)patientTypeObj[1] %><input type="hidden" id="accountId<%=i %>" name="accId<%=i %>" value="<%=(Integer)patientTypeObj[3] %>" />
	<input type="hidden" id="groupId<%=i %>" name="grpId<%=i %>" value="<%=(Integer)patientTypeObj[6] %>" />
	<input type="hidden" id="subGroupId<%=i %>" name="subGroupId<%=i %>" value="<%=(Integer)patientTypeObj[5] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(patientTypeObj[2]!= null){ %>
	<td><%=(String)patientTypeObj[2] %><input type="hidden" id="subLedgerId<%=i %>" name="subLedId<%=i %>" value="<%=(Integer)patientTypeObj[4] %>" /></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(patientTypeObj[7]!= null){ %>
	<td><%=(BigDecimal)patientTypeObj[7] %><input type="hidden" id="drAmountId<%=i %>" name="drAmtId<%=i %>" value="<%=(BigDecimal)patientTypeObj[7] %>"   /></td>
	<%}else{ %>
	<td>0.00</td>
	<%} %>
	<td>0.00<input type="hidden" id="crAmountId<%=i %>" name="crAmtId<%=i %>" value="<%=0.00 %>"   /></td>
	</tr>
<%i++;}} %> --%>


	</tbody>
</table>

<input type="hidden" id="count" name="counter" value="<%=i %>"   />
<div class="clear"></div>


	<label>Total </label>
	<label class="auto">Dr</label>
	<input id="totalDrAmountId" type="text" class="readOnly" readonly="readonly"  name="<%=TOTAL_DR_AMOUNT %>" value="<%=totalDrAmount %>"   MAXLENGTH="15" tabindex=1 />

	<label class="auto">Cr</label>
	<input id="totalCrAmountId" type="text" class="readOnly" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="<%=totalCrAmount %>"  MAXLENGTH="15" tabindex=1 />
	<div class="clear"></div>






<input type="button" name="Submit11" id="addbutton" value="Submit" class="button" onClick="submitForm('voucherMapping','account?method=postSalesVoucherMapping','validateTotalDrCr');" accesskey="a" tabindex=1 />
<div class="clear"></div>
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
