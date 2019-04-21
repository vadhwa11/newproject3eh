<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
	
	<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>
	

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	List<Object[]> pendingListForRefrigeratorAllocationList = new ArrayList<Object[]>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<Object[]> grnMList = new ArrayList<Object[]>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("pendingListForRefrigeratorAllocationList") != null){
		pendingListForRefrigeratorAllocationList = (List)map.get("pendingListForRefrigeratorAllocationList");
	}
	if(map.get("supplierList") != null){
		supplierList = (List)map.get("supplierList");
	}
	if(map.get("grnMList") != null){
		grnMList = (List<Object[]>)map.get("grnMList");
	}
	
	
%>


<div class="titleBg">
<h2>Pending List For Refrigerator Allocation</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="pendingListForRefrigeratorAllocation" method="post">
<div class="clear"></div>
<label>From Date </label>
<input type="text" name="fromDate"	value="<%= currentDate %>" class="date" maxlength="30" validate="From Date,date,no"/>
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pendingListForRefrigeratorAllocation.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="toDate" value="<%= currentDate %>" class="date" maxlength="30" validate="To Date,date,no"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pendingListForRefrigeratorAllocation.<%= TO_DATE%>,true);" />

<label>GRN No.</label>
<select name="grnNo" >
<option value="0">Select </option>
<%
	if(grnMList.size()>0){
		for(Object[] obj :grnMList){
			
		
%>
<option value="<%=obj[0]%>"><%=obj[0] %></option>
<%}} %>
</select>

<div class="clear"></div>


<label>GRN Date</label>
<input type="text" name="grnDate" value=""	class="date"  validate="GRN Date,date,no"  readonly="readonly" id="<%=GRN_DATE%>" />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pendingListForRefrigeratorAllocation.<%= GRN_DATE%>,event);" />

<label>Delivery Challan No.</label>
<input type="text" name="deliveryChallanNo" value=""	tabindex=1  readonly="readonly" id="deliveryChallanNo" />


<label>Vendor Name</label>
<select name="supplierId">
<option value="0">Select </option>
<%
if(supplierList.size()>0){
	for(MasStoreSupplier masStoreSupplier :supplierList){


%>
<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName() %> </option>
<%}} %>
</select>
<div class="clear"></div>
<label>Invoice No.</label>
<select name="invoiceNo">
<option value="0">Select </option>
<%
	if(grnMList.size()>0){
		for(Object[] obj : grnMList){
			
		
%>
<option value="<%=obj[1]%>"><%=obj[1] %></option>
<%}} %>
</select>
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('pendingListForRefrigeratorAllocation','coldChain?method=searchForRefrigeratorAllocation');" />



</div>



<div class="clear"></div>



<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>




<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>

<h4>Item Details</h4>
<div id="pageNavPosition"></div>
<table border="0" cellpadding="0" cellspacing="0" >


					<tr>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Min Temperature</th>
						<th>Max Temperature</th>
						
						
					</tr>
					<tbody id="tableData">
				<%
					if(pendingListForRefrigeratorAllocationList.size()>0){
						for(Object[] obj : pendingListForRefrigeratorAllocationList){
						
					
				
				
				%>
					<tr onclick="submitForm('pendingListForRefrigeratorAllocation','coldChain?method=showRefrigeratorColdRoomAllocationJsp&itemId=<%=(Integer)obj[0]%>&min=<%=(BigDecimal)obj[3] %>&max=<%=(BigDecimal)obj[4]%>');">
					<td><%=obj[2]!= null?(String)obj[2]:"" %></td>
					<td><%=obj[1]!= null?(String)obj[1]:""%></td>
					<td><%=obj[5] != null?(String)obj[5]:""%></td>
					<td><%=obj[3]!= null?((BigDecimal)obj[3]).intValue():"" %></td>
					<td><%=obj[4] != null?((BigDecimal)obj[4]).intValue():"" %></td>
					
					
					
					</tr>
				<%}} %>	
					
					</tbody>
			</table>

 
<div class="clear"></div>
<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);
</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


