<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	
	List<MasStoreItem> masItemList = new ArrayList<MasStoreItem>();
		
	if (map.get("masItemList") != null) {
		masItemList = (List<MasStoreItem>) map.get("masItemList");
	}
%>

<ul>


		<%
		if (masItemList.size() != 0) {

			for (Iterator iterator = masItemList.iterator(); iterator
					.hasNext();) {

				MasStoreItem masItem = (MasStoreItem) iterator
						.next();
	%>
	<li style="width: auto;"><%=masItem.getNomenclature()%>[<%=masItem.getId()%>]</li>

	<%
		}
		} else {
	%>
	<li>----------No Items found-------------</li>
	<%
		}
	%>
</ul>
