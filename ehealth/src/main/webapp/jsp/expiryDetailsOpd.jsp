<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * expiryDetails.jsp  
 * Purpose of the JSP -  This is for Expiry Details.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDeathCause"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<ExpiryDetails> expiryDetailsList=new ArrayList<ExpiryDetails>();

	
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String deathCertificateNo="";
	int transactionId=0;
	HospitalParameters hospitalParameters = new HospitalParameters();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("hospitalParameters") != null){
		hospitalParameters = (HospitalParameters)map.get("hospitalParameters");
	}
	String blockStatus="";
	if(hospitalParameters.getBlock()!=null){
		blockStatus=hospitalParameters.getBlock().trim();
	}
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
	}
	if(map.get("expiryDetailsList") != null){
		expiryDetailsList = (List<ExpiryDetails>)map.get("expiryDetailsList");
	}
	
	if(map.get("deathCertificateNo") != null){
		deathCertificateNo = (String)map.get("deathCertificateNo");
	}
	if(map.get("transactionId") != null){
		transactionId = (Integer)map.get("transactionId");
	}
	
	//Discharge discharge =dischargeList.get(0);
	 String dischargeDate ="";
	 String dischargeTime =""; 
	try{
		 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		// dischargeDate=formatterOut.format(formatterIn.parse(""+discharge.getDateOfDischarge()));
		// dischargeTime =""+discharge.getTimeOfDischarge();
		
	}catch(Exception ee){
		ee.printStackTrace();
	}
	if(dischargeTime.equals("")){
		dischargeTime=currentTime;
	}
	if(dischargeDate.equals("")){
		dischargeDate=currentDate;
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	
	
	String uhidNo="";
	String patientName="";
	String gender="";
	String age="";
	String address="";
	String patientCategory="";
	String faimlyIncome="";
	int hinId=0;
	String certificatePrintStatus="n";
	
	if(null !=patientList && patientList.size()>0){
		for(Patient patient:patientList){
			hinId=patient.getId();
			uhidNo=patient.getHinNo();
			patientName=patient.getFullName();
			gender=patient.getSex().getAdministrativeSexName();
			age=patient.getAge();
			if(null !=patient.getPatientType()){
			patientCategory=patient.getPatientType().getPatientTypeName();
			}
			if(null !=patient.getBplStatus() && !patient.getBplStatus().equals("")){
				faimlyIncome=patient.getBplStatus();
			}
			if(null !=patient.getDeathCertificatePrintStatus())
			certificatePrintStatus=patient.getDeathCertificatePrintStatus();
			System.out.println("certificatePrintStatus "+certificatePrintStatus);
		}
	}
	
		
	
%>

<form name="expiryDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript">
		
	
	
</script> 
<%if( !message.equals("") ){ %>
<%-- <h4><span><%=message %></span></h4> --%>
<div class="clear"></div>
<!-- <input value="Print" type="button" class="button"
	onClick="submitForm('expiryDetails','/hms/hms/ipd?method=showDischargeSlipReport&inpatientId=');"> -->
<%} %> <br />
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 13 Aug 2010
 -->	
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <%@include file="PatientDetails.jsp" %> --%>
<label>UHID</label> 
<label class="value"><%=uhidNo%></label>
<label>Patient Name</label> 
<label class="value"><%=patientName%></label>
<label>Address</label> 
<label class="value"></label>
<div class="clear"></div>
<label>Gender</label> 
<label class="value"><%=gender %></label>
<label>Marital Status</label> 
<label class="value">age</label>
<label>Age</label> 
<label class="value"><%=age %></label>
<div class="clear"></div>
<label>Patient Category</label> 
<label class="value"><%=patientCategory %></label>
<label>Department</label> 
<label class="value"></label>
<label>Unit</label> 
<label class="value"></label>
<div class="clear"></div>

<label>Unit Head</label> 
<label class="value"></label>
<label>Referring Doctor</label> 
<label class="value"></label>
<label>Admitting Doctor</label> 
<label class="value"></label>
<div class="clear"></div>

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="Block">
<% 
System.out.print("expiryDetailsList.size() "+expiryDetailsList.size());
if(null !=expiryDetailsList && expiryDetailsList.size()<=0){ %>
<h4>Expiry Details</h4>
<div class="clear"></div>
<label><span>*</span> Cause Of
Death(Direct)</label> <textarea name="<%=D_DEATH_CAUSE_ID %>"
	id="causeOfDeathId" validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea> <label>Cause of
Death(Secondary)</label> <textarea name="<%=S_DEATH_CAUSE_ID %>"
	validate="Cause Of Death(Secondary),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea> <label>Cause of
Death(Contributing):</label> <textarea name="<%=C_DEATH_CAUSE_ID %>"
	validate="Cause Of Death(Contributing),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea>

<div class="clear"></div>

<label>Issue Date</label> <input type="text" name="issueDate"
	value="<%=currentDate%>" class="readOnly" readonly="readonly"
	maxlength="20"><label>Issue Time</label> <input type="text"
	name="issueTime" value="<%=currentTime%>" class="readOnly"
	readonly="readonly" maxlength="20"><label>Death
Certificate No.</label> <input type="text" name="<%=DEATH_CERTIFICATE_NO %>"
	value="<%=deathCertificateNo%>" class="readOnly" readonly="readonly"
	maxlength="20"><input type="hidden" name="transactionId"
	value="<%=transactionId %>" />

<div class="clear"></div>

<label>Death Certificate Taken By</label> <input type="text"
	name="<%=DEATH_CERTIFICATE_TAKEN_BY %>" value=""
	validate="Death Certificate Taken By,String,no" maxlength="50"><label><span>*</span>
Expiry Date</label> <input type="text" name="<%=DATE_OF_EXPIRY %>"
	value="<%=dischargeDate.substring(0,10) %>" class="date" readonly="readonly"
	validate="Expiry Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.expiryDetails.<%=DATE_OF_EXPIRY%>)" />


<label><span>*</span> Expiry Time</label> <input type="text"
	name="<%=TIME_OF_EXPIRY %>" value="<%=dischargeTime %>"
	validate="Expiry Time,String,yes" maxlength="50">
<div class="clear"></div>

<label>Consequence of</label> <textarea name="<%=CONSQUENCE_OF %>"
	validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <label>Id Mark 1</label> <textarea
	name="<%=ID_MARK1%>" validate="Id Mark 1,String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <label>Id Mark 2</label> <textarea
	name="<%=ID_MARK2%>" validate="Id Mark 2,String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea>

<div class="clear"></div>

<label>Remarks</label> <textarea name="<%=REMARKS%>"
	validate="Remarks,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea>
<%} %>
<div class="clear"></div>
			
<% 
if(null !=expiryDetailsList && expiryDetailsList.size()>0){
	String deathCause="";
	String deathCausescondry="";
	String deathCauseContributing="";
	String issueDate="";
	String issueTime="";
	String deathCertificateNumber="";
	String certificateTakenBy="";
	String expiryDate="";
	String expiryTime="";
	String consequenceof="";
	String idMark1="";
	String idmark2="";
	String remark="";
	for(ExpiryDetails expiry:expiryDetailsList){
		deathCause=expiry.getCDeathCauseText();
		deathCausescondry=expiry.getSDeathCauseText();
		//deathCauseContributing=expiry.getc;
		issueDate=HMSUtil.convertDateToStringTypeDate(expiry.getIssueDate()) ;
		issueTime=expiry.getIssueTime();
		deathCertificateNumber=expiry.getDeathCertificateNo();
		certificateTakenBy=expiry.getDeathCertificateTakenBy();
		expiryDate=HMSUtil.convertDateToStringTypeDate(expiry.getExpiryDate()) ;
		expiryTime=expiry.getExpiryTime();
		consequenceof=expiry.getConsequenceOf();
		idMark1=expiry.getIdMarks1();
		idmark2=expiry.getIdMarks2();
		remark=expiry.getRemarks();
	} %>
	
	<div class="clear"></div>
<h4>Expiry Details</h4>
<div class="clear"></div>
<label><span>*</span> Cause Of
Death(Direct)</label> <textarea name="<%=D_DEATH_CAUSE_ID %>" value="<%=deathCause %>"
	id="causeOfDeathId" validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea> <label>Cause of
Death(Secondary)</label> <textarea name="<%=S_DEATH_CAUSE_ID %>"
	validate="Cause Of Death(Secondary),String,no"
	onpaste="return checkOnPaste(this)" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)" value="<%=deathCausescondry %>"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea>
	
	 <label>Cause of
Death(Contributing):</label> <textarea name="<%=C_DEATH_CAUSE_ID %>"
	validate="Cause Of Death(Contributing),String,no"
	onpaste="return checkOnPaste(this)" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)" value="<%=deathCauseContributing %>"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"></textarea>

<div class="clear"></div>

<label>Issue Date</label> <input type="text" name="issueDate"
	value="<%=issueDate%>" class="readOnly" readonly="readonly"
	maxlength="20"><label>Issue Time</label> <input type="text"
	name="issueTime" value="<%=issueTime%>" class="readOnly"
	readonly="readonly" maxlength="20"><label>Death
Certificate No.</label> <input type="text" name="<%=DEATH_CERTIFICATE_NO %>"
	value="<%=deathCertificateNumber%>" class="readOnly" readonly="readonly"
	maxlength="20"><input type="hidden" name="transactionId"
	value="<%=transactionId %>" />

<div class="clear"></div>

<label>Death Certificate Taken By</label> <input type="text"
	name="<%=DEATH_CERTIFICATE_TAKEN_BY %>" value="<%=certificateTakenBy %>" readonly="readonly"
	validate="Death Certificate Taken By,String,no" maxlength="50">
	
	<label><span>*</span>
Expiry Date</label> <input type="text" name="<%=DATE_OF_EXPIRY %>"
	value="<%=expiryDate.substring(0,10) %>" class="date" readonly="readonly"
	validate="Expiry Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" readonly="readonly"
	onclick="javascript:setdate('',document.expiryDetails.<%=DATE_OF_EXPIRY%>)" />


<label><span>*</span> Expiry Time</label> <input type="text"
	name="<%=TIME_OF_EXPIRY %>" value="<%=expiryTime %>"
	validate="Expiry Time,String,yes" readonly="readonly" maxlength="50"> 
<div class="clear"></div>

<label>Consequence of</label> <textarea name="<%=CONSQUENCE_OF %>"
	validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)" value="<%=consequenceof %>"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" readonly="readonly"
	maxlength="100" tabindex="1" /></textarea> <label>Id Mark 1</label> <textarea
	name="<%=ID_MARK1%>" validate="Id Mark 1,String,no"
	onpaste="return checkOnPaste(this)" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)"  value="<%=idMark1 %>"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea> <label>Id Mark 2</label> <textarea
	name="<%=ID_MARK2%>" validate="Id Mark 2,String,no"
	onpaste="return checkOnPaste(this)"  value="<%=idmark2 %>" readonly="readonly"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea>

<div class="clear"></div>

<label>Remarks</label> <textarea name="<%=REMARKS%>" readonly="readonly"
	validate="Remarks,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"  value="<%=remark %>"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" /></textarea>

<div class="clear"></div>
<%}

%>
</div>
<div class="clear"></div>
<div class="paddingTop25"></div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<%if(null !=expiryDetailsList && expiryDetailsList.size()>0 && certificatePrintStatus.equals("n") ){ %>
<input type="button" name="yes" value="Print Expiry Certificate" class="buttonBig2"
	onclick="submitForm('expiryDetails','/hms/hms/opd?method=printExpiryDetails&hinId='+<%=hinId%>);" />
	<%}if(null !=expiryDetailsList && expiryDetailsList.size()<=0){ %>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="if(validateExpiryDetails())submitForm('expiryDetails','/hms/hms/opd?method=submitExpiryDetails');" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	onclick="location.reload();" accesskey="r" />
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <input type="hidden"
	name="<%= CHANGED_BY%>" value="<%=userName%>" readonly="readonly"
	MAXLENGTH="8" tabindex=3 /> <label class="value"><%=userName%></label>

<label>Changed Date</label> <input type="hidden"
	name="<%= CHANGED_DATE %>" value="<%=currentDate%>" readonly="readonly"
	tabindex=3 /> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <input type="hidden" name="<%=CHANGED_TIME %>"
	value="<%=currentTime%>" readonly="readonly" tabindex=3 /> <label
	class="value"><%=currentTime%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>"><input
	type="hidden" name="<%=WARD_ID %>"
	value=""><input
	type="hidden" name="<%=BED_ID %>"
	value=""><input type="hidden"
	name="<%=INPATIENT_ID %>" value="">
<div id="statusMessage">
<h4></h4>
</div>
<script type="text/javascript">
function validateExpiryDetails(){
if(document.getElementById("causeOfDeathId").value ==""){
alert("Please fill Cause Of Death")
	return false
}else{
	return true
}
}
function displayListDateTime(){
	var list = document.getElementById('list').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';
	if(list != 0){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
}
</script></form>

