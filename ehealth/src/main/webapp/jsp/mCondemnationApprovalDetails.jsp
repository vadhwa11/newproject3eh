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
<h2>Approved Condemnation</h2>
</div>
<div class="clear"></div>
<h4>Request Details</h4>
<form name="mCondemnationApproved" method="post" action="">
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
	
		 <%if(mmServiceRequest.get(0).getEquipment()!=null  && null !=mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment().getGrnT() ){	%>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getPo().getPoNumber()%></label>
		<%} %> 
		<div class="clear"></div>
		
		<label>Request No</label>
		<label class="value"><%=mmServiceRequest.get(0).getServiceRequestNo()%></label>
		<label>Source Of Supply</label>
		<%if(null !=mmServiceRequest.get(0).getEquipment() && null !=mmServiceRequest.get(0).getEquipment().getGrnT()){ %>
		<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getGrnMaster().getReceiveType() %></label>
		<%}else{ %>
		<label class="value"></label>
		<%} %>
		<label>Purchase Date</label>
		<%if(null !=mmServiceRequest.get(0) &&  mmServiceRequest.get(0).getEquipment()!=null &&  mmServiceRequest.get(0).getEquipment().getGrnT()!=null &&
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
	<label>Value</label>
	<%if(null !=mmServiceRequest.get(0) && null !=mmServiceRequest.get(0).getEquipment() && null !=mmServiceRequest.get(0).getEquipment().getGrnT()){ %>
	<label class="value"><%=mmServiceRequest.get(0).getEquipment().getGrnT().getMrp()%></label>
	<%}else{ %>
	<label class="value"></label>
	<%} %>
	<div class="clear"></div>
</div>
<h4>Condemnation Detail</h4>
<div class="Block">
	<label>Mode Of Disposal</label>
	<select name="CondemnationStatus" onchange="validate(this.value)" validate="CondemnationStatus,string,yes">
	<option value="">Select</option>
	<%for(MmMasRequestStatus mmMasRequestStatus1:mmMasRequestStatus){ %>
		<option value="<%=mmMasRequestStatus1.getStatusCode()%>"><%=mmMasRequestStatus1.getStatusName() %></option>
	<%} %>
	</select>
	<!-- <label>Replacement Value</label>
	<input maxlength="15" validate="Replacement Value,string,yes" name="ReplacementValue" value="" onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;" />
	<span id="error" style="color: Red; display: none">* Input digits (0 - 9)</span> -->
	<!-- Commented by Amit Das on 29-03-2016 -->
	
	<label>Remarks</label>
	<textarea name="CondemnationRemark" id="CondemnationRemark" validate="CondemnationRemark,string,yes" maxlength="200"></textarea>
	
	<div class="clear"></div>
	<input type="hidden" name="requestId" value="<%=mmServiceRequest.get(0).getId()%>" />
	<input type="button" class="button" onclick="submitForm('mCondemnationApproved', '/hms/hms/maintenance?method=submitCondemnationApproved')"  value="Submit" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
	function validate(val){
		document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,yes");
		if(val=="CNDA"){
			document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,no");
		}
		if(val=="CNDR"){
			document.getElementById("CondemnationRemark").setAttribute("validate", "CondemnationRemark,string,yes");
		}
	}
</script>
<script type="text/javascript">
        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        specialKeys.push(46); //For . Value
        function IsNumeric(e) {
            var keyCode = e.which ? e.which : e.keyCode
            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            //document.getElementById("error").style.display = ret ? "none" : "inline";
            return ret;
        }
    </script>