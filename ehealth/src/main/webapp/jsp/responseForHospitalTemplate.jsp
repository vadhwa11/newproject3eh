
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

	int counterMenu=0;
		if(masTemplateList.size()>0){
		for(MasTemplate masTemplate :masTemplateList){
			++counterMenu;
	%>
	<label class=""><%=masTemplate.getTemplateName()%>
	</label>
	<input type="checkbox" class="radioAuto" name="templetId<%=counterMenu%>" id="templetId<%=counterMenu%>" value="<%=masTemplate.getId()%>" />
	<%
	if(counterMenu%3==0){
		%>
		<div class="clear" style="padding-top:8px"></div>
		<%
	}
	}
	}
	
	%> 
	<input type="hidden" name="counterMenu" id="counterMenu" value="<%=counterMenu%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
	<div class="clear"></div>