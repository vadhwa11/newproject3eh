<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * medico_legal_case.jsp  
 * Purpose of the JSP -  This is for Medico Legal Case.
 * @author  Ritu Sahu
 * Create Date: 17th March,2010 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>

<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>


<%@page import="jkt.hms.masters.business.MasInjuryNature"%>
<%@page import="jkt.hms.masters.business.MasBodyPart"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
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

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	String adNo = "";
	String message = "";
	String mlcNo = "";
	String flag = "";
	int visitNo = 0;
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
	
	List<MasInjuryNature> injuryNatureList = new ArrayList<MasInjuryNature>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasBodyPart> bodyPartList = new ArrayList<MasBodyPart>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}

	if(map.get("adNo") != null){
		adNo = (String)map.get("adNo");
	}
	if(map.get("mlcNo") != null){
		mlcNo = (String)map.get("mlcNo");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	if(map.get("visitNo") != null){
		visitNo = (Integer)map.get("visitNo");
	}
	
	if(map.get("mlcCaseList") != null){
		mlcCaseList = (List<MlcCase>)map.get("mlcCaseList");
	}
	if(mlcCaseList.size() > 0){
		MlcCase mlcCase = mlcCaseList.get(0);
		Patient patient = mlcCase.getHin();
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("injuryNatureList") != null){
			injuryNatureList = (List<MasInjuryNature>)detailsMap.get("injuryNatureList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(detailsMap.get("bodyPartList") != null){
			bodyPartList = (List<MasBodyPart>)detailsMap.get("bodyPartList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		String age = mlcCase.getHin().getAge();
		String currentAge = HMSUtil.calculateAgeForADT(age, mlcCase.getHin().getRegDate());
%>


<form name="updateMlcForm" method="post">
	
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 27 July 2010
 -->	
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<h2>Update Medico Legal Case</h2>
<div class="clear"></div>
<%
	 if(!message.equals("")){
	 %>

<h4><%=message %></h4>
<div class="clear"></div>
<%} %>
<h4>Medico Legal Case Details</h4>
<div class="clear"></div>
<div class="Block"><label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<label class="valueMedium"><%=patient.getHinNo() %></label> 
<%
		if(flag.equals("ipMlc")){
	%> 
	<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> 
	<label class="value"><%=mlcCase.getAdNo() %></label>
<%}else if(flag.equals("opMlc")){ %> 
<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> 
<label class="value"><%=mlcCase.getVisitNo() %></label> 
<%} %> <%		
String middleName = "";
String lastName = "";
if(patient.getPMiddleName() != null){
middleName = patient.getPMiddleName();
}
if(patient.getPLastName() != null){
lastName = patient.getPLastName();
}
%> 
<label>Patient Name</label> 
<label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>
<label class="medium">Sex</label> 
<label class="valueMedium"><%=patient.getSex().getAdministrativeSexName() %></label>
<div class="clear"></div>

<label class="medium">MLC No.</label> <label class="value"><%=mlcCase.getMlcNo()%></label>
<input type="hidden" name="mlcId" value="<%=mlcCase.getId() %>" /> <label
	class="medium"><span>*</span> MLC Date</label> <input type="text"
	id="mlcDateId" name="<%=MLC_DATE%>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(mlcCase.getMlcDate())%>"
	class="date" readonly="readonly"
	validate="MLC Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.updateMlcForm.<%=MLC_DATE%>,event)" />

<label><span>*</span> MLC Time</label> <input type="text" id="mlcTimeId"
	name="<%=MLC_TIME %>" value="<%= mlcCase.getMlcTime()%>" class="date"
	validate="MLC Time,String,yes"
	onchange="IsValidTime(this.value,this.id);" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Injury Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span> Nature of MLC</label> 
<select id="natureOfMlc" name="<%= NATURE_OF_MLC %>" validate="Nature of MLC,String,yes">
	<option value="">Select</option>
	<option value="Major">Major</option>
	<option value="Minor">Minor</option>
</select> <%
	if(mlcCase.getNatureOfMlc() != null){
%>
<script type="text/javascript">
document.getElementById("natureOfMlc").value = '<%=mlcCase.getNatureOfMlc()%>';
</script> <%}%> 
<label>Nature of Injury</label> <select id="injuryNatureId"
	name="<%= INJURY_NATURE_ID %>" validate="Nature of Injury,String,no">
	<option value="0">Select</option>
	<% 
		for (MasInjuryNature obj : injuryNatureList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getInjuryNatureName()%></option>
	<% }%>
</select> <%
	if(mlcCase.getInjuryNature() != null){
%> <script type="text/javascript">
document.getElementById("injuryNatureId").value = '<%=mlcCase.getInjuryNature().getId()%>';
</script> <%}%> <label>Type Of Injury</label> <select id="injuryType"
	name="<%= INJURY_TYPE %>" validate="Type Of Injury,String,no">
	<option value="">Select</option>
	<option value="RTA">RTA</option>
	<option value="Poisoning">Poisoning</option>
	<option value="Burning">Burning</option>
</select> <%
	if(mlcCase.getInjuryType() != null){
%> <script type="text/javascript">
document.getElementById("injuryType").value = '<%=mlcCase.getInjuryType()%>';
</script> <%}%>

<div class="clear"></div>

<label>Severity of Injury</label> <select id="sevrId"
	name="<%= SEVERITY_OF_INJURY %>"
	validate="Severity Of Injury,String,no">
	<option value="">Select</option>
	<option value="Minor">Minor</option>
	<option value="Moderate">Moderate</option>
	<option value="Severe">Severe</option>
</select> <%
	if(mlcCase.getSeverityOfInjury() != null){
%> <script type="text/javascript">
document.getElementById("sevrId").value = '<%=mlcCase.getSeverityOfInjury()%>';
</script> <%}%> <label>Injury Dimension</label> <input type="text" id="injuryDim"
	name="<%= INJURY_DIMENSION %>" value="" maxlength="20"
	validate="Injury Dimension,alphanumeric,no"> <%
	if(mlcCase.getInjuryDimension() != null){
%> <script type="text/javascript">
document.getElementById("injuryDim").value = '<%=mlcCase.getInjuryDimension()%>';
</script> <%}%> <label>Injury Details</label> <textarea id="injuryDt"
	name="<%=INJURY_DETAILS %>" validate="Injury Details ,alphanumeric,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea>
<div class="clear"></div>

<%
	if(mlcCase.getInjuryDetails() != null){
%> <script type="text/javascript">
document.getElementById("injuryDt").value = '<%=mlcCase.getInjuryDetails()%>';
</script> <%}%>
</div>
<div class="clear"></div>
<h4>Other Details</h4>
<div class="clear"></div>
<div class="Block">
<%
	String broughtBy = "";
	String relation = "";
	String weapon = "";
	String incidenceDate = "";
	String incidenceTime = "";
	String incidencePlace = "";
	String driverName = "";
	String remarks = "";
	String firNo = "";
	String policeOfficer = "";
	String policeStation = "";
	String statement = "";
	
	if(mlcCase.getBroughtBy() != null){
		broughtBy = mlcCase.getBroughtBy();
	}
	if(mlcCase.getPatientRelation() != null){
		relation = mlcCase.getPatientRelation();
	}
	if(mlcCase.getWeaponUsed() != null){
		weapon = mlcCase.getWeaponUsed();
	}
	if(mlcCase.getIncidentDate() != null){
		incidenceDate = HMSUtil.convertDateToStringWithoutTime(mlcCase.getIncidentDate());
	}
	if(mlcCase.getIncidentTime() != null){
		incidenceTime = mlcCase.getIncidentTime();
	}
	if(mlcCase.getIncidentPlace() != null){
		incidencePlace = mlcCase.getIncidentPlace();
	}
	if(mlcCase.getNameAndAddressOfDriver() != null){
		driverName = mlcCase.getNameAndAddressOfDriver();
	}
	if(mlcCase.getRemarks() != null){
		remarks = mlcCase.getRemarks();
	}
	if(mlcCase.getFirNo() != null){
		firNo = mlcCase.getFirNo();
	}
	if(mlcCase.getPoliceOfficer() != null){
		policeOfficer = mlcCase.getPoliceOfficer();
	}
	if(mlcCase.getPoliceStation() != null){
		policeStation = mlcCase.getPoliceStation();
	}
	if(mlcCase.getStatement() != null){
		statement = mlcCase.getStatement();
	}
	
	%> <label>Brought By</label> <input type="text"
	name="<%= BROUGHT_BY %>" value="<%=broughtBy %>"
	validate="Brought By,fullName,no" maxlength="40"> <label>Relation</label>
<input type="text" name="patientRelation" value="<%=relation %>"
	validate="Patient Relation,fullName,no" maxlength="40"> <label><span>*</span>
Doctor Attend</label> <select id="doctorId" name="<%=CONSULTING_DOCTOR %>"
	validate="Doctor Attended,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			  if(obj.getEmpCategory().getEmpCategoryCode().equals("01")){
				  String fName = "";
				  String mName = "";
				  String lName = "";
				  if (obj.getFirstName() != null){fName=obj.getFirstName();}
				  if (obj.getMiddleName() != null){mName=obj.getMiddleName();}
				  if (obj.getLastName() != null){lName=obj.getLastName();}
	%>
	<option value="<%=obj.getId ()%>"><%=fName+" "+mName+" "+lName%></option>
	<% }}}%>
</select> <%
	if(mlcCase.getDoctor() != null){
%> <script type="text/javascript">
document.getElementById("doctorId").value = '<%=mlcCase.getDoctor().getId()%>';
</script> <%}%>


<div class="clear"></div>
<script type="text/javascript">
		<%
			int i = 0;
			for (MasDepartment masDepartment : departmentList) 
			{
				for (MasEmployee masEmployee : employeeList) 
				{
					if(masEmployee.getDepartment() != null){
						if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
		%>
							doctorArr[<%=i%>] = new Array();
							doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
							doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;									
							doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName()%>";
		<%
							i++;
						}
					}
				}
			}
		%>
</script> <label><span>*</span> Condition</label> <select id="condition"
	name="<%=CONDITION %>" validate="Condition,String,yes">
	<option value="0">Select</option>
	<option value="Normal">Normal</option>
	<option value="Critical">Critical</option>
	<option value="Walking">Walking</option>
	<option value="Lying">Lying</option>
	<option value="Dead">Dead</option>
</select> <%
	if(mlcCase.getPatientCondition() != null){
%> <script type="text/javascript">
document.getElementById("condition").value = '<%=mlcCase.getPatientCondition()%>';
</script> <%}%> <label>Body Part Affected</label> <select id="bodyPartId"
	name="<%=BODY_PART_ID %>" validate="Body Part Affected,String,no">
	<option value="0">Select</option>
	<% 
		for (MasBodyPart obj : bodyPartList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getBodyPartName()%></option>
	<% }%>
</select> <%
	if(mlcCase.getBodyPart() != null){
%> <script type="text/javascript">
document.getElementById("bodyPartId").value = '<%=mlcCase.getBodyPart().getId()%>';
</script> <%}%> <label>Weapon Used</label> <input type="text"
	name="<%= WEAPON_USED %>" value="<%=weapon %>" maxlength="50"
	validate="Weapon Used,alphanumeric,no">
<div class="clear"></div>
<label><span>*</span> Incidence Date</label> <input type="text"
	class="date" id="incidenceDateId" name="<%=INCIDENCE_DATE%>"
	value="<%=incidenceDate %>" readonly="readonly"
	validate="Incidence Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.updateMlcForm.<%=INCIDENCE_DATE%>,event)" />



<label><span>*</span> Incidence Time</label> <input type="text"
	id="mlcTimeId" name="<%=INCIDENCE_TIME %>" value="<%=incidenceTime %>"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <label><span>*</span>
Incidence Place</label> <input type="text" name="<%= INCIDENCE_PLACE %>"
	value="<%=incidencePlace %>" maxlength="50"
	validate="Incidence Place,alphaspace,yes" />

<div class="clear"></div>


<label>Name &amp; Address of Driver</label> <textarea
	name="<%=NAME_AND_ADDR_OF_DRIVER %>"
	validate="Name & Address Of Driver,alphaspace,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"><%=driverName %></textarea> <label>Remarks</label> <textarea
	name="<%=REMARKS %>" validate="Remarks,remarks,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="60"><%=remarks %></textarea>

<div class="clear"></div></div>

<div class="clear"></div>
<h4>Police Details</h4>
<div class="clear"></div>
<div class="Block"><label>FIR No.</label> <input type="text"
	name="<%= FIR_NO %>" value="<%=firNo %>"
	validate="FIR No,alphanumeric,no" maxlength="15" /> <label>Police
Officer Name</label> <input type="text" name="<%= POLICE_OFFICER %>"
	value="<%=policeOfficer %>" validate="Police Officer Name,fullName,no"
	maxlength="45" /> <label><span>*</span> Police Station</label> <input
	type="text" name="<%= POLICE_STATION %>" value="<%=policeStation %>"
	validate="Police Station,alphanumeric,yes" maxlength="30" />

<div class="clear"></div>

<label>Statement</label> <textarea name="<%=STATEMENT %>"
	validate="Statement,remarks,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"><%=statement %></textarea>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Update" class="button"
	onClick="submitForm('updateMlcForm','/hms/hms/adt?method=updateMLCDetails');" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=currentTime%></label>
</div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo %>" /> <input
	type="hidden" name="<%=MLC_NO %>" value="<%=mlcNo %>" /> <input
	type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visitNo %>" /> <input
	type="hidden" id="idForAge" name="<%= AGE%>" value="<%=currentAge %>" />

<input type="hidden" name="flag" value="<%=flag %>" />
<div id="edited"></div>


<% }%>
<div id="statusMessage">
<h4></h4>
</div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


