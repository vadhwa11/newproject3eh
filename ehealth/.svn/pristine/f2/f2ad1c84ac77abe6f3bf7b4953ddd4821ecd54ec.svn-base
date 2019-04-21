<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * salesTypeJsp.jsp  
 * Purpose of the JSP -  This is for Sales Type.
 * @author  Vishal Jain 
 * Create Date: 14th Jan,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSalesTaxType"%>

<script language="javascript">


function validatePercentage () {
var Percent= document.getElementById("saleTax").value
  if (Percent != "") {
    
  if ((Percent.indexOf(".") == -1) && (Percent.length >= 3)) {
    alert("Invalid Percentage");
    return false;
  }
  if ((Percent.indexOf(".")) == 4 || (Percent.indexOf(".")) == 3 || (Percent.indexOf(".")) == 0) {
    alert("Invalid Percentage");
    return false;
  }
  if (isNaN(Percent)==true) {
    alert("Enter Numeric values");
    return false;
  }	
  }
  return true;
}
</script>
<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		ArrayList searchSalesTaxTypeList = (ArrayList)map.get("searchSalesTaxTypeList");
			
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message ="";
		if(map.get("message") != null){
			message= (String)map.get("message");
			
		}
%>
<H4><span><%=message %></span></H4>
<div class="titleBg">
<h2>Sales Tax Type</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>SalesTax Type Code </label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>SalesTax Type Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
 
<input type="hidden" name="colCode" value="sales_tax_type_code">
<input type="hidden" name="colName" value="sales_tax_type_name">
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value=""	validate="Sales Tax Type Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'billingMaster?method=searchSalesTaxType')" />
<input type="submit" name="search" value="Search" class="button"	onclick="submitForm('search','billingMaster?method=searchSalesTaxType','checkSearch')"	tabindex=1 /> <%--- Report Button     <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_sales_tax_type"> 

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
  if(searchSalesTaxTypeList.size()>0)
   {
   String strForCode = (String)map.get("salesTaxTypeCode");
   String strForName = (String)map.get("salesTaxTypeName");
   if(strForCode!= null && strForCode!= "" || strForName!= null && strForName!= "")
   {
 %>
<div class="clear"></div>
<h4><a href="billingMaster?method=showSalesTaxTypeJsp"> Show All Records </a></h4>
<%
			}
		 }
	if(searchSalesTaxTypeList.size()==0 && map.get("search") != null)
	  {
	 %> 
<h4><a href="billingMaster?method=showSalesTaxTypeJsp">Show AllRecords</a></h4> <%
  }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"],[7,"<%=SALES_TAX%>"] ];
	 statusTd = 7;
</script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="salesTaxType" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input	type="hidden" name="<%= POJO_NAME %>" value="MasSalesTaxType">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="SalesTaxTypeName"> <input type="hidden"	name="<%=JSP_NAME %>" value="salesTaxTypeJsp"> 
<input	type="hidden" name="pojoPropertyCode" value="SalesTaxTypeCode">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> SalesTax Type Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="SalesTaxType,String,yes" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> SalesTax Type Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="SalesTaxType Name,String,yes" MAXLENGTH="30" / tabindex=1>
<script>
document.salesTaxType.<%=CODE%>.focus();
</script>
<label>Sales tax in %</label> 
<input type="text" name="<%= SALES_TAX%>" id="saleTax" value="" tabindex=1 />
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="if(validatePercentage()){submitForm('salesTaxType','billingMaster?method=addSalesTaxType');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="if(validatePercentage()){submitForm('salesTaxType','billingMaster?method=editSalesTaxType');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('salesTaxType','billingMaster?method=deleteSalesTaxType&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
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
data_header[0][0] = "SalesTax Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "SalesTax Type Name"
data_header[1][1] = "data";
data_header[1][2] = "50%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%=STATUS %>";


data_header[6] = new Array;
data_header[6][0] = "Sale Tax"
data_header[6][1] = "data";
data_header[6][2] = "25%";
data_header[6][3] = "<%=SALES_TAX %>";

data_arr = new Array();

<%

Iterator itr=searchSalesTaxTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSalesTaxType  masSalesTaxType = (MasSalesTaxType)itr.next(); %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSalesTaxType.getId()%>
data_arr[<%= counter%>][1] = "<%=masSalesTaxType.getSalesTaxTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masSalesTaxType.getSalesTaxTypeName()%>"
data_arr[<%= counter%>][3] = "<%= masSalesTaxType.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masSalesTaxType.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masSalesTaxType.getLastChgTime() %>"
<% if(masSalesTaxType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<% if(masSalesTaxType.getSaleTax()!=null){ %>
data_arr[<%= counter%>][7] =  "<%= masSalesTaxType.getSaleTax() %>"
<%}else{%>
data_arr[<%= counter%>][7] = "0"
<%}%>
<%
       counter++;
}
%>
formName = "salesTaxType"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
