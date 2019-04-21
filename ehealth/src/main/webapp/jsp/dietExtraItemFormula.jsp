<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietExtraItemFormula.jsp  
 * Purpose of the JSP -  This is for Diet Extra Item Formula.
 * @author Ritu
 * Create Date: 8th Sep,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<%@page import="jkt.hms.masters.business.DietExtraItemFormula"%>
<%@page import="jkt.hms.masters.business.MasDietIndentItem"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />

<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
	List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
	List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
	
	if(map.get("extraItemFormulaList") != null){
		extraItemFormulaList = (List<DietExtraItemFormula>)map.get("extraItemFormulaList");
	}
	if(map.get("uomList") != null){
		uomList = (List<MasStoreUnit>)map.get("uomList");
	}
	if(map.get("indentItemList") != null){
		indentItemList = (List<MasDietIndentItem>)map.get("indentItemList");
	}
		
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }


%>
<h2 align="left" class="style1">Diet Extra Item Formula</h2>
<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><font
	class="bodytextB_blue">Item Name:</font> <input type="text"
	id="searchField" name="<%=ITEM_NAME%>" value=""
	validate="Item Name,string,no" MAXLENGTH="8"
	onkeypress="return submitenter(this,event,'diet?method=searchExtraItemFormula')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','diet?method=searchExtraItemFormula','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <%----  <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/> ----%>
<input type="hidden" name="<%=JASPER_FILE_NAME%>"
	value="Mas_diet_combination">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>

<% try{
		if(extraItemFormulaList.size()>0 )
		 {
			String itemName = (String)map.get("itemName");
			if(itemName!= null && itemName!= "")
			{
	%> <br />
<a href="diet?method=showExtraItemFormulaJsp">Show All Records</a> <%
			}
		 }
		 if(extraItemFormulaList.size()==0 && map.get("search") != null)
		  {
	%> <br />
<a href="diet?method=showExtraItemFormulaJsp">Show All Records</a> <%
      }}
	      catch(Exception ex){
	    	  ex.printStackTrace();
	      }
%> <script type="text/javascript">
	
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= ITEM_ID%>"], [2,"<%= EXTRA_SCALE %>"], [3,"<%= UNIT_ID%>"],[4,"<%= VALID_FROM_DATE %>"], [5,"<%= CHANGED_BY %>"],[6,"<%= CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>
<br />

<form name="extraItemFormula" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><br>
<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Item Name:</label> <select id="menuItemId"
	name="<%= ITEM_ID %>" validate="Item Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasDietIndentItem indentItem : indentItemList){
				%>

	<option value="<%=indentItem.getId ()%>"><%=indentItem.getIndentItemName()%></option>

	<%}%>
</select> <label class="bodytextB_blue"><font id="error">*</font>Extra
Scale</label> <input type="text" name="<%= EXTRA_SCALE%>" value=""
	validate="Quantity,num,yes" class="textbox_size20" MAXLENGTH="8"
	tabindex=1 /> <br />

<label class="bodytextB_blue"><font id="error">*</font>UOM:</label> <select
	name="<%= UNIT_ID %>" validate="UOM,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'canteen?method=addDietCombination')">
	<option value="">Select</option>
	<% 
			for (MasStoreUnit  storeUnit : uomList){
			%>
	<option value="<%=storeUnit.getId ()%>"><%=storeUnit.getUnitName()%></option>

	<%}%>
</select> <label> <font id="error">*</font>Validity Start Date:</label> <input
	type="text" id="dobId" name="<%=VALID_FROM_DATE %>" value=""
	class="textbox_date" readonly="readonly"
	validate="Validity Start Date ,date,yes" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.extraItemFormula.<%=VALID_FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <br />
<br />

<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=currentDate%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('extraItemFormula','diet?method=addExtraItemFormula');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('extraItemFormula','diet?method=editExtraItemFormula')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('extraItemFormula','diet?method=deleteExtraItemFormula&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <br />
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Name"
data_header[0][1] = "data";
data_header[0][2] = "30%";
data_header[0][3] = "<%= ITEM_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Extra Scale"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%=EXTRA_SCALE %>";

data_header[2] = new Array;
data_header[2][0] = "UOM"
data_header[2][1] = "data";
data_header[2][2] = "30%";
data_header[2][3] = "<%=UNIT_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Validity Start Date"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=VALID_FROM_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%=CHANGED_BY %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%=CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "40%";
data_header[7][3] = "<%=STATUS %>"

data_arr = new Array();

<%

          int  counter=0;
         for(DietExtraItemFormula extraItemFormula : extraItemFormulaList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= extraItemFormula.getId()%>

<% 
	if(extraItemFormula.getIndentItem() != null){
%>
<%
		for(MasDietIndentItem obj : indentItemList){
			 if(extraItemFormula.getIndentItem().getId().equals(obj.getId()) && obj.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][1] = "<%=obj.getIndentItemName()%>"
			<%}else if(extraItemFormula.getId().equals(obj.getId()) && obj.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=obj.getIndentItemName()%>";
			<%}
            }
		}
%>
data_arr[<%= counter%>][2] = "<%= extraItemFormula.getExtraScale()%>"
<% 
	if(extraItemFormula.getUnit() != null){
%>
<%
		for(MasStoreUnit storeUnit : uomList){
            
			 if(extraItemFormula.getUnit().getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=storeUnit.getUnitName()%>"
			<%}else if(extraItemFormula.getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=storeUnit.getUnitName()%>";
			<%}
         }
		}
%>

data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(extraItemFormula.getValidityStartDate()) %>"
data_arr[<%= counter%>][5] = "<%= extraItemFormula.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(extraItemFormula.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= extraItemFormula.getLastChgTime() %>"

<% if(extraItemFormula.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "extraItemFormula"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>