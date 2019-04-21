<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
		DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
		Map<String,Object> detailsMap1 = new HashMap<String,Object>();
		Integer resultEntryIndex = 0;
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if (map.get("detailsMap1") != null){
			detailsMap1 =(Map)map.get("detailsMap1");
		}

		if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
			dgResultEntryHeaderByOrderNo = (List<DgResultEntryHeader>) detailsMap1
					.get("dgResultEntryHeaderByOrderNo");
		}
		if(dgResultEntryHeaderByOrderNo.size() > 0 ){
			dgResultEntryDetailForSingleResult = dgResultEntryHeaderByOrderNo.get(resultEntryIndex)
												.getDgResultEntryDetails().iterator().next();
		}
		
		
	%>
<!-- Table Starts -->

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Test Name</th>
		<th scope="col">Result</th>
		

	</tr>
	<tr>
		<td>a)</td>
		<%
 if(dgResultEntryDetailForSingleResult.getInvestigation() !=null){ %>
		<td><%=dgResultEntryDetailForSingleResult.getInvestigation().getInvestigationName() %></td>
		<%}else { %>
		<td>-</td>
		<%} %>




		

		<%if(dgResultEntryDetailForSingleResult.getResult().equals("p")) {%>
			<td>Positive</td>
		<%}else{ %>
		<td>Negative</td>
		
			<%} %>	 
  
	
		

		


	






	</tr>

</table>



</div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
