<%-- <%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
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
<script type="text/javascript" src="/hms/jsp/javascript/functions.js"></script>

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

	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");
	}
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
<div id="dataDiv">
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

 <%for(String subChargeName : subChargeCodeGroup){ 

	%>

<div style="padding-top: 36px; margin-top: 5px;"></div>

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
	<label>Validate By</label> <label
	class="value"><%= dgDetail.getResultEntry().getLastChgdBy().getEmployee().getEmployeeName()%></label>

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
		//s= dgDetail.getResult();
	}
	%>
	 <label class="value"><%=s %></label>
	<%
	if(dgResultEntryHeader.getSampleCollectionHeader()!=null && dgResultEntryHeader.getSampleCollectionHeader().getDgHistoSampleCollectionDetails()!=null){
		Set<DgHistoSampleCollectionDetails> collectionDetails=dgResultEntryHeader.getSampleCollectionHeader().getDgHistoSampleCollectionDetails();
		%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<th>S.No.</th>
			<th>Name</th>
			<th>Identification No</th>
			<th>Remark</th>
			</tr> 
		
		<% int i=1;
		for(DgHistoSampleCollectionDetails dgHistoSampleCollectionDetails:collectionDetails){ 
			String identification="";
			String remark="";
			String invName="";
			if(dgHistoSampleCollectionDetails.getIdentificationNo() !=null){
				identification=dgHistoSampleCollectionDetails.getIdentificationNo();
			}
			if(dgHistoSampleCollectionDetails.getRemarks()!=null){
				remark=dgHistoSampleCollectionDetails.getRemarks();
			}
			if(dgHistoSampleCollectionDetails.getChargeCode()!=null && dgHistoSampleCollectionDetails.getChargeCode().getChargeCodeName()!=null){
				invName=dgHistoSampleCollectionDetails.getChargeCode().getChargeCodeName();
			}
		%>
			<tr>
			<td><%=i++ %></td>
			<td><%=invName %></td>
			<td><%=identification%></td>
			<td><%=remark%></td>
			</tr>
		
		<%	
			System.out.println("Code "+dgHistoSampleCollectionDetails.getIdentificationNo()+" Remark "+dgHistoSampleCollectionDetails.getRemarks());
		}
		%>
		</table>
		<div class="clear"></div>
		<div class="clear"></div>
		<%
	}

%>


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
<div class=""> <label class="auto">Validate By :</label><label><%=verifiedPersonName%> </label></div>
<div class=""> <label class="auto">Designation :</label><label><%=verifiedPersonNameDesignation%> </label></div>
<div class="clear"></div>
<div class=""> <label class="auto">Entered By :</label><label><%=entryPersonName%> </label></div>
<div class=""> <label class="auto">Designation :</label><label><%=entryPersonNameDesignation%> </label></div>
<div class="clear"></div>


<div class="clear"></div>
<!--  <label style="font-size:11px; color:#000;font-family:arial;	padding-left:350px;width:auto;padding-right:0px;margin-right: 0px;">Signature:</label> -->
<!--  <label class="value" style="width:120px;margin-left: 0px;padding-left: 0px;"> </label> -->
</div>
<% subTestCounter++; %> <% if(subTestCounter == noOfSubTest){ %> <label
	style="font: bold 13px arial color :     #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">----------End
Of The Report ----------</label> <% } %>

<%
 testCounter = 1;
} 
%>

</body>
</html> --%>
<%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>eHealth Kerala</title>

<style>
.tableMainDiv { width:960px; height:auto; margin:0 auto; }
.headerMainDiv {width:100%; height:auto; margin:0; padding:0px; }
.logo-div { width:248px; height:auto; float:left; margin-top:20px;}
.header-right {width:auto; float:right; margin:0px; padding:6px 20px 0px 0px; font-family:Calibri; font-size:16px; color:#333333;}
.hospitalName {font-size:20px; font-weight:bold; font-family:Calibri; color:#333333;}
.labName {font-size:18px; font-weight:bold; font-family:Calibri; color:#333333;}
.pTextMiddle {font-size:20px; font-weight:bold; text-align:center; font-family:Calibri; color:#333333; text-decoration:underline; margin:0; padding:0;}
.pTextleft {font-size:18px; text-align:left; margin:0; padding:0; font-family:Calibri; color:#333333;}

.tablestyle { border: 1px solid #bbbbbb; padding:0; font-family:Calibri; font-size:16px; color:#333333;}
.tablestyle th { background: #e9e9e9; border-bottom: 1px solid #bbbbbb; border-right: 1px solid #bbbbbb; padding:1px 5px;}
.tablestyle td {  border-bottom: 1px solid #bbbbbb; border-right: 1px solid #bbbbbb; padding:1px 5px;}</style>
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

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	List<String[]> subChargeCodeGroup = new ArrayList<String[]>();

	String message = "";
	String clinicalNotes = "";
	String url = "";
	String verifiedPersonNameDesignation = "";
	String entryPersonNameDesignation = "";
	String entryPersonNameRank = "";
	String verifiedPersonNameRank = "";
	String flagForConfidential = "";
	String patientStatus="";

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
	if (detailsMap1.get("patientStatus") != null  && "Out Patient".equalsIgnoreCase(detailsMap1.get("patientStatus").toString()) ) {
		patientStatus = "OP";

	}else if(detailsMap1.get("patientStatus") != null  && "In Patient".equalsIgnoreCase(detailsMap1.get("patientStatus").toString()) ){
		patientStatus = "IP";
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

	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List)detailsMap1.get("dgResultEntryHeaderByOrderNo");
	}
	if (detailsMap1.get("flagForConfidential") != null) {
		flagForConfidential = (String)detailsMap1.get("flagForConfidential");

	}

	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}
	if (map.get("url") != null) {
		url = "" + map.get("url");
	}
	List<Object[]> invDataObject=new ArrayList<Object[]>();
	if (detailsMap1.get("invReportdata") != null) {
		invDataObject = (List<Object[]>)detailsMap1.get("invReportdata");

	}
	Map<String,List<Object[]>> reportDataMap=new HashMap<String,List<Object[]>>();
	if (detailsMap1.get("reportDataMap") != null) {
		reportDataMap = (Map<String,List<Object[]>>)detailsMap1.get("reportDataMap");

	}

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	System.out.println("subChargeCodeGroup "+subChargeCodeGroup.size());
%>
<body>
<div class="tableMainDiv">
<div class="headerMainDiv">
<div class="logo-div"><img src="../jsp/images/gok-logo.jpg" alt="" border="0" width="150" height="61" /></div>
<div class="header-right"><span class="hospitalName"><%=hospitalName %></span><br> 
<span class="labName">Laboratory</span> <br><%=hospitalAddress %><br>Contact No:</div>

<div style="clear:both"></div>
</div>
<br>
<table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" >  
    <tr>
      <td align="center">Doctor</td>
      <td align="center"> <%=doctorName %></td> 
      <td align="center">Name</td>
      <td align="center"><%=patientName %></td>
    </tr>
    <tr>
      <td align="center">Account</td>
      <td align="center"><!-- Free/RSBY/Paid --></td> 
      <td align="center">Age</td>
      <td align="center"><%=patientAge%></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td align="center">&nbsp;</td> 
      <td align="center">Gender</td>
      <td align="center"><%=sex %></td>
    </tr>
    <tr>
      <td align="center">&nbsp;</td>
      <td align="center">&nbsp;</td> 
      <td align="center">SSN</td>
      <td align="center"><%=patientStatus%>, <%=orderByDepartment%></td>
    </tr>
    <tr>
      <td align="center">UHID:</td>
      <td align="center"><%= hinNo %></td> 
      <td align="center">&nbsp;</td>
      <td align="center">&nbsp;</td>
    </tr>
  </table>
  <br>
  <p class="pTextMiddle">Qualitative/Quantitative Laboratory Reports</p>
  
  <%for(Object[] obj : subChargeCodeGroup){  
	  List<Object[]> invMainDataObject=new ArrayList<Object[]>();
  	     if(reportDataMap.get(obj[0]+""+obj[1])!=null){
  	    	 
  	    	invMainDataObject=(List<Object[]>)reportDataMap.get(obj[0]+""+obj[1]);
  	     }
  	     
  	     if(invMainDataObject.size()>0){//added by govind 03-07-2017
  	    	 
  %>
  <br>
  <p class="pTextleft"><%=obj[0].toString() %> (<%=obj[1].toString() %>)</p>
  <br> 
  <table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" >  
    <tr>
      <td align="center">Specimen</td>
      <td align="center"> <%=invMainDataObject.get(0)[28] %></td> 
      <td align="center">Sample-Id</td>
      <td align="center"><%=invMainDataObject.get(0)[10]+"/"+invMainDataObject.get(0)[29] %></td>
    </tr>
    <tr>
      <td align="center">Collection Date and Time</td>
      <td align="center"><%=HMSUtil.convertDateToStringWithoutTime((Date)invMainDataObject.get(0)[30])+" "+invMainDataObject.get(0)[39] %></td> 
      <td align="center">Received Date and Time</td>
      <td align="center"><%=HMSUtil.convertDateToStringWithoutTime((Date)invMainDataObject.get(0)[31])+" "+invMainDataObject.get(0)[40] %></td>
    </tr>
    <tr>
      <td align="center">Reporting Date and Time</td>
      <td align="center"><%=HMSUtil.convertDateToStringWithoutTime((Date)invMainDataObject.get(0)[16])+" "+invMainDataObject.get(0)[17] %></td> 
      <td align="center"></td>
      <td align="center"></td>
    </tr> 
  </table> 
   <br>
  <table width="100%" border="0" cellpadding="5" cellspacing="0" class="tablestyle" style="margin-top:12px;font-size:18px; font-weight:bold;">
    <tr>
      <th align="center">Sl No</th>
      <!-- <th align="center">Investigation code</th> -->
      <th align="center">Name of Investigation</th>
      <th align="center">Observed Value</th>
      <th align="center">Units</th>
      <th align="center">Normal Range</th>
      <th align="center">Remarks</th>
    </tr>
    <%
    int index=0;
    float minVal=0,maxVal=0,result=0;
     for(int i=0;i<invMainDataObject.size();i++){ 
    	 
    	index++;
    	if(invMainDataObject.get(i)[35] !=null && !invMainDataObject.get(i)[35].equals(" - ")){
    		String Val[]=invMainDataObject.get(i)[35].toString().split("-");
    		if(Val[0].contains("Min")){
    			String newMinVal[]=Val[0].split("Min");
    			minVal=Float.parseFloat(newMinVal[0]);
    			String newMaxVal[]=Val[1].split("Min");
    			maxVal=Float.parseFloat(newMaxVal[0]);
    		}else{
    		minVal=Float.parseFloat(Val[0]);
    		maxVal=Float.parseFloat(Val[1]);
    		if(invMainDataObject.get(i)[18].toString().contains(".")){
    			String newMinVal=invMainDataObject.get(i)[18].toString().replace(".", "");
    			  if(newMinVal.trim().length()==0 ){
    				result=0;
    			} else{
    				result=Float.parseFloat(invMainDataObject.get(i)[18].toString());
    			} 
    		}else{
    			try{
      		result=Float.parseFloat(invMainDataObject.get(i)[18].toString());
    			}catch(Exception e){
    				
    			}
    		}
    		}
    	}
	 %>
	  
	
    <tr>
      <td align="center"><%=index %></td>
      <%-- <td align="left"><%=invDataObject.get(i)[0]!=null?invDataObject.get(i)[0]:"" %></td> --%>
      <td align="left"><%=invMainDataObject.get(i)[15] !=null?invMainDataObject.get(i)[15]:""%></td>
      <%if(invMainDataObject.get(i)[35]!=null){ %>
      <% String Val[]=invMainDataObject.get(i)[35].toString().split("-");
       if(Val[0].contains("Min")){ %>
      <td align="left" style="color:bold"><%=invMainDataObject.get(i)[18] !=null?invMainDataObject.get(i)[18]:""%></td>
      <%} 
	else{ %> 
      <%if(result>= minVal  && result<=maxVal){%>
		<td align="left" style="color:bold"><%=invMainDataObject.get(i)[18] !=null?invMainDataObject.get(i)[18]:""%></td>
		<%} 
	else{%>
		<td align="left" style="color:red;"><%=invMainDataObject.get(i)[18] !=null?invMainDataObject.get(i)[18]:""%></td>
	   <%}}}else{ %>
	  <td align="left" style="color:bold"><%=invMainDataObject.get(i)[18] !=null?invMainDataObject.get(i)[18]:""%></td>
	   <%} %>
      
      <td align="left"><%=invMainDataObject.get(i)[27] !=null?invMainDataObject.get(i)[27]:""%></td>
      <td align="left"><%=invMainDataObject.get(i)[35] !=null?invMainDataObject.get(i)[35]:""%></td>
      <% if(invMainDataObject.get(i)[12]!=null && !"".equalsIgnoreCase(invMainDataObject.get(i)[12]+"")){%> 
	
      <td colspan="6" align="left"><%=invMainDataObject.get(i)[12] %></td>
  
   	<% }else{%>
   	<td></td>
   	<%} %>
    </tr> 
    <%} %>
  </table> 
   <br> 
  <table width="100%" border="0" cellpadding="5" cellspacing="0" style="font-family:Calibri; color:#333333;">
    <tr>
    <%--  <td width="40%" align="center">Sample Validated by&nbsp;&nbsp;<b><%=invMainDataObject.get(0)[19]%><%=invMainDataObject.get(0)[33]!=null?" ("+invMainDataObject.get(0)[33]+")":""%></b></td>--%>
       <td width="40%" align="center"><b>Sample Validated by (Name and Designation)</b><br><%=invMainDataObject.get(0)[19]%>&nbsp;&nbsp;&nbsp;&nbsp;Lab Technician</td>
      <td width="20%" align="left">&nbsp;</td> 
      <%--  <td width="40%" align="center">Result Validated by&nbsp;&nbsp;<b><%=invMainDataObject.get(0)[20]%><%=invMainDataObject.get(0)[33]!=null?" ("+invMainDataObject.get(0)[33]+")":""%></b></td>--%>
       <td width="40%" align="center"><b>Result Validated by (Name and Designation)</b><br><%=invMainDataObject.get(0)[20]%>&nbsp;&nbsp;&nbsp;&nbsp;Lab Incharge</td>
    </tr>
    <tr>
      <%-- <td align="center"><%=invMainDataObject.get(0)[32]%><%=invMainDataObject.get(0)[32]!=null?" ("+invMainDataObject.get(0)[36]+")":""%></td> --%>
      <td align="left">&nbsp;</td>
<%--       <td align="center"><%=invMainDataObject.get(0)[19]%><%=invMainDataObject.get(0)[33]!=null?" ("+invMainDataObject.get(0)[33]+")":""%> </td> --%>
<td align="left">&nbsp;</td>
    </tr>
  </table>
 <br>
  <% }}%>  
 <br>
 <br>   

<div style="clear:both"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</body>
</html>
<script>
function changeResultValueTextColor(result,minValue,maxValue,inc){
	
	//alert(inc)
	if((parseFloat(result))>= (parseFloat(minValue))  && (parseFloat(result))<=(parseFloat(maxValue))){
		//alert(result)
		document.getElementById('result'+inc).style.color='gray';	
		}
	else{
		document.getElementById('result'+inc).style.color='red';
	
		}
	
}	
</script>
