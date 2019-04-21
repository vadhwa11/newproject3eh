<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ph_syndromic_survcillence_mapping.jsp  
 * Purpose of the JSP -  This is for Unit.
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
<%@page import="jkt.hms.masters.business.PhSyndromicSurvcillenceMapping"%>


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
ArrayList searchPhSyndromicSurvcillenceMappingList = (ArrayList)map.get("searchPhSyndromicSurvcillenceMappingList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

%>

<script type="text/javascript">
function mainGroupNameSelectedtext()
{
	var mainGroupNameSelect = document.getElementById("mainGroupId");
	var selectedText = mainGroupNameSelect.options[mainGroupNameSelect.selectedIndex].text;
	document.getElementById("mainGroupName").value=selectedText;
	return true;

}
function subGroupNameSelectedtext()
{
	var subGroupNameSelect = document.getElementById("subGroupId");
	var selectedText = subGroupNameSelect.options[subGroupNameSelect.selectedIndex].text;
	document.getElementById("subGroupName").value=selectedText;
	return true;

}

</script>
<div class="titleBg">
<h2>Syndromic Survcillence Mapping</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop5"></div>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Parameter Name</label>
<input type="text" id="searchField" name="<%= SEARCH_NAME%>"	value="" validate="Parameter Name,string,no" MAXLENGTH="8" tabindex=1/>
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','pubHealth?method=searchPhSyndromicSurvcillenceMapping','checkSearch')"	tabindex=1 />
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
		if(searchPhSyndromicSurvcillenceMappingList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("parameterName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%> <a href="pubHealth?method=showPhSyndromicSurvcillenceMappingJsp">Show All Records</a> <%
			}
		 }
	 if(searchPhSyndromicSurvcillenceMappingList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="pubHealth?method=showPhSyndromicSurvcillenceMappingJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"mainGroupName"], [2,"mainGroupId"], [3,"subGroupName"], [4,"subGroupId"],[5,"<%= SEARCH_NAME%>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script></div>

<form name="syndromicSurvcillenceMapping" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"	name="<%= POJO_NAME %>" value="PhSyndromicSurvcillenceMapping"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="ParameterName"> 
<input	type="hidden" name="title" value="ph_syndromic_survcillence_mapping"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="ph_syndromic_survcillence_mapping"> 
<input type="hidden"	name="pojoPropertyName" value="ParameterName">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">


<label>Main Group Name</label> 
<select name="mainGroupId" id="mainGroupId" onchange="mainGroupNameSelectedtext();"> 
<option value="">Select</option>
<option value="1">Fever</option>
<option value="2">Cough with or without fever</option>
<option value="3">Loose Watery Stool of Less than 2 weeks duration</option>
<option value="4">Jaundice cases of less than 4 Weeks Duration</option>
<option value="5">Acute Flacid Paralysis Cases in less than 15 years of age</option>
<option value="6">Unusual Symptoms leading to death or Hospitalisation that do not fir into the above</option>
</select>
<input name="mainGroupName" type="hidden" id="mainGroupName">


<label>Sub Group Name</label> 
<select name="subGroupId" id="subGroupId" onchange="subGroupNameSelectedtext();"> 
<option value="">Select</option>
<option value="1">Only Fever</option>
<option value="2">Fever with Rash</option>
<option value="3">Fever with Bleeding</option>
<option value="4">With Daze/Semiconsiousness/Unconsiousness/Altered sensorium</option>
<option value="5">Cough with or without fever</option>
<option value="6">with Dehydration/Severe Dehydration</option>
<option value="7">with no Dehydration</option>
<option value="8">with Blood in Stool</option>
<option value="9">Cases of Acute Jaundice</option>
<option value="10">Cases of Acute Flacid Paralysis</option>
</select>
<input name="subGroupName" type="hidden" id="subGroupName">


<label><span>*</span>Parameter Name</label> 
<select name="<%=SEARCH_NAME %>" id="<%=SEARCH_NAME %>"> 
<option value="">Select</option>
<option value="Only Fever">Only Fever</option>
<option value="Fever with Rash">Fever with Rash</option>
<option value="Fever with Bleeding">Fever with Bleeding</option>
<option value="Fever with Daze">Fever with Daze</option>
<option value="Fever with Semi Consciousness">Fever with Semi Consciousness</option>
<option value="Fever with Unconsciousness">Fever with Unconsciousness</option>
<option value="Fever with Altered Sensorium">Fever with Altered Sensorium</option>
<option value="Cough with Fever">Cough with Fever</option>
<option value="Cough without Fever">Cough without Fever</option>
<option value="Loose Watery Stools with Dehydration">Loose Watery Stools with Dehydration</option>
<option value="Loose Watery Stools with Severe Dehydration">Loose Watery Stools with Severe Dehydration</option>
<option value="Loose Watery Stools with no Dehydration">Loose Watery Stools with no Dehydration</option>
<option value="Loose Watery Stools with Blood in Stool">Loose Watery Stools with Blood in Stool</option>
<option value="Cases of Acute Jaundice">Cases of Acute Jaundice</option>
<option value="Cases of Acute Flacid Paralysis">Cases of Acute Flacid Paralysis</option>
<option value="Unusual Symptoms">Unusual Symptoms</option>
</select>

<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('syndromicSurvcillenceMapping','pubHealth?method=addPhSyndromicSurvcillenceMapping');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('syndromicSurvcillenceMapping','pubHealth?method=editPhSyndromicSurvcillenceMapping')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton"	value="Activate" class="button" style="display: none;"	onClick="submitForm('syndromicSurvcillenceMapping','pubHealth?method=deletePhSyndromicSurvcillenceMapping&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="button"	onClick="submitForm('syndromicSurvcillenceMapping','pubHealth?method=showPhSyndromicSurvcillenceMappingJsp');" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> <label	class="value"><%=userName%></label> 
<label>Changed Date:</label> <label	class="value"><%=date%></label> 
<label>Changed Time:</label> <label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />



</div>
</form>

<script type="text/javascript">
data_header = new Array();


data_header[0] = new Array;
data_header[0][0] = "Main Group Name"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "";

data_header[1] = new Array;
data_header[1][0] = "Main Group Id"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "";


data_header[2] = new Array;
data_header[2][0] = "Sub Group Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "";


data_header[3] = new Array;
data_header[3][0] = "Sub Group Id"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "";


data_header[4] = new Array;
data_header[4][0] = "Parameter Name"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%= SEARCH_NAME%>"


data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchPhSyndromicSurvcillenceMappingList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  PhSyndromicSurvcillenceMapping  phSyndromicSurvcillenceMapping = (PhSyndromicSurvcillenceMapping)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= phSyndromicSurvcillenceMapping.getId()%>
data_arr[<%= counter%>][1] = "<%= phSyndromicSurvcillenceMapping.getMainGroupName()%>"
data_arr[<%= counter%>][2] = "<%= phSyndromicSurvcillenceMapping.getMainGroupId() %>"
data_arr[<%= counter%>][3] = "<%= phSyndromicSurvcillenceMapping.getSubGroupName() %>"
data_arr[<%= counter%>][4] = "<%= phSyndromicSurvcillenceMapping.getSubGroupId() %>"
data_arr[<%= counter%>][5] = "<%=phSyndromicSurvcillenceMapping.getParameterName()%>"
data_arr[<%= counter%>][6] = "<%= phSyndromicSurvcillenceMapping.getLastChgBy()!=null?(phSyndromicSurvcillenceMapping.getLastChgBy().getId()!=null?phSyndromicSurvcillenceMapping.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(phSyndromicSurvcillenceMapping.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= phSyndromicSurvcillenceMapping.getLastChgTime() %>"
<% if(phSyndromicSurvcillenceMapping.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "syndromicSurvcillenceMapping"

nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

