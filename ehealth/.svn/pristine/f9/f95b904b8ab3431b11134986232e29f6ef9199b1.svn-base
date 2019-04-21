<%@ page import="static jkt.hms.util.RequestConstants.TEMPLATE"%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%

Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<Object[]> hospitalList = new ArrayList<Object[]>();
if(map.get("hospitalList")!=null){
	hospitalList =(List) map.get("hospitalList");
}
String formName = "";
if(map.get("formName")!=null){
	formName = (String)map.get("formName");
}
String url = "";
if(formName.equals("assignApplicationForm")){
	url = "submitProtoAjax('assignApplicationForm','/hms/hms/user?method=getTemplateForHospital')";
	
}else if(formName.equals("showUserAssinedTemplet")){
	url = "submitForm('showUserAssinedTemplet','/hms/hms/user?method=showUserAssignedTemplet')";
}
%>
<label>Institution <span>*</span></label>
	<select name="hospitalId" id="hospitalId" onchange="<%=url %>"  tabindex="1">
	<option value="0">Select</option>
	<%
	
		for(Object[] obj : hospitalList){
	 %>
	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option>
	<%
		}
			%>
	</select>
