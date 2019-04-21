<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasState> masStateList = new ArrayList<MasState>();
		List<MasCountry> masCountryList = new ArrayList<MasCountry>();
		List<MasState> gridStateList = new ArrayList<MasState>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masStateList") != null){
			masStateList = (ArrayList)map.get("masStateList");
		}
		if(map.get("masCountryList") != null){
			masCountryList = (ArrayList)map.get("masCountryList");
		}
	if(map.get("gridStateList") != null){
	gridStateList = (ArrayList)map.get("gridStateList");
	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
<h2>State Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>State Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>State Description </label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 

<input type="hidden" name="colCode" value="state_code">
<input type="hidden" name="colName" value="state_name">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="State Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchState')" />
<input type="button" name="search" value="Search" class="button"onclick="submitForm('search','generalMaster?method=searchState','checkSearch')" tabindex=1 /> 
<%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_state"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		if(masCountryList.size()>0 || masStateList.size() > 0)
		 {
			String strForCode = (String)map.get("stateCode");
			String strForCodeDescription = (String)map.get("stateName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="generalMaster?method=showStateJsp">Show All Records </a></h4> <%
			}
		 }
	 if(masCountryList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showStateJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= COUNTRY_ID%>"],  [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;

	</script></div>

<form name="state" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden"
	name="<%= POJO_NAME %>" value="MasState"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="StateName"> <input
	type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="StateCode">
<input type="hidden" name="title" value="State"> <input
	type="hidden" name="<%=JSP_NAME %>" value="state"> <input
	type="hidden" name="pojoPropertyCode" value="StateCode">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> State Code</label> 
<input type="text" name="<%= CODE%>" value="" validate="State Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> State Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="State Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
<script>
			document.state.<%=CODE%>.focus();
			</script>
<label><span>*</span> Country </label> 
<select	name="<%= COUNTRY_ID%>" validate="Country,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addState')">
<option value="">Select</option>
	<% 
				for (MasCountry  masCountry : masCountryList){
				%>
	<option value="<%=masCountry.getId ()%>"><%=masCountry.getCountryName()%></option>
	<%}%>
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('state','generalMaster?method=addState');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('state','generalMaster?method=editState')" accesskey="u" tabindex=1 /> 

<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('state','generalMaster?method=deleteState&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<!-- Added By Ritu for edit page-->
<input type="hidden" id="pageNoEdit" name="pageNoEdit" value="<%=pageNo%>"/>  
<div class="clear"></div>
</div>
<div class="bottom">
<label> Changed By: </label> 
<label class="value"><%=userName%></label> 
<label> Changed Date: </label> 
<label class="value"><%=date%></label> 
<label> Changed Time: </label> 
<label class="value"><%=time%></label> 
<input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "State Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "State Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Country"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=COUNTRY_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=masStateList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasState  masState = (MasState)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masState.getId()%>
data_arr[<%= counter%>][1] = "<%=masState.getStateCode()%>"
data_arr[<%= counter%>][2] = "<%= masState.getStateName()%>"
<%
		Iterator itrGridCountryList=gridStateList.iterator();
		 while(itrGridCountryList.hasNext())
            {
             MasCountry  masCountry = (MasCountry)itrGridCountryList.next(); 
            
			 if(masState.getCountry().getId().equals(masCountry.getId()) && masCountry.getStatus().equalsIgnoreCase("Y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masCountry.getCountryName()%>"
			<%}else if(masState.getCountry().getId().equals(masCountry.getId()) && masCountry.getStatus().equalsIgnoreCase("N")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masCountry.getCountryName()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masState.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masState.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masState.getLastChgTime() %>"

<% if(masState.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "state"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
//pgNo = '<%=pageNo%>';
//totalPages = Math.ceil(data_arr.length/rowsPerPage);
//goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
