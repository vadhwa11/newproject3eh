<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HrMedicalRecord"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrPatientSickCertificate"%>
<script type="text/javascript" src="../jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<script type="text/javascript" language="javascript">
<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String getDate = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (getDate.length() < 2) {
				getDate = "0" + getDate;
			}%>
serverdate = '<%=getDate + "/" + month + "/" + year%>'
</script>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	String entryNo = "MS/VBCH/CERT/";
	String max = "";
	String userName = "";
	String message = "";
	
	List<HrMedicalRecord> medicalRecordList = new ArrayList<HrMedicalRecord>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasEmployee> employeeDoctorList = new ArrayList<MasEmployee>();
	
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if (map.get("medicalRecordList") != null) {
		medicalRecordList = (List<HrMedicalRecord>) map.get("medicalRecordList");
	}

	if (map.get("employeeDoctorList") != null) {
		employeeDoctorList = (List<MasEmployee>) map.get("employeeDoctorList");
	}

	if (map.get("bloodGroupList") != null) {
		bloodGroupList = (List<MasBloodGroup>) map
				.get("bloodGroupList");
	}

	int counter = 1;
	if (map.get("counter") != null) {
		counter = (Integer) map.get("counter");
	}
	if (counter > 0) {
		entryNo = entryNo + counter;
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
%>

<h4><span><%=message%></span></h4>
<%
	}
%>
<div class="titleBg">
<h2>12 Medical Examination Report (Pre- Employment/ Periodical)</h2>
</div>
<div class="clear paddingTop15"></div>
<form action="" method="post" name="medicalExamForm"
	id="medicalExamForm">
<div class="Block">
<% 
for(HrMedicalRecord medRecord : medicalRecordList)
{
  

%>

<label><span>*</span> Examination type</label>
<% if (medRecord.getExamType().equals(1))
{ %>
<input type="text" name="typeIds" id="typeIds" value="Pre-employment" readonly="readonly"/>
<input type="hidden" name="typeId" id="typeId" value=1 readonly="readonly"/>

<% }
else if (medRecord.getExamType().equals(2))
{ %>
	<input type="text" name="typeIds" id="typeIds" value="Post-employment" readonly="readonly"/>
	<input type="hidden" name="typeId" id="typeId" value=2 />
<% 	
}
%>
<label> <span>*</span> Emp No</label> 
<input type="text" id="empCode" name="empCode" value="<%= medRecord.getEmpCode() %>" readonly="readonly"/>

	
<label><span>*</span> Employee Name</label> 
<input type="text" id="name" name="name" value="<%= medRecord.getEmpName() %>" readonly="readonly" />

<div class="clear"></div>
<div class="clear"></div>

<label><span>*</span> Department</label> 
<input type="text" id="departmentId" name="departmentIds" value="<%= medRecord.getDepartment().getDepartmentName() %>" readonly="readonly" />
<input type="hidden" id="departmentId" name="departmentId" value="<%= medRecord.getDepartment().getId() %>" readonly="readonly" />


<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> Blood Group </label> 
<input type="text" id="bloodIds" name="bloodIds" value="<%= medRecord.getBloodGroup().getBloodGroupName() %>" readonly="readonly" />
<input type="hidden" id="bloodId" name="bloodId" value="<%= medRecord.getBloodGroup().getId() %>" />


<label>Height </label> <input type="text" name="height" id="height" value="<%= medRecord.getHeight() %>" readonly="readonly" />
<label>Identification Mark </label> <input type="text" name="identification" id="identification" value="<%= medRecord.getIdentificationMark() %>"/></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>



<h4>Obesrvation based on physical examination by the Medical
practitioner</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block"><label>Date Of Examination</label> <input
	type="text" class="date" tabindex="1" value="<%=HMSUtil.convertDateToStringWithoutTime(medRecord.getPhysicalExamDate()) %>"
	validate="Date Of Path Exam,string,yes" id="dateOfPersDate"
	name="dateOfPersDate" MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfPathDate,'event')" />


<label>PAST HISTORY</label> <textarea name="pastHistory"
	id="pastHistory" validate="Care Summary,string,no" cols="25" rows="2"><%= medRecord.getPastHistory() %></textarea>

<label>PERSONAL HISTORY</label> <textarea name="personalHistory"
	id="personalHistory"  validate="Instructions To Patient,string,no"
	cols="25" rows="2"><%= medRecord.getPersonalHabits() %></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>FAMILY HISTORY</label> <textarea name="familyHistory"
	id="familyHistory"  validate="Family history,string,no" cols="25"
	rows="2"><%= medRecord.getFamilyHistory() %></textarea> 

<label>PRESENT COMPLAINT </label> <textarea
	name="presentComplaint" id="Prsent complaint,string,no" cols="25"
	rows="2" ><%= medRecord.getPresentComplain() %></textarea> 
	
<label>WEIGHT(in Kgs) </label> <input type="text"
	name="weightInKgs" id="weightInKgs" maxlength="30" value="<%= medRecord.getWeight() %>"
	validate="weight,integer,no" onkeypress="return isNumberKey(event)"/>

<div class="clear"></div>
<div class="clear"></div>

<label>EYE VISION</label> <textarea name="eyeVision" id="eyeVision" 
	validate="Eye Vision,string,no" cols="25" rows="2"><%= medRecord.getEyesight() %></textarea> 
	
<label>COLOR VISION</label> <textarea name="colorVision" id="colorVision" 
	validate="Color Vision,string,no" cols="25" rows="2"><%= medRecord.getColorVision() %></textarea> 

<label>OTHERS</label>
<textarea name="others" id="others" value="<%= medRecord.getOthers() %>" validate="Others,string,no"
	cols="25" rows="2"></textarea> 
	
<label>MOUTH, EAR, THROAT</label> <textarea
	name="mouth" id="mouth" value="<%= medRecord.getMouthEarThroat() %>" validate="Mouth Ear Throat,string,no" cols="25"
	rows="2"></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>SKIN CONDITION</label> <textarea name="skin" id="skin" 
	validate="Skin,string,no" cols="25" rows="2"><%= medRecord.getSkinCondition() %></textarea> 
	
<label>RESPIRATORY
SYSTEM</label><textarea name="respiratory" id="respiratory"
	validate="Respiratory,string,no" cols="25" rows="2"><%= medRecord.getRespiratorySystem() %></textarea> 
	
<label>CARDIOVASCULAR SYSTEM</label><textarea name="cardiovascular" id="cardiovascular"
	validate="cardiovascular,string,no" cols="25" rows="2"><%= medRecord.getCardiovascularSystem() %></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>B.P</label><input type="text" name="bloodPressure"
	id="bloodPressure" maxlength="50" value="<%= medRecord.getBloodPressure() %>" validate="Blood Pressure,String,no"/>

<label>ABDOMEN</label><textarea name="abdomen" id="abdomen"
	validate="Abdomen,string,no" cols="25" rows="2"><%= medRecord.getAbdomen() %></textarea> 

<label>GENITO
URINARY SYSTEM</label><textarea name="genito" id="genito"
	validate="Genito,string,no" cols="25" rows="2"><%= medRecord.getGenitoUrinarySystem() %></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>MASCULO SKELETON SYSTEM</label><textarea name="Masculo"
	id="Masculo" validate="Masculo Skeleton,string,no" cols="25" rows="2"><%= medRecord.getMasculoGenitalSystem() %></textarea>

<label>NERVOUS SYSTEM</label><textarea name="nervous" id="nervous"
	validate="Nervous,string,no" cols="25" rows="2"><%= medRecord.getNervousSystem() %></textarea></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<h4>[Part II] Obesrvation based on pathological tests conducted</h4>
<div class="clear"></div>

<div class="clear"></div>

<div class="Block"><label>Date Of Examination</label> <input
	type="text" class="date" tabindex="1"
	validate="Date Of Path Exam,string,yes" id="dateOfPathDate"
	name="dateOfPathDate" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medRecord.getPathoExamDate()) %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfPathDate,'event')" />

<label>CHEST X-RAY</label><textarea name="chest" id="chest" 
	validate="Chest,string,no" cols="25" rows="2"><%= medRecord.getChestXRay() %></textarea> 
	
<label>BLOOD</label><textarea
	name="blood" id="blood" validate="Blood,string,no" cols="25" rows="2"><%= medRecord.getBlood() %></textarea>

<label>URINE</label><textarea name="urine" id="urine" 
	validate="Urine,string,no" cols="25" rows="2"><%= medRecord.getUrine() %></textarea> 
	
<label>ANY
OTHER TEST</label><textarea name="otherTest" id="otherTest"
	validate="Other test,string,no" cols="25" rows="2" ><%= medRecord.getAnyOtherTest() %></textarea></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<h4>[Part II] Obesrvation of the Doctor</h4>

<div class="clear"></div>

<div class="clear"></div>
<div class="Block"><label>Observation Date</label> <input
	type="text" class="date" tabindex="1"
	validate="Date Of Path Exam,string,yes" id="observeDate"
	name="observeDate" value="<%=HMSUtil.convertDateToStringWithoutTime(medRecord.getDocObservationDate())%>" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.observeDate,'event')" />


<label>Any Additional Remarks</label><textarea name="addRemarks"
	id="addRemarks" validate="Other test,string,no" cols="25" rows="2"><%= medRecord.getAddlRemarks() %></textarea>

<label>FIT/UNFIT (if unfit, give details)</label> 
<select name="FitUnFit" id="FitUnFit" validate="Fit UnFit,string,no">
	
<%
if(medRecord.getFitUnfit()==0)
{
%>
	<option value="0" selected="selected">Select</option>
	<option value="1" >Fit</option>
	<option value="2" >UnFit</option>
	<%}

if(medRecord.getFitUnfit()==1)
{
%>
	<option value="0" >Select</option>
	<option value="1" selected="selected">Fit</option>
	<option value="2" >UnFit</option>
	<%}
if(medRecord.getFitUnfit()==2)
{
%>
	<option value="0" >Select</option>
	<option value="1" >Fit</option>
	<option value="2" selected="selected">Unfit</option>
	
	<%} %>

		</select> 


<div class="clear"></div>
<div class="clear"></div>
<label>Unfit Remarks(If any)</label><textarea name="unFitRemarks"
	id="unFitRemarks" validate="Other test,string,no" cols="25" rows="2"><%= medRecord.getFitUnfitRemarks() %></textarea>


<label>Doctor</label> 

<select name="doctorId" id="doctorId"
	validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeDoctorList){
	
	if(medRecord.getDoctor().getId().equals(employee.getId()))
	{
	%>
	<option value="<%=employee.getId()%>" selected="selected"><%=employee.getFirstName()+' '+ employee.getMiddleName() + ' '+employee.getLastName()%></option>
	
	<%}
	if(!medRecord.getDoctor().getId().equals(employee.getId()))
	{
	%>
	<option value="<%=employee.getId()%>" ><%=employee.getFirstName()+' '+ employee.getMiddleName() + ' '+employee.getLastName()%></option>
	<%}} %>
	</select>




</div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Update"
	onClick="submitForm('medicalExamForm','training?method=editMedicalExamEntry');" />
<input type="button" class="button" value="Print" onClick="submitForm('medicalExamForm','training?method=printMedicalExaminationReport');"/> 
	
<input type="hidden" name="<%=CHANGED_BY%>"   value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE%>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME%>" value="<%=time%>" />
<input type="hidden" name="<%=TRAINING_ID%>" value="<%= medicalRecordList.get(0).getId()%>" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<% } %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<SCRIPT language=Javascript>//script for entering only integer
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }

      function submitFormForSearch(val)
      {
       var formName=val;
       document.medicalExamForm.action='training?method=showSearchMedicalExamEntry';   
       document.medicalExamForm.submit();
      } 
      function forPreOrPost(val)
      {
         // alert(val);
          var typeId=0;
         
        	  typeId=document.medicalExamForm.typeId.value;
         
        //  alert(typeId);
                 if (typeId=="1"){
                //     alert("Pre-employment");
                     document.medicalExamForm.empCode="";
                     document.medicalExamForm.name.value="";
                     document.medicalExamForm.departmentName.value="";
                 }
                 else{
                     
                //     alert("Post-employment");
                     ajaxFunctionForEmployeeNameDepartment(val);
                 }
      }  

      function forPreOrPostdisable()
      {
         // alert(val);
          var
	typeId=0; typeId=document.medicalExamForm.typeId.value;
	alert(typeId);
        	  if (typeId==2)
	{
            	  alert("cxc"+typeId);
        		  document.medicalExamForm.name.value=""
	;
                  document.medicalExamForm.name.readOnly=true;
	}
        	  else if(typeId==1)
	{
        		  alert("cxc"+typeId);
        		 // document.medicalExamForm.name.value=""
	;
                  document.medicalExamForm.name.readOnly=false;}//-->
} </SCRIPT>