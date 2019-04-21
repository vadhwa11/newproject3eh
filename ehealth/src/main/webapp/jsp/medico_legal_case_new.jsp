<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * medico_legal_case.jsp  
 * Purpose of the JSP -  This is for Medico Legal Case.
 * @author  Deepti Tevatia
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
	
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

	
	String message = "";
	String mlcNo = "";
	String flag = "";
	
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> dMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<Visit> visitList = new ArrayList<Visit>();
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
	if(map.get("dMap") != null){
		dMap = (Map<String,Object>)map.get("dMap");
	}
	
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
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
	
	
	
	if(dMap.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)dMap.get("inpatientList");
		
	}
	if(dMap.get("visitList") != null){
		visitList = (List<Visit>)dMap.get("visitList");
		
	}
	
	
	if(patientMap.get("patientList") != null){
		patientList = (List<Patient>)patientMap.get("patientList");
		session.setAttribute("patientList", patientList);
	}else if(session.getAttribute("patientList") != null){
		patientList = (List<Patient>)session.getAttribute("patientList");
	}
	int inpId=0;
	String adNo="";
	if(inpatientList.size()>0)
	{
		Inpatient inp=inpatientList.get(0);
		inpId=inp.getId();
		adNo=inp.getAdNo();
	}
	int visitId=0;
	int visitNo=0;
	if(visitList.size()>0)
	{
		Visit v=visitList.get(0);
		visitId=v.getId();
		visitNo=v.getVisitNo();
	}
	if(patientList.size() > 0){
		Patient patient = patientList.get(0);
		
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
		String age = patient.getAge();
		String currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
%>


<form name="mlcForm" method="post">
<h2>Medico Legal Case</h2>
<div class="clear"></div>
<%
	 if(!message.equals("")){
	 %>

<h4><%=message %></h4>
<div class="clear"></div>
<%} %>

<h4>Medico Legal Case Details</h4>
<div class="clear"></div>

<div class="Block"><label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
	class="valueMedium"><%=patient.getHinNo() %></label> <%
		if(flag.equals("ipMlc")){
	%> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
	
	<label class="value"><%=adNo %></label>
	 <%}else if(flag.equals("opMlc")){ %>

<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> 
<label class="value"><%=visitNo %></label>

<div class="clear"></div>

<%} %> <%
		String middleName = "";
		String lastName = "";
		if(patient.getPMiddleName() != null){
			middleName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			lastName = patient.getPLastName();
		}
		
		%> <label class="medium">Sex</label> <label class="valueMedium"><%=patient.getSex().getAdministrativeSexName() %></label>

<label>Patient Name</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

<div class="clear"></div>

<label class="medium">MLC No.</label> <label class="value"><%=mlcNo%></label>


<label class="medium"><span>*</span> MLC Date</label> <input type="text"
	id="mlcDateId" name="<%=MLC_DATE%>" value="<%=currentDate %>"
	class="date" readonly="readonly"
	validate="MLC Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.mlcForm.<%=MLC_DATE%>,event)" />

<label><span>*</span> MLC Time</label> <input type="text" id="mlcTimeId"
	name="<%=MLC_TIME %>" value="<%=currentTime %>" class="textbox_size20"
	validate="MLC Time,String,yes"
	onchange="IsValidTime(this.value,this.id);" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Injury Details</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>

<label><span>*</span> Nature of MLC</label> <select
	name="<%= NATURE_OF_MLC %>" validate="Nature of MLC,String,yes">
	<option value="">Select</option>
	<option value="Major">Major</option>
	<option value="Minor">Minor</option>
</select> <label>Nature of Injury</label> <select name="<%= INJURY_NATURE_ID %>"
	validate="Nature of Injury,String,no">
	<option value="0">Select</option>
	<% 
		for (MasInjuryNature obj : injuryNatureList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getInjuryNatureName()%></option>
	<% }%>
</select> <label>Type Of Injury</label> <select name="<%= INJURY_TYPE %>"
	validate="Type Of Injury,String,no">
	<option value="">Select</option>
	<option value="RTA">RTA</option>
	<option value="Poisoning">Poisoning</option>
	<option value="Burning">Burning</option>
</select>

<div class="clear"></div>

<label>Severity of Injury</label> <select
	name="<%= SEVERITY_OF_INJURY %>"
	validate="Severity Of Injury,String,no">
	<option value="">Select</option>
	<option value="Minor">Minor</option>
	<option value="Moderate">Moderate</option>
	<option value="Severe">Severe</option>
</select> <label>Injury Dimension</label> <input type="text"
	name="<%= INJURY_DIMENSION %>" value="" maxlength="20"
	validate="Injury Dimension,alphanumeric,no"><label>Injury
Details</label> <textarea name="<%=INJURY_DETAILS %>"
	validate="Injury Details ,alphanumeric,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea>
<div class="clear"></div></div>
<div class="clear"></div>
<h4>Other Details</h4>
<div class="clear"></div>
<div class="Block"><label>Brought By</label> <input type="text"
	name="<%= BROUGHT_BY %>" value="" validate="Brought By,fullName,no"
	maxlength="40"><label>Relation</label> <input type="text"
	name="patientRelation" value="" validate="Patient Relation,fullName,no"
	maxlength="40"><label><span>*</span> Doctor Attend</label> <select
	name="<%=CONSULTING_DOCTOR %>" validate="Doctor Attended,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory() != null){
			  if(obj.getEmpCategory().getEmpCategoryCode().equals("01")){
				  String doctorName="";
				  doctorName=obj.getFirstName();
				  if(obj.getMiddleName()!=null){
					  doctorName+=" "+obj.getMiddleName();
				  }
				  if(obj.getLastName()!=null){
					  doctorName+=" "+obj.getLastName();
				  }
	%>
	<option value="<%=obj.getId ()%>"><%=doctorName%></option>
	<% }}}%>
</select>
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
</script> <label><span>*</span> Condition</label> <select name="<%=CONDITION %>"
	validate="Condition,String,yes">
	<option value="0">Select</option>
	<option value="Normal">Normal</option>
	<option value="Critical">Critical</option>
	<option value="Walking">Walking</option>
	<option value="Lying">Lying</option>
	<option value="Dead">Dead</option>
</select> <label>Body Part Affected</label> <select name="<%=BODY_PART_ID %>"
	validate="Body Part Affected,String,no">
	<option value="0">Select</option>
	<% 
		for (MasBodyPart obj : bodyPartList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getBodyPartName()%></option>
	<% }%>
</select> <label>Weapon Used</label> <input type="text" name="<%= WEAPON_USED %>"
	value="" maxlength="50" validate="Weapon Used,alphanumeric,no">
<div class="clear"></div>
<label><span>*</span> Incidence Date</label> <input type="text"
	class="date" id="incidenceDateId" name="<%=INCIDENCE_DATE%>"
	value="<%=currentDate %>" readonly="readonly"
	validate="Incidence Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.mlcForm.<%=INCIDENCE_DATE%>,event)" />



<label><span>*</span> Incidence Time</label> <input type="text"
	id="mlcTimeId" name="<%=INCIDENCE_TIME %>" value="<%=currentTime %>"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <label><span>*</span>
Incidence Place</label> <input type="text" name="<%= INCIDENCE_PLACE %>"
	value="" maxlength="50" validate="Incidence Place,alphaspace,yes" />

<div class="clear"></div>


<label>Name &amp; Address of Driver</label> <textarea
	name="<%=NAME_AND_ADDR_OF_DRIVER %>"
	validate="Name & Address Of Driver,alphaspace,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <label>Remarks</label> <textarea
	name="<%=REMARKS %>" validate="Remarks,remarks,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="60"></textarea>
<label>Address of Brought By</label> <textarea
	name="<%=ADDRESS_OF_BROUGHT_BY %>"
	validate="Address of Brought By,alphaspace,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea>
<div class="clear"></div></div>

<div class="clear"></div>
<h4>Police Details</h4>
<div class="clear"></div>
<div class="Block">
<label>FIR No.</label> 
<input type="text"
	name="<%= FIR_NO %>" value="" validate="FIR No,alphanumeric,no"
	maxlength="15" /> 
	<label>Police Officer Name</label> <input
	type="text" name="<%= POLICE_OFFICER %>" value=""
	validate="Police Officer Name,fullName,no" maxlength="45" /> 
	<label><span>*</span> Police Station</label> 
	<input type="text" name="<%= POLICE_STATION %>" value=""
	validate="Police Station,alphanumeric,yes" maxlength="30" />
<div class="clear"></div>
<label>Statement</label> 
<textarea name="<%=STATEMENT %>"	validate="Statement,remarks,no" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit11" value="Save" class="button"
	onClick="submitForm('mlcForm','/hms/hms/adt?method=submitMLCDetails');" />
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
	type="hidden" name="<%=AD_NO %>" value="<%=adNo %>" /> 
	
	<input type="hidden" name="inpId" value="<%=inpId%>"/>
	<input
	type="hidden" name="<%=MLC_NO %>" value="<%=mlcNo %>" /> <input
	type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visitNo %>" />
	<input type="hidden" name="visitId" value="<%=visitId%>"/> 
	<input	type="hidden" id="idForAge" name="<%= AGE%>" value="<%=currentAge %>" />

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
<%-- 
<div class="titleBg">
<h2>MLC</h2>
</div>

<div class="Block">
<label>Patient status</label>
<label class="value">
<select>
<option>Select</option>
<option>Normal</option>
<option>SI( seriously ill)</option>
<option>SI( seriously ill)</option>
<option>Dead</option>
</select>
</label>
<label>Pain Scale</label>
<label class="value">
<select>
<option>Select</option>
</select>
</label>
<label style="width:120px;">Glassgow Comma Scale</label>
<label class="value">
<select>
<option>Select</option>
</select>
</label>
<div class="clear"></div>
<label>MLC Type</label>
<label class="value">
<select>
<option>Select</option>
</select>
</label>

<div class="clear"></div>
<div class="paddingTop15"></div>
<label>Identification Mark &nbsp;&nbsp; 1</label>
<input type="text"  class="large"/>
<div class="clear"></div>
<label>&nbsp;&nbsp;2</label>
<input type="text" class="large"/>

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Bought By</h4>
<div class="clear"></div>
<div class="division"></div>


<label>Name</label>
<label class="value">
<input type="text"  />
</label>
<label>House No.</label>
<label class="value">
<input type="text"  />
</label>
<label>Street</label>
<label class="value">
<input type="text" />
</label>
<div class="clear"></div>

<label>Landmark</label>
<label class="value">
<input type="text"  />
</label>
<label>Street/Locality/Sector</label>
<label class="value">
<input type="text" />
</label>
<label>Village/Town/City</label>
<label class="value">
<input type="text"  />
</label>
<div class="clear"></div>

<label>Post Office</label>
<label class="value">
<input type="text"  />
</label>
<label>State</label>
<label class="value">
<select >
<option>select</option>
</select>
</label>
<label>District</label>
<label class="value">
<select >
<option>select</option>
</select>
</label>
<div class="clear"></div>

<label>Mobile No.</label>
<label class="value">
<input type="text"  />
</label>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>



<div class="clear"></div>
<div class="divisionSolid"></div>
<label>Requisition(if any) From</label>
<textarea class="large"  cols="0" rows="0" maxlength="500" tabindex="5" ></textarea>
<div class="clear"></div>
<label>History/Alleged cause of injury</label>
<textarea class="large" ></textarea>
<div class="clear"></div>
<label>Requisition(if any) From</label>
<textarea class="large" ></textarea>
<div class="clear"></div>
<label>History was stated by Injured</label>
<textarea class="large" ></textarea>
<div class="clear"></div>
<label>Detailss of Injuries</label>
<textarea class="large" ></textarea>
<div class="clear"></div>
<label>Finding of Physical Examination</label>
<textarea class="large" ></textarea>
<div class="clear"></div>
<label>No of Additional sheets if any</label>
<input type="text" class="mediumInput"/>
<input type="file" value="Browse"/>
<input type="button" value="Upload Document" class="buttonBig"/>
<div class="clear"></div>

<label style="width:120px;">Disposal</label>
<label class="value">
<select >
<option>Select</option>
</select>
</label>
<label style="width:120px;">Refered To</label>
<label class="value">
<select >
<option>Select</option>
</select>
</label>
<label style="width:120px;">Admitted To</label>
<label class="value">
<select >
<option>Select</option>
</select>
</label>
<div class="clear"></div>
<label style="width:120px;">Opinion</label>
<label class="value">
<select >
<option>Select</option>
</select>
</label>
<label style="width:120px;">Injury Appeared</label>
<label class="value">
<select >
<option>Select</option>
</select>
</label>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>

 --%>