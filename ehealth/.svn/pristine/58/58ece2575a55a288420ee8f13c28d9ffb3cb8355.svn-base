<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@ page import="java.util.*"%>
<%
	Map<String,Object> map = null;
	List<MasInstituteDepartment> hospitalDepartmentList = null;
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	String age = "";
	if(map.get("hospitalDepartmentList") != null){
		hospitalDepartmentList = (List<MasInstituteDepartment>)map.get("hospitalDepartmentList");
	
	for(MasInstituteDepartment instituteDepartment : hospitalDepartmentList){	
%>
	<option value="<%=instituteDepartment.getDepartment().getId()%>"><%=instituteDepartment.getDepartment().getDepartmentName()%></option>
<%} }%>