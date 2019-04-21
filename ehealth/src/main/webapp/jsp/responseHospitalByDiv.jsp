<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseHospitalByDiv.jsp 
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Govind
 * Create Date: 07th Jan,2017
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
String parameter="";
if(map.get("parameter")!=null){
	parameter=(String)map.get("parameter");
	}

System.out.println("paramter jsp "+parameter);
//System.out.println("--"+deptList1.size());
%>

 <select <%=parameter %>>
<%if(instituteList.size()>0){ %>
<option value="0">Select</option>
 	<%for(MasHospital mh:instituteList){ %>
		<option value="<%=mh.getId()%>"><%=mh.getHospitalName()%></option>
		<%}%>

<%}%>
</select>
