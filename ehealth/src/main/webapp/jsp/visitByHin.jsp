<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * visitByHin.jsp
 * Purpose of the JSP -  This is for Visit By HIN.
 * @author  Ritu
 * Create Date: 08th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.22
--%>

<%@page import="java.util.Date"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="static jkt.hms.util.RequestConstants.GENDER"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@page import="static jkt.hms.util.RequestConstants.VISIT_NUMBER"%>
<%@page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.PROJECT_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.COMPANY"%>
<%@page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.CASE_TYPE_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@page import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@page import="static jkt.hms.util.RequestConstants.COMPLAINT_ID"%>
<%@page import="static jkt.hms.util.RequestConstants.VISIT_TIME"%>
<%@page import="static jkt.hms.util.RequestConstants.VISIT_DATE"%>
<%@page import="static jkt.hms.util.RequestConstants.PATIENT_TYPE"%>
<%@page import="static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta> 
<body onload="changeAmount2();">
<script>
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String date=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
	month="0"+month;
}
if(date.length()<2){
	date="0"+date;
}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
Map<String, Object> patientMap = new HashMap<String, Object>();
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
List<Patient> patientList = new ArrayList<Patient>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
List<MasChargeCode>chargeCodeList=new ArrayList<MasChargeCode>();
List<MasAuthorizer>authorizerList=new ArrayList<MasAuthorizer>();
List<MasPatientType>patientTypeList=new ArrayList<MasPatientType>();
List<MasCompany>companyList=new ArrayList<MasCompany>();
List<MasEmployeeDependent>employeeDependentList=new ArrayList<MasEmployeeDependent>();

String billNo="";

BigDecimal amount=new BigDecimal(0.00);
BigDecimal rate=new BigDecimal(0.00);
BigDecimal stdDeduction = new BigDecimal(0.00);
BigDecimal discAmt = new BigDecimal(0.00);

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
int newVisits=0;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
List<Object[]> totalDoctorVisits = new ArrayList<Object[]>();

if(map.get("patientMap") != null){
	patientMap = (Map<String,Object>)map.get("patientMap");
}

if(patientMap.get("patientList") != null){
	patientList = (List<Patient>)patientMap.get("patientList");
	session.setAttribute("patientList", patientList);
}else if(session.getAttribute("patientList") != null){
	patientList = (List<Patient>)session.getAttribute("patientList");
}

Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}

String departmentTypeCodeForCR = properties.getProperty("departmentTypeCodeForCR");
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

if(patientList.size() > 0)
{
	Patient patient = patientList.get(0);
	if(!patient.getPatientStatus().equals("Expired")){
		String age = "";
		String currentAge = "";
		age = patient.getAge();
		//currentAge = HMSUtil.calculateAgeForADT(age, patient.getDateOfBirth());
		try{
		currentAge = HMSUtil.calculateAgeForADT(age, new Date());
		}catch(Exception e){
			e.printStackTrace();
			currentAge=""+age;
		}

	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}

	if(detailsMap.get("departmentList") != null){
		departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
	}
	if(detailsMap.get("totalDoctorVisits") != null){
		totalDoctorVisits = (List<Object[]>)detailsMap.get("totalDoctorVisits");
	}
	if(detailsMap.get("employeeList") != null){
		employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
	}
	if(detailsMap.get("complaintList") != null){
		complaintList = (List<MasComplaint>)detailsMap.get("complaintList");
	}
	if(detailsMap.get("caseTypeList") != null){
		caseTypeList = (List<MasCaseType>)detailsMap.get("caseTypeList");
	}
	if(detailsMap.get("diagnosisList") != null){
		diagnosisList = (List<MasDiagnosisConclusion>)detailsMap.get("diagnosisList");
	}
	if(detailsMap.get("disposalList") != null){
		disposalList = (List<MasDisposal>)detailsMap.get("disposalList");
	}
	if(detailsMap.get("newVisits") != null){
		newVisits = (Integer)detailsMap.get("newVisits");
	}
	if(map.get("amount")!=null){
		amount=(BigDecimal)map.get("amount");
	}
	if(map.get("rate") != null){
		rate = (BigDecimal)map.get("rate");
	}
	if (map.get("discAmt") != null) {
		discAmt =  (BigDecimal)map.get("discAmt");
	}
	if (map.get("stdDeduction") != null) {
		stdDeduction = (BigDecimal)map.get("stdDeduction");
	}
	//
	if(detailsMap.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
	}
	if(detailsMap.get("authorizerList") != null){
		authorizerList = (List<MasAuthorizer>)detailsMap.get("authorizerList");
	}
	if(detailsMap.get("patientTypeList") != null){
		patientTypeList = (List<MasPatientType>)detailsMap.get("patientTypeList");
	}
	if(detailsMap.get("companyList") != null){
		companyList = (List<MasCompany>)detailsMap.get("companyList");
	}
	if(detailsMap.get("employeeDependentList") != null){
		employeeDependentList = (List<MasEmployeeDependent>)detailsMap.get("employeeDependentList");
	}
	if(map.get("billNo") != null){
		billNo= (String)map.get("billNo");
	}

	MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
	if(detailsMap.get("systemParam") != null){
		systemParam= (MasSetupParameterMaintaince)detailsMap.get("systemParam");
	}
	int visitChargeId = 0;
	if(systemParam.getVisitChargeCode() != null){
		visitChargeId = systemParam.getVisitChargeCode().getId();
	}
%>
<form name="visitByHin" method="post" id="onFocusForm">

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="titleBg">
<h2>Patient Visit</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
	class="valueMedium"><%=patient.getHinNo() %></label> <input
	name="hinNo" value="<%=patient.getHinNo() %>" type="hidden"> <%
			String middleName = "";
			String lastName = "";
			if(patient.getPMiddleName() != null){
				middleName = patient.getPMiddleName();
			}
			if(patient.getPLastName() != null){
				lastName = patient.getPLastName();
			}
String ptype="";
ptype=patient.getPatientType().getPatientTypeName();
int ptypeId=0;
ptypeId=patient.getPatientType().getId();
			%> <label>Patient Name</label> <label class="value"><%=patient.getPFirstName()+" "+middleName+" "+lastName%></label>


<label class="medium">Sex</label> <input type="hidden"
	name="<%=GENDER %>" id="<%=GENDER %>"
	value="<%=patient.getSex().getId() %>" /> <label class="valueMedium"><%=patient.getSex().getAdministrativeSexName() %></label>

<label class="medium">Age</label> <label class="valueMedium"><%=currentAge%></label>
<div class="clear"></div>
<%
		String religion = "";
		if(patient.getReligion() != null){
			religion = patient.getReligion().getReligionName();
		%> <label class="medium">Religion</label> <label class="value"><%=religion%></label>
<%} %> <label class="medium">District</label> <%
			if(patient.getDistrict() != null){
		%> <label class="value"><%=patient.getDistrict().getDistrictName() %></label>
<%}else{ %> <label class="value">-</label> <% }%> <label class="auto">Today's
Visits</label> <label class="valueMedium"><%=newVisits%></label> <label
	class="medium">Patient Type</label> <%
	String pFirstName="";
	String pMiddleName="";
	String pLastname="";
	if(patient.getEmpId()!=null){
	if(patient.getEmpId().getFirstName()!=null){
		pFirstName=patient.getEmpId().getFirstName();
	}
	if(patient.getEmpId().getMiddleName()!=null){
		pMiddleName=patient.getEmpId().getMiddleName();
	}
	if(patient.getEmpId().getLastName()!=null){
		pLastname=patient.getEmpId().getLastName();
	}}%> <label class="valueMedium"><%=patient.getPatientType().getPatientTypeName()%></label>
<%if(patient.getPatientType().getId()==1 || patient.getPatientType().getId()==7){
			if(patient.getCompany() != null){
	%>

<div class="clear"></div>

<label class="medium">Company</label> <label class="value"><%=patient.getCompany().getCompanyName()%></label>
<%			}
			}else if(patient.getPatientType().getId()==2 || patient.getPatientType().getId()==8){ %>
<div class="clear"></div>
<label class="medium">Employee</label> <label class="value"><%=pFirstName+" "+pMiddleName+" "+pLastname%></label>
<%}else if(patient.getPatientType().getId()==4) {%>
<div class="clear"></div>
<label class="medium">Project Name</label> <label class="value"><%=patient.getCompany().getCompanyName()%></label>
<%} %> <%if(patient.getPatientType().getId()==7){ %>
<div class="clear"></div>
<label>Amount</label> <label class="value"><%=patient.getInsuranceAmt()%></label>
<%} %> <%if(patient.getPatientType().getId()== 2){ %> <label class="auto">Date
Of Birth:</label> <label class="valueMedium">
<%
String dateOfBirth="";
	if(patient.getEmpDependentId()!=null){
		dateOfBirth=""+HMSUtil.convertDateToStringWithoutTime(patient.getEmpDependentId().getDateOfBirth());
	}

%>
</label>
<input type="hidden" id="depDobId"
	value="<%=dateOfBirth%>" />
<%}%> <input type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
	value="<%=patient.getPatientType().getId() %>" /> <input type="hidden"
	id="patientType" name="<%=PATIENT_TYPE %>"
	value="<%=patient.getPatientType().getPatientTypeName() %>" /> <%
	if(patient.getCompany() != null){
%> <input type="hidden" id="companyId" name="companyId"
	value="<%=patient.getCompany().getId() %>" /> <%} %>
<div class="clear"></div></div>
<div class="clear"></div>
<h4>Visit Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.opd_no")%></label> <%
int visitNo = 0;
int lastVisitNo = 0;
if(patient.getCurrentVisitNo() != null){
	lastVisitNo = patient.getCurrentVisitNo();
}
visitNo = lastVisitNo + 1;
%> <label class="value"><%=visitNo%></label> <label><span>*</span> Visit Date</label> <input type="text" name="<%=VISIT_DATE %>"
	value="<%=currentDate %>" class="readOnly" readonly="readonly"
	validate="Visit Date,date,yes" MAXLENGTH="30" /> <label><span>*</span> Visit Time </label> <input type="text" name="<%=VISIT_TIME %>" class="readOnly"
	readonly="readonly" value="<%=time %>" validate="Visit Time,String,yes"
	maxlength="10" />

<div class="clear"></div>
<script type="text/javascript">
<!--Comment By  Rajendra Kumar :16-03-2015 -->
	<%
	int i = 0;
	for(MasDepartment masDepartment : departmentList){
		for (MasEmployee masEmployee : employeeList)
		{
			if(masEmployee.getDepartment() != null){
				if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
				if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
					if(totalDoctorVisits.size()>0){
						int totalVisit=0;
						for (Iterator iterator = totalDoctorVisits.iterator(); iterator.hasNext();) {
							Object[] objects = (Object[]) iterator.next();
							if(objects[0].equals(masEmployee.getId())){
								totalVisit=((Number)objects[1]).intValue();
								break;
							}
						}
						%>
						doctorArr[<%=i%>] = new Array();
						doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
						doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
						doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())+" [ "+totalVisit+" ]"%>";
						<%
					}else{
					%>
				doctorArr[<%=i%>] = new Array();
				doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
				doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
				doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";
			<%
			 }
			i++;
			}
		}
		}
	  }
	}
	%>

<%--
	<%
		int i = 0;
			for(MasDepartment masDepartment : departmentList){
				for (MasEmployee masEmployee : employeeList)
				{
					if(masEmployee.getDepartment() != null){
						if(masEmployee.getViewAllDepartment()!=null){
						if(masEmployee.getViewAllDepartment().equalsIgnoreCase("y")){
							if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
								// Code for Display Doctor Total Visit Day's wise
								if(totalDoctorVisits.size()>0){
									int totalVisit=0;
									for (Iterator iterator = totalDoctorVisits.iterator(); iterator.hasNext();) {
										Object[] objects = (Object[]) iterator.next();
										if(objects[0].equals(masEmployee.getId())){
											totalVisit=((Number)objects[1]).intValue();
											break;
										}
									}
									%>
									doctorArr[<%=i/%> = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())+" [ "+totalVisit+" ]"%>";
									<%
								}else{
									%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

								<%

								}
								i++;
							}
						}else{
							if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
								if(totalDoctorVisits.size()>0){
									int totalVisit=0;
									for (Iterator iterator = totalDoctorVisits.iterator(); iterator.hasNext();) {
										Object[] objects = (Object[]) iterator.next();
										if(objects[0].equals(masEmployee.getId())){
											totalVisit=((Number)objects[1]).intValue();
											break;
										}
									}
									%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())+" [ "+totalVisit+" ]"%>";
									<%
								}else{
								%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

								<%
								}
								i++;
									}
						}
						}else{
							if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
								if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
									if(totalDoctorVisits.size()>0){
										int totalVisit=0;
										for (Iterator iterator = totalDoctorVisits.iterator(); iterator.hasNext();) {
											Object[] objects = (Object[]) iterator.next();
											if(objects[0].equals(masEmployee.getId())){
												totalVisit=(Integer)objects[1];
												break;
											}
										}
										%>
										doctorArr[<%=i%>] = new Array();
										doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
										doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
										doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())+" [ "+totalVisit+" ]"%>";
										<%
									}else{
							%>
								doctorArr[<%=i%>] = new Array();
								doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
								doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
								doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

							<%
									}
							i++;
								}
						}
					}
					}
				}
			}
		%>
--%>
	</script>
<label>Complaint</label> <select id="complaintId"
	name="<%=COMPLAINT_ID%>" validate="Complaint,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
	 	for(MasComplaint masComplaint : complaintList){
	 %>
	<option value="<%=masComplaint.getId() %>"><%=masComplaint.getComplaintName() %></option>
	<%} %>
</select> <label><span>*</span> Department</label> <select id="deptId"
	name="<%=PATIENT_DEPARTMENT %>" tabindex="1"
	onchange="populateDoctor(this.value,'visitByHin');checkDepartment();submitProtoAjax('visitByHin','registration?method=getTokenNoForDepartment')"
	validate="Department,string,yes">
	<option value="0">Select</option>
	<%
	int departmentId = 0;
		for(MasDepartment masDepartment : departmentList){
			if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForCR) && masDepartment.getStatus().equalsIgnoreCase("Y"))
					{
				departmentId = masDepartment.getId();
		%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%
		}
			}departmentList=null; %>
</select> <label><span>*</span> Consulting Doc</label> <select
	name="<%=CONSULTING_DOCTOR %>" id="consultingDocId" validate="Consulting Doctor,string,yes"
	tabindex="1" title="Consulting Doctor & Total Current Visit">
	<option value="0">Select</option>
	<%
for(MasEmployee masEmployee : employeeList){
if(masEmployee.getEmpCategory() != null){
if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
//if(departmentId == masEmployee.getDepartment().getId())
//{
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				}
//}
}
} %>
</select>

<div class="clear"></div>


<label><span> *</span>   Case Type</label> <select name="<%=CASE_TYPE_ID %>"
	validate="Case Type,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%
 			for(MasCaseType masCaseType : caseTypeList){
 		%>
	<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
	<%} %>
</select> <label> Diagnosis</label> <select name="<%=DIAGNOSIS_ID %>"
	validate="Diagnosis,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			for(MasDiagnosisConclusion masDiagnosisConclusion : diagnosisList){
		%>
	<option value="<%=masDiagnosisConclusion.getId() %>"><%=masDiagnosisConclusion.getDiagnosisConclusionName() %></option>
	<%} %>
</select> <label><span>*</span> Token No.</label>

<div id="testDiv"><input id="tokenNoId" type="text"
	name="<%=TOKEN_NO %>" value="" validate="Token no.,string,yes"
	maxlength="3" class="readOnly" readonly="readonly"></div>
<div class="clear"></div>
<div style="visibility: hidden;"><label>Patient Type</label> <select
	name="<%=PATIENT_TYPE%>" id="patientTypeId"
	validate="Patient Type,string,no" tabindex="1"
	onblur="displayCompanyList();">
	<option value="0" selected="selected">select</option>
	<%
			for(MasPatientType masPatientType : patientTypeList){

		 	if(patient.getPatientType().getId()!=null && masPatientType.getId()==patient.getPatientType().getId()){
		 %>
	<option value="<%=masPatientType.getId() %>"><%=masPatientType.getPatientTypeName()%></option>
	<%}else{%>
	<option value="<%=masPatientType.getId() %>"><%=masPatientType.getPatientTypeName()%></option>
	<%}}%>
</select></div>

<!--<div id="companyLable">Company</div> --> <label id="companyLable"
	style="display: none;"><span>*</span> Company</label> <label
	id="insuranceLable" style="display: none;"><span>*</span> Company</label>

<div id="company" style="display: none;"><select
	name="<%=COMPANY %>" validate="Company,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==1)  {
	if(patient.getPatientType().getId()==1 && masCompany.getId()==patient.getCompany().getId()){
%>
	<option value="<%=masCompany.getId()%>" selected="selected"><%=masCompany.getCompanyName()%></option>
	<%}else{%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%}}} %>
</select></div>
<div id="insurance" style="display: none;"><select
	name="<%=COMPANY %>" validate="Company,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
	if (masCompany.getPatientType().getId().intValue()==7) {
		if(patient.getPatientType().getId()==7 && masCompany.getId()==patient.getCompany().getId()){
%>
	<option value="<%=masCompany.getId()%>" selected="selected"><%=masCompany.getCompanyName()%></option>
	<%}else{ %>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%}} }%>
</select></div>

<label id="insAmtlbl" style="display: none;"><span>*</span> Amount</label>
<div id="insAmt" style="display: none;">
<%if(patient.getInsuranceAmt()!=null && !patient.getInsuranceAmt().equals("")){ %>
<input type="text" id="" name="" value="<%=patient.getInsuranceAmt()%>"
	tabindex="1" title="" MAXLENGTH="15" /> <%}else{ %> <input type="text"
	id="" name="" value="" tabindex="1" title="" MAXLENGTH="15" /> <%} %>
</div>

<label id="employeelbl" style="display: none;"><span>*</span>Employee</label>
<div id="employeeDiv" style="display: none;"><select
	name="<%=EMPLOYEE_ID%>" id="employeeId" validate="Employee,string,no"
	tabindex="1" onblur="employeeDepntList();">
	<option value="0">Select</option>
	<%
for(MasEmployee masEmployee : employeeList){
	if(patient.getPatientType().getId()==8 || patient.getPatientType().getId()==2){

		if(patient.getEmpId()!=null&&patient.getEmpId().getId()==masEmployee.getId()){
%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%}}}employeeList=null;%>
</select></div>
<label id="employeeDependentlbl" style="display: none;"><span>*</span> Employee Dependent</label>
<div id="employeeDependentDiv" style="display: none;"><select
	name="<%=EMPLOYEE_DEPENDENT_ID%>" id="employeeDependentId"
	validate="Employee Dependent,string,no" tabindex="1"
	onblur="setEmployeeName();">
	<option value="0">Select</option>
	<%
for(MasEmployeeDependent masEmployeeDependent : employeeDependentList){
	if(patient.getPatientType().getId()==2 &&patient.getEmpDependentId()!=null&& patient.getEmpDependentId().getId()==masEmployeeDependent.getId()){
%>
	<option value="<%=masEmployeeDependent.getId()%>" selected="selected"><%=masEmployeeDependent.getEmployeeDependentName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeeDependent.getId()%>"><%=masEmployeeDependent.getEmployeeDependentName()%></option>
	<%}}employeeDependentList=null;%>
</select></div>

<label id="prjlbl" style="display: none;"><span>*</span> Project</label>
<div id="prjDiv" style="display: none;"><select
	name="<%=PROJECT_ID%>" validate="Project,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==4) {
	if(patient.getPatientType().getId()==4 && patient.getCompany().getId()==masCompany.getId()){
%>
	<option value="<%=masCompany.getId()%>" selected="selected"><%=masCompany.getCompanyName()%></option>
	<%}else{ %>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%}}}companyList=null;%>
</select></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4><%=prop.getProperty("com.jkt.hms.bill_heading")%></h4>
<div class="clear"></div>
<div class="Block">
<label>Billing Required</label>
<%if(ptypeId==15 || ptypeId==16 || ptypeId==17 || ptypeId==18){ %>
<label class="small">yes</label>
<input type="radio" name="bilreq" id="billreqId" value="y"  onclick="changeAmount2();" />
<label class="small">No</label>
<input type="radio" name="bilreq" id="billreqId2" value="n" checked="checked" onclick="changeAmount();"/>
<%}else { %>
<label class="small">yes</label>
<input type="radio" name="bilreq" id="billreqId" value="y" checked="checked" onclick="changeAmount2();" />
<label class="small">No</label>
<input type="radio" name="bilreq" id="billreqId2" value="n"  onclick="changeAmount();"/>
<%} %>

<label> <%=prop.getProperty("com.jkt.hms.bill_no")%></label> <input type="text"
	id="billNo" class="readOnly" name="billNo" value="<%=billNo%>"
	readonly="readonly" title="Bill No of the Patient"
	validate="Bill No,int,no" MAXLENGTH="15" />

<div id="amount">
<label>Amount</label> 
<%if(ptypeId==15 || ptypeId==16 || ptypeId==17 || ptypeId==18){ %>
<input type="text" id="amt" name="amt" value="0.00" MAXLENGTH="4" readonly="readonly" class="readOnly" />
<%}else { %>
<input type="text" id="amt" name="amt" value="<%=amount.setScale(2,BigDecimal.ROUND_HALF_UP) %>" MAXLENGTH="4" readonly="readonly" class="readOnly" />
<%} %> 
<input type="hidden" name="billamt" id="billamt" value="<%=rate%>" MAXLENGTH="4" class="readOnly" readonly="readonly" /> 
<input	type="hidden" name="stdDeduction" id="stdDeduction" value="<%=stdDeduction%>" MAXLENGTH="4" class="readOnly" readonly="readonly" /> 
<input type="hidden" name="discAmt" id="discAmt" value="<%=discAmt%>" MAXLENGTH="4" class="readOnly" readonly="readonly" />

</div>

<label>Registration Type</label> <select name="regisType" id="regisType"
	tabindex="1"
	onchange="submitProtoAjaxWithDivName('visitByHin','/hms/hms/registration?method=getAmount','amount')">
	<%
	String regType= "";
		if(patient.getRegistrationType() != null){
			regType = patient.getRegistrationType();
		}
			if(regType.equalsIgnoreCase("G")){
	%>
	<option value="G" selected="selected">General</option>
	<option value="S">Special</option>
	<%}else if(regType.equalsIgnoreCase("S")){ %>
	<option value="G">General</option>
	<option value="S" selected="selected">Special</option>

	<%}else{ %>
	<option value="G">General</option>
	<option value="S">Special</option>
	<%} %>
</select>
<div class="clear"></div>
<label><span>*</span> Charge</label> <select name="registrationType"
	id="registrationType" tabindex="1"
	validate="Registration Type,string,yes" onblur="checkForPatientType();">

	<%
	
	//
for(MasChargeCode masChargeCode : chargeCodeList){System.out.println(chargeCodeList);
	//
	//
	if(masChargeCode.getId()==visitChargeId){ %>

	<option value="<%=masChargeCode.getId()%>" selected="selected"><%=masChargeCode.getChargeCodeName()%></option>
	<%}else {%>
	<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
	<%}
}%>

</select> <label><%=prop.getProperty("com.jkt.hms.discount")%></label> <input type="text" id="discount" name="discount"
	tabindex="1" value="" validate="Discount, int, no" MAXLENGTH="3"
	onblur="checkForDiscount();" /> <label>Authorizer</label> <select
	name="refDoctor" id="refDoctor" tabindex="1"
	validate="Ref Doctor,string,no">
	<option value="0">Select</option>
	<%
for(MasAuthorizer masAuthorizer : authorizerList){
%>
	<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
	<%}%>
</select>
<div class="clear"></div>

<label>Actual Collected Amount</label>
<input type="hidden"  name="ptype" id="ptypeId" value="<%=ptypeId %>"/> 
<%if(ptype.equalsIgnoreCase("SC") || ptype.equalsIgnoreCase("ST")){ %>
<input type="text"
	id="actualColAmtId" name="actualCollectedAmt" tabindex="1"
	value="0.00"
	validate="Actual Collected Amount,float,no" maxlength="8" readonly="readonly" />

<%}else { %>
<input type="text"
	id="actualColAmtId" name="actualCollectedAmt" tabindex="1"
	value="<%=amount.setScale(2,BigDecimal.ROUND_HALF_UP) %>"
	validate="Actual Collected Amount,flo,no" maxlength="8" readonly="readonly" />
<%} %>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=AGE %>" value="<%=currentAge %>">
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visitNo%>">

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="Submit11" value="Save" tabindex="1"
	class="button"
	onClick="submitForm('visitByHin','/hms/hms/registration?method=saveVisitInformation','checkDependentAge','checkCollectedAmount');" />
<input type="reset" name="Reset" value="Reset" tabindex="1"
	class="buttonHighlight" accesskey="r" /> <input type="button"
	class="button" value="Back" tabindex="1" align="right"
	onClick="history.back();" /> <% }
}else{
%> No Record Found!! <%
}%>
<div id="statusMessage"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
<div class="paddingTop40"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
<script>
function checkForDiscount()
{
	var authorizer=eval(document.visitByHin.refDoctor.value);
	var amount=parseFloat(document.visitByHin.amt.value);
	var discountVar=document.visitByHin.discount.value;
	if(validateFloat(discountVar)){
		if(discountVar>amount)
		{
			alert("Discount should be less than or equal to amount!!");
			document.visitByHin.discount.value="";
			return false;
		}else if(parseFloat(discountVar)== parseFloat(amount)){
			document.getElementById('actualColAmtId').value = "";
		}
		if(discountVar!="" && authorizer==0)
		{
			alert("Select Authorizer!!");
			return false;
		}
	}else{
		alert("Charity should be integer or decimal value.");
		document.visitByHin.discount.value = "";
		return false;

	}
	return true;
}
function checkForPatientType()
{
	submitProtoAjaxWithDivName('visitByHin','/hms/hms/registration?method=getAmount','amount');
}
function displayCompanyList()
{

		var company = document.visitByHin.<%=PATIENT_TYPE_ID %>.value;

		if(company == "1"){
		document.getElementById('company').style.display = "inline";
		document.getElementById('companyLable').style.display = "inline";
		document.getElementById('employeeDependentDiv').style.display = "none";
		document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "1"){
		document.getElementById('company').style.display = "none";
		document.getElementById('companyLable').style.display = "none";
		document.getElementById('employeeDependentDiv').style.display = "none";
		document.getElementById('employeeDependentlbl').style.display = "none";
		}

		if(company == "7"){
		document.getElementById('insurance').style.display = "inline";
		document.getElementById('insuranceLable').style.display = "inline";
		document.getElementById('insAmtlbl').style.display = "inline";
		document.getElementById('insAmt').style.display = "inline";
		document.getElementById('employeeDependentDiv').style.display = "none";
		document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "7"){
		document.getElementById('insurance').style.display = "none";
		document.getElementById('insuranceLable').style.display = "none";
		document.getElementById('insAmtlbl').style.display = "none";
		document.getElementById('insAmt').style.display = "none";
		document.getElementById('employeeDependentDiv').style.display = "none";
		document.getElementById('employeeDependentlbl').style.display = "none";
		}
		if(company == "4"){
		document.getElementById('prjDiv').style.display = "inline";
		document.getElementById('prjlbl').style.display = "inline";
		}else if (company != "4"){
		document.getElementById('prjDiv').style.display = "none";
		document.getElementById('prjlbl').style.display = "none";
		}
		if(company == "8" || company == "2"){
		document.getElementById('employeeDiv').style.display = "inline";
		document.getElementById('employeelbl').style.display = "inline";
		}else if (company != "8"){
		document.getElementById('employeeDiv').style.display = "none";
		document.getElementById('employeelbl').style.display = "none";
		}
		if(document.getElementById("pFirstNameId").value!="")
			document.getElementById("pFirstNameId").value="";
}

function employeeDepntList()
{
	var company = document.visitByHin.<%=PATIENT_TYPE_ID %>.value;

	if(company == "2"){
	document.getElementById('employeeDependentDiv').style.display = "inline";
	document.getElementById('employeeDependentlbl').style.display = "inline";
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

}
</script>
<script>
function checkDepartment(){
var gender;
var department;
gender = document.visitByHin.<%=GENDER%>.value;
department = document.visitByHin.<%=PATIENT_DEPARTMENT%>.value;
if (gender == "3" && department == "49")
{
alert('This is a male patient OBG Department cannot register him');
document.visitByHin.<%=PATIENT_DEPARTMENT%>.value = "0";
return false;
}else
return true;

}
document.getElementById('complaintId').focus();
document.getElementById('complaintId').style.backgroundColor = "yellow";
</script>


<!--    For Highlight fields on focus -->

<script>

var formObj = document.getElementById('onFocusForm');
var inputArr = formObj.getElementsByTagName("input");
for (i=0; i<inputArr.length; i++){

if(/text/.test(inputArr[i].type)){
if(inputArr[i].readOnly ==false){
inputArr[i].onfocus = function(){
this.style.backgroundColor = "yellow";
};
}
inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};
if(inputArr[i].name=='discount'){
inputArr[i].onblur=function(){

checkForDiscount();this.style.backgroundColor = "";
}
}

}

}

var formObj = document.getElementById('onFocusForm');
var inputArr = formObj.getElementsByTagName("Select");
for (i=0; i<inputArr.length; i++){



inputArr[i].onfocus = function(){
this.style.backgroundColor = "yellow";
};
inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};

if(inputArr[i].name=='<%=PATIENT_DEPARTMENT%>'){
inputArr[i].onchange=function(){

checkDepartment();submitProtoAjax('visitByHin','registration?method=getTokenNoForDepartment');
populateDoctor(this.value,'visitByHin');
}

}
if(inputArr[i].name=='<%=PATIENT_TYPE_ID%>'){
inputArr[i].onblur=function(){

displayCompanyList()
}

}

if(inputArr[i].name=='<%=EMPLOYEE_ID%>'){
inputArr[i].onblur=function(){

employeeDepntList();
}

}

if(inputArr[i].name=='<%=EMPLOYEE_DEPENDENT_ID%>'){
inputArr[i].onblur=function(){

setEmployeeName();

}
}

if(inputArr[i].name=='regisType'){
inputArr[i].onchange=function(){

submitProtoAjaxWithDivName('visitByHin','/hms/hms/registration?method=getAmount','amount');
}

}

if(inputArr[i].name=='registrationType'){
inputArr[i].onblur=function(){

checkForPatientType();this.style.backgroundColor = "";
}

}


}



function changeAmount(){
	//alert("in changeAmount");
	var req=document.getElementById('billreqId2').value;
	var req1=document.getElementById('billreqId').value;
	var ptypeId=document.getElementById('ptypeId').value;
	var actualColAmtId=document.getElementById('actualColAmtId').value;
	//alert("--->"+req)
	if(req=='n' && (ptypeId==13 || ptypeId==15 || ptypeId==16 || ptypeId==17 || ptypeId==18)){
//alert("IN IF")
document.getElementById('actualColAmtId').value='0.00';
document.getElementById('amt').value='0.00';
actualColAmtId='0.00';
		}
	checkCollectedAmount(actualColAmtId);
}
function changeAmount2(){
	//alert("in changeAmount2");
	var req=document.getElementById('billreqId2').value;
	var req1=document.getElementById('billreqId').value;
	var actualColAmtId=document.getElementById('actualColAmtId').value;
	var ptypeId=document.getElementById('ptypeId').value;
	//alert("req--->"+req)
	//alert("ptypeId--->"+ptypeId)
	if(req=='n' && ( ptypeId==15 || ptypeId==16 || ptypeId==17 || ptypeId==18)){ 
	//	alert("IN IF")
		document.getElementById('actualColAmtId').value='0.00';
	}else if(req1=='y'){
//alert("IN else IF")
document.getElementById('actualColAmtId').value='5.00';
document.getElementById('amt').value='5.00';
	actualColAmtId='5.00';
		}
	 
	checkCollectedAmount(actualColAmtId);
}
function checkCollectedAmount(actualColAmtId){
	
	if(document.getElementById('registrationType').value==""){
		alert("Pleases Seslec Charge");
		return false;
		}else {
			return true;	
			}
	return true;
	}

</script>