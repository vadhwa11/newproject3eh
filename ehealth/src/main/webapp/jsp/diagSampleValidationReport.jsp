<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : SampleValidationReport.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author    Name: Arbind
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>


<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="SVReport" action=""  target="_blank" method="post">
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
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String message = "";
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId = 0;
		
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
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
		
		// added by amit das on 17-07-2017
		if(detailsMap.get("masHospital") != null){
			masHospital =(MasHospital)detailsMap.get("masHospital");
		}
		
		
		currentLabId = (Integer)detailsMap.get("currentLabId"); // added by amit das on 17-07-2017
		
		if (detailsMap.get("userId") != null) {
			userId = (Integer) detailsMap.get("userId");
		}
		
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	</script>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Sample Validation Report</h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,no"
			onClick="setdate('<%=currentDate %>',document.SVReport.<%=FROM_DATE%>,event)" />
		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,no"
			onClick="setdate('<%=currentDate %>',document.SVReport.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
		<div class="clear"></div>
		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>">
			<option value="OP">OP</option>
			<option value="IP">IP</option>
		</select>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> 
		<label>Mobile No</label> <input type="text" name="<%=MOBILE_NO%>" value="" MAXLENGTH="15" />
		<div class="clear"></div>
		<label>Modality</label> 
		<!-- added by amit das on 17-07-2017 -->
<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>" onchange="bookLabForDoctor('sampleValidation');">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(currentLabId==subChargecode.getId()){%>
			<option selected="selected" value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>
<% } else { %>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>

<% } %>		
</select>		
		<label>Priority</label> <select id="priorityId"
			name="priorityId">
			<option value="0">Select</option> 
			<option value="r">Routine</option>
			<option value="u">Urgent</option> 
		</select> 
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" id="addbutton"
		onclick="submitForm('SVReport','/hms/hms/lab?method=generateSampleValidationReport&flag=1');"
		value="Generate Report" class="button" accesskey="a" />
		<!--//Note: Revert the changes for story NO :37
		 <input type="button" id="addbutton1"
		onclick="submitForm('SVReport','/hms/hms/lab?method=generateSampleValidationReport&flag=2');"
		value="Generate Report HTML" class="button" accesskey="a" /> -->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>