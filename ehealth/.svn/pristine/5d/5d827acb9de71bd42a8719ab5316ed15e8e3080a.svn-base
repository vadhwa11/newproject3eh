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
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<PhMasParliyamentAssembly> searchParliyamentList = new ArrayList<PhMasParliyamentAssembly>();
	List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
	if(map.get("districtList") != null){
		districtList = (List)map.get("districtList");
	}
		
	if(map.get("searchParliyamentList") !=null){
		searchParliyamentList = (List)map.get("searchParliyamentList");
	}
	 if(map.get("gridDistrictList") !=null){
		gridDistrictList = (List)map.get("gridDistrictList");
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
<h2>Parliament  Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Parliament  Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Parliament  Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />


<input type="hidden" name="colCode" value="code">
<input type="hidden" name="colName" value="name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Parliament  Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchParliyament')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchParliyament','checkSearch')"	tabindex=1 /> 
<%--- Report Button   --%> <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_parliyament">
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
		if(searchParliyamentList.size()>0 && districtList.size() > 0)
		 {
			String strForCode = (String)map.get("code");
			String strForCodeDescription = (String)map.get("name");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showParliyamentJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchParliyamentList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showParliyamentJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=DISTRICT_ID %>"], [4,"<%=STATUS%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"] ];
	 statusTd = 4;
	</script></div>

<form name="parliyament" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="PhMasParliyamentAssembly">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Name">
<input type="hidden" name="<%=JSP_NAME %>" value="parliyament"/>
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="Code">
<input type="hidden" name="title" value="Parliyament">
 
<input type="hidden" name="pojoPropertyCode" value="Code">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span> Parliament  Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Parliament  Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>


<label><span>*</span> Parliament  Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Parliament  Name,string,yes" class="textbox_size20"	MAXLENGTH="30" / tabindex=1>
<script>
document.parliyament.<%=CODE%>.focus();
</script> 

<label><span>*</span> District </label> 
<select name="<%=DISTRICT_ID %>" id="<%=DISTRICT_ID %>" validate="District,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasDistrict  masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}%>
</select>

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('parliyament','generalMaster?method=addParliyament');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('parliyament','generalMaster?method=editParliyament')"	style="display: none;" accesskey="u" tabindex=1 /> 
<input	type="button" name="Delete" id="deletebutton" value="Activate"	class="button"	onClick="submitForm('parliyament','generalMaster?method=deleteParliyament&flag='+this.value)"	style="display: none;" accesskey="d" tabindex=1 /> 
<input type="reset"	name="Reset" id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('parliyament','generalMaster?method=showParliyamentJsp');"  accesskey="r" /> 
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
data_header[0][0] = "Parliament  Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Parliament  Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "District "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=STATUS %>";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>";



data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_TIME %>";


data_arr = new Array();

<%
Iterator itr=searchParliyamentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             PhMasParliyamentAssembly  phMasParliyamentAssembly = (PhMasParliyamentAssembly)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= phMasParliyamentAssembly.getId()%>
data_arr[<%= counter%>][1] = "<%=phMasParliyamentAssembly.getCode()%>"
data_arr[<%= counter%>][2] = "<%= phMasParliyamentAssembly.getName()%>"

	<%
	Iterator itrGridDistrictList=districtList.iterator();
	 while(itrGridDistrictList.hasNext())
        {try{
        	MasDistrict  districtGrid = (MasDistrict)itrGridDistrictList.next();
		 if(phMasParliyamentAssembly.getDistrict().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equalsIgnoreCase("Y")){%>
			data_arr[<%= counter%>][3] = "<%=districtGrid.getDistrictName()%>"
		<%}else if(phMasParliyamentAssembly.getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("N")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid.getDistrictName() %>";

		<%}
        }catch(Exception e){}}%>

        <% if(phMasParliyamentAssembly.getStatus().equalsIgnoreCase("Y")){ %>
        data_arr[<%= counter%>][4] = "Active"
        <%}else{%>
        data_arr[<%= counter%>][4] = "InActive"
        <%}%>
      
 
data_arr[<%= counter%>][5] = "<%= phMasParliyamentAssembly.getLastChgBy()!=null?(phMasParliyamentAssembly.getLastChgBy().getId()!=null?phMasParliyamentAssembly.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(phMasParliyamentAssembly.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= phMasParliyamentAssembly.getLastChgTime() %>" 

<%
		     counter++;
}
%>
formName = "parliyament"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
