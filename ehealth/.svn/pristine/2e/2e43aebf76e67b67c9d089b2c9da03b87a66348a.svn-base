<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * labOrganismMst.jsp  
 * Purpose of the JSP -  This is for Organism Description Master.
 * @author  Vishal Jain
 * Create Date: 06th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasOrganismDescLab"%>
<%@page import="jkt.hms.masters.business.MasOrganismLab"%>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/hms.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<script>
<%
  	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>


<div id="contentSpace">
<%

Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOrganismDescList = (ArrayList)map.get("searchOrganismDescList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
List<MasOrganismLab> organismGroupList = new ArrayList<MasOrganismLab>();
organismGroupList = (ArrayList) map.get("organismGroupList");
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

%>
<h2 align="left" class="style1">Organism</h2>
<br>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="common">Organism Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="common">Organism
Name:</font> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Organism Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'laboratory?method=searchOrganismDescLab')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','laboratory?method=searchOrganismDescLab','checkSearch')"
	tabindex=1 /> <input type="button" name="report"
	value="Generate Report Based on Search" class="button"
	onclick="submitForm('search','laboratory?method=generateReportForLabOrganismDesc')"
	tabindex=1 /> <input type="hidden" name="<%=JASPER_FILE_NAME%>"
	value="OrganismDescMaster"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
 	
 	    if(searchOrganismDescList.size()>0 )
		 {
			
			String strForCode = (String)map.get("organismDescCode");
			String strForCodeDescription = (String)map.get("organismDescName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
				
	%> <br> <a href="laboratory?method=showOrganismDescLabJsp">Show
All Records</a> <%
			}
		 }
		
	 if(searchOrganismDescList.size()==0 && map.get("search") != null)
	  {
		 
	 %> <a href="laboratory?method=showOrganismDescLabJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ORGANISM_GROUP_ID %>"],[4,"<%= CHANGED_BY%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
</div>
<br />
<form name="labOrganismDesc" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasOrganismDescLab"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="OrganismDescName"><input
	type="hidden" name="title" value="labOrganism"><input
	type="hidden" name="<%=JSP_NAME %>" value="labOrganismDescMst"><input
	type="hidden" name="pojoPropertyCode" value="OrganismDescCode"><br />
<div id=contentHolder><label class="common"><font
	id="error">*</font> Organism Code: </label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Organism Code,string,yes"
	class="textbox_date" MAXLENGTH="8" / tabindex=1><label
	class="common"><font id="error">*</font>Organism Name:</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Organism Name,string,yes" class="textbox_date" MAXLENGTH="30"
	/ tabindex=1
	onkeypress="return submitenter(this,event,'laboratory?method=addOrganismDescLab')"><script>
				document.labOrganismDesc.<%=CODE%>.focus();
				</script> <label class="bodytextB_blue"><font id="error">*</font>Oragnism
Group:</label> <select name="<%= ORGANISM_GROUP_ID %>"
	validate="Oragnism Group,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			for (MasOrganismLab masOrganismLab : organismGroupList) {
		%>

	<option value="<%=masOrganismLab.getId ()%>"><%=masOrganismLab.getOrganismLabName()%></option>

	<%
			}
		%>
</select> <br />
<br />

<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName %></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('labOrganismDesc','laboratory?method=addOrganismDescLab');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('labOrganismDesc','laboratory?method=editOrganismDescLabToDatabase')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('labOrganismDesc','laboratory?method=deleteOrganismDescLab&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />

</center>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br /></form>
</div>

<script type="text/javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Organism Code"
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= CODE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Organism Name"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";
		
		data_header[2] = new Array;
		data_header[2][0] = "Organism Group"
		data_header[2][1] = "data";
		data_header[2][2] = "35%";
		data_header[2][3] = "<%= ORGANISM_GROUP_ID %>";
		
		data_header[3] = new Array;
		data_header[3][0] = ""
		data_header[3][1] = "hide";
		data_header[3][2] = 0;
		data_header[3][3] = "<%= CHANGED_BY%>"
		
		data_header[4] = new Array;
		data_header[4][0] = ""
		data_header[4][1] = "hide";
		data_header[4][2] = 0;
		data_header[4][3] = "<%= CHANGED_BY%>"
		
		data_header[5] = new Array;
		data_header[5][0] = ""
		data_header[5][1] = "hide";
		data_header[5][2] = 0;
		data_header[5][3] = "<%= CHANGED_DATE%>"
		
		data_header[6] = new Array;
		data_header[6][0] = ""
		data_header[6][1] = "hide";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=CHANGED_TIME %>";
		
		
		data_header[7] = new Array;
		data_header[7][0] = "Status"
		data_header[7][1] = "data";
		data_header[7][2] = "15%";
		data_header[7][3] = "<%=STATUS %>";
		
		data_arr = new Array();

	<%
	
	  
	Iterator itr = searchOrganismDescList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             MasOrganismDescLab  MasOrganismDescLab = (MasOrganismDescLab)itr.next(); 
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= MasOrganismDescLab.getId()%>
		data_arr[<%= counter%>][1] = "<%= MasOrganismDescLab.getOrganismDescCode()%>"
		data_arr[<%= counter%>][2] = "<%= MasOrganismDescLab.getOrganismDescName()%>"
		<%
		Iterator itrGridOrganismGroupList=organismGroupList.iterator();
		while(itrGridOrganismGroupList.hasNext())
       {
       		MasOrganismLab  organismGroupGrid = (MasOrganismLab)itrGridOrganismGroupList.next(); 
			if(MasOrganismDescLab.getOrganismGroup().getId().equals(organismGroupGrid.getId()) && organismGroupGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=organismGroupGrid.getOrganismLabName()%>"
			<%}else if(MasOrganismDescLab.getId().equals(organismGroupGrid.getId()) && organismGroupGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=organismGroupGrid.getOrganismLabName()%>";
				
			<%}
		}
%>
		data_arr[<%= counter%>][4] = "<%= MasOrganismDescLab.getOrganismGroup() %>"
		data_arr[<%= counter%>][5] = "<%= MasOrganismDescLab.getLastChgBy() %>"
		data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(MasOrganismDescLab.getLastChgDate())%>"
		data_arr[<%= counter%>][7] = "<%= MasOrganismDescLab.getLastChgTime() %>"
		<% if(MasOrganismDescLab.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][8] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][8] = "InActive"
		<%}%>
		<%
				     counter++;
		}
		%>
 
		formName = "labOrganismDesc"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>