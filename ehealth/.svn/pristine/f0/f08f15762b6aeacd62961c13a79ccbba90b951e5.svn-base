<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	Map<String, Object> map = new HashMap<String, Object>();
	Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
	Integer resultEntryIndex = 0;
	char subCounter = 97;
	Integer resultEntryIndexForMultiple = 0;
	DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	try {
		if (map.get("resultList") != null) {
			resultList = (List) map.get("resultList");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (request.getParameter("resultEntryIndex") != null) {
		resultEntryIndex = Integer.parseInt(request
				.getParameter("resultEntryIndex"));
	}
	if (request.getParameter("resultEntryIndexForMultiple") != null) {
		resultEntryIndexForMultiple = Integer.parseInt(request
				.getParameter("resultEntryIndexForMultiple"));
	}

	if (resultList != null && resultList.size() > 0) {
		dgResultEntryHeader = (DgResultEntryHeader) resultList
				.get(resultEntryIndex);
		subSet1 = dgResultEntryHeader.getDgResultEntryDetails();
	}

	Set<DgResultEntryDetail> dgResultEntryDtSet = new LinkedHashSet<DgResultEntryDetail>();
	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo
			.getApplicationTreeSet();
	for (DgResultEntryDetail dgResultEntryDetail : subSet1) {
		linkedHashSet.add(dgResultEntryDetail);
	}
	dgResultEntryDtSet.addAll(linkedHashSet);
%>
<div class="clear"></div>
<!-- Table Starts -->
<%
	int i = 0;
	Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>();
%>
<tr>
	<%
		if (resultEntryIndex == 0) {
	%>
	<%--<label name="<%=INVESTIGATION_NAME%>" style="font-weight: bold;"> <%=dgResultEntryHeader.getDgResultEntryDetails()
						.iterator().next().getInvestigation()
						.getInvestigationName()%>  </label>--%>
	<%
		}
		if (resultEntryIndex == 0) {
	%>
	<td><%=resultEntryIndex + 1%></td>
	<%
		} else {
	%>
	<td></td>
	<%
		}
	%>
	<td>
		<%
			if (resultEntryIndex == 0) {
		%> <label name="<%=INVESTIGATION_NAME%>" style="font-weight: bold;"><%=dgResultEntryHeader.getDgResultEntryDetails()
						.iterator().next().getInvestigation()
						.getInvestigationName()%> </label> <%
 	}
 %>
	</td>
	<td><input type="hidden" name="HeaderCountFlag"
		id="HeaderCountFlag" value="HeaderCountFlag" /></td>
	<td></td>
	<td></td>
	<td></td>
	<td><input type="hidden" name="<%=SUB_TEST_SIZE%>"
		id="<%=SUB_TEST_SIZE%>" value="<%=dgResultEntryDtSet.size()%>" /> <input
		type="hidden" name="<%=RESULT_ID%>" id="<%=RESULT_ID%>"
		value="<%=dgResultEntryHeader.getId()%>" /> <input
		name="<%=RESULT_DETAIL_ID%>" id="<%=RESULT_DETAIL_ID%>" type="hidden"
		size="5" value="" readonly /> <input type="hidden" name="result"
		id="result<%=resultEntryIndexForMultiple%>" value="TestRowFlag" /> <input
		name="<%=ADDITIONAL_REMARKS%>" type="hidden" value="" /></td>
		<td></td>
	<%-- <td><input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>"
		onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"
		value="testValidate" type="hidden" class="check" /></td>
	<td><input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>"
		onclick="retest(this,<%=resultEntryIndexForMultiple%>);"
		value="testRetest" type="hidden" class="check" /></td>
	<td><input id="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		name="checkIdRecollect<%=resultEntryIndexForMultiple%>"
		onclick="retest(this,<%=resultEntryIndexForMultiple%>);"
		value="testRecollect" type="hidden" class="check" /></td> --%>
	<!-- <td><input type="checkbox" name="sms"
					class="radioCheck" value="yes" id="smsButton" 
					align="right" /></td> -->

</tr>
<%
	for (DgResultEntryDetail dgDetail : dgResultEntryDtSet) {
		//if(dgDetail.getResult()!=null){

		i++;
		resultEntryIndexForMultiple++;
%>

<input name="chargeCodeCodeForPerticularTestForMultiple"
	id="chargeCodeCodeForPerticularTestForMultiple<%=resultEntryIndexForMultiple%>"
	value=<%=dgDetail.getInvestigation().getChargeCode()
						.getChargeCodeCode()%>
	type="hidden" />
<input name="resultType" type="hidden" size="10"
	value="<%=dgDetail.getResultType()%>" />
<!-- -For Heading -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("h")) {
			System.out
					.println("*************** line number 132 for 1st condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
%><jsp:include page="resultEntryForMultipleTestTypePostQC1.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="i" value="<%=i%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
</jsp:include>
<%
	}
%>
<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("s")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 156 fon 2nd condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC2.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->
<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("s")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 189 for 3rd condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC3.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition None  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("s")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 220 for 4th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC4.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>

<%
	}
%>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("m")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 252 for 5th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC5.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>

<%
	}
%>
<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("m")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 272 for 6th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC6.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>


<%
	}
%>
<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("m")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 317 for 7th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC7.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>

<%
	}
%>
<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("t")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {

			System.out
					.println("*************** line number 350 for 8th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC8.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>


<%
	}
%>
<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("t")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 383 for 9th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC9.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>

<%
	}
%>
<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("t")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 416 for 10th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC10.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is Range and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("r")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 446 for 11th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC11.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("r")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 477 for 12th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC12.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
	normalSet = dgDetail.getSubInvestigation().getDgNormalValues();
%>
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("r")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("v")) {
			System.out
					.println("*************** line number 508 for 13th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC13.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>

<%
	}
%>
<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is HEADING and comparison type is NONE -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("s")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("f")) {
			System.out
					.println("*************** line number 536 for 14th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC14.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  end when result type is HEADING and comparison type is NONE  -->
<!--  when result type is HEADING and comparison type is FIXED VALUE -->

<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("s")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("n")) {
			System.out
					.println("*************** line number 567 for 15th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC15.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->

<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("m")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("n")) {
			System.out
					.println("*************** line number 597 for 16th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC16.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("m")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("f")) {
			System.out
					.println("*************** line number 623 for 17th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC17.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

<!--  when result type is TEXT AREA and comparison type is NONE -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("t")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("n")) {
			System.out
					.println("*************** line number 650 for 18th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC18.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!-- end when result type is TEXT AREA and comparison type is NONE -->
<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("t")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("f")) {
			System.out
					.println("*************** line number 676 for 19th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC19.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<!--  when result type is Range and comparison type is NONE -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("r")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("n")) {
			System.out
					.println("*************** line number 702 for 20th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC20.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("r")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("f")) {
			System.out
					.println("*************** line number 727 for 21th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC21.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<!-- when result type is multiple and comparison type is FIXED VALUE  -->
<%
	if (dgDetail.getSubInvestigation().getResultType()
				.equalsIgnoreCase("i")
				&& dgDetail.getSubInvestigation().getComparisonType()
						.equalsIgnoreCase("f")) {
			System.out
					.println("*************** line number 727 for 21th condition");
			request.setAttribute("dgDetailForMultipleTestType",
					dgDetail);
			request.setAttribute(
					"dgResultEntryHeaderForMultipleTestType",
					dgResultEntryHeader);
%>
<jsp:include page="resultEntryForMultipleTestTypePostQC22.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	<jsp:param name="resultEntryIndexForMultiple"
		value="<%=resultEntryIndexForMultiple%>" />
	<jsp:param name="subCounter" value="<%=subCounter%>" />
	<jsp:param name="i" value="<%=i%>" />
</jsp:include>
<%
	}
%>
<%
	subCounter++;
		resultEntryIndex++;
		//}
	}
%>
