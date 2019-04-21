package jkt.security.masters.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public interface UserMasterDataService {

	public List getHospitalList();

	public List getEmployeeList();

	public List getUserList();

	public List getLoginList(String loginName);

	public List getSelected(String loginName);

	public boolean updateUser(Users users);

	public List getGroupHospitalId(int groupId, int hospitalId);

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital);

	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId);

	public List getListWithUserId(int loginId);

	public List getUserGroupHospList();

	public List getUserName(int userId);

	public List getUserUserGroupHospList(int userId, int userUserGroupHospId);

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital);

	public List getUserUserGroupHospListWithID(int userUserGroupHospId);

	public List getUserUserGroupHospListWithGHID(int id);

	public boolean encryptAllPassword();

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ----------------------------- Users ----------------------------//

	public Map<String, Object> searchUser(Map<String, Object> datamap);

	public Map<String, Object> addUser(Map<String, Object> map);

	public Map<String, Object> showUserJsp(Map<String, Object> map);

	public boolean editUserToDatabase(Map<String, Object> generalMap);

	public boolean deleteUser(int userId, Map<String, Object> generalMap);

	// ------------------- User Group---------------

	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName);

	public Map<String, Object> showUserGroupsJsp();

	public boolean addUserGroups(UserGroups masUserGroup);

	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap);

	public boolean deleteUserGroups(int userGroupId, Map<String, Object> userMap);

	// ------------------- User Group Hospital ---------------

	public Map<String, Object> showUsergroupHospitalJsp();

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital);

	public boolean editUsergroupHospital(Map<String, Object> generalMap);

	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName);

	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap);

	// ------------------- Hospital Master ---------------

/*	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName);*/
	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName, int disId, int instiType);

	public Map<String, Object> showHospitalJsp();

	public boolean addHospital(MasHospital masHospital);

	public boolean editHospitalToDatabase(Map<String, Object> generalMap);

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap);

	// --------------------------- User Hospital Maintenance ---------------

	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap);

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap);

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap);

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap);

	public Map<String, Object> searchUserHospitalMaintenance(String userName);

	public List<Object> getUserGroupForHospital(int hospitalId);

	public Map<String, Object> getGroupHospitalIdFromUsergroupHospital(
			int groupId, int hospitalId);

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap);

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ============================= start of modules by abha
	// =============================
	public List getApplicationList();

	public List getGroupList();

	public List getHospitallistList();

	public boolean addApplication(Map<String, Object> infoMap);

	Map checkForExistingApplication(int groupId, String applicationName);

	public Map<String, Object> getGroupList(Box box);

	Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap);

	public Map<String, Object> searchApplication(String applicationId);

	public boolean updateApplication(Map<String, Object> map);

	public List getApplicationIdList();

	// ---------------- user department ------------
	public Map<String, Object> showUserDepartmentJsp();

	public boolean addUserDepartment(Map<String, Object> generalMap);

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap);

	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName);

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap);

	public boolean editUserDepartment(Map<String, Object> generalMap);

	// add by kalyan
	public Map<String, Object> getEmpName(Map<String, Object> dataMap);

	public Map<String, Object> getSubParentApplication(Map<String, Object> map);

	// end kalyan
	public Map<String, Object> searchUserDepartment(Box box);

	public Map<String, Object> searchUserDepartment(Map<String, Object> map);

	public Map<String, Object> getUrl(Map<String, Object> map);

	public Map<String, Object> getParentApplication(Map<String, Object> map);

	// ===================== Methods Written by Vivek
	// =========================End==========================
	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map);

	public Map showUserApplicationJsp();

	public Map<String, Object> searchUserApplication(String applicationName);

	public boolean editUserApplication(Map<String, Object> generalMap);

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap);

	public boolean addUserApplication(UserApplications userApplications);

	// Added by Kalyan
	public Map<String, Object> showUserList();

	// For User List ---Added by Kalyan
	// ===================== Methods Written by Vivek
	// =========================Start========================

	// =============================methods written by vikas for emp
	// groups=============================
	public Map<String, Object> showGroupsJsp();

	public boolean addEmpGroups(EmpGroups masUserGroup);

	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap);

	public boolean deleteEmpGroups(int empGroupId, Map<String, Object> userMap);

	boolean addUser(Users users, String[] empGroupIdArray, Map generalMap);

	Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName);

	// -------------------------end of methods for emp
	// groups----------------------------

	// =============================methods added by vikas on
	// 29/04/09==========================

	Map<String, Object> showButtonMasterJsp();

	boolean addButtonDetails(MasButtonForm masButtonForm);

	boolean editButtonDetails(Map<String, Object> generalMap);

	boolean deleteButtonDetails(int buttonId, Map<String, Object> generalMap);

	// =================================methods end by
	// vikas=========================================

	Map<String, Object> getUerGroupDetails(Box box);

	boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId);

	// public boolean encryptAllUserPassword();

	public Map<String, Object> showTemplateJsp(Map<String, Object> dataMap);

	public Map<String, Object> addTemplate(MasTemplate masTemplate, Map<String, Object> generalMap);

	public Map<String, Object> editTemplate(Map<String, Object> generalMap);

	public Map<String, Object> searchTemplate(Map<String, Object> dataMap);

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap);

	public Map<String, Object> getButtonList(String formName);

	public List<EmpGroups> getEmpGroupForTemplate();

	public List<MasButtonForm> getFormList();

	public List<MasApplication> getModuleListForTemplate();

	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId);

	public List<MasTemplate> getTemplateList(int hospitalId, int userType);
	//public Map<String, Object> getTemplateModuleList(String templateId, int hospitalId, int userType);
	public Map<String, Object> getTemplateModuleList(Box box);

	public Map<String, Object> getUserList(int empGroup);

	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId);

	public Map<String, Object> populateApplications(String parentId,
			String templateId);

	public boolean submitTemplateWiseApplication(Map<String, Object> datamap);

	public boolean addUserWiseTemplate(Map<String, Object> dataMap);

	public boolean editUserWiseTemplate(Map<String, Object> dataMap);
	
	public Map<String, Object> getTalukList(Map<String, Object> dataMap);
	
	public Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);

	Map<String, Object> showUserAssignedTemplet(Map<String, Object> mapDetails);

	Map<String, Object> addUserWiseTemplateOnly(Map<String, Object> dataMap);

	Map<String, Object> removeTemplateApplicationList(Map<String, Object> removeTemplateMap);

	Map<String, Object> getTemplateAsPerEmpCatList(Map<String, Object> mapDetails);

	public Map<String, Object> getEmployeeCodeDetails(Box box);

	public List<Object[]> getDepartmentList(int hospitalId);
	

	public Map<String, Object> getWardList(Map<String, Object> dataMap);

	public Map<String, Object> getAssemblyList(Map<String, Object> dataMap);

	public Map<String, Object> getVillageList(Map<String, Object> dataMap);
	
	
	public Map<String, Object> getPanchayatList(Map<String, Object> dataMap);

	public Map<String, Object> getLocalityList(Map<String, Object> dataMap);

	
	public Map<String, Object> getHospitalForDisplay(int hospitalId);

	public Map<String, Object> getHospitalWiseTemplate(int hospitalId);

	public List<Object[]> getHospitalListForTemplateApplication(int districtId);

	public List<Object[]> getDistrictList();

	public Map<String, Object> showInstituteWiseAuthorityLevel(int hospitalId);

	public Map<String, Object> saveAuthLevelDetails(int hospitalId,int authLevel, Box box);

	public Map<String, Object> getResponeValueForAuhorizationLevel(int val,int hospitalId);

	public Map<String, Object> updateDataForAuthLevel(int srNo,	String designation, int empId, int headerId, int userId);

	public Map<String, Object> saveDataForAuthLeve(int srNo,String designation, int empId, int headerId, int userId);
	
	public Map<String, Object> showRolMappingJsp(Map<String, Object> dataMap);
	
	public Map<String,Object> addRoleTemplate(Map<String,Object> map);

	public Map<String, Object> checkAppOrderNo(String appOrderNo);
	
	public Map<String, Object> changePasswordForPACS(Box box);
	
	public Map<String, Object> saveChangePasswordFromPACSToEhealth(Users users);
	
	public Map<String, Object> populateLocalityByWardId(Map<String, Object> dataMap);

	public Map<String, Object> searchEmployeeForUserRights(Box box);

	public List<MasHospitalType> getHospitalTypeListForTemplateApplication();

	public Map<String, Object> getEmployeeNameById(Map<String, Object> map1);

	public Map<String, Object> getRoleTemplateList(
			Map<String, Object> detailsMap);

	public List<Object[]> getBsScInstList(int userId);

	public List<MasHospitalType> getHospitalTypeListForPH();
	public Map<String, Object> getUserHospitalByUserId(int userId);
	
	public Map<String, Object> checkForAlreadyAvailableInstituteCode(String hospitalCode);
}
