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
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
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
		List<MasWard> ward = new ArrayList<MasWard>();
		if(map.get("ward") !=null){
			ward=(List<MasWard>)map.get("ward");
		}
		
		List<MasHospital> masHospitalCHC = new ArrayList<MasHospital>();
		if(map.get("masHospitalCHC") !=null){
			masHospitalCHC=(List<MasHospital>)map.get("masHospitalCHC");
		}
		
		List<MasHospital> masHospitalPHC = new ArrayList<MasHospital>();
		if(map.get("masHospitalPHC") !=null){
			masHospitalPHC=(List<MasHospital>)map.get("masHospitalPHC");
		}
		List<MasLsg> masLsg = new ArrayList<MasLsg>();
		if(map.get("masLsg") !=null){
			masLsg=(List<MasLsg>)map.get("masLsg");
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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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



<div class="clear"></div>

<label>House No</label>
<input type="text"	name="houseNo" value="" MAXLENGTH="30" id="adNo" />
 
<label>Ward</label><select name="ward" id="ward" onchange="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/pubHealth?method=getlocalitySearch&ward='+this.value,'teDivss');" >
<%	if(ward.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasWard wa : ward) {
					
				  %>
				  <option value="<%=wa.getId()%>"><%=wa.getWardName()%></option>
				  <%
				  	 	}}
				   %>

</select>


<div id="teDivss">
<label>Locality</label>
<select name="localityId" id="localityId" >
				<option value="0">Select</option>
</select>

<div class="clear"></div>


</div>
<!-- <label>Village</label> 
<input type="text"	name="village" value="" MAXLENGTH="30" id="adNo" /> -->
<%
int hospitalTypeId = (Integer)session.getAttribute("hospitalTypeId");
if(hospitalTypeId == 9 || hospitalTypeId == 10 || hospitalTypeId == 11){
%>

<%	if(masHospitalPHC.size() >0){
%>

<label>Sub Centre/Basic Section</label><select name="scBS" id="scBS" >
<%	if(masHospitalPHC.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital h : masHospitalPHC) {
					
				  %>
				  <option value="<%=h.getId()%>"><%=h.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>
<%} %>


<%} else if(hospitalTypeId==15){
	%>


<%	if(masHospitalPHC.size() >0){
%>
<label>LSG</label>
<select name="lsg" id="lsg" >
<%	if(masLsg.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasLsg h : masLsg) {
					
				  %>
				  <option value="<%=h.getId()%>"><%=h.getLsgTypeName()%></option>
				  <%
				  	 	}}
				   %>

</select>

<label>PHC</label><select name="phc" id="phc" onchange="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/pubHealth?method=getPHC&phc='+this.value,'scBs');">
<%	if(masHospitalPHC.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital h : masHospitalPHC) {
					
				  %>
				  <option value="<%=h.getId()%>"><%=h.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>
<%} %>




<div id="scBs">


</div>

<%} %>


	<div class="clear"></div>

<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','pubHealth?method=showJHIJPHNHouseSurveyJsp');}"	value="Search" class="button"  />
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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="requestId" value="<%=phHouseSurvey.getHouseHoldId() %>" />
			<tr onclick="submitForm('phHouseSurveys<%=counter+1%>', 'pubHealth?method=phMemberSurvey')" style="cursor: pointer;">
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