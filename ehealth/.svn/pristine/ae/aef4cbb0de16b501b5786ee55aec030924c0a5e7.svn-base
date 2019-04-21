<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<StoreItemBatchStock> batchStocks = new ArrayList<StoreItemBatchStock>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if (map.get("itemList") != null) {
		itemList = (List<MasStoreItem>) map.get("itemList");
		if (itemList.size() > 0) {
			MasStoreItem item = itemList.get(0);
%>
<%if(item.getDispUnit()!=null && !item.getDispUnit().isEmpty() && !item.getDispUnit().equals("0")){%>
		<%=item.getDispUnit()%>###<%=item.getItemConversion().getItemUnitName()%>###<%=(item.getRoute()!=null?item.getRoute().getId():0) %>###<%=(item.getTapered()!=null?item.getTapered():" ") %>
<%}else{ %>
	    <%=item.getItemConversion().getIssueUnit().getUnitName()%>###<%=""%>###<%=(item.getRoute()!=null?item.getRoute().getId():0) %>###<%=(item.getTapered()!=null?item.getTapered():" ") %>
<%} %>

<%
	}
	}
	if (map.get("masItemBatchStockValue") != null) {
		batchStocks = (List<StoreItemBatchStock>) map.get("masItemBatchStockValue");
		if (batchStocks.size() > 0) {
			StringBuilder batchNo = new StringBuilder("");
			StringBuilder closingStock = new StringBuilder("");
			StringBuilder stockItemId = new StringBuilder("");
			for (StoreItemBatchStock stock : batchStocks) {
				batchNo = batchNo.append(stock.getBatchNo())
						.append(",");
				closingStock = closingStock.append(
						stock.getClosingStock()).append(",");
				stockItemId = stockItemId.append(stock.getId()).append(
						",");

			}
%>
<%="/" + batchNo.toString() + "/"+ closingStock.toString() + "/" + stockItemId%>
<%
	}
	}
%>

