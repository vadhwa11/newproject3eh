
 
 
 <%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>


<%@page import="jkt.hms.util.PatientCaseSheetDetails"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">
/***********************************************
* Rich HTML Balloon Tooltip- � Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	int waitingCount = 0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
	try {
			if(map.get("inPatientSet")!=null)
			{
			  inPatientSet=(List<Inpatient>)map.get("inPatientSet");

			}
			
	} catch (Exception exp) {
			exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("waitingCount") != null) {
		waitingCount = Integer.parseInt(""+map.get("waitingCount")) ;
	}

	List<MasBed> bedNoList = new ArrayList<MasBed>();
	if(map.get("bedNoList")!=null){
		bedNoList = (List<MasBed>)map.get("bedNoList");
	}
	List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
	if(map.get("opdDetailsList")!=null){
		opdDetailsList = (List<OpdPatientDetails>)map.get("opdDetailsList");
	}
	List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();

	if(map.get("caseSheetDetails")!=null){
		caseSheetDetails = (List<PatientCaseSheetDetails>)map.get("caseSheetDetails");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	
	
	
	//for calender
	int month=0;
	if (map.get("month") != null) {
		month = Integer.parseInt(""+map.get("month")) ;
	}
	
	int year=0;
	if (map.get("year") != null) {
		year = Integer.parseInt(""+map.get("year")) ;
	}
	
	int surgeryId=0;
	if (map.get("surgeryId") != null) {
		surgeryId = Integer.parseInt(""+map.get("surgeryId")) ;
	}
	 List<OtBooking> bookList = new ArrayList<OtBooking>();
	 List<OtMasUnitDay> otMasUnitDayList=new ArrayList<OtMasUnitDay>();
	 HospitalDoctorUnitT doctorUnit=null;
	 Set<String> workingDays=new HashSet<String>();
	 if(map.get("bookList")!=null){
		 bookList = (List<OtBooking>)map.get("bookList");
		}
	 if(map.get("otMasUnitDayList")!=null){
		 otMasUnitDayList = (List<OtMasUnitDay>)map.get("otMasUnitDayList");
		}
	 if(map.get("doctorUnit")!=null){
		 doctorUnit = (HospitalDoctorUnitT)map.get("doctorUnit");
		}
	 if(map.get("workingDays")!=null){
		 workingDays = (Set<String>)map.get("workingDays");
		}

%>


<div class="titleBg"><h2>Ward Management</h2></div>
<div class="clear"></div>
<!--<h4><%=deptName %></h4>
--><!--  <div style="float: left; padding-left: 500px;"><h4 align="left" class="style1"><%//deptName%></h4></div>  -->
<div class="clear"></div>
<!-- thread search menu -->

    <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");

      %>
    <h4><%=message %></h4>
		<% }
		%>

<div class="clear"></div>
<div class="paddingTop5"></div>
<%Calendar cal1 = Calendar.getInstance();
 %>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Month<span>*</span></label>
<select name="month" validate="Month,int,yes">
<%
cal1.set(Calendar.MONTH,0);
if(month==0){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">January</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >January</option>
<%} %>

<%
cal1.set(Calendar.MONTH,1);
if(month==1){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">February</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >February</option>
<%} %>

<%
cal1.set(Calendar.MONTH,2);
if(month==2){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">March</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >March</option>
<%} %>

<%
cal1.set(Calendar.MONTH,3);
if(month==3){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">April</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >April</option>
<%} %>

<%
cal1.set(Calendar.MONTH,4);
if(month==4){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">May</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >May</option>
<%} %>

<%
cal1.set(Calendar.MONTH,5);
if(month==5){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">June</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >June</option>
<%} %>

<%
cal1.set(Calendar.MONTH,6);
if(month==6){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">July</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >July</option>
<%} %>

<%
cal1.set(Calendar.MONTH,7);
if(month==7){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">August</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >August</option>
<%} %>


<%
cal1.set(Calendar.MONTH,8);
if(month==8){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">September</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >September</option>
<%} %>

<%
cal1.set(Calendar.MONTH,9);
if(month==9){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">October</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >October</option>
<%} %>

<%
cal1.set(Calendar.MONTH,10);
if(month==10){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">November</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >November</option>
<%} %>

<%
cal1.set(Calendar.MONTH,11);
if(month==11){ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" selected="selected">December</option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.MONTH)%>" >December</option>
<%} %>
</select>
<label>Year<span>*</span></label>
<select name="year" validate="Year,int,yes">
<%
 cal1 = Calendar.getInstance();
if(year==cal1.get(Calendar.YEAR)){ %>
<option value="<%=cal1.get(Calendar.YEAR)%>" selected="selected"><%=cal1.get(Calendar.YEAR) %></option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.YEAR)%>" ><%=cal1.get(Calendar.YEAR) %></option>
<%} %>

<%if(year==(cal1.get(Calendar.YEAR)+1)){ %>
<option value="<%=cal1.get(Calendar.YEAR)+1%>" selected="selected"><%=cal1.get(Calendar.YEAR)+1 %></option>
<%}else{ %>
<option value="<%=cal1.get(Calendar.YEAR)+1%>" ><%=cal1.get(Calendar.YEAR)+1 %></option>
<%} %>
</select>
<div class="clear"></div>

<input type="button" value="Search" onclick="submitForm('search','/hms/hms/ot?method=showOtStatus&surgeryId=<%=surgeryId %>')" />
</form>

<form id="bookingStatus" name="bookingStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DAY_OF_MONTH, 1); 
 cal.set(Calendar.MONTH, month); 
cal.set(Calendar.YEAR, year); 
int myMonth=cal.get(Calendar.MONTH);
Map<String,String> bokkingDetails=new HashMap<String,String>();
while (myMonth==cal.get(Calendar.MONTH)) {
	String current=HMSUtil.convertDateToStringTypeDateOnly(cal.getTime());	
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	for(OtBooking booking:bookList)
	{
		if(cal.getTime().equals(booking.getSurgeryDate()))
		{
			if(bokkingDetails.get(current)==null)
			{
				bokkingDetails.put(current, "Patient:"+booking.getHin().getPFirstName()+"   OT:"+booking.getDepartment().getDepartmentName()+"    Table:"+booking.getBed().getBedNo()+"    Booked By:"+booking.getBookedBy().getEmployeeName());
			}
			else
			{
				bokkingDetails.put(current, bokkingDetails.get(current)+"</br></br>/n/n"+"Patient:"+booking.getHin().getPFirstName()+"   OT:"+booking.getDepartment().getDepartmentName()+"    Table:"+booking.getBed().getBedNo()+"    Booked By:"+booking.getBookedBy().getEmployeeName());
			}
		}
	}	
	cal.add(Calendar.DAY_OF_MONTH, 1);
}


cal1 = Calendar.getInstance();
 cal = Calendar.getInstance();
cal.set(Calendar.DAY_OF_MONTH, 1); 
 cal.set(Calendar.MONTH, month); 
cal.set(Calendar.YEAR, year); 


 myMonth=cal.get(Calendar.MONTH);
 int j=1;
	int i=0;
while (myMonth==cal.get(Calendar.MONTH)) {
	String current=HMSUtil.convertDateToStringTypeDateOnly(cal.getTime());
	
	DateFormat f = new SimpleDateFormat("EEEE");
	%>
	<%if(cal.getTime().before(cal1.getTime())){ %>
	<div rel="balloon<%=i %>" class="red" onclick=""> &nbsp;   <%=current%></div>
	<%}else if(workingDays.contains(f.format(cal.getTime())) && bokkingDetails.get(current)!=null ){%>
	
		<div rel="balloon<%=i %>" class="yellow" onclick="setInpatientId('<%=surgeryId%>','<%=current%>')"> &nbsp;    <%=current%></div>
	<%}else if(workingDays.contains(f.format(cal.getTime())) && bokkingDetails.get(current)==null ){%>
	
	<div rel="balloon<%=i %>" class="green" onclick="setInpatientId('<%=surgeryId%>','<%=current%>')"> &nbsp;  <%=current%></div>
<%}else if(!workingDays.contains(f.format(cal.getTime())) && bokkingDetails.get(current)!=null ){%>

<div rel="balloon<%=i %>" class="blue" onclick="setInpatientId('','')"> &nbsp;  <%=current%></div>
<%}else {
%>
			<div rel="balloon<%=i %>" class="orange"> &nbsp;   <%=current%></div>
	<%} %>
	<div id="balloon<%=i %>" class="wardstyle">
	 <%= bokkingDetails.get(current)!=null?bokkingDetails.get(current):""%>

<div class='clear'></div>
 </div>
	<%
	i++;
  cal.add(Calendar.DAY_OF_MONTH, 1);
}
%>
<input type="hidden" name="surgeryHdId"	value="" id="surgeryId" />
<input type="hidden" name="surgeryDate"	value="" id="surgeryDate" />

<div class="clear"></div>
<%--  <%if(waitingCount !=0){ %>
<div class="monitor"> Waiting Patients: <span><%=waitingCount%></span></div>
 <%} %> --%>
<div class="clear paddingTop15"></div>
<input type="text" class="signPriority3" readonly="readonly" >
<label class="value">Working Not Booked</label>

<input type="text" class="signPriority1" readonly="readonly" >
<label class="value">Previous Date</label>

<input type="text" class="signPriority5" readonly="readonly" >
<label class="value">Non-Working Booked</label>

<input type="text" class="signPriority4" readonly="readonly" >
<label class="value">Non-Working Not Booked</label>

<input type="text" class="signPriority2" readonly="readonly" >
<label class="value">Working Booked</label>

<script	type="text/javascript">



function setInpatientId(surgeryId,surgeryDate){
	document.getElementById('surgeryId').value = surgeryId;
	document.getElementById('surgeryDate').value = surgeryDate;
	submitForm('bookingStatus','/hms/hms/ot?method=showOTBookingJsp')
	//document.getElementById('bookingStatus').submit();;
}
/* setting border for show selected patient from list  */
function setBorder(inc){
	var count = '<%=j%>';

	for(var i=0;i<count;i++){
		if(i == inc){
			if(document.getElementById('admitted'+i)){
				//document.getElementById('admitted'+i).style.border = '2px solid blue';
			document.getElementById('admitted'+i).style.fontWeight  = 'bold';
			document.getElementById('admitted'+i).style.color  = '#AC1400';
			}
		}else{
			if(document.getElementById('admitted'+i)){
				document.getElementById('admitted'+i).style.border = '1px solid #000'
				document.getElementById('admitted'+i).style.fontWeight  = 'normal';
				document.getElementById('admitted'+i).style.color  = '#000';
			}
		}

	}
}


</script>


</form>
 