<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Birth Certificate.
 * @author  Dipali
 * Create Date: 23rd April,2008
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
			   List<Birthdeathreg> deathList = new ArrayList<Birthdeathreg>();
			   List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			   if(map.get("employeeList") !=null){
				   employeeList=(List<MasEmployee>)map.get("employeeList");
			   }
			   try{
				   deathList=(List)map.get("deathList");

				}catch(Exception e){
					e.printStackTrace();
				}
				String serviceNo ="";
				String hinNo ="";
				String adNo="";
				String ptName ="";
				String gender="";
				String dod ="";
				String mName ="";
				String fName="";
				int noOfCopies =0;
				int amount =0;
				String regDate="";
				int empId =0;
				String address ="";
				String permanentAddress ="";
				Birthdeathreg birthdeathreg =null;
				String doi ="";
				String remarks="";
				String deathTime ="";
				String deathTimeAM ="";
				int birthDeathId =0;
				int inpatientId =0;
				String wardName="";
				String age="";
				String immediateCause="";
		     	String antecedentCause="";
		     	String otherSignificantCondition="";
		     	String deliveryType="";
		     	String injuryOccur="";
		     	String deceasedFemalePregnancyDelivery="";
		     	String deceasedFemalePregnancyDeath="";
		     	if (deathList!=null && deathList.size() > 0 ) {
		     		 birthdeathreg = (Birthdeathreg)deathList.get(0);
		     	if(birthdeathreg.getHin() !=null)
		     		{
		     		birthDeathId =birthdeathreg.getId();
		     		serviceNo =birthdeathreg.getHin().getServiceNo();
		     		hinNo =birthdeathreg.getHin().getHinNo();
		     		if(birthdeathreg.getName() !=null)
		     		ptName =birthdeathreg.getName();
		     		if(birthdeathreg.getMname() !=null)
		     		mName =birthdeathreg.getMname();
		     		if(birthdeathreg.getFname()  !=null)
		     		fName =birthdeathreg.getFname();
		     		if(birthdeathreg.getAddressDeath() !=null)
		     		address =birthdeathreg.getAddressDeath();
		     		if(birthdeathreg.getRemarks() !=null)
		     		remarks =birthdeathreg.getRemarks();
		     		if(birthdeathreg.getAddressPermanent() !=null)
		     		permanentAddress =birthdeathreg.getAddressPermanent();
		     		if( birthdeathreg.getHin().getSex() !=null)
		     		gender = birthdeathreg.getHin().getSex().getAdministrativeSexName();
		     		if(birthdeathreg.getDod() != null && !birthdeathreg.getDod().equals(""))
		     		dod =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDod());
		     		if(birthdeathreg.getNoOfCopies() !=null && !birthdeathreg.getNoOfCopies().equals(""))
		     		noOfCopies =Integer.parseInt(""+birthdeathreg.getNoOfCopies());
		     		if(birthdeathreg.getAmount() !=null && !birthdeathreg.getAmount().equals(""))
		     		amount =Integer.parseInt(""+birthdeathreg.getAmount());

		     		if(birthdeathreg.getDateOfIssue() != null && !birthdeathreg.getDateOfIssue().equals(""))
		     			doi =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDateOfIssue());
		     	}
		     	if(birthdeathreg.getDor() != null && !birthdeathreg.getDor().equals(""))
		     		regDate =HMSUtil.changeDateToddMMyyyy(birthdeathreg.getDor());
		     	if(birthdeathreg.getEmp() !=null)
		     		empId =birthdeathreg.getEmp().getId();
		     	if(birthdeathreg.getInpatient() !=null)
		     		adNo =birthdeathreg.getInpatient().getAdNo();
		     	if(birthdeathreg.getInpatient() !=null){
		     		inpatientId =birthdeathreg.getInpatient().getId();

		 		   if(birthdeathreg.getInpatient().getAdWard()!=null){
		 			   wardName=birthdeathreg.getInpatient().getAdWard().getDepartmentName();
		 		   }

				   if(birthdeathreg.getInpatient().getAge()!=null){
					   age=birthdeathreg.getInpatient().getAge();
				   }

		     	}
		     	if(birthdeathreg.getTime() !=null){
		     		deathTime =birthdeathreg.getBabyDeliveryTime();
		     		try{
		     		String deathTimeTemp[]=deathTime.split(" ");
		     		if(deathTimeTemp[0]!=null){
			     		deathTime=deathTimeTemp[0];
		     		}
		     		if(deathTimeTemp[1]!=null){
			     		deathTimeAM=deathTimeTemp[1];
		     		}
		     		}catch(Exception e){
		     			e.printStackTrace();
		     		}
		     	}

		     	if(birthdeathreg.getImmediateCause()!=null){
		     		immediateCause=birthdeathreg.getImmediateCause();
		     	}
		     	if(birthdeathreg.getAntecedentCause()!=null){
		     		antecedentCause=birthdeathreg.getAntecedentCause();
		     	}
		     	if(birthdeathreg.getOtherSignificantCondition()!=null){
		     		otherSignificantCondition=birthdeathreg.getOtherSignificantCondition();
		     	}
		     	if(birthdeathreg.getDeliveryType()!=null){
		     		deliveryType=birthdeathreg.getDeliveryType();
		     	}
		     	if(birthdeathreg.getInjuryOccur()!=null){
		     		injuryOccur=birthdeathreg.getInjuryOccur();
		     	}
		     	if(birthdeathreg.getDeceasedFemalePregnancyDelivery()!=null){
		     		deceasedFemalePregnancyDelivery=birthdeathreg.getDeceasedFemalePregnancyDelivery();
		     	}
		     	if(birthdeathreg.getDeceasedFemalePregnancyDeath()!=null){
		     		deceasedFemalePregnancyDeath=birthdeathreg.getDeceasedFemalePregnancyDeath();
		     	}
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
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
<%-- <!-- <label class="bodytextB"><span>*</span> Service No.:</label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>"
	value="<%=serviceNo %>" readonly="readonly" class="readOnly"
	MAXLENGTH="30" /> --> --%>
<div id="hinDiv"><label class="bodytextB"><span>*</span>
<%=prop.getProperty("com.jkt.hms.registration_no") %>:</label>
<input type="text" name="<%=HIN_NO%>" value="<%=hinNo %>"
	readonly="readonly" class="readOnly" MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,metachar,yes" />
</div>
<label class="bodytextB"><span>*</span> <%=prop.getProperty("com.jkt.hms.ipd_no") %>:</label>
<input type="text" id="<%=INPATIENT_ID%>" name="<%=INPATIENT_ID%>"
	readonly="readonly" value="<%=adNo %>" class="readOnly" MAXLENGTH="30"
	validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,metachar,yes" />
<div class="clear"></div>
<div id="deathDiv"><label class="bodytextB">Patient Name:</label>
<input id="patientId" type="text" name="<%=PATIENT_NAME %>"
	value="<%=ptName %>" title="Patient Name"
	validate="Patient Name,string ,no" MAXLENGTH="50" />

	 <label
	class="bodytextB">Gender:</label> <input id="gender" type="text"
	name="<%=SEX %>" value="<%=gender %>" title="Gender" class="readOnly"
	readonly="readonly" validate="Gender,string,no" MAXLENGTH="15" />
	<label>Ward Name:</label> <input id="wardName"
	type="text" name="<%=WARD_NAME %>" value="<%=wardName%>" title="Ward Name"
	class="textbox_date" validate="Ward Name,metachar,no" MAXLENGTH="15" readonly="readonly"  tabindex="5"/>

	<div class="clear"></div>
	<label
	class="bodytextB">Date of Death:</label> <input type="text"
	class="date" id="deathDateId" name="<%=DATE_OF_DEATH %>"
	value="<%=dod%>" readonly="readonly" validate="Date Of Death ,date,no" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_DEATH%>,event)" />


<label class="bodytextB">Time of Birth:</label> <input id="<%=TIME %>"
	type="text" name="<%=TIME %>" value="<%=deathTime %>"
	validate="Time,string,no" MAXLENGTH="15" class="small"
	onblur="checkTime('fatalDocumentPanchnamaReport','<%=TIME%>')" />
	<select
	id="timeAm" name="<%=TIME_AM %>" class="smallest"  tabindex="8">
	<option value="AM">AM</option>
	<option value="PM">PM</option>
</select>
<script type="text/javascript">
<%  if(deathTimeAM!= ""){
%>
document.fatalDocumentPanchnamaReport.<%=TIME_AM%>.value = '<%=deathTimeAM%>'
<%
}
%>
</script>
<label><span>*</span>Age:</label> <input id="age"
	type="text" name="<%=AGE%>" value="<%=age%>" title="Age"
	validate="Age,string,yes" MAXLENGTH="15"  tabindex="9"
	/>
	<script type="text/javascript">
document.fatalDocumentPanchnamaReport.<%=AGE%>.value = '<%=age%>'
</script>
<div class="clear"></div>
<label><span>*</span>Immediate Cause</label>
	 <textarea name="<%=IMMEDIATE_CAUSE %>" id="<%=IMMEDIATE_CAUSE%>"
	cols="20" rows="2" tabindex="10" validate="immediateCause,string,yes"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	onblur="fillNokAddr();"><%=immediateCause%></textarea>
<label><span>*</span>Antecedent Cause</label>
	 <textarea name="<%=ANTECEDENT_CAUSE %>" id="<%=ANTECEDENT_CAUSE%>"
	cols="20" rows="2" tabindex="11" validate="antecedentCause,string,yes"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	onblur="fillNokAddr();" ><%=antecedentCause%></textarea>
	<label><span>*</span>Other Significant Condition</label>
	 <textarea name="<%=OTHER_SIGNIFICANT_CONDITION %>" id="<%=OTHER_SIGNIFICANT_CONDITION%>"
	cols="20" rows="2" tabindex="12" validate="otherSignificantCondition,string,yes"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	onblur="fillNokAddr();"><%=otherSignificantCondition%></textarea>
	<div class="clear"></div>
	<label><span>*</span>Manner Of Death:</label>
	<select	id="<%=MANNER_OF_DEATH%>" name="<%=MANNER_OF_DEATH %>" validate="mannerOfDeath,string,yes"  tabindex="13">
	<option value="Natural">Natural</option>
	<option value="Accident">Accident</option>
	<option value="Suicide">Suicide</option>
	<option value="Homicide">Homicide</option>
	<option value="Pending">Pending</option>
</select>
<script type="text/javascript">
document.fatalDocumentPanchnamaReport.<%=MANNER_OF_DEATH%>.value = '<%=deliveryType%>'
</script>
<label><span>*</span>How did the injury occur?:</label>
	 <input id="<%=INJURY_OCCUR%>" type="text" name="<%=INJURY_OCCUR %>"
	value="" title="How did the injury occur" class="textbox_date"
	validate="injuryOccur,string,yes" MAXLENGTH="99"  tabindex="14"/>
	<script type="text/javascript">
document.fatalDocumentPanchnamaReport.<%=INJURY_OCCUR%>.value = '<%=injuryOccur%>'
</script>
<div class="clear"></div>
	 <label><span>*</span>If deceased was a female, was pregnancy the death associated with?:</label>
	 <select id="<%=DECEASED_FEMALE_PREGNANCY_DEATH%>" name="<%=DECEASED_FEMALE_PREGNANCY_DEATH %>" validate="deceasedFemalePregnancyDeath,string,yes"  tabindex="15">
	<option value="Y">Yes</option>
	<option value="N">No</option>
</select>
<script type="text/javascript">
document.fatalDocumentPanchnamaReport.<%=DECEASED_FEMALE_PREGNANCY_DEATH%>.value = '<%=deceasedFemalePregnancyDeath%>'
</script>
	 <label><span>*</span>If Yes, was there a delivery:</label>
	<select	id="<%=DECEASED_FEMALE_PREGNANCY_DELIVERY%>" name="<%=DECEASED_FEMALE_PREGNANCY_DELIVERY %>" validate="deceasedFemalePregnancyDelivery,string,yes"  tabindex="16">
	<option value="Y">Yes</option>
	<option value="N">No</option>
</select>
<script type="text/javascript">
document.fatalDocumentPanchnamaReport.<%=DECEASED_FEMALE_PREGNANCY_DELIVERY%>.value = '<%=deceasedFemalePregnancyDelivery%>'
</script>
<%-- <!--
<label
	class="bodytextB">Mother's Name:</label> <input id="motherId"
	type="text" name="<%=MOTHER_NAME %>" value="<%=mName %>"
	title="Mother Name" validate="Mother Name,String,yes" MAXLENGTH="50" />

<label class="bodytextB">Father's Name:</label> <input id="fatherId"
	type="text" name="<%=FATHER_NAME %>" value="<%=fName %>"
	title="Father Name" validate="Father Name,String,yes" MAXLENGTH="50" />
<div class="clear"></div>
<label class="bodytextB">Address of the deceased at the time of
death:</label> <textarea name="<%=ADDRESS1%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="txtarea"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=address %></textarea>

<label class="bodytextB">Permanent address of deceased:</label> <textarea
	name="<%=ADDRESS2%>" cols="20" rows="2" tabindex="2"
	validate="Address,string,no" class="txtarea"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"><%=permanentAddress %></textarea>
<label class="bodytextB">Date Of Registration:</label> <input
	type="text" class="date" id="regDateId" name="<%=REG_DATE %>"
	value="<%=regDate %>" readonly="readonly"
	validate="Date Of Registration,date,no" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=REG_DATE%>,event)" />
<div class="clear"></div>

<label class="bodytextB">Date of Issuing:</label> <input type="text"
	class="date" id="regDateId" name="<%=ISSUE_DATE %>" value="<%=doi%>"
	readonly="readonly" validate="Date Of Registration,date,no" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=ISSUE_DATE%>,event)" />
<label class="bodytextB">No of Copies:</label> <input id="fatherId"
	type="text" name="<%=NO_OF_COPIES %>" value="<%=noOfCopies%>"
	validate="No of Copies,num,no" MAXLENGTH="15" /> <label
	class="bodytextB">Amount:</label> <input id="fatherId" type="text"
	name="<%=AMOUNT %>" value="<%=amount%>" validate="No of Copies,num,no"
	MAXLENGTH="15" />
<div class="clear"></div>
<label class="bodytextB">Remarks:</label> <input id="fatherId"
	type="text" name="<%=REMARKS %>" value="<%=remarks %>" title="Remarks"
	MAXLENGTH="15" />  <label class="bodytextB">Authenticated
Employee:</label> <select id="employeeId" name="<%=EMPLOYEE_ID %>"
	style="width: 120px">
	<option value="0">Select</option>

	<%
							for (MasEmployee employee : employeeList) {
								if(employee.getId() ==empId){
						%>
	<option value="<%=employee.getId()%>" selected="selected"><%=employee.getFirstName()%>
	<%=employee.getMiddleName()%> <%=employee.getLastName()%></option>
	<%}else{ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()%>
	<%=employee.getMiddleName()%> <%=employee.getLastName()%></option>
	<%} %>
	<%
						}
					%>
</select>
 --> --%>
<div class="clear"></div>
<input type="hidden" name="<%=BIRTHDEATHID %>"
	value="<%=birthDeathId %>" validate="birthDeathId,int,no"/>
<input type="button" name="Submit" value="Submit" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=submitUpdateDeathCertificate');" />
<input type="hidden" name="ipId" value="<%=inpatientId%>" validate="ipdId,int,no"/></div>
<%}else{ %>
<div class="clear"></div>
<h4><span>No Records found</span></h4>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
