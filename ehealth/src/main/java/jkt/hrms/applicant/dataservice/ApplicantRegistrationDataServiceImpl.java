package jkt.hrms.applicant.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hrms.masters.business.ApplicantEducation;
import jkt.hrms.masters.business.ApplicantExperience;
import jkt.hrms.masters.business.ApplicantPersonal;
import jkt.hrms.masters.business.ApplicantRefrenceDetails;
import jkt.hrms.masters.business.MasApplicant;
import jkt.hrms.masters.business.MasCourse;
import jkt.hrms.masters.business.MasDurationType;
import jkt.hrms.masters.business.MasInstitute;
import jkt.hrms.masters.business.MasJob;
import jkt.hrms.masters.business.MasNationality;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.masters.business.MasSplQualification;
import jkt.hrms.masters.business.MasTribe;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ApplicantRegistrationDataServiceImpl extends HibernateDaoSupport
		implements ApplicantRegistrationDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showApplicantRegistrationJsp(
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasNationality> nationalityList = new ArrayList<MasNationality>();
		List<MasJob> jobList = new ArrayList<MasJob>();

		List<MasSplQualification> splQualificationList = new ArrayList<MasSplQualification>();
		List<MasInstitute> instituteList = new ArrayList<MasInstitute>();
		List<MasTribe> tribeList = new ArrayList<MasTribe>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasDurationType> masDurationTypeList = new ArrayList<MasDurationType>();
		List<MasQualification> qualificationList = new ArrayList<MasQualification>();
		List<MasCourse> courseList = new ArrayList<MasCourse>();
		String applicantCode = "";

		List<MasReligion> religionList = new ArrayList<MasReligion>();

		Session session = (Session) getSession();
		List masApplicantListIds = null;
		MasApplicant masApplicant = null;
		Integer code = 0;
		try {

			List<String> applicantCodeList;
			masApplicantListIds = getHibernateTemplate().find(
					"select max(applicant.Id) from MasApplicant applicant");

			code = (Integer) (masApplicantListIds.get(0));
			if (code != null) {
				masApplicant = (MasApplicant) getHibernateTemplate().load(
						MasApplicant.class, code);
			}
			jobList = session.createCriteria(MasJob.class).list();
			masDurationTypeList = session.createCriteria(MasDurationType.class)
					.list();
			nationalityList = session.createCriteria(MasNationality.class)
					.add(Restrictions.eq("Status", "y")).list();
			titleList = session.createCriteria(MasTitle.class)
					.add(Restrictions.eq("Status", "y")).list();
			tribeList = session.createCriteria(MasTribe.class)
					.add(Restrictions.eq("Status", "y")).list();
			countryList = session.createCriteria(MasCountry.class)
					.add(Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y")).list();
			districtList = session
					.createQuery(
							"select dist from MasDistrict as dist order by dist.DistrictName ")
					.list();
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			applicantCode = getApplicantCode(session, request);

			maritalStatusList = session.createCriteria(MasMaritalStatus.class)
					.add(Restrictions.eq("Status", "y")).list();

			countryList = session.createCriteria(MasCountry.class)
					.add(Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y")).list();

			districtList = session
					.createQuery(
							"select dist from MasDistrict as dist order by dist.DistrictName ")
					.list();

			religionList = session.createCriteria(MasReligion.class).list();
			courseList = session.find("from MasCourse m ");
			splQualificationList = session.createCriteria(
					MasSplQualification.class).list();
			instituteList = session.createCriteria(MasInstitute.class).list();
			qualificationList = session.createCriteria(MasQualification.class)
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("maritalStatusList", maritalStatusList);
		map.put("jobList", jobList);
		map.put("titleList", titleList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("masApplicant", masApplicant);
		map.put("religionList", religionList);
		map.put("masDurationTypeList", masDurationTypeList);
		map.put("applicantCode", getApplicantCode(session, request));
		map.put("tribeList", tribeList);
		map.put("departmentList", departmentList);
		map.put("courseList", courseList);
		map.put("splQualificationList", splQualificationList);
		map.put("instituteList", instituteList);
		map.put("qualificationList", qualificationList);
		map.put("nationalityList", nationalityList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<String> saveMasterDetails(Map<String, Object> dataContentMap) {

		List<String> succesfullySaved = new ArrayList<String>();
		org.springframework.orm.hibernate3.HibernateTemplate ht = getHibernateTemaplateForSaveAndUpdate();
		try {

			if ((MasApplicant) dataContentMap.get("masApplicant") != null) {

				ht.saveOrUpdate(dataContentMap.get("masApplicant"));
				succesfullySaved.add("true");
			}
			List<MasApplicant> savedObj = getSession()
					.createCriteria(MasApplicant.class)
					.add(Restrictions.eq("ApplicantCode",
							((MasApplicant) dataContentMap.get("masApplicant"))
									.getApplicantCode())).list();

			if ((ApplicantRefrenceDetails) dataContentMap
					.get("applicantRefrenceDetails") != null) {
				ApplicantRefrenceDetails applicantRefrenceDetails = (ApplicantRefrenceDetails) dataContentMap
						.get("applicantRefrenceDetails");
				MasApplicant masApplicant = new MasApplicant();
				masApplicant.setId(savedObj.get(0).getId());
				applicantRefrenceDetails.setApplicant(masApplicant);
				ht.saveOrUpdate(applicantRefrenceDetails);
				succesfullySaved.add("true");

			}
			if ((ApplicantRefrenceDetails) dataContentMap
					.get("applicantRefrenceDetails1") != null) {

				ApplicantRefrenceDetails applicantRefrenceDetails1 = (ApplicantRefrenceDetails) dataContentMap
						.get("applicantRefrenceDetails1");
				MasApplicant masApplicant = new MasApplicant();
				masApplicant.setId(savedObj.get(0).getId());
				applicantRefrenceDetails1.setApplicant(masApplicant);
				ht.saveOrUpdate(applicantRefrenceDetails1);
				succesfullySaved.add("true");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;
	}

	@SuppressWarnings("unchecked")
	public boolean savePersonalDetails(ApplicantPersonal applicantPersonal) {

		boolean succesfullySaved = false;

		try {

			if (applicantPersonal != null) {
				getHibernateTemaplateForSaveAndUpdate().saveOrUpdate(
						applicantPersonal);
			}
			succesfullySaved = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;

	}

	@SuppressWarnings("unchecked")
	public boolean saveEducationalDetails(ApplicantEducation applicantEducation) {
		boolean succesfullySaved = false;

		try {

			if (applicantEducation != null) {
				getHibernateTemaplateForSaveAndUpdate().saveOrUpdate(
						applicantEducation);
			}
			succesfullySaved = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;
	}

	@SuppressWarnings("unchecked")
	public boolean saveExperienceDetails(ApplicantExperience applicantExperience) {
		boolean succesfullySaved = false;
		try {

			if (applicantExperience != null) {
				getHibernateTemaplateForSaveAndUpdate().saveOrUpdate(
						applicantExperience);
			}
			succesfullySaved = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;

	}

	private org.springframework.orm.hibernate3.HibernateTemplate getHibernateTemaplateForSaveAndUpdate() {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		return hbt;
	}

	/*
	 * public Map<String,String> getApplicantObjectsForUpdate(Map<String,Object>
	 * map){ if(map.get("applicantMaster")!=null) { // }
	 * 
	 * 
	 * 
	 * return null; }
	 */
	private String getApplicantCode(Session session, HttpServletRequest request) {
		String applicantCode = "";
		if (request.getSession().getAttribute("applicantCode") == null) {
			List<Integer> masApplicantListIds = new ArrayList<Integer>();
			List<String> applicantCodeList;
			masApplicantListIds = getHibernateTemplate().find(
					"select max(applicant.Id) from MasApplicant applicant");
			Integer code = (masApplicantListIds.get(0));

			if (code != null) {
				applicantCode = "A0" + (code + 1);
			} else {
				applicantCode = "A0" + 0;
			}
			request.getSession().setAttribute("applicantCode", applicantCode);
		} else {
			applicantCode = (String) request.getSession().getAttribute(
					"applicantCode");
		}

		return applicantCode;
	}

	public String getDepartmentCode(int departmentId) {
		Session session = (Session) getSession();

		MasDepartment masDepartment = (MasDepartment) session.get(
				MasDepartment.class, departmentId);
		return masDepartment.getDepartmentCode();
	}

	public String getJobCode(int jobId) {
		Session session = (Session) getSession();
		MasJob masJob = (MasJob) session.get(MasJob.class, jobId);
		return masJob.getJobCode();
	}

	public boolean updateEducationalDetails(
			ApplicantEducation applicantEducation) {
		boolean succesfullySaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate ht = getHibernateTemaplateForSaveAndUpdate();
		try {

			if (applicantEducation != null) {

				ht.update(applicantEducation);
				succesfullySaved = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;

	}

	public boolean updateExperienceDetails(
			ApplicantExperience applicantExperience) {
		boolean succesfullySaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate ht = getHibernateTemaplateForSaveAndUpdate();
		try {

			if (applicantExperience != null) {

				ht.update(applicantExperience);
				succesfullySaved = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;
	}

	public List<String> updateMasterDetails(Map<String, Object> dataContentMap) {
		List<String> succesfullySaved = new ArrayList<String>();
		org.springframework.orm.hibernate3.HibernateTemplate ht = getHibernateTemaplateForSaveAndUpdate();
		try {
			if ((MasApplicant) dataContentMap.get("storedMasApplicant") != null) {

				ht.update(dataContentMap.get("storedMasApplicant"));
				succesfullySaved.add("true");
			}

			if ((ApplicantRefrenceDetails) dataContentMap
					.get("storedApplicantRefrenceDetails") != null) {
				ApplicantRefrenceDetails applicantRefrenceDetails = (ApplicantRefrenceDetails) dataContentMap
						.get("storedApplicantRefrenceDetails");

				ht.update(applicantRefrenceDetails);
				succesfullySaved.add("true");

			}
			if ((ApplicantRefrenceDetails) dataContentMap
					.get("storedApplicantRefrenceDetails1") != null) {

				ApplicantRefrenceDetails applicantRefrenceDetails1 = (ApplicantRefrenceDetails) dataContentMap
						.get("storedApplicantRefrenceDetails1");

				ht.update(applicantRefrenceDetails1);
				succesfullySaved.add("true");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return succesfullySaved;
	}

	public boolean updatePersonalDetails(ApplicantPersonal applicantPersonal) {
		boolean succesfullySaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate ht = getHibernateTemaplateForSaveAndUpdate();
		try {

			if (applicantPersonal != null) {

				ht.update(applicantPersonal);
				succesfullySaved = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullySaved;
	}

	public MasApplicant getMasterDetails(int id) {
		Session session = (Session) getSession();
		return (MasApplicant) session.load(MasApplicant.class, id);

	}

	public ApplicantPersonal getPersonalDetails(int id) {
		Session session = (Session) getSession();
		return (ApplicantPersonal) session
				.createCriteria(ApplicantPersonal.class)
				.createAlias("Applicant", "masApplicant")
				.add(Restrictions.eq("masApplicant.Id", id)).list().get(0);
	}

	public List<ApplicantEducation> getEducationalDetails(int id) {
		Session session = (Session) getSession();
		return session.createCriteria(ApplicantEducation.class)
				.createAlias("Applicant", "masApplicant")
				.add(Restrictions.eq("masApplicant.Id", id))
				.addOrder(Order.asc("SrNo")).list();
	}

	public ApplicantExperience getApplicantExperience(int id) {
		Session session = (Session) getSession();
		return (ApplicantExperience) session
				.createCriteria(ApplicantExperience.class)
				.createAlias("Applicant", "masApplicant")
				.add(Restrictions.eq("masApplicant.Id", id)).list().get(0);

	}

	public List<ApplicantRefrenceDetails> getApplicantRefrenceDetailsList(int id) {
		Session session = (Session) getSession();
		return session.createCriteria(ApplicantRefrenceDetails.class)
				.createAlias("Applicant", "masApplicant")
				.add(Restrictions.eq("masApplicant.Id", id))
				.addOrder(Order.asc("SrNo")).list();
	}
}
