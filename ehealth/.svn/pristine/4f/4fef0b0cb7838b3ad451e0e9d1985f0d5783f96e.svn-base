package jkt.hrms.training.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.CONTACT_NUMBER;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.VISIT_ID;



import static jkt.hrms.util.HrmsRequestConstants.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.HrCommitteeDetails;
import jkt.hms.masters.business.HrCommitteeHeader;
import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.HrMedicalFitnessFirst;
import jkt.hms.masters.business.HrMedicalRecord;
import jkt.hms.masters.business.HrPatientFitnessCertificate;
import jkt.hms.masters.business.HrPatientSickCertificate;
import jkt.hms.masters.business.HrStudentCertificate;
import jkt.hms.masters.business.HrTrainingService;
import jkt.hms.masters.business.HrTransferApproved;
import jkt.hms.masters.business.HrVacancyPost;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.base.BaseHrInstitutionalSanctionedPost;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.business.HrMasInstructor;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;
import jkt.hrms.masters.business.HrMasTraining;
import jkt.hrms.masters.business.HrMasTrainingStatus;
import jkt.hrms.masters.business.HrTrainingApprovalStatus;
import jkt.hrms.masters.business.HrTrainingEffective;
import jkt.hrms.masters.business.HrTrainingRequisition;
import jkt.hrms.masters.business.HrTrainingSchedule;
import jkt.hrms.masters.business.MasTrainingType;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import jkt.hrms.training.handler.TrainingHandlerService;
import jkt.hrms.util.HrmsRequestConstants;

import org.apache.tools.ant.types.selectors.DepthSelector;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TrainingController extends MultiActionController {

	TrainingHandlerService trainingHandlerService = null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService = null;

	public TrainingHandlerService getTrainingHandlerService() {
		return trainingHandlerService;
	}

	public void setTrainingHandlerService(
			TrainingHandlerService trainingHandlerService) {
		this.trainingHandlerService = trainingHandlerService;
	}

	public HrmsCommonMasterHandlerService getHrmsCommonMasterHandlerService() {
		return hrmsCommonMasterHandlerService;
	}

	public void setHrmsCommonMasterHandlerService(
			HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService) {
		this.hrmsCommonMasterHandlerService = hrmsCommonMasterHandlerService;
	}

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy = "";
	String jspName = "";
	String url = "";

	// ***************************************** Start Training Module's
	// Instructor Master By Rajendra ********************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showInstructorMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showInstructorMasterJsp();
		String jsp = HR_INSTRUCTOR_MASTER_JSP;
		jsp += ".jsp";
		title = "Instructor Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInstructorMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		HttpSession session = null;
		int hospitalId = 0;

		String code = "";
		String name = "";
		String instructorType = "";
		int qualificationId = 0;
		String instructorAddress = "";
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		String pincode = "";
		String phoneNo = "";
		String remarks = "";

		HrMasInstructor hrMasInstructor = new HrMasInstructor();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(INSTRUCTOR_TYPE) != null
				&& !(request.getParameter(INSTRUCTOR_TYPE).equals(""))) {
			instructorType = request.getParameter(INSTRUCTOR_TYPE);
		}
		if (request.getParameter(QUALIFICATION_ID) != null
				&& !(request.getParameter(QUALIFICATION_ID).equals(""))) {
			qualificationId = Integer.parseInt(request
					.getParameter(QUALIFICATION_ID));
		}
		if (request.getParameter(INSTRUCTOR_ADDRESS) != null
				&& !(request.getParameter(INSTRUCTOR_ADDRESS).equals(""))) {
			instructorAddress = request.getParameter(INSTRUCTOR_ADDRESS);
		}
		if (request.getParameter(DISTRICT) != null
				&& !(request.getParameter(DISTRICT).equals(""))) {
			districtId = Integer.parseInt(request.getParameter(DISTRICT));
		}
		if (request.getParameter(STATE) != null
				&& !(request.getParameter(STATE).equals(""))) {
			stateId = Integer.parseInt(request.getParameter(STATE));
		}
		if (request.getParameter(COUNTRY) != null
				&& !(request.getParameter(COUNTRY).equals(""))) {
			countryId = Integer.parseInt(request.getParameter(COUNTRY));
		}
		if (request.getParameter(PINCODE) != null
				&& !(request.getParameter(PINCODE).equals(""))) {
			pincode = request.getParameter(PINCODE);
		}
		if (request.getParameter(PHONE_NO) != null
				&& !(request.getParameter(PHONE_NO).equals(""))) {
			phoneNo = request.getParameter(PHONE_NO);
		}
		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(POJO_NAME) != null
				&& !(request.getParameter(POJO_NAME).equals(""))) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_CODE) != null
				&& !(request.getParameter(POJO_PROPERTY_CODE).equals(""))) {
			pojoPropertyCode = request.getParameter(POJO_PROPERTY_CODE);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null
				&& !(request.getParameter(POJO_PROPERTY_NAME).equals(""))) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(TITLE) != null
				&& !(request.getParameter(TITLE).equals(""))) {
			title = request.getParameter(TITLE);
		}

		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);

		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List instructorCodeList = new ArrayList();
		List instructorNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			instructorCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			instructorNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if (instructorCodeList == null || instructorCodeList.size() == 0) {

			hrMasInstructor.setInstructorCode(code);
			hrMasInstructor.setInstructorName(name);
			hrMasInstructor.setInstructorType(instructorType);

			HrMasQualification hrMasQualification = new HrMasQualification();
			hrMasQualification.setId(qualificationId);
			hrMasInstructor.setQualification(hrMasQualification);

			hrMasInstructor.setAddress(instructorAddress);

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			hrMasInstructor.setDistrict(masDistrict);

			MasState masState = new MasState();
			masState.setId(stateId);
			hrMasInstructor.setState(masState);

			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			hrMasInstructor.setCountry(masCountry);

			hrMasInstructor.setPincode(pincode);
			hrMasInstructor.setPhoneNo(phoneNo);
			hrMasInstructor.setRemarks(remarks);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstructor.setCompany(masHospital);

			hrMasInstructor.setStatus("y");
			hrMasInstructor.setLastChgBy(changedBy);
			hrMasInstructor.setLastChgDate(currentDate);
			hrMasInstructor.setLastChgTime(currentTime);

			successfullyAdded = trainingHandlerService
					.addInstructionMaster(hrMasInstructor);

			if (successfullyAdded) {
				message = "Record Added Successfully  !!";
			} else {
				message = "Try Again  !!";
			}
		} else if ((instructorCodeList != null || instructorCodeList.size() != 0)
				|| (instructorNameList != null || instructorNameList.size() != 0)) {
			if ((instructorCodeList != null || instructorCodeList.size() != 0)
					&& (instructorNameList == null || instructorNameList.size() == 0)) {

				message = "Instructor Code already exists.";
			} else if ((instructorNameList != null || instructorNameList.size() != 0)
					&& (instructorCodeList == null || instructorCodeList.size() == 0)) {

				message = "Instructor Nmae already exists.";
			} else if ((instructorCodeList != null || instructorCodeList.size() != 0)
					&& (instructorNameList != null || instructorNameList.size() != 0)) {

				message = "Instructor Code and Instructor Description already exist.";
			}
		}

		url = "hms/hrms/training?method=showInstructorMasterJsp";
		try {
			map = trainingHandlerService.showInstructorMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_INSTRUCTOR_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Instructor Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchInstructorMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String instructorCode = "";
		String instructorName = "";
		String searchField = "";
		int searchId = 1;
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instructorCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instructorName = request.getParameter(SEARCH_NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchId = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchId == 1) {
			instructorCode = searchField;
			instructorName = null;
		} else {
			instructorName = searchField;
			instructorCode = null;
		}

		map = trainingHandlerService.searchInstructorMaster(instructorCode,
				instructorName);

		String jsp = HR_INSTRUCTOR_MASTER_JSP;
		jsp += ".jsp";
		title = "Instructor Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editInstructorMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

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

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			instructorId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instructorCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instructorName = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(INSTRUCTOR_TYPE) != null
				&& !(request.getParameter(INSTRUCTOR_TYPE).equals(""))) {
			instructorType = request.getParameter(INSTRUCTOR_TYPE);
		}

		if (request.getParameter(INSTRUCTOR_ADDRESS) != null
				&& !(request.getParameter(INSTRUCTOR_ADDRESS).equals(""))) {
			instructorAddress = request.getParameter(INSTRUCTOR_ADDRESS);
		}

		if (request.getParameter(QUALIFICATION_ID) != null
				&& !(request.getParameter(QUALIFICATION_ID).equals(""))) {
			qualificationId = Integer.parseInt(request
					.getParameter(QUALIFICATION_ID));
		}

		if (request.getParameter(DISTRICT) != null
				&& !(request.getParameter(DISTRICT).equals(""))) {
			districtId = Integer.parseInt(request.getParameter(DISTRICT));
		}

		if (request.getParameter(STATE) != null
				&& !(request.getParameter(STATE).equals(""))) {
			stateId = Integer.parseInt(request.getParameter(STATE));
		}

		if (request.getParameter(COUNTRY) != null
				&& !(request.getParameter(COUNTRY).equals(""))) {
			countryId = Integer.parseInt(request.getParameter(COUNTRY));
		}

		if (request.getParameter(PINCODE) != null
				&& !(request.getParameter(PINCODE).equals(""))) {
			pincode = request.getParameter(PINCODE);
		}

		if (request.getParameter(PHONE_NO) != null
				&& !(request.getParameter(PHONE_NO).equals(""))) {
			phoneNo = request.getParameter(PHONE_NO);
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", instructorId);
		generalMap.put("code", instructorCode);
		generalMap.put("name", instructorName);
		generalMap.put("instructorType", instructorType);
		generalMap.put("instructorAddress", instructorAddress);
		generalMap.put("qualificationId", qualificationId);
		generalMap.put("countryId", countryId);
		generalMap.put("stateId", stateId);
		generalMap.put("districtId", districtId);
		generalMap.put("pincode", pincode);
		generalMap.put("phoneNo", phoneNo);
		generalMap.put("remarks", remarks);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInstructorMasterList = (List) listMap
				.get("duplicateGeneralCodeList");

		boolean dataUpdated = false;
		if (existingInstructorMasterList.size() == 0) {
			dataUpdated = trainingHandlerService
					.editInstructorMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingInstructorMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/training?method=showInstructorMasterJsp";
		try {
			map = trainingHandlerService.showInstructorMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTRUCTOR_MASTER_JSP;
		title = "Edit Instructor Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteInstructorMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int instructorId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			instructorId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = trainingHandlerService.deleteInstructorMaster(
				instructorId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/training?method=showInstructorMasterJsp";

		try {
			map = trainingHandlerService.showInstructorMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTRUCTOR_MASTER_JSP;
		title = "Delete Instruction Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ***************************************** Start Training Module's
	// Training Master By Rajendra ********************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingMasterJsp();
		String jsp = HR_TRAINING_MASTER_JSP;
		jsp += ".jsp";
		title = "Training Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTrainingMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		HttpSession session = null;
		int hospitalId = 0;

		String code = "";
		String name = "";
		Integer departmentId = null;
		Integer trainingTypeId = null;
		String trainingVenue = "";
		Integer countryId = null;
		Integer stateId = null;
		Integer districtId = null;
		String pinCode = "";
		String phoneNo = "";
		Integer seatAvailable = 0;
		BigDecimal feesCharged = new BigDecimal(0.0);
		String topicCovered = "";
		String remarks = "";

		HrMasTraining hrMasTraining = new HrMasTraining();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(TRAINING_TYPE) != null
				&& !(request.getParameter(TRAINING_TYPE).equals(""))) {
			trainingTypeId = Integer.parseInt(request
					.getParameter(TRAINING_TYPE));
		}

		if (request.getParameter(TRAINING_VENUE) != null
				&& !(request.getParameter(TRAINING_VENUE).equals(""))) {
			trainingVenue = request.getParameter(TRAINING_VENUE);
		}

		if (request.getParameter(DISTRICT) != null
				&& !(request.getParameter(DISTRICT).equals(""))) {
			districtId = Integer.parseInt(request.getParameter(DISTRICT));
		}
		if (request.getParameter(STATE) != null
				&& !(request.getParameter(STATE).equals(""))) {
			stateId = Integer.parseInt(request.getParameter(STATE));
		}
		if (request.getParameter(COUNTRY) != null
				&& !(request.getParameter(COUNTRY).equals(""))) {
			countryId = Integer.parseInt(request.getParameter(COUNTRY));
		}
		if (request.getParameter(PINCODE) != null
				&& !(request.getParameter(PINCODE).equals(""))) {
			pinCode = request.getParameter(PINCODE);
		}
		if (request.getParameter(PHONE_NO) != null
				&& !(request.getParameter(PHONE_NO).equals(""))) {
			phoneNo = request.getParameter(PHONE_NO);
		}

		if (request.getParameter(SEAT_AVAILABLE) != null
				&& !(request.getParameter(SEAT_AVAILABLE).equals(""))) {
			seatAvailable = Integer.parseInt(request
					.getParameter(SEAT_AVAILABLE));
		}

		if (request.getParameter(FEES_CHARGED) != null
				&& !(request.getParameter(FEES_CHARGED).equals(""))) {
			feesCharged = new BigDecimal(request.getParameter(FEES_CHARGED));
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(POJO_NAME) != null
				&& !(request.getParameter(POJO_NAME).equals(""))) {
			pojoName = request.getParameter(POJO_NAME);
		}
		if (request.getParameter(POJO_PROPERTY_CODE) != null
				&& !(request.getParameter(POJO_PROPERTY_CODE).equals(""))) {
			pojoPropertyCode = request.getParameter(POJO_PROPERTY_CODE);
		}
		if (request.getParameter(POJO_PROPERTY_NAME) != null
				&& !(request.getParameter(POJO_PROPERTY_NAME).equals(""))) {
			pojoPropertyName = request.getParameter(POJO_PROPERTY_NAME);
		}
		if (request.getParameter(TITLE) != null
				&& !(request.getParameter(TITLE).equals(""))) {
			title = request.getParameter(TITLE);
		}

		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);

		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List trainingCodeList = new ArrayList();
		List trainingNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			trainingCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			trainingNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if (trainingCodeList == null || trainingCodeList.size() == 0) {

			hrMasTraining.setTrainingCode(code);
			hrMasTraining.setTrainingName(name);

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

			hrMasTraining.setPincode(pinCode);
			hrMasTraining.setPhoneNo(phoneNo);
			hrMasTraining.setSeatAvailable(seatAvailable);
			hrMasTraining.setFeesCharged(feesCharged);
			hrMasTraining.setTopicsCovered(topicCovered);
			hrMasTraining.setRemarks(remarks);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasTraining.setCompany(masHospital);

			hrMasTraining.setStatus("y");
			hrMasTraining.setLastChgBy(changedBy);
			hrMasTraining.setLastChgDate(currentDate);
			hrMasTraining.setLastChgTime(currentTime);

			successfullyAdded = trainingHandlerService
					.addTrainingMaster(hrMasTraining);

			if (successfullyAdded) {
				message = "Record Added Successfully  !!";
			} else {
				message = "Try Again  !!";
			}
		} else if ((trainingCodeList != null || trainingCodeList.size() != 0)
				|| (trainingNameList != null || trainingNameList.size() != 0)) {
			if ((trainingCodeList != null || trainingCodeList.size() != 0)
					&& (trainingNameList == null || trainingNameList.size() == 0)) {

				message = "Training Code already exists.";
			} else if ((trainingNameList != null || trainingNameList.size() != 0)
					&& (trainingCodeList == null || trainingCodeList.size() == 0)) {

				message = "Training Nmae already exists.";
			} else if ((trainingCodeList != null || trainingCodeList.size() != 0)
					&& (trainingNameList != null || trainingNameList.size() != 0)) {

				message = "Training Code and Training Description already exist.";
			}
		}

		url = "hms/hrms/training?method=showTrainingMasterJsp";
		try {
			map = trainingHandlerService.showTrainingMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_TRAINING_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Training Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editTrainingMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		String trainingCode = "";
		String trainingName = "";
		Integer departmentId = 0;
		Integer trainingTypeId = 0;
		String trainingVenue = "";
		int districtId = 0;
		int stateId = 0;
		int countryId = 0;
		String pincode = "";
		String phoneNo = "";
		int seatAvailable = 0;
		BigDecimal feesCharged = new BigDecimal(0.0);
		String topicsCovered = "";
		String remarks = "";

		int hospitalId = 0;
		int trainingId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			trainingCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			trainingName = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {

			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(TRAINING_TYPE) != null
				&& !(request.getParameter(TRAINING_TYPE).equals(""))) {
			trainingTypeId = Integer.parseInt(request
					.getParameter(TRAINING_TYPE));
		}

		if (request.getParameter(TRAINING_VENUE) != null
				&& !(request.getParameter(TRAINING_VENUE).equals(""))) {
			trainingVenue = request.getParameter(TRAINING_VENUE);
		}

		if (request.getParameter(DISTRICT) != null
				&& !(request.getParameter(DISTRICT).equals(""))) {
			districtId = Integer.parseInt(request.getParameter(DISTRICT));
		}

		if (request.getParameter(STATE) != null
				&& !(request.getParameter(STATE).equals(""))) {
			stateId = Integer.parseInt(request.getParameter(STATE));
		}

		if (request.getParameter(COUNTRY) != null
				&& !(request.getParameter(COUNTRY).equals(""))) {
			countryId = Integer.parseInt(request.getParameter(COUNTRY));
		}

		if (request.getParameter(PINCODE) != null
				&& !(request.getParameter(PINCODE).equals(""))) {
			pincode = request.getParameter(PINCODE);
		}

		if (request.getParameter(PHONE_NO) != null
				&& !(request.getParameter(PHONE_NO).equals(""))) {
			phoneNo = request.getParameter(PHONE_NO);
		}

		if (request.getParameter(SEAT_AVAILABLE) != null
				&& !(request.getParameter(SEAT_AVAILABLE).equals(""))) {
			seatAvailable = Integer.parseInt(request
					.getParameter(SEAT_AVAILABLE));
		}
		if (request.getParameter(FEES_CHARGED) != null
				&& !(request.getParameter(FEES_CHARGED).equals(""))) {
			feesCharged = new BigDecimal(request.getParameter(FEES_CHARGED));
		}

		if (request.getParameter(TOPICS_COVERED) != null
				&& !(request.getParameter(TOPICS_COVERED).equals(""))) {
			topicsCovered = request.getParameter(TOPICS_COVERED);
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", trainingId);
		generalMap.put("code", trainingCode);
		generalMap.put("name", trainingName);
		generalMap.put("departmentId", departmentId);
		generalMap.put("trainingTypeId", trainingTypeId);
		generalMap.put("trainingVenue", trainingVenue);
		generalMap.put("countryId", countryId);
		generalMap.put("stateId", stateId);
		generalMap.put("districtId", districtId);
		generalMap.put("pincode", pincode);
		generalMap.put("phoneNo", phoneNo);
		generalMap.put("seatAvailable", seatAvailable);
		generalMap.put("feesCharged", feesCharged);
		generalMap.put("topicsCovered", topicsCovered);
		generalMap.put("remarks", remarks);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTrainingMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingTrainingMasterList.size() == 0) {
			dataUpdated = trainingHandlerService.editTrainingMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingTrainingMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/training?method=showTrainingMasterJsp";
		try {
			map = trainingHandlerService.showTrainingMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_TRAINING_MASTER_JSP;
		title = "Edit Training Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteTrainingMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int trainingId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = trainingHandlerService.deleteTrainingMaster(trainingId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/training?method=showTrainingMasterJsp";

		try {
			map = trainingHandlerService.showTrainingMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_TRAINING_MASTER_JSP;
		title = "Delete Training Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchTrainingMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String trainingCode = "";
		String trainingName = "";
		String searchField = "";
		int searchId = 1;
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			trainingCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			trainingName = request.getParameter(SEARCH_NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchId = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchId == 1) {
			trainingCode = searchField;
			trainingName = null;
		} else {
			trainingName = searchField;
			trainingCode = null;
		}

		map = trainingHandlerService.searchTrainingMaster(trainingCode,
				trainingName);

		String jsp = HR_TRAINING_MASTER_JSP;
		jsp += ".jsp";
		title = "Training Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// ***************************************** Start Training Module's
	// Training Requisition By Rajendra ********************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingRequisitionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap =new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
		}
		parameterMap.put("users", users);
		map = trainingHandlerService.showTrainingRequisitionJsp(parameterMap);
		String jsp = HR_TRAINING_REQUISITION_JSP;
		jsp += ".jsp";
		title = "Training Requisition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTrainingRequisition(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameterMap =new HashMap<String, Object>();
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		HttpSession session = null;
		int hospitalId = 0;

		int trainingStatusId = 1;
		int currentStatus = 1;
		String statu = "y";
		Integer employeeId = null;
		Integer rankId = null;
		Integer departmentId = null;
		int tobeApproved = 0;
		Integer trainingId = null;
		Integer contributingtrainingId = null;
		Date requisitionDate = new Date();
		Date trainingDate = new Date();
		String requisitionStatus = "";
		String remarks = "";

		HrTrainingRequisition hrTrainingRequisition = new HrTrainingRequisition();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		 session = request.getSession();
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
		}
		parameterMap.put("users", users);
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}

		if (request.getParameter(RANK_HIDDEN_ID) != null
				&& !(request.getParameter(RANK_HIDDEN_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_HIDDEN_ID));
		}

		if (request.getParameter(TO_BE_APPROVED) != null
				&& !(request.getParameter(TO_BE_APPROVED).equals(""))) {
			tobeApproved = Integer.parseInt(request
					.getParameter(TO_BE_APPROVED));
		}

		if (request.getParameter(DEPARTMENT_HIDDEN_ID) != null
				&& !(request.getParameter(DEPARTMENT_HIDDEN_ID).equals(""))) {
			departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_HIDDEN_ID));
		}

		if (request.getParameter(TRAINING_ID) != null
				&& !(request.getParameter(TRAINING_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(TRAINING_ID));
		}

		if (request.getParameter(CONTRIBUTING_TRAINING_ID) != null
				&& !(request.getParameter(CONTRIBUTING_TRAINING_ID).equals(""))) {
			contributingtrainingId = Integer.parseInt(request
					.getParameter(CONTRIBUTING_TRAINING_ID));
		}

		if (request.getParameter(TRAINING_REQUISITION_DATE) != null
				&& !(request.getParameter(TRAINING_REQUISITION_DATE).equals(""))) {
			requisitionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_REQUISITION_DATE));
		}

		if (request.getParameter(TRAINING_DATE) != null
				&& !(request.getParameter(TRAINING_DATE).equals(""))) {
			trainingDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_DATE));
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		boolean successfullyAdded = false;
		boolean successfullyAddedStatus = false;

		if (employeeId != null) {

			if (employeeId != null) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				hrTrainingRequisition.setEmployee(masEmployee);
			}

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

			if (tobeApproved != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(tobeApproved);
				hrTrainingRequisition.setToBeApproved(masEmployee);
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

			HrMasTrainingStatus hrMasTrainingStatus = new HrMasTrainingStatus();
			hrMasTrainingStatus.setId(trainingStatusId);
			hrTrainingRequisition.setTrainingStatus(hrMasTrainingStatus);

			hrTrainingRequisition.setRequisitionDate(requisitionDate);
			hrTrainingRequisition.setTrainingDate(trainingDate);
			hrTrainingRequisition.setRemarks(remarks);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingRequisition.setCompany(masHospital);

			hrTrainingRequisition.setStatus("y");
			hrTrainingRequisition.setLastChgBy(changedBy);
			hrTrainingRequisition.setLastChgDate(currentDate);
			hrTrainingRequisition.setLastChgTime(currentTime);

			// -------setting training approval status -------//
			HrTrainingApprovalStatus hrTrainingApprovalStatus = new HrTrainingApprovalStatus();

			if (employeeId != null) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				hrTrainingApprovalStatus.setEmployee(masEmployee);
			}

			if (tobeApproved != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(tobeApproved);
				hrTrainingApprovalStatus.setToBeApproved(masEmployee);
			}

			hrTrainingApprovalStatus.setTrainingStatus(hrMasTrainingStatus);

			hrTrainingApprovalStatus.setCurrentLevel(0);

			hrTrainingApprovalStatus.setCompany(masHospital);
			hrTrainingApprovalStatus.setStatus("y");
			hrTrainingApprovalStatus.setLastChgBy(changedBy);
			hrTrainingApprovalStatus.setLastChgDate(currentDate);
			hrTrainingApprovalStatus.setLastChgTime(currentTime);

			successfullyAdded = trainingHandlerService
					.addTrainingRequisition(hrTrainingRequisition);

			if (successfullyAdded) {
				hrTrainingApprovalStatus
						.setHrTrainingRequisition(hrTrainingRequisition);
				successfullyAddedStatus = trainingHandlerService
						.addTrainingApprovalStatus(hrTrainingApprovalStatus);
				message = "Record Added Successfully  !!";
			} else {
				message = "Try Again  !!";
			}

			url = "hms/hrms/training?method=showTrainingRequisitionJsp";
			try {
				map = trainingHandlerService.showTrainingRequisitionJsp(parameterMap);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		String jsp = HR_TRAINING_REQUISITION_JSP;
		jsp += ".jsp";
		title = "Add Training Requisition";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editTrainingRequisition(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameterMap =new HashMap<String, Object>();
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
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

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
		}
		parameterMap.put("users", users);

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingRequisitionId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TO_BE_APPROVED) != null
				&& !(request.getParameter(TO_BE_APPROVED).equals(""))) {
			toBeApproved = Integer.parseInt(request
					.getParameter(TO_BE_APPROVED));
		}

		if (request.getParameter(RANK_HIDDEN_ID) != null
				&& !(request.getParameter(RANK_HIDDEN_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_HIDDEN_ID));
		}

		if (request.getParameter(DEPARTMENT_HIDDEN_ID) != null
				&& !(request.getParameter(DEPARTMENT_HIDDEN_ID).equals(""))) {
			departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_HIDDEN_ID));
		}

		if (request.getParameter(TRAINING_ID) != null
				&& !(request.getParameter(TRAINING_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(TRAINING_ID));
		}

		if (request.getParameter(CONTRIBUTING_TRAINING_ID) != null
				&& !(request.getParameter(CONTRIBUTING_TRAINING_ID).equals(""))) {
			contributingtrainingId = Integer.parseInt(request
					.getParameter(CONTRIBUTING_TRAINING_ID));
		}

		if (request.getParameter(TRAINING_REQUISITION_DATE) != null
				&& !(request.getParameter(TRAINING_REQUISITION_DATE).equals(""))) {
			requisitionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_REQUISITION_DATE));
		}
		if (request.getParameter(TRAINING_DATE) != null
				&& !(request.getParameter(TRAINING_DATE).equals(""))) {
			trainingDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_DATE));
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		generalMap.put("trainingRequisitionId", trainingRequisitionId);
		generalMap.put("employeeId", employeeId);
		generalMap.put("toBeApproved", toBeApproved);
		generalMap.put("rankId", rankId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("trainingId", trainingId);
		generalMap.put("contributingtrainingId", contributingtrainingId);
		generalMap.put("trainingDate", trainingDate);
		generalMap.put("requisitionDate", requisitionDate);
		generalMap.put("remarks", remarks);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService
				.editTrainingRequisition(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "/hms/hrms/training?method=showTrainingRequisitionJsp";
		try {
			map = trainingHandlerService.showTrainingRequisitionJsp(parameterMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = HR_TRAINING_REQUISITION_JSP;
		title = "Edit Training Requisition";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteTrainingRequisition(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameterMap =new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int trainingRequisitionId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingRequisitionId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = trainingHandlerService.deleteTrainingRequisition(
				trainingRequisitionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/training?method=showTrainingRequisitionJsp";

		try {
			map = trainingHandlerService.showTrainingRequisitionJsp(parameterMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_TRAINING_REQUISITION_JSP;
		title = "Delete Training Requisition";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchTrainingRequisition(HttpServletRequest request,
			HttpServletResponse response) {

		Integer employeeId = null;
		String searchField = "";

		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchField != null) {
			employeeId = Integer.parseInt(searchField);
		}

		map = trainingHandlerService.searchTrainingRequisition(employeeId);

		String jsp = HR_TRAINING_REQUISITION_JSP;
		jsp += ".jsp";
		title = "Training Requisition";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// ***************************************** Start Training Module's
	// Training Approval By Rajendra **************************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = null;
		int currentUserId = 0;
		String userName = "";
		session = request.getSession();
		Users currentUser = null;
		;

		if (session.getAttribute("users") != null) {
			currentUser = (Users) session.getAttribute("users");
			currentUserId = currentUser.getEmployee().getId();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingApprovalJsp(currentUserId);
		String jsp = HR_TRAINING_APPROVAL_JSP;
		jsp += ".jsp";
		title = "Training Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingApprovalStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Date fromDate = new Date();
		Date toDate = new Date();

		HttpSession session = null;
		int currentUserId = 0;
		session = request.getSession();
		Users currentUser = null;
		;

		if (session.getAttribute("users") != null) {
			currentUser = (Users) session.getAttribute("users");
			currentUserId = currentUser.getEmployee().getId();
		}

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map = trainingHandlerService.showTrainingApprovalStatus(fromDate,
				toDate, currentUserId);

		String jsp = HR_SHOW_TRAINING_STATUS_JSP;
		jsp += ".jsp";
		title = "Show Training Status";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateRequisitionStatus(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = null;
		session = request.getSession();

		Users currentUser = null;
		int currentUserId = 0;

		String changedBy = null;
		Date currentDate = new Date();
		String currentTime = null;
		int hospitalId = 0;

		int trainingRequisitionId = 0;
		int trainingStatusId = 0;
		int toBeApproved = 0;
		int currentLabel = 0;
		String statusReason = null;
		Date StatusDate = new Date();

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		if (session.getAttribute("users") != null) {
			currentUser = (Users) session.getAttribute("users");
			currentUserId = currentUser.getEmployee().getId();
		}

		if (session.getAttribute("hospitalId") != null
				&& !(session.getAttribute("hospitalId").equals(""))) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(TO_BE_APPROVED) != null
				&& !(request.getParameter(TO_BE_APPROVED).equals(""))) {
			toBeApproved = Integer.parseInt(request
					.getParameter(TO_BE_APPROVED));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(TRAINING_REQUISITION_ID) != null
				&& !(request.getParameter(TRAINING_REQUISITION_ID).equals(""))) {
			trainingRequisitionId = Integer.parseInt(request
					.getParameter(TRAINING_REQUISITION_ID));
		}
		if (request.getParameter(TRAINING_STATUS_ID) != null
				&& !(request.getParameter(TRAINING_STATUS_ID).equals(""))) {
			trainingStatusId = Integer.parseInt(request
					.getParameter(TRAINING_STATUS_ID));
		}

		if (request.getParameter(STATUS_REASON) != null
				&& !(request.getParameter(STATUS_REASON).equals(""))) {
			statusReason = request.getParameter(STATUS_REASON);
		}
		if (request.getParameter(STATUS_DATE) != null
				&& !(request.getParameter(STATUS_DATE).equals(""))) {
			StatusDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(STATUS_DATE));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("map") != null) {
			map = (HashMap<String, Object>) session.getAttribute("map");
		}

		HrMasTrainingStatus hrMasTrainingStatusList = trainingHandlerService
				.getTrainingStatusMasterById(trainingStatusId);

		// RequestStatusMaster requestStatusMaster =
		// recruitmentHandlerService.getRequestStatusMasterById(requestStatusId);
		List<HrTrainingRequisition> trainingRequisitionList = (List<HrTrainingRequisition>) map
				.get("searchTrainingRequisitionList");

		List<HrTrainingRequisition> trainingRequisitionListToBeUpdated = new ArrayList<HrTrainingRequisition>();
		for (int i = 0; i <= trainingRequisitionList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				trainingRequisitionListToBeUpdated.add(trainingRequisitionList
						.get(i));
			}
		}
		// List<HrTrainingApprovalStatus> hrTrainingApprovalStatusList =new
		// ArrayList<HrTrainingApprovalStatus>();
		// for(HrTrainingRequisition hrTrainingRequisition :
		// trainingRequisitionListToBeUpdated) {
		// hrTrainingApprovalStatusList.add(hrTrainingRequisition.getHrTrainingApprovalStatus());
		// }

		for (HrTrainingRequisition hrTrainingRequisition : trainingRequisitionListToBeUpdated) {
			HrTrainingApprovalStatus hrTrainingApprovalStatus = hrTrainingRequisition
					.getHrTrainingApprovalStatus();

			if (trainingStatusId == 2 || trainingStatusId == 5
					|| trainingStatusId == 5) {
				currentLabel = hrTrainingApprovalStatus.getCurrentLevel() + 1;
			} else {
				currentLabel = hrTrainingApprovalStatus.getCurrentLevel();
			}

			hrTrainingApprovalStatus.setCurrentLevel(currentLabel);
			if (currentUserId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(currentUserId);
				hrTrainingApprovalStatus.setEmployee(masEmployee);
			}

			if (toBeApproved != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(toBeApproved);
				hrTrainingApprovalStatus.setToBeApproved(masEmployee);
			}

			HrMasTrainingStatus hrMasTrainingStatus = new HrMasTrainingStatus();
			hrMasTrainingStatus.setId(trainingStatusId);
			hrTrainingApprovalStatus.setTrainingStatus(hrMasTrainingStatus);

			hrTrainingApprovalStatus.setRemarks(statusReason);
			hrTrainingApprovalStatus.setStatusDate(StatusDate);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingApprovalStatus.setCompany(masHospital);

			hrTrainingApprovalStatus.setLastChgBy(changedBy);
			hrTrainingApprovalStatus.setLastChgDate(currentDate);
			hrTrainingApprovalStatus.setLastChgTime(currentTime);

			hrTrainingApprovalStatus
					.setHrTrainingRequisition(hrTrainingRequisition);

		}

		List updatedList = trainingHandlerService
				.updateRequisitionStatus(trainingRequisitionListToBeUpdated);
		String message = "";
		String url = "/hms/hrms/training?method=showTrainingApprovalJsp";
		if (updatedList != null && updatedList.size() != 0) {
			// String updatedStatus =
			// ((HrTrainingApprovalStatus)updatedList.get(0)).getTrainingStatus().getTrainingStatusDescription();

			if (hrMasTrainingStatusList.getId() == 3) {
				message = "Selected Requests for training has been put "
						+ hrMasTrainingStatusList
								.getTrainingStatusDescription();
			} else {
				message = "Selected Requests for training has been "
						+ hrMasTrainingStatusList
								.getTrainingStatusDescription();
			}
		}

		List searchTrainingRequisitionList = trainingHandlerService
				.getTrainingRequisitionList(currentUserId);

		map.put("messageTOBeVisibleToTheUser", message);
		map.put("url", url);
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index", "map", map);

	}

	// ***************************************** Start Training Module's Show
	// Training Status By Rajendra **************************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = null;
		int currentUserId = 0;
		String userName = "";
		session = request.getSession();
		Users currentUser = null;
		;

		if (session.getAttribute("users") != null) {
			currentUser = (Users) session.getAttribute("users");
			currentUserId = currentUser.getEmployee().getId();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingStatusJsp(currentUserId);

		String jsp = HR_SHOW_TRAINING_STATUS_JSP;
		jsp += ".jsp";
		title = "Show Training Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ***************************************** Start Training Module's
	// Training Scheduling By Rajendra ********************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingSchedulingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingSchedulingJsp();

		String jsp = HR_TRAINING_SCHEDULING_JSP;
		jsp += ".jsp";
		title = "Training Scheduling";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTrainingScheduling(HttpServletRequest request,
			HttpServletResponse response) {

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		
		int hospitalId = 0;

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
		String orderNo = "";
		String endTrainingTime="";
		
		HrTrainingSchedule hrTrainingSchedule = new HrTrainingSchedule();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(TRAINING_ID) != null
				&& !(request.getParameter(TRAINING_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(TRAINING_ID));
		}

		if (request.getParameter(INSTRUCTOR_ID) != null
				&& !(request.getParameter(INSTRUCTOR_ID).equals(""))) {
			instructorId = Integer
					.parseInt(request.getParameter(INSTRUCTOR_ID));
		}
		if (request.getParameter(TRAINING_SCHEDULE_DATE) != null
				&& !(request.getParameter(TRAINING_SCHEDULE_DATE).equals(""))) {
			scheduleDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_SCHEDULE_DATE));
		}
		if (request.getParameter(TRAINING_START_DATE) != null
				&& !(request.getParameter(TRAINING_START_DATE).equals(""))) {
			trainingStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_START_DATE));
		}
		if (request.getParameter(TRAINING_END_DATE) != null
				&& !(request.getParameter(TRAINING_END_DATE).equals(""))) {
			trainingEndDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_END_DATE));
		}

		if (request.getParameter(TRAINING_TIME) != null
				&& !(request.getParameter(TRAINING_TIME).equals(""))) {
			trainingTime = request.getParameter(TRAINING_TIME);
		}
		if (request.getParameter(TRAINING_DURATION) != null
				&& !(request.getParameter(TRAINING_DURATION).equals(""))) {
			trainingDuration = request.getParameter(TRAINING_DURATION);
		}
		if (request.getParameter(CLASS_SIZE) != null
				&& !(request.getParameter(CLASS_SIZE).equals(""))) {
			classSize = Integer.parseInt(request.getParameter(CLASS_SIZE));
		}
		if (request.getParameter(TRAINING_ADDRESS) != null
				&& !(request.getParameter(TRAINING_ADDRESS).equals(""))) {
			trainingAddress = (request.getParameter(TRAINING_ADDRESS));
		}

		/*if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}*/
		
		if (request.getParameter("orderNo") != null	&& !(request.getParameter("orderNo").equals(""))) {
		
			orderNo = request.getParameter("orderNo");
		}
		
		if (request.getParameter("END_TRAINING_TIME") != null
				&& !(request.getParameter("END_TRAINING_TIME").equals(""))) {
			endTrainingTime = request.getParameter("END_TRAINING_TIME");
		}
		 String venue_Type = "";
		 
		 if(request.getParameter("SELECTED_RADIO") != null && ! (request.getParameter("SELECTED_RADIO").equals(""))){
	
			 venue_Type = request.getParameter("SELECTED_RADIO");
		 }
			
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		
		

		boolean successfullyAdded1 = false;

		if (trainingId != null) {

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

			hrTrainingSchedule.setTrainingDate(scheduleDate);
			hrTrainingSchedule.setTrainingStartDate(trainingStartDate);
			hrTrainingSchedule.setTrainingEndDate(trainingEndDate);
			hrTrainingSchedule.setTrainingTime(trainingTime);
			hrTrainingSchedule.setDuration(trainingDuration);
			hrTrainingSchedule.setClassSize(classSize);
			hrTrainingSchedule.setAddress(trainingAddress);
			hrTrainingSchedule.setRemarks(remarks);
			hrTrainingSchedule.setOrderNo(orderNo);
			hrTrainingSchedule.setTrainingEndTime(endTrainingTime);
			hrTrainingSchedule.setTrainingLocationType(venue_Type);

			MasHospital masHospital1 = new MasHospital();
			masHospital1.setId(hospitalId);
			hrTrainingSchedule.setCompany(masHospital1);

			hrTrainingSchedule.setStatus("y");
			hrTrainingSchedule.setLastChgBy(changedBy);
			hrTrainingSchedule.setLastChgDate(currentDate);
			hrTrainingSchedule.setLastChgTime(currentTime);

			/*successfullyAdded1 = trainingHandlerService
					.addTrainingScheduling(hrTrainingSchedule);*/
			
			
			
			Map m = trainingHandlerService
					.addTrainingScheduling(hrTrainingSchedule);
			
			
			successfullyAdded1 =(Boolean)  m.get("successfullyAdded");
			HrTrainingSchedule hrTrainingScheduleForRequuisition =(HrTrainingSchedule) m.get("hrTrainingSchedule");
			
			// for training Requestion 
			
			
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			/*String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			HttpSession session = null;
			int hospitalId = 0;
	*/
			int trainingStatusId = 1;
			int currentStatus = 1;
			String statu = "y";
			Integer employeeId = null;
			Integer rankId = null;
			Integer departmentId = null;
			int tobeApproved = 0;
			//Integer trainingId = null;
			Integer contributingtrainingId = null;
			Date requisitionDate = new Date();
			Date trainingDate = new Date();
			String requisitionStatus = "";
			//String remarks = "";

			HrTrainingRequisition hrTrainingRequisition = new HrTrainingRequisition();
			/*Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();*/

			 session = request.getSession();
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("users", users);
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}

			/*if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			}*/

			if (request.getParameter(RANK_HIDDEN_ID) != null
					&& !(request.getParameter(RANK_HIDDEN_ID).equals(""))) {
				rankId = Integer.parseInt(request.getParameter(RANK_HIDDEN_ID));
			}

			if (request.getParameter(TO_BE_APPROVED) != null
					&& !(request.getParameter(TO_BE_APPROVED).equals(""))) {
				tobeApproved = Integer.parseInt(request
						.getParameter(TO_BE_APPROVED));
			}

			if (request.getParameter(DEPARTMENT_HIDDEN_ID) != null
					&& !(request.getParameter(DEPARTMENT_HIDDEN_ID).equals(""))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_HIDDEN_ID));
			}

			if (request.getParameter(TRAINING_ID) != null
					&& !(request.getParameter(TRAINING_ID).equals(""))) {
				trainingId = Integer.parseInt(request.getParameter(TRAINING_ID));
			}

			if (request.getParameter(CONTRIBUTING_TRAINING_ID) != null
					&& !(request.getParameter(CONTRIBUTING_TRAINING_ID).equals(""))) {
				contributingtrainingId = Integer.parseInt(request
						.getParameter(CONTRIBUTING_TRAINING_ID));
			}

			if (request.getParameter(TRAINING_REQUISITION_DATE) != null
					&& !(request.getParameter(TRAINING_REQUISITION_DATE).equals(""))) {
				requisitionDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TRAINING_REQUISITION_DATE));
			}

			if (request.getParameter(TRAINING_DATE) != null
					&& !(request.getParameter(TRAINING_DATE).equals(""))) {
				trainingDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TRAINING_DATE));
			}

			if (request.getParameter(REMARKS) != null
					&& !(request.getParameter(REMARKS).equals(""))) {
				remarks = request.getParameter(REMARKS);
			}
			
			// get From above code(Training schedule)

			/*if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}*/

			boolean successfullyAdded = false;
			boolean successfullyAddedStatus = false;
			Box box = null;
			
			box = HMSUtil.getBox(request);
			ArrayList al = box.getArrayList("emp_id");
			//System.out.println("empl size>>>"+al.size());
			//if (employeeId != null) {
			if (al.size() >0) {
				
				for(int i = 0 ; i < al.size() ;i++){
					employeeId =Integer.parseInt(""+al.get(i));
					//System.out.println(" employeeId>>>"+employeeId);
				if (employeeId != null) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					hrTrainingRequisition.setEmployee(masEmployee);
				}

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

				if (tobeApproved != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(tobeApproved);
					hrTrainingRequisition.setToBeApproved(masEmployee);
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

				HrMasTrainingStatus hrMasTrainingStatus = new HrMasTrainingStatus();
				hrMasTrainingStatus.setId(trainingStatusId);
				hrTrainingRequisition.setTrainingStatus(hrMasTrainingStatus);

				hrTrainingRequisition.setRequisitionDate(requisitionDate);
				hrTrainingRequisition.setTrainingDate(trainingDate);
				hrTrainingRequisition.setRemarks(remarks);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				hrTrainingRequisition.setCompany(masHospital);

				hrTrainingRequisition.setStatus("y");
				hrTrainingRequisition.setLastChgBy(changedBy);
				hrTrainingRequisition.setLastChgDate(currentDate);
				hrTrainingRequisition.setLastChgTime(currentTime);
				hrTrainingRequisition.setScheduleId(hrTrainingScheduleForRequuisition);

				// -------setting training approval status -------//
				HrTrainingApprovalStatus hrTrainingApprovalStatus = new HrTrainingApprovalStatus();

				if (employeeId != null) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					hrTrainingApprovalStatus.setEmployee(masEmployee);
				}

				if (tobeApproved != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(tobeApproved);
					hrTrainingApprovalStatus.setToBeApproved(masEmployee);
				}

				hrTrainingApprovalStatus.setTrainingStatus(hrMasTrainingStatus);

				hrTrainingApprovalStatus.setCurrentLevel(0);

				hrTrainingApprovalStatus.setCompany(masHospital);
				hrTrainingApprovalStatus.setStatus("y");
				hrTrainingApprovalStatus.setLastChgBy(changedBy);
				hrTrainingApprovalStatus.setLastChgDate(currentDate);
				hrTrainingApprovalStatus.setLastChgTime(currentTime);

				successfullyAdded = trainingHandlerService
						.addTrainingRequisition(hrTrainingRequisition);

				/*if (successfullyAdded) {
					hrTrainingApprovalStatus
							.setHrTrainingRequisition(hrTrainingRequisition);
					successfullyAddedStatus = trainingHandlerService
							.addTrainingApprovalStatus(hrTrainingApprovalStatus);
					message = "Record Added Successfully  !!";
				} else {
					message = "Try Again  !!";
				}

				url = "hms/hrms/training?method=showTrainingRequisitionJsp";
				try {
					map = trainingHandlerService.showTrainingRequisitionJsp(parameterMap);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				
				}
			}
			
			
			
			
			// end for training Requestion
			
			
			
			

			if (successfullyAdded1) {
				message = "Record Added Successfully  !!";
			} else {
				message = "Try Again  !!";
			}

			url = "hms/hrms/training?method=showTrainingSchedulingJsp";
			try {
				map = trainingHandlerService.showTrainingSchedulingJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		String jsp = HR_TRAINING_SCHEDULING_JSP;
		jsp += ".jsp";
		title = "Add Training Scheduling";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editTrainingScheduling(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

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

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingSchedulingId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(TRAINING_ID) != null
				&& !(request.getParameter(TRAINING_ID).equals(""))) {
			trainingId = Integer.parseInt(request.getParameter(TRAINING_ID));
		}

		if (request.getParameter(INSTRUCTOR_ID) != null
				&& !(request.getParameter(INSTRUCTOR_ID).equals(""))) {
			instructorId = Integer
					.parseInt(request.getParameter(INSTRUCTOR_ID));
		}
		if (request.getParameter(TRAINING_SCHEDULE_DATE) != null
				&& !(request.getParameter(TRAINING_SCHEDULE_DATE).equals(""))) {
			scheduleDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_SCHEDULE_DATE));
		}
		if (request.getParameter(TRAINING_START_DATE) != null
				&& !(request.getParameter(TRAINING_START_DATE).equals(""))) {
			trainingStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_START_DATE));
		}
		if (request.getParameter(TRAINING_END_DATE) != null
				&& !(request.getParameter(TRAINING_END_DATE).equals(""))) {
			trainingEndDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRAINING_END_DATE));
		}

		if (request.getParameter(TRAINING_TIME) != null
				&& !(request.getParameter(TRAINING_TIME).equals(""))) {
			trainingTime = request.getParameter(TRAINING_TIME);
		}
		if (request.getParameter(TRAINING_DURATION) != null
				&& !(request.getParameter(TRAINING_DURATION).equals(""))) {
			trainingDuration = request.getParameter(TRAINING_DURATION);
		}
		if (request.getParameter(CLASS_SIZE) != null
				&& !(request.getParameter(CLASS_SIZE).equals(""))) {
			classSize = Integer.parseInt(request.getParameter(CLASS_SIZE));
		}
		if (request.getParameter(TRAINING_ADDRESS) != null
				&& !(request.getParameter(TRAINING_ADDRESS).equals(""))) {
			trainingAddress = (request.getParameter(TRAINING_ADDRESS));
		}

		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		generalMap.put("trainingSchedulingId", trainingSchedulingId);
		generalMap.put("trainingId", trainingId);
		generalMap.put("instructorId", instructorId);
		generalMap.put("scheduleDate", scheduleDate);
		generalMap.put("trainingStartDate", trainingStartDate);
		generalMap.put("trainingEndDate", trainingEndDate);
		generalMap.put("trainingTime", trainingTime);
		generalMap.put("trainingDuration", trainingDuration);
		generalMap.put("classSize", classSize);
		generalMap.put("trainingAddress", trainingAddress);
		generalMap.put("remarks", remarks);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editTrainingScheduling(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "/hms/hrms/training?method=showTrainingSchedulingJsp";
		try {
			map = trainingHandlerService.showTrainingSchedulingJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = HR_TRAINING_SCHEDULING_JSP;
		title = "Edit Training Schedule";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteTrainingScheduling(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int trainingSchedulingId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			trainingSchedulingId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = trainingHandlerService.deleteTrainingScheduling(
				trainingSchedulingId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/training?method=showTrainingSchedulingJsp";

		try {
			map = trainingHandlerService.showTrainingSchedulingJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_TRAINING_SCHEDULING_JSP;
		title = "Delete Training Scheduling";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingScheduling(HttpServletRequest request,
			HttpServletResponse response) {

		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map = trainingHandlerService.showTrainingScheduling(fromDate, toDate);

		String jsp = HR_TRAINING_SCHEDULING_JSP;
		jsp += ".jsp";
		title = "Training Scheduling";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ***************************************** Start Training Module's
	// Training Intimation By Rajendra ********************************//
	@SuppressWarnings("unchecked")
	public ModelAndView showTrainingIntimationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingIntimationJsp();

		String jsp = HR_TRAINING_INTIMATION_JSP;
		jsp += ".jsp";
		title = "Training Intimation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchEmployeeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean toAllEmp = false;
		int locationId = 0;
		int departmentId = 0;
		int employeeId = 0;

		if (request.getParameter(TO_ALL_EMPLOYEE) != null
				&& !(request.getParameter(TO_ALL_EMPLOYEE).equals(""))) {
			toAllEmp = Boolean
					.getBoolean(request.getParameter(TO_ALL_EMPLOYEE));
		}
		if (request.getParameter(LOCATION_ID) != null
				&& !(request.getParameter(LOCATION_ID).equals(""))) {
			locationId = Integer.parseInt(request.getParameter(LOCATION_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		map = trainingHandlerService.searchEmployeeList(toAllEmp, locationId,
				departmentId, employeeId);
		Map map1 = trainingHandlerService.showTrainingIntimationJsp();
		map.putAll(map1);

		String jsp = HR_TRAINING_INTIMATION_JSP;
		jsp += ".jsp";
		title = "Training Intimation";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView broadcastMail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		session = request.getSession(false);

		Users user = (Users) session.getAttribute(RequestConstants.USERS);

		Map<String, Object> map = new HashMap<String, Object>();

		if (session.getAttribute("searchMap") != null) {
			map = (HashMap<String, Object>) session.getAttribute("searchMap");
		}

		List<MasEmployee> employeeTrainingList = (ArrayList<MasEmployee>) map
				.get("employeeTrainingList");

		List<MasEmployee> tempMailList = new ArrayList<MasEmployee>();

		if (employeeTrainingList != null) {
			for (int i = 0; i < employeeTrainingList.size(); i++) {
				String checkedIds = request.getParameter("id" + i);
				if (checkedIds != null) {
					tempMailList.add(employeeTrainingList.get(i));
				}
			}
		}

		/*
		 * Iterator mailIterator=tempMailList.iterator(); int arraySize = 0;
		 * arraySize = tempMailList.size(); String mailList[] = new
		 * String[arraySize]; String emailMessage = ""; String
		 * emailMessageList[] = new String[arraySize]; for(int i = 0;
		 * mailIterator.hasNext(); i++) { Resumepersonaldetails
		 * resumepersonaldetails2 = (Resumepersonaldetails)mailIterator.next();
		 * String emailId = resumepersonaldetails2.getEmailId(); String name =
		 * resumepersonaldetails2.getFirstName()+"
		 * "+resumepersonaldetails2.getLastName(); mailList[i] = name+"
		 * <"+emailId+">"; emailMessage = "Hi "; emailMessage =
		 * emailMessage.concat(resumepersonaldetails2.getFirstName()+"
		 * "+resumepersonaldetails2.getLastName()+"\n\n"); emailMessage =
		 * emailMessage
		 * .concat(RequestUtils.getStringParameter(request,RequestConstants
		 * .MAIL_BODY, "")); emailMessage = emailMessage.concat("\r\r\rThanks
		 * and Regards,\r"); emailMessage =
		 * emailMessage.concat(user.getUserName()); emailMessageList[i] =
		 * emailMessage; }
		 *
		 * String subject
		 * =RequestUtils.getStringParameter(request,RequestConstants
		 * .MAIL_SUBJECT, ""); Map mapForMailMsg = new HashMap();
		 *
		 * try { mapForMailMsg =
		 * SendMail.sendMailForRMS("",mailList,user.getEmailAddress
		 * (),"","",subject,emailMessageList); }catch (Exception e) { } String
		 * sentSuccessfullyMsg =
		 * (String)mapForMailMsg.get("sentSuccessfullyMsg"); String
		 * notSentSuccessfullyMsg =
		 * (String)mapForMailMsg.get("notSentSuccessfullyMsg");
		 *
		 * map.put("sentSuccessfullyMsg",sentSuccessfullyMsg);
		 * map.put("notSentSuccessfullyMsg",notSentSuccessfullyMsg);
		 */
		map.put("title", "Broadcast Mail");
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index", "map", map);
	}

	// Start by Ramdular  on 23-02-2011 For Training and Services Certificate +++++
	//-----------------------------------------Training and Services------------------------------------------
	public ModelAndView showTrainingServiceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> map1 = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId=(Integer)session.getAttribute("deptId");
		//map1.put("deptId", deptId);
		map = trainingHandlerService.showTrainingServiceCertificate();
		String jsp = TRAINING_SERVICE_CERTIFICATE;
		jsp += ".jsp";
		title = "Training Service Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//------------------------by Nilay-------------------------------------------------------------------------
	
	public ModelAndView addTrainingServiceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo=null;
		Date entryDate=null;
		int titleId=0;
		String name=null;
		int age=0;
		String village=null;
		String typeId=null;
		int bloodId=0;
		int empId=0;
		String caseNo=null;
		
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
		
		HttpSession session = null;
		session = request.getSession();
		Users currentUser = null;
		
        int hospitalId=0;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		HrTrainingService hrTrainingService=new HrTrainingService();
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		
		if (request.getParameter("bloodId")!=null && request.getParameter("bloodId")!="");
		{
			bloodId=Integer.parseInt(request.getParameter("bloodId"));
		}
		
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("age")!=null && request.getParameter("age")!="");
		{
			age=Integer.parseInt(request.getParameter("age"));
		}
		if (request.getParameter("village")!=null && request.getParameter("village")!="");
		{
		    village = request.getParameter("village");
		}
		
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="");
		{
			typeId = request.getParameter("typeId");
		}
		
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
	
		map.put("entryNo", entryNo);
		map.put("bloodId", bloodId);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("age", age);
		map.put("village", village);
		map.put("typeId", typeId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("hospitalId",hospitalId);

		
		
	//	if (instructorId != null) {
		//	HrMasInstructor hrMasInstructor = new HrMasInstructor();
		//	hrMasInstructor.setId(instructorId);
		//	hrTrainingSchedule.setInstructor(hrMasInstructor);
	//	}
		
		
		
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
		if (bloodId != 0 )
		{
			MasBloodGroup masBloodGroup=new MasBloodGroup();
			masBloodGroup.setId(bloodId);
			hrTrainingService.setBloodGroup(masBloodGroup);
		}
		if (empId != 0 )
		{
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(empId);
			hrTrainingService.setDoctor(masEmployee);
		}
		if (hospitalId != 0 )
		{
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			hrTrainingService.setHospitalId(masHospital);
		}
		
		
		Map<String, Object>map1=new HashMap<String, Object>();

		int deptId=(Integer)session.getAttribute("deptId");
		map1.put("deptId", deptId);
		map1.put("entryNo", entryNo);
		
		boolean successfullyAdded = false;
		
		successfullyAdded = trainingHandlerService
		.addTrainingServiceCertificate(hrTrainingService,map1);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showTrainingServiceCertificate";
try {
	map = trainingHandlerService.showTrainingServiceCertificate();
} catch (Exception e) {
	e.printStackTrace();
}
String jsp = TRAINING_SERVICE_CERTIFICATE;
jsp += ".jsp";
title = "Training Service Certificate";
map.put("contentJsp", jsp);
map.put("title", title);
map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchTrainingServiceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int entryNos=0;
	
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) 
		{			
			entryNos = Integer.parseInt(request.getParameter(CODE));
		}
		map = trainingHandlerService.searchTrainingServiceCertificate(entryNos);
		
		String jsp = SEARCH_TRAINING_SERVICE_CERTIFICATE;
		jsp += ".jsp";
		title = "Training Service Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editTrainingServiceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
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
		int training_id=0;
		
		HttpSession session = null;
		session = request.getSession();
		Users currentUser = null;
		
		int hospitalId=0;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		HrTrainingService hrTrainingService=new HrTrainingService();
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		if (request.getParameter("bloodId")!=null && request.getParameter("bloodId")!="");
		{
			bloodId=Integer.parseInt(request.getParameter("bloodId"));
		}
		
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("age")!=null && request.getParameter("age")!="");
		{
			age=Integer.parseInt(request.getParameter("age"));
		}
		if (request.getParameter("village")!=null && request.getParameter("village")!="");
		{
		    village = request.getParameter("village");
		}
		
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="");
		{
			typeId = request.getParameter("typeId");
		}
		
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
	
		map.put("entryNo", entryNo);
		map.put("bloodId", bloodId);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("age", age);
		map.put("village", village);
		map.put("typeId", typeId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("training_id",training_id);
		map.put("hospitalId",hospitalId);
		
		/*
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
		if (bloodId != 0 )
		{
			MasBloodGroup masBloodGroup=new MasBloodGroup();
			masBloodGroup.setId(bloodId);
			hrTrainingService.setBloodGroup(masBloodGroup);
		}
		if (empId != 0 )
		{
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(empId);
			hrTrainingService.setDoctor(masEmployee);
		}
		
		*/
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.EditTrainingServiceCertificate(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showTrainingServiceCertificate";
		try {
			map = trainingHandlerService.showTrainingServiceCertificate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = TRAINING_SERVICE_CERTIFICATE;
		jsp += ".jsp";
		title = "Training Service Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
				
		return new ModelAndView("index", "map", map);
	}
	
	
	
	
	
	
	
	//----------------------------------------------------------------------------------------------------------
	
	public ModelAndView showCertificateStudentAdmission(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showCertificateStudentAdmission();
		String jsp = STUDENT_CERTIFICATE_ADMISSION;
		jsp += ".jsp";
		title = "Student Certificate Addmission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addCertificateStudentAdmission(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
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
        int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("age")!=null && request.getParameter("age")!="");
		{
			age=Integer.parseInt(request.getParameter("age"));
		}
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="");
		{
			typeId = request.getParameter("typeId");
		}
		if (request.getParameter("residence")!=null && request.getParameter("residence")!="");
		{
			residence = request.getParameter("residence");
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		map.put("entryNo", entryNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("age", age);
		map.put("residence", residence);
		map.put("typeId", typeId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("hospitalId", hospitalId);
		
		HttpSession session = null;
		session = request.getSession();
		//Users currentUser = null;
		HrStudentCertificate hrStudentCertificate=new HrStudentCertificate();
		
        boolean successfullyAdded = false;
		
        hrStudentCertificate.setAge(age);
        hrStudentCertificate.setCaseNo(caseNo);
        hrStudentCertificate.setEntryNo(entryNo);
        hrStudentCertificate.setName(name);
        hrStudentCertificate.setResidence(residence);
        hrStudentCertificate.setFitFor(typeId);
        hrStudentCertificate.setDate(entryDate);
        hrStudentCertificate.setLastChgDate(changedDate);
        hrStudentCertificate.setLastChgTime(currentTime);
        hrStudentCertificate.setLastChgBy(changedBy);
      
		
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
		

		
		successfullyAdded = trainingHandlerService
		.addCertificateStudentAdmission(hrStudentCertificate);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showCertificateStudentAdmission";
try {
	map = trainingHandlerService.showCertificateStudentAdmission();
} catch (Exception e) {
	e.printStackTrace();
}
  String jsp = STUDENT_CERTIFICATE_ADMISSION;
  jsp += ".jsp";
  title = "Student Certificate";
  map.put("contentJsp", jsp);
  map.put("title", title);
  map.put("message", message);
			
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchCertificateStudentAdmission(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int entryNos=0;
	
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) 
		{			
			entryNos = Integer.parseInt(request.getParameter(CODE));
		}
		map = trainingHandlerService.searchCertificateStudentAdmission(entryNos);
		
		String jsp = SEARCH_STUDENT_CERTIFICATE_ADMISSION;
		jsp += ".jsp";
		title = "Student Certificate Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editCertificateStudentAdmission(HttpServletRequest request,
			HttpServletResponse response) {
		
Map<String, Object> map = new HashMap<String, Object>();
		
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
			
			session = request.getSession();

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("age")!=null && request.getParameter("age")!="");
		{
			age=Integer.parseInt(request.getParameter("age"));
		}
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="");
		{
			typeId = request.getParameter("typeId");
		}
		if (request.getParameter("residence")!=null && request.getParameter("residence")!="");
		{
			residence = request.getParameter("residence");
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		map.put("entryNo", entryNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("age", age);
		map.put("residence", residence);
		map.put("typeId", typeId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("training_id", training_id);
		map.put("hospitalId", hospitalId);
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editCertificateStudentAdmission(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showCertificateStudentAdmission";
		try {
			map = trainingHandlerService.showCertificateStudentAdmission();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = STUDENT_CERTIFICATE_ADMISSION;
		jsp += ".jsp";
		title = "Student Certificate Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
	}
	
	
	
	
	//----------------------------------------------------------------------------------------------------------
	
	public ModelAndView showPatientFitnessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showPatientFitnessCertificate();
		String jsp = PATIENT_FITNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Patient FitNess Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPatientFitnessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int entryNos=0;
	
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) 
		{			
			entryNos = Integer.parseInt(request.getParameter(CODE));
		}
		map = trainingHandlerService.searchPatientFitnessCertificate(entryNos);
		
		String jsp = SEARCH_PATIENT_FITNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Student Certificate Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editPatientFitnessCertificate(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("departmentId")!=null && request.getParameter("departmentId")!="");
		{
			departmentId=Integer.parseInt(request.getParameter("departmentId"));
		}
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("resumeDate") != null && !(request.getParameter("resumeDate").equals(""))) {
			resumeDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("resumeDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		map.put("entryNo", entryNo);
		map.put("hospitalId", hospitalId);
		map.put("regNo", regNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("departmentId", departmentId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("resumeDate", resumeDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("training_id",training_id);
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editPatientFitnessCertificate(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showPatientFitnessCertificate";
		try {
			map = trainingHandlerService.showPatientFitnessCertificate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = PATIENT_FITNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Patient FitNess Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
		
	}
	
	public ModelAndView addPatientFitnessCertificate(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
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
        int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("empId")!=null && request.getParameter("empId")!="");
		{
			empId=Integer.parseInt(request.getParameter("empId"));
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("departmentId")!=null && request.getParameter("departmentId")!="");
		{
			departmentId=Integer.parseInt(request.getParameter("departmentId"));
		}
		if (request.getParameter("caseNo")!=null && request.getParameter("caseNo")!="");
		{
			caseNo = request.getParameter("caseNo");
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name=request.getParameter("Name");
		}
		if (request.getParameter("resumeDate") != null && !(request.getParameter("resumeDate").equals(""))) {
			resumeDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("resumeDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		map.put("entryNo", entryNo);
		map.put("regNo", regNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("departmentId", departmentId);
		map.put("empId", empId);
		map.put("caseNo", caseNo);
		map.put("entryDate", entryDate);
		map.put("resumeDate", resumeDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("hospitalId", hospitalId);
		
		
		HttpSession session = null;
		session = request.getSession();
	
        HrPatientFitnessCertificate hrPatientFitnessCertificate=new HrPatientFitnessCertificate();
		
        boolean successfullyAdded = false;
		
        hrPatientFitnessCertificate.setRegNo(regNo);
        hrPatientFitnessCertificate.setCaseNo(caseNo);
        hrPatientFitnessCertificate.setEntryNo(entryNo);
        hrPatientFitnessCertificate.setName(name);
        hrPatientFitnessCertificate.setResumeDate(resumeDate);
        hrPatientFitnessCertificate.setDate(entryDate);
        hrPatientFitnessCertificate.setLastChgDate(changedDate);
        hrPatientFitnessCertificate.setLastChgTime(currentTime);
        hrPatientFitnessCertificate.setLastChgBy(changedBy);
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
		

		
		successfullyAdded = trainingHandlerService
		.addPatientFitnessCertificate(hrPatientFitnessCertificate);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showPatientFitnessCertificate";
try {
	map = trainingHandlerService.showPatientFitnessCertificate();
} catch (Exception e) {
	e.printStackTrace();
}
String jsp = PATIENT_FITNESS_CERTIFICATE_ENTRY;
jsp += ".jsp";
title = "Patient Fitness Certificate";
map.put("contentJsp", jsp);
map.put("title", title);
map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------
	
	
	public ModelAndView showPatientSicknessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showPatientSicknessCertificate();
		String jsp = PATIENT_SICKNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Patient SickNess Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchPatientSicknessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int entryNos=0;
	
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) 
		{			
			entryNos = Integer.parseInt(request.getParameter(CODE));
		}
		map = trainingHandlerService.searchPatientSicknessCertificate(entryNos);
		
		String jsp = SEARCH_PATIENT_SICKNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "PAtient Sickness Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editPatientSicknessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		
Map<String, Object> map = new HashMap<String, Object>();
		
		String entryNo=null;
		Date entryDate=null;
		String regNo="";
		int titleId=0;
		String name=null;
		int absentDays=0;
		int training_id=0;
		String sufferFromDate="";
		Date effectFromDate=null;
		Date effectToDate=null;
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
        int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("absentDays")!=null && request.getParameter("absentDays")!="");
		{
			absentDays=Integer.parseInt(request.getParameter("absentDays"));
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name = request.getParameter("Name");
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("sufferDate") != null && !(request.getParameter("sufferDate").equals(""))) {
			sufferFromDate = request.getParameter("sufferDate");
		}
		if (request.getParameter("effectFromDate") != null && !(request.getParameter("effectFromDate").equals(""))) {
			effectFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("effectFromDate"));
		}
		if (request.getParameter("effectToDate") != null && !(request.getParameter("effectToDate").equals(""))) {
			effectToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("effectToDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		map.put("entryNo", entryNo);
		map.put("regNo", regNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("absentDays", absentDays);
		map.put("entryDate", entryDate);
		map.put("sufferFromDate", sufferFromDate);
		map.put("effectFromDate", effectFromDate);
		map.put("effectToDate", effectToDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("hospitalId", hospitalId);
		map.put("training_id", training_id);
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editPatientSicknessCertificate(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showPatientSicknessCertificate";
		try {
			map = trainingHandlerService.showPatientSicknessCertificate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = PATIENT_SICKNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Patient Sickness Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
		
	}
		
	
	public ModelAndView addPatientSicknessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		
Map<String, Object> map = new HashMap<String, Object>();
		
		String entryNo=null;
		Date entryDate=null;
		String regNo="";
		int titleId=0;
		String name=null;
		int absentDays=0;
		
		String sufferFromDate="";
		Date effectFromDate=null;
		Date effectToDate=null;
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
        int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("absentDays")!=null && request.getParameter("absentDays")!="");
		{
			absentDays=Integer.parseInt(request.getParameter("absentDays"));
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name = request.getParameter("Name");
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("sufferDate") != null && !(request.getParameter("sufferDate").equals(""))) {
			sufferFromDate = request.getParameter("sufferDate");
		}
		if (request.getParameter("effectFromDate") != null && !(request.getParameter("effectFromDate").equals(""))) {
			effectFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("effectFromDate"));
		}
		if (request.getParameter("effectToDate") != null && !(request.getParameter("effectToDate").equals(""))) {
			effectToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("effectToDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		map.put("entryNo", entryNo);
		map.put("regNo", regNo);
		map.put("titleId", titleId);
		map.put("name", name);
		map.put("absentDays", absentDays);
		map.put("entryDate", entryDate);
		map.put("sufferFromDate", sufferFromDate);
		map.put("effectFromDate", effectFromDate);
		map.put("effectToDate", effectToDate);
		map.put("currentTime",currentTime);
		map.put("changedDate",changedDate);
		map.put("changedBy",changedBy);
		map.put("hospitalId", hospitalId);
		
		
		
		HttpSession session = null;
		session = request.getSession();
	
        HrPatientSickCertificate hrPatientSickCertificate=new HrPatientSickCertificate();
		
        boolean successfullyAdded = false;
		
        hrPatientSickCertificate.setRegNo(regNo);
        hrPatientSickCertificate.setDaysAbsent(absentDays);
        hrPatientSickCertificate.setEntryNo(entryNo);
        hrPatientSickCertificate.setName(name);
        hrPatientSickCertificate.setSufferFromDate(sufferFromDate);
        hrPatientSickCertificate.setEffectFromDate(effectFromDate);
        hrPatientSickCertificate.setEffectToDate(effectToDate);
        hrPatientSickCertificate.setDate(entryDate);
        hrPatientSickCertificate.setLastChgDate(changedDate);
        hrPatientSickCertificate.setLastChgTime(currentTime);
        hrPatientSickCertificate.setLastChgBy(changedBy);
		
		
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
		
		successfullyAdded = trainingHandlerService
		.addPatientSicknessCertificate(hrPatientSickCertificate);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showPatientSicknessCertificate";
try {
	map = trainingHandlerService.showPatientSicknessCertificate();
} catch (Exception e) {
	e.printStackTrace();
}
		
		String jsp = PATIENT_SICKNESS_CERTIFICATE_ENTRY;
		jsp += ".jsp";
		title = "Patient Sickness Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
				return new ModelAndView("index", "map", map);
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	
	public ModelAndView showMedicalCertificateFitnessFirstEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showMedicalCertificateFitnessFirstEntry();
		String jsp = MEDICAL_CERTIFICATE_FITNESS_FIRST_ENTRY;
		jsp += ".jsp";
		title = "Medical Certificate of fitness of first entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editMedicalCertificateFitnessFirstEntry(HttpServletRequest request,
			HttpServletResponse response) {
		
        Map<String, Object> map = new HashMap<String, Object>();
		
		String entryNo=null;
		Date entryDate=null;
		String regNo="";
		int titleId=0;
		String name=null;
		String weakAtBody="";
		String employIn="";
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
        int hospitalId=0;
        int training_id=0;
        String message="";
        
        session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name = request.getParameter("Name");
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("weakAtBody")!=null && request.getParameter("weakAtBody")!="");
		{
			weakAtBody=request.getParameter("weakAtBody");
		}
		if (request.getParameter("employIn")!=null && request.getParameter("employIn")!="");
		{
			employIn=request.getParameter("employIn");
		}
				
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		
		
		map.put("entryNo",entryNo);
		map.put("regNo",regNo);
		map.put("titleId",titleId);
		map.put("name",name);
		map.put("entryDate",entryDate);
		map.put("weakAtBody",weakAtBody);
		map.put("employIn",employIn);
		map.put("hospitalId",hospitalId);
		map.put("changedBy",changedBy);
		map.put("changedDate",changedDate);
		map.put("currentTime",currentTime);
		map.put("training_id", training_id);
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editMedicalCertificateFitnessFirstEntry(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showMedicalCertificateFitnessFirstEntry";
		try {
			map = trainingHandlerService.showMedicalCertificateFitnessFirstEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		String jsp = MEDICAL_CERTIFICATE_FITNESS_FIRST_ENTRY;
		jsp += ".jsp";
		title = "Medical Certificate of fitness of first entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		
		
	}
	
	public ModelAndView addMedicalCertificateFitnessFirstEntry(HttpServletRequest request,
			HttpServletResponse response) {
		
Map<String, Object> map = new HashMap<String, Object>();
		
		String entryNo=null;
		Date entryDate=null;
		String regNo="";
		int titleId=0;
		String name=null;
		String weakAtBody="";
		String employIn="";
		String changedBy = "";
		Date changedDate = new Date();
		String currentTime = "";
        int hospitalId=0;
        
        session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		if (request.getParameter("hinNo")!=null && request.getParameter("hinNo")!="");
		{
			regNo=request.getParameter("hinNo");
		}
		if (request.getParameter("titleId")!=null && request.getParameter("titleId")!="");
		{
			titleId=Integer.parseInt(request.getParameter("titleId"));
		}
		if (request.getParameter("Name")!=null && request.getParameter("Name")!="");
		{
			name = request.getParameter("Name");
		}
		if (request.getParameter("entryDate") != null && !(request.getParameter("entryDate").equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("entryDate"));
		}
		if (request.getParameter("weakAtBody")!=null && request.getParameter("weakAtBody")!="");
		{
			weakAtBody=request.getParameter("weakAtBody");
		}
		if (request.getParameter("employIn")!=null && request.getParameter("employIn")!="");
		{
			employIn=request.getParameter("employIn");
		}
				
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		
		//HttpSession session = null;
		//session = request.getSession();
	
        HrMedicalFitnessFirst hrMedicalFitnessFirst=new HrMedicalFitnessFirst();
		
        boolean successfullyAdded = false;
		
        hrMedicalFitnessFirst.setRegNo(regNo);
        hrMedicalFitnessFirst.setDate(entryDate);
        hrMedicalFitnessFirst.setEntryNo(entryNo);
        hrMedicalFitnessFirst.setName(name);
        hrMedicalFitnessFirst.setConstWeakness(weakAtBody);
        hrMedicalFitnessFirst.setForEmployInOffice(employIn);
        hrMedicalFitnessFirst.setLastChgBy(changedBy);
        hrMedicalFitnessFirst.setLastChgDate(changedDate);
        hrMedicalFitnessFirst.setLastChgTime(currentTime);
        
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

		successfullyAdded = trainingHandlerService
		.addMedicalCertificateFitnessFirstEntry(hrMedicalFitnessFirst);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showMedicalCertificateFitnessFirstEntry";
try {
	map = trainingHandlerService.showMedicalCertificateFitnessFirstEntry();
} catch (Exception e) {
	e.printStackTrace();
}
		
        String jsp = MEDICAL_CERTIFICATE_FITNESS_FIRST_ENTRY;
		jsp += ".jsp";
		title = "Medical Certificate of fitness of first entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
				return new ModelAndView("index", "map", map);
		
	}
	
	public ModelAndView searchMedicalCertificateFitnessFirstEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int entryNos=0;
	
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) 
		{			
			entryNos = Integer.parseInt(request.getParameter(CODE));
		}
		map = trainingHandlerService.searchMedicalCertificateFitnessFirstEntry(entryNos);
		
		String jsp = SEARCH_MEDICAL_CERTIFICATE_FITNESS_FIRST_ENTRY;
		jsp += ".jsp";
		title = "Medical Certificate of fitness of first entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	//-----------------------------------------------------------------------------------------------------------
	
	
	public ModelAndView showMedicalExaminationReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showMedicalExaminationReport();
		String jsp = MEDICAL_EXAMINATION_REPORT;
		jsp += ".jsp";
		title = "Medical Examination Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	//----------------------------------------------------------------------------------------------------
	
	public ModelAndView showMedicalExamEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = trainingHandlerService.showMedicalExamEntry();
		String jsp = MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Medical Examination Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView forUpdateMedicalExamEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int empCode=0;
		if (request.getParameter("empCode")!=null && request.getParameter("empCode")!="")
		{
			empCode=Integer.parseInt(request.getParameter("empCode"));
		}
		map = trainingHandlerService.forUpdateMedicalExamEntry(empCode);
		String jsp = FOR_UPDATE_MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Medical Examination Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		
		
		
	}	
		
		
	public ModelAndView editMedicalExamEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
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
		Boolean successfullyAdded=false;
		int training_id=0;
		
		
		int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="")
		{
			typeId=Integer.parseInt(request.getParameter("typeId"));
		}
		if (request.getParameter("departmentId")!=null && request.getParameter("departmentId")!="")
		{
			departmentId=Integer.parseInt(request.getParameter("departmentId"));
		}
		if (request.getParameter("bloodId")!=null && request.getParameter("bloodId")!="")
		{
			bloodId=Integer.parseInt(request.getParameter("bloodId"));
		}
		if (request.getParameter("empCode")!=null && request.getParameter("empCode")!="")
		{
			empCode=request.getParameter("empCode");
		}
		if (request.getParameter("weightInKgs")!=null && request.getParameter("weightInKgs")!="")
		{
			weight=Integer.parseInt(request.getParameter("weightInKgs"));
		}
		if (request.getParameter("fitUnFit")!=null && request.getParameter("fitUnFit")!="")
		{
			fitUnFit=Integer.parseInt(request.getParameter("fitUnFit"));
		}
	//	if (request.getParameter(fitUnFit) != null
	//			&& !request.getParameter(fitUnFit).equals("0")) {
			
			
		
		if(request.getParameter("doctorId")!=null && request.getParameter("doctorId")!="")
		{
			doctorId=Integer.parseInt(request.getParameter("doctorId"));
		}
		
		if (request.getParameter("name")!=null && request.getParameter("name")!="")
		{
			empName = request.getParameter("name");
		}
		if (request.getParameter("height")!=null && request.getParameter("height")!="")
		{
			height = request.getParameter("height");
		}
		
		if (request.getParameter("identification")!=null && request.getParameter("identification")!="")
		{
			identification = request.getParameter("identification");
		}
		if (request.getParameter("pastHistory")!=null && request.getParameter("pastHistory")!="")
		{
			pastHistory = request.getParameter("pastHistory");
		}
		if (request.getParameter("personalHistory")!=null && request.getParameter("personalHistory")!="")
		{
			personalHistory = request.getParameter("personalHistory");
		}
		if (request.getParameter("familyHistory")!=null && request.getParameter("familyHistory")!="")
		{
			familyHistory = request.getParameter("familyHistory");
		}
		if (request.getParameter("presentComplaint")!=null && request.getParameter("presentComplaint")!="")
		{
			presentComplaint = request.getParameter("presentComplaint");
		}
		if (request.getParameter("eyeVision")!=null && request.getParameter("eyeVision")!="")
		{
			eyeVision = request.getParameter("eyeVision");
		}
		if (request.getParameter("colorVision")!=null && request.getParameter("colorVision")!="")
		{
			colorVision = request.getParameter("colorVision");
		}
		if (request.getParameter("skin")!=null && request.getParameter("skin")!="")
		{
			skin = request.getParameter("skin");
		}
		if (request.getParameter("respiratory")!=null && request.getParameter("respiratory")!="")
		{
			respiratory = request.getParameter("respiratory");
		}
		if (request.getParameter("cardiovascular")!=null && request.getParameter("cardiovascular")!="")
		{
			cardiovascular = request.getParameter("cardiovascular");
		}
		if (request.getParameter("bloodPressure")!=null && request.getParameter("bloodPressure")!="")
		{
			bloodPressure = request.getParameter("bloodPressure");
		}
		if (request.getParameter("abdomen")!=null && request.getParameter("abdomen")!="")
		{
			abdomen = request.getParameter("abdomen");
		}
		
		if (request.getParameter("genito")!=null && request.getParameter("genito")!="")
		{
			genito = request.getParameter("genito");
		}
		if (request.getParameter("Masculo")!=null && request.getParameter("Masculo")!="")
		{
			masculo = request.getParameter("Masculo");
		}
		if (request.getParameter("nervous")!=null && request.getParameter("nervous")!="")
		{
			nervous = request.getParameter("nervous");
		}
		if (request.getParameter("chest")!=null && request.getParameter("chest")!="")
		{
			chest = request.getParameter("chest");
		}
		if (request.getParameter("blood")!=null && request.getParameter("blood")!="")
		{
			blood = request.getParameter("blood");
		}
		if (request.getParameter("urine")!=null && request.getParameter("urine")!="")
		{
			urine = request.getParameter("urine");
		}
		if (request.getParameter("others")!=null && request.getParameter("others")!="")
		{
			others = request.getParameter("others");
		}
		if (request.getParameter("otherTest")!=null && request.getParameter("otherTest")!="")
		{
			otherTest = request.getParameter("otherTest");
		}
		if (request.getParameter("addRemarks")!=null && request.getParameter("addRemarks")!="")
		{
			addRemarks = request.getParameter("addRemarks");
		}
		if (request.getParameter("unFitRemarks")!=null && request.getParameter("unFitRemarks")!="")
		{
			fitUnfitRemarks = request.getParameter("unFitRemarks");
		}
		if (request.getParameter("dateOfBirth") != null && !(request.getParameter("dateOfBirth").equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfBirth"));
		}
		if (request.getParameter("dateOfJoin") != null && !(request.getParameter("dateOfJoin").equals(""))) {
			dateOfJoin = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfJoin"));
		}
		if (request.getParameter("dateOfPersDate") != null && !(request.getParameter("dateOfPersDate").equals(""))) {
			dateOfPersDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfPersDate"));
		}
		if (request.getParameter("dateOfPathDate") != null && !(request.getParameter("dateOfPathDate").equals(""))) {
			dateOfPathDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfPathDate"));
		}
		if (request.getParameter("observeDate") != null && !(request.getParameter("observeDate").equals(""))) {
			observeDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("observeDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		if (request.getParameter(TRAINING_ID)!=null && request.getParameter(TRAINING_ID)!="");
		{
			training_id=Integer.parseInt(request.getParameter(TRAINING_ID));
		}
		
		map.put("hospitalId",hospitalId);
		map.put("changedBy",changedBy);
		map.put("changedDate",changedDate);
		map.put("currentTime",currentTime);
		
		map.put("typeId",typeId);
		map.put("departmentId",departmentId);
		map.put("bloodId",bloodId);
		map.put("empCode",empCode);
		
		map.put("weight",weight);
		map.put("fitUnFit",fitUnFit);
		map.put("height",height);
		map.put("empName",empName);
		
		map.put("identification",identification);
		map.put("pastHistory",pastHistory);
		map.put("personalHistory",personalHistory);
		map.put("familyHistory",familyHistory);
		
		map.put("presentComplaint",presentComplaint);
		map.put("eyeVision",eyeVision);
		map.put("colorVision",colorVision);
		map.put("skin",skin);
		
		map.put("respiratory",respiratory);
		map.put("cardiovascular",cardiovascular);
		map.put("bloodPressure",bloodPressure);
		map.put("abdomen",abdomen);
		
		map.put("genito",genito);
		map.put("masculo",masculo);
		map.put("nervous",nervous);
		map.put("chest",chest);
		
		map.put("blood",blood);
		map.put("urine",urine);
		map.put("others",others);
		map.put("otherTest",otherTest);
		map.put("doctorId",doctorId);
		
		map.put("addRemarks",addRemarks);
		map.put("fitUnfitRemarks",fitUnfitRemarks);
		map.put("dateOfBirth",dateOfBirth);
		map.put("dateOfPersDate",dateOfPersDate);
		
		map.put("dateOfPathDate",dateOfPathDate);
		map.put("observeDate",observeDate);
		map.put("changedBy",changedBy);
		map.put("changedDate",changedDate);
		map.put("currentTime",currentTime);
		map.put("training_id",training_id);
		
	
		
		boolean dataUpdated = false;

		dataUpdated = trainingHandlerService.editMedicalExamEntry(map);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		url = "hms/hrms/training?method=showMedicalExamEntry";
		try {
			map = trainingHandlerService.showMedicalExamEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		String jsp = MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Medical Examination Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView addMedicalExamEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
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
		Boolean successfullyAdded=false;
		
		
		int hospitalId=0;
		
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		
		if (request.getParameter("typeId")!=null && request.getParameter("typeId")!="")
		{
			typeId=Integer.parseInt(request.getParameter("typeId"));
		}
		if (request.getParameter("departmentId")!=null && request.getParameter("departmentId")!="")
		{
			departmentId=Integer.parseInt(request.getParameter("departmentId"));
		}
		if (request.getParameter("bloodId")!=null && request.getParameter("bloodId")!="")
		{
			bloodId=Integer.parseInt(request.getParameter("bloodId"));
		}
		if (request.getParameter("empCode")!=null && request.getParameter("empCode")!="")
		{
			empCode=request.getParameter("empCode");
		}
		if (request.getParameter("weightInKgs")!=null && request.getParameter("weightInKgs")!="")
		{
			weight=Integer.parseInt(request.getParameter("weightInKgs"));
		}
		if (request.getParameter("fitUnFit")!=null && request.getParameter("fitUnFit")!="")
		{
			fitUnFit=Integer.parseInt(request.getParameter("fitUnFit"));
		}
	//	if (request.getParameter(fitUnFit) != null
	//			&& !request.getParameter(fitUnFit).equals("0")) {
			
			
		
		if(request.getParameter("doctorId")!=null && request.getParameter("doctorId")!="")
		{
			doctorId=Integer.parseInt(request.getParameter("doctorId"));
		}
		
		if (request.getParameter("name")!=null && request.getParameter("name")!="")
		{
			empName = request.getParameter("name");
		}
		if (request.getParameter("height")!=null && request.getParameter("height")!="")
		{
			height = request.getParameter("height");
		}
		
		if (request.getParameter("identification")!=null && request.getParameter("identification")!="")
		{
			identification = request.getParameter("identification");
		}
		if (request.getParameter("pastHistory")!=null && request.getParameter("pastHistory")!="")
		{
			pastHistory = request.getParameter("pastHistory");
		}
		if (request.getParameter("personalHistory")!=null && request.getParameter("personalHistory")!="")
		{
			personalHistory = request.getParameter("personalHistory");
		}
		if (request.getParameter("familyHistory")!=null && request.getParameter("familyHistory")!="")
		{
			familyHistory = request.getParameter("familyHistory");
		}
		if (request.getParameter("presentComplaint")!=null && request.getParameter("presentComplaint")!="")
		{
			presentComplaint = request.getParameter("presentComplaint");
		}
		if (request.getParameter("eyeVision")!=null && request.getParameter("eyeVision")!="")
		{
			eyeVision = request.getParameter("eyeVision");
		}
		if (request.getParameter("colorVision")!=null && request.getParameter("colorVision")!="")
		{
			colorVision = request.getParameter("colorVision");
		}
		if (request.getParameter("skin")!=null && request.getParameter("skin")!="")
		{
			skin = request.getParameter("skin");
		}
		if (request.getParameter("respiratory")!=null && request.getParameter("respiratory")!="")
		{
			respiratory = request.getParameter("respiratory");
		}
		if (request.getParameter("cardiovascular")!=null && request.getParameter("cardiovascular")!="")
		{
			cardiovascular = request.getParameter("cardiovascular");
		}
		if (request.getParameter("bloodPressure")!=null && request.getParameter("bloodPressure")!="")
		{
			bloodPressure = request.getParameter("bloodPressure");
		}
		if (request.getParameter("abdomen")!=null && request.getParameter("abdomen")!="")
		{
			abdomen = request.getParameter("abdomen");
		}
		
		if (request.getParameter("genito")!=null && request.getParameter("genito")!="")
		{
			genito = request.getParameter("genito");
		}
		if (request.getParameter("Masculo")!=null && request.getParameter("Masculo")!="")
		{
			masculo = request.getParameter("Masculo");
		}
		if (request.getParameter("nervous")!=null && request.getParameter("nervous")!="")
		{
			nervous = request.getParameter("nervous");
		}
		if (request.getParameter("chest")!=null && request.getParameter("chest")!="")
		{
			chest = request.getParameter("chest");
		}
		if (request.getParameter("blood")!=null && request.getParameter("blood")!="")
		{
			blood = request.getParameter("blood");
		}
		if (request.getParameter("urine")!=null && request.getParameter("urine")!="")
		{
			urine = request.getParameter("urine");
		}
		if (request.getParameter("others")!=null && request.getParameter("others")!="")
		{
			others = request.getParameter("others");
		}
		if (request.getParameter("otherTest")!=null && request.getParameter("otherTest")!="")
		{
			otherTest = request.getParameter("otherTest");
		}
		if (request.getParameter("addRemarks")!=null && request.getParameter("addRemarks")!="")
		{
			addRemarks = request.getParameter("addRemarks");
		}
		if (request.getParameter("unFitRemarks")!=null && request.getParameter("unFitRemarks")!="")
		{
			fitUnfitRemarks = request.getParameter("unFitRemarks");
		}
		if (request.getParameter("dateOfBirth") != null && !(request.getParameter("dateOfBirth").equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfBirth"));
		}
		if (request.getParameter("dateOfJoin") != null && !(request.getParameter("dateOfJoin").equals(""))) {
			dateOfJoin = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfJoin"));
		}
		if (request.getParameter("dateOfPersDate") != null && !(request.getParameter("dateOfPersDate").equals(""))) {
			dateOfPersDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfPersDate"));
		}
		if (request.getParameter("dateOfPathDate") != null && !(request.getParameter("dateOfPathDate").equals(""))) {
			dateOfPathDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfPathDate"));
		}
		if (request.getParameter("observeDate") != null && !(request.getParameter("observeDate").equals(""))) {
			observeDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("observeDate"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		
		HrMedicalRecord hrMedicalRecord=new HrMedicalRecord();
		
		
		hrMedicalRecord.setAbdomen(abdomen);
		hrMedicalRecord.setAddlRemarks(addRemarks);
		hrMedicalRecord.setAnyOtherTest(otherTest);
		hrMedicalRecord.setBlood(blood);
		hrMedicalRecord.setBloodPressure(bloodPressure);
		hrMedicalRecord.setCardiovascularSystem(cardiovascular);
		hrMedicalRecord.setChestXRay(chest);
		hrMedicalRecord.setColorVision(colorVision);
	//	hrMedicalRecord.setDepartment(department);
		hrMedicalRecord.setDocObservationDate(observeDate);
	//	hrMedicalRecord.setDoctor(doctor);
		hrMedicalRecord.setEmpCode(empCode);
		hrMedicalRecord.setEmpName(empName);
		hrMedicalRecord.setExamType(typeId);
		hrMedicalRecord.setEyesight(eyeVision);
		hrMedicalRecord.setFamilyHistory(familyHistory);
		hrMedicalRecord.setFitUnfit(fitUnFit);
		hrMedicalRecord.setFitUnfitRemarks(fitUnfitRemarks);
		hrMedicalRecord.setGenitoUrinarySystem(genito);
		hrMedicalRecord.setHeight(height);
		hrMedicalRecord.setIdentificationMark(identification);
		hrMedicalRecord.setLastCgDate(changedDate);
		hrMedicalRecord.setLastChgBy(changedBy);
		hrMedicalRecord.setLastChgTime(currentTime);
		hrMedicalRecord.setMasculoGenitalSystem(masculo);
		hrMedicalRecord.setMouthEarThroat(mouth);
		hrMedicalRecord.setNervousSystem(nervous);
		hrMedicalRecord.setOthers(others);
		hrMedicalRecord.setPastHistory(pastHistory);
		hrMedicalRecord.setPathoExamDate(dateOfPathDate);
		hrMedicalRecord.setPersonalHabits(personalHistory);
		hrMedicalRecord.setPhysicalExamDate(dateOfPersDate);
		hrMedicalRecord.setPresentComplain(presentComplaint);
		hrMedicalRecord.setRespiratorySystem(respiratory);
		hrMedicalRecord.setSkinCondition(skin);
		hrMedicalRecord.setUrine(urine);
		hrMedicalRecord.setWeight(weight);
		hrMedicalRecord.setDateOfBirth(dateOfBirth);
		
		if (hospitalId != 0 )
		{
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			hrMedicalRecord.setHospitalId(masHospital);	
		}
		
		if (doctorId != 0 )
		{
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(doctorId);
			hrMedicalRecord.setDoctor(masEmployee);
		}
		if (departmentId != 0 )
		{
			MasDepartment masDepartment=new MasDepartment();
			masDepartment.setId(departmentId);
			hrMedicalRecord.setDepartment(masDepartment);
		}
		if (bloodId != 0 )
		{
			MasBloodGroup masBloodGroup=new MasBloodGroup();
			masBloodGroup.setId(bloodId);
			hrMedicalRecord.setBloodGroup(masBloodGroup);
		}
		

		successfullyAdded = trainingHandlerService
		.addMedicalExamEntry(hrMedicalRecord);


if (successfullyAdded) {
	message = "Record Added Successfully  !!";
} else {
	message = "Try Again  !!";
}

url = "hms/hrms/training?method=showMedicalExamEntry";
try {
	map = trainingHandlerService.showMedicalExamEntry();
} catch (Exception e) {
	e.printStackTrace();
}
		
        String jsp = MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Medical Exam entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSearchMedicalExamEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = trainingHandlerService.showSearchMedicalExamEntry();
		
		
		String jsp = RESPONSE_SEARCH_MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Search Medical Exam entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public ModelAndView searchMedicalExaminationReport(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String empName="";
		String empCode="";
		String height="";
		String identification="";
		int departmentId=0;
		int bloodId=0;
		int typeId=0;
		Date dateOfBirth=null;
		Date dateOfJoin=null;
		
		try
		{
			if (request.getParameter("typeId") != null && !(request.getParameter("typeId").equals("")))
			{
				typeId=Integer.parseInt(request.getParameter("typeId"));
				enquiryMap.put("typeId", typeId);
			}	
			
		if (request.getParameter("empName") != null && !(request.getParameter("empName").equals("")))
		{
			empName=request.getParameter("empName");
			enquiryMap.put("empName", empName);
		}
		
		if (request.getParameter("empCode") != null	&& !(request.getParameter("empCode").equals(""))) 
		{
			empCode = request.getParameter("empCode");
			enquiryMap.put("empCode", empCode);
		}
		if (request.getParameter("departmentId") != null && !(request.getParameter("departmentId").equals(""))) 
		{
			departmentId = Integer.parseInt(request.getParameter("departmentId"));
			enquiryMap.put("departmentId", departmentId);
		}
		if (request.getParameter("bloodId") != null && !(request.getParameter("bloodId").equals(""))) 
		{
			bloodId = Integer.parseInt(request.getParameter("bloodId"));
			enquiryMap.put("bloodId", bloodId);
		}
		if (request.getParameter("height") != null	&& !(request.getParameter("height").equals(""))) 
		{
			height = request.getParameter("height");
			enquiryMap.put("height", height);
		}
		if (request.getParameter("identification") != null	&& !(request.getParameter("identification").equals(""))) 
		{
			identification = request.getParameter("identification");
			enquiryMap.put("identification", identification);
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		map = trainingHandlerService.searchMedicalExaminationReport(enquiryMap);
		
		String jsp = RESPONSE_SEARCH_MEDICAL_EXAM_ENTRY;
		jsp += ".jsp";
		title = "Response Search Medical Exam entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView printTrainingServiceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String entryNo="";
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		try {

			detailsMap = trainingHandlerService.getConnectionForReport();	
			parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("entryNo", entryNo);
			
			HMSUtil.generateReport(TRAINING_SERVICE_CERTIFICATE_REPORT,
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printStudentAdmissionCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
        String entryNo="";
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		try {
			detailsMap = trainingHandlerService.getConnectionForReport();
			parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("entryNo", entryNo);
			HMSUtil.generateReport(STUDENT_ADDMISSION_CERTIFICATE_REPORT,
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printPatientFitnessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String entryNo="";
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		try {

			detailsMap = trainingHandlerService.getConnectionForReport();	
			parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("entryNo", entryNo);
			
			HMSUtil.generateReport(PATIENT_FITNESS_CERTIFICATE,
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printPatientSicknessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String entryNo="";
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		try {

			detailsMap = trainingHandlerService.getConnectionForReport();	
			parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("entryNo", entryNo);
			
			HMSUtil.generateReport("PatientSicknessCertificate", parameters, (Connection) detailsMap.get("conn"), response, getServletContext());
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printPatientFitnessFirstEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String entryNo="";
		
		if (request.getParameter("entryNo")!=null && request.getParameter("entryNo")!=" ");
		{
			entryNo=request.getParameter("entryNo");
			
		}
		
		try {

			detailsMap = trainingHandlerService.getConnectionForReport();	
			parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("entryNo", entryNo);
			
			HMSUtil.generateReport("MedicalCertificateFitnessFirstEntry",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printMedicalExaminationReport(HttpServletRequest request ,HttpServletResponse response) 
	{
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		String empCode="";
		if (request.getParameter("empCode")!=null && request.getParameter("empCode")!=" ");
		{
			empCode=request.getParameter("empCode");
			
		}

		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("IMAGE_DIR_LEFT", getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_DIR_RIGHT", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("empCode", empCode);
		
		if(empCode!= null)
		{
		HMSUtil.generateReport("MedicalExaminationReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}
			return null;
	}
	
	
	public ModelAndView showTrainingScheduleReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingScheduleReport();
		String jsp = TRAINING_SCHEDULE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTrainingScheduleReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qry = "";
		int trainingId =0;
		if (! request.getParameter(TRAINING_ID).equals("0")) {
			trainingId =Integer.parseInt(request.getParameter(TRAINING_ID));
			qry += " and hr_mas_training.training_id = "+trainingId;
		}
		int instructorId = 0;
		if (! request.getParameter(INSTRUCTOR_ID).equals("0")) {
			instructorId =Integer.parseInt(request.getParameter(INSTRUCTOR_ID));
			qry += " and hr_mas_instructor.instructor_id = "+instructorId;
		}
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE)!= null) {
			fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE)!= null) {
			toDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("trainingId", trainingId);
		parameters.put("instructorId", instructorId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("toDate", toDate);
		parameters.put("qryString", qry);

			HMSUtil.generateReport("trainingScheduleReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());

			return null;
	}
	public ModelAndView showTrainingRequistionReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingRequistionReport();
		String jsp = TRAINING_REQUISTION_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTrainingRequistionReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qry = "";
		int reqStatusId = 0;
		if ( request.getParameter("reqStatus")!= null) {
			reqStatusId =Integer.parseInt(request.getParameter("reqStatus"));
		}
		int employeeId =0;
		if (! request.getParameter(EMPLOYEE_ID).equals("0")) {
			employeeId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			qry += " and mas_employee.employee_id = "+employeeId;
		}
		int departmentId = 0;
		if (! request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId =Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			qry += " and mas_department.`department_id`= "+departmentId;
		}

		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("reqStatusId", reqStatusId);
		parameters.put("employeeId", employeeId);
		parameters.put("departmentId", departmentId);
		parameters.put("qryString", qry);

		HMSUtil.generateReport("trainingRequisitionReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());

			return null;
	}
	
	public ModelAndView showTrainingDetailReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingDetailReport();
		String jsp = TRAINING_DETAIL_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTrainingDetailReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qry = "";
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE)!= null) {
			fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE)!= null) {
			toDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		int employeeId =0;
		if (! request.getParameter(EMPLOYEE_ID).equals("0")) {
			employeeId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			qry += " and mas_employee.employee_id = "+employeeId;
		}
		int departmentId = 0;
		if (! request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId =Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			qry += " and mas_department.department_id = "+departmentId;
		}
		int trainingId =0;
		if (! request.getParameter(TRAINING_ID).equals("0")) {
			trainingId =Integer.parseInt(request.getParameter(TRAINING_ID));
			qry += " and hr_mas_training.training_id = "+trainingId;
		}
		int instructorId = 0;
		if (! request.getParameter(INSTRUCTOR_ID).equals("0")) {
			instructorId =Integer.parseInt(request.getParameter(INSTRUCTOR_ID));
			qry += " and hr_mas_instructor.instructor_id = "+instructorId;
		}
		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("employeeId", employeeId);
		parameters.put("departmentId", departmentId);
		parameters.put("trainingId", trainingId);
		parameters.put("instructorId", instructorId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qryString", qry);
		HMSUtil.generateReport("trainingDetailReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showTrainingEvaluationReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = trainingHandlerService.showTrainingEvaluationReport();
		String jsp = TRAINING_EVALUATION_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printTrainingEvaluationReport(HttpServletRequest request ,HttpServletResponse response)
	{
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qry = "";
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE)!= null) {
			fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE)!= null) {
			toDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		int employeeId =0;
		if (! request.getParameter(EMPLOYEE_ID).equals("0")) {
			employeeId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			qry += " and mas_employee.employee_id = "+employeeId;
		}
		int courseId = 0;
		if (! request.getParameter(COURSE_ID).equals("0")) {
			courseId =Integer.parseInt(request.getParameter(COURSE_ID));
			qry += " and hr_mas_course.course_id = "+courseId;
		}

		int instructorId = 0;
		if (! request.getParameter(INSTRUCTOR_ID).equals("0")) {
			instructorId =Integer.parseInt(request.getParameter(INSTRUCTOR_ID));
			qry += " and hr_mas_instructor.instructor_id = "+instructorId;
		}
		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("employeeId", employeeId);
		parameters.put("courseId", courseId);
		parameters.put("instructorId", instructorId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qryString", qry);
		HMSUtil.generateReport("trainingEvaluationReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	public ModelAndView showDepartmentWiseTrainingReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		map = trainingHandlerService.showDepartmentWiseTrainingReport();
		String jsp = DEPARTMENTWISE_TRAINING_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAppropriationReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map= new HashMap<String, Object>();
		
		String jsp = DEPARTMENTWISE_TRAINING_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView printDepartemntWiseTrainingReport(HttpServletRequest request ,HttpServletResponse response) 
	{
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int departmentId = 0;
		if (! request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId =Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		detailsMap = trainingHandlerService.getConnectionForReport();
		parameters.put("departmentId", departmentId);
		if(departmentId!= 0){
		HMSUtil.generateReport("departmentWiseTrainingReport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}else
		{
			HMSUtil.generateReport("departmentWiseTrainingReportForAll", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		}
			return null;
	}
	
	
	
	
	 public void getNameTitle(HttpServletRequest request ,HttpServletResponse response)
	 {
		 Map<String, Object> map = new HashMap<String, Object>();
		 String regNo="";
		 if (request.getParameter("hinNo")!=null && !request.getParameter("hinNo").equals(""));
			{
				regNo=request.getParameter("hinNo");
			}
			map=trainingHandlerService.getNameTitle(regNo);
		
		List<Patient> patientNameTitleList = new ArrayList<Patient>();
		
		if (map.get("patientNameTitleList") != null) {
			patientNameTitleList = (List) map.get("patientNameTitleList");
		}
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientNameTitleList) {
				sb.append("<item>");
				String ptName="";
				String lastName="";
				if(patient.getPLastName() !=null){
					lastName=patient.getPLastName();
				}
				ptName=patient.getPFirstName()+" "+lastName;
				sb.append("<name>" + ptName + "</name>");
				if (patient.getTitle() != null) {
					sb.append("<titleId>" + patient.getTitle().getId() + "</titleId>");
				} else {
					sb.append("<titleId>-</titleId>");
				}
				if (patient.getTitle() != null) {
					sb.append("<titleName>" + patient.getTitle().getTitleName() + "</titleName>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	 public void getNameDepartment(HttpServletRequest request ,HttpServletResponse response)
	 {
		 Map<String, Object> map = new HashMap<String, Object>();
		 String empCode="";
		 
		 if (request.getParameter("empCode")!=null && !request.getParameter("empCode").equals(""));
			{
				empCode=request.getParameter("empCode");
			}
			map=trainingHandlerService.getNameDepartment(empCode);
		
			List<MasEmployee> empNameDepartmentList = new ArrayList<MasEmployee>();
			
			if (map.get("empNameDepartmentList") != null) {
				empNameDepartmentList = (List) map.get("empNameDepartmentList");
			}
			
			StringBuffer sb = new StringBuffer();
			try {
				sb.append("<items>");
				for (MasEmployee emp : empNameDepartmentList) {
					sb.append("<item>");
					String ptName="";
					String lastName="";
					if(emp.getLastName()!=null){
						lastName=emp.getLastName();
					}
					ptName=emp.getFirstName()+" "+lastName;
					sb.append("<name>" + ptName + "</name>");
					if (emp.getDepartment() != null) {
						sb.append("<departmentId>" + emp.getDepartment().getId() + "</departmentId>");
					} else {
						sb.append("<departmentId>-</departmentId>");
					}
					if (emp.getDepartment() != null) {
						sb.append("<departmentName>" + emp.getDepartment().getDepartmentName()+ "</departmentName>");
					}
					sb.append("</item>");
					break;
				}
				sb.append("</items>");
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");

			} catch (Exception e) {
				e.printStackTrace();
			}
			
	 }
	 
	 public ModelAndView getNameDepartmentforAjax(HttpServletRequest request ,HttpServletResponse response)
	 {
		 Map<String, Object> map = new HashMap<String, Object>();
		 String empCode="";
		 int typeId=0;
		 
		 if (request.getParameter("empCode")!=null && !request.getParameter("empCode").equals(""));
			{
				empCode=request.getParameter("empCode");
			}
			
			if (request.getParameter("typeId")!=null && !request.getParameter("typeId").equals(""));
			{
				typeId=Integer.parseInt(request.getParameter("typeId"));
			}
			
			map=trainingHandlerService.getNameDepartment(empCode);
		
			String jsp = "searchMedicalExamEntry";
//			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("typeId", typeId);
			return new ModelAndView(jsp, "map", map);
			
	 }
	// Start Add training type Master by Ramdular ++++++++++++++++++++++++15/04/2011
	 
	 

		public ModelAndView showTrainingTypeJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			map = trainingHandlerService.showTrainingTypeJsp();
			String jsp=TRAINING_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		public ModelAndView saveTrainingType(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasTrainingType masTrainingType = new MasTrainingType();
			HttpSession session = request.getSession();
			int hospitalId =0;
			if (session.getAttribute("hospitalId")!= null) {
				hospitalId = (Integer)session.getAttribute("hospitalId");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				masTrainingType.setHospital(masHospital);

			}
			if (request.getParameter(TRAINING_TYPE_CODE) != null) {
				masTrainingType.setTrainingTypeCode(request.getParameter(TRAINING_TYPE_CODE));
			}
			if (request.getParameter(TRAINING_TYPE_NAME) != null) {
				masTrainingType.setTrainingTypeName(request.getParameter(TRAINING_TYPE_NAME));
			}
			String changedBy = "";
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				masTrainingType.setLastChgBy(request.getParameter(CHANGED_BY));
			}

			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				masTrainingType.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)));
			}
			String currentTime = "";
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				masTrainingType.setLastChgTime(currentTime = request.getParameter(CHANGED_TIME));
			}
			masTrainingType.setStatus("y");

			map = trainingHandlerService.saveTrainingType(masTrainingType);

			String jsp=TRAINING_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}

		public ModelAndView editTrainingType(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			if(request.getParameter(TRAINING_TYPE_ID) != null && !(request.getParameter(TRAINING_TYPE_ID).equals(""))){
				int trainingTypeId =Integer.parseInt( request.getParameter(TRAINING_TYPE_ID));
				generalMap.put("trainingTypeId", trainingTypeId);
			}

			if(request.getParameter(TRAINING_TYPE_CODE) != null && !(request.getParameter(TRAINING_TYPE_CODE).equals(""))){
				String trainingTypeCode = request.getParameter(TRAINING_TYPE_CODE);
				generalMap.put("trainingTypeCode", trainingTypeCode);
			}
			if(request.getParameter(TRAINING_TYPE_NAME) != null && !(request.getParameter(TRAINING_TYPE_NAME).equals(""))){
				String trainingName = request.getParameter(TRAINING_TYPE_NAME);
				generalMap.put("trainingName", trainingName);
			}

			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				generalMap.put("changedBy", changedBy);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
				generalMap.put("currentDate", currentDate);
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String currentTime = request.getParameter(CHANGED_TIME);
				generalMap.put("currentTime", currentTime);
			}

			map = trainingHandlerService.editTrainingType(generalMap);
			String jsp=TRAINING_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		public ModelAndView deleteTrainingType(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			String message="";
			String flag ="";
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if(request.getParameter(TRAINING_TYPE_ID) != null && !(request.getParameter(TRAINING_TYPE_ID).equals(""))){
				int trainingTypeId=Integer.parseInt( request.getParameter(TRAINING_TYPE_ID));
				generalMap.put("trainingTypeId", trainingTypeId);
			}

			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				generalMap.put("changedBy", changedBy);
			}

			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
				generalMap.put("currentDate", currentDate);
			}

			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String currentTime = request.getParameter(CHANGED_TIME);
				generalMap.put("currentTime", currentTime);
			}

			map = trainingHandlerService.deleteTrainingType(generalMap);
			String jsp=TRAINING_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		public ModelAndView searchTrainingType(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			String trainingTypeCode = "";
			if(request.getParameter(TRAINING_TYPE_CODE) != null && !(request.getParameter(TRAINING_TYPE_CODE).equals(""))){
				trainingTypeCode = request.getParameter(TRAINING_TYPE_CODE);
			}
			String trainingTypeName = "";
			if(request.getParameter(TRAINING_TYPE_NAME) != null && !(request.getParameter(TRAINING_TYPE_NAME).equals(""))){
				trainingTypeName = request.getParameter(TRAINING_TYPE_NAME);
			}
			int searchRadio=1;
			String searchField= "";
			try{
				if(request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))){
					searchField = request.getParameter(SEARCH_FIELD);			}

				if(request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))){
					searchRadio =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ;			}
			}catch (Exception e) {
				e.printStackTrace();
			}

			if(searchRadio==1){
				trainingTypeCode=searchField;
				trainingTypeName=null;

			}else{
				trainingTypeCode=null;
				trainingTypeName=searchField;
			}
			map = trainingHandlerService.searchTrainingType(trainingTypeCode,trainingTypeName);
			String jsp=TRAINING_TYPE_MASTER_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("search", "search");
			return new ModelAndView("index","map",map);

		}

		public ModelAndView showTrainingEffectivnessJsp(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			generalMap.put("users", users);
			map = trainingHandlerService.showTrainingEffectivnessJsp(generalMap);
			String jsp = HR_TRAINING_EFFECTIVNESS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView saveTrainingEffectivness(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HrTrainingEffective trainingEffective = new HrTrainingEffective();

			HttpSession session = request.getSession();
			int hospitalId =0;
			if (session.getAttribute("hospitalId")!= null) {
				hospitalId = (Integer)session.getAttribute("hospitalId");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				trainingEffective.setCompany(masHospital);
			}
			if (request.getParameter(EVALUATION_DATE)!= null) {
				Date evaluationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(EVALUATION_DATE));
				trainingEffective.setEvaluationDate(evaluationDate);
			}
		
			if (request.getParameter(HELD_ON_DATE)!= null) {
				Date heldOnDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HELD_ON_DATE));
				trainingEffective.setHeldOnDate(heldOnDate);
			}
			if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null) {
				int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				trainingEffective.setEmployee(masEmployee);
			}
			if (request.getParameter(INSTITUTE_ID)!= null) {
				int instituteId = Integer.parseInt(request.getParameter(INSTITUTE_ID));
				HrMasInstitute hrMasInstitute = new HrMasInstitute();
				hrMasInstitute.setId(instituteId);
				trainingEffective.setInstitute(hrMasInstitute);
			}
			if (request.getParameter(COURSE_ID)!= null) {
				int courseId = Integer.parseInt(request.getParameter(COURSE_ID));
				HrMasCourse hrMasCourse = new HrMasCourse();
				hrMasCourse.setId(courseId);
				trainingEffective.setCourse(hrMasCourse);
			}
			if (request.getParameter(INSTRUCTOR_ID)!= null) {
				int instructorId = Integer.parseInt(request.getParameter(INSTRUCTOR_ID));
				HrMasInstructor hrMasInstructor = new HrMasInstructor();
				hrMasInstructor.setId(instructorId);
				trainingEffective.setInstructor(hrMasInstructor);
			}
			if (! request.getParameter(COURSE_EXPLAIN_A).equals("0")) {
				String courseExplainA = request.getParameter(COURSE_EXPLAIN_A);
				trainingEffective.setCourseExplaina(courseExplainA);
			}
			if (! request.getParameter(COURSE_EXPLAIN_B).equals("0")) {
				String courseExplainB = request.getParameter(COURSE_EXPLAIN_B);
				trainingEffective.setCourseExplainb(courseExplainB);
			}
			if (! request.getParameter(COURSE_MATERIAL).equals("0")) {
				String courseMaterial = request.getParameter(COURSE_MATERIAL);
				trainingEffective.setCourseMaterial(courseMaterial);
			}
			if (! request.getParameter(REVIEW_A).equals("0")) {
				int reviewA = Integer.parseInt(request.getParameter(REVIEW_A));
				trainingEffective.setReviewA(reviewA);
			}
			if (! request.getParameter(REVIEW_B).equals("0")) {
				int reviewB = Integer.parseInt(request.getParameter(REVIEW_B));
				trainingEffective.setReviewB(reviewB);
			}
			if (! request.getParameter(REVIEW_C).equals("0")) {
				int reviewC = Integer.parseInt(request.getParameter(REVIEW_C));
				trainingEffective.setReviewC(reviewC);
			}
			if (! request.getParameter(REVIEW_D).equals("0")) {
				int reviewD = Integer.parseInt(request.getParameter(REVIEW_D));
				trainingEffective.setReviewD(reviewD);
			}
			if (request.getParameter(AVERAGE_POINTS)!= null) {
				int averagePoints = Integer.parseInt(request.getParameter(AVERAGE_POINTS));
				trainingEffective.setAveragePoints(averagePoints);
			}
			if (request.getParameter(REMARKS)!= null) {
				String remarks = request.getParameter(REMARKS);
				trainingEffective.setRemarks(remarks);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				trainingEffective.setLastChgBy(changedBy);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				Date changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
				trainingEffective.setLastChgDate(changedDate);
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String changedTime = request.getParameter(CHANGED_TIME);
				trainingEffective.setLastChgTime(changedTime);
			}
			trainingEffective.setStatus("y");
			map = trainingHandlerService.saveTrainingEffectivness(trainingEffective);
			String jsp = HR_TRAINING_EFFECTIVNESS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView editTrainingEffectivness(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			if (request.getParameter(TRAINING_EFFECTIVNESS_ID)!= null) {
				int trainingEffectivnessId = Integer.parseInt(request.getParameter(TRAINING_EFFECTIVNESS_ID));
				generalMap.put("trainingEffectivnessId", trainingEffectivnessId);
			}
			if (request.getParameter(EVALUATION_DATE)!= null) {
				Date evaluationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(EVALUATION_DATE));
				generalMap.put("evaluationDate", evaluationDate);
			}
			if (request.getParameter(HELD_ON_DATE)!= null) {
				Date heldOnDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(HELD_ON_DATE));
				generalMap.put("heldOnDate", heldOnDate);
			}
			if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null) {
				int employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
				generalMap.put("employeeId", employeeId);
			}
			if (request.getParameter(INSTITUTE_ID)!= null) {
				int instituteId = Integer.parseInt(request.getParameter(INSTITUTE_ID));
				generalMap.put("instituteId", instituteId);
			}
			if (request.getParameter(COURSE_ID)!= null) {
				int courseId = Integer.parseInt(request.getParameter(COURSE_ID));
				generalMap.put("courseId", courseId);
			}
			if (request.getParameter(INSTRUCTOR_ID)!= null) {
				int instructorId = Integer.parseInt(request.getParameter(INSTRUCTOR_ID));
				generalMap.put("instructorId", instructorId);
			}
			if (! request.getParameter(COURSE_EXPLAIN_A).equals("0")) {
				String courseExplainA = request.getParameter(COURSE_EXPLAIN_A);
				generalMap.put("courseExplainA", courseExplainA);
			}
			if (! request.getParameter(COURSE_EXPLAIN_B).equals("0")) {
				String courseExplainB = request.getParameter(COURSE_EXPLAIN_B);
				generalMap.put("courseExplainB", courseExplainB);
			}
			if (! request.getParameter(COURSE_MATERIAL).equals("0")) {
				String courseMaterial = request.getParameter(COURSE_MATERIAL);
				generalMap.put("courseMaterial", courseMaterial);
			}
			if (! request.getParameter(REVIEW_A).equals("0")) {
				int reviewA = Integer.parseInt(request.getParameter(REVIEW_A));
				generalMap.put("reviewA", reviewA);
			}
			if (! request.getParameter(REVIEW_B).equals("0")) {
				int reviewB = Integer.parseInt(request.getParameter(REVIEW_B));
				generalMap.put("reviewB", reviewB);
			}
			if (! request.getParameter(REVIEW_C).equals("0")) {
				int reviewC = Integer.parseInt(request.getParameter(REVIEW_C));
				generalMap.put("reviewC", reviewC);
			}
			if (request.getParameter(REVIEW_D).equals("0")) {
				int reviewD = Integer.parseInt(request.getParameter(REVIEW_D));
				generalMap.put("reviewD", reviewD);
			}
			if (request.getParameter(AVERAGE_POINTS)!= null) {
				int averagePoints = Integer.parseInt(request.getParameter(AVERAGE_POINTS));
				generalMap.put("averagePoints", averagePoints);
			}
			if (request.getParameter(REMARKS)!= null) {
				String remarks = request.getParameter(REMARKS);
				generalMap.put("remarks", remarks);
			}
			if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
				String changedBy = request.getParameter(CHANGED_BY);
				generalMap.put("changedBy", changedBy);
			}
			if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
				Date changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
				generalMap.put("changedDate", changedDate);
			}
			if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
				String changedTime = request.getParameter(CHANGED_TIME);
				generalMap.put("changedTime", changedTime);
			}
			map = trainingHandlerService.editTrainingEffectivness(generalMap);
			String jsp = HR_TRAINING_EFFECTIVNESS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

	 
	//End Training type Master  by  Ramdular --------------------------15/04/2011 
		
		
	// added by javed khan for Ehealth Kerala (Transfer)
		
		public ModelAndView showTransferNotificationJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			map = trainingHandlerService.showTransferNotificationJsp(parameterMap);
			String jsp="transferNotification";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		
		public ModelAndView saveTransferNotification(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			int id =0;
			if (request.getParameter(COMMON_ID)!= null && ! request.getParameter(COMMON_ID).equals("")) {
				 id = Integer.parseInt(request.getParameter(COMMON_ID));
			
			}
			if(request.getParameter("Notification_Date") != null && !(request.getParameter("Notification_Date").equals(""))){
				String Notification_Date =request.getParameter("Notification_Date");
				parameterMap.put("Notification_Date", Notification_Date);
			}
			if (! request.getParameter("notification").equals("")) {
				String notification = request.getParameter("notification");
				parameterMap.put("notification", notification);
			}
			if(request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))){
				String fromDate =request.getParameter("fromDate");
				parameterMap.put("fromDate", fromDate);
			}
			if(request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))){
				String toDate =request.getParameter("toDate");
				parameterMap.put("toDate", toDate);
			}
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			parameterMap.put("id", id);
			boolean find =false;
			String msg="";
			find = trainingHandlerService.findNotificationNo(parameterMap);
			if(find){
			map = trainingHandlerService.saveTransferNotification(parameterMap);
			}else{
				if(id !=0){
					map = trainingHandlerService.saveTransferNotification(parameterMap);
				}else{
				map = trainingHandlerService.showTransferNotificationJsp(parameterMap);
				msg="Notification No allready Exist.";
				map.put("msg", msg);
				}
			}
			
			String jsp="transferNotification";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public ModelAndView showTransferApplicationJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			map = trainingHandlerService.showTransferApplicationJsp(parameterMap);
			String jsp="transferApplication";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveTransferApplication(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
			String notification="";
			String withInDays="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			
			
			if (request.getParameter("empid")!= null && ! request.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(request.getParameter("empid"));
				parameterMap.put("empId", empid);
			}
			if (request.getParameter("notification")!= null && ! request.getParameter("notification").equals("")) {
				 notification = request.getParameter("notification");
				
				
			}
			if (request.getParameter("withInDays")!= null && ! request.getParameter("withInDays").equals("")) {
				 withInDays = request.getParameter("withInDays");
				
			}
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			List priorityList= new ArrayList();
			List districtList= new ArrayList();
			List instList= new ArrayList();
			for(int i=1;i<=3;i++){
				if (! request.getParameter("priority"+i).equals("")) {
					String prio = request.getParameter("priority"+i);
					priorityList.add(prio);
				}
				if (! request.getParameter("district"+i).equals("")) {
					String district = request.getParameter("district"+i);
					districtList.add(district);
				}
				if (! request.getParameter("instiName"+i).equals("")) {
					String instiName = request.getParameter("instiName"+i);
					instList.add(instiName);
				}
				
			}
			
			parameterMap.put("priorityList", priorityList);
			parameterMap.put("districtList", districtList);
			parameterMap.put("instList", instList);
			parameterMap.put("notification", notification);
			parameterMap.put("withInDays", withInDays);
			map = trainingHandlerService.saveTransferApplication(parameterMap);
			
			String jsp="transferApplication";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		public ModelAndView showTransferApplicationApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			if(request.getParameter("dept")!=null && request.getParameter("dept")!=""){
				parameterMap.put("dept", Integer.parseInt(""+request.getParameter("dept")));
			}
			if(request.getParameter("desig")!=null && request.getParameter("desig")!=""){
				parameterMap.put("desig", Integer.parseInt(""+request.getParameter("desig")));
			}
			if(request.getParameter("emp")!=null && request.getParameter("emp")!=""){
				parameterMap.put("emp", Integer.parseInt(""+request.getParameter("emp")));
			}
			if(request.getParameter("cadre")!=null && request.getParameter("cadre")!=""){
				parameterMap.put("cadre", Integer.parseInt(""+request.getParameter("cadre")));
			}
			if(request.getParameter("district")!=null && request.getParameter("district")!=""){
				parameterMap.put("district", Integer.parseInt(""+request.getParameter("district")));
			}
			if(request.getParameter("currInsti")!=null && request.getParameter("currInsti")!=""){
				parameterMap.put("currInsti", Integer.parseInt(""+request.getParameter("currInsti")));
			}
			/*Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}*/
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.showTransferApplicationApprovalJsp(parameterMap);
			String jsp="transferApplicationApproval";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		
		public ModelAndView searchTransferApprovalEmployee(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			String dept="";
			String desig="";
			String emp="";
			String grade="";
			String cadre="";
			String district="";
			String currInsti="";
			if (request.getParameter("dept")!= null && ! request.getParameter("dept").equals("")) {
				dept = request.getParameter("dept");
				
			}
			if (request.getParameter("desig")!= null && ! request.getParameter("desig").equals("")) {
				desig = request.getParameter("desig");
			
			}
			if (request.getParameter("emp")!= null && ! request.getParameter("emp").equals("")) {
				emp = request.getParameter("emp");
				
			}
			
			if (request.getParameter("grade")!= null && ! request.getParameter("grade").equals("")) {
				grade = request.getParameter("grade");
				
			}
			if (request.getParameter("cadre")!= null && ! request.getParameter("cadre").equals("")) {
				cadre = request.getParameter("cadre");
			
			}
			if (request.getParameter("district")!= null && ! request.getParameter("district").equals("")) {
				district = request.getParameter("district");
				
			}
			
			
			if (request.getParameter("currInsti")!= null && ! request.getParameter("currInsti").equals("")) {
				currInsti = request.getParameter("currInsti");
				
			}
			
			/*Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}*/
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("dept", dept);
			parameterMap.put("desig", desig);
			parameterMap.put("emp", emp);
			parameterMap.put("grade", grade);
			parameterMap.put("cadre", cadre);
			parameterMap.put("district", district);
			parameterMap.put("currInsti", currInsti);
			map = trainingHandlerService.searchTransferApprovalEmployee(parameterMap);
			String jsp="transferApplicationApproval";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView viewTransferPriority(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailMap = new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int appId = 0;
			int hospitalId =0;
			
			if (session.getAttribute("locationId")!= null) {
				hospitalId = (Integer)session.getAttribute("locationId");
			}
			if (request.getParameter("appId")!= null) {
				appId = Integer.parseInt(""+request.getParameter("appId"));
			}
			detailMap.put("hospitalId", hospitalId);
			detailMap.put("appId", appId);
			map = trainingHandlerService.viewTransferPriority(detailMap);
			String jsp = "viewpostPopup";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView saveApproveOrRejectTransfer(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			int districtId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
				//requestParameters.put("hospitalId", hospitalId);
			}
			if (session.getAttribute("districtId") != null) {
				districtId = Integer.parseInt(""
						+ session.getAttribute("districtId"));
				parameterMap.put("districtId", districtId);
				//requestParameters.put("districtId", districtId);
			}
			
			int hiddenValueCharge=0;
			if (request.getParameter("hiddenValueCharge")!= null && ! request.getParameter("hiddenValueCharge").equals("")) {
				 hiddenValueCharge = Integer.parseInt(request.getParameter("hiddenValueCharge"));
				parameterMap.put("hiddenValueCharge", hiddenValueCharge);
			}
			List appList= new ArrayList();
			List rankList= new ArrayList();
			List empList= new ArrayList();
			List transfer_distList= new ArrayList();
			List transfer_instList= new ArrayList();
			List joindateList= new ArrayList();
			
			for(int i=0;i<hiddenValueCharge;i++){
				
				//System.out.println("pr>>>"+request.getParameter("priority"+i));
				String str = ""+request.getParameter("priority"+i);
				System.out.println("str--"+str);
				if(request.getParameter("priority"+i) != null){
					/*if (request.getParameter("priority"+i)!= null && ! request.getParameter("priority"+i).equals("")) {
					int priority = Integer.parseInt(request.getParameter("priority"+i));
					appList.add(priority);
				}*/

					if (request.getParameter("appId"+i)!= null && !request.getParameter("appId"+i).equals("")) {
						int appId = Integer.parseInt(request.getParameter("appId"+i));
						appList.add(appId);
					}else{
						appList.add(0);
					}
					System.out.println("appList---"+appList.size());
					if (request.getParameter("employee_id"+i)!= null && !request.getParameter("employee_id"+i).equals("")) {
						int employee_id = Integer.parseInt(request.getParameter("employee_id"+i));
						empList.add(employee_id);
					}	else{
						empList.add(0);
					}	
					System.out.println("empList---"+empList.size());
					if (request.getParameter("rank"+i)!= null && !request.getParameter("rank"+i).equals("")) {
						int rank = Integer.parseInt(request.getParameter("rank"+i));
						rankList.add(rank);
					}else{
						rankList.add(0);
					}

					if (request.getParameter("transfer_dist"+i)!= null && !request.getParameter("transfer_dist"+i).equals("")) {
						int transfer_dist = Integer.parseInt(request.getParameter("transfer_dist"+i));
						transfer_distList.add(transfer_dist);
					}else{
						transfer_distList.add(0);
					}
					if (request.getParameter("transfer_inst"+i)!= null && !request.getParameter("transfer_inst"+i).equals("")) {
						int transfer_inst= Integer.parseInt(request.getParameter("transfer_inst"+i));
						transfer_instList.add(transfer_inst);
					}else{
						transfer_instList.add(0);
					}
					System.out.println("transfer_instList---"+transfer_instList.size());
					if (request.getParameter("joindate"+i)!= null && !request.getParameter("joindate"+i).equals("")) {
						String joindate = ""+request.getParameter("joindate"+i);
						joindateList.add(joindate);
					}else{
						joindateList.add("");
					}

				}
		}
			
			
			if (request.getParameter("remark")!= null && ! request.getParameter("remark").equals("")) {
				String remark = request.getParameter("remark");
				parameterMap.put("remark", remark);
			}
			if (request.getParameter("flag")!= null && ! request.getParameter("flag").equals("")) {
				String flag = request.getParameter("flag");
				parameterMap.put("flag", flag);
			}
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			parameterMap.put("appList", appList);
			parameterMap.put("rankList", rankList);
			parameterMap.put("empList", empList);
			parameterMap.put("transfer_distList", transfer_distList);
			parameterMap.put("transfer_instList", transfer_instList);
			parameterMap.put("joindateList", joindateList);
			
			map = trainingHandlerService.saveTransferApplicationApproval(parameterMap);
			/*//Report
			requestParameters.put("SUBREPORT_DIR",
			getServletContext().getRealPath("/Reports/"));
			Map<String, Object> connectionMap = trainingHandlerService.getConnectionForReport();
			HMSUtil.generateReport("ProdeedingOfTheAdditinalDirectorOfHealth", requestParameters,
			(Connection) connectionMap.get("conn"), response,
			getServletContext());
			//End*/	
		    //String jsp="transferApplicationApproval";
		    String jsp="printApprovedEmpDetails";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		
		public ModelAndView showRelievingJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.getRelievingWaitingListJsp(parameterMap);
			String jsp="relievingWaiting";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		
		
		public ModelAndView searchWaitingReleivingListJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			String employee_name="";
			String department="";
			String designation ="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			if (request.getParameter("employee_name")!= null && ! request.getParameter("employee_name").equals("")) {
				 employee_name = request.getParameter("employee_name");
				
			}
			if (request.getParameter("department")!= null && ! request.getParameter("department").equals("")) {
				 department = request.getParameter("department");
			
			}
			if (request.getParameter("designation")!= null && ! request.getParameter("designation").equals("")) {
				 designation = request.getParameter("designation");
				
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("employee_name", employee_name);
			parameterMap.put("department", department);
			parameterMap.put("designation", designation);
			map = trainingHandlerService.searchWaitingReleivingListJsp(parameterMap);
			String jsp="relievingWaiting";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		
		public ModelAndView showEmpRelievingJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			String id="";
			if(request.getParameter("id") != null){
				id = ""+request.getParameter("id");
				
			}
			System.out.println("Mode>>>"+request.getParameter("Mode"));
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("id",id);
			map = trainingHandlerService.showEmpRelievingJsp(parameterMap);
			String jsp="transferEmpRelieving";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveEmpRelieving(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
			String mode ="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);	
			}
			
			if (request.getParameter("transferApp_id")!= null && !request.getParameter("transferApp_id").equals("")) {
				int transferApp_id = Integer.parseInt(request.getParameter("transferApp_id"));
				parameterMap.put("transferApp_id", transferApp_id);
			}
			if (request.getParameter("transferApprove_id")!= null && !request.getParameter("transferApprove_id").equals("")) {
				int transferApprove_id = Integer.parseInt(request.getParameter("transferApprove_id"));
				parameterMap.put("transferApprove_id", transferApprove_id);
			}
			
			if (request.getParameter("empid")!= null && !request.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(request.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			
			if (request.getParameter("cur_instituteId")!= null && !request.getParameter("cur_instituteId").equals("")) {
				int cur_instituteId = Integer.parseInt(request.getParameter("cur_instituteId"));
				parameterMap.put("cur_instituteId", cur_instituteId);
			}
			
			if (request.getParameter("trans_instituteId")!= null && !request.getParameter("trans_instituteId").equals("")) {
				int trans_instituteId = Integer.parseInt(request.getParameter("trans_instituteId"));
				parameterMap.put("trans_instituteId", trans_instituteId);
			}
			
			if(request.getParameter("reliving_date") != null && !(request.getParameter("reliving_date").equals(""))){
				String reliving_date =request.getParameter("reliving_date");
				parameterMap.put("reliving_date", reliving_date);
			}
			if(request.getParameter("actualRelivingDate") != null && !(request.getParameter("actualRelivingDate").equals(""))){
				String actualRelivingDate =request.getParameter("actualRelivingDate");
				parameterMap.put("actualRelivingDate", actualRelivingDate);
			}
			
			if(request.getParameter("mode_of_Retire") != null && !(request.getParameter("mode_of_Retire").equals(""))){
				String mode_of_Retire =request.getParameter("mode_of_Retire");
				parameterMap.put("mode_of_Retire", mode_of_Retire);
			}
			
			System.out.println("  releiving_sesson  "+request.getParameter("session"));
			
			if(request.getParameter("session") != null && !(request.getParameter("session").equals(""))){
				String releiving_sesson =request.getParameter("session");
				System.out.println(releiving_sesson+"  releiving_sesson  "+request.getParameter("session"));
				parameterMap.put("releiving_sesson", releiving_sesson);
			}
			if(request.getParameter("remarks") != null && !(request.getParameter("remarks").equals(""))){
				String remarks =request.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			
			
			if(request.getParameter("mode") != null && !(request.getParameter("mode").equals(""))){
				 mode =request.getParameter("mode");
				parameterMap.put("mode", mode);
			}
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			map = trainingHandlerService.saveEmpRelieving(parameterMap);
			String jsp="";
			//if(mode.equalsIgnoreCase("Transfer"))
				 jsp="relievingWaiting";
			//else
				// jsp="relievingWaitingForSuspAndTermin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public ModelAndView showJoiningListJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.getJoiningWaitingListJsp(parameterMap);
			String jsp="joiningWaiting";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView showEmpjoiningJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			String id="";
			if(request.getParameter("id") != null){
				id = ""+request.getParameter("id");
				
			}
			String mode="";
			if(request.getParameter("mode") != null){
				mode = ""+request.getParameter("mode");
				
			}
		System.out.println("mode"+mode);
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("id",id);
			parameterMap.put("mode",mode);
			map = trainingHandlerService.showEmpjoiningJsp(parameterMap);
			String jsp="transferEmpJoining.jsp";
			//jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveEmpJoining(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			if (request.getParameter("transferApp_id")!= null && !request.getParameter("transferApp_id").equals("")) {
				int transferApp_id = Integer.parseInt(request.getParameter("transferApp_id"));
				parameterMap.put("transferApp_id", transferApp_id);
			}
			
			if (request.getParameter("transferApprove_id")!= null && !request.getParameter("transferApprove_id").equals("")) {
				int transferApprove_id = Integer.parseInt(request.getParameter("transferApprove_id"));
				parameterMap.put("transferApprove_id", transferApprove_id);
			}
			
			if (request.getParameter("empid")!= null && !request.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(request.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			
			if (request.getParameter("instituteId")!= null && !request.getParameter("instituteId").equals("")) {
				int instituteId = Integer.parseInt(request.getParameter("instituteId"));
				parameterMap.put("instituteId", instituteId);
			}
			
			if (request.getParameter("from_instituteId")!= null && !request.getParameter("from_instituteId").equals("")) {
				int from_instituteId = Integer.parseInt(request.getParameter("from_instituteId"));
				parameterMap.put("from_instituteId", from_instituteId);
			}
			
			if(request.getParameter("joining_date") != null && !(request.getParameter("joining_date").equals(""))){
				String joining_date =request.getParameter("joining_date");
				parameterMap.put("joining_date", joining_date);
			}
			if(request.getParameter("actualJoiningDate") != null && !(request.getParameter("actualJoiningDate").equals(""))){
				String actualJoiningDate =request.getParameter("actualJoiningDate");
				parameterMap.put("actualJoiningDate", actualJoiningDate);
			}
			
			if(request.getParameter("joining_time") != null && !(request.getParameter("joining_time").equals(""))){
				String joining_time =request.getParameter("joining_time");
				parameterMap.put("joining_time", joining_time);
			}
			if(request.getParameter("session") != null && !(request.getParameter("session").equals(""))){
				String sesson =request.getParameter("session");
				parameterMap.put("session", sesson);
			}
			if(request.getParameter("remarks") != null && !(request.getParameter("remarks").equals(""))){
				String remarks =request.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			if(request.getParameter("mode") != null && !(request.getParameter("mode").equals(""))){
				String mode =request.getParameter("mode");
				parameterMap.put("mode", mode);
			}
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			map = trainingHandlerService.saveEmpJoining(parameterMap);
		
			
			String jsp="joiningWaiting";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public ModelAndView showDeputationJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.getRelievingWaitingListJsp(parameterMap);
			String jsp="employeeDeputation";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveEmpDeputaion(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			Date currentDate = new Date();
			String fileName = null;
			String fileExtension = null;
			
			MultipartFormDataRequest mrequest = null;
			if (MultipartFormDataRequest.isMultipartFormData(request)) 
			   {
					try 
					{
						mrequest = new MultipartFormDataRequest(request);
					} 
					catch (UploadException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
			   }
			
			
			
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			if (mrequest.getParameter("empid")!= null && !mrequest.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(mrequest.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			if (mrequest.getParameter("designationId")!= null && !mrequest.getParameter("designationId").equals("")) {
				int cur_designationId = Integer.parseInt(mrequest.getParameter("designationId"));
				parameterMap.put("cur_designationId", cur_designationId);
			}
			if (mrequest.getParameter("departmentId")!= null && !mrequest.getParameter("departmentId").equals("")) {
				int cur_departmentId = Integer.parseInt(mrequest.getParameter("departmentId"));
				parameterMap.put("cur_departmentId", cur_departmentId);
			}
			if (mrequest.getParameter("cur_instituteId")!= null && !mrequest.getParameter("cur_instituteId").equals("")) {
				int cur_instituteId = Integer.parseInt(mrequest.getParameter("cur_instituteId"));
				parameterMap.put("cur_instituteId", cur_instituteId);
			}
			
			if (mrequest.getParameter("othersName")!= null && !mrequest.getParameter("othersName").equals("")) {
				String others = mrequest.getParameter("othersName");
				parameterMap.put("others", others);
			}
			
			
			/*if (request.getParameter("cur_instituteId")!= null && !request.getParameter("cur_instituteId").equals("")) {
				int cur_instituteId = Integer.parseInt(request.getParameter("cur_instituteId"));
				parameterMap.put("cur_instituteId", cur_instituteId);
			}*/
			
			 if (mrequest.getParameter("depute_instituteId")!= null && !mrequest.getParameter("depute_instituteId").equals("")) {
				int depute_instituteId = Integer.parseInt(mrequest.getParameter("depute_instituteId"));
				parameterMap.put("depute_instituteId", depute_instituteId);
				
			} 
			 
			
			
			/*if(request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))){
				String fromDate =request.getParameter("fromDate");
				parameterMap.put("fromDate", fromDate);
				System.out.println("fromDatein cont>>"+fromDate);
			}
			if(request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))){
				String toDate =request.getParameter("toDate");
				parameterMap.put("toDate", toDate);
			}*/
			
			
			if(mrequest.getParameter("remarks") != null && !(mrequest.getParameter("remarks").equals(""))){
				String remarks =mrequest.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			 
			if(mrequest.getParameter("deputePeriod") != null && !(mrequest.getParameter("deputePeriod").equals(""))){
				String deputePeriod =mrequest.getParameter("deputePeriod");
				parameterMap.put("deputePeriod", deputePeriod);
			}
			if(mrequest.getParameter("deputePeriodUnit") != null && !(mrequest.getParameter("deputePeriodUnit").equals(""))){
				String deputePeriodUnit =mrequest.getParameter("deputePeriodUnit");
				parameterMap.put("deputePeriodUnit", deputePeriodUnit);
			}
			
			if(mrequest.getParameter("orderDate") != null && !(mrequest.getParameter("orderDate").equals(""))){
				String orderDate =mrequest.getParameter("orderDate");
				parameterMap.put("orderDate", orderDate);
			}
			if(mrequest.getParameter("order_no") != null && !(mrequest.getParameter("order_no").equals(""))){
				String order_no =mrequest.getParameter("order_no");
				parameterMap.put("order_no", order_no);
			}
			
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			
			if (mrequest.getParameter(CHANGED_DATE) != null
					&& !(mrequest.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter(CHANGED_DATE));
				parameterMap.put("currentDate", currentDate);
			}

			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome.substring(0,
					userHome.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;

			System.out.println("upload url is == ++++" + uploadURL);

			HMSUtil.createFolderFroDocument("hrms", uploadURL);
			List fileUploadedList = null;
			/*
			 * int uploadCount =
			 * Integer.parseInt(mrequest.getParameter("uploadCount"));
			 */
			/* box.put("uploadCount", uploadCount); */
			Hashtable files = mrequest.getFiles();

			int i = 1;
			/* for (i = 1; i <= uploadCount; i++) { */
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			if (file != null && file.getFileName() != null) // && fileSize <= //
															// 2097152 )
			{

				String fileName1 = file.getFileName();

				StringTokenizer strToken = new StringTokenizer(fileName1, ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ "hrms" + fileSeparator, whiteList, fileName1);
				parameterMap.put("filename", fileName1);
				parameterMap.put("fileExtension", fileExtension);
				parameterMap.put("uploadURL", uploadURL);
				parameterMap.put("fileSeparator", fileSeparator);
			} else {
				parameterMap.put("filename", "0");
			}
			
			
			/*String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome.substring(0,
					userHome.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;

			System.out.println("upload url is == ++++" + uploadURL);

			HMSUtil.createFolderFroDocument("hrms", uploadURL);
			String fileExtension=null;
			//String uploadURL = getServletContext().getRealPath("/Attendance/");
			//String uploadURL = getServletContext().getRealPath("/");
		//	System.out.println(">>>1000>>"+uploadURL);
			
			List fileUploadedList = null;
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			
				if(request.getParameter("filename")!= null){
					filename = request.getParameter("filename");
				}
			
				parameterMap.put("filename", filename);
			   String filename = file.getFileName();
				StringTokenizer strToken=new StringTokenizer(filename,".");
				Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
				filename=strToken.nextToken();
			   	fileExtension=strToken.nextToken();
			   	String whiteList = "."+fileExtension;
			  	System.out.println("jk>>>>"+uploadURL);
			   	System.out.println("whiteList>>>>"+whiteList);
			   	System.out.println("filename>>>>"+filename);
			
			   	//fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
			   	fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ "hrms" + fileSeparator, whiteList, filename);
				
				String comments = "";
				
				int request_id = 0;
				if(mrequest.getParameter("request_id")!= null){
					request_id = Integer.parseInt(mrequest.getParameter("request_id"));
					System.out.println(">>"+request_id);
					parameterMap.put("request_id", request_id);
				}
				int employeeId = 0;
				if(mrequest.getParameter(EMPLOYEE_ID)!= null){
					employeeId = Integer.parseInt(mrequest.getParameter(EMPLOYEE_ID));
					parameterMap.put("employeeId", employeeId);
				}
				parameterMap.put("uploadURL", uploadURL);*/
				
				
			
			map = trainingHandlerService.saveEmpDeputaion(parameterMap);
			map.putAll(trainingHandlerService.getRelievingWaitingListJsp(parameterMap));
			String jsp="employeeDeputation";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		
		public ModelAndView showSuspentionJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			String empId ="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			if(request.getParameter("empid") != null && !(request.getParameter("empid").equals(""))){
				 empId =request.getParameter("empid");
			
			}
			
			parameterMap.put("empId",  empId);
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.showSuspentionJsp(parameterMap);
			String jsp="employeeSuspetion.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView  getSuspendByList(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			Map parameterMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			System.out.println("getSessForShift");
			int hospitalId = 0;
			
			String empId="";
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				//hospital.setId(hospitalId);
			}
		
			if(request.getParameter("empid") != null && !(request.getParameter("empid").equals(""))){
				 empId =request.getParameter("empid");
			
			}
		
			parameterMap.put("empId", empId);
			parameterMap.put("hospitalId", hospitalId);
			
			//map1 = attendanceHandlerService.searchDutyScheduleEmployee(parameterMap);
			map = trainingHandlerService.getSuspendByList(parameterMap);
			String jsp = "responseSuspensionList";
			
			
			System.out.println("return");
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView saveEmpSuspention(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			MultipartFormDataRequest mrequest = null;
			
			if (MultipartFormDataRequest.isMultipartFormData(request)) 
			   {
					try 
					{
						mrequest = new MultipartFormDataRequest(request);
					} 
					catch (UploadException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
			   }
			 
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			if (mrequest.getParameter("instituteId")!= null && !mrequest.getParameter("instituteId").equals("")) {
				int instituteId = Integer.parseInt(mrequest.getParameter("instituteId"));
				parameterMap.put("instituteId", instituteId);
			}
			
			if (mrequest.getParameter("suspendBy")!= null && !mrequest.getParameter("suspendBy").equals("")) {
				int suspendBy = Integer.parseInt(mrequest.getParameter("suspendBy"));
				parameterMap.put("suspendBy", suspendBy);
			}
		    if(mrequest.getParameter("fromDate") != null && !(mrequest.getParameter("fromDate").equals(""))){
				Date fromDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter("fromDate"));
				parameterMap.put("fromDate", fromDate);
			}
			if(mrequest.getParameter("toDate") != null && !(mrequest.getParameter("toDate").equals(""))){
				Date toDate =HMSUtil.dateFormatterDDMMYYYY(mrequest.getParameter("toDate"));
				parameterMap.put("toDate", toDate);
			} 
			if(mrequest.getParameter("remarks") != null && !(mrequest.getParameter("remarks").equals(""))){
				String remarks =mrequest.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			 
			if (mrequest.getParameter("empid")!= null && !mrequest.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(mrequest.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			if(mrequest.getParameter("suspPeriod") != null && !(mrequest.getParameter("suspPeriod").equals(""))){
				String suspPeriod =mrequest.getParameter("suspPeriod");
				parameterMap.put("suspPeriod", suspPeriod);
			}
			if(mrequest.getParameter("suspPeriodUnit") != null && !(mrequest.getParameter("suspPeriodUnit").equals(""))){
				String suspPeriodUnit =mrequest.getParameter("suspPeriodUnit");
				parameterMap.put("suspPeriodUnit", suspPeriodUnit);
			}
			
			String mode="";
			if(mrequest.getParameter("mode") != null && !(mrequest.getParameter("mode").equals(""))){
				 mode =mrequest.getParameter("mode");
				parameterMap.put("mode", mode);
			}
			
			if(mrequest.getParameter("reason") != null && !(mrequest.getParameter("reason").equals(""))){
				String reason =mrequest.getParameter("reason");
				parameterMap.put("reason", reason);
			}
			
			if(mrequest.getParameter("orderDate") != null && !(mrequest.getParameter("orderDate").equals(""))){
				String orderDate =mrequest.getParameter("orderDate");
				parameterMap.put("orderDate", orderDate);
			}
			if(mrequest.getParameter("order_no") != null && !(mrequest.getParameter("order_no").equals(""))){
				String order_no =mrequest.getParameter("order_no");
				parameterMap.put("order_no", order_no);
			}
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(mrequest.getParameter("CHANGED_DATE") != null && !(mrequest.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =mrequest.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(mrequest.getParameter("CHANGED_TIME") != null && !(mrequest.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = mrequest.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			String fileName = null;
			String fileExtension = null;
			
			
			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome.substring(0,
					userHome.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;

			System.out.println("upload url is == ++++" + uploadURL);

			HMSUtil.createFolderFroDocument("hrms", uploadURL);
			List fileUploadedList = null;
			/*
			 * int uploadCount =
			 * Integer.parseInt(mrequest.getParameter("uploadCount"));
			 */
			/* box.put("uploadCount", uploadCount); */
			Hashtable files = mrequest.getFiles();

			int i = 1;
			/* for (i = 1; i <= uploadCount; i++) { */
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			if (file != null && file.getFileName() != null) // && fileSize <= //
															// 2097152 )
			{

				String fileName1 = file.getFileName();

				StringTokenizer strToken = new StringTokenizer(fileName1, ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ "hrms" + fileSeparator, whiteList, fileName1);
				
				
				parameterMap.put("filename", fileName1);
				parameterMap.put("fileExtension", fileExtension);
				parameterMap.put("uploadURL", uploadURL);
				parameterMap.put("fileSeparator", fileSeparator);
				//parameterMap.put("whiteList", whiteList);
				
			} else {
				parameterMap.put("filename", "0");
			}
			
			map = trainingHandlerService.saveEmpSuspention(parameterMap);
			
			String jsp="";
			if(mode.equals("Suspension")){
			 jsp="employeeSuspetion";
			}else{
				jsp="employeeTermination";
			}
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public void getEmpInfoForEmpSuspension(HttpServletRequest request,HttpServletResponse response) throws ParseException {
				
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			String PEN = "";
			int hospitalId=0;
			Date expirydate = new Date();
			List<MasEmployee> emplList = new ArrayList<MasEmployee>();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			
			}
			if (request.getParameter("PEN") != null) {
				PEN = "" + request.getParameter("PEN");
			}
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("PEN", PEN);
			
				map = trainingHandlerService.getEmpInfoForEmpSuspension(parameterMap);;
				
				emplList = (List<MasEmployee>)map.get("emplList");
			
				
				
			StringBuffer sb = new StringBuffer();
			try {
				if(emplList.size()>0){
					System.out.println(""+emplList.get(0).getId());
				sb.append("<item>");
				if(emplList.get(0).getEmployeeName() != null)
				{
				sb.append("<empName>" + emplList.get(0).getEmployeeName() + "</empName>");
				}else{
					sb.append("<empName>"+ "</empName>");
				}
				sb.append("<empId>" + emplList.get(0).getId() + "</empId>");
				sb.append("<desig>" + emplList.get(0).getRank().getRankName() + "</desig>");
				sb.append("<desigId>" + emplList.get(0).getRank().getId() + "</desigId>");
//				sb.append("<depart>" + emplList.get(0).getDepartment().getDepartmentName() + "</depart>");
//				sb.append("<departId>" + emplList.get(0).getDepartment().getId() + "</departId>");
				sb.append("<depart>" + emplList.get(0).getEmployeeDepartment().getEmpDeptName() + "</depart>");
				sb.append("<departId>" + emplList.get(0).getEmployeeDepartment().getId() + "</departId>");
				sb.append("<insti>" + emplList.get(0).getHospital().getHospitalName() + "</insti>");
				sb.append("<instiId>" + emplList.get(0).getHospital().getId() + "</instiId>");
				if(emplList.get(0).getEmployeeStatus() != null)
				sb.append("<status>" + emplList.get(0).getEmployeeStatus().getEmpStatusName() + "</status>");
				else
					sb.append("<status> </status>");
				sb.append("</item>");
				}
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(sb);
		}
		
		
		public ModelAndView showTerminationJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.getRelievingWaitingListJsp(parameterMap);
			String jsp="employeeTermination.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveEmpTermination(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
                MultipartFormDataRequest mrequest = null;
			
			if (MultipartFormDataRequest.isMultipartFormData(request)) 
			   {
					try 
					{
						mrequest = new MultipartFormDataRequest(request);
					} 
					catch (UploadException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
			   }
			
			
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			if (mrequest.getParameter("empid")!= null && !mrequest.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(mrequest.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			
			if (mrequest.getParameter("instituteId")!= null && !mrequest.getParameter("instituteId").equals("")) {
				int instituteId = Integer.parseInt(mrequest.getParameter("instituteId"));
				parameterMap.put("instituteId", instituteId);
			}
			
			if (mrequest.getParameter("suspendBy")!= null && !mrequest.getParameter("suspendBy").equals("")) {
				int suspendBy = Integer.parseInt(mrequest.getParameter("suspendBy"));
				parameterMap.put("suspendBy", suspendBy);
			}
			if(mrequest.getParameter("fromDate") != null && !(mrequest.getParameter("fromDate").equals(""))){
				String fromDate =mrequest.getParameter("fromDate");
				parameterMap.put("fromDate", fromDate);
			}
			
			if(mrequest.getParameter("remarks") != null && !(mrequest.getParameter("remarks").equals(""))){
				String remarks =mrequest.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			
			if(mrequest.getParameter("reason") != null && !(mrequest.getParameter("reason").equals(""))){
				String reason =mrequest.getParameter("reason");
				parameterMap.put("reason", reason);
			}
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(mrequest.getParameter("CHANGED_DATE") != null && !(mrequest.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =mrequest.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(mrequest.getParameter("CHANGED_TIME") != null && !(mrequest.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = mrequest.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			if(mrequest.getParameter("orderDate") != null && !(mrequest.getParameter("orderDate").equals(""))){
				String orderDate = mrequest.getParameter("orderDate");
				parameterMap.put("orderDate", orderDate);
			}
			if(mrequest.getParameter("fromDate") != null && !(mrequest.getParameter("fromDate").equals(""))){
				String fromDate = mrequest.getParameter("fromDate");
				parameterMap.put("fromDate", fromDate);
			}
			
			String fileName = null;
			String fileExtension = null;
			
			
			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome.substring(0,
					userHome.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;

			System.out.println("upload url is == ++++" + uploadURL);

			HMSUtil.createFolderFroDocument("hrms", uploadURL);
			List fileUploadedList = null;
			/*
			 * int uploadCount =
			 * Integer.parseInt(mrequest.getParameter("uploadCount"));
			 */
			/* box.put("uploadCount", uploadCount); */
			Hashtable files = mrequest.getFiles();

			int i = 1;
			/* for (i = 1; i <= uploadCount; i++) { */
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			if (file != null && file.getFileName() != null) // && fileSize <= //
															// 2097152 )
			{

				String fileName1 = file.getFileName();

				StringTokenizer strToken = new StringTokenizer(fileName1, ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ "hrms" + fileSeparator, whiteList, fileName1);
				
				
				parameterMap.put("filename", fileName1);
				parameterMap.put("fileExtension", fileExtension);
				parameterMap.put("uploadURL", uploadURL);
				parameterMap.put("fileSeparator", fileSeparator);
				//parameterMap.put("whiteList", whiteList);
				
			} else {
				parameterMap.put("filename", "0");
			}
			
			
			map = trainingHandlerService.saveEmpTermination(parameterMap);
			
			String jsp="employeeTermination";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public ModelAndView showWaitingForSuspenTermi(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			map = trainingHandlerService.getRelievingWaitingListForSuspaAndTermin(parameterMap);
			String jsp="relievingWaitingForSuspAndTermin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView searchWaitingForSuspenTermi(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			String employee_name="";
			String department="";
			String designation ="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			if (request.getParameter("employee_name")!= null && ! request.getParameter("employee_name").equals("")) {
				 employee_name = request.getParameter("employee_name");
				
			}
			if (request.getParameter("department")!= null && ! request.getParameter("department").equals("")) {
				 department = request.getParameter("department");
			
			}
			if (request.getParameter("designation")!= null && ! request.getParameter("designation").equals("")) {
				 designation = request.getParameter("designation");
				
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("employee_name", employee_name);
			parameterMap.put("department", department);
			parameterMap.put("designation", designation);
			map = trainingHandlerService.searchWaitingForSuspenTermi(parameterMap);
			String jsp="relievingWaitingForSuspAndTermin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView showEmpRelievingTerminAndSusp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			String id="";
			if(request.getParameter("id") != null){
				id = ""+request.getParameter("id");
				
			}
			
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			parameterMap.put("id",id);
			map = trainingHandlerService.showEmpRelievingTerminAndSusp(parameterMap);
			String jsp="transferEmpRelieving";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}

		public ModelAndView showEmpDeathJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			parameterMap.put("hospitalId", hospitalId);
			
			map = trainingHandlerService.getRelievingWaitingListJsp(parameterMap);
			String jsp="employeeDeath.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		public ModelAndView saveEmpDeath(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				parameterMap.put("hospitalId", hospitalId);
			}
			
			if (request.getParameter("empid")!= null && !request.getParameter("empid").equals("")) {
				int empid = Integer.parseInt(request.getParameter("empid"));
				parameterMap.put("empid", empid);
			}
			
			if (request.getParameter("cur_instituteId")!= null && !request.getParameter("cur_instituteId").equals("")) {
				int instituteId = Integer.parseInt(request.getParameter("cur_instituteId"));
				parameterMap.put("instituteId", instituteId);
			}
			

			
			
			if(request.getParameter("deathDate") != null && !(request.getParameter("deathDate").equals(""))){
				String deathDate =request.getParameter("deathDate");
				parameterMap.put("deathDate", deathDate);
			}
			
			if(request.getParameter("remarks") != null && !(request.getParameter("remarks").equals(""))){
				String remarks =request.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			
			/*if(request.getParameter("onDuty") != null && !(request.getParameter("onDuty").equals(""))){
				String onDuty =request.getParameter("onDuty");
				parameterMap.put("onDuty", onDuty);
			}*/
			
			if(request.getParameter("selectedRadio") != null && !(request.getParameter("selectedRadio").equals(""))){
				String selectedRadio =request.getParameter("selectedRadio");
				parameterMap.put("onDuty", selectedRadio);
			}
			
			if(session.getAttribute("users") != null){
				Users changedBy = (Users)session.getAttribute("users");
				parameterMap.put("changedBy", changedBy);
			}
			if(request.getParameter("CHANGED_DATE") != null && !(request.getParameter("CHANGED_DATE").equals(""))){
				String changedDate =request.getParameter("CHANGED_DATE");
				parameterMap.put("changedDate", changedDate);
			}
			if(request.getParameter("CHANGED_TIME") != null && !(request.getParameter("CHANGED_TIME").equals(""))){
				String changedTime = request.getParameter("CHANGED_TIME");
				parameterMap.put("changedTime", changedTime);
			}
			
			map = trainingHandlerService.saveEmpDeath(parameterMap);
			
			String jsp="employeeDeath";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		
		}
		
		public ModelAndView displaySubmitAttachment(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			int RequestId = 0;
			String mode = "";
			if(request.getParameter("Id")!= null){
				RequestId = Integer.parseInt(request.getParameter("Id"));
			}
			if(request.getParameter("mode")!= null){
				mode = ""+request.getParameter("mode");
			}
		//	System.out.println("RequestId>>7579>>>"+RequestId);
			parameterMap.put("RequestId", RequestId);
			parameterMap.put("mode", mode);
			map = trainingHandlerService.displaySubmitAttachment(parameterMap);
			String jsp = "hr_joining_attachDocumentPopup";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView addAttachFile(HttpServletRequest request ,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			MultipartFormDataRequest mrequest = null;
			if (MultipartFormDataRequest.isMultipartFormData(request)) 
			   {
					try 
					{
						mrequest = new MultipartFormDataRequest(request);
					} 
					catch (UploadException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
			   }
			String fileExtension=null;
			//String uploadURL = getServletContext().getRealPath("/Attendance/");
			String uploadURL = getServletContext().getRealPath("/");
		//	System.out.println(">>>1000>>"+uploadURL);
			String filename = "";
			List fileUploadedList = null;
				if(request.getParameter("filename")!= null){
					filename = request.getParameter("filename");
				}
				generalMap.put("filename", filename);
				StringTokenizer strToken=new StringTokenizer(filename,".");
				Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
				filename=strToken.nextToken();
			   	fileExtension=strToken.nextToken();
			   	String whiteList = "*."+fileExtension;
			   /*	System.out.println("jk>>>>"+uploadURL);
			   	System.out.println("whiteList>>>>"+whiteList);
			   	System.out.println("filename>>>>"+filename);*/
			
			   	//fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
			   	fileUploadedList = HMSUtil.uploadFile1(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
				
				String comments = "";
				if( mrequest.getParameter("comments")!= null){
					comments = mrequest.getParameter("comments");
					generalMap.put("comments", comments);
				}
				int request_id = 0;
				if(mrequest.getParameter("request_id")!= null){
					request_id = Integer.parseInt(mrequest.getParameter("request_id"));
					System.out.println(">>"+request_id);
					generalMap.put("request_id", request_id);
				}
				int employeeId = 0;
				if(mrequest.getParameter(EMPLOYEE_ID)!= null){
					employeeId = Integer.parseInt(mrequest.getParameter(EMPLOYEE_ID));
					generalMap.put("employeeId", employeeId);
				}
				generalMap.put("uploadURL", uploadURL);
				
			map = trainingHandlerService.addAttachFile(generalMap);
							
			String jsp = "hr_joining_attachDocumentPopup";
			String msg="File Successfuly Uploaded.";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);
			map.put("message", msg);
			
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView showContractEmployeeJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map =new HashMap<String, Object>();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
			}
			parameterMap.put("empId", users.getEmployee().getId());
			map = trainingHandlerService.showTransferNotificationJsp(parameterMap);
			String jsp="employeeContractJsp.jsp";
			//jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);

		}
		
		
		public ModelAndView searchEmployeeContract(HttpServletRequest request,
				HttpServletResponse response) {

			String instructorCode = "";
			String instructorName = "";
			String searchField = "";
			int searchId = 1;
			Map<String, Object> generalMap = new HashMap<String, Object>();

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				instructorCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				instructorName = request.getParameter(SEARCH_NAME);
			}

			try {
				if (request.getParameter(SEARCH_FIELD) != null
						&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
				}
				if (request.getParameter(SELECTED_RADIO) != null
						&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchId = Integer.parseInt(request
							.getParameter(SELECTED_RADIO));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (searchId == 1) {
				instructorCode = searchField;
				instructorName = null;
			} else {
				instructorName = searchField;
				instructorCode = null;
			}

			map = trainingHandlerService.searchEmployeeContract(instructorCode,
					instructorName);

			String jsp="employeeContractJsp.jsp";
			title = "Employee Contract";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);

		}
		
		public ModelAndView saveContractEmployee(HttpServletRequest request,
				HttpServletResponse response){
			Map<String, Object> parameterMap= new HashMap<String, Object>();
			Map<String, Object> map= new HashMap<String, Object>();
			if(request.getParameter("agency") != null && !(request.getParameter("agency").equals(""))){
				String agency =request.getParameter("agency");
				parameterMap.put("agency", agency);
			}
			if(request.getParameter("agreementType") != null && !(request.getParameter("agreementType").equals(""))){
				String agreementType =request.getParameter("agreementType");
				parameterMap.put("agreementType", agreementType);
			}
			if(request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))){
				String agreementStartDate =request.getParameter("fromDate");
				parameterMap.put("agreementStartDate", agreementStartDate);
			}
			if(request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))){
				String agreementEndDate =request.getParameter("toDate");
				parameterMap.put("agreementEndDate", agreementEndDate);
			}
			if(request.getParameter("doc_submit") != null && !(request.getParameter("doc_submit").equals(""))){
				String doc_submit =request.getParameter("doc_submit");
				parameterMap.put("doc_submit", doc_submit);
			}
			if(request.getParameter("agreement_rules") != null && !(request.getParameter("agreement_rules").equals(""))){
				String agreement_rules =request.getParameter("doc_submit");
				parameterMap.put("agreement_rules", agreement_rules);
			}
			
			if(request.getParameter("remarks") != null && !(request.getParameter("remarks").equals(""))){
				String remarks =request.getParameter("remarks");
				parameterMap.put("remarks", remarks);
			}
			
			map = trainingHandlerService.saveContractEmployee(parameterMap);
				
			
			String jsp="employeeContractJsp.jsp";
			title = "Employee Contract";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showMeetingSchedulingJsp(HttpServletRequest request,HttpServletResponse response)
		{
		//	String meetingNo="";
			Map<String, Object> map = trainingHandlerService.showMeetingSchedulingJsp();
			//meetingNo = legalHandlerService.generateMeetingNumber(meetingNo);
			jsp = "meeting_scheduling";
			jsp += ".jsp";
			title = "Meeting Scheduling";
			map.put("contentJsp",jsp);
		//	map.put("meetingNo", meetingNo);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		 public ModelAndView getMemberListForName(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				// --------------------------------------------------------------------------------
				String itemNameField = "";
				String autoHint = "";
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("requiredField") != null) {
						itemNameField = (request.getParameter("requiredField"));
					}
					System.out.println(itemNameField+">>>>ite"+request.getParameter(itemNameField));
					if (request.getParameter(itemNameField) != null) {
						autoHint = (request.getParameter(itemNameField));
					}
					if (request.getParameter("boardId") != null) {
						dataMap.put("boardId",request.getParameter("boardId"));
					}
					if (request.getParameter("subCommitteeId") != null && !request.getParameter("subCommitteeId").equalsIgnoreCase("") ) {
						dataMap.put("subCommitteeId",request.getParameter("subCommitteeId"));
					}
					if (request.getParameter("employeeId") != null) {
						dataMap.put("employeeId",request.getParameter("employeeId"));
					}
					if (request.getParameter(itemNameField) != null) {
						autoHint = (request.getParameter(itemNameField));
					}
				
					dataMap.put("autoHint", autoHint);
					
					map = trainingHandlerService.getMemberListForMeetingByName(dataMap);
					jsp = "itemAutoCompleteForMemberName";
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
		 public void fillMemberForName(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				System.out.println("fillMemberForName");
				Map<String, Object> dataMap = new HashMap<String, Object>();
				String nameMember = "";
				try {
					if (request.getParameter("nameMember") != null) {
						nameMember = request.getParameter("nameMember");
					}
				
					
					List<MasEmployee> eList = new ArrayList<MasEmployee>();
					
					dataMap.put("nameMember", nameMember);
					map = trainingHandlerService.fillMemberForName(dataMap);
				
				/*	if (map.get("bList") != null) {
						bList = (List) map.get("bList");
					}
					
					if (map.get("sList") != null) {
						sList = (List) map.get("sList");
					}
					*/
					if (map.get("eList") != null) {
						eList = (List) map.get("eList");
					}
					StringBuffer sb = new StringBuffer();
				 if(eList.size()>0){
						for (MasEmployee e : eList) {
							sb.append("<item>");
							sb.append("<nameMember>" + e.getFirstName() + "</nameMember>");
							sb.append("<idMember>" + e.getId() + "</idMember>");
							sb.append("<hos>" + e.getHospital().getId() + "</hos>");
							sb.append("<hosName>" + e.getHospital().getHospitalName() + "</hosName>");
							sb.append("<designation>");
							if (e.getRank()!= null)
							{
								sb.append("<drt>");
								sb.append("<dName>"+e.getRank().getRankName()+ "</dName>");
								sb.append("<designationId>" + e.getRank().getId()+ "</designationId>");
								sb.append("</drt>");
							}
							else{
								sb.append("<drt>");
								sb.append("<dName>" + "NA" + "</dName>");
								sb.append("<designationId>" + "0" + "</designationId>");
								sb.append("</drt>");
							}
							sb.append("</designation>");
							sb.append("</item>");
						}
						}
					System.out.println("sb>>>>"+sb);
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");

					response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 
	public ModelAndView saveMeetingScheduling(HttpServletRequest request, HttpServletResponse response) {
				
				String successfullyAdded = "no";
				int userId =0;
				int locationId = 0;
				int departmentId =0;
				HttpSession session = request.getSession();
				session = request.getSession();
				if (session.getAttribute("userId") != null)
					userId = (Integer) session.getAttribute("userId");
				if (session.getAttribute("hospitalId") != null)
					locationId = Integer.parseInt(""
							+ session.getAttribute("hospitalId"));
				if (session.getAttribute("departmentId") != null)
					departmentId = Integer.parseInt(""+ session.getAttribute("departmentId"));
				
				Map<String, Object> dataMap = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				
				String meetingNo = "";
				String buttonName = null;
				if(request.getParameter("buttonName")!=null){
					buttonName = request.getParameter("buttonName");
				}
				int meetingId = 0;
				if (request.getParameter("meetingNo") != null) {
					meetingNo = request.getParameter("meetingNo");
				
				}
				int scheduleId=0;
				Boolean dataSaved = false;
				Box box = null;
			
				
					box = HMSUtil.getBox(request);
					meetingId = box.getInt("meetingId");
						box.put("buttonName", buttonName);
						box.put("userId", userId);
						dataMap.put("locationId", locationId);
						box.put("departmentId", departmentId);
						System.out.println(departmentId);
						dataMap.put("box", box);
						map = trainingHandlerService.saveMeetingScheduling(dataMap);
						if (map.get("successfullyAdded") != null)
							successfullyAdded = "" + map.get("successfullyAdded");
						
						if(map.get("dataSaved") != null)
						{
							 
							dataSaved =  (Boolean)map.get("dataSaved");
						}
						
						if(map.get("scheduleId") != null)
						{
							 
							scheduleId =  (Integer)map.get("scheduleId");
						}
						
				
				String message = "";
				if (successfullyAdded.equals("yes")) {
					if(meetingId==0){
						message = "Meeting Scheduling Added Successfully and Meeting No. is "+meetingNo;
					}else{
						message = "Meeting Scheduling  Updated Successfully ";
					}
					
				} else {
					message = "Try Again!";
					map.put("messageType", "failure");
				}
				map = trainingHandlerService.showMeetingSchedulingJsp();
					if(request.getParameter("flag")!=null){
						box.put("locationId", locationId);
					}else{
						jsp="lgl_msg_meeting_scheduling";
					}
					map.put("dataSaved", dataSaved);
					
				jsp += ".jsp";
				System.out.println(scheduleId);
				map.put("scheduleId", scheduleId);
				map.put("contentJsp", jsp);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
				
			}
	//VKS
	public ModelAndView showVacancyPositionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datmap = new HashMap<String, Object>();
		if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){
			datmap.put("institute",Integer.parseInt(request.getParameter("institute")));
		}
		if(request.getParameter("department")!=null && !request.getParameter("department").equals("")){
			datmap.put("department", (Integer.parseInt(request.getParameter("department"))));}
		if(request.getParameter("designation")!=null && !request.getParameter("designation").equals("")){
			datmap.put("designation",(Integer.parseInt(request.getParameter("designation"))));}
		if(request.getParameter("cadre")!=null && !request.getParameter("cadre").equals("")){
			datmap.put("cadre",(Integer.parseInt(request.getParameter("cadre"))));}
		if(request.getParameter("district")!=null  && !request.getParameter("district").equals("")){
			datmap.put("district",(Integer.parseInt(request.getParameter("district"))));
		}
		if(request.getParameter("instituteType")!=null && !request.getParameter("instituteType").equals("")){
			datmap.put("instituteType", (Integer.parseInt(request.getParameter("instituteType"))));  
		}
		map = trainingHandlerService.showVacancyPositionJsp(datmap);
	
		   List<Object[]> list = new ArrayList<Object[]>();
		      if(map.get("list") != null){
		   	   list = (List<Object[]>)map.get("list");
		 	 	}
		     for(Object[] pd : list) {
		    System.out.println(pd[2]); 
		     }
		 String jsp = "vacancyPosition";
		jsp += ".jsp";
		title = "Vacancy Position";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//VKS
	public ModelAndView searchVacancyPositionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrInstitutionalSanctionedPost hisp = new HrInstitutionalSanctionedPost();
		 
		HttpSession session=request.getSession();
		int institute=0;
		if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){
			institute=Integer.parseInt(request.getParameter("institute"));
		}
		int department=0;
		if(request.getParameter("department")!=null && !request.getParameter("department").equals("")){
			department=(Integer.parseInt(request.getParameter("department")));}
		int designation=0;
		if(request.getParameter("designation")!=null && !request.getParameter("designation").equals("")){
			designation=(Integer.parseInt(request.getParameter("designation")));}
		 
		int cadre=0;
		if(request.getParameter("cadre")!=null && !request.getParameter("cadre").equals("")){
			cadre=(Integer.parseInt(request.getParameter("cadre")));}
		 
		map.put("institute", institute);
		map.put("department", department);
		map.put("designation", designation);
 		map.put("cadre", cadre);

 		map = trainingHandlerService.searchVacancyPositionJsp(map);
		 
		String jsp = "responseSearch";
		title = "Vacancy Position";
		map.put("contentJsp", jsp);
		map.put("title", title);
	 
		return new ModelAndView(jsp, "map", map);
	}
	//VKS
	  public ModelAndView saveVacancyPosition(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String massage="";
			HttpSession session=request.getSession();
			int count=Integer.parseInt(request.getParameter("hiddenValueCharge"));
			
			for(int i=1;i<count;i++){
			HrVacancyPost hrvp=new HrVacancyPost();
			HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost=new HrInstitutionalSanctionedPost();
			Date changedDate=new Date();
			if(request.getParameter(HrmsRequestConstants.CHANGED_DATE) != null && !request.getParameter(HrmsRequestConstants.CHANGED_DATE).equals("")){
				  changedDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter(HrmsRequestConstants.CHANGED_DATE));
			 
				hrvp.setLastChgDate(changedDate);
				 
			}
			String changedTime="";
			if(request.getParameter(HrmsRequestConstants.CHANGED_TIME) != null && !request.getParameter(HrmsRequestConstants.CHANGED_TIME).equals("")){
				  changedTime = request.getParameter(HrmsRequestConstants.CHANGED_TIME);
				hrvp.setLastChgTime(changedTime);
				 
			}
		
			int postId=0;
			if(request.getParameter("postId"+i)!=null){
				postId=Integer.parseInt(request.getParameter("postId"+i).trim());
			}
			dataMap.put("postId", postId);
			dataMap.put("status", request.getParameter(STATUS));
			HrInstitutionalSanctionedPost hrPost=new HrInstitutionalSanctionedPost();
			hrPost.setId(postId);
			hrvp.setSanctionedPost(hrPost);
			hrvp.setStatus("y");
			int instituteId=0;
			if(request.getParameter("instituteId"+i)!=null){
				instituteId=Integer.parseInt(request.getParameter("instituteId"+i).trim());
			}
			 
			 MasHospital mh = new MasHospital();
			 mh.setId(instituteId);
			 hrvp.setHospital(mh);
		    
			 int vpp=0;
		    if(request.getParameter("vpp"+i)!=null && !request.getParameter("vpp"+i).equals("")){
		    	vpp=Integer.parseInt(request.getParameter("vpp"+i));	
				}
		    
			hrvp.setVpermanentPost(vpp);
			
			int vtp=0;
		    if(request.getParameter("vtp"+i)!=null && !request.getParameter("vtp"+i).equals("")){
		    	vtp=Integer.parseInt(request.getParameter("vtp"+i));	
				}
		    
			hrvp.setVtemporaryPost(vtp);
			
			int vsp=0;
		    if(request.getParameter("vsp"+i)!=null && !request.getParameter("vsp"+i).equals("")){
		    	vsp=Integer.parseInt(request.getParameter("vsp"+i));	
				}
		    
			hrvp.setVsupernumeraryPost(vsp);
			map=trainingHandlerService.saveVacancyPosition(hrvp,dataMap);     
			}
			if(map.get("map")!=null){
			map=(Map<String, Object>) map.get("map");
			}
			boolean successfullyAdded=(Boolean)map.get("successfullyAdded");
			if(successfullyAdded){
			massage="Data Saved Successfully";
			}
			else {
			massage=" Try Again!";
			}
			map.put("massage", massage);
			 
			String jsp = "vacancyPosition";
			jsp += ".jsp";
			title = "Vacancy Position";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
	  }
	  
	//VKS
		public ModelAndView showTransferProcessingJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
		 	if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){
				datmap.put("instituteId", Integer.parseInt(""+request.getParameter("institute")));
			}
			if(request.getParameter("department")!=null && request.getParameter("department")!=""){
				datmap.put("departmentId", Integer.parseInt(""+request.getParameter("department")));
			}
			if(request.getParameter("designation")!=null && request.getParameter("designation")!=""){
				datmap.put("designationId", Integer.parseInt(""+request.getParameter("designation")));
			} 
			
			map = trainingHandlerService.showTransferProcessingJsp(datmap);
			 String jsp = "transferProcessing";
			jsp += ".jsp";
			title = "Transfer Processing";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showTransferProcessingDetailsJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			if(session.getAttribute("hospitalId")!=null){
				}
			if(session.getAttribute("districtId")!=null && !session.getAttribute("districtId").equals("")){
				datmap.put("districtId", Integer.parseInt(""+session.getAttribute("districtId")));
				}
			
			
			if (session.getAttribute("users") != null) {
				Users users = (Users) session.getAttribute("users");
				int userType = users.getUserType();
				datmap.put("userType", userType);
			}
			
			if(request.getParameter("requestId")!=null){
				datmap.put("requestId", Integer.parseInt(""+request.getParameter("requestId")));
			}
			if(request.getParameter("rankId")!=null){
				datmap.put("rankId", Integer.parseInt(""+request.getParameter("rankId")));
			}
			if(request.getParameter("requestHospitalId")!=null){
				datmap.put("requestHospitalId", Integer.parseInt(""+request.getParameter("requestHospitalId")));
			}
			map = trainingHandlerService.showTransferProcessingDetailsJsp(datmap);
			 String jsp = "transferProcessingDetails";
			jsp += ".jsp";
			title = "Transfer Processing";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView saveProcessingDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
			map = trainingHandlerService.saveProcessingDetails(datmap,box);
			map.putAll(trainingHandlerService.showTransferProcessingJsp(datmap));
			 String jsp = "transferProcessing";
			jsp += ".jsp";
			title = "Transfer Processing";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		// Kaushal Mishra
		
		public ModelAndView forwardProcessingDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
			map = trainingHandlerService.forwardProcessingDetails(datmap,box);
			map.putAll(trainingHandlerService.showTransferProcessingJsp(datmap));
			 String jsp = "transferProcessing";
			jsp += ".jsp";
			title = "Transfer Processing";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView cancleApprovalDetails(HttpServletRequest request,HttpServletResponse response)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
		 	if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){
				datmap.put("instituteId", Integer.parseInt(""+request.getParameter("institute")));
			}
			if(request.getParameter("department")!=null && request.getParameter("department")!=""){
				datmap.put("departmentId", Integer.parseInt(""+request.getParameter("department")));
			}
			if(request.getParameter("designation")!=null && request.getParameter("designation")!=""){
				datmap.put("designationId", Integer.parseInt(""+request.getParameter("designation")));
			} 
			
			map = trainingHandlerService.cancelApprovalDetails(datmap,box);
			String jsp = "cancelApprovalDetails.jsp";
			title = "Cancel Approval";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView cancelApproval(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
			map = trainingHandlerService.cancelApproval(datmap,box);
			map.putAll(trainingHandlerService.cancelApprovalDetails(datmap,box));
			
			String jsp = "cancelApprovalDetails.jsp";
			title = "Cancel Approval";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView inactiveEmployeeDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				datmap.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			
			map = trainingHandlerService.inactiveEmployeeDetails(datmap,box);
			
			String jsp = "inactiveEmployeeDetails.jsp";
			title = "Inactive Employees";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView assignHospitalToEmployee(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> datmap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			if(session.getAttribute("hospitalId")!=null){
				box.put("hospitalId", Integer.parseInt(""+session.getAttribute("hospitalId")));
			}
			if(request.getParameter("district")!=null && request.getParameter("district")!=""){
				box.put("district", Integer.parseInt(""+request.getParameter("district")));
			}
			if(request.getParameter("joiningDate")!=null && request.getParameter("joiningDate")!=""){
				box.put("joiningDate", ""+request.getParameter("joiningDate"));
			}
			
			if(request.getParameter("approvedId")!=null && request.getParameter("approvedId")!=""){
				box.put("approvedId", Integer.parseInt(""+request.getParameter("approvedId")));
			}
			if(request.getParameter("employeeId")!=null && request.getParameter("employeeId")!=""){
				box.put("employeeId", Integer.parseInt(""+request.getParameter("employeeId")));
			}
			if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){
				box.put("institute", Integer.parseInt(""+request.getParameter("institute")));
			}
			
			map = trainingHandlerService.assignHospitalToEmployee(datmap,box);
			map.putAll(trainingHandlerService.inactiveEmployeeDetails(datmap,box));
			
			String jsp = "inactiveEmployeeDetails.jsp";
			title = "Inactive Employees";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView generateApprovalReport(
				HttpServletRequest request, HttpServletResponse response) {

			Map<String, Object> requestParameters = new HashMap<String, Object>();
			int hospitalId = 0;

			HttpSession session = request.getSession();
			try {
				
				if (session.getAttribute("hospitalId") != null) 
				{
					hospitalId = (Integer) session.getAttribute("hospitalId");
					requestParameters.put("hospitalId", hospitalId);
				}
				   Users users = new Users();
	            if (session.getAttribute("users") != null) 
				{
	               users = (Users) session.getAttribute("users");
	               requestParameters.put("empId", users.getEmployee().getId());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			requestParameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/Reports/"));
			Map<String, Object> connectionMap = trainingHandlerService.getConnectionForReport();
			HMSUtil.generateReport("ProdeedingOfTheAdditinalDirectorOfHealth", requestParameters,(Connection) connectionMap.get("conn"), response, getServletContext());
			return null;
		}
		

	public ModelAndView deleteAttachFileDepute(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List ticketAttachIdList = new ArrayList();
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) 
		   {
				try 
				{
					mrequest = new MultipartFormDataRequest(request);
				} 
				catch (UploadException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
		   }
		int request_id = 0;
		if(mrequest.getParameter("request_id")!= null){
			request_id = Integer.parseInt(mrequest.getParameter("request_id"));
			generalMap.put("request_id", request_id);
		}
		int noOfFiles = 0;
		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}
		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter("TICKET_ATTACH_ID"+j)!= null && !(mrequest.getParameter("TICKET_ATTACH_ID"+j).equals(""))) {
				ticketAttachIdList .add(Integer.parseInt(mrequest.getParameter("TICKET_ATTACH_ID"+j)));
			}
			
		}
		generalMap.put("ticketAttachIdList", ticketAttachIdList);
		map = trainingHandlerService.deleteAttachFileDepute(generalMap);
		String jsp = "hr_joining_attachDocumentPopup";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showSubCommitteeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		map = trainingHandlerService.showSubCommitteeJsp();
		jsp = "lgl_subCommittee";
		jsp += ".jsp";
		title = "Sub Committee";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addSubCommittee(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map=new HashMap<String,Object>();
		HrCommitteeDetails lgl=new HrCommitteeDetails();
		
		Map<String,Object> listMap=new HashMap<String,Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=0;
		
		String address="";
		int designationId=0;
		Date dateOfAppointment=null;
		String briefBackground="";
		int noOfShareHeld=0;
		String remarks="";
		String designation="";
		int emp_id=0;
		String memberName="";
		int committeeId=0;
		int hosId=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		
		if (request.getParameter("nameMember") != null && !"".equals(request.getParameter("nameMember"))) {
			memberName = request.getParameter("nameMember");
		}
		
		if (request.getParameter("otherMember") != null&&!"".equals(request.getParameter("otherMember"))) {
			memberName = request.getParameter("otherMember");
		}
		
		String memberType="";
		if (request.getParameter("memberRadio") != null) {
			memberType = request.getParameter("memberRadio");
		}
		System.out.println(memberName+"memberType>>>"+memberType);
		if (request.getParameter("designationId") != null && !request.getParameter("designationId").equals("")) {
			designationId = Integer.parseInt(request.getParameter("designationId"));
		}
		if (request.getParameter("hosId") != null && !request.getParameter("hosId").equals("")) {
			hosId = Integer.parseInt(request.getParameter("hosId"));
		}
		if (request.getParameter("emp_id") != null && !request.getParameter("emp_id").equals("")) {
			emp_id = Integer.parseInt(request.getParameter("emp_id"));
		}
		if (request.getParameter("committeeId") != null) {
			committeeId = Integer.parseInt(request.getParameter("committeeId"));
		}
		if (request.getParameter("designation") != null) {
			designation = ""+request.getParameter("designation");
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
		}
		if (request.getParameter("dateOfAppointment") != null
				&& !(request.getParameter("dateOfAppointment").equals(""))) {
			dateOfAppointment = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfAppointment"));
		}
		if (request.getParameter("briefBackground") != null) {
			briefBackground = request.getParameter("briefBackground");
		}
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}
		
		if (request.getParameter("noOfShareHeld") != null) {
			noOfShareHeld =  Integer.parseInt(request.getParameter("noOfShareHeld"));
		}
		
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}	
		int sesHosId=0;
		if (session.getAttribute("hospitalId") != null) {
			sesHosId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					
		}
		generalMap.put("name", memberName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		//listMap = mastersHandlerService.checkForExistingMasters(generalMap);
		List nameList = new  ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			nameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		
		
		
		lgl.setCommitteeMemberType(memberType);
		
		if((nameList.size() == 0 || nameList == null))
		{
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
			successfullyAdded = trainingHandlerService.addSubCommittee(lgl);		

			if(successfullyAdded)
			{
				message="Record Added Successfully !!";
			}
			else
			{
				message="Try Again !!";
			}
		}
		else if((nameList.size() != 0) || nameList != null){

		
			if((nameList.size() != 0 || nameList != null)){
				message = "Name  already exists.";
			}
			
		}

		url = "/hms/hms/legal?method=showSubCommitteeJsp";
		try{
			map = trainingHandlerService.showSubCommitteeJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp="lgl_subCommittee";
		title="Add Sub Committee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editSubCommittee(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object>	map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String nameSubCommittee="";
		int subCommitteeId=0;
		int userId=0;
		
		
		String address="";
		int designationId=0;
		Date dateOfAppointment=null;
		String briefBackground="";
		int noOfShareHeld=0;
		String remarks="";
		
		HrCommitteeDetails lgl=new HrCommitteeDetails();
		
		
		Date currentDate = new Date();
		
		String designation="";
		int emp_id=0;
		String memberName="";
		int committeeId=0;
		int hosId=0;
		int sesHosId =0;
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			subCommitteeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		
		
		if (request.getParameter("nameMember") != null) {
			memberName = request.getParameter("nameMember");
		}
		
		if (request.getParameter("otherMember") != null) {
			memberName = request.getParameter("otherMember");
		}
		
		String memberType="";
		if (request.getParameter("memberRadio") != null) {
			memberType = request.getParameter("memberRadio");
		}
		System.out.println(memberName+"memberType>>>"+memberType);
		if (request.getParameter("designationId") != null && !request.getParameter("designationId").equals("")) {
			designationId = Integer.parseInt(request.getParameter("designationId"));
		}
		if (request.getParameter("hosId") != null && !request.getParameter("hosId").equals("")) {
			hosId = Integer.parseInt(request.getParameter("hosId"));
		}
		if (session.getAttribute("hospitalId") != null) {
			sesHosId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					
		}
		if (request.getParameter("emp_id") != null && !request.getParameter("emp_id").equals("")) {
			emp_id = Integer.parseInt(request.getParameter("emp_id"));
		}
		if (request.getParameter("committeeId") != null) {
			committeeId = Integer.parseInt(request.getParameter("committeeId"));
		}
		if (request.getParameter("designation") != null) {
			designation = ""+request.getParameter("designation");
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
		}
		if (request.getParameter("dateOfAppointment") != null
				&& !(request.getParameter("dateOfAppointment").equals(""))) {
			dateOfAppointment = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("dateOfAppointment"));
		}
		if (request.getParameter("briefBackground") != null) {
			briefBackground = request.getParameter("briefBackground");
		}
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}
		
		if (request.getParameter("noOfShareHeld") != null) {
			noOfShareHeld =  Integer.parseInt(request.getParameter("noOfShareHeld"));
		}
	
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		
		String changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("id", subCommitteeId);
		generalMap.put("memberType", memberType);
		generalMap.put("name", memberName);
		generalMap.put("emp_id", emp_id);
		generalMap.put("hosId", hosId);
		generalMap.put("sesHosId", sesHosId);
		generalMap.put("committeeId", committeeId);
		generalMap.put("noOfShareHeld", noOfShareHeld);
		generalMap.put("remarks", remarks);
		generalMap.put("briefBackground", briefBackground);
		generalMap.put("dateOfAppointment", dateOfAppointment);
		generalMap.put("address", address);
		generalMap.put("designationId", designationId);
		generalMap.put("designation", designation);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		//listMap = mastersHandlerService.checkForExistingMasters(generalMap);
		//List existingNameList = (List)listMap.get("duplicateMastersList");
		List existingNameList = new ArrayList();
		boolean dataUpdated=false;
		if(existingNameList.size() == 0)
		{
		dataUpdated=trainingHandlerService.editSubCommitteeToDatabase(generalMap);
		if(dataUpdated==true){
			message="Record Updated Successfully !!";
		}
		else{
			message="Record Cant be updated !!";
		}
		url = "/erp/erp/legal?method=showSubCommitteeJsp";
	
		try{
			map = trainingHandlerService.showSubCommitteeJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		} 
		else if(existingNameList.size() > 0){

			message = "Name already exists.";
		}
		jsp="lgl_subCommittee";
		title="Edit Sub Commitee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getCommitteeMember(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("getCommitteeMember"+request.getParameter("committeeId"));
		Map<String, Object> map = new HashMap<String, Object>();
		int committeeId = Integer.parseInt(request.getParameter("committeeId"));

		map = trainingHandlerService.getCommitteeMember(committeeId);
		System.out.println("first");
		String jsp = "responseForCommittee";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showListOfMeetingSchedulingJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int locationId = 0;
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		box.put("locationId", locationId);
		map = trainingHandlerService.showListOfMeetingScheduling(box);

		jsp = "lgl_list_of_meeting_scheduling";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
		 
	}
	
	public ModelAndView showMinutesOfMeetingJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		int meetingId  = 0;
		if(request.getParameter("meetingId")!=null){
			meetingId = Integer.parseInt(request.getParameter("meetingId"));
		}
		box.put("meetingId", meetingId);

		Map<String, Object> map = trainingHandlerService.showMinutesOfMeetingJsp(box);
		jsp = "lgl_minutes_of_meeting";
		jsp += ".jsp";
		title = "Minutes Of Meeting";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveMinutesOfMeeting(HttpServletRequest request, HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) 
		{
			try 
			{
				mrequest = new MultipartFormDataRequest(request);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		int scheduleId=0;
		String successfullyAdded = "no";
		int userId =0;
		int locationId = 0;
		int departmentId =0;
		//int meetingAgendaPointId=0;
		//int meetingMemberId=0;
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		if (session.getAttribute("hospitalId") != null)
			locationId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("departmentId") != null)
			departmentId = Integer.parseInt(""+ session.getAttribute("departmentId"));
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "";
		String fileExtension = null;
		int meetingId = 0;
		String meetingNo = "";
		String buttonName = null;
		if(request.getParameter("buttonName")!=null){
			buttonName = request.getParameter("buttonName");
		}
		
		if (request.getParameter("meetingNo") != null) {
			meetingNo = request.getParameter("meetingNo");
		
		}/*if (request.getParameter("meetingId") != null) {
			meetingId = Integer.parseInt(request.getParameter("meetingId"));
		
		}
		if (request.getParameter("meetingAgendaPointId") != null) {
			meetingAgendaPointId = Integer.parseInt(request.getParameter("meetingAgendaPointId"));
		
		}
		
		if (request.getParameter("meetingMemberId") != null) {
			meetingMemberId = Integer.parseInt(request.getParameter("meetingMemberId"));
		
		}*/
		
		
		
		Boolean dataSaved = false;
		Box box = null;
		if(mrequest != null)
		{
		
			box = HMSUtil.getBox(mrequest);
		
				
				try 
				{
			/*		String userHome = getServletContext().getRealPath("");
					String fileSeparator = System.getProperty("file.separator");
					String uploadURL = userHome.substring(0, userHome
							.lastIndexOf(fileSeparator))
							+ fileSeparator
							+ "upload" + fileSeparator;
					HMSUtil.createFolderFroDocument("MinutesOfMeeting", uploadURL);*/
					
					String userHome = getServletContext().getRealPath("");
					String fileSeparator = System.getProperty("file.separator");
					String uploadURL = userHome.substring(0, userHome
							.lastIndexOf(fileSeparator))
							+ fileSeparator
							+ "upload" + fileSeparator;
					HMSUtil.createFolderFroDocument("MinutesOfMeeting", uploadURL);
					
					
					
					List fileUploadedList = null;
					int uploadCount = 0;
					if(request.getParameter("uploadCount")!=null){
						uploadCount = Integer.parseInt(request.getParameter("uploadCount"));
					}
					int i = 1;
					for (i = 1; i <= uploadCount; i++) {
						if ((request.getParameter("filename" + i)!=null) && !request.getParameter("filename" + i).equals("")) {
							StringTokenizer strToken = new StringTokenizer(request
									.getParameter("filename" + i), ".");

							@SuppressWarnings("unused")
							String fileName = strToken.nextToken();
							fileExtension = strToken.nextToken();

							String whiteList = "*." + fileExtension;

							fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
									+ "MinutesOfMeeting" + fileSeparator, whiteList, request
									.getParameter("filename" + i), i);
							box.put("filename" + i, request.getParameter("filename" + i));
						
							box.put("fileExtension" + i, fileExtension);
						} else {
							box.put("filename" + i, "");
						}
					}
					
					@SuppressWarnings("unused")
					Boolean fileUploaded = false;
					if (fileUploadedList != null && fileUploadedList.size() != 0) {
						fileUploaded = (Boolean) fileUploadedList.get(0);
					}
					box.put("uploadCount", uploadCount);
					box.put("uploadURL", uploadURL);
					box.put("fileSeparator", fileSeparator);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
		}else{
			box = HMSUtil.getBox(request);
		}
		
		
				meetingId = box.getInt("meetingId");
				//meetingAgendaPointId = box.getInt("meetingAgendaPointId");
				//meetingMemberId = box.getInt("meetingMemberId");
				box.put("buttonName", buttonName);
				box.put("userId", userId);
				dataMap.put("locationId", locationId);
				box.put("departmentId", departmentId);
				System.out.println(departmentId);
				dataMap.put("box", box);
				System.out.println(meetingId);
				map = trainingHandlerService.saveMinutesOfMeeting(dataMap);
				if (map.get("successfullyAdded") != null)
					successfullyAdded = "" + map.get("successfullyAdded");
				
				if(map.get("dataSaved") != null)
				{
					 
					dataSaved =  (Boolean)map.get("dataSaved");
				}
				if(map.get("scheduleId") != null)
				{
					 
					scheduleId =  (Integer)map.get("scheduleId");
				}
		
		String message = "";
		if (successfullyAdded.equals("yes")) {
			if(meetingId==0){
				message = "Minutes Of Meeting Added Successfully and Meeting No. is "+meetingNo;
			}else{
				message = "Minutes Of Meeting  Updated Successfully ";
			}
			
		} else {
			message = "Try Again!";
			map.put("messageType", "failure");
		}
		map = trainingHandlerService.showMinutesOfMeetingJsp(box);
			if(request.getParameter("flag")!=null){
				box.put("locationId", locationId);
			}else{
				jsp="lgl_msg_minutes_of_meeting";
			}
			map.put("dataSaved", dataSaved);
			
		jsp += ".jsp";
		System.out.println(scheduleId);
		map.put("scheduleId", scheduleId);
		map.put("contentJsp", jsp);
		map.put("url", url);
	
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		
	}
		
	
}
