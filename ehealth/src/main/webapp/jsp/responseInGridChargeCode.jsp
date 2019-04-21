<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List chargeCodeList= new ArrayList();
if(map.get("chargeCodeList") != null){
	chargeCodeList = (List)map.get("chargeCodeList");
}
%>



<ul>
	<%	if(chargeCodeList.size() !=0){
	
		for (Iterator iterator = chargeCodeList.iterator(); iterator.hasNext();) {
			
			Object[] pair = (Object[]) iterator.next();
		    String chargeCodeName=(String)pair[0];
		    String chargeCodeId=(String)pair[1];
		
	
		
%>
	<li><%=chargeCodeName%>[<%=chargeCodeId%>]</li>



	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



