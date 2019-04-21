<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * trade.jsp  
 * Purpose of the JSP -  This is for Trade.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	serviceTypeList = (ArrayList)map.get("serviceTypeList");
	ArrayList searchTradeList = (ArrayList)map.get("searchTradeList");
	ArrayList gridServiceTypeList = (ArrayList)map.get("gridServiceTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }

%>

<div class="titleBg">
<h2>Trade Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label>Trade
Name:</label> <input type="text" id="searchField" name="<%= SEARCH_NAME%>"
	value="" validate="Trade Name,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'personnel?method=searchTrade')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','personnel?method=searchTrade','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> 
	<input type="hidden"	name="<%=SELECTED_RADIO  %>" value="1" /> 
	<input type="hidden" name="colCode" value="trade_name">
<input type="hidden" name="colName" value="">
	<input type="button"	name="Report" value="Generate Report Based on Search" class="button"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"
	accesskey="g" tabindex=1 /> 
	<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_trade"></form>
</div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchTradeList.size()>0 && serviceTypeList.size() > 0)
		 {
			
			String strForCodeDescription = (String)map.get("tradeName");
			if(strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="personnel?method=showTradeJsp">Show All Records</a> <%
			}
		 }
	 if(searchTradeList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="personnel?method=showTradeJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= SERVICE_TYPE_ID %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="trade" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasTrade"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="TradeName"> <input
	type="hidden" name="title" value="Trade"> <input type="hidden"
	name="<%=JSP_NAME %>" value="trade"> <input type="hidden"
	name="pojoPropertyName" value="TradeName">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Trade Name</label> <input
	type="text" name="<%= SEARCH_NAME%>" value=""
	validate="Trade Name,string,yes" class="textbox_size20" MAXLENGTH="30"
	/ tabindex=1> <script>
			document.trade.<%=SEARCH_NAME%>.focus();
		</script> <label><span>*</span> Service Type:</label> <select
	name="<%= SERVICE_TYPE_ID %>" validate="Service Type,string,yes"
	tabindex=1
	onkeypress="return submitenter(this,event,'personnel?method=addTrade')">
	<option value="">Select</option>
	<% 
				for (MasServiceType  masServiceType : serviceTypeList){
			%>
	<option value="<%=masServiceType.getId ()%>"><%=masServiceType.getServiceTypeName()%></option>
	<%}%>
</select>

<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('trade','personnel?method=addTrade');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('trade','personnel?method=editTrade')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('trade','personnel?method=deleteTrade&flag='+this.value)"
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
data_header[0][0] = "Trade Name"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "<%= SEARCH_NAME %>";

data_header[1] = new Array;
data_header[1][0] = "Service Type"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SERVICE_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHALLAN_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchTradeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasTrade  masTrade = (MasTrade)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masTrade.getId()%>
data_arr[<%= counter%>][1] = "<%= masTrade.getTradeName()%>"

<%
		Iterator itrGridServiceTypeList=gridServiceTypeList.iterator();
		 while(itrGridServiceTypeList.hasNext())
            {try{
             MasServiceType  serviceTypeGrid = (MasServiceType)itrGridServiceTypeList.next(); 
			 if(masTrade.getServiceType().getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=serviceTypeGrid.getServiceTypeName()%>"
			<%}else if(masTrade.getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=serviceTypeGrid.getServiceTypeName()%>";
				
			<%}
            }catch(Exception e){}}%>
data_arr[<%= counter%>][3] = "<%= masTrade.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masTrade.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masTrade.getLastChgTime() %>"
<% if(masTrade.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "trade"

nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
