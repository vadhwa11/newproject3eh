<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URL"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.Properties"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.math.BigDecimal"%>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<div class="titleBg">
	<h2>PENDING DISPENSING DETAILS</h2>
</div>
<form name="patientDrugIssue" method="post" action="">
	<div class="clear"></div>

	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	int deptId = 0;
	int hospitalId = 0;
	String patientIssueNo="";
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	List<Object[]> visitList=new ArrayList<Object[]>();
	if(map.get("visitList") != null){
		visitList = (List<Object[]>)map.get("visitList");
	}
	List<Visit> patientList = new ArrayList<Visit>();
	if(map.get("patientList") != null){
		patientList = (List<Visit>)map.get("patientList");
	}
	Visit visit = new Visit();
	if(patientList != null) {
		visit = (Visit) patientList.get(0);
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
	
	
	if(visit.getDoctor()!=null&&!"".equals(visit.getDoctor().getEmployeeName())){
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

	if(map.get("patientIssueNo") != null){
		patientIssueNo = (String) map.get("patientIssueNo");
	}
	List<PatientPrescriptionDetails> prescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();
	if(prescriptionDetailsList !=null){
		prescriptionDetailsList=(List<PatientPrescriptionDetails>)map.get("prescriptionDetailsList");
	}

	List<StoreIssueT> alreadyissuedDrugList = new ArrayList<StoreIssueT>();
	if(map.get("alreadyissuedDrugList")!=null){
		alreadyissuedDrugList=(List)map.get("alreadyissuedDrugList");
	}

	int issueId=0;
	if(map.get("issueId")!=null)
		 issueId = Integer.parseInt(""+map.get("issueId")) ;

	 String messageTOBeVisibleToTheUser ="";
		if(map.get("messageTOBeVisibleToTheUser")!=null){
			messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
		}
	%>
	<div class="Block">
		<div class="clear"></div>
		<input type="hidden" name="visitId" value="<%=visit.getId()%>" /> <input
			type="hidden" name="deptId" value="<%=deptId%>" /> <input
			type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
			type="hidden" name="hinId" value="<%=visit.getHin().getId()%>" /> <input
			type="hidden" name="<%=RequestConstants.HIN_NO %>" value="<%=regNo%>" />
		<input type="hidden" name="<%=ISSUE_ID%>" id="issueId" value="" /> <input
			type="hidden" size="2" value="0" name="noOfRecords" id="noOfRecords" />



		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=regNo %></label> <label> Patient Name</label> <label
			class="value"><%=ptName %></label> <label> Age</label> <label
			class="value"><%=age %></label>

		<div class="clear"></div>

		<label> Doctor</label> <label class="value"><%=doctorName %></label> <label>
			Department</label> <label class="value"><%=department %></label> <label>
			Patient Type</label> <label class="value"><%=patType %></label>
		<div class="clear"></div>
		<label> Visit No</label> <label class="value"><%=visit.getVisitNo()%></label>
		<label> Issue Date</label> <input type="hidden"
			name="<%=ISSUE_DATE %>" value="<%=currentDate %>" id="issueDate" />
		<label class="value"><%=currentDate %></label> <label> Sex</label> <label
			class="value"><%=sex %></label>
		<div class="clear"></div>
		<label> Issue No.</label> <input type="hidden" name="issueNo"
			value="<%=patientIssueNo %>" tabindex=1 id="issueNo" /> <label
			class="value"><%=patientIssueNo %></label>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<%int inc=0;
if(prescriptionDetailsList.size()>0){ %>

	<div class="tableHolderAuto" style="overflow: scroll;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="pendingDispense">
			<thead>
				<tr>
					<th>Sr No.</th>
					<th>Item Code</th>
					<th>Item Name</th>
					<th>Prescribed Qty.</th>
					<th>Dosage</th>
					<th>Frequency</th>
					<th>Days</th>
					<th>Route of Administration</th>
					<th>Instruction</th>
					<th>Special Instruction</th>
					<th>Last Issued Qty.</th>
					<th>Total Issued Qty.</th>
					<th>Balance Qty.</th>
					<th>Max. Qty. to be Issue</th>
					<!-- <th>Net amount</th> -->
					<th>Not Available</th>
					<th>Reffer to Empanelled Store</th>
				</tr>
				<%
					int temp=1;
						for(PatientPrescriptionDetails presdDetails : prescriptionDetailsList) {
							int itemId = 0;
							String nomeclature = "";
							String dosage = "";
							String qty = "";
							float cuurentIssueQty = 0;
							int noOfDays = 0;
							float totalQty = 0;
							float totalStoreIssued = 0;
							String frequency = "";
							String frequencyName = "";
							BigDecimal qtyPending = new BigDecimal(0);
							BigDecimal totalQuantity = new BigDecimal(0);
							int presId = 0;
							Date dispensingDate = new Date();
							Date prescriptionDate = new Date();
							int prescriptionId = 0;
							boolean isEmpanelled = false;
							boolean isNotAvaliable = false;
							if (presdDetails.getTotal() > 0) {
								totalQty = presdDetails.getTotal();
							}
							totalQuantity = new BigDecimal(totalQty);

							if (presdDetails.getItem() != null) {
								nomeclature = presdDetails.getItem().getNomenclature();
								itemId = presdDetails.getItem().getId();
							}
							if (presdDetails.getDosage() != null) {
								dosage = String.valueOf(presdDetails.getDosage());
							}
							if (presdDetails.getNoOfDays() != null) {
								noOfDays = presdDetails.getNoOfDays();
							}
							if (presdDetails.getFrequency() != null) {
								frequency = presdDetails.getFrequency()
										.getFrequencyCode();
								frequencyName=presdDetails.getFrequency().getFrequencyName();
							}
							if (presdDetails.getCurStoreIssuedQty() != null) {
								cuurentIssueQty = presdDetails.getCurStoreIssuedQty();
							}

							if (presdDetails.getId() != null) {
								presId = presdDetails.getId();
							}
							if (presdDetails.getPrescription().getId() != null) {
								prescriptionId = presdDetails.getPrescription().getId();
							}

							if (presdDetails.getTotalStoreIssuedQty() != null) {
								totalStoreIssued = presdDetails
										.getTotalStoreIssuedQty();
							}

							if (presdDetails.getPrescription().getDispencingDate() != null) {
								dispensingDate = presdDetails.getPrescription()
										.getDispencingDate(); 
							}
							if (presdDetails.getPrescription().getPrescriptionDate() != null) {
								prescriptionDate = presdDetails.getPrescription()
										.getPrescriptionDate(); 
							}
							if (presdDetails.getNotAvailable() != null
									&& "Y".equalsIgnoreCase(presdDetails
											.getNotAvailable())) {
								isNotAvaliable = true;
							}
							if (presdDetails.getReferToEmpanelled() != null
									&& "Y".equalsIgnoreCase(presdDetails
											.getReferToEmpanelled())) {
								isEmpanelled = true;
							}
							String instruction = "-";
							if (presdDetails.getInsrtuction() != null
									&& !"".equals(presdDetails.getInsrtuction()
											.getOpdInstructionTreatmentName())) {
								instruction = presdDetails.getInsrtuction()
										.getOpdInstructionTreatmentName();
							}

							String spcl_instruction = "-";
							if (presdDetails.getSplInstruction() != null
									&& !"".equals(presdDetails.getSplInstruction())) {
								spcl_instruction = presdDetails.getSplInstruction();
							}

							String routeName = "-";
							if (presdDetails.getRoute() != null
									&& !"".equals(presdDetails.getRoute()
											.getRouteName())) {
								routeName = presdDetails.getRoute().getRouteName();
							}
							BigDecimal issuedQty= new BigDecimal(0);
							if(presdDetails.getTotalStoreIssuedQty() !=null){
							issuedQty=new BigDecimal(presdDetails.getTotalStoreIssuedQty());
							}

							qtyPending = totalQuantity.subtract(issuedQty) ;
							Calendar with = Calendar.getInstance();
							with.setTime(prescriptionDate);

							with.set(Calendar.YEAR, with.get(Calendar.YEAR));

							Calendar to = Calendar.getInstance();
							to.setTime(dispensingDate);
							to.set(Calendar.YEAR, with.get(Calendar.YEAR));

							int withDAY = with.get(Calendar.DAY_OF_YEAR);
							int toDAY = to.get(Calendar.DAY_OF_YEAR);

							int diffDay = toDAY - withDAY; 
							int priviousQt=(int)totalStoreIssued-(diffDay * Integer.parseInt(frequency));
							if(priviousQt<0){
								priviousQt=0;
							}
							int maxQuantitiToBeIssued = 0;
							System.out.println("noOfDays--" + noOfDays + "diffDay--"
									+ diffDay + "frequency--" + frequency);
							maxQuantitiToBeIssued = (noOfDays - diffDay)
									* (Integer.parseInt(frequency))-priviousQt;
							if (maxQuantitiToBeIssued < 0) {
								maxQuantitiToBeIssued = 0;
							}  
							%>
				
				<tr>
					<td width="5%"><input type="text" size="2" tabindex="1"
						value="<%=temp+inc%>" id="srNo<%=inc %>" /> <input type="hidden"
						name="visitId" value="<%=visitId%>" id="visitId<%=inc %>" /> <input
						type="hidden" name="presId" value="<%=presId%>"
						id="presId<%=inc %>" /> <input type="hidden"
						name="prescriptionId" value="<%=prescriptionId%>"
						id="prescriptionId<%=inc%>" /></td>

					<td><input type="text" size="7px" value="<%=itemId %>"
						id="itemId<%=inc %>" name="<%=ITEM_ID %>" /></td>

					<td id="nomenclatureDiv<%=inc%>">
						<div id="ac2updates<%=inc%>" style="display: none;"
							class="autocomplete"></div> <a href="#"
						style="text-decoration: none;"
						onclick="openPopupForItemIssueForPatient(this.value,document.getElementById('qtyRequest<%=inc %>').value,<%=inc%>,'','');"><%=nomeclature%></a>
						<input type="hidden" value="<%=nomeclature%>" name="itemName"
						id="itemName<%=inc %>">
					</td> 
					<td><input type="text" value="<%=(int)totalQty %>"
						name="<%=QTY_IN_REQUEST %>" id="qtyRequest<%=inc %>" size="7px"
						readonly="readonly" tabindex=1 /></td>
					<td><%=(int)Float.parseFloat(dosage) %></td>
					<td><%=frequencyName%></td>
					<td><%=noOfDays %></td>
					<td><%=routeName %></td>
					<td><%=instruction %></td>
					<td><%=spcl_instruction %></td>
					<td><input type="text" value="<%=cuurentIssueQty%>" name=""
						id="" readonly="readonly" size="7px" tabindex="1" /></td>
					<td><input type="text" value="<%=(int)totalStoreIssued%>"
						name="<%=QTY_ISSUED %>" id="qtyIssued<%=inc %>"
						readonly="readonly" size="7px" tabindex="1" /></td>
					<td><%=qtyPending%></td>
					<td><input type="text" value="<%=maxQuantitiToBeIssued %>"
						name="qtyPending<%=inc%>" id="qtyPending<%=inc %>"
						readonly="readonly" size="7px" tabindex="1" /></td>
					</td>
					<td><input type="checkbox" id="notAvailable1<%=inc %>"
						onclick="notAvailable(<%=inc%>);"> <%-- <%}%> --%></td>
					<td><input type="checkbox" id="referToEmpanneled1<%=inc %>"
						onclick="referToEmpanneled(<%=inc%>);"> <input
							type="hidden" id="emapelledReqQty<%=inc %>"
							value="<%=maxQuantitiToBeIssued %>"></td>

				</tr>
				<%inc++; %>
				<%	}
		}//}%>
			</thead>
		</table>
		<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"
			id="hiddenValueCharge" />
	</div>

	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<input type="button" name="Submit11" class="button" value="Submit"
		onclick="submitForm('patientDrugIssue','stores?method=changePendingVisitStatus');" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="bottom">
		<div class="clear"></div>
		<div class="clear"></div>
	</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

<script type="text/javascript">
function notAvailable(rowVal)
{
	//alert(rowVal);
	/* PRESCRIPTION_HEADER_ID = "prescriptionHeaderId";
 PRESCRIPTION_DETAILS_ID = "prescriptionDetailsId"; */
	var hinId=0;
 var prescriptionDetailsId=document.getElementById("presId"+rowVal).value;
 var itemId=document.getElementById("itemId"+rowVal).value;
	var prescriptionNo=document.getElementById("prescriptionId"+rowVal).value;
	hinId=prescriptionNo;
	
	var x = document.getElementById("notAvailable1"+rowVal).checked;
	//alert("value of x--"+ x);
	if(x==true){
		submitProtoAjax('patientDrugIssue','stores?method=setNotAvailable&itemId='+itemId+'&prescriptionDetailsId='+prescriptionDetailsId+'&prescriptionNo='+prescriptionNo+'&hinId='+hinId);
	} 
		
	
	//var url="/hms/hms/stores?method=setNotAvailable&itemId="+itemId+"&presId="+presId;
	
	
	}
function referToEmpanneled(rowVal)
{

	var qtyRequest =document.getElementById("qtyRequest"+rowVal).value;
	qtyRequest=parseInt(qtyRequest)
	//alert(qtyRequest);
	var emapelledReqQty=document.getElementById("emapelledReqQty"+rowVal).value;
	var numbers = /^[0-9]+$/;
	
	
	
	if(!emapelledReqQty.match(numbers) ||emapelledReqQty.length<1 || emapelledReqQty>qtyRequest )
		{
		alert("qty cant blank/ allow only digits/cant greater than qty request");
		document.getElementById("referToEmpanneled1"+rowVal).checked=true
		return false
		}
	
	
	

	document.getElementById("referToEmpanneled1"+rowVal).disabled = true;
	
	 

	
	var hinId=0;
	 var prescriptionDetailsId=document.getElementById("presId"+rowVal).value;
	 var itemId=document.getElementById("itemId"+rowVal).value;
		var prescriptionNo=document.getElementById("prescriptionId"+rowVal).value;
		hinId=prescriptionNo;
		
		var x = document.getElementById("referToEmpanneled1"+rowVal).checked;
		//alert("value of x--"+ x);
		if(x==true){
			submitProtoAjax('patientDrugIssue','stores?method=setForEmpanelled&itemId='+itemId+'&prescriptionDetailsId='+prescriptionDetailsId+'&prescriptionNo='+prescriptionNo+'&hinId='+hinId+'&emapelledReqQty='+emapelledReqQty); 
		} 
	
	
	}
 function checkItemIssue(){
	<%
		if(alreadyissuedDrugList != null && alreadyissuedDrugList.size() > 0){
				for (StoreIssueT storeIssueT : alreadyissuedDrugList) {%>
								var invObj =<%= storeIssueT.getItem()%>
								var itemId=document.getElementById('itemId').value
								if(invObj==itemId ){
								alert("Drug is already issued in previous visit...");
 							}
 							<%}}%> 	
 							}


 	</script>