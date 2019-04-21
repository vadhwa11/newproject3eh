
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
	
%>
<form name="mTransferServiceRequest" action="" method="post">

	<div class="titleBg">
	<h2>Request Details</h2>
	</div>
	<div class="clear"></div>
	<h4>Equipment Details</h4>
	<div class="Block">
	 	<label>Item Code</label> 
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getItem().getPvmsNo():""%></label>
	 	<label>Item Name</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getItem().getNomenclature():""%></label>
	 	<label>Model No</label>
	 	<label class="value"><%= mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getModelName():""%></label>
	 	<div class="clear"></div>
	 	
	 	<label>Serial No</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getSerialNo():""%></label>
	 	<label>Manufacture</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getGrnT().getManufacturer().getManufacturerName():""%></label>
	 	<label>Supply Order No</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo()!=null ? mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoNumber():""%></label>
	 	<div class="clear"></div>
	 	
	 	<label>Source Of Supply</label>
	 	<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getSupplier()!=null ? mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getSupplier().getSupplierName():""%></label>
	 	<label><a href="/hms/hms/maintenance?method=showEquipmentHistory&eqId=<%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getId():""%>">History</a></label>
		<label><a href="/hms/hms/maintenance?method=showEquipmentDashBoard&eqId=<%=mmServiceRequest.get(0).getEquipment()!=null ? mmServiceRequest.get(0).getEquipment().getId():""%>">DashBoard</a></label>
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
	 	<label class="value"><%= mmServiceRequest.get(0)!=null ?mmServiceRequest.get(0).getRequestStatus().getStatusName():""%></label>
	 	<div class="clear"></div> 
	 </div>
	 <input type="button" class="button" value="Back" onclick="history.go(-1); return false;" />
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>