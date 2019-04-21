<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * meScale.jsp  
 * Purpose of the JSP -  This is for Scale.
 * @author  Mansi
 * @author  Dipali
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchMeScaleList = (ArrayList)map.get("searchMeScaleList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
}

%>

<div class="titleBg">
<h2>Me Scale Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action=""><label>ME
Scale Number</label> <input type="text" id="searchField"
	name="<%=ME_SCALE_NUMBER%>" value="" validate="ME Scale Number,int,no"
	MAXLENGTH="8"
	onkeypress="return submitenter(this,event,'pharmacy?method=searchMeScale')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','pharmacy?method=searchMeScale','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search"
	class="button"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_me_scale"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
  if(searchMeScaleList.size()>0)
   {
   String strForCode = (String)map.get("meScale");
   if(strForCode!= null && strForCode!= "" )
   {
	   %> <br />
<a href="pharmacy?method=showMeScaleJsp">Show All Records</a> <%
			}
		 }
	if(searchMeScaleList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="pharmacy?method=showMeScaleJsp">Show All Records</a> <%
  }
	%> <script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= ME_SCALE_NUMBER%>"], [2,"<%= ME_SCALE_DESCRIPTION %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
 </script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="meScale" method="post" action="">
<div class="Block">
<input type="hidden" name="<%= POJO_NAME %>"
	value="MasStoreMeScale"><input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="MeScaleDescription"><input
	type="hidden" name="title" value="MeScale"><input type="hidden"
	name="<%=JSP_NAME %>" value="meScale"><input type="hidden"
	name="pojoPropertyCode" value="MeScale"><label><span>*</span>
ME Scale Number</label> <input id="codeId" type="text"
	name="<%= ME_SCALE_NUMBER%>" value=""
	validate="ME Scale Number,int,yes" MAXLENGTH="8" tabindex=1><label><span>*</span>
ME Scale Description</label> <input type="text"
	name="<%= ME_SCALE_DESCRIPTION %>" value=""
	validate="ME Scale Description,alphanumeric,yes" MAXLENGTH="30"
	tabindex=1
	onkeypress="return submitenter(this,event,'pharmacy?method=addMeScale')" />
<script>
    document.meScale.<%=ME_SCALE_NUMBER%>.focus();
   </script>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('meScale','pharmacy?method=addMeScale');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('meScale','pharmacy?method=editMeScale')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('meScale','pharmacy?method=deleteMeScale&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "ME Scale Number"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= ME_SCALE_NUMBER%>"

data_header[1] = new Array;
data_header[1][0] = "ME Scale Description"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= ME_SCALE_DESCRIPTION %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchMeScaleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStoreMeScale  masStoreMeScale = (MasStoreMeScale)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreMeScale.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreMeScale.getMeScale()%>"
data_arr[<%= counter%>][2] = "<%= masStoreMeScale.getMeScaleDescription()%>"

data_arr[<%= counter%>][3] = "<%= masStoreMeScale.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreMeScale.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStoreMeScale.getLastChgTime() %>"
<% if(masStoreMeScale.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "meScale"

nonEditable = ['<%= ME_SCALE_NUMBER%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>