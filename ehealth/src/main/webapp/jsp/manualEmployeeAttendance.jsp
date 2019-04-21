<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>

<%		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String message = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!= null){
			employeeList = (List)map.get("employeeList");
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
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

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



<!--Main Div starts here-->



<div class="titleBg">
<h2>Manual Employee Attendance</h2>
</div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>

<form name="manualEmployeeAttendance" method="post" action="">

<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>

<!--table starts-->
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col"><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th scope="col">Employee Name</th>
		<th scope="col">Attendance Date</th>
		<th scope="col">Out Date</th>
		<th scope="col">TimeIn</th>
		<th scope="col">TimeOut</th>
	</tr>
	<tbody id="tableData">
		<%
int count = 0;
int i = 0;
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

	if(employeeList.size()>0){
		for(MasEmployee masEmployee : employeeList){

			

%>

		<tr class=<%= klass%> id="<%=count%>">
			<td><input name="<%=EMPLOYEE_ATTENDANCE_ID%><%=i%>"
				onClick="unCheck(this)" class="radioCheck" type="checkbox" value="" /></td>
			<td><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %>
			<input type="hidden" id="employeeId" name="<%=EMPLOYEE_ID%><%=i%>"
				value="<%=masEmployee.getId()%>" /></td>
			<td><input id="attendanceDateId<%=i%>" type="text"
				name="<%=ATTENDANCE_DATE %><%=i%>" value="" class="date"
				readonly="readonly" maxlength="30" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onclick="setdate('',document.getElementById('attendanceDateId<%=i%>'),event)" /></td>

			<td><input id="outDateId<%=i%>" type="text"
				name="<%=OUT_DATE %><%=i%>" value="" class="date"
				readonly="readonly" MAXLENGTH="30" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onclick="setdate('',document.getElementById('outDateId<%=i%>'),event)" /></td>
			<td><input name="<%=TIME_IN %><%=i%>" type="text" id="inTimeId"
				title="Time Should be in 24 hr Format" validate="Time In,string,no"
				onBlur="IsValidTime(this.value,this.id);" value=""
				onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
			<td><input name="<%=TIME_OUT %><%=i%>" type="text"
				id="outTimeId" title="Time Should be in 24 hr Format"
				validate="Time Out,string,no"
				onBlur="IsValidTime(this.value,this.id);" value=""
				onKeyUp="mask(this.value,this,'2',':');" maxlength="5" /></td>
		</tr>
		<%i++;
  }} %>
	</tbody>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i %>"><script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
		
		
		function checkAll()
		{
		var no = <%=i%>;
		
		for(i=0;i<no;i++)
		{
		var obj = "document.manualEmployeeAttendance." + "<%=EMPLOYEE_ATTENDANCE_ID%>" +i;
		
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
		if(document.manualEmployeeAttendance.allIds.checked==true)
		{
		obj.checked=true;
		}
		else
		{
		obj.checked=false;
		}
		}
		}
	}



function unCheck(obj)
{
if(obj.checked==false)
{
document.manualEmployeeAttendance.allIds.checked=false;
}
}

function chkCheckBoxes()
	{
	
		inps = document.getElementsByTagName('input');
		flag=false;
		for(i=0;i<inps.length;i++)
		{
 			if(inps[i].type == 'checkbox')
  			{
				if(inps[i].checked)
				{
       	            flag=true;
	 			     break;
				}
			}
		}
		if(!flag)
		{
		alert(flag);
			alert("Please select one of the Employee.");
			return false;
		}
		return true;
	}
	function submitAttendance()
		{
		val = chkCheckBoxes();
	if(val == true)
			submitForm('manualEmployeeAttendance','attendance?method=saveManualEmployeeAttenadance');
		}
	
	

</script>
<div class="clear"></div>
<div class="division"></div>
<input name="save" type="button" class="buttonBig" value="Submit"
	onclick="submitAttendance();" />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Last Changed By</label> <label
	class="value"><%=userName%></label> <label>Last Changed DATE</label> <label
	class="value"><%=currentDate%></label> <label>Last Changed Time</label>
<label class="value"><%=currentTime%></label></div>
<div class="clear"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />

<div class="clear"></div>
<div class="paddingTop40"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
