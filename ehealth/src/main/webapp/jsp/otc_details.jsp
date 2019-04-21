<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
if(map.get("itemList") != null){
	itemList = (List<MasStoreItem>)map.get("itemList");
}
%>

<ul>
	<%	if(itemList.size() !=0){
		for (MasStoreItem masStoreItem:itemList) {  
			 int itemId = masStoreItem.getId();
		    String itemName = masStoreItem.getNomenclature();
		    String pvms_no  = masStoreItem.getPvmsNo();
%>
	<li style="width: auto;"><%=itemName%>(<%=itemId%>)[<%=pvms_no%>]</li>
	<%}}else{%>
	<li>----------There is no OTC type item please add first OTC type item then issue-------------</li>
	<%} %>
</ul>



