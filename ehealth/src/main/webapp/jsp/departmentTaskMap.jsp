<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DepartmentTaskMap.jsp  
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Vishal
 * Create Date: 15th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MstrDeptTaskMap"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
	List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
	List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
	
	
	 if(map.get("departmentList")!=null){
		 departmentList=(List<MasDepartment>)map.get("departmentList");
		}
	
	 if(map.get("deptTaskMapList")!=null){
		 deptTaskMapList=(List<MstrDeptTaskMap>)map.get("deptTaskMapList");
		 
		}
	 if(map.get("mstrTaskList")!=null){
		 mstrTaskList=(List<MstrTask>)map.get("mstrTaskList");
	} 
%>



<div class="titleBg"> 
<h2>Department Task Mapping</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" action="">
<div class="Block">

<label><span>* </span>Department</label>
    <select name="<%=DEPARTMENT_TYPE %>" onchange="populateTasks(this,'tempId')" validate="Department,int,yes">
             	<option value="0">Select</option>
                 	<%for(MasDepartment masDepartment:departmentList){ %>
            	 <option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
   					<%} %>
	</select>
 <div class="clear"></div>
 <div class="division"></div>
  <div class="clear"></div>
<label class="hdTitle">&nbsp;&nbsp;&nbsp;Available Tasks</label>
<label class="white"> </label>

<label class="white"> </label>
<label class="hdTitle">To Be Assigned Tasks</label>
 <div class="clear"></div>
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">
    <%for(MstrTask mstrTask : mstrTaskList){ %>
     <option value="<%=mstrTask.getId()%>"><%=mstrTask.getTaskName()%></option>
     <%} %>
</select>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
 	 
     
     
</select>
<div class="clear"></div>
<div class="division"></div>
 <div class="clear"></div>
 <div class="paddingTop15"></div>
  <div class="paddLeft155">
<input type="button" class="button" name="Assign" value="Save" onclick="submitForm('task','/hms/hrms/projectTrackingMaster?method=saveDeptTasks')">  
 </div>
 <div class="clear"></div>
 <div class="paddingTop15"></div>
</div>	

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function populateTasks(obj,id)
{
	var sel = document.getElementById(id);
	removeAllOptions(sel);
		
	if(obj.value!="All"){
	<%for(MasDepartment department : departmentList ){%>
		
		if(obj.value == <%=department.getId()%>){
			
			
			<%
		//	Set taskMap = department.getDeptTaskMaps();
			List<MstrDeptTaskMap> taskMapList = new ArrayList();
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
		//	if(taskMap!=null)
		//	{
		//		taskMapList = new ArrayList(taskMap);
		//		Collections.sort(taskMapList,new TaskComparator());	
	   //	}
				
			
			
			
			
			for(MstrDeptTaskMap taskMap1:taskMapList){
				if(taskMap1.getStatus().equals("y")){
			%>
				optionRepMan = new Option("<%=taskMap1.getTask().getTaskName()%>" , "<%=taskMap1.getTask().getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}
			}%>
			
			
		
		}
		<%}%>
		}
		
				
	
}






function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}

function confirmSubmit()
{
 var x = confirm('Are you sure , you want to assign selected companies to selected record ?');
 if(x)
 {
 submitForm('masters','mastersManagementController?method=assignMasters');
 }
 else
 {
 	return false;
 }
}
</script>



 