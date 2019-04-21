<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for ed Report.
 * * @author  Priyanka garg  
 * Create Date: 22nd Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
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
<%@page import="jkt.hms.masters.business.MasServiceType"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<style>
#contentspace label {
	text-align: right;
	width: 99px;
	float: left;
	height: 9px;
	padding-top: 4px;
}
</style>
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
	</script> <br />
<h2 align="left" class="style1">Excuse Duty Reports</h2>
<br />


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
			 	List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
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
			 		visitList = (List<Visit>) map.get("showList");
			 		session.setAttribute("visitList", visitList);
			 	}
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("masServiceTypeList") != null) {
			 		masServiceTypeList = (List<MasServiceType>) map.get("masServiceTypeList");
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 	if (map.get("category") != null) {
			 		category = (String) map.get("category");
			 		session.setAttribute("category", category);
			 	}
			 	
			 	
			 %>

<form name="edreport" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label
	class="bodytextB"><font id="error">*</font> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.edreport.<%= FROM_DATE%>,event)" />

<label class="bodytextB"><font id="error">*</font> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.edreport.<%= TO_DATE%>,event)" />

<br />
<label class="bodytextB">Category Wise:</label> <select id="categoryId"
	name="<%=CATEGORY_ID %>" size="4" multiple="4">
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}%>
</select> <label class="bodytextB">Disposal :</label> <select id="categoryId"
	name="<%=DISPOSAL %>">
	<option value="0">Select</option>
	<option value="ED">ED</option>
	<option value="LD">LD</option>
	<option value="MD">MD</option>
	<option value="SIQ">SIQ</option>
	<option value="DUTY">DUTY</option>
</select> <label class="bodytextB">Service Type :</label> <select id="categoryId"
	name="<%=SERVICE_TYPE_ID %>">
	<option value="0">Select</option>
	<%for (MasServiceType masServiceType: masServiceTypeList) {%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName()%></option>
	<%}%>
</select> <br />
<br />
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('edreport','mis?method=showEDreports','checkFromNTodata');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>





