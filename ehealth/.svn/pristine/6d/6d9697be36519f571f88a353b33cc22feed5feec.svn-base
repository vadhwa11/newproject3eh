<%@page import="jkt.hms.masters.business.MasDietItems"%>
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
List<MasDietItems> masDietItems=new ArrayList<MasDietItems>();
if(map.get("masDietItems") != null){
	masDietItems = (List<MasDietItems>)map.get("masDietItems");
}
%>

<ul>
	<%	if(masDietItems.size() !=0){
		for (Iterator iterator = masDietItems.iterator(); iterator.hasNext();) {
			MasDietItems dietItem = (MasDietItems) iterator.next();
			 int itemId = dietItem.getId();
		    String itemName = dietItem.getDietItemsName();
%>
	<li style="width: auto;"><%=itemName%>(<%=itemId%>)</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
