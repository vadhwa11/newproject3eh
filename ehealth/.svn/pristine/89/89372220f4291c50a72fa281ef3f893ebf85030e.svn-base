<%@page import="jkt.hms.masters.business.DiseasesIcdMapping"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<DiseasesIcdMapping> diseasesIcdMappingList = new ArrayList<DiseasesIcdMapping>();	
	
	if (map.get("diseasesIcdMappingList") != null) {
		diseasesIcdMappingList = (List<DiseasesIcdMapping>) map.get("diseasesIcdMappingList");
	}

	int inc=0;
%>

<% for( DiseasesIcdMapping diseasesIcdMapping : diseasesIcdMappingList)  {%>	
<%inc++; %>

<tr>
		<td>
			<input type="checkbox"  class="radioCheck"  value="<%=diseasesIcdMapping.getId()%>" tabindex="1" id="itemCheck<%=inc %>" size="70"  name="itemCheck<%=inc %>" />
		</td>
		<td>
		<%=diseasesIcdMapping.getIcdCode().getIcdName()%>
		<input
			type="hidden" tabindex="1" id="itemId<%=inc %>" name="itemId<%=inc %>" />
		<input
			type="hidden" tabindex="1" id="itemFlag<%=inc %>" name="itemFlag<%=inc %>" />	 
		</td>
</tr>
<%  } %>
<input type="hidden" value="<%=inc %>" name="itemCount" id="itemCount" />	



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
