<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<DgResultEntryHeader> dgResultEntryHeaderList = new ArrayList<DgResultEntryHeader>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if (map.get("dgResultEntryHeader") != null) {
		dgResultEntryHeaderList = (List<DgResultEntryHeader>) map
				.get("dgResultEntryHeader");
	}
%>
<div id="testDiv">
	<%
		if (dgResultEntryHeaderList.size() > 0) {
	%>
	<table cellspacing="0" cellpadding="0" border="0"
		style="margin-top: 16px;">
		<thead>
			<tr>
				<th width="7%">Test Name</th>
				<th width="15%">UOM</th>
				<th width="10%">Test Type</th>
				<th width="20%">Status</th>
			</tr>
			<tr></tr>
		</thead>
		<tbody id="searchresulttable2">
			<%
				for (DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderList) {
						Set<DgResultEntryDetail> detail = (Set<DgResultEntryDetail>) dgResultEntryHeader
								.getDgResultEntryDetails();
						for (DgResultEntryDetail dgResultEntryDetail : detail) {
			%>
			<tr class="odd">
				<%
					String status = "";
								boolean flag = false;
								String testName = "";
								if ("V".equalsIgnoreCase(dgResultEntryDetail
										.getValidated())) {
									status = "Result Validated";
								} else {
									status = "Result Entered";
								}
								String testType = "";
								String val = dgResultEntryDetail.getInvestigation()
										.getInvestigationType();
								if ("m".equalsIgnoreCase(val)) {
									testType = "Multiple Parameter";
									flag = true;
								} else if ("t".equalsIgnoreCase(val)) {
									testType = "Template";
								} else if ("v".equalsIgnoreCase(val)) {
									testType = "Sensitive";
								} else {
									testType = "Single Parameter";
								}
								if (flag) {
									testName=dgResultEntryDetail.getSubInvestigation()
											.getSubInvestigationName();
								} else {
									testName=dgResultEntryDetail.getChargeCode()
									.getChargeCodeName();
								}
				%>
				<td><%=testName%></td>
				<%
					String unit = "";
								if (dgResultEntryDetail.getUom() != null) {
									unit = dgResultEntryDetail.getUom().getUomName();
								}
				%>
				<td><%=unit%></td>
				<td><%=testType%></td>
				<td><%=status%></td>
			</tr>
			<%
				}
					}
			%>
		</tbody>
	</table>
	<%
		} else {
	%>
	<h4>Record Not Found</h4>
	<%
		}
	%>


</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
