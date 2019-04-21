
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.util.List"%>

<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
	String approvedBy="NA";
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("mmServiceRequest")!=null){
		mmServiceRequest=(List<MmServiceRequest>)map.get("mmServiceRequest");
	}
	if(mmServiceRequest.get(0).getApprovedBy()!=null){
		approvedBy=mmServiceRequest.get(0).getApprovedBy().getEmployee().getEmployeeName();
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
<form name="mTransferServiceRequest" action="" method="post">

	<div class="titleBg">
	<h2>Feedback Details</h2>
	</div>
	<div class="clear"></div>
	<h4>Equipment Details</h4>
	<div class="Block">
	 	<label>Item Code</label> 
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment().getItem().getPvmsNo()%></label>
	 	<label>Item Name</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment().getItem().getNomenclature()%></label>
	 	<label>Model No</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment().getModelName()%></label>
	 	<div class="clear"></div>
	 	
	 	<label>Serial No</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment().getSerialNo()%></label>
	 	<label>Manufacture</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment().getGrnT().getManufacturer().getManufacturerName()%></label>
	 	<label>Supply Order No</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment()!= null && mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo()!= null?mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoNumber():""%></label>
	 	<div class="clear"></div>
	 	<label>Source Of Supply</label> 
	 	<%if(mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getSupplier()!=null && !"".equalsIgnoreCase(mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getSupplier().getSupplierName())){%>
	 		
	 		<label class="value"><%= mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getSupplier().getSupplierName()%></label>
	 	<%}else{%>
	 		<label class="value">-</label>
	 		
	 	<%}%>
	 	
	 	<label><a href="/hms/hms/maintenance?method=showEquipmentHistory&eqId=<%=mmServiceRequest.get(0).getEquipment().getId()%>"><button type="button">History</button></a></label>
		<label><a href="/hms/hms/maintenance?method=showEquipmentDashBoard&eqId=<%=mmServiceRequest.get(0).getEquipment().getId()%>"><button type="button">DashBoard</button></a></label>
	 	<div class="clear"></div>
	 </div>
	 
    <div class="clear"></div>
	<h4>Request Details</h4>
	<div class="Block">
	 	<label>Request No</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getServiceRequestNo()%></label>
	 	<label>Requested Date</label>
	 	<label class="value"><%= HMSUtil.changeDateToddMMyyyy(mmServiceRequest.get(0).getRequestDate())%></label>
	 	<label>Required Date</label>
	 	<label class="value"><%= HMSUtil.changeDateToddMMyyyy(mmServiceRequest.get(0).getRequiredDate())%></label>
	 	<div class="clear"></div>
	 	
	 	<label>Approved By</label>
	 	<label class="value"><%=approvedBy %></label>
	 	<label>Status</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getRequestStatus().getStatusName()%></label>
	 	<%if(mmServiceRequest.get(0).getCloseDate()!=null){%>
	 	<label>Closure Date</label>
	 	<label class="value"><%= HMSUtil.changeDateToddMMyyyy(mmServiceRequest.get(0).getCloseDate())%></label> 
	 	<%}%> 
	 	<div class="clear"></div>
	 	<div class="division"></div> 
	 	<div class="clear"></div>
	 	<label>Satisfaction</label>
	 	<input type="radio" checked="checked" style="margin: 0px" name="FeedBackSatisfaction" value="Yes" /><label class="value small"> Yes.</label>
	 	<input type="radio" style="margin: 0px"  name="FeedBackSatisfaction" value="No" /><label class="value small"> No.</label>
	 	<div class="clear"></div>
	 	<label><span>* </span>Call Closure</label>
	 	<select name="FeedBackCloser" validate="FeedBackCloser,string,yes">
	 		<option value="">Select</option>
	 		<option value="Most Satisfied">Most Satisfied</option>
	 		<option value="Satisfied">Satisfied</option>
	 		<option value="Needs Improvement">Needs Improvement</option>
	 	</select>
	 	<label>FeedBack Details</label>
	 	<textarea rows="4" cols="50" name="FeedBackRemark"></textarea>
	 </div>
	 <input type="submit" name="submit" class="button" value="Submit" onclick="submitForm('mTransferServiceRequest', 'maintenance?method=submitFeedBack')" />
	 <input type="button" class="button" value="Back" onclick="history.go(-1); return false;" />
	 
	 <input type="hidden" name="requestId" value="<%=mmServiceRequest.get(0).getId() %>" />
	 
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
	 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	