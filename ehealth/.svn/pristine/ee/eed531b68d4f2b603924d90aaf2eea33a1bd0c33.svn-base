package jkt.hms.hes.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.util.Box;

public interface MaintenanceHandlerService {
	
	Map<String, Object> getDepartment(int hospitalId);
	List<HesEquipmentMaster> getEquipmentList(Map<String, Object> details);
	Map<String, Object> getEquipmentDetails(Map<String, Object> details);
	Map<String, Object> saveServiceDetails(Map<String, Object> details);
	Map<String, Object> getEquipmentHistory(Map<String, Object> details);
	Map<String, Object> getPendingServiceRequest(Map<String, Object> details);
	Map<String, Object> getRequestDetails(Map<String, Object> details);
	Map<String, Object> saveServiceRequest(Map<String, Object> details);
	Map<String, Object> getPendingListOfInspection(Map<String, Object> details);
	Map<String, Object> getAssignResource(Map<String, Object> details);
	Map<String, Object> getResourceList(Map<String, Object> details);
	Map<String, Object> getResourceListForConfig(Map<String, Object> details);
	Map<String, Object> saveAssignResource(Map<String, Object> details);
	Map<String, Object> getPendingServiceRequestList(Map<String, Object> details);
	Map<String, Object> getInspectionDetails(Map<String, Object> details);
	Map<String, Object> getItemListForAutoComplet(Map<String, Object> details);
	Map<String, Object> getSupplierList(Map<String, Object> details);
	Map<String, Object> submitInspectionReport(Map<String, Object> details);
	Map<String, Object> getItemDetail(Map<String, Object> details);
	Map<String, Object> getPendingServiceServiceOrderList(Map<String, Object> details);
	Map<String, Object> getServiceOrderDetails(Map<String, Object> details);
	Map<String, Object> submitServiceOrderCompletion(Map<String, Object> details);
	Map<String, Object>  getTransferServiceRequestList(Map<String, Object> details);
	Map<String, Object>  getTransferEquipmentDetails(Map<String, Object> details);
	Map<String, Object>  submitTransferServiceRequst(Map<String, Object> details);
	Map<String, Object>  getPreventiveMaintenanceList(Map<String, Object> details);
	Map<String, Object>  addAttachFile(Map<String, Object> details);
	Map<String, Object>  getRequestTrackerList(Map<String, Object> details);
	Map<String, Object>  getRejectedRquest(Map<String, Object> details);
	Map<String, Object>  equipmentDashBoard(Map<String, Object> details);
	Map<String, Object>  getRequestTrackerDetail(Map<String, Object> details);
	Map<String, Object>  getCancelRquest(Map<String, Object> details);
	Map<String, Object>  getFeedBack(Map<String, Object> details);
	Map<String, Object>  showFeedBackDetails(Map<String, Object> details);
	Map<String, Object>  submitFeedBack(Map<String, Object> details);
	Map<String, Object>  getFeedBackList(Map<String, Object> details);
	Map<String, Object> getCondemnationApprovalList(Map<String, Object> details);
	Map<String, Object>  getCondemnationList(Map<String, Object> details);
	Map<String, Object>  approvedCondemnation(Map<String, Object> details);
	boolean  submitCondemnationApproved(Map<String, Object> details);
	Map<String, Object>  submitCondemnation(Map<String, Object> details);
	Map<String, Object>  getPerformanceAnalysisList(Map<String, Object> details);
	Map<String, Object>  deleteAttachFile(Map<String, Object> details);
	Map<String, Object> getAllPendingServiceRequest(Map<String, Object> details);
	Map<String, Object> showRequestTrackerConfig(Map<String, Object> details);
	Map<String, Object> addConfig(Map<String, Object> details);
	Map<String, Object> showAllPendingListOfInspctionJsp(
			Map<String, Object> details);
	Map<String, Object> getVendorAddress(Map<String, Object> details);
	Map<String, Object> showInstituteHeadApproval(Box box);
	Map<String, Object> displayEquipmentDetail(Box box);
	Map<String, Object> submitInstituteHeadApproval(Box box, Map<String, Object> generalMap);
	Map<String, Object> approveCondemnationFromDepartment(Box box);
	Map<String, Object> getConnectionForReport();
	Map<String, Object> showAuctionApprovalJsp(Box box);
	Map<String, Object> displayAuctionDetail(Box box);
	Map<String, Object> addPartyDetail(Box box);
	Map<String, Object> savePartyAuctionDetail(Box box);
	Boolean approveCondemnationFromCommitte(Box box);
	Map<String, Object> displayEquipmentDetailForCommitee(Box box);
	Map<String, Object> showCommiteeApproval(Box box);
	Map<String, Object> getMaxAmountBid(Box box);
	Map<String, Object> submitAuctionDetails(Box box);
	Map<String, Object> submitReauctionDetails(Box box);
	Map<String, Object> displayInstitueEmployee(Box box);
	Map<String, Object> displayInstitues(Box box);
	Map<String, Object>  deleteAttachFiles(Map<String, Object> details);
	
}
