<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWasteContainer"%>
<%@page import="jkt.hms.masters.business.MasState"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
		ex.printStackTrace();
	}
	List<MasWasteContainer> searchWasteContainerList = new ArrayList<MasWasteContainer>();

	if(map.get("searchWasteContainerList") !=null){
		searchWasteContainerList = (List)map.get("searchWasteContainerList");
	}

		
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
<h2>Waste Container Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Waste Container Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" /> 
<label>Waste Container Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" />



<input type="hidden" name="colCode" value="charity_type_code">
<input type="hidden" name="colName" value="charity_type_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Waste Container Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'inPatientMaster?method=searchWasteContainer')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','inPatientMaster?method=searchWasteContainer','checkSearch')"	tabindex=1 /> 
<%--- Report Button   --%> <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_waste_container">

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
		if(searchWasteContainerList.size()>0 )
		 {
			String strForCode = (String)map.get("wasteContainerCode");
			String strForCodeDescription = (String)map.get("wasteContainerName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="inPatientMaster?method=showWasteContainerJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchWasteContainerList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="inPatientMaster?method=showWasteContainerJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="wasteContainer" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasWasteContainer"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="WasteContainerName"><input
	type="hidden" name="title" value="WasteContainer"><input
	type="hidden" name="<%=JSP_NAME %>" value="wasteContainer"><input
	type="hidden" name="pojoPropertyCode" value="WasteContainerCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Waste Container Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="WasteContainer Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Waste Container Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="WasteContainer Name,string,yes" class="textbox_size20"	MAXLENGTH="30" / tabindex=1>
<script>
document.wasteContainer.<%=CODE%>.focus();
</script> 
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('wasteContainer','inPatientMaster?method=addWasteContainer');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('wasteContainer','inPatientMaster?method=editWasteContainer')"	style="display: none;" accesskey="u" tabindex=1 /> 
<input	type="button" name="Delete" id="deletebutton" value="Activate"	class="button"	onClick="submitForm('wasteContainer','inPatientMaster?method=deleteWasteContainer&flag='+this.value)"	style="display: none;" accesskey="d" tabindex=1 /> 
<input type="reset"	name="Reset" id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('wasteContainer','inPatientMaster?method=showWasteContainerJsp');"  accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= COMMON_ID%>" id="<%= COMMON_ID%>"  value="" />

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
	
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Waste Container Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Waste Container Name"
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
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchWasteContainerList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasWasteContainer  masWasteContainer = (MasWasteContainer)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masWasteContainer.getId()%>
data_arr[<%= counter%>][1] = "<%=masWasteContainer.getWasteContainerCode()%>"
data_arr[<%= counter%>][2] = "<%= masWasteContainer.getWasteContainerName()%>"





data_arr[<%= counter%>][3] = "<%= masWasteContainer.getLastChgBy()!=null?(masWasteContainer.getLastChgBy().getId()!=null?masWasteContainer.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masWasteContainer.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masWasteContainer.getLastChgTime() %>"
<% if(masWasteContainer.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "wasteContainer"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
