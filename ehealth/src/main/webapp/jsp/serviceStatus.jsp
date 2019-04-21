<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * serviceStatus.jsp  
 * Purpose of the JSP -  This is for Service Status.
 * @author  Dipali
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<br />


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchServiceStatusList = (ArrayList)map.get("searchServiceStatusList");
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
<h2>Service Status</h2>
</div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>ServiceStatus Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>ServiceStatus Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="ServiceStatus Code,string,no" MAXLENGTH="8"	tabindex=1	onkeypress="return submitenter(this,event,'hospitalRelated?method=searchServiceStatus')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','hospitalRelated?method=searchServiceStatus','checkSearch')"	tabindex=1 /> <%--- Report Button   --%> 
<input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 />
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_service_status"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchServiceStatusList.size()>0)
		 {
			String strForCode = (String)map.get("serviceStatusCode");
			String strForCodeDescription = (String)map.get("serviceStatusName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<a href="hospital?method=showServiceStatusJsp">Show All Records</a> <%
			}
		 }
	 if(searchServiceStatusList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="hospital?method=showServiceStatusJsp">Show All Records</a>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],  [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
	<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="serviceStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasServiceStatus">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="ServiceStatusName"> <input type="hidden" name="title"
	value="ServiceStatus"> <input type="hidden"
	name="<%=JSP_NAME %>" value="serviceStatus"> <input
	type="hidden" name="pojoPropertyCode" value="ServiceStatusCode">
<label><span>*</span>Service
Status Code </label>
<input type="text" name="<%= CODE%>" value=""
	validate="Service Status Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" tabindex=1> <label>
	<span>*</span>Service Status Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" value=""
	validate="Service Status Name,string,yes" class="textbox_size20"
	MAXLENGTH="30"  tabindex=1
	onkeypress="return submitenter(this,event,'hospitalRelated?method=addServiceStatus')">
<script>
				document.serviceStatus.<%=CODE%>.focus();
			</script>
<div class="clear"></div>
<div id="edited"></div>
	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('bed','hospital?method=addServiceStatus');" accesskey="a" />
	<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('bed','hospital?method=editServiceStatus')" accesskey="u" />
	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('bed','hospital?method=deleteServiceStatus&flag='+this.value)" accesskey="d" />
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

<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service Status Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Service Status Name"
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
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchServiceStatusList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasServiceStatus  masServiceStatus = (MasServiceStatus)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masServiceStatus.getId()%>
data_arr[<%= counter%>][1] = "<%=masServiceStatus.getServiceStatusCode()%>"
data_arr[<%= counter%>][2] = "<%= masServiceStatus.getServiceStatusName()%>"

data_arr[<%= counter%>][3] = "<%= masServiceStatus.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masServiceStatus.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masServiceStatus.getLastChgTime() %>"
<% if(masServiceStatus.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "serviceStatus"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>