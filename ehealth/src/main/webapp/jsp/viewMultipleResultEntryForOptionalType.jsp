<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%
	int pageNo = 1;
	Map<String, Object> map = new HashMap<String, Object>();
	Set<DgFixedValue> fixedValList = new HashSet<DgFixedValue>();
	Set<DgFixedValue> allFixedValueList = new HashSet<DgFixedValue>();
	Set<DgFixedValue> subList = new HashSet<DgFixedValue>();
	DgSubMasInvestigation dgCollection = new DgSubMasInvestigation();
	List<String> resultSeqNoList = new ArrayList<String>();
	String age = "";
	int sizeOfList = 0;
	int resultEntryIndex = 0;
	int resultEntryIndexTemp = 0;
	int srNoCounter = 0;
	int subCounter = 1;
	Integer resultEntryIndexForMultiple = 0;
	int dgSubMasInvestigationId = 0;
	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	DgSampleCollectionDetails dgDet = new DgSampleCollectionDetails();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	Patient patient = new Patient();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("sampleCollectionList") != null) {
		sampleCollectionList = (List) map.get("sampleCollectionList");
	}
	if (request.getParameter("resultEntryIndex") != null) {
		resultEntryIndex = Integer.parseInt(request
				.getParameter("resultEntryIndex"));
		resultEntryIndexTemp = resultEntryIndex;
	}
	if (request.getAttribute("dgCollection") != null) {

		dgCollection = (DgSubMasInvestigation) request
				.getAttribute("dgCollection");
	}
	if (request.getParameter("subCounter") != null) {
		int c = Integer.parseInt(request.getParameter("subCounter"));
		//c++;//commented by govind 03-07-2017
		subCounter = c;

	}

	if (request.getParameter("srNoCounter") != null) {
		srNoCounter = Integer.parseInt(request
				.getParameter("srNoCounter"));

	}
	if (request.getParameter("dgSubMasInvestigationId") != null) {
		dgSubMasInvestigationId = Integer.parseInt(request
				.getParameter("dgSubMasInvestigationId"));

	}

	if (map.get("allFixedValueList") != null) {

		allFixedValueList = new HashSet(
				(List) map.get("allFixedValueList"));
	}
	if (map.get("resultSeqNoList") != null) {
		resultSeqNoList = (List<String>) map.get("resultSeqNoList");
	}

	if (map.get("subList") != null) {
		subList = new HashSet((List) map.get("subList"));
	}

	if (request.getParameter("resultEntryIndexForMultiple") != null) {
		resultEntryIndexForMultiple = Integer.parseInt(request
				.getParameter("resultEntryIndexForMultiple"));
	}

	if (sampleCollectionList != null && sampleCollectionList.size() > 0) {
		dgDetails = (DgSampleCollectionDetails) sampleCollectionList
				.get(0);
		dgDet = (DgSampleCollectionDetails) sampleCollectionList
				.get(resultEntryIndex);
		sizeOfList = sampleCollectionList.size();
		patient = (Patient) dgDetails.getSampleCollectionHeader()
				.getHin();
	}
	for (DgFixedValue dgFixedValue : dgCollection.getDgFixedValues()) {

		if (dgFixedValue.getFixedValue() != null
				&& !dgFixedValue.getFixedValue().equalsIgnoreCase(
						"null")) {
			fixedValList.add(dgFixedValue);
		}
	}
%>
<!-- Table Starts -->



<!--  for increment of rows  -->
<%
	int detailCounter = 8;
	int temp = 0;
	int inc = resultEntryIndexForMultiple;

	if (pageNo != 1) {
		temp = detailCounter * (pageNo - 1);
	}
%>
<!--  end of increment code  -->
<!-- for getting sets  -->
<%
	Set<DgSubMasInvestigation> subSet = new HashSet<DgSubMasInvestigation>();
	Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>();

	dgDet = sampleCollectionList.get(resultEntryIndexTemp);
	normalSet = dgCollection.getDgNormalValues();
%>
<!--  if condition when result type is heading and comparison type is none -->
<!-- end of if condition when result type is heading and comparison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->
<input name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter%><%=subCounter%>"
	value=<%=dgCollection.getInvestigation().getChargeCode()
					.getChargeCodeCode()%>
	type="hidden"> <!-- if condition when result type is Range and comparison type is none -->
	<!--end of if condition when result type is Range and comparison type is none -->


	<!-- if result type is range  and comparison type is fixed values --> <%
 	if (dgCollection.getComparisonType().equalsIgnoreCase("f")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation().getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
				<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode()
						.getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"> <input name="<%=SUBTEST_NAME%>"
								type="text" value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation().getSample()
							.getId()%>
			type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample()
							.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td><input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="hidden"
			name="<%=RESULT%>" id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" /> <%-- <%
 	if (fixedValList != null) {
 			for (DgFixedValue dgFixedValue : fixedValList) {
 				if (dgCollection.getId() == dgFixedValue
 						.getSubInvestigation().getId()) {
 %><label><%=dgFixedValue.getFixedValue()%></label> <input type="radio"
		name="<%=dgCollection.getSubInvestigationName()%>"
		value="<%=dgFixedValue.getId()%>"></input> <%
 	}
 			}
 		}
 %> --%>
			<select id="fixedId<%=inc%>" name="<%=FIXED_ID%>" tabindex="1">
				<option value="">Select</option>
				<%
					if (fixedValList != null) {
							for (DgFixedValue dgFixedValue : fixedValList) {
								if (dgCollection.getId() == dgFixedValue
										.getSubInvestigation().getId()) {
				%>
				<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%
					}
							}
						}
				%>
		</select></td>
		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" class="readOnly"
				readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
					<input name="unitName" type="text" size="8" value=""
					class="readOnly" readonly /> <%
 	}
 %>
			
		</td>

		<td><input name="<%=NORMAL_ID%>" id="<%=NORMAL_ID%><%=inc%>"
			value="" type="hidden"></td>


		<td>
			<%
				if (dgDet.getRemarks() != null) {
			%> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
			id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="<%=dgDet.getRemarks()%>"
			maxlength="200"> <%
 	} else {
 %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
					<%
						}
					%>
			
		</td>
	</tr> <%
 	}
 %> <!--  end of if result type is range  and comparison type is fixed values -->
	<!--  if result type is Range and comaprison type is normal value  and condition MALE -->
	<!--  end of  if result type is range and comaprison type is normal value and condition MALE -->

	<!--  if result type is Range and comaprison type is normal value  and condition FEMALE -->
	<!--  end of  if result type is range and comaprison type is normal value and condition FEMALE-->

	<!--  if result type is range and comaprison type is normal value  and condition NONE -->
	<!--  end of  if result type is range and comaprison type is normal value and condition NONE -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		