
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
%>
<%@page import="java.util.Iterator"%>
<ul>
	<%	if(itemList.size() !=0){
		//for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
		  //  Object[] obj = (Object[]) iterator.next();
  		    //MasStoreItem masStoreItem=(MasStoreItem)obj[0];
  		    for (MasStoreItem masStoreItem:itemList) {
		    String itemName=masStoreItem.getNomenclature();
		    String pvmsNo=masStoreItem.getPvmsNo();
		    int itemId=masStoreItem.getId();
%>
	<li style="width: auto;"><%=itemName%>[<%=pvmsNo%>]
	</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>


