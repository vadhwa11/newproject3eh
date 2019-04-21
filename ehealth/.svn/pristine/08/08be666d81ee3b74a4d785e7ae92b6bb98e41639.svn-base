<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
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
List<String>kfcFormList = new ArrayList<String>();
List<MmServiceRequest>mmServiceRequestList = new ArrayList<MmServiceRequest>();
List<MmMasRequestStatus>mmMasRequestList = new ArrayList<MmMasRequestStatus>();
List<MasEmployee>employeeList = new ArrayList<MasEmployee>();

if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("kfcFormList")!= null){
	kfcFormList = (List)map.get("kfcFormList");
}
if (map.get("mmServiceRequestList")!= null){
	mmServiceRequestList = (List)map.get("mmServiceRequestList");
}
if (map.get("mmMasRequestList")!= null){
	mmMasRequestList = (List)map.get("mmMasRequestList");
}
if (map.get("employeeList")!= null){
	employeeList = (List)map.get("employeeList");
}
String kfcFormNo = "";
if(map.get("kfcFormNo") != null){
	kfcFormNo = (String)map.get("kfcFormNo");
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

</script><script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
if(map.get("message")!=null){
	String message=(String)map.get("message");
	out.print(message);
}	
%>

<div class="titleBg">
<h2>Auction List</h2>
</div>
<div class="clear"></div>
<form name="auctionList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	 <label><span>* </span>Form No</label> 
	<select name="kfcFormNo" id="kfcFormId" onchange="displayAuctionDetail(this.value)" validate ="Form No,string,yes">
	<option value="">Select</option>
	<%if(kfcFormList.size()>0 && kfcFormList != null){
		for(int i=0; i<kfcFormList.size();i++){
		if(((String)kfcFormList.get(i)).equals(kfcFormNo)){
		%>
		<option value="<%=(String)kfcFormList.get(i)%>" selected="selected"><%=(String)kfcFormList.get(i) %></option>
		<%}else{ %>
		<option value="<%=(String)kfcFormList.get(i)%>" ><%=(String)kfcFormList.get(i) %></option>
	<%}}} %>
	</select>
</div>

<div class="Block">
<%if(mmServiceRequestList.size()>0){ %>
<table>
	<tr><th>S.No.</th>
	<th>Request Date</th>
	<th>Equipment Name</th>
	<th>Replacement Value</th>
	<th>Resource Name</th>
	<th>Bidder</th>
	<th>Amount</th>
	<th></th>
	</tr>
	<%
	int k=1;
	
	for(MmServiceRequest mmServiceRequest :mmServiceRequestList){ %>
	
	<tr>
	<td><%=k %></td>
	<td><%=mmServiceRequest.getRequestDate()!= null?HMSUtil.convertDateToStringWithoutTime(mmServiceRequest.getRequestDate()):"" %>
	<input type="hidden" name="mmServiceRequestId<%=k %>" id="mmServiceRequestId" value="<%=mmServiceRequest.getId()!= null?mmServiceRequest.getId():""%>"></td>
	<td><%=mmServiceRequest.getEquipment()!= null?mmServiceRequest.getEquipment().getItem().getNomenclature():"" %></td>
	<td><%=mmServiceRequest.getEquipment()!=null ?mmServiceRequest.getEquipment().getReplacementValue():""%></td>
	<td><%=mmServiceRequest.getResourceUser()!=null ?mmServiceRequest.getResourceUser().getEmployeeName():""%></td>
	<td><input type="text" name="bidder<%=k %>" id="bidder<%=k %>" value=""></td>
	<td><input type="text" name="highestAmount<%=k %>" id="highestAmount<%=k %>" value="<%=(mmServiceRequest.getMaxBidAmount()!=null)? mmServiceRequest.getMaxBidAmount():0.00%>"></td>
	<td><input type="button" onclick="javascript:openPopupWindow('<%=mmServiceRequest.getId()%>','<%=mmServiceRequest.getKfcFormNo()%>','highestAmount<%=k %>','bidder<%=k %>');" value="Add Bids" > </td>
	</tr>	  
	    
<%k++;} %>
 </table>
 <div class="clear"></div> 
 <input	type="hidden" name="count" id="count"	value="<%=k %>"  />
 
<%}else{ %>
No Records Available.
<%} %>
 </div>
<div class="clear"></div> 
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
	
<div class="clear"></div>
<input	type="button" name="Submit" type="submit" value="Submit" class="button" onclick="submitForm('auctionList','maintenance?method=submitAuctionDetails');" />
	<script>
		function displayAuctionDetail(val){
		if(val != 0){
			submitForm('auctionList','maintenance?method=displayAuctionDetail&kfcFormNo='+val);
			
		}	
			
		}
	
		function openPopupWindow(requestId,formNo,highestAmountDiv,highestBidderDiv)
		{
		 var url="/hms/hms/maintenance?method=addPartyDetail&requestId="+requestId+"&formNo="+formNo+"&highestAmountDiv="+highestAmountDiv+"&highestBidderDiv="+highestBidderDiv+"&"+csrfTokenName+"="+csrfTokenValue;
		 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=750,status=1,scrollbars=1,resizable=0");
		}
		
		function setMaxBid(id,value,bidderdivId,bidderdivValue){
			document.getElementById(id).value = value;
			document.getElementById(bidderdivId).value = bidderdivValue;
		}
	
	</script>
	</form>