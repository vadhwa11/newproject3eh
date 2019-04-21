<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * currency.jsp  
 * Purpose of the JSP -  This is for Currency Details.
 * @author  Vishal
 * Create Date: 14th Jan,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.8  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasCurrency"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchCurrencyList = (ArrayList)map.get("searchCurrencyList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   
		    <h4><span><%=message %></span></h4>
		 <%} %>


<div class="titleBg">
<h2>Currency Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<label>Currency Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label> Currency Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="hidden" name="colCode" value="currency_code">
<input type="hidden" name="colName" value="currency_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Currency Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchCurrency')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchCurrency','checkSearch')"	tabindex=1 />
<%--- Report Button  --%> <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_currency">
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
		if(searchCurrencyList.size()>0)
		 {
			String strForCode = (String)map.get("currencyCode");
			String strForCodeDescription = (String)map.get("currencyName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showCurrencyJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchCurrencyList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showCurrencyJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script></div>

<form name="currency" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasCurrency"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CurrencyName"><input
	type="hidden" name="title" value="Currency"><input
	type="hidden" name="<%=JSP_NAME %>" value="currency"><input
	type="hidden" name="pojoPropertyCode" value="CurrencyCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Currency Code</label>
 <input id="codeId" type="text" name="<%= CODE%>" value="" validate="Currency Code,string,yes" MAXLENGTH="8" / tabindex=1>
 <label><span>*</span> Currency Name </label> 
 <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Currency Name,string,yes" MAXLENGTH="30" / tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCurrency')">
 <script>
	document.currency.<%=CODE%>.focus();
</script>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('currency','generalMaster?method=addCurrency');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('currency','generalMaster?method=editCurrency')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('currency','generalMaster?method=deleteCurrency&flag='+this.value)"
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
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Currency Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Currency Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%


Iterator itr=searchCurrencyList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasCurrency  masCurrency = (MasCurrency)itr.next(); 
             
			

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masCurrency.getId()%>
data_arr[<%= counter%>][1] = "<%=masCurrency.getCurrencyCode()%>"
data_arr[<%= counter%>][2] = "<%= masCurrency.getCurrencyName()%>"

data_arr[<%= counter%>][3] = "<%= masCurrency.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masCurrency.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masCurrency.getLastChgTime() %>"
<% if(masCurrency.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "currency"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
