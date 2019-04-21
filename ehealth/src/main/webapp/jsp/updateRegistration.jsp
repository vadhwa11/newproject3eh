<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Rajesh
* Create Date: 14th Nov,2008
* Revision Date:
* Revision By:  Mukesh Narayan Singh Date 16 July 2010
* Revision By:  Ujjwal Kashyap 		 Date 09 October 2012
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
	<h2>Update Registration</h2>
</div>




<form name="updateRegistration" method="post" action="" id="form1">
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
	List<Patient> patientList = new ArrayList<Patient>();
	List<Visit> visitList = new ArrayList<Visit>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasState> nativePlaceList = new ArrayList<MasState>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<MasCompany> companyList = new ArrayList<MasCompany>();
	if (map.get("companyList") != null) {
		companyList = (List<MasCompany>) map.get("companyList");
	}
	if (map.get("patientDetailsMap") != null) {
		patientDetailsMap = (Map<String, Object>) map
				.get("patientDetailsMap");
	}
	List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
	if (patientDetailsMap.get("uploadDocumentsList") != null) {
		uploadDocumentsList = (List<UploadDocuments>) patientDetailsMap
				.get("uploadDocumentsList");
	}

	if (patientDetailsMap.get("patientList") != null) {
		patientList = (List<Patient>) patientDetailsMap
				.get("patientList");
	}
	if (map.get("nativePlaceList") != null) {
		nativePlaceList = (List<MasState>) map
				.get("nativePlaceList");
	}
	//
	
	if (patientDetailsMap.get("visitList") != null) {
		/*
			not required visit detail on update registration
			code by Mukesh Narayan SIngh
			Confirmed By Mr. Bambam Gautam
			Date 16 July 2010
		 */
		//visitList = (List<Visit>)patientDetailsMap.get("visitList");
	}
	if (map.get("chargeCodeList") != null) {
		chargeCodeList = (List<MasChargeCode>) map
				.get("chargeCodeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map
				.get("authorizerList");
	}
	BigDecimal amount = new BigDecimal(0.00);
	BigDecimal rate = new BigDecimal(0.00);
	BigDecimal stdDeduction = new BigDecimal(0.00);
	BigDecimal discAmt = new BigDecimal(0.00);

	if (map.get("amount") != null) {
		amount = (BigDecimal) map.get("amount");
	}
	if (map.get("rate") != null) {
		rate = (BigDecimal) map.get("rate");
	}
	if (map.get("discAmt") != null) {
		discAmt = (BigDecimal) map.get("discAmt");
	}
	if (map.get("stdDeduction") != null) {
		stdDeduction = (BigDecimal) map.get("stdDeduction");
	}
	String billNo = "";
	if (map.get("billNo") != null) {
		billNo = (String) map.get("billNo");
	}
	MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
	if (map.get("systemParam") != null) {
		systemParam = (MasSetupParameterMaintaince) map
				.get("systemParam");
	}
	int regChargeId = 0;
	if (systemParam.getUpdateRegChargeCode() != null) {
		regChargeId = systemParam.getUpdateRegChargeCode().getId();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	if (map.get("unitList") != null) {
		unitList = (List<MasUnit>) map.get("unitList");
	}
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
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

	/*
	 * Code For validation in hospital parameter
	 Code By Mukesh Narayan Singh
	 Date 15 July 2010
	 */
	HospitalParameters hospitalParameters = new HospitalParameters();
	if (patientDetailsMap.get("hospitalParameters") != null) {
		hospitalParameters = (HospitalParameters) patientDetailsMap
				.get("hospitalParameters");
	}
	String blockStatus = "";
	if (hospitalParameters.getBlock() != null) {
		blockStatus = hospitalParameters.getBlock().trim();
	}
	String postOfficeStatus = "";
	if (hospitalParameters.getPostOffice() != null) {
		postOfficeStatus = hospitalParameters.getPostOffice().trim();
	}
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if (map.get("titleList") != null) {
		titleList = (List<MasTitle>) map.get("titleList");
	}
	if (map.get("maritalStatusList") != null) {
		maritalStatusList = (List<MasMaritalStatus>) map
				.get("maritalStatusList");
	}
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map
				.get("departmentList");
	}
	if (map.get("religionList") != null) {
		religionList = (List<MasReligion>) map.get("religionList");
	}
	if (map.get("countryList") != null) {
		countryList = (List<MasCountry>) map.get("countryList");
	}
	if (map.get("stateList") != null) {
		stateList = (List<MasState>) map.get("stateList");
	}
	if (map.get("districtList") != null) {
		districtList = (List<MasDistrict>) map.get("districtList");
	}
	if (map.get("blockList") != null) {
		blockList = (List<MasBlock>) map.get("blockList");
	}
	if (map.get("relationList") != null) {
		relationList = (List<MasRelation>) map.get("relationList");
	}
	if (map.get("referenceList") != null) {
		referenceList = (List<MasReference>) map.get("referenceList");
	}

	if (map.get("occupationList") != null) {
		occupationList = (List<MasOccupation>) map
				.get("occupationList");
	}
	//if(map.get("recordOfficeAddressList") != null){
	//recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
	//}
	if (map.get("diagnosisList") != null) {
		diagnosisList = (List<MasDiagnosisConclusion>) map
				.get("diagnosisList");
	}
	if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	if (map.get("patientTypeList") != null) {
		patientTypeList = (List<MasPatientType>) map
				.get("patientTypeList");
	}
	if (map.get("employeeList") != null) {
		doctorList = (List<MasEmployee>) map.get("employeeList");
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("caseTypeList") != null) {
		caseTypeList = (List<MasCaseType>) map.get("caseTypeList");
	}
	if (map.get("casteList") != null) {
		casteList = (List<MasCaste>) map.get("casteList");
	}
	if (map.get("postCodeList") != null) {
		postCodeList = (List<MasPostCode>) map.get("postCodeList");
	}
	if (map.get("villageList") != null) {
		villageList = (List<MasVillage>) map.get("villageList");
	}
	List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
	if (map.get("employeeDependentList") != null) {
		employeeDependentList = (List<MasEmployeeDependent>) map
				.get("employeeDependentList");
	}
	boolean cardValidFlag = false;
	String cardValidityDatePre = "";
	if (patientList.size() > 0) {
		Patient patient = new Patient();
		patient = (Patient) patientList.get(0);
		if (patient.getCardValidDate() != null) {
			cardValidFlag = HMSUtil.checkCardValidityDate(HMSUtil
					.convertDateToStringTypeDate(patient
							.getCardValidDate()));
			cardValidityDatePre = HMSUtil
					.convertDateToStringTypeDateOnly(patient
							.getCardValidDate());
		}
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	//String selectedTitleForReg = properties.getProperty("selectedTitleForReg");
	//String administrativeSexMaleCode = properties.getProperty("administrativeSexMaleCode");
	//String bangaloreDistrictCode = properties.getProperty("bangaloreDistrictCode");
	//String karnatakaStateCode = properties.getProperty("karnatakaStateCode");
	//String indiaCode = properties.getProperty("indiaCode");
	//String departmentTypeCodeForCR = properties.getProperty("departmentTypeCodeForCR");
	String empCategoryCodeForDoctor = properties
			.getProperty("empCategoryCodeForDoctor");
%>
	<script type="text/javascript">
function displayAddress(){
var unit = document.getElementById('unitId').value;
document.getElementById('unitAddId').style.display = 'inline';
if(unit != 0){
if(unit != 'Other'){
document.getElementById('addUnitDiv').style.display = 'none';
<%for (MasUnit masUnit : unitList) {%>
var unit1 = '<%=masUnit.getId()%>';
if(unit == unit1){

document.updateRegistration.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
}
<%}%>}else if(unit == 'Other'){
document.getElementById('addUnitDiv').style.display = 'inline';
document.getElementById('unitAddId').style.display = 'none';
}
}else if(unit == 0){
document.updateRegistration.<%=UNIT_ADDRESS%>.value = '';
}
}
</script>
	<script type="text/javascript">
<%int counter1 = 0;
			for (MasState masState : stateList) {
				for (MasDistrict masDistrict : districtList) {
					if (masDistrict.getState() != null) {
						if (masState.getId().equals(
								masDistrict.getState().getId())) {%>
districtArray[<%=counter1%>] = new Array();
districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;
districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

<%counter1++;
						}
					}
				}
			}%>
<%int count = 0;
			for (MasDistrict masDistrict : districtList) {
				for (MasBlock masBlock : blockList) {
					if (masBlock.getDistrict() != null) {
						if (masDistrict.getId().equals(
								masBlock.getDistrict().getId())) {%>
blockArray[<%=count%>] = new Array();
blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
blockArray[<%=count%>][1] = <%=masBlock.getId()%>;
blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

<%count++;
						}
					}
				}
			}%>
</script>

	<div class="clear"></div>

	<%
	String hin_no = "";
	if (patientList.size() > 0) {
		for (Patient patient : patientList) {
			hin_no = patient.getHinNo();
%>
	<!-- Patient details  section Starts-->
	<h4>Personal Information</h4>
	<div class="clear"></div>
	<div class="Block">
		<!--<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

-->

		<script>
   function checklenth(){
	   
	   var num="";
       num=document.getElementById("phone").value;
       alert("num>>"+num+"num length---->"+num.length);
       if(num.length>11)
       {
           alert("Enter Only 11 Digits!!");
       }
       }
   
   </script>
		<input type="hidden" id="hinNoId2" name="hinNoId2"
			value="<%=patient.getId()%>" /> <label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
		<label id="hinNoDivId" class="value"> <%=patient.getHinNo()%></label>
		<input id="hinNoId" type="hidden" name="<%=HIN_NO%>"
			value="<%=patient.getHinNo()%>" /> <label class="medium">Reg
			Date</label> <input type="text" name="<%=REG_DATE%>" id="registrationDateId"
			value="<%=HMSUtil.convertDateToStringWithoutTime(patient
							.getRegDate())%>"
			validate="Registration Date,String,no" class="readOnly"
			readonly="readonly" /> <label class="medium">Reg Time</label> <input
			type="text" name="<%=REG_TIME%>" value="<%=patient.getRegTime()%>"
			validate="Registration Time,string,no" maxlength="20"
			class="readOnly" readonly="readonly" />
		<div class="clear"></div>
		<label><span>*</span> Patient Type</label>
		<%
//checkForPatientType();displayCompanyList();
	if (cardValidFlag) {
%>
		<input type="hidden" name="cardValidFlag" id="cardValidFlag" value="0" />
		<select name="<%=PATIENT_TYPE_ID%>" id="patientTypeId"
			validate="Patient Type,string,yes"
			onchange="calculateValidUptoDateInAjax('updateRegistration');displayCompanyList();"
			tabindex="1" onchange="checkForPatientType();">
			<%
	} else {
%>
			<input type="hidden" name="cardValidFlag" id="cardValidFlag"
			value="1" />
			<select name="<%=PATIENT_TYPE_ID%>" id="patientTypeId"
			validate="Patient Type,string,yes" tabindex="1"
			onchange="calculateValidUptoDateInAjax('updateRegistration');displayCompanyList();"
			onchange="checkForPatientType();">
				<%
		}
	%>

				<option value="0" selected="selected">select</option>
				<%
		String registrationValidDate = "";
				int validationDays = 0;
				for (MasPatientType masPatientType : patientTypeList) {
					if (patient.getPatientType() != null) {
						if (masPatientType.getId().equals(
								patient.getPatientType().getId())) {
							validationDays = masPatientType.getValidity();
	%>
				<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
				<%
						} else {
					%>
				<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
				<%
					}
								} else {
				%>
				<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
				<%
		}
				}
	%>
		</select>
			<script type="text/javascript">
document.updateRegistration.<%=PATIENT_TYPE%>.focus();
</script>
			<%
	if (cardValidFlag) {
		if (validationDays > 0) {
			registrationValidDate = HMSUtil
					.getNextDate(validationDays);
		}
	} else {
				if (validationDays > 0) {
					registrationValidDate = HMSUtil
							.getNextDate(validationDays);
				}
			}
%>
			<!-- Code For Company List -->
			<%
	//String fileSeparator = System.getProperty("file.separator");

String uploadURL ="";
if(map.get("uploadURL")!=null){
	uploadURL=(String)map.get("uploadURL");
}

if (patient.getPatientImage()!=null) {
				String path="";
				path=uploadURL+hin_no;
				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						File someFile = new File(path+"\\"+hin_no + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path+"\\"+hin_no + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String imgfile =path+"\\"+hin_no+".jpg";

				%>


			<div class="clear"></div>


			<label class="">Patient Photo</label>
			<img id="img1" style="border: 5px solid"
			src="/hms/uploadedImage/<%=hin_no %>/<%=hin_no %>.jpg" width="210px"
			height="155px" />


			<%
 	}
 %>

			<!--
 Code for Image Upload
 Code By Mukesh Narayan Singh
 Date 14 Oct 2010
  -->
			<label class="auto">Update Image</label>
			<jsp:include page="testImageUpload.jsp" />
			<div class="division"></div>
			<!--
 End Of Code for Image Upload
 Code By Mukesh Narayan Singh
 Date 14 Oct 2010
  -->


			<%
 if(patient.getCompany()!=null)
 {
	 %>
			<label id="companyLable"><span>*</span> Company</label>
			<select name="<%=COMPANY%>" id="comId" validate="Company,string,no"
			tabindex="2" onchange="checkForPatientType();">
				<option value="0">Select</option>
				<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getId() == patient.getCompany().getId()) {
	%>
				<option value="<%=masCompany.getId()%>" selected="selected"><%=masCompany.getCompanyName()%></option>
				<%
		}
	}
	%>
		</select>
			<%}%>
			<label id="companyLable" style="display: none;"><span>*</span>
				Company</label>
			<label id="insuranceLable" style="display: none;"><span>*</span>
				Company</label>
			<div id="company" style="display: none;">
				<select name="<%=COMPANY%>" id="comId" validate="Company,string,no"
					tabindex="2" onchange="checkForPatientType();">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 1) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>
			<div id="insurance" style="display: none;">
				<select name="<%=COMPANY%>" id="insId" validate="Company,string,no"
					tabindex="3">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 7) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>

			<label id="insAmtlbl" style="display: none;"><span>*</span>
				Amount</label>
			<div id="insAmt" style="display: none;">
				<input type="text" id="" name="" value="" tabindex="4" title=""
					MAXLENGTH="15" />
			</div>
			<label id="employeelbl" style="display: none;"><span>*</span>Employee</label>
			<div id="employeeDiv" style="display: none;">
				<select name="<%=EMPLOYEE_ID%>" id="employeeId"
					validate="Employee,string,no" tabindex="5">
					<option value="0">Select</option>
					<%
		for (MasEmployee masEmployee : employeeList) {
					String employeeName = "";
					employeeName = masEmployee.getFirstName();
					if (masEmployee.getMiddleName() != null) {
						employeeName += " " + masEmployee.getMiddleName();
					}
					if (masEmployee.getLastName() != null) {
						employeeName += " " + masEmployee.getLastName();
					}
	%>
					<option value="<%=masEmployee.getId()%>"><%=employeeName%></option>
					<%
		}
	%>
				</select>
			</div>
			<!-- End Of Code for Company Date 19 July 2010 Code By Mukesh Narayan Singh-->
			<label id="employeeDependentlbl" style="display: none;"><span>*</span>Employee
				Dependent</label>
			<div id="employeeDependentDiv" style="display: none;">
				<select name="<%=EMPLOYEE_DEPENDENT_ID%>" id="employeeDependentId"
					validate="Employee Dependent,string,no" tabindex="6"
					onblur="getDepandentDetails();">
					<option value="0">Select</option>
					<%
		for (MasEmployeeDependent masEmployeeDependent : employeeDependentList) {
	%>
					<option value="<%=masEmployeeDependent.getId()%>"><%=masEmployeeDependent
								.getEmployeeDependentName()%></option>
					<%
		}
	%>
				</select>
			</div>
			<input type="hidden" name="depndtRelation" id="depndtRelation"
			value="" />
			<label id="prjlbl" style="display: none;"><span>*</span>Project</label>
			<div id="prjDiv" style="display: none;">
				<select name="<%=PROJECT_ID%>" id="prjId"
					validate="Project,string,no" tabindex="7">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 4) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>


			<div class="clear"></div>
			<label>Title</label>
			<select id="titleId" name="<%=TITLE%>" validate="Title,string,no">
				<option value="0">Select</option>
				<%
		for (MasTitle masTitle : titleList) {
	%>
				<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
				<%
		}
	%>

		</select>
			<script type="text/javascript">
<%if (patient.getTitle() != null) {
						int titleId = patient.getTitle().getId();%>
document.updateRegistration.<%=TITLE%>.value = '<%=titleId%>';
<%}%>
</script>
			<label>Valid Up To</label>
			<input type="text" name="validUpTo" id="validUpToId"
			value="<%=registrationValidDate%>" maxlength="6" readonly="readonly"
			class="readOnly" />

			<label>Aadhaar No.</label>
			<input type="text" id="pAadhaarNumberId" name="<%=P_AADHAAR_NUMBER%>"
			value="<%=patient.getAadhaarNo()!=null?patient.getAadhaarNo():"" %>"
			tabindex="1" validate="Aadhaar No,int,no" MAXLENGTH="12" />

			<div class="clear"></div>
			<label><span>*</span> First Name</label>
			<input type="text" id="pFirstNameId" name="<%=P_FIRST_NAME%>"
			value="<%=patient.getPFirstName()%>"
			validate="First Name,alphaspace,yes" MAXLENGTH="15" tabindex="1" />
			<input type="hidden" name="pFirstNameIdTemp" id="pFirstNameIdTemp"
			value="" />
			<label>Middle Name</label>
			<%
 	if (patient.getPMiddleName() != null
 					&& !(patient.getPMiddleName().equals(""))) {
 %>
			<input type="text" name="<%=P_MIDDLE_NAME%>" id="pMiddleNameId"
			value="<%=patient.getPMiddleName()%>" validate="Middle Name,name,no"
			MAXLENGTH="15" tabindex="1" />
			<%
 	} else {
 %>
			<input type="text" name="<%=P_MIDDLE_NAME%>" id="pMiddleNameId"
			value="" validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" />
			<%
 	}
 %><input type="hidden" name="pMiddleNameIdTemp" id="pMiddleNameIdTemp"
			value="" />
			<label>Last Name</label>
			<%
 	if (patient.getPLastName() != null
 					&& !(patient.getPLastName().equals(""))) {
 %>
			<input type="text" name="<%=P_LAST_NAME%>" id="pLastNameId"
			value="<%=patient.getPLastName()%>" validate="Last Name,name,no"
			MAXLENGTH="15" tabindex="1" />
			<%
 	} else {
 %>
			<input type="text" id="pLastNameId" name="<%=P_LAST_NAME%>" value=""
			validate="Last Name,name,no" MAXLENGTH="15" tabindex="1" />
			<%
 	}
 %>
			<input type="hidden" name="pLastNameIdTemp" id="pLastNameIdTemp"
			value="" />
			<div class="clear"></div>

			<label><span>*</span> Gender</label>
			<select name="<%=GENDER%>" id="gender" validate="Gender,string,yes"
			tabindex="1">
				<%
		for (MasAdministrativeSex masAdministrativeSex : sexList) {
	%>
				<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex
								.getAdministrativeSexName()%></option>
				<%
		}
	%>
		</select>
		<input type="hidden" name="genderTemp" id="genderTemp" value="0" />
			<script type="text/javascript">
<%if (patient.getSex() != null) {
						int sexId = patient.getSex().getId();%>
document.updateRegistration.<%=GENDER%>.value = '<%=sexId%>';
<%}%>
</script>
			<label>DOB</label>
			<%
 	if (patient.getDateOfBirth() != null) {
 %>
			<input type="text" id="dobId" name="<%=DATE_OF_BIRTH%>"
			value="<%=HMSUtil
								.convertDateToStringWithoutTime(patient
										.getDateOfBirth())%>"
			readonly="readonly" validate="Date of Birth,date,no" MAXLENGTH="30"
			onchange="calculateAgeInAjax('updateRegistration');" class="date"
			tabindex="1" />
			<div id="dobcalId">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date" tabindex="1"
					onclick="javascript:setdate('',document.updateRegistration.<%=DATE_OF_BIRTH%>,event);"
					onblur="calculateAgeInAjax('updateRegistration');"
					onchange="calculateAgeInAjax('updateRegistration');" />
			</div>

			<%
	} else {
%>
			<!--
Code commented By Mukesh
If DOB is null then DOb Enter

<label class="value">-</label>
-->
			<input type="text" id="dobId" name="<%=DATE_OF_BIRTH%>" value=""
			readonly="readonly" validate="Date of Birth,date,no" MAXLENGTH="30"
			onchange="calculateAgeInAjax('updateRegistration');" class="date"
			tabindex="1" />
			<div id="dobcalId">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date" tabindex="1"
					onclick="javascript:setdate('',document.updateRegistration.<%=DATE_OF_BIRTH%>,event);"
					onblur="calculateAgeInAjax('updateRegistration');"
					onchange="calculateAgeInAjax('updateRegistration');" />
			</div>
			<%
 	}
 %>
			<label>Age</label>
			<%
 	if (patient.getAge() != null) {
 				int age = 0;
				if(patient.getDateOfBirth()!=null){
 				 age = HMSUtil.getCurrentAgeByDoB(patient
 						.getDateOfBirth());
				}
 				String ageTempPatient = patient.getAge();
 				String ageArr[] = ageTempPatient.split(" ");
 				String ageUnitTemp = "";
 				try{
 				if (ageArr[1] != null) {

 					if (ageArr[1] != null) {
 						ageUnitTemp = ageArr[1];
 					} else {
 						ageUnitTemp = "";
 					}

 				}
 				}catch (Exception e) {
 		    	     System.err.println("Error: " + e.getMessage());
 		  	      e.printStackTrace();
 		  	    }
 %>
			<!--<label class="value"><%=patient.getAge()%></label> -->
			<input type="text" name="<%=AGE%>" id="age" value="<%=age%>"
			readonly="readonly" class="small" maxlength="2" tabindex="15"
			validate="Age,string,no" onblur="checkForDOB();" />
			<input type="text" id="ageUnitId" name="<%=AGE_UNIT%>"
			value="<%=ageUnitTemp%>" validate="AgeUnit,string,no" tabindex="16"
			class="small" readonly="readonly" onblur="checkForDOB();" />

			<%
	}
%>
			<input type="hidden" name="ageTemp" id="ageTemp" value="" />
			<input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" />
			<input type="hidden" name="ageUnitIdTemp" id="ageUnitIdTemp" value="" />
			<div class="clear"></div>

			<label><span>*</span> Religion</label>
			<select name="<%=RELIGION%>" id="religionId"
			validate="Religion,string,yes" tabindex="17">
				<option value="0">Select</option>
				<%
		for (MasReligion masReligion : religionList) {
	%>
				<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
				<%
		}
	%>
		</select>
			<script type="text/javascript">
<%if (patient.getReligion() != null) {
						int religionId = patient.getReligion().getId();%>
document.updateRegistration.<%=RELIGION%>.value = '<%=religionId%>';
<%}%>
</script>
			<input type="hidden" name="religionIdTemp" id="religionIdTemp"
			value="0" />
			<input type="hidden" name="casteIdTemp" id="casteIdTemp" value="0" />
			<input type="hidden" name="addrTemp" id="addrTemp" value="" />

			<label>Caste</label>
			<select id="casteId" name="<%=CASTE%>" validate="caste,string,no"
			tabindex="18">
				<option value="0">Select</option>
				<%
	for (MasCaste masCaste : casteList) {
%>
				<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
				<%
	}
%>
		</select>
			<script type="text/javascript">
<%if (patient.getCaste() != null) {
						int casteId = patient.getCaste().getId();%>
document.updateRegistration.<%=CASTE%>.value = '<%=casteId%>';
<%}%>
</script>
			<label>Address</label>
			<%
 	if (patient.getAddress() != null) {
 %>
			<textarea name="<%=ADDRESS%>" id="addr" cols="20" rows="2"
				validate="Address,string,no" onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"><%=patient.getAddress()%></textarea>
			<%
 	} else {
 %>
			<textarea name="<%=ADDRESS%>" cols="20" rows="2"
				validate="Address,string,no" id="addr"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"></textarea>
			<%
 	}
 %>
			<input type="hidden" name="addrTemp" id="addrTemp" value="" />
			<script type="text/javascript">

<%int counter = 0;
					for (MasCountry masCountry : countryList) {
						for (MasState masState : stateList) {
							if (masState.getCountry() != null) {
								if (masCountry.getId().equals(
										masState.getCountry().getId())) {%>
stateArr[<%=counter%>] = new Array();
stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
stateArr[<%=counter%>][1] = <%=masState.getId()%>;
stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
<%counter++;
								}
							}
						}
					} %>
</script>

			<div class="clear"></div>
	</div>
	<!-- Closed Div for block -->
	<div class="clear"></div>
	<div class="clear"></div>
	<h4>Contact Information</h4>
	<div class="Block">
		<label><span>*</span> Country</label> <select name="nationality"
			validate="Nationality,string,yes"
			onChange="populateState(this.value,'updateRegistration')"
			onblur="populateState(this.value,'updateRegistration')" tabindex="1"
			id="countryId">
			<option value="0">Select</option>
			<%
		for (MasCountry cntMaster : countryList) {
			
	%>
			<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
			<%
		}
	%>
		</select>
		<script type="text/javascript">
<%if (patient.getCountry() != null) {
						int countryId = patient.getCountry().getId();%>
						//alert("alert"+document.updateRegistration.<%=NATIONALITY%>.value);

document.getElementById('countryId').value='<%=countryId%>';
<%}%>
</script>
		<div class="clear"></div>
		<label><span>*</span> State</label> <select name="state"
			validate="State,string,yes" id="stateId"
			onChange="populateDistrict(this.value,'updateRegistration')"
			onblur="populateDistrict(this.value,'updateRegistration')"
			tabindex="1">
			<option value="0">Select</option>
			<%
		for (MasState masState : stateList) {
			if(patient.getState() !=null){
				if(patient.getState().getId().equals(masState.getId())){
	%>
			<option value="<%=masState.getId()%>" selected="selected"><%=masState.getStateName()%></option>
			<%}else{ %>
			<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
			<%} }else{ %>
			<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
			<%
		}}
	%>
		</select> <label><span>* </span>Native Place</label> <select name="nativePlace"
			id="nativePlace" validate="Native Place,string,yes">
			<option value="0">Select</option>
			<%for(MasState nativePlace:nativePlaceList){
	if(patient.getNativePlace()!=null && patient.getNativePlace().getId()==nativePlace.getId()){
	%>
			<option selected="selected" value="<%=nativePlace.getId() %>"><%=nativePlace.getStateName() %></option>
			<%}else{ %>
			<option value="<%=nativePlace.getId() %>"><%=nativePlace.getStateName() %></option>
			<%} }%>
		</select> -
		<%-- <script type="text/javascript">
<%int stateId = 0;
					if (patient.getState() != null) {
						stateId = patient.getState().getId();%>
document.updateRegistration.<%=STATE%>.value = '<%=stateId%>';
<%}%>
</script> --%>
		<label>District</label>
		<%
				if (blockStatus.equalsIgnoreCase("n")
						& postOfficeStatus.equalsIgnoreCase("n")) {
	%>
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
			validate="District,string,no"
			onChange="populateVillageFromDist(this.value);">
			<%
		} else if (!blockStatus.equalsIgnoreCase("n")
						& postOfficeStatus.equalsIgnoreCase("n")) {
	%>
			<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
			validate="District,string,no"
			onChange="populateBlock(this.value,'updateRegistration');">
				<%
			} else if (blockStatus.equalsIgnoreCase("n")
							& !postOfficeStatus.equalsIgnoreCase("n")) {
		%>
				<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
				validate="District,string,no"
				onChange="populateDistrictPostOffice(this.value,'updateRegistration')">
					<%
				} else {
			%>
					<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
					validate="District,string,no"
					onChange="populateBlock(this.value,'updateRegistration');">
						<%
					}
				%>
						<option value="0">Select</option>
						<%
				 int stateId=0;
			if(patient.getState()!=null){
				stateId=patient.getState().getId();
			}
		for (MasDistrict masDistrict : districtList) {
					if (masDistrict.getState().getId() == stateId) {
	%>
						<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
						<%
		}
				}
	%>
				</select>
					<script type="text/javascript">
<%if (patient.getDistrict() != null) {
						int districtId = patient.getDistrict().getId();%>
document.updateRegistration.<%=DISTRICT%>.value = '<%=districtId%>';
<%}%>
</script>
					<div id="disableBlock" style="display: none">
						<label><span>*</span> Block</label>
						<%
	if (postOfficeStatus.equalsIgnoreCase("n")) {
%>
						<select name="<%=BLOCK%>" validate="Block,string,no" tabindex="23"
							validate="Block,string,yes" id="blockId"
							onchange="populateVillageOfBlock(this.value);"
							onblur="populatePostOff(this.value);">
							<%
					} else {
				%>
							<select name="<%=BLOCK%>" validate="Block,string,no"
							tabindex="23" validate="Block,string,yes" id="blockId"
							onchange="populatePostOff(this.value);"
							onblur="populatePostOff(this.value);">
								<option value="0">Select</option>
								<%
						}
					%>
								<option value="0">Select</option>
								<%
		for (MasBlock masBlock : blockList) {
					if (masBlock.getDistrict() != null) {
						if(patient.getDistrict()!=null){
							if (masBlock.getDistrict().getId().equals(
									patient.getDistrict().getId())) {
								if (patient.getBlock() != null
										&& patient.getBlock().getId().equals(
												masBlock.getId())) {
		%>
								<option value="<%=masBlock.getId()%>" selected="selected"><%=masBlock.getBlockName()%></option>
								<%
			} else {
		%>
								<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
								<%
			}
							}
						}else{
					%>
								<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
								<%
						}
						}

					//}
				}
	%>
						</select>


							<div class="clear"></div>
					</div>

					<div id="disablePostOffice" style="display: none">
						<label><span>*</span> Post Office</label> <select
							name="<%=POST_OFFICE%>" id="postOff"
							onchange="populateVillage(this.value);"
							onblur="populateVillage(this.value);" tabindex="1">
							<option value="0">Select</option>
							<%
				for (MasPostCode postCode : postCodeList) {
					if (postCode.getBlock() != null
							&& patient.getBlock() != null && patient.getPostCode()!=null) {
						if (postCode.getBlock().getId() == patient
								.getBlock().getId()) {
							if (patient.getPostCode() != null
									&& patient.getPostCode().getId()
											.equals(postCode.getId())) {
	%>
							<option value="<%=patient.getPostCode().getId()%>"
								selected="selected"><%=patient.getPostCode()
											.getPostCodeName()%></option>
							<%
		} else {
	%>
							<option value="<%=postCode.getId()%>"><%=postCode.getPostCodeName()%></option>

							<%
		}
						}
					}else {
						%>
							<option value="<%=postCode.getId()%>"><%=postCode.getPostCodeName()%></option>

							<%
							}
				}
	%>
						</select>
					</div>
					<%
	if (!blockStatus.equalsIgnoreCase("Y")) {
%>
					<div class="clear"></div>
					<%
				}
			%>
					<script type="text/javascript">
<%int countDistrctPO = 0;
					for (MasDistrict masDistrict : districtList) {
						for (MasPostCode masPostCode : postCodeList) {
							if (masPostCode.getBlock() != null) {
								if (masDistrict.getId().equals(
										masPostCode.getBlock().getDistrict()
												.getId())) {%>
			districtPostOfficeArray[<%=countDistrctPO%>] = new Array();
			districtPostOfficeArray[<%=countDistrctPO%>][0] = <%=masDistrict.getId()%>;
			districtPostOfficeArray[<%=countDistrctPO%>][1] = <%=masPostCode.getId()%>;
			districtPostOfficeArray[<%=countDistrctPO%>][2] = "<%=masPostCode.getPostCodeName()%>";

			<%countDistrctPO++;
								}
							}
						}
					}%>
</script>
			</select>


				<label> Village</label>
				<select name="<%=PATIENT_DISTRICT%>" id="patientDistId"
				validate="Village,string,no" tabindex="1">

					<option value="0">Select</option>
					<%
		for (MasVillage village : villageList) {
					if (village.getPostCode() != null && patient.getVillage()!=null && patient.getPostCode()!=null) {
						if (village.getPostCode().getId().equals(
								patient.getPostCode().getId())) {
							if (patient.getVillage() != null
									&& patient.getVillage().getId().equals(
											village.getId())) {
	%>
					<option value="<%=village.getId()%>" selected="selected"><%=patient.getVillage()
											.getVillageName()%></option>
					<%
		} else {
	%>
					<option value="<%=village.getId()%>"><%=village.getVillageName()%></option>

					<%
		}
						}
					}else {
						%>
					<option value="<%=village.getId()%>"><%=village.getVillageName()%></option>

					<%
							}
				}
	%>
			</select>
				<label>Pincode</label>
				<%
 	if (patient.getPinCode() != null) {
 %>
				<input type="text" name="<%=PINCODE%>"
				value="<%=patient.getPinCode()%>" id="pinCodeId"
				validate="Pincode,int,no" maxlength="8" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	} else {
 %>
				<input type="text" name="<%=PINCODE%>" value=""
				validate="Pincode,int,no" id="pinCodeId" maxlength="8" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	}
 %>

				<div class="clear"></div>



				<label>Police Station</label>
				<%
if(patient.getPoliceStation() != null){
%>
				<input type="text" name="<%=POLICE_STATION %>"
				value="<%=patient.getPoliceStation() %>"
				validate="Police Station,alphaspace,no" MAXLENGTH="30" tabindex="1" />
				<%}else{ %>
				<input type="text" name="<%=POLICE_STATION %>" value=""
				validate="Police Station,alphaspace,no" MAXLENGTH="30" />
				<%} %>

				<label>Phone</label>
				<%
	if (patient.getPhoneNumber() != null) {
%>
				<input type="text" name="<%=PHONE%>" id="phone"
				value="<%=patient.getPhoneNumber()%>" validate="Phone,phone,no"
				MAXLENGTH="16" tabindex="1" onkeypress="return isNumberKey(event)" />
				<%
 	} else {
 %>
				<input type="text" name="<%=PHONE%>" value="" class="textbox_size20"
				id="phone" validate="Phone,phone,no" MAXLENGTH="16" tabindex="1"
				onkeypress="return isNumberKey(event)" onb />
				<%
 	}
 %>
				<label>Mobile</label>
				<%
	if (patient.getMobileNumber() != null) {
%>
				<input type="text" name="<%=MOBILE%>" id="mobile"
				value="<%=patient.getMobileNumber()%>"
				validate="Mobile Number,phone,no" MAXLENGTH="12" tabindex="1"
				onkeypress="return isNumberKey(event)" />
				<%
 	} else {
 %>

				<input type="text" name="<%=MOBILE%>" value=""
				class="textbox_size20" id="mobile"
				style="border: 1px solid #7f9db7;" validate="Mobile Number,phone,no"
				MAXLENGTH="12" tabindex="1" onkeypress="return isNumberKey(event)" />
				<%
 	}
 %>


				<div class="clear"></div>


				<label>Email Id</label>
				<%
 	if (patient.getEmailId() != null) {
 %>
				<input type="text" name="<%=EMAIL_ID%>" id="email"
				value="<%=patient.getEmailId()%>" validate="Email Id,email,no"
				MAXLENGTH="40" tabindex="1" onblur="validateForm();" />
				<%
 	} else {
 %>
				<input type="text" name="<%=EMAIL_ID%>" id="email"
				name="<%=EMAIL_ID%>" value="" validate="Email Id,email,no"
				MAXLENGTH="40" tabindex="1" onblur="validateForm();" />
				<%
 	}
 %>
				<label>Occupation</label>
				<select name="<%=OCCUPATION_ID%>" validate="Occupation,string,no"
				class="select_adt" tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasOccupation masOccupation : occupationList) {
	%>
					<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getOccupation() != null) {
						int occupationId = patient.getOccupation().getId();%>
document.updateRegistration.<%=OCCUPATION_ID%>.value = '<%=occupationId%>';
<%}%>
</script>
				<label>Marital Status</label>
				<select name="<%=MARITAL_STATUS_ID%>"
				validate="Marital Status,string,no">
					<option value="0">Select</option>
					<%
		for (MasMaritalStatus masMaritalStatus : maritalStatusList) {
	%>
					<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getMaritalStatus() != null) {
						int maritalStatusId = patient.getMaritalStatus()
								.getId();%>
document.updateRegistration.<%=MARITAL_STATUS_ID%>.value = '<%=maritalStatusId%>';
<%}%>
</script>

				<div class="clear"></div>

				<label>Reference</label>
				<select name="<%=REFERENCE%>" validate="Reference,string,no"
				tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasReference masReference : referenceList) {
	%>
					<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getReference() != null) {
						int referenceId = patient.getReference().getId();%>
document.updateRegistration.<%=REFERENCE%>.value = '<%=referenceId%>';
<%}%>
</script>
				<label><span>*</span> Relative Name</label>
				<%
 	if (patient.getNextOfKinName() != null) {
 %>
				<input type="text" name="<%=RELATIVE_NAME%>" id="nokNameId"
				value="<%=patient.getNextOfKinName()%>"
				validate="Relative Name,fullName,yes" maxlength="30" tabindex="1" />
				<%
 	} else {
 %>
				<input type="text" name="<%=RELATIVE_NAME%>" value="" id="nokNameId"
				validate="Relative Name,fullName,yes" maxlength="30" tabindex="1" />
				<%
 	}
 %>
				<input type="hidden" name="relativeNameTemp" id="relativeNameTemp"
				value="" />
				<div class="clear"></div>


				<label><span>*</span> Relation</label>
				<select name="<%=RELATION_ID%>" id="realtionId"
				validate="Relation,string,yes" tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasRelation masRelation : relationList) {
			if(patient.getRelation()!=null ){
			if(patient.getRelation().getId().equals(masRelation.getId())){
	%>
					<option value="<%=masRelation.getId()%>" selected="selected"><%=masRelation.getRelationName()%></option>
					<%}else{%>
					<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
					<% }}%>
					<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getNextOfKinRelation() != null) {
						int nokRelationId = patient.getNextOfKinRelation()
								.getId();%>
document.getElementById("realtionId").value = '<%=nokRelationId%>';
<%}%>
</script>
				<label>Relative Phone</label>
				<%
 	if (patient.getNextOfKinPhoneNumber() != null) {
 %>
				<input type="text" name="<%=EMERGENCY_PHONE%>" id="emphine"
				value="<%=patient.getNextOfKinPhoneNumber()%>"
				onkeypress="return isNumberKey(event);"
				validate="Kin Phone,phone,no" maxlength="16" tabindex="1" />
				<%
 	} else {
 %>
				<input type="text" name="<%=EMERGENCY_PHONE%>" value="" id="emphine"
				validate="Kin Phone,phone,no" maxlength="16" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	}
 %>
				<label>Relative Address</label>
				<%
 	if (patient.getNextOfKinAddress() != null) {
 %>
				<textarea name="<%=EMERGENCY_ADDRESS%>"
					validate="Kin Address,string,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" maxlength="250"
					tabindex="1"><%=patient.getNextOfKinAddress()%></textarea>
				<%
	} else {
%>
				<textarea name="<%=EMERGENCY_ADDRESS%>"
					validate="Kin Address,string,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" maxlength="250"
					tabindex="1"></textarea>
				<%
 	}
 %>

				<div class="clear"></div>

				<label>Remarks</label>
				<%
 	if (patient.getRemarks() != null) {
 %>
				<textarea name="<%=REMARKS%>" cols="99" rows="2"
					validate="Remarks,string,no" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
					tabindex="1" maxlength="50"><%=patient.getRemarks()%></textarea>
				<%
 	} else {
 %>
				<textarea name="<%=REMARKS%>" cols="99" rows="2"
					validate="Remarks,string,no" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" tabindex="1"
					maxlength="50"></textarea>
				<%
 	}
 %>
				<div class="clear"></div>
	</div>

	<!-- Patient details  section Ends-->
	<%
 	if (visitList.size() > 0) {}
%>

	<!-- Visit details  section Ends-->
	<!-- OTHER DETAILS  section  starts-->


	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<!--  Code for billing if registraion updated
Code By Mukesh Narayan SIngh
Date 16 July 2010
if cardValidFlag=false then billing is required
-->
	<%
			//if(!cardValidFlag){
%>

	<div class="clear"></div>
	<div class="division"></div>

	<div class="titleBg">
		<h2><%=prop.getProperty("com.jkt.hms.bill_heading")%></h2>
	</div>
	<div class="clear"></div>

	<div class="Block">
		<div class="clear"></div>
		<label>Billing Required (No)</label> <input type="radio"
			name="<%=SELECTED_RADIO%>" id="rad" value="1" checked="checked"
			class="radioCheck" /> <label>Billing Required (Yes)</label> <input
			type="radio" name="<%=SELECTED_RADIO%>" id="rad1" value="2"
			class="radioCheck" />

		<div class="clear"></div>


		<div id="testDiv">
			<label><%=prop.getProperty("com.jkt.hms.bill_no")%></label> <input
				type="text" id="billNo" class="readOnly" name="billNo"
				value="<%=billNo%>" readonly="readonly"
				title="Bill No of the Patient" validate="Bill No,int,no"
				MAXLENGTH="15" />
			<div id="amount">
				<label>Amount</label> <input type="text" id="amt" name="amt"
					value="<%=amount.setScale(2, BigDecimal.ROUND_HALF_UP)%>"
					MAXLENGTH="4" readonly="readonly" class="readOnly" /> <input
					type="hidden" name="billamt" id="billamt" value="<%=rate%>"
					MAXLENGTH="4" class="readOnly" readonly="readonly" /> <input
					type="hidden" name="stdDeduction" id="stdDeduction"
					value="<%=stdDeduction%>" MAXLENGTH="4" class="readOnly"
					readonly="readonly" /> <input type="hidden" name="discAmt"
					id="discAmt" value="<%=discAmt%>" MAXLENGTH="4" class="readOnly"
					readonly="readonly" />
			</div>
		</div>


		<label>Registration Type</label> <select name="regisType"
			id="regisType" tabindex="45"
			onchange="submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount','amount')">
			<option value="G">General</option>
			<option value="S">Special</option>
		</select> <input type="hidden" name="<%=CONSULTING_DOCTOR%>"
			id="consultingDocId" value="0" /> <input type="hidden"
			name="<%=CASE_TYPE_ID%>" value="0" />
		<div class="clear"></div>

		<label><span>*</span> Charge</label> <select name="registrationType"
			id="registrationType" tabindex="46" onblur="checkForPatientType();"
			onfocus="checkForPatientType();">
			<%
	
		for (MasChargeCode masChargeCode : chargeCodeList) {
					if (masChargeCode.getId() != regChargeId) {
						if(masChargeCode.getId()==1253){
	%>
			<option value="<%=masChargeCode.getId()%>" selected="selected"><%=masChargeCode.getChargeCodeName()%></option>

			<%
						}else{%>
			<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
			<%}}
				}
	%>
		</select> <label><%=prop.getProperty("com.jkt.hms.discount")%></label> <input
			type="text" id="discount" tabindex="47" name="discount" value=""
			validate="<%=prop.getProperty("com.jkt.hms.discount")%>, int, no"
			MAXLENGTH="3" onblur="checkForDiscount();"
			onkeypress="return isNumberKey(event);" /> <label>Authorizer</label>
		<select name="refDoctor" id="refDoctor"
			validate="Ref Doctor,string,no" tabindex="48">
			<option value="0">Select</option>
			<%
		for (MasAuthorizer masAuthorizer : authorizerList) {
	%>
			<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
			<%
		}
	%>
		</select>

		<div class="clear"></div>

		<label><span>*</span>Actual Collected Amount</label> <input
			type="text" id="actualColAmtId" name="actualCollectedAmt"
			tabindex="49" onkeypress="return isNumberKey(event);"
			value="<%=amount.setScale(2, BigDecimal.ROUND_HALF_UP)%>"
			validate="Actual Collected Amount,float,no" maxlength="8" /> <input
			type="hidden" id="idForAge" name="idForAge" />
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="division"></div>

	<!-- End of code for billing
	Code by Mukesh Narayan Singh
	Date 16 July 2010
 -->
	<%
	//	}
%>
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
 	}
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
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=currentDate%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE%>" value="<%=currentDate%>" /> <input
			type="hidden" name="<%=CHANGED_TIME%>" value="<%=time%>" />
	</div>
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
// Code for disable and enabled block and post office
// code by mukesh Narayan Singh
// Date 12 July 2010
//disablePostOffice
var blockStatus="Y";
var postOfficeStatus="Y";

if(blockStatus=='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='inline';
	document.getElementById('disablePostOffice').style.display ='inline';
}else if(blockStatus=='<%=blockStatus%>' && postOfficeStatus!='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='inline';
	document.getElementById('disablePostOffice').style.display ='none';
}else if(blockStatus!='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='none';
	document.getElementById('disablePostOffice').style.display ='inline';
}else{
	document.getElementById('disableBlock').style.display ='none';
	document.getElementById('disablePostOffice').style.display ='none';
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

function employeeDepntList()
{
	var company = document.updateRegistration.<%=PATIENT_TYPE_ID%>.value;

	if(company == "2"){
	document.getElementById('employeeDependentDiv').style.display = "inline";
	document.getElementById('employeeDependentlbl').style.display = "inline";
	populateDepandentList();


	}else if (company != "2"){
	document.getElementById('employeeDependentDiv').style.display = "none";
	document.getElementById('employeeDependentlbl').style.display = "none";
	}
	if(company=="8")
	{
				obj=document.getElementById("employeeId");
				document.getElementById("pFirstNameId").value=obj.options[obj.selectedIndex].text;
				//document.getElementById("pFirstNameId").readonly=true;
	}
	document.updateRegistration.<%=EMPLOYEE_DEPENDENT_ID%>.focus();
}
function checkForDOB()
{

	if(document.getElementById("age").value!="" && document.getElementById("age").value>0)
	{
		var ageAtRegTime=document.getElementById("age").value;
		if(ageAtRegTime.indexOf(".")==1)
		{
			currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("ageUnitId").value;
		}
		else if(ageAtRegTime.indexOf(".")==-1)
		{
			currentAge=document.getElementById("age").value+" "+document.getElementById("ageUnitId").value;
		}
		document.getElementById('idForAge').value=currentAge;
		var apoxAge=calculateApproxDobFromAge();
		document.getElementById("dobId").value="";
		document.getElementById("dobId").value=apoxAge;
	}

	return true;
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
<SCRIPT language=Javascript>
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 46 || charCode > 57)){
             alert("Please Enter Numbers Only!!");
            return false;
         }else{
         return true;
         }
        
      }
      //-->
   </SCRIPT>
<script>
function validateForm()
{
var x="";
x=document.getElementById("email").value;

var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
</script>
<script>function checkMaxLengthMozJsp(obj){
	//alert(obj);
     if(obj.value.length>50){
        alert("you are crossing maximum length limit pls reduce the some text");
	        return true;
    	}
    }
}</script>
<script language="JavaScript">
 function resetForm(){
   document.getElementById("updateRegistration").reset();
 } 
 function calform(){
	 var relation=document.getElementById("realtionId").value;
	 var relative=document.getElementById("nokNameId").value;
	 var nationality=document.getElementById("countryId").value;
	 var state=document.getElementById("stateId").value;
	 var phone=document.getElementById("phone").value;
	 var mobile=document.getElementById("mobile").value;
	 var emphine=document.getElementById("emphine").value;
	 var patientTypeId=document.getElementById("patientTypeId").value;
	 var nativePlaceId=document.getElementById("nativePlace").value;
	 //alert("---->>>"+nativePlaceId);
	 //alert(document.getElementById("nativePlace"));
	 if(document.getElementById("nativePlace").value=="0"){
		 alert("Please Select Native Place");
		 return false;
		 }else{
	 submitForm('updateRegistration','/hms/hms/registration?method=updatePatientInformation&nativePlace='+nativePlaceId+'&<%=RELATION_ID%>='+relation+'&relative='+relative+'&nationality='+nationality+'&state='+state+'&<%=PHONE%>='+phone+'&<%=MOBILE%>='+mobile+'&<%=EMERGENCY_PHONE%>='+emphine+'&<%=PATIENT_TYPE_ID%>='+patientTypeId);
	 }
	 }
</script>
<%
	authorizerList = null;
	blockList = null;
	caseTypeList = null;
	casteList = null;
	chargeCodeList = null;
	companyList = null;
	countryList = null;
	departmentList = null;
	diagnosisList = null;
	employeeDependentList = null;
	employeeList = null;
	maritalStatusList = null;
	nativePlaceList = null;
	sexList = null;
	stateList = null;
	titleList = null;
	unitList = null;
	uploadDocumentsList = null;
	villageList = null;
	visitList = null;
	authorizerList = null;
	blockList = null;
%>