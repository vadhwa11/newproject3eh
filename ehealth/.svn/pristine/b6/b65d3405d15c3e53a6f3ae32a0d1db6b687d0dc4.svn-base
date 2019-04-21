package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_COURSE_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_QUALIFICATION_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_SPECIAL_QUALIFICATION_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_FIELD;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;
import static jkt.hrms.util.HrmsRequestConstants.SELECTED_RADIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasSpecialQualification;
import jkt.hrms.masters.handler.EducationHandlerService;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EducationController extends MultiActionController {
	EducationHandlerService educationHandlerService = null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService = null;

	public EducationHandlerService getEducationHandlerService() {
		return educationHandlerService;
	}

	public void setEducationHandlerService(
			EducationHandlerService educationHandlerService) {
		this.educationHandlerService = educationHandlerService;
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

	// ****************************************** Start Of Course Master by
	// Rajendra ****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showCourseMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = educationHandlerService.showCourseMasterJsp();
		String jsp = HR_COURSE_MASTER_JSP;
		jsp += ".jsp";
		title = "Course Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchCourseMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String courseCode = null;
		String courseName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			courseCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			courseName = request.getParameter(SEARCH_NAME);
		}
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			courseCode = searchField;
			courseName = null;
		} else {
			courseName = searchField;
			courseCode = null;
		}

		map = educationHandlerService
				.searchCourseMaster(courseCode, courseName);
		String jsp = HR_COURSE_MASTER_JSP;
		jsp += ".jsp";
		title = "Course Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCourseMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasCourse hrMasCourse = new HrMasCourse();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int hospitalId = 0;

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& (!(request.getParameter(CHANGED_BY).equals("")))) {
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
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List courseCodeList = new ArrayList();
		List courseNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			courseCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			courseNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if ((courseCodeList.size() == 0 || courseCodeList == null)) {
			hrMasCourse.setCourseCode(code);
			hrMasCourse.setCourseName(name);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasCourse.setCompany(masHospital);

			hrMasCourse.setStatus("y");
			hrMasCourse.setLastChgBy(changedBy);
			hrMasCourse.setLastChgDate(currentDate);
			hrMasCourse.setLastChgTime(currentTime);
			successfullyAdded = educationHandlerService
					.addCourseMaster(hrMasCourse);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((courseCodeList.size() != 0 || courseCodeList != null)
				|| (courseNameList.size() != 0) || courseNameList != null) {
			if ((courseCodeList.size() != 0 || courseCodeList != null)
					&& (courseNameList.size() == 0 || courseNameList == null)) {

				message = "Course Code already exists.";
			} else if ((courseNameList.size() != 0 || courseNameList != null)
					&& (courseCodeList.size() == 0 || courseCodeList == null)) {

				message = "Course Name  already exists.";
			} else if ((courseCodeList.size() != 0 || courseCodeList != null)
					&& (courseNameList.size() != 0 || courseNameList != null)) {
				message = "Course Code and Course Description already exist.";
			}
		}
		url = "hms/hrms/educationMasters?method=showCourseMasterJsp";
		try {
			map = educationHandlerService.showCourseMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_COURSE_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Course Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCourseMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String courseCode = "";
		String courseName = "";
		int hospitalId = 0;
		int courseId = 0;

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
			courseId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			courseCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			courseName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", courseId);
		generalMap.put("code", courseCode);
		generalMap.put("name", courseName);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCourseMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingCourseMasterList.size() == 0) {
			dataUpdated = educationHandlerService.editCourseMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingCourseMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/educationMasters?method=showCourseMasterJsp";
		try {
			map = educationHandlerService.showCourseMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_COURSE_MASTER_JSP;
		title = "Edit Course Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteCourseMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int courseId = 0;
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
			courseId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = educationHandlerService.deleteCourseMaster(courseId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/educationMasters?method=showCourseMasterJsp";

		try {
			map = educationHandlerService.showCourseMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_COURSE_MASTER_JSP;
		title = "Delete Course Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ******************************************* End of Course Master By
	// Rajendra***************************************************//

	// ******************************************** Start of Qualification
	// Master By Rajendra ****************************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showQualificationMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = educationHandlerService.showQualificationMasterJsp();
		String jsp = HR_QUALIFICATION_MASTER_JSP;
		jsp += ".jsp";
		title = "Qualification Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addQualificationMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasQualification hrMasQualification = new HrMasQualification();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int hospitalId = 0;

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& (!(request.getParameter(CHANGED_BY).equals("")))) {
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
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List qualificationCodeList = new ArrayList();
		List qualificationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			qualificationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			qualificationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((qualificationCodeList.size() == 0 || qualificationCodeList == null)) {
			hrMasQualification.setQualificationCode(code);
			hrMasQualification.setQualificationName(name);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasQualification.setCompany(masHospital);

			hrMasQualification.setStatus("y");
			hrMasQualification.setLastChgBy(changedBy);
			hrMasQualification.setLastChgDate(currentDate);
			hrMasQualification.setLastChgTime(currentTime);
			successfullyAdded = educationHandlerService
					.addQualificationMaster(hrMasQualification);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((qualificationCodeList.size() != 0 || qualificationCodeList != null)
				|| (qualificationNameList.size() != 0)
				|| qualificationNameList != null) {
			if ((qualificationCodeList.size() != 0 || qualificationCodeList != null)
					&& (qualificationNameList.size() == 0 || qualificationNameList == null)) {

				message = "Qualifiction Code already exists.";
			} else if ((qualificationNameList.size() != 0 || qualificationNameList != null)
					&& (qualificationCodeList.size() == 0 || qualificationCodeList == null)) {

				message = "Qualification Name  already exists.";
			} else if ((qualificationCodeList.size() != 0 || qualificationCodeList != null)
					&& (qualificationNameList.size() != 0 || qualificationNameList != null)) {
				message = "Qualification Code and Qualification Description already exist.";
			}
		}
		url = "hms/hrms/educationMasters?method=showQualificationMasterJsp";
		try {
			map = educationHandlerService.showQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_QUALIFICATION_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Qualification Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchQualificationMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String qualificationCode = null;
		String qualificationName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			qualificationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			qualificationName = request.getParameter(SEARCH_NAME);
		}
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			qualificationCode = searchField;
			qualificationName = null;
		} else {
			qualificationName = searchField;
			qualificationCode = null;
		}

		map = educationHandlerService.searchQualificationMaster(
				qualificationCode, qualificationName);
		String jsp = HR_QUALIFICATION_MASTER_JSP;
		jsp += ".jsp";
		title = "Course Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editQualificationMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String qualificationCode = "";
		String qualificationName = "";
		int hospitalId = 0;
		int qualificationId = 0;

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
			qualificationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			qualificationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			qualificationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", qualificationId);
		generalMap.put("code", qualificationCode);
		generalMap.put("name", qualificationName);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingQualificationMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingQualificationMasterList.size() == 0) {
			dataUpdated = educationHandlerService
					.editQualificationMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingQualificationMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/educationMasters?method=showQualificationMasterJsp";
		try {
			map = educationHandlerService.showQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_QUALIFICATION_MASTER_JSP;
		title = "Edit Qualification Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteQualificationMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int qualificationId = 0;
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
			qualificationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = educationHandlerService.deleteQualificationMaster(
				qualificationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/educationMasters?method=showQualificationMasterJsp";

		try {
			map = educationHandlerService.showQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_QUALIFICATION_MASTER_JSP;
		title = "Delete Qualification Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ******************************************* End of Qualification Master
	// By Rajendra***************************************************//

	// ******************************************** Start of Special
	// Qualification Master By Rajendra
	// ****************************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showSpecialQualificationMasterJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map map = new HashMap();
		map = educationHandlerService.showSpecialQualificationMasterJsp();
		String jsp = HR_SPECIAL_QUALIFICATION_JSP;
		jsp += ".jsp";
		title = "Special Qualification Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSpecialQualificationMaster(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasSpecialQualification hrMasSpecialQualification = new HrMasSpecialQualification();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int hospitalId = 0;

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& (!(request.getParameter(CHANGED_BY).equals("")))) {
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
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List specialQualificationCodeList = new ArrayList();
		List specialQualificationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			specialQualificationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			specialQualificationNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((specialQualificationCodeList.size() == 0 || specialQualificationCodeList == null)) {
			hrMasSpecialQualification.setSpecialQualificationCode(code);
			hrMasSpecialQualification.setSpecialQualificationName(name);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasSpecialQualification.setCompany(masHospital);

			hrMasSpecialQualification.setStatus("y");
			hrMasSpecialQualification.setLastChgBy(changedBy);
			hrMasSpecialQualification.setLastChgDate(currentDate);
			hrMasSpecialQualification.setLastChgTime(currentTime);
			successfullyAdded = educationHandlerService
					.addSpecialQualificationMaster(hrMasSpecialQualification);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((specialQualificationCodeList.size() != 0 || specialQualificationCodeList != null)
				|| (specialQualificationNameList.size() != 0)
				|| specialQualificationNameList != null) {
			if ((specialQualificationCodeList.size() != 0 || specialQualificationCodeList != null)
					&& (specialQualificationNameList.size() == 0 || specialQualificationNameList == null)) {

				message = "Special Qualification Code already exists.";
			} else if ((specialQualificationNameList.size() != 0 || specialQualificationNameList != null)
					&& (specialQualificationCodeList.size() == 0 || specialQualificationCodeList == null)) {

				message = "Special Qualification Name  already exists.";
			} else if ((specialQualificationCodeList.size() != 0 || specialQualificationCodeList != null)
					&& (specialQualificationNameList.size() != 0 || specialQualificationNameList != null)) {
				message = "Special Qualification Code and Special Qualification Description already exist.";
			}
		}
		url = "hms/hrms/educationMasters?method=showSpecialQualificationMasterJsp";
		try {
			map = educationHandlerService.showSpecialQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_SPECIAL_QUALIFICATION_JSP;
		jsp += ".jsp";
		title = "Add Special Qualification Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSpecialQualificationMaster(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String specialQualificationCode = null;
		String specialQualificationName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			specialQualificationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			specialQualificationName = request.getParameter(SEARCH_NAME);
		}
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			specialQualificationCode = searchField;
			specialQualificationName = null;
		} else {
			specialQualificationName = searchField;
			specialQualificationCode = null;
		}

		map = educationHandlerService.searchSpecialQualificationMaster(
				specialQualificationCode, specialQualificationName);
		String jsp = HR_SPECIAL_QUALIFICATION_JSP;
		jsp += ".jsp";
		title = "Special Qualification Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSpecialQualificationMaster(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String specialQualificationCode = "";
		String specialQualificationName = "";
		int hospitalId = 0;
		int specialQualificationId = 0;

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
			specialQualificationId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			specialQualificationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			specialQualificationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", specialQualificationId);
		generalMap.put("code", specialQualificationCode);
		generalMap.put("name", specialQualificationName);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSpecialQualificationMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingSpecialQualificationMasterList.size() == 0) {
			dataUpdated = educationHandlerService
					.editSpecialQualificationMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingSpecialQualificationMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/educationMasters?method=showSpecialQualificationMasterJsp";
		try {
			map = educationHandlerService.showSpecialQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_SPECIAL_QUALIFICATION_JSP;
		title = "Edit Special Qualification Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteSpecialQualificationMaster(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int specialQualificationId = 0;
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
			specialQualificationId = Integer.parseInt(request
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
		dataDeleted = educationHandlerService.deleteSpecialQualificationMaster(
				specialQualificationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/educationMasters?method=showSpecialQualificationMasterJsp";

		try {
			map = educationHandlerService.showSpecialQualificationMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_SPECIAL_QUALIFICATION_JSP;
		title = "Delete Special Qualification Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

}
