package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COST_CENTER_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.DESCRIPTION;
import static jkt.hms.util.RequestConstants.FREQUENCY_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LEAVE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TRANSACTION_TYPE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasApkVersion;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.SystemRelatedMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasLeave;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SystemRelatedMasterController extends MultiActionController {
	SystemRelatedMasterHandlerService systemRelatedMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	static final Logger LOGGER = Logger.getLogger(SystemRelatedMasterController.class);
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

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
	String currentTime = "";
	HttpSession session = null;

	// -------------------------------------------DepartmentType
	// --------------------------------------

	public ModelAndView searchDepartmentType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String departmentTypeCode = null;
		String departmentTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentTypeName = request.getParameter(SEARCH_NAME);
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
			departmentTypeCode = searchField;
			departmentTypeName = null;
		} else {
			departmentTypeCode = null;
			departmentTypeName = searchField;
		}

		map = systemRelatedMasterHandlerService.searchDepartmentType(
				departmentTypeCode, departmentTypeName);
		jsp = DEPARTMENT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("departmentTypeCode", departmentTypeCode);
		map.put("departmentTypeName", departmentTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDepartmentTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchDepartmentTypeList = (ArrayList) map
				.get("searchDepartmentTypeList");
		jsp = DEPARTMENT_TYPE_JSP;
		jsp += ".jsp";
		title = "DepartmentType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDepartmentType masDepartmentType = new MasDepartmentType();

		String changedBy = "";
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String serviceCentreCategoryType="";
		String displayInWebSite="";
		String displayAtTokenCounter="";
		if (request.getParameter("serviceCentreCategoryType") != null) {
			serviceCentreCategoryType = request.getParameter("serviceCentreCategoryType");
		}
		if (request.getParameter("displayInWebSite") != null) {
			displayInWebSite = request.getParameter("displayInWebSite");
		}
		if (request.getParameter("displayAtTokenCounter") != null) {
			displayAtTokenCounter = request.getParameter("displayAtTokenCounter");
		}
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

		List departmentTypeCodeList = new ArrayList();
		List departmentTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			departmentTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			departmentTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((departmentTypeCodeList.size() == 0 || departmentTypeCodeList == null)
				&& (departmentTypeNameList.size() == 0 || departmentTypeNameList == null)) {
			masDepartmentType.setDepartmentTypeCode(code);
			masDepartmentType.setDepartmentTypeName(name);
			masDepartmentType.setStatus("Y");
			Users users=new Users();
			users.setId((Integer)session.getAttribute(RequestConstants.USER_ID));
			masDepartmentType.setLastChgBy(users);
			masDepartmentType.setLastChgDate(currentDate);
			masDepartmentType.setLastChgTime(currentTime);
			masDepartmentType.setServiceCentreCategoryType(serviceCentreCategoryType);
			masDepartmentType.setDisplayInWebSite(displayInWebSite);
			masDepartmentType.setDisplayAtTokenCounter(displayAtTokenCounter);
			
			successfullyAdded = systemRelatedMasterHandlerService.addDepartmentType(masDepartmentType);


			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
				|| (departmentTypeNameList.size() != 0)
				|| departmentTypeNameList != null) {

			if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
					&& (departmentTypeNameList.size() == 0 || departmentTypeNameList == null)) {

				message = "DepartmentType Code  already exists.";
			} else if ((departmentTypeNameList.size() != 0 || departmentTypeNameList != null)
					&& (departmentTypeCodeList.size() == 0 || departmentTypeCodeList == null)) {

				message = "DepartmentType Name already exists.";
			} else if ((departmentTypeCodeList.size() != 0 || departmentTypeCodeList != null)
					&& (departmentTypeNameList.size() != 0 || departmentTypeNameList != null)) {

				message = "DepartmentType Code and DepartmentType Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Add Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String departmentTypeCode = "";
		String departmentTypeName = "";
		int departmentTypeId = 0;
		int userId = 0;

		Date changedDate = null;
		String changedTime = "";

		departmentTypeCode = (String) session
				.getAttribute("departmentTypeCode");
		departmentTypeName = (String) session
				.getAttribute("departmentTypeName");
		String serviceCentreCategoryType="";
		String displayInWebSite="";
		String displayAtTokenCounter="";
		if (request.getParameter("serviceCentreCategoryType") != null) {
			serviceCentreCategoryType = request.getParameter("serviceCentreCategoryType");
		}
		if (request.getParameter("displayInWebSite") != null) {
			displayInWebSite = request.getParameter("displayInWebSite");
		}
		if (request.getParameter("displayAtTokenCounter") != null) {
			displayAtTokenCounter = request.getParameter("displayAtTokenCounter");
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentTypeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentTypeName = request.getParameter(SEARCH_NAME);
		}
		userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
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

		generalMap.put("id", departmentTypeId);
		generalMap.put("departmentTypeCode", departmentTypeCode);
		generalMap.put("name", departmentTypeName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("serviceCentreCategoryType", serviceCentreCategoryType);
		generalMap.put("displayInWebSite", displayInWebSite);
		generalMap.put("displayAtTokenCounter", displayAtTokenCounter);

		
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDepartmentTypeNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editDepartmentTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDepartmentType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentTypeId = 0;
		String message = null;
		String changedTime = "";
		int userId=0;
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentTypeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = systemRelatedMasterHandlerService.deleteDepartmentType(
				departmentTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_TYPE_JSP;
		title = "Delete Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ------------------------------------------
	// TransactionType----------------------------------------

	public ModelAndView searchTransactionType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String transactionTypeCode = null;
		String transactionTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionTypeName = request.getParameter(SEARCH_NAME);
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
			transactionTypeCode = searchField;
			transactionTypeName = null;
		} else {
			transactionTypeCode = null;
			transactionTypeName = searchField;
		}

		map = systemRelatedMasterHandlerService.searchTransactionType(
				transactionTypeCode, transactionTypeName);
		jsp = TRANSACTION_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("transactionTypeCode", transactionTypeCode);
		map.put("transactionTypeName", transactionTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTransactionTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchTransactionTypeList = (ArrayList) map
				.get("searchTransactionTypeList");
		jsp = TRANSACTION_TYPE_JSP;
		jsp += ".jsp";
		title = "TransactionType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTransactionType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasTransactionType masTransactionType = new MasTransactionType();

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

		List transactionTypeCodeList = new ArrayList();
		List transactionTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			transactionTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			transactionTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((transactionTypeCodeList.size() == 0 || transactionTypeCodeList == null)
				&& (transactionTypeNameList.size() == 0 || transactionTypeNameList == null)) {
			masTransactionType.setTransactionTypeCode(code);
			masTransactionType.setTransactionTypeName(name);
			masTransactionType.setStatus("y");
			masTransactionType.setLastChgBy(changedBy);
			masTransactionType.setLastChgDate(currentDate);
			masTransactionType.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addTransactionType(masTransactionType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
				|| (transactionTypeNameList.size() != 0)
				|| transactionTypeNameList != null) {

			if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
					&& (transactionTypeNameList.size() == 0 || transactionTypeNameList == null)) {

				message = "TransactionType Code  already exists.";
			} else if ((transactionTypeNameList.size() != 0 || transactionTypeNameList != null)
					&& (transactionTypeCodeList.size() == 0 || transactionTypeCodeList == null)) {

				message = "TransactionType Name already exists.";
			} else if ((transactionTypeCodeList.size() != 0 || transactionTypeCodeList != null)
					&& (transactionTypeNameList.size() != 0 || transactionTypeNameList != null)) {

				message = "TransactionType Code and TransactionType Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Add Transaction type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editTransactionType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String transactionTypeCode = "";
		String transactionTypeName = "";
		int transactionTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			transactionTypeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			transactionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			transactionTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", transactionTypeId);
		generalMap.put("transactionTypeCode", transactionTypeCode);
		generalMap.put("name", transactionTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTransactionTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingTransactionTypeNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editTransactionTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingTransactionTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Edit Transaction type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTransactionType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int transactionTypeId = 0;
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
			transactionTypeId = Integer.parseInt(request
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
		boolean dataDeleted = false;
		dataDeleted = systemRelatedMasterHandlerService.deleteTransactionType(
				transactionTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showTransactionTypeJsp";
		try {
			map = systemRelatedMasterHandlerService.showTransactionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRANSACTION_TYPE_JSP;
		title = "Delete Transaction type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------Frequency
	// ---------------------------------------------------------

	public ModelAndView searchFrequency(HttpServletRequest request,
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
		map = systemRelatedMasterHandlerService.searchFrequency(frequencyCode,
				frequencyName);
		jsp = FREQUENCY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("frequencyCode", frequencyCode);
		map.put("frequencyName", frequencyName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showFrequencyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.showFrequencyJsp();
		@SuppressWarnings("unused")
		ArrayList searchFrequencyList = (ArrayList) map
				.get("searchFrequencyList");
		jsp = FREQUENCY_JSP;
		jsp += ".jsp";
		title = "Frequency";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int frequencyValue=0;
		String frequencyType = ""; // added by amit das on 03-04-2017

		MasFrequency masFrequency = new MasFrequency();

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
		if (request.getParameter("frequencyValue") != null) {
			frequencyValue = Integer.parseInt(request.getParameter("frequencyValue"));
		}
		// added by amit das on 03-04-2017
		if (request.getParameter("frequencyType") != null) {
			frequencyType = request.getParameter("frequencyType");
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
			masFrequency.setFrequencyCode(code);
			masFrequency.setFrequencyName(name);
			masFrequency.setStatus("Y");
			/*//commented for maven*/			
			masFrequency.setFrequencyCount(frequencyValue); // uncommented by amit das on 03-04-2017
			masFrequency.setFrequencyType(frequencyType); // added by amit das on 03-04-2017
			Users users=new Users();
			users.setId((Integer)session.getAttribute(RequestConstants.USER_ID));
			masFrequency.setLastChgBy(users);
			
			masFrequency.setLastChgDate(currentDate);
			masFrequency.setLastChgTime(currentTime);
			successfullyAdded = systemRelatedMasterHandlerService
					.addFrequency(masFrequency);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		}

		else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
				|| (frequencyNameList.size() != 0) || frequencyNameList != null) {

			if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
					&& (frequencyNameList.size() == 0 || frequencyNameList == null)) {

				message = "Frequency Code  already exists.";
			} else if ((frequencyNameList.size() != 0 || frequencyNameList != null)
					&& (frequencyCodeList.size() == 0 || frequencyCodeList == null)) {

				message = "Frequency Name already exists.";
			} else if ((frequencyCodeList.size() != 0 || frequencyCodeList != null)
					&& (frequencyNameList.size() != 0 || frequencyNameList != null)) {

				message = "Frequency Code and Frequency Name already exist.";
			}
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";

		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Add Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editFrequency(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String frequencyCode = "";
		String frequencyName = "";
		String frequencyType = ""; // added by amit das on 03-04-2017
		int frequencyId = 0;
		int frequencyValue=0;
		Date changedDate = null;
		String changedTime = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			frequencyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			frequencyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			frequencyName = request.getParameter(SEARCH_NAME);
		}
	
		if (request.getParameter("frequencyValue") != null) {
			frequencyValue = Integer.parseInt(request.getParameter("frequencyValue"));
		}
		
		 // added by amit das on 03-04-2017
		if (request.getParameter("frequencyType") != null) {
			frequencyType = request.getParameter("frequencyType");
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

		generalMap.put("id", frequencyId);
		generalMap.put("frequencyCode", frequencyCode);
		generalMap.put("name", frequencyName);
		generalMap.put("frequencyValue", frequencyValue);
		generalMap.put("frequencyType", frequencyType); // added by amit das on 03-04-2017
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingFrequencyNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingFrequencyNameList.size() == 0) {
			dataUpdated = systemRelatedMasterHandlerService
					.editFrequencyToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingFrequencyNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";
		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Edit Frequency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int frequencyId = 0;
		String message = null;
		int userId = 0;
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
		userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataDeleted = false;
		dataDeleted = systemRelatedMasterHandlerService.deleteFrequency(
				frequencyId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showFrequencyJsp";
		try {
			map = systemRelatedMasterHandlerService.showFrequencyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FREQUENCY_JSP;
		title = "Delete Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -----------------------------------Department
	// ------------------------------

	public ModelAndView showDepartmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.showDepartmentJsp();
		jsp = DEPARTMENT_JSP+".jsp";
		title = "Department";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDepartment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDepartment masDepartment = new MasDepartment();
		String modalityName="";
		String deptDescription="";
		int departmentTypeId = 0;
		int costCenterId = 0;
		Integer storeType = 0;
		Integer changedBy = null;
		int empDeptId=0;
		Integer hospitalId=null;
		String webPortalDisplay="";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session=request.getSession();
		String changedTime = "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentTypeId = Integer.parseInt(request
					.getParameter(DEPARTMENT_TYPE_ID));
		}
		String visitApplicable="";
		if(request.getParameter("visitApplicable") !=null && !request.getParameter("visitApplicable").equals("-1")){
			if(request.getParameter("visitApplicable").equalsIgnoreCase("y")){
				visitApplicable="y";
			}
			else{
				visitApplicable="n";
			}
		}
		else{
			visitApplicable="n";
		}
		
		if (request.getParameter("webPortalDisplay") != null) {
			webPortalDisplay = request.getParameter("webPortalDisplay");
		}
		
		if (request.getParameter(COST_CENTER_ID) != null) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter("modalityName") != null) {
			modalityName = request.getParameter("modalityName");
		}
		if (request.getParameter("deptDescription") != null) {
			deptDescription = request.getParameter("deptDescription");
		}
		if (request.getParameter("store_type") != null && request.getParameter("store_type") != "") {
			storeType = Integer.parseInt(request.getParameter("store_type"));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !(session.getAttribute(RequestConstants.USER_ID).equals(""))) {
			changedBy =(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		if (request.getParameter("empDeptId") != null) {
			empDeptId = Integer.parseInt(request
					.getParameter("empDeptId"));
		}
		
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID).equals(""))) {
			hospitalId =(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
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
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		
		String servicecenter="";

		if (request.getParameter("servicecenter") != null) {
			servicecenter = request.getParameter("servicecenter");
			
		}
		else{
			servicecenter="N";
		}
		
		String payWard="";
		if (request.getParameter("payWard") != null) {
			payWard = request.getParameter("payWard");
		}
		else{
			payWard="n";
		}
		
		
		generalMap.put("servicecenter", servicecenter);
		
		code = commonMasterHandlerService.getMaxCode(pojoName,pojoPropertyCode);
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List departmentCodeList = new ArrayList();
		List departmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			departmentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			departmentNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((departmentCodeList.size() == 0 || departmentCodeList == null)
				&& (departmentNameList.size() == 0 || departmentNameList == null))
		{
			masDepartment.setDepartmentCode(code);
			masDepartment.setDepartmentName(name);
			if(storeType!=null && storeType>0){
			MasDepartment masDept =new MasDepartment();
			masDept.setId(storeType);
			masDepartment.setStoreType(masDept);
			}
			MasDepartmentType masDepartmentType = new MasDepartmentType();
			masDepartmentType.setId(departmentTypeId);
			masDepartment.setDepartmentType(masDepartmentType);
			if(costCenterId!=0)
			{
			MasCostCenter masCostCenter = new MasCostCenter();
			masCostCenter.setId(costCenterId);
			masDepartment.setCostCenter(masCostCenter);
			}
			if(webPortalDisplay!="")
			{
				masDepartment.setWebPortalDisplay(webPortalDisplay);
			}
			masDepartment.setModalityName(modalityName);
			masDepartment.setStatus("Y");
			Users users=new Users();
			users.setId(changedBy);
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			masDepartment.setHospital(hospital);
			masDepartment.setLastChgBy(users);
			masDepartment.setLastChgDate(currentDate);
			masDepartment.setLastChgTime(changedTime);
			masDepartment.setDeptDescription(deptDescription);
			masDepartment.setServiceCenter(servicecenter);
			masDepartment.setPaywardCheck(payWard);
			
			if(empDeptId!=0)
			{
			MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
			masEmployeeDepartment.setId(empDeptId);
			masDepartment.setEmpDept(masEmployeeDepartment);
			}
			masDepartment.setVisitApplicable(visitApplicable);
			successfullyAdded = systemRelatedMasterHandlerService
					.addDepartment(masDepartment);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((departmentCodeList.size() != 0 || departmentCodeList != null)
				|| (departmentNameList.size() != 0)
				|| departmentNameList != null) {

			if ((departmentCodeList.size() != 0 || departmentCodeList != null)
					&& (departmentNameList.size() == 0 || departmentNameList == null)) {

				message = "Department Code  already exists.";
			} else if ((departmentNameList.size() != 0 || departmentNameList != null)
					&& (departmentCodeList.size() == 0 || departmentCodeList == null)) {

				message = "Department Name  already exists.";
			} else if ((departmentCodeList.size() != 0 || departmentCodeList != null)
					&& (departmentNameList.size() != 0 || departmentNameList != null)) {

				message = "Department Code and Department Name already exist.";
			}
		}

		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "Add Department";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String departmentCode = null;
		String departmentName = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentName = request.getParameter(SEARCH_NAME);
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
			departmentCode = searchField;
			departmentName = null;

		} else {
			departmentCode = null;
			departmentName = searchField;
		}
		map = systemRelatedMasterHandlerService.searchDepartment(
				departmentCode, departmentName);

		jsp = DEPARTMENT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("departmentCode", departmentCode);
		map.put("departmentName", departmentName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDepartment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String departmentCode = "";
		String departmentName = "";
		String modalityName = "";
		String deptDescription = "";
		int departmentId = 0;
		int departmentTypeId = 0;
		int costCenterId = 0;
		Integer storeType = null;
		Integer changedBy = null;
		Date changedDate = null;
		String changedTime = "";
		int empDeptId=0;
		departmentCode = (String) session.getAttribute("departmentCode");
		departmentName = (String) session.getAttribute("departmentName");
		String webPortalDisplay ="";
		if (request.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentTypeId = Integer.parseInt(request
					.getParameter(DEPARTMENT_TYPE_ID));
		}
		if (request.getParameter(COST_CENTER_ID) != null) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			departmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			departmentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("webPortalDisplay") != null) {
			webPortalDisplay = request.getParameter("webPortalDisplay");
		}
		if (request.getParameter("modalityName") != null) {
			modalityName = request.getParameter("modalityName");
		}
		if (request.getParameter("deptDescription") != null) {
			deptDescription = request.getParameter("deptDescription");
		}
		if (request.getParameter("store_type") != null && request.getParameter("store_type") != "") {
			storeType = Integer.parseInt(request.getParameter("store_type"));
		}
		if (request.getParameter("empDeptId") != null) {
			empDeptId = Integer.parseInt(request
					.getParameter("empDeptId"));
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			changedBy = (Integer)session.getAttribute(RequestConstants.USER_ID);
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
		String servicecenter="";

		if (request.getParameter("servicecenter") != null) {
			servicecenter = request.getParameter("servicecenter");
			
		}
		else{
			servicecenter="N";
		}
		String payWard="";
		if (request.getParameter("payWard") != null) {
			payWard = request.getParameter("payWard");
		}
		else{
			payWard="n";
		}
		
		String visitApplicable="";
		if(request.getParameter("visitApplicable") !=null && !request.getParameter("visitApplicable").equals("-1")){
			if(request.getParameter("visitApplicable").equalsIgnoreCase("y")){
				visitApplicable="y";
			}
			else{
				visitApplicable="n";
			}
		}
		else{
			visitApplicable="n";
		}
		LOGGER.info("visitApplicable "+visitApplicable);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", departmentId);
		generalMap.put("departmentCode", departmentCode);
		generalMap.put("name", departmentName);
		generalMap.put("departmentTypeId", departmentTypeId);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("storeType", storeType);
		generalMap.put("modalityName", modalityName);
		generalMap.put("deptDescription", deptDescription);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("webPortalDisplay", webPortalDisplay);
		generalMap.put("servicecenter", servicecenter);
		generalMap.put("empDeptId", empDeptId);
		generalMap.put("flag", true);
		generalMap.put("visitApplicable", visitApplicable);
		generalMap.put("payWard", payWard);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDepartmentNameList = new ArrayList();
		if(listMap.get("duplicateMastersList")!=null){
		 existingDepartmentNameList = (List) listMap
				.get("duplicateMastersList");
		}
		boolean dataUpdated = false;
		if (existingDepartmentNameList.size() == 0) {

			dataUpdated = systemRelatedMasterHandlerService
					.editDepartmentToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDepartmentNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";
		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "Edit Department";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		String message = null;
		Integer changedBy = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			departmentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null
				&& !session.getAttribute(RequestConstants.USER_ID).equals("")) {
			changedBy =(Integer) session.getAttribute(RequestConstants.USER_ID);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = systemRelatedMasterHandlerService.deleteDepartment(
				departmentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showDepartmentJsp";

		try {
			map = systemRelatedMasterHandlerService.showDepartmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_JSP;
		title = "delete Department";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------Leave master---------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.showLeaveJsp();
		jsp = LEAVE_JSP;
		jsp += ".jsp";
		title = "Leave";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLeave(HttpServletRequest request,
			HttpServletResponse response) {
		Date currentDate = new Date();
		String description = "";
		int changedBy = 0;
		String currentTime = "";
		int hospitalId = 0;
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = Integer.parseInt(request.getParameter(CHANGED_BY));
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
		HrMasLeave hrMasLeave = new HrMasLeave();
		hrMasLeave.setDescription(description);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrMasLeave.setCompany(masHospital);

		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		hrMasLeave.setStatus("y");

		map = systemRelatedMasterHandlerService.addLeave(hrMasLeave);
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLeave(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int leaveId = 0;
		String description = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int hospitalId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			leaveId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(DESCRIPTION) != null
				&& !(request.getParameter(DESCRIPTION).equals(""))) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("leaveId", leaveId);
		generalMap.put("description", description);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		map = systemRelatedMasterHandlerService.editLeave(generalMap);
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteLeave(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int leaveId = 0;
		String message = "";
		String changedTime = "";
		String changedBy = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			leaveId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		generalMap.put("leaveId", leaveId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		map = systemRelatedMasterHandlerService.deleteLeave(generalMap);
		String jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchLeave(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String description = "";
		if (request.getParameter(DESCRIPTION) != null
				&& !(request.getParameter(DESCRIPTION).equals(""))) {
			description = request.getParameter(DESCRIPTION);
		}
		map = systemRelatedMasterHandlerService.searchLeave(description);

		jsp = LEAVE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("description", description);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showDepartInstiHierarchy(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		int userType=0;
		Users users=null;
		Map<String,Object> datamap = new HashMap<String,Object>();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
			datamap.put("userId", users.getId());
		}
		datamap.put("userType", userType);
		
		map = systemRelatedMasterHandlerService.showDepartInstiHierarchy(datamap);
		@SuppressWarnings("unused")
		ArrayList searchDepartmentList = (ArrayList) map.get("searchDepartmentList");
				
		jsp = "departmentInstituteHierarchy";
		jsp += ".jsp";
		title = "Department";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userType", userType);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveDepartmentForInstitute(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession(true);
		
		MasHospital Institute = new MasHospital();
		//MasDepartment department = new MasDepartment();
		//MasInstituteDepartment masInstituteDepartment = new MasInstituteDepartment();
		String instituteStr = request.getParameter("Institute");
		/*if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		}*/
		if(instituteStr!=null && !instituteStr.equals(""))
		{
			Institute.setId(new Integer(instituteStr));
		}

		map = systemRelatedMasterHandlerService.showDeptMapJsp(Institute.getId());
		
		@SuppressWarnings("unused")
		
		ArrayList<MasInstituteDepartment> alreadyAssignedDeptList = (ArrayList)map.get("deptMapList"); // already_list
		
		String [] toBeAssignedDeprtmentList = {"0"}; // new_list
		// List<Integer> toBeAssignedIdList = new ArrayList(); // new_id
		Set<Integer> toBeAssignedIdSet = new HashSet<Integer>(); // new_id
		List<Integer> alreadyAssignesdDeparmentIdList = new ArrayList<Integer>();// already_id
		if(request.getParameterValues("tempId")!=null && request.getParameterValues("tempId").length !=0) {
			toBeAssignedDeprtmentList = request.getParameterValues("tempId"); // new_list -----  added from form
		}
		
		for(int i = 0 ; i < toBeAssignedDeprtmentList.length ; i++) {
			toBeAssignedIdSet.add(new Integer(toBeAssignedDeprtmentList[i])); // Id added in new_id
		}
		for(MasInstituteDepartment o : alreadyAssignedDeptList) {
			alreadyAssignesdDeparmentIdList.add(o.getDepartment().getId());// Id added in already_id
		}
		
		List duplicateToBeAssignedList = new ArrayList();
		List<Integer> duplicateAlreadyAssignedDepartList = new ArrayList<Integer>();

		for(Integer o : toBeAssignedIdSet) {
			duplicateToBeAssignedList.add(o); //copy of new_Id
		}
		for(Integer o:  alreadyAssignesdDeparmentIdList) {
			duplicateAlreadyAssignedDepartList.add(o);//copy of already_Id
		}
		duplicateToBeAssignedList.removeAll(alreadyAssignesdDeparmentIdList); // remove already Id From  copy of new_Id
		duplicateAlreadyAssignedDepartList.removeAll(toBeAssignedIdSet);     // remove new _Id From  copy of already_Id
		
		Map parameterMap = new HashMap();
		if(duplicateToBeAssignedList.size()>0) {
			parameterMap.put("deptList", duplicateToBeAssignedList);
			parameterMap.put("instiId", Institute.getId());
			parameterMap.put("status", "n");
			List<MasInstituteDepartment> inactiveDeptTaskMap = systemRelatedMasterHandlerService.getInstituteDeptMap(parameterMap); 

			//Added by Arbind on 19-12-2017
			List<Integer> duplicateExistingdDeparmentIdList = new ArrayList<Integer>();
			//checking first in Db and activating them
			for(MasInstituteDepartment o: inactiveDeptTaskMap) {
				if(!duplicateExistingdDeparmentIdList.contains(o.getDepartment().getId())) {
					o.setStatus("y");
					systemRelatedMasterHandlerService.saveDeptMapDB(o);
					duplicateToBeAssignedList.remove(o.getDepartment().getId());
					duplicateExistingdDeparmentIdList.add(o.getDepartment().getId());
				}
			}
			message = "Data updated Successfully !!";
		}
		if(duplicateToBeAssignedList.size()>0) {
			List<MasDepartment> duplicateToBeAssignedList2 = systemRelatedMasterHandlerService.getDeptMapFromDB(duplicateToBeAssignedList);
	
			for(MasDepartment depmap : duplicateToBeAssignedList2) {
				MasInstituteDepartment deptInstiMap = new MasInstituteDepartment();
				deptInstiMap.setDepartment(depmap);
				deptInstiMap.setInstitute(Institute);
				/*deptInstiMap.setHospital(hospital);*/
				deptInstiMap.setStatus("y");
				boolean save = false;
				save = systemRelatedMasterHandlerService.saveDeptMapDB(deptInstiMap);
			}
		}
		
		if(duplicateAlreadyAssignedDepartList.size()>0) {
			parameterMap.put("deptList", duplicateAlreadyAssignedDepartList);
			parameterMap.put("instiId", Institute.getId());
			parameterMap.put("status", "y");
			List<MasInstituteDepartment> deptTaskMapTaskWise = systemRelatedMasterHandlerService.getInstituteDeptMap(parameterMap); 
			// inactivating 
			for(MasInstituteDepartment o : deptTaskMapTaskWise) {
				o.setStatus("n");
				systemRelatedMasterHandlerService.saveDeptMapDB(o);
			}
		}
		int userType=0;
		Users users=null;
		Map<String,Object> datamap = new HashMap<String,Object>();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
			datamap.put("userId", users.getId());
		}
		datamap.put("userType", userType);
		
		map = systemRelatedMasterHandlerService.showDepartInstiHierarchy(datamap);
		jsp = "departmentInstituteHierarchy.jsp";
		//jsp += ".jsp";
		title = "Department Institute";
		map.put("contentJsp",jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView fillInst(HttpServletRequest request,
			HttpServletResponse response) {
		String Val =request.getParameter("Val");
		session = request.getSession(true);
		map = systemRelatedMasterHandlerService.fillInst(Val);
		/*@SuppressWarnings("unused")
		ArrayList searchDepartmentTypeList = (ArrayList) map
				.get("searchDepartmentTypeList");*/
		jsp = "responseInstDept";
		/*jsp += ".jsp";*/
		title = "DepartmentType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView showInstituteWiseServiceCentersDetailsJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String hospitalName = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("hospitalName") != null) {
			hospitalName = (String) session.getAttribute("hospitalName");
			box.put("hospitalName", hospitalName);
		}
		map = systemRelatedMasterHandlerService.showInstituteWiseServiceCentersDetailsJsp(box);
		jsp = "instituteWiseServiceCentersDetails";
		jsp += ".jsp";
		title = "institute Wise Service Centers Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchInstituteWiseCenterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String hospitalName = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("hospitalName") != null) {
			hospitalName = (String) session.getAttribute("hospitalName");
			box.put("hospitalName", hospitalName);
		}
		map = systemRelatedMasterHandlerService.searchInstituteWiseCenterDetails(box);
		jsp = "instituteWiseServiceCentersDetails";
		jsp += ".jsp";
		title = "institute Wise Service Centers Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitInstituteWiseCenterDetails( HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String hospitalName = "";
		int userId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		if (session.getAttribute("hospitalName") != null) {
			hospitalName = (String) session.getAttribute("hospitalName");
			box.put("hospitalName", hospitalName);
		}
		map = systemRelatedMasterHandlerService.submitInstituteWiseCenterDetails(box);
		jsp = "instituteWiseServiceCentersDetails";
		jsp += ".jsp";
		title = "institute Wise Service Centers Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView showVersionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) systemRelatedMasterHandlerService.showVersion();
		String jsp = "version";
		jsp += ".jsp";
		title = "version";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addVersion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasApkVersion masVersion = new MasApkVersion();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

String apkVersionType="";
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
			if (request.getParameter("apkVersionType") != null
					&& !(request.getParameter("apkVersionType").equals(""))) {
				apkVersionType = request.getParameter("apkVersionType");
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
		List versionCodeList = new ArrayList();
		List versionNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			versionCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			versionNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((versionCodeList.size() == 0 || versionCodeList == null)
				&& (versionNameList.size() == 0 || versionNameList == null)) {
			masVersion.setVersionCode(code);
			masVersion.setVersionName(name);


			Users users = new Users();
			users.setId(userId);
			masVersion.setLastChgBy(users);

		
			masVersion.setStatus("Y");
			masVersion.setLastChgDate(currentDate);
			masVersion.setLastChgTime(currentTime);
			masVersion.setApkVersionType(apkVersionType);
			successfullyAdded = systemRelatedMasterHandlerService.addVersion(masVersion);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((versionCodeList.size() != 0 || versionCodeList != null)
				|| (versionNameList.size() != 0) || versionNameList != null) {
			if ((versionCodeList.size() != 0 || versionCodeList != null)
					&& (versionNameList.size() == 0 || versionNameList == null)) {
				message = "Version Code already exists.";
			} else if ((versionNameList.size() != 0 || versionNameList != null)
					&& (versionCodeList.size() == 0 || versionCodeList == null)) {
				message = "Version Name already exists.";
			} else if ((versionCodeList.size() != 0 || versionCodeList != null)
					&& (versionCodeList.size() != 0 || versionNameList != null)) {
				message = "Version Code and Name exist.";
			}
		}
		try {
			map = systemRelatedMasterHandlerService.showVersion();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "version";
		title = " Add version";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editVersion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String versionCode = "";
		String versionName = "";
		int versionId = 0;
		Date changedDate = null;
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		int hospitalId = 0;
String apkVersionType="";
		try {
		
			if (request.getParameter(HOSPITAL_ID) != null
					&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				versionId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				versionCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				versionName = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("apkVersionType") != null
					&& !(request.getParameter("apkVersionType").equals(""))) {
				apkVersionType = request.getParameter("apkVersionType");
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

			generalMap.put("id", versionId);
			generalMap.put("versionCode", versionCode);
			generalMap.put("name", versionName);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("apkVersionType", apkVersionType);
			
			Map<String, Object> listMap = new HashMap<String, Object>();

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingVersionNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingVersionNameList.size() == 0) {
				dataUpdated = systemRelatedMasterHandlerService
						.editVersion(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingVersionNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = systemRelatedMasterHandlerService.showVersion();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// jsp="version"_JSP;
		// title="Edit Version";
		// jsp += ".jsp";

		String jsp = "version";
		title = " Edit version";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchVersion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String versionCode = null;
		String versionName = null;
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
			versionCode = searchField;
			versionName = null;

		} else {
			versionCode = null;
			versionName = searchField;
		}


		map = systemRelatedMasterHandlerService.searchVersion(versionCode,
				versionName);

		jsp = "version";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("versionCode", versionCode);
		map.put("versionName", versionName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteVersion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int versionId = 0;
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
			versionId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = systemRelatedMasterHandlerService.deleteVersion(versionId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/systemRelatedMaster?method=showVersionJsp";
		try {
			map = systemRelatedMasterHandlerService.showVersion();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "version";
		title = "delete Version";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public SystemRelatedMasterHandlerService getSystemRelatedMasterHandlerService() {
		return systemRelatedMasterHandlerService;
	}

	public void setSystemRelatedMasterHandlerService(
			SystemRelatedMasterHandlerService systemRelatedMasterHandlerService) {
		this.systemRelatedMasterHandlerService = systemRelatedMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	//added by govind 20-12-2016
	public ModelAndView fillInstHospital(HttpServletRequest request,
			HttpServletResponse response) {
		int districtId=0,instType=0;
		session = request.getSession(true);
		if(request.getParameter("districtId")!=null){
			districtId=Integer.parseInt(request.getParameter("districtId"));
		}
		if(request.getParameter("instType")!=null){
			instType=Integer.parseInt(request.getParameter("instType"));
		}
		map = systemRelatedMasterHandlerService.fillInstHospital(districtId,instType);
		jsp = "responseInstHospital";
		/*jsp += ".jsp";*/
		title = "Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}//added by govind 20-12-2016 end

}
