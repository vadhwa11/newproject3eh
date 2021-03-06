<%@page import="jkt.hms.util.HMSUtil"%>
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
String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
Map<String ,Object> map = new HashMap<String ,Object>();
String msg="";
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
}
if (map.get("msg")!= null){
	msg = (String)map.get("msg");
}

%>
<script>
serverdate = '<%=date+"/"+month+"/"+year%>'
	
	function checkData(){
		var start= new Date(document.getElementById("fromDate").value);
		 var end= new Date(document.getElementById("toDate").value);
		 if(start<=end){
			 return true;
		 }else{alert("Date is Incorrect.");return false;}
}

</script>
<%=msg %>
<div class="titleBg">
<h2>Service Request Feedback</h2>
</div>
<form name="mFeedBack" method="post">
<div class="Block">
	 <label><span>* </span>From Date</label> 
	 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate"validate="From Date,date,yes">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
		<label><span>* </span>To Date</label>
		 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate" validate="To Date,date,yes">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	  <label>Request No.</label> <input type="text"	name="WorkOrderNo" value="" MAXLENGTH="30" id="adNo" validate="Request No,alphanumeric,no" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" class="button" value="Search" onclick="submitForm('mFeedBack', 'maintenance?method=showServiceRequestFeedBack')" />
<input type="button" class="button" value="Show All" onclick="submitForm('mFeedBack', 'maintenance?method=showServiceRequestFeedBack&flag=all')" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(serviceRequest.size()>0){ %>
<table>
	<tr><th>S.No.</th><th>Request Date</th><th>Request No</th><th>Priority</th><th>Request Type</th><th>Request By</th><th>Request From</th><th>Remarks</th><th>Status</th></tr>

	<% 
		 int  counter=0;
		if (true) { %>
	<% 	for(MmServiceRequest serviceDetail:serviceRequest){
		String requestType="";
		String remark="";
		if(requestType.equals("P")){requestType="Preventive";}else{requestType="Corrective";}
		if(serviceDetail.getRemarks()!=null)
			remark=serviceDetail.getRemarks();
	%>
	<form name="mFeedBack<%=counter %>" method="post">
	<input type="hidden" name="requestId" value="<%= serviceDetail.getId()%>" />
	<tr onclick="submitForm('mFeedBack<%=counter %>', 'maintenance?method=showRequestFeedBack')">
			<td><%= counter+1%></td>
			<td><%=HMSUtil.changeDateToddMMyyyy(serviceDetail.getRequestDate())%></td>
			<td><%=serviceDetail.getServiceRequestNo()%></td>
			<td><%=serviceDetail.getPriority().getCodesName()%></td>
			<td><%=serviceDetail.getRequestType()%></td>
			<td><%=serviceDetail.getLastChgBy().getEmployee().getEmployeeName()%></td>
			<td><%=serviceDetail.getEquipment().getDepartment().getDepartmentName()%></td>
			<td><%=remark%></td>
			<td><%=serviceDetail.getRequestStatus().getStatusName()%></td>
	</tr>	  
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">	
	</form>  	    
<%		++counter;
				}
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
	<div class="paddingTop5"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
 