<%--
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
<%@ page import="jkt.hms.masters.business.MasTaluk"%>
<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasVillage"%>
<%@ page import="jkt.hms.masters.business.MasPostCode"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasVillage> masVillageList = new ArrayList<MasVillage>();
	List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	List<MasTaluk> masTalukList = new ArrayList<MasTaluk>();
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masVillageList") != null){
		masVillageList = (ArrayList)map.get("masVillageList");
	}
	if(map.get("masPostCodeList") != null){
		masPostCodeList = (ArrayList)map.get("masPostCodeList");
	}
	if(map.get("masHospitalList") != null){
		masHospitalList = (ArrayList)map.get("masHospitalList");
	}
	if(map.get("masTalukList") != null){
		masTalukList = (ArrayList)map.get("masTalukList");
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
<h2>Village Master</h2>
</div>
<div class="Block">
<div class="Village">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Village Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Village Description</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 

<input type="hidden" name="colCode" value="village_code">
<input type="hidden" name="colName" value="village_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Village Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchVillage')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchVillage','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_village">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
</div>
</div>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(masTalukList.size()>0 || masVillageList.size() > 0)
		 {
			String strForCode = (String)map.get("villageCode");
			String strForCodeDescription = (String)map.get("villageName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showVillageJsp">Show All Records </a></h4>

<%
			}
		 }
	 if(masTalukList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showVillageJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"talukId"] ,[4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"]];	 
		 statusTd = 7;
	</script></div>

<form name="village" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>" value="MasVillage"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VillageName">
<input type="hidden" name="title" value="Village"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="village"> 
<input	type="hidden" name="pojoPropertyCode" value="VillageCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Village">
<div class="Block">
<label><span>*</span> Village Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Village Code,string,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 
<label><span>*</span> Village Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Village  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.village.<%=CODE%>.focus();
			</script>

<label><span>*</span> Taluk </label> 
<select	name="talukId" validate="Taluk,string,yes" tabindex=1	>
	<option value="0">Select</option>
	<% 
				
				for (MasTaluk  masTaluk : masTalukList){
				%>
	<option value="<%=masTaluk.getId ()%>"><%=masTaluk.getTalukName()%></option>

	<%}%>
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('village','generalMaster?method=addVillage');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('village','generalMaster?method=editVillage')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('village','generalMaster?method=deleteVillage&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
</div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Village Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Village Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Taluk"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "talukId";



data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"

data_header[4] = new Array;
data_header[4][0] = "Admin"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME%>";





data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=masVillageList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasVillage  masVillage = (MasVillage)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masVillage.getId()%>
data_arr[<%= counter%>][1] = "<%=masVillage.getVillageCode()%>"
data_arr[<%= counter%>][2] = "<%= masVillage.getVillageName()%>"




<%
Iterator itrmasTalukList=masTalukList.iterator();
 while(itrmasTalukList.hasNext())
    {
     MasTaluk  masTaluk = (MasTaluk)itrmasTalukList.next(); 
    
	 if(masVillage.getTaluk()!=null && masVillage.getTaluk().getId().equals(masTaluk.getId()) && masTaluk.getStatus().equalsIgnoreCase("y")){
	
	 %>
		data_arr[<%= counter%>][3] = "<%=masTaluk.getTalukName() %>"
	<%}else if(masVillage.getTaluk()!=null  && masVillage.getTaluk().getId().equals(masTaluk.getId()) && masTaluk.getStatus().equalsIgnoreCase("N")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masTaluk.getTalukName() %>";
		
	<%}
}%>

 data_arr[<%= counter%>][4] = "<%= masVillage.getLastChgBy()!=null?(masVillage.getLastChgBy().getId()!=null?masVillage.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masVillage.getLastChgDate()) %>"
	data_arr[<%= counter%>][6] = "<%= masVillage.getLastChgTime() %>"
<% if(masVillage.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "village"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
