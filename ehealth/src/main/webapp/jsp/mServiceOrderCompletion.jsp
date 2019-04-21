<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.MmPreventiveCheckList"%>
<%@page import="jkt.hms.masters.business.MmPreventiveCheckListDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%-- <%@page import="org.apache.poi.hssf.record.formula.eval.MultiplyEval"%> --%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
<%@page import="jkt.hms.masters.business.MmInspectionReport"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" language="javascript">
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
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmInspectionReport> mmInspectionReports=new ArrayList<MmInspectionReport>();
		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
		List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		if(request.getAttribute("map")!=null){
			map=(Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("mmInspectionReport")!=null){
			mmInspectionReports=(List<MmInspectionReport>)map.get("mmInspectionReport");
		}
		if(map.get("mmSafetyProcedureMaterials")!=null){
			mmSafetyProcedureMaterials=(List<MmSafetyProcedureMaterials>)map.get("mmSafetyProcedureMaterials");
		}
		if(map.get("hesEquipmentAmcDetailsEntry")!=null){
			hesEquipmentAmcDetailsEntry=(List<HesEquipmentAmcDetailsEntry>)map.get("hesEquipmentAmcDetailsEntry");
		}
		if(map.get("hesEquipmentMaster")!=null){
			hesEquipmentMaster=(List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
		}
		if(map.get("mmMasRequestStatus")!=null){
			mmMasRequestStatus=(List<MmMasRequestStatus>)map.get("mmMasRequestStatus");
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
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<div class="titleBg">
<h2>Service Order Completion</h2>
</div>
<div class="clear"></div>

<form name="mServiceOrderCompletion" method="post" >
<%for(MmInspectionReport mmInspectionReport:mmInspectionReports){ 
	String workOrderNo="";
    String workOrderDate="";
		if(mmInspectionReport.getPoDetail()!=null)
			workOrderNo=mmInspectionReport.getPoDetail().getPo().getPoNumber();
		if(mmInspectionReport.getPoDetail()!=null)
			workOrderDate=HMSUtil.changeDateToddMMyyyy(mmInspectionReport.getPoDetail().getPo().getPoDate());
		String approvedBy="N/A";
				if(mmInspectionReport.getRequest().getApprovedBy()!=null){
					approvedBy=mmInspectionReport.getRequest().getApprovedBy().getEmployee().getEmployeeName();
				}
%>
<div class="Block">
	<%@include file="mEquipmentDetail.jsp" %>
	<div class="clear"></div>
	
	<label>Request Type</label>
	<label class="value"><%=mmInspectionReport.getRequest().getRequestType()%></label>
	<label>Priority</label>
	<label class="value"><%=mmInspectionReport.getRequest().getPriority().getCodesName()%></label>
	<label>Approved By</label>
	<label class="value"><%=approvedBy%></label>
	<div class="clear"></div>
	
	<label>Requested By</label>
	<label class="value"><%=mmInspectionReport.getRequest().getLastChgBy().getEmployee().getEmployeeName()%></label>
	<label>Requested From</label>
	<label class="value"><%=mmInspectionReport.getRequest().getEquipment().getDepartment().getDepartmentName()%></label>
	<label>Description Of Work</label>
	<label class="value"><%=mmInspectionReport.getDescriptionOfWork()%></label>
	<div class="clear"></div>
	
	 <div class="division"></div>
	<label>Vendor Name</label>
	<label class="value"><%=mmInspectionReport.getVendor().getSupplierName()%></label>
	<label>Work Order No</label>
	<label class="value"><%=workOrderNo%></label>
	<label>Work Order Date</label>
	<label class="value"><%=workOrderDate%></label>
	<div class="clear"></div>
	
	<div class="Block">
	<input type="hidden" id="ServiceRequestId" name="ServiceRequestId" value="<%=mmInspectionReport.getRequest().getId()%>" />
	<input type="hidden" name="equipmentId" value="<%=mmInspectionReport.getRequest().getEquipment().getId()%>" />
	<div class="clear"></div>
	<%
	if(!status.equalsIgnoreCase("None")){
	if(mmInspectionReport.getRequest().getRequestType().equalsIgnoreCase("Preventive")){ 
		Integer preventiveCycle=0;
		Integer completedCycle=0;
		Integer preventiveCycleNo=0;
		int month1=0;
		
		String preventiveDueDate="";
		Calendar  instaletionDate= Calendar.getInstance();
		if(mmInspectionReport.getRequest().getEquipment()!=null){
			if(mmInspectionReport.getRequest().getEquipment().getPreventiveCycle()!=null)
			preventiveCycle=mmInspectionReport.getRequest().getEquipment().getPreventiveCycle();
			if(mmInspectionReport.getRequest().getEquipment().getPreventiveCompletedCycle()!=null)
			completedCycle=mmInspectionReport.getRequest().getEquipment().getPreventiveCompletedCycle();
			
			instaletionDate.setTime(mmInspectionReport.getRequest().getEquipment().getDateOfInstallation());
		}
		if(mmInspectionReport.getRequest().getAmc()!=null){
// 			preventiveCycle=mmServiceRequest.getAmc().getPreventiveCycle();
// 			completedCycle=mmServiceRequest.getAmc().getPreventiveCompletedCycle();
// 			instaletionDate=mmServiceRequest.getAmc().getAmcWarrentyStartDate();
		}
		
		preventiveCycleNo=preventiveCycle-completedCycle;
		if(preventiveCycle!=0){
			month1=(12/preventiveCycle)*(completedCycle+1);
		}
		instaletionDate.set(Calendar.MONTH, month1);
		int m=instaletionDate.get(Calendar.MONTH);
		int d=instaletionDate.get(Calendar.DAY_OF_MONTH);
		if(instaletionDate!=null){
			preventiveDueDate=instaletionDate.get(Calendar.DAY_OF_MONTH)+"/"+instaletionDate.get(Calendar.MONTH)+"/"+instaletionDate.get(Calendar.YEAR);
		}
		String preventiveDonOn=date+"/"+month+"/"+year;
		if(mmInspectionReport.getPreventiveDoneOn()!=null){
			preventiveDonOn=sdf.format(mmInspectionReport.getPreventiveDoneOn());
		}
	%>
	<div class="division"></div>
	<label>Preventive Due Date</label>
	<label class="value"><%=preventiveDueDate %></label>
	<label>Preventive Done On</label>
	<input id="PreventiveDoneOn" class="date" type="text" maxlength="30" readonly="readonly" value="<%=preventiveDonOn%>" name="PreventiveDoneOn">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mServiceOrderCompletion.PreventiveDoneOn,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	<%if(mmPreventiveCheckList.size()!=0){ %>
	<table style="width: 220px"><tr><th></th><th>Check List</th></tr>
	<% for(MmPreventiveCheckList mmPreventiveCheckLists:mmPreventiveCheckList){
			String checkedStatus="";
			if(mmPreventiveCheckListDetails.size()!=0){
				for(MmPreventiveCheckListDetails preventiveDetail:mmPreventiveCheckListDetails){
					if(preventiveDetail.getCheckList().getId()==mmPreventiveCheckLists.getId()){
						checkedStatus="checked='checked'";
					}
				}
			}
		
		%>
			<tr><td><input type="checkbox" <%=checkedStatus %>  name="checkList" validate="ItemName,string,yes" value="<%=mmPreventiveCheckLists.getId() %>" /><input type="hidden" name="AllCheckList" value="<%=mmPreventiveCheckLists.getId() %>" /></td><td><%=mmPreventiveCheckLists.getCheckListName() %></td></tr>
	<%} %>
		</table>
		<%}}} %>
</div>
	
    <div class="clear"></div>
	<label><span>* </span>Work Order Status</label>
	<select name="WorkOrderStatus" validate="WorkOrderStatus,string,yes">
			<option value="">Select</option>
			<%for(MmMasRequestStatus status2:mmMasRequestStatus){
				if(mmInspectionReport.getRequestStatus().getStatusCode().equalsIgnoreCase(status2.getStatusCode()) || mmInspectionReport.getRequestStatus().getStatusCode().equalsIgnoreCase(status2.getStatusCode())){
				%>
			<option value="<%=mmInspectionReport.getRequestStatus().getId() %>" selected><%=mmInspectionReport.getRequestStatus().getStatusName() %></option>
			<%}else{ %>
			<option value="<%=status2.getId() %>" ><%=status2.getStatusName() %></option>
			<%}} %>
<!-- 			<option value="Awaiting Materials">Awaiting Materials</option> -->
<!-- 			<option vaue="Partially Close">Partially Close</option> -->
<!-- 			<option value="Closed">Closed</option> -->
<!-- 			<option value="On Progress">On Progress</option> -->
	</select>
	<label>Closed Date</label>
	<input id="mlcDateId" class="date" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="closeDate">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mServiceOrderCompletion.closeDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	<label>Remark</label>
	<textarea rows="5" name="WORemark" cols="30"></textarea>
	<div class="clear"></div>
	
	<div class="clear"></div>
    <div class="division"></div>
    
    <label>Material Requirement</label>
<!--     <input class="buttonAdd" type="button" onclick="addRow();" style="margin-left: 70px" value="" name="add"> -->
    <input class="buttonDel" type="button" onclick="return deleteRow();" value="" name="delete">
    <table style="width: 75%" id='spm'>
    	<tr><th></th><th>Item Code</th><th>Item Name</th><th>Quantity</th><th>Rate</th><th>Cost</th><!-- <th>Remark</th> --></tr>
    	<%for(MmSafetyProcedureMaterials mmSafetyProcedureMaterial:mmSafetyProcedureMaterials){ 
    		BigDecimal price=mmSafetyProcedureMaterial.getItem().getCostPrice();
    		BigDecimal req=	mmSafetyProcedureMaterial.getRequiredQty();
    	%>
    	<tr><td><input type='checkbox' value='' name='check' /><input type="hidden" name="SafetyProcedureMaterialId" readonly="readonly" value="<%=mmSafetyProcedureMaterial.getId() %>" style='width: 100px' /></td>
    	<td><input type='text' readonly="readonly" value="<%=mmSafetyProcedureMaterial.getItem().getPvmsNo() %>" style='width: 100px' /></td>
    	<td><input type='text' readonly="readonly" value="<%=mmSafetyProcedureMaterial.getItem().getNomenclature() %>" style='width: 100px' /></td>
    	<td><input type='text' readonly="readonly" value="<%=mmSafetyProcedureMaterial.getRequiredQty() %>" style='width: 100px' /></td>
    	<td><!-- <input type='text' name="ModelNo" value="" style='width: 100px' /> --><%=mmSafetyProcedureMaterial.getItem().getCostPrice() %></td>
    	<td><!-- <input name="SerialNo" type='text' style='width: 100px' /> --><%= price.multiply(req).setScale(2) %></td>
    	<!-- <td><input type='text' name="ItemRemark" style='width: 100px' /></td> -->
    	</tr>
    	<%} %>
    </table>
    
    <div class="clear"></div>
    <div class="division"></div>
    <label><span>* </span>Service Report No</label>
    <input type="text" name="ServiceReportNo" validate="ServiceReportNo,string,yes" value="<%=mmInspectionReport.getServiceReportNo()!=null?mmInspectionReport.getServiceReportNo():""%>"/>
    <label><span>* </span>Service Report Date</label>
    <input id="serviceReportDate" class="date" validate="ServiceReportDate,string,yes" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="ServiceReportDate">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mServiceOrderCompletion.ServiceReportDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
    <label>Service Cost</label>
	<input type="text" name="WOPlannedCast" value="<%=mmInspectionReport.getServiceCost()%>"/>
	<div class="clear"></div>
	<label><span>* </span>Challan No.</label>
	<input type="text" name="WOChallanNo" validate="WOChallanNo,string,yes" value="<%=mmInspectionReport.getWoChallanNo()!=null?mmInspectionReport.getWoChallanNo():""%>"/>
	<label><span>* </span>Challan Date</label>
    <input id="challanDate" class="date" validate="ChallanDate,string,yes" type="text" maxlength="30" readonly="readonly" value="<%=date+"/"+month+"/"+year%>" name="ChallanDate">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.mServiceOrderCompletion.ChallanDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	<label>Material Cost</label>
	<input type="text" name="WOChallanAmount" validate="WOChallanAmount,string,yes" onkeydown="return isNumber(event)" value="<%=mmInspectionReport.getMaterialCost()%>"/>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<input type="hidden" name="InspectionReportId" value="<%= mmInspectionReport.getId()%>" />
	<input type="hidden" name="ServiceRequestId" value="<%= mmInspectionReport.getRequest().getId()%>" />
	<input type="submit"  onclick="return submitForm('mServiceOrderCompletion', '/hms/hms/maintenance?method=submitServiceOrderCompletion');" class="button" value="Submit" name="submit" />
	<input type="reset" class="button"  />
</div>
<%} %>

<script>
function addRow(){
	var table=document.getElementById("spm");
	var row=table.rows.length;
	var tr=table.insertRow(row);
	var data= tr.innerHTML="<td><input type='checkbox' value='' name='check' /></td><td><input type='text' style='width: 100px' /></td><td><input type='text' style='width: 100px' /></td><td><input type='text' style='width: 100px' /></td><td></td><td></td>";
}
function deleteRow(){
	var flag=true;
	var table=document.getElementById("spm");
	var ch=document.getElementsByName("check");
	for(var i=0;i<ch.length;i++){
		if(ch.length>=2){
			if(ch[i].checked==true){
				table.deleteRow(i+1);
			}
		}else{
			alert("Can not delete all rows")
			flag= false;
		}
	}
	return flag;
}

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
</script>
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