<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>	
<%@page import="java.util.*"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>	
	<%
			Map<String, Object> map = new HashMap<String, Object>();
			List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
			Set<PrjSiteResMap> prjSiteResMapSet = new HashSet<PrjSiteResMap>();
			if(request.getAttribute("map") != null){
				map = (Map) request.getAttribute("map");
			}
			if(map.get("prjSiteMapList")!= null){
				prjSiteMapList = (List)map.get("prjSiteMapList");
			}
			if(map.get("prjSiteResMapSet")!= null){
				prjSiteResMapSet = (Set)map.get("prjSiteResMapSet");
			}
	
	%>





<label>Site </label>
<select id="siteId" name="<%=SITE_ID %>"   >
<option value="0">Select</option>
<%
	for(PrjSiteResMap prjSiteResMap :prjSiteResMapSet){
%>
<option value="<%=prjSiteResMap.getSiteHeader().getId() %>"><%=prjSiteResMap.getSiteHeader().getSiteName()+"--"+prjSiteResMap.getPjr().getPjrName() %></option>
<%} %>
</select>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
