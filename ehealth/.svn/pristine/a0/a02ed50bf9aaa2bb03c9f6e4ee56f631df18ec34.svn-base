<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ambulanceRunRegister.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 17.03.2011    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.masters.business.AmbulanceRegister"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	</script>
<form name="ambulanceRunRegister" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<AmbulanceRegister> ambulanceRegisterList =new ArrayList<AmbulanceRegister>();		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
  		
		if(map.get("ambulanceRegisterList") != null){
			ambulanceRegisterList = (List<AmbulanceRegister>)map.get("ambulanceRegisterList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>



<h4><%=message %></h4>
<div class="titleBg"><h2>Ambulance Request</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<%if(ambulanceRegisterList.size()>0)
	{%>
<table border="1" cellpadding="0" cellspacing="0" style="padding: 0;">
<tr>
<th>&nbsp;</th>
<th>UHID</th>
<th>Patient Name</th>
<th>IP No.</th>
<th>Doctor Name</th>
<th>Status</th>
</tr>
<%
int i=0;
for(AmbulanceRegister ambulanceRegister:ambulanceRegisterList){
	
	i++;
	String patientName=ambulanceRegister.getHin().getPFirstName();
	if(ambulanceRegister.getHin().getPMiddleName()!=null){
		patientName += " "+ambulanceRegister.getHin().getPMiddleName();
	}
	if(ambulanceRegister.getHin().getPLastName()!=null){
		patientName += " "+ambulanceRegister.getHin().getPLastName();
	}
	
	
	String doctorName =ambulanceRegister.getDoctor().getFirstName();
	if(ambulanceRegister.getDoctor().getMiddleName()!=null)
	{
		doctorName +=" "+ambulanceRegister.getDoctor().getMiddleName();
	}
	
	if(ambulanceRegister.getDoctor().getLastName()!=null)
	{
		doctorName+=" "+ambulanceRegister.getDoctor().getLastName();
	}
	%>
<tr>
<td>
<%if(ambulanceRegister.getStatus()!=null && ambulanceRegister.getStatus().equals("P")||ambulanceRegister.getStatus()!=null && ambulanceRegister.getStatus().equals("F")){ %>
<input type="radio" name="ambulanceId" id="ambulanceId<%=i %>" value="<%=ambulanceRegister.getId() %>" onchange="selectPatientForAmbulance('<%=ambulanceRegister.getHin().getHinNo()%>','<%=patientName%>','<%=ambulanceRegister.getInpatient().getAdNo() %>','<%=doctorName %>')" onclick="selectPatientForAmbulance('<%=ambulanceRegister.getHin().getHinNo()%>','<%=patientName%>','<%=ambulanceRegister.getInpatient().getAdNo() %>','<%=doctorName %>')" /> 
<%} %>
</td>
<td><%=ambulanceRegister.getHin().getHinNo() %></td>
<td><%=patientName%></td>
<td><%=ambulanceRegister.getInpatient().getAdNo() %></td>
<td><%=doctorName %></td>

<td>
<%
String status="";
if(ambulanceRegister.getStatus()!=null && !ambulanceRegister.getStatus().equals("")){
	if(ambulanceRegister.getStatus().equals("A")){
		status="Accepted";
	}else if(ambulanceRegister.getStatus().equals("R")){
		status="Rejected";
	}else if(ambulanceRegister.getStatus().equals("C")){
		status="Closed";
	}else if(ambulanceRegister.getStatus().equals("P")){
		status="Pending";
	}else if(ambulanceRegister.getStatus().equals("F")){
		status="Forwarded";
	}
	}else{
		status="Pending";
	}
	%>
<%=status %>
</td>
</tr>
<%} %>
</table>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<label> UHID </label> 
<div id="testDiv">
<input type="text" name="<%= HIN_NO %>" id="<%= HIN_NO %>" value="" tabindex="1"  validate="HIN No,metachar,no"  maxlength="20" readonly="readonly" />
</div>
<label> Patient Name<span>*</span></label> 
<input type="text" id="<%= PATIENT_NAME %>" name="<%= PATIENT_NAME %>" i value="" tabindex="1"  maxlength="15" validate="Patient Name,metachar,yes"  readonly="readonly" />

<label> IP NO.<span>*</span></label> 
<input type="text" id="<%=AD_NO %>" name="<%=AD_NO %>" value="" tabindex="1"  maxlength="15" validate="IP NO.,metachar,yes"  readonly="readonly" />

<label> Doctor Name<span>*</span></label> 
<input type="text" id="<%=DOCTOR_NAME %>" name="<%=DOCTOR_NAME %>" value="" tabindex="1"  maxlength="15" validate="Doctor Name,yes"  readonly="readonly" />

<div class="clear"></div>

<hr/>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<label> Date <span>*</span></label> 

<input	type="text" name="<%=AMBULANCE_RUN_DATE %>" value="<%= currentDate %>" MAXLENGTH="30"  tabindex="1" id="ambulanceRunDate" validate="Ambulance Run Date,date,yes" class="date"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"  tabindex="1" 
class="calender"	onClick="setdate('<%=currentDate %>',document.ambulanceRunRegister.<%=AMBULANCE_RUN_DATE %>,event)" /> 

<label> Time <span>*</span></label> 

<input type="text" id="runTime" name="<%= AMBULANCE_RUN_TIME %>" value="<%=time%>" tabindex="1"   maxlength="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);" 	 validate="Ambulance Run Time,string,yes" >
</input>
<label> Source </label>

<input type="text" id="from" name="<%= FROM_SMC %>" value="" tabindex="1"  maxlength="100" validate="Source,metachar,no">
</input>
<div class="Clear"></div>

<label> Destination </label>

<input type="text" id="to" name="<%= DESTINATION %>" value="" tabindex="1"  maxlength="100" validate="Destination,metachar,no" />

<label>Attendants (If Any)</label> 

<input type="text" name="attendants" value="" maxlength="50" tabindex="1" validate="attendants,metachar,no"/>
</div>
<div class="Clear"></div>
<input type="button" name="Submit11" id="addbutton" tabindex="1" 
	onclick="submitForm('ambulanceRunRegister','/hms/hms/ipd?method=saveAmbulanceRunRequestDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />

<div class="Clear"></div>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('ambulanceRunRegister','ipd?method=showAmbulanceRunRequest');"/>
<%} else{%>
<h4>No Record found</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('ambulanceRunRegister','ipd?method=showPatientListNurseJsp');"/>
<%} %>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

function selectPatientForAmbulance(hin,name,ipno,doctorname)
{
	
	document.getElementById("<%= HIN_NO %>").value=hin;
	document.getElementById("<%= PATIENT_NAME %>").value=name;
	document.getElementById("<%= AD_NO %>").value=ipno;
	document.getElementById("<%= DOCTOR_NAME %>").value=doctorname;
}

</script>
