<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hrms.masters.business.HrEncashmentDetails"%>
<%@page import="jkt.hms.masters.business.Users"%>

<script>
function selectBeforeOperation(){
  flag = true;
  if(document.<%=WAITING_LEAVES%>.checkbox.checked != undefined)	
		{
			if(document.<%=WAITING_LEAVES%>.checkbox.checked)
			{
				flag = false;					
			}
		}
  else{
	for(i=0;i<document.<%=WAITING_LEAVES%>.checkbox.length;i++){
		if(document.<%=WAITING_LEAVES%>.checkbox[i].checked)
		  flag=false;
	}
 }
	if(flag){
		alert("Select a record to perform any operation.")
		document.<%=WAITING_LEAVES%>.approve.disabled=false;
		document.<%=WAITING_LEAVES%>.back.disabled=false;
		document.<%=WAITING_LEAVES%>.disapprove.disabled=false;
		document.<%=WAITING_LEAVES%>.sendSuggestion.disabled=false;
	    return false;
	}
	return true;
}

function unSelected(){
  flag = true;
  if(document.<%=WAITING_LEAVES%>.checkbox.checked != undefined)	
		{
			if(document.<%=WAITING_LEAVES%>.checkbox.checked)
			{
				flag = false;					
			}
		}
  else{
	for(i=0;i<document.<%=WAITING_LEAVES%>.checkbox.length;i++){
		if(document.<%=WAITING_LEAVES%>.checkbox[i].checked)
		  flag=false;
	}
 }
	if(flag){
		location.href='leave?method=showWaitingLeaves';
	}
	return true;
	}
	
function suggestionMandatory(){
    if(document.<%=WAITING_LEAVES%>.suggestion.value==""){
		alert("Suggestion text cannot be blank.");	
	 	return false;
	} 
	return true;
}

function remarksMandatory(){
    if(document.<%=WAITING_LEAVES%>.disapproveMessage.value==""){
		alert("Remarks text cannot be blank.");	
	 	return false;
	} 
	return true;
}

function disableOthers(val){
	document.<%=WAITING_LEAVES%>.approve.disabled=true;
	document.<%=WAITING_LEAVES%>.back.disabled=true;
	val.disabled=false;
	if(val=="sendSuggestion")
		document.<%=WAITING_LEAVES%>.disapprove.disabled=true;
	if(val=="disapprove")
		document.<%=WAITING_LEAVES%>.sendSuggestion.disabled=true;
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}	
var state = 'none';
function openTextarea(layer_ref)
{
	
	if(selectBeforeOperation()){
	if (state == 'block') {
		state = 'none';
	}
	else {
		state = 'block';
	}
	if (document.all) { //IS IE 4 or 5 (or 6 beta)
		eval( "document.all." + layer_ref + ".style.display = state");
	}
	if (document.layers) { //IS NETSCAPE 4 or below
		document.layers[layer_ref].display = state;
	}
	if (document.getElementById && !document.all) {
		maxwell_smart = document.getElementById(layer_ref);
		maxwell_smart.style.display = state;
	}
	}
}
</script>

<form name="<%=WAITING_LEAVES%>" method="post">
<div class="titleBg">
<h2>Waiting Leaves</h2>
</div>
<div class="clear"></div>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List waitingLeaveList=(List)map.get("waitingLeavesList");
	List<HrEncashmentDetails> leaveEncashmentList = (List)map.get("leaveEncashmentList");
	Users loggedUser =(Users)session.getAttribute(USERS);
	int empid= loggedUser.getEmployee().getId();
	
	if((waitingLeaveList.size()>0 && waitingLeaveList!=null) || (leaveEncashmentList!=null && leaveEncashmentList.size()>0 )){
%>
<div id="pageNavPosition"></div>
<table id="waitingLeavelist" width="575">
	<tr>
		<th>From Date</th>
		<th>To Date</th>
		<th>Working Days</th>
		<th>Leave Type</th>
		<th>Employee Name</th>
		<th>Current Balance</th>
	</tr>
	<tbody id="tableData">
		<%      int i = 1;
		if(waitingLeaveList!=null && waitingLeaveList.size()>0)
		{
				Iterator iterator = waitingLeaveList.iterator();
				for (; iterator.hasNext(); i++) {
					HrLeaveDetails waitingLeaves = (HrLeaveDetails) iterator.next();
					
					if (i % 2 == 0) {
		%>
		<tr class="odd">
			<%
			} else {
			%>

			<tr class="even">
				<%
			}
			%>
				<%if(waitingLeaves.getFromDate()!=null) {%>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getFromDate())%></td>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getToDate())%></td>
				<%}
					  else{
					%>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"></td>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"></td>
				<%} %>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getNoOfWorkingDays()%></td>
				<td align="left"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=(waitingLeaves.getLeaveType().getLeaveType().getLeaveType())!=null?waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription():""%></td>
				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpId().getFirstName()%>
				<%=waitingLeaves.getEmpId().getLastName()%></td>
				<%
			//double allowedDays=0;
			//double leaveTaken=0;
			//double leaveAdjusted=0;
			//double balance = 0;
			//String leaveBalance1="";
			//if(waitingLeaves.getEmpIdBal()!=null){
	    	//	 allowedDays = Float.valueOf(waitingLeaves.getEmpIdBal().getLeaveType().getLeaveType().getAllowedDays());
    		//	 leaveTaken = Float.valueOf(waitingLeaves.getEmpIdBal().getTaken());
    		//	 leaveAdjusted = Float.valueOf(waitingLeaves.getEmpIdBal().getBalanceAdjustedBy());
    		//	  balance = 0;
    		//	balance = allowedDays - leaveTaken + leaveAdjusted;
    		//	  leaveBalance1 = new DecimalFormat("0.##").format((double)balance);
			//}
			
			%>

				<td align="center"
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>'"><%=waitingLeaves.getEmpIdBal().getClosingBalance()%></td>
			</tr>
			<%
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
						align="left"><%=encashmentDetails.getEmp().getFirstName()%> <%=encashmentDetails.getEmp().getLastName()%></td>
					<td
						onclick="location.href='leave?method=contactDetailsEncashment&leaveId=<%=encashmentDetails.getId()%>'"
						align="center">----</td>
				</tr>

				<% i++; }
		
				
			%>
			
	</tbody>

</table>
<div class="clear"></div>
<%
		} else { %>
<div class="clear"></div>
<h4>No leaves waiting for approval</h4>
<div class="clear"></div>
<%		
	}
%> <script>
var pager = new Pager('tableData',5); 
pager.init(); 
pager.showPageNav('pager', 'pageNavPosition'); 
pager.showPage(1);
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
