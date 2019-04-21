<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript">
	function checkForValidSubmission(){
		var serviceCount = document.getElementById('serviceCount').value;
		var flag = false;
		for(var i=0;i<serviceCount;i++){
			if(document.getElementById('requestCheck'+i).checked){
				flag = true;
				break;
			}
		}
		if(!flag)
			alert("Select at least one item to approve !");
		
		return flag;
	}
</script>


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

String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
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
<%
if(map.get("message")!=null){
	String message=(String)map.get("message");
	out.print(message);
}	
%>
<div class="titleBg">
<h2>Waiting For Department Approval For Condemnation</h2>
</div>
<form name="mFeedBack" method="post">
<div class="Block">
	 <label><span>* </span>From Date</label> 
	 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
		<label><span>* </span>To Date</label>
		 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	  <label>Request No.</label> <input type="text"	name="RequestId" value="" MAXLENGTH="30" id="adNo" />
	  <div class="clear"></div>
	  <label>Item Name</label> <input type="text"	name="ItemName" value="" MAXLENGTH="30" id="ItemName" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" class="button" value="Search" onclick="if(checkData()){submitForm('mFeedBack', 'maintenance?method=showCondemnationApproval')}" />
<!-- <input type="button" class="button" value="Show All" onclick="if(checkData()){submitForm('mFeedBack', 'maintenance?method=showCondemnationApproval&flag=all')}" /> -->
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Block">
<%if(serviceRequest.size()>0){ %>
<form name="mCondemnation" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<table>
	<tr><th> </th><th>S.No.</th><th>Request Date</th><th>Request No</th><th>Item Name</th></tr>
	
	<% 
		 int  counter=0;
		if (true) { %>
	<% 	for(MmServiceRequest serviceDetail:serviceRequest){
	%>
	<tr>
			<td><input type="checkbox" id="requestCheck<%=counter%>" name="requestCheck<%=counter%>">
			    <input type="hidden" name="serviceDetailId<%=counter%>" value="<%=serviceDetail.getId()%>" > </td>
			<td><%= counter+1%></td>
			<td><%=HMSUtil.changeDateToddMMyyyy(serviceDetail.getRequestDate())%></td>
			<td><%=serviceDetail.getServiceRequestNo()%></td>
			<td><%=serviceDetail.getEquipment().getItem().getNomenclature()%></td>
	</tr>	    
<%		++counter;
				}

	    	}
	%>
 </table>
 
 <input type="hidden" name="serviceCount" value="<%=counter%>" id="serviceCount">
 <input type="button" value="Approve" onclick="if(checkForValidSubmission()){submitForm('mCondemnation', 'maintenance?method=approveCondemnationFromDepartment')}">
 
  <%}else{ %>
   No Records Available.
 <%} %>
 	  
	</form>  
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
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
	
	