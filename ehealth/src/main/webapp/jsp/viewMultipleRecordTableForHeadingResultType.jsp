<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
	int pageNo = 1;
	Map<String, Object> map = new HashMap<String, Object>();
	Set<DgFixedValue> fixedValList = new HashSet<DgFixedValue>();
	DgSubMasInvestigation dgCollection = new DgSubMasInvestigation();
	int resultEntryIndex = 0;
	int resultEntryIndexTemp = 0;
	int srNoCounter = 0;
	int subCounter = 1;
	Integer resultEntryIndexForMultiple = 0;
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
	if (sampleCollectionList != null && sampleCollectionList.size() > 0) {
		dgDet = (DgSampleCollectionDetails) sampleCollectionList
				.get(resultEntryIndex);
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
	if (request.getParameter("resultEntryIndexForMultiple") != null) {
		resultEntryIndexForMultiple = Integer.parseInt(request
				.getParameter("resultEntryIndexForMultiple"));
	}
	if (sampleCollectionList != null && sampleCollectionList.size() > 0) {
		dgDetails = (DgSampleCollectionDetails) sampleCollectionList
				.get(0);
		dgDet = (DgSampleCollectionDetails) sampleCollectionList
				.get(resultEntryIndex);
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
	dgDet = sampleCollectionList.get(resultEntryIndexTemp);
	
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
	//while(sampleCollectionList.get(resultEntryIndexTemp).getInvestigation().getInvestigationType()
	//		.equalsIgnoreCase("m")){
	//}
	//for(DgSampleCollectionDetails dgDet :sampleCollectionList)
	//{
	dgDet = sampleCollectionList.get(resultEntryIndexTemp);
	normalSet = dgCollection.getDgNormalValues();
	System.out.println(dgCollection.getSubInvestigationName()+"--dgCollection.getResultType()--"+dgCollection.getResultType());
	System.out.println("dgCollection.getComparisonType()--"+dgCollection.getComparisonType());
%>
<!--  if condition when result type is heading and comaprison type is none -->
<!-- end of if condition when result type is heading and comaprison type is none -->

<!-- if condition when result type is single parameter and comparison type is none -->
<input name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=srNoCounter%><%=subCounter%>"
	value=<%=dgCollection.getInvestigation().getChargeCode()
					.getChargeCodeCode()%>
	type="hidden"> <!--  if condition when result type is heading and comaprison type is none -->
	<%
		if (dgCollection.getResultType().equalsIgnoreCase("h")
				&& dgCollection.getComparisonType().equalsIgnoreCase("n")) {
			System.out.println("heading type");
	%>
	<tr>
		<td><label><%=srNoCounter%>.<%=subCounter%>)</label></td>
		<td>
			<%
				if (dgCollection.getSubInvestigationName() != null) {
			%> <input type="hidden"
			value="<%=dgCollection.getInvestigation().getId()%>"
			name=<%=INVESTIGATION_ID%> id="<%=INVESTIGATION_ID%><%=inc%>">
				<label name="<%=SUBTEST_NAME%>" class="heading"><%=dgCollection.getSubInvestigationName()%></label>
				<input name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID%><%=inc%>"
				value=<%=dgCollection.getId()%> type="hidden"> <input
					name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>" value=<%=dgDet.getId()%>
					type="hidden"> <%
 	} else {
 %> <label class="heading" name="<%=SUBTEST_NAME%>">-</label> <%
 	}
 %>
		</td>
		<td><input name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID%>" value=""
			type="hidden" /> <label>-</label></td>
		<td><input type="hidden" name="<%=RESULT_TYPE%>"
			id="<%=RESULT_TYPE%><%=inc%>" value="m"> <input type="hidden"
				name="<%=RESULT%>" id="<%=RESULT%><%=inc%>" value="____"> <input
					type="hidden" name="<%=FIXED_ID%>" id="<%=FIXED_ID%><%=inc%>"
					value="" /> <label>-</label></td>
		<%-- <%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())) {
		%>
		<td><input type="hidden" name="<%=QC_RESULT%>"
			id="<%=QC_RESULT%><%=inc%>" value="0"> <input type="hidden"
				name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID%><%=inc%>" value="" /> <label>-</label></td>
		<%
			}
		%> --%>
		<td><input name="<%=UNIT_OF_MEASUREMENT_ID%>"
			id="<%=UNIT_OF_MEASUREMENT_ID%>" value="0" type="hidden" /> <label>-</label></td>
		<td><input name="<%=NORMAL_ID%>" id="<%=NORMAL_ID%><%=inc%>"
			value="0" type="hidden"> <input type="hidden" value=""
				name="<%=FIXED_NORMAL_VALUE%>" id="<%=FIXED_NORMAL_VALUE%><%=inc%>" />
				<label>-</label></td>
		<td><input type="hidden" name="<%=ADDITIONAL_REMARKS%>"
			id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200">
				<label>-</label></td><td><% 
		String paymentStatus="";
				if(null !=dgDet.getSampleCollectionHeader() && null !=dgDet.getSampleCollectionHeader().getOrder() && null !=dgDet.getSampleCollectionHeader().getOrder().getVisit()){
		paymentStatus=HMSUtil.getBillStatus(dgDet.getSampleCollectionHeader().getOrder().getVisit().getId(),dgDet.getSampleCollectionHeader().getOrder().getId(), dgDet.getInvestigation().getChargeCode().getId(),dgDet.getSampleCollectionHeader().getHospital().getId());
				}
	/* 	String chargeValue="Free";
				String chargeValue1="Paid";
				String chargeValue2="Not Paid";
				if(dgCollection.getInvestigation().getChargeCode().getCharge().equals(new Float(0))){ */ %>
			<%-- 	<%=chargeValue %>
				<%}else if(paymentStatus.equalsIgnoreCase("y")){ %>
				<%=chargeValue1 %>
				<%}else{ %>
				<%=chargeValue2 %>
				<%} %>
			 --%>	
				</td>
	</tr> <%
 	}
 %> <%
 	inc++;

 	//inc++;srNoCounter++;
 	srNoCounter++;
 	//resultEntryIndexTemp++;
 	//if(resultEntryIndexTemp > sizeOfList-1 ){
 	//break;
 	//}
 	//}
 %><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		