<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");

}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 




List patientList = new ArrayList();

if(map.get("patientList") != null){
patientList=(List)map.get("patientList");
}				






String userName = "";
if (session.getAttribute("userName") != null) {
userName = (String) session.getAttribute("userName");
}
int deptId=0;

if (map.get("deptId") != null) {
deptId = (Integer) map.get("deptId");
}

String deptName="";
if (map.get("deptName") != null) {
deptName = (String) map.get("deptName");
}
%>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<div class="titleBg">
<h2><%=deptName%> Ward</h2>
</div>
<div class="Clear"></div>
<h4>OPD Patient List</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="search"><a href="">Search</a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: block;">
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label>HIN: </label>

<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"
	MAXLENGTH="30" tabindex=1 /> <input type="hidden" name="deptName"
	id="deptName" value="<%=deptName %>" /> <input type="hidden"
	name="date" id="date" value="<%=date %>" /> <label>Patient
First Name : </label> <input type="text"
	name="<%= RequestConstants.P_FIRST_NAME %>" id="patientFName"
	MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>

<label>Patient Middle Name : </label> <input type="text"
	name="<%= RequestConstants.P_MIDDLE_NAME %>" id="patientMName"
	MAXLENGTH="30" tabindex=1 /> <label>Patient Last Name : </label> <input
	type="text" name="<%= RequestConstants.P_LAST_NAME %>"
	id="pateintLName" MAXLENGTH="30" tabindex=1 />


<div class="clear"></div>

<label>Service No. : </label> <input type="text"
	name="<%= RequestConstants.SERVICE_NO %>" id="serviceNo" MAXLENGTH="30"
	tabindex=1 /> <label>Service Type : </label> <select
	name="<%=RequestConstants.SERVICE_TYPE_NAME%>" id="serviceType">
	<option value="">Select</option>
	<%
try{	
if(patientList.size()>0){
Set serviceTypeSet=  new HashSet();
Iterator itr=patientList.iterator();
while(itr.hasNext()){
Visit visitObj= (Visit) itr.next();
String serviceType=visitObj.getHin().getServiceType().getServiceTypeName();
if(visitObj.getVisitStatus().equals("w")){
serviceTypeSet.add(serviceType);
}
}
Iterator iterator=serviceTypeSet.iterator();
while(iterator.hasNext()){
String serviceType=(String)iterator.next();
%>

	<option value="<%=serviceType%>"><%=serviceType%></option>

	<%

}	
}
}catch(Exception e){
e.printStackTrace();	

}
%>
</select>

<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif"
	onClick="submitForm('search','opd?method=searchWaitingPatientListJsp');"
	class="button" /></form>
</div>





<%
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
%>
<div class="paddingTop15"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>

<form name="opdPatientList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->
<div class="floatLeft">
<div
	style="width: auto; height: 400px; float: left; border: 1px solid #ffffff;">
<!-- <div><img src="/hms/jsp/images/ward_title.jpg" width="172" height="26"></div> -->
<div class="navButtHeader">OPD</div>
<input name="patient fast history" type="button" class="navButtons"
	value="Appointments"><input name="patient fast history3"
	type="button" class="navButtons" value="Investigation Appt."><input
	name="patient fast history23" type="button" class="navButtons"
	value="Patient Allergic Drugs"><input
	name="patient fast history22" type="button" class="navButtons"
	value="Admitted Patient"><input name="patient fast history222"
	type="button" class="navButtons" value="Print Prescription"><input
	name="patient fast history22" type="button" class="navButtons"
	value="Print Investigation"> <!-- <div><img src="/hms/jsp/images/ward_footer.jpg" width="172" height="1"></div> --></div>
</div>
<div class="clear"></div>


<div id="test" class="wid">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">

formFields = [
[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
statusTd =12;

</script></div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>

<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = " "
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

data_header[1] = new Array;
data_header[1][0] = "Token No"
data_header[1][1] = "data";
data_header[1][2] = "8%";
data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"

data_header[2] = new Array;
data_header[2][0] = "Visit Number"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";

data_header[3] = new Array;
data_header[3][0] = "Visit Date"
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Visit Time"
data_header[4][1] = "data";
data_header[4][2] = "6%";
data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Service No"
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "<%=RequestConstants.SERVICE_NO %>";



data_header[6] = new Array;
data_header[6][0] = "Appointment Type"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";

data_header[7] = new Array;
data_header[7][0] = "Patient Name"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=RequestConstants.PATIENT_NAME %>";

data_header[8] = new Array;
data_header[8][0] = "Age"
data_header[8][1] = "data";
data_header[8][2] = "6%";
data_header[8][3] = "<%=RequestConstants.AGE %>";



data_header[9] = new Array;
data_header[9][0] = "Sex"
data_header[9][1] = "data";
data_header[9][2] = "1%";
data_header[9][3] = "<%=RequestConstants.SEX%>";

data_header[10] = new Array;
data_header[10][0] = "Diagnosis"
data_header[10][1] = "data";
data_header[10][2] = "10%";
data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";

data_header[11] = new Array;
data_header[11][0] = "I-Card Status"
data_header[11][1] = "hide";
data_header[11][2] = "1%";
data_header[11][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";



data_arr = new Array();

<%
int  i=0;
try{
String st="";

Iterator iterator=patientList.iterator();

while(iterator.hasNext())
{   
Visit visit= (Visit) iterator.next();
if(visit.getVisitStatus().equalsIgnoreCase("w"))
{
Patient patientHin=(Patient)visit.getHin();
MasDepartment deptObj=(MasDepartment)visit.getDepartment();
String patientName="";
if(visit.getHin().getPFirstName()!= null){
patientName=visit.getHin().getPFirstName();
}
if(visit.getHin().getPMiddleName()!= null){
patientName=patientName+" "+visit.getHin().getPMiddleName();
}
if(visit.getHin().getPLastName()!= null)
{
patientName=patientName+" "+visit.getHin().getPLastName();
}


MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());




%>

data_arr[<%= i%>] = new Array();

data_arr[<%= i%>][0] =<%=visit.getId()%>

data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= visit.getId()%>" id="parent" />'

<%
if(visit.getTokenNo()!=null)
{
%>
data_arr[<%= i%>][2] = "<%=visit.getTokenNo()%>"
<%
}else{
%>
data_arr[<%= i%>][2] = ""
<%
}
if(visit.getVisitNo()!=null)
{
%>
data_arr[<%= i%>][3]="<%=visit.getVisitNo()%>"
<%
}else{
%>
data_arr[<%= i%>][3]=""
<%
}
if(visit.getVisitDate()!= null )
{
%>
data_arr[<%= i%>][4] = "<%=visitDate%>"
<%
}else{
%> 
data_arr[<%= i%>][4] = ""
<%
}if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
{
%>
data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
<%
}else{
%>
data_arr[<%= i%>][5] = ""
<%
}
if(visit.getHin().getServiceNo()!= null ||visit.getHin().getServiceNo() != "")
{
%>
data_arr[<%= i%>][6] = "<%=visit.getHin().getServiceNo()%>"
<%
}else{
%>
data_arr[<%= i%>][6] = ""
<%
}
if(visit.getAppointmentType() != null || visit.getAppointmentType() !="")
{
%>
data_arr[<%= i%>][7] = "<%=visit.getAppointmentType()%>"
<%
}else{
%>
data_arr[<%= i%>][7] = ""

<%
}
if(patientName!= null )
{
%>
data_arr[<%= i%>][8] = "<%=patientName%>"
<%
}else{
%>
data_arr[<%= i%>][8] = ""
<%}
if(visit.getHin().getAge() != null)
{
%>

data_arr[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
<%
}else{
%> 			
data_arr[<%= i%>][9] = ""
<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
%>
data_arr[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
<%
}else{
%>
data_arr[<%= i%>][10] = ""
<%}

if(visit.getDiagnosis()!= null){

%>
data_arr[<%= i%>][11] = "<%=visit.getDiagnosis().getDiagnosisConclusionName()%>"
<%
}else{
%>
data_arr[<%= i%>][11] = ""
<%}%>
data_arr[<%= i%>][12] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=patientHin.getServiceCardStatus()%>"  />'
<% 	
i++;
}
}

}catch(Exception e){
e.printStackTrace();	

}
%>

formName = "opdPatientList"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeGridForPatient(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<div class="bottom">
<div class="floatRight"><label><span>Total Waiting
Patient</span> </label> <label class="value"><%= i%></label> <input type="hidden"
	name="counter" id="counter" value="<%=i %>" /> <input type="hidden"
	name="deptId" id="deptId" value="<%=deptId %>" /> <input type="hidden"
	name="deptName" id="deptName" value="<%=deptName %>" /></div>
</div>
<script>
   function check(){
     alert("In check")
   }
</script> <script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script> <script type="text/javascript">

function validateICard(){
var counter=document.getElementById("counter")
for(var i = 0; i < document.getElementsByName('parent').length; i++){

if(document.getElementsByName('parent')[i].checked == true)
{
var index=start+i;
var status=document.getElementById('iCardStatus'+index).value 
if(status=="n")
{
alert("I-Card is not available with the patient.")
return true;
}
//alert("I -Card Status for patient----:"+status)
return true;
}		
}
alert("Please select the patient")
return false;

}

</script></form>
</div>
<%patientList=null;%>