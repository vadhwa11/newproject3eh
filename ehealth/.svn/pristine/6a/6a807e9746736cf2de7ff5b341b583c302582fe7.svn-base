<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_instructorMaster.jsp  
 * Purpose of the JSP -  This is for Instructor details 
 * @author  Rajendra
 * Create Date: 23rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String sdate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
	List<HrMasFinancialYear> searchFinancialYearMasterList = new ArrayList<HrMasFinancialYear>();
//	if(map.get("hrMasFinancialYearList")!=null)
//	{
//		hrMasFinancialYearList =(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
//	}
	if(map.get("searchFinancialYearMasterList")!=null)
	{
		searchFinancialYearMasterList =(List<HrMasFinancialYear>)map.get("searchFinancialYearMasterList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>
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
<div class="titleBg">
<h2>Financial year</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Year</label> <input
	type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked"
	class="radiobutMargin" /> <label>Financial Year</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<label>&nbsp;</label> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="Year,string,no"
	MAXLENGTH="9" tabindex=1 /> <input type="button" name="search"
	value="Search" class="button"
	onclick="submitForm('search','incomeTaxMaster?method=searchFinancialYearMaster','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
 	if (searchFinancialYearMasterList.size() > 0) {
 			
 			String financialYr = (String) map.get("financialYear");
 			String yearDesc = (String)map.get("year");
 			if (financialYr != null && financialYr != ""|| yearDesc != "" && yearDesc != null) 
 			{
 	%>
<h4><a href="incomeTaxMaster?method=showFinancialYearJsp">Show
All Records</a></h4>
<%
			}
		}
		if (searchFinancialYearMasterList.size() == 0
				&& map.get("search") != null) {
	%>
<h4><a href="incomeTaxMaster?method=showFinancialYearJsp">Show
All Records</a></h4>

<%
    	}
    %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE %>"],[2,"<%=FROM_DATE %>"],[3,"<%=TO_DATE %>"],[4,"<%=SEARCH_NAME %>"], [5,"<%= CHANGED_BY%>"],[6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
	</div>
<div class="clear"></div>
<div class="Block">
<form name="financialMaster" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasFinancialYear" /> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FinancialYear" />
<input type="hidden" name="title" value="Financial year Master" /> <input
	type="hidden" name="<%=JSP_NAME %>" value="hr_masFinancialYearJsp" />
<input type="hidden" name="pojoPropertyCode" value="YearDescription" />


<div class="clear"></div>

<label><span>*</span> From Date</label> <input name="<%=FROM_DATE%>"
	type="text" readonly validate='From Date,date,yes' value=""
	class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calFromDate"
	onclick="javascript:setdate('',document.financialMaster.<%=FROM_DATE%>,'event')" />
<label><span>*</span> To Date</label> <input type="text"
	name="<%=TO_DATE%>" readonly validate='To Date,date,yes' value=""
	class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calToDate"
	onclick="javascript:setdate('',document.financialMaster.<%=TO_DATE%>,'event')" />
<script>
				document.financialMaster.<%=FROM_DATE%>.focus();
</script>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('financialMaster','incomeTaxMaster?method=addFinancialYearMaster');"
	accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('financialMaster','incomeTaxMaster?method=editFinancialYearMaster')"
	accesskey="u" tabindex=1 />


<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('financialMaster','incomeTaxMaster?method=deleteFinancialYearMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</form>
</div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
	<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=sdate%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Year"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= CODE %>"

data_header[1] = new Array;
data_header[1][0] = "From Date"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= FROM_DATE%>";

data_header[2] = new Array;
data_header[2][0] = "To Date"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= TO_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Financial Year"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= SEARCH_NAME%>";

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
data_header[6][2] = "";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "";
data_header[7][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchFinancialYearMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasFinancialYear  hrMasFinancialYear = (HrMasFinancialYear)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasFinancialYear.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getYearDescription()%>"

 
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasFinancialYear.getYearFromDate())%>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasFinancialYear.getYearToDate())%>"
data_arr[<%= counter%>][4] = "<%= hrMasFinancialYear.getFinancialYear()%>"
data_arr[<%= counter%>][5] = "<%= hrMasFinancialYear.getLastChgBy()!=null?(hrMasFinancialYear.getLastChgBy().getId()!=null?hrMasFinancialYear.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasFinancialYear.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= hrMasFinancialYear.getLastChgTime() %>"
<% if(hrMasFinancialYear.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%
		     counter++;
}
%>
 
formName = "financialMaster"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
