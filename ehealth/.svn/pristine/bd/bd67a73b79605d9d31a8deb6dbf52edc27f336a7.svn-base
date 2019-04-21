<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}

	List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>();
	List<Patient> patientList = new ArrayList<Patient>();
	if (map.get("patientEpisodeList") != null) {
		patientEpisodeList = (List<PatientEpisode>) map
				.get("patientEpisodeList");
	}//changed by govind 16-11-2016
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map
				.get("patientList");
	}
	System.out.println("patientEpisodeList jsp"+patientEpisodeList.size());
	System.out.println("patientList jsp"+patientList.size());
%>
<%if(patientList.size()>0){%>
<%if(patientEpisodeList.size()>0){%>
<label>Episodes </label>
<select name="episodeId" id="episodeId" size="1" >
	<option value="0">Select</option>
	<%
		for (PatientEpisode patientEpisode : patientEpisodeList) {
	%>
	<option value="<%=patientEpisode.getId()%>"><%=patientEpisode.getEpisodeNumber()%></option>
	<%
		}
	%>
</select>
<%}%>
<div class="clear"></div>
<input type="button" name="Generate Report" value="Generate Report" class="buttonBig" onClick="if(this.value!=''){submitForm('voucherReport','enquiry?method=printPatientEpfReport&flag=ehr');}" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}else{%>
<h4>No Data Found</h4>
<div class="clear"></div>
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%}%>