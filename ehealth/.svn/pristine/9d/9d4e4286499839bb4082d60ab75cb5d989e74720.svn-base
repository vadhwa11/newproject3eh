<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	int totalReg = 0;
	int totalVisit = 0;
	int totalOP = 0;
	int totalAdm = 0;
	String tab = "";
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("newRegistrations")!=null){
		totalReg=(Integer)map.get("newRegistrations");
	}
	if(map.get("newVisits")!=null){
		totalVisit=(Integer)map.get("newVisits");
	}
	if(map.get("newAdmission")!=null){
		totalAdm=(Integer)map.get("newAdmission");
	}
	totalOP = totalReg + totalVisit;
	
	if(map.get("tab")!=null){
		tab=(String)map.get("tab");
	}
%>


New Registration;<%=totalReg %>
Repeat Visit;
<font color="FF6600"><%=totalVisit %> </font>
OP Total;
<font color="FF9E01"><%=totalOP %> </font>
Admission;
<font color="FCD202"><%=totalAdm %> </font>
