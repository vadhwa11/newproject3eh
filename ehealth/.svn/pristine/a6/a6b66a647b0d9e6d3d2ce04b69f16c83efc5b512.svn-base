<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * room.jsp  
 * Purpose of the JSP -  This is for Room.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRoom"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
	departmentList = (ArrayList)map.get("departmentList");
	roomTypeList = (ArrayList)map.get("roomTypeList");
	ArrayList searchRoomList = (ArrayList)map.get("searchRoomList");
	ArrayList gridDepartmentList = (ArrayList)map.get("gridDepartmentList");
	ArrayList gridRoomTypeList = (ArrayList)map.get("gridRoomTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		   <%} %>
		   
<div class="titleBg">
<h2>Room Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Room Code</label>
<input type="text" id="searchField" name="<%= CODE%>" value=""	validate="Room Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=searchRoom')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','hospital?method=searchRoom','checkSearch')"	tabindex=1 />
<%--- Report Button    <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_room">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchRoomList.size()>0 && roomTypeList.size() > 0)
		 {
			String strForCode = (String)map.get("roomCode");
			String strForCodeDescription = (String)map.get("roomName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showRoomJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchRoomList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showRoomJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= ROOM_TYPE_ID %>"], [3,"<%= DEPARTMENT_ID %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="room" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasRoom"> <input type="hidden"
	name="title" value="Room"> <input type="hidden"
	name="<%=JSP_NAME %>" value="room"> <input type="hidden"
	name="pojoPropertyCode" value="RoomCode"> <input type="hidden"
	name="pojoPropertyName" value="">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Room Code</label>
<input	id="codeId" type="text" name="<%= CODE%>" value=""	validate="Room Code,string,yes" MAXLENGTH="8" tabindex=1 />
 <script>
		document.room.<%=CODE%>.focus();
	</script>
	<label><span>*</span> Room Type</label>
	<select name="<%= ROOM_TYPE_ID %>" validate="Room Type,string,yes" tabindex=1>
		<option value="">Select</option>
	<% 
			for (MasRoomType  masRoomType : roomTypeList){
		 %>
	<option value="<%=masRoomType.getId ()%>"><%=masRoomType.getRoomTypeName()%></option>

	<%}%>
</select>
 <label><span>*</span> Department</label>
 <select
	name="<%= DEPARTMENT_ID %>" validate="Deparment,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=addRoom')">
	<option value="">Select</option>
	<% 
			for (MasDepartment  masDepartment : departmentList){
		 %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button" onClick="submitForm('room','hospital?method=addRoom');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('room','hospital?method=editRoom')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" style="display: none;" class="button"
	onClick="submitForm('room','hospital?method=deleteRoom&flag='+this.value)" accesskey="d"
	tabindex=1 />
	<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
	<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

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
data_header[0][0] = "Room Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Room Type"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= ROOM_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DEPARTMENT_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%

Iterator itr=searchRoomList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRoom  masRoom = (MasRoom)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRoom.getId()%>
data_arr[<%= counter%>][1] = "<%=masRoom.getRoomCode()%>"
            
<% if(masRoom.getRoomType() != null){%> 
<%
		Iterator itrGridRoomTypeList=gridRoomTypeList.iterator();
		 while(itrGridRoomTypeList.hasNext())
            {
             MasRoomType  roomTypeGrid = (MasRoomType)itrGridRoomTypeList.next(); 
			 if(masRoom.getRoomType().getId().equals(roomTypeGrid.getId()) && roomTypeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][2] = "<%=roomTypeGrid.getRoomTypeName()%>"
			<%}else if(masRoom.getId().equals(roomTypeGrid.getId()) && roomTypeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=roomTypeGrid.getRoomTypeName()%>";				
			<%}
            }
		}
else{
%>
data_arr[<%= counter%>][2] = "";				

<%}%>
<% if(masRoom.getDepartment() != null){%>       
 <%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(masRoom.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(masRoom.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
			<%}
            }
		}
else{
%>
data_arr[<%= counter%>][3] = "";				

<%}%>

data_arr[<%= counter%>][4] = "<%= masRoom.getLastChgBy()!=null?masRoom.getLastChgBy().getId():"" %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masRoom.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masRoom.getLastChgTime() %>"
<% if(masRoom.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "room"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
