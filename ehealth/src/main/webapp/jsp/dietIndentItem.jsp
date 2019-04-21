<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietIndentItem.jsp  
 * Purpose of the JSP -  This is for Diet Indent Item Details.
 * @author  Ritu
 * Create Date: 05th Sep,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.7 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDiet"%>
<%@ page import="jkt.hms.masters.business.MasDietIndentItem"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	if(map.get("indentItemList") != null){
		indentItemList = (List<MasDietIndentItem>)map.get("indentItemList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
<div class="titleBg">
<h2>Diet Indent Item Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label> Indent Item Code </label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radiobutMargin" value="1" checked="checked" /> 
<label>Indent Item Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>"	class="radiobutMargin" value="2" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Diet Indent Item,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'canteen?method=searchDietIndentItem')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','canteen?method=searchDietIndentItem','checkSearch')"	tabindex=1 /> 
<%--- Report Button     
<input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>

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
		if(indentItemList.size()>0)
		 {
			String searchField = (String)map.get("searchField");
			if(searchField!= null && searchField!= "")
			{
	%> <h4><a href="canteen?method=showDietIndentItemJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(indentItemList.size()==0 && map.get("search") != null)
	  {
%><h4> <a href="canteen?method=showDietIndentItemJsp">Show All Records</a></h4> <%
    }
%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ITEM_TYPE%>"],[4,"<%= EXTRA_ITEM%>"], [5,"<%=INDENT_GROUP%>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"]];
	 statusTd = 9;
	</script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="dietIndentItem" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasDiet">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DietName">
<input type="hidden" name="title" value="Diet"><input type="hidden" name="<%=JSP_NAME %>" value="diet">
<input type="hidden"	name="pojoPropertyCode" value="DietCode">
<div class="Block">
<label><span>*</span> Indent Item Code </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Diet Indent Code,string,yes" MAXLENGTH="8" / tabindex=1>
<label id=biglabel><span>*</span> Indent Item Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Diet Indent Name,string,yes" MAXLENGTH="30" / tabindex=1 onkeypress="return submitenter(this,event,'canteen?method=addDiet')"><script>
				document.diet.<%=CODE%>.focus();
			</script> <label><span>*</span> Type: </label> <select name="<%=ITEM_TYPE %>"
	validate="Type,string,yes">
	<option value="">Select</option>
	<option value="Dry">Dry</option>
	<option value="Fresh">Fresh</option>
</select>
<div class="clear"></div>
<label><span>*</span> Extra Item </label> 
<select
	name="<%=EXTRA_ITEM %>" validate="Extra Item,string,yes">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select> 
<label><span>*</span> Indent Group </label> 
<select
	name="<%=INDENT_GROUP %>" validate="Indent Group,string,yes">
	<option value="">Select</option>
	<%
					for(char i='A'; i<='Z'; i++){
				%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('dietIndentItem','canteen?method=addDietIndentItem');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('dietIndentItem','canteen?method=editDietIndentItem')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"class="button"	onClick="submitForm('dietIndentItem','canteen?method=deleteDietIndentItem&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" onclick="resetCheck();"class="buttonHighlight" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Indent Item Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Indent Item Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Type"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= ITEM_TYPE %>"

data_header[3] = new Array;
data_header[3][0] = "Extra Item"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= EXTRA_ITEM %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=INDENT_GROUP %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = 0;
data_header[8][3] = "<%= STATUS %>"


data_arr = new Array();

<%
          int  counter=0;
          for(MasDietIndentItem dietIndentItem : indentItemList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dietIndentItem.getId()%>
data_arr[<%= counter%>][1] = "<%=dietIndentItem.getIndentItemCode()%>"
data_arr[<%= counter%>][2] = "<%= dietIndentItem.getIndentItemName()%>"
data_arr[<%= counter%>][3] = "<%= dietIndentItem.getIndentItemType()%>"
<% if(dietIndentItem.getExtraItem().equals("y")){ %>
data_arr[<%= counter%>][4] = "Yes"
<%}else{%>
data_arr[<%= counter%>][4] = "No"
<%}%>
data_arr[<%= counter%>][5] = "<%= dietIndentItem.getIndentGroup() %>"
data_arr[<%= counter%>][6] = "<%= dietIndentItem.getLastChgBy()!=null?(dietIndentItem.getLastChgBy().getId()!=null?dietIndentItem.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(dietIndentItem.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= dietIndentItem.getLastChgTime() %>"
<% if(dietIndentItem.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>

<%
		     counter++;
}
%>
formName = "dietIndentItem"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
