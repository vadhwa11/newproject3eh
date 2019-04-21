
<%@page import="java.math.BigDecimal"%>
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
	List<Object[]> itemBatchStockList = new ArrayList<Object[]>();
	if(map.get("itemBatchStockList") != null){
		itemBatchStockList = (List<Object[]>)map.get("itemBatchStockList");
	}
	int broadCastEnquiryTId  = 0;
	if(map.get("broadCastEnquiryTId") != null){
		broadCastEnquiryTId = (Integer)map.get("broadCastEnquiryTId");
	}
	int broadCastEnquiryMId = 0;
	if(map.get("broadCastEnquiryMId") != null){
		broadCastEnquiryMId = (Integer)map.get("broadCastEnquiryMId");
	}
	
	int hospitalId = 0;
	if(map.get("hospitalId") != null){
		hospitalId = (Integer)map.get("hospitalId");	
	}
	String broadCastStatus = "";
	String itemCode = "";
	String itemName = "";
	String unit = "";
	if(map.get("broadCastStatus") != null){
		broadCastStatus = (String)map.get("broadCastStatus");	
	}
	if(itemBatchStockList.size()>0){
		for(Object[] stock : itemBatchStockList){
			if(stock[1] != null){
				itemCode =(String)stock[1];
			}
			if(stock[2] != null){
				itemName =(String)stock[2];
			}
			if(stock[3] != null){
				unit =(String)stock[3];
			}
		}
	}
	

	
%>


<div id = "broadCastDiv">
<%-- <%if(broadCastStatus.equals("b")){ %> --%>
<div class="Block">

<label>Item Code</label>
 <input type="text" name="district" value="<%=itemCode != null?itemCode:"" %>"  MAXLENGTH="8"  /> 
	
	<label>Item Name</label>
 <input type="text" name="instituteType" value="<%=itemName != null?itemName:"" %>"  MAXLENGTH="8"  /> 
	
	<label>Unit</label>
 <input type="text" name="instituteName" value="<%=unit != null?unit:"" %>"  MAXLENGTH="8"  /> 
 <input type="hidden" name="broadCastEnquiryTId" value="<%=broadCastEnquiryTId != 0?broadCastEnquiryTId:"" %>" id ="broadCastEnquiryTId"  MAXLENGTH="8"  /> 
 <input type="hidden" name="broadCastEnquiryMId" value="<%=broadCastEnquiryMId != 0?broadCastEnquiryMId:"" %>" id ="broadCastEnquiryMId"  MAXLENGTH="8"  /> 

</div>

<div class="clear"></div>

	
			<table>
				
					<tr>

						<th>Sl No.</th>
						<th>Institute</th>
						<th>Available Stock</th>
						<th>Block</th>
					<%-- 	<th>Spare Qty</th>--%>
						
					 
						
					</tr>
					<%
					int i =1;
					if(itemBatchStockList.size()>0){
						for(Object[] obj:itemBatchStockList ){
							if(!(obj[5].equals(hospitalId))){
					
					
					%>
					<tr>
		<td><input type="checkbox" class="radioCheck" size="6" tabindex="1"  value="y" name="srNo" id="srNo<%=i %>" />
		<td><input type="text" value="<%=obj[4] != null?obj[4] :"" %>" tabindex="1" name="hospitalName" size="35" id="hospitalName<%=i %>" validate="Hospital Name,string,yes"   />
		<input type="hidden" value="<%=obj[5] != null?obj[5] :"" %>" tabindex="1" name="instituteId" size="20" id="instituteId<%=i %>"   /></td>
		<td><input type="text" size="6" tabindex="1"  value="<%=obj[0] != null?((BigDecimal)obj[0]).intValue() :"" %>" name="availableStock" id="availableStock<%=i %>" />					
		</td>
		<td><Select name= "dmostatus" id="dmostatus<%=i%>" validate="Status,string,yes">
		<option value="No">No</option>
		<option value="Yes">Yes</option>
		</Select></td>
		<%-- <td><input type="text" size="8" value=""  name="spareQty"  id="spareQty<%=i %>" validate="Spare Qty,float,no"/></td>--%>
		
		
		
	 </td>
					</tr>
					
					<%i++;}}} %>
			</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
	<%-- <%}else{ %>	
	
	<label>No Record</label>
	<%} %> --%>	
</div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('enquiryBroadcastdashBoard','stores?method=submitDmoDashboardBroadData');" class="button" />
<input type="button" name="Next/Update" type="submit" value="View"	onClick="submitFormForButton('enquiryBroadcastdashBoard','stores?method=viewBroadCastStatusData');" class="button" />

<div id="broadCastDiv"></div>