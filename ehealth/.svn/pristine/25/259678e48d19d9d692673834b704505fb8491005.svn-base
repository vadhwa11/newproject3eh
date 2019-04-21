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
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasAmbulance"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
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
<form name="printAmbulanceSlip" action="" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<form name="ambulanceRunRegister" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<AmbulanceRegister> ambulanceRegisterList =new ArrayList<AmbulanceRegister>();
		List<MasAmbulance> ambulanceList=new ArrayList<MasAmbulance>();
		List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
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
		if(map.get("ambulanceList") != null){
			ambulanceList = (List<MasAmbulance>)map.get("ambulanceList");
		}
		if(map.get("chargeCodeList") != null){
			chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
	%>


<h4><%=message %></h4>
<div class="titleBg"><h2>Ambulance Register</h2></div>
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
<th>Ambulance Slip</th>
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
	String source="";
	String destination="";
	String attends=""; // added by Amit Das on 22-03-2016
	int ambulanceId = 0; // added by Amit Das on 22-03-2016
	String driverName = ""; // added by Amit Das on 22-03-2016
	String driverContactNo = ""; // added by Amit Das on 22-03-2016
	BigDecimal distance = new BigDecimal("0"); // added by Amit Das on 22-03-2016
	String ambStatusId = ""; // added by Amit Das on 22-03-2016
	BigDecimal amount = new BigDecimal("0"); // added by Amit Das on 22-03-2016
	int masChargeCodeId = 0; // added by Amit Das on 22-03-2016
	
	if(ambulanceRegister.getFromSmc()!=null && !ambulanceRegister.getFromSmc().trim().equals("")){
		source=ambulanceRegister.getFromSmc();
	}
	if(ambulanceRegister.getToDestination()!=null && !ambulanceRegister.getToDestination().trim().equals("")){
		destination=ambulanceRegister.getToDestination();
	}
	// start of code by Amit Das on 22-03-2016
	if(ambulanceRegister.getToDestination()!=null && !ambulanceRegister.getToDestination().trim().equals("")){
		destination=ambulanceRegister.getToDestination();
	}
	if(ambulanceRegister.getAttendents()!=null && !ambulanceRegister.getAttendents().trim().equals("")){
		attends=ambulanceRegister.getAttendents();
	}
	if(ambulanceRegister.getAmbulance()!=null){
		ambulanceId=ambulanceRegister.getAmbulance().getId();
	}
	if(ambulanceRegister.getDriverName()!=null && !ambulanceRegister.getDriverName().trim().equals("")){
		driverName=ambulanceRegister.getDriverName();
	}
	if(ambulanceRegister.getDriverContact()!=null && !ambulanceRegister.getDriverContact().trim().equals("")){
		driverContactNo=ambulanceRegister.getDriverContact();
	}
	
	if(ambulanceRegister.getDistance()!=null){
		distance=ambulanceRegister.getDistance();
	}
	
	if(ambulanceRegister.getStatus()!=null && !ambulanceRegister.getStatus().trim().equals("")){
		ambStatusId =ambulanceRegister.getStatus();
	}
	
	if(ambulanceRegister.getCharge()!=null){
		amount =ambulanceRegister.getCharge();
	}
	
	if(ambulanceRegister.getChargeCode()!=null){
		masChargeCodeId =ambulanceRegister.getChargeCode().getId();
	}
	
	
	
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
<%if(ambulanceRegister.getStatus()!=null ){%>
<input type="radio" name="ambulanceId" id="ambulanceId<%=i %>" value="<%=ambulanceRegister.getId() %>" 
onchange="selectPatientForAmbulance('<%=ambulanceRegister.getHin().getHinNo()%>','<%=patientName%>','<%=ambulanceRegister.getInpatient().getAdNo() %>','<%=doctorName %>','<%=source%>','<%=destination %>','<%=attends%>','<%=ambulanceId%>','<%=driverName%>','<%=driverContactNo%>','<%=distance%>','<%=ambStatusId%>','<%=amount%>','<%=masChargeCodeId%>','<%=ambulanceRegister.getHin().getId()%>','<%=ambulanceRegister.getInpatient().getId() %>')" 
 /> 
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
		status="Pending";
	}
	}else{
		status="Pending";
	}
	%>
<%=status %>
</td>
<td>
<%
if(ambulanceRegister.getStatus()!=null && !ambulanceRegister.getStatus().equals("")){
	if(ambulanceRegister.getStatus().equals("A")){
		
		%>	
	<input type="button" name="ambulanceId" id="ambulanceId<%=i %>" value="Print" 
	onclick="submitForm('printAmbulanceSlip','/hms/hms/ipd?method=printAmbulanceSlip&adNo=<%=ambulanceRegister.getInpatient().getAdNo()%>&hospitalId=<%=ambulanceRegister.getHospital().getId() %>&hinId=<%=ambulanceRegister.getHin().getId()%>&inpatientId=<%=ambulanceRegister.getInpatient().getId()%>');"
<%-- onclick="/hms/hms/ipd?method=printAmbulanceSlip&adNo='<%=ambulanceRegister.getInpatient().getAdNo()%>'&hospitalId='<%=ambulanceRegister.getHospital().getId() %>'&hinId='<%=ambulanceRegister.getHin().getId()%>'&inpatientId='<%=ambulanceRegister.getInpatient().getId() %>'"  --%>
 />
<%		
	}
}		
		%>

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
<input type="hidden" name="hinId" id="hinId" value="" tabindex="1"    maxlength="20" readonly="readonly" />
<input type="hidden" name="inPatientId" id="inPatientId" value="" tabindex="1"    maxlength="20" readonly="readonly" />
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
<label> Source <span>*</span></label>

<input type="text" id="from" name="<%= FROM_SMC %>" value="" tabindex="1"  maxlength="100" validate="Source,metachar,yes">
</input>
<div class="Clear"></div>

<label> Destination <span>*</span></label>

<input type="text" id="to" name="<%= DESTINATION %>" value="" tabindex="1"  maxlength="100" validate="Destination,metachar,yes" />
<label>Attendants (If Any)</label> 

<input type="text" name="attendants" id="attendants" value="" maxlength="50" tabindex="1" validate="attendants,metachar,no"/>

<label>Charge</label> 

<select name="ambulanceCharge" id="ambulanceChargeId" tabindex="1" onchange="populateChargeAmoutForAmbulance()">
				<option value="0">Select</option>
				<%
				if(chargeCodeList.size()>0){
				for(MasChargeCode masChargeCode : chargeCodeList)
		{%>
			
				<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
				
	<%	}}%>
			</select>

<div class="Clear"></div>
<label>Charges (In Rs)</label> 

<input type="text" name="charge" id="chargeId" value="" maxlength="10"tabindex="1"  validate="Charges(For NE),float,no"/>


<label>KMs</label> 

<input type="text" id="distance" name="distance" value="" maxlength="3" tabindex="1" validate="KMs.,metachar,no" onblur="calculateAmbulanceAmount(this.value);"/>

<label>Amount</label> 

<input type="text" name="amount" id="amountId" value="" maxlength="10"tabindex="1"  validate="amount,float,no"/>


<div class="Clear"></div>
<label>Ambulance No.</label> 
<select name="ambulanceno" id="ambulanceno">
<option value="">Select</option>
<%if(ambulanceList.size()>0){
	for(MasAmbulance masAmbulance :ambulanceList){
	%>
	<option value="<%=masAmbulance.getId()%>"><%=masAmbulance.getAmbulanceNo() %></option>
<%}} %>
</select>

<label>Driver Name</label> 

<input type="text" name="drivername" id="drivername" value="" maxlength="50" tabindex="1" validate="drivername,metachar,no"/>
<label>Driver Contact No.</label> 

<input type="text" name="drivercontact" id="drivercontact" value="" maxlength="12" tabindex="1" validate="Driver Contact No.,contact,no" />

<label>Remarks</label> 

<textarea name="<%=REMARKS %>" rows="" cols="" tabindex="1"  maxlength="90" oninput="return checkMaxLengthMoz(this)" validate="remarks,remarks,no" class="textareaMediua"></textarea>
</label>
<label>Status <span>*</span></label>
<select name="ambStatus" id="ambStatusId" validate="Status,strung,yes">
<option value="">Select</option>
<option value="A">Accepted</option>
<option value="R">Rejected</option>
<option value="C">Closed</option>
</select>

<div class="Clear"></div>
<input type="button" name="Submit11" id="addbutton" tabindex="1" 
	onclick="submitForm('ambulanceRunRegister','/hms/hms/ipd?method=saveAmbulanceRunRegisterDetails');"
	value="Submit" class="button" accesskey="a" />
<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
</div>
<div class="Clear"></div>
<%} else{%>
<h4>No Record found</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

function calculateAmbulanceAmount(distance){
	var amount;
	var charge = document.getElementById('chargeId').value;	
	if(charge !=''){
		amount = parseFloat(charge)	*parseFloat(distance);
		if(!isNaN( parseFloat(amount))){
			document.getElementById('amountId').value = parseFloat(amount);
		}
	}
}



// changed by Amit Das on 22-03-2016
function selectPatientForAmbulance(hin,name,ipno,doctorname,source,destination,attends,ambulanceId,driverName,driverContactNo,distance,ambStatusId,amount,masChargeCodeId,hinId,inPatientId)
{
	document.getElementById("<%= HIN_NO %>").value=hin;
	document.getElementById("<%= PATIENT_NAME %>").value=name;
	document.getElementById("<%= AD_NO %>").value=ipno;
	document.getElementById("<%= DOCTOR_NAME %>").value=doctorname;
	document.getElementById("<%= DOCTOR_NAME %>").value=doctorname;
	document.getElementById('hinId').value=hinId;
	document.getElementById('inPatientId').value=inPatientId;
	document.getElementById("from").value=source;
	document.getElementById("to").value=destination;
	document.getElementById("attendants").value=attends;
	document.getElementById("ambulanceno").value=ambulanceId;
	document.getElementById("drivername").value=driverName;
	document.getElementById("drivercontact").value=driverContactNo;
	document.getElementById("distance").value=distance;
	document.getElementById("ambStatusId").value=ambStatusId;
	document.getElementById("chargeId").value=amount;
	document.getElementById("ambulanceChargeId").value=masChargeCodeId;
	calculateAmbulanceAmount(distance);
}


</script>
