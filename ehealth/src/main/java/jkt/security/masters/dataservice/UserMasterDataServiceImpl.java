package jkt.security.masters.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.Logger;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.HrInstituteAuthLevel;
import jkt.hms.masters.business.HrInstituteAuthLevelDetails;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTemplate;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasPanchayat;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.TemplateApplication;
import jkt.hms.masters.business.TemplateDepartment;
import jkt.hms.masters.business.UserApplications;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserGroups;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.UserTemplate;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserMasterDataServiceImpl extends HibernateDaoSupport implements
		UserMasterDataService {

	@SuppressWarnings("unchecked")
	List employeeList = null;
	@SuppressWarnings("unchecked")
	List hospitalList = null;
	@SuppressWarnings("unchecked")
	List userList = null;
	boolean dataSaved = false;
	static final Logger LOGGER = Logger.getLogger(UserMasterDataServiceImpl.class);
	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospListWithGHID(int id) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.Id = '"
						+ id + "' ");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospListWithID(int userUserGroupHospId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.GroupHospitalId = '"
						+ userUserGroupHospId + "' ");
		return list;
	}

	public boolean updateUserUsergroupHospital(
			UserUsergroupHospital userUsergroupHospital) {
		try {
			getHibernateTemplate().update(userUsergroupHospital);
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getUserUserGroupHospList(int userId, int userUserGroupHospId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.GroupHospitalId = '"
						+ userUserGroupHospId
						+ "' and uugh.UserId = '"
						+ userId + "'");
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getListWithUserId(int loginId) {
		List list = new ArrayList();
		try {
			list = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserUsergroupHospital as uugh where "
							+ "uugh.UserId = '" + loginId + "'  ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List checkExistOfUserHospMapping(int loginId, int groupHospitalId) {
		List list = new ArrayList();
		return list = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserUsergroupHospital as uugh where uugh.UserId = '"
						+ loginId
						+ "' and  uugh.GroupHospitalId='"
						+ groupHospitalId + "'  ");
	}

	public boolean addUserHosp(UserUsergroupHospital userUsergroupHospital) {
		try {
			getHibernateTemplate().save(userUsergroupHospital);
			dataSaved = true;

		} catch (Exception e) {
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getLoginList(String loginName) {

		List<Users> loginList = null;
		loginList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as us where us.LoginName like '"
						+ loginName + "%'");
		return loginList;
	}

	@SuppressWarnings("unchecked")
	public List getSelected(String loginName) {
		List<Users> loginList = null;
		loginList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as us where us.LoginName = '"
						+ loginName + "'");
		return loginList;
	}

	// ********************************************************************************************//
	// ************************************Start Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// ---------------------------------------------- Users
	// ------------------------//

	@SuppressWarnings("unchecked")
	/*
	 * public Map<String, Object> showUserJsp() { Map<String,Object> map=new
	 * HashMap<String,Object>(); List<Users> searchUserList = new
	 * ArrayList<Users>(); List<Users> userList = new ArrayList<Users>();
	 * List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 * List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
	 * List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
	 * searchUserList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.Users "); userList =
	 * getHibernateTemplate().find( "from jkt.hms.masters.business.Users as mc
	 * where mc.Status = 'y'"); employeeList = getHibernateTemplate().find(
	 * "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");
	 * empGroupList=getHibernateTemplate().find("from EmpGroups as eg where
	 * eg.Status='y'"); userEmpGroupList=getHibernateTemplate().find("from
	 * UserEmpGroup as ueg where ueg.Status='y'"); 
	 * map.put("searchUserList",searchUserList); map.put("userList",userList);
	 * map.put("employeeList",employeeList); map.put("empGroupList",
	 * empGroupList); map.put("userEmpGroupList", userEmpGroupList); return map;
	 * }
	 */
	public Map<String, Object> showUserJsp(Map<String, Object> datamap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId =0;
		String userName = "";
		int userType = 0;
		int userId = 0;
		int districtId= (Integer)datamap.get("districtId");
		
		if(datamap.get("hospitalId")!=null){
			hospitalId = (Integer)datamap.get("hospitalId");
		}
		if(datamap.get("userName")!=null){
			userName = (String)datamap.get("userName");
		}
		if(datamap.get("userType")!=null){
			userType = (Integer)datamap.get("userType");
		}
		
		if(datamap.get("userId")!=null){
			userId = (Integer)datamap.get("userId");
		}
		List<Users> userList = new ArrayList<Users>();
		Session session = (Session) getSession();
		
		/*if(userName.equals("admin"))
			userList = getHibernateTemplate().find("from jkt.hms.masters.business.Users as mc where lower(mc.Status)='y'");
		else
			userList = getHibernateTemplate().find("from jkt.hms.masters.business.Users as mc where  lower(mc.Status)='y' and mc.Employee.Hospital.Id="+hospitalId);
		*/
		
		if(userId!=0)
			userList = getHibernateTemplate().find("from jkt.hms.masters.business.Users as mc where Id="+userId);
		
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		masTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("TemplateName")).list();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Criteria crit = null;
		crit = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName"));
		if(userType==2){/* District Admin*/
			crit = crit.add(Restrictions.eq("District.Id", districtId));
		}
		hospitalList = crit.list();
		
		List<Object[]> employeeList = new ArrayList<Object[]>();
		if(userName.equals("admin"))
			employeeList = getHibernateTemplate()
			.find("select mc.Id,mc.EmployeeName,mc.Status,mc.PEN from jkt.hms.masters.business.MasEmployee as mc where lower(mc.Status)='y' ");
	
		else	
			employeeList = getHibernateTemplate()
				.find("select mc.Id,mc.EmployeeName,mc.Status,mc.PEN from jkt.hms.masters.business.MasEmployee as mc where lower(mc.Status)='y' and mc.Hospital.Id="+hospitalId);
	
		map.put("employeeList", employeeList);
		
		map.put("userList", userList);
		map.put("masTemplateList", masTemplateList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	public boolean deleteUser(int userId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		int chgById = (Integer) generalMap.get("chgById");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		Users users = new Users();
		users = (Users) getHibernateTemplate().get(Users.class, userId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				users.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				users.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(chgById);
		users.setLastChgBy(user);
		users.setLastChgDate(currentDate);
		users.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(users);
		return dataDeleted;
	}

	public boolean editUserToDatabase(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = "";
		String loginName = "";
		int userId = 0;
		Transaction tx = null;
		int employeeId = 0;
		int hospitalId = 0;
		Long imeiNo=0l;
		String simNo="";
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			userId = (Integer) generalMap.get("id");
			loginName = (String) generalMap.get("loginName");
			employeeId = (Integer) generalMap.get("employeeId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			hospitalId = (Integer) generalMap.get("hospitalId");
			int chgById = (Integer) generalMap.get("chgById");
			String password = (String)generalMap.get("password");
			String pacsUserName = (String)generalMap.get("pacsUserName");
			String pacsPassword = (String)generalMap.get("pacsPassword");
			String pacsDesignation = (String)generalMap.get("pacsDesignation");
			String wipseStatus=(String)generalMap.get("wipseStatus");
			String superUser = "";
			imeiNo=(Long)generalMap.get("imeiNo");
			simNo=(String)generalMap.get("simNo");
			if(generalMap.get("superUser")!=null){
				superUser = (String)generalMap.get("superUser");
			}
			int userType = 0;
			if(generalMap.get("userType")!=null){
				userType = (Integer)generalMap.get("userType");
			}
			Users users = (Users) getHibernateTemplate().get(Users.class,
					userId);
			MasHospital masHospital = (MasHospital) getHibernateTemplate().get(MasHospital.class,
					hospitalId);
			
			users.setId(userId);
			users.setUserName(userName);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			users.setEmployee(masEmployee);
			users.setLoginName(loginName);
			users.setSuperuser(superUser);
			users.setUserType(userType);
			users.setPassword(HMSUtil.encryptPassword(password));
			if(pacsUserName!=null && !pacsUserName.equals("")){
				users.setPacsUsername(pacsUserName);
			}
			if(pacsPassword!=null && !pacsPassword.equals("")){
				users.setPacsPassword(pacsPassword);
			}if(pacsDesignation!=null && !pacsDesignation.equals("-1")){
				users.setPacsDesignation(pacsDesignation);
			}
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			users.setHospital(hospital);
			users.setImeiNo(imeiNo);
			masHospital.setSimNo(simNo+"");
			masHospital.setImeiNo(imeiNo);
			users.setSimSerialNo(simNo+"");
			Users user = new Users();
			user.setId(chgById);
			users.setLastChgBy(user);
			users.setWipseStatus(wipseStatus);
			users.setLastChgDate(currentDate);
			users.setLastChgTime(currentTime);
			hbt.saveOrUpdate(users);
			hbt.saveOrUpdate(masHospital);

			tx.commit();
			dataUpdated = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addUser(Map<String, Object> userMap) {
		Map<String,Object> map = new HashMap<String,Object>();
		Session session = (Session) getSession();
		
		boolean successfullyAdded = false;
		int employeeId=0;
		int savedUserId = 0;
		if(userMap.get("employeeId")!=null){
			employeeId=(Integer)userMap.get("employeeId");
		}
		String loginName = "";
		if(userMap.get("loginName")!=null){
			loginName=(String)userMap.get("loginName");
		}
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);


			Users users = new Users();
				
			if(userMap.get("users")!=null){
				users=(Users)userMap.get("users");
			}
		/*	MasEmployee masEmployee = new MasEmployee();
			
			if(employeeId!=0){
				masEmployee.setId(employeeId);
				users.setEmployee(masEmployee);
				
			}*/

			int hospitalId=0;
			if(userMap.get("hospitalId")!=null){
				hospitalId=(Integer)userMap.get("hospitalId");
			}
			List<Integer> templetIdList=new ArrayList<Integer>();
			if(userMap.get("templetIdList")!=null){
				templetIdList=(List<Integer>)userMap.get("templetIdList");
			}
			
			
			hbt.save(users);
			
			UserHospital userHospital = new UserHospital();
			if(userMap.get("userHospital")!=null){
				userHospital = (UserHospital)userMap.get("userHospital");
			}
			userHospital.setUser(users);
			hbt.save(userHospital);

			savedUserId = 	users.getId();
			
			/*
				 * Code for Module Application
				 * Date 06 July 2012
				 */
				
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
				
				changedBy = (String) userMap.get("changedBy");
				currentDate = (Date) userMap.get("currentDate");
				
				int userId=0;
				if(userMap.get("userId")!=null){
					userId=(Integer)userMap.get("userId");
				}
				LOGGER.info("userId "+userId);
				if(templetIdList.size()>0){
					for(Integer templateId1:templetIdList){
						UserTemplate userTemplate = new UserTemplate();
				
						userTemplate.setUser(users);
						MasTemplate masTemplate = new MasTemplate();
						masTemplate.setId(templateId1);
						userTemplate.setTemplate(masTemplate);
						
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						userTemplate.setHospital(masHospital);
						userTemplate.setStatus("y");
						//userTemplate.setLastChgBy(changedBy);
						userTemplate.setLastChgBy(""+userId);
						userTemplate.setLastChgDate(currentDate);
						userTemplate.setLastChgTime(currentTime);
						hbt.save(userTemplate);
						 //added by govind 15-03-2017	
						LOGGER.info("templateId "+templateId1);
						MasTemplate mTemp = new MasTemplate();
						mTemp=hbt.load(MasTemplate.class, templateId1);
						if(mTemp!=null){
								TemplateDepartment temDep=new TemplateDepartment();
								temDep.setTemplate(mTemp);
								temDep.setDepartment(mTemp.getDept());
								Users user = new Users();
								user.setId(userId);
								temDep.setLastChgBy(user);
								temDep.setLastChgDate(currentDate);
								temDep.setLastChgTime(currentTime);
								temDep.setStatus("y");
								hbt.save(temDep);
							
						}
						//added by govind 15-03-2017 end
						
					}
				}
			tx.commit();
			successfullyAdded = true;
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
	
	
		successfullyAdded = true;
		
		map.put("userId", savedUserId);
		map.put("successfullyAdded", successfullyAdded);
		
		return map;
		}

	@SuppressWarnings("unchecked")
	public List getUserList() {

		userList = new ArrayList();
		try {
			userList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Users");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@SuppressWarnings("unchecked")
	public List getEmployeeList() {
		employeeList = new ArrayList();

		try {
			employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee");
		} catch (Exception e) {
		}

		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List getHospitalList() {
		List hospitalList = new ArrayList();
		try {

			hospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalList;
	}

	public boolean updateUser(Users users) {

		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			/*
			 * int id=users.getId();
			 * 
			 * Users user = new Users(); user = (Users) hbt.load(Users.class,
			 * id); user.setLoginName(users.getLoginName());
			 * user.setUserName(users.getUserName());
			 * user.setEmployeeCode(users.getEmployeeCode());
			 * user.setPassword(users.getPassword());
			 * user.setStatus(users.getStatus());
			 * user.setLastChgBy(users.getLastChgBy());
			 * user.setLastChgDate(users.getLastChgDate());
			 * user.setLastChgTime(users.getLastChgTime());
			 */
			hbt.update(users);
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}

		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public List getGroupHospitalId(int groupId, int hospitalId) {
		List list = new ArrayList();
		try {

			list = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.GroupId = '"
							+ groupId + "' and ugh.HospitalId = '" + hospitalId
							+ "' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List getUserGroupHospList() {
		return getHibernateTemplate().find(
				"from jkt.hms.masters.business.UsergroupHospital ");
	}

	@SuppressWarnings("unchecked")
	public List getUserName(int userId) {
		List list = new ArrayList();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.Users as users where users.Id = '"
						+ userId + "'");
		return list;
	}

	// ---------------------------------------User Groups
	// -------------------------

	public boolean addUserGroups(UserGroups masUserGroups) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUserGroups);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editUserGroupsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userGroupsName = "";
		@SuppressWarnings("unused")
		String userGroupsCode = "";
		int userGroupsId = 0;
		String changedBy = "";
		try {
			userGroupsId = (Integer) generalMap.get("id");
			userGroupsCode = (String) generalMap.get("userGroupsCode");
			userGroupsName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserGroups masUserGroups = (UserGroups) getHibernateTemplate().get(
				UserGroups.class, userGroupsId);

		masUserGroups.setId(userGroupsId);
		masUserGroups.setGroupName(userGroupsName);
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masUserGroups);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUserGroups(String userGroupsCode,
			String userGroupsName) {
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((userGroupsName != null) || (userGroupsCode == null)) {

				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserGroups imc where imc.GroupName like '"
								+ userGroupsName + "%' order by imc.GroupName");
			} else {
				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserGroups imc where imc.Code like '"
								+ userGroupsCode + "%' order by imc.Code");
			}
		} catch (Exception e) {
		}
		userGroupsFieldsMap.put("searchUserGroupsList", searchUserGroupsList);
		return userGroupsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUserGroupsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		searchUserGroupsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserGroups ");
		map.put("searchUserGroupsList", searchUserGroupsList);
		return map;
	}

	@SuppressWarnings("unused")
	public boolean deleteUserGroups(int userGroupsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserGroups masUserGroups = new UserGroups();
		masUserGroups = (UserGroups) getHibernateTemplate().get(
				UserGroups.class, userGroupsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUserGroups.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUserGroups.setStatus("y");
				dataDeleted = false;
			}
		}
		masUserGroups.setLastChgBy(changedBy);
		masUserGroups.setLastChgDate(currentDate);
		masUserGroups.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masUserGroups);
		return dataDeleted;
	}

	// ----------------------------------User Group
	// Hospital--------------------------------------

	public boolean addUsergroupHospital(UsergroupHospital masUsergroupHospital) {

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masUsergroupHospital);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public boolean deleteUsergroupHospital(int usergroupHospitalId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UsergroupHospital masUsergroupHospital = new UsergroupHospital();
		masUsergroupHospital = (UsergroupHospital) getHibernateTemplate().get(
				UsergroupHospital.class, usergroupHospitalId);
		@SuppressWarnings("unused")
		Integer userGroupsId = masUsergroupHospital.getGroup().getId();
		Integer hospitalId = masUsergroupHospital.getHospital().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			List userGroupsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserGroups as isc where isc.Id='"
							+ usergroupHospitalId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List hospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital as isc where isc.Id='"
							+ usergroupHospitalId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUsergroupHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUsergroupHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		masUsergroupHospital.setLastChgBy(changedBy);
		masUsergroupHospital.setLastChgDate(currentDate);
		masUsergroupHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUsergroupHospital);
		return dataDeleted;
	}

	public boolean editUsergroupHospital(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int usergroupHospitalId = 0;
		int userGroupId = 0;
		int hospitalId = 0;

		usergroupHospitalId = (Integer) generalMap.get("id");
		userGroupId = (Integer) generalMap.get("userGroupId");
		hospitalId = (Integer) generalMap.get("hospitalId");

		UsergroupHospital masUsergroupHospital = (UsergroupHospital) getHibernateTemplate()
				.get(UsergroupHospital.class, usergroupHospitalId);

		masUsergroupHospital.setId(usergroupHospitalId);

		UserGroups masUserGroups = new UserGroups();
		masUserGroups.setId(userGroupId);
		masUsergroupHospital.setGroup(masUserGroups);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		masUsergroupHospital.setHospital(masHospital);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masUsergroupHospital);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchUsergroupHospital(String groupName,
			String hospitalName) {
		List<UsergroupHospital> searchUsergroupHospitalList = new ArrayList<UsergroupHospital>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<UserGroups> userGroupsList = new ArrayList<UserGroups>();
		List<UserGroups> gridUserGroupsList = new ArrayList<UserGroups>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
		try {
			if ((groupName != null) || (hospitalName == null)) {

				searchUsergroupHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.UsergroupHospital imc where imc.Group.GroupName like '"
								+ groupName + "%' order by imc.Group.GroupName");
			} else {
				searchUsergroupHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.UsergroupHospital imc where imc.Hospital.HospitalName like '"
								+ hospitalName
								+ "%' order by imc.Hospital.HospitalName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		userGroupsList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		gridUserGroupsList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		hospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
		gridMasHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");

		usergroupHospitalFieldsMap.put("searchUsergroupHospitalList",
				searchUsergroupHospitalList);
		usergroupHospitalFieldsMap.put("hospitalList", hospitalList);
		usergroupHospitalFieldsMap.put("gridMasHospitalList",
				gridMasHospitalList);
		usergroupHospitalFieldsMap
				.put("gridUserGroupsList", gridUserGroupsList);
		usergroupHospitalFieldsMap.put("userGroupsList", userGroupsList);
		return usergroupHospitalFieldsMap;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> showUsergroupHospitalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UsergroupHospital> searchUsergroupHospitalList = new ArrayList<UsergroupHospital>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<UserGroups> userGroupsList = new ArrayList<UserGroups>();

		searchUsergroupHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UsergroupHospital ");
		hospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where upper(mc.Status) = upper('y')");
		userGroupsList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserGroups as mc where upper(mc.Status) = upper('y')");
		map.put("searchUsergroupHospitalList", searchUsergroupHospitalList);
		map.put("hospitalList", hospitalList);
		map.put("userGroupsList", userGroupsList);
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> checkForExistingGroupHospital(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateGroupHospitalList = new ArrayList();
		int userGroupId = (Integer) generalMap.get("userGroupId");
		int hospitalId = (Integer) generalMap.get("hospitalId");

		duplicateGroupHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UsergroupHospital ugh join ugh.Hospital as hospital join ugh.Group as grp where hospital.Id="
						+ hospitalId + " and grp.Id=" + userGroupId);
		map.put("duplicateGroupHospitalList", duplicateGroupHospitalList);

		return map;
	}

	public Map<String, Object> checkForExistingHospital(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateHospitalList = new ArrayList();
		Session session = (Session) getSession();
		int usersId = (Integer) generalMap.get("usersId");
		 int hospitalId = (Integer)generalMap.get("hospitalId");
		//int groupHospitalId = (Integer) generalMap.get("groupHospitalId");

		duplicateHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UserHospital ugh join ugh.User as user join ugh.Hospital as hosp where user.Id="
						+ usersId + " and hosp.Id=" + hospitalId);
		
		
			/*	duplicateHospitalList = session.createCriteria(UserHospital.class).add(Restrictions.eq("User.Id",usersId))
						.add(Restrictions.eq("Hospital.Id",hospitalId))
					.list();*/

		// duplicateHospitalList = getHibernateTemplate().find("from
		// jkt.security.masters.business.MasHospital as mh join
		// mh.UsergroupHospitals as ugh join ugh.Group as grp where mh.Id =
		// "+hospitalId +" and grp.Id="+groupId);
		map.put("duplicateHospitalList", duplicateHospitalList);

		return map;
	}

	// -------------------------------------- Hospital Master
	// --------------------------------

	public boolean addHospital(MasHospital masHospital) {

		boolean successfullyAdded = false;
		String hospitalSequenceName="";
		hospitalSequenceName="hospital_code_"+masHospital.getHospitalCode()+"_seq";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masHospital);
		// Added by Dhananjay 21-Mar-17
		HMSUtil.generateSequence(hospitalSequenceName);

		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteHospital(int hospitalId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHospital masHospital = new MasHospital();
		masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, hospitalId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			if (flag.equalsIgnoreCase("InActivate")) {
				masHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equalsIgnoreCase("Activate")) {
				masHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masHospital.setLastChgBy(users);
		masHospital.setLastChgDate(currentDate);
		masHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masHospital);
		return dataDeleted;
	}

	@SuppressWarnings("unused")
	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String hospitalName = "";
		@SuppressWarnings("unused")
		String hospitalCode = "";
		String hospitalAddress = "";
		String contactNumber = "";
		int hospitalId = 0;
		String changedBy = "";
		String sparkId="";
		String street="";
		String multiLab="";
		int locality=0;
		String institutionShortName="";
		int districtId=0;
		int talukId=0;
		int ward=0;
		int village=0;
		int electricalSectionId=0;
		String landLine="";
		int panchayat=0;
		int postOffice=0;
		int hospitalTypeId=0;
		int parentInstitutionId=0;
		int hoi=0;
		String lsgName="";
		String lsgType="";
		int pin=0;
		int assembly=0;
		int parliament=0;
		String emailId="";
		int sanctionBed=0;
		String kmsclInstituteCode = "";
		String kmsclCategory = "";
		String longitude="";
		String latitude="";
		String bbAvailability2="";
		String counterWiseTokenDisplay="";
		//if ip an port not present then it should be null
		String serverIp=null;
		String serverPort=null;
		String clientIp=null;
		String clientPort=null;
		String imeiNo=null;
		String mac= null;
		String sim =null;
		String utid=null;
		String specialityType="";
		try {
			hospitalId = (Integer) generalMap.get("id");
			hospitalCode = (String) generalMap.get("hospitalCode");
			hospitalName = (String) generalMap.get("name");
			hospitalAddress = (String) generalMap.get("hospitalAddress");
			contactNumber = (String) generalMap.get("contactNumber");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			lsgType = (String) generalMap.get("lsgType");
			lsgName = (String) generalMap.get("lsgName");
			sparkId=""+generalMap.get("sparkId");
			emailId=""+generalMap.get("emailId");
			locality=(Integer)generalMap.get("locality");
			street=""+generalMap.get("street");
			pin=(Integer)generalMap.get("pincode");
			assembly=(Integer)generalMap.get("assembly");
			parliament=(Integer)generalMap.get("parliament");
			counterWiseTokenDisplay= (String) generalMap.get("counterWiseTokenDisplay");
			specialityType= (String) generalMap.get("specialityType");
			if(generalMap.get("longitude") != null){
				longitude = (String)generalMap.get("longitude");
			}
			
			if(generalMap.get("multiLab") != null){
				multiLab = (String)generalMap.get("multiLab");
			}

			if(generalMap.get("latitude") != null){
				latitude = (String)generalMap.get("latitude");
			}
			
			ward=(Integer)generalMap.get("ward");
			postOffice=(Integer)generalMap.get("postOffice");
			panchayat=(Integer)generalMap.get("panchayat");
			village=(Integer)generalMap.get("village");
			districtId=Integer.parseInt(""+generalMap.get("districtId"));
			electricalSectionId=Integer.parseInt(""+generalMap.get("electricalSectionId"));
			talukId=Integer.parseInt(""+generalMap.get("talukId"));
			institutionShortName=""+generalMap.get("institutionShortName");
			landLine=""+generalMap.get("landLine");
			hospitalTypeId=Integer.parseInt(""+generalMap.get("hospitalTypeId"));
			sanctionBed=(Integer)generalMap.get("sanctionBed");
			parentInstitutionId=Integer.parseInt(""+generalMap.get("parentInstitutionId"));
			if(generalMap.get("hoi") != null){
			hoi=Integer.parseInt(""+generalMap.get("hoi"));
			}
			if(generalMap.get("kmsclInstituteCode") != null){
				kmsclInstituteCode = (String)generalMap.get("kmsclInstituteCode");
			}
			if(generalMap.get("kmsclCategory") != null){
				kmsclCategory = (String)generalMap.get("kmsclCategory");
			}
			if(generalMap.get("bbAvailability2")!=null){
				bbAvailability2=(String)generalMap.get("bbAvailability2");
			}
			if(generalMap.get("serverIp")!=null){
				serverIp=(String)generalMap.get("serverIp");
			}
			if(generalMap.get("serverPort")!=null){
				serverPort=(String)generalMap.get("serverPort");
			}
			if(generalMap.get("clientIp")!=null){
				clientIp=(String)generalMap.get("clientIp");
			}
			if(generalMap.get("clientPort")!=null){
				clientPort=(String)generalMap.get("clientPort");
			}
			if(generalMap.get("imeiNo")!=null){
				imeiNo=(String)generalMap.get("imeiNo");
			}
			if(generalMap.get("mac")!=null){
				mac=(String)generalMap.get("mac");
			}
			if(generalMap.get("sim")!=null){
				sim=(String)generalMap.get("sim");
			}
			if(generalMap.get("utid")!=null){
				utid=(String)generalMap.get("utid");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasHospital masHospital = (MasHospital) getHibernateTemplate().get(
				MasHospital.class, hospitalId);
		
		masHospital.setBbAvailable(bbAvailability2);
		masHospital.setId(hospitalId);
		masHospital.setHospitalCode(hospitalCode);
	
		masHospital.setImergencyNumber(landLine);
		
		if(imeiNo !=null && !imeiNo.equals("")){
			masHospital.setImeiNo(Long.parseLong(imeiNo));
			
		}
		if(mac !=null && !mac.equals("")){
			masHospital.setMac(mac);
			
		}
		if(utid !=null && !utid.equals("")){
			masHospital.setUtid(utid);
			
		}
		if(sim !=null && !sim.equals("")){
			masHospital.setSimNo(sim);
			
		}
		int nc=0;
		if(masHospital.getHospitalName().equalsIgnoreCase(hospitalName)){
			if(masHospital.getHospitalNameChangeCount()!= null){
			nc=masHospital.getHospitalNameChangeCount();
			}
			masHospital.setHospitalNameChangeCount(nc);
		}else{
			if(masHospital.getHospitalNameChangeCount()!= null){
				nc=masHospital.getHospitalNameChangeCount();
				}
			nc=nc+1;
			masHospital.setHospitalNameChangeCount(nc);
			
		}
		masHospital.setSpecialityType(specialityType);
		masHospital.setSanctionBed(sanctionBed);
		masHospital.setHospitalName(hospitalName);
		masHospital.setAddress(hospitalAddress);
		masHospital.setContactNumber(contactNumber);
		masHospital.setMultiLab(multiLab);
		if(electricalSectionId!=0){
		PhMasElectricalSection es = new PhMasElectricalSection();
		es.setId(electricalSectionId);
		masHospital.setElectricalSection(es);
		}
		masHospital.setSparkId(sparkId);
		masHospital.setEmailId(emailId);
		int tc=0;
		if( masHospital.getHospitalType() != null){
		if(masHospital.getHospitalType().getId() == hospitalTypeId){
		
			if(masHospital.getHospitalTypeChangeCount()!= null){
			tc=masHospital.getHospitalTypeChangeCount();
			}
			masHospital.setHospitalTypeChangeCount(tc);
		}else{
			if(masHospital.getHospitalTypeChangeCount() != null)  {
				tc=masHospital.getHospitalTypeChangeCount();
				}
			tc=tc+1;
			masHospital.setHospitalTypeChangeCount(tc);	
		}
		}else{
			if(hospitalTypeId != 0){
				tc=tc+1;
				masHospital.setHospitalTypeChangeCount(tc);	
			}else{
				masHospital.setHospitalTypeChangeCount(tc);	
				
			}
			
		}
		masHospital.setLsgType(lsgType);
		masHospital.setLsgName(lsgName);
		MasHospitalType hospitalType = new MasHospitalType();
		hospitalType.setId(hospitalTypeId);
		masHospital.setHospitalType(hospitalType);
		
		masHospital.setShortName(institutionShortName);
		masHospital.setAdd2Street(street);
		if(locality>0){
		PhMasLocality l = new PhMasLocality();
		l.setId(locality);
		masHospital.setAdd3Locality(l);
		}
		
		if(districtId>0){
		MasDistrict md = new MasDistrict();
		md.setId(districtId);
		masHospital.setDistrict(md);
		}
		
		if(talukId>0){
		MasTaluk mt = new MasTaluk();
		mt.setId(talukId);
		masHospital.setTaluk(mt);
		}
		masHospital.setPinCode(pin);
		masHospital.setLongitude(longitude);
		masHospital.setLatitude(latitude);
		masHospital.setServerIp(serverIp);
		masHospital.setServerPort(serverPort);
		masHospital.setClientIp(clientIp);
		masHospital.setClientPort(clientPort);
		
		if(assembly>0){
		PhMasParliyamentAssembly a = new PhMasParliyamentAssembly();
		a.setId(assembly);
		masHospital.setAssembly(a);
		}
		
		if(parliament>0){
		PhMasParliyamentAssembly p = new PhMasParliyamentAssembly();
		p.setId(parliament);
		masHospital.setParliament(p);
		}
		if(postOffice>0){
		MasPostCode po = new MasPostCode();
		po.setId(postOffice);
		masHospital.setPostOffice(po);
		}
		if(ward>0){
		MasWard w = new MasWard();
		w.setId(ward);
		masHospital.setWard(w);
		}
		if(village>0){
		MasVillage v= new MasVillage();
		v.setId(village);
		masHospital.setVillage(v);
		}
		if(parentInstitutionId!=0){
		MasHospital parentIns = new MasHospital();
		parentIns.setId(parentInstitutionId);
		masHospital.setParentInstitute(parentIns);
		
		}
		
		if(counterWiseTokenDisplay!=null){
		masHospital.setCounterWiseTokenDisplay("y");
		
	}else{
		masHospital.setCounterWiseTokenDisplay("n");
	}
		if(kmsclCategory != null){
			masHospital.setKmsclCategory(kmsclCategory);
		}
		if(kmsclInstituteCode != null){
			masHospital.setKmsclInstituteCode(kmsclInstituteCode);
		}
		if(hoi !=0){
			MasEmployee headOfIns = new MasEmployee();
			headOfIns.setId(hoi);
			masHospital.setHod(headOfIns);
		}else{
			masHospital.setHod(null);
		}
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			hbt.saveOrUpdate(masHospital);
			hbt.refresh(masHospital);
			
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName, int disId,int instiType) {
		
		
		Session session = (Session) getSession();
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		  URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	      
			 Properties prop = new Properties();
		        
		        try {
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
			 int stateId=Integer.parseInt(prop.getProperty("stateId"));
		       
		try {
			if ((hospitalName != null) && (hospitalCode == null) && disId==0 && instiType==0) {

				/*searchHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital imc where imc.HospitalName like '"
								+ hospitalName + "%' order by imc.HospitalName");*/
				
				searchHospitalList = session.createCriteria(MasHospital.class)
						.add(Restrictions.like("HospitalName", hospitalName+"%").ignoreCase())
						.addOrder(Order.asc("HospitalName")).list();
				
			} else if ((hospitalName == null) && (hospitalCode != null) && disId==0 && instiType==0) {
				/*searchHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital imc where imc.HospitalCode like '"
								+ hospitalCode + "%' order by imc.HospitalCode");
				*/
				searchHospitalList = session.createCriteria(MasHospital.class)
						.add(Restrictions.like("HospitalCode", hospitalCode+"%")
								.ignoreCase()).addOrder(Order.asc("HospitalCode")).list();
			} else if ((hospitalName == null) && (hospitalCode == null) && disId !=0 && instiType==0) {
				searchHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital imc where imc.District.Id = "
								+ disId + " order by imc.HospitalCode");
			} else if ((hospitalName == null) && (hospitalCode == null) && disId==0 && instiType !=0) {
				searchHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospital imc where imc.HospitalType.Id ="
								+ instiType + " order by imc.HospitalCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		
		
		userGroupsFieldsMap.put("masHospitalTypeList", masHospitalTypeList);
		
		
		List<PhMasElectricalSection> electricalSectionList = new ArrayList<PhMasElectricalSection>();
		electricalSectionList = session.createCriteria(PhMasElectricalSection.class)
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		userGroupsFieldsMap.put("electricalSectionList", electricalSectionList);
		
		// Commented by Dhananjay 24-Apr-17
		
		/*List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		*/
		//userGroupsFieldsMap.put("masEmployeeList", masEmployeeList);
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		userGroupsFieldsMap.put("districtList", districtList);
		
		userGroupsFieldsMap.put("searchHospitalList", searchHospitalList);
		
		
		
		
		return userGroupsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showHospitalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasRank> masRank = new ArrayList<MasRank>();
		searchHospitalList =session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("searchHospitalList", searchHospitalList);
		
		masHospitalList =session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status","y").ignoreCase())
				               .addOrder(Order.asc("HospitalTypeName"))
				              .list();
		
		masRank=session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		map.put("masHospitalTypeList", masHospitalTypeList);
	      URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	      
		 Properties prop = new Properties();
	        
	        try {
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			} 
		 int stateId=Integer.parseInt(prop.getProperty("stateId"));
	       
			LOGGER.info("stateId "+stateId);
		
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		/*List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		*/
		List<PhMasElectricalSection> electricalSectionList = new ArrayList<PhMasElectricalSection>();
		electricalSectionList = session.createCriteria(PhMasElectricalSection.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		List<Object> objectList = new ArrayList<Object>();
		String institutionCodeNo = "1";
		int hospitalCode=0;
		try {
			objectList = (List<Object>) session
					.createSQLQuery(
							"select max(hospital_code) from mas_hospital").list();
			if(objectList.size()>0)
			{
				for (Object object : objectList) {
				if (object != null) {
					hospitalCode=Integer.parseInt(object.toString())+1;
					institutionCodeNo = Integer.toString(hospitalCode);
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("institutionCodeNo", institutionCodeNo);
		map.put("electricalSectionList", electricalSectionList);
		//map.put("masEmployeeList", masEmployeeList);
		map.put("districtList", districtList);
		map.put("masRank", masRank);
		map.put("masHospitalList", masHospitalList);
		
		
		
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchUser(Map<String, Object> datamap) {

		List<Users> searchUserList = new ArrayList<Users>();
		List employeeList = null;
		Map<String, Object> usersFieldsMap = new HashMap<String, Object>();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<UserUsergroupHospital> useruserGroupHospList = new ArrayList<UserUsergroupHospital>();
		String loginName= "";
		int hospitalId = 0;
		int userType=0;
		int userId = 0;
		int districtId= 0;
		if(datamap.get("loginName")!=null){
			loginName = (String)datamap.get("loginName");
		}
		if(datamap.get("hospitalId")!=null){
			hospitalId = (Integer)datamap.get("hospitalId");
		}
		if(datamap.get("userType")!=null){
			userType = (Integer)datamap.get("userType");
		}
		if(datamap.get("districtId")!=null){
			districtId = (Integer)datamap.get("districtId");
		}
		try {
			if (loginName != null) {
				loginName="%"+loginName+"%";
				if(userType==1){
					searchUserList = getHibernateTemplate().find(
							"select i from jkt.hms.masters.business.Users as i where i.LoginName like'"+ loginName + "' order by i.LoginName");
			
				}else if(userType==2){
					searchUserList = getHibernateTemplate().find(
						"select i from jkt.hms.masters.business.Users as i join i.Hospital as mh join mh.District as md where i.LoginName like'"+ loginName + "' and md.Id = "+ districtId + " order by i.LoginName");
				}else{
					searchUserList = getHibernateTemplate().find(
							"select i from jkt.hms.masters.business.Users as i where i.LoginName like'"+ loginName + "' and i.Hospital.Id = "+ hospitalId + " order by i.LoginName");
			
				}
			}else {
				searchUserList = getHibernateTemplate().find(
						"select i from jkt.hms.masters.business.Users as i where i.Hospital.Id = "+ hospitalId + " order by i.LoginName");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Session session = (Session) getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName")).list();
	
			
		if(userType == 5){ // PH admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = getBsScInstList(userId);
			usersFieldsMap.put("bsScInstList", bsScInstList);
		}
		
		usersFieldsMap.put("useruserGroupHospList", useruserGroupHospList);
		usersFieldsMap.put("userEmpGroupList", userEmpGroupList);
		//usersFieldsMap.put("employeeList", employeeList);
		usersFieldsMap.put("searchUserList", searchUserList);
		usersFieldsMap.put("empGroupList", empGroupList);
		usersFieldsMap.put("hospitalList", hospitalList);
		return usersFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUserHospitalMaintenanceJsp(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Users> usersList = new ArrayList<Users>();

		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();

		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		int hospitalId = (Integer) generalMap.get("hospitalId");
		Session session = (Session) getSession();
		List<UserHospital> searchUserUsergroupHospitalList = new ArrayList<UserHospital>();
/*		searchUserUsergroupHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserHospital ");*/
	
		/*hospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where lower(mc.Status) = 'y'");
	
*/
		/*gridUsersList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc");
		gridMasHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc ");*/
	
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("mdistrictList", mdistrictList);
		map.put("searchUserUsergroupHospitalList",searchUserUsergroupHospitalList);
		map.put("hospitalList", hospitalList);
		map.put("usersList", usersList);
		map.put("gridMasHospitalList", gridMasHospitalList);
		map.put("gridUsersList", gridUsersList);
		return map;

	}

	public boolean addUserHospitalMaintenance(Map<String, Object> generalMap) {
		UserHospital userHospital = new UserHospital();
		List<UserHospital> userHospitalList=new ArrayList<UserHospital>();

		int userId=Integer.parseInt(String.valueOf(generalMap.get("userId")));
		String loginName=String.valueOf(generalMap.get("loginName"));
		Date currentDate=(Date) generalMap.get("currentDate");
		int changedBy=Integer.parseInt(String.valueOf(generalMap.get("changedBy")));
		String currentTime=String.valueOf(generalMap.get("currentTime"));
		int hospitalId=0;
		int removeHospId=0;
		String removeAll="";
		if(generalMap.get("hospitalId")!=null){
			hospitalId=Integer.parseInt(String.valueOf(generalMap.get("hospitalId")));
		}
		if(generalMap.get("removeHosp")!=null){
			removeHospId=Integer.parseInt(String.valueOf(generalMap.get("removeHosp")));
		}
		if(generalMap.get("removeAll")!=null){
			removeAll=String.valueOf(generalMap.get("removeAll"));
		}
		boolean successfullyAdded = false;
		try {
			Session session=(Session)getSession();

			if(hospitalId>0){
				userHospitalList=session.createCriteria(UserHospital.class)
						.add(Restrictions.eq("User.Id", userId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				
				if(userHospitalList.size()>0){
					UserHospital userHosp=userHospitalList.get(0);
					if(userHosp.getStatus().equalsIgnoreCase("n")){
						userHosp.setStatus("y");
						userHosp.setLastChgDate(currentDate);
						userHosp.setLastChgTime(currentTime);
						userHosp.setLastChgBy(new Users(changedBy));
						session.update(userHosp);
					}
				}else {
					userHospital.setHospital(new MasHospital(hospitalId));
					userHospital.setStatus("y");
					userHospital.setUser(new Users(userId));
					userHospital.setLastChgDate(currentDate);
					userHospital.setLastChgTime(currentTime);
					userHospital.setLastChgBy(new Users(changedBy));
					
					session.save(userHospital);
				}
			}else if(removeAll!="" && removeAll.equalsIgnoreCase("yes")){
				userHospitalList=session.createCriteria(UserHospital.class)
						.add(Restrictions.eq("User.Id", userId))
						.list();
				if(userHospitalList.size()>0){
					for(UserHospital userHos:userHospitalList){
						userHos.setStatus("n");
						userHos.setLastChgDate(currentDate);
						userHos.setLastChgTime(currentTime);
						userHos.setLastChgBy(new Users(changedBy));
						
						session.update(userHos);
					}
				}
			}else if(removeHospId>0){
				userHospitalList=session.createCriteria(UserHospital.class)
						.add(Restrictions.eq("User.Id", userId))
						.add(Restrictions.eq("Hospital.Id", removeHospId))
						.list();
				UserHospital userHo=userHospitalList.get(0);
				userHo.setStatus("n");
				userHo.setLastChgDate(currentDate);
				userHo.setLastChgTime(currentTime);
				userHo.setLastChgBy(new Users(changedBy));
				
				session.update(userHo);
			}
			
			session.flush();
			
			
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded=false;
		}

		return successfullyAdded;
	}

	public boolean deleteUserHospitalMaintenance(int userHospitalMaintenanceId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		int userId=0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserHospital userHospital = new UserHospital();
		userHospital = (UserHospital) getHibernateTemplate()
				.get(UserHospital.class, userHospitalMaintenanceId);
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				userHospital.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				userHospital.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		userHospital.setLastChgBy(users);
		userHospital.setLastChgDate(currentDate);
		userHospital.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(userHospital);
		return dataDeleted;
	}

	public boolean editUserHospitalMaintenance(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int userHospitalMaintenanceId = 0;
		int usersId = 0;
		int userId=0;
		//int groupHospitalId = 0;
		Date currentDate = new Date();
		//Date validUpto = new Date();
		String currentTime = "";
		int hospitalId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		//String changedBy = "";
		userHospitalMaintenanceId = (Integer) generalMap.get("id");
		usersId = (Integer) generalMap.get("usersId");
		userId = (Integer) generalMap.get("userId");
		hospitalId = (Integer) generalMap.get("hospitalId");
		//groupHospitalId = (Integer) generalMap.get("groupHospitalId");

		//validUpto = (Date) generalMap.get("validUpto");
		//changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		LOGGER.info("usersId---------"+usersId);
		LOGGER.info("hospitalId--------"+hospitalId);
		LOGGER.info("userHospitalMaintenanceId--------"+userHospitalMaintenanceId);
		UserHospital userHospital = (UserHospital) getHibernateTemplate()
				.get(UserHospital.class, userHospitalMaintenanceId);

		userHospital.setId(userHospitalMaintenanceId);

		Users masUserGroups = new Users();
		masUserGroups.setId(usersId);
		userHospital.setUser(masUserGroups);
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		userHospital.setHospital(hospital);
		
		Users lastChgBy = new Users();
		lastChgBy.setId(userId);
		userHospital.setLastChgBy(lastChgBy);

		//UsergroupHospital usergroupHospital = new UsergroupHospital();
		//usergroupHospital.setId(groupHospitalId);
		//masUsergroupHospital.setGroupHospital(usergroupHospital);

		//masUsergroupHospital.setValidUpto(validUpto);
		//masUsergroupHospital.setLastChgBy(changedBy);
		
		
		userHospital.setLastChgDate(currentDate);
		userHospital.setLastChgTime(currentTime);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(userHospital);
			hbt.refresh(userHospital);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> searchUserHospitalMaintenance(String userName) {
		List<UserHospital> searchUserUsergroupHospitalList = new ArrayList<UserHospital>();
		Map<String, Object> userUsergroupHospitalFieldsMap = new HashMap<String, Object>();
		/*List<Users> usersList = new ArrayList<Users>();
		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();*/
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		Session session=(Session)getSession();
		try {
			if ((userName != null)) {

				searchUserUsergroupHospitalList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.UserHospital as imc where imc.User.LoginName = '"
								+ userName + "' and imc.Status='y' order by imc.User.LoginName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*usersList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where lower(mc.Status) = 'y'");
		gridUsersList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc");
		hospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where lower(mc.Status) = 'y'");
		gridMasHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc");
	//	groupList = getHibernateTemplate().find("from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
//		gridGroupList = getHibernateTemplate().find("from jkt.hms.masters.business.UserGroups as mc where mc.Status = 'y'");
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");*/
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		
		userUsergroupHospitalFieldsMap.put("mhospitalTypetList", mhospitalTypetList);
		userUsergroupHospitalFieldsMap.put("mdistrictList", mdistrictList);
		userUsergroupHospitalFieldsMap.put("searchUserUsergroupHospitalList",
				searchUserUsergroupHospitalList);
		/*userUsergroupHospitalFieldsMap.put("hospitalList", hospitalList);
		userUsergroupHospitalFieldsMap.put("gridMasHospitalList",
				gridMasHospitalList);
		userUsergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		userUsergroupHospitalFieldsMap.put("usersList", usersList);
		userUsergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);*/

		return userUsergroupHospitalFieldsMap;
	}/*
	 * public Map<String, Object> searchUserHospitalMaintenance(String userName,
	 * String hospitalName) { List<UserUsergroupHospital>
	 * searchUserUsergroupHospitalList=new ArrayList<UserUsergroupHospital>();
	 * Map<String,Object> userUsergroupHospitalFieldsMap = new
	 * HashMap<String,Object>(); List<Users> usersList = new ArrayList<Users>();
	 * List<Users> gridUsersList = new ArrayList<Users>();
	 * List<UsergroupHospital> hospitalList = new
	 * ArrayList<UsergroupHospital>(); List<UsergroupHospital>
	 * gridMasHospitalList = new ArrayList<UsergroupHospital>(); try{
	 * if((userName!=null) || (hospitalName==null)){
	 * 
	 * searchUserUsergroupHospitalList=getHibernateTemplate().find("from
	 * jkt.security.masters.business.UserUsergroupHospital imc where
	 * imc.User.UserName like '"+ userName+"%' order by imc.Group.UserName"); }
	 * else{ searchUserUsergroupHospitalList=getHibernateTemplate().find("from
	 * jkt.security.masters.business.UserUsergroupHospital imc where
	 * imc.GroupHospital.Hospital.HospitalName like '"+ hospitalName+"%' order
	 * by imc.GroupHospital.Hospital.HospitalName");} }catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * usersList = getHibernateTemplate().find( "from
	 * jkt.security.masters.business.Users as mc where mc.Status = 'y'");
	 * gridUsersList = getHibernateTemplate().find( "from
	 * jkt.security.masters.business.Users as mc where mc.Status = 'y'");
	 * hospitalList = getHibernateTemplate().find( "from
	 * jkt.security.masters.business.UsergroupHospital as mc where mc.Status =
	 * 'y'"); gridMasHospitalList = getHibernateTemplate().find( "from
	 * jkt.security.masters.business.UsergroupHospital as mc where mc.Status =
	 * 'y'");
	 * 
	 * userUsergroupHospitalFieldsMap.put("searchUserUsergroupHospitalList",
	 * searchUserUsergroupHospitalList);
	 * userUsergroupHospitalFieldsMap.put("hospitalList",hospitalList);
	 * userUsergroupHospitalFieldsMap
	 * .put("gridMasHospitalList",gridMasHospitalList);
	 * userUsergroupHospitalFieldsMap.put("gridUsersList",gridUsersList);
	 * userUsergroupHospitalFieldsMap.put("usersList",usersList); return
	 * userUsergroupHospitalFieldsMap; }
	 */

	public List<Object> getUserGroupForHospital(int hospitalId) {

		MasHospital hospital = new MasHospital();

		List<Object> userGroupForHospitalList = new ArrayList<Object>();

		userGroupForHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital mh join mh.UsergroupHospitals as ugh join ugh.Group as grp where mh.Id = "
						+ hospitalId);


		return userGroupForHospitalList;
	}

	public Map<String, Object> getGroupHospitalIdFromUsergroupHospital(
			int groupId, int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();

		try {

			groupHospitalIdList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.Hospital.Id ="
							+ hospitalId + "and ugh.Group.Id=" + groupId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("groupHospitalIdList", groupHospitalIdList);
		return map;
	}

	// ********************************************************************************************//
	// ************************************End Modules of
	// Mansi******************************//
	// *******************************************************************************************//

	// =====================================================================================================
	// ================== adding application by abha============
	// =====================================================================================================

	// method to get application list from masApplication
	@SuppressWarnings({ "unused", "unchecked" })
	public List<MasApplication> getApplicationList() {
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		String no = "";
		int temp = 0;
		MasApplication masApp1 = new MasApplication();
		String applicationId = "";

		List objectList = new ArrayList();
		session = (Session) getSession();
		applicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication where lower(Status)='y' order by Name");

		return applicationList;
	}

	public List<MasApplication> getApplicationIdList() {
		List objectList = new ArrayList();
		String no = "";
		int temp = 0;
		session = (Session) getSession();

		// String qry="SELECT substring(app_id,2) as number, app_id FROM
		// mas_application ORDER BY CAST(number AS DECIMAL)";
		/*
		 * This Line is commented By Ram Dular Prajapati on date 30 July 2010
		 */
		//String qry = "SELECT CAST(substring(app_id,2) as UNSIGNED) as number, app_id FROM mas_application order by number";
		String qry ="SELECT CAST(substring(app_id,2,10) as int) as number, app_id FROM mas_application order by number";

		objectList = (List) session.createSQLQuery(qry).list();
		Object[] pair = (Object[]) objectList.get(objectList.size() - 1);
		// String lastNo = (String) pair[0];
		return objectList;
	}

	// method to get group list from userGroups
	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> getGroupList(Box box) {
		Map map = new HashMap<String, Object>();
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.UsergroupHospital as mi where  mi.Hospital.Id = "
						+ 1 + "");
		map.put("second_combo", groupList);
		return map;
	}

	// method to add applications in masApplication and groupApplication
	public boolean addApplication(Map<String, Object> infoMap) {
		@SuppressWarnings("unused")
		Box box = null;
		List<Integer> maxOrderNoList = new ArrayList<Integer>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String parentIdTemp = "";
		String subPrId = "";
		String parentId = "";
		if (infoMap.get("parentIdTemp") != null) {
			parentIdTemp = "" + infoMap.get("parentIdTemp");
		}
		if (box.get("subPrId") != null) {
			subPrId = "" + box.get("subPrId");
		}
		boolean successfullyAdded = false;
		try {
			parentIdTemp = "" + box.get("prId");
			try {
				if (parentIdTemp != "") {
					int index1 = parentIdTemp.lastIndexOf("[");
					int index2 = parentIdTemp.lastIndexOf("]");
					index1++;
					parentId = parentIdTemp.substring(index1, index2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String appIdTemp = "" + box.get("applicationName");
			String appName = "";
			int appId = 0;
			try {
				int index1 = appIdTemp.lastIndexOf("[");
				int index2 = appIdTemp.lastIndexOf("]");
				index1++;
				appName = appIdTemp.substring(0, index1 - 1);
				appId = Integer.parseInt(""
						+ appIdTemp.substring(index1, index2));
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
			maxOrderNoList = hbt
					.find("select max(OrderNo) from jkt.hms.masters.business.MasApplication ");
			int orderNo = maxOrderNoList.get(0);
			orderNo = orderNo + 1;
			UserApplications userApplications = (UserApplications) getHibernateTemplate()
					.load(UserApplications.class, appId);
			userApplications.setStatus("n");
			hbt.update(userApplications);
			hbt.refresh(userApplications);
			if (!parentId.equals("") && subPrId.equals("")) {
				@SuppressWarnings("unused")
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName(appName);
				masApplication.setParentId(parentId);
				masApplication.setUrl("" + box.get("url"));
				masApplication.setOrderNo(orderNo);
				masApplication.setStatus(box.getString("status"));
				hbt.save(masApplication);
				hbt.refresh(masApplication);

			/*	GroupApplication groupApplication = new GroupApplication();
				groupApplication.setApp(new MasApplication(""
						+ box.get("applicationId")));
				groupApplication.setStatus("y");
				groupApplication
						.setGroup(new UserGroups(box.getInt("groupId")));
				hbt.save(groupApplication);// ////////////////////////////////////
				hbt.refresh(groupApplication);*/

			} else if (parentId.equals("") && subPrId.equals("")) {
				// Adding parent Id
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName("" + appName);
				masApplication.setParentId("0");
				masApplication.setUrl("#");
				masApplication.setOrderNo(orderNo);
				hbt.save(masApplication);
				hbt.refresh(masApplication);

				/*GroupApplication groupApplication = new GroupApplication();
				groupApplication.setApp(new MasApplication(""
						+ box.get("applicationId")));
				groupApplication.setStatus("y");
				groupApplication
						.setGroup(new UserGroups(box.getInt("groupId")));
				hbt.save(groupApplication);
				hbt.refresh(groupApplication);*/
			} else if (!parentId.equals("") && !subPrId.equals("")) {
				// Adding parent Id
				MasApplication masApplication = new MasApplication();
				masApplication.setId("" + box.get("applicationId"));
				masApplication.setName("" + appName);
				masApplication.setParentId(subPrId);
				masApplication.setUrl("" + box.get("url"));
				masApplication.setOrderNo(orderNo);
				hbt.save(masApplication);
				hbt.refresh(masApplication);

			/*	GroupApplication groupApplication = new GroupApplication();
				groupApplication.setApp(new MasApplication(""
						+ box.get("applicationId")));
				groupApplication.setStatus("y");
				groupApplication
						.setGroup(new UserGroups(box.getInt("groupId")));
				hbt.save(groupApplication);
				hbt.refresh(groupApplication);*/
			}
			successfullyAdded = true;
		} catch (Exception e) {
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> checkForExistingApplication(int groupId,
			String applicationName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		List<GroupApplication> applicationList = new ArrayList<GroupApplication>();
		groupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupApplication as hm where hm.GroupId = '"
						+ groupId + "' ");

		applicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication as hm where hm.Name= '"
						+ applicationName + "'");
		map.put("groupList", groupList);
		map.put("applicationList", applicationList);

		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List<UsergroupHospital> getGroupList() {
		List<UsergroupHospital> groupList = new ArrayList<UsergroupHospital>();
		groupList = (List) getHibernateTemplate()
				.find("from jkt.hms.masters.business.UsergroupHospital as uugh where uugh.Hospital.Id = '1' ");
		return groupList;

	}

	public List<MasHospital> getHospitallistList() {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		hospitalList = (List) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as uugh where uugh.Id = '1' ");
		return hospitalList;

	}

	Session session;

	public Map<String, Object> getApplicationListByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> applicationList = new ArrayList<MasApplication>();
		List<MasApplication> allApplicationList = new ArrayList<MasApplication>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			String qry = "SELECT name FROM mas_application";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasApplication.class)
					.add(Restrictions.ilike("Name", str))
					.add(Restrictions.in("Name", objectList));
		//	c.setFirstResult(0);
			//c.setMaxResults(10);
			applicationList = c.list();
			allApplicationList = session.createCriteria(MasApplication.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("applicationList", applicationList);
		map.put("allApplicationList", allApplicationList);
		return map;

	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchApplication(String applicationId) {
		List<MasApplication> searchApplicationList = new ArrayList<MasApplication>();
//		List<GroupApplication> searchGroupList = new ArrayList<GroupApplication>();
		List<MasApplication> searchParentNameList = new ArrayList<MasApplication>();
		List<MasApplication> searchParentList = new ArrayList<MasApplication>();
		Map<String, Object> map = new HashMap<String, Object>();
		MasApplication masApp = new MasApplication();
		GroupApplication groupApplication = new GroupApplication();
		int groupApplicationId = 0;
		String parentId = "";

		String searchParentName = "";

		searchApplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication imc where imc.Id = '"
						+ applicationId + "' order by imc.Name");
		if (searchApplicationList.size() > 0) {
			masApp = (MasApplication) searchApplicationList.get(0);
			applicationId = masApp.getId();
			parentId = masApp.getParentId();
			if (!parentId.equals("0")) {
				searchParentName = masApp.getApplication().getName();
			}
		}

		/*searchGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupApplication ga where ga.App= '"
						+ applicationId + "'");
		if (searchGroupList.size() > 0) {
			groupApplication = (GroupApplication) searchGroupList.get(0);
			groupApplicationId = groupApplication.getId();
		}
		map.put("groupApplicationId", groupApplicationId);
		map.put("searchGroupList", searchGroupList);*/
		map.put("searchApplicationList", searchApplicationList);
		map.put("parentId", parentId);

		map.put("searchParentName", searchParentName);
		return map;
	}

	@SuppressWarnings("unused")
	public boolean updateApplication(Map<String, Object> map) {
		boolean dataUpdated = false;
		String applicationId = "";
		String applicationName = "";
		String url = "";
		int orderNo = 0;
		String parentId = "";
		int groupId = 0;
		String status = "";
		int groupAppId = 0;
		int groupAppl = 0;
		int groupApplicationId = 0;
		try {
			applicationId = (String) map.get("applicationId");
			applicationName = (String) map.get("applicationName");
			url = (String) map.get("url");
			parentId = (String) map.get("parentId");
			// orderNo=(Integer)map.get("orderNo");
			groupId = (Integer) map.get("groupId");
			status = (String) map.get("status");
			groupApplicationId = (Integer) map.get("groupApplicationId");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasApplication masApplication = (MasApplication) getHibernateTemplate()
				.get(MasApplication.class, applicationId);
		masApplication.setId(applicationId);
		masApplication.setName(applicationName);
		masApplication.setUrl(url);
		masApplication.setParentId(parentId);
		masApplication.setStatus(status);
		// masApplication.setOrderNo(orderNo);

	/*	GroupApplication groupApplication = (GroupApplication) getHibernateTemplate()
				.get(GroupApplication.class, groupApplicationId);
		UserGroups userGroups = new UserGroups();
		userGroups.setId(groupId);
		groupApplication.setGroup(userGroups);
		groupApplication.setStatus(status);
		MasApplication masApp = new MasApplication();
		masApp.setId(applicationId);
		groupApplication.setApp(masApp);
*/
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masApplication);
		//	hbt.update(groupApplication);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	// ============================== USER DEPARMENT
	// ======================================
	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> showUserDepartmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		List<Users> searchUsersList = new ArrayList<Users>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Users> userList = new ArrayList<Users>();

		searchUsersList = getHibernateTemplate()
				.find("select distinct ud.User from jkt.hms.masters.business.UserDepartment ud ");
		searchUserDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserDepartment");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where lower(mc.Status) = 'y'");
		userList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where lower(mc.Status) = 'y'");

		map.put("searchUserDepartmentList", searchUserDepartmentList);
		map.put("departmentList", departmentList);
		map.put("userList", userList);
		map.put("searchUsersList", searchUsersList);
		return map;
	}

	public Map<String, Object> checkForExistingUserDepartment(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateUserDepartmentList = new ArrayList();
		int userId = (Integer) generalMap.get("userId");
		duplicateUserDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserDepartment ugh where ugh.User.Id="
						+ userId);
		map.put("duplicateUserDepartmentList", duplicateUserDepartmentList);

		return map;
	}

	public boolean addUserDepartment(Map<String, Object> generalMap) {

		String deptStr = null;
		int userId = 0;
		if (generalMap.get("deptStr") != null) {
			deptStr = (String) generalMap.get("deptStr");
		}

		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}

		boolean successfullyAdded = false;
		StringTokenizer strForDept = new StringTokenizer(deptStr, ",");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			while (strForDept.hasMoreTokens()) {
				UserDepartment userDepartment = new UserDepartment();
				int deptId = Integer.parseInt(strForDept.nextToken());
				userDepartment.setDepartment(new MasDepartment(deptId));
				userDepartment.setUser(new Users(userId));
				userDepartment.setStatus("y");
				hbt.save(userDepartment);
				hbt.refresh(userDepartment);
			}
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchUserDepartment(String userName,
			String departmentName) {
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> searchUsersList = new ArrayList<Users>();
		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridMasDepartmentList = new ArrayList<MasDepartment>();
		try {
			if ((userName != null)) {
				searchUserDepartmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserDepartment");
				searchUsersList = getHibernateTemplate()
						.find("select distinct ud.User from jkt.hms.masters.business.UserDepartment ud where ud.User.UserName like '%"
								+ userName + "%' order by ud.User.UserName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		userList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where lower(mc.Status) = 'y'");
		gridUsersList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where lower(mc.Status) = 'y'");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where lower(mc.Status) = 'y'");
		gridMasDepartmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where lower(mc.Status) = 'y'");

		usergroupHospitalFieldsMap.put("searchUserDepartmentList",
				searchUserDepartmentList);
		usergroupHospitalFieldsMap.put("departmentList", departmentList);
		usergroupHospitalFieldsMap.put("gridMasDepartmentList",
				gridMasDepartmentList);
		usergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		usergroupHospitalFieldsMap.put("userList", userList);
		usergroupHospitalFieldsMap.put("searchUsersList", searchUsersList);
		return usergroupHospitalFieldsMap;
	}

	public boolean editUserDepartment(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		int userDepartmentId = 0;
		int userId = 0;
		int departmentId = 0;
		String departmentStr = null;

		userDepartmentId = (Integer) generalMap.get("id");
		userId = (Integer) generalMap.get("userId");

		if (generalMap.get("departmentStr") != null) {
			departmentStr = (String) generalMap.get("departmentStr");
		}
		StringTokenizer str = new StringTokenizer(departmentStr, ",");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<UserDepartment> userDepartmentList = hbt
					.find("from jkt.hms.masters.business.UserDepartment ud where ud.User.Id="
							+ userId);
			for (Iterator iterator = userDepartmentList.iterator(); iterator
					.hasNext();) {
				UserDepartment userDepartment = (UserDepartment) iterator
						.next();
				int id = userDepartment.getId();
				String hql = "delete from jkt.hms.masters.business.UserDepartment as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			while (str.hasMoreTokens()) {
				UserDepartment userDepartment = new UserDepartment();
				int deptId = Integer.parseInt(str.nextToken());
				userDepartment.setUser(new Users(userId));
				userDepartment.setDepartment(new MasDepartment(deptId));
				userDepartment.setStatus("y");
				hbt.save(userDepartment);
				hbt.refresh(userDepartment);
				dataUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	public boolean deleteUserDepartment(int userDepartmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		int userId = 0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (generalMap.get("flag") != null) {
				List<UserDepartment> userDepartmentList = hbt
						.find("from jkt.hms.masters.business.UserDepartment as isc where isc.User.Id="
								+ userId);
				String flag = (String) generalMap.get("flag");

				for (Iterator iterator = userDepartmentList.iterator(); iterator
						.hasNext();) {
					UserDepartment userDepartment = (UserDepartment) iterator
							.next();
					if (flag.equals("InActivate")) {
						userDepartment.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						userDepartment.setStatus("y");
						dataDeleted = false;
					}
					hbt.update(userDepartment);
					hbt.refresh(userDepartment);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		}

		return dataDeleted;
	}

	public Map<String, Object> getEmpName(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dataMap.get("serviceNo") != null) {
			serviceNo = (String) dataMap.get("serviceNo");
		}
		Session session = (Session) getSession();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		empList = hbt
				.find("from jkt.hms.masters.business.MasEmployee where ServiceNo="
						+ serviceNo + "and Status='y'");
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> searchUserDepartment(Box box) {
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		Map<String, Object> usergroupHospitalFieldsMap = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> searchUsersList = new ArrayList<Users>();
		List<Users> gridUsersList = new ArrayList<Users>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridMasDepartmentList = new ArrayList<MasDepartment>();
		org.hibernate.Criteria criteria = null;
		String userSearch = box.getString("userSearch").trim();
		String loginSearch = box.getString("loginSearch").trim();

		Session session = (Session) getSession();
		try {

			searchUserDepartmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.UserDepartment");
			// searchUsersList = getHibernateTemplate().find("select distinct
			// ud.User from jkt.hms.masters.business.UserDepartment ud where
			// ud.User.UserName like '%"+ userName+"%' order by
			// ud.User.UserName");
			try {
				criteria = session.createCriteria(Users.class).add(
						Restrictions.eq("Status", "y"));

				if (userSearch != null & !userSearch.equals("")) {
					criteria = criteria.add(Restrictions.like("UserName", "%"
							+ userSearch + "%"));
				}
				if (loginSearch != null & !loginSearch.equals("")) {
					criteria = criteria.add(Restrictions.like("LoginName", "%"
							+ loginSearch + "%"));
				}
				searchUsersList = criteria.list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		userList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		gridUsersList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Users as mc where mc.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		gridMasDepartmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");

		usergroupHospitalFieldsMap.put("searchUserDepartmentList",
				searchUserDepartmentList);
		usergroupHospitalFieldsMap.put("departmentList", departmentList);
		usergroupHospitalFieldsMap.put("gridMasDepartmentList",
				gridMasDepartmentList);
		usergroupHospitalFieldsMap.put("gridUsersList", gridUsersList);
		usergroupHospitalFieldsMap.put("userList", userList);
		usergroupHospitalFieldsMap.put("searchUsersList", searchUsersList);
		return usergroupHospitalFieldsMap;

	}

	public Map<String, Object> searchUserDepartment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	// ===================== Methods Written by Vivek
	// =========================Start========================

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUrl(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int appId = 0;
		if (map.get("appId") != null) {
			appId = Integer.parseInt("" + map.get("appId"));
		}
		Session session = (Session) getSession();
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();
		if (appId != 0) {
			Criteria c = session.createCriteria(UserApplications.class).add(
					Restrictions.eq("Id", appId));
			userApplicationsList = c.list();
		}
		dataMap.put("userApplicationsList", userApplicationsList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getParentApplication(Map<String, Object> map) {
		@SuppressWarnings("unused")
		String prAppName = "";
		if (map.get("prAppName") != null) {
			prAppName = "" + map.get("prAppName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + prAppName + "%";
		@SuppressWarnings("unused")
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		Criteria c = session
				.createCriteria(MasApplication.class)
				// .setFirstResult(0)
				// .setMaxResults(10)
				.add(Restrictions.like("Name", str))
				.addOrder(Order.desc("Name"));
		masApplicationList = c.list();
		dataMap.put("masApplicationList", masApplicationList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getApplicationForAutoComplete(
			Map<String, Object> map) {
		@SuppressWarnings("unused")
		String appName = "";
		if (map.get("appName") != null) {
			appName = "" + map.get("appName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + appName + "%";
		@SuppressWarnings("unused")
		List<UserApplications> userApplicationsList = new ArrayList<UserApplications>();
		Criteria c = session.createCriteria(UserApplications.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.ilike("AppName", str));
		userApplicationsList = c.list();
		dataMap.put("userApplicationsList", userApplicationsList);
		return dataMap;

	}

	public boolean addUserApplication(UserApplications userApplications) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(userApplications);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteUserApplication(int userApplicationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		UserApplications userApplications = new UserApplications();
		userApplications = (UserApplications) getHibernateTemplate().get(
				UserApplications.class, userApplicationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				userApplications.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				userApplications.setStatus("y");
				dataDeleted = false;
			}
		}
		userApplications.setLastChgBy(changedBy);
		userApplications.setLastChgDate(currentDate);
		userApplications.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(userApplications);
		return dataDeleted;
	}

	public boolean editUserApplication(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String applicationName = "";
		String url = "";
		@SuppressWarnings("unused")
		int userApplicationId = 0;
		String changedBy = "";
		userApplicationId = (Integer) generalMap.get("id");
		url = (String) generalMap.get("url");
		applicationName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		UserApplications userApplications = (UserApplications) getHibernateTemplate()
				.get(UserApplications.class, userApplicationId);

		userApplications.setId(userApplicationId);
		userApplications.setUrl(url);
		userApplications.setAppName(applicationName);
		userApplications.setLastChgBy(changedBy);
		userApplications.setLastChgDate(currentDate);
		userApplications.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(userApplications);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchUserApplication(String applicationName) {
		List<UserApplications> searchUserApplicationList = new ArrayList<UserApplications>();
		Map<String, Object> userApplicationFieldsMap = new HashMap<String, Object>();
		try {
			if ((applicationName != null)) {
				searchUserApplicationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.UserApplications mr where lower(mr.AppName) like lower('%"
								+ applicationName + "%') order by mr.AppName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userApplicationFieldsMap.put("searchUserApplicationList",
				searchUserApplicationList);
		return userApplicationFieldsMap;
	}

	public Map<String, Object> showUserApplicationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserApplications> searchUserApplicationList = new ArrayList<UserApplications>();
		searchUserApplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.UserApplications ");
		map.put("searchUserApplicationList", searchUserApplicationList);
		return map;
	}

	// ADDED by Kalyan
	public Map<String, Object> getSubParentApplication(Map<String, Object> map) {
		@SuppressWarnings("unused")
		String parentId = "";
		if (map.get("parentId") != null) {
			parentId = "" + map.get("parentId");
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		Criteria c = session
				.createCriteria(MasApplication.class)
				// .setFirstResult(0)
				// .setMaxResults(10)
				.add(Restrictions.eq("ParentId", parentId))
				.addOrder(Order.asc("Name"));
		masApplicationList = c.list();
		dataMap.put("masApplicationList", masApplicationList);
		return dataMap;
	}

	// Added by kalyan for Getting user List
	public Map<String, Object> showUserList() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> users = new ArrayList<Users>();
		org.hibernate.Criteria criteria = null;
		try {
			criteria = session.createCriteria(Users.class).add(
					Restrictions.eq("Status", "y").ignoreCase());
			users = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("users", users);
		return map;
	}

	// ===================== Methods Written by Vivek
	// =========================End==========================

	// ==========================methods written by vikas for emp
	// groups================================
	@SuppressWarnings("unchecked")
	public Map<String, Object> showGroupsJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<UserGroups> searchUserGroupsList = new ArrayList<UserGroups>();
		searchUserGroupsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.EmpGroups ");
		map.put("searchUserGroupsList", searchUserGroupsList);

		return map;
	}

	public Map<String, Object> searchEmpGroups(String empGroupsCode,
			String empGroupsName) {
		List<EmpGroups> searchUserGroupsList = new ArrayList<EmpGroups>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((empGroupsName != null) || (empGroupsCode == null)) {

				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.EmpGroups imc where imc.EmpGroupName like '%"
								+ empGroupsName
								+ "%' order by imc.EmpGroupName");
			} else {
				searchUserGroupsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.EmpGroups imc where imc.EmpGroupCode like '%"
								+ empGroupsCode
								+ "%' order by imc.EmpGroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userGroupsFieldsMap.put("searchUserGroupsList", searchUserGroupsList);
		return userGroupsFieldsMap;
	}

	public boolean addEmpGroups(EmpGroups masUserGroups) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUserGroups);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editEmpGroupsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empGroupsName = "";
		@SuppressWarnings("unused")
		String empGroupsCode = "";
		int empGroupsId = 0;
		String changedBy = "";
		try {
			empGroupsId = (Integer) generalMap.get("id");
			empGroupsCode = (String) generalMap.get("empGroupsCode");
			empGroupsName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		EmpGroups masUserGroups = (EmpGroups) getHibernateTemplate().load(
				EmpGroups.class, empGroupsId);

		masUserGroups.setId(empGroupsId);
		masUserGroups.setEmpGroupName(empGroupsName);
		/*
		 * masUserGroups.setLastChgBy(changedBy);
		 * masUserGroups.setLastChgDate(currentDate);
		 * masUserGroups.setLastChgTime(currentTime);
		 */
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masUserGroups);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unused")
	public boolean deleteEmpGroups(int empGroupId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		EmpGroups masUserGroups = new EmpGroups();
		masUserGroups = (EmpGroups) getHibernateTemplate().get(EmpGroups.class,
				empGroupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUserGroups.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUserGroups.setStatus("y");
				dataDeleted = false;
			}
		}
		masUserGroups.setLastChgBy(changedBy);
		masUserGroups.setLastChgDate(currentDate);
		masUserGroups.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masUserGroups);
		return dataDeleted;
	}

	// ============method added to add the employee groups for the
	// users========================
	@SuppressWarnings("unchecked")
	public boolean addUser(Users users, String[] empGroupIdArray, Map generalMap) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(users);
		String changedBy = (String) generalMap.get("changedBy");
		Date currentDate = new Date();
		String currentTime = (String) generalMap.get("currentTime");
		int hospitalId = (Integer) generalMap.get("hospitalId");
		for (int i = 0; i < empGroupIdArray.length; i++) {
			UserEmpGroup userEmpGroup = new UserEmpGroup();
			userEmpGroup.setUser(users);
			EmpGroups empGroups = new EmpGroups();
			empGroups.setId(Integer.parseInt(empGroupIdArray[i]));
			userEmpGroup.setEmpGroup(empGroups);
			userEmpGroup.setStatus("y");
			userEmpGroup.setLastChgBy(changedBy);
			userEmpGroup.setLastChgDate(currentDate);
			userEmpGroup.setLastChgTime(currentTime);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			userEmpGroup.setHospital(masHospital);
			hbt.save(userEmpGroup);
		}

		successfullyAdded = true;
		return successfullyAdded;
	}

	// -------------------end of methods for emp groups-------------------

	// ============method added by vikas 0n
	// 29/04/09===================================

	public Map<String, Object> showButtonMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> searchButtonDetailsList = new ArrayList<MasHospital>();
		searchButtonDetailsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasButtonForm ");
		map.put("searchButtonDetailsList", searchButtonDetailsList);
		return map;
	}

	public boolean addButtonDetails(MasButtonForm masButtonForm) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masButtonForm);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editButtonDetails(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String formName = "";
		@SuppressWarnings("unused")
		String buttonName = "";
		int masButtonId = 0;
		String changedBy = "";
		String url = "";
		String cssClass = "";
		String formulaUsed = "";
		try {
			masButtonId = (Integer) generalMap.get("id");
			buttonName = (String) generalMap.get("buttonName");
			formName = (String) generalMap.get("name");
			url = (String) generalMap.get("url");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			cssClass = (String) generalMap.get("cssClass");
			formulaUsed = (String) generalMap.get("formulaUsed");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasButtonForm masButtonForm = (MasButtonForm) hbt.load(
					MasButtonForm.class, masButtonId);

			// masButtonForm.setId(empGroupsId);
			masButtonForm.setButtonName(buttonName);
			masButtonForm.setFormName(formName);
			masButtonForm.setUrl(url);
			masButtonForm.setLastChgBy(changedBy);
			masButtonForm.setLastChgDate(currentDate);
			masButtonForm.setLastChgTime(currentTime);
			masButtonForm.setClassName(cssClass);
			masButtonForm.setFormulaUsed(formulaUsed);
			hbt.update(masButtonForm);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteButtonDetails(int buttonId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasButtonForm masButtonForm = new MasButtonForm();
		masButtonForm = (MasButtonForm) getHibernateTemplate().get(
				MasButtonForm.class, buttonId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masButtonForm.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masButtonForm.setStatus("y");
				dataDeleted = false;
			}
		}
		masButtonForm.setLastChgBy(changedBy);
		masButtonForm.setLastChgDate(currentDate);
		masButtonForm.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masButtonForm);
		return dataDeleted;
	}

	public Map<String, Object> getUerGroupDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		List<UserEmpGroup> userEmpList = new ArrayList<UserEmpGroup>();
		List<UserGroups> AlluserEmpList = new ArrayList<UserGroups>();
		String loginUser = box.getString("loginName");
		Session session = (Session) getSession();
		userList = session.createCriteria(Users.class)
				.add(Restrictions.eq("LoginName", loginUser)).list();
		int userId = 0;
		for (Users user : userList) {
			userId = user.getId();
		}

		userEmpList = session.createCriteria(UserEmpGroup.class)
				.add(Restrictions.eq("User.Id", userId)).list();
		AlluserEmpList = session.createCriteria(UserGroups.class)
				.add(Restrictions.eq("Status", "y")).list();

		// map.put("searchButtonDetailsList",searchButtonDetailsList);
		map.put("userEmpList", userEmpList);
		map.put("AlluserEmpList", AlluserEmpList);
		map.put("userId", userId);
		return map;
	}

	public boolean addUser(Users users, String[] empGroupIdArray,
			String[] appGroupIdArray, Map generalMap, int hospitalId) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(users);
		int userId = (Integer) users.getId();
		String changedBy = (String) generalMap.get("changedBy");
		int deptId = (Integer) generalMap.get("deptId");
		Date currentDate = new Date();
		String currentTime = (String) generalMap.get("currentTime");
		for (int i = 0; i < empGroupIdArray.length; i++) {
			UserEmpGroup userEmpGroup = new UserEmpGroup();
			userEmpGroup.setUser(users);
			EmpGroups empGroups = new EmpGroups();
			empGroups.setId(Integer.parseInt(empGroupIdArray[i]));
			userEmpGroup.setEmpGroup(empGroups);
			userEmpGroup.setStatus("y");
			userEmpGroup.setLastChgBy(changedBy);
			userEmpGroup.setLastChgDate(currentDate);
			userEmpGroup.setLastChgTime(currentTime);
			hbt.save(userEmpGroup);
		}
		Users usersObj = (Users) hbt.load(Users.class, userId);
		// int departmentId=usersObj.getEmployee().getDepartment().getId();
		UserDepartment userDepartment = new UserDepartment();
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		userDepartment.setDepartment(masDepartment);
		Users userObject = new Users();
		userObject.setId(usersObj.getId());
		userDepartment.setUser(userObject);
		userDepartment.setStatus("y");
		hbt.save(userDepartment);

		if (appGroupIdArray != null) {
			for (int i = 0; i < appGroupIdArray.length; i++) {

				List<UsergroupHospital> groupHospitalIdList = new ArrayList<UsergroupHospital>();
				groupHospitalIdList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.UsergroupHospital as ugh where ugh.Hospital.Id ="
								+ hospitalId
								+ "and ugh.Group.Id="
								+ appGroupIdArray[i]);
				if (groupHospitalIdList != null
						&& groupHospitalIdList.size() > 0) {
					UsergroupHospital usergroupHospital = (UsergroupHospital) groupHospitalIdList
							.get(0);
					UserUsergroupHospital masUserUsergroupHospital = new UserUsergroupHospital();
					masUserUsergroupHospital.setUser(users);
					int groupHospitalId = usergroupHospital.getId();

					masUserUsergroupHospital
							.setGroupHospital(new UsergroupHospital(
									groupHospitalId));
					// masUserUsergroupHospital.setValidUpto(null);
					masUserUsergroupHospital.setStatus("y");
					masUserUsergroupHospital.setLastChgBy(changedBy);
					masUserUsergroupHospital.setLastChgDate(currentDate);
					masUserUsergroupHospital.setLastChgTime(currentTime);
					hbt.save(masUserUsergroupHospital);
					hbt.refresh(masUserUsergroupHospital);
				}
			}
		}
		successfullyAdded = true;
		return successfullyAdded;
	}

	/*
	 * public boolean encryptAllUserPassword() { boolean
	 * successfullyAdded=false;
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); Session session =
	 * (Session)getSession(); String loginUser="1111"; List<Users> userList= new
	 * ArrayList<Users>(); userList=session.createCriteria(Users.class).list();
	 * encryptAllUserPassword===="+userList.size()); for(Users user:userList){
	 * int userId=user.getId(); 
	 * Users userObj=(Users)hbt.load(Users.class, userId); String
	 * encryptedPassword=HMSUtil.encryptPassword(userObj.getPassword());
	 * userObj.setPassword(encryptedPassword); hbt.update(userObj);
	 * successfullyAdded=true; }
	 * 
	 * 
	 * return successfullyAdded; }
	 */
	// ========================================methods written by
	// vikas=====================================
	public boolean encryptAllPassword() {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			List<Users> userList = session.createCriteria(Users.class).list();
			for (Users users : userList) {
				String password = HMSUtil.encryptPassword(users.getPassword());
				users.setPassword(password);
				hbt.update(users);

			}

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTemplateJsp(Map<String, Object> dataMap) {
		Session session = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
		List<Object[]> searchTemplateList = new ArrayList<Object[]>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		int hospitalId = 0;
		int userType = 0;
		if(dataMap.get("hospitalId")!=null){
			hospitalId = (Integer)dataMap.get("hospitalId");
		}
		String superAdmin = "";
		if(dataMap.get("superAdmin")!=null){
			superAdmin = (String)dataMap.get("superAdmin");
		}
		String userName = "";
		if(dataMap.get("userName")!=null){
			userName = (String)dataMap.get("userName");
		}
		if(dataMap.get("userType")!=null){
			userType = (Integer)dataMap.get("userType");
		}
		
		if(userType<3){
			searchTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TemplateCode")).add(Projections.property("TemplateName")).add(Projections.property("Hospital")).add(Projections.property("Dept")).add(Projections.property("Status"))).list();
			/*searchTemplateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasTemplate where lower(Status)='y'");*/
		}else{
				/*searchTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id="+hospitalId);*/
			searchTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TemplateName")).add(Projections.property("TemplateCode")).add(Projections.property("Hospital")).add(Projections.property("Dept")).add(Projections.property("Status"))).list();
		}
		map.put("searchTemplateList", searchTemplateList);
		/*Session session = getSession();*/
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		hospitalList= session.createCriteria(MasHospital.class)
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("Status")).add(Projections.property("ShortName"))).list();
		map.put("hospitalList", hospitalList);
		
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("mdistrictList", mdistrictList);
		return map;
	}

	public Map<String, Object> addTemplate(MasTemplate masTemplate,Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List templateCodeList = new ArrayList();
		
		try {
			String code = (String)generalMap.get("code");
			String name = (String)generalMap.get("name");
			int hospitalId = (Integer)generalMap.get("hospitalId");
			Session session = getSession();
			templateCodeList = session.createCriteria(MasTemplate.class).add(Restrictions.or(Restrictions.eq("TemplateCode", code).ignoreCase(), Restrictions.eq("TemplateCode", name).ignoreCase()))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(templateCodeList.size()==0){
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masTemplate);
				successfullyAdded = true;
			}
		} catch (JDBCException jdbce) {
		    jdbce.getSQLException().getNextException().printStackTrace();
		}
		map.put("templateCodeList", templateCodeList);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@SuppressWarnings("unused")
	public Map<String, Object> editTemplate(Map<String, Object> generalMap) {
		Map<String, Object> map =new HashMap<String, Object>();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String templateName = "";
		@SuppressWarnings("unused")
		String templateCode = "";
		int deptId = 0;
		int hospitalId = 0;
		int templateId = 0;
		int userId = 0;
		String status = "";

		try {
			templateId = (Integer) generalMap.get("id");
			templateCode = (String) generalMap.get("templateCode");
			templateName = (String) generalMap.get("templateName");
			deptId = (Integer) generalMap.get("deptId");
			hospitalId = (Integer) generalMap.get("hospitalId");
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List templateCodeList = new ArrayList();
	
		Session session = getSession();
		templateCodeList = session.createCriteria(MasTemplate.class).add(Restrictions.ne("Id", templateId))
				.add(Restrictions.or(Restrictions.eq("TemplateCode", templateCode).ignoreCase(), Restrictions.eq("TemplateCode", templateName).ignoreCase()))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		
		if(templateCodeList.size() == 0){
			MasTemplate masTemplate = (MasTemplate) getHibernateTemplate().get(
					MasTemplate.class, templateId);

			masTemplate.setId(templateId);
			masTemplate.setTemplateCode(templateCode);
			masTemplate.setTemplateName(templateName);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masTemplate.setHospital(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masTemplate.setDept(masDepartment);
			masTemplate.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masTemplate.setLastChgBy(user);

			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.saveOrUpdate(masTemplate);
				dataUpdated = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		map.put("templateCodeList", templateCodeList);
		map.put("dataUpdated", dataUpdated);
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchTemplate(Map<String, Object> dataMap) {
		List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		String templateCode = (String)dataMap.get("templateCode");
		String templateName = (String)dataMap.get("templateName");
		int hospitalId = (Integer)dataMap.get("hospitalId");
		Session session = getSession();
		String superAdmin = "";
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		if(dataMap.get("superAdmin")!=null){
			superAdmin = (String)dataMap.get("superAdmin");
		}
		String userName = "";
		if(dataMap.get("userName")!=null){
			userName = (String)dataMap.get("userName");
		}
		int userType = 4;
		if(dataMap.get("userType")!=null){
			userType = (Integer)dataMap.get("userType");
		}
		try {
			if ((templateName != null) || (templateCode == null)) {
				if(userType<3){
					searchTemplateList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasTemplate imc where lower(imc.TemplateName) like lower('"
								+ templateName + "%') order by imc.TemplateName");
				}else{
					searchTemplateList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasTemplate imc where lower(imc.TemplateName) like lower('"
									+ templateName + "%') and imc.Hospital.Id="+hospitalId+" order by imc.TemplateName");
				}
			} else {
				if( userType<3){
					searchTemplateList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasTemplate imc where lower(imc.TemplateCode) like lower('"
								+ templateCode + "%') order by imc.TemplateCode");
				}else{
					searchTemplateList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasTemplate imc where lower(imc.TemplateCode) like lower('"
									+ templateCode + "%')  and imc.Hospital.Id="+hospitalId+" order by imc.TemplateCode");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		hospitalList= session.createCriteria(MasHospital.class)
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("Status")).add(Projections.property("ShortName"))).list();
		userGroupsFieldsMap.put("hospitalList", hospitalList);
		userGroupsFieldsMap.put("searchTemplateList", searchTemplateList);
		
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		userGroupsFieldsMap.put("mhospitalTypetList", mhospitalTypetList);
		userGroupsFieldsMap.put("mdistrictList", mdistrictList);
		return userGroupsFieldsMap;
	}

	public boolean deleteTemplate(int templateId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTemplate masTemplate = new MasTemplate();
		masTemplate = (MasTemplate) getHibernateTemplate().get(
				MasTemplate.class, templateId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTemplate.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTemplate.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masTemplate.setLastChgBy(user);
		masTemplate.setLastChgDate(currentDate);
		masTemplate.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masTemplate);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getButtonList(String formName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<MasButtonForm> buttonList = new ArrayList<MasButtonForm>();
			buttonList = session.createCriteria(MasButtonForm.class)
					.add(Restrictions.eq("FormName", formName))
					.add(Restrictions.eq("Status", status).ignoreCase()).list();
			map.put("buttonList", buttonList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public List<EmpGroups> getEmpGroupForTemplate() {
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
		session = (Session) getSession();
		empGroupList = session.createCriteria(EmpGroups.class)
				.add(Restrictions.eq("Status", "y")).list();
		return empGroupList;
	}

	@SuppressWarnings("unchecked")
	public List<MasButtonForm> getFormList() {
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		session = (Session) getSession();
		formList = session
				.createSQLQuery(
						"select Distinct(form_name) from  mas_button_form where status='y';")
				.list();

		return formList;
	}

	@SuppressWarnings("unchecked")
	public List<MasApplication> getModuleListForTemplate() {
		List<MasApplication> moduleList = new ArrayList<MasApplication>();
		session = (Session) getSession();
		moduleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication where upper(Status)='Y' and ParentId='"
						+ 0 + "' order by name ASC");
		return moduleList;
	}

	/*@SuppressWarnings({ "unchecked", "unchecked" })
	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();
		@SuppressWarnings("unused")
		List<GroupApplication> grpApplicationList = new ArrayList<GroupApplication>();
		List<UsergroupHospital> userGrpHospitalList = new ArrayList<UsergroupHospital>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		String applicationId = "";
		int groupId = 0;
		int grpAppId = 0;
		int usergrpHospId = 0;
		try {
			String query = "select distinct(button_id) from template_application where template_id='"
					+ templateId + "' and button_id != '" + null + "'";
			buttonTemplateList = (List) session.createSQLQuery(query).list();

			tempAppList = session.createQuery(
					" from TemplateApplication as tempApp where Template.Id = "
							+ templateId).list();

			for (Iterator iterator = tempAppList.iterator(); iterator.hasNext();) {
				TemplateApplication tempApp = (TemplateApplication) iterator
						.next();
				if (tempApp.getApp() != null) {
					applicationId = tempApp.getApp().getId();
				}

				groupAppList = (List<GroupApplication>) session
						.createCriteria(GroupApplication.class)
						.createAlias("App", "app")
						.add(Restrictions.eq("app.Id", applicationId)).list();

				for (Iterator iterator1 = groupAppList.iterator(); iterator1
						.hasNext();) {
					GroupApplication grpApp = (GroupApplication) iterator1
							.next();
					groupId = grpApp.getGroup().getId();

					grpApplicationList = (List<GroupApplication>) session
							.createCriteria(GroupApplication.class)
							.createAlias("App", "app")
							.add(Restrictions.eq("app.Id", applicationId))
							.createAlias("Group", "grp")
							.add(Restrictions.eq("grp.Id", groupId)).list();
					for (Iterator iterator2 = grpApplicationList.iterator(); iterator2
							.hasNext();) {
						GroupApplication grpApplication = (GroupApplication) iterator2
								.next();
						grpAppId = grpApplication.getId();
						grpAppList.add(grpAppId);
					}

					userGrpHospitalList = (List<UsergroupHospital>) session
							.createCriteria(UsergroupHospital.class)
							.createAlias("Hospital", "hsp")
							.add(Restrictions.eq("hsp.Id", hospitalId))
							.createAlias("Group", "grp")
							.add(Restrictions.eq("grp.Id", groupId)).list();
					for (Iterator iterator3 = userGrpHospitalList.iterator(); iterator3
							.hasNext();) {
						UsergroupHospital usrgrpHosp = (UsergroupHospital) iterator3
								.next();
						usergrpHospId = usrgrpHosp.getId();
						usrGrpHospList.add(usergrpHospId);
					}

				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("grpAppList", grpAppList);
		map.put("usrGrpHospList", usrGrpHospList);
		map.put("tempAppList", tempAppList);
		map.put("groupAppList", groupAppList);
		map.put("buttonTemplateList", buttonTemplateList);
		return map;
	}
*/
	@SuppressWarnings("unchecked")
	public List<MasTemplate> getTemplateList(int hospitalId, int userType) {
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		session = (Session) getSession();
		if(userType<3){
			if(userType==1){//added by govind 19-08-2017
				templateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id is null and mt.RemoveId is null order by TemplateName");
				List<MasTemplate> templateList1 = new ArrayList<MasTemplate>();
				Map<String,Boolean> headMap=new HashMap<String,Boolean>();
						int hCount=0;
						for(MasTemplate mas:templateList){
							if(hCount==0){
								headMap.put(mas.getTemplateName(), true);
								templateList1.add(mas);
							}else{
								if(headMap.get(mas.getTemplateName())!=null && headMap.get(mas.getTemplateName())==true){
								}else{
									headMap.put(mas.getTemplateName(), true);
									templateList1.add(mas);
								}
							}
							hCount++;
						}
						templateList=null;
						templateList=templateList1;
				
			}else{
			templateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id= "+hospitalId+" or mt.Hospital.Id is null order by TemplateName");
			}//added by govind 19-08-2017 end
		}else{
			templateList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id= "+hospitalId+" order by TemplateName");
		}
		
		return templateList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTemplateModuleList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		List<Object[]> tempModuleList = new ArrayList<Object[]>();
		session = (Session) getSession();
		int userType=0,hospitalId=0,templateId=0,hositalStatus=0;
		
		if(box.get("hospitalId")!=null){
			hospitalId=box.getInt("hospitalId");
		}
		if(box.get("template")!=null){
			templateId=box.getInt("template");
		}
		if(box.get("userType")!=null){
			userType=box.getInt("userType");
		}
		if(box.get("hositalStatus")!=null){
			hositalStatus=box.getInt("hositalStatus");
		}
		
		String Query = "select t.template_id,t.app_id,m.name from template_application t,mas_application m"
				+ " where t.app_id = m.app_id and m.parent_id = '0' and t.template_id = '"
				+ templateId + "' group by t.template_id,t.app_id,m.name ";
		// templateList =
		// getHibernateTemplate().find("from
		// jkt.hms.masters.business.TemplateApplication where Status='y'"
		// );
		LOGGER.info("hositalStatus "+hositalStatus);
		tempModuleList = (List) session.createSQLQuery(Query).list();
		if(userType<3){
			if(userType==1){//added by govind 19-08-2017
				if(hositalStatus==1){
					templateList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id= "+hospitalId+" order by TemplateName");
						
				}
				if(hositalStatus==0){
				templateList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id is null and mt.RemoveId is null order by TemplateName");
				List<MasTemplate> templateList1 = new ArrayList<MasTemplate>();
				Map<String,Boolean> headMap=new HashMap<String,Boolean>();
						int hCount=0;
						for(MasTemplate mas:templateList){
							if(hCount==0){
								headMap.put(mas.getTemplateName(), true);
								templateList1.add(mas);
							}else{
								if(headMap.get(mas.getTemplateName())!=null && headMap.get(mas.getTemplateName())==true){
								}else{
									headMap.put(mas.getTemplateName(), true);
									templateList1.add(mas);
								}
							}
							hCount++;
						}
						templateList=null;
						templateList=templateList1;
				}
			}else{
			templateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id= "+hospitalId+" or mt.Hospital.Id is null order by TemplateName");
			}//added by govind 19-08-2017 end
		}else{
		templateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTemplate mt where lower(mt.Status)='y' and mt.Hospital.Id= "+hospitalId+" order by TemplateName");
		}
		LOGGER.info("templateList "+templateList.size());
		map.put("tempModuleList", tempModuleList);
		map.put("templateList", templateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserList(int empGroup) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> empGrpList = new ArrayList<Object[]>();
		try {
			String qry = "SELECT login_name,user_id FROM users where user_id in (select user_id from user_emp_group where emp_group_id ='"
					+ empGroup
					+ "' and user_id not in(SELECT user_id FROM user_template))";
			empGrpList = (List) session.createSQLQuery(qry).list();
			// empGrpList =
			// session.createQuery(" from UserEmpGroup as masApp where
			// EmpGroup.Id = "+empGroup).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("empGrpList", empGrpList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<UserTemplate> getUsersListFromUserTemplate(int templateId,
			int empGroupId) {
		Session session = (Session) getSession();
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = session.createCriteria(UserTemplate.class)
				.createAlias("Template", "template")
				.add(Restrictions.eq("template.Id", templateId))
				.createAlias("EmpGroup", "empGroup")
				.add(Restrictions.eq("empGroup.Id", empGroupId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		return userTemplateList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populateApplications(String parentId,
			String templateId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Session session = (Session) getSession();
//			List<GroupApplication> appList = new ArrayList<GroupApplication>();
			List<Object[]> applicationNameList = new ArrayList<Object[]>();
			List<Object[]> existingNameList = new ArrayList<Object[]>();
			List<MasApplication> masApp = new ArrayList<MasApplication>();
			/*appList = session.createCriteria(GroupApplication.class)
					.add(Restrictions.eq("Status", "y")).list();*/
			String qry = "select a.* from (select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa,ma1.order_no from mas_application ma1"
					+ " left join mas_application ma2 on ma1.parent_id=ma2.app_id"
					+ " where  upper(ma1.status)='Y' and ma1.parent_id=:parentId and upper(ma2.status)='Y' "
					+ " union all "
					+ " select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa,ma1.order_no from mas_application ma1"
					+ " left join mas_application ma2 on ma1.parent_id=ma2.app_id"
					+ " where  upper(ma1.status)='Y' and ma1.parent_id in (select app_id from mas_application where parent_id='"
					+ parentId + "'  and upper(ma2.status)='Y') ) as a order by order_no";
			applicationNameList = (List) session.createSQLQuery(qry).setParameter("parentId",parentId).list();

			masApp = session.createCriteria(MasApplication.class)
					.add(Restrictions.eq("ParentId", parentId)).add(Restrictions.eq("Status", 'y').ignoreCase())
					.add(Restrictions.eq("Url", "#")).list();
			String par = "";

			if (parentId != null && !parentId.equals("")) {
				par = par + "'" + parentId + "'";
			}
			for (MasApplication masAp : masApp) {
				if (par.length() == 0) {
					par = par + "'" + masAp.getId() + "'";
				} else {
					par = par + ",'" + masAp.getId() + "'";
				}
			}

			String existqry = " SELECT m.parent_id,t.app_id,t.template_id FROM template_application t,mas_application m where t.app_id = m.app_id"
					+ " and template_id = '"
					+ templateId
					+ "' and m.parent_id in (" + par + ") and upper(m.status)='Y'";
			existingNameList = (List) session.createSQLQuery(existqry).list();
//			map.put("appList", appList);
			map.put("applicationNameList", applicationNameList);
			map.put("existingNameList", existingNameList);

			List<Integer> maxOrderNoList = new ArrayList<Integer>();
			maxOrderNoList = session.createCriteria(MasApplication.class).setProjection(Projections.max("OrderNo")).list();
			map.put("maxOrderNoList", maxOrderNoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean submitTemplateWiseApplication(Map<String, Object> map) {
		int templateId = (Integer) map.get("templateId");
		String parentId = (String) map.get("parentId");
		@SuppressWarnings("unused")
		String appId = (String) map.get("appId");
		// Integer buttonId = (Integer)map.get("buttonId");
		List groupApplicationList = (List) map.get("groupApplicationList");
		List deptList = new ArrayList();
		if(map.get("deptList")!=null){
			deptList = (List)map.get("deptList");
		}
		int userId = (Integer) map.get("userId");
		
		List<TemplateApplication> application = new ArrayList<TemplateApplication>();
		List buttonList = (List) map.get("buttonList");
		List<TemplateApplication> buttonApp = new ArrayList<TemplateApplication>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = (String) map.get("userName");
		TemplateApplication templateApp;
		boolean successfullyAdded = false;
		
		Box box=(Box)map.get("box");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<Object[]> applicationNameList = new ArrayList<Object[]>();
			String qry = "select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.parent_id='"+parentId+"'" +
			" union all " +
			" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.parent_id in ( select app_id from mas_application where parent_id='"+parentId+"' ) "
			+" union all " +
			" select ma1.name,ma1.parent_id,ma1.app_id,ma1.url,ma2.name as aaaa from mas_application ma1" +
			" left join mas_application ma2 on ma1.parent_id=ma2.app_id" +
			" where ma1.app_id ='"+parentId+"'";
	
			applicationNameList = (List) session.createSQLQuery(qry).list();
			
			List appOrderNoList = new ArrayList();
			if(map.get("appOrderNoList")!=null){
				appOrderNoList = (List)map.get("appOrderNoList");
			}
			
			int deleteCnt=0;
			if(groupApplicationList.size()>0){
				if(applicationNameList.size()>0){
					for(Object[] masApplication : applicationNameList){
						if(!(masApplication[2]).equals("0"))
						{
							++deleteCnt;
							String hql = "delete from TemplateApplication as uuga where uuga.App.Id = '"
								+ masApplication[2] + "' and uuga.Template.Id='"
								+ templateId + "'";
							Query query = session.createQuery(hql);
							@SuppressWarnings("unused")
							int row = query.executeUpdate();
						}
					}
				}
			}
			MasTemplate masTemplate = new MasTemplate();
			if (groupApplicationList != null && groupApplicationList.size() > 0) {
				Iterator iterator = groupApplicationList.iterator();
				int j=0;
				while (iterator.hasNext()) {
					templateApp = new TemplateApplication();
					String applicationId = (String) iterator.next();
					
					
					applicationId.contains(parentId);
				
					masTemplate.setId(templateId);
					templateApp.setTemplate(masTemplate);
					MasApplication masApplication = new MasApplication();
					masApplication.setId(applicationId);
					templateApp.setApp(masApplication);
					templateApp.setLastChgBy(userName);
					templateApp.setLastChgDate(currentDate);
					templateApp.setLastChgTime(currentTime);
					templateApp.setStatus("y");
					hbt.save(templateApp);

					successfullyAdded = true;
					j++;
				}
			}
			if(deptList.size() > 0){
				if(templateId!=0){
					Query deptqry = session.createQuery("delete from TemplateDepartment td where td.Template.Id=:templateId");
					deptqry.setInteger("templateId",templateId);
					deptqry.executeUpdate();

					for(int i=0;i<deptList.size();i++){
						TemplateDepartment templateDepartment = new TemplateDepartment();
						masTemplate.setId(templateId);
						templateDepartment.setTemplate(masTemplate);

						MasDepartment department = new MasDepartment();
						department.setId(Integer.parseInt(deptList.get(i).toString()));
						templateDepartment.setDepartment(department);
						Users user = new Users();
						user.setId(userId);
						templateDepartment.setLastChgBy(user);
						templateDepartment.setLastChgDate(currentDate);
						templateDepartment.setLastChgTime(currentTime);
						templateDepartment.setStatus("y");
						hbt.save(templateDepartment);
					}
				}
			}
			
			/**
			 * Update order no in mas_application
			 */
			Vector order_no = box.getVector("appOrderNo");
			Vector app_id = box.getVector("appIdForOrderNo");
			if (order_no != null && !order_no.equals("") && !order_no.equals("0")) {
				for (int i = 0; i < order_no.size(); i++) {
					MasApplication masApp = new MasApplication();
					masApp = (MasApplication) hbt.load(MasApplication.class,app_id.get(i).toString());
					masApp.setOrderNo(Integer.parseInt((String)order_no.get(i)));
					hbt.update(masApp);
					hbt.refresh(masApp);
				}}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean addUserWiseTemplate(Map<String, Object> dataMap) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Integer> userIdList = new ArrayList<Integer>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		userIdList = (List<Integer>) dataMap.get("userIdList");
		int templateId = (Integer) dataMap.get("templateId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) dataMap.get("buttonTemplateList");
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = (String) dataMap.get("userName");

		if (userIdList.size() > 0) {
			for (int j = 0; j < userIdList.size(); j++) {
				for (int i = 0; i < grpAppList.size(); i++) {
					UserUsergroupApplication userUserGroupApp = new UserUsergroupApplication();
					if (grpAppList.get(i) != null
							&& !grpAppList.get(i).equals("")) {
						GroupApplication grpApp = new GroupApplication();
						int grpAppId = Integer.parseInt(grpAppList.get(i)
								.toString());
						grpApp.setId(grpAppId);
						userUserGroupApp.setGroupApp(grpApp);

						UsergroupHospital usergroupHospital = new UsergroupHospital();
						int userGrpHospId = Integer.parseInt(usrGrpHospList
								.get(i).toString());
						usergroupHospital.setId(userGrpHospId);
						userUserGroupApp.setGroupHospital(usergroupHospital);

						Users users = new Users();
						int userId = Integer.parseInt(userIdList.get(j)
								.toString());
						users.setId(userId);
						userUserGroupApp.setUser(users);
						userUserGroupApp.setStatus("y");

					}

					try {
						hbt.save(userUserGroupApp);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					UserTemplate userTemplate = new UserTemplate();

					Users user = new Users();
					int userId = Integer.parseInt(userIdList.get(j).toString());
					user.setId(userId);
					userTemplate.setUser(user);

					MasTemplate masTemplate = new MasTemplate();
					masTemplate.setId(templateId);
					userTemplate.setTemplate(masTemplate);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					userTemplate.setHospital(masHospital);

					EmpGroups empGroups = new EmpGroups();
					empGroups.setId(empGroupId);
					userTemplate.setEmpGroup(empGroups);

					userTemplate.setStatus("y");
					userTemplate.setLastChgBy(userName);
					userTemplate.setLastChgDate(currentDate);
					userTemplate.setLastChgTime(currentTime);
					hbt.save(userTemplate);
					successfullyAdded = true;
				} catch (NumberFormatException e) {

					e.printStackTrace();
				} catch (DataAccessException e) {

					e.printStackTrace();
				}

				/*
				 * code for giving button level rights
				 */
				for (int k = 0; k < buttonTemplateList.size(); k++) {
					UserButtonRights userButtonRights = new UserButtonRights();
					if (buttonTemplateList.get(k) != null
							&& !buttonTemplateList.get(k).equals("")) {
						MasButtonForm masButtonForm = new MasButtonForm();
						int buttonId = Integer.parseInt(buttonTemplateList.get(
								k).toString());
						masButtonForm.setId(buttonId);
						userButtonRights.setButton(masButtonForm);

						EmpGroups empGroups = new EmpGroups();
						empGroups.setId(empGroupId);
						userButtonRights.setEmpGroup(empGroups);

						Users users = new Users();
						int userId = Integer.parseInt(userIdList.get(j)
								.toString());
						users.setId(userId);
						userButtonRights.setUser(users);
					}
					try {
						hbt.save(userButtonRights);
						successfullyAdded = true;
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editUserWiseTemplate(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		buttonTemplateList = (List<Integer>) dataMap.get("buttonTemplateList");

		int templateId = (Integer) dataMap.get("templateId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		int userTempUserid = (Integer) dataMap.get("userTempUserid");

		int grpAppId = 0;
		int userGroupHospId = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < grpAppList.size(); i++) {
				grpAppId = (Integer) grpAppList.get(i);

				for (int j = 0; j < usrGrpHospList.size(); j++) {
					userGroupHospId = (Integer) usrGrpHospList.get(j);

					String hql1 = "delete from UserUsergroupApplication as uuga where uuga.User.Id like :userTempUserid and uuga.GroupApp.Id like :grpAppId and uuga.GroupHospital.Id like :userGroupHospId";
					Query query1 = session.createQuery(hql1)
							.setParameter("userTempUserid", userTempUserid)
							.setParameter("grpAppId", grpAppId)
							.setParameter("userGroupHospId", userGroupHospId);
					int row1 = query1.executeUpdate();
					if (row1 > 0) {
						successfullyAdded = true;
					}

				}

			}

			String hql = "delete from UserTemplate as uuga where uuga.User.Id like :userTempUserid and uuga.Template.Id like :templateId  and uuga.EmpGroup.Id like :empGroupId";
			Query query = session.createQuery(hql)
					.setParameter("userTempUserid", userTempUserid)
					.setParameter("templateId", templateId)
					.setParameter("empGroupId", empGroupId);
			int row = query.executeUpdate();
			if (row > 0) {
				successfullyAdded = true;
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return successfullyAdded;
	}
	
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<PhMasParliyamentAssembly> parliyamentList= new ArrayList<PhMasParliyamentAssembly>();
		Session session = (Session) getSession();
		List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
		List<MasWard> maswardlist = new ArrayList<MasWard>();
		session = (Session) getSession();
		int district = 0;
		try {
			
			if(dataMap.get("district") != null ){
				district = (Integer)dataMap.get("district");
			}
			talukList = session.createCriteria(MasTaluk.class)
						.createAlias("District", "g")
						.add(Restrictions.eq("g.Id",district))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();


			parliyamentList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","P"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			
			
			postCodeList = session.createCriteria(MasPostCode.class)
					.createAlias("DistrictId", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			
			
			assemblyList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","A"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			maswardlist = session.createCriteria(MasWard.class)
					.createAlias("District", "district")
					.add(Restrictions.eq("district.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("talukList", talukList);
		map.put("postCodeList", postCodeList);
		map.put("parliyamentList", parliyamentList);
		map.put("assemblyList", assemblyList);
		map.put("maswardlist", maswardlist);
		return map;

}

	@Override
	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List hospitalCodeList = new ArrayList();
		List hospitalNameList = new ArrayList();
		List hospitalExitsList = new ArrayList();
		String code="";
		String name="";
		int hospId=0;
		Criteria crit = null;

		if (generalMap.get("code") != null) {
			code = (String) generalMap.get("code");
		}
		if (generalMap.get("name") != null) {
			name = (String) generalMap.get("name");
		}
		if (generalMap.get("id") != null) {
			hospId = (Integer) generalMap.get("id");
		}
		
		if(!code.equalsIgnoreCase(""))
		{
		crit = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("HospitalCode",code));
		hospitalCodeList = crit.list();
		}		

		if(!name.equalsIgnoreCase(""))
		{
		crit = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("HospitalName",name));
		hospitalNameList = crit.list();
		}
		/*if(!code.equalsIgnoreCase("") && !name.equalsIgnoreCase("") )
		{
		crit = session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalCode",code)).add(Restrictions.eq("HospitalName",name));
		hospitalExitsList = crit.list();
		}*/
		map.put("hospitalNameList", hospitalNameList);
		map.put("hospitalCodeList", hospitalCodeList);
		//map.put("hospitalExitsList", hospitalExitsList);
		return map;
}
	@Override
	public Map<String, Object> showUserAssignedTemplet(Map<String, Object> mapDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> masEmpCatList = new ArrayList<Object[]>();
		
		Session session = getSession();
		int hospitalId=0;
		if (mapDetails.get("hospitalId") != null) {
			hospitalId = (Integer) mapDetails.get("hospitalId");
		}
	
		int districtId= 0;
		if(mapDetails.get("districtId")!=null){
			districtId = (Integer)mapDetails.get("districtId");
		}
		int userType = 0;
		if(mapDetails.get("userType")!=null){
			userType = (Integer)mapDetails.get("userType");
		}
		int userId = 0;
		if(mapDetails.get("userId")!=null){
			userId = (Integer)mapDetails.get("userId");
		}
		String userName = (String) mapDetails.get("userName");
		String superAdmin = (String) mapDetails.get("superAdmin");
	
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		
		Criteria crit = null;
		crit = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName"));
	//	if(userType==2){/* District Admin*/
			crit = crit.add(Restrictions.eq("District.Id", districtId));
		//}
		hospitalList = crit.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("ShortName"))).list();
		
		masEmpCatList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("EmpCategoryName"))).list();
		
		//added by govind 25-02-2017
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		map.put("mhospitalTypetList", mhospitalTypetList);
		//added by govind 25-02-2017
	
		if(userType == 5){ // PH Admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = getBsScInstList(userId);
			map.put("bsScInstList",bsScInstList);
		}
		map.put("hospitalList",hospitalList);
		map.put("masEmpCatList",masEmpCatList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addUserWiseTemplateOnly(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean successfullyAdded = false;
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Object> grpAppList = new ArrayList<Object>();
		usrGrpHospList = (List<Object>) dataMap.get("usrGrpHospList");
		grpAppList = (List<Object>) dataMap.get("grpAppList");
		int templateId = (Integer) dataMap.get("templateId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		int userId=0;
		if(dataMap.get("userId")!=null){
			userId = (Integer) dataMap.get("userId");
		}
	
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String userName = (String) dataMap.get("userName");
		if (userId > 0) {
			/*for (int i = 0; i < grpAppList.size(); i++) {
				UserUsergroupApplication userUserGroupApp = new UserUsergroupApplication();
				if (grpAppList.get(i) != null && !grpAppList.get(i).equals("")) {
					int grpAppId =0;
					if(grpAppList.get(i)!=null){
						grpAppId = Integer.parseInt(grpAppList.get(i).toString());
					}
					if(grpAppId>0){
						GroupApplication grpApp = new GroupApplication();
						grpApp.setId(grpAppId);
						userUserGroupApp.setGroupApp(grpApp);
					}
					int userGrpHospId =0;
					if(usrGrpHospList.get(i)!=null){
						userGrpHospId = Integer.parseInt(usrGrpHospList.get(i).toString());
						if(userGrpHospId>0){
							UsergroupHospital usergroupHospital = new UsergroupHospital();
							usergroupHospital.setId(userGrpHospId);
							userUserGroupApp.setGroupHospital(usergroupHospital);
						}
					}
					Users users = new Users();
					users.setId(userId);
					userUserGroupApp.setUser(users);
					userUserGroupApp.setStatus("y");
				}
				try {
					hbt.save(userUserGroupApp);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			Session session = getSession();
				try {
					if(templateId>0){
						//List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
						//userTemplateList = session.createCriteria(UserTemplate.class).add(Restrictions.eq("Template.Id", templateId)).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status","y")).addOrder(Order.asc("Template.Id")).list();
						//if(userTemplateList.size() == 0){
						UserTemplate userTemplate = new UserTemplate();
						
						Users user = new Users();
						user.setId(userId);
						userTemplate.setUser(user);
						if(templateId>0){
							MasTemplate masTemplate = new MasTemplate();
							masTemplate.setId(templateId);
							userTemplate.setTemplate(masTemplate);
						}
						
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						userTemplate.setHospital(masHospital);
						if(empGroupId>0){
							EmpGroups empGroups = new EmpGroups();
							empGroups.setId(empGroupId);
							userTemplate.setEmpGroup(empGroups);
						}
						
						userTemplate.setStatus("y");
						userTemplate.setLastChgBy(userName);
						userTemplate.setLastChgDate(currentDate);
						userTemplate.setLastChgTime(currentTime);
						hbt.save(userTemplate);
						}
						successfullyAdded = true;
				//	}
				} catch (NumberFormatException e) {
					successfullyAdded = false;
					e.printStackTrace();
				} catch (DataAccessException e) {
					successfullyAdded = false;
					e.printStackTrace();
				}
			

		
		}
		hbt.flush();
		map.put("successfullyAdded", successfullyAdded);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTemplateApplicationList(int templateId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<TemplateApplication> tempAppList = new ArrayList<TemplateApplication>();
		List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();
		@SuppressWarnings("unused")
		List<GroupApplication> grpApplicationList = new ArrayList<GroupApplication>();
		List<UsergroupHospital> userGrpHospitalList = new ArrayList<UsergroupHospital>();
		List<Object> grpAppList = new ArrayList<Object>();
		List<Object> grpIdList = new ArrayList<Object>();
		List<Object> usrGrpHospList = new ArrayList<Object>();
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		String applicationId = "";
		int groupId = 0;
		int grpAppId = 0;
		int usergrpHospId = 0;
		try {
		/*	String query ="select distinct(button_id) from template_application where template_id='"+templateId+"' and button_id is not null";
			buttonTemplateList = (List) session.createSQLQuery(query).list();*/
			tempAppList = session.createQuery(
					" from TemplateApplication as tempApp where Template.Id = "
							+ templateId).list();

			/*for (Iterator iterator = tempAppList.iterator(); iterator.hasNext();) {
				TemplateApplication tempApp = (TemplateApplication) iterator
						.next();
				if(tempApp.getApp() != null){
				applicationId = tempApp.getApp().getId();
				}
				
				groupAppList = (List<GroupApplication>) session.createCriteria(
						GroupApplication.class).createAlias("App", "app").add(
						Restrictions.eq("app.Id", applicationId)).add(Restrictions.eq("Status","y")).list();

				for (Iterator iterator1 = groupAppList.iterator(); iterator1
						.hasNext();) {
					GroupApplication grpApp = (GroupApplication) iterator1
							.next();
					groupId = grpApp.getGroup().getId();
					grpAppId = grpApp.getId();
					grpAppList.add(grpAppId);
					grpIdList.add(groupId);
				
					userGrpHospitalList = (List<UsergroupHospital>) session
					.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hsp")
					.add(Restrictions.eq("hsp.Id", hospitalId))
					.createAlias("Group", "grp").add(
							Restrictions.eq("grp.Id", groupId)).addOrder(Order.desc("Id")).list();
					usrGrpHospList.add(userGrpHospitalList.get(0).getId());
				
				}
			}
			*/
			

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("grpAppList", grpAppList);
		map.put("usrGrpHospList", usrGrpHospList);
		map.put("tempAppList", tempAppList);
		map.put("groupAppList", groupAppList);
		map.put("buttonTemplateList", buttonTemplateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTemplateAsPerEmpCatList(
			Map<String, Object> mapDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		
		Session session = getSession();
		int employeeCategoryId=0;
		if (mapDetails.get("employeeCategoryId") != null) {
			employeeCategoryId = (Integer) mapDetails.get("employeeCategoryId");
		}
		int templateId=0;
		if (mapDetails.get("templateId") != null) {
			templateId = (Integer) mapDetails.get("templateId");
		}
		int templateIdEmpCat=0;
		if(employeeCategoryId>0 && templateId!=0){
			masTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("EmpCategory.Id", employeeCategoryId)).add(Restrictions.eq("Templateparent.Id", templateId)).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("TemplateName")).list();
		/*	masTemplateList = getHibernateTemplate().find(
					"from MasTemplate templet where  templet.EmpCategory.Id="+employeeCategoryId+" and templet.Templateparent.Id="+templateId+"  and templet.Status ='y'  order by TemplateName asc");*/
			if(masTemplateList.size()>0){
				for(MasTemplate masTemplate:masTemplateList){
					templateIdEmpCat=masTemplate.getId();
				}
			}else{
				templateIdEmpCat=templateId;
			}
		}else if(employeeCategoryId==0 && templateId!=0){
			masTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("TemplateName")).list();
			/*masTemplateList = getHibernateTemplate().find(
					"from MasTemplate templet where  templet.TemplateParent.Id="+templateId+"  and templet.Status ='y'  order by TemplateName asc");*/
			if(masTemplateList.size()>0){
				for(MasTemplate masTemplate:masTemplateList){
					templateIdEmpCat=masTemplate.getId();
				}
			}else{
				templateIdEmpCat=templateId;
			}
		}else{
			templateIdEmpCat=templateId;
		}
		
		
		map.put("templateIdEmpCat",templateIdEmpCat);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> removeTemplateApplicationList(Map<String, Object> removeTemplateMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> preTempletIdList=new ArrayList<Integer>();
		List<Integer> preUserIdList=new ArrayList<Integer>();
		Session session = (Session) getSession();	
		
		int hospitalId=0;
		if (removeTemplateMap.get("hospitalId") != null) {
			hospitalId = (Integer) removeTemplateMap.get("hospitalId");
		}
		
		if (removeTemplateMap.get("preTempletIdList") != null) {
			preTempletIdList = (List) removeTemplateMap.get("preTempletIdList");
		}
		if (removeTemplateMap.get("preUserIdList") != null) {
			preUserIdList = (List) removeTemplateMap.get("preUserIdList");
		}
		try {
		if(preTempletIdList.size()>0){
				int index=0;
				//int userId=0;
				for(Integer userId:preUserIdList){
					int templateId = preTempletIdList.get(index);
				/*for(Integer preTemplateId:preTempletIdList){
					userId=preUserIdList.get(index);
					List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
					userTemplateList = session.createCriteria(UserTemplate.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Template.Id", preTemplateId)).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status","y")).addOrder(Order.asc("Template.Id")).list();
					userTemplateList = getHibernateTemplate().find(
							"from UserTemplate ut where ut.Template.Id="+preTemplateId+" and ut.User.Id="+userId+" and ut.Status ='y'  order by ut.Template.Id asc");
					int templateIdTemp=0;
					if(userTemplateList.size()>0){
					for(UserTemplate userTemplate:userTemplateList){
						templateIdTemp=userTemplate.getTemplate().getId();
					}
					}else{
						templateIdTemp=preTemplateId;
					}
					List<String> userTemplateListAppID = new ArrayList<String>();
					userTemplateListAppID = getHibernateTemplate().find(
							"select ta.App.Id from MasTemplate mt join mt.TemplateApplications as ta join mt.UserTemplates as ut where ut.User.Id = "+userId+" and ut.Hospital.Id = "+hospitalId+" and ut.Template.Id = "+templateIdTemp+" and ta.App.Id is not null");
							String hql ="";
							if(userTemplateListAppID.size()>0){
							List<GroupApplication> groupAppList = new ArrayList<GroupApplication>();
							groupAppList = (List<GroupApplication>) session.createCriteria(
									GroupApplication.class).createAlias("App", "app").add(
									Restrictions.in("app.Id", userTemplateListAppID)).add(Restrictions.eq("Status","y")).list();
							if(groupAppList.size()>0){
								for(GroupApplication groupApplication:groupAppList){
									hql = "delete from UserUsergroupApplication as uuga where uuga.User.Id = "+ userId+ " and uuga.GroupApp.Id ="+groupApplication.getId();
									Query query = session.createQuery(hql);
									@SuppressWarnings("unused")
									int row = query.executeUpdate();
								}
							}
						}
					
					++index;
				}*/
				//String hqlUserTemplate = "delete from UserTemplate as ut where ut.User.Id = "+ userId+ "";
					String hqlUserTemplate = "delete from UserTemplate as ut where ut.User.Id = "+ userId+ " and ut.Template.Id="+templateId+" and ut.Hospital.Id="+hospitalId;
				Query queryUserTemplate = session.createQuery(hqlUserTemplate);
				@SuppressWarnings("unused")
				int rowUserTemplate = queryUserTemplate.executeUpdate();
				++index;
				}
			}
			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			session.flush();
		return map;
	}

	@Override
	public Map<String, Object> getEmployeeCodeDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String employeeCode = box.getString("employeeCode");
		String userName = box.getString("userName");
		Session session = getSession();
		int userType = userType= box.getInt("userType");
		
		List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
		Criteria crit = null;
		
		crit = session.createCriteria(MasEmployee.class);
		if(userType>=3)/* userType>=3 means institute level user*/
			crit= crit.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")));
		
		
		if(!employeeCode.equals(""))
			crit = crit.add(Restrictions.eq("PEN", employeeCode));
		
		existingMasEmployeeList = crit.list();
		LOGGER.info("existingMasEmployeeList----"+existingMasEmployeeList.size());
		List<Users> existingUserList = new ArrayList<Users>();
		if(!employeeCode.equals("")){
			Criteria c = session.createCriteria(Users.class).createAlias("Employee", "emp");
					//.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")));
			c = c.add(Restrictions.eq("LoginName", employeeCode));
			existingUserList = c.list();
			map.put("existingUserList", existingUserList);
		}
		map.put("existingMasEmployeeList",existingMasEmployeeList);
		
		return map;
	}
	
	
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getVillageList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int taluk = 0;
		try {
			
			if(dataMap.get("taluk") != null ){
				taluk = (Integer)dataMap.get("taluk");
				
			}
			villageList = session.createCriteria(MasVillage.class)
						.createAlias("Taluk", "g")
						.add(Restrictions.eq("g.Id",taluk))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();


			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("villageList", villageList);
		return map;

}
	
	
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getAssemblyList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int parliamentId = 0;
		try {
			
			if(dataMap.get("parliamentId") != null ){
				parliamentId = (Integer)dataMap.get("parliamentId");
			}
			assemblyList = session.createCriteria(PhMasParliyamentAssembly.class)
						.createAlias("Parliyament", "g")
						.add(Restrictions.eq("g.Id",parliamentId))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();


			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("assemblyList", assemblyList);
		return map;

}
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getWardList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWard> wardList = new ArrayList<MasWard>();
		//List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		//int villageId = 0;
		int districtId=0;
		try {
			
			/*if(dataMap.get("villageId") != null ){
				villageId = (Integer)dataMap.get("villageId");
			}*/
			
			if(dataMap.get("districtId") != null ){
				districtId = (Integer)dataMap.get("districtId");
			}
			/*wardList = session.createCriteria(MasWard.class)
						.createAlias("Village", "g")
						.add(Restrictions.eq("g.Id",villageId))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
			
			wardList = session.createCriteria(MasWard.class)
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id",districtId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			/*postCodeList = session.createCriteria(MasPostCode.class)
					.createAlias("Village", "g")
					.add(Restrictions.eq("g.Id",villageId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("wardList", wardList);
		//map.put("postCodeList", postCodeList);
		return map;

}

	
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getPanchayatList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasPanchayat> panchayatList = new ArrayList<PhMasPanchayat>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int assemblyId = 0;
		try {
			
			if(dataMap.get("assemblyId") != null ){
				assemblyId = (Integer)dataMap.get("assemblyId");
			}
			panchayatList = session.createCriteria(PhMasPanchayat.class)
						.createAlias("Assembly", "g")
						.add(Restrictions.eq("g.Id",assemblyId))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();


			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("panchayatList", panchayatList);
		return map;

}
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> getLocalityList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasLocality> localityList = new ArrayList<PhMasLocality>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int ward = 0;
		try {
			
			if(dataMap.get("ward") != null ){
				ward = (Integer)dataMap.get("ward");
			}
			
			localityList = session.createCriteria(PhMasLocality.class)
						.createAlias("Ward", "g")
						.add(Restrictions.eq("g.Id",ward))
						.add(Restrictions.eq("Status","Y").ignoreCase()).list();


			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("localityList", localityList);
		return map;

}
	@Override
	public Map<String, Object> getHospitalForDisplay(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> searchHospitalList = new ArrayList<MasHospital>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasWard> wardList = new ArrayList<MasWard>();
		List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		List<PhMasLocality> localityList = new ArrayList<PhMasLocality>();
		List<PhMasParliyamentAssembly> parliyamentList= new ArrayList<PhMasParliyamentAssembly>();
		List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
		List<PhMasPanchayat> panchayatList = new ArrayList<PhMasPanchayat>();
		List<PhMasElectricalSection> electricalSectionList = new ArrayList<PhMasElectricalSection>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		
		session = (Session) getSession();
		
		try {
			
			 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			 Properties prop = new Properties();
		        try {
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
			 int stateId=Integer.parseInt(prop.getProperty("stateId"));
			
			searchHospitalList =session.createCriteria(MasHospital.class)
					.list();
			
			masHospitalList =session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
			masHospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status","y").ignoreCase())
					.addOrder(Order.asc("HospitalTypeName"))
					.list();
			
			masRankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("State.Id", stateId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		/*	masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).list();*/
			
			hospitalList = session.createCriteria(MasHospital.class)
						.add(Restrictions.eq("Id",hospitalId))
						//.add(Restrictions.eq("Status","y"))
						.list();

			
			electricalSectionList = session.createCriteria(PhMasElectricalSection.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			if(hospitalList.get(0).getDistrict()!=null)
			{
				int district = hospitalList.get(0).getDistrict().getId();
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
			parliyamentList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","P"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
			postCodeList = session.createCriteria(MasPostCode.class)
					.createAlias("DistrictId", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
			
				
			assemblyList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","A"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			}
			if(hospitalList.get(0).getTaluk()!=null)
			{
				int taluk= hospitalList.get(0).getTaluk().getId();
			villageList = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "g")
					.add(Restrictions.eq("g.Id",taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			}
			if(hospitalList.get(0).getVillage()!=null)
			{
				int villageId= hospitalList.get(0).getVillage().getId();
					wardList = session.createCriteria(MasWard.class)
					.createAlias("Village", "g")
					.add(Restrictions.eq("g.Id",villageId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
	
			}
			
			
			
			if(hospitalList.get(0).getWard()!=null)
			{
				int ward= hospitalList.get(0).getWard().getId();
			localityList = session.createCriteria(PhMasLocality.class)
					.createAlias("Ward", "g")
					.add(Restrictions.eq("g.Id",ward))
					.add(Restrictions.eq("Status","Y").ignoreCase()).list();
			}
/*			if(hospitalList.get(0).getParliament()!=null)
			{
				int parliamentId=hospitalList.get(0).getParliament().getId();
			assemblyList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("Parliyament", "g")
					.add(Restrictions.eq("g.Id",parliamentId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			}*/
			
			if(hospitalList.get(0).getAssembly()!=null)
			{
				int assemblyId=hospitalList.get(0).getAssembly().getId();
			panchayatList = session.createCriteria(PhMasPanchayat.class)
					.createAlias("Assembly", "g")
					.add(Restrictions.eq("g.Id",assemblyId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("hospitalList", hospitalList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("districtList", districtList);
		map.put("talukList", talukList);
		map.put("villageList", villageList);
		map.put("wardList", wardList);
		map.put("postCodeList", postCodeList);
		map.put("localityList", localityList);
		map.put("parliyamentList", parliyamentList);
		map.put("assemblyList", assemblyList);
		map.put("panchayatList", panchayatList);
		map.put("masHospitalTypeList", masHospitalTypeList);
		map.put("searchHospitalList", searchHospitalList);
		map.put("masHospitalList", masHospitalList);
		map.put("electricalSectionList", electricalSectionList);
		map.put("masRankList", masRankList);
		
		
		return map;

}


	@Override
	public List<Object[]> getDepartmentList(int hospitalId) {
		List<Object[]> departmentList = new ArrayList<Object[]>();
		Session session = getSession();
	/*	departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DepartmentName"))).addOrder(Order.asc("DepartmentName")).list();
	*/
	departmentList = session.createCriteria(MasInstituteDepartment.class).createAlias("Institute", "ins").add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("ins.Id", hospitalId)).createAlias("Department", "dept")
				.setProjection(Projections.projectionList().add(Projections.property("dept.Id")).add(Projections.property("dept.DepartmentName"))).addOrder(Order.asc("dept.DepartmentName")).list();
	
		return departmentList;
	}

	@Override
	public Map<String, Object> getHospitalWiseTemplate(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		Session session = getSession();
		masTemplateList = session.createCriteria(MasTemplate.class).add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("TemplateName")).list();
		map.put("masTemplateList", masTemplateList);
		return map;
	}


	@Override
	public List<Object[]> getHospitalListForTemplateApplication(int districtId) {
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		Session session = getSession();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("District.Id", districtId))
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("ShortName"))).addOrder(Order.asc("HospitalName")).list();
	
		return hospitalList;
	}

	@Override
	public List<Object[]> getDistrictList() {
			List<Object[]> districtList = new ArrayList<Object[]>();
			Session session = getSession();
			 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			 Properties prop = new Properties();
		        try {
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
			 int stateId=Integer.parseInt(prop.getProperty("stateId"));
		
			districtList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
					.add(Restrictions.eq("state.Id",stateId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.setProjection(Projections.projectionList()
							.add(Projections.property("Id"))
							.add(Projections.property("DistrictName"))).addOrder(Order.asc("DistrictName")).list();
			return districtList;

	}

	@Override
	public Map<String, Object> showInstituteWiseAuthorityLevel(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasEmployee>masEmployeeList=new ArrayList<MasEmployee>();
		List<HrInstituteAuthLevel>hrInstituteAuthLevelList=new ArrayList<HrInstituteAuthLevel>();
		List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
		Session session = getSession();
		masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName")).list();
				//.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("TemplateName")).list();
		masEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		hrInstituteAuthLevelList=session.createCriteria(HrInstituteAuthLevel.class).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		int id=0;
		for(HrInstituteAuthLevel hrInstituteAuthLevel:hrInstituteAuthLevelList){
			id=hrInstituteAuthLevel.getId();
		}
		LOGGER.info("id==="+id);
		hrInstituteAuthLevelDetailsList=session.createCriteria(HrInstituteAuthLevelDetails.class).add(Restrictions.eq("HrInstituteAuthLevel.Id", id)).list();
		map.put("masHospitalList", masHospitalList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("hrInstituteAuthLevelDetailsList", hrInstituteAuthLevelDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> saveAuthLevelDetails(int hospitalId,int authLevel, Box box) {
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session=(Session)getSession();
		List<HrInstituteAuthLevel>hrInstituteAuthLevelList=new ArrayList<HrInstituteAuthLevel>();
		hrInstituteAuthLevelList=session.createCriteria(HrInstituteAuthLevel.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		List<MasHospital>masHospitalList=new ArrayList<MasHospital>();
		masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName")).list();
		Map<String,Object>map=new HashMap<String,Object>();
		String message="";

		if(hrInstituteAuthLevelList.size()==0){
		HrInstituteAuthLevel hial=new HrInstituteAuthLevel();
		MasHospital mh=new MasHospital();
		mh.setId(hospitalId);
		hial.setHospital(mh);
		
		hial.setAuthLevel((Integer.parseInt(""+authLevel)));
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		
		int userId=0;
		if(box.getInt("userId")!=0){
			userId=box.getInt("userId");
		}
		
		Users user=new Users();
		user.setId(userId);
		hial.setLastChgBy(user);
		
		hial.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		hial.setLastChgTime(time);
		hbt.save(hial);
		LOGGER.info("---->>>"+box.getVector("name"));
		Vector  slNo=box.getVector("slNo"); 
		Vector desig=box.getVector("DesigNation");
		Vector empId=box.getVector("name");
		LOGGER.info("---->>>"+box.getVector("name"));
		int val=box.getInt("val");
		LOGGER.info("val in dataserviceIMPl---->>"+val);
		for(int i=0;i<val;i++){
			if(desig.get(i)!=null && !desig.get(i).equals("")){
			HrInstituteAuthLevelDetails hiald=new HrInstituteAuthLevelDetails();
			
			HrInstituteAuthLevel hial1=new HrInstituteAuthLevel();
			hial1.setId(hial.getId());
			hiald.setHrInstituteAuthLevel(hial1);
			
			
			
			Users user1=new Users();
			user1.setId(userId);
			hiald.setLastChgBy(user1);			
			
			hiald.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			hiald.setLastChgTime(time);
			
			hiald.setSlNo(Integer.parseInt(""+slNo.get(i)));
			if(desig.get(i)!=null && !desig.get(i).equals("")){
			hiald.setDesignation(""+desig.get(i));
			}
			LOGGER.info("<<==========>>"+empId.get(i));
			if(empId.get(i)!=null && !empId.get(i).equals("0") && !empId.get(i).equals("")){
				MasEmployee me=new MasEmployee();
				me.setId(Integer.parseInt(""+empId.get(i)));
				hiald.setEmployee(me);
			}
			hbt.save(hiald);
			message="Data Saved Successfully!!";
		}
		}
		}else{
			message="Data Already Exists for this Institute";
		}
		map.put("message", message);
		map.put("masHospitalList", masHospitalList);
		return map;
	}

	@Override
	public Map<String, Object> getResponeValueForAuhorizationLevel(int val,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasEmployee>masEmployeeList=new ArrayList<MasEmployee>();
		List<HrInstituteAuthLevel>hrInstituteAuthLevelList=new ArrayList<HrInstituteAuthLevel>();
		List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
		Session session = getSession();
		hrInstituteAuthLevelList=session.createCriteria(HrInstituteAuthLevel.class).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		int id=0;
		for(HrInstituteAuthLevel hrInstituteAuthLevel:hrInstituteAuthLevelList){
			id=hrInstituteAuthLevel.getId();
		}
		LOGGER.info("id=====>>>"+id);
		hrInstituteAuthLevelDetailsList=session.createCriteria(HrInstituteAuthLevelDetails.class).add(Restrictions.eq("HrInstituteAuthLevel.Id", id)).list();
		masHospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
				//.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("TemplateName")).list();
		masEmployeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		map.put("val", val);
		map.put("masEmployeeList", masEmployeeList);
		map.put("hrInstituteAuthLevelDetailsList", hrInstituteAuthLevelDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> updateDataForAuthLevel(int srNo,String designation, int empId, int headerId, int userId) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session=(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
		hrInstituteAuthLevelDetailsList=session.createCriteria(HrInstituteAuthLevelDetails.class).add(Restrictions.idEq(headerId)).list();
		for(HrInstituteAuthLevelDetails hrInstituteAuthLevelDetails:hrInstituteAuthLevelDetailsList){
			hrInstituteAuthLevelDetails.setSlNo(srNo);
			
			hrInstituteAuthLevelDetails.setDesignation(designation);
			
			MasEmployee employee=new MasEmployee();
			employee.setId(empId);
			hrInstituteAuthLevelDetails.setEmployee(employee);
		
			Users user=new Users();
			user.setId(userId);
			hrInstituteAuthLevelDetails.setLastChgBy(user);
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			hrInstituteAuthLevelDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			hrInstituteAuthLevelDetails.setLastChgTime(time);
			hbt.update(hrInstituteAuthLevelDetails);
		}
		return map;
	}

	@Override
	public Map<String, Object> saveDataForAuthLeve(int srNo,String designation, int empId, int headerId, int userId) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session=(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
		hrInstituteAuthLevelDetailsList=session.createCriteria(HrInstituteAuthLevelDetails.class).add(Restrictions.idEq(headerId)).list();
		HrInstituteAuthLevelDetails hrInstituteAuthLevelDetails=new HrInstituteAuthLevelDetails();
			hrInstituteAuthLevelDetails.setSlNo(srNo);
			
			hrInstituteAuthLevelDetails.setDesignation(designation);
			
			MasEmployee employee=new MasEmployee();
			employee.setId(empId);
			hrInstituteAuthLevelDetails.setEmployee(employee);
		
			HrInstituteAuthLevel HrInstituteAuthLevel=new HrInstituteAuthLevel();
			HrInstituteAuthLevel.setId(headerId);
			hrInstituteAuthLevelDetails.setHrInstituteAuthLevel(HrInstituteAuthLevel);
			
			Users user=new Users();
			user.setId(userId);
			hrInstituteAuthLevelDetails.setLastChgBy(user);
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			hrInstituteAuthLevelDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			hrInstituteAuthLevelDetails.setLastChgTime(time);
			hbt.save(hrInstituteAuthLevelDetails);
		
		return map;
	}

	@Override
	public Map<String, Object> showRolMappingJsp(Map<String, Object> dataMap) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		Session session=(Session)getSession();
		
		List<MasTemplate> templateList=new ArrayList<MasTemplate>();
		List<MasTemplate> templateListDup=new ArrayList<MasTemplate>();
		List<MasTemplate> templateListfinal=new ArrayList<MasTemplate>();
		List<MasTemplate> hospitaltemplateList=new ArrayList<MasTemplate>();
		int hospitalId = 0;
		
		
		if(dataMap.get("hospitalId")!=null){
			hospitalId = (Integer)dataMap.get("hospitalId");
		}
		
		int userType =0;
		int loginUserId = 0;
		if (dataMap.get("userType") != null) {
			userType = (Integer)dataMap.get("userType");
		}
		if (dataMap.get("userId") != null) {
			loginUserId =(Integer)dataMap.get("userId");
		}
		
		Criteria crt=null;
		crt=session.createCriteria(MasTemplate.class)
				.add(Restrictions.isNull("Hospital"))
				.add(Restrictions.isNull("RemoveId"))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("TemplateName"));
		templateList=crt.list();
		//added by govind 19-08-2017
		List<MasTemplate> templateList1 = new ArrayList<MasTemplate>();
		Map<String,Boolean> headMap=new HashMap<String,Boolean>();
				int hCount=0;
				for(MasTemplate mas:templateList){
					if(hCount==0){
						headMap.put(mas.getTemplateName(), true);
						templateList1.add(mas);
					}else{
						if(headMap.get(mas.getTemplateName())!=null && headMap.get(mas.getTemplateName())==true){
						}else{
							headMap.put(mas.getTemplateName(), true);
							templateList1.add(mas);
						}
					}
					hCount++;
				}
				templateList=null;
				templateList=templateList1;//added by govind 19-08-2017 end
	//	templateListDup=crt.list();
		/*for(MasTemplate ma:templateList){
			LOGGER.info("test 1 ");
			if(templateListfinal.size()>0){
				LOGGER.info("test 1 true "+templateListfinal.size());
				for(MasTemplate ma1:templateListfinal){
					if(ma.getTemplateName().equalsIgnoreCase(ma1.getTemplateName())){
						LOGGER.info("equal template");
						//break;
					}else{
						LOGGER.info("not equal template");
						templateListfinal.add(ma);
						//break;
					}
				}
			}else{
				LOGGER.info("test 1 else");
				templateListfinal.add(ma);
			}			
		}*/
		
		crt=session.createCriteria(MasTemplate.class).createAlias("Hospital","hospital")
				.add(Restrictions.eq("hospital.Id",hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase());
		
		hospitaltemplateList=crt.list();
		
		  List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
			List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
			List<MasHospital> instituteList = new ArrayList<MasHospital>();
	        mhospitalTypetList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
			mdistrictList = session.createCriteria(MasDistrict.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
					.list();
			instituteList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase()).list();
			


			/**
			 * For PH Admin
			 */
			if(userType==5){
				List<Object[]> bsScInstList = new ArrayList<Object[]>();
				bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
						.add(Restrictions.eq("User.Id", loginUserId)).add(Restrictions.eq("Status", "y").ignoreCase())
						.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
				map.put("bsScInstList", bsScInstList);
			}
			
			
			map.put("instituteList", instituteList);
			map.put("mhospitalTypetList", mhospitalTypetList);
			map.put("mdistrictList", mdistrictList);
			map.put("templateList", templateList);
			//map.put("templateList", templateListfinal);
			
			
		map.put("hospitaltemplateList", hospitaltemplateList);
		
		return map;
	}

	@Override
	public Map<String, Object> addRoleTemplate(Map<String, Object> datamap) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List templateCodeList = new ArrayList();
		List<MasTemplate> exisitingtemplateCodeList=new ArrayList<MasTemplate>();
		List<TemplateApplication> exisitingtemplateApplicationsList=new ArrayList<TemplateApplication>();
		List<TemplateDepartment> exisitingtemplatedepartmentList=new ArrayList<TemplateDepartment>();
		List<UserTemplate> exisitingUserTemplateList=new ArrayList<UserTemplate>();
		List<MasTemplate> fullTemplateList=new ArrayList<MasTemplate>();
		List<MasTemplate> hospitaltemplateList=null;
		List<MasTemplate> updateTemplateCodeList=new ArrayList<MasTemplate>();
		Transaction tnx=null;
		int hospitalId=0;
		hospitalId = (Integer)datamap.get("hospitalId");
		int userId = (Integer)datamap.get("userId");
		String currentTime=(String)datamap.get("currentTime");
		Date currentDate=(Date)datamap.get("currentDate");
		int deptId=(Integer)datamap.get("deptId");
		
		int userType =0;
		if (datamap.get("userType") != null) {
			userType = (Integer)datamap.get("userType");
		}
		
		try {
			tnx=session.beginTransaction();
			//String code = (String)datamap.get("code");
			//String name = (String)datamap.get("name");
			Criteria crt=null;
			 hospitaltemplateList=new ArrayList<MasTemplate>();
			crt=session.createCriteria(MasTemplate.class).createAlias("Hospital","hospital")
					.add(Restrictions.eq("hospital.Id",hospitalId));
			
			hospitaltemplateList=crt.list();
			
			
			/*ArrayList<String> rollList=null;
			rollList=new ArrayList<String>();
			 rollList=  (ArrayList<String>) datamap.get("rollList");
			*/
			Set<String> rollSet = null;
			rollSet = 	new HashSet<String>();
			rollSet =  (Set<String>) datamap.get("rollSet");
			String tRole=null;
			
			// ArrayList<String> rollListUp=  rollList;
			Set<String> rollSetUp = rollSet;
			
			fullTemplateList=exisitingtemplateCodeList=session.createCriteria(MasTemplate.class)
					.createAlias("Hospital","hospital")
					.add(Restrictions.eq("hospital.id", hospitalId)).list();
					
				List<Integer> updateList=new ArrayList<Integer>();
				for(MasTemplate ma:fullTemplateList){
					int c=0;
					// for( String role:rollListUp)
					/*for( String role:rollSetUp)
					{
					tRole=role;
					if(ma.getTemplateName().equalsIgnoreCase(role)){
						c++;
						break;
					}
					}*/
					
					if(rollSetUp.contains(ma.getTemplateName())){
						c++;
					}
					
					
					if(c==0){
						updateList.add(ma.getId());
					}
			     }

				if(updateList.size()>0){
				for(Integer id:updateList){
					//LOGGER.info("updatelist "+id);
					MasTemplate m=	hbt.load(MasTemplate.class, id);
					Users user=new Users();
					user.setId(userId);
					m.setLastChgBy(user);
					m.setLastChgDate(new Date());
					m.setLastChgTime(currentTime);
					m.setHospital(null);
					m.setRemoveId(hospitalId);
					hbt.update(m);
				}
				}
				
			// for( String role:rollList)
			for( String role:rollSet)	
			{		tRole=role;		
				
			updateTemplateCodeList=session.createCriteria(MasTemplate.class)
					.add(Restrictions.eq("TemplateName", tRole))
					.add(Restrictions.eq("RemoveId", hospitalId))
					.list();
			if(updateTemplateCodeList.size()>0){
				MasTemplate mtemp=updateTemplateCodeList.get(0);
				MasHospital hos=new MasHospital();
				hos.setId(hospitalId);
				mtemp.setHospital(hos);
				mtemp.setRemoveId(null);
				hbt.update(mtemp);
				hbt.refresh(mtemp);
				
			}else{
			/*exisitingtemplateCodeList=session.createCriteria(MasTemplate.class)
					.add(Restrictions.eq("TemplateName", tRole))
					//.add(Restrictions.eq("TemplateCode", tRole))
					.createAlias("Hospital","hospital")
					.add(Restrictions.eq("hospital.id", hospitalId))
					.list();*/
			
				exisitingtemplateCodeList=session.createCriteria(MasTemplate.class)
						.add(Restrictions.eq("TemplateName", tRole))
						//.add(Restrictions.eq("TemplateCode", tRole))
						.createAlias("Hospital","hospital")
						.add(Restrictions.eq("hospital.id", hospitalId))
						.list();
				
				//LOGGER.info(tRole+" hospitalId "+hospitalId);
				if(null !=exisitingtemplateCodeList && exisitingtemplateCodeList.size()>0){
				/*	for(MasTemplate template:exisitingtemplateCodeList ){
						
						exisitingtemplateApplicationsList=session.createCriteria(TemplateApplication.class)
								.createAlias("Template","template").add(Restrictions.eq("template.id", template.getId())).list();
						if(null !=exisitingtemplateApplicationsList && exisitingtemplateApplicationsList.size()>0){
							for(TemplateApplication application: exisitingtemplateApplicationsList){
								hbt.delete(application);
							}
						}
						/*exisitingtemplatedepartmentList=session.createCriteria(TemplateDepartment.class)
								.createAlias("Template", "template").add(Restrictions.eq("template.id", template.getId())).list();
						if(null !=exisitingtemplatedepartmentList && exisitingtemplatedepartmentList.size()>0){
							for(TemplateDepartment templateDepartment: exisitingtemplatedepartmentList){
								hbt.delete(templateDepartment);
							}
						}*/
						/*exisitingUserTemplateList=session.createCriteria(UserTemplate.class)
								.createAlias("Template", "template").createAlias("Hospital", "hospital").createAlias("User", "user")
								.add(Restrictions.eq("template.id", template.getId()))
								.add(Restrictions.eq("hospital.id", hospitalId))
								.add(Restrictions.eq("user.id", userId)).list();
						if(null !=exisitingUserTemplateList && exisitingUserTemplateList.size()>0){
							for(UserTemplate userTemplate: exisitingUserTemplateList){
								hbt.delete(userTemplate);
							}
						}*/
						//hbt.delete(template);
						
					//}
					
				}else{
			MasTemplate masTemplate = new MasTemplate();
			masTemplate.setTemplateCode(tRole);
			masTemplate.setTemplateName(tRole);
			masTemplate.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masTemplate.setLastChgBy(user);
			masTemplate.setLastChgDate(currentDate);
			masTemplate.setLastChgTime(currentTime);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			masTemplate.setDept(masDepartment);
			if(hospitalId>0){
			MasHospital masHosp = new MasHospital();
			masHosp.setId(hospitalId);
			masTemplate.setHospital(masHosp);
			}
				
			/*templateCodeList = session.createCriteria(MasTemplate.class)
					.add(Restrictions.or(Restrictions.eq("TemplateCode", tRole).ignoreCase(), Restrictions.eq("TemplateCode", tRole).ignoreCase()))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();*/
			
			templateCodeList = session.createCriteria(MasTemplate.class)
					.add(Restrictions.eq("TemplateCode", tRole).ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			int masTemplateId=0;
			
			List<TemplateApplication> tempApplicationList=new ArrayList<TemplateApplication>();
			List appIdList=new ArrayList();
			List<MasTemplate> templateList=new ArrayList<MasTemplate>();
			
			crt=session.createCriteria(MasTemplate.class).add(Restrictions.like("TemplateName", "%"+tRole+"%")).addOrder(Order.desc("Id"));
			templateList=crt.list();
			for(MasTemplate template:templateList){
				masTemplateId=template.getId();
			}
			
			if(masTemplateId>0){
				
				crt=session.createCriteria(TemplateApplication.class).createAlias("Template", "template").createAlias("App", "app")
						.add(Restrictions.eq("template.Id", masTemplateId)).setProjection(Projections.projectionList().add(Projections.property("app.Id")));
				 appIdList=crt.list();
			}
			
			
			if(templateCodeList.size()==0){
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masTemplate);
				
				Iterator it=appIdList.iterator();
				 
				while(it.hasNext())
				{
					String ob=(String) it.next();
					TemplateApplication templateApp=new TemplateApplication();
					MasApplication masApp=new MasApplication();
					masApp.setId(ob);
					templateApp.setApp(masApp);
					templateApp.setTemplate(masTemplate);
					templateApp.setStatus("y");
					templateApp.setLastChgBy("admin");
					templateApp.setLastChgDate(currentDate);
					templateApp.setLastChgTime(currentTime);
					hbt.save(templateApp);
					
				}
				
			}
			}
			}
			}
			tnx.commit();
			session.flush();
			successfullyAdded = true;
		}
		catch (JDBCException jdbce) {
			tnx.rollback();
		    jdbce.getSQLException().getNextException().printStackTrace();
		}
		
		List<MasTemplate> templateList=new ArrayList<MasTemplate>();
		Criteria crt=null;
		crt=session.createCriteria(MasTemplate.class)
				.add(Restrictions.isNull("Hospital"));
		
		templateList=crt.list();
		
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
        mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		instituteList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		


		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		
		
		map.put("instituteList", instituteList);
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("mdistrictList", mdistrictList);
		map.put("templateList", templateList);
		map.put("templateCodeList", templateCodeList);
		map.put("successfullyAdded", successfullyAdded);
		map.put("hospitaltemplateList", hospitaltemplateList);
		
		return map;
	}

	@Override
	public Map<String, Object> checkAppOrderNo(String appOrderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<MasApplication> appList = new ArrayList<MasApplication>();
		appList = session.createCriteria(MasApplication.class).add(Restrictions.eq("OrderNo", Integer.parseInt(appOrderNo))).list();
		map.put("appList", appList);
		return map;
	}

	@Override
	public Map<String, Object> changePasswordForPACS(Box box) {
		 Map<String,Object> dataMap=new HashMap<String,Object>();
		 String userName=""; 
		 if(box.get("userName")!=null){
			 userName=box.get("userName");
		 }
		 Session session=(Session)getSession();
		 Users user=(Users)session.createCriteria(Users.class)
				 	.add(Restrictions.eq("LoginName", userName)).uniqueResult();
		 if(user!=null){
			 dataMap.put("user", user);
		 }
		return dataMap;
	}

	@Override
	public Map<String, Object> saveChangePasswordFromPACSToEhealth(Users users) {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(users);
		dataMap.put("message", "success");
		return dataMap;
	}
	
	@SuppressWarnings({ "unchecked"})
	public Map<String, Object> populateLocalityByWardId(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<PhMasParliyamentAssembly> parliyamentList= new ArrayList<PhMasParliyamentAssembly>();
		Session session = (Session) getSession();
		List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		List<PhMasParliyamentAssembly> assemblyList = new ArrayList<PhMasParliyamentAssembly>();
		List<MasWard> maswardlist = new ArrayList<MasWard>();
		List<PhMasLocality> phmaslocalitylist = new ArrayList<PhMasLocality>();
		session = (Session) getSession();
		int district = 0;
		int wardId=0;
		try {
			
			if(dataMap.get("district") != null ){
				district = (Integer)dataMap.get("district");
			}
			
			if(dataMap.get("wardId") != null ){
				wardId = (Integer)dataMap.get("wardId");
			}
			talukList = session.createCriteria(MasTaluk.class)
						.createAlias("District", "g")
						.add(Restrictions.eq("g.Id",district))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();


			parliyamentList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","P"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			
			
			postCodeList = session.createCriteria(MasPostCode.class)
					.createAlias("DistrictId", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			
			
			assemblyList = session.createCriteria(PhMasParliyamentAssembly.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id",district))
					.add(Restrictions.eq("Category","A"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			maswardlist = session.createCriteria(MasWard.class)
					.createAlias("District", "district")
					.add(Restrictions.eq("district.Id",district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			phmaslocalitylist = session.createCriteria(PhMasLocality.class)
					.createAlias("Ward", "Ward")
					.add(Restrictions.eq("Ward.Id",wardId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("phmaslocalitylist", phmaslocalitylist);
		map.put("talukList", talukList);
		map.put("postCodeList", postCodeList);
		map.put("parliyamentList", parliyamentList);
		map.put("assemblyList", assemblyList);
		map.put("maswardlist", maswardlist);
		return map;

}

	@Override
	public Map<String, Object> searchEmployeeForUserRights(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		List<Object[]> masEmployeeList = new ArrayList<Object[]>();
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		Session session = getSession();

		int userType = 0;
		if(box.getInt("userType")!=0){
			userType = box.getInt("userType");
		}
		int userId = 0;
		if(box.getInt("userId")!=0){
			userId = box.getInt("userId");
		}
		
		masTemplateList = getHibernateTemplate().find("from MasTemplate templet where  (templet.Hospital.Id = "+hospitalId+") and lower(templet.Status) ='y'  order by TemplateName asc");
		
		String pen = box.getString("penNo");
		int empCatId = box.getInt("empCatId");

		/*Criteria empCrit = session.createCriteria(Users.class).createAlias("Employee", "emp")//.createAlias("UserHospitals", "uh") //commented & added by govind 25-03-2017 
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)); */
		Criteria empCrit = session.createCriteria(UserHospital.class)
				.createAlias("User", "User")
				.createAlias("User.Employee", "emp")//.createAlias("UserHospitals", "uh")
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
				.setProjection(Projections.property("User"))
				.addOrder(Order.asc("emp.FirstName")); //commented & added by govind 25-03-2017 
		if(!pen.equals("")){
			empCrit = empCrit.add(Restrictions.eq("emp.PEN", pen));
		}
		if(empCatId!=0){
			empCrit = empCrit.createAlias("emp.EmpCategory", "empc").add(Restrictions.eq("empc.Id", empCatId));
		}
		//masEmployeeList = empCrit.addOrder(Order.asc("emp.FirstName")).list();
		masEmployeeList = empCrit.list();
		LOGGER.info("masEmployeeList--"+masEmployeeList.size());
		
		//masEmployeeList = getHibernateTemplate().find("select  user from Users user join user.Employee emp join user.UserHospitals uh where  upper(user.Status)= 'Y' and  uh.Hospital.Id = "+hospitalId+" and emp.PEN='"+box.getString("penNo")+"' order by emp.FirstName asc");
		List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
		userTemplateList = session.createCriteria(UserTemplate.class).createAlias("User", "u").createAlias("u.Employee", "emp").createAlias("Template", "t")
				.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("emp.Status", "y").ignoreCase()).addOrder(Order.asc("t.TemplateName")).list();
			
		List<Object[]> masEmpCatList = new ArrayList<Object[]>();
		masEmpCatList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("EmpCategoryName"))).list();
		
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		
		Criteria crit = null;
		crit = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName"));
		crit = crit.add(Restrictions.eq("District.Id", box.getInt("districtId")));
		hospitalList = crit.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("ShortName"))).list();
		
		//added by govind 25-02-2017
				List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
				mhospitalTypetList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
				map.put("mhospitalTypetList", mhospitalTypetList);
		//added by govind 25-02-2017
				
		if(userType == 5){ // PH Admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = getBsScInstList(userId);
			map.put("bsScInstList",bsScInstList);
		}
		
		map.put("masEmployeeList",masEmployeeList);
		map.put("masTemplateList",masTemplateList);
		map.put("userTemplateList",userTemplateList);
		map.put("masEmpCatList",masEmpCatList);
		map.put("hospitalList",hospitalList);
		return map;
	}
	@Override
	public List<MasHospitalType> getHospitalTypeListForPH() {
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' and isc.HospitalTypeCode in ('115','101','102','109')  order by HospitalTypeName asc");
		return mhospitalTypetList;
	}
	@Override
	public List<MasHospitalType> getHospitalTypeListForTemplateApplication() {
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
			return mhospitalTypetList;
	}

	@Override
	public Map<String, Object> getEmployeeNameById(Map<String, Object> map1) {
		List<Users> usersList = new ArrayList<Users>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Criteria cr=null;
		String userIdStr="";
		int employeeId=0,instType=0;
		if (map1.get("employeeId") != null) {
			employeeId = (Integer)map1.get("employeeId");	
		}
		if (map1.get("userIdStr") != null) {
			userIdStr = (String)map1.get("userIdStr");	
		}
		
		cr=session.createCriteria(Users.class);
			 if(employeeId>0){
				 cr.add(Restrictions.eq("Id", employeeId));
			 }
			 if(userIdStr!=null){
				 cr.add(Restrictions.like("LoginName","%"+userIdStr+"%"));
				 cr.setFirstResult(0);
				 cr.setMaxResults(10);
			 }
		
		usersList=	cr.list();
		LOGGER.info("usersList "+usersList.size());
		map.put("usersList",usersList);
		return map;
	}

	@Override
	public Map<String, Object> getRoleTemplateList(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		int hospitalId=0;
		if(detailsMap.get("hospitalId")!=null){
			hospitalId=(Integer)detailsMap.get("hospitalId");
		}
		//LOGGER.info("hospitalId impl "+hospitalId);
		Criteria crt=null;
		List<MasTemplate> hospitaltemplateList=new ArrayList<MasTemplate>();
        crt=session.createCriteria(MasTemplate.class).createAlias("Hospital","hospital")
				.add(Restrictions.eq("hospital.Id",hospitalId));
		
		hospitaltemplateList=crt.list();
		LOGGER.info("hospitaltemplateList impl "+hospitaltemplateList.size());
		map.put("hospitaltemplateList", hospitaltemplateList);
		return map;
	}

	@Override
	public List<Object[]> getBsScInstList(int userId) {
		Session session=(Session)getSession();
		List<Object[]> bsScInstList = new ArrayList<Object[]>();
		bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
				.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();

		return bsScInstList;
	}

	@Override
	public Map<String, Object> getUserHospitalByUserId(int userId) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Integer> hospList=new ArrayList<Integer>();
		Session session=(Session)getSession();
		List<UserHospital> userHospitalList=new ArrayList<UserHospital>();
		userHospitalList=session.createCriteria(UserHospital.class)
				.add(Restrictions.eq("User.Id", userId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		if(userHospitalList.size()>0){
			for(UserHospital userHosp:userHospitalList){
				hospList.add(userHosp.getHospital().getId());
			}
			
		}
		
		map.put("userHospitals", hospList);
		return map;
	}

	
	public Map<String, Object> checkForAlreadyAvailableInstituteCode(String hospitalCode) {
		Session session=(Session)getSession();
		int hospitalCodeListCount=0;
		Map<String,Object>map=new HashMap<String,Object>();
		if(hospitalCode!=null && !hospitalCode.equals("")) {
			hospitalCodeListCount = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("HospitalCode",hospitalCode)).list().size();
		}
		boolean matched=false;
		if(hospitalCodeListCount > 0){
			matched=true;
		}
		map.put("matched",matched);
		return map;
	}

}