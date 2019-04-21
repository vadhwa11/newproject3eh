<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseInstHospital.jsp 
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Vishal
 * Create Date: 20th Dec,2016
 * Revision Date:      
 * Revision By: 
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<MasHospital> instituteList = new ArrayList<MasHospital>();

if(map.get("instituteList")!=null){
	instituteList=(List<MasHospital>)map.get("instituteList");
	}
int id=0;
if(instituteList.size()>0){
	id=instituteList.get(0).getId();
}
//System.out.println("--"+deptList1.size());
%>

<div id="insHospital">
 <select name="Institute" id="Institute" onchange="populateTasks(this,'tempId');abc1(this.value)" validate="Institute,int,yes">
<%if(instituteList.size()>0){ %>
<option value="0">Select</option>
 	<%for(MasHospital mh:instituteList){ %>
		<option value="<%=mh.getId()%>"><%=mh.getHospitalName()%></option>
		<%}%>

<%}%>
</select>
</div>