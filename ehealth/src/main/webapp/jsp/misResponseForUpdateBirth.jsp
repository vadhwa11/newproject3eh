<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Birth Certificate.
 * @author  Mukesh Narayan Singh
 * Create Date: 24 Sep,2010
 * Revision Date:
 * Revision By:
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Birthdeathreg"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>


<%

			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date1 = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			List<Birthdeathreg> birthList = new ArrayList<Birthdeathreg>();
			if(map.get("birthList")!=null){
				   birthList=(List)map.get("birthList");
			}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			%>
<div id="test">
<%
			String birthTime ="";
			String serviceNo ="";
			String hinNo ="";
			String gender="";
			String dob ="";
			int noOfCopies =0;
			int amount =0;
			String regDate="";
			int empId =0;
			int bdId =0;
			int inpatientId =0;
			Birthdeathreg birthdeathreg =null;
			String patientName="";
			String babyAddress="";
	     	if (birthList!=null && birthList.size() > 0 ) {
	     		 birthdeathreg = (Birthdeathreg)birthList.get(0);
	     		patientName=birthdeathreg.getName();
	     		babyAddress=birthdeathreg.getAddressPermanent();
	     	if(birthdeathreg.getHin() !=null)

	     	{	//serviceNo =birthdeathreg.getHin().getServiceNo();
	     		bdId =birthdeathreg.getId();
	     		hinNo =birthdeathreg.getHin().getHinNo();
	     		gender = birthdeathreg.getAdministrativeSex().getAdministrativeSexName();
	     		if(birthdeathreg.getDob() != null && !birthdeathreg.getDob().equals(""))
	     		dob =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDob());
	     		if(birthdeathreg.getNoOfCopies() !=null && !birthdeathreg.getNoOfCopies().equals(""))
	     		noOfCopies =Integer.parseInt(""+birthdeathreg.getNoOfCopies());
	     		if(birthdeathreg.getAmount() !=null && !birthdeathreg.getAmount().equals(""))
	     		amount =Integer.parseInt(""+birthdeathreg.getAmount());
	     	}
	     	if(birthdeathreg.getDor() != null && !birthdeathreg.getDor().equals(""))
	     		regDate =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDor());

	     	if(birthdeathreg.getInpatient() !=null)
	     		inpatientId =birthdeathreg.getInpatient().getId();
	     	if(birthdeathreg.getTime() !=null)
	     		birthTime =birthdeathreg.getTime();
			%>

<div class="clear"></div>

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
<div id="birthDiv"><label class="bodytextReg"><span>*</span>Patient:</label> <input id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=patientName %>" title="Patient" class="textbox_size20"
	validate="Patient,string,yes" MAXLENGTH="15" /> <input
	type="hidden" id="frwSlno" name="<%=HIN_ID%>"
	value="<%=birthdeathreg.getHin().getId()%>" class="textbox_date"
	MAXLENGTH="30" /> <input type="hidden" id="frwSlno" name="<%=SEX_ID%>"
	value="<%=birthdeathreg.getAdministrativeSex().getId()%>"
	class="textbox_date" MAXLENGTH="30" /> <label class="bodytextReg"><span>*</span>Gender:</label>
<%if(birthdeathreg.getAdministrativeSex()!= null){ %>
	<input type="test" id="genderId" name="genderId"
	value="<%=birthdeathreg.getAdministrativeSex().getAdministrativeSexName()%>" readonly="readonly"/>
 <%}else{ %>
<td width="8%"><input type="text" name="<%=SEX%>" size="2" value="" /></td>
<%} %>
<label>Address:</label>
<input id="address" type="text" name="<%=ADDRESS %>" value="<%=babyAddress%>" title="Address"
	class="textbox_date" validate="Address,string,yes" MAXLENGTH="500"/>

<label><span>*</span>Antenatal Checkup:</label> <select id="antenatalCheckup"
	name="<%=ANTENATAL_CHECKUP %>">
	<option value="Done">Done</option>
	<option value="Not Done">Not Done</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getAntenatalCheckup()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=ANTENATAL_CHECKUP%>.value = '<%=birthdeathreg.getAntenatalCheckup()%>'
<%
}
%>
</script>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span>Date of <%=prop.getProperty("com.jkt.hms.ipd") %> of Mother:</label>
<input type="text" class="calDate" id="motherIpdDate"
	name="<%=MOTHER_IPD_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDateOfAdmOfMother())  %>"
	class="textbox_date" style="width: 120px;"
	validate="Date of <%=prop.getProperty("com.jkt.hms.ipd") %> of Mother,date,yes" readonly="readonly" /> <img
	id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=MOTHER_IPD_DATE%>,event);" />


 <label class="bodytextReg"><span>*</span>Baby Delivery Date:</label>
 <%if(birthdeathreg.getDob() != null){ %>
<input type="text" class="calDate" id="birthDateId"
	name="<%=DATE_OF_BIRTH %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDob()) %>"
	class="textbox_date" style="width: 120px;"
	validate="Baby Delivery Date,date,yes" readonly="readonly" /> <img
	id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event);" />


<%}else{ %>
<td width="8%"><input type="text" id="birthDateId"
	name="<%=DATE_OF_BIRTH %>" size="2" value=""
	validate="Baby Delivery Date,date,yes" readonly="readonly" /></td>
<img id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_BIRTH%>,event);" />
<%} %> </a>
<label class="bodytextReg"><span>*</span>Baby Delivery Time:</label>
<input type="text" class="calDate" id="timeOfBirth"
	name="<%=TIME_OF_BIRTH %>"
	value="<%=birthdeathreg.getBabyDeliveryTime() %>" class="textbox_date" style="width: 114px;" validate="Baby Delivery Time,string,yes" maxlength="10" /><font size="1" color="blue">(HH:MM:SS)</font>
<%
%>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span>Type Of Delivery:</label>
<select id="deliveryType" name="<%=DELIVERY_TYPE %>" validate="Type Of Delivery,string,yes">
	<option value="Normal">Normal</option>
	<option value="Assisted">Assisted</option>
	<option value="C. S. Baby">C. S. Baby</option>
	<option value="III">III</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getDeliveryType()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=DELIVERY_TYPE%>.value = '<%=birthdeathreg.getDeliveryType()%>'
<%
}
%>
</script>
<label class="bodytextReg">Condition of Baby:</label> <input id="babyStatus"
	type="text" name="<%=BABY_STATUS %>" value=""
	title="Condition of Baby" class="textbox_size20"
	validate="Condition of Baby,string,no" MAXLENGTH="15" />
	<label class="bodytextReg"><span>*</span>Cry:</label>
<select id="cry" name="<%=CRY %>" validate="Cry,string,yes">
	<option value="Immediate">Immediate</option>
	<option value="Deliyed">Deliyed</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getCry()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=CRY%>.value = '<%=birthdeathreg.getCry()%>'
<%
}
%>
</script>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span>Color:</label>
<select id="babyColor" name="<%=BABY_COLOR%>" validate="Color,string,yes">
	<option value="Normal">Normal</option>
	<option value="Cyanosis & Yellow">Cyanosis & Yellow</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getColor()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=BABY_COLOR%>.value = '<%=birthdeathreg.getColor()%>'
<%
}
%>
</script>
<label class="bodytextReg"><span>*</span>Resuscitatino:</label>
<select id="resuscitatino" name="<%=RESUSCITATINO%>" validate="Resuscitatino,string,yes">
	<option value="Needed">Needed</option>
	<option value="Not needed">Not needed</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getResuscitatino()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=RESUSCITATINO%>.value = '<%=birthdeathreg.getResuscitatino()%>'
<%
}
%>
</script>
<label class="bodytextReg"><span>*</span>Any cong. Abnormality:</label>
<select id="anyCongAbnormality" name="<%=ANY_CONG_ABNORMALITY%>" validate="Any cong. Abnormality,string,yes">
	<option value="Present">Present</option>
	<option value="Not Present">Not Present</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getAnyCongAbnormality()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=ANY_CONG_ABNORMALITY%>.value = '<%=birthdeathreg.getAnyCongAbnormality()%>'
<%
}
%>
</script>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span>Apgar score at birth:</label> <input id="apgarScoreAtBirth"
	type="text" name="<%=APGAR_ACORE_AT_BIRTH %>" value="<%=birthdeathreg.getApgarScoreAtBirth() %>"
	title="Apgar score at birth" class="textbox_size20"
	validate="Apgar score at birth,string,yes" MAXLENGTH="49" />
	<label class="bodytextReg">Birth Weight:</label> <input id="birthWeight"
	type="text" name="<%=BIRTH_WEIGHT %>" value="<%=birthdeathreg.getBirthWeight() %>"
	title="Birth Weight" class="textbox_size20"
	validate="Birth Weight,num,yes" MAXLENGTH="10" />
<label class="bodytextReg"><span>*</span>Final Diagnosis:</label>
<select id="finalDiagnosis" name="<%=FINAL_DIAGNOSIS%>" validate="Final Diagnosis,string,yes">
	<option value="Normal baby">Normal baby</option>
	<option value="Premature">Premature</option>
	<option value="III">III</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getFinalDiagnosis() != null){
String finalDiagnosis = birthdeathreg.getFinalDiagnosis() ;
%>
document.fatalDocumentPanchnamaReport.<%=FINAL_DIAGNOSIS%>.value = '<%=finalDiagnosis%>';
<%
}
String dischargeDate="";
if(birthdeathreg.getDischargeDate()!=null){
	dischargeDate=HMSUtil.convertDateToStringTypeDateOnly(birthdeathreg.getDischargeDate());
}
%>
</script>
<div class="clear"></div>
<label class="bodytextReg"><span>*</span>Date of Discharge:</label>
<input type="text" class="calDate" id="dischargeDate"
	name="<%=DISCHARGE_DATE %>"
	value="<%=dischargeDate%>"
	class="textbox_date" style="width: 120px;"
	validate="Date of Discharge,date,yes" readonly="readonly" /> <img
	id="doiCardImgId" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('',document.fatalDocumentPanchnamaReport.<%=DISCHARGE_DATE%>,event);" />
<label class="bodytextReg"><span>*</span>Condition at Discharge:</label>
<select id="conditionAtDischarge" name="<%=CONDITION_AT_DISCHARGE%>" validate="Condition at Discharge,string,yes">
	<option value="Healthy">Healthy</option>
	<option value="LAMA">LAMA</option>
	<option value="Died">Died</option>
</select>
<script type="text/javascript">
<%  if(birthdeathreg.getConditionAtdischarge()!= null){
%>
document.fatalDocumentPanchnamaReport.<%=CONDITION_AT_DISCHARGE%>.value = '<%=birthdeathreg.getConditionAtdischarge()%>';
<%
}%>
</script>
<div class="clear"></div>


<input type="hidden" name="<%=BIRTHDEATHID%>" value="<%=bdId%>" /> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date1%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="ipId" value="<%=inpatientId%>" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="if(checkValidation()){submitForm('fatalDocumentPanchnamaReport','mis?method=submitUpdateBirthCertificate');}" />


<%}else{%>

<div class="clear"></div>
<h4><span>No Records found</span></h4>
<%}%>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
