<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ot.jsp
 * Purpose of the JSP -  This is for All Ot Master.
 * @author  Mansi
 * Create Date: 25 June,2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasOt"%>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/hms.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script>

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
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

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
ArrayList searchOtList = (ArrayList)map.get("searchOtList");

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
<h2>OT Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="clear"></div>
 <label>OT Code:</label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked"  class="radiobutMargin"/>
	 <label>OT Name:</label>
	 <input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin"/>

	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="OT Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'otMaster?method=searchOt')" />
	<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','otMaster?method=searchOt','checkSearch')"
	tabindex=1 />
	<input type="hidden" name="colCode" value="ot_code">
<input type="hidden" name="colName" value="ot_name">
	<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_ot">
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
<div id=></div>
<%
		if(searchOtList.size()>0)
		 {
			String strForCode = (String)map.get("otCode");
			String strForCodeDescription = (String)map.get("otName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>

<a href="otMaster?method=showOtJsp">Show All Records</a> <%
			}
		 }
	 if(searchOtList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="otMaster?method=showOtJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="ot" method="post" action="">

<input type="hidden"	name="<%= POJO_NAME %>" value="MasOt"><input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="OtName"><input
	type="hidden" name="title" value="Ot"><input type="hidden"
	name="<%=JSP_NAME %>" value="ot"><input type="hidden"
	name="pojoPropertyCode" value="OtCode">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> OT Code: </label>
<input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="OT Code,string,yes" class="textbox_date" MAXLENGTH="8" tabindex=1>
	<label><span>*</span>OT Name:</label>
	 <input type="text" name="<%= SEARCH_NAME %>" value="" validate="OT Name,string,yes" class="textbox_date" MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'otMaster?method=addOt')"><script>
				document.ot.<%=CODE%>.focus();
				</script>



<div id="edited"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('ot','otMaster?method=addOt');" accesskey="a"
	tabindex=1 /> <input type="button" name="edit" id="editbutton"
	value="Update" class="button"
	onClick="submitForm('ot','otMaster?method=editOt')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('ot','otMaster?method=deleteOt&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "OT Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "OT Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";


data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOtList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasOt  ot = (MasOt)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= ot.getId()%>
data_arr[<%= counter%>][1] = "<%=ot.getOtCode()%>"
data_arr[<%= counter%>][2] = "<%= ot.getOtName()%>"
data_arr[<%= counter%>][3] = "<%= ot.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(ot.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= ot.getLastChgTime() %>"
<% if(ot.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>

formName = "ot"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>