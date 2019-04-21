\<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * block.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: o7th April, 2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@ page import="jkt.hms.masters.business.PhMasterData"%>
<%@ page import="jkt.hms.masters.business.PhMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<PhMasterData> phMasterDataList = new ArrayList<PhMasterData>();
	List<PhMaster> phMasterList = new ArrayList<PhMaster>();
	
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("phMasterDataList") != null){
		phMasterDataList = (ArrayList)map.get("phMasterDataList");
	}
	if(map.get("phMasterList") != null){
		phMasterList = (ArrayList)map.get("phMasterList");
	}
	
	if(map.get("message") != null){
		 
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
		   message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}
%>
<div class="titleBg">
<h2>PH Master Data</h2>
</div>
<div class="clear"></div>

<div class="Block">

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Data Name</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Data Name,string,no" MAXLENGTH="32" tabindex=1  />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchPhMasterData','checkSearch')"	tabindex=1 />

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
		if(phMasterList.size()>0 || phMasterDataList.size() > 0)
		 {
			String strForCode = (String)map.get("phMasterDataName");
			if(strForCode!= null && strForCode!= "")
			{
	%> <h4><a href="generalMaster?method=showPhMasterDataJsp">Show All Records </a></h4>

<%
			}
		 }
	 if(phMasterList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showPhMasterDataJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"masterId"] ,[3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"]];	 
		 statusTd = 6;
	</script></div>

<form name="phMasterData" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Data Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Data  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.phMasterData.<%=SEARCH_NAME%>.focus();
			</script>

<label><span>*</span> Master </label> 
<select	name="masterId" id="masterId" validate="Master,string,yes" tabindex=1	>
	<option value="0">Select</option>
	<% 
				
				for (PhMaster  phMaster : phMasterList){
				%>
	<option value="<%=phMaster.getId()%>"><%=phMaster.getMasterName()%></option>

	<%}%>
</select>

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('phMasterData','generalMaster?method=addPhMasterData');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('phMasterData','generalMaster?method=editPhMasterData')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('phMasterData','generalMaster?method=deletePhMasterData&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="submitFormForButton('phMasterData','generalMaster?method=showPhMasterDataJsp');" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Data Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Master"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "masterId";


data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME%>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=phMasterDataList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             PhMasterData  phMasterData = (PhMasterData)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= phMasterData.getId()%>
data_arr[<%= counter%>][1] = "<%= phMasterData.getDataName()%>"




<%
Iterator itrmasMasterList=phMasterList.iterator();
 while(itrmasMasterList.hasNext())
    {
     PhMaster  phMaster = (PhMaster)itrmasMasterList.next(); 
    
	 if(phMasterData.getMaster()!=null && phMasterData.getMaster().getId().equals(phMaster.getId()) && phMaster.getStatus().equalsIgnoreCase("y")){
	
	 %>
		data_arr[<%= counter%>][2] = "<%=phMaster.getMasterName() %>"
	<%}else if(phMasterData.getMaster()!=null  && phMasterData.getMaster().getId().equals(phMaster.getId()) && phMaster.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=phMaster.getMasterName() %>";
		
	<%}
}%>

 data_arr[<%= counter%>][3] = "<%= phMasterData.getLastChgBy()!=null?(phMasterData.getLastChgBy().getId()!=null?phMasterData.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(phMasterData.getLastChgDate()) %>"
	data_arr[<%= counter%>][5] = "<%= phMasterData.getLastChgTime() %>"
<% if(phMasterData.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "phMasterData"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
