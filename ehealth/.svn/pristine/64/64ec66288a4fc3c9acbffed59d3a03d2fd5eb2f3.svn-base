<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object> itemList= new ArrayList<Object>();
if(map.get("itemList") != null){
	itemList = (List<Object>)map.get("itemList");
}
int counter =0;
if(map.get("counter")!=null)
{
	counter = (Integer)(map.get("counter"));
}
%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>

<ul>
	<%	if(itemList.size() !=0){

		for (int i=0;i<itemList.size(); i++) {

			 Object[] pair =(Object[])itemList.get(i);
 		String itemId = pair[1].toString();
  %>
   <li><%=pair[0]%>[<%=itemId%>]</li>
 	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



