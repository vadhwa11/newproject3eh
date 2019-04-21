<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Financial Year Details.
 * @author  Ujjwal
 * Create Date: 17th Jan,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="../jsp/js/calendar.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	ArrayList searchfinancialyearList = (ArrayList)map.get("searchfinancialyearList");
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
<h2>Financial Year Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="radio" name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Financial Code</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<label>Financial Name</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'budget?method=searchfinancialyear')"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','budget?method=searchfinancialyear')" accesskey="s" tabindex="1" />
 <%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="financial"/>
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



if(searchfinancialyearList!=null){
		if(searchfinancialyearList.size()>0 )

		 {
			String strForCode = (String)map.get("financialCode");
			String strForCodeDescription = (String)map.get("financialName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%><h4> <a href="budget?method=showFinancialyearMaster">Show All Records</a></h4> <%
			}
		 }
	 if(searchfinancialyearList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="budget?method=showFinancialyearMaster">Show All Records</a></h4>

<%
     }
	}%>

<script type="text/javascript">
formFields =
	[[0, "<%= COMMON_ID%>", "id"], [1,"<%=CODE%>"], [2,"<%=SEARCH_NAME %>"], [3,"<%=FROM_DATE %>"], [4,"<%=TO_DATE %>"], [5,"<%=CHANGED_BY %>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"] ];
statusTd =7;
</script>
</div>
<form name="financialyear" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="HrMasFinancialYear"/>
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="YearDescription"/>
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="FinancialYear"/>
<input type="hidden" name="title" value="FinancialYear"/>
<input type="hidden" name="<%=JSP_NAME %>" value="FinancialYearMaster"/>
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span>	Financial Code</label>
<input type="text" id="fId" name="<%=CODE%>" value="" class="textbox_size20" validate="Financial Code,string,yes" MAXLENGTH="8" / tabindex=1 />
<label><span>*</span>	Financial Name</label>
<input type="text" id="fname"  name="<%=SEARCH_NAME %>" value="" validate="Financial Name,string,yes" class="textbox_size20" MAXLENGTH="15" / tabindex=1/>
<div class="clear"></div>
<label><span>*</span>	Start Date</label>
<input type="text" id="startdate"  name="<%=FROM_DATE %>" value="" validate=" Start Date,string,yes" class="date" MAXLENGTH="30" readonly="readonly"  tabindex=1/>
<img src="/hms/jsp/images/cal.gif" id="startdate" onClick="javascript:setdate('',document.financialyear.<%=FROM_DATE%>,event)"width="16" height="16" border="0" validate="Pick a date" class="calender" />
<label><span>*</span> End Date</label>
<input type="text" id="todate"  name="<%=TO_DATE %>" validate=" End Date,string,yes" class="date" MAXLENGTH="30" readonly="readonly" tabindex=1/>
<img src="/hms/jsp/images/cal.gif"  id="todate" onClick="javascript:setdate('',document.financialyear.<%=TO_DATE%>,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('financialyear','budget?method=addfinancialyear');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('financialyear','budget?method=editfinancialyear')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('financialyear','budget?method=deletefinancialyear&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=COMMON_ID%>" value="" />
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

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop40">
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Financial Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME %>"

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=FROM_DATE %>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=TO_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME%>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS%>"

data_arr = new Array();
<%
Iterator itr=searchfinancialyearList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  String temp1="";
        	  String temp2="";
        	  String[] str = new String[2];
        	  HrMasFinancialYear  masItemType = (HrMasFinancialYear)itr.next();
             if(masItemType.getFinancialYear()!=null && masItemType.getFinancialYear().contains("-")){
              str=     masItemType.getFinancialYear().split("-");
     		  temp1=str[0];
      	 	  temp1=temp1.substring(2,4);
     	 	  temp2=str[1];
    		  temp2=temp2.substring(2,4);
             }
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masItemType.getId()%>
<%if(temp1!="" && temp2!=""){%>
data_arr[<%= counter%>][1] = "<%=temp1+"-"+temp2%>"
<%}%>
<%if(masItemType.getFinancialYear()!=null){%>
data_arr[<%= counter%>][2] = "<%= masItemType.getFinancialYear()%>"
	<%}%>
	<%if(masItemType.getYearFromDate()!=null){%>
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemType.getYearFromDate())%>"
	<%}%>
	<%if(masItemType.getYearToDate()!=null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masItemType.getYearToDate())%>"
	<%}%>
	<%if(masItemType.getLastChgBy()!=null){%>
data_arr[<%= counter%>][5] = "<%= masItemType.getLastChgBy()%>"
	<%}%>
	<%if(masItemType.getLastChgTime()!=null){%>
data_arr[<%= counter%>][6] = "<%= masItemType.getLastChgTime() %>"
	<%}%>
<%
if(masItemType.getStatus().equals("y")){
	
%>
data_arr[<%= counter%>][7] = "Active"
<%}else{
	
%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>

formName = "financialyear"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>