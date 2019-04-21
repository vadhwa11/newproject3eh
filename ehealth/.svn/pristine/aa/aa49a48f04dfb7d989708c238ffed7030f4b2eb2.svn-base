<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * @rework By Mukesh Narayan SIngh 20 July 2010
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
	<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientVisitMap = new HashMap<String, Object>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	List<Visit> visitList = new ArrayList<Visit>();
	List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientVisitMap") != null){
		patientVisitMap = (Map<String,Object>)map.get("patientVisitMap");
	}
	if(patientVisitMap.get("visitList") != null){
		visitList = (List<Visit>)patientVisitMap.get("visitList");
	}
	if(visitList.size() > 0)
	{
		Visit visit = visitList.get(0);
		Patient patient = (Patient)visit.getHin();
		String pName="";
		pName=patient.getPFirstName();
		if(patient.getPMiddleName()!=null){
		pName+=" "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!=null){
		pName+=" "+patient.getPLastName();
		}
		if(!visit.getHin().getPatientStatus().equals("Expired"))
		{
		if(map.get("complaintList") != null){
		complaintList = (List<MasComplaint>)map.get("complaintList");
		}
		if(map.get("caseTypeList") != null){
		caseTypeList = (List<MasCaseType>)map.get("caseTypeList");
		}
		if(map.get("diagnosisList") != null){
		diagnosisList = (List<MasDiagnosisConclusion>)map.get("diagnosisList");
		}
		if(map.get("disposalList") != null){
		disposalList = (List<MasDisposal>)map.get("disposalList");
		}
%>

<form name="updateVisit" method="post">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="tileBg">
<h2>Update Patient Visit</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<label class="value"><%=patient.getHinNo() %></label>
<label>Patient Name</label> 
<label class="value"><%=pName%></label>
<label>Sex</label> 
<label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%
				String maritalStatus = "";
				if(patient.getMaritalStatus() != null){
				maritalStatus = patient.getMaritalStatus().getMaritalStatusName();
				%>
<div class="clear"></div>
<label>Marital Status</label> 
<label class="value"><%=maritalStatus%></label>
<%} %> 
<label>Age</label> 
<label class="value"><%=visit.getAge()%></label>
<%
		String religion = "";
		if(patient.getReligion() != null){
		religion = patient.getReligion().getReligionName();
		%> 
<label>Religion</label> 
<label class="value"><%= religion%></label>
<%} %> 
<%
			if(patient.getDistrict() != null){
			%> 
<label>District</label> 
<label class="value"><%=patient.getDistrict().getDistrictName() %></label>
<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Visit Details</h4>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> 
<label class="value"><%=visit.getVisitNo()%><span></span></label>
<label>Visit Date</label> 
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate()) %></label>
<label>Visit Time </label> <label class="value"><%=visit.getVisitTime() %></label>
<%--
<div class="clear"></div>
<label >Hospital Staff</label>
	<%if(visit.getHospitalStaff()!=null){
		if(visit.getHospitalStaff().equals("y")){
	%>
<label class="value"><input type="checkbox" name="<%=HOSPITAL_STAFF %>" value="y" checked="checked" class="radioCheck" /></label>
<%}}else{ %>
	<label class="value"><input type="checkbox" name="<%=HOSPITAL_STAFF %>" value="y" class="radioCheck"  /></label>

	<%} %>
--%> 
<label>Complaint</label> 
<select name="<%=COMPLAINT_ID%>" validate="Complaint,metachar,no">
	<option value="0">Select</option>
	<%
			 	for(MasComplaint masComplaint : complaintList){
			 	%>
	<option value="<%=masComplaint.getId() %>"><%=masComplaint.getComplaintName() %></option>
	<%		}%>
</select> 
<script type="text/javascript">
          	<%  if(visit.getComplaint()  != null){
			 			int complaintId = visit.getComplaint().getId() ;
					%>
					document.updateVisit.<%=COMPLAINT_ID%>.value = '<%=complaintId %>';
               <%
			 		}%>
           </script> 
<label>Department</label> 
<label class="value"><%=visit.getDepartment().getDepartmentName() %></label>
<label>Consulting Doctor</label> <%
	String doctorFName = "";
	String doctorLName = "";
	if(visit.getDoctor() != null){
	if(visit.getDoctor().getFirstName() != null){
	doctorFName = visit.getDoctor().getFirstName();
	}
	if(visit.getDoctor().getLastName() != null){
	doctorLName = visit.getDoctor().getLastName();
	}
	}
	%> 
	<label class="value"><%=doctorFName %> <%=doctorLName%></label>
	<div class="clear"></div>
	<label><span> *</span>Case Type</label> 
	<select name="<%=CASE_TYPE_ID %>"	validate="Case Type,metachar,yes">
		<option value="0">Select</option>
	<%
 			for(MasCaseType masCaseType : caseTypeList){
				%>
	<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
	<%
 		}%>
</select> 
<script type="text/javascript">
          	<%  if(visit.getCaseType()  != null){
				int caseTypeId = visit.getCaseType().getId() ;
				%>
				document.updateVisit.<%=CASE_TYPE_ID%>.value = '<%=caseTypeId %>';
               <%}%>
           </script> 
           <label> Diagnosis</label> 
           <select name="<%=DIAGNOSIS_ID %>" validate="Diagnosis,metachar,no">
           	<option value="0">Select</option>
	<%
	 			for(MasDiagnosisConclusion masDiagnosisConclusion : diagnosisList){
	 		%>
	<option value="<%=masDiagnosisConclusion.getId() %>"><%=masDiagnosisConclusion.getDiagnosisConclusionName() %></option>
	<%}%>
</select> 
<script type="text/javascript">
          	<%  if(visit.getDiagnosis()  != null){
			 			int diagnosisId = visit.getDiagnosis().getId() ;
					%>
					document.updateVisit.<%=DIAGNOSIS_ID%>.value = '<%=diagnosisId %>';
               <%
			 		}%>
           </script> <%--
		<label> Disposal</label>
		<select name="<%=DISPOSAL_ID %>" validate="Disposal,string,no" >
			<option value="0">Select</option>
		<%
	 		for(MasDisposal masDisposal : disposalList){
	 		%>
	 		<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName() %></option>
	 		<%
	 			}%>
			</select>
		<script type="text/javascript">
          	<%  if(visit.getDisposal()  != null){
			 			int disposalId = visit.getDisposal().getId() ;
					%>
					document.updateVisit.<%=DISPOSAL_ID%>.value = '<%=disposalId %>';
               <%
			 		}%>
           </script>
		--%> 
<label><span>*</span> Token No.</label>
<label class="value"><%=visit.getTokenNo() %></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>"/>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="Submit" value="Update" class="button" onClick="submitForm('updateVisit','/hms/hms/registration?method=updateVisitInformation');" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<% }
}else{%>
<h4>No Record Found !!</h4>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div id="statusMessage">
<h4></h4>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date:</label> 
<label class="value"><%=currentDate%></label>
<label>Changed Time:</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

