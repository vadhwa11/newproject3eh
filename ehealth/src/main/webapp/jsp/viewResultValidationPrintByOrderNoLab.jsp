<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
</head>

<%Date d=new Date();
String patientName="&nbsp;";
String orderNo="&nbsp;";
String orderDate="&nbsp;";
String patientAge="&nbsp;";
String sex="&nbsp;";
String resultDate="&nbsp;";
String subChargeCodeName="&nbsp;";
String doctorName="&nbsp;";
String entryPersonName="&nbsp;";

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();

	String clinicalNotes = "";
	String flagForConfidential = "";
	String hospitalName="";
	String hospitalAddress="";

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("detailsMap1") != null) {
		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
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
	if (detailsMap1.get("clinicalNote") != null) {
		clinicalNotes = (String)detailsMap1.get("clinicalNote");

	}

	if (detailsMap1.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)detailsMap1.get("subChargeCodeName");

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
	if(map.get("hospitalAddress")!=null){
		hospitalAddress=(String)map.get("hospitalAddress");
	}
	if(map.get("hospitalName")!=null){
		hospitalName=(String)map.get("hospitalName");
	}

%>
<body>
<%int testCounter = 1; %>

<div id="mainIn">
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere --> <label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalName %></label>
<div class="clear"></div>
<label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalAddress %></label>

<div class="clear"></div>
<label
	style="font: bold 13px arial color :   #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Final
Pathology Result </label> <br>
<div style="padding-top: 10px; margin-top: 0px;"></div>
<div id="dataDiv" class="Block"><label>Test Date :</label> <label
	class="value"> <%=orderDate %> </label> <label>Patient Name :</label> <label
	class="value"> <%=patientName %> </label> <label>Age/Sex :</label> <label
	class="value"> <%=patientAge%>/<%=sex %></label>

<div class="clear"></div>

<label>Prescribed By :</label> <label class="value"> <%=doctorName %></label>

<label>Sub Department :</label> <label class="value"><%=subChargeCodeName%></label>

<div class="clear"></div>

<label>Clinical Notes :</label> <label class="valueAuto"> <%=clinicalNotes%></label>


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<%int resultEntryIndex = 0; %> <%
 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		if(dgResultEntryHeader.getResultType() != null && dgResultEntryHeader.getResultType().equalsIgnoreCase("v")){
 			//while(dgResultEntryHeader.getDgResultEntryDetailSens().iterator().hasNext()){
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSens().iterator().next();
 			if(flagForConfidential.equals("")
 					&& dgDetail.getInvestigation().getConfidential() != null
 					&& dgDetail.getInvestigation().getConfidential().equals("y")){ %>

<label class="value" style="padding-left: 40px; margin-left: 0px;">This
Test Result is confidential </label>
<div class="clear"></div>
<%}else { %>
<div class="clear"></div>
<label
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label>Test22: </label> <label class="value"><%= dgDetail.getInvestigation().getInvestigationName().concat(" silvassa")%></label>

<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}//} %>
<div class="clear"></div>

<%
String remarks="";
if(dgResultEntryHeader.getDgMasInvestigation()!=null){
	remarks=dgResultEntryHeader.getDgMasInvestigation().getRemark();
}
%>
	<label class="value" style="padding-left: 40px; margin-left: 0px;">Remark </label>
	<label><%=remarks %></label>
	<div class="clear"></div>
	
	<%
 		}else{
 		  if(dgResultEntryHeader.getDgResultEntryDetails().size()>0){
 			DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
 	   %> 
 	   <%if(testCounter==1){ %>
 	   <label
	style="padding-left: 20px; padding-right: 0px; margin-right: 0px; width: 16px;"><%=testCounter%>)</label>
<label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 0px; width: auto;">Test
: </label> <label class="value" style="padding-left: 0px; margin-left: 0px;"><%= dgDetail.getInvestigation().getInvestigationName()%></label>
<%}
 	       if(flagForConfidential.equals("")
				   && dgDetail.getInvestigation().getConfidential() != null
 	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="clear"></div>
<label class="value" style="padding-left: 40px; margin-left: 0px;">
This Test Result is confidential </label>
<div class="clear"></div>
<%}else{ %> <%
	if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){ %>
<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m")){%>

<jsp:include page="viewMultipleTestReportOrderNoWise.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include> <%}else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){%>
<label class="value"><%=dgDetail.getResult()%></label> <%}
	 	   	  } %>
<div class="clear"></div>
<%
String remarks="";
	if(dgResultEntryHeader.getDgMasInvestigation()!=null){
		remarks=dgResultEntryHeader.getDgMasInvestigation().getRemark();
	}
	%>
		<label class="value" style="padding-left: 40px; margin-left: 0px;">Remark </label>
		<label><%=remarks %></label>
		<div class="clear"></div>
		
		<%
 		}
}
 		
 	
 		resultEntryIndex++;
 		testCounter++;
 	}

 	%>

<div class="clear"></div>


<div class="clear"></div>


<label class="auto">Date</label> <label class="value"> <%=resultDate%>
</label>
<div class="floatRight"><label><%=entryPersonName%> </label></div>
<div class="clear"></div>

</div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		

<label
	style="font: bold 13px arial color :   #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">----------
End Of The Report ----------</label>

<div style='page-break-after: always;'></div>
</div>
</body>
</html>
