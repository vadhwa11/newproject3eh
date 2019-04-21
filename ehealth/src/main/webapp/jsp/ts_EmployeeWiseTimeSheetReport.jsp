
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.EmployeeComparator"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.EmployeeComparator;"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link href="/hms/jsp/css/phaseII.css" rel="stylesheet" type="text/css">


<SCRIPT>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
	%>
		serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</SCRIPT>

<div class="titleBg">
<h2>Employee Wise Timesheets</h2>
</div>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList")!=null)
	{
	departmentList = (List) map.get("departmentList");
	}
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null)
	{
	employeeList = (List) map.get("employeeList");
	}

%>
<form name="departmentList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<DIV class="Block">

<DIV class=clear></DIV>


<label><span>* </span>From Date</label> <input type="text"
	name="<%=FROM_DATE%>" value="" class="date" readonly="readonly"
	validate="From Date,'date',yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif"
	onClick="javascript:setdate('',document.departmentList.<%=FROM_DATE%>,event)"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" /> <label>To Date</label> <input type="text"
	name="<%=TO_DATE%>" value="" class="date" readonly="readonly"
	validate="To Date,'date',no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif"
	onClick="javascript:setdate('',document.departmentList.<%=TO_DATE%>,event)"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" />

<div class="clear"></div>


<label><span>* </span>Department</label> <select name="departmentId"
	validate="Department,int,yes" tabindex=1
	onchange="getEmployeeList(this)">
	<option value="0">Select</option>
	<%for(MasDepartment department : departmentList){ %>
	<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%} %>
</select> <label><span>* </span>Employee</label> <select name="employeeId"
	id="employeeId" validate="Employee,int,yes" tabindex=1>
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>

	<option value="<%=employee.getId() %>"><%=employee.getFirstName() + " "+ employee.getLastName() + "-" + employee.getEmployeeCode()  %></option>
	<%} %>
</select> <label><span>* </span>Status</label> <select name="status"
	validate="Status,string,yes" tabindex=1>
	<option value="%">All</option>

	<option value="Submitted">Submitted</option>
	<option value="Back">Sent Back</option>
	<option value="Approved">Approved</option>
	<option value="Rejected">Rejected</option>
	<option value="Forwarded">Forwarded</option>


</select>
<div class="paddingTop40"></div>

<input type="button" name="Print" id="Print" value="View Report"
	class="buttonBig"
	onclick="submitForm('departmentList','report?method=printEmployeeWiseSheetReport');"
	accesskey="r" /> <input type="button" name="xlPrint" id="xlPrint"
	value="Export To Excel" class="buttonBig"
	onclick="submitForm('departmentList','report?method=exportToExcelEmployeeWiseSheetReport');"
	accesskey="r" /></div>
</form>

<script>
function getEmployeeList(obj)
{
	<%for(MasDepartment department : departmentList){%>
		if(obj.value == <%=department.getId()%>){
			var sel = document.getElementById("employeeId");
			removeAllOptions(sel);
			sel.options.add(new Option('Select' , '0'));
			<%
			Set empSet = department.getMasEmployees();
			List<MasEmployee> emList = new ArrayList();
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
			if(empSet!=null)
			{
				emList = new ArrayList(empSet);
				Collections.sort(emList,new EmployeeComparator());
			}
			
			for(MasEmployee employee:emList){
				if(employee.getStatus().equals("y")){
			%>
				
				sel.options.add(new Option('<%=employee.getFirstName()+ " " + employee.getLastName()+"-"+employee.getEmployeeCode()%>' , '<%=employee.getId()%>'));
			<%
				}			
			}%>
		}
		
	<%}%>
}
function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
</script>