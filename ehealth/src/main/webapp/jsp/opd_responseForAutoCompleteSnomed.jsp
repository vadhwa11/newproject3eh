<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Sct2Description"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List itemList= new ArrayList();
if(map.get("itemList") != null){
	itemList = (List)map.get("itemList");
}
%>

<ul>
	<%	if(itemList.size() !=0){
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			Sct2Description obj = (Sct2Description) iterator.next();
		    String name=obj.getTerm();
		    long id=obj.getConceptid();
		    
	%>
	<li style="width: auto; font: normal 11px tahoma; text-align: left;"><%=name%>[<%=id%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



