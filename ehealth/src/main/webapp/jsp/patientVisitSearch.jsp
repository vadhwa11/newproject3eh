<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.HospitalRefer"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.AppInvestigationAppointments"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOSPITAL_STAFF"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPLAINT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page trimDirectiveWhitespaces="true"%>
<%-- 
 --%>
 <script type="text/javascript">
	var unitIdLastVisit;
	var doctorIdLastVisit;
 </script>
 <script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

<%Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }%>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<script>
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('btnSearchvisit').click();
			return false;
		}
		return true;
	}
	
	
</script>

<script type="text/javascript">
	function aadhaar() {
		
		    var aadhaarData= prompt("Pick Your Aadhar Details:","");
		    
		    if( aadhaarData != null &&  aadhaarData != ""){
		    	var dat= aadhaarData;
		    data = dat.replace('</?xml version="1.0" encoding="UTF-8"?>','');
		    if (window.DOMParser)
		     {
		     parser=new DOMParser();
		     xmlDoc=parser.parseFromString(data,"text/xml");
		     }
		   else // Internet Explorer
		     {
		     xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		     xmlDoc.async=false;
		     xmlDoc.loadXML(data);
		     }
		   
		    document.getElementById("hinNo1").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('uid');
		   
		    submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&visitSearch=serch')		   
		}
		    return null;
		}
	
</script>

<%URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentTimeHHMM();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");

Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

String userName = "";
if(session.getAttribute("userName") != null)
{
        userName = (String)session.getAttribute("userName");
}


List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
/* List<MasEmployee> doctorList = new ArrayList<MasEmployee>(); */
List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
List<MasAuthorizer> authorizerList=new ArrayList<MasAuthorizer>();
List<Patient> patientDetailsList=new ArrayList<Patient>();
List<Visit> visitList=new ArrayList<Visit>();
List<MasScheme> schemeList=new ArrayList<MasScheme>();

String billNo="";
BigDecimal availableCredit=new BigDecimal(0.00);
BigDecimal amount=new BigDecimal(0.00);
BigDecimal rate=new BigDecimal(0.00);
BigDecimal stdDeduction = new BigDecimal(0.00);
BigDecimal discAmt = new BigDecimal(0.00);
int regChargeId = 1038;
int nVisitId = 4777;

int hospitalId=0;
String searchUhid="";
String fullName="";
String patientDeadStatus="";
System.out.println();
if(request.getAttribute("map") != null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(request.getAttribute("map") != null)
{
	visitList=(List<Visit>)map.get("visitList");
}
if (map.get("billNo") != null) 
{
	billNo = (String) map.get("billNo");
}
if(map.get("amount")!=null)
{
	amount=(BigDecimal)map.get("amount");
}
if(map.get("hospitalId")!=null)
{
	hospitalId=(Integer)map.get("hospitalId");
}
if (map.get("patientDeadStatus") != null) 
{
	patientDeadStatus = (String) map.get("patientDeadStatus");
}

if(map.get("rate") != null)
{
	rate = (BigDecimal)map.get("rate");
}
if (map.get("discAmt") != null) 
{
	discAmt =  (BigDecimal)map.get("discAmt");
}
if (map.get("stdDeduction") != null) 
{
	stdDeduction = (BigDecimal)map.get("stdDeduction");
}
if(map.get("chargeCodeList") != null)
{
	chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
}
if (map.get("regChargeId") != null) 
{
	regChargeId =  (Integer)map.get("regChargeId");
}
if(map.get("authorizerList") != null)
{
	authorizerList = (List<MasAuthorizer>)map.get("authorizerList");
}
if(request.getAttribute("map") != null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}

if (map.get("complaintList") != null) 
{
	complaintList = (List<MasComplaint>) map.get("complaintList");
}
if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}


if (map.get("caseTypeList") != null) 
{
	caseTypeList = (List<MasCaseType>) map.get("caseTypeList");
}

if (map.get("billNo") != null) 
{
	billNo = (String) map.get("billNo");
}
if(map.get("amount")!=null)
{
	amount=(BigDecimal)map.get("amount");
}
if(map.get("availableCredit")!=null)
{
	availableCredit=(BigDecimal)map.get("availableCredit");
}

if(map.get("schemeList")!=null)
{
	schemeList=(List<MasScheme>)map.get("schemeList");
}
if(null !=map.get("uhid") && !map.get("uhid").equals("null")){
	searchUhid=(String)map.get("uhid");
	
}
if(null !=map.get("fullName") && !map.get("fullName").equals("null")){
	fullName=(String)map.get("fullName");
	
}
String searchmobno="";
if(null !=map.get("mobno") && !map.get("mobno").equals("null")){
	searchmobno=(String)map.get("mobno");
}

String pUhid=null;
int visitNo=0;
if(map.get("pUhid") != null && !map.get("pUhid").equals(""))
{
	pUhid = (String)map.get("pUhid");
}
BigDecimal mas_charge_code_rate=new BigDecimal("0.0");

if(map.get("mas_charge_code_rate") != null )
{
	mas_charge_code_rate = (BigDecimal)map.get("mas_charge_code_rate");
}
int FromAge = 0;
int toAge = 0;
if(map.get("toAge") != null )
{
	toAge = Integer.valueOf((String)map.get("toAge"));
	
}
if(map.get("FromAge") != null )
{
	FromAge = Integer.valueOf((String)map.get("FromAge"));
	System.out.println("FromAge SS "+FromAge);
}

String lastVisitDate="";
String lastUnit="";
String docotorIncharge="";
String dutyDoctor="";
String departmentName="";
if(null!=visitList && !visitList.isEmpty()){
for(Visit visit:visitList){
	lastVisitDate=""+visit.getVisitDate();
	dutyDoctor=visit.getDoctor()!=null?visit.getDoctor().getEmployeeName():"";
	departmentName=visit.getDepartment()!=null?visit.getDepartment().getDepartmentName():"";
}

}

List<AppPatientAppointments> patientAppointList = new ArrayList<AppPatientAppointments>();
if(map.get("patientAppointList") != null){
	patientAppointList = (List<AppPatientAppointments>)map.get("patientAppointList");
}
List<OpdPatientDetails> patientReferalList = new ArrayList<OpdPatientDetails>();
List<OpdPatientDetails> patientReferalListForInternal = new ArrayList<OpdPatientDetails>();
List<Object[]> hospitalReferes = new ArrayList<Object[]>();

if(null !=map.get("patientReferalList")){
	
	patientReferalList=(List<OpdPatientDetails>)map.get("patientReferalList");
}
if(map.get("patientReferalListForInternal") != null){
	
	patientReferalListForInternal=(List<OpdPatientDetails>)map.get("patientReferalListForInternal");
}
System.out.println("patientReferalListForInternal==="+patientReferalListForInternal.size());
//added by govind 22-10-2016
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}

//Changed by Arbind on 24-04-2016
//String antCode  = properties.getProperty("empDeptCodeForAnt"); //added by govind 22-10-2016 end 
String antCode  = properties.getProperty("empDeptCodeForGYNE");

String immunCode  = properties.getProperty("empDeptCodeForImmu");//added by arbind 10-01-2017 end 
String obsGynecDept  = properties.getProperty("deptCodeAnteNatalClinic");
String patientHinNum="";
if(session.getAttribute("patientHinNum")!=null && session.getAttribute("patientHinNum")!=""){
	patientHinNum=String.valueOf(session.getAttribute("patientHinNum"));
}
%>
<!--Commented by kishore on 19th mar start -->
<!-- <h2>Patient Search (Re-Visit)</h2> -->
<!--Commented by kishore on 19th mar end -->
<div class="titleBg"><h2>Patient Visit</h2></div>
<%-- <body onclick="pVisitDetails('<%=patientHinNum%>')"></body> --%>
<form name="search" method="post"
	action="/hms/hms/registration?method=showSearchPatientRecordsJsp">
	<div class="Block" style="padding-bottom:0;">
	<input type="button" name="Submit11" class="buttonBig"
				value="QR/Bar Scan" tabindex="2" class="buttonkl"
				onClick="aadhaar()" />
				<div class="clear"></div>
		<label>UHID</label> 
		<%if(searchUhid!=null && !searchUhid.equals("")){ %>
		<input type="text" tabindex="2"
			name="<%=HIN_NO %>" maxlength="25" value="<%=searchUhid %>"
			onkeypress="return searchKeyPress(event);"  id="hinNo1"/> 
			<%}else{ %>
		<input type="text" tabindex="2"
			name="<%=HIN_NO %>" maxlength="25" value=""
			onkeypress="return searchKeyPress(event);" id="hinNo1"/> 
				
			<%} %>
			<label> Name</label> <input
			type="text" id="pFirstNameId" name="<%=P_FULL_NAME %>" value="<%=fullName %>"
			tabindex="2" title=" Name of the Patient" validate="" MAXLENGTH="50"
			onkeypress="return searchKeyPress(event);" /> <label>LSG
			Name </label> <select name="<%=LSG_NAME %>" id="lsgNameId" tabindex="2"
			validate="LSG Name,metachar,no">
			<option value="0">Select</option>
		</select>
		<div class="clear"></div>
		<label>Ward</label> <input type="text" name="<%=WARD %>" value=""
			maxlength="32" tabindex="2" id="wardId" onblur="" /> <label>Locality</label><select
			name="<%=LOCALITY %>" id="locality" tabindex="2">
			<option value="0">Select</option>
		</select> <label>House No.</label> <input type="text" name="<%=HOUSE_NO %>"
			value="" maxlength="32" tabindex="2" id="houseId" onblur="" />
		<div class="clear"></div>
		<label>DOB</label> <input type="text" id="dobId" name="dob"
			tabindex="2" value="" class="date" readonly="readonly" MAXLENGTH="30" validate="DOB,date,no"/>

		<div id="dobcalId">
			<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0"
				onclick="setdate('<%=currentDate %>',document.search.dob,event)"
				validate="currentDate,date,no" tabindex="2" />
		</div>

		<input type="hidden" tabindex="2" name="dobIdTemp" id="dobIdTemp"
			value="" /> <label>Age From</label><select name="fromAge" validate="Age,int,no" id="fromAge"
			tabindex="2">
			<option value="">select</option>
			<%for (int i=0;i<150;i++){ if(FromAge==i && FromAge>0){%>

			<option value="<%=i%>" selected="selected"><%=i%></option>
			<%}else{%>
			<option value="<%=i%>"><%=i%></option>
				<%}}%>
			
		</select> <label>To</label> <select name="toAge" tabindex="2" validate="To Age,int,no" id="toAge">
			<option value="">select</option>
			<%for (int i=1;i<150;i++){if(toAge==i){%>
<option value="<%=i%>" selected="selected"><%=i%></option>
			<%}else{%>
			<option value="<%=i%>"><%=i%></option>
			<%}}%>
		</select>
		<div class="clear"></div>
		<label>Mobile No</label> <input type="text" tabindex="2" name="mobno" id="mobno"
			maxlength="10" value="<%=searchmobno %>" onkeypress="return searchKeyPress(event);" />

		<label>Land Line No.</label> <input type="text" tabindex="2" id="llno1"
			name="llno1" class="" /> <label>Ration
			Card No.</label><input type="text" tabindex="2" style="margin-right: 10px;"
			name="rationCardno" id="rationCardno"/>
		<div class="clear"></div>

		<input type="button" tabindex="2" id="btnSearchvisit" value="Search"
			class="button"
			onclick="if(checkSearchField()){submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&visitSearch=serch')}" />
		<input type="reset" tabindex="2" name="Reset" value="Cancel"
			class="button"
			onclick="submitProtoAjax('search','registration?method=getPatientName')"
			accesskey="r" /> 
			
			 <input type="button" id="btnSearch"
			class="buttonBig" value="Referral List"
			onclick="submitForm('search','/hms/hms/registration?method=showPatientReferalList')" /> 
			
			 <input type="button" id="btnSearch"
			class="inputButtonAutu" value="Investigation Appointment List"
			onclick="submitForm('search','/hms/hms/registration?method=showPatientInvestigationApp')" /> 


 <input type="button" id="btnSearch"
			class="inputButtonAutu" value="Nursing Appointment List"
			onclick="submitForm('search','/hms/hms/registration?method=showNursingAppointmentList')" /> 

	<div class="clearMargin"></div>
	<div class="division"></div>

	<%if(map.get("patientAppointList") != null){
	if(null !=patientAppointList && patientAppointList.size()>0){%>
	<table>
		<tr>
			<th>UHID</th>
			<th>Patient Name</th>
			<th>Department</th>
			<th>Hospital</th>
			<th>Appointment Date</th>
		</tr>
		<%int appId=0;
	String hinNo="";
	String patientname="";
	String department="";
	int departmentId=0;
	String hospital="";
	
	String st="";
	Iterator iterator=patientAppointList.iterator();
	while(iterator.hasNext())
	{
	AppPatientAppointments patientAppointments= (AppPatientAppointments) iterator.next();
	appId=patientAppointments.getId();
	patientname=patientAppointments.getPatientName();
	department=patientAppointments.getDepartment().getDepartmentName();
	departmentId=patientAppointments.getDepartment().getId();
	
	hospital=patientAppointments.getHospital().getHospitalName();
	hinNo=patientAppointments.getHin().getHinNo();%>
		<tr onclick="pVisitDetailsList('<%=appId%>','<%=hinNo%>','<%=departmentId%>','<%=department%>','yes');HighLightTR(this)" style="cursor: pointer;">
			<td><%=hinNo%></td>
			<td><%=patientname%></td>
			<td><%=department%></td>
			<td><%=hospital%></td>
			<td><%=HMSUtil.convertDateTypeToStringWithoutTime(patientAppointments.getAppointmentDate()) %>
			</td>

		</tr>
		<%}%>
	</table>
	<%}else{%>
	<font size="4" color="black">No Appointment Available For The Current Date </font>
	<%}} %>
	
	
	<%
			List<Object[]> appInvestList=new ArrayList<Object[]>();
		
	if(null !=map.get("appInvest")){
		appInvestList=(List<Object[]>)map.get("appInvest");
		
		
		if(null !=appInvestList && appInvestList.size()>0){%>
			<table>
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Appointment Date</th>
			<th>Equipment</th>
			<th> Department</th>
		</tr>
		<%for(Object[] obj:appInvestList) 
		{
		%>
	<tr onclick="populateInvestigationPatientDetail('<%=obj[2]%>','<%=obj[7]%>');HighLightTR(this)" style="cursor: pointer;">
	<td><%=obj[2] %></td>
	<td><%=obj[1] %></td>
	<td><%=obj[3]%></td>
	<td><%=obj[6]%></td>
	<%-- <td><%=HMSUtil.convertDateTypeToStringWithoutTime(Investigation.getInvestigationDate())%></td> --%>
	<td><%=obj[4]%></td>
	<td><%=obj[5]%></td>
	<td><%=obj[8]%></td>
		</tr>	
			
		<% }%>
		</table>
		<%}else{%>
		<font size="4" color="red">No any appointment for today </font>
<%}}%>
	
	<% List<Object[]> phDiseaseRegistrationFollowList = new ArrayList<Object[]>();
		if(null !=map.get("patientReferalList") || null !=map.get("phDiseaseRegistrationFollowList") || map.get("hospitalReferes")!=null || map.get("patientReferalListForInternal") != null ){ %>
			<table id='refferalGrid'>
			<tr>
				<th>UHID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Refered Date</th>
				<th>Refred From</th>
				<th>Refred Department</th>
				<th>Reason</th>
				<th style="display:none">Reffered Type</th>
			</tr>
			<% 
			patientReferalList=(List<OpdPatientDetails>)map.get("patientReferalList");
			hospitalReferes=(List<Object[]>)map.get("hospitalReferes");
			
			phDiseaseRegistrationFollowList=(List<Object[]>)map.get("phDiseaseRegistrationFollowList");
			%>
			<%
			if(null !=patientReferalList && patientReferalList.size()>0){
				for(OpdPatientDetails refredPatient:patientReferalList){
			%>
			<tr onclick="populateReferalPatientDetail('<%=refredPatient.getVisit().getHin().getHinNo()%>','<%=refredPatient.getVisit().getHin().getPFirstName() %>','<%=refredPatient.getVisit().getId() %>');HighLightTR(this);getReffaralType()" style="cursor: pointer;">
			<td><%=refredPatient.getVisit().getHin().getHinNo() %></td>
			<td><%=refredPatient.getVisit().getHin().getPFirstName() %></td>
			<td><%=refredPatient.getVisit().getHin().getSex().getAdministrativeSexName()%></td>
			
			<%if(null !=refredPatient.getVisit().getHin().getAge()){ %>
			<td><%=refredPatient.getVisit().getHin().getAge() %></td>
			<%}else{ %>
			<td></td>
			<%} %>
			<td><%=HMSUtil.convertDateTypeToStringWithoutTime(refredPatient.getReferedDate()) %></td>
			<td><%=refredPatient.getHospital().getHospitalName() %></td>
			<%if(null !=refredPatient.getReferedDepartment()){ %>
			<td><%=refredPatient.getReferedDepartment().getDepartmentName() %></td>
			<%}else{%>
				<td></td>
			<%}%>
				<td></td>
				<td style="display:none"><%=refredPatient.getReferredType() %></td>
			<%}
			}
			
			if(null !=patientReferalListForInternal && patientReferalListForInternal.size()>0){
				for(OpdPatientDetails refredPatientForInternal :patientReferalListForInternal){
			%>
			<tr onclick="populateReferalPatientDetail('<%=refredPatientForInternal.getVisit().getHin().getHinNo()%>','<%=refredPatientForInternal.getVisit().getHin().getPFirstName() %>','<%=refredPatientForInternal.getVisit().getId() %>');HighLightTR(this);getReffaralType()" style="cursor: pointer;">
			<td><%=refredPatientForInternal.getVisit().getHin().getHinNo() %></td>
			<td><%=refredPatientForInternal.getVisit().getHin().getPFirstName() %></td>
			<td><%=refredPatientForInternal.getVisit().getHin().getSex().getAdministrativeSexName()%></td>
			
			<%if(null !=refredPatientForInternal.getVisit().getHin().getAge()){ %>
			<td><%=refredPatientForInternal.getVisit().getHin().getAge() %></td>
			<%}else{ %>
			<td></td>
			<%} %>
			<td><%=HMSUtil.convertDateTypeToStringWithoutTime(refredPatientForInternal.getReferedDate()) %></td>
			<td><%=refredPatientForInternal.getHospital().getHospitalName() %></td>
			<%if(null !=refredPatientForInternal.getReferedDepartment()){ %>
			<td><%=refredPatientForInternal.getReferedDepartment().getDepartmentName() %></td>
			<%}else{%>
				<td></td>
			<%}%>
				<td></td>
				<td style="display:none"><%=refredPatientForInternal.getReferredType() %></td>
			<%}
			}
			
			
			
			//hrf.ref_date hos.hospital_name,hrf.ref_reason
			if(null !=hospitalReferes && hospitalReferes.size()>0){
				String uhidno,name,age="",sex,hospitalName,refreason;
				Date refDate=null;
				for(Object[] obj:hospitalReferes){
					uhidno=(String)obj[0];
					name=(String)obj[1];
					sex=(String)obj[2];
					age=HMSUtil.calculateAge((Date)obj[3]);
					refDate=(Date)obj[4];
					hospitalName=(String)obj[5];
					refreason=(String)obj[6];
			%>
			<tr onclick="populateReferalPatientDetail('<%=uhidno%>','<%=name %>',0);HighLightTR(this)" style="cursor: pointer;">
			<td><%=uhidno!=null?uhidno:"Not registered"%></td>
			<td><%=name%></td>
			<td><%=sex%></td>
			<td><%=age%></td>
			<td><%=refDate%></td>
			<td><%=hospitalName%></td>
			<td></td>
			<td><%=refreason%></td>
			<%}
			}
			
			if(null !=phDiseaseRegistrationFollowList && phDiseaseRegistrationFollowList.size()>0){
				String uhidNo="";
				for(Object[] refredPatient:phDiseaseRegistrationFollowList){
					uhidNo=(String)refredPatient[3];
					%>
					<tr onclick="populateReferalPatientDetail('<%=uhidNo%>','<%=refredPatient[0]%>',0);HighLightTR(this)" style="cursor: pointer;">
					<%if(null !=uhidNo && !uhidNo.equals("")){ %>
					<td><%=uhidNo %></td>
					<%}else{ %>
					<td></td>
					<%} %>
					<td><%=refredPatient[0]%></td>
					<td><%=refredPatient[1]%></td>
					<td></td>
					<td><%=HMSUtil.convertDateTypeToStringWithoutTime((Date)refredPatient[4]) %></td>
					
					<td><%=refredPatient[2] %></td>
					<td></td>
					<td><%=refredPatient[5] %></td>
			<%}}
			
			%>
			</tr>
			</table>
		<% }%>
		
		<%
		List<Visit> visitForInvestList=new ArrayList<Visit>();
		if(null !=map.get("pendingNursingList")){
			
			visitForInvestList=(List<Visit>)map.get("pendingNursingList");
			
			%>
			<%
			if(null !=visitForInvestList && visitForInvestList.size()>0){%>
			
			<table>
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Appointment Date</th>
			
			<th> Department</th>
		</tr>
			<%
				for(Visit refredPatient:visitForInvestList){
			%>
			<tr onclick="populateNursingPatientAppointment('<%=refredPatient.getHin().getHinNo()%>','<%=refredPatient.getId()%>');HighLightTR(this)" style="cursor: pointer;">
			<td><%=refredPatient.getHin().getHinNo()%></td>
			<td><%=refredPatient.getHin().getFullName() %></td>
			<td><%=refredPatient.getHin().getSex().getAdministrativeSexName() %></td>
			<%if(null !=refredPatient.getHin().getAge() && !refredPatient.getHin().getAge().equals("")) {%>
			<td><%=refredPatient.getHin().getAge()%></td>
			<%}else{ %>
			<td></td>
			<%} %>
			
			<td><%=HMSUtil.convertStringTypeDateToDateType(currentDate)%></td>
			
			
			
				<td>Nursing Station</td>
			</tr>
				
			<%}}
			else{%>
			<font size="4" color="red">No any patient referal list for today </font>
		<% }
			%>
			</table>
		<% }%>
		
		
	
	<%List<Patient> searchDataList=new ArrayList<Patient>();
String pname="";
String pgender="";
String patientage="";
String pstatus="";

int currentPage=0;
int noOfPages=0;

String shinNo = "";
String sfullName ="";
String smobNo="";
String sdateOfBirth="";

String houseNo="";
String streetName="";
String District="";
String taluk="";

String address="";

Map<Integer,Object> addressmap=new HashMap<Integer,Object>();
List<PatientAddress> searchAddressList = new ArrayList<PatientAddress>();
if(null!=map.get("addressmap")){
	addressmap=(Map<Integer,Object>)map.get("addressmap");
}

if(null !=map.get("currentPage")){
currentPage=(Integer)map.get("currentPage");
shinNo=(String)map.get("shinNo");
sfullName=(String)map.get("sfullName");

smobNo=(String)map.get("smobNo");
noOfPages=(Integer)map.get("noOfPages");
sdateOfBirth=""+(Date)map.get("sdateOfBirth");
}
String visitSearch="";
if(null !=map.get("visitSearch")){
	visitSearch=(String)map.get("visitSearch");
}
	if(null !=map.get("searchDataList")){
		searchDataList=(List<Patient>)map.get("searchDataList");
	
	if(null !=searchDataList && searchDataList.size()>0){%>

	<table class="tableTrhighlights">
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>UHID Print Status</th>
		</tr>
		<%for(Patient patient:searchDataList){
			
			address=patient.getPatientAddress()!=null?patient.getPatientAddress():"";
			if(patient.getPFirstName()!=null)
			pname=patient.getPFirstName();
			if(null !=patient.getSex()){
			pgender=patient.getSex().getAdministrativeSexName();
			}
			if(null!=patient.getAge())
			patientage=String.valueOf(patient.getAge());
			pstatus=patient.getStatus()!=null?patient.getStatus():"N";
			
			if(null!=addressmap.get(patient.getId())){
				if(null != searchAddressList){
					searchAddressList.clear();
				}
				 
			}%>
		<tr onclick="pVisitDetails('<%=patient.getHinNo()%>');HighLightTR(this)">
			<td><%=patient.getHinNo()%></td>
			<td><%=pname%></td>
			<td><%=pgender%></td>
			<td><%=patientage%></td>
			<td><%=address %></td>
			<td><%=pstatus%></td>
		</tr>
		<%}%>
	</table>
	<%
	if(currentPage !=1){%>
		<a href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage-1%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>&toAge=<%=toAge%>&fromAge=<%=FromAge%>&visitSearch=serch'>Previous</a>

	<%}

if(noOfPages>=1){
	//for(int i=1;i<=noOfPages;i++){
		//if(currentPage==i){%>
<%-- 	<%=i%> --%>
<%-- 	<%//}else{%> --%>

	<a
		href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>&toAge=<%=toAge%>&fromAge=<%=FromAge%>&visitSearch=serch'><%=currentPage%></a>
	<%
	//}}
}
if(currentPage <noOfPages){%>

	<a
		href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage+1%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>&toAge=<%=toAge%>&fromAge=<%=FromAge%>&visitSearch=serch'>Next</a>
	
	<%}%>
	<div class="Block">
	<!-- added by govind 10-11-2016 --><input type="text" id="inPage" tabindex="2"
	maxlength="4" style="width:30px;"/><input type="button" value="Go" tabindex="2" onclick="searchParticularPage(1);"/> 
	<label> No of Pages :  <%=noOfPages%></label><!-- added by govind end-->
   </div>
	<%}

	else{ if( patientDeadStatus.equals("")){%>
	<!-- <h4>No Record Found</h4> -->
	<font size="4" color="red">No Record Found </font>
	<%}else{%>
	<font size="4" color="red">Expired Person </font>
	<%}}}%>
	 

<%
List<Patient> currentRegistrationList=new ArrayList<Patient>();
if(null !=map.get("visitSearch")){
	visitSearch=(String)map.get("visitSearch");
}

if(null !=map.get("currentRegistrationList")){
	currentRegistrationList=(List<Patient>)map.get("currentRegistrationList");
	
	if(null !=currentRegistrationList && currentRegistrationList.size()>0){%>

	<table class="tableTrhighlights">
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>UHID Print Status</th>
		</tr>
		<%for(Patient patient:currentRegistrationList){
			address=patient.getPatientAddress();
			
			if(patient.getPFirstName()!=null)
			pname=patient.getPFirstName();
			if(null !=patient.getSex()){
			pgender=patient.getSex().getAdministrativeSexName();
			}
			if(null!=patient.getAge())
			patientage=String.valueOf(patient.getAge());
			pstatus=patient.getStatus()!=null?patient.getStatus():"N";
			
			if(null!=addressmap.get(patient.getId())){
				if(null != searchAddressList){
					searchAddressList.clear();
				}
			}%>
		<tr onclick="pVisitDetails('<%=patient.getHinNo()%>');HighLightTR(this)">
			<td><%=patient.getHinNo()%></td>
			<td><%=pname%></td>
			<td><%=pgender%></td>
			<td><%=patientage%></td>
			<td><%=address %></td>
			<td><%=pstatus%></td>
		</tr>
		<%}%>
	</table>
	<%
	if(currentPage !=1){if(visitSearch.equalsIgnoreCase("")){%>

	<a href='/hms/hms/registration?method=paginationForPatientVisitJsp&page=<%=currentPage-1%>&visitSearch='>Previous</a>
	<%}%>	
	<%}

if(noOfPages>=1){
	//for(int i=1;i<=noOfPages;i++){ added by govind 22-11-2016
		//if(currentPage==i){%>
<%-- 	<%=i%> --%>
	<%//}//else{ if(visitSearch.equalsIgnoreCase("")){%>

	<a
		href='/hms/hms/registration?method=paginationForPatientVisitJsp&page=<%=currentPage%>&visitSearch='><%=currentPage%></a>
	<%//}%>
	<%//}
	//}
}
if(currentPage <noOfPages){if(visitSearch.equalsIgnoreCase("")){%>
	<a href='/hms/hms/registration?method=paginationForPatientVisitJsp&page=<%=currentPage+1%>&visitSearch='>Next</a>

	<%}
	
	}%>
<div class="Block">
<!-- added by govind 22-11-2016 --><input type="text" id="inPage2" maxlength="4" tabindex="2" style="width:30px;"/><input type="button" value="Go" onclick="searchParticularPage(2);"/> <label> No of Pages :  <%=noOfPages%></label><!-- added by govind end-->
</div>
	<%}
	
	}%>
</div>	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	

<script type="text/javascript">
	function showLastVisitDetails() {
		var deptId = document.getElementById('deptId').value;

		var hinNo = document.getElementById('pUhidId').value
		showLastVisitDetailsInAjax('patientVisitSearch', deptId, hinNo);
	}
</script>

<%if(map.get("patientDetailsList")!=null){
	patientDetailsList=(List<Patient>)map.get("patientDetailsList");
	
}
if(map.get("visitNo")!=null){

	visitNo=(Integer)map.get("visitNo");
}
if(map.get("patientvisitNum")!=null){

	visitNo=(Integer)map.get("patientvisitNum");
}
String pathh="";
if(map.get("pathh")!=null){
	
	pathh=(String)map.get("pathh");
	
}
String phinNo="";

if(map.get("hinNo")!=null){
	
	phinNo=(String)map.get("hinNo");
	
}

	int uhid=0;
   String pName="";
   String gender="";
   String age="";
   String nameOf="";
   String relationName="";
   String occupation="";
   String mobileNo="";
   String category="";
   int billNumber=0;
   String patientTypeId="";
   String patientTypeIdd="";
   String UHID="";
   if(map.get("hinNo")!=null){
		
	   UHID=(String)map.get("hinNo");
		
	}

if(patientDetailsList.size()>=0){
	for(Patient patient:patientDetailsList){
		if(null !=UHID && !UHID.equals(""))
		UHID=patient.getHinNo();
		uhid=patient.getId();
		pName=patient.getFullName();
		if(null !=patient.getSex())
		gender=patient.getSex().getAdministrativeSexName();
		if(null !=patient.getAge() && !patient.getAge().equals(""))
		age=patient.getAge();
		if(null!=patient.getRelation()){
		nameOf=patient.getRelation().getRelationName(); 
		}
		if(null !=patient.getFatherMotherName())
		relationName=patient.getFatherMotherName();
		/* occupation=patient.getOccupation().getOccupationName(); */
		if(null !=patient.getMobileNumber())
		mobileNo=patient.getMobileNumber();
		/* billNumber=patient.getBillNo(); */
		if(null !=patient.getPatientType()){
		patientTypeId=patient.getPatientType().getPatientTypeName();
		patientTypeIdd=""+patient.getPatientType().getId();
		}
	}
}%>
<body onload="patientVisitSearch.reset();">
<form name="patientVisitSearch" method="post">
<div class="Block" style="padding:0;">
<input type="hidden" value="" name="appFlag" id="appFlag"/>
	<input type="hidden" value="" name="appdepId" id="appdepId"/>
	
<div id="imagePatient" align="right" class="patientProfileImg" style="margin-top: 25px">
<%if(!phinNo.isEmpty()){
	
%>
	<img id="imageIDDd" align="right" src="<%=pathh %>"  width="100px"
		height="90px">  
		<%}else{ 
			
		%>
		<img id="imageIDD" align="right" src="../jsp/images/default_profile.jpg"  width="100px"
		height="90px"> 
		
		<%} %>
</div>
<div class="patientProfileLeftdiv">
<h4>Patient Details</h4>
<!-- <div style="display: none" id="patientStatusDiv">
<label id="patientStatus" class="autoSpace"></label>
</div> -->
<div class="clear"></div>
		<label>UHID<span>*</span></label> <input type="text" tabindex="2" name="hinNO"
			id="pUhidId" maxlength="20" value="<%=UHID %>" validate="UHID,metachar,yes" readonly="readonly" />

		    <input type="hidden" tabindex="2" name="hinNO" id="pUhidId"
			maxlength="16" value="<%=uhid %>" readonly="readonly" />
			 <input
			type="hidden" tabindex="2" id="hinId" name="patientHinId"
			value="<%=uhid %>" />
			
			 <input
			type="hidden" tabindex="2" id="previousVisitId" name="previousVisitId"
			value="" />
			 <input
			type="hidden" tabindex="2" id="lastVisitId" name="lastVisitId"
			value="" />
			
			 <input type="hidden" tabindex="2" name="referalStatus" id="referalStatusId"  value=""  />
			 <input type="hidden" tabindex="2" name="referalType" id="referalTypeId"  value=""  />
			<%
			if(null !=visitForInvestList && visitForInvestList.size()>0){%>
			<input type="hidden" id="" value="nursing" name="nursingStation"/>
			<%} %>
			 <label>Patient Name</label> <input type="text"
			tabindex="2" name="pnameId" id="pnameId" maxlength="50" validate="Patient Name,metachar,yes"
			value="<%=pName %>" readonly="readonly" style="width: 310px;" />			
			<div class="clear"></div>
			<label>Gender</label><input
			type="text" tabindex="2" name="gender" id="genderId" value="<%=gender%>"
			readonly="readonly" />
			<label>Age</label> <input type="text" tabindex="2" name="age"
			id="ageId" maxlength="3" value="<%=age %>" readonly="readonly" />			
		
		<div id="searchbar">
			<div id="edited"></div>
			<!-- <input type="button" name="Submit11" class="buttonBig"
				value="QR/Bar Scan" tabindex="2" class="buttonkl"
				onClick="aadhaar()" /> -->
		</div>
<div class="clear"></div>
		<label>Name Of</label>
			<input type="text" tabindex="2" name="" id="relationId"
			value="<%=nameOf%>" readonly="readonly" /> <input class="date" type="text"
			tabindex="2" name="formname" id="relationNameId"
			value="<%=relationName %>" maxlength="50" readonly="readonly" style="width: 346px; margin-left:4px;" />
</div>		
			<div class="clear"></div>
			<label>Mobile No</label> <input type="text" tabindex="2" name="mobno"
			id="mobileNoId" value="<%=mobileNo %>" maxlength="10" readonly="readonly" />
			
		
		<label>Category</label> <input type="text" tabindex="2"
			name="<%=PATIENT_TYPE_ID %>" id="categoryId"
			value="<%=patientTypeId %>" readonly="readonly" /> <input
			type="hidden" tabindex="2" name="patientTypeName" validate="patientType,metachar,no"
			id="patientTypeNameId" value="<%=patientTypeIdd %>"
			readonly="readonly" /> <label>Occupation</label>
		<input type="text" tabindex="2" name="occupation" id="occupationId" validate="occupation,metachar,no"
			value="<%=occupation %>" maxlength="25" readonly="readonly" />
<div class="clear"></div>
</div>	
<div class="Block" style="padding:0;">
<h4>Visit Details</h4>
			<label>Visit No</label> <input type="text" tabindex="2"
				name="<%=VISIT_NUMBER %>" id="visitNoId" value="<%=visitNo %>"
				readonly="readonly" /> <label>Visit Date</label> <input
				type="text" validate="Visit Date,date,no" tabindex="2" name="<%=VISIT_DATE%>"
				value="<%=currentDate %>" readonly="readonly" /> <label>Visit
				Time</label> <input type="text" tabindex="2" name="<%=VISIT_TIME%>"
				value="<%=currentTime %>" readonly="readonly" />
			<div class="clear"></div>
			<label>Complaint Type</label> <select id="compltId" tabindex="2"
				name="<%=COMPLAINT_ID%>" validate="Complaint,metachar,no"
				tabindex="39">
				<option value="0">Select</option>
				<%for(MasComplaint masComplaint : complaintList)
		{%>
				<option value="<%=masComplaint.getId() %>"><%=masComplaint.getComplaintName()%></option>
				<%}%>
			</select>
			<% 
				if(session.getAttribute("prevDoctorVisit")!=null){
					%>
					<input type="checkbox" class="checkboxMargin" name="prevDoctorVisit" value="y" id="prevDoctorVisit" checked="checked" onclick="changeDrValue(this,'visit');">
				<%}else{
			%>
			<input type="checkbox" class="checkboxMargin" name="prevDoctorVisit" value="y" id="prevDoctorVisit" onclick="changeDrValue(this,'visit');">
			<%} %>
			
			<label style="width:131px;">Visit for Last Doctor</label>
			<input type="hidden" id="hospitalNameId" name="hospitalNameId" value="<%=hospitalId %>"/>
			<div class="clear"></div>
			<label>Service Center</label>
			<input type="radio" name="serviceCenter" checked="checked" id="opClinicServiceCenter" value="OP Clinic Service Center" 
			onclick="getServiceCentersList('op clinic');" style="margin:0px 6px 5px 5px"/>
			
			
			
			<label>Op Clinic  Service Center</label>
			<input type="radio" name="serviceCenter" id="otherServiceCenter" value="Other Service Center" 
			onclick="getServiceCentersList('other');" class="checkboxMargin"/>
			<input type="hidden" id="otherdeptId" value="0"/>
			
			
			<div id="opDeptDiv">
			<label style="width: 131px">Other Service Centre</label>
			<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="2" onchange="getSessionForDepartment(this.value); populateUnitForDepartment(this.value,'unit','loddrs','deptId','visit');getEmployeeDepartment(this.value);" validate="Service Center,string,no"
			style="background: #fdfd5f">
			<option value="0">Select</option>
			<%int departmentId = 0;
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%> 
			</select>
			
			<input type="hidden" name="empDeptCode" id="empDeptCodeId" value="" />
			</div>
			
			<div id="otherDeptDiv" style="display:none">
			<label style="width: 129px">Other Service Centre</label>
			<select id="othercenterId" name="<%=PATIENT_DEPARTMENT %>" tabindex="2" onchange="getSessionForDepartment(this.value); populateUnitForDepartment(this.value,'unit','loddrs','othercenterId','visit');getEmployeeDepartment(this.value);" validate="Service Center,string,no"
			style="background: #fdfd5f">
			<option value="0">Select</option>
			</select>
			</div>
			
			<label>OP Session<span>*</span></label>
			<select id="opsession" name="opsession" validate="Session,string,yes" tabindex="10"></select>
			<label>Unit</label> <select id="unit"
				name="unit" tabindex="2" validate="unit,metachar,no"onchange="populateDoctorForUnit(this.value,'visit','deptId')">
				<option value="">Select</option>
			</select>

			 <label>Doctors Incharge</label> 
			 <input type="text" name="<%=EMPLOYEE_ID %>" id="consultingDocId" value="" readonly="readonly" tabindex="2" validate="Doctors Incharge,metachar,no" />
 
			<label> Doctors</label> <select name="loddrs" id="loddrs"
				tabindex="2" title="" validate="loddrs,metachar,no" onchange="getAssignedPatientForDoctorSpecific(this.value)">
				<option value="">select</option>
			</select>
			<input name="patientCount" id="patientCount" value="" readonly="readonly" style="text-align: center;font-size:15px;width:25px;margin-left:0;background:#5bc0de;"/>			
			<div class="clear"></div>	
			<label>Current Proirity No.</label> <select id="priorityId"
				name="priorityName" tabindex="2">
				<option value="3">3</option>
				<option value="2">2</option>
				<option value="1">1</option>
			</select>
			<div class="clear"></div>
			<div id="lastVisitDetailsId">
				<h4>Last Visit Details</h4>
				<div class="clear"></div>

				<label>Date :</label><input type="text" tabindex="2"
					id="lastVisitDateId" name="lastVisitDate"
					value="<%=lastVisitDate %>" readonly="readonly" class="readOnly" />

				<label>Service centre :</label><input type="text" tabindex="2"
					id="visitdepartmentId" name="departmentIdName" value=""
					readonly="readonly" class="readOnly" /> 
					
					<label>Doctors :</label><input
					type="text" tabindex="2" id="lastVisitDoctorsIncharge" value=""
					name="lastVisitDoctorsIncharge" readonly="readonly"
					class="readOnly" />
					
					<input type="hidden" tabindex="2"
					id="lastVisitedDeptId" name="lastVisitedDeptId" value=""
					readonly="readonly" class="readOnly" /> 
					
					<input type="hidden" tabindex="2"
					id="lastVisitedDrId" name="lastVisitedDrId" value=""
					readonly="readonly" class="readOnly" /> 
					
					<input type="hidden" tabindex="2"
					id="lastVisitedUnitId" name="lastVisitedUnitId" value=""
					readonly="readonly" class="readOnly" />
					
				<div class="clear"></div>
				<%-- <label>Duty Doctor :</label><input type="text" id="lastVisitDutyDoctorId" value="<%=dutyDoctor %>" name="lastVisitDutyDoctor" readonly="readonly"  class="readOnly"/>--%>
			</div>
<div class="clear"></div>
</div>
<input type="hidden" name="onlineRegStatus" value="" id="onlineRegStatusID" />
<div class="Block" style="padding-top:0;">
<h4>Bill Details</h4>		
		<div class="clear"></div>
				<label>Scheme</label>
				<select name="Visitscheme" id="VisitschemeId" tabindex="2" onchange="patientVisitscheme(this.value)" >
				<option value="0">Select</option><%
					
				if(null != schemeList){
					for(MasScheme scheme:schemeList){%>
						<option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
					<% }
				}
				%>				
				</select>			
				
			<label>Cash Received</label> <input type="checkbox" tabindex="1" 
				name="cashreceived" id="cashreceived" value="y" onclick="cashNotReceived()" style=" margin: 0px 5px; "/> 
			<div id="cashNotReceived" style="display: block;">	
				<label>Reason</label> <select id="cashReason"
					name="cashReason" style="margin-left: 3px; width: 162px;" tabindex="1">
					<option value="">Select</option>
					<option value="Accident">Accident</option>
					<option value="Medico Legal">Medico Legal</option>
					<option value="Staff">Staff</option>
					<option value="Foreigner">Foreigner</option>
					<option value="UnKnown Patient">UnKnown Patient</option>
					<option value="Below 18 Years">Below 18 Years</option>
				</select>
			</div>
<div class="clear"></div>
			<label> Charge</label> <select name="registrationType"
				id="registrationTypeId" tabindex="2"
				onchange="populateChargeAmout()">
				<option value="0">Select</option>
				<%for(MasChargeCode masChargeCode : chargeCodeList)
		{
			if(masChargeCode.getId()==regChargeId || masChargeCode.getId()== nVisitId)
			{%>
				<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
				<%}
		}%>
			</select>
			<script type="text/javascript">
			function getReffaralType(){
				 document.getElementById('refferalGrid').onclick = function(event){
			        event = event || window.event; //for IE8 backward compatibility
			        var target = event.target || event.srcElement; //for IE8 backward compatibility
			        while (target && target.nodeName != 'TR') {
			            target = target.parentElement;
			        }
			        
			        var cells = target.cells; //cells collection
                    if(cells[8].innerHTML!="Reffered Type"){
                    	document.getElementById("referalTypeId").value=cells[8].innerHTML;
			        }
			        
			       
			    }
			    
			}
				function displayAuthorizedText(obj) {

					if (obj.checked) {

						document.getElementById("refDoctorId").style.display = 'block';
						document.getElementById("labelAuthorized").style.display = 'block';
						document.getElementById("cAdjustAmountId").disabled = true;
						document.getElementById("amountTenderedId").disabled = true;
						document.getElementById("balanceActuallyPaidId").disabled = true;
						document.getElementById("cAdjustAmountId").checked = false;
						document.getElementById("balanceActuallyPaidId").value = "";
						document.getElementById("amountTenderedId").value = "";
						document.getElementById('balanceToBePaidId').value = parseFloat(0);
						if (document.getElementById("adjustAmountId").value == "") {
							document.getElementById('revisedCreditBalanceId').value = parseFloat(document
									.getElementById("availableCreditBalanceId").value);
						} else {
							var x = parseFloat(document
									.getElementById('adjustAmountId').value);
							var y = parseFloat(document
									.getElementById("availableCreditBalanceId").value);
							var z = x + y;
							document.getElementById("availableCreditBalanceId").value = x
									+ y;
							document.getElementById('revisedCreditBalanceId').value = x
									+ y;
							document.getElementById("adjustAmountId").value = "";
						}
					} else {
						document.getElementById("refDoctorId").value = 0;
						document.getElementById("refDoctorId").style.display = 'none';
						document.getElementById("labelAuthorized").style.display = 'none';
						document.getElementById('refDoctorId').value = "";
						document.getElementById("cAdjustAmountId").disabled = false;
						document.getElementById("amountTenderedId").disabled = false;
						document.getElementById("balanceActuallyPaidId").disabled = false;
						document.getElementById('revisedCreditBalanceId').value = "";
						document.getElementById('balanceToBePaidId').value = parseFloat(document
								.getElementById("amountId").value);
					}
				}
			
				function displayAmountText(obj) {
					if (obj.checked) {
						
						document.getElementById("availableCreditBalanceId").style.display = 'block';
						document.getElementById("adjustAgainstCreditName").style.display = 'block';
						
						document.getElementById("adjustAgainstCreditName").value = '0.0';
						document.getElementById("labelcredit").style.display = 'block';
						if (document.getElementById('adjustAmountId').value == "") {
							document.getElementById('adjustAmountId').value = "";
							document.getElementById("adjustAmountId").disabled = false;

						} else {
							var x = parseFloat(document
									.getElementById('adjustAmountId').value);
							var y = parseFloat(document
									.getElementById("availableCreditBalanceId").value);
							var z = x + y
							document.getElementById("availableCreditBalanceId").value = x
									+ y;
							document.getElementById("adjustAmountId").disabled = false;
							document.getElementById("adjustAmountId").focus();
							document.getElementById('adjustAmountId').value = "";
							document.getElementById("balanceActuallyPaidId").disabled = false;
							document.getElementById("amountTenderedId").disabled = false;
							document.getElementById("revisedCreditBalanceId").value = "";
							document.getElementById("amountTenderedId").value = "";
							document.getElementById("balanceActuallyPaidId").value = "";
							document.getElementById('balanceToBePaidId').value = parseFloat(document
									.getElementById("amountId").value);
						}

					} else {
						document.getElementById("availableCreditBalanceId").style.display = 'none';
						document.getElementById("labelcredit").style.display = 'none';
						document.getElementById("adjustAmountId").disabled = true;
					}
				}

				function balanceToBePaidFunction(adjustAmount) {

					var availableCreditBalance = parseFloat(document
							.getElementById("availableCreditBalanceId").value);
					var adjustAmountId = parseFloat(adjustAmount);
					document.getElementById("cAdjustAmountId").checked = false;
					document.getElementById("adjustAmountId").disabled = true;

					if (adjustAmountId != NaN && adjustAmount != "") {
						if (availableCreditBalance >= adjustAmount) {
							var availableCredit = availableCreditBalance
									- adjustAmountId;
							document.getElementById("availableCreditBalanceId").value = availableCredit;
							var amountChargeable = parseFloat(document
									.getElementById("amountId").value);
							if (amountChargeable >= adjustAmountId) {
								document.getElementById("balanceToBePaidId").value = amountChargeable
										- adjustAmountId;
								document.getElementById("adjustAmountId").value = adjustAmountId;
								if ((amountChargeable - adjustAmountId) == 0) {
									document
											.getElementById("balanceActuallyPaidId").disabled = true;
									document.getElementById("amountTenderedId").disabled = true;
									document
											.getElementById("revisedCreditBalanceId").value = parseFloat(document
											.getElementById("availableCreditBalanceId").value);
								} else {
									document
											.getElementById("balanceActuallyPaidId").disabled = false;
									document.getElementById("amountTenderedId").disabled = false;
									document
											.getElementById("revisedCreditBalanceId").value = "";
								}
							} else {
								document.getElementById("cAdjustAmountId").checked = true;
								document.getElementById("adjustAmountId").disabled = false;
								document.getElementById("adjustAmountId").value = "";
								document.getElementById("adjustAmountId")
										.focus();
								document.getElementById("adjustAmountId").value = "";
								document
										.getElementById("availableCreditBalanceId").value = availableCreditBalance;
								alert("Adjusting Credit Balance More than Amount Chargeable is not necessary")
							}
						} else {
							alert("You can not adjust more than Available Credit Balance")
							document.getElementById("balanceToBePaidId").value = parseFloat(document
									.getElementById("amountId").value);
							document.getElementById("cAdjustAmountId").checked = true;
							document.getElementById("adjustAmountId").disabled = false;
							document.getElementById("adjustAmountId").value = "";
							document.getElementById("adjustAmountId").focus();

						}
					} else {
						alert("Enter Amount for Adjust Against Credit ")
						document.getElementById("cAdjustAmountId").checked = true;
						document.getElementById("adjustAmountId").disabled = false;
						document.getElementById("adjustAmountId").value = "";
						document.getElementById("adjustAmountId").focus();
					}
				}
				function getRivisedBalance(balanceActuallyPaid) {
					var balancePaid = parseFloat(balanceActuallyPaid);

					if (balancePaid != "" && balancePaid != NaN) {

						var tenderedAmount = balancePaid
								- parseFloat(document
										.getElementById("amountId").value);
						document.getElementById("amountTenderedId").value = tenderedAmount;
					} else {
						alert("Please Enter Amount for Balance Actually Paid")
						document.getElementById("balanceActuallyPaidId")
								.focus();
					}
				}
			</script>
			<label>Waive Charge</label> <input type="checkbox" tabindex="2"
				name="waiveCharge" id="waiveChargeId" value="waiveCharge" validate="waiveCharge,int,yes"
				onclick="displayAuthorizedText(this)" style=" margin: 0px 5px; "/> 
				<label style="display: none;" id="labelAuthorized">Authorized By</label>
				<select name="refDoctor" id="refDoctorId" validate="refDoctor,metachar,no"
				style="display: none; margin-left: 3px; width: 162px;" tabindex="2">
				<option value="0">Select</option>
				<%for(MasAuthorizer masAuthorizer : authorizerList)
		{%>
				<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
				<%}%>
			</select>
			<div class="clear"></div>

			<%-- 	<label><%=prop.getProperty("com.jkt.hms.bill_no")%></label> 
		<input type="text" tabindex="2" id="billNoId" class="readOnly" name="billNo" value="<%=billNumber%>" 
		readonly="readonly" 
		title="Bill No of the Patient" validate="Bill No,int,no" MAXLENGTH="15" /> --%>

			<label>Amount Chargeable</label> <input type="text" tabindex="2"
				id="amountId" name="billAmount" value="<%=mas_charge_code_rate %>"
				MAXLENGTH="4" readonly="readonly" class="readOnly" /> 
				
				 <input type="checkbox" tabindex="2"
				name="cAdjustAmount" id="cAdjustAmountId" style="margin:0px 6px 0px 5px;" 
				onclick="displayAmountText(this)" /> 				
				
				<label style="width:131px;">Adjust Against Credit</label>
				
				<input type="text" style="display: none;" tabindex="2"
				name="adjustAgainstCreditName" id="adjustAgainstCreditName" onkeypress="return numbersonly(event)"
				 onblur="adjustAgaintsCredit(this.value)"
				 value="" />
				
				<label style="display: none;" id="labelcredit">Available Credit Balance</label>
			<input type="text" style="display: none;" tabindex="2"
				name="<%=AVIALABLE_CREDIT_BALANCE %>" id="availableCreditBalanceId"
				readonly="readonly" value="" />
				
			<div class="clear"></div>
			<label>Balance To Be Paid</label><input type="text" tabindex="2"
				name="balanceToBePaid" value="<%=mas_charge_code_rate %>" id="balanceToBePaidId"
				readonly="readonly" />
				
				<label  id="discountPercent">Discount(%)</label>
			<input type="text"  tabindex="2"
				name="discountPercent" id="discountPercentText" value="" readonly="readonly" />
				
				<label  id="discountPerAmountId">Discount Amount</label>
			<input type="text"  tabindex="2"
				name="discountPerAmount" id="discountPerAmountTextId"
				readonly="readonly" value="" />

 <div class="clear"></div>
 		<label> Amount Tendered
				</label><input type="text" tabindex="2" maxlength="5" name="amountTendered"
				id="amountTenderedId" onblur="calculateBalaceReturn(this.value)" onkeypress="return numbersonly(event)" />

			<label>Balance to be return</label> 
			<input type="text" tabindex="2"
				name="balanceActuallyPaid" MAXLENGTH="5" id="balanceActuallyPaidId" onkeypress="return numbersonly(event)"
				 onblur="calculateRevisedCredit(this.value)"
				value=""  /> 
				
				<input type="hidden" tabindex="2"
				name="balanceActuallyPaidhidden" MAXLENGTH="8" id="balanceActuallyPaidIdhidden"
				value=""  /> 
				
			
			<label>Revised Credit Balance</label><input type="text" tabindex="2"
				name="revisedCreditBalance" id="revisedCreditBalanceId"
				readonly="readonly" />
				
				
			<div class="clear"></div>


		<div class="clear"></div>
		<div class="clear"></div>
<input name="onlineAppointment" id="onlineAppointment" type="hidden" value=""/>
<input name="onlineAppId" id="onlineAppId" type="hidden" value=""/>
		<div id="searchbar">
			<div id="edited"></div>
			<input type="button" name="Submit11" value="Submit" tabindex="1"
				class="button"
				onClick="if(checkField())if(printConfirmation())if(checkForPediatricDepartment()){submitForm('patientVisitSearch','/hms/hms/registration?method=saveVisitInformation')}" />
			<input type="reset" name="Reset" value="Reset"
				class="buttonHighlight" tabindex="2" onclick="" accesskey="" />
		</div>
		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<div class="paddingTop40"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</div>		
</form>
</body>
<script type="text/javascript">

	function checkForPediatricDepartment(){
		var age = document.getElementById('ageId').value;
		//var dept = document.getElementById('deptId').value;
		var obj = age.split(" ");
		var ageValue = obj[0];
		var ageunit = obj[1];
		 var selectedArray = new Array();
		 var selectedDept;
		    var deptObj = document.getElementById('deptId'); 
		    var i;
		    var count = 0;
		    for (i=0; i<deptObj.options.length; i++) { 
		        if (deptObj.options[i].selected) {
		            selectedArray[count] = deptObj.options[i].value;
		        	<%for(MasDepartment masDepartment :departmentList){%>
		        		if('<%=masDepartment.getId()%>' == selectedArray[count]){
		        			if(('<%=masDepartment.getDepartmentName()%>'=='PAEDIATRICS')){
		        				if(parseInt(age)>18  && ageunit=='Years'){
		        				alert("More than 18 Years Patient is not allowed in Paediatric Department.");
		        				deptObj.options[i].selected = false;
		        				return false;
		        				}else{
		        					return true;
		        				}
		        			}
		        		
		        		}
		        		<%}%>
		            count++; 
		            
		        } 
		    }
		    //selectedDept = selectedArray;
		    return true;
	}

	function checkField() {
		var deptId = document.getElementById('deptId').value;
		var othercenterId = document.getElementById('othercenterId').value; // added by amit das on 16-08-2017

		if (deptId == "0" && othercenterId == "0") {
			alert("Select Service Center ");
			return false;
		} 
		
		return true;	
		
	}
	
	function mandatoryOpClinicServiceCenter() {
		
		var element= document.getElementById("deptId");
		
		element.setAttribute("validate","no");
		
		document.getElementById("opClinicService").style.display = 'none';
		
		var element= document.getElementById("otherdeptId");
		
		element.setAttribute("validate","yes");
		
		document.getElementById("otherClinicService").style.display = 'block';
			
	}
function mandatoryOtherServiceCenter() {
		
		var element= document.getElementById("otherdeptId");
		
		element.setAttribute("validate","no");
		
		document.getElementById("otherClinicService").style.display = 'none';
		
		var element= document.getElementById("deptId");
		
		element.setAttribute("validate","yes");
		
		document.getElementById("opClinicService").style.display = 'block';	
		
	}
	
	function printConfirmation() {		
		
		var name=document.getElementById("pnameId").value;
		var genderId=document.getElementById("genderId").value;//govind code 
		var otherdeptId=document.getElementById("otherdeptId").value;
		var otherdeptId1=document.getElementById("deptId").value;
		var empDeptCodeId=document.getElementById("empDeptCodeId").value;
		
		var age=document.getElementById("ageId").value.split(" ")[0];//added by govind 22-10-2016
		
		var serviceCenter="";
		if(document.getElementById('deptId').value != 0){
		 serviceCenter=document.getElementById('deptId').options[document.getElementById('deptId').selectedIndex].text 
		}
		//added by arbind on 20-02-2017
		if(serviceCenter == "") {
			if(document.getElementById('otherdeptId').value != 0){
				 serviceCenter=document.getElementById('otherdeptId').options[document.getElementById('otherdeptId').selectedIndex].text 
			}
		}
		
		var complaint="";
		
		if(document.getElementById('compltId').options[document.getElementById('compltId').selectedIndex].text!='Select'){
			complaint=document.getElementById('compltId').options[document.getElementById('compltId').selectedIndex].text;
		}
		
		var docname="";
		if(document.getElementById('loddrs').options[document.getElementById('loddrs').selectedIndex].text!='select'){
			docname=document.getElementById('loddrs').options[document.getElementById('loddrs').selectedIndex].text;
		}
		 		 
	    if (confirm("Name- "+name+"\nService Centre - "+serviceCenter+"\nComplaint - "+complaint+"\nDoctor Name- "+docname+"\n\n\n  Do you want to continue !") == true) {
	    	//added by govind 22-10-2016 end
	    	
	       if(genderId=="Male" && (empDeptCodeId=='<%=obsGynecDept%>')){
	    	   alert(" Male patient could not create visit for this service center");
	    	   return false;
	       }
	    	
	       if(genderId=="Female" && (empDeptCodeId=='<%=obsGynecDept%>')){
	    	   if(age<12){
	    		   if(confirm("Patient is less than 12 years!\n\nDo you want to continue!"))
	    			   return true;
	    		   else
	    		   // alert("Please check the patient age for this service center");
		    	   return false;
	    	   }else{
	            return true;
	    	   }
	    	}
	     //added by govind 22-10-2016 end
	     //added by arbind 10-01-2017
	       if(otherdeptId=='<%=immunCode%>' || otherdeptId1=='<%=immunCode%>'){
	    	   if(age > 18){
	    		   alert("Patient is more than 18 years");
		    	   return false;
	    	   }else{
	            return true;
	    	   }
	    	}
	       return true;
	    } else {
	       
	        return false;
	    }
	  
	}
	
	function calculateBalaceReturn(tenderAmount){
		
		var balanceToBePaid=document.getElementById('balanceToBePaidId').value;
		document.getElementById('balanceActuallyPaidId').value="0.0";
		document.getElementById('balanceActuallyPaidIdhidden').value="";
		document.getElementById('revisedCreditBalanceId').value="";
		
		if(parseFloat(balanceToBePaid) <= parseFloat(tenderAmount)){
			
			var abc=parseFloat(tenderAmount)-parseFloat(balanceToBePaid);
			document.getElementById('balanceActuallyPaidId').value=abc;
			document.getElementById('balanceActuallyPaidIdhidden').value=abc;
			if(abc==0.0){
				document.getElementById('revisedCreditBalanceId').value=abc;
				}
		}
		else{
			alert("Tender Amoumt can not less than Balanced to be paid amount");
			document.getElementById('balanceActuallyPaidId').value="";
		}
		
	}
	function calculateRevisedCredit(balancetoPaid){
		
		if (balancetoPaid != "") {
			if(parseFloat(balancetoPaid)<0){
				alert("Please Enter Correct Value")
			}
			else{
				var balanceToReturn=document.getElementById('balanceActuallyPaidIdhidden').value;
				if(parseFloat(balancetoPaid)<= parseFloat(balanceToReturn)){
					var actualCreditBalance=parseFloat(balanceToReturn)-parseFloat(balancetoPaid);
					document.getElementById('revisedCreditBalanceId').value=actualCreditBalance;
				}
				else{
					document.getElementById('balanceActuallyPaidId').value="0";
					alert("Entered Amount Can not greater then actual return balance !")
				}
			}
			
		}
	}
	
	
function adjustAgaintsCredit(adjustAmount){
		
		var availableCreditbalance=document.getElementById('availableCreditBalanceId').value;
		if(adjustAmount>availableCreditbalance){
			alert("Enter value is greater than available balance")
			document.getElementById('adjustAgainstCreditName').value="0.0";
		}
		else{
			var btp=document.getElementById('balanceToBePaidId').value;
			var amount=document.getElementById('amountId').value;
			if(parseFloat(adjustAmount)<=parseFloat(amount)){
				
				var availableCredit=parseFloat(availableCreditbalance)-parseFloat(adjustAmount);
				document.getElementById('availableCreditBalanceId').value=availableCredit;
				alert(amount)
			var balanceToPaid=parseFloat(btp)-parseFloat(adjustAmount);
			document.getElementById('balanceToBePaidId').value=balanceToPaid;
			document.getElementById('amountTenderedId').value=balanceToPaid;
			}
			else{
				alert("Sorry Your amount can not ajdust !");
				}
		}
	}
	
	
function numbersonly(e){
	
    var charCode = (e.which) ? e.which : event.keyCode
    		 if (charCode > 31 && ((charCode < 48) || (charCode > 57))){
       return false;
    		 }
    return true;
 }
	   
	function searchParticularPage(type){
		if(type==1){//changed by govind 22-11-2016
		var curPage=document.getElementById("inPage").value;
		var fname=document.getElementById("pFirstNameId").value;
		var hinNo1=document.getElementById("hinNo1").value;
		var dobId=document.getElementById("dobId").value;
		var fromAge=document.getElementById("fromAge").value;
		var toAge=document.getElementById("toAge").value; 
		var mobno=document.getElementById("mobno").value;
		if(!curPage || isNaN(curPage)){
			
			curPage=1;
		}
		if(hinNo1==''){
			hinNo1='null';
		}
		if(dobId==''){
			dobId='null';
		}
		if(fromAge==''){
			fromAge=0;
		}
		if(toAge==''){
			toAge=0;
		}
		if(mobno==''){
			mobno='null';
		}
		submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page='+curPage+'&hinNo='+hinNo1+'&fn='+fname+'&moNo='+mobno+'&bitD='+dobId+'&toAge='+toAge+'&fromAge='+fromAge+'&visitSearch=serch');
		}
		if(type==2){
			var curPage2=document.getElementById("inPage2").value;
			submitForm('search','/hms/hms/registration?method=paginationForPatientVisitJsp&page='+curPage2+'&visitSearch=s');	
		}		
	}
</script>

