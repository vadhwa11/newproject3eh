package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasSpecialQualification;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EducationDataServiceImpl extends HibernateDaoSupport implements
		EducationDataService {

	// *************************************** Start of Course Master By
	// Rajendra *******************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCourseMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasCourse> searchCourseMasterList = new ArrayList<HrMasCourse>();

		searchCourseMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasCourse");
		map.put("searchCourseMasterList", searchCourseMasterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCourseMaster(String courseCode,
			String courseName) {
		List<HrMasCourse> searchCourseMasterList = new ArrayList<HrMasCourse>();
		Map<String, Object> courseMasterFieldsMap = new HashMap<String, Object>();

		try {
			if ((courseCode != null) || (courseName == null)) {
				searchCourseMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasCourse ms where ms.CourseCode like '"
								+ courseCode + "%' order by ms.CourseCode");
			} else {
				searchCourseMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasCourse ms where ms.CourseName like '"
								+ courseName + "%' order by ms.CourseName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseMasterFieldsMap.put("searchCourseMasterList",
				searchCourseMasterList);
		return courseMasterFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addCourseMaster(HrMasCourse hrMasCourse) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasCourse);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editCourseMaster(Map<String, Object> map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String courseCode = "";
		String courseName = "";
		int hospitalId = 0;
		int courseId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			courseId = (Integer) map.get("id");
			hospitalId = (Integer) map.get("hospitalId");
			courseCode = (String) map.get("code");
			courseName = (String) map.get("name");

			changedBy = (String) map.get("changedBy");
			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasCourse hrMasCourse = (HrMasCourse) getHibernateTemplate()
					.load(HrMasCourse.class, courseId);

			hrMasCourse.setId(courseId);
			hrMasCourse.setCourseCode(courseCode);
			hrMasCourse.setCourseName(courseName);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasCourse.setCompany(masHospital);

			hrMasCourse.setLastChgBy(changedBy);
			hrMasCourse.setLastChgDate(currentDate);
			hrMasCourse.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasCourse);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteCourseMaster(int courseId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasCourse hrMasCourse = new HrMasCourse();
			hrMasCourse = (HrMasCourse) getHibernateTemplate().load(
					HrMasCourse.class, courseId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasCourse.getStatus().equals("y")) {
				hrMasCourse.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasCourse.setStatus("y");
				dataDeleted = false;
			}
			hrMasCourse.setLastChgBy(changedBy);
			hrMasCourse.setLastChgDate(currentDate);
			hrMasCourse.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasCourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

	// *************************************** End of Course Master By Rajendra
	// *******************************//

	// *************************************** Start of Qualification Master By
	// Rajendra *******************************//

	@SuppressWarnings("unchecked")
	public Map<String, Object> showQualificationMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasQualification> searchQualificationMasterList = new ArrayList<HrMasQualification>();

		searchQualificationMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasQualification");
		map.put("searchQualificationMasterList", searchQualificationMasterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addQualificationMaster(HrMasQualification hrMasQualification) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasQualification);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchQualificationMaster(
			String qualificationCode, String qualificationName) {
		List<HrMasQualification> searchQualificationMasterList = new ArrayList<HrMasQualification>();
		Map<String, Object> qualificationMasterFieldsMap = new HashMap<String, Object>();
		try {
			if ((qualificationCode != null) || (qualificationName == null)) {
				searchQualificationMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasQualification ms where ms.QualificationCode like '"
								+ qualificationCode
								+ "%' order by ms.QualificationCode");
			} else {
				searchQualificationMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasQualification ms where ms.QualificationName like '"
								+ qualificationName
								+ "%' order by ms.QualificationName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		qualificationMasterFieldsMap.put("searchQualificationMasterList",
				searchQualificationMasterList);
		return qualificationMasterFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editQualificationMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String qualificationCode = "";
		String qualificationName = "";
		int hospitalId = 0;
		int qualificationId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			qualificationId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			qualificationCode = (String) generalMap.get("code");
			qualificationName = (String) generalMap.get("name");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasQualification hrMasQualification = (HrMasQualification) getHibernateTemplate()
					.load(HrMasQualification.class, qualificationId);

			hrMasQualification.setId(qualificationId);
			hrMasQualification.setQualificationCode(qualificationCode);
			hrMasQualification.setQualificationName(qualificationName);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasQualification.setCompany(masHospital);

			hrMasQualification.setLastChgBy(changedBy);
			hrMasQualification.setLastChgDate(currentDate);
			hrMasQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasQualification);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteQualificationMaster(int qualificationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasQualification hrMasQualification = new HrMasQualification();
			hrMasQualification = (HrMasQualification) getHibernateTemplate()
					.load(HrMasQualification.class, qualificationId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasQualification.getStatus().equals("y")) {
				hrMasQualification.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasQualification.setStatus("y");
				dataDeleted = false;
			}
			hrMasQualification.setLastChgBy(changedBy);
			hrMasQualification.setLastChgDate(currentDate);
			hrMasQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasQualification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

	// *************************************** End of Qualification Master By
	// Rajendra *******************************//

	// *************************************** Start of Special Qualification
	// Master By Rajendra *******************************//

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSpecialQualificationMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasSpecialQualification> searchSpecialQualificationMasterList = new ArrayList<HrMasSpecialQualification>();

		searchSpecialQualificationMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasSpecialQualification");
		map.put("searchSpecialQualificationMasterList",
				searchSpecialQualificationMasterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addSpecialQualificationMaster(
			HrMasSpecialQualification hrMasSpecialQualification) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasSpecialQualification);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSpecialQualificationMaster(
			String specialQualificationCode, String specialQualificationName) {
		List<HrMasSpecialQualification> searchSpecialQualificationMasterList = new ArrayList<HrMasSpecialQualification>();
		Map<String, Object> specialQualificationMasterFieldsMap = new HashMap<String, Object>();
		try {
			if ((specialQualificationCode != null)
					|| (specialQualificationName == null)) {
				searchSpecialQualificationMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasSpecialQualification ms where ms.SpecialQualificationCode like '"
								+ specialQualificationCode
								+ "%' order by ms.SpecialQualificationCode");
			} else {
				searchSpecialQualificationMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasSpecialQualification ms where ms.SpecialQualificationName like '"
								+ specialQualificationName
								+ "%' order by ms.SpecialQualificationName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		specialQualificationMasterFieldsMap.put(
				"searchSpecialQualificationMasterList",
				searchSpecialQualificationMasterList);
		return specialQualificationMasterFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editSpecialQualificationMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String specialQualificationCode = "";
		String specialQualificationName = "";
		int hospitalId = 0;
		int specialQualificationId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			specialQualificationId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			specialQualificationCode = (String) generalMap.get("code");
			specialQualificationName = (String) generalMap.get("name");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasSpecialQualification hrMasSpecialQualification = (HrMasSpecialQualification) getHibernateTemplate()
					.load(HrMasSpecialQualification.class,
							specialQualificationId);

			hrMasSpecialQualification.setId(specialQualificationId);
			hrMasSpecialQualification
					.setSpecialQualificationCode(specialQualificationCode);
			hrMasSpecialQualification
					.setSpecialQualificationName(specialQualificationName);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasSpecialQualification.setCompany(masHospital);

			hrMasSpecialQualification.setLastChgBy(changedBy);
			hrMasSpecialQualification.setLastChgDate(currentDate);
			hrMasSpecialQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSpecialQualification);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSpecialQlualificationMaster(
			int specialQualificationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasSpecialQualification hrMasSpecialQualification = new HrMasSpecialQualification();
			hrMasSpecialQualification = (HrMasSpecialQualification) getHibernateTemplate()
					.load(HrMasSpecialQualification.class,
							specialQualificationId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasSpecialQualification.getStatus().equals("y")) {
				hrMasSpecialQualification.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasSpecialQualification.setStatus("y");
				dataDeleted = false;
			}
			hrMasSpecialQualification.setLastChgBy(changedBy);
			hrMasSpecialQualification.setLastChgDate(currentDate);
			hrMasSpecialQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSpecialQualification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

}
