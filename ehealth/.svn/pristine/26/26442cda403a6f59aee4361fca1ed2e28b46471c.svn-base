
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdTemplate.jsp  
 * Purpose of the JSP -  This is for All OpdTemplate Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="jkt.hms.util.User"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.OpdTemplate"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdTemplateList = (ArrayList)map.get("searchOpdTemplateList");
List<MasInstituteDepartment> departmentList = new ArrayList<MasInstituteDepartment>();
//departmentList = (List<MasDepartment>)map.get("departmentList");

//List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
departmentList = (List<MasInstituteDepartment>)map.get("masDepartmentList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
Integer userType=null;
if(session.getAttribute("userType") != null){
	userType=(Integer)session.getAttribute("userType");
}

if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %> 
<div class="titleBg">
<h2>Opd Template</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Template Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Template Name </label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Template Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdTemplate')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchOpdTemplate','checkSearch')" tabindex=1 /> 
<%--- Report Button   --%> <!-- commented by Om Tripathi not working properly -->
<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> --> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Opd_template">
</form>
</div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchOpdTemplateList.size()>0)
		 {
			String strForCode = (String)map.get("templateCode");
			String strForCodeDescription = (String)map.get("templateName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="opdMaster?method=showOpdTemplateJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchOpdTemplateList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="opdMaster?method=showOpdTemplateJsp">Show All Records</a></h4>
<%
     }
	%> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= TEMPLATE_TYPE %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"global"],[9,"<%= STATUS %>"] ];
	 statusTd = 9;
	</script></div>
<form name="opdTemplate" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="OpdTemplate">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName">
<input type="hidden" name="title" value="OpdTemplate">
<input type="hidden" name="<%=JSP_NAME %>" value="opdTemplate">
<input type="hidden" name="pojoPropertyCode" value="TemplateCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Template Code  </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Template Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Template Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Template Name,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=1>
<script>
			document.opdTemplate.<%=CODE%>.focus();
		</script> 
<label><span>*</span> Department Name </label> 
<select
	name="<%= DEPARTMENT_ID %>" validate="Department Name,string,yes"
	tabindex=1>
	<option value="0">Select</option>
	<% if(departmentList!=null){
		
	
			  	for (MasInstituteDepartment masInstituteDepartment : departmentList) {
		    %>
	<option value="<%=masInstituteDepartment.getDepartment().getId ()%>"><%=masInstituteDepartment.getDepartment().getDepartmentName()%></option>
	<%}
			 }%>
</select>
<div class="clear"></div>
<label><span>*</span> Type  </label> 
<select name="<%=TEMPLATE_TYPE%>"	validate="Type,string,yes" onchange="displayInvestigation(this.value)" onkeypress="return submitenter(this,event,'opdMaster?method=addOpdTemplate')">
<option value="0">Select</option>                                                 
<option value="P">Pharmacy</option>
<option value="I">Investigation</option>
<!-- Code for CSSD is C
Code By Mukesh 07 Jun 2011 -->
<option value="C">CSSD</option>
</select>
<div id="insDiv">
 <%if(userType!=null && userType<3){%>
 	<label class="auto"> Global </label> <input id="globalId" name="global" type="radio" value="global" checked="checked"  class="checkbox"/>
 <%} %>	
 	<label class="auto"> Local </label>   <input id="localId" name="global" type="radio" value="local"  class="checkbox"/>
 </div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('opdTemplate','opdMaster?method=addOpdTemplate');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('opdTemplate','opdMaster?method=editOpdTemplate')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('opdTemplate','opdMaster?method=deleteOpdTemplate&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Template Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Template Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Department Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= DEPARTMENT_ID%>"

data_header[3] = new Array;
data_header[3][0] = "Type"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= TEMPLATE_TYPE %>";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Global"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "global";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdTemplateList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             OpdTemplate  opdTemplate = (OpdTemplate)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdTemplate.getId()%>
data_arr[<%= counter%>][1] = "<%=opdTemplate.getTemplateCode()%>"
data_arr[<%= counter%>][2] = "<%= opdTemplate.getTemplateName()%>"

	
<% if(opdTemplate.getDepartment() != null && departmentList!=null){%>
<%	Iterator itrGridDepartmentList = departmentList.iterator();
	 while(itrGridDepartmentList.hasNext())
           {
            MasInstituteDepartment masDepartment = (MasInstituteDepartment)itrGridDepartmentList.next(); 
		 if(opdTemplate.getDepartment().getId().equals(masDepartment.getDepartment().getId()) && masDepartment.getDepartment().getStatus().equals("Y")){
		 %>
			data_arr[<%= counter%>][3] = "<%=masDepartment.getDepartment().getDepartmentName()%>"
		<%}else if(opdTemplate.getDepartment().getId().equals(masDepartment.getDepartment().getId()) && masDepartment.getDepartment().getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartment().getDepartmentName()%>";
		<%}
}	%>
<%}%>

<% if(opdTemplate.getTemplateType().equals("P"))
	{%>
		data_arr[<%= counter%>][4] = "Pharmacy"
	<%}
else if(opdTemplate.getTemplateType().equals("I"))
	{%>
		data_arr[<%= counter%>][4] = "Investigation"
<%}else if(opdTemplate.getTemplateType().equals("C"))
	{%>
		data_arr[<%= counter%>][4] = "CSSD"
<%}else{%>
	data_arr[<%= counter%>][4] = ""
<%	
}%>

data_arr[<%= counter%>][5] = "<%= opdTemplate.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(opdTemplate.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= opdTemplate.getLastChgTime() %>"

<%if(opdTemplate.getHospital() != null && !opdTemplate.getHospital().getId().equals("")){%>
	data_arr[<%= counter%>][8] = "local"
	<%}else{%>
	data_arr[<%= counter%>][8] = "global"
	<%}%>
	

<% if(opdTemplate.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "opdTemplate"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<script>
	window.onload=document.getElementById("insDiv").style.display="none";
	function displayInvestigation(investigationType){
		if(investigationType == "C" || investigationType == "0"  ){
			document.getElementById('insDiv').style.display = 'none';
		}else{
			document.getElementById('insDiv').style.display = 'inline';
			
		}
	}
</script>
