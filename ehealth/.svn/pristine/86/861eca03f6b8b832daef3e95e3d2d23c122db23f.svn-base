<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
	DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
	Map<String,Object> detailsMap1 = new HashMap<String,Object>();
	Integer resultEntryIndex = 0;
	DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();
	
	Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if (map.get("detailsMap1") != null){
		detailsMap1 =(Map)map.get("detailsMap1");
	}

	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List<DgResultEntryHeader>) detailsMap1
				.get("dgResultEntryHeaderByOrderNo");
	}

	if(request.getParameter("resultEntryIndex") != null){
		resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
	}
	if(dgResultEntryHeaderByOrderNo.size() > 0 ){
		subSet1 = dgResultEntryHeaderByOrderNo.get(resultEntryIndex)
											.getDgResultEntryDetails();
		dgResultEntryHeaderForReport = dgResultEntryHeaderByOrderNo.get(resultEntryIndex);
	}

	Set<DgResultEntryDetail> dgResultdetail = new LinkedHashSet<DgResultEntryDetail>();
	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
	for(DgResultEntryDetail dgResultEntryDetail : subSet1){
		linkedHashSet.add(dgResultEntryDetail);
	}
	dgResultdetail.addAll(linkedHashSet);

%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>
<div class="clear"></div>
<!-- Table Starts -->

<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
		<th>Test Name</th>
		<th>Result</th>
		
	</tr>
	<% char i = 96;
	   for(DgResultEntryDetail dgDetail :dgResultdetail){
	    	i++;
				
	%>
	<tr>
		<td><%=i %>)</td>

		<%if(dgDetail.getSubInvestigation() !=null){ %>
		<td><%=dgDetail.getInvestigation().getInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>
		
		<%if(dgDetail.getResult().equalsIgnoreCase("p")) {%>
		<td>Positive</td>
		<%}else{ %>
		<td>Nagative</td>
		<%} %>
				
	</tr>
	<%} %>
</table>
</div>







<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		