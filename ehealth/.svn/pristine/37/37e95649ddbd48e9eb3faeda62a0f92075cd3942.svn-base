<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * postCode.jsp  
 * Purpose of the JSP -  This is for Post Code.
 * @author  Mansi
 * @author  Vishal
 * Create Date: 7th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
		
			
		List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		
		String userName = "";
		if(request.getAttribute("map") != null){
		 map = (Map) request.getAttribute("map");
		}
		if(map.get("masPostCodeList") != null){
		 masPostCodeList = (ArrayList)map.get("masPostCodeList");
		}
		/*  */
		if(map.get("masDistrictList") != null){
			masDistrictList = (List)map.get("masDistrictList");
	}
		if(map.get("gridDistrictList") !=null){
			gridDistrictList = (List)map.get("gridDistrictList");
		}
		
		
		String date ="";
		String time ="";
		try{
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");  
		 time = (String)utilMap.get("currentTime");
		}catch(Exception ex){
	     }
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
			   <h4><span><%=message %></span></h4>
			 <%} %> 


<div class="titleBg">
<h2>Post Office Master</h2>
</div>
<div class="Block">
<div class="PostCode">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Post Office ID </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Post Office Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="hidden" name="colCode" value="post_code">
<input type="hidden" name="colName" value="post_code_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="PostCode,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchPostCode')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchPostCode','checkSearch')"	tabindex=1 /> 
<%--- Report Button   --%> 
<input type="button"	name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_post_code">
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
  if(masPostCodeList.size() > 0)
   {
   String strForCode = (String)map.get("postCode");
   String strForCodeDescription = (String)map.get("postCodeName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %><h4> <a href="generalMaster?method=showPostCodeJsp">Show All Records
</a></h4> <%
   }
   } 
 if(map.get("search") != null)
 {
%> <h4><a href="generalMaster?method=showPostCodeJsp">Show All Records</a></h4> <%
 }
%> <script type="text/javascript">

 formFields = [
     [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=DISTRICT_ID %>"], [4,"<%= PIN_CODE%>"], [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
  statusTd = 8;
  </script></div>

<form name="postCode" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasPostCode"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PostCodeName">
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="PostCode">
<input type="hidden" name="title" value=""MasPostCode""> 
<input type="hidden" name="<%=JSP_NAME %>" value="<%=POSTCODE_JSP%>">
<input type="hidden" name="pojoPropertyCode" value="MasPostCode">
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="Block">
<label><span>*</span> Post Office Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="PostCode,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Post Office Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="PostCode Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 /> 
<script>
    document.postCode.<%=CODE%>.focus();
   </script>
 
<label><span>*</span> District </label> 
<select name="<%=DISTRICT_ID %>" id="<%=DISTRICT_ID%>" validate="District,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasDistrict  masDistrict : masDistrictList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}%>
</select>

<div class="clear"></div>
<label> PinCode </label>
 <input type="text" name="<%= PIN_CODE %>"	value="" validate="PinCode,string,no" class="textbox_size20"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('postCode','generalMaster?method=addPostCode');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('postCode','generalMaster?method=editPostCode')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('postCode','generalMaster?method=deletePostCode&flag='+this.value)"	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
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

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Post Office Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Post Office Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = "District"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID%>";

data_header[3] = new Array;
data_header[3][0] = "PinCode"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=PIN_CODE %>";


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";


data_arr = new Array();

<%
Iterator itr=masPostCodeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasPostCode  masPostCode = (MasPostCode)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPostCode.getId()%>
data_arr[<%= counter%>][1] = "<%=masPostCode.getPostCode()%>"
data_arr[<%= counter%>][2] = "<%= masPostCode.getPostCodeName()%>"

 <%
  Iterator itrGridDistrictList=gridDistrictList.iterator();
   while(itrGridDistrictList.hasNext())
            {
             MasDistrict  masDistrict = (MasDistrict)itrGridDistrictList.next(); 
    if(masPostCode.getDistrictId()!=null && masPostCode.getDistrictId().getId()==masDistrict.getId() && masDistrict.getStatus().equalsIgnoreCase("Y")){
    %>
    data_arr[<%= counter%>][3] = "<%=masDistrict.getDistrictName()%>"
   <%}else if(masPostCode.getDistrictId()!=null && masPostCode.getDistrictId().getId()==masDistrict.getId() && masDistrict.getStatus().equalsIgnoreCase("N")){%>
    data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDistrict.getDistrictName()%>";
    
   <%}
}%> 


<%
if(masPostCode.getPinCode()!=null){
	%>
	data_arr[<%= counter%>][4] = "<%= masPostCode.getPinCode() %>"
	<%
}else{
	%>
	data_arr[<%= counter%>][4] = ""
	<%
}
%>
data_arr[<%= counter%>][5] = "<%= masPostCode.getLastChgBy()!=null?(masPostCode.getLastChgBy().getId()!=null?masPostCode.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masPostCode.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masPostCode.getLastChgTime() %>"

<% if(masPostCode.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "postCode"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>