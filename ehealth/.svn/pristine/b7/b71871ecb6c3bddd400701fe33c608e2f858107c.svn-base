<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * roleDeptTaskMap.jsp  
 * Purpose of the JSP -  This is for Role wise Department Task Mapping Details.
 * @author  Vishal
 * Create Date: 20th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hrms.masters.business.MstrRoleTaskMap"%>
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
	List<MasRank>         masRankList = new ArrayList<MasRank>();
	List<MstrDeptTaskMap> deptTaskMapList = new ArrayList<MstrDeptTaskMap>();
	List<MstrRoleTaskMap> roleTaskMapList = new ArrayList<MstrRoleTaskMap>();
	List<MstrTask>        mstrTaskList = new ArrayList<MstrTask>();
	
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
	
	if(map.get("deptTaskMapList")!=null){
		 deptTaskMapList=(List<MstrDeptTaskMap>)map.get("deptTaskMapList");
	} 
	if(map.get("roleTaskMapList")!=null){
		roleTaskMapList=(List<MstrRoleTaskMap>)map.get("roleTaskMapList");
	} 
	if(map.get("masRankList")!=null){
		masRankList=(List<MasRank >)map.get("masRankList");
	} 
%>



<div class="titleBg"> 
<h2>Role-Department Wise Task Mapping</h2>
</div>

<div class="clear"></div>

<form name="roleTask" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label><span>* </span>Department</label>
    <select name="<%=DEPARTMENT_TYPE %>" id="<%=DEPARTMENT_TYPE %>" onchange="populateTasks(this,'mainGroupId')" validate="Department,int,yes">
             	<option value="0">Select</option>
                 	<%for(MasDepartment masDepartment:departmentList){ %>
            	 <option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
   	<%} %>
	</select>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<label><span>* </span>Role/Designation</label>
    		<select name="<%=ROLE_TYPE %>" id="<%=ROLE_TYPE %>"  onchange="populateRoleTasks(this,'tempId')" validate="Role,int,yes">
             	<option value="0">Select</option>
                 	<%for(MasRank masRank:masRankList){ %>
            	 <option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
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
 
 <select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="3" class="listBig3">
 


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">

</div>


 	 
     
     
</select>
<div class="clear"></div>
<div class="division"></div>
 <div class="clear"></div>
 <div class="paddingTop15"></div>
  <div class="paddLeft155">
<input type="button" class="button" name="Assign" value="Save" onclick="submitForm('roleTask','/hms/hrms/projectTrackingMaster?method=saveRoleDeptTasks')">  
 </div>
 <div class="clear"></div>
 <div class="paddingTop15"></div>
</div>	
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
			Set taskMap = department.getDeptTaskMaps();
			List<MstrDeptTaskMap> taskMapList = new ArrayList();
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
			if(taskMap!=null)
			{
				taskMapList = new ArrayList(taskMap);
				Collections.sort(taskMapList,new TaskComparator());	
			}
				
			
			
			
			
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


function populateRoleTasks(obj,id)
{
    var sel2 = document.getElementById(id);
    var obj2 = document.getElementById('<%=DEPARTMENT_TYPE %>'); 
    
	removeAllOptions(sel2);
		
	if(obj.value!="All"){
	
	<%for(MasRank masRank : masRankList ){%>
		
		if(obj.value == <%=masRank.getId()%>){
			
			<%
			Set roleMap = masRank.getRoleDeptTaskMaps();
			    
			List<MstrRoleTaskMap> taskMapList2 = new ArrayList();
			
			
			//Set set = EmployeeComparator.getEmployeeTreeSet();
			//set.addAll(empSet);
			
			
			
			
			if(roleMap!=null)
			{
				taskMapList2 = new ArrayList(roleMap);
				Collections.sort(taskMapList2,new RoleTaskMapComparator());
				//Collections.sort(taskMapList);
				
			}
		
			for(MstrRoleTaskMap taskMap11:taskMapList2){
				if(taskMap11.getStatus().equals("y")){ 
		    %>
					if(obj2.value == <%=taskMap11.getDepartment().getId()%>){
					
			
			    
				optionRepMan2 = new Option("<%=taskMap11.getTask().getTaskName()%>" , "<%=taskMap11.getTask().getId()%>","true");				
				
				sel2.options.add(optionRepMan2);
				}	
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



 