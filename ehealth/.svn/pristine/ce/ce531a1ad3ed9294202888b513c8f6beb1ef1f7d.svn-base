/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LoginHandlerServiceImpl.java 
 * Purpose of the class - This is for Login. 
 * Tables Used: mas_hospital, mas_application, users 
 * @author  Create Date: July 2007  Name: Ritu Sahu 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 **/

package jkt.hms.login.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.login.dataservice.LoginDataService;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hrms.masters.business.HrMasFinancialYear;

public class LoginHandlerServiceImpl implements LoginHandlerService {

	private LoginDataService loginDataService = null;

	// Methods by Ritu

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalName(String loginName, String password, String ipAddress) {
		return loginDataService.getHospitalName(loginName, password, ipAddress);
	}

	public List<Object> getExistingUser(String loginName, String password) {
		return loginDataService.getExistingUser(loginName, password);
	}

	/*
	 * @SuppressWarnings("unchecked") public Set getApplication(Users user, int
	 * hospitalId) { return loginDataService.getApplication(user, hospitalId); }
	 */
	// End of Methods by Ritu
	// method by vikas
	public List getDepartmentList(Map map) {
		return loginDataService.getDepartmentList(map);
	}

	public LoginDataService getLoginDataService() {
		return loginDataService;
	}

	public void setLoginDataService(LoginDataService loginDataService) {
		this.loginDataService = loginDataService;
	}

	public String getDepartmentName(int deptId) {
		// TODO Auto-generated method stub
		return loginDataService.getDepartmentName(deptId);
	}

	public Set getApplications(Users user, int hospitalId) {
		// TODO Auto-generated method stub
		return loginDataService.getApplications(user, hospitalId);
	}

	public Map<String, Object> getSetupParameterMap(Map<String, Object> dataMap) {
		return loginDataService.getSetupParameterMap(dataMap);
	}

	public String getDepartmentTypeCode(int deptId) {
		// TODO Auto-generated method stub
		return loginDataService.getDepartmentTypeCode(deptId);
	}

	public List<Object> getNoticeMessage() {
		return loginDataService.getNoticeMessage();
	}

	
	/*public List<HrMasFinancialYear> getCurrentFinancialYear() {
		
		return loginDataService.getCurrentFinancialYear();
	}*/


	public Map<String, Object> getBranchList(int departmentId,String userName) {
		
		return loginDataService.getBranchList(departmentId,userName);
	}

	@Override
	public Map<String, Object> showCommunicationJsp(Map<String, Object> mapCom) {
		return loginDataService.showCommunicationJsp(mapCom);
	}

	@Override
	public Map<String, Object> getDepartmentDetails(Map<String, Object> deptMap) {
		return loginDataService.getDepartmentDetails(deptMap);
	}

	
	public Object getBranchName(int branchId) {
		
		return loginDataService. getBranchName(branchId);
	}

	@Override
	public Map<String, Object> saveUserLog(Map<String, Object> mapUserLog) {
		return loginDataService. saveUserLog(mapUserLog);
	}

	@Override
	public Map<String, Object> getTelephoneDirectory() {
		// TODO Auto-generated method stub
		return loginDataService.getTelephoneDirectory();
	}

	@Override
	public List<HrMasFinancialYear> getCurrentFinancialYear() {
		
		return loginDataService.getCurrentFinancialYear();
	}

	@Override
	public List<Object[]> getLastLoginDetails(int userId) {
		return loginDataService.getLastLoginDetails(userId);
	}

	@Override
	public Map<String, Object> updateLastLoginDetails(Box box) {
		return loginDataService.updateLastLoginDetails(box);
	}

	

	@Override
	public List<MasStoreFinancial> getCurrentFinancialYearForAccount() {
		
		return loginDataService.getCurrentFinancialYearForAccount();
	}

	@Override
	public Map<String, Object> getLoginHospitalName(int hospitalId) {
		return loginDataService.getLoginHospitalName(hospitalId);
	}

	@Override
	public boolean updateLoginDateTime(int userId) {
		return loginDataService.updateLoginDateTime(userId) ;
	}

	@Override
	public int getHospitalType(int hospitalId) {
		return loginDataService.getHospitalType(hospitalId);
	}

	@Override
	public int getAuthLevel(int hospitalId) {
		return loginDataService.getAuthLevel(hospitalId);
	}

	@Override
	public int employeeLevel(int userId) {
		return loginDataService.employeeLevel(userId);
	}

	@Override	public List<Object> getExistingOtherUser(String loginName,String password, String userType) {
		return loginDataService.getExistingOtherUser(loginName, password,userType);
	}

	@Override
	public void updateLogoutDetail(Box box) {
		loginDataService.updateLogoutDetail(box);		
	}

	@Override
	public Map<String, Object> checkForBlockedAccount(String loginName){
		return loginDataService.checkForBlockedAccount(loginName);		
	}
	

	@Override
	public void freeCounterOnSessionTimeout(Map<String, Object> map){
			loginDataService.freeCounterOnSessionTimeout(map);		
	}

	@Override
	public void removeVisitUptoOnSessionTimeout(Map<String, Object> map){
		loginDataService.removeVisitUptoOnSessionTimeout(map);		
	}
	
	@Override
	public void reassignPatientsToDoctor(Box box){
		loginDataService.reassignPatientsToDoctor(box);		
	}
	
}