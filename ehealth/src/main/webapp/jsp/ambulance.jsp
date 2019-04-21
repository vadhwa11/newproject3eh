<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ambulance.jsp  
 * Purpose of the JSP -  This is for Ambulance.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAmbulance"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
ArrayList searchAmbulanceList = (ArrayList)map.get("searchAmbulanceList");
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
<h2>Ambulance Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Ambulance No.</label> 
<input type="text" id="searchField" name="<%= SEARCH_NAME%>"	value="" validate="Ambulance No.,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'inPatientMaster?method=searchAmbulance')" />

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','inPatientMaster?method=searchAmbulance','checkSearch')"	tabindex=1 /> <%--- Report Button   --%> 
<!-- <input type="button"	name="Report" value="Generate Report Based on Search" class="button"	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_ambulance">
 -->
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchAmbulanceList.size()>0)
		 {
			String strForAmbulanceNo = (String)map.get("ambulanceNo");
			if(strForAmbulanceNo!= null && strForAmbulanceNo!= "")
			{
	%> <a href="inPatientMaster?method=showAmbulanceJsp">Show All Records</a> <%
			}
		 }
	 if(searchAmbulanceList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="inPatientMaster?method=showAmbulanceJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"description"], [3,"available"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="ambulance" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasAmbulance"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="AmbulanceNo"> <input
	type="hidden" name="title" value="Ambulance"> <input type="hidden"
	name="<%=JSP_NAME %>" value="ambulance"> <input type="hidden"
	name="pojoPropertyName" value="AmbulanceName">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Ambulance No.</label>
<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Ambulance No.,string,yes" class="textbox_size20" MAXLENGTH="56" tabindex=1/>
 <script>
		document.ambulance.<%=SEARCH_NAME%>.focus();
	</script> 
<label><span>*</span>Description </label>
<textarea rows="" cols="" name="description" id="description" class="textareaMediua"></textarea>

 <label >Avialable</label> 
 <select name="available" id="available">
 <option value="">Select</option>
 <option value="Yes">Yes</option>
 <option value="No">No</option>
 </select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('ambulance','inPatientMaster?method=addAmbulance');"	accesskey="a" tabindex=1 />
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('ambulance','inPatientMaster?method=editAmbulance')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" 	value="Activate" class="button" style="display: none;"	onClick="submitForm('ambulance','inPatientMaster?method=deleteAmbulance&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Ambulance No."
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "description";

data_header[2] = new Array;
data_header[2][0] = "Avialable"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "available"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchAmbulanceList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasAmbulance  masAmbulance = (MasAmbulance)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAmbulance.getId()%>
data_arr[<%= counter%>][1] = "<%=masAmbulance.getAmbulanceNo()%>"
data_arr[<%= counter%>][2] = "<%= masAmbulance.getDescription()%>"
data_arr[<%= counter%>][3] = "<%= masAmbulance.getAvailable() %>"
data_arr[<%= counter%>][4] = "<%= masAmbulance.getLastChgBy()!=null?(masAmbulance.getLastChgBy().getId()!=null?masAmbulance.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masAmbulance.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masAmbulance.getLastChgTime() %>"
<% if(masAmbulance.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "ambulance"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
