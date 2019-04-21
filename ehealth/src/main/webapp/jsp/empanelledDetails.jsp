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
	<h2>EMPANELLED DISPENSING DETAILS</h2>
</div>
<form name="patientDrugIssue" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="clear"></div>

	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	int deptId = 0;
	int hospitalId = 0;
	String patientIssueNo="";
	int empanelledId=0;
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
	
	if(map.get("empanelledId") != null){
		empanelledId= (Integer)map.get("empanelledId");
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
	
	
	if(visit.getDoctor()!=null && !"".equals(visit.getDoctor().getEmployeeName())){
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
			type="hidden" name="<%=ISSUE_ID%>" id="issueId" value="" /> <input
			type="hidden" size="2" value="0" name="noOfRecords" id="noOfRecords" />



		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=regNo %></label> <label> Patient Name</label> <label
			class="value"><%=ptName %></label> <label> Age</label> <label
			class="value"><%=age %></label>

		<div class="clear"></div>

		<label> Doctor</label> <label class="value"><%=doctorName %></label> <label>
			Department</label> <label class="value"><%=department %></label> <label>
			Hospital Type</label> <label class="value"><%=visit.getHospital().getHospitalType().getHospitalTypeName() %></label>
		<div class="clear"></div>
		<label> Hospital</label><label class="value"><%=visit.getHospital().getHospitalName() %></label>
		<label> Gender</label> <label class="value"><%=sex %></label>
		<div class="clear"></div>




		<div class="clear"></div>
	</div>
	<!-- <label><h4>Doctor prescribed drug</h4></label> -->
	<div class="clear" style="padding-top: 40px"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<% int inc=1;
if(prescriptionDetailsList.size()>0){ %>

	<div class="tableHolderAuto" style="overflow: scroll;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>SI No.</th>
					<th>Item Code</th>
					<th>Item Name</th>
					<th>Prescribed Qty</th>
					<th>Issue Quantity</th>
					<th>Unit Rate</th>
					<th>Net amount</th>
				</tr>
				<%
		
		int temp=1;
		for(PatientPrescriptionDetails presdDetails:prescriptionDetailsList){
		String itemId="";
		int itemId1=0;
		String nomeclature="";
		String dosage="";
		String qty="";
		int noOfDays=0;
		float totalQty=0;
		String frequency="";
		BigDecimal qtyPending =new BigDecimal(0);
		BigDecimal totalQuantity =new BigDecimal(0);
 		if(presdDetails.getTotal()>0){
				totalQty=presdDetails.getTotal();
 			}
		  	totalQuantity=new BigDecimal(totalQty);

			if(presdDetails.getItem()!=null){
				nomeclature=presdDetails.getItem().getNomenclature();
				itemId1=presdDetails.getItem().getId();
				itemId=presdDetails.getItem().getPvmsNo();
			}
			if(presdDetails.getDosage()!=null){
				dosage=	String.valueOf(presdDetails.getDosage());
			}
			if(presdDetails.getNoOfDays()!=null){
				noOfDays=presdDetails.getNoOfDays();
			}
			if(presdDetails.getFrequency()!=null){
				frequency=presdDetails.getFrequency().getFrequencyName();
			}

 			int presId=0;
			presId=presdDetails.getId();
			
			int ppresId=0;
			ppresId=presdDetails.getPrescription().getId();
			
			float empRequestQty=0;
			 if(presdDetails.getEmpRequestQty()!=null){
				empRequestQty=presdDetails.getEmpRequestQty();
			} 
			
		%>
				<tr>
					<td width="5%"><input type="text" size="2" tabindex="1"
						value="<%=temp+inc%>" id="srNo<%=inc %>" /> <input type="hidden"
						name="visitId" value="<%=visitId%>" id="visitId<%=inc %>" validate="visitId,int,no"/> <input
						type="hidden" name="presId" value="<%=presId%>"
						id="presId<%=inc %>" validate="presId,int,no"/></td>
					<input type="hidden" name="ppresId" value="<%=ppresId%>"
						id="ppresId %>" validate=ppresId,int,no"/>
					</td>

					<td><input type="text" value="<%=itemId %>"
						id="itemId<%=inc %>" name="<%=ITEM_ID %>" validate="itemId,string,no"/> <input type="hidden"
						value="<%=itemId1 %>" id="itemsId<%=inc %>"
						name="<%=ITEMS_ID%><%=inc%>" validate="itemsId,int,no"/></td>

					<td><input type="text" size="50" value="<%=nomeclature%>"
						name="itemName" id="itemName<%=inc %>" readonly="readonly"
						tabindex=1 validate="itemName,string,no"/> <%
BigDecimal issuedQty= new BigDecimal(0);
if(presdDetails.getTotalStoreIssuedQty() !=null){
issuedQty=new BigDecimal(presdDetails.getTotalStoreIssuedQty());
}

qtyPending = totalQuantity.subtract(issuedQty) ;
%>
						<td><input type="text" value="<%=empRequestQty%>"
							name="<%=QTY_IN_REQUEST %><%=inc %>" id="qtyRequest<%=inc %>"
							readonly="readonly" tabindex=1 validate="qtyRequest,float,no"/></td>
						<td><input type="text" value=""
							name="<%=ISSUE_QUANTITY%><%=inc %>" id="issyeQty<%=inc %>"
							tabindex="1" onblur="checkIssueQty(<%=inc%>);"
							validate="Issued quantity,float,no" /></td>
						<td><input type="text" value=""
							name="<%=UNIT_RATE%><%=inc %>" id="unitRate<%=inc %>"
							tabindex="1" onblur="netamount(<%=inc%>);"
							validate="Unit Rate,float,no" /></td>
						<td><input type="text" value="" name="<%=netAmt%><%=inc %>"
							id="netAmt<%=inc %>" readonly="readonly"
							validate="Net Amount,float,no"></td>
				</tr>
				<%inc++; %>
				<%	}
		}//}%>
			</thead>
		</table>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" validate="counter,int,no"/>
	</div>

	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<label> Total Amount</label> <input type="text" name="totalValue"
		id="totalValue" value="" readonly="readonly" tabindex=1
		validate="Total Amount,float,no" onblur="checkDiscount();" /> <label>
		Discount %</label> <input type="text" name="discount" id="discount"
		value="0.0" tabindex=1 onblur="checkDiscount();" validate="discount,float,no"/> <label>
		Discount Amount</label> <input type="text" name="discountAmt" id="discountAmt"
		value="" tabindex=1 readonly="readonly" validate="discountAmt,float,no"/> <label>Total
		Net Amount</label> <input type="text" name="amt" id="amt" value=""
		readonly="readonly" tabindex=1 readonly="readonly"
		validate="Total Net Amount,float,no" /> <label> Received
		Amount</label> <input type="text" name="receivedAmt" id="receivedAmt" value=""
		tabindex=1 id="issueNo" validate="Received Amount,float,no" />


	<div class="division"></div>
	<div class="clear"></div>
	<!-- <input type="button" name="Submit11" class="button" value="Submit" onclick="submitForm('patientDrugIssue','stores?method=showPatientIssueEntryJsp');" /> -->
	<input type="button" name="Submit11" class="button" value="Submit"  onclick="submitForm('patientDrugIssue','stores?method=empanelledSave&empanelledId=<%out.print(empanelledId); %>');" />
	<input type="button" name="Submit11" class="button" value="Back"  onclick="BackToList();" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="bottom">
		<div class="clear"></div>
		<div class="clear"></div>
	</div>
</form>

<script type="text/javascript">

function BackToList()
{
	var empanelledId = <% out.print(empanelledId);%>;
	window.location ="stores?method=empanelled&empanelledId="+empanelledId;
}

function checkIssueQty(rowVal)
{
	 var issyeQty=document.getElementById("issyeQty"+rowVal).value
	var qtyRequest=document.getElementById("qtyRequest"+rowVal).value
	
	 issyeQty=parseInt(issyeQty)
	 qtyRequest=parseInt(qtyRequest)
	
	if(issyeQty>qtyRequest)
		{
		alert("issue quantity cant greater than prescribed qty");
		document.getElementById("issyeQty"+rowVal).value=""
		return false
		} 
	
	}


function checkDiscount(){
	var re =/^\d{0,2}(\.\d{0,2}){0,1}$/;             
	var discount=document.getElementById("discount").value;
	if(!discount.match(re) && isNaN(discount)){
		alert("please enter valid discount");
		document.getElementById("discountAmt").value="";
			document.getElementById("amt").value="";
		return false
	}
	
	var totAmount=document.getElementById("totalValue").value;
	
	var disAmt=(parseFloat(totAmount)*parseFloat(discount))/100;
	document.getElementById("discountAmt").value=disAmt;
	document.getElementById("amt").value=parseFloat(totAmount)-parseFloat(disAmt);
	
	
	
	
}

function netamount(rowVal)
{
	 var issyeQty=0;
	 var unitRate=0;
	 if(document.getElementById("issyeQty"+rowVal).value!="" && !isNaN(document.getElementById("issyeQty"+rowVal).value)){
		 issyeQty=document.getElementById("issyeQty"+rowVal).value;
	 }if(document.getElementById("unitRate"+rowVal).value!="" && !isNaN(document.getElementById("issyeQty"+rowVal).value)){
		 unitRate=document.getElementById("unitRate"+rowVal).value;
	 }
 	 
	 document.getElementById("netAmt"+rowVal).value= parseInt(unitRate)* parseInt(issyeQty);
	  var amount=parseInt(0);
	  var counter=parseInt(0);
	  var netamount=parseInt(0);
	  
	  var finalamt=parseInt(0);
	  
	 for(var i=1;i<=parseInt(rowVal);i++)
	 {
	   netamount=document.getElementById("netAmt"+i).value;
	   amount=parseInt(netamount)+parseInt(amount);
	   counter++;
	 }
	 document.getElementById("totalValue").value=parseInt(amount);
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