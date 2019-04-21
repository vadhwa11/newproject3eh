
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="java.util.Calendar"%>
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
	
	List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
	List<PrqAssetDetails> assetsList = new ArrayList<PrqAssetDetails>();
	List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("categoryList") != null){
		categoryList = (List)map.get("categoryList");
	}
	if(map.get("assetsList") != null){
		assetsList = (List)map.get("assetsList");
	}
	if(map.get("assetsDetailList") != null){
		assetsDetailList = (List)map.get("assetsDetailList");
	}
	
	
%>


<div class="titleBg">
<h2>Mark For Auction</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="markForAuction" method="post">
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

<div class="clear"></div>

<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('markForAuction','procurement?method=searchAssetsMarkForAuction');" />
<input name="button"  type="button"	value="Show All" class="button"	onclick="submitForm('markForAuction','procurement?method=searchAssetsMarkForAuction&flag=all');" />

<div class="clear"></div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>

<h4>Item Details</h4>
<div id="pageNavPosition"></div>
<%
int i = 1;
if(assetsDetailList.size()>0){ %>
<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>Asset Code</th>
						<th>Asset Name</th>
						<th>District</th>
						<th>Plot/Survey No.</th>
						<th>Mark For Auction</th>				
						
					</tr>
					<tbody id="tableData">
				<%					
						for(PrqAssetDetails assetDetails: assetsDetailList){
				%>
					<tr>
					<td><%=assetDetails.getAssetCode() != null?assetDetails.getAssetCode():""%>
					<input type="hidden"  name="assetDetailId<%=i %>" value="<%=assetDetails.getId() %>"  id="assetDetailId" /></td>
					<td><%=assetDetails.getAssetName()!= null?assetDetails.getAssetName():""%></td>
					<td><%=assetDetails.getDistrict()!=null?assetDetails.getDistrict().getDistrictName():"" %></td>
					<td><%=assetDetails.getPlotSurveyNo()!= null?assetDetails.getPlotSurveyNo():"" %></td>
					<td><input type="checkbox" class="radioCheck" name="markForAuction<%=i %>" value="y"  id="markForAuction" /></td>
					</tr>
				<%i++;} %>	
				</tbody>
					
			</table>
<%}else{ %>
<lable Style="padding:10px 0px 10px 10px">No Record find</lable>
<%} %>
 <input	type="hidden" name="count" id="count"	value="<%=i %>" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('markForAuction','procurement?method=submitMarkForAuction');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />
<script>
	var pager = new Pager('tableData',10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>


