<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link href="css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hstyle.css" />

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
}

int medicoLegalDetailsId=0;
if(map.get("medicoLegalDetailsId") != null){
	medicoLegalDetailsId = (Integer)map.get("medicoLegalDetailsId");
}
String mlcType="";
if(map.get("mlcType") != null){
	mlcType = (String)map.get("mlcType");
}
String hin_no="";
if(map.get("hin_no") != null){
	hin_no = (String)map.get("hin_no");
}
String report="";
if(map.get("report") != null){
	report = (String)map.get("report");
}
System.out.println(report+"reeeeeeeeee");

%>
<div id="contentHolder">
<form name="messageMlc" method="post">
<h2><font id="error"><%=message%></font></h2>
<input type="hidden" name="mlcType" value="<%=mlcType%>" />
<input type="hidden" name="<%=HIN_NO%>" value="<%=hin_no%>" />
<input type="hidden" name="medicoLegalDetailsId" value="<%=medicoLegalDetailsId%>" />
<input type="hidden" name="mlcNo" value="<%=medicoLegalDetailsId%>" />


<%if(mlcType.equalsIgnoreCase("Examination of a male accused in sexual offence")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print" class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=reportOfExaminationOfAMaleAccusedInSexualOffence');" />
<%} }%>
<%if(mlcType.equalsIgnoreCase("EXAMINATION OF A FEMALE VICTIM OF SEXUAL ASSAULT")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print" class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=REPORT_OF_ EXAMINATION_OF_ A_FEMALE_VICTIM_OF_SEXUAL_ASSAULT');" />
<%}} %>
<%if(mlcType.equalsIgnoreCase("Examination of a victim of unnatural sexual offence")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print" class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=REPORT_OF_EXAMINATION_OF_A_VICTIM_OF_ UNNATURAL_SEXUAL_OFFENCE_new');" />
<%}} %>
<%if(mlcType.equalsIgnoreCase("Examination for evidence of recent delivery")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=REPORT_OF_EXAMINATION_FOR_EVIDENCE_OF_RECENT_DELIVERY');" />
<%} }%> 
<%if(mlcType.equalsIgnoreCase("Final opinion as to cause of death")){ %>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=FINAL OPINION AS TO CAUSE OF DEATH');" />
<%} %> 
<%if(mlcType.equalsIgnoreCase("Examination of a victim alleged to have been drugged")){ %>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=Report_of_examination_of_a_victim_alleged_to_have_been_drugged');" />
<%} %> 
<%if(mlcType.equalsIgnoreCase("Certificate Of Drunkness")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print Certificate Of Drunkness"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=CERTIFICATE_OF_DRUNKENNESS');" />
<%} }%> 
<%if(mlcType.equalsIgnoreCase("Examination for estimation of age")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=REPORT OF EXAMINATION FOR ESTIMATION OF AGE');" />
<%} }%> 
<%if(mlcType.equalsIgnoreCase("Chemical Analysis")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=Report to be forwarded with material objects sent for chemical analysis');" />

<%}} %> 
<%if(mlcType.equalsIgnoreCase("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=Certificate of collection of material objects from the body of a person for chemical examination');" />
<%} }%> 
<%if(mlcType.equalsIgnoreCase("POSTMORTEM CERTIFICATE")){ %>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=POSTMORTEM CERTIFICATE');" />
<%} %> 

<%if(mlcType.equalsIgnoreCase("Examination by a Medical Officer")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC');" />
<%} }%> 

<%if(mlcType.equalsIgnoreCase("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers")){ %>
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=Certificate of Examination by a Specialist Medical Officer Team of Specialist Medical Officers');" />

<%}} %>

<%if(mlcType.equalsIgnoreCase("Application cum No Objection Certificate")){ %>

<input type="button" name="Back" value="Print"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC');" />
<%} %>
 
<%if(mlcType.equalsIgnoreCase("Accident Register-cum-Wound Certificate")){ %>
 <%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print Police Intimation"	class="BigButton" onclick="submitForm('messageMlc','/hms/hms/adt?method=generateReportForMLCNo&<%=JASPER_FILE_NAME%>=policeIntimation');" />

<input type="button" name="Back" value="Print Wound Certficate"	class="BigButton" onclick="submitForm('messageMlc','/hms/hms/adt?method=generateReportForMLCNo&<%=JASPER_FILE_NAME%>=accidentRegisterCumWoundCertificate');" />
<%} %>
<%} %>



<%if(mlcType.equalsIgnoreCase("Treatment / Discharge Certificate")){ 
 int inpatientId=0;
if(map.get("inpatientId") != null){
	inpatientId = (Integer)map.get("inpatientId");
}%>
<input type="hidden" name="inpatientId" value="<%=inpatientId%>" />
<%if(report.equalsIgnoreCase("need report")) {%>
<input type="button" name="Back" value="Print Treatment/Discharge"	class="BigButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=generateReportForMLC&<%=JASPER_FILE_NAME%>=trearmentDischargeCertificate_new&medicoLegalDetailsId=<%=medicoLegalDetailsId%>');" />
<%} }%>

<input type="button" name="Back" value="Back"	class="cmnButton" onclick="submitForm('messageMlc','/hms/hms/mlc?method=showPatientMlcWaitingList');" /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>