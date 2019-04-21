<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * roomType.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Mansi
 * @author  Vishal
 * Create Date: 25th Aug, 2015 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasRoomType> masRoomTypeList = new ArrayList<MasRoomType>();
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masRoomTypeList") != null){
		masRoomTypeList = (ArrayList)map.get("masRoomTypeList");
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
<h2>RoomType Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="RoomType">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>RoomType Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" /> 
<label>RoomType Description</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 


<input type="hidden" name="colCode" value="room_type_code">
<input type="hidden" name="colName" value="room_type_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="RoomType Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchRoomType')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchRoomType','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_roomType">
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
		if(masRoomTypeList.size() > 0)
		 {
			String strForCode = (String)map.get("roomTypeCode");
			String strForCodeDescription = (String)map.get("roomTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showRoomTypeJsp">Show All Records </a></h4>

<%
			}
		 }
	 if(map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showRoomTypeJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"]];	 
		 statusTd = 6;
	</script></div>

<form name="roomType" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasRoomType"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="RoomTypeName">
<input type="hidden" name="title" value="RoomType"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="roomType"> 
<input	type="hidden" name="pojoPropertyCode" value="RoomTypeCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="RoomType">
<div class="Block">
<label><span>*</span> RoomType Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="RoomType Code,string,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 
<label><span>*</span> RoomType Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="RoomType  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.roomType.<%=CODE%>.focus();
			</script>


<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('roomType','hospital?method=addRoomType');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('roomType','hospital?method=editRoomType')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('roomType','hospital?method=deleteRoomType&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />


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

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "RoomType Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "RoomType Name"
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
Iterator itr=masRoomTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRoomType  masRoomType = (MasRoomType)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRoomType.getId()%>
data_arr[<%= counter%>][1] = "<%=masRoomType.getRoomTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masRoomType.getRoomTypeName()%>"





 data_arr[<%= counter%>][3] = "<%= masRoomType.getLastChgBy()!=null?(masRoomType.getLastChgBy().getId()!=null?masRoomType.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masRoomType.getLastChgDate()) %>"
	data_arr[<%= counter%>][5] = "<%= masRoomType.getLastChgTime() %>"
<% if(masRoomType.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "roomType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
