<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->

<%
Map map = new HashMap();
List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgOrgGrpDtlList") != null){
	dgOrgGrpDtlList = (List<DgOrgGrpDtl>)map.get("dgOrgGrpDtlList");
}
%>
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>


	<%
    int srNo =1;
    for(DgOrgGrpDtl dgOrgGrpDtl: dgOrgGrpDtlList){
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox" name="checkbox"
			id="chkBox<%=srNo%>"
			value="<%=dgOrgGrpDtl.getOrganism().getId()%>@<%=dgOrgGrpDtl.getOrganismGroup().getId()%>"
			class="radio" onchange="fillSensitivity(this.value);" /></td>
		<td width="71%"><%=dgOrgGrpDtl.getOrganism().getOrganismName()%></td>
	</tr>
	<%
    srNo++;
    } %>

</table>
</div>

<!--  -->

<input id="noOfOrg" type="hidden" value="<%=srNo-1%>" />