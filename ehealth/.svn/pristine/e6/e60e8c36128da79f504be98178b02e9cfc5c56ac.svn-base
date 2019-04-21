<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<PhHouseSurvey> phHouseSurveys=new ArrayList<PhHouseSurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("phHouseSurveys")!=null){
			phHouseSurveys=(List<PhHouseSurvey>)map.get("phHouseSurveys");
		}
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
     	if(map.get("talukList")!=null){
     		talukList=(List<MasTaluk>)map.get("talukList");
		}
		
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
	function checkData(){
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start<=end){
				 return true;
			 }else{alert("Date is Incorrect.");return false;}
		}
</script>

<form name="search" action="" method="post">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>House Survey</h2>
</div>
<div class="clear"></div>
<div class="Block">
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="fromDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="toDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">


 <label><span>* </span>Taluk</label> 
<select name="taluk" id="taluk" onchange="submitProtoAjaxWithDivName('search','/hms/hms/pubHealth?method=getVillageListHouseSurvey','testDiv');">
	<option value="0">Select</option>
	<%
	for(MasTaluk taluk:talukList){
	%>
	<option value="<%=taluk.getId()%>"><%=taluk.getTalukName()%></option>
	 <%}%>
	</select>
<div class="clear"></div>
 <div id="testDiv">
 <label><span>*</span>Village</label> 
<select><option value="">Select</option>
</select>
</div> 	
	<label>House No</label>
	 <input type="text"	name="houseNo" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','pubHealth?method=showHouseSurveyINDistrictJsp');}"	value="Search" class="button"  />
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<h4>Survey Details</h4>
<div id="pageNavPosition"></div>
<%if(phHouseSurveys.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Survey Date</th><th>Village</th><th>House No</th><th>Address</th></tr>
<tbody id="tableData">
	<% 
		 int  counter=0; 
 		for(PhHouseSurvey phHouseSurvey:phHouseSurveys){ 
	%> 
			<form name="phHouseSurveys<%= counter+1%>" method="post">
			<input type="hidden" name="requestId" value="<%=phHouseSurvey.getHouseHoldId() %>" />
			<tr onclick="submitForm('phHouseSurveys<%=counter+1%>', 'pubHealth?method=phMemberSurvey')">
			<td><%= counter+1%></td>
		    <td><%= phHouseSurvey.getHouseSurveyDate()!=null ? HMSUtil.changeDateToddMMyyyy(phHouseSurvey.getHouseSurveyDate()):""%></td>
		    <td><%= phHouseSurvey.getVillage() !=null ? phHouseSurvey.getVillage().getVillageName():""%></td>
		    <td><%= phHouseSurvey.getLsgHouseNo()!=null ? phHouseSurvey.getLsgHouseNo():""%></td>
		    <td><%= phHouseSurvey.getAddress()!=null ? phHouseSurvey.getAddress():""%></td></tr></form>
<%		++counter;
				} 
 	%> 
 	</tbody>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	
	
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	</div>
   <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>