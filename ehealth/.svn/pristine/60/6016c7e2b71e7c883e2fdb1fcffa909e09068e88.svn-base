<%@page import="jkt.hms.masters.business.InvestigationIcdMapping"%>
<%@page import="jkt.hms.masters.business.DiseasesIcdMapping"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<InvestigationIcdMapping> investigationIcdMappingList = new ArrayList<InvestigationIcdMapping>();	
	
	if (map.get("investigationIcdMappingList") != null) {
		investigationIcdMappingList = (List<InvestigationIcdMapping>) map.get("investigationIcdMappingList");
	}

	int inc=0;
%>

<% for( InvestigationIcdMapping investigationIcdMapping : investigationIcdMappingList)  {%>	
<%inc++; %>

<tr>
		<td>
			<input type="checkbox"  class="radioCheck"  value="<%=investigationIcdMapping.getId()%>" tabindex="1" id="inv_itemCheck<%=inc %>" size="70"  name="inv_itemCheck<%=inc %>" />
		</td>
		<td>
		<%=investigationIcdMapping.getIcdCode().getIcdName()%>
		<input
			type="hidden" tabindex="1" id="inv_itemId<%=inc %>" name="inv_itemId<%=inc %>" />
		<input
			type="hidden" tabindex="1" id="inv_itemFlag<%=inc %>" name="inv_itemFlag<%=inc %>" />	 
		</td>
		<td>
		<%=investigationIcdMapping.getInvestigation().getInvestigationName()%>
		</td>
</tr>
<%  } %>
<input type="hidden" value="<%=inc %>" name="itemCount1" id="itemCount1" />	


