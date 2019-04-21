<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%
	DgResultEntryDetail dgDetail = null;
	Integer resultEntryIndex = 0;
	Integer resultEntryIndexForMultiple = 0;
	int i = 0;
	if (request.getParameter("resultEntryIndex") != null) {
		resultEntryIndex = Integer.parseInt(request
				.getParameter("resultEntryIndex"));
	}
	if (request.getParameter("resultEntryIndexForMultiple") != null) {
		resultEntryIndexForMultiple = Integer.parseInt(request
				.getParameter("resultEntryIndexForMultiple"));
	}
	if (request.getParameter("i") != null) {
		i = Integer.parseInt(request.getParameter("i"));
	}
	if (request.getAttribute("dgDetailForMultipleTestType") != null) {
		dgDetail = (DgResultEntryDetail) request
				.getAttribute("dgDetailForMultipleTestType");

	}
	Integer sampleId=0;
%>
<tr>
	<%if (dgDetail.getSubInvestigation() != null) {%>
	<td><%=resultEntryIndex%>.<%=dgDetail.getSubInvestigation().getOrderNo()%></td>
	<%} %>
	<td>
		<%
			if (dgDetail.getSubInvestigation() != null) {
		%> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=i%>"
		type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME%>" id="<%=SUBTEST_NAME%><%=i%>" type="hidden"
		value="<%=dgDetail.getSubInvestigation()
						.getSubInvestigationName()%>"
		class="readOnly" readonly /><label class="heading"><%=dgDetail.getSubInvestigation()
						.getSubInvestigationName()%></label> <%
 	} else {
 %> <label name="<%=SUBTEST_ID%>" id="<%=SUBTEST_NAME%><%=i%>">-</label>
		<%
			}
		%>
	</td>
	<td>
		<%
			if (dgDetail.getSample() != null) {
		%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=i%>"
		type="hidden" size="5" value="<%=dgDetail.getSample().getId()%>"
		readonly /> <label name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription()%></label>
		<%
			} else {
		%> <label name="<%=SAMPLE_ID%>" id="sample<%=i%>">-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResult() != null) {
				sampleId=dgDetail.getId();
		%><%-- <input type="hidden" value="" name="<%=RESULT%>"
		id="<%=RESULT%><%=i%>" />
		 govind change--%>
		 <input name="collectionId<%=resultEntryIndexForMultiple%>" value="<%=sampleId %>" type="hidden">
		 <input type="hidden" name="<%=RESULT%>"
		id="<%=RESULT%><%=i%>" tabindex="1" value="<%=dgDetail.getResult()%>" />
		<label name="<%=RESULT%>" id="<%=RESULT%><%=i%>">-</label> <%
 	} else {
 %>
 <input name="collectionId<%=resultEntryIndexForMultiple%>" value="<%=sampleId %>" type="hidden">
  <label name="<%=RESULT%>" id="<%=RESULT%><%=i%>">-</label> <input
		type="hidden" name="<%=RESULT%>" id="<%=RESULT%><%=i%>" tabindex="1"
		value="0" /> <%
 	}
 %>
	</td>
	 
		<%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgDetail.getResultEntry().getHin()
					.getHinNo())) {
				String val="-";
				if(dgDetail.getQcResult()!=null){
					val=dgDetail.getQcResult();
				}
		%>
		<td><label><%=val%></label></td>
		<%
			}
		%>
	 
	<td>
		<%
			if (dgDetail.getUom() != null) {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=i%>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=i%>"><%=dgDetail.getUom().getUomName()%></label>
		<%
			} else {
		%> <label name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=i%>">-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getNormal() != null) {
		%> <input name="normalValue" id="normalId<%=i%>" type="hidden"
		size="5" value="<%=dgDetail.getNormal().getNormalValue()%>" readonly />
		<label name="normalValue" id="normalId<%=i%>"> <%=dgDetail.getUom().getUomName()%></label>
		<%
			} else {
		%> <label name="normalValue" id="normalId<%=i%>">-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>
		<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>"
		onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"
		type="hidden" class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>

		<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>"
		onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"
		type="hidden" class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>
		<input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>"
		onclick="retest(this,<%=resultEntryIndexForMultiple%>);" type="hidden"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>

		<input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>"
		onclick="retest(this,<%=resultEntryIndexForMultiple%>);" type="hidden"
		class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>
		<input id="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		name="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		onclick="recollect(this,<%=resultEntryIndexForMultiple%>);"
		type="hidden" class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px;">-</label>

		<input id="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		name="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		onclick="recollect(this,<%=resultEntryIndexForMultiple%>);"
		type="hidden" class="check" /> <%
 	}
 %>
	</td>
	<td><%
		if (dgDetail.getRemarks() != null) {
	%> <input name="<%=ADDITIONAL_REMARKS%>" type="hidden"
		value="<%=dgDetail.getRemarks()%>" /> <%
 	} else {
 %> <input name="<%=ADDITIONAL_REMARKS%>" type="hidden" value="" /> <%
 	}
 %> <input name="<%=RESULT_DETAIL_ID%>" id="<%=RESULT_DETAIL_ID%>"
		type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly />
	</td>
</tr>
<%
	
%>
