<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	List<StoreStockTakingT> stocktakingTList = new ArrayList<StoreStockTakingT>();
	if(map.get("stocktakingTList") != null){
		stocktakingTList = (List)map.get("stocktakingTList");
	}
	

	%>

<div class="titleBg">
<h2>Physical Inventory Approval</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->

<form name="physicalInventoryApproval" method="post">


	

<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Date</th>
			<th>Asset Code</th>
			<th>Asset Name</th>
			
			
	
		</tr>
		<%
		int i = 1;
		if(stocktakingTList.size()>0){ 
		for(StoreStockTakingT storeStockTakingT: stocktakingTList){%>
		<tr>
			<td><%=i %><input type="hidden"  name="storeStockTakingTId" value="<%=storeStockTakingT.getId() %>"  id="storeStockTakingTId" />
			<input type="hidden"  name="storeStockTakingMId" value="<%=storeStockTakingT.getStockTakingM().getId() %>"  id="storeStockTakingMId" /></td>
			<td><%=storeStockTakingT.getStockTakingM().getPhysicalDate() != null?HMSUtil.convertDateToStringWithoutTime(storeStockTakingT.getStockTakingM().getPhysicalDate()):""%></td>
			<td><%=storeStockTakingT.getAsset() != null && storeStockTakingT.getAsset().getAssetCode()!= null?storeStockTakingT.getAsset().getAssetCode():"" %></td>
			<td><%=storeStockTakingT.getAsset() != null && storeStockTakingT.getAsset().getAssetName()!= null?storeStockTakingT.getAsset().getAssetName():"" %></td>
			
		</tr>
	<%i++;}} %>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<label>Status<span>*</span></label>
<select name="status" id="status" validate="Status,string,yes">
<option value="">Select </option>
<option value="Approve">Approve </option>
<option value="Reject">Reject</option>

</select>
<label>Remarks</label>
<input type="text" name="remarks" id="remarks" value="" class="large"/>




<div class="clear"></div>
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('physicalInventoryApproval','procurement?method=submitPhysicalInventoryApproval');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>