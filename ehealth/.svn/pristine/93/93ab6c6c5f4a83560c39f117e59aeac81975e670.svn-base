
<%@page import="jkt.hms.masters.business.PhStudentHealthDetails"%>
<%@page import="jkt.hms.masters.business.PhStudentRegistration"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.PhClassDetails"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTime");

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<PhMemberSurvey> phMemberSurveyValueList= new ArrayList<PhMemberSurvey>();
if(map.get("phMemberSurveyValueList") != null){
	phMemberSurveyValueList =  (List<PhMemberSurvey>)map.get("phMemberSurveyValueList");
	
}
List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
List<MasBloodGroup> bloodGrpList=new ArrayList<MasBloodGroup>();
List<PhVillageSurvey> schoolList=new ArrayList<PhVillageSurvey>();
List<PhVillageSurvey> anganwadiList=new ArrayList<PhVillageSurvey>();
List<MasOccupation> occupationList=new ArrayList<MasOccupation>();
List<MasRelation> relationList=new ArrayList<MasRelation>();
List<PhStudentRegistration> phStudentRegistrationList=new ArrayList<PhStudentRegistration>();

List<PhClassDetails> classList = new ArrayList<PhClassDetails>();

if(map.get("phStudentRegistrationList")!=null){
	phStudentRegistrationList=(List<PhStudentRegistration>)map.get("phStudentRegistrationList");
}

if(map.get("schoolList")!=null){
	schoolList=(List<PhVillageSurvey>)map.get("schoolList");
}
System.out.println("sdaasdasdas-----------"+schoolList.size());
if(map.get("anganwadiList")!=null){
	anganwadiList=(List<PhVillageSurvey>)map.get("anganwadiList");
}

if(map.get("genderList") != null){
	genderList = (List<MasAdministrativeSex>)map.get("genderList");
}

if(map.get("bloodGrpList") != null){
	bloodGrpList = (List<MasBloodGroup>)map.get("bloodGrpList");
}

if(map.get("occupationList") != null){
	occupationList = (List<MasOccupation>)map.get("occupationList");
}

if(map.get("relationList") != null){
	relationList = (List<MasRelation>)map.get("relationList");
}



if(map.get("classList") != null){
	classList = (List<PhClassDetails>)map.get("classList");
}
int surveyType=0;


if (phStudentRegistrationList.size() > 0) {
	for (PhStudentRegistration pst : phStudentRegistrationList) {
		surveyType=	pst.getClassdetails().getSurvey().getSurveyType();
%>



	
 <div id="memberSurveyValue">

<input type="hidden" name="studentId" value="<%=pst.getId()%>"></input>
<h4>Admission Information</h4>
<%if(pst.getClassdetails().getSurvey().getSurveyType()==1001){ %>
<label> School </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" class="radioCheckCol1" onclick="schoolTypeList();"/> 

<label>Anganwadi </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" checked="checked" value="Anganwadi" class="radioCheckCol1" onclick="schoolTypeList();" />

<%}else if(pst.getClassdetails().getSurvey().getSurveyType()==1002){ %>
<label> School </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" checked="checked"  class="radioCheckCol1" onclick="schoolTypeList();"/> 

<label>Anganwadi </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="Anganwadi" class="radioCheckCol1" onclick="schoolTypeList();" />

<%}else{ %>
<label> School </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" class="radioCheckCol1" onclick="schoolTypeList();"/> 

<label>Anganwadi </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="Anganwadi" class="radioCheckCol1" onclick="schoolTypeList();" />
<%} %>

<%if (phStudentRegistrationList.size() > 0) { 
	if(surveyType==1001){
%>
<script>
document.getElementById('anganwadiDiv').style.display = "inline";
document.getElementById('schoolDiv').style.display = "none";

</script>
<%}else if(surveyType==1002){ %>
<script>
document.getElementById('schoolDiv').style.display = "inline";
document.getElementById('anganwadiDiv').style.display = "none";
</script>
<%}} %>


<div id="schoolDiv" style="display: none;">

<div class="clear"></div>

<label><span>*</span>School Name </label>
<select name="<%= SCHOOL_ID%>" id="schoolNameId" tabindex="1"	   onblur="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getSchoolNameList&surveysId='+this.value,'testDivs');">
	<option value="">Select</option>
	<%
	int schoolId = 0;
	for(PhVillageSurvey school:  schoolList){ 
	if(pst.getClassdetails().getSurvey().getId()==school.getId()){
		schoolId = school.getId();
	%>
	<option value="<%=school.getId() %>" selected="selected"><%=school.getPlaceName() %></option>
	<%}else{ %>
<option value="<%=school.getId() %>"><%=school.getPlaceName() %></option>
<%} }%>
</select>

 <div id="testDivs">
 <%if(surveyType==1002 && surveyType!=1001){
	 %>

<label><span>*</span>Class</label>
<select name="<%= CLASS%>" tabindex="1">
<option value="">Select</option>

<%if(pst.getClassdetails().getSchoolClass()!=null){ %>
<option  value="<%=pst.getClassdetails().getSchoolClass()%>"  selected="selected"><%=pst.getClassdetails().getSchoolClass()%></option>
<%}%>
</select>

<label><span>*</span>Section</label>
<select name="classIdSection" id="classIdSection" tabindex="1"	validate="Section,string,no"	>
<option value="0">Select</option>
<%if(pst.getClassdetails().getSchoolClass()!=null){ %>
<option  value="<%=pst.getClassdetails().getId()%>" selected="selected"><%=pst.getClassdetails().getSchoolSection()%></option>
<%} %>

</select>
<%}else{ %>

<label><span>*</span>Class</label>
<select name="<%= CLASS%>" tabindex="1" validate="Class,date,no"	>
<option value="">Select</option>
</select>

	
<label><span>*</span>Section</label>
<select name="classIdSection" id="classIdSection" tabindex="1"	validate="Section,date,no"	>
	<option value="">Select</option>

</select>
<%} %>
</div>

<div class="clear"></div>
 <%if(surveyType==1002 && surveyType!=1001){
	 %>

<label>Joining Date</label>
 <%if(pst.getJoiningdate()!=null){ %>
<input	type="text" id="joiningDateIds" name="joiningDateIdSection" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getJoiningdate()) %>"		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 <%}else{ %>
 <input	type="text" id="joiningDateIds" name="joiningDateIdSection" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
 <%} %>
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIds,event)" />


 <label>Admission No.</label>
  <input type="text" name="admissionNoSection"  value="<%=pst.getAdmissionNo()%>"></input>

 <%}else{
 %>

<div class="clear"></div>
 
 <label>Joining Date</label>
<input	type="text" id="joiningDateIdjs" name="joiningDateIdSection" value=""		class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIdjs,event)" />


 <label>Admission No.</label>
  <input type="text" name="admissionNoSection" id="admissionNoSection"></input>
  

 <%} %>

  </div>


<div id="anganwadiDiv" style="display: none;">
<div class="clear"></div>

<label><span>*</span>Anganwadi Name </label>
<select name="<%=SCHOOL_ID%>" id="schoolNameId" tabindex="1"	 onblur="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getAnganwadiNameList&surveyId='+this.value,'testDivSurvey');">
<option value="">Select</option>
	<%for(PhVillageSurvey school:  anganwadiList){
		System.out.println("pst.getClassdetails().getSurvey()"+pst.getClassdetails().getSurvey().getId());
		System.out.println("pst.getClassdetails().school.getId()"+school.getId());
	if(pst.getClassdetails().getSurvey().getId()==school.getId()){
	%>
	<option value="<%=school.getId() %>" selected="selected"><%=school.getPlaceName() %></option>
	<%}else{ %>
<option value="<%=school.getId() %>" ><%=school.getPlaceName() %></option>
<%} }%>
</select>


 <div id="testDivSurvey">
 <%if(surveyType==1001 && surveyType!=1002){	%>

<label><span>*</span>Class</label>
<select name="<%= CLASS%>" tabindex="1">
<%if(pst.getClassdetails().getSchoolClass()!=null){ %>
<option  value="<%=pst.getClassdetails().getSchoolClass()%>"  selected="selected"><%=pst.getClassdetails().getSchoolClass()%></option>
<%} %>
</select>

	
<label><span>*</span>Division</label>
<select name="classIdDivison" id="classIdDivison" tabindex="1"	>
<%if(pst.getClassdetails().getSchoolClass()!=null){ %>
<option  value="<%=pst.getClassdetails().getId()%>" selected="selected"><%=pst.getClassdetails().getSchoolSection()%></option>
<%} %>

</select>
<%}else{ %>

<label><span>*</span>Class</label>
<select name="<%= CLASS%>" tabindex="1">
</select>

	
<label><span>*</span>Division</label>
<select name="classIdDivision" id="classIdDivison" tabindex="1"	>
	<option value="">Select</option>

</select>
<%} %>
</div>

 <div class="clear"></div>
 
  <%if(surveyType==1001 && surveyType!=1002){	%>
 <label>Joining Date</label>
 <%if(pst.getJoiningdate()!=null){ %>
 <input	type="text" id="joiningDateIdd" name="joiningDateIdDivision" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getJoiningdate()) %>"	class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 
<%}else{ %>
<input	type="text" id="joiningDateIdd" name="joiningDateIdDivision" value=""	class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
<%} %>
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIdd,event)" />
 <label>Admission No.</label>
  <input type="text" name="admissionNoDivison"  value="<%=pst.getAdmissionNo()%>"></input>
 <%}else{ %>
  
 <div class="clear"></div>
 <label>Joining Date</label>
 <input	type="text" id="joiningDateIdss" name="joiningDateIdDivision" value=""	class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIdss,event)" />

 <label>Admission No.</label>
  <input type="text" name="admissionNoDivison" id="admissionNoDivision" value=""></input>
 <%} %>

</div>



<div class="clear"></div>

<input type="button" name="add" onclick="generateExcel();" accesskey="r"  tabindex=1  value="Export" class="buttonBig" />
<input type="button" name="add" onclick="updateExcel();" accesskey="r"  tabindex=1  value="Import" class="buttonBig" />
 <div class="clear"></div>
 
 <h4>Student Registraion Details</h4>
 
 
 <input type="hidden" value="<%=pst.getMembersurvey().getId()%>" name ="memberSurveyId"></input>
<label>UHID No. </label> 
<%if(pst.getMembersurvey().getAadhaarNo() !=null){ %>
<input type="text" value="<%=pst.getMembersurvey().getAadhaarNo()%>" readonly="readonly"></input>
<%}else{ %>
<input type="text" value=""  readonly="readonly"></input>
<%} %>


<label>Blood Group </label> 
	<%	 %>
<select  name="bloodGrpId"  id="bloodGrpId" validate="Blood Group,string,no" tabindex="1" disabled="disabled" >
	<option value="0">Select</option>
	
	</select>
	
<label>Identification Mark 1 No. </label> 
<input type="text" name="IdentificationMarkOne" value="<%=pst.getIdentificationMarkOne() %>" ></input>
	
	<div class="clear"></div>

<label><span>*</span>Student Name </label>
	<input  type="text" name="studentName" readonly="readonly" value="<%=pst.getMembersurvey().getName()%>" validate="Student Name,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>


	<label><span>*</span>Gender </label> 
<select  name="genderId" validate="Gender,string,yes" tabindex="1" disabled="disabled">
<option value="0">Select</option>
	<%for(MasAdministrativeSex masAdminGender:genderList){ 
	 if(pst.getMembersurvey().getGender().getId()== masAdminGender.getId()){%>
	<option value="<%=masAdminGender.getId() %>" selected="selected"><%=masAdminGender.getAdministrativeSexName().trim()  %></option>
	<%}else{ %>
	<option value="<%=masAdminGender.getId() %>"><%=masAdminGender.getAdministrativeSexName().trim()  %></option>
	<%} }%>
	</select>
	
	<label>Identification Mark 2 No. </label> 
<input type="text" name="IdentificationMarkTwo" value="<%=pst.getIdentificationMarkTwo() %>"></input>
	
		
	<div class="clear"></div>
<label>DOB</label>
<%if(pst.getMembersurvey().getDateOfBirth()!=null){ %>
<input type="text" id="dobId" name="dob"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getMembersurvey().getDateOfBirth()) %>" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"
	onblur="calculateAgeInAjax('student');" MAXLENGTH="30" />
	<%}else{ %>
	<input type="text" id="dobId" name="dob"	value="" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"
	onblur="calculateAgeInAjax('student');" MAXLENGTH="30" />
	<%} %>
<div id="dobcalId">
<img id="" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0"	onclick="setdate('<%=date %>',document.student.dob,event)"	validate="Pick a date"  tabindex="14" />
</div>
	
	
	<input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" /> 
<label>Age</label>
<div id="ageDiv">
<input type="text" name="<%=AGE %>" id="age" 	onblur="checkForDOB();isAgeInteger(this.value);"  readonly="readonly"/>
	<input type="hidden" name="ageTemp"	id="ageTemp" value="" /> 
	<input id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,no" tabindex="1" class="small"	onblur="checkForDOB();" value="Years" readonly="readonly" />
	 <input 	type="hidden" id="idForAge" name="idForAge" />
	</div>
		<div class="clear"></div>
		<label>Number of siblings</label> 
<input type="text" name="nameOfSiblings" value="<%=pst.getNameOfSiblings()%>"></input>
	
	
<label>Address </label>
<input name="<%=ADDRESS %>" id="addr" tabindex="1"  value="<%=pst.getAddress() %>" validate="Address,string,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)"  onkeyup="chkLength(this,100);"	maxlength="100"/>


		<label>Birth order of this child</label>
		<input type="text" name="birthOrderOfThisChild"  value="<%=pst.getBirthOrderOfThisChild() %>"/>
		
		
			<div class="clear"></div>
		<label>Place of Birth</label>
		<input type="text" name="placeOfBirth"  value="<%=pst.getPlaceOfBirth() %>"></input>
		
		
	
	
	
<div class="clear"></div>
<h4>Mother's Details</h4>

<%if(pst.getMembersurvey().getRelationshipName()!=null && pst.getMembersurvey().getRelationshipName().equalsIgnoreCase("Mother")){ %>
<label>Mother Name </label>
<input  type="text" name="motherName" readonly="readonly" value="<%=pst.getMembersurvey().getPersonName() %>" validate="Mother Name,string,no" maxlength="49" tabindex=1 onkeyup="validateMother(this.value);" id="motherName"/>

<label>Education Status</label>
<input  type="text"  readonly="readonly" value="<%=pst.getMembersurvey().getEducation()%>"  name="educationStatusMother"//>

<label>Occupation</label>
<select disabled="disabled" name="occupationMother">
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
	 if(pst.getMembersurvey()!=null && masOccupation.getId()!=null && pst.getMembersurvey().getOccupation()!=null && pst.getMembersurvey().getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>

	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text" readonly="readonly" value="<%=pst.getMembersurvey().getContactNo()%>" name="contactNoMother"/>


<%}else{%>

<label>Mother Name </label>
<input  type="text" name="motherName"  value="<%=pst.getMotherName() != null ?pst.getMotherName():"" %>" validate="Mother Name,string,no" maxlength="49" tabindex=1 onkeyup="validateMother(this.value);" id="motherName"/>


<label>Education Status</label>
<input  type="text"  name="educationStatusMother"  value="<%=pst.getEducationStatusMother()!= null ?pst.getEducationStatusMother():"" %>" />

<label>Occupation</label>
<select name="occupationMother">
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
	 if(pst.getMembersurvey()!=null && masOccupation.getId()!=null && pst.getMembersurvey().getOccupation()!=null && pst.getMembersurvey().getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	 <%}else if(pst.getOccupationMother()!=null && masOccupation.getId()!=null && pst.getOccupationMother()!=null && pst.getOccupationMother().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	
	<%}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  name="contactNoMother"  value="<%=pst.getContactNoMother() != null ?pst.getContactNoMother():"" %>"/>


<%} %>
<h4>Father Details</h4>
<% if(pst.getMembersurvey().getRelationshipName()!=null &&  pst.getMembersurvey().getRelationshipName().equalsIgnoreCase("Father")){ %>
<div class="clear"></div>


<label>Father Name </label>
<input  type="text" readonly="readonly" name="fatherName" value="<%=pst.getMembersurvey().getPersonName() %>" validate="Father Name,string,no" maxlength="49" tabindex=1 onkeyup="validateFather(this.value);" id="fatherName"/>
 
<label>Education Status</label>
<%if(pst.getMembersurvey().getEducation()!=null){ %>
<input  type="text" readonly="readonly" value="<%=pst.getMembersurvey().getEducation()%>" name="educationStatusFather"/>
<%}else{ %>
<input  type="text" readonly="readonly" value="" name="educationStatusFather"/>
<%} %>

<label>Occupation</label>
<select disabled="disabled" name="occupationFather">
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
	 if(pst.getMembersurvey().getOccupation()!=null && pst.getMembersurvey().getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
		
	<%}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>
	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  readonly="readonly" value="<%=pst.getMembersurvey().getContactNo()%>" name="contactNoFather"/>



<%}else{ %>

<label>Father Name </label>
<input  type="text"  name="fatherName" value="<%=pst.getFatherName() != null ?pst.getFatherName():"" %>" validate="Father Name,string,no" maxlength="49" tabindex=1 onkeyup="validateFather(this.value);" id="fatherName"/>
 
<label>Education Status</label>
<input  type="text"   name="educationStatusFather"  value="<%=pst.getEducationStatusFather() != null ?pst.getEducationStatusFather():"" %>"/>

<label>Occupation</label>

<select name="occupationFather"> 
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
	 if(pst.getMembersurvey().getOccupation()!=null && pst.getMembersurvey().getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	
	 <%}else if(pst.getOccupationFather()!=null && masOccupation.getId()!=null && pst.getOccupationFather()!=null && pst.getOccupationFather().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	
	<%}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>
	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  name="contactNoFather"   value="<%=pst.getContactNoFather() != null ?pst.getContactNoFather():"" %>"/>

<%} %>

<div class="clear"></div>
<h4>Guardian / Emergency Contact Details</h4>
<label>Name </label>
<input  type="text" name="guardianName"  value="<%=pst.getGuardianName()%>" validate="Guardian Name,string,no" maxlength="49" tabindex=1 onkeyup="validateFather(this.value);" id="fatherName"/>
 
<label>Contact No.</label>
<input  type="text" name="guardianContactNo"  value="<%=pst.getGuardianContactno()%>" />

<label>Address</label>
	<%if(pst.getGuardianAddress()!=null){%>
<textarea rows="" cols="" name="guardianAddress"><%=pst.getGuardianAddress() %></textarea>
<%}else{ %>
<textarea rows="" cols="" name="guardianAddress"></textarea>
<%} %>
<label>Relationship</label>
<select name="relationId">
<option value="0">Select</option>
	<%for(MasRelation masRelation:relationList){
	
	if(pst.getRelation()!=null && pst.getRelation().getId()==masRelation.getId()){
	%> 
	 <option value="<%=masRelation.getId() %>" selected="selected"><%=masRelation.getRelationName().trim()  %></option>
	<%}else{ %>
	<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName().trim()  %></option>
	<%}}%>
	</select>
	

<input type="button" name="Submit" class="button" value="Update" onclick="submitForm('student','pubHealth?method=submitStudentRegistration')"/>
	<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
</div>


<%}}else{
if (phMemberSurveyValueList.size() > 0) {
	for (PhMemberSurvey st : phMemberSurveyValueList) {
%>

	
 <div id="memberSurveyValue">


<h4>Admission Information</h4>
<label> School </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" class="radioCheckCol1" onclick="schoolTypeList();"/> 

<label>Anganwadi </label>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="Anganwadi" class="radioCheckCol1" onclick="schoolTypeList();" />

<div id="schoolDiv" style="display: none;">
<div class="clear"></div>

<label><span>*</span>School Name </label>
<select name="<%= SCHOOL_ID%>" id="schoolNameId" tabindex="1"	   onblur="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getSchoolNameList&surveysId='+this.value,'testDivs');">
	<option value="0">Select</option>
	<%for(PhVillageSurvey school:  schoolList){ %>
<option value="<%=school.getId() %>"><%=school.getPlaceName() %></option>
<%} %>
</select>

 <div id="testDivs">

<label><span>*</span>Class</label>
<select name="<%= CLASS%>" tabindex="1">
</select>

	
<label><span>*</span>Section</label>
<select name="<%= SECTION%>" tabindex="1"	>
	<option value="">Select</option>

</select>
</div>
<div class="clear"></div>
 
 <label>Joining Date</label>
<input	type="text" id="joiningDateIdds" name="joiningDateIdSection" value=""	class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIdds,event)" />


 <label>Admission No.</label>
  <input type="text" name="admissionNoSection" maxlength="10"></input>
 

</div>


<div id="anganwadiDiv" style="display: none;">
<div class="clear"></div>

<label><span>*</span>Anganwadi Name </label>
<select name="<%=SCHOOL_ID%>" id="schoolNameId" tabindex="1"	 onblur="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getAnganwadiNameList&surveyId='+this.value,'testDivSurvey');">
	<option value="">Select</option>
	<%for(PhVillageSurvey school:  anganwadiList){ %>
<option value="<%=school.getId() %>" ><%=school.getPlaceName() %></option>
<%} %>
</select>


 <div id="testDivSurvey">
 

<label><span>*</span>Class</label>
<select name="<%=CLASS%>" tabindex="1">
</select>

	
<label><span>*</span>Division</label>
<select name="<%= SECTION%>" tabindex="1"	>
	<option value="">Select</option>

</select>
</div>
 <div class="clear"></div>
 <label>Joining Date</label>
 <input	type="text" id="joiningDateIdj" name="joiningDateIdDivision" value=""	class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" /> 
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('student',document.student.joiningDateIdj,event)" />

 <label>Admission No.</label>
  <input type="text" name="admissionNoDivision" id="admissionNoDivision" maxlength="10"></input>
 

</div>



<div class="clear"></div>

<input type="button" name="add" onclick="generateExcel();" accesskey="r"  tabindex=1  value="Export" class="buttonBig" />
<input type="button" name="add" onclick="updateExcel();" accesskey="r"  tabindex=1  value="Import" class="buttonBig" />
 <div class="clear"></div>
 
 <h4>Student Registraion Details</h4>
 
 
 <input type="hidden" value="<%=st.getId()%>" name ="memberSurveyId"></input>
<label>UHID No. </label> 
<%if(st.getAadhaarNo()!=null){ %>
<input type="text" value="<%=st.getAadhaarNo()%>" readonly="readonly"></input>
<%}else{ %>
<input type="text" value="" readonly="readonly"></input>
<%} %>


<label>Blood Group </label> 
	<%	 %>
<select  name="bloodGrpId"  id="bloodGrpId" validate="Blood Group,string,no" tabindex="1" disabled="disabled">
	<option value="0">Select</option>
	</select>
	
<label>Identification Mark 1 No. </label> 
<input type="text" name="IdentificationmarkName"></input>
	
	<div class="clear"></div>

<label><span>*</span>Student Name </label>
	<input  type="text" name="studentName" readonly="readonly" value="<%=st.getName()%>" validate="Student Name,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>


	<label><span>*</span>Gender </label> 
<select  name="genderId" validate="Gender,string,yes" tabindex="1" disabled="disabled" >
<option value="0">Select</option>
	<%for(MasAdministrativeSex masAdminGender:genderList){ 
	 if(st.getGender().getId()== masAdminGender.getId()){%>
	<option value="<%=masAdminGender.getId() %>" selected="selected"><%=masAdminGender.getAdministrativeSexName().trim()  %></option>
	<%}else{ %>
	<option value="<%=masAdminGender.getId() %>"><%=masAdminGender.getAdministrativeSexName().trim()  %></option>
	<%} }%>
	</select>
	
	<label>Identification Mark 2 No. </label> 
<input type="text" name="IdentificationmarkTwo" ></input>
	
		
	<div class="clear"></div>
<label>DOB</label>
<%if(st.getDateOfBirth()!=null){ %>
<input type="text" id="dobId" name="dob"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(st.getDateOfBirth()) %>" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"
	onblur="calculateAgeInAjax('student');" MAXLENGTH="30" />
	<%}else{ %>
	<input type="text" id="dobId" name="dob"	value="" class="date" onkeyup="
        var v = this.value;
        if (v.match(/^\d{2}$/) !== null) {
            this.value = v + '/';
        } else if (v.match(/^\d{2}\/\d{2}$/) !== null) {
            this.value = v + '/';
        }"
	onblur="calculateAgeInAjax('student');" MAXLENGTH="30" />
	<%} %>
<div id="dobcalId">
<img id="" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0"	onclick="setdate('<%=date %>',document.student.dob,event)"	validate="Pick a date"  tabindex="14" />
</div>
	
	
	<input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" /> 
<label>Age</label>
<div id="ageDiv">
<input type="text" readonly="readonly"  name="<%=AGE %>" id="age" value="<%=HMSUtil.calculateAgeByDOB(st.getDateOfBirth()) %>" 	onblur="checkForDOB();isAgeInteger(this.value);"  />
	<input type="hidden" name="ageTemp"	id="ageTemp" value="" /> 
	<input id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,no" tabindex="1" class="small"	onblur="checkForDOB();" value="Years" readonly="readonly" />
	 <input 	type="hidden" id="idForAge" name="idForAge" />
	</div>
		<div class="clear"></div>
		<label>Number of siblings</label> 
<input type="text" name="nameOfSiblings"></input>
	
	
<label>Address </label>
<input name="<%=ADDRESS %>" id="addr" tabindex="1" validate="Address,string,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)"  onkeyup="chkLength(this,100);"	maxlength="100"/>


		<label>Birth order of this child</label>
		<input type="text" name="birthOrderOfThisChild" />
		
		
			<div class="clear"></div>
		<label>Place of Birth</label>
		<input type="text" name="placeOfBirth"></input>
		
		
	
	
	
<div class="clear"></div>
<h4>Mother's Details</h4>

<%if(st.getRelationshipName()!=null && st.getRelationshipName().equalsIgnoreCase("Mother")){ %>
<label>Mother Name </label>
<input  type="text" name="motherName" value="<%=st.getPersonName() %>" readonly="readonly" validate="Mother Name,string,no" maxlength="49" tabindex=1 onkeyup="validateMother(this.value);" id="motherName"/>

<label>Education Status</label>
<input  type="text"  value="<%=st.getEducation()%>" readonly="readonly"   name="educationStatusMother"/>

<label>Occupation</label>
<select name="occupationMother">
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
		if(st.getOccupation()!=null){
	 if(st.getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>

	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text" value="<%=st.getContactNo()%>" readonly="readonly" name="contactNoMother"/>


<%}else{%>

<label>Mother Name </label>
<input  type="text" name="motherName"  value="" validate="Mother Name,string,no" maxlength="49" tabindex=1 onkeyup="validateMother(this.value);" id="motherName"/>


<label>Education Status</label>
<input  type="text"  value="" name="educationStatusMother"/>

<label>Occupation</label>
<select name="occupationMother">
<option value="0">Select</option>
<%for(MasOccupation masOccupation:occupationList){ 
		if(st.getOccupation()!=null){
	 if(st.getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%} }%>
	</select>


<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  value="" name="contactNoMother"/>

<%} %>
<h4>Father Details</h4>
<% if(st.getRelationshipName()!=null &&  st.getRelationshipName().equalsIgnoreCase("Father")){ %>
<div class="clear"></div>


<label>Father Name </label>
<input  type="text" name="fatherName" readonly="readonly" value="<%=st.getPersonName() %>" validate="Father Name,string,no" maxlength="49" tabindex=1 onkeyup="validateFather(this.value);" id="fatherName"/>
 
<label>Education Status</label>
<input  type="text" name="educationStatusFather" value="<%=st.getEducation()%>" readonly="readonly"/>

<label>Occupation</label>
<select name="occupationFather">
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
		if(st.getOccupation()!=null){	
	 if(st.getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}%>
	</select>
	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  value="<%=st.getContactNo()%>" readonly="readonly" name="contactNoFather"/>



<%}else{ %>

<label>Father Name </label>
<input  type="text" name="fatherName" validate="Father Name,string,no" maxlength="49" tabindex=1 onkeyup="validateFather(this.value);" id="fatherName"/>
 
<label>Education Status</label>
<input  type="text"  value="" name="educationStatusFather"/>

<label>Occupation</label>

<select name="occupationFather"> 
<option value="0">Select</option>
	<%for(MasOccupation masOccupation:occupationList){ 
		if(st.getOccupation()!=null){	
	 if(st.getOccupation().getId()== masOccupation.getId()){%>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}else{ %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName().trim()  %></option>
	<%}}%>
	</select>
	
<div class="clear"></div>

<label>Contact No.</label>
<input  type="text"  name="contactNoFather" value=""/>

<%} %>

<div class="clear"></div>
<h4>Guardian / Emergency Contact Details</h4>
<label>Name </label>
<input  type="text" name="guardianName" value="" validate="Guardian Name,string,no" maxlength="49" tabindex=1  id="fatherName"/>
 
<label>Contact No.</label>
<input  type="text" name="guardianContactNo"/>

<label>Address</label>
<textarea rows="" cols="" name="guardianAddress"></textarea>

<label>Relationship</label>
<select name="relationId">
<option value="0">Select</option>
	<%for(MasRelation masRelation:relationList){%> 
	 
	
	<option value="<%=masRelation.getId() %>"><%=masRelation.getRelationName().trim()  %></option>
	<%}%>
	</select>
	
	<input type="button" name="Submit" class="button" value="Submit" onclick="submitForm('student','pubHealth?method=submitStudentRegistration')"/>
	<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

</div>

<%}} }%>



