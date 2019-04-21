package jkt.hrms.leave.handler;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.leave.dataservice.LeaveDetailsDataService;
import jkt.hrms.masters.business.Holidaycalendar;
import jkt.hrms.masters.business.HrEmployeeBalance;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrEncashmentDetails;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrMasLeave;
import jkt.hrms.masters.business.HrMasLeaveType;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLeaveTypeNew;
import jkt.hrms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hrms.util.LeaveManagementUtil;

public class LeaveDetailsHandlerServiceImpl implements
		LeaveDetailsHandlerService {
	private LeaveDetailsDataService leaveDataService = null;

	public List getLeaveTypeList() {
		List leaveTypeList = leaveDataService.getLeaveTypeList();
		return leaveTypeList;
	}

	public Map leaveRecord(int leaveId) {
		Map detailsMap = leaveDataService.leaveRecord(leaveId);
		return detailsMap;
	}

	public List getRestrictedHolidays() {
		List restrictedHolidaysList = leaveDataService.getRestrictedHolidays();
		return restrictedHolidaysList;
	}

	public List getHolidays() {
		List holidaysList = leaveDataService.getHolidays();
		return holidaysList;
	}

	public List getManager(int userId) {
		List mgr = leaveDataService.getManager(userId);
		return mgr;
	}

	public List getManagers() {
		List managersList = leaveDataService.getManagers();
		return managersList;
	}

	public void submitLeaveForm(HrLeaveDetails leave, int userId,
			String applierId) {
		leaveDataService.submitLeaveForm(leave, userId, applierId);
	}

	public List getWaitingLeavesList(MasEmployee user,int hospitalId) {
		List waitingLeavesList = leaveDataService.waitingLeavesList(user,hospitalId);
		return waitingLeavesList;
	}

	public List getApprovedLeavesList(MasEmployee user) {
		List approvedLeavesList = leaveDataService.approvedLeavesList(user);
		return approvedLeavesList;
	}

	public List getDisapprovedLeavesList(MasEmployee user) {
		List disapprovedLeavesList = leaveDataService
				.disapprovedLeavesList(user);
		return disapprovedLeavesList;
	}

	public List getLeavesList(int empId) {
		List leaveList = leaveDataService.getLeaveList(empId);
		return leaveList;
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId) {
		List<HrEmployeeBalanceNew> balance = leaveDataService
				.getLeaveBalance(empId);
		return balance;
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId,
			String leaveType) {
		List<HrEmployeeBalanceNew> balance = leaveDataService.getLeaveBalance(
				empId, leaveType);
		return balance;
	}

	public void sendSuggestion(MasEmployee user,
			String suggestionMessage,Box box) {
		leaveDataService.sendSuggestion(user, suggestionMessage,box);
	}

	public void approveLeaves(MasEmployee user, String remarks,Box box) {
		leaveDataService.approveLeaves(user, remarks,box);
	}
	public Map<String,Object> recomendLeaves(String[] approve, MasEmployee user, String remarks,String recommend,String recommendRemarks,Box box) {
		return leaveDataService.recomendLeaves(approve, user, remarks,recommend,recommendRemarks,box);
	}
	
	public void disapproveLeaves(MasEmployee user,
			String disapproveMessage,Box box) {
		leaveDataService.disapproveLeaves(user, disapproveMessage,box);
	}

	public void deleteLeaves(String[] delete, MasEmployee user,
			String deleteMessage) {
		leaveDataService.deleteLeaves(delete, user, deleteMessage);
	}

	public List getEmpNamesList(int userId) {
		List empNamesList = leaveDataService.getempNamesList(userId);
		return empNamesList;
	}

	public LeaveDetailsDataService getLeaveDataService() {
		return leaveDataService;
	}

	public void setLeaveDataService(LeaveDetailsDataService leaveDataService) {
		this.leaveDataService = leaveDataService;
	}

	public int getRH(List<HrLeaveDetails> leaveList, String startDuration,
			String endDuration) throws IOException, ParseException {
		Properties properties = LeaveManagementUtil
				.loadProperyFile("holiday.properties");
		int rhCode = Integer.parseInt(properties.get("RestrictedHoliday")
				.toString());
		Date startDate = HMSUtil.dateFormatterDDMMYYYY(properties.getProperty(
				startDuration).toString());
		Date endDate = HMSUtil.dateFormatterDDMMYYYY(properties.getProperty(
				endDuration).toString());
		int restrictedHoliday = 1;
		for (HrLeaveDetails details : leaveList) {
			if (details.getLeaveType().getId() == rhCode
					&& details.getLeaveStatus().getId() == 2) {
				Date fromDate = details.getFromDate();
				if (LeaveManagementUtil.compareDates(fromDate, startDate) >= 0
						&& LeaveManagementUtil.compareDates(fromDate, endDate) < 0) {
					restrictedHoliday--;
				}
			}
		}
		return restrictedHoliday;
	}

	public Map getEmpLeaveDetails(int empId) {
		Map empLeaveDeatils = leaveDataService.getEmpLeaveDetails(empId);
		return empLeaveDeatils;
	}

	public void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory,
			String newLeaveBalance, String newOnsiteUkBalance, int empId,
			String balanceAdjustedBy) {
		leaveDataService.updateLeaveBalance(leaveHistory, newLeaveBalance,
				newOnsiteUkBalance, empId, balanceAdjustedBy);
	}

	public Map getEmailId(int hrId, int empId) {
		Map adminEmailIdList = leaveDataService.getEmailId(hrId, empId);
		return adminEmailIdList;
	}

	public List viewLeaveHistory(int empId) {
		List leaveHistoryList = leaveDataService.viewLeaveHistory(empId);
		return leaveHistoryList;
	}

	public List getRhAvailed(MasEmployee user) {
		List availedRhList = leaveDataService.getAvailedRhList(user);
		return availedRhList;
	}

	public List getBirthdayLeave(int empId) {
		List birthdayLeaveList = leaveDataService.getBirthdayLeave(empId);
		return birthdayLeaveList;
	}

	public List getAnniversaryLeave(int empId) {
		List anniversaryLeaveList = leaveDataService.getAnniversaryLeave(empId);
		return anniversaryLeaveList;
	}

	public List getPaternityLeave(int empId) {
		List paternityLeaveList = leaveDataService.getPaternityLeave(empId);
		return paternityLeaveList;
	}

	public List getWaitingEncashmentLeave(MasEmployee user) {
		List encashmentLeaveWaiting = leaveDataService
				.getWaitingEncashmentLeave(user);
		return encashmentLeaveWaiting;
	}

	public MasEmployee getMemberDetails(int memberId) {
		MasEmployee memberDetail = leaveDataService.getMemberDetails(memberId);
		return memberDetail;
	}

	public List getAllWaitingLeavesForHR(int eid) {
		List allWaitingLeavesList = leaveDataService
				.getAllWaitingLeavesForHR(eid);
		return allWaitingLeavesList;
	}

	public List getLeaveStatusList() {
		List leaveStatusList = leaveDataService.getLeaveStatusList();
		return leaveStatusList;
	}

	public List<HrLeaveDetails> getLeavesList(Integer id, String fromDate,
			String toDate, String leaveType, String leaveStatus) {
		List<HrLeaveDetails> leaveDetailsList = leaveDataService.getLeavesList(
				id, fromDate, toDate, leaveType, leaveStatus);
		return leaveDetailsList;
	}

	public void submitLeaveForm(List<HrLeaveDetails> optionalleaveList,
			int userId, String applierId) {
		leaveDataService.submitLeaveForm(optionalleaveList, userId, applierId);

	}
	public Map<String, Object> getUserDetails(int userId){
		return leaveDataService.getUserDetails(userId);
	}

	public Map getAddOrEdit(MasEmployee user) {
		return leaveDataService.getAddOrEdit(user);
	}

	public List getMasLeaveTypeList() {
		return leaveDataService.getMasLeaveTypeList();
	}

	public List getMasLeaveTypeList(int leaveType) {
		return leaveDataService.getMasLeaveTypeList(leaveType);
	}

	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType) {
		leaveDataService.submitTypeMaster(hrMasLeaveType);
	}

	public List getMasLeaveTypeListForId(int id) {
		return leaveDataService.getMasLeaveTypeListForId(id);
	}

	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType) {
		leaveDataService.updateTypeMaster(hrMasLeaveType);
	}

	public List getEncashableMasLeaveType(int empId) {
		return leaveDataService.getEncashableMasLeaveType(empId);
	}

	public void applyForEncashment(HrEncashmentDetails encashmentDetails) {
		leaveDataService.applyForEncashment(encashmentDetails);
	}

	public void saveEmployeeLeaveBalanceHistory(
			HrEmployeeBalance employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalanceHistory(employeeBalance);
	}

	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalance(employeeBalance);
	}

	public void disapproveLeavesEncashment(String[] disapprove,
			MasEmployee user, String disapproveMessage) {
		leaveDataService.disapproveLeavesEncashment(disapprove, user,
				disapproveMessage);
	}

	public void approveLeavesEncashment(String[] approve, MasEmployee user,
			String remarks) {
		leaveDataService.approveLeavesEncashment(approve, user, remarks);
	}

	public void onHoldEncashment(String[] suggestion, MasEmployee user,
			String suggestionMessage) {
		leaveDataService.onHoldEncashment(suggestion, user, suggestionMessage);
	}

	public List getApprovedLeavesEncashment(MasEmployee user) {
		List approvedLeavesList = leaveDataService
				.getApprovedLeavesEncashment(user);
		return approvedLeavesList;
	}

	public List getDisapprovedLeavesEncashment(MasEmployee user) {
		List disapprovedLeavesList = leaveDataService
				.getDisapprovedLeavesEncashment(user);
		return disapprovedLeavesList;
	}

	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId,
			String fromDate, String toDate, String leaveType, String leaveStatus) {
		List<HrEncashmentDetails> leaveDetailsList = leaveDataService
				.getLeavesEncashmentList(userId, fromDate, toDate, leaveType,
						leaveStatus);
		return leaveDetailsList;
	}

	public void deleteLeavesEncashment(String[] delete, MasEmployee user,
			String deleteMessage) {
		leaveDataService.deleteLeavesEncashment(delete, user, deleteMessage);
	}

	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType) {
		leaveDataService.submitTypeMasterNew(hrMasLeaveType);
	}

	public List getMasLeaveTypeNewList(int leaveType) {
		return leaveDataService.getMasLeaveTypeNewList(leaveType);
	}

	public List getMasLeaveTypeNewForMaxDate(int leaveType, Date maxDate) {
		return leaveDataService
				.getMasLeaveTypeNewForMaxDate(leaveType, maxDate);
	}

	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew) {
		leaveDataService.updateLeaveTypeMasterNew(hrMasLeaveTypeNew);
	}

	public List getMasLeaveTypeNewList() {
		return leaveDataService.getMasLeaveTypeNewList();
	}

	public List getMasLeaveTypeMediatorList() {
		return leaveDataService.getMasLeaveTypeMediatorList();
	}

	public void saveToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		leaveDataService.saveToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator);
	}

	public void updateToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		leaveDataService.updateToHrMasLeaveTypeMediator(hrMasLeaveTypeMediator);
	}

	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance) {
		leaveDataService.saveEmployeeLeaveBalanceNew(employeeBalance);
	}

	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType) {
		return leaveDataService
				.getMasLeaveTypeNewMinFromDateForLeaveType(leaveType);
	}

	public List getTodayApprovedLeavesList(MasEmployee user) {
		return leaveDataService.getTodayApprovedLeavesList(user);
	}

	public void updateLeavePolicy() {
		// TODO Auto-generated method stub
		leaveDataService.updateLeavePolicy();
	}

	public void updateLeaveBalanceMonthly() {
		// TODO Auto-generated method stub
		leaveDataService.updateLeaveBalanceMonthly();
	}

	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID) {
		// TODO Auto-generated method stub
		return leaveDataService.getCurrentPolicy(hrMasLeaveTypeMediatorID);
	}

	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return leaveDataService.getConnectionForReport();
	}

	public  Map<String, Object> getEmpPersonalDeatil(int uid) {
		// TODO Auto-generated method stub
		return leaveDataService.getEmpPersonalDeatil(uid);
	}

	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return leaveDataService.getLeaveListJsp(generalMap);
	}

	public Map<String, Object> getUserDetails(Map<String, Object> generalMap) {
		return leaveDataService.getUserDetails(generalMap);
	}

	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap) {
		return leaveDataService.showEmpForDept(generalMap);
	}

	public Map<String, Object> getPersonalDetailsPatMatDetails(
			Map<String, Object> generalMap) {
		return leaveDataService.getPersonalDetailsPatMatDetails(generalMap);
	}

	// Start Leave Master Added by Ramdular 14/04/2011 ++++++++++++++++++++++++

	public Map<String, Object> showLeaveJsp() {
		return leaveDataService.showLeaveJsp();
	}

	public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
		return leaveDataService.addLeave(hrMasLeave);
	}

	public Map<String, Object> editLeave(Map<String, Object> generalMap) {
		return leaveDataService.editLeave(generalMap);
	}

	public Map<String, Object> searchLeave(String desription) {
		return leaveDataService.searchLeave(desription);
	}

	public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
		return leaveDataService.deleteLeave(generalMap);
	}

	public Map<String, Object> showHolidayMasterJsp() {

		return leaveDataService.showHolidayMasterJsp();
	}

	public Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar) {

		return leaveDataService.addHolidayMaster(holidaycalendar);
	}

	public Map<String, Object> editHolidayMaster(Map<String, Object> generalMap) {

		return leaveDataService.editHolidayMaster(generalMap);
	}

	public Map<String, Object> deleteHolidayMaster(
			Map<String, Object> generalMap) {

		return leaveDataService.deleteHolidayMaster(generalMap);
	}

	public Map<String, Object> searchHolidayMaster(String name, String year) {

		return leaveDataService.searchHolidayMaster(name, year);
	}
	
	@Override
	public List<MasEmployee> getEmployeeOfSameDepartment(int empId,int deptId) {
		return leaveDataService.getEmployeeOfSameDepartment(empId,deptId);
	}

	@Override
	public List<Object[]> getUploadDataList(Map<String, Object> mapForDs) {
		return leaveDataService.getUploadDataList(mapForDs);
	}

	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		
		return leaveDataService.getDocumentList(uploadedDocumentId);
	}
		
	

	// End Leave Master Added by Ramdular 14/04/2011
	// -------------------------------

}
