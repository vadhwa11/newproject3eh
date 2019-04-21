<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="jkt.hrms.masters.business.HrUserLeavebalance"%>
<%@page import="jkt.hrms.masters.business.HrMasLeave"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveStatus"%>
<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>

<% 
	Map<String,Object> map=(Map)request.getAttribute("map");
	List<HrEmployeeBalanceNew> encashableMasLeaveType = new ArrayList<HrEmployeeBalanceNew>();
	List<UserManager> managers = new ArrayList<UserManager>();
	String message=null;
	if(map!=null)
	{
		if(map.get("encashableMasLeaveType")!= null){
			encashableMasLeaveType = (List)map.get("encashableMasLeaveType");
		}
		if(map.get("managers")!= null){
			managers = (List)map.get("managers");
		}
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
	}

	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hrms.masters.business.UserManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalance"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script>

function showLeaveBalance(idvalue){
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :encashableMasLeaveType){
		int id = hrEmployeeBalance.getId();
		
		//double allowedDays = Float.valueOf(employeeBalance.getLeaveType().getLeaveType().getAllowedDays());
	//	double leaveTaken = Float.valueOf(employeeBalance.getTaken());
	//	double leaveAdjusted = Float.valueOf(employeeBalance.getBalanceAdjustedBy());
	//	double balance = 0;
	//	balance= Float.valueOf(employeeBalance.getClosingBalance());
		
    	double balance=0;
    	
   		if(hrEmployeeBalance.getClosingBalance()!=null){
	   	 	balance =  Float.valueOf(hrEmployeeBalance.getClosingBalance());
   		}
		//balance = allowedDays - leaveTaken + leaveAdjusted;
		double unforBalance=0;
	
		if(hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent()!=null && !hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent().equals(0)){
			 unforBalance = ((balance)*(hrEmployeeBalance.getLeaveType().getLeaveType().getEncashablePercent()))/100;
		}else{
			 unforBalance=((balance)-(hrEmployeeBalance.getLeaveType().getLeaveType().getBufferRequired()));
		}
		
		int balance1=(int)unforBalance;
			//new DecimalFormat("0.##").format((double)unforBalance);
	%>
		if(idvalue == <%=id%> ){
	    	document.getElementById('balance').value = '<%= balance1%>'
	    	document.getElementById('leaveId').value = '<%= hrEmployeeBalance.getLeaveType().getId()%>'
	    	document.getElementById('balanceId').value = '<%= hrEmployeeBalance.getId()%>'
		}
		if(idvalue == "" ){
	    	document.getElementById('balance').value = '-----';
	    	document.getElementById('leaveId').value = '';
	    	document.getElementById('balanceId').value = '';
		}
		
		<%
	}

	%>
		
}
function checkEnchashedDays(){
	encashableBalance = document.<%=ENCASHMENT_LEAVE_FORM%>.<%=LEAVE_BALANCE%>.value;
	toEncash = document.<%=ENCASHMENT_LEAVE_FORM%>.<%=LEAVE_TO_ENCASH%>.value;
	
	encashableBalance=parseInt(encashableBalance);
	toEncash=parseInt(toEncash);
	
	if(toEncash>encashableBalance){
		alert("Leaves To Encash can't be greater than Leave Balance");
		return false;
	}
	return true
}

function submitThisForm(){
	val=checkEnchashedDays();
	if(val==true)
	{
		submitForm('<%=ENCASHMENT_LEAVE_FORM%>','leave?method=applyForEncashment');
	}
	
}

</script>
<div class="titleBg">
<h2>Leave Encashment</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="<%=ENCASHMENT_LEAVE_FORM%>" method="post">
<%
		if(message!= null){
	%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label><span>*</span> Leave Type </label> <select id="leaveType"
	name="<%=TYPE%>" readonly validate="Type,nothing,yes"
	onchange="showLeaveBalance(this.value);"
	onkeyup="showLeaveBalance(this.value);">
	<option value="">Select</option>
	<%
			
			for(HrEmployeeBalanceNew employeeBalance:encashableMasLeaveType){
				%>
	<option value="<%=employeeBalance.getId()%>"><%=employeeBalance.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<% 
			}
		%>
</select> <script>
			document.<%=ENCASHMENT_LEAVE_FORM%>.<%=TYPE%>.focus();
		</script> <label>Encashable Balance </label> <input type="text" id="balance"
	class="readOnly" value="-----" name="<%=LEAVE_BALANCE%>"
	readonly="readonly" maxlength="10" /> <label><span>*</span>
Leaves To Encash </label> <input type="text" id="toEncash"
	name="<%=LEAVE_TO_ENCASH%>" validate="Leaves To Encash,int,yes"
	maxlength="10" />

<div class="clear"></div>
<label><span>*</span> To be Approved By</label> <select
	name="<%=APPROVED_BY%>" validate="To be Approved By,string,yes">
	<option value="">Select</option>
	<%  
		for(UserManager userManager:managers)
		{
		%>
	<option value="<%= userManager.getManagers().getId() %>"><%=userManager.getManagers().getFirstName()+" "+userManager.getManagers().getLastName() +" - "+userManager.getManagers().getEmployeeCode() %></option>
	<%} %>
</select> <label><span>*</span> Reason</label> <textarea name="<%=REASON %>"
	maxlength="200" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	validate="Reason,string,yes"></textarea> <input type="hidden"
	id="leaveId" name="leaveIdForDatabase" value="" /> <input
	type="hidden" id="balanceId" name="balanceIdForDatabase" value="" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="apply" value="Apply" class="button" onclick="submitThisForm();" />
<input type="button" name="reset" value="Reset" class="buttonHighlight"	onclick="location.href='leave?method=encashLeaves'" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
