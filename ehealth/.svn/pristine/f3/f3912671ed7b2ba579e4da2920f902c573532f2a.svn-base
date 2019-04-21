<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<MasHospital>hospitalList=new ArrayList<MasHospital>();
if(map.get("hospitalList")!=null){
	hospitalList=(List<MasHospital>)map.get("hospitalList");
}

System.out.println("in jsp for hospital in district");
%>
<label>Hospital </label>
<select name="hospitalName" id="hospitalTypeId" >
<option value="0">Select</option>
<%for(MasHospital mh:hospitalList){ %>
<option value="<%=mh.getId() %>"><%=mh.getHospitalName() %></option>
<%} %>

</select>
