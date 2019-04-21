/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class LoginHandlerServiceImpl.java
 * Purpose of the class - This is for Login.
 * Tables Used: mas_hospital, mas_application, users, user_usergroup_hospital, usergroup_applications,usergroup_hospital
 * @author  Create Date: July 2007  Name: Ritu Sahu
 * Revision Date:      		Revision By:
 * @version 1.0
 **/

package jkt.hms.login.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.CommunicationMessages;
import jkt.hms.masters.business.EmployeeTeleDirec;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.HrDutyScheduleT;
import jkt.hms.masters.business.HrInstituteAuthLevel;
import jkt.hms.masters.business.HrInstituteAuthLevelDetails;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasServiceCentreCounter;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.UserWiseBranch;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.UsersLoginDetails;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.MasApplicationComparatorByOrderId;
import jkt.hrms.masters.business.HrMasFinancialYear;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LoginDataServiceImpl extends HibernateDaoSupport implements
		LoginDataService {


	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalName(String loginName, String password, String ipAddress) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<Users> loginNameList = new ArrayList<Users>();
		List<UserHospital> hospitalList = new ArrayList<UserHospital>();
		Session session = (Session) getSession();
		int userId=0;
		boolean isBlocked = false; // added by amit das on 05-12-2016
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			loginNameList = session.createCriteria(Users.class)
					.add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			
			if(loginNameList.size()>0){	
				Users user1=loginNameList.get(0);
				String password1=""+user1.getPassword();
				userId=Integer.parseInt(""+user1.getId());
				int empId = user1.getEmployee().getId();
				boolean ldapValidate = false;
				/*if(!loginName.equalsIgnoreCase("jktuser")){
					*//**
					 * If user authenticated through LDAP
					 *//*
					ldapValidate = LDAPAuthAndSearch.getAuthentcateUserAndPwd(loginName, password);
				}else if(loginName.equalsIgnoreCase("jktuser")){*/
					ldapValidate = HMSUtil.validatePassword(password1, password);
				//}
					Map<String,Object> utilMap = new HashMap<String,Object>();
					utilMap = (Map)HMSUtil.getCurrentDateAndTime();
					String date = (String)utilMap.get("currentDate");	 
					String time = (String)utilMap.get("currentTime");
			
					if(ldapValidate){
						
						hospitalList=session.createCriteria(UserHospital.class).add(Restrictions.eq("Status", "Y").ignoreCase())
								.add(Restrictions.eq("User.Id", userId)).list();
						user1.setLoginCount(0); // added by amit das on 14-04-2017
						hbt.update(user1); // added by amit das on 14-04-2017
						
					}else{
						Users users = (Users)hbt.load(Users.class, userId);
						int loginCount = users.getLoginCount()!=null?users.getLoginCount():0;
						loginCount = loginCount+1;
						users.setLoginCount(loginCount);
						
						/*	if(loginCount==10)
							users.setStatus("b");
						*/
						/*hbt.update(users);*/  // commented by amit das on  05-12-2016 
						
						UsersLoginDetails loginDetails = new UsersLoginDetails();
						loginDetails.setLastUnsuccessfulLoginDate(HMSUtil.convertStringTypeDateToDateType(date));
						loginDetails.setLastUnsuccessfulLoginTime(time);
						loginDetails.setFromIp(ipAddress);
						
						
						loginDetails.setUser(users);
						hbt.save(loginDetails);
						
						// added by amit das on 05-12-2016 for login block after 3 concustive invalid logins
						/*DateFormat formatter = new SimpleDateFormat("hh:mm");
						usersLoginDetails = session.createCriteria(UsersLoginDetails.class).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("LastUnsuccessfulLoginDate",HMSUtil.convertStringTypeDateToDateType(date))).addOrder(Order.desc("Id")).setMaxResults(3).list();
						if(usersLoginDetails!=null && usersLoginDetails.size()==3){
							
							 System.out.println("first");
							 System.out.println((formatter.parse(usersLoginDetails.get(0).getLastUnsuccessfulLoginTime()).getTime()/60000) - (formatter.parse(usersLoginDetails.get(1).getLastUnsuccessfulLoginTime()).getTime()/60000));
							 System.out.println("second");
							 System.out.println((formatter.parse(usersLoginDetails.get(1).getLastUnsuccessfulLoginTime()).getTime()/60000) - (formatter.parse(usersLoginDetails.get(2).getLastUnsuccessfulLoginTime()).getTime()/60000));
							
							if( ( ((formatter.parse(usersLoginDetails.get(0).getLastUnsuccessfulLoginTime()).getTime()/60000) - (formatter.parse(usersLoginDetails.get(1).getLastUnsuccessfulLoginTime()).getTime()/60000))<=2) 
								 && ( ((formatter.parse(usersLoginDetails.get(1).getLastUnsuccessfulLoginTime()).getTime()/60000) - (formatter.parse(usersLoginDetails.get(2).getLastUnsuccessfulLoginTime()).getTime()/60000))<=2) ){
								
								users.setStatus("b");
								isBlocked = true;
							}
						}*/  //commented by amit das on 14-04-2017
						// added by amit das on 14-04-2017
						if (loginCount==3) {
							//users.setStatus("b");
							//isBlocked = true;
						}
						
						hbt.update(users);
						// end of code by amit das on 05-12-2016 for login block after 3 concustive invalid logins
					}
					/**
					 * End
					 */
			} /*else { // added by amit das on 05-12-2016 for login block after 3 concustive invalid logins
				loginNameList = session.createCriteria(Users.class)
						.add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "b").ignoreCase())
						.list();
				isBlocked = true;
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		map.put("hospitalList",hospitalList);
		map.put("isBlocked", isBlocked); // added by amit das on 05-12-2016 for login block after 3 concustive invalid logins
		map.put("userId",userId);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getExistingUser(String loginName, String password) {
		List<Object> existingUserList = new ArrayList<Object>();
		List<Users> userList = new ArrayList<Users>();
		Session session = (Session) getSession();
		try {
			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (Users users : userList) {
				existingUserList.add(users);
		
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return existingUserList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getExistingOtherUser(String loginName, String password, String userType) {
		List<Object> existingUserList = new ArrayList<Object>();
		List<MasEmpaneled> userList = new ArrayList<MasEmpaneled>();
		Session session = (Session) getSession();
		try {
			userList = session.createCriteria(MasEmpaneled.class)
					.add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (MasEmpaneled users : userList) {
			
					String pwd = users.getPassword();

					if (HMSUtil.validatePassword(pwd, password)) {
						existingUserList.add(users);
					}
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return existingUserList;
	}
	
	
	// method by vikas
	@SuppressWarnings("unchecked")
	public List getDepartmentList(Map map) {

		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		try {
			if(map.get("userId")!=null && !map.get("userId").equals("0")){
		
				int userId = (Integer)map.get("userId");
				deptList=getHibernateTemplate().find("SELECT  DISTINCT dept FROM UserTemplate as ut join ut.Template as mt join mt.TemplateDepartments as td join ut.User as user join td.Department as dept where user.Id="+userId+" and upper(ut.Status)=upper('y') and upper(td.Status)=upper('y') and upper(user.Status)=upper('y') ORDER BY dept.DepartmentName asc ");
			}
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptList;
	}

	@SuppressWarnings("unchecked")
	public String getDepartmentName(int deptId) {
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String deptName = "";
		try {
			masDepartmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			if (masDepartmentList != null && masDepartmentList.size() > 0) {
				deptName = masDepartmentList.get(0).getDepartmentName();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptName;
	}

	@SuppressWarnings("unchecked")
	public Set getApplications(Users user, int hospitalId) {
		Set<MasApplication> applicationSet = MasApplicationComparatorByOrderId.getApplicationTreeSet();
		
		List<MasApplication> masApplicationsList=new ArrayList<MasApplication>();
		masApplicationsList=getHibernateTemplate().find("SELECT   app FROM UserTemplate as ut join ut.Template as mt join mt.TemplateApplications as ta join ut.User as user join ta.App as app where user.Id="+user.getId()+" and mt.Hospital.Id="+hospitalId+" and upper(ut.Status)=upper('y') and upper(ta.Status)=upper('y') and upper(user.Status)=upper('y') and upper(app.Status)='Y'");
		applicationSet.addAll(masApplicationsList);
		
		return applicationSet;

	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSetupParameterMap(Map<String, Object> dataMap) {
		int hospitalId = 0;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		masSetupParameterMaintainceList = session
				.createCriteria(MasSetupParameterMaintaince.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("masSetupParameterMaintainceList",
				masSetupParameterMaintainceList);
		return map;
	}

	/** for taking deptType from session * */
	@SuppressWarnings("unchecked")
	public String getDepartmentTypeCode(int deptId) {
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String deptType = "";
		try {
			masDepartmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			if (masDepartmentList != null && masDepartmentList.size() > 0) {
				deptType = masDepartmentList.get(0).getDepartmentType()
						.getDepartmentTypeCode();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptType;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getNoticeMessage() {
		List<Object> noticeBoardMessageList = new ArrayList<Object>();
		Session session = (Session) getSession();
		try {

			noticeBoardMessageList = session
					.createCriteria(HmsNoticeBoard.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return noticeBoardMessageList;
	}
	
	
	
	public Map<String, Object> getBranchList(int departmentId,String userName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserWiseBranch> userBranchList = new ArrayList<UserWiseBranch>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		//List<Users> userList = new ArrayList<Users>();
		Session session = (Session)getSession();
		userBranchList = session.createCriteria(UserWiseBranch.class).createAlias("User", "user")
		.add(Restrictions.eq("user.LoginName", userName))
		.add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Department.Id", departmentId)).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Department.Id", departmentId)).list();
		//userList = session.createCriteria(Users.class).add(Restrictions.eq("Status", "y")).list();
		map.put("branchList", branchList);
		map.put("userBranchList", userBranchList);
		//map.put("userList", userList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showCommunicationJsp(Map<String, Object> mapCom) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<CommunicationMessages> communicationMessagesList=new ArrayList<CommunicationMessages>();
		List<CommunicationMessages> communicationMessagesSentList=new ArrayList<CommunicationMessages>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int empId=0;
		if(mapCom.get("empId")!=null){
			empId=(Integer)mapCom.get("empId");
		}
		Session session =(Session)getSession();
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			
			masEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as me where me.Status='y' order by me.FirstName,me.LastName");
			map.put("masEmployeeList", masEmployeeList);
			communicationMessagesList=session.createCriteria(CommunicationMessages.class).createAlias("ToEmployee", "toEmp").add(Restrictions.eq("toEmp.Id", empId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			communicationMessagesSentList=session.createCriteria(CommunicationMessages.class).createAlias("FromEmployee", "fromEmp").add(Restrictions.eq("fromEmp.Id", empId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			map.put("communicationMessagesList", communicationMessagesList);
			map.put("communicationMessagesSentList", communicationMessagesSentList);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDepartmentDetails(Map<String, Object> deptMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int deptId=0;
		if(deptMap.get("deptId")!=null){
			deptId=(Integer)deptMap.get("deptId");
		}
		
		try {
			List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
			
			
			masDepartmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			map.put("masDepartmentList", masDepartmentList);
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	
	public String getBranchName(int branchId) {
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session) getSession();
		String branchName = "";
		try {
			branchList = session.createCriteria(MasBranch.class)
					.add(Restrictions.eq("Id", branchId)).list();
			if (branchList != null && branchList.size() > 0) {
				branchName = branchList.get(0).getBranchCode();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return branchName;
	
	}

	@Override
	public Map<String, Object> saveUserLog(Map<String, Object> mapUserLog) {

		Map<String, Object> mapUserLogReturn = new HashMap<String, Object>();
		
/*		UsersLog usersLog=new UsersLog();
		if(mapUserLog.get("usersLog")!=null){
			usersLog=(UsersLog)mapUserLog.get("usersLog");
		}
		//Session session =(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try{
			hbt.save(usersLog);
		}catch (Exception e) {
			e.printStackTrace();
		}
*/		return mapUserLogReturn;
	}

	@Override
	public Map<String, Object> getTelephoneDirectory() {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<Object[]>alist=new ArrayList<Object[]>();
		String query="select * from employee_telephone_dir";
		alist=session.createSQLQuery(query).list();
		map.put("alist",alist);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HrMasFinancialYear> getCurrentFinancialYear(){
			List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
			try {
				Session session = (Session)getSession();
				financialYearList = session.createCriteria(HrMasFinancialYear.class)
								.add(Restrictions.eq("FyStatus", "open"))
								.list();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return financialYearList;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getLastLoginDetails(int userId) {
		List<Object[]> lastLoginDetailsList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		lastLoginDetailsList = session.createCriteria(UsersLoginDetails.class).add(Restrictions.eq("User.Id", userId))
								.setProjection(Projections.projectionList().add(Projections.property("LastUnsuccessfulLoginDate"))
										.add(Projections.property("LastUnsuccessfulLoginTime")).add(Projections.property("FromIp"))).list();
				
		
		return lastLoginDetailsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateLastLoginDetails(Box box) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int deptId=0;
		int userId = box.getInt("userId");
		if(box.get("deptId")!=null){
			deptId= box.getInt("deptId");
		}
		
		if(box.getString("flag").equalsIgnoreCase("ignore")){
			Query delqry = session.createQuery("delete from UsersLoginDetails uld where uld.User.Id =:userId");
			delqry.setInteger("userId",userId);
			delqry.executeUpdate();
		}else{
			Users users = (Users)hbt.load(Users.class, userId);
			users.setReportToAdmin("y");
			users.setLoginStatus("y");
			if(deptId>0){
				MasDepartment dep=new MasDepartment();
				dep.setId(deptId);
				users.setDepartment(dep);
			}
			
			hbt.update(users);
		}
		datamap.put("userId", userId);
		
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		deptList = getDepartmentList(datamap);
		map.put("deptList", deptList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MasStoreFinancial> getCurrentFinancialYearForAccount(){
			List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
			try {
				Session session = (Session)getSession();
				financialYearList = session.createCriteria(MasStoreFinancial.class)
								.add(Restrictions.eq("FyStatus", "open"))
								.list();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return financialYearList;
		}

	@Override
	public Map<String, Object> getLoginHospitalName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String hospitalName = "";
		int districtId = 0;
		String hospitalCode = "";
		String specialtyType = "";
		try
		{
			masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (masHospitalList!=null && masHospitalList.size()>0){
				districtId = masHospitalList.get(0).getDistrict().getId();
				hospitalName = masHospitalList.get(0).getHospitalName();
				hospitalCode = masHospitalList.get(0).getHospitalCode();
				specialtyType = masHospitalList.get(0).getSpecialityType()!=null? masHospitalList.get(0).getSpecialityType():"";
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("districtId", districtId);
		map.put("hospitalName", hospitalName);
		map.put("hospitalCode", hospitalCode);
		map.put("specialtyType", specialtyType);
		return map;
	}

	@Override
	public boolean updateLoginDateTime(int userId) {
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean updated = false;
		
		try {
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			Users user = (Users)hbt.load(Users.class,userId);
			user.setLastSuccessfulLoginDate(HMSUtil.convertStringTypeDateToDateType(date));
			user.setLastSuccessfulLoginTime(time);
			user.setLoginStatus("y");
			hbt.update(user);
			updated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getHospitalType(int hospitalId) {
		List<MasHospital>hospitalList=new ArrayList<MasHospital>();
		Session session=(Session)getSession();
		hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalId)).list();
		int hospitalTypeId=0;
		for(MasHospital mh:hospitalList){
			hospitalTypeId=mh.getHospitalType().getId();
		}
		return hospitalTypeId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getAuthLevel(int hospitalId) {
		List<HrInstituteAuthLevel>hospitalList=new ArrayList<HrInstituteAuthLevel>();
		Session session=(Session)getSession();
		int authLevel=0;
		hospitalList=session.createCriteria(HrInstituteAuthLevel.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		for(HrInstituteAuthLevel mh:hospitalList){
			authLevel=mh.getAuthLevel();
		}
		return authLevel;
	}

	@Override
	public int employeeLevel(int userId) {
		List<Users>userList=new ArrayList<Users>();
		Session session=(Session)getSession();
		int employeeId=0;
		int employeeLevel=0;
		userList=session.createCriteria(Users.class).add(Restrictions.eq("Id", userId)).list();
		
		for(Users user:userList){
			employeeId=user.getEmployee().getId();
		}
		List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
		hrInstituteAuthLevelDetailsList=session.createCriteria(HrInstituteAuthLevelDetails.class).add(Restrictions.eq("Employee.Id", employeeId)).list();
		for(HrInstituteAuthLevelDetails hrInstituteAuthLevelDetails:hrInstituteAuthLevelDetailsList){
			employeeLevel=hrInstituteAuthLevelDetails.getSlNo();
		}
		return employeeLevel;
	}

	@Override
	public void updateLogoutDetail(Box box) {
		int deptId=0;
		String status="";
		int userId = box.getInt("userId");
		if(box.get("deptId")!=null){
			deptId= box.getInt("deptId");
		}
		if(box.get("status")!=null){
			status= box.get("status");
		}
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(userId!=0){ // added by amit das on 27-04-2017
			Users users = (Users)hbt.load(Users.class, userId);
			
			users.setLoginStatus(status);
			MasServiceCentreCounter serviceCentreCounter=null;
			if(users.getCurrentCounter()!=null){
				serviceCentreCounter =	users.getCurrentCounter();
			}
			// added by amit das on 19-04-2017
			
			if(!status.equalsIgnoreCase("y") && serviceCentreCounter!=null){
				serviceCentreCounter.setStatus("y");
				hbt.update(serviceCentreCounter);
			//	users.setAvailableToday("n");
				users.setCurrentCounter(null); //added  by amit das on 01-06-2017
			}else{
				users.setAvailableToday("y");
			}
			
			if(deptId>0){
				MasDepartment dep=new MasDepartment();
				dep.setId(deptId);
				users.setDepartment(dep);
			}
				hbt.update(users);
				
			}
		
	}
	
	
	@Override
	public void freeCounterOnSessionTimeout(Map<String, Object> map) {
		int userId = 0;
		MasEmployee employee = null;
		
		if(map.get("userId")!=null){
			userId= (Integer)map.get("userId");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
			
		if(userId!=0){ // added by amit das on 27-04-2017
		   Users users = (Users)hbt.get(Users.class, userId);
		  
		 // added by amit das on 19-04-2017
		 MasServiceCentreCounter serviceCentreCounter =	null;
		 if(users.getCurrentCounter()!=null){
			serviceCentreCounter = users.getCurrentCounter();
			serviceCentreCounter.setStatus("y");
			hbt.update(serviceCentreCounter);
			users.setCurrentCounter(null); //added by amit das on 19-04-2017
		 }
			
		 users.setLoginStatus("n");
		// users.setAvailableToday("n");
		
		   
		  /* if(users.getEmployee()!=null){
			    employee = (MasEmployee)hbt.load(MasEmployee.class, users.getEmployee().getId());
			   	employee.setVisitTimeUpto(null);
			    hbt.update(employee);
		   }*/
		 
		 hbt.update(users);
		}
		
	}
	
	// added by amit das on 17-04-2017 
	@Override
	public Map<String, Object> checkForBlockedAccount(String loginName) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<Users> loginNameList = null;
		Session session = (Session) getSession();
		boolean isBlocked = false; // added by amit das on 05-12-2016
		try {
			loginNameList = session.createCriteria(Users.class)
					.add(Restrictions.eq("LoginName", loginName)).add(Restrictions.eq("Status", "b").ignoreCase())
					.list();
			
			if(loginNameList!=null && loginNameList.size()>0)
				isBlocked = true;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		map.put("isBlocked", isBlocked);
		return map;
	}
	
	@Override
	public void removeVisitUptoOnSessionTimeout(Map<String, Object> map) {
		int userId = 0;
		MasEmployee employee = null;
		
		if(map.get("userId")!=null){
			userId= (Integer)map.get("userId");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
			
		if(userId!=0){
		   Users users = (Users)hbt.get(Users.class, userId);
		   employee = users.getEmployee();
		   
		   /*if(employee!=null){
			   	employee.setVisitTimeUpto(null);
			    hbt.update(employee);
		   }*/
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void reassignPatientsToDoctor(Box box) {
		Session session = (Session) getSession();
		int empId = 0;
		int deptId = 0;
		int hospitalId = 0;
		MasEmployee employee = null;
		
		if(box.get("empId")!=null){
			empId= box.getInt("empId");
		}
		
		if(box.get("deptId")!=null){
			deptId= box.getInt("deptId");
		}
		
		if(box.get("hospitalId")!=null){
			hospitalId= box.getInt("hospitalId");
		}
		
		employee = (MasEmployee) session.get(MasEmployee.class, empId);
		  
		List<QueueManagment> queueManagmentList = session.createCriteria(QueueManagment.class)
		.add(Restrictions.eq("LsCngDate", new Date()))
		.add(Restrictions.eq("TokenStatus", "w").ignoreCase())
		.add(Restrictions.eq("Hospital.Id", hospitalId))
		.add(Restrictions.eq("Department.Id", deptId))
		.add(Restrictions.eq("Docotor.Id", empId))
		.add(Restrictions.isNull("AssignedDoctorId"))
		.add(Restrictions.isNull("InitialDr")).list();
		
		if(queueManagmentList!=null && queueManagmentList.size()>0){
			for(QueueManagment queueManagment : queueManagmentList){
				queueManagment.setAssignedDoctorId(empId);
				queueManagment.setInitialDr(employee);
				session.update(queueManagment);
			}
		}
		session.flush();
		
	}
}
