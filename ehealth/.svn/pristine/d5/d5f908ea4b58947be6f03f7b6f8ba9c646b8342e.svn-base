<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
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

<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<MasEmployeeDepartment> masDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasRank> masDesignationList = new ArrayList<MasRank>();
		List<MasEmployee> srchEmployeeList = new ArrayList<MasEmployee>();
		List<HrAttendanceLoader> hrAttendanceLoaderList = new ArrayList<HrAttendanceLoader>();

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
			masDepartmentList = (List<MasEmployeeDepartment>)map.get("masDepartmentList");
			}
		if(map.get("masDesignationList")!= null){
			masDesignationList = (List<MasRank>)map.get("masDesignationList");
			}
		int count=0;
		if(map.get("hrAttendanceLoaderList")!= null){
			
			hrAttendanceLoaderList = (List<HrAttendanceLoader>)map.get("hrAttendanceLoaderList");
			count = hrAttendanceLoaderList.size();
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



<script
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
<h2>Attendance Validation</h2>
</div>
<form name="attendanceVerify" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<%
	if(message!= null){
%>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>


<label> Department </label>
<select	id="dept" name="dept" validate="Department,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(MasEmployeeDepartment md :masDepartmentList){
%>
	<option value="<%=md.getId() %>"><%=md.getEmpDeptName() %></option>
<%}%>
</select>

<label>Shift </label>
<select	id="shift" name="shift" validate="Shift,string,no" onchange="display(this.value);">
<option value="0">Select</option>
<%
for(HrMasShiftCodes mscl :masShiftCodeList){
%>
	<option value="<%=mscl.getId() %>"><%=mscl.getShiftName() %></option>
<%}%>
</select>

<label> Designation </label>
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
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('',document.attendanceVerify.<%=ATTENDANCE_DATE%>,event)" />
<div class="clear"></div>
<input name="Submit" type="button" class="button"	value="Search" onclick="submitForm('attendanceVerify','attendance?method=showAttendanceVerifyJsp');" />
   
<div class="clear"></div>
  <%
  System.out.println("Atta--"+hrAttendanceLoaderList.size());
  if(hrAttendanceLoaderList.size()>0){ %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

<!--table starts-->



<tr>
		<th scope="col">Employee Name</th>
		<th scope="col">Designation</th>		
		<th scope="col">Attendance</th>		
		<th scope="col">Remark</th>
		<th scope="col"><input type="checkbox" name="allIds" value="yes" onClick="checkAll()"  size="5" />Validate</th>
						

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



<% int i=0;
for(HrAttendanceLoader hal : hrAttendanceLoaderList){
	if(hal.getEmployee().getEmployeeName() != null){
	i++;
%>
	<%-- <tr class=<%= klass%> id="<%=counter%>"
		onclick="parent.location='<%=url %>'"> --%>
		<tr>
		
		
		
		<td><%=hal.getEmployee() != null ? hal.getEmployee().getEmployeeName() :""%>
			<input type="hidden" id="empId" name="empId" value="<%=hal.getEmployee().getId() %>" />
			<input type="hidden" id="id" name="id<%=i %>" value="<%=hal.getId() %>" />
		</td>
		<td><%=hal.getEmployee().getRank() != null ? hal.getEmployee().getRank().getRankName() :"" %><input type="hidden" id="rankId" name="rankId" value="<%= hal.getEmployee().getRank().getId() %>"  /></td>
		<td>
					<select	id="att_Status" name="att_Status" validate="Designation,string,yes" >
						<!-- <option value="0">Select</option> -->
						<option value="P">Present</option>
						
					</select>
		</td>
			
			<td>
				<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="100" class="medium3" validate="Remarks,String,no" />
			</td>
			
			<td>
				<input type="checkBox" id="validate" name="validate<%=i%>" size="5" value="<%=hal.getId() %>" onClick="unCheck(this)"  />
			</td>
		

	</tr>
	

<%}}
%>
</table>

<div class="clear"></div>
<input type="hidden" id="count" name="count" value="<%=hrAttendanceLoaderList.size() %>" />
<input name="Submit11" type="button" class="button"	value="Save" onclick="submitForm('attendanceVerify','attendance?method=saveAttendanceVerify');" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<%} %>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
<input	type="hidden" name="<%=EMPLOYEE_ATTENDANCE_ID %>" value="<%=employeeAttendanceId%>">

<div class="Block">
<div class="bottom"><label>Last Changed By</label>
<label	class="value"><%=userName%></label>
<label>Last Changed DATE</label>
<label	class="value"><%=currentDate%></label>
<label>Last Changed Time</label>
<label class="value"><%=currentTime%></label></div>
</div>

</form>

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

function checkAll()
{
var no = <%=count%>;

for(i=1;i<=no;i++)
{
var obj = "document.attendanceVerify." + "<%="validate"%>" +i;

obj=eval(obj);
if(obj.disabled==true)
{
}
else
{
if(document.attendanceVerify.allIds.checked==true)
{
obj.checked=true;
}
else
{
obj.checked=false;
}}}
}




function unCheck(obj)
{
if(obj.checked==false)
{
document.attendanceVerify.allIds.checked=false;
}
}

</script>

