<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Task Master.jsp  
 * Purpose of the JSP -  This is for Task  Details.
 * @author  Vishal
 * Create Date: 13th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrTask" %>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchTaskList = (ArrayList)map.get("searchTaskList");
	List<MstrTaskType> taskTypeList =new ArrayList<MstrTaskType>();
	List<MstrBudgetSubhead> budgetSubHeadingList = new ArrayList<MstrBudgetSubhead>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<%@page import="jkt.hrms.masters.business.MstrTaskType"%>
<%@page import="jkt.hrms.masters.business.MstrBudgetSubhead"%>
<div class="titleBg"> 
<h2>Task Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<label>Task Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Task Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Task Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchTask')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchTask','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_Task">  --%>
    
</form>
</div>
</div>
<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
	
	 if(map.get("taskTypeList")!=null){
		 taskTypeList=(List<MstrTaskType>)map.get("taskTypeList");
		}
	
	 if(map.get("budgetSubHeadingList")!=null){
		budgetSubHeadingList=(List<MstrBudgetSubhead>)map.get("budgetSubHeadingList");
		}
	    
		if(searchTaskList.size()>0)
		 {	String strForCode = (String)map.get("taskCode");
			String strForCodeDescription = (String)map.get("TaskName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showTaskMasterJsp">Show All Records</a>
	<%
			}
		 }
	if(searchTaskList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showTaskMasterJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%=TASK_TYPE_ID%>"],[4,"<%=BUDGET_SUBHEADING %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="task" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrTask">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TaskName">
  	<input type="hidden" name="title" value = "Task Master">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "taskMaster">
  	<input type="hidden" name="pojoPropertyCode" value = "TaskCode">
<div class="division"></div>
	<label><span>*</span>Task Code:</label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Task Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Task Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Task Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addTask')" >
  	
    <div class="clear"></div>
    
 <label><span>*</span>Task Type</label>
    	<select name="<%=TASK_TYPE_ID%>" id="taskType" validate="Task Type,string,yes">
    	<option value="">Select</option>
    	<%
			for(MstrTaskType mstrTaskType:taskTypeList)
			{				
		%>
		<option value="<%= mstrTaskType.getId() %>"><%=mstrTaskType.getTaskTypeName() %></option>
		
		<%} %>   
		</select>
		  
		
<label>Budget Sub-Heading</label>
    	<select name="<%=BUDGET_SUBHEADING%>" id="budSubHeading" validate="Budget Sub Heading,string,no">
    	<option value="0">Select</option>
    	<%
			for(MstrBudgetSubhead mstrBudgetSubhead:budgetSubHeadingList)
			{				
		%>
		<option value="<%= mstrBudgetSubhead.getId() %>"><%=mstrBudgetSubhead.getBudName() %></option>
		
		<%} %> 
		</select>	
		<div class="clear"></div>
<script>
	document.task.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('task','projectTrackingMaster?method=addTask');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('task','projectTrackingMaster?method=editTask')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('task','projectTrackingMaster?method=deleteTask&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
 			
	<label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
	
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
			
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Task Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Task Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Task Type"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= TASK_TYPE_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Budget Sub-Heading"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= BUDGET_SUBHEADING %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchTaskList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrTask  mstrTask = (MstrTask)itr.next(); 		
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrTask.getId()%>
<%if(mstrTask.getTaskCode()!= null){%>
data_arr[<%= counter%>][1] = "<%=mstrTask.getTaskCode()%>"
<%}else{%>
data_arr[<%= counter%>][1] = ""
<%}%>
data_arr[<%= counter%>][2] = "<%= mstrTask.getTaskName()%>"

<%
		Iterator itrGridTaskTypeList = taskTypeList.iterator();
		 while(itrGridTaskTypeList.hasNext())
            {try{
             MstrTaskType  taskTypeGrid = (MstrTaskType)itrGridTaskTypeList.next(); 
			 if(mstrTask.getTaskType().getId().equals(taskTypeGrid.getId()) && taskTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=taskTypeGrid.getTaskTypeName()%>"
			<%}else if(mstrTask.getId().equals(taskTypeGrid.getId()) && taskTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=taskTypeGrid.getTaskTypeName()%>";
				
			<%}
}catch(Exception e){e.printStackTrace();}}%>
  
         
        
     <%   if(mstrTask.getBudid()!=null){
	for(MstrBudgetSubhead costCenterGrid : budgetSubHeadingList){
		if(mstrTask.getBudid().getId().equals(costCenterGrid.getId()) && costCenterGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][4] = "<%=costCenterGrid.getBudName()%>"
		<%}else if(mstrTask.getBudid().getId().equals(costCenterGrid.getId()) && costCenterGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=costCenterGrid.getBudName()%>";
		
		<%}
	}
	%>
<%}else{%>
	data_arr[<%= counter%>][4] = ""
<%}%>
            
            
            
data_arr[<%= counter%>][5] = "<%= mstrTask.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= mstrTask.getLastChgDate() %>"
data_arr[<%= counter%>][7] = "<%= mstrTask.getLastChgTime()%>"

<% if(mstrTask.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "task"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  