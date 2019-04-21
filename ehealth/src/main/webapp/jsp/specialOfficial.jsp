<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for SpecialOfficial.
 * @author  Mansi
 * Create Date: 17th April,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.9;
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialOfficial"%>


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

ArrayList searchSpecialOfficialList = (ArrayList)map.get("searchSpecialOfficialList");

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
<h2>Special Official Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">

<label>Special Official Name</label>

<input type="text" id="searchField" name="<%= SEARCH_NAME%>" value="" validate="Special Official Name,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="inputButtonAutu" onclick="submitForm('search','generalMaster?method=searchSpecialOfficial','checkSearch')"	tabindex=1 />

 <%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report Based on Search" class="inputButtonAutu" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 /> 

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_SpecialOfficial">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchSpecialOfficialList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("specialOfficialName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showSpecialOfficialJsp">Show All Records</a> 
	<%
			}
		 }
	 if(searchSpecialOfficialList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showSpecialOfficialJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= CHANGED_BY%>"], [3,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[5,"<%=STATUS%>"] ];
	 statusTd = 5;
	</script></div>

<form name="specialOfficial" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden"	name="<%= POJO_NAME %>" value="MasSpecialOfficial"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="SpecialOfficialName"> 
<input	type="hidden" name="title" value="SpecialOfficial"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="specialOfficial"> 
<input type="hidden"	name="pojoPropertyName" value="SpecialOfficialName">

<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">

<label><span>*</span>Special Official Name</label>

<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Special Official Name,string,yes" class="textbox_size20" MAXLENGTH="32"	 tabindex=1> 
<script>
		document.specialOfficial.<%=SEARCH_NAME%>.focus();
</script>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('specialOfficial','generalMaster?method=addSpecialOfficial');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('specialOfficial','generalMaster?method=editSpecialOfficial')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('specialOfficial','generalMaster?method=deleteSpecialOfficial&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('specialOfficial','generalMaster?method=showSpecialOfficialJsp')" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>

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
data_header[0][0] = "Special Official Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"


data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= CHANGED_BY %>"

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "0";
data_header[2][3] = "<%= CHANGED_DATE %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSpecialOfficialList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSpecialOfficial  masSpecialOfficial = (MasSpecialOfficial)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSpecialOfficial.getId()%>
data_arr[<%= counter%>][1] = "<%=masSpecialOfficial.getSpecialOfficialName()!=null?masSpecialOfficial.getSpecialOfficialName():" "%>"
data_arr[<%= counter%>][2] = "<%= masSpecialOfficial.getLastChgBy()!=null?(masSpecialOfficial.getLastChgBy().getId()!=null?masSpecialOfficial.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masSpecialOfficial.getLastChgDate()) %>"
data_arr[<%= counter%>][4] = "<%= masSpecialOfficial.getLastChgTime() %>"
<% if(masSpecialOfficial.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "specialOfficial"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
