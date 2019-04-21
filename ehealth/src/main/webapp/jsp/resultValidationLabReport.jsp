<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ResultValidationLabReport.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 14.09.2016    Name: Arbind
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream" %>
<%@page import="java.net.URL" %>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script>
function checkModulity(){
var subChargeCodeId=document.getElementById('subChargeCodeId').value;
if(subChargeCodeId!=0){
	return true;
}
else{
	alert("Please Select Modality");
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
<form name="RVLReport" action="" target="_blank" method="post"><script
	type="text/javascript" language="javascript">
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
	</script> <%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 	Date toDate  = null;
		Date fromDate=null;
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId = 0;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		String message = "";
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
	%> <script type="text/javascript">
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

<label><span>*</span> From Date</label> <input type="text" class="date"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.RVLReport.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date</label> <input type="text" id="ToDateId"

	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.RVLReport.<%=TO_DATE%>,event)" />
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="50" /> 
<div class="clear"></div>
<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>"
	validate="P Type,string,no">
	<!-- <option value="">Select One</option> -->
	<option value="OP">OP</option>
	<option value="IP">IP</option>
</select>
<label>Patient Name</label> <input type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />
<label>Mobile No</label> <input type="text"	name="<%=MOBILE_NO%>" value="" MAXLENGTH="30" />
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
<div class="clear"></div>

	<input type="button" name="" id="addbutton"
	onclick="submitForm('RVLReport','/hms/hms/investigation?method=generateResultValidationLabReport&flag=1','checkModulity','checkFromNTodata');"
	value="Generate Report" class="button" accesskey="a" />
	
<!-- //Note: Revert the changes for story NO :37
	<input type="button" name="" id="addbutton1"
	onclick="submitForm('RVLReport','/hms/hms/investigation?method=generateResultValidationLabReport&flag=2','checkModulity','checkFromNTodata');"
	value="Generate Report HTML" class="button" accesskey="a" /> -->
<div class="clear"></div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>