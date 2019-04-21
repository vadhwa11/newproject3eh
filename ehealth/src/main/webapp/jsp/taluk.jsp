<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * taluk.jsp  
 * Purpose of the JSP -  This is for Taluk Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: o7th April, 2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasTaluk> masTalukList = new ArrayList<MasTaluk>();
	List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
	List<MasTaluk> gridTalukList = new ArrayList<MasTaluk>();
	
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masTalukList") != null){
		masTalukList = (ArrayList)map.get("masTalukList");
	}
	if(map.get("masDistrictList") != null){
		masDistrictList = (ArrayList)map.get("masDistrictList");
	}
	if(map.get("gridTalukList") != null){
		gridTalukList = (ArrayList)map.get("gridTalukList");
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
		 <%} %> 
		 
<div class="titleBg">
<h2>Taluk Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Taluk Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Taluk Description </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 

<input type="hidden" name="colCode" value="taluk_code">
<input type="hidden" name="colName" value="taluk_name">
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Taluk Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchTaluk')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchTaluk','checkSearch')"	tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_taluk">
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
		if(masDistrictList.size()>0 || masTalukList.size() > 0)
		 {
			String strForCode = (String)map.get("talukCode");
			String strForCodeDescription = (String)map.get("talukName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showTalukJsp">Show All Records </a></h4> <%
			}
		 }
	 if(masDistrictList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showTalukJsp">Show All Records</a></h4> <%
     }
%>
	
<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DISTRICT_ID%>"], [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"] ];
	 
		 statusTd = 7;
</script></div>

<form name="taluk" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"name="<%= POJO_NAME %>" value="MasTaluk"/>
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TalukName"/>
<input	type="hidden" name="title" value="taluk"/>
<input type="hidden" name="<%=JSP_NAME %>" value="taluk"/>
<input type="hidden" name="pojoPropertyCode" value="TalukCode"/>
	
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<div class="Taluk">
<label><span>*</span> Taluk Code </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Taluk Code,string,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 
<label><span>*</span> Taluk Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Taluk  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
<script>
	document.taluk.<%=CODE%>.focus();
</script> 
<label><span>*</span> District </label> 
<select	name="<%= DISTRICT_ID%>" validate="District,string,yes" tabindex=1 >
<option value="0">Select</option>
	<% 
				
				for (MasDistrict  masDistrict : masDistrictList){
					String stateName="";
					if(masDistrict.getState()!=null){
						stateName="["+masDistrict.getState().getStateName().trim()+"]";
					}
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()+stateName%></option>

	<%}%>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('taluk','generalMaster?method=addTaluk');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('taluk','generalMaster?method=editTaluk')"
	style="display: none;" accesskey="u" tabindex=1 /> <input
	type="button" name="Delete" id="deletebutton" value="Activate"
	class="button"
	onClick="submitForm('taluk','generalMaster?method=deleteTaluk&flag='+this.value)"
	style="display: none;" accesskey="d" tabindex=1 /> 
	<input type="reset"
	name="Reset" id="reset" value="Reset" class="buttonHighlight"
	onClick="submitFormForButton('taluk','generalMaster?method=showTalukJsp')" accesskey="r" /> <input type="hidden"
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
data_header[0][0] = "Taluk Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Taluk Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "District"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

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
Iterator itr=masTalukList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasTaluk  masTaluk = (MasTaluk)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masTaluk.getId()%>
data_arr[<%= counter%>][1] = "<%=masTaluk.getTalukCode()%>"
data_arr[<%= counter%>][2] = "<%= masTaluk.getTalukName().trim()%>"
<%
		Iterator itrGridDistrictList=gridTalukList.iterator();
		 while(itrGridDistrictList.hasNext())
            {
             MasDistrict  masDistrict = (MasDistrict)itrGridDistrictList.next(); 
            
			 if(masTaluk.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equalsIgnoreCase("Y")){
			 %>
				data_arr[<%= counter%>][3] = "<%=masDistrict.getDistrictName().trim()+"["+masDistrict.getState().getStateName().trim()+"]"%>"
			<%}else if(masTaluk.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equalsIgnoreCase("N")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--
				<%=masDistrict.getDistrictName().trim()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masTaluk.getLastChgBy()!=null?(masTaluk.getLastChgBy().getId()!=null?masTaluk.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masTaluk.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masTaluk.getLastChgTime() %>"

<% if(masTaluk.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "taluk"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
