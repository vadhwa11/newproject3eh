<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.util.*"%>
<%
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		List<MmServiceRequest> mmServiceRequest = new ArrayList<MmServiceRequest>();
		List<MmMasRequestStatus> mmMasRequestStatus = new ArrayList<MmMasRequestStatus>();
		if(request.getAttribute("map")!=null)
		{
			map = (Map<String ,Object>) request.getAttribute("map");
		}
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String currentTime = (String)utilMap.get("currentTime");

		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		}
		if (map.get("mmServiceRequest")!= null){
			mmServiceRequest = (List<MmServiceRequest>)map.get("mmServiceRequest");
		}
		if (map.get("mmMasRequestStatus")!= null){
			mmMasRequestStatus = (List<MmMasRequestStatus>)map.get("mmMasRequestStatus");
		}
		
%>

<div class="titleBg">
<h2>Condemnation Details</h2>
</div>
<div class="clear"></div>
<h4>Equipment Details</h4>
<form name="mCondemnation" method="post" action="">
<div class="Block">
	
	<div class="clear"></div>
	<label>Item Code</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getItem().getPvmsNo() %></label>
		<label>Item Name</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getItem().getNomenclature() %></label>
		<label>Model No</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getModelName() %></label>
		<div class="clear"></div>
		
		<label>Serial No</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getSerialNo() %></label>
		<label>Manufacture</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getManufacturer().getManufacturerName() %></label>
		<label>Supply Order No</label>
		 <%if(null !=mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment() && null !=mmServiceRequest.get(0).getEquipment().getGrnT() 
		 && mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo()!=null &&
		 	!"".equalsIgnoreCase(mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoNumber())){	%>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoNumber()%></label>
		<%} %> 
		<div class="clear"></div>
		
		<label>Request No</label>
		<label class="value"><%=mmServiceRequest.get(0).getServiceRequestNo()%></label>
		<label>Source Of Supply</label>
		<%if(null !=mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment() && null !=mmServiceRequest.get(0).getEquipment().getGrnT() && null !=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getReceiveType()){ %>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getReceiveType() %></label>
		<%} %>
		<label>Purchase Date</label>
		<%if(null !=mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment() && null!=mmServiceRequest.get(0).getEquipment().getGrnT() && mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo()!=null &&
		 mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoDate()!=null){	%>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoDate()) %></label>
		<%} %> 
		<div class="clear"></div>
		<label>Request Type</label>
		<label class="value"><%=mmServiceRequest.get(0).getRequestType()%></label>
		<label>Priority</label>
		<label class="value"><%=mmServiceRequest.get(0).getPriority().getCodesName()%></label>
		<label>Required By Date</label>
		<label class="value"><%=mmServiceRequest.get(0).getRequiredDate()%></label>
		<div class="clear"></div>
	
		<label>Requested By</label>
		<label class="value"><%=mmServiceRequest.get(0).getLastChgBy().getEmployee().getEmployeeName()%></label>
		<label>Requested From</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getDepartment().getDepartmentName()%></label>
		<label>Request Date</label>
		<label class="value"><%=mmServiceRequest.get(0).getRequestDate()%></label>
		<div class="clear"></div>
		
		<label>Description</label>
		<textarea readonly="readonly"><%=mmServiceRequest.get(0).getDescription()%></textarea>
		<%if(mmServiceRequest.get(0).getCondemnApprovelRemarks()!=null){ %>
		<label>Condemnation Approval</label>
		<textarea readonly="readonly"><%=mmServiceRequest.get(0).getDescription()%></textarea>
		<%}if(mmServiceRequest.get(0).getRemarks()!=null){ %>
		<label>Remarks</label>
		<textarea readonly="readonly"><%=mmServiceRequest.get(0).getRemarks()%></textarea>
		<%} %>
	<div class="clear"></div>
	
	<%if(null != mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment() && null !=mmServiceRequest.get(0).getEquipment().getGrnT() && mmServiceRequest.get(0).getEquipment().getGrnT().getMrp()!=null){ %>
		<label>Value</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getMrp()%></label>
		<%} %>
		<% if(mmServiceRequest.get(0).getEquipment().getReplacementValue()!=null){ %>
		<label>Replacement Value</label>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getReplacementValue()%></label>
		<%} %>
	<div class="clear"></div>
</div>
<h4>Condemnation Detail</h4>
<div class="Block">
	<label>Remarks</label>
	<textarea name="CondemnationRemark" id="CondemnationRemark" validate="CondemnationRemark,string,yes" maxlength="200"></textarea>
	
	<div class="clear"></div>
	<input type="hidden" name="requestId" value="<%=mmServiceRequest.get(0).getId()%>" />
	<input type="button" class="button" onclick="submitForm('mCondemnation', '/hms/hms/maintenance?method=submitCondemnation')"  value="Submit" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
	function validate(val){
		document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,yes");
		if(val=="CND"){
			document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,no");
		}
		if(val=="CNDR"){
			document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,yes");
		}
	}
</script>