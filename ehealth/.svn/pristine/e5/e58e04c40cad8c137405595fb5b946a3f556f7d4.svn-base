<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.PatientObservation"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>jQuery.noConflict();</script>

<script type="text/javascript" language="javascript">
	<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");

	int totalPatient=0;
	OpdPatientDetails details=new OpdPatientDetails();
	List<PatientObservation>obsList=new ArrayList<PatientObservation>();
	List<ProcedureDetails> procedureDetailsList=new ArrayList<ProcedureDetails>();
	List<PatientPrescriptionDetails> patientPrescriptionDetails=new ArrayList<PatientPrescriptionDetails>();
	List<DgOrderdt> dgOrderdts=new ArrayList<DgOrderdt>();
	List<StoreItemBatchStock> sotckBatchList = new ArrayList<StoreItemBatchStock>();
	if(map.get("sotckBatchList") !=null){
		sotckBatchList=(List<StoreItemBatchStock>)map.get("sotckBatchList");
	}
	if(map.get("procedureDetailsList") != null){
		procedureDetailsList=(List<ProcedureDetails>)map.get("procedureDetailsList");
	}
	if(map.get("patientPrescriptionDetails") != null){
		patientPrescriptionDetails=(List<PatientPrescriptionDetails> )map.get("patientPrescriptionDetails");
	}
	if(map.get("dgOrderdts") != null){
		dgOrderdts=(List<DgOrderdt>)map.get("dgOrderdts");
	}
	
	List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
	if(map.get("routeOfAdministrationList") != null)
	{
		routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
	}
	List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
	if(map.get("masInstructionMasterList") != null)
	{
	  masInstructionMasterList=(List<OpdInstructionTreatment>)map.get("masInstructionMasterList");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	
	Integer tokenNo=null;
	String patientName="";
	String doctorName="";
	Integer visitNo=null;
	String mobilNo="";
	String visitDate="";
	Visit visit=null;
	Integer hinId=0;
	if(map.get("opdpatient") != null){
		details=(OpdPatientDetails)map.get("opdpatient");
		visit=details.getVisit();
		tokenNo=visit.getTokenNo();
		visitNo=visit.getVisitNo();
		Patient patient=visit.getHin();
		
		if(visit!=null){
			hinId=visit.getHin().getId();
		}
		
		if(visit.getHin().getPFirstName()!= null){
	patientName=visit.getHin().getPFirstName();
	
	if(visit.getHin().getPMiddleName()!= null){
	patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null)
	{
	patientName=patientName+" "+visit.getHin().getPLastName();
	}
		}
		if(visit.getDoctor()!= null){
	doctorName=visit.getDoctor().getFirstName();
	if(visit.getDoctor().getMiddleName()!= null){
		doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
	}
	if(visit.getDoctor().getLastName()!= null)
	{
		doctorName=doctorName+" "+visit.getDoctor().getLastName();
	}
		}
		visitDate=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	}
	if(map.get("observationList") != null){
		obsList=(List)map.get("observationList");
	}
	
	
	List<MasDepartment> wardDepartmentList = new   ArrayList<MasDepartment>();
	if(map.get("wardDepartment") != null)
	{
		wardDepartmentList=(List<MasDepartment>)map.get("wardDepartment");
	}
%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<div class="Block">
	<form name="observationWard" method="post" action="">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
		<%
			if(map.get("msg") != null){
		%>
		<div class="clear"></div>
		<label class="autoSize"><span><%=map.get("msg")%></span></label>
		<div class="clear"></div>
		<div class="clear"></div>
		<input type="button" class="buttonAuto"
			value="Observation ward waiting list"
			onclick="window.open('/hms/hms/opd?method=getObservationDashboard','_self');" />
		<%
			}else{
		%>
		<h4>Observation Ward</h4>
		<label>Token No</label> <input name="tokenNo" id="tokenNo" type="text"
			value="<%=tokenNo!=null?tokenNo:""%>" tabindex="10"
			validate="Token No,alphanumeric,no" /> <input name="opdId"
			id="opdId" type="hidden" value="<%=details.getId()%>"
			validate="Opd Id,alphanumeric,no" />
			
			<input name="hinId" id="hinId" type="hidden" value="<%=hinId%>" />
			<input id="visitId" name="visitId" id="visitId" type="hidden" value="<%=visit!=null?visit.getId():0%>" />
			
			
			 <label>Patient Name</label> <input
			name="patientName" id="patientName" type="text"
			value="<%=patientName!=null?patientName:""%>" tabindex="10"
			validate="Patient Name,alphanumeric,no" /> <label>Doctor
			Name</label> <input name="doctorName" id="doctorName" type="text"
			value="<%=doctorName!=null?doctorName:""%>" tabindex="10"
			validate="Doctor,alphanumeric,no" />

		<div class="clear"></div>
		<label>Visit No</label> <input name="visitNo" id="visitNo" type="text"
			value="<%=visitNo%>" tabindex="10"
			validate="Visit No,alphanumeric,no" /> <label>Visit Date</label> <input
			name="visitDate" id="visitDate" type="text" value="<%=visitDate%>"
			tabindex="10" validate="Visit Date,date,no" /> <label>Mobile
			No</label> <input name="mobilNo" id="mobilNo" type="text"
			value="<%=mobilNo!=null?mobilNo:""%>" tabindex="10"
			validate="Mobile,number,no" />
		<div class="clear"></div>
		<%
			if(details!=null){
		%>
		<input type="hidden" name="opdId" id="opdId"
			value="<%=details!=null?details.getId():0%>">
			<input id="visitId" name="visitId" id="visitId" type="hidden"
			value="<%=visit!=null?visit.getId():0%>" />
		<%
			}
				if(patientPrescriptionDetails!=null && patientPrescriptionDetails.size()>0){
		%>
		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<label>Investigation Details</label>
		<div class="paddingTop15"></div>
		<div class="clear"></div>

		<div class="tableForTab" style="width: 620px;">
			<div id="divTemplet1">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">Investigation Name</th>
						<th scope="col">Clinical Notes</th>
						<th scope="col">Status</th>
					</tr>
					<%
						int count=1;
					%>
					<%
						for(DgOrderdt pob:dgOrderdts){
					%>
					<tr>
						<td scope="col"><%=count++%></td>
						<td><input type="hidden" value="<%=pob.getId()%>" /> <input
							type="text" class="nomeclatureOpdgridText"
							value="<%=pob.getChargeCode().getChargeCodeName()%>" /></td>
						<td scope="col"><input class="opdgridText" /></td>
						<td scope="col">
							<%
								if(pob.getPaymentMade()!=null && !pob.getPaymentMade().equalsIgnoreCase("y")){
							%> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Done" /> <%
 	}else{
 %> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Not Done" /> <%
 	}
 %>
						</td>
					</tr>
					<%
						}
					%>

				</table>
			</div>
		</div>
		<%
			}
		%>

		<%
			if(patientPrescriptionDetails!=null && patientPrescriptionDetails.size()>0){
		%>
		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<label>Prescription Details</label>
		<div class="paddingTop15"></div>
		<div class="clear"></div>

		<div class="tableForTab" style="width: 1120px">
			<div id="divTemplet1">
				<table border="0" align="center" cellpadding="0" cellspacing="0" id="medicGrid">
					<tr>
						<th scope="col">Action</th>
						<th scope="col">Item Name</th>
						<th scope="col">Route</th>
						<th scope="col">Batch No</th>
						<th scope="col">Dosage</th>
						<th scope="col">Unit</th>
						<th scope="col">pres Qty</th>
						<th scope="col">Frequency</th>
						<th scope="col">Instruction</th>
						<th scope="col">Special Instruction</th>
						<th scope="col">Status</th>
						<th scope="col">Done At</th>
					</tr>
					<%
						int count=1;
					%>
					<%
						for(PatientPrescriptionDetails pob:patientPrescriptionDetails){
							String mixable="";
							String aDispQty="";
							String mixtureQuantity="";
							if(pob.getItem().getMixable()!=null){
							mixable = pob.getItem().getMixable().toUpperCase();
							}
							if(pob.getItem().getADispQty()!=null){
								aDispQty=String.valueOf(pob.getItem().getADispQty());
							}
							if(pob.getItem().getMixtureQuantity()!=null){
								mixtureQuantity=String.valueOf(pob.getItem().getMixtureQuantity());
							}
					%>
					<tr>
						<td scope="col">
							<%
								if(pob.getNursingStatus().equalsIgnoreCase("y")){
							%> <input type="checkbox" class="radioCheck" disabled="disabled"
							value="<%=pob.getId()%>" name="prescrtionNurseStatus<%=count%>"
							id="prescrtionNurseStatus<%=count%>" />
							
							 <%
 	}else{
 %> <input type="checkbox" class="radioCheck" value="<%=pob.getId()%>"
							name="prescrtionNurseStatus<%=count%>"
							id="prescrtionNurseStatus<%=count%>" /> <%
 	}
 %>
						</td>
						<td scope="col"><input type="hidden" value="<%=pob.getId()%>" name="pdId<%=count%>" id="pdId<%=count%>"/>
							<input type="text" readonly="readonly"
							class="nomeclatureOpdgridText"
							value="<%=pob.getItem().getNomenclature()%>" /></td>
						<td scope="col"><input type="text" class="opdgridText" id="routeId<%=count%>" name="routeId<%=count%>"
							readonly="readonly"
							value="<%=pob.getRoute()!=null?pob.getRoute().getRouteName():""%>" /></td>
							
						<td scope="col" style="display:none">
						<input type="hidden" class="opdgridText" id="itemId<%=count%>" name="itemId<%=count%>"
							readonly="readonly"
							value="<%=pob.getItem()!=null?pob.getItem().getId():""%>" />
							<input type="hidden" size="10" value="<%=mixable %>" name="mixable<%=count %>"  id="mixable<%=count %>"  tabindex="1" />
							<input type="hidden" size="10" value="<%=aDispQty %>" name="aDispQty<%=count %>"  id="aDispQty<%=count %>"  tabindex="1" />
							<input type="hidden" size="10" value="<%=mixtureQuantity %>" name="mixtureQuantity<%=count %>"  id="mixtureQuantity<%=count %>"  tabindex="1" /><!-- added by govind 04-01-2017 -->
					</td>
						</td>
							
							
							<td>
						<%
							if(sotckBatchList.size()>=0){
						%> <select name="stockId<%=count%>"
						 <%-- <%if(pob.getStopMedicine().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%> --%>						
						id="stockId<%=count%>">
							<option value="0">select</option>
							<%
								for(StoreItemBatchStock batchStock:sotckBatchList){
							%>
							<%
								if(batchStock.getItem().getId()==pob.getItem().getId()){
							%>
							<option value="<%=batchStock.getId()%>"><%=batchStock.getBatchNo()%></option>
							<%
								}
							%>
							<%
								}
							%>
					</select> <%
 	}else{
 %> <%
 	if(pob.getItem().getItemClass().getItemClassName().equalsIgnoreCase("INJECTION")){
 %>
						<input type="checkbox" name="stockId<%=count%>" name="stockId<%=count%>" />Outside
						Prescription <script type="text/javascript">document.getElementById("stockId<%=count%>").style.display='block'</script>
						<%
							}
						%> <%
 	}
 %>

					</td>
							
							
						<td scope="col"><input type="text" class="grdTextSmall" id="dosageId<%=count%>" name="dosageId<%=count%>"
							readonly="readonly"
							value="<%=pob.getDosage()!=null?pob.getDosage():""%>" /></td>
						<td scope="col"><input type="text" class="grdTextSmall" id="unitId<%=count%>" name="unitId<%=count%>"
							readonly="readonly"
							value="<%=pob.getItem().getItemConversion()!=null?pob.getItem().getItemConversion().getItemUnitName():""%>" /></td>
							
							<td scope="col"><input type="text" class="grdTextSmall" id="presQtyId<%=count%>" name="presQtyId<%=count%>"
							readonly="readonly"
							value="<%=pob.getTotal()!=null?pob.getTotal():""%>" /></td>
							
						<td scope="col"><input type="text" class="grdTextSmall" id="frequencyId<%=count%>" name="frequencyId<%=count%>"
							readonly="readonly"
							value="<%=pob.getFrequency()!=null?pob.getFrequency().getFrequencyName():""%>" /></td>
						<td scope="col"><input type="text" class="opdgridText" id="instructionId<%=count%>" name="instructionId<%=count%>"
							readonly="readonly"
							value="<%=pob.getInsrtuction()!=null?pob.getInsrtuction().getOpdInstructionTreatmentName():""%>" /></td>
						<td scope="col"><input type="text" class="opdgridText" id="splInstructionId<%=count%>" name="splInstructionId<%=count%>"
							readonly="readonly"
							value="<%=pob.getSplInstruction()!=null?pob.getSplInstruction():""%>" /></td>
						<td scope="col">
							<%
								if(pob.getNursingStatus()!=null && pob.getNursingStatus().equalsIgnoreCase("y")){
							%> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Done" /> <%
 	}else{
 %> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Not Done" /> <%
 	}
 %>
						</td>
						<td scope="col"><input type="text" class="grdTextSmall"
							style="width: 100px;" readonly="readonly"
							value="<%=pob.getNursingDate()!=null?pob.getNursingDate():""%>&nbsp;<%=pob.getNursingTime()!=null?pob.getNursingTime():""%>" /></td>
					</tr>
					<%
						count++;}
					%>
				</table>
				<input type="hidden" name="nurseprescription" id="nurseprescription"
					value="<%=count-1%>" />
			</div>
		</div>
		<%
			}
		%>

		<%
			if(procedureDetailsList!=null && procedureDetailsList.size()>0){
		%>
		<div class="clear"></div>
		<label>Procedure Details</label>
		<div class="paddingTop15"></div>
		<div class="clear"></div>

		<div class="tableForTab" style="width: 725px">
			<div id="divTemplet1">
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<th scope="col">Action</th>
						<th scope="col">Procedure Name</th>
						<th scope="col">Remark</th>
						<th scope="col">Status</th>
						<th scope="col">Done At</th>
					</tr>
					<%
						int count=1;
					%>
					<%
						for(ProcedureDetails pob:procedureDetailsList){
					%>
					<tr>
						<td scope="col">
							<%
								if(pob.getStatus().equalsIgnoreCase("y")){
							%> <input type="checkbox" class="radioCheck" disabled="disabled"
							value="<%=pob.getId()%>" name="procedureStatus<%=count%>"
							id="procedureStatus<%=count%>" /> <%
 	}else{
 %> <input type="checkbox" class="radioCheck" value="<%=pob.getId()%>"
							name="procedureStatus<%=count%>" id="procedureStatus<%=count%>" />
							<%
								}
							%>
						</td>
						<td><input type="hidden" value="<%=pob.getId()%>" /> <input
							type="text" class="nomeclatureOpdgridText"
							value="<%=pob.getProcedure().getNursingName()%>" /></td>
						<td><input type="text" class="opdgridText"
							value="<%=pob.getRemarks()!=null && !pob.getRemarks().equals("")?pob.getRemarks():""%>" /></td>
						<td>
							<%
								if(pob.getStatus()!=null && pob.getStatus().equalsIgnoreCase("y")){
							%> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Done" /> <%
 	}else{
 %> <input type="text" class="grdTextSmall" readonly="readonly"
							value="Not Done" /> <%
 	}
 %>
						</td>
						<td scope="col"><input type="text" class="grdTextSmall"
							style="width: 100px;" readonly="readonly"
							value="<%=pob.getProcedureDate()!=null?pob.getProcedureDate():""%>&nbsp;<%=pob.getProcedureTime()!=null?pob.getProcedureTime():""%>" /></td>
					</tr>
					<%
						count++;}
					%>
				</table>
				<input type="hidden" name="nurseprocedure" id="nurseprocedure"
					value="<%=count-1%>" />
			</div>
		</div>
		<%
			}
		%>


		<div class="clear"></div>
		<label>Vitals Details</label>
		<div class="clear"></div>

		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<div class="tableForTab">
			<div id="divTemplet1">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">Pulse</th>
						<th scope="col">Temperature</th>
						<th scope="col">Diastolic</th>
						<th scope="col">Systolic</th>
						<th scope="col">Time</th>
					</tr>
					<%
						int count=1 ;
					%>
					<%
						for(PatientObservation pob:obsList){
													String diastolic="",systolic="";
													if(pob.getBp()!=null && !pob.getBp().equals("") && !pob.getBp().equals("/")){
												diastolic=pob.getBp().split("/")[0];
												systolic=pob.getBp().split("/")[1];
													}	
													if(pob.getPulse()!=null && pob.getPulse()!=0 && pob.getTemperature()!=null && pob.getTemperature()!=0.0f)
													{
					%>
					<tr>
						<td><input type="checkbox" class="radioCheck" /></td>
						<td><input type="text" class="opdgridTextMedium"
							value="<%=pob.getPulse()!=null?pob.getPulse():""%>"
							readonly="readonly" /></td>
						<td><input type="text" class="opdgridTextMedium"
							value="<%=pob.getTemperature()!=null?pob.getTemperature():""%>"
							readonly="readonly" /></td>
						<td><input type="text" class="opdgridTextMedium"
							value="<%=diastolic%>" readonly="readonly" /></td>
						<td><input type="text" class="opdgridTextMedium"
							value="<%=systolic%>" readonly="readonly" /></td>
						<td><input type="text" class="opdgridTextMedium"
							value="<%=pob.getLastChgTime()!=null?pob.getLastChgTime():""%>"
							readonly="readonly" /></td>
					</tr>
					<%
						}
													count++;}
					%>
					<tr>
						<td><input type="checkbox" class="radioCheck" /></td>
						<td><input type="text"
							class="opdgridTextMedium allownumericwithdecimal" id="pulse"
							name="pulse" /> <input type="hidden" class="opdgridTextMedium"
							id="pulseHidden" name="pulseHidden" /></td>
						<td><input type="text"
							class="opdgridTextMedium allownumericwithdecimal"
							id="temperature" name="temperature" /> <input type="hidden"
							class="opdgridTextMedium " id="temperatureHidden"
							name="temperatureHidden" /></td>
						<td><input type="text"
							class="opdgridTextMedium allownumericwithdecimal" id="diastolic"
							name="diastolic" /> <input type="hidden"
							class="opdgridTextMedium" id="diastolicHidden"
							name="diastolicHidden" /></td>

						<td><input type="text"
							class="opdgridTextMedium allownumericwithdecimal" id="systolic"
							name="systolic" /> <input type="hidden"
							class="opdgridTextMedium" id="systolicHidden"
							name="systolicHidden" /></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="clear"></div>
		
		<script type="text/javascript">
		   var icdArray=new Array();
		   var icdArray1=new Array();
		   var brandArray=new Array();
		   var allergyTypeArray=new Array();
		   var saverityCodeArray=new Array();
</script>

		<label style="width:200px">Discharge Medicine Prescription</label>

		<div class="clear"></div>
		<div class="addDeleteButton">
			<input type="button" class="buttonDel" value=""
				onclick="removeGridRow();" /> <input type="button" class="buttonAdd"
				onclick="addMedicineRow();" value="" />
		</div>
		<div class="clear"></div>
		<div class="floatLeft">
			<label id="cantralabel" class="autoSize" style="display: none"><span
				id="cantraMsg"></span></label> <label id="cantralabelDisease"
				class="autoSize" style="display: none"><span
				id="cantraMsgDisease"></span></label>
		</div>
		<div class="clear"></div>
		<div class="">
						<div class="tableForTab" style="width:1130px; height:152px; overflow: scroll;">
							<!-- <div id="divTemplet1"> -->
								<table border="0" align="center" cellpadding="0" cellspacing="0" id="medicineGrid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage<span>*</span></th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<!-- <th scope="col">Days<span>*</span></th> -->
										<th scope="col">Duration<span>*</span></th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
										<th scope="col"></th>
									</tr>
									<%
	int incr = 0,len=3;
	 /*  if(patientPrescriptionDetails.size()>0){
		len=3;
	}else{
		len=3;
	}  */ 
	int inxRow=3;
	int inxCol=0;
	for(;incr< len;incr++,inxRow++){
		String nomeclature="";
		Integer ItemId=0;
		String pvmsNo="";
		int routeId=0;
		int frequencyId=0;
		int inctrunctionId=0;
		String unit="";
		String frequecnyType="";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		String issuedStatus="";
		String routeName="";
		String pAvailableStatus="";
		String conversion="";
		PatientPrescriptionDetails pd=null;
		/* if(patientPrescriptionDetails.size()>0){
			pd=patientPrescriptionDetails.get(incr);
			
			ItemId=pd.getItem().getId();
			if(pd.getIssuedStatus()!=null && !pd.getIssuedStatus().equals("")  && pd.getIssuedStatus().equalsIgnoreCase("y")){
				issuedStatus=pd.getIssuedStatus();
			}		
			if(pd.getNotAvailable()!=null){
				pAvailableStatus=pd.getNotAvailable();
			}
			nomeclature=pd.getItem().getNomenclature();
			pvmsNo=pd.getItem().getPvmsNo();
			dosage=pd.getDosage();
			unit=pd.getItem().getDispUnit()!=null?pd.getItem().getDispUnit():pd.getItem().getItemConversion().getItemUnitName();
			conversion=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			ndays=pd.getNoOfDays();
			frequecnyType=pd.getFrequency().getFrequencyType();
			if(pd.getRoute()!=null){
				routeId=pd.getRoute().getId();
				routeName=pd.getRoute().getRouteName();
			}
			if(pd.getFrequency()!=null){
				frequencyId=pd.getFrequency().getId();
			}
			if(pd.getInsrtuction()!=null){
				inctrunctionId=pd.getInsrtuction().getId();
			}
			if(ItemId!=0 &&  !pvmsNo.equals("")){
				nomeclature=nomeclature+"("+ItemId+")["+pvmsNo+"]";
			}
		} */
	%>
									<tr>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" class="radioCheck"
											id="itemRadio<%=incr %>" title="Prescription issued.."
											disabled="disabled" name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" />
											<%}else{%> <input
											type="checkbox" tabindex="<%=inxRow%><%=inxCol+1%>"
											class="radioCheck" id="itemRadio<%=incr %>"
											name="itemRadio<%=incr %>"
											onchange="checkPrescriptionCheck(<%=incr %>)" /> <%} %> <input
											type="hidden" name="prescription_availableStatus<%=incr %>"
											id="prescription_availableStatus<%=incr %>"
											value="<%= pAvailableStatus%>" />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											title="Prescription issued.."
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											class="textYellow largTextBoxOpd" value="<%=nomeclature%>"
											id="nomenclature<%=incr%>" size="35"
											name="nomenclature<%=incr%>"
											onblur="populatePVMS(this.value,'<%=incr%>');checkMedicineItem('<%=incr%>');checkForBlockedMedicine(this.value,'<%=incr%>'); displayAu(this.value,'<%=incr%>');validatePrescriptionAutocomplete('opPTab',this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											tabindex="<%=inxRow%><%=inxCol+2%>"
											class="textYellow largTextBoxOpd"
											onkeypress="checkTextColor('nomenclature<%=incr%>');"
											value="<%=nomeclature%>" id="nomenclature<%=incr%>" size="35"
											name="nomenclature<%=incr%>"
											<%-- onfocus="checkEnteredDiagnosis(); //Commented by Arbind on 31-01-2017--%>
											checkFrequency('<%=incr%>','opc');"
											onblur="
												 
												 populatePVMS(this.value,'<%=incr%>');
												 checkMedicineItem('<%=incr%>');
												  checkForBlockedMedicine(this.value,'<%=incr%>');
												 displayAu(this.value,'<%=incr%>');
												 validatePrescriptionAutocomplete('opmain',this.value,<%=incr %> )" />
											<%}%>
											<div id="ac2updates<%=incr%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>'});
					</script> <input type="hidden" name="pvmsNo<%=incr %>" id="pvmsNo<%=incr %>"
											size="10" readonly="readonly" /> <input type="hidden"
											name="actualDispensingQty<%=incr%>"
											id="actualDispensingQty<%=incr%>" size="6"
											validate="AU,string,no" />
										
										
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixable<%=incr%>"
											id="mixable<%=incr%>" 
											validate="mixable,string,no" />
											
										<!-- added by amit das on 19-11-2016 -->
										<input type="hidden"
											name="mixtureQuantity<%=incr%>"
											id="mixtureQuantity<%=incr%>" 
											validate="mixtureQuantity,int,no" />
											
										<input type="hidden"
											name="mixtureUnit<%=incr%>"
											id="mixtureUnit<%=incr%>" 	
											validate="mixtureUnit,string,no" />
<!-- 											validate="mixtureUnit,int,no" /> added by govind 05-01-2017-->
										<input type="hidden"
											name="actualTotalAfterMix<%=incr%>"
											id="actualTotalAfterMix<%=incr%>" 
											validate="actualTotalAfterMix,float,no" />
										<input type="hidden"
											name="tapered<%=incr%>"
											id="tapered<%=incr%>" 
											validate="tapered,string,no" />
										</td>
										<td>
								 <%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled" title="Prescription issued.."
											name="route<%=incr%>" id="route<%=incr%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
								
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select> <%}else{ %> <select name="route<%=incr%>"
											tabindex="<%=inxRow%><%=inxCol+3%>" id="route<%=incr%>"
											style="width: 90px; background: #FFFF99"
											onblur="fillRouteOnTAb('<%=incr%>');">
												<option value="0">Select</option>
												<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
							   	  
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
					          %>
												<%-- <%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ if(name.equalsIgnoreCase("oral")){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%} else{%>
												<option  value="<%=id %>"><%=name%></option>
													<%} %>
												
												<%}%> --%>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ 
												%>
												<option  value="<%=id %>"><%=name%></option>
												
												<%}%>
												<%}%>
										</select> <%}%> <script type="text/javascript">	var	routeArray= new Array();
		              <%
			    		RouteOfAdministration  route = new RouteOfAdministration();
					     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
		     			 %> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=route.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=route.getRouteName()%>";
	     				<% }%> 
            </script>
										</td>
										<td><input class="textYellow opdTextBoxTSmall"
											tabindex="<%=inxRow%><%=inxCol+4%>" type="text"
											name="dosage<%=incr%>" id="dosage<%=incr%>"
											value="<%=dosage!=null && dosage!=0?dosage:"" %>" size="10"
											maxlength="45" onblur="fillGridValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)" /></td>
										<td><input type="text"
											tabindex="<%=inxRow%><%=inxCol+5%>" name="unit<%=incr %>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											class="textYellow opdTextBoxTSmall" id="unit<%=incr %>"
											readonly="readonly" size="5"
											onblur="fillGridValue(this.value,<%=incr%>);" /></td>
										<td><input type="hidden" name="frequencyValue<%=incr%>"
											id="frequencyValue<%=incr%>" value="" size="6" /> <input
											type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
											style="display: none;" size="3"
											onblur="fillGridValue(this.value,<%=incr%>)" maxlength="3"
											validate="Sos Qty,num,no" /> 
									<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="frequency<%=incr%>" id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillGridValue(this.value,<%=incr%>);displayGridSOSQty(this.value,<%=incr%>);displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
												<option value="0">Select</option>
												<%
												  for(MasFrequency masFrequency2 : frequencyList){
											       int id = masFrequency2.getId();
											       String name = masFrequency2.getFrequencyName();
											       String type = masFrequency2.getFrequencyType();
									          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRow%><%=inxCol+6%>" name="frequency<%=incr%>"
											id="frequency<%=incr%>"
											onchange="getFrequencyValue(this.value,<%=incr%>);fillGridValue(this.value,<%=incr%>);displayGridSOSQty(this.value,<%=incr%>);displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)">
												<option value="0">Select</option>
												<%
													 
												      for(MasFrequency masFrequency2 : frequencyList){
												       int id = masFrequency2.getId();
												       String name = masFrequency2.getFrequencyName();
												       String type = masFrequency2.getFrequencyType();
										          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <% }%> 
										
										<%	MasFrequency  masFrequency3 = null;
										        for (int i = 0; i < frequencyList.size(); i++) {
										      	 masFrequency3 = (MasFrequency) frequencyList.get(i);
							     		 %> <script>
								          icdArray[<%=i%>]= new Array();
								          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
								          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
								          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
							            </script> <% }%>
	          					  </td>
										<td>
											<div style="width:100px; float: left;">
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="noOfDays<%=incr%>" id="noOfDays<%=incr%>"
											value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillGridValue(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<%}else{ %> <input type="text"
											tabindex="<%=inxRow%><%=inxCol+7%>" name="noOfDays<%=incr%>"
											id="noOfDays<%=incr%>" value="<%=ndays!=0 ?ndays:"" %>"
											class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueDays(<%=incr%>);fillGridValue(this.value,<%=incr%>);" />
											<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
											<% }%>
                                         </div>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<select disabled="disabled"
											style="width: 90px; background: #FFFF99"
											name="instrunction<%=incr%>" id="instrunction<%=incr%>"
											>
												<option value="0">Select</option>
												<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
					}
					%>
										</select> <%}else{ %> <select style="width: 90px; background: #FFFF99"
											tabindex="<%=inxRow%><%=inxCol+8%>"
											name="instrunction<%=incr%>" id="instrunction<%=incr%>"
											>
												<option value="0">Select</option>
												<%
							for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
							{
				
						       int id = instructionTreatment.getId();
						       String name = instructionTreatment.getOpdInstructionTreatmentName();
				
				          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
							}
							%>
										</select> <% }%> <script type="text/javascript">	var	instructionArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script>
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunction<%=incr %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" /> <%}else{ %>
											<input type="text" tabindex="<%=inxRow%><%=inxCol+9%>"
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunction<%=incr %>" maxlength="200"
											onblur="fillSPLInstrunctionOnPTAb(<%=incr %>);" /> <% }%>
										</td>
										<td>
											<input type="text" name="total<%=incr %>" id="total<%=incr %>"	value="<%=total!=null && total!=0?total:"" %>" size="5"
											class="textYellow opdTextBoxTSmall" validate="Total,num,no"	readonly="readonly" />
										</td>
										
										<td>
											<input type="text" id="unitLable<%=incr%>" value="<%=!conversion.equals("")?conversion:"" %>" 	class="textYellow opdTextBoxTSmall" readonly="readonly" />
										</td>
										
									</tr>
									<%} %>
					
<tbody id="divTemplet1"></tbody>	
								</table>
								<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
								<input type="hidden" 	id="PharmacyqueueId"  />
								<input type="hidden" name="hdbRecordSize"
									value="<%= patientPrescriptionDetails.size()-1 %>"
									id="hdbRecordSize" /> <input type="hidden" name="hdbTabIndex"
									id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" />
								
							</div>
						<!-- </div> -->
					</div>

<div class="floatLeft" style=" margin: 5px 0px;">
<label class="auto"><img src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />
<span>Stock not available for medicine</span></label>
</div>
		<div class="clear"></div>
		<input type="button" class="buttonAuto" value="Submit"
			onclick="validateBatchNo();submitPatientObservation()"/> 
			<input type="button"
			class="buttonAuto" value="Discharge" onclick="discharge()" /> <input
			type="button" class="buttonAuto" value="Admit to IP" id="admitToIp" />
		<input type="button" class="buttonAuto" value="Refer Back"
			onclick="referToOpd();" />
		<%
			}
		%>
<div style="display: none;" >
						<table id="taperedMedicne1">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
	<input type="hidden" id="taperedMedicineHdb1" name="taperedMedicineHdb" value="0"/>
</div>
	</form>
	<form action="" name="taperedForm" style="display: none;" >
							<!-- added by govind for tapered Medicine -->
						<div>
						<table id="taperedMedicne">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						</div>
						<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb" value="0"/>
						<!-- added by govind for tapered Medicine -->
	</form>
</div>


<div class="Block" id="observationDialog" title="Transfer To IP"
	style="display: none;">
	<form name="admittoip" method="post">
		<label class="auto">Admission Date</label> <input type="text"
			name="admissionDate" id="admissionDate"
			style="text-align: left; width: 90px" class="dateTextSmall"
			value="<%=currentDate%>" readonly="readonly" onblur="checkAdmte()" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate%>',document.admittoip.admissionDate,event);" />
		<div class="clear"></div>
		<label class="autoSpace">Payward <input type="checkbox"
			name="payward" id="payward" class="radioCheckCol2" value="Y" />
		</label>
		<div class="clear"></div>
		<div class="paddingTop15">
			<label class="auto">Ward</label> <select name="admissionWard"
				id="admissionWard" onchange="getBedStatus(this.value);">
				<option value="0">Select</option>
				<%
					for(MasDepartment ward:wardDepartmentList){
				%>
				<option value="<%=ward.getId()%>"><%=ward.getDepartmentName()%></option>
				<%
					}
				%>
			</select>
			<div id="bedDiv"></div>
		</div>
		<input type="button" class="buttonAuto" value="Admit" id="admit"
			name="admin" />
	</form>
</div>

<!-- By Srikanth Start-->
<div id="myModal" class="modal">

  <div class="modal-content" id="blockMedicineDiv">
    <span class="close" onclick="closePopUp();">&times;</span>
    <p id="blockMedicineMsg" style="color:red;font-weight: bold;"></p>
    <input type="hidden" id="blockMedicineTableId" name="blockMedicineTableId"  />
    <input type="hidden" id="incrementNum" />
    
    <input type="button"  value="UnBlock" onclick="unBlockMedicine();"  />
    <input type="button"  value="Cancel" onclick="closePopUp();"  />
  </div>

</div>

<!-- By Srikanth End-->





<script type="text/javascript">
	jQuery(function($) {
		$("#admitToIp").click(function() {
			$("#observationDialog").dialog({
				width : 380,
				height : 232,
				modal : true
			});
			/* var hinId=document.getElementById("hinId").value;;
			new Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue, {
				  onSuccess: function(response) {
				      if(response.responseText.trim()!='No vital Details')
			    	  {		
				  		  $("#vitalUHID").val(document.getElementById("hinNo").value);
				    	  $("#vitalPname").val(document.getElementById("patientName").value); 
				    	  $("#vitalTable").html(response.responseText.trim()); 
				    	  $("#vitalDialog").dialog({width:842,height:332,modal: true});
			    	  }else{
			    		  alert("No vital details");
			    	  }
				  }
			  }); */
		});

		$(".allownumericwithdecimal")
				.on(
						"keypress keyup blur",
						function(event) {
							//this.value = this.value.replace(/[^0-9\.]/g,'');
							$(this).val($(this).val().replace(/[^0-9\.]/g, ''));
							if ((event.keyCode != 46)
									&& ((event.keyCode != 37))
									&& ((event.keyCode != 39))
									&& (event.keyCode != 8)
									&& (event.keyCode != 9)
									&& (event.which != 46 || $(this).val()
											.indexOf('.') != -1)
									&& ((event.which < 48) || (event.which > 57))) {
								event.preventDefault();
							}
						});

		$("#admit")
				.click(
						function() {
							var visitId = document.getElementById('visitId').value;
							$
									.ajax({
										url : 'opd?method=patientDischargeAndAdmit&visitId=' + visitId + '&'
												+ csrfTokenName
												+ '='
												+ csrfTokenValue,
										type : 'POST',
										data : {
											IpAdStatus : 1,
											opdId : $("#opdId").val(),
											admissionWard : $("#admissionWard")
													.val(),
											paywardFlag : $("#payward").is(
													':checked') ? 'y' : 'n'
										},
										success : function(response) {
											alert("Patient transfer to IP");
											$("#observationDialog").dialog(
													"close");
											window.location
													.replace("/hms/hms/opd?method=getObservationDashboard");
										},
										error : function() {
											alert("server side error");
										}
									});
						})

	});

	function checkPayWard() {
		var flag;
		if (document.getElementById("payward").checked) {
			flag = "y";
		} else {
			flag = "n";
		}
		new Ajax.Request(
				'opd?method=getPayward&flag=' + flag + '&' + csrfTokenName
						+ '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							document.getElementById('admissionWard').innerHTML = response.responseText
									.trim();
						}
					}
				});
	}
	function checkAdmte() {
		var dob = document.getElementById('admissionDate').value;
		adDate = new Date(dob.substring(6), (dob.substring(3, 5) - 1), dob
				.substring(0, 2));
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		if (adDate < currentDate) {
			alert("Admission Date is not valid.");
			document.getElementById('admissionDate').value = document
					.getElementById("consultationDate").value;
			document.getElementById('admissionDate').focus();
			return false;
		}
		return true;

	}
	function getBedStatus(val) {
		submitProtoAjaxNew('observationWard', 'opd?method=getBedStatus&deptId='
				+ val + "&csrfTokenName+'='" + csrfTokenValue, 'bedDiv');
	}
	function submitPatientObservation() {
		var pulse = document.getElementById("pulse").value;
		document.getElementById("pulseHidden").value = pulse;
		var temperature = document.getElementById("temperature").value;
		document.getElementById("temperatureHidden").value = temperature;
		var diastolic = document.getElementById("diastolic").value;
		document.getElementById("diastolicHidden").value = diastolic;
		var systolic = document.getElementById("systolic").value;
		document.getElementById("systolicHidden").value = systolic;
		if (confirm("Do you want to submit ?")) {
			var flag = submitForm('observationWard',
					'/hms/hms/opd?method=submitObservationWard&obStatus=1');
		}
	}
	
	
	function discharge() {
		if (confirm("Do you want to discharge patient ?")) {
			var flag = submitForm('observationWard',
					'/hms/hms/opd?method=patientDischargeAndAdmit&obStatus=1');
		}
	}
	function referToOpd() {
		if (confirm("Do you want to Refer back patient to Opd  ?")) {
			var flag = submitForm('observationWard',
					'/hms/hms/opd?method=submitObservationWard&obStatus=2');
		}
	}
	
	function addMedicineRow() {
		var tbl = document.getElementById('medicineGrid');
		var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value) + 1;
		document.getElementById('hdbTabIndex').value = hdbTabIndex;

		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hdb');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;
		// document.getElementById('pulse').value=hdb.value;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name = 'itemRadio' + iteration;
		e1.id = 'itemRadio' + iteration;
		e1.className = 'radioCheck';
		e1.onchange = function() {
			checkPrescriptionCheck(iteration);
		};
		e1.tabIndex = hdbTabIndex + "1";
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'prescription_availableStatus' + iteration;
		e1.id = 'prescription_availableStatus' + iteration;
		e1.className = "textYellow grdTextSmall";
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'nomenclature' + iteration;
		e1.id = 'nomenclature' + iteration;
		e1.className = "textYellow largTextBoxOpd";
		e1.onfocus = function() {
			//Commented by Arbind on 31-01-2017
			//checkEnteredDiagnosis(); 
			checkFrequency(iteration, "opc");
		}
		e1.onkeypress = function() {
			checkTextColor('nomenclature' + iteration);
		};
		 e1.onblur = function() {
			//checkForAlreadyIssuedPrescribtion(this.value, iteration);
			populatePVMS(this.value, iteration);
			checkMedicineItem(iteration);
			//copyToPrescriptionTAb(iteration, 'opconsult');
			//ValidateCantra();
			checkForBlockedMedicine(this.value, iteration);
			displayAu(this.value, iteration);
			validatePrescriptionAutocomplete('opmain', this.value, iteration);
			//checkForAllergy(this.value, iteration);
			
		};
		e1.size = '35';
		e1.tabIndex = hdbTabIndex + "2";
		cellRight1.appendChild(e1);
		e1.focus();

		var newdiv = document.createElement('div');
		newdiv.setAttribute('id', 'ac2updates' + iteration);
		newdiv.style.display = 'none';
		newdiv.className = "autocomplete";
		cellRight1.appendChild(newdiv);
		new Ajax.Autocompleter('nomenclature' + iteration,
				'ac2updates' + iteration,
				'opd?method=getItemListForAutoCompleteItem', {
					minChars : 3,
					parameters : 'requiredField=nomenclature' + iteration
				});

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'brandId' + iteration;
		e1.id = 'brandId' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'manufactureId' + iteration;
		e1.id = 'manufactureId' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'pvmsNo' + iteration;
		e1.id = 'pvmsNo' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'actualDispensingQty' + iteration;
		e1.id = 'actualDispensingQty' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'mixable' + iteration;
		e1.id = 'mixable' + iteration;
		cellRight1.appendChild(e1);
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'mixtureQuantity' + iteration;
		e1.id = 'mixtureQuantity' + iteration;
		cellRight1.appendChild(e1);
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'mixtureUnit' + iteration;
		e1.id = 'mixtureUnit' + iteration;
		cellRight1.appendChild(e1);
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'actualTotalAfterMix' + iteration;
		e1.id = 'actualTotalAfterMix' + iteration;
		cellRight1.appendChild(e1);
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'tapered' + iteration;
		e1.id = 'tapered' + iteration;
		cellRight1.appendChild(e1);
		/*
		 * var cellRight1 = row.insertCell(2); var e1 =
		 * document.createElement('input'); e1.name='route'+iteration;
		 * e1.id='route'+iteration; e1.className="textYellow opdgridText";
		 * e1.onblur=function() { fillRouteOnTAb(iteration);};
		 * cellRight1.appendChild(e1);
		 * 
		 * var e1 = document.createElement('input'); e1.type = 'hidden';
		 * e1.name='routeHidden'+iteration; e1.id='routeHidden'+iteration;
		 * e1.className="textYellow opdgridText"; cellRight1.appendChild(e1);
		 * 
		 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
		 * 'ac2updatesRoute'+iteration); newdiv.style.display = 'none';
		 * newdiv.className = "autocomplete"; cellRight1.appendChild(newdiv); new
		 * Ajax.Autocompleter('route'+iteration,'ac2updatesRoute'+iteration,'opd?method=getRouteAutoList',{minChars:1,parameters:'requiredField=route'+iteration,afterUpdateElement :
		 * changeTest});
		 */
		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.name = 'route' + iteration;
		e1.id = 'route' + iteration;
		e1.style.width = "90px";
		e1.style.background = "#FFFF99";
		e1.tabIndex = hdbTabIndex + "3";
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < routeArray.length; i++) {
			e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
		}
		e1.onblur = function() {
			fillRouteOnTAb(iteration);
		};
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.name = 'dosage' + iteration;
		e1.id = 'dosage' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.onblur = function() {
			fillGridValue(this.value, iteration);checkFrequencyForTaperedDrugs(iteration);
		};
		e1.tabIndex = hdbTabIndex + "4";
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'unit' + iteration;
		e1.id = 'unit' + iteration;
		e1.className = 'textYellow opdTextBoxTSmall';
		e1.readOnly = 'readOnly';
		e1.tabIndex = hdbTabIndex + "5";
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(5);
		var e1 = document.createElement('Select');
		e1.name = 'frequency' + iteration;
		e1.id = 'frequency' + iteration;
		e1.style.width = "90px";
		e1.style.background = "#FFFF99";
		e1.tabIndex = hdbTabIndex + "6";
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < icdArray.length; i++) {
			// this part is added by amit das 
			 var opt = document.createElement('option'); 
			 	opt.id = icdArray[i][2];
			 	opt.value = icdArray[i][0];
			    opt.innerHTML = icdArray[i][1];
			    e1.appendChild(opt);
			 //e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); // this part is commented by amit das
		}
		e1.onblur = function() {
			getFrequencyValue(this.value, iteration);
			fillGridValue(this.value, iteration);
			displayGridSOSQty(this.value, iteration);	
			checkFrequencyForTaperedDrugs(iteration);
		};
		
		e1.onchange = function() { // added by amit das
			displaFrequencyType(this, iteration);	
		};
		
		cellRight1.appendChild(e1);
		
		var e21 = document.createElement('input');
		e21.type = 'hidden';
		e21.name = 'sosQty' + iteration;
		e21.id = 'sosQty' + iteration;
		e21.size = '5';
		e21.setAttribute('tabindex', '1');
		cellRight1.appendChild(e21);

		var e21 = document.createElement('input');
		e21.type = 'hidden';
		e21.name = 'frequencyValue' + iteration;
		e21.id = 'frequencyValue' + iteration;
		e21.size = '5';
		e21.setAttribute('tabindex', '1');
		cellRight1.appendChild(e21);

		var cellRight1 = row.insertCell(6);
		
		var e21Div = document.createElement('div');
		e21Div.style = 'width:100px; float: left;';
		
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'noOfDays' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.id = 'noOfDays' + iteration;
		e1.size = '3';
		e1.tabIndex = hdbTabIndex + "7";
		e1.onblur = function() {
			fillValueDays(iteration);
			fillGridValue(this.value, iteration);
		};
		e21Div.appendChild(e1);
		
		var ef21 = document.createElement('p');
		ef21.style = 'line-height:0px;';
		ef21.id = 'frequencyType' + iteration;
		e21Div.appendChild(ef21);
		cellRight1.appendChild(e21Div);

		var cellRight1 = row.insertCell(7);
		var e1 = document.createElement('Select');
		e1.name = 'instrunction' + iteration;
		e1.id = 'instrunction' + iteration;
		e1.style.width = "90px";
		e1.style.background = "#FFFF99";
		e1.tabIndex = hdbTabIndex + "8";
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < instructionArray.length; i++) {
			e1.options[i + 1] = new Option(instructionArray[i][1],
					instructionArray[i][0]);
		}
		e1.onblur = function() {
			fillInstrunctionOnTAb(iteration);
		};
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(8);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'splInstrunction' + iteration;
		e1.id = 'splInstrunction' + iteration;
		e1.tabIndex = hdbTabIndex + "9";
		e1.className = "textYellow opdTextBoxSmall";
		e1.onblur = function() {
			fillSPLInstrunctionOnPTAb(iteration);
		};
		e1.size = '5';
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(9);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'total' + iteration;
		e1.id = 'total' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.readOnly = 'readOnly';
		e1.size = '5';
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(10);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'unitLable' + iteration;
		e1.id = 'unitLable' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.readOnly = 'readOnly';
		e1.size = '5';
		cellRight1.appendChild(e1);
		
	}
	
	 
	function removeGridRow() {
		var tbl = document.getElementById('medicineGrid');
		var lastRow = tbl.rows.length;
		var hdb = document.getElementById('hdb');
		var iteration = parseInt(hdb.value);
		var totalSelected = 0;
		if (confirm("Do you want to delete !")) {
			for (var i = 0; i <= iteration; i++) {

				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					totalSelected = totalSelected + 1;
				}
			}

			if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
			}
			/*
			 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
			 * not delete all Row.'); } else if (lastRow > 2){
			 */
			for (var i = 0; i <= iteration; i++) {
				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					// added by govind on 15-9-2016
				/*	if (document.getElementById("treatTemplteId" + i) != null) {
						var tempId = document
								.getElementById('tempLatePrescription').value;
						var tempTreatId = document.getElementById("treatTemplteId"
								+ i).value;
						added by govind on 4-10-2016
						submitProtoAjaxNew('opdMain',
							'opd?method=deletePrescriptionTamplate&templTreateId='
										+ tempTreatId + '&templateId=' + tempId,
								'divTemplet1'); // added by govind on 4-10-2016 end
						fnGetPrescriptionTemplate(tempId);
						document.getElementById('tempLatePrescription').value = 0;
					}*/
					// added by govind on 15-9-2016
					var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
					document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}
			// }
			//removeRowPrescriptionTab('opc');
		}
		//setDisablePharmacy();
	}
	
	
	
	
</script>
<script>

function checkMedicineItem(cnt) {
	var tbl = document.getElementById('medicineGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId = document.getElementById("visitId").value
	var nomenclature = document.getElementById("nomenclature" + cnt).value
	var index1 = nomenclature.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = nomenclature.lastIndexOf("]");
	index1++;

	var pvmsNo = nomenclature.substring(index1, index2);
	var prescriptionName = nomenclature.substring(0, (index1 - 1));
	if (pvmsNo != "") {

		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				jQuery(function($) {
					var items = xmlHttp.responseXML
							.getElementsByTagName('items')[0];
					var items = xmlHttp.responseXML
							.getElementsByTagName('items')[0];
					for (loop = 0; loop < items.childNodes.length; loop++) {
						var item = items.childNodes[loop];
						var stockStstus = item.getElementsByTagName("stock")[0];
						if (stockStstus.childNodes[0].nodeValue == '0') {
							$("#nomenclature" + cnt).css({
								'color' : 'red',
								'font-size' : '125%'
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'red',
								'font-size' : '125%'
							});
							$("#prescription_availableStatus" + cnt).val('y');
							$("#prescription_availableStatuspTab" + cnt).val(
									'y');
						} else {
							$("#nomenclature" + cnt).css({
								'color' : 'black',
								'font-size' : '125%'
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'black',
								'font-size' : '125%'
							});
							$("#prescription_availableStatuspTab" + cnt).val(
									'n');
							$("#prescription_availableStatus" + cnt).val('n');
						}
					}
				});
			}
		}
		var url = "/hms/hms/opd?method=checkItem&pvmsNo=" + pvmsNo
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;

		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function getFrequencyValue(feqValue,inc){
	var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFrequencyCount()%>'
	  }

	<%}
	}%>
	if(document.getElementById('frequencyValue' + inc)!=null){
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	}
	 if(document.getElementById('frequencyValuepTab' + inc)!=null){
	 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
	 }
}

function fillGridValue(value, inc, from) {
	var dosage;
	var freq;
	var dispenseQty;
	var noOfDays;
	var sosQty;
	// added by amit das on 19-11-2016
	var unit;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;
	
	//added by govind 24-01-2017
	//setDisablePharmacy();
	//added by govind 24-01-2017 end
	if (from != 'tab') {
		dosage = document.getElementById('dosage' + inc).value;
		freq = document.getElementById('frequencyValue' + inc).value;
		dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
		noOfDays = document.getElementById('noOfDays' + inc).value;
		sosQty = document.getElementById('sosQty' + inc).value;

		// added by amit das on 19-11-2016
		unit = document.getElementById('unit' + inc).value;
		/*mixable = document.getElementById('mixable' + inc).value;//commented by govind 23-12-2016
		mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
		mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;*/
		if(document.getElementById('mixable' + inc)!=null){
			mixable = document.getElementById('mixable' + inc).value;
			}
			if(document.getElementById('mixtureUnit' + inc)!=null){
			mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
			}
			if(document.getElementById('mixtureQuantity' + inc)!=null){
			mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
			}
			//commented by govind 23-12-2016 end 
		
		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total =  Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}
		
		
		var finalQty = "";
		var actualFinalQty = "";
		if (document.getElementById('frequency' + inc).value != 13) {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				
				// condition added by amit das on 19-11-2016 
				if(mixable=='Y'){
					// var solutionMixAmount =  parseFloat(mixtureQuantity) + parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(total);
					if(actualFinalQty != '0.00'){
						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					//document.getElementById('totalpTab' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;
					
				} else {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
				//document.getElementById('totalpTab' + inc).value = finalQty;
			   }
			} else {
				
				document.getElementById('total' + inc).value = total;
				//document.getElementById('totalpTab' + inc).value = total;
			
			}
		} else {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				
				// condition added by amit das on 19-11-2016 
				if(diluteable=='Y'){
					// var solutionMixAmount =  parseFloat(mixtureQuantity) + parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(total);
					if(actualFinalQty != '0.00'){
						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					//document.getElementById('totalpTab' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;
					
				} else {
				
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
				//document.getElementById('totalpTab' + inc).value = finalQty;
				}
			} else {
				
				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
				/* document.getElementById('totalpTab' + inc).value = sosQty
						* freq * dosage; */
			}
		}

		//document.getElementById('dosagepTab' + inc).value = dosage;
		//document.getElementById('noOfDayspTab' + inc).value = noOfDays; 
		//document.getElementById('frequencyValuepTab' + inc).value = freq;
		//document.getElementById('actualDispensingQtypTab' + inc).value = dispenseQty;
		//document.getElementById('sosQtypTab' + inc).value = sosQty;
		/* document.getElementById('frequencypTab' + inc).value = document
				.getElementById('frequency' + inc).value; */
		/* document.getElementById('frequencyValuepTab' + inc).text = document
				.getElementById('frequencyValue' + inc).text; */
		
		
	} else {
		//dosage = document.getElementById('dosagepTab' + inc).value
		//noOfDays = document.getElementById('noOfDayspTab' + inc).value
		freq = document.getElementById('frequencyValuepTab' + inc).value
		/* document.getElementById('totalpTab' + inc).value = noOfDays * freq
				* dosage */
		dispenseQty = document.getElementById('actualDispensingQtypTab' + inc).value;
		sosQty = document.getElementById('sosQtypTab' + inc).value;
		unit = document.getElementById('unit' + inc).value;
		
		
		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total =  Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}
	
		
		var finalQty = "";
		if (document.getElementById('frequencypTab' + inc).value != 13) {
			if (document.getElementById('actualDispensingQtypTab' + inc).value != 0) {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				//document.getElementById('totalpTab' + inc).value = finalQty;
				document.getElementById('total' + inc).value = finalQty;
			} else {
				//document.getElementById('totalpTab' + inc).value = total;
				document.getElementById('total' + inc).value = total;
			}
		} else {
			
			if (document.getElementById('actualDispensingQtypTab' + inc).value != 0) {
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				//document.getElementById('totalpTab' + inc).value = finalQty;
				document.getElementById('total' + inc).value = finalQty;
			} else {
				/* document.getElementById('totalpTab' + inc).value = sosQty
						* freq * dosage; */
				document.getElementById('total' + inc).value = sosQty
				* freq * dosage;
			}
		}
		
		document.getElementById('dosage' + inc).value = dosage;
		document.getElementById('noOfDays' + inc).value = noOfDays;
		document.getElementById('frequencyValue' + inc).value = freq;
		document.getElementById('actualDispensingQty' + inc).value = dispenseQty;
		document.getElementById('sosQty' + inc).value = sosQty;
		document.getElementById('frequency' + inc).value = document
				.getElementById('frequencypTab' + inc).value;
		document.getElementById('frequencyValue' + inc).text = document
				.getElementById('frequencyValuepTab' + inc).text;
	}
}

function displayGridSOSQty(val, inc) {
	if (val == '13') {
		document.getElementById('sosQty' + inc).style.display = 'block';
		document.getElementById('noOfDays' + inc).disabled = true;
	} else {

		document.getElementById('sosQty' + inc).style.display = 'none';
		document.getElementById('noOfDays' + inc).disabled = false;
	}
}

function validateBatchNo(){
	var rowsCount=0;
	if(document.getElementById("nurseprescription")!=null){
	rowsCount=document.getElementById("nurseprescription").value;
	}
	var rowCounts = parseInt(rowsCount);
	for (i = 1; i <= rowCounts ; i++) { 
		
		if(document.getElementById("medicGrid").getElementsByTagName('tr')[i].getElementsByTagName('td')[0].getElementsByTagName('input')[0].checked){
			
			if(document.getElementById("stockId"+i).value="0"){
				alert("Batch No can not be Blank.");
				return false;
			}
			
		}
	}
	return true;
	
}

 function referToOpd()
 {
	if(confirm("Do you want to Refer back patient to Opd  ?")){
		var flag=submitForm('observationWard','/hms/hms/opd?method=submitObservationWard&obStatus=2');	
	}
}
 
 function checkForBlockedMedicine(val, inc) {
		// alert(val+"<<<-------val======inc------>>"+inc);
		var visitId = document.getElementById("visitId").value;
		var id;
		if (val != "") {

			var xmlHttp;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					alert(e)
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("Your browser does not support AJAX!");
						return false;
					}
				}
			}

			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
					
					var responseJson = JSON.parse(this.responseText);
					
					if(responseJson.matched==true){
						var message="";
						if(responseJson.blockedDays!=null && responseJson.blockedDays!="" && responseJson.blockedDays!=0){
							message="This Medicine is Blocked By "+responseJson.blockedDoctor+" For "+responseJson.blockedDays+" Days. Do You Want to UnBlock It?";
						}else{
							message="This Medicine is Blocked By "+responseJson.blockedDoctor+" Do You Want to UnBlock It?";
						}
						document.getElementById("blockMedicineMsg").innerHTML=message;
						
						document.getElementById("blockMedicineMsg").value=responseJson.allergyTid;
						document.getElementById("incrementNum").value=inc;
						 
						var modal = document.getElementById('myModal');
						modal.style.display = "block";	
					}else{
						//checkForAllergy(val, inc);
					}
					
				}
			}
			var url = "/hms/hms/opd?method=checkForBlockedMedicine&val=" + val
					+ "&visitId=" + visitId + "&" + csrfTokenName + "="
					+ csrfTokenValue;
			xmlHttp.open("GET", url, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
		}
	}
 function closePopUp(){
		var incr=document.getElementById("incrementNum").value;
		var val=document.getElementById("nomenclature"+incr).value;
		document.getElementById("nomenclature"+incr).value="";
		var modal = document.getElementById('myModal');
		modal.style.display = "none";
		
		//checkForAllergy(val, incr);
		
	}
 function unBlockMedicine(){
		var medicineTableId=document.getElementById("blockMedicineMsg").value;
		if (medicineTableId != "") {
			var xmlHttp;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					alert(e)
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("Your browser does not support AJAX!");
						return false;
					}
				}
			}

			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
					var modal = document.getElementById('myModal');
					modal.style.display = "none";

				}
			}
			var url = "/hms/hms/opd?method=unBlockMedicine&medicineTableId=" + medicineTableId;
			xmlHttp.open("GET", url, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
		}
		
	}
</script>
