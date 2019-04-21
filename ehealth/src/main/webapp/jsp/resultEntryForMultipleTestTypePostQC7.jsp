<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.DecimalFormat"%>
<%
	DgResultEntryDetail dgDetail = null;
	DgResultEntryHeader dgResultEntryHeader = null;
	Integer resultEntryIndex = 0;
	Integer resultEntryIndexForMultiple = 0;
	int i = 0;
	char subCounter = request.getParameter("subCounter").charAt(0);
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
	if (request.getAttribute("dgResultEntryHeaderForMultipleTestType") != null) {
		dgResultEntryHeader = (DgResultEntryHeader) request
				.getAttribute("dgResultEntryHeaderForMultipleTestType");
	}

	if (dgResultEntryHeader.getHin().getSex()
			.getAdministrativeSexName()
			.equalsIgnoreCase("Not applicable")) {

		if (dgDetail.getSubInvestigation().getDgNormalValues().size() > 0) {
			for (DgNormalValue nv : dgDetail.getSubInvestigation()
					.getDgNormalValues()) {
				if (nv != null && nv.getSex().equalsIgnoreCase("n")) {
%>
<tr>
	<td><%=resultEntryIndex + 1%></td>
	<td>
		<%
			if (dgDetail.getSubInvestigation() != null) {
		%> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=i%>"
		type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation()
										.getId()%>"
		readonly /> <input name="<%=SUBTEST_NAME%>"
		id="<%=SUBTEST_NAME%><%=i%>" type="text"
		value="<%=dgDetail.getSubInvestigation()
										.getSubInvestigationName()%>"
		class="readOnly" readonly /> <%
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
		readonly /> <label name="sample" id="sample<%=i%>"><%=dgDetail.getSample()
										.getSampleDescription()%> <%
 	} else {
 %> <label name="<%=SAMPLE_ID%>" id="sample<%=i%>">-</label> <%
 	}
 %>
	</td>

	<td>
		<!-- frst if --> <%
 	if (dgDetail.getResult() != null
 							&& !dgDetail.getResult().equals("")) {
 						/**second if **/
 						if (!dgDetail.getResult().contains("-")) {
 							/**third if **/
 							if (dgDetail.getNormal() != null
 									&& !dgDetail.getNormal().equals("")) {
 								if (dgDetail.getNormal()
 										.getNormalValue() != null
 										&& !dgDetail.getNormal()
 												.getNormalValue()
 												.equals("")) {
 									if (Integer.parseInt(dgDetail
 											.getResult()) > Integer
 											.parseInt(dgDetail
 													.getNormal()
 													.getNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		class="highlight" value="<%=dgDetail.getResult()%>" /> <%
 	} else if (Integer
 											.parseInt(dgDetail
 													.getResult()) < Integer
 											.parseInt(dgDetail
 													.getNormal()
 													.getNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		value="<%=dgDetail.getResult()%>" /> <%
 	}
 								}
 								if (dgDetail.getNormal()
 										.getMaxNormalValue() != null
 										&& !dgDetail.getNormal()
 												.getMaxNormalValue()
 												.equals("")) {
 									if (Integer.parseInt(dgDetail
 											.getResult()) < Integer
 											.parseInt(dgDetail
 													.getNormal()
 													.getMaxNormalValue())
 											&& Integer
 													.parseInt(dgDetail
 															.getResult()) > Integer
 													.parseInt(dgDetail
 															.getNormal()
 															.getMinNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <%
 	} else {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		class="highlight" value="<%=dgDetail.getResult()%>" /> <%
 	}
 								}
 %> <!--  else if third if  --> <%
 	} else {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		value="<%=dgDetail.getResult()%>" /> <!--  else of second if --> <%
 	}
 						} else {
 							String[] minMax = dgDetail.getResult()
 									.split("-");
 							if (Integer.parseInt(minMax[0]) < Integer
 									.parseInt(dgDetail.getNormal()
 											.getMinNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		class="highlight" value="<%=minMax[0]%>-<%=minMax[1]%>" /> <%
 	} else if (Integer.parseInt(minMax[1]) > Integer
 									.parseInt(dgDetail.getNormal()
 											.getMaxNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		class="highlight" value="<%=minMax[0]%>-<%=minMax[1]%>" /> <%
 	} else if (Integer.parseInt(minMax[1]) > Integer
 									.parseInt(dgDetail.getNormal()
 											.getMinNormalValue())
 									|| Integer.parseInt(minMax[0]) < Integer
 											.parseInt(dgDetail
 													.getInvestigation()
 													.getMaxNormalValue())) {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		value="<%=minMax[0]%>-<%=minMax[1]%>" /> <%
 	}
 						}
 						/**else of frst if  **/
 					} else {
 %> <input name="<%=RESULT%>"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>"
		onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=resultEntryIndexForMultiple%>','<%=resultEntryIndex + 1%>','<%=subCounter%>');"
		value="" /> <%
 	}
 %>
	</td>
	<%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgDetail.getResultEntry().getHin()
					.getHinNo())) {
		%>
		<td><label><%=dgDetail.getQcResult()%></label>
		<input type="hidden" name="<%=QC_RESULT_SINGLE_VALUE %>" tabindex="1" id="<%=QC_RESULT_SINGLE_VALUE %><%=i%>" value="" />
		</td>
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
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=i%>"><%=dgDetail.getUom().getUomName()%>
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
		%> <%
 	if (dgDetail.getNormal().getNormalValue() != null
 								|| dgDetail.getNormal()
 										.getMinNormalValue() != null
 								|| dgDetail.getNormal()
 										.getMaxNormalValue() != null) {
 %> <%
 	if (dgDetail.getNormal().getNormalValue() != null) {
 								if (!dgDetail.getNormal()
 										.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" id="normalId" size="5"
		value="<%=dgDetail.getNormal()
													.getId()%>" readonly />
		<label name="normalValue" id="normalValue"><%=dgDetail.getNormal()
													.getNormalValue()%> <%
 	} else if (dgDetail.getNormal()
 										.getMinNormalValue() != null
 										&& dgDetail.getNormal()
 												.getMaxNormalValue() != null) {
 %> <label name="normalValue" id="normalValue"><%=dgDetail.getNormal()
													.getMinNormalValue()
													+ " - "
													+ dgDetail
															.getNormal()
															.getMaxNormalValue()%> <input name="normalId"
				type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal()
													.getId()%>" readonly />
				<%
					}
											} else if (dgDetail.getNormal()
													.getMinNormalValue() != null
													&& dgDetail.getNormal()
															.getMaxNormalValue() != null) {
				%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId()%>" readonly /> <label
				name="normalValue" id="normalValue"><%=dgDetail.getNormal()
												.getMinNormalValue()
												+ " - "
												+ dgDetail.getNormal()
														.getMaxNormalValue()%> <%
 	}
 						} else {
 %> <input name="normalId" type="hidden" id="normalId" size="5"
					value="<%=dgDetail.getNormal().getId()%>" readonly /> <label
					name="normalValue" id="normalValue">-</label> <%
 	}
 					}
 %>
	</td>

	<%-- <td>
		<%
			if (dgDetail.getResultDetailStatus()
									.equalsIgnoreCase("A")) {
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
			if (dgDetail.getResultDetailStatus()
									.equalsIgnoreCase("A")) {
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
			if (dgDetail.getResultDetailStatus()
									.equalsIgnoreCase("A")) {
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

<%
	}
			}
		}
	}
