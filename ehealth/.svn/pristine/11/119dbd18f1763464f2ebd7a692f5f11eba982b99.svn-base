<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MasDesignation"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hrms.masters.business.HrAttendanceLoader"%>
<%@page import="jkt.hrms.masters.business.HrParameter"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hrms.masters.business.MasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasRank> masDesignationList = new ArrayList<MasRank>();
		List<MasEmployee> srchEmployeeList = new ArrayList<MasEmployee>();

		List<HrAttendanceLoader> singleAttendanceList = new ArrayList<HrAttendanceLoader>();
		String message = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masEmployeeList")!= null){
		masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");
		}
		if(map.get("singleAttendanceList")!= null){
			singleAttendanceList = (List<HrAttendanceLoader>)map.get("singleAttendanceList");
			}
		if(map.get("attendanceList")!= null){
			attendanceList = (List<HrAttendanceLoader>)map.get("attendanceList");
			}

		if(map.get("parameterList")!= null){
			parameterList = (List<HrParameter>)map.get("parameterList");
			}
		if(map.get("masShiftCodeList")!= null){
			masShiftCodeList = (List<HrMasShiftCodes>)map.get("masShiftCodeList");
			}
		
		if(map.get("masDepartmentList")!= null){
			masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");
			}
		if(map.get("masDesignationList")!= null){
			masDesignationList = (List<MasRank>)map.get("masDesignationList");
			}
		if(map.get("map1")!= null){
			map1 = (Map)map.get("map1");
			}
		if(map1.get("srchEmplList")!= null){
			srchEmployeeList = (List<MasEmployee>)map1.get("srchEmplList");
			}
		if(map.get("message")!= null){
			message = (String)map.get("message");
			}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String shiftName = "";
		if(masShiftCodeList.size()>0){
			HrMasShiftCodes masShiftCodes = (HrMasShiftCodes)masShiftCodeList.get(0);
			shiftName = masShiftCodes.getShiftName();
		}
		String halfday = "";
		String fullday = "";
		String manualOverTime ="";
		if(parameterList.size()>0){
			for(HrParameter hrParameter: parameterList){
				halfday =""+hrParameter.getHalfday();
				fullday = ""+hrParameter.getFullday();
				manualOverTime = ""+hrParameter.getOvertime();

			}
		}
		String attendanceDate ="";
		int employeeAttendanceId = 0;
		int employeeId = 0;
		String timeIn = "";
		String timeOut = "";
		String employeeCode = "";
		String employeeName= "";
		String attendanceMark = "";
		String updatedOutDate = "";
		String remark = "";
		int shiftId = 0;
		String updatedShiftName = "";
		if(attendanceList.size()>0){
			 for(HrAttendanceLoader hrAttendanceLoader :singleAttendanceList){
				if(hrAttendanceLoader.getDate() != null){
				attendanceDate =HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getDate());
				}
				if(hrAttendanceLoader.getEmployee().getId() != null){
				 employeeId = 	hrAttendanceLoader.getEmployee().getId();
				}
				employeeAttendanceId = hrAttendanceLoader.getId();
				if(hrAttendanceLoader.getTimeIn()!=null&&!hrAttendanceLoader.getTimeIn().equals("")&&!hrAttendanceLoader.getTimeIn().equalsIgnoreCase("null")){
				timeIn = hrAttendanceLoader.getTimeIn();
				}
				employeeCode = hrAttendanceLoader.getEmployee().getEmployeeCode()+"-"+hrAttendanceLoader.getEmployee().getFirstName()+" "+hrAttendanceLoader.getEmployee().getLastName();
				employeeName = hrAttendanceLoader.getEmployee().getFirstName()+" "+hrAttendanceLoader.getEmployee().getLastName();
				if(hrAttendanceLoader.getTimeOut()!=null&&!hrAttendanceLoader.getTimeOut().equals("")&&!hrAttendanceLoader.getTimeOut().equalsIgnoreCase("null")){
				timeOut = hrAttendanceLoader.getTimeOut();
				}
				if(hrAttendanceLoader.getAttendanceMark()!=null&&!hrAttendanceLoader.getAttendanceMark().equals("")&&!hrAttendanceLoader.getAttendanceMark().equalsIgnoreCase("null")){
				attendanceMark = hrAttendanceLoader.getAttendanceMark();
				}
				if(hrAttendanceLoader.getOutDate() != null){
					updatedOutDate = HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getOutDate());
				}
				if(hrAttendanceLoader.getRemark()!=null&&!hrAttendanceLoader.getRemark().equals("")&&!hrAttendanceLoader.getRemark().equalsIgnoreCase("null")){
				remark = hrAttendanceLoader.getRemark();
				}

				shiftId = hrAttendanceLoader.getShiftCodes().getId();
				if(hrAttendanceLoader.getShiftCodes().getShiftName()!=null&&!hrAttendanceLoader.getShiftCodes().getShiftName().equals("")&&!hrAttendanceLoader.getShiftCodes().getShiftName().equalsIgnoreCase("null")){
				updatedShiftName = hrAttendanceLoader.getShiftCodes().getShiftName();
				}

			}


	}

%>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	</script>



<form name="employeeAttendance" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript">
	function display(idvalue) {
	<%
	for(MasEmployee masEmployee :masEmployeeList){
		int id = masEmployee.getId();

	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empId').value = '<%= masEmployee.getFirstName()+" "+masEmployee.getLastName() %>'

	}
<%
	}

%>

}


function checkAttendanceDate(){
		var aDate = document.employeeAttendance.<%= ATTENDANCE_DATE%>.value;
		var oDate = document.employeeAttendance.<%=OUT_DATE%>.value;
		var	attendanceDate =new Date(aDate.substring(6),(aDate.substring(3,5) - 1) ,aDate.substring(0,2))
		var outDate =new Date(oDate.substring(6),(oDate.substring(3,5) - 1) ,oDate.substring(0,2))
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);

		if(aDate != "" && oDate != ""){
		if(attendanceDate < currentDate || currentDate < attendanceDate)
		{
			alert(" Attendance Date should be equal to  Current Date.");
			document.employeeAttendance.<%= ATTENDANCE_DATE%>.value = "";
			return false;
		}else if(outDate < attendanceDate){
			alert(" Out Date should be greater than equal to Attendance Date.");
			document.employeeAttendance.<%= ATTENDANCE_DATE%>.value = "";
			document.employeeAttendance.<%= OUT_DATE%>.value = "";
			return false;
		}
		}
		return true;
	}

	function checkTime(){
		var timeIn = document.employeeAttendance.<%= TIME_IN%>.value;
		var timeOut = document.employeeAttendance.<%= TIME_OUT%>.value;
		var index = timeIn.indexOf(":");
		var hr = timeIn.substring(0,index);
		var min = timeIn.substring(index+1);
		if(hr <10){
			hr = "0".concat(hr);
			timeIn = hr.concat(":").concat(min);

		}
		if(timeIn != "" && timeOut != ""){
		if(timeIn == timeOut){
			alert(" Time In should not  equal to Time Out .");
			return false;
		}else if(timeOut < timeIn ){
			alert(" Time Out should  greater than  Time in .");
			return false;
		}
		}
		return true;
	}
function openPopupWindow()
{
	var id = document.getElementById('employeeId2').value;
	var fromDate = document.getElementById('fromDateId').value;
	var toDate = document.getElementById('toDateId').value;
	var url="/hms/hrms/attendance?method=displayEmployeeAttenadance&employeeId="+id+"&fromDateId="+fromDate+"&toDateId="+toDate+"";
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function validateFieldsForDisplay(){
var errMsg = "";
	var empId = document.getElementById('employeeId2').value;
	var fromDate = document.getElementById('fromDateId').value;
	var toDate = document.getElementById('toDateId').value;
	if(empId == "0"){
		errMsg += "Employee Code can not be blank.\n";
	}
	if(fromDate == ""){
		errMsg += "From Date can not be blank.\n";
	}
	if(toDate == ""){
		errMsg += "To Date can not be blank.\n";
	}

	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}

	function checkFromDate(){
		var fDate = document.employeeAttendance.<%= FROM_DATE%>.value;
		var tDate = document.employeeAttendance.<%= TO_DATE %>.value;

		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(toDate < fromDate)
		{
			alert(" To Date should be greater than  From Date.");
			document.employeeAttendance.<%= FROM_DATE%>.value = "";
			document.employeeAttendance.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}


</script>
<div class="titleBg">
<h2>Employee Attendance</h2>
</div>
<div class="clear"></div>

<%
	if(message!= null){
%>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>
<%--
<div class="Block"><label><span>*</span> Employee Name </label>
<select	id="employeeId" name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :masEmployeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode() %></option>
<%}%>
</select>
<script type="text/javascript">
document.employeeAttendance.<%=EMPLOYEE_ID%>.value='<%=employeeId%>';
</script>
<input type="hidden" name="<%=EMPLOYEE_NAME%>" id="empId" readonly="readonly" type="text" />
<script type="text/javascript">
document.employeeAttendance.<%=EMPLOYEE_NAME%>.value='<%=employeeName%>';
</script>
<label><span>*</span> Mark</label>
<select name="<%=ATTENDANCE_MARK  %>"	validate="Attendance Mark,string,yes" onchange="display(this.value);">
<option value="">Select</option>
<option value="ND">Normal Duty</option>
<option value="OD">On Duty</option>
<option value="Absent">Absent</option>
</select>
<script type="text/javascript">
document.employeeAttendance.<%=ATTENDANCE_MARK%>.value='<%=attendanceMark%>';
</script>
<label><span>*</span> Attendance Date</label>
<input	type="text" name="<%=ATTENDANCE_DATE %>" value="" class="date"	readonly="readonly" validate="Attendance date ,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.employeeAttendance.<%=ATTENDANCE_DATE%>,event)" />
<script type="text/javascript">
document.employeeAttendance.<%=ATTENDANCE_DATE%>.value='<%=attendanceDate%>';
</script>
<label><span>*</span> Out Date </label>
<input type="text"	name="<%=OUT_DATE %>" value="" class="date" readonly="readonly"	validate="Out date ,date,yes" MAXLENGTH="30" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="setdate('',document.employeeAttendance.<%=OUT_DATE%>,event)" />
<script type="text/javascript">
document.employeeAttendance.<%=OUT_DATE%>.value='<%=updatedOutDate%>';
</script>
<label><span>*</span> Time In</label>
<input name="<%=TIME_IN %>" type="text" id="inTimeId" title="Time Should be in 24 hr Format" validate="Time In,string,yes" onBlur="IsValidTime(this.value,this.id);" value="" maxlength="5" />
<script type="text/javascript">
document.employeeAttendance.<%=TIME_IN%>.value='<%=timeIn%>';
</script>
<label><span>*</span> Time Out </label>
<input	name="<%=TIME_OUT %>" type="text" id="outTimeId"	title="Time Should be in 24 hr Format" validate="Time Out,string,yes"	onBlur="IsValidTime(this.value,this.id);" value="" maxlength="5" />
<script	type="text/javascript">
document.employeeAttendance.<%=TIME_OUT%>.value='<%=timeOut%>';
</script>
<div class="clear"></div>
<label>Remarks</label>
<input name="<%=REMARK %>"	type="text" validate="Remarks,string,no" value="" maxlength="30" />
<script	type="text/javascript">
document.employeeAttendance.<%=REMARK%>.value='<%=remark%>';
</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--table starts-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<%
	  if(attendanceList.size()>0){
			String inTime = "";
			String outTime = "";
			String inDate = "";
			String outDate = "";
		for(HrAttendanceLoader hrAttendanceLoader :attendanceList){
			String totalOverTime = "";
		    String totalUt = "";
			inDate = HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getDate());
			if(hrAttendanceLoader.getOutDate() != null){
				outDate =HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getOutDate());
			}

			inTime=hrAttendanceLoader.getTimeIn();
			outTime =hrAttendanceLoader.getTimeOut();


			Map parameterMap = new HashMap();
			parameterMap.put("inDate",inDate);
			parameterMap.put("outDate",outDate);
			parameterMap.put("inTime",inTime);
			parameterMap.put("outTime",outTime);
			parameterMap.put("manualOverTime",manualOverTime);
			parameterMap.put("fullday",fullday);

			Map diffMap = new HashMap();

			diffMap = HMSUtil.calculateTimeDiffForAttendance(parameterMap);

			if(diffMap.get("totalOverTime")!= null){
				totalOverTime = (String)diffMap.get("totalOverTime");
			}
			if(diffMap.get("totalUt")!= null){
				totalUt = (String)diffMap.get("totalUt");
			}
			String url = "attendance?method=editEmployeeAttendance&"+EMPLOYEE_ATTENDANCE_ID +"="+hrAttendanceLoader.getId();

  %>

	<tr>
		<th scope="col">Employee Name</th>
		<th scope="col">Atten Date</th>
		<th scope="col">Time In</th>
		<th scope="col">Time Out</th>
		<th scope="col">Atten.Mark</th>
		<th scope="col">OT</th>
		<th scope="col">Undertime</th>
		<th scope="col">Authorized</th>
		<th scope="col">Processed</th>



	</tr>
	<%
	  String klass = "even";
	  int  counter=0;
				String id = "";
	 		id = "id" + counter;
	 		counter++;

	 		if(counter%2==0){
	 			klass = "even";
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}


  %>

	<tr class=<%= klass%> id="<%=counter%>"
		onclick="parent.location='<%=url %>'">
		<%
  	for(MasEmployee masEmployee :masEmployeeList){
  		if(masEmployee.getId().equals(hrAttendanceLoader.getEmployee().getId())){
  %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></a></td>
		<%
  		}
  	}

    %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=HMSUtil.convertDateToStringWithoutTime(hrAttendanceLoader.getDate())%></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=hrAttendanceLoader.getTimeIn() %></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=hrAttendanceLoader.getTimeOut() %></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=attendanceMark %></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=totalOverTime %></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=totalUt %></a></td>
		<%if(hrAttendanceLoader.getAuthorized()!=null) {%>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=hrAttendanceLoader.getAuthorized() %></a></td>
		<%}else{ %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"></a></td>
		<% }%>
		<%if(hrAttendanceLoader.getProcessed()!=null) {%>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=hrAttendanceLoader.getProcessed() %></a></td>
		<%}else{ %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"></a></td>
		<% }%>



	</tr>
	<%
  		}
  	}
 %>
</table>

<!--table ends-->
--%>

<label><span>*</span> Department </label>
<select	id="dept" name="dept" validate="Department,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(MasDepartment md :masDepartmentList){
%>
	<option value="<%=md.getId() %>"><%=md.getDepartmentName() %></option>
<%}%>
</select>

<label><span>*</span> Shift </label>
<select	id="shift" name="shift" validate="Shift,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(HrMasShiftCodes mscl :masShiftCodeList){
%>
	<option value="<%=mscl.getId() %>"><%=mscl.getShiftName() %></option>
<%}%>
</select>

<label><span>*</span> Designation </label>
<select	id="designation" name="designation" validate="Designation,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(MasRank masDes :masDesignationList){
%>
	<option value="<%=masDes.getId() %>"><%=masDes.getRankName()%></option>
<%}%>
</select>

<div class="clear"></div>

 
 
 <label><span>*</span> Attendance Date</label>
<input	type="text" name="<%=ATTENDANCE_DATE %>" value="<%=curDate+"/"+month+"/"+year%>" class="date"	 validate="Attendance date ,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.employeeAttendance.<%=ATTENDANCE_DATE%>,event)" />
  <script type="text/javascript">
document.employeeAttendance.<%=ATTENDANCE_DATE%>.value='<%=curDate+"/"+month+"/"+year%>';
</script>  
  
  <div class="clear"></div
  	<input name="Submit11" type="button" class="button"	value="Search" onclick="submitForm('employeeAttendance','attendance?method=searchEmployeeForAttenadance');" />	
     <input name="Submit11" type="button" class="button"	value="Search" onclick="submitForm('employeeAttendance','attendance?method=searchEmployeeForAttenadance');" />
<div class="clear"></div>
<div class="division"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%if(srchEmployeeList.size()>0){ 

%>
<!--table starts-->



<tr>
		<th scope="col">Employee Name</th>
		<th scope="col">Designation</th>		
		<th scope="col">Attendance</th>		
		<th scope="col">Remark</th>

	</tr>
	<%
	  String klass = "even";
	  int  counter=0;
				String id = "";
	 		id = "id" + counter;
	 		counter++;

	 		if(counter%2==0){
	 			klass = "even";
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}

String url="";
  %>
<%for(MasEmployee me : srchEmployeeList){ %>
	<tr class=<%= klass%> id="<%=counter%>"
		onclick="parent.location='<%=url %>'">
		
		
		
		
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=me.getEmployeeName() != null ? me.getEmployeeName() :""%></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%=me.getRank() != null ? me.getRank().getRankName() :"" %></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%="3" %></a></td>
			<td><a
			href="javascript:Request(document.getElementById('<%=counter %>'),'employeeAttendance')"><%="4" %></a></td>
		



	</tr>
	

<%}} %>
</table>
<div class="clear"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<input	type="hidden" name="<%=EMPLOYEE_ATTENDANCE_ID %>" value="<%=employeeAttendanceId%>">
<%
if(singleAttendanceList.size()>0){
%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Update" type="button" class="button" value="Update" onClick="submitForm('employeeAttendance','attendance?method=updateEmployeeAttendance');" />
<%
	}else{

%>



<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemDetails">


		<tr>
			<th width="13%">Employee Name</th>
			<th width="13%">Designation</th>
			<th width="13%">Department</th>
			
			<th width="10%"> Attendance</th>
			<th width="10%"> Remark</th>
			<th width="10%"> Validate</th>		 
		</tr>
		<%int i = 1;
		
		/* for(i=1;i<=3;i++){ */

		%>
		<tr>
			<td>
			<input type="text" name="priority<%=i  %>" value="Sanjay Dixit"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			<input type="hidden" name="employee_id<%=i  %>" value=""	tabindex=1  id="id<%=i  %>"  size="20"/>
			</td>
			<td>
			<input type="desig" name="priority<%=i  %>" value="Peon"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
		
			<td>
			<input type="depart" name="priority<%=i  %>" value="Administrator"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			
			<td>
			
				<select name="instiName<%=i  %>" id="instiName<%=i  %>"  validate="shift,string,no" >	
					<option value="">Select</option>
					<option value="">Present</option>
						<%-- <%
							for(MasHospital mh: hosList) {
						%>
							<option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
						<%} %> --%>
			  </select>

			
				</td>
				
				<td>
			<input type="text" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			 <td>
			<input type="checkBox" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="5"/>
			</td> 
		</tr>
		
		<tr>
			<td>
			<input type="text" name="priority<%=i  %>" value="Karan"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			<input type="hidden" name="employee_id<%=i  %>" value=""	tabindex=1  id="id<%=i  %>"  size="20"/>
			</td>
			<td>
			<input type="desig" name="priority<%=i  %>" value="male Nurse"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
		
			<td>
			<input type="depart" name="priority<%=i  %>" value="Administrator"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			
			<td>
			
				<select name="instiName<%=i  %>" id="instiName<%=i  %>"  validate="shift,string,no" >	
					<option value="">Select</option>
					<option value="">Present</option>
						<%-- <%
							for(MasHospital mh: hosList) {
						%>
							<option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
						<%} %> --%>
			  </select>

			
				</td>
				
				<td>
			<input type="text" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			 <td>
			<input type="checkBox" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="5"/>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="priority<%=i  %>" value="VK Das"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			<input type="hidden" name="employee_id<%=i  %>" value=""	tabindex=1  id="id<%=i  %>"  size="20"/>
			</td>
			<td>
			<input type="desig" name="priority<%=i  %>" value="Doctor"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
		
			<td>
			<input type="depart" name="priority<%=i  %>" value="Administrator"	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			
			<td>
			
				<select name="instiName<%=i  %>" id="instiName<%=i  %>"  validate="shift,string,no" >	
					<option value="">Select</option>
					<option value="">Present</option>
					<option value="">Absent</option>
						<%-- <%
							for(MasHospital mh: hosList) {
						%>
							<option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
						<%} %> --%>
			  </select>

			
				</td>
				
				<td>
			<input type="text" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="20"/>
			</td>
			<td>
			<input type="checkBox" name="priority<%=i  %>" 	tabindex=1  id="priority<%=i  %>"  size="5"/>
			</td> 
		</tr>
		<%-- <%} %> --%>

</table>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Submit11" type="button" class="button"	value="Save" onclick="submitForm('employeeAttendance','attendance?method=saveEmployeeAttenadance','checkAttendanceDate','checkTime');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<%
	}

%>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<%-- <label><span>*</span> Employee Name </label>
<select	id="employeeId2" name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,no" onchange="">
<option value="0">Select</option>
<%
for(MasEmployee masEmployee :masEmployeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode() %></option>
<%}%>
</select>
<label><span>*</span> From Date </label>
<input type="text"	id="fromDateId" name="<%=FROM_DATE %>" value="" class="date" readonly="readonly" validate="From date ,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.employeeAttendance.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label>
<input type="text" id="toDateId" name="<%=TO_DATE %>" value="" class="date" readonly="readonly" validate="To date ,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.employeeAttendance.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="button" class="buttonBig"	value="Display Records"	onclick="if(validateFieldsForDisplay()){javascript:openPopupWindow();}" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> --%>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Last Changed By</label>
<label	class="value"><%=userName%></label>
<label>Last Changed DATE</label>
<label	class="value"><%=currentDate%></label>
<label>Last Changed Time</label>
<label class="value"><%=currentTime%></label></div>
<div class="clear"></div>
</form>
<div class="paddingTop40"></div>
<script type="text/javascript">
function mask(str,textbox,loc,delim){
		var locs = loc.split(',');
		for (var i = 0; i <= locs.length; i++){
			for (var k = 0; k <= str.length; k++){
				if (k == locs[i]){
					if (str.substring(k, k+1) != delim){
						str = str.substring(0,k) + delim + str.substring(k,str.length)
					}

				}

		}

		}
		textbox.value = str
}


function IsValidTime(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.

	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
		alert("Time should be in HH:MM format.");
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
	if (minute<0 || minute > 59) {
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
	return false;
}



</script>

