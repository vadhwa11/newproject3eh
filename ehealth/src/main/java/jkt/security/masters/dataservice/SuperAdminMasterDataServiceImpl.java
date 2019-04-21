package jkt.security.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.Department;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.UserWiseBranch;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SuperAdminMasterDataServiceImpl extends HibernateDaoSupport
		implements SuperAdminMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings({ "unchecked" })
	public Map checkForExistingHospital(String hospitalCode, String hospitalName) {

		List<MasHospital> codeList = new ArrayList<MasHospital>();
		List<MasHospital> nameList = new ArrayList<MasHospital>();

		codeList = getHibernateTemplate()
				.find("from jkt.security.masters.business.MasHospital as hm where hm.HospitalCode = '"
						+ hospitalCode + "' ");
		nameList = getHibernateTemplate()
				.find("from jkt.security.masters.business.MasHospital as hm where hm.HospitalName = '"
						+ hospitalName + "'");
		map.put("codeList", codeList);
		map.put("nameList", nameList);

		return map;
	}

	public boolean addHospital(MasHospital hospitalMaster) {

		boolean bool = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.save(hospitalMaster);
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> getHospitalNameList(String hospitalCode,
			String hospitalName) {

		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		if ((hospitalCode.equals(""))
				&& !(hospitalName.equalsIgnoreCase(""))
				|| (!(hospitalCode.equals("")) && !(hospitalName
						.equalsIgnoreCase("")))) {
			hospitalNameList = getHibernateTemplate()
					.find("from jkt.security.masters.business.MasHospital as hm where  hm.HospitalName like '"
							+ hospitalName + "%'");
		}
		return hospitalNameList;

	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> getHospitalMasterList(int hospitalId) {
		List<MasHospital> hospitalMasterList = new ArrayList<MasHospital>();
		hospitalMasterList = getHibernateTemplate().find(
				"from jkt.security.masters.business.MasHospital as hm where hm.Id = "
						+ hospitalId);
		return hospitalMasterList;
	}

	@SuppressWarnings("unchecked")
	public List<MasHospital> checkExistingHospitalForEdit(int hospitalId,
			String hospitalName) {

		List<MasHospital> hospitalMasterNameList = new ArrayList<MasHospital>();
		hospitalMasterNameList = getHibernateTemplate()
				.find("from jkt.security.masters.business.MasHospital as hm where hm.HospitalName = '"
						+ hospitalName + "' and hm.Id != " + hospitalId);

		return hospitalMasterNameList;

	}

	public boolean updateHospital(MasHospital hospitalMaster) {
		boolean dataFixed = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hospitalMaster);
			dataFixed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFixed;

	}

	public boolean deleteHospital(int hospitalId) {
		boolean dataDeleted = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasHospital hospitalMaster = new MasHospital();
			hospitalMaster = (MasHospital) hbt.load(MasHospital.class,
					hospitalId);

			String hospName = hospitalMaster.getHospitalName();
			hospitalMaster.setStatus("n");
			hbt.update(hospitalMaster);
			dataDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public List getTableRecords(Map<String, Object> mapForDs) {

		List enquiryList = new ArrayList();
		String pojoName = (String) mapForDs.get("pojoName");
		String searchName = (String) mapForDs.get("searchName");
		String pojoPropertyName = (String) mapForDs.get("pojoPropertyName");
		try {
			enquiryList = getHibernateTemplate().find(
					"from jkt.security.masters.business." + pojoName
							+ " as master where master." + pojoPropertyName
							+ " like '" + searchName + "%'");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return enquiryList;
	}

	public boolean editHospitalToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Object> searchHospital(String hospitalCode,
			String hospitalName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showHospitalMasterJsp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showModuleManagementJsp(Box box) {
		Session session = (Session) getSession();

		List<Users> users = new ArrayList<Users>();
		// Set inPatientSet= new HashSet();
		// Map<String,Object>map= new HashMap<String, Object>();
		String userSearch = box.getString("userSearch").trim();
		String loginSearch = box.getString("loginSearch").trim();

		org.hibernate.Criteria criteria = null;
		try {
			criteria = session.createCriteria(Users.class).add(
					Restrictions.eq("Status", "y").ignoreCase());

			if (userSearch != null) {
				criteria = criteria.add(Restrictions.like("UserName", "%"
						+ userSearch + "%"));
			}
			if (loginSearch != null) {
				criteria = criteria.add(Restrictions.like("LoginName", "%"
						+ loginSearch + "%"));
			}
			users = criteria.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("users", users);
		return map;
	}

	public Map<String, Object> showUserManagementJsp(int userId) {

		Session session = (Session) getSession();
		List<Object> userList = new ArrayList<Object>();
		try {

			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("userList", userList);
		List<Object[]> userHospitalList = new ArrayList<Object[]>();
		userHospitalList = session.createCriteria(UserUsergroupHospital.class).createAlias("User", "u").add(Restrictions.eq("u.Id", userId))
				.createAlias("GroupHospital", "gh").createAlias("gh.Hospital", "h")
				.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("h.Id"))).add(Projections.property("h.HospitalName")))
				.list();
		map.put("userHospitalList", userHospitalList);
		return map;
	}

	public Map<String, Object> getGroupList(int hospitalId) {
		Session session = (Session) getSession();
		List<Object> groupList = new ArrayList<Object>();
		try {

			groupList = session.createQuery(
					"select ugh from UsergroupHospital as ugh where ugh.Hospital.Id="
							+ hospitalId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("groupList", groupList);

		return map;
	}

	public Map<String, Object> getApplicationGroupWise(int groupId) {

		Session session = (Session) getSession();
		String parentAppId = "";
		List<Object> applicationListGroupWise = new ArrayList<Object>();
		try {

			// applicationListGroupWise = session.createQuery("select gh from
			// GroupApplication as gh where gh.Group.Id="+ groupId+).list();
			applicationListGroupWise = session
					.createCriteria(GroupApplication.class)
					.createAlias("Group", "group",
							CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.eq("group.Id", groupId))
					.createAlias("App", "App", CriteriaSpecification.LEFT_JOIN)
					.createAlias("App.application", "application",
							CriteriaSpecification.LEFT_JOIN)
					.addOrder(Order.asc("application.Name"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			Iterator itr = applicationListGroupWise.iterator();
			while (itr.hasNext()) {
				GroupApplication groupApplication = (GroupApplication) itr
						.next();
				if (groupApplication.getApp().getParentId().equals("0")) {
					parentAppId = groupApplication.getApp().getId();
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("parentAppId", parentAppId);
		map.put("applicationListGroupWise", applicationListGroupWise);

		return map;
	}

	public Map<String, Object> getMasterApplicationList(int userId) {
		Session session = (Session) getSession();
		List<Object> masApplicationList = new ArrayList<Object>();
		List<Object> userList = new ArrayList<Object>();
		try {

			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();
			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masApplicationList", masApplicationList);
		map.put("userList", userList);

		return map;
	}

	public int getGroupIdFromGroupHospitalId(int groupHospitalId) {
		Session session = (Session) getSession();
		List<Object> groupIdList = new ArrayList<Object>();
		try {

			groupIdList = session.createQuery(
					" from UsergroupHospital as ugh  where ugh.Id="
							+ groupHospitalId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		UsergroupHospital usergroupHospital = (UsergroupHospital) groupIdList
				.get(0);
		int groupId = usergroupHospital.getGroup().getId();

		return groupId;
	}

	public boolean submitUserWiseApplication(Map map) {

		Session session = (Session) getSession();
		List<Object> groupIdList = new ArrayList<Object>();
		boolean successfullyAdded = false;
		UserUsergroupApplication userUsergroupApplication;
		int userId = (Integer) map.get("userId");
		int groupHospitalId = (Integer) map.get("groupHospitalId");
		List groupApplicationList = (List) map.get("groupApplicationList");
		List<GroupApplication> groupAppArrayList = (List<GroupApplication>) map
				.get("groupAppArrayList");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String hql = "delete from UserUsergroupApplication as uuga where uuga.GroupHospital.Id =:groupHosId and uuga.User.Id =:userId";
			Query query = session.createQuery(hql)
					.setParameter("groupHosId", groupHospitalId)
					.setParameter("userId", userId);
			int row = query.executeUpdate();
			if (row > 0) {
				successfullyAdded = true;
			}
			if (groupApplicationList != null && groupApplicationList.size() > 0) {
				Iterator iterator = groupApplicationList.iterator();
				while (iterator.hasNext()) {
					userUsergroupApplication = new UserUsergroupApplication();
					int groupApplicationId = (Integer) iterator.next();

					GroupApplication groupApplication = new GroupApplication();
					groupApplication.setId(groupApplicationId);
					userUsergroupApplication.setGroupApp(groupApplication);
					UsergroupHospital usergroupHospital = new UsergroupHospital();
					usergroupHospital.setId(groupHospitalId);
					userUsergroupApplication
							.setGroupHospital(usergroupHospital);
					Users users = new Users();
					users.setId(userId);
					userUsergroupApplication.setUser(users);
					userUsergroupApplication.setStatus("y");

					hbt.save(userUsergroupApplication);
System.out.println("After save");
					successfullyAdded = true;

				}

				if (groupAppArrayList != null && groupAppArrayList.size() > 0) {
					for (GroupApplication groupApplication : groupAppArrayList) {
						String parentId = groupApplication.getApp()
								.getParentId();
						int groupAppId = groupApplication.getId();
						if (parentId.equals("0")) {

							List<UserUsergroupApplication> checkParentAppList = session
									.createCriteria(
											UserUsergroupApplication.class)
									.createAlias("GroupApp", "groupApp")
									.createAlias("GroupHospital",
											"groupHospital")
									.createAlias("User", "user")
									.add(Restrictions.eq("groupApp.Id",
											groupAppId))
									.add(Restrictions.eq("groupHospital.Id",
											groupHospitalId))
									.add(Restrictions.eq("user.Id", userId))
									.list();
							if (checkParentAppList != null
									&& checkParentAppList.size() > 0) {
								userUsergroupApplication = checkParentAppList
										.get(0);
								String statusOfApp = userUsergroupApplication
										.getStatus();
								System.out.println(statusOfApp);
								if (statusOfApp.equals("n")) {
									userUsergroupApplication.setStatus("Y");
									hbt.update(userUsergroupApplication);
								}
							} else {
								userUsergroupApplication = new UserUsergroupApplication();
								GroupApplication groupApplication2 = new GroupApplication();
								groupApplication2.setId(groupAppId);
								userUsergroupApplication
										.setGroupApp(groupApplication2);
								UsergroupHospital usergroupHospital = new UsergroupHospital();
								usergroupHospital.setId(groupHospitalId);
								userUsergroupApplication
										.setGroupHospital(usergroupHospital);
								Users users = new Users();
								users.setId(userId);
								userUsergroupApplication.setStatus("Y");
								userUsergroupApplication.setUser(users);
								hbt.save(userUsergroupApplication);
							}
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public Map<String, Object> getUserUsergroupApplicationList(int userId,
			int groupHospitalId) {
		Session session = (Session) getSession();
		List<Object> userUsergroupApplicationList = new ArrayList<Object>();
		try {

			userUsergroupApplicationList = session
					.createQuery(
							" from UserUsergroupApplication as uugh  where  upper(uugh.GroupApp.Status)=upper('y') and uugh.User.Id="
									+ userId).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// Iterator itr=userUsergroupApplicationList.iterator();
		/*
		 * while(itr.hasNext()) { UserUsergroupApplication
		 * usergroupApplication=(UserUsergroupApplication)itr.next(); String
		 * appName=usergroupApplication.getGroupApp().getApp().getName(); //
		 * list---------"+appName); }
		 */
		map.put("userUsergroupApplicationList", userUsergroupApplicationList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDepartmentList(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
//		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<EmpScMapping> departmentList = new ArrayList<EmpScMapping>();
		//Added By OM Tripathi 3/2/2018
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		
		int deptId = 0;
		int empId = 0;
		int hospitalId = 0;
		int userId = 0;
		if(generalMap.get("deptId")!= null){
			deptId = (Integer)generalMap.get("deptId");
		}
		if(generalMap.get("empId")!= null){
			empId = (Integer)generalMap.get("empId");
		}
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		
		try {
		//	departmentList=getHibernateTemplate().find("select dept from EmpScMapping as esm join esm.Department as dept join esm.Employee as me join me.Users u where u.Id ="+userId+" and lower(u.Status)='y' and lower(me.Status)='y' and lower(dept.Status)='y' order by dept.DepartmentName asc ");
			departmentList=getHibernateTemplate().find("SELECT  DISTINCT dept FROM UserTemplate as ut join ut.Template as mt join mt.TemplateDepartments as td join ut.User as user join td.Department as dept where user.Id="+userId+" and upper(ut.Status)=upper('y') and upper(td.Status)=upper('y') and upper(user.Status)=upper('y') ORDER BY dept.DepartmentName asc ");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//Added By OM Tripathi 3/2/2018
		try {
			if(userId>0){
				tx = session.beginTransaction();
				Users user=(Users)session.get(Users.class, userId);
				MasDepartment department=new MasDepartment();
				department.setId(deptId);
				user.setDepartment(department);
				hbt.update(user);
				tx.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("deptList", departmentList);
		
		return map;

	}
	public Map<String, Object> showBranchList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserWiseBranch> userWiseBranchList = new ArrayList<UserWiseBranch>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<UserDepartment> searchUserDepartmentList = new ArrayList<UserDepartment>();
		Session session = (Session)getSession();
		userWiseBranchList = session.createCriteria(UserWiseBranch.class)
		.createAlias("User", "users").add(Restrictions.eq("users.Id", box.getInt("userId")))
		.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", box.getInt("ward")))
		.add(Restrictions.eq("Status", "y")).list();
		
			map.put("userWiseBranchList", userWiseBranchList);
		return map;
	}

	// Added by Kalyan
	public Map<String, Object> updateNewPassowd(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Users> changeList = new ArrayList<Users>();
		List<Users> usersList = new ArrayList<Users>();

		String message = "";
		String loginUser = (String) dataMap.get("loginUser");
		String pwd = (String) dataMap.get("oldpwd");
		String action = (String) dataMap.get("action");
		String loginName = (String) dataMap.get("loginName");
		String newPwd = (String) dataMap.get("newpwd");
		int userId = (Integer) dataMap.get("userId");
		// code for encryption
		List<Users> userListByLoginName = new ArrayList<Users>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		// usersList = getHibernateTemplate().find( "from
		// jkt.hms.masters.business.MasEmployee u order by u.FirstName");
		if (action.equals("update")) {
			if (!pwd.equals("")) {
				// changeList=getHibernateTemplate().find( "from
				// jkt.hms.masters.business.Users u where u.LoginName =
				// '"+loginName+"' and u.Password = '"+pwd+"'");
				userListByLoginName = getHibernateTemplate().find(
						"from jkt.hms.masters.business.Users u where u.LoginName = '"
								+ loginName + "'");
				for (Users users : userListByLoginName) {
					String pwdFromDB = users.getPassword();
					boolean bool = HMSUtil.validatePassword(pwdFromDB, pwd);
					if (HMSUtil.validatePassword(pwdFromDB, pwd)) {
						changeList.add(users);
					}
				}
				if (changeList.size() == 0) {
					message = "Your entered wrong password ";
				}
				if (changeList.size() > 0) {
					Users user = (Users) changeList.get(0);
					Users usersObj = (Users) hbt
							.load(Users.class, user.getId());
					// usersObj.setPassword(newPwd);
					usersObj.setPassword(HMSUtil.encryptPassword(newPwd));
					hbt.update(usersObj);
					message = "Your Password Updated";
				}
			}
		} else if (action.equals("reset")) {
			if (loginUser.equals("admin")) {
				Users usersObj = (Users) hbt.load(Users.class, userId);
				String userName = (String) usersObj.getLoginName();
				usersObj.setPassword(HMSUtil.encryptPassword(userName));
				hbt.update(usersObj);
				message = "Password reseted";
			}
		}
		map.put("changeList", changeList);
		// map.put("usersList",usersList);
		map.put("message", message);
		return map;
	}

	/** method to get dept type * */

	public String getDepartmentTypeCode(int deptId) {
		// TODO Auto-generated method stub
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

	// -------------------methods For enhancement of security module Assign
	// application to user-------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getApplicationListForAutoComplete(Map mapForDS) {
		@SuppressWarnings("unused")
		String appName = "";
		if (mapForDS.get("appName") != null) {
			appName = (String) mapForDS.get("appName");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + appName + "%";
		List<MasApplication> applicationsList = new ArrayList<MasApplication>();
		Criteria c = session.createCriteria(MasApplication.class).add(
				Restrictions.like("Name", str));
		c.setFirstResult(0);
		c.setMaxResults(10);
		applicationsList = c.list();
		dataMap.put("applicationsList", applicationsList);
		return dataMap;
	}

	public List<GroupApplication> getGroupForApplication(String applicationId) {
		Session session = (Session) getSession();

		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		Criteria c = session.createCriteria(GroupApplication.class)
				.createAlias("App", "app")
				.add(Restrictions.eq("app.Id", applicationId));
		groupList = c.list();
		return groupList;
	}

	// ------------------------method added for taking out application
	// array---------------
	public Map<String, Object> getGroupApplicationArray(String applicationId) {
		Session session = (Session) getSession();
		String[] applicationArray = null;
		List<MasApplication> appList = new ArrayList<MasApplication>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupApplication> groupAppArrayList = new ArrayList<GroupApplication>();
		MasApplication masApplication = null;
		appList = session.createCriteria(MasApplication.class)
				.add(Restrictions.eq("Id", applicationId)).list();
		masApplication = (MasApplication) appList.get(0);

		String parentId = masApplication.getParentId();

		List<GroupApplication> groupList = new ArrayList<GroupApplication>();
		groupList = session.createCriteria(GroupApplication.class)
				.createAlias("App", "app")
				.add(Restrictions.eq("app.Id", applicationId)).list();
		GroupApplication groupApplication = groupList.get(0);
		groupAppArrayList.add(groupApplication);

		if (!parentId.equals("0")) {
			appList = session.createCriteria(MasApplication.class)
					.add(Restrictions.eq("Id", parentId)).list();
			masApplication = appList.get(0);
			String parentApplicationId = masApplication.getId();
			String parentParentId = masApplication.getParentId();
			groupList = session.createCriteria(GroupApplication.class)
					.createAlias("App", "app")
					.add(Restrictions.eq("app.Id", parentApplicationId)).list();
			GroupApplication groupApplicationObj = groupList.get(0);
			groupAppArrayList.add(groupApplicationObj);

			if (!parentParentId.equals("0")) {
				appList = session.createCriteria(MasApplication.class)
						.add(Restrictions.eq("Id", parentParentId)).list();
				masApplication = appList.get(0);
				String parentParentApplicationId = masApplication.getId();
				groupList = session
						.createCriteria(GroupApplication.class)
						.createAlias("App", "app")
						.add(Restrictions.eq("app.Id",
								parentParentApplicationId)).list();
				GroupApplication groupApplicationObject = groupList.get(0);
				groupAppArrayList.add(groupApplicationObject);
			}
		}
		map.put("groupAppArrayList", groupAppArrayList);
		return map;
	}

	// --------method incomplete adding for taking out application
	// array----------
	public List<UsergroupHospital> getHospitalList(int groupApplicationId,
			int hospitalId) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<UsergroupHospital> hospitalList = new ArrayList<UsergroupHospital>();

		GroupApplication groupAplication = (GroupApplication) hbt.load(
				GroupApplication.class, groupApplicationId);
		int groupId = groupAplication.getGroup().getId();
		Criteria c = session.createCriteria(UsergroupHospital.class)
				.createAlias("Group", "group")
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("group.Id", groupId));
		hospitalList = c.list();

		return hospitalList;
	}

	public List<UserEmpGroup> getAllUsersListFromUserEmpGroup(int hospitalId) {
		Session session = (Session) getSession();

		List<UserEmpGroup> usersList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId));
		usersList = c.list();

		return usersList;
	}

	@SuppressWarnings("unused")
	public List<UserUsergroupApplication> getUserListFromUserUGApp(
			int groupHospitalId, int groupAppId) {

		Session session = (Session) getSession();

		List<UserUsergroupApplication> userUGAppList = new ArrayList<UserUsergroupApplication>();

		userUGAppList = session.createCriteria(UserUsergroupApplication.class)
				.createAlias("GroupHospital", "groupHospital")
				.createAlias("GroupApp", "groupApp")
				.add(Restrictions.eq("GroupApp.Id", groupAppId))
				.add(Restrictions.eq("GroupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		return userUGAppList;
	}

	public boolean addUserWiseApplication(Map dataMap) {
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;
		List<Integer> userIdToBeAdded = (List) dataMap.get("userIdToBeAdded");
		List<Integer> userIdToBeRemoved = (List) dataMap
				.get("userIdToBeRemoved");
		List<GroupApplication> groupAppArrayList = (List) dataMap
				.get("groupAppArrayList");
		// int groupApplicationId=(Integer)dataMap.get("groupApplicationId");
		int groupHospitalId = (Integer) dataMap.get("groupHospitalId");
		try {
			tx = session.beginTransaction();
			for (Integer userId : userIdToBeRemoved) {
				for (GroupApplication groupApplication : groupAppArrayList) {
					int groupApplicationId = groupApplication.getId();
					List userUGAppList = session
							.createCriteria(UserUsergroupApplication.class)
							.createAlias("GroupHospital", "groupHosp")
							.createAlias("GroupApp", "groupApp")
							.createAlias("User", "user")
							.add(Restrictions.eq("groupHosp.Id",
									groupHospitalId))
							.add(Restrictions.eq("groupApp.Id",
									groupApplicationId))
							.add(Restrictions.eq("user.Id", userId)).list();
					UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
							.get(0);
					int userUserGroupAppId = userUsergroupApplication.getId();
					UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
							.load(UserUsergroupApplication.class,
									userUserGroupAppId);
					userUsergroupApplicationObj.setStatus("n");
					hbt.update(userUsergroupApplicationObj);

				}
			}

			for (Integer userId : userIdToBeAdded) {
				for (GroupApplication groupApplication : groupAppArrayList) {
					int groupApplicationId = groupApplication.getId();
					List userUGAppList = session
							.createCriteria(UserUsergroupApplication.class)
							.createAlias("GroupHospital", "groupHosp")
							.createAlias("GroupApp", "groupApp")
							.createAlias("User", "user")
							.add(Restrictions.eq("groupHosp.Id",
									groupHospitalId))
							.add(Restrictions.eq("groupApp.Id",
									groupApplicationId))
							.add(Restrictions.eq("user.Id", userId)).list();
					if (userUGAppList != null && userUGAppList.size() > 0) {
						UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
								.get(0);
						int userUserGroupAppId = userUsergroupApplication
								.getId();
						UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
								.load(UserUsergroupApplication.class,
										userUserGroupAppId);
						userUsergroupApplicationObj.setStatus("y");
						hbt.update(userUsergroupApplicationObj);
					} else {
						UserUsergroupApplication userUsergroupApplication = new UserUsergroupApplication();

						GroupApplication groupApplicationObj = new GroupApplication();
						groupApplicationObj.setId(groupApplicationId);
						userUsergroupApplication
								.setGroupApp(groupApplicationObj);
						UsergroupHospital usergroupHospital = new UsergroupHospital();
						usergroupHospital.setId(groupHospitalId);
						userUsergroupApplication
								.setGroupHospital(usergroupHospital);
						Users users = new Users();
						users.setId(userId);
						userUsergroupApplication.setUser(users);
						userUsergroupApplication.setAddStatus("y");
						userUsergroupApplication.setDeleteStatus("y");
						userUsergroupApplication.setUpdateStatus("y");
						userUsergroupApplication.setStatus("y");
						hbt.save(userUsergroupApplication);
					}
				}
			}

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dataSaved;
	}

	public Map<String, Object> getEmpGroupList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			empGroupList = session.createCriteria(EmpGroups.class)
					.add(Restrictions.eq("Status", status)).list();

			map.put("empGroupList", empGroupList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<UserEmpGroup> getUsersListFromUserEmpGroup(int empGroupId,
			int groupHospitalId) {
		Session session = (Session) getSession();

		List<UserUsergroupHospital> usersList = new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		userEmpGroupList = session.createCriteria(UserEmpGroup.class)
				.createAlias("EmpGroup", "empGroup")
				.add(Restrictions.eq("empGroup.Id", empGroupId)).list();
		/*
		 * for(Iterator itr=userEmpGroupList.iterator();itr.hasNext();){
		 * UserEmpGroup userEmpGroup=(UserEmpGroup)itr.next(); int
		 * userId=userEmpGroup.getUser().getId(); List<UserUsergroupHospital>
		 * userUserGroupHospitalList
		 * =session.createCriteria(UserUsergroupHospital
		 * .class).createAlias("User",
		 * "user").createAlias("GroupHospital","groupHospital"
		 * ).add(Restrictions.eq("user.Id",
		 * userId)).add(Restrictions.eq("groupHospital.Id",
		 * groupHospitalId)).list(); for(UserUsergroupHospital
		 * userUsergroupHospital:userUserGroupHospitalList){ int
		 * userUserGroupHospitalId=userUsergroupHospital.getId();
		 * UserUsergroupHospital user =
		 * (UserUsergroupHospital)getHibernateTemplate
		 * ().load(UserUsergroupHospital.class, userUserGroupHospitalId);
		 * usersList.add(user); } }
		 */
		return userEmpGroupList;
	}

	// -----------------methods added for assign module---------------

	public Map<String, Object> showAssignModuleToEmpGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", status)).list();

			map.put("hospitalList", hospitalList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> populateEmpGroupAndAppGroupJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";

			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			List<UsergroupHospital> groupHospitalList = new ArrayList<UsergroupHospital>();
			empGroupList = session.createCriteria(EmpGroups.class)
					.add(Restrictions.eq("Status", status)).list();
			groupHospitalList = session.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("Status", status))
					.add(Restrictions.eq("hospital.Id", hospitalId)).list();
			map.put("groupHospitalList", groupHospitalList);
			map.put("empGroupList", empGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<MasApplication> getApplicationList(int groupId) {
		Session session = (Session) getSession();
		List<MasApplication> masApplicationList = new ArrayList<MasApplication>();
		try {

			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return masApplicationList;
	}

	public List<UserUsergroupHospital> getUserListFromUserUserGroupHospitalForGroupHospitalId(
			int groupHospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<UserUsergroupHospital> usersList = new ArrayList<UserUsergroupHospital>();
		Criteria c = session.createCriteria(UserUsergroupHospital.class)
				.createAlias("GroupHospital", "groupHospital")
				.add(Restrictions.eq("groupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y"));
		usersList = c.list();

		return usersList;
	}

	public List<UserEmpGroup> getUserListFromUserEmpGroup(int empGroupId) {
		Session session = (Session) getSession();

		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class)
				.createAlias("EmpGroup", "empGroup")
				.add(Restrictions.eq("empGroup.Id", empGroupId));
		userEmpGroupList = c.list();

		return userEmpGroupList;
	}

	@SuppressWarnings("unchecked")
	public boolean assignModuleToEmpGroup(Map dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		List<Object> applicationListGroupWise = (List) dataMap
				.get("applicationListGroupWise");
		String[] userIdArray = (String[]) dataMap.get("userIdArray");
		String[] appIdArray = (String[]) dataMap.get("appIdArray");
		int groupId = (Integer) dataMap.get("groupId");
		int groupHospitalId = (Integer) dataMap.get("groupHospitalId");
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < userIdArray.length; i++) {

				for (int j = 0; j < appIdArray.length; j++) {
					for (Iterator itr = applicationListGroupWise.iterator(); itr
							.hasNext();) {
						GroupApplication groupApplication = (GroupApplication) itr
								.next();
						if (appIdArray[j].toString().equals(
								groupApplication.getApp().getId())) {
							int groupApplicationId = groupApplication.getId();
							int userId = Integer.parseInt(userIdArray[i]);

							List userUGAppList = session
									.createCriteria(
											UserUsergroupApplication.class)
									.createAlias("GroupHospital", "groupHosp")
									.createAlias("GroupApp", "groupApp")
									.createAlias("User", "user")
									.add(Restrictions.eq("groupHosp.Id",
											groupHospitalId))
									.add(Restrictions.eq("groupApp.Id",
											groupApplicationId))
									.add(Restrictions.eq("user.Id", userId))
									.list();
							if (userUGAppList != null
									&& userUGAppList.size() > 0) {
								UserUsergroupApplication userUsergroupApplication = (UserUsergroupApplication) userUGAppList
										.get(0);
								int userUserGroupAppId = userUsergroupApplication
										.getId();
								UserUsergroupApplication userUsergroupApplicationObj = (UserUsergroupApplication) hbt
										.load(UserUsergroupApplication.class,
												userUserGroupAppId);
								userUsergroupApplicationObj.setStatus("y");
								userUsergroupApplicationObj.setAddStatus("n");
								userUsergroupApplicationObj
										.setDeleteStatus("n");
								userUsergroupApplicationObj
										.setUpdateStatus("n");
								hbt.update(userUsergroupApplicationObj);
							} else {

								UserUsergroupApplication userUsergroupApplication = new UserUsergroupApplication();
								Users user = new Users();
								user.setId(Integer.parseInt(userIdArray[i]));
								userUsergroupApplication.setUser(user);
								GroupApplication groupApplicationObj = new GroupApplication();
								groupApplicationObj.setId(groupApplication
										.getId());
								userUsergroupApplication
										.setGroupApp(groupApplicationObj);
								UsergroupHospital usergroupHospital = new UsergroupHospital();
								usergroupHospital.setId(groupHospitalId);
								userUsergroupApplication
										.setGroupHospital(usergroupHospital);

								userUsergroupApplication.setStatus("y");
								userUsergroupApplication.setAddStatus("n");
								userUsergroupApplication.setDeleteStatus("n");
								userUsergroupApplication.setUpdateStatus("n");
								hbt.save(userUsergroupApplication);
							}
						}
					}
				}
			}

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dataSaved;
	}

	public List<UserUsergroupApplication> getUserListFromUUGAppForGroupHospital(
			int groupHospitalId) {
		Session session = (Session) getSession();

		List<UserUsergroupApplication> userUGAppList = new ArrayList<UserUsergroupApplication>();

		userUGAppList = session.createCriteria(UserUsergroupApplication.class)
				.createAlias("GroupHospital", "groupHospital")
				.add(Restrictions.eq("GroupHospital.Id", groupHospitalId))
				.add(Restrictions.eq("Status", "y")).list();

		return userUGAppList;

	}

	// ------------------------End of methods for assign
	// module----------------------------------

	// --------------end of methods added for security screen Assign application
	// to user-------------------

	public List<UserEmpGroup> getUserListFromUserEmpGroup(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int empGroupId = (Integer) dataMap.get("empGroupId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		Criteria c = session.createCriteria(UserEmpGroup.class)
				.createAlias("EmpGroup", "empGroup")
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("empGroup.Id", empGroupId))
				.add(Restrictions.eq("hospital.Id", hospitalId));
		userEmpGroupList = c.list();

		return userEmpGroupList;
	}

	// ----------------------------method added by vikas on
	// 29/04/09-----------------------------

	public Map<String, Object> showAssignButtonRightsToEmpGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";
			List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();
			List<MasHospital> hospitalList = new ArrayList<MasHospital>();
			List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", status)).list();
			// formList=session.createCriteria(MasButtonForm.class).add(Restrictions.eq("Status",
			// status)).list();
			empGroupList = session.createCriteria(EmpGroups.class)
					.add(Restrictions.eq("Status", status)).list();
			formList = session
					.createSQLQuery(
							"select Distinct(form_name) from  mas_button_form where status='y';")
					.list();
			map.put("empGroupList", empGroupList);
			map.put("hospitalList", hospitalList);
			map.put("formList", formList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

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
					.add(Restrictions.eq("Status", status)).list();
			map.put("buttonList", buttonList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean assignButtonRightsToEmpGroup(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		String[] buttonNameArray = (String[]) dataMap.get("buttonNameArray");
		String[] userIdArray = (String[]) dataMap.get("userIdArray");
		int empGroupId = (Integer) dataMap.get("empGroupId");
		String formName = (String) dataMap.get("formName");
		try {
			tx = session.beginTransaction();

			for (int k = 0; k < userIdArray.length; k++) {
				int userId = Integer.parseInt(userIdArray[k]);
				List<UserButtonRights> userButtonRightsList = session
						.createCriteria(UserButtonRights.class)
						.createAlias("User", "user")
						.createAlias("EmpGroup", "empGroup")
						.createAlias("Button", "button")
						.add(Restrictions.eq("user.Id", userId))
						.add(Restrictions.eq("button.FormName", formName))
						.add(Restrictions.eq("empGroup.Id", empGroupId)).list();
				hbt.deleteAll(userButtonRightsList);

			}

			for (int i = 0; i < buttonNameArray.length; i++) {
				int buttonId = Integer.parseInt(buttonNameArray[i]);
				for (int j = 0; j < userIdArray.length; j++) {
					int userId = Integer.parseInt(userIdArray[j]);
					List<UserButtonRights> userButtonRightsList = session
							.createCriteria(UserButtonRights.class)
							.createAlias("User", "user")
							.createAlias("EmpGroup", "empGroup")
							.createAlias("Button", "button")
							.add(Restrictions.eq("user.Id", userId))
							.add(Restrictions.eq("button.Id", buttonId))
							.add(Restrictions.eq("empGroup.Id", empGroupId))
							.list();
					if (userButtonRightsList == null
							|| userButtonRightsList.size() == 0) {
						UserButtonRights userButtonRights = new UserButtonRights();

						Users user = new Users();
						user.setId(userId);
						userButtonRights.setUser(user);

						MasButtonForm masButtonForm = new MasButtonForm();
						masButtonForm.setId(buttonId);
						userButtonRights.setButton(masButtonForm);

						EmpGroups empGroups = new EmpGroups();
						empGroups.setId(empGroupId);
						userButtonRights.setEmpGroup(empGroups);
						hbt.save(userButtonRights);
					}

				}
			}
			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dataSaved;
	}

	public List<Users> getEmpNameByLoginName(String loginName) {
		List<Users> userList = new ArrayList<Users>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("LoginName", loginName))
					.add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public Map<String, Object> showRemoveButtonRights(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = null;
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			int userId = (Integer) dataMap.get("userId");
			user = (Users) hbt.load(Users.class, userId);
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", "y")).list();
			formList = session
					.createSQLQuery(
							"select Distinct(form_name) from  mas_button_form where status='y';")
					.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("user", user);
		map.put("hospitalList", hospitalList);
		map.put("formList", formList);

		return map;
	}

	public Map<String, Object> getButtonRightsAvailableList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String formName = (String) dataMap.get("formName");
			int userId = (Integer) dataMap.get("userId");
			String status = "y";
			List<UserButtonRights> buttonList = new ArrayList<UserButtonRights>();
			buttonList = session.createCriteria(UserButtonRights.class)
					.createAlias("User", "user")
					.createAlias("Button", "button")
					.add(Restrictions.eq("user.Id", userId))
					.add(Restrictions.eq("button.FormName", formName))
					.add(Restrictions.eq("button.Status", status)).list();
			map.put("buttonList", buttonList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public boolean removeButtonRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;

		String[] buttonNameArray = (String[]) dataMap.get("buttonNameArray");
		int userId = (Integer) dataMap.get("userId");

		String formName = (String) dataMap.get("formName");
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < buttonNameArray.length; i++) {
				int buttonId = Integer.parseInt(buttonNameArray[i]);

				List<UserButtonRights> userButtonRightsList = session
						.createCriteria(UserButtonRights.class)
						.createAlias("User", "user")
						.createAlias("Button", "button")
						.add(Restrictions.eq("user.Id", userId))
						.add(Restrictions.eq("button.Id", buttonId)).list();
				hbt.deleteAll(userButtonRightsList);
			}
			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dataSaved;
	}

	public Map<String, Object> viewUserRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int userId = (Integer) dataMap.get("userId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		List<Object> userUsergroupApplicationList = new ArrayList<Object>();
		List<Object> masApplicationList = new ArrayList<Object>();
		List<Object> userList = new ArrayList<Object>();
		try {

			// userUsergroupApplicationList = session.createQuery(" from
			// UserUsergroupApplication as uugh where
			// uugh.User.Id="+userId).list();
			userUsergroupApplicationList = session
					.createCriteria(UserUsergroupApplication.class)
					.createAlias("User", "user")
					.createAlias("GroupHospital", "groupHospital")
					.createAlias("groupHospital.Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("user.Id", userId)).list();
			masApplicationList = session.createQuery(
					" from MasApplication as masApp ").list();
			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", userId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("userList", userList);
		map.put("userUsergroupApplicationList", userUsergroupApplicationList);
		map.put("masApplicationList", masApplicationList);

		return map;

	}

	public boolean removeUserRights(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean dataSaved = false;
		int userId = (Integer) dataMap.get("userId");
		int hospitalId = (Integer) dataMap.get("hospitalId");

		try {
			tx = session.beginTransaction();

			List<UserUsergroupApplication> userUsergroupApplicationList = session
					.createCriteria(UserUsergroupApplication.class)
					.createAlias("User", "user")
					.createAlias("GroupHospital", "groupHospital")
					.createAlias("groupHospital.Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("user.Id", userId)).list();

			hbt.deleteAll(userUsergroupApplicationList);

			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return dataSaved;

	}

	public Map<String, Object> showOrderApplicationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			List<MasApplication> moduleList = new ArrayList<MasApplication>();
			
			moduleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasApplication where upper(Status)='Y' and ParentId='"
							+ 0 + "' order by name ASC");
			map.put("moduleList", moduleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> populateEmpGroup(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			String status = "y";

			List<UsergroupHospital> groupHospitalList = new ArrayList<UsergroupHospital>();

			groupHospitalList = session.createCriteria(UsergroupHospital.class)
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("Status", status))
					.add(Restrictions.eq("hospital.Id", hospitalId)).list();
			map.put("groupHospitalList", groupHospitalList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean submitSwapApplication(Map<String, Object> dataMap) {
		boolean success = false;
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			Vector appIdVector = (Vector) dataMap.get("appIdVector");
			Vector OrderNoVector = (Vector) dataMap.get("OrderNoVector");
			System.out.println(appIdVector);
			System.out.println(OrderNoVector);
			for (int i = 0; i < appIdVector.size(); i++) {
				String appId = (String) appIdVector.get(i);
				MasApplication masApplication = (MasApplication) hbt.load(
						MasApplication.class, appId);
				masApplication.setOrderNo(Integer
						.parseInt((String) OrderNoVector.get(i)));
				hbt.update(masApplication);
				hbt.refresh(masApplication);

			}
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean addOrderInApplication() {
		boolean success = false;
		int orderNo = 1;
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();
			List<MasApplication> masApplicationList = new ArrayList<MasApplication>();

			masApplicationList = session.createCriteria(MasApplication.class)
					.list();
			for (MasApplication masApplication : masApplicationList) {
				String appId = masApplication.getId();
				MasApplication masApplication2 = (MasApplication) hbt.load(
						MasApplication.class, appId);
				//masApplication2.setOrderNo(orderNo);
				hbt.update(masApplication2);
				orderNo++;
			}
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	// ----------------------------method added by vikas on
	// 29/04/09-----------------------------
	public List<UserUsergroupApplication> getUserApplicationList(int user,
			int groupId) {
		Session session = (Session) getSession();
		List<UserUsergroupApplication> masApplicationList = new ArrayList<UserUsergroupApplication>();
		List<UsergroupHospital> groupHospList = new ArrayList<UsergroupHospital>();
		try {

			groupHospList = session.createCriteria(UsergroupHospital.class)
					.add(Restrictions.eq("Group.Id", groupId)).list();
			groupId = 0;
			if (groupHospList.size() > 0) {
				UsergroupHospital group = (UsergroupHospital) groupHospList
						.get(0);
				groupId = group.getId();
			}
			masApplicationList = session
					.createCriteria(UserUsergroupApplication.class)
					.createAlias("GroupApp", "group")
					.add(Restrictions.eq("User.Id", user))
					.add(Restrictions.eq("GroupHospital.Id", groupId))
					.add(Restrictions.eq("group.Status", "y"))
					.addOrder(Order.asc("GroupApp.Id")).list();
			// masApplicationList = session.createQuery(" from MasApplication as
			// masApp ").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return masApplicationList;
	}

	public void compareMasApplication() {
		Session session = (Session) getSession();
		List<Object> masApplicationList = new ArrayList<Object>();
		List<Object> masApplicationTestList = new ArrayList<Object>();
		try {
			masApplicationList = session.createSQLQuery(
					"select url from mas_application ").list();
			masApplicationTestList = session.createSQLQuery(
					"select url from mas_application_test ").list();

			Vector original = new Vector(masApplicationList);
			Vector test = new Vector(masApplicationTestList);
			test.removeAll(original);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Map<String, Object> showUserWiseBranchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<UserDepartment> userDeptList = new ArrayList<UserDepartment>();
		Set<Users> userSet = new HashSet<Users>();
		List<Users> userList = new ArrayList<Users>();
		List<Users> userList1 = new ArrayList<Users>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<Object[]> searchBranchList = new ArrayList<Object[]>();
		List<UserWiseBranch> userWiseBranchList = new ArrayList<UserWiseBranch>();
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session = (Session)getSession();
		
		try{
			departmentList = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "deptType").add(Restrictions.eq("deptType.DepartmentTypeName", "Finance")).list();
			userDeptList = session.createCriteria(UserDepartment.class).createAlias("Department", "dept").createAlias("dept.DepartmentType", "deptType").add(Restrictions.eq("deptType.DepartmentTypeName", "Finance")).list();
			int userId = 0;
			if(userDeptList.size()>0){
				for(UserDepartment userDepartment :userDeptList){
					 userId = userDepartment.getUser().getId();
					 userList = session.createCriteria(Users.class).add(Restrictions.idEq(userId)).list();
					 userSet.add(userList.get(0));
					 //userList1.add(userList.get(0));
				}
			}
			map.put("userSet", userSet);
				
			branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		//	searchBranchList = session.createCriteria(UserWiseBranch.class).add(Restrictions.eq("Status", "y")).createAlias("Department", "dept").setProjection(Projections.distinct(Projections.property("dept.DepartmentName"))).list();
			
			//searchBranchList = hbt.find("select distinct uwb.Department from jkt.hms.masters.business.UserWiseBranch uwb where uwb.Department.Status='y'");
			//userWiseBranchList = session.createCriteria(UserWiseBranch.class).list();
			userWiseBranchList = hbt.find("from jkt.hms.masters.business.UserWiseBranch as uwb");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("userDeptList", userDeptList);
		
		map.put("userList1", userList1);
		map.put("userList", userList);
		map.put("branchList", branchList);
		map.put("userWiseBranchList", userWiseBranchList);
		map.put("searchBranchList", searchBranchList);
		return map;
	}


	public Map<String, Object> addUserWiseBranch(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserWiseBranch> existingUserBranchList = new ArrayList();
		int userId = 0;
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		int deptId = 0;
		if(generalMap.get("deptId")!= null){
			deptId = (Integer)generalMap.get("deptId");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		int changedBy = 0;
		if(generalMap.get("changedBy")!= null){
			changedBy = (Integer)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if(generalMap.get("currentDate")!= null){
			currentDate = (Date)generalMap.get("currentDate");
		}
		String currentTime = "";
		if(generalMap.get("currentTime")!= null){
			currentTime = (String)generalMap.get("currentTime");
		}
		String branchStr = null;
		
		if (generalMap.get("branchStr") != null) {
			branchStr = (String) generalMap.get("branchStr");
		}
		Session session = (Session)getSession();
		String message = "";
		boolean successfullyAdded = false;
		StringTokenizer strForbranch = new StringTokenizer(branchStr, ",");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			while (strForbranch.hasMoreTokens()) {
				UserWiseBranch userWiseBranch = new UserWiseBranch();
				int branchId = Integer.parseInt(strForbranch.nextToken());
				MasBranch masBranch = new MasBranch();
				masBranch.setId(branchId);
				userWiseBranch.setBranch(masBranch);
				
				Users users = new Users();
				users.setId(userId);
				userWiseBranch.setUser(users);
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				userWiseBranch.setDepartment(masDepartment);
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				userWiseBranch.setHospital(masHospital);
				
				Users users2 = new Users();
				users2.setId(changedBy);
				userWiseBranch.setLastChgBy(users2);
				
				userWiseBranch.setLastChgDate(currentDate);
				userWiseBranch.setLastChgTime(currentTime);
				userWiseBranch.setStatus("y");
				existingUserBranchList =session.createCriteria(UserWiseBranch.class).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Branch.Id", branchId))
				.add(Restrictions.eq("Department.Id", deptId)).list();
				
				if (existingUserBranchList.size() > 0) {
					message = "Record already Exist";
				} else {
					hbt.save(userWiseBranch);
					message = "Record saved sucessfully!";

				
			}
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("message",message);
		return map;
	}

	
	public Map<String, Object> editUserWiseBranch(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserWiseBranch> existingUserBranchList = new ArrayList();
		int userId = 0;
		Session session = (Session)getSession();
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		int userBranchId = 0;
		if(generalMap.get("userBranchId")!= null){
			userBranchId = (Integer)generalMap.get("userBranchId");
		}
		int deptId = 0;
		if(generalMap.get("deptId")!= null){
			deptId = (Integer)generalMap.get("deptId");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		int branchId = 0;
		
		if (generalMap.get("branchId") != null) {
			branchId = (Integer) generalMap.get("branchId");
		}
		
		int changedBy = 0;
		if(generalMap.get("changedBy")!= null){
			changedBy = (Integer)generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if(generalMap.get("currentDate")!= null){
			currentDate = (Date)generalMap.get("currentDate");
		}
		String currentTime = "";
		if(generalMap.get("currentTime")!= null){
			currentTime = (String)generalMap.get("currentTime");
		}
		//StringTokenizer str = new StringTokenizer(branchStr, ",");
		
		boolean dataUpdated = false;
		String message = "";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			/*List<UserWiseBranch> userWiseBranchList = hbt.find("from jkt.hms.masters.business.UserWiseBranch ud where ud.Department.Id="+ deptId);
			for (Iterator iterator = userWiseBranchList.iterator(); iterator
					.hasNext();) {
				UserWiseBranch userWiseBranch = (UserWiseBranch) iterator
						.next();
				int id = userWiseBranch.getId();
				String hql = "delete from jkt.hms.masters.business.UserWiseBranch as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}*/
			existingUserBranchList =session.createCriteria(UserWiseBranch.class).add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Branch.Id", branchId))
			.add(Restrictions.eq("Department.Id", deptId)).list();
			if (existingUserBranchList.size() > 0) {
				message = "Record already Exist";
			} else {
				
		
			UserWiseBranch userWiseBranch = (UserWiseBranch) hbt.load(UserWiseBranch.class, userBranchId);
				userWiseBranch.setBranch(new MasBranch(branchId));
				userWiseBranch.setUser(new Users(userId));
				userWiseBranch.setDepartment(new MasDepartment(deptId));
				userWiseBranch.setStatus("y");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				userWiseBranch.setHospital(masHospital);
				
				Users users2 = new Users();
				users2.setId(changedBy);
				userWiseBranch.setLastChgBy(users2);
				
				userWiseBranch.setLastChgDate(currentDate);
				userWiseBranch.setLastChgTime(currentTime);
				
				message = "Record update sucessfully!";
				hbt.update(userWiseBranch);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("message",message);
		return map;
	}

	@Override
	public Map<String, Object> getModuleWiseApplication(String parentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasApplication> appList = new ArrayList<MasApplication>();
		Session session = (Session) getSession();
		System.out.println(parentId);
		appList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication where upper(Status)='Y' and ParentId="
						+"? order by OrderNo",parentId); // chanegd by amit das on 01-08-2017 for preventing sql injection
		map.put("appList", appList);
		return map;
	}

	
}
