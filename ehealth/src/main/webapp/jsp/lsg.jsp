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
<%@page import="jkt.hms.masters.business.MasLsgType"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasLsg"%>
<%@ page import="jkt.hms.masters.business.MasPostCode"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasLsg> masLsgList = new ArrayList<MasLsg>();
	List<MasLsgType> masLsgTypeList = new ArrayList<MasLsgType>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masLsgList") != null){
		masLsgList = (ArrayList)map.get("masLsgList");
	}
	if(map.get("masLsgTypeList") != null){
		masLsgTypeList = (ArrayList)map.get("masLsgTypeList");
	}
	if(map.get("masHospitalList") != null){
		masHospitalList = (ArrayList)map.get("masHospitalList");
	}
	if(map.get("masDistrictList") != null){
		masDistrictList = (ArrayList)map.get("masDistrictList");
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
<h2>LSG Master</h2>
</div>
<div class="Block">
<div class="Lsg">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Lsg Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>LSG Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="hidden" name="colCode" value="lsg_type_code">
<input type="hidden" name="colName" value="lsg_type_name">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Lsg Code,string,no" MAXLENGTH="20" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchLsg')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchLsg','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_lsg">
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
		if(masDistrictList.size()>0 || masLsgList.size() > 0)
		 {
			String strForCode = (String)map.get("lsgTypeCode");
			String strForCodeDescription = (String)map.get("lsgTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showLsgJsp">Show All Records </a></h4>

<%
			}
		 }
	 if(masDistrictList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showLsgJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"lsgTypeId"], [4,"districtId"] ,[5,"<%=CHANGED_BY%>"], [6,"<%=CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"]];	 
		 statusTd = 8;
	</script></div>

<form name="lsg" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasLsg"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="LsgTypeName">
<input type="hidden" name="title" value="Lsg"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="lsg"> 
<input	type="hidden" name="pojoPropertyCode" value="LsgTypeCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Lsg">
<div class="Block">
<label><span>*</span> Lsg Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Lsg Code,string,yes" class="textbox_size20" MAXLENGTH="20"	tabindex=1 /> 
<label><span>*</span> Lsg Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Lsg  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.lsg.<%=CODE%>.focus();
			</script>


<label><span>*</span> Lsg Type </label> 
<select	name="lsgTypeId" validate="Lsg Type,string,yes" tabindex=1	>
	<option value="0">Select</option>
	<% 
				
				for (MasLsgType  masLsgType : masLsgTypeList){
				%>
	<option value="<%=masLsgType.getId()%>"><%=masLsgType.getLsgTypeName()%></option>

	<%}%>
</select>

<div class="clear"></div>
<label><span>*</span> District </label> 
<select	name="districtId" validate="District,string,yes" tabindex=1	>
	<option value="0">Select</option>
	<% 
				
				for (MasDistrict  masDistrict : masDistrictList){
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>

	<%}%>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('lsg','generalMaster?method=addLsg');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('lsg','generalMaster?method=editLsg')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('lsg','generalMaster?method=deleteLsg&flag='+this.value)" accesskey="d" tabindex=1 /> 
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
data_header[0][0] = "Lsg Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Lsg Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = "Lsg Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "lsgTypeId";

data_header[3] = new Array;
data_header[3][0] = "District"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "districtId";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = "Admin"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME%>";





data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=masLsgList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasLsg  masLsg = (MasLsg)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masLsg.getId()%>
data_arr[<%= counter%>][1] = "<%=masLsg.getLsgTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masLsg.getLsgTypeName()%>"

	<%
	Iterator itrmasLsgTypeList=masLsgTypeList.iterator();
	 while(itrmasLsgTypeList.hasNext())
	    {
	     MasLsgType  masLsgType = (MasLsgType)itrmasLsgTypeList.next(); 
	    
		 if(masLsg.getLsgType()!=null && masLsg.getLsgType().getId().equals(masLsgType.getId()) && masLsgType.getStatus().equalsIgnoreCase("y")){
		
		 %>
			data_arr[<%= counter%>][3] = "<%=masLsgType.getLsgTypeName() %>"
		<%}else if(masLsg.getLsgType()!=null  && masLsg.getLsgType().getId().equals(masLsgType.getId()) && masLsgType.getStatus().equalsIgnoreCase("N")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masLsgType.getLsgTypeName() %>";
			
		<%}
	}%>



<%
Iterator itrmasDistrictList=masDistrictList.iterator();
 while(itrmasDistrictList.hasNext())
    {
     MasDistrict  masDistrict = (MasDistrict)itrmasDistrictList.next(); 
    
	 if(masLsg.getDistrict()!=null && masLsg.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equalsIgnoreCase("y")){
	
	 %>
		data_arr[<%= counter%>][4] = "<%=masDistrict.getDistrictName() %>"
	<%}else if(masLsg.getDistrict()!=null  && masLsg.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equalsIgnoreCase("N")){%>
		data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masDistrict.getDistrictName() %>";
		
	<%}
}%>

 data_arr[<%= counter%>][5] = "<%= masLsg.getLastChgBy()!=null?(masLsg.getLastChgBy().getId()!=null?masLsg.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masLsg.getLastChgDate()) %>"
	data_arr[<%= counter%>][7] = "<%= masLsg.getLastChgTime() %>"
<% if(masLsg.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "lsg"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
