<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.BlChargeSlipDetail"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />



<%
	Map<String, Object> map = new HashMap<String, Object>();
	//List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();
	List<BlChargeSlipDetail> chargeSlipDtList = new ArrayList<BlChargeSlipDetail>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	/*if(map.get("chargeSlipList") != null){
		chargeSlipList = (List<BlChargeSlipMain>)map.get("chargeSlipList");
	}*/
	if(map.get("chargeSlipDtList") != null){
		chargeSlipDtList = (List<BlChargeSlipDetail>)map.get("chargeSlipDtList");
	}
	if(chargeSlipDtList.size() > 0){

%>
<div class="clear"></div>
<div class="paddingTop40"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"><input type="checkbox" name="checkAll" class="radioCheck" onclick="checkAllRow(this);"/></th>
		<th scope="col">Charge Code</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
	</tr>
	<%
   		 for(BlChargeSlipDetail blChargeSlipDetail : chargeSlipDtList){
   	    %>
	<tr>
		<td><input type="checkbox" name="chargeSlipDetailsId" class="radioCheck"  value="<%=blChargeSlipDetail.getId() %>"/></td>
		<td><%=blChargeSlipDetail.getChargeCode().getChargeCodeName() %></td>
		<td><%=blChargeSlipDetail.getQuantity() %></td>
		<td><%=blChargeSlipDetail.getNetAmt() %></td>
	</tr>
	<%} %>
</table>
<div class="clear"></div>
<input type="button" name="Submit11" value="Cancel" class="button"
	onclick="submitForm('searchChargeSlipCancel','billing?method=cancelChargeSlip');" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<%}else{ %>
<div class="clear"></div>
<h4><span>No Record found!</span></h4>
<div class="clear"></div>
<%} %>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
