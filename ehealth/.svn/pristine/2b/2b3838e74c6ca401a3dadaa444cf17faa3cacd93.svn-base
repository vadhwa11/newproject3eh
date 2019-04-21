package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_FIELD;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;
import static jkt.hrms.util.HrmsRequestConstants.SECTION_MASTER_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SELECTED_RADIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasSection;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import jkt.hrms.masters.handler.SectionMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SectionMasterController extends MultiActionController {

	SectionMasterHandlerService sectionMasterHandlerService = null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService = null;

	public void setSectionMasterHandlerService(
			SectionMasterHandlerService sectionMasterHandlerService) {
		this.sectionMasterHandlerService = sectionMasterHandlerService;
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

	// ****************************************** Start Of Job Master by
	// Rajendra ****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showSectionMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = sectionMasterHandlerService.showSectionMasterJsp();
		String jsp = SECTION_MASTER_JSP;
		jsp += ".jsp";
		title = "Section Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSectionMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String sectionCode = null;
		String sectionName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sectionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sectionName = request.getParameter(SEARCH_NAME);
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
			sectionCode = searchField;
			sectionName = null;
		} else {
			sectionName = searchField;
			sectionCode = null;
		}

		map = sectionMasterHandlerService.searchSectionMaster(sectionCode,
				sectionName);
		String jsp = SECTION_MASTER_JSP;
		jsp += ".jsp";
		title = "Section Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSectionMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasSection hrMasSection = new HrMasSection();

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int departmentId = 0;
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

		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
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
		List sectionCodeList = new ArrayList();
		List sectionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			sectionCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			sectionNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((sectionCodeList.size() == 0 || sectionCodeList == null)) {
			hrMasSection.setSectionCode(code);
			hrMasSection.setSectionName(name);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasSection.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasSection.setCompany(masHospital);

			hrMasSection.setStatus("y");
			hrMasSection.setLastChgBy(changedBy);
			hrMasSection.setLastChgDate(currentDate);
			hrMasSection.setLastChgTime(currentTime);
			successfullyAdded = sectionMasterHandlerService
					.addSectionMaster(hrMasSection);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((sectionCodeList.size() != 0 || sectionCodeList != null)
				|| (sectionNameList.size() != 0) || sectionNameList != null) {
			if ((sectionCodeList.size() != 0 || sectionCodeList != null)
					&& (sectionNameList.size() == 0 || sectionNameList == null)) {

				message = "Section Code already exists.";
			} else if ((sectionNameList.size() != 0 || sectionNameList != null)
					&& (sectionCodeList.size() == 0 || sectionCodeList == null)) {

				message = "Name Name  already exists.";
			} else if ((sectionCodeList.size() != 0 || sectionCodeList != null)
					&& (sectionNameList.size() != 0 || sectionNameList != null)) {
				message = "Section Code and Section Description already exist.";
			}
		}
		url = "hms/hrms/sectionMaster?method=showSectionMasterJsp";
		try {
			map = sectionMasterHandlerService.showSectionMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = SECTION_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Section Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSectionMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String sectionCode = "";
		String sectionName = "";
		int departmentId = 0;
		int hospitalId = 0;
		int sectionId = 0;

		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sectionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sectionName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", sectionId);
		generalMap.put("jobCode", sectionCode);
		generalMap.put("name", sectionName);

		generalMap.put("departmentId", departmentId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingJobCodeMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingJobCodeMasterList.size() == 0) {
			dataUpdated = sectionMasterHandlerService
					.editSectionMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingJobCodeMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/sectionMaster?method=showSectionMasterJsp";
		try {
			map = sectionMasterHandlerService.showSectionMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SECTION_MASTER_JSP;
		title = "Edit Section Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteSectionMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int sectionId = 0;
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
			sectionId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = sectionMasterHandlerService.deleteSectionMaster(
				sectionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/sectionMaster?method=showSectionMasterJsp";

		try {
			map = sectionMasterHandlerService.showSectionMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SECTION_MASTER_JSP;
		title = "Delete Section Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

}
