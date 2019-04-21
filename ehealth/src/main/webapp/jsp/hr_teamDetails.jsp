<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveStatus"%>
<%@page import="jkt.hrms.masters.business.HrLeaveDetails"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hrms.masters.business.HrEncashmentDetails"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeMediator"%>
<%@page import="jkt.hrms.masters.business.HrEmployeeBalanceNew"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.Users"%> 
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
serverdate = '<%=date+"/"+month+"/"+year%>';
<% 
	Map<String,Object> map=(Map<String,Object>)request.getAttribute("map");
	List<HrEmployeeBalanceNew> userBalance=new ArrayList<HrEmployeeBalanceNew>();
	if(map.get("leaveBalance")!=null){
			userBalance=(List)map.get("leaveBalance");
	}
	List empNamesList=new ArrayList();
	if(map.get("empNames")!=null){
		empNamesList=(List)map.get("empNames");
	}
	List<HrLeaveDetails> leaveList=(List)map.get("leaveList");
    List<Integer> empDependents = new ArrayList<Integer>();
    List<Object> empMatAvailedOrNot = new ArrayList<Object>();
    List<Object> empPatAvailedOrNot = new ArrayList<Object>();
    String statusMaternity ="";
    String statusPaternity ="";

	List<HrEncashmentDetails> leaveEncashmentList = (List)map.get("leaveEncashmentList");

	boolean encashmentListOnly=(Boolean)map.get("encashmentListOnly");

	List<HrMasLeaveTypeMediator> leaveTypeList =(List)map.get("leaveTypeList");

	List leaveStatusList = (List)map.get("leaveStatusList");
    if(map.get("empDependents")!=null){
    	empDependents = (List)map.get("empDependents");
    }
    if(map.get("empMatAvailedOrNot")!=null){
    	empMatAvailedOrNot = (List)map.get("empMatAvailedOrNot");
    }
    if(map.get("empPatAvailedOrNot")!=null){
    	empPatAvailedOrNot = (List)map.get("empPatAvailedOrNot");
    }
    if(empMatAvailedOrNot.size()>0){
    	statusMaternity = (String)empMatAvailedOrNot.get(0);
    }
    if(empPatAvailedOrNot.size()>0){
    	statusPaternity = (String)empPatAvailedOrNot.get(0);
    }
    int childrenCount = empDependents.get(0);
    Users loggedUser =(Users)session.getAttribute(USERS);
	Boolean flag=(Boolean)map.get("flag");
%>

function chkDate()
{
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
	obj1 = document.<%=TEAM_DETAILS%>.<%=FROM_DATE%>.value;
	obj2 = document.<%=TEAM_DETAILS%>.<%=TO_DATE%>.value;
	fromDate=new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	toDate=new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
	if(obj1 != "" && obj2 != "")
	{
		if(fromDate > toDate)
		{
			alert("From Date should be smaller than To Date. ");
			return false;
		}
	}
	return true;
}

function memberNameEmpty(){
	if(document.<%=TEAM_DETAILS%>.memberId.value==''){
		alert("Please Select team member to see details")
		return false;
	}	
	return true;
}
	
function showLeaveBalance(idvalue){
	//alert(idvalue);
	<%
	for(HrEmployeeBalanceNew hrEmployeeBalance  :userBalance){
		int id = hrEmployeeBalance.getLeaveType().getId();
	%>
		if(idvalue == <%=id%> ){
			<%
		    	double leavebalance=0;
		    	if(hrEmployeeBalance.getClosingBalance()!=null){
		    		leavebalance =  Float.valueOf(hrEmployeeBalance.getClosingBalance());
		    	}//double balance = 0;
		    		//balance = allowedDays - leaveTaken + leaveAdjusted;
		    	String leaveBalance1 = new DecimalFormat("0.##").format((double)leavebalance);
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

</script>

<!-- function for pagination -->

<script type="text/javascript">
 

</script>
<%
String sex ="";
String maritalStatusCode ="";
if(loggedUser.getEmployee().getPersonalDetails() != null){
	sex = loggedUser.getEmployee().getPersonalDetails().getGender().getAdministrativeSexName();
	maritalStatusCode = loggedUser.getEmployee().getPersonalDetails().getMaritalStatus().getMaritalStatusCode();
}
%>
<form name="<%=TEAM_DETAILS%>" method="post" action="">
<div class="titleBg">
<h2>My Team Member Leave Details</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Select Team
Member</label> <select name="memberId">
	<option value="">Select</option>
	<%
	if(map.get("empNames")!=null){
		
		empNamesList=(List)map.get("empNames");
		Iterator nameIterator=empNamesList.iterator();
		for(int i=1;nameIterator.hasNext();i++ ){
			MasEmployee element = (MasEmployee) nameIterator.next();
%>

	<option value="<%=element.getId()%>"><%=element.getFirstName() %>
	<%=element.getLastName() %> <%="-"%><%=element.getEmployeeCode()%></option>
	<%}} %>
</select>
<div class="clear"></div>

<label>From Date</label> <input name=<%=FROM_DATE%> value="" type="text"
	readonly class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calFromDate"
	onclick="javascript:setdate('',document.<%=TEAM_DETAILS%>.<%=FROM_DATE%>,'event')" />

<label>To Date</label> <input name=<%=TO_DATE%> value="" type="text"
	readonly class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calFromDate"
	onclick="javascript:setdate('',document.<%=TEAM_DETAILS%>.<%=TO_DATE%>,'event')" />

<div class="clear"></div>
<label>Leave Type</label> <select name="<%=LEAVE_TYPE%>">
	<option value="">Select</option>
	<%for(HrMasLeaveTypeMediator leaveType:leaveTypeList){
					if(leaveType.getLeaveType().getStatus().equals("y")
							&& !leaveType.getLeaveType().getLeaveType().getId().equals(20)){
			    			if(maritalStatusCode.equalsIgnoreCase("M") 
			    					&& sex.equalsIgnoreCase("male") && leaveType.getLeaveType().getLeaveType().getId().equals(4)){ 
			    				if(childrenCount < 3 && statusPaternity.equals("n") ){%>
	<option value="<%=leaveType.getId()%>"><%=leaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
			    					&& sex.equalsIgnoreCase("female") &&  leaveType.getLeaveType().getLeaveType().getId().equals(3)){
				    				if(childrenCount < 3 && statusMaternity.equals("n") ){ %>
	<option value="<%=leaveType.getId()%>"><%=leaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%	} %>
	<%} else { 
			    				if(!leaveType.getLeaveType().getLeaveType().getId().equals(4)
			    					&&  !leaveType.getLeaveType().getLeaveType().getId().equals(3)){ %>
	<option value="<%=leaveType.getId()%>"><%=leaveType.getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%}}}%>
</select> <label>Leave Status</label> <select name="<%=LEAVE_STATUS%>">
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
</select> <label class="auto">Encashable Leave Details</label> <input
	type="checkbox" name="<%=ENCHASHMENT_CHECK %>" value="y"
	class="radioCheck" />
 <br />
 <script>
	<%
 		if(request.getParameter("memberId")!= null && !request.getParameter("memberId").equals(""))
		{
	%>	
		document.<%=TEAM_DETAILS%>.memberId.value = '<%=request.getParameter("memberId")%>'; 
	<% } %>
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="showDetails" value="Show Details" class="buttonBig" onclick="submitForm('<%=TEAM_DETAILS%>','leave?method=showTeamMemberDetail','memberNameEmpty','chkDate');" />
<input type=reset value=Reset class="button">
<input	type="button" name="back" value="Back" class="button"	onclick="submitForm('<%=TEAM_DETAILS%>','leave?method=showLeaveDetails')" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<br />
 <% 
 	String balance="";
	String onsiteBalance = "";
	//balance = userBalance.getLeaveBalance();
 	//onsiteBalance = userBalance.getOnsiteUkBalance();
	//Integer locationId=(Integer)map.get("locationId");
 	//if(locationId==null)
	//	locationId=0;
	//int locId=locationId.intValue();
	//List leaveList=(List)map.get("leaveList");
	//Integer rhFirstHalf = (Integer)map.get("rhFirstHalf");
	//Integer rhSecondHalf = (Integer)map.get("rhSecondHalf");
	
 %> <%
if(flag){ 
	%>
 <div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block" id="leaveBalance">
<div class="clear"></div>
<h4>Leave Balance till <%=date+"/"+month+"/"+year%></h4>
<div class="clear"></div>
<label>Leaves Type</label> <select id="leaveType" name="<%=TYPE %>"
	readonly onkeyup="showLeaveBalance(this.value);"
	onchange="showLeaveBalance(this.value);">
 	<option value="">Select</option>
	<%for (HrEmployeeBalanceNew balance2:userBalance){ 
			if(balance2.getLeaveType().getLeaveType().getLeaveType().getStatus().equals("y")
					&& !balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(8)
					&& !balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(20)){
				if(maritalStatusCode.equalsIgnoreCase("M") 
					&& sex.equalsIgnoreCase("male") && balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)){ 
					if(childrenCount < 3 && statusPaternity.equals("n") ){%>
	<option value="<%=balance2.getLeaveType().getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
						&& sex.equalsIgnoreCase("female") &&  balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){
	    				if(childrenCount < 3 && statusMaternity.equals("n") ){ %>
	<option value="<%=balance2.getLeaveType().getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%	} %>
	<%} else { 
					if(!balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(4)
						&&  !balance2.getLeaveType().getLeaveType().getLeaveType().getId().equals(3)){ %>
	<option value="<%=balance2.getLeaveType().getId()%>"><%=balance2.getLeaveType().getLeaveType().getLeaveType().getDescription()%></option>
	<%}%>
	<%}}}%>
</select> <%
			 //	double allowedDays = Float.valueOf(userBalance.get(0).getLeaveType().getLeaveType().getAllowedDays());
	    	//	double leaveTaken = Float.valueOf(userBalance.get(0).getTaken());
	    	//	double leaveAdjusted = Float.valueOf(userBalance.get(0).getBalanceAdjustedBy());
	    		
	    	//	double balanceInFloat = 0;
	    	//	balanceInFloat = allowedDays - leaveTaken + leaveAdjusted;
	    	//	String leaveBalanceToShow = new DecimalFormat("0.##").format((double)balanceInFloat);
 	    		double allowedDays=0;
		    	double leaveTaken=0;
		    	double leaveAdjusted=0 ;
		    	double earned=0;
		    	double leavebalance=0;
 		    	if(userBalance.get(0).getLeaveType().getLeaveType().getAllowedDays()!=null){
		    		 allowedDays = Float.valueOf(userBalance.get(0).getLeaveType().getLeaveType().getAllowedDays());
		    	}
		    	if(userBalance.get(0).getEarned()!=null){
		    		 earned = Float.valueOf(userBalance.get(0).getEarned());
		    	}
		    	if(userBalance.get(0).getTaken()!=null)
		    	{
		    		
		    		 leaveTaken = Float.valueOf(userBalance.get(0).getTaken());}
		    		 
 		    	if(userBalance.get(0).getBalanceAdjustedBy()!=null)
		    	{
		    		 leaveAdjusted = Float.valueOf(userBalance.get(0).getBalanceAdjustedBy());
		    	}	
		    	if(userBalance.get(0).getOpeningBalance()!=null){
		    		
		    		leavebalance =  Float.valueOf(userBalance.get(0).getOpeningBalance())+leaveAdjusted-leaveTaken;
		    	
		    	}//double balance = 0;
		    	//balance = allowedDays - leaveTaken + leaveAdjusted;
	    		String leaveBalance1 = new DecimalFormat("0.##").format((double)leavebalance);
 		%>
<div id="leaveBalanceDiv" style="display: block;">
<label>Balance</label> <input type="text" id="balance" class="readOnly"
	name="<%=LEAVE_BALANCE%>" readonly="readonly" value="-------"
	maxlength="10" /></div>

 <div class="clear"></div>
</div>
 <div class="paddingTop15"></div>
<%	
	if((leaveList != null && leaveList.size()>0) || (leaveEncashmentList!=null && leaveEncashmentList.size()>0 )){
%>
<div class="clear"></div>
 <h4>Leave Details</h4>
<div id="pageNavPosition"></div>
<table id="waitingLeavelist" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>From Date</th>
		<th>To Date</th>
		<th>Working Days</th>
		<th>Leave Type</th>
		<th>Reason</th>
		<th>Status</th>
	</tr>
 	<tbody id="tableData">
 		<%	int i=1;
			if(leaveList!=null){
  			Iterator iterator1=leaveList.iterator();
			for(;iterator1.hasNext();i++)
			{
			HrLeaveDetails leavesList=(HrLeaveDetails)iterator1.next();	
			if(i%2==0)
				{
 		%>
		<tr class="odd"
			onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'">
			<%
		  		}
		  		else
		  		{
		%>
 			<tr class="even"
				onclick="location.href='leave?method=contactDetails&leaveId=<%=leavesList.getId()%>'">
				<%
		  		}
		%>
				<%if(leavesList.getFromDate()!=null) {%>
				<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leavesList.getFromDate())%></td>
				<td align="center"><%=LeaveManagementUtil.convertDateToStringWithoutTime(leavesList.getToDate())%></td>
				<%}
					  else{
					%>
				<td align="center"></td>
				<td align="center"></td>
				<%} %>
				<td align="center"><%=leavesList.getNoOfWorkingDays()%></td>
				<td align="center"><%=leavesList.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td align="left"><%=leavesList.getReason()%></td>
				<td align="center"><%=leavesList.getLeaveStatus().getStatusDesc()%></td>
			</tr>

			<%  }
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
<% } 
	else
	{ %> <%if(encashmentListOnly){ %>
<h4>No Encashment Leave Details</h4>
<%}else{ %>
<h4>No Leave Details</h4>
<%} %> <%} %> <%} %> <script>
 var pager = new Pager('tableData',5); 
	        pager.init(); 
	        pager.showPageNav('pager', 'pageNavPosition'); 
	        pager.showPage(1);
   </script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form> 