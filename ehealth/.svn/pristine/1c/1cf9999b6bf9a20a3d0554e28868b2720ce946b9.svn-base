<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrMasLocation"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<form name="leaveType" method="post" action="">
<script type="text/javascript">
	function chkDate(){
		obj1 = document.leaveType.<%=FROM_DATE%>.value;
		obj2 = document.leaveType.<%=TO_DATE%>.value;

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
	List<HrMasLocation> locationList = new ArrayList<HrMasLocation>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if(map.get("employeeList")!=null){
		employeeList=(List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("locationList")!=null){
		locationList = (List<HrMasLocation>)map.get("locationList");
	}
	if(map.get("departmentList")!=null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
%><div class="titleBg">
<h2>Employee Wise  Leave Detail</h2></div>
        
         <div class="clear"></div>
		<div class="clear"></div>
    	<label><span>*</span> From Date</label>
    	<input name="<%=FROM_DATE%>" type="text" readonly validate='From Date,date,yes' value="" class="date" />
   		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="<%=FROM_DATE%>" 
   			onclick="javascript:setdate('',document.leaveType.<%=FROM_DATE%>,event)"  />

		<label><span>*</span> To Date</label>
   		<input type="text" name="<%=TO_DATE%>" readonly validate='To Date,date,yes'  value=""  class="date" />
    	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="<%=TO_DATE%>" 
    		onclick="javascript:setdate('',document.leaveType.<%=TO_DATE%>,event)" />
    	
    	<div class="clear"></div>
         
    	<label><span>*</span>Employee</label>
    	<select name="empcode" id="empcode">
    	<option value="">All</option>
    	<%for(MasEmployee masEmployee:employeeList){%>
			<option value="<%= masEmployee.getEmployeeCode() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%></option>
		<%} %>
    	</select>
    	
    	<div class="clear"></div>
    	<input type="button" class="button" value="View" name="print" onclick="submitForm('leaveType','/hms/hrms/report?method=printEmployeeLeaveType','chkDate');"/>
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>