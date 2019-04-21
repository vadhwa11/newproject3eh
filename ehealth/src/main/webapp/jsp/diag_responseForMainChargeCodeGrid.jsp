<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		
		}
		List chargeCodeList= new ArrayList();
		List chargeCodeList1= new ArrayList();
		if(map.get("chargeCodeList") != null){
			chargeCodeList = (List)map.get("chargeCodeList");
		}
if(map.get("chargeCodeList1") != null){
			chargeCodeList1 = (List)map.get("chargeCodeList1");
		}
%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%><ul>
	<%	if(chargeCodeList.size() !=0){
	
		for (Iterator iterator = chargeCodeList.iterator(); iterator.hasNext();) {
			DgMasInvestigation dgMasInvestigation = (DgMasInvestigation)iterator.next();
					
%>
	<input type="hidden" name="mainCharge" id="mainChargeId" value="<%=dgMasInvestigation.getMainChargecode().getId() %>" />
	<li><%=dgMasInvestigation.getInvestigationName()%>[<%=dgMasInvestigation.getId()%>](<%=dgMasInvestigation.getMainChargecode().getId()%>)</li>

	<%}}else if(chargeCodeList1.size()!=0){
		for (Iterator iterator = chargeCodeList1.iterator(); iterator.hasNext();) {
			MasChargeCode dgMasInvestigation = (MasChargeCode)iterator.next();

	%>
	<input type="hidden" name="mainCharge" id="mainChargeId" value="<%=dgMasInvestigation.getMainChargecode().getId() %>" />
	<li><%=dgMasInvestigation.getChargeCodeName()%>[<%=dgMasInvestigation.getId()%>](<%=dgMasInvestigation.getMainChargecode().getId()%>)</li>
	<%}}else{ %>
		<li>----------No Items found-------------</li>
	<%} %>
</ul>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
