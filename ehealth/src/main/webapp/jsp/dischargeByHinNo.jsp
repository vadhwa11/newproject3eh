<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dischargeByHinNo.jsp
 * Purpose of the JSP -  This is for Discharge process By Hin No.
 * @author  Ritu
 * Create Date: 13th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.9
--%>

<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script> 
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);

function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}

// -->
function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function removeSelectedOptions() {
 from =document.getElementById("diagnosisId")
	if (!hasOptions(from)) { return; }
	if (from.type=="select-one") {
		from.options[from.selectedIndex] = null;
		}
	else {
		for (var i=(from.options.length-1); i>=0; i--) {
			var o=from.options[i];
			if (o.selected) {
				from.options[i] = null;
				}
			}
		}
	from.selectedIndex = -1;
	}
</script>
<script>
<%!
public String getAmbulanceRequestStatus(String ambulanceStatus){
     
	try
	{	
		if(ambulanceStatus.equals("A")){
			ambulanceStatus="Accepted";
		}else if(ambulanceStatus.equals("R")){
			ambulanceStatus="Rejected";
		}else if(ambulanceStatus.equals("C")){
			ambulanceStatus="Closed";
		}else if(ambulanceStatus.equals("P")){
			ambulanceStatus="Pending";
		}else if(ambulanceStatus.equals("F")){
			ambulanceStatus="Pending";
		}
		else{	ambulanceStatus="No Request";
			}
	}
	catch(Exception exception)
	{
		ambulanceStatus="-";
	}
	return ambulanceStatus;
}
%>
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>

<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<MasCareType> careTypeList = new ArrayList<MasCareType>();
	List<Discharge> dischargeNoList = new ArrayList<Discharge>();
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
	List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();
	List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	
	String time = (String) utilMap.get("currentTime");

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");


	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	String ambulanceStatus="";
	if(map.get("ambulanceStatus") != null){
		ambulanceStatus =(String)map.get("ambulanceStatus");
	}
			
	if(map.get("patientDiagnosisMap") != null){
		patientDiagnosisMap = (Map<String,Object>)map.get("patientDiagnosisMap");
	}
	if(patientMap.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		
		System.out.println("inpatientList--JSP-->"+inpatientList.size());
		
		session.setAttribute("inpatientList", inpatientList);
	}else if(session.getAttribute("inpatientList") != null){
		inpatientList = (List<Inpatient>)session.getAttribute("inpatientList");
	}
	if(patientDiagnosisMap.get("dischargeIcdList") != null){
		dischargeIcdList = (List<DischargeIcdCode>)patientDiagnosisMap.get("dischargeIcdList");
	}
%>

<%
	if(inpatientList != null && inpatientList.size() > 0){
		Inpatient inpatient = inpatientList.get(0);
		Patient patient = inpatient.getHin();

		String age = "";
		String currentAge = "";
		age = patient.getAge()!=null && !patient.getAge().equals("")?patient.getAge():"";
		if(!age.equals("") &&  patient!=null && patient.getRegDate()!=null)
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		
		if(detailsMap.get("disposedToList") != null){
			disposedToList = (List<MasDisposedTo>)detailsMap.get("disposedToList");
		}
		if(detailsMap.get("disposalList") != null){
			disposalList = (List<MasDisposal>)detailsMap.get("disposalList");
		}
		if(detailsMap.get("careTypeList") != null){
			careTypeList = (List<MasCareType>)detailsMap.get("careTypeList");
		}
		if(detailsMap.get("dischargeNoList") != null){
			dischargeNoList = (List<Discharge>)detailsMap.get("dischargeNoList");
		}
		if(detailsMap.get("icdNoList") != null){
			icdNoList = (List<MasIcd>)detailsMap.get("icdNoList");
		}
		if(detailsMap.get("dischargeStatusList") != null){
			dischargeStatusList = (List<MasDischargeStatus>)detailsMap.get("dischargeStatusList");
		}
		if(detailsMap.get("expiryDetailsList") != null){
			expiryDetailsList = (List<ExpiryDetails>)detailsMap.get("expiryDetailsList");
		}
		System.out.println("expiryDetailsList=="+expiryDetailsList.size());
		
		int dischargeNo = 0;

		if(dischargeNoList.size() > 0){
			for(Discharge discharge : dischargeNoList){
				dischargeNo = discharge.getDischargeNo()+1;
			}
		}else{
			dischargeNo = 1;
		}

		String adNo = "";
		String admissionDate = "";
		String admissionTime = "";
		adNo = inpatient.getAdNo();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();
%>
<script>
	function checkFollowUpDate(){
		var followUpDate = document.dischargeByHin.<%= FOLLOW_UP%>.value;
		var	followDate =new Date(followUpDate.substring(6),(followUpDate.substring(3,5) - 1) ,followUpDate.substring(0,2))
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		if(followUpDate != ""){
		if(followDate < currentDate)
		{
			alert("Follow Up Date should be greater Current Date.");
			document.dischargeByHin.<%=FOLLOW_UP%>.value = "";
			return false;
		}
		}
		return true;
	}
</script>
<form name="dischargeByHin" method="post"><script type="text/javascript">
var icdArray = new Array();
</script>



<%
int hinId1=0;
int inpatientId1=0;
String hinNo1 = "";
String adNo1 = "";
String patientStatus = "";

if( inpatient.getHin().getId()!=null)
{
hinId1 = inpatient.getHin().getId();
}

if(inpatient.getId()!=null)
{
inpatientId1 = inpatient.getId();
}

if(inpatient.getHin().getHinNo()!=null)
{
hinNo1 = inpatient.getHin().getHinNo();
}

if(inpatient.getAdNo()!=null)
{
adNo1 = inpatient.getAdNo();
}

if(inpatient.getAdStatus()!=null)
{
patientStatus = inpatient.getAdStatus();
}

String deptName="";
if (map.get("deptName") != null) {
deptName = (String) map.get("deptName");
}
%>



		
	<input type="hidden" id="hinId" name="hinId" value="<%=inpatient.getHin().getId() %>" />
	<input type="hidden" id="parent" name="parent" value="<%=inpatient.getId() %>" />
	<input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatient.getId() %>" />
	<input type="hidden" id="hiNumber" name="hiNumber" value="<%=inpatient.getHin().getHinNo() %>" />
	<input type="hidden" id="adNo" name="adNo" value="<%=inpatient.getAdNo() %>" />
	<input type="hidden" id="patientStatus" name="patientStatus" value="<%=inpatient.getAdStatus() %>" />


<input type="hidden" name="hinNo1" id="hinNO1" value=""/>
<input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId1 %>" />
<input type="hidden" name="patientStatus" id="patientStatus" value="<%=patientStatus %>" />

<div class="clear"></div>

<div class="clear paddingTop25"></div>




<div class="titleBg">
<h2>Patient Discharge</h2>

</div>


<h4>Discharge Schedule</h4>
<div class="clear"></div>
<div class="Block">
<%-- <label>Discharge No.</label> --%>
<input type="hidden" readonly="readonly" value="<%=dischargeNo %>"  /> 
<label>Discharge Date<span>*</span></label>
<input type="text" id="dobId" name="<%=DISCHARGE_DATE %>" tabindex="1" value="<%=currentDate%>" class="date"
	
	readonly="readonly" validate="Discharge Date,date,yes" maxlength="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
onclick="javascript:setdate('<%=currentDate %>',document.dischargeByHin.<%=DISCHARGE_DATE%>,event)" tabindex="1" />
<label>Discharge Time<span>*</span></label>
<input type="text" name="<%=DISCHARGE_TIME%>" value="<%=currentTime%>" onkeyup="mask(this.value,this,'2,5',':');"
	onblur="IsValidTimeForSetup(this.value,this.id);" validate="Discharge Time,time,yes"   maxlength="8" />

<label>Admission Date</label> 
<input type="text" readonly="readonly" value="<%=admissionDate%>"  />
<div class="clear"></div>
<label>Admission Time</label> 
<input type="text" readonly="readonly" value="<%=admissionTime %>"  />
<label>Ward</label> 
<input type="text" readonly="readonly" value="<%=inpatient.getDepartment().getDepartmentName() %>"  />
<div class="clear"></div></div>



<h4>Patient Details</h4>
<div class="clear"></div>
<%@include file="PatientDetails.jsp" %>


<h4>Discharge Details</h4>
<div class="clear"></div>
<div class="Block">

<label> Doctor<span>*</span></label> 
<select	name="<%=DOCTOR_NAME %>" validate="Doctor,int,yes">
	<option value="0">Select</option>
	<%
							for(MasEmployee masEmployee : employeeList){
								if(masEmployee.getEmpCategory() != null){
									//if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
										String doctorMiddleName = "";
										String doctorLastName = "";
										if(patient.getPMiddleName() != null){
											doctorMiddleName = masEmployee.getMiddleName();
										}
										if(patient.getPLastName() != null){
											doctorLastName = masEmployee.getLastName();
										}
										
										System.out.println(masEmployee.getFirstName());
						%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() %>
	<%=doctorMiddleName %> <%=doctorLastName %></option>
	<% 			//}
					}
							}	%>
</select>
<%-- <label> Dis Condition<span>*</span></label>
<select	name="<%=DISPOSAL_ID %>" validate="Disposal,int,yes">
	<option value="0">Select</option>
<%
	for(MasDisposal masDisposal : disposalList){%>
	<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName() %></option>
	<%} %>
</select> --%> 
<label> Discharge Status<span>*</span></label> <select
	name="<%=DISCHARGE_STATUS_ID %>" validate="Discharge Status,int,yes"
	onchange="checkDischargeStatus(this.value);" class="select_adt">
	<option value="0">Select</option>
	<%	
	for(MasDischargeStatus masDischargeStatus : dischargeStatusList){
		if(expiryDetailsList.size()>0){
			System.out.println("masDischargeStatus.getDischargeStatusName() "+masDischargeStatus.getDischargeStatusName());
	if(masDischargeStatus.getDischargeStatusName().equalsIgnoreCase("Expired")){		
	
		%>
	<option value="<%=masDischargeStatus.getId() %>" selected="selected"><%=masDischargeStatus.getDischargeStatusName() %></option>
	<%}}else{ %>
	<option value="<%=masDischargeStatus.getId() %>"><%=masDischargeStatus.getDischargeStatusName() %></option>
	<%}} %>
</select>
<label>Ambulance Request</label> 
<label class="value"><%=getAmbulanceRequestStatus(ambulanceStatus)%></label>
<div class="clear"></div>
<div id="otherHospitalId" style="display: none;">
<input type="text" name="<%=OTHER_HOSPITAL_NAME%>" id="" maxlength="30"	validate="Other Hospital Name,String,no" /></div>

<div class="clear"></div>
<%--
<label>Care Type</label> <select name="<%=CARE_TYPE_ID %>" validate="Care Type,String,no">
	<option value="0">Select</option>
	<%for(MasCareType masCareType : careTypeList){
						%>
	<option value="<%=masCareType.getId() %>"><%=masCareType.getCareTypeName() %></option>
	<%} %>
</select> <label>Injury Rpt Init On</label>
<input type="text"	id="cardValidityId" name="<%=INJURY_REPORT_INITIATED_ON %>" value="" class="date" readonly="readonly"
	validate="Injury Report Initiated On,date,no" maxlength="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.dischargeByHin.<%=INJURY_REPORT_INITIATED_ON%>,event);" />

<label>Injury Rpt Init at</label>
<textarea name="injury_report_init_at"	validate="Injury Report Initiated At,string,no" cols="25" rows="2"></textarea>

<div class="clear"></div>

<label>Board Held On</label>
<input type="text" id="cardValidityId" name="<%=BOARD_HELD_ON %>" value="" class="date" readonly="readonly"
	validate="Board Held On,date,no" maxlength="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.dischargeByHin.<%=BOARD_HELD_ON%>,event);" />

<label>Follow Up Date</label> 
<input type="text" id="cardValidityId" name="<%=FOLLOW_UP %>" value="" class="date" readonly="readonly"
	validate="Follow Up Date,date,no" maxlength="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate %>',document.dischargeByHin.<%=FOLLOW_UP%>,event);" />

<label>Dischrg In Medical Ctgry</label> 
<textarea name="<%=DISCHARGE_IN_MEDICAL_CATEGORY %>" value="" cols="25" rows="1"
	validate="Discharge In Medical Category,String,no" maxlength="20"></textarea>

<div class="clear"></div>
 --%>
 <label> Discharge To<span>*</span></label>
<select	name="<%=DISPOSED_TO_ID %>" validate="Disposed To,int,yes"
	onchange="getOtherHospitalTextBox(this.value);">
	<option value="0">Select</option>
	<%	for(MasDisposedTo masDisposedTo : disposedToList){	%>
	<option value="<%=masDisposedTo.getId() %>"><%=masDisposedTo.getDisposedToName() %></option>
	<%} %>
</select>
 <label>Care Summary</label> 
<textarea name="<%=CARE_SUMMARY %>"	validate="Care Summary,string,no" cols="25" rows="2" maxlength="200" onkeyup="return ismaxlength(this)"></textarea> 

<label>Instructions To Patient</label>
<textarea name="<%=INSTRUCTIONS %>"	validate="Instructions To Patient,string,no" cols="25" rows="2" maxlength="200" onkeyup="return ismaxlength(this)"></textarea>

<!--
<label>Document Initiated </label>
<textarea name="document_initiated" validate="Document Initiated,string,no" cols="25" rows="2" class="select_adt" /></textarea>
				 -->

<div class="clear"></div>
</div>

<h4>Diagnosis</h4>
<div class="clear"></div>

<%
			String diagnosis = "";
			if(dischargeIcdList.size() > 0){
				for(DischargeIcdCode dischargeIcdCode : dischargeIcdList){
					if(diagnosis.equals("")){
						if(dischargeIcdCode.getDiagnosisStatus().equals("f"))
						diagnosis = dischargeIcdCode.getIcd().getIcdName();
					}else{
						if(dischargeIcdCode.getDiagnosisStatus().equals("f"))
						diagnosis = diagnosis.concat(" , ").concat(dischargeIcdCode.getIcd().getIcdName());
					}
				}
			}
		%>
<div class="Block">

<%-- <label>Diagnosis</label> 
<input type="hidden" id="diag" value="<%=diagnosis %>" /> <%
if(!diagnosis.equals("")){
%> <label class="valueAuto"><%=diagnosis %></label> <%}else{ %> 
<label class="valueAuto">-</label> <%} %> --%>

<!--<input type="checkbox" id="<%=Z03 %>" name="<%=Z03 %>" class="radioCheck css-checkbox" value="z03" /><label for="<%=Z03 %>" name="<%=Z03 %>lbl" class="css-label"></label>
<label class="smallAuto">Z03</label>
<input type="checkbox" name="<%=Z09%>" id="Z09" class="radioCheck css-checkbox" value="z09" /><label for="Z09" name="Z09lbl" class="css-label"></label>
<label class="smallAuto">Z09</label>

-->

<%-- <input type="button" class="buttonDel" value=" " onclick="removeSelectedOptions();" align="right" />
<input type="button" class="buttonAdd" value=" " onclick="fillDiagnosisCombo();" align="right" />
<div class="clear"></div>
<label class="smalllabel">ICD Code</label>
<input name="" value="" class="date" id="icdCode" /> 
<input name="" value="" class="date" id="temp" type="hidden" />
<img src="/hms/jsp/images/search.gif" width="26" height="26" style="cursor: pointer;"
	onclick="javascript:openPopupWindow();" title="Click here to Search ICD Codes"></img>
<input type="hidden" class="checkbox" name="checkbox" id="checkbox" value="" /> 
<label>ICD Name 1</label> 
<input type="text" align="right" name="icd" id="icd" class="textbox_size20" style="width: 800" />
<div id="ac2update" style="overflow: scroll; display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	 new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
</script>

<div class="clear"></div>
<label>&nbsp;</label> 
<select name="<%=DIAGNOSIS_ID%>" size="5" multiple="65" id="diagnosisId" class="listBig2">
</select> --%>

<label>ICD Code</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
<select name="<%=DIAGNOSIS_ID%>" size="5" multiple="65" id="diagnosisId" class="listBig2">


<input type="button" class="buttonDel" value="" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />

<input type="text" name="dischargeStatus" id="dischargeStatusId" readonly="readonly" value="" />
<div class="clear"></div></div>
<div class="clear"></div>

<div class="division"></div>
<div class="clear"></div>
<input id="dischargeAddId" type="button" name="Submit11" value="Submit"	class="button"
	onclick="checkForFinalBill(<%=inpatient.getId() %>);if(finalBill()){submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation');}" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight" accesskey="r" /> 
<input id="expiryDetailsId" type="button" name="expiry" value="Expiry Details" class="buttonBig" style="display: none;"
	onclick="submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation&flag=expiry');" />
<%if(expiryDetailsList.size()>0){ %>	
<input id="gfgh" type="button" name="expiry" value="Expiry Details" class="button"  onclick="submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation&flag=expiry');" />
	<%}else{ %>
	<input id="gfgh" type="button" name="expiry" value="Expiry Details" class="button" style="display: none;"
	onclick="submitForm('dischargeByHin','/hms/hms/adt?method=submitDischargeInformation&flag=expiry');" />
	<%} %>
<input type="button" class="button" value="Back" align="right" onclick="history.back();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=currentTime%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /> 
<input type="hidden" name="hdb" value="1" id="hdb" /> 
<input type="hidden" name="<%=DISCHARGE_NO %>" value="<%=dischargeNo%>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/>
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo %>"/>
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatient.getId() %>"/>
<input type="hidden" name="<%=BED_ID%>" value="<%=inpatient.getBed().getId()%>"/>
<input type="hidden" name="<%=DEPARTMENT_ID%>" value="<%=inpatient.getDepartment().getId()%>"/>

<script>
		function getIcd(){
 //=========To get Icd String with icd code==========================
var icdCode =document.getElementById("icdCode").value

 if(icdCode !="")
  {
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }

    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName("icdString")[0];
	          var val =icdString.childNodes[0].nodeValue
	        	 if(val !="" && val !="NO"){
  				  var index1 = val.lastIndexOf("[");
				  var index2 = val.lastIndexOf("]");
	    		 index1++;
	    		 var id = val.substring(index1,index2);

	        	 obj =document.getElementById('diagnosisId');
				 obj.length = document.getElementById('diagnosisId').length;
	        	obj.length++;
	        	/* if(document.getElementById("Z09").checked == true ){
					id ="["+id+"]" +"{OLD}"
					val =val +"{OLD}"
				}else{
				id ="["+id+"]"
				} */
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				document.getElementById('icdCode').value =""
				 }else{
						 alert("Wrong Icd Code ...!");
					 getShadow('icdCode');
				 document.getElementById('icdCode').value =""
				 return false
				 }
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
  //==================End of Icd String block======================
}

		/* function deleteFromCombo(){
		var obj = document.getElementById("diagnosisId");
		var val = obj.value;
		for(i=0;i<obj.length;i++)
		{
			if(obj.options[i].selected == true){
			obj.options[i].text=""
			obj.options[i].value=""
			}

			}
		} */
		
		function deleteDgItems(value){
			alert(document.getElementById('diagnosisId').selectedIndex);
		    if(document.getElementById('diagnosisId').selectedIndex!=0){
			 if(confirm("are you sure want to delete ?")){
			 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

			    }
			   }
		    }

		/* function fillDiagnosisCombo() {
		var val =document.getElementById("icd").value
		//By using ICD Name
			if(val !=""){
  			    var index1 = val.lastIndexOf("[");
		        var index2 = val.lastIndexOf("]");
	            index1++;
	            var id = val.substring(index1,index2);
				obj =document.getElementById('diagnosisId');
				obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
	        	id ="["+id+"]"
				 if(document.getElementById("Z09").checked == true ){
					id ="["+id+"]" +"{OLD}"
					val =val +"{OLD}"
				}else{
					id ="["+id+"]"
				} 
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				document.getElementById('icd').value =""
				}else{
				//By using ICD Code
				getIcd();
				}
  			} */
  			
  			function fillDiagnosisCombo(val) {

  		         
  		  	  var index1 = val.lastIndexOf("[");
  			    var index2 = val.lastIndexOf("]");
  			    index1++;
  			    var id = val.substring(index1,index2);
  			   
  			    if(id ==""){
  				  return;
  				}else{
  				   		obj =document.getElementById('diagnosisId');
  						obj.length = document.getElementById('diagnosisId').length;
  	                   var valu=document.getElementById('diagnosisId').value;
  						var b="false";
  						for(var i=1;i<obj.length;i++){
  								    
  			                    	var val1=obj.options[i].value;
  			                    	var length=obj.length-1;
  	                               	
  			                    	if(id==val1)
  			                    	{
  			                        	alert("ICD  Already taken");
  			                        	document.getElementById('icd').value =""
  			                        	b=true;
  			                       	}
  			                              	
  			                    }
  	                   
  			                    if(b=="false")
  			                    {
  			                    	obj.length++;
  			    					obj.options[obj.length-1].value=id
  			    					obj.options[obj.length-1].text=val
  			    					obj.options[obj.length-1].selected=true
  			    					document.getElementById('icd').value =""
  			    			                    
  			                    }
  					}
  				
  		  }
  			
  			
			function checkSilDilPatient(){
		//Check for diagnosis blank

		if(document.getElementById('diag').value == ""){
		if(document.getElementById('diagnosisId').length =="0"){
			alert("Diagnosis should not blank ");
			return false
		}else{
		var temp = document.getElementById("diagnosisId");
			ln= temp.length;
			for(i=0;i<temp.length;i++)
			{
    			if(temp.options[i].text =="")
    			ln--;
			}
			if(ln=="0"){
			alert("Diagnosis should not blank ")
			return false
			}

			var obj = document.getElementById("diagnosisId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
    			obj.options[i].selected=true
			}

			}
		 }
		<%-- <%
		if(inpatient.getConditionStatus().equals("SIL") || inpatient.getConditionStatus().equals("DIL") ){
		%>
			var agree = confirm("Patient is SIL/DIL.Do you want to discharge patient.");
			if (agree)
				return true ;
			else
				return false
		<%}%> --%>
		return true;
		}
		</script> <%
		session.setAttribute("inpatient",inpatient);
		 }else{
		%>
<h4><font id="error">Patient is Ready To Discharge</font> </h4>
<%}%>
<div id="statusMessage" class="messagelabel">
<h4></h4>
</div>

<script type="text/javascript">

function displayListDateTime(){
	var list = document.getElementById('list').value;
	date = '<%=currentDate%>';
	time = '<%=currentTime%>';

	if(list != 0){
		document.getElementById('listdateId').value = date;
		document.getElementById('listtimeId').value = time;
	}else{
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
	}
}


function getOtherHospitalTextBox(disposalId){

if(disposalId == 12){
	document.getElementById('otherHospitalId').style.display = 'inline';
}else{
	document.getElementById('otherHospitalId').style.display = 'none';
return true;
}
}

</script>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<script type="text/javascript" language="javascript">
function checkPatientForDischarge()
{

	if(document.getElementById('inpatientId').value==''){
			alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('inpatientId').value!=''){
		if(document.getElementById('patientStatus').value=='R'){
				return true;
		}else{
				alert("Patient is not ready to discharge.");
			return false;
		}
	}
}



function checkPatient()
{
	if(document.getElementById('inpatientId').value==''){
			alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('inpatientId').value!=''){
		if(document.getElementById('patientStatus').value=='W'){
			if(confirm("Has the patient physically reported to ward ?"))
				return true;
			else
				return false;
		}else{
				alert("Patient already reported to ward.");
		}
	}
}

</script>


<script>
function checkForFinalBill(inpatientId){

	//alert("inpatientId----->>"+inpatientId);
	if(inpatientId!="0" && inpatientId!=""){

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }

		xmlHttp.onreadystatechange=function()
		{
		  if(xmlHttp.readyState==4){
			var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		         icdString  = item.getElementsByTagName('pendingString')[0];
		         b =icdString.childNodes[0].nodeValue;	  
				    if(b=='true'){alert(" Final Bill is Pending to Discharge the Patient!!");
				    document.getElementById('dischargeStatusId').value="y";
						 //  confirm("Some Prescription && Investigations are pending for the patient!!");
						   //document.getElementById('nomenclaturetreatment'+inc).value="";
						 //  if(confirm("Are you sure!!\n  Some Prescription && Investigations are pending for the patient!!")){
							//   document.getElementById('readyToDischarge').checked=true;
						 //  }else {
							//   alert("in else");
							//   document.getElementById('readyToDischarge').checked=false;
							//   }
						   }
					   }
				    }
					
		  }
			
		var url="/hms/hms/ipd?method=getDetailsForFinalBill&inpatientId="+inpatientId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
			}
}
function finalBill(){
	if(document.getElementById('dischargeStatusId').value=='y'){
	return false;
	}else{
		return true;
	}
}
</script>
