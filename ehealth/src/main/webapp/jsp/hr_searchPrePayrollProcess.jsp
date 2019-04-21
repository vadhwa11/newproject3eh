<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.HrPayrollProcessDetail"%>
<%@page import="jkt.hrms.masters.business.HrPayrollProcessHeader"%>
<%@page import="jkt.hrms.masters.business.HrEmployeePayStructure"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
				List<HrEmployeePayStructure> employeePayStructureList = new ArrayList<HrEmployeePayStructure>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
				 employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("prePayrollProcessList")!= null){
					prePayrollProcessList = (List<HrPayrollProcessHeader>)map.get("prePayrollProcessList");
				}
				if(map.get("employeePayStructureList")!= null){
					employeePayStructureList = (List)map.get("employeePayStructureList");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				if(map.get("message") != null){
				String message = (String)map.get("message");
				out.println(message);
				}
	%>


<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.HrLoanHeader"%>
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

<form name="searchPrePayrollProcess" method="post" action="">
<div class="titleBg">
<h2>Search Pre Payroll Process</h2>
</div>
<div class="clear"></div>
<div class="Block"><label> Month</label> <select
	name="<%=MONTH %>" validate="month,string,no">
	<option value="0">Select</option>
	<option value="1">January</option>
	<option value="2">February</option>
	<option value="3">March</option>
	<option value="4">April</option>
	<option value="5">May</option>
	<option value="6">June</option>
	<option value="7">July</option>
	<option value="8">August</option>
	<option value="9">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> 
<label><span>*</span> Year</label> 
<select name="<%=YEAR %>"	validate="Year,string,yes">
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
<select id="<%=DEPARTMENT_ID %>"	name="<%=DEPARTMENT_ID %>" validate="Department,string,no"	onchange="getEmployeeList(this)">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%} %>
</select> 
<label> Employee Name</label> 
<select id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>" validate="Employee,string,no"">
	<option value="0">Select</option>
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
<input name="save" type="button" class="button" value="Search"	onClick="submitForm('searchPrePayrollProcess','payroll?method=searchPrePayrollDetail');" />
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<%
	if(prePayrollProcessList.size()>0){
%>
<table id="searchresulttable" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>


		<th scope="col">Emp.Name</th>
		<th scope="col">Year</th>
		<th scope="col">Month</th>
		<th scope="col">Department</th>
		<th scope="col">Basic</th>
		<th scope="col">T.Days</th>
		<th scope="col">LWP</th>
		<th scope="col">S.Days</th>
		<th scope="col">Earning</th>
		<th scope="col">Deduction</th>
		<th scope="col">Reimb</th>
		<th scope="col">Net Salary.</th>

	</tr>
	<tbody id="tableData">
		<%
		  	int  counter=0;
			String klass = "even";
  			for(HrPayrollProcessHeader payrollProcessHeader :prePayrollProcessList){
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
  			BigDecimal basic =  new BigDecimal("0");
  			BigDecimal totalbasicAndPayElementAmt = new BigDecimal("0");
  			basic = payrollProcessHeader.getBasic();
  			Set<HrPayrollProcessDetail> detailSet = new HashSet<HrPayrollProcessDetail>();
  			detailSet = payrollProcessHeader.getHrPayrollProcessDetails();
  				BigDecimal totalAdditionPayElement = new BigDecimal("0");
  				BigDecimal totalDeductionPayElement = new BigDecimal("0");
  				BigDecimal totalReimbPayElement = new BigDecimal("0");
  				BigDecimal totalPayElement = new BigDecimal("0");
  			for(HrPayrollProcessDetail payrollProcessDetail : detailSet){
  				BigDecimal payElementAmt = new BigDecimal("0");
  				if(payrollProcessDetail.getPayelementAmount() != null){
  				payElementAmt =payrollProcessDetail.getPayelementAmount();
  				}
  				if(payrollProcessDetail.getElementType()!= null){
  				if(payrollProcessDetail.getElementType().equals("Addition")){
  					totalAdditionPayElement = totalAdditionPayElement.add(payElementAmt);
  				}
  				if(payrollProcessDetail.getElementType().equals("Reimb")){
  					totalReimbPayElement = totalReimbPayElement.add(payElementAmt);
  				}
  				if(payrollProcessDetail.getElementType().equals("Deduction")){
  					totalDeductionPayElement = totalDeductionPayElement.add(payElementAmt);
  				}
  					totalPayElement = totalAdditionPayElement.add(totalReimbPayElement).subtract(totalDeductionPayElement);
  			}
  			}
  			totalbasicAndPayElementAmt = basic.add(totalPayElement);
  			int salaryDays = payrollProcessHeader.getSalDays();
  			int totaldays = payrollProcessHeader.getTotalDays();
  			int totalMonthdays =payrollProcessHeader.getTotalMonthDays();
  			BigDecimal totalsalaryAmount =new BigDecimal(totalbasicAndPayElementAmt.intValue()*salaryDays/totalMonthdays);
  			
  			BigDecimal loanAmount =new BigDecimal("0");
  			BigDecimal bonusAmount =new BigDecimal("0");
  			BigDecimal advanceAmount =new BigDecimal("0");
  			BigDecimal arrearPayElementAmount =new BigDecimal("0");
  			BigDecimal arrearSalaryAmount =new BigDecimal("0");
  			BigDecimal totalSalary =new BigDecimal("0");
  			BigDecimal netSalary =new BigDecimal("0");
  			Float arrearDays =0.0f;
  			
  			if(payrollProcessHeader.getLoanInstallment()!= null){
  				loanAmount = payrollProcessHeader.getLoanInstallment();
  			}
  			if(payrollProcessHeader.getBonusAmount()!= null){
  				bonusAmount = payrollProcessHeader.getBonusAmount();
  			}
  			if(payrollProcessHeader.getAdvanceInstallment()!= null){
  				advanceAmount = payrollProcessHeader.getAdvanceInstallment();
  			}
  			if(payrollProcessHeader.getArrearPayelementAmt()!= null){
  				arrearPayElementAmount = payrollProcessHeader.getArrearPayelementAmt();
  			}
  			if(payrollProcessHeader.getArrearDays()!= null){
  				arrearSalaryAmount = payrollProcessHeader.getArrearSalaryAmt();
  			}
  			if(payrollProcessHeader.getArrearSalaryAmt()!= null){
  				arrearDays = payrollProcessHeader.getArrearDays();
  			}
  			if(payrollProcessHeader.getNetSalary()!= null){
  				totalSalary = payrollProcessHeader.getNetSalary();
  			}
  			if(salaryDays == 30 || salaryDays == 31){
  				netSalary = totalSalary; 
  			}else if(salaryDays < 30 && salaryDays <31){
  				netSalary =totalsalaryAmount.add(arrearSalaryAmount).add(arrearPayElementAmount).add(bonusAmount).subtract(loanAmount).subtract(advanceAmount);	
  			}
  			
  		//netsalary = (totalsalaryAmount.add(arrearSalaryAmount).add(arrearPayElementAmount).add(bonusAmount).subtract(loanAmount).subtract(advanceAmount)).intValue();
  		String url = "/hms/hrms/payroll?method=editPrePayrollDetail&"+PRE_PAYROLL_PROCESS_ID +"="+payrollProcessHeader.getId()+"&"+FLAG+"="+payrollProcessHeader.getFlag()+"";
  		//String url = "payroll?method=editPrePayrollDetail&"+PRE_PAYROLL_PROCESS_ID +"="+payrollProcessHeader.getId();
  %>


		<tr class=<%= klass%> id="<%=counter%>"
			onclick="parent.location='<%=url %>';">

			<%
 		for(MasEmployee masEmployee :employeeList){
 			if(masEmployee.getId() == payrollProcessHeader.getEmployee().getId()){	
 		
 %>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></a></td>
			<%
 		}
 	}
%>

			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=payrollProcessHeader.getYear() %></a></td>
			<td><%=HMSUtil.convertMonth(payrollProcessHeader.getMonth()) %></td>
			<%
		for(MasDepartment masDepartment :departmentList){
			if(masDepartment.getId().equals(payrollProcessHeader.getDepartment().getId())){
%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=masDepartment.getDepartmentName() %></a></td>
			<%
		}
  	}
%>

			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=basic %></a></td>

			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=payrollProcessHeader.getTotalDays() %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=payrollProcessHeader.getLwpDays() %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=payrollProcessHeader.getSalDays() %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=totalAdditionPayElement %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=totalDeductionPayElement %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=totalReimbPayElement %></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'searchPrePayrollProcess')"><%=netSalary %></a></td>

		</tr>
		<%} %>
	</tbody>
</table>
<%
		
  	}else{
 %> <label><h4>No Record Exists</h4></label> <%} %> <!--table ends--> <script>
	  var pager = new Pager('tableData',15); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function getEmployeeList(obj)
{
	<%for(MasDepartment department : departmentList){%>
		if(obj.value == <%=department.getId()%>){
			var sel = document.getElementById('<%=EMPLOYEE_ID %>');
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