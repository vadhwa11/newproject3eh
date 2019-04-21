<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingBillDetailsList = new ArrayList<BlDispensingHeader>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("dispensingBillDetailsList") != null){
		dispensingBillDetailsList = (List<BlDispensingHeader>)map.get("dispensingBillDetailsList");
	}
	if(dispensingBillDetailsList.size() > 0){	
		
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">Bill No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Bill Amount</th>
		<th scope="col">Receipt Amount</th>
		<th scope="col">Outstanding Amount</th>
		<th scope="col">Charity Amount</th>
		<th scope="col">Bill Date</th>
	</tr>
	<%
   		 for(BlDispensingHeader dispensingHeader : dispensingBillDetailsList){
   	    %>
	<tr>
		<td><input type="checkbox" name="dispensingHeaderId"
			value="<%=dispensingHeader.getId() %>"></td>
		<td><%=dispensingHeader.getBillNo() %></td>
		<td><%=dispensingHeader.getPatientName() %></td>
		<td><%=dispensingHeader.getBillAmt() %></td>
		<%
   	    		if(dispensingHeader.getPayableAmt() != null){
   	    	%>
		<td><%=dispensingHeader.getPayableAmt() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<%
   	     	if(dispensingHeader.getOutstanding() != null){
   	    %>
			<td><%=dispensingHeader.getOutstanding() %></td>
		<%}else if(dispensingHeader.getAdvAdjustment() != null){ %>
		<td><%=dispensingHeader.getAdvAdjustment() %></td> <%} else { %>
		<td></td>
		<%} %>
		
		<%if(dispensingHeader.getDiscountAmt() != null){
   	    %>
		<td><%=dispensingHeader.getDiscountAmt() %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td><%=HMSUtil.convertDateToStringWithoutTime(dispensingHeader.getBillDate()) %></td>
	</tr>
	<%} %>
</table>
<div class="clear"></div>

<input type="button" name="Submit11" value="Cancel" class="button"
	onclick="submitForm('searchChargeSlipCancel','billing?method=cancelBillDispensing');" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<%}else{ %>
<div class="clear"></div>
<h4><span>No Record found!</span></h4>
<div class="clear"></div>
<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>