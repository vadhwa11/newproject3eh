<%@ page import="static jkt.hms.util.RequestConstants.TEMPLATE"%>


<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%

Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
if(map.get("masTemplateList")!=null){
	masTemplateList =(List) map.get("masTemplateList");
}

%>
 <select name="<%=TEMPLATE %>" id="<%=TEMPLATE %>" value=""
	maxlength="" validate=""
	onchange="if(checkBlankTemplate()){submitFormForButton('assignApplicationForm','user?method=showTemplateModulesJsp');}"
	tabindex="1" >
	<option value="">Select Template Name</option>
	<%	for(MasTemplate masTemplate : masTemplateList){
	    	 %>
	<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
	<% 
			} %>
</select>
