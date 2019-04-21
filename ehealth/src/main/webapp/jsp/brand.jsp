<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map<String,Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasStoreBrand> searchBrandList = null;
	if (map.get("searchBrandList")!=null)
	{
		searchBrandList = (List<MasStoreBrand>)map.get("searchBrandList");
	}
	//List<MasStoreItemGeneric> genericList = new ArrayList<MasStoreItemGeneric>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	//genericList = (ArrayList)map.get("genericList");
	if(map.get("itemList") != null){
		itemList = (List<MasStoreItem>)map.get("itemList");
	}
	if(map.get("manufacturerList") != null){
		manufacturerList = (List<MasManufacturer>)map.get("manufacturerList");
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
<h2>Brand Master</h2>
</div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label> Brand Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" validate="Administrative Sex Code,int,no" />
<label>Brand Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" validate="Administrative Sex Code,int,no" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Brand Code,string,no" MAXLENGTH="25" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_brand" validate="Administrative Sex Code,string,no" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchBrand','checkSearch')" tabindex=1 /> <%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />

</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
  if(searchBrandList.size()>0)
   {
   String strForCode = (String)map.get("brandCode");
   String strForCodeDescription = (String)map.get("brandName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %><h4> <a href="personnel?method=showBrandJsp">Show All Records</a></h4> <%
   }
   }
 if(searchBrandList.size()==0 && map.get("search") != null)
 {
%><h4> <a href="personnel?method=showBrandJsp">Show All Records</a></h4> <%
 }
%> <script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= MANUFACTURER_ID %>"],[4,"<%= NAME_ITEM %>"], [5,"<%= CHANGED_BY %>"],[6,"<%= CHANGED_DATE %>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"] ];
  statusTd = 8;
 </script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="brand" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<input type="hidden" name="<%= POJO_NAME %>" value="MasStoreBrand">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BrandName">
<input type="hidden" name="brand" value="Brand"><input type="hidden" name="<%=JSP_NAME %>" value="brand">
<input type="hidden"	name="pojoPropertyCode" value="BrandCode">
<label><span>*</span> Brand Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Brand Code,string,yes" class="textbox_size20" MAXLENGTH="8"	/ tabindex=1>
<label><span>*</span> Brand Name</label>
<input	type="text" name="<%= SEARCH_NAME %>" value="" validate="Brand Name,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=1>

<script>
    document.brand.<%=CODE%>.focus();
   </script>
<label><span>*</span> Manufacturer Name</label>
<select name="<%=MANUFACTURER_ID %>" validate="Manufacturer Name,string,yes" tabindex=1>
<option value="0">Select</option>
	<%
          		if(manufacturerList != null){
          			for (Iterator iter = manufacturerList.iterator(); iter.hasNext();) {
          				MasManufacturer masManufacturer = (MasManufacturer) iter.next();
          %>
	<option value="<%=masManufacturer.getId() %>"><%=masManufacturer.getManufacturerName() %></option>
	<%
         			}
         		 }
         %>
</select>
<div class="clear"></div>
<label>Nomenclature</label>
<input type="text" value="" id="nameItem"	name="<%=NAME_ITEM%>" class="large" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=NAME_ITEM%>','ac2update','stores?method=getItemListForLoanoutByAutocomplete',{parameters:'requiredField=<%=NAME_ITEM%>'});
		</script>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('brand','personnel?method=addBrand');" accesskey="a" tabindex=1 />
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('brand','personnel?method=editBrand')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('brand','personnel?method=deleteBrand')" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> <input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Brand Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Brand Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Manufacturer Name"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=MANUFACTURER_ID %>"

data_header[3] = new Array;
data_header[3][0] = "PVMS/NIV Nomenclature"
data_header[3][1] = "hide";
data_header[3][2] = "100%";
data_header[3][3] = "<%=NAME_ITEM %>"

data_header[4] = new Array;
data_header[4][0] = "Admin"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchBrandList.iterator();
          int  counter = 0;
          while(itr.hasNext())
           {
             MasStoreBrand  masStoreBrand = (MasStoreBrand)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreBrand.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreBrand.getBrandCode()%>"
data_arr[<%= counter%>][2] = "<%= masStoreBrand.getBrandName()%>"
<%
	Iterator itrManufacturerList=manufacturerList.iterator();
	try
	{
	 while(itrManufacturerList.hasNext())
           {
            MasManufacturer  masManufacturerGrid = (MasManufacturer)itrManufacturerList.next();
		 if(masStoreBrand.getManufacturer().getId().equals(masManufacturerGrid.getId()) && masManufacturerGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masManufacturerGrid.getManufacturerName()%>"
		<%}else if(masStoreBrand.getItem().getId().equals(masManufacturerGrid.getId()) && masManufacturerGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masManufacturerGrid.getManufacturerName()%>";
		<%}
}}catch(NullPointerException e){ %>
	data_arr[<%= counter%>][3]="";
	<%
	e.printStackTrace();
}

%>

   data_arr[<%= counter%>][4] = "";
data_arr[<%= counter%>][5] = "<%= masStoreBrand.getLastChgBy()!=null?(masStoreBrand.getLastChgBy().getId()!=null?masStoreBrand.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreBrand.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masStoreBrand.getLastChgTime() %>"
<% if(masStoreBrand.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
       counter++;
}
%>

formName = "brand"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>