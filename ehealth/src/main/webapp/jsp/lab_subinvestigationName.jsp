
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
int rowVal=(Integer)map.get("rowVal");
List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
if(map.get("subInvestigationlist") != null)
{
	subInvestigationlist = (List<DgSubMasInvestigation>)map.get("subInvestigationlist");

}

%>
<td>
		<div id="subInv<%=rowVal%>" align="center">
		<select id="subInvestigationName<%=rowVal %>" name="<%=SUB_INVESTIGATION_NAME %>"
			validate="subInvestigationName,string,no"  tabindex=1 onchange="ajaxFunctionForSubInvestigationName(machineParameter,<%=rowVal%>);" >
				<option value="">Select</option>
		 	<%

			for (DgSubMasInvestigation subMasInvestigation : subInvestigationlist)
			{
				if(subMasInvestigation.getSubInvestigationName() != null)
				{

    %>
			<option value="<%=subMasInvestigation.getId()%>" ><%=subMasInvestigation.getSubInvestigationName()%></option>
			<%
					}

			}
		%>
		</select>
			</div></td>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       