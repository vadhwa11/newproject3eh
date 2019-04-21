<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%
Map map = (Map)request.getAttribute("map");
List<MstrTask> taskList = (List)map.get("taskList");

%>

<select name="<%=TASK_ID %>" validate="Task ,string,yes">
	<option value="">Select</option>
	<%for(MstrTask task : taskList){ %>
	<option value="<%=task.getId() %>"><%=task.getTaskName() %></option>
	<%} %>
</select>
