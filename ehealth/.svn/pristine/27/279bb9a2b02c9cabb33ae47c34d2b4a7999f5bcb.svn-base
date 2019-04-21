<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System1</title>
<%--<script type="text/javascript" src="/hms/jsp/javascript/functions.js"></script>
 --%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<link href="css/style.css" rel="stylesheet" type="text/css">
</head>


<%Date d=new Date();
String hinNo="&nbsp;";
String deptName="&nbsp;";
String patientName="&nbsp;";
String orderNo="&nbsp;";
String orderDate="&nbsp;";
String patientAge="&nbsp;";
String sex="&nbsp;";
String resultDate="&nbsp;";
String resulttime="";
String subChargeCodeName="&nbsp;";
String mainChargeCodeName="&nbsp;";
String charge="&nbsp;";
String doctorName="&nbsp;";
String entryPersonName="&nbsp;";
String orderByDepartment = "";
String hospitalName="";
String hospitalAddress="";


	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();

	String message = "";
	String clinicalNotes = "";
	String flagForConfidential = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if (map.get("detailsMap1") != null) {
		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
	}
	if (map.get("hospitalAddress") != null) {
	hospitalAddress = (String)map.get("hospitalAddress");
	}
	if (map.get("hospitalName") != null) {
		hospitalName = (String)map.get("hospitalName");
		}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	if (detailsMap1.get("hinNo") != null) {
		hinNo = (String)detailsMap1.get("hinNo");
	}
	if (detailsMap1.get("orderByDepartment") != null) {
		orderByDepartment = (String)detailsMap1.get("orderByDepartment");
	}
	
	if (detailsMap1.get("entryPersonName") != null) {
		entryPersonName = (String)detailsMap1.get("entryPersonName");
	}
	if (detailsMap1.get("patientName") != null) {
		patientName = (String)detailsMap1.get("patientName");
	}
	if (detailsMap1.get("orderNo") != null) {
		orderNo = (String)detailsMap1.get("orderNo");
	}
	if (detailsMap1.get("orderDate") != null) {
		orderDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap1.get("orderDate"));
	}
	if (detailsMap1.get("patientAge") != null) {
		patientAge = (String)detailsMap1.get("patientAge");
	}
	if (detailsMap1.get("sex") != null) {
		sex = (String)detailsMap1.get("sex");
	}
	if (detailsMap1.get("resultDate") != null) {
		resultDate = HMSUtil.convertDateToStringWithoutTime((Date)detailsMap1.get("resultDate"));
	}
	if (detailsMap1.get("resulttime") != null) {
		resulttime =(String)detailsMap1.get("resulttime");
	}
	if (detailsMap1.get("clinicalNote") != null) {
		clinicalNotes = (String)detailsMap1.get("clinicalNote");
	}
	if (detailsMap1.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)detailsMap1.get("subChargeCodeName");
	}
	if (detailsMap1.get("mainChargeCodeName") != null) {
		mainChargeCodeName = (String)detailsMap1.get("mainChargeCodeName");
	}
	if (detailsMap1.get("charge") != null) {
		charge = (String)detailsMap1.get("charge");
	}
	if (detailsMap1.get("doctorName") != null) {
		doctorName = (String)detailsMap1.get("doctorName");
	}
	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");
	}
	if (detailsMap1.get("flagForConfidential") != null) {
		flagForConfidential = (String)detailsMap1.get("flagForConfidential");
	}
	
	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}

	String resultType = "";
	if (map.get("resultType") != null) {
		resultType = (String) map.get("resultType");
	}
 %>
<body>
<%int testCounter = 1; %>

<%int subTestCounter = 0; %>

<%
	
	%>
<div id="mainIn">
<%if(hospitalName!=null && !"".equalsIgnoreCase(hospitalName)){%>
<h2 class="report"><%=hospitalName %></h2>
<div class="clear"></div>
<%} %>
<%if(hospitalAddress!=null && !"".equalsIgnoreCase(hospitalAddress)){%>
<h2 class="reportSubHd"><%=hospitalAddress %></h2>
<div class="clear"></div>
<%} %>
<%if(orderByDepartment!=null && !"".equalsIgnoreCase(orderByDepartment)){%>
<h2 class="reportSubHd"><%=orderByDepartment%></h2>
<div class="clear"></div>
<%} %>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Reg No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Age/ Sex</th>
		<th scope="col">Prescribed By</th>
		<th scope="col">Clinical Notes</th>
		<th scope="col">Sub Department</th>
	</tr>
	<tr>
		<td><%=hinNo %></td>

		<td><%=patientName %></td>
		<td><%=patientAge%>/ <%=sex %></td>
		<td><%=doctorName %></td>
		<td><%=clinicalNotes%></td>
		<td><%=subChargeCodeName%></td>
	</tr>

</table>



</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<%int resultEntryIndex = 0;  int countforcbc=1; %> <% 
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 				
 		if(dgResultEntryHeader.getResultType() != null 
 				&& dgResultEntryHeader.getResultType().equalsIgnoreCase("z")){
 			//while(dgResultEntryHeader.getDgResultEntryDetailSens().iterator().hasNext()){
 				
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSens().iterator().next();
 			if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
 					&& dgDetail.getInvestigation().getConfidential().equalsIgnoreCase("y")){ %>
<div class="clear"></div>
<label class="auto">This Test Result is confidential </label>
<div class="clear"></div>
<%}else{
 			 		 		
 				%> <label class="auto"><%=testCounter%>)</label> <label
	class="auto">Test </label> <label class="valueAuto"><%= dgDetail.getInvestigation().getInvestigationName()%></label>


<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%} %>
<div class="clear"></div>
<%

}else{ 
	if(dgResultEntryHeader.getDgResultEntryDetails()!=null){
		
		if(dgResultEntryHeader.getDgResultEntryDetails().iterator().hasNext()){
 		  DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
 		if(dgDetail!=null && !dgDetail.equals("")){
 		 
 	   %> 
 	  <%if(dgDetail.getInvestigation().getId()!=1081){ %>
 	   <label class="auto"><%=testCounter%>)</label>
 	   
 	     <label
	class="auto">Test Name:</label> <label class="valueAuto"><%= dgDetail.getInvestigation().getInvestigationName()%></label><%
 	   }else %>
 	   <%if(countforcbc==1 && dgDetail.getInvestigation().getId()==1081){ %> <label
	class="auto">Test Name:</label> <label class="valueAuto"><%= dgDetail.getInvestigation().getInvestigationName()%></label><%} %>
<div class="clear"></div>
<%
 	       if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
 	    		   && dgDetail.getInvestigation().getConfidential().equalsIgnoreCase("y") ){ %>
<div class="clear"></div>
<label class="valueAuto"> This Test Result is confidential </label>
<div class="clear"></div>
<%}else{ %> <%
	 	   	  if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){%>

<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
	
	
</jsp:include> <%} %><%
if(dgDetail.getInvestigation().getId()==1081 ){
	//%>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%if(countforcbc==1){ %>
	<tr>
		<th>Test Name</th>
		<th>Result</th>
		<th>UOM</th>
		<th>Normal Range</th>
	</tr>
	<%} %>
	<tr>
		<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
		<td><%=dgDetail.getResult() %></td>
		<td>-</td>
		<td>-</td>
</tr>
</table>
</div>
<% countforcbc++;// 
}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m") && dgDetail.getInvestigation().getId()!=1081 ){
	//	

	 	   	  %> <jsp:include page="viewMultipleTestReportOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%} else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){%>
<label class="value"><%=dgDetail.getResult()%></label> <%} 
	 	   	  } %>
	 	   	  
	 	   	 <%if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("v")){ %>
	 	   	 
	 	   	   <jsp:include page="viewSensitiveResultEntryJSP.jsp"
		flush="true">
			<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
	 	   	 
	 	   	 <%} %>
<div class="clear"></div>
<% }}}}
 		
 		String remarks="";
 		if(dgResultEntryHeader.getInvestigation()!=null){
 			remarks=dgResultEntryHeader.getInvestigation().getRemark();
 		}
 		%>

 			
 			
 			<%
 		resultEntryIndex++;
 		testCounter++;
 	}
 	
 	%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
<div class="clear"></div>
<label class="floatRight"><%=entryPersonName%> </label>
 <label class="auto">Date</label> <label class="value"> <%=resultDate%></label>
 <label class="auto">Time</label> <label class="value"> <%=resulttime%>
</label>


<div class="clear"></div>
<label class="large">&nbsp;</label>
<label class="auto">---------- End of The Report ----------</label></div> 

<div style='page-break-after: always;'></div>
<div class="clear"></div>