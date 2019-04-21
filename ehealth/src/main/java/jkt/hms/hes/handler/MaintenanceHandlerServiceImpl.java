package jkt.hms.hes.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.hes.dataservice.MaintenanceDataService;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.util.Box;

public class MaintenanceHandlerServiceImpl implements MaintenanceHandlerService{
	MaintenanceDataService maintenanceDataService = null;
	
	public MaintenanceDataService getMaintenanceDataService() {
		return maintenanceDataService;
	}

	public void setMaintenanceDataService(
			MaintenanceDataService maintenanceDataService) {
		this.maintenanceDataService = maintenanceDataService;
	}
	
	@Override
	public Map<String, Object> getDepartment(int hospitalId) {
		return maintenanceDataService.getDepartment(hospitalId);
	}
	
	@Override
	public List<HesEquipmentMaster> getEquipmentList(Map<String, Object> details) {
		return maintenanceDataService.getEquipmentList(details);
	}

	@Override
	public Map<String, Object> getEquipmentDetails(Map<String, Object> details) {
		return maintenanceDataService.getEquipmentDetail(details);
	}
	
	@Override
	public Map<String, Object> saveServiceDetails(Map<String, Object> details) {
		return maintenanceDataService.saveServiceDetails(details);
	}
	
	@Override
	public Map<String, Object> getEquipmentHistory(Map<String, Object> details) {
		return maintenanceDataService.getEquipmentHistory(details);
	}
	
	@Override
	public Map<String, Object> getPendingServiceRequest(
			Map<String, Object> details) {
		return maintenanceDataService.getPendingServiceRequest(details);
	}
	@Override
	public Map<String, Object> getRequestDetails(Map<String, Object> details) {
		return maintenanceDataService.getRequestDetails(details);
	}
	@Override
	public Map<String, Object> saveServiceRequest(Map<String, Object> details) {
		return maintenanceDataService.saveServiceRequest(details);
	}
	
	@Override
	public Map<String, Object> getPendingListOfInspection(
			Map<String, Object> details) {
		return maintenanceDataService.getPendingListOfInspection(details);
	}
	@Override
	public Map<String, Object> getAssignResource(Map<String, Object> details) {
		return maintenanceDataService.getAssignResource(details);
	}
	@Override
	public Map<String, Object> getResourceList(Map<String, Object> details) {
		return maintenanceDataService.getResourceList(details);
	}
	@Override
	public Map<String, Object> getResourceListForConfig(
			Map<String, Object> details) {
		return maintenanceDataService.getResourceListForConfig(details);
	}
	@Override
	public Map<String, Object> saveAssignResource(Map<String, Object> details) {
		return maintenanceDataService.saveAssignResource(details);
	}
	@Override
	public Map<String, Object> showRequestTrackerConfig(
			Map<String, Object> details) {
		return maintenanceDataService.showRequestTrackerConfig(details);
	}
	@Override
	public Map<String, Object> addConfig(Map<String, Object> details) {
		return maintenanceDataService.addConfig(details);
	}
	@Override
	public Map<String, Object> getPendingServiceRequestList(
			Map<String, Object> details) {
		return maintenanceDataService.getPendingServiceRequestList(details);
	}
	@Override
	public Map<String, Object> getInspectionDetails(Map<String, Object> details) {
		return maintenanceDataService.getInspectionDetails(details);
	}
	@Override
	public Map<String, Object> getItemListForAutoComplet(
			Map<String, Object> details) {
		return maintenanceDataService.getItemListForAutoComplet(details);
	}
	@Override
	public Map<String, Object> getSupplierList(Map<String, Object> details) {
		return maintenanceDataService.getSupplierList(details);
	}
	@Override
	public Map<String, Object> submitInspectionReport(
			Map<String, Object> details) {
		return maintenanceDataService.submitInspectionReport(details);
	}
	@Override
	public Map<String, Object> getItemDetail(Map<String, Object> details) {
		return maintenanceDataService.getItemDetail(details);
	}
	@Override
	public Map<String, Object> getPendingServiceServiceOrderList(
			Map<String, Object> details) {
		return maintenanceDataService.getPendingServiceServiceOrderList(details);
	}
	@Override
	public Map<String, Object> getServiceOrderDetails(
			Map<String, Object> details) {
		return maintenanceDataService.getServiceOrderDetails(details);
	}
	@Override
	public Map<String, Object> submitServiceOrderCompletion(
			Map<String, Object> details) {
		return maintenanceDataService.submitServiceOrderCompletion(details);
	}
	@Override
	public Map<String, Object> getTransferServiceRequestList(
			Map<String, Object> details) {
		return maintenanceDataService.getTransferServiceRequestList(details);
	}
	@Override
	public Map<String, Object> getTransferEquipmentDetails(
			Map<String, Object> details) {
		return maintenanceDataService.getTransferEquipmentDetails(details);
	}
	@Override
	public Map<String, Object> submitTransferServiceRequst(
			Map<String, Object> details) {
		return maintenanceDataService.submitTransferServiceRequst(details);
	}
	@Override
	public Map<String, Object> getPreventiveMaintenanceList(
			Map<String, Object> details) {
		return maintenanceDataService.getPreventiveMaintenanceList(details);
	}
	@Override
	public Map<String, Object> addAttachFile(Map<String, Object> details) {
		return maintenanceDataService.addAttachFile(details);
	}
	@Override
	public Map<String, Object> getRequestTrackerList(Map<String, Object> details) {
		return maintenanceDataService.getRequestTrackerList(details);
	}
	@Override
	public Map<String, Object> getRejectedRquest(Map<String, Object> details) {
		return maintenanceDataService.getRejectedRquest(details);
	}
	@Override
	public Map<String, Object> equipmentDashBoard(Map<String, Object> details) {
		return maintenanceDataService.equipmentDashBoard(details);
	}
	@Override
	public Map<String, Object> getRequestTrackerDetail(
			Map<String, Object> details) {
		return maintenanceDataService.getRequestTrackerDetail(details);
	}
	@Override
	public Map<String, Object> getCancelRquest(Map<String, Object> details) {
		return maintenanceDataService.getCancelRquest(details);
	}
	@Override
	public Map<String, Object> getFeedBack(Map<String, Object> details) {
		return maintenanceDataService.getFeedBack(details);
	}
	@Override
	public Map<String, Object> showFeedBackDetails(Map<String, Object> details) {
		return maintenanceDataService.showFeedBackDetails(details);
	}
	@Override
	public Map<String, Object> submitFeedBack(Map<String, Object> details) {
		return maintenanceDataService.submitFeedBack(details);
	}
	@Override
	public Map<String, Object> getFeedBackList(Map<String, Object> details) {
		return maintenanceDataService.getFeedBackList(details);
	}
	@Override
	public Map<String, Object> getCondemnationApprovalList(
			Map<String, Object> details) {
		return maintenanceDataService.getCondemnationApprovalList(details);
	}
	@Override
	public Map<String, Object> getCondemnationList(Map<String, Object> details) {
		return maintenanceDataService.getCondemnationList(details);
	}
	@Override
	public Map<String, Object> approvedCondemnation(Map<String, Object> details) {
		return maintenanceDataService.approvedCondemnation(details);
	}
	@Override
	public boolean submitCondemnationApproved(
			Map<String, Object> details) {
		return maintenanceDataService.submitCondemnationApproved(details);
	}
	@Override
	public Map<String, Object> submitCondemnation(Map<String, Object> details) {
		return maintenanceDataService.submitCondemnation(details);
	}
	@Override
	public Map<String, Object> getPerformanceAnalysisList(
			Map<String, Object> details) {
		return maintenanceDataService.getPerformanceAnalysisList(details);
	}
	@Override
	public Map<String, Object> deleteAttachFile(Map<String, Object> details) {
		return maintenanceDataService.deleteAttachFile(details);
	}

	@Override
	public Map<String, Object> getAllPendingServiceRequest(
			Map<String, Object> details) {
		// TODO Auto-generated method stub
		return  maintenanceDataService.getAllPendingServiceRequest(details);
	}

	@Override
	public Map<String, Object> showAllPendingListOfInspctionJsp(Map<String, Object> details) {
		
		return maintenanceDataService.showAllPendingListOfInspctionJsp(details);
	}

	@Override
	public Map<String, Object> getVendorAddress(Map<String, Object> details) {
		
		return maintenanceDataService.getVendorAddress(details);
	}

	@Override
	public Map<String, Object> showInstituteHeadApproval(Box box) {
		
		return maintenanceDataService.showInstituteHeadApproval(box);
	}

	@Override
	public Map<String, Object> displayEquipmentDetail(Box box) {
		// TODO Auto-generated method stub
		return maintenanceDataService.displayEquipmentDetail(box);
	}

	@Override
	public Map<String, Object> submitInstituteHeadApproval(Box box,Map<String, Object> generalMap) {
		
		return maintenanceDataService.submitInstituteHeadApproval(box,generalMap);
	}
	
	@Override
	public Map<String, Object> approveCondemnationFromDepartment(Box box) {
		
		return maintenanceDataService.approveCondemnationFromDepartment(box);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return maintenanceDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> showAuctionApprovalJsp(Box box) {
		// TODO Auto-generated method stub
		return maintenanceDataService.showAuctionApprovalJsp(box);
	}

	@Override
	public Map<String, Object> displayAuctionDetail(Box box) {
		// TODO Auto-generated method stub
		return maintenanceDataService.displayAuctionDetail(box);
	}

	@Override
	public Map<String, Object> addPartyDetail(Box box) {
		// TODO Auto-generated method stub
		return maintenanceDataService.addPartyDetail(box);
	}

	@Override
	public Map<String, Object> savePartyAuctionDetail(Box box) {
		// TODO Auto-generated method stub
		return maintenanceDataService.savePartyAuctionDetail(box);
	}
	
	@Override
	public Boolean approveCondemnationFromCommitte(Box box) {
		
		return maintenanceDataService.approveCondemnationFromCommitte(box);
	}
	
	@Override
	public Map<String, Object> displayEquipmentDetailForCommitee(Box box) {
		
		return maintenanceDataService.displayEquipmentDetailForCommitee(box);
	}
	
	@Override
	public Map<String, Object> showCommiteeApproval(Box box) {
		
		return maintenanceDataService.showCommiteeApproval(box);
	}
	
	@Override
	public Map<String, Object> getMaxAmountBid(Box box) {
		
		return maintenanceDataService.getMaxAmountBid(box);
	}
	
	@Override
	public Map<String, Object> submitAuctionDetails(Box box) {
		
		return maintenanceDataService.submitAuctionDetails(box);
	}
	
	
	@Override
	public Map<String, Object> submitReauctionDetails(Box box) {
		
		return maintenanceDataService.submitReauctionDetails(box);
	}
	
	@Override
	public Map<String, Object> displayInstitueEmployee(Box box) {
		
		return maintenanceDataService.displayInstitueEmployee(box);
	} 
	
	@Override
	public Map<String, Object> displayInstitues(Box box) {
		
		return maintenanceDataService.displayInstitues(box);
	} 
	
	@Override
	public Map<String, Object> deleteAttachFiles(Map<String, Object> details) {
		
		return maintenanceDataService.deleteAttachFiles(details);
	} 
	
}
