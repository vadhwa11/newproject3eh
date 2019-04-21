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
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

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
		
			function checkData(){
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start<=end){
				 return true;
			 }else{alert("Date is Incorrect.");return false;}
		}
</script>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("mmServiceRequests")!=null){
		mmServiceRequests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
%>
<form name="RequestTracker"  method="post">
<div class="titleBg">
<h2>Request Tracker</h2>
</div>
<div class="Block">
 <label>Require From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.RequestTracker.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label>Require To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.RequestTracker.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	 <label>Request No</label> <input type="text"	name="RequestNo" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
<!-- <label>Service Order No</label> 
  <input type="text"	name="" value="" MAXLENGTH="30" id="adNo" />
	<label>Item Code</label>
	 <input type="text"	name="" value="" MAXLENGTH="30" id="adNo" /> -->
	 <label>Item Name</label>
	 <input type="text"	name="ItemName" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('RequestTracker', '/hms/hms/maintenance?method=showRequestTrackerJsp')}"	value="Search" class="button" accesskey="a" />
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('RequestTracker', '/hms/hms/maintenance?method=showRequestTrackerJsp&flag=all')}"	value="Show All" class="button" accesskey="a" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
	<h4>First Level</h4>
	
		<table>
			<tr><th>S.No.</th><th>Requested Date</th><th>Require Date</th><th>Request No</th><th>Item Name</th><th>Priority</th><th>Requested By</th><th>Requested From</th><th>Status</th></tr>
			<%
			int sNo=1;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date curentDate=new Date();
			for(MmServiceRequest serviceRequest:mmServiceRequests){
				Date requirDate=null;
				if(serviceRequest.getRequiredDate().before(curentDate)){
				%>	
			<form name="mRequestTrackerDetails<%=sNo%>" method="post">
			<input type="hidden" name="requestId" value="<%=serviceRequest.getId() %>" />
			<tr onclick="submitForm('mRequestTrackerDetails<%=sNo%>', 'maintenance?method=showRequestTrackerDetail')"><td><%=sNo %></td><td><%=HMSUtil.changeDateToddMMyyyy(serviceRequest.getRequestDate()) %></td><td><%=HMSUtil.changeDateToddMMyyyy(serviceRequest.getRequiredDate())%></td><td><%=serviceRequest.getServiceRequestNo() %></td><td><%=serviceRequest.getEquipment().getItem().getNomenclature() %></td><td><%= serviceRequest.getPriority().getCodesName() %></td><td><%= serviceRequest.getLastChgBy().getEmployee().getEmployeeName() %></td><td><%= serviceRequest.getEquipment().getDepartment().getDepartmentName() %></td><td><%= serviceRequest.getRequestStatus().getStatusName() %></td></tr>
			
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		<% sNo++;}} %>
		</table>
	
	<h4>Second Level</h4>
	
		<table>
			<tr><th>S.No.</th><th>Requested Date</th><th>Require Date</th><th>Request No</th><th>Item Name</th><th>Priority</th><th>Requested By</th><th>Requested From</th><th>Status</th></tr>
			<%
			int sNo1=1;
			for(MmServiceRequest serviceRequest:mmServiceRequests){
				if(serviceRequest.getRequiredDate().after(curentDate) || serviceRequest.getRequiredDate().equals(curentDate)){
				%>	
			<form name="mRequestTrackerDetail<%=sNo1%>" method="post">
			<input type="hidden" name="requestId" value="<%=serviceRequest.getId() %>" />
			<tr onclick="submitForm('mRequestTrackerDetail<%=sNo1%>', 'maintenance?method=showRequestTrackerDetail')"><td><%=sNo1 %></td><td><%=HMSUtil.changeDateToddMMyyyy(serviceRequest.getRequestDate()) %></td><td><%=HMSUtil.changeDateToddMMyyyy(serviceRequest.getRequiredDate())%></td><td><%=serviceRequest.getServiceRequestNo() %></td><td><%=serviceRequest.getEquipment().getItem().getNomenclature() %></td><td><%= serviceRequest.getPriority().getCodesName() %></td><td><%= serviceRequest.getLastChgBy().getEmployee().getEmployeeName() %></td><td><%= serviceRequest.getEquipment().getDepartment().getDepartmentName() %></td><td><%= serviceRequest.getRequestStatus().getStatusName() %></td></tr>
			
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		<% sNo1++;}} %>
		</table>
	</div>
