<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReturnFrom.jsp  
 * Purpose of the JSP -  This is for ed Return.
 * @author  Deepti
 * @author  Ritu  
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
     function check(browser){
     document.getElementById("ff").value=browser
     }
 </script>
<h2 align="left" class="style1">Excuse Duty Returns Entry Form</h2>
<%
     String userName = "";
     if (session.getAttribute("userName") != null) {
      userName = (String) session.getAttribute("userName");
     }
          Map<String, Object> utilMap = new HashMap<String, Object>();
     utilMap = (Map) HMSUtil.getCurrentDateAndTime();
     String currenDate = (String) utilMap.get("currentDate");
     String time = (String) utilMap.get("currentTime");

     Map<String, Object> map = new HashMap<String, Object>();
     if (request.getAttribute("map") != null) {
      map = (Map<String, Object>) request.getAttribute("map");
     }
     List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
     List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
     List<Patient> patientList = new ArrayList<Patient>();
     List<Visit> visitList = new ArrayList<Visit>();
     List<Object> list = null;
     Date toDate  = null;
     Date fromDate=null;
     String category=null;
     
    
     if (map.get("rankCategoryList") != null) {
      rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
     }
     if (map.get("disposalList") != null) {
      disposalList = (List<MasDisposal>) map.get("disposalList");
     }
     if (map.get("patientList") != null) {
      patientList = (List<Patient>) map.get("patientList");
     }
    
     if (map.get("showList") != null) {
      list = (List<Object>) map.get("showList");
      
     }
     if (map.get("toDate") != null) {
      toDate = (Date) map.get("toDate");
      
     }
     if (map.get("fromDate") != null) {
      fromDate = (Date) map.get("fromDate");
      
     }
     if (map.get("category") != null) {
      category = (String) map.get("category");
      
     }
     if(map.get("message") != null){
     String message = (String)map.get("message");
     
     %>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<%    
       }
    %>
<form name="EDDetails" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Enter Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 60px; background-color: #f4f9fe;">
<br />
<label class="bodytextB">From Date:</label> <input type="text"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.EDDetails.<%=FROM_DATE%>,event)" />

<label class="bodytextB"> To Date:</label> <input type="text"
	id="toDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.EDDetails.<%=TO_DATE%>,event)" />

<label class="bodytextB">Category :</label> <select id="categoryId"
	name="<%=CATEGORY_ID %>" validate="Category,string,yes">
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}%>
</select></div>

<br />

<input type="button" name="show" value="Show" class="button"
	onClick="submitProtoAjaxForEDReturns('EDDetails','mis?method=showEDReturns','show');" />
<input type="hidden" name="<%= POJO_NAME %>" value="Visit" /> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VisitNo" /> <input
	type="hidden" name="title" value="EDDetails" /> <input type="hidden"
	name="<%=JSP_NAME %>" value="EDDetails" /> <input type="hidden"
	name="pojoPropertyCode" value="VisitNo" /></form>

<div id="show"></div>
</div>