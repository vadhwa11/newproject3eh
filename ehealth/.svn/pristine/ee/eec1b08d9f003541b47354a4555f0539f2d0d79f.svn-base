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
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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
	List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("mmMasPriorityCodes")!=null){
		masPriorityCodes=(List<MasPriorityCodes>)map.get("mmMasPriorityCodes");
	}
	if(map.get("mmServiceRequests")!=null){
		mmServiceRequests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
	if(map.get("msg")!=null){
		out.println(map.get("msg"));
	}
%>
<form name="mTransferServiceRequest" action="" method="post">

<div class="titleBg">
<h2>Transfer Service Request</h2>
</div>
<div class="Block">
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate" validate="From Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mTransferServiceRequest.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate" validate="To Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mTransferServiceRequest.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	 <label>Item Code</label> <input type="text"	name="EquipmentNo" value="" MAXLENGTH="30" id="adNo" validate="Item Code,alphanumeric,no"/>
<div class="clear"></div>

<!-- <label>Item Category</label>  -->
<!--  <select><option>Select</option></select> -->
	<label>Request No</label>
	 <input type="text"	name="RequestNo" value="" MAXLENGTH="30" id="adNo" validate="Request No,alphanumeric,no"/>
	 <label>Priority</label> <select name="Priority"><option value="">Select</option>
	 <%for(MasPriorityCodes masPriorityCode:masPriorityCodes){ %>
	 <option value="<%=masPriorityCode.getId()%>"><%=masPriorityCode.getCodesName() %></option>
	 <%} %>
	 </select>
<div class="clear"></div>
<input type="button" name="Search" id="addbutton" onclick="if(checkData()){submitForm('mTransferServiceRequest','maintenance?method=showTransferServiceRequestToAnotherEngineer');}"	value="Search" class="button" accesskey="a" />
<input type="button" name="Search" id="addbutton" onclick="if(checkData()){submitForm('mTransferServiceRequest','maintenance?method=showTransferServiceRequestToAnotherEngineer&flag=all');}"	value="Show All" class="button" accesskey="a" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(mmServiceRequests.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Request Date</th><th>Request No</th><th>Item Code</th><th>Item Name</th><th>Priority</th><th>Request By</th><th>Requested From</th><th>Approved By</th><th>Status</th></tr>

	<% 
		 int  counter=0;
		for(MmServiceRequest object:mmServiceRequests){
			String approved="Not Required";
			if(object.getApprovedBy()!=null)
				approved=object.getApprovedBy().getEmployee().getEmployeeName();
	%>
			<form name="servicRequest<%= counter+1%>" method="post"><input type="hidden" name="requestId" value="<%=object.getId() %>" />
			<tr onclick="submitForm('servicRequest<%= counter+1%>', 'maintenance?method=showTransferService')" style="cursor: pointer;"><td><%= counter+1%></td>
			<td><%= HMSUtil.changeDateToddMMyyyy(object.getRequestDate())%></td>
			<td><%= object.getServiceRequestNo()%></td>
			<td><%= object.getEquipment().getItem().getPvmsNo()%></td>
		    <td><%= object.getEquipment().getItem().getNomenclature()%></td>
		    <td><%= object.getPriority().getCodesName()%></td>
		    <td><%= object.getLastChgBy().getEmployee().getEmployeeName()%></td>
		    <td><%= object.getEquipment().getDepartment().getDepartmentName()%></td>
		    <td><%= approved %></td>
		    <td><%= object.getRequestStatus().getStatusName() %></td>
		    </tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		    </form>
<%		++counter;
				}
	%>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	</div>
