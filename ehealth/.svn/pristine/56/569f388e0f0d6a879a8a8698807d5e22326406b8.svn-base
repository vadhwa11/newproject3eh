<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<%@page import="java.util.*"%>
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
	
	//added by govind 17-06-2017
		String multResultVal=null,resultStatus="P";
		Integer resultEntryId=0;
		if (request.getAttribute("multResultVal") != null) {
			multResultVal = (String) request
					.getAttribute("multResultVal");
		}		//added by govind 16-06-2017 end
		int resultCount=0; 
		if(request.getAttribute("resultCount")!=null){
			resultCount=(Integer)request.getAttribute("resultCount");
		}
		if (request.getAttribute("resultStatus") != null) {

			resultStatus = (String) request
					.getAttribute("resultStatus");
		}
		if (request.getAttribute("resultEntryId") != null) {

			resultEntryId = Integer.parseInt((String) request
					.getAttribute("resultEntryId"));
		}
		System.out.println("multResultVal "+multResultVal+" resultCount "+resultCount);
		
		//added by govind 17-06-2017 end
%>
<!-- Table Starts -->
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Patient"%>


<!--  for increment of rows  -->
<%
	int detailCounter = 8;
	int temp = 0;
	int inc = resultEntryIndexForMultiple;
System.out.println("inc------------------108---"+inc);
	if (pageNo != 1) {
		temp = detailCounter * (pageNo - 1);
	}
%>
<!--  end of increment code  -->
<!-- for getting sets  -->
<%
	Set<DgSubMasInvestigation> subSet = new HashSet<DgSubMasInvestigation>();
	Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>();
	//while(sampleCollectionList.get(resultEntryIndexTemp).getInvestigation().getInvestigationType()
	//		.equalsIgnoreCase("m")){
	//}
	//for(DgSampleCollectionDetails dgDet :sampleCollectionList)
	//{
	dgDet = sampleCollectionList.get(resultEntryIndexTemp);
%>
<%--<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<tr>
		  <td><label name="<%=SR_NO%>"><%=srNoCounter%></label></td>
		  <td>
			<%if(dgDet.getDiagNo() != null){ %>
				<label name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>><%=dgDet.getDiagNo() %></label>
			<%}else{ %>
				<label name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>>-</label>
			<%} %>
		  </td>
			<td>
				<label name="<%=INVESTIGATION_NAME%>" style="font-weight: bold;"><%=dgDet.getInvestigation().getInvestigationName() %> </label>
				<input type= "hidden" name="<%=TEST_ORDER_NO_MULTIPLE_VALUE%>"
						value="<%=dgDet.getInvestigation().getTestOrderNo()%>"
				</input>
			</td>
			<td>
			  <input type="hidden" name="HeaderCountFlag" id="HeaderCountFlag" value="HeaderCountFlag" />
			</td>
		    <td>
		    	<input type="hidden" name="<%=RESULT_NO_FOR_MULTIPLE_VALUE%>" value="<%=resultSeqNoList.get(resultEntryIndexTemp) %>" title="Result No."  />
		    </td>
			<td>


			  <input type="hidden" name="<%=SUB_TEST_SIZE%>" id="<%=SUB_TEST_SIZE %>" value="<%=subSet1.size()%>" />

 			  <input type="hidden" name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS %>" value="" />
 			  <input type="hidden" name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID %>" value="" />
  			  <input type="hidden" name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID %>" value="" />
  			  <input type="hidden" name="<%=NORMAL_ID%>" id="<%=NORMAL_ID %>" value="" />
  			  <input type="hidden" name="<%=FIXED_ID%>" id="<%=FIXED_ID %>" value="" />
			  <input type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID%>" id="<%=UNIT_OF_MEASUREMENT_ID %>" value="" />
			  <input type="hidden" name="<%=RESULT_TYPE%>" id="<%=RESULT_TYPE %>" value="" />
			  <input type="hidden" name="<%=INVESTIGATION_ID%>" id="<%=INVESTIGATION_ID %>" value="" />
			  <input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>" id="<%=DG_SAMPLE_DETAIL_ID %>" value="" />

			</td>
			<td>
			  <input type="hidden" name="<%=RESULT%>" id="<%=RESULT%><%=inc%>" value="TestRowFlag" />
			</td>
			<% inc++; %>

		</tr>--%>

<%
	normalSet = dgCollection.getDgNormalValues();
%>
<!--  if condition when result type is heading and comaprison type is none -->
<!-- end of if condition when result type is heading and comaprison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->
<input name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter%><%=subCounter%>"
	value=<%=dgCollection.getInvestigation().getChargeCode()
					.getChargeCodeCode()%>
	type="hidden"> <%
 	if (dgCollection.getResultType().equalsIgnoreCase("t")
 			&& dgCollection.getComparisonType().equalsIgnoreCase("n")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation().getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode()
						.getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value="<%=dgDet.getId()%>"
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>
		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation().getSample()
							.getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample()
							.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>
		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m"><input type="text"
				<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %>
				onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
				id="<%=RESULT%><%=inc%>" tabindex="1" maxlength="50"
				value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
				 /> <input
				type="hidden" name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>"
				value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())) {
		%>
		<td><input type="text" name="<%=QC_RESULT%>"
			id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input
			type="hidden" name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>"
			value="" /></td>
		<%
			}
		%> --%>
		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" class="readOnly"
				readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>
		<td><input name="<%=NORMAL_ID%>" id="<%=NORMAL_ID%><%=inc%>"
			value="" type="hidden"><label>-</label></td>
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
			
		</td><td><% 
	String paymentStatus="";
	
		
		
		if(null !=dgDet.getSampleCollectionHeader().getOrder().getVisit())
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%--<%}else if(paymentStatus.equalsIgnoreCase("y")){ %> --%>
				<%}else if(paymentStatus.equalsIgnoreCase("Settled")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <!--end of if condition when result type is text and comparison type is none -->

	<!-- if result type is text  and comparison type is fixed values --> <%
 	if (dgCollection.getResultType().equalsIgnoreCase("t")
 			&& dgCollection.getComparisonType().equalsIgnoreCase("f")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>

		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation().getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode()
						.getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value="<%=dgCollection.getId()%>"
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>
		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation().getSample()
							.getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample()
							.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>
		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m"><input type="hidden"
				name="<%=RESULT%>" id="<%=RESULT%><%=inc%>"
				onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
				tabindex="1" maxlength="50" 
				value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
				/> <select id="fixedId<%=inc%>"
				name="<%=FIXED_ID%>" tabindex="1">
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
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())) {
		%>
		<td><input type="hidden" name="<%=QC_RESULT%>"
			id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <select
			id="<%=QC_FIXED_ID%><%=inc%>" name="<%=QC_FIXED_ID%>" tabindex="1">
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
		<%
			}
		%> --%>
		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" class="readOnly"
				readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <!--  end of if result type is text  and comparison type is fixed values -->


	<!--  if result type is Text and comaprison type is normal value  and condition MALE  -->
	<%
		if (patient.getSex().getAdministrativeSexName()
				.equalsIgnoreCase("male")) {
	%> <%
 	if (dgCollection.getResultType().equalsIgnoreCase("t")
 				&& dgCollection.getComparisonType().equalsIgnoreCase(
 						"v")) {
 %> <%
 	String age1 = "";
 age = patient.getAge()!=null?patient.getAge():"";
	if(!age.equals("")){
	int index = age.indexOf(" ");
	age1 = age.substring(0, index);
	}
 			if (normalSet.size() > 0) {
 				for (DgNormalValue nv : normalSet) {
 					if (nv.getFromAge() != null
 							&& nv.getToAge() != null
 							&& !nv.getToAge().equals("")
 							&& !nv.getFromAge().equals("")) {
 						if (nv != null
 								&& (nv.getSex().equalsIgnoreCase("m") || nv
 										.getSex().equalsIgnoreCase("n"))
 								&& Integer.parseInt(age1) > nv
 										.getFromAge()
 								&& Integer.parseInt(age1) < nv
 										.getToAge()) {
 %>

	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>

		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
											.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
												.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation()
												.getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
											.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>"
			tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
												.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
												|| nv.getMinNormalValue() != null
												|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 									if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>
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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	} else if ((nv.getSex().equalsIgnoreCase("m") || nv
 							.getSex().equalsIgnoreCase("n"))
 							&& nv.getFromAge() == null
 							|| (nv.getSex().equalsIgnoreCase("m") || nv
 									.getSex().equalsIgnoreCase("n"))
 							&& nv.getSex().equalsIgnoreCase("")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>

		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
											.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation()
											.getSample().getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
											.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 								if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>



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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <!--  end of  if result type is text t and comaprison type is normal value and condition MALE -->

	<!--  if result type is Text t and comaprison type is normal value  and condition FEMALE -->
	<%
		if (patient.getSex().getAdministrativeSexName()
				.equalsIgnoreCase("female")) {
	%> <%
 	if (dgCollection.getResultType().equalsIgnoreCase("t")
 				&& dgCollection.getComparisonType().equalsIgnoreCase(
 						"v")) {
 %> <%
 
 	String age1 = "";
 			age = patient.getAge()!=null?patient.getAge():"";
 			if(!age.equals("")){
 			int index = age.indexOf(" ");
 			age1 = age.substring(0, index);
 			}
 			if (normalSet.size() > 0) {
 				for (DgNormalValue nv : normalSet) {
 					if (nv.getFromAge() != null
 							&& nv.getToAge() != null
 							&& !nv.getToAge().equals("")
 							&& !nv.getFromAge().equals("")) {
 						if (nv != null
 								&& (nv.getSex().equalsIgnoreCase("f") || nv
 										.getSex().equalsIgnoreCase("n"))
 								&& Integer.parseInt(age1) > nv
 										.getFromAge()
 								&& Integer.parseInt(age1) < nv
 										.getToAge()) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
											.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
												.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation()
												.getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
											.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
												.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
												|| nv.getMinNormalValue() != null
												|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 									if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>

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
			
		</td><td><% 
	String paymentStatus="";
		if(dgDet.getSampleCollectionHeader().getOrder().getVisit()!=null){
			paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
			
		}
		 
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	} else if ((nv.getSex().equalsIgnoreCase("f") || nv
 							.getSex().equalsIgnoreCase("n"))
 							&& nv.getFromAge() == null
 							|| (nv.getSex().equalsIgnoreCase("f") || nv
 									.getSex().equalsIgnoreCase("n"))
 							&& nv.getSex().equalsIgnoreCase("")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
											.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation()
											.getSample().getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50"
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			 /> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value="<%=dgCollection.getUom().getId()%>" type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
											.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 								if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>

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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <!--  end of  if result type is text t and comaprison type is normal value and condition FEMALE-->

	<!--  if result type is Text and comaprison type is normal value  and condition NONE -->
	<%
		if (patient.getSex().getAdministrativeSexName()
				.equalsIgnoreCase("Not applicable")) {
	%> <%
 	if (dgCollection.getResultType().equalsIgnoreCase("t")
 				&& dgCollection.getComparisonType().equalsIgnoreCase(
 						"v")) {
 %> <%
 	String age1 = "";
 age = patient.getAge()!=null?patient.getAge():"";
	if(!age.equals("")){
	int index = age.indexOf(" ");
	age1 = age.substring(0, index);
	}
 			if (normalSet.size() > 0) {
 				for (DgNormalValue nv : normalSet) {
 					if (nv.getFromAge() != null
 							&& nv.getToAge() != null
 							&& !nv.getToAge().equals("")
 							&& !nv.getFromAge().equals("")) {
 						if (nv != null
 								&& (nv.getSex().equalsIgnoreCase("n") || nv
 										.getSex().equalsIgnoreCase("n"))
 								&& Integer.parseInt(age1) > nv
 										.getFromAge()
 								&& Integer.parseInt(age1) < nv
 										.getToAge()) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
											.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
												.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation()
												.getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
											.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
												.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
												|| nv.getMinNormalValue() != null
												|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 									if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>

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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	} else if (nv.getSex().equalsIgnoreCase("n")
 							&& nv.getFromAge() == null
 							|| nv.getSex().equalsIgnoreCase("n")
 							&& nv.getSex().equalsIgnoreCase("")) {
 %>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td><input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>"><input
				type="hidden"
				value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>"> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %> <input name="<%=SUBTEST_NAME%>" type="text"
					value="<%=dgCollection
											.getSubInvestigationName()%>"
					class="readOnly" readonly /> <input name="<%=SUBTEST_ID%>"
					id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
					type="hidden"><input name="<%=DG_SAMPLE_DETAIL_ID%>"
						id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
						type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>" value=""
							type="hidden"><input name="<%=SUBTEST_NAME%>" type="text"
								value="" class="readOnly" readonly /> <%
 	}
 %></td>

		<td>
			<%
				if (dgCollection.getInvestigation().getSample() != null) {
			%> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
			value=<%=dgCollection.getInvestigation()
											.getSample().getId()%>
			type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>" value=""
				type="hidden"><input name="<%=SAMPLE_NAME%>" type="text"
					size="10" value="" class="readOnly" readonly /> <%
 	}
 %>
		</td>

		<td>
		<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
		<input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
			<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			onkeyup="submitAllExceptEnterForMultiple(this,event,'','<%=inc%>','<%=srNoCounter%>','<%=subCounter%>');"
			tabindex="1" maxlength="50" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		        <%if(!resultStatus.equals("Y") && resultCount>0){ %> readonly="readonly" <%} %>
		        
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
		%>
		<td><input type="text"
			name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="50" /> <input type="hidden"
			name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /></td>
		<%
			}
		%> --%>

		<td>
			<%
				if (dgCollection.getUom() != null) {
			%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
			value=<%=dgCollection.getUom().getId()%> type="hidden"><input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom()
											.getUomName()%>"
				class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden"><input
					name="unitName" type="text" size="8" value="" class="readOnly"
					readonly /> <%
 	}
 %>
		</td>

		<td>
			<%
				if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
			%> <%
 	if (nv.getNormalValue() != null) {
 								if (!nv.getNormalValue().equals("")) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="<%=nv.getNormalValue()%>"
			class="readOnly" readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8"
			value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
			class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId" type="hidden" size="8"
			value="<%=nv.getId()%>" readonly /> <input name="normalValue"
			type="text" size="8" value="" class="readOnly" readonly /><label>-</label>
			<%
				}
			%>
		</td>

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
			
		</td><td><% 
	String paymentStatus="";
	paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
				
				</td>
	</tr> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <%
 	}
 %> <!--  end of  if result type is text and comaprison type is normal value and condition NONE -->
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		