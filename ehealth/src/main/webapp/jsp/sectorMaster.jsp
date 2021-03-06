<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * majorHead.jsp
 * Purpose of the JSP -  This is for Budget Major Head.
 * @author  Ujjwal
 * Create Date: 21st Jan,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.BudMajorHead" %>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Sector"%>


<script type="text/javascript" src="../jsp/js/calendar.js"></script>
<%
  Map map = new HashMap();
  if(request.getAttribute("map") != null){
    map = (Map) request.getAttribute("map");
  }
  Map<String, Object>utilmap= new HashMap<String,Object>();
  utilmap=(Map)HMSUtil.getCurrentDateAndTime();
  String date = (String)utilmap.get("currentDate");
  String time = (String)utilmap.get("currentTime");
  List<Sector>searchCountryList=new ArrayList();
  searchCountryList=(List<Sector>)map.get("searchCountryList");
  String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
 <h4><span><%=message %></span></h4>
<%} %>
<script>
<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<div class="clear"></div>
<div class="titleBg">
<h2>Sector Master</h2>
</div>
<div class="Block">
<form name="search" method="post" >
<input type="radio" name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Sector Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2"  class="radioCheck" />
<label>Sector Name</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'account?method=searchmajorhead')"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','budget?method=searchmajorhead')" accesskey="s" tabindex="1" />
 <%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','budget?method=generateReportForBudgetMaster');" accesskey="f" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="bud_major_head">
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
if(searchCountryList!= null){

		if(searchCountryList.size()>0 )
		 {
			String strForCode = (String)map.get("MajorHeadCode");
			String strForCodeDescription = (String)map.get("MajorHeadName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%><h4> <a href="budget?method=showBudgetMajorHead">Show All Records</a></h4> <%
			}
		 }
	 if(searchCountryList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="budget?method=showBudgetMajorHead">Show All Records</a></h4>

<%
     }
	%>
<%} %>
<script type="text/javascript">
formFields =
	[[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= SEQUENCE_NO%>"],[4,"<%= STATUS%>"]  ];

statusTd =4;
</script></div>
<form name="majorhead" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>" value="BudMajorHead"/>
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MajorHeadName"/>
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="MajorHeadCode"/>
<input type="hidden" name="title" value="financialyear"/>
<input type="hidden" name="<%=JSP_NAME %>" value="majorHead"/>
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span>	Sector Code</label>
<input type="text" id="fId" name="<%= CODE%>" value="" validate="Major Code,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=1>
<label><span>*</span>	Sector Name</label>
<input type="text" id="fname"  name="<%= SEARCH_NAME %>" value="" validate="Major Head,string,yes" class="textbox_size20" MAXLENGTH="50" / tabindex=1>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('majorhead','budget?method=addMajorHead');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('majorhead','budget?method=editmajorhead')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('majorhead','budget?method=deleteMajorHead&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
<script type="text/javascript"><!--
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sector Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Sector Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= SEARCH_NAME %>"


data_header[2] = new Array;
data_header[2][0] = "Status"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= STATUS%>"

data_arr = new Array();
<%
	if(searchCountryList != null)
	{
		Iterator itr=  searchCountryList.iterator();
		int  counter=0;
		while(itr.hasNext())
		{
			BudMajorHead  majorHead = (BudMajorHead)itr.next();
%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= majorHead.getId()%>
			data_arr[<%= counter%>][1] = "<%= majorHead.getMajorHeadCode()%>"
			data_arr[<%= counter%>][2] = "<%= majorHead.getMajorHeadName()%>"
			data_arr[<%= counter%>][3] = "<%= majorHead.getSequenceNo()%>"

<%if(majorHead.getStatus().equals("y"))
{%>
data_arr[<%= counter%>][4] = "Active"
<%}	else{
%>
data_arr[<%= counter%>][4] = "InActive"

<%}%>

	<%
counter++;}}
%>
formName = "majorhead"
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>
