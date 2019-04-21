<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.EmployeeShiftDetails"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeShiftDetails"%>
<%@page import="jkt.hrms.masters.business.MasShiftCodes"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
				List<HrEmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
				List<HrEmployeeShiftDetails> singleEmployeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masHospitalList")!= null){
					masHospitalList = (List)map.get("masHospitalList");
				}
				if(map.get("masEmployeeList")!= null){
					masEmployeeList = (List)map.get("masEmployeeList");
				}
				
				if(map.get("employeeShiftDetailsList")!= null){
					employeeShiftDetailsList = (List)map.get("employeeShiftDetailsList");
				}
				if(map.get("singleEmployeeShiftDetailsList")!= null){
					singleEmployeeShiftDetailsList = (List)map.get("singleEmployeeShiftDetailsList");
				}
				if(map.get("masShiftCodesList")!= null){
					masShiftCodesList = (List)map.get("masShiftCodesList");
				}
				String message = "";
				
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int hospitalId = 0;
				//int employeeId = 0;
				//int departmentId = 0;
				if(masHospitalList.size()>0){
					MasHospital masHospital = masHospitalList.get(0);
					hospitalId = masHospital.getId();
				}
				//if(masEmployeeList.size()>0){
					//MasEmployee masEmployee= masEmployeeList.get(0);
					//employeeId = masEmployee.getId();
					//departmentId = masEmployee.getDepartment().getId();
				//}
				int employeeShiftDetailId = 0;
				int employeeId = 0;
				String departmentCode = "";
				String employeeCode = "";
				int mondayShiftId = 0;
				int tuesdayShiftId = 0;
				int wednesdayShiftId = 0;
				int thursdayShiftId = 0;
				int fridayShiftId = 0;
				int saturadyShiftId = 0;
				int sundayShiftId = 0;
				
				String shiftStartDate ="";
				String shiftEndDate = "";
				String employeeName = "";
				String departmentName = "";
				int departmentId = 0;
				if(singleEmployeeShiftDetailsList.size()>0){
					for(HrEmployeeShiftDetails hrEmployeeShiftDetails:singleEmployeeShiftDetailsList){
						employeeShiftDetailId = hrEmployeeShiftDetails.getId();
						if(hrEmployeeShiftDetails.getEmployee().getId()!= null){
						employeeId = hrEmployeeShiftDetails.getEmployee().getId();
						}
						employeeCode = hrEmployeeShiftDetails.getEmployee().getEmployeeCode();
						employeeName = hrEmployeeShiftDetails.getEmployee().getFirstName()+" "+hrEmployeeShiftDetails.getEmployee().getLastName();
						departmentCode = hrEmployeeShiftDetails.getEmployee().getDepartment().getDepartmentCode();
						departmentName = hrEmployeeShiftDetails.getEmployee().getDepartment().getDepartmentName();
						mondayShiftId = hrEmployeeShiftDetails.getMondayShift().getId();
						tuesdayShiftId = hrEmployeeShiftDetails.getTuesdayShift().getId();
						wednesdayShiftId = hrEmployeeShiftDetails.getWednesdayShift().getId();
						thursdayShiftId = hrEmployeeShiftDetails.getThursdayShift().getId();
						fridayShiftId = hrEmployeeShiftDetails.getFridayShift().getId();
						saturadyShiftId = hrEmployeeShiftDetails.getSaturdayShift().getId();
						sundayShiftId = hrEmployeeShiftDetails.getSundayShift().getId();
						shiftStartDate = HMSUtil.convertDateToStringWithoutTime(hrEmployeeShiftDetails.getShiftStartDate());
						shiftEndDate = HMSUtil.convertDateToStringWithoutTime(hrEmployeeShiftDetails.getShiftEndDate());
						
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
		
		function checkStartDate(){
		var sDate = document.employeeShiftDetails.<%= START_DATE%>.value;
		var eDate = document.employeeShiftDetails.<%= END_DATE %>.value;

		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		
		var	startDate =new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2))
		var endDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		
		if(sDate != "" && eDate != ""){
		if(endDate < startDate )
		{
			alert(" End Date should be greater than Start Date.");
			document.employeeShiftDetails.<%= START_DATE%>.value = "";
			document.employeeShiftDetails.<%= END_DATE %>.value = "";
			return false;
		}else if(startDate < currentDate){
			alert(" Start Date should be greater than or equal to Current Date.");
			document.employeeShiftDetails.<%= START_DATE%>.value = "";
			return false;
		}else if(endDate < currentDate){
			alert(" End Date should be greater than or equal to Current Date.");
			document.employeeShiftDetails.<%= END_DATE %>.value = "";
			return false;
		}
		}
		return true;
	}
	
	
	
	</script>

<form name="employeeShiftDetails" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	if(message!= null){
%>
<h4><span><%=message %></span></h4>
<%} %>
<div class="titleBg">
<h2>Employee Shift Details</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block"><label><span>*</span> Employee Name</label> <select
	name="<%=EMPLOYEE_ID %>" validate="Employee Code,string,yes"
	onchange="display(this.value);">
	<option value="0">Select</option>
	<%	
	for(MasEmployee masEmployee :masEmployeeList)
	{
		
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>

	<%
		
}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=EMPLOYEE_ID%>.value='<%=employeeId%>';
            </script> <input type="hidden" name="<%=EMPLOYEE_ID %>"
	value="<%=employeeId %>"><input name="<%=EMPLOYEE_CODE%>"
	id="aa" class="readOnly" readonly="readonly" type="text" /> <script
	type="text/javascript">
          		  document.employeeShiftDetails.<%=EMPLOYEE_CODE%>.value='<%=employeeCode%>';
            </script> <label><span>*</span>Department Code</label> <input
	name="<%=DEPARTMENT_CODE %>" id="bb" class="readOnly"
	readonly="readonly" type="text" validate="Department Code,string,yes" />
<script type="text/javascript">
          		  document.employeeShiftDetails.<%=DEPARTMENT_CODE%>.value='<%=departmentCode%>';
            </script> <input name="<%=DEPARTMENT_NAME %>" id="cc"
	class="readOnly" readonly="readonly" type="text" /> <script
	type="text/javascript">
          		  document.employeeShiftDetails.<%=DEPARTMENT_NAME%>.value='<%=departmentName%>';
            </script>
<div class="clear"></div></div>
<div class="division"></div>
<div class="titleBg">
<h2>Shift Details</h2>
</div>
<div class="Block"><label><span>*</span> Monday</label> <select
	name="<%=MONDAY_SHIFT_CODE_ID %>"
	validate="Monday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
		
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>
	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=MONDAY_SHIFT_CODE_ID%>.value='<%=mondayShiftId%>';
            </script> <label><span>*</span> Tuesday</label> <select
	name="<%=TUESDAY_SHIFT_CODE_ID %>"
	validate=" Tuesday Shift Code,string,yes">

	<option value="0">Select</option>
	<%
for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>

	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=TUESDAY_SHIFT_CODE_ID%>.value='<%=tuesdayShiftId%>';
            </script> <label><span>*</span> Wednesday </label> <select
	name="<%=WEDNESDAY_SHIFT_CODE_ID %>"
	validate="Wednesday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>
	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=WEDNESDAY_SHIFT_CODE_ID%>.value='<%=wednesdayShiftId%>';
            </script>

<div class="clear"></div>
<label><span>*</span> Thursday </label> <select
	name="<%=THURSDAY_SHIFT_CODE_ID %>"
	validate="Thursday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>
	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=THURSDAY_SHIFT_CODE_ID%>.value='<%=thursdayShiftId%>';
            </script> <label><span>*</span> Friday</label> <select
	name="<%=FRIDAY_SHIFT_CODE_ID %>"
	validate="Friday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>
	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=FRIDAY_SHIFT_CODE_ID%>.value='<%=fridayShiftId%>';
  </script> <label><span>*</span> Saturday</label> <select
	name="<%=SATURDAY_SHIFT_CODE_ID %>"
	validate=" Saturday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>
	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=SATURDAY_SHIFT_CODE_ID%>.value='<%=saturadyShiftId%>';
            </script>



<div class="clear"></div>
<label><span>*</span> Sunday</label> <select
	name="<%=SUNDAY_SHIFT_CODE_ID %>"
	validate="Sunday Shift Code,string,yes">
	<option value="0">Select</option>
	<%
	for(HrMasShiftCodes  hrMasShiftCodes: masShiftCodesList){
%>
	<option value="<%=hrMasShiftCodes.getId() %>"><%=hrMasShiftCodes.getShiftCode() %></option>

	<%
	}
%>
</select> <script type="text/javascript">
          		  document.employeeShiftDetails.<%=SUNDAY_SHIFT_CODE_ID%>.value='<%=sundayShiftId%>';
            </script> <label><span>*</span> Shift Start Date </label> <input
	type="text" name="<%=START_DATE %>" value="" class="date"
	readonly="readonly" validate="Start date ,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.employeeShiftDetails.<%=START_DATE%>,event)" />
<script type="text/javascript">
          		  document.employeeShiftDetails.<%=START_DATE%>.value='<%=shiftStartDate%>';
            </script> <label><span>*</span> Shift End Date</label> <input
	type="text" name="<%=END_DATE %>" value="" class="date"
	readonly="readonly" validate="End date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.employeeShiftDetails.<%=END_DATE%>,event)" />
<script type="text/javascript">
          		  document.employeeShiftDetails.<%=END_DATE%>.value='<%=shiftEndDate%>';
            </script>

<div class="clear"></div>



<div class="clear"></div>
</div>

<div class="division"></div>
<div id="pageNavPosition"></div>
<!--table starts-->

<table id="searchresulttable" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>

		<th scope="col">Emp.Name</th>
		<th scope="col">Monday</th>
		<th scope="col">Tuesday</th>
		<th scope="col">Wednesday</th>
		<th scope="col">Thursday</th>
		<th scope="col">Friday</th>
		<th scope="col">Saturday</th>
		<th scope="col">Sunday</th>
		<th scope="col">StartDate</th>
		<th scope="col">End Date</th>
	</tr>
	<tbody id="tableData">
		<%
  				String klass = "even";
  			  int  counter=0;
  		if(employeeShiftDetailsList.size()>0){
  			for(HrEmployeeShiftDetails hrEmployeeShiftDetails:employeeShiftDetailsList){
  				String url = "attendance?method=editEmployeeShiftDetail&"+EMPLOYEE_SHIFT_DETAILS_ID +"="+hrEmployeeShiftDetails.getId();
  			 	
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
  	
  %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getEmployee().getFirstName()+" "+hrEmployeeShiftDetails.getEmployee().getLastName() %></a></td>
			<%
  		

 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getMondayShift().getShiftName()%></a></td>
			<% 	
 	 
 	 
 	 
 	 
 	
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getTuesdayShift().getShiftName()%></a></td>
			<% 	
 	
 	
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getWednesdayShift().getShiftName()%></a></td>
			<% 
 	
 	
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getThursdayShift().getShiftName()%></a></td>
			<%
 	 
 	
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getFridayShift().getShiftName()%></a></td>
			<%
 	 
 	
 		 
  %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getSaturdayShift().getShiftName()%></a></td>
			<%
 	 
 	
 		 
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=hrEmployeeShiftDetails.getSundayShift().getShiftName()%></a></td>
			<%
 	
 	 
  	
%>

			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=HMSUtil.convertDateToStringWithoutTime(hrEmployeeShiftDetails.getShiftStartDate()) %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'employeeShiftDetails')"><%=HMSUtil.convertDateToStringWithoutTime(hrEmployeeShiftDetails.getShiftEndDate()) %></a></td>
		</tr>
		<%
  		
  	}
  		}
  			
 %>
	</tbody>
</table>
<!--table ends--> <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>


<div class="clear"></div>
<div class="division"></div>

<%
	if(singleEmployeeShiftDetailsList.size()>0){
%> <input name="Update" type="button" class="button" value="Update"
	onClick="submitForm('employeeShiftDetails','attendance?method=updateEmployeeShiftDetails');" />
<%
	}else{

%> <input name="save" type="button" class="button" value="Save"
	onClick="submitForm('employeeShiftDetails','attendance?method=saveEmployeeShiftDetails','checkStartDate');" />
<%
	}

%> <input type="reset" name="Reset" value="Reset"
	onclick="resetValues();" class="buttonHighlight" accesskey="r" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=departmentId %>"><input
	type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" /> <input
	type="hidden" name="<%=EMPLOYEE_SHIFT_DETAILS_ID %>"
	value="<%=employeeShiftDetailId%>">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Last Changed By</label> <label
	class="value"><%=userName%></label> <label>Last Changed DATE</label> <label
	class="value"><%=date%></label> <label>Last Changed Time</label> <label
	class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	function display(idvalue) {
	<%
	for(MasEmployee masEmployee :masEmployeeList){
		int id = masEmployee.getId();
		
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('aa').value = '<%= masEmployee.getEmployeeCode()%>'
	document.getElementById('bb').value = '<%=masEmployee.getDepartment().getDepartmentCode() %>'
	document.getElementById('cc').value = '<%=masEmployee.getDepartment().getDepartmentName() %>'
	}
<%
	}
	
%>
}
function resetValues(){
submitForm('employeeShiftDetails','attendance?method=showEmployeeDetails');
}




</script></form>
