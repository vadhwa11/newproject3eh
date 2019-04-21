<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemCategory.jsp  
 * Purpose of the JSP -  This is for Item Category.
 * @author  shailesh
 * @author  shailesh
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>


<% String message ="";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasStoreSection> gridSectionList = new ArrayList<MasStoreSection>();
	List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
	if(map.get("gridSectionList")!=null){
		gridSectionList = (ArrayList)map.get("gridSectionList");
	}
	List<MasItemCategory> searchItemCategoryList = new ArrayList<MasItemCategory>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	if(map.get("searchItemCategoryList")!=null){
		searchItemCategoryList = (List)map.get("searchItemCategoryList");
	}
	if(map.get("sectionList")!=null){
		sectionList = (List)map.get("sectionList");
	}
	if(map.get("departmentList1")!=null){
		departmentList1 = (List<MasDepartment>)map.get("departmentList1");
	}
	
	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		    message = (String)map.get("message");
		  
		  }	 	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Item Category Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label> Item Category Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label> Item Category Description</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 

<input	type="hidden" name="colCode" value="item_category_code"/>
<input	type="hidden" name="colName" value="item_category_name"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub Section Code,alphanumeric,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=searchItemCategory')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemCategory','checkSearch')" tabindex=1 />
<%--- Report Button  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>  --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_item_class_new"/>
</form>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
			if(searchItemCategoryList.size()>0 && sectionList.size() > 0)
			 {
				String strForCode = (String)map.get("itemCategoryCode");
				String strForCodeDescription = (String)map.get("itemCategoryName");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%> <h4><a href="pharmacy?method=showItemCategoryJsp">Show All Records</a></h4>
<%
				}
			 }
		
		if(searchItemCategoryList.size()==0 && map.get("search") != null)
		  {
		 %><h4> <a href="pharmacy?method=showItemCategoryJsp">Show All Records</a></h4>

<%
	  }
		%> <script type="text/javascript">		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"],  [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME%>"], [3,"<%= SECTION_ID %>"],[4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
		 statusTd =7;
		</script></div>
<div class="clear"></div>
<form name="itemCategory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasItemCategory" />
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemCategoryName" />
<input	type="hidden" name="<%=JSP_NAME %>" value="itemCategory" />
<input	type="hidden" name="pojoPropertyCode" value="ItemCategoryCode" />
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<%--
<div style="visibility: visible;">
<label><span>*</span> Category</label> 
<select name="<%= SECTION_ID %>"	validate="Section Type,string,no" tabindex=1>
	<option value="0">Select</option>
	<% 					
				for (MasStoreSection  masStoreSection : sectionCodeList){
				%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName().trim()%></option>
	<%}%>
</select></div> --%>

<label class="auto"><span>*</span> Item Category Code</label>
<input id="codeId"	type="text" name="<%= CODE%>" value=""	validate="Item Sub Section Code,string,yes" MAXLENGTH="8" tabindex=1 />

<label class="auto"><span>*</span> Item Category Description</label> 
<input type="text" name="<%= SEARCH_NAME %>"	value="" validate="Item Sub Section Description,string,yes"	onkeypress="return submitenter(this,event,'pharmacy?method=addItemCategory')"	MAXLENGTH="30" tabindex=1 />

<label class="auto"><span>*</span>Section</label> 
<select name="<%=SECTION_ID %>" validate="Section,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
	for(MasStoreSection masStoreSection : sectionList) {
	%>
	<option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('itemCategory','pharmacy?method=addItemCategory');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('itemCategory','pharmacy?method=editItemCategory')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	style="display: none;"	onClick="submitForm('itemCategory','pharmacy?method=deleteItemCategory&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Category Code"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "<%=CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Item Category Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME%>"

data_header[2] = new Array;
data_header[2][0] = "Section"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SECTION_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=STATUS %>";


data_arr = new Array();
	
	<%	
	Iterator itr=searchItemCategoryList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {	            
	             MasItemCategory  masItemCategory = (MasItemCategory)itr.next(); 
	%>	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masItemCategory.getId()%>
	
	
data_arr[<%= counter%>][1] = "<%=masItemCategory.getItemCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masItemCategory.getItemCategoryName()%>"

	<%
	if(masItemCategory.getSection() != null){
	  for(MasStoreSection masStoreSection:gridSectionList){
	     
		 if(masItemCategory.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][3] = "<%=masStoreSection.getSectionName().trim()%>"
		<%}else if(masItemCategory.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName().trim()%>";
			
		<%}
	}%>
	<%}else{
	%>
	data_arr[<%= counter%>][3] = "-"
	<%}%>


data_arr[<%= counter%>][4] = "<%= masItemCategory.getLastChgBy().getId() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemCategory.getLastChgDate()) %>"



data_arr[<%= counter%>][6] = "<%= masItemCategory.getLastChgTime() %>"



<% if(masItemCategory.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "itemCategory"	
nonEditable = ['<%= CODE%>'];	
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>