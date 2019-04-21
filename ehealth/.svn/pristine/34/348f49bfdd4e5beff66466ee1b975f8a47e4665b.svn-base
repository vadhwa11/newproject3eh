package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CLINICAL_NOTE;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DOSAGE_CALCULATION;
import static jkt.hms.util.RequestConstants.EQUIPMENT_OPD_JSP;
import static jkt.hms.util.RequestConstants.FREQUENCY;
import static jkt.hms.util.RequestConstants.HOLIDAY_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INSTRUCTIONS;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MODULARITY_MASTER_JSP;
import static jkt.hms.util.RequestConstants.NO_OF_DAYS;
import static jkt.hms.util.RequestConstants.NO_OF_EQUIPMENT;
import static jkt.hms.util.RequestConstants.OPD_HOLIDAY_JSP;
import static jkt.hms.util.RequestConstants.OPD_INSTRUCTION_TREATMENT_JSP;
import static jkt.hms.util.RequestConstants.OPD_INVESTIGATION_TEMPLATE_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.OPD_INVESTIGATION_TEMPLATE_JSP;
import static jkt.hms.util.RequestConstants.OPD_TEMPLATE_JSP;
import static jkt.hms.util.RequestConstants.OPD_TREATMENT_TEMPLATE_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.OPD_TREATMENT_TEMPLATE_JSP;
import static jkt.hms.util.RequestConstants.OPD_VACCIN_JSP;
import static jkt.hms.util.RequestConstants.QTY;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TEMPLATE_ID;
import static jkt.hms.util.RequestConstants.TEMPLATE_TYPE;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VACCIN_DURATION;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasModularity;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.OPDMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OPDMasterController extends MultiActionController {


	OPDMasterHandlerService opdMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

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

	// ****************************************** Start Of OPD by Mansi
	// ****************************//

	public ModelAndView searchOpdTemplate(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String templateCode = null;
		String templateName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
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
			templateCode = searchField;
			templateName = null;

		} else {
			templateCode = null;
			templateName = searchField;
		}
		map = opdMasterHandlerService.searchOpdTemplate(templateCode,
				templateName);

		jsp = OPD_TEMPLATE_JSP;
		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("templateCode", templateCode);
		map.put("templateName", templateName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOpdTemplateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = null;
		session=request.getSession();
		Map map = new HashMap();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		map = opdMasterHandlerService.showOpdTemplateJsp(hospitalId);
		String jsp = OPD_TEMPLATE_JSP;
		jsp += ".jsp";
		title = "OPD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdTemplate opdTemplate = new OpdTemplate();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int departmentId = 0;
		int hospitalId = 0;
		String templateType = "";
		session=request.getSession();
		String instituteTemplateType = "";
		Users users=(Users)session.getAttribute("users");
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
		
		if (request.getParameter(TEMPLATE_TYPE) != null) {
			templateType = request.getParameter(TEMPLATE_TYPE);
		}
		if (request.getParameter("global") != null) {
			instituteTemplateType = request.getParameter("global");
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
		generalMap.put("instituteTemplateType", instituteTemplateType);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List templateCodeList = new ArrayList();
		List templateNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			templateCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			templateNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((templateCodeList.size() == 0 || templateCodeList == null)
				&& (templateNameList.size() == 0 || templateNameList == null)) {
			opdTemplate.setTemplateCode(code);
			opdTemplate.setTemplateName(name);
			
			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
			
			}
			if(instituteTemplateType.equals("local")){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					opdTemplate.setHospital(masHospital);
			}

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdTemplate.setDepartment(masDepartment);

			opdTemplate.setTemplateType(templateType);
			opdTemplate.setStatus("y");
			opdTemplate.setLastChgBy(users);
			opdTemplate.setLastChgDate(currentDate);
			opdTemplate.setLastChgTime(currentTime);
			
			
			
			successfullyAdded = opdMasterHandlerService.addOpdTemplate(opdTemplate);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((templateCodeList.size() != 0 || templateCodeList != null)
				|| (templateNameList.size() != 0) || templateNameList != null) {
			if ((templateCodeList.size() != 0 || templateCodeList != null)
					&& (templateNameList.size() == 0 || templateNameList == null)) {

				message = "Template Code  already exists.";
			} else if ((templateNameList.size() != 0 || templateNameList != null)
					&& (templateCodeList.size() == 0 || templateCodeList == null)) {

				message = "Template Name already exists.";
			} else if ((templateCodeList.size() != 0 || templateCodeList != null)
					&& (templateNameList.size() != 0 || templateNameList != null)) {

				message = "Template Code and Template Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdTemplateJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_TEMPLATE_JSP;
		title = "Add OPD Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdTemplate(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String templateCode = "";
		String templateName = "";
		int templateId = 0;
		int departmentId = 0;
		String templateType = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			templateCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			templateName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(TEMPLATE_TYPE) != null) {
			templateType = request.getParameter(TEMPLATE_TYPE);
		}
		String instituteTemplateType = "";
		if (request.getParameter("global") != null) {
			instituteTemplateType = request.getParameter("global");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
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

		generalMap.put("id", templateId);
		generalMap.put("hospitalId",hospitalId);
		generalMap.put("templateCode", templateCode);
		generalMap.put("name", templateName);
		generalMap.put("departmentId", departmentId);
		generalMap.put("templateType", templateType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("instituteTemplateType", instituteTemplateType);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTemplateNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingTemplateNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdTemplateToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingTemplateNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateJsp";

		try {
			map = opdMasterHandlerService.showOpdTemplateJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_TEMPLATE_JSP;
		title = "update OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		session=request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		Users users=(Users)session.getAttribute("users");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("users", users);
		boolean dataDeleted = false;
		dataDeleted = opdMasterHandlerService.deleteOpdTemplate(templateId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateJsp";

		try {
			int hospitalId = 0;
			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
			}
			
			map = opdMasterHandlerService.showOpdTemplateJsp(hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_TEMPLATE_JSP;
		title = "delete OPD Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOpdHoliday(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String holidayCode = null;
		String holidayName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			holidayCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			holidayName = request.getParameter(SEARCH_NAME);
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
			holidayCode = searchField;
			holidayName = null;

		} else {
			holidayCode = null;
			holidayName = searchField;
		}
		map = opdMasterHandlerService
				.searchOpdHoliday(holidayCode, holidayName);

		jsp = OPD_HOLIDAY_JSP;

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("holidayCode", holidayCode);
		map.put("holidayName", holidayName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOpdHolidayJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdHolidayJsp();
		String jsp = OPD_HOLIDAY_JSP;
		jsp += ".jsp";
		title = "Holiday";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdHoliday(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdHoliday opdHoliday = new OpdHoliday();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date holidayDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(HOLIDAY_DATE) != null
				&& !(request.getParameter(HOLIDAY_DATE).equals(""))) {
			holidayDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(HOLIDAY_DATE));
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

		List holidayCodeList = new ArrayList();
		List holidayNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			holidayCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			holidayNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((holidayCodeList.size() == 0 || holidayCodeList == null)
				&& (holidayNameList.size() == 0 || holidayNameList == null)) {
			opdHoliday.setHolidayCode(code);
			opdHoliday.setHolidayName(name);

			opdHoliday.setHolidayDate(holidayDate);
			opdHoliday.setStatus("y");
			opdHoliday.setLastChgBy(changedBy);
			opdHoliday.setLastChgDate(currentDate);
			opdHoliday.setLastChgTime(currentTime);

			int hospitalId = (Integer)session.getAttribute("hospitalId");
			  MasHospital hospital = new MasHospital();
			  hospital.setId(hospitalId);
			  opdHoliday.setHospital(hospital);
			successfullyAdded = opdMasterHandlerService
					.addOpdHoliday(opdHoliday);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((holidayCodeList.size() != 0 || holidayCodeList != null)
				|| (holidayNameList.size() != 0) || holidayNameList != null) {
			if ((holidayCodeList.size() != 0 || holidayCodeList != null)
					&& (holidayNameList.size() == 0 || holidayNameList == null)) {

				message = "Holiday Code  already exists.";
			} else if ((holidayNameList.size() != 0 || holidayNameList != null)
					&& (holidayCodeList.size() == 0 || holidayCodeList == null)) {

				message = "Holiday Name already exists.";
			} else if ((holidayCodeList.size() != 0 || holidayCodeList != null)
					&& (holidayNameList.size() != 0 || holidayNameList != null)) {

				message = "Holiday Code and Holiday Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdHolidayJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_HOLIDAY_JSP;
		title = "Add OPD Holiday";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdHoliday(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String holidayCode = "";
		String holidayName = "";
		int holidayId = 0;
		Date holidayDate = new Date();
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			holidayId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			holidayCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			holidayName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(HOLIDAY_DATE) != null
				&& !(request.getParameter(HOLIDAY_DATE).equals(""))) {
			holidayDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(HOLIDAY_DATE));
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

		generalMap.put("id", holidayId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("holidayCode", holidayCode);
		generalMap.put("name", holidayName);
		generalMap.put("holidayDate", holidayDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHolidayNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHolidayNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdHolidayToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHolidayNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";

		try {
			map = opdMasterHandlerService.showOpdHolidayJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_HOLIDAY_JSP;
		title = "update OPD Holiday";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdHoliday(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int holidayId = 0;
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
			holidayId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = opdMasterHandlerService.deleteOpdHoliday(holidayId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";

		try {
			map = opdMasterHandlerService.showOpdHolidayJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_HOLIDAY_JSP;
		title = "delete OPD Holiday";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ****************************************** End Of OPD by Mansi
	// ****************************//

	// ****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdTemplateTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdTemplateTreatment opdTemplateTreatment = new OpdTemplateTreatment();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String frequencyCodeId = "";
		int departmentId = 0;
		int frequencyId = 0;
		int itemId = 0;
		int templateId = 0;
		int instructionId = 0;
		int noofdays = 0;
		int total = 0;
		String dosage = "";
		String duration="";
		String templateName="";
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			}
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosage = (request.getParameter(DOSAGE_CALCULATION));
		}
		if (request.getParameter(INSTRUCTIONS) != null) {
			instructionId = Integer
					.parseInt(request.getParameter(INSTRUCTIONS));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(FREQUENCY) != null) {
			frequencyCodeId = request.getParameter(FREQUENCY);
			frequencyId = Integer.parseInt(frequencyCodeId.substring(0, 1));
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt(request.getParameter(ITEM_ID));
		}
		if (request.getParameter(NO_OF_DAYS) != null) {
			noofdays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			total = Integer.parseInt(request.getParameter(TOTAL_AMOUNT));
		}
		
		if (request.getParameter("duration") != null) {
			duration = request.getParameter("duration");
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
		/*
		 * generalMap.put("code", code); generalMap.put("name", name);
		 */
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		/*
		 * generalMap.put("pojoPropertyName", pojoPropertyName);
		 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
		 * generalMap.put("pojoName", pojoName);
		 */

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List templateCodeList = new ArrayList();
		// List templateNameList = new ArrayList();
		/*
		 * if(listMap.get("duplicateGeneralCodeList") != null){ templateCodeList
		 * = (List)listMap.get("duplicateGeneralCodeList"); }
		 * if(listMap.get("duplicateGeneralNameList") != null){ templateNameList
		 * = (List)listMap.get("duplicateGeneralNameList"); }
		 */boolean successfullyAdded = false;

		/*
		 * if((templateCodeList.size() == 0 || templateCodeList == null) &&
		 * (templateNameList.size() == 0 || templateNameList == null)) {
		 */

		opdTemplateTreatment.setDosage(dosage);

		opdTemplateTreatment.setNoofdays(noofdays);

		opdTemplateTreatment.setTotal(total);
		
		opdTemplateTreatment.setDuration(duration);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplateTreatment.setDepartment(masDepartment);

		MasFrequency masFrequency = new MasFrequency();
		masFrequency.setId(frequencyId);
		opdTemplateTreatment.setFrequency(masFrequency);

		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate.setId(templateId);
		opdTemplateTreatment.setTemplate(opdTemplate);

		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		opdTemplateTreatment.setItem(masStoreItem);

		if(instructionId>0){
		OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
		opdInstructionTreatment.setId(instructionId);
		opdTemplateTreatment
				.setOpdInstructionTreatment(opdInstructionTreatment);
		}
		opdTemplateTreatment.setStatus("y");
		
		Users users = new Users();
		users.setId(changedBy);
		opdTemplateTreatment.setLastChgBy(users);
		
		
	
		
		opdTemplateTreatment.setLastChgDate(currentDate);
		opdTemplateTreatment.setLastChgTime(currentTime);
		successfullyAdded = opdMasterHandlerService
				.addOpdTemplateTreatment(opdTemplateTreatment);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		/*
		 * }
		 *
		 * else if((templateCodeList.size() != 0 || templateCodeList != null) ||
		 * (templateNameList.size() != 0) || templateNameList != null) {
		 * if((templateCodeList.size() != 0 || templateCodeList != null) &&
		 * (templateNameList.size() == 0 || templateNameList == null)){
		 *
		 * message = "Template Code already exists."; } else
		 * if((templateNameList.size() != 0 || templateNameList != null) &&
		 * (templateCodeList.size() == 0 || templateCodeList == null) ){
		 *
		 * message = "Template Name already exists."; } else
		 * if((templateCodeList.size() != 0 || templateCodeList != null) &&
		 * (templateNameList.size() != 0 || templateNameList != null)){
		 *
		 * message = "Template Code and Template Name already exist."; } }
		 */try {
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 //added by govind 17-2-2017 
			String departmentName="";
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			departmentList = (List<MasDepartment>)map.get("departmentList");
			for(MasDepartment dept:departmentList){
				if(departmentId==dept.getId()){
					departmentName=dept.getDepartmentName();
				}
			
			}
					List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
					opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
					for(OpdTemplate opd:opdTemplateList){
						if(templateId==opd.getId()){
							templateName=opd.getTemplateName();
						}
					
					}
					System.out.println("departmentId "+departmentId+" templateId "+templateId+" templateName "+templateName);
					 map.put("deptId", departmentId);
					 map.put("templateId", templateId);
					 map.put("templateName", templateName);
					 map.put("departmentName", departmentName);
						String opClinic="OPTemp";
						if(request.getParameter("opClinic")!=null){
							opClinic=request.getParameter("opClinic");
						}
					
						if(opClinic.equals("OPClinic")){
							jsp = "opdTemplateTreatment_inOPD";
						}else{
						    jsp = OPD_TREATMENT_TEMPLATE_JSP;
						}
						//added by govind 17-2-2017  end 
			//jsp = OPD_TREATMENT_TEMPLATE_JSP;
		title = "Add OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
//Added By Om Tripathi
	public ModelAndView deleteTemplateTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		int departmentId = 0;
		int itemId = 0;
		int templateId = 0;
		String templateName="";
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
			}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			generalMap.put("departmentId", departmentId);
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
			generalMap.put("templateId", templateId);
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt(request.getParameter(ITEM_ID));
		}
		generalMap.put("changedBy", changedBy);
		boolean successfullyAdded = false;
		successfullyAdded = opdMasterHandlerService
				.deleteTemplateTreatment(generalMap);

		if (successfullyAdded) {
			message = "Record Removed Successfully !!";
		} else {
			message = "Try Again !!";
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		String jsp = "opdTemplateTreatment_inOPD";
		jsp += ".jsp";

		title = "Standard Treatment Template";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView editOpdTemplateTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		int departmentId = 0;
		String frequencyCodeId = "";
		int frequencyId = 0;
		int itemId = 0;
		int templateId = 0;
		int templateTreatmentId = 0;
		int instructionId = 0;
		int noofdays = 0;
		int total = 0;
		String dosage = "";
		String changedTime = "";
		Date changedDate = null;
		String duration="";
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int userType = users.getUserType();
			generalMap.put("userType", userType);
		}
	
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(DOSAGE_CALCULATION) != null) {
			dosage = (request.getParameter(DOSAGE_CALCULATION));
		}
		if (request.getParameter(INSTRUCTIONS) != null) {
			instructionId = Integer
					.parseInt(request.getParameter(INSTRUCTIONS));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(FREQUENCY) != null) {
			frequencyCodeId = request.getParameter(FREQUENCY);
			frequencyId = Integer.parseInt(frequencyCodeId.substring(0, 1));
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt(request.getParameter(ITEM_ID));
		}
		if (request.getParameter(NO_OF_DAYS) != null) {
			noofdays = Integer.parseInt(request.getParameter(NO_OF_DAYS));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			total = Integer.parseInt(request.getParameter(TOTAL_AMOUNT));
		}
		
		if (request.getParameter("duration") != null) {
			duration = request.getParameter("duration");
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

		generalMap.put("duration", duration);
		generalMap.put("id", templateTreatmentId);
		generalMap.put("templateId", templateId);
		generalMap.put("frequencyId", frequencyId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("instructionId", instructionId);
		generalMap.put("total", total);
		generalMap.put("noofdays", noofdays);
		generalMap.put("dosage", dosage);
		generalMap.put("itemId", itemId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		// Map<String, Object> listMap = new HashMap<String, Object>();
		/*
		 * generalMap.put("pojoPropertyName", pojoPropertyName);
		 * generalMap.put("pojoName", pojoName);
		 */
		generalMap.put("flag", true);
		/*
		 * listMap =
		 * commonMasterHandlerService.checkForExistingMasters(generalMap); List
		 * existingTemplateNameList = (List)listMap.get("duplicateMastersList");
		 */boolean dataUpdated = false;
		/*
		 * if(existingTemplateNameList.size() == 0) {
		 */dataUpdated = opdMasterHandlerService
				.editOpdTemplateTreatment(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
		/*
		 * } else if(existingTemplateNameList.size() > 0){ message = "Name
		 * already exists."; }
		 */url = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";

		try {
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		 //added by govind 17-2-2017 
		String departmentName="";
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (List<MasDepartment>)map.get("departmentList");
		for(MasDepartment dept:departmentList){
			if(departmentId==dept.getId()){
				departmentName=dept.getDepartmentName();
			}
		
		}
		
		String templateName="";
				List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
				opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
				for(OpdTemplate opd:opdTemplateList){
					if(templateId==opd.getId()){
						templateName=opd.getTemplateName();
					}
				
				}
				System.out.println("departmentId "+departmentId+" templateId "+templateId+" templateName "+templateName);
				 map.put("deptId", departmentId);
				 map.put("templateId", templateId);
				 map.put("templateName", templateName);
				 map.put("departmentName", departmentName);
					String opClinic="OPTemp";
					if(request.getParameter("opClinic")!=null){
						opClinic=request.getParameter("opClinic");
					}
				
					if(opClinic.equals("OPClinic")){
						jsp = "opdTemplateTreatment_inOPD";
					}else{
					    jsp = OPD_TREATMENT_TEMPLATE_JSP;
					}
					//added by govind 17-2-2017  end 
		//jsp = OPD_TREATMENT_TEMPLATE_JSP;
		title = "update OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdTemplateTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int templateTreatmentId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int templateId = 0;
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
		int hospitalId=0;
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int userType = users.getUserType();
			generalMap.put("userType", userType);
		}
	
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
			generalMap.put("templateId", templateId);
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
		dataDeleted = opdMasterHandlerService.deleteOpdTemplateTreatment(
				templateTreatmentId, generalMap);
		if (dataDeleted == true) {
			message = "Record  deleted successfully !!";
		}

		else {
			message = "Record is not deleted !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateTreatmentJsp";

		try {
			map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}

		 //added by govind 17-2-2017 
		int departmentId=0;
		String departmentName="";
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (List<MasDepartment>)map.get("departmentList");
		for(MasDepartment dept:departmentList){
			if(departmentId==dept.getId()){
				departmentName=dept.getDepartmentName();
			}
		
		}
		
		String templateName="";
				List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
				opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
				for(OpdTemplate opd:opdTemplateList){
					if(templateId==opd.getId()){
						templateName=opd.getTemplateName();
					}
				
				}
				System.out.println("departmentId "+departmentId+" templateId "+templateId+" templateName "+templateName);
				 map.put("deptId", departmentId);
				 map.put("templateId", templateId);
				 map.put("templateName", templateName);
				 map.put("departmentName", departmentName);
					String opClinic="OPTemp";
					if(request.getParameter("opClinic")!=null){
						opClinic=request.getParameter("opClinic");
					}
				
					if(opClinic.equals("OPClinic")){
						jsp = "opdTemplateTreatment_inOPD";
					}else{
					    jsp = OPD_TREATMENT_TEMPLATE_JSP;
					}
					//added by govind 17-2-2017  end 
		//jsp = OPD_TREATMENT_TEMPLATE_JSP;
		title = "delete OPD Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView searchOpdTemplateTreatment(HttpServletRequest
	 * request, HttpServletResponse response) throws
	 * ServletRequestBindingException { Map<String, Object> map= new
	 * HashMap<String, Object>(); String templateGroup = "";
	 * if(request.getParameter(SEARCH_FIELD) != null &&
	 * !(request.getParameter(SEARCH_FIELD).equals(""))){ templateGroup =
	 * request.getParameter(SEARCH_FIELD); }
	 *
	 * map = opdMasterHandlerService.searchOpdTemplateTreatment(templateGroup);
	 *
	 * jsp=OPD_TREATMENT_TEMPLATE_JSP;
	 *
	 * jsp += ".jsp";
	 *
	 * map.put("search", "search"); map.put("contentJsp",jsp); map.put("title",
	 * title); map.put("templateGroup",templateGroup); return new
	 * ModelAndView("index", "map", map); }
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showOpdTemplateTreatmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
	
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		}
		
		map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		String jsp = OPD_TREATMENT_TEMPLATE_JSP;
		jsp += ".jsp";

		title = "Standard Treatment Template";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getTemplateGroup(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		int templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		int deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
   
		String opClinic=null;
		if(request.getParameter("opClinic")!=null){
			opClinic=request.getParameter("opClinic");
		}
		
		map = opdMasterHandlerService.getTemplateGroup(templateId, deptId);

		String jsp = OPD_TREATMENT_TEMPLATE_DETAILS_JSP;

		title = "Template Group Detail";
		map.put("templateId", templateId);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("opClinic", opClinic);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("deptId", deptId);
			map.put("userName", userName);
			map.put("autoHint", autoHint);
			map = opdMasterHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillItemsInGrid(HttpServletRequest request,
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
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String pvmsNo = "";

		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = opdMasterHandlerService.fillItemsInGrid(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
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

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	// ****************************************** Start Of OPD Instruction
	// Treatment by Mansi ****************************//

	public ModelAndView searchOpdInstructionTreatment(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String opdInstructionTreatmentCode = null;
		String opdInstructionTreatmentName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			opdInstructionTreatmentCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			opdInstructionTreatmentName = request.getParameter(SEARCH_NAME);
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
			opdInstructionTreatmentCode = searchField;
			opdInstructionTreatmentName = null;

		} else {
			opdInstructionTreatmentCode = null;
			opdInstructionTreatmentName = searchField;
		}
		map = opdMasterHandlerService.searchOpdInstructionTreatment(
				opdInstructionTreatmentCode, opdInstructionTreatmentName);

		jsp = OPD_INSTRUCTION_TREATMENT_JSP;

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("opdInstructionTreatmentCode", opdInstructionTreatmentCode);
		map.put("opdInstructionTreatmentName", opdInstructionTreatmentName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOpdInstructionTreatmentJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();
		String jsp = OPD_INSTRUCTION_TREATMENT_JSP;
		jsp += ".jsp";
		title = "OpdInstructionTreatment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdInstructionTreatment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int changedBy=0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		HttpSession session = request.getSession();
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

		List opdInstructionTreatmentCodeList = new ArrayList();
		List opdInstructionTreatmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			opdInstructionTreatmentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			opdInstructionTreatmentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((opdInstructionTreatmentCodeList.size() == 0 || opdInstructionTreatmentCodeList == null)
				&& (opdInstructionTreatmentNameList.size() == 0 || opdInstructionTreatmentNameList == null)) {
			opdInstructionTreatment.setOpdInstructionTreatmentCode(code);
			opdInstructionTreatment.setOpdInstructionTreatmentName(name);

			opdInstructionTreatment.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			opdInstructionTreatment.setLastChgBy(users);
			
			opdInstructionTreatment.setLastChgDate(currentDate);
			opdInstructionTreatment.setLastChgTime(currentTime);
			
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			  MasHospital hospital = new MasHospital();
			  hospital.setId(hospitalId);
			  opdInstructionTreatment.setHospital(hospital);
			  
			successfullyAdded = opdMasterHandlerService
					.addOpdInstructionTreatment(opdInstructionTreatment);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null)
				|| (opdInstructionTreatmentNameList.size() != 0)
				|| opdInstructionTreatmentNameList != null) {
			if ((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null)
					&& (opdInstructionTreatmentNameList.size() == 0 || opdInstructionTreatmentNameList == null)) {

				message = "OpdInstructionTreatment Code  already exists.";
			} else if ((opdInstructionTreatmentNameList.size() != 0 || opdInstructionTreatmentNameList != null)
					&& (opdInstructionTreatmentCodeList.size() == 0 || opdInstructionTreatmentCodeList == null)) {

				message = "OpdInstructionTreatment Name already exists.";
			} else if ((opdInstructionTreatmentCodeList.size() != 0 || opdInstructionTreatmentCodeList != null)
					&& (opdInstructionTreatmentNameList.size() != 0 || opdInstructionTreatmentNameList != null)) {

				message = "OpdInstructionTreatment Code and OpdInstructionTreatment Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INSTRUCTION_TREATMENT_JSP;
		title = "Add OPD OpdInstructionTreatment";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdInstructionTreatment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String opdInstructionTreatmentCode = "";
		String opdInstructionTreatmentName = "";
		int opdInstructionTreatmentId = 0;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			opdInstructionTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			opdInstructionTreatmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			opdInstructionTreatmentName = request.getParameter(SEARCH_NAME);
		}
		HttpSession session = request.getSession();
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

		generalMap.put("id", opdInstructionTreatmentId);
		generalMap.put("opdInstructionTreatmentCode",
				opdInstructionTreatmentCode);
		generalMap.put("name", opdInstructionTreatmentName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOpdInstructionTreatmentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOpdInstructionTreatmentNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdInstructionTreatmentToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingOpdInstructionTreatmentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdInstructionTreatmentJsp";

		try {
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INSTRUCTION_TREATMENT_JSP;
		title = "update OPD OpdInstructionTreatment";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdInstructionTreatment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int opdInstructionTreatmentId = 0;
		String message = null;
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
			opdInstructionTreatmentId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		HttpSession session = request.getSession();
		changedBy = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = opdMasterHandlerService.deleteOpdInstructionTreatment(
				opdInstructionTreatmentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdInstructionTreatmentJsp";

		try {
			map = opdMasterHandlerService.showOpdInstructionTreatmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INSTRUCTION_TREATMENT_JSP;
		title = "delete OPD OpdInstructionTreatment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ****************************************** Start Of OPD Template
	// Investigation by Mansi****************************//

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdTemplateInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdTemplateInvestigation opdTemplateInvestigation = new OpdTemplateInvestigation();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int departmentId = 0;

		int chargeCodeId = 0;
		int templateId = 0;
		int templateInvestigationQty = 0;
		String clinicalNotes = "";
		if (request.getParameter(CLINICAL_NOTE) != null) {
			clinicalNotes = (request.getParameter(CLINICAL_NOTE));
		}
		 int userId =0;
		    if(session.getAttribute("userId")!=null){
		    	userId =(Integer) session.getAttribute("userId");
		      map.put("userId", userId);
		    }
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}

		if (request.getParameter(QTY) != null) {
			templateInvestigationQty = Integer.parseInt(request
					.getParameter(QTY));
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
		/*
		 * generalMap.put("code", code); generalMap.put("name", name);
		 */
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		/*
		 * generalMap.put("pojoPropertyName", pojoPropertyName);
		 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
		 * generalMap.put("pojoName", pojoName);
		 */

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List templateCodeList = new ArrayList();
		// List templateNameList = new ArrayList();
		/*
		 * if(listMap.get("duplicateGeneralCodeList") != null){ templateCodeList
		 * = (List)listMap.get("duplicateGeneralCodeList"); }
		 * if(listMap.get("duplicateGeneralNameList") != null){ templateNameList
		 * = (List)listMap.get("duplicateGeneralNameList"); }
		 */boolean successfullyAdded = false;

		/*
		 * if((templateCodeList.size() == 0 || templateCodeList == null) &&
		 * (templateNameList.size() == 0 || templateNameList == null)) {
		 */

		opdTemplateInvestigation.setClinicalNotes(clinicalNotes);

		opdTemplateInvestigation
				.setTemplateInvestigationQty(templateInvestigationQty);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplateInvestigation.setDepartment(masDepartment);

		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate.setId(templateId);
		opdTemplateInvestigation.setTemplate(opdTemplate);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		opdTemplateInvestigation.setChargeCode(masChargeCode);

		opdTemplateInvestigation.setStatus("y");
		Users users = new Users();
		users.setId(userId);
		opdTemplateInvestigation.setLastChgBy(users);
		opdTemplateInvestigation.setLastChgDate(currentDate);
		opdTemplateInvestigation.setLastChgTime(currentTime);
		successfullyAdded = opdMasterHandlerService
				.addOpdTemplateInvestigation(opdTemplateInvestigation);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		/*
		 * }
		 *
		 * else if((templateCodeList.size() != 0 || templateCodeList != null) ||
		 * (templateNameList.size() != 0) || templateNameList != null) {
		 * if((templateCodeList.size() != 0 || templateCodeList != null) &&
		 * (templateNameList.size() == 0 || templateNameList == null)){
		 *
		 * message = "Template Code already exists."; } else
		 * if((templateNameList.size() != 0 || templateNameList != null) &&
		 * (templateCodeList.size() == 0 || templateCodeList == null) ){
		 *
		 * message = "Template Name already exists."; } else
		 * if((templateCodeList.size() != 0 || templateCodeList != null) &&
		 * (templateNameList.size() != 0 || templateNameList != null)){
		 *
		 * message = "Template Code and Template Name already exist."; } }
		 */try {
			map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INVESTIGATION_TEMPLATE_JSP;
		title = "Add OPD Template Investigation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdTemplateInvestigation(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		int departmentId = 0;
		int templateId = 0;
		int chargeCodeId = 0;
		int templateInvestigationQty = 0;
		String clinicalNotes = "";
		int templateInvestigtaionId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		
		int userId =0;
	    if(session.getAttribute("userId")!=null){
	    	userId =(Integer) session.getAttribute("userId");
	    	generalMap.put("userId", userId);
	    }
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateInvestigtaionId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CLINICAL_NOTE) != null) {
			clinicalNotes = (request.getParameter(CLINICAL_NOTE));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(QTY) != null) {
			templateInvestigationQty = Integer.parseInt(request
					.getParameter(QTY));
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

		generalMap.put("id", templateInvestigtaionId);
		generalMap.put("templateId", templateId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("templateInvestigationQty", templateInvestigationQty);
		generalMap.put("clinicalNotes", clinicalNotes);
		generalMap.put("chargeCodeId", chargeCodeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = opdMasterHandlerService
				.editOpdTemplateInvestigation(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateInvestigationJsp";

		try {
			map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INVESTIGATION_TEMPLATE_JSP;
		title = "update OPD Template";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdTemplateInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int templateInvestigationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		 int userId =0;
		    if(session.getAttribute("userId")!=null){
		    	userId =(Integer) session.getAttribute("userId");
		    	generalMap.put("userId", userId);
		    }
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			templateInvestigationId = Integer.parseInt(request
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
		dataDeleted = opdMasterHandlerService.deleteOpdTemplateInvestigation(
				templateInvestigationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdTemplateInvestigationJsp";

		try {
			map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_INVESTIGATION_TEMPLATE_JSP;
		title = "delete OPD OpdInstructionTreatment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOpdTemplateInvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdTemplateInvestigationJsp();

		String jsp = OPD_INVESTIGATION_TEMPLATE_JSP;
		jsp += ".jsp";

		title = "Standard Template Investigation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getInvestigationTemplateGroup(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		int templateId = Integer.parseInt(request.getParameter(TEMPLATE_ID));
		int deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		map = opdMasterHandlerService.getInvestigationTemplateGroup(templateId,
				deptId);

		String jsp = OPD_INVESTIGATION_TEMPLATE_DETAILS_JSP;

		title = "Template Group Detail";
		map.put("templateId", templateId);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getChargeCodeList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String chargeCodeNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				chargeCodeNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(chargeCodeNameField) != null) {
				autoHint = (request.getParameter(chargeCodeNameField));
			}
			map.put("deptId", deptId);
			map.put("userName", userName);
			map.put("autoHint", autoHint);
			map = opdMasterHandlerService.getChargeCodeList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGridChargeCode";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillChargeCodeInGrid(HttpServletRequest request,
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
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		String chargeCodeCode = "";

		try {
			if (request.getParameter("chargeCodeCode") != null) {
				chargeCodeCode = request.getParameter("chargeCodeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		dataMap.put("chargeCodeCode", chargeCodeCode);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = opdMasterHandlerService.fillChargeCodeInGrid(dataMap);
		if (map.get("chargeCodeList") != null) {
			chargeCodeList = (List) map.get("chargeCodeList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasChargeCode masChargeCode : chargeCodeList) {
				sb.append("<chargeCode>");
				sb.append("<id>" + masChargeCode.getId() + "</id>");
				sb.append("<chargeCodeCode>"
						+ masChargeCode.getChargeCodeCode()
						+ "</chargeCodeCode>");
				sb.append("</chargeCode>");
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
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ****************************************** End Of OPD Template
	// Investigation by Mansi ****************************//
	// ------------------------------------Methods by
	// Vishal---------------------------------------
	// -----------------------------------Equipment
	// Master-----------------------------
	public ModelAndView showOpdEquipmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		map = opdMasterHandlerService.showOpdEquipmentJsp();
		String jsp = EQUIPMENT_OPD_JSP;
		jsp += ".jsp";
		title = "Equipment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOpdEquipment(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String equipmentCode = null;
		String equipmentName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			equipmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			equipmentName = request.getParameter(SEARCH_NAME);
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
			equipmentCode = searchField;
			equipmentName = null;

		} else {
			equipmentCode = null;
			equipmentName = searchField;
		}
		map = opdMasterHandlerService.searchOpdEquipment(equipmentCode,
				equipmentName);
		jsp = EQUIPMENT_OPD_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("equipmentCode", equipmentCode);
		map.put("equipmentName", equipmentName);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdEquipment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Integer noOfEquipment = null;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(NO_OF_EQUIPMENT) != null) {
			noOfEquipment = Integer.parseInt(request
					.getParameter(NO_OF_EQUIPMENT));
		}
		
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
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
		generalMap.put("noOfEquipment", noOfEquipment);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List equipmentCodeList = new ArrayList();
		List equipmentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			equipmentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			equipmentNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((equipmentCodeList.size() == 0 || equipmentCodeList == null)
				&& (equipmentNameList.size() == 0 || equipmentNameList == null)) {
			appEquipmentMaster.setEquipmentCode(code);
			appEquipmentMaster.setEquipmentName(name);
			appEquipmentMaster.setNoOfEquipments(noOfEquipment);
			appEquipmentMaster.setEquipmentStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			appEquipmentMaster.setLastChgBy(users);
			
			appEquipmentMaster.setLastChgDate(currentDate);
			appEquipmentMaster.setLastChgTime(currentTime);

			int hospitalId = (Integer)session.getAttribute("hospitalId");
			  MasHospital hospital = new MasHospital();
			  hospital.setId(hospitalId);
			  appEquipmentMaster.setHospital(hospital);
				
				successfullyAdded = opdMasterHandlerService.addOpdEquipment(appEquipmentMaster);

	
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((equipmentCodeList.size() != 0 || equipmentCodeList != null)
				|| (equipmentNameList.size() != 0) || equipmentNameList != null) {
			if ((equipmentCodeList.size() != 0 || equipmentCodeList != null)
					&& (equipmentNameList.size() == 0 || equipmentNameList == null)) {

				message = "Equipment Code  already exists.";
			} else if ((equipmentNameList.size() != 0 || equipmentNameList != null)
					&& (equipmentCodeList.size() == 0 || equipmentCodeList == null)) {

				message = "Equipment Name already exists.";
			} else if ((equipmentCodeList.size() != 0 || equipmentCodeList != null)
					&& (equipmentNameList.size() != 0 || equipmentNameList != null)) {

				message = "Equipment Code and Equipment Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdEquipmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EQUIPMENT_OPD_JSP;
		title = "Add OPD Equipment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdEquipment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String equipmentCode = "";
		String equipmentName = "";
		int equipmentId = 0;
		Integer noOfEquipment = null;
		HttpSession session = request.getSession();
		int changedBy = (Integer) session.getAttribute("userId");
		String changedTime = "";
		Date changedDate = null;
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			equipmentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			equipmentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			equipmentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(NO_OF_EQUIPMENT) != null
				&& !(request.getParameter(NO_OF_EQUIPMENT).equals(""))) {
			noOfEquipment = Integer.parseInt(request
					.getParameter(NO_OF_EQUIPMENT));
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

		generalMap.put("id", equipmentId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("equipmentCode", equipmentCode);
		generalMap.put("name", equipmentName);
		generalMap.put("noOfEquipment", noOfEquipment);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingEquipmentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingEquipmentNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdEquipmentToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingEquipmentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdEquipmentJsp";

		try {
			map = opdMasterHandlerService.showOpdEquipmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EQUIPMENT_OPD_JSP;
		title = "Update OPD Equipment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdEquipment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int equipmentId = 0;
		String message = null;
		int changedBy = 0;
		HttpSession session = request.getSession();
		changedBy = (Integer) session.getAttribute("userId");
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			equipmentId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = opdMasterHandlerService.deleteOpdEquipment(equipmentId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdEquipmentJsp";

		try {
			map = opdMasterHandlerService.showOpdEquipmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EQUIPMENT_OPD_JSP;
		title = "delete OPD Equipment";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForOpdEquipment(
			HttpServletRequest request, HttpServletResponse response) {
		String jasper = null;
		int hospitalId = 0;
		String hospitalName = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = opdMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------Vaccine master------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showOpdVaccinJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = opdMasterHandlerService.showOpdVaccinJsp();
		String jsp = OPD_VACCIN_JSP;
		jsp += ".jsp";
		title = "Vaccin";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOpdVaccin(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String vaccinCode = null;
		String vaccinName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			vaccinCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			vaccinName = request.getParameter(SEARCH_NAME);
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
			vaccinCode = searchField;
			vaccinName = null;

		} else {
			vaccinCode = null;
			vaccinName = searchField;
		}
		map = opdMasterHandlerService.searchOpdVaccin(vaccinCode, vaccinName);
		jsp = OPD_VACCIN_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("vaccinCode", vaccinCode);
		map.put("vaccinName", vaccinName);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdVaccin(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		OpdVaccinMst opdVaccin = new OpdVaccinMst();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Integer vaccinDuration = null;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		String vaccineName="";
		int masStoreItemId=0;
		int userId = 0;
		int dose=0;
		int maxDays=0;
		String type = null;
		Box box=HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if(request.getParameter("maxDays")!=null){
			maxDays=Integer.parseInt(request.getParameter("maxDays"));
		}
		if (request.getParameter(SEARCH_NAME) != null ) {
			vaccineName = request.getParameter(SEARCH_NAME);
			int index=0;
			int index1=vaccineName.indexOf("[");
			int index2=vaccineName.indexOf("]");
			name=vaccineName.substring(index, index1);
			masStoreItemId=Integer.parseInt(vaccineName.substring(index1+1, index2));
			
		}
		if (request.getParameter(VACCIN_DURATION) != null) {
			vaccinDuration = Integer.parseInt(request
					.getParameter(VACCIN_DURATION));
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
		
		// added by amit das on 05-08-2016
		if (request.getParameter("vaccineType") != null) {
			type = request.getParameter("vaccineType");
		}
		
		generalMap.put("box", box);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("masStoreItemId", masStoreItemId); 
		generalMap.put("maxDays",maxDays);
		listMap = opdMasterHandlerService
				.checkExistingVaccineMaster(generalMap);

		List vaccinCodeList = new ArrayList();
		List vaccinNameList = new ArrayList();

		if (listMap.get("duplicateMastersList") != null) {
			vaccinCodeList = (List) listMap.get("duplicateMastersList");
		}
		if (listMap.get("duplicateMastersList") != null) {
			vaccinNameList = (List) listMap.get("duplicateMastersList");
		}
		if(box.get("vaccineDose")!=null && !"select".equalsIgnoreCase(box.get("vaccineDose"))){
			dose=box.getInt("vaccineDose");
		}
		boolean successfullyAdded = false;

		if ((vaccinCodeList.size() == 0 || vaccinCodeList == null)
				&& (vaccinNameList.size() == 0 || vaccinNameList == null)) {
			opdVaccin.setVaccinCode(code);
			opdVaccin.setVaccinName(name);

			opdVaccin.setVaccinDuration(vaccinDuration);
			opdVaccin.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			opdVaccin.setLastChgBy(users);
			opdVaccin.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdVaccin.setLastChgTime(currentTime);
			MasStoreItem item=new MasStoreItem(masStoreItemId);
			opdVaccin.setMasStoreItem(item);
			opdVaccin.setDose(dose);
			opdVaccin.setVaccinToDays(maxDays);
			opdVaccin.setVaccinType(type); // added by amit das on 05-08-2016
			successfullyAdded = opdMasterHandlerService.addOpdVaccin(opdVaccin);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((vaccinCodeList.size() != 0 || vaccinCodeList != null)
				|| (vaccinNameList.size() != 0) || vaccinNameList != null) {
			if ((vaccinCodeList.size() != 0 || vaccinCodeList != null)
					&& (vaccinNameList.size() == 0 || vaccinNameList == null)) {

				message = "Vaccin Code  already exists.";
			} else if ((vaccinNameList.size() != 0 || vaccinNameList != null)
					&& (vaccinCodeList.size() == 0 || vaccinCodeList == null)) {

				message = "Vaccin Name already exists.";
			} else if ((vaccinCodeList.size() != 0 || vaccinCodeList != null)
					&& (vaccinNameList.size() != 0 || vaccinNameList != null)) {

				message = "Vaccin Code and Vaccin Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdVaccinJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_VACCIN_JSP;
		title = "Add OPD Vaccin";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdVaccin(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String vaccinCode = "";
		String vaccinName = "";
		int vaccinId = 0;
		Integer vaccinDuration = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String name="";
		int masStoreItemId=0;
		int userId = 0;
		String type = null; // added by amit das on 05-08-2016
		Box box=HMSUtil.getBox(request);
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			vaccinCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
			int index=0;
			int index1=name.indexOf("[");
			int index2=name.indexOf("]");
			if(index1!=-1 && index2!=-1){
				vaccinName=name.substring(index, index1);
				masStoreItemId=Integer.parseInt(name.substring(index1+1, index2));
			}else{
				vaccinName=name;
			}
			
		}
		if (request.getParameter(VACCIN_DURATION) != null
				&& !(request.getParameter(VACCIN_DURATION).equals(""))) {
			vaccinDuration = Integer.parseInt(request
					.getParameter(VACCIN_DURATION));
		}
		int maxDays=0;
		if (request.getParameter("maxDays") != null
				&& !(request.getParameter("maxDays").equals(""))) {
			maxDays = Integer.parseInt(request
					.getParameter("maxDays"));
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
		
		// added by amit das on 05-08-2016
		if (request.getParameter("vaccineType") != null) {
			type = request.getParameter("vaccineType");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("box", box);
		generalMap.put("userId", userId);
		generalMap.put("id", vaccinId);
		generalMap.put("vaccinCode", vaccinCode);
		generalMap.put("name", vaccinName);
		generalMap.put("vaccinDuration", vaccinDuration);
		generalMap.put("maxDays", maxDays);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("masStoreItemId", masStoreItemId); 
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("type", type); // added by amit das on 05-08-2016
		
		listMap = opdMasterHandlerService
				.checkExistingVaccineMaster(generalMap);
		List existingVaccinNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingVaccinNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdVaccinToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingVaccinNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

		try {
			map = opdMasterHandlerService.showOpdVaccinJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_VACCIN_JSP;
		title = "Update OPD Vaccin";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdVaccin(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int vaccinId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			vaccinId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = opdMasterHandlerService.deleteOpdVaccin(vaccinId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdVaccinJsp";

		try {
			map = opdMasterHandlerService.showOpdVaccinJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_VACCIN_JSP;
		title = "delete OPD Vaccin";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForOpdVaccin(HttpServletRequest request,
			HttpServletResponse response) {
		String jasper = null;
		int hospitalId = 0;
		String hospitalName = null;

		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = opdMasterHandlerService.getConnection();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------Methods Ended By
	// Vishal--------------------------------------

	public OPDMasterHandlerService getOpdMasterHandlerService() {
		return opdMasterHandlerService;
	}

	public void setOpdMasterHandlerService(
			OPDMasterHandlerService opdMasterHandlerService) {
		this.opdMasterHandlerService = opdMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public ModelAndView addModularityModule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");

		map = opdMasterHandlerService.showOpdModalityJsp();

		jsp = MODULARITY_MASTER_JSP;
		title = "add Modularity Module";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptName", deptName);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unused")
	public ModelAndView submitModularity(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users user = (Users) session.getAttribute("users");
		String modularity_code="";
		String modularity_name="";

		int userId = user.getId();
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
		}
		if(request.getParameter(RequestConstants.MODULARITY_CODE)!=null)
		{
			modularity_code = request.getParameter(RequestConstants.MODULARITY_CODE);
		}
		if(request.getParameter(RequestConstants.MODULARITY_NAME)!=null)
		{
			modularity_name =request.getParameter(RequestConstants.MODULARITY_NAME);
		}
		jsp = MODULARITY_MASTER_JSP;
		title = "add Modularity Module";
		jsp += ".jsp";
		message = "Record is added successfully !!";

		map.put("contentJsp", jsp);
		map.put("currentDate",currentDate);
		map.put("time",time);
		map.put("modularity_code",modularity_code);
		map.put("modularity_name",modularity_name);
		map.put("userName",userName);
		map.put("message", message);

		map = opdMasterHandlerService.submitModularity(map);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOpdModality(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String modalityCode = null;
		String modalityName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			modalityCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			modalityName = request.getParameter(SEARCH_NAME);
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
			modalityCode = searchField;
			modalityName = null;

		} else {
			modalityCode = null;
			modalityName = searchField;
		}
		map = opdMasterHandlerService
				.searchOpdModality(modalityCode, modalityName);

		jsp = MODULARITY_MASTER_JSP;

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("modalityCode", modalityCode);
		map.put("modalityName", modalityName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOpdModality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasModularity  masModularity = new MasModularity();
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

		List modalityCodeList = new ArrayList();
		List modalityNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			 modalityCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			modalityNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if (( modalityCodeList.size() == 0 ||  modalityCodeList == null)
				&& (modalityNameList.size() == 0 || modalityNameList == null)) {
			masModularity.setCode(code);
			masModularity.setModularityName(name);
			masModularity.setStatus("y");
			masModularity.setLastChgBy(changedBy);
			masModularity.setLastChgDate(currentDate);
			masModularity.setLastChgTime(currentTime);
			successfullyAdded = opdMasterHandlerService
					.addOpdModality(masModularity);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((modalityCodeList.size() != 0 || modalityCodeList != null)
				|| (modalityNameList.size() != 0) || modalityNameList != null) {
			if ((modalityCodeList.size() != 0 || modalityCodeList != null)
					&& (modalityNameList.size() == 0 || modalityNameList == null)) {

				message = "Modality Code  already exists.";
			} else if ((modalityNameList.size() != 0 || modalityNameList != null)
					&& (modalityCodeList.size() == 0 || modalityCodeList == null)) {

				message = "Modality Name already exists.";
			} else if ((modalityCodeList.size() != 0 || modalityCodeList != null)
					&& (modalityNameList.size() != 0 || modalityNameList != null)) {

				message = "Modality Code and Modality Name already exist.";
			}
		}

		try {
			map = opdMasterHandlerService.showOpdModalityJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MODULARITY_MASTER_JSP;
		title = "Add OPD Holiday";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editOpdModality(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession(true);
		String modalityCode = "";
		String modalityName = "";
		int modalityId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			modalityId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			modalityCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			modalityName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", modalityId);
		generalMap.put("modalityCode", modalityCode);
		generalMap.put("name", modalityName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingHolidayNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingHolidayNameList.size() == 0) {
			dataUpdated = opdMasterHandlerService
					.editOpdModalityToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingHolidayNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";

		try {
			map = opdMasterHandlerService.showOpdModalityJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MODULARITY_MASTER_JSP;
		title = "update OPD Modality";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOpdModality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int modalityId = 0;
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
			modalityId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = opdMasterHandlerService.deleteOpdModality(modalityId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showOpdHolidayJsp";

		try {
			map = opdMasterHandlerService.showOpdModalityJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MODULARITY_MASTER_JSP;
		title = "delete OPD Modality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView showFrequencyJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) opdMasterHandlerService.showFrequencyJsp();
		String jsp = "opdFrequency";
		jsp += ".jsp";
		title = "Frequency";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasOpdFrequency masOpdFrequency = new MasOpdFrequency();

		HttpSession session = request.getSession();
		String code = " ";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		try {

		

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				code = request.getParameter(CODE);
				System.out.println("CODE" + request.getParameter(CODE));
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
				System.out.println("SEARCH_NAME"
						+ request.getParameter(SEARCH_NAME));
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

		
				masOpdFrequency.setFrequencyCode(code);
				masOpdFrequency.setFrequencyName(name);

				Users users = new Users();

				if (session.getAttribute("users") != null) {
					users = (Users) session.getAttribute("users");
				}

				masOpdFrequency.setLastChgBy(users);
				masOpdFrequency.setLastChgDate(currentDate);
				masOpdFrequency.setLastChgTime(currentTime);
				masOpdFrequency.setStatus("y");

				successfullyAdded = opdMasterHandlerService.addFrequency(masOpdFrequency);
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
			map = opdMasterHandlerService.showFrequencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opdFrequency";
		title = "Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

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
		map = opdMasterHandlerService.searchFrequency(frequencyCode, frequencyName);
		jsp = "opdFrequency";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("frequencyCode", frequencyCode);
		map.put("frequencyName", frequencyName);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editFrequency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String frequencyCode = "";
		String name = "";
		int frequencyId = 0;
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
			generalMap.put("name", name);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = opdMasterHandlerService.editFrequency(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = opdMasterHandlerService.showFrequencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opdFrequency";
		title = "Edit Frequency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteFrequency(HttpServletRequest request,
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
		dataDeleted = opdMasterHandlerService.deleteFrequency(
				frequencyId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/opdMaster?method=showFrequencyJsp";

		try {
			map = opdMasterHandlerService.showFrequencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opdFrequency";
		title = "delete Frequency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView getVaccinationList(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int section = 0; 
			String itemNameField = "";
			int deptId = 0;
			String autoHint = "";
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter("search_name") != null) {
				autoHint = (request.getParameter("search_name"));
			}

			System.out.println("autoHint==== "+autoHint);
			Box box = HMSUtil.getBox(request);
			box.put("autoHint", autoHint);
			map =opdMasterHandlerService.getVaccinationList(box);  
 			String jsp = "listOfVaccine"; 
			return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView showOpdExaminationTemplateJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "opdExaminationTemplate";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		//map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView addOpdExaminationTemplate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		int userId = 0;
		boolean saveFlag = false;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		map = opdMasterHandlerService.addOpdExaminationTemplate(box);
		if(map.get("saveFlag") != null){
			saveFlag = (boolean)map.get("saveFlag");
		}
		if (saveFlag) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = "opdExaminationTemplate";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView searchOpdExaminationTemplate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		map = opdMasterHandlerService.searchOpdExaminationTemplate(box);
		jsp = "responseForExaminationTemplate";
		//jsp += ".jsp";
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView showOpdTemplateTreatmentOPDJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
		int changedBy=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		}
		
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("userId") != null
				&& !(session.getAttribute("userId").equals(""))) {
			changedBy =(int) session.getAttribute("userId");
			box.put("changedBy", changedBy);
		}//Added By Om Tripathi 5/2/2018
		
		map = opdMasterHandlerService.showOpdTemplateTreatmentJsp(box);

		String jsp = "opdTemplateTreatment_inOPD";
		jsp += ".jsp";

		title = "Standard Treatment Template";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView showPrescriptionMappingJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session=request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		map = opdMasterHandlerService.showPrescriptionMappingJsp(hospitalId);
		
		jsp = "prescriptionMapping";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		return new ModelAndView("index", "map", map);

	}
	
	public void displayAU(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemMasterList = new ArrayList<MasStoreItem>();
		List<Object[]> presMapList = new ArrayList<Object[]>();
		
		String pvmsNo ="";
				
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		if(request.getParameter("pvmsNo") != null){
			pvmsNo = request.getParameter("pvmsNo");
		}
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("pvmsNo",pvmsNo);
		map = opdMasterHandlerService.displayAU(dataMap);
		if(map.get("itemMasterList") != null){
			itemMasterList=(List<MasStoreItem>)map.get("itemMasterList");
		}
		if(map.get("presMapList") != null){
			presMapList=(List<Object[]>)map.get("presMapList");
		}
		String au = "";
//		int route = 0;
		String route = "";
		if(itemMasterList.size()>0){
			MasStoreItem storeItem= itemMasterList.get(0);
			if(storeItem.getItemConversion() != null){
			 au =(String) storeItem.getItemConversion().getItemUnitName();
			}
			if(storeItem.getRoute() != null){
//				 route =(Integer) storeItem.getRoute().getId();
				 route =(String) storeItem.getRoute().getRouteName();
				}
			
		 }
		
		StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<au>" +au + "</au>");
			sb.append("<route>" +route + "</route>");
			
			if(presMapList.size() > 0){
				for(Object[] obj : presMapList){
					sb.append("<dosage>" +(obj[0]!=null?obj[0]:"") + "</dosage>");
					sb.append("<noOfDays>" +(obj[1]!=null?obj[1]:"" )+ "</noOfDays>");
					sb.append("<freq>" +(obj[2]!=null?obj[2]:"") + "</freq>");
					sb.append("<freqType>" +(obj[3]!=null?obj[3]:"") + "</freqType>");
					sb.append("<presMapId>" +(obj[4]!=null?obj[4]:"") + "</presMapId>");
				}
				
			}else{
				sb.append("<dosage>" +""+ "</dosage>");
				sb.append("<noOfDays>" +"" + "</noOfDays>");
				sb.append("<freq>" +"" + "</freq>");
				sb.append("<freqType>" +"" + "</freqType>");
				sb.append("<presMapId>" +"" + "</presMapId>");
			}
			
			sb.append("</item>");
	

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public ModelAndView submitPrescriptionMapping(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			HttpSession session = request.getSession();
			session=request.getSession();
			Integer hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
			Integer userId=(Integer) session.getAttribute(USER_ID);
			Integer deptId=(Integer) session.getAttribute(DEPT_ID);
			Box box=HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(USER_ID, userId);
			box.put(DEPT_ID, deptId);
			
			map.put("hospitalId", hospitalId);
			
			returnMap=opdMasterHandlerService.submitPrescriptionGrid(box);
			
			map = opdMasterHandlerService.showPrescriptionMappingJsp(hospitalId);
			
			map.put("message", (String)returnMap.get("message"));
			}
		catch(Exception e){
				e.printStackTrace();
			}
		    jsp = "prescriptionMapping";
			jsp += ".jsp";
		    map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	}
}
