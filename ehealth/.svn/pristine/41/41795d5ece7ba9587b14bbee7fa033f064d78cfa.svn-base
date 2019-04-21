<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<%@page import="java.util.*"%>
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
String msg="";
Map<String ,Object> map = new HashMap<String ,Object>();
List<Object[]> hesEquipmentMaster = new ArrayList<Object[]>();
List<MmServiceRequest> serviceRequest = new ArrayList<MmServiceRequest>();
if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("equipmentMaster")!= null){
	hesEquipmentMaster = (List<Object[]>)map.get("equipmentMaster");
}if (map.get("serviceRequest")!= null){
	serviceRequest = (List<MmServiceRequest>)map.get("serviceRequest");
}if (map.get("msg")!= null){
	msg = (String)map.get("msg");
}

%>
<script>
serverdate = '<%=date+"/"+month+"/"+year%>'
	
	function checkData(){
	var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
	 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
	 if(start<=end){
		 return true;
	 }else{alert("Date is Incorrect.");return false;}
}

</script>
<div class="titleBg">
<h2>Rejected Request</h2>
<%=msg %>
</div>
<form name="search" method="post">
<div class="Block">
	 <label><span>* </span>From Date</label> 
	 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
		<label><span>* </span>To Date</label>
		 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	 <label>Request No.</label> <input type="text"	name="WorkOrderNo" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" class="button" onclick="if(checkData()){submitForm('search', 'maintenance?method=showRejectedRequestJsp')}" value="Search" />
<input type="button" class="button" onclick="if(checkData()){submitForm('search', 'maintenance?method=showRejectedRequestJsp&flag=all')}" value="Show All" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(serviceRequest.size()>0){ %>	
<table>
	<tr><th>S.No.</th><th>Request Date</th><th>Request No</th><th>Priority</th><th>Request Type</th><th>Request By</th><th>Request From</th><th>Remarks</th><th>Status</th><th>Edit</th><th>Cancel</th></tr>
	<% 
		 int  counter=0;
		if (true) { %>
	<% 	for(MmServiceRequest serviceDetail:serviceRequest){
		String requestType="";
		Integer requestId=0;
		if(requestType.equals("P")){requestType="Preventive";}else{requestType="Corrective";}
		if(serviceDetail.getEquipment()!=null){
			requestId=serviceDetail.getEquipment().getId();
		}
		if(serviceDetail.getAmc()!=null){
			requestId=serviceDetail.getAmc().getEpuipment().getId();
		}
	%>
	<input type="hidden" name="requestId" value="<%= serviceDetail.getId()%>" />
	<tr>
	  		<td> <%= counter+1%></td>
			<td><%=serviceDetail.getRequestDate()%></td>
			<td><%=serviceDetail.getServiceRequestNo()%></td>
			<td><%=serviceDetail.getPriority().getCodesName()%></td>
			<td><%=serviceDetail.getRequestType()%></td>
			<td><%=serviceDetail.getLastChgBy().getEmployee().getEmployeeName()%></td>
			<td><%=serviceDetail.getEquipment().getDepartment().getDepartmentName()%></td>
			<td><%=serviceDetail.getRemarks()%></td>
			<td><%=serviceDetail.getRequestStatus().getStatusName()%></td>
			<td><a href='maintenance?method=showCreateServiceRequestDetails&serviceRequestId=<%= serviceDetail.getId()%>&requestId=<%= requestId%>'>Edit</a></td>
			<td><a href="javascript:if(confirm('You want to cancel request.')){window.location.href='maintenance?method=cancelRequest&requestId=<%= serviceDetail.getId()%>'}">Cancel</a></td>
		</tr>    	    
<%		++counter;
				}

	    	}
	%>
</table>
  
 <%}else{ %>
   No Records Available.
 <%} %>
 </div>

