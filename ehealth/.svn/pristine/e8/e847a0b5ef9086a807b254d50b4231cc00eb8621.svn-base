<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
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

<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

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
	List<MmServiceRequest> mmRequests=new ArrayList<MmServiceRequest>();
	if(map.get("categoryList") != null){
		categoryList = (List)map.get("categoryList");
	}
	if(map.get("assetsList") != null){
		assetsList = (List)map.get("assetsList");
	}
	if(map.get("assetsDetailList") != null){
		assetsDetailList = (List)map.get("assetsDetailList");
	}
	if(map.get("mmRequests") != null){
		mmRequests = (List)map.get("mmRequests");
	}
	%>

<div class="titleBg">
<h2>Auction Approval</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->

<form name="auctionApproval" method="post">


	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<% int i = 1;
		if(assetsDetailList.size()>0){ %>
			<th>Sl No.</th>
			<th>Date</th>
			<th>Asset Code</th>
			<th>Asset Name</th>
			<th>District</th>
			<th>Plot/Survey No.</th>
			<th>Requested By</th>
		</tr>
		<%
		for(PrqAssetDetails assetDetails: assetsDetailList){%>
		<tr onclick="submitForm('pendingListForAuction','procurement?method=showAuctionApprovalJsp');">
			<td><%=i %><input type="hidden"  name="assetDetailId" value="<%=assetDetails.getId() %>"  id="assetDetailId" /></td>
			<td><%=assetDetails.getAuctionDate() != null?HMSUtil.convertDateToStringWithoutTime(assetDetails.getAuctionDate()):""%></td>
			<td><%=assetDetails.getAssetCode()!= null?assetDetails.getAssetCode():"" %></td>
			<td><%=assetDetails.getAssetName()!= null?assetDetails.getAssetName():"" %></td>
			<td><%=assetDetails.getDistrict()!= null?assetDetails.getDistrict().getDistrictName():"" %></td>
			<td><%=assetDetails.getPlotSurveyNo()!= null?assetDetails.getPlotSurveyNo():"" %></td>
			<td><%=assetDetails.getRequestedBy() != null?assetDetails.getRequestedBy().getEmployeeName():"" %></td>
		</tr>
		<%i++;}} %>
		<% int i1=1;
		if(mmRequests.size()>0){ %>
			<th>Sl No.</th>
			<th>Date</th>
			<th>Equipment Code</th>
			<th>Equipment Name</th>
			<th>Replacement Value</th>
			<th>Resource Name</th>
		</tr>
		<%
		for(MmServiceRequest mmServiceRequest: mmRequests){%>
		<tr>
			<td><%=i %><input type="hidden"  name="serviceId" value="<%=mmServiceRequest.getId() %>"  id="serviceId" /></td>
			<input type="hidden"  name="equipmentId" value="<%=mmServiceRequest.getEquipment().getId() %>"  id="equipmentId" /></td>
			<td><%=mmServiceRequest.getRequestDate()!=null ?mmServiceRequest.getRequestDate():""%></td>
			<td><%=mmServiceRequest.getEquipment()!=null ?mmServiceRequest.getEquipment().getItem().getPvmsNo() :"" %></td>
			<td><%=mmServiceRequest.getEquipment()!=null ?mmServiceRequest.getEquipment().getItem().getNomenclature() :"" %></td>
			<td><%=mmServiceRequest.getEquipment()!=null ?mmServiceRequest.getEquipment().getReplacementValue():""%></td>
			<td><%=mmServiceRequest.getResourceUser()!=null ?mmServiceRequest.getResourceUser().getEmployeeName():""%></td>
		</tr>
			<%i1++;}} %>
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
<input type="text" name="auctionRemarks" id="auctionRemarks" value="" class="large"/>




<div class="clear"></div>
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('auctionApproval','procurement?method=submitAuctionApproval');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


</form>