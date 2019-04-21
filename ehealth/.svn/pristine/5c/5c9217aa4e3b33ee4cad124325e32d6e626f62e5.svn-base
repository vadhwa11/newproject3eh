<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if (map.get("itemList") != null) {
		itemList = (List) map.get("itemList");
	}
	int rowVal = 0;
	String flag = "";
	if (map.get("rowVal") != null) {
		rowVal = (Integer) map.get("rowVal");
	}
	if (map.get("flag") != null) {
		flag = (String) map.get("flag");
	}
	MasStoreItem storeItem = new MasStoreItem();
	String itemName = "";
	String itemCode = "";
	int itemId = 0;
	if(itemList.size() > 0){
		storeItem =  itemList.get(0);
		itemName = storeItem.getNomenclature();
		itemCode = storeItem.getPvmsNo();
		itemId = storeItem.getId();
	}
	if(flag.equals("name")){
%>
<input type="text" size="28" value="<%=itemName %>"
	id="itemName<%=rowVal%>" name="<%=ITEM_NAME%><%=rowVal%>"
	validate="Item Name,string,no"
	onblur="openPopupForItem(this.value,<%=rowVal %>,'codeDiv','code');"
	readonly="readonly" />

<%}else if(flag.equals("code")){ %>
<input type="text" name="<%=ITEM_CODE%><%=rowVal%>" size="18"
	id="itemCode<%=rowVal%>" value="<%=itemCode %>" tabindex="1"
	onblur="openPopupForItem(this.value,<%=rowVal %>,'nameDiv','name');"
	readonly="readonly" />
<%} %>
<input type="hidden" id="itemId<%=rowVal %>"
	name="<%=ITEM_ID%><%=rowVal %>" value="<%=itemId%>" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
