<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateAdmission.jsp
 * Purpose of the JSP -
 * @author  Deepti
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.23
--%>


<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasAdmissionType"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.InpatientDocument"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.util.HashSet"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
<script type="text/javascript">
function checkCancelAdmin(state){
if(state=="no")
{
alert("Can not cancel admission after One Hour...!")
return false
}else{
return  true
}
}

//-->
</script>

<form name="updateAdmission" method="post">

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Update Patient Admission</h2>
</div>
<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	int bedId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientAdmissionMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();

	List<Inpatient> admissionDetailsList = new ArrayList<Inpatient>();

	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
	List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasDocument> documentList = new ArrayList<MasDocument>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");

	String currentTime = (String)utilMap.get("currentTime");
	List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();

	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
	 String date4Cancel=formatterOut.format(formatterIn.parse(currentDate));
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientAdmissionMap") != null){
		patientAdmissionMap = (Map<String,Object>)map.get("patientAdmissionMap");
	}

	if(patientAdmissionMap.get("admissionDetailsList") != null){
		admissionDetailsList = (List<Inpatient>)patientAdmissionMap.get("admissionDetailsList");
	}
	if(patientAdmissionMap.get("inpatientDocumentList") != null){
		inpatientDocumentList = (List<InpatientDocument>)patientAdmissionMap.get("inpatientDocumentList");
	}

	if(admissionDetailsList.size() > 0){

		Inpatient inpatient = admissionDetailsList.get(0);
		Patient patient = inpatient.getHin();

		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("dietList") != null){
			dietList = (List<MasDiet>)map.get("dietList");
		}
		if(map.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		if(map.get("diagnosisList") != null){
			diagnosisList = (List<MasIcd>)map.get("diagnosisList");
		}
		if(map.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)map.get("admissionTypeList");
		}
		if(map.get("caseTypeList") != null){
			caseTypeList = (List<MasCaseType>)map.get("caseTypeList");
		}
		if(map.get("relationList") != null){
			relationList = (List<MasRelation>)map.get("relationList");
		}
		if(map.get("documentList") != null){
			documentList = (List<MasDocument>)map.get("documentList");
		}
		if(map.get("recordOfficeAddressList") != null){
			recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
		}
		String cancelState="yes";
		boolean check =false;
		String adDateString =""+inpatient.getDateOfAddmission();
		String adTimeString =""+inpatient.getTimeOfAddmission();

		if(date4Cancel.equals(adDateString)){
			check =true;
		}


%>

<h4>Patient Details</h4>
<div class="clear"></div>

<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label class="value"><%=patient.getHinNo() %></label>
<%
	if(patient.getSex() != null){
	%> <label>Sex</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
<%} %> <%
	if(patient.getMaritalStatus() != null){
	%> <label>Marital Status</label> <label class="value"><%=patient.getMaritalStatus().getMaritalStatusName() %></label>
<%} %>

<div class="clear"></div>

<%
	String pName="";
pName= patient.getPFirstName();
if(patient.getPMiddleName()!=null){
	pName+=" "+patient.getPMiddleName();
}
if(patient.getPLastName()!=null){
	pName+=" "+patient.getPLastName();
}
String ageAsDob="";
String age = "";
if(inpatient.getHin().getDateOfBirth()!=null){
ageAsDob=HMSUtil.calculateAge(inpatient.getHin().getDateOfBirth());
}else{
	ageAsDob=inpatient.getAge();
}
%>
<label>Patient Name</label> <label class="value"><%=pName%></label>

<label>Age</label> <label class="value"><%=ageAsDob%></label>
<input type="hidden" name="ageAsDob" id="ageAsDob" value="<%=ageAsDob%>" />
<%
	if(patient.getReligion() != null){
	%> <label>Religion</label> <label class="value"><%= patient.getReligion().getReligionName()%></label>
<%} %> <%
	if(patient.getPatientDistrict() != null){
	%>

<div class="clear"></div>

<label>Patient Dist</label> <label class="value"><%=patient.getPatientDistrict() %></label>
<%} %> <label>Admission Type</label> <select
	name="<%=ADMISSION_TYPE_ID %>" validate="Admission Type,String,no">
	<option value="0">Select</option>
	<%
		for (MasAdmissionType obj : admissionTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdmissionTypeName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getAdmissionType()  != null){
			 			int admissionTypeId = inpatient.getAdmissionType().getId() ;
					%>
					document.updateAdmission.<%=ADMISSION_TYPE_ID%>.value = '<%=admissionTypeId %>';
               <%
			 		}%>
			 		<%
			 		String admDate="";
			 		if(inpatient.getDateOfAddmission()!=null){
			 			admDate=HMSUtil.convertDateToStringTypeDateOnly(inpatient.getDateOfAddmission());
			 		}
			 		%>
           </script> <label><span>*</span> Adm Date </label> <label class="value"><%=admDate%></label>

<div class="clear"></div>

<label><span>*</span> Adm Time </label> <label class="value"><%=inpatient.getTimeOfAddmission()%></label>

<label>Ward</label> <label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>

<div class="clear"></div>


<label><span>*</span> Admitted By</label> <select
	name="<%=CONSULTING_DOCTOR %>" validate="Admitted By,String,yes">
	<option value="0">Select</option>
	<%
		for (MasEmployee  obj : employeeList){
			//if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String admittedBy="";
				admittedBy=obj.getFirstName();
				if(obj.getMiddleName()!=null){
					admittedBy=" "+obj.getMiddleName();
				}
				if(obj.getLastName()!=null){
					admittedBy=" "+obj.getLastName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=admittedBy%></option>
	<%  }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDoctor()  != null){
			 			int doctorId = inpatient.getDoctor().getId() ;
					%>
					document.updateAdmission.<%=CONSULTING_DOCTOR%>.value = '<%=doctorId %>';
               <%
			 		}%>
</script>

<div class="clear"></div>
<label><span>*</span> Condition</label>
<select id="conditionId" name="<%=CONDITION %>" tabindex="1" validate="Condition,String,yes" onchange="displayStatus();">
		<option value="0">Select</option>
		<option value="Normal">Normal</option>
		<option value="Critical">Critical</option>
		<option value="Dead">Dead</option>
</select>

<script type="text/javascript">
          	<%  if(inpatient.getPatientCondition()  != null){
					%>
					document.updateAdmission.<%=CONDITION%>.value = '<%=inpatient.getPatientCondition() %>';
               <%
			 		}%>
</script>
<label ><span>*</span> Condt. Status</label>
<div id="statusLoad" style="display: inline;">
 <label class="value"><%=inpatient.getConditionStatus()%></label>
</div>
<div id="status1" style="display: none;">
<label class="value">Normal</label>
</div>

<div id="status2" style="display: none;">
<label class="value">Dead</label>
</div>

<div id="status3" style="display: none;">
<select name="<%=CONDITION_STATUS %>" class="smallest" tabindex="1">
<option value="SIL">SIL</option>
<option value="DIL">DIL</option>
</select>
</div>
<div class="clear"></div>


<%
if(inpatient.getPatientCondition().equalsIgnoreCase("Critical")){


		if(inpatient.getListDate() != null){
	%>

<div class="clear"></div>

<label>List Date</label> <label class="value"><%=inpatient.getListDate()%></label>
<%} %> <%
		if(inpatient.getListTime() != null){
	%> <label>List Time</label> <label class="value"><%=inpatient.getListTime()%></label>
<%}
}%>


<div class="clear"></div>
<%
String initialDiagnosis="";
if(inpatient.getInitDiagnosis()!=null){
	initialDiagnosis=inpatient.getInitDiagnosis();
}


%>
<label>Provisional Diagnosis</label> <input type="text" value="<%=initialDiagnosis%>"
	id="icd" name="icd" onblur="fillDiagnosisCombo()" />
<div id="ac2update" style="overflow: scroll; display: none;"
	class="autocomplete"></div>

<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
</script> <label>Veg/Non-Veg</label> <select name="<%=DIET_TYPE%>">
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDietType()  != null){
			 			String dietType = inpatient.getDietType();
					%>
					document.updateAdmission.<%=DIET_TYPE%>.value = '<%=dietType %>';
               <%
			 		}%>
	 </script> <label>Patient Diet</label> <select name="<%=DIET_ID %>"
	validate="Diet,String,no">
	<option value="0">Select</option>
	<%
		for (MasDiet  obj : dietList){
			//if(currentTime.substring(0,2).equals("00") || currentTime.substring(0,2).)

	%>
	<option value="<%=obj.getId ()%>"><%=obj.getDietName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getDiet()  != null){
			 			int  dietId = inpatient.getDiet().getId();
					%>
					document.updateAdmission.<%=DIET_ID%>.value = '<%=dietId %>';
               <%
			 		}%>
	 </script>

<div class="clear"></div>



<label><span>*</span> Case Type</label> <select id="caseId"
	name="<%=CASE_TYPE_ID %>" validate="Case Type,String,yes">
	<option value="0">Select</option>
	<%
	 	for (MasCaseType obj : caseTypeList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getCaseTypeName()%></option>
	<% }%>
</select> <script type="text/javascript">
          	<%  if(inpatient.getCaseType()  != null){
			 			int  caseTypeId = inpatient.getCaseType().getId();
					%>
					document.updateAdmission.<%=CASE_TYPE_ID%>.value = '<%=caseTypeId %>';
               <%
			 		}%>
</script>
<div class="clear"></div>
<%
		if(inpatient.getMotherAdNo() != null){
		%> <label>Mother IP No.</label> <label class="value"><%=inpatient.getMotherAdNo()%></label>
<%} %>
<div class="clear"></div>
</div>



<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId() %>">



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="Submit" value="Update" class="button"
	onClick="submitForm('updateAdmission','/hms/hms/adt?method=updateAdmissionInformation');" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	onclick="location.reload();" accesskey="r" /> <% }else{%> No Records
Found ! <%} %>
<h4></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=currentDate%></label>
<label>Changed Time</label>
<label class="value"><%=currentTime%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<script>
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId');
		obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
</script>
<script type="text/javascript">
	function displayStatus(){
		var condition = document.updateAdmission.<%=CONDITION %>.value;
		if(condition == "Normal"){
			document.getElementById('status1').style.display = "inline";
			document.getElementById('status2').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('statusLoad').style.display = "none";
		}else if(condition == "Dead"){
			document.getElementById('status2').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('statusLoad').style.display = "none";
		}else if(condition == "Critical"){
			document.getElementById('status3').style.display = "inline";
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
			document.getElementById('statusLoad').style.display = "none";
		}else if(condition == "0"){
			document.getElementById('status1').style.display = "none";
			document.getElementById('status2').style.display = "none";
			document.getElementById('status3').style.display = "none";
			document.getElementById('statusLoad').style.display = "inline";
		}

	}


</script>