
<%
Map map = new HashMap();
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	List<MstrTask> taskList = new ArrayList<MstrTask>();
	if(map.get("taskList")!=null)
	{
		taskList = (List)map.get("taskList");
	}
%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<div id="taskDiv"><select name="task" id="task"
	validate='Task,string,yes' onclick="chkProjectSelect()">
	<option value="">Select</option>
	<%
	for(MstrTask obj:taskList)
	{%>
	<option value=<%=obj.getId() %>><%=obj.getTaskName() %></option>
	<%}
	%>
</select></div>