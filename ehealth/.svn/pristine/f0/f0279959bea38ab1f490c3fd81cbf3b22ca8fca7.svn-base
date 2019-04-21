<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Task Type.jsp  
 * Purpose of the JSP -  This is for Task Type  Details.
 * @author  Vishal
 * Create Date: 13th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrTaskType" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchTaskTypeList = (ArrayList)map.get("searchTaskTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<div class="titleBg"> 
<h2>Task Type Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<label>Task Type Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Task Type Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Task Type  Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchTaskType')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchTaskType','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_TaskType">  --%>
    
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
		if(searchTaskTypeList.size()>0)
		 {	String strForCode = (String)map.get("taskTypeCode");
			String strForCodeDescription = (String)map.get("taskTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showTaskTypeJsp">Show All Records</a>
	<%
			}
		 }
	if(searchTaskTypeList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showTaskTypeJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="taskType" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrTaskType">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TaskTypeName">
  	<input type="hidden" name="title" value = "TaskType">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "taskType">
  	<input type="hidden" name="pojoPropertyCode" value = "TaskTypeCode">
<div class="division"></div>
	<label><span>*</span>Task Type Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Task Type Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Task Type Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Task Type Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addTaskType')" >

<script>
	document.taskType.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('taskType','projectTrackingMaster?method=addTaskType');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('taskType','projectTrackingMaster?method=editTaskType')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('taskType','projectTrackingMaster?method=deleteTaskType&flag='+this.value)" accesskey="d" tabindex=1/>		

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
data_header[0][0] = "Task Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Task Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchTaskTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrTaskType  mstrTasktype = (MstrTaskType)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrTasktype.getId()%>
data_arr[<%= counter%>][1] = "<%=mstrTasktype.getTaskTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= mstrTasktype.getTaskTypeName()%>"

data_arr[<%= counter%>][3] = "<%= mstrTasktype.getLastChgBy() %>"

data_arr[<%= counter%>][4] = "<%= mstrTasktype.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= mstrTasktype.getLastChgTime()%>"

<% if(mstrTasktype.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "taskType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  