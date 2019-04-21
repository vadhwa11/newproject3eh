
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmInspectionReport"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");	
		Map<String, Object> map= new HashMap<String, Object>();
		List<MasPriorityCodes> priorityCodes=new ArrayList<MasPriorityCodes>();
		List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
		if(request.getAttribute("map")!=null){
			map=(Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("inspectionReports")!=null){
			inspectionReports=(List<MmInspectionReport>)map.get("inspectionReports");
		}
		if(map.get("priorityCodes")!=null){
			priorityCodes=(List<MasPriorityCodes>)map.get("priorityCodes");
		}
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
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
<form name="pendingForServiceOrderComletion"  method="post">
<%
	if(map.get("msg")!=null){
		String message=(String)map.get("msg");
		out.print(message);
	}
%>
<div class="titleBg">
<h2>Pending List For Service Order Completion</h2>
</div>
<div class="Block">
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate" validate="From Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.pendingForServiceOrderComletion.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate" validate="To Date,date,yes">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.pendingForServiceOrderComletion.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	 <label>Work Order No</label> <input type="text"	name="WorkOrderNo" value="" MAXLENGTH="30" id="adNo" validate="Work Order No,alphanumeric,no" />
<div class="clear"></div>
	<label>Request No</label>
	 <input type="text"	name="RequestNo" value="" MAXLENGTH="30" id="adNo" validate="Request No,alphanumeric,no"/>
	 <label>Priority</label> <select name="Priority"><option value="">Select</option>
	 <%for(MasPriorityCodes masPriorityCodes:priorityCodes){ %>
	 <option value="<%=masPriorityCodes.getId()%>"><%=masPriorityCodes.getCodesName() %></option>
	 <%} %>
	 </select>
<!-- 	 <label>Status</label>  -->
<!-- 	 <select><option>Select</option></select> -->
<div class="clear"></div>
<input type="button" name="Search" id="addbutton" onclick="if(checkData()){submitForm('pendingForServiceOrderComletion','maintenance?method=showPendingListForServiceCompletionJsp');}"	value="Search" class="button" accesskey="a" />
<input type="button" name="Search" id="addbutton" onclick="if(checkData()){submitForm('pendingForServiceOrderComletion','maintenance?method=showPendingListForServiceCompletionJsp&flag=all');}"	value="Show All" class="button" accesskey="a" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<% if(inspectionReports.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Request Date</th><th>Request No</th><th>Item Code</th><th>Item Name</th><th>Priority</th><th>Request By</th><th>Requested From</th><th>Approved By</th><th>Status</th></tr>

	<% 
		 int  counter=0;
		for(MmInspectionReport object:inspectionReports){
			String approvedBy="Not Required";
			if(object.getRequest().getApprovedBy()!=null){
				approvedBy=object.getRequest().getApprovedBy().getEmployee().getEmployeeName();
			}
	%>
			<form name="servicRequest<%= counter+1%>" method="post"><input type="hidden" name="requestId" value="<%=object.getId() %>" />
			<tr onclick="submitForm('servicRequest<%= counter+1%>', 'maintenance?method=serviceOrderCompletion')" style="cursor: pointer;"><td><%= counter+1%></td>
			<td><%= HMSUtil.changeDateToddMMyyyy(object.getRequest().getRequestDate())%></td>
			<td><%= object.getRequest().getServiceRequestNo()%></td>
			<td><%= object.getRequest().getEquipment().getItem().getPvmsNo()%></td>
		    <td><%= object.getRequest().getEquipment().getItem().getNomenclature()%></td>
		    <td><%= object.getRequest().getPriority().getCodesName()%></td>
		    <td><%= object.getRequest().getLastChgBy().getEmployee().getEmployeeName()%></td>
		    <td><%= object.getRequest().getEquipment().getDepartment().getDepartmentName()%></td>
		    <td><%=approvedBy  %></td>
		    <td><%= object.getRequest().getRequestStatus().getStatusName() %></td>
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
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
