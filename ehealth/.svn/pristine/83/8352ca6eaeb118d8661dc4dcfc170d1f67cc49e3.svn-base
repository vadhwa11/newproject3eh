
<%-- 
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* File Name           : ResultEntryLabReport.jsp 
* Tables Used         : 
* Description         : 
* @author  Create Date: 15.11.2016    Name: Govind
* Revision Date:      Revision By: 
* @version 1.0  

--%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>



<% 
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="RELReport" action="" method="post" target="_blank">
	<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	date = (String) utilMap.get("currentDate");
	String message = "";
	Date toDate  = null;
	Date fromDate=null;
	Box box = null;
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
	if(session.getAttribute("boxForResultEntry") != null){
		box = (Box)session.getAttribute("boxForResultEntry");
	}
	if(detailsMap.get("subChargeCodeList") != null){
		subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
	}
	//added by govind 14-11-2016
	if(detailsMap.get("investigationList") != null){
		investigationList = (List<DgMasInvestigation>)detailsMap.get("investigationList");
	}
	
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
alert(msg);

<%}
%>
</script>
	<div class="titleBg">
		<h2>Result Entry Lab Report</h2>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.RELReport.<%=FROM_DATE%>,event)" />
			<label class="autoSpace"> Time</label>
			<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.RELReport.<%=TO_DATE%>,event)" />
<label class="autoSpace"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>

		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
		<div class="clear"></div>
		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>"
			id="patientType" validate="P Type,string,no">
			<!-- <option value="">Select One</option> -->
			<option value="Out Patient">OP</option>
			<option value="In Patient">IP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input
			type="text" name="<%=AD_NO %>" value="" MAXLENGTH="30" /> 
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />
		<div class="clear"></div>
		<label>Mobile No</label> <input type="text" name="<%=MOBILE_NO %>"
			value="" MAXLENGTH="50" />
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
		
		
		<!-- added by govind 14-11-2016 -->	
		<label>Investigation Name</label> <select id="investId"
			name="investId">
			<option value="0">Select</option>
			<% for(DgMasInvestigation inv :investigationList){ %>
			<option value="<%=inv.getId() %>"><%=inv.getInvestigationName() %></option>
			<%}%>
		</select>
		<!-- added by govind 14-11-2016 end-->	
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" value="Generate Report" class="button"
		onclick="submitForm('RELReport','/hms/hms/investigation?method=generateLabWorkSheetReport&flag=1','checkFromNTodata','chkPatientTypeForBillno');"
		accesskey="a" id="submitButtonId" />
			
		 <input type="button" value="VIEW" class="button" target="_blank"
		onclick="submitForm('RELReport','/hms/hms/investigation?method=generateLabWorkSheetReport&flag=2','checkFromNTodata','chkPatientTypeForBillno');"
		accesskey="a" id="submitButtonIdHtml" /> 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>