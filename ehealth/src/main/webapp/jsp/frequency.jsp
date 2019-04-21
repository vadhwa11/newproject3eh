<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * frequency.jsp  
 * Purpose of the JSP -  This is for frequency.
 * @author  Mansi
 * @author  Vishal
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchFrequencyList = (ArrayList)map.get("searchFrequencyList");
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
<h2>Frequency Type</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Frequency Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Frequency Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />


<input type="hidden" name="colCode" value="frequency_code">
<input type="hidden" name="colName" value="frequency_name">

<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Frequency Code,string,no"	MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'systemRelatedMaster?method=searchFrequency')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','systemRelatedMaster?method=searchFrequency','checkSearch')"	tabindex=1 /> 
<%--- Report Button  
<input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>  --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_frequency">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		if(searchFrequencyList.size()>0)
		 {
			String strForCode = (String)map.get("frequencyCode");
			String strForCodeDescription = (String)map.get("frequencyName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	<h4><a href="systemRelatedMaster?method=showFrequencyJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchFrequencyList.size()==0 && map.get("search") != null)
	  {
    %>
   <h4>  <a href="systemRelatedMaster?method=showFrequencyJsp">Show All Records </a></h4> <%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"frequencyValue"], [4,"frequencyType"],  [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="frequency" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasFrequency">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FrequencyName">
<input type="hidden" name="title" value="Frequency">
<input type="hidden" name="<%=JSP_NAME %>" value="frequency">
<input type="hidden" name="pojoPropertyCode" value="FrequencyCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Frequency Code  </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Frequency Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Frequency Name</label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Frequency Name,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=2 onkeypress="return submitenter(this,event,'systemRelatedMaster?method=addFrequency')">
<script>
document.frequency.<%=CODE%>.focus();
</script>
<label><span>*</span> Frequency Value  </label>
<input type="text" name="frequencyValue" value="" validate="Frequency Code,int,yes" class="textbox_size20" MAXLENGTH="4" / tabindex=3>
<div class="clear"></div>

<label><span>*</span> Frequency Type</label>
<select name="frequencyType" validate="Frequency Type,string,yes"   tabindex=4>
<option value="Days">Daily</option>
<option value="Weeks">Weekly</option>
<option value="Months">Monthly</option>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('frequency','systemRelatedMaster?method=addFrequency');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('frequency','systemRelatedMaster?method=editFrequency')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;"	onClick="submitForm('frequency','systemRelatedMaster?method=deleteFrequency&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"  onClick="submitForm('frequency','systemRelatedMaster?method=showFrequencyJsp');"  accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Frequency Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Frequency Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Frequency Value"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SEARCH_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Frequency Type"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= SEARCH_NAME %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchFrequencyList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasFrequency  masFrequency = (MasFrequency)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masFrequency.getId()%>
data_arr[<%= counter%>][1] = "<%=masFrequency.getFrequencyCode()%>"
data_arr[<%= counter%>][2] = "<%= masFrequency.getFrequencyName()%>"
data_arr[<%= counter%>][3] = <%= masFrequency.getFrequencyCount()%>
data_arr[<%= counter%>][4] = "<%= masFrequency.getFrequencyType()%>"

data_arr[<%= counter%>][5] = "<%= masFrequency.getLastChgBy()!=null?masFrequency.getLastChgBy().getId():"" %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masFrequency.getLastChgDate())%>"
data_arr[<%= counter%>][7] = "<%= masFrequency.getLastChgTime() %>"
<% if(masFrequency.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "frequency"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
