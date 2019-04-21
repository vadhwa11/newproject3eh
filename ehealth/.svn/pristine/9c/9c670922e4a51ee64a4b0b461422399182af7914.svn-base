<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BlPackageServicesDetails"%>
<%@page import="jkt.hms.masters.business.BlPackageMedicineDetails"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlPackageServicesDetails> pkgServList = new ArrayList<BlPackageServicesDetails>();
	List<BlPackageMedicineDetails> pkgMedList = new ArrayList<BlPackageMedicineDetails>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("pkgServList") != null){
		pkgServList = (List<BlPackageServicesDetails>)map.get("pkgServList");
	}
	if(map.get("pkgMedList") != null){
		pkgMedList = (List<BlPackageMedicineDetails>)map.get("pkgMedList");
	}
	if(pkgServList.size() > 0){	
		
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Package Services Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Charge</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
		<!-- <th scope="col">Net Amount</th> -->
	</tr>
	<%
   	    int i=1;
   		 for(BlPackageServicesDetails packageServicesDetails : pkgServList){
   	    %>
	<tr>
		<td><input type="hidden" name="<%=CHARGE_CODE_ID %><%=i %>"
			value="<%=packageServicesDetails.getChargeCode().getId()%>" /> <input
			type="text" class="readOnly" name="<%=CHARGE_CODE_NAME %><%=i %>"
			value="<%=packageServicesDetails.getChargeCode().getChargeCodeName() %>" /></td>
		<td><input type="text" class="readOnly"
			name="<%=QUANTITY %><%=i %>"
			value="<%=packageServicesDetails.getQuantity() %>" /></td>
		<td><input type="text" class="readOnly"
			name="<%=AMOUNT %><%=i %>"
			value="<%=packageServicesDetails.getChargeAmount() %>" /></td>
		<%-- <td><input type="text" class="readOnly"
			name="<%=NET_AMOUNT%><%=i %>"
			value="<%=packageServicesDetails.getNetChargeAmt() %>" /></td> --%>
		<%i++;} %>
	
</table>
<div class="clear"></div>

<div class="clear"></div>
<%}
	
	if(pkgMedList.size() > 0){	
		
	 %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Package Medicines Details</h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Item</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
		<!-- <th scope="col">Net Amount</th> -->
	</tr>
	<%int j=1;
    		 for(BlPackageMedicineDetails packageMedicineDetails : pkgMedList){
    	    %>
	<tr
		onclick="openPopForBatch('<%=packageMedicineDetails.getItem().getPvmsNo()%>',<%=j %>);">
		<td><input type="hidden" name="itemCode<%=j %>"
			id="itemCode<%= j%>"
			value="<%=packageMedicineDetails.getItem().getPvmsNo() %>" /> <input
			type="hidden" id="itemId<%=j %>" name="<%=ITEM_ID %><%=j %>"
			value="<%=packageMedicineDetails.getItem().getId()%>" /> <input
			type="text" class="readOnly" name="<%=ITEM_NAME %><%=j %>"
			value="<%=packageMedicineDetails.getItem().getNomenclature() %>" /></td>
		<td><input type="text" id="quantity<%=j %>" class="readOnly"
			name="<%=QTY %><%=j %>"
			value="<%=packageMedicineDetails.getQuantity() %>" /></td>
		<td><input type="text" class="readOnly"
			name="<%=DISPENSING_PRICE %><%=j %>"
			value="<%=packageMedicineDetails.getItemAmount() %>" /></td>
		<%-- <input type="text" class="readOnly" id="dispPriceId<%=j %>"
			name="netAmtDisp<%=j %>"
			value="<%=packageMedicineDetails.getNetItemAmt() %>" /> --%>
			 <input
			type="hidden" name="<%=FA_ACCOUNT_ID %><%=j%>" id="accountId<%=j%>"
			value="" /> <input type="hidden" name="<%=FA_SUB_LED_ID %><%=j%>"
			id="subAccountId<%=j%>" value="" /> <input type="hidden"
			id="itemBatchCount<%=j %>" value /> <input type="hidden"
			id="amount<%=j %>" name="" value="" /> <input type="hidden"
			id="netamount<%=j %>" value="" /> <input type="hidden"
			id="qty<%=j %>" value="" />

	</tr>
	<% j++;} %>
</table>
<input type="hidden" id="totalDiscountAmtId"
	name="totalAdditionalDiscount" value="" />
<input type="hidden" id="totalNetId" name="" value="" />
<input type="hidden" value="<%=j %>" name="hiddenValueItem"
	id="hiddenValueCharge" />
<div class="clear"></div>

<table id="batchDetails" style="display: none;">
	<tr>
		<th scope="col">Batch Id</th>
		<th scope="col">Quantity</th>
		<th scope="col">Item Id</th>
		<th scope="col">Amount</th>
		<th scope="col">Discount Percent</th>
		<th scope="col">Discount Amount</th>
		<th scope="col">Proportional Discount Amt</th>
		<th scope="col">Net Amount</th>
	</tr>

</table>
<input type="hidden" id="totalBatchId" name="batchNoCounter" value="" />
<div class="clear"></div>

<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>