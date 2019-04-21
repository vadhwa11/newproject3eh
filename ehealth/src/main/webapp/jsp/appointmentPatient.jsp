<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientAppointments.jsp
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.sql.Time"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<script type="text/javascript"
src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="patientAppointments" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
        type="text/javascript" language="javascript"><!--
        <%

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
                serverdate = '<%=date+"/"+month+"/"+year%>'


                function openPopUp(inc)
                {

                        window.open('appointment?method=showExistingPatients&serviceNo='+document.getElementById("serviceNo"+inc).value+'&counter='+inc,'mywindow','location=1,status=1,scrollbars=1,width=500,height=300');
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
                                        if(document.getElementById("hinId"+i)!=null)
                                        {
                                                document.getElementById("hinId"+i).disabled=true;
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
                                document.getElementById('employeeId'+inc).setAttribute('validate','Doctor,string,yes');
                                if(document.getElementById("hinNo"+inc)!=null)
                                {

                                        document.getElementById("hinNo"+inc).disabled=false;
                                        document.getElementById("hinNo"+inc).readOnly=false;
                                }

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
                                        //document.getElementById("sex"+inc).readOnly=false;
                                }
                                if(document.getElementById("age"+inc)!=null)
                                {
                                        document.getElementById("age"+inc).disabled=false;
                                        document.getElementById("age"+inc).readOnly=false;
                                }
                                if(document.getElementById("ageUnit"+inc)!=null)
                                {
                                        document.getElementById("ageUnit"+inc).disabled=false;
                                        //document.getElementById("ageUnit"+inc).readOnly=false;
                                }
                                if(document.getElementById("employeeId"+inc)!=null)
                                {
                                        document.getElementById("employeeId"+inc).disabled=true;
                                        document.getElementById("employeeId"+inc).readOnly=true;
                                }
                                //submitProtoAjaxWithDivName('patientAppointments','appointment?method=showListBasedonNone&inc='+inc,'testDiv'+inc);
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
                                        if(document.getElementById("hinId"+inc)!=null)
                                        {
                                                document.getElementById("hinId"+inc).disabled=true;
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
<div class="titleBg"><h2>OPD Patient Appointment</h2></div>
<div class="clear"></div>

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
                                 List<OpdHoliday>holidayList=new ArrayList<OpdHoliday>();
                                 List<Patient> registeredPatientList = new ArrayList<Patient>();
                                 List<Patient>listBasedonHinNo=new ArrayList<Patient>();
                                 List<AppPatientAppointments>slotAvailableList=new ArrayList<AppPatientAppointments>();
                                 List<AppPatientAppointments> patientAppointmentsList=new ArrayList<AppPatientAppointments>();
                                List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
                                 String[][] calculatedSlotList=null;
                                 Integer[] noOfDoctorsList=null;
                                 String breakToTime=null;
                                 boolean patientNameExist = false;
                                 boolean recordExists=false;
                                 String alertMessage=null;
                                 int doctorId=0;

                                 int counter=0;
                                 Calendar c_currentTime=Calendar.getInstance();
                                 Properties properties = new Properties();
                                 URL resourcePath = Thread.currentThread().getContextClassLoader()
                                 .getResource("adt.properties");
                                 try {
                                 properties.load(resourcePath.openStream());
                                 } catch (Exception e) {
                                 e.printStackTrace();
                                 }
                                 String empCategoryCodeForDoctor =
properties.getProperty("empCategoryCodeForDoctor");




                            //c_currentTime.setTime(Time.valueOf(currentTime));

                                if (map.get("departmentList") != null) {
                                        departmentList = (List<MasDepartment>) map.get("departmentList");

                                 }
                                if (map.get("slotAvailableList") != null) {
                                	slotAvailableList = (List<AppPatientAppointments>) map.get("slotAvailableList");

                             }
                                
                                if (map.get("patientAppointmentsList") != null) {
                                	patientAppointmentsList = (List<AppPatientAppointments>) map.get("patientAppointmentsList");

                             }

                                if(map.get("listBasedonHinNo")!=null){
                                        listBasedonHinNo=(List<Patient>)map.get("listBasedonHinNo");
                                }
                                if (map.get("employeeList") != null) {
                                        employeeList = (List<MasEmployee>) map.get("employeeList");

                                 }
                                if (map.get("holidayList") != null) {
                                        holidayList = (List<OpdHoliday>) map.get("holidayList");

                                 }
                                if(map.get("slotList")!=null)
                                {
                                        calculatedSlotList=(String [][])map.get("slotList");
                                }
                                if(map.get("noOfDoctorsList")!=null)
                                {
                                        noOfDoctorsList=(Integer[])map.get("noOfDoctorsList");
                                }

                                if(map.get("employeeList") != null){
                                        doctorList = (List<MasEmployee>)map.get("employeeList");
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
                                        %> <span> <%=message %></span>
<div class="clear"></div>
<%

                                }
                                 else if(map.get("actualAvailableAppointments")!=null)
                                 {
                                         int actualAvailableAppointments=
(Integer)map.get("actualAvailableAppointments");
                                 %>
<MARQUEE direction="right" loop="20" width="100%"><%=actualAvailableAppointments+" "
%>Appointments are available.. !!</MARQUEE>
<div class="clear"></div>
<!--<marquee height=20 width="auto" align="right" direction="right"
                                           behavior="scroll"><font color=blue style="font-weight: bold;font-size: large">
                                           </font></marquee>--> <%        }

                                 if(map.get("patientNameExist")!=null || map.get("recordExists")!=null)
                                 {
                                         if(map.get("recordExists")!=null)
                                         {
                                                 recordExists=(Boolean)map.get("recordExists");
                                         }
                                         patientNameExist=(Boolean)map.get("patientNameExist");
                                         if(patientNameExist==true || recordExists==true)
                                         {
                                         %>
                                         <input type="hidden" id="returnDeptId" name="returnDeptId" value="<%=map.get("departmentId")%>" />
       
                                         <input type="hidden" id="returnPatientName" name="returnPatientName"  value="<%=map.get("patientName") %>" />

                                         <input type="hidden" id="returnSex" name="returnSex" value="<%=map.get("sex") %>" />

                                         <input type="hidden" id="returnAge" name="returnAge" value="<%=map.get("age") %>" />

                                         <%if(map.get("ageUnit")!=null){%>
                                         <input        type="hidden" id="returnAgeUnit" name="returnAgeUnit" value="<%=map.get("ageUnit") %>" />

                                         <%}else{ %>
                                         <input type="hidden" id="returnAgeUnit" name="returnAgeUnit" value="" />
                                         <%} %>
                                          <input        type="hidden" id="returnAppointmentDate"
name="returnAppointmentDate"        value="<%=map.get("appointmentDate") %>" />
                                          <input type="hidden" id="returnStartTime" name="returnStartTime"
value="<%=map.get("fromTimeSlot") %>" />
                                          <input type="hidden" id="returnEndTime"
name="returnEndTime"        value="<%=map.get("toTimeSlot") %>" />
<%if(map.get("doctorId")!=null){%>
                                          <input type="hidden" id="returnDoctorId"
name="returnDoctorId"        value="<%=map.get("doctorId") %>" />
                                          <%}else{ %>
                                          <input type="hidden"        id="returnDoctorId" name="returnDoctorId" value="" />
                                          <%} %> <%if(map.get("doctorId")!=null){%>
                                          <input type="hidden" id="returnDoctorId"
name="returnDoctorId"        value="<%=map.get("doctorId") %>" />
        <%}else{ %>
        <input type="hidden"        id="returnDoctorId" name="returnDoctorId" value="" />
        <%} %> <%if(map.get("mobileNo")!=null){%>
<input type="hidden" id="returnMobileNo" name="returnMobileNo"
        value="<%=map.get("mobileNo") %>" /> <%}else{ %> <input type="hidden"
        id="returnMobileNo" name="returnMobileNo" value="" /> <%} %>
<%if(map.get("hinId")!=null){%>
<input type="hidden" id="returnHinId" name="returnHinId"
        value="<%=map.get("hinId") %>" /> <%}else{ %> <input type="hidden"
        id="returnHinId" name="returnHinId" value="" /> <%} %> <%if(recordExists==true)
                                         {
                                                 alertMessage="You have already taken appointment for Dept:" +
map.get("existingDept")+" at "+ map.get("existingStartTime")+ " - "+
map.get("existingEndTime");
                                         }
                                         else
                                         {
                                                 alertMessage="Duplicate Patient Name!!!";
                                         }
                                         boolean duplicateRecord = false;
                                         duplicateRecord =  (Boolean)map.get("duplicateRecord");
                                         %> <Script>
                                                 var fl = '<%=duplicateRecord%>';
                                                 if(confirm('<%=alertMessage%>') && fl=="false")
                                                 {
                                                         // submitForm('patientAppointments','appointment?method=submitDulicatePatientNameAppointment'); 
                                                	 submitForm('messageForm','/hms/hms/registration?method=showOnlineAppointmentJsp');
                                                 }
                                         </script> <%                }
                                 }%> <%                int i=0;
                                if(holidayList!=null){
                                        if(holidayList.size()>0){


                                                        Iterator ite = holidayList.iterator();
                                                        while ( ite.hasNext() ) {
                                                         OpdHoliday opdHoliday=(OpdHoliday)  ite.next();

                %> <script>

                                                         holidayArray[<%=i%>]= new Array();
                                                                holidayArray[<%=i%>][0] = "<%=opdHoliday.getHolidayName()%>";
                                                                holidayArray[<%=i%>][1] =
"<%=HMSUtil.changeDateToddMMyyyy(opdHoliday.getHolidayDate())%>";

                                                                </script> <%
                                                         i++;
                                                    }
                                                 }
                                }
                %> <!--Block One Starts-->

<%-- --
////**commented by anand for doctor appoientment**//
<label>Department</label> <select
        id="departmentId" name="<%=DEPARTMENT_ID%>"
        validate="Department,number,no">
        <option value="0">Select</option>
        <%
                                //int deptId=(Integer)session.getAttribute("deptId");
                                //if(departmentList!= null){
                                //for (MasDepartment masDepartment : departmentList) {
                                        //if(masDepartment.getId()==deptId){
                        %>

        <option value="<%=masDepartment.getId()%>"
selected="selected"><%=masDepartment.getDepartmentName()%></option><%
        }
                --                        //else{%>
        <option
value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
        %--!>
                //                        }
                        //        }
                        //}
                        //%>
//</select> -->--%>

<div class="Block">
<%-- <label>Department</label>
<select id="diagnosisId" name="<%=DEPARTMENT_ID%>"
        validate="Department,number,no" onblur="populateDoctorName(this.value,'patientAppointments');" onchange="populateDoctorName(this.value,'patientAppointments');">
<option value="0">Select</option>
        <%
                                int deptId=(Integer)session.getAttribute("deptId");
                                if(departmentList!= null){
                                for (MasDepartment masDepartment : departmentList) {
                                        if(masDepartment.getId()==deptId){
                        %>
        <option value="<%=masDepartment.getId()%>"
selected="selected"><%=masDepartment.getDepartmentName()%></option>

        <%
                        }else{%>
        <option
value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
        <%
                                        }
                                }
                        }
                        %>
</select> --%>

<!--Code By Anand-->
 <%--  <label><span>*</span> Consulting Doc.</label>
<select name="<%=CONSULTING_DOCTOR %>" id="employeeId123"  tabindex="41"  >
<option value="0">Select</option>
<%
for(MasEmployee masEmployee : doctorList){
        doctorId = masEmployee.getId();
if(masEmployee.getEmpCategory() != null){
        if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
//if(departmentId == masEmployee.getDepartment().getId())
//{
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%><%=" "+masEmployee.getLastName() %></option>
<%                                }
//}
}
} %>
</select>
 --%>
<script type="text/javascript">
<%
int j = 0;
for(MasDepartment masDepartment : departmentList){
for (MasEmployee masEmployee : doctorList)
{
if(masEmployee.getDepartment() != null){
if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
if(masDepartment.getId()==masEmployee.getDepartment().getId()){
%>
doctorArray[<%=j%>] = new Array();
doctorArray[<%=j%>][0] = <%=masDepartment.getId()%>;
doctorArray[<%=j%>][1] = <%=masEmployee.getId()%>;
doctorArray[<%=j%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

<%
j++;
}
}
}
}
}
%>
</script>

<%-- <label>Appointment Date</label>
<input type="text" id="appointmentdate"        name="<%=APPOINTMENT_DATE %>" value=""
maxlength="30"        readonly="readonly" class="date" />
<img src="/hms/jsp/images/cal.gif"        width="16" height="16" border="0" validate="Pick
a date"        onclick="setdate('<%=currenDate
%>',document.patientAppointments.<%=APPOINTMENT_DATE%>,event);" />
<div class="clear"></div>

<label>Selected Department</label>
<input type="hidden" id="departmentId" name="<%=WARD_ID%>"  value="<%=box.getInt(DEPARTMENT_ID)%>" />

 <%
    if(departmentList!=null && departmentList.size()>0)
    {
             Iterator ite=departmentList.iterator();
             while ( ite.hasNext() ) {
                     MasDepartment masDepartment=(MasDepartment)ite.next();
                     if(masDepartment.getId()==box.getInt(DEPARTMENT_ID))
                     {


     %>
     <input type="text" class="readOnly" name="dep"        readonly="readonly"
value="<%=masDepartment.getDepartmentName()%>" />
<%                }

             }
    }else if(departmentList!=null && departmentList.size()==0){%> <input
        type="text" class="readOnly" name="dep" readonly="readonly" value="-" />
<%         }

    %> --%>
    <label>Selected Appointment Date</label> <input type="hidden"
        id="apmtDate" name="<%=APMT_DATE%>"
        value="<%=box.getString(APPOINTMENT_DATE)%>" /> <%String tempDate=
box.getString(APPOINTMENT_DATE); %>
<label class="value"><%= tempDate %></label>
<div class="clear"></div>
</div>

<div class="clear"></div>
<!--Block one Ends-->
<div class="paddingTop15"></div>
<!--Block Three Starts-->
<%-- <table border="0" cellspacing="0" cellpadding="0">
        <tr>
                <th>&nbsp;</th>
                <th scope="col">Time Slot</th>
                <th scope="col">Slots Available</th>
                <th scope="col">Appointment Criteria</th>
                <th scope="col">HIN</th>
                <th colspan="5" scope="col">
                       <span style="color: #FFF; padding-left: 24px; float: left;">Patient Name </span>
                       <span style="color: #FFF; padding-left: 28px; float: left;">Mobile  No.</span>
                       <span style="color: #FFF; padding-left: 35px; float: left;">Sex</span>
                       <span style="color: #FFF; padding-left: 60px; float: left;">Age</span></th>
                <th scope="col">Doctor's<br /> Name</th>
               
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

                                            Date
apmtDate=HMSUtil.convertStringTypeDateToDateType(box.getString(APPOINTMENT_DATE));
                            %>
        <tr>
                <%        if(noOfDoctorsList[inc] != null && noOfDoctorsList[inc] > 0 )
                                    {
                                       if
(apmtDate.compareTo(HMSUtil.convertStringTypeDateToDateType(currenDate))==0
&& c_calculatedTime.getTime().before(Time.valueOf(currentTimeinformat)))
                                       {
                            %>
                <td><input type="radio" class="radioCheck" id="parent"
                        name="parent" value=""
                        onclick="disableFields(<%=counter%>,<%=inc%>);" disabled="disabled" /></td>

                <%}else { %>
                <td><input type="radio" class="radioCheck" id="parent"
                        name="parent" value=""
                        onclick="disableFields(<%=counter%>,<%=inc%>);" /></td>
                <%
                                            }
                                    }else {
                            %>
                <td><input type="radio" class="radioCheck" id="radio"
                        name="parent" value=""
                        onclick="disableFields(<%=counter%>,<%=inc%>);" disabled="disabled" /></td>
                <%
                                            }
                                    %>
                <%StringTokenizer st1=new StringTokenizer(calculatedSlotList[inc][0],":");%>
                <%StringTokenizer st2=new StringTokenizer(calculatedSlotList[inc][1],":"); %>

                <td><label><%=st1.nextToken()%>:<%=st1.nextToken()%>&nbsp;</label>
                <label>- <%=st2.nextToken()%>:<%=st2.nextToken()%></label> 
                <input type="hidden" id="fromTimeSlot<%=inc %>" 
                name="<%=FROMTIMESLOT%>"  value="<%=calculatedSlotList[inc][0]%>" /> <input type="hidden"
                        id="toTimeSlot<%=inc %>" name="<%=TOTIMESLOT%>"
                        value="<%=calculatedSlotList[inc][1]%>" /></td>
                <%if(noOfDoctorsList[inc] != null && noOfDoctorsList[inc] > 0){ %>
                <td><%=noOfDoctorsList[inc]%></td>
                <%}else{%>
                <td>NIL</td>
                <%}%>
                <%
                if(patientAppointmentsList.size()>0){ 
                for(AppPatientAppointments appPatientAppointments : patientAppointmentsList)
                {
                	
                if(appPatientAppointments.getFromTimeSlot().equalsIgnoreCase(calculatedSlotList[inc][0]))
                {
                %>
                
                  <td><select id="hin_service<%=inc%>" class="small"
                        name="<%=SELECTED_RADIO%>" disabled="disabled" selected="selected"
                        onchange="disableHinService(this.value,<%=inc%>);">
                        <option value="0">Select</option>
                        <option value="hinNo">HIN</option>
                        <option value="none">None</option>
                </select></td>

                <td><input type="text" size=10 id="hinNo<%=inc %>"
                        name="<%=HIN_NO%>" disabled="disabled"  value="<%=appPatientAppointments.getHin().getHinNo() %>"
                        onblur="submitProtoAjaxWithDivNameForAppointment('patientAppointments','/hms/hms/appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc%>');" />
                </td>

                <td colspan="5" id="testDiv<%=inc %>">
                <input type="hidden"
                        id="hinId<%=inc%>" name="<%=HIN_ID %>" disabled="disabled"  value="<%=appPatientAppointments.getHin().getId()%>" />

                 <input
                        type="text" size=16 id="patientName<%=inc %>"
                        name="<%=PATIENT_NAME%>" disabled="disabled" MAXLENGTH="30" value="<%=appPatientAppointments.getPatientName() %>"
                        validate="Patient Name,string,no" class="floatLeft" />

                        <input         type="text" size=10 id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>"
                        disabled="disabled" MAXLENGTH="10" validate="Mobile No.,int,no" value="<%=appPatientAppointments.getMobileNo() %>"
                        class="floatLeft" />
                <select id="sex<%=inc%>" name="<%=SEX%>"
                        disabled="disabled" class="smallFltLeft">
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                </select>
                <%String age="";
                String age1="";
                age=appPatientAppointments.getAge();
                age1=age.substring(0,3);
                %>
                 <input type="text" id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2" value="<%=age1%>"
                   disabled="disabled" size="1" />
<input type="text" id="ageUnit<%=inc%>" name="<%=AGEUNIT%>%>" MAXLENGTH="2" value="<%=""%>"
                   disabled="disabled" size="1" />
                
         </td>

                <td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"
                        disabled="disabled">
                        <option value="0">Select</option>
                        <%
                                                                        if(employeeList!= null){
                                                                                for (MasEmployee masEmployee : employeeList) {
                                                                                	
                                                                %>
                        <option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()%><%=masEmployee.getLastName() %><</option>
                        <%        }
                                                                        }
                                                                        %>
                </select>
                <script type="text/javascript">
<%  if( box.getInt(CONSULTING_DOCTOR) != 0){
int counsultId = box.getInt(CONSULTING_DOCTOR) ;
%>
document.patientAppointments.employeeId<%=inc%>.value = '<%=counsultId %>';
//document.getElementById(employeeId<%=inc%>).disabled = false;
<%
}%>
</script>
                </td>
                
                <% }else { %>
                
                <td><select id="hin_service<%=inc%>" class="small"
                        name="<%=SELECTED_RADIO%>" disabled="disabled"
                        onchange="disableHinService(this.value,<%=inc%>);">
                        <option value="0">Select</option>
                        <option value="hinNo">HIN</option>
                        <option value="none">None</option>
                </select></td>

                <td><input type="text" size=10 id="hinNo<%=inc %>"
                        name="<%=HIN_NO%>" disabled="disabled"
                        onblur="submitProtoAjaxWithDivNameForAppointment('patientAppointments','/hms/hms/appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc%>');" />
                </td>

                <td colspan="5" id="testDiv<%=inc %>">
                <input type="hidden"
                        id="hinId<%=inc%>" name="<%=HIN_ID %>" disabled="disabled" />

                 <input
                        type="text" size=16 id="patientName<%=inc %>"
                        name="<%=PATIENT_NAME%>" disabled="disabled" MAXLENGTH="30"
                        validate="Patient Name,string,no" class="floatLeft" />

                        <input         type="text" size=10 id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>"
                        disabled="disabled" MAXLENGTH="10" validate="Mobile No.,int,no"
                        class="floatLeft" />
                <select id="sex<%=inc%>" name="<%=SEX%>"
                        disabled="disabled" class="smallFltLeft">
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                </select>
                 <input type="text" id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
                   disabled="disabled" size="1" />

                <select id="ageUnit<%=inc%>"
                          name="<%=AGEUNIT%>" disabled="disabled" class="small">
                <option value="0">Select</option>
                        <option value="Years">Years</option>
                        <option value="Months">Months</option>
           </select>
         </td>

                <td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"
                        disabled="disabled">
                        <option value="0">Select</option>
                        <%
                                                                        if(employeeList!= null){
                                                                                for (MasEmployee masEmployee : employeeList) {
                                                                                	System.out.println(">>>>>>>>"+employeeList.size());
                                                                %>
                        <option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
                        <%        }
                                                                        }
                                                                        %>
                </select>
                <script type="text/javascript">
<%  if( box.getInt(CONSULTING_DOCTOR) != 0){
int counsultId = box.getInt(CONSULTING_DOCTOR) ;
%>
document.patientAppointments.employeeId<%=inc%>.value = '<%=counsultId %>';
//document.getElementById(employeeId<%=inc%>).disabled = false;
<%
}%>
</script>
                </td>
                <% }}}else {%>
                <td><select id="hin_service<%=inc%>" class="small"
                        name="<%=SELECTED_RADIO%>" disabled="disabled"
                        onchange="disableHinService(this.value,<%=inc%>);">
                        <option value="0">Select</option>
                        <option value="hinNo">HIN</option>
                        <option value="none">None</option>
                </select></td>

                <td><input type="text" size=10 id="hinNo<%=inc %>"
                        name="<%=HIN_NO%>" disabled="disabled"
                        onblur="submitProtoAjaxWithDivNameForAppointment('patientAppointments','/hms/hms/appointment?method=showListBasedonHinNo&inc=<%=inc%>&hinNo='+this.value,'testDiv<%=inc%>');" />
                </td>

                <td colspan="5" id="testDiv<%=inc %>">
                <input type="hidden"
                        id="hinId<%=inc%>" name="<%=HIN_ID %>" disabled="disabled" />

                 <input
                        type="text"  id="patientName<%=inc %>"
                        name="<%=PATIENT_NAME%>" disabled="disabled" MAXLENGTH="30"
                        validate="Patient Name,string,no" />

                        <input         type="text" size=10 id="mobileNo<%=inc %>" name="<%=MOBILE_NO%>"
                        disabled="disabled" MAXLENGTH="10" validate="Mobile No.,int,no"
                         />
                <select id="sex<%=inc%>" name="<%=SEX%>"
                        disabled="disabled" class="small">
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                </select>
                 <input type="text" id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
                   disabled="disabled" size="1" />

                <select id="ageUnit<%=inc%>"
                          name="<%=AGEUNIT%>" disabled="disabled" class="small">
                <option value="0">Select</option>
                        <option value="Years">Years</option>
                        <option value="Months">Months</option>
           </select>
         </td>

                <td><select id="employeeId<%=inc%>" name="<%=EMPLOYEE_ID%>"
                        disabled="disabled">
                        <option value="0">Select</option>
                        <%
                                                                        if(employeeList!= null){
                                                                                for (MasEmployee masEmployee : employeeList) {
                                                                                	
                                                                %>
                        <option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
                        <%        }
                                                                        }
                                                                        %>
                </select>
                <script type="text/javascript">
<%  if( box.getInt(CONSULTING_DOCTOR) != 0){
int counsultId = box.getInt(CONSULTING_DOCTOR) ;
%>
document.patientAppointments.employeeId<%=inc%>.value = '<%=counsultId %>';
//document.getElementById(employeeId<%=inc%>).disabled = false;
<%
}%>
</script>
                </td>
        </tr>

        <%                        }}
                            else
                            {
  %>
        <tr>
                <td>&nbsp;</td>
                <td><label>BREAK</label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td colspan="5">&nbsp;</td>
        </tr>

        <%                          }
                            }
   %>
</table> --%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<%if(showSubmitButton==true){ %>
<input name="S" type="button"        class="button"
value="Submit"        onclick="if(validateAppointmentRadio())submitForm('patientAppointments','appointment?method=submitPatientAppointment','validateAgeOnSubmit');"
/>
<input name="B" type="reset" class="buttonHighlight"
value="Reset"        onclick="resetAppointmentSetup();" />
<%} %>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By </label> <label
        class="value"><%=userName %></label> <label>Changed Date </label> <label
        class="value"><%=currenDate %></label> <label>Changed Time </label> <label
        class="value"><%=currentTime%></label>

<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<!--Bottom labels ends--></form>
<script type="text/javascript">

function validateAppointmentRadio(){

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
                              if(trimAll(document.getElementsByName('patientName')[i].value)=="")
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
                                                        msg += "HIN can not be blank in row "+i+".\n";
                                                }
                                        }
                                        if(document.getElementsByName('selectedRadio')[i].value=="none" ||
document.getElementsByName('hinNo')[i].value=="")
                                        {
                                                if(document.getElementsByName('ageUnit')[i].value=="0")
                                                {
                                                    //    msg += "Select Age Unit in row "+i+".\n";
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




function resetAppointmentSetup(){
                         for(var i = 0; i < document.getElementsByName('parent').length; i++){
                          if(document.getElementsByName('parent')[i].checked == true )
              {
			                      document.getElementsByName('selectedRadio')[i].disabled=true;
			                      document.getElementsByName('patientName')[i].disabled=true;
	                                document.getElementsByName('sex')[i].disabled=true;
	                                document.getElementsByName('age')[i].disabled=true;
	                                document.getElementsByName('ageUnit')[i].disabled=true;
	                                document.getElementsByName('hinNo')[i].disabled=true;
	                                document.getElementsByName('employeeId')[i].disabled=true;
	                                document.getElementsByName('mobilNo')[i].disabled=true;


                        }
                  }
                  return true;

        }

function validateAgeOnSubmit()
{
 for(var i = 0; i < document.getElementsByName('parent').length; i++)
 {
                          if(document.getElementsByName('parent')[i].checked == true )
              {
                      var submitAge=document.getElementsByName('age')[i].value;
                      var pos=submitAge.indexOf('',1)
                      //alert("pos-->"+pos)
                      var subAge=submitAge.substring(0,pos);
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
function checkForAppmtDate()
{
        var dept=document.getElementById('departmentId').value;
        var appointmentDate=document.getElementById('appointmentdate').value;
        if(dept!=0 && appointmentDate!="")
        {
                submitForm('patientAppointments','appointment?method=showAppointmentPatientDepartmentWise','isApptGrCurrentDate1','checkForHoliday');
                return true;
        }
        else
        {
                return false;
        }
}

//var doctorArray = new Array();
 function populateDoctorName(val,formName){
	obj = eval('document.'+formName+'.employeeId123');
	obj.length = 1;
	
	for(i=0;i<doctorArray.length;i++){
		if(doctorArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=doctorArray[i][1];
			obj.options[obj.length-1].text=doctorArray[i][2];
		}
	}
} 
</script>


<!--main content placeholder ends here-->