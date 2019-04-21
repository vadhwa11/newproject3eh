package jkt.hrms.masters.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_INSTALMENT_MASTER_JSP;
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
import jkt.hrms.masters.business.HrMasInstalment;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import jkt.hrms.masters.handler.InstalmentHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InstalmentController extends MultiActionController {

	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService = null;
	InstalmentHandlerService instalmentHandlerService = null;

	public HrmsCommonMasterHandlerService getHrmscommonmasterHandlerService() {
		return hrmsCommonMasterHandlerService;
	}

	public void setHrmsCommonMasterHandlerService(
			HrmsCommonMasterHandlerService hrmscomMasterHandlerService) {
		this.hrmsCommonMasterHandlerService = hrmscomMasterHandlerService;
	}

	public InstalmentHandlerService getInstalmentHandlerService() {
		return instalmentHandlerService;
	}

	public void setInstalmentHandlerService(
			InstalmentHandlerService instalmentHandlerService) {
		this.instalmentHandlerService = instalmentHandlerService;
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

	// *************************************** Start For Instalment Master by
	// Rajendra ******************************************//

	public ModelAndView showInstalmentMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = instalmentHandlerService.showInstalmentMasterJsp();
		String jsp = HR_INSTALMENT_MASTER_JSP;
		jsp += ".jsp";
		title = "Instalment Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchInstalmentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		String instalmentCode = "";
		String instalmentName = "";
		String searchField = "";
		int searchId = 1;
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instalmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instalmentName = request.getParameter(SEARCH_NAME);
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
			instalmentCode = searchField;
			instalmentName = null;
		} else {
			instalmentName = searchField;
			instalmentCode = null;
		}

		map = instalmentHandlerService.searchInstalmentMaster(instalmentCode,
				instalmentName);

		String jsp = HR_INSTALMENT_MASTER_JSP;
		jsp += ".jsp";
		title = "Instalment Master";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInstalmentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HrMasInstalment hrMasInstalment = new HrMasInstalment();

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = null;

		int hospitalId = 0;

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

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY((request
					.getParameter(CHANGED_DATE)));
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
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);

		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List instalmentCodeList = new ArrayList();
		List instalmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			instalmentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}

		if (listMap.get("duplicateGeneralNameList") != null) {
			instalmentNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if (instalmentCodeList.size() == 0 || instalmentCodeList == null) {

			hrMasInstalment.setInstalmentCode(code);
			hrMasInstalment.setInstalmentName(name);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstalment.setCompany(masHospital);

			hrMasInstalment.setStatus("y");
			hrMasInstalment.setLastChgBy(changedBy);
			hrMasInstalment.setLastChgDate(currentDate);
			hrMasInstalment.setLastChgTime(currentTime);
			successfullyAdded = instalmentHandlerService
					.addInstalmentMaster(hrMasInstalment);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((instalmentCodeList.size() != 0 || instalmentCodeList != null)
				|| (instalmentNameList.size() != 0)
				|| instalmentNameList != null) {
			if ((instalmentCodeList.size() != 0 || instalmentCodeList != null)
					&& (instalmentNameList.size() == 0 || instalmentNameList == null)) {

				message = "Instalment Code already exists.";
			} else if ((instalmentNameList.size() != 0 || instalmentNameList != null)
					&& (instalmentCodeList.size() == 0 || instalmentCodeList == null)) {

				message = "Instalment Name  already exists.";
			} else if ((instalmentCodeList.size() != 0 || instalmentCodeList != null)
					&& (instalmentNameList.size() != 0 || instalmentNameList != null)) {
				message = "Instalment Code and Instalment Description already exist.";
			}
		}
		url = "hms/hrms/instalmentMaster?method=showInstalmentMasterJsp";
		try {
			map = instalmentHandlerService.showInstalmentMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = HR_INSTALMENT_MASTER_JSP;
		jsp += ".jsp";
		title = "Add Instalment Master";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editInstalmentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		session = request.getSession();

		String instalmentCode = "";
		String instalmentName = "";
		int hospitalId = 0;
		int instalmentId = 0;

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
			instalmentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instalmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instalmentName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", instalmentId);
		generalMap.put("code", instalmentCode);
		generalMap.put("name", instalmentName);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = hrmsCommonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInstalmentMasterList = (List) listMap
				.get("duplicateGeneralCodeList");
		boolean dataUpdated = false;
		if (existingInstalmentMasterList.size() == 0) {
			dataUpdated = instalmentHandlerService
					.editInstalmentMaster(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingInstalmentMasterList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hrms/instalmentMaster?method=showInstalmentMasterJsp";
		try {
			map = instalmentHandlerService.showInstalmentMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTALMENT_MASTER_JSP;
		title = "Edit Instalment Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteInstalmentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int instalmentId = 0;
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
			instalmentId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = instalmentHandlerService.deleteInstalmentMaster(
				instalmentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hrms/instalmentMaster?method=showInstalmentMasterJsp";

		try {
			map = instalmentHandlerService.showInstalmentMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_INSTALMENT_MASTER_JSP;
		title = "Delete Instalment Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

}
