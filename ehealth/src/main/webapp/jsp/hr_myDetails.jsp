<%@page import="jkt.hms.masters.business.UploadDocuments"%>
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
<%@page import="jkt.hrms.masters.business.HrEmployeeBalance"%>

<% 
Map<String,Object> map=(Map)request.getAttribute("map");

Boolean waitingRecord=false;
Boolean waitingRecordEncashment=false;
if(map!=null){
	List<HrEmployeeBalanceNew> userBalance=(List)map.get("leaveBalance");
    List<Integer> empDependents = new ArrayList<Integer>();
    List<Object> empMatAvailedOrNot = new ArrayList<Object>();
    List<Object> empPatAvailedOrNot = new ArrayList<Object>();
    String statusMaternity ="";
    String statusPaternity ="";

    List leaveList=(List)map.get("leaveList");
	List<HrEncashmentDetails> leaveEncashmentList = (List)map.get("leaveEncashmentList");
	boolean encashmentListOnly=(Boolean)map.get("encashmentListOnly");
	List<HrMasLeaveTypeMediator> leaveTypeList =(List)map.get("leaveTypeList");
	List leaveStatusList = (List)map.get("leaveStatusList");
	List<Object[]>uploadViewDataList = new ArrayList<Object[]>();
    if(map.get("empDependents")!=null){
    	empDependents = (List)map.get("empDependents");
    }
    if(map.get("empMatAvailedOrNot")!=null){
    	empMatAvailedOrNot = (List)map.get("empMatAvailedOrNot");
    }
    if(map.get("empPatAvailedOrNot")!=null){
    	empPatAvailedOrNot = (List)map.get("empPatAvailedOrNot");
    }
    if(map.get("uploadViewDataList")!=null){
    	uploadViewDataList = (List<Object[]>)map.get("uploadViewDataList");
    }
    System.out.println("uploadViewDataList999=="+uploadViewDataList.size());
    int childrenCount = empDependents.get(0);
	Users loggedUser =(Users)session.getAttribute(USERS);
%>
<%@page import="jkt.hrms.masters.business.HrEncashmentDetails"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeMediator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.util.ArrayList"%>
<script>
	
function showLeaveBalance(idvalue){
	//alert(idvalue);
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :userBalance){
		int id = hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId();%>
		if(idvalue == <%=id%> ){
		<%
	    	double balance=0;
	    	if(hrEmployeeBalance.getClosingBalance()!=null){
	    		balance = (Float.valueOf(hrEmployeeBalance.getClosingBalance()));
	    	}
			String leaveBalance1 = new DecimalFormat("0.##").format((double)balance);
			if(hrEmployeeBalance.getLeaveType().getLeaveType().getLeaveType().getId()==8){%>
				document.getElementById('leaveBalanceDiv').style.display ='block';
		    	document.getElementById('balance').value = '--';
			<%}else{%>
				document.getElementById('leaveBalanceDiv').style.display ='block';
	    		document.getElementById('balance').value = '<%= leaveBalance1%>'
			<%}%>
		}
		if(idvalue == "" ){
			document.getElementById('leaveBalanceDiv').style.display ='block';
	    	document.getElementById('balance').value = '--';
		}
		<%
	}
	%>
}


function chkDate()
{
var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
obj1 = document.<%=MY_DETAILS%>.<%=FROM_DATE%>.value;
obj2 = document.<%=MY_DETAILS%>.<%=TO_DATE%>.value;
fromDate=new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
toDate=new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
if(obj1 != "" && obj2 != "")
{
//if(fromDate <= currentDate && toDate<= currentDate)
//{
if(fromDate > toDate)
{
alert(" From Date should be smaller than To Date. ");
return false;
}
//}else if(fromDate > currentDate && toDate > currentDate){
//alert("Both Dates should be smaller or equal to Current Date. ")
//return false;
//}
//else if(fromDate > currentDate){
//alert("From date should not be greater than today's Date ");
//return false;
//}
//else if(toDate > currentDate){
//alert("To Date should not be greater than today's Date");
//return false;
//}
}
//else if(obj1 != "" && obj2 == "")
//{
//alert(" Please enter both the Dates.");
//return false;
//}
//else if(obj1 == "" && obj2 != "")
//{
//alert(" Please enter both the Dates.");
//return false;
//}
return true;
}

function validateForm()
{
	fromdate = document.<%=MY_DETAILS%>.<%=FROM_DATE%>.value;
	todate = document.<%=MY_DETAILS%>.<%=TO_DATE%>.value;
	leaveStatus = document.<%=MY_DETAILS%>.<%=LEAVE_STATUS%>.value;
	leaveType = document.<%=MY_DETAILS%>.<%=LEAVE_TYPE%>.value;

	if(chkDate()){
		document.<%=MY_DETAILS%>.submit();
		return;
	}
	else{
		return false;
	}
	document.<%=MY_DETAILS%>.submit();

}


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



serverdate = '<%=date+"/"+month+"/"+year%>';

</script>

<div class="titleBg">
<h2>Search Leave Details</h2>
</div>
<div class="Block">
<h4>Leave Balance till <%=date+"/"+month+"/"+year%></h4>
<%
String sex ="";
String maritalStatusCode ="";
if(loggedUser.getEmployee().getPersonalDetails() != null){
	sex = loggedUser.getEmployee().getPersonalDetails().getGender().getAdministrativeSexName();
	maritalStatusCode = loggedUser.getEmployee().getPersonalDetails().getMaritalStatus().getMaritalStatusCode();
}
%> <label>Leave Type</label> <select id="leaveType" name="<%=TYPE%>"
	readonly onkeyup="showLeaveBalance(this.value);"
	onchange="showLeaveBalance(this.value);">
	<option value="">Select</option>
	<%for(HrMasLeaveTypeMediator hrMasLeaveType:leaveTypeList){
			if(hrMasLeaveType.getLeaveType().getStatus().equals("y")
					&& !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(20)){
	    			if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("male") && hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)){ 
	    				if(childrenCount < 3 && statusPaternity.equals("n") ){%>
	<option
		value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("female") &&  hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3)){
		    				if(childrenCount < 3 && statusMaternity.equals("n") ){ %>
	<option
		value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%	} %>
	<%} else { 
	    				if(!hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)
	    					&&  !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3)){ %>
	<option
		value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%}}}%>
</select>

<div id="leaveBalanceDiv" style="display: block;"><label>Balance
</label> <input type="text" id="balance" readonly  name="<%=LEAVE_BALANCE%>" readonly="readonly" value=""  maxlength="10" />
	
</div>
<div class="clear"></div>
<input type="button" class="button" value="Leave Status Report"	onclick="location.href='leave?method=printEmployeeLeaveCard'">

</div>
<form name="<%=MY_DETAILS%>" method="post" action="leave?method=showMyDetails">
<div class="Block">
<h4>Leave History</h4>
<label>From Date </label> <input
	name=<%=FROM_DATE%> value="" type="text" readonly class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calFromDate"
	onclick="javascript:setdate('',document.<%=MY_DETAILS%>.<%=FROM_DATE%>,event)" />

<label>To Date </label> <input name=<%=TO_DATE%> value="" type="text"
	readonly="" class="date" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" id="calToDate"
	onclick="javascript:setdate('',document.<%=MY_DETAILS%>.<%=TO_DATE%>,event)" />

<div class="clear"></div>

<label>Leave Type </label> <select name="<%=LEAVE_TYPE%>">
	<option value="">Select</option>
	<%	
for(HrMasLeaveTypeMediator hrMasLeaveType:leaveTypeList){
	if(hrMasLeaveType.getLeaveType().getStatus().equals("y")
			&& !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(20)){
			if(maritalStatusCode.equalsIgnoreCase("M") 
					&& sex.equalsIgnoreCase("male") && hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)){ 
				if(childrenCount < 3 && statusPaternity.equals("n") ){%>
	<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
					&& sex.equalsIgnoreCase("female") &&  hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3)){
    				if(childrenCount < 3 && statusMaternity.equals("n") ){ %>
	<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%	} %>
	<%} else { 
				if(!hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)
					&&  !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3)){ %>
	<option value="<%=hrMasLeaveType.getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%}}}%>
</select> <label>Leave Status </label> <select name="<%=LEAVE_STATUS%>">
	<option value="">Select</option>
	<%	
ListIterator leaveStatusListIterator = leaveStatusList.listIterator();
while(leaveStatusListIterator.hasNext())
{
HrMasLeaveStatus leaveStatus = (HrMasLeaveStatus)leaveStatusListIterator.next();
%>
	<option value=<%=leaveStatus.getId()%>><%=leaveStatus.getStatusDesc()%>
	</option>
	<% } %>
</select> <%-- <label class="auto">Encashable Leave Details</label> <input
	type="checkbox" name="<%=ENCHASHMENT_CHECK %>" value="y"
	class="radioCheck" /> --%>
<div class="clear"></div>
<input type="button" value="Submit" class="button"
	onclick="validateForm();"> <input type=reset value=Reset
	class="button"> <input type="button" name="back" value="Back"
	class="button" onclick="location.href='leave?method=showLeaveDetails'" />
<div class="clear"></div>


<div id="testDiv"></div>
<h4>Leave History</h4>
<div class="clear"></div>
<% 
if((leaveList!=null && leaveList.size() > 0)||(leaveEncashmentList!=null && leaveEncashmentList.size()>0 ))
{			
%>

<div id="pageNavPosition"></div>
<table id="waitingLeavelist" width="100%" cellpadding="0"
	cellspacing="0">
	<tr>
		<th>Select</th>
		<th>From Date</th>
		<th>To Date</th>
		<th>Working Days</th>
		<th>Leave Type</th>
		<th>Reason</th>
		<th>Status</th>
		<th>View Document</th>
	</tr>
	<tbody id="tableData">

		<%	
int i=1;
if(leaveList!=null){

Iterator iterator1=leaveList.iterator();

for(;iterator1.hasNext();i++)
{
	
HrLeaveDetails leavesList=(HrLeaveDetails)iterator1.next();	
int statusOfLeave=leavesList.getLeaveStatus().getId();
if(i%2==0)
{
%>
		<tr class="odd">
			<%
}
else
{
%>

			<tr class="even">
				<%
}
%>
				<%
if(statusOfLeave==3||statusOfLeave==2)
	{
	waitingRecord=true;
	}
if(statusOfLeave==6 || statusOfLeave==5 ||statusOfLeave==4){ 
waitingRecord=true;%>
				<td align="center"><input type="checkbox" name="checkbox"
					disabled="disabled" value="<%=leavesList.getId() %>"
					class="radioCheck"></td>
				<%}else{ %>
				<td><input type="checkbox" name="checkbox"
					value="<%=leavesList.getId() %>" class="radioCheck"></td>
				<%}if(leavesList.getFromDate()!=null) {%>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leavesList.getFromDate())%></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leavesList.getToDate())%></td>
				<%}
else{
%>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"></td>
				<%} %>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"><%=leavesList.getNoOfWorkingDays()%></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"><%=leavesList.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="left"><%=leavesList.getReason()%></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'"
					align="center"><%=leavesList.getLeaveStatus().getStatusDesc()%></td>
					
				<%
				int uploadId = 0;
				String fileName = "";
				String fileExtension = "";
				if(uploadViewDataList.size()>0){
					  for(Object[] uploadDocuments :uploadViewDataList){
						if(uploadDocuments[0].equals(leavesList.getId())){
						  System.out.println("uploadDocuments===="+uploadDocuments[0]);
							uploadId = (Integer)uploadDocuments[3];
							fileExtension = (String)uploadDocuments[2];
							fileName = (String)uploadDocuments[1];
						}
					  }}
					%>	
			
			<td><a href="#" onclick="submitFormForButton('<%=MY_DETAILS%>','/hms/hms/investigation?method=viewUploadDocuments&viewFrom=IP&uploadedDocumentId=<%=uploadId%>&filename=<%=fileName+"."+fileExtension%>')"><%=fileName+"."+fileExtension%></a></td>  <!-- File Having Link to Download--> 
				
				
			</tr>
			<%	}

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
					<%if(statusOfLeave==3){ 
			waitingRecordEncashment=true;%>
					<td align="center"><input type="checkbox"
						name="checkboxEncashment" value="<%=encashmentDetails.getId() %>"
						class="radioCheck"></td>
					<%}else{ %>
					<td><input type="checkbox" name="checkboxEncashment"
						value="<%=encashmentDetails.getId() %>" disabled="disabled"
						class="radioCheck"></td>
					<%} %>
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

				<% i++; }%>

				<%
}
else
{ %>
				<%if(encashmentListOnly){ %>
				<h4>No Encashment Leave Details</h4>
				<%}else{ %>
				<h4>No Leave Details</h4>

				<%} %>
				<%} %>
			
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div id="deleteRemarks" style="display: block;"><label><span>*</span>Reason</label>
<textarea name="deleteMessage" rows="6" maxlength="250" class="textareaMediua"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	validate="Reason,string,yes"></textarea>
<div class="clear"></div>
</div>
<input name="send" type="button" value="Cancel Leave" class="buttonBig"
	onclick="submitForm('<%=MY_DETAILS%>','leave?method=deleteLeaves','selectBeforeOperation');"><input
	type=reset value=Reset class="button"> <!-- <input name="reset" type="button" value="Reset" class="buttonHighlight"	onclick="location.href='leave?method=showMyDetails'"> --></div>

<script>
<% 
if((leaveList!=null && leaveList.size() > 0)||(leaveEncashmentList!=null && leaveEncashmentList.size()>0 ))
{			
%>
document.getElementById("deleteRemarks").style.display='block';
<%}else{%>
document.getElementById("deleteRemarks").style.display='none';
<%}%>
</script> <%	} %> <script>
var pager = new Pager('tableData',5); 
pager.init(); 
pager.showPageNav('pager', 'pageNavPosition'); 
pager.showPage(1);
</script>

<h4>
<div id="message"></div>
</h4>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<script>
function selectBeforeOperation()
{
flag = true;
waitingRecord=<%=waitingRecord%>;
waitingRecordEncashment=<%=waitingRecordEncashment%>;
if(waitingRecord  || waitingRecordEncashment)
{

	if(waitingRecord){
		if(document.<%=MY_DETAILS%>.checkbox.checked != undefined)	
		{
			if(document.<%=MY_DETAILS%>.checkbox.checked)
			{
				flag = false;
			}
		}
		else
		{
			for(i=0;i<document.<%=MY_DETAILS%>.checkbox.length;i++)
			{
				if(document.<%=MY_DETAILS%>.checkbox[i].checked)
					flag=false;
			}
		}
	}
	
	if(waitingRecordEncashment){
		if(document.<%=MY_DETAILS%>.checkboxEncashment.checked != undefined)	
		{
			if(document.<%=MY_DETAILS%>.checkboxEncashment.checked)
			{
				flag = false;					
			}
		}
		else
		{	
			for(i=0;i<document.<%=MY_DETAILS%>.checkboxEncashment.length;i++)
			{
				if(document.<%=MY_DETAILS%>.checkboxEncashment[i].checked)
					flag=false;
			}
		}
	}
	
	if(flag)
	{
		alert("Select a leave to cancel.")
		return false;
	}
		document.getElementById("deleteRemarks").style.display="block";
}
else{
	alert("No leave in waiting status to cancel.");
}

return true;

}
</script>