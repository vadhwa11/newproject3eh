<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}

	if (map.get("doctorList") != null) {
		doctorList = (List<MasEmployee>) map.get("doctorList");
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
<div class="Block"><label><span>*</span> Examination type</label> <select
	name="typeId" id="typeId" validate="Type,string,yes"
	onchange="">
	<option value="0">select</option>
	<option value="1">Pre-employment</option>
	<option value="2">Post-employment</option>
</select> 
<label> <span>*</span> Emp No</label> 
<input type="text" id="empCode" name="empCode"	onblur="submitProtoAjaxWithDivName('medicalExamForm','training?method=getNameDepartmentforAjax', 'forNameDept' )" /> 
<div id="forNameDept">
	
<label><span>*</span> Employee Name</label> <input type="text" id="name" name="name" validate="Name,string,yes" />

<div class="clear"></div>
<div class="clear"></div>

<label><span>*</span> Department</label> 
<!--  
<input type="hidden" name="departmentId" id="departmentId" validate="Department,integer,yes" >
<input type="text" name="departmentName" id="departmentName" validate="Department Name,string,yes" > 
-->
<select name="departmentId" id="departmentId" validate="Type,string,yes" >
    <option value="0">select</option>
	<% for (MasDepartment dept : departmentList) {%>
	<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
	<%}%>
</select> 

</div>

<label>Date Of Birth</label> <input type="text" class="date" tabindex="1"
	validate="Date Of Birth,string,yes" id="dateOfBirth" name="dateOfBirth"
	readonly="readonly" value="<%=currentDate%>" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfBirth,'event')" />
<label>Date Of joining</label> <input type="text" class="date"
	tabindex="1" validate="Date Of Birth,string,yes" id="dateOfJoin"
	name="dateOfJoin" readonly="readonly" value="<%=currentDate%>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfJoin,'event')" />
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> Blood Group </label> <select name="bloodId" id="bloodId"
	validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%for (MasBloodGroup blood : bloodGroupList) {%>
	<option value="<%=blood.getId()%>"><%=blood.getBloodGroupName()%></option>
	<%}%>
</select> <label>Height </label> <input type="text" name="height" id="height" />
<label>Identification Mark </label> <input type="text"
	name="identification" id="identification" /></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>Obesrvation based on physical examination by the Medical
practitioner</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block"><label>Date Of Examination</label> <input
	type="text" class="date" tabindex="1"
	validate="Date Of Path Exam,string,yes" id="dateOfPersDate"
	name="dateOfPersDate" readonly="readonly" value="<%=currentDate%>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfPathDate,'event')" />


<label>PAST HISTORY</label> <textarea name="pastHistory"
	id="pastHistory" validate="Care Summary,string,no" cols="25" rows="2"></textarea>

<label>PERSONAL HISTORY</label> <textarea name="personalHistory"
	id="personalHistory" validate="Instructions To Patient,string,no"
	cols="25" rows="2"></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>FAMILY HISTORY</label> <textarea name="familyHistory"
	id="familyHistory" validate="Family history,string,no" cols="25"
	rows="2"></textarea> <label>PRESENT COMPLAINT </label> <textarea
	name="presentComplaint" id="Prsent complaint,string,no" cols="25"
	rows="2"></textarea> <label>WEIGHT(in Kgs) </label> <input type="text"
	name="weightInKgs" id="weightInKgs" maxlength="30"
	validate="weight,integer,no" onkeypress="return isNumberKey(event)"/>

<div class="clear"></div>
<div class="clear"></div>

<label>EYE VISION</label> <textarea name="eyeVision" id="eyeVision"
	validate="Eye Vision,string,no" cols="25" rows="2"></textarea> 
	
<label>COLOR VISION</label> 

<textarea name="colorVision" id="colorVision"
	validate="Color Vision,string,no" cols="25" rows="2"></textarea> 
	
<label>OTHERS</label>
<textarea name="others" id="others" validate="Others,string,no"
	cols="25" rows="2"></textarea> <label>MOUTH, EAR, THROAT</label> <textarea
	name="mouth" id="mouth" validate="Mouth Ear Throat,string,no" cols="25"
	rows="2"></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>SKIN CONDITION</label> 
<textarea name="skin" id="skin"
	validate="Skin,string,no" cols="25" rows="2"></textarea> 

<label>RESPIRATORY SYSTEM</label>
<textarea name="respiratory" id="respiratory"
	validate="Respiratory,string,no" cols="25" rows="2"></textarea> 
<label>CARDIOVASCULAR SYSTEM</label>
<textarea name="cardiovascular" id="cardiovascular"
	validate="cardiovascular,string,no" cols="25" rows="2"></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>B.P</label><input type="text" name="bloodPressure"
	id="bloodPressure" maxlength="50" validate="Blood Pressure,String,no"/>

<label>ABDOMEN</label><textarea name="abdomen" id="abdomen"
	validate="Abdomen,string,no" cols="25" rows="2"></textarea> <label>GENITO
URINARY SYSTEM</label><textarea name="genito" id="genito"
	validate="Genito,string,no" cols="25" rows="2"></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>MASCULO SKELETON SYSTEM</label><textarea name="Masculo"
	id="Masculo" validate="Masculo Skeleton,string,no" cols="25" rows="2"></textarea>

<label>NERVOUS SYSTEM</label><textarea name="nervous" id="nervous"
	validate="Nervous,string,no" cols="25" rows="2"></textarea></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<h4>[Part II] Obesrvation based on pathological tests conducted</h4>
<div class="clear"></div>

<div class="clear"></div>

<div class="Block"><label>Date Of Examination</label> <input
	type="text" class="date" tabindex="1"
	validate="Date Of Path Exam,string,yes" id="dateOfPathDate"
	name="dateOfPathDate" readonly="readonly" value="<%=currentDate%>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.dateOfPathDate,'event')" />

<label>CHEST X-RAY</label><textarea name="chest" id="chest"
	validate="Chest,string,no" cols="25" rows="2"></textarea> <label>BLOOD</label><textarea
	name="blood" id="blood" validate="Blood,string,no" cols="25" rows="2"></textarea>

<label>URINE</label><textarea name="urine" id="urine"
	validate="Urine,string,no" cols="25" rows="2"></textarea> <label>ANY
OTHER TEST</label><textarea name="otherTest" id="otherTest"
	validate="Other test,string,no" cols="25" rows="2"></textarea></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<h4>[Part II] Obesrvation of the Doctor</h4>

<div class="clear"></div>

<div class="clear"></div>
<div class="Block"><label>Observation Date</label> <input
	type="text" class="date" tabindex="1"
	validate="Date Of Path Exam,string,yes" id="observeDate"
	name="observeDate" value="<%=currentDate%>" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate%>',document.medicalExamForm.observeDate,'event')" />


<label>Any Additional Remarks</label><textarea name="addRemarks"
	id="addRemarks" validate="Other test,string,no" cols="25" rows="2"></textarea>

<label>FIT/UNFIT (if unfit, give details)</label> <select
	name="FitUnFit" id="FitUnFit" validate="Fit UnFit,string,yes">
	<option value="0">select</option>
	<option value="1">Fit</option>
	<option value="2">UnFit</option>
</select>

<div class="clear"></div>
<div class="clear"></div>
<label>Unfit Remarks(If any)</label><textarea name="unFitRemarks"
	id="unFitRemarks" validate="Other test,string,no" cols="25" rows="2"></textarea>


<label>Doctor</label> <select name="doctorId" id="doctorId"
	validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%for (MasEmployee employee : doctorList) {%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName() + ' '
						+ employee.getMiddleName() + ' '
						+ employee.getLastName()%></option>
	<%}%>
</select></div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"
	onClick="submitForm('medicalExamForm','training?method=addMedicalExamEntry');" />
<input type="button" class="button" value="Search"
	onClick="submitFormForSearch('medicalExamForm');" /> <input
	type="button" class="button" value="Cancel" /> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE%>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME%>" value="<%=time%>" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

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