<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : SampleCollectionReport.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 12.09.2016    Name: Arbind
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	
	 <META HTTP-EQUIV="REFRESH" CONTENT="20"> 
<form name="SCReport" action="" target="_blank" method="post">
	<script type="text/javascript" language="javascript">

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
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String message = "";

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
		<%}	%>
</script>
	<script type="text/javascript">
	function check(){
		var FDate = document.SCReport.<%= FROM_DATE%>.value;
		var TDate = document.SCReport.<%= TO_DATE %>.value;


		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<div class="titleBg">
		<h2>Sample Collection Report(OP Patient)</h2>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>


		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate%>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="From Date,date,yes"
			onClick="setdate('<%=currentDate%>',document.SCReport.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="To Date,date,yes"
			onClick="setdate('<%=currentDate %>',document.SCReport.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="16" />

		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" validate="Patient Name,metachar,no" />
		<label>Token No.</label>
		<input type="text" name="<%=VISIT_NUMBER %>" value="" MAXLENGTH="3" validate="visitNumber,int,no"/>
		<label>Doctor Name</label> <input type="text" name="<%=DOCTOR_NAME %>"
			value="" MAXLENGTH="15"  validate="Doctor Name,metachar,no"/>
		<div class="clear"></div>
		<label>Priority</label> <select id="priorityId"
			name="priorityId">
			<option value="0">Select</option> 
			<option value="r">Routine</option>
			<option value="u">Urgent</option> 
		</select>
		<div class="clear"></div> 
		<div class="clear"></div>
		<input type="button" value="Generate Report" class="button"	onclick="submitForm('SCReport','/hms/hms/lab?method=generateSampleCollectionReport&flag=1','check()');"	accesskey="a" />
		<!-- //Note: Revert the changes for story NO :37
		<input type="button" value="Generate Report HTML" class="button"	onclick="submitForm('SCReport','/hms/hms/lab?method=generateSampleCollectionReport&flag=2','check()');"	accesskey="a" />
		 -->
		<div class="clear"></div>
	</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>