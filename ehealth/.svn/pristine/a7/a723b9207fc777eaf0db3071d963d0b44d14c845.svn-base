
<%@page import="jkt.hms.masters.business.StoreBroadcastStatus"%>
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
 	List<StoreBroadcastEnquiryT> broadCastEnquiryTList = new ArrayList<StoreBroadcastEnquiryT>();
	if(map.get("broadCastEnquiryTList") != null){
		broadCastEnquiryTList = (List)map.get("broadCastEnquiryTList");
	}
 
 /* List<StoreBroadcastStatus> broadCastStatusList = new ArrayList<StoreBroadcastStatus>();
 if(map.get("broadCastStatusList") != null){
	 broadCastStatusList = (List<StoreBroadcastStatus>)map.get("broadCastStatusList");
	}
 */
	
%>


<div id = "testDiv">

<div class="clear"></div>

	<%int i =1;
	if(broadCastEnquiryTList.size()>0){ %>
			<table>
				
					<tr>

						
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Available Stock</th>
						<th>DemandedQty</th>
					 
						
					</tr>
					<%
					
						for(StoreBroadcastEnquiryT broadcastEnquiryT:broadCastEnquiryTList ){
					
					
					%>
					<tr onclick="submitProtoAjaxWithDivName('enquiryBroadcastdashBoardInstitute','stores?method=showInstituteBroadStatus&broadCastEnquiryTId=<%=broadcastEnquiryT.getId()%>&itemId=<%=broadcastEnquiryT.getItem().getId()%>','broadCastDiv');">
		
		<td><%=broadcastEnquiryT.getItem()!= null?broadcastEnquiryT.getItem().getPvmsNo():"" %><input type="hidden" size="6" tabindex="1"  value="<%=broadcastEnquiryT.getItem()!= null?broadcastEnquiryT.getItem().getPvmsNo():"" %>" name="pvms" id="pvms<%=i %>" />
		<input type="hidden" value="<%=broadcastEnquiryT.getItem()!= null?broadcastEnquiryT.getItem().getId():"" %>" name="itemid" id="itemId<%=i %>" /></td>
		
							
	<td><%=broadcastEnquiryT.getItem()!= null?broadcastEnquiryT.getItem().getNomenclature():"" %><input type="hidden" value="<%=broadcastEnquiryT.getItem()!= null?broadcastEnquiryT.getItem().getNomenclature():"" %>" tabindex="1" name="nomenclature" size="20" id="nomenclature<%=i %>" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=i %>');;"  />
		</td>
		<td><input type="text" size="6" tabindex="1"  value="<%=broadcastEnquiryT.getItem()!= null && broadcastEnquiryT.getItem().getItemConversion()!= null?broadcastEnquiryT.getItem().getItemConversion().getItemUnitName():"" %>" name="au" id="au<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><%=broadcastEnquiryT.getStock() != null ?broadcastEnquiryT.getStock().intValue():"" %><input type="hidden" size="8" value="<%=broadcastEnquiryT.getStock() != null ?broadcastEnquiryT.getStock().intValue():"" %>"  name="actualStock"  id="actualStock<%=i %>"/></td>
		<td><input type="text" size="8" value="<%=broadcastEnquiryT.getDemandedQtyExcessQty() != null ?broadcastEnquiryT.getDemandedQtyExcessQty().intValue():"" %>"  name="demandedExcessQty"  id="demandedExcessQty<%=i %>"/></td>
		
		
		
	 </td>
					</tr>
					
					<%i++;}//} %>
			</table>
		<%}else{ %>
	<h4>No Record</h4>	
		<%} %>	
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="broadCastDiv"></div>