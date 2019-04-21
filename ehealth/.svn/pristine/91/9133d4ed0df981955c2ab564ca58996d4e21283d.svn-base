<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
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

Map<String ,Object> map = new HashMap<String ,Object>();
String msg="";
List<PrqQuotationHeader> serviceRequest = new ArrayList<PrqQuotationHeader>();
if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("headers")!= null){
	serviceRequest = (List<PrqQuotationHeader>)map.get("headers");
}
if (map.get("msg")!= null){
	msg = (String)map.get("msg");
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
<%=msg %>
<div class="titleBg">
<h2>Pending List for Negotiation</h2>
</div>
<form name="mFeedBack" method="post">
<div class="Block">
	 <label><span>* </span>From Date</label> 
	 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="fromDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
		<label><span>* </span>To Date</label>
		 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="toDate">
	 <img width="16" height="16" border="0" onclick="javascript:setdate('',document.mFeedBack.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	  <label>Quotation No.</label> <input type="text"	name="QuotationNo" value="" MAXLENGTH="30" id="QuotationNo" />

<input type="button" class="button" value="Search" onclick="if(checkData()){submitForm('mFeedBack', 'procurement?method=showPendingListNegotiation')}"; />
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="Block">
<%if(serviceRequest.size()>0){ %>	
<table>
	  <tr><th>S.No</th><th>Date</th><th>Quotation Requisation no.</th><th> Quotation requisation By</th><th>Quotation Requisation Approved By</th></tr>
        <% int sn=1;
        for(PrqQuotationHeader mmServiceRequest:serviceRequest){ %>
        
        <tr onclick="submitForm('pendingList<%=sn %>', 'procurement?method=getItemListForNegotiation')" style="cursor: pointer;"><td><%=sn %>
        <form name="pendingList<%=sn %>" method="post">
        <input type="hidden" name="requitionId" value="<%=mmServiceRequest.getId()%>" />
        
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
        
        </td><td><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getQuotationDate()) %></td>
        <td><%=mmServiceRequest.getQuotationNo() %></td>
        <td><%= mmServiceRequest.getQuotationBy().getEmployee().getEmployeeName()%></td>
        <td><%= mmServiceRequest.getQuotationBy().getEmployee().getEmployeeName()%></td> </tr>
        <% sn++;} %>
	</tr>	
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">  		    

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

	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>

	
	