<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>


<%@page import="java.net.URL"%>
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
<%

Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String dateCal=String.valueOf(calendar.get(Calendar.DATE));
int year = calendar.get(calendar.YEAR);
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
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
utilMap = (Map <String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(request.getAttribute("map") != null){
map = (Map<String,Object>) request.getAttribute("map");
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
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
if(map.get("employeeList") != null){
employeeList = (List<MasEmployee>)map.get("employeeList");
}


try{
if(map.get("sampleCollectionList") != null){
sampleCollectionList=(List)map.get("sampleCollectionList");
}
}catch(Exception e){
e.printStackTrace();
}
List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
try{
	if(map.get("fixedValList") != null){
		fixedValList=(List<DgFixedValue>)map.get("fixedValList");
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
	try{
		if(map.get("subList") != null){
			subList=(List)map.get("subList");
		}
		}catch(Exception e){
		e.printStackTrace();
		}

DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
Patient patient = new Patient();
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
}
String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
if(sampleCollectionList != null && sampleCollectionList.size()>0){
	 dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
			patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
}
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
function inputResultValue(){
		for(var i = 0; i < document.getElementsByName('result').length; i++){
			if(document.getElementsByName('result')[i].value != "" && document.getElementsByName('result')[i].value != 0)
              {
       			return true;
			  }		
  		}
  		alert("Please Enter The Result.")
		return false;
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
  } %>
<div class="clear"></div>
<div class="Block"><label class="common">Department</label> <label
	name="<%=MAIN_CHARGECODE_NAME %>" class="value"><%=deptName%> </label>
<input name="<%=DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID%>" type="hidden"
	value="<%=deptId %>" /> <label class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%> </label> <input
	name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %>
<label class="NoWidth">Order No.</label> <label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label class="NoWidth">Order Date</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="medium">Order
By</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /></div>
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

<!--Block Two Ends--> <!-- Block Three Starts -->
<h4>Report Details</h4>
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
	title="Result No." /> <label>Result Prepared By</label> <select
	name="<%= RESULT_ENTERED_BY  %>" tabindex=1>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if((masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical)) || (masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) ){
						if (userId .equals(masEmployeecode.getId())) {
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
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate() )%></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated Time</label> <%}else{ %> <label
	class="noWidth">Radio Collection Time</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label class="noWidth">Sample Validated By</label> <%}else{ %> <label
	class="noWidth">Radio Collected By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value"> -</label> <%} %>
<div class="clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>

<div class="clear"></div>

</div>
<div class="division"><input type=hidden value=0 name=pagecounter2 />
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->

<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Sample</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
		<th scope="col">Additional Remarks</th>
	</tr>
	<tbody>
		<!--  for increment of rows  -->
		<%
int inc =0;   
 
%>
		<!--  end of increment code  -->
		<!-- for getting sets  -->
		<%
	Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	for(DgSampleCollectionDetails dgDet :sampleCollectionList)
	{
		for(DgSubMasInvestigation dgCollection : subList){		
	normalSet = dgCollection.getDgNormalValues();
%>

		<!--  if condition when result type is heading and comaprison type is none -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("h")&& dgCollection.getComparisonType().equalsIgnoreCase("n")) { %>
		<tr>


			<td>
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				type="hidden" value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<label name="<%=SUBTEST_NAME %>" class="heading"><%=dgCollection.getSubInvestigationName()%></label>
			<input name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <label class="heading"
				name="<%=SUBTEST_NAME %>">-</label> <%} %>
			</td>

			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %>" value=""
				type="hidden" /> <label>-</label></td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
				name="<%=RESULT%>" id="<%=RESULT %><%=inc %>" value="" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /> <label>-</label></td>

			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" value="" type="hidden" /> <label>-</label></td>


			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>


			<td><input type="hidden" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <label>-</label>
			</td>
		</tr>
		<%} %><!-- end of if condition when result type is heading and comaprison type is none -->

		<!-- if condition when result type is single parameter and comparison type is none -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("n")){%>

		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>"
				readonly="readonly" /> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value=<%= dgCollection.getId()%>
				type="hidden" /> <input name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly="readonly" />
			<%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly="readonly" /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-"
				readonly="readonly" /> <%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly="readonly" />
			<%}else{ %> <input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value=""
				readonly="readonly" /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>

			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is single parameter and comparison type is none -->

		<!-- if condition when result type is   text and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("n")){%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>


			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is text and comparison type is none -->

		<!-- if condition when result type is   text Area and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("n")){%>

		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <textarea value=""
				name="<%=RESULT %>" id="<%=RESULT %>" maxlength="100"
				onkeyup="return ismaxlength(this)"></textarea> <input type="hidden"
				name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>" value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>

			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<!--end of if condition when result type is text Area and comparison type is none -->

		<!-- if condition when result type is Range and comparison type is none -->
		<%if (dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("n")){%>

		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>


			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>


			<td>
			<%if(dgDet.getRemarks() != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks() %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<!--end of if condition when result type is Range and comparison type is none -->


		<!-- if condition when result type is single parameter and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("f")) {%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" /> <select
				id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%}
				  } %>
			</select></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /> <label>-</label></td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is single parameter and comparison type is fixed values -->

		<!-- if result type is text area and comparison type is fixed values  -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("m")&& dgCollection.getComparisonType().equalsIgnoreCase("f") ){%>
		<tr>
			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
				value="" name="<%=RESULT %>" id="<%=RESULT %>" /> <select
				id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%}
				  } %>
			</select></td>
			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /></td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %><!--end of if condition when result type is text area and comparison type is fixed values-->

		<!-- if result type is text  and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value="<%= dgCollection.getId()%>" type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
				value="" name="<%=RESULT %>" id="<%=RESULT %>" /> <select
				id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="large"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%}
				  } %>
			</select></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /></td>

			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>

		<%} %>
		<!--  end of if result type is text  and comparison type is fixed values -->

		<!-- if result type is range  and comparison type is fixed values -->
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="hidden"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" /> <select
				id="fixedId<%=inc %>" name="<%= FIXED_ID %>" class="small"
				tabindex="1">
				<option value="">Select</option>
				<% 
				   if(fixedValList != null){ 	
					for (DgFixedValue  dgFixedValue : fixedValList){
					%>
				<option value="<%=dgFixedValue.getId ()%>"><%=dgFixedValue.getFixedValue()%></option>
				<%}
				  } %>
			</select></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td><input name="<%=NORMAL_ID %>" id="<%=NORMAL_ID %><%=inc %>"
				value="" type="hidden" /></td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>

		<%} %>
		<!--  end of if result type is range  and comparison type is fixed values -->

		<!--  if result type is single parameter and comaprison type is normal value  and condition MALE -->
		<%if(sex.equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("m")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<%if(dgCollection.getSubInvestigationName() != null){ %> <input
				name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10" value="" readonly /> <%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>



		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition MALE -->

		<!--  if result type is single parameter and comparison type is normal value  and condition FEMALE -->
		<%if(sex.equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ 
%>
		<%if(normalSet.size()>0) {
	
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("f")){
%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>

		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition FEMALE -->

		<!--  if result type is single parameter and comaprison type is normal value  and condition NONE -->
		<%if(sex.equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("s") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("n")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue() != null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>

		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is single parameter and comaprison type is normal value and condition NONE -->

		<!--  if result type is Text Area and comaprison type is normal value  and condition MALE -->
		<%if(sex.equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("m")){
%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="-" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>

		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition MALE -->

		<!--  if result type is Text Area and comaprison type is normal value  and condition FEMALE -->
		<%if(sex.equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("f")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is Text Area and comaprison type is normal value  and condition NONE -->
		<%if(sex.equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("m") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("n")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value="<%= dgCollection.getId()%>" type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text area and comaprison type is normal value and condition NONE -->


		<!--  if result type is Text and comaprison type is normal value  and condition MALE -->
		<%if(sex.equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("m")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text t and comaprison type is normal value and condition MALE -->

		<!--  if result type is Text t and comaprison type is normal value  and condition FEMALE -->
		<%if(sex.equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("f")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"><input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50"><input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text t and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is Text and comaprison type is normal value  and condition NONE -->
		<%if(sex.equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("t") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("n")){

%>
		<tr>

			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value="<%= dgDet.getId()%>"
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value="<%= dgCollection.getInvestigation().getSample().getId()%>"
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is text and comaprison type is normal value and condition NONE -->



		<!--  if result type is Range and comaprison type is normal value  and condition MALE -->
		<%if(sex.equalsIgnoreCase("male")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("m")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition MALE -->

		<!--  if result type is Range and comaprison type is normal value  and condition FEMALE -->
		<%if(sex.equalsIgnoreCase("female")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("f")){

%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden"><input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden"><input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>


			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition FEMALE-->

		<!--  if result type is range and comaprison type is normal value  and condition NONE -->
		<%if(sex.equalsIgnoreCase("Not applicable")){ %>
		<%if(dgCollection.getResultType().equalsIgnoreCase("r") && dgCollection.getComparisonType().equalsIgnoreCase("v")){ %>

		<%if(normalSet.size()>0) {
for(DgNormalValue nv :normalSet){
if(nv != null && nv.getSex().equalsIgnoreCase("n")){
%>
		<tr>


			<td><input type="hidden"
				value="<%=dgCollection.getInvestigation().getId() %>"
				name=<%=INVESTIGATION_ID %> id="<%=INVESTIGATION_ID %><%=inc %>" />
			<input type="hidden"
				value="<%=dgCollection.getInvestigation().getChargeCode().getId()%>"
				name=<%=CHARGE_CODE_ID %> id="<%=CHARGE_CODE_ID %><%=inc %>" /> <%if(dgCollection.getSubInvestigationName() != null){ %>
			<input name="<%=SUBTEST_NAME %>" type="text"
				value="<%=dgCollection.getSubInvestigationName()%>" readonly /> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=inc %>"
				value=<%= dgCollection.getId()%> type="hidden" /> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>"
				id="<%=DG_SAMPLE_DETAIL_ID %><%=inc %>" value=<%= dgDet.getId()%>
				type="hidden" /> <%}else{%> <input name="<%=SUBTEST_ID %>"
				id="<%=SUBTEST_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SUBTEST_NAME %>" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgCollection.getInvestigation().getSample() != null){ %> <input
				name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=inc %>"
				value=<%= dgCollection.getInvestigation().getSample().getId()%>
				type="hidden" /> <input name="<%=SAMPLE_NAME %>" type="text"
				size="10"
				value="<%=dgCollection.getInvestigation().getSample().getSampleDescription()%>"
				readonly /> <%}else{ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=inc %>" value="" type="hidden" /> <input
				name="<%=SAMPLE_NAME %>" type="text" size="10" value="" readonly />
			<%} %>
			</td>

			<td><input type="hidden" name="<%=RESULT_TYPE%>"
				id="<%=RESULT_TYPE %><%=inc %>" value="m" /> <input type="text"
				name="<%=RESULT %>" id="<%=RESULT %><%=inc %>" maxlength="50" /> <input
				type="hidden" name="<%=FIXED_ID %>" id="<%=FIXED_ID %><%=inc %>"
				value="" /></td>

			<td>
			<%if(dgCollection.getUom()!= null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>"
				value=<%=dgCollection.getUom().getId()%> type="hidden" /> <input
				name="unitName" type="text" size="8"
				value="<%=dgCollection.getUom().getUomName()%>" readonly /> <%}else{ %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=inc %>" value="" type="hidden" />
			<input name="unitName" type="text" size="8" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(nv.getNormalValue() != null || nv.getMinNormalValue() != null || nv.getMaxNormalValue() != null){ %>
			<%if(nv.getNormalValue() != null ){ 
				if(!nv.getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" size="8"
				value="<%=nv.getId()%>" readonly /> <input name="normalValue"
				type="text" size="8" value="<%=nv.getNormalValue()%>" readonly /> <%}else if (nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(nv.getMinNormalValue()!= null && nv.getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" size="8" value="<%=nv.getId()%>"
				readonly /> <input name="normalValue" type="text" size="8"
				value="<%=nv.getMinNormalValue()+" - "+nv.getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				size="8" value="<%=nv.getId()%>" readonly /> <input
				name="normalValue" type="text" size="8" value="" readonly /><label>-</label>
			<%} %>
			</td>



			<td>
			<%if(dgDet.getRemarks()  != null){ %> <input type="text"
				name="<%=ADDITIONAL_REMARKS%>" id="<%=ADDITIONAL_REMARKS%><%=inc%>"
				value="<%=dgDet.getRemarks()  %>" maxlength="200" /> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDet.getRemarks()%>"</script>
			<%}else{ %> <input type="text" name="<%=ADDITIONAL_REMARKS%>"
				id="<%=ADDITIONAL_REMARKS%><%=inc%>" value="" maxlength="200" /> <%} %>
			</td>
		</tr>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<%} %>
		<!--  end of  if result type is range and comaprison type is normal value and condition NONE -->


		<!-- end for sets -->
		<%	}
} %>
	</tbody>
</table>

<div class="clear"></div>
<!-- Table Ends --> <input type="button" class="button" value="Submit"
	onclick="submitForm('sampleCollection','investigation?method=submitResultEntryForMultiple');"
	align="right" /> <input type="reset" value="Reset"
	class="buttonHighlight" onclick="resetClicked('sampleCollection');"
	accesskey="r" />
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
