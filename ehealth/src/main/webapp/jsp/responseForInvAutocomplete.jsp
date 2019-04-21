<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	
	List<DgMasInvestigation> masInvList = new ArrayList<DgMasInvestigation>();
		
	if (map.get("masInvList") != null) {
		masInvList = (List<DgMasInvestigation>) map.get("masInvList");
	}
%>

<ul>
	

		<%
		if (masInvList.size() != 0) {

			for (Iterator iterator = masInvList.iterator(); iterator
					.hasNext();) {

				DgMasInvestigation masIcd = (DgMasInvestigation) iterator
						.next();
	%>
	<li style="width: auto;"><%=masIcd.getInvestigationName()%>{<%=masIcd.getId()%>}</li>

	<%
		}
		} else {
	%>
	<li>----------No Items found-------------</li>
	<%
		}
	%>
</ul>



