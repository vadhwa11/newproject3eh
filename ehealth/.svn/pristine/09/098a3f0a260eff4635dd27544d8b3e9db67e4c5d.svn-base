<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
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
	serverdate = '<%=date+"/"+month1+"/"+year1%>';
</script>
<div class="titleBg">
	<h2>DISPENSING DETAILS</h2>
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
	
	String userName = "";
	String time= "";
	
	date = (String)utilMap.get("currentDate");
	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
/* 	List<Object[]> visitList=new ArrayList<Object[]>();
	if(map.get("visitList") != null){
		visitList = (List<Object[]>)map.get("visitList");
	} */
	List<Visit> patientList = new ArrayList<Visit>();
	if(map.get("patientList") != null){
		patientList = (List<Visit>)map.get("patientList");
	}
	Visit visit = new Visit();
	StringBuffer visitIdForShow=new StringBuffer("");
	StringBuffer deptList=new StringBuffer("");
	if(patientList != null && patientList.size()>0) {
		for(Visit visitObj:patientList){
			if(patientList.size()==1){
				visitIdForShow=visitIdForShow.append(visitObj.getVisitNo());
				deptList=deptList.append(visitObj.getDepartment().getDepartmentName());
			}else{
				visitIdForShow=visitIdForShow.append(visitObj.getVisitNo()+",");
				deptList=deptList.append(visitObj.getDepartment().getDepartmentName()+",");
			}
			
		}
		visit = (Visit) patientList.get(0);
	}
	
	/* List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	} */
	
	int visitId=0;
	String regNo="";
	String ptName="";
	String lastName="";
	String age="";
	String sex="";
	String diagnosis="";
	String department="";
	String patType="-";
	String doctorName="";
	String mobileNo = "";
	
	
	if(visit.getDoctor()!=null&&!"".equals(visit.getDoctor().getEmployeeName())){
		doctorName=visit.getDoctor().getEmployeeName();
	}
	regNo=visit.getHin().getHinNo();
	visitId=visit.getId();
	if(visit.getHin().getPatientType()!=null){
		patType=visit.getHin().getPatientType().getPatientTypeName();
	}
	
	if(visit.getHin().getMobileNumber()!=null){
		mobileNo= visit.getHin().getMobileNumber();
	}
	if(visit.getHin().getPLastName()!=null){
		lastName=visit.getHin().getPLastName();
	}
	ptName=visit.getHin().getPFirstName()+" "+lastName;
	if(visit.getHin().getAge()!=null &&!visit.getHin().getAge().equals(""))
	age=visit.getHin().getAge();
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
	List<Object[]> nonInsulineprescriptionDetailsList = new ArrayList<Object[]>();
	
	if(nonInsulineprescriptionDetailsList !=null){
		nonInsulineprescriptionDetailsList=(List<Object[]>)map.get("nonInsulineprescriptionDetailsList");
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
	Map<Integer,String> mapForAvailabilityStatus=new HashMap<Integer,String>();
	if(map.get("mapForAvaliabilityStatus")!=null){
		mapForAvailabilityStatus=(Map<Integer,String>)map.get("mapForAvaliabilityStatus");
	}
//	Set<DischargeIcdCode> dischargeIcdCodes=visit.getDischargeIcdCodes();
	Set<OpdPatientDetails> opdPatientDetails=visit.getOpdPatientDetails();
	String provisionalDiagnosis=null;
	String finalDiagnosis=null;
	int opdDetailsId=0;
	for(OpdPatientDetails oDetails:opdPatientDetails){
		if(oDetails.getProvisionalDiagnosis()!=null)
			provisionalDiagnosis =oDetails.getProvisionalDiagnosis();
    		   finalDiagnosis = oDetails.getFinalDiagnosis();
    		   opdDetailsId=oDetails.getId();
	}
	
/* 	for(DischargeIcdCode code:dischargeIcdCodes){
		provisionalDiagnosis.append(code.getIcd().getIcdName());
	}
	for(OpdPatientDetails oDetails:opdPatientDetails){
		if(oDetails.getEmployee()!=null)
		doctorName=oDetails.getEmployee().getEmployeeName();

		if(oDetails.getInitialDiagnosis()!=null){
			provisionalDiagnosis.append(", "+oDetails.getInitialDiagnosis());
		}
		
	} */
	 Map<Integer,ArrayList<String>> bachNoMapList=null;
	 bachNoMapList=new HashMap<Integer,ArrayList<String>>();
	 
	 Map<Integer,ArrayList<String>> expiryMapList=null;
	 expiryMapList=new HashMap<Integer,ArrayList<String>>();
	 
	 Map<Integer,ArrayList<String>> stockMapList=null;
	 stockMapList=new HashMap<Integer,ArrayList<String>>();
	 
	 if(map.get("bachNoMapList")!=null)
		 bachNoMapList = (Map<Integer,ArrayList<String>>)map.get("bachNoMapList") ;

	 if(map.get("ExpiryMapList")!=null)
		 expiryMapList = (Map<Integer,ArrayList<String>>)map.get("ExpiryMapList") ;
	 
	 if(map.get("stockMapList")!=null)
		 stockMapList = (Map<Integer,ArrayList<String>>)map.get("stockMapList") ;
	
	%>
	<div class="Block">
		<div class="clear"></div>
		 <input type="hidden" name="visitId" id="visitId"
			value="<%=visit.getId()%>" />
			<input type="hidden" name="opdDetailsId" id="opdDetailsId"
			value="<%=opdDetailsId%>" />   
		<input type="hidden" name="deptId" id="deptId" value="<%=deptId%>" /> <input
			type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
			type="hidden" name="hinId" value="<%=visit.getHin().getId()%>" /><input
			type="hidden" name="<%=RequestConstants.HIN_NO %>" value="<%=regNo%>" />
		<input type="hidden" name="<%=ISSUE_ID%>" id="issueId" value="" /> <input
			type="hidden" size="2" value="0" name="noOfRecords" id="noOfRecords" />

		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=regNo %></label> <label> Patient Name</label> <label
			class="value"><%=ptName %></label> <label> Age</label> <label
			class="value"><%=age %></label>

		<div class="clear"></div>

		<label> Doctor</label> <label class="value"><%=doctorName %> </label>
		<input type="hidden" name="doctorNameforphmcy"
			value="<%=doctorName %>" tabindex=1 id="doctorNameforph" /> <label>
			Department</label> <label class="value"><%=deptList.toString() %></label>
	
		<label> Visit No</label> <label class="value"><%=visitIdForShow.toString()%></label>


		<div class="clear"></div>
		<label> Issue Date</label> <input type="hidden"
			name="<%=ISSUE_DATE %>" value="<%=currentDate %>" id="issueDate" />
		<label class="value"><%=currentDate %></label> <label> Gender</label>
		<label class="value"><%=sex %></label>

	<label> Issue No.</label> <input type="hidden" name="issueNo"
			value="<%=patientIssueNo %>" tabindex=1 id="issueNo" /> <label
			class="value"><%=patientIssueNo %></label>
		<div class="clear"></div>
		<label> Mobile No.</label><label
			class="value"><%=mobileNo %></label>
		<div class="clear"></div>
		<label> Provisional Diagnosis</label> <label class="auto"
			style="padding: 0px 12px 0px 5px;"><%=provisionalDiagnosis!=null?provisionalDiagnosis:""%></label>
				<label> Final Diagnosis</label> <label class="auto"
			style="padding: 0px 12px 0px 5px;"><%=finalDiagnosis!=null?finalDiagnosis:"" %></label>

	</div>
	<div class="clear" style="padding-top: 10px"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>


	<div class="clear"></div>
	<script type="text/javascript">
	 var BatchNo=new Array();
	</script>
	<div class="tableHolderAuto"  style="overflow: scroll; width: 1150px;">
		<% int inc=0; int noPrecrib=0; 
if(prescriptionDetailsList.size()>0 ){
	
	%>


		<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="dispense">
			<thead>
				<tr>
					<th style="line-height: 10px !important;">SI No.</th>
					<!-- <th>Prescription No.</th> -->
					<!-- Added by Amit Das on 18-02-2016 -->
					<!-- <th>Item Code</th> -->
					<th style="width:250px !important;">Item Name</th>
					
					<!-- <th>Unit</th> -->
					<th  style="width:20px !important;">Dosage</th>
					<th>Freq.</th>
					
					<th>Duration</th>
					<th>Route</th>
					<th>Instruction</th>
					<th>Special Instruction</th>
					<th>Batch No.</th>
					<th>Expiry Date</th>
					<th>Stock Available</th>
					<th>Pres. Qty.</th>
					<th>Issue Qty.</th>
					<th>Bal. Qty.</th>
					
					<!-- <th>Net amount</th> -->
					<th>Not Available</th>
					<th>Refer to Empanelled Store/Qty</th>
					<th>Add</th>
				</tr>
				<%
					int temp=1;
				String unit="";
				String dispensingUnit="";
				String dosageUnit="";
				
				ArrayList<String> batchNo=null;
				batchNo=new ArrayList<String>();
				ArrayList<String> expiryList=null;
				expiryList=new ArrayList<String>();
				
				ArrayList<String> stockList=null;
				stockList=new ArrayList<String>();
				
								for(PatientPrescriptionDetails presdDetails:prescriptionDetailsList){
								int itemId=0;
								String itemId1="";
								
								String nomeclature="";
								String dosage="";
								String qty="";
								int noOfDays=0;
								float totalStoreIssued=0;
								float totalQty=0;
								//String frequency="";
								int frequency = 0;
								String frequencyName="";
								String frequencyType="";
								int prescriptionId=0;
								BigDecimal qtyPending =new BigDecimal(0);
								BigDecimal totalQuantity =new BigDecimal(0);
						 		boolean isEmpanelled=false;
						 		boolean isNotAvaliable=false;
						 		String mixtureQuantity="";
						 		String aDispQty="";
						 		String issueStatus =null;
						 		if(presdDetails.getIssuedStatus()!=null && presdDetails.getIssuedStatus().equalsIgnoreCase("y") )
						 			issueStatus =presdDetails.getIssuedStatus();
							if(presdDetails.getItem()!=null){
								nomeclature=presdDetails.getItem().getNomenclature();
								itemId1=presdDetails.getItem().getPvmsNo();
								itemId=presdDetails.getItem().getId();
								if(presdDetails.getItem().getMixtureQuantity()!=null){//added by govind 04-01-2017
									mixtureQuantity=String.valueOf(presdDetails.getItem().getMixtureQuantity());
								}
								if(presdDetails.getItem().getADispQty()!=null){//added by govind 05-01-2017
									aDispQty=String.valueOf(presdDetails.getItem().getADispQty());
								}
							} 
							if(presdDetails.getDosage()!=null){
								dosage=	String.valueOf(presdDetails.getDosage());
							}
							if(presdDetails.getNoOfDays()!=null){
								noOfDays=presdDetails.getNoOfDays();
							}
							if(presdDetails.getFrequency()!=null && presdDetails.getFrequency().getFrequencyType()!=null){
								frequencyType = presdDetails.getFrequency().getFrequencyType();
							}
							if(presdDetails.getFrequency()!=null){
								//frequency=presdDetails.getFrequency().getFrequencyCode();
								frequency=presdDetails.getFrequency().getFrequencyCount();
								frequencyName=presdDetails.getFrequency().getFrequencyName();
								
							}
							if(presdDetails.getTotalStoreIssuedQty()!=null){ 
								totalStoreIssued=presdDetails.getTotalStoreIssuedQty();
							}
							
							if(presdDetails.getPrescription().getId()!=null){ 
								prescriptionId=presdDetails.getPrescription().getId();
							}if(presdDetails.getReferToEmpanelled()!=null && "Y".equalsIgnoreCase(presdDetails.getReferToEmpanelled())){
								isEmpanelled=true;
							}
							if(presdDetails.getNotAvailable()!=null && "Y".equalsIgnoreCase(presdDetails.getNotAvailable())){
								isNotAvaliable=true;
							}
							    String instruction="";
							if(presdDetails.getInsrtuction() != null
											&& !"".equals(presdDetails.getInsrtuction()
													.getOpdInstructionTreatmentName())) {
										instruction = presdDetails.getInsrtuction()
												.getOpdInstructionTreatmentName();
									}

									String spcl_instruction="";
									if(presdDetails.getSplInstruction()!=null && !"".equals(presdDetails.getSplInstruction())){ 
										spcl_instruction=presdDetails.getSplInstruction();
									} 
									
									
									String routeName="";
									if(presdDetails.getRoute()!=null && !"".equals(presdDetails.getRoute().getRouteName())){ 
										routeName = presdDetails.getRoute().getRouteName();
							} 
							if (presdDetails.getTotal() > 0) {
								totalQty = presdDetails.getTotal();
								
								float dosageInt = Float.parseFloat(dosage);
								//float frequencyInt = Float.parseFloat(frequency);
								int frequencyInt= frequency;
								//totalQty = dosageInt * (noOfDays) * frequencyInt;
								
							} else {
								float dosageInt = Float.parseFloat(dosage);
								if(presdDetails.getFrequency()!=null){
									//float frequencyInt = Float.parseFloat(frequency);
									int frequencyInt= frequency;
									totalQty = dosageInt * (noOfDays) * frequencyInt;
								}
								
							}
							totalQuantity = new BigDecimal(totalQty);

							int presId = 0;
							presId = presdDetails.getId();
				%>
				<tr>
					<td><%=temp+inc%><input type="hidden" size="1" tabindex="1" name="srNo<%=inc %>"
						value="<%=temp+inc%>" id="srNo<%=inc %>" />
						 <input type="hidden"
						name="visitId<%=inc %>"
						value="<%=presdDetails.getPrescription().getVisit().getId()%>"
						id="visitId<%=inc %>" /> <input type="hidden" name="presId<%=inc %>"
						value="<%=presId%>" id="presId<%=inc %>" />
					<input type="hidden" name="prescriptionId"
						value="<%=prescriptionId%>" id="prescriptionId<%=inc %>" />
						<input type="hidden" name="issuedStatus<%=inc%>"
						value="<%=issueStatus!=null?issueStatus:""%>" id="issuedStatus<%=inc%>" /></td>
					<!-- </td> -->
					<%-- <td><%=prescriptionId%></td> --%>
					<!-- Added by Amit Das on 18-02-2016 -->
					<%-- <td><input type="text" size="5px" value="<%=itemId1 %>"
						tabindex=1 /> </td> --%>
					<input type="hidden" size="5px" value="<%=itemId %>"
						id="itemId<%=inc %>" name="<%=ITEM_ID %><%=inc %>" tabindex=1 />
					<%if("available".equalsIgnoreCase(mapForAvailabilityStatus.get(itemId))){%>
					<td id="nomenclatureDiv<%=inc%>">
						<div id="ac2updates<%=inc%>" style="display: none;"
							class="autocomplete"></div> 
							
							<!-- 	Added by dhananjay on 01-DEC-2016 -->
							<%-- <a href="#"style="text-decoration: none;"
						onclick="openPopupForItemIssueForPatient(this.value,document.getElementById('qtyRequest<%=inc %>').value,<%=inc%>,'','',csrfTokenName,csrfTokenValue);"><%=nomeclature%></a> --%>
						<input type="hidden" value="<%=nomeclature%>" name="itemName<%=inc %>"
						id="itemName<%=inc %>">
						<span style="color: <%=issueStatus!=null?"green":"black"%>"><%=nomeclature%></span> 
					</td>
					<%}else{%>
					<td id="nomenclatureDiv<%=inc%>">
						<div id="ac2updates<%=inc%>" style="display: none;"
							class="autocomplete"></div> <a href="#"
						style="text-decoration: none; color:  <%=issueStatus!=null?"green":"red"%> ;"
						onclick="openPopupForItemIssueForPatient(this.value,document.getElementById('qtyRequest<%=inc %>').value,<%=inc%>,'','',csrfTokenName,csrfTokenValue);"><%=nomeclature%></a>
						<input type="hidden" value="<%=nomeclature%>" name="itemName<%=inc %>"
						id="itemName<%=inc %>">
					</td>
					<%} %>

					<%
BigDecimal issuedQty= new BigDecimal(0);
if(presdDetails.getTotalStoreIssuedQty() !=null){
issuedQty=new BigDecimal(presdDetails.getTotalStoreIssuedQty());
}


// condition added by amit das on 19-11-2016
float actualQtyNeeded=0.0f;
if(presdDetails.getActualTotal()!=null){
actualQtyNeeded = presdDetails.getActualTotal();
}
String mixable="";
if(presdDetails.getItem().getMixable()!=null){
mixable = presdDetails.getItem().getMixable().toUpperCase();
}
if(null !=presdDetails.getItem().getMixable() && presdDetails.getItem().getMixable().equalsIgnoreCase("Y")){
	unit=presdDetails.getItem().getMixtureUnit();
} else {	
	unit=presdDetails.getItem().getItemConversion().getItemUnitName();
}
	
//dispensingUnit=presdDetails.getItem().getDispUnit()!=null?presdDetails.getItem().getDispUnit():""; commented by Srikanth
dispensingUnit=presdDetails.getItem().getItemConversion().getItemUnitName();    // Added By Srikanth
dosageUnit=presdDetails.getItem().getDispUnit()!=null?presdDetails.getItem().getDispUnit():presdDetails.getItem().getItemConversion().getItemUnitName();

qtyPending = totalQuantity.subtract(issuedQty) ;

BigDecimal scaledQtyPending = qtyPending.setScale(0, RoundingMode.HALF_UP);

%>
					
				<%-- 	<td>
					
					<%=unit%>
					<%=dispensingUnit%>
					<input type="hidden" size="10" value="<%=unit %>"
						name="unit<%=inc %>" id="unit<%=inc %>"
						readonly="readonly" tabindex=1 />
					</td> --%>
					
					<%if(Float.parseFloat(dosage)-(long)Float.parseFloat(dosage)<=0.0) {%>
					
					<% if(mixable!=null && mixable.equalsIgnoreCase("Y")) {%>
						<input type="hidden" size="10" value="<%=(int)Float.parseFloat(dosage)%><%=" "+dosageUnit%>"
								name="dosage<%=inc %>" id="dosage<%=inc %>"
								readonly="readonly" tabindex=1 />
					
					
					<td><%=(int)Float.parseFloat(dosage)%><%=" "+dosageUnit%></td>
					<% } else { %>
						<input type="hidden" size="10" value="<%=(int)Float.parseFloat(dosage)%><%=" "+dosageUnit%>"
								name="dosage<%=inc %>" id="dosage<%=inc %>"
								readonly="readonly" tabindex=1 />
					
					
					<td><%=(int)Float.parseFloat(dosage)%><%=" "+dosageUnit%></td>
					<% } %>
					<%}else{%>
					<td><%=Float.parseFloat(dosage) %><%=" "+dosageUnit%></td>
					<% }%>
					<td>
					<input type="hidden" size="10" value="<%=frequencyName %>"
								name="frequencyName<%=inc %>" id="frequencyName<%=inc %>"
								readonly="readonly" tabindex=1 />
					<%=frequencyName%></td>
					<td>
					<input type="hidden" size="10" value="<%=noOfDays %>"
								name="noOfDays<%=inc %>" id="noOfDays<%=inc %>"
								readonly="readonly" tabindex=1 />
								<input type="hidden" size="10" value="<%=frequencyType %>"
								name="frequencyType<%=inc %>" id="frequencyType<%=inc %>"
								readonly="readonly" tabindex=1 />
					<%=noOfDays %> <%=frequencyType %></td>
					
					<td>
						<input type="hidden" size="10" value="<%=routeName %>" name="routeName<%=inc%>" id="routeName<%=inc%>" />
						<%=routeName%></td>
					<td>
		<input type="hidden" size="20" value="<%=instruction %>" name="instruction<%=inc%>" id="instruction<%=inc%>"  />
					
					<%=instruction%></td>
					<td>
				<input type="hidden" size="20" value="<%=spcl_instruction %>" name="spcl_instruction<%=inc%>" id="spcl_instruction<%=inc%>"  />	
					<%=spcl_instruction%></td>
					
				<td>
				<input type="hidden" value="<%=presdDetails.getItem().getId()%>" name="itemId<%=inc %>" id="itemId<%=inc %>"/>
				<select name="batchNo<%=inc %>" id="batchNo<%=inc %>" class="smallnew"
				tabindex="1" validate=""
				onChange="populateExpiryDateByBatchNo(<%=inc %>,this.value,<%=presdDetails.getItem().getId()%>,<%=deptId%>)"
			<%-- 	<%if(null !=bachNoMapList) {//added by govind 19-12-2016
						batchNo=(ArrayList<String>)bachNoMapList.get(presdDetails.getItem().getId());
						if(batchNo.size()>0){}else{							
						%>
						disabled="disabled"
				<%}}//added by govind 19-12-2016 end%> --%>
				
				>
					<%if(null !=bachNoMapList) {
						batchNo=(ArrayList<String>)bachNoMapList.get(presdDetails.getItem().getId());	
						String tempbatchNo="";
						System.out.println("batchNo--"+batchNo.size());
						for (int i = 0; i < batchNo.size(); i++) {
					
							tempbatchNo=batchNo.get(i);%>
							<script>
							BatchNo<%=inc %>[<%=i%>]= new Array();
							BatchNo<%=inc %>[<%=i%>][0] = "<%=batchNo.get(i)%>";
							BatchNo<%=inc %>[<%=i%>][1] = "<%=batchNo.get(i)%>";
	            </script>
						<option value="<%=batchNo.get(i)%>"><%=batchNo.get(i) %></option>
						<%}//batchNo.clear();%>
					<%}%>
					</select>
					</td>
					
					<td>
				
					 <% String expiryDate="";if(null !=expiryMapList) {
						expiryList=(ArrayList<String>)expiryMapList.get(presdDetails.getItem().getId());
						
						
						for(String expiry:expiryList){expiryDate=expiry;%>
						
						<%break;} //expiryList.clear();
					}%>
			
					<input type="text" name="expiry<%=inc %>" id="expiry<%=inc %>" value="<%=expiryDate %>"readonly="readonly"
				tabindex="1" validate="" size="7"
				onChange=""/>
					</td>
					
					
					
					<td>
					
					<% String batchNoWisestock="";
					if(null !=stockMapList) {
						stockList=(ArrayList<String>)stockMapList.get(presdDetails.getItem().getId());
						
						
						for(String stock:stockList){batchNoWisestock=stock;
						
						%>
						
						<%break;} //stockList.clear();
					}%>
					
					
			<div style="width:103px; float:left;">
					<input type="text" name="batchWisestock<%=inc %>" id="batchWisestock<%=inc %>" value="<%=batchNoWisestock%>"readonly="readonly" size="6"
				tabindex="1" validate="" />
				
				<%=dispensingUnit %>
				</div>
					</td>
					<td>
					<div style="width:90px; float:left;">
						<%if(totalQty- (long)totalQty<=0.0) {%> 
						<input type="text" size="4"
						value="<%=(int)totalQty %>" name="<%=QTY_IN_REQUEST %><%=inc %>"
						id="qtyRequest<%=inc %>" readonly="readonly" tabindex=1 />
						<%=unit%>
						<%}else{%>
						<input type="text" size="4" value="<%=totalQty %>"
						name="<%=QTY_IN_REQUEST %><%=inc %>" id="qtyRequest<%=inc %>"
						readonly="readonly" tabindex=1 />
						<%=unit%>
						<% }%>
						</div>
					</td>
					<%-- <%if("available".equalsIgnoreCase(mapForAvailabilityStatus.get(itemId)) ){%>
					<td><input type="text" size="4" value="<%=(int)totalStoreIssued %>" name="qtyIssued<%=inc %>" onblur="updateBalanceQuantity(<%=inc %>,this.value)" id="qtyIssued<%=inc %>"  tabindex="1" />
					</br>
					<%=unit %>
					</td> --%>
					<%if("available".equalsIgnoreCase(mapForAvailabilityStatus.get(itemId)) ){
						float availableStok=Float.parseFloat(batchNoWisestock);
					%>
					
					<td>
					<div style="width:90px; float:left;">
					<input type="text" size="4" value="<%=(float)availableStok>0.0&&(float)availableStok>=(float)totalQty?(int)Math.ceil(totalQty):(int)Math.ceil(availableStok) %>" name="qtyIssued<%=inc %>" onblur="updateBalanceQuantity(<%=inc %>,this.value)" id="qtyIssued<%=inc %>"  tabindex="1" <%=issueStatus!=null?"readonly":""%>/>
					
					<%=unit %>
					</div>
					</td>
						<%}else{ %>
						<td>
						<div style="width:90px; float:left;">
						<input type="text" size="4" readonly="readonly" value="<%=(float)Math.ceil(totalStoreIssued) %>" name="qtyIssued<%=inc %>" id="qtyIssued<%=inc %>"  tabindex="1" />
						
						<%=unit %>
						</div>
						</td>
						<%} %>
						
						<% if(batchNoWisestock!=""){
							float availableStock=Float.parseFloat(batchNoWisestock);
							   int issueQty=(int)availableStock>0&&(int)availableStock>=(int)totalQty?(int)totalQty:(int)availableStock;
							   int balStock=((int)totalQty)-(issueQty);
						%>
						
						<td>
						<div style="width:90px; float:left;">
						<input type="text" size="4" value="<%=balStock %>" name="" id="qtyPending<%=inc%>" readonly="readonly" tabindex="1" />
					<%=unit %>
					
					<input type="hidden" size="10" value="<%=balStock %>" name="" id="actualQtyPending<%=inc%>" readonly="readonly" tabindex="1" />
					</div>
					</td>
					<%}else{ %>
										
					<td>
					<div style="width:90px; float:left;">
					<input type="text" size="4" value="<%=scaledQtyPending %>" name="" id="qtyPending<%=inc%>" readonly="readonly" tabindex="1" />
					<%=unit %>
					
					<input type="hidden" size="10" value="<%=scaledQtyPending %>" name="" id="actualQtyPending<%=inc%>" readonly="readonly" tabindex="1" />
					</div>
					</td>
					<%} %>
						
					<!-- <td><input type="text" readonly="readonly"></td> -->
					<td>
						<%-- <%if(isNotAvaliable){%><label>Not Available</label> <%}else{%> --%>
						<input type="checkbox" id="notAvailable1<%=inc %>"
						onclick="notAvailable(<%=inc%>);"> <%-- <%} %> --%>
					</td>
					<td>
						<%-- <%if(isEmpanelled){%><label>Empanelled</label> <%}else{%> --%>
						<input type="checkbox" id="referToEmpanneled1<%=inc %>" disabled="disabled"
						onclick="referToEmpanneled(<%=inc%>);"> <input
						type="hidden" id="emapelledReqQty<%=inc %>"
						value="<%=qtyPending%>"> <%--  <%} %> --%>
						
						<input type="hidden" size="10"
						value="<%=actualQtyNeeded %>" name="actualQtyNeeded<%=inc %>" 
						id="actualQtyNeeded<%=inc %>"  tabindex="1" />
						
						<input type="hidden" size="10"
						value="<%=mixable %>" name="mixable<%=inc %>" 
						id="mixable<%=inc %>"  tabindex="1" />
						
						<input type="hidden" size="10"
						value="<%=mixtureQuantity %>" name="mixtureQuantity<%=inc %>" 
						id="mixtureQuantity<%=inc %>"  tabindex="1" /><!-- added by govind 04-01-2017 -->
						
						<input type="hidden" size="10"
						value="<%=aDispQty %>" name="aDispQty<%=inc %>" 
						id="aDispQty<%=inc %>"  tabindex="1" /><!-- added by govind 04-01-2017 -->
					</td>
					<td >
					<%if(batchNo.size()>0){%>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForDirectPrescription(<%=inc %>);" />
		<%} %>
		</td>

				</tr>
				
				<%inc++;noPrecrib++; %>
				<%}
		}
			//}%>
			</thead>
			<input type="hidden" value="<%=inc%>" name="medicineCounter" id="medicineCounter"/>
		</table>

		<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"
			id="hiddenValueCharge" />
			
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<%if(noPrecrib==0){ %>
	<br><br>
			<font style="color:#0000cd;font: bold 16px/15px arial, tahoma;margin-left:300px;">Other Medicine prescribed for this patient</font>
	<%}%>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="tableHolderAuto" style="overflow: scroll; width: 1150px;">
		<% int inc1=0;
if(nonInsulineprescriptionDetailsList!=null && nonInsulineprescriptionDetailsList.size()>0){ %>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="dispense">
			<thead>
				<tr>
					<th style="line-height: 15px !important;">SI No.</th>
					<th>Item Code</th>
					<th>Item Name</th>
					<th>Prescribed Quantity</th>
					<th>Dosage</th>
					<th>Frequency</th>
					<th>Days</th>
					<th>Route of Administration</th>
					<th>Issued Qty</th>

				</tr>
				<%
								int temp=1;
								for(Object[] presdDetails:nonInsulineprescriptionDetailsList){
								int itemId=0;
								String itemId1="";				
				%>
				<tr>
					<td><%=temp+inc1%>
					<td><%=presdDetails[0]!=null?presdDetails[0]:"" %>
					<td><%=presdDetails[1]!=null?presdDetails[1]:"" %></td>
					<td><%=presdDetails[5]!=null?presdDetails[5]:"" %></td>
					<td><%=presdDetails[2]!=null?presdDetails[2]:"" %></td>
					<td><%=presdDetails[3]!=null?presdDetails[3]:"" %></td>
					<td><%=presdDetails[4]!=null?presdDetails[4]:"" %></td>
					<td><%=presdDetails[6]!=null?presdDetails[6]:"" %></td>
					<td><%=presdDetails[7]!=null?presdDetails[7]:"" %></td>
				</tr>
				<%inc1++; %>
				<%	}
		}//}%>
			</thead>
		</table>

		<input type="hidden" value="<%=inc1%>" name="hiddenValueCharge"
			id="hiddenValueCharge" />
	</div>

	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<input type="button" name="Submit11" class="button" value="Submit"
		onclick="checkForIssueQuantity();" />
		
	<!-- <input type="button" name="Submit11" class="button" value="Submit And Print"
		onclick="submitAndPrint();" /> -->
			
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="bottom">
		<div class="clear"></div>
		<div class="clear"></div>
	</div>
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
		type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
</form>

<script type="text/javascript">
/* function addRowForDirectPrescription(rowValue)
{
	alert(rowValue)
    var x=document.getElementById('dispense');
       // deep clone the targeted row
    var new_row = x.rows[rowValue+1].cloneNode(true);
       // get the total number of rows
    var len = x.rows.length;
       // set the innerHTML of the first row 
    new_row.cells[0].innerHTML = len;

       // grab the input from the first cell and update its ID and value
    var inp1 = new_row.cells[1].getElementsByTagName('input')[0];
    inp1.id += len;
    inp1.value = '';

       // grab the input from the first cell and update its ID and value
    var inp2 = new_row.cells[2].getElementsByTagName('input')[0];
    inp2.id += len;
    inp2.value = '';

       // append the new row to the table
    x.appendChild( new_row );
} */
function addRowForDirectPrescription(rowValues)
{
	
	  var tbl = document.getElementById('dispense');
	
	  var lastRow = tbl.rows.length;
	 // var deptId = document.getElementById('deptId').value;
	//  var listSize=document.getElementById('listsize').value;
	 // listSize=(parseInt(listSize))+1;
/*	  var iteration = lastRow;
	
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration*/


	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueCharge');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
		  


	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemName'+iteration;
	  e1.id = 'itemName'+iteration;
	  e1.size='20';
	 e1.value=document.getElementById('itemName'+rowValues).value;
	  e1.readOnly=true;

	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	  e11.value=document.getElementById('itemId'+rowValues).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);


	  

	  
	  /* var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'unit' + iteration;
	  e3.id = 'unit' + iteration;
	  e3.size = '7';
	  e3.setAttribute('tabindex', '5');
	  e3.value=document.getElementById('unit'+rowValues).value;
	  e3.readOnly=true;
	  cellRight3.appendChild(e3); */
	  
	  var cellRight4 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'dosage' + iteration;
	  e4.id = 'dosage' + iteration;
	  e4.size = '7';
	  e4.setAttribute('tabindex', '5');
	  e4.value=document.getElementById('dosage'+rowValues).value;
	  e4.readOnly=true;
	  cellRight4.appendChild(e4);
	  
	  
	  var cellRight5 = row.insertCell(3);
	  var e5= document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'frequencyName' + iteration;
	  e5.id = 'frequencyName' + iteration;
	  e5.size = '7';
	  e5.setAttribute('tabindex', '5');
	  e5.value=document.getElementById('frequencyName'+rowValues).value;
	  e5.readOnly=true;
	  cellRight5.appendChild(e5);
	  
	  var cellRight6 = row.insertCell(4);
	  var e6= document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'noOfDays' + iteration;
	  e6.id = 'noOfDays' + iteration;
	  e6.size = '7';
	  e6.setAttribute('tabindex', '5');
	  e6.value=document.getElementById('noOfDays'+rowValues).value+" "+document.getElementById('frequencyType'+rowValues).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);
	  
	  var deptId=document.getElementById('deptId').value
	
	  var batchValue=document.getElementById('batchNo'+rowValues).value
	 
	var itemId=document.getElementById('itemId'+rowValues).value
	
	 var cellRight12 = row.insertCell(5);
	  var e12=document.createElement('input');
	  e12.type = 'text';
	  e12.name = 'routeName' + iteration;
	  e12.id = 'routeName' + iteration;
	  e12.size = '15';
	  e12.setAttribute('tabindex', '5');
	  e12.value=document.getElementById('routeName'+rowValues).value;
	  e12.readOnly=true;
	  cellRight12.appendChild(e12); 
	
	var cellRight13 = row.insertCell(6);
	  var e13=document.createElement('input');
	  e13.type = 'text';
	  e13.name = 'instruction' + iteration;
	  e13.id = 'instruction' + iteration;
	  e13.size = '15';
	  e13.setAttribute('tabindex', '5');
	  e13.value=document.getElementById('instruction'+rowValues).value;
	  e13.readOnly=true;
	  cellRight13.appendChild(e13);
	  
	  var cellRight14 = row.insertCell(7);
	  var e14=document.createElement('input');
	  e14.type = 'text';
	  e14.name = 'spcl_instruction' + iteration;
	  e14.id = 'spcl_instruction' + iteration;
	  e14.size = '15';
	  e14.setAttribute('tabindex', '5');
	  e14.value=document.getElementById('spcl_instruction'+rowValues).value;
	  e14.readOnly=true;
	  cellRight14.appendChild(e14);
	
	   
	
	  var cellRight7 = row.insertCell(8);
		var e7 = document.createElement('Select');
		e7.name = 'batchNo' + iteration;
		e7.id = 'batchNo' + iteration;
		e7.className ='smallnew';
		/* e7.style.background = "#FFFF99"; */
		e7.options[0] = new Option('Select', '0');
		var opt1 = document.getElementById('batchNo' + rowValues);
		e7.innerHTML = e7.innerHTML+opt1.innerHTML;
		for (var i = 0; i < BatchNo.length; i++) {
			e7.options[i + 1] = new Option(BatchNo[i][1],
					BatchNo[i][0]);
		}
		
		
		e7.onchange = function() {
			//alert();
			populateExpiryDateByBatchNo(iteration,this.value,itemId,deptId);
		};
		cellRight7.appendChild(e7);
		var cellRight8 = row.insertCell(9);
		  var e8=document.createElement('input');
		  e8.type = 'text';
		  e8.name = 'expiry' + iteration;
		  e8.id = 'expiry' + iteration;
		  e8.size = '7';
		  e8.setAttribute('tabindex', '5');
		 // e24.value=document.getElementById('noOfDays'+rowValues).value;
		  e8.readOnly=true;
		  cellRight8.appendChild(e8);
		  
		  var cellRight9 = row.insertCell(10);
		  var e9=document.createElement('input');
		  e9.type = 'text';
		  e9.name = 'batchWisestock' + iteration;
		  e9.id = 'batchWisestock' + iteration;
		  e9.size = '6';
		  e9.setAttribute('tabindex', '5');
		 // e24.value=document.getElementById('noOfDays'+rowValues).value;
		  e9.readOnly=true;
		  cellRight9.appendChild(e9);
		
		  
		  var cellRight2 = row.insertCell(11);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name = 'qtyRequest' + iteration;
		  e2.id = 'qtyRequest' + iteration;
		  e2.size = '4';
		  e2.setAttribute('tabindex', '4');
		  e2.value=document.getElementById('qtyRequest'+rowValues).value;
		  e1.readOnly=true;
		  cellRight2.appendChild(e2);
		  
		  var cellRight10 = row.insertCell(12);
		  var e10=document.createElement('input');
		  e10.type = 'text';
		  e10.name = 'qtyIssued' + iteration;
		  e10.id = 'qtyIssued' + iteration;
		  e10.size = '4';
		  e10.setAttribute('tabindex', '5');
		 // e24.value=document.getElementById('noOfDays'+rowValues).value;
		 // e10.readOnly=true;
		 e10.onchange = function() {
			//alert();
			updateBalanceQuantity(iteration,this.value);
		};
		  cellRight10.appendChild(e10);
		  
		  
		  
		  var cellRight11 = row.insertCell(13);
		  var e11=document.createElement('input');
		  e11.type = 'text';
		  e11.name = 'qtyPending' + iteration;
		  e11.id = 'qtyPending' + iteration;
		  e11.size = '4';
		  e11.setAttribute('tabindex', '5');
		  e11.value=document.getElementById('qtyPending'+rowValues).value;
		  e11.readOnly=true;
		  cellRight11.appendChild(e11);
		  
		  
	
		   
		  
		  
		   var cellRight15 = row.insertCell(14);
		  var e15=document.createElement('input');
		  e15.type = 'checkbox';
		  e15.name = 'notAvailable' + iteration;
		  e15.id = 'notAvailable' + iteration;
		  e15.size = '15';
		  e15.setAttribute('tabindex', '5');
		 // e15.value=document.getElementById('spcl_instruction'+rowValues).value;
		  e15.readOnly=true;
		  cellRight15.appendChild(e15);
		    
		  
		  var cellRight16 = row.insertCell(15);
		  var e16=document.createElement('input');
		  e16.type = 'checkbox';
		  e16.name = 'referToEmpanneled' + iteration;
		  e16.id = 'referToEmpanneled' + iteration;
		  e16.size = '16';
		  e16.setAttribute('tabindex', '5');
		 // e16.value=document.getElementById('spcl_instruction'+rowValues).value;
		  e16.readOnly=true;
		  cellRight16.appendChild(e16);
		  
		  var cellRight17 = row.insertCell(16);
		  var e17=document.createElement('input');
		  e17.type = 'hidden';
		  e17.name = 'actualQtyPending' + iteration;
		  e17.id = 'actualQtyPending' + iteration;
		  e17.size = '16';
		  e17.setAttribute('tabindex', '5');
		  e17.value=document.getElementById('qtyPending'+rowValues).value;
		  e17.readOnly=true;
		  cellRight17.appendChild(e17);
		  
		 // var cellRight18 = row.insertCell(17);
		  var e18 =document.createElement('input');
		  e18.type = 'hidden';
		  e18.name = 'mixable' + iteration;
		  e18.id = 'mixable' + iteration;
		  e18.size = '16';
		  e18.setAttribute('tabindex', '5');
		  e18.value=document.getElementById('mixable'+rowValues).value;
		  e18.readOnly=true;
		  cellRight17.appendChild(e18);
		  
		  
		 // var cellRight19 = row.insertCell(18);
		  var e19=document.createElement('input');
		  e19.type = 'hidden';
		  e19.name = 'mixtureQuantity' + iteration;
		  e19.id = 'mixtureQuantity' + iteration;
		  e19.size = '16';
		  e19.setAttribute('tabindex', '5');
		  e19.value=document.getElementById('mixtureQuantity'+rowValues).value;
		  e19.readOnly=true;
		  cellRight17.appendChild(e19);
		
		  
		 
		     
	  <%-- /*  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2update'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature'+iteration});
	  e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
		
	  cellRight2.appendChild(e2); */

	  var cellRight21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'au' + iteration;
	  e21.id = 'au' + iteration;
	  e21.size = '7';
	  e21.readOnly=true;
	  cellRight21.appendChild(e21);


	  var cellRight22 = row.insertCell(4);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'barCodeNo' + iteration;
	  e22.id = 'barCodeNo' + iteration;
	  e22.size = '8';
	  e22.onblur = function(){getDataForBarcode(this.value,iteration);};
	  e22.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight22.appendChild(e22);

	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('Select');
	  e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.className="small3"
	  e23.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight23.appendChild(e23);
	  
	  
	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	
	  cellRight23.appendChild(e24);
	  	  
	  var cellRight25 = row.insertCell(6);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;
	  var e26 = document.createElement('input');
	  e26.type = 'hidden';
	  e26.name = 'costPrice' + iteration;
	  e26.id = 'costPrice' + iteration;
	  e26.size = '10';
	  cellRight25.appendChild(e25);
	  cellRight25.appendChild(e26);
	  
	  
	  var cellRight3 = row.insertCell(7);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'strength' + iteration;
	  e3.id = 'strength' + iteration;
	  e3.size = '5';
	  //e3.value=document.getElementById('strength'+rowVal).value;
	 
	  cellRight3.appendChild(e3);
	 

	  var cellRight31 = row.insertCell(8);
     var e31 = document.createElement("select");
    
     //element5.type = "text";
     e31.name="frequencyName"+iteration;
     e31.id="frequencyName"+iteration;
     e31.setAttribute('tabindex', '1');
     e31.options[0] = new Option('Select Frequency', '0');
      <%
      
       for(MasFrequency masFrequency :frequencyList)
       { %>
     	  var choice = document.createElement('option');
	  			choice.value ='<%=masFrequency.getFeq()%>';
	  			choice.appendChild(document.createTextNode('<%=masFrequency.getFrequencyName()%>'));
				e31.appendChild(choice);
				
		<%}%>
		
		e31.onblur=function(){getFrequencyValue(this.value,iteration);};
		cellRight31.appendChild(e31);

		var e32 = document.createElement('input');
		  e32.type = 'hidden';
		  e32.name='frequencyValue'+iteration;
		  e32.id='frequencyValue'+iteration;
		  e32.size='5';
		  e32.setAttribute('tabindex','1');
		  cellRight31.appendChild(e32);
		  
	  var cellRight32 = row.insertCell(9);
	  var e32 = document.createElement('input');
	  e32.type = 'text';
	  e32.name = 'noOfDays' + iteration;
	  e32.id = 'noOfDays' + iteration;
	  e32.size = '5';
	  e32.onblur = function(){setTotal(iteration);};
	  cellRight32.appendChild(e32);

	  var cellRight33 = row.insertCell(10);
     var e33 = document.createElement('input');
	  e33.type = 'text';
	  e33.name = 'intake' + iteration;
	  e33.id = 'intake' + iteration;
	  e33.size = '6';
	  e33.value="";
	  cellRight33.appendChild(e33);

	  var cellRight34 = row.insertCell(11);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'qtyPrescription' + iteration;
	  e34.id = 'qtyPrescription' + iteration;
	  e34.size = '6';
	 
	 	   
	   cellRight34.appendChild(e34);
	  
	  var cellRight6 = row.insertCell(12);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.size = '6';
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);
	  
	  var cellRight35 = row.insertCell(13);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '6';
	  e35.onblur = function(){checkQty(iteration);checkForIssue(iteration);};
	  cellRight35.appendChild(e35);

	  var cellRight36 = row.insertCell(14);
	  var e36 = document.createElement('input');
	  e36.type = 'text';
	  e36.name = 'qtyStock' + iteration;
	  e36.id = 'qtyStock' + iteration;
	  e36.size = '6';
	  e36.onblur = function(){checkQty(iteration)};
	  cellRight36.appendChild(e36);

	  var cellRight71 = row.insertCell(15);
	  var e71 = document.createElement('input');
	  e71.type = 'checkbox';
	  e71.name = 'lotOut' + iteration;
	  e71.id = 'lo' + iteration;
	  e71.value='lo';
	  e71.onblur = function(){checkForIssue(iteration)};
	  cellRight71.appendChild(e71);

	
	  var cellRight37 = row.insertCell(16);
	  var e37 = document.createElement('input');
	  e37.type = 'text';
	  e37.name = 'lotQty' + iteration;
	  e37.id = 'lotQty' + iteration;
	  e37.size = '6';
	  cellRight37.appendChild(e37);


	  var cellRight38 = row.insertCell(17);
	  var e38 = document.createElement('input');
	  e38.type = 'checkbox';
	  e38.name = 'lp' + iteration;
	  e38.id = 'lp' + iteration;
	  e38.value='lp';
	  e38.onclick = function(){changeCheckBoxValue(iteration);checkForIssue(iteration);};
	  cellRight38.appendChild(e38);

	  var cellRight39 = row.insertCell(18);
	  var e39 = document.createElement('input');
	  e39.type = 'text';
	  e39.name = 'lpQty' + iteration;
	  e39.id = 'lpQty' + iteration;
	  e39.size = '6';
	  cellRight39.appendChild(e39);


	  var cellRight40 = row.insertCell(19);
	  var e40 = document.createElement('input');
	  e40.type = 'text';
	  e40.name = 'remark' + iteration;
	  e40.id = 'remark' + iteration;
	  e40.size = '10';
	  cellRight40.appendChild(e40);

	  var cellRight41 = row.insertCell(20);
	  var e41 = document.createElement('input');
	  e41.type = 'button';
	  e41.name="b1"
	  e41.className = 'buttonAdd';
	  e41.setAttribute('tabindex', 1); 
	  e41.onclick = function(){addRowForDirectPrescription()};
	  cellRight41.appendChild(e41);

	  var cellRight42 = row.insertCell(21);
	  var e42 = document.createElement('input');
	  e42.type = 'button';
	  e42.name='delete'+iteration;
	  e42.setAttribute('tabindex', 1); 
	  e42.className = 'buttonDel';
	  e42.onclick= function(){removeRow('stockDetails',this);};
	  cellRight42.appendChild(e42);

	 document.getElementById('listsize').value=listSize; --%>
}

</script>
<script type="text/javascript">
function checkForIssueQuantity(){
	var medicineCounter = document.getElementById('medicineCounter').value;
	var issuedQuantity,batchNo,issuedStatus;
	var issueFlag = false;
	
	/*	for(var i = 0; i<medicineCounter; i++){
		issuedQuantity = document.getElementById('qtyIssued'+i).value;
		if(issuedQuantity>0){
			issueFlag = true;
			break;
		}
	}*/
	var qCount=0;nqCount=0;//added by govind 19-12-2016
	for(var i = 0; i<medicineCounter; i++){
	//	alert("i "+i);
		issuedQuantity = document.getElementById('qtyIssued'+i).value;
		batchNo = document.getElementById('batchNo'+i).value;
		issuedStatus = document.getElementById('issuedStatus'+i).value;
		if(batchNo!="" && issuedQuantity>0 && issuedStatus!="y" )
			nqCount++;
		else
			qCount++;
		/* if(batchNo>0){
		if(issuedQuantity==0){
			qCount++;
		}
		}else{
			nqCount++;
		} */
	}
	//alert("qCount "+qCount+" nqCount "+nqCount);
	
	if(nqCount>0){
		issueFlag=true;	
	}else{
			issueFlag=false;
	}
/* 	if(qCount>0){
		issueFlag=false;	
	}else{
		if(nqCount>0){
			issueFlag=true;
		}else{
			issueFlag=true;	
		}
	} */
	//added by govind 19-12-2016 end
	if(issueFlag==true){
		submitForm('patientDrugIssue','stores?method=submitChangeCurVisitStatus');	
	} else{
		alert("Atleast issue some quantity of any medicine !");
	}
}




function updateBalanceQuantity(inc,issueQty){
	
	if(document.getElementById('qtyIssued'+inc).value!=""){
		
		var stock=parseInt(document.getElementById('batchWisestock'+inc).value);
		
		var qtyPending=parseInt(document.getElementById('qtyPending'+inc).value);
		
		var actualQtyPending=parseInt(document.getElementById('actualQtyPending'+inc).value);
		var prescribedQty=parseInt(Math.ceil(parseFloat(document.getElementById('qtyRequest'+inc).value)));
		
		
		
		//added by govind 04-01-2017
		var mixable=document.getElementById('mixable'+inc).value;
		var mixtureQuantity=parseInt(document.getElementById('mixtureQuantity'+inc).value);
		//alert("mixable "+mixable+" condition "+(mixable=="Y"));
		//alert("issueQty "+issueQty+" qtyPending 1 "+qtyPending);
		
		 if(mixable=="Y"){
			// issueQty=((issueQty)/1000); //commented by amit das on 01-09-2017
			issueQty = issueQty/mixtureQuantity; //added by amit das on 01-09-2017
			actualQtyPending = actualQtyPending/mixtureQuantity; //added by amit das on 01-09-2017
			qtyPending=(qtyPending)/mixtureQuantity; //added by amit das on 01-09-2017
		}else{ 
			   var issueQty = parseInt(issueQty);
	    } 
		//alert("issueQty "+issueQty+" qtyPending 2 "+qtyPending);	//added by govind 04-01-2017 end
	 
	    if(issueQty<=stock){
			if( issueQty <=actualQtyPending || issueQty<=prescribedQty){
				var balanceQty;
				//added by amit das on 01-09-2017
				if(mixable=="Y"){
					//balanceQty = (actualQtyPending-issueQty)*mixtureQuantity;   Commented By Srikanth 27/09/2017
					balanceQty = (prescribedQty-issueQty)*mixtureQuantity;
				}else{
					//balanceQty = actualQtyPending-issueQty;     Commented By Srikanth 27/09/2017
					balanceQty = prescribedQty-issueQty;
				}
				// ended by amit on 01-09-2017
				document.getElementById('qtyPending'+inc).value=balanceQty;
		   }else{
				 alert("Issue Quantity can not greater than Balance Quantity");
	             document.getElementById('qtyIssued'+inc).value="";
	             //document.getElementById('qtyPending'+inc).value=actualQtyPending    Commented By Srikanth 27/09/2017
	             document.getElementById('qtyPending'+inc).value=prescribedQty;
	       }
	    }
	    else{
	    	alert("Issue Quantity can not greater than Stock Available");
	    	document.getElementById('qtyIssued'+inc).value="";
	    }
		
		if(issueQty>0){
			document.getElementById('notAvailable1'+inc).disabled = true;
			document.getElementById('notAvailable1'+inc).checked = false;
		}else{
			
			document.getElementById('notAvailable1'+inc).disabled = false;
			
			//var balQty= parseInt(actualQtyPending)+parseInt(issueQty);         Commented By Srikanth 27/09/2017
			var balQty= parseInt(prescribedQty)+parseInt(issueQty);
			document.getElementById('qtyPending'+inc).value= parseInt(balQty);
		}
		
	}else if(document.getElementById('qtyIssued'+inc).value==""){
		alert("Issue Quantity can not be Empty !");
    	document.getElementById('qtyIssued'+inc).value="";
    	document.getElementById('qtyPending'+inc).value=document.getElementById('qtyRequest'+inc).value;
    	document.getElementById('actualQtyPending'+inc).value=document.getElementById('qtyRequest'+inc).value;
	}
	
	  
}


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
	if(document.getElementById("notAvailable1"+rowVal).checked){
	document.getElementById('referToEmpanneled1'+rowVal).disabled = false;
	}
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
	
	 
var visitId=document.getElementById("visitId").value;
	
	var hinId=0;
	 var prescriptionDetailsId=document.getElementById("presId"+rowVal).value;
	 var itemId=document.getElementById("itemId"+rowVal).value;
		var prescriptionNo=document.getElementById("prescriptionId"+rowVal).value;
		hinId=prescriptionNo;
		
		var x = document.getElementById("referToEmpanneled1"+rowVal).checked;
		//alert("value of x--"+ x);
		if(x==true){
			//alert()
			submitProtoAjax('patientDrugIssue','stores?method=setForEmpanelled&itemId='+itemId+'&prescriptionDetailsId='+prescriptionDetailsId+'&prescriptionNo='+prescriptionNo+'&hinId='+hinId+'&emapelledReqQty='+emapelledReqQty+'&visitId='+visitId); 
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