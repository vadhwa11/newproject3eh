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
<%@page import="jkt.hms.masters.business.PhMasPanchayat"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
	List<PhMasPanchayat> searchPanchayatList = new ArrayList<PhMasPanchayat>();
	List<PhMasParliyamentAssembly> gridAssemblyList = new ArrayList<PhMasParliyamentAssembly>();
	if(map.get("assemblyList") != null){
		assemblyList = (List)map.get("assemblyList");
	}
		
	if(map.get("searchPanchayatList") !=null){
		searchPanchayatList = (List)map.get("searchPanchayatList");
	}
	if(map.get("gridAssemblyList") !=null){
		gridAssemblyList = (List)map.get("gridAssemblyList");
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
<h2>Panchayat Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Panchayat Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Panchayat Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="hidden" name="colCode" value="panchayat_code">
<input type="hidden" name="colName" value="panchayat_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Panchayat Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchPanchayat')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchPanchayat','checkSearch')"	tabindex=1 /> 
<%--- Report Button   --%> <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_panchayat">
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
		if(searchPanchayatList.size()>0 && assemblyList.size() > 0)
		 {
			String strForCode = (String)map.get("panchayatCode");
			String strForCodeDescription = (String)map.get("panchayatName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showPanchayatJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchPanchayatList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showPanchayatJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=STATE_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="panchayat" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="PhMasPanchayat"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PanchayatName"><input
	type="hidden" name="title" value="Panchayat"><input
	type="hidden" name="<%=JSP_NAME %>" value="panchayat"><input
	type="hidden" name="pojoPropertyCode" value="PanchayatCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Panchayat Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Panchayat Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Panchayat Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Panchayat Name,string,yes" class="textbox_size20"	MAXLENGTH="30" / tabindex=1>
<script>
document.panchayat.<%=CODE%>.focus();
</script> 
<label><span>*</span> Assembly </label> 
<select name="<%=STATE_ID %>" id="<%=STATE_ID %>" validate="Assembly,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (PhMasParliyamentAssembly  masAssembly : assemblyList){
				%>
	<option value="<%=masAssembly.getId ()%>"><%=masAssembly.getName().trim()%></option>
	<%}%>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('panchayat','generalMaster?method=addPanchayat');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('panchayat','generalMaster?method=editPanchayat')"	style="display: none;" accesskey="u" tabindex=1 /> 
<input	type="button" name="Delete" id="deletebutton" value="Activate"	class="button"	onClick="submitForm('panchayat','generalMaster?method=deletePanchayat&flag='+this.value)"	style="display: none;" accesskey="d" tabindex=1 /> 
<input type="reset"	name="Reset" id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('panchayat','generalMaster?method=showPanchayatJsp');"  accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= COMMON_ID%>" id="<%= COMMON_ID%>"  value="" />
<div class="clear"></div>
</div>

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

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Panchayat Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Panchayat Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Assembly "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=STATE_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchPanchayatList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             PhMasPanchayat  phMasPanchayat = (PhMasPanchayat)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= phMasPanchayat.getId()%>
data_arr[<%= counter%>][1] = "<%=phMasPanchayat.getPanchayatCode()%>"
data_arr[<%= counter%>][2] = "<%= phMasPanchayat.getPanchayatName()%>"




	<%
	Iterator itrGridAssemblyList=gridAssemblyList.iterator();
	 while(itrGridAssemblyList.hasNext())
        {try{
        	PhMasParliyamentAssembly  assemblyGrid = (PhMasParliyamentAssembly)itrGridAssemblyList.next();
		 if(phMasPanchayat.getAssembly().getId().equals(assemblyGrid.getId()) && assemblyGrid.getStatus().equals("Y")){%>
			data_arr[<%= counter%>][3] = "<%=assemblyGrid.getName().trim()%>"
		<%}else if(phMasPanchayat.getId().equals(assemblyGrid.getId()) && assemblyGrid.getStatus().equals("N")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=assemblyGrid.getName().trim()%>";

		<%}
        }catch(Exception e){}}%>


    	data_arr[<%= counter%>][4] = "<%= phMasPanchayat.getLastChgBy()!=null?(phMasPanchayat.getLastChgBy().getId()!=null?phMasPanchayat.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(phMasPanchayat.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= phMasPanchayat.getLastChgTime() %>"
<% if(phMasPanchayat.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "panchayat"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
