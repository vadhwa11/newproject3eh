<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.HrArrearSalary"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			if(map.get("hospitalList")!= null){
				hospitalList = (List)map.get("hospitalList");
			}
			if(map.get("employeeList")!= null){
				employeeList = (List)map.get("employeeList");
			}
			if(map.get("arrearSalaryList")!= null){
				arrearSalaryList = (List)map.get("arrearSalaryList");
			}
			
			int hospitalId = 0;
			if(hospitalList.size()>0){
				MasHospital masHospital = hospitalList.get(0);
				hospitalId = masHospital.getId();
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






<script type="text/javascript">
	


  function displayValues(idvalue) {
	<%
	for(MasEmployee masEmployee :employeeList){
		int id = masEmployee.getId();
	%>
	if(idvalue == <%=id%> ){
    document.getElementById('empCodeId').value = '<%= masEmployee.getEmployeeCode()%>'
	}
<%
	}
%>	
}
	function checkFromDate(){
		var fDate = document.arrearSalary.<%= FROM_DATE%>.value;
		var tDate = document.arrearSalary.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert(" To Date should be greater than  From Date.");
			document.arrearSalary.<%= FROM_DATE%>.value = "";
			document.arrearSalary.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	
	
	
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
		
	function calculateArrearDays(){
		var fDate = document.arrearSalary.<%= FROM_DATE%>.value;
		var tDate = document.arrearSalary.<%= TO_DATE %>.value;
		var	startDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var endDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		var oneday = 1000 * 60 * 60 * 24
		
		var diffDays = Math.abs((startDate.getTime() - endDate.getTime()));
		var totalDays = Math.round(diffDays/oneday);
		document.arrearSalary.<%= ARREAR_DAYS %>.value = totalDays;

	}
		
		
		
		function resetUpdatedValue(){
  			document.getElementById('empId').disabled = false;
 		}
 	
</script>

<div class="titleBg">
<h2>Arrear Salary</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">

formFields = [
[0, "<%= ARREAR_SALARY_ID%>", "id"], [1,"<%=EMPLOYEE_ID%>"], [2,"<%= EMPLOYEE_CODE %>"],[3,"<%=FROM_DATE%>"],[4,"<%= TO_DATE%>"],[5,"<%= ARREAR_DAYS%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=REMARK%>"],[10,"<%=STATUS%>"],[11,"hiddenEmp"],[12,"<%=PAYMENT_DATE%>"]];
statusTd = 10;
</script></div>
<div class="clear"></div>
<div class="division"></div>

<form name="arrearSalary" method="post" action="">

<div class="Block"><input type="hidden" name="hiddenEmp"
	id=hiddenEmp " value="" /> <label><span>*</span> Employee Name</label>
<select id="empId" name="<%=EMPLOYEE_ID %>"
	validate="Employee,string,yes" onchange="displayValues(this.value);">
	<option value="0">Select</option>
	<%
	for(MasEmployee masEmployee :employeeList){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%></option>
	<%
	}
%>
</select> <label id=biglabel><span>*</span> Employee Code</label> <input
	name="<%=EMPLOYEE_CODE%>" id="empCodeId"
	validate="Employee Code,string,yes" class="readOnly"
	readonly="readonly" type="text" /> <label><span>*</span>From
Date</label> <input type="text" name="<%=FROM_DATE %>" value="" class="date"
	readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.arrearSalary.<%=FROM_DATE%>,event)" />

<div class="clear"></div>


<label><span>*</span>To Date</label> <input type="text"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="Todate ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.arrearSalary.<%=TO_DATE%>,event)" /> <label><span>*</span>Arrear
Days</label> <input type="text" name="<%= ARREAR_DAYS%>" value=""
	onblur="calculateArrearDays();" validate="Arrear Days,Float,yes"
	MAXLENGTH="3" tabindex=1 /> <label><span>*</span>Payment date</label>
<input type="text" name="<%=PAYMENT_DATE %>" value="" class="date"
	readonly="readonly" validate="Todate ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.arrearSalary.<%=PAYMENT_DATE%>,event)" />

<div class="clear"></div>
<label><span>*</span>Remark</label> <input type="text"
	name="<%= REMARK%>" value="" validate="Remark,String,yes"
	MAXLENGTH="40" tabindex=1 />




<div class="clear"></div>



</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('arrearSalary','loan?method=saveArrearSalary','checkFromDate');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('arrearSalary','loan?method=updateArrearSalary','checkFromDate')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('reimbDetail','payrollMasters?method=deletePayroll&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();resetUpdatedValue();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= ARREAR_SALARY_ID%>" value="" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= EMPLOYEE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Emp.Code"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= EMPLOYEE_CODE %>";

data_header[2] = new Array;
data_header[2][0] = "From Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=FROM_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "To Date"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= TO_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Arrear Days"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= ARREAR_DAYS %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%=REMARK %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "hiddenEmp";

data_header[11] = new Array;
data_header[11][0] = "Payment date"
data_header[11][1] = "data";
data_header[11][2] = 0;
data_header[11][3] = "<%= PAYMENT_DATE %>";

data_arr = new Array();

<%


Iterator itr=arrearSalaryList.iterator();
int  counter=0;
while(itr.hasNext())
{


	HrArrearSalary hrArrearSalary = (HrArrearSalary)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrArrearSalary.getId()%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%>";
<%
		}
			}
		
%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][2] = "<%=masEmployee.getEmployeeCode()%>";
<%
		}
			}
		
%>

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getFromDate())%>";
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getToDate())%>"
data_arr[<%= counter%>][5] = "<%= hrArrearSalary.getArrearDays()%>"
data_arr[<%= counter%>][6] = "<%= hrArrearSalary.getLastChgBy()%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%=hrArrearSalary.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=hrArrearSalary.getRemark() %>"

<%
if(hrArrearSalary.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
	
			for(MasEmployee masEmployee : employeeList){
				if(hrArrearSalary.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][11] = "<%=masEmployee.getId()%>";
<%
		}
			}
		
%>
data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(hrArrearSalary.getPaymentDate())%>";
<%

counter++;
}
%>


formName = "arrearSalary"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>
