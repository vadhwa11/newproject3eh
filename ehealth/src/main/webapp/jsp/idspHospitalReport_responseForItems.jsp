<%@page import="jkt.hms.masters.business.IdspHospitalReport"%>
<%@page import="jkt.hms.masters.business.DiseasesIcdMapping"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<IdspHospitalReport> idspHospitalReportList = new ArrayList<IdspHospitalReport>();	 // list from idsp_hosiptal_report table
	List<IdspHospitalReport> idspHospitalReportByCountList = new ArrayList<IdspHospitalReport>();	 // list from discharge_icd_code table
	
	if (map.get("idspHospitalReportList") != null) 
		idspHospitalReportList = (List<IdspHospitalReport>) map.get("idspHospitalReportList");
	
	
	if (map.get("idspHospitalReportByCountList") != null) 
		idspHospitalReportByCountList = (List<IdspHospitalReport>) map.get("idspHospitalReportByCountList");
	
	
	int inc=0;
%>

<% 
if(idspHospitalReportByCountList!=null && idspHospitalReportByCountList.size()>0) {
for( IdspHospitalReport idspHospitalReport : idspHospitalReportByCountList)  {	
inc++; 
%>
<tr>
	<td><%=idspHospitalReport.getDiseasesName()%></td>
	<td><input type="text"
		value="<%=idspHospitalReport.getNoOfCases()%>" id="caseCount<%=inc %>"
		size="70" name="caseCount<%=inc %>" />
	<input type="hidden"
		value="<%=idspHospitalReport.getDiseasesName()%>" id="diseasesName<%=inc %>"
		name="diseasesName<%=inc %>" />	
	</td>

</tr>
<%  } 
} else {
	for( IdspHospitalReport idspHospitalReport : idspHospitalReportList)  {
		inc++; 
%>
<tr>
	<td><%=idspHospitalReport.getDiseasesName()%></td>
	<td><input type="text"
		value="<%=idspHospitalReport.getNoOfCases()%>" id="caseCount<%=inc %>"
		size="70" name="caseCount<%=inc %>" /></td>

</tr>
<% } 
} %>
<input type="hidden" value="<%=inc%>" name="itemCount" id="itemCount" />


