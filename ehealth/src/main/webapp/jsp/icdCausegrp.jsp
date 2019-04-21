<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * IcdCausegrp.jsp  
 * Purpose of the JSP -  This is for IcdCauseGroup Details.
 * @author  Dipali
 * @author Vishal
 * Create Date: 08th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.12  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcdcausegrp"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchCauseList = (ArrayList)map.get("searchCauseList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		  <% }%>

<div class="titleBg">
<h2>ICD Cause Group Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Cause Code</label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Cause Name</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Cause Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=searchIcdCause')" />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchIcdCause','checkSearch')"	tabindex=1 />
<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_icd_cause_grp">
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
		if(searchCauseList.size()>0)
		 {
			String strForCode = (String)map.get("causeCode");
			String strForCodeDescription = (String)map.get("causeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showIcdCauseJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchCauseList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="hospital?method=showIcdCauseJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="icdCausegrp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasIcdcausegrp">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="IcdCauseName">
<input type="hidden" name="title" value="IcdCausegrp">
<input type="hidden" name="<%=JSP_NAME %>" value="icdCausegrp">
<input type="hidden" name="pojoPropertyCode" value="IcdCauseCode">
<div class="clear"></div>
<div class="Block"><label><span>*</span> Cause Code </label>
<input	id="codeId" type="text" name="<%= CODE%>" value=""	validate="Cause Code,string,yes" MAXLENGTH="8"	tabindex=1 />
<label><span>*</span> Cause Name</label>
<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Cause Name,string,yes" MAXLENGTH="250" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=addIcdCause')" />
<script>
		document.icdCausegrp.<%=CODE%>.focus();
	</script>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('icdCausegrp','hospital?method=addIcdCause');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('icdCausegrp','hospital?method=editIcdCause')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('icdCausegrp','hospital?method=deleteIcdCause&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Cause Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Cause Name"
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
Iterator itr=searchCauseList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MasIcdcausegrp  masIcdcausegrp = (MasIcdcausegrp)itr.next(); 
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masIcdcausegrp.getId()%>
data_arr[<%= counter%>][1] = "<%=masIcdcausegrp.getIcdCauseCode()%>"
data_arr[<%= counter%>][2] = "<%= masIcdcausegrp.getIcdCauseName()%>"

	 data_arr[<%= counter%>][3] = "<%= masIcdcausegrp.getLastChgBy()!=null?(masIcdcausegrp.getLastChgBy().getId()!=null?masIcdcausegrp.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masIcdcausegrp.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masIcdcausegrp.getLastChgTime() %>"
<% if(masIcdcausegrp.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "icdCausegrp"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
