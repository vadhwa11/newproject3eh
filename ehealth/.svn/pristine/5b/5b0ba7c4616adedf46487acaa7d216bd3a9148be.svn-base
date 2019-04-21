<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * madularityMaster.jsp
 * Purpose of the JSP -  This is for All Modality Master Master.
 * @author  Ramdular
 * Create Date: 26 OCT 2010
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.masters.business.MasModularity"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

List<MasModularity> searchOpdModalityList = new ArrayList<MasModularity>();
	searchOpdModalityList = (List<MasModularity>)map.get("searchOpdModalityList");

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
<h2>Opd Modality Master</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Modality Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" />
 <label>Modality Name </label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Modality Code ,string,no" MAXLENGTH="9" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdModality')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchOpdModality','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	

</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%
		if(searchOpdModalityList.size()>0)
		 {
			String strForCode = (String)map.get("modalityCode");
			String strForCodeDescription = (String)map.get("modalityName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="opdMaster?method=addModularityModule">Show All Records</a></h4> <%
			}
		 }
	 if(searchOpdModalityList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="opdMaster?method=addModularityModule">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= HOLIDAY_DATE %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="opdModality" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasModularity" />
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ModularityName" />
<input	type="hidden" name="title" value="OpdModality" />
<input	type="hidden" name="pojoPropertyCode" value="Code" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><script>
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
<label><span>*</span> Modality Code </label>
<input id="codeId"	type="text" name="<%= CODE%>" value=""	validate="Modality Code,string,yes" class="textbox_date" MAXLENGTH="9"	/ tabindex=1 />
<label><span>*</span> Modality Name</label>
<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Modality Name,string,yes" class="textbox_date" MAXLENGTH="30"	/ tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=addOpdModality')" />
<script>
			document.opdModality.<%=CODE%>.focus();
		</script>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('opdModality','opdMaster?method=addOpdModality');"	accesskey="a" tabindex=1 />
 <input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('opdModality','opdMaster?method=editOpdModality')"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('opdModality','opdMaster?method=deleteOpdModality&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
 <label	class="value"><%=time%></label>
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
 <input type="hidden"name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Modality Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Modality Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Modality Date"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%= HOLIDAY_DATE %>";



data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdModalityList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasModularity  opdModality = (MasModularity)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdModality.getId()%>
data_arr[<%= counter%>][1] = "<%=opdModality.getCode()%>"
data_arr[<%= counter%>][2] = "<%= opdModality.getModularityName()%>"


data_arr[<%= counter%>][3] = ""
data_arr[<%= counter%>][4] = ""
data_arr[<%= counter%>][5] = ""
data_arr[<%= counter%>][6] = "<%= opdModality.getLastChgTime() %>"
<% if(opdModality.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>

//formName = "opdHoliday"
formName = "opdModality"


nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
