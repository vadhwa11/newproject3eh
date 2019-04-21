<%@page import="jkt.hms.masters.business.HmisParameterMapping"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<HmisParameterMapping> hmisParameterMappingList = new ArrayList<HmisParameterMapping>();	
	
	if (map.get("hmisParameterMappingList") != null) {
		hmisParameterMappingList = (List<HmisParameterMapping>) map.get("hmisParameterMappingList");
	}

	int inc=0;
%>

<% for( HmisParameterMapping hmisParameterMapping : hmisParameterMappingList)  {%>	
<%inc++; %>

<tr>
		<td>
			<input type="checkbox"  class="radioCheck"  value="<%=hmisParameterMapping.getId()%>" tabindex="1" id="itemCheck<%=inc %>" size="70"  name="itemCheck<%=inc %>" />
		</td>
		<td>
		<%=hmisParameterMapping.getItemName()%>
		<input
			type="hidden" tabindex="1" id="itemId<%=inc %>" name="itemId<%=inc %>" />
		<input
			type="hidden" tabindex="1" id="itemFlag<%=inc %>" name="itemFlag<%=inc %>" />	 
		</td>
		<td>
			<%=hmisParameterMapping.getItemCategory()%>
		<input
			type="hidden" tabindex="1" id="itemCategory<%=inc %>" name="itemCategory<%=inc %>" /> 
		</td>
</tr>
<%  } %>
<input type="hidden" value="<%=inc %>" name="itemCount" id="itemCount" />	


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
