
<%	Map map = new HashMap();
	List<MasEmployee> managerList = new ArrayList<MasEmployee>();
	List<Tbltimesheet> tbltimesheetList = new ArrayList<Tbltimesheet>();
	List<TbltimesheetAprl> tblTimeSheetAprList = new ArrayList<TbltimesheetAprl>();
	int currentEmpId =0;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}if(map.get("currentEmpId")!=null)
	{
		currentEmpId = (Integer)map.get("currentEmpId");
	}if(map.get("managerList")!=null)
	{
		managerList = (List)map.get("managerList");
	}if(map.get("tbltimesheetList")!=null)
	{
		tbltimesheetList = (List)map.get("tbltimesheetList");
	}if(map.get("tblTimeSheetAprList")!=null)
	{
		tblTimeSheetAprList = (List)map.get("tblTimeSheetAprList");
	}%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hrms.masters.business.Tbltimesheet"%>
<%@page import="jkt.hrms.masters.business.TbltimesheetAprl"%>

<%@page import="java.text.NumberFormat"%>
<div id="timeSheetDiv">
<table id="timesheetTable">
	<tr>
		<th>Project</th>
		<th>Site</th>
		<th>Task</th>
		<th>Hours</th>
		<th>Comments</th>
		<th>Approver Comments</th>
		<th><input type="checkbox" id="chkToReject" class="radioCheck"
			onclick="selectAll(this,'a')">Appr</input></th>
		<th><input type="checkbox" id="chkToReject" class="radioCheck"
			onclick="selectAll(this,'b')">Back</input></th>
		<th><input type="checkbox" id="chkToReject" class="radioCheck"
			onclick="selectAll(this,'r')">Reject</input></th>
		<th><input type="checkbox" id="chkToReject" class="radioCheck"
			onclick="selectAll(this,'f')">Fwd</input></th>
		<th>Fwd To</th>
	</tr>

	<tbody id="tableData">
		<input type="hidden" id="tbSheetSize" name="tbSheetSize"
			value="<%=tbltimesheetList.size() %>" />
		<%	int i=0;

for(Tbltimesheet obj: tbltimesheetList)
{
	if(obj.getStatus().equalsIgnoreCase("submitted"))
	{
		if(i%2==0)
		{%>
		<tr id="row<%=i %>" class="odd" onclick="">
			<%}else{%>
			<tr "row <%=i %>" class="even" onclick="">
				<%}%>
				<td><%=obj.getProjectID().getPrjName()+" "+obj.getProjectID().getPrjCode() %><input
					type="hidden" name="hide<%=i%>" id="hide<%=i%>"
					value="<%=obj.getId() %>" /></td>
				<td><%=obj.getSiteID() == null ? " --- " : obj.getSiteID().getSiteName()%></td>
				<td><%=obj.getTaskID().getTaskName() %></td>
				<td><%=obj.getHrsWorked() %><input type="hidden"
					name="hrs<%=i%>" id="hrs<%=i%>" value="<%=obj.getHrsWorked() %>" /></td>
				<td><%=obj.getComments() %></td>
				<td><input type="text" name="appCom<%=i %>"
					value="<%=(obj.getAppComments()!=null)?obj.getAppComments():"" %>"></td>
				<td><input type="radio" id="chkAction<%=i %>"
					name="chkAction<%=i %>" value="a" class="radioCheck"></td>
				<td><input type="radio" id="chkAction<%=i %>"
					name="chkAction<%=i %>" value="b" class="radioCheck"></td>
				<td><input type="radio" id="chkAction<%=i %>"
					name="chkAction<%=i %>" value="r" class="radioCheck"></td>
				<td><input type="radio" id="chkAction<%=i %>"
					name="chkAction<%=i %>" value="f" class="radioCheck"></td>
				<td><select name="manager<%=i%>" id="manager<%=i%>">
					<option value="0">Select</option>
					<%if(managerList!=null && managerList.size()>0)
		{
			for(MasEmployee manager :managerList)
				if(manager.getLineManager()!=null)
				{
			{%>
					<option value="<%=manager.getLineManager().getId() %>"><%= manager.getLineManager().getFirstName()+" "+manager.getLineManager().getLastName()%></option>
					<%}}
		}%>
				</select></td>
				<%}if(obj.getStatus().equalsIgnoreCase("forwarded"))
		{
			for(TbltimesheetAprl  apvObj : tblTimeSheetAprList)
			{
				if((obj.getId()).equals(apvObj.getTmshtId()))
				{
					if((apvObj.getApprover())== currentEmpId)
					{
						if(i%2==0)
						{%>
				<tr id="row<%=i %>" class="odd" onclick="">
					<%}else{%>
					<tr id="row<%=i %>" class="even" onclick="">
						<%}%>
						<td><%=obj.getProjectID().getPrjName()+" "+obj.getProjectID().getPrjCode() %><input
							type="hidden" name="hide<%=i%>" id="hide<%=i%>"
							value="<%=obj.getId() %>" /></td>
						<td><%=obj.getSiteID() == null ? " --- " : obj.getSiteID().getSiteName()%></td>
						<td><%=obj.getTaskID().getTaskName() %></td>
						<td><%=obj.getHrsWorked() %><input type="hidden"
							name="hrs<%=i%>" id="hrs<%=i%>" value="<%=obj.getHrsWorked() %>" /></td>
						<td><%=obj.getComments() %></td>
						<td><input type="text" name="appCom<%=i %>"
							value="<%=(obj.getAppComments()!=null)?obj.getAppComments():"" %>"></td>
						<td><input type="radio" name="chkAction<%=i %>" value="a"
							class="radioCheck"></td>
						<td><input type="radio" name="chkAction<%=i %>" value="b"
							class="radioCheck"></td>
						<td><input type="radio" name="chkAction<%=i %>" value="r"
							class="radioCheck"></td>
						<td><input type="radio" name="chkAction<%=i %>" value="f"
							class="radioCheck"></td>
						<td><select name="manager<%=i%>" id="manager<%=i%>">
							<option value="0">Select</option>
							<%if(managerList!=null && managerList.size()>0)
						{
							for(MasEmployee manager :managerList)
								if(manager.getLineManager()!=null)
								{
							{%>
							<option value="<%=manager.getLineManager().getId() %>"><%= manager.getLineManager().getFirstName()+" "+manager.getLineManager().getLastName()%></option>
							<%}}
						}%>
						</select></td>
						<%}
					}
				}
			}
		i++;
		}%>
					</tr>
	</tbody>
</table>

</div>

