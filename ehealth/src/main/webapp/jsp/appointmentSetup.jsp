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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>

<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

<form name="appSetup" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript" language="javascript">
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
	//System.out.println("check");
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
					alert("'From Time' should be less than 'To Time' for row "+ eval(inc+1));
					document.getElementById('fromTime'+inc).value="";
					document.getElementById('toTime'+inc).value="";
					return false;
				}
			}
			if(document.getElementById('breakFromTime'+inc).value!="" && document.getElementById('breakToTime'+inc).value!="")
			{
				if(document.getElementById('breakFromTime'+inc).value >= document.getElementById('breakToTime'+inc).value)
				{
					alert("'Break From Time' should be less than 'Break To Time' for row "+ eval(inc+1));
					document.getElementById('breakFromTime'+inc).value="";
					document.getElementById('breakToTime'+inc).value="";
					return false;
				}
			}
		}
		return true;
	}


function compareTime()
{
	if(document.getElementById('fromTime').value >= document.getElementById('toTime').value)
	{
		alert("From Time should be less than To Time");
		return false;
	}
	return true;

}
function checkDept()
{
	if(deptSelected==false){
		alert("Select department!!");
		return false;
	}
	return true;
}
function checkDr()
{
	if(drSelected==false){
		alert("Select department!!");
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
		alert("Time should be in HH:MM:SS format.");
		obj.value = "";
		obj.focus();
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute >59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (hour<=00 && minute<05) {
		alert ("Slot duration must be atleast 5 min.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}

	</script>
<div class="titleBg">
<h2>Appointment Setup</h2>
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
			 	
			 	String tokenStartNo="";
		    	 String tokenInterval="";
		    	 String totalToken="";
		    	 String maxNo="";
		    	 String minNo="";
		    	 int inc1= 0;
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
			 	List<Object[]> doctorList = new ArrayList<Object[]>();
			 	List<AppSetup> appSetupList = new ArrayList<AppSetup>();

				if (map.get("appSetupList") != null) {
					appSetupList = (List<AppSetup>) map.get("appSetupList");

			 	}
				int deptId=0;
				if (map.get("deptId") != null) {
					deptId = (Integer) map.get("deptId");

			 	}
				
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");

			 	}
				if(map.get("employeeList") != null){
					doctorList = (List<Object[]>)map.get("employeeList");
					}
				System.out.println("doctorList>>"+doctorList.size());
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
			 %> <!--Block One Starts-->

<div class="Block">
<label>Service Centre<span>*</span></label>
<select
	id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="submitProtoAjax('appSetup','/hms/hms/appointment?method=getServiceCentreWiseSession')" Validate="Service Centre,string,yes">
	<%-- 
	<select
	id="diagnosisId" name="<%=DEPARTMENT_ID%>" onchange="getDetails(this.value);" Validate="Service Centre,string,yes"> --%>
	
	<option value="0">Select</option>
	<%
				System.out.println("deptId  "+deptId);
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) 
					{
					if(deptId==masDepartment.getId()){
					%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
				<% 	}}}	%>
</select>

<div id="testDiv">

</div>
<script type="text/javascript">
<%
int i = 0;
for(MasDepartment masDepartment : departmentList){
for (Object[] masEmployee : doctorList)
{
if(masEmployee[3] != null){
if(masEmployee[4].equals(empCategoryCodeForDoctor)){
if(masDepartment.getId()==masEmployee[3]){
%>
doctorArray[<%=i%>] = new Array();
doctorArray[<%=i%>][0] = <%=masDepartment.getId()%>;
doctorArray[<%=i%>][1] = <%=masEmployee[1]%>;
doctorArray[<%=i%>][2] = "<%=(masEmployee[2].toString()).concat(" ").concat(masEmployee[3].toString())%>";

<%
i++;
}
}
}
}
}
%>
</script>

 <!-- <input name="Print" class="buttonBig" type="button"
	value="Generate Report" target="_blank"
	onClick="showReport('appSetup');"> --> <!--Block one Ends-->
<div class="clear"></div>
<div class="clear"></div>

<!--Block Three Starts--> <%
	int deptMap;
	if(box.getInt(DEPARTMENT_ID)==0)
		deptMap=(Integer)map.get("deptIdinMap");
	else
		deptMap=box.getInt(DEPARTMENT_ID);

if (appSetupList!=null)
     {
    %><!--  <label>Selected Service Centre:</label> --> <input type="hidden"
	id="departmentId" name="<%=WARD_ID%>" value="<%=deptMap%>"   /> <%

    	 Iterator ite=departmentList.iterator();
    	 while ( ite.hasNext() ) {
     		MasDepartment masDepartment=(MasDepartment)ite.next();
     		if(masDepartment.getId()==deptMap)
     		{


     %> <script type="text/javascript">deptSelected=true;</script> 
    <%--  <label class="value"> <%=masDepartment.getDepartmentName()%></label> --%> <%		}
    	 }
     }
    %>
<!--Code By Anand--> 
  
<!--Block Counsulting Doctor Starts--> <%
	int deptMap1=0;
	if(box.getInt(CONSULTING_DOCTOR)==0 ){
		//deptMap1=(Integer)map.get("drIdinMap");
	}
	else
		//deptMap1=box.getInt(CONSULTING_DOCTOR);

if (appSetupList!=null)
     {
    %> <label>Select Doctor:</label> <input type="hidden"
	id="consultingDocId" name="<%=CONSUNTANT%>" value="<%=deptMap1%>"   /> <%

    	 Iterator ite=doctorList.iterator();
    	 while ( ite.hasNext() ) {
    		 Object[] masEmployee=(Object[])ite.next();
     		//MasDepartment masDepartment=(MasDepartment)ite.next();
     		if((Integer)masEmployee[0]==deptMap1)
     		{


     %> <script type="text/javascript">drSelected=true;</script> <label
	class="value"> <%=masEmployee[1]+" "+masEmployee[2]%></label> <%		}
    	 }
     }
    %>
<div class="clear"></div></div>
<div id="deptDiv"></div>
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Days</th>
		<!--<th scope="col">No. of Doctors</th>
		-->
		<!-- <th scope="col">From Time:</th>
		<th scope="col">To Time</th>
		<th scope="col">Slot Duration</th>
		<th scope="col">% for Slot</th>
		<th scope="col">Break From Time</th>
		<th scope="col">Break To Time</th>
		<th scope="col">Break From Time 2</th>
		<th scope="col">Break To Time 2</th>
		<th scope="col">Break From Time 3</th>
		<th scope="col">Break To Time 3</th> -->
		<th scope="col">Token Start No.</th>
		<th scope="col">Token Interval</th>
		<th scope="col">Total Token</th>
		<th scope="col">Max No. of Days</th>
		<th scope="col">Min No. of Days</th>
		<th scope="col">Total No. of Patients</th>
	</tr>
	<%

     	int inc = 0;
     if(appSetupList!=null && appSetupList.size()<=0)
     {
    	 
    	 url="submitForm('appSetup','appointment?method=submitAppointmentSetup');";
    	for(inc=0;inc<7;inc++){
    		//System.out.println("inc"+inc);
    	%>

	<tr>
	
		<input type="hidden" id="days<%=inc%>" name="<%=DAYS%>"
			value="<%=day[inc]%>" />
		<td><%=day[inc]%><input type="hidden" name="<%=APPOINTMENT_ID%>" id="appointmentId<%=inc%>"
			value="" /></td>
		<!--<td><input type="text" id="dr<%=inc%>" size=8 name="<%=DR%>"
			MAXLENGTH="3" validate="No. Of Doctors,num,no" /></td>
		-->
		<%-- <td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="percentage<%=inc%>"
			name="<%=PERCENTAGE%>" MAXLENGTH="2" validate="Percentage,num,no" /></td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakFromTime" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakToTime" /></td>
		<td><input type="text" size=8 id="breakFromTime2<%=inc%>"
			name="<%=BREAKFROMTIME2%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakFromTime2" /></td> --%>	
		<td><input type="text" size=8 id="TokenStart<%=inc%>"
			name="TokenStart" 
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakToTime2" /></td>	
		<td><input type="text" size=8 id="TokenInterval<%=inc%>"
			name="TokenInterval" 
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakFromTime3" /></td>
				
		<td><input type="text" size=8 id="TotalToken<%=inc%>"
			name="TotalToken" 
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			id="breakToTime3" /></td>		
				
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" MAXLENGTH="3" validate="Max. no. of Days,num,no" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" MAXLENGTH="3" validate="Min no. of Days,num,no" /></td>
			
			<td><input type="text" size=8 id="numberofPatient<%=inc%>"
			name="numberofPatient" MAXLENGTH="3" validate="number of Patient. of Days,num,no" /></td>
	</tr>

	<%	}
     }%>
    
   <input  type="hidden" value="<%=inc%>" name="totalRow" id="totalRowId"/>
   
</table>
<div class="clear"></div>
<% System.out.println(" url "+url); %>
<div id="addId">
<input name="" type="button" class="button" value="Submit"
	onclick="if(validateDatefield()){<%=url%>}" /> 
	</div>
	<div id="updateId" style="display: none">
<input name="" type="button" class="button" value="Update"
	onclick="submitForm('appSetup','appointment?method=updateAppointmentSetup');" /> 
	</div>
<input name="" type="reset" class="buttonHighlight" value="Reset" /> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currenDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>
<div class="clear"></div>
</form>

<!--main content placeholder ends here-->
<script type="text/javascript">
function validateDatefield(){
	
	var totalRow=document.getElementById('totalRowId').value;
	
	var errorMessage="";
	var flag = true;
	for(var k=0;k<totalRow;k++){
		
		if(document.getElementById('TokenStart'+k).value!="" && document.getElementById('TokenInterval'+k).value!="" 
				&& document.getElementById('TotalToken'+k).value!="" && document.getElementById('maxDays'+k).value!="" && document.getElementById('minDays'+k).value!=""){
        	flag = false;
        	break;
        	}
		

	} 
	if(flag == false)
	{	
	return true;
	}
	else{
	alert("Please Enter Atleast One Row Value!!!!");
	return false;
} 
	} 

/* function getDetails(val){	
	alert(val)
	submitForm('appSetup','/hms/hms/appointment?method=getRecords&deptId='+val);	
} */
</script>
