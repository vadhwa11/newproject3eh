<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
		DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
		Map<String,Object> detailsMap1 = new HashMap<String,Object>();
		Integer resultEntryIndex = 0;
		char counter =97;
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
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>

	</tr>
	<tr>
		<td><%=counter %></td>

		<% 
    try{
    	if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		if(dgResultEntryDetailForSingleResult.getResult() != null 
    				&& !dgResultEntryDetailForSingleResult.getResult().equals("")){

    			Float result1   = Float.parseFloat(dgResultEntryDetailForSingleResult.getResult());
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %>

		
		<td>
		<%if(result.equalsIgnoreCase("Positive")){ %>
		Positive
		<%}else{ %>
		Negative
		<%} %>
		</td>
		<% }else{ %>
		<td>
	<%if(result.equalsIgnoreCase("Positive")){ %>
		Positive
		<%}else{ %>
		Negative
		<%} %>
		</td>
		<% }
    		}else{%>
		<td>No Result Entered</td>
		<%}
	       }else{ %>


		<td><%if(dgResultEntryDetailForSingleResult.getResult().equalsIgnoreCase("Positive")){ %>
		Positive
		<%}else{ %>
		Negative
		<%} %>
		</td>
		<% } 
    }catch(Exception exception){ %>
		<td><%if(dgResultEntryDetailForSingleResult.getResult().equalsIgnoreCase("Positive")){ %>
		Positive
		<%}else{ %>
		Negative
		<%} %>
		</td>
		<% } %>

		<% if(dgResultEntryDetailForSingleResult.getInvestigation().getUom() != null){ %>
		<td><%=dgResultEntryDetailForSingleResult.getInvestigation().getUom().getUomName()%></td>
		<% }else{ %>
		<td>-</td>
		<% } %>


		<% if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null
    		
      &&!dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue().equals("")
      &&!dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue().equals("")){
     		Float minValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
		<td><%=minValue%> - <%=maxValue %></td>


		<% }else {
			
		if(dgResultEntryDetailForSingleResult.getInvestigation().getNormalValue() != null)
			{%>
		<td><%=dgResultEntryDetailForSingleResult.getInvestigation().getNormalValue() %></td>
		<% }
		else{ %>
		<td>-</td>
		<%} }%>






	</tr>

</table>



</div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
