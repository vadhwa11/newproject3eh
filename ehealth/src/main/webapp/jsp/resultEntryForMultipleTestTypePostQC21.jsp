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
%>

<tr>
	<td><%=resultEntryIndex + 1%></td>
	<td>
		<%
			if (dgDetail.getSubInvestigation() != null) {
		%> <input name="<%=SUBTEST_ID%>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /><input
		name="<%=SUBTEST_NAME%>" id="<%=SUBTEST_NAME%><%=i%>" type="text"
		value="<%=dgDetail.getSubInvestigation()
						.getSubInvestigationName()%>"
		class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" type="text" size="2" value="" readonly />
		<%
			}
		%>
	</td>

	<td>
		<%
			if (dgDetail.getSample() != null) {
		%> <input name="<%=SAMPLE_ID%>" id=<%=SAMPLE_ID%> type="hidden"
		size="5" value="<%=dgDetail.getSample().getId()%>" readonly /> <input
		name="sample" type="text"
		value="<%=dgDetail.getSample().getSampleDescription()%>" readonly />
		<%
			} else {
		%> <input name="<%=SAMPLE_ID%>" type="text" value="" readonly /> <%
 	}
 %>
	</td>


	<td>
		<%
			if (dgDetail.getFixed() != null && dgDetail.getResult() == null) {
		%> <input type="text" name="<%=FIXED_ID%>" id="<%=FIXED_ID%>"
		value="<%=dgDetail.getFixed().getFixedValue()%>" /> <input
		type="hidden" name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>" tabindex="1"
		value="<%=dgDetail.getResult()%>" /> <%
 	} else {
 %> <input type="text" name="<%=FIXED_ID%>" id="<%=FIXED_ID%>" value="" />
		<input type="hidden" name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>" tabindex="1" value="" />
		<%
			}
		%>
	</td>
		<%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgDetail.getResultEntry().getHin()
					.getHinNo())) {
		%>
		<td><label><%=dgDetail.getQcFixed().getFixedValue()%></label>
		<input type="hidden" name="<%=QC_RESULT_SINGLE_VALUE %>" tabindex="1" id="<%=QC_RESULT_SINGLE_VALUE %><%=i%>" value="" />
		</td>
		<%
			}
		%>
	<td>
		<%
			if (dgDetail.getUom() != null) {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>" type="text" size="5"
		value="<%=dgDetail.getUom().getUomName()%>" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>" type="text" size="2"
		value="" readonly /> <%
 	}
 %>
	</td>

	<td>
		<%
			if (dgDetail.getNormal() != null) {
		%> <%
 	if (dgDetail.getNormal().getNormalValue() != null
 				|| dgDetail.getNormal().getMinNormalValue() != null
 				|| dgDetail.getNormal().getMaxNormalValue() != null) {
 %> <%
 	if (dgDetail.getNormal().getNormalValue() != null) {
 				if (!dgDetail.getNormal().getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId()%>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%=dgDetail.getNormal().getNormalValue()%>" readonly /> <%
 	} else if (dgDetail.getNormal().getMinNormalValue() != null
 						&& dgDetail.getNormal().getMaxNormalValue() != null) {
 %> <input name="normalValue" type="text" size="8"
		value="<%=dgDetail.getNormal().getMinNormalValue()
									+ " - "
									+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <input name="normalId" type="hidden" id="normalId"
		size="5" value="<%=dgDetail.getNormal().getId()%>" readonly /> <%
 	}
 			} else if (dgDetail.getNormal().getMinNormalValue() != null
 					&& dgDetail.getNormal().getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId()%>" readonly /> <input
		name="normalValue" type="text" size="8"
		value="<%=dgDetail.getNormal().getMinNormalValue()
								+ " - "
								+ dgDetail.getNormal().getMaxNormalValue()%>"
		readonly /> <%
 	}
 		} else {
 %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal().getId()%>" readonly /> <label>-</label>
		<%
			}
			}
		%>
	</td>

	<%-- <td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>" onclick="retest(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		/ style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>" onclick="retest(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		name="checkIdRecollect<%=resultEntryIndexForMultiple%>" onclick="recollect(this,<%=resultEntryIndexForMultiple%>);" 
		type="checkbox" class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		name="checkIdRecollect<%=resultEntryIndexForMultiple%>" onclick="recollect(this,<%=resultEntryIndexForMultiple%>);" 
		type="checkbox" class="check" /> <%
 	}
 %>
	</td> --%>

	<td>
		<%
			if (dgDetail.getRemarks() != null) {
		%> <input name="<%=ADDITIONAL_REMARKS%>" type="text"
		value="<%=dgDetail.getRemarks()%>" /> <%
 	} else {
 %> <input name="<%=ADDITIONAL_REMARKS%>" type="text" value="" /> <%
 	}
 %> <input name="<%=RESULT_DETAIL_ID%>" id="<%=RESULT_DETAIL_ID%>"
		type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly />
	</td>
</tr>


<%%>
