
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="java.util.*"%>
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
	
	//added by govind 
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> fixedListMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (request.getAttribute("fixedListMap") != null) {
		fixedListMap = (Map) request.getAttribute("fixedListMap");
	}
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	
	if (request.getAttribute("fixedValListAtr") != null) {
		fixedValList = (List<DgFixedValue>) request
				.getAttribute("fixedValListAtr");
		System.out.println("final jsp fixedValList "+fixedValList.size());
	}
	Integer sampleId=0;
	sampleId=dgDetail.getId();	
	String result=dgDetail.getResult();
%>


<tr>
	<%if (dgDetail.getSubInvestigation() != null) {%>
	<td><%=resultEntryIndex%>.<%=dgDetail.getSubInvestigation().getOrderNo()%></td>
	<%} %>
	<td>
		<%
			if (dgDetail.getSubInvestigation() != null) {
		%> <input name="<%=SUBTEST_ID%>" type="hidden" size="5"
		value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
		name="<%=SUBTEST_NAME%>" id="<%=SUBTEST_NAME%><%=i%>" type="text"
		value="<%=dgDetail.getSubInvestigation()
						.getSubInvestigationName()%>"
		class="readOnly" /> <%
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
		size="5" value="<%=dgDetail.getSample().getId()%>" readonly /> <label><%=dgDetail.getSample().getSampleDescription()%>
	</label> <%
 	} else {
 %><input name="<%=SAMPLE_ID%>" type="hidden" value="" readonly /> <%
 	}
 %>
	</td>

	<td>
		<%
			if (dgDetail.getFixed() != null) {				
		%> 
	<%-- 
		<input name="<%=FIXED_ID%>" id="<%=FIXED_ID%>"
		value="<%=dgDetail.getFixed().getFixedValue()%>" />--%>	
		<input name="collectionId<%=resultEntryIndexForMultiple%>" value="<%=sampleId %>" type="hidden">	
		 <input
		type="text" name="<%=RESULT%>" tabindex="1"
		id="result1<%=resultEntryIndexForMultiple%>" value="<%=result%>" />
		
		<!-- added by govind 24-10-2016-->
 <%--<select id="<%=FIXED_ID%><%=resultEntryIndexForMultiple%>"
		name="<%=FIXED_ID%>" tabindex="1" onchange="setResultValue('<%=FIXED_ID%><%=resultEntryIndexForMultiple%>','<%=resultEntryIndexForMultiple%>');" disabled>
			<%
				if (fixedValList != null) {
						for (DgFixedValue dgFixedValue : fixedValList) {
							if (dgFixedValue.getId()==dgDetail.getFixed().getId()) {
			%>
			<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
			<%
							}}%>
							
						<%	for (DgFixedValue dgFixedValue : fixedValList) {							
			%>
			<option value="<%=dgFixedValue.getId()%>"><%=dgFixedValue.getFixedValue()%></option>
			<%
							}%>
					<%							
					}
			%>
	</select> --%>
	<!--added by govind 24-10-2016 end -->
		 <%
 	} else {
 %> 
 <input name="collectionId<%=resultEntryIndexForMultiple%>" value="<%=sampleId %>" type="hidden">
<input name="<%=FIXED_ID%>" id="<%=FIXED_ID%>" value="" type="hidden"/> <input
		type="text" name="<%=RESULT%>" tabindex="1"
		id="<%=RESULT%><%=resultEntryIndexForMultiple%>" value="<%=result %>" readonly="readonly"/> <%
 	}
 %>
	</td>
	<%
			if (RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(dgDetail.getResultEntry().getHin()
					.getHinNo())) {
		%>
		<td><label><%=dgDetail.getQcFixed().getFixedValue()%></label></td>
		<%
			}
		%>
	<td>
		<%
			if (dgDetail.getUom() != null) {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>"
		id="<%=UNIT_OF_MEASUREMENT_ID%>" type="hidden" size="5"
		value="<%=dgDetail.getUom().getId()%>" readonly /> <label><%=dgDetail.getUom().getUomName()%></label>
		<%
			} else {
		%> <input name="<%=UNIT_OF_MEASUREMENT_ID%>" type="hidden" size="2"
		value="" readonly /><label>-</label> <%
 	}
 %>
	</td>
	<td>
		<%
			if (dgDetail.getFixedNormalValue() != null) {
		%> <label><%=dgDetail.getFixedNormalValue()%></label> <%
 	} else {
 %> <label>-</label> <%
 	}
 %>
	</td>

	<td>
		<%
			if (dgDetail.getResultDetailStatus().equalsIgnoreCase("A")) {
		%> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkId<%=resultEntryIndexForMultiple%>"
		name="checkId<%=resultEntryIndexForMultiple%>" onclick="accepted(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

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
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>
		<input id="checkIdRetest<%=resultEntryIndexForMultiple%>"
		name="checkIdRetest<%=resultEntryIndexForMultiple%>" onclick="retest(this,<%=resultEntryIndexForMultiple%>);"  type="checkbox"
		class="check" /> <%
 	} else {
 %> <label name="ddd" type="text"
		style="margin: 0px; 0 px; 0 px; 0 px; padding: 0px; 0 px; 0 px; 0 px; width: 8px; color: red;"></label>

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
<%
	
%>
<script>
function setResultValue(id,inc){
	
	var skillsSelect = document.getElementById(id);
	var selectedText = skillsSelect.options[skillsSelect.selectedIndex].text;
	
	document.getElementById("result1"+inc).value=selectedText;
}
</script>
<!-- govind end -->
