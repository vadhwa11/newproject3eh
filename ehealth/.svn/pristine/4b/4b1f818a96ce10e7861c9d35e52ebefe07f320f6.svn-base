
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreBroadcastStatus"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryT"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<StoreBroadcastStatus> storeBroadcastStatusList = new ArrayList<StoreBroadcastStatus>();
	List<StoreBroadcastEnquiryT> enquiryTList = new ArrayList<StoreBroadcastEnquiryT>();
	List<Object[]> itemBatchStockList = new ArrayList<Object[]>();
	
	if(map.get("storeBroadcastStatusList") != null){
		storeBroadcastStatusList = (List<StoreBroadcastStatus>)map.get("storeBroadcastStatusList");
	}
	if(map.get("itemBatchStockList") != null){
		itemBatchStockList = (List<Object[]>)map.get("itemBatchStockList");
	}
	if(map.get("enquiryTList") != null){
		enquiryTList = (List<StoreBroadcastEnquiryT>)map.get("enquiryTList");
	}
	int broadCastEnquiryTId  = 0;
	if(map.get("broadCastEnquiryTId") != null){
		broadCastEnquiryTId = (Integer)map.get("broadCastEnquiryTId");
	}
	String broadCastStatus = "";
	if(map.get("broadCastStatus") != null){
		broadCastStatus = (String)map.get("broadCastStatus");
	}
	//System.out.println("broadCastStatus=="+broadCastStatus);
	String itemCode = "";
	String itemName = "";
	String unit = "";
	if(enquiryTList.size()>0){
		for(StoreBroadcastEnquiryT broadCastEnquiryT : enquiryTList){
			if(broadCastEnquiryT != null && broadCastEnquiryT.getItem() != null){
				itemCode = broadCastEnquiryT.getItem().getPvmsNo();
				itemName = broadCastEnquiryT.getItem().getNomenclature();
				unit =broadCastEnquiryT.getItem().getItemConversion().getItemUnitName();
			}
			
		}
	}
	
	
%>


<div id = "broadCastDiv">
<div class="Block">
<%

if(enquiryTList.size()>0){ %>
<label>Item Code</label>
 <input type="text" name="district" value="<%=itemCode != null?itemCode:"" %>"  MAXLENGTH="8"  /> 
	
	<label>Item Name</label>
 <input type="text" name="instituteType" value="<%=itemName != null?itemName:"" %>"  MAXLENGTH="8"  /> 
	
	<label>Unit</label>
 <input type="text" name="instituteName" value="<%=unit != null?unit:"" %>"  MAXLENGTH="8"  /> 
 <input type="hidden" name="broadCastEnquiryTId" value="<%=broadCastEnquiryTId != 0?broadCastEnquiryTId:"" %>" id ="broadCastEnquiryTId"  MAXLENGTH="8"  /> 

</div>

<div class="clear"></div>

	
			<table>
				
					<tr>

						<th>Sl No.</th>
						<th>Institute</th>
						<th>Available Stock</th>
						<th>Status</th>
						<th>Spare Qty</th>
						
					 
						
					</tr>
					<%
					
					
					int i =1;
			//if(!broadCastStatus.equalsIgnoreCase("block")){			
					if(itemBatchStockList.size()>0){
						for(Object[] obj:itemBatchStockList ){
					
					
					%>
					<tr>
		<td><input type="checkbox" class="radioCheck" size="6" tabindex="1"  value="y" name="srNo" id="srNo<%=i %>" />
		<td><%=obj[4] != null?obj[4] :"" %><input type="hidden" value="<%=obj[4] != null?obj[4] :"" %>" tabindex="1" name="hospitalName" size="20" id="hospitalName<%=i %>"   />
		<input type="hidden" value="<%=obj[5] != null?obj[5] :"" %>" tabindex="1" name="hospitalId" size="20" id="hospitalId<%=i %>"   /></td>
		<td><input type="text" size="6" tabindex="1"  value="<%=obj[0] != null?((BigDecimal)obj[0]).intValue() :"" %>" name="availableStock" id="availableStock<%=i %>" />
		<%-- <input type="hidden" name="storeBroadCastStatusId" id="storeBroadCastStatusId"<%=i %>" value="<%=obj.getId()%>"/>	 --%>				
		</td>
		<td><Select name= "instituteStatus" id="instituteStatus<%=i%>" validate="Status,string,yes">
		<option value="">Select</option>
		<option value="Accept">Accept</option>
		<option value="Reject">Reject</option>
		<option value="Partialy">Partialy</option>
		</Select></td>
		<td><input type="text" size="8" value=""  name="spareQty"  id="spareQty<%=i %>" validate="Spare Qty,float,yes"/></td>
		
		
		
	 </td>
					</tr>
					
					<%i++;}//}
					} %>
			</table>
			<div class="clear"></div>
	<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('enquiryBroadcastdashBoardInstitute','stores?method=submitInstituteDashboardBroadData','validateRows');" class="button" />
			
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<%}else{ %>
<label>No Record found</label>
<%} %>

</div>

<div id="broadCastDiv"></div>