<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * empStatus.jsp  
 * Purpose of the JSP -  This is for Employee Status.
 * @author Mansi
 * @author Vishal 
 * Create Date: 14th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchEmpStatusList = (ArrayList)map.get("searchEmpStatusList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}%>
<div class="titleBg">
<h2>Employee Status Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label> Employee Status Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" /> 
<label>Employee Status Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Employee Status Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchEmpStatus')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchEmpStatus','checkSearch')" tabindex=1 /> 
<div class="clear"></div>
<%--- Report Button    
<input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>  --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_emp_status">
</form>
</div>
</div>

<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchEmpStatusList.size()>0)
		 {
			String strForCode = (String)map.get("empStatusCode");
			String strForCodeDescription = (String)map.get("empStatusName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="personnel?method=showEmpStatusJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchEmpStatusList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="personnel?method=showEmpStatusJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<form name="empStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasEmpStatus">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="EmpStatusName">
<input type="hidden" name="title" value="EmpStatus">
<input type="hidden" name="<%=JSP_NAME %>" value="empStatus">
<input type="hidden" name="pojoPropertyCode" value="EmpStatusCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Emp Status Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Employee Status Code,string,yes" class="textbox_size20"	MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Emp Status Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Employee Status Name,string,yes" class="textbox_size20"	MAXLENGTH="30" / tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=addEmpStatus')">
<script>
		document.empStatus.<%=EMP_STATUS_CODE%>.focus();
	</script>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('empStatus','personnel?method=addEmpStatus');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('empStatus','personnel?method=editEmpStatus')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('empStatus','personnel?method=deleteEmpStatus&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee Status Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= EMP_STATUS_CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Employee Status Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= EMP_STATUS_NAME %>";

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
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";
data_arr = new Array();

<%
Iterator itr=searchEmpStatusList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasEmpStatus  masEmpStatus = (MasEmpStatus)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masEmpStatus.getId()%>
data_arr[<%= counter%>][1] = "<%=masEmpStatus.getEmpStatusCode()%>"
data_arr[<%= counter%>][2] = "<%= masEmpStatus.getEmpStatusName()%>"
data_arr[<%= counter%>][3] = "<%= masEmpStatus.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masEmpStatus.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masEmpStatus.getLastChgTime() %>"

<% if(masEmpStatus.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "empStatus"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>