package jkt.security.masters.handler;

import java.util.ArrayList;
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
import jkt.hms.masters.dataservice.CommonMasterDataService;
import jkt.hms.util.Box;
import jkt.security.masters.dataservice.UserMasterDataService;

@SuppressWarnings("unchecked")
public class UserMasterHandlerServiceImpl implements UserMasterHandlerService {

	List employeeList = null;
	List hospitalList = null;
	List userList = null;
	UserMasterDataService userMasterDataService = null;
	CommonMasterDataService commonMasterDataService = null;
	Map map;

	public List getUserUserGroupHospListWithGHID(int id) {

		return userMasterDataService.getUserUserGroupHospListWithGHID(id);
	}

	public List getUserUserGroupHospListWithID(int userUserGroupHospId) {
		return userMasterDataService
				.getUserUserGroupHospListWithID(userUserGroupHospId);
	}

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital) {

		return userMasterDataService
				.updateUserUsergroupHospital(userUsergroupHospital);
	}

	public List getUserUserGroupHospList(int userId, int userUserGroupHospId) {

		return userMasterDataService.getUserUserGroupHospList(userId,
				userUserGroupHospId);
	}

	public List getUserName(int userId) {

		return userMasterDataService.getUserName(userId);
	}

	public List getUserGroupHospList() {

		return userMasterDataService.getUserGroupHospList();
	}

	public List getListWithUserId(int loginId) {

		return userMasterDataService.getListWithUserId(loginId);
	}

	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId) {

		return userMasterDataService.checkExistOfUserHospMapping(loginId,
				groupHospitalId);
	}

	public List getGroupHospitalId(int groupId, int hospitalId) {

		return userMasterDataService.getGroupHospitalId(groupId, hospitalId);
	}

	public List getLoginList(String loginName) {
		List loginList = new ArrayList();
		loginList = userMasterDataService.getLoginList(loginName);
		return loginList;
	}

	public List getUserList() {

		return userMasterDataService.getUserList();
	}

	public List getSelected(String loginName) {

		return userMasterDataService.getSelected(loginName);
	}

	public List getEmployeeList() {
		employeeList = userMasterDataService.getEmployeeList();
		return employeeList;
	}

	public List getHospitalList() {
		hospitalList = userMasterDataService.getHospitalList();

		return hospitalList;
	}

	public UserMasterDataService getUserMasterDataService() {
		return userMasterDataService;
	}

	public void setUserMasterDataService(
			UserMasterDataService userMasterDataService) {
		this.userMasterDataService = userMasterDataService;
	}

	public boolean updateUser(Users users) {

		return userMasterDataService.updateUser(users);
	}

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital) {
		return userMasterDataService.addUserHosp(userUsergroupHospital);
	}

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// --------------------------------Users-------------------------------------

	public Map<String, Object> addUser(Map<String, Object> map) {
		return userMasterDataService.addUser(map);
	}

	public Map<String, Object> searchUser(Map<String, Object> datamap) {
		return userMasterDataService.searchUser( datamap);
	}

	public Map<String, Object> showUserJsp(Map<String, Object> map) {
		return userMasterDataService.showUserJsp(map);
	}

	public boolean deleteUser(int userId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteUser(userId, generalMap);
	}

	public boolean editUserToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editUserToDatabase(generalMap);
	}

	// ---------------------------------- User Group ------------------

	public boolean addUserGroups(UserGroups masUserGroup) {
		return userMasterDataService.addUserGroups(masUserGroup);
	}

	public boolean deleteUserGroups(int userGroupId, Map<String, Object> userMap) {
		return userMasterDataService.deleteUserGroups(userGroupId, userMap);
	}

	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editUserGroupsToDatabase(generalMap);
	}

	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName) {
		return userMasterDataService.searchUserGroups(userGroupsCode,
				userGroupsName);
	}

	public Map<String, Object> showUserGroupsJsp() {
		return userMasterDataService.showUserGroupsJsp();
	}

	// ---------------------------------- User Group Hospital ------------------

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital) {
		return userMasterDataService.addUsergroupHospital(masUsergroupHospital);
	}

	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUsergroupHospital(
				usergroupHospitalId, generalMap);
	}

	public boolean editUsergroupHospital(Map<String, Object> generalMap) {
		return userMasterDataService.editUsergroupHospital(generalMap);
	}

	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName) {
		return userMasterDataService.searchUsergroupHospital(groupName,
				hospitalName);
	}

	public Map<String, Object> showUsergroupHospitalJsp() {
		return userMasterDataService.showUsergroupHospitalJsp();
	}

	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap) {
		return userMasterDataService.checkForExistingGroupHospital(generalMap);
	}

	// ------------------------------- Hospital Master
	// --------------------------------

	public boolean addHospital(MasHospital masHospital) {
		return userMasterDataService.addHospital(masHospital);
	}

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteHospital(hospitalId, generalMap);
	}

	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		return userMasterDataService.editHospitalToDatabase(generalMap);
	}

	/*public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		return userMasterDataService.searchHospital(hospitalCode, hospitalName);
	}*/
	@Override
	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName, int disId, int instiType) {
		return userMasterDataService.searchHospital(hospitalCode, hospitalName,disId,instiType);
	}

	public Map<String, Object> showHospitalJsp() {
		return userMasterDataService.showHospitalJsp();
	}

	public List getApplicationList() {

		return userMasterDataService.getApplicationList();
	}

	public boolean addApplication(Map<String, Object> infoMap) {

		return userMasterDataService.addApplication(infoMap);
	}

	// --------------------------- User Hospital Maintenance ---------------

	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap) {
		return userMasterDataService.showUserHospitalMaintenanceJsp(generalMap);
	}

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap) {
		return userMasterDataService.addUserHospitalMaintenance(generalMap);
	}

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUserHospitalMaintenance(
				userHospitalMaintenanceId, generalMap);
	}

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap) {
		return userMasterDataService.editUserHospitalMaintenance(generalMap);
	}

	public Map<String, Object> searchUserHospitalMaintenance(String userName) {
		return userMasterDataService.searchUserHospitalMaintenance(userName);
	}

	public List<Object> getUserGroupForHospital(int hospitalId) {
		return userMasterDataService.getUserGroupForHospital(hospitalId);
	}

	public Map<String, Object> getGroupHospitalIdFromUsergroupHospital(
			int groupId, int hospitalId) {
		return userMasterDataService.getGroupHospitalIdFromUsergroupHospital(
				groupId, hospitalId);
	}

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap) {
		return userMasterDataService.checkForExistingHospital(generalMap);
	}

	public List getGroupList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getGroupList();
	}

	public Map checkForExistingApplication(int groupId, String applicationName) {
		// TODO Auto-generated method stub
		return userMasterDataService.checkForExistingApplication(groupId,
				applicationName);
	}

	public Map<String, Object> getGroupList(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.getGroupList(box);
	}

	public Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.getApplicationListByAutocomplete(dataMap);
	}

	public Map<String, Object> searchApplication(String applicationId) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchApplication(applicationId);
	}

	public boolean updateApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.updateApplication(map);
	}

	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	public List getHospitallistList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getHospitallistList();
	}

	public List getApplicationIdList() {
		// TODO Auto-generated method stub
		return userMasterDataService.getApplicationIdList();
	}

	public Map<String, Object> showUserDepartmentJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showUserDepartmentJsp();
	}

	public boolean addUserDepartment(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.addUserDepartment(generalMap);
	}

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.checkForExistingUserDepartment(generalMap);
	}

	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchUserDepartment(userName,
				departmentName);
	}

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteUserDepartment(userDepartmentId,
				generalMap);
	}

	public boolean editUserDepartment(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editUserDepartment(generalMap);
	}

	public Map<String, Object> getEmpName(Map<String, Object> dataMap) {
		return userMasterDataService.getEmpName(dataMap);
	}

	public Map<String, Object> searchUserDepartment(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchUserDepartment(box);
	}

	public Map<String, Object> getApplication(Map<String, Object> map) {
		return userMasterDataService.searchUserDepartment(map);
	}

	public Map<String, Object> getUrl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getUrl(map);
	}

	public Map<String, Object> getParentApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getParentApplication(map);
	}

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ===================== Methods Written by Vivek
	// =========================End==========================

	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map) {
		return userMasterDataService.getApplicationForAutoComplete(map);
	}

	// ----------------User Application-------------------------
	public boolean addUserApplication(UserApplications userApplications) {
		return userMasterDataService.addUserApplication(userApplications);
	}

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap) {
		return userMasterDataService.deleteUserApplication(userApplicationId,
				generalMap);
	}

	public boolean editUserApplication(Map<String, Object> generalMap) {
		return userMasterDataService.editUserApplication(generalMap);
	}

	public Map<String, Object> searchUserApplication(String applicationName) {
		return userMasterDataService.searchUserApplication(applicationName);
	}

	public Map showUserApplicationJsp() {
		return userMasterDataService.showUserApplicationJsp();
	}

	// /////////// ADDED BY KALYAN FOR ADD FORMS///////////////
	public Map<String, Object> getSubParentApplication(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.getSubParentApplication(map);
	}

	public Map<String, Object> showUserList() {
		// TODO Auto-generated method stub
		return userMasterDataService.showUserList();
	}

	// ===================== Methods Written by Vivek
	// =========================Start========================

	// ===============================mthods writen by vikas for emp
	// groups=======================================================

	public Map<String, Object> showGroupsJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showGroupsJsp();
	}

	public boolean addEmpGroups(EmpGroups masUserGroup) {
		// TODO Auto-generated method stub
		return userMasterDataService.addEmpGroups(masUserGroup);
	}

	public Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName) {
		// TODO Auto-generated method stub
		return userMasterDataService.searchEmpGroups(empGroupsCode,
				empGroupsName);
	}

	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editEmpGroupsToDatabase(generalMap);
	}

	public boolean deleteEmpGroups(int empGroupId, Map<String, Object> userMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteEmpGroups(empGroupId, userMap);
	}

	public boolean addUser(Users users, String[] empGroupIdArray, Map generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService
				.addUser(users, empGroupIdArray, generalMap);
	}

	// ---------------------------end of methods for emp
	// groups-------------------------
	// ===============================mthods added by vikas
	// 29/04/09==================================
	public Map<String, Object> showButtonMasterJsp() {
		// TODO Auto-generated method stub
		return userMasterDataService.showButtonMasterJsp();
	}

	public boolean addButtonDetails(MasButtonForm masButtonForm) {
		// TODO Auto-generated method stub
		return userMasterDataService.addButtonDetails(masButtonForm);
	}

	public boolean editButtonDetails(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.editButtonDetails(generalMap);
	}

	public boolean deleteButtonDetails(int buttonId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return userMasterDataService.deleteButtonDetails(buttonId, generalMap);
	}

	public Map<String, Object> getUerGroupDetails(Box box) {
		// TODO Auto-generated method stub
		return userMasterDataService.getUerGroupDetails(box);
	}

	public boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId) {
		// TODO Auto-generated method stub
		return userMasterDataService.addUser(users, empGroupIdArray,
				appGroupIdArray, generalMap, hospitalId);
	}

	public boolean encryptAllPassword() {
		// TODO Auto-generated method stub
		return userMasterDataService.encryptAllPassword();
	}

	/*
	 * public boolean encryptAllUserPassword() { // TODO Auto-generated method
	 * stub return userMasterDataService.encryptAllUserPassword(); }
	 */

	// ====================================methods End by
	// vikas================================================
	public Map<String, Object> showTemplateJsp(Map<String, Object> dataMap) {
		return userMasterDataService.showTemplateJsp(dataMap);
	}

	public Map<String, Object> addTemplate(MasTemplate masTemplate, Map<String, Object> generalMap) {
		return userMasterDataService.addTemplate(masTemplate, generalMap);
	}

	public Map<String, Object> editTemplate(Map<String, Object> generalMap) {
		return userMasterDataService.editTemplate(generalMap);
	}

	public Map<String, Object> searchTemplate(Map<String, Object> dataMap) {
		return userMasterDataService.searchTemplate(dataMap);
	}

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap) {
		return userMasterDataService.deleteTemplate(templateId, generalMap);
	}

	public Map<String, Object> getButtonList(String formName) {
		return userMasterDataService.getButtonList(formName);
	}

	public List<EmpGroups> getEmpGroupForTemplate() {
		return userMasterDataService.getEmpGroupForTemplate();
	}

	public List<MasButtonForm> getFormList() {
		return userMasterDataService.getFormList();
	}

	public List<MasApplication> getModuleListForTemplate() {
		return userMasterDataService.getModuleListForTemplate();
	}

	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId) {
		return userMasterDataService.getTemplateApplicationList(templateId,
				hospitalId);
	}

	public List<MasTemplate> getTemplateList(int hospitalId, int userType) {
		return userMasterDataService.getTemplateList(hospitalId, userType);
	}

	public Map<String, Object> getTemplateModuleList(Box box) {
		return userMasterDataService.getTemplateModuleList(box);
	}

	public Map<String, Object> getUserList(int empGroup) {
		return userMasterDataService.getUserList(empGroup);
	}

	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId) {
		return userMasterDataService.getUsersListFromUserTemplate(templateId,
				empGroupId);
	}

	public Map<String, Object> populateApplications(String parentId,
			String templateId) {
		return userMasterDataService.populateApplications(parentId, templateId);
	}

	public boolean submitTemplateWiseApplication(Map<String, Object> datamap) {
		return userMasterDataService.submitTemplateWiseApplication(datamap);
	}

	public boolean addUserWiseTemplate(Map<String, Object> dataMap) {
		return userMasterDataService.addUserWiseTemplate(dataMap);
	}

	public boolean editUserWiseTemplate(Map<String, Object> dataMap) {
		return userMasterDataService.editUserWiseTemplate(dataMap);
	}

	@Override
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		return userMasterDataService.getTalukList(dataMap);
	}

	@Override
	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {
		return userMasterDataService.checkForExistingMasters(generalMap);
	}
	
	@Override
	public Map<String, Object> showUserAssignedTemplet(Map<String, Object> mapDetails) {
		return userMasterDataService.showUserAssignedTemplet(mapDetails);
	}
	@Override
	public Map<String, Object> addUserWiseTemplateOnly(Map<String, Object> dataMap) {
		return userMasterDataService.addUserWiseTemplateOnly(dataMap);
	}
	
	@Override
	public Map<String, Object> getTemplateAsPerEmpCatList(Map<String, Object> mapDetails) {
		return userMasterDataService.getTemplateAsPerEmpCatList(mapDetails);
	}
	@Override
	public Map<String, Object> removeTemplateApplicationList(Map<String, Object> removeTemplateMap) {
		return userMasterDataService.removeTemplateApplicationList(removeTemplateMap) ;
	}

	@Override
	public Map<String, Object> getEmployeeCodeDetails(Box box) {
		return userMasterDataService.getEmployeeCodeDetails(box);
	}

	@Override
	public Map<String, Object> getWardList(Map<String, Object> dataMap) {
		return userMasterDataService.getWardList(dataMap);
	}

	@Override
	public Map<String, Object> getAssemblyList(Map<String, Object> dataMap) {
		return userMasterDataService.getAssemblyList(dataMap);
	}

	@Override
	public Map<String, Object> getVillageList(Map<String, Object> dataMap) {
		return userMasterDataService.getVillageList(dataMap);
	}

	@Override
	public Map<String, Object> getPanchayatList(Map<String, Object> dataMap) {
		return userMasterDataService.getPanchayatList(dataMap);
	}

	@Override
	public Map<String, Object> getLocalityList(Map<String, Object> dataMap) {
		return userMasterDataService.getLocalityList(dataMap);
	}

	@Override
	public Map<String, Object> getHospitalForDisplay(int hospitalId) {
		return userMasterDataService.getHospitalForDisplay(hospitalId);
	}


	@Override
	public List<Object[]> getDepartmentList(int hospitalId) {
		return userMasterDataService.getDepartmentList(hospitalId);
	}

	@Override
	public Map<String, Object> getHospitalWiseTemplate(int hospitalId) {
		return userMasterDataService.getHospitalWiseTemplate(hospitalId);
	}

	@Override
	public List<Object[]> getHospitalListForTemplateApplication(int districtId) {
		return userMasterDataService.getHospitalListForTemplateApplication(districtId);
	}

	@Override
	public List<Object[]> getDistrictList() {
		return userMasterDataService.getDistrictList();
	}

	@Override
	public Map<String, Object> showInstituteWiseAuthorityLevel(int hospitalId) {
		return userMasterDataService.showInstituteWiseAuthorityLevel(hospitalId);
	}

	@Override
	public Map<String, Object> saveAuthLevelDetails(int hospitalId,int authLevel, Box box) {
		return userMasterDataService.saveAuthLevelDetails(hospitalId,authLevel, box);
	}

	@Override
	public Map<String, Object> getResponeValueForAuhorizationLevel(int val,int hospitalId) {
		return userMasterDataService.getResponeValueForAuhorizationLevel(val,hospitalId);
	}

	@Override
	public Map<String, Object> updateDataForAuthLevel(int srNo,String designation, int empId, int headerId, int userId) {
		return userMasterDataService.updateDataForAuthLevel( srNo, designation,  empId,  headerId,  userId);
	}

	@Override
	public Map<String, Object> saveDataForAuthLeve(int srNo,String designation, int empId, int headerId, int userId) {
		return userMasterDataService.saveDataForAuthLeve( srNo, designation,  empId,  headerId,  userId);
	}

	@Override
	public Map<String, Object> showRolMappingJsp(Map<String, Object> dataMap) {
		return userMasterDataService.showRolMappingJsp(dataMap);

	}

	@Override
	public Map<String, Object> addRoleTemplate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMasterDataService.addRoleTemplate(map);
	}

	@Override
	public Map<String, Object> checkAppOrderNo(String appOrderNo) {
		return userMasterDataService.checkAppOrderNo(appOrderNo);
	}
	@Override
	public Map<String, Object> changePasswordForPACS(Box box) {
		return userMasterDataService.changePasswordForPACS(box);
	}
	@Override
	public Map<String, Object> saveChangePasswordFromPACSToEhealth(Users users){
		return userMasterDataService.saveChangePasswordFromPACSToEhealth(users);
	}
	@Override
	public Map<String, Object> populateLocalityByWardId(Map<String, Object> dataMap){
		return userMasterDataService.populateLocalityByWardId(dataMap);
		
	}

	@Override
	public Map<String, Object> searchEmployeeForUserRights(Box box) {
		return userMasterDataService.searchEmployeeForUserRights(box);
	}

	@Override
	public List<MasHospitalType> getHospitalTypeListForTemplateApplication() {
		return userMasterDataService.getHospitalTypeListForTemplateApplication();
	}

	@Override
	public Map<String, Object> getEmployeeNameById(Map<String, Object> map1) {
		return userMasterDataService.getEmployeeNameById(map1);
	}

	@Override
	public Map<String, Object> getRoleTemplateList(
			Map<String, Object> detailsMap) {
		return userMasterDataService.getRoleTemplateList(detailsMap);
	}

	@Override
	public List<Object[]> getBsScInstList(int userId) {
		return userMasterDataService.getBsScInstList( userId);
	}

	@Override
	public List<MasHospitalType> getHospitalTypeListForPH() {
		return userMasterDataService.getHospitalTypeListForPH();
	}

	@Override
	public Map<String, Object> getUserHospitalByUserId(int userId) {
		return userMasterDataService.getUserHospitalByUserId(userId);
	}

	@Override
	public Map<String, Object> checkForAlreadyAvailableInstituteCode(String hospitalCode){
		return userMasterDataService.checkForAlreadyAvailableInstituteCode(hospitalCode);
	}
}
