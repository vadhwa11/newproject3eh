<%@page import="jkt.hms.masters.business.FaSchemeAccountMapping"%>
<%@page import="jkt.hms.masters.business.FaAccountHospitalTypeMapping"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<FaAccountHospitalTypeMapping> accList = new ArrayList<FaAccountHospitalTypeMapping>();
		List<FaSchemeAccountMapping> accList1 = new ArrayList<FaSchemeAccountMapping>();
		if(map.get("accList") != null){
			accList = (List)map.get("accList");
		}
		System.out.println("accList.size()==========>>"+accList.size());
		if(map.get("accList1") != null){
			accList1 = (List)map.get("accList1");
		}
		System.out.println("accList1.size()==========>>"+accList1.size());
%>

<ul>
	<%	if(accList.size() !=0){

		for (FaAccountHospitalTypeMapping faMasAccount :accList) {


%>
	<li><%=faMasAccount.getAccount().getAccDesc()%>[<%=faMasAccount.getAccount().getAccCode()%>]</li>
	<%}}else if(accList1.size()!=0){
	for (FaSchemeAccountMapping faMasAccount :accList1) {
		%>
		
		<li><%=faMasAccount.getAccount().getAccDesc()%>[<%=faMasAccount.getAccount().getAccCode()%>]</li>
		
		<%}}else{ %>
		<li>------No Data Found-------</li>
		<%} %>
</ul>


