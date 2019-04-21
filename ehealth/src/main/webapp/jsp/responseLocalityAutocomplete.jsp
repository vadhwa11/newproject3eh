<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	
	List<Object[]> localityList = new ArrayList<Object[]>();
		
	if (map.get("localityList") != null) {
		localityList = (List<Object[]>) map.get("localityList");
	}
%>

<ul>
	

		<%
		if (localityList.size() != 0) {

			for (Object[] obj : localityList) {

			
	%>
	<li style="width: auto;" onclick="setValue('<%=obj[0]%>')"  onkeypress="javascript:setValue('<%=obj[0]%>')"><%=obj[1]%></li>

	<%
		}
		} else {
	%>
	<li>----------No Items found-------------</li>
	<%
		}
	%>
</ul>



