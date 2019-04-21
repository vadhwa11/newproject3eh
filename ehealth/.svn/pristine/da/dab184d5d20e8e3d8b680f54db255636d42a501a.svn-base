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
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="java.text.DecimalFormat"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
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
function checkForNumericResult(obj,inc)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + inc + '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}
function submitAllExceptEnter(myfield,e,url,inc)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else 
		return true;
	if (keycode != 13) {
		var chargeCodeCode = document.getElementById('chargeCodeCodeForPerticularTest'+inc).value
		if(chargeCodeCode != 'HA17' && chargeCodeCode != 'HA18'){
		
			if(checkForNumericResult(myfield,inc)){
				return true;
			}else{
				document.getElementById('<%=RESULT_SINGLE_VALUE %>'+inc).value = '';
				return false;
			}
		}
	}
}
function checkForNumericResultMultiple(obj,inc,mainCount,subCount)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + mainCount + '.' + subCount+ '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}

function submitAllExceptEnterForMultiple(myfield,e,url,inc,mainCount,subCount)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else 
		return true;
	if (keycode != 13) {
		var chargeCodeCode = document.getElementById('chargeCodeCodeForPerticularTestForMultiple'+inc).value;
		if(chargeCodeCode != 'HA25'){
			if(checkForNumericResultMultiple(myfield,inc,mainCount,subCount)){
				return true;
			}else{
				document.getElementById('<%=RESULT%>'+inc).value = '';
				return false;
			}
		}
	}
}
function CheckAll(chk)
{
for (var i=0;i < document.sampleCollection.elements.length;i++)
	{
		var e = document.sampleCollection.elements[i];
		
		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
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
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String resultId = "";
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
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(map.get("resultId") !=null){
		resultId = (String)map.get("resultId");
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


	DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0) {
		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
	}

	DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
	if(resultList != null && resultList.size() >0){
		dgresultHeader = (DgResultEntryHeader) resultList.get(0);

	}
	//session.setAttribute("dgResultEntryHeader",dgResultEntryHeader);
	//session.setAttribute("dgResultDtSet",dgResultDtSet);
	 
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
	 	e.printStackTrace();
	}
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
%>

<!--main content placeholder starts here-->

<form name="sampleCollection" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>Result Entry For Modification</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<%
String subDept = "";

int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%> <%
 			}
 		}%> <label class="common"> Department</label> <label
	class="valueNoWidth" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
<label class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="valueNoWidth"><%=subDept%></label>
<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" />
<div class="clear"></div>

<div class="Block"><label>Order Date</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Order Time</label>
<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Order No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
<label>Order By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>

<%--
<!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
<div class="clear"></div>
<div class="blockFrame" style="padding: 0px; 0px; 0px; 0px;margin:  0px; 0px; 0px; 0px;">
<div class="clear"></div>
<label class="medium">Service Type</label>
			<%
				if(dgResultEntryHeader.getHin().getServiceType() != null){
			%>
				<label class="valuemedium"><%=dgResultEntryHeader.getHin().getServiceType().getServiceTypeName()%></label>
				<%}else{ %>
				<label class="valuemedium">-</label>
				<% }%>
	
	<label class="medium">Service No.</label>
		  <%
				if(dgResultEntryHeader.getHin().getServiceNo() != null && !(dgResultEntryHeader.getHin().getServiceNo().equals(""))){
			%>
			
			<label class="valuemedium"><%=dgResultEntryHeader.getHin().getServiceNo()%></label>
			<%}else{ %>
			<label class="valuemedium">-</label>
			<%}%>
	
	<label class="medium">Service Status</label>
			<%if(dgResultEntryHeader.getHin().getServiceStatus() != null){
			%>
			<label class="valuemedium"><%= dgResultEntryHeader.getHin().getServiceStatus().getServiceStatusName()%></label>
			<%}else{ %>
			<label class="valuemedium">-</label>
			<% }%>
	<label class="medium">Relation</label>
			<%
				if(dgResultEntryHeader.getHin().getRelation() != null){
			%>
				<label class="valuemedium"><%=dgResultEntryHeader.getHin().getRelation().getRelationName()%></label>
				<%}else{ %>
				<label class="valuemedium">-</label>
				<% }%>
	<div class="clear"></div>
	<label>Ser. Per. Name</label>
			<%
				if(dgResultEntryHeader.getHin().getSFirstName() != null  && !(dgResultEntryHeader.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(dgResultEntryHeader.getHin().getSMiddleName() != null){
						sMiddleName = dgResultEntryHeader.getHin().getSMiddleName();
					}
					if(dgResultEntryHeader.getHin().getSLastName() != null){
						sLastName = dgResultEntryHeader.getHin().getSLastName();
					}
			 %>
			<label class="valueNoWidth"><%=dgResultEntryHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
			<%}else{ %>
			<label  class="valueNoWidth">-</label>
			<% }%>
	
	<label class="medium">Rank</label>
			<%
			if(dgResultEntryHeader.getHin().getRank() != null){
			%>
			
			<label class="valuemedium"><%=dgResultEntryHeader.getHin().getRank().getRankName()%></label>
			<%} else{ %>
			<label class="valuemedium">-</label>
			<% }%>
			<label class="medium">Unit</label>
<%
if(dgResultEntryHeader.getHin().getUnit() != null){
%>

<label class="valuemedium"><%= dgResultEntryHeader.getHin().getUnit().getUnitName()%></label>
<%} else{ %>
<label class="valuemedium">-</label>
<% }%>

<label class="medium">Trade</label>
<%
if(dgResultEntryHeader.getHin().getTrade() != null){
%>
<label class="valuemedium"><%=  dgResultEntryHeader.getHin().getTrade().getTradeName()%></label>
<%} else{ %>
<label class="valuemedium">-</label>
<% }%>
<div class="clear"></div>

</div>--%> <!--Block one Ends--> <!--Block Two Starts-->
<div class="clear"></div>


<h4>Patient Details</h4>
<div class="clear"></div>


<label>HIN</label> <label class="value"><%=dgResultEntryHeader.getHin().getHinNo() %></label>

<%
					String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getHin().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getHin().getPMiddleName();
					}
					if(dgResultEntryHeader.getHin().getPLastName() != null){
						lastName = dgResultEntryHeader.getHin().getPLastName();
					}
					
					%> <label>Patient Name</label> <label class="valueNoWidth"><%=dgResultEntryHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <label class="valueNoWidth"><%= dgResultEntryHeader.getHin().getSex().getAdministrativeSexName()%></label>

<%
		String age = "";
		String currentAge = "";
		age = dgResultEntryHeader.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, dgResultEntryHeader.getHin().getRegDate());
		%> <label>Age</label> <label class="value"><%=currentAge%></label>

<div class="clear"></div>

<div>
<%
if(dgResultEntryHeader.getInpatient() != null){
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} else{%> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=dgResultEntryHeader.getHin().getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>"
	value="<%=dgResultEntryHeader.getHin().getHinNo() %>" /></div>

<div class="clear"></div>
<div class="clear"></div>
<!--Block Two Ends--> <script><!--

function inputValidate(){

	var validatedCheckBoxCountSingle = document.getElementById('validatedCheckBoxCountSingle').value;
	var validatedCheckBoxCountMultiple = document.getElementById('validatedCheckBoxCountMultiple').value;
	if(validatedCheckBoxCountSingle > 0 || validatedCheckBoxCountMultiple > 0){
		for(var i = 0 ;i< validatedCheckBoxCountSingle ;i++){
			if(document.getElementById('checkIdSingleValue'+i+'').checked == true){
				return true;
			}
		}	
		
		for(var j = 0 ;j< validatedCheckBoxCountMultiple ;j++){
			if(document.getElementById('checkId'+j+'').checked == true){
				return true;
			}
		}	
		alert("Please validate atleast one result.")
		return false;
	}else{
		return true;
	}
}

//function inputValidate(){
//	validatedSingleValue  = document.getElementsByName('validatedSingleValue');
//	if(validatedSingleValue != null || validatedSingleValue != undefined){
//		for(var i = 0; i < document.getElementsByName('validatedSingleValue').length; i++){
//			if(document.getElementsByName('validatedSingleValue')[i].checked == true)
 //             {
//				return true;
//			  }		
 // 		}
//	}
//	validated  = document.getElementsByName('validated');
//	if(validated != null || validated != undefined){
//		for(var i = 0; i < document.getElementsByName('validated').length; i++){
//			if(document.getElementsByName('validated')[i].checked == true)
 //             {
//				return true;
//			  }		
 // 		}
//	}
 // 		alert("Please Validate The Result.")
//		return false;
//}
				
function inputValue(){
		for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please Validate The Result.")
		return false;
	}
function openTemplateScreen(index){
	//var resultEnteredBy = document.getElementById('<%=RESULT_VALIDATED_BY %>').value;
	//if(resultEnteredBy != ''){
		var resultId = document.getElementById('resultIdTemplate'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_ENTERED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultEntryModification&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
	//}else{
	//	alert('Result Entered By can not be blank.');
	//	return false;
	//}
	
}				
function openSensitiveScreen(index){
		var resultId = document.getElementById('resultIdSensitive'+index).value;
		var resultIdStringForTemplate = document.getElementById('resultIdStringForTemplate').value;
		var resultEnteredByForTemplate = document.getElementById('<%=RESULT_ENTERED_BY %>').value;
		submitForm('sampleCollection','investigation?method=searchPatientForResultEntryModification&resultId='+resultId+'&flagForLab=fromLab&resultIdStringForTemplate='+resultIdStringForTemplate+'&resultEnteredByForTemplate='+resultEnteredByForTemplate+'');
}				
   
--></script> <script>

function resetResult(){
	  document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
</script> <!-- Block Three Starts -->
<h4>Result Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Result Date</label> <%if(dgresultHeader.getResultDate() != null){ %>
<label class="valueNoWidth"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> <label>Result
Time</label> <label class="valueNoWidth"><%=dgresultHeader.getResultTime() %></label>

<div class="clear"></div>
<input type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" /> <label>Result
Entered Date</label> <label class="value"><%=date%></label> <label>Result
Entered Time</label> <label class="value"><%=time%></label> <label><span>*</span>Result
Entered By</label> <select id="<%=RESULT_ENTERED_BY %>"
	name="<%= RESULT_ENTERED_BY %>" validate="Report Entered By,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) || masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select>
<div class="clear"></div>
<label>Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueNoWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->

<div class="tableHolderAutoValidate" style="width: 980px;">
<table id="chargeDetails" width="100%" cellpadding="0" cellspacing="0"
	style="height: auto;">

	<tr>
		<th width="7%">S.No.</th>


		<th width="7%">Service</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Sample</th>
		<%} %>

		<th width="10%">Result</th>
		<th width="10%">UOM</th>

		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Normal Range</th>
		<%} %>
		<th width="4%">Additional Remarks</th>

		<% 
    int index = 0;
    int indexForSingle = 0;
    int indexForMultiple = 0;
    
    for(DgResultEntryHeader dgResultEntryHeader2 : resultList){ 
 		if(dgResultEntryHeader2.getResultType() != null 
				&& dgResultEntryHeader2.getResultType().equalsIgnoreCase("S")){
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader2.getDgResultEntryDetailSens().iterator().next();
 			%>
		<tr>

			<td><%=index+1 %></td>
			<td>
			<%if(dgDetail.getInvestigation() !=null){ 
			              %> <label name="<%=INVESTIGATION_NAME %>"
				style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
			</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
			</td>
			<td></td>
			<td><input name="resultIdSensitive"
				id="resultIdSensitive<%=index%>" type="hidden"
				value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
				type="button" class="buttonBig" style="width: auto;"
				value="Click Here To Fill Result"
				onclick="openSensitiveScreen('<%=index%>');" align="right" /></td>
			<td></td>

		</tr>

		<%	}else{
		   	DgResultEntryDetail dgDetail = dgResultEntryHeader2.getDgResultEntryDetails().iterator().next();

	    	if(dgDetail.getInvestigation().getInvestigationType().equals("s")){
				
			    %>
		<tr>
			<td><%=index+1 %></td>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){ 
			              
			              %> <input type="hidden"
				name="<%=RESULT_ID_SINGLE_VALUE %>"
				id="<%= RESULT_ID_SINGLE_VALUE%>"
				value="<%=dgResultEntryHeader2.getId() %>" /> <input
				name="<%=RESULT_TYPE_SINGLE_VALUE %>" type="hidden" size="10"
				value="<%=dgDetail.getResultType() %>" readonly /> <input
				name="<%=INVESTIGATION_ID_SINGLE_VALUE %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly /> <input
				name="chargeCodeCodeForPerticularTest"
				id="chargeCodeCodeForPerticularTest<%=index+1 %>"
				value=<%= dgDetail.getInvestigation().getChargeCode().getChargeCodeCode()%>
				type="hidden"> <input name="chargeCode" type="hidden"
				readonly="readonly"
				value="<%=dgDetail.getInvestigation().getInvestigationName()%>"></input>
			<label style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>
			<%}else { %> <input name="chargeCode" value="-" readonly="readonly"></input>
			<label style="font-weight: bold;">-</label> <%} %>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="7%">
			<%if(dgDetail.getSample() !=null){ %> <input
				name="<%=SAMPLE_ID_SINGLE_VALUE %>" id=<%=SAMPLE_ID_SINGLE_VALUE %>
				type="hidden" size="5" value="<%=dgDetail.getSample().getId() %>"
				readonly /> <input name="sample2"
				value="<%=dgDetail.getSample().getSampleDescription() %>"
				readonly="readonly" /> <%}else { %> <input name="sample"
				readonly="readonly">-</input> <%} %>
			</td>
			<%} %>
			<td>
			<% 
				    try{
				    	if(dgDetail.getInvestigation().getMinNormalValue() != null
				    		&& dgDetail.getInvestigation().getMaxNormalValue() != null
				    		&& !dgDetail.getInvestigation().getMinNormalValue().equals("")
				    		&& !dgDetail.getInvestigation().getMaxNormalValue().equals("")){
				    		
				    		Float minValue = Float.parseFloat(dgDetail.getInvestigation().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getInvestigation().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="<%=result %>" />
			<% }else{ %> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" class="highlight"
				value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
				value="<%=dgDetail.getResult()%>" /> <%}
					       }else{ %> <input name="<%=RESULT_SINGLE_VALUE %>"
				tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
				value="<%=dgDetail.getResult()%>" /> <% } 
				    }catch(Exception exception){ %> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
				value="<%=dgDetail.getResult()%>" /> <% } %>
			</td>

			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>"
				id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>" type="hidden"
				size="5" value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="uom" value="<%=dgDetail.getUom().getUomName() %>"
				readonly="readonly" /> <%}else { %> <input name="uom" value="-"
				readonly="readonly" /> <%} %>
			</td>
			<%} %>



			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getInvestigation().getNormalValue() != null ){ 
							if(!dgDetail.getInvestigation().getNormalValue().equals("")){
						%> <input name="normalValue" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getNormalValue()%>" readonly />
			<%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" style="" size="10"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}
							} 
						else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalValue" type="text"
				size="8" value="" readonly /> <%} %>
			</td>
			<%} %>

			<td>
			<%if(dgDetail.getRemarks() != null){ %> <input
				value="<%=dgDetail.getRemarks() %>" onkeyup="chkLength(this,100);"
				id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"
				name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%}else{ %> <input
				value="" onkeyup="chkLength(this,100);"
				id="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"
				name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%} %>
			</td>

		</tr>

		<% 
		 indexForSingle++;
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("t")){ %>
		<tr>

			<td><%=index+1 %></td>
			<td>
			<%if(dgDetail.getInvestigation() !=null){ 
			              %> <label name="<%=INVESTIGATION_NAME %>"
				style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
			</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
			</td>
			<td></td>
			<td><input name="resultIdTemplate"
				id="resultIdTemplate<%=index%>" type="hidden"
				value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
				type="button" class="buttonBig" style="width: auto;"
				value="Click Here To Fill Result"
				onclick="openTemplateScreen('<%=index%>');" align="right" /></td>
			<td></td>

		</tr>
		<%	
		
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("m")){ %>
		<jsp:include page="resultEntryCorrectionTableForLab.jsp" flush="true">
			<jsp:param name="resultEntryIndex" value="<%=index%>" />
			<jsp:param name="resultEntryIndexForMultiple"
				value="<%=indexForMultiple%>" />
		</jsp:include>

		<%  
			indexForMultiple = indexForMultiple + dgResultEntryHeader2.getDgResultEntryDetails().size()+1;
		}
		}
 		index++;
    	} %>
	
</table>
</div>

<div class="clear"></div>
<input type="hidden" name="validatedCheckBoxCountSingle"
	id="validatedCheckBoxCountSingle" value="<%=indexForSingle%>" /> <input
	type="hidden" name="validatedCheckBoxCountMultiple"
	id="validatedCheckBoxCountMultiple" value="<%=indexForMultiple%>" /> <input
	type="hidden" name="resultIdStringForTemplate"
	id="resultIdStringForTemplate" value="<%=resultId%>" /> <!-- Table Ends -->
<div class="Height10"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="clear"></div>

<input type="button" name="submitForDisable" id="submitForDisable"
	class="button" value="Submit" tabindex="1"
	onclick="submitFormToDisableSubmit('sampleCollection','investigation?method=submitResultEntryForModificationLab');"
	align="right" /> <input name="Button" type="button"
	class="buttonHighlight" value="Reset" onclick="resetResult();" /> <input
	name="Button" type="button" class="button" value="Back"
	onclick="history.back();" />
<div class="clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label></div>
<!--Bottom labels starts--></form>
<!--main content placeholder ends here-->
