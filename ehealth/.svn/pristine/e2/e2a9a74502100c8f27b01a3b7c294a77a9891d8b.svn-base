<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.Iterator"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	List<MasStoreItem> masStoreItemsList = new ArrayList<MasStoreItem>();
	List<DgMasInvestigation> dgMasInvestigationsList = new ArrayList<DgMasInvestigation>();

	if (map.get("masStoreItemsList") != null) {
		masStoreItemsList = (List<MasStoreItem>) map.get("masStoreItemsList");
	}

	if (map.get("dgMasInvestigationsList") != null) {
		dgMasInvestigationsList = (List<DgMasInvestigation>) map
				.get("dgMasInvestigationsList");
	}
%>

<ul>
	<%
		if (masStoreItemsList.size() != 0) {

			for (Iterator iterator = masStoreItemsList.iterator(); iterator
					.hasNext();) {

				MasStoreItem masStoreItem = (MasStoreItem) iterator.next();
	%>
	<li style="width: auto;"><%=masStoreItem.getNomenclature()%>[<%=masStoreItem.getId()%>]</li>



	<%
		}

		} else if (dgMasInvestigationsList.size() != 0) {

			for (Iterator iterator = dgMasInvestigationsList.iterator(); iterator
					.hasNext();) {

				DgMasInvestigation dgMasInvestigation = (DgMasInvestigation) iterator
						.next();
	%>
	<li style="width: auto;"><%=dgMasInvestigation.getInvestigationName()%>[<%=dgMasInvestigation.getId()%>]</li>

	<%
		}
		} else {
	%>
	<li>----------No Items found-------------</li>
	<%
		}
	%>
</ul>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
