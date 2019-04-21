<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<%--<script type="text/javascript" src="/hms/jsp/javascript/functions.js"></script> --%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


</head>

<body>
<%Date d=new Date();
String hinNo="&nbsp;";
String deptName="&nbsp;";
String patientName="&nbsp;";
String orderNo="&nbsp;";
String orderDate="&nbsp;";
String patientAge="&nbsp;";
String sex="&nbsp;";
String resultDate="&nbsp;";
String subChargeCodeName="&nbsp;";
String mainChargeCodeName="&nbsp;";
String charge="&nbsp;";
String doctorName="&nbsp;";
String entryPersonName="&nbsp;";
String servicePersonName="&nbsp;";
String radioId = "&nbsp;";
String entryPersonNameRank = "&nbsp;";
String prefix = "";
String suffix = "";
String hospitalAddress="";
String hospitalName="";

	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap1 = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	String message = "";
	String url = "";
	String clinicalNotes = "";
	int deptId = 0;
	String deptType="";
	String verifiedPersonNameDesignation = "&nbsp;";
	String entryPersonNameDesignation = "&nbsp;";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("detailsMap1") != null) {
		
		detailsMap1 = (Map<String, Object>)map.get("detailsMap1");
		
	}
	if (map.get("dataMap") != null) {
		
	dataMap = (Map<String, Object>)map.get("dataMap");
		
	}
	if(map.get("hospitalName")!=null){
		hospitalName=(String)map.get("hospitalName");
	}
	if(map.get("hospitalAddress")!=null){
		hospitalAddress=(String)map.get("hospitalAddress");
	}
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	if(session.getAttribute("deptId")!=null){
		deptId =(Integer)session.getAttribute("deptId");
	}
	if(session.getAttribute("deptType")!=null){
		deptType =(String)session.getAttribute("deptType");
	}
	if (detailsMap1.get("hinNo") != null) {
		hinNo = (String)detailsMap1.get("hinNo");

	}if (detailsMap1.get("servicePersonName") != null) {
		servicePersonName = (String)detailsMap1.get("servicePersonName");

	}
	if (detailsMap1.get("prefix") != null) {
		prefix = (String)detailsMap1.get("prefix");

	}
	if (detailsMap1.get("suffix") != null) {
		suffix = (String)detailsMap1.get("suffix");

	}

	if (detailsMap1.get("entryPersonName") != null) {
		entryPersonName = (String)detailsMap1.get("entryPersonName");

	}
	if (detailsMap1.get("entryPersonNameDesignation") != null) {
		entryPersonNameDesignation = (String)detailsMap1.get("entryPersonNameDesignation");

	}
	if (detailsMap1.get("entryPersonNameRank") != null) {
		entryPersonNameRank = (String)detailsMap1.get("entryPersonNameRank");

	}
	if (detailsMap1.get("verifiedPersonNameDesignation") != null) {
		verifiedPersonNameDesignation = (String)detailsMap1.get("verifiedPersonNameDesignation");

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
	if (detailsMap1.get("clinicalNotes") != null) {
		clinicalNotes = (String)detailsMap1.get("clinicalNotes");
	}
	if (map.get("messageTOBeVisibleToTheUser") != null) {
		message = "" + map.get("messageTOBeVisibleToTheUser");
	}
	if (map.get("url") != null) {
		url = "" + map.get("url");
	}
	if (map.get("dgResultdetailList") != null) {
		dgResultdetailList = (List<DgResultEntryDetail>) map
				.get("dgResultdetailList");
	}

	String resultType = "";
	if (map.get("resultType") != null) {
		resultType = (String) map.get("resultType");
	}

	String sampleCollDateString = "";
	DgSampleCollectionDetails dgSampleCollectionDetails = dgResultdetailList.get(0).getSampleCollectionDetails();
	 Date sampleCollectionDate =  dgSampleCollectionDetails.getSampleCollDatetime();
	 sampleCollDateString = HMSUtil.convertDateToStringWithoutTime(sampleCollectionDate);


%>

<div id="mainIn">
<%if(deptType.equalsIgnoreCase("radio")){ %> <label
	style="font-size: 11px; color: #000; font-family: arial; padding-left: 20px; font-weight: bold; width: 70px; padding-right: 0px; margin-right: 0px; margin-top: 0px; margin-bottom: 0px;"></label>
<div class="clear"></div>

<label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 3px;"></label>
<div class="clear"></div>
<label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalName %></label>
<div class="clear"></div>
<label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalAddress %></label>

<div class="clear"></div>
<% if(dgResultdetailList.get(0).getResultDetailStatus().equalsIgnoreCase("W")){ %>
<label
	style="font: bold 13px arial color :   #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px"><%=deptName %>
Report </label> <% }else{ %> <label
	style="font: bold 13px arial color :   #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Provisional
<%=deptName %> Report </label> <% } %> <br> <%}else{ %> <label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalName %></label>
<div class="clear"></div>
<label
	style="font: bold 13px arial color :   #000; font-weight: bold; text-decoration: underline; float: right; text-align: center; font-size: 12px; width: 100%; margin-top: 0px;"><%=hospitalAddress %></label>

<div class="clear"></div>
<% if(dgResultdetailList.get(0).getResultDetailStatus().equalsIgnoreCase("W")){ %>
<label
	style="font: bold 13px arial color :   #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px"><%=deptName %>
Result </label> <% }else{ %> <label
	style="font: bold 13px arial color :   #000; width: 100%; font-weight: bold; text-align: center; font-size: 12px; float: right; margin-top: 1px">Provisional
<%=deptName %> Result </label> <% } %> <br> <% } %>
<div style="padding-top: 10px; margin-top: 0px;"></div>
<div class="Block"><label>Dept/Ward :</label> <label class="value">
<%=dgResultdetailList.get(0).getSampleCollectionDetails().getSampleCollectionHeader().getDepartment().getDepartmentName() %>
</label> <label>Patient Name :</label> <label class="value">: <%=patientName %>
</label> <label>Age/Sex :</label> <label class="value"> <%=patientAge%>/<%=sex %></label>

<div class="clear"></div>

<label>Prescribed By :</label> <label class="value"> <%=doctorName %></label>

<label>Sub Department :</label> <label class="value"> <%=subChargeCodeName%></label>

<div class="clear"></div>

<label>Clinical Notes :</label> <label class="value"> <%=clinicalNotes%></label>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="Block"><!-- line should  be here -->
<h1 align="center" class="style1"><!-- charge Code here --></h1>
<!-- line should  behere -->
<div class="clear"></div>
<label>Test Name :</label> <label class="value"> <%=charge%> </label> <label>Test
Date :</label> <label class="value"> <%=sampleCollDateString %> </label>

<div class="clear"></div>
<div class="clear"></div>
<%if(deptType.equalsIgnoreCase("radio")){ %> <label>Report :</label> <% }else{ %>
<label>Result :</label> <% } %> <label class="valueAuto" style="height: auto;"><%=dgResultdetailList.get(0).getResult()%></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="Block"><label class="auto">Date</label> <label
	class="value"> <%=resultDate%> </label>
<div class="floatRight"><label><%=entryPersonName%> </label></div>
<div class="clear"></div>

</div>
<div class="clear"></div>



<label
	style="font: bold 13px arial color :   #000; font-weight: bold; float: right; text-align: center; font-size: 11px; width: 100%; height: 0px; margin-top: 0px;">----------
End Of The Report ----------</label>

<div style='page-break-after: always;'></div>
</div>
</body>
</html>