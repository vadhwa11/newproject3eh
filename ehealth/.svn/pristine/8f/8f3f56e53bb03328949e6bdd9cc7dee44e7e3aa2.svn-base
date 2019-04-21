<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
				 employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				
				List<HrPayrollProcessHeader> processedPayrollList = new ArrayList();
				
				if(map.get("processedPayrollList")!= null){
					processedPayrollList = (List)map.get("processedPayrollList");
				}
				
			   List<HrPayrollProcessHeader> unprocessedPayrollList = new ArrayList();
				
				if(map.get("unprocessedPayrollList")!= null){
					unprocessedPayrollList = (List)map.get("unprocessedPayrollList");
				}
				
				
	%>

<%@page import="jkt.hrms.masters.business.HrPayrollProcessHeader"%>
<script type="text/javascript">

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

<form name="prePayrollProcess" method="post" action="">
<div class="titleBg">
<h2>Pre Payroll Process</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Month</label> 
<select	name="<%=MONTH %>" validate="Month,string,yes"">
	<option value="0">Select</option>
	<option value="01">January</option>
	<option value="02">February</option>
	<option value="03">March</option>
	<option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> 
<label><span>*</span> Year</label> 
<select name="<%=YEAR %>"	validate="Year,string,yes"">
	<option value="0">Select</option>
	<option value="2007">2007</option>
	<option value="2008">2008</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>
	<option value="2014">2014</option>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	<option value="2017">2017</option>
	<option value="2018">2018</option>
</select>
<label> Department Name</label> 
<select id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID %>" validate="Department,string,no"	onchange="getEmployeeList(this)">
<option value="0">All</option>
<%
	for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%} %>
</select>
<div class="clear"></div> 
<label>Employee Name</label> 
<select id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>" validate="Employee,string,no"">
<option value="0">All</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%} %>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="button" class="button" value="Process"	onClick="submitForm('prePayrollProcess','payroll?method=processPrePayrollDetail');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<%
String period = "";	
if(map.get("year")!=null && map.get("month")!=null){
period = map.get("month") +"/"+  map.get("year");
%> <B><%=period +": " %></B> <%} %>
<div class="clear"></div>
<%if(processedPayrollList!=null && processedPayrollList.size()>0) {%> <B>Salary
Successfuly processed for <%=processedPayrollList.size() %> employees:</B>
<div class="msg">
<% for(HrPayrollProcessHeader payrollProcessHeader : processedPayrollList){
%> <%=payrollProcessHeader.getEmployee().getFirstName()+" " + payrollProcessHeader.getEmployee().getLastName()+" ,"%>
<%} %>

<div>
<% }%>
<div class="paddingTop40"></div>
<%if(unprocessedPayrollList!=null && unprocessedPayrollList.size()>0) {%>
<B>Salary already processed for <%=unprocessedPayrollList.size() %>
employees:</B>
<div class="msg"><span> <% for(HrPayrollProcessHeader payrollProcessHeader : unprocessedPayrollList){
%> <%=payrollProcessHeader.getEmployee().getFirstName()+" " + payrollProcessHeader.getEmployee().getLastName()+" ,"%>
<%} %> </span>

<div>
<% }%>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function getEmployeeList(obj)
{
	 sel = document.getElementById('<%=EMPLOYEE_ID %>');
	if(obj.value == '0')
	{
		removeAllOptions(sel);
		sel.options.add(new Option('All' , '0'));
		<%
		for(MasEmployee masEmployee :employeeList){
		%>
		sel.options.add(new Option('<%=masEmployee.getFirstName()+ " " + masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%>' , '<%=masEmployee.getId()%>'));
		<%}%>
	}
	<%for(MasDepartment department : departmentList){%>
		if(obj.value == <%=department.getId()%>){
			
			removeAllOptions(sel);
			sel.options.add(new Option('All' , '0'));
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
			
			for(MasEmployee employee:emList){%>
				sel.options.add(new Option('<%=employee.getFirstName()+ " " + employee.getLastName()+"-"+employee.getEmployeeCode()%>' , '<%=employee.getId()%>'));
			<%}%>
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
