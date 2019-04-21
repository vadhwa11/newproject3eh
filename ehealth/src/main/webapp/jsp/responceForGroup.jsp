<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
if(map.get("masApplicationList") !=null){
	itemList=(List<MasStoreItem>)map.get("masApplicationList");
}
%>
<div id="deficientId">
<labe>Item Name</labe>
<select id="itemId" name="itemId" validate="Item Name,String,yes" onChange="populateItemBatch(this.value,'stockRegisterReport')">
<option value="0">Select</option>
<%	for(MasStoreItem masStoreItem: itemList){%>
		<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<%}%>
</select> 
</div>