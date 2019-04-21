<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * addMotherBabyDetails.jsp
 * Purpose of the JSP -  This is for adding mother details.
 * @author  Tej Singh
 * Create Date: 13th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.9
--%>
<%@page import="jkt.hms.masters.business.MasDeliveryType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DeliveryDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<%@page import="java.io.InputStream"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<div class="clear"></div>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script>
<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

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

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object>  utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

	List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}

	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	
	if(patientMap.get("inPatientList") != null){
		inPatientList = (List<Inpatient>)patientMap.get("inPatientList");
	}
	if(patientMap.get("deliveryTypeList") != null){
		deliveryTypeList = (List<MasDeliveryType>)patientMap.get("deliveryTypeList");
	}
	if(patientMap.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)patientMap.get("sexList");
	}
	if(patientMap.get("employeeList") != null){
		employeeList = (List<MasEmployee>)patientMap.get("employeeList");
	}
	if(patientMap.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)patientMap.get("bloodGroupList");
	}

%>

<!--  <h2>Patient Discharge</h2> -->

<%
	Inpatient inpatient = new Inpatient();
	Patient patient = new Patient();

	if(inPatientList != null && inPatientList.size() > 0){
		inpatient = inPatientList.get(0);
		patient = inpatient.getHin();
	%>

<form name="motherBabyDetails" method="post">
<h2>Mother Details</h2>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" id="hiNumber" name="hiNumber" tabindex="1" value="<%=patient.getHinNo()%>" class="readOnly"	MAXLENGTH="30" onblur="if(validateHinNo(this.value)){submitProtoAjaxWithDivName('motherBabyDetails','/hms/hms/ipd?method=fillPatinetDetailsAjax&hinNo=<%=patient.getHinNo()%>','patientDetails');}" />
<input type="hidden" id="hinIdMother" name="hinIdMother" class="readOnly" tabindex="1" value="<%=patient.getId()%>" MAXLENGTH="30" />
<div id="patientDetails">
<label>Name</label>
<input type="text" id="patientName" name="<%=PATIENT_NAME %>" class="readOnly"	tabindex="1" value="<%=patient.getPFirstName()%>" +"<%=patient.getPMiddleName()%>"+"<%=patient.getPLastName()%>"   MAXLENGTH="30" />
<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" id="AdNumber" name="<%=AD_NO %>" class="readOnly" tabindex="1" value="<%=inpatient.getAdNo()%>" MAXLENGTH="30" />
<input type="hidden" id="<%=INPATIENT_ID%>" name="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" />
<input type="hidden"id="<%=HIN_ID%>" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />

<div class="clear"></div>
<label>Ward</label>
<input type="text" id="Department"	name="<%=DEPARTMENT_NAME %>" class="readOnly" tabindex="1"	value="<%=inpatient.getDepartment().getDepartmentName()%>"	MAXLENGTH="30" />
<label>Age</label>
<% if(patient.getAge()!=null){%>
<input type="text" id="Age"	name="<%=AGE %>" class="readOnly" tabindex="1"	value="<%=patient.getAge()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="text" id="Age"	name="<%=AGE %>" class="readOnly" tabindex="1"	value="" MAXLENGTH="30" />
<%} %>
<label>Bed No.</label>
<input type="text" id="BedNo" name="<%=BED_NO %>" class="readOnly"	tabindex="1" value="<%=inpatient.getBed().getBedNo()%>" MAXLENGTH="30" />
<div class="clear"></div>


<%if(patient.getPatientType()!=null){ %>
<input type="hidden" id="patientTypeId" name="patientTypeId" class="readOnly" tabindex="1" value="<%=patient.getPatientType().getId()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="hidden" id="patientTypeId" name="patientTypeId" class="readOnly" tabindex="1" value="0" MAXLENGTH="30" />
<%} %>

<%if(patient.getBplStatus()!=null){ %>
<input type="hidden" id="bplStatus" name="bplStatus" class="readOnly" tabindex="1" value="<%=patient.getBplStatus()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="hidden" id="bplStatus" name="bplStatus" class="readOnly" tabindex="1" value="" MAXLENGTH="30" />
<%} %>
<%if(patient.getNotionalDobStatus()!=null){ %>
<input type="hidden" id="nationalDobStatus" name="nationalDobStatus" class="readOnly" tabindex="1" value="<%=patient.getNotionalDobStatus()%>" MAXLENGTH="30" />
<%}else{ %>
<input type="hidden" id="nationalDobStatus" name="nationalDobStatus" class="readOnly" tabindex="1" value="" MAXLENGTH="30" />
<%} %>
<%} %>

</div>
<label>Term of Gestation</label>
<select name="termOfGestation" id="termOfGestation" validate="Term of Gestation,string,no">
<option value="">Select</option>
<option value="Full Term">Full Term</option>
<option value="Pre Term">Pre Term</option>
<option value="Post Term">Post Term</option>
</select>

<label>Duration Of Delivery</label>
<select name="durationOfDelivery" id="durationOfDelivery" validate="Duration Of Delivery,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Prolonged">Prolonged</option>
<option value="Precipitated">Precipitated</option>
</select>

<label>Stage III</label>
<select name="stageThree" id="stageThree" validate="Stage III,string,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Prolonged">Prolonged</option>
</select>
<div class="clear"></div>
<label>Episiotomy</label>
<select name="episiotomy" id="episiotomy" validate="Episiotomy,string,no">
<option value="">Select</option>
<option value="RMLE">RMLE</option>
<option value="LMLE">LMLE</option>
<option value="Midline">Midline</option>
<option value="No episiotomy">No episiotomy</option>
</select>

<label>Anaesthesia</label>
<select name="anaesthesia" id="anaesthesia" validate="Anaesthesia,string,no">
<option value="">Select</option>
<option value="LA">LA</option>
<option value="Epidural">Epidural</option>
<option value="Spinal">Spinal</option>
<option value="General">General</option>
<option value="Nil">Nil</option>
</select>
<!-- <label><span>*</span> Perineal Tears</label> -->
<label>Perineal Tears</label>
<input type="text" id="perinealTears" name="perinealTears"	validate="Perineal Tears,string,no" tabindex="1" MAXLENGTH="250" />

<div class="clear"></div>

<label>Placenta & Membranes</label>
<select name="placentaAndMembranes" id="placentaAndMembranes" validate="Placenta,string,no">
<option value="">Select</option>
<option value="Expelled completely">Expelled completely</option>
<option value="Incomplete">Incomplete/Retained products</option>
<option value="Adherent Placenta">Adherent Placenta</option>
<option value="Manual">Manual</option>
</select>

<label>Bleeding</label>
<select name="bleeding" id="bleeding" validate="Bleeding,string,no">
<option value="">Select</option>
<option value="Within normal limits">Within normal limits</option>
<option value="Excessive">Excessive</option>
<option value="Massive">Massive</option>
</select>

<label>Blood Transfusion</label>
<select name="bloodTransfusion" id="bloodTransfusion" validate="Bleeding,string,no">
<option value="">Select</option>
<option value="Not Required">Not Required</option>
<option value="Given">Given</option>
</select>

<div class="clear"></div>

<label>Suture Material</label>
<input type="text" id="sutureMaterial" name="sutureMaterial"	validate="Suture Material,string,no" tabindex="1" MAXLENGTH="250" />

<label>State Of Uterus</label>
<select name="stateOfUterus" id="stateOfUterus" validate="State Of Uterus,string,no">
<option value="">Select</option>
<option value="Convoluted">Convoluted</option>
<option value="Atonic">Atonic</option>
</select>


<label>Lactation</label>
<select name="lactation" id="lactation" validate="Lactation,string,no">
<option value="">Select</option>
<option value="Not Required">Initiated Immediately</option>
<option value="Initiated within 1 Hr">Initiated within 1 Hr</option>
<option value="Not Initiated">Not Initiated</option>
</select>

<div class="clear"></div>

<label> Stage Complications</label>
<input type="text" id="stageComplications" name="satgeComplications"	validate="Complications,string,no" tabindex="1" MAXLENGTH="250" />

<label>Other Remarks</label>
<input type="text" id="otherRemarks" name="otherRemarks"	validate="Other Remarks,string,no" tabindex="1" MAXLENGTH="250" />

<label>No. Of Baby</label>
<input type="text" id="noOfBaby" name="noOfBaby" value=""	 onblur="displayBabyDetails(this.value)"   validate="No.Of Baby,int,yes" tabindex="1" MAXLENGTH="1" />

<div class="clear"></div>
<label><span>*</span> Blood Group</label>
 <select id="bloodGroupId"	name="<%=BLOOD_GROUP_JSP%>">
 	<%if(patient.getBloodGroup() != null){ %>
 		<option value="<%=patient.getBloodGroup().getId()%>"><%=patient.getBloodGroup().getBloodGroupName()%></option>
 	<% } else { %>
	<option value="0">Select</option>
	<%for(MasBloodGroup bloodGroup : bloodGroupList){ %>
	<option value="<%=bloodGroup.getId()%>"><%=bloodGroup.getBloodGroupName()%></option>
	<%} }%>
</select>

<div id="babyDetailsDiv">


</div>

<script type="text/javascript">
var sexArray=new Array();
var deliveryTypeArray=new Array();
var bloodGroupArray=new Array();

<%
MasAdministrativeSex sex = new MasAdministrativeSex();

for (int i = 0; i < sexList.size(); i++) {
	sex = (MasAdministrativeSex) sexList.get(i);
if(!sex.getAdministrativeSexName().equals("")){
%>


sexArray[<%=i%>]= new Array();
sexArray[<%=i%>][0] = "<%=sex.getId()%>";


sexArray[<%=i%>][1] = "<%=sex.getAdministrativeSexName()%>";
 <% }}%>
 
 
 <%
 MasDeliveryType deliveryType = new MasDeliveryType();

 for (int i = 0; i < deliveryTypeList.size(); i++) {
	 deliveryType = (MasDeliveryType) deliveryTypeList.get(i);
 %>


 deliveryTypeArray[<%=i%>]= new Array();
 deliveryTypeArray[<%=i%>][0] = "<%=deliveryType.getId()%>";
 deliveryTypeArray[<%=i%>][1] = "<%=deliveryType.getDeliveryTypeDescription()%>";
  <% }%>

 <%
 MasBloodGroup bloodGroup = new MasBloodGroup();
 
 for (int i = 0; i < bloodGroupList.size(); i++) {
	 bloodGroup = (MasBloodGroup) bloodGroupList.get(i);
 %>

 	bloodGroupArray[<%=i%>]=new Array();
 	bloodGroupArray[<%=i%>][0] = "<%=bloodGroup.getId()%>";
 	bloodGroupArray[<%=i%>][1] = "<%=bloodGroup.getBloodGroupName()%>";
 <% }%>
 
 
	function displayBabyDetails(iteration){
		 for(var j=1;j<=iteration;j++)
   	  {
			 
		 var e0 = document.createElement('h4');
		e0.innerHTML ='Baby Detail '+j;
		babyDetailsDiv.appendChild(e0);
		
		var clearDiv = document.createElement('div');
		clearDiv.className = 'clear';
		babyDetailsDiv.appendChild(clearDiv); 
			 
		 var e1 = document.createElement('label');
		e1.innerHTML ='Baby No.';
		babyDetailsDiv.appendChild(e1);
		
		  var e11 = document.createElement('input');
		  e11.type = 'text';
		  e11.name='babyNo'+j;
		  e11.id='babyNo';
		  e11.value = j;
		  babyDetailsDiv.appendChild(e11);
		  
			var e2 = document.createElement('label');
			//e2.innerHTML ='Sex Of Baby';
			e2.innerHTML ='<span>*</span>Gender of Baby';//added by govind 22-12-2016				
			babyDetailsDiv.appendChild(e2);
					
		   var e21 = document.createElement('Select');
		  e21.name='sexOfBaby'+j;
		  e21.id='sexOfBaby';
		  e21.setAttribute('validate', 'Gender of Baby,int,yes');//added by govind 22-12-2016	
		 e21.options[0] = new Option('Select', '0');
		for(var i = 0;i<sexArray.length;i++ ){
			e21.options[i+1] = new Option(sexArray[i][1],sexArray[i][0]);
		} 
		babyDetailsDiv.appendChild(e21); 
		
		// var e22 = document.createElement("br");
	      //babyDetailsDiv.appendChild(e22);
		
		var e3 = document.createElement('label');
		e3.innerHTML ='Live/Still Born';
		babyDetailsDiv.appendChild(e3);
		
		var e31 = document.createElement('select');
		e31.options[0] = new Option('Select', '');
		e31.options[1] = new Option('Live', 'Live');
		e31.options[2] = new Option('Masserated Still Birth', 'Masserated Still Birth');
		e31.options[3] = new Option('Fresh Still Birth', 'Fresh Still Birth');
		e31.options[4] = new Option('Live cyanosed', 'Live cyanosed');
		e31.name = 'live'+ j;
		e31.id = 'live';
		e31.tabIndex="1";
	 	//e31.onclick = function(){displayValue(this.value)};
		babyDetailsDiv.appendChild(e31);
		
		 var e4 = document.createElement('label');
		e4.innerHTML ='Birth Weight';
		babyDetailsDiv.appendChild(e4);
		
		var e41 = document.createElement('input');
	  e41.type = 'text';
	  e41.name='birthWeight'+j;
	  e41.id='birthWeight';
	  e41.value='';
	  babyDetailsDiv.appendChild(e41);
	  
	  var e5 = document.createElement('label');
		e5.innerHTML ='Time Delivery';
		babyDetailsDiv.appendChild(e5);
		
		var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.name='timeOfDelivery'+j;
	  e51.id='timeOfDelivery';
	  e51.value = '';
	  e51.maxLength ='5';
	  e51.onkeyup = function(){mask(this.value,this,'2',':')};
	  babyDetailsDiv.appendChild(e51);
	  
	  var e6 = document.createElement('label');
		e6.innerHTML ='Date';
		babyDetailsDiv.appendChild(e6);
		
		var e61 = document.createElement('input');
	  e61.type = 'text';
	  e61.name='birthDate'+j;
	  e61.id='bDate';
	  e61.className='date';
	  e61.value = '<%=currentDate%>';
	  babyDetailsDiv.appendChild(e61);
	  
	  var img1 = document.createElement('img');
	  img1.src = '/hms/jsp/images/cal.gif';
	  img1.onclick=function(event)
      {	
		  var obj1=document.getElementById('bDate');
		  setdate('<%=currentDate%>',obj1,event);
      };
      babyDetailsDiv.appendChild(img1);
     
      var clearDiv = document.createElement('div');
		clearDiv.className = 'clear';
		babyDetailsDiv.appendChild(clearDiv); 
      
      var e7 = document.createElement('label');
		e7.innerHTML ='Type Of Delivery';
		babyDetailsDiv.appendChild(e7);
		
		var e71 = document.createElement('select');
		e71.name = 'typeOfDelivery'+ j;
		e71.id = 'typeOfDelivery';
		e71.options[0] = new Option('Select', '');
		for(var i = 0;i<deliveryTypeArray.length;i++ ){
			e71.options[i+1] = new Option(deliveryTypeArray[i][1],deliveryTypeArray[i][0]);
		} 
		e71.tabIndex="1";
		babyDetailsDiv.appendChild(e71);
		
		var e8 = document.createElement('label');
		e8.innerHTML ='Presentation';
		babyDetailsDiv.appendChild(e8);
		
		var e81 = document.createElement('select');
		e81.options[0] = new Option('Select', '');
		e81.options[1] = new Option('Vertex', 'Vertex');
		e81.options[2] = new Option('Breech', 'Breech');
		e81.options[3] = new Option('Face', 'Face');
		e81.name = 'presentation'+ j;
		e81.id = 'presentation';
		e81.tabIndex="1";
		babyDetailsDiv.appendChild(e81);
		
		var e9 = document.createElement('label');
		e9.innerHTML ='Baby Cry';
		babyDetailsDiv.appendChild(e9);
		
		var e91 = document.createElement('select');
		e91.options[0] = new Option('Select', '');
		e91.options[1] = new Option('Cried immediately', 'Cried immediately');
		e91.options[2] = new Option('Cry delayed', 'Cry delayed');
		e91.name = 'babyCry'+ j;
		e91.id = 'babyCry';
		e91.tabIndex="1";
		babyDetailsDiv.appendChild(e91);
		
		var e10 = document.createElement('label');
		e10.innerHTML ='APGAR AT 1';
		babyDetailsDiv.appendChild(e10);
		
		var e12 = document.createElement('select');
		e12.options[0] = new Option('Select', '');
		 for(var i=0;i<=10;i++)
	   	  {
			 e12.options[i] = new Option(i, i); 
	   	  }
		e12.name = 'apgarAtone'+ j;
		e12.id = 'apgarAtone';
		e12.tabIndex="1";
		babyDetailsDiv.appendChild(e12);
		
		var e13 = document.createElement('label');
		e13.innerHTML ='APGAR AT 1';
		babyDetailsDiv.appendChild(e13);
		
		var e14 = document.createElement('select');
		e14.options[0] = new Option('Select', '');
		 for(var i=0;i<=10;i++)
	   	  {
			 e14.options[i] = new Option(i, i); 
	   	  }
		e14.name = 'apgarAtFive'+ j;
		e14.id = 'apgarAtFive';
		e14.tabIndex="1";
		babyDetailsDiv.appendChild(e14);
		
		
		var e15 = document.createElement('label');
		e15.innerHTML ='Complications';
		babyDetailsDiv.appendChild(e15);
		
		var e16 = document.createElement('input');
	  e16.type = 'text';
	  e16.name='complications'+j;
	  e16.id='complications';
	  e16.value = '';
	  babyDetailsDiv.appendChild(e16);
	  
	  
	  var e17 = document.createElement('label');
		e17.innerHTML ='Anomalies';
		babyDetailsDiv.appendChild(e17);
		
		var e18 = document.createElement('input');
	  e18.type = 'text';
	  e18.name='anomalies'+j;
	  e18.id='anomalies';
	  e18.value = '';
	  babyDetailsDiv.appendChild(e18);
	  
	  var e19 = document.createElement('label');
		e19.innerHTML ='Baby Feeding';
		babyDetailsDiv.appendChild(e19);
		
		var e20 = document.createElement('select');
		e20.options[0] = new Option('Select', '');
		e20.options[1] = new Option('Feeding well', 'Feeding well');
		e20.options[2] = new Option('Not feeding well', 'Not feeding well');
		e20.name = 'babyFeeding'+ j;
		e20.id = 'babyFeeding';
		e20.value = '';
		e20.tabIndex="1";
		babyDetailsDiv.appendChild(e20);

	  var e23 = document.createElement('label');
		e23.innerHTML ='Blood Group';
		babyDetailsDiv.appendChild(e23);

		var e24 = document.createElement('select');
		e24.name = 'bloodGroup'+ j;
		e24.id = 'bloodGroup';
		e24.options[0] = new Option('Select', '0');
		for(var i = 0; i < bloodGroupArray.length; i++ ){
			e24.options[i+1] = new Option(bloodGroupArray[i][1],bloodGroupArray[i][0]);
		} 
		e24.tabIndex="1";
		babyDetailsDiv.appendChild(e24);
		
		  var clearDiv = document.createElement('div');
			clearDiv.className = 'clear';
			babyDetailsDiv.appendChild(clearDiv); 	
		
			  
   	  }	
		
	}
	
	/* function displayValue(val){
	
	if(val="Masserated Still Birth"){
		document.getElementById('live').style.dislpaly = 'none';	
	}else if(val = "Fresh Still Birth"){
		
		
	}
		
		
		
		
		
	}
 */





</script>

<%-- <label>Blood Loss</label>
<input type="radio" name="<%=BLOOD_LOSS %>"	value="1" class="radioCheck" />
<label class="auto">More than 500 ml</label>
<input	type="radio" name="<%=BLOOD_LOSS %>" value="2" class="radioCheck" />
<label class="auto">Less than 500 ml</label>
<div class="clear"></div>
<label>Placenta</label>
<input type="radio" name="<%=PLACENTA %>" value="1" class="radioCheck" />
<label class="auto">Complete</label>
<input	type="radio" name="<%=PLACENTA %>" value="2" class="radioCheck" />
<label class="auto">InComplete</label>
<div class="clear"></div>
<input type="hidden" id="<%=INPATIENT_ID%>" name="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" />
<input type="hidden"id="<%=HIN_ID%>" name="<%=HIN_ID%>" value="<%=patient.getId() %>" />
<label><span>*</span> Treatment</label>
<input type="text" id="Treatment" name="<%=TREATMENT%>"	validate="Treatment,string,yes" tabindex="1" MAXLENGTH="12" />
<label>Date of Labor Onset</label>
<input type="text" id="DateOnSet" name="<%=DATE_ON_SET %>" value="<%=currentDate %>" class="readOnly" readonly="readonly" tabindex="1" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('',document.motherBabyDetails.<%=DATE_ON_SET%>,event)" />
<label>Time of Labor Onset</label>
<input type="text" id="TimeOnSet" name="<%=TIME_ON_SET %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label>Puerperium</label>
<input type="text" id="Puerperium"	name="<%=PUERPERIUM %>" tabindex="1" MAXLENGTH="30" />
<label>Mother Condition</label>
<input type="radio" name="<%=MOTHER_CONDITION %>" value="1"	class="radioCheck" />
<label class="auto">Alive</label>
<input type="radio"	name="<%=MOTHER_CONDITION %>" value="2" class="radioCheck" />
<label class="auto">Dead</label>
<div class="clear"></div>
<label>Pulse</label>
<input type="text" id="Pulse" name="<%=PULSE %>" tabindex="1" MAXLENGTH="30" />
<label>Perineum</label>
<input	type="text" id="Perineum" name="<%=PERINEUM%>" tabindex="1"	MAXLENGTH="30" />
<div class="clear"></div>
<label>BP</label>
<input type="text" id="Bp" placeholder="Systolic" 	name="bp" tabindex="1" MAXLENGTH="30" />
<input type="text" id="Bp" placeholder="Diastolic" 	name="bp2" tabindex="1" MAXLENGTH="30" />


<div class="clear"></div>
<label>Additional Notes</label>
<input type="text" id="AdditionalNotes"	name="<%=ADDITIONAL_NOTES %>" tabindex="1" MAXLENGTH="30" />
 <label>Complications</label>
<input type="text" id="Complications" name="<%=COMPLICATIONS%>"	tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label><span>*</span> Conducted By </label>
 <select id="ConductedBy"	name="<%=CONDUCTED_BY%>" validate="Conducted By,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	</option>
	<%} %>
</select>
<label><span>*</span>AssistedBy </label>
 <select id="AssistedBy"	name="<%=ASSISTED_BY%>" validate="Assisted By,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	</option>
	<%} %>
</select> --%>

<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('motherBabyDetails','/hms/hms/ipd?method=addMotherBabyDetails');"accesskey="a" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time:</label> <label
	class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>

<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>
<%deliveryDetailsList.clear();
employeeList.clear();
inPatientList.clear();
%>