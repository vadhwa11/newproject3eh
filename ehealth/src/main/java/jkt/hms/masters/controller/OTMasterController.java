package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ANESTHESIA_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_NAME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DAYS;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.OT_CHANGE_DETAILS;
import static jkt.hms.util.RequestConstants.OT_DISTRIBUTION_JSP;
import static jkt.hms.util.RequestConstants.OT_ID;
import static jkt.hms.util.RequestConstants.OT_JSP;
import static jkt.hms.util.RequestConstants.OT_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.START_DATE;
import static jkt.hms.util.RequestConstants.TIME;
import static jkt.hms.util.RequestConstants.TYPE_OF_REG;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.OTMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OTMasterController extends MultiActionController {
	OTMasterHandlerService otMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyCode = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoName = "";
	String pojoPropertyName = "";
	String currentDate = "";
	String currentTime = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	// --------------------------------------Anesthesia-----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showAnesthesiaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = (Map<String, Object>) otMasterHandlerService.showAnesthesiaJsp();
		@SuppressWarnings("unused")
		ArrayList searchAnesthesiaList = (ArrayList) map
				.get("searchAnesthesiaList");
		jsp = ANESTHESIA_JSP;
		jsp += ".jsp";
		title = "Anesthesia";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAnesthesia(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String anesthesiaCode = null;
		String anesthesiaName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			anesthesiaCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			anesthesiaName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
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
			anesthesiaCode = searchField;
			anesthesiaName = null;

		} else {
			anesthesiaCode = null;
			anesthesiaName = searchField;
		}
		map = otMasterHandlerService.searchAnesthesia(anesthesiaCode,
				anesthesiaName);
		jsp = ANESTHESIA_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("anesthesiaCode", anesthesiaCode);
		map.put("anesthesiaName", anesthesiaName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAnesthesia(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAnesthesia masAnesthesia = new MasAnesthesia();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session =  request.getSession();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			
			
		}*/
		changedBy = (Integer) session.getAttribute("userId");
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List anesthesiaCodeList = new ArrayList();
		List anesthesiaNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			anesthesiaCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			anesthesiaNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((anesthesiaCodeList.size() == 0 || anesthesiaCodeList == null)
				&& (anesthesiaNameList.size() == 0 || anesthesiaNameList == null)) {
			masAnesthesia.setAnesthesiaCode(code);
			masAnesthesia.setAnesthesiaName(name);
			masAnesthesia.setStatus("y");
			
			Users users = new Users();
			users.setId(changedBy);
			masAnesthesia.setLastChgBy(users);
			
			masAnesthesia.setLastChgDate(currentDate);
			masAnesthesia.setLastChgTime(currentTime);
			successfullyAdded = otMasterHandlerService
					.addAnesthesia(masAnesthesia);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null)
				|| (anesthesiaNameList.size() != 0)
				|| anesthesiaNameList != null) {
			if ((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null)
					&& (anesthesiaNameList.size() == 0 || anesthesiaNameList == null)) {
				message = "Anesthesia Code  already exists.";
			} else if ((anesthesiaNameList.size() != 0 || anesthesiaNameList != null)
					&& (anesthesiaCodeList.size() == 0 || anesthesiaCodeList == null)) {
				message = "Anesthesia Name already exists.";
			} else if ((anesthesiaCodeList.size() != 0 || anesthesiaCodeList != null)
					&& (anesthesiaNameList.size() != 0 || anesthesiaNameList != null)) {
				message = "Anesthesia Code and Anesthesia Name already exist.";
			}
		}
		url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
		try {
			map = otMasterHandlerService.showAnesthesiaJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANESTHESIA_JSP;
		title = "Add Anesthesia";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAnesthesia(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session =  request.getSession();
		String anesthesiaCode = "";
		String anesthesiaName = "";
		int anesthesiaId = 0;
		int changedBy = 0;
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			anesthesiaId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			anesthesiaCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			anesthesiaName = request.getParameter(SEARCH_NAME);
		}
		changedBy = (Integer) session.getAttribute("userId");
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

		generalMap.put("id", anesthesiaId);
		generalMap.put("anesthesiaCode", anesthesiaCode);
		generalMap.put("name", anesthesiaName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAnesthesiaNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAnesthesiaNameList.size() == 0) {
			dataUpdated = otMasterHandlerService
					.editAnesthesiaToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data Updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAnesthesiaNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
		try {
			map = otMasterHandlerService.showAnesthesiaJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANESTHESIA_JSP;
		title = "update Anesthesia";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAnesthesia(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int anesthesiaId = 0;
		String message = null;
		HttpSession session =  request.getSession();
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			anesthesiaId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = otMasterHandlerService.deleteAnesthesia(anesthesiaId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/otMaster?method=showAnesthesiaJsp";
		try {
			map = otMasterHandlerService.showAnesthesiaJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ANESTHESIA_JSP;
		title = "delete Anesthesia";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ****************************************** Start Of OT Master by Mansi
	// ****************************//

	public ModelAndView searchOt(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String otCode = null;
		String otName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			otCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			otName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
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
			otCode = searchField;
			otName = null;

		} else {
			otCode = null;
			otName = searchField;
		}
		map = otMasterHandlerService.searchOt(otCode, otName);

		jsp = OT_JSP;

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("otCode", otCode);
		map.put("otName", otName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOtJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = otMasterHandlerService.showOtJsp();
		String jsp = OT_JSP;
		jsp += ".jsp";
		title = "Ot";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasOt ot = new MasOt();
		HttpSession session =  request.getSession();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		changedBy = (Integer) session.getAttribute("userId");
		
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List otCodeList = new ArrayList();
		List otNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			otCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			otNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((otCodeList.size() == 0 || otCodeList == null)
				&& (otNameList.size() == 0 || otNameList == null)) {
			ot.setOtCode(code);
			ot.setOtName(name);

			ot.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			ot.setLastChgBy(users);
			ot.setLastChgDate(currentDate);
			ot.setLastChgTime(currentTime);
			successfullyAdded = otMasterHandlerService.addOt(ot);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((otCodeList.size() != 0 || otCodeList != null)
				|| (otNameList.size() != 0) || otNameList != null) {
			if ((otCodeList.size() != 0 || otCodeList != null)
					&& (otNameList.size() == 0 || otNameList == null)) {

				message = "Ot Code  already exists.";
			} else if ((otNameList.size() != 0 || otNameList != null)
					&& (otCodeList.size() == 0 || otCodeList == null)) {

				message = "Ot Name already exists.";
			} else if ((otCodeList.size() != 0 || otCodeList != null)
					&& (otNameList.size() != 0 || otNameList != null)) {

				message = "Ot Code and Ot Name already exist.";
			}
		}

		try {
			map = otMasterHandlerService.showOtJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_JSP;
		title = "Add OPD Ot";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOt(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session =  request.getSession();
		String otCode = "";
		String otName = "";
		int otId = 0;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			otId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			otCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			otName = request.getParameter(SEARCH_NAME);
		}
		changedBy = (Integer) session.getAttribute("userId");
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", otId);
		generalMap.put("otCode", otCode);
		generalMap.put("name", otName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOtNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOtNameList.size() == 0) {
			dataUpdated = otMasterHandlerService.editOtToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingOtNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOtJsp";

		try {
			map = otMasterHandlerService.showOtJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_JSP;
		title = "update OPD Ot";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int otId = 0;
		String message = null;
		HttpSession session =  request.getSession();
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			otId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = otMasterHandlerService.deleteOt(otId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOtJsp";

		try {
			map = otMasterHandlerService.showOtJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_JSP;
		title = "delete OPD Ot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOtDistributionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = otMasterHandlerService.showOtDistributionJsp();
		String jsp = OT_DISTRIBUTION_JSP;
		jsp += ".jsp";
		title = "Ot Distribution";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOtDistribution(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasOtDistribution masOtDistribution = new MasOtDistribution();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session =  request.getSession();
		int changedBy = 0;
		int departmentId = 0;
		int otId = 0;
		String days = "";
		Date validityStartDate = new Date();
		Map<String, Object> listMap = new HashMap<String, Object>();
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(OT_ID) != null) {
			otId = Integer.parseInt(request.getParameter(OT_ID));
		}
		if (request.getParameter(DAYS) != null) {
			days = request.getParameter(DAYS);
		}

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			validityStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		changedBy = (Integer) session.getAttribute("userId");
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("otId", otId);
		generalMap.put("days", days);
		generalMap.put("departmentId", departmentId);
		generalMap.put("validityStartDate", validityStartDate);
		listMap = otMasterHandlerService.checkForExistingDaysOt(generalMap);
		List duplicateDaysOtList = new ArrayList();

		if (listMap.get("duplicateDaysOtList") != null) {
			duplicateDaysOtList = (List) listMap.get("duplicateDaysOtList");
		}

		boolean successfullyAdded = false;
		if ((duplicateDaysOtList.size() == 0 || duplicateDaysOtList == null))

		{
			masOtDistribution.setDays(days);

			masOtDistribution.setValidityStartDate(validityStartDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masOtDistribution.setDepartment(masDepartment);

			MasOt masOt = new MasOt();
			masOt.setId(otId);
			masOtDistribution.setOt(masOt);

			masOtDistribution.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			masOtDistribution.setLastChgBy(users);
			masOtDistribution.setLastChgDate(currentDate);
			masOtDistribution.setLastChgTime(currentTime);
			successfullyAdded = otMasterHandlerService
					.addOtDistribution(masOtDistribution);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateDaysOtList.size() != 0) {

			message = "Ot Name , Days , Department Name and Validity Start Date already exist.";
		}

		try {
			map = otMasterHandlerService.showOtDistributionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = OT_DISTRIBUTION_JSP;
		title = "Add Ot Distribution";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOtDistribution(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session =  request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		int departmentId = 0;
		int otId = 0;
		String days = "";
		int otDistributionId = 0;
		Date validityStartDate = new Date();

		if (request.getParameter(COMMON_ID) != null) {
			otDistributionId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(OT_ID) != null) {
			otId = Integer.parseInt(request.getParameter(OT_ID));
		}
		if (request.getParameter(DAYS) != null) {
			days = request.getParameter(DAYS);
		}

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {

			validityStartDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(START_DATE));
		}
		changedBy = (Integer) session.getAttribute("userId");

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", otDistributionId);
		generalMap.put("days", days);
		generalMap.put("otId", otId);
		generalMap.put("validityStartDate", validityStartDate);
		generalMap.put("departmentId", departmentId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = otMasterHandlerService.checkForExistingDaysOt(generalMap);
		List duplicateDaysOtList = new ArrayList();

		if (listMap.get("duplicateDaysOtList") != null) {
			duplicateDaysOtList = (List) listMap.get("duplicateDaysOtList");
		}

		boolean dataUpdated = false;
		if ((duplicateDaysOtList.size() == 0 || duplicateDaysOtList == null)) {
			dataUpdated = otMasterHandlerService.editOtDistribution(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (duplicateDaysOtList.size() != 0) {

			message = "Ot Name , Days , Department Name and Validity Start Date already exist.";
		}

		try {
			map = otMasterHandlerService.showOtDistributionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_DISTRIBUTION_JSP;
		title = "Edit Ot Distribution";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOtDistribution(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int otDistributionId = 0;
		String message = null;
		HttpSession session =  request.getSession();
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			otDistributionId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = otMasterHandlerService.deleteOtDistribution(
				otDistributionId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = otMasterHandlerService.showOtDistributionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_DISTRIBUTION_JSP;
		title = "Delete Ot Distribution";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOtDistribution(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String oTName = "";
		String days = "";
		String searchField = null;

		if (request.getParameter(OT_NAME) != null
				&& !(request.getParameter(OT_NAME).equals(""))) {
			oTName = request.getParameter(OT_NAME);
		}
		if (request.getParameter(DAYS) != null
				&& !(request.getParameter(DAYS).equals(""))) {
			days = request.getParameter(DAYS);
		}
		int searchRadio = 1;
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
			oTName = searchField;
			days = null;
		} else {
			oTName = null;
			days = searchField;
		}
		map = otMasterHandlerService.searchOtDistribution(oTName, days);

		jsp = OT_DISTRIBUTION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("oTName", oTName);
		map.put("days", days);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------- Master OT Charge Details
	// -------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showOtMasChargeDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = otMasterHandlerService.showOtMasChargeDetailsJsp();
		String jsp = OT_CHANGE_DETAILS;
		jsp += ".jsp";
		title = "Ot Charge Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOtMasChargeDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OtMasChargeDetails masChargeDetails = new OtMasChargeDetails();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session =  request.getSession();
		int changedBy = 0;
		int chargeCodeId = 0;
		int otId=0;
		int otChargeType = 0;
		String approxDuration = "";

		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}

		if (request.getParameter("otName") != null
				&& !(request.getParameter("otName").equals(""))) {
			otId = Integer.parseInt(request
					.getParameter("otName"));
		}

		if (request.getParameter(TYPE_OF_REG) != null &&  !(request.getParameter(TYPE_OF_REG).equals("0"))) {
			otChargeType = Integer.parseInt(request.getParameter(TYPE_OF_REG));
		}

		if (request.getParameter(TIME) != null) {
			approxDuration = request.getParameter(TIME);
		}

		changedBy = (Integer) session.getAttribute("userId");
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
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("chargeCodeId", chargeCodeId);
		generalMap.put("otChargeType", otChargeType);
		generalMap.put("approxDuration", approxDuration);
		generalMap.put("otId", otId);
		
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = otMasterHandlerService
				.checkForExistingChargeCodeId(generalMap);
		List duplicateChargeCodeIdList = new ArrayList();

		if (listMap.get("duplicateChargeCodeIdList") != null) {
			duplicateChargeCodeIdList = (List) listMap
					.get("duplicateChargeCodeIdList");
		}
		if ((duplicateChargeCodeIdList.size() == 0 || duplicateChargeCodeIdList == null))

		{
			boolean successfullyAdded = false;
			
			MasChargeType masChargeType=new MasChargeType();
			masChargeType.setId(otChargeType);
			masChargeDetails.setChargeType(masChargeType);
			
			if (chargeCodeId != 0) {
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(chargeCodeId);
				masChargeDetails.setChargeCode(masChargeCode);
			}

			masChargeDetails.setApproxDuration(approxDuration);
			MasOt masOt=new MasOt();
			masOt.setId(otId);
			masChargeDetails.setOt(masOt);
			masChargeDetails.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			masChargeDetails.setLastChgBy(users);
			masChargeDetails.setLastChgDate(currentDate);
			masChargeDetails.setLastChgTime(currentTime);
			successfullyAdded = otMasterHandlerService
					.addOtMasChargeDetails(masChargeDetails);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (duplicateChargeCodeIdList.size() != 0) {

			message = "Charge Code Name already exists for same OT.";
		}

		try {
			map = otMasterHandlerService.showOtMasChargeDetailsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = OT_CHANGE_DETAILS;
		title = "Add Ot Master Charge Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOtMasChargeDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session =  request.getSession();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		int otMasChargeDetailsId = 0;
		String chargeCodeName = "";
		int otChargeType = 0;
		String approxDuration = "";
		int otId=0;
		int chargeCodeId=0;
		if (request.getParameter(CHARGE_CODE_NAME) != null) {
			chargeCodeName = request.getParameter(CHARGE_CODE_NAME);
		}


if(request.getParameter("otName")!=null){

	otId=Integer.parseInt(request.getParameter("otName"));
}



		if (request.getParameter(TYPE_OF_REG) != null) {
			otChargeType = Integer.parseInt(request.getParameter(TYPE_OF_REG));
		}

		if (request.getParameter(TIME) != null) {
			approxDuration = request.getParameter(TIME);
		}

		if (request.getParameter(COMMON_ID) != null) {
			otMasChargeDetailsId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		changedBy = (Integer) session.getAttribute("userId");

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", otMasChargeDetailsId);
		generalMap.put("approxDuration", approxDuration);
		generalMap.put("otChargeType", otChargeType);
		generalMap.put("otId",otId);
		generalMap.put("chargeCodeName", chargeCodeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = otMasterHandlerService
				.checkForExistingChargeCodeName(generalMap);
		List duplicateChargeCodeNameList = (List) listMap
				.get("duplicateChargeCodeNameList");
		boolean dataUpdated = false;
		if (duplicateChargeCodeNameList.size() == 0) {
			dataUpdated = otMasterHandlerService
					.editOtMasChargeDetails(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (duplicateChargeCodeNameList.size() > 0) {
			message = "Charge Code Name, OT Charge Type, OT Name and Approx. Duration exist.";
		}

		try {
			map = otMasterHandlerService.showOtMasChargeDetailsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_CHANGE_DETAILS;
		title = "Edit Ot Charge Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOtMasChargeDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int otMasChargeDetailsId = 0;
		String message = null;
		HttpSession session =  request.getSession();
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			otMasChargeDetailsId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = otMasterHandlerService.deleteOtMasChargeDetails(
				otMasChargeDetailsId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = otMasterHandlerService.showOtMasChargeDetailsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_CHANGE_DETAILS;
		title = "Delete Ot Charge Details";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOtMasChargeDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeCodeName = "";

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				chargeCodeName = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = otMasterHandlerService.searchOtMasChargeDetails(chargeCodeName);

		jsp = OT_CHANGE_DETAILS;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeCodeName", chargeCodeName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getChageCodeByAutocomplete(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------------------------------------------------------------------------
		String chargeCodeNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			chargeCodeNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(chargeCodeNameField) != null) {
			autoHint = (request.getParameter(chargeCodeNameField));
		}
		dataMap.put("autoHint", autoHint);
		map = otMasterHandlerService.getChageCodeByAutocomplete(dataMap);
		jsp = "resultOtChargeCodeName";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillChargeCodeNameInGrid(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();

		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = otMasterHandlerService.fillChargeCodeNameInGrid(dataMap);
		if (map.get("masChargeCodeList") != null) {
			masChargeCodeList = (List) map.get("masChargeCodeList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasChargeCode masChargeCode : masChargeCodeList) {
				sb.append("<item>");
				sb.append("<id>" + masChargeCode.getId() + "</id>");
				sb.append("</item>");
			}
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

	// ---------------------------------------------------------------------------------------------------------
	public OTMasterHandlerService getOtMasterHandlerService() {
		return otMasterHandlerService;
	}

	public void setOtMasterHandlerService(
			OTMasterHandlerService otMasterHandlerService) {
		this.otMasterHandlerService = otMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}