<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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
%>


<%
	normalSet = dgCollection.getDgNormalValues();
%>
<!--  if condition when result type is heading and comaprison type is none -->
<!-- end of if condition when result type is heading and comaprison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->

<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%><input
	name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter%><%=subCounter%>"
	value=<%=dgCollection.getInvestigation().getChargeCode()
					.getChargeCodeCode()%>
	type="hidden" />
<!-- if condition when result type is   text Area and comparison type is none -->
<%
	if (dgCollection.getResultType().equalsIgnoreCase("m")
			&& dgCollection.getComparisonType().equalsIgnoreCase("n")) {
%>
<tr>
	<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId()%>"
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>" /> <input
		type="hidden"
		value="<%=dgCollection.getInvestigation().getChargeCode()
						.getId()%>"
		name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>" /> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %>
		<input name="<%=SUBTEST_NAME%>" type="text"
		value="<%=dgCollection.getSubInvestigationName()%>" class="readOnly"
		readonly /> <input name="<%=SUBTEST_ID%>"
		id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
		type="hidden" /> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
		id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
		type="hidden" /> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
		id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden" /> <input
		name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
		readonly /> <%
 	}
 %></td>
	<td>
		<%
			if (dgCollection.getInvestigation().getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection.getInvestigation().getSample()
							.getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection.getInvestigation().getSample()
							.getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>
	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m">
			</option> <input type="text" <%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>"
			tabindex="1" maxlength="100" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
			/> <input type="hidden"
			name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>" value="" /></td>
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
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
		value="" type="hidden"> <label>-</label></td>
	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
			id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
				<%
					}
				%>
		
	</td><td><% 
	String paymentStatus="";
	//added by govind 23-01-2017
	int visitid=0,orderid=0,chargeCodeid=0,hospitalid=0;
	if(dgDet.getSampleCollectionHeader()!=null && dgDet.getSampleCollectionHeader().getOrder()!=null  && dgDet.getSampleCollectionHeader().getOrder().getVisit()!=null){
		visitid=dgDet.getSampleCollectionHeader().getOrder().getVisit().getId();
	}
	if(dgDet.getSampleCollectionHeader()!=null && dgDet.getSampleCollectionHeader().getOrder()!=null){
		orderid=dgDet.getSampleCollectionHeader().getOrder().getId();
	}
	if(dgDet.getInvestigation()!=null && dgDet.getInvestigation().getChargeCode()!=null){
		chargeCodeid= dgDet.getInvestigation().getChargeCode().getId();
	}
	if(dgDet.getSampleCollectionHeader()!=null && dgDet.getSampleCollectionHeader().getHospital()!=null ){
		hospitalid=dgDet.getSampleCollectionHeader().getHospital().getId();
	}
	//paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
	paymentStatus=HMSUtil.getBillStatus(visitid,orderid,chargeCodeid,hospitalid);
	//added by govind 23-01-2017 end
	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ %>
				<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%}%>
				
				</td>
</tr>
<%
	}
%>
<!--end of if condition when result type is text Area and comparison type is none -->


<!-- if result type is text area and comparison type is fixed values  -->
<%
	if (dgCollection.getResultType().equalsIgnoreCase("m")
			&& dgCollection.getComparisonType().equalsIgnoreCase("f")) {
%>

<tr>
	<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
	<td><input type="hidden"
		value="<%=dgCollection.getInvestigation().getId()%>"
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation().getChargeCode()
						.getId()%>"
			name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation().getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection.getInvestigation().getSample()
							.getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection.getInvestigation().getSample()
							.getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m">
			</option> <input type="hidden" name="<%=RESULT%>" id="<%=RESULT%><%=inc%>"
			tabindex="1" maxlength="100" 
			value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
			/> <select id="fixedId<%=inc%>"
			name="<%=FIXED_ID%>" tabindex="1">
				<option value="">Select</option>
				<%
					if (fixedValList != null) {
							for (DgFixedValue dgFixedValue : fixedValList) {
								if (dgCollection.getId() == dgFixedValue
										.getSubInvestigation().getId())
				%>
				<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%
					}
						}
				%>
		</select></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())) {
	%>
	<td><input type="hidden" name="<%=QC_RESULT%>"
		id="<%=QC_RESULT%><%=inc%>" tabindex="1" maxlength="100" /> <select
		id="<%=QC_FIXED_ID%><%=inc%>" name="<%=QC_FIXED_ID%>" tabindex="1">
			<option value="">Select</option>
			<%
				if (fixedValList != null) {
							for (DgFixedValue dgFixedValue : fixedValList) {
								if (dgCollection.getId() == dgFixedValue
										.getSubInvestigation().getId())
			%>
			<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
			<%
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
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
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
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
</tr>
<%
	}
%><!--end of if condition when result type is text area and comparison type is fixed values-->
<%
	String sex = "";
	if (patient != null) {
		sex = patient.getSex().getAdministrativeSexName();
		age = patient.getAge();
	} else {
		Set<DgOrderdt> set = new HashSet<DgOrderdt>();
		set = dgDetails.getSampleCollectionHeader().getOrder()
				.getDgOrderdts();
		for (DgOrderdt orderDt : set) {
			if (orderDt.getBill() != null) {
				BlOpBillHeader billHeader = orderDt.getBill();
				if (billHeader.getHin() != null) {
					//patientName=billHeader.getHin().getPFirstName();
					age = billHeader.getHin().getAge();
					//currentAge = HMSUtil.calculateAgeForADT(age, dgDetails.getSampleCollectionHeader().getOrder().getHin().getRegDate());
					sex = billHeader.getHin().getSex()
							.getAdministrativeSexName();
					//hinNo=billHeader.getHin().getHinNo();
					//hinId=billHeader.getHin().getId();

				} else {
					//patientName=billHeader.getPatientName();
					age = billHeader.getAge();
					sex = billHeader.getSex()
							.getAdministrativeSexName();
					//currentAge=billHeader.getAge();
					//hinNo="--";
					//maritalStatus="--";
				}
			}
		}

	}
%>
<!-- if result type is text  and comparison type is fixed values -->
<!--  if result type is Text Area and comaprison type is normal value  and condition MALE -->
<%
	if (sex.equalsIgnoreCase("male")) {
%>
<%
	if (dgCollection.getResultType().equalsIgnoreCase("m")
				&& dgCollection.getComparisonType().equalsIgnoreCase(
						"v")) {
%>

<%
	String age1 = "";
			//age = patient.getAge();
			int index = age.indexOf(" ");
			age1 = age.substring(0, index);
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>" /> <input
		type="hidden"
		value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
		name="<%=CHARGE_CODE_ID%>" id="<%=CHARGE_CODE_ID%><%=inc%>" /> <%
 	if (dgCollection.getSubInvestigationName() != null) {
 %>
		<input name="<%=SUBTEST_NAME%>" type="text"
		value="<%=dgCollection
												.getSubInvestigationName()%>" class="readOnly"
		readonly /> <input name="<%=SUBTEST_ID%>"
		id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
		type="hidden" /> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
		id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
		type="hidden" /> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
		id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden" /> <input
		name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
		readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation()
											.getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100" 
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		/> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value="<%=dgCollection.getUom().getId()%>" type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
												.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>
	<td>
		<%
			if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
											if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>


	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
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
</tr>
<%
	}
%>
<%
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
			name="<%=CHARGE_CODE_ID%>" id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection
											.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value="<%=dgCollection.getId()%>"
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation().getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value="<%=dgCollection.getInvestigation()
											.getSample().getId()%>"
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100" 
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		/> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
									.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
											.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>
	<td>
		<%
			if (nv.getNormalValue() != null
										|| nv.getMinNormalValue() != null
										|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
										if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>

	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
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
</tr>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<!--  end of  if result type is text area and comaprison type is normal value and condition MALE -->

<!--  if result type is Text Area and comaprison type is normal value  and condition FEMALE -->
<%
	if (sex.equalsIgnoreCase("female")) {
%>
<%
	if (dgCollection.getResultType().equalsIgnoreCase("m")
				&& dgCollection.getComparisonType().equalsIgnoreCase(
						"v")) {
%>

<%
	String age1 = "";
			//age = patient.getAge();
			int index = age.indexOf(" ");
			age1 = age.substring(0, index);
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
			name="<%=CHARGE_CODE_ID%>" id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection
												.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>
	<td>
		<%
			if (dgCollection.getInvestigation()
											.getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>
	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100"
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		 /> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
												.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>
	<td>
		<%
			if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
											if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
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
</tr>
<%
	}
%>
<%
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
			name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection
											.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation().getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection.getInvestigation()
											.getSample().getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100" 
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		/> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
									.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
											.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>

	<td>
		<%
			if (nv.getNormalValue() != null
										|| nv.getMinNormalValue() != null
										|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
										if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>



	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
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
</tr>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<!--  end of  if result type is text area and comaprison type is normal value and condition FEMALE-->

<!--  if result type is Text Area and comaprison type is normal value  and condition NONE -->
<%
	if (sex.equalsIgnoreCase("Not applicable")) {
%>
<%
	if (dgCollection.getResultType().equalsIgnoreCase("m")
				&& dgCollection.getComparisonType().equalsIgnoreCase(
						"v")) {
%>

<%
	String age1 = "";
			//age = patient.getAge();
			int index = age.indexOf(" ");
			age1 = age.substring(0, index);
			if (normalSet.size() > 0) {
				for (DgNormalValue nv : normalSet) {
					if (nv.getFromAge() != null
							&& nv.getToAge() != null
							&& !nv.getToAge().equals("")
							&& !nv.getFromAge().equals("")) {
						if (nv != null
								&& nv.getSex().equalsIgnoreCase("n")
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation()
											.getChargeCode().getId()%>"
			name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection
												.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation()
											.getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection
												.getInvestigation().getSample()
												.getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10" class="readOnly"
			value="<%=dgCollection
												.getInvestigation().getSample()
												.getSampleDescription()%>"
			readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100" 
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		/> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
										.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
												.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>

	<td>
		<%
			if (nv.getNormalValue() != null
											|| nv.getMinNormalValue() != null
											|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
											if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 											&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		class="readOnly" readonly /> <input name="normalValue" type="text"
		size="8"
		value="<%=nv
														.getMinNormalValue()
														+ " - "
														+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 								} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200"> <%
 	} else {
 %> <input
			type="text" name="<%=ADDITIONAL_REMARKS%>"
			id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
				<%
					}
				%>
		
	</td>
	<td><% 
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
</tr>
<%
	}
%>
<%
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
		name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
			<input type="hidden"
			value="<%=dgCollection.getInvestigation()
										.getChargeCode().getId()%>"
			name=<%=CHARGE_CODE_ID%> id="<%=CHARGE_CODE_ID%><%=inc%>">
				<%
					if (dgCollection.getSubInvestigationName() != null) {
				%> <input
				name="<%=SUBTEST_NAME%>" type="text"
				value="<%=dgCollection
											.getSubInvestigationName()%>" class="readOnly"
				readonly /> <input name="<%=SUBTEST_ID%>"
				id="<%=SUBTEST_ID%><%=inc%>" value=<%=dgCollection.getId()%>
				type="hidden"> <input name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <input name="<%=SUBTEST_ID%>"
						id="<%=SUBTEST_ID%><%=inc%>" value="" type="hidden"> <input
							name="<%=SUBTEST_NAME%>" type="text" value="" class="readOnly"
							readonly /> <%
 	}
 %></td>

	<td>
		<%
			if (dgCollection.getInvestigation().getSample() != null) {
		%> <input
		name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%><%=inc%>"
		value=<%=dgCollection.getInvestigation()
											.getSample().getId()%>
		type="hidden"> <input name="<%=SAMPLE_NAME%>" type="text"
			size="10"
			value="<%=dgCollection.getInvestigation()
											.getSample().getSampleDescription()%>"
			class="readOnly" readonly /> <%
 	} else {
 %> <input name="<%=SAMPLE_ID%>"
			id="<%=SAMPLE_ID%><%=inc%>" value="" type="hidden"> <input
				name="<%=SAMPLE_NAME%>" type="text" size="10" value=""
				class="readOnly" readonly /> <%
 	}
 %>
	</td>

	<td>
	<input type="hidden" <%if(resultEntryId>0){%>name="resultEntryId"<%} %> value="<%=resultEntryId%>"/>
	<input type="hidden" name="<%=RESULT_TYPE%>"
		id="<%=RESULT_TYPE%><%=inc%>" value="m" /> <input type="text"
		<%if(resultEntryId>0){%>name="upResult"<%}else{ %>name="<%=RESULT%>"<%} %> id="<%=RESULT%><%=inc%>" tabindex="1"
		maxlength="100" 
		value="<%=(multResultVal!=null)?multResultVal:""%>" 
		<%if(!resultStatus.equals("A") && resultCount>0){ %> readonly="readonly" <%} %>
		onkeypress="return validateAmountDot(event)"
		/> <input type="hidden" name="<%=FIXED_ID%>"
		id="<%=FIXED_ID%><%=inc%>" value="" /></td>
	<%-- <%
		if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient
									.getHinNo())) {
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
		%> <input
		name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>"
		value=<%=dgCollection.getUom().getId()%> type="hidden"> <input
			name="unitName" type="text" size="8"
			value="<%=dgCollection.getUom()
											.getUomName()%>" class="readOnly"
			readonly /> <%
 	} else {
 %> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%><%=inc%>" value="" type="hidden">
				<input name="unitName" type="text" size="8" value=""
				class="readOnly" readonly /> <%
 	}
 %>
		
	</td>

	<td>
		<%
			if (nv.getNormalValue() != null
										|| nv.getMinNormalValue() != null
										|| nv.getMaxNormalValue() != null) {
		%>
		<%
			if (nv.getNormalValue() != null) {
										if (!nv.getNormalValue().equals("")) {
		%> <input name="normalId" type="hidden" size="8"
		value="<%=nv.getId()%>" readonly /> <input name="normalValue"
		type="text" size="8" value="<%=nv.getNormalValue()%>" class="readOnly"
		readonly /> <%
 	} else if (nv.getMinNormalValue() != null
 										&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
													+ " - "
													+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 							} else if (nv.getMinNormalValue() != null
 									&& nv.getMaxNormalValue() != null) {
 %>
		<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
		readonly /> <input name="normalValue" type="text" size="8"
		value="<%=nv.getMinNormalValue()
												+ " - "
												+ nv.getMaxNormalValue()%>"
		class="readOnly" readonly /> <%
 	}
 						} else {
 %> <input name="normalId"
		type="hidden" size="8" value="<%=nv.getId()%>" readonly /> <input
		name="normalValue" type="text" size="8" value="" class="readOnly"
		readonly /><label>-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDet.getRemarks() != null) {
		%> <input type="text"
		name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
		value="<%=dgDet.getRemarks()%>" maxlength="200" /> <%
 	} else {
 %> <input
		type="text" name="<%=ADDITIONAL_REMARKS%>"
		id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%
 	}
 %>
	</td>
	<td><% 
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
</tr>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<%
	}
%>
<!--  end of  if result type is text area and comaprison type is normal value and condition NONE -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		