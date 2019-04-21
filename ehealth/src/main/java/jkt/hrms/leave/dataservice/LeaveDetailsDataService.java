package jkt.hrms.leave.dataservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.Box;
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

public interface LeaveDetailsDataService {
	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap);

	public Map<String, Object> getEmpPersonalDeatil(int uid);

	List getLeaveTypeList();

	void submitLeaveForm(HrLeaveDetails leave, int userId, String applierId);

	List waitingLeavesList(MasEmployee user,int hospitalId);

	List approvedLeavesList(MasEmployee user);

	List disapprovedLeavesList(MasEmployee user);

	List getLeaveList(int empId);

	void approveLeaves(MasEmployee user, String remarks,Box box);
	
	Map<String,Object> recomendLeaves(String[] approve, MasEmployee user, String remarks,String recommend,String recommendRemarks, Box box);

	void disapproveLeaves(MasEmployee user, String disapproveMessage,
			Box box);

	public void disapproveLeavesEncashment(String[] disapprove,
			MasEmployee user, String disapproveMessage);

	List getempNamesList(int userId);

	void sendSuggestion(MasEmployee user, String suggestionMessage,
			Box box);

	List<HrEmployeeBalanceNew> getLeaveBalance(int empId);

	List<HrEmployeeBalanceNew> getLeaveBalance(int empId, String leaveType);

	List getManager(int userId);

	List getRestrictedHolidays();

	List getHolidays();

	Map getEmpLeaveDetails(int empId);

	List getManagers();

	void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory,
			String newLeaveBalance, String newOnsiteUkBalance, int empId,
			String balanceAdjustedBy);

	Map getEmailId(int hrId, int empId);

	List viewLeaveHistory(int empId);

	Map leaveRecord(int leaveId);

	List getAvailedRhList(MasEmployee user);

	List getBirthdayLeave(int empId);

	List getAnniversaryLeave(int empId);

	List getPaternityLeave(int empId);

	List getWaitingEncashmentLeave(MasEmployee user);

	void deleteLeaves(String[] delete, MasEmployee user, String deleteMessage);

	MasEmployee getMemberDetails(int memberId);

	List getAllWaitingLeavesForHR(int eid);

	List getIdsToSendMail();

	List getLeaveStatusList();

	List<HrLeaveDetails> getLeavesList(Integer id, String fromDate,
			String toDate, String leaveType, String leaveStatus);

	void submitLeaveForm(List<HrLeaveDetails> optionalleaveList, int userId,
			String applierId);
	public Map<String, Object> getUserDetails(int userId);

	public Map getAddOrEdit(MasEmployee user);

	public List getMasLeaveTypeList();

	public List getMasLeaveTypeList(int leaveType);

	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType);

	public List getMasLeaveTypeListForId(int id);

	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType);

	public List getEncashableMasLeaveType(int empId);

	public void applyForEncashment(HrEncashmentDetails encashmentDetails);

	public void saveEmployeeLeaveBalanceHistory(
			HrEmployeeBalance employeeBalance);

	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance);

	public void approveLeavesEncashment(String[] approve, MasEmployee user,
			String remarks);

	public void onHoldEncashment(String[] suggestion, MasEmployee user,
			String suggestionMessage);

	public List getApprovedLeavesEncashment(MasEmployee user);

	public List getDisapprovedLeavesEncashment(MasEmployee user);

	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId,
			String fromDate, String toDate, String leaveType, String leaveStatus);

	public void deleteLeavesEncashment(String[] delete, MasEmployee user,
			String deleteMessage);

	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType);

	public List getMasLeaveTypeNewForMaxDate(int leaveType, Date maxDate);

	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew);

	public List getMasLeaveTypeNewList(int leaveType);

	public List getMasLeaveTypeNewList();

	public List getMasLeaveTypeMediatorList();

	public void saveToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator);

	public void updateToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator);

	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance);

	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType);

	public List getTodayApprovedLeavesList(MasEmployee user);

	public void updateLeavePolicy();

	public void updateLeaveBalanceMonthly();

	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID);

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> getUserDetails(Map<String, Object> generalMap);

	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap);

	public Map<String, Object> getPersonalDetailsPatMatDetails(
			Map<String, Object> generalMap);

	// Start Leave Master Added by Ramdular 14/04/2011 ++++++++++++++++++++++++

	Map<String, Object> showLeaveJsp();

	Map<String, Object> addLeave(HrMasLeave hrMasLeave);

	Map<String, Object> editLeave(Map<String, Object> generalMap);

	Map<String, Object> deleteLeave(Map<String, Object> generalMap);

	Map<String, Object> searchLeave(String desription);

	Map<String, Object> showHolidayMasterJsp();

	Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar);

	Map<String, Object> editHolidayMaster(Map<String, Object> generalMap);

	Map<String, Object> deleteHolidayMaster(Map<String, Object> generalMap);

	Map<String, Object> searchHolidayMaster(String name, String year);
	
	List<MasEmployee> getEmployeeOfSameDepartment(int empId, int deptId);

	public List<Object[]> getUploadDataList(Map<String, Object> mapForDs);

	public List<UploadDocuments> getDocumentList(int uploadedDocumentId);

	// End Leave Master Added by Ramdular 14/04/2011 ----------------------

}
