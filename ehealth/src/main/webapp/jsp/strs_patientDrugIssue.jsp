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
<h2>Patient Issue Entry</h2>
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
	regNo=visit.getHin().getHinNo();
	visitId=visit.getId();
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
<input	type="hidden" name="visitId" value="<%=visit.getId()%>"  />
<input	type="hidden" name="deptId" value="<%=deptId%>" />
<input	type="hidden" name="hospitalId" value="<%=hospitalId%>"/>
<input	type="hidden" name="hinId" value="<%=visit.getHin().getId()%>"/>
<input type="hidden" name="<%=ISSUE_ID%>" id="issueId" value="" />
<input type="hidden" size="2" value="0" name="noOfRecords"	id="noOfRecords" />
<label> Issue No.</label>
<input type="hidden" name="issueNo" value="<%=patientIssueNo %>" tabindex=1 id="issueNo" />
<label  class="value"><%=patientIssueNo %></label>

<label> Issue Date</label>
<input type="hidden" name="<%=ISSUE_DATE %>" value="<%=currentDate %>" id="issueDate"/>
<label  class="value"><%=currentDate %></label>

<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value"><%=regNo %></label>

<label> Patient Name</label>
<label class="value"><%=ptName %></label>

<div class="clear"></div>

<label> Age</label>
<label class="value"><%=age %></label>

<label> Sex</label>
<label class="value"><%=sex %></label>

<div class="clear"></div>

<label> Diagnosis</label>
<label class="value"><%=diagnosis %></label>
<label> Department</label>
<label class="value"><%=department %></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<label><h4>Last Issue Drug Details</h4></label>

<div class="clear"></div>
<%if(visitList.size()>0){ %>
<div class="tableSmall floatLeft">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<thead>
		<tr>
			<th>Visit Date</th>
			</tr>
</thead>
	<%
	int i = 1;
	String visitDate=null;
	for (Iterator iterator = visitList.iterator(); iterator.hasNext();) {
		Object[] objects = (Object[]) iterator.next();

	//}

	//for(StoreIssueT issueT :alreadyissuedDrugList){
		if(objects[1]!=null){
			visitDate=HMSUtil.convertDateToStringTypeDateOnly((Date)objects[1]);
		}
		//visitDate=""+objects[1];
%>
		<tr>
			<td>
			<input type="text" id="visitDate<%=i %>" name="visitDate" value="<%=visitDate %>"
			  onclick="setIssueId(<%=objects[0]%>);submitProtoAjaxWithDivName('patientDrugIssue','/hms/hms/stores?method=viewIssuedDrug','testDiv');"/>
			</td>
		</tr>

		<%
		 i++;
			} %>
		<input type="hidden" value="0" name="issuedMId"  id="issuedMId" />
		<input type="hidden" name="counter1" id="counter1" value="<%=i %>"/>

<script type="text/javascript">
function setIssueId(val){
					document.getElementById('issuedMId').value=val;
				}
</script>

</table>
</div>
<%}else{ %>
<label class="auto">Drug Not issued previously </label>
<%} %>
<div id="testDiv">

</div>
<div class="clear"></div>
<label><h4>Doctor prescribed drug</h4></label>
<div class="clear"></div>
<%
if(prescriptionDetailsList.size()>0){ %>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th> Sr No.</th>
			<th> Drug Name</th>
			<th> Dose</th>
			<th> Frequency</th>
			<th> Days</th>
			<th> Qty Requested</th>
			<th> Pending Qty</th>
			<th> Qty Issue</th>
			<th> Issue</th>
		</tr>
		<%
		int inc=0;
		int temp=1;
		for(PatientPrescriptionDetails presdDetails:prescriptionDetailsList){
		int itemId=0;
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
				itemId=presdDetails.getItem().getId();
			}
			if(presdDetails.getDosage()!=null){
				dosage=	presdDetails.getDosage();
			}
			if(presdDetails.getNoOfDays()!=null){
				noOfDays=presdDetails.getNoOfDays();
			}
			if(presdDetails.getFrequency()!=null){
				frequency=presdDetails.getFrequency().getFrequencyName();
			}

 			int presId=0;
			presId=presdDetails.getId();
		%>
 		<tr>
		<td width="5%"><input type="text" size="2" tabindex="1"	value="<%=temp+inc%>" id="srNo<%=inc %>"/>
		<input	type="hidden" name="visitId" value="<%=visitId%>" id="visitId<%=inc %>"/>
		<input	type="hidden" name="presId" value="<%=presId%>" id="presId<%=inc %>"/></td>
		<td>
		<input type="text" size="50" value="<%=nomeclature%>" name="itemName" id="itemName<%=inc %>" readonly="readonly" tabindex=1/>
		<input type="hidden" value="<%=itemId %>" id="itemId<%=inc %>" name="<%=ITEM_ID %>" /></td>
		<td><input type="text" value="<%=dosage %>" name="dose" id="dose<%=inc %>"readonly="readonly" tabindex=1/></td>
		<td><%=frequency%></td>
		<td><input type="text" value="<%=noOfDays %>" name="days" id="days"readonly="readonly" tabindex=1/></td>
<%
BigDecimal issuedQty= new BigDecimal(0);
if(presdDetails.getIssuedQty() !=null){
issuedQty=presdDetails.getIssuedQty();
}

qtyPending = totalQuantity.subtract(issuedQty) ;
%>
		<td><input type="text" value="<%=totalQty %>" name="<%=QTY_IN_REQUEST %>" id="qtyRequest<%=inc %>" readonly="readonly" tabindex=1/></td>
		<td><%=qtyPending %></td>
		<td><input type="text" value="" name="<%=QTY_ISSUED %>" id="qtyIssued<%=inc %>" readonly="readonly" tabindex="1"/></td>
		<td width="5%">

		<%

		 if(issuedQty.intValue()>0){ 	%>
		<input type="buttonAuto" class="buttonHighlight"  id="issuebutton" tabindex="1" name="Submit2" onblur="checkItemIssue(this.value);"
			value="Already Issued" disabled="disabled"/>
				 <%}else{%>
				 <input type="button"class="buttonIssue" tabindex="1" name="Submit2" onblur="checkItemIssue();"
				 	onclick="openPopupForItemIssueForPatient(this.value,document.getElementById('qtyRequest<%=inc %>').value,<%=inc%>,'','');"/>
			<%} %></td>

		</tr>
		<%inc++; %>
	<%	}
		}//}%>
	</thead>
	</table>
	</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit11" class="button" value="Next Patient" onclick="submitForm('patientDrugIssue','stores?method=showPatientIssueEntryJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="bottom">
<div class="clear"></div>
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<script type="text/javascript">
			function checkItemIssue(){
	<%
		if(alreadyissuedDrugList != null && alreadyissuedDrugList.size() > 0){
				for (StoreIssueT storeIssueT : alreadyissuedDrugList) {%>
								var invObj =<%= storeIssueT.getItem().getId()%>
								var itemId=document.getElementById('itemId').value
								if(invObj==itemId ){
								alert("Drug is already issued in previous visit...");
 							}
 							<%}}%>
 							}


 	</script>