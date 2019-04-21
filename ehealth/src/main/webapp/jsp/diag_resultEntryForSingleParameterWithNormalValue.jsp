<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript">
 function resetResult(){
 
	   document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	Map detailsMap = new HashMap();
	String userName = "";
	String deptName ="";
	String deptType="";
	int deptId =0;
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	try{
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	Patient patient = new Patient();
	int hinId=0;
	 if(sampleCollectionList != null && sampleCollectionList.size()>0){
		 dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
				patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
				if(dgDetails.getSampleCollectionHeader().getHin() != null){
				hinId=  dgDetails.getSampleCollectionHeader().getHin().getId();
				}
	 }
%>

<script>
function inputResult(){
var result;
result = document.getElementById('result').value;
if(result == ""){;
  alert("Please Enter The Result. ")
 	}else{
			return true;
			}
		}
   
</script>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post" action="">
<div class="titleBg">
<h2>Result Entry</h2>
</div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
		
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation()!= null){
	subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
	dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
	SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
	mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
	//hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
    hinId = dgCollection.getSampleCollectionHeader().getHin().getId();
	DgSampleCollectionHeader sampleHeader = dgCollection.getSampleCollectionHeader();
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	set = dgCollection.getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId();
		currentAge = HMSUtil.calculateAgeForADT(age, sampleHeader.getHin().getRegDate());
		if(billHeader.getHin().getMaritalStatus() != null){
		maritalStatus = billHeader.getHin().getMaritalStatus().getMaritalStatusName();
		}
		}else {
			patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
			currentAge=billHeader.getAge();
			hinNo="--";
			maritalStatus="--";
		}
		}
	else{
		DgOrderhd  orderhd = orderDt.getOrderhd();
		if(orderhd.getHin() != null){
			patientName=orderhd.getHin().getPFirstName();
			age=orderhd.getHin().getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, orderhd.getHin().getRegDate());
			if(orderhd.getHin().getMaritalStatus() != null){
				maritalStatus = orderhd.getHin().getMaritalStatus().getMaritalStatusName();
				}
			sex=orderhd.getHin().getSex().getAdministrativeSexName();
			hinNo=orderhd.getHin().getHinNo();
		}
	}
}
}
} %>
<div class="clear"></div>
<div class="Block"><label class="NoWidth"> Department</label> <label
	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <input
	name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>" type="hidden"
	value="<%= deptId %>" /> <label class="NoWidth">Sub Department</label>
<label class="value" name="<%=SUB_CHARGECODE_NAME %>"><%=subDept%></label>
<input name="<%= SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID %>"
	type="hidden" value="<%= SubChargeId %>" /> <input
	name="<%= MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID %>"
	type="hidden" value="<%= mainChargeId %>" /> <label class="NoWidth">Order
No.</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{%> <label class="value">-</label> <%}%> <label class="NoWidth">Order
Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>

<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" /> <!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> HIN</label> <%if(hinNo != null){ %> <label class="value"><%=hinNo%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Patient
Name</label> <label class="value"><%=patientName%></label> <label> Sex</label> <label
	class="value"><%=sex %></label>
<div class="clear"></div>
<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label> Marital
Status</label> <%if(maritalStatus !=null){ %> <label class="value"><%=maritalStatus%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="clear"></div>

<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />

<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}%>
</div>

<!--Block Two Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>

<!-- Block Three Starts -->

<h4>Result Details</h4>
<div class="clear"></div>
<div class="Block"><label class="noWidth">&nbsp;&nbsp;Result
Date</label> <label class="value"><%=date%></label> <label class="noWidth">Result
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />
<%
	 String resultSeqNo="";
		if(map.get("resultSeqNo") != null){
			resultSeqNo = (String)map.get("resultSeqNo");
		}
	%> <input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
	title="Result No." /> <label class="noWidth">Result Prepared
By</label> <select name="<%= RESULT_ENTERED_BY %>"
	validate="Result Entered By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId = null;
			if(user!=null && user.getEmployee()!=null)
				userId = user.getEmployee().getId();
				
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) || masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId!=null && userId.equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}}}	%>
</select>
<div class="clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %> <label class="noWidth">Sample
Validated Date</label> <%}else{ %> <label class="noWidth">Radio Collection
Date</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated Time</label> <%}else{ %> <label
	class="noWidth">Radio Collection Time</label> <%}%> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated By</label> <%}else{ %> <label
	class="noWidth">Radio Collected By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+dgDetails.getSampleCollectionHeader().getValidatedBy().getMiddleName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value"> -</label> <%} %>
<div class="clear"></div>
<label>Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>
<div class="clear"></div>
</div>

<div class="clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->
<div class="clear"></div>
<div class="division"></div>
<table border="0" cellspacing="0" width="100%" cellpadding="0">

	<tr>

		<th width=7%>S.No.</th>
		<th scope="col">Test Name</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Sample</th>
		<%} %>
		<th scope="col">Result</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">UOM</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th scope="col">Normal Range</th>
		<%} %>

		<%
			
		Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
   		 DgMasInvestigation masInv = new DgMasInvestigation();
		String charge="";
		String resultType="";
		int chargeId=0;
       	int i =0;
		for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
			masInv = dgCollection.getInvestigation();
			if(dgCollection.getInvestigation().getChargeCode()!= null){
			charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
			chargeId=dgCollection.getInvestigation().getChargeCode().getId();
			resultType = dgCollection.getInvestigation().getInvestigationType();
			}
			i++;
	%>

		<tr>

			<td><input type="text" readonly="readonly" size="2"
				class="readOnly" name="<%=SR_NO%>" value="<%=i%>" /></td>
			<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
				value="s" type="hidden"><input name="<%=INVESTIGATION_ID %>"
				id="<%=INVESTIGATION_ID %>"
				value=<%= dgCollection.getInvestigation().getId()%> type="hidden"><input
				name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
				value=<%= chargeId%> type="hidden"><input
				name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
				value=<%= dgCollection.getId()%> type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){%>
			<input name="<%=INVESTIGATION_NAME %>" type="text" class="readOnly"
				readonly="readonly" size="15"
				value="<%=dgCollection.getInvestigation().getInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=INVESTIGATION_NAME %>"
				type="text" class="readOnly" readonly="readonly" size="15" value=""
				readonly /> <%} %>
			</td>

			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getSample() !=null){ %> <input
				type="hidden" name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID %>"
				value="<%=dgCollection.getInvestigation().getSample().getId() %>" />
			<input name="<%=SAMPLE_NAME %>" type="text" class="readOnly"
				readonly="readonly" size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription() %>"
				readonly /> <%}else { %> <input name="<%=SAMPLE_NAME %>" type="text"
				class="readOnly" readonly="readonly" size="10" value="-" readonly />
			<%} %>
			</td>
			<%} %>
			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %>"><input type="text"
				name="<%=RESULT %>" id="<%=RESULT %>" value="" maxlength="50"></td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getUom() !=null){ %> <input
				type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID%>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>"
				value="<%=dgCollection.getInvestigation().getUom().getId() %>" /> <input
				name="uomName" type="text" class="readOnly" readonly="readonly"
				size="8"
				value="<%=dgCollection.getInvestigation().getUom().getUomName() %>"
				readonly /> <%}else { %> <input name="uomName" type="text"
				class="readOnly" readonly="readonly" size="8" value="" readonly
				value="-" /> <%} %>
			</td>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getInvestigation().getNormalValue() != null || dgCollection.getInvestigation().getMinNormalValue() != null || dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<%if(dgCollection.getInvestigation().getNormalValue() != null ){ 
				if(!dgCollection.getInvestigation().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getNormalValue()%>"
				readonly /> <%}else if (dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				class="readOnly" size="8"
				value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
				name="normalValue" type="text" class="readOnly" size="8" value=""
				readonly /><label>-</label> <%} %>
			</td>
			<%} %>

		</tr>
</table>


<div class="clear"></div>
<label class="common">Additional Remarks</label> <%if(dgCollection.getRemarks() != null){ %>
<textarea value="<%=dgCollection.getRemarks() %>" class="large"
	maxlength="200" onkeyup="return ismaxlength(this)"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
<%}else{ %> <textarea value="" maxlength="200" class="large"
	onkeyup="return ismaxlength(this)" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %> <%} %>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(inputResult()){submitForm('sampleCollection','investigation?method=submitResultEntryForSingleParameterWithNormalValue');}"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="resetResult();" />
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels ends-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--main content placeholder ends here-->
