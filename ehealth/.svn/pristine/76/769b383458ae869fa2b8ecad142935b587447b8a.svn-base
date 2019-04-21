<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	PatientEpisode patientEpisode = null;

	if (map.get("patientEpisode") != null) {
		patientEpisode = (PatientEpisode) map.get("patientEpisode");
	
%>

<div class="tableForTab"
	style="width: 875px; height: 72px;">
	<div id="divEpisode">

		<table border="0" align="center" cellpadding="0" cellspacing="0"
			id="gridForEpisode">
			<tbody>
				<tr>
					<th scope="col">Department</th>
					<th scope="col">Start Date</th>
					<th scope="col">Description</th>
					<th scope="col">Status</th>
				</tr>
				<tr>
					<td>
					<%if(patientEpisode.getDepartment()!=null){%>
					<%=patientEpisode.getDepartment().getDepartmentName()%>
					<% } else {%>
					<% }%>
					</td>
					<td>
					<%if(patientEpisode.getStartDate()!=null){%>
					<%=patientEpisode.getStartDate()%>
					<% } else {%>
					<% }%>
					</td>
					<td>
					<%if(patientEpisode.getEpisodeDesc()!=null){%>
					<%=patientEpisode.getEpisodeDesc()%>
					<% } else {%>
					<% }%></td>
					<% if(patientEpisode.getEndDate()!=null) {%>
					<td>Closed</td>
					<% } else {%>
					<td>Open</td>
					<% } %>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<% } %>