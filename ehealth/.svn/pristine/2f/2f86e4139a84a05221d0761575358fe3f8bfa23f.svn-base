<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlDispensingDetails"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlDispensingDetails> dispensingBatchDetailsList = new ArrayList<BlDispensingDetails>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("dispensingBatchDetailsList") != null){
		dispensingBatchDetailsList = (List<BlDispensingDetails>)map.get("dispensingBatchDetailsList");
	}
	
%>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Item Batch Wise Details</h4>
<div class="clear"></div>
<%
	if(dispensingBatchDetailsList.size() > 0){
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"><input type="checkbox" class="radioCheck"
			name="issueAll" id="issueAllId" onclick="checkAllBatch();" /></th>
		<th scope="col">Item Description</th>
		<th scope="col">Batch No</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
		<th scope="col">Dispensed Date</th>
		<th scope="col">Expiry Date</th>
	</tr>
	<%int i=1;
   	    int itemId = 0;
   	    int dispensingDetailsId = 0;
   	 		for(BlDispensingDetails dispensingDetails : dispensingBatchDetailsList){   	
   	 			itemId = dispensingDetails.getItem().getId();
   	 		dispensingDetailsId = dispensingDetails.getId();
   	    %>
	<tr>
		<td>
		<%
   	 		if(dispensingDetails.getIssued().equals("n")){
   	    	%> <input type="checkbox" class="radioCheck"
			name="<%=BATCH_ID%><%=i %>" id="issueId<%=i %>"
			value="<%=dispensingDetails.getBatch().getId() %>" /> <%}else{ %> <input
			type="checkbox" class="radioCheck" name="<%=BATCH_ID%><%=i %>"
			id="issueId<%=i %>"
			value="<%=dispensingDetails.getBatch().getId() %>"
			disabled="disabled" /> <%} %>
		</td>
		<td><%=dispensingDetails.getItem().getNomenclature() %> <input
			type="hidden" id="" name="dispensingDetailsId<%=i %>"
			value="<%=dispensingDetailsId %>" /></td>
		<td><%=dispensingDetails.getBatch().getBatchNo() %></td>
		<td><%=dispensingDetails.getQty() %><input type="hidden"
			id="qtyId<%=i %>" name="<%=QUANTITY %><%=i %>"
			value="<%=dispensingDetails.getQty() %>" /></td>
		<td><%=dispensingDetails.getAmount() %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(dispensingDetails.getDispensingHeader().getBillDate()) %></td>
		<%
	   	   		if(dispensingDetails.getBatch().getExpiryDate() != null){
	   	   	%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(dispensingDetails.getBatch().getExpiryDate()) %></td>
		<%}else{ %>
		<td></td>
		<%} %>
	</tr>
	<%i++;
  }
   	 			%>
</table>
<input type="hidden" id="itemId" name="<%=ITEM_ID %>"
	value="<%=itemId %>" />
<input type="hidden" id="countId" name="counter" value="<%=i-1 %>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" tabindex="1" class="button" name="Submit11"
	value="Issue"
	onclick="if(validateRows()){submitProtoAjaxForIssueBatch('pharmacySalesView','opBilling?method=checkBatchNo');}"
	align="right" />
<input type="button" class="buttonHighlight" value="Reset"
	onclick="form.reset();" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<%}else{ %>
<div class="clear"></div>
<h4>No Record found!</h4>

<%} %>
<div class="clear"></div>
