<%@page import="jkt.hms.masters.business.IdspHospitalReportForml"%>
<%@page import="jkt.hms.masters.business.IdspHospitalReport"%>
<%@page import="jkt.hms.masters.business.DiseasesIcdMapping"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<IdspHospitalReportForml> idspHospitalReportList = new ArrayList<IdspHospitalReportForml>();	 // list from idsp_hosiptal_report_formL table
	List<IdspHospitalReportForml> idspHospitalReportByCountList = new ArrayList<IdspHospitalReportForml>();	 // list from dg_result_details_entry table
	
	if (map.get("idspHospitalReportList") != null) 
		idspHospitalReportList = (List<IdspHospitalReportForml>) map.get("idspHospitalReportList");
	
	
	if (map.get("idspHospitalReportByCountList") != null) 
		idspHospitalReportByCountList = (List<IdspHospitalReportForml>) map.get("idspHospitalReportByCountList");
	
	
	int inc=0;
%>

<% 
if(idspHospitalReportByCountList!=null && idspHospitalReportByCountList.size()>0) {
for( IdspHospitalReportForml idspHospitalReport : idspHospitalReportByCountList)  {	
inc++; 
%>
<tr>
	<td><%=idspHospitalReport.getDiseasesName()%></td>
	<td><input type="text"
		value="<%=idspHospitalReport.getNoOfSamplesTested()%>" id="sampleTestedCount<%=inc %>"
		size="70" name="sampleTestedCount<%=inc %>" />
	<input type="hidden"
		value="<%=idspHospitalReport.getDiseasesName()%>" id="diseasesName<%=inc %>"
		name="diseasesName<%=inc %>" />	
	</td>

</tr>
<%  } 
} else {
	for( IdspHospitalReportForml idspHospitalReport : idspHospitalReportList)  {
		inc++; 
%>
<tr>
	<td><%=idspHospitalReport.getDiseasesName()%></td>
	<td><input type="text"
		value="<%=idspHospitalReport.getNoOfSamplesTested()%>" id="sampleTestedCount<%=inc %>"
		size="70" name="sampleTestedCount<%=inc %>" /></td>

</tr>
<% } 
} %>
<input type="hidden" value="<%=inc%>" name="itemCount" id="itemCount" />


