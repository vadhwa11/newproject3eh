package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ACCOUNT_CODE;
import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_MASTER_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_NAME;
import static jkt.hms.util.RequestConstants.ACCOUNT_TYPE_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.BANK_CODE;
import static jkt.hms.util.RequestConstants.BANK_JSP;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.BILL_TYPE_ID;
import static jkt.hms.util.RequestConstants.BILL_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMPANY;
import static jkt.hms.util.RequestConstants.CR_BALANCE;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DISCOUNT_JSP;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.DISCOUNT_TYPE;
import static jkt.hms.util.RequestConstants.DISCOUNT_VALUE;
import static jkt.hms.util.RequestConstants.DR_BALANCE;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_FROM;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_TO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INSURANCE_AMOUNT;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.OTHER_CATEGORY;
import static jkt.hms.util.RequestConstants.PATIENT_CATEGORY;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.PROJECT_ID;
import static jkt.hms.util.RequestConstants.ROOM_TYPE_ID;
import static jkt.hms.util.RequestConstants.SALES_TAX;
import static jkt.hms.util.RequestConstants.SALES_TAX_TYPE;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.DISCOUNT;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.BlPriority;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountType;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillScheme;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.PatientCategoryDetails;
import jkt.hms.masters.business.RsbyCardDetails;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.BillingMasterHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BillingMasterController extends MultiActionController {

	BillingMasterHandlerService billingMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String code = "";
	String bed = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	HttpSession session = null;
	String viewPage = "";
	String currentTime = "";

	// ----------------------------------- Account
	// Type--------------------------------------

	public ModelAndView searchAccountType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String accountTypeCode = null;
		String accountTypeName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			accountTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			accountTypeName = request.getParameter(SEARCH_NAME);
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
			accountTypeCode = searchField;
			accountTypeName = null;
		} else {
			accountTypeCode = null;
			accountTypeName = searchField;
		}
		map = billingMasterHandlerService.searchAccountType(accountTypeCode,
				accountTypeName);
		jsp = ACCOUNT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("accountTypeCode", accountTypeCode);
		map.put("accountTypeName", accountTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAccountTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = billingMasterHandlerService.showAccountTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchAccountTypeList = (ArrayList) map
				.get("searchAccountTypeList");
		jsp = ACCOUNT_TYPE_JSP;
		jsp += ".jsp";
		title = "AccountType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAccountType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		FaMasAccountType faMasAccountType = new FaMasAccountType();

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

		List accountTypeCodeList = new ArrayList();
		List accountTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			accountTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			accountTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((accountTypeCodeList.size() == 0 || accountTypeCodeList == null)
				&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {
			faMasAccountType.setAccountTypeCode(code);
			faMasAccountType.setAccountTypeName(name);
			faMasAccountType.setStatus("y");
			//commented for maven
			/*faMasAccountType.setLastChgBy(changedBy);*/
			faMasAccountType.setLastChgDate(currentDate);
			faMasAccountType.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService
					.addAccountType(faMasAccountType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
				|| (accountTypeNameList.size() != 0)
				|| accountTypeNameList != null) {

			if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {

				message = "Account Type Code  already exists.";
			} else if ((accountTypeNameList.size() != 0 || accountTypeNameList != null)
					&& (accountTypeCodeList.size() == 0 || accountTypeCodeList == null)) {

				message = "Account Type Name already exists.";
			} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() != 0 || accountTypeNameList != null)) {
				message = "Account Type Code and Account Type Name already exist.";
			}
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";
		try {
			map = billingMasterHandlerService.showAccountTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Add Account Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editAccountType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String accountTypeCode = "";
		String accountTypeName = "";
		int accountTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		accountTypeName = (String) session.getAttribute("chargeTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			accountTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			accountTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", accountTypeId);
		generalMap.put("accountTypeCode", accountTypeCode);
		generalMap.put("name", accountTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAccountTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAccountTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editAccountTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingAccountTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";

		try {
			map = billingMasterHandlerService.showAccountTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Edit Account Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int accountTypeId = 0;
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
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteAccountType(
				accountTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showAccountTypeJsp";

		try {
			map = billingMasterHandlerService.showAccountTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ACCOUNT_TYPE_JSP;
		title = "Delete Account Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------- Charge
	// Type---------------------------------------------

	public ModelAndView searchChargeType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeTypeCode = null;
		String chargeTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			chargeTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			chargeTypeName = request.getParameter(SEARCH_NAME);
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
			chargeTypeCode = searchField;
			chargeTypeName = null;

		} else {
			chargeTypeCode = null;
			chargeTypeName = searchField;
		}
		map = billingMasterHandlerService.searchChargeType(chargeTypeCode,
				chargeTypeName);
		jsp = CHARGE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeTypeCode", chargeTypeCode);
		map.put("chargeTypeName", chargeTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showChargeTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = billingMasterHandlerService.showChargeTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchChargeTypeList = (ArrayList) map
				.get("searchChargeTypeList");
		jsp = CHARGE_TYPE_JSP;
		jsp += ".jsp";
		title = "ChargeType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addChargeType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		MasChargeType masChargeType = new MasChargeType();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String chargeTypeStatus="";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter("chargeTypeStatus") != null) {
			chargeTypeStatus = request.getParameter("chargeTypeStatus");
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

		List chargeTypeCodeList = new ArrayList();
		List chargeTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			chargeTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((chargeTypeCodeList.size() == 0 || chargeTypeCodeList == null)
				&& (chargeTypeNameList.size() == 0 || chargeTypeNameList == null)) {
			masChargeType.setChargeTypeCode(code);
			masChargeType.setChargeTypeName(name);
			masChargeType.setChargeTypeStatus(chargeTypeStatus);
			masChargeType.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masChargeType.setLastChgBy(users);
			masChargeType.setLastChgDate(currentDate);
			masChargeType.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService
					.addChargeType(masChargeType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
				|| (chargeTypeNameList.size() != 0)
				|| chargeTypeNameList != null) {

			if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
					&& (chargeTypeNameList.size() == 0 || chargeTypeNameList == null)) {

				message = "Charge Type Code  already exists.";
			} else if ((chargeTypeNameList.size() != 0 || chargeTypeNameList != null)
					&& (chargeTypeCodeList.size() == 0 || chargeTypeCodeList == null)) {

				message = "Charge Type Name already exists.";
			} else if ((chargeTypeCodeList.size() != 0 || chargeTypeCodeList != null)
					&& (chargeTypeNameList.size() != 0 || chargeTypeNameList != null)) {
				message = "Charge Type Code and Charge Type Name already exist.";
			}
		}

		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";
		try {
			map = billingMasterHandlerService.showChargeTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Add Charge Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editChargeType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String chargeTypeCode = "";
		String chargeTypeName = "";
		int chargeTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		String chargeTypeStatus="";
		Date changedDate = null;

		chargeTypeCode = (String) session.getAttribute("chargeTypeCode");
		chargeTypeName = (String) session.getAttribute("chargeTypeName");
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			chargeTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			chargeTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			chargeTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		if (request.getParameter("chargeTypeStatus") != null) {
			chargeTypeStatus = request.getParameter("chargeTypeStatus");
		}
		
		generalMap.put("id", chargeTypeId);
		generalMap.put("chargeTypeCode", chargeTypeCode);
		generalMap.put("name", chargeTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("chargeTypeStatus", chargeTypeStatus);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingChargeTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingChargeTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editChargeTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingChargeTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";

		try {
			map = billingMasterHandlerService.showChargeTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Edit Charge Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteChargeType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int chargeTypeId = 0;
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
			chargeTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteChargeType(
				chargeTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showChargeTypeJsp";

		try {
			map = billingMasterHandlerService.showChargeTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_TYPE_JSP;
		title = "Delete Charge Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------------Bill
	// Type----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBillTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = (Map<String, Object>) billingMasterHandlerService
				.showBillTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchBillTypeList = (ArrayList) map
				.get("searchBillTypeList");
		jsp = BILL_TYPE_JSP;
		jsp += ".jsp";
		title = "Bill Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBillType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String billTypeCode = null;
		String billTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			billTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			billTypeName = request.getParameter(SEARCH_NAME);
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
			billTypeCode = searchField;
			billTypeName = null;

		} else {
			billTypeCode = null;
			billTypeName = searchField;
		}
		map = billingMasterHandlerService.searchBillType(billTypeCode,
				billTypeName);
		jsp = BILL_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("billTypeCode", billTypeCode);
		map.put("billTypeName", billTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		MasBillType masBillType = new MasBillType();
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
		List billTypeCodeList = new ArrayList();
		List billTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			billTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			billTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((billTypeCodeList.size() == 0 || billTypeCodeList == null)
				&& (billTypeNameList.size() == 0 || billTypeNameList == null)) {
			masBillType.setBillTypeCode(code);
			masBillType.setBillTypeName(name);
			masBillType.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masBillType.setLastChgBy(users);
			masBillType.setLastChgDate(currentDate);
			masBillType.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService
					.addBillType(masBillType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
				|| (billTypeNameList.size() != 0) || billTypeNameList != null) {
			if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
					&& (billTypeNameList.size() == 0 || billTypeNameList == null)) {
				message = "Bill Type Code  already exists.";
			} else if ((billTypeNameList.size() != 0 || billTypeNameList != null)
					&& (billTypeCodeList.size() == 0 || billTypeCodeList == null)) {
				message = "Bill Type Name already exists.";
			} else if ((billTypeCodeList.size() != 0 || billTypeCodeList != null)
					&& (billTypeNameList.size() != 0 || billTypeNameList != null)) {
				message = "Bill Type Code and Bill Type Name already exist.";
			}
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "Add Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String billTypeCode = "";
		String billTypeName = "";
		int billTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		billTypeCode = (String) session.getAttribute("billTypeCode");
		billTypeName = (String) session.getAttribute("billTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			billTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			billTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			billTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", billTypeId);
		generalMap.put("billTypeCode", billTypeCode);
		generalMap.put("name", billTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBillTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBillTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editBillTypeToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data Updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBillTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "update Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBillType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int billTypeId = 0;
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
			billTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteBillType(billTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/otMaster?method=showBillTypeJsp";
		try {
			map = billingMasterHandlerService.showBillTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BILL_TYPE_JSP;
		title = "delete Bill Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Bank
	// Master------------------------------

	public ModelAndView searchBank(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bankCode = null;
		String bankName = null;
		String searchField = null;

		if (request.getParameter(BANK_CODE) != null
				&& !(request.getParameter(BANK_CODE).equals(""))) {
			bankCode = request.getParameter(BANK_CODE);
		}

		if (request.getParameter(BANK_NAME) != null
				&& !(request.getParameter(BANK_NAME).equals(""))) {
			bankName = request.getParameter(BANK_NAME);
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
			bankCode = searchField;
			bankName = null;
		} else {
			bankCode = null;
			bankName = searchField;
		}
		map = billingMasterHandlerService.searchBank(bankCode, bankName);
		jsp = BANK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bankCode", bankCode);
		map.put("bankName", bankName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBankJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = billingMasterHandlerService.showBankJsp();
		@SuppressWarnings("unused")
		ArrayList searchBankList = (ArrayList) map.get("searchBankList");
		jsp = BANK_JSP;
		jsp += ".jsp";
		title = "Bank";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasBankMaster masBank = new MasBankMaster();
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

		List bankCodeList = new ArrayList();
		List bankNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bankCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bankNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bankCodeList.size() == 0 || bankCodeList == null)
				&& (bankNameList.size() == 0 || bankNameList == null)) {
			masBank.setBankCode(code);
			masBank.setBankName(name);
			masBank.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masBank.setLastChgBy(users);
			masBank.setLastChgDate(currentDate);
			masBank.setLastChgTime(currentTime);
			successfullyAdded = billingMasterHandlerService.addBank(masBank);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((bankCodeList.size() != 0 || bankCodeList != null)
				|| (bankNameList.size() != 0) || bankNameList != null) {

			if ((bankCodeList.size() != 0 || bankCodeList != null)
					&& (bankNameList.size() == 0 || bankNameList == null)) {

				message = "Bank Code  already exists.";
			} else if ((bankNameList.size() != 0 || bankNameList != null)
					&& (bankCodeList.size() == 0 || bankCodeList == null)) {

				message = "Bank Name already exists.";
			} else if ((bankCodeList.size() != 0 || bankCodeList != null)
					&& (bankNameList.size() != 0 || bankNameList != null)) {

				message = "Bank Code and Bank Name already exist.";
			}
		}

		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Add Bank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editBank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String bankCode = "";
		String bankName = "";
		int bankId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		String changedTime = "";
		Date changedDate = null;

		bankCode = (String) session.getAttribute("bankCode");
		bankName = (String) session.getAttribute("bankName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bankId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bankName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", bankId);
		generalMap.put("bankCode", bankCode);
		generalMap.put("name", bankName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBankNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBankNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editBankToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingBankNameList.size() > 0) {

			message = "Name already exists.";

		}
		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Edit Bank";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteBank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bankId = 0;
		String message = null;
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
			bankId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService
				.deleteBank(bankId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showBankJsp";

		try {
			map = billingMasterHandlerService.showBankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BANK_JSP;
		title = "Delete Bank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------Sales Tax Type
	// --------------------------------------------------------------
	public ModelAndView searchSalesTaxType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String salesTaxTypeCode = null;
		String salesTaxTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			salesTaxTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			salesTaxTypeName = request.getParameter(SEARCH_NAME);
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
			salesTaxTypeCode = searchField;
			salesTaxTypeName = null;
		} else {
			salesTaxTypeCode = null;
			salesTaxTypeName = searchField;
		}
		map = billingMasterHandlerService.searchSalesTaxType(salesTaxTypeCode,
				salesTaxTypeName);
		jsp = SALES_TAX_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("salesTaxTypeCode", salesTaxTypeCode);
		map.put("salesTaxTypeName", salesTaxTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSalesTaxTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = billingMasterHandlerService.showSalesTaxTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchSalesTaxTypeList = (ArrayList) map
				.get("searchSalesTaxTypeList");
		jsp = SALES_TAX_TYPE;
		jsp += ".jsp";
		title = "Sales Tax Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSalesTaxType(HttpServletRequest request,
			HttpServletResponse response) {
		BigDecimal saleTax = new BigDecimal(0);
		Map<String, Object> map = new HashMap<String, Object>();
		MasSalesTaxType masSalesTaxType = new MasSalesTaxType();
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
		if (request.getParameter(SALES_TAX) != null
				&& !(request.getParameter(SALES_TAX).equals(""))) {
			saleTax = new BigDecimal(request.getParameter(SALES_TAX));
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

		List salesTaxTypeCodeList = new ArrayList();
		List salesTaxTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			salesTaxTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			salesTaxTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((salesTaxTypeCodeList.size() == 0 || salesTaxTypeCodeList == null)
				&& (salesTaxTypeNameList.size() == 0 || salesTaxTypeNameList == null)) {
			masSalesTaxType.setSalesTaxTypeCode(code);
			masSalesTaxType.setSalesTaxTypeName(name);
			masSalesTaxType.setStatus("y");
			masSalesTaxType.setLastChgBy(changedBy);
			masSalesTaxType.setLastChgDate(currentDate);
			masSalesTaxType.setLastChgTime(currentTime);
			masSalesTaxType.setSaleTax(saleTax);
			successfullyAdded = billingMasterHandlerService
					.addSalesTaxType(masSalesTaxType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
				|| (salesTaxTypeNameList.size() != 0)
				|| salesTaxTypeNameList != null) {

			if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
					&& (salesTaxTypeNameList.size() == 0 || salesTaxTypeNameList == null)) {

				message = "SalesTax Type Code  already exists.";
			} else if ((salesTaxTypeNameList.size() != 0 || salesTaxTypeNameList != null)
					&& (salesTaxTypeCodeList.size() == 0 || salesTaxTypeCodeList == null)) {

				message = "SalesTax Type Name already exists.";
			} else if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
					&& (salesTaxTypeNameList.size() != 0 || salesTaxTypeNameList != null)) {

				message = "SalesTax Type Code and SalesTax Type Name already exist.";
			}
		}

		url = "/hms/hms/billingMaster?method=showSalesTaxTypeJsp";

		try {
			map = billingMasterHandlerService.showSalesTaxTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TAX_TYPE;
		title = "Add Sales Tax Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSalesTaxType(HttpServletRequest request,
			HttpServletResponse response) {
		BigDecimal saleTax = new BigDecimal(0);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String salesTaxTypeCode = "";
		String salesTaxTypeName = "";
		int salesTaxTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		salesTaxTypeCode = (String) session.getAttribute("salesTaxTypeCode");
		salesTaxTypeName = (String) session.getAttribute("salesTaxTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			salesTaxTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			salesTaxTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			salesTaxTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(SALES_TAX) != null
				&& !(request.getParameter(SALES_TAX).equals(""))) {
			saleTax = new BigDecimal(request.getParameter(SALES_TAX));
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

		generalMap.put("id", salesTaxTypeId);
		generalMap.put("bankCode", salesTaxTypeCode);
		generalMap.put("saleTax", saleTax);
		generalMap.put("name", salesTaxTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSalesTaxTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSalesTaxTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editSalesTaxTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingSalesTaxTypeNameList.size() > 0) {

			message = "Name already exists.";

		}
		url = "/hms/hms/billingMaster?method=showSalesTaxTypeJsp";

		try {
			map = billingMasterHandlerService.showSalesTaxTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TAX_TYPE;
		title = "Edit Sales Tax Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteSalesTaxType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int salesTaxTypeId = 0;
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
			salesTaxTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteSalesTaxType(
				salesTaxTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showSalesTaxTypeJsp";

		try {
			map = billingMasterHandlerService.showSalesTaxTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TAX_TYPE;
		title = "Delete SalesTax type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showDiscountJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put("localdiscount", false);
		
		map = billingMasterHandlerService.showDiscountJsp(box);
		
		jsp = DISCOUNT_JSP;
		jsp += ".jsp";
		title = "Discount";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView deleteDiscount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int discountId = 0;
		String message = null;
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put("localdiscount", false);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter("discountId") != null
				&& !(request.getParameter("discountId").equals("0"))) {
			discountId = Integer.parseInt(request.getParameter("discountId"));
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
		dataDeleted = billingMasterHandlerService.deleteDiscount(discountId,generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showDiscountJsp";
		try {
			map = billingMasterHandlerService.showDiscountJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISCOUNT_JSP;
		title = "delete Discount";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getDrugNamesForAutocomplete(HttpServletRequest request,
			HttpServletResponse response)
	{
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		session = request.getSession();
		
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("requiredField") != null)
		{
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null)
		{
			autoHint = (request.getParameter(itemNameField));
		}
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		
		map = billingMasterHandlerService.getDrugNamesForAutocomplete(dataMap);
		jsp = "autocompleteResultForDrugNames";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView saveDiscount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		
		// map = billingMasterHandlerService.showDiscountJsp(box); // commented by amit das on 17-06-2016
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		box.put(HOSPITAL_ID, hospitalId);
		box.put("localdiscount", false);
		
		//MasDiscount masDiscount = new MasDiscount();
		
		String message = "";
		Boolean chargeStatus = false;
		List<MasDiscount> existingMasDiscountList = new ArrayList<MasDiscount>();
		/*int hospitalId = 0;
		int chargeCodeId = 0;
		
		
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masDiscount.setHospital(masHospital);
		}
		if (request.getParameter(PATIENT_TYPE_ID) != null) {
			int patientTypeId = Integer.parseInt(request
					.getParameter(PATIENT_TYPE_ID));
			MasPatientType masPatientType = new MasPatientType();
			masPatientType.setId(patientTypeId);
			masDiscount.setPatientType(masPatientType);
			parameterMap.put("patientTypeId", patientTypeId);
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
			int employeeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			masDiscount.setEmployee(masEmployee);
		}
		if (!request.getParameter(EMPLOYEE_DEPENDENT_ID).equals("0")) {
			int employeeDependentId = Integer.parseInt(request
					.getParameter(EMPLOYEE_DEPENDENT_ID));
			MasEmployeeDependent masEmployeeDependent = new MasEmployeeDependent();
			masEmployeeDependent.setId(employeeDependentId);
			masDiscount.setEmployeeDependent(masEmployeeDependent);

		}
		if (!request.getParameter(PROJECT_ID).equals("0")) {
			int projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
			MasCompany masCompany = new MasCompany();
			masCompany.setId(projectId);
			masDiscount.setCompany(masCompany);
			parameterMap.put("companyId", projectId);
		}
		if (!request.getParameter(COMPANY).equals("0")) {
			int companyId = Integer.parseInt(request.getParameter(COMPANY));
			MasCompany masCompany = new MasCompany();
			masCompany.setId(companyId);
			masDiscount.setCompany(masCompany);
			parameterMap.put("companyId", companyId);
		}
		if (request.getParameter(INSURANCE_AMOUNT) != null
				&& !(request.getParameter(INSURANCE_AMOUNT).equals(""))) {
			BigDecimal insuranceAmt = new BigDecimal(
					request.getParameter(INSURANCE_AMOUNT));
			masDiscount.setInsuranceAmt(insuranceAmt);
		}
		if (request.getParameter(PATIENT_CATEGORY) != null) {
			String patientCategory = request.getParameter(PATIENT_CATEGORY);
			masDiscount.setPatientCategory(patientCategory);
			parameterMap.put("patientCategory", patientCategory);
		}

		if (request.getParameter(BILL_TYPE_ID) != null) {
			int billTypeId = Integer.parseInt(request
					.getParameter(BILL_TYPE_ID));
			MasBillType masBillType = new MasBillType();
			masBillType.setId(billTypeId);
			masDiscount.setBillType(masBillType);
			parameterMap.put("billTypeId", billTypeId);
		}*/
		//already commented
		/*if (!request.getParameter(ITEM_ID).equals("0")) {
			int drugId = Integer.parseInt(request.getParameter(ITEM_ID));
			MasStoreItem masStoreItem = new MasStoreItem();
			masStoreItem.setId(drugId);
			masDiscount.setItem(masStoreItem);
			parameterMap.put("drugId", drugId);
		}*/

		/*if (null!=request.getParameter(ROOM_TYPE_ID) && !request.getParameter(ROOM_TYPE_ID).equals("0")) {
			int roomTypeId = Integer.parseInt(request
					.getParameter(ROOM_TYPE_ID));
			MasRoomType masRoomType = new MasRoomType();
			masRoomType.setId(roomTypeId);
			masDiscount.setRoomType(masRoomType);
			parameterMap.put("roomTypeId", roomTypeId);
		}
		if (request.getParameter(EFFECTIVE_DATE_FROM) != null
				&& !(request.getParameter(EFFECTIVE_DATE_FROM).equals(""))) {
			Date effectiveDateFrom = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_FROM));
			masDiscount.setEffectiveDateFrom(effectiveDateFrom);
			parameterMap.put("effectiveDateFrom", effectiveDateFrom);
		}
		if (request.getParameter(EFFECTIVE_DATE_TO) != null
				&& !(request.getParameter(EFFECTIVE_DATE_TO).equals(""))) {
			Date effectiveDateTo = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_TO));
			masDiscount.setEffectiveDateTo(effectiveDateTo);
			parameterMap.put("effectiveDateTo", effectiveDateTo);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !request.getParameter(MAIN_CHARGECODE_ID).equals("0")) {
			int mainchargeCodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
			MasMainChargecode mainChargecode = new MasMainChargecode();
			mainChargecode.setId(mainchargeCodeId);
			masDiscount.setMainChargecode(mainChargecode);
			parameterMap.put("mainchargeCodeId", mainchargeCodeId);
		}
		if (!request.getParameter(SUB_CHARGECODE_ID).equals("0")) {
			int subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
			MasSubChargecode subChargecode = new MasSubChargecode();
			subChargecode.setId(subChargeCodeId);
			masDiscount.setSubChargecode(subChargecode);
			parameterMap.put("subChargeCodeId", subChargeCodeId);
		}
		if (!request.getParameter(CHARGE_CODE_ID).equals("0")) {
			chargeCodeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
			MasChargeCode chargeCode = new MasChargeCode();
			chargeCode.setId(chargeCodeId);
			masDiscount.setChargeCode(chargeCode);
			parameterMap.put("chargeCodeId", chargeCodeId);
		}
		if (request.getParameter(DISCOUNT_PERCENTAGE) != null
				&& !(request.getParameter(DISCOUNT_PERCENTAGE).equals(""))) {
			BigDecimal discountPercentage = new BigDecimal(
					request.getParameter(DISCOUNT_PERCENTAGE));
			masDiscount.setDiscountPercentage(discountPercentage);
		}

		if (request.getParameter(DISCOUNT_TYPE) != null) {
			String discountType = request.getParameter(DISCOUNT_TYPE);
			masDiscount.setDiscountType(discountType);
		}

		if (request.getParameter(DISCOUNT_TYPE).equals("F")) {
			if (request.getParameter(DISCOUNT_VALUE) != null
					&& !(request.getParameter(DISCOUNT_VALUE).equals(""))) {
				BigDecimal discountValue = new BigDecimal(
						request.getParameter(DISCOUNT_VALUE));
				masDiscount.setFixedValue(discountValue);
			}
		} else {
			if (request.getParameter(DISCOUNT_VALUE) != null
					&& !(request.getParameter(DISCOUNT_VALUE).equals(""))) {
				BigDecimal discountValue = new BigDecimal(
						request.getParameter(DISCOUNT_VALUE));
				masDiscount.setDiscountValue(discountValue);
			}
		}

		if (!request.getParameter(ACCOUNT_ID).equals("0")) {
			int accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(accountId);
			masDiscount.setAccount(masAccount);
		}*/
		//already commented
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			String changedBy = request.getParameter(CHANGED_BY);
			masDiscount.setLastChgBy(changedBy);
		}*/
		/*Users user = new Users();
		user.setId((Integer)session.getAttribute("userId"));
		masDiscount.setLastChgBy(user);
		
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			masDiscount.setLastChgDate(currentDate);
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			String currentTime = request.getParameter(CHANGED_TIME);
			masDiscount.setLastChgTime(currentTime);
		}
		
		masDiscount.setStatus("y");*/
	
		//already commented
		/*if(chargeCodeId !=0)
			chargeStatus = billingMasterHandlerService.checkMasChargeCodeStatus(chargeCodeId);
		if(chargeStatus == true) // Selected Charge Code cannot give discount bcoz mas_charge is not discountable 
		{
			message = "Selected Charge Code cannot be given discount. Please contact Administrator !!";
			map = billingMasterHandlerService.showDiscountJsp();
			map.put("message", message);
		}
		else
		{*/
			existingMasDiscountList = billingMasterHandlerService.checkExistingDiscountDetails(parameterMap,box);
			
			if (existingMasDiscountList.size() == 0) {
				map = billingMasterHandlerService.saveDiscount(box);
				message = "Record Saved Successfully.";
				map = billingMasterHandlerService.showDiscountJsp(box);
				map.put("message", message);		
			} else {
				message = "Record already exists.";
				map = billingMasterHandlerService.showDiscountJsp(box);
				map.put("message", message);			
			}
		//}
		jsp = DISCOUNT_JSP;
		jsp += ".jsp";
		title = "Discount";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDiscountList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceName="";
        if(request.getParameter("serviceName")!=null){
        	serviceName=request.getParameter("serviceName");
        }
        String schemeName="";
        if(request.getParameter("schemeName")!=null){
        	schemeName=request.getParameter("schemeName");
        }
       
		map = billingMasterHandlerService.searchDiscountList(box);
		String jsp = DISCOUNT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDiscountDetailsForEdit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int discountId = Integer.parseInt(request.getParameter("discountId"));
        
		map = billingMasterHandlerService.getDiscountDetailsForEdit(discountId);
		map.put("localdiscount", false);
		String jsp = "responseForDiscountDetails";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editDiscountDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		box.put("localdiscount", box.getBoolean("localdiscount"));
		List<MasDiscount> existingMasDiscountList = new ArrayList<MasDiscount>();

		existingMasDiscountList = billingMasterHandlerService.checkExistingDiscountDetails(parameterMap,box);
		
		if (existingMasDiscountList.size() <= 1) {
			map = billingMasterHandlerService.editDiscountDetails(box);
			message = "Record Updated Successfully.";
			map = billingMasterHandlerService.showDiscountJsp(box);
			map.put("message", message);		
		} else {
			message = "Record already exists.";
			map = billingMasterHandlerService.showDiscountJsp(box);
			map.put("message", message);			
		}
		//map = billingMasterHandlerService.editDiscountDetails(box);
			if(box.getBoolean("localdiscount"))
			{
			 jsp =RequestConstants.LOCAL_DISCOUNT_JSP;
			}
			else
			{
			 jsp = DISCOUNT_JSP;
			}
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingMasterHandlerService.showAccountMasterJsp();
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		FaMasAccount faMasAccount = new FaMasAccount();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			faMasAccount.setHospital(masHospital);
		}
		String accountCode = "";
		/*if (request.getParameter(ACCOUNT_CODE) != null) {
			accountCode = request.getParameter(ACCOUNT_CODE);
			faMasAccount.setAccCode(accountCode);
		}*/
		String accountName = "";
		if (request.getParameter(ACCOUNT_NAME) != null) {
			accountName = request.getParameter(ACCOUNT_NAME);
			faMasAccount.setAccDesc(accountName);
		}
		int accountTypeId = 0;
		if (request.getParameter(ACCOUNT_TYPE_ID) != null
				&& !(request.getParameter(ACCOUNT_TYPE_ID).equals("0"))) {
			accountTypeId = Integer.parseInt(request
					.getParameter(ACCOUNT_TYPE_ID));
			FaMasAccountType faMasAccountType = new FaMasAccountType();
			faMasAccountType.setId(accountTypeId);
			//faMasAccount.setAccType(faMasAccountType);

		}
		BigDecimal drBalance = new BigDecimal("0");
		if (request.getParameter(DR_BALANCE) != null
				&& !request.getParameter(DR_BALANCE).equals("")) {
			drBalance = new BigDecimal(request.getParameter(DR_BALANCE));
			//faMasAccount.setDrBalance(drBalance);
		}
		BigDecimal crBalance = new BigDecimal("0");
		if (request.getParameter(CR_BALANCE) != null
				&& !request.getParameter(CR_BALANCE).equals("")) {
			crBalance = new BigDecimal(request.getParameter(CR_BALANCE));
			//faMasAccount.setCrBalance(crBalance);
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			//faMasAccount.setLastChgBy(changedBy);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			faMasAccount.setLastChgDate(currentDate);
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			faMasAccount.setLastChgTime(currentTime);
		}
		faMasAccount.setStatus("y");
		map = billingMasterHandlerService.addAccountMaster(faMasAccount);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int accountMasterId = 0;
		if (request.getParameter(ACCOUNT_MASTER_ID) != null) {
			accountMasterId = Integer.parseInt(request
					.getParameter(ACCOUNT_MASTER_ID));
			generalMap.put("accountMasterId", accountMasterId);
		}
		String accountCode = "";
		if (request.getParameter(ACCOUNT_CODE) != null) {
			accountCode = request.getParameter(ACCOUNT_CODE);
			generalMap.put("accountCode", accountCode);
		}
		String accountName = "";
		if (request.getParameter(ACCOUNT_NAME) != null) {
			accountName = request.getParameter(ACCOUNT_NAME);
			generalMap.put("accountName", accountName);
		}
		int accountTypeId = 0;
		if (request.getParameter(ACCOUNT_TYPE_ID) != null
				&& !(request.getParameter(ACCOUNT_TYPE_ID).equals("0"))) {
			accountTypeId = Integer.parseInt(request
					.getParameter(ACCOUNT_TYPE_ID));
			generalMap.put("accountTypeId", accountTypeId);
		}
		BigDecimal drBalance = new BigDecimal("0");
		if (request.getParameter(DR_BALANCE) != null
				&& !request.getParameter(DR_BALANCE).equals("")) {
			drBalance = new BigDecimal(request.getParameter(DR_BALANCE));
			generalMap.put("drBalance", drBalance);
		}
		BigDecimal crBalance = new BigDecimal("0");
		if (request.getParameter(CR_BALANCE) != null
				&& !request.getParameter(CR_BALANCE).equals("")) {
			crBalance = new BigDecimal(request.getParameter(CR_BALANCE));
			generalMap.put("crBalance", crBalance);
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = billingMasterHandlerService.editAccountMaster(generalMap);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int accountMasterId = 0;
		if (request.getParameter(ACCOUNT_MASTER_ID) != null) {
			accountMasterId = Integer.parseInt(request
					.getParameter(ACCOUNT_MASTER_ID));
			generalMap.put("accountMasterId", accountMasterId);
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}

		map = billingMasterHandlerService.deleteAccountMaster(generalMap);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String accountCode = "";
		if (request.getParameter(ACCOUNT_CODE) != null) {
			accountCode = request.getParameter(ACCOUNT_CODE);
		}
		String accountName = "";
		if (request.getParameter(ACCOUNT_NAME) != null) {
			accountName = request.getParameter(ACCOUNT_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
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
			accountCode = searchField;
			accountName = null;

		} else {
			accountCode = null;
			accountName = searchField;
		}
		map = billingMasterHandlerService.searchAccountMaster(accountCode,
				accountName);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDailyChargeSetupJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingMasterHandlerService.showDailyChargeSetupJsp();
		String jsp = "dailyChargeSetup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addChargeForDailyChargeSetup(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = new Users();
		HttpSession session = request.getSession();
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users") ;
		}
		int userId =user.getId();

		Box box = HMSUtil.getBox(request);
		box.put("userId", userId);
		map = billingMasterHandlerService.addChargeForDailyChargeSetup(box);
		boolean saved = false;
		if(map.get("saved") != null){
			saved = (Boolean)map.get("saved");
		}
		String message=  "";
		if(saved){
			message = "Record saved successfully.";
		}else{
			message = "Try Again.";
		}
		map = billingMasterHandlerService.showDailyChargeSetupJsp();
		map.put("message", message);
		String jsp = "dailyChargeSetup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editChargeForDailyChargeSetup(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = new Users();
		HttpSession session = request.getSession();
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users") ;
		}
		int userId =user.getId();

		Box box = HMSUtil.getBox(request);
		box.put("userId", userId);
		map = billingMasterHandlerService.editChargeForDailyChargeSetup(box);
		boolean saved = false;
		if(map.get("saved") != null){
			saved = (Boolean)map.get("saved");
		}
		String message=  "";
		if(saved){
			message = "Record updated successfully.";
		}else{
			message = "Try Again.";
		}
		map = billingMasterHandlerService.showDailyChargeSetupJsp();
		map.put("message", message);
		String jsp = "dailyChargeSetup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteChargeForDailyChargeSetup(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = new Users();
		HttpSession session = request.getSession();
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users") ;
		}
		int userId =user.getId();

		Box box = HMSUtil.getBox(request);
		box.put("userId", userId);
		map = billingMasterHandlerService.deleteChargeForDailyChargeSetup(box);
		boolean statusChanged = false;
		if(map.get("statusChanged") != null){
			statusChanged = (Boolean)map.get("statusChanged");
		}
		String message=  "";
		if(statusChanged){
			if(box.getString("flag").equalsIgnoreCase("Activate")){
				message = "Record Activated successfully.";
			}else if(box.getString("flag").equalsIgnoreCase("InActivate")){
				message = "Record Inactivated successfully.";
			}
		}else{
			message = "Try Again.";
		}

		map = billingMasterHandlerService.showDailyChargeSetupJsp();
		map.put("message", message);
		String jsp = "dailyChargeSetup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDailyChargeSetup(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = billingMasterHandlerService.searchDailyChargeSetup(box);
		String jsp = "dailyChargeSetup.jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}
	
	/*
	 * 
	 */
	public ModelAndView showBillingSchemeMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = billingMasterHandlerService.showBillingSchemeMasterJsp();
		@SuppressWarnings("unused")
		ArrayList searchAccountTypeList = (ArrayList) map
				.get("searchAccountTypeList");
		jsp = "billingScheme";
		jsp += ".jsp";
		title = "AccountType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView addBillingSchemeMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBillScheme faMasAccountType = new MasBillScheme();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String discount="";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DISCOUNT) != null) {
			discount = request.getParameter(DISCOUNT);
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
		generalMap.put("discount",discount);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List accountTypeCodeList = new ArrayList();
		List accountTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			accountTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			accountTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((accountTypeCodeList.size() == 0 || accountTypeCodeList == null)
				&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {
			faMasAccountType.setBillSchemeCode(code);
			faMasAccountType.setBillSchemeName(name);
			faMasAccountType.setStatus("y");
			faMasAccountType.setLastChgBy(changedBy);
			faMasAccountType.setLastChgDate(currentDate);
			faMasAccountType.setLastChgTime(currentTime);
			faMasAccountType.setDiscount(discount);
			successfullyAdded = billingMasterHandlerService
					.addBillingSchemeMaster(faMasAccountType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
				|| (accountTypeNameList.size() != 0)
				|| accountTypeNameList != null) {

			if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() == 0 || accountTypeNameList == null)) {

				message = "Account Type Code  already exists.";
			} else if ((accountTypeNameList.size() != 0 || accountTypeNameList != null)
					&& (accountTypeCodeList.size() == 0 || accountTypeCodeList == null)) {

				message = "Account Type Name already exists.";
			} else if ((accountTypeCodeList.size() != 0 || accountTypeCodeList != null)
					&& (accountTypeNameList.size() != 0 || accountTypeNameList != null)) {
				message = "Account Type Code and Account Type Name already exist.";
			}
		}
		url = "/hms/hms/billingMaster?method=showBillingSchemeMasterJsp";
		try {
			map = billingMasterHandlerService.showBillingSchemeMasterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "billingScheme";
		jsp += ".jsp";
		title = "AccountType";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editBillingSchemeMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String accountTypeCode = "";
		String accountTypeName = "";
		int accountTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String discount="";
		accountTypeName = (String) session.getAttribute("chargeTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			accountTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			accountTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DISCOUNT) != null
				&& !(request.getParameter(DISCOUNT).equals(""))) {
			discount = request.getParameter(DISCOUNT);
		}
		
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", accountTypeId);
		generalMap.put("accountTypeCode", accountTypeCode);
		generalMap.put("name", accountTypeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("discount", discount);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAccountTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAccountTypeNameList.size() == 0) {
			dataUpdated = billingMasterHandlerService
					.editBillingSchemeMaster(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingAccountTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/billingMaster?method=showBillingSchemeMasterJsp";

		try {
			map = billingMasterHandlerService.showBillingSchemeMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "billingScheme";
		jsp += ".jsp";
		title = "AccountType";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteBillingSchemeMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int accountTypeId = 0;
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
			accountTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = billingMasterHandlerService.deleteBillingSchemeMaster(
				accountTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/billingMaster?method=showBillingSchemeMasterJsp";

		try {
			map = billingMasterHandlerService.showBillingSchemeMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "billingScheme";
		jsp += ".jsp";
		title = "AccountType";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getItemCategoryDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = null;
		Box box=HMSUtil.getBox(request);
		map=billingMasterHandlerService.getItemCategoryDetails(box);
		jsp = "itemcategoryForDiscount";

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getChargeForExclude(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = null;
		Box box=HMSUtil.getBox(request);
		map=billingMasterHandlerService.getChargeForExclude(box);
		jsp = "getChargeForExclude";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getItemForExclude(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = null;
		Box box=HMSUtil.getBox(request);
		map=billingMasterHandlerService.getItemForExclude(box);
		jsp = "getItemForExclude";

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView listScheme(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheme> schemeList=new ArrayList<MasScheme>();
		String message = null;
		Box box=HMSUtil.getBox(request);
		schemeList=billingMasterHandlerService.listScheme(box);
		map.put("schemeList", schemeList);
		// Added by Amit Das on 02-03-2016
		if(box.getInt("schemeId_op")!=0 && box.getString("schemeName_op")!=null && !box.getString("schemeName_op").trim().equals("")) {
			map.put("schemeId_op", box.getInt("schemeId_op"));
			map.put("schemeName_op", box.getString("schemeName_op"));
		}
		
		// Added by Amit Das on 02-03-2016
		if(box.getString("currentScheme")!=null) 
			map.put("currentScheme", box.getString("currentScheme"));
		//added by govind 29-07-2017 for IP Billing Discount		
		if(box.getString("type")!=null){
			map.put("type", box.getString("type"));
		}
		//added by govind 29-07-2017 for IP Billing Discount
		jsp = "responceForScheme";

		return new ModelAndView(jsp, "map", map);
	}
	
	// Added by Amit Das on 29-02-2016
	public ModelAndView listSchemeForDiscount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasScheme> schemeList=new ArrayList<MasScheme>();
		String message = null;
		Box box=HMSUtil.getBox(request);
		schemeList=billingMasterHandlerService.listSchemeForDiscount(box);
		map.put("schemeList", schemeList);
		map.put("page", "discount");
		jsp = "responceForScheme";

		
		return new ModelAndView(jsp, "map", map);
	}
	
	
	// -----------------------------Scheme-------------

		@SuppressWarnings("unchecked")
		public ModelAndView showSchemeJsp(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map) billingMasterHandlerService.showScheme();
			String jsp = "scheme";
			jsp += ".jsp";
			title = "scheme";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addScheme(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasScheme masScheme = new MasScheme();
			HttpSession session = request.getSession();
			int userId = (Integer) session.getAttribute("userId");
			String letterFlag = "";
			String schemeType="";
			/* Added by Amit Das on 26-02-2016 */
			int priority = 0;
			int genderId = 0;
			String patientStatus = "";
			int fromAge = 0;
			int toAge = 0;
			long limit = 0;
			String fromAgeUnit = "";
			String toAgeUnit = "";
			String pkgFlag = "";
			/* Ended by Amit Das on 26-02-2016 */
			Map<String, Object> objectMap = new HashMap<String, Object>();
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
				
				if (request.getParameter("letterFlag") != null) {
					letterFlag = request.getParameter("letterFlag");
				}
				if (request.getParameter("schemeType") != null) {
					schemeType = request.getParameter("schemeType");
				}

				/* Added by Amit Das on 26-02-2016 */
				if (request.getParameter("priority") != null && !request.getParameter("priority").equals("0")) {
					priority = Integer.parseInt(request.getParameter("priority"));
				}
				
				if (request.getParameter("patientStatus") != null && !request.getParameter("patientStatus").equals("0")) {
					patientStatus = request.getParameter("patientStatus");
				}
				
				if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").trim().equals("")) {
					fromAge = Integer.parseInt(request.getParameter("fromAge"));
				}
				
				if (request.getParameter("toAge") != null && !request.getParameter("toAge").trim().equals("")) {
					toAge = Integer.parseInt(request.getParameter("toAge"));
				}
				
				if (request.getParameter("fromAgeUnit") != null && !request.getParameter("fromAgeUnit").equals("0")) {
					fromAgeUnit = request.getParameter("fromAgeUnit");
				}
				
				if (request.getParameter("toAgeUnit") != null && !request.getParameter("toAgeUnit").equals("0")) {
					toAgeUnit = request.getParameter("toAgeUnit");
				}
				
				if (request.getParameter("genderId") != null && !request.getParameter("genderId").equals("0")) {
					genderId = Integer.parseInt(request.getParameter("genderId"));
				}
				
				if (request.getParameter("limit") != null && !request.getParameter("limit").trim().equals("")) {
					limit = Long.parseLong(request.getParameter("limit"));
				}
				
				if (request.getParameter("pkgFlag") != null && !request.getParameter("pkgFlag").trim().equals("")) {
					pkgFlag = request.getParameter("pkgFlag");
				}
				
				
				/* Ended by Amit Das on 26-02-2016 */
				
			
				if (request.getParameter("accountId") != null && !request.getParameter("accountId").equals("0")) {
					String[] accountList= request.getParameterValues("accountId");
					objectMap.put("accountList", accountList);
					
					
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
				if (request.getParameter("title") != null && !request.getParameter("title").trim().equals("")) {
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
				generalMap.put("priority", priority);

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
			List schemeCodeList = new ArrayList();
			List schemeNameList = new ArrayList();
			List schemePriorityList = new ArrayList(); // added by Amit Das on 26-02-2016 
			if (listMap.get("duplicateGeneralCodeList") != null) {
				schemeCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				schemeNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			
			if (listMap.get("duplicateGeneralPriorityList") != null) {
				schemePriorityList = (List) listMap.get("duplicateGeneralPriorityList");
			}
			
			boolean successfullyAdded = false;

			if ((schemeCodeList.size() == 0 || schemeCodeList == null)
					&& (schemeNameList.size() == 0 || schemeNameList == null)  && (schemePriorityList.size() == 0 || schemePriorityList == null) ) { // edited by Amit Das on 26-02-2016
				masScheme.setSchemeCode(code);
				masScheme.setSchemeName(name);
				masScheme.setSchemeType(schemeType);
				Users users = new Users();
				users.setId(userId);
				masScheme.setLastChgBy(users);
				masScheme.setStatus("Y");
				
				// added by Amit Das on 26-02-2016
				if(genderId!=0){
					MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
					administrativeSex.setId(genderId);
					masScheme.setSex(administrativeSex);
				}
				if(priority!=0)
				masScheme.setPriority(priority);
				
				masScheme.setFromAge(new BigDecimal(fromAge));
				masScheme.setToAge(new BigDecimal(toAge));
				masScheme.setFromAgeUnit(fromAgeUnit);
				masScheme.setToAgeUnit(toAgeUnit);
				masScheme.setPatientStatus(patientStatus);
				masScheme.setAmountLimit(limit);
				if(pkgFlag.equalsIgnoreCase("y")){
					masScheme.setPackageFlag(pkgFlag);
				}else{
					masScheme.setPackageFlag("n");
				}
				
				// ended by Amit Das on 26-02-2016
				
				if(letterFlag.equalsIgnoreCase("y")){
					masScheme.setLetterFlag(letterFlag);
				}else{
					masScheme.setLetterFlag("n");
				}
				masScheme.setLastChgDate(currentDate);
				masScheme.setLastChgTime(currentTime);
				successfullyAdded = billingMasterHandlerService.addScheme(masScheme,objectMap);
				
				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if ((schemeCodeList.size() != 0 || schemeCodeList != null) // added priority condtion in each step of this block by Amit Das on 26-02-2016 
					|| (schemeNameList.size() != 0) || schemeNameList != null 
					|| (schemePriorityList.size() != 0) || schemePriorityList != null
					) {
				if ((schemeCodeList.size() != 0 || schemeCodeList != null)
						&& (schemeNameList.size() == 0 || schemeNameList == null) && (schemePriorityList.size() == 0 || schemePriorityList == null)) {
					message = "Scheme Code already exists.";
				} else if ((schemeNameList.size() != 0 || schemeNameList != null)
						&& (schemeCodeList.size() == 0 || schemeCodeList == null) && (schemePriorityList.size() == 0 || schemePriorityList == null)) {
					message = "Scheme Name already exists.";
				}else if ((schemePriorityList.size() != 0 || schemePriorityList != null)
						&& (schemeNameList.size() == 0 || schemeNameList == null) && (schemeCodeList.size() == 0 || schemeCodeList == null)) {
					message = "Scheme Priority already exists.";
				} else if ((schemeCodeList.size() != 0 || schemeCodeList != null)
						&& (schemeCodeList.size() != 0 || schemeNameList != null) && (schemePriorityList.size() != 0 || schemePriorityList != null)) {
					message = "Scheme Code and Name and Priority exist.";
				}
			}
			try {
				map = billingMasterHandlerService.showScheme();

			} catch (Exception e) {
				e.printStackTrace();
			}

			String jsp = "scheme";
			title = " Add scheme";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editScheme(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			String schemeCode = "";
			String schemeName = "";
			int schemeId = 0;
			Date changedDate = null;
			/* Added by Amit Das on 26-02-2016 */
			String pkgFlag = "";
			int priority = 0;
			int genderId = 0;
			String patientStatus = "";
			int fromAge = 0;
			int toAge = 0;
			String fromAgeUnit = "";
			String toAgeUnit = "";
			long limit = 0;
			/* Ended by Amit Das on 26-02-2016 */
			
			@SuppressWarnings("unused")
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			int hospitalId = 0;
			String letterFlag = "";
			String schemeType="";
			try {
			
				if (request.getParameter(HOSPITAL_ID) != null
						&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
					hospitalId = Integer
							.parseInt(request.getParameter(HOSPITAL_ID));
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					schemeId = Integer.parseInt(request.getParameter(COMMON_ID));
				}

				if (request.getParameter("schemeType") != null) {
					schemeType = request.getParameter("schemeType");
				}
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					schemeCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					schemeName = request.getParameter(SEARCH_NAME);
				}
				if (request.getParameter("letterFlag") != null) {
					letterFlag = request.getParameter("letterFlag");
				}
				
				
				
				/* Added by Amit Das on 26-02-2016 */
				if (request.getParameter("priority") != null && !request.getParameter("priority").equals("0")) {
					priority = Integer.parseInt(request.getParameter("priority"));
				}
				
				if (request.getParameter("patientStatus") != null && !request.getParameter("patientStatus").equals("0")) {
					patientStatus = request.getParameter("patientStatus");
				}
				
				if (request.getParameter("fromAge") != null) {
					fromAge = Integer.parseInt(request.getParameter("fromAge"));
				}
				
				if (request.getParameter("toAge") != null) {
					toAge = Integer.parseInt(request.getParameter("toAge"));
				}
				
				if (request.getParameter("fromAgeUnit") != null && !request.getParameter("fromAgeUnit").equals("0")) {
					fromAgeUnit = request.getParameter("fromAgeUnit");
				}
				
				if (request.getParameter("toAgeUnit") != null && !request.getParameter("toAgeUnit").equals("0")) {
					toAgeUnit = request.getParameter("toAgeUnit");
				}
				
				if (request.getParameter("genderId") != null && !request.getParameter("genderId").equals("0")) {
					genderId = Integer.parseInt(request.getParameter("genderId"));
				}
				
				if (request.getParameter("limit") != null  && !request.getParameter("limit").trim().equals("") && !request.getParameter("limit").trim().equals("-")) {
					limit = Long.parseLong(request.getParameter("limit"));
				}
				

				if (request.getParameter("pkgFlag") != null && !request.getParameter("pkgFlag").equals("")) {
					pkgFlag = request.getParameter("pkgFlag");
				}
				
				/* Ended by Amit Das on 26-02-2016 */

				if (request.getParameter("pojoName") != null) {
					pojoName = request.getParameter("pojoName");
				}
				if (request.getParameter("pojoPropertyName") != null) {
					pojoPropertyName = request.getParameter("pojoPropertyName");
				}
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}
				if (request.getParameter("accountId") != null && !request.getParameter("accountId").equals("0")) {
					String[] accountList= request.getParameterValues("accountId");
					generalMap.put("accountList", accountList);
					
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", schemeId);
				generalMap.put("schemeCode", schemeCode);
				generalMap.put("name", schemeName);
				generalMap.put("hospitalId", hospitalId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("userId", userId);
				generalMap.put("letterFlag", letterFlag);
				generalMap.put("schemeType", schemeType);
				
				/*Added by Amit Das on 26-02-2016*/
				generalMap.put("genderId", genderId);
				generalMap.put("fromAge", fromAge);
				generalMap.put("toAge", toAge);
				generalMap.put("priority", priority);
				generalMap.put("toAgeUnit", toAgeUnit);
				generalMap.put("fromAgeUnit", fromAgeUnit);
				generalMap.put("limit", limit);
				generalMap.put("patientStatus", patientStatus);
				generalMap.put("pkgFlag", pkgFlag);
				/*Ended by Amit Das on 26-02-2016*/
				
				Map<String, Object> listMap = new HashMap<String, Object>();

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put("flag", true);

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingSchemeNameList = (List) listMap
						.get("duplicateMastersList");
				boolean dataUpdated = false;

				if (existingSchemeNameList.size() == 0) {
					dataUpdated = billingMasterHandlerService.editScheme(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				} else if (existingSchemeNameList.size() > 0) {
					message = "Name already exists.";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				map = billingMasterHandlerService.showScheme();

			} catch (Exception e) {
				e.printStackTrace();
			}
	
			String jsp = "scheme";
			title = " Edit scheme";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView searchScheme(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String searchField = null;
			String schemeCode = null;
			String schemeName = null;
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
				schemeCode = searchField;
				schemeName = null;

			} else {
				schemeCode = null;
				schemeName = searchField;
			}

			//

			map = billingMasterHandlerService.searchScheme(schemeCode,
					schemeName);

			jsp = "scheme";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("schemeCode", schemeCode);
			map.put("schemeName", schemeName);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView deleteScheme(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int schemeId = 0;
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
				schemeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = billingMasterHandlerService.deleteScheme(schemeId,generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/billingMaster?method=showSchemeJsp";
			try {
				map = billingMasterHandlerService.showScheme();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "scheme";
			title = "delete Scheme";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		
		@SuppressWarnings("unchecked")
		public ModelAndView showLocalCharge(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			generalMap.put(HOSPITAL_ID, hospitalId);
			map = (Map) billingMasterHandlerService.showLocalCharge(generalMap);
			String jsp = "localcharge";
			jsp += ".jsp";
			title = "localcharge";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addLocalCharge(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			MasChargeCodeRates chargeCodeRates=new MasChargeCodeRates();
			HttpSession session = request.getSession();
			int userId = (Integer) session.getAttribute("userId");
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			generalMap.put(HOSPITAL_ID, hospitalId);


			Map<String, Object> listMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int chargeCodeId=0;
			BigDecimal charge=new BigDecimal(0.00);
			try {
				if(request.getParameter(RequestConstants.CHARGE_CODE)!=null && !request.getParameter(RequestConstants.CHARGE_CODE).equalsIgnoreCase(""))
				{
					chargeCodeId=Integer.parseInt(request.getParameter(RequestConstants.CHARGE_CODE));
				}
				
				if(request.getParameter(RequestConstants.CHARGE)!=null 
						&& !request.getParameter(RequestConstants.CHARGE).equalsIgnoreCase(""))
				{
					charge= new BigDecimal(request.getParameter(RequestConstants.CHARGE)); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				listMap = billingMasterHandlerService
						.checkDuplicateLocalCharge(chargeCodeId, hospitalId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<MasChargeCodeRates> masChargeCodeRates = new ArrayList<MasChargeCodeRates>();
			if (listMap.get("masChargeCodeRates") != null) {
				masChargeCodeRates = (List<MasChargeCodeRates>) listMap.get("masChargeCodeRates");
			}
			
			boolean successfullyAdded = false;

			if (masChargeCodeRates.size() == 0 || masChargeCodeRates == null) {
				MasChargeCode chargeCode=new MasChargeCode();
				chargeCode.setId(chargeCodeId);
				chargeCodeRates.setChargeCode(chargeCode);
				MasHospital hospital=new MasHospital();
				hospital.setId(hospitalId);
				chargeCodeRates.setHospital(hospital);
				chargeCodeRates.setRate(charge);
				successfullyAdded = billingMasterHandlerService.addLocalCharge(chargeCodeRates);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else  {
					message = "Local Charge Already Exists.";
			}
			try {
				map = billingMasterHandlerService.showLocalCharge(generalMap);

			} catch (Exception e) {
				e.printStackTrace();
			}

			String jsp = "localcharge";
			title = " Add Local Charge";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editLocalCharge(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			HttpSession session = request.getSession();
			int localChargeId = 0;
			Date changedDate = null;
			@SuppressWarnings("unused")
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			int hospitalId = 0;
			int chargeCodeId=0;
			BigDecimal charge=new BigDecimal(0.00);

			try {
			
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					localChargeId = Integer.parseInt(request.getParameter(COMMON_ID));
				}

		
				
					if(request.getParameter(RequestConstants.CHARGE_CODE)!=null && !request.getParameter(RequestConstants.CHARGE_CODE).equalsIgnoreCase(""))
					{
						chargeCodeId=Integer.parseInt(request.getParameter(RequestConstants.CHARGE_CODE));
					}
					
					if(request.getParameter(RequestConstants.CHARGE)!=null 
							&& !request.getParameter(RequestConstants.CHARGE).equalsIgnoreCase(""))
					{
						charge= new BigDecimal(request.getParameter(RequestConstants.CHARGE)); 
					}
					

			} catch (Exception e) {
				e.printStackTrace();
			}

			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				generalMap.put("id", localChargeId);
				generalMap.put("hospitalId", hospitalId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("userId", userId);
				generalMap.put("chargeCodeId", chargeCodeId);
				generalMap.put("charge", charge);
				Map<String, Object> listMap = new HashMap<String, Object>();
				generalMap.put("flag", true);

				/*listMap = billingMasterHandlerService
						.checkDuplicateLocalCharge(chargeCodeId, hospitalId);
				List<MasChargeCodeRates> masChargeCodeRates = new ArrayList<MasChargeCodeRates>();
				if (listMap.get("masChargeCodeRates") != null) {
					masChargeCodeRates = (List<MasChargeCodeRates>) listMap.get("masChargeCodeRates");
				}*/
				boolean dataUpdated = false;

				/*if (masChargeCodeRates.size() == 1) {*/
					dataUpdated = billingMasterHandlerService.editLocalCharge(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				/*} else if (masChargeCodeRates.size() > 1) {
					message = "Local Charge already exists.";
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				map.putAll(billingMasterHandlerService.showLocalCharge(generalMap));

			} catch (Exception e) {
				e.printStackTrace();
			}
	
			String jsp = "localcharge";
			title = " Add Local Charge";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView searchLocalCharge(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String searchField = null;
			String chargeCode = null;
			String chargeName = null;
			int searchRadio = 1;
			int hospitalId=0;
			try {
				
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				}
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
				chargeCode = searchField;
				chargeName = null;

			} else {
				chargeCode = null;
				chargeName = searchField;
			}

			//

			map = billingMasterHandlerService.searchLocalCharge(chargeCode,
					chargeName,hospitalId);

			String jsp = "localcharge";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("schemeCode", chargeCode);
			map.put("schemeName", chargeName);
			return new ModelAndView("index", "map", map);
		}

		/*public ModelAndView deleteScheme(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int schemeId = 0;
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
				schemeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = billingMasterHandlerService.deleteScheme(schemeId,generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/billingMaster?method=showSchemeJsp";
			try {
				map = billingMasterHandlerService.showScheme();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "scheme";
			title = "delete Scheme";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
*/
		
		public ModelAndView showLocalDiscountJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			Box box=HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put("localdiscount", true);
			map = billingMasterHandlerService.showDiscountJsp(box);
			
			jsp = RequestConstants.LOCAL_DISCOUNT_JSP;
			jsp += ".jsp";
			title = "Discount";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pageNo", 1);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView saveLocalDiscount(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box=HMSUtil.getBox(request);
			
			map = billingMasterHandlerService.showDiscountJsp(box);
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			int userId=(Integer)session.getAttribute(USER_ID);
			int empId=(Integer)session.getAttribute("empId");
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
			box.put(USER_ID, userId);
			box.put("empId", empId);
			box.put(HOSPITAL_ID, hospitalId);
			box.put("localdiscount", true);
			
			//MasDiscount masDiscount = new MasDiscount();
			
			String message = "";
			Boolean chargeStatus = false;
			List<MasDiscount> existingMasDiscountList = new ArrayList<MasDiscount>();
			
				existingMasDiscountList = billingMasterHandlerService.checkExistingDiscountDetails(parameterMap,box);
				
				if (existingMasDiscountList.size() == 0) {
					map = billingMasterHandlerService.saveDiscount(box);
					message = "Record Saved Successfully.";
					map = billingMasterHandlerService.showDiscountJsp(box);
					map.put("message", message);		
				} else {
					message = "Record already exists.";
					map = billingMasterHandlerService.showDiscountJsp(box);
					map.put("message", message);			
				}
				jsp = RequestConstants.LOCAL_DISCOUNT_JSP;
			jsp += ".jsp";
			title = "Discount";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
			return new ModelAndView("index", "map", map);
		}

			/*public ModelAndView searchDiscountList(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);

			map = billingMasterHandlerService.searchDiscountList(box);
			String jsp = DISCOUNT_JSP;
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("pageNo", 1);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView getDiscountDetailsForEdit(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int discountId = Integer.parseInt(request.getParameter("discountId"));

			map = billingMasterHandlerService.getDiscountDetailsForEdit(discountId);
			String jsp = "responseForDiscountDetails";
			return new ModelAndView(jsp, "map", map);
		}

		public ModelAndView editDiscountDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			int userId=(Integer)session.getAttribute(USER_ID);
			int empId=(Integer)session.getAttribute("empId");
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
			box.put(USER_ID, userId);
			box.put("empId", empId);
			List<MasDiscount> existingMasDiscountList = new ArrayList<MasDiscount>();

			existingMasDiscountList = billingMasterHandlerService.checkExistingDiscountDetails(parameterMap,box);
			
			if (existingMasDiscountList.size() <= 1) {
				map = billingMasterHandlerService.editDiscountDetails(box);
				message = "Record Updated Successfully.";
				map = billingMasterHandlerService.showDiscountJsp();
				map.put("message", message);		
			} else {
				message = "Record already exists.";
				map = billingMasterHandlerService.showDiscountJsp();
				map.put("message", message);			
			}
			map = billingMasterHandlerService.editDiscountDetails(box);
			String jsp = DISCOUNT_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
			return new ModelAndView("index", "map", map);
		}*/


	//===========================================method for priority======================
		
		@SuppressWarnings("unchecked")
		public ModelAndView showPriorityJsp(HttpServletRequest request,
				HttpServletResponse response) {
			session = request.getSession(true);
			map = billingMasterHandlerService.showPriorityJsp();
			@SuppressWarnings("unused")
			ArrayList blPriorities = (ArrayList) map
					.get("blPriorities");
			jsp = "priority";
			jsp += ".jsp";
			title = "Priority";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
//===============================================================================
		
//=====================================================================================
		@SuppressWarnings("unchecked")
		public ModelAndView addPriorityType(HttpServletRequest request,
				HttpServletResponse response) {
			BigDecimal saleTax = new BigDecimal(0);
			Map<String, Object> map = new HashMap<String, Object>();
			BlPriority blPriority=new BlPriority();
			String changedBy = "";
			String priority="";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();

			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if (request.getParameter(SALES_TAX) != null) {
				bed = request.getParameter(SALES_TAX);
			}
			if (request.getParameter("priority") != null) {
				priority = request.getParameter("priority");
			}
			System.out.println(code+""+name+""+bed);

			/*if (request.getParameter("title") != null) {
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
			}*/
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("bed", bed);
			generalMap.put("priority", priority);


			/*generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
*/
			//listMap = commonMasterHandlerService
					//.checkForExistingMasters(generalMap);
/*
			List salesTaxTypeCodeList = new ArrayList();
			List salesTaxTypeNameList = new ArrayList();

			if (listMap.get("duplicateGeneralCodeList") != null) {
				salesTaxTypeCodeList = (List) listMap
						.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				salesTaxTypeNameList = (List) listMap
						.get("duplicateGeneralNameList");
			}*/
			boolean successfullyAdded = false;
/*
			if ((salesTaxTypeCodeList.size() == 0 || salesTaxTypeCodeList == null)
					&& (salesTaxTypeNameList.size() == 0 || salesTaxTypeNameList == null)) {*/
			    blPriority.setPriorityCode(code);
			    blPriority.setPriorityNam(name);
				blPriority.setStatus("y");
				blPriority.setBed(bed);
				blPriority.setPriority(priority);
				successfullyAdded = billingMasterHandlerService
						.addPriorityType(blPriority);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			 /*else if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
					|| (salesTaxTypeNameList.size() != 0)
					|| salesTaxTypeNameList != null) {

				if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
						&& (salesTaxTypeNameList.size() == 0 || salesTaxTypeNameList == null)) {

					message = "SalesTax Type Code  already exists.";
				} else if ((salesTaxTypeNameList.size() != 0 || salesTaxTypeNameList != null)
						&& (salesTaxTypeCodeList.size() == 0 || salesTaxTypeCodeList == null)) {

					message = "SalesTax Type Name already exists.";
				} else if ((salesTaxTypeCodeList.size() != 0 || salesTaxTypeCodeList != null)
						&& (salesTaxTypeNameList.size() != 0 || salesTaxTypeNameList != null)) {

					message = "SalesTax Type Code and SalesTax Type Name already exist.";
				}
			}*/

			url = "/hms/hms/billingMaster?method=showPriorityJsp";

			try {
				map = billingMasterHandlerService.showPriorityJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "priority";
			title = "Add Priority Type";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		//====================================================================
		public ModelAndView searchPriorityType(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String priorityCode = null;
			String priorityName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				priorityCode = request.getParameter(CODE);
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				priorityName = request.getParameter(SEARCH_NAME);
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
				priorityCode = searchField;
				priorityName = null;
			} else {
				priorityCode = null;
				priorityName = searchField;
			}
			map = billingMasterHandlerService.searchPriorityType(priorityCode,
					priorityName);
			jsp = "priority";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("priorityCode", priorityCode);
			map.put("priorityName", priorityName);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView deletePriorityType(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int priorityId = 0;
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
				priorityId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = billingMasterHandlerService.deletePriorityType(
					priorityId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/billingMaster?method=showPriorityJsp";

			try {
				map = billingMasterHandlerService.showPriorityJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "priority";
			title = "Delete Priority type";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
		

		@SuppressWarnings("unchecked")
		public ModelAndView editPriorityType(HttpServletRequest request,
				HttpServletResponse response) {
			BigDecimal saleTax = new BigDecimal(0);
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			session = request.getSession();
			String priorityCode = "";
			String priorityName = "";
			int priorityId = 0;
			String bed = "";
			String changedTime = "";
			Date changedDate = null;
            String priority="";
			/*priorityCode = (String) session.getAttribute("priorityCode");
			priorityName = (String) session.getAttribute("priorityName");*/
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
		    priorityId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				priorityCode = request.getParameter(CODE);
			}
			System.out.println("code"+priorityCode);
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				priorityName = request.getParameter(SEARCH_NAME);
			}
			
			if (request.getParameter(SALES_TAX) != null
					&& !(request.getParameter(SALES_TAX).equals(""))) {
				bed = request.getParameter(SALES_TAX);
			}
			if (request.getParameter("priority") != null
					&& !(request.getParameter("priority").equals(""))) {
				priority = request.getParameter("priority");
			}
			generalMap.put("priority", priority);
			generalMap.put("id", priorityId);
			generalMap.put("bed", bed);
			generalMap.put("name", priorityName);
			generalMap.put("code", priorityCode);
			generalMap.put("flag", true);

			/*listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingSalesTaxTypeNameList = (List) listMap
					.get("duplicateMastersList");*/

			boolean dataUpdated = false;
			/*if (existingSalesTaxTypeNameList.size() == 0) {*/
				dataUpdated = billingMasterHandlerService
						.editPriorityType(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			/*} else if (existingSalesTaxTypeNameList.size() > 0) {

				message = "Name already exists.";

			}*/
			url = "/hms/hms/billingMaster?method=showPriorityJsp";

			try {
				map = billingMasterHandlerService.showPriorityJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "priority";
			title = "Edit Priority Type";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		//========================================================================
	// ----------------------------------------------------------------------------------------------------
	public BillingMasterHandlerService getBillingMasterHandlerService() {
		return billingMasterHandlerService;
	}

	public void setBillingMasterHandlerService(
			BillingMasterHandlerService billingMasterHandlerService) {
		this.billingMasterHandlerService = billingMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
