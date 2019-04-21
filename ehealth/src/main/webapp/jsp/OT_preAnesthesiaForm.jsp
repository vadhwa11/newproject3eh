<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<!--<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
--><!--</script>
--><!--<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
-->
      <!--  By Vishnu -->
 <%
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	String icd="";
	 List opdSurgeryList = new ArrayList();
	 List opdPatientHistoryList= new ArrayList();	
	 List<PatientPrescriptionDetails> patientPrescriptionDetailList= new ArrayList<PatientPrescriptionDetails>();
	if(map.get("opdSurgeryList") != null){
		opdSurgeryList=(List)map.get("opdSurgeryList");
	}
	if(map.get("icd")!=null){
		icd=(String)map.get("icd");
	}
	if(map.get("opdPatientHistoryList") != null){
		opdPatientHistoryList=(List)map.get("opdPatientHistoryList");
	}
	if(map.get("patientPrescriptionDetailList") != null){
		patientPrescriptionDetailList=(List)map.get("patientPrescriptionDetailList");
	}
	OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader)opdSurgeryList.get(0);
	
	String patientName="";
	if(opdSurgeryHeader.getHin().getPFirstName()!= null){
		patientName=opdSurgeryHeader.getHin().getPFirstName();
	}
	if(opdSurgeryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPMiddleName();
	}
	if(opdSurgeryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+opdSurgeryHeader.getHin().getPLastName();
	}
	String servicePersonName="";
	if(opdSurgeryHeader.getHin().getSFirstName()!= null){
		servicePersonName=opdSurgeryHeader.getHin().getSFirstName();
	}
	if(opdSurgeryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSMiddleName();
	}
	if(opdSurgeryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+opdSurgeryHeader.getHin().getSLastName();
	}
	 String requisitionDateInString =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
	int deptId=opdSurgeryHeader.getPrescribedDepartment().getId();
	String departmentName=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName();
	List<MasAnesthesia> anesthesiaList= new ArrayList<MasAnesthesia>();
	if(map.get("anesthesiaList") != null){
		anesthesiaList=(List)map.get("anesthesiaList");
	}
	List<BloodMasComponent>BloodMasComponentList=new ArrayList<BloodMasComponent>();
	if(map.get("BloodMasComponentList") != null){
		BloodMasComponentList=(List)map.get("BloodMasComponentList");
	}
	List<MasEmployee>doctorList=new ArrayList<MasEmployee>();
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
	}
	List<OpdPatientDetails>patientDetailsList=new ArrayList<OpdPatientDetails>();
	if(map.get("patientDetailsList") != null){
		patientDetailsList=(List)map.get("patientDetailsList");
	}
	String anesthesia="";
	if(map.get("anesthesia") != null){
		anesthesia=(String)map.get("anesthesia");
	}
	List<MasInstituteDepartment>instituteDepartmentList=new ArrayList<MasInstituteDepartment>();
	if(map.get("instituteDepartmentList")!=null){
		instituteDepartmentList=(List<MasInstituteDepartment>)map.get("instituteDepartmentList");
	}
		
	
	Double height=0.0;
	Double weight=0.0;
	String bmi="";
	String bmiStatus="";
	String bp="";
		
	for(OpdPatientDetails OpdPatientDetails:patientDetailsList){
		if(OpdPatientDetails.getHeight()!=null)
		{
		height=OpdPatientDetails.getHeight();
		}
		if(OpdPatientDetails.getWeight()!=null)
		{
		weight=OpdPatientDetails.getWeight();
		}
		if(OpdPatientDetails.getBmi()!=null){
		bmi=""+OpdPatientDetails.getBmi();
		}
		if(OpdPatientDetails.getBp()!=null){
		bp=OpdPatientDetails.getBp();
		}
		//bmiStatus=OpdPatientDetails.getBmiStatus();
	}
	%>
 <title>Pre-Anesthesia Assessment Form Entry</title>
<form name="preAnesthesia" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Pre-Anesthesia Assessment Form Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>Requisition No.</label> 
<input type="text" readonly="readonly" value="<%=(opdSurgeryHeader.getOrderNo()!=null?opdSurgeryHeader.getOrderNo():"")  %>"  />
<label>Requisition Date</label> 
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getRequisitionDate() %>"  />
<%-- <input type="text" readonly="readonly" value="<%=currentDate %>"  /> --%>
</div>
<!--Block One Starts-->
<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>

<label >UHID</label> 
<%if(opdSurgeryHeader.getHin().getHinNo()!= null){ %>
<input type="text" readonly="readonly" id="hinNoUHID" value="<%=opdSurgeryHeader.getHin().getHinNo() %>"  />
<%}else{ %> 
<input type="text" readonly="readonly" value="-"  />
<%} %> 
<label>Patient Name </label> 
<%if(patientName!= null){ %> 
<input type="text" readonly="readonly" value="<%=patientName %>"  />
<%}else{ %> 
<input type="text" readonly="readonly" value="-"  />
<%} %> 
 
<label >Gender</label> 
<%if(opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()!= null){ %>
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName() %>"  />
<%}else{ %> 
<input type="text" readonly="readonly" value="-"  />
<%} %> 

<%--  
<label >Req. Date </label> 
<%if(requisitionDateInString != null){ %> 
<input type="text" readonly="readonly" value="<%=requisitionDateInString %>"  />
<%}else{ %> 
<input type="text" readonly="readonly" value="-"  />
<%} %> 

 <label >Patient Type </label> 
<%if(opdSurgeryHeader.getPatientStatus()!= null){ %>
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getPatientStatus() %>"  />
<%}else{ %>
<input type="text" readonly="readonly" value="-"  />
<%}
	  if(opdSurgeryHeader.getPatientStatus().equalsIgnoreCase("OutPatient")){
	%> <label >Visit No. </label> <%if(opdSurgeryHeader.getVisit()!= null){ %>
<label class="valueMedium"><%=opdSurgeryHeader.getVisit().getVisitNo() %></label>
<input name="visitId" id="visitId" type="hidden"
	value="<%=opdSurgeryHeader.getVisit().getId() %>" /> <%}else{ %> <label
	class="valueMedium">-</label> <%}
	  }else{	
	%>  --%>
<div class="clear"></div>
<%if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getAdNo()!= null){ %> 
<label>IP No. </label> 
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getInpatient().getAdNo() %>" />
 <input	name="inPatientId" id="inPatientId" type="hidden"value="<%=opdSurgeryHeader.getInpatient().getId() %>" /> 
	<%}else{ %> <label>Visit No. </label> 
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getVisit().getVisitNo() %>" />
 <input	name="visitId" id="visitId" type="hidden"value="<%=opdSurgeryHeader.getVisit().getId() %>" />  <%} %>
	
	
<label >Age</label>
<%if(opdSurgeryHeader.getHin().getAge()!= null){ %> 
 
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getHin().getAge() %>"  />
<%}else{ %>
<input type="text" readonly="readonly" value="-" />
<%} %>
 
   <label>Admitted By </label> 
   <%if(opdSurgeryHeader.getInpatient() != null){ 
	   if(opdSurgeryHeader.getInpatient().getOpdPatientDetails() != null){ 
		   if(opdSurgeryHeader.getInpatient().getOpdPatientDetails().getEmployee()!= null){ 
    %>
<%if(opdSurgeryHeader.getInpatient().getOpdPatientDetails().getEmployee().getEmployeeName()!= null){ %> 
<input type="text" readonly="readonly" value="<%=opdSurgeryHeader.getInpatient().getOpdPatientDetails().getEmployee().getEmployeeName() %>" />
   <%}else{ %>  
	<input type="text" readonly="readonly" value="-"  />
	 <%}}}} %>    
 
<div class="clear"></div>
<label>Provisional Diagnosis </label> 
<%if(icd!= null){ %> 
<textarea class="large"  readonly="readonly"  ><%=icd%></textarea>
  
	<%}else{ %>  
	<textarea class="large" readonly="readonly" >-</textarea>
	 <%} %> 
<div class="clear"></div>	  
<div class="Block">
<label>Height</label>
<%if(height!=0){ %>
<input type="text" name="height" id="heightId" value="<%=height %>" />
<%}else{ %>
<input type="text" name="height" id="heightId" value="" />
<%} %>
<label>Weight</label>
<%if(weight!=0){ %>
<input type="text" name="weight" id="weightId" value="<%=weight %>" onblur="calculateBMI();"/>
<%}else{ %>
<input type="text" name="weight" id="weightId" value="" onblur="calculateBMI();" />
<%} %>
<label>BMI</label>
<%if(bmi!=null && !bmi.equals("")){ %>
<input type="text" name="bmi" id="bmiId" value="<%=bmi %>" />
<%}else{ %>
<input type="text" name="bmi" id="bmiId" />
<%} %>
<label>BMI Status</label>
<input type="text" name="bmiStatus" id="bmiStatusId" readonly="readonly"  />
</div>

<div class="clear"></div> 
<h4>Prescription Details</h4>
<div class="clear"></div>
<table>
<tr>
<th>Item Name</th>
<th>Frequency</th>
<th>No of Days</th>
<th>Dosage</th>
<th>Total</th>
</tr>
<%for(PatientPrescriptionDetails PatientPrescriptionDetails:patientPrescriptionDetailList){ %>
<tr>
<td><%=PatientPrescriptionDetails.getItem().getNomenclature() %></td>
<%if(PatientPrescriptionDetails.getFrequency()!=null){ %>
<td><%=PatientPrescriptionDetails.getFrequency().getFrequencyName() %></td>
<%}else{ %>
<td>-</td>
<%} %>
<td><%=PatientPrescriptionDetails.getNoOfDays() %></td>
<td><%=PatientPrescriptionDetails.getDosage() %></td>
<td><%=PatientPrescriptionDetails.getTotal() %></td>
</tr>

<%} %>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Previous Anesthetics Details</h4>
<textarea name="anestheticName" cols="0" readonly="readonly"
	rows="0" class="large" style="margin-left:7px;" ><%=anesthesia %>
	</textarea>
<div class="clear"></div>
<div class="paddingTop15"></div>

<label>Surgery Name </label> <textarea name="surgeryName" cols="0"
	rows="0" class="large" >
		<%
		String message1="No records.";
		if(opdSurgeryHeader.getOpdSurgeryDetails()!=null){
			 
		%>
		<%=((OpdSurgeryDetail)(opdSurgeryHeader.getOpdSurgeryDetails().toArray()[0])).getChargeCode().getChargeCodeName() %>
		<% }else{%>
		<%=message1%>
<%} %>
</textarea>
<input type="button" name="Submit" class="button" value="Allergy"
	onclick="javascript:openPopupWindow();" />

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
 
<div class="division"></div>
<!--Block one Ends--> <label>Patient Past History</label> <% 
		String presentHistory="";
		String pastHistory="";
		String presentMedication="";
		int opdPatientHistoryId=0;
		if(opdPatientHistoryList!= null && opdPatientHistoryList.size()>0){
		 OpdPatientHistory opdPatientHistory= (OpdPatientHistory)opdPatientHistoryList.get(0);
			 presentHistory=opdPatientHistory.getPersonalPresentHistory();
			 pastHistory=opdPatientHistory.getPersonalPastHistory();
			 opdPatientHistoryId=opdPatientHistory.getId();
			 presentMedication=opdPatientHistory.getPersonalPresentMedication();
		}
		if(pastHistory !=null){
		%> <textarea name="pastHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)"><%=pastHistory %></textarea>
<%}else { %> <textarea name="pastHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)">No Records.</textarea>
<%} %> <!-- <h5>Past History</h5>
	<textarea name="pastHistory" cols="0" rows="0" class="large" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>
	 -->
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Drug Therapy </label> <textarea name="drugTreatment" cols="0"
	rows="0" class="large" >
		<%
		String message="No records.";
		if(presentMedication!=null){
			if(!presentMedication.equals("")){
		%>
		<%=presentMedication %>
		<% }}else{%>
		<%=message%>
<%} %>
</textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Patient Personal History</label> <%if (presentHistory!=null){ %> <textarea
	name="presentHistory" cols="0" rows="0" class="large" maxlength="500"
	onkeyup="return ismaxlength(this)"><%=presentHistory %></textarea> <%}else{ %>
<textarea name="presentHistory" cols="0" rows="0" class="large"
	maxlength="500" onkeyup="return ismaxlength(this)">No Records</textarea>
<%} %>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Smoking/ Alcohol</label>

<select name="smoking" class="midium" >
	<option value="">Select</option>
	<option value="Smoking">Smoking</option>
	<option value="Alcohol">Alcohol</option>
	<option value="Both">Both</option>
</select>

<label>Prev Treatment/Surgery</label> <input name="Previous treatment"
	type="text" class="large" maxlength="100" />
<div class="clear"></div>
<label>Diet Category</label>
<select name="smoking" class="midium">
	<option value="">Select</option>
	<option value="veg">VEG</option>
	<option value="nonVeg">NON-Veg</option>
</select>
<div><label>Drug Therapy </label></div>
<input name="drugTherapy" type="text" class="large" maxlength="45" />
</div>
<div class="clear"></div>
<h4>Bed Arrangements</h4>
<div class="clear"></div>
<div class="Block">
<label>Arrange Bed</label>
<input type="checkbox" name="arrangeBed" id="arrangeBedId" value="" onclick="setBedStatus()" />
<input type="hidden" name="arrangeBed1" id="arrangeBedId1" value="n" />
<div id="ventilatorId" style="display: none;">
<label>Ward</label>
<select name="wardName" id="wardId">
<option value="0">Select</option>
<%for(MasInstituteDepartment dept:instituteDepartmentList){ %>
<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName() %></option>
<%} %>
</select>
<select name="vent" >
<option value="withVen">With Ventilator</option>
<option value="withoutVen">Without Ventilator</option>
</select>
<div class="clear"></div>
<label>Remarks</label>
<textarea class="large" name="remarksForBedArrangement" maxlength="250">

</textarea>
</div>

</div>


<div class="Block">
<h4>General Examination</h4>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label >Pulse</label> <input name="pulse" type="text" maxlength="15"  />
<label>Icetrus</label> <input name="icetrus" type="text" maxlength="15"  />
<label >Nourishment</label><input name="nourishment" type="text" maxlength="15"  />
<label>Pallor</label> <input name="pallor" type="text"	maxlength="15"  />

<label >Oedema</label> <input name="oedema" type="text" maxlength="15"  />
<label >BP</label> 
<%if(bp!=null && !bp.equals("")){ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" value="<%=bp %>" maxlength="10" />
<%}else{ %>
<input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" maxlength="10" />
<%} %>
<div class="clear"></div> 
<label>Cyanosis</label> <input name="cyanosis" type="text" maxlength="15"  /> 
<label >Spine</label> <input name="spine" type="text" maxlength="15"  />

<label >Airway</label>
<input name="airway" type="text" maxlength="15"  /><div class="clear"></div> 
<label >Clubbing</label>
<input name="clubbing" type="text" maxlength="15"  />
<label>Thyroid</label> <input name="thyroid" type="text" maxlength="15"  />
<label >Venous Access </label> <input name="venous" type="text" maxlength="15"  />

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Respiratory System</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>

<label >Breath Sound </label> <input name="breath"
	type="text" maxlength="25"  /> <label >Adv.
Sound </label> <input name="advance" type="text" maxlength="25"  />

<div class="clear"></div>

<div class="clear"></div>

<h4>Cardio Vascular System</h4>

<div class="clear"></div>

<label class="auto">S1 </label> 
<input id="s1" name="s1" type="checkbox" value="s1" class="radioCheck css-checkbox" />
 
<label class="auto">S2 </label> 
<input id="s2" name="s2" type="checkbox" value="s2" class="radioCheck css-checkbox" />
 
<label class="auto">S3 </label> 
<input id="s3" name="s3" type="checkbox" value="s3"	class="radioCheck css-checkbox" />
 
<label class="auto">S4 </label> 
<input id="s4" name="s4" type="checkbox" value="s4" class="radioCheck css-checkbox" />

<label class="auto">Cardio Vascular Remark </label> 
<input id="cardioVascularRemark" name="cardioVascularRemark" type="text"  />


<div class="clear"></div>

<div class="clear"></div>

<!--  <h4>Investigation</h4>--> <div class="clear"></div>
</div>
<div class="Block">
<h4>Others</h4>
<div class="clear"></div>

<label>Abdomen</label> <textarea name="abdomen" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>

<label>Liver</label> <textarea name="liver" cols="" rows="" class="textareaMediua"
	maxlength="100" onkeyup="return ismaxlength(this)"></textarea> <label>Spleen</label>
<textarea name="spleen" cols="" rows="" maxlength="100" class="textareaMediua"
	onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
<label class="auto" style="padding:0px 12px 0px 5px;"><span>*</span> Anesthetic Technique Planed</label> 
<select style="width:160px;" name="grade1" id="grade" onblur="stValueToAnaesthicPlanned(this.value);" validate=" Anesthetic Technique,string,yes">
	<option value="0">Select</option>
	<%for(MasAnesthesia masAnesthesia:anesthesiaList) {%>
	<option value="<%=masAnesthesia.getAnesthesiaName()%>"><%=masAnesthesia.getAnesthesiaName()%></option>
	<%} %>
</select> 
<input type="text" value="" id="anaesthicPlanned" name="anaesthicPlanned" style="width:160px;" />
<div class="clear"></div>
 <label>Blood Component </label> 
<!--  <input name="blood" type="text" maxlength="25" /> -->
 <select name="blood" multiple="multiple" class="list" size="25" >
 <option value="">Select</option>
 <%for(BloodMasComponent BloodMasComponent:BloodMasComponentList){ %>
 <option value="<%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]")%>"><%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]") %></option>
 <%} %>
 </select>
 <label>Unit</label>
 <input type="text" name="unitForBloodComponent" id="unitForBloodComponentId" value=""  maxlength="4" />
 
	<div class="clear"></div>
	<label>In</label> <select name="">
	<option>select</option>
	<option>OT</option>
</select>
<div class="clear"></div>
<label>Any Special Instruction</label> <textarea name="instructions" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>
<label>ASA Grade</label> <select name="asa" id="asa">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="III">III</option>
	<option value="IV">IV</option>
	<option value="V">V</option>
</select> <label>Patient Type</label> 
<select name="patientType" id="patientType">
	<option value="">Select</option>
	<option value="new">New</option>
	<option value="Review">Review</option>

</select>
<div class="clear"></div>
<label>Fit for surgery</label>
<select name="fitForSurgery" id="fitForSurgery1" onchange="getFitForSurgery(this.value);">
<option value="">-Select-</option>
<option value="y">Yes</option>
<option value="n">Pending</option>
</select>
<div id="fitForSurgery" style="display: none;"><label>Doctor</label>
<select name="doctorName" id="doctorId">
<option value="0">Select</option>
<%for(MasEmployee emp:doctorList){ %>
<option value="<%=emp.getId()%>"><%=emp.getFirstName()%></option>
<%} %>
</select>
<label>Remarks</label>
<textarea name="remarks" ></textarea>

</div>
<div class="clear"></div>
<label>Summary</label>
<textarea name="summary" id="summaryId" class="textareaMediua">

</textarea>
<div class="clear"></div>
<input name="investigation"
	type="button" value="View Patient History" class="inputButtonAutu"
	onclick="showPatientHistory();" />
	
	<input name="investigation"
	type="button" value="Blood request" class="inputButtonAutu"
	onclick="getBloodRequest('<%=opdSurgeryHeader.getHin().getHinNo() %>')" />

<input name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" />
	<input type="hidden" id="requestId" value="<%=opdSurgeryHeader.getHin().getId() %>"/>
	
	
	
	 <input	name="hinId" id="hinId" type="hidden"	value="<%=opdSurgeryHeader.getHin().getId() %>" /> 
	 <input	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> 
	 <input	name="deptId" type="hidden" value="<%=deptId %>" /> 
	 <input	name="orderNo" type="hidden" value="<%=opdSurgeryHeader.getOrderNo() %>" /> 
	 <input name="changedBy"
	type="hidden" value="<%=userName %>" /> <input name="changedDate"
	type="hidden" value="<%=currentDate %>" /> <input name="changedTime"
	type="hidden" value="<%=currentTime %>" /> <input type="button"
	name="Submit" class="button" value="Submit"
	onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" />

<input name="back" type="button" class="button" value="Back"
	onclick="submitForm ('preAnesthesia','ot?method=showPACClearanceList')" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
</form>
<!--main content placeholder ends here-->


<script type="text/javascript">
	
	
		function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
		}
		
		function checkGrade(){
		var grade=document.getElementById('grade').value;
		if (grade== ""){
		
			if(!displayAlert("Please Enter the Anesthtic Technique Planned."))
				alert("Please Enter the Anesthtic Technique Planned.");
			getShadow('grade');
		    return false;
		}
		  return true;
		}
		
		
		function openPopupForInvestigation(patientStatus){
			
			var hinId=document.getElementById('hinId').value;
			if(patientStatus=="OutPatient"){
			var visitId=document.getElementById('visitId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&visitId="+visitId+"&hinId="+hinId;
			}else{
			 var inpatientId=document.getElementById('inPatientId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&hinId="+hinId+"&inpatientId="+inpatientId;
			}
		   popwindow(url);
		}
		var newwindow;
		function popwindow(url)
		{
		 newwindow=window.open(url,'name',"height=300,width=700,status=1");
		
		}

		function validateBpValue(obj){
			var bpObj = document.getElementById('bp');
			 var bool =validateBpWithSlash(obj)
			if(bool)
			{

			if(obj != ""){
			var index=obj.indexOf('/');
			if(index != 3){
				if(!displayAlert("BP should be in max/min Format."))
					alert("BP should be in max/min Format.");
				showShadow(bpObj);
				 bpObj.value="";
				 //bpObj.focus();
				 return false;
				 }


				 var pairs2 = obj.substring(0,obj.length).split('/');
				 if (pairs2.length!=2) {
					 if(!displayAlert("Invalid  Format."))
						 alert("Invalid  Format.");
					 showShadow(bpObj);
					return false;
					}

				val3=eval(pairs2[0]);
				if (val3>240) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Maximum BP should be less than 240.");
					showShadow(bpObj);
				 return false;}

				val2=eval(pairs2[1]);
				if (val2<60 ) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Minimum BP should be greater than 60");
					showShadow(bpObj);
				  return false;}


			}
			return true;
			}
			showShadow(bpObj);
			bpObj.value="";
			return false;
			}
		function stValueToAnaesthicPlanned(val){
				val=val+" ";
				var valForAna=document.getElementById('anaesthicPlanned').value;
				val=valForAna+val+",";
				document.getElementById('anaesthicPlanned').value=val;
			     
				}
	</script>
<script>
function getBloodRequest(hinNo){
	submitForm('preAnesthesia','bloodBank?method=searchPatientForBloodRequest&<%=HIN_NO%>='+hinNo);
	
	
}
</script>

<script type="text/javascript">
function openPopupWindow(){
   var requestId=document.getElementById("requestId").value.trim();
	
 window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}
</script>
<script>
function getFitForSurgery(val){
	//alert(""+val)
	if(val=='n'){
		document.getElementById('fitForSurgery').style.display="inline";
	}else if(val=='y'){
		document.getElementById('fitForSurgery').style.display="none";
	}else //if(val=='')
	{
		document.getElementById('fitForSurgery').style.display="none";
	}
}

</script>
<script>
function calculateBMI()
{
	 document.getElementById('bmiId').value='';
	if(document.getElementById('heightId').value != "" && document.getElementById('weightId').value !="")
	{
	 var height = 	parseFloat(document.getElementById('heightId').value)/100;
	 var weight = 	document.getElementById('weightId').value;
	document.getElementById('bmiId').value=(weight/(height*height)).toFixed(2);
	}
	bmiCat();
}

function bmiCat(){
	 var bmicat;
	document.getElementById('bmiId').value='';
		if(document.getElementById('heightId').value != "" && document.getElementById('weightId').value !="")
		{
		 var height = 	parseFloat(document.getElementById('heightId').value)/100;
		 var weight = 	document.getElementById('weightId').value;
		document.getElementById('bmiId').value=(weight/(height*height)).toFixed(2);
		 bmicat=(weight/(height*height)).toFixed(2);
		}
		document.getElementById('bmiStatusId').value=' ';
		 if(bmicat<18.5){
			document.getElementById('bmiStatusId').value='Underweight';
		}else if(bmicat>=18.5 && bmicat<25){
			document.getElementById('bmiStatusId').value='Healthy Range';
		}else if(bmicat>=25 && bmicat<=30){
			document.getElementById('bmiStatusId').value='Overweight';
		}else if(bmicat>=30 && bmicat<=35){
			document.getElementById('bmiStatusId').value='Obese';
		}else if(bmicat>35){
			
			document.getElementById('bmiStatusId').value='Severely obese';
		}else{
			document.getElementById('bmiStatusId').value='';
		}
}
function setBedStatus(){
	if(document.getElementById('arrangeBedId').checked==true){
		document.getElementById('ventilatorId').style.display="inline";
		document.getElementById('arrangeBedId1').value='y';
	}else if(document.getElementById('arrangeBedId').checked==false){
		document.getElementById('ventilatorId').style.display="none";
		document.getElementById('arrangeBedId1').value='n';
	}
	
	
}
function showPatientHistory(){
    //document.opdMain.action="/hms/hms/enquiry?method=showPatientDetails&hinNo="+hinNo;
    //document.opdMain.submit();
   // var visitId = document.getElementById("visitId").value;
   var hinNo=document.getElementById('hinNoUHID').value;
    var url='/hms/hms/enquiry?method=showPatientDetails&hinNo='+hinNo+'&'+csrfTokenName+'='+csrfTokenValue;
    newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
    
 }
</script>