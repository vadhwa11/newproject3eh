<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasDepartment> deptList1 = new ArrayList<MasDepartment>();

if(map.get("deptList1")!= null){
	deptList1 = (List<MasDepartment>)map.get("deptList1");
}

%>

<div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0;">
<%if(deptList1.size()>0){ %>


    <%for(MasDepartment md : deptList1){ %>
     <option value="<%=md.getId()%>"><%=md.getDepartmentName()%></option>
     <%} %>

	<%} %>
</select>
</div>