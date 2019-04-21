package jkt.hrms.recruitment.dataservice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jkt.hms.exception.DataServiceException;
import jkt.hms.masters.business.HrRequisitionFrPromotion;
import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeHistory;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasApplicationLevel;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.recruitment.masters.business.HrReqPromHistory;
import jkt.hrms.recruitment.masters.business.HrReqPromStatus;
import jkt.hrms.recruitment.masters.business.HrResumePayElements;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;
import jkt.hrms.recruitment.masters.business.Resumehrdetails;
import jkt.hrms.recruitment.masters.business.Resumehrdetailshistory;
import jkt.hrms.recruitment.masters.business.Resumepersonaldetails;
import jkt.hrms.recruitment.masters.business.Resumeprojectsdetail;
import jkt.hrms.recruitment.masters.business.Resumeremarks;
import jkt.hrms.recruitment.masters.business.Resumeskill;
import jkt.hrms.recruitment.masters.business.Resumeskillmaster;
import jkt.hrms.recruitment.masters.business.Resumestatus;
import jkt.hrms.recruitment.masters.business.Resumestatushistory;
import jkt.hrms.recruitment.masters.business.Resumestatusmaster;
import jkt.hrms.recruitment.masters.business.Resumetechnical;
import jkt.hrms.recruitment.masters.business.Resumetechnicalhistory;
import jkt.hrms.recruitment.masters.business.Uploads;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class ResumeDataServiceImpl extends HibernateDaoSupport implements
		ResumeDataService {

	boolean isEditResume = false;
	String errorString = null;

	public ResumeDataServiceImpl() {
		isEditResume = false;
		errorString = null;
	}

	public Connection getDBConnection() {
		Session session = (Session) getSession(true);
		Connection connection = null;
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			connection = session.connection();
			// session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public List getSkillMasterList() {
		List skillMasterList = null;
		try {
			skillMasterList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumeskillmaster as sm order by sm.SkillDesc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return skillMasterList;
	}

	public List getDuList() {
		List duList = null;
		try {
			duList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumedudetail as rdd order by rdd.DUName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duList;
	}

	public List<Resumeprojectsdetail> getProjectDetails() {
		List<Resumeprojectsdetail> projectDetails = null;
		try {
			projectDetails = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumeprojectsdetail as rpd order by rpd.Id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectDetails;
	}

	public List getJobProfiles() {
		List jobProfiles = null;
		try {
			jobProfiles = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumejobprofile");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobProfiles;
	}

	public Map<String, Object> checkResumeUniqueness(
			Map<String, Object> verificationMap) {

		errorString = "Verified";

		String resumeThrough = (String) verificationMap.get("resumeThrough");
		String firstName = (String) verificationMap.get("firstName");
		String lastName = (String) verificationMap.get("lastName");
		String dateOfBirth = (String) verificationMap.get("dateOfBirth");
		String emailId = (String) verificationMap.get("emailId");
		String currentEmployer = (String) verificationMap
				.get("currentEmployer");
		String previousEmployer = (String) verificationMap
				.get("previousEmployer");
		String passportNumber = (String) verificationMap.get("passportNumber");

		List resumeList = new ArrayList();
		if (!passportNumber.equals("")) {
			resumeList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where "
							+ "rpd.PassportNo ='" + passportNumber + "'");
		}
		if (resumeList.isEmpty() && emailId != null && !emailId.equals("")) {
			resumeList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where "
							+ "rpd.EmailId ='" + emailId + "'");
		}
		if (resumeList.isEmpty()) {
			StringBuffer hql = new StringBuffer(
					"from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where rpd.ResumeStatus.StatusId != 8"
							+ " and rpd.FirstName ='"
							+ firstName
							+ "' and rpd.LastName='"
							+ lastName
							+ "' and rpd.DateOfBirth='" + dateOfBirth + "'");
			if (!previousEmployer.equals("")) {
				hql.append("and ( rpd.CurrentEmployer like '" + currentEmployer
						+ "' or rpd.CurrentEmployer like '" + previousEmployer
						+ "')");
			} else {
				hql.append("and ( rpd.CurrentEmployer like '" + currentEmployer
						+ "')");
			}
			Session sess = null;
			try {
				sess = getHibernateTemplate().getSessionFactory().openSession();
				Query query = sess.createQuery(hql.toString());
				resumeList = query.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (resumeList.size() > 0) {
			errorString = "Record Already Existed";
		}
		verificationMap.put("errorString", errorString);
		verificationMap.put("resumeList", resumeList);
		verificationMap.put("skillMasterList", getSkillMasterList());
		verificationMap.put("statusMasterList", getStatusMasterList());
		verificationMap.put("duList", getDuList());
		verificationMap.put("projectDetails", getProjectDetails());
		verificationMap.put("jobProfiles", getJobProfiles());

		return verificationMap;
	}

	public List getStatusMasterList() {
		List statusMaster = null;
		Criteria criteria = getSession().createCriteria(
				Resumestatusmaster.class);
		criteria = criteria.add(Restrictions.in("Id",
				new Object[] { 11, 12, 13 }));
		try {
			statusMaster = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumestatusmaster ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// statusMaster = criteria.list();
		return statusMaster;
	}

	public List getStatusMasterListForFinalStatus() {
		List statusMaster = null;
		Criteria criteria = getSession().createCriteria(
				Resumestatusmaster.class);
		criteria = criteria.add(Restrictions.in("Id",
				new Object[] { 11, 12, 13 }));
		statusMaster = criteria.list();
		return statusMaster;
	}

	public int getLastResumeId() {
		int resumeid = 0;
		Resumepersonaldetails resumePersonalDetails = null;
		try {
			List resume = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails");
			if (resume.size() > 0) {
				for (Iterator resumeIterator = resume.iterator(); resumeIterator
						.hasNext();) {
					resumePersonalDetails = (Resumepersonaldetails) (Resumepersonaldetails) resumeIterator
							.next();
					resumeid = resumePersonalDetails.getId().intValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resumeid;
	}

	public Map<String, Object> addResume(Map<String, Object> addResumeDetails) {
		Map<String, Object> addResumeMap = new HashMap<String, Object>();
		boolean isAddResume = false;
		isAddResume = false;
		try {

			Resumepersonaldetails resumePersonalDetails = (Resumepersonaldetails) addResumeDetails
					.get("personalDetails");
			Resumeremarks resumeRemarks = (Resumeremarks) addResumeDetails
					.get("resumeRemarks");

			String passportNO = resumePersonalDetails.getPassportNo();
			List passportList = new ArrayList();

			if (!passportNO.equals("") || passportNO.length() != 0) {
				passportList = getHibernateTemplate()
						.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where rpd.PassportNo='"
								+ passportNO + "'");
			}

			if (passportList != null && !passportList.isEmpty()) {
				if (!passportNO.equals("")) {
					errorString = "Passport No. already Exist. \nTry Again later. ";
					isAddResume = false;
				}
				addResumeMap.put("isAddResume", isAddResume);
				addResumeMap.put("errorString", errorString);
				return addResumeMap;
			}

			if (addResumeDetails.get("othersProject") != null) {
				Resumeprojectsdetail project = new Resumeprojectsdetail();
				project.setProjectName((String) addResumeDetails
						.get("othersProject"));
				project.setDuid(resumePersonalDetails.getDuID());
				addProject(project);
				Integer projectId = project.getId();
				resumePersonalDetails.setProjectId(projectId);
			}

			getHibernateTemplate().save(resumePersonalDetails);
			if (resumeRemarks != null) {
				resumeRemarks.setResumeId(resumePersonalDetails.getId());
			}
			getHibernateTemplate().save(resumeRemarks);

			String[] resumePrimarySkill = (String[]) addResumeDetails
					.get("primarySkills");
			String[] resumeSecondrySkill = (String[]) addResumeDetails
					.get("secondrySkills");
			int i = 0;

			for (i = 0; i < resumePrimarySkill.length; i++) {
				Resumeskill objResumeSkill = new Resumeskill();
				objResumeSkill.setResumeId(resumePersonalDetails.getId());
				objResumeSkill.setSkillId(Integer
						.parseInt(resumePrimarySkill[i]));
				objResumeSkill.setSkillType("Primary");
				getHibernateTemplate().save(objResumeSkill);
			}

			if (resumeSecondrySkill != null && !resumeSecondrySkill.equals("")) {
				for (i = 0; i < resumeSecondrySkill.length; i++) {
					Resumeskill objResumeSkill = new Resumeskill();
					objResumeSkill.setResumeId(resumePersonalDetails.getId());
					objResumeSkill.setSkillId(Integer
							.parseInt(resumeSecondrySkill[i]));
					objResumeSkill.setSkillType("Secondary");
					getHibernateTemplate().save(objResumeSkill);
				}
			}

			Resumestatus resumeStatus = new Resumestatus();

			resumeStatus.setResumeId(resumePersonalDetails.getId());
			resumeStatus.setStatusId(1);
			resumeStatus.setDateOfJoin("");
			resumeStatus.setDesignation(null);
			resumeStatus.setDate(HMSUtil.getCurrentDateAndTimeObject());
			getHibernateTemplate().save(resumeStatus);

			isAddResume = true;
			addResumeMap.put("isAddResume", isAddResume);
			addResumeMap.put("errorString", errorString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return addResumeMap;
	}

	public void addProject(Resumeprojectsdetail obj) {
		Resumeprojectsdetail objResumeprojectsdetail = new Resumeprojectsdetail();
		getHibernateTemplate().save(obj);
	}

	public List<String> getProject() {
		List<String> project = null;
		try {
			project = getHibernateTemplate()
					.find("select distinct rpd.ProjectName from jkt.hrms.recruitment.masters.business.Resumeprojectsdetail as rpd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	public Map appId(Users user) throws DataServiceException {
		/*
		 * MasApplication application=null;
		 * 
		 * Map applicationMap = new HashMap(); String roleId = ""; for (Iterator
		 * roleIterator = user.getRoles().iterator(); roleIterator.hasNext();) {
		 * UserRoleMap roleMap = (UserRoleMap) roleIterator.next(); roleId =
		 * roleId.concat("'").concat(roleMap.getRoleId()).concat("',"); }
		 * if(!roleId.equals("")) { roleId =
		 * roleId.substring(0,roleId.length()-1); } List listOfApplication =
		 * null; listOfApplication = getHibernateTemplate().find("select
		 * distinct arm.AppId from
		 * jkt.hrms.recruitment.masters.business.ApplicationRoleMaster as arm
		 * where arm.RoleId in("+roleId+")");
		 * 
		 * List listOfAppName=null; listOfAppName=
		 * getAppName(listOfApplication);
		 * applicationMap.put("listOfApplication",listOfApplication);
		 * applicationMap.put("roleId",roleId);
		 */return null;
	}

	public List getAppName(List listOfApplication) {
		Iterator itrListOfApplication = listOfApplication.iterator();
		List listOfAppIDs = null;
		List listOfApplicatonMaster = null;
		List listOfAppName = new ArrayList();
		List applicationMasterList = null;

		while (itrListOfApplication.hasNext()) {
			/*
			 * ApplicationRoleMaster applicationRoleMaster =
			 * (ApplicationRoleMaster) itrListOfApplication.next(); String
			 * applicationId = applicationRoleMaster.getAppId();
			 */
			String applicationId = (String) itrListOfApplication.next();
			listOfApplicatonMaster = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.ApplicationMaster as appMaster where appMaster.AppId ='"
							+ applicationId + "'");
			if (listOfApplicatonMaster != null) {
				MasApplication applicationMasterObj;
				for (Iterator itrApplication = listOfApplicatonMaster
						.iterator(); itrApplication.hasNext(); listOfAppName
						.add(applicationMasterObj)) {
					applicationMasterObj = (MasApplication) itrApplication
							.next();
				}
			}
		}
		return listOfAppName;
	}

	public Map<String, Object> searchResume(Map searchCriteriaMap) {
		boolean parametersDefined = false;
		Session session = getSession();
		Criteria criteriaHql = session
				.createCriteria(Resumepersonaldetails.class);

		StringBuffer hql = new StringBuffer(
				"from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rp where rp.ResumeStatus.StatusId != 12 ");

		// StringBuffer hqlForAllResumes = new StringBuffer("from
		// jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rp
		// where rp.ResumeStatus.StatusId != 12");
		String showAllResume = "";
		Map<String, Object> mapSearch = new HashMap<String, Object>();
		List<Resumeskillmaster> skillList = new ArrayList<Resumeskillmaster>();
		skillList = (ArrayList<Resumeskillmaster>) getSkillMasterList();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (ArrayList<MasDepartment>) getDepartmentList();
		Query query = null;
		Query query1 = null;
		Session sess = null;
		List<Resumepersonaldetails> searchResultList = new ArrayList<Resumepersonaldetails>();

		if (searchCriteriaMap != null) {
			if (searchCriteriaMap.get("ShowAllResume") != null) {
				showAllResume = (String) searchCriteriaMap.get("ShowAllResume");
			}
		}

		if (!((String) searchCriteriaMap.get("byArchivedRecords")).equals("on")) {
			// hqlForAllResumes.append(" and rp.Active = 1 ");
			hql.append(" and rp.Active = 1 ");
			criteriaHql = criteriaHql.add(Restrictions.eq("Active", true));
		}

		if (showAllResume.equalsIgnoreCase("All")) {
			try {
				Criteria criteria = getSession().createCriteria(
						Resumepersonaldetails.class);
				criteria = criteria.createAlias("ResumeStatus", "RS");
				// criteria = criteria.createAlias("RS.ResumeStatusmaster",
				// "RSM");

				criteria = criteria.add(Restrictions.ne(
						"RS.Resumestatusmaster.Id", 12));
				criteria = criteria.add(Restrictions.ne(
						"RS.Resumestatusmaster.Id", 19));
				searchResultList = (ArrayList<Resumepersonaldetails>) criteria
						.list();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// sess.close();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		} else if (searchCriteriaMap != null) {
			String byFirstName = (String) searchCriteriaMap.get("byFirstName");
			String byLastName = (String) searchCriteriaMap.get("byLastName");
			String bySkillsString = (String) searchCriteriaMap.get("bySkills");
			Integer bySkills = null;
			if (bySkillsString != "") {
				bySkills = new Integer(bySkillsString);
			}
			String byLocation = (String) searchCriteriaMap.get("byLocation");
			String operatorInt = (String) searchCriteriaMap.get("operator");
			Integer byExperience = (Integer) searchCriteriaMap
					.get("byExperience");
			Integer byResumeId = (Integer) searchCriteriaMap.get("byResumeId");
			Integer departmentId = (Integer) searchCriteriaMap
					.get("departmentId");
			Date byFromDate = (Date) searchCriteriaMap.get("byFromDate");
			Date byToDate = (Date) searchCriteriaMap.get("byToDate");
			String byOnsiteAvailabilty = (String) searchCriteriaMap
					.get("byOnsiteAvailability");
			String byJobProfile = (String) searchCriteriaMap
					.get("byJobProfile");
			Integer byProject = (Integer) searchCriteriaMap.get("byProject");
			Integer byStatus = (Integer) searchCriteriaMap.get("byStatus");
			String byEducation = (String) searchCriteriaMap.get("byEducation");
			String byOthers = "'B.E/B.Tech','MCA','B.Sc','B.A','B.Com','M.Sc','MBA/PGDM','BL/LLB','CA','CS','Diploma','ICWA','M.A','M.Com','M.E/M.Tech','Ph. D'";

			if (byFirstName != null && byFirstName.length() > 0) {
				criteriaHql = criteriaHql.add(Restrictions.like("FirstName",
						byFirstName + "%"));
			}

			if (byLastName != null && byLastName.length() > 0) {
				criteriaHql = criteriaHql.add(Restrictions.like("LastName",
						byLastName + "%"));
			}

			if (byEducation != null && byEducation.length() > 0) {
				if (byEducation.equalsIgnoreCase("Other")) {;
					hql.append(" and rp.Education NOT IN (" + byOthers + ")");
				} else {
					criteriaHql = criteriaHql.add(Restrictions.like(
							"Education", byEducation + "%"));
				}
			}

			if (byLocation != null && byLocation.length() > 0) {
				criteriaHql = criteriaHql.add(Restrictions.like("byLocation",
						byLocation + "%"));
			}

			if (byExperience != 0 && operatorInt != null && operatorInt != "") {
				if (operatorInt.equals("=")) {
					criteriaHql = criteriaHql.add(
							Restrictions.eq("ExperienceYear", byExperience))
							.add(Restrictions.eq("ExperienceMonth", 0));
				} else if (operatorInt.equals(">")) {
					criteriaHql = criteriaHql.add(
							Restrictions.ge("ExperienceYear", byExperience))
							.add(Restrictions.ge("ExperienceMonth", 0));
				} else if (operatorInt.equals("<")) {
					criteriaHql = criteriaHql.add(Restrictions.lt(
							"ExperienceYear", byExperience));
				}

			}

			if (byResumeId != null && !byResumeId.equals(0)) {// 
				criteriaHql = criteriaHql
						.add(Restrictions.eq("Id", byResumeId));
			}

			if (departmentId != null && departmentId != 0) {
				criteriaHql = criteriaHql.createAlias("DU", "dept");
				criteriaHql = criteriaHql.add(Restrictions.eq("dept.Id",
						departmentId));
			}

			if (bySkills != null) {
				Criteria crit = session.createCriteria(Resumeskill.class);
				crit = crit.add(Restrictions.eq("SkillType", "Primary")).add(
						Restrictions.eq("SkillId", bySkills));
				List<Resumeskill> list = crit.list();
				List<Integer> resumeIdList = new ArrayList();
				for (Resumeskill resumeskill : list) {
					resumeIdList.add(resumeskill.getResumeId());
				}
				criteriaHql = criteriaHql.add(Restrictions.in("Id",
						resumeIdList));

			}

			if (byJobProfile != null && byJobProfile.length() > 0) {
				criteriaHql = criteriaHql.add(Restrictions.eq("JobProfileID",
						byJobProfile));
			}

			if (byProject != null && byProject != 0) {
				criteriaHql = criteriaHql.createAlias("Project", "project");
				criteriaHql = criteriaHql.add(Restrictions.eq("project.Id",
						byProject));
			}

			if (byFromDate != null) {
				criteriaHql = criteriaHql.add(Restrictions.ge("AddOn",
						byFromDate));
			}

			if (byToDate != null) {
				criteriaHql = criteriaHql.add(Restrictions
						.ge("AddOn", byToDate));
			}

			if (byOnsiteAvailabilty.equals("on")) {
				hql.append(" and rp.OnSiteAvailability = 1 ");
				criteriaHql = criteriaHql.add(Restrictions.eq(
						"OnSiteAvailability", true));
			}

			criteriaHql = criteriaHql.addOrder(Order.asc("FirstName"));
			criteriaHql = criteriaHql.createAlias("ResumeStatus", "RS");
			criteriaHql = criteriaHql.add(Restrictions.ne(
					"RS.Resumestatusmaster.Id", 12));
			if (byStatus != null && !byStatus.equals(-1)) {
				criteriaHql = criteriaHql.add(Restrictions.eq(
						"RS.Resumestatusmaster.Id", byStatus));
			} else {
				criteriaHql = criteriaHql.add(Restrictions.ne(
						"RS.Resumestatusmaster.Id", 19));
			}

			try {
				sess = getHibernateTemplate().getSessionFactory().openSession();
				query = sess.createQuery(hql.toString());
				if (showAllResume == null || showAllResume.equals("")) {
					searchResultList = criteriaHql.list();
					// searchResultList.removeAll(searchResultList);
				} else {
					searchResultList = criteriaHql.list();
					mapSearch.put("searchResultList", searchResultList);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					sess.close();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}
		// mapSearch.put("projectList",getMasterListWithoutStatus(MstrProject.class));
		mapSearch.put("jobProfiles", getJobProfiles());
		mapSearch.put("searchResultList", searchResultList);
		mapSearch.put("skillList", skillList);
		mapSearch.put("departmentList", departmentList);
		return mapSearch;
	}

	public List getRmsUsersList(String roleId) {
		List rmsUsersList = null;
		try {

			rmsUsersList = getHibernateTemplate()
					.find("select urm.EmpId from jkt.hrms.recruitment.masters.business.UserRoleMap as urm where urm.RoleId in("
							+ roleId + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rmsUsersList;
	}

	public List getRecruitersList() {
		List recruitersList = null;
		int mdUserId = 0;
		try {
			Criteria criteria = getSession().createCriteria(
					HrMasApplicationLevel.class);
			String recuitmentApplicationId = HMSUtil
					.getValuesFromPropertiesFile("recruitmentFile.properties",
							"MasApplication.Id");
			criteria = criteria.add(Restrictions.eq("Application.Id",
					recuitmentApplicationId));

			List applicationLevelList = criteria.list();
			HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel) applicationLevelList
					.get(0);
			MasRank intermediateApproverDesignation = applicationLevel
					.getIntermediateApproverDesignation();
			for (MasEmployee masEmployee : intermediateApproverDesignation
					.getMasEmployees()) {
				for (Users users : masEmployee.getUsers()) {
					mdUserId = users.getId();
					break;
				}
				break;
			}

			recruitersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Users as u where u.Id in( "
							+ mdUserId + ") order by u.UserName");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return recruitersList;
	}

	public Map<String, Object> getdetailsOfResume(int resumeid, String uploadUrl) {
		List resumePersonalDetails = null;
		List resumeSkill = null;
		List resumeRemarksList = null;
		List listOfUploads = null;
		List listOfEvaluationSheets = null;
		Map<String, Object> detailsOfResume = new HashMap<String, Object>();
		try {
			resumePersonalDetails = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where rpd.Id="
							+ resumeid);
			resumeSkill = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumeskill as brs where brs.ResumeId="
							+ resumeid);
			String resumeId = resumeid + "";
			resumeRemarksList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumeremarks as brs where brs.ResumeId="
							+ resumeid);
			Resumepersonaldetails resumeDetails = (Resumepersonaldetails) resumePersonalDetails
					.get(0);
			String name = resumeDetails.getFirstName();
			listOfUploads = getAllUploadedResume(name + resumeid, uploadUrl);
			listOfEvaluationSheets = getAllUploadedEvaluationSheets(name
					+ new Integer(resumeid).toString(), uploadUrl);
			detailsOfResume.put("resumePersonalDetails", resumePersonalDetails);
			detailsOfResume.put("resumeSkill", resumeSkill);
			detailsOfResume.put("skillMasterList", getSkillMasterList());
			detailsOfResume.put("listOfUploads", listOfUploads);
			detailsOfResume.put("listOfEvaluationSheets",
					listOfEvaluationSheets);
			detailsOfResume.put("resumeRemarks", resumeRemarksList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsOfResume;
	}

	public List getAllUploadedResume(String fileName, String uploadUrl) {

		List listOfUploadedResume = new ArrayList();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File myFile = new File(uploadUrl + "/rms_resume");
		if (myFile.isDirectory()) {
			String[] allFiles = myFile.list();
			for (int i = 0; i < allFiles.length; i++) {
				int strLength = fileName.length();
				allFiles[i].contains(fileName);
				if (allFiles[i].contains(fileName)) {
					listOfUploadedResume.add(allFiles[i]);
				}
			}
		} else {
		}

		return listOfUploadedResume;
	}

	public List getAllUploadedEvaluationSheets(String fileName, String uploadUrl) {

		List listOfUploadedResume = new ArrayList();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File myFile = new File(uploadUrl + "/evaluationSheets");
		if (myFile.isDirectory()) {
			String[] allFiles = myFile.list();
			for (int i = 0; i < allFiles.length; i++) {
				int strLength = fileName.length();
				allFiles[i].contains(fileName);
				if (allFiles[i].contains(fileName)) {
					listOfUploadedResume.add(allFiles[i]);
				}
			}
		} else {
		}

		return listOfUploadedResume;
	}

	public Map updateAuthorizationTo(Map<String, Object> authorizationMap) {
		Map<String, Object> updateAuthorizationMap = new HashMap<String, Object>();
		List tempList = (List) authorizationMap.get("tempList");
		int assignedTo = (Integer) authorizationMap.get("assignedTo");
		Integer requestId = (Integer) authorizationMap.get("requestId");
		for (Iterator<Object> iter = tempList.iterator(); iter.hasNext();) {
			Resumepersonaldetails rpd = (Resumepersonaldetails) iter.next();
			int id = rpd.getId();
			Resumepersonaldetails rp = (Resumepersonaldetails) getHibernateTemplate()
					.load(Resumepersonaldetails.class, id);
			rp.setAssignedTo(assignedTo);
			if (rp.getResumeStatus().getStatusId().equals(1)) {
				rp.getResumeStatus().setStatusId(2);
			}
			if (requestId != null) {
				rp.setResourceRequisitionId(requestId);
			}
			getHibernateTemplate().saveOrUpdate(rp);
			getHibernateTemplate().saveOrUpdate(rp.getResumeStatus());

			if (rp.getResumeStatus().getStatusId().equals(1)) {
				Resumestatushistory statusHistory = new Resumestatushistory();
				statusHistory.setResumeId(rp.getId());
				statusHistory.setStatusId(2);
				statusHistory.setDate(new Date());
				getHibernateTemplate().save(statusHistory);
			}
		}

		getSession().flush();

		List list = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where rpd.AssignedTo="
						+ assignedTo + " ");
		Resumepersonaldetails rp = (Resumepersonaldetails) list.get(0);
		String name = "";
		String emailId = "";
		if (rp.getAssignedResumeTo() != null) {
			name = rp.getAssignedResumeTo().getUserName();
			emailId = rp.getAssignedResumeTo().getEmailAddress();
		}
		updateAuthorizationMap.put("name", name);
		updateAuthorizationMap.put("emailId", emailId);
		return updateAuthorizationMap;
	}

	public List getTechnicalDetails(int resumeId) {
		List technicalDetailsList = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumetechnical as rt where rt.ResumeId="
						+ resumeId);
		return technicalDetailsList;
	}

	public List getCurrentStatus(int resumeId) {

		List resumeStatus = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumestatus as rsf where rsf.ResumeId="
						+ resumeId);

		return resumeStatus;
	}

	public boolean addTechDetails(Resumetechnical resumeTechnical,
			Resumetechnicalhistory resumeTechnicalHistory) {
		boolean addTechDetails = false;
		int idStatus = resumeTechnical.getResumeId();
		try {
			int id = 0;
			int resumeId = resumeTechnical.getResumeId();
			List resume = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumetechnical as rtd where rtd.ResumeId="
							+ resumeTechnical.getResumeId());
			/*
			 * if (!resume.isEmpty()) { Resumetechnical resumeTech =
			 * (Resumetechnical) resume.get(0); id = resumeTech.getId();
			 * resumeTechnical.setId(id); }
			 */
			getHibernateTemplate().saveOrUpdate(resumeTechnical);
			getHibernateTemplate().flush();
			getHibernateTemplate().refresh(resumeTechnical);

			getHibernateTemplate().save(resumeTechnicalHistory);
			addTechDetails = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (addTechDetails) {
			Resumepersonaldetails rpd = (Resumepersonaldetails) getHibernateTemplate()
					.load(Resumepersonaldetails.class, idStatus);
			int statusId = 3;
			if (resumeTechnical.getStatus().contains("Selected")) {
				statusId = 6;
			} else if (resumeTechnical.getStatus().contains("Rejected")) {
				statusId = 5;
			} else {
				statusId = 4;
			}
			rpd.getResumeStatus().setStatusId(statusId);
			rpd.getResumeStatus().setDate(new Date());
			getHibernateTemplate().saveOrUpdate(rpd);
			getHibernateTemplate().saveOrUpdate(rpd.getResumeStatus());

			Resumestatushistory statusHistory = new Resumestatushistory();
			statusHistory.setResumeId(rpd.getId());
			statusHistory.setStatusId(statusId);
			statusHistory.setDate(new Date());

			getHibernateTemplate().save(statusHistory);
		}
		return addTechDetails;
	}

	public List getHrDetails(int resumeId) {
		List hrDetails = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumehrdetails as rhrd where rhrd.ResumeId="
						+ resumeId);
		return hrDetails;
	}

	public boolean addHRDetails(Resumehrdetails resumeHrDetails,
			Resumehrdetailshistory resumeHrDetailsHistory) {
		boolean addHRDetails = false;
		int idStatus = resumeHrDetails.getResumeId();

		try {
			/*
			 * int id = 0; List resume = getHibernateTemplate().find("from
			 * jkt.hrms.recruitment.masters.business.Resumehrdetails as rhd
			 * where rhd.ResumeId="+ resumeHrDetails.getResumeId()); if
			 * (!resume.isEmpty()) { Resumehrdetails resumeHr =
			 * (Resumehrdetails) resume.get(0); id = resumeHr.getId();
			 * resumeHrDetails.setId(id); }
			 */
			/*
			 * getSession().flush(); getSession().evict(resumeHrDetails);
			 */
			getHibernateTemplate().saveOrUpdate(resumeHrDetails);
			getHibernateTemplate().save(resumeHrDetailsHistory);
			Resumestatus resumeStatus = (Resumestatus) getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumestatus as rms where rms.ResumeId="
							+ resumeHrDetails.getResumeId()).get(0);

			Resumestatushistory resumeStatusHistory = new Resumestatushistory();
			resumeStatus.setResumeId(resumeHrDetails.getResumeId());
			resumeStatus.setDate(resumeHrDetails.getDate());
			resumeStatusHistory.setResumeId(resumeHrDetails.getResumeId());
			resumeStatusHistory.setDate(resumeHrDetails.getDate());
			if (resumeHrDetails.getRecommended().equalsIgnoreCase("Selected")) {
				resumeStatus.setStatusId(10);
			} else if (resumeHrDetails.getRecommended().equalsIgnoreCase(
					"Rejected")) {
				resumeStatus.setStatusId(8);
			} else {
				resumeStatus.setStatusId(9);
			}
			getHibernateTemplate().saveOrUpdate(resumeStatus);
			resumeStatusHistory.setStatusId(resumeStatus.getStatusId());
			getHibernateTemplate().save(resumeStatusHistory);
			addHRDetails = true;
		} catch (Exception e) {
			addHRDetails = false;
			e.printStackTrace();
		}
		if (addHRDetails) {
			Resumepersonaldetails rpd = (Resumepersonaldetails) getHibernateTemplate()
					.load(Resumepersonaldetails.class, idStatus);
			getHibernateTemplate().saveOrUpdate(rpd);
		}
		// getHibernateTemplate().setFlushMode();
		return addHRDetails;
	}

	public List getDesignationMasterList() {
		List designationMasterList = null;
		try {
			designationMasterList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRank");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return designationMasterList;
	}

	public List getLocationMasterList() {
		List locationMasterList = null;
		try {
			locationMasterList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDistrict");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return locationMasterList;
	}

	public List getMasterList(String className) {
		List masterList = new ArrayList();
		String hql = "from jkt.hms.masters.business." + className;
		try {
			masterList = getHibernateTemplate().find(hql);

		} catch (Exception e) {

		}
		return masterList;

	}

	public List getMasterList(Class klass) {
		List masterList = new ArrayList();

		// String hql = packag + "." + className;
		Criteria criteria = getSession().createCriteria(klass);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		try {
			masterList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterList;

	}

	public List getMasterListWithoutStatus(Class klass) {
		List masterList = new ArrayList();

		// String hql = packag + "." + className;
		Criteria criteria = getSession().createCriteria(klass);
		// criteria = criteria.add(Restrictions.eq("Status", "y"));
		try {
			masterList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return masterList;

	}

	public int getStatusId(String statusDesc) {
		int statusId;
		List statusMaster = null;
		try {
			statusMaster = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumestatusmaster as rsm where rsm.StatusDesc='"
							+ statusDesc + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Resumestatusmaster resumeStatusMaster = (Resumestatusmaster) statusMaster
				.get(0);
		statusId = resumeStatusMaster.getId();
		return statusId;
	}

	public boolean addResumeStatus(Resumestatus resumeStatus,
			Resumestatushistory resumeStatusHistory) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		boolean addResumeStatus = false;
		// int idStatus = resumeStatus.getResumeId();
		try {
			int id = 0;
			int resumeId = resumeStatus.getResumeId();
			int statusId = resumeStatus.getStatusId();
			/*
			 * List resume = getHibernateTemplate().find("from
			 * jkt.hrms.recruitment.masters.business.Resumestatus as rsf where
			 * rsf.ResumeId="+ resumeStatus.getResumeId());
			 * 
			 * if (!resume.isEmpty()) { Resumestatus resumeFinal =
			 * (Resumestatus) resume.get(0); if(statusId!=11) { resumeStatus =
			 * resumeFinal; resumeStatus.setStatusId(statusId); } id =
			 * resumeFinal.getId(); }
			 */
			// resumeStatus.setId(id);
			// getHibernateTemplate().refresh(resumeStatus);
			getHibernateTemplate().update(resumeStatus);
			getHibernateTemplate().flush();
			getHibernateTemplate().refresh(resumeStatus);
			getHibernateTemplate().save(resumeStatusHistory);
			// getHibernateTemplate().refresh(resumeStatus);
			// getHibernateTemplate().refresh(resumeStatusHistory);
			/*
			 * getHibernateTemplate().refresh(resumeStatus);
			 * getHibernateTemplate().refresh(resumeStatusHistory);
			 */
			addResumeStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * if(addResumeStatus){ Resumepersonaldetails rpd =
		 * (Resumepersonaldetails
		 * )getHibernateTemplate().load(Resumepersonaldetails.class,idStatus);
		 * //if(rpd.getFinalStatus().equals("2")){ rpd.setFinalStatus(3); //}
		 * getHibernateTemplate().saveOrUpdate(rpd); }
		 */
		return addResumeStatus;
	}

	public Map<String, Object> editResume(Map<String, Object> editResumeDetails) {
		Map<String, Object> editResumeMap = new HashMap<String, Object>();
		isEditResume = false;

		try {

			Resumepersonaldetails resumePersonalDetails = (Resumepersonaldetails) editResumeDetails
					.get("personalDetails");
			// Resumevisadetails resumevisadetails1 =
			// (Resumevisadetails)editResumeDetails.get("resumevisadetails");
			String passportNO = resumePersonalDetails.getPassportNo();
			int resumeID = resumePersonalDetails.getId();
			List list = null;
			Resumepersonaldetails rpd = (Resumepersonaldetails) getHibernateTemplate()
					.load(Resumepersonaldetails.class, new Integer(resumeID));
			if (!passportNO.equals("")) {
				list = getHibernateTemplate()
						.find("from jkt.hrms.recruitment.masters.business.Resumepersonaldetails as rpd where rpd.PassportNo='"
								+ passportNO + "' and rpd.Id !=" + resumeID);
			}

			if (list != null && !list.isEmpty()) {
				editResumeMap.put("isEditResume", isEditResume);

				if (!passportNO.equals("")) {
					errorString = "Passport No. already Exist.So your Resume Details cannot be updated.\nTry Again later.";
				}

				editResumeMap.put("errorString", errorString);

				return editResumeMap;
			}

			resumePersonalDetails.setResumeRemarks(rpd.getResumeRemarks());
			resumePersonalDetails.setResumeSkill(rpd.getResumeSkill());

			resumePersonalDetails.setAddOn(rpd.getAddOn());
			Resumeremarks resumeRemarks = (Resumeremarks) editResumeDetails
					.get("resumeRemarks");

			if (resumeRemarks != null) {
				resumePersonalDetails.getResumeRemarks().add(resumeRemarks);
			}

			int resumeid = resumePersonalDetails.getId();
			Set<Resumeskill> resumeskill = resumePersonalDetails
					.getResumeSkill();
			// Resumeremarks resumeRemarks = new Resumeremarks();
			// if(resumeRemarks!=null){
			// resumeRemarks.setResumeId(resumeid);
			// getHibernateTemplate().save(resumeRemarks);
			// }

			String[] resumePrimarySkill = (String[]) editResumeDetails
					.get("primarySkills");
			String[] resumeSecondrySkill = (String[]) editResumeDetails
					.get("secondrySkills");
			int i = 0;

			// getHibernateTemplate().delete("from
			// jkt.hrms.recruitment.masters.business.Resumeskill as resumeSkill
			// where resumeSkill.ResumeId="+ resumeid);
			getHibernateTemplate().deleteAll(resumeskill);

			Set<Resumeskill> resumeSkill = new HashSet<Resumeskill>();
			resumePersonalDetails.setResumeSkill(resumeSkill);

			for (i = 0; i < resumePrimarySkill.length; i++) {
				Resumeskill objResumeSkill = new Resumeskill();
				objResumeSkill.setResumeId(resumePersonalDetails.getId());
				objResumeSkill.setSkillId(Integer
						.parseInt(resumePrimarySkill[i]));
				objResumeSkill.setSkillType("Primary");
				if (objResumeSkill != null) {
					resumePersonalDetails.getResumeSkill().add(objResumeSkill);
				}
			}

			if (resumeSecondrySkill != null && !resumeSecondrySkill.equals("")) {
				for (i = 0; i < resumeSecondrySkill.length; i++) {
					Resumeskill objResumeSkill = new Resumeskill();
					objResumeSkill.setResumeId(resumePersonalDetails.getId());
					objResumeSkill.setSkillId(Integer
							.parseInt(resumeSecondrySkill[i]));
					objResumeSkill.setSkillType("Secondary");
					if (objResumeSkill != null) {
						resumePersonalDetails.getResumeSkill().add(
								objResumeSkill);
					}
				}
			}

			if (editResumeDetails.get("othersProject") != null) {
				Resumeprojectsdetail project = new Resumeprojectsdetail();
				project.setProjectName((String) editResumeDetails
						.get("othersProject"));
				project.setDuid(resumePersonalDetails.getDuID());
				addProject(project);
				Integer projectId = project.getId();
				resumePersonalDetails.setProjectId(projectId);
			}

			getHibernateTemplate().saveOrUpdate(resumePersonalDetails);
			String resumeId = resumeid + "";

			// getHibernateTemplate().delete("from
			// com.jkt.intranet.business.Resumevisadetails as resumevisadetails
			// where resumevisadetails.ResumeId='"+ resumeId + "'");

			isEditResume = true;
			editResumeMap.put("isEditResume", isEditResume);
			editResumeMap.put("errorString", errorString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return editResumeMap;
	}

	public List getResumePersonalDetailsById(Integer id) {
		Session session = getSession();
		Criterion cri = Restrictions.eq("Id", id);
		Criteria criteria = session.createCriteria(Resumepersonaldetails.class)
				.add(cri);
		List resumeList = criteria.list();
		return resumeList;
	}

	public List getHRHistory(int resumeId) {
		List hrDetails = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumehrdetailshistory as rhrd where rhrd.ResumeId="
						+ resumeId);
		return hrDetails;
	}

	public List getStatusHistory(int resumeId) {
		List resumeStatus = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumestatushistory as rsf where rsf.ResumeId="
						+ resumeId);
		return resumeStatus;
	}

	public List getTechnicalHistory(int resumeId) {
		List technicalDetailsList = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.Resumetechnicalhistory as rt where rt.ResumeId="
						+ resumeId);
		return technicalDetailsList;
	}

	public List getStateList(String countryId) {
		Integer countryIdInt = new Integer(countryId);
		List stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState state where state.Country.Id ="
						+ countryIdInt);
		return stateList;
	}

	public List getDistrictList(String stateId) {
		Integer stateIdInt = new Integer(stateId);
		List stateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict dis where dis.State.Id ="
						+ stateIdInt);
		return stateList;
	}

	public List getJoinedCandidates() {
		Session session = getSession();
		List joinedCandidates = new ArrayList();
		Criteria crit = session.createCriteria(Resumepersonaldetails.class);
		crit = crit.createAlias("ResumeStatus", "RS");
		crit = crit.add(Restrictions.eq("RS.StatusId", 18));
		joinedCandidates = crit.list();
		// joinedCandidates = getHibernateTemplate().find("from
		// jkt.hrms.recruitment.masters.business.Resumepersonaldetails rpd where
		// rpd.ResumeStatus.StatusId =13");
		return joinedCandidates;
	}

	public List getCountryList() {
		List countryLIst = null;
		/*
		 * Criteria crit = session.createCriteria(Resumepersonaldetails.class);
		 * crit = crit.add(Restrictions.eq("ResumeStatus.StatusId",13));
		 * joinedCandidates = crit.list();
		 */
		countryLIst = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry rpd where rpd.Status ='y'");
		return countryLIst;
	}

	public Object getBinaryFile() {
		org.hibernate.Criteria c = getSession().createCriteria(Uploads.class);
		c = c.add(Restrictions.eq("Filename", "sdad7_20090120_125853.doc"));
		List list = c.list();
		return list.get(0);
	}

	public List getHrSelectedResumeList() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Resumepersonaldetails.class)
				.createAlias("ResumeStatus", "RS");
		LogicalExpression exp = Restrictions.or(
				Restrictions.eq("RS.StatusId", 20),
				Restrictions.eq("RS.StatusId", 13));
		criteria = criteria.add(exp);

		List list = criteria.list();
		return list;
	}

	public void updateResumeStatus(Resumestatus resumeListToBeUpdated) {
		getHibernateTemplate().update(resumeListToBeUpdated);
		getHibernateTemplate().flush();
		getHibernateTemplate().refresh(resumeListToBeUpdated);

	}

	public Map getAddressMap() {
		Session session = getSession();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();

		Criteria criteria = session.createCriteria(MasCountry.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));

		countryList = criteria.list();

		criteria = session.createCriteria(MasState.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		stateList = criteria.list();

		criteria = session.createCriteria(MasDistrict.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		districtList = criteria.list();

		Map map = new HashMap();
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		return map;
	}

	public Resumetechnical getResumeTechnical(Integer resumeTechnicalId) {
		Criteria criteria = getSession().createCriteria(Resumetechnical.class);
		criteria = criteria.add(Restrictions.eq("Id", resumeTechnicalId));
		List list = criteria.list();
		Resumetechnical resumetechnical = (Resumetechnical) list.get(0);
		return resumetechnical;
	}

	public Resumehrdetails getResumeHr(Integer resumeHrId) {
		Criteria criteria = getSession().createCriteria(Resumehrdetails.class);
		criteria = criteria.add(Restrictions.eq("Id", resumeHrId));
		List list = criteria.list();
		Resumehrdetails resumehrdetails = (Resumehrdetails) list.get(0);
		return resumehrdetails;
	}

	public List<Resumepersonaldetails> getUploadedResumes() {
		Criteria criteria = getSession().createCriteria(
				Resumepersonaldetails.class);
		criteria = criteria.createAlias("ResumeStatus", "RS");
		criteria = criteria.add(Restrictions.eq("RS.StatusId", 1));
		List<Resumepersonaldetails> uploadedResumeList = criteria.list();
		return uploadedResumeList;
	}

	public List<MasQualification> getQualificationMasterList() {
		Criteria criteria = getSession().createCriteria(MasQualification.class);
		// criteria = criteria.add(Restrictions.eq("Status","y"));
		List<MasQualification> qualificationList = criteria.list();
		return qualificationList;
	}

	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		return departmentList;
	}

	public Map<String, Object> showResumePayElementsJsp(
			Resumepersonaldetails resume) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
		List<HrResumePayElements> searchResumePayElementsList = new ArrayList<HrResumePayElements>();

		payElementsList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasPayElement as pe where pe.Status ='y' ");
		searchResumePayElementsList = getHibernateTemplate()
				.find("from jkt.hrms.recruitment.masters.business.HrResumePayElements pd where pd.Status='y' and pd.Resume.Id= "
						+ resume.getId());

		map.put("payElementsList", payElementsList);
		map.put("searchResumePayElementsList", searchResumePayElementsList);
		return map;
	}

	public Map addResumePayELementsList(
			List<HrResumePayElements> resumePayELementsList) {

		HrResumePayElements resumePayElement = resumePayELementsList.get(0);
		Resumepersonaldetails resume = resumePayElement.getResume();

		Query query = getSession().createQuery(
				"delete from HrResumePayElements where resume_id = "
						+ resume.getId());
		query.executeUpdate();

		getHibernateTemplate().saveOrUpdateAll(resumePayELementsList);
		for (HrResumePayElements resumePayElements : resumePayELementsList) {
			getHibernateTemplate().refresh(resumePayElements);
		}
		Map map = null;
		return map;
	}

	public Object loadObject(Class klass, Integer id) {
		return getHibernateTemplate().load(klass, id);
	}

	public void addOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		getHibernateTemplate().flush();
		getHibernateTemplate().refresh(entity);
	}

	@Override
	public Map<String, Object> getEmployeeForPromo(String id) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		  List<MasEmployee> promoEmpList = new ArrayList<MasEmployee>();
		  List desigList = new ArrayList();
		  
		/*  Criteria criteria = getSession().createCriteria(ResourceRequisition.class).add(Restrictions.eq("Id", Integer.parseInt(id)));
		  List<ResourceRequisition> resorceReqList = criteria.list();
		  int designation_order =resorceReqList.get(0).getDesignation().getDesignationOrder();*/
		  
		  int designation_order =Integer.parseInt(id);
		  
		 // System.out.println(">designation_order>>>>"+designation_order);
		  LogicalExpression exp =  Restrictions.or(Restrictions.eq("DesignationOrder", (designation_order-1)), Restrictions.eq("DesignationOrder", (designation_order-2)));
		  List al = new ArrayList();
		  
		  al.add((designation_order+1)); 
		 // al.add((designation_order+2)); 
		 // al.add((designation_order+3));

		  desigList = getSession().createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).add(Restrictions.in("DesignationOrder",al))
				  					.setProjection(Projections.projectionList().add(Projections.groupProperty("Id"))).list();
		//  System.out.println(""+desigList.size());
		  if(desigList.size()>0){
		  promoEmpList = getSession().createCriteria(MasEmployee.class).add(Restrictions.in("Rank.Id", desigList)).list();
		  }
		  System.out.println(desigList.size()+">promoEmpList>>>>"+promoEmpList.size());
				
		 
		 // return promoEmpList;
		  map1.put("designation_order", designation_order);
		  map1.put("promoEmpList", promoEmpList);
		  return  map1;
	}
	
	@Override
	public Map<String, Object> saveResourceRequisitionDetail(Map detailMap){
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean successfullyAdded=false;
		List departList = new ArrayList();
		List desigList = new ArrayList();
		List noOfpositionList = new ArrayList();
		List directReqList = new ArrayList();
		List promReqList = new ArrayList();
		List approveList = new ArrayList();
		List availList = new ArrayList();
		List promList = new ArrayList();
		List directList = new ArrayList();
		
		Users user =(Users) detailMap.get("user");
		departList=(List)detailMap.get("departList");
		desigList=(List)detailMap.get("desigList");
		noOfpositionList=(List)detailMap.get("noOfpositionList");
		directReqList=(List)detailMap.get("directReqList");
		promReqList=(List)detailMap.get("promReqList");
		approveList=(List)detailMap.get("approveList");
		availList=(List)detailMap.get("availList");
		promList=(List)detailMap.get("promList");
		directList=(List)detailMap.get("directList");
		String lastchangeBy= ""+detailMap.get("lastchangeBy");
		String changedDate =""+detailMap.get("changedDate");
		String changedTime=""+detailMap.get("changedTime");
		String hospitalId = ""+detailMap.get("hospitalId");
		int val = Integer.parseInt(""+detailMap.get("val"));
		int empId = Integer.parseInt(""+detailMap.get("empId"));
		
		try{	
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for(int i=0;i<val;i++){
			//System.out.println(departList.size()+">>>>"+i);
			ResourceRequisition resourceRequisition = new ResourceRequisition();
			
			MasEmployeeDepartment md = new MasEmployeeDepartment();
			md.setId(Integer.parseInt(""+departList.get(i)));
			resourceRequisition.setDepartment(md);
			
			MasRank mr = new MasRank();
			mr.setId(Integer.parseInt(""+desigList.get(i)));
			//resourceRequisition.setDesignation(mr);
			resourceRequisition.setDesignation(mr);
			
			MasHospital mh = new MasHospital();
			mh.setId(Integer.parseInt(hospitalId));
			resourceRequisition.setCompany(mh);
			
			MasEmployee me = new MasEmployee();
			me.setId(empId);
			resourceRequisition.setInitiator(me);
			resourceRequisition.setReqAddBy(me);
			resourceRequisition.setTotalNoPosition(Integer.parseInt(""+noOfpositionList.get(i)));
			/*if(directReqList.size() >i && directReqList.size()>0){*/
				
			//resourceRequisition.setDirectReq(Integer.parseInt(""+directReqList.get(i)));
			/*}*/
			
			//resourceRequisition.setPromotionReq(Integer.parseInt(""+promReqList.get(i)));
			
			//resourceRequisition.setPostApproved(Integer.parseInt(""+approveList.get(i)));
			resourceRequisition.setPostAvail(Integer.parseInt(""+availList.get(i)));
		//	resourceRequisition.setPromotion(Integer.parseInt(""+promList.get(i)));
			//resourceRequisition.setDirect(Integer.parseInt(""+directList.get(i)));
			
	
			resourceRequisition.setStatus("a"); // a for Approved
			resourceRequisition.setNoOfPositionOccupied(0);
			resourceRequisition.setLastChgBy(lastchangeBy);
			//resourceRequisition.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date()))
			resourceRequisition.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
			resourceRequisition.setRequisitionDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
			resourceRequisition.setLastChgTime(changedTime);
			
			//System.out.println("resourceRequisition"+resourceRequisition);
			
		if(resourceRequisition != null) {
			hbt.saveOrUpdate(resourceRequisition);
			hbt.flush();
			hbt.refresh(resourceRequisition);
			}
		
		/*HrResourceRequisitionStatus hrResourceRequisitionStatus = new HrResourceRequisitionStatus();
		
		RequestStatusMaster requestStatusMaster = new RequestStatusMaster();
		
		
		hrResourceRequisitionStatus.setCurrentLevel(0);
		requestStatusMaster.setId(1);
		
		hrResourceRequisitionStatus.setMasEmployee(user.getEmployee());
		
		hrResourceRequisitionStatus.setRequestStatusMaster(requestStatusMaster);
		
		hrResourceRequisitionStatus.setResourceRequisition(resourceRequisition);
		hrResourceRequisitionStatus.setActionDate(HMSUtil.getCurrentDateAndTimeObject());
	
		
		hbt.saveOrUpdate(hrResourceRequisitionStatus);
		hbt.flush();
		hbt.refresh(hrResourceRequisitionStatus);
		
		
		HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
		requisitionHistory.setRequisition(resourceRequisition);
		requisitionHistory.setEmployee(user.getEmployee());
		
		
		requisitionHistory.setStatus(requestStatusMaster);
		
		requisitionHistory.setActionDate(HMSUtil.getCurrentDateAndTimeObject());
		requisitionHistory.setTotalNoPosition(Integer.parseInt(""+noOfpositionList.get(i)));
		
		hbt.saveOrUpdate(requisitionHistory);
		hbt.flush();
		hbt.refresh(requisitionHistory);
		successfullyAdded = true;	*/	
		
		map.put("resourceRequisition", resourceRequisition);
		
		}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		String message = "";
		if (successfullyAdded) {
			message = "Record saved sucessfully";
		}else {
			message = "Some Problem Occured!";
			 
		}
		map.put("flag", successfullyAdded);
		map.put("message", message);
		
		return map;
	}
	
	@Override
	public Map<String, Object> saveEmpPromo(Map<String, Object> authorizationMap) {
		Map<String, Object> updateAuthorizationMap = new HashMap<String, Object>();		
		List tempList = (List)authorizationMap.get("tempList");
		/*int assignedTo = (Integer)authorizationMap.get("assignedTo");*/
		Integer requestId  = (Integer)authorizationMap.get("requestId");
		List rankList = (List)authorizationMap.get("rankList");
		int userId = Integer.parseInt(""+authorizationMap.get("userId"));
		
		ResourceRequisition resourceRequisition1 =(ResourceRequisition)authorizationMap.get("resourceRequisition");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (int i=0;i<tempList.size() ; i++) {
			int emp_id = Integer.parseInt(""+tempList.get(i));
			int rank_id =  Integer.parseInt(""+rankList.get(i));
				
				
				//  Data insert into hr_requisition_fr_promotion table
			
				HrRequisitionFrPromotion hrfp = new HrRequisitionFrPromotion();
				
				MasEmployee me1 = new MasEmployee();
				me1.setId(emp_id);
				hrfp.setEmployee(me1);
				
				/*ResourceRequisition rr = new ResourceRequisition();
				rr.setId(requestId);
				hrfp.setRequisition(rr);*/
				System.out.println("resourceRequisition1==="+resourceRequisition1);
				hrfp.setRequisition(resourceRequisition1);
				
				MasRank mr = new MasRank();
				mr.setId(rank_id);
				hrfp.setRank(mr);
				
				Users user = new Users();
				user.setId(userId);
				hrfp.setLastChgBy(user);
				
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String time = (String)utilMap.get("currentTime");
				hrfp.setLastChgTime(time);
				
				hrfp.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				
				hrfp.setStatus("s" );  // for promoted
				
				hbt.saveOrUpdate(hrfp)	;
				hbt.refresh(hrfp);
				
			// end .. Data insert into hr_requisition_fr_promotion table
				
				
				// Data insert into   hr_req_prom_history table
				
			
				HrReqPromHistory hrpHistory = new HrReqPromHistory();
		
				hrpHistory.setPromReq(hrfp);
				hrpHistory.setRequisition(resourceRequisition1);
				
				Resumestatusmaster rsm = new Resumestatusmaster();
				rsm.setId(2);
				hrpHistory.setPromStatus(rsm);
				
				hrpHistory.setEmp(me1);
				hrpHistory.setLastChgBy(user);			
				hrpHistory.setLastChgTime(time);			
				hrpHistory.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				hbt.save(hrpHistory);
				hbt.refresh(hrpHistory);
				
				
				// end ..... Data insert into   hr_req_prom_history table
				
				
				// Data insert into   hr_req_prom_status table
				
				
			
				HrReqPromStatus hrpStatus = new HrReqPromStatus();
				hrpStatus.setPromReq(hrfp);
				hrpStatus.setRank(mr);
				hrpStatus.setPromStatus(rsm);
				hrpStatus.setLastChgBy(user);			
				hrpStatus.setLastChgTime(time);			
				hrpStatus.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				hbt.save(hrpStatus);
				hbt.refresh(hrpStatus);
				
				
				// end.....Data insert into   hr_req_prom_status table
				
				
				// save data in employee history and Update Employee  table
				
	
				 Calendar cal = Calendar.getInstance();
				 cal.add(Calendar.DATE,-1);
				 String oneDayBeforeOfpromo_date=(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.DATE) )+"/"+cal.get(Calendar.YEAR);
				
				MasEmployee masEmployee1 =(MasEmployee) hbt.load(MasEmployee.class, emp_id);
				
				//System.out.println(masEmployee1.getRank().getId()+"   "+resourceRequisition1.getDesignation().getId());
				
				MasEmployeeHistory masEmployeeHistory = new MasEmployeeHistory();
				MasEmployee me2 = new MasEmployee();
				me2.setId(emp_id);
				masEmployeeHistory.setEmployee(me2);
				masEmployeeHistory.setRank(masEmployee1.getRank());
				masEmployeeHistory.setDepartment(masEmployee1.getDepartment());
				//masEmployeeHistory.setDesignationFromDate(masEmployee.get);
				System.out.println("---"+new Date(oneDayBeforeOfpromo_date));
				masEmployeeHistory.setDesignationToDate((new Date(oneDayBeforeOfpromo_date)));
				hbt.save(masEmployeeHistory);
				hbt.flush();
				hbt.refresh(masEmployeeHistory);
				
	
				//MasEmployee masEmployee =(MasEmployee) hbt5.load(MasEmployee.class, employee_id);
				masEmployee1.setRank(resourceRequisition1.getDesignation());
				masEmployee1.setEmployeeDepartment(resourceRequisition1.getDepartment());
				hbt.saveOrUpdate(masEmployee1);		
				hbt.flush();
				hbt.refresh(masEmployee1);
				
				// End -- save data in employee history table
				
		}
		
		getSession().flush();
		
		return updateAuthorizationMap;
		
	}
	
	@Override
	public Map<String, Object> getEmployeeForHrApprovePromo(Map<String, Object>  detailMap) {
		Session session = getSession();
		Map map2= new HashMap();
		List<HrReqPromStatus> shortListedEmpForHr = new ArrayList<HrReqPromStatus>();
		List<RequestStatusMaster> requestStatusMasterList = new ArrayList<RequestStatusMaster>();
		List<MasEmployeeDepartment> masDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrRequisitionFrPromotion> masEmployeeRequisionList = new ArrayList<HrRequisitionFrPromotion>();
		
		Date fromDate = null;
		Date toDate=null;
		Integer promoId = 0;
		Integer deptId =0;
		Integer empId =0;
		String flag="";
			
		if(detailMap.get("fromDate") != null){
			fromDate = (Date)detailMap.get("fromDate");
		}
		if(detailMap.get("toDate") != null){
			toDate = (Date)detailMap.get("toDate");
		}
		if(detailMap.get("promoId") != null){
			promoId = (Integer)detailMap.get("promoId");
		}
		if(detailMap.get("deptId") != null){
			deptId = (Integer)detailMap.get("deptId");
		}
		System.out.println("deptId=="+deptId);
		if(detailMap.get("empId") != null){
			empId = (Integer)detailMap.get("empId");
		}
		if(detailMap.get("flag") != null){
			flag = ""+detailMap.get("flag");
		}
		
		Criteria crit= null;
		if(flag != null && !flag.equals("")){ 
		if(flag.equalsIgnoreCase("H")){
		/*shortListedEmpForHr*/  crit= session.createCriteria(HrReqPromStatus.class).add(Restrictions.eq("PromStatus.Id", 2)); // for HR Approval
				crit =crit.createAlias("PromReq", "PromReq").createAlias("PromReq.Employee", "emp");
			
		}
		else if(flag.equalsIgnoreCase("M")){
			 crit= session.createCriteria(HrReqPromStatus.class).add(Restrictions.eq("PromStatus.Id", 10)); // for MD Approval
			 crit =crit.createAlias("PromReq", "PromReq").createAlias("PromReq.Employee", "emp");
		}
		
		if(promoId != null && promoId != 0){
			crit = crit.add(Restrictions.eq("Id", promoId));
		}
		if(deptId != null && deptId != 0){
			crit = crit/*.createAlias("PromReq", "PromReq1").createAlias("PromReq1.Employee", "emp1")*/.createAlias("emp.EmployeeDepartment", "depart").
					add(Restrictions.eq("depart.Id", deptId));
		}
		if(empId != null && empId != 0){
			
			crit =crit/*.createAlias("PromReq", "PromReq").createAlias("PromReq.Employee", "emp")*/.add(Restrictions.eq("emp.Id", empId));
		}
		
		if(fromDate != null && toDate!=null  ){
			crit = crit.add(Restrictions.between("LastChgDate", fromDate,toDate));
		}
		
			shortListedEmpForHr = crit.list();
		
		}
		requestStatusMasterList = session.createCriteria(RequestStatusMaster.class).add(Restrictions.ne("Id",1))
							.add(Restrictions.ne("Id",3)).add(Restrictions.ne("Id",5)).add(Restrictions.ne("Id",7)).list();
		
		masDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("EmployeeName").ignoreCase()).list();
		masEmployeeRequisionList = session.createCriteria(HrRequisitionFrPromotion.class).add(Restrictions.eq("Status", "s").ignoreCase()).list();
		
		System.out.println("flagflag in java>>"+flag);
		
		map2.put("shortListedEmpForHr", shortListedEmpForHr);
		map2.put("masEmployeeList", masEmployeeList);
		map2.put("requestStatusMasterList", requestStatusMasterList);
		map2.put("masDepartmentList", masDepartmentList);
		map2.put("masEmployeeRequisionList", masEmployeeRequisionList);
		return map2;
	}



	@Override
	public Map<String,Object> updateEmpPromoStatus(Map<String, Object> detailMap) {
	
		
		Map<String, Object> updateMap = new HashMap<String, Object>();		
		List tempList = (List)detailMap.get("tempList");
		List reqList = (List)detailMap.get("reqList");
		String remarks = ""+detailMap.get("remraks");
		String requestStatus = ""+detailMap.get("requestStatus");
		int userId = Integer.parseInt(""+detailMap.get("userId"));
		String flag = ""+detailMap.get("flag");
		List reqfrPromotionIdList = new ArrayList();
		if(detailMap.get("reqfrPromotionIdList") != null){
			reqfrPromotionIdList = (List)detailMap.get("reqfrPromotionIdList");	
		}
		System.out.println("reqfrPromotionIdList=ds===="+reqfrPromotionIdList.size());
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		Session session = getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean update= false;
		Transaction tx = null;
		try{
		for (int i=0;i<tempList.size() ; i++) {
			int promoId = Integer.parseInt(""+tempList.get(i));
			
				
					tx = session.beginTransaction();
				
				
				// Data updated into   hr_req_prom_status table
				
				HrReqPromStatus hrpStatus =(HrReqPromStatus) session.load(HrReqPromStatus.class, promoId);
				
				if(flag.equalsIgnoreCase("H")){
				if(requestStatus.equalsIgnoreCase("Approved")){
					Resumestatusmaster rsm = new Resumestatusmaster();
					rsm.setId(10); // for selected by HR
					hrpStatus.setPromStatus(rsm);
					}else if(requestStatus.equalsIgnoreCase("DisApproved")){
						Resumestatusmaster rsm = new Resumestatusmaster();
						rsm.setId(9); // for rejected by HR
						hrpStatus.setPromStatus(rsm);
					}
				}else if(flag.equalsIgnoreCase("M")){
					if(requestStatus.equalsIgnoreCase("Approved")){
						Resumestatusmaster rsm = new Resumestatusmaster();
						rsm.setId(21); // for selected by MD
						hrpStatus.setPromStatus(rsm);
					}else if(requestStatus.equalsIgnoreCase("DisApproved")){
						Resumestatusmaster rsm = new Resumestatusmaster();
						rsm.setId(22); // for rejected by MD
						hrpStatus.setPromStatus(rsm);
					}
					
				}
				hrpStatus.setRemarks(remarks);
				Users user = new Users();
				user.setId(userId);
				hrpStatus.setLastChgBy(user);			
				hrpStatus.setLastChgTime(time);			
				hrpStatus.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				hbt.saveOrUpdate(hrpStatus);
				hbt.refresh(hrpStatus);
				
				// end.....Data updated into   hr_req_prom_status table
				
				
		// Data insert into   hr_req_prom_history table
				
				HrReqPromHistory hrpHistory = new HrReqPromHistory();
		
				hrpHistory.setPromReq(hrpStatus.getPromReq());
				hrpHistory.setRequisition(hrpStatus.getPromReq().getRequisition());
				if(flag.equalsIgnoreCase("H")){
					if(requestStatus.equalsIgnoreCase("Approved")){
						Resumestatusmaster rsm = new Resumestatusmaster();
						rsm.setId(10); // for selected by HR
						hrpHistory.setPromStatus(rsm);
						}else if(requestStatus.equalsIgnoreCase("DisApproved")){
							Resumestatusmaster rsm = new Resumestatusmaster();
							rsm.setId(9); // for rejected by HR
							hrpHistory.setPromStatus(rsm);
						}
					}else if(flag.equalsIgnoreCase("M")){
						if(requestStatus.equalsIgnoreCase("Approved")){
							Resumestatusmaster rsm = new Resumestatusmaster();
							rsm.setId(21); // for selected by MD
							hrpHistory.setPromStatus(rsm);
						}else if(requestStatus.equalsIgnoreCase("DisApproved")){
							Resumestatusmaster rsm = new Resumestatusmaster();
							rsm.setId(22); // for rejected by MD
							hrpHistory.setPromStatus(rsm);
						}
						
					}
				hrpHistory.setEmp(hrpStatus.getPromReq().getEmployee());
				hrpHistory.setRemarks(remarks);
				hrpHistory.setLastChgBy(user);			
				hrpHistory.setLastChgTime(time);			
				hrpHistory.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				hrpHistory.setApprovedBy(user);
				hrpHistory.setApprovedDate(HMSUtil.dateFormatterDDMMYYYY(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				hbt.save(hrpHistory);
				hbt.refresh(hrpHistory);
				
				// end ..... Data insert into   hr_req_prom_history table
				System.out.println("reqFrPromotionId=con=666==="+reqfrPromotionIdList.get(i));
				if(reqfrPromotionIdList.get(i) != null && !reqfrPromotionIdList.get(i).equals("")){
					int reqFrPromotionId = Integer.parseInt(""+reqfrPromotionIdList.get(i));
					HrRequisitionFrPromotion hrRequisitionFrPromotion =(HrRequisitionFrPromotion)hbt.load(HrRequisitionFrPromotion.class, reqFrPromotionId);
					hrRequisitionFrPromotion.setStatus("a");
					hbt.update(hrRequisitionFrPromotion);
				}
				
				
		}
		update=true;
		tx.commit();
		} catch (Exception e) {
			update=false;
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		
		session.flush();
		updateMap.put("update", update);
		return updateMap;
	}



}
