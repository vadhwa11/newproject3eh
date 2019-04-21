<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<%@page
	import="jkt.hrms.recruitment.masters.business.ResourceRequisition"%>

<%@page
	import="jkt.hrms.recruitment.masters.business.Resumepersonaldetails"%>
	
<form name="<%=APPROVED_LEAVES%>" method="post">
<div class="titleBg">
<h2>Approved Leaves</h2>
</div>
<div class="clear"></div>
<div class="Block">
<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	List approvedLeavesList=(List)map.get("approvedLeavesList");

	
	if((approvedLeavesList.size()>0 && approvedLeavesList!=null) ){
%>
<div id="pageNavPosition"></div>
<table id="waitingLeavelist" width="575">
	<tr>
		<th>Name</th>
		<th>Date Of Birth</th>
		<th>Domain Knowledge</th>
		<th>Current Designation</th>
	</tr>

	<tbody id="tableData">
		<%		
			
			Iterator iterator=approvedLeavesList.iterator();
			int i=1;
			for(;iterator.hasNext();i++)
			{
				Resumepersonaldetails approvedLeaves=(Resumepersonaldetails)iterator.next();
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

				<td align="center"><%=approvedLeaves.getFirstName()%></td>
				<td align="center"><%=approvedLeaves.getDateOfBirth()%></td>
				<td align="left"><%=approvedLeaves.getDomainKnowledge()%></td>

				<td align="center"><%=approvedLeaves.getCurrentDesignation() %></td>
			</tr>
			<%	}
			
	
			}
			else
			{
				out.println("<font size=\"2\"><b>No leaves approved</b></font>");
				%>
			<br />
			<%
			}
		%>
		
	</tbody>
</table>

<script>
	var pager = new Pager('tableData',2); 
	pager.init(); 
	pager.showPageNav('pager', 'pageNavPosition'); 
	pager.showPage(1);
</script>

<div class="clear"></div>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
