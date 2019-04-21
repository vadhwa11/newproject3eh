<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%><html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<%--<script type="text/javascript" src="/hms/jsp/javascript/functions.js"></script> --%>

</head>


<%Date d=new Date();
String hinNo="";
String deptName="";
String patientName="";
String orderNo="";
String orderDate="";
String patientAge="";
String sex="";
String resultDate="";
String doctorName="";
String entryPersonName="";
String verifiedPersonName="";
String orderByDepartment = "";
int departmentType =0;

	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
	List<DgResultEntryDetail>dgResultEntryDetailList=new ArrayList<DgResultEntryDetail>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	List<String> subChargeCodeGroup = new ArrayList<String>();

	String message = "";
	String clinicalNotes = "";
	String url = "";
	String verifiedPersonNameDesignation = "";
	String entryPersonNameDesignation = "";
	String entryPersonNameRank = "";
	String verifiedPersonNameRank = "";
	String flagForConfidential = "";

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("detailsMap1") != null) {

		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");

	}
	String hospitalName="";
	if (map.get("hospitalName") != null) {

		hospitalName = (String)map.get("hospitalName");

	}
	String hospitalAddress="";
	if (map.get("hospitalAddress") != null) {

		hospitalAddress = (String)map.get("hospitalAddress");

	}

	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}


	if (detailsMap1.get("verifiedPersonName") != null) {
		verifiedPersonName = (String)detailsMap1.get("verifiedPersonName");

	}
	if (detailsMap1.get("orderByDepartment") != null) {
		orderByDepartment = (String)detailsMap1.get("orderByDepartment");

	}
	
	if (detailsMap1.get("entryPersonName") != null) {
		entryPersonName = (String)detailsMap1.get("entryPersonName");

	}
	if (detailsMap1.get("subChargeCodeGroup") != null){
		subChargeCodeGroup = (List)detailsMap1.get("subChargeCodeGroup");
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
	if (detailsMap1.get("entryPersonNameDesignation") != null
			&& !detailsMap1.get("entryPersonNameDesignation").equals("")) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");

	}
	if (detailsMap1.get("entryPersonNameRank") != null
			&& !detailsMap1.get("entryPersonNameRank").equals("")) {
		entryPersonNameRank = (String)detailsMap1.get("entryPersonNameRank");

	}

	if (detailsMap1.get("verifiedPersonNameDesignation") != null) {
		verifiedPersonNameDesignation = (String)detailsMap1.get("verifiedPersonNameDesignation");

	}
	if (detailsMap1.get("verifiedPersonNameRank") != null) {
		verifiedPersonNameRank = (String)detailsMap1.get("verifiedPersonNameRank");

	}
	if (detailsMap1.get("hinNo") != null) {
		hinNo = (String)detailsMap1.get("hinNo");

	}
	if (detailsMap1.get("doctorName") != null) {
		doctorName = (String)detailsMap1.get("doctorName");

	}

	if (detailsMap1.get("dgResultEntryDetailList") != null) {
		dgResultEntryDetailList = (List)detailsMap1.get("dgResultEntryDetailList");
	}
	//
	if (detailsMap1.get("flagForConfidential") != null) {
		flagForConfidential = (String)detailsMap1.get("flagForConfidential");

	}

	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}
	if (map.get("url") != null) {
		url = "" + map.get("url");
	}

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>
<body>
<%int testCounter = 1; %>
<%int noOfSubTest = subChargeCodeGroup.size(); %>
<%int subTestCounter = 0; %>
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere -->
<label
	style="font: bold 13px arial color :       #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"
	class="value">
	<%=hospitalName %></label>
	<label
	style="font: bold 13px arial color :       #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"
	class="value">
	<%=hospitalAddress %></label>
<div class="clear"></div>
<%if(!(deptName).equals("Laboratory (35)")){ %>
<label
	style="font: bold 13px arial color :       #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Order
Status Report </label>
<%}else{ %>
<label
	style="font: bold 13px arial color :       #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Pathology
Result </label>
<%} %>

 <%for(String subChargeName : subChargeCodeGroup){ 

	%>

<div style="padding-top: 20px; margin-top: 5px;"></div>
<div id="dataDiv">
<%for(DgResultEntryDetail dtl:dgResultEntryDetailList){ 


%>

<%} %>
<div class="Block"><label>Dept/Ward</label> <label class="value">
<%=orderByDepartment%></label>
<label>Test Date</label>
<label class="value"> <%=orderDate %></label>
 <label>Patient Name</label>
<label class="value"> <%=patientName %></label>
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<label class="value"><%= hinNo %></label>

<label>Age/Sex</label> <label class="value"> <%=patientAge%>/<%=sex %></label>

<label>Prescribed By</label> <label class="value"> <%=doctorName %></label>
<div class="clear"></div>

<label>Clinical Notes </label> <label class="value"><%=clinicalNotes%></label>

<label>Sub Department</label> <label class="value"><%=subChargeName%></label>

<div class="clear"></div>
</div>
<!-- Loop for Printing DgResultEntryHeader For Lab  Only For Multiple-->
<%

int resultEntryIndex = 0; %> <%
int counterForMultiple=0;

 	for(DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderByOrderNo){
 		if(dgResultEntryHeader.getResultType() != null
 				&& dgResultEntryHeader.getResultType().equalsIgnoreCase("v")){
 			if(dgResultEntryHeader.getSubChargecode().getSubChargecodeName().equalsIgnoreCase(subChargeName)){
 			//DgResultEntryDetailSen dgDetail = dgResultEntryHeader.getDgResultEntryDetailSens().iterator().next();
			DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
			if(dgDetail.getResult()!=null && ! dgDetail.getResult().equalsIgnoreCase("null") && ! dgDetail.getResult().equals("") || dgDetail.getFixed()!=null){
 			if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
  	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>

<div class="clear"></div>
<label class="value">This Test Result is confidential </label>
<div class="clear"></div>
<%}else{ %> <label><%=testCounter%>)</label> <label>Test</label> <label
	class="value"><%= dgDetail.getInvestigation().getInvestigationName()%></label>

<jsp:include page="viewReportForSensitiveTestTypeOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="clear"></div>
<%
String remark="";
if(dgDetail.getInvestigation().getRemark()!=null){
	remark=dgDetail.getInvestigation().getRemark();
}
%>
<label>Remark</label> <label
	class="value"><%= remark%></label>
<div class="clear"></div>
<%}
 			 testCounter++;
 			}
			
 			}
 		%> <%}else{
 			if(dgResultEntryHeader.getDgResultEntryDetails() != null && dgResultEntryHeader.getDgResultEntryDetails().size() != 0){
 				//for(DgResultEntryDetail dgDetail :dgResultEntryHeader.getDgResultEntryDetails()){
 					
 						
	DgResultEntryDetail dgDetail = dgResultEntryHeader.getDgResultEntryDetails().iterator().next();
	//if((dgDetail.getResult()!=null && !dgDetail.getResult().equalsIgnoreCase("null") && !dgDetail.getResult().equals("")) || dgDetail.getFixed()!=null){
		if(dgResultEntryHeader.getSubChargecode().getSubChargecodeName().equalsIgnoreCase(subChargeName)){
 	   %> <label class="auto"><%=testCounter%>)</label> <label
	class="auto">Test</label> <label class="value"><%= dgDetail.getInvestigation().getInvestigationName()%></label>
<%
	       if(flagForConfidential.equals("") && dgDetail.getInvestigation().getConfidential() != null
	    		   && dgDetail.getInvestigation().getConfidential().equals("y") ){ %>
<div class="clear"></div>

<label class="value"> This Test Result is confidential </label>

<div class="clear"></div>
<%}else{ %> <%if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){ %>
<div class="clear"></div>
<jsp:include page="viewSingleResultReportLabOrderNoWise.jsp"
	flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="clear"></div>
<%
String remark="";
if(dgDetail.getInvestigation().getRemark()!=null){
	remark=dgDetail.getInvestigation().getRemark();
}
%>
<label>Remark</label> <label
	class="value"><%= remark%></label>
	<div class="clear"></div>
<%}

else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("m")){
%>
<jsp:include page="viewMultipleTestReportOrderNoWise.jsp" flush="true">
	<jsp:param name="resultEntryIndex" value="<%=resultEntryIndex%>" />
</jsp:include>
<div class="clear"></div>
<%
String remark="";
if(dgDetail.getInvestigation().getRemark()!=null){
	remark=dgDetail.getInvestigation().getRemark();
}
%>
<label>Remark</label> <label
	class="value"><%= remark%></label>
	<div class="clear"></div>
<%}
else if(dgDetail.getInvestigation().getInvestigationType().equalsIgnoreCase("t")){
	
	%>
<label>Result</label>
<div class="clear"></div>
<label>&nbsp;</label>
<%
	String s = "";
	if(dgDetail.getResult() != null){
		s = dgDetail.getResult();

	/* String[] str = dgDetail.getResultForDischargeSummary().split(" ");
	for(int i=0;i<str.length;i++){
		if(i>4){
			s = s.concat(" ").concat(str[i]);
		}
	}*/
	}else{
		s = dgDetail.getResult();
	}

%>

 <label class="value"><%=s%></label>
<div class="clear"></div>
<label>Remarks</label> <% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<label class="value"><%=dgDetail.getRemarks()%></label> <% } else { %> <label
	class="value">-</label> <% } %>
<div class="clear"></div>
<%}
	       }
 	  		testCounter++;
 		  }
			//}
 	//	}
 			}
 			}
 		resultEntryIndex++;

 	}

 	%>
<div class="Block"><label class="auto">Reported Date :</label> <label
	class="value"> <%=resultDate%> </label>
<div class="floatRight"> <label class="auto">Reported By :</label><label><%=entryPersonName%> </label></div>
<div class="clear"></div>


<div class="clear"></div>
<!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
</div>
<% subTestCounter++; %> <% if(subTestCounter == noOfSubTest){ %> <label
	style="font: bold 13px arial color :     #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">----------End
Of The Report ----------</label> <% } %>
<div style='page-break-after: always;'></div>
<%
 testCounter = 1;
} 
%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</body>
</html>