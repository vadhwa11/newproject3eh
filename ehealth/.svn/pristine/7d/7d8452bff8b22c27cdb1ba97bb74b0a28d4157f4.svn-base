<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.lang.RandomStringUtils"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.UserManager"%>
<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.masters.business.Holidaycalendar"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeMediator"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.StringTokenizer"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
	session.setAttribute("save", true);
	Map map=(Map)request.getAttribute("map");
	List mgr=(List)map.get("manager");
	request.getSession(true);
	Users loggedUser =(Users)session.getAttribute(USERS);
	UserManager manager=null;
	if(mgr!=null && mgr.size()>0)
	{
		 manager=(UserManager)mgr.get(0);
	}
	
	List listOfHolidays=(List)map.get("listOfHolidays"); 
	List<HrEmployeeBalanceNew> leaveBalance=(List)map.get("leaveBalance");

    List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

    List<HrMasLeaveTypeMediator> listOfTypesOfLeaves=new ArrayList<HrMasLeaveTypeMediator>();
    List<Integer> empDependents = new ArrayList<Integer>();
    
    if(map.get("listOfTypesOfLeaves")!=null){
    	listOfTypesOfLeaves = (List)map.get("listOfTypesOfLeaves");
    	
    }
    if(map.get("masDepartmentList")!=null){
    	masDepartmentList = (List)map.get("masDepartmentList");
    }

%>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script>
<%
		Calendar calendar=Calendar.getInstance();
	
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		
%>

serverdate = '<%=date+"/"+month+"/"+year%>'
window.onload=function()
{
	showLeaveBalance(20);
}
function showLeaveBalance(idvalue){
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :leaveBalance){
		int id = hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId();
		String leaveBalance1 = new DecimalFormat("0.##").format((double)Float.valueOf(hrEmployeeBalance.getClosingBalance()));
	%>
		js =<%= leaveBalance1%>;
		if(idvalue == <%=id%> ){
	    	document.getElementById('hrMasLeaveTypeNewId').value =<%=hrEmployeeBalance.getLeaveType().getLeaveType().getId()%>
	    	document.getElementById('leaveId').value = '<%= hrEmployeeBalance.getLeaveType().getId()%>'
	    	document.getElementById('balanceId').value='<%= hrEmployeeBalance.getId()%>';
	    	document.getElementById('shortLeaveTaken').value='<%= hrEmployeeBalance.getTaken()%>';
		}
		if(idvalue == "" ){
	    	document.getElementById('leaveId').value = '';
	    	document.getElementById('balanceId').value = '';
		}
		<%
	}
	%>
}	

var errorMsg = '';

function selectHalfDay(){
	//document.getElementById("leaveType").value='1';
	document.<%=APPLY_SHORT_LEAVE%>.<%=HALF_DAY%>[0].checked=true;

	if(document.<%=APPLY_SHORT_LEAVE%>.checkbox.checked) {
		document.getElementById("divHalfDay").style.display ='block';
		document.<%=APPLY_SHORT_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='1';
	} else {
		document.getElementById("divHalfDay").style.display ='none';
		document.<%=APPLY_SHORT_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='';
	}
	document.<%=APPLY_SHORT_LEAVE%>.<%=REASON%>.value='';
}

</script>


<form name="<%=APPLY_SHORT_LEAVE%>" method="post">
<div class="titleBg">
<h2>Short Leave Application</h2>
</div>
<div class="clear"></div>
<div class="Block">
<h4>
<div id="message"></div>
</h4>
<div class="division"></div>

<div class="clear"></div>
<div id="divHalfDay" style="display: block;" name="divHalfDay"><input
	type="radio" id="<%=SHORT_LEAVE_HALF_DAY%>" checked="checked"
	name="<%=SHORT_LEAVE_HALF_DAY%>" value="f" onclick=""
	class="radioCheck" /><label class="value">First Half</label> <input
	type="radio" id="<%=SHORT_LEAVE_HALF_DAY%>"
	name="<%=SHORT_LEAVE_HALF_DAY%>" value="s" onclick=""
	class="radioCheck" /><label class="value">Second Half</label></div>

<div class="clear"></div>
<div class="clear"></div>


<div class="Block">
<div class="clear"></div>
<div class="division"></div>
</div>



<script type="text/javascript">
    function chkForShortLeave()
    {
    	//alert(document.<%=APPLY_SHORT_LEAVE%>.<%=TO_DATE%>.value);
    	if(document.getElementById("leaveType").value==20)
    	{
    		
    			document.<%=APPLY_SHORT_LEAVE%>.<%=TO_DATE%>.value=document.<%=APPLY_SHORT_LEAVE%>.<%=FROM_DATE%>.value;
    			document.<%=APPLY_SHORT_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.value='0';
    			document.<%=APPLY_SHORT_LEAVE%>.<%=NO_OF_WORKING_DAYS%>.setAttribute("validate","");
    		
    	}
    }
    function chkForOptionalLeave(leaveId)
    {
    	
    	if(leaveId==21)
    	{
    		document.getElementById("listOfRestrictedForm").style.display="block";
    		document.getElementById("leaveBalanceDiv").style.display="none";
    		document.getElementById("dates").style.display="none";
    		//document.getElementById("divToDate").style.display="none";
    		
    		fillDates();
    	 	document.<%=APPLY_SHORT_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","Holiday,string,yes");
			document.<%=APPLY_SHORT_LEAVE%>.<%= NO_OF_WORKING_DAYS %>.value="1";
    	}
    	else if(leaveId!=2){
    		
    		document.getElementById("listOfRestrictedForm").style.display="none";
    		
    		document.getElementById("dates").style.display="block";
    	//	document.getElementById("divToDate").style.display="block";
    		//document.getElementById("divJoinDate").style.display="block";
    		document.<%=APPLY_SHORT_LEAVE%>.<%=FROM_DATE%>.setAttribute("validate","From Date,date,yes");
    		document.<%=APPLY_SHORT_LEAVE%>.<%=TO_DATE%>.setAttribute("validate","To Date,date,yes");
    		document.<%=APPLY_SHORT_LEAVE%>.<%=JOINING_DATE%>.setAttribute("validate","Joining Date,date,yes");
    		document.<%=APPLY_SHORT_LEAVE%>.<%=RESTRICTED_HOLIDAYS%>.setAttribute("validate","");
    	}
    	
    }
    function showEmployeeListAjax(obj){
    	var departmentId = obj.value;
    	if(departmentId != '0' && departmentId != ''){
    		submitProtoAjaxWithDivName('<%=APPLY_SHORT_LEAVE%>','/hms/hrms/leave?method=showEmpForDept','employeeDiv');
    	}
    }
    function showHideLineManager(obj){
    	var checkedLineOrOther = obj.value;
    	if(checkedLineOrOther == 'o'){
    		document.getElementById('divLineManager').style.display='none';
    		document.getElementById('<%=APPROVED_BY%>').setAttribute("validate","Approver,string,no");
    		document.getElementById('divOtherManager').style.display='block';
    		document.getElementById('<%=APPROVED_BY_OTHER%>').setAttribute("validate","Approver,string,yes");
    		document.getElementById('<%=DEPARTMENT_ID%>').setAttribute("validate","Department,string,yes");
    	}else{
    		document.getElementById('divLineManager').style.display='block';
    		document.getElementById('<%=APPROVED_BY%>').setAttribute("validate","Approver,string,yes");
    		document.getElementById('divOtherManager').style.display='none';
    		document.getElementById('<%=APPROVED_BY_OTHER%>').setAttribute("validate","Approver,string,no");
    		document.getElementById('<%=DEPARTMENT_ID%>').setAttribute("validate","Department,string,no");
    	}
    }
 function submitThisForm(){
 	if(checkForFromDate()){
	 	var shortLeaveTaken = document.getElementById('shortLeaveTaken').value;
	 	if(shortLeaveTaken >= 2){
	 		alert('You have already availed your short leaves for this month.');
	 		return false;
	 	}
		submitForm('<%=APPLY_SHORT_LEAVE%>','leave?method=submitLeaveForm','noSatSunOrHoliday');	  
 	}
 }
 function checkForFromDate(){
 		obj1 = document.<%=APPLY_SHORT_LEAVE%>.<%=FROM_DATE%>.value;
		if(obj1 != ""){
			fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	 		currentdate = new Date();
	 		if((obj1.substring(3,5) - 1) != currentdate.getMonth()){
	 			alert('Short leave can be not be applied except for current month.');
	 			return false;
	 		}else if((obj1.substring(3,5) - 1) == currentdate.getMonth()
	 			&& obj1.substring(6) != currentdate.getFullYear()){
	 			alert('Short leave can be not be applied except for current month.');
	 			return false;
	 		}
		}
		return true;
 }   
    </script> <input type="hidden" name="hrMasLeaveTypeNewId"
	id="hrMasLeaveTypeNewId" value="" /> <script type="text/javascript">
	
	</script>

<div class="clear"></div>

<div id="labelType" style="display: none;"><label>Type:</label><label
	class="value">Earned</label> <input type="hidden" id="typeId"
	name="<%=TYPE%>" value="1" /></div>

<div id="dates" style="display: block;">
<div id="datesForm" style="display: block;"><label><span>*</span>Leave
Date</label> <input name="<%=FROM_DATE%>" type="text" readonly
	validate='Leave Date,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calFromDate"
	onclick="javascript:setdate('',document.<%=APPLY_SHORT_LEAVE%>.<%=FROM_DATE%>,event)" />
</div>

<input type="hidden" name="<%=TO_DATE%>" readonly
	validate='To Date,date,no' value="" class="date" /></div>

<input type="hidden" name="<%=NO_OF_WORKING_DAYS%>" readonly
	maxlength="4" validate="No of working days,num,yes" value="1"><label><span>*</span>
Contact Number</label> <input type="text" name="<%=CONTACT_PHONE%>"
	maxlength="11" validate="Contact Number,int,yes"><label>Alternate
Email Id</label> <input type="text" name="<%=EMAIL%>" maxlength="50"
	validate="Email Id,email,no">
<div class="clear"></div>
<label><span>*</span> Reason</label> <textarea id="reason"
	name="<%=REASON %>" onkeydown="refreshLengthWithoutMeter1(this.id,200)"
	onkeyup="refreshLengthWithoutMeter(this.id,200)"
	validate="Reason,string,yes"></textarea>

<div class="clear"></div>

<input type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>"
	value="m" onclick="showHideLineManager(this)" checked="checked"
	class="radioCheck" /> <label class="value">Line Manager</label> <input
	type="radio" id="<%=MANAGER_TYPE%>" name="<%=MANAGER_TYPE%>" value="o"
	onclick="showHideLineManager(this);" class="radioCheck" /> <label
	class="value">Other</label>
<div class="clear"></div>

<div id="divLineManager" style="display: block;"><label><span>*</span>
Approver</label> <select name="<%=APPROVED_BY%>" id="<%=APPROVED_BY%>"
	validate="Approver,string,yes">
	<option value="">Select</option>
	<%List<UserManager> userList=(List<UserManager>)map.get("manager");
			Iterator iterator=userList.iterator();
			while(iterator.hasNext()){
				UserManager user = (UserManager)iterator.next();%>
	<option value="<%= user.getManagers().getId() %>"><%=user.getManagers().getFirstName()+" "+user.getManagers().getLastName()+" -- "+user.getManagers().getEmployeeCode()%></option>
	<%} %>
</select></div>

<div id="divOtherManager" style="display: none;"><label><span>*</span>
Department</label> <select name="<%=DEPARTMENT_ID%>" id="<%=DEPARTMENT_ID%>"
	validate="Department,string,no">
	<option value="" onclick="showEmployeeListAjax(this);">Select</option>
	<%for(MasDepartment masDepartment : masDepartmentList){%>
	<option onclick="showEmployeeListAjax(this);"
		value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%} %>
</select>
<div id="employeeDiv"><label><span>*</span> Approver</label> <select
	name="<%=APPROVED_BY_OTHER%>" id="<%=APPROVED_BY_OTHER%>"
	validate="Approver,string,no">
	<option value="">Select</option>
</select></div>
</div>

<div class="clear"></div>

<input type="hidden" name="holiday" /> <input type="hidden"
	name="typeFlag" /> <input type="hidden" name="typeFlagForJoiningDate"
	id="typeFlagForJoiningDate" value="shortLeave" /> <input type="hidden"
	id="leaveId" name="leaveIdForDatabase" value="" /> <input
	type="hidden" id="balanceId" name="balanceIdForDatabase" value="" /> <input
	type="hidden" id="shortLeaveTaken" name="shortLeaveTaken" value="" />

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="waitMessage" class="msg" style="display: none">Please
Wait...</div>
<div class="paddingTop15"></div>
<input type="button" name="apply" value="Apply" class="button"
	onclick="submitThisForm();" /> <input type="button" name="reset"
	value="Reset" class="buttonHighlight"
	onclick="location.href='leave?method=showLeaveApplicationJsp'" />

<div class="clear"></div></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

