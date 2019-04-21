<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.StringTokenizer"%>

<script>


var urlForSubmit = '';

	// & operater added by dhananjay at the end of urlForSubmit    10-11-2016
	
function setUrl(idvalue){

		if(idvalue == "hold" ){
	    	urlForSubmit = 'leave?method=sendSuggestion&';
	    	document.getElementById('recomedDiv').style.display = 'none';
		}
		if(idvalue == "approve" ){
	    	urlForSubmit = 'leave?method=approveLeaves&';
	    	document.getElementById('recomedDiv').style.display = 'none';
		}
		
		if(idvalue == "disapprove" ){
	    	urlForSubmit = 'leave?method=disapproveLeaves&';
	    	document.getElementById('recomedDiv').style.display = 'none';
		}
		if(idvalue == "recomedNo" ){
			
			document.getElementById('recomedDiv').style.display = 'block';
	    	urlForSubmit = 'leave?method=recomendLeaves&';
		}
		if(idvalue == "recomedYes" ){
	    	urlForSubmit = 'leave?method=recomendLeaves&';
	    	document.getElementById('recomedDiv').style.display = 'none'; // added by amit das on 15-11-2016
		}
		
		if(idvalue == "" ){
			document.getElementById('recomedDiv').style.display = 'none';
	    	urlForSubmit = "";
	    	//document.getElementById('leaveId').value = '';
	    	//document.getElementById('balanceId').value = '';
		}
}

function submitThisForm(){
	submitForm('<%=WAITING_LEAVES%>',urlForSubmit+csrfTokenName+'='+csrfTokenValue);
}

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
		location.href='leave?method=showWaitingLeaves'+csrfTokenName+'='+csrfTokenValue;
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
  window.open(theURL+csrfTokenName+'='+csrfTokenValue,winName,features);
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
 function chkForPL(field,leaveStatus,joinDate,empFName,empLName)
    {
    if(field.checked)
    {
    if(leaveStatus==6)
    {
    	alert(empFName+' '+empLName+' wants to cancel approved leave');
    }
    }
    	if(joinDate!=''){
		joinDate=new Date(joinDate.substring(0,4),(joinDate.substring(5,7)-1),joinDate.substring(8,10));
		dayOfToDate=joinDate.getDate();
		monthOfToDate=joinDate.getMonth();
		yearOfToDate=joinDate.getFullYear();
		var jdate=new Date(yearOfToDate, monthOfToDate, dayOfToDate)
		var one_day=1000*60*60*24;
		
    	today = new Date();
    	
    	var gap=Math.ceil((today.getTime()-jdate.getTime())/(one_day));
    	if(gap<=183)
    	{
    		alert(empFName+ ' does not completed 6 month after joining');
    	}
    	}
    }
</script>

<form name="<%=WAITING_LEAVES%>" method="post" enctype="multipart/form-data">
<div class="titleBg">
<h2>Leaves Waiting for Approval/Recommend</h2>
</div>
<div class="clear"></div>
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List waitingLeaveList=(List)map.get("waitingLeavesList");
	int userType = 0;
	int userId = 0;
	if(map.get("userType") != null){
		userType = (Integer)map.get("userType");
	}
	if(map.get("userId") != null){
		userId = (Integer)map.get("userId");
	}
	
	if(waitingLeaveList.size()>0 && waitingLeaveList!=null){
%>
<div class="Block">
<div id="pageNavPosition"></div>
<table id="waitingLeavelist">

	<tr>
		<th>Select</th>
		<!-- <th>Leave Id</th> -->
		<th>From Date</th>
		<th>To Date</th>
		<th>Working Days</th>
		<th>Leave Type</th>
		<th>Employee Name</th>
		<th>Reason</th>
		<th>Remarks</th>
		<th>Current Balance</th>
		 <%if(userType==1){ %>
		<th>File</th>
		<%} %>
	</tr>
	<tbody id="tableData">

		<%
		int i = 0;
		Iterator iterator = waitingLeaveList.iterator();
				for (i = 1; iterator.hasNext(); i++) {
					HrLeaveDetails waitingLeaves = (HrLeaveDetails) iterator.next();
					//if (i % 2 == 0) {
		%>
		<%-- <tr class="odd">
			<%
			} else {
			%>

			<tr class="even">
				<%
			}
			%> --%>
			<tr>
				<td ><input type="checkbox" name="checkbox<%=i %>" value="<%=waitingLeaves.getId() %>" class="radioCheck" onclick="chkForPL(this,'<%=waitingLeaves.getLeaveStatus().getId() %>','<%=waitingLeaves.getEmpId().getJoinDate()%>','<%=waitingLeaves.getEmpId().getEmployeeName() %>','<%=waitingLeaves.getEmpId().getLastName()%>')"></td>
				<%-- <td><%=waitingLeaves.getId() %></td> --%>
				<%if(waitingLeaves.getFromDate()!=null) {%>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getFromDate())%></td>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=LeaveManagementUtil.convertDateToStringWithoutTime(waitingLeaves.getToDate())%></td>
				<%}
					  else{
					%>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"></td>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"></td>
				<%} %>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getNoOfWorkingDays()%></td>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getEmpId().getEmployeeName()%>
				<%-- <%=waitingLeaves.getEmpId().getLastName()%> --%></td>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getReason()%></td>
				<%  
				//double allowedDays =  Float.valueOf(waitingLeaves.getLeaveType().getLeaveType().getAllowedDays());
				//double taken = Float.valueOf(waitingLeaves.getEmpIdBal().getTaken());
				//double leaveAdjusted = Float.valueOf(waitingLeaves.getEmpIdBal().getBalanceAdjustedBy());
				
				//double balance = 0;
				//balance = allowedDays - taken + leaveAdjusted; 
				//String balanceToShow = new DecimalFormat("0.##").format((double)balance);
			%>
				<td onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getSuggestion() != null?waitingLeaves.getSuggestion():""%></td>
				
				<%
				if(waitingLeaves.getLeaveType().getLeaveType().getLeaveType().getId()!=8){
			%>
				<td
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue"><%=waitingLeaves.getEmpIdBal()!=null && waitingLeaves.getEmpIdBal().getClosingBalance()!=null?waitingLeaves.getEmpIdBal().getClosingBalance():0%></td>

				<%}else {				%>
				<td 
					onclick="location.href='leave?method=contactDetails&leaveId=<%=waitingLeaves.getId()%>&csrfTokenName=csrfTokenValue">---------</td>
				<%} %>
			 	<%if(userType==1){ %>
				<td><input type="file" name="<%=RequestConstants.UPLOAD_FILENAME + i %>" id="<%=RequestConstants.UPLOAD_FILENAME + i %>" /></td> 
<%} %>
			</tr>
			<%
		}
		%>
		
	</tbody>
</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<script>
	var pager = new Pager('tableData',5); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>

<div class="clear"></div>

<label> Leave Status</label> <select id="leaveAppStatus" onblur="checkForSelect();"
	name="<%=TYPE%>" readonly validate="Leave Status,string,no"
	onkeyup="setUrl(this.value);" onchange="setUrl(this.value);">

	<option value="">Select</option>
	<!-- <option value="hold">On Hold</option> -->
	<option value="approve">Approve</option>
	<option value="disapprove">Disapprove</option>

</select>



<label>Remarks </label>
 <textarea name="remarks" id="remarks" rows="6" maxlength="250" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)">
	</textarea><br>
	
	<label> Recommend  </label>
		<select name="recommend" id="recommend" validate="Recommend,string,no" onblur="checkForSelect();"
		 onkeyup="setUrl(this.value);" onchange="setUrl(this.value);" >
	 	 <option value="">Select</option>
	 		<option value="recomedYes">Yes</option>
	 		<option value="recomedNo">No</option>
	 	</select>
<div class="clear"></div>
<div id="recomedDiv" style="display:none" >
<label><span>*</span>Remarks </label> <textarea name="recomendRemarks" id="recomendRemarksId" rows="6" validate="Recommend,string,no"
	maxlength="250" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea><br>
	</div>
<div class="clear"></div>
<div class="division"></div>

<input name="send" type="button" value="Submit" class="button"
	onclick="submitThisForm();"><input type=reset value=Reset
	class="button"> <%
		} else { %>
<h4>No leaves waiting for approval</h4>
<div class="clear"></div>
<%
	}
%> 

<input type="button" name="back" value="Back" class="button" onclick="location.href='leave?method=showLeaveStatus'" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="clear"></div>
<font face="bold" color="blue">
<div id="message"></div>
</font> <br />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
function checkForSelect(){
	
	if(document.getElementById('leaveAppStatus').value!=""){
		document.getElementById('recommend').disabled=true;
	
	}else if(document.getElementById('recommend').value!=""){
		document.getElementById('leaveAppStatus').disabled=true;
	}else  {
		document.getElementById('recommend').disabled=false;
		document.getElementById('leaveAppStatus').disabled=false;
	}
	if(document.getElementById('recommend').value= 'recomedYes'){
	<%if(userType ==1){%>
		document.getElementById('remarks').value='Recommended By State Admin';
		<%}%>
	}
}

</script>