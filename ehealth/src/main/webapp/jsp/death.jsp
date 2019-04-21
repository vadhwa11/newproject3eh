<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
    Map<String, Object> map = new HashMap<String, Object>();
	String regNo="";
	int serNo =0;
	String motherName="";
	String fatherName="";
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

	try{
		if(map.get("inpatientList")!=null)
		{
			inpatientList=(List<Inpatient>)map.get("inpatientList");
		}
		if(map.get("fatherName")!=null)
		{
			fatherName=""+map.get("fatherName");
		}
		if(map.get("motherName")!=null)
		{
			motherName=""+map.get("motherName");
		}
		if(map.get("employeeList")!=null)
		{
			employeeList=(List)map.get("employeeList");
		}

		if(map.get("regNo")!=null)
		{
			regNo=(String)map.get("regNo");
		}
		if(map.get("serNo")!=null)
		{
			serNo=Integer.parseInt(""+map.get("serNo")) ;
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Inpatient inpatient = new Inpatient();
	 if(inpatientList != null && inpatientList.size()>0)
	   {
			 inpatient = inpatientList.get(0);
		 }

		   String patientName="";
		   if(inpatient.getHin() !=null){

			   patientName =inpatient.getHin().getPFirstName();
			   if(inpatient.getHin().getPMiddleName()!=null){
				   patientName+=inpatient.getHin().getPMiddleName();
			   }
			   if(inpatient.getHin().getPLastName()!=null){
				   patientName+=inpatient.getHin().getPLastName();
			   }
		   }
			   String age="";
			   if(inpatient.getAge()!=null){
				   age=inpatient.getAge();
			   }
		   String wardName="";
		   if(inpatient.getAdWard()!=null){
			   wardName=inpatient.getAdWard().getDepartmentName();
		   }

 %>
<div id="deathDiv">
<label><span>*</span> Patient Name</label> 
<input id="patientId" type="text" name="<%=PATIENT_NAME %>" value="<%=patientName %>" title="Patient Name" class="textbox_date"	validate="Patient Name,metachar,yes" MAXLENGTH="50" tabindex="3"/> 
<input	type="hidden" id="hin_Id" name="<%=HIN_ID%>" value="<%=inpatient.getHin().getId()%>" class="textbox_date" MAXLENGTH="30" validate="hinId,int,no"/> 
<input type="hidden" id="frwSlno" name="<%=SEX_ID%>" value="<%=inpatient.getHin().getSex().getId()%>" class="textbox_date"MAXLENGTH="30"  validate="genderId,int,no"/> 
<input type="hidden" name="serNo" value="<%=serNo%>" class="textbox_date" MAXLENGTH="30" validate="serNo,metachar,no"/> 
<label>Gender</label> 
<%if(inpatient.getHin().getSex() != null){ %>
<input id="genderId" type="text" name="<%=SEX%>" value="<%=inpatient.getHin().getSex().getAdministrativeSexName() %>" title="Gender" class="textbox_date" validate="Gender,metachar,no" MAXLENGTH="15" readonly="readonly" tabindex="4"/> <%}else{ %>
<td width="8%"><input type="text" name="<%=SEX%>"
	class="medcaption" size="2" value="" readonly="readonly"  tabindex="4"/></td>
<%} %>
<label> Ward Name</label> 
<input id="wardName" type="text" name="<%=WARD_NAME %>" value="<%=wardName%>" title="Ward Name" class="textbox_date" validate="Ward Name,metachar,no" MAXLENGTH="15" readonly="readonly"  tabindex="5"/>
<div class="clear"></div>
<label> Date Of Death</label> 
<input type="text" class="date"	id="deathDateId" name="<%=DATE_OF_DEATH %>" value="" class="textbox_date" readonly="readonly" validate="DDate Of Death,date,no"  tabindex="6"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.fatalDocumentPanchnamaReport.<%=DATE_OF_DEATH%>,event)" />
<label style="padding-left: 26px;"><span>*</span> Time Of Death</label> 
<input id="time" type="text" name="<%=TIME %>" value="" title="time" class="small" validate="Time,metachar,yes" MAXLENGTH="15" onblur="checkTime('fatalDocumentPanchnamaReport','<%=TIME%>')"  tabindex="7"/>	
<select	id="timeAm" name="<%=TIME_AM %>" class="smallest"  tabindex="8">
	<option value="AM">AM</option>
	<option value="PM">PM</option>
</select>
<label style="margin-left: 77px;"><span style="">*</span> Age</label> 
<input id="age"	type="text" name="<%=AGE%>" value="<%=age%>" title="Age" validate="Age,metachar,yes" MAXLENGTH="15"  tabindex="9"	/>
<div class="clear"></div>
<label><span>*</span> Immediate Cause</label>
	 <textarea name="<%=IMMEDIATE_CAUSE %>" id="<%=IMMEDIATE_CAUSE%>" cols="20" rows="2" tabindex="10" validate="Immediate cause,metachar,yes" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" onblur="fillNokAddr();"></textarea>
<label style="padding-left: 26px;"><span>*</span> Antecedent Cause</label>
	 <textarea name="<%=ANTECEDENT_CAUSE %>" id="<%=ANTECEDENT_CAUSE%>" cols="20" rows="2" tabindex="11" validate="Antecedent cause,metachar,yes"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	onblur="fillNokAddr();" ></textarea>
<label style="padding-left: 26px;"><span>*</span> Other Significant Condition</label>
	 <textarea name="<%=OTHER_SIGNIFICANT_CONDITION %>" id="<%=OTHER_SIGNIFICANT_CONDITION%>" cols="20" rows="2" tabindex="12" validate="Other significant condition,metachar,yes" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" onblur="fillNokAddr();"></textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> Manner Of Death</label>
	<select	id="<%=MANNER_OF_DEATH%>" name="<%=MANNER_OF_DEATH %>" validate="Manner of death,metachar,yes"  tabindex="13">
	<option value="Natural">Natural</option>
	<option value="Accident">Accident</option>
	<option value="Suicide">Suicide</option>
	<option value="Homicide">Homicide</option>
	<option value="Pending">Pending</option>
</select>

<label><span>*</span> How did the injury occur?</label>
<input id="<%=INJURY_OCCUR%>" type="text" name="<%=INJURY_OCCUR %>"	value="" title="How did the injury occur" class="textbox_date" validate="How did the injury occur,metachar,yes" MAXLENGTH="99"  tabindex="14"/>
<div class="clear"></div>
<label><span>*</span> If deceased was a female, was pregnancy the death associated with?</label>
<select id="<%=DECEASED_FEMALE_PREGNANCY_DEATH%>" name="<%=DECEASED_FEMALE_PREGNANCY_DEATH %>" validate="If deceased was a female was pregnancy the death associated with,metachar,yes"  tabindex="15">
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<label><span>*</span> If Yes, was there a delivery</label>
<select	id="<%=DECEASED_FEMALE_PREGNANCY_DELIVERY%>" name="<%=DECEASED_FEMALE_PREGNANCY_DELIVERY %>" validate="If Yes was there a delivery,metachar,yes"  tabindex="16">
<option value="Y">Yes</option>
<option value="N">No</option>
</select>
<div class="clear"></div><input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
