package jkt.hms.login.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;

public interface LoginHandlerService {

	// Methods by Ritu

	Map<String, Object> getHospitalName(String loginName, String password, String ipAddress);

	List<Object> getExistingUser(String loginName, String password);

	// Set getApplication(Users user, int hospitalId);

	// End of Methods by Ritu

	@SuppressWarnings("unchecked")
	List getDepartmentList(Map map);

	String getDepartmentName(int deptId);

	// method written by vikas

	Set getApplications(Users user, int hospitalId);

	Map<String, Object> getSetupParameterMap(Map<String, Object> dataMap);

	/** method by abha * */
	public String getDepartmentTypeCode(int deptId);

	List<Object> getNoticeMessage();

	//List<HrMasFinancialYear> getCurrentFinancialYear();


	Map<String, Object> getBranchList(int departmentId, String userName);

	Map<String, Object> showCommunicationJsp(Map<String, Object> mapCom);

	Map<String, Object> getDepartmentDetails(Map<String, Object> deptMap);

	Object getBranchName(int branchId);

	Map<String, Object> saveUserLog(Map<String, Object> mapUserLog);

	Map<String, Object> getTelephoneDirectory();

	List<HrMasFinancialYear> getCurrentFinancialYear();

	List<Object[]> getLastLoginDetails(int userId);

	Map<String, Object> updateLastLoginDetails(Box box);

	List<MasStoreFinancial> getCurrentFinancialYearForAccount();

	Map<String, Object> getLoginHospitalName(int hospitalId);

	boolean updateLoginDateTime(int userId);

	int getHospitalType(int hospitalId);

	int getAuthLevel(int hospitalId);

	int employeeLevel(int userId);	

	List<Object> getExistingOtherUser(String loginName, String password,String userType);

	void updateLogoutDetail(Box box);
	
	Map<String, Object> checkForBlockedAccount(String loginName);
	
	void freeCounterOnSessionTimeout(Map<String, Object> map);
	
	void removeVisitUptoOnSessionTimeout(Map<String, Object> map);
	
	void reassignPatientsToDoctor(Box box);
}