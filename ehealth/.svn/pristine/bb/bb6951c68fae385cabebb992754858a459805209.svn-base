<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All HospitalType Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>

<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchHospitalTypeList = (ArrayList)map.get("searchHospitalTypeList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}

if(map.get("message") != null){
	   String message = (String)map.get("message");
	 %>
<h4><span><%=message %></span></h4>
<%}

%>

<!--main content placeholder starts here-->

<h2>Institute Type Master</h2>

<div class="clear"></div>
<!--Block One Starts-->
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Institute Type Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"	checked="checked" class="radioCheck" /> 

<label>Institute Type Name</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />

<input	type="hidden" name="colCode" value="hospital_type_code">
<input	type="hidden" name="colName" value="hospital_type_name">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="HospitalType Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=searchHospitalType','checkSearch')" />

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','hospital?method=searchHospitalType','checkSearch')"	tabindex=1 />

<input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_hospitalType">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchHospitalTypeList.size()>0)
		 {
			String strForCode = (String)map.get("hospitalTypeCode");
			String strForCodeDescription = (String)map.get("hospitalTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="hospital?method=showHospitalTypeJsp">Show All Records</a> <%
			}
		 }
	 if(searchHospitalTypeList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="hospital?method=showHospitalTypeJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=DESCRIPTION %>"],[4,"<%= CHANGED_BY%>"],[5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"]];
	 statusTd = 7;
	</script>
<div class="clear"></div>
</div>
<form name="hospitalType" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasHospitalType">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HospitalTypeName">
<input	type="hidden" name="title" value="HospitalType">
<input	type="hidden" name="<%=JSP_NAME %>" value="hospitalType">
<input	type="hidden" name="pojoPropertyCode" value="HospitalTypeCode">
<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span> Institute Type Code </label> 

<input id="codeId" class="date" type="text"	name="<%= CODE%>" value="" validate="HospitalType Code,string,no"	MAXLENGTH="8" tabindex=1 /> 

<label><span>*</span> Institute Type Name</label> 

<input id="hospitalTypeName" type="text" class="date"	name="<%= SEARCH_NAME %>" value="" validate="Hospital Type Name,string,no"	MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=addHospitalType')" />
<script>
document.hospitalType.<%=CODE%>.focus();
</script> 

<label>Description </label>
<input type="text" name="<%= DESCRIPTION %>" class="date" id="description"	value="" validate="description,string,no" MAXLENGTH="100" tabindex=1 />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('hospitalType','hospital?method=addHospitalType','checkBlankForAddHospitalType');"	accesskey="a" tabindex=1 /> 

<input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('hospitalType','hospital?method=editHospitalType')"	accesskey="u" tabindex=1 />

<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('hospitalType','hospital?method=deleteHospitalType&flag='+this.value)"	accesskey="d" tabindex=1 />
 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />

<input type="button"	name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('hospitalType','superAdmin?method=showModuleManagementJsp')"	tabindex=1 />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">

<label>Changed By</label> 

<label class="value"><%=userName %></label>

<label>Changed Date</label> 

<label class="value"><%=date%></label> 

<label>Changed Time</label> 

<label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="admin" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Institute Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Institute Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Description"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= DESCRIPTION%>"


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchHospitalTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasHospitalType  masHospitalType = (MasHospitalType)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHospitalType.getId()%>
data_arr[<%= counter%>][1] = "<%=masHospitalType.getHospitalTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masHospitalType.getHospitalTypeName()%>"

data_arr[<%= counter%>][3] = "<%=masHospitalType.getDescription()%>"

data_arr[<%= counter%>][4] = "<%= masHospitalType.getLastChgBy()!=null?(masHospitalType.getLastChgBy().getId()!=null?masHospitalType.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masHospitalType.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masHospitalType.getLastChgTime() %>"
<% if(masHospitalType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "hospitalType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
