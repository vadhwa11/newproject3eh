<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="jkt.hrms.masters.business.HrUpdateLeaveBalanceHistory"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
		Users loggedUser =(Users)session.getAttribute(USERS);
%>

serverdate = '<%=date+"/"+month+"/"+year%>';
</script>


<form name="showLeaveHistory" method="post">
<div class="titleBg">
<h2>Leave Update History</h2>
</div>
<div class="clear"></div>

<%
		        Map map = (Map)request.getAttribute("map");
		        if(map.containsKey("employeeList"))
		        {
 			        List employeeList = (List)map.get("employeeList");
 			        String employeeName = "";
 		  %>
<div class="Block">
<label><span>*</span> Employee Name</label>
<select	name="<%=EMP_NAME%>" class="select3" validate='Employee name,nothing,yes'>
<option value="">Select</option>
	<%
 			        for(Iterator iter = employeeList.iterator(); iter.hasNext();)
 			        {
 			        	MasEmployee user = (MasEmployee)iter.next();	
 			        	employeeName=user.getFirstName().concat(" ").concat(user.getLastName());
 			%>
	<option value="<%=user.getId()%>"><%=user.getFirstName()%> <%=user.getLastName()%>
	<%="-"%><%=user.getEmployeeCode()%></option>
	<%}%>
</select></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="View History" value="View History"	class="buttonBig"	onclick="submitForm('showLeaveHistory','leave?method=viewLeaveHistory');" />
<%	 if(map.containsKey("employeeList"))
		{%> 
<input type="button" name="Update" value="Update" class="button" onClick="submitForm('showLeaveHistory','leave?method=viewLeaveBalance')" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %> 
<script>
<%
if(request.getParameter(EMP_NAME)!= null && !request.getParameter(EMP_NAME).equals(""))
{%>	
document.showLeaveHistory.<%=EMP_NAME%>.value = '<%=request.getParameter(EMP_NAME)%>'; 
<% } %>
</script> <% }
	else if(map.containsKey("userName"))
	{
	String userName = (String)map.get("userName");
%> 
<div class="Block">
<label>Employee Name</label> 
<label class="value"><%=loggedUser.getEmployee().getFirstName() %>
<%=loggedUser.getEmployee().getLastName() %></label>
<div class="clear"></div></div>
<%}

if(map.containsKey("leaveHistoryList"))
{
	List leaveHistoryList = (List)map.get("leaveHistoryList");
	if(leaveHistoryList.size() != 0 && leaveHistoryList != null )
	{
		 %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<h4>Leave Update History</h4>
<div id="pageNavPosition"></div>
<table>
	<tr>
		<th>Modified By Name</th>
		<th>Modified By Emp Code</th>
		<th>Previous Balance</th>
		<th>Current Balance</th>
		<th>Leave Type</th>
		<th>Remarks</th>
		<th>Modified At</th>
	</tr>

	<tbody id="tableData">
		<%	
		
			int i = 1;
			for (Iterator iter = leaveHistoryList.iterator(); iter.hasNext();)
			{
				HrUpdateLeaveBalanceHistory leaveHistory = (HrUpdateLeaveBalanceHistory)iter.next();
				String modifiedByName = leaveHistory.getUsers().getFirstName().concat(" ").concat(leaveHistory.getUsers().getLastName());
				String modifiedEmpCode = leaveHistory.getUsers().getEmployeeCode();
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
				<td><%=modifiedByName%></td>
				<td><%=modifiedEmpCode%></td>
				<td><%=leaveHistory.getPreviousLeaveBalance()%></td>
				<td><%=leaveHistory.getNewLeaveBalance()%></td>
				<td><%=leaveHistory.getLeaveType().getLeaveType().getLeaveType().getDescription()%></td>
				<td><%=leaveHistory.getRemarks()%></td>
				<td><%=LeaveManagementUtil.convertDateToStringWithoutTime(leaveHistory.getModifiedAt())%></td>

			</tr>
			<%		i++;	
			 }
		%>
		
	</tbody>
</table>

<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
	</script>
<div class="clear"></div>
<%}
			else
			{
				if(map.containsKey("employeeList"))
				{
					if(session.getAttribute("firstTime").equals("firstTime"))
					{%>
<div class="clear"></div>
<h4>No Leave Update History</h4>
<div class="clear"></div>
<%					}
					else if(session.getAttribute("firstTime").equals("secondTime"))
					{
				%>
<div class="clear"></div>
<h4>No Leave Update History</h4>
<div class="clear"></div>
<%		
					}
					
				}else{ %>
<div class="clear"></div>
<h4>No Leave Update History</h4>
<div class="clear"></div>
<%}
			}
	}
%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

