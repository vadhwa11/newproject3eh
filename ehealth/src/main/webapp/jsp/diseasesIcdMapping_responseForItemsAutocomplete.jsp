<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	
	List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		
	if (map.get("masIcdList") != null) {
		masIcdList = (List<MasIcd>) map.get("masIcdList");
	}
%>

<ul>


		<%
		if (masIcdList.size() != 0) {

			for (Iterator iterator = masIcdList.iterator(); iterator
					.hasNext();) {

				MasIcd masIcd = (MasIcd) iterator
						.next();
	%>
	<li style="width: auto;"><%=masIcd.getIcdName()%>[<%=masIcd.getIcdCode()%>]{<%=masIcd.getId()%>}</li>

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
