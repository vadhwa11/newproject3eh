<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


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


<div class="Block">
<form name="empLeaveReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script type="text/javascript">
	function getDepartmentForCompany(companyId){
		submitProtoAjaxWithDivName('empLeaveReport','report?method=getDepartmentForCompany','departmentDiv');
	}
	function getEmpForDepartment(departmentId){
		submitProtoAjaxWithDivName('empLeaveReport','report?method=getEmpForDepartment','employeeDiv');
	}

	function showHideEmpOrg(chkValue){
		if(chkValue == 'empWise'){
			document.getElementById('<%=COMPANY%>').setAttribute("validate","Organization,string,no");
			document.getElementById('orgWiseDiv').style.display='none';
			document.getElementById('empWiseDiv').style.display='block';
		}else if(chkValue == 'orgWise'){
			document.getElementById('<%=COMPANY%>').setAttribute("validate","Organization,string,yes");
			document.getElementById('empWiseDiv').style.display='none';
			document.getElementById('orgWiseDiv').style.display='block';
		}
	}
	function chkDate(){
		obj1 = document.empLeaveReport.<%=FROM_DATE%>.value;
		obj2 = document.empLeaveReport.<%=TO_DATE%>.value;

		fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
		toDate= new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
		
		if(obj1 != "" && obj2 == ""){
			alert("To Date can't be blank if From date is filled.");
			return false;
		}
		if(obj2 != "" && obj1 == ""){
			alert("From Date can't be blank if To date is filled.");
			return false;
		}
		if(fromDate > toDate){
			errorMsg += "From Date should be smaller than To Date.\n ";
			return false;
		}
		return true;
	}
	
</script>
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee> employeeList=new ArrayList<MasEmployee>();
List<MasHospital> hospitalList=new ArrayList<MasHospital>();

if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}
if(map.get("hospitalList")!=null){
	hospitalList=(List<MasHospital>)map.get("hospitalList");
}

%>
<div class="titleBg">
<h2>Employee Leave Report</h2></div>
        
         <div class="clear"></div>
         <label>Employee Wise</label>
         <input type="radio" class="radioCheck" checked="checked" 
         	onclick="showHideEmpOrg(this.value);" value="empWise" name="<%=SELECTED_RADIO%>"/>
         
         <label>Organization Wise</label>
         <input type="radio" class="radioCheck" 
         	onclick="showHideEmpOrg(this.value);" value="orgWise" name="<%=SELECTED_RADIO%>"/>

		<div class="clear"></div><div class="clear"></div>
		
		<div id="empWiseDiv">
	    	<label><span>*</span>Employee</label>
	    	<select name="empcode" id="empcode">
	    	<option value="">All</option>
	    	<%for(MasEmployee masEmployee:employeeList){%>
				<option value="<%= masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%></option>
			<%} %>
	    	</select>
    	</div>
    	
		<div class="clear"></div>
		<div id="orgWiseDiv" style="display: none;">
	    	<label><span>*</span>Organization</label>
	    	<select name="<%=COMPANY%>" id="<%=COMPANY%>" validate="Organization,string,no">
	    	<option value="">Select</option>
	    	<%for(MasHospital masHospital:hospitalList) {%>
				<option value="<%=masHospital.getId() %>" onclick="getDepartmentForCompany(this.value)"><%=masHospital.getHospitalName()%></option>
			<%} %>
	    	</select>
    		<div id="departmentDiv">
    			<label>Department</label>
    			<select name="<%=DEPARTMENT_ID%>" id="<%=DEPARTMENT_ID%>">
    				<option value="">All</option>
    			</select>
    		</div>
    		<div id="employeeDiv">
    			<label>Employee</label>
    			<select name="<%=EMPLOYEE_ID%>" id="<%=EMPLOYEE_ID%>">
    				<option value="">All</option>
    			</select>
    		</div>
    	</div>
    	
		<div class="clear"></div>
    	<label><span>*</span> From Date</label>
    	<input name="<%=FROM_DATE%>" type="text" readonly 
    		validate='From Date,date,yes' value="" class="date" />
   		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="<%=FROM_DATE%>" 
   			onclick="javascript:setdate('',document.empLeaveReport.<%=FROM_DATE%>,event)"  />

		<label><span>*</span> To Date</label>
   		<input type="text" name="<%=TO_DATE%>" readonly 
   			validate='To Date,date,yes'	value=""  class="date" />
    	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="<%=TO_DATE%>" 
    		onclick="javascript:setdate('',document.empLeaveReport.<%=TO_DATE%>,event)" />
    	
    	<div class="clear"></div>
    	
    	<input type="button" class="button" value="View" name="print" onclick="submitForm('empLeaveReport','/hms/hrms/report?method=printEmpLeaveReport','chkDate');"/>
    	</form>
</div>