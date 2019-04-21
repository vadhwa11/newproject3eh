<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemConversion.jsp  
 * Purpose of the JSP -  This is for Item Conversion.
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<MasStoreItemConversion> searchItemConversionList = (ArrayList) map.get("searchItemConversionList");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		if(map.get("message") != null){
			 String  message = (String)map.get("message");
			   %>
			   <h4><span><%=message %></span></h4>
			 <%} 

	}
	List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
	itemPurchaseUnitList = (ArrayList)map.get("itemPurchaseUnitList");
	
	List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
	itemIntermediateUnitList = (ArrayList)map.get("itemIntermediateUnitList");
	
	List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();
	itemIssueUnitList = (ArrayList)map.get("itemIssueUnitList");
%>
<div class="titleBg">
<h2>Accounting Unit Conversion Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="auto">A/U Name</label>
<input type="hidden"	name="<%=SELECTED_RADIO  %>" value="2" checked="checked" class="radioCheckCol1"/> 
<input	type="hidden" name="colName" value="item_unit_name"/>
<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value="" validate="A/U Name,strin,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'pharmacy?method=searchItemConversion')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemConversion','checkSearch')" tabindex=1 /> 
<%--- Report Button     
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_item_conversion">
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
	if (searchItemConversionList.size() > 0) {
		String strForCodeDescription = (String) map	.get("itemUnitName");
		if (strForCodeDescription != null && strForCodeDescription != "") {
%> <h4><a href="pharmacy?method=showItemConversionJsp">Show All Records</a></h4>
<%
 	}
 	}
 	
if(searchItemConversionList.size()==0 && map.get("search") != null)
{
%><h4> <a href="pharmacy?method=showItemConversionJsp">Show All Records</a></h4>
<%
}
%> <script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= PURCHASE_UNIT_ID %>"], [3,"<%= CONVERSION_FACTOR %>"], [4,"<%= INTERMEDIATE_UNIT_ID %>"], [5,"<%= CONVERSION_FACTOR2 %>"], [6,"<%= ISSUE_UNIT_ID %>"],  [7,"<%= CHANGED_BY %>"],[8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%= STATUS %>"] ];
  statusTd = 10;
 </script></div>
<div class="clear"></div>
<form name="itemConversion" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasStoreItemConversion">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemUnitName">
<input type="hidden" name="title" value="itemConversion">
<input type="hidden" name="<%=JSP_NAME %>" value="itemConversion">
<div class="paddingTop5"></div>
<div class="Block">
<label><span>*</span> A/U Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="A/U Name,alphanumeric,yes" MAXLENGTH="30"  tabindex=1>
<script>
document.itemConversion.<%=SEARCH_NAME%>.focus();
   </script> 
<label><span>*</span> Purchase Unit</label> 
<select name="<%=PURCHASE_UNIT_ID %>" validate="Purchase Unit,alphanumeric,yes" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(itemPurchaseUnitList != null){ 
          			for (Iterator iter = itemPurchaseUnitList.iterator(); iter.hasNext();) 
					{
          				MasStoreUnit masStoreUnit = (MasStoreUnit)iter.next();
          %>
	<option value="<%=masStoreUnit.getId() %>"><%=masStoreUnit.getUnitName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label><span>*</span> Conversion Factor1</label> 
<input type="text"	name="<%= CONVERSION_FACTOR %>" value=""	validate="Conversion Factor1,int,yes" MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>

<label><span>*</span> Intermediate Unit </label> 
<select	name="<%=INTERMEDIATE_UNIT_ID %>"	validate="Intermediate Unit,alphanumeric,yes" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(itemIntermediateUnitList != null){ 
	        			for (Iterator iter = itemIntermediateUnitList.iterator(); iter.hasNext();) 
	        			{
							MasStoreUnit masStoreUnit1 = (MasStoreUnit)iter.next();
          %>
	<option value="<%=masStoreUnit1.getId() %>"><%=masStoreUnit1.getUnitName() %></option>
	<%		
         			}
         		 } 
         %>
</select> 

<label><span>*</span> Conversion Factor 2</label> 
<input type="text"	name="<%= CONVERSION_FACTOR2 %>" value=""	validate="Conversion Factor 2,int,yes" MAXLENGTH="30" tabindex=1 />
 
<label><span>*</span>Issue Unit </label> 
<select name="<%=ISSUE_UNIT_ID %>"	validate="Issue Unit,alphanumeric,yes" tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=addItemConversion')">
	<option value="0">Select</option>
	<%
          		if(itemIssueUnitList != null){ 
          			for (Iterator iter = itemIssueUnitList.iterator(); iter.hasNext();) 
          			{         				
							MasStoreUnit masStoreUnit2 = (MasStoreUnit)iter.next();
          %>
	<option value="<%=masStoreUnit2.getId()%>"><%=masStoreUnit2.getUnitName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('itemConversion','pharmacy?method=addItemConversion');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('itemConversion','pharmacy?method=editItemConversion')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('itemConversion','pharmacy?method=deleteItemConversion&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> 
<label class="value"><%=date%></label> 

<label>Changed Time</label> 
<label class="value"><%=time%></label> 

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "A/U Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Purchase Unit"
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%= PURCHASE_UNIT_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CONVERSION_FACTOR %>"

data_header[3] = new Array;
data_header[3][0] = "Intermediate Unit"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%=INTERMEDIATE_UNIT_ID %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CONVERSION_FACTOR2 %>"

data_header[5] = new Array;
data_header[5][0] = "Issue Unit"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=ISSUE_UNIT_ID %>"

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

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchItemConversionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStoreItemConversion  masStoreItemConversion = (MasStoreItemConversion)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreItemConversion.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreItemConversion.getItemUnitName()%>"
<% if(masStoreItemConversion.getPurchaseUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit : itemPurchaseUnitList)
		{
            if(masStoreItemConversion.getPurchaseUnit() != null){
			if(masStoreItemConversion.getPurchaseUnit().getId().equals(masStoreUnit.getId()) && masStoreUnit.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][2] = "<%=masStoreUnit.getUnitName()%>"
			<%}else if(masStoreItemConversion.getPurchaseUnit().getId().equals(masStoreUnit.getId()) && masStoreUnit.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit.getUnitName()%>";
				
			<%}
            }
		}
}%>
data_arr[<%= counter%>][3] = "<%=masStoreItemConversion.getConversionFactor1()%>"
<% if(masStoreItemConversion.getIntermediateUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit1 : itemIntermediateUnitList)
		{
            if(masStoreItemConversion.getIntermediateUnit() != null){
			if(masStoreItemConversion.getIntermediateUnit().getId().equals(masStoreUnit1.getId()) && masStoreUnit1.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][4] = "<%=masStoreUnit1.getUnitName()%>"
			<%}else if(masStoreItemConversion.getIntermediateUnit().getId().equals(masStoreUnit1.getId()) && masStoreUnit1.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit1.getUnitName()%>";
				
			<%}
            }
		}
}%>

data_arr[<%= counter%>][5] = "<%=masStoreItemConversion.getConversionFactor2()%>"

<% if(masStoreItemConversion.getIssueUnit() != null){%>
<%
		for(MasStoreUnit masStoreUnit2 : itemIssueUnitList)
		{
            if(masStoreItemConversion.getIssueUnit() != null){
			if(masStoreItemConversion.getIssueUnit().getId().equals(masStoreUnit2.getId()) && masStoreUnit2.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][6] = "<%=masStoreUnit2.getUnitName()%>"
			<%}else if(masStoreItemConversion.getIssueUnit().getId().equals(masStoreUnit2.getId()) && masStoreUnit2.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masStoreUnit2.getUnitName()%>";
				
			<%}
            }
		}
}%>

data_arr[<%= counter%>][7] = "<%= masStoreItemConversion.getLastChgBy()!=null?(masStoreItemConversion.getLastChgBy().getId()!=null?masStoreItemConversion.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItemConversion.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masStoreItemConversion.getLastChgTime() %>"
<% if(masStoreItemConversion.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
       counter++;
}
%>
 formName = "itemConversion"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>