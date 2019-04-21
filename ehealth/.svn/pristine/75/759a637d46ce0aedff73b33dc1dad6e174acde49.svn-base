<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="investigationAppointments" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript" language="javascript">
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>';
	
		
		function openPopUp(inc)
		{
			
			window.open('appointment?method=showExistingPatients&serviceNo='+document.getElementById('serviceNo'+inc).value+'&counter='+inc+'&'+csrfTokenName+'='+csrfTokenValue,'mywindow','location=1,status=1,scrollbars=1,width=500,height=300');
		}
		
		function blankAllFields(inc)
		{
				document.getElementById('hinNo'+inc).value="";
				document.getElementById('hinId'+inc).value="";
				document.getElementById('patientName'+inc).value="";
				document.getElementById('mobileNo'+inc).value="";
				document.getElementById('age'+inc).value="";
				document.getElementById('sex'+inc).value="M";
				document.getElementById('employeeId'+inc).value="";
				document.getElementById('ageUnit'+inc).value="0";
		}
		function disableFields(counter,inc)
		{
			var i=0;
			for(i=0;i<=counter;i++)
			{
				if(i==inc)
				{
					
					document.getElementById("hin_service"+i).disabled=false;
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=false;
					}
				}else{
					if(document.getElementById("hinNo"+i)!=null)
					{
						document.getElementById("hinNo"+i).value="";
						document.getElementById("hinNo"+i).disabled=true;
					}
					if(document.getElementById("hinId"+i)!=null)
					{
						document.getElementById("hinId"+i).value="";
						document.getElementById("hinId"+i).disabled=true;
					}
					if(document.getElementById("patientName"+i)!=null)
					{
						document.getElementById("patientName"+i).value="";
						document.getElementById("patientName"+i).disabled=true;
					}
					if(document.getElementById("mobileNo"+i)!=null)
					{
						document.getElementById("mobileNo"+i).value="";
						document.getElementById("mobileNo"+i).disabled=true;
					}
					if(document.getElementById("sex"+i)!=null)
					{
						document.getElementById("sex"+i).value="M";
						document.getElementById("sex"+i).disabled=true;
					}
					if(document.getElementById("age"+i)!=null)
					{
						document.getElementById("age"+i).value="";
						document.getElementById("age"+i).disabled=true;
					}
					if(document.getElementById("employeeId"+i)!=null)
					{
						document.getElementById("employeeId"+i).value="";
						document.getElementById("employeeId"+i).disabled=true;
					}
					if(document.getElementById("fromTimeSlot"+i)!=null)
					{
						document.getElementById("fromTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("toTimeSlot"+i)!=null)
					{
						document.getElementById("toTimeSlot"+i).disabled=true;
					}
					if(document.getElementById("hinNo"+i)!=null)
					{
						document.getElementById("hinNo"+i).disabled=true;
					}
					if(document.getElementById("ageUnit"+i)!=null)
					{
						document.getElementById("ageUnit"+i).disabled=true;
					}
					if(document.getElementById("hin_service"+i)!=null)
					{
						document.getElementById("hin_service"+i).disabled=true;
					}
					
				}
				
			}
			
		}
		
		function disableHinService(selectedValue,inc)
		{
			blankAllFields(inc);
			if(selectedValue=='hinNo')
			{
				document.getElementById('employeeId'+inc).disabled=false;
				document.getElementById("hinNo"+inc).readOnly=false;
				document.getElementById("hinNo"+inc).disabled=false;
				
				
			}
			else if(selectedValue=='none')
			{
				document.getElementById('hinNo'+inc).disabled=true;
				document.getElementById('hinId'+inc).disabled=true;
				if(document.getElementById("patientName"+inc)!=null)
				{
					document.getElementById("patientName"+inc).disabled=false;
					document.getElementById("patientName"+inc).readOnly=false;
				}
				if(document.getElementById("mobileNo"+inc)!=null)
				{
					document.getElementById("mobileNo"+inc).disabled=false;
					document.getElementById("mobileNo"+inc).readOnly=false;
				}
				if(document.getElementById("sex"+inc)!=null)
				{
					document.getElementById("sex"+inc).disabled=false;
					document.getElementById("sex"+inc).readOnly=false;
				}
				if(document.getElementById("age"+inc)!=null)
				{
					document.getElementById("age"+inc).disabled=false;
					document.getElementById("age"+inc).readOnly=false;
				}
				if(document.getElementById("ageUnit"+inc)!=null)
				{
					document.getElementById("ageUnit"+inc).disabled=false;
					document.getElementById("ageUnit"+inc).readOnly=false;
				}
				if(document.getElementById("employeeId"+inc)!=null)
				{
					document.getElementById("employeeId"+inc).disabled=false;
					document.getElementById("employeeId"+inc).readOnly=false;
				}
			}
			else
			{
				if(document.getElementById("hinNo"+inc)!=null)
					{
						document.getElementById("hinNo"+inc).disabled=true;
					}
					if(document.getElementById("hinId"+inc)!=null)
					{
						document.getElementById("hinId"+inc).disabled=true;
					}
					if(document.getElementById("patientName"+inc)!=null)
					{
						document.getElementById("patientName"+inc).disabled=true;
					}
					if(document.getElementById("mobileNo"+inc)!=null)
					{
						document.getElementById("mobileNo"+inc).disabled=true;
					}
					if(document.getElementById("sex"+inc)!=null)
					{
						document.getElementById("sex"+inc).disabled=true;
					}
					if(document.getElementById("age"+inc)!=null)
					{
						document.getElementById("age"+inc).disabled=true;
					}
					if(document.getElementById("employeeId"+inc)!=null)
					{
						document.getElementById("employeeId"+inc).disabled=true;
					}
					if(document.getElementById("fromTimeSlot"+inc)!=null)
					{
						document.getElementById("fromTimeSlot"+inc).disabled=true;
					}
					if(document.getElementById("toTimeSlot"+inc)!=null)
					{
						document.getElementById("toTimeSlot"+inc).disabled=true;
					}
					if(document.getElementById("hinNo"+inc)!=null)
					{
						document.getElementById("hinNo"+inc).disabled=true;
					}
					if(document.getElementById("ageUnit"+inc)!=null)
					{
						document.getElementById("ageUnit"+inc).disabled=true;
					}
					if(document.getElementById("hin_service"+inc)!=null)
					{
						document.getElementById("hin_service"+inc).disabled=false;
					}
				alert("select HIN or service No or None");
			}
			
		}
		
		
		
		var holidayArray=new Array();
		
		
		
	</script>
<div class="titleBg">
<h2>OPD Investigation Appointment</h2>
</div>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box=HMSUtil.getBox(request);
			 	
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");
			 	//Time sqlCurrentTime=(Time)utilMap.get("currentTime");
			 	boolean showSubmitButton=false;
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			 	
			 	/* List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>(); */
			 	
			 	List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
			 	List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	String[][] calculatedSlotList=null;
			 	Integer[] noOfEquipmentsList=null;
			 	String breakToTime=null;
			 	boolean patientNameExist = false;
			 	boolean recordExists=false;
			 	String alertMessage=null;
			 	int counter=0;
			 	Calendar c_currentTime=Calendar.getInstance();
    			//c_currentTime.setTime(Time.valueOf(currentTime));
			 	
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 		
			 	}
				if (map.get("employeeList") != null) {
					employeeList = (List<MasEmployee>) map.get("employeeList");
			 		
			 	}
				if (map.get("holidayList") != null) {
					holidayList = (List<OpdHoliday>) map.get("holidayList");
			 		
			 	}
				if (map.get("equipmentList") != null) {
					equipmentList = (List<HesEquipmentMaster>) map.get("equipmentList");
			 		
			 	}
				if(map.get("slotList")!=null)
				{
					calculatedSlotList=(String [][])map.get("slotList");
				}
				if(map.get("noOfEquipmentsList")!=null)
				{
					noOfEquipmentsList=(Integer[])map.get("noOfEquipmentsList");
				}
				if(map.get("counter")!=null)
				{
					counter=(Integer)map.get("counter");
				}
				if (map.get("registeredPatientList") != null) {
					registeredPatientList = (List<Patient>) map.get("registeredPatientList");
			 		
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <span> <%=message %> </span>
<%    
					   
				}
			 	else if(map.get("actualAvailableAppointments")!=null)
			 	{
			 		int actualAvailableAppointments= (Integer)map.get("actualAvailableAppointments");
			 	%> <marquee height=20 width=auto align=right direction=right
	behavior=scroll><font color=blue
	style="font-weight: bold; font-size: large"><%=actualAvailableAppointments+" " %>
Appointments are available.. !! </font></marquee> <%	}			 	
 %> <!--Block One Starts-->

<div class="Block">
<label>UHID<span>*</span></label>
<input type="text" name="uhid" id="uhid" value="" maxlength="25" tabindex="1" validate="UHID,string,yes" onblur="populateInvestigationOrder(this.value)" >

<label>Patient Name</label>
<input type="text" name="patientName" value="" id="patientNameId"/>

<label>Order No.</label>
<select id="OrderNoId" name="OrderNoName " onchange="populatePatientinvestigation(this.value)">
<option value="0">Select</option>
</select>
<div class="clear"></div>
<label>Department<span>*</span></label> <select
	<%-- id="departmentId" name="<%=DEPARTMENT_ID%>" onchange="populateInvestigationOrder(this.value)" --%>
	id="departmentId" name="<%=DEPARTMENT_ID%>" 
	validate="Department,number,no" onchange="getServiceCentreSession(this.value);" >
	<option value="0">Select</option>
	<%	int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
				if(masDepartment.getDepartmentCode().equalsIgnoreCase("Radio")){	
				%>
				<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
				
	<%} }			
				}
			%>
</select>


 <label>Investigation Date<span>*</span></label> <input type="text"
	id="appointmentdate" name="<%=APPOINTMENT_DATE %>" class="date"
	value="" MAXLENGTH="30" readonly="readonly" validate="Appointment date,string,yes"  /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currenDate %>',document.investigationAppointments.<%=APPOINTMENT_DATE%>,event);" />

<label>Equipment<span>*</span></label> 

<%-- <select id="equipmentId"
	name="<%=EQUIPMENT_ID%>" validate="Equipment,number,no"
	onblur="if(isApptGrCurrentDate('investigationAppointments'))submitProtoAjax('investigationAppointments','appointment?method=showAppointmentInvestigationWise','checkForHoliday');"
	onchange="submitProtoAjax('investigationAppointments','appointment?method=showAppointmentInvestigationWise','isApptGrCurrentDate','checkForHoliday');">
	 --%>
<select id="equipmentId"
	name="<%=EQUIPMENT_ID%>" validate="Equipment,number,yes">
	<option value="0">Select</option>
	<%
				if(equipmentList!= null){
				for (HesEquipmentMaster appEquipmentMaster : equipmentList) {
			%>
	<option value="<%=appEquipmentMaster.getItem().getId()%>"><%=appEquipmentMaster.getItem().getNomenclature()%></option>
	<%}
				}
			%>
</select>

<label>Investigation List</label>
<select id="investigationId" name="investigationName" class="multiple" multiple="multiple" validate="Investigation,metachar,yes">
</select>
<label>Session<span>*</span></label>
<select id="opsession" name="opsession" validate="Session,string,yes" tabindex="1" 
	onchange="if(checkSession()){if(isApptGrCurrentDate('investigationAppointments')){submitProtoAjax('investigationAppointments','appointment?method=showAppointmentInvestigationWise','isApptGrCurrentDate','checkForHoliday');}}">
				  <option value="0">Select</option>			
</select>

<div class="clear"></div>
<input type="hidden" name="preQueue" id="preQueue" value="0">
<h4>Select Queue Priority</h4>
<div id="testDiv">

</div>

<%-- <div class="clear"></div>
<label>Department</label> <input type="hidden" id="departmentId"
	name="<%=WARD_ID%>" value="<%=box.getInt(DEPARTMENT_ID)%>" /> <%
    if(departmentList!=null)
    {
    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==box.getInt(DEPARTMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=masDepartment.getDepartmentName()%></label>

<%		}
     		
    	 }
    }else{%> <label class="value"> &nbsp;</label> <% 	}
    
    %> <label>Appointment Date</label> <input type="hidden"
	id="apmtDate" name="<%=APMT_DATE%>"
	value="<%=box.getString(APPOINTMENT_DATE)%>" /> <%String tempDate= box.getString(APPOINTMENT_DATE); %>
<label class="value"><%= tempDate %></label> <label>Equipment</label> <input
	type="hidden" id="equipmentId" name="<%=EQUIP_ID%>"
	value="<%=box.getInt(EQUIPMENT_ID)%>" /> <%
    if(equipmentList!=null)
    {
    	 Iterator ite=equipmentList.iterator();
    	 while ( ite.hasNext() ) {
     		HesEquipmentMaster appEquipmentMaster=(HesEquipmentMaster)ite.next();
     		if(appEquipmentMaster.getItem().getId()==box.getInt(EQUIPMENT_ID))
     		{
     			
     		
     %> <label class="value"> <%=appEquipmentMaster.getEquipmentName()%></label>

<%		}
     		
    	 }
    }else{%> <label class="value"> &nbsp;</label> <% 	}
    
    %> --%>
<div class="clear"></div>

<!--Block one Ends-->
<div class="clear"></div>
<div class="division"></div>

<%-- <%		
				int i=0;
				if(holidayList!=null){
					if(holidayList.size()>0){
					
							
							Iterator ite = holidayList.iterator();
							while ( ite.hasNext() ) {
						         OpdHoliday opdHoliday=(OpdHoliday)  ite.next();
						         
		%> <script>
	         		 			
	         					holidayArray[<%=i%>]= new Array();
								holidayArray[<%=i%>][0] = "<%=opdHoliday.getHolidayName()%>";
								holidayArray[<%=i%>][1] = "<%=HMSUtil.changeDateToddMMyyyy(opdHoliday.getHolidayDate())%>";
								
								</script> <%
						         i++;
						    }
						 }
				}
		%>
 --%>


<%-- <table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th></th>
		<th scope="col">Time Slot</th>
		<th scope="col">Slots <br />
		Available</th>
		<th scope="col">Appointment <br />
		Criteria</th>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
		<th colspan="5" scope="col"><span
			style="color: #FFF; padding-left: 24px; float: left;">Patient
		Name </span><span style="color: #FFF; padding-left: 28px; float: left;">Mobile
		No.</span> <span style="color: #FFF; padding-left: 35px; float: left;">Sex</span>
		<span style="color: #FFF; padding-left: 60px; float: left;">Age</span></th>
		<th scope="col">Doctor's <br />
		Name</th>
	</tr>

	<%
     	int inc = 0;  
    				Calendar c_calculatedTime=Calendar.getInstance();
    				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    		        String currentTimeinformat=sdf.format(c_currentTime.getTime());
    		        
     	for(inc=0;inc<counter;inc++){ 
    			if(calculatedSlotList[inc][0]!=null || calculatedSlotList[inc][1]!=null)
    			{
    				showSubmitButton=true;
    				c_calculatedTime.setTime(Time.valueOf(calculatedSlotList[inc][0]));
    				String calculatedTimeFormat=sdf.format(c_calculatedTime.getTime());
    				
    				Date apmtDate=HMSUtil.convertStringTypeDateToDateType(box.getString(APPOINTMENT_DATE));

    			%>
	<tr>
		<%	if(noOfEquipmentsList[inc] != null && noOfEquipmentsList[inc] > 0 )
    				{
    				   if (apmtDate.compareTo(HMSUtil.convertStringTypeDateToDateType(currenDate))==0 && c_calculatedTime.getTime().before(Time.valueOf(currentTimeinformat)))
    				   {
    			%>
		<!--Radio button 1-->
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>

		<%		}else {		%>

		<!--Radio button 2-->
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>
	<%		
    					}
    				}
					else{					
    			%>
		<td><input type="radio" id="parent" name="parent" value=""
			onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>
		<% }
				%>

		<%StringTokenizer st1=new StringTokenizer(calculatedSlotList[inc][0],":"); %>
		<%StringTokenizer st2=new StringTokenizer(calculatedSlotList[inc][1],":"); %>

		<!--Time Slot-->
		<td><label><%=st1.nextToken()%>:<%=st1.nextToken()%>&nbsp;</label><label>
		- <%=st2.nextToken()%>:<%=st2.nextToken()%></label> <input type="hidden"
			id="fromTimeSlot<%=inc %>" name="<%=FROMTIMESLOT%>"
			value="<%=calculatedSlotList[inc][0]%>" /> <input type="hidden"
			id="toTimeSlot<%=inc %>" name="<%=TOTIMESLOT%>"
			value="<%=calculatedSlotList[inc][1]%>" /></td>
		<%if(noOfEquipmentsList[inc] != null && noOfEquipmentsList[inc] > 0){ %>
		<!--Slots Available 1-->
		<td><%=noOfEquipmentsList[inc]%></td>
		<%}else{%>
		<!--Slots Available 2-->
		<td></td>
		<%}%>
		<!--App criteria-->
		<td><select id="hin_service<%=inc%>" name="<%=SELECTED_RADIO%>"
			disabled="disabled"
			onchange="disableHinService(this.value,<%=inc%>);">
			<option value="0">Select</option>
			<option value="hinNo"><%=prop.getProperty("com.jkt.hms.registration_no") %></option>
			<option value="none">None</option>
		</select></td>
		<td><input type="text" size=10 id="hinNo<%=inc %>"
			name="<%=HIN_NO%>" disabled="disabled"
			onblur="if(this.value!='')submitProtoAjaxWithDivName('investigationAppointments','appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc %>');" /></td>

		<td colspan="5" id="testDiv<%=inc %>"><input type="hidden"
			id="hinId<%=inc%>" name="<%=HIN_ID %>" disabled="disabled" /> <!--Patient Name--><input
			type="text" size=16 id="patientName<%=inc%>" name="<%=PATIENT_NAME%>"
			disabled="disabled" MAXLENGTH="30"
			validate="Patient Name,fullName,no" class="floatLeft" /> <!--Mobile No.--><input
			type="text" size=10 id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>"
			disabled="disabled" MAXLENGTH="10" validate="Mobile No.,int,no"
			class="floatLeft" /> <!--Sex--> <select id="sex<%=inc%>"
			name="<%=SEX%>" disabled="disabled" class="smallFltLeft">
			<option value="M">M</option>
			<option value="F">F</option>
		</select> <!--Age 1--><input type="text" size=1 id="age<%=inc%>"
			name="<%=AGE%>" MAXLENGTH="2" size="1" disabled="disabled" class="" />


		<!--Age 2--> <select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>"
			disabled="disabled" class="small">
			<option value="0">Select</option>
			<option value="Years">Years</option>
			<option value="Months">Months</option>

		</select></td>
		<!--Doctor's Name-->
		<td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"
			disabled="disabled">
			<option value="0">Select</option>
			<%
									if(employeeList!= null){
										for (MasEmployee masEmployee : employeeList) {
								%>
			<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
			<%	}
									}
									%>
		</select></td>
	</tr>

	<%			}
    			else
    			{
  %>
	<tr>
		<td>&nbsp;</td>
		<td><label>BREAK</label></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="5" scope="col">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<%  			}
   			 }
   %>
</table> --%>

<div class="clear"></div>
<div class="paddingTop15"></div>
<%-- <%if(showSubmitButton==true){ %> --%> <input name="" type="button"
	class="button" value="Submit"
	onclick="submitForm('investigationAppointments','appointment?method=submitInvestigationAppointment&'+csrfTokenName+'='+csrfTokenValue);" />
	<!-- onclick="if(validateAppointmentRadio())submitForm('investigationAppointments','appointment?method=submitInvestigationAppointment','validateAgeOnSubmit');" /> -->
<input name="" type="reset" class="buttonHighlight" value="Reset"
	onclick="resetAppointmentSetup();" /> <%-- <%} %> --%>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName%></label> <label>Changed Date </label> <label
	class="value"><%=currenDate%></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label>

<div class="clear"></div>

</div>
</div>
<!--Bottom labels ends--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">

/* function validateAppointmentRadio(){
			var msg="Select a Time Slot !!";
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true )
              { msg="";
              	if(document.getElementsByName('selectedRadio')[i].value == "0" )
              	{	
              		msg += "Select Appointment Criteria";
              	}
              	else
              	{
              		if(document.getElementsByName('patientName')[i].value=="")
					{
						msg += "Patient Name can not be blank in row "+i+".\n";
					}
					if(document.getElementsByName('sex')[i].value=="")
					{
						msg += "Sex can not be blank in row "+i+".\n";
					}
					if(document.getElementsByName('age')[i].value=="")
					{
						msg += "Age can not be blank in row "+i+".\n";
					}
					
              		if(document.getElementsByName('selectedRadio')[i].value=="hinNo" )
					{
						if(document.getElementsByName('hinNo')[i].value=="")
						{
							msg += "Hin No. can not be blank in row "+i+".\n";
						}
					}
					if(document.getElementsByName('selectedRadio')[i].value=="none" || document.getElementsByName('hinNo')[i].value=="")
					{
						if(document.getElementsByName('ageUnit')[i].value=="0")
						{
							msg += "Select Age Unit in row "+i+".\n";
						}
					}
					
					
				  }
				}		
  		}
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;
		
	}
	 */
	 
	
	 function getPriorityNumber(priorityNo){
	 	
	 	var property=document.getElementById("Id"+priorityNo);
	 	//alert("You have Selected "+property.value+"Queue");
	 	//document.getElementById("queueNumberId").value=priorityNo;
	 	
	 	//document.getElementById("Id"+priorityNo).style.color = 'green';
	 		property.style.background = 'green';
	 		//property.style.color = 'green';
	 		
	 		//var checkQueue=document.getElementById("preQueue").value;
	 		
	 		
	 			var val=document.getElementById("preQueue").value;
	 			//alert(val);
	 			if(val>0){
	 			var ch=document.getElementById("preQueue").value;
	 			var propert=document.getElementById("Id"+ch);
	 			
	 			//document.getElementById("Id"+ch).style.color = '#0f75bf';
	 			propert.style.background = '#0f75bf';
	 			//propert.style.color = '#0f75bf';
	 			
	 			document.getElementById("preQueue").value=property.value;
	 			document.getElementById("Id"+ch).value=ch;
	 			}
	 			else{
	 				document.getElementById("preQueue").value=property.value;
	 				
	 			}
	 		
	 		
	 		
	 	
	 }
	 
	function resetAppointmentSetup(){
	document.getElementsByName('patientName')[1].value = "";
			 alert(document.getElementsByName('patientName')[1].value)
  		return true;
		
	}
	
function validateAgeOnSubmit()
{
 for(var i = 0; i < document.getElementsByName('parent').length; i++)
 {
			  if(document.getElementsByName('parent')[i].checked == true )
              {
              	var submitAge=document.getElementsByName('age')[i].value;
              	var subAge=submitAge.substring(0,2);
              	if(!validateNumeric(subAge))
			  	{
			  		errors ="Age should be a number .\n";
					alert(errors)
			  		document.getElementsByName('age')[i].value="";
					return false;
			  	}
			  }	
			 
  		 }
	
	return true;
}	

function getServiceCentreSession(departmentId){
	document.getElementById('testDiv').innerHTML='';
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	if(departmentId!="0"){
		new Ajax.Request(
				'appointment?method=getServiceCentreSession&departmentId=' + departmentId+ '&hospitalId=' + hospitalId +'&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							var data=response.responseText;
							var dt=data.toString();
							var result = dt.slice(1, -1);
							
							var session=result.split(",");
							var select;
							if(document.getElementById('opsession')){
								document.getElementById('opsession').options.length = 0;
								select = document.getElementById('opsession');
							}
					
							for(var index=0;index<session.length;index++){
								
								var sessionData=session[index].split(":");
								var opt = document.createElement('option');
								opt.value = sessionData[0].trim();
							    opt.innerHTML = sessionData[1].trim();
							    select.appendChild(opt);
							    
							}
							
						}
					}
				});
	}
	  
}	

function checkSession(){
	var sessionId = 	document.getElementById('opsession').value;
	if(sessionId!=0){
		return true;
	}
	
	return false;
}

</script>
