<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List itemList= new ArrayList();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
%>


<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<ul>
	<%	if(itemList.size() !=0){
	
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			
			Object[] pair = (Object[]) iterator.next();
		    String brandName=(String)pair[0];
		    int brandId=(Integer)pair[1];
		
%>
	<li><%=brandName%></li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



