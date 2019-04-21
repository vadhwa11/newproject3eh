<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="java.util.List"%>
<% 
	int deptId = 0;
	int hospitalId = 0;
	String patientIssueNo="";
	boolean lastPrescripitionBasedDispensing=false;
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PatientPrescriptionHeader> prescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
	PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
	Set<PatientPrescriptionDetails> prescriptionDetailsSet = new HashSet<PatientPrescriptionDetails>();
	 if(session.getAttribute(RequestConstants.DEPT_ID)!=null){
		 deptId=Integer.parseInt(session.getAttribute(RequestConstants.DEPT_ID).toString()) ;
	 }
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	} 
	if("success".equalsIgnoreCase(map.get("message").toString())){ 
	if(map.get("patientPrescriptionHeaderList") != null){
		prescriptionHeaderList = (List<PatientPrescriptionHeader>)map.get("patientPrescriptionHeaderList");
		prescriptionHeader=prescriptionHeaderList.get(0);
	}  
	Visit visit = new Visit();
	if(prescriptionHeader != null) {
		visit = prescriptionHeader.getVisit();
	}
	if(prescriptionHeader!=null){
		prescriptionDetailsSet=prescriptionHeader.getPatientPrescriptionDetails();
	} 
	int visitId=0;
	String regNo="";
	String ptName="";
	String lastName="";
	String age="";
	String sex="";
	String diagnosis="";
	String department="";
	String patType="";
	String doctorName="";
	if(visit.getDoctor()!=null && visit.getDoctor().getEmployeeName()!=null){
		 doctorName=visit.getDoctor().getEmployeeName();
	} 
	regNo=visit.getHin().getHinNo();
	visitId=visit.getId();
	if(visit.getHin().getPatientType()!=null){
		 patType=visit.getHin().getPatientType().getPatientTypeName();
	}
	
	
	if(visit.getHin().getPLastName()!=null){
		lastName=visit.getHin().getPLastName();
	}
	ptName=visit.getHin().getPFirstName()+" "+lastName;
	if(visit.getHin().getAge()!=null){
		age=visit.getHin().getAge();	
	}
	
	if(visit.getHin().getSex()!=null){
	sex=visit.getHin().getSex().getAdministrativeSexName();
	}
	if(visit.getDiagnosis()!=null){
		diagnosis=visit.getDiagnosis().getDiagnosisConclusionName();
	}else{
		diagnosis="-";
	}
	if(visit.getDepartment()!=null){
		department=visit.getDepartment().getDepartmentName();
	} 
	%>
<div id="divTemplet">
	<table border="0" align="center" cellpadding="0" cellspacing="0"
		id="grid">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Item Name</th>
			<th scope="col">Batch No.</th>
			<th scope="col">Stock Qty.</th>
			<th scope="col">Doages</th>
			<th scope="col">Unit</th>
			<th scope="col">Frequency</th>
			<th scope="col">No of Days</th>
			<th scope="col">Instruction</th>
			<th scope="col">Route</th>
			<th scope="col">Issue Qty.</th>
			<th scope="col">Remark</th>

		</tr>
		<%
		 	int incr = 1;
 			for(PatientPrescriptionDetails prescriptionDetails:prescriptionDetailsSet){
						 if(prescriptionDetails.getItem().getOtcType()==null || "n".equalsIgnoreCase(prescriptionDetails.getItem().getOtcType())){
							continue;
						}  
		%>
		 
		<tr>
			<td><input type="checkbox" class="radioCheck" id="itemRadio1"
				name="itemRadio1" />
				<input type="hidden" id="prescriptionDetailId<%=incr%>"
				name="prescriptionDetailId<%=incr%>" value="<%=prescriptionDetails.getId()%>"></input>
			</td>
			<td><input type="text"  tabindex="1" id="nomenclature<%=incr%>"
				size="35" name="nomenclature<%=incr%>" value="<%=prescriptionDetails.getItem().getNomenclature()%>"/> 
			</td>
					<%
					for(StoreItemBatchStock batchStock:prescriptionDetails.getItem().getStoreItemBatchStocks()){
						if(batchStock.getDepartment().getId()==deptId){%>  
						
					<%}}%>
			<td><select name="itemBatchNo<%=incr%>"
				id="itemBatchNoId<%=incr%>"
				onchange="getItemStockValue(this.value,<%=incr%>);">
					<option value="-1">Select</option>
					<%
					for(StoreItemBatchStock batchStock:prescriptionDetails.getItem().getStoreItemBatchStocks()){
						if(batchStock.getDepartment().getId()==deptId){  
						%>
						<option value="<%=batchStock.getBatchNo()+"-"+batchStock.getId()+"-"+batchStock.getClosingStock()%>"><%=batchStock.getBatchNo()%></option> 
						
					<%}}%> 
				</select></td> 
			<td><input type="hidden" id="drugItemId<%=incr%>"
				name="drugItemId<%=incr%>" value="<%=prescriptionDetails.getItem().getId()%>"></input><input type="hidden"
				id="stockItemBatchStockId<%=incr%>"
				name="stockItemBatchStockId<%=incr%>"></input> <input type="text"
				readonly="readonly" class="small" size="10" maxlength="45"
				tabindex="1" id="stockQtyId<%=incr%>" name="stockQty<%=incr%>"></input>
			</td> 
			<td><input class="small" type="text" name="dosage<%=incr%>" readonly="readonly"
				id="dosage<%=incr%>" tabindex="1" size="5" value="<%=prescriptionDetails.getDosage()%>"/>
			</td>
			<td><input type="text" name="unit<%=incr%>" class="small"
				id="unit<%=incr%>" readonly="readonly" size="5" value="<%=prescriptionDetails.getItem().getItemConversion().getItemUnitName()%>"/>
			</td>
			<td> 
			<input type="text" tabindex="1" id="frequency<%=incr%>"
				  name="frequency<%=incr%>" readonly="readonly"
				  value="<%=prescriptionDetails.getFrequency().getFrequencyName()%>" class="small" size="5"/></td>
				   
			<td><input type="text" name="noOfDays<%=incr%>"
				id="noOfDays<%=incr%>" class="small" tabindex="1"
				 value="<%=prescriptionDetails.getNoOfDays()%>" readonly="readonly" size="5"/></td>
			<td>
			
			<%
			String instruction="";
			if(prescriptionDetails.getInsrtuction()!=null){
				instruction=prescriptionDetails.getInsrtuction().getOpdInstructionTreatmentCode();
			}%>
			<input type="text" name="instrunction<%=incr%>"
			id="instrunction<%=incr%>" class="small" tabindex="1"
			 readonly="readonly" value="<%=instruction%>" size="5"/>
			</td>
				 
			<td>
			<%
			String route="";
			if(prescriptionDetails.getRoute()!=null){
				route=prescriptionDetails.getRoute().getRouteName();
			}%>
			 
				<input type="text" name="route<%=incr%>"
				id="route<%=incr%>" class="small" tabindex="1"
				 value="<%=route%>" readonly="readonly" size="5"/>
			  
			</td>
				  
					<td>
					<%
					Float issuedQty=0.00f;
					if(prescriptionDetails.getTotalStoreIssuedQty()!=null){
						issuedQty=prescriptionDetails.getTotalStoreIssuedQty();
					}
					
					%>
					<input type="text" name="total1" id="total1" size="5"
							class="small" validate="Total,num,no" value="<%=issuedQty%>"/> <input
							type="hidden" name="pvmsNo<%=incr%>" id="pvmsNo<%=incr%>"
							size="10" value="<%=prescriptionDetails.getItem().getPvmsNo()%>" /></td>
					<td><input type="text" name="remark<%=incr%>"></input></td>
				
		</tr> 
	<%} %>	
	</table>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</div> 
<%}else{%>
		<h2><span>No Record Found</span></h2>
<%}%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
