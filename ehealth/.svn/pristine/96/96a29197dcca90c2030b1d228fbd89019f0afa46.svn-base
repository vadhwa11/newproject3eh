<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.net.URL"%>
<script type="text/javascript">
<%
	Map map = new HashMap();
	int resultId=0;
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}
	if(map.get("resultId") != null)
	{
	resultId=(Integer)map.get("resultId");
	}
%>

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
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	///List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String deptType="";
	String deptName ="";
	
	if(map.get("pageNo") != null){
	pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	
	if(session.getAttribute("deptType") != null){
	deptType = (String)session.getAttribute("deptType");
	}
	
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
	
	List<DgResultEntryDetailSen> dgResultEntryDetailSenList =new ArrayList<DgResultEntryDetailSen>();
	
	if(map.get("dgResultEntryDetailSenList") !=null){
	dgResultEntryDetailSenList=(List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
	}
	List<DgMasOrganismGroup> dgMasOrganismGroupList =new ArrayList<DgMasOrganismGroup>();
	
	if(map.get("dgMasOrganismGroupList") !=null){
	dgMasOrganismGroupList=(List<DgMasOrganismGroup>)map.get("dgMasOrganismGroupList");
	}
	
	List<DgMasOrganism> dgMasOrganismList =new ArrayList<DgMasOrganism>();
	if(map.get("dgMasOrganismList") !=null){
	dgMasOrganismList=(List<DgMasOrganism>)map.get("dgMasOrganismList");
	}
	List<MasAntibioticLab> masAntibioticLabList =new ArrayList<MasAntibioticLab>();
	
	if(map.get("masAntibioticLabList") !=null)
	{
	masAntibioticLabList=(List<MasAntibioticLab>)map.get("masAntibioticLabList");
	}
	try{
	if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	
	Set<DgResultEntryDetailSen> dgResultDtSenSet = new HashSet<DgResultEntryDetailSen>();
	for(DgResultEntryHeader dgResultHeader : resultList){
	dgResultDtSenSet = dgResultHeader.getDgResultEntryDetailSens();
	}
	DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	int hinId = 0;
	if(resultList != null){
	
	dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
	if(dgResultEntryHeader.getHin() != null){
	hinId =dgResultEntryHeader.getHin().getId();
	}
	}
	DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
	DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
	
	if(resultList != null){
	dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	}
	session.setAttribute("dgResultEntryHeader",dgResultEntryHeader);
	session.setAttribute("dgResultDtSenSet",dgResultDtSenSet);
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
<form name="sensitivityValidation" method="post" action="">
<div class="titleBg">
<h2>Result Validation</h2>
</div>
<div class="clear"></div>
<%
	String subDept = "";String dept="";
	int SubChargeId=0;
	int mainChargeId=0;
	//for(DgResultEntryDetail dgDetail :dgResultDtSet){
	if(dgresultHeader != null){
	subDept = dgresultHeader.getSubChargecode().getSubChargecodeName();
	dept = dgresultHeader.getMainChargecode().getMainChargecodeName();
	SubChargeId=dgresultHeader.getSubChargecode().getId();
	mainChargeId=dgresultHeader.getMainChargecode().getId();
}
//}%>
<div class="Block"><label class="auto"> Department</label> <label
	class="valueAuto" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>

<label class="auto">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueAuto"><%=subDept%></label>

<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <label class="auto">Order
Date</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="valueAuto"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %> <label class="auto">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %> <label class="auto">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %> <label class="auto">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" /> <!--Block Two Starts--> <%

String patientName = "";
String age = "";
String sex = "";
String hinNo = "";
String currentAge = "";
String maritalStatus = "";
Set<DgOrderdt> set = new HashSet<DgOrderdt>();
for(DgResultEntryDetailSen dgResultEntryDetailSen :dgResultDtSenSet){
set = dgResultEntryDetailSen.getSampleCollection().getSampleCollectionHeader().getOrder().getDgOrderdts();
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
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" />
<div class="Block"><label class="auto">HIN</label> <label
	class="valueAuto"><%=hinNo%></label> <label class="auto">Patient
Name</label> <label class="valueAuto"><%=patientName%></label> <label
	class="auto">Sex</label> <label class="valueAuto"><%= sex%></label> <label
	class="auto">Age</label> <label class="valueAuto"><%=currentAge%></label>

<label class="auto">Marital Status</label> <label class="valueAuto"><%=maritalStatus%></label>
<div class="clear"></div>

</div>
<%if(dgResultEntryHeader.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" />


<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>Report Details</h4>
<div class="clear"></div>
<div class="Block"><label>Report Date</label> <%if(dgresultHeader.getResultDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Report Time</label>
<%if(dgresultHeader.getResultTime()!= null){ %> <label class="value"><%=dgresultHeader.getResultTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Report
Prepared By</label> <%if(dgresultHeader.getEmployee() != null) {%> <input
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
<label>Report Validated Date</label> <label class="value"><%=date%></label>


<label>Report Validated Time</label> <label class="value"><%=time%></label>


<label><span>*</span> Report Validated By</label> <select
	id="<%=RESULT_VALIDATED_BY %>" name="<%= RESULT_VALIDATED_BY %>"
	validate="Validated By,string,yes" tabindex=1>
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
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
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


<div class="paddingTop15"></div>
<div class="clear"></div>


<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Diag. No.</th>
		<%}else{  %>
		<th width="7%">Radio Id.</th>
		<%} %>
		<th width="7%">Service</th>
		<th width="4%">Validated</th>

		<% int i =0;

%>

		<tr>
			<td>
			<%if(dgResultEntryDetailSenList.get(0).getSampleCollection() != null){ %>
			<label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %>><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getDiagNo()%></label>
			<%} else{%> <label name="<%=DIAGNOSIS_NO %>" id=<%=DIAGNOSIS_NO %>><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getDiagNo()%></label>
			<%} %>
			</td>
			<td width="7%"><input name="resultType" type="hidden" size="10"
				value="" readonly /> <%if(dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation() !=null){  %>
			<input name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation().getId() %>"
				readonly /> <label name="chargeCode" type="text" size="10"><%=dgResultEntryDetailSenList.get(0).getSampleCollection().getInvestigation().getInvestigationName()%></label>
			<%}else { %> <label name="chargeCode" type="text" size="10"></label> <%} %>
			</td>
			<td width="4%"><input id="checkId" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
		</tr>
</table>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<%if(dgResultEntryDetailSenList.get(0).getGrowthOption().equalsIgnoreCase("g")){ %>

<jsp:include page="sensitivityListJsp.jsp"></jsp:include>
<div class="clear"></div>

<%}else{%>
<div id="otherDiv">
<div class="clear"></div>
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 1</th>

	</tr>
	<tr>
		<td><textarea name="result1" id="result1"
			onkeyup="chkLength(this,100);"><%= dgResultEntryDetailSenList.get(0).getResult()%></textarea>
		</td>

	</tr>

</table>
</div>
<script type="text/javascript">
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
alert('you crossed the maximum limit of '+maxLimit+' characters');
var val=field.value.substring(0,maxLimit);
field.value=val;
//alert(field.value);
}
}
</script>

<div class="clear"></div>
<div class="paddLeft35">
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 2</th>
	</tr>
	<tr>
		<td><textarea name="result2" onkeyup="chkLength(this,100);"><%=dgResultEntryDetailSenList.get(0).getResultOther() %></textarea>
		</td>
	</tr>
</table>
</div>
</div>
</div>

<%}%>
<div class="division"></div>
<div class="clear"></div>
<input name="growthOption" type="hidden"
	value="<%=dgResultEntryDetailSenList.get(0).getGrowthOption()%>" />
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Remarks</th>
	</tr>
	<tr>
		<td><textarea name="remarks" onkeyup="chkLength(this,100);"><%=dgResultEntryHeader.getRemarks()%></textarea></td>
	</tr>
</table>
</div>


<div class="paddLeft35">
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col" colspan="2">NOSOCOMIAL</th>

	</tr>
	<tr>
		<td>Yes <%if(dgResultEntryDetailSenList.get(0).getNosocomial().equalsIgnoreCase("y")){ %>
		<input type="radio" class="radioCheck" name="NOSOCOMIAL" value="Y"
			checked="checked"> <%}else{ %> <input type="radio"
			class="radioCheck" name="NOSOCOMIAL" value="Y" /> <%} %>
		</td>
		<td>No <%if(dgResultEntryDetailSenList.get(0).getNosocomial().equalsIgnoreCase("n")){ %>
		<input type="radio" class="radioCheck" name="NOSOCOMIAL" value="N"
			checked="checked" /> <%}else{ %> <input type="radio"
			class="radioCheck" name="NOSOCOMIAL" value="N" /> <%} %>
		</td>
	</tr>
</table>

</div>
</div>



<!-- end -->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit"
	onclick="if(inputValidate()){submitForm('sensitivityValidation','investigation?method=submitResultValidationForSensitivity')};"
	align="right" /> <input name="Button" type="button"
	class="buttonHighlight" value="Reset" onclick="resetResult();" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
