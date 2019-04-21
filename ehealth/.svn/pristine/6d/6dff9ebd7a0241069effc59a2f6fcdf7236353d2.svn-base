<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appSetup.jsp
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>

<%@page import="jkt.hms.masters.business.DialysisSetup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.RequestConstants"%> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<!--main content placeholder starts here-->

<form name="dialysisSetup" method="post" action="">
<script	type="text/javascript" language="javascript">
var deptSelected=false;
var drSelected=false;
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


	function validateMandatoryFields()
	{
		var inc=0;
		for(inc=0;inc<7;inc++)
		{
			/*coment by anand for doctor appoientment**/
			//if(document.getElementById("dr"+inc).value!="" )
			//{
			//	if(document.getElementById("fromTime"+inc).value=="" || document.getElementById("toTime"+inc).value=="" || document.getElementById("slotDuration"+inc).value=="" )
				//{
					//alert("Please fill From Time, To Time, Slot Duration");
					//return false;
				//}
			//}
			//if(document.getElementById("dr"+inc).value==" " || document.getElementById("dr"+inc).value=="")
			//{
				//if(document.getElementById("fromTime"+inc).value!="" || document.getElementById("toTime"+inc).value!="" || document.getElementById("slotDuration"+inc).value!="" )
//				{
	//				alert("Please fill No. of Doctors, From Time, To Time, Slot Duration");
		//			return false;
			//	}
			//}
			if(document.getElementById('fromTime'+inc).value!="" && document.getElementById('toTime'+inc).value!="")
			{
				if(document.getElementById('fromTime'+inc).value >= document.getElementById('toTime'+inc).value)
				{
					if(!displayAlert("'From Time' should be less than 'To Time' for row "+ eval(inc+1)))
						alert("'From Time' should be less than 'To Time' for row "+ eval(inc+1));
					document.getElementById('fromTime'+inc).style.boxShadow="";
					document.getElementById('fromTime'+inc).style.boxShadow="0px 0px 2px 1px red";
					document.getElementById('toTime'+inc).style.boxShadow="";
					document.getElementById('toTime'+inc).style.boxShadow="0px 0px 2px 1px red";
					return false;
				}
			}
			/* if(document.getElementById('breakFromTime'+inc).value!="" && document.getElementById('breakToTime'+inc).value!="")
			{
				if(document.getElementById('breakFromTime'+inc).value >= document.getElementById('breakToTime'+inc).value)
				{
					if(!displayAlert("'Break From Time' should be less than 'Break To Time' for row "+ eval(inc+1)))
						alert("'Break From Time' should be less than 'Break To Time' for row "+ eval(inc+1));
					document.getElementById('breakFromTime'+inc).style.boxShadow="";
					document.getElementById('breakFromTime'+inc).style.boxShadow="0px 0px 2px 1px red";
					document.getElementById('breakToTime'+inc).style.boxShadow="";
					document.getElementById('breakToTime'+inc).style.boxShadow="0px 0px 2px 1px red";
					return false;
				}
			} */
		}
		return true;
	}


function compareTime()
{
	if(document.getElementById('fromTime').value >= document.getElementById('toTime').value)
	{
		if(!displayAlert("From Time should be less than To Time"))
			alert("From Time should be less than To Time");
		document.getElementById('fromTime').style.boxShadow="";
		document.getElementById('fromTime').style.boxShadow="0px 0px 2px 1px red";
		document.getElementById('toTime').style.boxShadow="";
		document.getElementById('toTime').style.boxShadow="0px 0px 2px 1px red";
		return false;
	}
	return true;

}
function checkDept()
{
	if(deptSelected==false){
		if(!displayAlert("Select department!!"))
			alert("Select department!!");
		document.getElementById('diagnosisId').style.boxShadow="";
		document.getElementById('diagnosisId').style.boxShadow="0px 0px 2px 1px red";
		return false;
	}
	return true;
}
function checkDr()
{
	if(drSelected==false){
		if(!displayAlert("Select doctor!!"))
			alert("Select doctor!!");
		document.getElementById('consultingDocId1').style.boxShadow="";
		document.getElementById('consultingDocId1').style.boxShadow="0px 0px 2px 1px red";
		return false;
	}
	return true;
}


function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/appointment?method=printAppointmentSetupJsp";
  obj.submit();
}

function IsValidTimeForSlotDuration(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.

	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
		if(!displayAlert("Time should be in HH:MM:SS format."))
			alert("Time should be in HH:MM:SS format.");
		obj.style.boxShadow = "";
		obj.style.boxShadow = "0px 0px 2px 1px red";
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 23) {
		if(!	("Hour must be between 0 and 23."))
			alert("Hour must be between 0 and 23.");
		obj.style.boxShadow = "";
		obj.style.boxShadow = "0px 0px 2px 1px red";
		return false;
	}
	if (minute<0 || minute > 59) {
		if(!displayAlert("Minute must be between 0 and 59."))
			alert("Minute must be between 0 and 59.");
		obj.style.boxShadow = "";
		obj.style.boxShadow = "0px 0px 2px 1px red";
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		if(!displayAlert("Second must be between 0 and 59."))
			alert("Second must be between 0 and 59.");
		obj.style.boxShadow = "";
		obj.style.boxShadow = "0px 0px 2px 1px red";
		return false;
	}
	if (hour<=00 && minute<05) {
		if(!displayAlert("Slot duration must be atleast 5 min."))
			alert("Slot duration must be atleast 5 min.");
		obj.style.boxShadow = "";
		obj.style.boxShadow = "0px 0px 2px 1px red";
		return false;
	}
	return false;
}

	</script>
<div class="titleBg">
<h2>Dialysis Scheduling Setup</h2>
</div>
<div class="clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	Box box=HMSUtil.getBox(request);

			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");

			 	String url=null;
			 	String[] day=new String[7];

			 	int doctorId = 0;

			 	day[0]="Sunday";
			 	day[1]="Monday";
			 	day[2]="Tuesday";
			 	day[3]="Wednesday";
			 	day[4]="Thursday";
			 	day[5]="Friday";
			 	day[6]="Saturday";

			 	Map<String, Object> map = new HashMap<String, Object>();

			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}


			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
			 	List<DialysisSetup> dialysisSetupList = new ArrayList<DialysisSetup>();

				if (map.get("dialysisSetupList") != null) {
					dialysisSetupList = (List<DialysisSetup>) map.get("dialysisSetupList");
			 	}
				System.out.println("dialysisSetupList=="+dialysisSetupList.size());
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");

			 	}
				if(map.get("employeeList") != null){
					doctorList = (List<MasEmployee>)map.get("employeeList");
					}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <span><%=message %></span> <%

					  }

			 	Properties properties = new Properties();
			 	URL resourcePath = Thread.currentThread().getContextClassLoader()
			 	.getResource("adt.properties");
			 	try {
			 	properties.load(resourcePath.openStream());
			 	} catch (Exception e) {
			 	e.printStackTrace();
			 	}
			 	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			 	String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
			 %> <!--Block One Starts-->

<div class="Block">

<label>Department</label> 
<select id="diagnosisId" name="<%=WARD_ID%>" 	validate="Department,number,no" 
	>
	<option value="0">Select</option>
	<%
	int deptId=0;
	if(session.getAttribute("deptId")!=null){
				deptId=(Integer)session.getAttribute("deptId");}
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					  if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(depTypeCodeDialysis)){
			%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>

	<%
			}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
					}
				}
			}
			%>
</select>

<!--Code By Anand--> 
<%-- <label>Consulting Doc.<span>*</span></label>
<select name="<%=CONSULTING_DOCTOR %>" id="consultingDocId1"  tabindex="41" Validate="Consulting Doc.,string,yes">
<!-- onchange="submitForm('dialysisSetup','appointment?method=getRecords');"
	onblur="submitForm('dialysisSetup','appointment?method=getRecords');" --> 
<option value="0">Select</option>
<%
String firstName="";
String lastName="";
for(MasEmployee masEmployee : doctorList){
        doctorId = masEmployee.getId();
if(masEmployee.getEmpCategory() != null){
        if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
	//if(departmentId == masEmployee.getDepartment().getId())
	//{
	firstName=masEmployee.getFirstName();
	if(masEmployee.getLastName() !=null){
		lastName=masEmployee.getLastName();
	}
	firstName=firstName+" "+lastName;
%>
<option value="<%=masEmployee.getId() %>"><%=firstName%></option>
<%                                }
//}
}
} %>
</select> --%>

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
doctorArr[<%=j%>] = new Array();
doctorArr[<%=j%>][0] = <%=masDepartment.getId()%>;
doctorArr[<%=j%>][1] = <%=masEmployee.getId()%>;
doctorArr[<%=j%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

<%
j++;
}
}
}
}
}
%>
</script>

 <!-- <input name="Print" class="buttonBig" type="button" value="Generate Report" target="_blank"
	onclick="showReport('dialysisSetup');" /> --> <!--Block one Ends-->
<div class="clear"></div>
<div class="clear"></div>

<!--Block Three Starts--> <%
	int deptMap;
	if(box.getInt(DEPARTMENT_ID)==0)
		deptMap=(Integer)map.get("deptIdinMap");
	else
		deptMap=box.getInt(DEPARTMENT_ID);

if (dialysisSetupList!=null)
{
%>  
<input type="hidden" id="departmentId" name="<%=WARD_ID%>" value="<%=deptMap%>"   /> 
<%

    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==deptMap)
     		{


     %> <script type="text/javascript">deptSelected=true;</script> 
     
     <!--<label class="value"> </label> -->
     
<%-- <label>Selected Department</label>
<input type="text" value="<%=masDepartment.getDepartmentName()%>" Validate="Service Centre,string,yes"/> --%>
     
     <%}	 }    }   %>
     
<!--Code By Anand--> 
  
<!--Block Counsulting Doctor Starts--> <%
	int deptMap1;
	if(box.getInt(CONSULTING_DOCTOR)==0)
		deptMap1=(Integer)map.get("drIdinMap");
	else
		deptMap1=box.getInt(CONSULTING_DOCTOR);

if (dialysisSetupList!=null)
     {
    %> 
    
<input type="hidden" id="consultingDocId" name="<%=CONSUNTANT%>" value="<%=deptMap1%>"   /> 

<%
    	 Iterator ite=doctorList.iterator();
    	 while ( ite.hasNext() ) {
    		 MasEmployee masEmployee=(MasEmployee)ite.next();
     		//MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masEmployee.getId()==deptMap1)
     		{


     %> <script type="text/javascript">drSelected=true;</script> 
     
     <!--<label	class="value"> </label>-->
     <label>Selected Doctor</label>
     <input type="text" value="<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>" />
     
      <%		}    	 }     }    %>
<div class="clear"></div>
</div>
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Days</th>
		<!--<th scope="col">No. of Doctors</th>
		--><th scope="col">From Time</th>
		<th scope="col">To Time</th>
		<th scope="col">Slot Duration</th>
		<!-- <th scope="col">% for Slot</th>
		<th scope="col">Break From Time</th>
		<th scope="col">Break To Time</th>
		<th scope="col">Break From Time 2</th>
		<th scope="col">Break To Time 2</th>
		<th scope="col">Break From Time 3</th>
		<th scope="col">Break To Time 3</th>
		<th scope="col">Max No. of Days</th>
		<th scope="col">Min No. of Days</th> -->
	</tr>
	<%

     	int inc = 0;
     if(dialysisSetupList!=null && dialysisSetupList.size()<=0)
     {
    	 //url="submitForm('dialysisSetup','appointment?method=submitDialysisSetup');";
    	for(inc=0;inc<7;inc++){
    	%>

	<tr>
		<input type="hidden" id="days<%=inc%>" name="<%=DAYS%>" value="<%=day[inc]%>" />
		<td><%=day[inc]%></td>
		<!--<td><input type="text" id="dr<%=inc%>" size=8 name="<%=DR%>"
			maxlength="3" validate="No. Of Doctors,num,no" /></td>
		-->
		<td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			maxlength="5" /></td>
		<%-- <td><input type="text" size=8 id="percentage<%=inc%>"
			name="<%=PERCENTAGE%>" maxlength="3" validate="Percentage,num,no" /></td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakFromTime" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakToTime" /></td>
		<td><input type="text" size=8 id="breakFromTime2<%=inc%>"
			name="<%=BREAKFROMTIME2%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakFromTime2" /></td>	
		<td><input type="text" size=8 id="breakToTime2<%=inc%>"
			name="<%=BREAKTOTIME2%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakToTime2" /></td>	
		<td><input type="text" size=8 id="breakFromTime3<%=inc%>"
			name="<%=BREAKFROMTIME3%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakFromTime3" /></td>	
		<td><input type="text" size=8 id="breakToTime3<%=inc%>"
			name="<%=BREAKTOTIME3%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			id="breakToTime3" /></td>		
				
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" maxlength="2" validate="Max. no. of Days,num,no" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" maxlength="2" validate="Min no. of Days,num,no" /></td> --%>
	</tr>

	<%	}
     }
     else if (dialysisSetupList!=null && dialysisSetupList.size()>0)
     {
   		 url="submitForm('dialysisSetup','appointment?method=updateDialysisSetup');";

    	 Iterator ite=dialysisSetupList.iterator();
    	 while ( ite.hasNext() ) {
     		DialysisSetup dialysisSetup=(DialysisSetup)ite.next();
     %>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[inc]%>" />
		<input type="hidden" name="<%=DEPT_ID%>"
			value="<%=dialysisSetup.getDept().getId()%>" />
		<input type="hidden" name="<%=APPOINTMENT_ID%>"
			value="<%=dialysisSetup.getId()%>" />
		<td class="colHeader"><%=day[inc]%></td>
		<!--<td>
		<%if(dialysisSetup.getNoOfDoctor()!=null && dialysisSetup.getNoOfDoctor()!=0){ %>
		<input type="text" id="dr<%=inc%>" size=8 name="<%=DR%>" maxlength="3"
			value="<%=dialysisSetup.getNoOfDoctor() %>"
			validate="No. Of Doctors,num,no" /> <%}else{ %> <input type="text"
			id="dr<%=inc%>" size=8 name="<%=DR%>" maxlength="3"
			validate="No. Of Doctors,num,no" /> <%}%>
		</td>

		--><td>
		<%if(dialysisSetup.getFromTime()!=null){ %> <input type="text" size=8
			id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=dialysisSetup.getFromTime() %>" /> <%}else{ %> <input type="text"
			size=8 id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>

		<td>
		<%if(dialysisSetup.getToTime()!=null){ %> <input type="text" size=8
			id="toTime<%=inc%>" name="<%=TOTIME %>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=dialysisSetup.getToTime() %>" /> <%}else{ %> <input type="text"
			size=8 id="toTime<%=inc%>" name="<%=TOTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>

		<td>
		<%if(dialysisSetup.getSlotDuration()!=null){ %> <input type="text" size=8
			id="slotDuration<%=inc%>" name="<%=SLOTTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			maxlength="5" value="<%=dialysisSetup.getSlotDuration() %>" /> <%}else{ %>
		<input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			maxlength="5" id="slotTime" /> <%}%>
		</td>

		<%-- <td>
		<%if(appSetup.getPercentageForSlots()!=null && appSetup.getPercentageForSlots()!=0){ %>
		<input type="text" size=8 id="percentageForSlots<%=inc%>"
			name="<%=PERCENTAGE%>" maxlength="2"
			value="<%=appSetup.getPercentageForSlots() %>"
			validate="Percentage,num,no" /> <%}else{ %> <input type="text" size=8
			id="percentageForSlots<%=inc%>" name="<%=PERCENTAGE%>" maxlength="2"
			validate="Percentage,num,no" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getBreakFromTime()!=null){ %> <input type="text" size=8
			id="breakFromTime<%=inc%>" name="<%=BREAKFROMTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakFromTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getBreakToTime()!=null){ %> <input type="text" size=8
			id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakToTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>
		
		<td>
		<%if(appSetup.getBreakFromTime2()!=null){ %> <input type="text" size=8
			id="breakFromTime2<%=inc%>" name="<%=BREAKFROMTIME2%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakFromTime2() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime2<%=inc%>"
			name="<%=BREAKFROMTIME2%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>
		<td>
		<%if(appSetup.getBreakToTime2()!=null){ %> <input type="text" size=8
			id="breakToTime2<%=inc%>" name="<%=BREAKTOTIME2%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakToTime2() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime2<%=inc%>" name="<%=BREAKTOTIME2%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>
		<td>
		<%if(appSetup.getBreakFromTime3()!=null){ %> <input type="text" size=8
			id="breakFromTime3<%=inc%>" name="<%=BREAKFROMTIME3%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakFromTime3() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime3<%=inc%>"
			name="<%=BREAKFROMTIME3%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>
		<td>
		<%if(appSetup.getBreakToTime3()!=null){ %> <input type="text" size=8
			id="breakToTime3<%=inc%>" name="<%=BREAKTOTIME3%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5"
			value="<%=appSetup.getBreakToTime3() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime3<%=inc%>" name="<%=BREAKTOTIME3%>"
			onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /> <%}%>
		</td>
		

		<td>
		<%if(appSetup.getMaxNoOfDays()!=null && appSetup.getMaxNoOfDays()!=0){ %>
		<input type="text" size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>"
			maxlength="2" value="<%=appSetup.getMaxNoOfDays() %>"
			validate="Max. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>" maxlength="2"
			validate="Max. no. of Days,num,no" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getMinNoOfDays()!=null && appSetup.getMinNoOfDays()!=0){ %>
		<input type="text" size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>"
			maxlength="2" value="<%=appSetup.getMinNoOfDays() %>"
			validate="Min. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>" maxlength="2"
			validate="Min. no. of Days,num,no" /> <%}%>
		</td> --%>

	</tr>

	<%	inc++;
   		}

    		inc=7-dialysisSetupList.size();
    		for(int i=0;i<inc;i++){
    	    	%>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[i]%>" />
		<td class="colHeader"><%=day[i]%></td>
		<td><input type="text" size=8 id="dr<%=inc%>" name="<%=DR%>"
			maxlength="3" /></td>
		<td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			maxlength="5" /></td>
		<%-- <td><input type="text" size=8 id="percentage<%=inc%>"
			name="<%=PERCENTAGE%>" maxlength="2" /></td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>" onKeyUp="mask(this.value,this,'2',':');"
			onBlur="8IsValidTimeForSetup(this.value,this.id);" maxlength="5" /></td>
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" maxlength="2" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" maxlength="2" /></td> --%>
	</tr>

	<%	}


      }
   %>
</table>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%if(dialysisSetupList.size()>0){ %>
<input name="" type="button" class="button" value="Update" 	onclick="if(validateMandatoryFields()){submitForm('dialysisSetup','appointment?method=updateDialysisSetup');}" /> 
<%}else{ %>
<input name="" type="button" class="button" value="Submit" 	onclick="if(validateMandatoryFields()){submitForm('dialysisSetup','appointment?method=submitDialysisSetup');}" /> 
<%} %>
<input name="" type="reset" class="buttonHighlight" value="Reset" /> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currenDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<!--main content placeholder ends here-->