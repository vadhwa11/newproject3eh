<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * version.jsp  
 * Purpose of the JSP -  This is for Version.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasApkVersion"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchVersionList = (ArrayList)map.get("searchVersionList");
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
<h2>Version Master</h2>
</div>
<div class="clear"></div>
 <div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Version Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Version Description</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 


<input type="hidden" name="colCode" value="version_code">
<input type="hidden" name="colName" value="version_name">

 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Version Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'systemRelatedMaster?method=searchVersion')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','systemRelatedMaster?method=searchVersion','checkSearch')"	tabindex=1 />
<input type="button" name="Report" value="Generate Report " class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_apk_version">
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
  if(searchVersionList.size()>0)
   {
   String strForCode = (String)map.get("versionCode");
   String strForCodeDescription = (String)map.get("versionName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <h4> <a href="systemRelatedMaster?method=showVersionJsp">Show All Records</a></h4>
<%
   }
   }
		 if(searchVersionList.size()==0 && map.get("search") != null)
		 {
		%> <h4><a href="systemRelatedMaster?method=showVersionJsp">Show All Records</a></h4>

<%
		 }
		%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"apkVersionType"], [4,"<%= CHANGED_BY %>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
  statusTd = 7;
 </script></div>

<form name="version" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input	type="hidden" name="<%= POJO_NAME %>" value="MasApkVersion">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="VersionName"> 
<input type="hidden"	name="version" value="Version"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="version"> 
<input	type="hidden" name="pojoPropertyCode" value="VersionCode">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Version Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" 	validate="Version Code,num,yes" class="textbox_size20"	MAXLENGTH="8" tabindex=1/> 
<label><span>*</span> Version Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Version Name,string,yes" class="textbox_size20"	MAXLENGTH="30"  tabindex=1	onkeypress="return submitenter(this,event,'systemRelatedMaster?method=addVersion')"/>
<script>
    	document.version.<%=CODE%>.focus();
</script>
<label><span>*</span> Type</label>
<select name="apkVersionType" id="apkVersionType">
<option value="Select">Select</option>
<option value="ME">ME</option>
<option value="EH">EH</option>
</select> 
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('version','systemRelatedMaster?method=addVersion');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('version','systemRelatedMaster?method=editVersion')"	accesskey="u" tabindex=1 /> 
<input type="hidden" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('version','systemRelatedMaster?method=deleteVersion&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />

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
data_header[0][0] = "Version Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Version Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Type"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "apkVersionType"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchVersionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasApkVersion  masVersion = (MasApkVersion)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masVersion.getId()%>
data_arr[<%= counter%>][1] = "<%=masVersion.getVersionCode()%>"
data_arr[<%= counter%>][2] = "<%= masVersion.getVersionName()%>"
	data_arr[<%= counter%>][3] = "<%= masVersion.getLastChgBy()!=null?masVersion.getApkVersionType():""%>"

data_arr[<%= counter%>][4] = "<%= masVersion.getLastChgBy()!=null?(masVersion.getLastChgBy().getId()!=null?masVersion.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masVersion.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masVersion.getLastChgTime() %>"

<% if(masVersion.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "version"		

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>