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
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasState"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> searchDistrictList = new ArrayList<MasDistrict>();
	List<MasState> gridStateList = new ArrayList<MasState>();
	if(map.get("stateList") != null){
		stateList = (List)map.get("stateList");
	}
		
	if(map.get("searchDistrictList") !=null){
		searchDistrictList = (List)map.get("searchDistrictList");
	}
	if(map.get("gridStateList") !=null){
		gridStateList = (List)map.get("gridStateList");
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
<h2>District Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>District Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>District Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="hidden" name="colCode" value="district_code">
<input type="hidden" name="colName" value="district_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="District Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchDistrict')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchDistrict','checkSearch')"	tabindex=1 /> 
<%--- Report Button   --%> <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_district">

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
		if(searchDistrictList.size()>0 && stateList.size() > 0)
		 {
			String strForCode = (String)map.get("districtCode");
			String strForCodeDescription = (String)map.get("districtName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showDistrictJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchDistrictList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showDistrictJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=STATE_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="district" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDistrict"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DistrictName"><input
	type="hidden" name="title" value="District"><input
	type="hidden" name="<%=JSP_NAME %>" value="district"><input
	type="hidden" name="pojoPropertyCode" value="DistrictCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> District Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="District Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> District Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="District Name,string,yes" class="textbox_size20"	MAXLENGTH="30" / tabindex=1>
<script>
document.district.<%=CODE%>.focus();
</script> 
<label><span>*</span> State </label> 
<select name="<%=STATE_ID %>" id="<%=STATE_ID %>" validate="State,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasState  masState : stateList){
				%>
	<option value="<%=masState.getId ()%>"><%=masState.getStateName().trim()%></option>
	<%}%>
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('district','generalMaster?method=addDistrict');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('district','generalMaster?method=editDistrict')"	style="display: none;" accesskey="u" tabindex=1 /> 
<input	type="button" name="Delete" id="deletebutton" value="Activate"	class="button"	onClick="submitForm('district','generalMaster?method=deleteDistrict&flag='+this.value)"	style="display: none;" accesskey="d" tabindex=1 /> 
<input type="reset"	name="Reset" id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('district','generalMaster?method=showDistrictJsp');"  accesskey="r" /> 
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
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "District Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "District Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "State "
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
Iterator itr=searchDistrictList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDistrict  masDistrict = (MasDistrict)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDistrict.getId()%>
data_arr[<%= counter%>][1] = "<%=masDistrict.getDistrictCode()%>"
data_arr[<%= counter%>][2] = "<%= masDistrict.getDistrictName()%>"




	<%
	Iterator itrGridStateList=gridStateList.iterator();
	 while(itrGridStateList.hasNext())
        {try{
        	MasState  stateGrid = (MasState)itrGridStateList.next();
		 if(masDistrict.getState().getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("Y")){%>
			data_arr[<%= counter%>][3] = "<%=stateGrid.getStateName().trim()%>"
		<%}else if(masDistrict.getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("N")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid.getStateName().trim()%>";

		<%}
        }catch(Exception e){}}%>


data_arr[<%= counter%>][4] = "<%= masDistrict.getLastChgBy()!=null?(masDistrict.getLastChgBy().getId()!=null?masDistrict.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masDistrict.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masDistrict.getLastChgTime() %>"
<% if(masDistrict.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "district"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
