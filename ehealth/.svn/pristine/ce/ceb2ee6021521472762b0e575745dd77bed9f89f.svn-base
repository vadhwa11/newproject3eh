<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poMain.jsp  
 * Purpose of the JSP -  This is for PO Main form .
 * @author  Deepti Tevatia
 * Create Date: 12th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HesMinorRoutineWork"%>
<%@page import="jkt.hms.masters.business.HesWorkParticularMaster"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
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


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	List<HesWorkParticularMaster> workParticularList = new ArrayList<HesWorkParticularMaster>();
	List<HesMinorRoutineWork> entryNoList = new ArrayList<HesMinorRoutineWork>();
	includedJsp = (String) map.get("includedJsp");

	if (map.get("hesWorkList")!= null)
		workParticularList = (List<HesWorkParticularMaster>)map.get("hesWorkList");
	
	if (map.get("hesEntryList")!= null)
		entryNoList = (List<HesMinorRoutineWork>)map.get("hesEntryList");
	
	if (map.get("masDepartmentList")!= null)
		masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>

<form name="minorRoutineForm" method="post"">
<h2>Minor Routine Works Entry</h2>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form action="" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Date </label> <input type="text" name="<%=FROM_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.minorRoutineForm.<%= FROM_DATE%>,event);" />
	
<label>Work Particular :</label> <select name="searchWorkParticular">
	<option value="0" >-Select Work Particulars-</option>
<%
		for (HesWorkParticularMaster hesWorkParticular : workParticularList )
		{
%>
			<option value=<%=hesWorkParticular.getId()%>><%=hesWorkParticular.getWorkParticularName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Entry No :</label> <select name="searchEntryNo">
	<option value="0">---Select Entry No----</option>
<%
		for (HesMinorRoutineWork hesMinorRoutineWork : entryNoList )
		{
%>
			<option value=<%=hesMinorRoutineWork.getId()%>><%=hesMinorRoutineWork.getEntryNo()%></option>
<%
		}
%>
</select> 
<label>Department/Area :</label> <select name="searchDeptName">
	<option value="0">--Select Department--</option>
<%
		for (MasDepartment mastDepartment : masDepartmentList )
		{
%>
			<option value=<%=mastDepartment.getId()%>><%=mastDepartment.getDepartmentName()%></option>
<%
		}
%>
</select> 
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('minorRoutineForm','hes?method=searchMinorRoutine');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" /> <%
 	if (includedJsp != null) {
 %>
<div class="clear"></div>
<jsp:include page="hesMinorDetail.jsp" /> <%
 	}
 %> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <input type="button" name="Modify" class="button" value="Modify"
	onClick="submitForm('minorRoutineForm','hes?method=modifyMinorRoutine');" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

