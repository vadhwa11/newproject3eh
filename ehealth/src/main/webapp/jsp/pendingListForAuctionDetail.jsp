<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
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
	List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
	List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
	List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
	List<HesEquipmentMaster> equipmentMasters=new ArrayList<HesEquipmentMaster>();
	if(map.get("categoryList") != null){
		categoryList = (List)map.get("categoryList");
	}
	if(map.get("assetsList") != null){
		assetsList = (List)map.get("assetsList");
	}
	if(map.get("assetsDetailList") != null){
		assetsDetailList = (List)map.get("assetsDetailList");
	}
	if(map.get("equipmentMasters") != null){
		equipmentMasters = (List<HesEquipmentMaster>)map.get("equipmentMasters");
	}
	%>

<div class="titleBg">
<h2>Pending list for Auction</h2>
</div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="Block">
<form name="pendingListForAuctionDetail" method="post">
<div class="clear"></div>
<label>Asset Code</label>
<select name="assetCode" id="assetCode" validate="Asset Code,string,no">
<option value="">Select </option>
<%
	if(assetsList.size()>0){
		for(PrqAssetDetails assetsDetail :assetsList){		
%>
<option value="<%=assetsDetail.getAssetCode()%>"><%=assetsDetail.getAssetCode() %></option>
<%}} %>
</select>

<label>Asset Name</label>
<select name="assetName" id="assetName" validate="Asset Name,string,no">
<option value="">Select </option>
<%
	if(assetsList.size()>0){
		for(PrqAssetDetails assetsDetail :assetsList){	
%>
<option value="<%=assetsDetail.getAssetName()%>"><%=assetsDetail.getAssetName() %></option>
<%}} %>
</select>

<label>Auction Date</label>
<input type="text" name="auctionDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pendingListForAuctionDetail.auctionDate,event);" />
<div class="clear"></div>
<label>Category</label>
<select name="itemCategoryId" id="itemCategoryId" validate="Category,string,no">
<option value="0">Select </option>
<%
	if(categoryList.size()>0){
		for(MasItemCategory itemCategory :categoryList){
			
		
%>
<option value="<%=itemCategory.getId()%>"><%=itemCategory.getItemCategoryName() %></option>
<%}} %>
</select>
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('pendingListForAuctionDetail','procurement?method=searchPendingListForAuctionDetail');" />
<input name="button"  type="button"	value="Show All" class="button"	onclick="submitForm('pendingListForAuctionDetail','procurement?method=searchPendingListForAuctionDetail&flag=all');" />
<div class="clear"></div>
<div class="paddingTop5"></div>	
<div class="cmntable">
<div id="pageNavPosition"></div>
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Date</th>
			<th>Asset Code</th>
			<th>Asset Name</th>
			<th>Category</th>
		</tr>
	<tbody id="tableData">
		<%
		int i = 1;
		System.out.println("assetliost=="+assetsDetailList.size());
		if(assetsDetailList.size()>0){ 
		for(PrqAssetDetails assetDetails: assetsDetailList){%>
		<tr onclick="submitForm('pendingListForAuctionDetail','procurement?method=showAuctionDetailJsp&assetDetailId=<%=assetDetails.getId()%>');">
			<td><%=i %></td>
			<td><%=assetDetails.getAuctionDate() != null?HMSUtil.convertDateTypeToStringWithoutTime(assetDetails.getAuctionDate()):""%></td>
			<td><%=assetDetails.getAssetCode()!= null?assetDetails.getAssetCode():"" %></td>
			<td><%=assetDetails.getAssetName()!= null?assetDetails.getAssetName():"" %></td>
			<td><%=assetDetails.getAssetCategory()!= null?assetDetails.getAssetCategory().getItemCategoryName():"" %></td>
		</tr>
	<%i++;} }%>
	<%
		int i1 = 1;
		if(equipmentMasters.size()>0){ 
		for(HesEquipmentMaster hesEquipmentMaster: equipmentMasters){%>
		<tr onclick="submitForm('pendingListForAuctionDetail','procurement?method=showAuctionDetailJsp&requestId=<%=hesEquipmentMaster.getId()%>');">
			<td><%=i1 %></td>
			<td><%=hesEquipmentMaster.getAsset()!=null ? hesEquipmentMaster.getAsset().getAuctionDate():""%></td>
			<td><%= hesEquipmentMaster.getAsset()!=null ? hesEquipmentMaster.getAsset().getAssetCode():""%></td>
			<td><%=hesEquipmentMaster.getItem()!=null ?hesEquipmentMaster.getItem().getNomenclature():"" %></td>
			<td><%=hesEquipmentMaster.getItem()!=null ?hesEquipmentMaster.getItem().getItemCategory().getItemCategoryName() :""%></td>			
		</tr>
	</tbody>
	<%i1++;}} %>
</table>
</div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<script>
	var pager = new Pager('tableData',10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
