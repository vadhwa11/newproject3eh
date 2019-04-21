<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<%--<script type="text/javascript" src="/hms/jsp/javascript/functions.js"></script> --%>

</head>


<%
Date d=new Date();
String hinNo="&nbsp;";
String deptName="&nbsp;";
String patientName="&nbsp;";
String orderNo="&nbsp;";
String orderDate="&nbsp;";
String relationName="&nbsp;";
String patientAge="&nbsp;";
String sex="&nbsp;";
String resultDate="&nbsp;";
String subChargeCodeName="&nbsp;";
String mainChargeCodeName="&nbsp;";
String charge="&nbsp;";
String doctorName="&nbsp;";
String entryPersonName="&nbsp;";
String verifiedPersonName="&nbsp;";
String orderByDepartment = "&nbsp;";
String radioId = "&nbsp;";
String verifiedPersonNameDesignation = "&nbsp;";
String entryPersonNameDesignation = "&nbsp;";
String entryPersonNameRank = "&nbsp;";
String verifiedPersonNameRank = "&nbsp;";

	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	List<String> subChargeCodeGroup = new ArrayList<String>();
	String clinicalNotes = "";
	String message = "";
	String url = "";
	int deptId = 0;
	if (request.getAttribute("map") != null) {
		detailsMap1 = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	if(session.getAttribute("deptId")!=null){
		deptId =(Integer)session.getAttribute("deptId");
	}

	if (detailsMap1.get("hinNo") != null) {
		hinNo = (String)detailsMap1.get("hinNo");
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
	String adNo="";
	if (detailsMap1.get("adNo") != null) {
		adNo = (String)detailsMap1.get("adNo");

	}
	if (detailsMap1.get("radioId") != null) {
		radioId = (String)detailsMap1.get("radioId");

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

	if (detailsMap1.get("subChargeCodeName") != null) {
		subChargeCodeName = (String)detailsMap1.get("subChargeCodeName");

	}
	if (detailsMap1.get("clinicalNotes") != null) {
		clinicalNotes = (String)detailsMap1.get("clinicalNotes");

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
	
	if (detailsMap1.get("entryPersonNameRank") != null) {
		entryPersonNameRank = (String)detailsMap1.get("entryPersonNameRank");

	}

	
	if (detailsMap1.get("verifiedPersonNameRank") != null) {
		verifiedPersonNameRank = (String)detailsMap1.get("verifiedPersonNameRank");

	}

	if (detailsMap1.get("entryPersonNameDesignation") != null) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");

	}
	if (detailsMap1.get("verifiedPersonNameDesignation") != null) {
		verifiedPersonNameDesignation = (String)detailsMap1.get("verifiedPersonNameDesignation");

	}
	
	
	
	if (detailsMap1.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + detailsMap1.get("messageTOBeVisibleToTheUser");
	}
	if (detailsMap1.get("url") != null) {
		url = "" + detailsMap1.get("url");
	}
	if (detailsMap1.get("dgResultdetailList") != null) {
		dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
				.get("dgResultdetailList");
	}

%>
<body>
<%int testCounter = 1; %>
<%int noOfSubTest = subChargeCodeGroup.size(); %>
<%int subTestCounter = 0; %>
<%for(String subChargeName : subChargeCodeGroup){
	%>
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere -->

<div class="clear"></div>
<label
	style="font: bold 13px arial color :       #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;">General Hospital Trivandrum</label>
	<label
	style="font: bold 13px arial color :       #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;">THIRUVANANTHAPURAM</label>
<div class="clear"></div>
<label
	style="font: bold 13px arial color :       #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 0px">Radiodiagnosis
Report </label>
<div class="clear"></div>
<div style="padding-top: 0px; margin-top: 0px;"></div>
<div id="dataDiv">
<div class="Block">

 <label>UHID</label> <label class="value"> <%=adNo %></label>

 <label>Patient Name</label> <label class="value"> <%=patientName %></label>


<label>Age/Sex</label> <label class="value"><%=patientAge%>/<%=sex %></label>
<div class="clear"></div>
<label>Prescribed By</label> <label class="value"> <%=doctorName %></label>


<label>Clinical Notes </label> <label class="value"><%=clinicalNotes%></label>
<div class="clear"></div>

<label>Sub Department </label> <label class="value"><%=subChargeName%></label>

</div>


<%for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){
	if(dgResultEntryDetail.getInvestigation().getSubChargecode().getSubChargecodeName()
			.equalsIgnoreCase(subChargeName)){

	%> <!-- line should  be here --> 
<label><%=testCounter%>)Test </label>
 <label class="value"> <%=dgResultEntryDetail.getInvestigation().getInvestigationName() %></label> 
 <% if(deptId == 46 ){ %> 
 <label>Radio Id</label> <% }else{ %> 
 
 <label>DiagNo</label> <% } %> 
 
 <label class="value"><%=radioId %> </label> 
 <%
	String sampleCollDateString = "";
	DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail.getSampleCollectionDetails();
	Date sampleCollectionDate =  dgSampleCollectionDetails.getSampleCollDatetime();
	sampleCollDateString = HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);

%> <label>Test Date</label> <label class="value"> <%=sampleCollDateString %></label>
<!-- line should  behere --> <% 
   	String confidential = "";
		if(dgResultEntryDetail.getInvestigation().getConfidential() != null 
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equals("")
				&& !dgResultEntryDetail.getInvestigation().getConfidential().equalsIgnoreCase("n")){
			confidential = "y";
		}else{
			confidential = "n";
		}

%> 
<div class="clear"></div>
<label>Result</label>
<%if(confidential.equalsIgnoreCase("n")){ %>

<label class="auto"><%=dgResultEntryDetail.getResult()%></label> <%}else{ %>
<label class="auto"> This test's result is confidential</label> <%} %>
<div class="clear"></div>

<%	testCounter++;
 	} 
}
%> <!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
<div class="clear"></div>
<div class="Block"><label>Date</label> <label
	class="value"> <%=resultDate%> </label>
<label>Doctor</label><label class="value"><%=entryPersonName%> </label>
<div class="clear"></div>
</div>
</div>

<% subTestCounter++; %>
<% if(subTestCounter == noOfSubTest){ %>
<label style="font: bold 13px arial color : #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">
----------End Of The Report ----------</label>
<% } %>
<div style='page-break-after: always;'></div>
<% 
 testCounter = 1;
}
%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</body>
</html>
