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

<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasSpecialityParameter> masParameter = new ArrayList<MasSpecialityParameter>();
		
		List<MasSpecialityGroup> gridGroupList = new ArrayList<MasSpecialityGroup>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masParameter") != null){
			masParameter = (ArrayList)map.get("masParameter");
		}
			
	    if(map.get("gridGroupList") != null){
	    	gridGroupList = (ArrayList)map.get("gridGroupList");
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
		  <h2> <%=masParameter.size() %> </h2>
<h4>
	<span><%=message %></span>
</h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
	<h2>Parameter Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Parameter Code </label>

<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Parameter Name </label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Parameter,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchParameter')" />
<input type="button" name="search" value="Search" class="button"onclick="submitForm('search','generalMaster?method=searchParameter','checkSearch')" tabindex=1 /> 

				<%--- Report Button   --%>
							
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
		if(masParameter.size()>0 || masParameter.size() > 0)
		 {
			String strForCode = (String)map.get("pameterCode");
			String strForCodeDescription = (String)map.get("parameterName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showParameterJsp">Show All Records </a>
	</h4>
	<%
			}
		 }
	 if(masParameter.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showParameterJsp">Show All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= VALUE_TYPE%>"],[4,"<%= IMG_REQ%>"],[5,"<%= COMMON%>"], [6,"<%= STATUS%>"],  [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"] ];
	 statusTd = 6;

	</script>
</div>

<form name="state" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
	<input type="hidden" name="<%= POJO_NAME %>" value="MasSpecialityParameter">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SpParameterName">
			<input type="hidden" name="<%=POJO_PROPERTY_CODE %>"
			value="SpParameterCode"> <input type="hidden" name="title"
				value="PARAMETER"> <input type="hidden" name="<%=JSP_NAME %>"
					value="speciality_parameter"> <input type="hidden" name="pojoPropertyCode"
						value="SpParameterCode">

							<div class="paddingTop5"></div>
							<div class="clear"></div>
							<div class="Block">
								
								<label><span>*</span> Parameter Code</label> <input type="text"
									name="<%= CODE%>" value="" validate="Parameter Code,number,yes"
									class="textbox_size20" MAXLENGTH="8" tabindex=1 /> <label><span>*</span>
									Parameter Name </label> <input type="text" name="<%= SEARCH_NAME %>"
									value="" validate="Parameter Name,string,yes"
									class="textbox_size20" MAXLENGTH="236" tabindex=1 />
									<label><span>*</span> Snomed CT </label> <input type="text"
									name=" " value="" validate="Snomed Code,alphanumeric,no"
									class="textbox_size20" MAXLENGTH="8" tabindex=1 />
									       
									                 
									                 
									                 
									                 
									                 
			<%-- 						                 
									                 
			<label><span>*</span> Value Type</label> <select name="<%=VALUE_TYPE%>" validate="Parameter,string,yes" tabindex=1>
			<option value="">Select</option>
            <option value="TEXT">Text</option>
            <option value="LOV">LOV</option>
            <option value="TEXT AREA">Text Area</option>
            <option value="CHECK BOX">Check Box</option>
            <option value="RADIO BUTTON">Radio Button</option>
            
		</select>    
		 --%>
	<div class="clear"></div>
	<%-- <label><span>*</span>Image Required</label> <select	name="<%= IMG_REQ%>" validate="Image,string,yes" tabindex=1>
	
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="NO">NO</option>

	</select> 
	<label><span>*</span>Common</label> <select name="<%=COMMON%>" id="<%=COMMON%>"  validate="Common,string,yes" tabindex=1>
		
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">NO</option>

	</select>
		
             --%>
		
		       
	
								<script>
			document.state.<%=CODE%>.focus();
			</script>
							<div class="clear"></div>
							<div id="edited"></div>
							
							 <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('state','generalMaster?method=addParameter');"accesskey="a" tabindex=1 />
							
							 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;"
							class="button"	onClick="submitForm('state','generalMaster?method=editParameter')"
							accesskey="u" tabindex=1 /> 
							
							
							<input type="button" name="Delete"id="deletebutton" value="Activate" class="button"
							style="display: none;" onClick="submitForm('state','generalMaster?method=deleteParameter&flag='+this.value)"
							accesskey="d" tabindex=1 />
							
							 <input type="reset" name="Reset"id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" />
							
							 <input type="hidden"name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> 
							
							<!-- Added By Ritu for edit page-->
							
							<input type="hidden" id="pageNoEdit" name="pageNoEdit"
							value="<%=pageNo%>" /> <!--  -->
							<div class="clear"></div>
							</div>
							<div class="bottom">
								<label> Changed By: </label> <label class="value"><%=userName%></label>
								<label> Changed Date: </label> <label class="value"><%=date%></label>
								<label> Changed Time: </label> <label class="value"><%=time%></label>
								<input type="hidden" name="<%=CHANGED_BY%>"
									value="<%=userName%>" /> <input type="hidden"
									name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
									type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
							</div>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Parameter Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Parameter Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Value Type"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%= VALUE_TYPE %>";

data_header[3] = new Array;
data_header[3][0] = "Image  Required"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%= IMG_REQ %>";

data_header[4] = new Array;
data_header[4][0] = "Common"
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%= COMMON %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";


data_header[6] = new Array;                   
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_TIME %>"



data_arr = new Array();


<%
Iterator itr=masParameter.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityParameter  masSpParameter = (MasSpecialityParameter)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSpParameter.getId()%>
data_arr[<%= counter%>][1] = "<%=masSpParameter.getSpParameterCode()%>"
data_arr[<%= counter%>][2] = "<%= masSpParameter.getSpParameterName()%>"
data_arr[<%= counter%>][3] = "<%= masSpParameter.getValueType()%>"
data_arr[<%= counter%>][4] = "<%= masSpParameter.getImageReq()%>"
data_arr[<%= counter%>][5] = "<%= masSpParameter.getCommon()%>"

	<% if(masSpParameter.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][6] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][6] = "InActive"
	<%}%>
data_arr[<%= counter%>][7] = "<%= masSpParameter.getLastChgBy()%>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masSpParameter.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masSpParameter.getLastChgTime() %>"

<%
       counter++;
}
%>


<%-- 
<%
Iterator itr=masGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityGroup  masGroup = (MasSpecialityGroup)itr.next(); 
%>


data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGroup .getId()%>
data_arr[<%= counter%>][1] = "<%=masGroup .getSpGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masGroup .getSpGroupName()%>"
<%
		Iterator itrGridGroupList=gridGroupList.iterator();
		 while(itrGridGroupList.hasNext())
            {
			 MasSpecialityGroup  masGroupItr = (MasSpecialityGroup)itrGridGroupList.next(); 
            
			 if(masGroupItr.getSpGroupName().getId().equals(masGroupItr.getId()) && masGroupItr.getStatus().equalsIgnoreCase("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masGroupItr.getSpGroupName()%>"
			<%}else if(masGroupItr.getSpGroupName().getId().equals(masGroupList.getId()) && masGroupList.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masGroupList.getSpGroupName()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masGroupList.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masGroupList.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masGroupList.getLastChgTime() %>
	"
<% if(masGroupList.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[
<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 --%>
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
</form>
