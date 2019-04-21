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

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHouseKeeping"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasHouseKeeping> masHouseKeepingList = new ArrayList<MasHouseKeeping>();

	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masHouseKeepingList") != null){
		masHouseKeepingList = (ArrayList)map.get("masHouseKeepingList");
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
<h2>Activity Master</h2>
</div>
<div class="Block">
<div class="HouseKeeping">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Activity Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Activity Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="hidden" name="colCode" value="house_keeping_code">
<input type="hidden" name="colName" value="house_keeping_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="HouseKeeping Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'inPatientMaster?method=searchHouseKeeping')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','inPatientMaster?method=searchHouseKeeping','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_houseKeeping">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
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
		if(masHouseKeepingList.size() > 0)
		 {
			String strForCode = (String)map.get("houseKeepingCode");
			String strForCodeDescription = (String)map.get("houseKeepingName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="inPatientMaster?method=showHouseKeepingJsp">Show All Records </a></h4>

<%
			}
		 }
if(masHouseKeepingList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="inPatientMaster?method=showHouseKeepingJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"]];	 
		 statusTd = 6;
	</script></div>

<form name="houseKeeping" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasHouseKeeping"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HouseKeepingName">
<input type="hidden" name="title" value="HouseKeeping"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="houseKeeping"> 
<input	type="hidden" name="pojoPropertyCode" value="HouseKeepingCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="HouseKeeping">
<div class="Block">
<label><span>*</span> Activity Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Activity Code,string,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 
<label><span>*</span> Activity Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Activity  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.houseKeeping.<%=CODE%>.focus();
			</script>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('houseKeeping','inPatientMaster?method=addHouseKeeping');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('houseKeeping','inPatientMaster?method=editHouseKeeping')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('houseKeeping','inPatientMaster?method=deleteHouseKeeping&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Activity Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Activity Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME%>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=masHouseKeepingList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasHouseKeeping  masHouseKeeping = (MasHouseKeeping)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHouseKeeping.getId()%>
data_arr[<%= counter%>][1] = "<%=masHouseKeeping.getHouseKeepingCode()%>"
data_arr[<%= counter%>][2] = "<%= masHouseKeeping.getHouseKeepingName()%>"




 data_arr[<%= counter%>][3] = "<%= masHouseKeeping.getLastChgBy()!=null?(masHouseKeeping.getLastChgBy().getId()!=null?masHouseKeeping.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masHouseKeeping.getLastChgDate()) %>"
	data_arr[<%= counter%>][5] = "<%= masHouseKeeping.getLastChgTime() %>"
<% if(masHouseKeeping.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "houseKeeping"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
