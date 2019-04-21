<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Birth .
 * @author  Dipali
 * Create Date: 23rd April,2008
 * Revision Date:
 * Revision By:
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
    Map<String, Object> map = new HashMap<String, Object>();
	String motherName=null;
	
	String regNo="";
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}

	

	   String timeOfBirth="";
		Date dateOfBirth=null;
		Double apgarScore=null;
		String dob="";
		Integer obj = new Integer(5);
		if(map.get("timeOfBirth")!=null)
		{
			timeOfBirth=(String)map.get("timeOfBirth");
		}
		if(map.get("apgarScore")!=null)
		{
			obj=(Integer)map.get("apgarScore");
			apgarScore=obj.doubleValue();
		}
		if(map.get("dateOfBirth")!=null)
		{
			dateOfBirth=(Date)map.get("dateOfBirth");
			
			dob=HMSUtil.convertDateToStringTypeDateOnly(dateOfBirth);
		}
		if(map.get("motherName")!=null)
		{
			motherName=(String)map.get("motherName");
		}
		String address="";
		if(map.get("address")!=null)
		{
			address=(String)map.get("address");
		}
		
		Date  regDated=null;
		if(map.get("regDate")!=null)
		{
			regDated=(Date)map.get("regDate");
			
		
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date1 = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<Patient> motherList = new ArrayList<Patient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
   try{
		inPatientDetailList=(List)map.get("showList");
	
		
		

	
		if(map.get("employeeList")!=null)
		{
			employeeList=(List)map.get("employeeList");
		}

		if(map.get("regNo")!=null)
		{
			regNo=(String)map.get("regNo");
		}
		
	
	}catch(Exception e){
		e.printStackTrace();
	}


	String userName = "";
	String regDate="";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String babyAddress="";
	
	   if(inPatientDetailList != null && inPatientDetailList.size()>0)
	   {
		   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
		   String middleName = "";
		   String lastName = "";
		   if(inPatientDetail.getHin().getPMiddleName() != null){
				middleName = inPatientDetail.getHin().getPMiddleName();
			}
			if(inPatientDetail.getHin().getPLastName() != null){
				lastName = inPatientDetail.getHin().getPLastName();
			}
		   String patientName=inPatientDetail.getHin().getPFirstName()+""+middleName+""+lastName;
		   if(inPatientDetail.getHin()!=null){
			   babyAddress=inPatientDetail.getAddress();

			   regDate=HMSUtil.convertDateToStringTypeDateOnly(inPatientDetail.getHin().getRegDate());
		   }
 %>

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 22 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div id="birthDiv">
<label class="bodytextReg">
<span>*</span> Patient</label> 
<input id="patientId" type="text" name="<%=PATIENT_NAME %>"	value="<%=patientName %>" title="Patient" class="textbox_size20" validate="Patient,metachar,yes" MAXLENGTH="15" tabindex="3"/> 
<input	type="hidden" id="frwSlno" name="<%=HIN_ID%>" value="<%=inPatientDetail.getHin().getId()%>" class="textbox_date" MAXLENGTH="30" validate="hinId,int,no"/> 
<input type="hidden" id="frwSlno" name="<%=SEX_ID%>" value="<%=inPatientDetail.getHin().getSex().getId()%>"	class="textbox_date" MAXLENGTH="30" validate="genderId,int,no"/> 
<label class="bodytextReg"><span>*</span> Gender</label>
<%if(inPatientDetail.getHin().getSex() != null){ %>
<input type="text" id="genderId" name="genderId" value="<%=inPatientDetail.getHin().getSex().getAdministrativeSexName()%>" readonly="readonly"  tabindex="4"/>
<%}else{ %>
<input type="text" name="<%=SEX%>" size="2" value=""  tabindex="4"/>
<%} %>



<input type="hidden" name="<%=MOTHER_NAME%>" value="<%=motherName %>"  tabindex="4"/>

<label>Address</label>
<%if(address!=null){ %>
<textarea rows="" cols="" name="<%=ADDRESS %>" disabled="disabled"><%=address%></textarea>

<%}else{ %>

<textarea rows="" cols="" name="<%=ADDRESS %>"  disabled="disabled">-</textarea>
<%} %>
<label><span>*</span> Antenatal Checkup</label> 
<select id="antenatalCheckup"	name="<%=ANTENATAL_CHECKUP %>"  tabindex="6" validate="antenatalCheckup,metachar,yes">
	<option value="Done">Done</option>
	<option value="Not Done">Not Done</option>
</select>

<label class="auto"><span>*</span> Date of <%=prop.getProperty("com.jkt.hms.ipd") %> of Mother</label>
<%if(regDated!=null){ %>
<input type="text" class="calDate" id="motherIpdDate"	 name="<%=MOTHER_IPD_DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(regDated)%>" class="textbox_date" 	validate="Date of <%=prop.getProperty("com.jkt.hms.ipd") %> of Mother,date,yes" readonly="readonly"  tabindex="7"/> 

<%}else{ %>
<input type="text" class="calDate" id="motherIpdDate"	name="<%=MOTHER_IPD_DATE %>" value="" class="textbox_date" 	validate="Date of <%=prop.getProperty("com.jkt.hms.ipd") %> of Mother,date,yes" readonly="readonly"  tabindex="7"/> 
<img id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=MOTHER_IPD_DATE%>,event);" />

<%} %>
<div class="clear"></div>

<label class="bodytextReg"><span>*</span> Baby Delivery Date</label>
 <%if(dateOfBirth!=null){ %>
<input type="text" class="calDate" id="birthDateId"	name="<%=DATE_OF_BIRTH %>" onblur="pastDateValidation();"	value="<%=HMSUtil.changeDateToddMMyyyy(dateOfBirth)%>" class="textbox_date" validate="Baby Delivery Date,date,yes" readonly="readonly"  tabindex="8"/> 
<img id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event);" />
<input	type="hidden" name="<%=CHANGED_DATE %>" id="changeddate2" value="<%=date1%>" /> 
<%}else{ %>
<input type="text" id="birthDateId"	name="<%=DATE_OF_BIRTH %>" size="2" value="" onblur="pastDateValidation();" validate="Baby Delivery Date,date,yes" readonly="readonly"  tabindex="8"/>
<img id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event);" />
<%} %> 
 <%if(timeOfBirth!=null){ %>
<label class="bodytextReg"><span>*</span> Baby Delivery Time</label>
<input type="text" class="calDate" id="timeOfBirth"	name="<%=TIME_OF_BIRTH %>"	value="<%=timeOfBirth %>" class="textbox_date" style="width: 114px;" validate="Baby Delivery Time,string,yes" onKeyUp="mask(this.value,this,'2',':');"  maxlength="10"  tabindex="9"/><font size="1" color="blue">(HH:MM)</font>
<%}else{ %>
<input type="text" class="calDate" id="timeOfBirth"	name="<%=TIME_OF_BIRTH %>"	value="" class="textbox_date" style="width: 114px;" validate="Baby Delivery Time,string,yes" onKeyUp="mask(this.value,this,'2',':');"  maxlength="10"  tabindex="9"/><font size="1" color="blue">(HH:MM)</font>
<%} %>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span> Type Of Delivery</label>
<select id="deliveryType" name="<%=DELIVERY_TYPE %>" validate="Type Of Delivery,string,yes"  tabindex="10">
	<option value="Normal">Normal</option>
	<option value="Assisted">Assisted</option>
	<option value="C. S. Baby">C. S. Baby</option>
	<option value="III">III</option>
</select>
<label class="bodytextReg">Condition of Baby</label> 
<input id="babyStatus" type="text" name="<%=BABY_STATUS %>" value="" title="Condition of Baby" class="textbox_size20" validate="Condition of Baby,metachar,no" MAXLENGTH="15"  tabindex="11"/> 
<label class="bodytextReg"><span>*</span> Cry</label>
<select id="cry" name="<%=CRY %>" validate="Cry,metachar,yes"  tabindex="12">
	<option value="Immediate">Immediate</option>
	<option value="Deliyed">Deliyed</option>
</select>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span> Color</label>
<select id="babyColor" name="<%=BABY_COLOR%>" validate="Color,metachar,yes"  tabindex="13">
	<option value="Normal">Normal</option>
	<option value="Cyanosis & Yellow">Cyanosis & Yellow</option>
</select>
<label class="bodytextReg"><span>*</span>Resuscitatino</label>
<select id="resuscitatino" name="<%=RESUSCITATINO%>" validate="Resuscitatino,metachar,yes"  tabindex="14">
	<option value="Needed">Needed</option>
	<option value="Not needed">Not needed</option>
</select>
<label class="bodytextReg"><span>*</span> Any cong. Abnormality</label>
<select id="anyCongAbnormality" name="<%=ANY_CONG_ABNORMALITY%>" validate="Any cong. Abnormality,metachar,yes"  tabindex="15">
	<option value="Present">Present</option>
	<option value="Not Present">Not Present</option>
</select>
<div class="clear"></div>

<label class="bodytextReg"><span>*</span> Apgar score at birth</label>
 <%if(apgarScore!=null){ %> 
<input id="apgarScoreAtBirth" type="text"  name="<%=APGAR_ACORE_AT_BIRTH %>" value="<%=apgarScore.intValue() %>" title="Apgar score at birth" class="textbox_size20" onkeypress="return isNumber(event);" validate="Apgar score at birth,float,yes" MAXLENGTH="2"  tabindex="16"/>

<%}else{ %>
<input id="apgarScoreAtBirth" onkeypress="return isNumber(event)" type="text" name="<%=APGAR_ACORE_AT_BIRTH %>" value="" title="Apgar score at birth" class="textbox_size20" validate="Apgar score at birth,float,yes" MAXLENGTH="2"  tabindex="16"/>
<%} %>
<label class="bodytextReg"><span>*</span> Birth Weight</label> 
<input id="birthWeight"	type="text" name="<%=BIRTH_WEIGHT %>" value="" placeholder="00.00" onKeyUp="mask(this.value,this,'2','.');"	 title="Birth Weight" class="textbox_size20"	validate="Birth Weight,string,no" MAXLENGTH="5"  tabindex="17"/>
<label class="bodytextReg"><span>*</span> Final Diagnosis</label>
<select id="finalDiagnosis" name="<%=FINAL_DIAGNOSIS%>" validate="Final Diagnosis,metachar,yes"  tabindex="18">
	<option value="Normal baby">Normal baby</option>
	<option value="Premature">Premature</option>
	<option value="III">III</option>
</select>
<div class="clear"></div>
<label class="bodytextReg"> Date of Discharge</label>
<input type="text" class="calDate" id="dischargeDate" name="<%=DISCHARGE_DATE %>" value="" class="textbox_date" style="width: 120px;" validate="Date of Discharge,date,no" readonly="readonly"  tabindex="19"/> 
<img	id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DISCHARGE_DATE%>,event);" />
<label class="bodytextReg"><span>*</span> Condition at Discharge</label>
<select id="conditionAtDischarge" name="<%=CONDITION_AT_DISCHARGE%>" validate="Condition at Discharge,metachar,yes"  tabindex="20">
	<option value="Healthy">Healthy</option>
	<option value="LAMA">LAMA</option>
	<option value="Died">Died</option>
</select>

<div class="clear"></div>
<input type="button" name="Submit" value="Submit" class="button"	onClick="submitForm('fatalDocumentPanchnamaReport','ipd?method=submitBirthCertificate');"  tabindex="21"/>
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r"  tabindex="22"/>
<div class="clear"></div>

<%} %>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" id="regDateId"
	name="<%=REG_DATE %>" value="<%=regDate %>" class="readonly" validate="Date Of Registration,date,no"  tabindex="21"/>
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>"  id="changeddate2" value="<%=date1%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	

