package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.ATTACHED;
import static jkt.hms.util.RequestConstants.AUTHORIZER_JSP;
import static jkt.hms.util.RequestConstants.BED_JSP;
import static jkt.hms.util.RequestConstants.BED_STATUS_ID;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_CODE;
import static jkt.hms.util.RequestConstants.CASE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE;
import static jkt.hms.util.RequestConstants.CHARGE_CODE;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_JSP;
import static jkt.hms.util.RequestConstants.CHARGE_NAME;
import static jkt.hms.util.RequestConstants.CHARGE_TYPE_ID;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMPLAINT_JSP;
import static jkt.hms.util.RequestConstants.COMPLICATION_JSP;
import static jkt.hms.util.RequestConstants.COST_CENTER_JSP;
import static jkt.hms.util.RequestConstants.DEATH_CAUSE_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DESCRIPTION;
import static jkt.hms.util.RequestConstants.DIET_TYPE;
import static jkt.hms.util.RequestConstants.DISCARD_DATE;
import static jkt.hms.util.RequestConstants.DISCOUNTABLE;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.DR_ACC_REQ;
import static jkt.hms.util.RequestConstants.EDITABLE;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_FROM;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_TO;
import static jkt.hms.util.RequestConstants.FA_ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.FA_MAS_SUB_LED;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ICD_CAUSE_GROUP_ID;
import static jkt.hms.util.RequestConstants.ICD_CAUSE_GROUP_JSP;
import static jkt.hms.util.RequestConstants.ICD_JSP;
import static jkt.hms.util.RequestConstants.ICD_MAIN_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.ICD_MAIN_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.ICD_SUB_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.ICD_SUB_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.INTRODUCTION_DATE;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_JSP;
import static jkt.hms.util.RequestConstants.MAJOR_CATEGORY_CODE_JSP;
import static jkt.hms.util.RequestConstants.MAX_AUTHORIZE_AMOUNT;
import static jkt.hms.util.RequestConstants.MIN_AUTHORIZE_AMOUNT;
import static jkt.hms.util.RequestConstants.OPD_RELATED_SERVICES;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.ROOM_ID;
import static jkt.hms.util.RequestConstants.ROOM_JSP;
import static jkt.hms.util.RequestConstants.ROOM_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.SHORT_DESCRIPTION;
import static jkt.hms.util.RequestConstants.STD_DEDUCTION_GEN;
import static jkt.hms.util.RequestConstants.STD_DEDUCTION_SPL;
import static jkt.hms.util.RequestConstants.SUB_CHARGE;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.VALIDITY_DAYS;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.login.handler.LoginHandlerService;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MasActionTaken;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasServiceCentreCounter;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.masters.handler.ReportDataSource;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HospitalDetailsMasterController extends MultiActionController {
	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	LoginHandlerService loginHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String systemIp = "";
	String name = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String CommonChargeCodeStatus=null;
	HttpSession session = null;

	// ----------------------------- Cost
	// Center----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showCostCenterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		jsp = COST_CENTER_JSP;
		jsp += ".jsp";
		title = "CostCenter";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCostCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String costCenterCode = null;
		String costCenterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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
			costCenterCode = searchField;
			costCenterName = null;

		} else {
			costCenterCode = null;
			costCenterName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCostCenter(
				costCenterCode, costCenterName);

		jsp = COST_CENTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("costCenterCode", costCenterCode);
		map.put("costCenterName", costCenterName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCostCenter(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCostCenter masCostCenter = new MasCostCenter();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
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
		List costCenterCodeList = new ArrayList();
		List costCenterNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			costCenterCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			costCenterNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((costCenterCodeList.size() == 0 || costCenterCodeList == null)
				&& (costCenterNameList.size() == 0 || costCenterNameList == null)) {
			masCostCenter.setCostCenterCode(code);
			masCostCenter.setCostCenterName(name);
			masCostCenter.setStatus("y");
			masCostCenter.setLastChgBy(changedBy);
			masCostCenter.setLastChgDate(currentDate);
			masCostCenter.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addCostCenter(masCostCenter);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
				|| (costCenterNameList.size() != 0)
				|| costCenterNameList != null) {
			if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
					&& (costCenterNameList.size() == 0 || costCenterNameList == null)) {
				message = "Cost Center Code  already exists.";
			} else if ((costCenterNameList.size() != 0 || costCenterNameList != null)
					&& (costCenterCodeList.size() == 0 || costCenterCodeList == null)) {
				message = "Cost Center Name already exists.";
			} else if ((costCenterCodeList.size() != 0 || costCenterCodeList != null)
					&& (costCenterNameList.size() != 0 || costCenterNameList != null)) {
				message = "Cost Center Code and Cost Center Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Add Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String costCenterCode = "";
		String costCenterName = "";
		int costCenterId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			costCenterId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", costCenterId);
		generalMap.put("costCenterCode", costCenterCode);
		generalMap.put("name", costCenterName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCostCenterNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCostCenterNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editCostCenterToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCostCenterNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Update Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int costCenterId = 0;
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
			costCenterId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteCostCenter(
				costCenterId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showCostCenterJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCostCenterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COST_CENTER_JSP;
		title = "Delete Cost center";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------- Major Category Code
	// -----------------------------------------

	public ModelAndView showMajorCategoryCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showMajorCategoryCodeJsp();
		jsp = MAJOR_CATEGORY_CODE_JSP;
		jsp += ".jsp";
		title = "MajorCategoryCode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String majorCategoryCodeCode = null;

		String majorCategoryCodeName = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryCodeName = request.getParameter(SEARCH_NAME);
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
			majorCategoryCodeCode = searchField;
			majorCategoryCodeName = null;

		} else {
			majorCategoryCodeCode = null;
			majorCategoryCodeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMajorCategoryCode(
				majorCategoryCodeCode, majorCategoryCodeName);

		jsp = MAJOR_CATEGORY_CODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("majorCategoryCodeCode", majorCategoryCodeCode);
		map.put("majorCategoryCodeName", majorCategoryCodeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasMajorCategoryCode masMajorCategoryCode = new MasMajorCategoryCode();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
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
		List majorCategoryCodeCodeList = new ArrayList();
		List majorCategoryCodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			majorCategoryCodeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			majorCategoryCodeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((majorCategoryCodeCodeList.size() == 0 || majorCategoryCodeCodeList == null)
				&& (majorCategoryCodeNameList.size() == 0 || majorCategoryCodeNameList == null)) {
			masMajorCategoryCode.setMajorCategoryCode(code);
			masMajorCategoryCode.setMajorCategoryName(name);
			masMajorCategoryCode.setStatus("y");
			masMajorCategoryCode.setLastChgBy(changedBy);
			masMajorCategoryCode.setLastChgDate(currentDate);
			masMajorCategoryCode.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addMajorCategoryCode(masMajorCategoryCode);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
				|| (majorCategoryCodeNameList.size() != 0)
				|| majorCategoryCodeNameList != null) {

			if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
					&& (majorCategoryCodeNameList.size() == 0 || majorCategoryCodeNameList == null)) {
				message = "major Category Code  already exists.";
			} else if ((majorCategoryCodeNameList.size() != 0 || majorCategoryCodeNameList != null)
					&& (majorCategoryCodeCodeList.size() == 0 || majorCategoryCodeCodeList == null)) {
				message = "major Category Name already exists.";
			} else if ((majorCategoryCodeCodeList.size() != 0 || majorCategoryCodeCodeList != null)
					&& (majorCategoryCodeNameList.size() != 0 || majorCategoryCodeNameList != null)) {
				message = "major Category Code and major Category Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Add Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String majorCategoryCode = "";
		String majorCategoryName = "";
		int majorCtegoryCodeId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			majorCtegoryCodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", majorCtegoryCodeId);
		generalMap.put("majorCategoryCode", majorCategoryCode);
		generalMap.put("name", majorCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMajorCategoryCodeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingMajorCategoryCodeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editMajorCategoryCodeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMajorCategoryCodeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Update Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteMajorCategoryCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int majorCategoryCodeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			majorCategoryCodeId = Integer.parseInt(request
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
		dataDeleted = hospitalDetailsMasterHandlerService
				.deleteMajorCategoryCode(majorCategoryCodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showMajorCategoryCodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService
					.showMajorCategoryCodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAJOR_CATEGORY_CODE_JSP;
		title = "Delete Major Category code";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------------Death Cause
	// -----------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDeathCauseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		@SuppressWarnings("unused")
		ArrayList searchTitleList = (ArrayList) map.get("searchTitleList");
		jsp = DEATH_CAUSE_JSP;
		jsp += ".jsp";
		title = "deathCause";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDeathCause(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deathCauseCode = null;
		String deathCauseName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
			deathCauseCode = searchField;
			deathCauseName = null;

		} else {
			deathCauseCode = null;
			deathCauseName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchDeathCause(
				deathCauseCode, deathCauseName);
		jsp = DEATH_CAUSE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deathCauseCode", deathCauseCode);
		map.put("deathCauseName", deathCauseName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		MasDeathCause masDeathCause = new MasDeathCause();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
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
		List deathCauseCodeList = new ArrayList();
		List deathCauseNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			deathCauseCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			deathCauseNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((deathCauseCodeList.size() == 0 || deathCauseCodeList == null)
				&& (deathCauseNameList.size() == 0 || deathCauseNameList == null)) {
			masDeathCause.setDeathCauseCode(code);
			masDeathCause.setDeathCauseName(name);
			masDeathCause.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masDeathCause.setLastChgBy(users);
			masDeathCause.setLastChgDate(currentDate);
			masDeathCause.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addDeathCause(masDeathCause);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
				|| (deathCauseNameList.size() != 0)
				|| deathCauseNameList != null) {
			if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
					&& (deathCauseNameList.size() == 0 || deathCauseNameList == null)) {
				message = "Death Cause Code  already exists.";
			} else if ((deathCauseNameList.size() != 0 || deathCauseNameList != null)
					&& (deathCauseCodeList.size() == 0 || deathCauseCodeList == null)) {
				message = "Death Cause Name already exists.";
			} else if ((deathCauseCodeList.size() != 0 || deathCauseCodeList != null)
					&& (deathCauseNameList.size() != 0 || deathCauseNameList != null)) {
				message = "Death Cause Code and Death Cause Name already exist.";
			}

		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Add Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String deathCauseCode = "";
		String deathCauseName = "";
		int deathCauseId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			deathCauseId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", deathCauseId);
		generalMap.put("deathCauseCode", deathCauseCode);
		generalMap.put("name", deathCauseName);
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
		List existingDeathCauseNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDeathCauseNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editDeathCauseToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDeathCauseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Update Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDeathCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int deathCauseId = 0;
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
			deathCauseId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteDeathCause(
				deathCauseId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showDeathCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showDeathCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEATH_CAUSE_JSP;
		title = "Delete Death Cause";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------Patient_Status
	// -----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = (Map<String, Object>) hospitalDetailsMasterHandlerService
				.showPatientStatusJsp();
		jsp = PATIENT_STATUS_JSP;
		jsp += ".jsp";
		title = "PatientStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatusCode = null;
		String patientStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(BLOOD_GROUP_CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
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
			patientStatusCode = searchField;
			patientStatusName = null;
		} else {
			patientStatusCode = null;
			patientStatusName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchPatientStatus(
				patientStatusCode, patientStatusName);
		jsp = PATIENT_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientStatusCode", patientStatusCode);
		map.put("patientStatusName", patientStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPatientStatus masPatientStatus = new MasPatientStatus();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
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
		List patientStatusCodeList = new ArrayList();
		List patientStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			patientStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			patientStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((patientStatusCodeList.size() == 0 || patientStatusCodeList == null)
				&& (patientStatusNameList.size() == 0 || patientStatusNameList == null)) {
			masPatientStatus.setPatientStatusCode(code);
			masPatientStatus.setPatientStatusName(name);
			masPatientStatus.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masPatientStatus.setLastChgBy(user);
			masPatientStatus.setLastChgDate(currentDate);
			masPatientStatus.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addPatientStatus(masPatientStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
				|| (patientStatusNameList.size() != 0)
				|| patientStatusNameList != null) {

			if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
					&& (patientStatusNameList.size() == 0 || patientStatusNameList == null)) {
				message = "Patient Status Code  already exists.";
			} else if ((patientStatusNameList.size() != 0 || patientStatusNameList != null)
					&& (patientStatusCodeList.size() == 0 || patientStatusCodeList == null)) {
				message = "Patient Status Name already exists.";
			} else if ((patientStatusCodeList.size() != 0 || patientStatusCodeList != null)
					&& (patientStatusNameList.size() != 0 || patientStatusNameList != null)) {
				message = "Patient Status Code and Patient Status Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Add Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String patientStatusCode = "";
		String patientStatusName = "";
		int patientStatusId = 0;
		
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", patientStatusId);
		generalMap.put("patientStatusCode", patientStatusCode);
		generalMap.put("name", patientStatusName);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingPatientStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingPatientStatusNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editPatientStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPatientStatusNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Update Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePatientStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int patientStatusId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deletePatientStatus(
				patientStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showPatientStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPatientStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_STATUS_JSP;
		title = "Delete Patient Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------------BED
	// MASTER-----------------------------------------------------

	public ModelAndView showBedJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int hospitalid=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalid);
		jsp = BED_JSP;
		jsp += ".jsp";
		title = "Bed";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBed(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bedNumber = null;
		HttpSession session = request.getSession(true);
		int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}

		map = hospitalDetailsMasterHandlerService.searchBed(bedNumber,hospitalId);
		jsp = BED_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bedNumber", bedNumber);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBed(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int departmentId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		Date introductionDate = null;
		Date discardDate = null;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		int hospitalid=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(ROOM_ID) != null) {
			roomId = Integer.parseInt(request.getParameter(ROOM_ID));
		}
		if (request.getParameter(BED_STATUS_ID) != null) {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}
		if (request.getParameter(ATTACHED) != null) {
			masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			masBed.setAttached("n");
		}
		/*
		 * if (request.getParameter(CHANGED_BY) != null) { changedBy =
		 * request.getParameter(CHANGED_BY); }
		 */
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
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
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		generalMap.put("hospitalid", hospitalid);
		generalMap.put("name", bedNumber);
		generalMap.put("code", departmentId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = hospitalDetailsMasterHandlerService
				.checkForExistingMastersForHospital(generalMap);
		List bedNumberList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bedNumberList = (List) listMap.get("duplicateGeneralCodeList");
		}

		boolean successfullyAdded = false;
		if (bedNumberList.size() == 0) {
			masBed.setBedNo(bedNumber);

			MasDepartment departmentObj = new MasDepartment();
			departmentObj.setId(departmentId);
			masBed.setDepartment(departmentObj);

			MasRoom roomObj = new MasRoom();
			roomObj.setId(roomId);
			masBed.setRoom(roomObj);

			MasBedStatus bedStatusObj = new MasBedStatus();
			bedStatusObj.setId(bedStatusId);
			masBed.setBedStatus(bedStatusObj);

			masBed.setAdNo(adNo);
			masBed.setDietType(dietType);
			masBed.setIntroductionDate(introductionDate);
			masBed.setDiscardDate(discardDate);
			masBed.setStatus("y");
			masBed.setBedType("P");
			Users users=new Users();
			users.setId(userId);
			masBed.setLastChgBy(users);
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalid);
			masBed.setHospital(hospital);
			
			masBed.setFlag("WARD");

			masBed.setLastChgDate(changedDate);
			masBed.setLastChgTime(changedTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addBed(masBed);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (bedNumberList.size() != 0) {
			message = "Same Bed Number for selected Ward already exists.";
		}
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "Add Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int bedId = 0;
		int departmentId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		Date introductionDate = null;
		Date discardDate = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = new Date();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		session = request.getSession(true);
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
int hospitalid=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != "") {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(BED_STATUS_ID) != "") {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
		if (request.getParameter(ROOM_ID) != "") {
			roomId = Integer.parseInt(request.getParameter(ROOM_ID));
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}

		if (request.getParameter(ATTACHED) != null) {
			masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			masBed.setAttached("n");
		}

		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
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
		generalMap.put("id", bedId);
		generalMap.put("bedNumber", bedNumber);
		generalMap.put("departmentId", departmentId);
		generalMap.put("bedStatusId", bedStatusId);
		generalMap.put("roomId", roomId);
		generalMap.put("adNo", adNo);
		generalMap.put("dietType", dietType);
		generalMap.put("attached", attached);
		generalMap.put("introductionDate", introductionDate);
		generalMap.put("discardDate", discardDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataUpdated = false;
		dataUpdated = hospitalDetailsMasterHandlerService
				.editBedToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/hospital?method=showBedJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "Add Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBed(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		int bedId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
int hospitalid=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteBed(bedId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showBedJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showBedJsp(hospitalid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BED_JSP;
		title = "delete Bed";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------Service
	// Status----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showServiceStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		jsp = SERVICE_STATUS_JSP;
		jsp += ".jsp";
		title = "ServiceStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceStatusCode = null;
		String serviceStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceStatusName = request.getParameter(SEARCH_NAME);
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
			serviceStatusCode = searchField;
			serviceStatusName = null;
		} else {
			serviceStatusCode = null;
			serviceStatusName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchServiceStatus(
				serviceStatusCode, serviceStatusName);

		jsp = SERVICE_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("serviceStatusCode", serviceStatusCode);
		map.put("serviceStatusName", serviceStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
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

		List serviceStatusCodeList = new ArrayList();
		List serviceStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			serviceStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			serviceStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((serviceStatusCodeList.size() == 0 || serviceStatusCodeList == null)
				&& (serviceStatusNameList.size() == 0 || serviceStatusNameList == null)) {
			masServiceStatus.setServiceStatusCode(code);
			masServiceStatus.setServiceStatusName(name);
			masServiceStatus.setStatus("y");
			masServiceStatus.setLastChgBy(changedBy);
			masServiceStatus.setLastChgDate(currentDate);
			masServiceStatus.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addServiceStatus(masServiceStatus);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		}

		else if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
				|| (serviceStatusNameList.size() != 0)
				|| serviceStatusNameList != null) {
			if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
					&& (serviceStatusNameList.size() == 0 || serviceStatusNameList == null)) {
				message = "Service Status Code  already exists.";
			} else if ((serviceStatusNameList.size() != 0 || serviceStatusNameList != null)
					&& (serviceStatusCodeList.size() == 0 || serviceStatusCodeList == null)) {
				message = "Service Status Name already exists.";
			} else if ((serviceStatusCodeList.size() != 0 || serviceStatusCodeList != null)
					&& (serviceStatusNameList.size() != 0 || serviceStatusNameList != null)) {
				message = "Service Status Code and Service Status Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Add Service Status";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String serviceStatusCode = "";
		String serviceStatusName = "";
		int serviceStatusId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";

		serviceStatusCode = (String) session.getAttribute("serviceStatusCode");
		serviceStatusName = (String) session.getAttribute("serviceStatusName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			serviceStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceStatusName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", serviceStatusId);
		generalMap.put("serviceStatusCode", serviceStatusCode);
		generalMap.put("name", serviceStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingServiceStatusNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingServiceStatusNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editServiceStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingServiceStatusNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Edit Service Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteServiceStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceStatusId = 0;
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
			serviceStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteServiceStatus(
				serviceStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showServiceStatusJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_STATUS_JSP;
		title = "Delete Service Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------- Case Type -------------------------
	public ModelAndView searchCaseType(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String caseTypeCode = null;
		String caseTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			caseTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			caseTypeName = request.getParameter(SEARCH_NAME);
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
			caseTypeCode = searchField;
			caseTypeName = null;

		} else {
			caseTypeCode = null;
			caseTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCaseType(caseTypeCode,
				caseTypeName);

		jsp = CASE_TYPE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("caseTypeCode", caseTypeCode);
		map.put("caseTypeName", caseTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCaseTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchCaseTypeList = (ArrayList) map
				.get("searchCaseTypeList");
		jsp = CASE_TYPE_JSP;
		jsp += ".jsp";
		title = "CaseType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCaseType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCaseType masCaseType = new MasCaseType();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		//String changedBy = "";
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
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		

		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List caseTypeCodeList = new ArrayList();
		List caseTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			caseTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			caseTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((caseTypeCodeList.size() == 0 || caseTypeCodeList == null)
				&& (caseTypeNameList.size() == 0 || caseTypeNameList == null)) {
			masCaseType.setCaseTypeCode(code);
			masCaseType.setCaseTypeName(name);
			masCaseType.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masCaseType.setLastChgBy(user);
			masCaseType.setLastChgDate(currentDate);
			masCaseType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addCaseType(masCaseType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
				|| (caseTypeNameList.size() != 0) || caseTypeNameList != null) {

			if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
					&& caseTypeNameList.size() == 0 || caseTypeNameList == null) {
				message = "CT Code  already exists.";
			} else if ((caseTypeNameList.size() != 0 || caseTypeNameList != null)
					&& (caseTypeCodeList.size() == 0 || caseTypeCodeList == null)) {

				message = "CT Name already exists.";
			} else if ((caseTypeCodeList.size() != 0 || caseTypeCodeList != null)
					&& (caseTypeNameList.size() != 0 || caseTypeNameList != null)) {

				message = "CT Code and CT Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Add Case type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editCaseType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String caseTypeCode = "";
		String caseTypeName = "";
		int caseTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			caseTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			caseTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			caseTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", caseTypeId);
		generalMap.put("caseTypeCode", caseTypeCode);
		generalMap.put("name", caseTypeName);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCaseTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCaseTypeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editCaseTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCaseTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Edit Case type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteCaseType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int caseTypeId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			caseTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteCaseType(
				caseTypeId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showCaseTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showCaseTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASE_TYPE_JSP;
		title = "Delete Case type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------- Main Charge
	// Code-----------------------------

	public ModelAndView searchMainChargecode(HttpServletRequest request,
			HttpServletResponse esponse) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String mainChargecodeCode = null;
		String mainChargecodeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
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
			mainChargecodeCode = searchField;
			mainChargecodeName = null;

		} else {
			mainChargecodeCode = null;
			mainChargecodeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchMainChargecode(
				mainChargecodeCode, mainChargecodeName);

		jsp = MAIN_CHARGECODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("mainChargecodeCode", mainChargecodeCode);
		map.put("mainChargecodeName", mainChargecodeName);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMainChargecodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		@SuppressWarnings("unused")
		ArrayList searchMainChargecodeList = (ArrayList) map
				.get("searchMainChargecodeList");

		jsp = MAIN_CHARGECODE_JSP;
		jsp += ".jsp";
		title = "MainChargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * showBillInstituteWiseServicesJsp method for Institute Wise Billing
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showBillInstituteWiseServicesJsp(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		Box box=HMSUtil.getBox(request);
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null) {
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		box.put(HOSPITAL_ID, hospitalId);
		map = hospitalDetailsMasterHandlerService
				.showBillInstituteWiseServicesJsp(box);
		@SuppressWarnings("unused")
		ArrayList searchMainChargecodeList = (ArrayList) map
				.get("searchMainChargecodeList");
		ArrayList searchSubChargeList = (ArrayList) map
				.get("searchSubChargeList");
		// System.out.println("searchMainChargecodeList");
		jsp = "billInstituteWiseBill";
		jsp += ".jsp";
		title = "MainChargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView submitBillInstituteWiseServicesJsp(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		Box box=HMSUtil.getBox(request);
		int hospitalId=0;
		int userId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(session.getAttribute(RequestConstants.USER_ID)!=null)
		{
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		box.put(HOSPITAL_ID, hospitalId);
		box.put(RequestConstants.USER_ID, userId);
		
		
		map = hospitalDetailsMasterHandlerService.submitBillInstituteWiseServicesJsp(box);
		//Added by Arbind on 27-06-2017
		String message = (String) map.get("message");
		
		map = hospitalDetailsMasterHandlerService
				.showBillInstituteWiseServicesJsp(box);
		jsp = "billInstituteWiseBill";
		jsp += ".jsp";
		title = "MainChargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		map.put("hospitalId", hospitalId);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getBillInstituteWiseServices(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		Box box=HMSUtil.getBox(request);
		int hospitalId=0;
		int userId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		if(session.getAttribute(RequestConstants.USER_ID)!=null)
		{
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		box.put(HOSPITAL_ID, box.getInt("hospital"));
		box.put(RequestConstants.USER_ID, userId);
				
		map = hospitalDetailsMasterHandlerService
				.showBillInstituteWiseServicesJsp(box);
		jsp = "hospitalServices";
		/*jsp += ".jsp";
		title = "MainChargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);*/
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView getBillInstituteWiseServicesForBlockUnBlock(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);
		Box box=HMSUtil.getBox(request);
		int hospitalId=0;
		int userId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		
		if(session.getAttribute(RequestConstants.USER_ID)!=null)
		{
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		box.put(HOSPITAL_ID, box.getInt("hospital"));
		box.put(RequestConstants.USER_ID, userId);
				
		map = hospitalDetailsMasterHandlerService
				.showBillInstituteWiseServicesJsp(box);
		jsp = "hospitalServicesBlockUnblock";
		/*jsp += ".jsp";
		title = "MainChargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);*/
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView showprinterdetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showPrinterDetails();
		@SuppressWarnings("unused")
		ArrayList searchMainChargecodeList = (ArrayList) map
				.get("searchPrinterLists");
		jsp = RequestConstants.Printer_Details_Jsp;
		jsp += ".jsp";
		title = "printerdetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasMainChargecode masMainChargecode = new MasMainChargecode();

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Users user = new Users();
		user.setId(userId);

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int departmentId = 0;
		session = request.getSession();

		if (request.getParameter("departmentName") != null) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentName"));
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

		List mainChargecodeCodeList = new ArrayList();
		List mainChargecodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			mainChargecodeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			mainChargecodeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((mainChargecodeCodeList.size() == 0 || mainChargecodeCodeList == null)
				&& (mainChargecodeNameList.size() == 0 || mainChargecodeNameList == null)) {
			masMainChargecode.setMainChargecodeCode(code);
			masMainChargecode.setMainChargecodeName(name);
			masMainChargecode.setStatus("y");
			masMainChargecode.setLastChgBy(user);
			masMainChargecode.setDepartment(new MasDepartment(departmentId));
			masMainChargecode.setLastChgDate(currentDate);
			masMainChargecode.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addMainChargecode(masMainChargecode);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
				|| (mainChargecodeNameList.size() != 0)
				|| mainChargecodeNameList != null) {

			if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
					&& (mainChargecodeNameList.size() == 0 || mainChargecodeNameList == null)) {

				message = "MainCharge Code  already exists.";
			} else if ((mainChargecodeNameList.size() != 0 || mainChargecodeNameList != null)
					&& (mainChargecodeCodeList.size() == 0 || mainChargecodeCodeList == null)) {

				message = "MainChargeCode Name already exists.";
			} else if ((mainChargecodeCodeList.size() != 0 || mainChargecodeCodeList != null)
					&& (mainChargecodeNameList.size() != 0 || mainChargecodeNameList != null)) {

				message = "MainCharge Code and MainChargeCode Name	already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "Add MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPrinterName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		PrinterCofiguration printerCofiguration = new PrinterCofiguration();

		String changedBy = "";
		/* Map<String, Object> listMap = new HashMap<String, Object>(); */
		Boolean listMap = true;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		session = request.getSession();

		if (request.getParameter("systemIp") != null) {
			systemIp = request.getParameter("systemIp");
		}
		String type = "";
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		String printerName = "";
		if (request.getParameter("printerName") != null) {
			printerName = request.getParameter("printerName");
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

		generalMap.put("systemIp", systemIp);
		generalMap.put("type", type);
		generalMap.put("printerName", printerName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		listMap = hospitalDetailsMasterHandlerService
				.checkprinterDetails(generalMap);

		/*
		 * List printerNameList = new ArrayList(); List systemIPList = new
		 * ArrayList();
		 */

		boolean successfullyAdded = false;

		if (listMap == false) {
			String message = "";
			message = "Printer name Already exists";

		} else {
			if ((systemIp != null) && (printerName != null) && (type != null)) {
				/*
				 * masMainChargecode.setMainChargecodeCode(code);
				 * masMainChargecode.setMainChargecodeName(name);
				 * masMainChargecode.setStatus("y");
				 * masMainChargecode.setLastChgBy(changedBy);
				 * masMainChargecode.setDepartment(new MasDepartment((Integer)
				 * session .getAttribute("deptId")));
				 * masMainChargecode.setLastChgDate(currentDate);
				 * masMainChargecode.setLastChgTime(currentTime);
				 */
				printerCofiguration.setPrinterName(printerName);
				printerCofiguration.setSystemIp(systemIp);
				printerCofiguration.setReportType(type);
				successfullyAdded = hospitalDetailsMasterHandlerService
						.addprinterDetails(printerCofiguration);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
		}
		/*
		 * else if ((printerNameList.size() != 0 || printerNameList != null) ||
		 * (systemIPList.size() != 0) || systemIPList != null) {
		 * 
		 * if ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() =s= 0 || systemIPList == null)) {
		 * 
		 * message = "MainCharge Code  already exists."; } else if
		 * ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() == 0 || systemIPList == null)) {
		 * 
		 * message = "MainChargeCode Name already exists."; } else if
		 * ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() != 0 || systemIPList != null)) {
		 * 
		 * message = "MainCharge Code and MainChargeCode Name	already exist."; }
		 */

		url = "/hms/hms/hospital?method=showprinterdetailsJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPrinterDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.Printer_Details_Jsp;
		title = "Add MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		generalMap.put(RequestConstants.USER_ID, userId);
		String mainChargecodeCode = "";
		String mainChargecodeName = "";
		int mainChargecodeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Date currentDate = null;
		int departmentId = 0;

		if (request.getParameter("departmentName") != null) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentName"));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			mainChargecodeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		/*
		 * if (session.getAttribute("deptId") != null) {
		 * generalMap.put("departmentId", (Integer)
		 * session.getAttribute("deptId")); }
		 */
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", mainChargecodeId);
		generalMap.put("code", mainChargecodeCode);
		generalMap.put("name", mainChargecodeName);

		generalMap.put("departmentId", departmentId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMainChargecodeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingMainChargecodeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editMainChargecodeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMainChargecodeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "Edit MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPrinterDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		PrinterCofiguration printerCofiguration = new PrinterCofiguration();

		String changedBy = "";
		/* Map<String, Object> listMap = new HashMap<String, Object>(); */
		Boolean listMap = true;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		session = request.getSession();
		Integer id = 0;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter("systemIp") != null) {
			systemIp = request.getParameter("systemIp");
		}

		String type = "";
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		String printerName = "";
		if (request.getParameter("printerName") != null) {
			printerName = request.getParameter("printerName");
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

		generalMap.put("id", id);
		generalMap.put("systemIp", systemIp);
		generalMap.put("type", type);
		generalMap.put("printerName", printerName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		listMap = hospitalDetailsMasterHandlerService
				.checkprinterDetails(generalMap);

		/*
		 * List printerNameList = new ArrayList(); List systemIPList = new
		 * ArrayList();
		 */

		boolean dataUpdated = false;

		if (listMap == false) {
			String message = "";
			message = "Printer name Already exists";

		} else {
			if ((systemIp != null) && (printerName != null) && (type != null)) {
				/*
				 * masMainChargecode.setMainChargecodeCode(code);
				 * masMainChargecode.setMainChargecodeName(name);
				 * masMainChargecode.setStatus("y");
				 * masMainChargecode.setLastChgBy(changedBy);
				 * masMainChargecode.setDepartment(new MasDepartment((Integer)
				 * session .getAttribute("deptId")));
				 * masMainChargecode.setLastChgDate(currentDate);
				 * masMainChargecode.setLastChgTime(currentTime);
				 */
				/*
				 * printerCofiguration.setPrinterName(printerName);
				 * printerCofiguration.setSystemIp(systemIp);
				 * printerCofiguration.setType(type);
				 */
				dataUpdated = hospitalDetailsMasterHandlerService
						.editPrinterDetails(generalMap);

				if (dataUpdated) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
		}
		/*
		 * else if ((printerNameList.size() != 0 || printerNameList != null) ||
		 * (systemIPList.size() != 0) || systemIPList != null) {
		 * 
		 * if ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() =s= 0 || systemIPList == null)) {
		 * 
		 * message = "MainCharge Code  already exists."; } else if
		 * ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() == 0 || systemIPList == null)) {
		 * 
		 * message = "MainChargeCode Name already exists."; } else if
		 * ((printerNameList.size() != 0 || printerNameList != null) &&
		 * (systemIPList.size() != 0 || systemIPList != null)) {
		 * 
		 * message = "MainCharge Code and MainChargeCode Name	already exist."; }
		 */

		url = "/hms/hms/hospital?method=showprinterdetailsJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showPrinterDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.Printer_Details_Jsp;
		title = "Edit Printer Details";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMainChargecode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int mainChargecodeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			mainChargecodeId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
		 * request.getParameter(CHANGED_BY); }
		 */
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		Users user = new Users();
		user.setId(userId);

		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteMainChargecode(
				mainChargecodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showMainChargecodeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showMainChargecodeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MAIN_CHARGECODE_JSP;
		title = "delete MainChargecode";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------------------------COMPLAINT-------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showComplaintJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showComplaintJsp();
		jsp = COMPLAINT_JSP;
		jsp += ".jsp";
		title = "Complaint";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchComplaint(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintCode = null;
		String complaintName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
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
			complaintCode = searchField;
			complaintName = null;

		} else {
			complaintCode = null;
			complaintName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplaint(
				complaintCode, complaintName);
		jsp = COMPLAINT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintCode", complaintCode);
		map.put("complaintName", complaintName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addComplaint(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplaint masComplaint = new MasComplaint();
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
	/*	if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
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
		List complaintCodeList = new ArrayList();
		List complaintNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complaintCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complaintNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((complaintCodeList.size() == 0 || complaintCodeList == null)
				&& (complaintNameList.size() == 0 || complaintNameList == null)) {
			masComplaint.setComplaintCode(code);
			masComplaint.setComplaintName(name);
			masComplaint.setStatus("y");
//			masComplaint.setLastChgBy(changedBy);
			Users users=new Users();
			users.setId(changedBy);
			masComplaint.setLastChgBy(users);
			masComplaint.setLastChgDate(currentDate);
			masComplaint.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addComplaint(masComplaint);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((complaintCodeList.size() != 0 || complaintCodeList != null)
				|| (complaintNameList.size() != 0) || complaintNameList != null) {
			if ((complaintCodeList.size() != 0 || complaintCodeList != null)
					&& (complaintNameList.size() == 0 || complaintNameList == null)) {

				message = "Complaint Code  already exists.";
			} else if ((complaintNameList.size() != 0 || complaintNameList != null)
					&& (complaintCodeList.size() == 0 || complaintCodeList == null)) {
				message = "Complaint Name already exists.";
			} else if ((complaintCodeList.size() != 0 || complaintCodeList != null)
					&& (complaintNameList.size() != 0 || complaintNameList != null)) {

				message = "Complaint Code and Complaint Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "Add Complaint";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editComplaint(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String complaintCode = "";
		String complaintName = "";
		int complaintId = 0;
//		String changedBy = "";
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		
		
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
		}
/*		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
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

		generalMap.put("id", complaintId);
		generalMap.put("complaintCode", complaintCode);
		generalMap.put("name", complaintName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingComplaintNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingComplaintNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editComplaintToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingComplaintNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "edit Complaint";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int complaintId = 0;
		String message = null;
		//String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		
		
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteComplaint(
				complaintId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showComplaintJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplaintJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_JSP;
		title = "delete Complaint";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------------------------COMPLICATION----------------------------------------------

	public ModelAndView searchComplication(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complicationCode = null;
		String complicationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complicationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complicationName = request.getParameter(SEARCH_NAME);
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
			complicationCode = searchField;
			complicationName = null;
		} else {
			complicationCode = null;
			complicationName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplication(
				complicationCode, complicationName);

		jsp = COMPLICATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complicationCode", complicationCode);
		map.put("complicationName", complicationName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showComplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showComplicationJsp();
		@SuppressWarnings("unused")
		ArrayList searchComplicationList = (ArrayList) map
				.get("searchComplicationList");
		jsp = COMPLICATION_JSP;
		jsp += ".jsp";
		title = "Complication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addComplication(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplication masComplication = new MasComplication();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
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

		List complicationCodeList = new ArrayList();
		List complicationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complicationCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complicationNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((complicationCodeList.size() == 0 || complicationCodeList == null)
				&& (complicationNameList.size() == 0 || complicationNameList == null)) {
			masComplication.setComplicationCode(code);
			masComplication.setComplicationName(name);
			masComplication.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masComplication.setLastChgBy(users);
			masComplication.setLastChgDate(currentDate);
			masComplication.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addComplication(masComplication);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((complicationCodeList.size() != 0 || complicationCodeList != null)
				|| (complicationNameList.size() != 0)
				|| complicationNameList != null) {

			if ((complicationCodeList.size() != 0 || complicationCodeList != null)
					&& (complicationNameList.size() == 0 || complicationNameList == null)) {

				message = "Complication Code  already exists.";
			} else if ((complicationNameList.size() != 0 || complicationNameList != null)
					&& (complicationCodeList.size() == 0 || complicationCodeList == null)) {

				message = "Complication Name already exists.";
			} else if ((complicationCodeList.size() != 0 || complicationCodeList != null)
					&& (complicationNameList.size() != 0 || complicationNameList != null)) {

				message = "Complication Code and Complication Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showComplicationJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "add Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editComplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		session = request.getSession();
		String complicationCode = "";
		String complicationName = "";
		int complicationId = 0;
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complicationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complicationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complicationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", complicationId);
		generalMap.put("complicationCode", complicationCode);
		generalMap.put("name", complicationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingComplicationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingComplicationNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editComplicationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingComplicationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showComplicationJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "edit Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteComplication(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int complicationId = 0;
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
			complicationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteComplication(
				complicationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showComplicationJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showComplicationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLICATION_JSP;
		title = "delete Complication";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------- Authorizer------------------------------

	public ModelAndView searchAuthorizer(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String authorizerCode = null;
		String authorizerName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			authorizerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			authorizerName = request.getParameter(SEARCH_NAME);
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
			authorizerCode = searchField;
			authorizerName = null;

		} else {
			authorizerCode = null;
			authorizerName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchAuthorizer(
				authorizerCode, authorizerName);
		jsp = AUTHORIZER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("authorizerCode", authorizerCode);
		map.put("authorizerName", authorizerName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAuthorizerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();
		@SuppressWarnings("unused")
		ArrayList searchAuthorizerList = (ArrayList) map
				.get("searchAuthorizerList");
		jsp = AUTHORIZER_JSP;
		jsp += ".jsp";
		title = "Authorizer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasAuthorizer masAuthorizer = new MasAuthorizer();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		BigDecimal maxAuthorizeAmt = new BigDecimal(0);
		BigDecimal minAuthorizeAmt = new BigDecimal(0);

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

		List authorizerCodeList = new ArrayList();
		List authorizerNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			authorizerCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			authorizerNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((authorizerCodeList.size() == 0 || authorizerCodeList == null)
				&& (authorizerNameList.size() == 0 || authorizerNameList == null)) {
			masAuthorizer.setAuthorizerCode(code);
			masAuthorizer.setAuthorizerName(name);
			if (request.getParameter(MAX_AUTHORIZE_AMOUNT) != null
					&& !request.getParameter(MAX_AUTHORIZE_AMOUNT).equals("")) {
				maxAuthorizeAmt = new BigDecimal(
						request.getParameter(MAX_AUTHORIZE_AMOUNT));
				masAuthorizer.setMaxAuthorizeAmt(maxAuthorizeAmt);
			}
			if (request.getParameter(MIN_AUTHORIZE_AMOUNT) != null
					&& !request.getParameter(MIN_AUTHORIZE_AMOUNT).equals("")) {
				minAuthorizeAmt = new BigDecimal(
						request.getParameter(MIN_AUTHORIZE_AMOUNT));
				masAuthorizer.setMinAuthorizeAmt(minAuthorizeAmt);
			}
			masAuthorizer.setStatus("y");
//			masAuthorizer.setLastChgBy(changedBy);
			masAuthorizer.setLastChgDate(currentDate);
			masAuthorizer.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addAuthorizer(masAuthorizer);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		}

		else if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
				|| (authorizerNameList.size() != 0)
				|| authorizerNameList != null) {

			if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
					&& (authorizerNameList.size() == 0 || authorizerNameList == null)) {

				message = "Authorizer Code  already exists.";
			} else if ((authorizerNameList.size() != 0 || authorizerNameList != null)
					&& (authorizerCodeList.size() == 0 || authorizerCodeList == null)) {

				message = "Authorizer Name already exists.";
			} else if ((authorizerCodeList.size() != 0 || authorizerCodeList != null)
					&& (authorizerNameList.size() != 0 || authorizerNameList != null)) {

				message = "Authorizer Code and Authorizer Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "Add Authorizer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String authorizerCode = "";
		String authorizerName = "";
		int authorizerId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		BigDecimal maxAuthorizeAmt = new BigDecimal(0);
		BigDecimal minAuthorizeAmt = new BigDecimal(0);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			authorizerId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			authorizerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			authorizerName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAX_AUTHORIZE_AMOUNT) != null
				&& !request.getParameter(MAX_AUTHORIZE_AMOUNT).equals("")) {
			maxAuthorizeAmt = new BigDecimal(
					request.getParameter(MAX_AUTHORIZE_AMOUNT));
			generalMap.put("maxAuthorizeAmt", maxAuthorizeAmt);
		}
		if (request.getParameter(MIN_AUTHORIZE_AMOUNT) != null
				&& !request.getParameter(MIN_AUTHORIZE_AMOUNT).equals("")) {
			minAuthorizeAmt = new BigDecimal(
					request.getParameter(MIN_AUTHORIZE_AMOUNT));
			generalMap.put("minAuthorizeAmt", minAuthorizeAmt);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", authorizerId);
		generalMap.put("authorizerCode", authorizerCode);
		generalMap.put("name", authorizerName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAuthorizerNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingAuthorizerNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editAuthorizerToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAuthorizerNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "edit Authorizer";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteAuthorizer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int authorizerId = 0;
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
			authorizerId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteAuthorizer(
				authorizerId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showAuthorizerJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showAuthorizerJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AUTHORIZER_JSP;
		title = "delete Authorizer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------- Room
	// ----------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRoomJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showRoomJsp();
		jsp = ROOM_JSP;
		jsp += ".jsp";
		title = "Room";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		MasRoom masRoom = new MasRoom();
		int roomTypeId = 0;
		int departmentId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (!request.getParameter(ROOM_TYPE_ID).equals("0")) {
			roomTypeId = Integer.parseInt(request.getParameter(ROOM_TYPE_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
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
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List roomCodeList = new ArrayList();
		List roomNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			roomCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		boolean successfullyAdded = false;

		if ((roomCodeList.size() == 0 || roomCodeList == null)
				&& (roomNameList.size() == 0 || roomNameList == null)) {
			masRoom.setRoomCode(code);
			if (roomTypeId != 0) {
				MasRoomType masRoomType = new MasRoomType();
				masRoomType.setId(roomTypeId);
				masRoom.setRoomType(masRoomType);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masRoom.setDepartment(masDepartment);
			}
			masRoom.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masRoom.setLastChgBy(users);
			masRoom.setLastChgDate(currentDate);
			masRoom.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addRoom(masRoom);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((roomCodeList.size() != 0 || roomCodeList != null)
				|| (roomNameList.size() != 0) || roomNameList != null) {

			if ((roomCodeList.size() != 0 || roomCodeList != null)
					&& (roomNameList.size() == 0 || roomNameList == null)) {

				message = "Room Code  already exists.";
			} else if ((roomNameList.size() != 0 || roomNameList != null)
					&& (roomCodeList.size() == 0 || roomCodeList == null)) {

				message = "Room Name  already exists.";
			} else if ((roomCodeList.size() != 0 || roomCodeList != null)
					&& (roomNameList.size() != 0 || roomNameList != null)) {

				message = "Room Code and Room Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "add Room";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRoom(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String roomCode = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			roomCode = request.getParameter(CODE);
		}
		map = hospitalDetailsMasterHandlerService.searchRoom(roomCode);
		jsp = ROOM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("roomCode", roomCode);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String roomCode = "";
		int roomTypeId = 0;
		int departmentId = 0;
		int roomId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		roomCode = (String) session.getAttribute("roomCode");
		if (request.getParameter(ROOM_TYPE_ID) != null
				&& !(request.getParameter(ROOM_TYPE_ID).equals(""))) {
			roomTypeId = Integer.parseInt(request.getParameter(ROOM_TYPE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			roomId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			roomCode = request.getParameter(CODE);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", roomId);
		generalMap.put("roomCode", roomCode);
		generalMap.put("roomTypeId", roomTypeId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataUpdated = false;

		dataUpdated = hospitalDetailsMasterHandlerService
				.editRoomToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "edit Room";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteRoom(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int roomId = 0;
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
			roomId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteRoom(roomId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showRoomJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ROOM_JSP;
		title = "delete Room";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * // -------------------------------------------- Charge Code
	 * -----------------------------
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * searchChargeCode(HttpServletRequest request, HttpServletResponse
	 * response) { Map<String, Object> map= new HashMap<String, Object>();
	 * String chargeCodeCode = null; String chargeCodeName = null; String
	 * searchField= null;
	 * 
	 * if(request.getParameter(CHARGE_CODE_CODE) != null &&
	 * !(request.getParameter(CHARGE_CODE_CODE).equals(""))){ chargeCodeCode =
	 * request.getParameter(CHARGE_CODE_CODE); }
	 * 
	 * if(request.getParameter(CHARGE_CODE_NAME) != null &&
	 * !(request.getParameter(CHARGE_CODE_NAME).equals(""))){ chargeCodeName =
	 * request.getParameter(CHARGE_CODE_NAME); }
	 * 
	 * int searchRadio=1; try{ if(request.getParameter(SEARCH_FIELD) != null &&
	 * !(request.getParameter(SEARCH_FIELD).equals(""))){ searchField =
	 * request.getParameter(SEARCH_FIELD); }
	 * 
	 * if(request.getParameter(SELECTED_RADIO) != null &&
	 * !(request.getParameter(SELECTED_RADIO).equals(""))){ searchRadio
	 * =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ; } }catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * if(searchRadio==1){ chargeCodeCode=searchField; chargeCodeName =null;
	 * 
	 * }else{ chargeCodeCode=null; chargeCodeName =searchField; }
	 * 
	 * map =
	 * hospitalDetailsMasterHandlerService.searchChargeCode(chargeCodeCode,
	 * chargeCodeName );
	 * 
	 * jsp=CHARGE_CODE_JSP;
	 * 
	 * jsp += ".jsp"; map.put("contentJsp",jsp); map.put("title", title);
	 * 
	 * 
	 * map.put("chargeCodeCode",chargeCodeCode); map.put("chargeCodeName
	 * ",chargeCodeName );
	 * 
	 * 
	 * 
	 * return new ModelAndView("index", "map", map); }
	 * 
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showChargeCodeJsp(HttpServletRequest request,HttpServletResponse
	 * response) {
	 * 
	 * session = request.getSession(true);
	 * 
	 * map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(); jsp =
	 * CHARGE_CODE_JSP; title = "Charge Code"; jsp +=".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title);
	 * 
	 * return new ModelAndView("index","map",map); }
	 * 
	 * 
	 * 
	 * 
	 * @SuppressWarnings({ "unchecked", "deprecation" }) public ModelAndView
	 * addChargeCode(HttpServletRequest request, HttpServletResponse response){
	 * 
	 * 
	 * Map <String,Object>map = new HashMap<String,Object>();
	 * 
	 * @SuppressWarnings("unused") Map<String, Object> listMap = new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>();
	 * 
	 * MasChargeCode masChargeCode = new MasChargeCode();
	 * 
	 * MasMainChargecode masMainChargecode= new MasMainChargecode() ;
	 * MasSubChargecode masSubChargecode = new MasSubChargecode(); MasChargeType
	 * masChargeType= new MasChargeType(); MasDepartment masDepartment= new
	 * MasDepartment(); MasSample masSample= new MasSample();
	 * MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
	 * String
	 * checkBoxConfidence=null,checkBoxDischargeSummary=null,subTestRecords
	 * =null; String chargeCodeCode; String changedBy="";
	 * 
	 * try {
	 * 
	 * chargeCodeCode =
	 * 
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_CODE);
	 * masChargeCode.setChargeCodeCode(chargeCodeCode);
	 * 
	 * 
	 * masChargeCode.setChargeCodeName(RequestUtils.getStringParameter(request,
	 * CHARGE_CODE_NAME));
	 * 
	 * 
	 * masMainChargecode.setId(RequestUtils.getIntParameter(request,
	 * MAIN_CHARGECODE_ID)); masChargeCode.setMainChargecode(masMainChargecode);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * masSubChargecode.setId(RequestUtils.getIntParameter(request,SUB_CHARGECODE_ID
	 * )); masChargeCode.setSubChargecode(masSubChargecode);
	 * 
	 * masChargeCode.setCharge(RequestUtils.getFloatParameter(request,CHARGE));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * masChargeType.setId(RequestUtils.getIntParameter(request,CHARGE_TYPE_ID));
	 * masChargeCode.setChargeType(masChargeType);
	 * 
	 * masDepartment.setId(RequestUtils.getIntParameter(request,DEPARTMENT_ID));
	 * masChargeCode.setDepartment(masDepartment);
	 * 
	 * subTestRecords = request.getParameter("subTest"); } catch
	 * (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * masSample.setId(RequestUtils.getIntParameter(request,SAMPLE_ID,0));
	 * masChargeCode.setSample(masSample);
	 * 
	 * 
	 * masChargeCode.setNormalValue(RequestUtils.getStringParameter(request,
	 * NORMAL_VALUE,null));
	 * 
	 * 
	 * masUnitOfMeasurement.setId(RequestUtils.getIntParameter(request,
	 * UNIT_OF_MEASUREMENT_ID,0));
	 * masChargeCode.setUnitOfMeasurement(masUnitOfMeasurement);
	 * 
	 * 
	 * 
	 * checkBoxConfidence=RequestUtils.getStringParameter(request,CONFIDENTIAL,null
	 * );
	 * 
	 * 
	 * checkBoxDischargeSummary=RequestUtils.getStringParameter(request,
	 * DSICHARGE_SUMMARY,null); if(checkBoxConfidence==null){
	 * masChargeCode.setConfidential("n"); }else{ try {
	 * 
	 * 
	 * masChargeCode.setConfidential(RequestUtils.getStringParameter(request,
	 * CONFIDENTIAL)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName"); }
	 * if(request.getParameter(POJO_PROPERTY_CODE) != null){ pojoPropertyCode =
	 * request.getParameter(POJO_PROPERTY_CODE); }
	 * if(request.getParameter(POJO_PROPERTY_NAME) != null){ pojoPropertyName =
	 * request.getParameter(POJO_PROPERTY_NAME); }
	 * if(request.getParameter("jspName") != null){ jspName =
	 * request.getParameter("jspName"); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 * 
	 * if(checkBoxDischargeSummary==null){
	 * masChargeCode.setAppearInDischargeSummary("n"); }else{ try {
	 * 
	 * 
	 * 
	 * 
	 * masChargeCode.setAppearInDischargeSummary(RequestUtils.getStringParameter(
	 * request,DSICHARGE_SUMMARY
	 * 
	 * )); } catch (ServletRequestBindingException e) { e.printStackTrace(); } }
	 * 
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
	 * generalMap.put("pojoName", pojoName);
	 * 
	 * listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	 * 
	 * String changedTime=""; Date changedDate= new Date();
	 * if(request.getParameter(CHANGED_DATE) != null){ changedDate =
	 * 
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(CHANGED_BY)
	 * != null &&
	 * 
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * masChargeCode.setLastChgDate(changedDate);
	 * masChargeCode.setLastChgTime(changedTime);
	 * masChargeCode.setLastChgBy(changedBy); masChargeCode.setStatus("y");
	 * boolean successfullyAdded = false; List<MasSubTest> masSubtest = new
	 * ArrayList<MasSubTest>(); if(subTestRecords!=null){ masSubtest =
	 * addSubTest(subTestRecords); }
	 * 
	 * 
	 * 
	 * 
	 * if((checkChargeCodeExsist(masChargeCode.getChargeCodeCode(),masChargeCode.
	 * getChargeCodeName()))==true) {
	 * 
	 * successfullyAdded =
	 * 
	 * 
	 * 
	 * hospitalDetailsMasterHandlerService.addChargeCode(masChargeCode,masSubtest
	 * ); } if(successfullyAdded == true) { message = "Charge Code Information
	 * Saved Successfully "; }else{ message = "Try Again."; }
	 * map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp();
	 * 
	 * }catch (Exception e) { } jsp=CHARGE_CODE_JSP; title="delete ChargeCode";
	 * jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 * 
	 * 
	 * 
	 * public boolean checkChargeCodeExsist(String chargeCodeCode, String
	 * chargeCodeName) { boolean
	 * 
	 * 
	 * 
	 * chargeCodeExsist=hospitalDetailsMasterHandlerService.checkChargeCodeExsist
	 * (chargeCodeCode,chargeCodeName) ; return chargeCodeExsist; }
	 * 
	 * public List<MasSubTest> addSubTest(String subTestEditList) {
	 * StringTokenizer stringTokenizerOfSubTest=new
	 * StringTokenizer(subTestEditList,","); int i=0;
	 * 
	 * List<MasSubTest> subTestList=new ArrayList<MasSubTest>(); MasSubTest
	 * masSubtest =null; while(stringTokenizerOfSubTest.hasMoreTokens()){
	 * masSubtest = new MasSubTest();
	 * 
	 * String tempString =stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(tempString.equals("0")) {
	 * masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) { masSubtest.setNormalValue(normalValue); }
	 * else { masSubtest.setNormalValue(""); } String
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * masSubtest.setUnitOfResult(unitofResult); } else {
	 * masSubtest.setUnitOfResult(""); } stringTokenizerOfSubTest.nextToken();
	 * masSubtest.setStatus("y"); } else{ masSubtest.setId(new
	 * Integer(tempString));
	 * masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) { masSubtest.setNormalValue(normalValue); }
	 * else { masSubtest.setNormalValue(""); } String
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * masSubtest.setUnitOfResult(unitofResult); } else {
	 * masSubtest.setUnitOfResult(""); } stringTokenizerOfSubTest.nextToken();
	 * masSubtest.setStatus("y"); } subTestList.add(masSubtest); i++; }
	 * 
	 * return subTestList; }
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * editChargeCode(HttpServletRequest request, HttpServletResponse
	 * 
	 * response) {
	 * 
	 * Map<String, Object>map = new HashMap<String, Object>(); MasChargeCode
	 * chargeCode=new MasChargeCode(); String changedBy=""; String
	 * checkBoxConfidence=null,checkBoxDischargeSummary=null;String
	 * 
	 * multipleResults = null; String chargeCodeName = null; String
	 * chargeCodeCode=null; Integer chargeCodeId=null; Integer mainChargeId =
	 * null,subChargeId = null,departmentId = null, chargeTypeId = null,
	 * sampleId = null,unitOfResult = null; String status=null,normalValue =
	 * null; try { chargeCodeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_CODE_ID); status =
	 * 
	 * (String)RequestUtils.getStringParameter(request,STATUS, "String");
	 * multipleResults =
	 * 
	 * RequestUtils.getStringParameter(request,"multipleresults", "String"); }
	 * catch (ServletRequestBindingException e1) {
	 * 
	 * e1.printStackTrace(); } boolean subTesttobeDeleted = false; String
	 * subTestEditList = ""; List<MasSubTest> masSubTest = new
	 * ArrayList<MasSubTest>(); subTesttobeDeleted = true;
	 * subTestEditList=request.getParameter("subTest");
	 * 
	 * boolean successfullyAdded=false; String message=null;
	 * if(status.equals("Active")){ try { chargeCode.setId(chargeCodeId);
	 * chargeCodeCode =
	 * 
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_CODE);
	 * chargeCode.setChargeCodeCode(chargeCodeCode); chargeCodeName =
	 * RequestUtils.getStringParameter(request,CHARGE_CODE_NAME);
	 * chargeCode.setChargeCodeName(chargeCodeName); float
	 * amount=RequestUtils.getFloatParameter(request,CHARGE);
	 * chargeCode.setCharge(amount);
	 * 
	 * MasMainChargecode masMainChargecode = new
	 * 
	 * MasMainChargecode(); mainChargeId =
	 * 
	 * RequestUtils.getIntParameter(request,MAIN_CHARGECODE_ID);
	 * masMainChargecode.setId(mainChargeId);
	 * chargeCode.setMainChargecode(masMainChargecode);
	 * 
	 * MasSubChargecode masSubChargecode= new
	 * 
	 * MasSubChargecode(); subChargeId =
	 * 
	 * RequestUtils.getIntParameter(request,SUB_CHARGECODE_ID);
	 * masSubChargecode.setId(subChargeId);
	 * chargeCode.setSubChargecode(masSubChargecode);
	 * 
	 * MasChargeType masChargeType = new MasChargeType(); chargeTypeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_TYPE_ID);
	 * masChargeType.setId(chargeTypeId);
	 * chargeCode.setChargeType(masChargeType);
	 * 
	 * MasDepartment masDepartment= new MasDepartment(); departmentId =
	 * 
	 * RequestUtils.getIntParameter(request,DEPARTMENT_ID);
	 * masDepartment.setId(departmentId);
	 * chargeCode.setDepartment(masDepartment);
	 * 
	 * MasSample masSample= new MasSample(); sampleId =
	 * 
	 * RequestUtils.getIntParameter(request,SAMPLE_ID);
	 * masSample.setId(sampleId); chargeCode.setSample(masSample);
	 * 
	 * normalValue =
	 * 
	 * RequestUtils.getStringParameter(request,NORMAL_VALUE,null);
	 * chargeCode.setNormalValue(normalValue);
	 * 
	 * MasUnitOfMeasurement masUnitOfMeasurement= new
	 * 
	 * MasUnitOfMeasurement(); unitOfResult =
	 * 
	 * RequestUtils.getIntParameter(request,UNIT_OF_MEASUREMENT_ID);
	 * masUnitOfMeasurement.setId(unitOfResult);
	 * 
	 * 
	 * chargeCode.setUnitOfMeasurement(masUnitOfMeasurement); } catch
	 * (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * checkBoxConfidence=RequestUtils.getStringParameter(request,CONFIDENTIAL,null
	 * );
	 * 
	 * 
	 * checkBoxDischargeSummary=RequestUtils.getStringParameter(request,
	 * DSICHARGE_SUMMARY,null); if(checkBoxConfidence==null){
	 * chargeCode.setConfidential("n"); }else{ try {
	 * 
	 * 
	 * chargeCode.setConfidential(RequestUtils.getStringParameter(request,
	 * CONFIDENTIAL)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * if(checkBoxDischargeSummary==null){
	 * chargeCode.setAppearInDischargeSummary("n"); }else{
	 * 
	 * try {
	 * 
	 * 
	 * chargeCode.setAppearInDischargeSummary(RequestUtils.getStringParameter(
	 * request,DSICHARGE_SUMMARY)); } catch (ServletRequestBindingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * String changedTime=""; Date changedDate= new Date();
	 * if(request.getParameter(CHANGED_DATE) != null){ changedDate =
	 * 
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter(CHANGED_BY)
	 * != null &&
	 * 
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * chargeCode.setLastChgDate(changedDate);
	 * chargeCode.setLastChgTime(changedTime);
	 * chargeCode.setLastChgBy(changedBy); chargeCode.setStatus("y");
	 * 
	 * 
	 * if(multipleResults.equals("String")) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if((checkChargeCodeNameExsistForEditing(chargeCodeId,chargeCodeName))==true
	 * ) { if(subTestEditList!= null) { masSubTest =
	 * 
	 * editSubTest(subTestEditList,chargeCodeId); } successfullyAdded =
	 * 
	 * hospitalDetailsMasterHandlerService.editChargeCode(chargeCode,masSubTest,
	 * subTesttobeDeleted);
	 * 
	 * } } else {
	 * 
	 * if(subTestEditList!= null) { masSubTest =
	 * 
	 * editSubTest(subTestEditList,chargeCodeId); }
	 * 
	 * successfullyAdded =
	 * 
	 * hospitalDetailsMasterHandlerService.editChargeCode(chargeCode,
	 * masSubTest, subTesttobeDeleted); }
	 * 
	 * if(successfullyAdded) {
	 * 
	 * message="The Record is updated successfully."; } else {
	 * 
	 * message="The Name already exsist!!!."; } }
	 * 
	 * else {
	 * 
	 * message = "Record is InActive, Can't be Updated."; }
	 * 
	 * 
	 * map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp();
	 * 
	 * }catch (Exception e) { } jsp=CHARGE_CODE_JSP; title="edit ChargeCode";
	 * jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 * 
	 * public List<MasSubTest> editSubTest(String subTestEditList, Integer
	 * chargeCodeId) { { StringTokenizer stringTokenizerOfSubTest=new
	 * 
	 * StringTokenizer(subTestEditList,","); int i=0; List<MasSubTest>
	 * subTestList=new ArrayList<MasSubTest>(); MasSubTest masSubTest =null;
	 * while(stringTokenizerOfSubTest.hasMoreTokens()){ masSubTest = new
	 * MasSubTest();
	 * 
	 * String tempString =stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(tempString.equals("0")) {
	 * 
	 * 
	 * masSubTest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * 
	 * 
	 * masSubTest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * 
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setNormalValue(normalValue); } else {
	 * masSubTest.setNormalValue(""); } String
	 * 
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setUnitOfResult(unitofResult); } else {
	 * masSubTest.setUnitOfResult(""); } stringTokenizerOfSubTest.nextToken();
	 * MasChargeCode masChargeCode = new
	 * 
	 * MasChargeCode(); masChargeCode.setId(chargeCodeId);
	 * masSubTest.setChargeCode(masChargeCode); masSubTest.setStatus("y");
	 * 
	 * } else{
	 * 
	 * masSubTest.setId(new Integer(tempString));
	 * 
	 * 
	 * masSubTest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
	 * 
	 * 
	 * masSubTest.setSubTestName(stringTokenizerOfSubTest.nextToken());
	 * stringTokenizerOfSubTest.nextToken(); String
	 * 
	 * normalValue=stringTokenizerOfSubTest.nextToken();
	 * 
	 * if(!normalValue.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setNormalValue(normalValue); } else {
	 * masSubTest.setNormalValue(""); } String
	 * 
	 * unitofResult=stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * if(!unitofResult.equals("~^")) {
	 * 
	 * 
	 * masSubTest.setUnitOfResult(unitofResult); } else {
	 * masSubTest.setUnitOfResult(""); } stringTokenizerOfSubTest.nextToken();
	 * 
	 * 
	 * masSubTest.getChargeCode().setId(chargeCodeId);
	 * masSubTest.setStatus("y"); } subTestList.add(masSubTest); i++;
	 * 
	 * } return subTestList; } }
	 * 
	 * public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
	 * String
	 * 
	 * chargeCodeName) { boolean
	 * 
	 * chargeCodeameExsistForEdition=hospitalDetailsMasterHandlerService.
	 * checkChargeCodeNameExsistForEditing(chargeCodeId, chargeCodeName); return
	 * chargeCodeameExsistForEdition; }
	 * 
	 * public ModelAndView deleteSubTest(HttpServletRequest
	 * request,HttpServletResponse
	 * 
	 * response){
	 * 
	 * Integer subTestId=(Integer.valueOf(request.getParameter("subTestId")));
	 * hospitalDetailsMasterHandlerService.deleteSubTest(subTestId); return
	 * showChargeCodeJsp(request,response); }
	 * 
	 * 
	 * 
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * deleteChargeCode(HttpServletRequest request, HttpServletResponse
	 * 
	 * response) { Map<String, Object>map = new HashMap<String, Object>();
	 * String status = null; String message; Integer chargeCodeId = null; try {
	 * chargeCodeId =
	 * 
	 * RequestUtils.getIntParameter(request,CHARGE_CODE_ID); status =
	 * (String)RequestUtils.getStringParameter(request,STATUS,
	 * 
	 * "String"); RequestUtils.getStringParameter(request,CHARGE_CODE_CODE); }
	 * catch (ServletRequestBindingException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * boolean successfullyDeleted =
	 * 
	 * 
	 * 
	 * hospitalDetailsMasterHandlerService.deleteChargeCode(chargeCodeId,status);
	 * 
	 * if(successfullyDeleted) { if(status.equals("Active")){ message=" Record
	 * is InActivated successfully"; } else{ message=" Record is Activated
	 * successfully"; } } else {
	 * 
	 * message="Some Problem Occured while Processing Kindly try Again."; }
	 * 
	 * map.put("message",message); url =
	 * "/hms/hms/hospital?method=showChargeCodeJsp"; try{ map =
	 * hospitalDetailsMasterHandlerService.showChargeCodeJsp(); }catch
	 * (Exception e) { } jsp=CHARGE_CODE_JSP; title="delete ChargeCode"; jsp +=
	 * ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 */

	// -------------------------------------------- Charge Code
	// -----------------------------
	@SuppressWarnings("deprecation")
	public ModelAndView searchChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeCodeCode = null;
		String chargeCodeName = null;
		
		HttpSession session=request.getSession();
		
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		

		String searchField = null;

	
		int mas_main_charge_id = 0;
		if (request.getParameter("m1") != null
				&& !(request.getParameter("m1").equals(""))) {
			mas_main_charge_id = Integer.parseInt(request
					.getParameter("m1"));
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
			chargeCodeCode = searchField;
			chargeCodeName = null;

		} else {
			chargeCodeCode = null;
			chargeCodeName = searchField;
		}
		map.put("chargeCodeCode", chargeCodeCode);
		map.put("chargeCodeName", chargeCodeName);
		map.put("mas_main_charge_id",mas_main_charge_id);
		map = hospitalDetailsMasterHandlerService.searchChargeCode(map);

		jsp = CHARGE_CODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeCodeCode", chargeCodeCode);
		map.put("chargeCodeName", chargeCodeName);
		map.put("mas_main_charge_id", mas_main_charge_id);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showChargeCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(map);
		jsp = CHARGE_CODE_JSP;
		jsp += ".jsp";
		title = "ChargeCode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);

	}
      //method for local charge code master-------
	
	@SuppressWarnings("unchecked")
	public ModelAndView showLocalChargeCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		map = hospitalDetailsMasterHandlerService.showLocalChargeCodeJsp(hospitalId);
		jsp = "localChargeCode";
		jsp += ".jsp";
		title = "ChargeCode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);

	}
	//===============end=============================
	public ModelAndView printMainWiseCharge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Integer mas_main_charge_id = 0;
		String investigationType = "";

		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !(request.getParameter(MAIN_CHARGECODE_ID).equals(""))) {
			mas_main_charge_id = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		detailsMap = hospitalDetailsMasterHandlerService.getConnection();
		parameters.put("hospital_id", hospitalId);
		parameters.put("mas_main_charge_id", mas_main_charge_id);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		try {

			HMSUtil.generateReport("Mas_charge_code1", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public ModelAndView addChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> chargeTypeMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> listMapCharge = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		MasChargeCode masChargeCode = new MasChargeCode();
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		MasChargeType masChargeType = new MasChargeType();
		MasDepartment masDepartment = new MasDepartment();
		FaMasAccount faMasAccount = new FaMasAccount();
		FaMasSubLed famasSubLed = new FaMasSubLed();
		MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();

		List chargeCodeCodeList = new ArrayList();
		List chargeCodeNameList = new ArrayList();
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		List<MasChargeCode> checkMasChargeCodeType = new ArrayList<MasChargeCode>();
		List<MasChargeCode> existChargeDeptList = new ArrayList<MasChargeCode>();
		String changedBy = "";
		Date currentDate = new Date();
		Date effactiveFromDate = new Date();
		Date effactiveToDate = new Date();
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int chargeTypeId = 0;
		int departmentId = 0;
		int subAccountId = 0;
		int accountId = 0;
		float amount = 0;
		int chargeCodeId = 0;
		String editable = "";
		String discountable = "";
		String drAccountRequired = "";
		String opd_related_services = "";
		String chargeTypeName = "";
		Integer chargeTypeNameId = 0;
		boolean successfullyAdded = false;
		Users user = null;
		HttpSession session = request.getSession();
		user = (Users) session.getAttribute("users");

		if (request.getParameter(CHARGE_CODE) != null) {
			code = request.getParameter(CHARGE_CODE);
		}
		if (request.getParameter(CHARGE_NAME) != null) {
			name = request.getParameter(CHARGE_NAME);
		}
		if (request.getParameter(CHARGE) != null && 
				!request.getParameter(CHARGE).equals("")) {
			amount = Float.parseFloat(request.getParameter(CHARGE));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_TYPE_ID) != null) {
			chargeTypeId = Integer.parseInt(request
					.getParameter(CHARGE_TYPE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EFFECTIVE_DATE_FROM) != null
				&& !(request.getParameter(EFFECTIVE_DATE_FROM).equals(""))) {
			effactiveFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_FROM));
		}
		if (request.getParameter(EFFECTIVE_DATE_TO) != null
				&& !(request.getParameter(EFFECTIVE_DATE_TO).equals(""))) {
			effactiveToDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_TO));
		}
		if (request.getParameter(FA_ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(FA_ACCOUNT_ID));
		}
		if (request.getParameter(FA_MAS_SUB_LED) != null) {
			subAccountId = Integer.parseInt(request
					.getParameter(FA_MAS_SUB_LED));
		}
		if (request.getParameter(EDITABLE) != null) {
			editable = request.getParameter(EDITABLE);
		} else {
			editable = "n";
		}
		if (request.getParameter(DISCOUNTABLE) != null) {
			discountable = request.getParameter(DISCOUNTABLE);
		} else {
			discountable = "n";
		}
		if (request.getParameter(DR_ACC_REQ) != null) {
			drAccountRequired = request.getParameter(DR_ACC_REQ);
		} else {
			drAccountRequired = "n";
		}
		if (request.getParameter(OPD_RELATED_SERVICES) != null) {
			opd_related_services = request.getParameter(OPD_RELATED_SERVICES);
		} else {
			opd_related_services = "n";
		}

		if (request.getParameter(DISCOUNT_PERCENTAGE) != ""
				&& request.getParameter(DISCOUNT_PERCENTAGE) != null) {
			masChargeCode.setDiscountPercentage(new BigDecimal(request
					.getParameter(DISCOUNT_PERCENTAGE)));
		} else {
			masChargeCode.setDiscountPercentage(new BigDecimal(0));
		}
		if (request.getParameter(STD_DEDUCTION_GEN) != null
				&& !(request.getParameter(STD_DEDUCTION_GEN).equals(""))) {
			masChargeCode.setStdDeductionGen(new BigDecimal(request
					.getParameter(STD_DEDUCTION_GEN)));
		}
		if (request.getParameter(STD_DEDUCTION_SPL) != null
				&& !(request.getParameter(STD_DEDUCTION_SPL).equals(""))) {
			masChargeCode.setStdDeductionSpl(new BigDecimal(request
					.getParameter(STD_DEDUCTION_SPL)));
		}

		if (request.getParameter("proceCode") != null
				&& !(request.getParameter("proceCode").equals(""))) {
			masChargeCode.setProcedureCode(request.getParameter("proceCode"));
		}

		if (request.getParameter("pacsInteg") != null
				&& !(request.getParameter("pacsInteg").equals(""))) {
			masChargeCode
					.setChargePacsStatus(request.getParameter("pacsInteg"));
		}

		if (request.getParameter("telemediInteg") != null
				&& !(request.getParameter("telemediInteg").equals(""))) {
			masChargeCode.setTelemedicineStatus(request
					.getParameter("telemediInteg"));
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
		}//Added By Om tripathi 25/09/2017
		if (request.getParameter("CommonChargeCodeStatus") != null) {
			CommonChargeCodeStatus = request.getParameter("CommonChargeCodeStatus");
		}
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("effactiveFromDate", effactiveFromDate);
		generalMap.put("effactiveToDate", effactiveToDate);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		chargeTypeMap = hospitalDetailsMasterHandlerService	.checkChargeTypeName(chargeTypeId);
		listMap = hospitalDetailsMasterHandlerService.checkForExistingChargeCode(generalMap);
		searchChargeTypeList = (List) chargeTypeMap.get("searchChargeTypeList");

		if (listMap.get("chargeCodeList") != null) {
			chargeCodeCodeList = (List) listMap.get("chargeCodeList");
		}
		if (listMap.get("chargeNameList") != null) {
			chargeCodeNameList = (List) listMap.get("chargeNameList");
		}

		if (searchChargeTypeList.size() > 0) {
			chargeTypeName = searchChargeTypeList.get(0).getChargeTypeName();
			if (chargeTypeName.equalsIgnoreCase("Room Rent")) {
				chargeTypeNameId = searchChargeTypeList.get(0).getId();
				/*listMapCharge = hospitalDetailsMasterHandlerService
						.checkMasChargeCodeType(chargeTypeNameId);*/
				/*checkMasChargeCodeType = (List) listMapCharge
						.get("checkMasChargeCodeType");*/

				if (checkMasChargeCodeType.size() > 0) {
					message = "Record already exist for the selected Charge Type ";
				} else {
					if ((chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)
							&& (chargeCodeNameList.size() == 0 || chargeCodeNameList == null)) {
						masChargeCode.setChargeCodeCode(code);
						masChargeCode.setChargeCodeName(name);
						masChargeCode.setCharge(amount);

						masMainChargecode.setId(mainChargecodeId);
						masChargeCode.setMainChargecode(masMainChargecode);

						masSubChargecode.setId(subChargecodeId);
						masChargeCode.setSubChargecode(masSubChargecode);

						masChargeType.setId(chargeTypeId);
						masChargeCode.setChargeType(masChargeType);

						masDepartment.setId(departmentId);
						masChargeCode.setDepartment(masDepartment);
						if (accountId != 0) {
							faMasAccount.setId(accountId);
							masChargeCode.setAccount(faMasAccount);
						}
						if (subAccountId != 0) {
							famasSubLed.setId(subAccountId);
							masChargeCode.setSubAccount(famasSubLed);
						}

						masChargeCode.setEditable(editable);
						masChargeCode.setDiscountable(discountable);
						masChargeCode
								.setDrAccountingRequired(drAccountRequired);
						masChargeCode
								.setOpdRelatedServices(opd_related_services);

						masChargeCode.setDateEffectiveFrom(effactiveFromDate);
						// masChargeCode.setDateEffectiveTo(effactiveToDate);
						masChargeCode.setLastChgBy(user);
						masChargeCode.setLastChgDate(currentDate);
						masChargeCode.setLastChgTime(currentTime);
						masChargeCode.setStatus("y");
						masChargeCode.setCommonChargeCodeStatus(CommonChargeCodeStatus); //Added By Om tripathi 25/09/2017
						// ------------ Code Added by Ritu
						// -------------------------------

						chargeCodeRates.setRate(new BigDecimal(amount));
						chargeCodeRates.setEffectiveFromDate(effactiveFromDate);

						dataMap.put("masChargeCode", masChargeCode);
						dataMap.put("chargeCodeRates", chargeCodeRates);
						// if((checkChargeCodeExsist(masChargeCode.getChargeCodeCode(),masChargeCode.getChargeCodeName()))==true){
						successfullyAdded = hospitalDetailsMasterHandlerService
								.addChargeCode(dataMap);
						// }

						if (successfullyAdded) {
							message = "Record Added Successfully !!";
						} else {
							message = "Try Again !!";
						}
					} else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
							|| (chargeCodeNameList.size() != 0)
							|| chargeCodeNameList != null) {
						if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
								&& (chargeCodeNameList.size() == 0 || chargeCodeNameList == null)) {
							message = "Charge Code  already exists.";
						} else if ((chargeCodeNameList.size() != 0 || chargeCodeNameList != null)
								&& (chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)) {
							message = "Charge Name already exists.";
						} else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
								&& (chargeCodeNameList.size() != 0 || chargeCodeNameList != null)) {
							message = "Charge Code and Charge Name already exist.";
						}
					}
				}
			} else {
				if ((chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)
						&& (chargeCodeNameList.size() == 0 || chargeCodeNameList == null)) {
					masChargeCode.setChargeCodeCode(code);
					masChargeCode.setChargeCodeName(name);
					masChargeCode.setCharge(amount);

					masMainChargecode.setId(mainChargecodeId);
					masChargeCode.setMainChargecode(masMainChargecode);

					masSubChargecode.setId(subChargecodeId);
					masChargeCode.setSubChargecode(masSubChargecode);

					masChargeType.setId(chargeTypeId);
					masChargeCode.setChargeType(masChargeType);

					masDepartment.setId(departmentId);
					masChargeCode.setDepartment(masDepartment);
					if (accountId != 0) {
						faMasAccount.setId(accountId);
						masChargeCode.setAccount(faMasAccount);
					}
					if (subAccountId != 0) {
						famasSubLed.setId(subAccountId);
						masChargeCode.setSubAccount(famasSubLed);
					}
					/*faMasAccount.setId(accountId);
					masChargeCode.setAccount(faMasAccount);

					famasSubLed.setId(subAccountId);
					masChargeCode.setSubAccount(famasSubLed);*/

					masChargeCode.setEditable(editable);
					masChargeCode.setDiscountable(discountable);
					masChargeCode.setDrAccountingRequired(drAccountRequired);
					masChargeCode.setOpdRelatedServices(opd_related_services);

					masChargeCode.setDateEffectiveFrom(effactiveFromDate);
					// masChargeCode.setDateEffectiveTo(effactiveToDate);
					masChargeCode.setLastChgBy(user);
					masChargeCode.setLastChgDate(currentDate);
					masChargeCode.setLastChgTime(currentTime);
					masChargeCode.setStatus("y");
					masChargeCode.setCommonChargeCodeStatus(CommonChargeCodeStatus);
					// ------------ Code Added by Ritu
					// -------------------------------

					chargeCodeRates.setRate(new BigDecimal(amount));
					chargeCodeRates.setEffectiveFromDate(effactiveFromDate);

					dataMap.put("masChargeCode", masChargeCode);
					dataMap.put("chargeCodeRates", chargeCodeRates);
					// if((checkChargeCodeExsist(masChargeCode.getChargeCodeCode(),masChargeCode.getChargeCodeName()))==true){
					successfullyAdded = hospitalDetailsMasterHandlerService
							.addChargeCode(dataMap);
					// }

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}
				} else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
						|| (chargeCodeNameList.size() != 0)
						|| chargeCodeNameList != null) {
					if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
							&& (chargeCodeNameList.size() == 0 || chargeCodeNameList == null)) {
						message = "Charge Code  already exists.";
					} else if ((chargeCodeNameList.size() != 0 || chargeCodeNameList != null)
							&& (chargeCodeCodeList.size() == 0 || chargeCodeCodeList == null)) {
						message = "Charge Name already exists.";
					} else if ((chargeCodeCodeList.size() != 0 || chargeCodeCodeList != null)
							&& (chargeCodeNameList.size() != 0 || chargeCodeNameList != null)) {
						message = "Charge Code and Charge Name already exist.";
					}
				}
			}
		}

		try {
			if (masChargeCode.getId() != null && masChargeCode.getId() != 0) {
				chargeCodeId = masChargeCode.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = CHARGE_CODE_JSP;
		title = "Add ChargeCode";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeTypeId", chargeTypeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargecodeId", subChargecodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("name", name);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeName) {
		boolean chargeCodeExsist = hospitalDetailsMasterHandlerService
				.checkChargeCodeExsist(chargeCodeCode, chargeCodeName);
		return chargeCodeExsist;
	}

	public boolean checkprinterDetails(String chargeCodeCode,
			String chargeCodeName) {
		boolean printernameList = hospitalDetailsMasterHandlerService
				.checkprinterDetails(generalMap);
		return printernameList;
	}

	public List<MasSubTest> addSubTest(String subTestEditList) {
		StringTokenizer stringTokenizerOfSubTest = new StringTokenizer(
				subTestEditList, ",");
		int i = 0;

		List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
		MasSubTest masSubtest = null;
		while (stringTokenizerOfSubTest.hasMoreTokens()) {
			masSubtest = new MasSubTest();

			String tempString = stringTokenizerOfSubTest.nextToken();

			if (tempString.equals("0")) {
				masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
				masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
				stringTokenizerOfSubTest.nextToken();
				String normalValue = stringTokenizerOfSubTest.nextToken();

				if (!normalValue.equals("~^")) {
					masSubtest.setNormalValue(normalValue);
				} else {
					masSubtest.setNormalValue("");

				}
				String unitofResult = stringTokenizerOfSubTest.nextToken();

				if (!unitofResult.equals("~^")) {
					masSubtest.setUnitOfResult(unitofResult);
				} else {
					masSubtest.setUnitOfResult("");

				}
				stringTokenizerOfSubTest.nextToken();
				masSubtest.setStatus("y");
			} else {
				masSubtest.setId(new Integer(tempString));
				masSubtest.setSubTestCode(stringTokenizerOfSubTest.nextToken());
				masSubtest.setSubTestName(stringTokenizerOfSubTest.nextToken());
				stringTokenizerOfSubTest.nextToken();
				String normalValue = stringTokenizerOfSubTest.nextToken();

				if (!normalValue.equals("~^")) {
					masSubtest.setNormalValue(normalValue);
				} else {
					masSubtest.setNormalValue("");

				}
				String unitofResult = stringTokenizerOfSubTest.nextToken();

				if (!unitofResult.equals("~^")) {
					masSubtest.setUnitOfResult(unitofResult);
				} else {
					masSubtest.setUnitOfResult("");

				}
				stringTokenizerOfSubTest.nextToken();
				masSubtest.setStatus("y");
			}
			subTestList.add(masSubtest);
			i++;
		}

		return subTestList;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		generalMap.put(RequestConstants.USER_ID, (Integer)session.getAttribute(RequestConstants.USER_ID));
		int chargeId = 0;
		int mainChargeId = 0;
		int departmentId = 0;
		int subChargeId = 0;
		int chargeTypeId = 0;
		int accountId = 0;
		int subAccountId = 0;
		float charge = 0;

		String chargeName = "";
		String chargeCode = "";
		String changedBy = "";
		String changedTime = "";
		String editable = "";
		String discountable = "";
		String drAccountRequired = "";
		String opd_related_services = "";
		String proceCode = "";
		String pacsInteg = "";
		String telemediInteg = "";
		Date changedDate = new Date();
		Date effactiveFromDate = new Date();
		Date effactiveToDate = new Date();
		String CommonChargeCodeStatus=null;
		BigDecimal discountPercentage = new BigDecimal(0);
		BigDecimal stdDeductionGen = new BigDecimal(0.00);
		BigDecimal stdDeductionSpl = new BigDecimal(0.00);
		if (request.getParameter("CommonChargeCodeStatus") != null) {
			CommonChargeCodeStatus =request.getParameter("CommonChargeCodeStatus");
		}
		
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !(request.getParameter(MAIN_CHARGECODE_ID).equals(""))) {
			mainChargeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals(""))) {
			subChargeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(CHARGE_TYPE_ID) != null
				&& !(request.getParameter(CHARGE_TYPE_ID).equals(""))) {
			chargeTypeId = Integer.parseInt(request
					.getParameter(CHARGE_TYPE_ID));
		}
		if (request.getParameter(FA_MAS_SUB_LED) != null
				&& !(request.getParameter(FA_MAS_SUB_LED).equals(""))) {
			subAccountId = Integer.parseInt(request
					.getParameter(FA_MAS_SUB_LED));
		}
		if (request.getParameter(FA_ACCOUNT_ID) != null
				&& !(request.getParameter(FA_ACCOUNT_ID).equals(""))) {
			accountId = Integer.parseInt(request.getParameter(FA_ACCOUNT_ID));
		}
		if (request.getParameter(CHARGE_CODE) != null
				&& !(request.getParameter(CHARGE_CODE).equals(""))) {
			chargeCode = request.getParameter(CHARGE_CODE);
		}
		if (request.getParameter(CHARGE_NAME) != null
				&& !(request.getParameter(CHARGE_NAME).equals(""))) {
			chargeName = request.getParameter(CHARGE_NAME);
		}
		if (request.getParameter(CHARGE) != null
				&& !request.getParameter(CHARGE).equals("0")
				&& !request.getParameter(CHARGE).equals("")) {
			charge = Float.parseFloat(request.getParameter(CHARGE));
		}
		if (request.getParameter(EDITABLE) != null
				&& !(request.getParameter(EDITABLE).equals(""))) {
			editable = request.getParameter(EDITABLE);
		} else {
			editable = "n";
		}
		if (request.getParameter(DISCOUNTABLE) != null
				&& !(request.getParameter(DISCOUNTABLE).equals(""))) {
			discountable = request.getParameter(DISCOUNTABLE);
		} else {
			discountable = "n";
		}
		if (request.getParameter(DR_ACC_REQ) != null
				&& !(request.getParameter(DR_ACC_REQ).equals(""))) {
			drAccountRequired = request.getParameter(DR_ACC_REQ);
		} else {
			drAccountRequired = "n";
		}
		if (request.getParameter(OPD_RELATED_SERVICES) != null) {
			opd_related_services = request.getParameter(OPD_RELATED_SERVICES);
		} else {
			opd_related_services = "n";
		}

		if (request.getParameter(DISCOUNT_PERCENTAGE) != null
				&& !request.getParameter(DISCOUNT_PERCENTAGE).equals("")) {
			discountPercentage = new BigDecimal(
					request.getParameter(DISCOUNT_PERCENTAGE));
		}
		if (request.getParameter(STD_DEDUCTION_GEN) != null
				&& !(request.getParameter(STD_DEDUCTION_GEN).equals(""))) {
			stdDeductionGen = new BigDecimal(
					request.getParameter(STD_DEDUCTION_GEN));
		}
		if (request.getParameter(STD_DEDUCTION_SPL) != null
				&& !(request.getParameter(STD_DEDUCTION_SPL).equals(""))) {
			stdDeductionSpl = new BigDecimal(
					request.getParameter(STD_DEDUCTION_SPL));
		}

		if (request.getParameter("proceCode") != null
				&& !(request.getParameter("proceCode").equals(""))) {
			proceCode = (request.getParameter("proceCode"));
		}

		if (request.getParameter("pacsInteg") != null
				&& !(request.getParameter("pacsInteg").equals(""))) {
			pacsInteg = (request.getParameter("pacsInteg"));
		}

		if (request.getParameter("telemediInteg") != null
				&& !(request.getParameter("telemediInteg").equals(""))) {
			telemediInteg = (request.getParameter("telemediInteg"));
		}

		if (request.getParameter(EFFECTIVE_DATE_FROM) != null
				&& !(request.getParameter(EFFECTIVE_DATE_FROM).equals(""))) {
			effactiveFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_FROM));
		}
		/*
		 * if(request.getParameter(EFFECTIVE_DATE_TO) != null &&
		 * !(request.getParameter(EFFECTIVE_DATE_TO).equals(""))){
		 * effactiveToDate =
		 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EFFECTIVE_DATE_TO
		 * )); }
		 */
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("CommonChargeCodeStatus", CommonChargeCodeStatus);
		generalMap.put("id", chargeId);
		generalMap.put("charge", charge);
		generalMap.put("chargeTypeId", chargeTypeId);
		generalMap.put("chargeCode", chargeCode);
		generalMap.put("chargeName", chargeName);
		generalMap.put("mainChargeId", mainChargeId);
		generalMap.put("subchargeId", subChargeId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("chargeTypeId", chargeTypeId);
		generalMap.put("discountPercentage", discountPercentage);
		generalMap.put("accountId", accountId);
		generalMap.put("subAccountId", subAccountId);
		generalMap.put("editable", editable);
		generalMap.put("discountable", discountable);
		generalMap.put("drAccountRequired", drAccountRequired);
		generalMap.put("opd_related_services", opd_related_services);
		generalMap.put("effactiveFromDate", effactiveFromDate);
		generalMap.put("effactiveToDate", effactiveToDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("stdDeductionGen", stdDeductionGen);
		generalMap.put("stdDeductionSpl", stdDeductionSpl);
		generalMap.put("proceCode", proceCode);
		generalMap.put("pacsInteg", pacsInteg);
		generalMap.put("telemediInteg", telemediInteg);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSubChargeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSubChargeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editChargeCode(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Can't Be Updated !!";
			}
		} else if (existingSubChargeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showChargeCodeJsp";
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_CODE_JSP;
		title = "edit Charge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	public List<MasSubTest> editSubTest(String subTestEditList,
			Integer chargeCodeId) {
		{
			StringTokenizer stringTokenizerOfSubTest = new

			StringTokenizer(subTestEditList, ",");
			int i = 0;
			List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
			MasSubTest masSubTest = null;
			while (stringTokenizerOfSubTest.hasMoreTokens()) {
				masSubTest = new MasSubTest();

				String tempString = stringTokenizerOfSubTest.nextToken();

				if (tempString.equals("0")) {
					masSubTest.setSubTestCode(stringTokenizerOfSubTest
							.nextToken());

					masSubTest.setSubTestName(stringTokenizerOfSubTest
							.nextToken());
					stringTokenizerOfSubTest.nextToken();
					String normalValue = stringTokenizerOfSubTest.nextToken();

					if (!normalValue.equals("~^")) {

						masSubTest.setNormalValue(normalValue);
					} else {
						masSubTest.setNormalValue("");

					}
					String

					unitofResult = stringTokenizerOfSubTest.nextToken();

					if (!unitofResult.equals("~^")) {

						masSubTest.setUnitOfResult(unitofResult);
					} else {
						masSubTest.setUnitOfResult("");

					}
					stringTokenizerOfSubTest.nextToken();
					MasChargeCode masChargeCode = new

					MasChargeCode();
					masChargeCode.setId(chargeCodeId);
					masSubTest.setChargeCode(masChargeCode);
					masSubTest.setStatus("y");

				} else {

					masSubTest.setId(new Integer(tempString));

					masSubTest.setSubTestCode(stringTokenizerOfSubTest
							.nextToken());
					masSubTest.setSubTestName(stringTokenizerOfSubTest
							.nextToken());
					stringTokenizerOfSubTest.nextToken();
					String

					normalValue = stringTokenizerOfSubTest.nextToken();

					if (!normalValue.equals("~^")) {

						masSubTest.setNormalValue(normalValue);
					} else {
						masSubTest.setNormalValue("");

					}
					String

					unitofResult = stringTokenizerOfSubTest.nextToken();

					if (!unitofResult.equals("~^")) {

						masSubTest.setUnitOfResult(unitofResult);
					} else {
						masSubTest.setUnitOfResult("");

					}
					stringTokenizerOfSubTest.nextToken();

					masSubTest.getChargeCode().setId(chargeCodeId);
					masSubTest.setStatus("y");
				}
				subTestList.add(masSubTest);
				i++;

			}
			return subTestList;

		}
	}

	public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName) {
		boolean

		chargeCodeameExsistForEdition = hospitalDetailsMasterHandlerService
				.checkChargeCodeNameExsistForEditing(chargeCodeId,
						chargeCodeName);
		return chargeCodeameExsistForEdition;

	}

	public ModelAndView deleteSubTest(HttpServletRequest request,
			HttpServletResponse response) {

		Integer subTestId = (Integer.valueOf(request.getParameter("subTestId")));
		hospitalDetailsMasterHandlerService.deleteSubTest(subTestId);
		return showChargeCodeJsp(request, response);
	}

	@SuppressWarnings("deprecation")
	public ModelAndView deleteChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> chargeTypeMap = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		int chargeCodeId = 0;
		int chargeTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		String chargeTypeName = "";
		Date changedDate = null;
		String flag = "";
		Boolean chargeStatus = false;
		boolean dataDeleted = false;

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
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
      //System.out.println("flag==="+flag);
		/*if (flag.equals("Activate")) {
			chargeTypeMap = hospitalDetailsMasterHandlerService
					.checkMasChargeCodeName(chargeCodeId);
			searchChargeTypeList = (List) chargeTypeMap
					.get("searchChargeTypeList");
			if (searchChargeTypeList.size() > 0) {
				chargeTypeName = searchChargeTypeList.get(0).getChargeType()
						.getChargeTypeName();
				if (chargeTypeName.equalsIgnoreCase("Room Rent")) {
					chargeTypeId = hospitalDetailsMasterHandlerService
							.getChargeTypeId(chargeTypeName);
					chargeStatus = hospitalDetailsMasterHandlerService
							.checkStatusMasCharge(chargeTypeId);
					if (chargeStatus == true) // Room rent data is already there
												// and activated in DB
					{
						message = "Record is already activated !!";
					} else {
						dataDeleted = hospitalDetailsMasterHandlerService
								.deleteChargeCode1(chargeCodeId, generalMap);
						if (dataDeleted == true) {
							message = "Record is InActivated successfully !!";
						} else {
							message = "Record is Activated successfully !!";
						}
					}
				}
			}*/
		/*} else // flag Inactivate
		{*/if (flag.equals("Activate")) {
			dataDeleted = hospitalDetailsMasterHandlerService
					.deleteChargeCode1(chargeCodeId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}
		}
		if (flag.equals("InActivate")) {
			dataDeleted = hospitalDetailsMasterHandlerService
					.deleteChargeCode1(chargeCodeId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}
		}
		url = "/hms/hms/hospitalDetailsMaster?method=showChargeCodeJsp";
		int hospitalId=0;
		System.out.println("hospital"+session.getAttribute(HOSPITAL_ID));
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			map.put("hospitalId", hospitalId);
		}
		try {
			map = hospitalDetailsMasterHandlerService.showChargeCodeJsp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CHARGE_CODE_JSP;
		title = "Delete Charge Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);

		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); int
		 * chargeCodeId=0; String message=null;
		 * 
		 * 
		 * if(request.getParameter(CHARGE_CODE_ID) != null &&
		 * !(request.getParameter(CHARGE_CODE_ID).equals(""))){ chargeCodeId
		 * =Integer.parseInt( request.getParameter(CHARGE_CODE_ID)); }
		 * if(request.getParameter("title") != null){ title =
		 * request.getParameter("title"); } boolean dataDeleted=false;
		 * dataDeleted
		 * =hospitalDetailsMasterHandlerService.deleteChargeCode(chargeCodeId);
		 * if (dataDeleted==true) {
		 * 
		 * message="Record is InActivated successfully"; }
		 * 
		 * else{ message="Record is Activated successfully"; } url =
		 * "/hms/hms/hospitalDetailsMaster?method=showChargeCodeJsp"; try{ map =
		 * hospitalDetailsMasterHandlerService.showChargeCodeJsp(); }catch
		 * (Exception e) { e.printStackTrace(); } jsp=CHARGE_CODE_JSP;
		 * title="delete ChargeCode"; jsp += ".jsp";
		 * 
		 * map.put("contentJsp", jsp); map.put("title", title); map.put("url",
		 * url); map.put("message", message); return new ModelAndView("index",
		 * "map", map);
		 */
	}

	// --------------------------------------sub charge Code
	// --------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSubChargeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showSubChargeJsp();
		@SuppressWarnings("unused")
		ArrayList searchSubChargeList = (ArrayList) map
				.get("searchSubChargeList");
		jsp = SUB_CHARGE;
		jsp += ".jsp";
		title = "SubCharge";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSubCharge(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		MasSubChargecode masSubChargecode = new MasSubChargecode();

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Users user = new Users();
		user.setId(userId);

		int mainChargecodeId = 0;
		String changedBy = "";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
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

		List subChargeCodeList = new ArrayList();
		List subChargeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			subChargeCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			subChargeNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		int departmentId = 0;
		if (request.getParameter("departmentId") != null) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}

		boolean successfullyAdded = false;

		if ((subChargeCodeList.size() == 0 || subChargeCodeList == null)
				&& (subChargeNameList.size() == 0 || subChargeNameList == null)) {
			masSubChargecode.setSubChargecodeCode(code);
			masSubChargecode.setSubChargecodeName(name);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			masSubChargecode.setMainChargecode(masMainChargecode);
			masSubChargecode.setStatus("y");
			masSubChargecode.setLastChgBy(user);
			masSubChargecode.setLastChgDate(currentDate);
			masSubChargecode.setLastChgTime(currentTime);

			MasDepartment department = new MasDepartment();
			department.setId(departmentId);
			masSubChargecode.setDepartment(department);

			successfullyAdded = hospitalDetailsMasterHandlerService
					.addSubCharge(masSubChargecode);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
				|| (subChargeNameList.size() != 0) || subChargeNameList != null) {

			if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
					&& (subChargeNameList.size() == 0 || subChargeNameList == null)) {

				message = "SubCharge Code  already exists.";
			} else if ((subChargeNameList.size() != 0 || subChargeNameList != null)
					&& (subChargeCodeList.size() == 0 || subChargeCodeList == null)) {

				message = "SubCharge Description  already exists.";
			} else if ((subChargeCodeList.size() != 0 || subChargeCodeList != null)
					&& (subChargeNameList.size() != 0 || subChargeNameList != null)) {

				message = "SubCharge Code and SubCharge Description already exist.";
			}
		}

		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "add SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSubCharge(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String subChargecodeCode = null;
		String subChargecodeName = null;
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
			subChargecodeCode = searchField;
			subChargecodeName = null;

		} else {
			subChargecodeCode = null;
			subChargecodeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchSubCharge(
				subChargecodeCode, subChargecodeName);

		jsp = SUB_CHARGE;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("subChargecodeCode", subChargecodeCode);
		map.put("subChargecodeName", subChargecodeName);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSubCharge(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String subChargecodeCode = "";
		String subChargecodeName = "";
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			subChargecodeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			subChargecodeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			subChargecodeName = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
		 * request.getParameter(CHANGED_BY); }
		 */
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		int departmentId = 0;
		if (request.getParameter("departmentId") != null) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		System.out.println("deptid---" + departmentId);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		if (session.getAttribute("deptId") != null) {
			generalMap.put("departmentId",
					(Integer) session.getAttribute("deptId"));
		}
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", subChargecodeId);
		generalMap.put("subChargecodeCode", subChargecodeCode);
		generalMap.put("name", subChargecodeName);
		generalMap.put("mainChargecodeId", mainChargecodeId);
		generalMap.put("departmentId", departmentId);
		Users user = new Users();
		user.setId(userId);
		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSubChargeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSubChargeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editSubChargeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSubChargeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showSubChargeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "edit SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteSubCharge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Users user = new Users();
		user.setId(userId);

		int subChargecodeId = 0;
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
			subChargecodeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*
		 * if (request.getParameter(CHANGED_BY) != null &&
		 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
		 * request.getParameter(CHANGED_BY); }
		 */
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;

		dataDeleted = hospitalDetailsMasterHandlerService.deleteSubCharge(
				subChargecodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showSubChargeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showSubChargeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SUB_CHARGE;
		title = "delete SubCharge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------- ICD Main Category
	// -------------------------------

	public ModelAndView searchIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdMaincategoryCode = null;
		String icdMaincategoryName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMaincategoryCode = request.getParameter(CODE);

		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMaincategoryName = request.getParameter(SEARCH_NAME);
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
			icdMaincategoryCode = searchField;
			icdMaincategoryName = null;
		} else {
			icdMaincategoryCode = null;
			icdMaincategoryName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcdMainCategory(
				icdMaincategoryCode, icdMaincategoryName);
		jsp = ICD_MAIN_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdMaincategoryCode", icdMaincategoryCode);
		map.put("icdMaincategoryName", icdMaincategoryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showIcdMainCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdMainCategoryList = (ArrayList) map
				.get("searchIcdMainCategoryList");
		jsp = ICD_MAIN_CATEGORY_JSP;
		jsp += ".jsp";
		title = "ICD Main Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();

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

		List icdMainCategoryCodeList = new ArrayList();
		List icdMainCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdMainCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdMainCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdMainCategoryCodeList.size() == 0 || icdMainCategoryCodeList == null)
				&& (icdMainCategoryNameList.size() == 0 || icdMainCategoryNameList == null)) {
			masIcdMainCategory.setIcdMaincategoryCode(code);
			masIcdMainCategory.setIcdMaincategoryName(name);
			masIcdMainCategory.setStatus("y");
			
			Users users=new Users();
			users.setId(changedBy);
			masIcdMainCategory.setLastChgBy(users);
			masIcdMainCategory.setLastChgDate(currentDate);
			masIcdMainCategory.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdMainCategory(masIcdMainCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		}

		else if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
				|| (icdMainCategoryNameList.size() != 0)
				|| icdMainCategoryNameList != null) {

			if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
					&& (icdMainCategoryNameList.size() == 0 || icdMainCategoryNameList == null)) {

				message = "icd Main Category Code  already exists.";
			} else if ((icdMainCategoryNameList.size() != 0 || icdMainCategoryNameList != null)
					&& (icdMainCategoryCodeList.size() == 0 || icdMainCategoryCodeList == null)) {

				message = "icd Main Category Name already exists.";
			} else if ((icdMainCategoryCodeList.size() != 0 || icdMainCategoryCodeList != null)
					&& (icdMainCategoryNameList.size() != 0 || icdMainCategoryNameList != null)) {

				message = "icd Main Category Code and icd Main Category Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "add IcdMainCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdMainCategoryCode = "";
		String icdMainCategoryName = "";
		int icdMainCategoryId = 0;
		int changedBy=(Integer)session.getAttribute(RequestConstants.USER_ID);
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdMainCategoryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMainCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMainCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", icdMainCategoryId);
		generalMap.put("icdMainCategoryCode", icdMainCategoryCode);
		generalMap.put("name", icdMainCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdMainCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdMainCategoryNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdMainCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdMainCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "edit IcdMainCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteIcdMainCategory(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		int icdMainCategoryId = 0;
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
			icdMainCategoryId = Integer.parseInt(request
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

		dataDeleted = hospitalDetailsMasterHandlerService
				.deleteIcdMainCategory(icdMainCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdMainCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdMainCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_MAIN_CATEGORY_JSP;
		title = "delete IcdMainCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------ICD Master------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showIcdJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showIcdJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdList = (ArrayList) map.get("searchIcdList");
		jsp = ICD_JSP;
		jsp += ".jsp";
		title = "ICD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasIcd masIcd = new MasIcd();

		int icdSubCategoryId = 0;
		int icdCauseId = 0;
		String changedBy = "";
		String phAlert = "";
		String alertType = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("alertToStaff") != null) {
			phAlert = request.getParameter("alertToStaff");
		}
		
		if (request.getParameter("alertType") != null) {
			alertType = request.getParameter("alertType");
		}
		if (!request.getParameter(ICD_SUB_CATEGORY_ID).equals("0")) {
			icdSubCategoryId = Integer.parseInt(request
					.getParameter(ICD_SUB_CATEGORY_ID));
		}
		if (!request.getParameter(ICD_CAUSE_GROUP_ID).equals("0")) {
			icdCauseId = Integer.parseInt(request
					.getParameter(ICD_CAUSE_GROUP_ID));
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

		List icdCodeList = new ArrayList();
		List icdNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdCodeList.size() == 0 || icdCodeList == null)
				&& (icdNameList.size() == 0 || icdNameList == null)) {
			masIcd.setIcdCode(code);
			masIcd.setIcdName(name);

			if (icdSubCategoryId != 0) {
				MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
				masIcdSubCategory.setId(icdSubCategoryId);
				masIcd.setIcdSubCategory(masIcdSubCategory);
			}
			if (icdCauseId != 0) {
				MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
				masIcdcausegrp.setId(icdCauseId);
				//commented for maven
				/*masIcd.setIcdCause(masIcdcausegrp);*/
			}
			if(phAlert.equalsIgnoreCase("y")){
				masIcd.setPhAlert("y");
				if(!alertType.equals("")){
					masIcd.setAlertType(alertType);
				}
			}else{
				masIcd.setPhAlert("n");
			}

			masIcd.setStatus("y");
			//commented for maven
			/*masIcd.setLastChgBy(changedBy);*/
			masIcd.setLastChgDate(currentDate);
			masIcd.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcd(masIcd);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((icdCodeList.size() != 0 || icdCodeList != null)
				|| (icdNameList.size() != 0) || icdNameList != null) {

			if ((icdCodeList.size() != 0 || icdCodeList != null)
					&& (icdNameList.size() == 0 || icdNameList == null)) {

				message = "ICD Code  already exists.";
			} else if ((icdNameList.size() != 0 || icdNameList != null)
					&& (icdCodeList.size() == 0 || icdCodeList == null)) {

				message = "ICD Name  already exists.";
			} else if ((icdCodeList.size() != 0 || icdCodeList != null)
					&& (icdNameList.size() != 0 || icdNameList != null)) {

				message = "ICD Code and ICD Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "add Icd";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIcd(HttpServletRequest request,
			HttpServletResponse response) throws

	ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdCode = null;
		String icdName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdName = request.getParameter(SEARCH_NAME);
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
			icdCode = searchField;
			icdName = null;

		} else {
			icdCode = null;
			icdName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcd(icdCode, icdName);
		jsp = ICD_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdCode", icdCode);
		map.put("icdName", icdName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdCode = "";
		String icdName = "";
		int icdSubCategoryId = 0;
		int icdId = 0;
		int icdCauseId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String phAlert= "";
		String alertType = "";

		if (!request.getParameter(ICD_SUB_CATEGORY_ID).equals("0")) {
			icdSubCategoryId = Integer.parseInt(request
					.getParameter(ICD_SUB_CATEGORY_ID));
		}
		if (!request.getParameter(ICD_CAUSE_GROUP_ID).equals("0")) {
			icdCauseId = Integer.parseInt(request
					.getParameter(ICD_CAUSE_GROUP_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdCode = request.getParameter(CODE);
		}
		
		if (request.getParameter("alertToStaff") != null) {
			phAlert = request.getParameter("alertToStaff");
		}
		System.out.println("phAlert=="+phAlert);
		
		if (request.getParameter("alertType") != null) {
			alertType = request.getParameter("alertType");
		}
		System.out.println("alertType=="+alertType);
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		if (request.getParameter("notifiableDisease") != null) {
			String notifiableDisease = request.getParameter("notifiableDisease");System.out.println("notifiableDisease  "+notifiableDisease);
			generalMap.put("notifiableDisease", "y");
		}
		if (request.getParameter("pregister") != null) {
			String pregister = request.getParameter("pregister");System.out.println("pregister  "+pregister);
			generalMap.put("pregister", "y");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", icdId);
		generalMap.put("icdCode", icdCode);
		generalMap.put("phAlert", phAlert);
		generalMap.put("alertType", alertType);
		generalMap.put("name", icdName);
		generalMap.put("icdSubCategoryId", icdSubCategoryId);
		generalMap.put("icdCauseId", icdCauseId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "edit Icd";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteIcd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int icdId = 0;
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
			icdId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcd(icdId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_JSP;
		title = "delete Icd";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------------------- Icd SubCategory
	// ---------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showIcdSubCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchIcdSubCategoryList = (ArrayList) map
				.get("searchIcdSubCategoryList");
		jsp = ICD_SUB_CATEGORY_JSP;
		jsp += ".jsp";
		title = "ICD SubCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
		int icdMainCategoryId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int changedBy = (Integer) session.getAttribute("userId");
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ICD_MAIN_CATEGORY_ID) != null) {
			icdMainCategoryId = Integer.valueOf(request
					.getParameter(ICD_MAIN_CATEGORY_ID));
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

		List icdSubCategoryCodeList = new ArrayList();
		List icdSubCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			icdSubCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			icdSubCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((icdSubCategoryCodeList.size() == 0 || icdSubCategoryCodeList == null)
				&& (icdSubCategoryNameList.size() == 0 || icdSubCategoryNameList == null)) {
			masIcdSubCategory.setIcdSubCategoryCode(code);
			masIcdSubCategory.setIcdSubCategoryName(name);
			MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
			masIcdMainCategory.setId(icdMainCategoryId);
			masIcdSubCategory.setIcdMaincategory(masIcdMainCategory);

			masIcdSubCategory.setStatus("y");
			Users users=new Users();
			users.setId(changedBy);
			masIcdSubCategory.setLastChgBy(users);
			masIcdSubCategory.setLastChgDate(currentDate);
			masIcdSubCategory.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdSubCategory(masIcdSubCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
				|| (icdSubCategoryNameList.size() != 0)
				|| icdSubCategoryNameList != null) {

			if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
					&& (icdSubCategoryNameList.size() == 0 || icdSubCategoryNameList == null)) {

				message = "ICD SubCategory Code  already exists.";
			} else if ((icdSubCategoryNameList.size() != 0 || icdSubCategoryNameList != null)
					&& (icdSubCategoryCodeList.size() == 0 || icdSubCategoryCodeList == null)) {

				message = "ICD SubCategory Name  already exists.";
			} else if ((icdSubCategoryCodeList.size() != 0 || icdSubCategoryCodeList != null)
					&& (icdSubCategoryNameList.size() != 0 || icdSubCategoryNameList != null)) {

				message = "ICD SubCategory Code and ICD SubCategory Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "add IcdSubCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdSubCategoryCode = null;
		String icdSubCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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
			icdSubCategoryCode = searchField;
			icdSubCategoryName = null;
		} else {
			icdSubCategoryCode = null;
			icdSubCategoryName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				icdSubCategoryCode, icdSubCategoryName);
		jsp = ICD_SUB_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("icdSubCategoryCode", icdSubCategoryCode);
		map.put("icdSubCategoryName", icdSubCategoryName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String icdSubCategoryCode = "";
		String icdSubCategoryName = "";
		int icdMainCategoryId = 0;
		int icdSubCategoryId = 0;
		Date changedDate = null;
		String changedTime = "";
		int changedBy = (Integer) session.getAttribute("userId");
		if (request.getParameter(ICD_MAIN_CATEGORY_ID) != null
				&& !(request.getParameter(ICD_MAIN_CATEGORY_ID).equals(""))) {
			icdMainCategoryId = Integer.parseInt(request
					.getParameter(ICD_MAIN_CATEGORY_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdSubCategoryId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", icdSubCategoryId);
		generalMap.put("icdSubCategoryCode", icdSubCategoryCode);
		generalMap.put("name", icdSubCategoryName);
		generalMap.put("icdMainCategoryId", icdMainCategoryId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingIcdSubCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingIcdSubCategoryNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdSubCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingIcdSubCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "edit IcdSubCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteIcdSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int icdSubCategoryId = 0;
		String message = null;
		int changedBy = (Integer) session.getAttribute("userId");
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			icdSubCategoryId = Integer
					.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcdSubCategory(
				icdSubCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdSubCategoryJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdSubCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_SUB_CATEGORY_JSP;
		title = "delete IcdSubCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------- Service Type -------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showServiceTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchServiceTypeList = (ArrayList) map
				.get("searchServiceTypeList");
		jsp = SERVICE_TYPE_JSP;
		jsp += ".jsp";
		title = "ServiceType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchServiceType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceTypeCode = null;
		String serviceTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
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
			serviceTypeCode = searchField;
			serviceTypeName = null;
		} else {
			serviceTypeCode = null;
			serviceTypeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchServiceType(
				serviceTypeCode, serviceTypeName);

		jsp = SERVICE_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("serviceTypeCode", serviceTypeCode);
		map.put("serviceTypeName", serviceTypeName);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addServiceType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasServiceType masServiceType = new MasServiceType();
		String changedBy = "";
		String shortDescription = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SHORT_DESCRIPTION) != null) {
			shortDescription = request.getParameter(SHORT_DESCRIPTION);
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

		List serviceTypeCodeList = new ArrayList();
		List serviceTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			serviceTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			serviceTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((serviceTypeCodeList.size() == 0 || serviceTypeCodeList == null)
				&& (serviceTypeNameList.size() == 0 || serviceTypeNameList == null)) {
			masServiceType.setServiceTypeCode(code);
			masServiceType.setServiceTypeName(name);
			masServiceType.setServiceNameShortDesc(shortDescription);
			masServiceType.setStatus("y");
			masServiceType.setLastChgBy(changedBy);
			masServiceType.setLastChgDate(currentDate);
			masServiceType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addServiceType(masServiceType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
				|| (serviceTypeNameList.size() != 0)
				|| serviceTypeNameList != null) {

			if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
					&& serviceTypeNameList.size() == 0
					|| serviceTypeNameList == null) {
				message = "ServiceType Code  already exists.";
			} else if ((serviceTypeNameList.size() != 0 || serviceTypeNameList != null)
					&& (serviceTypeCodeList.size() == 0 || serviceTypeCodeList == null)) {
				message = "ServiceType Name already exists.";
			} else if ((serviceTypeCodeList.size() != 0 || serviceTypeCodeList != null)
					&& (serviceTypeNameList.size() != 0 || serviceTypeNameList != null)) {

				message = "ServiceType Code and ServiceType Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Add Service type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editServiceType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String serviceTypeCode = "";
		String serviceTypeName = "";
		String shortDescription = "";
		int serviceTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SHORT_DESCRIPTION) != null
				&& !(request.getParameter(SHORT_DESCRIPTION).equals(""))) {
			shortDescription = request.getParameter(SHORT_DESCRIPTION);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", serviceTypeId);
		generalMap.put("serviceTypeCode", serviceTypeCode);
		generalMap.put("name", serviceTypeName);
		generalMap.put("shortDescription", shortDescription);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingServiceTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingServiceTypeNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editServiceTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingServiceTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Edit Service Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteServiceType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceTypeId = 0;
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
			serviceTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteServiceType(
				serviceTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showServiceTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showServiceTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SERVICE_TYPE_JSP;
		title = "Delete Service type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// --------------------------- REPORT METHOD For Service Type
	// ------------------------
	public ModelAndView genrateReportForServiceType(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceTypeCode = null;
		String serviceTypeName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "ServiceTypeCode", "ServiceTypeName" };
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			serviceTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SEARCH_NAME);
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
			serviceTypeCode = searchField;
			serviceTypeName = null;

		} else {
			serviceTypeCode = null;
			serviceTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				serviceTypeCode, serviceTypeName);
		searchServiceTypeList = (List<MasServiceType>) map
				.get("searchServiceTypeList");
		if (searchServiceTypeList != null || !searchServiceTypeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchServiceTypeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("servicetype"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}

		return null;
	}

	// --------------------------- REPORT METHOD For Cost Center
	// ------------------------

	public ModelAndView genrateReportForCostCenterCode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String costCenterCode = null;
		String costCenterName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "CostCenterCode", "CostCenterName" };
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			costCenterCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			costCenterName = request.getParameter(SEARCH_NAME);
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
			costCenterCode = searchField;
			costCenterName = null;

		} else {
			costCenterCode = null;
			costCenterName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchCostCenter(
				costCenterCode, costCenterName);
		searchCostCenterList = (List<MasCostCenter>) map
				.get("searchCostCenterList");
		if (searchCostCenterList != null || !searchCostCenterList.isEmpty()) {
			ds = new ReportDataSource(fields, searchCostCenterList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("costcenter"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHODS For Major Category Code
	// ------------------------

	public ModelAndView genrateReportForMajorCategoryCode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String majorCategoryCode = null;
		String majorCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "MajorCategoryCode", "MajorCategoryName" };
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			majorCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			majorCategoryName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			majorCategoryCode = searchField;
			majorCategoryName = null;

		} else {
			majorCategoryCode = null;
			majorCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMajorCategoryCode(
				majorCategoryCode, majorCategoryName);
		searchMajorCategoryCodeList = (List<MasMajorCategoryCode>) map
				.get("searchMajorCategoryCodeList");
		if (searchMajorCategoryCodeList != null
				|| !searchMajorCategoryCodeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchMajorCategoryCodeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("majorcategorycode"), new HashMap(),
						ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHODS Death Cause
	// ------------------------

	public ModelAndView generateReportForDeathCause(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String deathCauseCode = null;
		String deathCauseName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "DeathCauseCode", "DeathCauseName" };
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			deathCauseCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			deathCauseName = request.getParameter(SEARCH_NAME);
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
			deathCauseCode = searchField;
			deathCauseName = null;

		} else {
			deathCauseCode = null;
			deathCauseName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchDeathCause(
				deathCauseCode, deathCauseName);
		searchDeathCauseList = (List<MasDeathCause>) map
				.get("searchDeathCauseList");
		if (searchDeathCauseList != null || !searchDeathCauseList.isEmpty()) {
			ds = new ReportDataSource(fields, searchDeathCauseList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("deathcause"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Patient Status
	// ------------------------

	public ModelAndView generateReportForPatientStatus(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatusCode = null;
		String patientStatusName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "PatientStatusCode", "PatientStatusName" };
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientStatusCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientStatusName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			patientStatusCode = searchField;
			patientStatusName = null;

		} else {
			patientStatusCode = null;
			patientStatusName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchPatientStatus(
				patientStatusCode, patientStatusName);
		searchPatientStatusList = (List<MasPatientStatus>) map
				.get("searchPatientStatusList");
		if (searchPatientStatusList != null
				|| !searchPatientStatusList.isEmpty()) {
			ds = new ReportDataSource(fields, searchPatientStatusList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("patientstatus"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Main Charge Code
	// ------------------------

	public ModelAndView genrateReportForMainChargecode(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String mainChargecodeCode = null;
		String mainChargecodeName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "mainChargecodeCode", "mainChargecodeName" };
		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			mainChargecodeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			mainChargecodeName = request.getParameter(SEARCH_NAME);
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
			mainChargecodeCode = searchField;
			mainChargecodeName = null;

		} else {
			mainChargecodeCode = null;
			mainChargecodeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchMainChargecode(
				mainChargecodeCode, mainChargecodeName);
		searchMainChargecodeList = (List<MasMainChargecode>) map
				.get("searchMainChargecodeList");
		if (searchMainChargecodeList != null
				|| !searchMainChargecodeList.isEmpty()) {
			ds = new ReportDataSource(fields, searchMainChargecodeList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(getCompiledReport("main_chargecode"),
								new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHOD For Complaint
	// ------------------------

	public ModelAndView generateReportForComplaint(HttpServletRequest request,
			HttpServletResponse resp) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintCode = null;
		String complaintName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "ComplaintCode", "ComplaintName" };
		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio

				= Integer.parseInt(request.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			complaintCode = searchField;
			complaintName = null;

		} else {
			complaintCode = null;
			complaintName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchComplaint(
				complaintCode, complaintName);
		searchComplaintList = (List<MasComplaint>) map
				.get("searchComplaintList");
		if (searchComplaintList != null || !searchComplaintList.isEmpty()) {
			ds = new ReportDataSource(fields, searchComplaintList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("complaint"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	// --------------------------- REPORT METHOD For ICD Main Category Code
	// ------------------------

	public ModelAndView genrateReportForICDMainCategory(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdMainCategoryCode = null;
		String icdMainCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "IcdMaincategoryCode", "IcdMaincategoryCode" };
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdMainCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdMainCategoryName = request.getParameter(SEARCH_NAME);
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
			icdMainCategoryCode = searchField;
			icdMainCategoryName = null;

		} else {
			icdMainCategoryCode = null;
			icdMainCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdMainCategory(
				icdMainCategoryCode, icdMainCategoryName);
		searchIcdMainCategoryList = (List<MasIcdMainCategory>) map
				.get("searchIcdMainCategoryList");
		if (searchIcdMainCategoryList != null
				|| !searchIcdMainCategoryList.isEmpty()) {
			ds = new ReportDataSource(fields, searchIcdMainCategoryList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(getCompiledReport("IcdMainCategory"),
								new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// --------------------------- REPORT METHODS For ICD Sub Category
	// ------------------------

	public ModelAndView genrateReportForICDSubCategory(
			HttpServletRequest request, HttpServletResponse resp)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String icdSubCategoryCode = null;
		String icdSubCategoryName = null;
		String searchField = null;
		JRDataSource ds = null;
		String[] fields = { "IcdSubcategoryCode", "IcdSubcategoryCode" };
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			icdSubCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			icdSubCategoryName = request.getParameter(SEARCH_NAME);
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
			icdSubCategoryCode = searchField;
			icdSubCategoryName = null;

		} else {
			icdSubCategoryCode = null;
			icdSubCategoryName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdSubCategory(
				icdSubCategoryCode, icdSubCategoryName);
		searchIcdSubCategoryList = (List<MasIcdSubCategory>) map
				.get("searchIcdSubCategoryList");
		if (searchIcdSubCategoryList != null
				|| !searchIcdSubCategoryList.isEmpty()) {
			ds = new ReportDataSource(fields, searchIcdSubCategoryList);
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("IcdSubCategory"), new HashMap(), ds);
			} catch (JRException e) {

				e.printStackTrace();
			}
			resp.setContentType("application/pdf");
			resp.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = resp.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}

		return null;
	}

	// -------------------------------------------------------------------------------------------------

	public ModelAndView generateReportForHospitalRelatedMasters(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int group = 0;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if (request.getParameter("group") != null) {
			group = Integer.parseInt(request.getParameter("group").toString());
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int hospitalId = 0;
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		hospitalId = Integer.parseInt(request.getSession()
				.getAttribute(HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap = hospitalDetailsMasterHandlerService
				.getSetupParameterMap(dataMap);
		parameters = hospitalDetailsMasterHandlerService.getConnection();
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			if(masSetupParameterMaintainceList.get(0).getHospital()!=null){
				parameters.put("hospitalName",
						masSetupParameterMaintainceList.get(0).getHospital()
								.getHospitalName());
				parameters.put("hospitalAddress", masSetupParameterMaintainceList
						.get(0).getHospital().getAddress());
			}
			
		}
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		parameters.put("group", group);
		HMSUtil.generateReport("Mas_vendor_list", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// /-----------------------------for rank
	// report--------------------------------//

	public ModelAndView generateReportForHospitalRelatedMastersforrank(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int group = 0;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		if (request.getParameter("group") != null) {
			group = Integer.parseInt(request.getParameter("group").toString());
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		parameters = hospitalDetailsMasterHandlerService.getConnection();

		int hospitalId = 0;
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		hospitalId = Integer.parseInt(request.getSession()
				.getAttribute(HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		dataMap = hospitalDetailsMasterHandlerService
				.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			parameters.put("hospitalName",
					masSetupParameterMaintainceList.get(0).getHospital()
							.getHospitalName());
			parameters.put("hospitalAddress", masSetupParameterMaintainceList
					.get(0).getHospital().getAddress());
		}
		HMSUtil.generateReport("Mas_Rank", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------Patient
	// Type----------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);

		map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		jsp = PATIENT_TYPE_JSP;
		jsp += ".jsp";
		title = "Patient Type";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String patientTypeCode = null;
		String patientTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientTypeName = request.getParameter(SEARCH_NAME);
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
			patientTypeCode = searchField;
			patientTypeName = null;
		} else {
			patientTypeCode = null;
			patientTypeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchPatientType(
				patientTypeCode, patientTypeName);

		jsp = PATIENT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientTypeCode", patientTypeCode);
		map.put("patientTypeName", patientTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPatientType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPatientType masPatientType = new MasPatientType();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int validityDays = 0;
		String categoryTypeName="";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
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
		if (request.getParameter(VALIDITY_DAYS) != null) {
			validityDays = Integer
					.parseInt(request.getParameter(VALIDITY_DAYS));
			
			System.out.println("pojoPropertyCode>>>>>>>>>"+validityDays);
		}
		if (request.getParameter("categoryTypeName") != null) {
			categoryTypeName = request.getParameter("categoryTypeName");
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

		List patientTypeCodeList = new ArrayList();
		List patientTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			patientTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			patientTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((patientTypeCodeList.size() == 0 || patientTypeCodeList == null)
				&& (patientTypeNameList.size() == 0 || patientTypeNameList == null)) {
			masPatientType.setPatientTypeCode(code);
			masPatientType.setPatientTypeName(name);
			if (request.getParameter("dischargeWithoutSettlement") != null) {
				masPatientType.setDischargeWithoutSettlement("y");
			} else {
				masPatientType.setDischargeWithoutSettlement("n");
			}
			masPatientType.setStatus("y");
			
			Users user = new Users();
			user.setId(userId);
			masPatientType.setLastChgBy(user);
			
			
			masPatientType.setLastChgDate(currentDate);
			masPatientType.setLastChgTime(currentTime);
			masPatientType.setValidity(validityDays);
			masPatientType.setType(categoryTypeName);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addPatientType(masPatientType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";

			} else {
				message = "Try Again !!";

			}
		}

		else if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
				|| (patientTypeNameList.size() != 0)
				|| patientTypeNameList != null) {

			if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
					&& (patientTypeNameList.size() == 0 || patientTypeNameList == null)) {

				message = "Patient Type Code  already exists.";
			} else if ((patientTypeNameList.size() != 0 || patientTypeNameList != null)
					&& (patientTypeCodeList.size() == 0 || patientTypeCodeList == null)) {

				message = "Patient Type Name already exists.";
			} else if ((patientTypeCodeList.size() != 0 || patientTypeCodeList != null)
					&& (patientTypeNameList.size() != 0 || patientTypeNameList != null)) {

				message = "Patient Type Code and Patient Type Name already exist.";
			}
		}

		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "Add Patient Type";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editPatientType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String patientTypeCode = "";
		String patientTypeName = "";
		int patientTypeId = 0;
		Date changedDate = null;
		String changedTime = "";
		String dischargeFlag = "";
		int validityDays = 0;
		String categoryTypeName="";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			patientTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			patientTypeName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("categoryTypeName") != null) {
			categoryTypeName = request.getParameter("categoryTypeName");
			System.out.println("categoryTypeName "+categoryTypeName);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(VALIDITY_DAYS) != null) {
			validityDays = Integer
					.parseInt(request.getParameter(VALIDITY_DAYS));
		}

		if (request.getParameter("dischargeWithoutSettlement") != null) {
			dischargeFlag = "y";
		} else {
			dischargeFlag = "n";
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", patientTypeId);
		generalMap.put("patientTypeCode", patientTypeCode);
		generalMap.put("name", patientTypeName);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("dischargeFlag", dischargeFlag);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("validityDays", validityDays);
		generalMap.put("categoryTypeName", categoryTypeName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingPatientTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingPatientTypeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editPatientTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingPatientTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "update PatientType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deletePatientType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int patientTypeId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			patientTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deletePatientType(
				patientTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showPatientTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showPatientTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PATIENT_TYPE_JSP;
		title = "delete PatientType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// --------------------------------------------IcdCausegrp
	// -----------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showIcdCauseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		jsp = ICD_CAUSE_GROUP_JSP;
		jsp += ".jsp";
		title = "icdCausegrp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchIcdCause(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String causeCode = null;
		String causeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			causeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			causeName = request.getParameter(SEARCH_NAME);
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
			causeCode = searchField;
			causeName = null;

		} else {
			causeCode = null;
			causeName = searchField;
		}

		map = hospitalDetailsMasterHandlerService.searchIcdCause(causeCode,
				causeName);
		jsp = ICD_CAUSE_GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("causeCode", causeCode);
		map.put("causeName", causeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
		int userId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

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
		List causeCodeList = new ArrayList();
		List causeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			causeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			causeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((causeCodeList.size() == 0 || causeCodeList == null)
				&& (causeNameList.size() == 0 || causeNameList == null)) {
			masIcdcausegrp.setIcdCauseCode(code);
			masIcdcausegrp.setIcdCauseName(name);
			masIcdcausegrp.setStatus("y");
			
			Users user = new Users();
			user.setId(userId);
			masIcdcausegrp.setLastChgBy(user);
			
			masIcdcausegrp.setLastChgDate(currentDate);
			masIcdcausegrp.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addIcdCause(masIcdcausegrp);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((causeCodeList.size() != 0 || causeCodeList != null)
				|| (causeNameList.size() != 0) || causeNameList != null) {
			if ((causeCodeList.size() != 0 || causeCodeList != null)
					&& (causeNameList.size() == 0 || causeNameList == null)) {
				message = "Cause Code  already exists.";
			} else if ((causeNameList.size() != 0 || causeNameList != null)
					&& (causeCodeList.size() == 0 || causeCodeList == null)) {
				message = "Cause Name already exists.";
			} else if ((causeCodeList.size() != 0 || causeCodeList != null)
					&& (causeNameList.size() != 0 || causeNameList != null)) {
				message = "Cause Code and Death Cause Name already exist.";
			}

		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Add icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String causeCode = "";
		String causeName = "";
		int causeId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		int userId=0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			causeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			causeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			causeName = request.getParameter(SEARCH_NAME);
		}
	/*	if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
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
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", causeId);
		generalMap.put("causeCode", causeCode);
		generalMap.put("name", causeName);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCauseNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCauseNameList.size() == 0) {

			dataUpdated = hospitalDetailsMasterHandlerService
					.editIcdCauseToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCauseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Update icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteIcdCause(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int causeId = 0;
		String message = null;
		
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=0;
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			causeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteIcdCause(
				causeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/hospital?method=showIcdCauseJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showIcdCauseJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ICD_CAUSE_GROUP_JSP;
		title = "Delete icdCausegrp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String noticeCode = null;
		String noticeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			noticeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			noticeName = request.getParameter(SEARCH_NAME);
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
			noticeCode = searchField;
			noticeName = null;

		} else {
			noticeCode = null;
			noticeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchNotice(noticeCode,
				noticeName);

		jsp = RequestConstants.NOTICE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("noticeCode", noticeCode);
		map.put("noticeName", noticeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showNoticeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showNoticeJsp();
		@SuppressWarnings("unused")
		ArrayList searchNoticeList = (ArrayList) map.get("searchNoticeList");
		jsp = RequestConstants.NOTICE_JSP;
		jsp += ".jsp";
		title = "notice";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addNotice(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HmsNoticeBoard hmsNoticeBoard = new HmsNoticeBoard();

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

		List noticeCodeList = new ArrayList();
		List noticeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			noticeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			noticeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((noticeCodeList.size() == 0 || noticeCodeList == null)
				&& (noticeNameList.size() == 0 || noticeNameList == null)) {
			hmsNoticeBoard.setNoticeCode(code);
			hmsNoticeBoard.setDesc(name);
			hmsNoticeBoard.setStatus("y");
			hmsNoticeBoard.setLastChangedBy(changedBy);
			hmsNoticeBoard.setLastChangedDate(currentDate);
			hmsNoticeBoard.setLastChangedTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addNotice(hmsNoticeBoard);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((noticeCodeList.size() != 0 || noticeCodeList != null)
				|| (noticeNameList.size() != 0) || noticeNameList != null) {

			if ((noticeCodeList.size() != 0 || noticeCodeList != null)
					&& (noticeNameList.size() == 0 || noticeNameList == null)) {
				message = "Notice Code  already exists.";
			} else if ((noticeNameList.size() != 0 || noticeNameList != null)
					&& (noticeCodeList.size() == 0 || noticeCodeList == null)) {
				message = "Notice Description already exists.";
			} else if ((noticeCodeList.size() != 0 || noticeCodeList != null)
					&& (noticeNameList.size() != 0 || noticeNameList != null)) {
				message = "Notice Code and Currency Name already exist.";
			}
		}
		url = "/hms/hms/hospital?method=showNoticeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showNoticeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.NOTICE_JSP;
		title = "Add Notice";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editNotice(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String noticeCode = "";
		String noticeName = "";
		int noticeId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			noticeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			noticeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			noticeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		generalMap.put("id", noticeId);
		generalMap.put("currencyCode", noticeCode);
		generalMap.put("name", noticeName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCurrencyNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCurrencyNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editNoticeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCurrencyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showNoticeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showNoticeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.NOTICE_JSP;
		title = "Update Notice";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteNotice(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int noticeId = 0;
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
			noticeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteNotice(
				noticeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showNoticeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showNoticeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.NOTICE_JSP;
		title = "Delete Notice";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------- Hospital Type Master by Mansi

	@SuppressWarnings("unchecked")
	public ModelAndView showHospitalTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = hospitalDetailsMasterHandlerService.showHospitalTypeJsp();
		String jsp = "hospitalType";
		jsp += ".jsp";
		title = "HospitalType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addHospitalType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasHospitalType masHospitalType = new MasHospitalType();
		int userId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String description = "";
		HttpSession session = request.getSession();
		session = request.getSession();
		String code = "";
		String name = "";
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

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
		// generalMap.put("hospitalAddress", hospitalAddress);
		// generalMap.put("contactNumber", contactNumber);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List hospitalTypeCodeList = new ArrayList();
		List hospitalTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			hospitalTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			hospitalTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((hospitalTypeCodeList.size() == 0 || hospitalTypeCodeList == null)
				&& (hospitalTypeNameList.size() == 0 || hospitalTypeNameList == null)) {

			System.out.println(code);
			System.out.println(name);

			masHospitalType.setHospitalTypeCode(code);
			masHospitalType.setHospitalTypeName(name);
			masHospitalType.setDescription(description);

			masHospitalType.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masHospitalType.setLastChgBy(users);

			masHospitalType.setLastChgDate(currentDate);
			masHospitalType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addHospitalType(masHospitalType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((hospitalTypeCodeList.size() != 0 || hospitalTypeCodeList != null)
				|| (hospitalTypeNameList.size() != 0)
				|| hospitalTypeNameList != null) {
			if ((hospitalTypeCodeList.size() != 0 || hospitalTypeCodeList != null)
					&& (hospitalTypeNameList.size() == 0 || hospitalTypeNameList == null)) {

				message = "Hospital Type Code  already exists.";
			} else if ((hospitalTypeNameList.size() != 0 || hospitalTypeNameList != null)
					&& (hospitalTypeCodeList.size() == 0 || hospitalTypeCodeList == null)) {

				message = "Hospital Type Name already exists.";
			} else if ((hospitalTypeCodeList.size() != 0 || hospitalTypeCodeList != null)
					&& (hospitalTypeNameList.size() != 0 || hospitalTypeNameList != null)) {

				message = "Hospital Type Code and Hospital Type Name already exist.";
			}
		}

		try {
			map = hospitalDetailsMasterHandlerService.showHospitalTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospitalType";
		title = "Add HospitalType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editHospitalType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String hospitalTypeCode = "";
		String hospitalTypeName = "";
		int userGroupsId = 0;
		String description = "";
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			userGroupsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
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

		generalMap.put("id", userGroupsId);
		generalMap.put("hospitalTypeCode", hospitalTypeCode);
		generalMap.put("name", hospitalTypeName);
		generalMap.put("description", description);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHospitalTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHospitalTypeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editHospitalTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHospitalTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showHospitalTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showHospitalTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospitalType";
		title = "update HospitalType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteHospitalType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int hospitalTypeId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		session = request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			hospitalTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = hospitalDetailsMasterHandlerService.deleteHospitalType(
				hospitalTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showHospitalTypeJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showHospitalTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "hospitalType";
		title = "delete HospitalType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchHospitalType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String hospitalTypeCode = null;
		String hospitalTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			hospitalTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			hospitalTypeName = request.getParameter(SEARCH_NAME);
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
			hospitalTypeCode = searchField;
			hospitalTypeName = null;

		} else {
			hospitalTypeCode = null;
			hospitalTypeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchHospitalType(
				hospitalTypeCode, hospitalTypeName);

		jsp = "hospitalType";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalTypeCode", hospitalTypeCode);
		map.put("hospitalTypeName", hospitalTypeName);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	// -----------------------------RoomType-------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRoomTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) hospitalDetailsMasterHandlerService.showRoomType();
		String jsp = "roomType";
		jsp += ".jsp";
		title = "roomType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRoomType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRoomType masRoomType = new MasRoomType();
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
		List roomTypeCodeList = new ArrayList();
		List roomTypeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			roomTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			roomTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((roomTypeCodeList.size() == 0 || roomTypeCodeList == null)
				&& (roomTypeNameList.size() == 0 || roomTypeNameList == null)) {
			masRoomType.setRoomTypeCode(code);
			masRoomType.setRoomTypeName(name);

			Users users = new Users();
			users.setId(userId);
			masRoomType.setLastChgBy(users);

			masRoomType.setStatus("Y");
			masRoomType.setLastChgDate(currentDate);
			masRoomType.setLastChgTime(currentTime);
			successfullyAdded = hospitalDetailsMasterHandlerService.addRoomType(masRoomType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((roomTypeCodeList.size() != 0 || roomTypeCodeList != null)
				|| (roomTypeNameList.size() != 0) || roomTypeNameList != null) {
			if ((roomTypeCodeList.size() != 0 || roomTypeCodeList != null)
					&& (roomTypeNameList.size() == 0 || roomTypeNameList == null)) {
				message = "RoomType Code already exists.";
			} else if ((roomTypeNameList.size() != 0 || roomTypeNameList != null)
					&& (roomTypeCodeList.size() == 0 || roomTypeCodeList == null)) {
				message = "RoomType Name already exists.";
			} else if ((roomTypeCodeList.size() != 0 || roomTypeCodeList != null)
					&& (roomTypeCodeList.size() != 0 || roomTypeNameList != null)) {
				message = "RoomType Code and Name exist.";
			}
		}
		try {
			map = hospitalDetailsMasterHandlerService.showRoomType();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "roomType";
		title = " Add roomType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editRoomType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String roomTypeCode = "";
		String roomTypeName = "";
		int roomTypeId = 0;
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
				roomTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

	
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				roomTypeCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				roomTypeName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", roomTypeId);
			generalMap.put("roomTypeCode", roomTypeCode);
			generalMap.put("name", roomTypeName);
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
			List existingRoomTypeNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingRoomTypeNameList.size() == 0) {
				dataUpdated = hospitalDetailsMasterHandlerService.editRoomType(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingRoomTypeNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = hospitalDetailsMasterHandlerService.showRoomType();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "roomType";
		title = " Edit Room Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchRoomType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String roomTypeCode = null;
		String roomTypeName = null;
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
			roomTypeCode = searchField;
			roomTypeName = null;

		} else {
			roomTypeCode = null;
			roomTypeName = searchField;
		}

		//

		map = hospitalDetailsMasterHandlerService.searchRoomType(roomTypeCode,
				roomTypeName);

		jsp = "roomType";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("roomTypeCode", roomTypeCode);
		map.put("roomTypeName", roomTypeName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteRoomType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int roomTypeId = 0;
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
			roomTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteRoomType(roomTypeId,generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospitalDetailsMaster?method=showRoomTypeJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showRoomType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "roomType";
		title = "delete Room Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showHospitalUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId",hospitalId);
		}

		map = hospitalDetailsMasterHandlerService.showHospitalUnitJsp(box);
		String jsp = "hospital_unit" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getEmpDepartmentSearch(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId",hospitalId);
		}
		int empDepSearchId=0;
	
		if (request.getParameter("empDepSearchId") != null
				&& !(request.getParameter("empDepSearchId").equals("0"))) {
			empDepSearchId = Integer.parseInt(request.getParameter("empDepSearchId"));
		}
		box.put("empDepSearchId",empDepSearchId);
		map = hospitalDetailsMasterHandlerService.getEmpDepartmentSearch(box);
		
		jsp = "responseEmpDepartmentSearch";

		
		return new ModelAndView(jsp, "map", map);

	}
	@SuppressWarnings("unchecked")
	public ModelAndView showDataFromSearch(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		int unitCodeId=0;
		Box box = HMSUtil.getBox(request);

		if (request.getParameter("unitCodeId") != null
				&& !(request.getParameter("unitCodeId").equals("0"))) {
			unitCodeId = Integer.parseInt(request.getParameter("unitCodeId"));
			box.put("unitCodeId",unitCodeId);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId",hospitalId);
		}
		
		map = hospitalDetailsMasterHandlerService.showDataFromSearch(box);
		
		jsp = "responseDataFromSearch";

		
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView getRankDesignation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String flag = "";
		int val = 0;
		int counter = 0;
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(session.getAttribute(HOSPITAL_ID).toString());
			dataMap.put(HOSPITAL_ID, hospitalId);
		}
		
		
		if (request.getParameter("val") != null) {
			val = Integer.parseInt(request.getParameter("val"));
			dataMap.put("val", val);
		}
		
		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
			dataMap.put("counter", counter);
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			dataMap.put("flag", flag);
		}
		
		map = hospitalDetailsMasterHandlerService.getRankDesignation(dataMap);
		jsp = "responseForRankDesignation";
		map.put("counter", counter);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	

	public ModelAndView submitHospitalUnit(HttpServletRequest request,
			HttpServletResponse response) {
		String unitDays = "";
		if(request.getParameterValues("unitradio")!=null){
			unitDays=StringUtils.join(request.getParameterValues("unitradio"), ',');
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		
		box.put("unitradio", unitDays);
	
		map = hospitalDetailsMasterHandlerService.submitHospitalUnit(box);
		
		String message = "";
	   if(map.containsKey("codeExisted")&&map.get("codeExisted")!=null){
		   message="This Unit Already Existed For "+map.get("codeExisted")+" !";
		   map.put("message",message);
		   System.out.println("Code Already There !");
		   
	   }

		boolean saved = false;
		//String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
	
		if (saved) {
			message = "Record Saved Successfully";
					
		} 
		/*else {
			message = "Try Again!";
		}*/
		
		map.put("message", message);
		String url = "/hms/hms/hospital?method=showHospitalUnitJsp";
		map.put("url", url);
		String jsp = "hosp_unit_message" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	// -------------------------------------------------BED
	// MASTER-----------------------------------------------------

	public ModelAndView showOtJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = hospitalDetailsMasterHandlerService.showOtJsp();
		jsp = "otTable";
		jsp += ".jsp";
		title = "Ot";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOt(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bedNumber = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}

		map = hospitalDetailsMasterHandlerService.searchOt(bedNumber);
		jsp = "otTable";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bedNumber", bedNumber);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOt(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int departmentId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		Date introductionDate = null;
		Date discardDate = null;
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		int hospitalid=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
	
		if (request.getParameter(BED_STATUS_ID) != null) {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}
		if (request.getParameter(ATTACHED) != null) {
			masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			masBed.setAttached("n");
		}
		/*
		 * if (request.getParameter(CHANGED_BY) != null) { changedBy =
		 * request.getParameter(CHANGED_BY); }
		 */
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
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
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("name", bedNumber);
		generalMap.put("code", departmentId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("hospitalid", hospitalid); // added by amit das on 27-09-2016
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = hospitalDetailsMasterHandlerService
				.checkForExistingMastersForHospital(generalMap);
		List bedNumberList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bedNumberList = (List) listMap.get("duplicateGeneralCodeList");
		}

		boolean successfullyAdded = false;
		if (bedNumberList.size() == 0) {
			masBed.setBedNo(bedNumber);

			MasDepartment departmentObj = new MasDepartment();
			departmentObj.setId(departmentId);
			masBed.setDepartment(departmentObj);


			MasBedStatus bedStatusObj = new MasBedStatus();
			bedStatusObj.setId(bedStatusId);
			masBed.setBedStatus(bedStatusObj);

			masBed.setAdNo(adNo);
			masBed.setDietType(dietType);
			masBed.setIntroductionDate(introductionDate);
			masBed.setDiscardDate(discardDate);
			masBed.setStatus("y");
			masBed.setBedType("P");
			masBed.setFlag("OT");
			
			Users users=new Users();
			users.setId(userId);
			masBed.setLastChgBy(users);
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalid);
			masBed.setHospital(hospital);
			masBed.setLastChgDate(changedDate);
			masBed.setLastChgTime(changedTime);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addBed(masBed);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (bedNumberList.size() != 0) {
			message = "Same Table Number for selected Ward already exists.";
		}
		try {
			map = hospitalDetailsMasterHandlerService.showOtJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "otTable";
		title = "Add Ot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasBed masBed = new MasBed();
		String bedNumber = "";
		int bedId = 0;
		int departmentId = 0;
		int bedStatusId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		Date introductionDate = null;
		Date discardDate = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = new Date();
		String code = "";
		String name = "";
		String jspName = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		session = request.getSession(true);
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bedNumber = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != "") {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(BED_STATUS_ID) != "") {
			bedStatusId = Integer.parseInt(request.getParameter(BED_STATUS_ID));
		}
	
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(DIET_TYPE) != null) {
			dietType = request.getParameter(DIET_TYPE);
		}

		if (request.getParameter(ATTACHED) != null) {
			masBed.setAttached(request.getParameter(ATTACHED));
		} else {
			masBed.setAttached("n");
		}

		if (request.getParameter(INTRODUCTION_DATE) != null) {
			introductionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(INTRODUCTION_DATE));
		}
		if (request.getParameter(DISCARD_DATE) != null) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
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
		generalMap.put("id", bedId);
		generalMap.put("bedNumber", bedNumber);
		generalMap.put("departmentId", departmentId);
		generalMap.put("bedStatusId", bedStatusId);
		generalMap.put("adNo", adNo);
		generalMap.put("dietType", dietType);
		generalMap.put("attached", attached);
		generalMap.put("introductionDate", introductionDate);
		generalMap.put("discardDate", discardDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataUpdated = false;
		dataUpdated = hospitalDetailsMasterHandlerService.editOtToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/hospital?method=showOtJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showOtJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "otTable";
		title = "Add Ot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteOt(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		int bedId = 0;
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
			bedId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteOt(bedId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hospital?method=showOtJsp";
		try {
			map = hospitalDetailsMasterHandlerService.showOtJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "otTable";
		title = "delete Ot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	//local charge code search---
	
	@SuppressWarnings("deprecation")
	public ModelAndView searchLocalChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeCodeCode = null;
		String chargeCodeName = null;
		
		HttpSession session=request.getSession();
		
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		

		String searchField = null;

		/*if (request.getParameter(CHARGE_CODE_CODE) != null
				&& !(request.getParameter(CHARGE_CODE_CODE).equals(""))) {
			chargeCodeCode = request.getParameter(CHARGE_CODE_CODE);
		}

		if (request.getParameter(CHARGE_CODE_NAME) != null
				&& !(request.getParameter(CHARGE_CODE_NAME).equals(""))) {
			chargeCodeName = request.getParameter(CHARGE_CODE_NAME);
		}*/
	
		Integer mas_main_charge_id = 0;
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !(request.getParameter(MAIN_CHARGECODE_ID).equals(""))) {
			mas_main_charge_id = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
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
			chargeCodeCode = searchField;
			chargeCodeName = null;

		} else {
			chargeCodeCode = null;
			chargeCodeName = searchField;
		}
		System.out.println("in controller"+chargeCodeName+"----"+chargeCodeName);
		map = hospitalDetailsMasterHandlerService.searchLocalChargeCode(
				chargeCodeCode, chargeCodeName, mas_main_charge_id,hospitalId);

		jsp = "localChargeCode";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chargeCodeCode", chargeCodeCode);
		map.put("chargeCodeName", chargeCodeName);
		map.put("mas_main_charge_id", mas_main_charge_id);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}
	//================================edit local charge code master====================
	@SuppressWarnings("unchecked")
	public ModelAndView editLocalChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		generalMap.put(RequestConstants.USER_ID, (Integer)session.getAttribute(RequestConstants.USER_ID));
		generalMap.put(RequestConstants.HOSPITAL_ID, (Integer)session.getAttribute(RequestConstants.HOSPITAL_ID));
		int chargeId = 0;
		int mainChargeId = 0;
		int departmentId = 0;
		int subChargeId = 0;
		int chargeTypeId = 0;
		int accountId = 0;
		int subAccountId = 0;
		float charge = 0;

		String chargeName = "";
		String chargeCode = "";
		String changedBy = "";
		String changedTime = "";
		String editable = "";
		String discountable = "";
		String drAccountRequired = "";
		String opd_related_services = "";
		String proceCode = "";
		String pacsInteg = "";
		String telemediInteg = "";
		Date changedDate = new Date();
		Date effactiveFromDate = new Date();
		Date effactiveToDate = new Date();

		BigDecimal discountPercentage = new BigDecimal(0);
		BigDecimal stdDeductionGen = new BigDecimal(0.00);
		BigDecimal stdDeductionSpl = new BigDecimal(0.00);

		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeId = Integer.parseInt(request.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& !(request.getParameter(MAIN_CHARGECODE_ID).equals(""))) {
			mainChargeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& !(request.getParameter(SUB_CHARGECODE_ID).equals(""))) {
			subChargeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (request.getParameter(CHARGE_TYPE_ID) != null
				&& !(request.getParameter(CHARGE_TYPE_ID).equals(""))) {
			chargeTypeId = Integer.parseInt(request
					.getParameter(CHARGE_TYPE_ID));
		}
		if (request.getParameter(FA_MAS_SUB_LED) != null
				&& !(request.getParameter(FA_MAS_SUB_LED).equals(""))) {
			subAccountId = Integer.parseInt(request
					.getParameter(FA_MAS_SUB_LED));
		}
		if (request.getParameter(FA_ACCOUNT_ID) != null
				&& !(request.getParameter(FA_ACCOUNT_ID).equals(""))) {
			accountId = Integer.parseInt(request.getParameter(FA_ACCOUNT_ID));
		}
		if (request.getParameter(CHARGE_CODE) != null
				&& !(request.getParameter(CHARGE_CODE).equals(""))) {
			chargeCode = request.getParameter(CHARGE_CODE);
		}
		if (request.getParameter(CHARGE_NAME) != null
				&& !(request.getParameter(CHARGE_NAME).equals(""))) {
			chargeName = request.getParameter(CHARGE_NAME);
		}
		if (request.getParameter(CHARGE) != null
				&& !request.getParameter(CHARGE).equals("0")
				&& !request.getParameter(CHARGE).equals("")) {
			charge = Float.parseFloat(request.getParameter(CHARGE));
		}
		if (request.getParameter(EDITABLE) != null
				&& !(request.getParameter(EDITABLE).equals(""))) {
			editable = request.getParameter(EDITABLE);
		} else {
			editable = "n";
		}
		if (request.getParameter(DISCOUNTABLE) != null
				&& !(request.getParameter(DISCOUNTABLE).equals(""))) {
			discountable = request.getParameter(DISCOUNTABLE);
		} else {
			discountable = "n";
		}
		if (request.getParameter(DR_ACC_REQ) != null
				&& !(request.getParameter(DR_ACC_REQ).equals(""))) {
			drAccountRequired = request.getParameter(DR_ACC_REQ);
		} else {
			drAccountRequired = "n";
		}
		if (request.getParameter(OPD_RELATED_SERVICES) != null) {
			opd_related_services = request.getParameter(OPD_RELATED_SERVICES);
		} else {
			opd_related_services = "n";
		}

		if (request.getParameter(DISCOUNT_PERCENTAGE) != null
				&& !request.getParameter(DISCOUNT_PERCENTAGE).equals("")) {
			discountPercentage = new BigDecimal(
					request.getParameter(DISCOUNT_PERCENTAGE));
		}
		if (request.getParameter(STD_DEDUCTION_GEN) != null
				&& !(request.getParameter(STD_DEDUCTION_GEN).equals(""))) {
			stdDeductionGen = new BigDecimal(
					request.getParameter(STD_DEDUCTION_GEN));
		}
		if (request.getParameter(STD_DEDUCTION_SPL) != null
				&& !(request.getParameter(STD_DEDUCTION_SPL).equals(""))) {
			stdDeductionSpl = new BigDecimal(
					request.getParameter(STD_DEDUCTION_SPL));
		}

		if (request.getParameter("proceCode") != null
				&& !(request.getParameter("proceCode").equals(""))) {
			proceCode = (request.getParameter("proceCode"));
		}

		if (request.getParameter("pacsInteg") != null
				&& !(request.getParameter("pacsInteg").equals(""))) {
			pacsInteg = (request.getParameter("pacsInteg"));
		}

		if (request.getParameter("telemediInteg") != null
				&& !(request.getParameter("telemediInteg").equals(""))) {
			telemediInteg = (request.getParameter("telemediInteg"));
		}

		if (request.getParameter(EFFECTIVE_DATE_FROM) != null
				&& !(request.getParameter(EFFECTIVE_DATE_FROM).equals(""))) {
			effactiveFromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE_FROM));
		}
		/*
		 * if(request.getParameter(EFFECTIVE_DATE_TO) != null &&
		 * !(request.getParameter(EFFECTIVE_DATE_TO).equals(""))){
		 * effactiveToDate =
		 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EFFECTIVE_DATE_TO
		 * )); }
		 */
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", chargeId);
		generalMap.put("charge", charge);
		generalMap.put("chargeTypeId", chargeTypeId);
		generalMap.put("chargeCode", chargeCode);
		generalMap.put("chargeName", chargeName);
		generalMap.put("mainChargeId", mainChargeId);
		generalMap.put("subchargeId", subChargeId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("chargeTypeId", chargeTypeId);
		generalMap.put("discountPercentage", discountPercentage);
		generalMap.put("accountId", accountId);
		generalMap.put("subAccountId", subAccountId);
		generalMap.put("editable", editable);
		generalMap.put("discountable", discountable);
		generalMap.put("drAccountRequired", drAccountRequired);
		generalMap.put("opd_related_services", opd_related_services);
		generalMap.put("effactiveFromDate", effactiveFromDate);
		generalMap.put("effactiveToDate", effactiveToDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("stdDeductionGen", stdDeductionGen);
		generalMap.put("stdDeductionSpl", stdDeductionSpl);
		generalMap.put("proceCode", proceCode);
		generalMap.put("pacsInteg", pacsInteg);
		generalMap.put("telemediInteg", telemediInteg);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSubChargeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSubChargeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editLocalChargeCode(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSubChargeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hospital?method=showLocalChargeCodeJsp";
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		try {
			map = hospitalDetailsMasterHandlerService.showLocalChargeCodeJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "localChargeCode";
		title = "edit Charge";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		//map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);
	}
	//===========================active and inactive local charge code===========================
	
	@SuppressWarnings("deprecation")
	public ModelAndView deleteLocalChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> chargeTypeMap = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		int chargeCodeId = 0;
		int chargeTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		String chargeTypeName = "";
		Date changedDate = null;
		String flag = "";
		Boolean chargeStatus = false;
		boolean dataDeleted = false;

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& !(request.getParameter(CHARGE_CODE_ID).equals(""))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		System.out.println(chargeCodeId+"---"+flag);
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
    
		if (flag.equals("Activate")) {
			dataDeleted = hospitalDetailsMasterHandlerService
					.deleteLocalChargeCode1(chargeCodeId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}
		}
		if (flag.equals("InActivate")) {
			dataDeleted = hospitalDetailsMasterHandlerService
					.deleteLocalChargeCode1(chargeCodeId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			} else {
				message = "Record is Activated successfully !!";
			}
		}
		url = "/hms/hms/hospitalDetailsMaster?method=showLocalChargeCodeJsp";
		int hospitalId=0;
		System.out.println("hospital"+session.getAttribute(HOSPITAL_ID));
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			map.put("hospitalId", hospitalId);
		}
		try {
			map = hospitalDetailsMasterHandlerService.showLocalChargeCodeJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "localChargeCode";
		title = "Delete Charge Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);

		
	}
	
	// ------------------------------------------Session
		// ----------------------------------

		public ModelAndView searchSession(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String sessionName = null;
			session=request.getSession();
			
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
				//box.put(HOSPITAL_ID, hospitalId);
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				sessionName = request.getParameter(SEARCH_NAME);
			}
			map = hospitalDetailsMasterHandlerService.searchSession(sessionName,hospitalId);
			jsp = "session";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("sessionName", sessionName);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView showSessionJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map map = new HashMap();
			Box box=HMSUtil.getBox(request);
			HttpSession session=request.getSession();
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
				box.put(HOSPITAL_ID, hospitalId);
			}
			
			map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
			String jsp = "session";
			jsp += ".jsp";
			title = "Session";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addSession(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasSession masSession = new MasSession();
			String changedBy = "";
			String fromTime="";
			String toTime="";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			String hospitalCode="";
			int departmentId = 0; // added by amit das on 21-08-2017
			
			hospitalCode=(String)session.getAttribute("hospitalCode");
			
			Box box=HMSUtil.getBox(request);
			int hospitalId=0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
				box.put(HOSPITAL_ID, hospitalId);
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
			if (request.getParameter(FROM_TIME) != null
					&& !(request.getParameter(FROM_TIME).trim().equals(""))) {
				fromTime = request.getParameter(FROM_TIME).trim();
			}
			if (request.getParameter(TO_TIME) != null
					&& !(request.getParameter(TO_TIME).trim().equals(""))) {
				toTime = request.getParameter(TO_TIME).trim();
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

			/*if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}*/
			
			// added by amit das on 21-08-2017
			if (request.getParameter("department") != null) {
				departmentId = Integer.parseInt(request.getParameter("department"));
			}
			
			

			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put(HOSPITAL_ID, hospitalId);
			
			generalMap.put("fromTime", fromTime); // added by amit das on 21-08-2017
			generalMap.put("toTime", toTime); // added by amit das on 21-08-2017
			generalMap.put("departmentId", departmentId); // added by amit das on 21-08-2017

			listMap = hospitalDetailsMasterHandlerService
					.checkSession(generalMap);
			List sessionNameList = new ArrayList();
			if (listMap.get("duplicateGeneralNameList") != null) {
				sessionNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((sessionNameList.size() == 0 || sessionNameList == null)
					&& (sessionNameList.size() == 0 || sessionNameList == null)) {
				masSession.setSessionName(name);
				
				masSession.setFromTime(fromTime);
				masSession.setToTime(toTime);
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				masSession.setHospital(masHospital);
				
				Integer depart=Integer.parseInt(request.getParameter("department"));
				masSession.setStatus("Y");
				if(depart != 0){
				MasDepartment dept=new MasDepartment();
				dept.setId(Integer.parseInt(request.getParameter("department")));
				masSession.setDepartment(dept);
				}else if(depart == 0){
					masSession.setDepartment(null);
				}
				
				Users users = new Users();
				users.setId(userId);
				masSession.setLastChgBy(users);
				masSession.setLastChgDate(currentDate);
				masSession.setLastChgTime(currentTime);
				successfullyAdded = hospitalDetailsMasterHandlerService
						.addSession(masSession,hospitalCode);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((sessionNameList.size() != 0) || sessionNameList != null) {
				if ((sessionNameList.size() != 0 || sessionNameList != null)) {
					message = "Session already exists.";
				}
			}
			try {
				map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "session";
			title = "Add Session";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editSession(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
			MasSession masSession = new MasSession();
			session = request.getSession();
			String sessionName = "";
			int sessionId = 0;
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			int hospitalId=0;
			String fromTime="";
			String toTime="";
			Box box=HMSUtil.getBox(request); 
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
				box.put(HOSPITAL_ID, hospitalId);
			} 
			Integer userId = (Integer) session.getAttribute("userId");

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				sessionId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				sessionName = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(FROM_TIME) != null
					&& !(request.getParameter(FROM_TIME).equals(""))) {
				fromTime = request.getParameter(FROM_TIME);
			}
			if (request.getParameter(TO_TIME) != null
					&& !(request.getParameter(TO_TIME).equals(""))) {
				toTime = request.getParameter(TO_TIME);
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
			int deptId=0;
			if(request.getParameter("department") != "0"){
				deptId=Integer.parseInt(request.getParameter("department"));
				}

			generalMap.put("id", sessionId);
			generalMap.put("name", sessionName);
			generalMap.put("userId", userId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("fromTime", fromTime);
			generalMap.put("toTime", toTime);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);

			generalMap.put("flag", true);
			generalMap.put("deptId", deptId);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingOccupationNameList = (List) listMap
					.get("duplicateGeneralNameList");

			boolean dataUpdated = false;
			if (existingOccupationNameList.size() == 0) {
				dataUpdated = hospitalDetailsMasterHandlerService
						.editSessionToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingOccupationNameList.size() > 0) {
				message = "Name already exists.";
			}
			url = "/hms/hms/hospitalDetailsMaster?method=showSessionJsp";

			try {
				map = hospitalDetailsMasterHandlerService.showSessionJsp(box);

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "session";
			title = "update Session";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteSession(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int sessionId = 0;
			String message = null;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null; 
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId"); 
			Map<String, Object> generalMap = new HashMap<String, Object>();
			String flag = "";
			Box box=HMSUtil.getBox(request);
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
				box.put(HOSPITAL_ID, hospitalId);
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				sessionId = Integer.parseInt(request.getParameter(COMMON_ID));
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

			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = hospitalDetailsMasterHandlerService.deleteSession(sessionId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/hospital?method=showSessionJsp";

			try {
				map = hospitalDetailsMasterHandlerService.showSessionJsp(box);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "session";
			title = "delete Session";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView showLocalChargeCodeBlockUnblockJsp(HttpServletRequest request,
				HttpServletResponse response) {
			session = request.getSession(true);
			Box box=HMSUtil.getBox(request);
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			int deptId=0;
			if(session.getAttribute("deptId")!=null)
			{
				deptId=(Integer)session.getAttribute("deptId");
			}
			
			box.put(HOSPITAL_ID, hospitalId);
			box.put("deptId", deptId);
					map = hospitalDetailsMasterHandlerService
							.showLocalChargeCodeBlockUnblockJsp(box);
					@SuppressWarnings("unused")
					ArrayList searchMainChargecodeList = (ArrayList) map
							.get("searchMainChargecodeList");
					ArrayList searchSubChargeList = (ArrayList) map
							.get("searchSubChargeList");
					// System.out.println("searchMainChargecodeList");
					jsp = "billInstituteWiseBillBlockUnBlock";
					jsp += ".jsp";
					title = "MainChargecode";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("pageNo", 1);
					return new ModelAndView("index", "map", map);

				}
		
		public ModelAndView	saveForBlockUnBlock(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String,Object>map=new HashMap<String,Object>();
			String[] invList=null;
			List<String>invFinalList=new ArrayList<String>();
			List<Integer>invFinalList1=new ArrayList<Integer>();
			if(request.getParameterValues("invName")!=null){
				invList=request.getParameterValues("invName");
				for(String s:invList){
					invFinalList1.add(Integer.parseInt(s));
				}
			}
			session=request.getSession();
			String status="";
			if(request.getParameter("status")!=null){
				status=request.getParameter("status");
			}
			Box box=HMSUtil.getBox(request);
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			int deptId=0;
			if(session.getAttribute("deptId")!=null)
			{
				deptId=(Integer)session.getAttribute("deptId");
			}
			
			box.put(HOSPITAL_ID, hospitalId);
			box.put("deptId", deptId);
			//int hospitalId=0;
			
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			String reasonToBlock="";
			if(request.getParameter("reasonToBlock")!=null){
				reasonToBlock=request.getParameter("reasonToBlock");
			}
			map=hospitalDetailsMasterHandlerService.saveForBlockUnBlock(invFinalList1,status,hospitalId,reasonToBlock);
			map = hospitalDetailsMasterHandlerService
					.showLocalChargeCodeBlockUnblockJsp(box);
			String message="";
			message="Charge List Updated!!";
			jsp = "billInstituteWiseBillBlockUnBlock";
			jsp += ".jsp";
			title = "MainChargecode";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pageNo", 1);
			map.put("message",message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView		getReasonForBlock(HttpServletRequest request,
				HttpServletResponse response) {
				Map<String,Object>map=new HashMap<String,Object>();
				int chargeCodeId=0;
				if(request.getParameter("chargeCodeId")!=null){
					chargeCodeId=Integer.parseInt(request.getParameter("chargeCodeId"));
				}
				session=request.getSession();
				int hospitalId=0;
				if(session.getAttribute(HOSPITAL_ID)!=null)
				{
					hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
				}
				int deptId=0;
				if(session.getAttribute("deptId")!=null)
				{
					deptId=(Integer)session.getAttribute("deptId");
				}
				map=hospitalDetailsMasterHandlerService.getReasonForBlock(chargeCodeId,hospitalId,deptId);
				jsp = "responseForbillInstituteWiseBillBlockUnBlock";
				//jsp += ".jsp";
				title = "MainChargecode";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("pageNo", 1);
				map.put("message",message);
				return new ModelAndView(jsp, "map", map);
		}
		// ------------------------------------------------------------------------------------------

	public HospitalDetailsMasterHandlerService getHospitalDetailsMasterHandlerService() {
		return hospitalDetailsMasterHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	
	//--------------------------------
	// ----------- Mas Action Taken ----------
	
	

	@SuppressWarnings("unchecked")
	public ModelAndView showActionTakenJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) hospitalDetailsMasterHandlerService.showActionTaken();
		String jsp = "actionTaken";
		jsp += ".jsp";
		title = "ActionTaken";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addActionTaken(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasActionTaken masActionTaken = new MasActionTaken();
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

		List charityTypeCodeList = new ArrayList();
		List charityTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			charityTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			charityTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((charityTypeCodeList.size() == 0 || charityTypeCodeList == null)
				&& (charityTypeNameList.size() == 0 || charityTypeNameList == null)) {
			masActionTaken.setActionTakenCode(code);
			masActionTaken.setActionTakenName(name);

			masActionTaken.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masActionTaken.setLastChgBy(users);
			masActionTaken.setLastChgDate(currentDate);
			masActionTaken.setLastChgTime(currentTime);
			Map<String, Object> actionTakenMap = new HashMap<String, Object>();

			System.out.println("masActionTaken4456456" + masActionTaken);

			actionTakenMap.put("masActionTaken", masActionTaken);
			actionTakenMap.put("hospitalId", hospitalId);
			successfullyAdded = hospitalDetailsMasterHandlerService
					.addActionTaken(actionTakenMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((charityTypeCodeList.size() != 0 || charityTypeCodeList != null)
				|| (charityTypeNameList.size() != 0)
				|| charityTypeNameList != null) {
			if ((charityTypeCodeList.size() != 0 || charityTypeCodeList != null)
					&& (charityTypeNameList.size() == 0 || charityTypeNameList == null)) {
				message = "ActionTaken Code already exists.";
			} else if ((charityTypeNameList.size() != 0 || charityTypeNameList != null)
					&& (charityTypeCodeList.size() == 0 || charityTypeCodeList == null)) {
				message = "ActionTaken Name already exists.";
			} else if ((charityTypeCodeList.size() != 0 || charityTypeCodeList != null)
					&& (charityTypeNameList.size() != 0 || charityTypeNameList != null)) {
				message = "ActionTaken Code and ActionTaken exist.";
			}
		}

		try {
			map = hospitalDetailsMasterHandlerService.showActionTaken();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "actionTaken";
		title = "Add ActionTaken";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editActionTaken(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String charityTypeCode = "";
		String name = "";
		int charityTypeId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				charityTypeId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				charityTypeCode = request.getParameter(CODE);
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

			generalMap.put("id", charityTypeId);
			generalMap.put("charityTypeCode", charityTypeCode);
			generalMap.put("name", name);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editActionTaken(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = hospitalDetailsMasterHandlerService.showActionTaken();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "actionTaken";
		title = "Edit ActionTaken";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchActionTaken(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String charityTypeCode = null;
		String charityTypeName = null;
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
			charityTypeCode = searchField;
			charityTypeName = null;

		} else {
			charityTypeCode = null;
			charityTypeName = searchField;
		}
		map = hospitalDetailsMasterHandlerService.searchActionTaken(charityTypeCode,
				charityTypeName);

		jsp = "actionTaken";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("charityTypeCode", charityTypeCode);
		map.put("charityTypeName", charityTypeName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteActionTaken(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int charityTypeId = 0;
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
			charityTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteActionTaken(
				charityTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showActionTakenJsp";

		try {
			map = hospitalDetailsMasterHandlerService.showActionTaken();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "actionTaken";
		title = "delete ActionTaken";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showSnomedChargeCodeJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeCodeCode = null;
		String chargeCodeName = null;
		
		HttpSession session=request.getSession();
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		String searchField = null;
		int mas_main_charge_id = 0;
		if (request.getParameter("m1") != null && !(request.getParameter("m1").equals(""))) {
			mas_main_charge_id = Integer.parseInt(request.getParameter("m1"));
		}
		int searchRadio = 1;
		try {
				if (request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
				}
	
				if (request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		if (searchRadio == 1) {
			chargeCodeCode = searchField;
			chargeCodeName = null;

		}else {
			chargeCodeCode = null;
			chargeCodeName = searchField;
		}
		int mainChargecodeId=0;
		int subChargecodeId=0;
		int chargeTypeId=0;
		int departmentId=0;
		int tableRow=0;
		String changedBy = "";
		Date currentDate = new Date();
		Date effactiveFromDate = new Date();
		Users user = null;
		user = (Users) session.getAttribute("users");
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.parseInt(request.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_TYPE_ID) != null) {
			chargeTypeId = Integer.parseInt(request.getParameter(CHARGE_TYPE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EFFECTIVE_DATE_FROM) != null && !(request.getParameter(EFFECTIVE_DATE_FROM).equals(""))) {
			effactiveFromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EFFECTIVE_DATE_FROM));
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
		map.put("user",user);
		map.put("currentTime",currentTime);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargecodeId", subChargecodeId);
		map.put("chargeTypeId", chargeTypeId);
		map.put("departmentId", departmentId);
		map.put("effactiveFromDate", effactiveFromDate);
		
		//for addition new snomed charge
		System.out.println(">>>>>>>>> "+request.getParameter("tableRow"));
		if (request.getParameter("tableRow") != null && !(request.getParameter("tableRow").equals(""))) {
			tableRow = Integer.parseInt(request.getParameter("tableRow"));
			if(tableRow>0){
				List<String>chargeList=new ArrayList<String>();
				List<String>codeList=new ArrayList<String>();
				List<String>chargeIdList=new ArrayList<String>();
				List<Float>chargerateList=new ArrayList<Float>();
				for(int t=0;t<tableRow;t++){
					if (request.getParameter("code"+t) != null && !(request.getParameter("code"+t).equals(""))) {
						codeList.add(request.getParameter("code"+t));
					}
					if (request.getParameter("charge"+t) != null && !(request.getParameter("charge"+t).equals(""))) {
						chargeList.add(request.getParameter("charge"+t));
					}
					if (request.getParameter("chargeId"+t) != null && !(request.getParameter("chargeId"+t).equals(""))) {
						chargeIdList.add(request.getParameter("chargeId"+t));
					}
					if (request.getParameter("chargerate"+t) != null && !(request.getParameter("chargerate"+t).equals(""))) {
						chargerateList.add(Float.parseFloat(request.getParameter("chargerate"+t)));
					}
				}
				System.out.println("codeList "+codeList.size());
				System.out.println("chargeList "+chargeList.size());
				System.out.println("chargeIdList "+chargeIdList.size());
				System.out.println("chargerateList "+chargerateList.size());
				map.put("codeList", codeList);
				map.put("chargeList", chargeList);
				map.put("chargeIdList", chargeIdList);
				map.put("chargerateList", chargerateList);
				
				map = hospitalDetailsMasterHandlerService.addSnomedChargeCode(map);
				}
		}
		map.put("chargeCodeCode", chargeCodeCode);
		map.put("chargeCodeName", chargeCodeName);
		map.put("mas_main_charge_id",mas_main_charge_id);		
		map = hospitalDetailsMasterHandlerService.searchChargeCode(map);
		jsp = "snomedchargecode";
		jsp += ".jsp";
		title = "snomedchargecode";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView addSnomedChargeCode(HttpServletRequest request,HttpServletResponse response) {
		
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView showServiceCentreCounterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		map = hospitalDetailsMasterHandlerService.showServiceCentreCounterJsp(hospitalId);
		String jsp = "serviceCentreCounter";
		jsp += ".jsp";
		title = "Ot Charge Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addServiceCentreCounter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		MasServiceCentreCounter masServiceCentreCounter = new MasServiceCentreCounter();
		int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
	
		int changedBy = 0;
		int departmentId = 0;
		String counterNo = "";

		if (request.getParameter("departmentId") != null
				&& !(request.getParameter("departmentId").equals("0"))) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}

		if (request.getParameter("counterNo") != null) {
			counterNo = request.getParameter("counterNo");
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
		generalMap.put("departmentId", departmentId);
		generalMap.put("counterNo", counterNo);
		generalMap.put("hospitalId", hospitalId);

		System.out.println("-------departmentId-----"+departmentId);
		System.out.println("-------counterNo-----"+counterNo);
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = hospitalDetailsMasterHandlerService.checkForExistingServiceCentreCounter(generalMap);
		List duplicateChargeCodeNameList = new ArrayList();
		
		if (listMap.get("duplicateChargeCodeNameList") != null) {
			duplicateChargeCodeNameList = (List) listMap
					.get("duplicateChargeCodeNameList");
		}
		if ((duplicateChargeCodeNameList.size() == 0 || duplicateChargeCodeNameList == null))

		{
			boolean successfullyAdded = false;
			
			
			
			if (departmentId != 0) {
				MasDepartment masDepartment=new MasDepartment();
				masDepartment.setId(departmentId);
				masServiceCentreCounter.setDepartment(masDepartment);
			}

			masServiceCentreCounter.setCounterNo(counterNo);
			
			masServiceCentreCounter.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			masServiceCentreCounter.setLastChgBy(users);
			masServiceCentreCounter.setLastChgDate(currentDate);
			masServiceCentreCounter.setLastChgTime(currentTime);
			
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			masServiceCentreCounter.setHospital(hospital);
			successfullyAdded = hospitalDetailsMasterHandlerService.addServiceCentreCounter(masServiceCentreCounter);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (duplicateChargeCodeNameList.size() != 0) {

			message = "SC and Counter No. already exists for same.";
		}

		try {
			map = hospitalDetailsMasterHandlerService.showServiceCentreCounterJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "serviceCentreCounter";
		title = "Add Service Centre Counter";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editServiceCentreCounter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		int serviceCentreCounterId = 0;
		int otId=0;
		int chargeCodeId=0;
		int departmentId = 0;
		String counterNo = "";

		if (request.getParameter("departmentId") != null
				&& !(request.getParameter("departmentId").equals("0"))) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}

		if (request.getParameter("counterNo") != null) {
			counterNo = request.getParameter("counterNo");
		}

		if (request.getParameter(COMMON_ID) != null) {
			serviceCentreCounterId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		changedBy = (Integer) session.getAttribute("userId");

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", serviceCentreCounterId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("counterNo", counterNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("flag", true);

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = hospitalDetailsMasterHandlerService
				.checkForExistingServiceCentreCounterId(generalMap);
		List duplicateChargeCodeNameList = (List) listMap
				.get("duplicateChargeCodeNameList");
		boolean dataUpdated = false;
		if (duplicateChargeCodeNameList.size() == 0) {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editServiceCentreCounter(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (duplicateChargeCodeNameList.size() > 0) {
			message = "SC and Counter No. already exists for same.";
		}

		try {
			map = hospitalDetailsMasterHandlerService.showServiceCentreCounterJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "serviceCentreCounter";
		title = "Edit Service Centre Counter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteServiceCentreCounter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceCentreCounterId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			serviceCentreCounterId = Integer.parseInt(request
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
		dataDeleted = hospitalDetailsMasterHandlerService.deleteServiceCentreCounter(
				serviceCentreCounterId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = hospitalDetailsMasterHandlerService.showServiceCentreCounterJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "serviceCentreCounter";
		title = "Delete Service Centre Counter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchServiceCentreCounter(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String counterNo = "";
int departmentId=0;
HttpSession session=request.getSession();
int hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		try {
			
			
			if (request.getParameter("departmentIds") != null
					&& !(request.getParameter("departmentIds").equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter("departmentIds"));
			}else{
				departmentId=0;
			}

			if (request.getParameter("counterNos") != null) {
				counterNo = request.getParameter("counterNos");
			}
			int searchRadio = 1;
			try {
					if (request.getParameter(SELECTED_RADIO) != null
						&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio = Integer.parseInt(request
							.getParameter(SELECTED_RADIO));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (searchRadio == 1) {
				departmentId = departmentId;
				counterNo = null;

			} else {
				counterNo = counterNo;
				departmentId = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hospitalDetailsMasterHandlerService.searchServiceCentreCounter(departmentId,counterNo,hospitalId);

		jsp = "serviceCentreCounter";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("counterNo", counterNo);
		map.put("departmentId", departmentId);
		return new ModelAndView("index", "map", map);
	}
	
	public void removeDoctorFromUnit(HttpServletRequest request,HttpServletResponse response){
		String unit_t_id=request.getParameter("unit_t_id");
		boolean status=hospitalDetailsMasterHandlerService.removeDoctorFromUnit(unit_t_id);
	}
	
	public ModelAndView showMultiDepartmentMappingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");

		map.put("hospitalId", hospitalId);

		map = hospitalDetailsMasterHandlerService
				.getMultiDepartmentMappings(map);

		jsp = "multiDepartmentMapping.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addMultiDepartmentMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int parentServiceCenterId = 0;
		String parentServiceCenterIdStr = request
				.getParameter("parentServiceCenterId");
		String departmentTypeName = request.getParameter("departmentTypeName");

		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");

		if (parentServiceCenterIdStr != null
				&& !parentServiceCenterIdStr.trim().equals(""))
			parentServiceCenterId = Integer.parseInt(parentServiceCenterIdStr);

		String[] serviceCenterIdArray = request
				.getParameterValues("serviceCenterId");

		map.put("hospitalId", hospitalId);
		map.put("parentServiceCenterId", parentServiceCenterId);
		map.put("departmentTypeName", departmentTypeName);
		map.put("serviceCenterIdArray", serviceCenterIdArray);

		map = hospitalDetailsMasterHandlerService
				.addMultiDepartmentMapping(map);

		jsp = "multiDepartmentMapping.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDepartmentPharmacyMapping(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		String[] parentServiceCenterIdArray = null;
		String parentServiceCenterIdStr = request
				.getParameter("parentServiceCenterIds");

		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");

		if (parentServiceCenterIdStr != null
				&& !parentServiceCenterIdStr.trim().equals(""))
			parentServiceCenterIdArray = parentServiceCenterIdStr.split(",");

		map.put("hospitalId", hospitalId);
		map.put("parentServiceCenterIdArray", parentServiceCenterIdArray);

		map = hospitalDetailsMasterHandlerService
				.deleteMultiDepartmentMapping(map);

		jsp = "multiDepartmentMapping.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	


	public ModelAndView showDoctorCounterMapping(
			HttpServletRequest request, HttpServletResponse response) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session=request.getSession();
	int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
	map.put("hospitalId", hospitalId);
		
	map = hospitalDetailsMasterHandlerService.showDoctorCounterMapping(map);
	jsp = "doctorCounterMapping";
	jsp += ".jsp";
	title = "doctorCounterMapping";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);

	}
	public ModelAndView showDoctorCounterValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		HttpSession session = request.getSession();
		int departmentId=0;
		if (request.getParameter("departmentId") != null
				&& !(request.getParameter("departmentId").equals("0"))) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map = hospitalDetailsMasterHandlerService.showDoctorCounterValues(map);
		String jsp = "doctorValue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView(jsp, "map", map);

	}
	
	
	public ModelAndView showEmpValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		HttpSession session = request.getSession();
		int hospitalDoctorUnitId=0;
		if (request.getParameter("hospitalDoctorUnitId") != null
				&& !(request.getParameter("hospitalDoctorUnitId").equals("0"))) {
			hospitalDoctorUnitId = Integer.parseInt(request
					.getParameter("hospitalDoctorUnitId"));
		}
		
		int departmentId=0;
		if (request.getParameter("departmentId") != null
				&& !(request.getParameter("departmentId").equals("0"))) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		map.put("departmentId", departmentId);
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);
		map.put("hospitalDoctorUnitId", hospitalDoctorUnitId);
		map = hospitalDetailsMasterHandlerService.showEmpValues(map);
		String jsp = "employeeValue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView(jsp, "map", map);

	}
	
	

	public ModelAndView editDoctorCounterMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		Box box=HMSUtil.getBox(request);
		String charityTypeCode = "";
		String name = "";
		int userId = 0;
		int cntId = 0;
		String status=null;
		int usersId=0;
		//List<Integer> counterIdList = new ArrayList<>();
		List<String> StatusList = new ArrayList<>();
		List<Integer> userIdList = new ArrayList<>();
		int totalrecord = 0;int servicecenterId=0;
		if(request.getParameter("serviceCentreId")!=null){
			servicecenterId =Integer.parseInt(request.getParameter("serviceCentreId"));
		}
		if (request.getParameter("totalrecord") != null) {
			totalrecord = Integer.parseInt(request.getParameter("totalrecord"));

			for (int i = 1; i <= totalrecord; i++) {

				if (request.getParameter("chk" + i) != null) {
					status = request.getParameter("chk" + i);
					StatusList.add(status);
				}else{
					StatusList.add("n");
				}

				if (request.getParameter("userId" + i) != null) {
					userId = Integer.parseInt(request
							.getParameter("userId" + i));
					userIdList.add(userId);
				}

			}

		}
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			usersId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		//generalMap.put("counterIdList", counterIdList);
		generalMap.put("StatusList", StatusList);
		generalMap.put("userIdList", userIdList);
		generalMap.put("usersId", usersId);
		generalMap.put("servicecenterId", servicecenterId);
		boolean dataUpdated = false;
		try {
			dataUpdated = hospitalDetailsMasterHandlerService
					.editDoctorCounterMapping(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map.put("hospitalId", hospitalId);

		try {
			map = hospitalDetailsMasterHandlerService
					.showDoctorCounterMapping(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "doctorCounterMapping";
		jsp += ".jsp";
		title = "doctorCounterMapping";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

}
