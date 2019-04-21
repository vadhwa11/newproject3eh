<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * block.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: o7th April, 2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>

<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAccountSchedule"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasAccountSchedule> masAccountScheduleList = new ArrayList<MasAccountSchedule>();
	
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masAccountScheduleList") != null){
		masAccountScheduleList = (ArrayList)map.get("masAccountScheduleList");
	}
	
	
	if(map.get("message") != null){
		 
	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}
%>
<div class="titleBg">
<h2>Account Schedule Master</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Account Schedule Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" /> 
<label>Account Schedule Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 


<input type="hidden" name="colCode" value="schedule_code">
<input type="hidden" name="colName" value="schedule_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Schedule Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchAccountSchedule')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchAccountSchedule','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMastersInt');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_account_schedule">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(masAccountScheduleList.size() > 0)
		 {
			String strForCode = (String)map.get("scheduleCode");
			String strForCodeDescription = (String)map.get("scheduleName");
			if(strForCode!= null && strForCode!=""|| strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showAccountScheduleJsp">Show All Records </a></h4>

<%
			}
		 }
		else if(map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showAccountScheduleJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"orderNo"] ,[4,"scheduleNo"] ,[5,"<%=CHANGED_BY%>"], [6,"<%=CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"]];	 
		 statusTd = 8;
	</script></div>

<form name="accountSchedule" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasAccountSchedule"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ScheduleName">
<input type="hidden" name="title" value="Account Schedule"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="fa_account_schedule"> 
<input	type="hidden" name="pojoPropertyCode" value="ScheduleCode">
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<label><span>*</span> Schedule Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Schedule Code,int,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 
<label><span>*</span> Schedule Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Schedule  Name,string,yes"  MAXLENGTH="100" tabindex=1 />
 <script>
 		document.accountSchedule.<%=CODE%>.focus();
			</script>

<label><span>*</span> Order No.</label> 
<input type="text" name="orderNo" value="" validate="Order No.,int,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />


<label><span>*</span> Schedule No. </label> 
<input type="text" name="scheduleNo" value="" validate="Schedule No.,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('accountSchedule','generalMaster?method=addAccountSchedule');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('accountSchedule','generalMaster?method=editAccountSchedule')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('accountSchedule','generalMaster?method=deleteAccountSchedule&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="submitFormForButton('accountSchedule','generalMaster?method=showAccountScheduleJsp')"  accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Schedule Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Schedule Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Order No."
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "orderNo";

data_header[3] = new Array;
data_header[3][0] = "Schedule No."
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "scheduleNo";


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = "Admin"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME%>";





data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=masAccountScheduleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasAccountSchedule  masAccountSchedule = (MasAccountSchedule)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAccountSchedule.getId()%>
data_arr[<%= counter%>][1] = "<%=masAccountSchedule.getScheduleCode()%>"
data_arr[<%= counter%>][2] = "<%= masAccountSchedule.getScheduleName().trim()%>"

data_arr[<%= counter%>][3] = "<%= masAccountSchedule.getOrderNo()%>"
data_arr[<%= counter%>][4] = "<%= masAccountSchedule.getScheduleNo().trim()%>"

 data_arr[<%= counter%>][5] = "<%= masAccountSchedule.getLastChgBy()!=null?(masAccountSchedule.getLastChgBy().getId()!=null?masAccountSchedule.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masAccountSchedule.getLastChgDate()) %>"
	data_arr[<%= counter%>][7] = "<%= masAccountSchedule.getLastChgTime() %>"
<% if(masAccountSchedule.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "accountSchedule"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
