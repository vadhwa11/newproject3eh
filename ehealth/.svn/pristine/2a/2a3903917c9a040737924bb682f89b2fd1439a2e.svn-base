package jkt.hrms.training.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HrCommitteeDetails;
import jkt.hms.masters.business.HrCommitteeHeader;
import jkt.hms.masters.business.HrDeathRegister;
import jkt.hms.masters.business.HrEmployeeDeputation;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.HrJoiningDetails;
import jkt.hms.masters.business.HrMasTransferNotification;
import jkt.hms.masters.business.HrMedicalFitnessFirst;
import jkt.hms.masters.business.HrMedicalRecord;
import jkt.hms.masters.business.HrMeetingAgendaPoint;
import jkt.hms.masters.business.HrMeetingMembers;
import jkt.hms.masters.business.HrMeetingSchedule;
import jkt.hms.masters.business.HrPatientFitnessCertificate;
import jkt.hms.masters.business.HrPatientSickCertificate;
import jkt.hms.masters.business.HrStudentCertificate;
import jkt.hms.masters.business.HrTerminationProcess;
import jkt.hms.masters.business.HrTrainingService;
import jkt.hms.masters.business.HrTransferApplicationM;
import jkt.hms.masters.business.HrTransferApplicationT;
import jkt.hms.masters.business.HrTransferApproved;
import jkt.hms.masters.business.HrVacancyPost;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeHistory;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasOpSession;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.EtrTravelreq;
import jkt.hrms.masters.business.HrMasApplicationLevel;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.business.HrMasInstructor;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasTraining;
import jkt.hrms.masters.business.HrMasTrainingStatus;
import jkt.hrms.masters.business.HrTrainingApprovalStatus;
import jkt.hrms.masters.business.HrTrainingEffective;
import jkt.hrms.masters.business.HrTrainingRequisition;
import jkt.hrms.masters.business.HrTrainingSchedule;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MasTrainingType;
import jkt.hrms.masters.business.TempTickattach;
import jkt.hrms.masters.business.UserManager;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TrainingDataServiceImpl extends HibernateDaoSupport implements
		TrainingDataService {

	// ***************************************** Start Training Module's
	// Instructor Master By Rajendra ********************************//

	
	static final Logger log = Logger.getLogger(jkt.hrms.training.dataservice.TrainingDataServiceImpl.class);
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstructorMasterJsp() {
		List<HrMasInstructor> searchInstructorMasterList = new ArrayList<HrMasInstructor>();
		List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
		List<HrMasQualification> gridQualificationList = new ArrayList<HrMasQualification>();

		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		searchInstructorMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasInstructor");

		gridQualificationList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasQualification");
		qualificationList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasQualification mq where mq.Status = 'y'");

		countryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry mc where mc.Status ='y'");
		gridCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry");

		stateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasState ms where ms.Status ='y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		districtList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict md where md.Status ='y'");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");

		generalMap
				.put("searchInstructorMasterList", searchInstructorMasterList);
		generalMap.put("gridQualificationList", gridQualificationList);
		generalMap.put("qualificationList", qualificationList);

		generalMap.put("countryList", countryList);
		generalMap.put("gridCountryList", gridCountryList);

		generalMap.put("stateList", stateList);
		generalMap.put("gridStateList", gridStateList);

		generalMap.put("districtList", districtList);
		generalMap.put("gridDistrictList", gridDistrictList);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addInstructionMaster(HrMasInstructor hrMasInstructor) {
		boolean successfullyAdded = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasInstructor);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInstructorMaster(String instructorCode,
			String instructorName) {
		List<HrMasInstructor> searchInstructorMasterList = new ArrayList<HrMasInstructor>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
		List<HrMasQualification> gridQualificationList = new ArrayList<HrMasQualification>();

		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

		try {
			if (instructorCode != null || instructorName == null) {

				searchInstructorMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstructor mi where mi.InstructorCode like '"
								+ instructorCode
								+ "%' order by mi.InstructorCode");
			} else {
				searchInstructorMasterList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasInstructor mi where mi.InstructorName like '"
								+ instructorName
								+ "%' order by mi.InstructorName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		gridQualificationList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasQualification");
		qualificationList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasQualification mq where mq.Status = 'y'");

		countryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry mc where mc.Status ='y'");
		gridCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry");

		stateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasState ms where ms.Status ='y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		districtList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict md where md.Status ='y'");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");

		generalMap.put("qualificationList", qualificationList);
		generalMap.put("gridQualificationList", gridQualificationList);

		generalMap.put("countryList", countryList);
		generalMap.put("gridCountryList", gridCountryList);

		generalMap.put("stateList", stateList);
		generalMap.put("gridStateList", gridStateList);

		generalMap.put("districtList", districtList);
		generalMap.put("gridDistrictList", gridDistrictList);

		generalMap
				.put("searchInstructorMasterList", searchInstructorMasterList);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public boolean editInstructorMaster(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String instructorCode = "";
		String instructorName = "";
		String instructorType = "";
		int qualificationId = 0;
		String instructorAddress = "";
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		String pincode = "";
		String phoneNo = "";
		String remarks = "";
		int hospitalId = 0;
		int instructorId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			instructorId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			instructorCode = (String) generalMap.get("code");
			instructorName = (String) generalMap.get("name");
			instructorType = (String) generalMap.get("instructorType");
			instructorAddress = (String) generalMap.get("instructorAddress");
			qualificationId = (Integer) generalMap.get("qualificationId");
			districtId = (Integer) generalMap.get("districtId");
			stateId = (Integer) generalMap.get("stateId");
			countryId = (Integer) generalMap.get("countryId");
			pincode = (String) generalMap.get("pincode");
			phoneNo = (String) generalMap.get("phoneNo");
			remarks = (String) generalMap.get("remarks");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HrMasInstructor hrMasInstructor = (HrMasInstructor) getHibernateTemplate()
					.load(HrMasInstructor.class, instructorId);

			hrMasInstructor.setId(instructorId);
			hrMasInstructor.setInstructorCode(instructorCode);
			hrMasInstructor.setInstructorName(instructorName);
			hrMasInstructor.setAddress(instructorAddress);
			hrMasInstructor.setInstructorType(instructorType);
			hrMasInstructor.setPincode(pincode);
			hrMasInstructor.setPhoneNo(phoneNo);
			hrMasInstructor.setRemarks(remarks);

			HrMasQualification hrMasQualification = new HrMasQualification();
			hrMasQualification.setId(qualificationId);
			hrMasInstructor.setQualification(hrMasQualification);

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			hrMasInstructor.setDistrict(masDistrict);

			MasState masState = new MasState();
			masState.setId(stateId);
			hrMasInstructor.setState(masState);

			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			hrMasInstructor.setCountry(masCountry);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstructor.setCompany(masHospital);

			hrMasInstructor.setLastChgBy(changedBy);
			hrMasInstructor.setLastChgDate(currentDate);
			hrMasInstructor.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstructor);
			dataUpdated = true;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteInstructorMaster(int instructorId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasInstructor hrMasInstructor = new HrMasInstructor();
			hrMasInstructor = (HrMasInstructor) getHibernateTemplate().load(
					HrMasInstructor.class, instructorId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasInstructor.getStatus().equals("y")) {
				hrMasInstructor.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasInstructor.setStatus("y");
				dataDeleted = false;
			}
			hrMasInstructor.setLastChgBy(changedBy);
			hrMasInstructor.setLastChgDate(currentDate);
			hrMasInstructor.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstructor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	// *********************************************** Start Training Module's
	// Training Master By Rajendra
	// ***********************************************************************************************//

	public Map<String, Object> showTrainingMasterJsp() {

		List<HrMasTraining> searchTrainingMasterList = new ArrayList<HrMasTraining>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		searchTrainingMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasTraining");

		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment md where md.Status = 'y'");

		countryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry mc where mc.Status ='y'");
		gridCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry");

		stateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasState ms where ms.Status ='y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		districtList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict md where md.Status ='y'");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");

		generalMap.put("searchTrainingMasterList", searchTrainingMasterList);
		generalMap.put("gridDepartmentList", gridDepartmentList);
		generalMap.put("departmentList", departmentList);

		generalMap.put("countryList", countryList);
		generalMap.put("gridCountryList", gridCountryList);

		generalMap.put("stateList", stateList);
		generalMap.put("gridStateList", gridStateList);

		generalMap.put("districtList", districtList);
		generalMap.put("gridDistrictList", gridDistrictList);

		return generalMap;

	}

	@SuppressWarnings("unchecked")
	public boolean addTrainingMaster(HrMasTraining hrMasTraining) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasTraining);
		successfullyAdded = true;

		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean editTrainingMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String trainingCode = "";
		String trainingName = "";
		Integer departmentId = null;
		Integer trainingTypeId = null;
		String trainingVenue = "";
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		String pincode = "";
		String phoneNo = "";
		Integer seatAvailable = 0;
		BigDecimal feesCharged = new BigDecimal(0.0);
		String topicsCovered = "";
		String remarks = "";

		int hospitalId = 0;
		int trainingId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			trainingId = (Integer) generalMap.get("id");
			hospitalId = (Integer) generalMap.get("hospitalId");
			trainingCode = (String) generalMap.get("code");
			trainingName = (String) generalMap.get("name");
			departmentId = (Integer) generalMap.get("departmentId");

			trainingTypeId = (Integer) generalMap.get("trainingTypeId");
			trainingVenue = (String) generalMap.get("trainingVenue");
			districtId = (Integer) generalMap.get("districtId");
			stateId = (Integer) generalMap.get("stateId");
			countryId = (Integer) generalMap.get("countryId");
			pincode = (String) generalMap.get("pincode");
			phoneNo = (String) generalMap.get("phoneNo");
			seatAvailable = (Integer) generalMap.get("seatAvailable");
			feesCharged = (BigDecimal) generalMap.get("feesCharged");
			topicsCovered = (String) generalMap.get("topicsCovered");
			remarks = (String) generalMap.get("remarks");

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			HrMasTraining hrMasTraining = (HrMasTraining) getHibernateTemplate()
					.load(HrMasTraining.class, trainingId);

			hrMasTraining.setId(trainingId);
			hrMasTraining.setTrainingCode(trainingCode);
			hrMasTraining.setTrainingName(trainingName);
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				hrMasTraining.setDepartment(masDepartment);
			} else {
				hrMasTraining.setDepartment(null);
			}
			hrMasTraining.setCourseId(trainingTypeId);
			hrMasTraining.setAddress(trainingVenue);

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			hrMasTraining.setDistrict(masDistrict);

			MasState masState = new MasState();
			masState.setId(stateId);
			hrMasTraining.setState(masState);

			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			hrMasTraining.setCountry(masCountry);

			hrMasTraining.setPincode(pincode);
			hrMasTraining.setPhoneNo(phoneNo);
			hrMasTraining.setSeatAvailable(seatAvailable);
			hrMasTraining.setFeesCharged(feesCharged);
			hrMasTraining.setTopicsCovered(topicsCovered);
			hrMasTraining.setRemarks(remarks);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasTraining.setCompany(masHospital);

			hrMasTraining.setLastChgBy(changedBy);
			hrMasTraining.setLastChgDate(currentDate);
			hrMasTraining.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasTraining);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTrainingMaster(int trainingId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasTraining hrMasTraining = new HrMasTraining();
			hrMasTraining = (HrMasTraining) getHibernateTemplate().load(
					HrMasTraining.class, trainingId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasTraining.getStatus().equals("y")) {
				hrMasTraining.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasTraining.setStatus("y");
				dataDeleted = false;
			}
			hrMasTraining.setLastChgBy(changedBy);
			hrMasTraining.setLastChgDate(currentDate);
			hrMasTraining.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasTraining);
			dataDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTrainingMaster(String trainingCode,
			String trainingName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List searchTrainingMasterList = new ArrayList();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

		try {
			if (trainingCode != null && trainingName == null) {
				searchTrainingMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasTraining mt where mt.TrainingCode like '"
								+ trainingCode + "%' order by mt.TrainingCode");
			} else {
				searchTrainingMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasTraining mt where mt.TrainingName like '"
								+ trainingName + "%' order by mt.TrainingName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment md where md.Status = 'y'");

		countryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCountry mc where mc.Status ='y'");
		gridCountryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCountry");

		stateList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasState ms where ms.Status ='y'");
		gridStateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasState");

		districtList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDistrict md where md.Status ='y'");
		gridDistrictList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDistrict");

		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);

		map.put("gridCountryList", gridCountryList);
		map.put("countryList", countryList);

		map.put("gridStateList", gridStateList);
		map.put("stateList", stateList);

		map.put("gridDistrictList", gridDistrictList);
		map.put("districtList", districtList);
		map.put("searchTrainingMasterList", searchTrainingMasterList);

		return map;
	}

	// *********************************************** Start Training Module's
	// Training Requisition By Rajendra
	// ***********************************************************************************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showTrainingRequisitionJsp(Map<String, Object> parameterMap) {
		List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();

		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> gridRankList = new ArrayList<MasRank>();

		List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
		List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Users users = new Users();
		if(parameterMap.get("users")!= null){
			users = (Users)parameterMap.get("users");
		}
		int employeeId = users.getEmployee().getId();
		Session session = (Session) getSession();

		searchTrainingRequisitionList = session.createCriteria(HrTrainingRequisition.class).add(Restrictions.eq("Status", "y")).list();
		//searchTrainingRequisitionList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrTrainingRequisition");

		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment md where md.Status = 'y'");
		//employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee me where me.Status ='y'");
		gridEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee");

		rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank mr where mr.Status ='y'");
		gridRankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank");

		trainingMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasTraining mt where mt.Status ='y'");
		gridTrainingMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasTraining");

		generalMap.put("searchTrainingRequisitionList",	searchTrainingRequisitionList);
		generalMap.put("gridDepartmentList", gridDepartmentList);
		generalMap.put("departmentList", departmentList);

		generalMap.put("employeeList", employeeList);
		generalMap.put("gridEmployeeList", gridEmployeeList);

		generalMap.put("rankList", rankList);
		generalMap.put("gridRankList", gridRankList);
		generalMap.put("trainingMasterList", trainingMasterList);
		generalMap.put("gridTrainingMasterList", gridTrainingMasterList);

		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addTrainingRequisition(
			HrTrainingRequisition hrTrainingRequisition) {
		boolean successfullyAdded = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrTrainingRequisition);
		hbt.flush();
		hbt.refresh(hrTrainingRequisition);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean addTrainingApprovalStatus(
			HrTrainingApprovalStatus hrTrainingApprovalStatus) {
		boolean successfullyAddedStatus = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrTrainingApprovalStatus);
		hbt.flush();
		hbt.refresh(hrTrainingApprovalStatus);
		successfullyAddedStatus = true;
		return successfullyAddedStatus;
	}

	@SuppressWarnings("unchecked")
	public boolean editTrainingRequisition(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		HttpSession session = null;
		int hospitalId = 0;

		Integer trainingRequisitionId = null;
		Integer employeeId = null;
		Integer rankId = null;
		Integer departmentId = null;
		Integer trainingId = null;
		Integer contributingtrainingId = null;
		int toBeApproved = 0;
		Date requisitionDate = new Date();
		Date trainingDate = new Date();
		String requisitionStatus = "";
		String remarks = "";

		try {
			trainingRequisitionId = (Integer) generalMap
					.get("trainingRequisitionId");
			employeeId = (Integer) generalMap.get("employeeId");
			toBeApproved = (Integer) generalMap.get("toBeApproved");
			rankId = (Integer) generalMap.get("rankId");
			departmentId = (Integer) generalMap.get("departmentId");
			trainingId = (Integer) generalMap.get("trainingId");
			contributingtrainingId = (Integer) generalMap
					.get("contributingtrainingId");
			requisitionDate = (Date) generalMap.get("requisitionDate");
			trainingDate = (Date) generalMap.get("trainingDate");
			remarks = (String) generalMap.get("remarks");

			hospitalId = (Integer) generalMap.get("hospitalId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			HrTrainingRequisition hrTrainingRequisition = (HrTrainingRequisition) getHibernateTemplate()
					.load(HrTrainingRequisition.class, trainingRequisitionId);

			hrTrainingRequisition.setId(trainingRequisitionId);
			hrTrainingRequisition.setTrainingDate(trainingDate);
			hrTrainingRequisition.setRequisitionDate(requisitionDate);
			hrTrainingRequisition.setRemarks(remarks);

			if (employeeId != null) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				hrTrainingRequisition.setEmployee(masEmployee);
			}

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(toBeApproved);
			hrTrainingRequisition.setToBeApproved(masEmployee);

			if (rankId != null) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				hrTrainingRequisition.setDesignation(masRank);
			}

			if (departmentId != null) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				hrTrainingRequisition.setDepartment(masDepartment);
			}

			if (trainingId != null) {
				HrMasTraining masTraining = new HrMasTraining();
				masTraining.setId(trainingId);
				hrTrainingRequisition.setTraining(masTraining);
			}

			if (contributingtrainingId != null) {
				HrMasTraining masTraining = new HrMasTraining();
				masTraining.setId(contributingtrainingId);
				hrTrainingRequisition.setContributingTraining(masTraining);
			}

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingRequisition.setCompany(masHospital);

			hrTrainingRequisition.setLastChgBy(changedBy);
			hrTrainingRequisition.setLastChgDate(currentDate);
			hrTrainingRequisition.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrTrainingRequisition);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {

			HrTrainingApprovalStatus hrTrainingApprovalStatus = (HrTrainingApprovalStatus) getHibernateTemplate()
					.load(HrTrainingApprovalStatus.class, trainingRequisitionId);

			hrTrainingApprovalStatus.setId(trainingRequisitionId);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(toBeApproved);
			hrTrainingApprovalStatus.setToBeApproved(masEmployee);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingApprovalStatus.setCompany(masHospital);

			hrTrainingApprovalStatus.setLastChgBy(changedBy);
			hrTrainingApprovalStatus.setLastChgDate(currentDate);
			hrTrainingApprovalStatus.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrTrainingApprovalStatus);

		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTrainingRequisition(int trainingRequisitionId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrTrainingRequisition hrTrainingRequisition = (HrTrainingRequisition) getHibernateTemplate()
					.load(HrTrainingRequisition.class, trainingRequisitionId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrTrainingRequisition.getStatus().equals("y")) {
				hrTrainingRequisition.setStatus("n");
				dataDeleted = true;
			} else {
				hrTrainingRequisition.setStatus("y");
				dataDeleted = false;
			}
			hrTrainingRequisition.setLastChgBy(changedBy);
			hrTrainingRequisition.setLastChgDate(currentDate);
			hrTrainingRequisition.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrTrainingRequisition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

	public Map<String, Object> searchTrainingRequisition(int employeeId) {

		List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();

		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRank> gridRankList = new ArrayList<MasRank>();

		List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
		List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (employeeId != 0) {
				searchTrainingRequisitionList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrTrainingRequisition tr where tr.Employee.Id = "
								+ employeeId + "");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment md where md.Status = 'y'");

		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee me where me.Status ='y'");
		gridEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");

		rankList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRank mr where mr.Status ='y'");
		gridRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank");

		trainingMasterList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasTraining mt where mt.Status ='y'");
		gridTrainingMasterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasTraining");

		generalMap.put("searchTrainingRequisitionList",
				searchTrainingRequisitionList);
		generalMap.put("gridDepartmentList", gridDepartmentList);
		generalMap.put("departmentList", departmentList);

		generalMap.put("employeeList", employeeList);
		generalMap.put("gridEmployeeList", gridEmployeeList);

		generalMap.put("rankList", rankList);
		generalMap.put("gridRankList", gridRankList);
		generalMap.put("trainingMasterList", trainingMasterList);
		generalMap.put("gridTrainingMasterList", gridTrainingMasterList);

		return generalMap;

	}

	// *********************************************** Start Training Module's
	// Training Approval By Rajendra
	// ***********************************************************************************************//
	public Map<String, Object> showTrainingApprovalJsp(int currentUserId) {
		List<HrTrainingRequisition> searchTrainingRequisitionList =new ArrayList<HrTrainingRequisition>();

		List<HrMasTrainingStatus> trainingStatusList =new ArrayList<HrMasTrainingStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<UserManager> userManagerList = new ArrayList<UserManager>();
		List subordinatesList = new ArrayList();


		Session session = getSession();


		Criteria criteria = session.createCriteria(UserManager.class);
		criteria = criteria.add(Restrictions.eq("ManagerId", currentUserId));
		userManagerList = criteria.list();

		for(UserManager userManager :userManagerList)
		{
			subordinatesList.add(userManager.getUsers().getId());
		}

		Map<String, Object> generalMap = new HashMap<String, Object>();
		UserManager userManager =new UserManager();
		HrTrainingRequisition hrTrainingRequisition =new HrTrainingRequisition();

		List<HrTrainingApprovalStatus> hrTrainingApprovalList =new ArrayList<HrTrainingApprovalStatus>();

		  Criteria criteria2 = session.createCriteria(HrMasApplicationLevel.class);
		  criteria2 = criteria2.add(Restrictions.eq("Application.Id", "A1"));

		  List applicationLevelList = criteria2.list();
		  HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel)applicationLevelList.get(0);
		  MasRank intermediateApproverDesignation = applicationLevel.getIntermediateApproverDesignation();
		  MasRank finalApproverDesignation = applicationLevel.getFinalApproverDesignation();


		  try {
		   Criteria crit = session.createCriteria(HrTrainingApprovalStatus.class);

		   /*if(currentUserId !=(finalApproverDesignation.getId())){
			     if(currentUserId != 0){
			    	crit = crit.add(Restrictions.eq("ToBeApproved.Id", currentUserId));
			    	crit = crit.add(Restrictions.le("CurrentLevel", 1));
			     }
		    }
		   if(currentUserId ==(finalApproverDesignation.getId())){
			     crit = crit.add(Restrictions.eq("CurrentLevel", 2));
		//	     crit = crit.add(Restrictions.ne("TrainingStatus.Id", 6));
			     crit = crit.add(Restrictions.ne("TrainingStatus.Id", finalApproverDesignation.getId()));
		    }
*/
		    crit = crit.add(Restrictions.eq("Status", "y"));
		    hrTrainingApprovalList = crit.list();
		    for(HrTrainingApprovalStatus hrTrainingApprovalStatus :hrTrainingApprovalList )
			{
				searchTrainingRequisitionList.add(hrTrainingApprovalStatus.getHrTrainingRequisition());
			}
		   }
		  catch (Exception e) {
		    e.printStackTrace();
		   }



		  for(HrTrainingApprovalStatus hrTrainingApprovalStatus :hrTrainingApprovalList )
			{
			  	if(hrTrainingApprovalStatus.getCurrentLevel() == 0 && hrTrainingApprovalStatus.getTrainingStatus().getId() != 2) {
			  		Criteria criteria3 =session.createCriteria(HrMasTrainingStatus.class);
			  		criteria3.add(Restrictions.ne("Id", 5));
			  		criteria3.add(Restrictions.ne("Id", 6));
					criteria3.add(Restrictions.ne("Status", "n"));
					trainingStatusList=criteria3.list();
			  	}else if(hrTrainingApprovalStatus.getCurrentLevel() == 1 && hrTrainingApprovalStatus.getTrainingStatus().getId() != 5) {
				  	Criteria criteria3 =session.createCriteria(HrMasTrainingStatus.class);
			  		criteria3.add(Restrictions.ne("Id", 2));
			  		criteria3.add(Restrictions.ne("Id", 6));
					criteria3.add(Restrictions.ne("Status", "n"));
					trainingStatusList=criteria3.list();
			  	}else {
				  		Criteria criteria3 =session.createCriteria(HrMasTrainingStatus.class);
				  		criteria3.add(Restrictions.ne("Id", 2));
				  		criteria3.add(Restrictions.ne("Id", 5));
						criteria3.add(Restrictions.ne("Status", "n"));
						trainingStatusList=criteria3.list();
			  	}
			}



		Criteria criteria4 = session.createCriteria(MasEmployee.class);
		criteria4.add(Restrictions.ne("Status", "n"));
		employeeList =criteria4.list();


		generalMap.put("searchTrainingRequisitionList", searchTrainingRequisitionList);
		generalMap.put("trainingStatusList",trainingStatusList);
		generalMap.put("employeeList", employeeList);

		return generalMap;

	}

	@SuppressWarnings("unchecked")
	public List<HrTrainingRequisition> updateRequisitionStatus(
			List<HrTrainingRequisition> trainingRequisitionListToBeUpdated) {
		getHibernateTemplate().saveOrUpdateAll(
				trainingRequisitionListToBeUpdated);
		for (HrTrainingRequisition tr : trainingRequisitionListToBeUpdated) {
			getHibernateTemplate().flush();
			getHibernateTemplate().refresh(tr);
		}

		return trainingRequisitionListToBeUpdated;
	}

	@SuppressWarnings("unchecked")
	public HrMasTrainingStatus getTrainingStatusMasterById(int trainingStatusId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(HrMasTrainingStatus.class);
		crit = crit.add(Restrictions.eq("Id", trainingStatusId));
		List<HrMasTrainingStatus> list = crit.list();
		HrMasTrainingStatus hrMasTrainingStatus = list.get(0);
		return hrMasTrainingStatus;
	}

	// ***************************************** Start Training Module's Show
	// Training Status By Rajendra **************************************//

	public Map<String, Object> showTrainingStatusJsp(int currentUserId) {
		List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
		List<HrMasTrainingStatus> trainingStatusList = new ArrayList<HrMasTrainingStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<UserManager> userManagerList = new ArrayList<UserManager>();
		List subordinatesList = new ArrayList();
		List<HrTrainingApprovalStatus> trainingApprovalStatusList = new ArrayList<HrTrainingApprovalStatus>();
		Session session = getSession();

		Criteria criteria = session.createCriteria(UserManager.class);
		criteria = criteria.add(Restrictions.eq("ManagerId", currentUserId));
		userManagerList = criteria.list();

		for (UserManager userManager : userManagerList) {
			subordinatesList.add(userManager.getUsers().getId());
		}

		Map<String, Object> generalMap = new HashMap<String, Object>();
		UserManager userManager = new UserManager();
		HrTrainingRequisition hrTrainingRequisition = new HrTrainingRequisition();

		List<HrTrainingApprovalStatus> hrTrainingApprovalList = new ArrayList<HrTrainingApprovalStatus>();

		try {
			Criteria crit = session
					.createCriteria(HrTrainingApprovalStatus.class);

			crit = crit.add(Restrictions.eq("Status", "y"));
			hrTrainingApprovalList = crit.list();
			for (HrTrainingApprovalStatus hrTrainingApprovalStatus : hrTrainingApprovalList) {
				searchTrainingRequisitionList.add(hrTrainingApprovalStatus
						.getHrTrainingRequisition());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchTrainingRequisitionList",
				searchTrainingRequisitionList);

		return generalMap;

	}

	public Map<String, Object> showTrainingApprovalStatus(Date fromDate,
			Date toDate, int currentUserId) {

		List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();
		List<HrMasTrainingStatus> trainingStatusList = new ArrayList<HrMasTrainingStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<UserManager> userManagerList = new ArrayList<UserManager>();
		List subordinatesList = new ArrayList();

		List<HrTrainingApprovalStatus> trainingApprovalStatusList = new ArrayList<HrTrainingApprovalStatus>();
		Session session = getSession();

		Criteria criteria = session.createCriteria(UserManager.class);
		criteria = criteria.add(Restrictions.eq("ManagerId", currentUserId));
		userManagerList = criteria.list();

		for (UserManager userManager : userManagerList) {
			subordinatesList.add(userManager.getUsers().getId());
		}

		Map<String, Object> generalMap = new HashMap<String, Object>();
		UserManager userManager = new UserManager();
		HrTrainingRequisition hrTrainingRequisition = new HrTrainingRequisition();

		criteria = session.createCriteria(HrTrainingApprovalStatus.class);

		criteria = criteria.createAlias("HrTrainingRequisition", "TR");

		criteria = criteria
				.add(Restrictions.ge("TR.RequisitionDate", fromDate));
		criteria = criteria.add(Restrictions.le("TR.RequisitionDate", toDate));

		criteria = criteria.add(Restrictions.eq("Status", "y"));
		trainingApprovalStatusList = criteria.list();

		for (HrTrainingApprovalStatus hrTrainingApprovalStatus : trainingApprovalStatusList) {
			searchTrainingRequisitionList.add(hrTrainingApprovalStatus
					.getHrTrainingRequisition());
		}

		generalMap.put("searchTrainingRequisitionList",
				searchTrainingRequisitionList);
		generalMap.put("trainingStatusList", trainingStatusList);

		return generalMap;
	}

	@SuppressWarnings("uncheked")
	public List<HrTrainingRequisition> getTrainingRequisitionList(
			int currentUserId) {
		List<HrTrainingRequisition> searchTrainingRequisitionList = new ArrayList<HrTrainingRequisition>();

		List<HrMasTrainingStatus> trainingStatusList = new ArrayList<HrMasTrainingStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<UserManager> userManagerList = new ArrayList<UserManager>();
		List subordinatesList = new ArrayList();

		Session session = getSession();

		Criteria criteria = session.createCriteria(UserManager.class);
		criteria = criteria.add(Restrictions.eq("ManagerId", currentUserId));
		userManagerList = criteria.list();

		for (UserManager userManager : userManagerList) {
			subordinatesList.add(userManager.getUsers().getId());
		}

		Map<String, Object> generalMap = new HashMap<String, Object>();
		UserManager userManager = new UserManager();
		HrTrainingRequisition hrTrainingRequisition = new HrTrainingRequisition();

		List<HrTrainingApprovalStatus> hrTrainingApprovalList = new ArrayList<HrTrainingApprovalStatus>();

		Criteria criteria2 = session
				.createCriteria(HrMasApplicationLevel.class);
		criteria2 = criteria2.add(Restrictions.eq("Application.Id", "A1"));

		List applicationLevelList = criteria2.list();
		HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel) applicationLevelList
				.get(0);
		MasRank intermediateApproverDesignation = applicationLevel
				.getIntermediateApproverDesignation();
		MasRank finalApproverDesignation = applicationLevel
				.getFinalApproverDesignation();

		try {
			Criteria crit = session
					.createCriteria(HrTrainingApprovalStatus.class);

			if (currentUserId != (finalApproverDesignation.getId())) {
				if (currentUserId != 0) {
					crit = crit.add(Restrictions.eq("ToBeApproved.Id",
							currentUserId));
					crit = crit.add(Restrictions.le("CurrentLevel", 1));
				}
			}

			if (currentUserId == (finalApproverDesignation.getId())) {
				crit = crit.add(Restrictions.eq("CurrentLevel", 2));
				crit = crit.add(Restrictions.ne("TrainingStatus.Id", 6));
				crit = crit.add(Restrictions.ne("TrainingStatus.Id",
						finalApproverDesignation.getId()));
			}

			crit = crit.add(Restrictions.eq("Status", "y"));
			hrTrainingApprovalList = crit.list();
			for (HrTrainingApprovalStatus hrTrainingApprovalStatus : hrTrainingApprovalList) {
				searchTrainingRequisitionList.add(hrTrainingApprovalStatus
						.getHrTrainingRequisition());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchTrainingRequisitionList;
	}

	// *********************************************** Start Training Module's
	// Training Scheduling By Rajendra
	// ***********************************************************************************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showTrainingSchedulingJsp() {
		List<HrTrainingSchedule> searchTrainingScheduleList = new ArrayList<HrTrainingSchedule>();

		List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
		List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();

		List<HrMasInstructor> instructorMasterList = new ArrayList<HrMasInstructor>();
		List<HrMasInstructor> gridInstructorMasterList = new ArrayList<HrMasInstructor>();
		List<MasRank> desigList = new ArrayList<MasRank>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		Session session = getSession();

		Criteria criteria = session.createCriteria(HrTrainingSchedule.class);
		searchTrainingScheduleList = criteria.list();

		Criteria critm = session.createCriteria(HrMasTraining.class);
		critm = critm.add(Restrictions.eq("Status", "y").ignoreCase());
		trainingMasterList = critm.list();

		Criteria critm1 = session.createCriteria(HrMasTraining.class);
		gridTrainingMasterList = critm1.list();

		Criteria criim = session.createCriteria(HrMasInstructor.class);
		criim = criim.add(Restrictions.eq("Status", "y").ignoreCase());
		instructorMasterList = criim.list();

		Criteria criim1 = session.createCriteria(HrMasInstructor.class);
		gridInstructorMasterList = criim1.list();
		
		desigList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();

		generalMap
				.put("searchTrainingScheduleList", searchTrainingScheduleList);
		generalMap.put("trainingMasterList", trainingMasterList);
		generalMap.put("gridTrainingMasterList", gridTrainingMasterList);

		generalMap.put("instructorMasterList", instructorMasterList);
		generalMap.put("gridInstructorMasterList", gridInstructorMasterList);
		generalMap.put("desigList", desigList);

		return generalMap;
	}
	
	//VKS

	public Map<String,Object> saveVacancyPosition(HrVacancyPost hrvp, Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		Map<String,Object> map=new HashMap<String, Object>();
		HrInstitutionalSanctionedPost hrPost=new HrInstitutionalSanctionedPost();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hrPost=(HrInstitutionalSanctionedPost)hbt.get(HrInstitutionalSanctionedPost.class, (Integer)dataMap.get("postId"));
		hrPost.setStatus((String)dataMap.get("status"));
		hbt.update(hrPost);
		hbt.save(hrvp);
		successfullyAdded = true;
        map.put("successfullyAdded", successfullyAdded);
		return map;
	}

 //VKS
  @SuppressWarnings("unchecked")
  public  Map<String,Object>showVacancyPositionJsp(Map<String, Object> generalMap){
	  List<MasHospital> institutionList=new ArrayList<MasHospital>();
	  List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	  List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
	  List<MasEmployeeDepartment> deptpartmentList=new ArrayList<MasEmployeeDepartment>();
	  List<Object[]> list = new ArrayList<Object[]>();
	  List<HrInstitutionalSanctionedPost> hrInstitutionalSanctionedPosts=new ArrayList<HrInstitutionalSanctionedPost>();
	  List<MasRank> designationList=new ArrayList<MasRank>();
	  List<MasCadre> cadreList=new ArrayList<MasCadre>();
	  Session session = getSession();
	  institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	  mhospitalTypetList=session.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	 //System.out.println("mHospitalTypeList>>>>>>>>>"+mhospitalTypetList.size());
	 masDistrictList=session.createCriteria(MasDistrict.class).addOrder(Order.asc("DistrictName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		String hql="select hisp.cadre_id,mr.rank_name,mh.hospital_name,md.department_name,hisp.permanent_post,hisp.temporary_post,hisp.supernumerary_post,hisp.* from hr_institutional_sanctioned_post hisp LEFT OUTER JOIN mas_cadre mcdr ON mcdr.cadre_id=hisp.cadre_id LEFT OUTER JOIN mas_rank mr ON mr.cadre_id=hisp.cadre_id LEFT OUTER JOIN mas_hospital mh ON mh.hospital_id=hisp.institution_id LEFT OUTER JOIN mas_department md ON md.department_id=hisp.department_id";
         list = (List) session.createSQLQuery(hql).list();
	deptpartmentList =  session.createCriteria(MasEmployeeDepartment.class).addOrder(Order.asc("EmpDeptName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	designationList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	cadreList = session.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	 Criteria hrISP=session.createCriteria(HrInstitutionalSanctionedPost.class)
			 .createAlias("Institution", "ins").createAlias("Department", "d").createAlias("Rank", "r").createAlias("Cadre", "c")
			 .add(Restrictions.eq("Status", "y"));
	 if(generalMap.get("institute")!=null){
		 hrISP.add(Restrictions.eq("ins.Id", (Integer)generalMap.get("institute")));
	 }
	 if(generalMap.get("department")!=null){
		 hrISP.add(Restrictions.eq("d.Id", (Integer)generalMap.get("department")));
	 }
	 if(generalMap.get("designation")!=null){
		 hrISP.add(Restrictions.eq("r.Id", (Integer)generalMap.get("designation")));
	 }
	 if(generalMap.get("cadre")!=null){
		 hrISP.add(Restrictions.eq("c.Id", (Integer)generalMap.get("cadre")));
	 }
	 hrInstitutionalSanctionedPosts=hrISP.list();
  generalMap.put("institutionList", institutionList);
  generalMap.put("mhospitalTypetList", mhospitalTypetList );
  generalMap.put("masDistrictList", masDistrictList);
  generalMap.put("deptpartmentList", deptpartmentList);
  generalMap.put("designationList", designationList);
  generalMap.put("hrInstitutionalSanctionedPosts", hrInstitutionalSanctionedPosts); 
  generalMap.put("cadreList", cadreList);
//  generalMap.put("list", list);

return generalMap;
}
	  
//VKS
  @SuppressWarnings("unchecked")
public  Map<String,Object>searchVacancyPositionJsp(Map<String,Object>map){
	  Map<String,Object> generalMap=new HashMap<String, Object>();
	  List<HrVacancyPost> vaclist=new ArrayList<HrVacancyPost>();
	  Session session =(Session)getSession();

	  int institute=(Integer)map.get("institute");
	  int department=(Integer)map.get("department");
	  int designation=(Integer) map.get("designation");
	  int  cadre= (Integer)map.get("cadre");
	System.out.println(institute+"------"+department+"------"+designation+"------"+cadre);
	  Criteria cri=session.createCriteria(HrVacancyPost.class,"vac")
			       .createAlias("vac.SanctionedPost", "sanctionedPost").createAlias("sanctionedPost.Department","department")
			       .createAlias("sanctionedPost.Institution","institution").createAlias("sanctionedPost.Rank","rank").createAlias("sanctionedPost.Cadre","cadre");
	  		if(institute>0)
	  			cri.add(Restrictions.eq("institution.Id", institute));
			 if(department>0)     	
			      	cri.add(Restrictions.eq("department.Id", department));
			  if(designation>0)    	
			      	cri.add(Restrictions.eq("rank.Id", designation));
			   if(cadre>0)	
			      	cri.add(Restrictions.eq("cadre.Id", cadre));
	  
	  vaclist=cri.add(Restrictions.eq("Status", "y")).list();
	  System.out.println("list"+vaclist.size());
	  List<HrInstitutionalSanctionedPost> hrInstitutionalSanctionedPost = new ArrayList<HrInstitutionalSanctionedPost>(); 
	  HrInstitutionalSanctionedPost hisp=new HrInstitutionalSanctionedPost(); 
      List<MasHospital> institutionList=new ArrayList<MasHospital>();
 	  List<MasEmployeeDepartment> deptpartmentList=new ArrayList<MasEmployeeDepartment>();
 	  List<MasRank> designationList=new ArrayList<MasRank>();
 	  List<MasCadre> cadreList=new ArrayList<MasCadre>();  
	  institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	  deptpartmentList=session.createCriteria(MasEmployeeDepartment.class).addOrder(Order.asc("EmpDeptName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	  designationList=session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	  cadreList=session.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status", "y").ignoreCase()).list(); 
	 
	  generalMap.put("institutionList", institutionList);
	  generalMap.put("deptpartmentList", deptpartmentList);
	  generalMap.put("designationList", designationList);
	  generalMap.put("cadreList", cadreList);
	  generalMap.put("hrInstitutionalSanctionedPost", hrInstitutionalSanctionedPost); 
	  generalMap.put("vaclist", vaclist);
	  
	   return generalMap;
}
  
  
  //VKS
  @SuppressWarnings("unchecked")
  public  Map<String,Object>showTransferProcessingJsp(Map<String, Object> generalMap){
	  Session session=(Session)getSession();
	  List<MasHospital> institutionList=new ArrayList<MasHospital>();
	  List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
	  List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	  List<MasEmployeeDepartment> deptpartmentList=new ArrayList<MasEmployeeDepartment>();
	  List<HrVacancyPost> hrVacancyPosts = new ArrayList<HrVacancyPost>();
	  List<MasRank> designationList=new ArrayList<MasRank>();
	  List<MasCadre> cadreList=new ArrayList<MasCadre>();
	  institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	  masDistrictList=session.createCriteria(MasDistrict.class).addOrder(Order.asc("DistrictName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	  
	  mhospitalTypetList=session.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	  
	  Criteria  vp=session.createCriteria(HrVacancyPost.class,"vp").createAlias("vp.Hospital", "h").createAlias("vp.SanctionedPost", "sp")
				.createAlias("sp.Institution", "ins").createAlias("sp.Department", "d").createAlias("sp.Rank", "r");
		if(generalMap.get("instituteId")!=null){
			vp.add(Restrictions.eq("ins.Id", (Integer)generalMap.get("instituteId")));
		}
		if(generalMap.get("departmentId")!=null){
			vp.add(Restrictions.eq("d.Id", (Integer)generalMap.get("departmentId")));		
		}
		if(generalMap.get("designationId")!=null){
			vp.add(Restrictions.eq("r.Id", (Integer)generalMap.get("designationId")));
		}
//		if(generalMap.get("hospitalId")!=null){
//			vp.add(Restrictions.eq("h.Id", (Integer)generalMap.get("hospitalId")));
//		}
		hrVacancyPosts=vp.add(Restrictions.or(Restrictions.isNull("BalancePost"), Restrictions.ge("BalancePost", 1))).list();
	deptpartmentList =  session.createCriteria(MasEmployeeDepartment.class).addOrder(Order.asc("EmpDeptName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	designationList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	 cadreList = session.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	System.out.println("cadreList>>>cadreList"+cadreList.size()); 
	 
generalMap.put("institutionList", institutionList);
generalMap.put("mhospitalTypetList", mhospitalTypetList);
generalMap.put("masDistrictList", masDistrictList);
generalMap.put("deptpartmentList", deptpartmentList);
generalMap.put("designationList", designationList);
generalMap.put("cadreList", cadreList);
generalMap.put("hrVacancyPosts", hrVacancyPosts);

return generalMap;
}
  	@Override
  	public Map<String, Object> showTransferProcessingDetailsJsp(
  			Map<String, Object> dataMap) {
  		Session session=(Session)getSession();
  		Map<String, Object> map=new HashMap<String, Object>();
  		List<HrVacancyPost> hrVacancyPosts = new ArrayList<HrVacancyPost>();
//  	List<HrTransferApplicationM> hrTransferApplicationMs = new ArrayList<HrTransferApplicationM>();
  		List<HrTransferApplicationT> hrTransferApplicationTs = new ArrayList<HrTransferApplicationT>();
  		int userType=(Integer) dataMap.get("userType");
  if(dataMap.get("userType").equals(1) )
  		 {
	    Criteria  vp=session.createCriteria(HrVacancyPost.class,"vp");
  		if(dataMap.get("requestId")!=null){
			vp.add(Restrictions.eq("vp.Id", (Integer)dataMap.get("requestId")));
		}
		Criteria transferApplication=session.createCriteria(HrTransferApplicationT.class).createAlias("Institute", "i");
		if(dataMap.get("requestHospitalId")!=null){
			transferApplication.add(Restrictions.eq("i.Id", (Integer)dataMap.get("requestHospitalId")));
		}
		if(dataMap.get("rankId")!=null){
			transferApplication.createAlias("TransferApp", "m").createAlias("m.Employee", "e")
			.createAlias("e.Rank", "r").add(Restrictions.eq("m.TransferStstus", "f"))
			.add(Restrictions.eq("r.Id", (Integer)dataMap.get("rankId"))).addOrder(Order.asc("e.JoinDate"));
		}
  		hrVacancyPosts=vp.list();
		hrTransferApplicationTs=transferApplication.list();
  	}
  else{
  		 Criteria  vp=session.createCriteria(HrVacancyPost.class,"vp");
   		if(dataMap.get("requestId")!=null){
 			vp.add(Restrictions.eq("vp.Id", (Integer)dataMap.get("requestId")));
 		}
 		Criteria transferApplication=session.createCriteria(HrTransferApplicationT.class).createAlias("Institute", "i");
 		if(dataMap.get("requestHospitalId")!=null){
 			transferApplication.add(Restrictions.eq("i.Id", (Integer)dataMap.get("requestHospitalId")));
 		}
 		if(dataMap.get("rankId")!=null){
 			transferApplication.createAlias("TransferApp", "m").createAlias("m.Employee", "e")
 			.createAlias("e.Rank", "r").add(Restrictions.isNull("m.TransferStstus"))
 			.add(Restrictions.eq("r.Id", (Integer)dataMap.get("rankId"))).addOrder(Order.asc("e.JoinDate"));	
 		}	 
   		hrVacancyPosts=vp.list();
 		hrTransferApplicationTs=transferApplication.list();		
  	}
        map.put("hrVacancyPosts", hrVacancyPosts);
		map.put("hrTransferApplicationTs", hrTransferApplicationTs);
		map.put("userType", userType);  
  		return map;
  	}
	   
  
	@Override
	public Map<String, Object> saveProcessingDetails(
			Map<String, Object> details, Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String msg="";
		Transaction tx=null;
		Session session=(Session)getSession();
		try{
			tx=session.beginTransaction();
			int count=box.getInt("count");
			int vacancyPostId=box.getInt("vacancyPostId");
			HrVacancyPost hrVacancyPost=new HrVacancyPost();
			for(int i=1;i<count;i++){
				if(box.getInt("EmployeeName"+i)>0){
				HrTransferApplicationM hrTransferApplicationM=new HrTransferApplicationM();
				hrVacancyPost=(HrVacancyPost)hbt.get(HrVacancyPost.class, vacancyPostId);
				hrTransferApplicationM=(HrTransferApplicationM)hbt.get(HrTransferApplicationM.class, box.getInt("EmployeeName"+i));
				hrTransferApplicationM.setTransferStstus("p");
				hrTransferApplicationM.setStatus("p");
				MasHospital masHospital=new MasHospital();
				masHospital.setId(box.getInt("requestHospitalId"));
				hrTransferApplicationM.setTrHospital(masHospital);
				int balancePost=1;
				int allocatedPost=0;
				if(hrVacancyPost.getBalancePost()!=null){
					balancePost=hrVacancyPost.getBalancePost();
				}
				if(hrVacancyPost.getAllocatedPost()!=null){
					allocatedPost=hrVacancyPost.getAllocatedPost();
				}
				hrVacancyPost.setAllocatedPost(allocatedPost+1);
				hrVacancyPost.setBalancePost(hrVacancyPost.getVpermanentPost()-hrVacancyPost.getAllocatedPost());
				hbt.update(hrVacancyPost);
				hbt.update(hrTransferApplicationM);
				}
			}
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg="Successfully Saved.";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				msg="Try Again.";
				tx.rollback();
			}
		}
		map.put("msg", msg);
		return map;
	}
	
	//Kaushal Mishra
	
	@Override
	public Map<String, Object> forwardProcessingDetails(Map<String, Object> dataMap, Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String msg="";
		Transaction tx=null;
		Session session=(Session)getSession();
		try{
			tx=session.beginTransaction();
			int count=box.getInt("count");
			int vacancyPostId=box.getInt("vacancyPostId");
			HrVacancyPost hrVacancyPost=new HrVacancyPost();
			for(int i=1;i<count;i++){
				if(box.getInt("EmployeeName"+i)>0){
				HrTransferApplicationM hrTransferApplicationM=new HrTransferApplicationM();
				hrVacancyPost=(HrVacancyPost)hbt.get(HrVacancyPost.class, vacancyPostId);
				System.out.println(box.getInt("EmployeeName"+i)+"============");
				
				hrTransferApplicationM=(HrTransferApplicationM)hbt.get(HrTransferApplicationM.class, box.getInt("EmployeeName"+i));
				hrTransferApplicationM.setTransferStstus("f");
				hrTransferApplicationM.setStatus("f");
				MasHospital masHospital=new MasHospital();
				masHospital.setId(box.getInt("requestHospitalId"));
				hrTransferApplicationM.setTrHospital(masHospital);
				hbt.update(hrTransferApplicationM);
				}
			}
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg="Successfully Forwarded.";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				msg="Try Again.";
				tx.rollback();
			}
		}
		map.put("msg", msg);
		return map;
	}
	
	
	@Override
	public Map<String, Object> cancelApprovalDetails(Map<String, Object> dataMap, Box box) {
		  Session session=(Session)getSession();
		  List<HrTransferApproved> hrApprovalList = new ArrayList<HrTransferApproved>();
		  
		  List<MasHospital> institutionList=new ArrayList<MasHospital>();
		  List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
		  List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		  List<MasEmployeeDepartment> deptpartmentList=new ArrayList<MasEmployeeDepartment>();
		  List<MasRank> designationList=new ArrayList<MasRank>();
		  List<MasCadre> cadreList=new ArrayList<MasCadre>();
		  
		 masDistrictList=session.createCriteria(MasDistrict.class,"md").createAlias("md.State", "s")
				  .addOrder(Order.asc("md.DistrictName")).add(Restrictions.eq("md.Status", "y").ignoreCase()).add(Restrictions.eq("s.Id", 32)).list();
		  
		  mhospitalTypetList=session.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		  
		  institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
		  
		  Criteria  ad=session.createCriteria(HrTransferApproved.class,"ha").createAlias("ha.TransferApp", "ht").createAlias("ha.Hospital", "h").createAlias("ha.Employee", "e")
		  .createAlias("e.EmployeeDepartment", "d").createAlias("e.Rank", "r");
		  
		    if(dataMap.get("instituteId")!=null){
				ad.add(Restrictions.eq("h.Id", (Integer)dataMap.get("instituteId")));
			}
			if(dataMap.get("departmentId")!=null){
				ad.add(Restrictions.eq("d.Id", (Integer)dataMap.get("departmentId")));		
			}
			if(dataMap.get("designationId")!=null){
				ad.add(Restrictions.eq("r.Id", (Integer)dataMap.get("designationId")));
			}

		hrApprovalList=ad.add( Restrictions.or(Restrictions.eq("ha.Status","y").ignoreCase(), Restrictions.eq("ha.Status","r").ignoreCase())).list();
		System.out.println("Approval size"+hrApprovalList.size());
		
		deptpartmentList =  session.createCriteria(MasEmployeeDepartment.class).addOrder(Order.asc("EmpDeptName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
		designationList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
		cadreList = session.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
		
		dataMap.put("institutionList", institutionList);
		dataMap.put("mhospitalTypetList", mhospitalTypetList);
		dataMap.put("masDistrictList", masDistrictList);
		dataMap.put("deptpartmentList", deptpartmentList);
		dataMap.put("designationList", designationList);
		dataMap.put("cadreList", cadreList);
		dataMap.put("hrApprovalList", hrApprovalList);

	return dataMap;
}
	
	
	@Override
	public Map<String, Object> cancelApproval(Map<String, Object> dataMap, Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String msg="";
		Transaction tx=null;
		Session session=(Session)getSession();
		try{
			tx=session.beginTransaction();
			int count=box.getInt("count");
		for(int i=1;i<count;i++)
		{
			int approvedId=box.getInt("EmployeeName"+i);
				if(approvedId>0)
				{
				HrTransferApproved hrTransferApproved=new HrTransferApproved();
				hrTransferApproved=(HrTransferApproved)hbt.get(HrTransferApproved.class, approvedId);
				hrTransferApproved.setStatus("c");
						
				HrTransferApplicationM hrTransferApplicationM=new HrTransferApplicationM();
				hrTransferApplicationM=(HrTransferApplicationM)hbt.get(HrTransferApplicationM.class, hrTransferApproved.getTransferApp().getId());
				hrTransferApplicationM.setTransferStstus("n");
				hrTransferApplicationM.setStatus("n");
				
				MasEmployee masEmployee=new MasEmployee();
				masEmployee=(MasEmployee)hbt.get(MasEmployee.class, hrTransferApplicationM.getEmployee().getId());
				masEmployee.setEmpStatusId(6);
				masEmployee.setStatus("n");
			
				hbt.update(masEmployee);
				hbt.update(hrTransferApplicationM);
				hbt.update(hrTransferApproved);
				}
			}
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg=" Approval Cancelled Successfully.";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				msg="Try Again.";
				tx.rollback();
			}
		}
		map.put("msg", msg);
		return map;
	}
	

	@Override
	public Map<String, Object> inactiveEmployeeDetails(Map<String, Object> dataMap, Box box) {
		  Session session=(Session)getSession();
		  List<HrTransferApproved> inactiveEmpList = new ArrayList<HrTransferApproved>();
		  
		  List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
		  List<MasHospital> institutionList=new ArrayList<MasHospital>();
		  List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		  
		  masDistrictList=session.createCriteria(MasDistrict.class,"md").createAlias("md.State", "s")
				  .addOrder(Order.asc("md.DistrictName")).add(Restrictions.eq("md.Status", "y").ignoreCase()).add(Restrictions.eq("s.Id", 32)).list();
		  
		  
		  institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
		  mhospitalTypetList=session.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		  
		  Criteria  ie=session.createCriteria(HrTransferApproved.class,"ha").createAlias("ha.TransferApp", "ht").createAlias("ha.Hospital", "h").createAlias("ha.Employee", "e")
				  .createAlias("e.EmployeeDepartment", "d").createAlias("e.Rank", "r");
		
		  inactiveEmpList=ie.add(Restrictions.and(Restrictions.eq("ha.Status","c").ignoreCase(),Restrictions.eq("e.EmpStatusId",6))).list();
		
			
		   System.out.println("inactiveEmp size"+inactiveEmpList.size());
		
		   dataMap.put("masDistrictList", masDistrictList);
		   dataMap.put("institutionList", institutionList);
		   dataMap.put("mhospitalTypetList", mhospitalTypetList);
		   dataMap.put("inactiveEmpList", inactiveEmpList);

	return dataMap;
}
	
	@Override
	public Map<String, Object> assignHospitalToEmployee(Map<String, Object> dataMap, Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String msg="";
		Transaction tx=null;
		Session session=(Session)getSession();
		try{
			tx=session.beginTransaction();
			int approvedId=box.getInt("approvedId");
			int employeeId=box.getInt("employeeId");
			int institute=box.getInt("institute");
			int district=box.getInt("district");
			String joiningDate=box.getString("joiningDate");
		
				if(approvedId>0)
				{
					System.out.println(approvedId);
					//System.out.println(employeeId);
			    HrTransferApproved hrTransferApproved=new HrTransferApproved();
				hrTransferApproved=(HrTransferApproved)hbt.get(HrTransferApproved.class, approvedId);
				MasHospital masHospital=new MasHospital();
				masHospital.setId(institute);
				hrTransferApproved.setTransferInstitute(masHospital);
				MasDistrict masDistrict= new MasDistrict();
				masDistrict.setId(district);
				hrTransferApproved.setTransferDistrict(masDistrict);
				hrTransferApproved.setStatus("r");
				hrTransferApproved.setJoiningDate(HMSUtil.convertStringTypeDateToDateType(joiningDate));
					
				HrTransferApplicationM hrTransferApplicationM=new HrTransferApplicationM();
				hrTransferApplicationM=(HrTransferApplicationM)hbt.get(HrTransferApplicationM.class, hrTransferApproved.getTransferApp().getId() );
				hrTransferApplicationM.setTransferStstus("r");
				hrTransferApplicationM.setStatus("r");
				MasEmployee masEmployee=new MasEmployee();
				masEmployee=(MasEmployee)hbt.get(MasEmployee.class,employeeId);
				masEmployee.setEmpStatusId(1);
				
				hbt.update(masEmployee);
				hbt.update(hrTransferApplicationM);
				hbt.update(hrTransferApproved);
				
				}
			
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg=" Hospital Assigned To Employee Successfully.";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				msg="Try Again.";
				tx.rollback();
			}
		}
		map.put("msg", msg);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	/*public boolean addTrainingScheduling(HrTrainingSchedule hrTrainingSchedule) {*/
	public Map addTrainingScheduling(HrTrainingSchedule hrTrainingSchedule) {
		boolean successfullyAdded = false;
		Map m = new HashMap();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrTrainingSchedule);
		successfullyAdded = true;
		m.put("successfullyAdded",successfullyAdded);
		m.put("hrTrainingSchedule",hrTrainingSchedule);

		//return successfullyAdded;
		return m; 
	}

	@SuppressWarnings("unchecked")
	public boolean editTrainingScheduling(Map<String, Object> generalMap) {

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		HttpSession session = null;
		int hospitalId = 0;

		Integer trainingSchedulingId = null;
		Integer trainingId = null;
		Integer instructorId = null;
		Date scheduleDate = new Date();
		Date trainingStartDate = null;
		Date trainingEndDate = null;
		String trainingTime = "";
		String trainingDuration = "";
		int classSize = 0;
		String trainingAddress = "";
		String remarks = "";
		boolean dataUpdated = false;

		try {
			trainingSchedulingId = (Integer) generalMap
					.get("trainingSchedulingId");
			trainingId = (Integer) generalMap.get("trainingId");
			instructorId = (Integer) generalMap.get("instructorId");
			scheduleDate = (Date) generalMap.get("scheduleDate");
			trainingStartDate = (Date) generalMap.get("trainingStartDate");
			trainingEndDate = (Date) generalMap.get("trainingEndDate");
			trainingTime = (String) generalMap.get("trainingTime");
			trainingDuration = (String) generalMap.get("trainingDuration");
			classSize = (Integer) generalMap.get("classSize");
			trainingAddress = (String) generalMap.get("trainingAddress");
			remarks = (String) generalMap.get("remarks");

			hospitalId = (Integer) generalMap.get("hospitalId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			HrTrainingSchedule hrTrainingSchedule = (HrTrainingSchedule) getHibernateTemplate()
					.load(HrTrainingSchedule.class, trainingSchedulingId);

			if (trainingId != null) {
				HrMasTraining masTraining = new HrMasTraining();
				masTraining.setId(trainingId);
				hrTrainingSchedule.setTraining(masTraining);
			}

			if (instructorId != null) {
				HrMasInstructor hrMasInstructor = new HrMasInstructor();
				hrMasInstructor.setId(instructorId);
				hrTrainingSchedule.setInstructor(hrMasInstructor);
			}

			hrTrainingSchedule.setId(trainingSchedulingId);
			hrTrainingSchedule.setTrainingDate(scheduleDate);

			if (trainingStartDate != null) {
				hrTrainingSchedule.setTrainingStartDate(trainingStartDate);
			}
			if (trainingEndDate != null) {
				hrTrainingSchedule.setTrainingEndDate(trainingEndDate);
			}

			hrTrainingSchedule.setTrainingTime(trainingTime);
			hrTrainingSchedule.setDuration(trainingDuration);
			hrTrainingSchedule.setClassSize(classSize);
			hrTrainingSchedule.setAddress(trainingAddress);
			hrTrainingSchedule.setRemarks(remarks);

			if (hospitalId != 0) {
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				hrTrainingSchedule.setCompany(masHospital);
			}

			hrTrainingSchedule.setLastChgBy(changedBy);
			hrTrainingSchedule.setLastChgDate(currentDate);
			hrTrainingSchedule.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrTrainingSchedule);
			dataUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTrainingScheduling(int trainingSchedulingId,
			Map<String, Object> generalMap) {
		String message = null;
		String changedBy = "";
		String currentTime = "";
		Date currentDate = null;
		String flag = "";
		boolean dataDeleted = false;

		try {
			HrTrainingSchedule hrTrainingSchedule = (HrTrainingSchedule) getHibernateTemplate()
					.load(HrTrainingSchedule.class, trainingSchedulingId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrTrainingSchedule.getStatus().equals("y")) {
				hrTrainingSchedule.setStatus("n");
				dataDeleted = true;
			} else {
				hrTrainingSchedule.setStatus("y");
				dataDeleted = false;
			}
			hrTrainingSchedule.setLastChgBy(changedBy);
			hrTrainingSchedule.setLastChgDate(currentDate);
			hrTrainingSchedule.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrTrainingSchedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map<String, Object> showTrainingScheduling(Date fromDate, Date toDate) {
		List<HrTrainingSchedule> searchTrainingScheduleList = new ArrayList<HrTrainingSchedule>();

		List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
		List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();

		List<HrMasInstructor> instructorMasterList = new ArrayList<HrMasInstructor>();
		List<HrMasInstructor> gridInstructorMasterList = new ArrayList<HrMasInstructor>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		Session session = getSession();

		Criteria criteria = session.createCriteria(HrTrainingSchedule.class);
		criteria = criteria.add(Restrictions.between("TrainingDate", fromDate,
				toDate));
		searchTrainingScheduleList = criteria.list();

		Criteria critm = session.createCriteria(HrMasTraining.class);
		critm = critm.add(Restrictions.eq("Status", "y"));
		trainingMasterList = critm.list();

		Criteria critm1 = session.createCriteria(HrMasTraining.class);
		gridTrainingMasterList = critm1.list();

		Criteria criim = session.createCriteria(HrMasInstructor.class);
		criim = criim.add(Restrictions.eq("Status", "y"));
		instructorMasterList = criim.list();

		Criteria criim1 = session.createCriteria(HrMasInstructor.class);
		gridInstructorMasterList = criim1.list();

		generalMap
				.put("searchTrainingScheduleList", searchTrainingScheduleList);
		generalMap.put("trainingMasterList", trainingMasterList);
		generalMap.put("gridTrainingMasterList", gridTrainingMasterList);

		generalMap.put("instructorMasterList", instructorMasterList);
		generalMap.put("gridInstructorMasterList", gridInstructorMasterList);

		return generalMap;
	}

	// *********************************************** Start Training Module's
	// Training Intimation By Rajendra
	// ***********************************************************************************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showTrainingIntimationJsp() {
		List<HrTrainingSchedule> searchTrainingScheduleList = new ArrayList<HrTrainingSchedule>();

		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		Session session = getSession();

		Criteria criteria = session.createCriteria(HrTrainingSchedule.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		searchTrainingScheduleList = criteria.list();

		Criteria crtLocation = session.createCriteria(MasLocation.class);
		crtLocation = crtLocation.add(Restrictions.eq("Status", "y"));
		locationList = crtLocation.list();

		Criteria crtDept = session.createCriteria(MasDepartment.class);
		crtDept = crtDept.add(Restrictions.eq("Status", "y"));
		departmentList = crtDept.list();

		Criteria crtEmp = session.createCriteria(MasEmployee.class);
		crtEmp = crtEmp.add(Restrictions.eq("Status", "y"));
		employeeList = crtEmp.list();

		generalMap
				.put("searchTrainingScheduleList", searchTrainingScheduleList);
		generalMap.put("locationList", locationList);
		generalMap.put("departmentList", departmentList);
		generalMap.put("employeeList", employeeList);

		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployeeList(boolean toAllEmp,
			int locationId, int departmentId, int employeeId) {

		List<MasEmployee> employeeTrainingList = new ArrayList<MasEmployee>();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		Session session = getSession();
		Criteria crtEmp = session.createCriteria(MasEmployee.class);

		if (toAllEmp == true) {
			crtEmp = crtEmp.add(Restrictions.eq("Status", "y"));
			employeeTrainingList = crtEmp.list();
		} else {
			if (locationId != 0) {
				crtEmp = crtEmp.add(Restrictions.eq("LocationId", locationId));
			}
			if (departmentId != 0) {
				crtEmp = crtEmp.createAlias("Department", "MD");
				crtEmp = crtEmp.add(Restrictions.eq("MD.Id", departmentId));
			}
			if (employeeId != 0) {
				crtEmp = crtEmp.add(Restrictions.eq("Id", employeeId));
			}
			crtEmp = crtEmp.add(Restrictions.eq("Status", "y"));
			employeeTrainingList = crtEmp.list();

		}
		generalMap.put("employeeTrainingList", employeeTrainingList);
		return generalMap;
	}
	// Start by Ramdular on 23-02-2011 For Training and Services Certificate
	// +++++
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showTrainingServiceCertificate() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	//	List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		
		List<HrTrainingService> hrTrainingServiceList= new ArrayList<HrTrainingService>();
		int doctor_id =1;
		
		//int deptId=(Integer)dataMap.get("deptId");
		int entry_num=0;
		List objectList=new ArrayList();
		String query="";
		String num="";
		String maxTrainingServiceNum="";
		
		String traingEntryNo="";
		Session session = getSession();
		hrTrainingServiceList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.HrTrainingService");
	
		query = "SELECT entry_number FROM hr_training_service " +
		"WHERE (training_service_id =(SELECT MAX(training_service_id) " +
		"FROM hr_training_service AS hr_training_service_1))";
							
    String traingEntryNo1="MS/VBCH/CERT/";
    String num1="";
	objectList = (List) session.createSQLQuery(query).list();
					
	if (objectList != null && objectList.size() > 0) {
						

	if (objectList.get(0) != null) 
	{

	maxTrainingServiceNum = ("" + objectList.get(0));
	num = ("" + maxTrainingServiceNum);
	num = getTraingEntryNum(num,traingEntryNo1);
} else {
	num = getTraingEntryNum(num,traingEntryNo1);
}
	}
	else
	{
		num = "MS/VBCH/CERT/1";
	}
						
	
	
		
		//-----------------------------------------xyz--------------------------
				
		
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).list();
		tileMap.put("titleList", titleList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("bloodGroupList", bloodGroupList);
		tileMap.put("max", num);
		tileMap.put("hrTrainingServiceList", hrTrainingServiceList);
		
	return tileMap;
	}
	public Map<String, Object> showCertificateStudentAdmission() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List objectList=new ArrayList();
		List<HrStudentCertificate> hrStudentCertificateList= new ArrayList<HrStudentCertificate>();
		
		int doctor_id =1;
		Session session = getSession();
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
		
		hrStudentCertificateList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.HrStudentCertificate");
		
		
		String num="";
		String query="";
		String maxTrainingServiceNum="";
		String traingEntryNo="";
		
		query = "SELECT entryNo FROM hr_student_certificate " +
		"WHERE (student_certificate_id =(SELECT MAX(student_certificate_id) " +
		"FROM hr_student_certificate AS hr_student_certificate_1))";
		
	    String traingEntryNo1="MS/VBCH/CERT/";
	    String num1="";
		objectList = (List) session.createSQLQuery(query).list();
						
		if (objectList != null && objectList.size() > 0) {
							
		if (objectList.get(0) != null) 
		{

		maxTrainingServiceNum = ("" + objectList.get(0));
		num = ("" + maxTrainingServiceNum);
		num = getTraingEntryNum(num,traingEntryNo1);
	} else {
		num = getTraingEntryNum(num,traingEntryNo1);
	}				
		}
		else
		{
			num = "MS/VBCH/CERT/1";
		}
		
		tileMap.put("titleList", titleList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("hrStudentCertificateList", hrStudentCertificateList);
		tileMap.put("max", num);
		
				
	return tileMap;
	
	}
	
	
	public Map<String, Object> showPatientFitnessCertificate() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List objectList=new ArrayList();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrPatientFitnessCertificate> hrPatientFitnessCertificateList= new ArrayList<HrPatientFitnessCertificate>();
		
		int doctor_id =1;
		Session session = getSession();
		
		hrPatientFitnessCertificateList= getHibernateTemplate().find(
		"from jkt.hms.masters.business.HrPatientFitnessCertificate");
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).add(Restrictions.ne("DepartmentType.id", 3)).list();
		
		String num="";
		String query="";
		String maxTrainingServiceNum="";
		String traingEntryNo="";
		
		query = "SELECT entryNo FROM hr_patient_fitness_certificate " +
		"WHERE (patient_fitness_certificate_id =(SELECT MAX(patient_fitness_certificate_id) " +
		"FROM hr_patient_fitness_certificate AS hr_patient_fitness_certificate_1))";
		
	    String traingEntryNo1="MS/VBCH/CERT/";
	    String num1="";
		objectList = (List) session.createSQLQuery(query).list();
						
		if (objectList != null && objectList.size() > 0) {
							
		if (objectList.get(0) != null) 
		{

		maxTrainingServiceNum = ("" + objectList.get(0));
		num = ("" + maxTrainingServiceNum);
		num = getTraingEntryNum(num,traingEntryNo1);
	} else {
		num = getTraingEntryNum(num,traingEntryNo1);
	}				
		}
		else
		{
			num = "MS/VBCH/CERT/1";
		}
		
		tileMap.put("titleList", titleList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("hrPatientFitnessCertificateList", hrPatientFitnessCertificateList);
		tileMap.put("departmentList", departmentList);
		tileMap.put("max", num);
		
	return tileMap;
	}
	public Map<String, Object> showPatientSicknessCertificate() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List objectList=new ArrayList();
		List<HrPatientSickCertificate> hrPatientSickCertificateList= new ArrayList<HrPatientSickCertificate>();
		Session session = getSession();
		
		hrPatientSickCertificateList= getHibernateTemplate().find("from jkt.hms.masters.business.HrPatientSickCertificate");
		
		
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		
		String num="";
		String query="";
		String maxTrainingServiceNum="";
		String traingEntryNo="";
		
		query = "SELECT entryNo FROM hr_patient_sick_certificate " +
		"WHERE (patient_sick_certificate_id =(SELECT MAX(patient_sick_certificate_id) " +
		"FROM hr_patient_sick_certificate AS hr_patient_sick_certificate_1))";
		
	    String traingEntryNo1="MS/VBCH/CERT/";
	    String num1="";
		objectList = (List) session.createSQLQuery(query).list();
						
		if (objectList != null && objectList.size() > 0) {
							
		if (objectList.get(0) != null) 
		{

		maxTrainingServiceNum = ("" + objectList.get(0));
		num = ("" + maxTrainingServiceNum);
		num = getTraingEntryNum(num,traingEntryNo1);
	} else {
		num = getTraingEntryNum(num,traingEntryNo1);
	}				
		}
		else
		{
			num = "MS/VBCH/CERT/1";
		}
		
		
		tileMap.put("titleList", titleList);
		tileMap.put("hrPatientSickCertificateList", hrPatientSickCertificateList);
		tileMap.put("max", num);		
		
	return tileMap;
	}
	public Map<String, Object> showMedicalCertificateFitnessFirstEntry() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int doctor_id =1;
		List objectList=new ArrayList();
		Session session = getSession();
		
		List<HrMedicalFitnessFirst> hrMedicalFitnessFirstList= new ArrayList<HrMedicalFitnessFirst>();
		
		hrMedicalFitnessFirstList= getHibernateTemplate().find("from jkt.hms.masters.business.HrMedicalFitnessFirst");
		
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeType.Id",doctor_id)).list();
		
		String num="";
		String query="";
		String maxTrainingServiceNum="";
		String traingEntryNo="";
		
		query = "SELECT entryNo FROM hr_medical_fitness_first " +
		"WHERE (medical_fitness_first_id =(SELECT MAX(medical_fitness_first_id) " +
		"FROM hr_medical_fitness_first AS hr_medical_fitness_first_1))";
		
	    String traingEntryNo1="MS/VBCH/CERT/";
	    String num1="";
		objectList = (List) session.createSQLQuery(query).list();
						
		if (objectList != null && objectList.size() > 0) {
							
		if (objectList.get(0) != null) 
		{

		maxTrainingServiceNum = ("" + objectList.get(0));
		num = ("" + maxTrainingServiceNum);
		num = getTraingEntryNum(num,traingEntryNo1);
	} 
		else 
		{
		num = getTraingEntryNum(num,traingEntryNo1);
	}				
		}
		else
		{
			num = "MS/VBCH/CERT/1";
		}
		
		tileMap.put("titleList", titleList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("hrMedicalFitnessFirstList", hrMedicalFitnessFirstList);
		tileMap.put("max", num);
		
		return tileMap;
		
	}
	
	public Map<String, Object> showMedicalExaminationReport() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		
		int doctor_id =1;
		Session session = getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeType.Id",doctor_id)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).list();
		tileMap.put("departmentList", departmentList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("bloodGroupList", bloodGroupList);
		
	return tileMap;
	}
	
	public Map<String, Object> showMedicalExamEntry() {
		Map<String, Object> tileMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Session session = getSession();
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
		int doctor_id =1;
		employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee");
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).list();
		tileMap.put("departmentList", departmentList);
		tileMap.put("employeeList", employeeList);
		tileMap.put("doctorList", doctorList);
		tileMap.put("bloodGroupList", bloodGroupList);
		
	return tileMap;
	}
	
	
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	public Map<String, Object> showTrainingScheduleReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasTraining> masTrainingList = new ArrayList<HrMasTraining>();
		List<HrMasInstructor> masInstructorList = new ArrayList<HrMasInstructor>();
		Session session = (Session)getSession();
		masTrainingList = session.createCriteria(HrMasTraining.class).add(Restrictions.eq("Status", "y")).list();
		masInstructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masTrainingList", masTrainingList);
		map.put("masInstructorList", masInstructorList);
		return map;
	}
	
	public Map<String, Object> showTrainingRequistionReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrMasTrainingStatus> trainingStatusList = new ArrayList<HrMasTrainingStatus>();
		Session session = (Session)getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		trainingStatusList = session.createCriteria(HrMasTrainingStatus.class).add(Restrictions.eq("Status", "y")).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("trainingStatusList", trainingStatusList);
		return map;
	}
	public Map<String, Object> showTrainingDetailReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasTraining> masTrainingList = new ArrayList<HrMasTraining>();
		List<HrMasInstructor> masInstructorList = new ArrayList<HrMasInstructor>();
		Session session = (Session)getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		masTrainingList = session.createCriteria(HrMasTraining.class).add(Restrictions.eq("Status", "y")).list();
		masInstructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masTrainingList", masTrainingList);
		map.put("masInstructorList", masInstructorList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map ;
	}
	public Map<String, Object> showTrainingEvaluationReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
		List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
		Session session = (Session)getSession();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		instructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
		courseList = session.createCriteria(HrMasCourse.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("instructorList", instructorList);
		map.put("courseList", courseList);
		return map;
	}
	
	public Map<String, Object> showDepartmentWiseTrainingReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("departmentList", departmentList);
		return map;
	}
	
	// End by Ramdular on 04-03-2011 For Training and Services Certificate -----	
	
	//------------------for training service by Nilay-----------------------------------------------------------
	
	public boolean addTrainingServiceCertificate(HrTrainingService hrTrainingService,Map<String,Object>map1) {
		boolean successfullyAdded = false;
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		
		int deptId=(Integer)map1.get("deptId");
		int storeFyId=0;
		String entryNo=(String)map1.get("entryNo");
		Session session = (Session) getSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
		
		hbt.save(hrTrainingService);
		
		/*
		 storeFyDocumentNoList =  getHibernateTemplate()
			.find("from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
					+ deptId + "'");
		
		 if(storeFyDocumentNoList.size()>0)
			{
			 storeFyId= storeFyDocumentNoList.get(0).getId();
			}
		
		 StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
		.load(StoreFyDocumentNo.class, storeFyId);
		 storeFyDocumentNo.setTrainingEntryNo(entryNo);
		 hbt.update(storeFyDocumentNo);
		 hbt.refresh(storeFyDocumentNo);*/

		 hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
		 successfullyAdded = true;
		 tx.commit();
		
		}
		catch (Exception e) 
		{
			
			successfullyAdded = false;
			tx.rollback();
		}
		return successfullyAdded;
	}
	

	
	public String getTraingEntryNum(String no,String poCode) {
		String sequenceNo="";
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate="";
			currentDate = (String) utilMap.get("currentDate");
			//String financialYear="";
			//financialYear=HMSUtil.getfinancialYear(currentDate);

			String[] str = no.split("/");
			String seqNo="";
			int sequenceCounter=0;
			
			if(!no.equalsIgnoreCase("0")){
			try{


				if(str[3]!=""){
					seqNo=str[3];
					if(seqNo!="" && seqNo!=null){
						sequenceCounter=Integer.parseInt(seqNo)+1;
					}else{
						sequenceCounter=1;
					}
				}else{
					sequenceCounter=1;
				}
			}catch (ArrayIndexOutOfBoundsException e) {
				sequenceCounter=1;
				e.printStackTrace();
			}
			}else{
				sequenceCounter=1;
			}
			//sequenceNo=poCode+""+financialYear+"/"+sequenceCounter;
			sequenceNo=poCode+sequenceCounter;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sequenceNo;
	}

	@Override
	public Map<String, Object> searchTrainingServiceCertificate(int entryNos) {
		
		int trainingId=entryNos;
		int doctor_id =1;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<HrTrainingService> trainingServiceList = new ArrayList<HrTrainingService>();
		List<HrTrainingService> hrTrainingServicefulList = new ArrayList<HrTrainingService>();
		hrTrainingServicefulList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.HrTrainingService");
		Session session = (Session)getSession();
		trainingServiceList = session.createCriteria(HrTrainingService.class).add(Restrictions.eq("Id", trainingId)).list();
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeType.Id",doctor_id)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).list();
		map.put("titleList", titleList);
		map.put("employeeList", employeeList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("bloodGroupList", bloodGroupList);		
		
		map.put("hrTrainingServicefulList", hrTrainingServicefulList); 
		map.put("trainingServiceList", trainingServiceList); 
 		
		
		
		return map;
	}

	@Override
	public boolean EditTrainingServiceCertificate(Map<String, Object> map) {
		
		String entryNo=null;
		Date entryDate=null;
		int titleId=0;
		String name=null;
		int age=0;
		String village=null;
		String typeId=null;
		int empId=0;
		String caseNo=null;
		int bloodId=0;
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
		Boolean dataUpdated=false;
		int training_id=0;
		int hospitalId=0;
		
		try
		{
		
		entryNo=(String)map.get("entryNo");
		bloodId=(Integer)map.get("bloodId");
		titleId=(Integer)map.get("titleId");
		name=(String)map.get("name");
		age=(Integer)map.get("age");
		village=(String)map.get("village");
		typeId=(String)map.get("typeId");
		empId=(Integer)map.get("empId");
		caseNo=(String)map.get("caseNo");
		entryDate=(Date)map.get("entryDate");
		currentTime=(String)map.get("currentTime");
		changedDate=(Date)map.get("changedDate");
		changedBy=(String)map.get("changedBy");
		training_id=(Integer)map.get("training_id");
		hospitalId=(Integer)map.get("hospitalId");
		
		HrTrainingService hrTrainingService = (HrTrainingService) getHibernateTemplate()
		.load(HrTrainingService.class, training_id);
		//HrTrainingService hrTrainingService=new HrTrainingService();
		
		hrTrainingService.setAge(age);
		hrTrainingService.setCaseNo(caseNo);
		hrTrainingService.setEntryNumber(entryNo);
		hrTrainingService.setName(name);
		hrTrainingService.setVillage(village);
		hrTrainingService.setType(typeId);
		hrTrainingService.setDate(entryDate);
		hrTrainingService.setLastChgDate(changedDate);
		hrTrainingService.setLastChgTime(currentTime);
		hrTrainingService.setLastChgBy(changedBy);
		
		
		if (titleId != 0 )
		{
			MasTitle masTitle=new MasTitle();
			masTitle.setId(titleId);
			hrTrainingService.setTitleId(masTitle);
			
		}
		
		if (empId != 0 )
		{
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(empId);
			hrTrainingService.setDoctor(masEmployee);
		}
		if (bloodId != 0 )
		{
			MasBloodGroup masBloodGroup=new MasBloodGroup();
			masBloodGroup.setId(bloodId);
			hrTrainingService.setBloodGroup(masBloodGroup);
		}
		if (hospitalId != 0 )
		{
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingService.setHospitalId(masHospital);
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrTrainingService);
		dataUpdated = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dataUpdated;
}
	
	//-------------------------------------------------------------------------------------------------------

	@Override
	public boolean addCertificateStudentAdmission(HrStudentCertificate hrStudentCertificate) {
		
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
		
		    hbt.save(hrStudentCertificate);
		    successfullyAdded = true;
		    tx.commit();
		
		}
		catch (Exception e) 
		{
			
			successfullyAdded = false;
			tx.rollback();
		}
		return successfullyAdded;
		
	}
	
public Map<String, Object> searchCertificateStudentAdmission(int entryNos) {
		
		int trainingId=entryNos;
		int doctor_id =1;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		
		
		List<HrStudentCertificate> hrStudentCertificatefulList = new ArrayList<HrStudentCertificate>();
		hrStudentCertificatefulList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.HrStudentCertificate");
		
		List<HrStudentCertificate> hrStudentCertificateList = new ArrayList<HrStudentCertificate>();
		Session session = (Session)getSession();
		hrStudentCertificateList = session.createCriteria(HrStudentCertificate.class).add(Restrictions.eq("Id", trainingId)).list();
		
		titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeType.Id",doctor_id)).list();
		
		map.put("titleList", titleList);
		map.put("employeeList", employeeList);
				
		
		map.put("hrStudentCertificatefulList", hrStudentCertificatefulList); 
		map.put("hrStudentCertificateList", hrStudentCertificateList); 
 		
		
		return map;
	}

@Override
public boolean editCertificateStudentAdmission(Map<String, Object> map) {
	
	String entryNo=null;
	Date entryDate=null;
	int titleId=0;
	String name=null;
	int age=0;
	int empId=0;
	String caseNo=null;
	String changedBy = "";
	Date changedDate = new Date();
	String currentTime = "";
	String typeId=null;
	String residence=null;
	int training_id=0;
	int hospitalId=0;
	Boolean dataUpdated=false;
	
	try
	{
	
	entryNo=(String)map.get("entryNo");
	titleId=(Integer)map.get("titleId");
	name=(String)map.get("name");
	age=(Integer)map.get("age");
	residence=(String)map.get("residence");
	typeId=(String)map.get("typeId");
	empId=(Integer)map.get("empId");
	caseNo=(String)map.get("caseNo");
	entryDate=(Date)map.get("entryDate");
	currentTime=(String)map.get("currentTime");
	changedDate=(Date)map.get("changedDate");
	changedBy=(String)map.get("changedBy");
	training_id=(Integer)map.get("training_id");
	hospitalId=(Integer)map.get("hospitalId");
	
	
	HrStudentCertificate hrStudentCertificate=(HrStudentCertificate) getHibernateTemplate()
	.load(HrStudentCertificate.class, training_id);
	
	hrStudentCertificate.setEntryNo(entryNo);
	//hrStudentCertificate.setTitleId(titleId);
	hrStudentCertificate.setName(name);
	hrStudentCertificate.setAge(age);
	hrStudentCertificate.setResidence(residence);
	hrStudentCertificate.setFitFor(typeId);
	hrStudentCertificate.setCaseNo(caseNo);
	hrStudentCertificate.setDate(entryDate);
	hrStudentCertificate.setLastChgBy(changedBy);
	hrStudentCertificate.setLastChgDate(changedDate);
	hrStudentCertificate.setLastChgTime(currentTime);
	
	if (titleId != 0 )
	{
		MasTitle masTitle=new MasTitle();
		masTitle.setId(titleId);
		hrStudentCertificate.setTitleId(masTitle);
		
	}
	
	if (empId != 0 )
	{
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(empId);
		hrStudentCertificate.setDoctor(masEmployee);
	}
	if (hospitalId != 0 )
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		hrStudentCertificate.setHospitalId(masHospital);
		
	}
	
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(hrStudentCertificate);
	dataUpdated = true;
} catch (Exception e) {
	e.printStackTrace();
}
return dataUpdated;
	
	
}

@Override
public Map<String, Object> getNameTitle(String regNo) {
	List<Patient> patientNameTitleList = new ArrayList<Patient>();
	Session session = (Session)getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	patientNameTitleList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", regNo)).list();
	map.put("patientNameTitleList", patientNameTitleList);
	
	return map;
}

@Override
public Map<String, Object> searchPatientFitnessCertificate(int entryNos) {
	
	int trainingId=entryNos;
	int doctor_id =1;
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	List<HrPatientFitnessCertificate> hrPatientFitnessCertificateFulList = new ArrayList<HrPatientFitnessCertificate>();
	hrPatientFitnessCertificateFulList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.HrPatientFitnessCertificate");
	
	List<HrPatientFitnessCertificate> hrPatientFitnessCertificateList = new ArrayList<HrPatientFitnessCertificate>();
	Session session = (Session)getSession();
	hrPatientFitnessCertificateList = session.createCriteria(HrPatientFitnessCertificate.class).add(Restrictions.eq("Id", trainingId)).list();
	
	titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
	departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).add(Restrictions.ne("DepartmentType.id", 3)).list();
	
	map.put("titleList", titleList);
	map.put("departmentList", departmentList);
	map.put("employeeList", employeeList);
			
	
	map.put("hrPatientFitnessCertificateFulList", hrPatientFitnessCertificateFulList); 
	map.put("hrPatientFitnessCertificateList", hrPatientFitnessCertificateList); 
		
	return map;
}

@Override
public boolean editPatientFitnessCertificate(Map<String, Object> map) {
	
	String entryNo=null;
	Date entryDate=null;
	int titleId=0;
	String name=null;
	int empId=0;
	String caseNo=null;
	int departmentId=0;
	String regNo="";
	Date resumeDate=null;
	String changedBy = "";
	Date changedDate = new Date();
	String currentTime = "";
	int training_id=0;
	boolean dataUpdated=false;
	int hospitalId=0;
	
	try
	{
	
	entryNo=(String)map.get("entryNo");
	hospitalId=(Integer)map.get("hospitalId");
	titleId=(Integer)map.get("titleId");
	name=(String)map.get("name");
	departmentId=(Integer)map.get("departmentId");
	resumeDate=(Date)map.get("resumeDate");
	empId=(Integer)map.get("empId");
	caseNo=(String)map.get("caseNo");
	entryDate=(Date)map.get("entryDate");
	currentTime=(String)map.get("currentTime");
	changedDate=(Date)map.get("changedDate");
	changedBy=(String)map.get("changedBy");
	regNo=(String)map.get("regNo");
	training_id=(Integer)map.get("training_id");
	
	HrPatientFitnessCertificate hrPatientFitnessCertificate=(HrPatientFitnessCertificate) getHibernateTemplate()
	.load(HrPatientFitnessCertificate.class, training_id);
	
	hrPatientFitnessCertificate.setEntryNo(entryNo);
	hrPatientFitnessCertificate.setName(name);
	hrPatientFitnessCertificate.setRegNo(regNo);
	hrPatientFitnessCertificate.setResumeDate(resumeDate);
	hrPatientFitnessCertificate.setCaseNo(caseNo);
	hrPatientFitnessCertificate.setDate(entryDate);
	hrPatientFitnessCertificate.setLastChgBy(changedBy);
	hrPatientFitnessCertificate.setLastChgDate(changedDate);
	hrPatientFitnessCertificate.setLastChgTime(currentTime);
	hrPatientFitnessCertificate.setHospitalId(hospitalId);
	
	if (titleId != 0 )
	{
		MasTitle masTitle=new MasTitle();
		masTitle.setId(titleId);
		hrPatientFitnessCertificate.setTitleId(masTitle);	
	}
	
	if (empId != 0 )
	{
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(empId);
		hrPatientFitnessCertificate.setDoctor(masEmployee);
	}
	if (departmentId != 0 )
	{
		MasDepartment masDepartment=new MasDepartment();
		masDepartment.setId(departmentId);
		hrPatientFitnessCertificate.setDepartmentId(masDepartment);
	}
	
	
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(hrPatientFitnessCertificate);
	dataUpdated = true;
} catch (Exception e) {
	
	e.printStackTrace();
}
return dataUpdated;
}

@Override
public boolean addPatientFitnessCertificate(
		HrPatientFitnessCertificate hrPatientFitnessCertificate) {
	
	Session session = (Session) getSession();
	boolean successfullyAdded = false;
	Transaction tx = null;
	try
	{
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
	    hbt.save(hrPatientFitnessCertificate);
	    successfullyAdded = true;
	    tx.commit();
	
	}
	catch (Exception e) 
	{
		
		successfullyAdded = false;
		tx.rollback();
	}
	return successfullyAdded;
	
}

public boolean addPatientSicknessCertificate(HrPatientSickCertificate hrPatientSickCertificate) {
	
	Session session = (Session) getSession();
	boolean successfullyAdded = false;
	Transaction tx = null;
	try
	{
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
	    hbt.save(hrPatientSickCertificate);
	    successfullyAdded = true;
	    tx.commit();
	
	}
	catch (Exception e) 
	{
		
		successfullyAdded = false;
		tx.rollback();
	}
	return successfullyAdded;
	
}

@Override
public Map<String, Object> searchPatientSicknessCertificate(int entryNos) {
	
	int trainingId=entryNos;
	int doctor_id =1;
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	
	List<HrPatientSickCertificate> hrPatientSickCertificateFulList = new ArrayList<HrPatientSickCertificate>();
	hrPatientSickCertificateFulList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.HrPatientSickCertificate");
	
	List<HrPatientSickCertificate> hrPatientSickCertificateList = new ArrayList<HrPatientSickCertificate>();
	Session session = (Session)getSession();
	hrPatientSickCertificateList = session.createCriteria(HrPatientSickCertificate.class).add(Restrictions.eq("Id", trainingId)).list();
	
	titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
	departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).add(Restrictions.ne("DepartmentType.id", 3)).list();
	
	map.put("titleList", titleList);
	map.put("departmentList", departmentList);
	map.put("employeeList", employeeList);
			
	
	map.put("hrPatientSickCertificateFulList", hrPatientSickCertificateFulList); 
	map.put("hrPatientSickCertificateList", hrPatientSickCertificateList); 
		
	return map;
	
}

@Override
public boolean editPatientSicknessCertificate(Map<String, Object> map) {
	
	String entryNo=null;
	Date entryDate=null;
	String regNo="";
	int titleId=0;
	String name=null;
	int absentDays=0;
	Boolean dataUpdated=false;
	String sufferFromDate="";
	Date effectFromDate=null;
	Date effectToDate=null;
	String changedBy = "";
	Date changedDate = new Date();
	String currentTime = "";
    int hospitalId=0;
    int training_id=0;
    
    try
	{
    
    entryNo=(String)map.get("entryNo");
    entryDate=(Date)map.get("entryDate");
    regNo=(String)map.get("regNo");
    name=(String)map.get("name");
    absentDays=(Integer)map.get("absentDays");
    titleId=(Integer)map.get("titleId");
    sufferFromDate=(String
    		)map.get("sufferFromDate");
    effectFromDate=(Date)map.get("effectFromDate");
    effectToDate=(Date)map.get("effectToDate");
    currentTime=(String)map.get("currentTime");
	changedDate=(Date)map.get("changedDate");
	changedBy=(String)map.get("changedBy");
	training_id=(Integer)map.get("training_id");
	hospitalId=(Integer)map.get("hospitalId");
	
	
	HrPatientSickCertificate hrPatientSickCertificate=(HrPatientSickCertificate) getHibernateTemplate()
	.load(HrPatientSickCertificate.class, training_id);
	
	hrPatientSickCertificate.setEntryNo(entryNo);
	hrPatientSickCertificate.setName(name);
	hrPatientSickCertificate.setRegNo(regNo);
	hrPatientSickCertificate.setDate(entryDate);
	hrPatientSickCertificate.setDaysAbsent(absentDays);
	
	hrPatientSickCertificate.setSufferFromDate(sufferFromDate);
	hrPatientSickCertificate.setEffectFromDate(effectFromDate);
	hrPatientSickCertificate.setEffectToDate(effectToDate);
	hrPatientSickCertificate.setLastChgBy(changedBy);
	hrPatientSickCertificate.setLastChgDate(changedDate);
	hrPatientSickCertificate.setLastChgTime(currentTime);
	
	
	if (titleId != 0 )
	{
		MasTitle masTitle=new MasTitle();
		masTitle.setId(titleId);
		hrPatientSickCertificate.setTitleId(masTitle);	
	}
	
	if (hospitalId != 0 )
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		hrPatientSickCertificate.setHospitalId(masHospital);
	}
		
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(hrPatientSickCertificate);
	dataUpdated = true;
} catch (Exception e) {
	
	e.printStackTrace();
}
return dataUpdated;
    
}

@Override
public boolean addMedicalCertificateFitnessFirstEntry(
		HrMedicalFitnessFirst hrMedicalFitnessFirst) {
	Session session = (Session) getSession();
	boolean successfullyAdded = false;
	Transaction tx = null;
	try
	{
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
	    hbt.save(hrMedicalFitnessFirst);
	    successfullyAdded = true;
	    tx.commit();
	
	}
	catch (Exception e) 
	{
		
		successfullyAdded = false;
		tx.rollback();
	}
	return successfullyAdded;
}

@Override
public Map<String, Object> searchMedicalCertificateFitnessFirstEntry(
		int entryNos) {
	
	int trainingId=entryNos;
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	List<HrMedicalFitnessFirst> hrMedicalFitnessFirstFulList = new ArrayList<HrMedicalFitnessFirst>();
	hrMedicalFitnessFirstFulList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.HrMedicalFitnessFirst");
	
	List<HrMedicalFitnessFirst> hrMedicalFitnessFirstList = new ArrayList<HrMedicalFitnessFirst>();
	Session session = (Session)getSession();
	hrMedicalFitnessFirstList = session.createCriteria(HrMedicalFitnessFirst.class).add(Restrictions.eq("Id", trainingId)).list();
	
	titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).list();
		
	map.put("titleList", titleList);
	map.put("employeeList", employeeList);
			
	
	map.put("hrMedicalFitnessFirstFulList", hrMedicalFitnessFirstFulList); 
	map.put("hrMedicalFitnessFirstList", hrMedicalFitnessFirstList); 
		
	return map;
	
	
	
}

@Override
public boolean editMedicalCertificateFitnessFirstEntry(Map<String, Object> map) {
	
	String entryNo=null;
	Date entryDate=null;
	String regNo="";
	int titleId=0;
	String name=null;
	String weakAtBody="";
	String employIn="";
	String changedBy = "";
	Date changedDate = null;
	String currentTime = "";
    int hospitalId=0;
    int training_id=0;
    Boolean dataUpdated = false;
    
    try
    {
    entryNo=(String)map.get("entryNo");
    regNo= (String)map.get("regNo");
   // titleId= (Integer)map.get("titleId");
    name=(String)map.get("name");
	entryDate= (Date) map.get("entryDate");
	weakAtBody=(String)map.get("weakAtBody");
	employIn=(String)map.get("employIn");
	changedBy=(String)map.get("changedBy");
	currentTime=(String)map.get("currentTime");
	changedDate=(Date)map.get("changedDate");
	training_id=(Integer)map.get("training_id");
	
	HrMedicalFitnessFirst hrMedicalFitnessFirst=(HrMedicalFitnessFirst) getHibernateTemplate()
	.load(HrMedicalFitnessFirst.class, training_id);
	
	hrMedicalFitnessFirst.setConstWeakness(weakAtBody);
	hrMedicalFitnessFirst.setDate(entryDate);
	hrMedicalFitnessFirst.setEntryNo(entryNo);
	hrMedicalFitnessFirst.setForEmployInOffice(employIn);
	hrMedicalFitnessFirst.setLastChgBy(changedBy);
	hrMedicalFitnessFirst.setLastChgDate(changedDate);
	hrMedicalFitnessFirst.setLastChgTime(currentTime);
	hrMedicalFitnessFirst.setName(name);
	hrMedicalFitnessFirst.setRegNo(regNo);
	
	if (titleId != 0 )
	{
		MasTitle masTitle=new MasTitle();
		masTitle.setId(titleId);
		hrMedicalFitnessFirst.setTitleId(masTitle);	
	}
	
	if (hospitalId != 0 )
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		hrMedicalFitnessFirst.setHospitalId(masHospital);
	}
	
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(hrMedicalFitnessFirst);
	dataUpdated = true;
} catch (Exception e) {
	
	e.printStackTrace();
}
return dataUpdated;
	
}

@Override
public Map<String, Object> searchMedicalExaminationReport(
		Map<String, Object> enquiryMap) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> map2 = new HashMap<String, Object>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List<HrMedicalRecord> medicalRecordList = new ArrayList<HrMedicalRecord>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	
	String empName="";
	String empCode="";
	String height="";
	String identification="";
	int departmentId=0;
	int bloodId=0;
	int typeId=0;
	Date dateOfBirth=null;
	Date dateOfJoin=null;
	
	
	
	if (enquiryMap.get("empName") != null) {
		empName = (String) enquiryMap.get("empName");
	}
	
	if (enquiryMap.get("typeId") != null) {
		typeId = (Integer) enquiryMap.get("typeId");
	}
	if (enquiryMap.get("empCode") != null) {
		empCode = (String) enquiryMap.get("empCode");
	}
	if (enquiryMap.get("identification") != null) {
		identification = (String) enquiryMap.get("identification");
	}
	if (enquiryMap.get("height") != null) {
		height = (String) enquiryMap.get("height");
	}
	if (enquiryMap.get("departmentId") != null) {
		departmentId = (Integer) enquiryMap.get("departmentId");
	}
	if (enquiryMap.get("bloodId") != null) {
		bloodId = (Integer) enquiryMap.get("bloodId");
	}
	
	departmentList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasDepartment");
	
	bloodGroupList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasBloodGroup");
	
	Session session = (Session)getSession();
	try 
	
	{
		Criteria crit = session.createCriteria(HrMedicalRecord.class);

		if (!empName.equals("")) {
			crit = crit.add(Restrictions.like("EmpName", empName
					+ "%"));
		}
		if (!empCode.equals("")) {
			crit = crit.add(Restrictions.eq("EmpCode", empCode));
		}
		if (!identification.equals("")) {
			crit = crit.add(Restrictions.eq("IdentificationMark", identification));
		}
		if (!height.equals("")) {
			crit = crit.add(Restrictions.eq("Height", height));
		}
		if (departmentId!=0) {
			crit = crit.add(Restrictions.eq("Department.Id", departmentId));
		}
		if (bloodId !=0) {
			crit = crit.add(Restrictions.eq("BloodGroup.Id", bloodId));
		}
		if (typeId !=0) {
			crit = crit.add(Restrictions.eq("ExamType", typeId));
		}
		medicalRecordList=crit.list();
	}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
	
	
	map.put("medicalRecordList", medicalRecordList);
	map.put("departmentList", departmentList);
	map.put("bloodGroupList", bloodGroupList);
	return map;
}

@Override
public Boolean addMedicalExamEntry(HrMedicalRecord hrMedicalRecord) {
	
	Session session = (Session) getSession();
	boolean successfullyAdded = false;
	Transaction tx = null;
	try
	{
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
	    hbt.save(hrMedicalRecord);
	    successfullyAdded = true;
	    tx.commit();
	
	}
	catch (Exception e) 
	{
		
		successfullyAdded = false;
		tx.rollback();
	}
	return successfullyAdded;
}

@Override
public Map<String, Object> getNameDepartment(String empCode) {
	
	List<MasEmployee> empNameDepartmentList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	Session session = (Session)getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	empNameDepartmentList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeCode", empCode)).list();
	departmentList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasDepartment");
	
	map.put("empNameDepartmentList", empNameDepartmentList);
	map.put("departmentList", departmentList);
	return map;
	
}

@Override
public Map<String, Object> showSearchMedicalExamEntry() {
	
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	
	departmentList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasDepartment");
	
	bloodGroupList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasBloodGroup");
	
	map.put("departmentList", departmentList);
	map.put("bloodGroupList", bloodGroupList);
	
	return map;
}


public boolean editMedicalExamEntry(Map<String, Object> map) {
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	int typeId=0;
	String empName="";
	String empCode="";
	int departmentId=0;
	Date dateOfBirth=null;
	Date dateOfJoin=null;
	int bloodId=0;
	String height="";
	String identification="";
	Date dateOfPersDate=null;
	String pastHistory="";
	String personalHistory="";
	String familyHistory="";
	String presentComplaint="";
	int weight=0;
	String eyeVision="";
	String colorVision="";
	String others="";
	String mouth="";
	String skin="";
	String respiratory="";
	String cardiovascular="";
	String bloodPressure="";
	String abdomen="";
	String genito="";
	String masculo="";
	String nervous="";
	Date dateOfPathDate=null;
	String chest="";
	String blood="";
	String urine="";
	String otherTest="";
	Date observeDate=null;
	String addRemarks="";
	String fitUnfitRemarks="";
	int fitUnFit=0;
	int doctorId=0;
	String changedBy="";
	Date changedDate=null;
	String currentTime="";
	Boolean dataUpdated=false;	
	int hospitalId=0;
	int training_id=0;
	
	try
	 {
	
	 typeId=(Integer) map.get("typeId"); 
	 training_id=(Integer) map.get("training_id"); 
	 empName = (String) map.get("empName");
	 empCode = (String) map.get("empCode");
	 departmentId =(Integer) map.get("departmentId");
	 dateOfBirth = (Date) map.get("dateOfBirth");
	 dateOfJoin = (Date) map.get("dateOfJoin");
	 bloodId = (Integer) map.get("bloodId");
	 height = (String) map.get("height");
	 identification = (String) map.get("identification");
	 dateOfPersDate = (Date) map.get("dateOfPersDate");
	 pastHistory = (String) map.get("pastHistory");
	 personalHistory = (String) map.get("personalHistory");
	 familyHistory = (String) map.get("familyHistory");
	 presentComplaint = (String) map.get("presentComplaint");
	 weight = (Integer) map.get("weight");
	 eyeVision = (String) map.get("eyeVision");
	 colorVision = (String) map.get("colorVision");
	 others = (String) map.get("others");
	 mouth = (String) map.get("mouth");
	 skin = (String) map.get("skin");
	 respiratory = (String) map.get("respiratory");
	 cardiovascular = (String) map.get("cardiovascular");
	 bloodPressure = (String) map.get("bloodPressure");
	 abdomen = (String) map.get("abdomen");
	 genito = (String) map.get("genito"); 
	 masculo = (String) map.get("masculo"); 
	 nervous = (String) map.get("nervous"); 
	 dateOfPathDate = (Date) map.get("dateOfPathDate"); 
	 chest = (String) map.get("chest"); 
	 blood = (String) map.get("blood"); 
	 urine = (String) map.get("urine"); 
	 otherTest = (String) map.get("otherTest"); 
	 observeDate = (Date) map.get("observeDate"); 
	 addRemarks = (String) map.get("addRemarks"); 
	 fitUnfitRemarks = (String) map.get("fitUnfitRemarks"); 
	 fitUnFit = (Integer) map.get("fitUnFit"); 
	 doctorId = (Integer) map.get("doctorId"); 
	 changedBy = (String) map.get("changedBy"); 
	 changedDate = (Date) map.get("changedDate"); 
	 currentTime = (String) map.get("currentTime"); 
	 	
	 hospitalId = (Integer) map.get("hospitalId"); 
	 
	 
	 
	// HrMedicalRecord medRecord = new HrMedicalRecord();
	 
	 HrMedicalRecord medRecord=(HrMedicalRecord) getHibernateTemplate()
		.load(HrMedicalRecord.class, training_id);
	 
	 medRecord.setExamType(typeId);
	 medRecord.setEmpCode(empCode);
	 medRecord.setEmpName(empName);
	 medRecord.setDateOfBirth(dateOfBirth);
	 medRecord.setHeight(height);
	 medRecord.setIdentificationMark(identification);
	 medRecord.setPhysicalExamDate(dateOfPersDate);
	 medRecord.setPastHistory(pastHistory);
	 medRecord.setPersonalHabits(personalHistory);
	 medRecord.setFamilyHistory(familyHistory);
	 medRecord.setPresentComplain(presentComplaint);
	 medRecord.setWeight(weight);
	 medRecord.setEyesight(eyeVision);
	 medRecord.setColorVision(colorVision);
	 medRecord.setOthers(others);
	 medRecord.setMouthEarThroat(mouth);
	 medRecord.setSkinCondition(skin);
	 medRecord.setRespiratorySystem(respiratory);
	 medRecord.setCardiovascularSystem(cardiovascular);
	 medRecord.setBloodPressure(bloodPressure);
	 medRecord.setAbdomen(abdomen);
	 medRecord.setGenitoUrinarySystem(genito);
	 medRecord.setMasculoGenitalSystem(masculo);
	 medRecord.setNervousSystem(nervous);
	 medRecord.setPathoExamDate(dateOfPathDate);
	 medRecord.setChestXRay(chest);
	 medRecord.setBlood(blood);
	 medRecord.setUrine(urine);
	 medRecord.setAnyOtherTest(otherTest);
	 medRecord.setDocObservationDate(observeDate);
	 medRecord.setAddlRemarks(addRemarks);
	 medRecord.setFitUnfitRemarks(fitUnfitRemarks);
	 medRecord.setFitUnfit(fitUnFit);
	 
	 medRecord.setLastChgBy(changedBy);
	 medRecord.setLastCgDate(changedDate);
	 medRecord.setLastChgTime(currentTime);
	 
	 
	 if (hospitalId != 0 )
		{
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			medRecord.setHospitalId(masHospital);	
		}
		
		if (doctorId != 0 )
		{
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(doctorId);
			medRecord.setDoctor(masEmployee);
		}
		
		if (departmentId != 0 )
		{
			MasDepartment masDepartment=new MasDepartment();
			masDepartment.setId(departmentId);
			medRecord.setDepartment(masDepartment);
		}
		
		if (bloodId != 0 )
		{
			MasBloodGroup masBloodGroup=new MasBloodGroup();
			masBloodGroup.setId(bloodId);
			medRecord.setBloodGroup(masBloodGroup);
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(medRecord);
		dataUpdated = true;
}
		catch (Exception e) {
		
		e.printStackTrace();
	}
	return dataUpdated;

}

public Map<String, Object> forUpdateMedicalExamEntry(int empCode) 
{
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrMedicalRecord> medicalRecordList = new ArrayList<HrMedicalRecord>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<MasEmployee> employeeDoctorList = new ArrayList<MasEmployee>();
	int doctor_id=1;
	
	Session session = (Session)getSession();
	medicalRecordList = session.createCriteria(HrMedicalRecord.class).add(Restrictions.eq("Id", empCode)).list();
	
	
	departmentList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasDepartment");
	
	bloodGroupList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.MasBloodGroup");
	
	employeeDoctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmployeeType.Id",doctor_id)).list();
	
	map.put("departmentList", departmentList);
	map.put("employeeDoctorList", employeeDoctorList);
	map.put("bloodGroupList", bloodGroupList);
	map.put("medicalRecordList", medicalRecordList);
	return map;
}


public Map<String, Object> saveTrainingType(MasTrainingType masTrainingType) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrainingType> trainingTypeList = new ArrayList<MasTrainingType>();
	List<MasTrainingType> existingTrainingTypeList = new ArrayList<MasTrainingType>();
	Session session = (Session)getSession();
	String message = "";
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	String trainingCode = masTrainingType.getTrainingTypeCode();
	String trainingName = masTrainingType.getTrainingTypeName();

	//existingTrainingTypeList = session.createCriteria(MasTrainingType.class).add(Restrictions.eq("TrainingTypeCode","trainingCode")).add(Restrictions.eq("TrainingTypeName", "trainingName")).list();
	existingTrainingTypeList = getHibernateTemplate().find("from jkt.hrms.masters.business.MasTrainingType as msc where msc.TrainingTypeCode = '"+trainingCode+"' and msc.TrainingTypeName = '"+trainingName+"'");

	if(existingTrainingTypeList.size()>0){
		message = "Record already exist";
	}else{
		hbt.save(masTrainingType);
		message = "Record save successfully";
	}
	trainingTypeList = session.createCriteria(MasTrainingType.class).add(Restrictions.eq("Status","y")).list();
	map.put("trainingTypeList", trainingTypeList);
	map.put("message", message);
	return map;
}

public Map<String, Object> showTrainingTypeJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrainingType> trainingTypeList = new ArrayList<MasTrainingType>();
	Session session = (Session)getSession();
	trainingTypeList = session.createCriteria(MasTrainingType.class).list();
	map.put("trainingTypeList", trainingTypeList);
	return map;
}

public Map<String, Object> editTrainingType(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrainingType> trainingTypeList = new ArrayList<MasTrainingType>();
	List<MasTrainingType> existingTrainingTypeList = new ArrayList<MasTrainingType>();
	Session session = (Session)getSession();
	int trainingTypeId = 0;
	if (generalMap.get("trainingTypeId")!= null) {
		trainingTypeId = (Integer)generalMap.get("trainingTypeId");
	}
	String trainingTypeCode = "";
	if (generalMap.get("trainingTypeCode")!= null) {
		trainingTypeCode = (String)generalMap.get("trainingTypeCode");
	}
	String trainingName = "";
	if (generalMap.get("trainingName")!= null) {
		trainingName = (String)generalMap.get("trainingName");
	}
	String changedBy ="";
	if (generalMap.get("changedBy")!= null) {
		changedBy = (String)generalMap.get("changedBy");
	}
	Date currentDate = null;
	if (generalMap.get("currentDate")!= null) {
		currentDate = (Date)generalMap.get("currentDate");
	}
	String currentTime = "";
	if (generalMap.get("currentTime")!= null) {
		currentTime = (String)generalMap.get("currentTime");
	}
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	MasTrainingType masTrainingType = (MasTrainingType)hbt.load(MasTrainingType.class, trainingTypeId);
	masTrainingType.setTrainingTypeCode(trainingTypeCode);
	masTrainingType.setTrainingTypeName(trainingName);
	masTrainingType.setLastChgBy(changedBy);
	masTrainingType.setLastChgDate(currentDate);
	masTrainingType.setLastChgTime(currentTime);
	existingTrainingTypeList = getHibernateTemplate().find("from jkt.hrms.masters.business.MasTrainingType as msc where msc.TrainingTypeCode = '"+trainingTypeCode+"' and msc.TrainingTypeName = '"+trainingName+"' and msc.Id != '"+trainingTypeId+"'");
	String message = "";
	if(existingTrainingTypeList.size()>0){
		message = "Record already exist";
	}else{
		hbt.update(masTrainingType);
		message = "Record update successfully";
	}
	trainingTypeList = session.createCriteria(MasTrainingType.class).list();
	map.put("trainingTypeList", trainingTypeList);
	map.put("message", message);
	return map;
}

public Map<String, Object> deleteTrainingType(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrainingType> trainingTypeList = new ArrayList<MasTrainingType>();
	Session session = (Session)getSession();
	 boolean dataDeleted=false;
	int trainingTypeId = 0;
	if (generalMap.get("trainingTypeId")!= null) {
		trainingTypeId = (Integer)generalMap.get("trainingTypeId");
	}
	String changedBy ="";
	if (generalMap.get("changedBy")!= null) {
		changedBy = (String)generalMap.get("changedBy");
	}
	Date currentDate = new Date();
	if (generalMap.get("currentDate")!= null) {
		currentDate = (Date)generalMap.get("currentDate");
	}
	String currentTime = "";
	if (generalMap.get("currentTime")!= null) {
		currentTime = (String)generalMap.get("currentTime");
	}
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	MasTrainingType masTrainingType= (MasTrainingType)hbt.load(MasTrainingType.class, trainingTypeId);
	masTrainingType.setLastChgBy(changedBy);
	masTrainingType.setLastChgDate(currentDate);
	masTrainingType.setLastChgTime(currentTime);
	if(generalMap.get("flag") != null){
		  String flag = (String)generalMap.get("flag");
		  if (flag.equals("InActivate")){
			  masTrainingType.setStatus("n");
		   dataDeleted=true;
		  }else if(flag.equals("Activate")){
			  masTrainingType.setStatus("y");
			  dataDeleted=false;
		  }
	  }
	hbt.update(masTrainingType);
	String message = "";
	if (dataDeleted==true)
	{
		message="Record is InActivated successfully !!";
	}

	else{
		message="Record is Activated successfully !!";
	}
	trainingTypeList = session.createCriteria(MasTrainingType.class).list();
	map.put("trainingTypeList", trainingTypeList);
	map.put("message", message);
	return map;
}

public Map<String, Object> searchTrainingType(String trainingTypeCode,String trainingTypeName) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrainingType> trainingTypeList = new ArrayList<MasTrainingType>();

	try{
		if((trainingTypeName!=null) || (trainingTypeCode==null)){

			trainingTypeList = getHibernateTemplate().find("from jkt.hrms.masters.business.MasTrainingType  msc where msc.TrainingTypeName like '"+trainingTypeName+"%' order by msc.TrainingTypeName");
		}
		else{
			trainingTypeList = getHibernateTemplate().find("from jkt.hrms.masters.business.MasTrainingType  msc where msc.TrainingTypeCode like '"+trainingTypeCode+"%' order by msc.TrainingTypeCode");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	map.put("trainingTypeList", trainingTypeList);
	map.put("trainingTypeName", trainingTypeName);
	map.put("trainingTypeCode", trainingTypeCode);
	return map;
}


public Map<String, Object> showTrainingEffectivnessJsp(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Users users = new Users();
	Session session = (Session)getSession();
	List<HrMasInstitute> instituteList = new ArrayList<HrMasInstitute>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
	List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
	List<HrTrainingEffective> trainingEffectiveList = new ArrayList<HrTrainingEffective>();
	if(generalMap.get("users")!= null){
		users = (Users)generalMap.get("users");
	}
	int employeeId = users.getEmployee().getId();
	instituteList = session.createCriteria(HrMasInstitute.class).add(Restrictions.eq("Status", "y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
	courseList = session.createCriteria(HrMasCourse.class).add(Restrictions.eq("Status", "y")).list();
	instructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
	trainingEffectiveList = session.createCriteria(HrTrainingEffective.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
	map.put("instituteList", instituteList);
	map.put("employeeList", employeeList);
	map.put("courseList", courseList);
	map.put("instructorList", instructorList);
	map.put("trainingEffectiveList", trainingEffectiveList);
	return map;
}

public Map<String, Object> saveTrainingEffectivness(HrTrainingEffective trainingEffective) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<HrMasInstitute> instituteList = new ArrayList<HrMasInstitute>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
	List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
	List<HrTrainingEffective> trainingEffectiveList = new ArrayList<HrTrainingEffective>();
	List<HrTrainingEffective> existingTrainingEffectiveList = new ArrayList<HrTrainingEffective>();
	String message = "";
	boolean saved = false;
	SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
	int employeeId = trainingEffective.getEmployee().getId();
	String heldOnDate = sdf.format(trainingEffective.getHeldOnDate());
	int courseId = trainingEffective.getCourse().getId();
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	existingTrainingEffectiveList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrTrainingEffective as te where te.Employee.Id = "+employeeId+" and te.HeldOnDate = '"+heldOnDate+"' and te.Course.id = "+courseId+" ");

	if(existingTrainingEffectiveList.size()>0){
		message = "Record already Exist";
	}else{
		hbt.save(trainingEffective);
		message = "Record saved sucessfully!";
	}
	instituteList = session.createCriteria(HrMasInstitute.class).add(Restrictions.eq("Status", "y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
	courseList = session.createCriteria(HrMasCourse.class).add(Restrictions.eq("Status", "y")).list();
	instructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
	trainingEffectiveList = session.createCriteria(HrTrainingEffective.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
	map.put("instituteList", instituteList);
	map.put("employeeList", employeeList);
	map.put("courseList", courseList);
	map.put("instructorList", instructorList);
	map.put("trainingEffectiveList", trainingEffectiveList);
	map.put("message", message);
	return map;
}

public Map<String, Object> editTrainingEffectivness(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<HrMasInstitute> instituteList = new ArrayList<HrMasInstitute>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
	List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
	List<HrTrainingEffective> trainingEffectiveList = new ArrayList<HrTrainingEffective>();
	int trainingEffectivnessId = 0;
	if (generalMap.get("trainingEffectivnessId")!= null) {
		trainingEffectivnessId = (Integer)generalMap.get("trainingEffectivnessId");
	}
	Date evaluationDate = new Date();
	if (generalMap.get("evaluationDate")!= null) {
		evaluationDate = (Date)generalMap.get("evaluationDate");
	}
	Date heldOnDate = new Date();
	if (generalMap.get("heldOnDate")!= null) {
		heldOnDate = (Date)generalMap.get("heldOnDate");
	}
	int employeeId = 0;
	if (generalMap.get("employeeId")!= null) {
		employeeId = (Integer)generalMap.get("employeeId");
	}
	int instituteId = 0;
	if (generalMap.get("instituteId")!= null) {
		instituteId = (Integer)generalMap.get("instituteId");
	}
	int courseId = 0;
	if (generalMap.get("courseId")!= null) {
		courseId = (Integer)generalMap.get("courseId");
	}
	int instructorId = 0;
	if (generalMap.get("instructorId")!= null) {
		instructorId = (Integer)generalMap.get("instructorId");
	}
	String courseExplainA = "";
	if (generalMap.get("courseExplainA")!= null) {
		courseExplainA = (String)generalMap.get("courseExplainA");
	}
	String courseExplainB = "";
	if (generalMap.get("courseExplainB")!= null) {
		courseExplainB = (String)generalMap.get("courseExplainB");
	}
	String courseMaterial = "";
	if (generalMap.get("courseMaterial")!= null) {
		courseMaterial = (String)generalMap.get("courseMaterial");
	}
	int reviewA = 0;
	if (generalMap.get("reviewA")!= null) {
		reviewA = (Integer)generalMap.get("reviewA");
	}
	int reviewB = 0;
	if (generalMap.get("reviewB")!= null) {
		reviewB = (Integer)generalMap.get("reviewB");
	}
	int reviewC = 0;
	if (generalMap.get("reviewC")!= null) {
		reviewC = (Integer)generalMap.get("reviewC");
	}
	int reviewD = 0;
	if (generalMap.get("reviewD")!= null) {
		reviewD = (Integer)generalMap.get("reviewD");
	}
	int averagePoints = 0;
	if (generalMap.get("averagePoints")!= null) {
		averagePoints = (Integer)generalMap.get("averagePoints");
	}
	String remarks = "";
	if (generalMap.get("remarks")!= null) {
		remarks = (String)generalMap.get("remarks");
	}
	String changedBy  = "";
	if (generalMap.get("changedBy")!= null) {
		changedBy = (String)generalMap.get("changedBy");
	}
	Date changedDate = new Date();
	if (generalMap.get("changedDate")!= null) {
		changedDate = (Date)generalMap.get("changedDate");
	}
	String changedTime = "";
	if (generalMap.get("changedTime")!= null) {
		changedTime = (String)generalMap.get("changedTime");
	}
	boolean updated = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	HrTrainingEffective hrTrainingEffective = (HrTrainingEffective)hbt.load(HrTrainingEffective.class, trainingEffectivnessId);
	hrTrainingEffective.setEvaluationDate(evaluationDate);
	hrTrainingEffective.setHeldOnDate(heldOnDate);
	HrMasCourse hrMasCourse = new HrMasCourse();
	hrMasCourse.setId(courseId);
	hrTrainingEffective.setCourse(hrMasCourse);
	HrMasInstructor hrMasInstructor = new HrMasInstructor();
	hrMasInstructor.setId(instructorId);
	hrTrainingEffective.setInstructor(hrMasInstructor);
	HrMasInstitute hrMasInstitute = new HrMasInstitute();
	hrMasInstitute.setId(instituteId);
	hrTrainingEffective.setInstitute(hrMasInstitute);
	MasEmployee masEmployee = new MasEmployee();
	masEmployee.setId(employeeId);
	hrTrainingEffective.setEmployee(masEmployee);
	hrTrainingEffective.setCourseExplaina(courseExplainA);
	hrTrainingEffective.setCourseExplainb(courseExplainB);
	hrTrainingEffective.setCourseMaterial(courseMaterial);
	hrTrainingEffective.setReviewA(reviewA);
	hrTrainingEffective.setReviewB(reviewB);
	hrTrainingEffective.setReviewC(reviewC);
	hrTrainingEffective.setReviewD(reviewD);
	hrTrainingEffective.setAveragePoints(averagePoints);
	hrTrainingEffective.setRemarks(remarks);
	hrTrainingEffective.setLastChgBy(changedBy);
	hrTrainingEffective.setLastChgDate(changedDate);
	hrTrainingEffective.setLastChgTime(changedTime);
	hbt.update(hrTrainingEffective);
	updated = true;
	String message = "";
	if(updated){
		message = "Record update successfully";
	}else{
		message = "Some problem occured";
	}
	instituteList = session.createCriteria(HrMasInstitute.class).add(Restrictions.eq("Status", "y")).list();
	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
	courseList = session.createCriteria(HrMasCourse.class).add(Restrictions.eq("Status", "y")).list();
	instructorList = session.createCriteria(HrMasInstructor.class).add(Restrictions.eq("Status", "y")).list();
	trainingEffectiveList = session.createCriteria(HrTrainingEffective.class).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
	map.put("instituteList", instituteList);
	map.put("employeeList", employeeList);
	map.put("courseList", courseList);
	map.put("instructorList", instructorList);
	map.put("trainingEffectiveList", trainingEffectiveList);
	map.put("message", message);
	return map;
}

@Override
public Map<String, Object> showTransferNotificationJsp(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session sess = getSession();
	List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
	transferNotificationList = sess.createCriteria(HrMasTransferNotification.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	map.put("transferNotificationList", transferNotificationList);
	return map;
}


@Override
public boolean findNotificationNo(Map<String, Object> parameterMap) {
	
	Session sess = getSession();
	String notification=""+parameterMap.get("notification");
	List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
	transferNotificationList = sess.createCriteria(HrMasTransferNotification.class).add(Restrictions.eq("NotificationNo", notification)).list();
	if(transferNotificationList.size()>0)
				return false;
	else
		return true;
}


@Override
public Map<String, Object> saveTransferNotification(Map<String, Object> parameterMap) {
	
	Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
		List<HrTransferApplicationM> transferApplicationMList = new ArrayList<HrTransferApplicationM>();
		int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));
		int id=Integer.parseInt(""+parameterMap.get("id"));
		String Notification_Date=""+parameterMap.get("Notification_Date");
		String notification=""+parameterMap.get("notification");
		String fromDate=""+parameterMap.get("fromDate");
		String toDate=""+parameterMap.get("toDate");
		Users user = (Users)parameterMap.get("changedBy");
		String changedDate=""+parameterMap.get("changedDate");
		String changedTime=""+parameterMap.get("changedTime");
		String msg="";
		boolean b= false;
		try {
			
			HrMasTransferNotification hrMasTransferNotification = null;
			if(id != 0){
				hrMasTransferNotification =(HrMasTransferNotification) session.load(HrMasTransferNotification.class, id);
			}else{
				 hrMasTransferNotification = new HrMasTransferNotification();
			}
			hrMasTransferNotification.setNotificationNo(notification);
			hrMasTransferNotification.setReleaseDate(HMSUtil.convertStringTypeDateToDateType(Notification_Date));
			hrMasTransferNotification.setApplicableFromDate(HMSUtil.convertStringTypeDateToDateType(fromDate));
			hrMasTransferNotification.setApplicableToDate(HMSUtil.convertStringTypeDateToDateType(toDate));
			hrMasTransferNotification.setStatus("y");
			hrMasTransferNotification.setLastChgTime(changedTime);
			hrMasTransferNotification.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			hrMasTransferNotification.setLastChgBy(user);
			session.saveOrUpdate(hrMasTransferNotification);
			session.flush();
			session.refresh(hrMasTransferNotification);
			msg="Successfully Added.";
			b=true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b=false;
			msg="Problem Occerd ! Try Again .";
		}
		
		
		if(b){
			
			transferApplicationMList= session.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if(transferApplicationMList.size() > 0){
			for(HrTransferApplicationM htam : transferApplicationMList){
				htam.setStatus("n"); // inactive all previous Application
				session.saveOrUpdate(htam);
				
				}
			}
		}
		transferNotificationList = session.createCriteria(HrMasTransferNotification.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("transferNotificationList", transferNotificationList);
		/*System.out.println("in data>>"+transferNotificationList);*/
		map.put("msg", msg);
	
	return map;
}


@Override
public Map<String, Object> showTransferApplicationJsp(
	Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	List<MasHospitalType> hosTypelst = new ArrayList<MasHospitalType>();
	/*List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();*/
	List transferNotificationList = new ArrayList();
	int employeeId= Integer.parseInt(""+parameterMap.get("empId"));
	Date current_date = new Date();
	Session sess = getSession();
	empList = sess.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
	hosList = sess.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
 	distList = sess.createCriteria(MasDistrict.class).addOrder(Order.asc("DistrictName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	hosTypelst = sess.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
/*
	transferNotificationList = sess.createCriteria(HrMasTransferNotification.class).add(Restrictions.eq("Status", "y").ignoreCase())
								//.add(Restrictions.and(Restrictions.or(Restrictions.gt("ApplicableFromDate", current_date), Restrictions.eq("ApplicableFromDate", current_date)), Restrictions.or(Restrictions.lt("ApplicableToDate", current_date), Restrictions.eq("ApplicableToDate", current_date))))
								.add(Restrictions.or(Restrictions.gt("ApplicableFromDate", current_date), Restrictions.eq("ApplicableFromDate", current_date)))
								.add(Restrictions.or(Restrictions.lt("ApplicableToDate", current_date), Restrictions.eq("ApplicableToDate", current_date)))
								.list();*/
	String qry ="select * from hr_mas_transfer_notification nt where   nt.applicable_from_date <= NOW() and  nt.applicable_to_date >= NOW() ; ";
	transferNotificationList = sess.createSQLQuery(qry).list();
	map.put("empList",empList);
	map.put("hosList",hosList);
	map.put("distList",distList);
	map.put("hosTypelst",hosTypelst);
	map.put("transferNotificationList", transferNotificationList);
	return map;
}


@Override
public Map<String, Object> saveTransferApplication(
		Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasHospital> hosList = new ArrayList<MasHospital>();
		List<MasDistrict> distList = new ArrayList<MasDistrict>();
		Session session = getSession();
		int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
		int empid=Integer.parseInt(""+parameterMap.get("empId"));	
		String notification=""+parameterMap.get("notification");
		String withInDays=""+parameterMap.get("withInDays");	
		Users user = (Users)parameterMap.get("changedBy");
		String changedDate=""+parameterMap.get("changedDate");
		String changedTime=""+parameterMap.get("changedTime");
		
		List priorityList= (List)parameterMap.get("priorityList");
		List districtList= (List)parameterMap.get("districtList");
		List instList= (List)parameterMap.get("instList");
		String msg="";
		try{
		HrTransferApplicationM hrTransferApplicationM = new HrTransferApplicationM();
		
		MasEmployee employee = new MasEmployee();
		employee.setId(empid);
		List<HrTransferApplicationM> hrTransferApplicationMs=new ArrayList<HrTransferApplicationM>();
		hrTransferApplicationMs=session.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Employee.Id", empid))
				.add(Restrictions.or(Restrictions.isNull("TransferStstus"), Restrictions.eq("TransferStstus", "p"))).list();
		if(hrTransferApplicationMs.size()>0){
			msg="You have Allready Applied.";
		}else{
		hrTransferApplicationM.setEmployee(employee);
		
		MasHospital mh = new MasHospital();
		mh.setId(hospitalId);
		hrTransferApplicationM.setCurHospital(mh);
		System.out.println(""+notification);
		
		if(notification != null && !notification.equals("")){
		
		HrMasTransferNotification hmtn = new HrMasTransferNotification();
		hmtn.setId(Integer.parseInt(notification));
		hrTransferApplicationM.setNotificationNo(hmtn);
		}else{
			hrTransferApplicationM.setNotificationNo(null);
		}
		hrTransferApplicationM.setWithinDays(withInDays);
		
		hrTransferApplicationM.setStatus("y");
		hrTransferApplicationM.setLastChgBy(user);
		hrTransferApplicationM.setLastChgTime(changedTime);
		hrTransferApplicationM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
		session.save(hrTransferApplicationM);
		
		for(int i=0;i<instList.size();i++){
			HrTransferApplicationT hrTransferApplicationT = new HrTransferApplicationT();
			if(instList.get(i) != null && !instList.get(i).equals("0")){
				
				MasDistrict district = new MasDistrict();
				district.setId(Integer.parseInt(""+districtList.get(i)));
				hrTransferApplicationT.setDistrict(district);
				
				
				hrTransferApplicationT.setPriority(""+priorityList.get(i));
				
				MasHospital institute = new MasHospital();
				institute.setId(Integer.parseInt(""+instList.get(i)));
				hrTransferApplicationT.setInstitute(institute);
				hrTransferApplicationT.setTransferApp(hrTransferApplicationM);
				session.save(hrTransferApplicationT);
				msg="Successfully Applied";
				
			}
					
		}
		
		}
		}catch(Exception e){
			e.printStackTrace();
			msg="Try Again";
		}
		empList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empid)).list();
		hosList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		distList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("empList",empList);
		map.put("hosList",hosList);
		map.put("distList",distList);
		map.put("msg", msg);
	
	return map;
}

@Override
public Map<String, Object> showTransferApplicationApprovalJsp(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasInstituteDepartment> insWiseDepartList = new ArrayList<MasInstituteDepartment>();
	List<MasEmployeeDepartment> departList = new ArrayList<MasEmployeeDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	//List<MasGrade> gradeList = new ArrayList<MasGrade>();
	List<MasCadre> cadreList = new ArrayList<MasCadre>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasHospitalType> hosTypeList = new ArrayList<MasHospitalType>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	Session sess = getSession();
	empList = sess.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName")).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
	
	/*insWiseDepartList = sess.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.eq("Institute.Id", hospitalId)).list();*/
	distList = sess.createCriteria(MasDistrict.class).addOrder(Order.asc("DistrictName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	desigList = sess.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	cadreList = sess.createCriteria(MasCadre.class).addOrder(Order.asc("CadreName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	hosList = sess.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	hosTypeList = sess.createCriteria(MasHospitalType.class).addOrder(Order.asc("HospitalTypeName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	departList = sess.createCriteria(MasEmployeeDepartment.class).addOrder(Order.asc("EmpDeptName")).add(Restrictions.eq("Status","y").ignoreCase()).list();
	//gradeList = sess.createCriteria(MasGrade.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
	Criteria transferApp = sess.createCriteria(HrTransferApplicationM.class);
	/*	.createAlias("Employee", "e").createAlias("e.Rank", "r")
			.createAlias("e.Hospital", "curentHospital").createAlias("e.Department", "d");
		if(parameterMap.get("dept")!=null){
			transferApp.add(Restrictions.eq("d.Id", (Integer)parameterMap.get("dept")));
		}
		if(parameterMap.get("desig")!=null){
			transferApp.add(Restrictions.eq("r.Id", (Integer)parameterMap.get("desig")));
		}
		if(parameterMap.get("emp")!=null){
			transferApp.add(Restrictions.eq("e.Id", (Integer)parameterMap.get("emp")));
		}
		if(parameterMap.get("cadre")!=null){
			transferApp.createAlias("r.Cadre", "c").add(Restrictions.eq("c.Id", (Integer)parameterMap.get("cadre")));
		}
		if(parameterMap.get("district")!=null){
			transferApp.createAlias("curentHospital.District", "dis").add(Restrictions.eq("dis.Id", (Integer)parameterMap.get("district")));
		}
		if(parameterMap.get("currInsti")!=null){
			transferApp.add(Restrictions.eq("curentHospital.Id", (Integer)parameterMap.get("currInsti")));
		}*/
	hrTransferApplicationMList=transferApp.add(Restrictions.eq("Status", "p")).add(Restrictions.eq("TransferStstus","p").ignoreCase()).list();
//	System.out.println("=Tra===="+hrTransferApplicationMList.size());
	map.put("departList",departList);
	map.put("desigList",desigList);
	map.put("empList",empList);
	//map.put("gradeList",gradeList);
	map.put("cadreList",cadreList);
	map.put("distList",distList);
	map.put("hosList",hosList);
	map.put("hosTypeList",hosTypeList);
	map.put("hrTransferApplicationMList",hrTransferApplicationMList);
	
	return map;
}


@Override
public Map<String, Object> searchTransferApprovalEmployee(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasInstituteDepartment> insWiseDepartList = new ArrayList<MasInstituteDepartment>();
	List<MasDepartment> departList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	//List<MasGrade> gradeList = new ArrayList<MasGrade>();
	List<MasCadre> cadreList = new ArrayList<MasCadre>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	Session sess = getSession();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	
	String dept = ""+parameterMap.get("dept");
	String emp=""+parameterMap.get("emp");
	String desig = ""+parameterMap.get("desig");
	//String grade = ""+parameterMap.get("grade");
	String cadre=""+parameterMap.get("cadre");
	String district = ""+parameterMap.get("district");
	String currInsti = ""+parameterMap.get("currInsti");
	
	
	
	
	Criteria crit = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","y").ignoreCase());
									// status r for relieving
	if(emp != null && !emp.equals("")){
	
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Id",  Integer.parseInt(emp)));
		
	}
	if(dept != null && !dept.equals("")){
		
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Department.Id", Integer.parseInt(dept)));
		
	}
	if(desig != null && !desig.equals("")){
		
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Rank.Id", Integer.parseInt(desig)));
		
	}
	/*if(grade != null && !grade.equals("")){
		
		crit = crit.createAlias("Employee", "emp").createAlias("emp.Rank", "emp1").add(Restrictions.eq("emp1.Grade.Id", Integer.parseInt(grade)));
		
	}*/
	if(cadre != null && !cadre.equals("")){
	
		crit = crit.createAlias("Employee", "emp").createAlias("emp.Rank", "emp1").add(Restrictions.eq("emp1.Cadre.Id", Integer.parseInt(cadre)));
	
	}
	if(district != null && !district.equals("")){
	
		crit = crit.createAlias("Hospital", "Hospital").add(Restrictions.eq("Hospital.District.Id", Integer.parseInt(district)));
		
	}
	if(currInsti != null && !currInsti.equals("")){
		
		crit = crit.createAlias("Hospital", "Hospital").add(Restrictions.eq("Hospital.Id", Integer.parseInt(currInsti)));
		
	}
	hrTransferApplicationMList=crit.list();
empList = sess.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
	
	/*insWiseDepartList = sess.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.eq("Institute.Id", hospitalId)).list();*/
	distList = sess.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	desigList = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	cadreList = sess.createCriteria(MasCadre.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	hosList = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	departList = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	//gradeList = sess.createCriteria(MasGrade.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
/*	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","y").ignoreCase()).
			add(Restrictions.eq("Hospital.Id", hospitalId)).list(); // all approved Transfer
*/	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	
	
	map.put("departList",departList);
	map.put("desigList",desigList);
	map.put("empList",empList);
	//map.put("gradeList",gradeList);
	map.put("cadreList",cadreList);
	map.put("distList",distList);
	map.put("hosList",hosList);
	return map;
}

@Override
public Map<String, Object> saveTransferApplicationApproval(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session sess = getSession();
	List appList= new ArrayList();
	List rankList= new ArrayList();
	List empList= new ArrayList();
	List transfer_distList= new ArrayList();
	List transfer_instList= new ArrayList();
	List joindateList= new ArrayList();
	String msg="";
	try {
		appList = (List) parameterMap.get("appList");
		rankList = (List) parameterMap.get("rankList");
		empList = (List)parameterMap.get("empList");
		transfer_distList = (List) parameterMap.get("transfer_distList");
		transfer_instList = (List) parameterMap.get("transfer_instList");
		joindateList = (List)  parameterMap.get("joindateList");
		String remarks = ""+parameterMap.get("remark");
		String flag = ""+parameterMap.get("flag");
		int hos_id = Integer.parseInt(""+parameterMap.get("hospitalId"));
			
				
		Users user = (Users)parameterMap.get("changedBy");
		String approvedByDate=""+parameterMap.get("changedDate");
		String approvedTime=""+parameterMap.get("changedTime");
		String transferNo =(String)sess.createSQLQuery("select transfer_order_no from hr_transfer_approved order by trans_approv_id desc LIMIT 1").uniqueResult();
		int t_no=0;
		if(transferNo != null && !transferNo.equals("")){
			transferNo = transferNo.split("/")[2];
			t_no = Integer.parseInt(transferNo)+1;
		}else{
			t_no=t_no+1;
			
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		if(appList.size()>0){
			for(int i=0;i<appList.size();i++){
			if(flag.equals("a")){
		
			HrTransferApproved hta = new HrTransferApproved();
			
			HrTransferApplicationM transferApp =  new HrTransferApplicationM();
			transferApp.setId(Integer.parseInt(""+appList.get(i)));
			hta.setTransferApp(transferApp);
			
			
			MasEmployee me = new MasEmployee();
			me.setId(Integer.parseInt(""+empList.get(i)));
			hta.setEmployee(me);
			
			MasHospital transferInstitute = new MasHospital();
			transferInstitute.setId(Integer.parseInt(""+transfer_instList.get(i)));
			hta.setTransferInstitute(transferInstitute);
			
			MasDistrict transferDistrict = new MasDistrict();
			transferDistrict.setId(Integer.parseInt(""+transfer_distList.get(i)));
			hta.setTransferDistrict(transferDistrict);
			if(joindateList.size()>0 &&  !joindateList.get(i).equals("")){
				hta.setJoiningDate(HMSUtil.convertStringTypeDateToDateType(""+joindateList.get(i)));
			}
			hta.setStatus("y");
			hta.setRemarks(remarks);
			
			MasHospital hos = new MasHospital();
			hos.setId(hos_id);
			hta.setHospital(hos);
			MasHospital hospi = (MasHospital)sess.load(MasHospital.class, hos_id);
			
			hta.setTransferOrderNo(hospi.getHospitalCode()+"/"+year+"/"+t_no);
			
			
			MasEmployee approvedBy = new MasEmployee();
			approvedBy.setId(user.getEmployee().getId());
			hta.setApprovedBy(approvedBy);
			hta.setApprovedTime(approvedTime);
			hta.setApprovedByDate(HMSUtil.convertStringTypeDateToDateType(approvedByDate));
			
			HrTransferApplicationM transferApp1 = (HrTransferApplicationM)sess.load(HrTransferApplicationM.class, Integer.parseInt(""+appList.get(i)));
			transferApp1.setStatus("a"); // a for transfer Approval 
			transferApp1.setTransferStstus("a");
			sess.saveOrUpdate(transferApp1);
			
			sess.save(hta);
			msg="Successfully Save.";
			String subject = "Transfer approved";
			String mailContent = "Hi \n\n  your transfer has been approved ";
					/*+ name + " having Employee Code :" + empId + ":- \n\n";*/
			
			boolean sent = false;
			/*if ((Boolean) map.get("flag")) {*/
				try {
					//sent = SendMail.sendMail("", me.getEmail(), "javed.khan@jktech.com", "", "", subject,mailContent);
							
							
				} catch (Exception e) {
					sent = false;
					e.printStackTrace();
				}
				if (sent) {
					
					msg += " and a mail notification has been sent to corresponding Employee";
					
				}

			/*}*/
			
			map.put("msg",msg);
			
		}else if(flag.equals("r")){
			
			HrTransferApplicationM transferApp1 = (HrTransferApplicationM)sess.load(HrTransferApplicationM.class, Integer.parseInt(""+appList.get(i)));
			transferApp1.setStatus("c"); // c for transfer reject 
			sess.saveOrUpdate(transferApp1);
			msg="Successfully Save.";
			
		}
			}
		}
	}  catch (Exception e) {
		msg="problem occerud! Try again.";
		e.printStackTrace();
	}
	return map;
}


@Override
public Map<String, Object> getRelievingWaitingListJsp(
		Map<String, Object> parameterMap) {
	// TODO Auto-generated method stub
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasDeathCause> deathCauseList = new ArrayList<MasDeathCause>();
	
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	Session sess = getSession();
	hrTransferApplicationMList = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","a").ignoreCase()).
									add(Restrictions.eq("CurHospital.Id", hospitalId)).list(); // status a for selecting approve Transfer
	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","y").ignoreCase()).
			/*add(Restrictions.eq("Hospital.Id", hospitalId)).*/list(); // all approved Transfer
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("HospitalName")).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	deathCauseList = sess.createCriteria(MasDeathCause.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	//System.out.println("deathCauseList>>>>>>>>>>>>>>>>>"+deathCauseList.size());
	
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("hosList", hosList);
	map.put("deathCauseList", deathCauseList);
	return map;
}

@Override
public Map<String, Object> searchWaitingReleivingListJsp(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	Session sess = getSession();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	
	String employee_name = ""+parameterMap.get("employee_name");
	String department=""+parameterMap.get("department");
	String designation = ""+parameterMap.get("designation");
	
	//System.out.println(employee_name+"-   -"+department+"-    -"+designation);
	Criteria crit = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","a").ignoreCase()).
									add(Restrictions.eq("CurHospital.Id", hospitalId)); // status r for relieving
	if(employee_name != null && !employee_name.equals("")){
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.EmployeeName", employee_name.trim()).ignoreCase());
		
	}
	if(department != null && !department.equals("")){
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Department.Id", Integer.parseInt(department)));
		
	}
	if(designation != null && !designation.equals("")){
		crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Rank.Id", Integer.parseInt(designation)));
		
	}
	hrTransferApplicationMList=crit.list();
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","y").ignoreCase()).
			/*add(Restrictions.eq("Hospital.Id", hospitalId)).*/list(); // all approved Transfer
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	return map;
}

@Override
public Map<String, Object> showEmpRelievingJsp(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasOpSession> sesList = new ArrayList<MasOpSession>();
	
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	int id= Integer.parseInt(""+parameterMap.get("id"));
	//System.out.println("id>>>"+id);
	Session sess = getSession();
	hrTransferApplicationMList = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","a").ignoreCase()).
			add(Restrictions.eq("Id", id)).list(); // status a for selecting approve Transfer from transfer application
	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","y").ignoreCase()).
					add(Restrictions.eq("TransferApp.Id", id)).list(); // all approved Transfer from transfer Approval Table
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	sesList = sess.createCriteria(MasOpSession.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	

	
	hrTerminationProcessList = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","a").ignoreCase()).
			add(Restrictions.eq("Id", id)).list(); // status a for selecting approve Transfer from transfer application
	
	
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("sesList", sesList);

	return map;
}

@Override
public Map<String, Object> saveEmpRelieving(Map<String, Object> parameterMap) {

	
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	Session session = getSession();
	
	int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int transferApp_id=Integer.parseInt(""+parameterMap.get("transferApp_id"));
	
	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int instituteId=Integer.parseInt(""+parameterMap.get("cur_instituteId"));	

	String joining_date=""+parameterMap.get("reliving_date");
	String actualJoiningDate=""+parameterMap.get("actualRelivingDate");
	/*String mode_of_Retire=""+parameterMap.get("mode_of_Retire");*/
	String releiving_sesson=""+parameterMap.get("releiving_sesson");
	String remarks=""+parameterMap.get("remarks");
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	String msg="";
	String mode=""+parameterMap.get("mode");
	

	Transaction tx = session.beginTransaction();
	System.out.println(""+transferApp_id);
	try {
		if(mode.equalsIgnoreCase("Transfer")){
			
			int transferApprove_id=Integer.parseInt(""+parameterMap.get("transferApprove_id"));
			int from_instituteId=Integer.parseInt(""+parameterMap.get("trans_instituteId"));	
			
		HrTransferApplicationM htam = (HrTransferApplicationM)session.load(HrTransferApplicationM.class, transferApp_id);
		htam.setStatus("r"); // r for relieving
		session.update(htam);
		session.flush();
		session.refresh(htam);
		
		System.out.println(releiving_sesson+"   "+transferApp_id);
		
		HrTransferApproved hta = (HrTransferApproved)session.load(HrTransferApproved.class, transferApprove_id);
		hta.setActualReleivingDate(HMSUtil.convertStringTypeDateToDateType(actualJoiningDate));
		
		/*MasOpSession mos = new MasOpSession();
		mos.setId(Integer.parseInt(releiving_sesson));
		hta.setReleivingSession(mos);*/
		
		hta.setStatus("r");// r for relieving
		session.saveOrUpdate(hta);
		session.flush();
		
		session.refresh(hta);
		}else{
			HrTerminationProcess htp = (HrTerminationProcess)session.load(HrTerminationProcess.class, transferApp_id);
			htp.setStatus("r"); // r for relieving
			session.update(htp);
			session.flush();
			session.refresh(htp);
			
			MasEmployee me =  (MasEmployee)session.load(MasEmployee.class, empid);
			me.setStatus("n");
			session.update(me);
			session.flush();
			session.refresh(me);
			
			
			
			hrTerminationProcessList = session.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","a").ignoreCase()).
					add(Restrictions.eq("FromInstitute.Id", hospitalId)).list(); //  for selecting suspend Employee
			map.put("hrTerminationProcessList", hrTerminationProcessList);
			
		}
		tx.commit();
		msg="Save Successfully.";
	} catch (HibernateException e) {
		tx.rollback();
		msg="Some Problem occured ! try again";
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	map.put("msg", msg);
	return map;
}

@Override
public Map<String, Object> saveEmpJoining(Map<String, Object> parameterMap) {
	
	
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	
	List<Users> userDetails = new ArrayList<Users>();
	List<UserHospital> userHospital = new ArrayList<UserHospital>();
	
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();	
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	Session session = getSession();
	
	int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int transferApp_id=Integer.parseInt(""+parameterMap.get("transferApp_id"));

	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int instituteId=Integer.parseInt(""+parameterMap.get("instituteId"));	
	//int from_instituteId=Integer.parseInt(""+parameterMap.get("from_instituteId"));	
	String joining_date=""+parameterMap.get("joining_date");
	String actualJoiningDate=""+parameterMap.get("actualJoiningDate");
	String joining_time=""+parameterMap.get("joining_time");
	String joining_session=""+parameterMap.get("session");
	String remarks=""+parameterMap.get("remarks");
	String mode=""+parameterMap.get("mode");
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	
	Transaction Tx = session.beginTransaction();
	String msg="";
	int transferApprove_id=0;
	try{
		
		HrJoiningDetails empjoin = new HrJoiningDetails();
		empjoin.setJoiningMode(mode);
		
		if(mode.equalsIgnoreCase("Transfer")){ // for transfer
			 transferApprove_id=Integer.parseInt(""+parameterMap.get("transferApprove_id"));
		HrTransferApproved hta = new HrTransferApproved();
		hta.setId(transferApprove_id);
		empjoin.setTransApprov(hta);
		}else{ // for Suspension
			HrTerminationProcess htp = new HrTerminationProcess();
			htp.setId(transferApp_id);
			empjoin.setTerminationProcess(htp);
			
		}
		 
		empjoin.setJoiningDate(HMSUtil.convertStringTypeDateToDateType(joining_date));
		empjoin.setActualJoiningDate(HMSUtil.convertStringTypeDateToDateType(actualJoiningDate));
		
		MasHospital join_insti = new MasHospital();
		join_insti.setId(hospitalId);
		empjoin.setJoiningInstitute(join_insti);
		
		empjoin.setJoiningTime(joining_time);
		
		MasOpSession mos = new MasOpSession();
		mos.setId(Integer.parseInt(joining_session));
		empjoin.setJoiningSession(mos);
		
		empjoin.setStatus("y");
		
		empjoin.setJoiningRemarks(remarks);
		empjoin.setLastChgBy(user);
		empjoin.setLastChgTime(changedTime);
		empjoin.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
		
		session.save(empjoin);
		
		
		HrTransferApproved hrTransferApproved = null;
		
		if(mode.equalsIgnoreCase("Transfer")){ // for transfer
		 hrTransferApproved = (HrTransferApproved) session.load(HrTransferApproved.class, transferApprove_id);
		hrTransferApproved.setStatus("j");
		session.saveOrUpdate(hrTransferApproved);
		session.flush();
		session.refresh(hrTransferApproved);
		
		HrTransferApplicationM hrTransferApplicationM  =(HrTransferApplicationM) session.load(HrTransferApplicationM.class, transferApp_id);
		hrTransferApplicationM.setStatus("j");
		session.saveOrUpdate(hrTransferApplicationM);
		session.flush();
		session.refresh(hrTransferApplicationM);
		}
		
		HrTerminationProcess hrTerminationProcess = null;
		if(mode.equalsIgnoreCase("Suspension")){
			hrTerminationProcess = (HrTerminationProcess) session.load(HrTerminationProcess.class, transferApp_id); 
			hrTerminationProcess.setStatus("j");
			session.saveOrUpdate(hrTerminationProcess);
			session.flush();
			session.refresh(hrTerminationProcess);
			
		}
		
		// create Employee History
		
		MasEmployee me = (MasEmployee) session.load(MasEmployee.class, empid);
		
		MasEmployeeHistory meh = new MasEmployeeHistory();
		meh.setEmployee(me);
		meh.setDepartment(me.getDepartment());
		meh.setHospital(me.getHospital());
		meh.setRank(me.getRank());
		meh.setMode(mode);
		if(mode.equalsIgnoreCase("Transfer")){ // for transfer
		meh.setTransferDate(hrTransferApproved.getActualReleivingDate());
		}else{ // for suspension
			meh.setTransferDate(hrTerminationProcess.getFromDate());
		}
		session.save(meh);
		session.flush();
		session.refresh(meh);
		
		
		// update in Mas Employee
		 
		me.setHospital(join_insti);
		session.saveOrUpdate(me);
		session.flush();
		session.refresh(me);
		
		//Update Hospital to users table and user_hospital --- Kaushal Mishra
		
		 MasEmployee mEmp = (MasEmployee) session.load(MasEmployee.class, empid);
		 userDetails=session.createCriteria(Users.class,"u").createAlias("u.Employee", "e").add(Restrictions.eq("e.Id", empid)).list();
		 int userId= userDetails.get(0).getId();
		 
		 userHospital=session.createCriteria(UserHospital.class,"uh").createAlias("uh.User", "u").add(Restrictions.eq("u.Id", userId)).list();
		 
		 int userHosId= userHospital.get(0).getId();
		 
		 Users us= (Users) session.load(Users.class, userId);
		 MasHospital masHos = new MasHospital();
		 masHos.setId(mEmp.getHospital().getId());
		 us.setHospital(masHos);
		 
		 UserHospital userHos= (UserHospital) session.load(UserHospital.class, userHosId);
		 MasHospital masHosp = new MasHospital();
		 masHosp.setId(mEmp.getHospital().getId());
		 userHos.setHospital(masHosp);
		 
		 session.saveOrUpdate(userHos);
		 session.saveOrUpdate(us);
		 
		//Ended
		
		Tx.commit();
		msg="Successfully Joined";
	}catch(Exception e){
		Tx.rollback();
		e.printStackTrace();
		msg="Try Again !";
		
	}
	
	
	hrTransferApplicationMList = session.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","r").ignoreCase()).
									add(Restrictions.eq("TrHospital.Id", hospitalId)).list(); // status r for selecting releiving and (joining in this insti) Transfer
	hrTransferApprovedList = session.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","r").ignoreCase()).
			add(Restrictions.eq("TransferInstitute.Id", hospitalId)).list(); // all  releiving and (joining in this insti) Transfer
	hosList  = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("hosList", hosList);
	map.put("msg", msg);
	
	return map;
}

@Override
public Map<String, Object> saveEmpDeputaion(Map<String, Object> parameterMap) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasHospital> hosList = new ArrayList<MasHospital>();
		List<UploadDocuments> tempdocAttachList = new ArrayList<UploadDocuments>();
		HrEmployeeDeputation deputeEmployee = new HrEmployeeDeputation();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String Msg="";
		int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
		int empid=Integer.parseInt(""+parameterMap.get("empid"));
		int depute_instituteId=0;
		if(parameterMap.get("depute_instituteId")!=null){
			depute_instituteId=Integer.parseInt(String.valueOf(parameterMap.get("depute_instituteId")));
		}
		//String depute_instituteId=""+parameterMap.get("depute_instituteId");
		
		int cur_instituteId=Integer.parseInt(""+parameterMap.get("cur_instituteId"));	
			
		int cur_departmentId=Integer.parseInt(""+parameterMap.get("cur_departmentId"));	
		int cur_designationId=Integer.parseInt(""+parameterMap.get("cur_designationId"));
		//Date fromDate=(Date)parameterMap.get("fromDate");
		//Date toDate=(Date)parameterMap.get("toDate");
		String remarks="";
		if(parameterMap.get("remarks")!=null)
		remarks=""+parameterMap.get("remarks");
		String changedTime=""; 
 		Users user = (Users)parameterMap.get("changedBy");
		Date changedDate=(Date)parameterMap.get("changedDate");
		if(parameterMap.get("changedTime")!=null)
		changedTime=""+parameterMap.get("changedTime");
		Date currentDate=(Date)parameterMap.get("currentDate");
		int deputePeriod=Integer.parseInt(""+parameterMap.get("deputePeriod"));	
		String deputePeriodUnit=""+parameterMap.get("deputePeriodUnit");
		String orderDate=""+parameterMap.get("orderDate");
 		String order_no=""+parameterMap.get("order_no");
 		String others ="";
 		if(parameterMap.get("others")!=null){
 			others=(String)parameterMap.get("others");
 		}
		
 		String filename = "";
		if(parameterMap.get("filename")!= null){
			filename =(String) parameterMap.get("filename");
		}
		String whiteList = "";
		if(parameterMap.get("whiteList")!= null){
			whiteList =(String) parameterMap.get("whiteList");
		}
		
		String uploadURL = "";
		if(parameterMap.get("uploadURL")!= null){
			uploadURL =(String) parameterMap.get("uploadURL");
		}
		String comments = "";
		if(parameterMap.get("comments")!= null){
			comments =(String) parameterMap.get("comments");
		}
		String fileSeparator="";
		if(parameterMap.get("fileSeparator")!= null){
		fileSeparator =(String) parameterMap.get("fileSeparator");
	    }
		
		
		int request_id = 0;
		if(parameterMap.get("request_id")!= null){
			request_id =(Integer) parameterMap.get("request_id");
		}
		
		int employeeId = 0;
		if(parameterMap.get("employeeId")!= null){
			employeeId =(Integer) parameterMap.get("employeeId");
		}
		String fileExtension=null;
		
		
		 File file=null;
 		
		
 		Transaction tx = session.beginTransaction();

		try {
		
			MasEmployee me =(MasEmployee)hbt.get(MasEmployee.class, empid);
			me.setStatus("d");
			hbt.update(me);
			deputeEmployee.setEmployee(me);
		
			MasDepartment curDep = new MasDepartment();
			curDep.setId(cur_departmentId);
			deputeEmployee.setCurDepartment(curDep);
			
			MasHospital curHos = new MasHospital();
			curHos.setId(hospitalId);
			deputeEmployee.setCurHospital(curHos);
			
			MasRank curDes = new MasRank();
			curDes.setId(cur_designationId);
			deputeEmployee.setCurDesignation(curDes);
			
			MasDepartment deputDep = new MasDepartment();
			deputDep.setId(cur_departmentId);
			deputeEmployee.setDepuDepartment(deputDep);
			
			MasHospital deputHos = new MasHospital();
			deputHos.setId(depute_instituteId);
			deputeEmployee.setDepuHospital(deputHos);
			
			MasRank deputDes = new MasRank();
			deputDes.setId(cur_designationId);
			deputeEmployee.setDepuDesignation(deputDes);
			
			//deputeEmployee.setFromDate(fromDate);
			//deputeEmployee.setToDate(toDate);
			deputeEmployee.setRemarks(remarks);
			  
			deputeEmployee.setStatus("y");
			deputeEmployee.setLastChgBy(user);
			deputeEmployee.setLastChgTime(changedTime);
			deputeEmployee.setLastChgDate(changedDate);
			//deputeEmployee.setOrderDate(orderDate);
			deputeEmployee.setOrderDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
			deputeEmployee.setOrderNo(order_no);
			deputeEmployee.setDepuPeriod(deputePeriod);
			deputeEmployee.setDepuPeriodUnit(deputePeriodUnit);
			deputeEmployee.setOtherInstitution(others);
			hbt.save(deputeEmployee);
 			//session.flush();
			//session.refresh(deputeEmployee);
			


			// masSpDepValue.setImgFile(bytes);

			/*
			 * MasDepartment masDep = (MasDepartment) hbt.get(
			 * MasDepartment.class, Integer.parseInt(dpartName));
			 */
            int i=1;
			if (!filename.equals("0")) {
				 UploadDocuments deputeDoc = new UploadDocuments();	
				
				file = new File(uploadURL + fileSeparator + "hrms"
						+ fileSeparator + filename);

				File f = new File(uploadURL);
				try {
					if (f.exists()) {
						/*f.delete();
						f.mkdir();*/
						FileInputStream is = new FileInputStream(file);
						long length = file.length();

						if (length > Integer.MAX_VALUE) {
							// File is too large
						}
						// Create the byte array to hold the data
						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file.getName());
						}
						is.close();

						 deputeDoc.setPatientDocument(bytes);
						  deputeDoc.setFileName(filename); 
						  deputeDoc.setDeputation(deputeEmployee);
						  deputeDoc.setFileExtension(whiteList);
						  deputeDoc.setLastChgBy(user);
						  deputeDoc.setLastChgDate(currentDate);
						  
						  hbt.save(deputeDoc);
					    	     
						
					} else {
						f.mkdir();
						FileInputStream is = new FileInputStream(file);
						long length = file.length();
						// ByteBuffer byteBuff=null;
						// int modLength=length/
						if (length > Integer.MAX_VALUE) {
							// File is too large
						}
						// Create the byte array to hold the data
						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file.getName());
						}
						is.close();

						 deputeDoc.setPatientDocument(bytes);
						  deputeDoc.setFileName(filename); 
						  deputeDoc.setDeputation(deputeEmployee);
						  deputeDoc.setFileExtension(whiteList);
						  deputeDoc.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
						  deputeDoc.setLastChgBy(user);
						  hbt.save(deputeDoc);
					
					}

				} catch (Exception e) {
					e.printStackTrace();
                
                 
				}
   	   
   	    // deputation.setId(request_id);
   	    
   	 //    deputeDoc.setDescription(comments);
   	    /* MasEmployee masEmployee = new MasEmployee();
   	     masEmployee.setId(employeeId);
   	     deputeDoc.set;*/
   	    
    	     
    	    /* UploadDocuments deputeDoc = new UploadDocuments();
    	     deputeDoc.setPatientDocument(bytes);
    	     deputeDoc.setFileName(filename);
    	   
    	     HrEmployeeDeputation deputation = new HrEmployeeDeputation();
    	     deputation.setId(request_id);
    	     deputeDoc.setDeputation(deputation);
    	     deputeDoc.setDescription(comments);
    	     MasEmployee masEmployee = new MasEmployee();
    	     masEmployee.setId(employeeId);
    	     deputeDoc.set;
    	     hbt.save(deputeDoc);
    	     hbt.flush();
    	     hbt.refresh(deputeDoc);*/
		 
 			
			}
			tx.commit();
 			hbt.flush();
 			hbt.clear();
			Msg="successfully saved";	
		} catch (HibernateException e) {
		
			tx.rollback();
			Msg="Some Problem occured ! try again";
			e.printStackTrace();
		}
		
		map.put("msg",Msg);
		map.put("deputeEmployee",deputeEmployee);
		return map;
}



@Override
public Map<String, Object> saveEmpTermination(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	Session session = getSession();
	String msg="";
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	HrTerminationProcess hrTerminationProcess=new HrTerminationProcess();
	int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int depute_instituteId=Integer.parseInt(""+parameterMap.get("instituteId")); 
	int suspendBy=Integer.parseInt(""+parameterMap.get("suspendBy"));	
	Transaction tx = null;
	try {
		tx=session.beginTransaction();
 	String fromDate=""+parameterMap.get("fromDate");
 	String orderDate=""+parameterMap.get("orderDate");
	String remarks=""+parameterMap.get("remarks");	
 	String reason=""+parameterMap.get("reason");	
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	MasHospital hospital=new MasHospital();
	hospital.setId(hospitalId);
	hrTerminationProcess.setFromInstitute(hospital);
	MasEmployee masEmployee = (MasEmployee)session.get(MasEmployee.class, empid);
	masEmployee.setStatus("t");
	hbt.update(masEmployee);
	hrTerminationProcess.setEmployeeId(masEmployee);
	MasEmployee masEmployee1=new MasEmployee();
	masEmployee1.setId(suspendBy);
	hrTerminationProcess.setActionBy(masEmployee1);
	hrTerminationProcess.setLastChgBy(user);
	hrTerminationProcess.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(fromDate));
	hrTerminationProcess.setRemarks(remarks);
	hrTerminationProcess.setReason(reason);
	hrTerminationProcess.setTerminationMode("Termination");
	hrTerminationProcess.setStatus("a");
	hrTerminationProcess.setLastChgTime(changedTime);
	hrTerminationProcess.setOrderDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
	hbt.save(hrTerminationProcess);
	hbt.flush();
	hbt.clear();
	tx.commit();
	msg="Successfully Save.";
	}catch(Exception e){
		msg="Try Again.";
		tx.rollback();
	}
	map.put("msg", msg);
	return map;
}


public Map<String, Object> saveEmpDeath(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	Session session = getSession();
	
	int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int instituteId=Integer.parseInt(""+parameterMap.get("instituteId"));	
	
	String deathDate=""+parameterMap.get("deathDate");
	String remarks=""+parameterMap.get("remarks");	
	String onDuty=""+parameterMap.get("onDuty");	
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	String msg="";
	Transaction tx = session.beginTransaction();
	try {
		HrDeathRegister hrEmpDeath = new HrDeathRegister();
		
		MasEmployee employee = new MasEmployee();
		employee.setId(empid);
		hrEmpDeath.setEmployee(employee);
		
		hrEmpDeath.setDeathOnDuty(onDuty);
		hrEmpDeath.setRemarks(remarks);
		hrEmpDeath.setStatus("y");
		hrEmpDeath.setLastChgBy(user);
		hrEmpDeath.setDeathDate(HMSUtil.convertStringTypeDateToDateType(deathDate));
		hrEmpDeath.setLastChgTime(changedTime);
		hrEmpDeath.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
		session.save(hrEmpDeath);
		session.flush();
		session.refresh(hrEmpDeath);
		
		
		MasEmployee me =(MasEmployee) session.load(MasEmployee.class, empid);
		me.setStatus("n");
		MasEmpStatus employeeStatus = new MasEmpStatus();
		employeeStatus.setId(8); // death
		me.setEmployeeStatus(employeeStatus);
		session.save(me);
		session.flush();
		session.refresh(me);
		
		 msg="Successfully save.";
		 tx.commit();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		 msg="Problem Occured Try Again.";
		 tx.rollback();
		e.printStackTrace();
	}
	
	map.put("msg", msg);
	
	return map;
}

@Override
public Map<String, Object> viewTransferPriority(Map<String, Object> detailMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApplicationT> hrTransferApplicationTList = new ArrayList<HrTransferApplicationT>();
	Session session = getSession();
	int appId = 0;
	if(detailMap.get("appId") != null){
		appId =(Integer)detailMap.get("appId");
	}
	hrTransferApplicationTList = session.createCriteria(HrTransferApplicationT.class)./*add(Restrictions.eq("Status","a").ignoreCase())*/
			add(Restrictions.eq("TransferApp.Id", appId)).list();
	map.put("hrTransferApplicationTList", hrTransferApplicationTList);
	return map;
}

@Override
public Map<String, Object> getJoiningWaitingListJsp(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	Session sess = getSession();
	hrTransferApplicationMList = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","r").ignoreCase()).
									add(Restrictions.eq("TrHospital.Id", hospitalId)).list(); // status r for selecting relieving and (joining in this insti) Transfer
	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","r").ignoreCase()).
			add(Restrictions.eq("TransferInstitute.Id", hospitalId)).list(); // all  relieving and (joining in this insti) Transfer
	
	
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date sus_toDate = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(sus_toDate);
	 cal.add(Calendar.DATE, -1);
	System.out.println("todate>>>"+HMSUtil.convertStringTypeDateToDateType(dateFormat.format(cal.getTime())));
	hrTerminationProcessList = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","r").ignoreCase()).
			add(Restrictions.eq("FromInstitute.Id", hospitalId)).add(Restrictions.eq("ToDate", HMSUtil.convertStringTypeDateToDateType(dateFormat.format(cal.getTime())))).list(); // all  relieving of suspend (which employee suspend to date, one day previous of current Date )
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("hrTerminationProcessList", hrTerminationProcessList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("hosList", hosList);
	return map;
}

@Override
public Map<String, Object> showEmpjoiningJsp(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasOpSession> sesList = new ArrayList<MasOpSession>();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	int id= Integer.parseInt(""+parameterMap.get("id"));
	String mode=""+parameterMap.get("mode");
	//System.out.println("id>>>"+id);
	Session sess = getSession();
	/*hrTransferApplicationMList = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","a").ignoreCase()).
			add(Restrictions.eq("Id", id)).list(); // status a for selecting approve Transfer from transfer application
*/	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","r").ignoreCase()).
					add(Restrictions.eq("Id", id)).list(); // particular joining Employee from transfer Approval Table
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	sesList = sess.createCriteria(MasOpSession.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
	hrTerminationProcessList = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","r").ignoreCase()).
			add(Restrictions.eq("Id", id)).list(); // particular joining Employee from transfer Approval Table
			
	System.out.println("mode"+mode);
			 
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("hrTerminationProcessList", hrTerminationProcessList);
	map.put("mode", mode);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("sesList", sesList);
	return map;
}

@Override
public Map<String, Object> showSuspentionJsp(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasEmployee> suspendByList = new ArrayList<MasEmployee>();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	
	Session sess = getSession();
	hrTransferApplicationMList = sess.createCriteria(HrTransferApplicationM.class).add(Restrictions.eq("Status","a").ignoreCase()).
									add(Restrictions.eq("CurHospital.Id", hospitalId)).list(); // status a for selecting approve Transfer
	hrTransferApprovedList = sess.createCriteria(HrTransferApproved.class).add(Restrictions.eq("Status","y").ignoreCase()).
			/*add(Restrictions.eq("Hospital.Id", hospitalId)).*/list(); // all approved Transfer
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	suspendByList=sess.createCriteria(MasEmployee.class).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("EmployeeName")).list();
	 
	map.put("hrTransferApplicationMList", hrTransferApplicationMList);
	map.put("hrTransferApprovedList", hrTransferApprovedList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("hosList", hosList);
	map.put("suspendByList", suspendByList);
	return map;
}

@Override
public Map<String, Object> getSuspendByList(Map parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> suspendByList = new ArrayList<MasEmployee>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	int empId= Integer.parseInt(""+parameterMap.get("empId"));
	System.out.println("empId"+empId);
	Session sess = getSession();
	MasEmployee me = (MasEmployee)sess.load(MasEmployee.class,empId);
	if(me.getRank().getDesignationOrder() != null && ! me.getRank().getDesignationOrder().equals("")){
		  int designation_order =me.getRank().getDesignationOrder();
		
		 // LogicalExpression exp =  Restrictions.or(Restrictions.eq("DesignationOrder", (designation_order-1)), Restrictions.eq("DesignationOrder", (designation_order-2)));
		  List al = new ArrayList();
		  
		  al.add((designation_order-1)); 
		 // al.add((designation_order-2)); 
		 // al.add((designation_order-3));
		  System.out.println("designation_order"+designation_order);
		 
		  desigList = getSession().createCriteria(MasRank.class).add(Restrictions.eq("Status","n").ignoreCase()).add(Restrictions.in("DesignationOrder",al))
				  					.setProjection(Projections.projectionList().add(Projections.groupProperty("Id"))).list();
		  System.out.println("desigList"+desigList.size());
		  if(desigList.size()>0){
			  suspendByList = getSession().createCriteria(MasEmployee.class).add(Restrictions.in("Rank.Id", desigList)).list();
		  }
	}
		System.out.println("===="+suspendByList.size());
		map.put("suspendByList", suspendByList);
	return map;
}
@Override
public Map<String, Object> getEmpInfoForEmpSuspension(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session ses = getSession();
	String PEN = ""+parameterMap.get("PEN");
	List<MasEmployee> emplList = new ArrayList<MasEmployee>();
	emplList = ses.createCriteria(MasEmployee.class).add(Restrictions.eq("PEN",PEN)).add(Restrictions.eq("Status", "y")).list();
	map.put("emplList", emplList);
	return map;
}

@Override
public Map<String, Object> saveEmpSuspention(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
	List<UploadDocuments> tempdocAttachList = new ArrayList<UploadDocuments>();
	
	Session session = getSession();
	 
	int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int suspensioninstituteId=Integer.parseInt(""+parameterMap.get("instituteId"));	
	int suspendBy=Integer.parseInt(""+parameterMap.get("suspendBy"));	
 	String remarks=""+parameterMap.get("remarks");
 	String mode=""+parameterMap.get("mode");	
	String reason=""+parameterMap.get("reason");	
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	String orderDate=""+parameterMap.get("orderDate");
	String order_no=""+parameterMap.get("order_no");
	String suspPeriodUnit = "";
	int suspPeriod = 0;
	String msg="";
	 Date toDate=new Date();
	 Date fromDate=new Date();
	//System.out.println("fromDatein data>>"+fromDate);
	if(parameterMap.get("suspPeriod")!=null && !parameterMap.get("suspPeriod").equals(""))
	{
			
		suspPeriod=Integer.parseInt(""+parameterMap.get("suspPeriod"));
	}
	if(parameterMap.get("suspPeriodUnit")!=null && !parameterMap.get("suspPeriodUnit").equals(""))
	{
		suspPeriodUnit= (String) (parameterMap.get("suspPeriod"));
	}
	
	String filename = "";
	if(parameterMap.get("filename")!= null){
		filename =(String) parameterMap.get("filename");
	}
	String whiteList = "";
	if(parameterMap.get("whiteList")!= null){
		whiteList =(String) parameterMap.get("whiteList");
	}
	
	String uploadURL = "";
	if(parameterMap.get("uploadURL")!= null){
		uploadURL =(String) parameterMap.get("uploadURL");
	}
	String comments = "";
	if(parameterMap.get("comments")!= null){
		comments =(String) parameterMap.get("comments");
	}
	String fileSeparator="";
	if(parameterMap.get("fileSeparator")!= null){
	fileSeparator =(String) parameterMap.get("fileSeparator");
    }
	 
	int request_id = 0;
	if(parameterMap.get("request_id")!= null){
		request_id =(Integer) parameterMap.get("request_id");
	}
	
	int employeeId = 0;
	if(parameterMap.get("employeeId")!= null){
		employeeId =(Integer) parameterMap.get("employeeId");
	}
	String fileExtension=null;
	 
	 File file=null;
	 
	 if(parameterMap.get("fromDate") != null && !(parameterMap.get("fromDate").equals(""))){
		fromDate =((Date) parameterMap.get("fromDate")) ;
		parameterMap.put("fromDate", fromDate);
	}
	
	if(parameterMap.get("toDate") != null && !(parameterMap.get("toDate").equals(""))){
		toDate =((Date) parameterMap.get("toDate")) ;
		parameterMap.put("toDate", toDate);
	} 
	
	Transaction tx = session.beginTransaction();
	try {
		HrTerminationProcess htp = new HrTerminationProcess();
 		//--- For Suspen
		MasEmployee me = (MasEmployee)session.get(MasEmployee.class, empid);
		me.setStatus("s");
		session.update(me);
		session.flush();
		session.refresh(me);
		htp.setEmployeeId(me);
		htp.setTerminationMode(mode);
		
		MasHospital fromInsti = new MasHospital();
		fromInsti.setId(suspensioninstituteId);
		htp.setFromInstitute(fromInsti);
		
		MasEmployee suspendby = new MasEmployee();
		suspendby.setId(suspendBy);
		htp.setActionBy(suspendby);
		if(!mode.equals("Suspension")){
		 htp.setFromDate(fromDate);
		 htp.setToDate(toDate);
		}
		//if(mode.equals("Suspension")){
			htp.setSuspensionPeriod(suspPeriod);
			htp.setSuspensionPeriodUnit(suspPeriodUnit);
			//}
		htp.setReason(reason);
		htp.setRemarks(remarks);
		htp.setStatus("a");
		htp.setLastChgBy(user);
		htp.setLastChgTime(changedTime);
		htp.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
		
		htp.setOrderDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
		htp.setOrderNo(order_no);
		
		session.save(htp);
	//	session.flush();
	//	session.refresh(htp);
		
		if(mode.equals("Suspension")){
		MasEmployee employeeSuspend = (MasEmployee)session.load(MasEmployee.class, empid);
		
		MasEmpStatus employeeStatus = new MasEmpStatus();
		employeeStatus.setId(5); // suspend
		employeeSuspend.setEmployeeStatus(employeeStatus);
		
		session.save(employeeSuspend);
 		session.flush();
		session.refresh(employeeSuspend);
		
		 int i=1;
			if (!filename.equals("0")) {
				 UploadDocuments deputeDoc = new UploadDocuments();	
				
				file = new File(uploadURL + fileSeparator + "hrms"
						+ fileSeparator + filename);

				File f = new File(uploadURL);
				try {
					if (f.exists()) {
						/*f.delete();
						f.mkdir();*/
						FileInputStream is = new FileInputStream(file);
						long length = file.length();

						if (length > Integer.MAX_VALUE) {
							// File is too large
						}
						// Create the byte array to hold the data
						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file.getName());
						}
						is.close();

						  deputeDoc.setPatientDocument(bytes);
						  deputeDoc.setFileName(filename); 
						  deputeDoc.setEmployee(employeeSuspend);
						  deputeDoc.setFileExtension(whiteList);
						  deputeDoc.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
						  deputeDoc.setLastChgBy(user);
						 // deputeDoc.setLastChgDat
						  
						  session.save(deputeDoc);
						  session.flush();
						   session.refresh(deputeDoc);
					    	     
						
					} else {
						f.mkdir();
						FileInputStream is = new FileInputStream(file);
						long length = file.length();
						// ByteBuffer byteBuff=null;
						// int modLength=length/
						if (length > Integer.MAX_VALUE) {
							// File is too large
						}
						// Create the byte array to hold the data
						byte[] bytes = new byte[(int) length];
						int offset = 0;
						int numRead = 0;
						while (offset < bytes.length
								&& (numRead = is.read(bytes, offset,
										bytes.length - offset)) >= 0) {
							offset += numRead;
						}

						if (offset < bytes.length) {
							throw new IOException(
									"Could not completely read file "
											+ file.getName());
						}
						is.close();

						 deputeDoc.setPatientDocument(bytes);
						  deputeDoc.setFileName(filename); 
						  deputeDoc.setEmployee(employeeSuspend);
						  deputeDoc.setFileExtension(whiteList);
						  deputeDoc.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(orderDate));
						  deputeDoc.setLastChgBy(user);
						  deputeDoc.setDescription("Suspended");
						  session.save(deputeDoc);
						  session.flush();
						   session.refresh(deputeDoc);
					
					}


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 }
		  msg="Successfully Saved.";
		 tx.commit();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		 msg="Problem Occured Try Again.";
		 tx.rollback();
		e.printStackTrace();
	}
	
	map.put("msg", msg);
	
	return map;
}

@Override
public Map<String, Object> getRelievingWaitingListForSuspaAndTermin(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasEmployeeDepartment> masEmployeeDepartments=new ArrayList<MasEmployeeDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	Session sess = getSession();
	masEmployeeDepartments=getEmployeeDepartmentId(hospitalId);
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	
	System.out.println(""+hospitalId);
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	hrTerminationProcessList = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","a").ignoreCase()).
			add(Restrictions.eq("FromInstitute.Id", hospitalId)).list(); //  for selecting suspend Employee

	map.put("departList", masEmployeeDepartments);
	map.put("desigList", desigList);
	map.put("hosList", hosList);
	
	map.put("hrTerminationProcessList", hrTerminationProcessList);
	
	return map;
}

//---Method For geting Hospital wise department
	public List<MasEmployeeDepartment> getEmployeeDepartmentId(int hospitalId){
		Session session=(Session)getSession();
		List<Integer> departmentList=new ArrayList<Integer>();
		List<MasEmployeeDepartment> masEmployeeDepartments=new ArrayList<MasEmployeeDepartment>();
		List<HrInstEmpDept> hrInstEmpDept=(List<HrInstEmpDept>)session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "h").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("Status", "Y")).list();
		if(hrInstEmpDept.size()>0){
			String[] departmentId=hrInstEmpDept.get(0).getEmployeeDepartment().split(",");
			for(int i=0;i<departmentId.length;i++){
				departmentList.add(Integer.parseInt(departmentId[i]));
			}
			masEmployeeDepartments=session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", departmentList)).add(Restrictions.eq("Status", "Y")).list();
		}
		
		return masEmployeeDepartments;
	}

@Override
public Map<String, Object> searchWaitingForSuspenTermi(
		Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	Session sess = getSession();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	
	String employee_name = ""+parameterMap.get("employee_name");
	String department=""+parameterMap.get("department");
	String designation = ""+parameterMap.get("designation");
	
	Criteria crit = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","a").ignoreCase()).
									add(Restrictions.eq("FromInstitute.Id", hospitalId)); 
	if(employee_name != null && !employee_name.equals("")){
		crit = crit.createAlias("EmployeeId", "emp").add(Restrictions.like("emp.EmployeeName", employee_name.trim()+"%").ignoreCase());
		
	}
	if(department != null && !department.equals("")){
		crit = crit.createAlias("EmployeeId", "emp").add(Restrictions.eq("emp.Department.Id", Integer.parseInt(department)));
		
	}
	if(designation != null && !designation.equals("")){
		crit = crit.createAlias("EmployeeId", "emp").add(Restrictions.eq("emp.Rank.Id", Integer.parseInt(designation)));
		
	}
	hrTerminationProcessList=crit.list();
	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = getEmployeeDepartmentId(hospitalId);
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	
	map.put("hrTerminationProcessList", hrTerminationProcessList);
	map.put("departList", deptList);
	map.put("desigList", desigList);
	return map;
}

@Override
public Map<String, Object> showEmpRelievingTerminAndSusp(Map<String, Object> parameterMap) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	List<MasOpSession> sesList = new ArrayList<MasOpSession>();
	int hospitalId= Integer.parseInt(""+parameterMap.get("hospitalId"));
	int id=0;
	if(parameterMap.get("id")!=null && !parameterMap.get("id").equals("")){ 
	  id= Integer.parseInt(""+parameterMap.get("id")); 
	System.out.println("id>>>"+id);}
	Session sess = getSession();

	hosList  = sess.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	deptList  = sess.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	desigList  = sess.createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	sesList = sess.createCriteria(MasOpSession.class).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
	
	hrTerminationProcessList = sess.createCriteria(HrTerminationProcess.class).add(Restrictions.eq("Status","a").ignoreCase()).
			add(Restrictions.eq("Id", id)).list(); // status a for selecting approve Transfer from transfer application
	System.out.println("hrTerminationProcessList>>>"+hrTerminationProcessList.size());
	map.put("hrTerminationProcessList", hrTerminationProcessList);
	map.put("deptList", deptList);
	map.put("desigList", desigList);
	map.put("sesList", sesList);
	return map;
}


public Map<String, Object> displaySubmitAttachment(Map<String, Object> parameterMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<HrEmployeeDeputation> hrEmployeeDeputationList = new ArrayList<HrEmployeeDeputation>();
	
	int RequestId = Integer.parseInt(""+parameterMap.get("RequestId"));
	String mode = ""+parameterMap.get("mode");
	
	Session session = (Session)getSession();
	//hrTerminationProcessList = session.createCriteria(HrTerminationProcess.class).add(Restrictions.idEq(RequestId)).list();
	hrEmployeeDeputationList = session.createCriteria(HrEmployeeDeputation.class).add(Restrictions.idEq(RequestId)).list();
	/*etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
	temExpensesAttachList = session.createCriteria(TempTrvsub.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
	map.put("etrTravelRequestList", etrTravelRequestList);
	map.put("temExpensesAttachList", temExpensesAttachList);*/
	//map.put("hrTerminationProcessList", hrTerminationProcessList);
	map.put("hrEmployeeDeputationList", hrEmployeeDeputationList);
	return map;
}

public Map<String, Object> addAttachFile(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	/*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
	List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();*/
	
	List<UploadDocuments> tempdocAttachList = new ArrayList<UploadDocuments>();
	List<HrEmployeeDeputation> deputationList = new ArrayList<HrEmployeeDeputation>();
	
	
	Session session = (Session)getSession();
	String filename = "";
	if(generalMap.get("filename")!= null){
		filename =(String) generalMap.get("filename");
	}
	String uploadURL = "";
	if(generalMap.get("uploadURL")!= null){
		uploadURL =(String) generalMap.get("uploadURL");
	}
	String comments = "";
	if(generalMap.get("comments")!= null){
		comments =(String) generalMap.get("comments");
	}
	int request_id = 0;
	if(generalMap.get("request_id")!= null){
		request_id =(Integer) generalMap.get("request_id");
	}
	int employeeId = 0;
	if(generalMap.get("employeeId")!= null){
		employeeId =(Integer) generalMap.get("employeeId");
	}
	String fileExtension=null;
	 File file=null;
	 try { 
			HibernateTemplate hbt=getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			System.out.println(uploadURL+" -- "+filename);
			 file=new File(uploadURL + "/" + filename);
    		 System.out.println("path>>"+file.getPath()+filename);
    		
    	     FileInputStream is = new FileInputStream(file);
    	     long length = file.length();
    	     ByteBuffer byteBuff=null;
    	   //  int modLength=length/
    	     if (length > Integer.MAX_VALUE) {
            // File is too large
    	     }
    	     // Create the byte array to hold the data
    	     byte[] bytes = new byte[(int)length];
    	     int offset = 0;
    	     int numRead = 0;
    	     while (offset < bytes.length
    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
    	    	 offset += numRead;
    	    	
    	     }
    
    	     if (offset < bytes.length) {
    	    	 throw new IOException("Could not completely read file "+file.getName());
    	         
    	     }
    	     is.close();
        // Close the input stream and return bytes
    	    // StringTokenizer strToken=new StringTokenizer( filename,".");
	   	
    	   //  filename=strToken.nextToken();
    	   //  fileExtension=strToken.nextToken();
    	     /*TempTickattach tempTickattach = new TempTickattach();
    	     tempTickattach.setTdsaDfilename(filename);
    	     tempTickattach.setTdsaOfilename(filename);
    	     EtrTravelreq etrTravelreq = new EtrTravelreq();
    	     etrTravelreq.setId(travelRequestId);
    	     tempTickattach.setTdsaDsid(etrTravelreq);
    	     tempTickattach.setTdsaCmts(comments);
    	     MasEmployee masEmployee = new MasEmployee();
    	     masEmployee.setId(employeeId);
    	     tempTickattach.setTdsaUserid(masEmployee);
    	     hbt.save(tempTickattach);*/
    	     
    	     
      
    	     //file.delete();
    	 HrEmployeeDeputation deputation = new HrEmployeeDeputation();
   	     deputation.setId(request_id);
   	     hbt.save(deputation);
    	      
   	     UploadDocuments deputeDoc = new UploadDocuments();
   	     deputeDoc.setPatientDocument(bytes);
   	     deputeDoc.setFileName(filename); 
   	    // deputation.setId(request_id);
   	     deputeDoc.setDeputation(deputation);
   	     deputeDoc.setDescription(comments);
   	    /* MasEmployee masEmployee = new MasEmployee();
   	     masEmployee.setId(employeeId);
   	     deputeDoc.set;*/
   	     hbt.save(deputeDoc);
   	     hbt.flush();
   	     hbt.refresh(deputeDoc);
    	     
    	     
    	    /* UploadDocuments deputeDoc = new UploadDocuments();
    	     deputeDoc.setPatientDocument(bytes);
    	     deputeDoc.setFileName(filename);
    	   
    	     HrEmployeeDeputation deputation = new HrEmployeeDeputation();
    	     deputation.setId(request_id);
    	     deputeDoc.setDeputation(deputation);
    	     deputeDoc.setDescription(comments);
    	     MasEmployee masEmployee = new MasEmployee();
    	     masEmployee.setId(employeeId);
    	     deputeDoc.set;
    	     hbt.save(deputeDoc);
    	     hbt.flush();
    	     hbt.refresh(deputeDoc);*/
      
    
    }// end of 'try' loop 
	catch (Exception e) {
    	e.printStackTrace();
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
	 tempdocAttachList = session.createCriteria(UploadDocuments.class).createAlias("EmployeeDeputation", "deput").add(Restrictions.eq("deput.Id", request_id)).list();
	 deputationList = session.createCriteria(HrEmployeeDeputation.class).add(Restrictions.idEq(request_id)).list();
	// System.out.println("afterSave>>..>>"+tempdocAttachList.size());
	map.put("tempdocAttachList", tempdocAttachList);
	map.put("hrEmployeeDeputationList", deputationList);
	return map;
}

@Override
public Map<String, Object> searchEmployeeContract(String instructorCode,
		String instructorName) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Map<String, Object> saveContractEmployee(Map<String, Object> parameterMap) {
	
	
	/*int hospitalId=Integer.parseInt(""+parameterMap.get("hospitalId"));	
	int empid=Integer.parseInt(""+parameterMap.get("empid"));	
	int suspensioninstituteId=Integer.parseInt(""+parameterMap.get("instituteId"));	
	int suspendBy=Integer.parseInt(""+parameterMap.get("suspendBy"));	*/
	String agency=""+parameterMap.get("agency");
	String agreementType=""+parameterMap.get("agreementType");
	String doc_submit=""+parameterMap.get("doc_submit");
	String agreement_rules=""+parameterMap.get("agreement_rules");
	String agreementStartDate=""+parameterMap.get("agreementStartDate");
	String agreementEndDate=""+parameterMap.get("agreementEndDate");
	String remarks=""+parameterMap.get("remarks");
		
	Users user = (Users)parameterMap.get("changedBy");
	String changedDate=""+parameterMap.get("changedDate");
	String changedTime=""+parameterMap.get("changedTime");
	
	return null;
}

@Override

public Map<String, Object> showMeetingSchedulingJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	 Session session =(Session)getSession();
	 List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
	 String lastSeqNo = "";
	 String lastSeqYear = "";
	 String meetingNo = "";
	List<MasEmployee> masEmployee = new ArrayList<MasEmployee>();
	List<HrCommitteeHeader> committeeList = new ArrayList<HrCommitteeHeader>();
	//List<LglBoardMember> bmList = new ArrayList<LglBoardMember>();
	//List<LglBoardMember> smList = new ArrayList<LglBoardMember>();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 List<HrMeetingSchedule> scheduleList = new ArrayList<HrMeetingSchedule>(); 
	Map<String, Object> utilMap = new HashMap<String, Object>();
	 utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 String date = (String) utilMap.get("currentDate");
	 String currentYear = date.substring(date.lastIndexOf("/") + 1);

		try {
			departmentList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment where Status = 'y' ");
			scheduleList = session.createCriteria(HrMeetingSchedule.class).list();
			if (scheduleList.size() > 0) {
				for (HrMeetingSchedule hms : scheduleList) {
					lastSeqNo = hms.getMeetingNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			
	orderSeqNoList = session.createCriteria(TransactionSequence.class)
	.add(Restrictions.eq("TransactionPrefix", "HRM")).list();
	 
	if (orderSeqNoList != null && orderSeqNoList.size() > 0) {
		for (TransactionSequence maxOrderNo : orderSeqNoList) {
			if (currentYear.equals(lastSeqYear)) {
				meetingNo = String.valueOf(maxOrderNo.getTransactionSequenceNumber() + 1);
			} else {
				meetingNo = String.valueOf(1);

			}
		}
		
	} else {
		meetingNo = String.valueOf(1);
		TransactionSequence transactionSequence = new TransactionSequence();
		transactionSequence.setTransactionPrefix("HRM"); // HRM - HR meeting
		transactionSequence
				.setTransactionSequenceName("Meeting No.");
		transactionSequence.setTransactionSequenceNumber(0);
		transactionSequence.setTablename("LglMeetingSchedule");
		transactionSequence.setStatus("y");
			/*MasHospital masHospital = new MasHospital();
		masHospital.setId(box.getInt("storeId"));
		transactionSequence.setHospital(masHospital);*/
			session.save(transactionSequence);
	}
	meetingNo = meetingNo.concat("/").concat(String.valueOf(lastSeqYear));
	masEmployee=session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	//masEmployee = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee where Status = 'y' ");
	committeeList = session.createCriteria(HrCommitteeHeader.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
/*	bmList = getHibernateTemplate().find("from jkt.erp.masters.business.LglBoardMember where BoardMemberType = 'BM' ");
	smList = getHibernateTemplate().find("from jkt.erp.masters.business.LglBoardMember where BoardMemberType = 'SCM' ");*/
		}catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
		map.put("departmentList", departmentList);
		map.put("committeeList", committeeList);
		/*map.put("bmList", bmList);
		map.put("smList", smList);*/
		map.put("meetingNo", meetingNo);
	map.put("masEmployee", masEmployee);
		
	return map;
}

@Override
public Map<String, Object> getMemberListForMeetingByName(
		Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	/*List<LglBoardMember> bList = new ArrayList<LglBoardMember>();*/
	List<HrCommitteeDetails> sList = new ArrayList<HrCommitteeDetails>();
	List<MasEmployee> eList = new ArrayList<MasEmployee>();
	Session session = (Session) getSession();
	
	session = (Session) getSession();
	String boardId = "";
	String subCommitteeId="";
	String employeeId="";
	if(dataMap.get("boardId")!=null){
		boardId = (String)dataMap.get("boardId");
	}
	if(dataMap.get("subCommitteeId")!=null){
		subCommitteeId = (String)dataMap.get("subCommitteeId");
	}
	if(dataMap.get("employeeId")!=null){
		employeeId = (String)dataMap.get("employeeId");
	}

	try {
			
		String str = dataMap.get("autoHint") + "%";
		System.out.println(subCommitteeId+" "+employeeId+"str>>"+str);
		/*if(boardId!=""){
			Criteria c = session.createCriteria(LglBoardMember.class).add(
					Restrictions.like("NameBoard", str).ignoreCase())
					.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("BoardMemberType","BM"));
			bList = c.list();
		}*/
		if(subCommitteeId!=""){
			System.out.println("subCommitteeId"); 
			Criteria c =session.createCriteria(HrCommitteeDetails.class).add(Restrictions.like("Name", str).ignoreCase())
					.add(Restrictions.eq("Status", "y"));
					
			sList = c.list();
		}
		if(employeeId!=""){
		
			Criteria c = session.createCriteria(MasEmployee.class).add(
					Restrictions.like("EmployeeName", str).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase());
		eList = c.list();
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}

	/*map.put("bList", bList);*/
	map.put("sList", sList);
	map.put("eList", eList);
	System.out.println(sList.size()+">size>"+eList.size());
	return map;

}

@Override
public Map<String, Object> fillMemberForName(Map<String, Object> dataMap) {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> eList = new ArrayList<MasEmployee>();
	String nameMember = null;
	nameMember = "" + dataMap.get("nameMember");

	try {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		eList = session.createCriteria(MasEmployee.class)
		.add(Restrictions.like("EmployeeName", "%"+nameMember+"%").ignoreCase())
		.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	map.put("eList", eList);
	return map;
}

@Override
public Map<String, Object> saveMeetingScheduling(Map<String, Object> dataMap) {

	
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int locationId = 0;
	if (dataMap.get("locationId") != null)
		locationId = Integer.parseInt("" + dataMap.get("locationId"));
	Box box = (Box)dataMap.get("box");
	String successfullyAdded = "no";
	HrMeetingSchedule ls = new HrMeetingSchedule();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	int meetingId = 0;
	if(box.getInt("meetingId")!=0){
		meetingId = box.getInt("meetingId");
	}
	int scheduleId=0;
	Transaction tx = null;
	Users users=new Users();
	MasHospital masHospital = new MasHospital();
	String buttonName="";
	if(box.getString("buttonName")!=null){
		buttonName=box.getString("buttonName");
	}
	try {
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (meetingId!=0) {
			ls = (HrMeetingSchedule)hbt.load(HrMeetingSchedule.class, meetingId);
			
		}
		
		if(!box.getString("meetingDate").equals(""))
			ls.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString("meetingDate")));
		
		if(!box.getString("meetingNo").equals(""))
			ls.setMeetingNo(box.getString("meetingNo"));
		
		if(!box.getString("meetingType").equals("")){
			ls.setMeetingType(box.getString("meetingType"));
		}
		if(!box.getString("scheduleDate").equals("")){
			ls.setScheduledDate(HMSUtil.convertStringTypeDateToDateType(box.getString("scheduleDate")));
		}
		if(!box.getString("scheduleTimeFrom").equals("")){
			ls.setScheduledTimeFrom(box.getString("scheduleTimeFrom"));
		}
		if(!box.getString("scheduleTimeTo").equals("")){
			ls.setScheduledTimeTo(box.getString("scheduleTimeTo"));
		}
		if(!box.getString("venue").equals("")){
			ls.setVenue(box.getString("venue"));
		}
		if(!box.getString("remarks").equals("")){
			ls.setRemarks(box.getString("remarks"));
		}
		if(!box.getString("chairedBy").equals("")){
			ls.setChairedBy(box.getString("chairedBy"));
		}
		/*if(box.getInt("chairedBy")!=0){
			MasStoreGroup group = new MasStoreGroup();
			group.setId(box.getInt("chairedBy"));
			storeIndentM.setGroup(group);
		}*/
		MasDepartment department = new MasDepartment();
		department.setId(1);
		ls.setDepartment(department);

		users.setId(box.getInt("userId"));
		ls.setLastChgBy(users);
		ls.setStatus("l");
		ls.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		ls.setLastChgTime(time);
		
		if(buttonName.equals("save")){
			masHospital.setId(locationId);
			ls.setLocation(masHospital);
		}
		hbt.saveOrUpdate(ls);
		
		scheduleId = ls.getId();
		
	
		Vector designation=box.getVector("designation");
		Vector remarks = box.getVector("remarks");
		Vector nameMember= box.getVector("nameMember");
		//Vector emp_id= box.getVector("emp_id");
		for(int j=0; j<nameMember.size();j++){
			HrMeetingMembers lm =new HrMeetingMembers();
			if (nameMember.get(j) != null && !nameMember.get(j).equals("0") && !nameMember.get(j).toString().equals("")) {
				lm.setMemberName(nameMember.get(j).toString());
				
				
				/*MasEmployee me = new MasEmployee();
				me.setId(Integer.parseInt(""+emp_id.get(j)));
				lm.setMember(me);*/
				
				
				lm.setDesignation(designation.get(j).toString());
				lm.setRemarks(remarks.get(0).toString());
				lm.setSchedule(ls);
				
				hbt.saveOrUpdate(lm);
			}
				
		}
	
		Vector agendaPoints=box.getVector("agendaPoints");
		Vector reference = box.getVector("reference");
		Vector remarka= box.getVector("remarka");
		for(int j=0; j<agendaPoints.size();j++){
			HrMeetingAgendaPoint la =new HrMeetingAgendaPoint();
			if (agendaPoints.get(j) != null && !agendaPoints.get(j).equals("0") && !agendaPoints.get(j).toString().equals("")) {
				la.setAgendaPoint(agendaPoints.get(j).toString());
				
				la.setReference(reference.get(j).toString());
				la.setRemarks(remarka.get(j).toString());
				la.setSchedule(ls);
				
				hbt.saveOrUpdate(la);
			}
				
		}
		
		TransactionSequence transactionSequence = new TransactionSequence() ;
		transactionSequence = (TransactionSequence)session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix","HRM" )).list().get(0);
		transactionSequence.setTransactionSequenceNumber(transactionSequence.getTransactionSequenceNumber()+1);
		hbt.saveOrUpdate(transactionSequence);
		hbt.refresh(transactionSequence);
		
		successfullyAdded = "yes";
		tx.commit();

	} catch (RuntimeException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} 
	System.out.println(scheduleId);
	map.put("scheduleId", scheduleId);
	map.put("successfullyAdded", successfullyAdded);

	return map;

}


public Map<String, Object> deleteAttachFileDepute(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<TempTickattach> tempdocAttachList = new ArrayList<TempTickattach>();
	List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
	List<HrEmployeeDeputation> deputationList = new ArrayList<HrEmployeeDeputation>();
	Session session = (Session)getSession();
	List ticketAttachIdList = new ArrayList();
	List uploadFileNameList = new ArrayList();
	List commentsList = new ArrayList();
	List employeeIdList = new ArrayList();
	List travelRequestIdList = new ArrayList();
	
	if(generalMap.get("ticketAttachIdList")!= null){
		ticketAttachIdList =(List)generalMap.get("ticketAttachIdList");
	}
	
	int request_id = 0;
	if(generalMap.get("request_id")!= null){
		request_id =(Integer) generalMap.get("request_id");
	}
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	// etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
	//TempTickattach tempTickattach = (TempTickattach)hbt.load(TempTickattach.class, ticketAttachId);
	//hbt.delete(tempTickattach);
	int docId = 0;
	if(ticketAttachIdList.size()>0){
		for (int i = 0; i < ticketAttachIdList.size(); i++) {
			if(ticketAttachIdList.get(i) != null){
				docId = Integer.parseInt(ticketAttachIdList.get(i).toString());
				//etrTrvdetails = (EtrTrvdetails)hbt.load(EtrTrvdetails.class, etrTrvDeatilId);
				UploadDocuments tempTickattach = (UploadDocuments)hbt.load(UploadDocuments.class, docId);
				hbt.delete(tempTickattach);
			}
		}
	}
	
	 tempdocAttachList = session.createCriteria(UploadDocuments.class).createAlias("EmployeeDeputation", "deput").add(Restrictions.eq("deput.Id", request_id)).list();
	 deputationList = session.createCriteria(HrEmployeeDeputation.class).add(Restrictions.idEq(request_id)).list();
	// System.out.println("afterSave>>..>>"+tempdocAttachList.size());
	map.put("tempdocAttachList", tempdocAttachList);
	map.put("hrEmployeeDeputationList", deputationList);
	return map;
}

@Override

public Map<String, Object> showSubCommitteeJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	List gridDesignationList =null;
	List<HrCommitteeHeader> commiteeList = new ArrayList<HrCommitteeHeader>();
	List<HrCommitteeDetails> searchLglBoardMemberList = new ArrayList<HrCommitteeDetails>();
	List<MasRank> designationList = new ArrayList<MasRank>();
	Session session = (Session)getSession();
	searchLglBoardMemberList = session.createCriteria(HrCommitteeDetails.class)/*.add(Restrictions.eq("BoardMemberType", "SCM"))*/.list();
	commiteeList = session.createCriteria(HrCommitteeHeader.class)/*.add(Restrictions.eq("Status", "y").ignoreCase())*/.addOrder(Order.asc("CommitteeName")).list();
	designationList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
	gridDesignationList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
    System.out.println(" in data>>>>"+searchLglBoardMemberList.size());
	map.put("searchLglBoardMemberList", searchLglBoardMemberList);
	map.put("commiteeList", commiteeList);
	map.put("designationList", designationList);
	map.put("gridDesignationList", gridDesignationList);
	return map;
}

@Override
public boolean addSubCommittee(HrCommitteeDetails lgl) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.save(lgl);
	hbt.refresh(lgl);
	successfullyAdded = true;
	return successfullyAdded;
}

@Override
public boolean editSubCommitteeToDatabase(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");

	String address="";
	int designationId=0;
	int emp_id=0;
	int hosId=0;
	int sesHosId=0;
	int committeeId=0;
	Date dateOfAppointment=null;
	String briefBackground="";
	int noOfShareHeld=0;
	String remarks="";
	String disclosureOfInterest="";
	int subCommitteeId=0;
	String memberName="";
	String memberType="";
	
	subCommitteeId = (Integer) generalMap.get("id");
	memberName = (String) generalMap.get("name");
	memberType = (String) generalMap.get("memberType");
	emp_id = (Integer) generalMap.get("emp_id");
	hosId = (Integer) generalMap.get("hosId");
	sesHosId = (Integer) generalMap.get("sesHosId");
	committeeId = (Integer) generalMap.get("committeeId");

	String designation = (String) generalMap.get("designation");
	designationId = (Integer) generalMap.get("designationId");
	address = (String) generalMap.get("address");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	dateOfAppointment= (Date) generalMap.get("dateOfAppointment");
	
	briefBackground = (String) generalMap.get("briefBackground");
	noOfShareHeld = (Integer) generalMap.get("noOfShareHeld");
	remarks = (String) generalMap.get("remarks");
	disclosureOfInterest = (String) generalMap.get("disclosureOfInterest");

	
	int userId=0;
	userId = (Integer) generalMap.get("userId");
	
	HrCommitteeDetails lgl = (HrCommitteeDetails) getHibernateTemplate().load(HrCommitteeDetails.class,subCommitteeId);
			

	lgl.setCommitteeMemberType(memberType);
	
	
		if(memberType.equalsIgnoreCase("employee")){
			MasRank d = new MasRank();
			d.setId(designationId);
			lgl.setDesignation(d);
			
			MasEmployee me = new MasEmployee();
			me.setId(emp_id);
			lgl.setEmployee(me);
			
			MasHospital mh = new MasHospital();		
			mh.setId(hosId);
			lgl.setHospital(mh);
			
		}else if(memberType.equalsIgnoreCase("other")){
			MasHospital mh = new MasHospital();		
			mh.setId(sesHosId);
			lgl.setHospital(mh);
			lgl.setDesignationName(designation);
		}
		
		HrCommitteeHeader committee = new HrCommitteeHeader();
		committee.setId(committeeId);
		lgl.setCommittee(committee);
		
		
		
		lgl.setName(memberName);
		lgl.setStatus("y");
		
		Users user = new Users();
		user.setId(userId);
		lgl.setLastChgBy(user);
		
		
		lgl.setAddress(address);
		/*lgl.setAppointmentDate(dateOfAppointment);
		lgl.setBriefBackground(briefBackground);
		lgl.setNoOfShareHeld(noOfShareHeld);*/
		lgl.setRemarks(remarks);
		
		lgl.setLastChgDate(currentDate);
		lgl.setLastChgTime(currentTime);

	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(lgl);
	dataUpdated = true;
	return dataUpdated;
}

@Override
public Map<String, Object> getCommitteeMember(int committeeId) {
	Session session = (Session) getSession();
	Map dMap = new HashMap();
	List<HrCommitteeDetails>  commiteeDetailsList = new ArrayList<HrCommitteeDetails>();
	
	commiteeDetailsList= session.createCriteria(HrCommitteeDetails.class).createAlias("Committee", "Committee").add(Restrictions.eq("Committee.Id", committeeId)).list();
	
	dMap.put("commiteeDetailsList", commiteeDetailsList);
	return dMap;
}



public Map<String, Object> showListOfMeetingScheduling(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<HrMeetingSchedule> lsList = new ArrayList<HrMeetingSchedule>();
	List<HrMeetingSchedule> meetingNoList = new ArrayList<HrMeetingSchedule>();
	Criteria crit = null;
	//String[] statusArr = {"submitted"};
	crit =  session.createCriteria(HrMeetingSchedule.class).add(Restrictions.eq("Location.Id", box.getInt("locationId"))).add(Restrictions.eq("Status","l"));
			

	if(!box.getString("fromDate").equals("") && !box.getString("toDate").equals("") ){
		crit = crit.add(Restrictions.between("Date", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")),  HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
	}
	if(box.getInt("meetingId")!=0){
		crit = crit.add(Restrictions.idEq(box.getInt("meetingId")));
	}
	
	lsList =crit.addOrder(Order.desc("Date")).list();
	
	Criteria c = null;
	c = session.createCriteria(HrMeetingSchedule.class).add(Restrictions.eq("Location.Id", box.getInt("locationId"))).add(Restrictions.eq("Status","l"));

	meetingNoList = c.addOrder(Order.desc("Date")).list();
	map.put("lsList", lsList);
	map.put("meetingNoList", meetingNoList);
	return map;

}

@Override
public Map<String, Object> showMinutesOfMeetingJsp(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<HrMeetingSchedule> lsList = new ArrayList<HrMeetingSchedule>();
	List<HrCommitteeHeader> committeeList = new ArrayList<HrCommitteeHeader>();
	Criteria crit = null;
	//String[] statusArr = {"submitted"};
	crit =  session.createCriteria(HrMeetingSchedule.class).add(Restrictions.eq("Id", box.getInt("meetingId")));
	lsList =crit.list();
	
	committeeList = session.createCriteria(HrCommitteeHeader.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
	map.put("lsList", lsList);
	map.put("committeeList", committeeList);
	return map;
}

@Override
public Map<String, Object> saveMinutesOfMeeting(Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int locationId = 0;
	if (dataMap.get("locationId") != null)
		locationId = Integer.parseInt("" + dataMap.get("locationId"));
	Box box = (Box)dataMap.get("box");
	String successfullyAdded = "no";
	HrMeetingSchedule ls = new HrMeetingSchedule();

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	int uploadCount = box.getInt("uploadCount");
	int meetingId = 0;
	int scheduleId=0;
	if(box.getInt("meetingId")!=0){
		meetingId = box.getInt("meetingId");
	}
	

	Transaction tx = null;
	Users users=new Users();
	MasHospital masHospital = new MasHospital();
	String buttonName="";
	if(box.getString("buttonName")!=null){
		buttonName=box.getString("buttonName");
	}
	try {
		tx = session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (meetingId!=0) {
			ls = (HrMeetingSchedule)hbt.load(HrMeetingSchedule.class, meetingId);
			
		}
		
		if(!box.getString("mintuesOfMeetingDate").equals(""))
			ls.setAfterMeetingDate(HMSUtil.convertStringTypeDateToDateType(box.getString("mintuesOfMeetingDate")));
		
		if(!box.getString("meetingNo").equals(""))
			ls.setMeetingNo(box.getString("meetingNo"));
		
		if(!box.getString("meetingType").equals("")){
			ls.setMeetingType(box.getString("meetingType"));
		}
		if(!box.getString("scheduleDate").equals("")){
			ls.setScheduledDate(HMSUtil.convertStringTypeDateToDateType(box.getString("scheduleDate")));
		}
		if(!box.getString("scheduleTimeFrom").equals("")){
			ls.setScheduledTimeFrom(box.getString("scheduleTimeFrom"));
		}
		if(!box.getString("scheduleTimeTo").equals("")){
			ls.setScheduledTimeTo(box.getString("scheduleTimeTo"));
		}
		if(!box.getString("venue").equals("")){
			ls.setVenue(box.getString("venue"));
		}
		if(!box.getString("remarks").equals("")){
			ls.setRemarks(box.getString("remarks"));
		}
		if(!box.getString("chairedBy").equals("")){
			ls.setChairedBy(box.getString("chairedBy"));
		}
		/*if(box.getInt("chairedBy")!=0){
			MasStoreGroup group = new MasStoreGroup();
			group.setId(box.getInt("chairedBy"));
			storeIndentM.setGroup(group);
		}*/
		MasDepartment department = new MasDepartment();
		department.setId(1);
		ls.setDepartment(department);

		users.setId(box.getInt("userId"));
		ls.setLastChgBy(users);
		
		ls.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		ls.setLastChgTime(time);
		
		if(buttonName.equals("save")){
			masHospital.setId(locationId);
			ls.setLocation(masHospital);
		}
		
		if(!box.getString("actualDate").equals("")){
			ls.setActualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("actualDate")));
		}
		if(!box.getString("actualTimeFrom").equals("")){
			ls.setActualTimeFrom(box.getString("actualTimeFrom"));
		}
		if(!box.getString("actualTimeTo").equals("")){
			ls.setActualTimeTo(box.getString("actualTimeTo"));
		}
	
		ls.setStatus("m");
					
		hbt.saveOrUpdate(ls);
		
		scheduleId = ls.getId();
		
	
		Vector designation=box.getVector("designation");
		Vector attendance=box.getVector("attendance");
		Vector remarks = box.getVector("remarks");
		Vector nameMember= box.getVector("nameMember");
		Vector  meetingMemberId=box.getVector("meetingMemberId");
	
		for(int j=0; j<nameMember.size();j++){
			HrMeetingMembers lm = new HrMeetingMembers();
			System.out.println(meetingMemberId.size());
			if (!meetingMemberId.get(j).equals("0")) {
				lm = (HrMeetingMembers)hbt.load(HrMeetingMembers.class,Integer.parseInt(meetingMemberId.get(j).toString()));
				
			}
			
			if (nameMember.get(j) != null && !nameMember.get(j).equals("0") && !nameMember.get(j).toString().equals("")) {
				lm.setMemberName(nameMember.get(j).toString());
				lm.setDesignation(designation.get(j).toString());
				lm.setAttendance(attendance.get(j).toString());
				lm.setAfterMeetingRemarks(remarks.get(0).toString());
				lm.setSchedule(ls);
				
				hbt.saveOrUpdate(lm);
			}
				
		}
	
		Vector agendaPoints=box.getVector("agendaPoints");
		Vector decision = box.getVector("decision");
		Vector action = box.getVector("action");
		Vector info = box.getVector("info");
		Vector remarka= box.getVector("remarka");
		Vector  meetingAgendaPointId=box.getVector("meetingAgendaPointId");
		
		for(int j=0; j<agendaPoints.size();j++){
			
			HrMeetingAgendaPoint la = new HrMeetingAgendaPoint();
			
			
			if (!meetingAgendaPointId.get(j).equals("0")) {
				la = (HrMeetingAgendaPoint)hbt.load(HrMeetingAgendaPoint.class,Integer.parseInt(meetingAgendaPointId.get(j).toString()));
				
			}
			if (agendaPoints.get(j) != null && !agendaPoints.get(j).equals("0") && !agendaPoints.get(j).toString().equals("")) {
				la.setAgendaPoint(agendaPoints.get(j).toString());
				
				la.setDecision(decision.get(j).toString());
				la.setAction(action.get(j).toString());
				la.setInfo(info.get(j).toString());
				la.setAfterMeetingRemarks(remarka.get(j).toString());
				la.setSchedule(ls);
				
				hbt.saveOrUpdate(la);
				/**
				 * Upload Documents
				 */
				if(uploadCount>0){
					int i = j+1;
					if(!box.getString("filename"+i).equals("")){
						String fileName = null;
						String fileExtension = null;
						UploadDocuments uploadDocuments = new UploadDocuments();
						StringTokenizer strToken = new StringTokenizer(box
								.getString("filename" + i), ".");

						fileName = strToken.nextToken();
						fileExtension = strToken.nextToken();


						uploadDocuments.setFileExtension(fileExtension);
						uploadDocuments.setFileName(fileName);

						uploadDocuments.setDescription(box.getString("description"+ i));
						//uploadDocuments.setRemarks(box.getString("remarks"+ i));
						uploadDocuments.setLastChgTime(time);
						uploadDocuments.setLastChgDate(new Date());
						//uploadDocuments.setStatus("y");

						//uploadDocuments.setAgendaPoint(la);
						uploadDocuments.setUploadDate(new Date());
						uploadDocuments.setHospital(masHospital);
						hbt.save(uploadDocuments);

						
					}
				}

				
			}
				
		}
		
	    map.put("dataSaved", true);
		successfullyAdded = "yes";
		tx.commit();

	} catch (RuntimeException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} 
	System.out.println(scheduleId);
	map.put("scheduleId", scheduleId);
	map.put("successfullyAdded", successfullyAdded);
	
	return map;
}

 
}
	
