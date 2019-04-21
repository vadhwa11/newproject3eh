package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_INSTITUTE_MASTER_JSP;
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
import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import jkt.hrms.masters.handler.InstituteHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InstituteController extends MultiActionController {

	InstituteHandlerService instituteHandlerService = null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService = null;

	public InstituteHandlerService getInstituteHandlerService() {
		return instituteHandlerService;
	}

	public void setInstituteHandlerService(
			InstituteHandlerService instituteHandlerService) {
		this.instituteHandlerService = instituteHandlerService;
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

	// ****************************************** Start Of Institute Master by
	// Rajendra ****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView showInstituteMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = instituteHandlerService.showInstituteMasterJsp();
		String jsp = HR_INSTITUTE_MASTER_JSP;
		jsp += ".jsp";
		title = "Institute Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInstituteMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasInstitute hrMasInstitute = new HrMasInstitute();

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
		List instituteCodeList = new ArrayList();
		List instituteNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			instituteCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			instituteNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((instituteCodeList.size() == 0 || instituteCodeList == null)) {
			hrMasInstitute.setInstituteCode(code);
			hrMasInstitute.setInstituteName(name);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstitute.setCompany(masHospital);

			hrMasInstitute.setStatus("y");
			hrMasInstitute.setLastChgBy(changedBy);
			hrMasInstitute.setLastChgDate(currentDate);
			hrMasInstitute.setLastChgTime(currentTime);
			successfullyAdded = instituteHandlerService
					.addInstituteMaster(hrMasInstitute);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((instituteCodeList.size() != 0 || instituteCodeList != null)
				|| (instituteNameList.size() != 0) || instituteNameList != null) {
			if ((instituteCodeList.size() != 0 || instituteCodeList != null)
					&& (instituteNameList.size() == 0 || instituteNameList == null)) {

				message = "Institute Code already exists.";
			} else if ((instituteNameList.size() != 0 || instituteNameList != null)
					&& (instituteCodeList.size() == 0 || instituteCodeList == null)) {

				message = "Institute Name  already exists.";
			} else if ((instituteCodeList.size() != 0 || instituteCodeList != null)
					&& (instituteNameList.size() != 0 || instituteNameList != null)) {
				message = "Institute Code and Institute Description already exist.";
			}
		}
		url = "hms/hrms/instituteMaster?method=showInstituteMasterJsp";
		try {
			map = instituteHandlerService.showInstituteMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_INSTITUTE_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Institute Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchInstituteMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String instituteCode = null;
		String instituteName = null;
		String searchField = null;
		int searchRadio = 1;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instituteCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instituteName = request.getParameter(SEARCH_NAME);
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
			instituteCode = searchField;
			instituteName = null;
		} else {
			instituteName = searchField;
			instituteCode = null;
		}

		map = instituteHandlerService.searchInstituteMaster(instituteCode,
				instituteName);
		String jsp = HR_INSTITUTE_MASTER_JSP;
		jsp += ".jsp";
		title = "Institute Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editInstituteMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String instituteCode = "";
		String instituteName = "";
		int hospitalId = 0;
		int instituteId = 0;

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
			instituteId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instituteCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instituteName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", instituteId);
		generalMap.put("code", instituteCode);
		generalMap.put("name", instituteName);

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
			dataUpdated = instituteHandlerService
					.editInstituteMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingQualificationMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/instituteMaster?method=showInstituteMasterJsp";
		try {
			map = instituteHandlerService.showInstituteMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTITUTE_MASTER_JSP;
		title = "Edit Institute Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteInstituteMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int instituteId = 0;
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
			instituteId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = instituteHandlerService.deleteInstituteMaster(
				instituteId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/instituteMaster?method=showInstituteMasterJsp";

		try {
			map = instituteHandlerService.showInstituteMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTITUTE_MASTER_JSP;
		title = "Delete Institute Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ******************************************* End of Qualification Master
	// By Rajendra***************************************************//

}
