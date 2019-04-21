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
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %> --%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<!-- <script type="text/javascript">
var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />';
</script> -->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

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
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasDeathCause> deathCauseList = new ArrayList<MasDeathCause>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<Discharge> dischargeList = new ArrayList<Discharge>();
	List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
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
	if(map.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)map.get("inpatientList");
	}
	if(map.get("relationList") != null){
		relationList = (List<MasRelation>)map.get("relationList");
	}
	if(map.get("blockList") != null){
		blockList = (List<MasBlock>)map.get("blockList");
	}
	if(map.get("districtList") != null){
		districtList = (List<MasDistrict>)map.get("districtList");
	}
	if(map.get("stateList") != null){
		stateList = (List<MasState>)map.get("stateList");
	}
	if(map.get("countryList") != null){
		countryList = (List<MasCountry>)map.get("countryList");
	}
	if(map.get("dischargeList") != null){
		dischargeList = (List<Discharge>)map.get("dischargeList");
	}
	if(map.get("transactionId") != null){
		transactionId = (Integer)map.get("transactionId");
	}
	if(map.get("deathCertificateNo") != null){
		deathCertificateNo = (String)map.get("deathCertificateNo");
	}
	if(map.get("expiryDetailsList") != null){
		expiryDetailsList = (List<ExpiryDetails>)map.get("expiryDetailsList");
	}
	ExpiryDetails expiryDetails = null;
	if(expiryDetailsList.size()>0){
		expiryDetails =(ExpiryDetails)expiryDetailsList.get(0);
	}
	String flagJsp = "";
	if(map.get("flagJsp") != null){
		flagJsp = (String)map.get("flagJsp");
	}
	
	
	Discharge discharge = null;
	String dischargeDate ="";
	 String dischargeTime =""; 
if(dischargeList.size()>0){
	 discharge =dischargeList.get(0);
	 
	try{
		 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		 dischargeDate=formatterOut.format(formatterIn.parse(""+discharge.getDateOfDischarge()));
		 dischargeTime =""+discharge.getTimeOfDischarge();
		
	}catch(Exception ee){
		ee.printStackTrace();
	}
	if(dischargeTime.equals("")){
		dischargeTime=currentTime;
	}
	if(dischargeDate.equals("")){
		dischargeDate=currentDate;
	}
}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	
	Patient patient = new Patient();
	if(patientList.size() > 0){
		 patient = patientList.get(0);
	}
	String age = "";
	String currentAge = "";
	Set<Visit> visitSet = (Set<Visit>)patient.getVisits();
	for(Visit visit : visitSet){
		if(visit.getVisitNo() == 1){
			age = visit.getAge();
			currentAge = HMSUtil.calculateAgeForADT2(age, visit.getVisitDate());
		
		}
	}
	Inpatient inpatient = inpatientList.get(0);
	String adNo = inpatient.getAdNo();
		
		System.out.println("test 1");
		session.setAttribute("inpatient",inpatient);
	
%>

<form name="expiryDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript">
		<%
			int counter=0;
			for (MasCountry masCountry : countryList) 
			{
				for (MasState masState : stateList) 
				{
					if(masCountry.getId().equals(masState.getCountry().getId())){
								%>
									stateArr[<%=counter%>] = new Array();
									stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
									stateArr[<%=counter%>][1] = <%=masState.getId()%>;									
									stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
								<%
								counter++;
						}
					}
			}
			System.out.println("test 2");
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
	
			int count = 0;
			for (MasDistrict masDistrict : districtList) 
			{
				for (MasBlock masBlock  : blockList) 
				{
					if(masDistrict.getId().equals(masBlock.getDistrict().getId())){
								%>
									blockArray[<%=count%>] = new Array();
									blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
									blockArray[<%=count%>][1] = <%=masBlock.getId()%>;									
									blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

								<%
								count++;
						}
					}
				}
			System.out.println("test 3");
			%>
	
	
</script> <%if( !message.equals("") ){ %>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<input value="Print" type="button" class="button"
	onClick="submitForm('expiryDetails','/hms/hms/ipd?method=showDischargeSlipReport&inpatientId='+<%=inpatient.getId()%>);">
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
<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="paddingTop5"></div>

<%@include file="PatientDetails.jsp" %>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<h4>Expiry Details</h4>
<div class="clear"></div>

<label><span>*</span> Cause Of Death(Direct)</label>
 <textarea name="<%=D_DEATH_CAUSE_ID %>" class="textAriaW" id="causeOfDeathId" validate="Cause Of Death(Direct),String,no" onpaste="return checkOnPaste(this)" 
 oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" maxlength="100" 
 tabindex="1"><%=expiryDetailsList.size()>0 && expiryDetails.getDDeathCauseText()!= null?expiryDetails.getDDeathCauseText():"" %></textarea>
	 <label>Cause of Death(Secondary)</label>
 <textarea name="<%=S_DEATH_CAUSE_ID %>" class="textAriaW" validate="Cause Of Death(Secondary),String,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" maxlength="100" tabindex="1"><%=expiryDetailsList.size()>0 && expiryDetails.getSDeathCauseText()!= null?expiryDetails.getSDeathCauseText():"" %></textarea>
 <label class="heightAuto">Cause of Death (Contributing)</label>
	  <textarea name="<%=C_DEATH_CAUSE_ID %>" class="textAriaW"
	validate="Cause Of Death(Contributing),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"><%= expiryDetailsList.size()>0 && expiryDetails.getCDeathCauseText()!= null?expiryDetails.getCDeathCauseText():"" %></textarea>

<div class="clear"></div>

<label>Issue Date</label> <input type="text" name="issueDate" style="width:164px;"
	value="<%= expiryDetailsList.size()>0 && expiryDetails.getIssueDate() != null?HMSUtil.convertDateToStringWithoutTime(expiryDetails.getIssueDate()):currentDate%>" class="readOnly" readonly="readonly"
	maxlength="20"><label>Issue Time</label> <input type="text" style="width:164px;"
	name="issueTime" value="<%=currentTime%>" class="readOnly"
	readonly="readonly" maxlength="20"><label>Death
Certificate No.</label> <input type="text" name="<%=DEATH_CERTIFICATE_NO %>" style="width:164px;"
	value="<%=expiryDetailsList.size()>0 && expiryDetails.getDeathCertificateNo() != null?expiryDetails.getDeathCertificateNo():deathCertificateNo%>" class="readOnly" readonly="readonly"
	maxlength="20"><input type="hidden" name="transactionId"
	value="<%=transactionId %>" />
	<input type="hidden" name="expiryDetailId"  value="<%= expiryDetailsList.size()>0 && expiryDetails.getId() != null?expiryDetails.getId():""  %>" />
	<input type="hidden" name="flagJsp"  value="<%= flagJsp != null?flagJsp:""  %>" />

<div class="clear"></div>

<label>Death Certificate Taken By</label> <input type="text" style="width:164px;"
	name="<%=DEATH_CERTIFICATE_TAKEN_BY %>" value="<%=expiryDetailsList.size()>0 && expiryDetails.getDeathCertificateTakenBy() != null?expiryDetails.getDeathCertificateTakenBy():"" %>"
	validate="Death Certificate Taken By,String,no" maxlength="50">
	<label><span>*</span>Expiry Date</label>
<%if(expiryDetailsList.size()>0 && expiryDetails.getExpiryDate() != null){ %>
 <input type="text" name="<%=DATE_OF_EXPIRY %>" value="<%=HMSUtil.convertDateToStringWithoutTime(expiryDetails.getExpiryDate())%>" class="date" style="width:144px;" readonly="readonly" validate="Expiry Date,date,yes" MAXLENGTH="30" />
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate %>',document.expiryDetails.<%=DATE_OF_EXPIRY%>)" />
<%}else{ %>
 <input type="text" name="<%=DATE_OF_EXPIRY %>" value="<%=!dischargeDate.equals("") && dischargeDate != null?dischargeDate:currentDate %>" class="date" style="width:144px;" readonly="readonly" validate="Expiry Date,date,yes" MAXLENGTH="30" />
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate %>',document.expiryDetails.<%=DATE_OF_EXPIRY%>)" />
	<%} %>

<label><span>*</span> Expiry Time</label>
<%if(expiryDetailsList.size()>0 && expiryDetails.getExpiryTime() != null){ %>
 <input type="text" name="<%=TIME_OF_EXPIRY %>" value="<%=expiryDetails.getExpiryTime() %>" validate="Expiry Time,String,yes" maxlength="50" style="width:164px;" />
 <%}else{ %>
  <input type="text" name="<%=TIME_OF_EXPIRY %>" value="<%=!dischargeTime.equals("") && dischargeTime != null?dischargeTime:currentTime %>" validate="Expiry Time,String,yes" maxlength="50" style="width:164px;" />
 <%} %>
<div class="clear"></div>

<label>Consequence of</label> <textarea name="<%=CONSQUENCE_OF %>" class="textAriaW"
	validate="Cause Of Death(Direct),String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" ><%=expiryDetailsList.size()>0 && expiryDetails.getConsequenceOf() != null?expiryDetails.getConsequenceOf():"" %></textarea>
	 <label>Id Mark 1</label> <textarea class="textAriaW"
	name="<%=ID_MARK1%>" validate="Id Mark 1,String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" ><%=expiryDetailsList.size()>0 && expiryDetails.getIdMarks1() != null?expiryDetails.getIdMarks1():"" %></textarea>
	<label>Id Mark 2</label> <textarea class="textAriaW"
	name="<%=ID_MARK2%>" validate="Id Mark 2,String,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1" ><%=expiryDetailsList.size()>0 && expiryDetails.getIdMarks2() != null?expiryDetails.getIdMarks2():"" %></textarea>

<div class="clear"></div>

<label>Remarks</label> <textarea name="<%=REMARKS%>" class="textAriaW"
	validate="Remarks,String,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="100" tabindex="1"><%= expiryDetailsList.size()>0 && expiryDetails.getRemarks() != null?expiryDetails.getRemarks():"" %></textarea>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div id="edited"></div>
<%if(expiryDetailsList.size()>0){ %>
<input type="button" name="Submit" value="Update" class="button" onClick="if(validateExpiryDetails())submitForm('expiryDetails','/hms/hms/adt?method=submitExpiryDetails&flag=update');" />

<%}else{ %>
<input type="button" name="Submit" value="Submit" class="button" onClick="if(validateExpiryDetails())submitForm('expiryDetails','/hms/hms/adt?method=submitExpiryDetails&flag=save');" />
<%} %>
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"	onclick="location.reload();" accesskey="r" />
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
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"><input
	type="hidden" name="<%=WARD_ID %>"
	value="<%=inpatient.getDepartment().getId() %>"><input
	type="hidden" name="<%=BED_ID %>"
	value="<%=inpatient.getBed().getId() %>"><input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatient.getId() %>">
<div id="statusMessage">
<h4></h4>
</div>

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
</script>

</form>

<style>
.textAriaW{width:164px !important; margin:0px 5px 5px 0px !important;}
</style>



