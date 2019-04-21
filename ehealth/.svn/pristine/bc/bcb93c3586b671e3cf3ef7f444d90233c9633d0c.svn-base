<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.util.*"%>

<%
		Map<String ,Object> map = new HashMap<String ,Object>();
		String entryNo = "";
		String userName = "";
		String el="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		List<HesEquipmentMaster> hesEquipmentMaster = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		MmServiceRequest mmServiceRequest = new MmServiceRequest();
		if(request.getAttribute("map")!=null)
		{
			map = (Map<String ,Object>) request.getAttribute("map");
		}
		if (map.get("hesEquipmentMaster")!= null){
			hesEquipmentMaster = (List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
		}
		if (map.get("hesEquipmentAmcDetailsEntry")!= null){
			hesEquipmentAmcDetailsEntry = (List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
		}
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");

		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		}
		if(request.getAttribute("map")!=null)
		{
			map = (Map<String ,Object>) request.getAttribute("map");
		}
		if (map.get("mmServiceRequest")!= null){
			mmServiceRequest = (MmServiceRequest)map.get("mmServiceRequest");
		}
		String approved="N/A";
		if(mmServiceRequest.getApprovedBy()!=null){
			approved=mmServiceRequest.getApprovedBy().getEmployee().getEmployeeName();
		}
%>

<div class="titleBg">
<h2>Transfer Service Request To Another Engineer</h2>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<form name="mServiceRequest" method="post" action="">
<div class="Block">
	
	<div class="clear"></div>
	<%@include file="mEquipmentDetail.jsp" %>
	<div class="clear"></div>
	<label>Request Type</label>
	<label class="value"><%=mmServiceRequest.getRequestType()%></label>
	<label>Priority</label>
	<label class="value"><%=mmServiceRequest.getPriority().getCodesName()%></label>
	<label>Required By Date</label>
	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getRequiredDate())%></label>
	<div class="clear"></div>
	
	<label>Requested By</label>
	<label class="value"><%=mmServiceRequest.getLastChgBy().getEmployee().getEmployeeName()%></label>
	<label>Requested From</label>
	<label class="value"><%=mmServiceRequest.getEquipment().getDepartment().getDepartmentName()%></label>
	<label>Approved By</label>
	<label class="value"><%=approved%></label>
	<div class="clear"></div>
	
	<label>Request Date</label>
	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getRequestDate())%></label>
	<label>Request No</label>
	<label class="value"><%=mmServiceRequest.getServiceRequestNo()%></label>
	<label>Description</label>
	<label class="value"><%=mmServiceRequest.getDescription()%></label>
	<div class="clear"></div>
</div>
<h4>Transfer Detail</h4>
<div class="Block">
	<label>Transfer Details</label>
	<textarea name="TransferDetails" maxlength="200" ></textarea>
	</div>
	<div class="clear"></div>
	<input type="hidden" name="requestId" value="<%=mmServiceRequest.getId()%>" />
	<input type="button" class="button" onclick="submitForm('mServiceRequest', '/hms/hms/maintenance?method=submitTransferServiceRequst')"  value="Submit" />
	<input type="reset"  class="button" value="Reset" />
	<input type="button" onclick="javascript: history.go(-1);" class="button" value="Back" /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>