<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * projectRole.jsp  
 * Purpose of the JSP -  This is for Bank Details.
 * @author  Vishal
 * Create Date: 14th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchProjectRoleList = (ArrayList)map.get("searchProjectRoleList");
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
<h2>Project Role</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Project Role Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Project Role Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Projectrole Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchProjectRole')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchProjectRole','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_ProjectRole">  --%>
    
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
		if(searchProjectRoleList.size()>0)
		 {
			String strForCode = (String)map.get("prjCode");
			String strForCodeDescription = (String)map.get("prjName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
	%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showProjectRoleJsp">Show All Records</a>
	<%
			}
		 }
	if(searchProjectRoleList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showProjectRoleJsp">Show All Records</a>

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
<form name="projectRole" method="post" action="">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrProjectrole">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PjrName">
  	<input type="hidden" name="title" value = "ProjectRole">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "projectRole">
  	<input type="hidden" name="pojoPropertyCode" value = "PjrCode">
<div class="division"></div>
	<label><span>*</span>Project Role Code:</label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Project Role Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Project Role Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Project Role Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addProjectRole')" >

<script>
	document.projectRole.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('projectRole','projectTrackingMaster?method=addProjectRole');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('projectRole','projectTrackingMaster?method=editProjectRole')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('projectRole','projectTrackingMaster?method=deleteProjectRole&flag='+this.value)" accesskey="d" tabindex=1/>		

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
			
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Role Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Project Role Name"
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
Iterator itr=searchProjectRoleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MstrProjectrole  mstrProjectrole = (MstrProjectrole)itr.next(); 		
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrProjectrole.getId()%>
<%if(mstrProjectrole.getPjrCode() != null){%>
data_arr[<%= counter%>][1] = "<%=mstrProjectrole.getPjrCode()%>"
<%}else{%>
data_arr[<%= counter%>][1] = ""
<%}%>
data_arr[<%= counter%>][2] = "<%= mstrProjectrole.getPjrName()%>"

data_arr[<%= counter%>][3] = "<%= mstrProjectrole.getLastChgBy() %>"

data_arr[<%= counter%>][4] = "<%= mstrProjectrole.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= mstrProjectrole.getLastChgTime()%>"

<% if(mstrProjectrole.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "projectRole"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  