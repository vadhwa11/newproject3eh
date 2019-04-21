<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * projectStatus.jsp  
 * Purpose of the JSP -  This is for Project Status  Details.
 * @author  Vishal
 * Create Date: 10th Aug,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrProjectStatus" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchProjectStatusList = (ArrayList)map.get("searchProjectStatusList");
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
<h2>Project Status</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Project Status Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Project Status Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Calendar  Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchProjectStatus')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchProjectStatus','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_TaskType">  --%>
    
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		if(searchProjectStatusList.size()>0)
		 {	String strForCode = (String)map.get("projectStatusCode");
			String strForCodeDescription = (String)map.get("projectStatusName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showProjectStatusJsp">Show All Records</a>
	<%
			}
		 }
	if(searchProjectStatusList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showProjectStatusJsp">Show All Records</a>

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
<form name="projectStatus" method="post" action="">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrProjectStatus">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PrjsName">
  	<input type="hidden" name="title" value = "ProjectStatus">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "projectStatus">
  	<input type="hidden" name="pojoPropertyCode" value = "PrjsCode">
<div class="division"></div>
	<label><span>*</span>Project Status Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Project Status Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Project Status Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Project Status Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addProjectStatus')" >

<script>
	document.calendar.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('projectStatus','projectTrackingMaster?method=addProjectStatus');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('projectStatus','projectTrackingMaster?method=editProjectStatus')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('projectStatus','projectTrackingMaster?method=deleteProjectStatus&flag='+this.value)" accesskey="d" tabindex=1/>		

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
<div class="clear"></div>
	
<div class="division"></div>
<div class="clear"></div>
			
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Status Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Project Status Name"
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
Iterator itr=searchProjectStatusList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrProjectStatus  mstrProjectStatus = (MstrProjectStatus)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrProjectStatus.getId()%>
data_arr[<%= counter%>][1] = "<%=mstrProjectStatus.getPrjsCode()%>"
data_arr[<%= counter%>][2] = "<%= mstrProjectStatus.getPrjsName()%>"
data_arr[<%= counter%>][3] = "<%= mstrProjectStatus.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= mstrProjectStatus.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= mstrProjectStatus.getLastChgTime()%>"

<% if(mstrProjectStatus.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "projectStatus"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  