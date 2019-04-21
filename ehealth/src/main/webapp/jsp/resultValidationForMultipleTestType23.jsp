<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="java.util.*"%>

<%	DgResultEntryDetail dgDetail = null;
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
	        <td><%=resultEntryIndex%></td>
				<td><input name="<%=RESULT_TYPE_FOR_SENSITIVE %>"
						id="<%=RESULT_TYPE_FOR_SENSITIVE %>" value="m" type="hidden">
						<input name="<%=RESULT_ID%>"
						 value="<%=dgDetail.getResultEntry().getId()%>" type="hidden">
		<label name="investigationName" style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>
							</td>
					<td>
				<%
			if (dgDetail.getSample() != null) {
		%> <input name="<%=SAMPLE_ID%>" id=<%=SAMPLE_ID%> type="hidden"
		size="5" value="<%=dgDetail.getSample().getId()%>" readonly />
	<input name="<%=SAMPLE_ID%>" type="text" value="<%=dgDetail.getSample().getSampleDescription()%>" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" type="text" value="Urine" readonly /> <%
 	}
 %>
				</td>
				<td>
						<select id=""
						name="<%=RESULT %>">
							<option value="<%=dgDetail.getResult()%>"><%=dgDetail.getResult()%></option>
							<option value="Positive">Positive</option>
							<option value="Negative">Negative</option>
					</select>

				</td>
					<td>
					<%
			if (dgDetail.getInvestigation().getUom() != null) {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%>" type="hidden" size="5"
		value="<%=dgDetail.getInvestigation().getUom().getId()%>" readonly /> <label><%=dgDetail.getInvestigation().getUom().getUomName()%></label>
		<%
			} else {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>" type="hidden" size="2"
		value="" readonly /><label>-</label> <%
 	}
 %>
					</td>
					<td>
						<%
			if (dgDetail.getFixedNormalValue()!= null) {
		%> <label><%=dgDetail.getFixedNormalValue()%></label> <%
 	} else {
 %> <label>-</label> <%
 	}
 %>
					</td>
			<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%><label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkId<%=resultEntryIndex%>"
		name="checkId<%=resultEntryIndex%>" onclick="accepted(this,<%=resultEntryIndex%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %><label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkId<%=resultEntryIndex%>"
		name="checkId<%=resultEntryIndex%>" onclick="accepted(this,<%=resultEntryIndex%>);"  type="checkbox"
		class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkIdRetest<%=resultEntryIndex%>"
		name="checkIdRetest<%=resultEntryIndex%>" onclick="retest(this,<%=resultEntryIndex%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkIdRetest<%=resultEntryIndex%>"
		name="checkIdRetest<%=resultEntryIndex%>" onclick="retest(this,<%=resultEntryIndex%>);"  type="checkbox"
		class="check" /> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkIdRecollect<%=resultEntryIndex%>"
		name="checkIdRecollect<%=resultEntryIndex%>" onclick="recollect(this,<%=resultEntryIndex%>);" 
		type="checkbox" class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

		<input id="checkIdRecollect<%=resultEntryIndex%>"
		name="checkIdRecollect<%=resultEntryIndex%>" onclick="recollect(this,<%=resultEntryIndex%>);" 
		type="checkbox" class="check" /> <%
 	}
 %>
	</td>
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
	