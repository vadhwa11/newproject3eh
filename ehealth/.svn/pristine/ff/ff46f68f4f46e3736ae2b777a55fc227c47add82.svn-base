<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * monthlySick.jsp  
 * Purpose of the JSP -  This is for Monthly sick Report.
 * * @author  Priyanka garg  
 * Create Date: 26th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MisFrw"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>

<%@page import="jkt.hms.masters.business.MasDisposedTo"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>

<br />

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
		
	</script> <script type="text/javascript" language="javascript">
	var showListArray=new Array();
	var misFrwArray=new Array();
	
	
	function checkFrwCases()
		{
			var dateFrom = document.getElementById('inputDate').value;
 			fromDateFormat = new Date(dateFrom.substring(6),(dateFrom.substring(3,5) - 1) ,dateFrom.substring(0,2));
 			var calcYear=fromDateFormat.getFullYear();
 			var calcMonth=1+fromDateFormat.getMonth();
 			if(calcMonth<10)
 				calcMonth="0"+calcMonth;
 			var calcDate=fromDateFormat.getDate();
 			if(calcDate<10)
 				calcDate="0"+calcDate;
			var finalFromDate=calcYear+"-"+calcMonth+"-"+calcDate;
			if(misFrwArray.length>0)
			for(i=0;i<misFrwArray.length;i++)
			{  		
					if(misFrwArray[i][1]==finalFromDate && misFrwArray[i][0]==document.frwCases.serviceNo.value)
					{	
						alert("Duplicate record!!!!")
						document.getElementById("hinId").value ="";
						document.getElementById("rankName").value = "";
						document.getElementById("patientName").value="";
						document.getElementById("tradeName").value="";	  			         
						document.getElementById("unitName").value="";		     	         			        		          
						document.getEl("sex").value="";
						document.getElementById("fromDateId").focus();
						return false;
					
					}
			}
			return true;
		}
		
					
		function showFrwCases()
		{
			
			for(i=0;i<showListArray.length;i++)
			{
					if( showListArray[i][6]==document.frwCases.serviceNo.value)
					{
						document.getElementById("hinId").value = showListArray[i][0];
						document.getElementById("rankName").value = showListArray[i][1];
						document.getElementById("patientName").value=showListArray[i][2];
						document.getElementById("tradeName").value=showListArray[i][3];	  			         
						document.getElementById("unitName").value=showListArray[i][4];		     	         			        		          
						document.getElementById("sex").value=showListArray[i][5];
						document.getElementById("hinId").value=showListArray[i][7];
						document.getElementById("sex").value="SBC";
						
					}
			}
			document.getElementById("to").focus();
			
		}
		
		function displayHospital(){
				var disposalId = document.getElementById('disposalId').value;
				
				if(disposalId != 12){
				      document.getElementById('hospitalDiv').style.display = 'none';
				}else if(disposalId == 12){
					  document.getElementById('hospitalDiv').style.display = 'inline';
				}
				if(disposalId != 13){
				      document.getElementById('leaveDiv').style.display = 'none';
				}else if(disposalId == 13 ){
				      document.getElementById('leaveDiv').style.display = 'inline';
				}
			}
	</script>
<h2 align="left" class="style1">Requisition for issue of FRW on
Discharge/Transfer/Sick Leave</h2>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 
			 	String currentDate = (String) utilMap.get("currentDate");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<MasDisposedTo> disposalToList=null;
				if (request.getAttribute("map") != null) {
					map = (Map)request.getAttribute("map");
				}
				if (map.get("disposalToList") != null) {
					disposalToList = (List<MasDisposedTo>)map.get("disposalToList");
				}
				%>

<form name="frwCases" method="post"><label class="bodytextB">
Entry Date:</label> <input type="text" id="inputDate" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.frwCases.<%=FROM_DATE%>,event)" />

<br />
<br />
<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 180px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;"><br />
<label class="bodytextB">Service No:</label> <input type="text"
	class="textbox_date" size="2" title="Enter Service No. of patient."
	id="serviceNo" name="<%=SERVICE_NO%>"
	onblur="populateHinNo(this.value);" /> <label class="bodytextB">HIN:</label>
<select id="hinNoId" name="<%=HIN_ID %>" validate="HIN,string,yes"
	onchange="getFRWDetails(this.value);" style="width: 120px">
	<option value="0">select</option>
</select> <label class="bodytextB">Rank:</label> <input type="text"
	class="readOnly" value="" id="rankName" name="<%=RANK_NAME %>"
	readonly="readonly" /> <label class="bodytextB">Name:</label> <input
	type="text" class="readOnly" id="patientName" name="<%=PATIENT_NAME%>"
	readonly="readonly" /> <label class="bodytextB">Trade Name:</label> <input
	type="text" class="readOnly" id="tradeName" name="<%=TRADE_NAME%>"
	readonly="readonly" /> <label class="bodytextB">Sex:</label> <input
	type="text" class="readOnly" id="sex" name="<%=SEX%>"
	readonly="readonly" /> <label class="bodytextB">Unit Name:</label> <input
	type="text" class="readOnly" id="unitName" name="<%=UNIT_NAME%>"
	readonly="readonly" /> <input type="hidden" class="textbox_date"
	id="hinId" name="<%=HIN_ID%>" readonly="readonly" /> <label
	class="bodytextB">From:</label> <input type="text" class="readOnly"
	id="from" size="2" value="SBC" id="from" name="<%=FROM%>"
	readonly="readonly" /> <label class="bodytextB">To:</label> <input
	type="text" class="textbox_date" id="to" size="2" value="" id="to"
	name="<%=TO%>" /> <label class="bodytextB">Class:</label> <select
	name="<%=CLASS%>" id="toClass" style="width: 100px;">
	<option value="">select</option>
	<option value="Sleeper">Sleeper</option>
	<option value="AC-III">AC-III</option>
	<option value="AC-II">AC-II</option>
	<option value="AC-I">AC-I</option>
</select> <!-- <input type="text" class="textbox_date"  id="toClass" size="2" value="" name="<%=CLASS%>" /> -->
<label class="bodytextB">Disposal:</label> <select id="disposalId"
	name="<%=DISPOSAL_ID %>" validate="Disposal,string,yes"
	style="width: 120px" onchange="displayHospital();">
	<option value="0">select</option>
	<option value="5">Unit</option>
	<option value="12">TRANSFER TO OTH HOSPITAL</option>
	<option value="13">SICK LEAVE</option>
</select>
<div id="hospitalDiv" style="display: none;"><label
	class="bodytextReg"> Hospital Name:</label> <input id="newUnitId"
	type="text" name="<%=HOSPITAL_NAME%>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /></div>

<div id="leaveDiv" style="display: none;"><label class="bodytextB">
Period of sick leave:</label> <input id="sickLeave" type="text"
	name="<%=SICK_LEAVE%>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label
	class="bodytextB"> Review at:</label> <input id="reviewat" type="text"
	name="<%=REVIEW_AT%>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label
	class="bodytextB">From Date:</label> <input type="text" id="fromdate"
	name="<%=SICK_FROM_DATE%>" value="" class="readOnly" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.frwCases.<%=SICK_FROM_DATE%>,event)" />

<label class="bodytextB">To Date:</label> <input type="text"
	id="fromdate" name="<%=TO_DATE%>" value="" class="readOnly"
	MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.frwCases.<%=TO_DATE%>,event)" />
</div>
<label class="bodytextB">Frw S.No:</label> <input type="text"
	id="frwSrNo" class="textbox_date" validate="Frw SrNo,String,no"
	size="2" value="" tabindex="1" name="<%=FRW_SR_NO%>" /> <label
	class="bodytextB">POR:</label> <input type="text" id="por"
	class="textbox_date" size="2" value="" tabindex="1" name="<%=POR%>" />
</div>
</div>

<input type="button" class="button" value="Submit" align="right"
	onClick="if(checkFrwCases()){submitForm('frwCases','mis?method=submitFrwCases','checkDateNotGreaterThanCurrentDate');}" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>





