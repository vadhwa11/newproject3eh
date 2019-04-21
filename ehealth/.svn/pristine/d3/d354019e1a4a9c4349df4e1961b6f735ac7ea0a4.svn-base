<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HrCommitteeDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List bList= new ArrayList();
if(map.get("bList") != null){
	bList = (List)map.get("bList");
	
}
List sList= new ArrayList();
if(map.get("sList") != null){
	sList = (List)map.get("sList");
	
}
List eList= new ArrayList();
if(map.get("eList") != null){
	eList = (List)map.get("eList");
	
}
%>


<ul>

<%	
		    
%>
	<% if(sList.size() !=0){
		for (Iterator iterator = sList.iterator();
		iterator.hasNext();) {
		HrCommitteeDetails s = (HrCommitteeDetails) iterator.next();
    String memberName = s.getName();    
%>
<li style="width: auto;"><%=memberName%></li>
<%}}else if(eList.size() !=0){
	for (Iterator iterator = eList.iterator();
	iterator.hasNext();) {
MasEmployee e = (MasEmployee) iterator.next();
String memberName = e.getEmployeeName();

%>
<li style="width: auto;"><%=memberName%></li>
<%}}
	else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>










