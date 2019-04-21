<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * attach_admission.jsp  
 * Purpose of the JSP -  This is for admission.
 * @author  Deepti Tevatia
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.13  
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.AttachInpatient"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.StringTokenizer"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/prototype.js"></script>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
	function jsSetBedId(bedId)
			{
			document.getElementById("bedId").value=bedId;
			}
</script>

<form name="attach" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%

int bedId = 0;
String adNo ="";
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> patientMap = new HashMap<String,Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
Map<String,Object> attachMap = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();

List<MasRelation> relationList = new ArrayList<MasRelation>();
List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
List<Patient> patientList = new ArrayList<Patient>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<Patient> hinList = new ArrayList<Patient>();
List<MasBed> bedList = new ArrayList<MasBed>();
List<Inpatient> existenceAttachedList = new ArrayList<Inpatient>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");
String message="";
String fathereExists ="n";
String motherExists ="n";
String serviceNo ="";
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
	e.printStackTrace();
}
int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
int relationIdForFather = Integer.parseInt(properties.getProperty("relationIdForFather"));
int relationIdForMother = Integer.parseInt(properties.getProperty("relationIdForMother"));
List<Inpatient> inpatientList =new ArrayList<Inpatient>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientMap") != null){
	patientMap = (Map<String,Object>)map.get("patientMap");
}
if(map.get("adNo") != null){
	adNo = ""+map.get("adNo");
}
if(map.get("serviceNo") != null){
	serviceNo = ""+map.get("serviceNo");
}
if(map.get("inpatientList") != null){
	inpatientList = (List<Inpatient>)map.get("inpatientList");
}
Inpatient inpatient =null;
try{
	if(inpatientList.size()>0)
inpatient = inpatientList.get(0);
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("attachMap") != null){
	attachMap = (Map<String,Object>)map.get("attachMap");
}
if(attachMap.get("hinList") != null){
	hinList = (List<Patient>)attachMap.get("hinList");
}
if(attachMap.get("existenceAttachedList") != null){
	existenceAttachedList = (List<Inpatient>)attachMap.get("existenceAttachedList");
}
if(patientMap.get("patientList") != null){
	patientList = (List<Patient>)patientMap.get("patientList");
}
}catch(Exception e){
	e.printStackTrace();
}
Patient patient =null;
if(patientList.size() > 0){
	
 try{
	 patient = patientList.get(0);
	
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String, Object>)map.get("detailsMap");
	}
	if(detailsMap.get("relationList") != null){
		relationList = (List<MasRelation>)detailsMap.get("relationList");
	}
	if(detailsMap.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)detailsMap.get("sexList");
	}
	if(detailsMap.get("departmentList") != null){
		departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
	}
	if(detailsMap.get("bedList") != null){
		bedList = (List<MasBed>)detailsMap.get("bedList");
	}
 }catch(Exception ee ){
	 ee.printStackTrace();
 }
 
%>
<h4><%=message %></h4>
<div class="clear"></div>
<input type="button" name="yes" value="Print" class="button"
	onclick="submitForm('attach','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%

 
if(existenceAttachedList.size() > 0){
%>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Already Attached Admission</h4>
<div class="clear"></div>
<div class="Block">
<%try{
		for (Iterator<Inpatient> iterator2 = existenceAttachedList.iterator(); iterator2.hasNext();) {
			Inpatient inpatient2 = (Inpatient) iterator2.next();
%> <label class="auto">Name</label> <label class="valueAuto"><%= inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()%></label>

<label class="auto">Age</label> <%
		if(inpatient2.getAge() != null){
		%> <label class="valueAuto"><%= inpatient2.getAge()%></label> <%} %> <label
	class="auto">Sex</label> <%
		if(inpatient2.getHin().getSex() != null){
		%> <label class="valueAuto"><%=inpatient2.getHin().getSex().getAdministrativeSexName()%></label>
<%} %> <label class="auto">Relation</label> <%
		if(inpatient2.getHin().getRelation() != null){
			
			if(inpatient2.getHin().getRelation().getId()==relationIdForMother ){
				motherExists="y";
			}
			if(inpatient2.getHin().getRelation().getId()==relationIdForFather ){
				fathereExists="y";
			}
		%> <label class="valueAuto"><%= inpatient2.getHin().getRelation().getRelationName() %></label>
<%} %> <%		}}catch(Exception e){
	e.printStackTrace();
}%>
<div class="clear"></div>
</div>

<%
	
}
%>

<div class="clear"></div>
<h4>New Attached Admission</h4>
<div class="clear"></div>
<div class="Block"><label class="medium"><span>*</span>
Name</label> <input type="text" name="<%=NAME_OF_ATTACH %>"
	validate="Name,String,no" MAXLENGTH="30" id="forName" /> <%Integer hours =0;
StringTokenizer s = new StringTokenizer(currentTime,":");  
if(s.hasMoreTokens())
hours=Integer.parseInt(""+s.nextToken()) ;
%> <label class="medium"><span>*</span> Sex</label> <select
	name="<%=SEX_ID %>" validate="Sex,String,no" id="forSex" class="small">
	<option value="0">Select</option>
	<% 
		for (MasAdministrativeSex  obj : sexList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getAdministrativeSexName()%></option>
	<% }%>
</select> <label class="medium"><span>*</span> Age</label> <input type="text"
	name="<%=AGE %>" validate="Age,int,no" maxlength="2" class="small"
	id="forAge" onblur="calculateDiet('<%=hours%>');" /> <select
	id="ageUnitId" name="<%=AGE_UNIT %>" validate="AgeUnit,string,no"
	class="small" tabindex="1" id="ageUnitId"
	onblur="calculateDiet('<%=hours%>');">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> <label><span>*</span> Veg/ Non-Veg</label> <select
	name="<%=DIET_TYPE%>" validate="Veg/Non-Veg,String,Yes" id="veg"
	class="small">
	<option value="0">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select>

<div class="clear"></div>

<label class="medium"><span>*</span> Diet </label> <select
	name="<%=DIET_ID%>" validate="Diet,String,Yes" id="diet">
	<option value="0">Select</option>
</select> <label class="medium"><span>*</span> Relation</label> <select
	name="<%=RELATION_ID %>" validate="Relation,String,no" id="rel"
	onchange="checkForDuplicateOfAdnoInAttach();" class="small">
	<option value="0">Select</option>
	<% 
	for (MasRelation  obj : relationList){
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getRelationName()%></option>
	<% }%>
</select> <label class="medium"><span>*</span> Ward</label> <select
	name="<%=DEPARTMENT_ID %>" validate="Select Ward,String,yes"
	onchange="checkBed();" id="wardId">
	<option value="0">Select</option>
	<% 
			for (MasDepartment  masDepartment : departmentList){
				if(inpatient.getDepartment().getId() ==masDepartment.getId()){
		%>
	<option value="<%=masDepartment.getId ()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}}%>
</select> <label class="medium"><span>*</span> Bed No</label> <input type="text"
	name="bedNo" id="bedNo" class="readOnly" readonly="readonly" value="" validate="Bed No,num,no"/>
<input type="hidden" name="bedNoTemp" id="bedNoTemp" value="" />
<div class="clear"></div>

<label class="medium"><span>*</span> Adm. Date</label> <input
	type="text" name="<%=CHANGED_DATE%>" value="<%=currentDate %>"
	readonly="readonly" validate="Visit Date,date,yes" MAXLENGTH="30"
	class="date" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.attach.<%=CHANGED_DATE%>,event)" /> <label
	class="medium"><span>*</span> Adm. Time</label> <input type="text"
	id="attachTimeId" name="<%=CHANGED_TIME %>" value="<%=currentTime %>"
	validate="Visit Time,String,yes"
	onchange="IsValidTime(this.value,this.id);" class="small" />

<div class="clear"></div>


<label class="medium"><span>*</span> Attached As </label> <select
	name="<%=AT_OR_DT%>" id="attachedAs">
	<option value="0">Select</option>
	<option value="Sick Attendent">Sick Attendent</option>
	<option value="Sick Dependent">Sick Dependent</option>
	<option value="Sick Dependent">dependent to attendent</option>

</select> <input type="hidden" name="<%=HSR_RECEIPT_NO %>"
	validate="HSR Receipt No,string,no" maxlength="12" value=""
	class="small" /> <input type="hidden" name="<%=HSR_AMOUNT %>"
	validate="HSR Amount,floatWithoutSpaces,no" maxlength="7" value=""
	class="small" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" value="<%=inpatient.getAdNo()%>" name="parentAdNo" />
<input type="hidden" value="<%=inpatient.getHin().getId()%>"
	name="<%=HIN_ID %>" /> <input type="hidden" name="<%=BED_ID %>"
	value="" id="bedId"><input type="hidden" name="bedNo" value=""
	id="bedNo">
<div id="edited"></div>
<input type="button" name="Submit11" value="Save" class="button"
	onClick="if(testPage()){submitForm('attach','/hms/hms/adt?method=saveAttachedAdmission&formName=attach');}" />
<input type="submit" class="button" value="Back"
	onclick="submitFormForBack('attach','/hms/hms/adt?method=showAdmissionJsp');" />
<input type="hidden" name="Reset" value="Reset" class="buttonHighlight"
	onclick="location.reload();" accesskey="r" /> <% }
		%>
<div id="statusMessage">
<h4></h4>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
function closeWin(){
close();
}

function testPage(){
var errorMessage="";
	formName="attach"
	obj = eval('document.'+formName)


	if(document.getElementById('forName').value == "")
		errorMessage=errorMessage+"Please Fill name \n"; 
		if(document.getElementById('forAge').value == "")
		errorMessage=errorMessage+"Please fill age \n"; 
		if(document.getElementById('forSex').value == 0)
		errorMessage=errorMessage+"Please Select sex \n"; 
		if(document.getElementById('attachedAs').value == 0)
		errorMessage=errorMessage+"Please Select attached As \n"; 
	if(document.getElementById('rel').value == 0)
		errorMessage=errorMessage+"Please Select Relation \n"; 
	if(document.getElementById('veg').value == 0)
		errorMessage=errorMessage+"Please Select Veg/Non-Veg  \n";
	if(document.getElementById('diet').value == 0)
		errorMessage=errorMessage+"Please Select diet  \n";
		if(document.getElementById('wardId').value == 0)
		errorMessage=errorMessage+"Please Select Ward  \n";

		if(document.getElementById('bedNo').value == 0)
			errorMessage=errorMessage+"Please Select Bed No  \n";
			
		if(errorMessage !=""){
		alert(errorMessage)
		return false;
		}else{
		return true
		}
}

function checkForDuplicateOfAdno2(motherStatus,fatherStatus,motherId,fatherId,id){
if((motherStatus=="y") &&(motherId==id)){
	alert("Mother Already attached...!");
	obj=eval(document.getElementById('rel'))
	obj.selectedIndex=0
	return false;
}
if((fatherStatus=="y") &&(fatherId==id)){
	alert("Father already attached...!")
	obj=eval(document.getElementById('rel'))
	obj.selectedIndex=0
	return false
}
return true
}


function submitFormForBack(formName,action){
		obj = eval('document.'+formName)
	        	obj.action = action;
				obj.submit();
			
	}
function calculateDiet(hours){
ageVal=document.getElementById("forAge").value
	if(document.getElementById("ageUnitId").value !="Years"){
		ageVal=0
	}
	obj = eval('document.attach.diet');
	obj.length = 1;
	
	if(ageVal < 1){
		obj.options[obj.length-1].value=24;
		obj.options[obj.length-1].text='B/F';
		obj.selectedIndex =obj.length-1			
	}else if(ageVal < 5){
		obj.options[obj.length-1].value=25;
		obj.options[obj.length-1].text='N/2';
		obj.selectedIndex =obj.length-1
	}else if(ageVal >5 && ageVal <10){
		obj.options[obj.length-1].value=26;
		obj.options[obj.length-1].text='O/2';
		obj.selectedIndex =obj.length-1
	}else if(ageVal > 10){
	
		if(hours >= 18  && hours <24){
			obj.options[obj.length-1].value=3;
			obj.options[obj.length-1].text='N';
			obj.selectedIndex =obj.length-1
		}else if(hours >= 0  && hours <12)
		{
			obj.options[obj.length-1].value=1;
			obj.options[obj.length-1].text='O';
			obj.selectedIndex =obj.length-1
		}else if(hours >= 12  && hours <18 ){
			obj.options[obj.length-1].value=2;
			obj.options[obj.length-1].text='S';
			obj.selectedIndex =obj.length-1
		}
	}
	}
	
	
</script></form>



<% bedList.clear();
departmentList.clear();
existenceAttachedList.clear();
hinList.clear();
inpatientList.clear();
patientList.clear();
sexList.clear();

%>