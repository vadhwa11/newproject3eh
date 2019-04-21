<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
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
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	List<PrqAssetDetails> assetsDetailList = new ArrayList<PrqAssetDetails>();
	List<HesEquipmentMaster> equipmentMasters=new  ArrayList<HesEquipmentMaster>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("assetsDetailList") != null){
		assetsDetailList= (List<PrqAssetDetails>)map.get("assetsDetailList");	
	}
	if(map.get("equipmentMasters") != null){
		equipmentMasters= (List<HesEquipmentMaster>)map.get("equipmentMasters");	
	}
	if(map.get("employeeList") != null){
		employeeList= (List<MasEmployee>)map.get("employeeList");	
	}
	%>

<div class="titleBg">
<h2>Auction Detail</h2>
</div>


<div class="clear"></div>
<form name="auctionDetail" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Auction Detail</h4>

<div class="paddingTop15"></div>

	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">

		<tr>
			<th>Asset Code</th>
			<th>Asset Name</th>
			<th>Model No.</th>
			<th>Survey No</th>
			<th>Manufacture</th>
			<th>Auction Date</th>
			<th>Base Amount</th>
			<th>Auction Amount</th>
			<th>Reamrks</th>
			
			
	
		</tr>
	<%
		if(equipmentMasters.size()>0){
			for(HesEquipmentMaster equipmentMaster : equipmentMasters){
	%>
		<tr>
			<td><%=equipmentMaster.getItem()!=null? equipmentMaster.getItem().getPvmsNo():"" %>
			<input type="hidden"  name="eqpId" value="<%=equipmentMaster.getId() %>"  id="eqpId" /></td>
			<td><%=equipmentMaster.getItem()!= null?equipmentMaster.getItem().getNomenclature():"" %></td>
			<td><%=equipmentMaster.getModelName()!= null?equipmentMaster.getModelName():"" %></td>
			<td><%="--" %></td>
			<td><%=equipmentMaster.getManufacturer()!= null?equipmentMaster.getManufacturer().getManufacturerName():"" %></td>
			<td><%="-" %></td>
			<td><%="-" %></td>
			<td><input type="text" name="auctionAmount" value="" id="auctionAmount" validate="Auction Amount,float,yes" /></td>
			<td><%="-" %></td>
	
		</tr>
	<%}} %>
	
	<%
		if(assetsDetailList.size()>0){
			for(PrqAssetDetails assetDetails : assetsDetailList){
	%>
		<tr>
			<td><%=assetDetails.getAssetCode()!= null?assetDetails.getAssetCode():"" %>
			<input type="hidden"  name="assetDetailId" value="<%=assetDetails.getId() %>"  id="assetDetailId" /></td>
			<td><%=assetDetails.getAssetName()!= null?assetDetails.getAssetName():"" %></td>
			<td><%=assetDetails.getModalNo()!= null?assetDetails.getModalNo():"" %></td>
			<td><%=assetDetails.getPlotSurveyNo() != null?assetDetails.getPlotSurveyNo():"" %></td>
			<td><%=assetDetails.getManufacturer()!= null?assetDetails.getManufacturer().getManufacturerName():"" %></td>
			<td><%=assetDetails.getAuctionDate()!= null?HMSUtil.convertDateToStringWithoutTime(assetDetails.getAuctionDate()):"" %></td>
			<td><%=assetDetails.getEstCost()!= null?assetDetails.getEstCost().intValue():"" %></td>
			<td><input type="text" name="auctionAmount" value="" id="auctionAmount" validate="Auction Amount,float,yes" /></td>
			<td><%=assetDetails.getAuctionRemarks()!= null?assetDetails.getAuctionRemarks():"" %></td>
	
		</tr>
	<%}} %>
	
</table>
</div>
<div class="paddingTop15"></div>

<div class="paddingTop15"></div>

	<h4>Party Detail</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			
			<th>Name Of Party</th>
			<th>Address Of Party</th>
			<th>Contact No.</th>
			<th>Name Of Authorized</th>
			
	
		</tr>
	
		<tr>
			
		
			<td>
			<input type="text" name="partyName" value=""	tabindex=1   id="partyName" validate="Party Name,string,yes" />
			</td>
			
			<td>
			<input type="text" name="partyAddress" value=""	tabindex=1  id="partyAddress" validate="Party Address,string,no" />
			</td>
			<td>
			<input type="text" name="contactNo" value=""	tabindex=1  id="contactNo" validate="Contact No.,string,no" />
			</td>
			
			<td>
			<select name="authorizerId" validate="Authorizer,string,yes">
				<option value="">Select</option>
				<%if(employeeList.size()>0){
					for(MasEmployee masEmployee :employeeList){
					%>
					<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
				<%}} %>
			
			</select>
			</td>
			
		
	
		</tr>
	
</table>
</div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('auctionDetail','procurement?method=submitAuctionDetail');" />
<input type="button" name="add" id="addbutton" value="Reset" class="button" onClick="" accesskey="a" tabindex=1 />



</form>