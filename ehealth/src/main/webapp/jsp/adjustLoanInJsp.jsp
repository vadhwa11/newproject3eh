<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * adjustLoanOut.jsp  
 * Purpose of the JSP -  This is for adjust the items that are given based on loan out
 * Table  store_grn_m
 * @author  Abha
 * Create Date: 28th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
		
<%
Map map= new HashMap();
int poId=0;
int loanInId=0;

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

List<StoreLoaninM> loaninList = new ArrayList<StoreLoaninM>();
if(map.get("loaninList") != null){
	loaninList = (ArrayList) map.get("loaninList");
	session.setAttribute("loaninList",loaninList);
}else if(session.getAttribute("loaninList") != null){
	loaninList = (ArrayList)session.getAttribute("loaninList");
	
}
List<StoreLoaninT> loaninTList = new ArrayList<StoreLoaninT>();
if(map.get("loaninTList") != null){
	loaninTList = (ArrayList) map.get("loaninTList");
	session.setAttribute("loaninTList",loaninTList);
}else if(session.getAttribute("loaninTList") != null){
	loaninTList = (ArrayList)session.getAttribute("loaninTList");
	
}

if(map.get("loanInId")!=null){
	loanInId = (Integer)map.get("loanInId");

}
if(map.get("poId")!=null){
	poId = (Integer)map.get("poId");

}
String max="";
if(map.get("max") != null){
	max = (String) map.get("max");
}
%>
</script>
<div id="contentspace">
<form name="loanIn" method="post"><br />
<h2 align="left" class="style1">Adjust Loan In</h2>

<fieldset style="width: 99%; padding-left: 9px;"><legend>Adjust
Loan In</legend>
<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" class="grid_header" border="1"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="10%"><label valign="left" class="smalllabel">LoanIn
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Loan
			In date</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Vendor
			Name</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Challan
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Challan
			Date</label></td>
		</tr>
	</thead>


	<%for (StoreLoaninM storeLoaninM : loaninList) { %>
	<input type="hidden" value="<%=storeLoaninM.getId()%>"
		name="<%= LOANIN_ID%>" />
	<%if(storeLoaninM.getLoaninNo()!= null){ %>
	<td width="10%"><input type="text"
		value="<%=storeLoaninM.getLoaninNo()%>" class=" readOnly"
		readonly="readonly" name="<%=LOANIN_NO%>" /></td>
	<%} %>
	<td width="10%"><input type="text"
		value="<%=storeLoaninM.getLoaninDate()%>" class="readOnly"
		readonly="readonly" name="<%=LOANIN_DATE%>" /></td>

	<td width="10%"><input type="text"
		value="<%=storeLoaninM.getSupplier().getSupplierName()%>"
		class="readOnly" readonly="readonly" /></td>

	<td width="10%"><input type="text"
		value="<%=storeLoaninM.getChallanNo()%>" class="readOnly"
		readonly="readonly" name="<%=CHALLAN_NO%>" /></td>

	<td width="10%"><input type="text"
		value="<%=storeLoaninM.getChallanDate()%>" class="readOnly"
		readonly="readonly" name="<%=CHALLAN_DATE%>" /></td>

	<input type="hidden" value="<%=storeLoaninM.getSupplier().getId()%>"
		class="readOnly" readonly="readonly" name="<%=SUPPLIER_ID%>" />

	<%if(storeLoaninM.getOctroi() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getOctroi()%>"
		class="readOnly" readonly="readonly" name="<%=OCTROI%>" />
	<%} %>
	<%if(storeLoaninM.getOtherCharges() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getOtherCharges()%>"
		class="readOnly" readonly="readonly" name="<%=OTHER_CHARGES%>" />
	<%} %>
	<%if(storeLoaninM.getExciseDuty() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getExciseDuty()%>"
		class="readOnly" readonly="readonly" name="<%=EXCISE_DUTY%>" />
	<%} %>
	<%if(storeLoaninM.getFreightDuty() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getFreightDuty()%>"
		class="readOnly" readonly="readonly" name="<%=FREIGHT_DUTY%>" />
	<%} %>
	<%if(storeLoaninM.getInsuranceCharge() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getInsuranceCharge()%>"
		class="readOnly" readonly="readonly" name="<%=INSURANCE_CHARGES%>" />
	<%} %>
	<input type="hidden" value="<%=storeLoaninM.getLoaninValue()%>"
		class="readOnly" readonly="readonly" name="<%=LOANIN_VALUE%>" />
	<%if(storeLoaninM.getLoaninAmount() != null) {%>
	<input type="hidden" value="<%=storeLoaninM.getLoaninAmount()%>"
		class="readOnly" readonly="readonly" name="<%=LOANIN_AMOUNT%>" />
	<%} %>
	<input type="hidden" value="<%=storeLoaninM.getRemarks()%>"
		class="readOnly" readonly="readonly" name="<%=REMARKS%>" />
	<%if(storeLoaninM.getCustomDuty() != null) {%>

	<input type="hidden" value="<%=storeLoaninM.getCustomDuty()%>"
		class="readOnly" readonly="readonly" name="<%=CUSTOM_DUTY%>" />
	<%} %>
	<input type="hidden" value="<%=storeLoaninM.getPo().getId()%>"
		class="readOnly" readonly="readonly" name="<%=INDENT_ID%>" />
	<input type="hidden" value="<%=storeLoaninM.getChallanNo()%>"
		class="readOnly" readonly="readonly" name="<%=CHALLAN_NO%>" />
	<input type="hidden" value="<%=storeLoaninM.getChallanDate()%>"
		class="readOnly" readonly="readonly" name="<%=CHALLAN_DATE%>" />
	<input type="hidden" value="<%=storeLoaninM.getEmployee().getId()%>"
		class="readOnly" readonly="readonly" name="<%=EMPLOYEE_ID%>" />
	<%} %>
	<tr></tr>
	<td></td>

	<%for(StoreLoaninT storeLoaninT : loaninTList){%>
	<input type="hidden" value="<%=storeLoaninT.getSerialNo()%>"
		name="<%= SR_NO%>" />
	</td>
	<input type="hidden" value="" name="<%=NO_OF_ROWS %>" />
	<input type="hidden" value="<%=storeLoaninT.getId()%>"
		name="<%= DETAIL_ID%>" />
	</td>
	<input type="hidden" value="<%=storeLoaninT.getItem().getId()%>"
		name="<%=ITEM_ID%>" />
	</td>
	<input type="hidden" value="<%=storeLoaninT.getManufacturer()%>"
		name="<%=MANUFACTURER_ID%>" />
	</td>
	<input type="hidden" value="<%=storeLoaninT.getLotNo()%>"
		name="<%=LOT_NO%>" />
	</td>
	<input type="hidden" value="<%=storeLoaninT.getBrand()%>"
		name="<%=BRAND_ID%>" />
	</td>
	<input type="hidden" value="<%=storeLoaninT.getBatchNo()%>"
		name="<%=BATCH_NO%>" />
	<input type="hidden" value="<%=storeLoaninT.getExpiryDate()%>"
		name="<%=EXPIRY_DATE%>" />
	<input type="hidden" value="<%=storeLoaninT.getDiscount()%>"
		name="<%=DISCOUNT_PERCENTAGE%>" />
	<input type="hidden" value="<%=storeLoaninT.getTax()%>"
		name="<%=TAX_PERCENT%>" />
	<input type="hidden" value="<%=storeLoaninT.getFreeItem()%>"
		name="<%=FREE_ITEM%>" />
	<input type="hidden" value="<%=storeLoaninT.getFreeQty()%>"
		name="<%=FREE_QTY%>" />
	<input type="hidden" value="<%=storeLoaninT.getUnitRate()%>"
		name="<%=UNIT_RATE%>" />
	<input type="hidden" value="<%=storeLoaninT.getAmountValue()%>"
		name="<%=AMOUNT%>" />
	<input type="hidden" value="<%=storeLoaninT.getReceivedQty()%>"
		name="<%=QUANTITY_RECEIVED%>" />
	<input type="hidden" value="<%=storeLoaninT.getManufacturerDate()%>"
		name="<%=MANUFACTURING_DATE%>" />
	</td>

	<%} %>
	</tbody>

</table>
</div>

<input type="button" name="add" id="addbutton" value="Adjust"
	class="button"
	onClick="submitForm('loanIn','stores?method=submitAdjustLoan')"
	accesskey="a" tabindex=1 /></fieldset>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<%-- End of contentspace div--%>
<%loaninList.clear();
loaninTList.clear();
%>