<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<%@page
	import="jkt.hrms.recruitment.masters.business.ResourceRequisition"%>

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
		<th>Initiator Name</th>
		<th>Required Skill</th>
		<th>No Of Positions</th>
		<th>Proposed Designation</th>
	</tr>

	<tbody id="tableData">
		<%		
			
			Iterator iterator=approvedLeavesList.iterator();
			int i=1;
			for(;iterator.hasNext();i++)
			{
				ResourceRequisition approvedLeaves=(ResourceRequisition)iterator.next();
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

				<td align="center"><%=approvedLeaves.getInitiatorName()%></td>
				<td align="center"><%=approvedLeaves.getRequiredSkill()%></td>
				<td align="left"><%=approvedLeaves.getNoOfPositionOccupied()%></td>

				<td align="center"><%=approvedLeaves.getProposedDesignation() %></td>
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
