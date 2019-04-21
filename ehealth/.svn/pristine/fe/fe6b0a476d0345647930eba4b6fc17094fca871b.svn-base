<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>

<script type="text/javascript">

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
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	///List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
    DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	MasRank masRank = new MasRank();
	String admissionNumber = "";
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	String number="";
	if(resultList != null)
	{
		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		hinId =dgResultEntryHeader.getHin().getId();
		inpatientSet=dgResultEntryHeader.getHin().getInpatients();
	}
	    MasDepartment masDepartment=new MasDepartment();
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
	 if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	 }
	 session.setAttribute("dgResultEntryHeader",dgResultEntryHeader);
	 session.setAttribute("dgResultDtSet",dgResultDtSet);
	 
	 Properties properties = new Properties();
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	 try {
	 	properties.load(resourcePath.openStream());
	 	} catch (Exception e) {
	 	e.printStackTrace();
	 }
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
<!--main content placeholder starts here-->
<form name="sampleCollection" method="post" action="">
<div class="titleBg">
<h2>Result Validation</h2>
</div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%> <%
 	}
 	}%>
<div class="clear"></div>
<div class="Block"><label class="common"> Department</label> <label
	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <label
	class="noWidth">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%></label> <input
	name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <label class="NoWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>

<div class="paddLeft25"><label class="NoWidth">Order Date</label></div>
<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div>
<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" />
<div class="paddingTop15"></div>
<%
		
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	for(DgResultEntryDetail dgResultEntryDetail :dgResultDtSet){
	set = dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId();
		currentAge = HMSUtil.calculateAgeForADT(age, dgresultHeader.getHin().getRegDate());
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
		}else{
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
 %> <!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=hinId %>" />
<div class="clear"></div>
<label>HIN</label> <label class="value"><%=hinNo%></label> <label>Patient
Name</label> <label class="value"><%=patientName%></label> <label
	class="noWidth">Sex</label> <label class="value"><%= sex%></label>
<div class="clear"></div>
<label>Age</label> <label class="value"><%=currentAge%></label> <label>Marital
Status</label> <label class="value"><%=maritalStatus%></label>
<div class="clear"></div>

</div>

<%if(dgResultEntryHeader.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <!--Block Two Ends-->
<div class="paddingTop15"></div>
<!-- Block Three Starts -->
<h4>Result Details</h4>
<div class="clear"></div>
<div class="Block"><label>&nbsp;&nbsp;Report Date</label> <%if(dgresultHeader.getResultDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Report Time</label>
<%if(dgresultHeader.getResultTime()!= null){ %> <label class="value"><%=dgresultHeader.getResultTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Report
Prepared By:</label> <%if(dgresultHeader.getEmployee() != null) {%> <input
	type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <label
	class="value"> <%=dgresultHeader.getEmployee().getFirstName()+" "+dgresultHeader.getEmployee().getMiddleName()+" "+dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
-</label> <%} %> <input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" />
<div class="clear"></div>
<label>&nbsp;&nbsp;Report Validated Date</label> <label class="value"><%=date%></label>
<label class="noWidth">&nbsp;&nbsp;Report Validated Time</label> <label
	class="value"><%=time%></label> <label>Report Validated By</label> <select
	id="<%=RESULT_VALIDATED_BY %>" name="<%= RESULT_VALIDATED_BY %>"
	validate="Validated By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}	}}%>
</select>


<div class="clear"></div>
<label>Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueFixedWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueFixedWidth">-</label> <%} %>
<div class="clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<script>
function inputValidate(){

obj = document.getElementById('checkId');

if(!obj.checked){;
  alert("Please Validate The Report ")
 	}else{
			return true;
			}
				}
   
</script> <script>

function resetResult(){
	document.getElementById('additionalRemarks').value="";
	document.getElementById('abc').value = "";
	}
</script> <!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->
<div class="clear"></div>
<div class="division"></div>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<th width="7%">Test Name</th>
		<th width="4%">Validated</th>

		<% int i =0;
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    i++;
    %>

		<tr>
			<td width="7%"><input name="resultType" type="hidden" size="10"
				value="<%=dgDetail.getResultType() %>" readonly /> <%if(dgDetail.getInvestigation() !=null){ %>
			<input name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly
				class="readOnly" /> <input type="text" name="chargeCode" size="10"
				value="<%=dgDetail.getInvestigation().getInvestigationName()%>"
				readonly class="readOnly" /> <%}else { %> <input type="text"
				name="chargeCode" size="10" value="" readonly class="readOnly" /> <%} %>
			</td>
			<td width="4%">
			<% if(dgDetail.getValidated() != null) {%> <input id="checkId"
				name="<%=VALIDATED %>" type="checkbox" checked="true" class="check" />
			<%}else{ %> <input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /> <%} %>
			</td>
		</tr>
</table>

<div class="clear"></div>

<!--Abha--> <label class="noWidth">Report</label>
<div class="clear"></div>
<!--Rich text editor--> <label>&nbsp;</label> <%if(dgDetail.getResult() != null){ %>
<textarea class="large2" id="abc" name="test2"
	class="tableTextareaEditor"><%=new String(dgDetail.getResult()) %>  </textarea>
<%}else{ %> <textarea class="large2" value="" id="abc" name="test2"
	class="tableTextareaEditor">  </textarea> <%} %>


<div class="clear"></div>
<label>Additional Remarks</label> <%if(dgDetail.getRemarks() != null){ %>
<textarea class="large" value="<%=dgDetail.getRemarks() %>"
	maxlength="200" onkeyup="return ismaxlength(this)"
	id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea class="large" value="" maxlength="200"
	onkeyup="return ismaxlength(this)" id="<%=ADDITIONAL_REMARKS %>"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <%} %>

<div class="clear"></div>

<label class="noWidth">Film Size Used</label> <%if(dgDetail.getFilmSize() != null){ %>
<label class="value"><%=dgDetail.getFilmSize() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label class="noWidth">Film Used</label> <%if(dgDetail.getFilmUsed() != null){ %>
<label class="value"><%=dgDetail.getFilmUsed() %></label> <%}else{ %> <label
	class="value">-</label> <%} }%> <!-- Table Ends -->

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultValidationForTemplate')};"
	align="right" /> <input type="reset" name="Reset" value="Reset"
	class="buttonHighlight" onclick="resetResult();" /> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels ends--> <!--main content placeholder ends here-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
