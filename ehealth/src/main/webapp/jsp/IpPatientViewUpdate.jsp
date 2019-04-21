<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for IpPatientRegistration.
* @author  Awadhesh
* Create Date: 25th Jul,2017

* @version 1
--%>

<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>
<%@ page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasPatientType"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasCaste"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>


<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>

<script
	src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="../jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="../jsp/js/switchicon.js"></script>

<script>
<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
serverdate = '<%=date + "/" + month + "/" + year%>'
</script>
<div class="titleBg">
	<!--Commented by kishore on 20th mar start -->
	<!-- <h2>Update Patient Registration</h2> -->
	<h2>Update IP Patient Detail</h2>
</div>





<form name="updateIpPatientRegistration" method="post" action="" id="form1">
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
	<%
		URL myURL = application
				.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		//out.println("name-jsp-" +p.getProperty("age") );
		String serverPath=application.getResource("/WEB-INF/").getPath();
	%>

	<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	Map<String, Object> map = new HashMap<String, Object>();

	Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
	List<Inpatient>inPatientList=new ArrayList<Inpatient>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<Visit> visitList = new ArrayList<Visit>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasState> nativePlaceList = new ArrayList<MasState>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if (map.get("patientMap") != null) {
		patientDetailsMap = (Map<String, Object>) map
				.get("patientMap");
	}
	if(patientDetailsMap.get("relationList") != null)
    {
  	  relationList = (List<MasRelation>)patientDetailsMap.get("relationList");
    }
	if (patientDetailsMap.get("inpatientList") != null) {
		inPatientList = (List<Inpatient>)patientDetailsMap
				.get("inpatientList");
	}
	int defaultRelationId=0;
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	
	List<MasReference> referenceList = new ArrayList<MasReference>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	//List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
	List<MasCaste> casteList = new ArrayList<MasCaste>();
	List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
	List<MasVillage> villageList = new ArrayList<MasVillage>();
    
	  
%>
	

	<div class="clear"></div>

	<%
	String hin_no = "";
	if (inPatientList.size() > 0) {
		for (Inpatient patient : inPatientList) {
			hin_no = patient.getHin().getHinNo();
%>
	<!-- Patient details  section Starts-->
	<h4>Personal Information</h4>
	<div class="clear"></div>
	<div class="Block">
		<!--<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

-->

	
		<input type="hidden" id="inPatientId" name="inPatientId"
			value="<%=patient.getId()%>" /> <label>HIN_No</label>
		<label id="hinNoDivId" class="value" style="width:180px;margin-right:6px;"> <%=patient.getHinNo()%></label>
		<input id="hinNoId" type="hidden" name="<%=HIN_NO%>"
			value="<%=patient.getHinNo()%>" />
			 <label>Patient Name</label> <input
			type="text" id="patientName" name="patientName" value="<%=patient.getHin().getFullName()%>"
			 maxlength="40"
			class="readOnly" readonly="readonly" />
			<label>Patient Age</label> <input
			type="text" id="patientAge" name="patientAge" value="<%=patient.getHin().getAge()%>"
			 maxlength="40"
			class="readOnly" readonly="readonly" />
			 
			 <div class="clear"></div>
			 <label>Admission Date</label> 
			 <input type="text" name="<%=REG_DATE%>" id="registrationDateId"
			value="<%=patient.getDateOfAddmission()%>" maxlength="20"
			 class="readOnly" readonly="readonly" /> <label>Admission Time</label> <input
			type="text" name="<%=REG_TIME%>" value="<%=patient.getTimeOfAddmission()%>"
			validate="Registration Time,string,no" maxlength="20"
			class="readOnly" readonly="readonly" />
			
			 <label>Admitted By</label> <input
			type="text" id="admittedBy" name="admittedBy" value="<%=patient.getDoctor().getFirstName()%>"
			 maxlength="40"
			class="readOnly" readonly="readonly" />
			
			<div class="clear"></div>
			<label>ByStander</label>
			 <%
			if (patient.getDependentName()!= null) {
 %>
			 <input
			type="text" id="bysterName" name="bysterName" value="<%=patient.getDependentName()%>"
			 maxlength="40"
			 />
			<%
 	} else {
 %>	
             <input
			type="text" id="bysterName" name="bysterName" value=""
			 maxlength="20"
			 />
		<%
 	}
 %>	
			
			 <label>Mobile Number</label> 
			 <%
 	if (patient.getContactNo()!= null) {
 %>
			 <input
			type="text" id="contectNo" name="contectNo" onkeypress="return isNumber(event)" value="<%=patient.getContactNo() %>"
			 maxlength="10"
			 />
		<%
 	} else {
 %>	
             <input
			type="text" id="contectNo" name="contectNo" value="" onkeypress="return isNumber(event)"
			 maxlength="10"
			 />
		<%
 	}
 %>	
		<label>ByStander Relation</label>
			<%
 	if (patient.getRelation()!= null) {
 %>
			 <select name="relation" id="relation" validate=" "
				tabindex="2" class="">
			 <option value="">select</option>
				<%
				defaultRelationId=patient.getRelation().getId();
					for(MasRelation masRelation:relationList ){
					if(defaultRelationId>0 && defaultRelationId==masRelation.getId()){%>
				<option value="<%=masRelation.getId()%>" selected="selected"><%=masRelation.getRelationName() %></option>
				<% }else{%>
				<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName() %></option>
				<%	
				}}
					%>
			</select>
				<%
 	} else {
 %>
                <select name="relation" id="relation" validate=" "
				tabindex="2" class="">
			 <option value="">select</option>
				<%
				    for(MasRelation masRelation:relationList ){
					%>
				<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName() %></option>
				<%
				}
					%>
			</select>
           	<%
 	}
 %>
 <div class="clear"></div>
			 <label>ByStander Address</label>
			<%
 	if (patient.getAddress() != null) {
 %>
			<textarea id="address" name="address" cols="20" rows="2" class="textareaMediua"
				validate="Address,string,no" onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"><%=patient.getAddress()%></textarea>
			<%
 	} else {
 %>
			<textarea cols="20" rows="2" class="textareaMediua"
				validate="Address,string,no" id="address" name="address"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"></textarea>
			<%
 	}
 %>
		<div class="clear"></div>
		

		<%
	}
%>			
			
	

			
			<!-- onChange="populateState(this.value,'updateRegistration')" -->

			<!-- End Of Code for Company Date 19 July 2010 Code By Mukesh Narayan Singh-->
			

			
	<!-- OTHER DETAILS  section  ends-->

	<div class="clear"></div>
	<div class="division"></div>
	<div id="searchbar">

		<div id="edited"></div>

		<input type="button" name="Submit" value="Update" class="button"
			onClick="calform();" />
		<!-- <input name="Send" type="button"  class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" /> -->
		<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
			onClick="document.location.reload(true)" accesskey="r" />

		<%
 	
 	} else {
 %>
		<h4>
			<span>No record found!!</span>
		</h4>
		<%
	}
%>
	</div>
	<h4 id="statusMessage"></h4>
	<div class="clear"></div>
	<div class="division"></div>
	
	<div class="paddingTop40"></div>
	<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script type="text/javascript">
function openPopupWindow()
{
	var hinNo = document.getElementById('hinNoId').value;
	var url="/hms/hms/registration?method=displayRegisPhoto&hinNo=<%=hin_no%>";
 	newwindow=window.open(url,'name',"left=100,top=100,height=400,width=350,status=1,scrollbars=1,resizable=0");
}

</script>


<script type="text/javascript">
function checkForDiscount()
{
	var authorizer=eval(document.updateRegistration.refDoctor.value);
	var amount=parseFloat(document.updateRegistration.amt.value);
	var discountVar=document.updateRegistration.discount.value;
	if(isNaN(discountVar)){

	if(validateFloat(discountVar)){
		if(parseFloat(discountVar)>parseFloat(amount))
		{
			alert("Discount should be less than or equal to amount!!");
			document.updateRegistration.discount.value="";
			return false;
		}else if(parseFloat(discountVar)== parseFloat(amount)){
			document.getElementById('actualColAmtId').value = "";
		}
		if(discountVar!="" && authorizer==0)
		{
			alert("Select Authorizer!!");
			return false;
		}
		document.getElementById('actualColAmtId').value = "";
	}else{
		alert("Discount should be integer or decimal value.");
		document.updateRegistration.discount.value = "";
		return false;

	}
	}else{
		if(parseFloat(discountVar)>parseFloat(amount))
		{
			alert("Discount should be less than or equal to amount!!");
			document.updateRegistration.discount.value="";
			return false;
		}
		}
	return true;
}
function displayCompanyList()
{

		var company = document.updateRegistration.<%=PATIENT_TYPE%>.value;
	//	if(company != "2"){
	//		getActivateReadOnlyFieldOnReg();
	//	}
		if(company == "1"){
			document.getElementById('company').style.display = "inline";
			document.getElementById('companyLable').style.display = "inline";
			document.getElementById('comId').focus();
			document.getElementById('comId').style.backgroundColor = "yellow";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "1"){
			document.getElementById('company').style.display = "none";
			document.getElementById('companyLable').style.display = "none";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";
			document.getElementById('comId').style.backgroundColor = "";
		}

		if(company == "7"){
			document.getElementById('insurance').style.display = "inline";
			document.getElementById('insuranceLable').style.display = "inline";
			document.getElementById('insAmtlbl').style.display = "inline";
			document.getElementById('insAmt').style.display = "inline";
			document.getElementById('insId').focus();
			document.getElementById('insId').style.backgroundColor = "yellow";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "7"){
			document.getElementById('insurance').style.display = "none";
			document.getElementById('insuranceLable').style.display = "none";
			document.getElementById('insAmtlbl').style.display = "none";
			document.getElementById('insAmt').style.display = "none";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";
			document.getElementById('insId').style.backgroundColor = "";
		}

		if(company == "4"){
			document.getElementById('prjDiv').style.display = "inline";
			document.getElementById('prjlbl').style.display = "inline";
			document.getElementById('prjId').focus();
			document.getElementById('prjId').style.backgroundColor = "yellow";
		}else if (company != "4"){
			document.getElementById('prjDiv').style.display = "none";
			document.getElementById('prjlbl').style.display = "none";
			document.getElementById('prjId').style.backgroundColor = "";
		}

		if(company == "8" || company == "2"){
			document.getElementById('employeeDiv').style.display = "inline";
			document.getElementById('employeelbl').style.display = "inline";
			document.getElementById('employeeId').focus();
			document.getElementById('employeeId').style.backgroundColor = "yellow";
		}else if (company != "8"){
			document.getElementById('employeeDiv').style.display = "none";
			document.getElementById('employeelbl').style.display = "none";
			document.getElementById('employeeId').style.backgroundColor = "";
		}

	//	if(document.getElementById("pFirstNameId").value!="")
		//	document.getElementById("pFirstNameId").value="";

		document.getElementById('employeeDependentId').value = "0";
		document.getElementById('employeeId').value = "0";
		document.getElementById('prjId').value = "0";
		document.getElementById('insId').value = "0";
		document.getElementById('comId').value = "0";
}
function checkForPatientType()
{
	var registrationType=document.getElementById('registrationType').value;
	var rad=document.getElementById('rad').value;
	var rad1=document.getElementById('rad1').value;
	if(rad!=""){
		//alert("if");
	submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount&registrationType='+registrationType+'&<%=SELECTED_RADIO%>='+rad,'amount');
	}else{
		//("else");
		submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount&registrationType='+registrationType+'&<%=SELECTED_RADIO%>='+rad1,'amount');
			}
}
function hideCalendar(patientType){

	if(patientType == 2 || patientType == 8){ // For Staff & staff dependent case
		document.getElementById('dobcalId').style.visibility = 'hidden';
		}else{
		document.getElementById('dobcalId').style.visibility = 'visible';
		}

	}
//---------------------- Code By MUkesh Narayan Singh Date 18 Aug 2010

var formObj = document.getElementById('form1');
var inputArr = formObj.getElementsByTagName("Select");
for (i=0; i<inputArr.length; i++){



inputArr[i].onfocus = function(){
this.style.backgroundColor = "yellow";
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};
if(inputArr[i].name=='<%=PATIENT_TYPE_ID%>'){
inputArr[i].onblur=function(){

//displayCompanyList();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='<%=EMPLOYEE_DEPENDENT_ID%>'){
inputArr[i].onblur=function(){

getDepandentDetails();
this.style.backgroundColor = "";
}

}

if(inputArr[i].name=='<%=GENDER%>'){
inputArr[i].onblur=function(){

changeGender() ;
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='ageUnit'){

inputArr[i].onblur=function(){
checkForDOB();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='registrationType'){

inputArr[i].onblur=function(){
checkForPatientType();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='regisType'){

inputArr[i].onchange=function(){
submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount','amount');
}

}
if(inputArr[i].name=='<%=EMPLOYEE_ID%>'){
inputArr[i].onblur=function(){

employeeDepntList();
ajaxForEmployeeDetails();
this.style.backgroundColor = "";
}

}

}



/*
 * This function is used for remove readonly after select staf dependent
 Code By Mukesh Narayan SIngh
 Date 16 Aug 2010
 */
function getActivateReadOnlyFieldOnReg(){
	var objTitle=	document.getElementById("titleId");
    document.getElementById("titleId").value= "select";
    objTitle.disabled=false;


	document.getElementById("pFirstNameId").value=  "";
    document.getElementById("pFirstNameId").disabled=false;
    document.getElementById("pFirstNameIdTemp").value=  "";

    document.getElementById("pMiddleNameId").value= "";
    document.getElementById("pMiddleNameId").disabled=false;
    document.getElementById("pMiddleNameIdTemp").value=  "";

    document.getElementById("pLastNameId").value="";
  	 document.getElementById("pLastNameId").disabled=false;
 	 document.getElementById("pLastNameIdTemp").value="";

     var obj1=	document.getElementById("gender");
     document.getElementById("gender").value= "select";
     document.getElementById("genderTemp").value= "0";
     obj1.disabled=false;


     try{
  		document.getElementById("dobId").value="";
  		document.getElementById("dobId").disabled=false;
  		document.getElementById("dobIdTemp").value= "";
	   	}
	   	catch(e){
  		document.getElementById("dobId").value="";
  		document.getElementById("dobIdTemp").value="";
  		}


     try{
  		document.getElementById("age").value="";
  		document.getElementById("age").disabled=false;
  		document.getElementById("ageTemp").value= "";
  		 document.getElementById("ageUnitIdTemp").value ="";
		 document.getElementById("ageUnitId").disabled = false;
  	}
  	catch(e){
  		document.getElementById("age").value="";
  		document.getElementById("age").disabled=false;
  		document.getElementById("ageTemp").value="";
  		document.getElementById("ageUnitIdTemp").value = "";
		document.getElementById("ageUnitId").disabled=false;
  	}
		document.getElementById("religionId").disabled=false;
		document.getElementById("religionId").value= "";
  		document.getElementById("religionIdTemp").value= "";

  		document.getElementById("casteId").disabled=false;
  		document.getElementById("casteId").value="";
		document.getElementById("casteIdTemp").value= "";

		document.getElementById("nokNameId").value="";
    	document.getElementById("relativeNameTemp").value="";
    	document.getElementById("nokNameId").disabled=false;

}
</script>


<script>function checkMaxLengthMozJsp(obj){
	//alert(obj);
     if(obj.value.length>125){
        alert("you are crossing maximum length limit pls reduce the some text");
	        return true;
    	}
    }
</script>
<script language="JavaScript">
 function resetForm(){
   document.getElementById("updateIpPatientRegistration").reset();
 } 
 function calform(){
	 
	  var address=document.getElementById("address").value;
	 var inPatientId=document.getElementById("inPatientId").value;
	
	 //alert("---->>>"+nativePlaceId);
	 //alert(document.getElementById("nativePlace"));
	  if(address!=null){
		 
		  submitForm('updateIpPatientRegistration','/hms/hms/registration?method=updateIpPatientInformation&inPatientId='+inPatientId);
		 
		 }else{
			alert("Please Enter Bysister Address");
			 return false;
		 } 
	 }
 function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	    	alert("Enter Only Numeric Value");
	        return false;
	    }
	    return true;
	}
</script>
<script>function checkMaxLengthMoz(obj){
	//alert(obj);
     if(obj.value.length>50){
        alert("you are crossing maximum length limit pls reduce the some text");
	        return true;
    	}
    }
</script>
<%
	authorizerList = null;
	blockList = null;
	caseTypeList = null;
	casteList = null;
	chargeCodeList = null;
	
	countryList = null;

	diagnosisList = null;
	
	employeeList = null;
	maritalStatusList = null;
	nativePlaceList = null;
	sexList = null;
	stateList = null;
	titleList = null;
	villageList = null;
	visitList = null;
	authorizerList = null;
	blockList = null;
%>