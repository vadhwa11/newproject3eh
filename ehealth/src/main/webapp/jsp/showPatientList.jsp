 
 <%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>

<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
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
<%@page import="java.text.SimpleDateFormat"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>


<%@page import="jkt.hms.util.PatientCaseSheetDetails"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">
/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
 
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	int waitingCount = 0;
	int referCount=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
	List<OtBooking> otBookingList = new ArrayList<OtBooking>();
	try {
			if(map.get("inPatientSet")!=null)
			{
			  inPatientSet=(List<Inpatient>)map.get("inPatientSet");

			}
			
	} catch (Exception exp) {
			exp.printStackTrace();
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
	if (map.get("waitingCount") != null) {
		waitingCount = Integer.parseInt(""+map.get("waitingCount")) ;
	}
	if (map.get("referCount") != null) {
		referCount = Integer.parseInt(""+map.get("referCount")) ;
	}
	List<MasDepartment> departmentListForDialysis = new ArrayList<MasDepartment>();		
	if(map.get("departmentListForDialysis")!=null){
		departmentListForDialysis = (List<MasDepartment>)map.get("departmentListForDialysis");
	}
	List<MasBed> bedNoList = new ArrayList<MasBed>();
	if(map.get("bedNoList")!=null){
		bedNoList = (List<MasBed>)map.get("bedNoList");
	}
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList")!=null){
		opdDetailsList = (List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	if(map.get("otBookingList")!=null){
		otBookingList = (List<OtBooking>)map.get("otBookingList");
	}
	System.out.println("otBookingList11="+otBookingList.size());
	List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();

	if(map.get("caseSheetDetails")!=null){
		caseSheetDetails = (List<PatientCaseSheetDetails>)map.get("caseSheetDetails");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
	String mesageForNurse="";
	if(map.get("mesageForNurse")!=null){
		mesageForNurse=(String)map.get("mesageForNurse");
	}
	Map<Integer,Object> mlcMap=new HashMap<Integer,Object>();
	if(map.get("mlcMap")!=null){
		mlcMap=(Map<Integer,Object>)map.get("mlcMap");
	}
%>
<%if(mesageForNurse!=null && !mesageForNurse.equals("")){ %>
<marquee behavior="scroll" direction="left" onmousedown="this.stop();" onmouseup="this.start();"  style="font-size: 16px; color: red"  ><%=mesageForNurse %></marquee>
<%} %>
<div class="titleBg"  ><h2>Ward Management</h2></div>
<div class="clear"></div>
<!--<h4><%=deptName %></h4>
--><!--  <div style="float: left; padding-left: 500px;"><h4 align="left" class="style1"><%//deptName%></h4></div>  -->
<div class="clear"></div>
<!-- thread search menu -->

    <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");

      %>
    <h4><%=message %></h4>
		<% }
		%>

<div class="clear"></div>
<form name="patientList" method="post" action="">
<div class="clear"></div>

<!-- CASE SHEET	Doctor
DISCHARGE SLIP	Doctor
DISCHARGE SUMMARY	Doctor
ALLERGY	Doctor
SURGERY REQUISITION	Doctor
REQUISITION DETAILS	Doctor

WARD / BED TRANSFER ACCEPTANCE	Doctor
CARE TRANSFER ACCEPTANCE	Doctor -->
<!-- <input type="button" class="buttonAuto" value="Admission Kit Issue" onclick="submitForm('patientList','ipd?method=showPatientKitIssueJsp','validatePatient');" />
 -->
<!--  <input type="button" class="buttonAuto" value="Diet Scheduling"  onClick="submitForm('patientList','/hms/hms/ipd?method=showDietSetupJsp')" />
 -->
 <input type="button" class="buttonAuto" value="Case Sheet" onclick="submitForm('patientList','ipd?method=showCaseSheetJsp','validatePatientForCaseSheet');" />
<input type="button" class="buttonAuto" value="Requisition Details"  onClick="submitForm('patientList','/hms/hms/lab?method=getOrderNoListForOrderStatus','validatePatient')" />
<!-- <input type="button" class="buttonAuto" value="Nursing Entry" onClick="submitForm('patientList','ipd?method=showNursingCareEntryJsp','validatePatient');"	/>
 --> <!-- <input type="button" class="buttonAuto" value="Nursing Care Setup" onclick="submitForm('patientList','ipd?method=showNursingCareJsp','validatePatient');" /> -->
<!-- <input type="button" class="buttonAuto" value="Nursing Station" onClick="javascript:void(0)"	/>
 --><!-- <input type="button" class="buttonAuto" value="Clinical Entry" onClick="submitForm('patientList','ipd?method=showNursingClinicalChartJsp','validatePatient');"	/>
 -->
<!--  <input type="button" class="buttonAuto" value="Medicine Issue" onClick="submitForm('patientList','ipd?method=showPrescriptionEntryDetailHomeJsp','validatePatient');" />
 -->
 <input type="button" class="buttonAuto" value="Surgery Requisition" onClick="submitForm('patientList','opd?method=showSurgeryRequisitionJspFromPatientList1','validatePatientForCaseSheet');"	/>
<!-- <input type="button" class="buttonAuto" value="Blood Requisition" onClick="submitForm('patientList','bloodBank?method=showBloodRequestEntryJsp','validatePatient');"	/>
 --><input type="button" class="buttonAuto" value="Allergy" onClick="submitForm('patientList','ipd?method=showAlergyJsp','validatePatient');"	/>
<!-- <input type="button" class="buttonAuto" value="Ward/Bed Transfer" onClick="submitForm('patientList','/hms/hms/adt?method=getTransferScreen','validatePatient');" />
 --><!-- <input type="button" class="buttonAuto" value="MLC"  onClick="submitForm('patientList','/hms/hms/adt?method=showMedicoLegalCaseDetails','validatePatient');" />
 -->
<!--  <input type="button" class="buttonAuto" value="Issue Diet to Patient" onClick="javascript:submitForm('patientList','ipd?method=showDietForIndoorPatientList');"" />
 -->
<!--  <input type="button" class="buttonAuto" value="Upload Documents"  onClick="submitForm('patientList','/hms/hms/opd?method=showUploadingDocumentsJsp','validatePatient');" />
 -->
 <input type="button" class="buttonAuto" value="Discharge Summary" onClick="submitForm('patientList','discharge?method=showDischargeInputJsp','validatePatientForDischarge','dischargeSummaryStatus');"	/>

<!-- <input type="button" class="buttonAuto" value="Ward Consumption" onClick="submitForm('patientList','ipd?method=showWardConsList');"	/>
 -->
<!--  <input type="button" class="buttonAuto" value="Pass Generation" onClick="submitForm('patientList','ipd?method=showGeneratepassJsp','validatePatient');"	/>
 -->
 <input type="button" class="buttonAuto" value="Ward/Bed Transfer Acceptance" onClick="submitForm('patientList','ipd?method=showWardTransferAccepJsp');"	/>
<!-- <input type="button" class="buttonAuto" value="Care Transfer" onClick="submitForm('patientList','ipd?method=showHandTakeJsp','validatePatient');"	/>
 -->
 <input type="button" class="buttonAuto" value="Care Transfer Acceptance" onClick="submitForm('patientList','ipd?method=showCareTransferAccepJsp');"	/>
 <input type="button" class="buttonAuto" value="Blood Request"
  onClick="submitForm('patientList','ipd?method=showBloodRequestEntryJsp','validatePatient');"	/>
<input type="button" class="buttonAuto" value="Blood Transfusion" onClick="submitForm('patientList','bloodBank?method=showReactionFormEntryJsp','validatePatient');"	/>
<input type="button" class="buttonAuto" value="Blood Ack" onClick="submitForm('patientList','bloodBank?method=showbldIssueAcknowledgmentListJsp','validatePatient');"	/>


 <input type="button" class="buttonAuto" value="Ambulance Request" onClick="submitForm('patientList','ipd?method=showAmbulanceRunRequest');"	/>
<input type="button" class="buttonAuto" value="Delivery Details " onClick="submitForm('patientList','ipd?method=getInpatientDetails','validateDeliveryDetails');" />
<input type="button" class="buttonAuto" value="Discharge Slip" onClick="submitForm('patientList','adt?method=getDischargeScreen','validatePatientForDischarge','dischargeSummaryStatusForSlip');"	/>
<input type="button" class="buttonAuto" value="Monitor Investigation" onClick="submitForm('patientList','ipd?method=getInvestigationDetails','validatePatient');"	/>
<input type="button" class="buttonAuto" value="Investigation Trend" onClick="submitForm('patientList','ipd?method=showInvestigationTrend','validatePatient');"	/>
<input type="button" class="buttonAuto" value="Service Cancellation" onClick="submitForm('patientList','ipd?method=showWardServiceCanCelledJsp','validatePatientForCaseSheet');"	/>
<!-- <input type="button" class="buttonAuto" value="Change Scheme" onClick="submitForm('patientList','ipd?method=showChangeSchemeJsp','validatePatient');" /> -->
<%
			if(departmentListForDialysis.size()>0){
				if(departmentListForDialysis.get(0).getDepartmentType().getDepartmentTypeCode().equals(depTypeCodeDialysis)){
			%>

<input type="button" class="buttonAuto" value="Dialysis Process" onClick="submitForm('patientList','ipd?method=showDialysisProcessJsp');"	/>
<%}} %>

<!-- <input type="button" class="buttonAuto" value="Ambulance Register" onClick="submitForm('patientList','ipd?method=showAmbulanceRunRegister');"	/>
 -->
<!--    <input type="button" class="buttonAuto" value="Vitals / Intake Output Entry" onClick="submitForm('patientList','ipd?method=showIntakeOutputJsp','validatePatient');" />
 --><!-- <input type="button" class="buttonAuto" value="Pending Acknowledge" onClick="submitForm('patientList','ipd?method=showPendingBloodRequestEntryJsp','validatePatient');" />
 --><!-- <input type="button" class="buttonAuto" value="Issue Diet" onClick="submitForm('patientList','diet?method=showDietForIndoorPatientList','validatePatient');" />
 -->  


<div class="clear paddingTop15"></div>
<span>

<a href="/hms/hms/ipd?method=showPatientAdmissionAcceptJsp"><%=waitingCount%>  New Admission Patient Not Reported to ward</a></span>
<div class="clear"></div>
<%if(referCount>0){ %>
<div style="color: red;"><a style="color: red;" href="/hms/hms/ipd?method=getReferedPatientList"><%=referCount%>  New Referals are Waiting</a></div>
<%}else{ %>
<span><a href="/hms/hms/ipd?method=getReferedPatientList"><%=referCount%>  New Referals are Waiting</a></span>
<%} %>
<div class="clear paddingTop15"></div>
<%
String adNo ="";
int j=1;
	int i=0;
	if(bedNoList.size()>0){
		for(MasBed bed : bedNoList){
			 String hospitalUnitCode = "--";
			 
			 Set<OtMasUnitDay> unitSet = new HashSet<OtMasUnitDay>();
			 
			 if(bed.getBedType().equalsIgnoreCase("v")){
				 unitSet = bed.getVBed().getOtMasUnitDays()!=null?bed.getVBed().getOtMasUnitDays():new HashSet<OtMasUnitDay>();
			 }else{
				 unitSet =  bed.getOtMasUnitDays()!=null?bed.getOtMasUnitDays():new HashSet<OtMasUnitDay>();
			 }
				for(OtMasUnitDay masUnitDays: unitSet){
					hospitalUnitCode = masUnitDays.getUnitM().getUnitCode();
				}
		 if(bed.getBedStatus().getId() == bedStatusUnOccupiedId){

%>
<div class="green" onclick="setInpatientId('','')"> &nbsp;<div class="bedNo"><%=bed.getBedNo() %><div class="clear"></div><%=hospitalUnitCode%>
</div></div>
<%
	 }else{
		if(inPatientSet.size()>0){
		 	for(Inpatient inpatient : inPatientSet){
		 		if(inpatient.getBed()!=null && bed.getId()==inpatient.getBed().getId()){
		 		String patientName = "";
		 		/* if(inpatient.getHin().getRelation().getId()==8){
		 			patientName += inpatient.getHin().getRank().getRankName()+" ";
		 		} */
		 		patientName += inpatient.getHin().getPFirstName()+" "+(inpatient.getHin().getPMiddleName()!=null?inpatient.getHin().getPMiddleName():"")+" "+(inpatient.getHin().getPLastName()!=null?inpatient.getHin().getPLastName():"") ;
	 	 		adNo =inpatient.getAdNo();
		 		String doctornameName = inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"") ;

	 	 		String admDate = HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission());
		 		String condition = inpatient.getConditionStatus()!=null?inpatient.getConditionStatus():"";
		 		String gender = inpatient.getHin().getSex()!=null?inpatient.getHin().getSex().getAdministrativeSexName():"";
		 		String age = "";
		 		String surgryStatus = "";
				int currentAge = 0;
				int ipId=inpatient.getId(); 
				if(inpatient.getHin().getDateOfBirth()!=null){
					currentAge = HMSUtil.getCurrentAgeByDoB(inpatient.getHin().getDateOfBirth());
				}
				age=""+currentAge;
				
				if(otBookingList.size()>0){
					for(OtBooking ot :otBookingList){	
						if(inpatient.getBed()!=null && ot.getInpatient()!=null && bed.getId()==ot.getInpatient().getBed().getId()){
							surgryStatus = ot.getSurgeryStatus();
				}}}
			
					%>
					
<%if(surgryStatus.equalsIgnoreCase("y")){ 
//for(OtBooking ot :otBookingList){	
	//if(inpatient.getHin().getId()== ot.getHin().getId()){
		
%>					
<div class="greenDark" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex().getAdministrativeSexName() %>','<%=surgryStatus %>');setBorder('<%=i %>');" rel="balloon<%=i %>">
<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
</div>

<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
	<span style="color: red;">MLC</span>
<%}%>
<div class="clear"></div>
<%=patientName%>
<div class="clear"></div>
<%=adNo %>
<div class="clear"></div>
<%-- <%=admDate %> --%>
<%=doctornameName%>
<div class="clear"></div>
<%=gender%>/<%=currentAge%> 
<div class="clear"></div>
<%=hospitalUnitCode%>
<div class="clear"></div>
</div>					
<%//}
	//} %>					
				<% }else if(null !=inpatient.getAdStatus() && inpatient.getAdStatus().equalsIgnoreCase("R")){
					
					
					%>
<div class="yellow" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex().getAdministrativeSexName() %>','','<%=inpatient.getDischargeSummaryStatus() != null ? inpatient.getDischargeSummaryStatus() : ""%>');setBorder('<%=i %>');" rel="balloon<%=i %>">
<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
</div>

<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
	<span style="color: red;">MLC</span>
<%}%>
<div class="clear"></div>
<%=patientName%>
<div class="clear"></div>
<%=adNo %>
<div class="clear"></div>
<%-- <%=admDate %> --%>
<%=doctornameName%>
<div class="clear"></div>
<%=gender%>/<%=currentAge%> 
<div class="clear"></div>
<%=hospitalUnitCode%>
<div class="clear"></div>
</div>

<%	 		}				
					else  if(inpatient.getCriticalCondition()!=null && inpatient.getCriticalCondition().equalsIgnoreCase("y")){
					%>
					<div class="red" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex().getAdministrativeSexName() %>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
					<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
					</div> 
					<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
						<span style="color: red;">MLC</span>
					<%}%>
					<div class="clear"></div>
					<%=patientName%>
					<div class="clear"></div>
					<%=adNo %>
					<div class="clear"></div>
					<%-- <%=admDate %> --%>
					<%=doctornameName%>
					<div class="clear"></div>
					<%=gender%>/<%=currentAge%>  
					<div class="clear"></div>
					<%=hospitalUnitCode%>
					<div class="clear"></div>
					</div>
					<%}	else if(null !=inpatient && inpatient.getBed()!=null && bed.getBedType().equalsIgnoreCase("v")){
						System.out.println("asdas"+inpatient.getId());
						System.out.println(inpatient.getAdStatus());
						System.out.println(inpatient.getHin().getId());
						//System.out.println(inpatient.getHin().getSex().getAdministrativeSexName());
						System.out.println(inpatient.getAdNo());
						%>
						<div class="orange" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex() !=null ? inpatient.getHin().getSex().getAdministrativeSexName():"" %>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
						<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
						</div> 
						<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
						<span style="color: red;">MLC</span>
						<%}%>
						<div class="clear"></div>
						<%=patientName%>
						<div class="clear"></div>
						<%=adNo %>
						<div class="clear"></div>
						<%-- <%=admDate %> --%>
						<%=doctornameName%>
						<div class="clear"></div>
						<%=gender%>/<%=currentAge%> 
						<div class="clear"></div>
						<%=hospitalUnitCode%>
					<div class="clear"></div>
						</div>
						<%}	else if(inpatient.getBed()!=null && bed.getBedType().equalsIgnoreCase("v")){
						%>
						<div class="orange" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex().getAdministrativeSexName() %>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
						<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
						</div> 
						<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
						<span style="color: red;">MLC</span>
						<%}%>
						<div class="clear"></div>
						<%=patientName%>
						<div class="clear"></div>
						<%=adNo %>
						<div class="clear"></div>
						<%-- <%=admDate %> --%>
						<%=doctornameName%>
						<div class="clear"></div>
						<%=gender%>/<%=currentAge%> 
						<div class="clear"></div>
						<%=hospitalUnitCode%>
					<div class="clear"></div>
						</div>
						
						
						
						
						<%}else if(inpatient.getAdStatus().equalsIgnoreCase("A")){
%>
<div class="blue" id="admitted<%=i %>" onclick="setInpatientId('<%=inpatient.getId() %>','<%=inpatient.getAdStatus() %>','<%=inpatient.getHin().getId() %>','<%=inpatient.getAdNo() %>','<%=inpatient.getHin().getSex().getAdministrativeSexName() %>');setBorder('<%=i %>');" rel="balloon<%=i %>" >
<div class="bedNo"><%=bed.getBedNo() %> <div class="clear"></div><%=hospitalUnitCode%>
</div> 
<%if(mlcMap!=null && mlcMap.get(ipId)!=null){%>
<span style="color: red;">MLC</span>
<%}%>
<div class="clear"></div>
<%=patientName%>
<div class="clear"></div>
<%=adNo %>
<div class="clear"></div>
<%-- <%=admDate %> --%>
<%=doctornameName%>
<div class="clear"></div>
<%=gender%>/<%=currentAge%> 
<div class="clear"></div>
<%=hospitalUnitCode%>
<div class="clear"></div>
<%
	if(!condition.equals("") && inpatient.getPatientCondition()!=null && !inpatient.getPatientCondition().equalsIgnoreCase("Normal")){
%>
<div class="condition"><%=condition %></div>
<%} %>
</div>
<%}%>


	<%
	String treatment = "";
	String procedure = "";
	String physioTherapy = "";
	String diagnosis = "";
	String nursingCare = "";
	if(caseSheetDetails.size()>0){
		for(PatientCaseSheetDetails patientCaseSheetDetails : caseSheetDetails){
			if(inpatient.getHin().getId().equals(patientCaseSheetDetails.getHinId())){
				treatment = patientCaseSheetDetails.getTreatmentDetails();
				procedure = patientCaseSheetDetails.getProcedureDetails();
				physioTherapy = patientCaseSheetDetails.getPhysiotherapyDetails();
				diagnosis = patientCaseSheetDetails.getDiagnosisDetails();
				nursingCare = patientCaseSheetDetails.getNursingCareDetails();
				break;
			}
		}
	}
	

%>

<div id="balloon<%=i %>" class="wardstyle">
Diagnosis: <%= diagnosis%>
<div class='clear'></div>
 Treatment: <%= treatment%>
 <div class='clear'></div>
 Procedure: <%= procedure%>
 <div class='clear'></div>
 Physiotherapy: <%= physioTherapy%>
<div class='clear'></div>
  Nursing Care: <%= nursingCare%>
<div class='clear'></div>
 </div>

 		<% i++;} %>


<%				}
			}
		 }
		 if(j%5==0){
				%>
				<!-- <div class="clear"></div> -->
				<%}
		j++;}
	}%>
<input type="hidden" name="adNo"	value="" id="adNo" validate="adNo,metachar,no" />
<input type="hidden" name="hinId"	value="" id="hinId" validate="hinId,int,no"/>
<input type="hidden" name="parent"	value="" id="parent" />
<input type="hidden" name="sex"	value="" id="sex" validate="hinId,string,no"/>
<input type="hidden" name="surgryStatus" value="" id="surgryStatus" validate="hinId,string,no"/>
<input type="hidden" name="patientStatus"	value="" id="patientStatus" validate="patientStatus,metachar,no"/>
<input type="hidden" name="dischargeStatus"	value="" id="dischargeStatus" validate="dischargeStatus,metachar,no"/>
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" validate="deptId,int,no"/>
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" validate="deptName,metachar,no"/>
<div class="clear paddingTop15"></div>
<div class="clear"></div>

<%--  <%if(waitingCount !=0){ %>
<div class="monitor"> Waiting Patients: <span><%=waitingCount%></span></div>
 <%} %> --%>
<div class="clear paddingTop15"></div>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="value">Vacant</label>

<input type="text" class="signPriority1" readonly="readonly" >
<label class="value">Critical Condition</label>

<input type="text" class="signPriority5" readonly="readonly" >
<label class="value">VB: Virtual Bed</label>

<input type="text" class="signPriority4" readonly="readonly" >
<label class="value">OC: Occupied</label>

<input type="text" class="signPriority2" readonly="readonly" >
<label class="value">RD: Ready for Discharge</label>
<div class="clear"></div>

<input type="text" class="signPriority6" readonly="readonly" >
<label class="value">PD: PreAneshthesia Completed</label>

<script	type="text/javascript">



function setInpatientId(val,patientStatus,hinId,adNo,sex,surgryStatus,dischargeStatus){
	document.getElementById('parent').value = val;
	document.getElementById('patientStatus').value = patientStatus;
	document.getElementById('hinId').value = hinId;
	document.getElementById('adNo').value = adNo;
	document.getElementById('sex').value = sex;
	document.getElementById('surgryStatus').value = surgryStatus;
	document.getElementById('dischargeStatus').value = dischargeStatus;
}
/* setting border for show selected patient from list  */
function setBorder(inc){
	var count = '<%=j%>';

	for(var i=0;i<count;i++){
		if(i == inc){
			if(document.getElementById('admitted'+i)){
				//document.getElementById('admitted'+i).style.border = '2px solid blue';
			document.getElementById('admitted'+i).style.fontWeight  = 'bold';
			document.getElementById('admitted'+i).style.color  = '#AC1400';
			}
		}else{
			if(document.getElementById('admitted'+i)){
				document.getElementById('admitted'+i).style.border = '1px solid #000'
				document.getElementById('admitted'+i).style.fontWeight  = 'normal';
				document.getElementById('admitted'+i).style.color  = '#000';
			}
		}

	}
}

function validatePatient(){
	//alert(document.getElementById('patientStatus').value);
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value =='R'){
		alert("Patient is ready to discharge.");
		return false;
	}
	return true;

}

function validatePatientForDischarge(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value !='R'){
		alert("Patient is not ready to discharge.");
		return false;
	}
	return true;

}

function validatePatientForCaseSheet(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	
	if(document.getElementById('parent').value!='' && document.getElementById('surgryStatus').value == 'y'){
		alert("Patient admitted in OT.");
		return false;
	}
	return true;

}
function checkPatient()
{
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!=''){
		if(document.getElementById('patientStatus').value=='W'){
			if(confirm("Has the patient physically reported to ward ?"))
				return true;
			else
				return false;
		}else{
			alert("Patient already reported to ward.")
		}
	}
}

function checkPatientForDischarge()
{
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!=''){
		if(document.getElementById('patientStatus').value=='R'){
				return true;
		}else{
			alert("Patient is not ready to discharge.")
			return false;
		}
	}
}

function validateDeliveryDetails(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='W'){
		alert("Patient has not been reported to ward.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value=='R'){
		alert("Patient is ready to discharge.");
		return false;
	}
	if(document.getElementById('sex').value!='' && document.getElementById('sex').value=='Male'){
		alert("Patient is only Female");
		return false;
	}
	return true;

}

//Added by Arbind on 31-03-2017
function dischargeSummaryStatus(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('dischargeStatus').value =='y'){
		alert("Patient discharge summary already created.");
		return false;
	}
	return true;
}

function dischargeSummaryStatusForSlip(){
	if(document.getElementById('parent').value==''){
		alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!='' && document.getElementById('patientStatus').value =='R' && document.getElementById('dischargeStatus').value !='y'){
		if (confirm("Patient discharge summary has not been created.\nDo you want to continue !")) {
			return true;
		}
		return false;
	}
	return true;
}
//Added by Arbind on 31-03-2017 end
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
 