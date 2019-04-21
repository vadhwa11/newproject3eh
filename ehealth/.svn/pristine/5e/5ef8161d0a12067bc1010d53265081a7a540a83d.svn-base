
<%@ page import="jkt.hms.masters.business.MasStoreItem" %>
<%@ page import="jkt.hms.masters.business.MasStoreItemConversion" %>
<%@ page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
	Map<String, Object> dataMap = new HashMap<String, Object>();	
	List<StoreInternalIndentT> displayIndentList = new ArrayList<StoreInternalIndentT>();
	List<Object[]> issueTList = new ArrayList<Object[]>();
	List<Object[]>stockList = new ArrayList<Object[]>();
	if (request.getAttribute("dataMap") != null) 
	{
		dataMap = (Map) request.getAttribute("dataMap");
	}
	if(dataMap.get("displayIndentList")!=null)
		displayIndentList = (List) dataMap.get("displayIndentList");
	
	if(dataMap.get("issueTList")!=null)
		issueTList = (List) dataMap.get("issueTList");
	
	if(dataMap.get("stockList")!=null)
		stockList = (List) dataMap.get("stockList");
%>

<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<!-- <form name="indentTrackingExcel" method="post" action="">
	<input type="hidden" name="indentMId" id="indentMId" value="" />
</form> -->

<table class="cmntable">

	<tr>
		<th>Sl No.</th>
		<th>Date</th>
		<th>Indent No.</th>
		<th>PVMS No.</th>
		<th>Nomenclature</th>
		<th>A/U</th>
		<th>Qty Demanded</th>
		<th>Qty Issue</th>
		<th>Main Store Stock</th>
		<th>Remarks</th>
	</tr>

	<tbody id="tableData">
<%
		String st = "";
		if(displayIndentList.size()>0)
		{
			int count = 1;
			Iterator<StoreInternalIndentT> iterate = displayIndentList.iterator();
			while(iterate.hasNext())
			{
				StoreInternalIndentT storeIndentT = iterate.next();
				StoreInternalIndentM storeIndentM = storeIndentT.getInternal();
				MasStoreItem masStoreItem = storeIndentT.getItem();
				MasStoreItemConversion masStoreItemConversion = masStoreItem.getItemConversion();
				
%>
				<tr>
					<td><label><%=count%></label></td>
					<td>
						<%=storeIndentM.getDemandDate() != null ?HMSUtil.convertDateToStringWithoutTime(storeIndentM.getDemandDate()):"" %>
					</td>
					<td><%=storeIndentM.getDemandNo()!= null?storeIndentM.getDemandNo():"" %></td>
						
					<td><%=storeIndentT.getItem()!= null?storeIndentT.getItem().getPvmsNo():""%></td>
					
						<td><%=storeIndentT.getItem()!= null?storeIndentT.getItem().getNomenclature():""%></td>
						
				<td><%=storeIndentT.getItem()!= null && storeIndentT.getItem().getItemConversion()!= null?storeIndentT.getItem().getItemConversion().getItemUnitName():""%></td>
					
						
						
						
<%
	int qd = 0;
	if(storeIndentT.getQtyRequest()!=null && !storeIndentT.getQtyRequest().equals("")){
		qd = storeIndentT.getQtyRequest();
		
	}
%>
						
					<td><%=qd != 0?qd:"" %></td>
					

						<%
							BigDecimal qtyIssued =new BigDecimal(0);
						if(issueTList.size()>0){
							for(Object[] ob: issueTList)
							{
								if(storeIndentT.getItem().getId().equals(ob[1]))
								{
									qtyIssued = (BigDecimal)ob[0];
									//System.out.println("qtyIssued=="+qtyIssued);
									//out.print(qtyIssued);
									break;
								}else{
									//out.print("-");
								}
							}
						}else{
							//out.print("-");
						}
							
							//if(storeIndentT.getQtyReceived()==null || storeIndentT.getQtyReceived().equals(""))
								//out.print("-");
							//else 
								//out.print(storeIndentT.getQtyReceived().intValue());
						%>
						<td><%=qtyIssued!= null?qtyIssued.intValue():"" %></td>
						
						<%
						System.out.println("stockList=="+stockList.size());
						String stockMsg = "";
							if(stockList.size()>0){
								for(Object[] stock : stockList){
									if(((Integer)stock[0]).equals(storeIndentT.getItem().getId())){
										if(stock[1] != null && ((BigDecimal)stock[1]).compareTo(new BigDecimal(0))>0){
											stockMsg = "Stock Available";
										}else{
											stockMsg = "Stock Not Available";
										}
										break;
									}else{
										stockMsg = "Stock Not Available";
									}
								  }
								}else{
									stockMsg = "Stock Not Available";
								}
							
						
						%>
						
						<td><%=stockMsg != null?stockMsg:"" %></td>
						
						
						
						
						<td><%
							if(storeIndentT.getRemarks()==null || storeIndentT.getRemarks().equals(""))
								out.print("-");
							else 
								out.print(storeIndentT.getRemarks());
						%>
					</td>
				</tr><%
			count++;
			}%>
			
<%
		}
		else
		{
			%><tr><td colspan=9><label id="NoData" class="labelError">No Data Found</label></td></tr>
			<%
		}
		
	%></tbody>
</table>

