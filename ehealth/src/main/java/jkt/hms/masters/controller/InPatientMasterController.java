package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.BABY_STATUS_JSP;
import static jkt.hms.util.RequestConstants.BED_STATUS_JSP;
import static jkt.hms.util.RequestConstants.BODY_PART_JSP;
import static jkt.hms.util.RequestConstants.CARE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DELIVERY_JSP;
import static jkt.hms.util.RequestConstants.DESCRIPTION;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_CATEGORY;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_ID;
import static jkt.hms.util.RequestConstants.DISCHARGE_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.DISCHARGE_STATUS_JSP;
import static jkt.hms.util.RequestConstants.DISPOSED_TO_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INJURY_NATURE_JSP;
import static jkt.hms.util.RequestConstants.LABEL_DATA_TYPE;
import static jkt.hms.util.RequestConstants.LOCAL_UNIT;
import static jkt.hms.util.RequestConstants.NEONATAL_PROBLEM_JSP;
import static jkt.hms.util.RequestConstants.ORDER_NO;
import static jkt.hms.util.RequestConstants.OUTSIDE_TREATMENT_JSP;
import static jkt.hms.util.RequestConstants.PERINEUM_MAINTENANCE_JSP;
import static jkt.hms.util.RequestConstants.POST_CODE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.UNIT_ADDRESS;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.DischargeItems;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.MasAmbulance;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasDelivery;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHouseKeepingFrequency;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasNeonatalProblem;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasOutsideTreatment;
import jkt.hms.masters.business.MasPerineumMaintenance;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWasteCategory;
import jkt.hms.masters.business.MasWasteContainer;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasHouseKeeping;
import jkt.hms.masters.business.OtMasUnitDay;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.InPatientMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.mapping.Array;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InPatientMasterController extends MultiActionController {

	InPatientMasterHandlerService inPatientMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String currentDate = "";
	String currentTime = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String userName = "";

	// ------------------------------------------ Bed Status
	// -------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBedStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = (Map<String, Object>) inPatientMasterHandlerService
				.showBedStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchBedStatusList = (ArrayList) map
				.get("searchBedStatusList");
		jsp = BED_STATUS_JSP;
		jsp += ".jsp";
		title = "Bed Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String bedStatusCode = null;
		String bedStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bedStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedStatusName = request.getParameter(SEARCH_NAME);
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
			bedStatusCode = searchField;
			bedStatusName = null;
		} else {
			bedStatusCode = null;
			bedStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchBedStatus(bedStatusCode,
				bedStatusName);
		jsp = BED_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bedStatusCode", bedStatusCode);
		map.put("bedStatusName", bedStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBedStatus masBedStatus = new MasBedStatus();
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		String changedBy = "";
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
		List bedStatusCodeList = new ArrayList();
		List bedStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bedStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bedStatusNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bedStatusCodeList.size() == 0 || bedStatusCodeList == null)
				&& (bedStatusNameList.size() == 0 || bedStatusNameList == null)) {
			masBedStatus.setBedStatusCode(code);
			masBedStatus.setBedStatusName(name);
			masBedStatus.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masBedStatus.setLastChgBy(users);
			masBedStatus.setLastChgDate(currentDate);
			masBedStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBedStatus(masBedStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
				|| (bedStatusNameList.size() != 0) || bedStatusNameList != null) {
			if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
					&& (bedStatusNameList.size() == 0 || bedStatusNameList == null)) {
				message = "Bed Status Code  already exists.";
			} else if ((bedStatusNameList.size() != 0 || bedStatusNameList != null)
					&& (bedStatusCodeList.size() == 0 || bedStatusCodeList == null)) {
				message = "Bed Status Name already exists.";
			} else if ((bedStatusCodeList.size() != 0 || bedStatusCodeList != null)
					&& (bedStatusNameList.size() != 0 || bedStatusNameList != null)) {
				message = "Bed Status Code and Bed Status Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "Add BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		String bedStatusCode = "";
		String bedStatusName = "";
		int bedStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		int userId=(Integer) session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bedStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedStatusName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", bedStatusId);
		generalMap.put("bedStatusCode", bedStatusCode);
		generalMap.put("name", bedStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBedStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBedStatusNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editBedStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingBedStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "update BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		
		int bedStatusId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteBedStatus(
				bedStatusId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBedStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_STATUS_JSP;
		title = "delete BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------- Injury Nature
	// -------------------------------------------------

	public ModelAndView searchInjuryNature(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String injuryNatureCode = null;
		String injuryNatureName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			injuryNatureCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			injuryNatureName = request.getParameter(SEARCH_NAME);
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
			injuryNatureCode = searchField;
			injuryNatureName = null;

		} else {
			injuryNatureCode = null;
			injuryNatureName = searchField;
		}
		map = inPatientMasterHandlerService.searchInjuryNature(
				injuryNatureCode, injuryNatureName);

		jsp = INJURY_NATURE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("injuryNatureCode", injuryNatureCode);
		map.put("injuryNatureName", injuryNatureName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showInjuryNatureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showInjuryNatureJsp();
		@SuppressWarnings("unused")
		ArrayList searchInjuryNatureList = (ArrayList) map
				.get("searchInjuryNatureList");
		jsp = INJURY_NATURE_JSP;
		jsp += ".jsp";
		title = "InjuryNature";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasInjuryNature masInjuryNature = new MasInjuryNature();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List injuryNatureCodeList = new ArrayList();
		List injuryNatureNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			injuryNatureCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			injuryNatureNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((injuryNatureNameList.size() == 0 || injuryNatureNameList == null)
				&& (injuryNatureNameList.size() == 0 || injuryNatureNameList == null)) {
			masInjuryNature.setInjuryNatureCode(code);
			masInjuryNature.setInjuryNatureName(name);
			masInjuryNature.setStatus("y");
			
			Users users=new Users();
			users.setId(changedBy);
			masInjuryNature.setLastChgBy(users);
			
			masInjuryNature.setLastChgDate(currentDate);
			masInjuryNature.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addInjuryNature(masInjuryNature);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
				|| (injuryNatureNameList.size() != 0)
				|| injuryNatureNameList != null) {

			if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
					&& (injuryNatureNameList.size() == 0 || injuryNatureNameList == null)) {

				message = "Injury Nature Code  already exists.";
			} else if ((injuryNatureNameList.size() != 0 || injuryNatureNameList != null)
					&& (injuryNatureCodeList.size() == 0 || injuryNatureCodeList == null)) {

				message = "Injury Nature Name already exists.";
			} else if ((injuryNatureCodeList.size() != 0 || injuryNatureCodeList != null)
					&& (injuryNatureNameList.size() != 0 || injuryNatureNameList != null)) {

				message = "Injury Nature Code and Injury Nature Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Add Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String injuryNatureCode = "";
		String injuryNatureName = "";
		int injuryNatureId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		injuryNatureCode = (String) session.getAttribute("injuryNatureCode");
		injuryNatureName = (String) session.getAttribute("injuryNatureName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			injuryNatureId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			injuryNatureCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			injuryNatureName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", injuryNatureId);
		generalMap.put("injuryNatureCode", injuryNatureCode);
		generalMap.put("name", injuryNatureName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInjuryNatureNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingInjuryNatureNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editInjuryNatureToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingInjuryNatureNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Edit Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteInjuryNature(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int injuryNatureId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			injuryNatureId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteInjuryNature(
				injuryNatureId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showInjuryNatureJsp";
		try {
			map = inPatientMasterHandlerService.showInjuryNatureJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INJURY_NATURE_JSP;
		title = "Delete Injury Nature";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------- Baby Status
	// -----------------------------------------------
	public ModelAndView searchBabyStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String babyStatusCode = null;
		String babyStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			babyStatusCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			babyStatusName = request.getParameter(SEARCH_NAME);
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
			babyStatusCode = searchField;
			babyStatusName = null;
		} else {
			babyStatusCode = null;
			babyStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchBabyStatus(babyStatusCode,
				babyStatusName);
		jsp = BABY_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("babyStatusCode", babyStatusCode);
		map.put("babyStatusName", babyStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBabyStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showBabyStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchBabyStatusList = (ArrayList) map
				.get("searchBabyStatusList");
		jsp = BABY_STATUS_JSP;
		jsp += ".jsp";
		title = "BabyStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBabyStatus masBabyStatus = new MasBabyStatus();

		String changedBy = "";
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

		List babyStatusCodeList = new ArrayList();
		List babyStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			babyStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			babyStatusNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;
		if ((babyStatusNameList.size() == 0 || babyStatusNameList == null)
				&& (babyStatusNameList.size() == 0 || babyStatusNameList == null)) {
			masBabyStatus.setBabyStatusCode(code);
			masBabyStatus.setBabyStatusName(name);
			masBabyStatus.setStatus("y");
			masBabyStatus.setLastChgBy(changedBy);
			masBabyStatus.setLastChgDate(currentDate);
			masBabyStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBabyStatus(masBabyStatus);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
				|| (babyStatusNameList.size() != 0)
				|| babyStatusNameList != null) {

			if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
					&& (babyStatusNameList.size() == 0 || babyStatusNameList == null)) {

				message = "Baby Status Code  already exists.";
			} else if ((babyStatusNameList.size() != 0 || babyStatusNameList != null)
					&& (babyStatusCodeList.size() == 0 || babyStatusCodeList == null)) {

				message = "Baby Status Name already exists.";
			} else if ((babyStatusCodeList.size() != 0 || babyStatusCodeList != null)
					&& (babyStatusNameList.size() != 0 || babyStatusNameList != null)) {

				message = "Baby Status Code and Baby Status Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";

		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Add Baby Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String babyStatusCode = "";
		String babyStatusName = "";
		int babyStatusId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			babyStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			babyStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			babyStatusName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", babyStatusId);
		generalMap.put("babyStatusCode", babyStatusCode);
		generalMap.put("name", babyStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBabyStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBabyStatusNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editBabyStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingBabyStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";

		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Edit Baby Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteBabyStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int babyStatusId = 0;
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
			babyStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteBabyStatus(
				babyStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBabyStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBabyStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BABY_STATUS_JSP;
		title = "Delete Baby Status";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------ Delivery
	// ------------------------------------------
	public ModelAndView searchDelivery(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deliveryCode = null;
		String deliveryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deliveryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deliveryName = request.getParameter(SEARCH_NAME);
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
			deliveryCode = searchField;
			deliveryName = null;

		} else {
			deliveryCode = null;
			deliveryName = searchField;
		}

		map = inPatientMasterHandlerService.searchDelivery(deliveryCode,
				deliveryName);

		jsp = DELIVERY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deliveryCode", deliveryCode);
		map.put("deliveryName", deliveryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeliveryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = inPatientMasterHandlerService.showDeliveryJsp();
		String jsp = DELIVERY_JSP;
		jsp += ".jsp";
		title = "Delivery";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDelivery(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDelivery masDelivery = new MasDelivery();
		HttpSession session = request.getSession();
		int changedBy = (Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);

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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List deliveryCodeList = new ArrayList();
		List deliveryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			deliveryCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			deliveryNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((deliveryNameList.size() == 0 || deliveryNameList == null)
				&& (deliveryNameList.size() == 0 || deliveryNameList == null)) {
			masDelivery.setDeliveryCode(code);
			masDelivery.setDeliveryName(name);
			masDelivery.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masDelivery.setLastChgBy(users);
			masDelivery.setLastChgDate(currentDate);
			masDelivery.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDelivery(masDelivery);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
				|| (deliveryNameList.size() != 0) || deliveryNameList != null) {
			if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
					&& (deliveryNameList.size() == 0 || deliveryNameList == null)) {
				message = "Delivery Code  already exists.";
			} else if ((deliveryNameList.size() != 0 || deliveryNameList != null)
					&& (deliveryCodeList.size() == 0 || deliveryCodeList == null)) {

				message = "Delivery Name already exists.";
			} else if ((deliveryCodeList.size() != 0 || deliveryCodeList != null)
					&& (deliveryNameList.size() != 0 || deliveryNameList != null)) {

				message = "Delivery Code and Delivery Name already exist.";
			}
		}

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "Add Delivery";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDelivery(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deliveryCode = "";
		String deliveryName = "";
		int deliveryId = 0;
		int changedBy =(Integer)session.getAttribute(RequestConstants.USER_ID); 

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		deliveryCode = (String) session.getAttribute("deliveryCode");
		deliveryName = (String) session.getAttribute("deliveryName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			deliveryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deliveryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deliveryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", deliveryId);
		generalMap.put("deliveryCode", deliveryCode);
		generalMap.put("name", deliveryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDeliveryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDeliveryNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDeliveryToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDeliveryNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatient?method=showDeliveryJsp";

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "update Delivery";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteDelivery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deliveryId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy =(Integer)session.getAttribute(RequestConstants.USER_ID); 
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			deliveryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteDelivery(deliveryId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatient?method=showDeliveryJsp";

		try {
			map = inPatientMasterHandlerService.showDeliveryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DELIVERY_JSP;
		title = "delete Delivery";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------Care Type--------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showCareTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showCareTypeJsp();
		jsp = CARE_TYPE_JSP;
		jsp += ".jsp";
		title = "CareType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCareType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String careTypeCode = null;
		String careTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			careTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			careTypeName = request.getParameter(SEARCH_NAME);
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
			careTypeCode = searchField;
			careTypeName = null;

		} else {
			careTypeCode = null;
			careTypeName = searchField;
		}
		map = inPatientMasterHandlerService.searchCareType(careTypeCode,
				careTypeName);
		jsp = CARE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("careTypeCode", careTypeCode);
		map.put("careTypeName", careTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCareType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCareType masCareType = new MasCareType();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List careTypeCodeList = new ArrayList();
		List careTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			careTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			careTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((careTypeCodeList.size() == 0 || careTypeCodeList == null)
				&& (careTypeNameList.size() == 0 || careTypeNameList == null)) {
			masCareType.setCareTypeCode(code);
			masCareType.setCareTypeName(name);
			masCareType.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masCareType.setLastChgBy(users);
			masCareType.setLastChgDate(currentDate);
			masCareType.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addCareType(masCareType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
				|| (careTypeNameList.size() != 0) || careTypeNameList != null) {
			if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
					&& (careTypeNameList.size() == 0 || careTypeNameList == null)) {
				message = "Care Type Code  already exists.";
			} else if ((careTypeNameList.size() != 0 || careTypeNameList != null)
					&& (careTypeCodeList.size() == 0 || careTypeCodeList == null)) {
				message = "Care Type Name already exists.";
			} else if ((careTypeCodeList.size() != 0 || careTypeCodeList != null)
					&& (careTypeNameList.size() != 0 || careTypeNameList != null)) {
				message = "Care Type Code and Care Type Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Add CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editCareType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String careTypeCode = "";
		String careTypeName = "";
		int careTypeId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		careTypeCode = (String) session.getAttribute("careTypeCode");
		careTypeName = (String) session.getAttribute("careTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			careTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			careTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			careTypeName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", careTypeId);
		generalMap.put("careTypeCode", careTypeCode);
		generalMap.put("name", careTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCareTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCareTypeNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editCareTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCareTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Update CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteCareType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int careTypeId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			careTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteCareType(careTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showCareTypeJsp";
		try {
			map = inPatientMasterHandlerService.showCareTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CARE_TYPE_JSP;
		title = "Delete CareType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------Disposed
	// TO-------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDisposedToJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDisposedToJsp();
		jsp = DISPOSED_TO_JSP;
		jsp += ".jsp";
		title = "DisposedTo";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDisposedTo(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String disposedToCode = null;
		String disposedToName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposedToCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposedToName = request.getParameter(SEARCH_NAME);
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
			disposedToCode = searchField;
			disposedToName = null;

		} else {
			disposedToCode = null;
			disposedToName = searchField;
		}
		map = inPatientMasterHandlerService.searchDisposedTo(disposedToCode,
				disposedToName);
		jsp = DISPOSED_TO_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("disposedToCode", disposedToCode);
		map.put("disposedToName", disposedToName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		MasDisposedTo masDisposedTo = new MasDisposedTo();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Integer userId = (Integer) session.getAttribute("userId");
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		List disposedToCodeList = new ArrayList();
		List disposedToNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			disposedToCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			disposedToNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((disposedToCodeList.size() == 0 || disposedToCodeList == null)
				&& (disposedToNameList.size() == 0 || disposedToNameList == null)) {
			masDisposedTo.setDisposedToCode(code);
			masDisposedTo.setDisposedToName(name);
			masDisposedTo.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masDisposedTo.setLastChgBy(users);
			masDisposedTo.setLastChgDate(currentDate);
			masDisposedTo.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDisposedTo(masDisposedTo);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
				|| (disposedToNameList.size() != 0)
				|| disposedToNameList != null) {
			if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
					&& (disposedToNameList.size() == 0 || disposedToNameList == null)) {
				message = "DisposedTo Code  already exists.";
			} else if ((disposedToNameList.size() != 0 || disposedToNameList != null)
					&& (disposedToCodeList.size() == 0 || disposedToCodeList == null)) {
				message = "DisposedTo Name already exists.";
			} else if ((disposedToCodeList.size() != 0 || disposedToCodeList != null)
					&& (disposedToNameList.size() != 0 || disposedToNameList != null)) {
				message = "DisposedTo Code and DisposedTo Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Add DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String disposedToCode = "";
		String disposedToName = "";
		int disposedToId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		disposedToCode = (String) session.getAttribute("disposedToCode");
		disposedToName = (String) session.getAttribute("disposedToName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			disposedToId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposedToCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposedToName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", disposedToId);
		generalMap.put("disposedToCode", disposedToCode);
		generalMap.put("name", disposedToName);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDisposedToNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDisposedToNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDisposedToToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDisposedToNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Update DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteDisposedTo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int disposedToId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			disposedToId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteDisposedTo(
				disposedToId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDisposedToJsp";
		try {
			map = inPatientMasterHandlerService.showDisposedToJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSED_TO_JSP;
		title = "Delete DisposedTo";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------Body
	// Part---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBodyPartJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showBodyPartJsp();
		jsp = BODY_PART_JSP;
		jsp += ".jsp";
		title = "bodyPart";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBodyPart(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bodyPartCode = null;
		String bodyPartName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bodyPartCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bodyPartName = request.getParameter(SEARCH_NAME);
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
			bodyPartCode = searchField;
			bodyPartName = null;

		} else {
			bodyPartCode = null;
			bodyPartName = searchField;
		}
		map = inPatientMasterHandlerService.searchBodyPart(bodyPartCode,
				bodyPartName);
		jsp = BODY_PART_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bodyPartCode", bodyPartCode);
		map.put("bodyPartName", bodyPartName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBodyPart masBodyPart = new MasBodyPart();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List bodyPartCodeList = new ArrayList();
		List bodyPartNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bodyPartCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bodyPartNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bodyPartCodeList.size() == 0 || bodyPartCodeList == null)
				&& (bodyPartNameList.size() == 0 || bodyPartNameList == null)) {
			masBodyPart.setBodyPartCode(code);
			masBodyPart.setBodyPartName(name);
			masBodyPart.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masBodyPart.setLastChgBy(users);
			masBodyPart.setLastChgDate(currentDate);
			masBodyPart.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addBodyPart(masBodyPart);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
				|| (bodyPartNameList.size() != 0) || bodyPartNameList != null) {
			if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
					&& (bodyPartNameList.size() == 0 || bodyPartNameList == null)) {
				message = "BodyPart Code  already exists.";
			} else if ((bodyPartNameList.size() != 0 || bodyPartNameList != null)
					&& (bodyPartCodeList.size() == 0 || bodyPartCodeList == null)) {
				message = "BodyPart Name already exists.";
			} else if ((bodyPartCodeList.size() != 0 || bodyPartCodeList != null)
					&& (bodyPartNameList.size() != 0 || bodyPartNameList != null)) {
				message = "BodyPart Code and BodyPart Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showBedStatusJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Add BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String bodyPartCode = "";
		String bodyPartName = "";
		int bodyPartId = 0;
		
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bodyPartId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bodyPartCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bodyPartName = request.getParameter(SEARCH_NAME);
		}
	
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", bodyPartId);
		generalMap.put("bodyPartCode", bodyPartCode);
		generalMap.put("name", bodyPartName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBodyPartNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBodyPartNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editBodyPartToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBodyPartNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showBodyPartJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Update BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteBodyPart(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bodyPartId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bodyPartId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteBodyPart(bodyPartId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showBodyPartJsp";
		try {
			map = inPatientMasterHandlerService.showBodyPartJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BODY_PART_JSP;
		title = "Delete BodyPart";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------ Discharge Status
	// -------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDischargeStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeStatusJsp();
		jsp = DISCHARGE_STATUS_JSP;
		jsp += ".jsp";
		title = "DischargeStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeStatusCode = null;
		String dischargeStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dischargeStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeStatusName = request.getParameter(SEARCH_NAME);
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
			dischargeStatusCode = searchField;
			dischargeStatusName = null;

		} else {
			dischargeStatusCode = null;
			dischargeStatusName = searchField;
		}
		map = inPatientMasterHandlerService.searchDischargeStatus(
				dischargeStatusCode, dischargeStatusName);
		jsp = DISCHARGE_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dischargeStatusCode", dischargeStatusCode);
		map.put("dischargeStatusName", dischargeStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDischargeStatus masDischargeStatus = new MasDischargeStatus();
		HttpSession session=request.getSession();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List dischargeStatusCodeList = new ArrayList();
		List dischargeStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			dischargeStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			dischargeStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((dischargeStatusCodeList.size() == 0 || dischargeStatusCodeList == null)
				&& (dischargeStatusNameList.size() == 0 || dischargeStatusNameList == null)) {
			masDischargeStatus.setDischargeStatusCode(code);
			masDischargeStatus.setDischargeStatusName(name);
			masDischargeStatus.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masDischargeStatus.setLastChgBy(users);
			masDischargeStatus.setLastChgDate(currentDate);
			masDischargeStatus.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDischargeStatus(masDischargeStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
				|| (dischargeStatusNameList.size() != 0)
				|| dischargeStatusNameList != null) {
			if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
					&& (dischargeStatusNameList.size() == 0 || dischargeStatusNameList == null)) {
				message = "DS Code  already exists.";
			} else if ((dischargeStatusNameList.size() != 0 || dischargeStatusNameList != null)
					&& (dischargeStatusCodeList.size() == 0 || dischargeStatusCodeList == null)) {
				message = "DS Name already exists.";
			} else if ((dischargeStatusCodeList.size() != 0 || dischargeStatusCodeList != null)
					&& (dischargeStatusNameList.size() != 0 || dischargeStatusNameList != null)) {
				message = "DS Code and DS Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Add DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String dischargeStatusCode = "";
		String dischargeStatusName = "";
		int dischargeStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);


		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeStatusId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dischargeStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeStatusName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", dischargeStatusId);
		generalMap.put("dischargeStatusCode", dischargeStatusCode);
		generalMap.put("name", dischargeStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put(RequestConstants.USER_ID, userId);


		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDischargeStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDischargeStatusNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDischargeStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDischargeStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Update DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteDischargeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int dischargeStatusId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeStatusId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteDischargeStatus(
				dischargeStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeStatusJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_STATUS_JSP;
		title = "Delete DischargeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------DischargeItems-------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showDischargeItemsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeItemsJsp();
		jsp = DISCHARGE_ITEMS_JSP;
		jsp += ".jsp";
		title = "DischargeItems";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDischargeItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String itemCode = null;
		String itemName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemName = request.getParameter(SEARCH_NAME);
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
			itemCode = searchField;
			itemName = null;

		} else {
			itemCode = null;
			itemName = searchField;
		}
		map = inPatientMasterHandlerService.searchDischargeItems(itemCode,
				itemName);
		jsp = DISCHARGE_ITEMS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("itemCode", itemCode);
		map.put("itemName", itemName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		DischargeItems dischargeItems = new DischargeItems();
		HttpSession session=request.getSession();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);


		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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
		generalMap.put(RequestConstants.USER_ID, userId);

		
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List itemCodeList = new ArrayList();
		List itemNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			itemCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			itemNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((itemCodeList.size() == 0 || itemCodeList == null)
				&& (itemNameList.size() == 0 || itemNameList == null)) {
			dischargeItems.setItemCode(code);
			dischargeItems.setItemDesc(name);
			dischargeItems.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			dischargeItems.setLastChgBy(users);
			dischargeItems.setLastChgDate(currentDate);
			dischargeItems.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addDischargeItems(dischargeItems);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((itemCodeList.size() != 0 || itemCodeList != null)
				|| (itemNameList.size() != 0) || itemNameList != null) {
			if ((itemCodeList.size() != 0 || itemCodeList != null)
					&& (itemNameList.size() == 0 || itemNameList == null)) {
				message = "DischargeItem Code  already exists.";
			} else if ((itemNameList.size() != 0 || itemNameList != null)
					&& (itemCodeList.size() == 0 || itemCodeList == null)) {
				message = "DischargeItem Name already exists.";
			} else if ((itemCodeList.size() != 0 || itemCodeList != null)
					&& (itemNameList.size() != 0 || itemNameList != null)) {
				message = "DischargeItem Code and DischargeItem Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Add DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String itemCode = "";
		String itemName = "";
		int itemId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", itemId);
		generalMap.put("itemCode", itemCode);
		generalMap.put("name", itemName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put(RequestConstants.USER_ID, userId);


		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRelationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRelationNameList.size() == 0) {

			dataUpdated = inPatientMasterHandlerService
					.editDischargeItemsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingRelationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Update DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDischargeItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int itemId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteDischargeItems(
				itemId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeItemsJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeItemsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_JSP;
		title = "Delete DischargeItem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------DischargeItems
	// Category------------------------------------------------

	public ModelAndView showDischargeCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {		
		HttpSession session = request.getSession();
		map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		jsp += ".jsp";
		title = "DischargeItemCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addDischargeItemsCategory(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DischargeItemsCategory dischargeItemsCategory = new DischargeItemsCategory();
		int itemCode = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		int orderNo = 0;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
     int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		if (request.getParameter(DISCHARGE_ITEMS_ID) != null) {
			itemCode = Integer.parseInt(request
					.getParameter(DISCHARGE_ITEMS_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_CATEGORY) != null) {
			dischargeCategory = request.getParameter(DISCHARGE_ITEMS_CATEGORY);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = Integer.parseInt(request.getParameter(ORDER_NO));
		}
		if (request.getParameter(LABEL_DATA_TYPE) != null) {
			labelDataType = request.getParameter(LABEL_DATA_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;

		DischargeItems dischargeItems = new DischargeItems();
		dischargeItems.setId(itemCode);
		dischargeItemsCategory.setItemCode(dischargeItems);

		dischargeItemsCategory.setCategoryName(dischargeCategory);
		dischargeItemsCategory.setLabel(description);
		dischargeItemsCategory.setOrderno(orderNo);
		dischargeItemsCategory.setLabelDataType(labelDataType);
		dischargeItemsCategory.setStatus("y");
		Users users=new Users();
		users.setId(userId);
		dischargeItemsCategory.setLastChgBy(users);
		dischargeItemsCategory.setLastChgDate(changedDate);
		dischargeItemsCategory.setLastChgTime(changedTime);
		successfullyAdded = inPatientMasterHandlerService
				.addDischargeItemsCategory(dischargeItemsCategory);
		if (successfullyAdded == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "Add DischargeItemsCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDischargeItemsCategory(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DischargeItemsCategory dischargeItemsCategory = new DischargeItemsCategory();
		int itemCode = 0;
		int dischargeCateogryId = 0;
		String dischargeCategory = null;
		String description = null;
		String labelDataType = null;
		int orderNo = 0;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		HttpSession session = request.getSession();
	     int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeCateogryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_ID) != null) {
			itemCode = Integer.parseInt(request
					.getParameter(DISCHARGE_ITEMS_ID));
		}
		if (request.getParameter(DISCHARGE_ITEMS_CATEGORY) != null) {
			dischargeCategory = request.getParameter(DISCHARGE_ITEMS_CATEGORY);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = Integer.parseInt(request.getParameter(ORDER_NO));
		}
		if (request.getParameter(LABEL_DATA_TYPE) != null) {
			labelDataType = request.getParameter(LABEL_DATA_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
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
		generalMap.put("id", dischargeCateogryId);
		generalMap.put("itemCode", itemCode);
		generalMap.put("dischargeCategory", dischargeCategory);
		generalMap.put("description", description);
		generalMap.put("orderNo", orderNo);
		generalMap.put("labelDataType", labelDataType);
		generalMap.put("dietType", labelDataType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);
		boolean dataUpdated = false;
		dataUpdated = inPatientMasterHandlerService
				.editDischargeItemsCategory(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeCategoryJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "Add DischargeItemsCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDischargeItemsCategory(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeCateogryId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();

	     int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dischargeCateogryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService
				.deleteDischargeItemsCategory(dischargeCateogryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showDischargeCategoryJsp";
		try {
			map = inPatientMasterHandlerService.showDischargeCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		title = "delete DischargeItemCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDischargeItemsCategory(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeItem = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dischargeItem = request.getParameter(SEARCH_NAME);
		}
		map = inPatientMasterHandlerService
				.searchDischargeItemsCategory(dischargeItem);

		jsp = DISCHARGE_ITEMS_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dischargeItem", dischargeItem);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView showNeonatalProblemJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = (Map<String, Object>) inPatientMasterHandlerService
				.showNeonatalProblemJsp();
		@SuppressWarnings("unused")
		String jsp = "";
		jsp = NEONATAL_PROBLEM_JSP;
		jsp += ".jsp";
		title = "Neonatal Problem";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchNeonatalProblem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String neonatalProblemCode = null;
		String neonatalProblemName = null;
		String searchField = null;

		// if(request.getParameter(CODE) != null &&
		// !(request.getParameter(CODE).equals(""))){
		// neonatalProblemCode = request.getParameter(CODE);
		// }
		// if(request.getParameter(SEARCH_NAME) != null &&
		// !(request.getParameter(SEARCH_NAME).equals(""))){
		// neonatalProblemName = request.getParameter(SEARCH_NAME);
		// }

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
			neonatalProblemCode = searchField;
			neonatalProblemName = null;
		} else {
			neonatalProblemCode = null;
			neonatalProblemName = searchField;
		}
		map = inPatientMasterHandlerService.searchNeonatalProblem(
				neonatalProblemCode, neonatalProblemName);
		jsp = NEONATAL_PROBLEM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("neonatalProblemCode", neonatalProblemCode);
		map.put("neonatalProblemName", neonatalProblemName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addNeonatalProblem(HttpServletRequest request,
			HttpServletResponse response) {
		MasNeonatalProblem masNeonatalProblem = new MasNeonatalProblem();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List neonatalProblemCodeList = new ArrayList();
		List neonatalProblemNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			neonatalProblemCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			neonatalProblemNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((neonatalProblemCodeList.size() == 0 || neonatalProblemCodeList == null)
				&& (neonatalProblemNameList.size() == 0 || neonatalProblemNameList == null)) {
			masNeonatalProblem.setNeonatalProblemCode(code);
			masNeonatalProblem.setNeonatalProblemName(name);
			masNeonatalProblem.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masNeonatalProblem.setLastChgBy(users);
			masNeonatalProblem.setLastChgDate(currentDate);
			masNeonatalProblem.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addNeonatalProblem(masNeonatalProblem);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((neonatalProblemCodeList.size() != 0 || neonatalProblemCodeList != null)
				|| (neonatalProblemNameList.size() != 0)
				|| neonatalProblemNameList != null) {
			if ((neonatalProblemCodeList.size() != 0 || neonatalProblemCodeList != null)
					&& (neonatalProblemNameList.size() == 0 || neonatalProblemNameList == null)) {
				message = "neonatal Problem Code already exists.";
			} else if ((neonatalProblemNameList.size() != 0 || neonatalProblemNameList != null)
					&& (neonatalProblemCodeList.size() == 0 || neonatalProblemCodeList == null)) {
				message = "neonatal Problem Name already exists.";
			} else if ((neonatalProblemCodeList.size() != 0 || neonatalProblemCodeList != null)
					&& (neonatalProblemNameList.size() != 0 || neonatalProblemNameList != null)) {
				message = "neonatal Problem Code and neonatal Problem Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showNeonatalProblemJsp";
		try {
			map = inPatientMasterHandlerService.showNeonatalProblemJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = NEONATAL_PROBLEM_JSP;
		title = "Add neonatalproblem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editNeonatalProblem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String neonatalProblemCode = "";
		String neonatalProblemName = "";
		int neonatalProblemId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			neonatalProblemId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			neonatalProblemCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			neonatalProblemName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("neonatalProblemId", neonatalProblemId);
		generalMap.put("neonatalProblemCode", neonatalProblemCode);
		generalMap.put("neonatalProblemName", neonatalProblemName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingNeonatalProblemNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingNeonatalProblemNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editNeonatalProblem(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingNeonatalProblemNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showneonatalProblemJsp";
		try {
			map = inPatientMasterHandlerService.showNeonatalProblemJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = NEONATAL_PROBLEM_JSP;
		title = "update neonatalProblem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteNeonatalProblem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int neonatalProblemId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			neonatalProblemId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteNeonatalProblem(
				neonatalProblemId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showOutsideTreatmentsp";
		try {
			map = inPatientMasterHandlerService.showNeonatalProblemJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = NEONATAL_PROBLEM_JSP;
		title = "delete neonatalProblem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOutsideTreatmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = (Map<String, Object>) inPatientMasterHandlerService
				.showOutsideTreatmentJsp();
		@SuppressWarnings("unused")
		String jsp = "";
		jsp = OUTSIDE_TREATMENT_JSP;
		jsp += ".jsp";
		title = "Outside Treatment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOutsideTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outsideTreatmentCode = null;
		String outsideTreatmentName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			outsideTreatmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			outsideTreatmentName = request.getParameter(SEARCH_NAME);
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
			outsideTreatmentCode = searchField;
			outsideTreatmentName = null;
		} else {
			outsideTreatmentCode = null;
			outsideTreatmentName = searchField;
		}
		map = inPatientMasterHandlerService.searchOutsideTreatment(
				outsideTreatmentCode, outsideTreatmentName);
		jsp = OUTSIDE_TREATMENT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("outsideTreatmentCode", outsideTreatmentCode);
		map.put("outsideTreatmentName", outsideTreatmentName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOutsideTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasOutsideTreatment masOutsideTreatment = new MasOutsideTreatment();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List outsideTreatmentCodeList = new ArrayList();
		List outsideTreatmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			outsideTreatmentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			outsideTreatmentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((outsideTreatmentCodeList.size() == 0 || outsideTreatmentCodeList == null)
				&& (outsideTreatmentNameList.size() == 0 || outsideTreatmentNameList == null)) {
			masOutsideTreatment.setOutsideTreatmentCode(code);
			masOutsideTreatment.setOutsideTreatmentName(name);
			masOutsideTreatment.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masOutsideTreatment.setLastChgBy(users);
			masOutsideTreatment.setLastChgDate(currentDate);
			masOutsideTreatment.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addOutsideTreatment(masOutsideTreatment);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((outsideTreatmentCodeList.size() != 0 || outsideTreatmentCodeList != null)
				|| (outsideTreatmentNameList.size() != 0)
				|| outsideTreatmentNameList != null) {
			if ((outsideTreatmentCodeList.size() != 0 || outsideTreatmentCodeList != null)
					&& (outsideTreatmentNameList.size() == 0 || outsideTreatmentNameList == null)) {
				message = "outside Treatment Code  already exists.";
			} else if ((outsideTreatmentNameList.size() != 0 || outsideTreatmentNameList != null)
					&& (outsideTreatmentCodeList.size() == 0 || outsideTreatmentCodeList == null)) {
				message = "outside Treatment Name already exists.";
			} else if ((outsideTreatmentCodeList.size() != 0 || outsideTreatmentCodeList != null)
					&& (outsideTreatmentNameList.size() != 0 || outsideTreatmentNameList != null)) {
				message = "outside Treatment Code and outside Treatment Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showOutsideTreatmentJsp";
		try {
			map = inPatientMasterHandlerService.showOutsideTreatmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OUTSIDE_TREATMENT_JSP;
		title = "Add outsideTreatment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOutsideTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String outsideTreatmentCode = "";
		String outsideTreatmentName = "";
		int outsideTreatmentId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			outsideTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			outsideTreatmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			outsideTreatmentName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", outsideTreatmentId);
		generalMap.put("outsideTreatmentCode", outsideTreatmentCode);
		generalMap.put("name", outsideTreatmentName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBedStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBedStatusNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editOutsideTreatment(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingBedStatusNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showOutsideTreatmentJsp";
		try {
			map = inPatientMasterHandlerService.showOutsideTreatmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OUTSIDE_TREATMENT_JSP;
		title = "update outsideTreatment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOutsideTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int outsideTreatmentId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			outsideTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deleteOutsideTreatment(
				outsideTreatmentId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showOutsideTreatmentsp";
		try {
			map = inPatientMasterHandlerService.showOutsideTreatmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OUTSIDE_TREATMENT_JSP;
		title = "delete BedStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPerineumMaintenanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		map = (Map<String, Object>) inPatientMasterHandlerService
				.showPerineumMaintenanceJsp();
		@SuppressWarnings("unused")
		String jsp = "";
		jsp = PERINEUM_MAINTENANCE_JSP;
		jsp += ".jsp";
		title = "Perineum Maintenance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPerineumMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String perineumMaintenanceCode = null;
		String perineumMaintenanceName = null;
		String searchField = null;

		// if(request.getParameter(CODE) != null &&
		// !(request.getParameter(CODE).equals(""))){
		// neonatalProblemCode = request.getParameter(CODE);
		// }
		// if(request.getParameter(SEARCH_NAME) != null &&
		// !(request.getParameter(SEARCH_NAME).equals(""))){
		// neonatalProblemName = request.getParameter(SEARCH_NAME);
		// }

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
			perineumMaintenanceCode = searchField;
			perineumMaintenanceName = null;
		} else {
			perineumMaintenanceCode = null;
			perineumMaintenanceName = searchField;
		}
		map = inPatientMasterHandlerService.searchPerineumMaintenance(
				perineumMaintenanceCode, perineumMaintenanceName);
		jsp = PERINEUM_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("perineumMaintenanceCode", perineumMaintenanceCode);
		map.put("perineumMaintenanceName", perineumMaintenanceName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPerineumMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPerineumMaintenance masPerineumMaintenance = new MasPerineumMaintenance();
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List perineumMaintenanceCodeList = new ArrayList();
		List perineumMaintenancenameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			perineumMaintenanceCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			perineumMaintenancenameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((perineumMaintenanceCodeList.size() == 0 || perineumMaintenanceCodeList == null)
				&& (perineumMaintenancenameList.size() == 0 || perineumMaintenancenameList == null)) {
			masPerineumMaintenance.setPerineumMaintenanceCode(code);
			masPerineumMaintenance.setPerineumMaintenanceName(name);
			masPerineumMaintenance.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masPerineumMaintenance.setLastChgBy(users);
			masPerineumMaintenance.setLastChgDate(currentDate);
			masPerineumMaintenance.setLastChgTime(currentTime);
			successfullyAdded = inPatientMasterHandlerService
					.addPerineumMaintenance(masPerineumMaintenance);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";
			}
		}

		else if ((perineumMaintenanceCodeList.size() != 0 || perineumMaintenanceCodeList != null)
				|| (perineumMaintenancenameList.size() != 0)
				|| perineumMaintenancenameList != null) {
			if ((perineumMaintenanceCodeList.size() != 0 || perineumMaintenanceCodeList != null)
					&& (perineumMaintenancenameList.size() == 0 || perineumMaintenancenameList == null)) {
				message = " perineum MaintenanceCode already exists.";
			} else if ((perineumMaintenancenameList.size() != 0 || perineumMaintenancenameList != null)
					&& (perineumMaintenanceCodeList.size() == 0 || perineumMaintenanceCodeList == null)) {
				message = " perineum Maintenance Name already exists.";
			} else if ((perineumMaintenanceCodeList.size() != 0 || perineumMaintenanceCodeList != null)
					&& (perineumMaintenancenameList.size() != 0 || perineumMaintenancenameList != null)) {
				message = " perineum MaintenanceCode and  perineum Maintenance Name already exist.";
			}
		}
		url = "/hms/hms/inPatientMaster?method=showPerineumMaintenanceJsp";
		try {
			map = inPatientMasterHandlerService.showPerineumMaintenanceJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PERINEUM_MAINTENANCE_JSP;
		title = "Add neonatal problem";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPerineumMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String perineumMaintenanceCode = "";
		String perineumMaintenanceName = "";
		int perineumMaintenanceId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			perineumMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			perineumMaintenanceCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			perineumMaintenanceName = request.getParameter(SEARCH_NAME);
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
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("perineumMaintenanceId", perineumMaintenanceId);
		generalMap.put("perineumMaintenanceCode", perineumMaintenanceCode);
		generalMap.put("perineumMaintenanceName", perineumMaintenanceName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingPerineumMaintenanceNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingPerineumMaintenanceNameList.size() == 0) {
			dataUpdated = inPatientMasterHandlerService
					.editPerineumMaintenance(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be Updated !!";
			}
		} else if (existingPerineumMaintenanceNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/inPatientMaster?method=showPerineumMaintenanceJsp";
		try {
			map = inPatientMasterHandlerService.showPerineumMaintenanceJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PERINEUM_MAINTENANCE_JSP;
		title = "update perineumMaintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePerineumMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int perineumMaintenanceId = 0;
		String message = null;
		HttpSession session = request.getSession();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			perineumMaintenanceId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = inPatientMasterHandlerService.deletePerineumMaintenance(
				perineumMaintenanceId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/inPatientMaster?method=showPerineumMaintenanceJsp";
		try {
			map = inPatientMasterHandlerService.showPerineumMaintenanceJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PERINEUM_MAINTENANCE_JSP;
		title = "delete perineumMaintenance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showKitIssueJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		 jsp =RequestConstants.SHOW_KIT_ISSUE_JSP;
		 jsp += ".jsp";
		 title = "Kit Issue";
		 map.put("contentJsp", jsp);
		 map.put("title",title);
		 return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getItemListForAutoComplete(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if(session.getAttribute(RequestConstants.DEPT_ID)!=null)
			{
				deptId=(Integer)session.getAttribute(RequestConstants.DEPT_ID);
			}
			
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = inPatientMasterHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	
	}
	
	public ModelAndView getItemListForKitIssueAutoComplete(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if(session.getAttribute(RequestConstants.DEPT_ID)!=null)
			{
				deptId=(Integer)session.getAttribute(RequestConstants.DEPT_ID);
			}
			
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = inPatientMasterHandlerService.getItemListForKitIssueAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_response_kit_issue";

		return new ModelAndView(jsp, "map", map);
	
	}
	
	
	public ModelAndView submitKitIssueMasterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box =HMSUtil.getBox(request);
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.submitKitIssueMasterDetails(box);
		if(!box.getString("flag").equals("") && box.getString("flag").equals("kitIssue")){
			jsp ="patientKitIssue";
		}else{
		 jsp =RequestConstants.SHOW_KIT_ISSUE_JSP;
		}
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getPatientDetailsForKitIssue(box);
		map.putAll(inPatientMasterHandlerService.getKitTemplateList(hospitalId));
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showKitIssueTemplateDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = inPatientMasterHandlerService.showKitIssueTemplateDetails(box);
		return new ModelAndView("responseKitIssueTemplate", "map", map);
	}
	
	public ModelAndView updateKitIssueMasterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Box box =HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.updateKitIssueMasterDetails(box);
		String jsp =RequestConstants.SHOW_KIT_ISSUE_JSP; 
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteKitIssueTemplate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Box box =HMSUtil.getBox(request);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		datamap = inPatientMasterHandlerService.deleteKitIssueTemplate(box);
		String jsp =RequestConstants.SHOW_KIT_ISSUE_JSP; 
		jsp += ".jsp";
		map = inPatientMasterHandlerService.getKitTemplateList(hospitalId);
		map.put("message", datamap.get("message"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	// -------------------------------- HouseKeeping
		// ------------------------------------------

		@SuppressWarnings("unchecked")
		public ModelAndView showHouseKeepingJsp(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map) inPatientMasterHandlerService.showHouseKeeping();
			String jsp = "houseKeeping";
			jsp += ".jsp";
			title = "houseKeeping";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addHouseKeeping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasHouseKeeping masHouseKeeping = new MasHouseKeeping();
			int hospitalId = 0;
			HttpSession session = request.getSession();
			int userId = (Integer) session.getAttribute("userId");


			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			try {
				if (request.getParameter(CODE) != null) {
					code = request.getParameter(CODE);
				}

				if (request.getParameter(SEARCH_NAME) != null) {
					name = request.getParameter(SEARCH_NAME);
				}

			
				if (request.getParameter(HOSPITAL_ID) != null
						&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
					hospitalId = Integer
							.parseInt(request.getParameter(HOSPITAL_ID));
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
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List houseKeepingCodeList = new ArrayList();
			List houseKeepingNameList = new ArrayList();
			if (listMap.get("duplicateGeneralCodeList") != null) {
				houseKeepingCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				houseKeepingNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((houseKeepingCodeList.size() == 0 || houseKeepingCodeList == null)
					&& (houseKeepingNameList.size() == 0 || houseKeepingNameList == null)) {
				masHouseKeeping.setHouseKeepingCode(code);
				masHouseKeeping.setHouseKeepingName(name);

				Users users = new Users();
				users.setId(userId);
				masHouseKeeping.setLastChgBy(users);


				masHouseKeeping.setStatus("Y");
				masHouseKeeping.setLastChgDate(currentDate);
				masHouseKeeping.setLastChgTime(currentTime);
				successfullyAdded = inPatientMasterHandlerService
						.addHouseKeeping(masHouseKeeping);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if ((houseKeepingCodeList.size() != 0 || houseKeepingCodeList != null)
					|| (houseKeepingNameList.size() != 0) || houseKeepingNameList != null) {
				if ((houseKeepingCodeList.size() != 0 || houseKeepingCodeList != null)
						&& (houseKeepingNameList.size() == 0 || houseKeepingNameList == null)) {
					message = "HouseKeeping Code already exists.";
				} else if ((houseKeepingNameList.size() != 0 || houseKeepingNameList != null)
						&& (houseKeepingCodeList.size() == 0 || houseKeepingCodeList == null)) {
					message = "HouseKeeping Name already exists.";
				} else if ((houseKeepingCodeList.size() != 0 || houseKeepingCodeList != null)
						&& (houseKeepingCodeList.size() != 0 || houseKeepingNameList != null)) {
					message = "HouseKeeping Code and Name exist.";
				}
			}
			try {
				map = inPatientMasterHandlerService.showHouseKeeping();

			} catch (Exception e) {
				e.printStackTrace();
			}

			String jsp = "houseKeeping";
			title = " Add houseKeeping";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editHouseKeeping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			HttpSession session = request.getSession();
			String houseKeepingCode = "";
			String houseKeepingName = "";
			int houseKeepingId = 0;
			Date changedDate = null;
			@SuppressWarnings("unused")
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			int hospitalId = 0;

			try {
				
				if (request.getParameter(HOSPITAL_ID) != null
						&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
					hospitalId = Integer
							.parseInt(request.getParameter(HOSPITAL_ID));
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					houseKeepingId = Integer.parseInt(request.getParameter(COMMON_ID));
				}

			
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					houseKeepingCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					houseKeepingName = request.getParameter(SEARCH_NAME);
				}

				if (request.getParameter("pojoName") != null) {
					pojoName = request.getParameter("pojoName");
				}
				if (request.getParameter("pojoPropertyName") != null) {
					pojoPropertyName = request.getParameter("pojoPropertyName");
				}
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", houseKeepingId);
				generalMap.put("houseKeepingCode", houseKeepingCode);
				generalMap.put("name", houseKeepingName);
				generalMap.put("hospitalId", hospitalId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("userId", userId);
				Map<String, Object> listMap = new HashMap<String, Object>();

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put("flag", true);

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingHouseKeepingNameList = (List) listMap
						.get("duplicateMastersList");
				boolean dataUpdated = false;

				if (existingHouseKeepingNameList.size() == 0) {
					dataUpdated = inPatientMasterHandlerService
							.editHouseKeeping(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				} else if (existingHouseKeepingNameList.size() > 0) {
					message = "Name already exists.";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				map = inPatientMasterHandlerService.showHouseKeeping();

			} catch (Exception e) {
				e.printStackTrace();
			}
			// jsp="houseKeeping"_JSP;
			// title="Edit HouseKeeping";
			// jsp += ".jsp";

			String jsp = "houseKeeping";
			title = " Edit houseKeeping";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView searchHouseKeeping(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String searchField = null;
			String houseKeepingCode = null;
			String houseKeepingName = null;
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
				houseKeepingCode = searchField;
				houseKeepingName = null;

			} else {
				houseKeepingCode = null;
				houseKeepingName = searchField;
			}

			//

			map = inPatientMasterHandlerService.searchHouseKeeping(houseKeepingCode,
					houseKeepingName);

			jsp = "houseKeeping";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("houseKeepingCode", houseKeepingCode);
			map.put("houseKeepingName", houseKeepingName);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteHouseKeeping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int houseKeepingId = 0;
			String message = null;
			HttpSession session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");

			Map<String, Object> generalMap = new HashMap<String, Object>();
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				houseKeepingId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}

			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = inPatientMasterHandlerService.deleteHouseKeeping(houseKeepingId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/inPatientMaster?method=showHouseKeepingJsp";
			try {
				map = inPatientMasterHandlerService.showHouseKeeping();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "houseKeeping";
			title = "delete House Keeping";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		


		public ModelAndView showHouseKeepingFrequencyJsp(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map) inPatientMasterHandlerService.showHouseKeepingFrequencyJsp();
			String jsp = "houseKeepingFrequency";
			jsp += ".jsp";
			title = "HouseKeepingFrequency";
			map.put("contentJsp", jsp);
			map.put("pageNo", 1);
			map.put("title", title);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView addHouseKeepingFrequency(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasHouseKeepingFrequency masHouseKeepingFrequency = new MasHouseKeepingFrequency();

			HttpSession session = request.getSession();
			String code = " ";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int frequencyCount=0;
			try {

			

				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					code = request.getParameter(CODE);
					
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					name = request.getParameter(SEARCH_NAME);
					
				}
				if (request.getParameter("frequencyCount") != null
						&& !(request.getParameter("frequencyCount").equals(""))) {
					frequencyCount = Integer.parseInt(request.getParameter("frequencyCount"));
					
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
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {

				listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}

			List frequencyCodeList = new ArrayList();
			List frequencyNameList = new ArrayList();

			if (listMap.get("duplicateGeneralCodeList") != null) {
				frequencyCodeList = (List) listMap.get("duplicateGeneralCodeList");

			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				frequencyNameList = (List) listMap.get("duplicateGeneralNameList");

			}
			boolean successfullyAdded = false;

			if ((frequencyCodeList.size() == 0 || frequencyCodeList == null)
					&& (frequencyNameList.size() == 0 || frequencyNameList == null)) {
				if (!code.equals("")) {

			
					masHouseKeepingFrequency.setFrequencyCode(code);
					masHouseKeepingFrequency.setFrequencyName(name);

					Users users = new Users();

					if (session.getAttribute("users") != null) {
						users = (Users) session.getAttribute("users");
					}
					masHouseKeepingFrequency.setFrequencyCount(frequencyCount);
					masHouseKeepingFrequency.setLastChgBy(users);
					masHouseKeepingFrequency.setLastChgDate(currentDate);
					masHouseKeepingFrequency.setLastChgTime(currentTime);
					masHouseKeepingFrequency.setStatus("y");

					successfullyAdded = inPatientMasterHandlerService.addHouseKeepingFrequency(masHouseKeepingFrequency);
				}

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
					|| (frequencyNameList.size() != 0) || frequencyNameList != null) {
				if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
						&& (frequencyNameList.size() == 0 || frequencyNameList == null)) {
					message = "Frequency Code already exists.";
				} else if ((frequencyNameList.size() != 0 || frequencyNameList != null)
						&& (frequencyCodeList.size() == 0 || frequencyCodeList == null)) {
					message = "Frequency Name already exists.";
				} else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
						&& (frequencyNameList.size() != 0 || frequencyNameList != null)) {
					message = "Frequency Code and State exist.";
				}
			}

			try {
				map = inPatientMasterHandlerService.showHouseKeepingFrequencyJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "houseKeepingFrequency";
			title = "houseKeepingFrequency";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView searchHouseKeepingFrequency(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String frequencyCode = null;
			String frequencyName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				frequencyCode = request.getParameter(CODE);
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				frequencyName = request.getParameter(SEARCH_NAME);
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
				System.out.println("searchRadio" + searchRadio);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (searchRadio == 1) {
				frequencyCode = searchField;
				frequencyName = null;
			} else {
				frequencyCode = null;
				frequencyName = searchField;
			}
			map = inPatientMasterHandlerService.searchHouseKeepingFrequency(frequencyCode, frequencyName);
			jsp = "houseKeepingFrequency";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("frequencyCode", frequencyCode);
			map.put("frequencyName", frequencyName);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView editHouseKeepingFrequency(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			session = request.getSession();
			String frequencyCode = "";
			String name = "";
			int frequencyId = 0;
			int frequencyCount=0;
			Date changedDate = null;
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			try {

				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					frequencyId = Integer.parseInt(request
							.getParameter(COMMON_ID));
				}
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					frequencyCode = request.getParameter(CODE);
				}
				
				if (request.getParameter("frequencyCount") != null
						&& !(request.getParameter("frequencyCount").equals(""))) {
					frequencyCount = Integer.parseInt(request.getParameter("frequencyCount"));
					
				}

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					name = request.getParameter(SEARCH_NAME);
				}

				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", frequencyId);
				generalMap.put("frequencyCode", frequencyCode);
				generalMap.put("frequencyCount", frequencyCount);
				generalMap.put("name", name);
				generalMap.put("userId", userId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
			} catch (Exception e) {
				e.printStackTrace();
			}

			boolean dataUpdated = false;
			try {
				dataUpdated = inPatientMasterHandlerService.editHouseKeepingFrequency(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";

			} else {
				message = "Data Cant be updated !!";
			}

			try {
				map = inPatientMasterHandlerService.showHouseKeepingFrequencyJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "houseKeepingFrequency";
			title = "Edit Frequency";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView deleteHouseKeepingFrequency(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			int frequencyId = 0;
			String message = null;
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				frequencyId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}

			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = inPatientMasterHandlerService.deleteHouseKeepingFrequency(
					frequencyId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/inPatientMaster?method=showHouseKeepingFrequencyJsp";

			try {
				map = inPatientMasterHandlerService.showHouseKeepingFrequencyJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "houseKeepingFrequency";
			title = "delete Frequency";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
		public ModelAndView showUnitWiseTableJsp(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();
			Map<String,Object> map=new HashMap<String,Object>();
			int hospitalId=0;
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			
			map = (Map<String, Object>) inPatientMasterHandlerService
					.showUnitWiseTableJsp(hospitalId);
			jsp = "unitWiseTable";
			jsp += ".jsp";
			title = "Bed Status";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView	getTableBasedOnUnit(HttpServletRequest request,
				HttpServletResponse response) {
			int departmentId=0;
			if(request.getParameter("departmentName")!=null && !request.getParameter("departmentName").equals("0")){
				departmentId=Integer.parseInt(request.getParameter("departmentName"));
			}else
			if(request.getParameter("departmentName2")!=null && !request.getParameter("departmentName2").equals("0")){
				departmentId=Integer.parseInt(request.getParameter("departmentName2"));
			}
			
			String deptType="";
			if(request.getParameter("depType2")!=null){
				deptType=request.getParameter("depType2");
			}
			HttpSession session = request.getSession();
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			Map<String,Object>map=new HashMap<String,Object>();	
			map=inPatientMasterHandlerService.getTableList(departmentId,hospitalId);
			jsp="responseForBedJsp";
			map.put("deptType",deptType);
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView	 saveUnitWiseTable(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String,Object>map=new HashMap<String,Object>();
			
			int deptId=0;
			int hospitalId=0;
			int unitId=0;
			String dayName="";
			int bedId=0;
			HttpSession session =request.getSession();
			if(request.getParameter("departmentName")!=null && !request.getParameter("departmentName").equals("0")){
				deptId=Integer.parseInt(request.getParameter("departmentName"));
			}else
			if(request.getParameter("departmentName2")!=null && !request.getParameter("departmentName2").equals("0")){
				deptId=Integer.parseInt(request.getParameter("departmentName2"));
			}
			if(session.getAttribute("hospitalId")!=null){
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			if(request.getParameter("bedName")!=null && !request.getParameter("bedName").equals("0")){
				bedId=Integer.parseInt(request.getParameter("bedName"));
			}
			if(request.getParameter("UnitName")!=null && !request.getParameter("UnitName").equals("0")){
				unitId=Integer.parseInt(request.getParameter("UnitName"));
			}
			if(request.getParameter("dayName")!=null && !request.getParameter("dayName").equals("0")){
				dayName=(request.getParameter("dayName"));
			}
			OtMasUnitDay omud=new OtMasUnitDay();
			
			MasHospital mh = new MasHospital();
			mh.setId(hospitalId);
			omud.setHospital(mh);
			
			MasDepartment md =new MasDepartment();
			md.setId(deptId);
			omud.setDepartment(md);
			
			MasBed mb =new MasBed();
			mb.setId(bedId);
			omud.setMasBed(mb);
		
			if(unitId!=0){
			HospitalDoctorUnitM hdum=new HospitalDoctorUnitM();
			hdum.setId(unitId);
			omud.setUnitM(hdum);
			}
			omud.setStatus("y");
			omud.setDayName(dayName);
			boolean saved=false;
			String message="";
			List<OtMasUnitDay>omudList=new ArrayList<OtMasUnitDay>();
			omudList=inPatientMasterHandlerService.checkForExistingData(bedId,unitId,dayName,hospitalId);
			if(omudList.size()==0){
			saved=inPatientMasterHandlerService.saveUnitWiseTable(omud);
			
			if(saved==true){
				message="Saved Successfully!!";
			}
			}else{
				message="Data Already Exist!!";
			}
			
			map = (Map<String, Object>) inPatientMasterHandlerService
					.showUnitWiseTableJsp(hospitalId);
			jsp = "unitWiseTable";
					jsp += ".jsp";
				title = "Bed Status";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message",message);
				return new ModelAndView("index", "map", map);
		}
		
		// -----------------------------------

				// ---------------------------------------
				// WasteCategory ----------------------------------------------

				@SuppressWarnings("unchecked")
				public ModelAndView showWasteCategoryJsp(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					map = (Map) inPatientMasterHandlerService.showWasteCategory();
					String jsp = "wasteCategory";
					jsp += ".jsp";
					title = "Waste Category";
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index", "map", map);

				}

				@SuppressWarnings("unchecked")
				public ModelAndView addWasteCategory(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					MasWasteCategory masWasteCategory = new MasWasteCategory();
					String changedBy = " ";

					Map<String, Object> listMap = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					Date currentDate = new Date();

					HttpSession session = request.getSession();
					int departmentId = (Integer) session.getAttribute("deptId");
					int hospitalId = 0;
					Integer userId = (Integer) session.getAttribute("userId");

					synchronized (currentDate) {
						if (session.getAttribute("hospitalId") != null) {
							hospitalId = (Integer) session.getAttribute("hospitalId");
						}
					}
					try {
						if (request.getParameter(CODE) != null) {
							code = request.getParameter(CODE);
						}
						if (request.getParameter(SEARCH_NAME) != null) {
							name = request.getParameter(SEARCH_NAME);
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
						generalMap.put("hospitalId", hospitalId);

						generalMap.put("pojoPropertyName", pojoPropertyName);
						generalMap.put("pojoPropertyCode", pojoPropertyCode);
						generalMap.put("pojoName", pojoName);

					} catch (Exception e) {
						e.printStackTrace();
					}

					try {

						listMap = commonMasterHandlerService
								.checkForExistingMasters(generalMap);
					} catch (Exception e) {
						e.printStackTrace();
					}

					List wasteCategoryCodeList = new ArrayList();
					List wasteCategoryNameList = new ArrayList();

					if (listMap.get("duplicateGeneralCodeList") != null) {
						wasteCategoryCodeList = (List) listMap
								.get("duplicateGeneralCodeList");

					}
					if (listMap.get("duplicateGeneralNameList") != null) {
						wasteCategoryNameList = (List) listMap
								.get("duplicateGeneralNameList");

					}
					boolean successfullyAdded = false;

					if ((wasteCategoryCodeList.size() == 0 || wasteCategoryCodeList == null)
							&& (wasteCategoryNameList.size() == 0 || wasteCategoryNameList == null)) {
						masWasteCategory.setWasteCategoryCode(code);
						masWasteCategory.setWasteCategoryName(name);

						masWasteCategory.setStatus("Y");
						Users users = new Users();
						users.setId(userId);

						masWasteCategory.setLastChgBy(users);
						masWasteCategory.setLastChgDate(currentDate);
						masWasteCategory.setLastChgTime(currentTime);
						Map<String, Object> wasteCategoryMap = new HashMap<String, Object>();

						System.out.println("masWasteCategory4456456"
								+ masWasteCategory);

						wasteCategoryMap.put("masWasteCategory",
								masWasteCategory);
						wasteCategoryMap.put("hospitalId", hospitalId);
						successfullyAdded = inPatientMasterHandlerService
								.addWasteCategory(wasteCategoryMap);

						if (successfullyAdded) {
							message = "Record Added Successfully";
						} else {
							message = "Try Again !";
						}

					} else if ((wasteCategoryCodeList.size() != 0 || wasteCategoryCodeList != null)
							|| (wasteCategoryNameList.size() != 0)
							|| wasteCategoryNameList != null) {
						if ((wasteCategoryCodeList.size() != 0 || wasteCategoryCodeList != null)
								&& (wasteCategoryNameList.size() == 0 || wasteCategoryNameList == null)) {
							message = "Specialty WasteCategory  Code already exists.";
						} else if ((wasteCategoryNameList.size() != 0 || wasteCategoryNameList != null)
								&& (wasteCategoryCodeList.size() == 0 || wasteCategoryCodeList == null)) {
							message = "Specialty WasteCategory  Name already exists.";
						} else if ((wasteCategoryCodeList.size() != 0 || wasteCategoryCodeList != null)
								&& (wasteCategoryNameList.size() != 0 || wasteCategoryNameList != null)) {
							message = "Specialty WasteCategory  Code and Specialty WasteCategory Name  exist.";
						}
					}

					try {
						map = inPatientMasterHandlerService.showWasteCategory();

					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "wasteCategory";
					title = "Add Specialty WasteCategory ";
					jsp += ".jsp";

					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("url", url);
					map.put("message", message);
					return new ModelAndView("index", "map", map);

				}

				public ModelAndView editWasteCategory(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();
					HttpSession session = request.getSession();
					session = request.getSession();
					String wasteCategoryCode = "";
					String name = "";
					int wasteCategoryId = 0;
					Date changedDate = null;
					@SuppressWarnings("unused")
					String changedTime = "";
					Integer userId = (Integer) session.getAttribute("userId");
					try {

						if (request.getParameter(COMMON_ID) != null
								&& !(request.getParameter(COMMON_ID).equals(""))) {
							wasteCategoryId = Integer.parseInt(request
									.getParameter(COMMON_ID));
						}
						if (request.getParameter(CODE) != null
								&& !(request.getParameter(CODE).equals(""))) {
							wasteCategoryCode = request.getParameter(CODE);
						}
						if (request.getParameter(SEARCH_NAME) != null
								&& !(request.getParameter(SEARCH_NAME).equals(""))) {
							name = request.getParameter(SEARCH_NAME);
						}

						if (request.getParameter("title") != null) {
							title = request.getParameter("title");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					changedDate = new Date();
					try {
						changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
								"currentTime");

						generalMap.put("id", wasteCategoryId);
						generalMap.put("wasteCategoryCode", wasteCategoryCode);
						generalMap.put("name", name);
						generalMap.put("userId", userId);
						generalMap.put("currentDate", changedDate);
						generalMap.put("currentTime", changedTime);
					} catch (Exception e) {
						e.printStackTrace();
					}

					boolean dataUpdated = false;
					try {
						dataUpdated = inPatientMasterHandlerService
								.editWasteCategory(generalMap);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (dataUpdated == true) {
						message = "Data updated Successfully !!";

					} else {
						message = "Data Cant be updated !!";
					}

					try {
						map = inPatientMasterHandlerService.showWasteCategory();

					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "wasteCategory";
					title = "Edit WasteCategory";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("url", url);
					map.put("message", message);
					return new ModelAndView("index", "map", map);
				}

				public ModelAndView searchWasteCategory(HttpServletRequest request,
						HttpServletResponse response) throws ServletRequestBindingException {
					Map<String, Object> map = new HashMap<String, Object>();
					String searchField = null;
					String wasteCategoryCode = null;
					String wasteCategoryName = null;
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
						wasteCategoryCode = searchField;
						wasteCategoryName = null;

					} else {
						wasteCategoryCode = null;
						wasteCategoryName = searchField;
					}
					map = inPatientMasterHandlerService.searchWasteCategory(
							wasteCategoryCode, wasteCategoryName);

					jsp = "wasteCategory";
					jsp += ".jsp";
					map.put("search", "search");
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("wasteCategoryCode", wasteCategoryCode);
					map.put("wasteCategoryName", wasteCategoryName);
					return new ModelAndView("index", "map", map);
				}

				public ModelAndView deleteWasteCategory(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> generalMap = new HashMap<String, Object>();

					int wasteCategoryId = 0;
					String message = null;
					HttpSession session = request.getSession();
					session = request.getSession();
					Integer userId = (Integer) session.getAttribute("userId");
					String changedTime = "";
					Date changedDate = null;
					String flag = "";
					if (request.getParameter("flag") != null) {
						flag = request.getParameter("flag");
						generalMap.put("flag", flag);
					}
					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						wasteCategoryId = Integer.parseInt(request
								.getParameter(COMMON_ID));
					}
					if (request.getParameter("title") != null) {
						title = request.getParameter("title");
					}

					changedDate = new Date();
					changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					generalMap.put("userId", userId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					boolean dataDeleted = false;
					dataDeleted = inPatientMasterHandlerService.deleteWasteCategory(
							wasteCategoryId, generalMap);
					if (dataDeleted == true) {
						message = "Record is InActivated successfully !!";
					}

					else {
						message = "Record is Activated successfully !!";
					}
					url = "/hms/hms/inPatientMaster?method=showWasteCategoryJsp";

					try {
						map = inPatientMasterHandlerService.showWasteCategory();

					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "wasteCategory";
					title = "delete WasteCategory";
					jsp += ".jsp";

					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("url", url);
					map.put("message", message);
					return new ModelAndView("index", "map", map);

				}
		// -----------------------------------

		// ---------------------------------------
		// WasteContainer ----------------------------------------------

		@SuppressWarnings("unchecked")
		public ModelAndView showWasteContainerJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map) inPatientMasterHandlerService.showWasteContainer();
			String jsp = "wasteContainer";
			jsp += ".jsp";
			title = "Waste Category";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);

		}

		@SuppressWarnings("unchecked")
		public ModelAndView addWasteContainer(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasWasteContainer masWasteContainer = new MasWasteContainer();
			String changedBy = " ";

			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			HttpSession session = request.getSession();
			int departmentId = (Integer) session.getAttribute("deptId");
			int hospitalId = 0;
			Integer userId = (Integer) session.getAttribute("userId");

			synchronized (currentDate) {
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
				}
			}
			try {
				if (request.getParameter(CODE) != null) {
					code = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null) {
					name = request.getParameter(SEARCH_NAME);
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
				generalMap.put("hospitalId", hospitalId);

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoPropertyCode", pojoPropertyCode);
				generalMap.put("pojoName", pojoName);

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}

			List wasteContainerCodeList = new ArrayList();
			List wasteContainerNameList = new ArrayList();

			if (listMap.get("duplicateGeneralCodeList") != null) {
				wasteContainerCodeList = (List) listMap
						.get("duplicateGeneralCodeList");

			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				wasteContainerNameList = (List) listMap
						.get("duplicateGeneralNameList");

			}
			boolean successfullyAdded = false;

			if ((wasteContainerCodeList.size() == 0 || wasteContainerCodeList == null)
					&& (wasteContainerNameList.size() == 0 || wasteContainerNameList == null)) {
				masWasteContainer.setWasteContainerCode(code);
				masWasteContainer.setWasteContainerName(name);

				masWasteContainer.setStatus("Y");
				Users users = new Users();
				users.setId(userId);

				masWasteContainer.setLastChgBy(users);
				masWasteContainer.setLastChgDate(currentDate);
				masWasteContainer.setLastChgTime(currentTime);
				Map<String, Object> wasteContainerMap = new HashMap<String, Object>();

				System.out.println("masWasteContainer4456456"
						+ masWasteContainer);

				wasteContainerMap.put("masWasteContainer",
						masWasteContainer);
				wasteContainerMap.put("hospitalId", hospitalId);
				successfullyAdded = inPatientMasterHandlerService
						.addWasteContainer(wasteContainerMap);

				if (successfullyAdded) {
					message = "Record Added Successfully";
				} else {
					message = "Try Again !";
				}

			} else if ((wasteContainerCodeList.size() != 0 || wasteContainerCodeList != null)
					|| (wasteContainerNameList.size() != 0)
					|| wasteContainerNameList != null) {
				if ((wasteContainerCodeList.size() != 0 || wasteContainerCodeList != null)
						&& (wasteContainerNameList.size() == 0 || wasteContainerNameList == null)) {
					message = "Specialty WasteContainer  Code already exists.";
				} else if ((wasteContainerNameList.size() != 0 || wasteContainerNameList != null)
						&& (wasteContainerCodeList.size() == 0 || wasteContainerCodeList == null)) {
					message = "Specialty WasteContainer  Name already exists.";
				} else if ((wasteContainerCodeList.size() != 0 || wasteContainerCodeList != null)
						&& (wasteContainerNameList.size() != 0 || wasteContainerNameList != null)) {
					message = "Specialty WasteContainer  Code and Specialty WasteContainer Name  exist.";
				}
			}

			try {
				map = inPatientMasterHandlerService.showWasteContainer();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "wasteContainer";
			title = "Add Specialty WasteContainer ";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView editWasteContainer(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			session = request.getSession();
			String wasteContainerCode = "";
			String name = "";
			int wasteContainerId = 0;
			Date changedDate = null;
			@SuppressWarnings("unused")
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			try {

				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					wasteContainerId = Integer.parseInt(request
							.getParameter(COMMON_ID));
				}
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					wasteContainerCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					name = request.getParameter(SEARCH_NAME);
				}

				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", wasteContainerId);
				generalMap.put("wasteContainerCode", wasteContainerCode);
				generalMap.put("name", name);
				generalMap.put("userId", userId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
			} catch (Exception e) {
				e.printStackTrace();
			}

			boolean dataUpdated = false;
			try {
				dataUpdated = inPatientMasterHandlerService
						.editWasteContainer(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";

			} else {
				message = "Data Cant be updated !!";
			}

			try {
				map = inPatientMasterHandlerService.showWasteContainer();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "wasteContainer";
			title = "Edit WasteContainer";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView searchWasteContainer(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String searchField = null;
			String wasteContainerCode = null;
			String wasteContainerName = null;
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
				wasteContainerCode = searchField;
				wasteContainerName = null;

			} else {
				wasteContainerCode = null;
				wasteContainerName = searchField;
			}
			map = inPatientMasterHandlerService.searchWasteContainer(
					wasteContainerCode, wasteContainerName);

			jsp = "wasteContainer";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("wasteContainerCode", wasteContainerCode);
			map.put("wasteContainerName", wasteContainerName);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteWasteContainer(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			int wasteContainerId = 0;
			String message = null;
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				wasteContainerId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}

			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = inPatientMasterHandlerService.deleteWasteContainer(
					wasteContainerId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/inPatientMaster?method=showWasteContainerJsp";

			try {
				map = inPatientMasterHandlerService.showWasteContainer();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "wasteContainer";
			title = "delete WasteContainer";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
		
		
		// ------------------------------------------Ambulance
		// ----------------------------------

		public ModelAndView searchAmbulance(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String ambulanceNo = null;

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				ambulanceNo = request.getParameter(SEARCH_NAME);
			}
			map = inPatientMasterHandlerService.searchAmbulance(ambulanceNo);
			jsp = "ambulance";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("ambulanceNo", ambulanceNo);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView showAmbulanceJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map map = new HashMap();
			map = inPatientMasterHandlerService.showAmbulanceJsp();
			String jsp = "ambulance";
			jsp += ".jsp";
			title = "Ambulance";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addAmbulance(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasAmbulance masAmbulance = new MasAmbulance();
			String description = "";
			String available = "";
			int userId=0;
			HttpSession session=request.getSession();
			String local = "";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			if (request.getParameter("description") != null) {
				description = request.getParameter("description");
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if(session.getAttribute("userId") != null){
				userId=(Integer)session.getAttribute("userId");
			 }
			if (request.getParameter("available") != null && !(request.getParameter("available").equals(""))) {
				available = request.getParameter("available");
			} else {
				available = request.getParameter("available");
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

			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			 
			
			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List ambulanceNameList = new ArrayList();
			if (listMap.get("duplicateGeneralNameList") != null) {
				ambulanceNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((ambulanceNameList.size() == 0 || ambulanceNameList == null)
					&& (ambulanceNameList.size() == 0 || ambulanceNameList == null)) {
				masAmbulance.setDescription(description);
				masAmbulance.setAmbulanceNo(name);
				masAmbulance.setStatus("y");
				masAmbulance.setLastChgDate(currentDate);
				masAmbulance.setLastChgTime(currentTime);
				masAmbulance.setAvailable(available);
				Users user=new Users();
			    user.setId(userId);
			    masAmbulance.setLastChgBy(user);
			    
				successfullyAdded = inPatientMasterHandlerService.addAmbulance(masAmbulance);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((ambulanceNameList.size() != 0) || ambulanceNameList != null) {
				if ((ambulanceNameList.size() != 0 || ambulanceNameList != null)) {
					message = "Ambulance No. already exists.";
				}
			}
			try {
				map = inPatientMasterHandlerService.showAmbulanceJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "ambulance";
			title = "Add Ambulance";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editAmbulance(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			MasAmbulance masAmbulance = new MasAmbulance();
			HttpSession session=request.getSession();
			session = request.getSession();
			String description = "";
			String ambulanceNo = "";
			int ambulanceId = 0;
			String available = "";
	  		int userId=0;
			Date changedDate = null;
			String changedTime = "";
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				ambulanceId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("description") != null
					&& !(request.getParameter("description").equals(""))) {
				description = request.getParameter("description");
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				ambulanceNo = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("available") != null && !(request.getParameter("available").equals(""))) {
				available = request.getParameter("available");
			} else {
				available = request.getParameter("available");
			}
			if(session.getAttribute("userId") != null){
				userId=(Integer)session.getAttribute("userId");
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

		     Users user=new Users();
		     user.setId(userId);
	 		generalMap.put("id", ambulanceId);
			generalMap.put("description", description);
			generalMap.put("name", ambulanceNo);
			generalMap.put("available", available);
	 		generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingOccupationNameList = (List) listMap
					.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingOccupationNameList.size() == 0) {
				dataUpdated = inPatientMasterHandlerService
						.editAmbulanceToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingOccupationNameList.size() > 0) {
				message = "Ambulance No. already exists.";
			}
			url = "/hms/hms/inPatient?method=showAmbulanceJsp";

			try {
				map = inPatientMasterHandlerService.showAmbulanceJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "ambulance";
			title = "update Ambulance";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteAmbulance(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int ambulanceId = 0;
			String message = null;
			//String changedBy = "";
			int userId=0;
			HttpSession session=request.getSession();
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				ambulanceId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if(session.getAttribute("userId") != null){
				userId=(Integer)session.getAttribute("userId");
			 }
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			 Users user=new Users();
		     user.setId(userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			boolean dataDeleted = false;
			dataDeleted = inPatientMasterHandlerService.deleteAmbulance(ambulanceId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/inPatient?method=showAmbulanceJsp";

			try {
				map = inPatientMasterHandlerService.showAmbulanceJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "ambulance";
			title = "delete Ambulance";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

	// -----------------------------------------------------------------

	public InPatientMasterHandlerService getInPatientMasterHandlerService() {
		return inPatientMasterHandlerService;
	}

	public void setInPatientMasterHandlerService(
			InPatientMasterHandlerService inPatientMasterHandlerService) {
		this.inPatientMasterHandlerService = inPatientMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}