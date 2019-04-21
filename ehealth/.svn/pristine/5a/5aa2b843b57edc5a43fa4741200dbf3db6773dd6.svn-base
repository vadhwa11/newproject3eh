<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Stream.
 * @author  Mansi
 * Create Date: 17th April,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.9;
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStream"%>


<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

ArrayList searchStreamList = (ArrayList)map.get("searchStreamList");

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
<h2>Stream Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Stream Name</label>

<input type="text" id="searchField" name="searchField"	value="" validate="Stream Name,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />
<input type="hidden" name="colName" value="stream_name">
<input type="hidden" name="<%=SELECTED_RADIO%>"  id="radio1"  value="2"  checked="checked" />
		
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchStream','checkSearch')"	tabindex=1 />

 <%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_stream">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchStreamList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("streamName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showStreamJsp">Show All Records</a> 
	<%
			}
		 }
	 if(searchStreamList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showStreamJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"description"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="stream" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden"	name="<%= POJO_NAME %>" value="MasStream"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="StreamName"> 
<input	type="hidden" name="title" value="Stream"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="stream"> 
<input type="hidden"	name="pojoPropertyName" value="StreamName">

<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="Block">

<label><span>*</span>Stream</label>

<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Stream Name,string,yes" class="textbox_size20" MAXLENGTH="32"	 tabindex=1> 
<script>
		document.stream.<%=SEARCH_NAME%>.focus();
</script>

<label>Description </label> 
<!-- <input type="text"	name="description" value="" validate="Description,string,no"	class="textbox_size20" MAXLENGTH="200"  tabindex=1> --> 
 <textarea name="description" validate="Description,string,no" MAXLENGTH="200"  cols="10" rows="10" class="textareaMediua"></textarea>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('stream','generalMaster?method=addStream');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('stream','generalMaster?method=editStream')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('stream','generalMaster?method=deleteStream&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('stream','generalMaster?method=showStreamJsp')" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By</label> 
<label	class="value"><%=userName%></label>
 
<label>Changed Date</label> 
<label	class="value"><%=date%></label> 

<label>Changed Time</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Stream Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "description";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "0";
data_header[3][3] = "<%= CHANGED_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchStreamList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasStream  masStream = (MasStream)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStream.getId()%>
data_arr[<%= counter%>][1] = "<%=masStream.getStreamName()!=null?masStream.getStreamName():" "%>"
data_arr[<%= counter%>][2] = "<%=masStream.getDescription()!=null?masStream.getDescription():" " %>"
data_arr[<%= counter%>][3] = "<%= masStream.getLastChgBy()!=null?(masStream.getLastChgBy().getId()!=null?masStream.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masStream.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStream.getLastChgTime() %>"
<% if(masStream.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "stream"

nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
