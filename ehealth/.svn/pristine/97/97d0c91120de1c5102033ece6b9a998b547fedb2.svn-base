<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDistrict" %>
<%@page import="jkt.hms.masters.business.MasVillage" %>
<%@page import="jkt.hms.masters.business.MasPostCode" %>
<%@page import="jkt.hrms.masters.business.MasQualification" %>
<%@page import="jkt.hrms.masters.business.HrMasQualification" %>
<%@page import="jkt.hms.masters.business.MasLsg" %>
<%@page import="jkt.hms.masters.business.MasLsgType" %>
<%@page import="jkt.hms.masters.business.MasOccupation" %>
<%@page import="jkt.hms.masters.business.MasState" %>
<%@page import="jkt.hms.masters.business.MasCountry" %>
<%@page import="jkt.hms.masters.business.MasVisaType" %>
<%@page import="jkt.hms.masters.business.PhMasLocalityType" %>
<%@page import="jkt.hms.masters.business.MasIdCard" %>
<%@page import="jkt.hms.masters.business.MasTaluk" %>
<%@page import="jkt.hms.masters.business.PhMemberSurvey" %>
<%@page import="jkt.hms.masters.business.MasHospital" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>

<%@ page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientCategoryDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.GENDER"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_AADHAAR_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LAST_NAME"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FULL_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPANY"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PROJECT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TITLE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_BIRTH"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELIGION"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASTE"%>
<%@ page import="static jkt.hms.util.RequestConstants.ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.NATIONALITY"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOCK"%>
<%@ page import="static jkt.hms.util.RequestConstants.POST_OFFICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.PINCODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMAIL_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.OCCUPATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERENCE"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATIVE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.REMARKS"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPLAINT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOSPITAL_STAFF"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOUSE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.STREET_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.VILLAGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SUB_DISTRICT"%>

<%@ page import="static jkt.hms.util.RequestConstants.LOCALITY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.WARD"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HEALTH_HOUSE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PURPOSE"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISANAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PASSPORTNUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.NATIVE_SUB_CENTRE"%>
<%@ page import="static jkt.hms.util.RequestConstants.EDUCATION"%>
<%@ page import="static jkt.hms.util.RequestConstants.YOB"%>
<%@ page import="static jkt.hms.util.RequestConstants.BPL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.APL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasWard" %>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script lang="javascript"  src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();

List<Patient> patientList = new ArrayList<Patient>();
List<Patient> patientwithMobList = new ArrayList<Patient>();
int currentPage=0;
int noOfPages=0;
String name="";
String mobNo="";


if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
if(null!=map.get("patientList")){
	patientList=(List<Patient>)map.get("patientList");
	 }
if(null!=map.get("patientwithMobList")){
	patientwithMobList=(List<Patient>)map.get("patientwithMobList");
	 }
if(null!=map.get("currentPage")){
	currentPage=(Integer)map.get("currentPage");
	 }
if(null!=map.get("noOfPages")){
	noOfPages=(Integer)map.get("noOfPages");
	 }
if(null!=map.get("mobNo")){
	mobNo=(String)map.get("mobNo");
	 }
if(null!=map.get("name")){
	name=(String)map.get("name");
	 }



%>

<%-- <input type="text" name="nameForMobNoSearch" value="<%=name%>"/>
<input type="text" name="mobNoForSearch" value="<%=mobNo%>"/>
 --%>
	
		
		<% 
		if(null !=patientList && patientList.size()>0 || null !=patientwithMobList && patientwithMobList.size()>0){%>
			<h4>Patient Already Registered </h4>
			<div class="cmntable">
		<table>
	
	<tr>
	 <th>UHID</th> 
	<th>Name</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Mobile No.</th>
	
	<th></th>
	</tr>
		<%}
		String dob="";
		String gender="";
		Date dd=null;
		String pdistrict="";
		String housname="";
		String streetname="";
		String citizenAddress="";
		String uhidNo="";
		String mobileNo="";
		for(Patient patient:patientList){
			if(null !=patient.getDateOfBirth()){
			dd=patient.getDateOfBirth();
			dob=HMSUtil.calculateAge(dd);
			}
			if(null!=patient.getSex()){
				gender=patient.getSex().getAdministrativeSexName();
			}
			uhidNo=patient.getHinNo();
			if(null !=patient.getMobileNumber())
			mobileNo=patient.getMobileNumber();
			/* if(null!=patient.getAadhaarDistrict()){
				pdistrict=patient.getAadhaarDistrict().getDistrictName();
			}
			if(null!=patient.getHouseName())
			housname=patient.getHouseName();
			if(null!=patient.getStreetName())
			streetname= patient.getStreetName();
			
			citizenAddress=housname+"     "+streetname+"    "+pdistrict; */
			%>
	<%-- <tr onclick="submitForm('search','/hms/hms/registration?method=showMsgForRegJsp&patientHinNo=<%=patient.getId()%>')"> --%>	
	<tr  HighLightTR(this)" style="cursor: pointer;">
	
	<td><%=uhidNo%></td>
	<td><%=patient.getFullName()%></td>
	<td><%=gender%></td>
	<% if(null!=dob){%>
	<td><%=dob%></td>
	<%}else{
		%>
		<td></td>
		<% 
	}
	%>
	 <td><%=mobileNo %> </td> 
	 <td><input type="button" name="no" value="Visit" class="button"	onclick="submitForm('patientRegistersearch','/hms/hms/registration?method=showPatientVisitJsp&hinNo=<%=uhidNo %>','checkTargetForNo');" /></td>

</tr>
<%}
		 dob="";
		 gender="";
		 dd=null;
		 pdistrict="";
		 housname="";
		 streetname="";
		 citizenAddress="";
		 uhidNo="";
		 mobileNo="";
if(null!=patientwithMobList && patientwithMobList.size()>0)	{
	for(Patient patient:patientwithMobList){
		if(null !=patient.getDateOfBirth()){
		dd=patient.getDateOfBirth();
		dob=HMSUtil.calculateAge(dd);
		}
		if(null!=patient.getSex()){
			gender=patient.getSex().getAdministrativeSexName();
		}
		uhidNo=patient.getHinNo();
		if(null !=patient.getMobileNumber())
		mobileNo=patient.getMobileNumber();
		/* if(null!=patient.getAadhaarDistrict()){
			pdistrict=patient.getAadhaarDistrict().getDistrictName();
		}
		if(null!=patient.getHouseName())
		housname=patient.getHouseName();
		if(null!=patient.getStreetName())
		streetname= patient.getStreetName();
		
		citizenAddress=housname+"     "+streetname+"    "+pdistrict; */
		%>
		<tr  HighLightTR(this)" style="cursor: pointer;">
		
		<td><%=uhidNo%></td>
		<td><%=patient.getFullName()%></td>
		<td><%=gender%></td>
		<% if(null!=dob){%>
		<td><%=dob%></td>
		<%}else{
			%>
			<td></td>
			<% 
		}
		%>
		 <td><%=mobileNo %> </td> 
		 <td><input type="button" name="no" value="Visit" class="button" onclick="submitForm('patientRegistersearch','/hms/hms/registration?method=showPatientVisitJsp&hinNo=<%=uhidNo%>','checkTargetForNo');" /></td>

	</tr>	
<%}}%>
	</table>
	</div>
	<div class="clear"></div>
	<%--	<% 
		
if(currentPage !=1){--%>	
<%-- <a href="javascript:paginationForRegistedPatient('<%=currentPage-1%>','<%=name%>','<%=mobNo%>');">Previous</a>
 <% }
		if(noOfPages>=1){
			for(int i=1;i<=noOfPages;i++){
				if(currentPage==i){%>
					<%=i%>
					<% }else{%>
	<a href="javascript:paginationForRegistedPatient('<%=i%>','<%=name%>','<%=mobNo%>');"><%=i%></a>
 <% 	}}
		}

		if(currentPage <noOfPages){
			%>
		
 	<a href="javascript:paginationForRegistedPatient('<%=currentPage+1%>','<%=name%>','<%=mobNo%>');">Next</a></td>

 <% } 
%>	--%>

  <!-- added by govind 30-12-2016 -->
	<%
	if(currentPage !=1){%>

		<a href="javascript:paginationForRegistedPatient('<%=currentPage-1%>','<%=name%>','<%=mobNo%>');">Previous</a>


	<%}

if(noOfPages>=1){%>

		<a href="javascript:paginationForRegistedPatient('<%=currentPage%>','<%=name%>','<%=mobNo%>');"><%=currentPage%></a>
	<%
}
if(currentPage <noOfPages){%>

	<a href="javascript:paginationForRegistedPatient('<%=currentPage+1%>','<%=name%>','<%=mobNo%>');">Next</a>
	
	<%}%>
	<div class="Block">
	<input type="text" id="inPage" maxlength="4" style="width:30px;"/><input type="button" value="Go" onclick="searchParticularPage();"/> <label> No of Pages :  <%=noOfPages%></label><!-- added by govind end-->
	<input type="hidden" id="nameS" value="<%=name%>"/>
	<input type="hidden" id="mobNoS" value="<%=mobNo%>"/>
   </div>
   <!-- added by govind 30-12-2016 -->
   
<!-- <script type="text/javascript">
function paginationForRegistedPatient(page,name,mobNo){
	alert();
	//submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&mobNo='+mobNo+'&name='+name,'patientDtDiv');
	submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&page='+page+'&nameForMobNoSearch='+name+'&mobNoForSearch='+mobNo,'patientDtDiv');
} -->
<!-- </script> -->
</body>
</html>
<script type="text/javascript">

	</script>