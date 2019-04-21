<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrUserLeavebalance"%>
<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalance"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hrms.masters.business.HrEncashmentDetails"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.ArrayList"%>
<script type="text/javascript" language="javascript"
	src="/jktintranet/jsp/javascript/calendar.js"></script>
	
<script>
<% 
	session.setAttribute("update", true);
	
	Map<String,Object> map=(Map)request.getAttribute("map");
	Map empDetailsMap = (Map)map.get("empDetailsMap");
	
	List<MasEmployee> userList = (List)empDetailsMap.get("userList");
	MasEmployee user = (MasEmployee)userList.get(0);
	String empName = user.getFirstName().concat(" ").concat(user.getLastName());
	String empCode = user.getEmployeeCode();

	List<HrEmployeeBalanceNew> leaveBalanceList = (List)empDetailsMap.get("leaveBalanceList");
	List<HrEncashmentDetails> leaveEncashmentList = (List)map.get("leaveEncashmentList");
    List<Integer> empDependents = new ArrayList<Integer>();
    List<Object> empMatAvailedOrNot = new ArrayList<Object>();
    List<Object> empPatAvailedOrNot = new ArrayList<Object>();
	
	Users loggedUser =(Users)session.getAttribute(USERS);
	String balance = "";
	String oldbalance = "";
	String onsiteBalance = "";
    String statusMaternity ="";
    String statusPaternity ="";
    if(map.get("empDependents")!=null){
    	empDependents = (List)map.get("empDependents");
    }
    if(map.get("empMatAvailedOrNot")!=null){
    	empMatAvailedOrNot = (List)map.get("empMatAvailedOrNot");
    }
    if(map.get("empPatAvailedOrNot")!=null){
    	empPatAvailedOrNot = (List)map.get("empPatAvailedOrNot");
    }
	
//	if(leaveBalanceList!=null && leaveBalanceList.size()>0 )
//	{
//		HrEmployeeBalance leaveBalance = (HrEmployeeBalance)leaveBalanceList.get(0);
//		balance = leaveBalance.getEarned();
//		oldbalance=balance;
		//onsiteBalance = leaveBalance.getOnsiteUkBalance();
//	}
    if(empMatAvailedOrNot.size()>0){
    	statusMaternity = (String)empMatAvailedOrNot.get(0);
    }
    if(empPatAvailedOrNot.size()>0){
    	statusPaternity = (String)empPatAvailedOrNot.get(0);
    }
    int childrenCount = empDependents.get(0);

	String sex ="";
	String maritalStatusCode ="";
	if(loggedUser.getEmployee().getEmployeePersonalDetails() != null){
		sex = loggedUser.getEmployee().getEmployeePersonalDetails().getGender().getAdministrativeSexName();
		maritalStatusCode = loggedUser.getEmployee().getEmployeePersonalDetails().getMaritalStatus().getMaritalStatusCode();
	}
%>

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



var errorMsg = '';
	
function showChangedLeaveBalance(idvalue){
	//alert(idvalue);
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :leaveBalanceList){
		int id = hrEmployeeBalance.getId();
		//int balance = (Integer.parseInt(hrEmployeeBalance.getEarned()));
		//int balanceId = hrEmployeeBalance.getId();
	%>
		if(idvalue == <%=id%> ){
		<%
			//double allowedDays = Float.valueOf(hrEmployeeBalance.getLeaveType().getLeaveType().getAllowedDays());
			//double leaveTaken = Float.valueOf(hrEmployeeBalance.getTaken());
			//double leaveAdjusted = Float.valueOf(hrEmployeeBalance.getBalanceAdjustedBy());
			
			//double balance1 = 0;
			//balance1= Float.valueOf(hrEmployeeBalance.getClosingBalance())+leaveAdjusted;
			//balance1 = allowedDays - leaveTaken + leaveAdjusted;
			//String leaveBalance1 = new DecimalFormat("0.##").format((double)balance1);

			double allowedDays=0;
	    	double leaveTaken=0;
	    	double leaveAdjusted=0 ;
	    	double earned=0;
	    	double leavebalance=0;
	    	
	    	if(hrEmployeeBalance.getLeaveType().getLeaveType().getAllowedDays()!=null){
	    		 allowedDays = Float.valueOf(hrEmployeeBalance.getLeaveType().getLeaveType().getAllowedDays());
	    	}
	    	if(hrEmployeeBalance.getEarned()!=null){
	    		 earned = Float.valueOf(hrEmployeeBalance.getEarned());
	    	}
	    	if(hrEmployeeBalance.getTaken()!=null) {
	    		 leaveTaken = Float.valueOf(hrEmployeeBalance.getTaken());
	    	}
	    	if(hrEmployeeBalance.getBalanceAdjustedBy()!=null) {
	    		 leaveAdjusted = Float.valueOf(hrEmployeeBalance.getBalanceAdjustedBy());
	    	}	
	    	if(hrEmployeeBalance.getOpeningBalance()!=null){
	    		//leavebalance =  Float.valueOf(hrEmployeeBalance.getOpeningBalance())+leaveAdjusted-leaveTaken+earned;
	    		leavebalance =  Float.valueOf(hrEmployeeBalance.getClosingBalance());
	    	}
	    	String leaveBalance1 = new DecimalFormat("0.##").format((double)leavebalance);
		%>
	    	document.getElementById('balance').value = '<%= leaveBalance1%>'
			document.getElementById('oldBalance').value = '<%= leaveBalance1%>'
			document.getElementById('leaveTypeId').value = '<%= hrEmployeeBalance.getLeaveType().getId()%>'
		}
		if(idvalue == "" ){
	    	document.getElementById('balance').value = '';
	    	document.getElementById('oldBalance').value = '';
	    	document.getElementById('leaveTypeId').value = '';
		}
		<%
	}
	%>
}

function remarksMandatory(){
//flag = false;
var bal = document.showLeaveBalance.<%=LEAVE_BALANCE%>.value;
var rem = document.showLeaveBalance.remarks.value;
//var re = /\s*((\S+\s*)*)/;
//.replace(re, "$1")
	if(trimAll(bal) == "" && trimAll(rem) == ""){
		errorMsg += "Leave Balance cannot be blank.\n";
		errorMsg += "Remarks text cannot be blank.\n";	
	 	return false;
	}
	if(trimAll(bal) == ""){
		errorMsg += "Leave Balance cannot be blank.\n";	
		return false;
	}
	if(trimAll(rem) == ""){
		errorMsg += "Remarks text cannot be blank.\n";	
		return false;
	}
	return true;
}
</script>

<form name="showLeaveBalance" method="post">
<div class="titleBg">
<h2>Leave Balance Details</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="leaveBalance"><font face="bold" color="blue">
<div id="messageformail"></div>
</font>
<div class="clear"></div>

<label>Employee Code </label><label class="value"><%=empCode %></label>
<label>Employee Name </label><label class="value"><%=empName %></label>
</div>
<div class="clear"></div>
<label><span>*</span> Leave Type</label> <select id="leaveType"
	name="<%=TYPE%>" validate="Leave Type,nothing,yes" readonly
	onkeyup="showChangedLeaveBalance(this.value);"
	onchange="showChangedLeaveBalance(this.value);">
	<option value="">Select</option>
	<%
		for(HrEmployeeBalanceNew balance2:leaveBalanceList){ 
			if(balance2.getLeaveType().getLeaveType().getLeaveType().getId()!=8
					&& balance2.getLeaveType().getLeaveType().getLeaveType().getId()!=20
					&& balance2.getLeaveType().getLeaveType().getStatus().equals("y")){
    			if(maritalStatusCode.equalsIgnoreCase("M") 
    					&& sex.equalsIgnoreCase("male") && balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)){ 
    				if(childrenCount < 3 && statusPaternity.equals("n") ){%>
	<option value="<%=balance2.getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
    					&& sex.equalsIgnoreCase("female") &&  balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
	    				if(childrenCount < 3 && statusMaternity.equals("n") ){ %>
	<option value="<%=balance2.getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%	} %>
	<%} else { 
    				if(!balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
    					&&  !balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){ %>
	<option value="<%=balance2.getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%}}}%>
</select> <input type="hidden" id="oldBalance" name="<%=OLD_LEAVE_BALANCE%>"
	value="<%=oldbalance %>" /> <input type="hidden" id="leaveTypeId"
	name="<%=LEAVE_TYPE_ID%>" value="" /> <label><span>*</span>
Leave Balance</label> <input type="text" id="balance" name="<%=LEAVE_BALANCE%>"
	value="<%=balance %>" validate="Leave Balance,num,no" maxlength="5" />



<br />

<div class="clear"></div>
<label><span>*</span> Remarks</label> <textarea id="remarks"
	name="remarks" rows="3" maxlength="500"
	onkeydown="refreshLengthWithoutMeter1(this.id,45)"
	onkeyup="refreshLengthWithoutMeter(this.id,45)"
	onkeyup="finalCheck(this)" validate="Remarks,string,no"></textarea>
<div class="clear"></div>



<%
	List leaveDetailsList = (List)empDetailsMap.get("leaveDetailsList");
	if((leaveDetailsList.size() != 0 && leaveDetailsList != null) || (leaveEncashmentList!=null && leaveEncashmentList.size()>0 ) )
	{
%>
<div class="division"></div>
<h4>Leave Details</h4>
<div id="pageNavPosition"></div>
<table id="waitingLeavelist" width="575">
	<tr>
		<th>From Date</th>
		<th>To Date</th>
		<th>Working Days</th>
		<th>Leave Type</th>
		<th>Reason</th>
		<th>Status</th>
	</tr>

	<tbody id="tableData">
		<%	
		
			int i = 1;
			if(leaveDetailsList!=null){
			for (Iterator iter = leaveDetailsList.iterator(); iter.hasNext();)
			{
				HrLeaveDetails leaveDetails = (HrLeaveDetails)iter.next();
				if(i%2==0)
				{
		%>
		<tr class="odd"
			onclick="location.href='leave?method=contactDetails&leaveId='+<%=leaveDetails.getId()%>">
			<%
		  		}
		  		else
		  		{
		%>

			<tr class="even"
				onclick="location.href='leave?method=contactDetails&leaveId='+<%=leaveDetails.getId()%>">
				<%
		  		}
		%>
				<% if(leaveDetails.getFromDate()!=null){ %>
				<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getFromDate())%></td>
				<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveDetails.getToDate())%></td>
				<%} else { %>
				<td align="center"></td>
				<td align="center"></td>
				<%} %>
				<td align="center"><%=leaveDetails.getNoOfWorkingDays()%></td>
				<td align="center"><%=leaveDetails.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td align="left"><%=leaveDetails.getReason()%></td>
				<td align="center"><%=leaveDetails.getLeaveStatus().getStatusDesc()%></td>
			</tr>
			<%		i++;	
			 }
			}
			for(HrEncashmentDetails encashmentDetails:leaveEncashmentList){ 
				int statusOfLeave=encashmentDetails.getLeaveStatus().getId();
					if(i%2==0)
					{
						%>
			<tr class="odd">
				<%
					}else{
					%>

				<tr class="even">
					<%
					}
					%>

					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center">---------</td>
					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center">---------</td>

					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center"><%=encashmentDetails.getLeaveToEncash()%></td>
					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center"><%=encashmentDetails.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="left"><%=encashmentDetails.getReason()%></td>
					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center"><%=encashmentDetails.getLeaveStatus().getStatusDesc()%></td>
				</tr>

				<% i++; }
				%>
			
	</tbody>
</table>
<div class="clear"></div>
<%}
			else
			{%>
<h4>No Leave Record</h4>
<%		}%> <script>
	var pager = new Pager('tableData',5); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>

<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="update" value="Update" class="button" onClick="submitForm('showLeaveBalance','leave?method=updateLeaveBalance','remarksMandatory');" />
<input type="button" name="back" value="View History" class="buttonBig" onclick="location.href='leave?method=viewLeaveHistory&empName=<%=user.getId()%>'" />
<!-- <input type="button" name="View History" value="View History" class="buttonBig" onclick="submitForm('showLeaveBalance','leave?method=viewLeaveHistory');"/> -->
<input type=reset value=Reset class="button">
<input	type="button" name="back" value="Back" class="button" onclick="location.href='leave?method=searchLeaveBalance'" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=EMP_NAME%>" value="<%=user.getId()%>" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
function messageForMail(){
if(document.getElementById('messageformail'))
			document.getElementById('messageformail').innerHTML ='Sending mail, please wait...';
			return true;
}
</script>
