<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%><%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<MasTemplate> hospitaltemplateList=new ArrayList<MasTemplate>();

if(map.get("hospitaltemplateList")!=null){
	 hospitaltemplateList=(List<MasTemplate>)map.get("hospitaltemplateList");
	} 

%>


<select name="tempId" id="tempId"  multiple="multiple" validate="Role,string,yes" size="3" class="listBig3">
<%if(null !=hospitaltemplateList && hospitaltemplateList.size()>0){
	for(MasTemplate template:hospitaltemplateList){
%>
<option value="<%= template.getTemplateName()%>"><%= template.getTemplateName()%></option>
<%}} %>
</select>



