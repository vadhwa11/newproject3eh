<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.OpdNursingPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%> 
<%@page import="jkt.hms.masters.business.IpdVitalcareSetupHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientStoreIndentHeader"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script src="/hms/jsp/js/opd.js"></script>
<script>jQuery.noConflict();</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
	String detailId ="";
	String opOrString ="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
	List<Visit> visitList = new ArrayList<Visit>();
	List<Discharge> dischargeList = new ArrayList<Discharge>();
	List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
	List<Transfer> transferList = new ArrayList<Transfer>();
	List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	List<PatientPrescriptionHeader> opPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	List<InpatientPrescriptionDetails>  inpatientPrescriptionDetailsList = new ArrayList<InpatientPrescriptionDetails>();
	List<OpdPatientDetails> opdDetails=new ArrayList<OpdPatientDetails>();
	List<PatientStoreIndentHeader> ipPrescriptionList = new ArrayList<PatientStoreIndentHeader>();
	List<OpdSurgeryDetail> headerList = new ArrayList<OpdSurgeryDetail>();
	List<OpdSurgeryDetail> opdSurgeryDetailList= new ArrayList<OpdSurgeryDetail>(); // added by amit das on 28-09-2016
	List<OtBooking> operationsList = new ArrayList<OtBooking>();
	List<PatientInvestigationHeader>  patientInvestigationList = new ArrayList<PatientInvestigationHeader>();
	List<Inpatient>inPatientList=new ArrayList<Inpatient>();
	List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
	OpdNursingPatientDetails preOpc=new OpdNursingPatientDetails();
	DgOrderhd dgOrderhd=null;
	// definition of vitalList By Ujjwal fo OP
	OpdPatientDetails vitals=new OpdPatientDetails();
 	// definition of vitalList By Ujjwal fo IP
	List<IpdVitalcareSetupHistory>vitalListIP=new ArrayList<IpdVitalcareSetupHistory>();
	String diagnosisIcd=new String();
	//definition ended by Ujjwal 	
	//List Get by Ujjwal  
	if(map.get("vitalListIP")!=null){
		vitalListIP=(List<IpdVitalcareSetupHistory>)map.get("vitalListIP");
	}
	
	if(map.get("preOpc")!=null){
		preOpc=(OpdNursingPatientDetails)map.get("preOpc");
	}
	Integer preOpcSize=0;
	if(map.get("preOpcSize")!=null){
		preOpcSize=(Integer)map.get("preOpcSize");
	}
	
	if(map.get("diagnosisIcd")!=null){
		diagnosisIcd=(String)map.get("diagnosisIcd");
	}
	if(map.get("opdDetails")!=null){
		opdDetails=(List<OpdPatientDetails>)map.get("opdDetails");
	}
	
	if(map.get("vitalList")!=null){
		vitals=(OpdPatientDetails)map.get("vitalList");
	}
	
	Integer vitalListSize=0;
	if(map.get("vitalListSize")!=null){
		vitalListSize=(Integer)map.get("vitalListSize");
	}
	
	
	
	//End by ujjwal	 		
	
	// added by amit das on 28-09-2016
	if(map.get("ipdOpdSurgeryDetailList")!=null){
		opdSurgeryDetailList = (List<OpdSurgeryDetail>)map.get("ipdOpdSurgeryDetailList");
	}
	
	
	if(map.get("visitList") != null)	{
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("inPatientList") != null)	{
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	}
	
	if(map.get("dischargeList") != null)	{
		dischargeList = (List<Discharge>)map.get("dischargeList");
	}
	if(map.get("silDilStatusList") != null)	{
		silDilStatusList = (List<SilDilStatus>)map.get("silDilStatusList");
	}
	if(map.get("transferList") != null)	{
		transferList = (List<Transfer>)map.get("transferList");
	}
	if(map.get("mlcCaseList") != null)	{
		mlcCaseList = (List<MlcCase>)map.get("mlcCaseList");
	}
	if(map.get("headerList") != null)	{
		headerList = (List<OpdSurgeryDetail>)map.get("headerList");
	}
	
	List<ProcedureDetails>procedureDetailsList=new ArrayList<ProcedureDetails>();
	if(map.get("procedureDetailsList") != null)	{
		procedureDetailsList = (List<ProcedureDetails>)map.get("procedureDetailsList");
	}
		
	if(map.get("dischargeIcdCodeList") != null)	{
		dischargeIcdCodeList = (List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	if(map.get("opPrescriptionList") != null)	{
		opPrescriptionList = (List<PatientPrescriptionHeader>)map.get("opPrescriptionList");
	}
	
	if(map.get("inpatientPrescriptionDetailsList") != null)	{
		inpatientPrescriptionDetailsList = (List<InpatientPrescriptionDetails>)map.get("inpatientPrescriptionDetailsList");
	}
	if(map.get("patientInvestigationList") != null)	{
		patientInvestigationList = (List<PatientInvestigationHeader>)map.get("patientInvestigationList");
	}
	if(map.get("ipPrescriptionList") != null)	{
		ipPrescriptionList = (List<PatientStoreIndentHeader>)map.get("ipPrescriptionList");
	}
	if(map.get("operationsList") != null)	{
		operationsList = (List<OtBooking>)map.get("operationsList");
	}
	if(map.get("detailId") != null)	{
		detailId = ""+map.get("detailId");
	}
	if(map.get("opOrString") != null)	{
		opOrString = ""+map.get("opOrString");
	}
	
	 List<PatientPrescriptionHeader>  ipdPatientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();

	 if(map.get("ipdPatientPrescriptionHeaderList") != null){
		 ipdPatientPrescriptionHeaderList=(List<PatientPrescriptionHeader>)map.get("ipdPatientPrescriptionHeaderList");
		}
	 
	 List<PatientInvestigationHeader>  ipdPatientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
	 if(map.get("ipdPatientInvestigationHeaderList") != null){
		 ipdPatientInvestigationHeaderList=(List<PatientInvestigationHeader>)map.get("ipdPatientInvestigationHeaderList");
		}
	 
	 List<OpdSurgeryHeader>  ipdOpdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
	 if(map.get("ipdOpdSurgeryHeaderList") != null){
		 ipdOpdSurgeryHeaderList=(List<OpdSurgeryHeader>)map.get("ipdOpdSurgeryHeaderList");
		}
	 if(map.get("dgOrderHd")!=null && ((List<DgOrderhd>)map.get("dgOrderHd")).size()>0){
		 dgOrderhd=((List<DgOrderhd>)map.get("dgOrderHd")).get(0);
	 }
	String empName="";
	if(map.get("empName")!=null && !map.get("empName").equals("")){
		empName=""+map.get("empName");
	}
	if(map.get("DgOrderdtList")!=null){
		DgOrderdtList=(List<DgOrderdt>)map.get("DgOrderdtList");
	}
	System.out.println(""+DgOrderdtList.size());
%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%><div class="clear"></div>

<!-- START OF CODE BY MRITUNJAY kUMAR sINGH -->


<!-- END OF CODE BY MRITUNJAY kUMAR sINGH -->
<%//-------------Admission Type Details----------------------
	  if(opOrString.equals("IP")){
		//-------------For Discharge  Details----------------------
		System.out.println("detailId  ----  >>"+detailId);
		if(detailId.equals("Prescriptions") ){%>
			<div class="clear"></div>
<h4>Prescription Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%
if(inpatientPrescriptionDetailsList!=null && inpatientPrescriptionDetailsList.size()>0)
{
%>

<%Date presDate=new Date();
String presTimeIp="";
String deptNamrPres="";

for(InpatientPrescriptionDetails header:inpatientPrescriptionDetailsList)
{
	presDate=header.getPrescription().getPrescriptionDate();
	presTimeIp=header.getPrescription().getPrescriptionTime();
	deptNamrPres=header.getPrescription().getDepartment().getDepartmentName();
}

%>
<div class="">
<div onclick="expandCollaps(this);">

<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.gif" alt="" /> 
</h6>
<h6 style="display: inline;"><%=presDate %></h6>
<h6 style="display: inline;"><%=presTimeIp %></h6>
<h6 style="display: inline;"><%=deptNamrPres %></h6>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<th scope="col">Item Name</th>
<th scope="col">Dosage</th>
<th scope="col">Unit</th>
<th scope="col">Frequency</th>
<!-- <th scope="col">No Of Days</th> -->
<th scope="col">Duration</th>
<th scope="col">Instruction</th>
<th scope="col" >Special Instruction</th>
<th scope="col" >Route</th>
<th scope="col">Total</th>
</tr>
<%for(InpatientPrescriptionDetails details:inpatientPrescriptionDetailsList)
{ %>
<tr>
<td>
<%if(details.getItem().getNomenclature()!=null){ %>
<%=details.getItem().getNomenclature() %>
<%} %>
</td>
<td>
<%if(details.getDosage()!=null ){ %>
<%=details.getDosage() %>
<%} %>
</td>
<td>
<%if(details.getItem()!=null && details.getItem().getItemConversion()!=null && details.getItem().getItemConversion().getIssueUnit()!=null){ %>
	<%=details.getItem().getItemConversion().getIssueUnit().getUnitName()%>
<%} %>
</td>
<td> <%=details.getFrequency()!=null ?details.getFrequency().getFrequencyName():""%>
</td>

<td>
<%=details.getNoOfDays()+" "+details.getFrequency().getFrequencyType()%>
</td>
<td>
<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
</td>
<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
</td>
<td>
<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
</td>
<td>
<%=details.getTotal() %>
</td>
</tr>
<%}}
%>
</table>
</div>
</div>
		<%}else
		
		if(detailId.equals("Discharge") ){
			%>
<div class="clear"></div>
<h4>Discharge Details</h4>
<div class="clear"></div>
<%
		if(dischargeList.size() >0){
			Discharge discharge =dischargeList.get(0);
			String doctorName ="-";
			String disposal="-";
			String disposedTo="-";
			String careType="-";
			String injuryRptInitOn="-";
			String injuryRptInitat="-";
			String boardHeldOn="-";
			String followUpDate="-";
			String dischrgInMedicalCtgry="-";
			String dischargeStatus="-";
			String careSummary="-";
			String instructionsToPatient="-";
			String documentInitiated="-";
			String diagnosis="-";
			String dDate="-";
			String dTime="-";
			if(discharge.getDoctor() !=null){
				doctorName =discharge.getDoctor().getFirstName()+" "+discharge.getDoctor().getMiddleName()+" "+discharge.getDoctor().getLastName();
			}
			if(discharge.getDisposal() !=null){
				disposal =discharge.getDisposal().getDisposalName();
			}
			//if(discharge.getDisposedTo() !=null){
				//disposedTo =discharge.getDisposedTo().getDisposedToName();
			//}
			if(discharge.getCareType() !=null){
				careType =discharge.getCareType().getCareTypeName();
			}
			if(discharge.getInjuryReportInitiatedOn() !=null){
				injuryRptInitOn =discharge.getInjuryReportInitiatedOn()+"";
			}
			if(discharge.getInjuryReportInitAt() !=null){
				injuryRptInitat =discharge.getInjuryReportInitAt()+"";
			}
			if(discharge.getBoardHeldOn() !=null){
				boardHeldOn =discharge.getBoardHeldOn()+"";
			}
			if(discharge.getFollowUpDate() !=null){
				followUpDate =discharge.getFollowUpDate()+"";
			}
			if(discharge.getDischargeInMedicalCategory() !=null){
				if(!discharge.getDischargeInMedicalCategory().equals(""))
				dischrgInMedicalCtgry =discharge.getDischargeInMedicalCategory()+"";
			}
			if(discharge.getDischargeStatus() !=null){
				dischargeStatus =discharge.getDischargeStatus().getDischargeStatusName()+"";
			}
			if(discharge.getCareSummary()!=null){
				if(!discharge.getCareSummary().equals(""))
				careSummary =discharge.getCareSummary()+"";
			}
			if(discharge.getInstructionsToPatient() !=null){
				instructionsToPatient =discharge.getInstructionsToPatient()+"";
			}
			if(discharge.getDocumentInitiated() !=null){
				documentInitiated =discharge.getDocumentInitiated()+"";
			}
			if(dischargeIcdCodeList.size() >0){
				 for(DischargeIcdCode dischargeIcdCode :dischargeIcdCodeList ){

					  if(dischargeIcdCode.getZ09().equals("y")){
						  if(dischargeIcdCode.getIcd() !=null)
						  diagnosis = diagnosis+dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"]{OLD},";
					  }else{
						  if(dischargeIcdCode.getIcd() !=null)
						  diagnosis = diagnosis+dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"],";
					  }

				  }
			}

			if(discharge.getDateOfDischarge() !=null){
				dDate =discharge.getDateOfDischarge()+"";
			}
			if(discharge.getTimeOfDischarge() !=null){
				dTime =discharge.getTimeOfDischarge()+"";
			}
			Date dDate1=new Date();
			for(Inpatient ip:inPatientList){
				dDate1=ip.getDischargeDate();
				dTime=ip.getDischargeTime();
			}
			
		
			%>


<div class="Block"><label>Discharge Date </label> <%if(dDate1 !=null){ %>
<%String disDate ="";
			    SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
			    SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
			    disDate=formatterOut2.format(formatterIn2.parse(""+dDate));
			 %> <label class="value"><%=dDate1%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Discharge Time </label> <label
	class="value"><%=dTime%></label> <label>Doctor </label> <label
	class="value"><%=doctorName%></label>

<div class="clear"></div>

<label>Dis condition </label> <label class="value"><%=disposal%></label>

<label>Discharge To </label> <label class="value"><%=disposedTo%></label>

<label>Care Type </label> <label class="value"><%=careType%></label>

<div class="clear"></div>

<label>Injury Rpt Init On</label> <label class="value"><%=injuryRptInitOn%></label>

<label>Injury Rpt Init at</label> <label class="value"><%=injuryRptInitat%></label>

<!--   <label>Board Held On</label>
			<label class="value"><%=boardHeldOn%></label> --> <label>Follow
Up Date</label> <%if(dDate !=null){ %> <%String disDates ="";
			  //  SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
			  //  SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
			  //  disDates=formatterOut2.format(formatterIn2.parse(""+followUpDate));
			//    disDates=formatterOut2.format(""+followUpDate);


			 %> <label class="value"><%=followUpDate%></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="clear"></div>

<label>Dis In Medical Ctgry</label> <label class="value"><%=dischrgInMedicalCtgry%></label>

<label>Dis Status</label> <label class="value"><%=dischargeStatus%></label>


<!--  <label>Document Initiated</label>
			<label class="value"><%=documentInitiated%></label> By Anand gupta (11-02-10)-->

<label>Instructions To Patient</label> <label class="value"><%=instructionsToPatient%></label>

<div class="clear"></div>

<label>Care Summary</label> <label class="value"><%=careSummary%></label>

<div class="clear"></div>

<label>Diagnosis </label> <label class="valueAuto"><%=diagnosis%></label>
<div class="clear"></div>
</div>

<%
		}else{
			%>
<div class="clear"></div>
<h6>No Discharge Records Found</h6>
<div class="clear"></div>
</div>
<%
		}
		%>
<%
	//-------------For IP MLC  Details----------------------
		}else if(detailId.equals("Mlc")){
		%>
<div class="clear"></div>
<h4>IP Mlc Deatils</h4>
<div class="clear"></div>
<%
		if(mlcCaseList.size() >0){
		for(MlcCase mlcCase :mlcCaseList){
			String mlcNo ="-";
			String mlcDate ="-";
			String mlcTime ="-";
			String natureOfMlc ="-";

			String natureofInjur ="-";
			String typeOfInjury ="-";
			String severityofInjury ="-";
			String injuryDimen ="-";

			String injuryDetails ="-";
			String broughtBy ="-";
			String doctorAttnd ="-";
			String condition ="-";

			String bodyPartAff ="-";
			String weaponUsed ="-";
			String incidenceDate ="-";
			String incidenceTime ="-";

			String incidencePlace ="-";
			String typeNoOfVehicle ="-";
			String addressOfDriver ="-";
			String remarks ="-";

			String FIRNo ="-";
			String policeOfficerName ="-";
			String policeStation ="-";
			String statement ="-";

			if(mlcCase.getMlcNo() !=null )
			mlcNo=mlcCase.getMlcNo();
			if(mlcCase.getMlcDate() !=null )
			mlcDate=""+mlcCase.getMlcDate();
			if(mlcCase.getMlcTime() !=null )
			mlcTime =mlcCase.getMlcTime();
			if(mlcCase.getNatureOfMlc() !=null )
			natureOfMlc =""+mlcCase.getNatureOfMlc();

				if(mlcCase.getInjuryNature() !=null )
					if(!mlcCase.getInjuryNature().getInjuryNatureName().equals(""))
					natureofInjur=mlcCase.getInjuryNature().getInjuryNatureName();
				if(mlcCase.getInjuryType() !=null )
					if(!mlcCase.getInjuryType().equals(""))
					typeOfInjury=""+mlcCase.getInjuryType();
				if(mlcCase.getSeverityOfInjury() !=null )
					if(!mlcCase.getSeverityOfInjury().equals(""))
					severityofInjury =mlcCase.getSeverityOfInjury();
				if(mlcCase.getInjuryDimension() !=null )
						if(!mlcCase.getInjuryDimension().equals(""))
					injuryDimen =""+mlcCase.getInjuryDimension();

				if(mlcCase.getInjuryDetails() !=null )
						if(!mlcCase.getInjuryDetails().trim().equals(""))
					injuryDetails="";
				if(mlcCase.getBroughtBy() !=null )
					if(!mlcCase.getBroughtBy().equals(""))
					broughtBy=""+mlcCase.getBroughtBy();
				if(mlcCase.getDoctor().getFirstName() !=null )
					if(!mlcCase.getDoctor().getFirstName().equals(""))
					doctorAttnd =mlcCase.getDoctor().getFirstName();
				if(mlcCase.getPatientCondition() !=null )
						if(!mlcCase.getPatientCondition().equals(""))
					condition =""+mlcCase.getPatientCondition();

				if(mlcCase.getBodyPart() !=null )
					if(!mlcCase.getBodyPart().equals(""))
					bodyPartAff=mlcCase.getBodyPart().getBodyPartName();
				if(mlcCase.getWeaponUsed() !=null )
						if(!mlcCase.getWeaponUsed().equals(""))
					weaponUsed=""+mlcCase.getWeaponUsed();
				if(mlcCase.getIncidentDate() !=null )
						if(!mlcCase.getIncidentDate().equals(""))
					incidenceDate =""+mlcCase.getIncidentDate();
				if(mlcCase.getIncidentTime() !=null )
					if(!mlcCase.getIncidentTime().equals(""))
					incidenceTime =""+mlcCase.getIncidentTime();

				if(mlcCase.getIncidentPlace() !=null )
						if(!mlcCase.getIncidentPlace().equals(""))
					incidencePlace=mlcCase.getIncidentPlace();
				if(mlcCase.getTypeAndNoOfVehicle() !=null )
						if(!mlcCase.getTypeAndNoOfVehicle().equals(""))
					typeNoOfVehicle=""+mlcCase.getTypeAndNoOfVehicle();
				if(mlcCase.getNameAndAddressOfDriver() !=null )
					if(!mlcCase.getNameAndAddressOfDriver().trim().equals(""))
					addressOfDriver =""+mlcCase.getNameAndAddressOfDriver();
				if(mlcCase.getRemarks() !=null )
					if(!mlcCase.getRemarks().equals(""))
					remarks =""+mlcCase.getRemarks();

				if(mlcCase.getFirNo() !=null )
					if(!mlcCase.getFirNo().equals(""))
					FIRNo=mlcCase.getFirNo();
				if(mlcCase.getPoliceOfficer() !=null )
					if(!mlcCase.getPoliceOfficer().equals(""))
					policeOfficerName=""+mlcCase.getPoliceOfficer();
				if(mlcCase.getPoliceStation() !=null )
					if(!mlcCase.getPoliceStation().equals(""))
					policeStation =""+mlcCase.getPoliceStation();
				if(mlcCase.getStatement() !=null )
					if(!mlcCase.getStatement().equals(""))
					statement =""+mlcCase.getStatement();
		%>
<div class="Block"><label>MLC No </label> <label class="value"><%=mlcNo%></label>
<label>MLC Date </label> <label class="value"><%=mlcDate%></label> <label>MLC
Time </label> <label class="value"><%=mlcTime%></label>

<div class="clear"></div>

<label>Nature of MLC </label> <label class="value"><%=natureOfMlc%></label>
<label>Nature of Injur</label> <label class="value"><%=natureofInjur%></label>
<label>Type Of Injury</label> <label class="value"><%=typeOfInjury%></label>

<div class="clear"></div>

<label>Severity of Injury </label> <label class="value"><%=severityofInjury%></label>
<label>Injury Dimen </label> <label class="value"><%=injuryDimen%></label>
<label>Injury Details </label> <label class="value"><%=injuryDetails%></label>

<div class="clear"></div>

<label>Brought By </label> <label class="value"><%=broughtBy%></label> <label>Doctor
Attend </label> <label class="value"><%=doctorAttnd%></label> <label>Condition</label>
<label class="value"><%=condition%></label>

<div class="clear"></div>

<label>Body Part Aff </label> <label class="value"><%=bodyPartAff%></label>
<label>Weapon Used </label> <label class="value"><%=weaponUsed%></label>
<label>Incidence Date</label> <label class="value"><%=incidenceDate%></label>

<div class="clear"></div>

<label>Incidence Time</label> <label class="value"><%=incidenceTime%></label>
<label>Incidence Place </label> <label class="value"><%=incidencePlace%></label>
<label>Type &amp; No of Vehicle </label> <label class="value"><%=typeNoOfVehicle%></label>

<div class="clear"></div>

<label>Address of Driver</label> <label class="value"><%=addressOfDriver%></label>
<label>Remarks</label> <label class="value"><%=remarks%></label> <label>FIR
No</label> <label class="value"><%=FIRNo%></label>

<div class="clear"></div>

<label>Police Officer Name</label> <label class="value"><%=policeOfficerName%></label>
<label>Police Station </label> <label class="value"><%=policeStation%></label>
<label>Statement</label> <label class="value"><%=statement%></label>
<div class="clear"></div>


<%}}else{
			%>
<h6>No Mlc Records Found</h6>
<div class="clear"></div>
</div>
<%

		}
		%>
<%
		//-------------For Sil/Dil Details----------------------
		}else if(detailId.equals("Sil/Dil")){
			%>
<div class="clear"></div>
<h4>SIL/DIL Details</h4>
<div class="clear"></div>
<%int inc=1;
			if(silDilStatusList.size() >0){
			for(SilDilStatus silDilStatus : silDilStatusList){
				String silDilDate ="-";
				String silDilTime ="-";
				String icdName ="-";
				String treatment ="-";
				String remarks ="-";
				String conditionStatus ="-";
				String nok ="-";
				String placedBy ="-";
			if(silDilStatus.getIcd() !=null){
				icdName =""+silDilStatus.getIcd().getIcdName()+"["+silDilStatus.getIcd().getIcdCode()+"]";
			}
			if(silDilStatus.getTreatment() !=null){
				treatment =""+silDilStatus.getTreatment();
			}
			if(silDilStatus.getRemarks() !=null){
				remarks =""+silDilStatus.getRemarks();
			}
			if(silDilStatus.getConditionStatus() !=null){
				conditionStatus =""+silDilStatus.getConditionStatus();
			}
			if(silDilStatus.getNok() !=null){
				nok =""+silDilStatus.getNok();
			}
			if(silDilStatus.getLastChgDate() !=null){
				silDilDate =""+silDilStatus.getLastChgDate();
			}
			if(silDilStatus.getLastChgTime() !=null){
				silDilTime =""+silDilStatus.getLastChgTime();
			}
			if(silDilStatus.getPlacedBy() !=null){
				placedBy =""+silDilStatus.getPlacedBy().getFirstName()+" "+silDilStatus.getPlacedBy().getMiddleName()+" "+silDilStatus.getPlacedBy().getLastName();
			}
			%>

<div class="Block">
<h4><%=inc%></h4>
<div class="clear"></div>

<label>Condition</label> <label class="value"><%=conditionStatus%></label>
<label>Date </label> <label class="value"><%=silDilDate%></label> <label>Time
</label> <label class="value"><%=silDilTime%></label>

<div class="clear"></div>

<label>Placed By </label> <label class="value"><%=placedBy%></label> <label>Treatment
</label> <label class="value"><%=treatment%></label> <label>Remarks </label> <label
	class="value"><%=remarks%></label>

<div class="clear"></div>

<label>Nok </label> <label class="value"><%=nok%></label> <label>Diagnosis
</label> <%=icdName%>
<div class="clear"></div>
<%inc++;}}else{
				%>
<h6>No Sil/Dil Records Found</h6>
<div class="clear"></div>
</div>
<%
			}
			%>
<%//-------------For Transfer Details----------------------
			}else if(detailId.equals("Transfer")){
				%>
<div class="clear"></div>
<h4>Transfer Deatils</h4>
<div class="clear"></div>
<%	int i =1;
				if(transferList.size() >0){
					for(Transfer transfer :transferList){
					String fromWard ="-";
					String toWard ="-";
					String date ="-";
					String time ="-";
					String doctor ="-";
					fromWard = transfer.getFromWard().getDepartmentName();
					toWard = transfer.getToWard().getDepartmentName();
					date =""+transfer.getDateOfTransfer();
					time =transfer.getTimeOfTransfer();
					if(transfer.getAuthorizedBy() !=null)
					doctor =transfer.getAuthorizedBy().getFirstName()+" "+transfer.getAuthorizedBy().getMiddleName()+" "+transfer.getAuthorizedBy().getLastName();
				%>
<div class="Block">
<h4><%=i %></h4>
<div class="clear"></div>

<label>T Date</label> <label class="value"><%=date%></label> <label>T
Time</label> <label class="value"><%=time%></label> <label>From Ward </label> <label
	class="value"><%=fromWard%></label>

<div class="clear"></div>

<label>To Ward </label> <label class="value"><%=toWard%></label> <label>Auth
By </label> <label class="value"><%=doctor%></label>

<div class="clear"></div>

<%i++;}}else{
					%>
<h6>No Transfer Records Found</h6>

<div class="clear"></div>
</div>
<%
				}}%>

<%//-------------Else of Admission Type Details----------------------
	}else if(opOrString.equals("OP")){
	//-------------For Discharge  Details----------------------

		if(detailId.equals("Visit") ){
			%>
<div class="clear"></div>
<h4>Visit Details</h4>
<div class="clear"></div>
<%  if(visitList.size() > 0){
				Visit visit =visitList.get(0);
				String visitNo ="-";
				String visitDate ="-";
				String visitTime ="-";
				String hospitalStaff ="-";

				String complaint ="-";
				String department ="-";
				String consultingDoc ="-";
				String caseType ="-";

				String diagnosis ="-";
				String disposedAs ="-";
				String tokenNo ="-";
				Integer visitId=0;
				String opdRemarks="";
				String consultation="";

				visitNo =""+visit.getVisitNo();
				visitId=visit.getId();
				if(map.get("opdRemarks") !=null){
					opdRemarks =(String)map.get("opdRemarks");
					
				}
				
				if(map.get("consultation") !=null){
					consultation =(String)map.get("consultation");
					}
				if(visit.getVisitDate() !=null){
					visitDate =""+visit.getVisitDate();
				}
				if(visit.getVisitDate() !=null){
					visitDate =""+visit.getVisitDate();
				}
				if(visit.getVisitDate() !=null){
					visitDate =""+visit.getVisitDate();
				}
				if(visit.getVisitTime() !=null){
					visitTime =""+visit.getVisitTime();
				}
				if(visit.getHospitalStaff() !=null){
					if(visit.getHospitalStaff().equalsIgnoreCase("n"))
					hospitalStaff ="No";
					else if(visit.getHospitalStaff().equalsIgnoreCase("y"))
						hospitalStaff ="Yes";
				}

				if(visit.getComplaint() !=null){
					complaint =""+visit.getComplaint().getComplaintName();
				}
				if(visit.getDepartment() !=null){
					department =""+visit.getDepartment().getDepartmentName();
				}

				if(visit.getCaseType() !=null){
					caseType =""+visit.getCaseType().getCaseTypeName();
				}
				if(visit.getDoctor() !=null){
					MasEmployee doc=visit.getDoctor();
					consultingDoc ="";
					if(doc.getFirstName()!=null && !doc.getFirstName().equals(""))
						consultingDoc =consultingDoc+" "+doc.getFirstName();
					if(doc.getMiddleName()!=null && !doc.getMiddleName().equals(""))
						consultingDoc =consultingDoc+" "+doc.getMiddleName();
					if(doc.getLastName()!=null && !doc.getLastName().equals(""))
						consultingDoc =consultingDoc+" "+doc.getLastName();
				}
				
				if(visit.getTokenNo() !=null){
					tokenNo =""+visit.getTokenNo();
				}
				if(dischargeIcdCodeList.size() >0){
					 for(DischargeIcdCode dischargeIcdCode :dischargeIcdCodeList ){
							  if(!diagnosis.equals("")){
								  diagnosis = dischargeIcdCode.getIcd().getIcdName();  
							  }else{
								  diagnosis = diagnosis+"\n"+dischargeIcdCode.getIcd().getIcdName();
							  }
							  
					  }
				}
			%>

<div class="Block">
<label>Visit No. </label> <label class="value"><%=visitNo%></label>
<input type="hidden" value="<%=visitId%>" />
<label>Visit Date </label> <label class="value"><%=visitDate%></label> <label>Visit
Time </label> <label class="value"><%=visitTime%></label>
<div class="clear"></div>
<label>Complaint </label> <label class="value"><%=complaint%></label>

<label>Department</label> <label class="value"><%=department%></label>
<label>Consulting Doc</label> <label class="value"><%=consultingDoc%></label>
<div class="clear"></div>
<label>Remarks</label> <label class="value"><%=opdRemarks%></label>
<label>Consulting Summary</label> <label class="value"><%=consultation%></label>
<div class="clear"></div>
<label>Token No </label> <label class="value"><%=tokenNo%></label>
<label>Diagnosis</label> <textarea style="width: 497px;height: 39px;"><%=diagnosis%></textarea>
<div class="clear"></div>

</div>
<%} %> <%}else if(detailId.equals("OP-Mlc")){

	%>
<div class="clear"></div>
<h4>OP Mlc Deatils</h4>
<div class="clear"></div>
<%
		if(mlcCaseList.size() >0){
		for(MlcCase mlcCase :mlcCaseList){
			String mlcNo ="-";
			String mlcDate ="-";
			String mlcTime ="-";
			String natureOfMlc ="-";

			String natureofInjur ="-";
			String typeOfInjury ="-";
			String severityofInjury ="-";
			String injuryDimen ="-";

			String injuryDetails ="-";
			String broughtBy ="-";
			String doctorAttnd ="-";
			String condition ="-";

			String bodyPartAff ="-";
			String weaponUsed ="-";
			String incidenceDate ="-";
			String incidenceTime ="-";

			String incidencePlace ="-";
			String typeNoOfVehicle ="-";
			String addressOfDriver ="-";
			String remarks ="-";

			String FIRNo ="-";
			String policeOfficerName ="-";
			String policeStation ="-";
			String statement ="-";

			if(mlcCase.getMlcNo() !=null )
			mlcNo=mlcCase.getMlcNo();
			if(mlcCase.getMlcDate() !=null )
			mlcDate=""+mlcCase.getMlcDate();
			if(mlcCase.getMlcTime() !=null )
			mlcTime =mlcCase.getMlcTime();
			if(mlcCase.getNatureOfMlc() !=null )
			natureOfMlc =""+mlcCase.getNatureOfMlc();

				if(mlcCase.getInjuryNature() !=null )
					natureofInjur=mlcCase.getInjuryNature().getInjuryNatureName();
				if(mlcCase.getInjuryType() !=null )
					typeOfInjury=""+mlcCase.getInjuryType();
				if(mlcCase.getSeverityOfInjury() !=null )
					severityofInjury =mlcCase.getSeverityOfInjury();
				if(mlcCase.getInjuryDimension() !=null )
					injuryDimen =""+mlcCase.getInjuryDimension();

				if(mlcCase.getInjuryDetails() !=null )
					if(!mlcCase.getInjuryDetails().trim().equals(""))
					injuryDetails=mlcCase.getInjuryDetails();
				if(mlcCase.getBroughtBy() !=null )
					if(!mlcCase.getBroughtBy().trim().equals(""))
					broughtBy=""+mlcCase.getBroughtBy();
				if(mlcCase.getDoctor().getFirstName() !=null )
					doctorAttnd =mlcCase.getDoctor().getFirstName();
				if(mlcCase.getPatientCondition() !=null )
					if(!mlcCase.getPatientCondition().trim().equals(""))
					condition =""+mlcCase.getPatientCondition();

				if(mlcCase.getBodyPart() !=null )
					if(!mlcCase.getBodyPart().getBodyPartName().trim().equals(""))
					bodyPartAff=mlcCase.getBodyPart().getBodyPartName();
				if(mlcCase.getWeaponUsed() !=null )
					if(!mlcCase.getWeaponUsed().trim().equals(""))
					weaponUsed=""+mlcCase.getWeaponUsed();
				if(mlcCase.getIncidentDate() !=null )
					incidenceDate =""+mlcCase.getIncidentDate();
				if(mlcCase.getIncidentTime() !=null )
					if(!mlcCase.getIncidentTime().trim().equals(""))
					incidenceTime =""+mlcCase.getIncidentTime();

				if(mlcCase.getIncidentPlace() !=null )
					if(!mlcCase.getIncidentPlace().trim().equals(""))
					incidencePlace=mlcCase.getIncidentPlace();
				if(mlcCase.getTypeAndNoOfVehicle() !=null )
					if(!mlcCase.getTypeAndNoOfVehicle().trim().equals(""))
					typeNoOfVehicle=""+mlcCase.getTypeAndNoOfVehicle();
				if(mlcCase.getNameAndAddressOfDriver() !=null )
					if(!mlcCase.getNameAndAddressOfDriver().trim().equals(""))
					addressOfDriver =""+mlcCase.getNameAndAddressOfDriver();
				if(mlcCase.getRemarks() !=null )
					if(!mlcCase.getRemarks().trim().equals(""))
					remarks =""+mlcCase.getRemarks();

				if(mlcCase.getFirNo() !=null )
					if(!mlcCase.getFirNo().trim().equals(""))
					FIRNo=mlcCase.getFirNo();
				if(mlcCase.getPoliceOfficer() !=null )
					if(!mlcCase.getPoliceOfficer().trim().equals(""))
					policeOfficerName=""+mlcCase.getPoliceOfficer();
				if(mlcCase.getPoliceStation() !=null )
					if(!mlcCase.getPoliceStation().trim().equals(""))
					policeStation =""+mlcCase.getPoliceStation();
				if(mlcCase.getStatement() !=null )
					if(!mlcCase.getStatement().trim().equals(""))
					statement =""+mlcCase.getStatement();
		%>
<div class="Block"><label>MLC No </label> <label class="value"><%=mlcNo%></label>
<label>MLC Date </label> <label class="value"><%=mlcDate%></label> <label>MLC
Time </label> <label class="value"><%=mlcTime%></label> <label>Nature of
MLC </label> <label class="value"><%=natureOfMlc%></label> <label>Nature
of Injur </label> <label class="value"><%=natureofInjur%></label> <label>Type
Of Injury </label> <label class="value"><%=typeOfInjury%></label>

<div class="clear"></div>

<label>Severity of Injury </label> <label class="value"><%=severityofInjury%></label>
<label>Injury Dimen </label> <label class="value"><%=injuryDimen%></label>
<label>Injury Details </label> <label class="value"><%=injuryDetails%></label>


<label>Brought By </label> <label class="value"><%=broughtBy%></label> <label>Doctor
Attnd </label> <label class="value"><%=doctorAttnd%></label> <label>Condition</label>
<label class="value"><%=condition%></label>

<div class="clear"></div>

<label>Body Part Aff </label> <label class="value"><%=bodyPartAff%></label>
<label>Weapon Used </label> <label class="value"><%=weaponUsed%></label>
<label>Incidence Date </label> <label class="value"><%=incidenceDate%></label>

<div class="clear"></div>

<label>Incidence Time </label> <label class="value"><%=incidenceTime%></label>
<label>Incidence Place </label> <label class="value"><%=incidencePlace%></label>
<label>Type & No of Vehicle </label> <label class="value"><%=typeNoOfVehicle%></label>

<div class="clear"></div>

<label>Address Of Driver</label> <label class="value"><%=addressOfDriver%></label>
<label>Remarks</label> <label class="value"><%=remarks%></label> <label>FIR
No</label> <label class="value"><%=FIRNo%></label>

<div class="clear"></div>

<label>Police Officer Name</label> <label class="value"><%=policeOfficerName%></label>
<label>Police Station </label> <label class="value"><%=policeStation%></label>
<label>Statement</label> <label class="value"><%=statement%></label>

<div class="clear"></div>
<%}}else{%>
<h6>No Mlc Records Found</h6>
<div class="clear"></div>
</div>
<%}}
	}%> <%
	 
	if(detailId.equals("Operations")){
	%>
<div class="clear"></div>
<h4>Sugery Requisition Done</h4>
<%if(ipdOpdSurgeryHeaderList.size()>0)
	{%>
	<div class="division"></div>
	<div class="clear"></div>
	<%for(OpdSurgeryHeader header:ipdOpdSurgeryHeaderList)
	{%>
	<div class="">
	<div onclick="expandCollaps(this);">
	<div class="clear"></div>
	<h6 style="display: inline;">
	<img src="../jsp/images/plusIcon.gif" alt="" /> 
	</h6>
	<h6 style="display: inline;"><%=header.getRequisitionDate() %></h6>
	<h6 style="display: inline;"><%=header.getRequisitionTime() %></h6>
	<h6 style="display: inline;"><%=header.getPrescribedDepartment().getDepartmentName() %></h6>
	<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="collaps">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="">
	<tr>
		<th scope="col">Procedure Name</th>
		<th>Procedure Code</th>
		<th>Tentative Date</th>
		<th>Remarks<%=header.getOpdSurgeryDetails().size()%></th>
		
	</tr>
		<%for(OpdSurgeryDetail opdSurgeryDetail:header.getOpdSurgeryDetails())
		{%>
		<tr>
		
			<td>
			<%=opdSurgeryDetail.getChargeCode().getChargeCodeName() %>
			</td>
			<td>
			<%=opdSurgeryDetail.getChargeCode().getChargeCodeCode() %>
			</td>
			<td>	
				<%=opdSurgeryDetail.getTentativeDate() %>
				</td>
				<td>	
				<%=opdSurgeryDetail.getRemarks() %>
				</td>
			
		</tr>
	 <%}%>
	</table>
	</div>
	</div>
	<%}
	}else{%>
	<h6>No Records Found!</h6>
	<%} %>
<div id="prescrpDiv"></div>
<%}else if(detailId.equals("Investigation")){ %>
<div class="clear"></div>
<h4>Investigation  Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%
if(dgOrderhd!=null)
{
	
	System.out.println(" in if  ");
	String clinicalNote="";
	String orderNo="";
	if(dgOrderhd.getClinicalNote()!=null){
		clinicalNote=dgOrderhd.getClinicalNote(); 
	}
	orderNo=dgOrderhd.getOrderNo();
	Set<DgOrderdt> dgOrderdtSet=dgOrderhd.getDgOrderdts();
%>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div> 
<div class="">
<div onclick="expandCollaps(this);">
<div class="clear"></div>
<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.gif" alt="" /> 
</h6>
<h6 style="display: inline;"><%=dgOrderhd.getOrderDate() %></h6>
<h6 style="display: inline;"><%=dgOrderhd.getOrderTime()%></h6>
<h6 style="display: inline;"><%=dgOrderhd.getDepartment().getDepartmentName() %></h6>
<div class="clear"></div>
</div>
<div class="clear"></div>
	<div class="collaps">
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
		<th scope="col">Result</th>
		
		<th scope="col">Clinical Observation</th>
		<th scope="col">Outside Lab</th>
		<th scope="col">Result Parameter</th>
		<th scope="col">Lab Values</th>
<!-- 		<th scope="col">Clinical Observation2</th>
		<th scope="col">Clinical Observation3</th>
		<th scope="col">Clinical Observation4</th>
		<th scope="col">Clinical Observation5</th>
 -->		
	</tr>
<%
int i=1;
String clinicalObservation = "";
String clinicalObservation2 = "";
String clinicalObservation3 = "";
String clinicalObservation4 = "";
String clinicalObservation5 = "";
boolean dataavail=false;
if(dgOrderdtSet.size()>0){
for(DgOrderdt orderdt:dgOrderdtSet)
{
	int dgSampleHeaderId = 0;
	int subChargeId = 0;
	System.out.println("in set 1");
Set<DgSampleCollectionHeader>dgSampleCollectionHeaderSet=orderdt.getOrderhd().getDgSampleCollectionHeaders();
	String url="/hms/hms/enquiry?method=investigationResult&orderNo="+orderNo+"&chargeCodeId="+orderdt.getChargeCode().getId();
%>


	<tr> 
		<td><%=orderdt.getChargeCode().getChargeCodeName()+" "+orderdt.getId()%></td>  
		<td><%=clinicalNote%></td> 
		<td><input type="button" accesskey="a" class="button" value="Result" 
			 onclick="callFunction();" id="print" name="print"></td>
		<td>
		<%
		int dgResultEntryHeaderId = 0;
		String status = "";
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				dgSampleHeaderId=dgSampleCollectionHeader.getId();			
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						subChargeId=dgResultEntryHeader.getSubcharge().getId();
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarks() != null && !dgResultEntryDetail.getRemarks().equals("")){
								clinicalObservation = dgResultEntryDetail.getRemarks();
								dataavail=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail==false ){ %>
<textarea name="clinicalObservation" id="observationId<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"   maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation != null?clinicalObservation:"By"+empName%></textarea>
		
		<%}else{ %>
<textarea name="clinicalObservation" disabled="disabled" id="observationId<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"   maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation != null?clinicalObservation:"By"+empName%></textarea>
		
		<%} %>
		
	<%-- 	<%
		int dgResultEntryHeaderId2 = 0;
		String status2 = "";
		boolean dataavail2=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksOne() != null){
									clinicalObservation2 = dgResultEntryDetail.getRemarksOne(); 
									dataavail2=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail2==false){ %>
		<textarea name="clinicalObservation" id="observationId2<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation2 != null?clinicalObservation2:""%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','2')" id="Save" name="Save">
 --%>	<%--	<%}else{ %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId2<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation2 != null?clinicalObservation2:""%></textarea>
		<%} %>
		<%
		int dgResultEntryHeaderId3 = 0;
		String status3 = "";
		boolean dataavail3=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksTwo() != null){
									clinicalObservation3 = dgResultEntryDetail.getRemarksTwo(); 
									dataavail3=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail3==false){ %>
        <textarea name="clinicalObservation" id="observationId3<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation3 != null?clinicalObservation3:""%></textarea>
	<%-- 	<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','3')" id="Save" name="Save"> --%>
	<%--	<%}else { %>
        <textarea name="clinicalObservation" id="observationId3<%=i %>" disabled="disabled" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation3 != null?clinicalObservation3:""%></textarea>		
		<%} %>
		<%
		int dgResultEntryHeaderId4 = 0;
		String status4 = "";
		boolean dataavail4=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksThree() != null){
								clinicalObservation4 = dgResultEntryDetail.getRemarksThree(); 
								dataavail4=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail4==false){ %>
        <textarea name="clinicalObservation" id="observationId4<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation4 != null?clinicalObservation4:""%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','4')" id="Save" name="Save">
 --%><%--		<%}else { %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId4<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation4 != null?clinicalObservation4:""%></textarea>
		<%} %>
		<%
		int dgResultEntryHeaderId5 = 0;
		String status5 = "";
		boolean dataavail5=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksFour() != null){
								clinicalObservation5 = dgResultEntryDetail.getRemarksFour(); 
								dataavail5=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail5==false){ %>
		<textarea name="clinicalObservation" id="observationId5<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation5 != null?clinicalObservation5:""%></textarea>
	<%-- 	<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','5')" id="Save" name="Save"> --%>
	<%--	<%}else{ %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId5<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation5 != null?clinicalObservation5:""%></textarea>
		<%} %>
		<%if(dataavail==false ||  dataavail2==false || dataavail3==false || dataavail4==false || dataavail5==false){ %>
		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>')" id="Save" name="Save">
<%} %> --%>
        <input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>')" id="Save" name="Save">
		</td> 
		<td>
		<%String lab="";
		if(orderdt.getOutsideLab()!=null){
			lab=orderdt.getOutsideLab();
		}
		System.out.println("outSideLab jsp "+lab);
		%>
		<%if(lab.equalsIgnoreCase("y")){ %>
		<input type="checkbox" id="outsideLab<%=i %>" disabled="disabled" checked="checked" name="outsideLab<%=i %>" value="y" onchange="showSaveOutsideDiv(<%=i %>);"/>
		<%}else{ %>
		<input type="checkbox" id="outsideLab<%=i %>" name="outsideLab<%=i %>" value="y" onchange="showSaveOutsideDiv(<%=i %>);"/>
		<%}%>
		<script>
		window.onload= showSaveOutsideDiv(<%=i %>);
		</script>
		</td>
		<td>
	 	<input type="text" id="outsideLabName<%=i %>" name="outsideLabName<%=i %>" <%if(lab.equalsIgnoreCase("y")){ %> readonly="readonly" <%} %> 
	 	value="<%=orderdt.getOutsideLabName()!=null?orderdt.getOutsideLabName():""%>"/>	 		
		</td>
		<td>
	 		<textarea name="outsideLabValue<%=i %>" class="outsideLabValue"
				id="outsideLabValue<%=i %>" validate="labValue,string,no" <%if(lab.equalsIgnoreCase("y")){ %> readonly="readonly" <%} %>
				cols="0" rows="0" maxlength="300"><%=orderdt.getOutsideLabValues()!=null?orderdt.getOutsideLabValues():"" %></textarea>
		<input type="button" id="saveBut<%=i %>" class="button" value="Save" <%if(lab.equalsIgnoreCase("y")){ %> disabled="disabled" <%} %> onclick="saveOutsideLab('<%=orderdt.getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>');" >
		</td>
	</tr>
	<%i++;}}else{
		for(DgOrderdt orderdt:DgOrderdtList){
			System.out.println("in set 2");
			Set<DgSampleCollectionHeader>dgSampleCollectionHeaderSet=orderdt.getOrderhd().getDgSampleCollectionHeaders();
				String url="/hms/hms/enquiry?method=investigationResult&orderNo="+orderNo+"&chargeCodeId="+orderdt.getChargeCode().getId();
			
		%>
	<tr> 
		<td><%=orderdt.getChargeCode().getChargeCodeName()%></td>  
		<td><%=clinicalNote%></td> 
		<td><input type="button" accesskey="a" class="button" value="Result" 
			 onclick="popwindowresult('<%=url%>');" id="print" name="print"></td>
		<td>
		<%
		int dgResultEntryHeaderId = 0;
		String status = "";
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarks() != null && !dgResultEntryDetail.getRemarks().equals("")){
								clinicalObservation = dgResultEntryDetail.getRemarks();
								dataavail=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail==false ){ %>
<textarea name="clinicalObservation" id="observationId<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"   maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation != null?clinicalObservation:"By"+empName%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','1')" id="Save" name="Save"> --%>
		<%}else{ %>
<textarea name="clinicalObservation" disabled="disabled" id="observationId<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"   maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation != null?clinicalObservation:"By"+empName%></textarea>
		
		<%} %>
		
		<%
		int dgResultEntryHeaderId2 = 0;
		String status2 = "";
		boolean dataavail2=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksOne() != null){
									clinicalObservation2 = dgResultEntryDetail.getRemarksOne(); 
									dataavail2=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail2==false){ %>
		<textarea name="clinicalObservation" id="observationId2<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation2 != null?clinicalObservation2:""%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','2')" id="Save" name="Save">
 --%>		<%}else{ %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId2<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation2 != null?clinicalObservation2:""%></textarea>
		<%} %>
		<%
		int dgResultEntryHeaderId3 = 0;
		String status3 = "";
		boolean dataavail3=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksTwo() != null){
									clinicalObservation3 = dgResultEntryDetail.getRemarksTwo(); 
									dataavail3=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail3==false){ %>
        <textarea name="clinicalObservation" id="observationId3<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation3 != null?clinicalObservation3:""%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','3')" id="Save" name="Save"> --%>
		<%}else { %>
        <textarea name="clinicalObservation" id="observationId3<%=i %>" disabled="disabled" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation3 != null?clinicalObservation3:""%></textarea>		
		<%} %>
		<%
		int dgResultEntryHeaderId4 = 0;
		String status4 = "";
		boolean dataavail4=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksThree() != null){
								clinicalObservation4 = dgResultEntryDetail.getRemarksThree(); 
								dataavail4=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail4==false){ %>
        <textarea name="clinicalObservation" id="observationId4<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation4 != null?clinicalObservation4:""%></textarea>
<%-- 		<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','4')" id="Save" name="Save">
 --%>		<%}else { %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId4<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation4 != null?clinicalObservation4:""%></textarea>
		<%} %>
		<%
		int dgResultEntryHeaderId5 = 0;
		String status5 = "";
		boolean dataavail5=false;
		if(dgSampleCollectionHeaderSet.size()>0){
			for(DgSampleCollectionHeader dgSampleCollectionHeader: dgSampleCollectionHeaderSet){
				Set<DgSampleCollectionDetails> dgResultEntryHeaderSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
				if(dgResultEntryHeaderSet.size()>0){
					for(DgSampleCollectionDetails dgResultEntryHeader:dgResultEntryHeaderSet){
						if(orderdt.getChargeCode().getId() == dgResultEntryHeader.getChargeCode().getId()){
						dgResultEntryHeaderId = dgResultEntryHeader.getId();
						Set<DgResultEntryDetail>dgResultEntryDetailSet = dgResultEntryHeader.getDgResultEntryDetails();
						if(dgResultEntryDetailSet.size()>0){
							for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailSet){
								if(dgResultEntryDetail.getValidated()!=null){
								status =dgResultEntryDetail.getValidated();
								}
								if(dgResultEntryDetail.getRemarksFour() != null){
								clinicalObservation5 = dgResultEntryDetail.getRemarksFour(); 
								dataavail5=true;
								}
							}
						}
						}
					}
				}
			}
		}
		
		%>
		 
		 
		<%if( dataavail5==false){ %>
		<textarea name="clinicalObservation" id="observationId5<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation5 != null?clinicalObservation5:""%></textarea>
	<%-- 	<input type="button" accesskey="a" class="button" value="Save" onclick="saveClinicalObservation('<%=orderdt.getOrderhd().getId() %>','<%=orderdt.getChargeCode().getId() %>','<%=i %>','5')" id="Save" name="Save"> --%>
		<%}else{ %>
		<textarea name="clinicalObservation" disabled="disabled" id="observationId5<%=i %>" validate="clinical Observation,string,no" cols="0" rows="0"  maxlength="190"  onkeyup="return checkLength(this)"><%=clinicalObservation5 != null?clinicalObservation5:""%></textarea>
		<%} %>
		
		</td> 		
	</tr>	
		
<%i++;}} %>
</table>
</div>
</div> 
<%}else{ %>
<h6>No Investigation Records Found!</h6>
<%}%>
<%}else if(detailId.equals("Prescriptions")){%>
<div class="clear"></div>
<h4>Prescription Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%
if(ipdPatientPrescriptionHeaderList!=null && ipdPatientPrescriptionHeaderList.size()>0)
{
%>

<%
for(PatientPrescriptionHeader header:ipdPatientPrescriptionHeaderList)
{

%>
<div class="">
<div onclick="expandCollaps(this);">

<h6 style="display: inline;">
<img src="../jsp/images/plusIcon.gif" alt="" /> 
</h6>
<h6 style="display: inline;"><%=header.getPrescriptionDate() %></h6>
<h6 style="display: inline;"><%=header.getPrescriptionTime() %></h6>
<h6 style="display: inline;"><%=header.getDepartment().getDepartmentName() %></h6>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="collaps">
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<th scope="col">Item Name</th>
<th scope="col">Dosage</th>
<th scope="col">Unit</th>
<th scope="col">Frequency</th>
<!-- <th scope="col">No Of Days</th> -->
<th scope="col">Duration</th>
<th scope="col">Instruction</th>
<th scope="col" >Special Instruction</th>
<th scope="col" >Route</th>
<th scope="col">Total</th>
</tr>
<%for(PatientPrescriptionDetails details:header.getPatientPrescriptionDetails())
{%>
<tr>
<td>

<%if(details.getItem()!=null ){%>
<%=details.getItem().getNomenclature() %>

<%} %>
</td>
<td>
<%if(details.getDosage()!=null ){%>
<%=details.getDosage() %>
<%} %>
</td>
<td>
<%if(details.getItem()!=null && details.getItem().getItemConversion()!=null && details.getItem().getItemConversion().getIssueUnit()!=null){ %>
	<%=details.getItem().getItemConversion().getIssueUnit().getUnitName()%>
<%} %>
</td>
<td> <%=details.getFrequency()!=null ?details.getFrequency().getFrequencyName():""%>
</td>

<td>
<%=details.getNoOfDays()+" "+(details.getFrequency()!=null?details.getFrequency().getFrequencyType():"")%>
</td>
<td>
<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
</td>
<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
</td>
<td>
<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
</td>
<td>
<%=details.getTotal() %>
</td>
</tr>
<%}
%>
</table>
</div>
</div>
<%
}
%>
<div id="prescrpDiv"></div>
<%}else{ %>
<h6>No Prescription Records Found!
</h4>
<%}%>
<%}else if(detailId.equalsIgnoreCase("Vitals")){
	if(vitals!=null && vitalListSize>0){%>
		<div class="clear"></div>
		<label>Visit Date</label>
		<%if(vitals!=null && vitals.getVisit()!=null && vitals.getVisit().getVisitDate()!=null){ %>
		<label class="value"><%=vitals.getVisit().getVisitDate() %></label>
		<%}%>
		<label>Visit Time</label>
		<%if(vitals!=null && vitals.getVisit()!=null && vitals.getVisit().getVisitTime()!=null){ %>
		<label class="value"><%=vitals.getVisit().getVisitTime() %></label>
		<%}%>
		
		<label>Pulse</label>
		<%if(vitals.getPulse()!=null){ %>
		<label class="value"><%=vitals.getPulse() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>Temperature</label>
		<%if(vitals.getTemperature()!=null){ %>
		<label class="value"><%=vitals.getTemperature() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%}%>
		<label>Height</label>
		<%if(vitals.getHeight()!=null){ %>
		<label class="value"><%=vitals.getHeight() %></label>
		<%}else{%>
		<label class="value">-</label>
		<%}%>
		<input type="hidden" id="weight" value="<%=vitals.getWeight() %>">
		<input type="hidden" id="height" value="<%=vitals.getHeight() %>">
		<label>Weight</label>
		<%if(vitals.getWeight()!=null){ %>
		<label class="value"><%=vitals.getWeight() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>BMI</label>
		<%if(vitals.getBmi()!=null){ %>
		<label class="value" id="bmicat"><%=vitals.getBmi() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		
		<label>BP</label>
		<%if(vitals.getBp()!=null){ %>
		<label class="value"><%=vitals.getBp() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%}%>
<%}else{%>

<h4>No Records Found!!</h4>

<%}%>
<%}else if(detailId.equalsIgnoreCase("examination")){
	if(opdDetails!=null && opdDetails.size()>0){
	OpdPatientDetails opddetails=opdDetails.get(0);
	%>
	
		<div class="clear"></div>
		<label>Visit Date</label>
		<%if(vitals!=null && vitals.getVisit()!=null && vitals.getVisit().getVisitDate()!=null){ %>
		<label class="value"><%=vitals.getVisit().getVisitDate() %></label>
		<%}%>
		<label>Visit Time</label>
		<%if(vitals!=null && vitals.getVisit()!=null && vitals.getVisit().getVisitTime()!=null){ %>
		<label class="value"><%=vitals.getVisit().getVisitTime() %></label>
		<%}%>
		
		<label>Local Examination</label>
		<%if(opddetails.getLocalExamination()!=null){ %>
		<label class="value"><%=opddetails.getLocalExamination() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>General Examination</label>
		<%if(opddetails.getGeneralExamination()!=null){ %>
		<label class="value"><%=opddetails.getGeneralExamination() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%}%>
		<label>Symentic Examination</label>
		<%if(opddetails.getSystemicExamination()!=null){ %>
		<label class="value"><%=opddetails.getSystemicExamination() %></label>
		<%}else{%>
		<label class="value">-</label>
		<%}%>

<%}else{%>

<h4>No Records Found!!</h4>





<%}}else if(detailId.equalsIgnoreCase("pre-opc")){ %>
	<%if(preOpcSize>0){ %>
		
<label>Present Complaint / History</label>
<textarea name="presentComplain" readonly="readonly" class="medium" id="presentComplain"  validate="presentComplain,string,no"   cols="0" rows="0"  maxlength="300" tabindex="1" ><%=preOpc.getPresentComplaintHistory()!=null?preOpc.getPresentComplaintHistory():"" %></textarea>
  
<label>History of Past Illness</label>
 <textarea name="pastIllness" readonly="readonly" class="medium" id="pastIllness" cols="0"  validate="pastIllness,string,no" 	rows="0" maxlength="300" tabindex="1"  ><%=preOpc.getPastIllnessHistory()!=null?preOpc.getPastIllnessHistory():"" %></textarea>

<div class="clear"></div>
<label>Personal History</label>
<textarea name="personalHistory" readonly="readonly" class="medium" id="personalHistory"  validate="personalHistory,string,no"  tabindex="1" cols="0"	rows="0" maxlength="500" ><%=preOpc.getPresentHistory()!=null?preOpc.getPresentHistory():"" %></textarea>

<label>Family History</label>
<textarea	name="familyHistory" readonly="readonly" id="familyHistory" class="medium"  validate="familyHistory,string,no"  cols="0"   tabindex="4" rows="0" maxlength="500" ><%=preOpc.getFamilyHistory()!=null?preOpc.getFamilyHistory():"" %></textarea>

<div class="clear"></div>

<label>Medication History</label>
<textarea name="medicationhistory" readonly="readonly" id="medicationhistory" class="medium "  validate="medicationhistory,string,no"    cols="0"	rows="0" maxlength="500" tabindex="5"><%=preOpc.getMadicationHistory()!=null?preOpc.getMadicationHistory():"" %></textarea>
<div class="clear"></div>

<label class="auto">Pulse</label>
<input name="pulse" id="pulse" readonly="readonly" type="text" value="<%=preOpc.getPulse()!=null && preOpc.getPulse()>0?preOpc.getPulse():"" %>"	validate="pulse,num,no" maxlength="3" class="textSmall"  tabindex="10"/>
<label	class="smallAuto">min</label>

<label class="auto">Temperature</label>
<input	name="temperature" readonly="readonly" id="temperature" value="<%=preOpc.getTemperature()!=null && preOpc.getTemperature()>0?preOpc.getTemperature():"" %>" validate="temperature,float,no" type="text" maxlength="6" class="textSmall"  tabindex="11"/>
<label	class="smallAuto">&deg;F</label>

<label id="bpLabel" class="auto">BP</label>
<input readonly="readonly" value="<%=preOpc.getBp()!=null ?preOpc.getBp():"" %>"  type="text" 	maxlength="3" class=" textSmall"  tabindex="12"/>
<label class="smallAuto">mm&nbsp;Hg</label>

<div class="clear"></div>
<label class="auto">Weight</label>
<input name="weight" readonly="readonly" id="weight" type="text" maxlength="3" value="<%=preOpc.getWeight()!=null && preOpc.getWeight()>0?preOpc.getWeight():"" %>"  class="textSmall"   validate="weight,int,no"  tabindex="14"/>
<label	class="smallAuto">Kg</label>

<label class="auto">Height</label>
<input	name="height" readonly="readonly" id="height" type="text" value="<%=preOpc.getHeight()!=null && preOpc.getHeight()>0?preOpc.getHeight():"" %>"  maxlength="3" class="textSmall"  validate="height,int,no" tabindex="15"/>
<label	class="smallAuto">cm</label>

 <%}else{%>
 	<h4>No Records Found!!</h4>
	<%} %> 
<%}else if(detailId.equalsIgnoreCase("diag")){ %>

<%if(!diagnosisIcd.equals("")){ %>
<label>Patient Diagnosis</label>
<div class="clear"></div>
<textarea  style="width: 497px;height: 39px;"><%= diagnosisIcd%></textarea>
<textarea  style="width: 497px;height: 39px;"><%= diagnosisIcd%></textarea>
<%}else{%>
	<h4>No Records Found!!</h4>
<%}
}else if(detailId.equalsIgnoreCase("Procedures")){ %>
	<!-- added by amit das on for OT procedures on 28-09-2016 --> 
		<%if(opdSurgeryDetailList.size()>0){%>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
			<tr>
				<th>Procedure Name</th>
				<th>Remarks</th>
			</tr>
			<%
			String procedureName="";
			String procedureRemark="";
			for(OpdSurgeryDetail pd:opdSurgeryDetailList){		
				// procedureName=pd.getProcedureName(); 
				procedureName=pd.getChargeCode().getChargeCodeName(); // Changed by Amit Das for procedure name in visit history of patient
				if(pd.getRemarks()!=null)
						procedureRemark= pd.getRemarks();
			%>
			<tr>
				<td><%=procedureName%></td>
				<td><%=procedureRemark%></td>
			</tr>
		</table>	
			<%} %>
		<%} %>

		<%if(procedureDetailsList.size()>0){%>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
			<tr>
				<th>Procedure Name</th>
				<th>Remarks</th>
			</tr>
			<%
			String procedureName="";
			String procedureRemark="";
			for(ProcedureDetails pd:procedureDetailsList){		
				// procedureName=pd.getProcedureName(); 
				procedureName=pd.getProcedure().getNursingName(); // Changed by Amit Das for procedure name in visit history of patient
				procedureRemark=pd.getRemarks();
			%>
			<tr>
				<td><%=procedureName%></td>
				<td><%=procedureRemark%></td>
			</tr>
		</table>	
			<%} %>
		<%} else{ %>
	 	<h4>No Records Found!!</h4>
	 	<%} %>
<%}%>

<script type="text/javascript">
jQuery(function ($) {
	   var bmicat;
		if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
		{
			 var height = 	parseFloat($("#height").val())/100;
			 var weight = 	$("#weight").val();
			 bmicat=(weight/(height*height)).toFixed(2);
			 $("#bmicat").val(" ");
			 if(bmicat<18.5){
				 $("#bmicat").text("Underweight");
				 $("#bmicat").css('color', '#F65C5C');
			}else if(bmicat>=18.5 && bmicat<25){
				$("#bmicat").text("Healthy Range");	
				$("#bmicat").css('color', 'green');
			}else if(bmicat>=25 && bmicat<=30){
				$("#bmicat").text("Overweight");
			}else if(bmicat>=30 && bmicat<=35){
				$("#bmicat").text("Obese");
				$("#bmicat").css('color', '#C40707');
			}else if(bmicat>35){
				$("#bmicat").text("Severely obese ");
				$("#bmicat").css('color', '#AD0C0C');
			}
		}
});

function callFunction(){
	alert("callFunction");
}

</script>